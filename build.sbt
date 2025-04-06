ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.16"

lazy val root = (project in file("."))
  .settings(
    name := "scala-2-essentials",
    idePackagePrefix := Some("com.elixirin")
  )
