package com.pillar.djh;

import java.util.Arrays;

/**
 * Babysitter Billing App. 
 *
 */
public class BabysitterBilling 
{
	
	public final static int RANGE_ERROR = -1;
	public final static int START_STOP_ERROR = -2;
	public final static int FAMILY_ID_ERROR = -3;
	private final static int ARRAY_LENGTH = 12;
	
	private static boolean debug = false;
	
	private final int familyRate[] = new int[ARRAY_LENGTH];
	
	public int totalPay(int startHour, int stopHour, char familyId) {
	    
	    //Read debug environment variable.
	  String debugEnv = System.getenv("BabysitterBillingDebug");
	    if (debugEnv != null && debugEnv.equalsIgnoreCase("true")) {
	        debug = true;
	    } else {
	        debug = false;
	    }
	    
    	//Check that start/stop hours are in range: All integers 1-12 inclusive are valid, 
    	//except that the start hour cannot be 4. 
    	if((startHour == 4) ||
    	   (startHour < 1 || startHour > 12) ||
    	   (stopHour < 1 || stopHour > 12)) {
    		return RANGE_ERROR;
    	}
    	
    	//Check that stop hour is greater chronologically than start hour: 
    	//Possible errors:
    	//stop is before start and both start and stop are before 12, 
    	//stop is before 12 and start is after 12, 
    	//or stop is before start and both start and stop are after 12. 
    	if (stopBeforeStartBefore12 (startHour, stopHour) ||
    		stopBefore12StartAfter12 (startHour, stopHour) ||	
    		stopBeforeStartAfter12 (startHour, stopHour)) {
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
    	
    	//Calculate total pay based on start/stop hour and rate schedule. 
    	initRate(familyId);
    	return calculatePay(startHour, stopHour);
    	
    }
	
	//Determine if stop hour is before start hour and both are before 12PM.
	private boolean stopBeforeStartBefore12 (int startHour, int stopHour) {
		if (stopHour < startHour && (startHour >= 5 && startHour <= 12) && (stopHour >= 5 && stopHour <= 12)) {
			return true;
		} else return false; 
	}
	
	//Determine if stop hour is before 12PM and start hour is after 12PM.
	private boolean stopBefore12StartAfter12 (int startHour, int stopHour) {
		if (stopHour >= 5 && stopHour <= 12 && startHour >= 1 && startHour <= 4) {
			return true;
		} else return false; 
	}
	
	//Determine if stop hour is before start hour and both are after 12PM.
	private boolean stopBeforeStartAfter12 (int startHour, int stopHour) {
		if (stopHour < startHour && startHour <= 4 && stopHour < 4) {
			return true;
		} else return false; 
	}
	
	//Initialize Family Pay Rate array:
	//Family A: $15 per hour before 11pm, $20 afterwards. 
	//Family B: $12 per hour before 10pm, $8 between 10pm and 12am, and $16 afterwards.
	//Family C: $21 per hour before 9pm, $15 afterwards.
	private void initRate(char familyId) {
		if (familyId == 'A') {
			Arrays.fill(familyRate, 0, 6, 15);
			Arrays.fill(familyRate, 6, 12, 20);
		} else if (familyId == 'B') {
			Arrays.fill(familyRate, 0, 5, 12);
			Arrays.fill(familyRate, 5, 7, 8);
			Arrays.fill(familyRate, 7, 12, 16);
		} else {
			Arrays.fill(familyRate, 0, 4, 21);
			Arrays.fill(familyRate, 4, 12, 15);
		}
		
		if (debug) {
			System.out.println("\n\nFamily " + familyId + ":");
			for(int i = 0; i< ARRAY_LENGTH; i++) {
				System.out.println("i = " + i + ", rate = " + familyRate[i]);
			}	
		}
	}
	
	//Convert hour to array offset.
	private int convertHourToOffset(int hour) {
		int offset;
		
		if (hour >= 5 && hour <= 12) {
			offset = hour - 5;
		} else {
			offset = hour + 7;
		}
		return offset;
	}
	
	//Calculate pay based on rate and start/stop hour.
	private int calculatePay(int startHour, int stopHour) {
		int pay = 0;
		int startOffset = convertHourToOffset(startHour);
		int stopOffset = convertHourToOffset(stopHour);
		
		if (debug) {
			System.out.println("\nStart Offset: " + startOffset);
			System.out.println("Stop Offset: " + stopOffset);
		}
			
		for (int i = startOffset; i < stopOffset; i++) {
			pay += familyRate[i];
			
			if (debug) {
				System.out.println("Pay Rate[" + i + "] = " + familyRate[i]);
			}
			
		}

		if (debug) {
			System.out.println("Total Pay = " + pay);
		}
		
		return pay;
	}
	
}
