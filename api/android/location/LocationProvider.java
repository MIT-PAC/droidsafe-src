package android.location;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import android.os.RemoteException;

public abstract class LocationProvider {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:00.735 -0500", hash_original_field = "CF63F24A50923DD5411A549B84491C0D", hash_generated_field = "E0555379B6CF7BCD06CEE07CE9475600")

    private static final String TAG = "LocationProvider";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:00.737 -0500", hash_original_field = "5A8A2BC29ADD7231D4F8082284CDE420", hash_generated_field = "2285A116D71E82D421B711A507630688")

    // in the name of a LocationProvider.
    static final String BAD_CHARS_REGEX = "[^a-zA-Z0-9]";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:00.744 -0500", hash_original_field = "C2D975D4DBF3A4FF5769108DF24F37FC", hash_generated_field = "7F47E89ED92EB0041561E3E6FDFC0CA8")

    public static final int OUT_OF_SERVICE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:00.747 -0500", hash_original_field = "4A005E03634811A2A302FB3758AEAF29", hash_generated_field = "8FC12DE1A6F66422CA33C5DF3A2CD280")

    public static final int TEMPORARILY_UNAVAILABLE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:00.749 -0500", hash_original_field = "57D8A1AD57A6FAF8530900DAD575BC33", hash_generated_field = "299301506C5B5A1C60298C6C87349C6B")

    public static final int AVAILABLE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:00.739 -0500", hash_original_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

    private  String mName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:00.742 -0500", hash_original_field = "50ECBA7D5C5287025A532B86729D1152", hash_generated_field = "172E00EA90AE9807366F5CA34B42799B")

    private  ILocationManager mService;

    /**
     * Constructs a LocationProvider with the given name.   Provider names must
     * consist only of the characters [a-zA-Z0-9].
     *
     * @throws IllegalArgumentException if name contains an illegal character
     *
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:00.752 -0500", hash_original_method = "BAF0DB5834B7193F7ED3616F680059B0", hash_generated_method = "19BAC5EF4201D5273FDC1C507FBAEDFA")
    
public LocationProvider(String name, ILocationManager service) {
        if (name.matches(BAD_CHARS_REGEX)) {
            throw new IllegalArgumentException("name " + name +
                " contains an illegal character");
        }
        mName = name;
        mService = service;
    }

    /**
     * Returns the name of this provider.
     */
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:00.754 -0500", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "AD920925278DEAFAFBD283F9C2E39E5D")
    
public String getName() {
        return mName;
    }

    /**
     * Returns true if this provider meets the given criteria,
     * false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:00.757 -0500", hash_original_method = "635BF1E9CDC5B7DBCFDF1ACD3F6E624D", hash_generated_method = "E2BD4ED9428DD276E1AE77C23DC905E3")
    
public boolean meetsCriteria(Criteria criteria) {
        try {
            return mService.providerMeetsCriteria(mName, criteria);
        } catch (RemoteException e) {
            Log.e(TAG, "meetsCriteria: RemoteException", e);
            return false;
        }
    }

    /**
     * Returns true if the provider requires access to a
     * data network (e.g., the Internet), false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:00.759 -0500", hash_original_method = "C991F65DC5DEF0243F48DDC29B664431", hash_generated_method = "6EE0D775B20E6884DC2712A90B23195B")
    
public abstract boolean requiresNetwork();

    /**
     * Returns true if the provider requires access to a
     * satellite-based positioning system (e.g., GPS), false
     * otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:00.761 -0500", hash_original_method = "366017BB8C58181868D32947274C7BC7", hash_generated_method = "F7621CAD0178AAA1D61AE710E32A211C")
    
public abstract boolean requiresSatellite();

    /**
     * Returns true if the provider requires access to an appropriate
     * cellular network (e.g., to make use of cell tower IDs), false
     * otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:00.763 -0500", hash_original_method = "F6873F536EAE3AC70229B04378E6EEC8", hash_generated_method = "E8F1616BA288FA767C1A755C27079287")
    
public abstract boolean requiresCell();

    /**
     * Returns true if the use of this provider may result in a
     * monetary charge to the user, false if use is free.  It is up to
     * each provider to give accurate information.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:00.765 -0500", hash_original_method = "CFBD5CD0BF0CEBDC729EBCFAF691D465", hash_generated_method = "644AEA863785DD307221F32DBA4D32B2")
    
public abstract boolean hasMonetaryCost();

    /**
     * Returns true if the provider is able to provide altitude
     * information, false otherwise.  A provider that reports altitude
     * under most circumstances but may occassionally not report it
     * should return true.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:00.767 -0500", hash_original_method = "55DEE25283169E9A5D4800DBA4BDB841", hash_generated_method = "F797EC496563E6D155DB3B6A066DDD33")
    
public abstract boolean supportsAltitude();

    /**
     * Returns true if the provider is able to provide speed
     * information, false otherwise.  A provider that reports speed
     * under most circumstances but may occassionally not report it
     * should return true.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:00.770 -0500", hash_original_method = "5B5F31FFA599FC91D5138C125D59C200", hash_generated_method = "A4DF7333959724A8F1BAED0345DE40C5")
    
public abstract boolean supportsSpeed();

    /**
     * Returns true if the provider is able to provide bearing
     * information, false otherwise.  A provider that reports bearing
     * under most circumstances but may occassionally not report it
     * should return true.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:00.772 -0500", hash_original_method = "658D3CCD5832B63C0257E88968EB6E43", hash_generated_method = "A8D064CCA76BA74701B7E4E7219A97BF")
    
public abstract boolean supportsBearing();

    /**
     * Returns the power requirement for this provider.
     *
     * @return the power requirement for this provider, as one of the
     * constants Criteria.POWER_REQUIREMENT_*.
     */
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:00.774 -0500", hash_original_method = "2F50AAAB2647BF8230ECBEB434938FE5", hash_generated_method = "34DD62495694D40DE49D2D104CB0D3B2")
    
public abstract int getPowerRequirement();

    /**
     * Returns a constant describing horizontal accuracy of this provider.
     * If the provider returns finer grain or exact location,
     * {@link Criteria#ACCURACY_FINE} is returned, otherwise if the
     * location is only approximate then {@link Criteria#ACCURACY_COARSE}
     * is returned.
     */
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:00.776 -0500", hash_original_method = "DF70590EBA658BF9F5EE889268264DFA", hash_generated_method = "CD4BE7A1C5BB4B32874B2664C730697D")
    
public abstract int getAccuracy();
}

