package android.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;

import com.android.internal.telephony.ITelephony;
import com.android.internal.telephony.Phone;

public abstract class CellLocation {

    /**
     * Request an update of the current location.  If the location has changed,
     * a broadcast will be sent to everyone registered with {@link
     * PhoneStateListener#LISTEN_CELL_LOCATION}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:44.141 -0500", hash_original_method = "931895DA09A99015508BB8A6358CBC6B", hash_generated_method = "7A9F043FC5A0D235F1752142FB0D628C")
    
public static void requestLocationUpdate() {
        try {
            ITelephony phone = ITelephony.Stub.asInterface(ServiceManager.getService("phone"));
            if (phone != null) {
                phone.updateServiceLocation();
            }
        } catch (RemoteException ex) {
            // ignore it
        }
    }

    /**
     * Create a new CellLocation from a intent notifier Bundle
     *
     * This method is used by PhoneStateIntentReceiver and maybe by
     * external applications.
     *
     * @param bundle Bundle from intent notifier
     * @return newly created CellLocation
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:44.149 -0500", hash_original_method = "1C17C109B5D9308B1DACC8FC25DADB84", hash_generated_method = "9302334CF07696D94D9799FE13FA270D")
    
public static CellLocation newFromBundle(Bundle bundle) {
        // TelephonyManager.getDefault().getCurrentPhoneType() handles the case when
        // ITelephony interface is not up yet.
        switch(TelephonyManager.getDefault().getCurrentPhoneType()) {
        case Phone.PHONE_TYPE_CDMA:
            return new CdmaCellLocation(bundle);
        case Phone.PHONE_TYPE_GSM:
            return new GsmCellLocation(bundle);
        default:
            return null;
        }
    }

    /**
     * Return a new CellLocation object representing an unknown
     * location, or null for unknown/none phone radio types.
     *
     */
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:44.170 -0500", hash_original_method = "772CDA5B255ED5AFC7BB2F44019BFECD", hash_generated_method = "211FE06CF4C76A637818F279C819EF77")
    
public static CellLocation getEmpty() {
        // TelephonyManager.getDefault().getCurrentPhoneType() handles the case when
        // ITelephony interface is not up yet.
        switch(TelephonyManager.getDefault().getCurrentPhoneType()) {
        case Phone.PHONE_TYPE_CDMA:
            return new CdmaCellLocation();
        case Phone.PHONE_TYPE_GSM:
            return new GsmCellLocation();
        default:
            return null;
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.070 -0400", hash_original_method = "18EEA113758CA529F35B4B776EC100D9", hash_generated_method = "18EEA113758CA529F35B4B776EC100D9")
    public CellLocation ()
    {
        //Synthesized constructor
    }

    /**
     * @hide
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:44.156 -0500", hash_original_method = "345CB571362C5D7AE1D7BE61B15A2338", hash_generated_method = "BF357EC13D8004B791ED6EB37C53D9B6")
    
public abstract void fillInNotifierBundle(Bundle bundle);

    /**
     * @hide
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:44.162 -0500", hash_original_method = "9B1CCC3AB82A9C7B7A46C788921405FB", hash_generated_method = "047840219A293BF58358C9060BC573A9")
    
public abstract boolean isEmpty();
    
}

