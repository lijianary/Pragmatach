package com.khubla.pragmatach.plugin.freemarker;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import com.khubla.pragmatach.framework.annotation.View;
import com.khubla.pragmatach.framework.api.PragmatachException;
import com.khubla.pragmatach.framework.api.Response;
import com.khubla.pragmatach.framework.controller.AbstractController;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * @author tome
 */
public class FreemarkerController extends AbstractController {
   /**
    * state variables
    */
   private static final String SESSION = "session";
   private static final String CONTROLLER = "controller";

   /**
    * ctor
    */
   public FreemarkerController() {
   }

   /**
    * get the Freemarker Template
    */
   private Template getTemplate() throws PragmatachException {
      try {
         final Configuration cfg = new Configuration();
         PragmatachTemplateLoader pragmatachTemplateLoader = new PragmatachTemplateLoader(this.getRequest().getServletContext());
         cfg.setTemplateLoader(pragmatachTemplateLoader);
         final String templateName = getTemplateName();
         final InputStream templateInputStream = getResource(templateName);
         if (null != templateInputStream) {
            return new Template(templateName, new InputStreamReader(templateInputStream), cfg);
         } else {
            throw new Exception("Unable to load template '" + templateName + "'");
         }
      } catch (final Exception e) {
         throw new PragmatachException("Exception in getTemplate", e);
      }
   }

   /**
    * get the name of the template from the annotation
    */
   private String getTemplateName() {
      final View view = this.getClass().getAnnotation(View.class);
      if (null != view) {
         final String template = view.view();
         if ((null != template) && (template.length() > 0)) {
            return template;
         }
      }
      return null;
   }

   /**
    * render
    */
   public Response render() throws PragmatachException {
      try {
         final Template template = getTemplate();
         final Map<String, Object> context = new HashMap<String, Object>();
         context.put(SESSION, getRequest().getSession());
         context.put(CONTROLLER, this);
         return new FreemarkerResponse(template, context);
      } catch (final Exception e) {
         throw new PragmatachException("Exception in render", e);
      }
   }
}