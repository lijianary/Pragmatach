package com.khubla.pragmatach.framework.controller.impl;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.khubla.pragmatach.framework.annotation.CacheControl;
import com.khubla.pragmatach.framework.annotation.Controller;
import com.khubla.pragmatach.framework.api.PragmatachException;
import com.khubla.pragmatach.framework.api.Request;
import com.khubla.pragmatach.framework.api.Response;
import com.khubla.pragmatach.framework.application.Application;
import com.khubla.pragmatach.framework.controller.PragmatachController;
import com.khubla.pragmatach.framework.controller.SessionScopedControllers;
import com.khubla.pragmatach.framework.controller.impl.redirect.RedirectController;
import com.khubla.pragmatach.framework.controller.impl.trivial.TrivialResponse;
import com.khubla.pragmatach.framework.resourceloader.DefaultResourceLoaderImpl;
import com.khubla.pragmatach.framework.resourceloader.ResourceLoader;
import com.khubla.pragmatach.framework.router.PragmatachRoute;

/**
 * @author tome
 */
public abstract class AbstractController implements PragmatachController {
   /**
    * build a path from a wildcard path
    */
   public static String buildWildcardResourceURI(String[] resource) {
      String ret = "";
      for (final String s : resource) {
         ret += "/" + s;
      }
      return ret;
   }

   /**
    * get the name of the controller from the annotation
    */
   public static String getControllerName(Class<?> clazz) {
      final Controller controller = clazz.getAnnotation(Controller.class);
      if (null != controller) {
         String name = controller.name();
         if (name.length() == 0) {
            /*
             * *this* is a proxy, so we need the superclass name
             */
            // name = this.getClass().getSuperclass().getSimpleName();
            name = clazz.getSimpleName();
         }
         return name;
      }
      return null;
   }

   /**
    * get the name of the controller from the annotation
    */
   public static String getControllerName(PragmatachController pragmatachController) {
      final Controller controller = pragmatachController.getClass().getAnnotation(Controller.class);
      if (null != controller) {
         String name = controller.name();
         if (name.length() == 0) {
            /*
             * *this* is a proxy, so we need the superclass name
             */
            // name = this.getClass().getSuperclass().getSimpleName();
            name = pragmatachController.getClass().getSimpleName();
         }
         return name;
      }
      return null;
   }

   /**
    * request
    */
   private Request request;
   /**
    * cache control
    */
   private static final String CACHECONTROL = "Cache-Control: ";
   /**
    * route
    */
   private PragmatachRoute pragmatachRoute;

   /**
    * bad; HTTP 400
    */
   public Response bad() throws PragmatachException {
      return new TrivialResponse(null, 400);
   }

   /**
    * forward to another controller uri
    */
   public Response forward(String uri) throws PragmatachException {
      final String forwardURI = request.getHttpServletRequest().getContextPath() + uri;
      return new RedirectController(forwardURI).render();
   }

   /**
    * get the base URI of this application
    */
   public String getApplicationURL() {
      final HttpServletRequest httpServletRequest = getRequest().getHttpServletRequest();
      return httpServletRequest.getScheme() + "://" + httpServletRequest.getServerName() + ":" + httpServletRequest.getServerPort() + httpServletRequest.getContextPath();
   }

   /**
    * generate the cache headers
    */
   protected Map<String, String> getCacheHeaders() throws PragmatachException {
      try {
         final CacheControl cacheControl = this.getClass().getAnnotation(CacheControl.class);
         if (null != cacheControl) {
            final Map<String, String> ret = new HashMap<String, String>();
            String cacheControlHeader = "";
            boolean first = true;
            /*
             * max age
             */
            if (-1 != cacheControl.maxAge()) {
               cacheControlHeader += "max-age=" + cacheControl.maxAge();
               first = false;
            }
            /*
             * s-max
             */
            if (-1 != cacheControl.sMaxAge()) {
               if (false == first) {
                  cacheControlHeader += ",";
               }
               cacheControlHeader += "s-maxage=" + cacheControl.sMaxAge();
               first = false;
            }
            /*
             * policy
             */
            if (false == first) {
               cacheControlHeader += ",";
            }
            cacheControlHeader += cacheControl.policy().toString().toLowerCase().trim();
            /*
             * done
             */
            ret.put(CACHECONTROL, cacheControlHeader);
            return ret;
         } else {
            return null;
         }
      } catch (final Exception e) {
         throw new PragmatachException("Exception in getCacheHeaders", e);
      }
   }

   /**
    * get a configuration parameter from the pragmatatch configuration
    */
   public String getConfigurationParameter(String name) throws PragmatachException {
      return Application.getConfiguration().getParameter(name);
   }

   public PragmatachRoute getPragmatachRoute() {
      return pragmatachRoute;
   }

   /**
    * get the request
    */
   public Request getRequest() {
      return request;
   }

   /**
    * get a resource using the servlet's class loader
    */
   protected InputStream getResource(String resource) throws PragmatachException {
      try {
         final ResourceLoader resourceLoader = new DefaultResourceLoaderImpl(request.getServletContext());
         return resourceLoader.getResource(resource);
      } catch (final Exception e) {
         throw new PragmatachException("Exception in getResource", e);
      }
   }

   /**
    * get the instance of a session-bound controller
    */
   @SuppressWarnings("unchecked")
   public <T> T getSessionScopedController(Class<T> clazz) {
      return (T) SessionScopedControllers.getController(request.getSession(), clazz);
   }

   /**
    * ok; HTTP 200
    */
   public Response ok() throws PragmatachException {
      return new TrivialResponse(null, 200);
   }

   /**
    * redirect. This API requires a full URL including authority, hostname, port, etc.
    */
   public Response redirect(String uri) throws PragmatachException {
      return new RedirectController(uri).render();
   }

   @Override
   public void setPragmatachRoute(PragmatachRoute pragmatachRoute) {
      this.pragmatachRoute = pragmatachRoute;
   }

   /**
    * set the request
    */
   @Override
   public void setRequest(Request request) {
      this.request = request;
   }
}
