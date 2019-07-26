# PillarTDD
Repository for Pillar TDD exercise. 

The name of this project is PillarTDD. It is designed to satisfy the requirements stated in the Kata description at https://github.com/PillarTechnology/kata-babysitter. PillarTDD is structured as a Maven project. The Eclipse IDE was used for development. The project can be cloned from GitHub repository at https://github.com/DJHutira/PillarTDD. 

The main class is BabysitterBilling.java. The corresponding test class is BabysitterBillingTest.java. 

The main BabysitterBilling class has one public method called 'totalPay'. It accepts three arguments, all of which are required:

	1: Start Hour: An integer representing the first hour worked, inclusive. This value should be rounded down to the nearest whole hour from the actual start time. For example, if the actual start time is 5:45, a 5 should be entered. 	Valid values are between 1 and 12, inclusive, excluding 4.

	2: Stop Hour: An integer representing the last hour worked, exclusive. This value should be rounded up to the nearest whole hour from the actual stop time. For example, if the actual stop time is 3:30, a 4 should be entered. Valid values are between 1 and 12.
	
	3: Family ID: A single character identifying the family worked for. Valid values are 'A', 'B', and 'C'.

If the start/stop hours and Family ID are valid, the total pay is returned, as a positive integer in dollars. If the start/stop hours or Family ID is invalid, a negative value is returned, indicating the type of error: 

	-1: Range Error: Start and/or Stop Hour is out of range. 
	
	-2: Start/Stop Chronological error: Stop Hour is before Start Hour. 
	
	-3: Family ID error: Invalid Family ID. 

To run the tests, clone the repository to your local computer, then go to the main PillarTDD directory and enter 'mvn test'. This builds the project and runs the tests. The output indicates the number of tests which have succeeded and failed. 
