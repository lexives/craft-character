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
// Web browser JS editor
libraryDependencies += "org.webjars" % "codemirror" % "5.23.0-1"
// AngularJS
libraryDependencies += "org.webjars.bower" % "angular" % "1.6.1"

// Compile before setting up eclipse
EclipseKeys.preTasks := Seq(compile in Compile)
