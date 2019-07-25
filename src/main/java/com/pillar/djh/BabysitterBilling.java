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
	
	public int totalPay(int startHour, int stopHour, char familyId) {
		
		int totalPay = 0;
    	
    	//Check that start/stop hours are in range: All integers 1-12 inclusive are valid, 
    	//except that the start hour cannot be 4. 
    	if((startHour == 4) ||
    	   (startHour < 1 || startHour > 12) ||
    	   (stopHour < 1 || stopHour > 12)) {
    		return RANGE_ERROR;
    	}
    	
    	//Check that stop hour is greater chronologically than start hour: 
		//Possible errors are if stop is less than start and both start and stop are before 12, 
		//stop is before 12 and start is after 12, 
		//or stop is before start and both start and stop are after 12. 
    	if ((stopHour < startHour && (startHour >= 5 && startHour <= 12) && (stopHour >= 5 && stopHour <= 12)) ||
    		(stopHour >= 5 && stopHour <= 12 && startHour >= 1 && startHour <= 4) ||	
    		(stopHour < startHour && startHour <= 4 && stopHour < 4 )) {
    		return START_STOP_ERROR;
    	}
    	
    	//Check that the Family ID is valid. 
    	if(familyId != 'A' && familyId != 'B' && familyId != 'C') {
    		return FAMILY_ID_ERROR;
    	}
    	
    	//If no hours were worked, return no pay. 
    	if(startHour == stopHour) {	
    		return 0;
    	}
    	
    	//Calculate pay for Family 'A' $15 per hour before 11pm, $20 per hour after. 
    	if(familyId == 'A') {
    		//Determine if both start and stop are before 11, 
    		//start is before 11 and stop is after 11, 
    		//or both start and stop are after 11. 
    		if((startHour >= 5 && startHour < 11) && (stopHour > 5 && stopHour <= 11 )) {
    			totalPay = (stopHour - startHour) * 15; 
    		} else if ((startHour >= 5 && startHour < 11) && (stopHour == 12 || (stopHour >= 1 && stopHour <=4))) {
    			//Add in hours before 11pm. 
    			totalPay = (11 - startHour) * 15;
    			//Add in hours after 11pm. 
    			if (stopHour == 12) {
    				totalPay = totalPay + 20;
    			} else {
    				totalPay = totalPay + 40 + (stopHour - 1) * 20;
    			}
    		} else if ((startHour == 12 || (startHour >= 1 && startHour <= 4 )) &&
    				   (stopHour >= 1 && stopHour <= 4)) {
    			if(startHour == 12) {
    				totalPay = 20; 
    			}
    			totalPay = totalPay + (stopHour - startHour) * 20;
    		}
    		return totalPay;
    	}
    	
    	
    	//If a known condition was not detected, assume failure and return Unknown Error. 
    	return UNKNOWN_ERROR; 
    	
    }
}
