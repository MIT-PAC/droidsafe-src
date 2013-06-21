package android.location;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.RemoteException;
import android.util.Log;

public abstract class LocationProvider {
    private String mName;
    private ILocationManager mService;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.002 -0400", hash_original_method = "BAF0DB5834B7193F7ED3616F680059B0", hash_generated_method = "71956136CAD0AEE1CB910F4DE2242C7D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LocationProvider(String name, ILocationManager service) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(service.dsTaint);
        {
            boolean varB4D0ACA360CC3A8CDEEB8791521063B2_1386379352 = (name.matches(BAD_CHARS_REGEX));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("name " + name +
                " contains an illegal character");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (name.matches(BAD_CHARS_REGEX)) {
            //throw new IllegalArgumentException("name " + name +
                //" contains an illegal character");
        //}
        //mName = name;
        //mService = service;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.002 -0400", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "1698AF415E3250D582962C1A88D4A564")
    @DSModeled(DSC.SAFE)
    public String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.002 -0400", hash_original_method = "635BF1E9CDC5B7DBCFDF1ACD3F6E624D", hash_generated_method = "07985462EB8F90463E6F597CCE8FC46E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean meetsCriteria(Criteria criteria) {
        dsTaint.addTaint(criteria.dsTaint);
        try 
        {
            boolean var195CD10D7384B80733627E7A4A95E4BA_436456370 = (mService.providerMeetsCriteria(mName, criteria));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return mService.providerMeetsCriteria(mName, criteria);
        //} catch (RemoteException e) {
            //Log.e(TAG, "meetsCriteria: RemoteException", e);
            //return false;
        //}
    }

    
    public abstract boolean requiresNetwork();

    
    public abstract boolean requiresSatellite();

    
    public abstract boolean requiresCell();

    
    public abstract boolean hasMonetaryCost();

    
    public abstract boolean supportsAltitude();

    
    public abstract boolean supportsSpeed();

    
    public abstract boolean supportsBearing();

    
    public abstract int getPowerRequirement();

    
    public abstract int getAccuracy();

    
    private static final String TAG = "LocationProvider";
    static final String BAD_CHARS_REGEX = "[^a-zA-Z0-9]";
    public static final int OUT_OF_SERVICE = 0;
    public static final int TEMPORARILY_UNAVAILABLE = 1;
    public static final int AVAILABLE = 2;
}

