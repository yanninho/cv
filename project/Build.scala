import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "cv"
  val appVersion      = "2.2.2"

  val appDependencies = Seq(
    // Add your project dependencies here,
    "mysql" % "mysql-connector-java" % "5.1.21",
    "postgresql" % "postgresql" % "9.1-901-1.jdbc4",
    javaCore,
    javaJdbc,
    javaEbean
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
  )

}
