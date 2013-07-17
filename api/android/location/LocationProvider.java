package android.location;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.RemoteException;
import android.util.Log;

public abstract class LocationProvider {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.732 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

    private String mName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.732 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "172E00EA90AE9807366F5CA34B42799B")

    private ILocationManager mService;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.732 -0400", hash_original_method = "BAF0DB5834B7193F7ED3616F680059B0", hash_generated_method = "BE44554458ECB35F08F7618724B22ACA")
    public  LocationProvider(String name, ILocationManager service) {
        if(name.matches(BAD_CHARS_REGEX))        
        {
            IllegalArgumentException var85E94FA077970DDA7050839618B516D5_854669605 = new IllegalArgumentException("name " + name +
                " contains an illegal character");
            var85E94FA077970DDA7050839618B516D5_854669605.addTaint(taint);
            throw var85E94FA077970DDA7050839618B516D5_854669605;
        } //End block
        mName = name;
        mService = service;
        // ---------- Original Method ----------
        //if (name.matches(BAD_CHARS_REGEX)) {
            //throw new IllegalArgumentException("name " + name +
                //" contains an illegal character");
        //}
        //mName = name;
        //mService = service;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.732 -0400", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "5154CAB3ACBA2254C1D1BF850D8DE22E")
    public String getName() {
String varDBF15A5FB8102A5C28D5046A0E92E443_1832678251 =         mName;
        varDBF15A5FB8102A5C28D5046A0E92E443_1832678251.addTaint(taint);
        return varDBF15A5FB8102A5C28D5046A0E92E443_1832678251;
        // ---------- Original Method ----------
        //return mName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.732 -0400", hash_original_method = "635BF1E9CDC5B7DBCFDF1ACD3F6E624D", hash_generated_method = "0F53C3D98B25B5CCD391B4F03A2A0C26")
    public boolean meetsCriteria(Criteria criteria) {
        addTaint(criteria.getTaint());
        try 
        {
            boolean var6441C998D6EFE0D365E481E0F9D32F81_1339611155 = (mService.providerMeetsCriteria(mName, criteria));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_518855793 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_518855793;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_327078768 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1286617832 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1286617832;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.providerMeetsCriteria(mName, criteria);
        //} catch (RemoteException e) {
            //Log.e(TAG, "meetsCriteria: RemoteException", e);
            //return false;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    public abstract boolean requiresNetwork();

    
    @DSModeled(DSC.SAFE)
    public abstract boolean requiresSatellite();

    
    @DSModeled(DSC.SAFE)
    public abstract boolean requiresCell();

    
    @DSModeled(DSC.SAFE)
    public abstract boolean hasMonetaryCost();

    
    @DSModeled(DSC.SAFE)
    public abstract boolean supportsAltitude();

    
    @DSModeled(DSC.SAFE)
    public abstract boolean supportsSpeed();

    
    @DSModeled(DSC.SAFE)
    public abstract boolean supportsBearing();

    
    @DSModeled(DSC.SAFE)
    public abstract int getPowerRequirement();

    
    @DSModeled(DSC.SAFE)
    public abstract int getAccuracy();

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.734 -0400", hash_original_field = "B067EBE768F4DC555D675AFC3B7A3A83", hash_generated_field = "E0555379B6CF7BCD06CEE07CE9475600")

    private static final String TAG = "LocationProvider";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.734 -0400", hash_original_field = "1BD760940DCF4B31479C267B709A7056", hash_generated_field = "182C0B86C5859E56D7E3C49A25DC759D")

    static final String BAD_CHARS_REGEX = "[^a-zA-Z0-9]";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.734 -0400", hash_original_field = "379AD3D6C566357A345692A65FD14593", hash_generated_field = "7F47E89ED92EB0041561E3E6FDFC0CA8")

    public static final int OUT_OF_SERVICE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.734 -0400", hash_original_field = "2AAE365236DECFBEDF3C4DBC04BC833A", hash_generated_field = "8FC12DE1A6F66422CA33C5DF3A2CD280")

    public static final int TEMPORARILY_UNAVAILABLE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.734 -0400", hash_original_field = "3D413F7DAEB0CA418E5A18E317C11370", hash_generated_field = "299301506C5B5A1C60298C6C87349C6B")

    public static final int AVAILABLE = 2;
}

