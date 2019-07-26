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
	
	private final static boolean DEBUG = false;
	
	final int familyRate[] = new int[12];
	
	public int totalPay(int startHour, int stopHour, char familyId) {
    	
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
    	
    	//At this point we've validated input data. 
    	//Calculate total pay based on start/stop hour and rate array. 
    	initRate(familyId, familyRate);
    	return calculatePay(startHour, stopHour, familyRate);
    	
    }
	
	//Initialize Family A Pay Rate array: $15 before 11pm, $20 afterwards. 
	private void initRate(char FamilyId, int[] familyRate) {
		Arrays.fill(familyRate, 0, 6, 15 );
		Arrays.fill(familyRate, 6, 12, 20 );
		
		if (DEBUG) {
			System.out.println("\n\n");
			for(int i=0; i<12;i++) {
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
	private int calculatePay(int startHour, int stopHour, int[] payRate) {
		int pay = 0;
		int startOffset = convertHourToOffset(startHour);
		int stopOffset = convertHourToOffset(stopHour);
		
		if (DEBUG) {
			System.out.println("\nStart Offset: " + startOffset);
			System.out.println("Stop Offset: " + stopOffset);
		}
			
		for (int i = startOffset; i < stopOffset; i++) {
			pay += payRate[i];
			
			if (DEBUG) {
				System.out.println("Pay Rate[" + i + "] = " + payRate[i]);
			}
			
		}
		return pay;
	}
	
}
