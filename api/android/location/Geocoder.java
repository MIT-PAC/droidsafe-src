package android.location;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.735 -0400", hash_original_field = "18200E5D7C3839693F00E5A4D3DAD0B6", hash_generated_field = "CA3AB959F12DEEA21A35F58EC638730B")

    private GeocoderParams mParams;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.735 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "172E00EA90AE9807366F5CA34B42799B")

    private ILocationManager mService;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.735 -0400", hash_original_method = "14E84A4B1974BF851ED8726736E80E86", hash_generated_method = "39F7FB854D3C4495473B55B227DA3E55")
    public  Geocoder(Context context, Locale locale) {
    if(locale == null)        
        {
            NullPointerException var3F3F6EF29B25D30496E9F54071267749_1807976631 = new NullPointerException("locale == null");
            var3F3F6EF29B25D30496E9F54071267749_1807976631.addTaint(taint);
            throw var3F3F6EF29B25D30496E9F54071267749_1807976631;
        } 
        mParams = new GeocoderParams(context, locale);
        IBinder b = ServiceManager.getService(Context.LOCATION_SERVICE);
        mService = ILocationManager.Stub.asInterface(b);
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.736 -0400", hash_original_method = "EADDD88BF54CFB72F79FF8220981CC0D", hash_generated_method = "759C4625FD3041193E6A238A72B8718E")
    public  Geocoder(Context context) {
        this(context, Locale.getDefault());
        addTaint(context.getTaint());
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.737 -0400", hash_original_method = "284E75C67527B2849F40BED710ED6A66", hash_generated_method = "F2F587FA0FC22CC98941B55380269B9A")
    public List<Address> getFromLocation(double latitude, double longitude, int maxResults) throws IOException {
        addTaint(maxResults);
        addTaint(longitude);
        addTaint(latitude);
    if(latitude < -90.0 || latitude > 90.0)        
        {
            IllegalArgumentException var5CDB5E8BE2780A449DF91F3598B8F033_1523449452 = new IllegalArgumentException("latitude == " + latitude);
            var5CDB5E8BE2780A449DF91F3598B8F033_1523449452.addTaint(taint);
            throw var5CDB5E8BE2780A449DF91F3598B8F033_1523449452;
        } 
    if(longitude < -180.0 || longitude > 180.0)        
        {
            IllegalArgumentException var7C246BAC6A5717BCB23B4212A47C4761_1553668954 = new IllegalArgumentException("longitude == " + longitude);
            var7C246BAC6A5717BCB23B4212A47C4761_1553668954.addTaint(taint);
            throw var7C246BAC6A5717BCB23B4212A47C4761_1553668954;
        } 
        try 
        {
            List<Address> results = new ArrayList<Address>();
            String ex = mService.getFromLocation(latitude, longitude, maxResults,
                mParams, results);
    if(ex != null)            
            {
                IOException var8B943AA6A4D3283BFEECC199C0F539AA_534911420 = new IOException(ex);
                var8B943AA6A4D3283BFEECC199C0F539AA_534911420.addTaint(taint);
                throw var8B943AA6A4D3283BFEECC199C0F539AA_534911420;
            } 
            else
            {
List<Address> var238ECCC9872FFCA0B3C3DB83598FF044_1339643945 =                 results;
                var238ECCC9872FFCA0B3C3DB83598FF044_1339643945.addTaint(taint);
                return var238ECCC9872FFCA0B3C3DB83598FF044_1339643945;
            } 
        } 
        catch (RemoteException e)
        {
List<Address> var540C13E9E156B687226421B24F2DF178_646930000 =             null;
            var540C13E9E156B687226421B24F2DF178_646930000.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_646930000;
        } 
        
        
            
        
        
            
        
        
            
            
                
            
                
            
                
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.737 -0400", hash_original_method = "29488D3CE065C208A897F66C86CADF17", hash_generated_method = "9EEEF41EDA13695112734400CF6107D1")
    public List<Address> getFromLocationName(String locationName, int maxResults) throws IOException {
        addTaint(maxResults);
        addTaint(locationName.getTaint());
    if(locationName == null)        
        {
            IllegalArgumentException var798B9480099C940248D3D5C9994F9EF0_1822470075 = new IllegalArgumentException("locationName == null");
            var798B9480099C940248D3D5C9994F9EF0_1822470075.addTaint(taint);
            throw var798B9480099C940248D3D5C9994F9EF0_1822470075;
        } 
        try 
        {
            List<Address> results = new ArrayList<Address>();
            String ex = mService.getFromLocationName(locationName,
                0, 0, 0, 0, maxResults, mParams, results);
    if(ex != null)            
            {
                IOException var8B943AA6A4D3283BFEECC199C0F539AA_1874494245 = new IOException(ex);
                var8B943AA6A4D3283BFEECC199C0F539AA_1874494245.addTaint(taint);
                throw var8B943AA6A4D3283BFEECC199C0F539AA_1874494245;
            } 
            else
            {
List<Address> var238ECCC9872FFCA0B3C3DB83598FF044_6251130 =                 results;
                var238ECCC9872FFCA0B3C3DB83598FF044_6251130.addTaint(taint);
                return var238ECCC9872FFCA0B3C3DB83598FF044_6251130;
            } 
        } 
        catch (RemoteException e)
        {
List<Address> var540C13E9E156B687226421B24F2DF178_1064467752 =             null;
            var540C13E9E156B687226421B24F2DF178_1064467752.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1064467752;
        } 
        
        
            
        
        
            
            
                
            
                
            
                
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.739 -0400", hash_original_method = "13307F87291B7F7130BBF7F095A5BF05", hash_generated_method = "C53FE163CB2E51C2F13E9445F605C768")
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
            IllegalArgumentException var798B9480099C940248D3D5C9994F9EF0_1082302215 = new IllegalArgumentException("locationName == null");
            var798B9480099C940248D3D5C9994F9EF0_1082302215.addTaint(taint);
            throw var798B9480099C940248D3D5C9994F9EF0_1082302215;
        } 
    if(lowerLeftLatitude < -90.0 || lowerLeftLatitude > 90.0)        
        {
            IllegalArgumentException varDC5BD51928E1A02BC95178BCDAB3A8A9_1941677360 = new IllegalArgumentException("lowerLeftLatitude == "
                + lowerLeftLatitude);
            varDC5BD51928E1A02BC95178BCDAB3A8A9_1941677360.addTaint(taint);
            throw varDC5BD51928E1A02BC95178BCDAB3A8A9_1941677360;
        } 
    if(lowerLeftLongitude < -180.0 || lowerLeftLongitude > 180.0)        
        {
            IllegalArgumentException var53D4CADC41B8EE441D510B1810C29475_377335922 = new IllegalArgumentException("lowerLeftLongitude == "
                + lowerLeftLongitude);
            var53D4CADC41B8EE441D510B1810C29475_377335922.addTaint(taint);
            throw var53D4CADC41B8EE441D510B1810C29475_377335922;
        } 
    if(upperRightLatitude < -90.0 || upperRightLatitude > 90.0)        
        {
            IllegalArgumentException varC4B8A31C00CEFDBFF48C811CEE2B644F_478270708 = new IllegalArgumentException("upperRightLatitude == "
                + upperRightLatitude);
            varC4B8A31C00CEFDBFF48C811CEE2B644F_478270708.addTaint(taint);
            throw varC4B8A31C00CEFDBFF48C811CEE2B644F_478270708;
        } 
    if(upperRightLongitude < -180.0 || upperRightLongitude > 180.0)        
        {
            IllegalArgumentException var5FAB725CCE17B470073F2D50AE0545C8_599382342 = new IllegalArgumentException("upperRightLongitude == "
                + upperRightLongitude);
            var5FAB725CCE17B470073F2D50AE0545C8_599382342.addTaint(taint);
            throw var5FAB725CCE17B470073F2D50AE0545C8_599382342;
        } 
        try 
        {
            ArrayList<Address> result = new ArrayList<Address>();
            String ex = mService.getFromLocationName(locationName,
                lowerLeftLatitude, lowerLeftLongitude, upperRightLatitude, upperRightLongitude,
                maxResults, mParams, result);
    if(ex != null)            
            {
                IOException var8B943AA6A4D3283BFEECC199C0F539AA_523494421 = new IOException(ex);
                var8B943AA6A4D3283BFEECC199C0F539AA_523494421.addTaint(taint);
                throw var8B943AA6A4D3283BFEECC199C0F539AA_523494421;
            } 
            else
            {
List<Address> varDC838461EE2FA0CA4C9BBB70A15456B0_1881112598 =                 result;
                varDC838461EE2FA0CA4C9BBB70A15456B0_1881112598.addTaint(taint);
                return varDC838461EE2FA0CA4C9BBB70A15456B0_1881112598;
            } 
        } 
        catch (RemoteException e)
        {
List<Address> var540C13E9E156B687226421B24F2DF178_479824745 =             null;
            var540C13E9E156B687226421B24F2DF178_479824745.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_479824745;
        } 
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.739 -0400", hash_original_field = "2F13D28EF33AD881D6EF6A469D590D1B", hash_generated_field = "B31A436DE52E80FF02F1461C2CF60861")

    private static final String TAG = "Geocoder";
}

