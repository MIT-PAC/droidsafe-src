package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.477 -0400", hash_original_field = "285E977A3F24171DCF659128908B0B5A", hash_generated_field = "4B86B7A6BB3954D8A0D6116E4CC1760F")

    protected int mProfileId = RILConstants.DATA_PROFILE_DEFAULT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.477 -0400", hash_original_field = "BEFD69DEB43D71296C7CCACD00213393", hash_generated_field = "FEA7396BF99CD16BDCDC29FABBFA8C84")

    protected String mActiveApnType = Phone.APN_TYPE_DEFAULT;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.477 -0400", hash_original_method = "D7C479FF4503363D3DB56494C7CC433A", hash_generated_method = "03561623326AF5DE503043A90B285CE4")
    private  GsmDataConnection(PhoneBase phone, String name, int id, RetryManager rm) {
        super(phone, name, id, rm);
        addTaint(phone.getTaint());
        addTaint(name.getTaint());
        addTaint(id);
        addTaint(rm.getTaint());
        // ---------- Original Method ----------
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.478 -0400", hash_original_method = "B9699B49BCC7654BF74B38BF9D177791", hash_generated_method = "A63E06E0E11D4F6151C834C33D884E9F")
    @Override
    protected void onConnect(ConnectionParams cp) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mApn = cp.apn;
        log("Connecting to carrier: '" + mApn.carrier
                + "' APN: '" + mApn.apn
                + "' proxy: '" + mApn.proxy + "' port: '" + mApn.port);
        createTime = -1;
        lastFailTime = -1;
        lastFailCause = FailCause.NONE;
        Message msg = obtainMessage(EVENT_SETUP_DATA_CONNECTION_DONE, cp);
        msg.obj = cp;
        int authType = mApn.authType;
        {
            authType = (mApn.user != null) ? RILConstants.SETUP_DATA_AUTH_PAP_CHAP :
                RILConstants.SETUP_DATA_AUTH_NONE;
        } //End block
        String protocol;
        {
            boolean var5BCCD4E05A22FFA39BB9AB650CCFFFDA_1874337021 = (phone.getServiceState().getRoaming());
            {
                protocol = mApn.roamingProtocol;
            } //End block
            {
                protocol = mApn.protocol;
            } //End block
        } //End collapsed parenthetic
        phone.mCM.setupDataCall(
                Integer.toString(getRadioTechnology(RILConstants.SETUP_DATA_TECH_GSM)),
                Integer.toString(mProfileId),
                mApn.apn, mApn.user, mApn.password,
                Integer.toString(authType),
                protocol, msg);
        addTaint(cp.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.478 -0400", hash_original_method = "A22DEA53C24C8CD549338E7FA6E130EF", hash_generated_method = "727F58AE6FDA84B9FCAE25982BC0A444")
    public void setProfileId(int profileId) {
        mProfileId = profileId;
        // ---------- Original Method ----------
        //mProfileId = profileId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.479 -0400", hash_original_method = "F4D053905D2BF654ACB2CC18D573B985", hash_generated_method = "BC8949FC77D0DCF041C3003CD53677F5")
    public int getProfileId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1571366755 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1571366755;
        // ---------- Original Method ----------
        //return mProfileId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.479 -0400", hash_original_method = "49E60EF07FF1E574F2B5B752F6A3111C", hash_generated_method = "6098E4E3C54C8A106210FF605DE9D6C0")
    public void setActiveApnType(String apnType) {
        mActiveApnType = apnType;
        // ---------- Original Method ----------
        //mActiveApnType = apnType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.479 -0400", hash_original_method = "E1755C32D3A976D9153A9C990E44F94A", hash_generated_method = "38BECA3CFE1004720095F6E2A8381F29")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_993958609 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_993958609 = "State=" + getCurrentState().getName() + " Apn=" + mApn +
               " create=" + createTime + " lastFail=" + lastFailTime +
               " lastFailCause=" + lastFailCause;
        varB4EAC82CA7396A68D541C85D26508E83_993958609.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_993958609;
        // ---------- Original Method ----------
        //return "State=" + getCurrentState().getName() + " Apn=" + mApn +
               //" create=" + createTime + " lastFail=" + lastFailTime +
               //" lastFailCause=" + lastFailCause;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.480 -0400", hash_original_method = "0657EF2F9C80323FA50A03320BF221A9", hash_generated_method = "6169089F5A56E9DBF60FA27C489FD34F")
    @Override
    protected boolean isDnsOk(String[] domainNameServers) {
        {
            boolean var454D5CFCC9EE7F2E8CA18D44D86DA1B6_1559251672 = (NULL_IP.equals(domainNameServers[0]) && NULL_IP.equals(domainNameServers[1])
                && !phone.isDnsCheckDisabled());
            {
                {
                    boolean varB0BFD8446F053730B6557C3F6C323779_28213087 = (!mApn.types[0].equals(Phone.APN_TYPE_MMS)
                || !isIpAddress(mApn.mmsProxy));
                    {
                        log(String.format(
                        "isDnsOk: return false apn.types[0]=%s APN_TYPE_MMS=%s isIpAddress(%s)=%s",
                        mApn.types[0], Phone.APN_TYPE_MMS, mApn.mmsProxy,
                        isIpAddress(mApn.mmsProxy)));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(domainNameServers[0].getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_116616305 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_116616305;
        // ---------- Original Method ----------
        //if (NULL_IP.equals(domainNameServers[0]) && NULL_IP.equals(domainNameServers[1])
                //&& !phone.isDnsCheckDisabled()) {
            //if (!mApn.types[0].equals(Phone.APN_TYPE_MMS)
                //|| !isIpAddress(mApn.mmsProxy)) {
                //log(String.format(
                        //"isDnsOk: return false apn.types[0]=%s APN_TYPE_MMS=%s isIpAddress(%s)=%s",
                        //mApn.types[0], Phone.APN_TYPE_MMS, mApn.mmsProxy,
                        //isIpAddress(mApn.mmsProxy)));
                //return false;
            //}
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.481 -0400", hash_original_method = "E3E03901000B497B61536E572BF51316", hash_generated_method = "EB8C75A46F3714E41BD20C8651699298")
    @Override
    protected void log(String s) {
        Log.d(LOG_TAG, "[" + getName() + "] " + s);
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[" + getName() + "] " + s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.482 -0400", hash_original_method = "0EBFCAAE2D7BDF5375234415A0DA2D8D", hash_generated_method = "9CDA8807F9F9EDBFCDD5D0DC5A32E6BE")
    private boolean isIpAddress(String address) {
        boolean var65033AEEF924DF643741D59ED1BDE7AC_1412762177 = (Patterns.IP_ADDRESS.matcher(address).matches());
        addTaint(address.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_615471562 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_615471562;
        // ---------- Original Method ----------
        //if (address == null) return false;
        //return Patterns.IP_ADDRESS.matcher(address).matches();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.482 -0400", hash_original_field = "41EBE7F32B96C1E2E9C209710486A443", hash_generated_field = "D922E4732DF1A8050A7A55C2D62EC423")

    private static final String LOG_TAG = "GSM";
}

