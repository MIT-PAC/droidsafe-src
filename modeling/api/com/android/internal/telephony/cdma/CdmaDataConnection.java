package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Message;
import android.util.Log;

import com.android.internal.telephony.DataConnection;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.RILConstants;
import com.android.internal.telephony.RetryManager;

public class CdmaDataConnection extends DataConnection {

    /**
     * Create the connection object
     *
     * @param phone the Phone
     * @param id the connection id
     * @param rm the RetryManager
     * @return CdmaDataConnection that was created.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:03.481 -0500", hash_original_method = "C9A1242FF2125DF955BA0640C93EB6EB", hash_generated_method = "F589F88BC8E285568B73C1ECE9CC898C")
    
static CdmaDataConnection makeDataConnection(CDMAPhone phone, int id, RetryManager rm) {
        synchronized (mCountLock) {
            mCount += 1;
        }
        CdmaDataConnection cdmaDc = new CdmaDataConnection(phone, "CdmaDC-" + mCount,
                id, rm);
        cdmaDc.start();
        if (DBG) cdmaDc.log("Made " + cdmaDc.getName());
        return cdmaDc;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:03.475 -0500", hash_original_field = "DB10E3AE28CC9996A816C3CCD7216A83", hash_generated_field = "1718F4DE7305211326235C8400C02ED3")

    private static final String LOG_TAG = "CDMA";

    // ***** Constructor
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:03.477 -0500", hash_original_method = "90BEBC84F90039055B8CE59477380674", hash_generated_method = "947C24E53D663B3FAC672F5677F9849B")
    
private CdmaDataConnection(CDMAPhone phone, String name, int id, RetryManager rm) {
        super(phone, name, id, rm);
    }

    /**
     * Begin setting up a data connection, calls setupDataCall
     * and the ConnectionParams will be returned with the
     * EVENT_SETUP_DATA_CONNECTION_DONE AsyncResul.userObj.
     *
     * @param cp is the connection parameters
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:03.483 -0500", hash_original_method = "1E0A08AF35615E9E10187C3143DD41F0", hash_generated_method = "D2B3F704F60127F3A4CB27DBBEB3DB0F")
    
@Override
    protected void onConnect(ConnectionParams cp) {
        if (DBG) log("CdmaDataConnection Connecting...");

        mApn = cp.apn;
        createTime = -1;
        lastFailTime = -1;
        lastFailCause = FailCause.NONE;
        int dataProfile;
        if ((cp.apn != null) && (cp.apn.types.length > 0) && (cp.apn.types[0] != null) &&
                (cp.apn.types[0].equals(Phone.APN_TYPE_DUN))) {
            if (DBG) log("CdmaDataConnection using DUN");
            dataProfile = RILConstants.DATA_PROFILE_TETHERED;
        } else {
            dataProfile = RILConstants.DATA_PROFILE_DEFAULT;
        }

        // msg.obj will be returned in AsyncResult.userObj;
        Message msg = obtainMessage(EVENT_SETUP_DATA_CONNECTION_DONE, cp);
        msg.obj = cp;
        phone.mCM.setupDataCall(
                Integer.toString(getRadioTechnology(RILConstants.SETUP_DATA_TECH_CDMA)),
                Integer.toString(dataProfile),
                null, null, null,
                Integer.toString(RILConstants.SETUP_DATA_AUTH_PAP_CHAP),
                RILConstants.SETUP_DATA_PROTOCOL_IP, msg);
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:03.486 -0500", hash_original_method = "3581014A48A474B85EE6C8602B0DDEFE", hash_generated_method = "33D4CF7E24506DE6193E0AB3A35D9191")
    
@Override
    public String toString() {
        return "State=" + getCurrentState().getName() + " create=" + createTime + " lastFail="
                + lastFailTime + " lastFasilCause=" + lastFailCause;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:03.489 -0500", hash_original_method = "78F02BF6B20F01750FE4BD6062BC9879", hash_generated_method = "82906345A843F6E651C7CA63CB7770E3")
    
@Override
    protected boolean isDnsOk(String[] domainNameServers) {
        if (NULL_IP.equals(domainNameServers[0])
                && NULL_IP.equals(domainNameServers[1])
                && !phone.isDnsCheckDisabled()) {
            return false;
        } else {
            return true;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:03.491 -0500", hash_original_method = "E3E03901000B497B61536E572BF51316", hash_generated_method = "55AC2223A3FC018EA3E9CC8DDDECA33D")
    
@Override
    protected void log(String s) {
        Log.d(LOG_TAG, "[" + getName() + "] " + s);
    }
}

