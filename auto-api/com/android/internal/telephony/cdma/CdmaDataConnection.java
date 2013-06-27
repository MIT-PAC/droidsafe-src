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
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.RILConstants;
import com.android.internal.telephony.RetryManager;

public class CdmaDataConnection extends DataConnection {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.138 -0400", hash_original_method = "90BEBC84F90039055B8CE59477380674", hash_generated_method = "CFCAA3A7DAB097D73558B18A0E89B29E")
    private  CdmaDataConnection(CDMAPhone phone, String name, int id, RetryManager rm) {
        super(phone, name, id, rm);
        addTaint(phone.getTaint());
        addTaint(name.getTaint());
        addTaint(id);
        addTaint(rm.getTaint());
        // ---------- Original Method ----------
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.139 -0400", hash_original_method = "1E0A08AF35615E9E10187C3143DD41F0", hash_generated_method = "04A0624D8077E5F14A22EBAC6BFE7547")
    @Override
    protected void onConnect(ConnectionParams cp) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        log("CdmaDataConnection Connecting...");
        mApn = cp.apn;
        createTime = -1;
        lastFailTime = -1;
        lastFailCause = FailCause.NONE;
        int dataProfile;
        {
            boolean var74177C9596C4964B7FDF6CB920D0B850_17815874 = ((cp.apn != null) && (cp.apn.types.length > 0) && (cp.apn.types[0] != null) &&
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
        addTaint(cp.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.140 -0400", hash_original_method = "3581014A48A474B85EE6C8602B0DDEFE", hash_generated_method = "FCDD70B57A3D3CBEB8FD846D3A22E049")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_755161432 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_755161432 = "State=" + getCurrentState().getName() + " create=" + createTime + " lastFail="
                + lastFailTime + " lastFasilCause=" + lastFailCause;
        varB4EAC82CA7396A68D541C85D26508E83_755161432.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_755161432;
        // ---------- Original Method ----------
        //return "State=" + getCurrentState().getName() + " create=" + createTime + " lastFail="
                //+ lastFailTime + " lastFasilCause=" + lastFailCause;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.152 -0400", hash_original_method = "78F02BF6B20F01750FE4BD6062BC9879", hash_generated_method = "D9D6F0E16CE89263276A2A103C9BB8DB")
    @Override
    protected boolean isDnsOk(String[] domainNameServers) {
        {
            boolean var8C06B76FEAE693BB0F1D1CC645E9B66E_1212466186 = (NULL_IP.equals(domainNameServers[0])
                && NULL_IP.equals(domainNameServers[1])
                && !phone.isDnsCheckDisabled());
        } //End collapsed parenthetic
        addTaint(domainNameServers[0].getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_749255986 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_749255986;
        // ---------- Original Method ----------
        //if (NULL_IP.equals(domainNameServers[0])
                //&& NULL_IP.equals(domainNameServers[1])
                //&& !phone.isDnsCheckDisabled()) {
            //return false;
        //} else {
            //return true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.155 -0400", hash_original_method = "E3E03901000B497B61536E572BF51316", hash_generated_method = "EB8C75A46F3714E41BD20C8651699298")
    @Override
    protected void log(String s) {
        Log.d(LOG_TAG, "[" + getName() + "] " + s);
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[" + getName() + "] " + s);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.155 -0400", hash_original_field = "951C150E6D062E6AED2C45BB9B756185", hash_generated_field = "3180393FBDFF3695C5B6689D6A3679D8")

    private static String LOG_TAG = "CDMA";
}

