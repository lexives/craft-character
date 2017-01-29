# Craft: Character

Craft: Character is a web application for managing Pathfinder character sheets.

## Dependencies
* JDK v1.8+
* SBT v0.13+
* MongoDB

## Install
Run:
`git clone https://tflucke@github.com/lexives/craft-character.git`

## Configure IDE
### Eclipse
Run once before using:
`sbt eclipse`
<<<<<<< HEAD

**Note:** You will have to rerun this command if your project directory changes.

To enter debug mode, run:
`sbt -jvm-debug <debug port> run`
or
`sbt -jvm-debug <debug port> ~run`

To use the eclipse debugger,  Right-Click on the craft-character project and
navigate to Debug As > Debug Configurations.  Right-Click Remote Java Applications
and click New.  Set the debug port and apply.

## Running
To run the program, run the command:
`sbt run`
Connect to the program using your web browser and the URL "http://0.0.0.0:9000".

Instead, to automatically recompile when the source changes, run :
`sbt ~run`

This file will be packaged with your application when using `activator dist`.

There are several demonstration files available in this template.

## Distributing
To package the final product, run:
`sbt dist`
This will create a zip file in craft-character/target/universal/ directory containing
the runnable play server.  

## Contributors
Developed by Lexi Ives and Thomas Flucke.

## License
<<<<<<< HEAD
TBD - see the LICENSE.md file for details
=======
TBD - see the LICENSE.md file for details
>>>>>>> 154729a79df35e4d28cd6eefd2e822321032934a
