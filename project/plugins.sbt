// The Play plugin
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.5.10")

// Web plugins
// CSS Pre-processor - Adds functions/conditionals to CSS
addSbtPlugin("com.typesafe.sbt" % "sbt-less" % "1.1.0") // Maybe remove?

// JS compiler/error checker - Checks for errors and warnings before sending out JS files
addSbtPlugin("com.typesafe.sbt" % "sbt-jshint" % "1.0.4") // Maybe remove?

// JS file dependency handler - loads JS files based on dependency trees and makes sure they are loaded in the correct order.
addSbtPlugin("com.typesafe.sbt" % "sbt-rjs" % "1.0.8") // Maybe remove?

// Creates md5 validity checks for public files to verify non-corrupt
addSbtPlugin("com.typesafe.sbt" % "sbt-digest" % "1.1.1") // Maybe remove?

// JS Unit testing
addSbtPlugin("com.typesafe.sbt" % "sbt-mocha" % "1.1.0") // Maybe remove?

// CSS meta-language - Used for organizing complex CSS styles
addSbtPlugin("org.irundaia.sbt" % "sbt-sassify" % "1.4.6") // Maybe remove?

// Play enhancer - this automatically generates getters/setters for public fields
// and rewrites accessors of these fields to use the getters/setters. Remove this
// plugin if you prefer not to have this feature, or disable on a per project
// basis using disablePlugins(PlayEnhancer) in your build.sbt
addSbtPlugin("com.typesafe.sbt" % "sbt-play-enhancer" % "1.1.0")

// Eclipse plugin
addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "5.1.0")

// Angular
libraryDependencies += "org.webjars.bower" % "angular" % "1.6.1"

// Hibernate
libraryDependencies += "org.hibernate" % "hibernate-entitymanager" % "5.1.0.Final"
