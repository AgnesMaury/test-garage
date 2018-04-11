
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/mauryagnes/IdeaProjects/test_garage/conf/routes
// @DATE:Wed Apr 11 16:56:13 CEST 2018

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:1
package controllers.javascript {

  // @LINE:1
  class ReverseGarageController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def deleteAllCarsOfGarage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GarageController.deleteAllCarsOfGarage",
      """
        function(garageId0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "garages/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("garageId", garageId0)) + "/cars"})
        }
      """
    )
  
    // @LINE:1
    def createGarage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GarageController.createGarage",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "garages"})
        }
      """
    )
  
    // @LINE:6
    def addCarToGarage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GarageController.addCarToGarage",
      """
        function(garageId0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "garages/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("garageId", garageId0)) + "/cars"})
        }
      """
    )
  
    // @LINE:5
    def retrieveAllCars: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GarageController.retrieveAllCars",
      """
        function(garageId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "garages/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("garageId", garageId0)) + "/cars"})
        }
      """
    )
  
    // @LINE:2
    def retrieveGarage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GarageController.retrieveGarage",
      """
        function(garageId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "garages/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("garageId", garageId0))})
        }
      """
    )
  
    // @LINE:4
    def deleteGarage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GarageController.deleteGarage",
      """
        function(garageId0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "garages/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("garageId", garageId0))})
        }
      """
    )
  
    // @LINE:3
    def modifyGarage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GarageController.modifyGarage",
      """
        function(garageId0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "garages/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("garageId", garageId0))})
        }
      """
    )
  
  }


}
