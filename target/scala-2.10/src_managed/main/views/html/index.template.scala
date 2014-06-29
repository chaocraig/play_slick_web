
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._
/**/
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[List[Cat],List[Ats],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(cats: List[Cat], ats: List[Ats]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.35*/("""


"""),_display_(Seq[Any](/*4.2*/main("Cat database")/*4.22*/ {_display_(Seq[Any](format.raw/*4.24*/("""
  <h2>Insert a kitty cat here:</h2>

  <form action="/insert" method="POST">
    <input name="create_at" type="text" value="N" placeholder="create_at"/>
    <input name="userID" type="text" placeholder="name your feline friend"/>
    <input name="bala" type="text" placeholder="enter the color of this kitty cat"/>
    <input name="url" type="text" value="N" placeholder="URL"/>
    <input name="headers" type="text" value="N" placeholder="headers"/>
    <input type="submit"/>
  </form>

  <h2>Previously inserted cats:</h2>
  <table>
    <tr><th>Name</th><th>Color</th></tr>
    """),_display_(Seq[Any](/*19.6*/for(c <- cats) yield /*19.20*/{_display_(Seq[Any](format.raw/*19.21*/(""" 
    <tr><td>"""),_display_(Seq[Any](/*20.14*/c/*20.15*/.create_at)),format.raw/*20.25*/("""</td><tr><td>"""),_display_(Seq[Any](/*20.39*/c/*20.40*/.userID)),format.raw/*20.47*/("""</td><td>"""),_display_(Seq[Any](/*20.57*/c/*20.58*/.bala)),format.raw/*20.63*/("""</td><td>"""),_display_(Seq[Any](/*20.73*/c/*20.74*/.url)),format.raw/*20.78*/("""</td><td>"""),_display_(Seq[Any](/*20.88*/c/*20.89*/.headers)),format.raw/*20.97*/("""</td></tr>
    """)))})),format.raw/*21.6*/("""
  </table>


  <h2>Previously inserted ats:</h2>
  <table>
    <tr><th>IP</th><th>bala</th></tr>
    """),_display_(Seq[Any](/*28.6*/for(c <- ats) yield /*28.19*/{_display_(Seq[Any](format.raw/*28.20*/(""" 
    <tr><td>"""),_display_(Seq[Any](/*29.14*/c/*29.15*/.create_at)),format.raw/*29.25*/("""</td><tr><td>"""),_display_(Seq[Any](/*29.39*/c/*29.40*/.ip)),format.raw/*29.43*/("""</td><td>"""),_display_(Seq[Any](/*29.53*/c/*29.54*/.bala)),format.raw/*29.59*/("""</td><td>"""),_display_(Seq[Any](/*29.69*/c/*29.70*/.url)),format.raw/*29.74*/("""</td><td>"""),_display_(Seq[Any](/*29.84*/c/*29.85*/.headers)),format.raw/*29.93*/("""</td></tr>
    """)))})),format.raw/*30.6*/("""
  </table>


    
""")))})),format.raw/*35.2*/("""
"""))}
    }
    
    def render(cats:List[Cat],ats:List[Ats]): play.api.templates.HtmlFormat.Appendable = apply(cats,ats)
    
    def f:((List[Cat],List[Ats]) => play.api.templates.HtmlFormat.Appendable) = (cats,ats) => apply(cats,ats)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Jun 27 11:59:45 CST 2014
                    SOURCE: /Users/cray/Documents/workspace-scala/play-slick-quickstart/app/views/index.scala.html
                    HASH: 79c839d2125ffa575d4908f3fff1c24fc5ece1b7
                    MATRIX: 569->1|696->34|734->38|762->58|801->60|1419->643|1449->657|1488->658|1539->673|1549->674|1581->684|1631->698|1641->699|1670->706|1716->716|1726->717|1753->722|1799->732|1809->733|1835->737|1881->747|1891->748|1921->756|1968->772|2106->875|2135->888|2174->889|2225->904|2235->905|2267->915|2317->929|2327->930|2352->933|2398->943|2408->944|2435->949|2481->959|2491->960|2517->964|2563->974|2573->975|2603->983|2650->999|2701->1019
                    LINES: 19->1|22->1|25->4|25->4|25->4|40->19|40->19|40->19|41->20|41->20|41->20|41->20|41->20|41->20|41->20|41->20|41->20|41->20|41->20|41->20|41->20|41->20|41->20|42->21|49->28|49->28|49->28|50->29|50->29|50->29|50->29|50->29|50->29|50->29|50->29|50->29|50->29|50->29|50->29|50->29|50->29|50->29|51->30|56->35
                    -- GENERATED --
                */
            