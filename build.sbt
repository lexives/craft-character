name := """TBN"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.8"

// --- List dependancies ---

// Java SQL driver
libraryDependencies += javaJdbc // TODO: May not be needed

libraryDependencies += cache
libraryDependencies += javaWs

// MongoDB driver
libraryDependencies += "uk.co.panaxiom" %% "play-jongo" % "2.0.0-jongo1.3"
