# PillarTDD
Repository for Pillar TDD exercise.

The name of this project is PillarTDD. It is built as a Maven project. The Eclipse IDE was used for development.

The main class is BabysitterBilling.java. The corresponding test class is BabysitterBillingTest.java. 

The main BabysitterBilling class has one public method called 'totalPay'. It accepts three arguments, all of which are required:

	1: Start Hour: An integer for first hour worked, inclusive; should be rounded down to the nearest whole hour from the actual start time. For example, if the actual start time is 5:45, a 5 should be entered. 
	
	2: Stop Hour: An integer for last hour worked, exclusive. Should be rounded up to the nearest whole hour from the actual stop time. For example, if the actual stop time is 3:30, a 4 should be entered. 
	
	3: Family: A single character identifying the family worked for. Valid values are "A", "B", and "C". 

To run the tests, go to the main PillarTDD directory, and enter 'mvn test'. The output indicates the number of tests which have succeeded and failed. 
