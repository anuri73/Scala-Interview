name := "Scala-Interview"

ThisBuild / scalaVersion := "3.2.0"

ThisBuild / scalacOptions ++= List(
  "-feature",
  "-deprecation",
  "-Ykind-projector:underscores",
  "-source:future"
)
