package com.khubla.pragmatach.framework.controller.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

import com.khubla.pragmatach.framework.api.PragmatachException;
import com.khubla.pragmatach.framework.api.Response;
import com.khubla.pragmatach.framework.controller.AbstractController;

/**
 * @author tome
 */
public class SimpleTemplateResponse implements Response {
   /**
    * InputStream
    */
   private final InputStream resourceInputStream;
   /**
    * parameters
    */
   private final Map<String, String> parameters;
   private static final String ESCAPE = "$";

   public static void template(InputStream templateInputStream, OutputStream outputStream, Map<String, String> substitutions) throws PragmatachException {
      try {
         /*
          * read the entire InputStream
          */
         final ByteArrayOutputStream baos = new ByteArrayOutputStream();
         IOUtils.copy(templateInputStream, baos);
         /*
          * do substitutions
          */
         String renderedTemplate = baos.toString();
         if (null != substitutions) {
            for (final String key : substitutions.keySet()) {
               final String v = substitutions.get(key);
               renderedTemplate = StringUtils.replace(renderedTemplate, ESCAPE + key, v);
            }
         }
         /*
          * write out
          */
         final ByteArrayInputStream bais = new ByteArrayInputStream(renderedTemplate.getBytes());
         IOUtils.copy(bais, outputStream);
      } catch (final Exception e) {
         throw new PragmatachException("Exception in template", e);
      }
   }

   /**
    * ctor
    */
   public SimpleTemplateResponse(String template, Map<String, String> parameters) {
      this.parameters = parameters;
      if (null != template) {
         /*
          * ok, go for it
          */
         resourceInputStream = getClass().getResourceAsStream("/" + template);
      } else {
         resourceInputStream = null;
      }
   }

   @Override
   public Map<String, String> getHeaders() throws PragmatachException {
      return null;
   }

   @Override
   public int getHTTPCode() {
      return AbstractController.HTTP_OK;
   }

   @Override
   public void render(OutputStream outputStream) throws PragmatachException {
      try {
         template(resourceInputStream, outputStream, parameters);
      } catch (final Exception e) {
         throw new PragmatachException("Exception in render", e);
      }
   }
}