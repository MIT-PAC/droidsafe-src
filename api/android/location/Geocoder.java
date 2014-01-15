package android.location;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;

public final class Geocoder {

    /**
     * Returns true if the Geocoder methods getFromLocation and
     * getFromLocationName are implemented.  Lack of network
     * connectivity may still cause these methods to return null or
     * empty lists.
     */
    @DSComment("Utility function")
    @DSSafe(DSCat.UTIL_FUNCTION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.059 -0500", hash_original_method = "C5EE9D72EF131FEA950520687E6D432D", hash_generated_method = "4D141F4B433F72F4C5A0AF9C4C4E06BB")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.052 -0500", hash_original_field = "072F1A4A3EFACF2B6A18C72A3A81468A", hash_generated_field = "B31A436DE52E80FF02F1461C2CF60861")

    private static final String TAG = "Geocoder";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.054 -0500", hash_original_field = "B22824C6E906376A8FECCCCBCF30506F", hash_generated_field = "CA3AB959F12DEEA21A35F58EC638730B")

    private GeocoderParams mParams;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.056 -0500", hash_original_field = "50ECBA7D5C5287025A532B86729D1152", hash_generated_field = "172E00EA90AE9807366F5CA34B42799B")

    private ILocationManager mService;

    /**
     * Constructs a Geocoder whose responses will be localized for the
     * given Locale.
     *
     * @param context the Context of the calling Activity
     * @param locale the desired Locale for the query results
     *
     * @throws NullPointerException if Locale is null
     */
    @DSComment("Utility function")
    @DSSafe(DSCat.UTIL_FUNCTION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.063 -0500", hash_original_method = "14E84A4B1974BF851ED8726736E80E86", hash_generated_method = "1C36BBE9907E4DB6EC9677D2355EAD8B")
    
public Geocoder(Context context, Locale locale) {
        if (locale == null) {
            throw new NullPointerException("locale == null");
        }
        mParams = new GeocoderParams(context, locale);
        IBinder b = ServiceManager.getService(Context.LOCATION_SERVICE);
        mService = ILocationManager.Stub.asInterface(b);
    }

    /**
     * Constructs a Geocoder whose responses will be localized for the
     * default system Locale.
     *
     * @param context the Context of the calling Activity
     */
    @DSComment("Utility function")
    @DSSafe(DSCat.UTIL_FUNCTION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.065 -0500", hash_original_method = "EADDD88BF54CFB72F79FF8220981CC0D", hash_generated_method = "28778F0E116D3FCD4F6F5F892496788F")
    
public Geocoder(Context context) {
        this(context, Locale.getDefault());
    }

    /**
     * Returns an array of Addresses that are known to describe the
     * area immediately surrounding the given latitude and longitude.
     * The returned addresses will be localized for the locale
     * provided to this class's constructor.
     *
     * <p> The returned values may be obtained by means of a network lookup.
     * The results are a best guess and are not guaranteed to be meaningful or
     * correct. It may be useful to call this method from a thread separate from your
     * primary UI thread.
     *
     * @param latitude the latitude a point for the search
     * @param longitude the longitude a point for the search
     * @param maxResults max number of addresses to return. Smaller numbers (1 to 5) are recommended
     *
     * @return a list of Address objects. Returns null or empty list if no matches were
     * found or there is no backend service available.
     *
     * @throws IllegalArgumentException if latitude is
     * less than -90 or greater than 90
     * @throws IllegalArgumentException if longitude is
     * less than -180 or greater than 180
     * @throws IOException if the network is unavailable or any other
     * I/O problem occurs
     */
    @DSComment("Utility function")
    @DSSafe(DSCat.UTIL_FUNCTION)
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.068 -0500", hash_original_method = "284E75C67527B2849F40BED710ED6A66", hash_generated_method = "457A8E4836C67CBA625FDDB93C2539DD")
    
public List<Address> getFromLocation(double latitude, double longitude, int maxResults)
        throws IOException {
        if (latitude < -90.0 || latitude > 90.0) {
            throw new IllegalArgumentException("latitude == " + latitude);
        }
        if (longitude < -180.0 || longitude > 180.0) {
            throw new IllegalArgumentException("longitude == " + longitude);
        }
        try {
            List<Address> results = new ArrayList<Address>();
            String ex =  mService.getFromLocation(latitude, longitude, maxResults,
                mParams, results);
            if (ex != null) {
                throw new IOException(ex);
            } else {
                return results;
            }
        } catch (RemoteException e) {
            Log.e(TAG, "getFromLocation: got RemoteException", e);
            return null;
        }
    }

    /**
     * Returns an array of Addresses that are known to describe the
     * named location, which may be a place name such as "Dalvik,
     * Iceland", an address such as "1600 Amphitheatre Parkway,
     * Mountain View, CA", an airport code such as "SFO", etc..  The
     * returned addresses will be localized for the locale provided to
     * this class's constructor.
     *
     * <p> The query will block and returned values will be obtained by means of a network lookup.
     * The results are a best guess and are not guaranteed to be meaningful or
     * correct. It may be useful to call this method from a thread separate from your
     * primary UI thread.
     *
     * @param locationName a user-supplied description of a location
     * @param maxResults max number of results to return. Smaller numbers (1 to 5) are recommended
     *
     * @return a list of Address objects. Returns null or empty list if no matches were
     * found or there is no backend service available.
     *
     * @throws IllegalArgumentException if locationName is null
     * @throws IOException if the network is unavailable or any other
     * I/O problem occurs
     */
    @DSComment("Utility function")
    @DSSafe(DSCat.UTIL_FUNCTION)
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.070 -0500", hash_original_method = "29488D3CE065C208A897F66C86CADF17", hash_generated_method = "6C17B046873F8D38E071B5695D8A1BD9")
    
public List<Address> getFromLocationName(String locationName, int maxResults) throws IOException {
        if (locationName == null) {
            throw new IllegalArgumentException("locationName == null");
        }
        try {
            List<Address> results = new ArrayList<Address>();
            String ex = mService.getFromLocationName(locationName,
                0, 0, 0, 0, maxResults, mParams, results);
            if (ex != null) {
                throw new IOException(ex);
            } else {
                return results;
            }
        } catch (RemoteException e) {
            Log.e(TAG, "getFromLocationName: got RemoteException", e);
            return null;
        }
    }

    /**
     * Returns an array of Addresses that are known to describe the
     * named location, which may be a place name such as "Dalvik,
     * Iceland", an address such as "1600 Amphitheatre Parkway,
     * Mountain View, CA", an airport code such as "SFO", etc..  The
     * returned addresses will be localized for the locale provided to
     * this class's constructor.
     *
     * <p> You may specify a bounding box for the search results by including
     * the Latitude and Longitude of the Lower Left point and Upper Right
     * point of the box.
     *
     * <p> The query will block and returned values will be obtained by means of a network lookup.
     * The results are a best guess and are not guaranteed to be meaningful or
     * correct. It may be useful to call this method from a thread separate from your
     * primary UI thread.
     *
     * @param locationName a user-supplied description of a location
     * @param maxResults max number of addresses to return. Smaller numbers (1 to 5) are recommended
     * @param lowerLeftLatitude the latitude of the lower left corner of the bounding box
     * @param lowerLeftLongitude the longitude of the lower left corner of the bounding box
     * @param upperRightLatitude the latitude of the upper right corner of the bounding box
     * @param upperRightLongitude the longitude of the upper right corner of the bounding box
     *
     * @return a list of Address objects. Returns null or empty list if no matches were
     * found or there is no backend service available.
     *
     * @throws IllegalArgumentException if locationName is null
     * @throws IllegalArgumentException if any latitude is
     * less than -90 or greater than 90
     * @throws IllegalArgumentException if any longitude is
     * less than -180 or greater than 180
     * @throws IOException if the network is unavailable or any other
     * I/O problem occurs
     */
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.073 -0500", hash_original_method = "13307F87291B7F7130BBF7F095A5BF05", hash_generated_method = "0B1DBFCDA45AB3795CE5CC65B4E634BC")
    
public List<Address> getFromLocationName(String locationName, int maxResults,
        double lowerLeftLatitude, double lowerLeftLongitude,
        double upperRightLatitude, double upperRightLongitude) throws IOException {
        if (locationName == null) {
            throw new IllegalArgumentException("locationName == null");
        }
        if (lowerLeftLatitude < -90.0 || lowerLeftLatitude > 90.0) {
            throw new IllegalArgumentException("lowerLeftLatitude == "
                + lowerLeftLatitude);
        }
        if (lowerLeftLongitude < -180.0 || lowerLeftLongitude > 180.0) {
            throw new IllegalArgumentException("lowerLeftLongitude == "
                + lowerLeftLongitude);
        }
        if (upperRightLatitude < -90.0 || upperRightLatitude > 90.0) {
            throw new IllegalArgumentException("upperRightLatitude == "
                + upperRightLatitude);
        }
        if (upperRightLongitude < -180.0 || upperRightLongitude > 180.0) {
            throw new IllegalArgumentException("upperRightLongitude == "
                + upperRightLongitude);
        }
        try {
            ArrayList<Address> result = new ArrayList<Address>();
            String ex =  mService.getFromLocationName(locationName,
                lowerLeftLatitude, lowerLeftLongitude, upperRightLatitude, upperRightLongitude,
                maxResults, mParams, result);
            if (ex != null) {
                throw new IOException(ex);
            } else {
                return result;
            }
        } catch (RemoteException e) {
            Log.e(TAG, "getFromLocationName: got RemoteException", e);
            return null;
        }
    }
}

