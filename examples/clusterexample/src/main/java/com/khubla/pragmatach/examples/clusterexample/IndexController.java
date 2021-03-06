package com.khubla.pragmatach.examples.clusterexample;

import java.util.Date;

import com.khubla.pragmatach.framework.annotation.Controller;
import com.khubla.pragmatach.framework.annotation.Route;
import com.khubla.pragmatach.framework.annotation.View;
import com.khubla.pragmatach.framework.api.PragmatachException;
import com.khubla.pragmatach.framework.api.Response;
import com.khubla.pragmatach.plugin.freemarker.FreemarkerController;

@Controller(name = "IndexController")
@View(view = "index.html")
public class IndexController extends FreemarkerController {
   /**
    * the time
    */
   private String time;

   public String getTime() {
      return time;
   }

   @Route(uri = "/")
   public Response render() throws PragmatachException {
      time = new Date().toString();
      return super.render();
   }

   public void setTime(String time) {
      this.time = time;
   }
}