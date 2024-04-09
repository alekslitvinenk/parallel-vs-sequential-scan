ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.2.1"

lazy val root = (project in file("."))
  .settings(
    name := "project-challenge"
  )

libraryDependencies += ("com.storm-enroute" %% "scalameter" % "0.21" % Test)
  .withCrossVersion(CrossVersion.for3Use2_13 ) exclude("org.scala-lang.modules", "scala-xml_2.13")

libraryDependencies += ("org.scalatest" %% "scalatest" % "3.2.15" % Test)

testFrameworks += new TestFramework("org.scalameter.ScalaMeterFramework")

Test / parallelExecution := false
Test / fork := true
logBuffered := false
