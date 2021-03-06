package com.khubla.pragmatach.examples.uploadexample;

import com.khubla.pragmatach.framework.annotation.Controller;
import com.khubla.pragmatach.framework.annotation.Route;
import com.khubla.pragmatach.framework.annotation.View;
import com.khubla.pragmatach.framework.api.PragmatachException;
import com.khubla.pragmatach.framework.api.Response;
import com.khubla.pragmatach.plugin.freemarker.FreemarkerController;

/**
 * @author tome
 */
@Controller()
public class IndexController extends FreemarkerController {
   @Route(uri = "/")
   @View(view = "index.html")
   public Response render() throws PragmatachException {
      return super.render();
   }
}