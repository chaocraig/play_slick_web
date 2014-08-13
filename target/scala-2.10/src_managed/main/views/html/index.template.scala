
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
    <input name="uid" type="text" placeholder="name your feline friend"/>
    <input name="bala" type="text" placeholder="enter the color of this kitty cat"/>
    <input name="ip" type="text" value="IP" placeholder="URL"/>
    <input name="url" type="text" value="URL" placeholder="URL"/>
    <input name="headers" type="text" value="N" placeholder="headers"/>
    <input type="submit"/>
  </form>

  <h2>Previously inserted cats:</h2>
  <table>
    <tr><th>Name</th><th>Color</th></tr>
    """),_display_(Seq[Any](/*20.6*/for(c <- cats) yield /*20.20*/{_display_(Seq[Any](format.raw/*20.21*/(""" 
    <tr><td>"""),_display_(Seq[Any](/*21.14*/c/*21.15*/.create_at)),format.raw/*21.25*/("""</td><tr><td>"""),_display_(Seq[Any](/*21.39*/c/*21.40*/.uid)),format.raw/*21.44*/("""</td><td>"""),_display_(Seq[Any](/*21.54*/c/*21.55*/.bala)),format.raw/*21.60*/("""</td><td>"""),_display_(Seq[Any](/*21.70*/c/*21.71*/.ip)),format.raw/*21.74*/("""</td><td>"""),_display_(Seq[Any](/*21.84*/c/*21.85*/.url)),format.raw/*21.89*/("""</td><td>"""),_display_(Seq[Any](/*21.99*/c/*21.100*/.headers)),format.raw/*21.108*/("""</td></tr>
    """)))})),format.raw/*22.6*/("""
  </table>


  <h2>Previously inserted ats:</h2>
  <table>
    <tr><th>IP</th><th>bala</th></tr>
    """),_display_(Seq[Any](/*29.6*/for(c <- ats) yield /*29.19*/{_display_(Seq[Any](format.raw/*29.20*/(""" 
    <tr><td>"""),_display_(Seq[Any](/*30.14*/c/*30.15*/.create_at)),format.raw/*30.25*/("""</td><tr><td>"""),_display_(Seq[Any](/*30.39*/c/*30.40*/.ip)),format.raw/*30.43*/("""</td><td>"""),_display_(Seq[Any](/*30.53*/c/*30.54*/.action_type)),format.raw/*30.66*/("""</td><td>"""),_display_(Seq[Any](/*30.76*/c/*30.77*/.goalId)),format.raw/*30.84*/("""</td><td>"""),_display_(Seq[Any](/*30.94*/c/*30.95*/.gaid)),format.raw/*30.100*/("""</td><td>"""),_display_(Seq[Any](/*30.110*/c/*30.111*/.url)),format.raw/*30.115*/("""</td><td>"""),_display_(Seq[Any](/*30.125*/c/*30.126*/.headers)),format.raw/*30.134*/("""</td></tr>
    """)))})),format.raw/*31.6*/("""
  </table>


    
""")))})),format.raw/*36.2*/("""
"""))}
    }
    
    def render(cats:List[Cat],ats:List[Ats]): play.api.templates.HtmlFormat.Appendable = apply(cats,ats)
    
    def f:((List[Cat],List[Ats]) => play.api.templates.HtmlFormat.Appendable) = (cats,ats) => apply(cats,ats)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Aug 13 23:08:57 CST 2014
                    SOURCE: /Users/cray/Documents/workspace-scala/play_slick_web/app/views/index.scala.html
                    HASH: d741e0b992a3446a96019646fadbadb6b9812dfb
                    MATRIX: 569->1|696->34|734->38|762->58|801->60|1482->706|1512->720|1551->721|1602->736|1612->737|1644->747|1694->761|1704->762|1730->766|1776->776|1786->777|1813->782|1859->792|1869->793|1894->796|1940->806|1950->807|1976->811|2022->821|2033->822|2064->830|2111->846|2249->949|2278->962|2317->963|2368->978|2378->979|2410->989|2460->1003|2470->1004|2495->1007|2541->1017|2551->1018|2585->1030|2631->1040|2641->1041|2670->1048|2716->1058|2726->1059|2754->1064|2801->1074|2812->1075|2839->1079|2886->1089|2897->1090|2928->1098|2975->1114|3026->1134
                    LINES: 19->1|22->1|25->4|25->4|25->4|41->20|41->20|41->20|42->21|42->21|42->21|42->21|42->21|42->21|42->21|42->21|42->21|42->21|42->21|42->21|42->21|42->21|42->21|42->21|42->21|42->21|43->22|50->29|50->29|50->29|51->30|51->30|51->30|51->30|51->30|51->30|51->30|51->30|51->30|51->30|51->30|51->30|51->30|51->30|51->30|51->30|51->30|51->30|51->30|51->30|51->30|52->31|57->36
                    -- GENERATED --
                */
            