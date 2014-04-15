name:="Sudoku"

version:="1.0"

scalaVersion:="2.9.3"

libraryDependencies += "junit" % "junit" % "4.8" % "test"

libraryDependencies ++= Seq(       
     "org.specs2" %% "specs2" % "1.12.4.1" % "test",
     "org.specs2" %% "specs2-scalaz-core" % "6.0.1" % "test"
  )
  
libraryDependencies += "org.scala-lang" % "scala-swing" % "2.9.2" 
