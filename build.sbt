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
libraryDependencies += javaJpa
libraryDependencies += "org.hibernate.ogm" % "hibernate-ogm-mongodb" % "5.1.0.Beta3"

// MongoDB driver
libraryDependencies += "uk.co.panaxiom" %% "play-jongo" % "2.0.0-jongo1.3"
// AngularJS
libraryDependencies += "org.webjars.bower" % "angular" % "1.6.1"
// Angular Resource
libraryDependencies += "org.webjars.bower" % "angular-resource" % "1.6.1"
// Web browser JS editor
libraryDependencies += "org.webjars" % "ui-codemirror" % "0.1.5"

// Compile before setting up eclipse
EclipseKeys.preTasks := Seq(compile in Compile)
