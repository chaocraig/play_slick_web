name := """play_slick_web"""

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
    jdbc,anorm,cache,
  "mysql" % "mysql-connector-java" % "5.1.27",
  "org.webjars" %% "webjars-play" % "2.2.2",
  "com.typesafe.play" %% "play-slick" % "0.6.0.1"
)


play.Project.playScalaSettings