package com.pillar.djh;

/**
 * Babysitter Billing App. 
 *
 */
public class BabysitterBilling 
{
	
	public final static int RANGE_ERROR = -1;
	final static int START_STOP_ERROR = -2;
	final static int UNKNOWN_ERROR = -3;
	final static int FAMILY_ID_ERROR = -4;
	
	public int totalPay(int startHour, int stopHour, char familyID) {
    	
    	//Check that start/stop hours are in range: All integers 1-12 inclusive are valid, 
    	//except that the start hour cannot be 4. 
    	if((startHour == 4) ||
    	   (startHour < 1 || startHour > 12) ||
    	   (stopHour < 1 || stopHour > 12)) {
    		return RANGE_ERROR;
    	}
    	
    	//Check that start hour is greater chronologically than stop hour. 
    	if ((stopHour < startHour && startHour <= 12 && stopHour < 12) ||
    		(stopHour >= 5 && stopHour <= 12 && startHour >= 1 && startHour <= 4) ||	
    		(stopHour < startHour && startHour <= 4 && stopHour < 4 )) {
    		return START_STOP_ERROR;
    	}
    	
    	//Check that the Family ID is valid. 
    	if(familyID != 'A' && familyID != 'B' && familyID != 'C') {
    		return FAMILY_ID_ERROR;
    	}
    	
    	//If no hours were worked, return no pay. 
    	if(startHour == stopHour) {	
    		return 0;
    	}
    	
    	//If a known condition was not detected, assume failure and return Unknown Error. 
    	return UNKNOWN_ERROR; 
    	
    }
}
