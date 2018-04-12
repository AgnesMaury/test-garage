scalaVersion := "2.12.4"

libraryDependencies += jdbc
libraryDependencies += guice
libraryDependencies += "org.postgresql" % "postgresql" % "9.3-1100-jdbc41"
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    name := "test-garage",
    version := "1.0"
  )