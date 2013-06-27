package android.location;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.location.Address;
import android.os.RemoteException;
import android.os.IBinder;
import android.os.ServiceManager;
import android.util.Log;
import java.io.IOException;
import java.util.Locale;
import java.util.ArrayList;
import java.util.List;

public final class Geocoder {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.768 -0400", hash_original_field = "18200E5D7C3839693F00E5A4D3DAD0B6", hash_generated_field = "CA3AB959F12DEEA21A35F58EC638730B")

    private GeocoderParams mParams;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.783 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "172E00EA90AE9807366F5CA34B42799B")

    private ILocationManager mService;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.784 -0400", hash_original_method = "14E84A4B1974BF851ED8726736E80E86", hash_generated_method = "0E62357E9F266E51BA1932426DA6AC9F")
    public  Geocoder(Context context, Locale locale) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("locale == null");
        } //End block
        mParams = new GeocoderParams(context, locale);
        IBinder b;
        b = ServiceManager.getService(Context.LOCATION_SERVICE);
        mService = ILocationManager.Stub.asInterface(b);
        // ---------- Original Method ----------
        //if (locale == null) {
            //throw new NullPointerException("locale == null");
        //}
        //mParams = new GeocoderParams(context, locale);
        //IBinder b = ServiceManager.getService(Context.LOCATION_SERVICE);
        //mService = ILocationManager.Stub.asInterface(b);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.785 -0400", hash_original_method = "EADDD88BF54CFB72F79FF8220981CC0D", hash_generated_method = "759C4625FD3041193E6A238A72B8718E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.795 -0400", hash_original_method = "284E75C67527B2849F40BED710ED6A66", hash_generated_method = "78F0CDF56816D0B3C44C7FA2D20F69EE")
    public List<Address> getFromLocation(double latitude, double longitude, int maxResults) throws IOException {
        List<Address> varB4EAC82CA7396A68D541C85D26508E83_1231231720 = null; //Variable for return #1
        List<Address> varB4EAC82CA7396A68D541C85D26508E83_213646336 = null; //Variable for return #2
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("latitude == " + latitude);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("longitude == " + longitude);
        } //End block
        try 
        {
            List<Address> results;
            results = new ArrayList<Address>();
            String ex;
            ex = mService.getFromLocation(latitude, longitude, maxResults,
                mParams, results);
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException(ex);
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1231231720 = results;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_213646336 = null;
        } //End block
        addTaint(latitude);
        addTaint(longitude);
        addTaint(maxResults);
        List<Address> varA7E53CE21691AB073D9660D615818899_1637764902; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1637764902 = varB4EAC82CA7396A68D541C85D26508E83_1231231720;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1637764902 = varB4EAC82CA7396A68D541C85D26508E83_213646336;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1637764902.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1637764902;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.808 -0400", hash_original_method = "29488D3CE065C208A897F66C86CADF17", hash_generated_method = "32E4E434B1120DB992811D7FE0737409")
    public List<Address> getFromLocationName(String locationName, int maxResults) throws IOException {
        List<Address> varB4EAC82CA7396A68D541C85D26508E83_315416144 = null; //Variable for return #1
        List<Address> varB4EAC82CA7396A68D541C85D26508E83_1930055444 = null; //Variable for return #2
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("locationName == null");
        } //End block
        try 
        {
            List<Address> results;
            results = new ArrayList<Address>();
            String ex;
            ex = mService.getFromLocationName(locationName,
                0, 0, 0, 0, maxResults, mParams, results);
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException(ex);
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_315416144 = results;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1930055444 = null;
        } //End block
        addTaint(locationName.getTaint());
        addTaint(maxResults);
        List<Address> varA7E53CE21691AB073D9660D615818899_1828329984; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1828329984 = varB4EAC82CA7396A68D541C85D26508E83_315416144;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1828329984 = varB4EAC82CA7396A68D541C85D26508E83_1930055444;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1828329984.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1828329984;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.819 -0400", hash_original_method = "13307F87291B7F7130BBF7F095A5BF05", hash_generated_method = "D0F60E30E377ADEA92C05E524375C4A0")
    public List<Address> getFromLocationName(String locationName, int maxResults,
        double lowerLeftLatitude, double lowerLeftLongitude,
        double upperRightLatitude, double upperRightLongitude) throws IOException {
        List<Address> varB4EAC82CA7396A68D541C85D26508E83_1746940576 = null; //Variable for return #1
        List<Address> varB4EAC82CA7396A68D541C85D26508E83_645138862 = null; //Variable for return #2
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("locationName == null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("lowerLeftLatitude == "
                + lowerLeftLatitude);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("lowerLeftLongitude == "
                + lowerLeftLongitude);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("upperRightLatitude == "
                + upperRightLatitude);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("upperRightLongitude == "
                + upperRightLongitude);
        } //End block
        try 
        {
            ArrayList<Address> result;
            result = new ArrayList<Address>();
            String ex;
            ex = mService.getFromLocationName(locationName,
                lowerLeftLatitude, lowerLeftLongitude, upperRightLatitude, upperRightLongitude,
                maxResults, mParams, result);
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException(ex);
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1746940576 = result;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_645138862 = null;
        } //End block
        addTaint(locationName.getTaint());
        addTaint(maxResults);
        addTaint(lowerLeftLatitude);
        addTaint(lowerLeftLongitude);
        addTaint(upperRightLatitude);
        addTaint(upperRightLongitude);
        List<Address> varA7E53CE21691AB073D9660D615818899_847921373; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_847921373 = varB4EAC82CA7396A68D541C85D26508E83_1746940576;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_847921373 = varB4EAC82CA7396A68D541C85D26508E83_645138862;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_847921373.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_847921373;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.933 -0400", hash_original_field = "2F13D28EF33AD881D6EF6A469D590D1B", hash_generated_field = "9894B86866D1F27E7FCA1473C6E65860")

    private static String TAG = "Geocoder";
}

