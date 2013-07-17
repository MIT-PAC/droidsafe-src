package android.location;

import droidsafe.annotations.DSModeled;

/*
 * With the latest push of PTA code, this began to get flagged as
 * a missing API.  Created a minimalist model for the class.  This
 * class is related to location services, and as such should be tracked
 * very carefully.
 * 
 * @author sgraf
 */
public class LocationManager {
	
	private ILocationManager mService;
	
	@DSModeled(DSC.SPEC)
	public LocationManager(ILocationManager service) {
        mService = service;
    }
}
