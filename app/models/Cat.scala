package models

import play.api.db.slick.Config.driver.simple._

case class Cat(create_at: String, uid: String, bala: String, ip:String, url: String, headers: String)

case class Ats(create_at: String, ip: String, action_type: String, goalId:String, gaid:String, url: String, headers: String)

case class Conv(create_at: String, uid: String, ip:String, goalId:String, gaid:String)


/* Table mapping
 */
class CatsTable(tag: Tag) extends Table[Cat](tag, "CAT") {

  //def name = column[String]("name", O.PrimaryKey)
  
  def create_at = column[String]("create_at", O.NotNull)
  def uid = column[String]("uid", O.NotNull)
  def bala = column[String]("bala", O.NotNull)
  def ip = column[String]("ip", O.NotNull)
  def url = column[String]("url", O.DBType("varchar(1024)"))
  def headers = column[String]("headers", O.DBType("varchar(2048)"))

  def * = (create_at, uid, bala, ip, url, headers) <> (Cat.tupled, Cat.unapply _)
}


/* Table mapping
 */
class AtsTable(tag: Tag) extends Table[Ats](tag, "ATS") {

  def create_at = column[String]("create_at", O.NotNull)
  def ip = column[String]("ip", O.NotNull)
  def action_type = column[String]("action_type", O.NotNull)
  def goalId = column[String]("goalId", O.NotNull)
  def gaid = column[String]("gaid", O.NotNull)
  def url = column[String]("url", O.DBType("varchar(1024)"))
  def headers = column[String]("headers", O.DBType("varchar(2048)"))

  def * = (create_at, ip, action_type, goalId, gaid, url, headers) <> (Ats.tupled, Ats.unapply _)
}

/* Table mapping
 */
class ConvTable(tag: Tag) extends Table[Conv](tag, "CONV") {

  def create_at = column[String]("create_at", O.NotNull)
  def uid = column[String]("uid", O.NotNull)
  def ip = column[String]("ip", O.NotNull)
  def goalId = column[String]("goalId", O.NotNull)
  def gaid = column[String]("gaid", O.NotNull)

  def * = (create_at, uid, ip, goalId, gaid) <> (Conv.tupled, Conv.unapply _)
}

