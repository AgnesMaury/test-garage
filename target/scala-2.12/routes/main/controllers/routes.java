
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/mauryagnes/IdeaProjects/test_garage/conf/routes
// @DATE:Wed Apr 11 16:56:13 CEST 2018

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseGarageController GarageController = new controllers.ReverseGarageController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseGarageController GarageController = new controllers.javascript.ReverseGarageController(RoutesPrefix.byNamePrefix());
  }

}
