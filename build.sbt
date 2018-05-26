
val buildSettings = Seq(
  organization := "com.softwaremill.scalamacrodebug",
  version := "0.4.1",
  scalaVersion := "2.12.6"
)

lazy val root = (project in file("."))
  .settings(buildSettings)
  .aggregate(macros, examples)

lazy val macros = (project in file("macros"))
  .settings(buildSettings)
  .settings(libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value)

lazy val examples = (project in file("examples"))
  .settings(buildSettings)
  .dependsOn(macros)
