package test.com.khubla.pragmatach.framework.examples;

import com.khubla.pragmatach.framework.annotation.Controller;
import com.khubla.pragmatach.framework.annotation.Route;
import com.khubla.pragmatach.framework.api.PragmatachException;
import com.khubla.pragmatach.framework.api.Request;
import com.khubla.pragmatach.framework.api.Response;
import com.khubla.pragmatach.framework.freemarker.FreemarkerController;
import com.khubla.pragmatach.framework.freemarker.FreemarkerTemplate;

@Controller
@FreemarkerTemplate(template = "index.ftl")
public class ExampleController1 extends FreemarkerController {
   @Route(path = "/abc/123", method = Route.HttpMethod.post)
   public Response doPost(Request request) throws PragmatachException {
      return super.render(request);
   }

   @Route(path = "/")
   public Response render(Request request) throws PragmatachException {
      return super.render(request);
   }

   @Route(path = "/a", method = Route.HttpMethod.post)
   public Response renderRoot(Request request) throws PragmatachException {
      return super.render(request);
   }
}