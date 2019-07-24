package com.pillar.djh;

/**
 * Babysitter Billing App. 
 *
 */
public class BabysitterBilling 
{
	
	final static int FAILURE = -1;
	
    public int totalPay(int startHour, int stopHour, char family) {
    	
    	//Check that start/stop hours are in range: All integers 1-12 inclusive are valid, 
    	//except that the start hour cannot be 4. 
    	if((startHour == 4) ||
    	   (startHour < 1 || startHour > 12) ||
    	   (stopHour < 1 || stopHour > 12)) {
    		return FAILURE;
    	}
    	
    	//Check that start hour is greater chronologically than stop hour. 
    	if ((stopHour < startHour && startHour <= 12 && stopHour < 12) ||
    		(stopHour >= 5 && stopHour <= 12 && startHour >= 1 && startHour <= 4) ||	
    		(stopHour < startHour && startHour <= 4 && stopHour < 4 )) {
    		return FAILURE;
    	}
    	
    	//If no hours were worked, return no pay. 
    	if(startHour == stopHour) {	
    		return 0;
    	}
    	
    	//If a known condition was not detected, assume failure. 
    	return FAILURE; 
    	
    }
}
