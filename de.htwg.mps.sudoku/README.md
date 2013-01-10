# Sudoku in Scala

This project is used as a sample project and architecture for the lecture *Software Engineering* at the University of Applied Science in Konstanz. 

The project evolves over the course of the lecture from a few simple classes to a full blown Model-View-Controller architecture with layers, components, dependency injection. 

It demonstrates the usage of 
+version control with git
+test driven development (TDD) and behaviour driven development (BDD)
+continuous integration with sbt and jenkins
+design patterns
+dependency injection
+interfaces
+documentation using markdown and scaladoc

The project shows how to provide several user interfaces. It is first built with a textual user interface. The architecture is then extended to provide the textual and a graphical user interface in Swing. Both interfaces can be used in parallel. This ensures that the architecture is ready to be extended to further UIs. A view using play is available in a separate git project, since the default package structure is different in play. 

