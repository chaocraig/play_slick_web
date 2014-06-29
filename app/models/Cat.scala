package models

import play.api.db.slick.Config.driver.simple._

case class Cat(create_at: String, userID: String, bala: String, url: String, headers: String)

case class Ats(create_at: String, ip: String, bala: String, url: String, headers: String)

case class Conv(create_at: String, userID: String)


/* Table mapping
 */
class CatsTable(tag: Tag) extends Table[Cat](tag, "CAT") {

  //def name = column[String]("name", O.PrimaryKey)
  
  def create_at = column[String]("create_at", O.NotNull)
  def userID = column[String]("userID", O.NotNull)
  def bala = column[String]("bala", O.NotNull)
  def url = column[String]("url", O.DBType("varchar(1024)"))
  def headers = column[String]("headers", O.DBType("varchar(2048)"))

  def * = (create_at, userID, bala, url, headers) <> (Cat.tupled, Cat.unapply _)
}


/* Table mapping
 */
class AtsTable(tag: Tag) extends Table[Ats](tag, "ATS") {

  def create_at = column[String]("create_at", O.NotNull)
  def ip = column[String]("ip", O.NotNull)
  def bala = column[String]("bala", O.NotNull)
  def url = column[String]("url", O.DBType("varchar(1024)"))
  def headers = column[String]("headers", O.DBType("varchar(2048)"))

  def * = (create_at, ip, bala, url, headers) <> (Ats.tupled, Ats.unapply _)
}

/* Table mapping
 */
class ConvTable(tag: Tag) extends Table[Conv](tag, "CONV") {

  def create_at = column[String]("create_at", O.NotNull)
  def userID = column[String]("userID", O.NotNull)

  def * = (create_at, userID) <> (Conv.tupled, Conv.unapply _)
}

