scalaVersion := "2.12.4"

libraryDependencies += jdbc
libraryDependencies += guice
libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.14"
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    name := "test-garage",
    version := "1.0"
  )