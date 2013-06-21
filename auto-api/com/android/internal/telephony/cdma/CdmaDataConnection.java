package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Message;
import android.util.Log;
import com.android.internal.telephony.DataConnection;
import com.android.internal.telephony.DataConnectionTracker;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.RILConstants;
import com.android.internal.telephony.RetryManager;

public class CdmaDataConnection extends DataConnection {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.383 -0400", hash_original_method = "F27C28FDFB283A8ADA0995D15025337B", hash_generated_method = "59886543D2258CE0293DF23B1EC04EBC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CdmaDataConnection(CDMAPhone phone, String name, int id, RetryManager rm,
            DataConnectionTracker dct) {
        super(phone, name, id, rm, dct);
        dsTaint.addTaint(id);
        dsTaint.addTaint(phone.dsTaint);
        dsTaint.addTaint(rm.dsTaint);
        dsTaint.addTaint(dct.dsTaint);
        dsTaint.addTaint(name);
        // ---------- Original Method ----------
    }

    
        static CdmaDataConnection makeDataConnection(CDMAPhone phone, int id, RetryManager rm,
            DataConnectionTracker dct) {
        synchronized (mCountLock) {
            mCount += 1;
        }
        CdmaDataConnection cdmaDc = new CdmaDataConnection(phone, "CdmaDC-" + mCount,
                id, rm, dct);
        cdmaDc.start();
        if (DBG) cdmaDc.log("Made " + cdmaDc.getName());
        return cdmaDc;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.384 -0400", hash_original_method = "1E0A08AF35615E9E10187C3143DD41F0", hash_generated_method = "3269C9B5C81C1AF5C8A4651BF314CE0B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onConnect(ConnectionParams cp) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(cp.dsTaint);
        log("CdmaDataConnection Connecting...");
        mApn = cp.apn;
        createTime = -1;
        lastFailTime = -1;
        lastFailCause = FailCause.NONE;
        int dataProfile;
        {
            boolean var74177C9596C4964B7FDF6CB920D0B850_1327697862 = ((cp.apn != null) && (cp.apn.types.length > 0) && (cp.apn.types[0] != null) &&
                (cp.apn.types[0].equals(Phone.APN_TYPE_DUN)));
            {
                log("CdmaDataConnection using DUN");
                dataProfile = RILConstants.DATA_PROFILE_TETHERED;
            } //End block
            {
                dataProfile = RILConstants.DATA_PROFILE_DEFAULT;
            } //End block
        } //End collapsed parenthetic
        Message msg;
        msg = obtainMessage(EVENT_SETUP_DATA_CONNECTION_DONE, cp);
        msg.obj = cp;
        phone.mCM.setupDataCall(
                Integer.toString(getRadioTechnology(RILConstants.SETUP_DATA_TECH_CDMA)),
                Integer.toString(dataProfile),
                null, null, null,
                Integer.toString(RILConstants.SETUP_DATA_AUTH_PAP_CHAP),
                RILConstants.SETUP_DATA_PROTOCOL_IP, msg);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.385 -0400", hash_original_method = "3581014A48A474B85EE6C8602B0DDEFE", hash_generated_method = "4EFC3FAE5A0E1CBABDC3D6325BAB75B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String var09F0BA1AE7EB600D74E5E177CB943B21_881737730 = ("State=" + getCurrentState().getName() + " create=" + createTime + " lastFail="
                + lastFailTime + " lastFasilCause=" + lastFailCause);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "State=" + getCurrentState().getName() + " create=" + createTime + " lastFail="
                //+ lastFailTime + " lastFasilCause=" + lastFailCause;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.385 -0400", hash_original_method = "78F02BF6B20F01750FE4BD6062BC9879", hash_generated_method = "4A8B74A58093B3C9D3400E25FB4A6AC6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean isDnsOk(String[] domainNameServers) {
        dsTaint.addTaint(domainNameServers[0]);
        {
            boolean var8C06B76FEAE693BB0F1D1CC645E9B66E_1669287402 = (NULL_IP.equals(domainNameServers[0])
                && NULL_IP.equals(domainNameServers[1])
                && !phone.isDnsCheckDisabled());
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (NULL_IP.equals(domainNameServers[0])
                //&& NULL_IP.equals(domainNameServers[1])
                //&& !phone.isDnsCheckDisabled()) {
            //return false;
        //} else {
            //return true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.385 -0400", hash_original_method = "E3E03901000B497B61536E572BF51316", hash_generated_method = "A7A846DA1C21C7C7BCF2BA2B51000A14")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void log(String s) {
        dsTaint.addTaint(s);
        Log.d(LOG_TAG, "[" + getName() + "] " + s);
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[" + getName() + "] " + s);
    }

    
    private static final String LOG_TAG = "CDMA";
}

