package android.location;

// Droidsafe Imports
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

public final class Geocoder {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.056 -0400", hash_original_field = "18200E5D7C3839693F00E5A4D3DAD0B6", hash_generated_field = "CA3AB959F12DEEA21A35F58EC638730B")

    private GeocoderParams mParams;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.056 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "172E00EA90AE9807366F5CA34B42799B")

    private ILocationManager mService;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.057 -0400", hash_original_method = "14E84A4B1974BF851ED8726736E80E86", hash_generated_method = "595D2306ADD17A55F02C614F7038997A")
    public  Geocoder(Context context, Locale locale) {
        if(locale == null)        
        {
            NullPointerException var3F3F6EF29B25D30496E9F54071267749_1823121663 = new NullPointerException("locale == null");
            var3F3F6EF29B25D30496E9F54071267749_1823121663.addTaint(taint);
            throw var3F3F6EF29B25D30496E9F54071267749_1823121663;
        } //End block
        mParams = new GeocoderParams(context, locale);
        IBinder b = ServiceManager.getService(Context.LOCATION_SERVICE);
        mService = ILocationManager.Stub.asInterface(b);
        // ---------- Original Method ----------
        //if (locale == null) {
            //throw new NullPointerException("locale == null");
        //}
        //mParams = new GeocoderParams(context, locale);
        //IBinder b = ServiceManager.getService(Context.LOCATION_SERVICE);
        //mService = ILocationManager.Stub.asInterface(b);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.058 -0400", hash_original_method = "EADDD88BF54CFB72F79FF8220981CC0D", hash_generated_method = "759C4625FD3041193E6A238A72B8718E")
    public  Geocoder(Context context) {
        this(context, Locale.getDefault());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    public static boolean isPresent() {
        IBinder b = ServiceManager.getService(Context.LOCATION_SERVICE);
        ILocationManager lm = ILocationManager.Stub.asInterface(b);
        try {
            return lm.geocoderIsPresent();
        } catch (RemoteException e) {
            Log.e(TAG, "isPresent: got RemoteException", e);
            return false;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.060 -0400", hash_original_method = "284E75C67527B2849F40BED710ED6A66", hash_generated_method = "67EF42A6AA9A22C6E39C5C688B8B0330")
    public List<Address> getFromLocation(double latitude, double longitude, int maxResults) throws IOException {
        addTaint(maxResults);
        addTaint(longitude);
        addTaint(latitude);
        if(latitude < -90.0 || latitude > 90.0)        
        {
            IllegalArgumentException var5CDB5E8BE2780A449DF91F3598B8F033_439945493 = new IllegalArgumentException("latitude == " + latitude);
            var5CDB5E8BE2780A449DF91F3598B8F033_439945493.addTaint(taint);
            throw var5CDB5E8BE2780A449DF91F3598B8F033_439945493;
        } //End block
        if(longitude < -180.0 || longitude > 180.0)        
        {
            IllegalArgumentException var7C246BAC6A5717BCB23B4212A47C4761_1719278974 = new IllegalArgumentException("longitude == " + longitude);
            var7C246BAC6A5717BCB23B4212A47C4761_1719278974.addTaint(taint);
            throw var7C246BAC6A5717BCB23B4212A47C4761_1719278974;
        } //End block
        try 
        {
            List<Address> results = new ArrayList<Address>();
            String ex = mService.getFromLocation(latitude, longitude, maxResults,
                mParams, results);
            if(ex != null)            
            {
                IOException var8B943AA6A4D3283BFEECC199C0F539AA_1439231136 = new IOException(ex);
                var8B943AA6A4D3283BFEECC199C0F539AA_1439231136.addTaint(taint);
                throw var8B943AA6A4D3283BFEECC199C0F539AA_1439231136;
            } //End block
            else
            {
List<Address> var238ECCC9872FFCA0B3C3DB83598FF044_1875665973 =                 results;
                var238ECCC9872FFCA0B3C3DB83598FF044_1875665973.addTaint(taint);
                return var238ECCC9872FFCA0B3C3DB83598FF044_1875665973;
            } //End block
        } //End block
        catch (RemoteException e)
        {
List<Address> var540C13E9E156B687226421B24F2DF178_1432694146 =             null;
            var540C13E9E156B687226421B24F2DF178_1432694146.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1432694146;
        } //End block
        // ---------- Original Method ----------
        //if (latitude < -90.0 || latitude > 90.0) {
            //throw new IllegalArgumentException("latitude == " + latitude);
        //}
        //if (longitude < -180.0 || longitude > 180.0) {
            //throw new IllegalArgumentException("longitude == " + longitude);
        //}
        //try {
            //List<Address> results = new ArrayList<Address>();
            //String ex =  mService.getFromLocation(latitude, longitude, maxResults,
                //mParams, results);
            //if (ex != null) {
                //throw new IOException(ex);
            //} else {
                //return results;
            //}
        //} catch (RemoteException e) {
            //Log.e(TAG, "getFromLocation: got RemoteException", e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.062 -0400", hash_original_method = "29488D3CE065C208A897F66C86CADF17", hash_generated_method = "A387DFB00094824D5AADBDFD4B780914")
    public List<Address> getFromLocationName(String locationName, int maxResults) throws IOException {
        addTaint(maxResults);
        addTaint(locationName.getTaint());
        if(locationName == null)        
        {
            IllegalArgumentException var798B9480099C940248D3D5C9994F9EF0_975726732 = new IllegalArgumentException("locationName == null");
            var798B9480099C940248D3D5C9994F9EF0_975726732.addTaint(taint);
            throw var798B9480099C940248D3D5C9994F9EF0_975726732;
        } //End block
        try 
        {
            List<Address> results = new ArrayList<Address>();
            String ex = mService.getFromLocationName(locationName,
                0, 0, 0, 0, maxResults, mParams, results);
            if(ex != null)            
            {
                IOException var8B943AA6A4D3283BFEECC199C0F539AA_2051576379 = new IOException(ex);
                var8B943AA6A4D3283BFEECC199C0F539AA_2051576379.addTaint(taint);
                throw var8B943AA6A4D3283BFEECC199C0F539AA_2051576379;
            } //End block
            else
            {
List<Address> var238ECCC9872FFCA0B3C3DB83598FF044_952457131 =                 results;
                var238ECCC9872FFCA0B3C3DB83598FF044_952457131.addTaint(taint);
                return var238ECCC9872FFCA0B3C3DB83598FF044_952457131;
            } //End block
        } //End block
        catch (RemoteException e)
        {
List<Address> var540C13E9E156B687226421B24F2DF178_776208618 =             null;
            var540C13E9E156B687226421B24F2DF178_776208618.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_776208618;
        } //End block
        // ---------- Original Method ----------
        //if (locationName == null) {
            //throw new IllegalArgumentException("locationName == null");
        //}
        //try {
            //List<Address> results = new ArrayList<Address>();
            //String ex = mService.getFromLocationName(locationName,
                //0, 0, 0, 0, maxResults, mParams, results);
            //if (ex != null) {
                //throw new IOException(ex);
            //} else {
                //return results;
            //}
        //} catch (RemoteException e) {
            //Log.e(TAG, "getFromLocationName: got RemoteException", e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.064 -0400", hash_original_method = "13307F87291B7F7130BBF7F095A5BF05", hash_generated_method = "04151684FCE729209FBC514D198263B0")
    public List<Address> getFromLocationName(String locationName, int maxResults,
        double lowerLeftLatitude, double lowerLeftLongitude,
        double upperRightLatitude, double upperRightLongitude) throws IOException {
        addTaint(upperRightLongitude);
        addTaint(upperRightLatitude);
        addTaint(lowerLeftLongitude);
        addTaint(lowerLeftLatitude);
        addTaint(maxResults);
        addTaint(locationName.getTaint());
        if(locationName == null)        
        {
            IllegalArgumentException var798B9480099C940248D3D5C9994F9EF0_233270229 = new IllegalArgumentException("locationName == null");
            var798B9480099C940248D3D5C9994F9EF0_233270229.addTaint(taint);
            throw var798B9480099C940248D3D5C9994F9EF0_233270229;
        } //End block
        if(lowerLeftLatitude < -90.0 || lowerLeftLatitude > 90.0)        
        {
            IllegalArgumentException varDC5BD51928E1A02BC95178BCDAB3A8A9_1832076309 = new IllegalArgumentException("lowerLeftLatitude == "
                + lowerLeftLatitude);
            varDC5BD51928E1A02BC95178BCDAB3A8A9_1832076309.addTaint(taint);
            throw varDC5BD51928E1A02BC95178BCDAB3A8A9_1832076309;
        } //End block
        if(lowerLeftLongitude < -180.0 || lowerLeftLongitude > 180.0)        
        {
            IllegalArgumentException var53D4CADC41B8EE441D510B1810C29475_2130491073 = new IllegalArgumentException("lowerLeftLongitude == "
                + lowerLeftLongitude);
            var53D4CADC41B8EE441D510B1810C29475_2130491073.addTaint(taint);
            throw var53D4CADC41B8EE441D510B1810C29475_2130491073;
        } //End block
        if(upperRightLatitude < -90.0 || upperRightLatitude > 90.0)        
        {
            IllegalArgumentException varC4B8A31C00CEFDBFF48C811CEE2B644F_413010481 = new IllegalArgumentException("upperRightLatitude == "
                + upperRightLatitude);
            varC4B8A31C00CEFDBFF48C811CEE2B644F_413010481.addTaint(taint);
            throw varC4B8A31C00CEFDBFF48C811CEE2B644F_413010481;
        } //End block
        if(upperRightLongitude < -180.0 || upperRightLongitude > 180.0)        
        {
            IllegalArgumentException var5FAB725CCE17B470073F2D50AE0545C8_1443990658 = new IllegalArgumentException("upperRightLongitude == "
                + upperRightLongitude);
            var5FAB725CCE17B470073F2D50AE0545C8_1443990658.addTaint(taint);
            throw var5FAB725CCE17B470073F2D50AE0545C8_1443990658;
        } //End block
        try 
        {
            ArrayList<Address> result = new ArrayList<Address>();
            String ex = mService.getFromLocationName(locationName,
                lowerLeftLatitude, lowerLeftLongitude, upperRightLatitude, upperRightLongitude,
                maxResults, mParams, result);
            if(ex != null)            
            {
                IOException var8B943AA6A4D3283BFEECC199C0F539AA_778756387 = new IOException(ex);
                var8B943AA6A4D3283BFEECC199C0F539AA_778756387.addTaint(taint);
                throw var8B943AA6A4D3283BFEECC199C0F539AA_778756387;
            } //End block
            else
            {
List<Address> varDC838461EE2FA0CA4C9BBB70A15456B0_659596615 =                 result;
                varDC838461EE2FA0CA4C9BBB70A15456B0_659596615.addTaint(taint);
                return varDC838461EE2FA0CA4C9BBB70A15456B0_659596615;
            } //End block
        } //End block
        catch (RemoteException e)
        {
List<Address> var540C13E9E156B687226421B24F2DF178_1690231918 =             null;
            var540C13E9E156B687226421B24F2DF178_1690231918.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1690231918;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.064 -0400", hash_original_field = "2F13D28EF33AD881D6EF6A469D590D1B", hash_generated_field = "B31A436DE52E80FF02F1461C2CF60861")

    private static final String TAG = "Geocoder";
}

