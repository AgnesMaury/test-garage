
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/mauryagnes/IdeaProjects/test_garage/conf/routes
// @DATE:Wed Apr 11 16:56:13 CEST 2018

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:1
  GarageController_0: controllers.GarageController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:1
    GarageController_0: controllers.GarageController
  ) = this(errorHandler, GarageController_0, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, GarageController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """garages""", """controllers.GarageController.createGarage"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """garages/""" + "$" + """garageId<[^/]+>""", """controllers.GarageController.retrieveGarage(garageId:String)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """garages/""" + "$" + """garageId<[^/]+>""", """controllers.GarageController.modifyGarage(garageId:String)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """garages/""" + "$" + """garageId<[^/]+>""", """controllers.GarageController.deleteGarage(garageId:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """garages/""" + "$" + """garageId<[^/]+>/cars""", """controllers.GarageController.retrieveAllCars(garageId:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """garages/""" + "$" + """garageId<[^/]+>/cars""", """controllers.GarageController.addCarToGarage(garageId:String)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """garages/""" + "$" + """garageId<[^/]+>/cars""", """controllers.GarageController.deleteAllCarsOfGarage(garageId:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:1
  private[this] lazy val controllers_GarageController_createGarage0_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("garages")))
  )
  private[this] lazy val controllers_GarageController_createGarage0_invoker = createInvoker(
    GarageController_0.createGarage,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GarageController",
      "createGarage",
      Nil,
      "POST",
      this.prefix + """garages""",
      """""",
      Seq()
    )
  )

  // @LINE:2
  private[this] lazy val controllers_GarageController_retrieveGarage1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("garages/"), DynamicPart("garageId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_GarageController_retrieveGarage1_invoker = createInvoker(
    GarageController_0.retrieveGarage(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GarageController",
      "retrieveGarage",
      Seq(classOf[String]),
      "GET",
      this.prefix + """garages/""" + "$" + """garageId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:3
  private[this] lazy val controllers_GarageController_modifyGarage2_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("garages/"), DynamicPart("garageId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_GarageController_modifyGarage2_invoker = createInvoker(
    GarageController_0.modifyGarage(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GarageController",
      "modifyGarage",
      Seq(classOf[String]),
      "PUT",
      this.prefix + """garages/""" + "$" + """garageId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:4
  private[this] lazy val controllers_GarageController_deleteGarage3_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("garages/"), DynamicPart("garageId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_GarageController_deleteGarage3_invoker = createInvoker(
    GarageController_0.deleteGarage(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GarageController",
      "deleteGarage",
      Seq(classOf[String]),
      "DELETE",
      this.prefix + """garages/""" + "$" + """garageId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:5
  private[this] lazy val controllers_GarageController_retrieveAllCars4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("garages/"), DynamicPart("garageId", """[^/]+""",true), StaticPart("/cars")))
  )
  private[this] lazy val controllers_GarageController_retrieveAllCars4_invoker = createInvoker(
    GarageController_0.retrieveAllCars(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GarageController",
      "retrieveAllCars",
      Seq(classOf[String]),
      "GET",
      this.prefix + """garages/""" + "$" + """garageId<[^/]+>/cars""",
      """""",
      Seq()
    )
  )

  // @LINE:6
  private[this] lazy val controllers_GarageController_addCarToGarage5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("garages/"), DynamicPart("garageId", """[^/]+""",true), StaticPart("/cars")))
  )
  private[this] lazy val controllers_GarageController_addCarToGarage5_invoker = createInvoker(
    GarageController_0.addCarToGarage(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GarageController",
      "addCarToGarage",
      Seq(classOf[String]),
      "POST",
      this.prefix + """garages/""" + "$" + """garageId<[^/]+>/cars""",
      """""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_GarageController_deleteAllCarsOfGarage6_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("garages/"), DynamicPart("garageId", """[^/]+""",true), StaticPart("/cars")))
  )
  private[this] lazy val controllers_GarageController_deleteAllCarsOfGarage6_invoker = createInvoker(
    GarageController_0.deleteAllCarsOfGarage(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GarageController",
      "deleteAllCarsOfGarage",
      Seq(classOf[String]),
      "DELETE",
      this.prefix + """garages/""" + "$" + """garageId<[^/]+>/cars""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:1
    case controllers_GarageController_createGarage0_route(params@_) =>
      call { 
        controllers_GarageController_createGarage0_invoker.call(GarageController_0.createGarage)
      }
  
    // @LINE:2
    case controllers_GarageController_retrieveGarage1_route(params@_) =>
      call(params.fromPath[String]("garageId", None)) { (garageId) =>
        controllers_GarageController_retrieveGarage1_invoker.call(GarageController_0.retrieveGarage(garageId))
      }
  
    // @LINE:3
    case controllers_GarageController_modifyGarage2_route(params@_) =>
      call(params.fromPath[String]("garageId", None)) { (garageId) =>
        controllers_GarageController_modifyGarage2_invoker.call(GarageController_0.modifyGarage(garageId))
      }
  
    // @LINE:4
    case controllers_GarageController_deleteGarage3_route(params@_) =>
      call(params.fromPath[String]("garageId", None)) { (garageId) =>
        controllers_GarageController_deleteGarage3_invoker.call(GarageController_0.deleteGarage(garageId))
      }
  
    // @LINE:5
    case controllers_GarageController_retrieveAllCars4_route(params@_) =>
      call(params.fromPath[String]("garageId", None)) { (garageId) =>
        controllers_GarageController_retrieveAllCars4_invoker.call(GarageController_0.retrieveAllCars(garageId))
      }
  
    // @LINE:6
    case controllers_GarageController_addCarToGarage5_route(params@_) =>
      call(params.fromPath[String]("garageId", None)) { (garageId) =>
        controllers_GarageController_addCarToGarage5_invoker.call(GarageController_0.addCarToGarage(garageId))
      }
  
    // @LINE:7
    case controllers_GarageController_deleteAllCarsOfGarage6_route(params@_) =>
      call(params.fromPath[String]("garageId", None)) { (garageId) =>
        controllers_GarageController_deleteAllCarsOfGarage6_invoker.call(GarageController_0.deleteAllCarsOfGarage(garageId))
      }
  }
}
