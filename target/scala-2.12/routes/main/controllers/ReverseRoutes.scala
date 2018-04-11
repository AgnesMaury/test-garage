
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/mauryagnes/IdeaProjects/test_garage/conf/routes
// @DATE:Wed Apr 11 16:56:13 CEST 2018

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:1
package controllers {

  // @LINE:1
  class ReverseGarageController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def deleteAllCarsOfGarage(garageId:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "garages/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("garageId", garageId)) + "/cars")
    }
  
    // @LINE:1
    def createGarage(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "garages")
    }
  
    // @LINE:6
    def addCarToGarage(garageId:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "garages/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("garageId", garageId)) + "/cars")
    }
  
    // @LINE:5
    def retrieveAllCars(garageId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "garages/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("garageId", garageId)) + "/cars")
    }
  
    // @LINE:2
    def retrieveGarage(garageId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "garages/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("garageId", garageId)))
    }
  
    // @LINE:4
    def deleteGarage(garageId:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "garages/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("garageId", garageId)))
    }
  
    // @LINE:3
    def modifyGarage(garageId:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "garages/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("garageId", garageId)))
    }
  
  }


}
