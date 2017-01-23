name := "Craft: Character"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.8"

// --- List dependancies ---

// TODO: Remove unused dependencies
// Java SQL driver
// libraryDependencies += javaJdbc
libraryDependencies += cache
// libraryDependencies += javaWs

// MongoDB driver
libraryDependencies += "uk.co.panaxiom" %% "play-jongo" % "2.0.0-jongo1.3"
