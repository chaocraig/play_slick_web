// @SOURCE:/Users/cray/Documents/workspace-scala/play_slick_web/conf/routes
// @HASH:077912b0446f9b2ddf2c40aa4a2450a20e6391dd
// @DATE:Sun Aug 10 15:41:40 CST 2014


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_turn0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("turn"))))
        

// @LINE:9
private[this] lazy val controllers_Application_index1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:12
private[this] lazy val controllers_Application_insert2 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("insert"))))
        

// @LINE:14
private[this] lazy val controllers_Application_jsonFindAll3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("json/all"))))
        

// @LINE:17
private[this] lazy val controllers_Application_jsonInsert4 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("json/insert"))))
        

// @LINE:20
private[this] lazy val controllers_Assets_at5 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        

// @LINE:23
private[this] lazy val controllers_Application_goalAdActivation6 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/goalAdActivation"))))
        

// @LINE:24
private[this] lazy val controllers_Application_goalAdConversion7 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/goalAdConversion"))))
        
def documentation = List(("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """turn""","""controllers.Application.turn(uid:String, bala:String)"""),("""GET""", prefix,"""controllers.Application.index"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """insert""","""controllers.Application.insert"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """json/all""","""controllers.Application.jsonFindAll"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """json/insert""","""controllers.Application.jsonInsert"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/goalAdActivation""","""controllers.Application.goalAdActivation"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/goalAdConversion""","""controllers.Application.goalAdConversion""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_turn0(params) => {
   call(params.fromQuery[String]("uid", None), params.fromQuery[String]("bala", None)) { (uid, bala) =>
        invokeHandler(controllers.Application.turn(uid, bala), HandlerDef(this, "controllers.Application", "turn", Seq(classOf[String], classOf[String]),"GET", """ for TURN DSP""", Routes.prefix + """turn"""))
   }
}
        

// @LINE:9
case controllers_Application_index1(params) => {
   call { 
        invokeHandler(controllers.Application.index, HandlerDef(this, "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:12
case controllers_Application_insert2(params) => {
   call { 
        invokeHandler(controllers.Application.insert, HandlerDef(this, "controllers.Application", "insert", Nil,"POST", """ Home page""", Routes.prefix + """insert"""))
   }
}
        

// @LINE:14
case controllers_Application_jsonFindAll3(params) => {
   call { 
        invokeHandler(controllers.Application.jsonFindAll, HandlerDef(this, "controllers.Application", "jsonFindAll", Nil,"GET", """""", Routes.prefix + """json/all"""))
   }
}
        

// @LINE:17
case controllers_Application_jsonInsert4(params) => {
   call { 
        invokeHandler(controllers.Application.jsonInsert, HandlerDef(this, "controllers.Application", "jsonInsert", Nil,"POST", """ Home page""", Routes.prefix + """json/insert"""))
   }
}
        

// @LINE:20
case controllers_Assets_at5(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        

// @LINE:23
case controllers_Application_goalAdActivation6(params) => {
   call { 
        invokeHandler(controllers.Application.goalAdActivation, HandlerDef(this, "controllers.Application", "goalAdActivation", Nil,"POST", """ ATS Goals""", Routes.prefix + """api/goalAdActivation"""))
   }
}
        

// @LINE:24
case controllers_Application_goalAdConversion7(params) => {
   call { 
        invokeHandler(controllers.Application.goalAdConversion, HandlerDef(this, "controllers.Application", "goalAdConversion", Nil,"POST", """""", Routes.prefix + """api/goalAdConversion"""))
   }
}
        
}

}
     