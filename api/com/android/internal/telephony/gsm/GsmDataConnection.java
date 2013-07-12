package com.android.internal.telephony.gsm;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Message;
import android.util.Log;
import android.util.Patterns;
import android.text.TextUtils;
import com.android.internal.telephony.DataConnection;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.PhoneBase;
import com.android.internal.telephony.RILConstants;
import com.android.internal.telephony.RetryManager;

public class GsmDataConnection extends DataConnection {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.142 -0400", hash_original_field = "285E977A3F24171DCF659128908B0B5A", hash_generated_field = "4B86B7A6BB3954D8A0D6116E4CC1760F")

    protected int mProfileId = RILConstants.DATA_PROFILE_DEFAULT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.142 -0400", hash_original_field = "BEFD69DEB43D71296C7CCACD00213393", hash_generated_field = "FEA7396BF99CD16BDCDC29FABBFA8C84")

    protected String mActiveApnType = Phone.APN_TYPE_DEFAULT;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.143 -0400", hash_original_method = "D7C479FF4503363D3DB56494C7CC433A", hash_generated_method = "72FAAAEFC1DE62C211506493411F6478")
    private  GsmDataConnection(PhoneBase phone, String name, int id, RetryManager rm) {
        super(phone, name, id, rm);
        addTaint(rm.getTaint());
        addTaint(id);
        addTaint(name.getTaint());
        addTaint(phone.getTaint());
        
    }

    
        static GsmDataConnection makeDataConnection(PhoneBase phone, int id, RetryManager rm) {
        synchronized (mCountLock) {
            mCount += 1;
        }
        GsmDataConnection gsmDc = new GsmDataConnection(phone, "GsmDC-" + mCount, id, rm);
        gsmDc.start();
        if (DBG) gsmDc.log("Made " + gsmDc.getName());
        return gsmDc;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.144 -0400", hash_original_method = "B9699B49BCC7654BF74B38BF9D177791", hash_generated_method = "F6E635B2039B55317FF4BC305148AE05")
    @Override
    protected void onConnect(ConnectionParams cp) {
        
        addTaint(cp.getTaint());
        mApn = cp.apn;
    if(DBG)        
        log("Connecting to carrier: '" + mApn.carrier
                + "' APN: '" + mApn.apn
                + "' proxy: '" + mApn.proxy + "' port: '" + mApn.port);
        createTime = -1;
        lastFailTime = -1;
        lastFailCause = FailCause.NONE;
        Message msg = obtainMessage(EVENT_SETUP_DATA_CONNECTION_DONE, cp);
        msg.obj = cp;
        int authType = mApn.authType;
    if(authType == -1)        
        {
            authType = (mApn.user != null) ? RILConstants.SETUP_DATA_AUTH_PAP_CHAP :
                RILConstants.SETUP_DATA_AUTH_NONE;
        } 
        String protocol;
    if(phone.getServiceState().getRoaming())        
        {
            protocol = mApn.roamingProtocol;
        } 
        else
        {
            protocol = mApn.protocol;
        } 
        phone.mCM.setupDataCall(
                Integer.toString(getRadioTechnology(RILConstants.SETUP_DATA_TECH_GSM)),
                Integer.toString(mProfileId),
                mApn.apn, mApn.user, mApn.password,
                Integer.toString(authType),
                protocol, msg);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.145 -0400", hash_original_method = "A22DEA53C24C8CD549338E7FA6E130EF", hash_generated_method = "727F58AE6FDA84B9FCAE25982BC0A444")
    public void setProfileId(int profileId) {
        mProfileId = profileId;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.145 -0400", hash_original_method = "F4D053905D2BF654ACB2CC18D573B985", hash_generated_method = "18B038629154ACE35F23D879106FDD78")
    public int getProfileId() {
        int varAD5F16B5D45AD9FEEE13E88B2059EC91_753884532 = (mProfileId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_607679812 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_607679812;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.145 -0400", hash_original_method = "49E60EF07FF1E574F2B5B752F6A3111C", hash_generated_method = "6098E4E3C54C8A106210FF605DE9D6C0")
    public void setActiveApnType(String apnType) {
        mActiveApnType = apnType;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.146 -0400", hash_original_method = "E1755C32D3A976D9153A9C990E44F94A", hash_generated_method = "65BDE2DA2C579E323635802B3C2FC208")
    @Override
    public String toString() {
String var4AD72B987A838A37F68883A3F1D1CCD2_282568977 =         "State=" + getCurrentState().getName() + " Apn=" + mApn +
               " create=" + createTime + " lastFail=" + lastFailTime +
               " lastFailCause=" + lastFailCause;
        var4AD72B987A838A37F68883A3F1D1CCD2_282568977.addTaint(taint);
        return var4AD72B987A838A37F68883A3F1D1CCD2_282568977;
        
        
               
               
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.146 -0400", hash_original_method = "0657EF2F9C80323FA50A03320BF221A9", hash_generated_method = "653BB26450CA3C1B9334A1BD77B08829")
    @Override
    protected boolean isDnsOk(String[] domainNameServers) {
        addTaint(domainNameServers[0].getTaint());
    if(NULL_IP.equals(domainNameServers[0]) && NULL_IP.equals(domainNameServers[1])
                && !phone.isDnsCheckDisabled())        
        {
    if(!mApn.types[0].equals(Phone.APN_TYPE_MMS)
                || !isIpAddress(mApn.mmsProxy))            
            {
                log(String.format(
                        "isDnsOk: return false apn.types[0]=%s APN_TYPE_MMS=%s isIpAddress(%s)=%s",
                        mApn.types[0], Phone.APN_TYPE_MMS, mApn.mmsProxy,
                        isIpAddress(mApn.mmsProxy)));
                boolean var68934A3E9455FA72420237EB05902327_930552855 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_101721628 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_101721628;
            } 
        } 
        boolean varB326B5062B2F0E69046810717534CB09_1448870168 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1665158364 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1665158364;
        
        
                
            
                
                
                        
                        
                        
                
            
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.147 -0400", hash_original_method = "E3E03901000B497B61536E572BF51316", hash_generated_method = "3D39A3641D1F679267312BB4AD7C571C")
    @Override
    protected void log(String s) {
        addTaint(s.getTaint());
        Log.d(LOG_TAG, "[" + getName() + "] " + s);
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.147 -0400", hash_original_method = "0EBFCAAE2D7BDF5375234415A0DA2D8D", hash_generated_method = "B9E598FAC711D8BCAA2B6697F27647FE")
    private boolean isIpAddress(String address) {
        addTaint(address.getTaint());
    if(address == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1747353301 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_536123110 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_536123110;
        }
        boolean var1D94E909116588975EF937A195F1A6B2_548786897 = (Patterns.IP_ADDRESS.matcher(address).matches());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1033186479 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1033186479;
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.147 -0400", hash_original_field = "41EBE7F32B96C1E2E9C209710486A443", hash_generated_field = "D922E4732DF1A8050A7A55C2D62EC423")

    private static final String LOG_TAG = "GSM";
}

