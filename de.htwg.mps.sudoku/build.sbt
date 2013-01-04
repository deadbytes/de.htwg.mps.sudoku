name:="Sudoku"

version:="1.0"

scalaVersion:="2.9.2"

libraryDependencies += "junit" % "junit" % "4.8" % "test"

libraryDependencies ++= Seq(       
     "org.specs2" %% "specs2" % "1.12.3" % "test",
     "org.specs2" %% "specs2-scalaz-core" % "6.0.1" % "test"
  )
