package com.android.internal.telephony.cdma;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Message;
import android.util.Log;
import com.android.internal.telephony.DataConnection;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.RILConstants;
import com.android.internal.telephony.RetryManager;

public class CdmaDataConnection extends DataConnection {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.599 -0400", hash_original_method = "90BEBC84F90039055B8CE59477380674", hash_generated_method = "CFCAA3A7DAB097D73558B18A0E89B29E")
    private  CdmaDataConnection(CDMAPhone phone, String name, int id, RetryManager rm) {
        super(phone, name, id, rm);
        addTaint(phone.getTaint());
        addTaint(name.getTaint());
        addTaint(id);
        addTaint(rm.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.600 -0400", hash_original_method = "1E0A08AF35615E9E10187C3143DD41F0", hash_generated_method = "84A53D7B5BE67DE7414D191D806C3F4E")
    @Override
    protected void onConnect(ConnectionParams cp) {
        
        log("CdmaDataConnection Connecting...");
        mApn = cp.apn;
        createTime = -1;
        lastFailTime = -1;
        lastFailCause = FailCause.NONE;
        int dataProfile;
        {
            boolean var74177C9596C4964B7FDF6CB920D0B850_728320061 = ((cp.apn != null) && (cp.apn.types.length > 0) && (cp.apn.types[0] != null) &&
                (cp.apn.types[0].equals(Phone.APN_TYPE_DUN)));
            {
                log("CdmaDataConnection using DUN");
                dataProfile = RILConstants.DATA_PROFILE_TETHERED;
            } 
            {
                dataProfile = RILConstants.DATA_PROFILE_DEFAULT;
            } 
        } 
        Message msg = obtainMessage(EVENT_SETUP_DATA_CONNECTION_DONE, cp);
        msg.obj = cp;
        phone.mCM.setupDataCall(
                Integer.toString(getRadioTechnology(RILConstants.SETUP_DATA_TECH_CDMA)),
                Integer.toString(dataProfile),
                null, null, null,
                Integer.toString(RILConstants.SETUP_DATA_AUTH_PAP_CHAP),
                RILConstants.SETUP_DATA_PROTOCOL_IP, msg);
        addTaint(cp.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.601 -0400", hash_original_method = "3581014A48A474B85EE6C8602B0DDEFE", hash_generated_method = "DE60BEA7247E69636EBADEDAFF6060DC")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1407137396 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1407137396 = "State=" + getCurrentState().getName() + " create=" + createTime + " lastFail="
                + lastFailTime + " lastFasilCause=" + lastFailCause;
        varB4EAC82CA7396A68D541C85D26508E83_1407137396.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1407137396;
        
        
                
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.601 -0400", hash_original_method = "78F02BF6B20F01750FE4BD6062BC9879", hash_generated_method = "183655E9843957C294A97508140858FF")
    @Override
    protected boolean isDnsOk(String[] domainNameServers) {
        {
            boolean var8C06B76FEAE693BB0F1D1CC645E9B66E_51951519 = (NULL_IP.equals(domainNameServers[0])
                && NULL_IP.equals(domainNameServers[1])
                && !phone.isDnsCheckDisabled());
        } 
        addTaint(domainNameServers[0].getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_127054245 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_127054245;
        
        
                
                
            
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.602 -0400", hash_original_method = "E3E03901000B497B61536E572BF51316", hash_generated_method = "EB8C75A46F3714E41BD20C8651699298")
    @Override
    protected void log(String s) {
        Log.d(LOG_TAG, "[" + getName() + "] " + s);
        addTaint(s.getTaint());
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.602 -0400", hash_original_field = "951C150E6D062E6AED2C45BB9B756185", hash_generated_field = "1718F4DE7305211326235C8400C02ED3")

    private static final String LOG_TAG = "CDMA";
}

