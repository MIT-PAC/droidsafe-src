package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    protected final RegistrantList mPreciseCallStateRegistrants
            = new RegistrantList();
    protected final RegistrantList mNewRingingConnectionRegistrants
            = new RegistrantList();
    protected final RegistrantList mIncomingRingRegistrants
            = new RegistrantList();
    protected final RegistrantList mDisconnectRegistrants
            = new RegistrantList();
    protected final RegistrantList mServiceStateRegistrants
            = new RegistrantList();
    protected final RegistrantList mMmiCompleteRegistrants
            = new RegistrantList();
    protected final RegistrantList mMmiRegistrants
            = new RegistrantList();
    protected final RegistrantList mUnknownConnectionRegistrants
            = new RegistrantList();
    protected final RegistrantList mSuppServiceFailedRegistrants
            = new RegistrantList();
    protected Looper mLooper;
    protected final Context mContext;
    protected PhoneNotifier mNotifier;
    protected SimulatedRadioControl mSimulatedRadioControl;
    boolean mUnitTestMode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.361 -0400", hash_original_method = "0B01EDD7CFA10DA565A9E13F0B7F18B5", hash_generated_method = "0F43C6BA9CC209EB9DEB839B67D44DC1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected PhoneBase(PhoneNotifier notifier, Context context, CommandsInterface ci) {
        this(notifier, context, ci, false);
        dsTaint.addTaint(notifier.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(ci.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.361 -0400", hash_original_method = "0B181FBA64FE5D093F6319BFF754183A", hash_generated_method = "50536A277E9C9B7973ECF3E15553C210")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected PhoneBase(PhoneNotifier notifier, Context context, CommandsInterface ci,
            boolean unitTestMode) {
        dsTaint.addTaint(unitTestMode);
        dsTaint.addTaint(notifier.dsTaint);
        //dsTaint.addTaint(context.dsTaint);
        mContext = context;
        dsTaint.addTaint(ci.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.361 -0400", hash_original_method = "5E4CE6B07EFCD29EE81659A348140E39", hash_generated_method = "51FFE75E9D9E957520F4C2720DFF0DB7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSystemProperty(String property, String value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(property);
        {
            boolean var70902CF88F4EB5C4A377580704B63A33_818916628 = (getUnitTestMode());
        } //End collapsed parenthetic
        SystemProperties.set(property, value);
        // ---------- Original Method ----------
        //if(getUnitTestMode()) {
            //return;
        //}
        //SystemProperties.set(property, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.361 -0400", hash_original_method = "E6D9767A803FC78FE4F21E8C0AA16E1B", hash_generated_method = "71D4559A361973E3AC3E092C92992721")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.361 -0400", hash_original_method = "AD2C393D4007178071128FB79D198E7A", hash_generated_method = "DE2FE72466CD1D9684B3E69EA9A03A63")
    @DSModeled(DSC.SAFE)
    public void removeReferences() {
        mSmsStorageMonitor = null;
        mSmsUsageMonitor = null;
        // ---------- Original Method ----------
        //mSmsStorageMonitor = null;
        //mSmsUsageMonitor = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.361 -0400", hash_original_method = "DB16D19FE7C055C53AF6F04667B938A9", hash_generated_method = "A2A47E62BCD6285539281C4DEA29B3EB")
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
            boolean var95B9CB18D0624E6EEB44A7D4EE2ACB8D_1336169384 = (getState() == Phone.State.RINGING);
            {
                sendIncomingCallRingNotification(msg.arg1);
            } //End block
        } //End collapsed parenthetic
        //End case EVENT_CALL_RING_CONTINUE 
        //Begin case default 
        throw new RuntimeException("unexpected event not handled");
        //End case default 
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.361 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "9B65AC4EA6CCDDDA341BF99C9DD2713E")
    @DSModeled(DSC.SAFE)
    public Context getContext() {
        return (Context)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.361 -0400", hash_original_method = "6B58AC4FFDA912638B2751BFF719D57B", hash_generated_method = "A3A8D8BBFC6804682CDFF17F45078E65")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.362 -0400", hash_original_method = "26E6CAA04D711DCC258BDCDD2AAE1C53", hash_generated_method = "9E1F080D1B452A8AFDD0C894F7B1F8D2")
    @DSModeled(DSC.SAFE)
    public boolean isDnsCheckDisabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mDnsCheckDisabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.362 -0400", hash_original_method = "97FD2D9125201743A42C7236EAF94A65", hash_generated_method = "91AC92A2457B0EB5FFF71B4DC42F010B")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.362 -0400", hash_original_method = "3468093E0DED2950A146A2A89C89E0C9", hash_generated_method = "218061EF399FF6B14F6D304EC63BD216")
    @DSModeled(DSC.SAFE)
    public void unregisterForPreciseCallStateChanged(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mPreciseCallStateRegistrants.remove(h);
        // ---------- Original Method ----------
        //mPreciseCallStateRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.362 -0400", hash_original_method = "7D1AEC63A120FA3D327FCF14A278BC6F", hash_generated_method = "D95A1B885508B209E5D4A5ECD94BAC23")
    @DSModeled(DSC.SAFE)
    protected void notifyPreciseCallStateChangedP() {
        AsyncResult ar;
        ar = new AsyncResult(null, this, null);
        mPreciseCallStateRegistrants.notifyRegistrants(ar);
        // ---------- Original Method ----------
        //AsyncResult ar = new AsyncResult(null, this, null);
        //mPreciseCallStateRegistrants.notifyRegistrants(ar);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.362 -0400", hash_original_method = "B9AA4FF50180EB9A48B29DB9F5910CE4", hash_generated_method = "4D45984435410373B8A7EA98AF17CC81")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.362 -0400", hash_original_method = "75B09E3F4F0ED781C6A40D2F37829CA0", hash_generated_method = "8063E077E362CD76B3C773E8EB1BDA30")
    @DSModeled(DSC.SAFE)
    public void unregisterForUnknownConnection(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mUnknownConnectionRegistrants.remove(h);
        // ---------- Original Method ----------
        //mUnknownConnectionRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.362 -0400", hash_original_method = "AD1FA3FDB645CF1FEF5A2946EFD96B38", hash_generated_method = "837F8378FB988A08B2A83AF8C1BD39F8")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.362 -0400", hash_original_method = "058A0D079EFCE83305D698FFA7B5D825", hash_generated_method = "ABC4DF3FBE75869D991330C7BB2CBC77")
    @DSModeled(DSC.SAFE)
    public void unregisterForNewRingingConnection(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mNewRingingConnectionRegistrants.remove(h);
        // ---------- Original Method ----------
        //mNewRingingConnectionRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.362 -0400", hash_original_method = "0EC65AF661091C788FEAC732E62723E6", hash_generated_method = "3EF20E83F031FA4D51EBBE723197138E")
    @DSModeled(DSC.SAFE)
    public void registerForInCallVoicePrivacyOn(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mCM.registerForInCallVoicePrivacyOn(h,what,obj);
        // ---------- Original Method ----------
        //mCM.registerForInCallVoicePrivacyOn(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.362 -0400", hash_original_method = "AAF2DABAA6CCE680F9F5730540C91C97", hash_generated_method = "5E82BFE8054A86BA3E461A47C95F1EF4")
    @DSModeled(DSC.SAFE)
    public void unregisterForInCallVoicePrivacyOn(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mCM.unregisterForInCallVoicePrivacyOn(h);
        // ---------- Original Method ----------
        //mCM.unregisterForInCallVoicePrivacyOn(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.362 -0400", hash_original_method = "5EF015768DAEEB9D8933F39BF43636FD", hash_generated_method = "E2E0A19C20F902EDAB5DC3FD13E6E640")
    @DSModeled(DSC.SAFE)
    public void registerForInCallVoicePrivacyOff(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mCM.registerForInCallVoicePrivacyOff(h,what,obj);
        // ---------- Original Method ----------
        //mCM.registerForInCallVoicePrivacyOff(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.362 -0400", hash_original_method = "D5B23AF1D1217C6A3E1625439D35B2E2", hash_generated_method = "8B69F9210499AD12B5BF884367968E27")
    @DSModeled(DSC.SAFE)
    public void unregisterForInCallVoicePrivacyOff(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mCM.unregisterForInCallVoicePrivacyOff(h);
        // ---------- Original Method ----------
        //mCM.unregisterForInCallVoicePrivacyOff(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.362 -0400", hash_original_method = "50A4B0D73C58D3A2BE8105C1A17D2698", hash_generated_method = "B0E965F147C46313BE2821D3D2A0CF8A")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.362 -0400", hash_original_method = "92E2BA35AB0B11C010FD1FF2A8E6A65B", hash_generated_method = "A2AF192FA68E8923309F7CC6E93C4FB2")
    @DSModeled(DSC.SAFE)
    public void unregisterForIncomingRing(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mIncomingRingRegistrants.remove(h);
        // ---------- Original Method ----------
        //mIncomingRingRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.362 -0400", hash_original_method = "2053ED9D2D7BD498A1C704AFBEE337C3", hash_generated_method = "511201AB318664C9DB84E8B3C0887DC4")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.362 -0400", hash_original_method = "77A19CF742BA6691CDA7407600B4E7F3", hash_generated_method = "439DA561BC37C0CD3A4391307307BDD7")
    @DSModeled(DSC.SAFE)
    public void unregisterForDisconnect(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mDisconnectRegistrants.remove(h);
        // ---------- Original Method ----------
        //mDisconnectRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.362 -0400", hash_original_method = "D574E9C9A24655069A0054F4E3538F49", hash_generated_method = "2F7E48148189E05C62930C84076353A0")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.362 -0400", hash_original_method = "C86C69890AF660CD858A7F262F783D04", hash_generated_method = "DD942610ED9BD7A88B49CFCD3D5E72AF")
    @DSModeled(DSC.SAFE)
    public void unregisterForSuppServiceFailed(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mSuppServiceFailedRegistrants.remove(h);
        // ---------- Original Method ----------
        //mSuppServiceFailedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.362 -0400", hash_original_method = "04A8F1C35CFA7005AF5258C29F5FFE2B", hash_generated_method = "A6A31C7ABAB94C4374E7EEB73F17336F")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.363 -0400", hash_original_method = "338E9AA4432AD835C97CF49233FF5692", hash_generated_method = "36227FFAA8346463AB6CEAD864151C84")
    @DSModeled(DSC.SAFE)
    public void unregisterForMmiInitiate(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mMmiRegistrants.remove(h);
        // ---------- Original Method ----------
        //mMmiRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.363 -0400", hash_original_method = "61BE6CB4DF9A0C652F1BC7F7AD4D4CCB", hash_generated_method = "5F79FDB7D46385223FFDFA846B6382AE")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.363 -0400", hash_original_method = "FE25021AB6559853BB3705423F117C85", hash_generated_method = "C736154F4A67C619EF6F36D735358E49")
    @DSModeled(DSC.SAFE)
    public void unregisterForMmiComplete(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        checkCorrectThread(h);
        mMmiCompleteRegistrants.remove(h);
        // ---------- Original Method ----------
        //checkCorrectThread(h);
        //mMmiCompleteRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.363 -0400", hash_original_method = "764E722E685D5D307BCF00BDB294F564", hash_generated_method = "2DFF5F58CA79A6DB1A5F2A92CB610971")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String getSavedNetworkSelection() {
        SharedPreferences sp;
        sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        String var96F22B674EC19CE2850DD24FA26E01FB_1999506498 = (sp.getString(NETWORK_SELECTION_KEY, ""));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        //return sp.getString(NETWORK_SELECTION_KEY, "");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.363 -0400", hash_original_method = "29F19DECCCFC42207CFA8F3911C2D799", hash_generated_method = "7479616CDEF96705B01A8F0A9006EEFA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void restoreSavedNetworkSelection(Message response) {
        dsTaint.addTaint(response.dsTaint);
        String networkSelection;
        networkSelection = getSavedNetworkSelection();
        {
            boolean var7DB33003CA3D238605A26618783283D8_1537349261 = (TextUtils.isEmpty(networkSelection));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.363 -0400", hash_original_method = "347AF2D7A75CED9B3C82A500C1FA5AD6", hash_generated_method = "FDF2A74FEB0FB4800B21537CCF6D824B")
    @DSModeled(DSC.SAFE)
    public void setUnitTestMode(boolean f) {
        dsTaint.addTaint(f);
        // ---------- Original Method ----------
        //mUnitTestMode = f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.363 -0400", hash_original_method = "958D127406A24370C06699E6AB687F2A", hash_generated_method = "883AA338139EE822D453A7C793ED3163")
    @DSModeled(DSC.SAFE)
    public boolean getUnitTestMode() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mUnitTestMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.363 -0400", hash_original_method = "80E90CBCA9EDC240B4F0091FF8E28C26", hash_generated_method = "9DBD3C067DB4FD9B746F425EDE89DDAD")
    @DSModeled(DSC.SAFE)
    protected void notifyDisconnectP(Connection cn) {
        dsTaint.addTaint(cn.dsTaint);
        AsyncResult ar;
        ar = new AsyncResult(null, cn, null);
        mDisconnectRegistrants.notifyRegistrants(ar);
        // ---------- Original Method ----------
        //AsyncResult ar = new AsyncResult(null, cn, null);
        //mDisconnectRegistrants.notifyRegistrants(ar);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.363 -0400", hash_original_method = "BD17CCC0601D2F340E3F675C1E59C4B9", hash_generated_method = "532D5E17BF8B4852D3739CEC2C024823")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.363 -0400", hash_original_method = "5AFF1BE54185C9B4577A75EFF0396B68", hash_generated_method = "2B46AFD2C41CBA96BF040ED8E622024D")
    @DSModeled(DSC.SAFE)
    public void unregisterForServiceStateChanged(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mServiceStateRegistrants.remove(h);
        // ---------- Original Method ----------
        //mServiceStateRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.363 -0400", hash_original_method = "6C50CDA22F8E02023B34911844DFEED2", hash_generated_method = "40D27B5291FDB9675E1D51BBF9341A75")
    @DSModeled(DSC.SAFE)
    public void registerForRingbackTone(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mCM.registerForRingbackTone(h,what,obj);
        // ---------- Original Method ----------
        //mCM.registerForRingbackTone(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.363 -0400", hash_original_method = "475301C04BE08B381350355879425A76", hash_generated_method = "5AF5CDA0139C00DFF53164C85C5D6AD6")
    @DSModeled(DSC.SAFE)
    public void unregisterForRingbackTone(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mCM.unregisterForRingbackTone(h);
        // ---------- Original Method ----------
        //mCM.unregisterForRingbackTone(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.363 -0400", hash_original_method = "6FE1177D9BF24D9A41C1BE1AD2A93980", hash_generated_method = "02D25EEFFD92E704AFFEB34EADC0B896")
    @DSModeled(DSC.SAFE)
    public void registerForResendIncallMute(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mCM.registerForResendIncallMute(h,what,obj);
        // ---------- Original Method ----------
        //mCM.registerForResendIncallMute(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.363 -0400", hash_original_method = "1E28EF1EEBC2208F47A83D89926DE82E", hash_generated_method = "2930AAF32E7B2E2B04D30915962C0622")
    @DSModeled(DSC.SAFE)
    public void unregisterForResendIncallMute(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mCM.unregisterForResendIncallMute(h);
        // ---------- Original Method ----------
        //mCM.unregisterForResendIncallMute(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.363 -0400", hash_original_method = "F34715D262D40C908422031B6920D016", hash_generated_method = "737A242263F3278996B57AB99FFF8E5A")
    @DSModeled(DSC.SAFE)
    public void setEchoSuppressionEnabled(boolean enabled) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(enabled);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.363 -0400", hash_original_method = "D42B19E1304E0F299FEED69470ACF7B6", hash_generated_method = "C8414BF7A47D0803605F0FDE821419B7")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.363 -0400", hash_original_method = "6C132AD700E1EDF5A17434649EDA0F2C", hash_generated_method = "B683453D142B0956727DA92EF74E3E5E")
    @DSModeled(DSC.SAFE)
    public SimulatedRadioControl getSimulatedRadioControl() {
        return (SimulatedRadioControl)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSimulatedRadioControl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.363 -0400", hash_original_method = "930052C83226AF8DE91A3B058305558F", hash_generated_method = "8FE054D3EC66A642AEEB66E0564F11D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkCorrectThread(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        {
            boolean varC80731002783DFD1F9463E965D806130_1996361024 = (h.getLooper() != mLooper);
            {
                throw new RuntimeException(
                    "com.android.internal.telephony.Phone must be used from within one thread");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (h.getLooper() != mLooper) {
            //throw new RuntimeException(
                    //"com.android.internal.telephony.Phone must be used from within one thread");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.364 -0400", hash_original_method = "FDCB651DF17FF9811415182F19CE1B4C", hash_generated_method = "E16FEED78952A6CDA3AE828C6DD89468")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setPropertiesByCarrier() {
        String carrier;
        carrier = SystemProperties.get("ro.carrier");
        {
            boolean var4C71EF3FF41846A3F65598AC0FD7C2DF_401911269 = (null == carrier || 0 == carrier.length() || "unknown".equals(carrier));
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
                    boolean var75425E199AD2683373EB064DEACE952B_1787372530 = (carrier.equals(c));
                    {
                        String l;
                        l = carrierLocales[i+1].toString();
                        String language;
                        language = l.substring(0, 2);
                        String country;
                        country = "";
                        {
                            boolean varF67DA07AFC0B8D9D491D3A93A03DA49E_1466787252 = (l.length() >=5);
                            {
                                country = l.substring(3, 5);
                            } //End block
                        } //End collapsed parenthetic
                        setSystemLocale(language, country, false);
                        {
                            boolean varE322B40A95DAFE52AA6E0E240CD3B924_1494209782 = (!country.isEmpty());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.364 -0400", hash_original_method = "B1CAAC16126A906DDE46004E33C276B7", hash_generated_method = "A019BA56D0A5564BEDFF1894291EC96E")
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
            boolean varE02578713C19A1BF95FEF0FA4F6086A2_139974630 = ((null == l || 0 == l.length()) && (null == c || 0 == c.length()));
            {
                try 
                {
                    String[] locales;
                    locales = mContext.getAssets().getLocales();
                    final int N;
                    N = locales.length;
                    String bestMatch;
                    bestMatch = null;
                    {
                        int i;
                        i = 0;
                        {
                            {
                                boolean varB3910760851B0FD21D5BDE8F0437EA86_1421331808 = (locales[i]!=null && locales[i].length() >= 5 &&
                            locales[i].substring(0,2).equals(language));
                                {
                                    {
                                        boolean varD7C1E0B87149D0FC064FD18A3F2956D9_947339416 = (locales[i].substring(3,5).equals(country));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.364 -0400", hash_original_method = "B77EA67F9749FFFAEC203B31F557B343", hash_generated_method = "5F1BE0665DA5FC79EA3DDF376BD5525B")
    @DSModeled(DSC.SAFE)
    public Handler getHandler() {
        return (Handler)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.364 -0400", hash_original_method = "E9813275B540C23EC4ABDDE1F3F36487", hash_generated_method = "B9E768CD9B126679F0C749E8513A5A29")
    @DSModeled(DSC.SAFE)
    public ServiceStateTracker getServiceStateTracker() {
        return (ServiceStateTracker)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.364 -0400", hash_original_method = "A2CFF60AF23DAF5B5D13432A0E634448", hash_generated_method = "0A9699179FF6CF08514B979241C929C0")
    @DSModeled(DSC.SAFE)
    public CallTracker getCallTracker() {
        return (CallTracker)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.364 -0400", hash_original_method = "E12359725DA3BA4F59BA85FD7E4F143C", hash_generated_method = "7ED83E2E1BAD6257A0D2DB92319C65C0")
    @DSModeled(DSC.SAFE)
    @Override
    public IccCard getIccCard() {
        return (IccCard)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mIccCard;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.364 -0400", hash_original_method = "26C3C4C321ACD0FC593701A52D49E497", hash_generated_method = "61E64E36A5D7AF29F877C88DF7169422")
    @DSModeled(DSC.SAFE)
    @Override
    public String getIccSerialNumber() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mIccRecords.iccid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.365 -0400", hash_original_method = "9078EC96DE8D2AE9C16B88E94341FB99", hash_generated_method = "23EBF65F0709040F5E74F8A021FBC7D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getIccRecordsLoaded() {
        boolean var83CEE5D1173D41B37947C1976F7A6F36_408519626 = (mIccRecords.getRecordsLoaded());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIccRecords.getRecordsLoaded();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.365 -0400", hash_original_method = "1B6614D059F66BD820665EDAF3DE7F9F", hash_generated_method = "812587AAD96B144027D6EE08319665EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getMessageWaitingIndicator() {
        boolean var9905017E0A4EF52F8E7F52DF159D611D_55182128 = (mIccRecords.getVoiceMessageWaiting());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIccRecords.getVoiceMessageWaiting();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.365 -0400", hash_original_method = "EAA51813A27C6D01EBD0F8DD0837A86A", hash_generated_method = "1E4880A93D56465E7E8042F068B860C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getCallForwardingIndicator() {
        boolean varF91C9B7616B652A3A4D61DDBCE0EC0EE_355848858 = (mIccRecords.getVoiceCallForwardingFlag());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIccRecords.getVoiceCallForwardingFlag();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.365 -0400", hash_original_method = "93DCD756C677180103F6D6F7873E6AE7", hash_generated_method = "786F88878DCFFE062C00138275B7AAE1")
    @DSModeled(DSC.SAFE)
    public void queryCdmaRoamingPreference(Message response) {
        dsTaint.addTaint(response.dsTaint);
        mCM.queryCdmaRoamingPreference(response);
        // ---------- Original Method ----------
        //mCM.queryCdmaRoamingPreference(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.365 -0400", hash_original_method = "D1AE94805C952F3809EAEE65E7FED134", hash_generated_method = "57427051F9308DAC8387FF74258BAEB9")
    @DSModeled(DSC.SAFE)
    public void setCdmaRoamingPreference(int cdmaRoamingType, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(cdmaRoamingType);
        mCM.setCdmaRoamingPreference(cdmaRoamingType, response);
        // ---------- Original Method ----------
        //mCM.setCdmaRoamingPreference(cdmaRoamingType, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.365 -0400", hash_original_method = "532B78C8CD74E377483500017A27260E", hash_generated_method = "729ABE65386CE1A21194454B642FE3B6")
    @DSModeled(DSC.SAFE)
    public void setCdmaSubscription(int cdmaSubscriptionType, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(cdmaSubscriptionType);
        mCM.setCdmaSubscriptionSource(cdmaSubscriptionType, response);
        // ---------- Original Method ----------
        //mCM.setCdmaSubscriptionSource(cdmaSubscriptionType, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.365 -0400", hash_original_method = "EA18BAD07370F2F495FB68EDF5CD8C8E", hash_generated_method = "A8B904668068134D99B0B231A9CC3AAC")
    @DSModeled(DSC.SAFE)
    public void setPreferredNetworkType(int networkType, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(networkType);
        mCM.setPreferredNetworkType(networkType, response);
        // ---------- Original Method ----------
        //mCM.setPreferredNetworkType(networkType, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.365 -0400", hash_original_method = "379A4BC143905A2FA132EF757E52297F", hash_generated_method = "C44BA64CD3675DE69E65B680437A22C9")
    @DSModeled(DSC.SAFE)
    public void getPreferredNetworkType(Message response) {
        dsTaint.addTaint(response.dsTaint);
        mCM.getPreferredNetworkType(response);
        // ---------- Original Method ----------
        //mCM.getPreferredNetworkType(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.365 -0400", hash_original_method = "1E1783F8116903E275F3EB4645F9C2EE", hash_generated_method = "893815A4C70DC304F7554521EF7AC387")
    @DSModeled(DSC.SAFE)
    public void getSmscAddress(Message result) {
        dsTaint.addTaint(result.dsTaint);
        mCM.getSmscAddress(result);
        // ---------- Original Method ----------
        //mCM.getSmscAddress(result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.365 -0400", hash_original_method = "4D63BDB7F30F381F077564B4D4894249", hash_generated_method = "B19B5FABEE66B9599EFCE8CC9E192713")
    @DSModeled(DSC.SAFE)
    public void setSmscAddress(String address, Message result) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(address);
        mCM.setSmscAddress(address, result);
        // ---------- Original Method ----------
        //mCM.setSmscAddress(address, result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.365 -0400", hash_original_method = "63C869993C8085EA489C8231FED76E37", hash_generated_method = "E702A19A6C3CB90B8C049DB2ACE1BF6A")
    @DSModeled(DSC.SAFE)
    public void setTTYMode(int ttyMode, Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(ttyMode);
        mCM.setTTYMode(ttyMode, onComplete);
        // ---------- Original Method ----------
        //mCM.setTTYMode(ttyMode, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.365 -0400", hash_original_method = "2CF2C1C8F165F7A0D032A77B44E87766", hash_generated_method = "F3D3BBFA0C615840A1DE1161ECDAC493")
    @DSModeled(DSC.SAFE)
    public void queryTTYMode(Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        mCM.queryTTYMode(onComplete);
        // ---------- Original Method ----------
        //mCM.queryTTYMode(onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.365 -0400", hash_original_method = "5E8CBEA5609C7848D9FB026D7FBB8ABD", hash_generated_method = "21E4B9755F51064B8120E0B3CE421B03")
    @DSModeled(DSC.SAFE)
    public void enableEnhancedVoicePrivacy(boolean enable, Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(enable);
        logUnexpectedCdmaMethodCall("enableEnhancedVoicePrivacy");
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("enableEnhancedVoicePrivacy");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.365 -0400", hash_original_method = "33AF0BA0508B34DC6251B1288B05B827", hash_generated_method = "5861613E6F8AC5C65093D855E788E27C")
    @DSModeled(DSC.SAFE)
    public void getEnhancedVoicePrivacy(Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        logUnexpectedCdmaMethodCall("getEnhancedVoicePrivacy");
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("getEnhancedVoicePrivacy");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.365 -0400", hash_original_method = "89D25AC6FB0D0D55BD65CF567206F30D", hash_generated_method = "7985B96C347BE6687F10AEE227DC65D3")
    @DSModeled(DSC.SAFE)
    public void setBandMode(int bandMode, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(bandMode);
        mCM.setBandMode(bandMode, response);
        // ---------- Original Method ----------
        //mCM.setBandMode(bandMode, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.365 -0400", hash_original_method = "83F6C692B5B60F1074FC39097E38CED5", hash_generated_method = "9D5175AA31472173195A35B4EA6C36A5")
    @DSModeled(DSC.SAFE)
    public void queryAvailableBandMode(Message response) {
        dsTaint.addTaint(response.dsTaint);
        mCM.queryAvailableBandMode(response);
        // ---------- Original Method ----------
        //mCM.queryAvailableBandMode(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.365 -0400", hash_original_method = "13F8DD451E5397866EEA2E2D05CD7BB9", hash_generated_method = "0D34E66B48015884BDF1F9C9F3829A52")
    @DSModeled(DSC.SAFE)
    public void invokeOemRilRequestRaw(byte[] data, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(data);
        mCM.invokeOemRilRequestRaw(data, response);
        // ---------- Original Method ----------
        //mCM.invokeOemRilRequestRaw(data, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.365 -0400", hash_original_method = "FF2E1FA4CC9C1321FDC1F9CFA6F4625A", hash_generated_method = "BD00E156AF58C9797A7A5591CA49141D")
    @DSModeled(DSC.SAFE)
    public void invokeOemRilRequestStrings(String[] strings, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(strings);
        mCM.invokeOemRilRequestStrings(strings, response);
        // ---------- Original Method ----------
        //mCM.invokeOemRilRequestStrings(strings, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.365 -0400", hash_original_method = "FF7C38607D5C4F28572FCAAA94A2F244", hash_generated_method = "BD3FEC214463A7E3FA9F6F3BAA49A9CD")
    @DSModeled(DSC.SAFE)
    public void notifyDataActivity() {
        mNotifier.notifyDataActivity(this);
        // ---------- Original Method ----------
        //mNotifier.notifyDataActivity(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.365 -0400", hash_original_method = "CD8E1DAAFB356590CE946A9A3EFA7BF6", hash_generated_method = "4CC170B07416004C24A22E486EDA6B4D")
    @DSModeled(DSC.SAFE)
    public void notifyMessageWaitingIndicator() {
        mNotifier.notifyMessageWaitingChanged(this);
        // ---------- Original Method ----------
        //if (!mIsVoiceCapable)
            //return;
        //mNotifier.notifyMessageWaitingChanged(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.365 -0400", hash_original_method = "B949430324D30DD706A09A11AE93C217", hash_generated_method = "00B43B491C7CAAC9E70DE743EF943A62")
    @DSModeled(DSC.SAFE)
    public void notifyDataConnection(String reason, String apnType,
            Phone.DataState state) {
        dsTaint.addTaint(reason);
        dsTaint.addTaint(apnType);
        dsTaint.addTaint(state.dsTaint);
        mNotifier.notifyDataConnection(this, reason, apnType, state);
        // ---------- Original Method ----------
        //mNotifier.notifyDataConnection(this, reason, apnType, state);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.365 -0400", hash_original_method = "FACBD8427065A5D42D63A885B3F07753", hash_generated_method = "E328E4B4ED41F33B8DE87CE2CB0BD61F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void notifyDataConnection(String reason, String apnType) {
        dsTaint.addTaint(reason);
        dsTaint.addTaint(apnType);
        mNotifier.notifyDataConnection(this, reason, apnType, getDataConnectionState(apnType));
        // ---------- Original Method ----------
        //mNotifier.notifyDataConnection(this, reason, apnType, getDataConnectionState(apnType));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.366 -0400", hash_original_method = "0547766DA98E44E8B89F2461696DDA6A", hash_generated_method = "D70CA5ACFB9C5DADD4CB2F474909F543")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.366 -0400", hash_original_method = "68DB92920F159FB7A2995379683DC8DE", hash_generated_method = "3AB828A448D1AF955F4438CAAAC60469")
    @DSModeled(DSC.SAFE)
    public void notifyOtaspChanged(int otaspMode) {
        dsTaint.addTaint(otaspMode);
        mNotifier.notifyOtaspChanged(this, otaspMode);
        // ---------- Original Method ----------
        //mNotifier.notifyOtaspChanged(this, otaspMode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.366 -0400", hash_original_method = "EBE7791CDB6F228DD3645706A64042D5", hash_generated_method = "081DC2AC7C26F58ADE86939110EDACA1")
    @DSModeled(DSC.SAFE)
    public boolean isInEmergencyCall() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.366 -0400", hash_original_method = "2D052AB13CFF7511C3F5373523EDFF5B", hash_generated_method = "BAEA531F8F36CC0BFE14ED202C23AD0E")
    @DSModeled(DSC.SAFE)
    public boolean isInEcm() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    public abstract String getPhoneName();

    
    public abstract int getPhoneType();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.366 -0400", hash_original_method = "91CE395C2B1A59CCA21CB689DCBFE10B", hash_generated_method = "D5B7398CCA7805F6512C9669522BC09D")
    @DSModeled(DSC.SAFE)
    public int getVoiceMessageCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.366 -0400", hash_original_method = "A48905F669D5C197EA0EF66127013B06", hash_generated_method = "DA9C2417F3A72BBB12BE0EEE4E42D7E1")
    @DSModeled(DSC.SAFE)
    public int getCdmaEriIconIndex() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        logUnexpectedCdmaMethodCall("getCdmaEriIconIndex");
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("getCdmaEriIconIndex");
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.366 -0400", hash_original_method = "F2685CF828A9991D177F425CEE905936", hash_generated_method = "2F67BE1537BDE95A71E3363E9D465BC9")
    @DSModeled(DSC.SAFE)
    public int getCdmaEriIconMode() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        logUnexpectedCdmaMethodCall("getCdmaEriIconMode");
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("getCdmaEriIconMode");
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.366 -0400", hash_original_method = "B9212A70F84EE88792E9F77579D252EB", hash_generated_method = "910E685B5FD55D78ED81877D75248268")
    @DSModeled(DSC.SAFE)
    public String getCdmaEriText() {
        logUnexpectedCdmaMethodCall("getCdmaEriText");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("getCdmaEriText");
        //return "GSM nw, no ERI";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.366 -0400", hash_original_method = "31C17E46EDF55F22A4F7752D6C0E6244", hash_generated_method = "663CB6ABFEF6C8A8266837E93B5C814B")
    @DSModeled(DSC.SAFE)
    public String getCdmaMin() {
        logUnexpectedCdmaMethodCall("getCdmaMin");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("getCdmaMin");
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.366 -0400", hash_original_method = "5ED51837BFBC47DED520188DB45BE3ED", hash_generated_method = "3FFA38E88A8E07A63AE94FA1A7A0A17D")
    @DSModeled(DSC.SAFE)
    public boolean isMinInfoReady() {
        logUnexpectedCdmaMethodCall("isMinInfoReady");
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("isMinInfoReady");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.366 -0400", hash_original_method = "A959C6A3260B45047463EF5F7B599FA2", hash_generated_method = "7CCF898F6CA8B3F5CCA98676AF663DBB")
    @DSModeled(DSC.SAFE)
    public String getCdmaPrlVersion() {
        logUnexpectedCdmaMethodCall("getCdmaPrlVersion");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("getCdmaPrlVersion");
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.366 -0400", hash_original_method = "2891F3B114A0E9671C3D7B6F8CA784DA", hash_generated_method = "40C0841817B45C242D13B53AE4080597")
    @DSModeled(DSC.SAFE)
    public void sendBurstDtmf(String dtmfString, int on, int off, Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(off);
        dsTaint.addTaint(on);
        dsTaint.addTaint(dtmfString);
        logUnexpectedCdmaMethodCall("sendBurstDtmf");
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("sendBurstDtmf");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.366 -0400", hash_original_method = "1233D801AF5BD64366571B89C874921A", hash_generated_method = "5B7ED07A0818185C3F224FC8A9B3AB93")
    @DSModeled(DSC.SAFE)
    public void exitEmergencyCallbackMode() {
        logUnexpectedCdmaMethodCall("exitEmergencyCallbackMode");
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("exitEmergencyCallbackMode");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.366 -0400", hash_original_method = "A559D3AF3D26E6025D0072F9A69D12D5", hash_generated_method = "EA14F93F67BDB34C98945324F674E0EB")
    @DSModeled(DSC.SAFE)
    public void registerForCdmaOtaStatusChange(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        logUnexpectedCdmaMethodCall("registerForCdmaOtaStatusChange");
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("registerForCdmaOtaStatusChange");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.366 -0400", hash_original_method = "ECF4F8F98FA1956C40263AEBA8AA4F0E", hash_generated_method = "98DC17239651FDA4CD81D9CA67A58EDA")
    @DSModeled(DSC.SAFE)
    public void unregisterForCdmaOtaStatusChange(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        logUnexpectedCdmaMethodCall("unregisterForCdmaOtaStatusChange");
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("unregisterForCdmaOtaStatusChange");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.366 -0400", hash_original_method = "D0126A4408C76F0C8443237E283C8B7B", hash_generated_method = "BC291D574791BC7A61639E28AD18FE68")
    @DSModeled(DSC.SAFE)
    public void registerForSubscriptionInfoReady(Handler h, int what, Object obj) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        logUnexpectedCdmaMethodCall("registerForSubscriptionInfoReady");
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("registerForSubscriptionInfoReady");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.366 -0400", hash_original_method = "87FC8275C239D995B7197317524E9D40", hash_generated_method = "B4F5C80849AF29B85081F506248F0A65")
    @DSModeled(DSC.SAFE)
    public void unregisterForSubscriptionInfoReady(Handler h) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        logUnexpectedCdmaMethodCall("unregisterForSubscriptionInfoReady");
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("unregisterForSubscriptionInfoReady");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.366 -0400", hash_original_method = "08A6E4B71FA09531A80AE7640F0ED8FC", hash_generated_method = "53FFC7845B9FF03FF0BEC0C0EA65CF77")
    @DSModeled(DSC.SAFE)
    public boolean needsOtaServiceProvisioning() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.366 -0400", hash_original_method = "A73C77982F42451CD95F88A8474FB403", hash_generated_method = "4438E96AE366BF1AF06FF82AC558C45F")
    @DSModeled(DSC.SAFE)
    public boolean isOtaSpNumber(String dialStr) {
        dsTaint.addTaint(dialStr);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.366 -0400", hash_original_method = "663CEDCAC596E020E0D8D3DEB84218C7", hash_generated_method = "508D9E4DF8B2D7B40CB16FEC2FF5D5FE")
    @DSModeled(DSC.SAFE)
    public void registerForCallWaiting(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        logUnexpectedCdmaMethodCall("registerForCallWaiting");
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("registerForCallWaiting");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.366 -0400", hash_original_method = "6A9877CFE858A21BAD2DF20E221EE6F8", hash_generated_method = "A99B253DA4BF1A959BED49A8681CB35F")
    @DSModeled(DSC.SAFE)
    public void unregisterForCallWaiting(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        logUnexpectedCdmaMethodCall("unregisterForCallWaiting");
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("unregisterForCallWaiting");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.366 -0400", hash_original_method = "DCA99E7B790465429FB14A326BDABF1A", hash_generated_method = "958FC23EA34F5D945279CEF7206EC59A")
    @DSModeled(DSC.SAFE)
    public void registerForEcmTimerReset(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        logUnexpectedCdmaMethodCall("registerForEcmTimerReset");
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("registerForEcmTimerReset");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.367 -0400", hash_original_method = "7FC556E6839E1551B3AA1598A94EB641", hash_generated_method = "DE71287787DE69297EFDA4562617C1DC")
    @DSModeled(DSC.SAFE)
    public void unregisterForEcmTimerReset(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        logUnexpectedCdmaMethodCall("unregisterForEcmTimerReset");
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("unregisterForEcmTimerReset");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.367 -0400", hash_original_method = "9EA1B9B633F04B4B40F6D988C6C6EAE0", hash_generated_method = "9398B85D7D1125D48236A819C6323BEF")
    @DSModeled(DSC.SAFE)
    public void registerForSignalInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mCM.registerForSignalInfo(h, what, obj);
        // ---------- Original Method ----------
        //mCM.registerForSignalInfo(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.367 -0400", hash_original_method = "490F0951818D5A292B4D850AA9A9557C", hash_generated_method = "F860F925700FECCE996C7B40AB51827B")
    @DSModeled(DSC.SAFE)
    public void unregisterForSignalInfo(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mCM.unregisterForSignalInfo(h);
        // ---------- Original Method ----------
        //mCM.unregisterForSignalInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.367 -0400", hash_original_method = "9A93FB64A77E8F3AD75482A91959C175", hash_generated_method = "312819FA2E216634857A768AFC567EA6")
    @DSModeled(DSC.SAFE)
    public void registerForDisplayInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mCM.registerForDisplayInfo(h, what, obj);
        // ---------- Original Method ----------
        //mCM.registerForDisplayInfo(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.367 -0400", hash_original_method = "1D7139AB5835E964A2112E0A96A55533", hash_generated_method = "6BE235E2FDEED8E0185266C1BB3DFE24")
    @DSModeled(DSC.SAFE)
    public void unregisterForDisplayInfo(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mCM.unregisterForDisplayInfo(h);
        // ---------- Original Method ----------
        //mCM.unregisterForDisplayInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.367 -0400", hash_original_method = "735A13B0D1CB0B503F36D15D851EF79F", hash_generated_method = "3C784479AB0392B624118F3616B4A786")
    @DSModeled(DSC.SAFE)
    public void registerForNumberInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mCM.registerForNumberInfo(h, what, obj);
        // ---------- Original Method ----------
        //mCM.registerForNumberInfo(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.367 -0400", hash_original_method = "6DBE3FA0B44D5F0F3EA0C4D2C4C9DEA2", hash_generated_method = "4EA7D96E253A0CCA3377541EE83FFF2B")
    @DSModeled(DSC.SAFE)
    public void unregisterForNumberInfo(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mCM.unregisterForNumberInfo(h);
        // ---------- Original Method ----------
        //mCM.unregisterForNumberInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.367 -0400", hash_original_method = "D3A5B2415D3398E5BAA61633747135F3", hash_generated_method = "0ED5A3169B0469DB41AD0775CB417119")
    @DSModeled(DSC.SAFE)
    public void registerForRedirectedNumberInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mCM.registerForRedirectedNumberInfo(h, what, obj);
        // ---------- Original Method ----------
        //mCM.registerForRedirectedNumberInfo(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.367 -0400", hash_original_method = "FEE62A9F06FB60B95297A2B9A46AFB0E", hash_generated_method = "D31A237B065E43DA97871922E1749A59")
    @DSModeled(DSC.SAFE)
    public void unregisterForRedirectedNumberInfo(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mCM.unregisterForRedirectedNumberInfo(h);
        // ---------- Original Method ----------
        //mCM.unregisterForRedirectedNumberInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.367 -0400", hash_original_method = "73B61604D8C534BA3038C74FC6F1FC84", hash_generated_method = "43D5E0CA68EBA55F26DABFFF962B8509")
    @DSModeled(DSC.SAFE)
    public void registerForLineControlInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mCM.registerForLineControlInfo( h, what, obj);
        // ---------- Original Method ----------
        //mCM.registerForLineControlInfo( h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.367 -0400", hash_original_method = "5D4E66E94B3A48B485E9B9F7921C3B01", hash_generated_method = "730DF9E2E0F2AF4AA5A59BE9272320AC")
    @DSModeled(DSC.SAFE)
    public void unregisterForLineControlInfo(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mCM.unregisterForLineControlInfo(h);
        // ---------- Original Method ----------
        //mCM.unregisterForLineControlInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.367 -0400", hash_original_method = "590438B1B11ADBD08E7A44131058572B", hash_generated_method = "B28704601C2FCACD37D5C8832D9C42F2")
    @DSModeled(DSC.SAFE)
    public void registerFoT53ClirlInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mCM.registerFoT53ClirlInfo(h, what, obj);
        // ---------- Original Method ----------
        //mCM.registerFoT53ClirlInfo(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.367 -0400", hash_original_method = "034ED9AF183776C78D98034D25F265A2", hash_generated_method = "9669A5BB8A3EE3309289B652D7F96D4F")
    @DSModeled(DSC.SAFE)
    public void unregisterForT53ClirInfo(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mCM.unregisterForT53ClirInfo(h);
        // ---------- Original Method ----------
        //mCM.unregisterForT53ClirInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.367 -0400", hash_original_method = "66D030845270A8F126DBBDF302E2A141", hash_generated_method = "AF7BC5DE427EA64B7437C006A2CCE859")
    @DSModeled(DSC.SAFE)
    public void registerForT53AudioControlInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mCM.registerForT53AudioControlInfo( h, what, obj);
        // ---------- Original Method ----------
        //mCM.registerForT53AudioControlInfo( h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.367 -0400", hash_original_method = "C4F9238B8E9649490800210FA099DE0F", hash_generated_method = "CF2B4E46B11E06F2213F754084CB83BC")
    @DSModeled(DSC.SAFE)
    public void unregisterForT53AudioControlInfo(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mCM.unregisterForT53AudioControlInfo(h);
        // ---------- Original Method ----------
        //mCM.unregisterForT53AudioControlInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.367 -0400", hash_original_method = "815749C135EEAFF1973468BF7BE05E75", hash_generated_method = "D802AB1164B11BE2E1F31C6368B97FF8")
    @DSModeled(DSC.SAFE)
    public void setOnEcbModeExitResponse(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        logUnexpectedCdmaMethodCall("setOnEcbModeExitResponse");
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("setOnEcbModeExitResponse");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.367 -0400", hash_original_method = "ECE14734C7F2F497945A22923EF26B0A", hash_generated_method = "667EAEF3B8DC20CBE1814FFD98E78FCE")
    @DSModeled(DSC.SAFE)
    public void unsetOnEcbModeExitResponse(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        logUnexpectedCdmaMethodCall("unsetOnEcbModeExitResponse");
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("unsetOnEcbModeExitResponse");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.367 -0400", hash_original_method = "04CB7EBB1F2C2F5A1F94C891E246EC01", hash_generated_method = "8B152FE11E04B8F93BC58B1EE86AD6CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getActiveApnTypes() {
        String[] var905F9282CFCC2CBA712022EFC59B1EE0_2122636147 = (mDataConnectionTracker.getActiveApnTypes());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return mDataConnectionTracker.getActiveApnTypes();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.367 -0400", hash_original_method = "D30362481D576467EFD2166079686420", hash_generated_method = "1714C2BD0C0E5F0FEA38A5BEC47E70BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getActiveApnHost(String apnType) {
        dsTaint.addTaint(apnType);
        String var38A0D074A292E089B08AC627AC3CB1DA_994225739 = (mDataConnectionTracker.getActiveApnString(apnType));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mDataConnectionTracker.getActiveApnString(apnType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.367 -0400", hash_original_method = "C11066F2623E480AC3C630C6CBD36058", hash_generated_method = "B0F0BC5A8E40B3901A30F50EA9A7F167")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkProperties getLinkProperties(String apnType) {
        dsTaint.addTaint(apnType);
        LinkProperties var3DC8B02C1E8BFDA46BF7973961BEC938_1331195471 = (mDataConnectionTracker.getLinkProperties(apnType));
        return (LinkProperties)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mDataConnectionTracker.getLinkProperties(apnType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.368 -0400", hash_original_method = "035A2689990E07C724064B64E344B05A", hash_generated_method = "97BF1ED93C48BC8EB7CE2528682B7FE7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkCapabilities getLinkCapabilities(String apnType) {
        dsTaint.addTaint(apnType);
        LinkCapabilities varA457917684ECB615E7E4E6E7BBB4D959_551360488 = (mDataConnectionTracker.getLinkCapabilities(apnType));
        return (LinkCapabilities)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mDataConnectionTracker.getLinkCapabilities(apnType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.368 -0400", hash_original_method = "8FC26686EA9F953DFAC2E032B4ED9578", hash_generated_method = "A8FD3B080569561E4FB2FEA57FBA7082")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int enableApnType(String type) {
        dsTaint.addTaint(type);
        int varDF3C53CB85D858230747E36923D6A726_181212380 = (mDataConnectionTracker.enableApnType(type));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mDataConnectionTracker.enableApnType(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.368 -0400", hash_original_method = "EEF84E670D69A41297DD287EFE00D426", hash_generated_method = "6FAD193DBFFCBCF0C8626575F5FF823F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int disableApnType(String type) {
        dsTaint.addTaint(type);
        int var6C853F768C2F44BB0E963400679EF2D6_829162569 = (mDataConnectionTracker.disableApnType(type));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mDataConnectionTracker.disableApnType(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.368 -0400", hash_original_method = "0E7DDF56B2AD7D089B639A5A4C8707B8", hash_generated_method = "2BC9F9B847D9B69E012F869344E7FF56")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isDataConnectivityPossible() {
        boolean var72302C29A137970B018198D274956B4F_13417187 = (isDataConnectivityPossible(Phone.APN_TYPE_DEFAULT));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isDataConnectivityPossible(Phone.APN_TYPE_DEFAULT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.368 -0400", hash_original_method = "D1C4C7300A786DB2DE96913E45D224C3", hash_generated_method = "78FB3AE4A79212930028FBCCAD931634")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isDataConnectivityPossible(String apnType) {
        dsTaint.addTaint(apnType);
        boolean varDADABF19322860B2D8E43DBCBAC0403E_1288994626 = (((mDataConnectionTracker != null) &&
                (mDataConnectionTracker.isDataPossible(apnType))));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ((mDataConnectionTracker != null) &&
                //(mDataConnectionTracker.isDataPossible(apnType)));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.368 -0400", hash_original_method = "78C210B796AC9661779AB486B8F70A37", hash_generated_method = "D2BAF77B5EDA84DA519078581AACB57B")
    @DSModeled(DSC.SAFE)
    protected void notifyNewRingingConnectionP(Connection cn) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.368 -0400", hash_original_method = "E77A37BE6BEB7ED310F1875BE08F1BE3", hash_generated_method = "C263A46033246B07BF9B1A675432A244")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.368 -0400", hash_original_method = "E1A10981C368CA09B703B9716F98BBE5", hash_generated_method = "17A0C4FFCEC4C2D6B168E5ECAA5751F7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.368 -0400", hash_original_method = "3242BA07687ED62C3518200E2F9FB53F", hash_generated_method = "D1BB85682C9FD6F51E1E85AA343CD408")
    @DSModeled(DSC.SAFE)
    public boolean isCspPlmnEnabled() {
        logUnexpectedGsmMethodCall("isCspPlmnEnabled");
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //logUnexpectedGsmMethodCall("isCspPlmnEnabled");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.368 -0400", hash_original_method = "B1975F1CE49D1493C79D22CB0A320E47", hash_generated_method = "DC178DFE80FA07CB89E527C439FAA624")
    @DSModeled(DSC.SAFE)
    public IsimRecords getIsimRecords() {
        return (IsimRecords)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "getIsimRecords() is only supported on LTE devices");
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.368 -0400", hash_original_method = "0D543BE7AD53581775829ADD7A6346BC", hash_generated_method = "26BD78BA69CE6E46885F33318AABA21B")
    @DSModeled(DSC.SAFE)
    public void requestIsimAuthentication(String nonce, Message result) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(nonce);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "requestIsimAuthentication() is only supported on LTE devices");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.368 -0400", hash_original_method = "60A69213567A9812671ADC8B66C5585F", hash_generated_method = "F55345BBE1BAEA0833BC6CD41D08204C")
    @DSModeled(DSC.SAFE)
    public String getMsisdn() {
        logUnexpectedGsmMethodCall("getMsisdn");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //logUnexpectedGsmMethodCall("getMsisdn");
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.368 -0400", hash_original_method = "5895E0F86D6993EE4A5D0827268FD313", hash_generated_method = "45BE346C5C047BF18D7AEBD9932E3EB9")
    private static void logUnexpectedCdmaMethodCall(String name) {
        Log.e(LOG_TAG, "Error! " + name + "() in PhoneBase should not be " +
                "called, CDMAPhone inactive.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.368 -0400", hash_original_method = "3916B54807B55A36DB6B185AF3F43F9B", hash_generated_method = "52D24A010782227B192CC8DB99A2E7BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DataState getDataConnectionState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        DataState var707DB245DFCD57192F33B108AA62A65B_512877977 = (getDataConnectionState(APN_TYPE_DEFAULT));
        return (DataState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getDataConnectionState(APN_TYPE_DEFAULT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.368 -0400", hash_original_method = "AD520BE59382A2059D08B3D3D1300653", hash_generated_method = "F781D30AB7A8E1058AC9D8944D576049")
    private static void logUnexpectedGsmMethodCall(String name) {
        Log.e(LOG_TAG, "Error! " + name + "() in PhoneBase should not be " +
                "called, GSMPhone inactive.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.368 -0400", hash_original_method = "3E0F86392A957104B8FBDE9CC6F59C4C", hash_generated_method = "4EF7CC8B38FAF59EF0FBDAD035754303")
    @DSModeled(DSC.SAFE)
    public void notifyCallForwardingIndicator() {
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "Error! This function should never be executed, inactive CDMAPhone.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.368 -0400", hash_original_method = "920CBD0242A41CC292CB0CFE1F874523", hash_generated_method = "730FBBE709E86220799BC22E7F5715E7")
    @DSModeled(DSC.SAFE)
    public void notifyDataConnectionFailed(String reason, String apnType) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(reason);
        dsTaint.addTaint(apnType);
        mNotifier.notifyDataConnectionFailed(this, reason, apnType);
        // ---------- Original Method ----------
        //mNotifier.notifyDataConnectionFailed(this, reason, apnType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.368 -0400", hash_original_method = "1FC25F07E17A01F63F573F1677883F29", hash_generated_method = "A6DFA208A307B03235085AEAA3712E50")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getLteOnCdmaMode() {
        int var5CFC37F2D9C4A6A0C98F9CAA2D688F1A_1014721376 = (mCM.getLteOnCdmaMode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mCM.getLteOnCdmaMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.368 -0400", hash_original_method = "B0657B144D34E1997F6D522B080186C1", hash_generated_method = "A1D56C61260F7FE6F17EDA61262D2AB4")
    @DSModeled(DSC.SAFE)
    @Override
    public void setVoiceMessageWaiting(int line, int countWaiting) {
        dsTaint.addTaint(line);
        dsTaint.addTaint(countWaiting);
        mIccRecords.setVoiceMessageWaiting(line, countWaiting);
        // ---------- Original Method ----------
        //mIccRecords.setVoiceMessageWaiting(line, countWaiting);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.369 -0400", hash_original_method = "099D11C8CFE57EFDDC5741548A2AEB3D", hash_generated_method = "99227A5862D8D27A17BEB2E28411BA4C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public UsimServiceTable getUsimServiceTable() {
        UsimServiceTable var7D90000EECE75C4F17D441F879A68272_1530478269 = (mIccRecords.getUsimServiceTable());
        return (UsimServiceTable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mIccRecords.getUsimServiceTable();
    }

    
}


