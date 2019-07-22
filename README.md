# PillarTDD
Repository for Pillar TDD exercise. . 

The name of this project is PillarTDD. It is built as a Maven project. The Eclipse IDE was used for development.

The main class is BabysitterBilling.java. The corresponding test class is BabysitterBillingTest.java. 

The main BabysitterBilling class has one public method called 'totalPay'. It accepts three arguments:
	An integer for first hour worked. Valid values are between 5 and 12, inclusive. 
	An integer for last hour worked. Valid values are 12, and between 1 and 4, inclusive. 
	A single character for the Family identifier. Valid values are "A", "B", and "C". 

To run the tests, go to the main PillarTDD directory, and enter 'mvn test'. The output indicates the number of tests which have succeeded and failed. 
