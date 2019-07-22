package com.pillar.djh;

/**
 * Babysitter Billing App. 
 *
 */
public class BabysitterBilling 
{
    public int totalPay(int startHour, int stopHour, char family) {
    	
    	//Check that start/stop hours are in range: All integers 1-12 inclusive are valid, 
    	// except that the Start Hour cannot be 4. 
    	if(startHour == 4) {
    		return -1;
    	}
    	
    	return 0;

    	
    }
}
