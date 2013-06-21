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
import com.android.internal.telephony.DataConnectionTracker;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.PhoneBase;
import com.android.internal.telephony.RILConstants;
import com.android.internal.telephony.RetryManager;

public class GsmDataConnection extends DataConnection {
    protected int mProfileId = RILConstants.DATA_PROFILE_DEFAULT;
    protected String mActiveApnType = Phone.APN_TYPE_DEFAULT;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.328 -0400", hash_original_method = "AC4E9A30F7AD03CC3D3FB8CF1913D25B", hash_generated_method = "F4A8474A2282167877A7456DEE1C3A96")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private GsmDataConnection(PhoneBase phone, String name, int id, RetryManager rm,
            DataConnectionTracker dct) {
        super(phone, name, id, rm, dct);
        dsTaint.addTaint(id);
        dsTaint.addTaint(phone.dsTaint);
        dsTaint.addTaint(rm.dsTaint);
        dsTaint.addTaint(dct.dsTaint);
        dsTaint.addTaint(name);
        // ---------- Original Method ----------
    }

    
        static GsmDataConnection makeDataConnection(PhoneBase phone, int id, RetryManager rm,
            DataConnectionTracker dct) {
        synchronized (mCountLock) {
            mCount += 1;
        }
        GsmDataConnection gsmDc = new GsmDataConnection(phone, "GsmDC-" + mCount, id, rm, dct);
        gsmDc.start();
        if (DBG) gsmDc.log("Made " + gsmDc.getName());
        return gsmDc;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.329 -0400", hash_original_method = "B9699B49BCC7654BF74B38BF9D177791", hash_generated_method = "7A70C4EED8A5E7EE8EA854642BFC0BA2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onConnect(ConnectionParams cp) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(cp.dsTaint);
        mApn = cp.apn;
        log("Connecting to carrier: '" + mApn.carrier
                + "' APN: '" + mApn.apn
                + "' proxy: '" + mApn.proxy + "' port: '" + mApn.port);
        createTime = -1;
        lastFailTime = -1;
        lastFailCause = FailCause.NONE;
        Message msg;
        msg = obtainMessage(EVENT_SETUP_DATA_CONNECTION_DONE, cp);
        msg.obj = cp;
        int authType;
        authType = mApn.authType;
        {
            authType = (mApn.user != null) ? RILConstants.SETUP_DATA_AUTH_PAP_CHAP :
                RILConstants.SETUP_DATA_AUTH_NONE;
        } //End block
        String protocol;
        {
            boolean var5BCCD4E05A22FFA39BB9AB650CCFFFDA_1961603098 = (phone.getServiceState().getRoaming());
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.329 -0400", hash_original_method = "A22DEA53C24C8CD549338E7FA6E130EF", hash_generated_method = "AC6B730F2A16C7A1891002DC10C0B2FF")
    @DSModeled(DSC.SAFE)
    public void setProfileId(int profileId) {
        dsTaint.addTaint(profileId);
        // ---------- Original Method ----------
        //mProfileId = profileId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.329 -0400", hash_original_method = "F4D053905D2BF654ACB2CC18D573B985", hash_generated_method = "127D6D78BCA66CBEEB8A3E2E229724BF")
    @DSModeled(DSC.SAFE)
    public int getProfileId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mProfileId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.329 -0400", hash_original_method = "49E60EF07FF1E574F2B5B752F6A3111C", hash_generated_method = "E609E35170F3B5A84B71896BBCC049AF")
    @DSModeled(DSC.SAFE)
    public void setActiveApnType(String apnType) {
        dsTaint.addTaint(apnType);
        // ---------- Original Method ----------
        //mActiveApnType = apnType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.330 -0400", hash_original_method = "E1755C32D3A976D9153A9C990E44F94A", hash_generated_method = "446083D7D0032FB69EC939CF5F85D9CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String varCB5DF8AD4BCA16B907EFADBF6DAE3A3A_402508519 = ("State=" + getCurrentState().getName() + " Apn=" + mApn +
               " create=" + createTime + " lastFail=" + lastFailTime +
               " lastFailCause=" + lastFailCause);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "State=" + getCurrentState().getName() + " Apn=" + mApn +
               //" create=" + createTime + " lastFail=" + lastFailTime +
               //" lastFailCause=" + lastFailCause;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.330 -0400", hash_original_method = "0657EF2F9C80323FA50A03320BF221A9", hash_generated_method = "7501379D76807E1BB2F0375CCEC9571C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean isDnsOk(String[] domainNameServers) {
        dsTaint.addTaint(domainNameServers[0]);
        {
            boolean var454D5CFCC9EE7F2E8CA18D44D86DA1B6_1823112844 = (NULL_IP.equals(domainNameServers[0]) && NULL_IP.equals(domainNameServers[1])
                && !phone.isDnsCheckDisabled());
            {
                {
                    boolean varB0BFD8446F053730B6557C3F6C323779_1851500690 = (!mApn.types[0].equals(Phone.APN_TYPE_MMS)
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.330 -0400", hash_original_method = "E3E03901000B497B61536E572BF51316", hash_generated_method = "A7A846DA1C21C7C7BCF2BA2B51000A14")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void log(String s) {
        dsTaint.addTaint(s);
        Log.d(LOG_TAG, "[" + getName() + "] " + s);
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[" + getName() + "] " + s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.330 -0400", hash_original_method = "0EBFCAAE2D7BDF5375234415A0DA2D8D", hash_generated_method = "F72B24108311C81F5EE91CCDB61C079E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isIpAddress(String address) {
        dsTaint.addTaint(address);
        boolean var65033AEEF924DF643741D59ED1BDE7AC_1942550150 = (Patterns.IP_ADDRESS.matcher(address).matches());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (address == null) return false;
        //return Patterns.IP_ADDRESS.matcher(address).matches();
    }

    
    private static final String LOG_TAG = "GSM";
}

