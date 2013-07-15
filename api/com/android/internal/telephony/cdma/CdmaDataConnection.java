package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Message;
import android.util.Log;
import com.android.internal.telephony.DataConnection;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.RILConstants;
import com.android.internal.telephony.RetryManager;

public class CdmaDataConnection extends DataConnection {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.230 -0400", hash_original_method = "90BEBC84F90039055B8CE59477380674", hash_generated_method = "B81648F6AB419A6DCAB1BF385B0968A8")
    private  CdmaDataConnection(CDMAPhone phone, String name, int id, RetryManager rm) {
        super(phone, name, id, rm);
        addTaint(rm.getTaint());
        addTaint(id);
        addTaint(name.getTaint());
        addTaint(phone.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.232 -0400", hash_original_method = "1E0A08AF35615E9E10187C3143DD41F0", hash_generated_method = "A37F07C1ECB55EAB024A56DF4B8C713D")
    @Override
    protected void onConnect(ConnectionParams cp) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(cp.getTaint());
    if(DBG)        
        log("CdmaDataConnection Connecting...");
        mApn = cp.apn;
        createTime = -1;
        lastFailTime = -1;
        lastFailCause = FailCause.NONE;
        int dataProfile;
    if((cp.apn != null) && (cp.apn.types.length > 0) && (cp.apn.types[0] != null) &&
                (cp.apn.types[0].equals(Phone.APN_TYPE_DUN)))        
        {
    if(DBG)            
            log("CdmaDataConnection using DUN");
            dataProfile = RILConstants.DATA_PROFILE_TETHERED;
        } //End block
        else
        {
            dataProfile = RILConstants.DATA_PROFILE_DEFAULT;
        } //End block
        Message msg = obtainMessage(EVENT_SETUP_DATA_CONNECTION_DONE, cp);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.233 -0400", hash_original_method = "3581014A48A474B85EE6C8602B0DDEFE", hash_generated_method = "91F583259C7DF4B890F96568D6C73A3F")
    @Override
    public String toString() {
String var20537B75E409F43099188469A355FDC5_566342555 =         "State=" + getCurrentState().getName() + " create=" + createTime + " lastFail="
                + lastFailTime + " lastFasilCause=" + lastFailCause;
        var20537B75E409F43099188469A355FDC5_566342555.addTaint(taint);
        return var20537B75E409F43099188469A355FDC5_566342555;
        // ---------- Original Method ----------
        //return "State=" + getCurrentState().getName() + " create=" + createTime + " lastFail="
                //+ lastFailTime + " lastFasilCause=" + lastFailCause;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.233 -0400", hash_original_method = "78F02BF6B20F01750FE4BD6062BC9879", hash_generated_method = "AC3BA7280D7B268BFC1C3E6FA57CA01B")
    @Override
    protected boolean isDnsOk(String[] domainNameServers) {
        addTaint(domainNameServers[0].getTaint());
    if(NULL_IP.equals(domainNameServers[0])
                && NULL_IP.equals(domainNameServers[1])
                && !phone.isDnsCheckDisabled())        
        {
            boolean var68934A3E9455FA72420237EB05902327_816943579 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2093358971 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2093358971;
        } //End block
        else
        {
            boolean varB326B5062B2F0E69046810717534CB09_1271378489 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1431419913 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1431419913;
        } //End block
        // ---------- Original Method ----------
        //if (NULL_IP.equals(domainNameServers[0])
                //&& NULL_IP.equals(domainNameServers[1])
                //&& !phone.isDnsCheckDisabled()) {
            //return false;
        //} else {
            //return true;
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.233 -0400", hash_original_method = "E3E03901000B497B61536E572BF51316", hash_generated_method = "3D39A3641D1F679267312BB4AD7C571C")
    @Override
    protected void log(String s) {
        addTaint(s.getTaint());
        Log.d(LOG_TAG, "[" + getName() + "] " + s);
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[" + getName() + "] " + s);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.234 -0400", hash_original_field = "951C150E6D062E6AED2C45BB9B756185", hash_generated_field = "1718F4DE7305211326235C8400C02ED3")

    private static final String LOG_TAG = "CDMA";
}

