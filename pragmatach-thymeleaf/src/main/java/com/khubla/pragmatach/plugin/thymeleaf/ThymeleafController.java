package com.khubla.pragmatach.plugin.thymeleaf;

import java.util.HashMap;
import java.util.Map;

import org.thymeleaf.templateresolver.ITemplateResolver;

import com.khubla.pragmatach.framework.api.PragmatachException;
import com.khubla.pragmatach.framework.api.Response;
import com.khubla.pragmatach.framework.controller.AbstractTemplateEngineController;
import com.khubla.pragmatach.framework.controller.BeanBoundController;
import com.khubla.pragmatach.framework.form.Form;
import com.khubla.pragmatach.framework.form.FormItem;

/**
 * @author tome
 */
public class ThymeleafController extends AbstractTemplateEngineController implements BeanBoundController {
   /**
    * ctor
    */
   public ThymeleafController() {
   }

   @Override
   public Map<String, String> getPostFieldValues() throws PragmatachException {
      try {
         final Form form = Form.parse(getRequest().getHttpServletRequest());
         if (null != form) {
            final Map<String, String> ret = new HashMap<String, String>();
            for (final FormItem formItem : form.getItems().values()) {
               ret.put(formItem.getName(), formItem.getValue());
            }
            return ret;
         } else {
            return null;
         }
      } catch (final Exception e) {
         throw new PragmatachException("Exception in getPostFieldValues", e);
      }
   }

   /**
    * render
    */
   public Response render() throws PragmatachException {
      try {
         final ITemplateResolver templateResolver = new PragmatachTemplateResolver(getRequest().getServletContext());
         return new ThymeleafResponse(getCacheHeaders(), getTemplateName(), getTemplateContext(), templateResolver);
      } catch (final Exception e) {
         throw new PragmatachException("Exception in render", e);
      }
   }
}
