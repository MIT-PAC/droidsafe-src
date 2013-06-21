package android.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.351 -0400", hash_original_method = "623DB351F111CAAADBC7A0AEE07D47FE", hash_generated_method = "623DB351F111CAAADBC7A0AEE07D47FE")
        public CellLocation ()
    {
    }


        public static void requestLocationUpdate() {
        try {
            ITelephony phone = ITelephony.Stub.asInterface(ServiceManager.getService("phone"));
            if (phone != null) {
                phone.updateServiceLocation();
            }
        } catch (RemoteException ex) {
        }
    }

    
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

