package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.app.ActivityManagerNative;
import android.app.IActivityManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.SharedPreferences;
import android.net.LinkCapabilities;
import android.net.LinkProperties;
import android.net.wifi.WifiManager;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RegistrantList;
import android.os.SystemProperties;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.telephony.ServiceState;
import android.text.TextUtils;
import android.util.Log;
import com.android.internal.R;
import com.android.internal.telephony.gsm.UsimServiceTable;
import com.android.internal.telephony.ims.IsimRecords;
import com.android.internal.telephony.test.SimulatedRadioControl;
import com.android.internal.telephony.gsm.SIMRecords;
import com.android.internal.telephony.gsm.SimCard;
import java.util.Locale;

public abstract class PhoneBase extends Handler implements Phone {
    public CommandsInterface mCM;
    protected IccFileHandler mIccFileHandler;
    boolean mDnsCheckDisabled;
    public DataConnectionTracker mDataConnectionTracker;
    boolean mDoesRilSendMultipleCallRing;
    int mCallRingContinueToken;
    int mCallRingDelay;
    public boolean mIsTheCurrentActivePhone = true;
    boolean mIsVoiceCapable = true;
    public IccRecords mIccRecords;
    public IccCard mIccCard;
    public SmsStorageMonitor mSmsStorageMonitor;
    public SmsUsageMonitor mSmsUsageMonitor;
    public SMSDispatcher mSMS;
    protected RegistrantList mPreciseCallStateRegistrants
            = new RegistrantList();
    protected RegistrantList mNewRingingConnectionRegistrants
            = new RegistrantList();
    protected RegistrantList mIncomingRingRegistrants
            = new RegistrantList();
    protected RegistrantList mDisconnectRegistrants
            = new RegistrantList();
    protected RegistrantList mServiceStateRegistrants
            = new RegistrantList();
    protected RegistrantList mMmiCompleteRegistrants
            = new RegistrantList();
    protected RegistrantList mMmiRegistrants
            = new RegistrantList();
    protected RegistrantList mUnknownConnectionRegistrants
            = new RegistrantList();
    protected RegistrantList mSuppServiceFailedRegistrants
            = new RegistrantList();
    protected Looper mLooper;
    protected Context mContext;
    protected PhoneNotifier mNotifier;
    protected SimulatedRadioControl mSimulatedRadioControl;
    boolean mUnitTestMode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.578 -0400", hash_original_method = "0B01EDD7CFA10DA565A9E13F0B7F18B5", hash_generated_method = "4A1D0EC590710CCC2ACD11F21D2DEB3F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected PhoneBase(PhoneNotifier notifier, Context context, CommandsInterface ci) {
        this(notifier, context, ci, false);
        dsTaint.addTaint(notifier.dsTaint);
        dsTaint.addTaint(ci.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.579 -0400", hash_original_method = "0B181FBA64FE5D093F6319BFF754183A", hash_generated_method = "390D50DF27B75452926C75B59C10FED1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected PhoneBase(PhoneNotifier notifier, Context context, CommandsInterface ci,
            boolean unitTestMode) {
        dsTaint.addTaint(unitTestMode);
        dsTaint.addTaint(notifier.dsTaint);
        dsTaint.addTaint(ci.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        mLooper = Looper.myLooper();
        setPropertiesByCarrier();
        setUnitTestMode(unitTestMode);
        SharedPreferences sp;
        sp = PreferenceManager.getDefaultSharedPreferences(context);
        mDnsCheckDisabled = sp.getBoolean(DNS_SERVER_CHECK_DISABLED_KEY, false);
        mCM.setOnCallRing(this, EVENT_CALL_RING, null);
        mIsVoiceCapable = mContext.getResources().getBoolean(
                com.android.internal.R.bool.config_voice_capable);
        mDoesRilSendMultipleCallRing = SystemProperties.getBoolean(
                TelephonyProperties.PROPERTY_RIL_SENDS_MULTIPLE_CALL_RING, true);
        Log.d(LOG_TAG, "mDoesRilSendMultipleCallRing=" + mDoesRilSendMultipleCallRing);
        mCallRingDelay = SystemProperties.getInt(
                TelephonyProperties.PROPERTY_CALL_RING_DELAY, 3000);
        Log.d(LOG_TAG, "mCallRingDelay=" + mCallRingDelay);
        mSmsStorageMonitor = new SmsStorageMonitor(this);
        mSmsUsageMonitor = new SmsUsageMonitor(context.getContentResolver());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.579 -0400", hash_original_method = "5E4CE6B07EFCD29EE81659A348140E39", hash_generated_method = "792D241DF9BF480BAFD83FBCA76B36C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSystemProperty(String property, String value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(property);
        {
            boolean var70902CF88F4EB5C4A377580704B63A33_1566276769 = (getUnitTestMode());
        } //End collapsed parenthetic
        SystemProperties.set(property, value);
        // ---------- Original Method ----------
        //if(getUnitTestMode()) {
            //return;
        //}
        //SystemProperties.set(property, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.579 -0400", hash_original_method = "E6D9767A803FC78FE4F21E8C0AA16E1B", hash_generated_method = "4E2EEF57B7AE7D00D54C481EF756B0D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispose() {
        {
            mCM.unSetOnCallRing(this);
            mDataConnectionTracker.cleanUpAllConnections(null);
            mIsTheCurrentActivePhone = false;
            mSmsStorageMonitor.dispose();
            mSmsUsageMonitor.dispose();
        } //End block
        // ---------- Original Method ----------
        //synchronized(PhoneProxy.lockForRadioTechnologyChange) {
            //mCM.unSetOnCallRing(this);
            //mDataConnectionTracker.cleanUpAllConnections(null);
            //mIsTheCurrentActivePhone = false;
            //mSmsStorageMonitor.dispose();
            //mSmsUsageMonitor.dispose();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.580 -0400", hash_original_method = "AD2C393D4007178071128FB79D198E7A", hash_generated_method = "939AA9D60C792DDBF5AE38E81D1C4004")
    @DSModeled(DSC.SAFE)
    public void removeReferences() {
        mSmsStorageMonitor = null;
        mSmsUsageMonitor = null;
        // ---------- Original Method ----------
        //mSmsStorageMonitor = null;
        //mSmsUsageMonitor = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.580 -0400", hash_original_method = "DB16D19FE7C055C53AF6F04667B938A9", hash_generated_method = "D706E222D4BEC26F49B75406171079BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void handleMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        AsyncResult ar;
        //Begin case EVENT_CALL_RING 
        Log.d(LOG_TAG, "Event EVENT_CALL_RING Received state=" + getState());
        //End case EVENT_CALL_RING 
        //Begin case EVENT_CALL_RING 
        ar = (AsyncResult)msg.obj;
        //End case EVENT_CALL_RING 
        //Begin case EVENT_CALL_RING 
        {
            Phone.State state;
            state = getState();
            {
                mCallRingContinueToken += 1;
                sendIncomingCallRingNotification(mCallRingContinueToken);
            } //End block
            {
                notifyIncomingRing();
            } //End block
        } //End block
        //End case EVENT_CALL_RING 
        //Begin case EVENT_CALL_RING_CONTINUE 
        Log.d(LOG_TAG, "Event EVENT_CALL_RING_CONTINUE Received stat=" + getState());
        //End case EVENT_CALL_RING_CONTINUE 
        //Begin case EVENT_CALL_RING_CONTINUE 
        {
            boolean var95B9CB18D0624E6EEB44A7D4EE2ACB8D_565797291 = (getState() == Phone.State.RINGING);
            {
                sendIncomingCallRingNotification(msg.arg1);
            } //End block
        } //End collapsed parenthetic
        //End case EVENT_CALL_RING_CONTINUE 
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("unexpected event not handled");
        //End case default 
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.580 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "DFA42A6C39C27C217BA4B1F8A6817BD5")
    @DSModeled(DSC.SAFE)
    public Context getContext() {
        return (Context)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.580 -0400", hash_original_method = "6B58AC4FFDA912638B2751BFF719D57B", hash_generated_method = "0CAC34B713858A7A536BF7AB0B65EBC2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void disableDnsCheck(boolean b) {
        dsTaint.addTaint(b);
        SharedPreferences sp;
        sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor;
        editor = sp.edit();
        editor.putBoolean(DNS_SERVER_CHECK_DISABLED_KEY, b);
        editor.apply();
        // ---------- Original Method ----------
        //mDnsCheckDisabled = b;
        //SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        //SharedPreferences.Editor editor = sp.edit();
        //editor.putBoolean(DNS_SERVER_CHECK_DISABLED_KEY, b);
        //editor.apply();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.581 -0400", hash_original_method = "26E6CAA04D711DCC258BDCDD2AAE1C53", hash_generated_method = "D40C94AEBD1842441B97B3826C5EE407")
    @DSModeled(DSC.SAFE)
    public boolean isDnsCheckDisabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mDnsCheckDisabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.581 -0400", hash_original_method = "97FD2D9125201743A42C7236EAF94A65", hash_generated_method = "C45666E75E37546006EADFD142E991AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForPreciseCallStateChanged(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        checkCorrectThread(h);
        mPreciseCallStateRegistrants.addUnique(h, what, obj);
        // ---------- Original Method ----------
        //checkCorrectThread(h);
        //mPreciseCallStateRegistrants.addUnique(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.581 -0400", hash_original_method = "3468093E0DED2950A146A2A89C89E0C9", hash_generated_method = "2ADACA64B9BEFB5A90A700A131330EC9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForPreciseCallStateChanged(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mPreciseCallStateRegistrants.remove(h);
        // ---------- Original Method ----------
        //mPreciseCallStateRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.581 -0400", hash_original_method = "7D1AEC63A120FA3D327FCF14A278BC6F", hash_generated_method = "69848D6291CDA576C25A072576E7D384")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void notifyPreciseCallStateChangedP() {
        AsyncResult ar;
        ar = new AsyncResult(null, this, null);
        mPreciseCallStateRegistrants.notifyRegistrants(ar);
        // ---------- Original Method ----------
        //AsyncResult ar = new AsyncResult(null, this, null);
        //mPreciseCallStateRegistrants.notifyRegistrants(ar);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.581 -0400", hash_original_method = "B9AA4FF50180EB9A48B29DB9F5910CE4", hash_generated_method = "6F94C6FD72FA96EA5E23DF239A9B6B12")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForUnknownConnection(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        checkCorrectThread(h);
        mUnknownConnectionRegistrants.addUnique(h, what, obj);
        // ---------- Original Method ----------
        //checkCorrectThread(h);
        //mUnknownConnectionRegistrants.addUnique(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.582 -0400", hash_original_method = "75B09E3F4F0ED781C6A40D2F37829CA0", hash_generated_method = "543CC1D726DB220E8CECEC8D28F086D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForUnknownConnection(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mUnknownConnectionRegistrants.remove(h);
        // ---------- Original Method ----------
        //mUnknownConnectionRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.582 -0400", hash_original_method = "AD1FA3FDB645CF1FEF5A2946EFD96B38", hash_generated_method = "F4B03876F1A28C76E108CF02A1B9D0EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForNewRingingConnection(
            Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        checkCorrectThread(h);
        mNewRingingConnectionRegistrants.addUnique(h, what, obj);
        // ---------- Original Method ----------
        //checkCorrectThread(h);
        //mNewRingingConnectionRegistrants.addUnique(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.582 -0400", hash_original_method = "058A0D079EFCE83305D698FFA7B5D825", hash_generated_method = "58696F2D43CF3B11EB9A4CFFC1D609AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForNewRingingConnection(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mNewRingingConnectionRegistrants.remove(h);
        // ---------- Original Method ----------
        //mNewRingingConnectionRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.582 -0400", hash_original_method = "0EC65AF661091C788FEAC732E62723E6", hash_generated_method = "0FBAE55F79CF7B2E03A6E2E4D67A49E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForInCallVoicePrivacyOn(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mCM.registerForInCallVoicePrivacyOn(h,what,obj);
        // ---------- Original Method ----------
        //mCM.registerForInCallVoicePrivacyOn(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.582 -0400", hash_original_method = "AAF2DABAA6CCE680F9F5730540C91C97", hash_generated_method = "F53960A3AEC9E67399F9E3FBDCC605DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForInCallVoicePrivacyOn(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mCM.unregisterForInCallVoicePrivacyOn(h);
        // ---------- Original Method ----------
        //mCM.unregisterForInCallVoicePrivacyOn(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.582 -0400", hash_original_method = "5EF015768DAEEB9D8933F39BF43636FD", hash_generated_method = "21EFEFA4EDF8B25B683157DF21BE0DD8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForInCallVoicePrivacyOff(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mCM.registerForInCallVoicePrivacyOff(h,what,obj);
        // ---------- Original Method ----------
        //mCM.registerForInCallVoicePrivacyOff(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.583 -0400", hash_original_method = "D5B23AF1D1217C6A3E1625439D35B2E2", hash_generated_method = "8BC6CD134156D8ABEFFA6A482B065EEF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForInCallVoicePrivacyOff(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mCM.unregisterForInCallVoicePrivacyOff(h);
        // ---------- Original Method ----------
        //mCM.unregisterForInCallVoicePrivacyOff(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.583 -0400", hash_original_method = "50A4B0D73C58D3A2BE8105C1A17D2698", hash_generated_method = "01FC27D995CDBD0C697DC0EC5C528902")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForIncomingRing(
            Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        checkCorrectThread(h);
        mIncomingRingRegistrants.addUnique(h, what, obj);
        // ---------- Original Method ----------
        //checkCorrectThread(h);
        //mIncomingRingRegistrants.addUnique(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.583 -0400", hash_original_method = "92E2BA35AB0B11C010FD1FF2A8E6A65B", hash_generated_method = "544E94D727E72D9255A8970D6042B8E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForIncomingRing(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mIncomingRingRegistrants.remove(h);
        // ---------- Original Method ----------
        //mIncomingRingRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.583 -0400", hash_original_method = "2053ED9D2D7BD498A1C704AFBEE337C3", hash_generated_method = "4900EB76A671BE87B6FCFA2906BEB0EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForDisconnect(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        checkCorrectThread(h);
        mDisconnectRegistrants.addUnique(h, what, obj);
        // ---------- Original Method ----------
        //checkCorrectThread(h);
        //mDisconnectRegistrants.addUnique(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.583 -0400", hash_original_method = "77A19CF742BA6691CDA7407600B4E7F3", hash_generated_method = "003870E3812955A67ECBA77AAA3AE549")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForDisconnect(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mDisconnectRegistrants.remove(h);
        // ---------- Original Method ----------
        //mDisconnectRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.584 -0400", hash_original_method = "D574E9C9A24655069A0054F4E3538F49", hash_generated_method = "D27C031A66FED01408195B934CF36344")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForSuppServiceFailed(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        checkCorrectThread(h);
        mSuppServiceFailedRegistrants.addUnique(h, what, obj);
        // ---------- Original Method ----------
        //checkCorrectThread(h);
        //mSuppServiceFailedRegistrants.addUnique(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.585 -0400", hash_original_method = "C86C69890AF660CD858A7F262F783D04", hash_generated_method = "D4FE2084D834C324115BB068DA04DCF0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForSuppServiceFailed(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mSuppServiceFailedRegistrants.remove(h);
        // ---------- Original Method ----------
        //mSuppServiceFailedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.586 -0400", hash_original_method = "04A8F1C35CFA7005AF5258C29F5FFE2B", hash_generated_method = "C64B76AFB362CD8D83821D2783A9E2DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForMmiInitiate(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        checkCorrectThread(h);
        mMmiRegistrants.addUnique(h, what, obj);
        // ---------- Original Method ----------
        //checkCorrectThread(h);
        //mMmiRegistrants.addUnique(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.587 -0400", hash_original_method = "338E9AA4432AD835C97CF49233FF5692", hash_generated_method = "C6C819218A7AFC2E15525D79DF949FBD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForMmiInitiate(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mMmiRegistrants.remove(h);
        // ---------- Original Method ----------
        //mMmiRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.589 -0400", hash_original_method = "61BE6CB4DF9A0C652F1BC7F7AD4D4CCB", hash_generated_method = "E5293282BD54BD2240DC692C58DEDEB9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForMmiComplete(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        checkCorrectThread(h);
        mMmiCompleteRegistrants.addUnique(h, what, obj);
        // ---------- Original Method ----------
        //checkCorrectThread(h);
        //mMmiCompleteRegistrants.addUnique(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.590 -0400", hash_original_method = "FE25021AB6559853BB3705423F117C85", hash_generated_method = "01E36E91C5F8888BAF14B3DA4B0BB127")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForMmiComplete(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        checkCorrectThread(h);
        mMmiCompleteRegistrants.remove(h);
        // ---------- Original Method ----------
        //checkCorrectThread(h);
        //mMmiCompleteRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.590 -0400", hash_original_method = "764E722E685D5D307BCF00BDB294F564", hash_generated_method = "9D4D2AEB11EE32B88B6647822C7ED7A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String getSavedNetworkSelection() {
        SharedPreferences sp;
        sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        String var96F22B674EC19CE2850DD24FA26E01FB_683309227 = (sp.getString(NETWORK_SELECTION_KEY, ""));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        //return sp.getString(NETWORK_SELECTION_KEY, "");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.590 -0400", hash_original_method = "29F19DECCCFC42207CFA8F3911C2D799", hash_generated_method = "564660F5586DB58A8B01F8CD4E3AD6E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void restoreSavedNetworkSelection(Message response) {
        dsTaint.addTaint(response.dsTaint);
        String networkSelection;
        networkSelection = getSavedNetworkSelection();
        {
            boolean var7DB33003CA3D238605A26618783283D8_1159260117 = (TextUtils.isEmpty(networkSelection));
            {
                mCM.setNetworkSelectionModeAutomatic(response);
            } //End block
            {
                mCM.setNetworkSelectionModeManual(networkSelection, response);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //String networkSelection = getSavedNetworkSelection();
        //if (TextUtils.isEmpty(networkSelection)) {
            //mCM.setNetworkSelectionModeAutomatic(response);
        //} else {
            //mCM.setNetworkSelectionModeManual(networkSelection, response);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.590 -0400", hash_original_method = "347AF2D7A75CED9B3C82A500C1FA5AD6", hash_generated_method = "B57AF6133BB1C397C43F9DB482030A72")
    @DSModeled(DSC.SAFE)
    public void setUnitTestMode(boolean f) {
        dsTaint.addTaint(f);
        // ---------- Original Method ----------
        //mUnitTestMode = f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.591 -0400", hash_original_method = "958D127406A24370C06699E6AB687F2A", hash_generated_method = "341FF379FA82DB3E0CCB516EBA0FFA5B")
    @DSModeled(DSC.SAFE)
    public boolean getUnitTestMode() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mUnitTestMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.591 -0400", hash_original_method = "80E90CBCA9EDC240B4F0091FF8E28C26", hash_generated_method = "A4BCDA978E3E24D4BBE8DCCAA77E7F95")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void notifyDisconnectP(Connection cn) {
        dsTaint.addTaint(cn.dsTaint);
        AsyncResult ar;
        ar = new AsyncResult(null, cn, null);
        mDisconnectRegistrants.notifyRegistrants(ar);
        // ---------- Original Method ----------
        //AsyncResult ar = new AsyncResult(null, cn, null);
        //mDisconnectRegistrants.notifyRegistrants(ar);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.591 -0400", hash_original_method = "BD17CCC0601D2F340E3F675C1E59C4B9", hash_generated_method = "089FB0A95A2B9761B85EF15DF8998B90")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForServiceStateChanged(
            Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        checkCorrectThread(h);
        mServiceStateRegistrants.add(h, what, obj);
        // ---------- Original Method ----------
        //checkCorrectThread(h);
        //mServiceStateRegistrants.add(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.591 -0400", hash_original_method = "5AFF1BE54185C9B4577A75EFF0396B68", hash_generated_method = "F080BB6BF2F3057317C1340322BAB7E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForServiceStateChanged(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mServiceStateRegistrants.remove(h);
        // ---------- Original Method ----------
        //mServiceStateRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.591 -0400", hash_original_method = "6C50CDA22F8E02023B34911844DFEED2", hash_generated_method = "025B2E0CF609691135CBF304AAB30756")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForRingbackTone(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mCM.registerForRingbackTone(h,what,obj);
        // ---------- Original Method ----------
        //mCM.registerForRingbackTone(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.591 -0400", hash_original_method = "475301C04BE08B381350355879425A76", hash_generated_method = "BE0496444CD76E266BD25654DB22ED28")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForRingbackTone(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mCM.unregisterForRingbackTone(h);
        // ---------- Original Method ----------
        //mCM.unregisterForRingbackTone(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.592 -0400", hash_original_method = "6FE1177D9BF24D9A41C1BE1AD2A93980", hash_generated_method = "E5B9A6FDFCB8933AA25383A8842D8B98")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForResendIncallMute(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mCM.registerForResendIncallMute(h,what,obj);
        // ---------- Original Method ----------
        //mCM.registerForResendIncallMute(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.592 -0400", hash_original_method = "1E28EF1EEBC2208F47A83D89926DE82E", hash_generated_method = "C8A6A5C6DCAA92CD90C35E645BDDF16D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForResendIncallMute(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mCM.unregisterForResendIncallMute(h);
        // ---------- Original Method ----------
        //mCM.unregisterForResendIncallMute(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.592 -0400", hash_original_method = "F34715D262D40C908422031B6920D016", hash_generated_method = "CBBBE5FFF0B3384DB9E569031759EBE2")
    @DSModeled(DSC.SAFE)
    public void setEchoSuppressionEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.592 -0400", hash_original_method = "D42B19E1304E0F299FEED69470ACF7B6", hash_generated_method = "2CC099216CCDE8D00BFDCDC48FDCF707")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void notifyServiceStateChangedP(ServiceState ss) {
        dsTaint.addTaint(ss.dsTaint);
        AsyncResult ar;
        ar = new AsyncResult(null, ss, null);
        mServiceStateRegistrants.notifyRegistrants(ar);
        mNotifier.notifyServiceState(this);
        // ---------- Original Method ----------
        //AsyncResult ar = new AsyncResult(null, ss, null);
        //mServiceStateRegistrants.notifyRegistrants(ar);
        //mNotifier.notifyServiceState(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.592 -0400", hash_original_method = "6C132AD700E1EDF5A17434649EDA0F2C", hash_generated_method = "4660AE6C6EEE168C959EFC08B7465162")
    @DSModeled(DSC.SAFE)
    public SimulatedRadioControl getSimulatedRadioControl() {
        return (SimulatedRadioControl)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSimulatedRadioControl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.592 -0400", hash_original_method = "930052C83226AF8DE91A3B058305558F", hash_generated_method = "6B2676E0CB95C035D75B57D0C0E5DD6D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkCorrectThread(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        {
            boolean varC80731002783DFD1F9463E965D806130_1411628732 = (h.getLooper() != mLooper);
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                    "com.android.internal.telephony.Phone must be used from within one thread");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (h.getLooper() != mLooper) {
            //throw new RuntimeException(
                    //"com.android.internal.telephony.Phone must be used from within one thread");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.593 -0400", hash_original_method = "FDCB651DF17FF9811415182F19CE1B4C", hash_generated_method = "59BC8A3930F87550ED8AC396DE226D37")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setPropertiesByCarrier() {
        String carrier;
        carrier = SystemProperties.get("ro.carrier");
        {
            boolean var4C71EF3FF41846A3F65598AC0FD7C2DF_573298716 = (null == carrier || 0 == carrier.length() || "unknown".equals(carrier));
        } //End collapsed parenthetic
        CharSequence[] carrierLocales;
        carrierLocales = mContext.
                getResources().getTextArray(R.array.carrier_properties);
        {
            int i;
            i = 0;
            i+=3;
            {
                String c;
                c = carrierLocales[i].toString();
                {
                    boolean var75425E199AD2683373EB064DEACE952B_1675260029 = (carrier.equals(c));
                    {
                        String l;
                        l = carrierLocales[i+1].toString();
                        String language;
                        language = l.substring(0, 2);
                        String country;
                        country = "";
                        {
                            boolean varF67DA07AFC0B8D9D491D3A93A03DA49E_824159811 = (l.length() >=5);
                            {
                                country = l.substring(3, 5);
                            } //End block
                        } //End collapsed parenthetic
                        setSystemLocale(language, country, false);
                        {
                            boolean varE322B40A95DAFE52AA6E0E240CD3B924_1490843361 = (!country.isEmpty());
                            {
                                try 
                                {
                                    Settings.Secure.getInt(mContext.getContentResolver(),
                                Settings.Secure.WIFI_COUNTRY_CODE);
                                } //End block
                                catch (Settings.SettingNotFoundException e)
                                {
                                    WifiManager wM;
                                    wM = (WifiManager)
                                mContext.getSystemService(Context.WIFI_SERVICE);
                                    wM.setCountryCode(country, false);
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.594 -0400", hash_original_method = "B1CAAC16126A906DDE46004E33C276B7", hash_generated_method = "56E3DA5863F1B97EFC8A2181890FC6C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSystemLocale(String language, String country, boolean fromMcc) {
        dsTaint.addTaint(fromMcc);
        dsTaint.addTaint(language);
        dsTaint.addTaint(country);
        String l;
        l = SystemProperties.get("persist.sys.language");
        String c;
        c = SystemProperties.get("persist.sys.country");
        language = language.toLowerCase();
        {
            country = "";
        } //End block
        country = country.toUpperCase();
        {
            boolean varE02578713C19A1BF95FEF0FA4F6086A2_1273391113 = ((null == l || 0 == l.length()) && (null == c || 0 == c.length()));
            {
                try 
                {
                    String[] locales;
                    locales = mContext.getAssets().getLocales();
                    int N;
                    N = locales.length;
                    String bestMatch;
                    bestMatch = null;
                    {
                        int i;
                        i = 0;
                        {
                            {
                                boolean varB3910760851B0FD21D5BDE8F0437EA86_798167224 = (locales[i]!=null && locales[i].length() >= 5 &&
                            locales[i].substring(0,2).equals(language));
                                {
                                    {
                                        boolean varD7C1E0B87149D0FC064FD18A3F2956D9_1382263294 = (locales[i].substring(3,5).equals(country));
                                        {
                                            bestMatch = locales[i];
                                        } //End block
                                        {
                                            bestMatch = locales[i];
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                    {
                        IActivityManager am;
                        am = ActivityManagerNative.getDefault();
                        Configuration config;
                        config = am.getConfiguration();
                        config.locale = new Locale(bestMatch.substring(0,2),
                                               bestMatch.substring(3,5));
                        config.userSetLocale = true;
                        am.updateConfiguration(config);
                    } //End block
                } //End block
                catch (Exception e)
                { }
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public abstract Phone.State getState();

    
    public abstract IccFileHandler getIccFileHandler();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.594 -0400", hash_original_method = "B77EA67F9749FFFAEC203B31F557B343", hash_generated_method = "A11B107B3F78F764C6B1E2C50703D783")
    @DSModeled(DSC.SAFE)
    public Handler getHandler() {
        return (Handler)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.594 -0400", hash_original_method = "E9813275B540C23EC4ABDDE1F3F36487", hash_generated_method = "79E5A44EDFE68208E76AB649D3BA9F7A")
    @DSModeled(DSC.SAFE)
    public ServiceStateTracker getServiceStateTracker() {
        return (ServiceStateTracker)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.594 -0400", hash_original_method = "A2CFF60AF23DAF5B5D13432A0E634448", hash_generated_method = "A95E53B24D3D28B27A6A75EE48A3DEE7")
    @DSModeled(DSC.SAFE)
    public CallTracker getCallTracker() {
        return (CallTracker)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.594 -0400", hash_original_method = "E12359725DA3BA4F59BA85FD7E4F143C", hash_generated_method = "61D40C48C8C9E3E652FC329FCAB5FB09")
    @DSModeled(DSC.SAFE)
    @Override
    public IccCard getIccCard() {
        return (IccCard)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mIccCard;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.595 -0400", hash_original_method = "26C3C4C321ACD0FC593701A52D49E497", hash_generated_method = "5CD4F11ECBA4B519059459F096B4F992")
    @DSModeled(DSC.SAFE)
    @Override
    public String getIccSerialNumber() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mIccRecords.iccid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.595 -0400", hash_original_method = "9078EC96DE8D2AE9C16B88E94341FB99", hash_generated_method = "CE73B2A2C36342A369119BDAD06469B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getIccRecordsLoaded() {
        boolean var83CEE5D1173D41B37947C1976F7A6F36_1386418563 = (mIccRecords.getRecordsLoaded());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIccRecords.getRecordsLoaded();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.595 -0400", hash_original_method = "1B6614D059F66BD820665EDAF3DE7F9F", hash_generated_method = "B94E313DEE0759F318C1067AEC23BEE5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getMessageWaitingIndicator() {
        boolean var9905017E0A4EF52F8E7F52DF159D611D_1869237040 = (mIccRecords.getVoiceMessageWaiting());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIccRecords.getVoiceMessageWaiting();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.595 -0400", hash_original_method = "EAA51813A27C6D01EBD0F8DD0837A86A", hash_generated_method = "88F92F24F1FED72D26E9190BAE9343B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getCallForwardingIndicator() {
        boolean varF91C9B7616B652A3A4D61DDBCE0EC0EE_1829758702 = (mIccRecords.getVoiceCallForwardingFlag());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIccRecords.getVoiceCallForwardingFlag();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.595 -0400", hash_original_method = "93DCD756C677180103F6D6F7873E6AE7", hash_generated_method = "0253B0F9F005D5688678A31F25B26751")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void queryCdmaRoamingPreference(Message response) {
        dsTaint.addTaint(response.dsTaint);
        mCM.queryCdmaRoamingPreference(response);
        // ---------- Original Method ----------
        //mCM.queryCdmaRoamingPreference(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.595 -0400", hash_original_method = "D1AE94805C952F3809EAEE65E7FED134", hash_generated_method = "4269BCA2B83531D3AF6CB4EC35B5CF3C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCdmaRoamingPreference(int cdmaRoamingType, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(cdmaRoamingType);
        mCM.setCdmaRoamingPreference(cdmaRoamingType, response);
        // ---------- Original Method ----------
        //mCM.setCdmaRoamingPreference(cdmaRoamingType, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.595 -0400", hash_original_method = "532B78C8CD74E377483500017A27260E", hash_generated_method = "305298CBAB83288D10696EE39203960A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCdmaSubscription(int cdmaSubscriptionType, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(cdmaSubscriptionType);
        mCM.setCdmaSubscriptionSource(cdmaSubscriptionType, response);
        // ---------- Original Method ----------
        //mCM.setCdmaSubscriptionSource(cdmaSubscriptionType, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.596 -0400", hash_original_method = "EA18BAD07370F2F495FB68EDF5CD8C8E", hash_generated_method = "B6E8FBB4242E99ED2D82C4166C477E29")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPreferredNetworkType(int networkType, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(networkType);
        mCM.setPreferredNetworkType(networkType, response);
        // ---------- Original Method ----------
        //mCM.setPreferredNetworkType(networkType, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.596 -0400", hash_original_method = "379A4BC143905A2FA132EF757E52297F", hash_generated_method = "B3E5E61BCCB44A15021242F0A0D5F318")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getPreferredNetworkType(Message response) {
        dsTaint.addTaint(response.dsTaint);
        mCM.getPreferredNetworkType(response);
        // ---------- Original Method ----------
        //mCM.getPreferredNetworkType(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.596 -0400", hash_original_method = "1E1783F8116903E275F3EB4645F9C2EE", hash_generated_method = "0D9E790D9EF1F6A970AA32B94A24C066")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getSmscAddress(Message result) {
        dsTaint.addTaint(result.dsTaint);
        mCM.getSmscAddress(result);
        // ---------- Original Method ----------
        //mCM.getSmscAddress(result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.596 -0400", hash_original_method = "4D63BDB7F30F381F077564B4D4894249", hash_generated_method = "805E66B477FF25E4B7233D111F164AB3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSmscAddress(String address, Message result) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(address);
        mCM.setSmscAddress(address, result);
        // ---------- Original Method ----------
        //mCM.setSmscAddress(address, result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.596 -0400", hash_original_method = "63C869993C8085EA489C8231FED76E37", hash_generated_method = "2CC51504783343760E715A7F5F16DEB2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTTYMode(int ttyMode, Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(ttyMode);
        mCM.setTTYMode(ttyMode, onComplete);
        // ---------- Original Method ----------
        //mCM.setTTYMode(ttyMode, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.596 -0400", hash_original_method = "2CF2C1C8F165F7A0D032A77B44E87766", hash_generated_method = "F7397AE6161464279B8ED27EC5238A72")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void queryTTYMode(Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        mCM.queryTTYMode(onComplete);
        // ---------- Original Method ----------
        //mCM.queryTTYMode(onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.596 -0400", hash_original_method = "5E8CBEA5609C7848D9FB026D7FBB8ABD", hash_generated_method = "196C72A12B084DA2B24E9D0C167BF20E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void enableEnhancedVoicePrivacy(boolean enable, Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(enable);
        logUnexpectedCdmaMethodCall("enableEnhancedVoicePrivacy");
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("enableEnhancedVoicePrivacy");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.597 -0400", hash_original_method = "33AF0BA0508B34DC6251B1288B05B827", hash_generated_method = "3013D4D15419EDE30CEEDF4574866EBD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getEnhancedVoicePrivacy(Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        logUnexpectedCdmaMethodCall("getEnhancedVoicePrivacy");
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("getEnhancedVoicePrivacy");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.597 -0400", hash_original_method = "89D25AC6FB0D0D55BD65CF567206F30D", hash_generated_method = "C970AD1850D259984FEACA91081A13A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setBandMode(int bandMode, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(bandMode);
        mCM.setBandMode(bandMode, response);
        // ---------- Original Method ----------
        //mCM.setBandMode(bandMode, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.597 -0400", hash_original_method = "83F6C692B5B60F1074FC39097E38CED5", hash_generated_method = "00F376B7551BF1D770B023F5304E44D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void queryAvailableBandMode(Message response) {
        dsTaint.addTaint(response.dsTaint);
        mCM.queryAvailableBandMode(response);
        // ---------- Original Method ----------
        //mCM.queryAvailableBandMode(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.597 -0400", hash_original_method = "13F8DD451E5397866EEA2E2D05CD7BB9", hash_generated_method = "658C4917476FEB34E85E3E9496ADADBD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void invokeOemRilRequestRaw(byte[] data, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(data[0]);
        mCM.invokeOemRilRequestRaw(data, response);
        // ---------- Original Method ----------
        //mCM.invokeOemRilRequestRaw(data, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.597 -0400", hash_original_method = "FF2E1FA4CC9C1321FDC1F9CFA6F4625A", hash_generated_method = "1D43571E42E847745CD442D952B05DAF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void invokeOemRilRequestStrings(String[] strings, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(strings[0]);
        mCM.invokeOemRilRequestStrings(strings, response);
        // ---------- Original Method ----------
        //mCM.invokeOemRilRequestStrings(strings, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.597 -0400", hash_original_method = "FF7C38607D5C4F28572FCAAA94A2F244", hash_generated_method = "3F05111CC8235C6253E2D7363CB24A45")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void notifyDataActivity() {
        mNotifier.notifyDataActivity(this);
        // ---------- Original Method ----------
        //mNotifier.notifyDataActivity(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.598 -0400", hash_original_method = "CD8E1DAAFB356590CE946A9A3EFA7BF6", hash_generated_method = "B7C2EB789B8EA18ED6CFD98FF729A3E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void notifyMessageWaitingIndicator() {
        mNotifier.notifyMessageWaitingChanged(this);
        // ---------- Original Method ----------
        //if (!mIsVoiceCapable)
            //return;
        //mNotifier.notifyMessageWaitingChanged(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.598 -0400", hash_original_method = "B949430324D30DD706A09A11AE93C217", hash_generated_method = "ABB67B831CCF25519E65E69467F66D08")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void notifyDataConnection(String reason, String apnType,
            Phone.DataState state) {
        dsTaint.addTaint(reason);
        dsTaint.addTaint(state.dsTaint);
        dsTaint.addTaint(apnType);
        mNotifier.notifyDataConnection(this, reason, apnType, state);
        // ---------- Original Method ----------
        //mNotifier.notifyDataConnection(this, reason, apnType, state);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.598 -0400", hash_original_method = "FACBD8427065A5D42D63A885B3F07753", hash_generated_method = "44B6B10F6806489B9D29AB7CA6109FB8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void notifyDataConnection(String reason, String apnType) {
        dsTaint.addTaint(reason);
        dsTaint.addTaint(apnType);
        mNotifier.notifyDataConnection(this, reason, apnType, getDataConnectionState(apnType));
        // ---------- Original Method ----------
        //mNotifier.notifyDataConnection(this, reason, apnType, getDataConnectionState(apnType));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.614 -0400", hash_original_method = "0547766DA98E44E8B89F2461696DDA6A", hash_generated_method = "D340B9C3DA809150F1EFCE48C6601E12")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void notifyDataConnection(String reason) {
        dsTaint.addTaint(reason);
        String types[];
        types = getActiveApnTypes();
        {
            String apnType = types[0];
            {
                mNotifier.notifyDataConnection(this, reason, apnType, getDataConnectionState(apnType));
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //String types[] = getActiveApnTypes();
        //for (String apnType : types) {
            //mNotifier.notifyDataConnection(this, reason, apnType, getDataConnectionState(apnType));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.615 -0400", hash_original_method = "68DB92920F159FB7A2995379683DC8DE", hash_generated_method = "EC6B671A74B0BF80801FF906B2679334")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void notifyOtaspChanged(int otaspMode) {
        dsTaint.addTaint(otaspMode);
        mNotifier.notifyOtaspChanged(this, otaspMode);
        // ---------- Original Method ----------
        //mNotifier.notifyOtaspChanged(this, otaspMode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.615 -0400", hash_original_method = "EBE7791CDB6F228DD3645706A64042D5", hash_generated_method = "E4F90F8A895E3886D7C22525E4F767C7")
    @DSModeled(DSC.SAFE)
    public boolean isInEmergencyCall() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.615 -0400", hash_original_method = "2D052AB13CFF7511C3F5373523EDFF5B", hash_generated_method = "5EC99082D22BE6FAE76534E4CAFD762A")
    @DSModeled(DSC.SAFE)
    public boolean isInEcm() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    public abstract String getPhoneName();

    
    public abstract int getPhoneType();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.616 -0400", hash_original_method = "91CE395C2B1A59CCA21CB689DCBFE10B", hash_generated_method = "6055A2D1BE67C4F564C86B75CBF0D262")
    @DSModeled(DSC.SAFE)
    public int getVoiceMessageCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.616 -0400", hash_original_method = "A48905F669D5C197EA0EF66127013B06", hash_generated_method = "1152FA99963FCAC5D3DA58E21D474F07")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getCdmaEriIconIndex() {
        logUnexpectedCdmaMethodCall("getCdmaEriIconIndex");
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("getCdmaEriIconIndex");
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.616 -0400", hash_original_method = "F2685CF828A9991D177F425CEE905936", hash_generated_method = "10576C55C0B72377DC49319EC5CB52A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getCdmaEriIconMode() {
        logUnexpectedCdmaMethodCall("getCdmaEriIconMode");
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("getCdmaEriIconMode");
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.617 -0400", hash_original_method = "B9212A70F84EE88792E9F77579D252EB", hash_generated_method = "868D77E209EF1A255E012B7C79C6B249")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getCdmaEriText() {
        logUnexpectedCdmaMethodCall("getCdmaEriText");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("getCdmaEriText");
        //return "GSM nw, no ERI";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.617 -0400", hash_original_method = "31C17E46EDF55F22A4F7752D6C0E6244", hash_generated_method = "45F7C85CAB0E0EFF1E285D25FD24668E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getCdmaMin() {
        logUnexpectedCdmaMethodCall("getCdmaMin");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("getCdmaMin");
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.617 -0400", hash_original_method = "5ED51837BFBC47DED520188DB45BE3ED", hash_generated_method = "BC158DD3C9CEC52CC32FBDDACD292F77")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isMinInfoReady() {
        logUnexpectedCdmaMethodCall("isMinInfoReady");
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("isMinInfoReady");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.617 -0400", hash_original_method = "A959C6A3260B45047463EF5F7B599FA2", hash_generated_method = "F2254E0E815B628D6E10A1688575E50E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getCdmaPrlVersion() {
        logUnexpectedCdmaMethodCall("getCdmaPrlVersion");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("getCdmaPrlVersion");
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.617 -0400", hash_original_method = "2891F3B114A0E9671C3D7B6F8CA784DA", hash_generated_method = "82D0B403FA79DC755C47EAB0DB46D780")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendBurstDtmf(String dtmfString, int on, int off, Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(off);
        dsTaint.addTaint(on);
        dsTaint.addTaint(dtmfString);
        logUnexpectedCdmaMethodCall("sendBurstDtmf");
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("sendBurstDtmf");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.618 -0400", hash_original_method = "1233D801AF5BD64366571B89C874921A", hash_generated_method = "C419AD7983ACE1A8CECC53CA8062906D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void exitEmergencyCallbackMode() {
        logUnexpectedCdmaMethodCall("exitEmergencyCallbackMode");
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("exitEmergencyCallbackMode");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.618 -0400", hash_original_method = "A559D3AF3D26E6025D0072F9A69D12D5", hash_generated_method = "E844B06E0AA197D378E89610C9A06856")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForCdmaOtaStatusChange(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        logUnexpectedCdmaMethodCall("registerForCdmaOtaStatusChange");
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("registerForCdmaOtaStatusChange");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.618 -0400", hash_original_method = "ECF4F8F98FA1956C40263AEBA8AA4F0E", hash_generated_method = "AF8E9BDD923384F7D1C77799CEB04C82")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForCdmaOtaStatusChange(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        logUnexpectedCdmaMethodCall("unregisterForCdmaOtaStatusChange");
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("unregisterForCdmaOtaStatusChange");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.618 -0400", hash_original_method = "D0126A4408C76F0C8443237E283C8B7B", hash_generated_method = "1BCB266849FF92CC6DF38A25621E9A68")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForSubscriptionInfoReady(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        logUnexpectedCdmaMethodCall("registerForSubscriptionInfoReady");
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("registerForSubscriptionInfoReady");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.619 -0400", hash_original_method = "87FC8275C239D995B7197317524E9D40", hash_generated_method = "5E7F6CC74DBCF40DAD5165EEFE0468A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForSubscriptionInfoReady(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        logUnexpectedCdmaMethodCall("unregisterForSubscriptionInfoReady");
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("unregisterForSubscriptionInfoReady");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.620 -0400", hash_original_method = "08A6E4B71FA09531A80AE7640F0ED8FC", hash_generated_method = "5E512AF1432DDA1E803A60D0438B9C5E")
    @DSModeled(DSC.SAFE)
    public boolean needsOtaServiceProvisioning() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.621 -0400", hash_original_method = "A73C77982F42451CD95F88A8474FB403", hash_generated_method = "C5041FAA832DD907DC45A67591A1A5E7")
    @DSModeled(DSC.SAFE)
    public boolean isOtaSpNumber(String dialStr) {
        dsTaint.addTaint(dialStr);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.621 -0400", hash_original_method = "663CEDCAC596E020E0D8D3DEB84218C7", hash_generated_method = "4A99D9EBE489726EBE380E823DF4E999")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForCallWaiting(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        logUnexpectedCdmaMethodCall("registerForCallWaiting");
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("registerForCallWaiting");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.621 -0400", hash_original_method = "6A9877CFE858A21BAD2DF20E221EE6F8", hash_generated_method = "5240E266DE8E2885EDCC50397033190B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForCallWaiting(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        logUnexpectedCdmaMethodCall("unregisterForCallWaiting");
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("unregisterForCallWaiting");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.622 -0400", hash_original_method = "DCA99E7B790465429FB14A326BDABF1A", hash_generated_method = "5CDF3E3BF078BCD2E003A86C62F40AA7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForEcmTimerReset(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        logUnexpectedCdmaMethodCall("registerForEcmTimerReset");
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("registerForEcmTimerReset");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.622 -0400", hash_original_method = "7FC556E6839E1551B3AA1598A94EB641", hash_generated_method = "55C5DEC16A640291CF19E6CDD28C56F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForEcmTimerReset(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        logUnexpectedCdmaMethodCall("unregisterForEcmTimerReset");
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("unregisterForEcmTimerReset");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.622 -0400", hash_original_method = "9EA1B9B633F04B4B40F6D988C6C6EAE0", hash_generated_method = "15B27A8B820BCC87F4966A7865823D84")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForSignalInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mCM.registerForSignalInfo(h, what, obj);
        // ---------- Original Method ----------
        //mCM.registerForSignalInfo(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.623 -0400", hash_original_method = "490F0951818D5A292B4D850AA9A9557C", hash_generated_method = "B5AA7FDC6FAE3AC803BF1403B39ADED0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForSignalInfo(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mCM.unregisterForSignalInfo(h);
        // ---------- Original Method ----------
        //mCM.unregisterForSignalInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.623 -0400", hash_original_method = "9A93FB64A77E8F3AD75482A91959C175", hash_generated_method = "523C7CC12A0036C22514A09F52782632")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForDisplayInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mCM.registerForDisplayInfo(h, what, obj);
        // ---------- Original Method ----------
        //mCM.registerForDisplayInfo(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.623 -0400", hash_original_method = "1D7139AB5835E964A2112E0A96A55533", hash_generated_method = "3A01C55FE8FEF68FC2CD19E9B57D8578")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForDisplayInfo(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mCM.unregisterForDisplayInfo(h);
        // ---------- Original Method ----------
        //mCM.unregisterForDisplayInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.623 -0400", hash_original_method = "735A13B0D1CB0B503F36D15D851EF79F", hash_generated_method = "F00F278274EF7640B3387FE5BDD1AE78")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForNumberInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mCM.registerForNumberInfo(h, what, obj);
        // ---------- Original Method ----------
        //mCM.registerForNumberInfo(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.623 -0400", hash_original_method = "6DBE3FA0B44D5F0F3EA0C4D2C4C9DEA2", hash_generated_method = "7F78DD92C0567FDA467B390C2EC4DC7F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForNumberInfo(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mCM.unregisterForNumberInfo(h);
        // ---------- Original Method ----------
        //mCM.unregisterForNumberInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.624 -0400", hash_original_method = "D3A5B2415D3398E5BAA61633747135F3", hash_generated_method = "904FC23D2EE3188151D0212CB7116626")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForRedirectedNumberInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mCM.registerForRedirectedNumberInfo(h, what, obj);
        // ---------- Original Method ----------
        //mCM.registerForRedirectedNumberInfo(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.624 -0400", hash_original_method = "FEE62A9F06FB60B95297A2B9A46AFB0E", hash_generated_method = "9CD18F21E4C045D42FF8CA6E860C6460")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForRedirectedNumberInfo(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mCM.unregisterForRedirectedNumberInfo(h);
        // ---------- Original Method ----------
        //mCM.unregisterForRedirectedNumberInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.624 -0400", hash_original_method = "73B61604D8C534BA3038C74FC6F1FC84", hash_generated_method = "60CADF00A811ABD717CE1C5ABCB6CC57")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForLineControlInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mCM.registerForLineControlInfo( h, what, obj);
        // ---------- Original Method ----------
        //mCM.registerForLineControlInfo( h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.624 -0400", hash_original_method = "5D4E66E94B3A48B485E9B9F7921C3B01", hash_generated_method = "EBE3DC917EBC5FD7ACD80432B970702B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForLineControlInfo(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mCM.unregisterForLineControlInfo(h);
        // ---------- Original Method ----------
        //mCM.unregisterForLineControlInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.624 -0400", hash_original_method = "590438B1B11ADBD08E7A44131058572B", hash_generated_method = "D9BBFCC4CB1D57B0F9364EAE9FDAAC7D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerFoT53ClirlInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mCM.registerFoT53ClirlInfo(h, what, obj);
        // ---------- Original Method ----------
        //mCM.registerFoT53ClirlInfo(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.625 -0400", hash_original_method = "034ED9AF183776C78D98034D25F265A2", hash_generated_method = "8C6B12994C84CF1D29D11B84BAA67B85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForT53ClirInfo(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mCM.unregisterForT53ClirInfo(h);
        // ---------- Original Method ----------
        //mCM.unregisterForT53ClirInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.625 -0400", hash_original_method = "66D030845270A8F126DBBDF302E2A141", hash_generated_method = "3B29556FA49E84B0C04ABA7E109B557B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForT53AudioControlInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mCM.registerForT53AudioControlInfo( h, what, obj);
        // ---------- Original Method ----------
        //mCM.registerForT53AudioControlInfo( h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.625 -0400", hash_original_method = "C4F9238B8E9649490800210FA099DE0F", hash_generated_method = "6E314ED2C407AEC97D01C1871DC36F29")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForT53AudioControlInfo(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mCM.unregisterForT53AudioControlInfo(h);
        // ---------- Original Method ----------
        //mCM.unregisterForT53AudioControlInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.625 -0400", hash_original_method = "815749C135EEAFF1973468BF7BE05E75", hash_generated_method = "DC038C2CD27DAF0C595C34BAC8A6A630")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnEcbModeExitResponse(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        logUnexpectedCdmaMethodCall("setOnEcbModeExitResponse");
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("setOnEcbModeExitResponse");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.625 -0400", hash_original_method = "ECE14734C7F2F497945A22923EF26B0A", hash_generated_method = "825CE24ADD794586B60DC8B065630511")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unsetOnEcbModeExitResponse(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        logUnexpectedCdmaMethodCall("unsetOnEcbModeExitResponse");
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("unsetOnEcbModeExitResponse");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.626 -0400", hash_original_method = "04CB7EBB1F2C2F5A1F94C891E246EC01", hash_generated_method = "4BAE47807431E6A518E23DF9F54D044A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getActiveApnTypes() {
        String[] var905F9282CFCC2CBA712022EFC59B1EE0_160175858 = (mDataConnectionTracker.getActiveApnTypes());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return mDataConnectionTracker.getActiveApnTypes();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.626 -0400", hash_original_method = "D30362481D576467EFD2166079686420", hash_generated_method = "9E446533891A1A304B2B96364A470219")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getActiveApnHost(String apnType) {
        dsTaint.addTaint(apnType);
        String var38A0D074A292E089B08AC627AC3CB1DA_369252595 = (mDataConnectionTracker.getActiveApnString(apnType));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mDataConnectionTracker.getActiveApnString(apnType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.626 -0400", hash_original_method = "C11066F2623E480AC3C630C6CBD36058", hash_generated_method = "150F5A1B9E2E4B403B0C01DF6BD5837B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkProperties getLinkProperties(String apnType) {
        dsTaint.addTaint(apnType);
        LinkProperties var3DC8B02C1E8BFDA46BF7973961BEC938_949196508 = (mDataConnectionTracker.getLinkProperties(apnType));
        return (LinkProperties)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mDataConnectionTracker.getLinkProperties(apnType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.626 -0400", hash_original_method = "035A2689990E07C724064B64E344B05A", hash_generated_method = "8BCEEBEA149334707351B0F323B1AD8C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkCapabilities getLinkCapabilities(String apnType) {
        dsTaint.addTaint(apnType);
        LinkCapabilities varA457917684ECB615E7E4E6E7BBB4D959_1477978664 = (mDataConnectionTracker.getLinkCapabilities(apnType));
        return (LinkCapabilities)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mDataConnectionTracker.getLinkCapabilities(apnType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.626 -0400", hash_original_method = "8FC26686EA9F953DFAC2E032B4ED9578", hash_generated_method = "57AE7EB1E2B1E4BECC2ACE14B14FC98B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int enableApnType(String type) {
        dsTaint.addTaint(type);
        int varDF3C53CB85D858230747E36923D6A726_89326096 = (mDataConnectionTracker.enableApnType(type));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mDataConnectionTracker.enableApnType(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.636 -0400", hash_original_method = "EEF84E670D69A41297DD287EFE00D426", hash_generated_method = "B473CAC84EFB406E7BA72F85EB1047F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int disableApnType(String type) {
        dsTaint.addTaint(type);
        int var6C853F768C2F44BB0E963400679EF2D6_535527366 = (mDataConnectionTracker.disableApnType(type));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mDataConnectionTracker.disableApnType(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.636 -0400", hash_original_method = "0E7DDF56B2AD7D089B639A5A4C8707B8", hash_generated_method = "C4C0B8765D317F4654F561C1300BC3F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isDataConnectivityPossible() {
        boolean var72302C29A137970B018198D274956B4F_1848784472 = (isDataConnectivityPossible(Phone.APN_TYPE_DEFAULT));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isDataConnectivityPossible(Phone.APN_TYPE_DEFAULT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.637 -0400", hash_original_method = "D1C4C7300A786DB2DE96913E45D224C3", hash_generated_method = "65BE3E2E575C47E91ADF58F7E7C0994A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isDataConnectivityPossible(String apnType) {
        dsTaint.addTaint(apnType);
        boolean varDADABF19322860B2D8E43DBCBAC0403E_930793045 = (((mDataConnectionTracker != null) &&
                (mDataConnectionTracker.isDataPossible(apnType))));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ((mDataConnectionTracker != null) &&
                //(mDataConnectionTracker.isDataPossible(apnType)));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.638 -0400", hash_original_method = "78C210B796AC9661779AB486B8F70A37", hash_generated_method = "9B54317B2A46615E451EE2C81957B06B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void notifyNewRingingConnectionP(Connection cn) {
        dsTaint.addTaint(cn.dsTaint);
        AsyncResult ar;
        ar = new AsyncResult(null, cn, null);
        mNewRingingConnectionRegistrants.notifyRegistrants(ar);
        // ---------- Original Method ----------
        //if (!mIsVoiceCapable)
            //return;
        //AsyncResult ar = new AsyncResult(null, cn, null);
        //mNewRingingConnectionRegistrants.notifyRegistrants(ar);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.638 -0400", hash_original_method = "E77A37BE6BEB7ED310F1875BE08F1BE3", hash_generated_method = "E3A5356587E625E501757FB995E452BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void notifyIncomingRing() {
        AsyncResult ar;
        ar = new AsyncResult(null, this, null);
        mIncomingRingRegistrants.notifyRegistrants(ar);
        // ---------- Original Method ----------
        //if (!mIsVoiceCapable)
            //return;
        //AsyncResult ar = new AsyncResult(null, this, null);
        //mIncomingRingRegistrants.notifyRegistrants(ar);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.639 -0400", hash_original_method = "E1A10981C368CA09B703B9716F98BBE5", hash_generated_method = "513CAAA7818AF6B5FBC17602DC4E6CAB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sendIncomingCallRingNotification(int token) {
        dsTaint.addTaint(token);
        {
            Log.d(LOG_TAG, "Sending notifyIncomingRing");
            notifyIncomingRing();
            sendMessageDelayed(
                    obtainMessage(EVENT_CALL_RING_CONTINUE, token, 0), mCallRingDelay);
        } //End block
        {
            Log.d(LOG_TAG, "Ignoring ring notification request,"
                    + " mDoesRilSendMultipleCallRing=" + mDoesRilSendMultipleCallRing
                    + " token=" + token
                    + " mCallRingContinueToken=" + mCallRingContinueToken
                    + " mIsVoiceCapable=" + mIsVoiceCapable);
        } //End block
        // ---------- Original Method ----------
        //if (mIsVoiceCapable && !mDoesRilSendMultipleCallRing &&
                //(token == mCallRingContinueToken)) {
            //Log.d(LOG_TAG, "Sending notifyIncomingRing");
            //notifyIncomingRing();
            //sendMessageDelayed(
                    //obtainMessage(EVENT_CALL_RING_CONTINUE, token, 0), mCallRingDelay);
        //} else {
            //Log.d(LOG_TAG, "Ignoring ring notification request,"
                    //+ " mDoesRilSendMultipleCallRing=" + mDoesRilSendMultipleCallRing
                    //+ " token=" + token
                    //+ " mCallRingContinueToken=" + mCallRingContinueToken
                    //+ " mIsVoiceCapable=" + mIsVoiceCapable);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.639 -0400", hash_original_method = "3242BA07687ED62C3518200E2F9FB53F", hash_generated_method = "D69676CE637C0F86769DD7F82E49F70E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isCspPlmnEnabled() {
        logUnexpectedGsmMethodCall("isCspPlmnEnabled");
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //logUnexpectedGsmMethodCall("isCspPlmnEnabled");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.639 -0400", hash_original_method = "B1975F1CE49D1493C79D22CB0A320E47", hash_generated_method = "E8A369DBAE1665B731410B8122C3B53B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IsimRecords getIsimRecords() {
        return (IsimRecords)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "getIsimRecords() is only supported on LTE devices");
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.639 -0400", hash_original_method = "0D543BE7AD53581775829ADD7A6346BC", hash_generated_method = "7EC187F47821D7257E04014F36421AD0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void requestIsimAuthentication(String nonce, Message result) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(nonce);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "requestIsimAuthentication() is only supported on LTE devices");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.640 -0400", hash_original_method = "60A69213567A9812671ADC8B66C5585F", hash_generated_method = "CC79BC9B56372510E727EB14C7E38D6A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getMsisdn() {
        logUnexpectedGsmMethodCall("getMsisdn");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //logUnexpectedGsmMethodCall("getMsisdn");
        //return null;
    }

    
        private static void logUnexpectedCdmaMethodCall(String name) {
        Log.e(LOG_TAG, "Error! " + name + "() in PhoneBase should not be " +
                "called, CDMAPhone inactive.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.640 -0400", hash_original_method = "3916B54807B55A36DB6B185AF3F43F9B", hash_generated_method = "1C15810B597E2FA0B2A0B123D0547ED0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DataState getDataConnectionState() {
        DataState var707DB245DFCD57192F33B108AA62A65B_1038833569 = (getDataConnectionState(APN_TYPE_DEFAULT));
        return (DataState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getDataConnectionState(APN_TYPE_DEFAULT);
    }

    
        private static void logUnexpectedGsmMethodCall(String name) {
        Log.e(LOG_TAG, "Error! " + name + "() in PhoneBase should not be " +
                "called, GSMPhone inactive.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.641 -0400", hash_original_method = "3E0F86392A957104B8FBDE9CC6F59C4C", hash_generated_method = "58BFBC231130793F6A272E782A5696DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void notifyCallForwardingIndicator() {
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "Error! This function should never be executed, inactive CDMAPhone.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.641 -0400", hash_original_method = "920CBD0242A41CC292CB0CFE1F874523", hash_generated_method = "C36A2C5E8FBDCC178A63FADD30F7CBFE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void notifyDataConnectionFailed(String reason, String apnType) {
        dsTaint.addTaint(reason);
        dsTaint.addTaint(apnType);
        mNotifier.notifyDataConnectionFailed(this, reason, apnType);
        // ---------- Original Method ----------
        //mNotifier.notifyDataConnectionFailed(this, reason, apnType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.641 -0400", hash_original_method = "1FC25F07E17A01F63F573F1677883F29", hash_generated_method = "930623956BD28184A4707AF4E9B4151F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getLteOnCdmaMode() {
        int var5CFC37F2D9C4A6A0C98F9CAA2D688F1A_1812972872 = (mCM.getLteOnCdmaMode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mCM.getLteOnCdmaMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.641 -0400", hash_original_method = "B0657B144D34E1997F6D522B080186C1", hash_generated_method = "34413DC8BFBA83D509626D39E043F623")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setVoiceMessageWaiting(int line, int countWaiting) {
        dsTaint.addTaint(countWaiting);
        dsTaint.addTaint(line);
        mIccRecords.setVoiceMessageWaiting(line, countWaiting);
        // ---------- Original Method ----------
        //mIccRecords.setVoiceMessageWaiting(line, countWaiting);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.642 -0400", hash_original_method = "099D11C8CFE57EFDDC5741548A2AEB3D", hash_generated_method = "A7B77E652F94672D100EF53CBD73C1D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public UsimServiceTable getUsimServiceTable() {
        UsimServiceTable var7D90000EECE75C4F17D441F879A68272_522576582 = (mIccRecords.getUsimServiceTable());
        return (UsimServiceTable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mIccRecords.getUsimServiceTable();
    }

    
    private static final String LOG_TAG = "PHONE";
    private static final boolean LOCAL_DEBUG = true;
    public static final String NETWORK_SELECTION_KEY = "network_selection_key";
    public static final String NETWORK_SELECTION_NAME_KEY = "network_selection_name_key";
    public static final String DATA_DISABLED_ON_BOOT_KEY = "disabled_on_boot_key";
    protected static final int EVENT_RADIO_AVAILABLE             = 1;
    protected static final int EVENT_SSN                         = 2;
    protected static final int EVENT_SIM_RECORDS_LOADED          = 3;
    protected static final int EVENT_MMI_DONE                    = 4;
    protected static final int EVENT_RADIO_ON                    = 5;
    protected static final int EVENT_GET_BASEBAND_VERSION_DONE   = 6;
    protected static final int EVENT_USSD                        = 7;
    protected static final int EVENT_RADIO_OFF_OR_NOT_AVAILABLE  = 8;
    protected static final int EVENT_GET_IMEI_DONE               = 9;
    protected static final int EVENT_GET_IMEISV_DONE             = 10;
    protected static final int EVENT_GET_SIM_STATUS_DONE         = 11;
    protected static final int EVENT_SET_CALL_FORWARD_DONE       = 12;
    protected static final int EVENT_GET_CALL_FORWARD_DONE       = 13;
    protected static final int EVENT_CALL_RING                   = 14;
    protected static final int EVENT_CALL_RING_CONTINUE          = 15;
    protected static final int EVENT_SET_NETWORK_MANUAL_COMPLETE    = 16;
    protected static final int EVENT_SET_NETWORK_AUTOMATIC_COMPLETE = 17;
    protected static final int EVENT_SET_CLIR_COMPLETE              = 18;
    protected static final int EVENT_REGISTERED_TO_NETWORK          = 19;
    protected static final int EVENT_SET_VM_NUMBER_DONE             = 20;
    protected static final int EVENT_GET_DEVICE_IDENTITY_DONE       = 21;
    protected static final int EVENT_RUIM_RECORDS_LOADED            = 22;
    protected static final int EVENT_NV_READY                       = 23;
    protected static final int EVENT_SET_ENHANCED_VP                = 24;
    protected static final int EVENT_EMERGENCY_CALLBACK_MODE_ENTER  = 25;
    protected static final int EVENT_EXIT_EMERGENCY_CALLBACK_RESPONSE = 26;
    public static final String CLIR_KEY = "clir_key";
    public static final String DNS_SERVER_CHECK_DISABLED_KEY = "dns_server_check_disabled_key";
}

