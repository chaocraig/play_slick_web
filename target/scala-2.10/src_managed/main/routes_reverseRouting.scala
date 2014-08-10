// @SOURCE:/Users/cray/Documents/workspace-scala/play_slick_web/conf/routes
// @HASH:077912b0446f9b2ddf2c40aa4a2450a20e6391dd
// @DATE:Sun Aug 10 15:41:40 CST 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString


// @LINE:24
// @LINE:23
// @LINE:20
// @LINE:17
// @LINE:14
// @LINE:12
// @LINE:9
// @LINE:6
package controllers {

// @LINE:20
class ReverseAssets {
    

// @LINE:20
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:24
// @LINE:23
// @LINE:17
// @LINE:14
// @LINE:12
// @LINE:9
// @LINE:6
class ReverseApplication {
    

// @LINE:24
def goalAdConversion(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "api/goalAdConversion")
}
                                                

// @LINE:17
def jsonInsert(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "json/insert")
}
                                                

// @LINE:23
def goalAdActivation(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "api/goalAdActivation")
}
                                                

// @LINE:6
def turn(uid:String, bala:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "turn" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("uid", uid)), Some(implicitly[QueryStringBindable[String]].unbind("bala", bala)))))
}
                                                

// @LINE:12
def insert(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "insert")
}
                                                

// @LINE:14
def jsonFindAll(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "json/all")
}
                                                

// @LINE:9
def index(): Call = {
   Call("GET", _prefix)
}
                                                
    
}
                          
}
                  


// @LINE:24
// @LINE:23
// @LINE:20
// @LINE:17
// @LINE:14
// @LINE:12
// @LINE:9
// @LINE:6
package controllers.javascript {

// @LINE:20
class ReverseAssets {
    

// @LINE:20
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:24
// @LINE:23
// @LINE:17
// @LINE:14
// @LINE:12
// @LINE:9
// @LINE:6
class ReverseApplication {
    

// @LINE:24
def goalAdConversion : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.goalAdConversion",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/goalAdConversion"})
      }
   """
)
                        

// @LINE:17
def jsonInsert : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.jsonInsert",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "json/insert"})
      }
   """
)
                        

// @LINE:23
def goalAdActivation : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.goalAdActivation",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/goalAdActivation"})
      }
   """
)
                        

// @LINE:6
def turn : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.turn",
   """
      function(uid,bala) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "turn" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("uid", uid), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("bala", bala)])})
      }
   """
)
                        

// @LINE:12
def insert : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.insert",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "insert"})
      }
   """
)
                        

// @LINE:14
def jsonFindAll : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.jsonFindAll",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "json/all"})
      }
   """
)
                        

// @LINE:9
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:24
// @LINE:23
// @LINE:20
// @LINE:17
// @LINE:14
// @LINE:12
// @LINE:9
// @LINE:6
package controllers.ref {


// @LINE:20
class ReverseAssets {
    

// @LINE:20
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:24
// @LINE:23
// @LINE:17
// @LINE:14
// @LINE:12
// @LINE:9
// @LINE:6
class ReverseApplication {
    

// @LINE:24
def goalAdConversion(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.goalAdConversion(), HandlerDef(this, "controllers.Application", "goalAdConversion", Seq(), "POST", """""", _prefix + """api/goalAdConversion""")
)
                      

// @LINE:17
def jsonInsert(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.jsonInsert(), HandlerDef(this, "controllers.Application", "jsonInsert", Seq(), "POST", """ Home page""", _prefix + """json/insert""")
)
                      

// @LINE:23
def goalAdActivation(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.goalAdActivation(), HandlerDef(this, "controllers.Application", "goalAdActivation", Seq(), "POST", """ ATS Goals""", _prefix + """api/goalAdActivation""")
)
                      

// @LINE:6
def turn(uid:String, bala:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.turn(uid, bala), HandlerDef(this, "controllers.Application", "turn", Seq(classOf[String], classOf[String]), "GET", """ for TURN DSP""", _prefix + """turn""")
)
                      

// @LINE:12
def insert(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.insert(), HandlerDef(this, "controllers.Application", "insert", Seq(), "POST", """ Home page""", _prefix + """insert""")
)
                      

// @LINE:14
def jsonFindAll(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.jsonFindAll(), HandlerDef(this, "controllers.Application", "jsonFindAll", Seq(), "GET", """""", _prefix + """json/all""")
)
                      

// @LINE:9
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      
    
}
                          
}
        
    