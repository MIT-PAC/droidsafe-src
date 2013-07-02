package android.location;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.227 -0400", hash_original_field = "18200E5D7C3839693F00E5A4D3DAD0B6", hash_generated_field = "CA3AB959F12DEEA21A35F58EC638730B")

    private GeocoderParams mParams;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.227 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "172E00EA90AE9807366F5CA34B42799B")

    private ILocationManager mService;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.227 -0400", hash_original_method = "14E84A4B1974BF851ED8726736E80E86", hash_generated_method = "F7D8C713FE7A48759C5FA35E4256A76D")
    public  Geocoder(Context context, Locale locale) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("locale == null");
        } 
        mParams = new GeocoderParams(context, locale);
        IBinder b = ServiceManager.getService(Context.LOCATION_SERVICE);
        mService = ILocationManager.Stub.asInterface(b);
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.228 -0400", hash_original_method = "EADDD88BF54CFB72F79FF8220981CC0D", hash_generated_method = "759C4625FD3041193E6A238A72B8718E")
    public  Geocoder(Context context) {
        this(context, Locale.getDefault());
        addTaint(context.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.229 -0400", hash_original_method = "284E75C67527B2849F40BED710ED6A66", hash_generated_method = "39A844E826B4B4A39ABDD440618F846E")
    public List<Address> getFromLocation(double latitude, double longitude, int maxResults) throws IOException {
        List<Address> varB4EAC82CA7396A68D541C85D26508E83_398081182 = null; 
        List<Address> varB4EAC82CA7396A68D541C85D26508E83_249780628 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("latitude == " + latitude);
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("longitude == " + longitude);
        } 
        try 
        {
            List<Address> results = new ArrayList<Address>();
            String ex = mService.getFromLocation(latitude, longitude, maxResults,
                mParams, results);
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException(ex);
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_398081182 = results;
            } 
        } 
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_249780628 = null;
        } 
        addTaint(latitude);
        addTaint(longitude);
        addTaint(maxResults);
        List<Address> varA7E53CE21691AB073D9660D615818899_194586334; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_194586334 = varB4EAC82CA7396A68D541C85D26508E83_398081182;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_194586334 = varB4EAC82CA7396A68D541C85D26508E83_249780628;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_194586334.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_194586334;
        
        
            
        
        
            
        
        
            
            
                
            
                
            
                
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.230 -0400", hash_original_method = "29488D3CE065C208A897F66C86CADF17", hash_generated_method = "6B0AC3084792E2CDC45C51DB2C8015D2")
    public List<Address> getFromLocationName(String locationName, int maxResults) throws IOException {
        List<Address> varB4EAC82CA7396A68D541C85D26508E83_1771931585 = null; 
        List<Address> varB4EAC82CA7396A68D541C85D26508E83_1180904654 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("locationName == null");
        } 
        try 
        {
            List<Address> results = new ArrayList<Address>();
            String ex = mService.getFromLocationName(locationName,
                0, 0, 0, 0, maxResults, mParams, results);
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException(ex);
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1771931585 = results;
            } 
        } 
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1180904654 = null;
        } 
        addTaint(locationName.getTaint());
        addTaint(maxResults);
        List<Address> varA7E53CE21691AB073D9660D615818899_343399417; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_343399417 = varB4EAC82CA7396A68D541C85D26508E83_1771931585;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_343399417 = varB4EAC82CA7396A68D541C85D26508E83_1180904654;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_343399417.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_343399417;
        
        
            
        
        
            
            
                
            
                
            
                
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.231 -0400", hash_original_method = "13307F87291B7F7130BBF7F095A5BF05", hash_generated_method = "25734B641C62E8572482B0A0759D7060")
    public List<Address> getFromLocationName(String locationName, int maxResults,
        double lowerLeftLatitude, double lowerLeftLongitude,
        double upperRightLatitude, double upperRightLongitude) throws IOException {
        List<Address> varB4EAC82CA7396A68D541C85D26508E83_661933555 = null; 
        List<Address> varB4EAC82CA7396A68D541C85D26508E83_970816127 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("locationName == null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("lowerLeftLatitude == "
                + lowerLeftLatitude);
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("lowerLeftLongitude == "
                + lowerLeftLongitude);
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("upperRightLatitude == "
                + upperRightLatitude);
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("upperRightLongitude == "
                + upperRightLongitude);
        } 
        try 
        {
            ArrayList<Address> result = new ArrayList<Address>();
            String ex = mService.getFromLocationName(locationName,
                lowerLeftLatitude, lowerLeftLongitude, upperRightLatitude, upperRightLongitude,
                maxResults, mParams, result);
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException(ex);
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_661933555 = result;
            } 
        } 
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_970816127 = null;
        } 
        addTaint(locationName.getTaint());
        addTaint(maxResults);
        addTaint(lowerLeftLatitude);
        addTaint(lowerLeftLongitude);
        addTaint(upperRightLatitude);
        addTaint(upperRightLongitude);
        List<Address> varA7E53CE21691AB073D9660D615818899_1627199311; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1627199311 = varB4EAC82CA7396A68D541C85D26508E83_661933555;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1627199311 = varB4EAC82CA7396A68D541C85D26508E83_970816127;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1627199311.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1627199311;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.232 -0400", hash_original_field = "2F13D28EF33AD881D6EF6A469D590D1B", hash_generated_field = "B31A436DE52E80FF02F1461C2CF60861")

    private static final String TAG = "Geocoder";
}

