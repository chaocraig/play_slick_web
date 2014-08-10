package controllers

import models._
import play.api._
import play.api.db.slick._
import play.api.db.slick.Config.driver.simple._
import play.api.data._
import play.api.data.Forms._
import play.api.mvc._
import play.api.Play.current
import play.api.mvc.BodyParsers._
import play.api.libs.json.Json
import play.api.libs.json.Json._

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormatter
import org.joda.time.format.DateTimeFormat

import com.vpon.decrypt._;
import com.vpon.xforward._;

import java.io.File
import java.net.URL
import scala.sys.process._




object Application extends Controller{

  //create an instance of the table
  val cats = TableQuery[CatsTable] //see a way to architect your app in the computers-database-slick sample  
  val atsDb  = TableQuery[AtsTable] 
  val convDb = TableQuery[ConvTable] 
  
  final val NO_IP_STR = "X"
  final val CONV_HTTP_HEAD = "/usr/bin/curl https://sr.turn.com/r/beacon?b2=woCSVkJtHoKbplkrPGHL2wk98Cn3xcHMQ60wld9Ibke_6ehyMoDwzXEwzDS4u4ruFJau0A8_GRSw-6Lmy0tf_g&cid=&uid="
  final val CONV_HTTP_TAIL = "&device_sha1=&platform_sha1=&ifa=&mac_sha1=&bprice="
  //final val CONV_HTTPS = "/usr/bin/curl http://127.0.0.1:9000/turn?userID=PLAY12&bala=PLAY12345"
  final val SHELL_LOG_FILE = "/var/tmp/play_slick_log.txt"

  //JSON read/write macro
  implicit val catFormat = Json.format[Cat]

  def index = DBAction { implicit rs =>
    Ok(views.html.index(cats.list, atsDb.list))
  }

  val catForm = Form(
    mapping(
      "create_at" -> text(),
      "uid" -> text(),
      "bala" -> text(),
      "ip" -> text(),
      "url" -> text(),
      "headers" -> text()
    )(Cat.apply)(Cat.unapply)
  )

  val atsForm = Form(
    mapping(
      "create_at" -> text(),
      "ip" -> text(),
      "bala" -> text(),
      "url" -> text(),
      "headers" -> text()
    )(Ats.apply)(Ats.unapply)
  )


  val convForm = Form(
    mapping(
      "create_at" -> text(),
      "uid" -> text(),
      "ip" -> text()
    )(Conv.apply)(Conv.unapply)
  )



  def insert = DBAction { implicit rs =>
    val cat = catForm.bindFromRequest.get
    //println("====> cat="+cat)
    cats.insert(cat)

    Redirect(routes.Application.index)
  }

  def jsonFindAll = DBAction { implicit rs =>
    Ok(toJson(cats.list))
  }

  def jsonInsert = DBAction(parse.json) { implicit rs =>
    rs.request.body.validate[Cat].map { cat =>
        //println("====> cat="+cat)
        cats.insert(cat)
        Ok(toJson(cat))
    }.getOrElse(BadRequest("invalid json"))    
  }
  
  
  def getPublicIp(x: String) = {

		val para = new ParameterUtil()
		val oldIp = x   //x-forwarded-for ???
		val newIp = para.getLastPublicProxyIP(oldIp)
		
		newIp
  }
  
  
  def runShellHtpps(uid:String) = {
     val output0 =  "ls ".!

     //val cmd = Seq("curl", CONV_HTTPS, ">>", SHELL_LOG_FILE)
     //   cmd.lines
     val cmd_str = CONV_HTTP_HEAD + uid + CONV_HTTP_TAIL + " >> " + SHELL_LOG_FILE
     val output = cmd_str.!
     
  }
  
  
  def turn(uid: String, bala1:String) = DBAction { implicit rs =>
    //val userID: Option[String] = request.getQueryString("userID")
    //val bala: Option[String] = request.getQueryString("bala")
      val create_at = DateTime.now.toString("yyyy-MM-dd HH:mm:ss:SSSS")
      val url = rs.uri
      val headers = rs.headers.toString
      val ips = rs.headers.get("X-Forwarded-For").getOrElse(NO_IP_STR)  //x-forwarded-for ???
      val ip = getPublicIp(ips)
      val cat = Cat(create_at, uid, bala1, ip, url, headers)
      cats.insert(cat)
     
      
      val msg =  toJson(cat)
      Ok(msg)
        //Ok("Hello!  userID="+userID+", bala="+bala)
   }

   def decodeGoalAd(data:String, p:String) = {
       val POST_data = data;
       val POST_p = p.toInt;

 	   val cipher = new ApiCipherManagerImpl;
       cipher.init();
       val msg2 = cipher.decrypt(null, POST_data , POST_p, 0);
       
       val msg = "\n["+p+"]["+data+"]\n\n" + msg2;
       msg2
   }


   def getAts(rs:RequestHeader) = {

       val create_at = DateTime.now.toString("yyyy-MM-dd HH:mm:ss:SSSS")
       val ips = rs.headers.get("X-Forwarded-For").getOrElse(NO_IP_STR)  //x-forwarded-for ???
       val client_ip = getPublicIp(ips)
       val url = rs.uri
       val headers = rs.headers.toString
       val ats = Ats(create_at, client_ip, "N", url, headers)
       ats
   }


   def goalAdActivation = DBAction { implicit  rs =>
       /* parse ATS
       val data = rs.body.asFormUrlEncoded.get("data")(0)
       val p = rs.body.asFormUrlEncoded.get("p")(0)
       val msg = decodeGoalAd(data, p)
       */
       val ats=getAts(rs)
       atsDb.insert(ats)
       
       val nearestID = cats.filter(_.ip === ats.ip).sortBy(_.column[String]("create_at").desc).take(1)

       val msg = "goalAdActivation! \n"
       var msg2 = ""
       
       nearestID.list match {
           case List() => msg2 = "\n Not found! " + ats.toString
           case Nil    => msg2 = "\n Not found! " + ats.toString
           case _      => {
               if (nearestID.list.head == List() ) {
                   msg2 = "\n Not found! " + ats.toString
               } else {
                   val cat = nearestID.list.head
                   val conv = Conv(cat.create_at, cat.uid, cat.ip) 
                   convDb.insert(conv)
                   msg2 = "\nInsert: " + conv.toString
                   runShellHtpps(cat.uid)
               }
           }
       }
       
       Ok(msg+"ATS_IP="+ats.ip+msg2)
   }
  
   def goalAdConversion = DBAction { implicit  rs =>
       /* parse ATS
       val data = rs.body.asFormUrlEncoded.get("data")(0)
       val p = rs.body.asFormUrlEncoded.get("p")(0)
       val msg = decodeGoalAd(data, p)
       */
       
       val ats=getAts(rs)
       atsDb.insert(ats)
       
       val nearestID = cats.filter(_.ip === ats.ip).sortBy(_.column[String]("create_at").desc).take(1)

       val msg = "goalAdConversion! \n"
       var msg2 = ""
       nearestID.list match {
           case List() => msg2 = "\n Not found! " + ats.toString
           case Nil    => msg2 = "\n Not found! " + ats.toString
           case _      => {
               if (nearestID.list.head == List() ) {
                   msg2 = "\n Not found! " + ats.toString
               } else {
                   val cat = nearestID.list.head
                   val conv = Conv(cat.create_at, cat.uid, cat.ip) 
                   convDb.insert(conv)
                   msg2 = "\nInsert: " + conv.toString
                   runShellHtpps(cat.uid)
                }
           }
       }
       
       Ok(msg+"ATS_IP="+ats.ip+msg2)
    }
  
}
