package android.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.Bundle;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.provider.Settings;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.android.internal.telephony.ITelephony;
import com.android.internal.telephony.Phone;

public abstract class CellLocation {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.444 -0400", hash_original_method = "931895DA09A99015508BB8A6358CBC6B", hash_generated_method = "8C8A6E6E4EE4CD9BF1529D85A012EBB9")
    public static void requestLocationUpdate() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        try {
            ITelephony phone = ITelephony.Stub.asInterface(ServiceManager.getService("phone"));
            if (phone != null) {
                phone.updateServiceLocation();
            }
        } catch (RemoteException ex) {
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.444 -0400", hash_original_method = "1C17C109B5D9308B1DACC8FC25DADB84", hash_generated_method = "382ED001754D5A57153B0F0F3C0C6C4B")
    public static CellLocation newFromBundle(Bundle bundle) {
        switch(TelephonyManager.getDefault().getCurrentPhoneType()) {
        case Phone.PHONE_TYPE_CDMA:
            return new CdmaCellLocation(bundle);
        case Phone.PHONE_TYPE_GSM:
            return new GsmCellLocation(bundle);
        default:
            return null;
        }
    }

    
    public abstract void fillInNotifierBundle(Bundle bundle);

    
    public abstract boolean isEmpty();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.444 -0400", hash_original_method = "772CDA5B255ED5AFC7BB2F44019BFECD", hash_generated_method = "49A7ED1A926888640C13105C6AA23EA3")
    public static CellLocation getEmpty() {
        switch(TelephonyManager.getDefault().getCurrentPhoneType()) {
        case Phone.PHONE_TYPE_CDMA:
            return new CdmaCellLocation();
        case Phone.PHONE_TYPE_GSM:
            return new GsmCellLocation();
        default:
            return null;
        }
    }

    
}


