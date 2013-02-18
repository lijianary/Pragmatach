package test.com.khubla.pragmatach.framework.router;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.khubla.pragmatach.framework.annotation.AnnotationsScanner;
import com.khubla.pragmatach.framework.router.PragmatachRoute;
import com.khubla.pragmatach.framework.router.PragmatachRoutes;

/**
 * @author tome
 */
public class TestRoutes {
   private void reportRoutes(List<PragmatachRoute> routes) {
      for (final PragmatachRoute pragmatachRoute : routes) {
         System.out.println(pragmatachRoute.getRoute().uri());
      }
   }

   @BeforeTest
   public void setup() {
      try {
         AnnotationsScanner.scan(null);
      } catch (final Exception e) {
         e.printStackTrace();
         Assert.fail();
      }
   }

   @Test
   public void test1() {
      try {
         final PragmatachRoutes routes = PragmatachRoutes.getInstance();
         Assert.assertNotNull(routes);
         reportRoutes(routes.getGETRoutes());
         reportRoutes(routes.getPOSTRoutes());
         Assert.assertTrue(routes.getGETRoutes().size() == 4);
         Assert.assertTrue(routes.getGETRoutes().get(3).getRoute().uri().compareTo("/") == 0);
         Assert.assertTrue(routes.getPOSTRoutes().size() == 3);
         Assert.assertTrue(routes.getPOSTRoutes().get(2).getRoute().uri().compareTo("/a") == 0);
      } catch (final Exception e) {
         e.printStackTrace();
         Assert.fail();
      }
   }
}
