# Project05_ChrisBharucha

Project 5:
  Project 5 posed a new challenge in that it requires not only the use of some calculations using methods and classes,
but also displaying the results using JavaFx applications. This project allows for the use of a basic java application
that performs various functions upon the users interaction with the application. The problem solving approach was very
similar to previous projects, just using the output to break down exactly what needs to be included in the application
and where.

HammingDist.java class:
  This class is used for providing all of the calculations that the application needs to display. Within this class, a 
 buffered reader is used to read in all of the stations from the provided MesoStation.txt file. These files are stored in
 an ArrayList<String> and can be accessed anytime via the getStations() method. Additionally, this class has methods that
 calculate and keep track of the number and String Id of the MesoStations that share a certain hamming distance. 
  
HDApplication.java class:
  This class builds and displays the application seen when the code is compiled. Upon compiling the code, the main method
 runs the launch(args) method which calls the method that builds the app. The start() method initializes all of the classes
 local variables, and sets them up with the correct initial conditions to be added to the layout. The layout used was GridPane
 because this provides easy access to adding components to the scene in desired areas. A HammingDist.java object is created
 in this class as well in order to access any calculations for the application itself.
  The creative portion was the hardest portion of the project. I had to make sure that the moving image of the man himself was
perfect, as I did not want to embarrass myself. Watching a few tutorials online and a bit of work resulted in the final copy.
