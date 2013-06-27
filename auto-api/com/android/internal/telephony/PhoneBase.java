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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.183 -0400", hash_original_field = "E7C221DB31E51F3F1CDC4689D17720C2", hash_generated_field = "0AC6FF61658A415C5960AD3646988614")

    public CommandsInterface mCM;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.183 -0400", hash_original_field = "468652BF843E336CFF551B50C329526F", hash_generated_field = "198CC7CC33D8E2C02C5C9590CB5AD311")

    protected IccFileHandler mIccFileHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.183 -0400", hash_original_field = "C12E4AC723C288B61D322062D91081B5", hash_generated_field = "8A6DB45685594C6B3CA56D072EAE88A2")

    boolean mDnsCheckDisabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.183 -0400", hash_original_field = "9A9C0EBC5F526311B48334D7F45EB12C", hash_generated_field = "12EFF52E123F190477A6BAA0D7E8BFC7")

    public DataConnectionTracker mDataConnectionTracker;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.184 -0400", hash_original_field = "EE3FE7245E74958CAE8034777BEEA8B4", hash_generated_field = "7012C269E9F9BA8E17E0D6E257D14593")

    boolean mDoesRilSendMultipleCallRing;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.184 -0400", hash_original_field = "471067A610965490C0B36D06578B215E", hash_generated_field = "6DF77C84901D61F939B98BC5F13EC488")

    int mCallRingContinueToken;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.184 -0400", hash_original_field = "318D491062090302154EC3506C3334FD", hash_generated_field = "8B2C85FE062C8E1E1BE9A9671BFD773E")

    int mCallRingDelay;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.184 -0400", hash_original_field = "DD30091BF44B847FB6465E8B57CD5AB6", hash_generated_field = "7AC2DAF64A3A2115F12FB6B4AC4A0E0E")

    public boolean mIsTheCurrentActivePhone = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.184 -0400", hash_original_field = "D57DDA0136A7F0A5C975D75CCD876E99", hash_generated_field = "5B4D36755C5058654DC5817A0531A0FC")

    boolean mIsVoiceCapable = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.184 -0400", hash_original_field = "C90E66D30105E64A69B0470347184F2E", hash_generated_field = "373EB9ACD432C91447EB4C9C52571686")

    public IccRecords mIccRecords;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.184 -0400", hash_original_field = "D30B0F4E33C60E156D6B9A465CCE0A9C", hash_generated_field = "FDCA805CE2E645965D8424F392885596")

    public IccCard mIccCard;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.184 -0400", hash_original_field = "10C8BA4A75E9540145A9C975173E644E", hash_generated_field = "FFF9200D373C7FEFEF20A4999EB8139A")

    public SmsStorageMonitor mSmsStorageMonitor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.184 -0400", hash_original_field = "4D552408A6FCA16BC34ACDC443DAE64E", hash_generated_field = "7806E0DA87D41123DEDBE3D402001152")

    public SmsUsageMonitor mSmsUsageMonitor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.184 -0400", hash_original_field = "13732D6DCF8B8DFEB7A05955ED67A616", hash_generated_field = "1CCDFDF0949A05986349192A62052DA8")

    public SMSDispatcher mSMS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.184 -0400", hash_original_field = "2A00E7783B25841870BB9326860F9D07", hash_generated_field = "2C522C2FAACB036BA133653CE6586AFC")

    protected RegistrantList mPreciseCallStateRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.184 -0400", hash_original_field = "046AD962F76E43F793C72A8520081388", hash_generated_field = "1994F7475CF90AEF23EB0F09AC2624AC")

    protected RegistrantList mNewRingingConnectionRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.184 -0400", hash_original_field = "4C7B39D5A9D904D8B1C5B59EA05D3E19", hash_generated_field = "2B3EA0E66941B3D2D1673900C519A806")

    protected RegistrantList mIncomingRingRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.184 -0400", hash_original_field = "6B17894FE235D6A8C0BBEE6382BF1CDE", hash_generated_field = "D0D49BFA6DDB783C6A12DF761BD7AA27")

    protected RegistrantList mDisconnectRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.184 -0400", hash_original_field = "99A28BF65FE1E029B35B39D9FDFB3BFF", hash_generated_field = "AFE2AD382FB01053A1D7E9E26FD3FA84")

    protected RegistrantList mServiceStateRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.184 -0400", hash_original_field = "0AE36B7A06695323758D47DC20170D52", hash_generated_field = "BDB16ECBB5922CCAB12170AAAFC05371")

    protected RegistrantList mMmiCompleteRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.184 -0400", hash_original_field = "0B1A7701B95E2A553C6027F90A4D24CE", hash_generated_field = "FEEFB26D61271795DB6E63573142520C")

    protected RegistrantList mMmiRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.184 -0400", hash_original_field = "F7ADD316BD43AB6664404F10762B7C57", hash_generated_field = "5AAF09E774CB1668233404F4849596EF")

    protected RegistrantList mUnknownConnectionRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.184 -0400", hash_original_field = "9F99D3D12ACFC19F3630650F9E356767", hash_generated_field = "A8FC819EC32F822EAE6962DDF72D996E")

    protected RegistrantList mSuppServiceFailedRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.184 -0400", hash_original_field = "DA288C1345E9C94467C02060ED19C6FA", hash_generated_field = "D741950DD4D297A5A97E2573D2099374")

    protected Looper mLooper;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.184 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B3359F86E29A965BC1436888E98C55A8")

    protected Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.184 -0400", hash_original_field = "B9C5CA8CA7E27D8D9C93841E740D9D20", hash_generated_field = "0DBF65814173CE16A85F1AA98BDF5F5E")

    protected PhoneNotifier mNotifier;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.184 -0400", hash_original_field = "EB66409812E41FE34BF5C0DEF3D420BF", hash_generated_field = "3A8866AF6F9DF724308515FF86538AAE")

    protected SimulatedRadioControl mSimulatedRadioControl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.184 -0400", hash_original_field = "089ED708F2208CFF55FCCE18DCF579A1", hash_generated_field = "F1D2CE7105A6C577055D5D2EA9384903")

    boolean mUnitTestMode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.185 -0400", hash_original_method = "0B01EDD7CFA10DA565A9E13F0B7F18B5", hash_generated_method = "6BCCB7E516644597B20AF4C4B6D03747")
    protected  PhoneBase(PhoneNotifier notifier, Context context, CommandsInterface ci) {
        this(notifier, context, ci, false);
        addTaint(notifier.getTaint());
        addTaint(context.getTaint());
        addTaint(ci.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.204 -0400", hash_original_method = "0B181FBA64FE5D093F6319BFF754183A", hash_generated_method = "134E0F8C4C0A38687D0BDE32EE570C21")
    protected  PhoneBase(PhoneNotifier notifier, Context context, CommandsInterface ci,
            boolean unitTestMode) {
        this.mNotifier = notifier;
        this.mContext = context;
        mLooper = Looper.myLooper();
        mCM = ci;
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
        addTaint(unitTestMode);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.204 -0400", hash_original_method = "5E4CE6B07EFCD29EE81659A348140E39", hash_generated_method = "92416E25CE2AD3D5C49B40924D8F5958")
    public void setSystemProperty(String property, String value) {
        {
            boolean var70902CF88F4EB5C4A377580704B63A33_1736526197 = (getUnitTestMode());
        } //End collapsed parenthetic
        SystemProperties.set(property, value);
        addTaint(property.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //if(getUnitTestMode()) {
            //return;
        //}
        //SystemProperties.set(property, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.205 -0400", hash_original_method = "E6D9767A803FC78FE4F21E8C0AA16E1B", hash_generated_method = "4E2EEF57B7AE7D00D54C481EF756B0D8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.205 -0400", hash_original_method = "AD2C393D4007178071128FB79D198E7A", hash_generated_method = "939AA9D60C792DDBF5AE38E81D1C4004")
    public void removeReferences() {
        mSmsStorageMonitor = null;
        mSmsUsageMonitor = null;
        // ---------- Original Method ----------
        //mSmsStorageMonitor = null;
        //mSmsUsageMonitor = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.206 -0400", hash_original_method = "DB16D19FE7C055C53AF6F04667B938A9", hash_generated_method = "B1A0DB0D83B279325C5B67DA40B03B4D")
    @Override
    public void handleMessage(Message msg) {
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
            boolean var95B9CB18D0624E6EEB44A7D4EE2ACB8D_2044326921 = (getState() == Phone.State.RINGING);
            {
                sendIncomingCallRingNotification(msg.arg1);
            } //End block
        } //End collapsed parenthetic
        //End case EVENT_CALL_RING_CONTINUE 
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("unexpected event not handled");
        //End case default 
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.221 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "3A932FBD99028BF1B74045AAB6BC0B96")
    public Context getContext() {
        Context varB4EAC82CA7396A68D541C85D26508E83_1561525864 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1561525864 = mContext;
        varB4EAC82CA7396A68D541C85D26508E83_1561525864.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1561525864;
        // ---------- Original Method ----------
        //return mContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.222 -0400", hash_original_method = "6B58AC4FFDA912638B2751BFF719D57B", hash_generated_method = "0F00CFC1BDF9163C60D6D62388013047")
    public void disableDnsCheck(boolean b) {
        mDnsCheckDisabled = b;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.222 -0400", hash_original_method = "26E6CAA04D711DCC258BDCDD2AAE1C53", hash_generated_method = "65C743D96CF0E7CEC794C872052A6F46")
    public boolean isDnsCheckDisabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1981278066 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1981278066;
        // ---------- Original Method ----------
        //return mDnsCheckDisabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.222 -0400", hash_original_method = "97FD2D9125201743A42C7236EAF94A65", hash_generated_method = "9A5594382C86CFCE532B4C1C5F87DD79")
    public void registerForPreciseCallStateChanged(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        checkCorrectThread(h);
        mPreciseCallStateRegistrants.addUnique(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //checkCorrectThread(h);
        //mPreciseCallStateRegistrants.addUnique(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.223 -0400", hash_original_method = "3468093E0DED2950A146A2A89C89E0C9", hash_generated_method = "F4024BCE6DD0ECE29750EFC643D8AFD3")
    public void unregisterForPreciseCallStateChanged(Handler h) {
        mPreciseCallStateRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mPreciseCallStateRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.227 -0400", hash_original_method = "7D1AEC63A120FA3D327FCF14A278BC6F", hash_generated_method = "69848D6291CDA576C25A072576E7D384")
    protected void notifyPreciseCallStateChangedP() {
        AsyncResult ar;
        ar = new AsyncResult(null, this, null);
        mPreciseCallStateRegistrants.notifyRegistrants(ar);
        // ---------- Original Method ----------
        //AsyncResult ar = new AsyncResult(null, this, null);
        //mPreciseCallStateRegistrants.notifyRegistrants(ar);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.230 -0400", hash_original_method = "B9AA4FF50180EB9A48B29DB9F5910CE4", hash_generated_method = "D5F27719706B5E45C882BBBD882A8B84")
    public void registerForUnknownConnection(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        checkCorrectThread(h);
        mUnknownConnectionRegistrants.addUnique(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //checkCorrectThread(h);
        //mUnknownConnectionRegistrants.addUnique(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.231 -0400", hash_original_method = "75B09E3F4F0ED781C6A40D2F37829CA0", hash_generated_method = "086053ADE1DBA2B079531958E3F214A3")
    public void unregisterForUnknownConnection(Handler h) {
        mUnknownConnectionRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mUnknownConnectionRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.231 -0400", hash_original_method = "AD1FA3FDB645CF1FEF5A2946EFD96B38", hash_generated_method = "6CB6201354159339001F056971A5A4B5")
    public void registerForNewRingingConnection(
            Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        checkCorrectThread(h);
        mNewRingingConnectionRegistrants.addUnique(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //checkCorrectThread(h);
        //mNewRingingConnectionRegistrants.addUnique(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.231 -0400", hash_original_method = "058A0D079EFCE83305D698FFA7B5D825", hash_generated_method = "AE5B9B5EB6D33FF69A8BBDBBE106CF47")
    public void unregisterForNewRingingConnection(Handler h) {
        mNewRingingConnectionRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mNewRingingConnectionRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.232 -0400", hash_original_method = "0EC65AF661091C788FEAC732E62723E6", hash_generated_method = "98671D55D0CEDC16CBA3159FF765841D")
    public void registerForInCallVoicePrivacyOn(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mCM.registerForInCallVoicePrivacyOn(h,what,obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mCM.registerForInCallVoicePrivacyOn(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.243 -0400", hash_original_method = "AAF2DABAA6CCE680F9F5730540C91C97", hash_generated_method = "D4B7E737B7512E0448DEA68C02E8BF0B")
    public void unregisterForInCallVoicePrivacyOn(Handler h) {
        mCM.unregisterForInCallVoicePrivacyOn(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mCM.unregisterForInCallVoicePrivacyOn(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.243 -0400", hash_original_method = "5EF015768DAEEB9D8933F39BF43636FD", hash_generated_method = "488A42470581EF78199C9150306933C2")
    public void registerForInCallVoicePrivacyOff(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mCM.registerForInCallVoicePrivacyOff(h,what,obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mCM.registerForInCallVoicePrivacyOff(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.244 -0400", hash_original_method = "D5B23AF1D1217C6A3E1625439D35B2E2", hash_generated_method = "87FCF0D857489E46AB740E5C743E4697")
    public void unregisterForInCallVoicePrivacyOff(Handler h) {
        mCM.unregisterForInCallVoicePrivacyOff(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mCM.unregisterForInCallVoicePrivacyOff(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.244 -0400", hash_original_method = "50A4B0D73C58D3A2BE8105C1A17D2698", hash_generated_method = "9F982C376AC0332994F5E8BDED9D7E81")
    public void registerForIncomingRing(
            Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        checkCorrectThread(h);
        mIncomingRingRegistrants.addUnique(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //checkCorrectThread(h);
        //mIncomingRingRegistrants.addUnique(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.244 -0400", hash_original_method = "92E2BA35AB0B11C010FD1FF2A8E6A65B", hash_generated_method = "49D84398FFF884B886847A656061C0F3")
    public void unregisterForIncomingRing(Handler h) {
        mIncomingRingRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mIncomingRingRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.244 -0400", hash_original_method = "2053ED9D2D7BD498A1C704AFBEE337C3", hash_generated_method = "A655E014A8D3A4243548D96771431C1B")
    public void registerForDisconnect(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        checkCorrectThread(h);
        mDisconnectRegistrants.addUnique(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //checkCorrectThread(h);
        //mDisconnectRegistrants.addUnique(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.245 -0400", hash_original_method = "77A19CF742BA6691CDA7407600B4E7F3", hash_generated_method = "4D52137A6CB93361CFC09550938A36DF")
    public void unregisterForDisconnect(Handler h) {
        mDisconnectRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mDisconnectRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.245 -0400", hash_original_method = "D574E9C9A24655069A0054F4E3538F49", hash_generated_method = "0860BC41CA66A942DE12F3CF074E5534")
    public void registerForSuppServiceFailed(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        checkCorrectThread(h);
        mSuppServiceFailedRegistrants.addUnique(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //checkCorrectThread(h);
        //mSuppServiceFailedRegistrants.addUnique(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.245 -0400", hash_original_method = "C86C69890AF660CD858A7F262F783D04", hash_generated_method = "17B5552BDA46DEE5A0B98F6E236DE265")
    public void unregisterForSuppServiceFailed(Handler h) {
        mSuppServiceFailedRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mSuppServiceFailedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.245 -0400", hash_original_method = "04A8F1C35CFA7005AF5258C29F5FFE2B", hash_generated_method = "F6B56BEF84B0326C516445C093D14C96")
    public void registerForMmiInitiate(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        checkCorrectThread(h);
        mMmiRegistrants.addUnique(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //checkCorrectThread(h);
        //mMmiRegistrants.addUnique(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.246 -0400", hash_original_method = "338E9AA4432AD835C97CF49233FF5692", hash_generated_method = "A01CF615F9F12C98A2883F9F689F2588")
    public void unregisterForMmiInitiate(Handler h) {
        mMmiRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mMmiRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.246 -0400", hash_original_method = "61BE6CB4DF9A0C652F1BC7F7AD4D4CCB", hash_generated_method = "9D84F67BB56D98FA030A0DEAED425710")
    public void registerForMmiComplete(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        checkCorrectThread(h);
        mMmiCompleteRegistrants.addUnique(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //checkCorrectThread(h);
        //mMmiCompleteRegistrants.addUnique(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.246 -0400", hash_original_method = "FE25021AB6559853BB3705423F117C85", hash_generated_method = "21DCD3F0C17419881A9F7FF294DAE785")
    public void unregisterForMmiComplete(Handler h) {
        checkCorrectThread(h);
        mMmiCompleteRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //checkCorrectThread(h);
        //mMmiCompleteRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.261 -0400", hash_original_method = "764E722E685D5D307BCF00BDB294F564", hash_generated_method = "34304049668982FEFFCD086FF2F14BBA")
    private String getSavedNetworkSelection() {
        String varB4EAC82CA7396A68D541C85D26508E83_279233835 = null; //Variable for return #1
        SharedPreferences sp;
        sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        varB4EAC82CA7396A68D541C85D26508E83_279233835 = sp.getString(NETWORK_SELECTION_KEY, "");
        varB4EAC82CA7396A68D541C85D26508E83_279233835.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_279233835;
        // ---------- Original Method ----------
        //SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        //return sp.getString(NETWORK_SELECTION_KEY, "");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.261 -0400", hash_original_method = "29F19DECCCFC42207CFA8F3911C2D799", hash_generated_method = "BE74FB6F6373C73866E8BD9E272D6C55")
    public void restoreSavedNetworkSelection(Message response) {
        String networkSelection;
        networkSelection = getSavedNetworkSelection();
        {
            boolean var7DB33003CA3D238605A26618783283D8_1344907440 = (TextUtils.isEmpty(networkSelection));
            {
                mCM.setNetworkSelectionModeAutomatic(response);
            } //End block
            {
                mCM.setNetworkSelectionModeManual(networkSelection, response);
            } //End block
        } //End collapsed parenthetic
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //String networkSelection = getSavedNetworkSelection();
        //if (TextUtils.isEmpty(networkSelection)) {
            //mCM.setNetworkSelectionModeAutomatic(response);
        //} else {
            //mCM.setNetworkSelectionModeManual(networkSelection, response);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.261 -0400", hash_original_method = "347AF2D7A75CED9B3C82A500C1FA5AD6", hash_generated_method = "3688FCA7B96722A600A49ED95FD11CA4")
    public void setUnitTestMode(boolean f) {
        mUnitTestMode = f;
        // ---------- Original Method ----------
        //mUnitTestMode = f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.262 -0400", hash_original_method = "958D127406A24370C06699E6AB687F2A", hash_generated_method = "69A0925F3C51C0A32B732AF9DE767A73")
    public boolean getUnitTestMode() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1887199975 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1887199975;
        // ---------- Original Method ----------
        //return mUnitTestMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.262 -0400", hash_original_method = "80E90CBCA9EDC240B4F0091FF8E28C26", hash_generated_method = "0B29A5459E2D02BC10E28D10E9760398")
    protected void notifyDisconnectP(Connection cn) {
        AsyncResult ar;
        ar = new AsyncResult(null, cn, null);
        mDisconnectRegistrants.notifyRegistrants(ar);
        addTaint(cn.getTaint());
        // ---------- Original Method ----------
        //AsyncResult ar = new AsyncResult(null, cn, null);
        //mDisconnectRegistrants.notifyRegistrants(ar);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.262 -0400", hash_original_method = "BD17CCC0601D2F340E3F675C1E59C4B9", hash_generated_method = "3078056C3AFF62F4BC70F4CB02E61464")
    public void registerForServiceStateChanged(
            Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        checkCorrectThread(h);
        mServiceStateRegistrants.add(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //checkCorrectThread(h);
        //mServiceStateRegistrants.add(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.262 -0400", hash_original_method = "5AFF1BE54185C9B4577A75EFF0396B68", hash_generated_method = "510F8039133BA6553A2915C261AFF1D6")
    public void unregisterForServiceStateChanged(Handler h) {
        mServiceStateRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mServiceStateRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.263 -0400", hash_original_method = "6C50CDA22F8E02023B34911844DFEED2", hash_generated_method = "7EAFE7D2838B4C4243629B77BA293D0E")
    public void registerForRingbackTone(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mCM.registerForRingbackTone(h,what,obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mCM.registerForRingbackTone(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.263 -0400", hash_original_method = "475301C04BE08B381350355879425A76", hash_generated_method = "180D37860B39E9ADD4C6512B704B8129")
    public void unregisterForRingbackTone(Handler h) {
        mCM.unregisterForRingbackTone(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mCM.unregisterForRingbackTone(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.263 -0400", hash_original_method = "6FE1177D9BF24D9A41C1BE1AD2A93980", hash_generated_method = "4288B6C0C535F52DB7CEA463897273CB")
    public void registerForResendIncallMute(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mCM.registerForResendIncallMute(h,what,obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mCM.registerForResendIncallMute(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.263 -0400", hash_original_method = "1E28EF1EEBC2208F47A83D89926DE82E", hash_generated_method = "DD5C13C2E7658D21546534E6467C1628")
    public void unregisterForResendIncallMute(Handler h) {
        mCM.unregisterForResendIncallMute(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mCM.unregisterForResendIncallMute(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.264 -0400", hash_original_method = "F34715D262D40C908422031B6920D016", hash_generated_method = "4A991C5D707470F1B7A17B8AA612EC14")
    public void setEchoSuppressionEnabled(boolean enabled) {
        addTaint(enabled);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.264 -0400", hash_original_method = "D42B19E1304E0F299FEED69470ACF7B6", hash_generated_method = "4F120E0E750F85F2305313FFC7C8A654")
    protected void notifyServiceStateChangedP(ServiceState ss) {
        AsyncResult ar;
        ar = new AsyncResult(null, ss, null);
        mServiceStateRegistrants.notifyRegistrants(ar);
        mNotifier.notifyServiceState(this);
        addTaint(ss.getTaint());
        // ---------- Original Method ----------
        //AsyncResult ar = new AsyncResult(null, ss, null);
        //mServiceStateRegistrants.notifyRegistrants(ar);
        //mNotifier.notifyServiceState(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.264 -0400", hash_original_method = "6C132AD700E1EDF5A17434649EDA0F2C", hash_generated_method = "8A27D34ADC9CD18BAF1599D7FE64B12B")
    public SimulatedRadioControl getSimulatedRadioControl() {
        SimulatedRadioControl varB4EAC82CA7396A68D541C85D26508E83_1787723858 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1787723858 = mSimulatedRadioControl;
        varB4EAC82CA7396A68D541C85D26508E83_1787723858.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1787723858;
        // ---------- Original Method ----------
        //return mSimulatedRadioControl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.264 -0400", hash_original_method = "930052C83226AF8DE91A3B058305558F", hash_generated_method = "9B8977999DA3970CF530892AC7EAF184")
    private void checkCorrectThread(Handler h) {
        {
            boolean varC80731002783DFD1F9463E965D806130_679330680 = (h.getLooper() != mLooper);
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                    "com.android.internal.telephony.Phone must be used from within one thread");
            } //End block
        } //End collapsed parenthetic
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //if (h.getLooper() != mLooper) {
            //throw new RuntimeException(
                    //"com.android.internal.telephony.Phone must be used from within one thread");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.265 -0400", hash_original_method = "FDCB651DF17FF9811415182F19CE1B4C", hash_generated_method = "D9A0753CDF4EAAB5A76C6F8C57ACBB4B")
    private void setPropertiesByCarrier() {
        String carrier;
        carrier = SystemProperties.get("ro.carrier");
        {
            boolean var4C71EF3FF41846A3F65598AC0FD7C2DF_1239954593 = (null == carrier || 0 == carrier.length() || "unknown".equals(carrier));
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
                    boolean var75425E199AD2683373EB064DEACE952B_1942770313 = (carrier.equals(c));
                    {
                        String l;
                        l = carrierLocales[i+1].toString();
                        String language;
                        language = l.substring(0, 2);
                        String country;
                        country = "";
                        {
                            boolean varF67DA07AFC0B8D9D491D3A93A03DA49E_1584041873 = (l.length() >=5);
                            {
                                country = l.substring(3, 5);
                            } //End block
                        } //End collapsed parenthetic
                        setSystemLocale(language, country, false);
                        {
                            boolean varE322B40A95DAFE52AA6E0E240CD3B924_1493727842 = (!country.isEmpty());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.276 -0400", hash_original_method = "B1CAAC16126A906DDE46004E33C276B7", hash_generated_method = "02DC1D990D25987E164963C0FFB5E8DE")
    public void setSystemLocale(String language, String country, boolean fromMcc) {
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
            boolean varE02578713C19A1BF95FEF0FA4F6086A2_57832300 = ((null == l || 0 == l.length()) && (null == c || 0 == c.length()));
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
                                boolean varB3910760851B0FD21D5BDE8F0437EA86_1864370661 = (locales[i]!=null && locales[i].length() >= 5 &&
                            locales[i].substring(0,2).equals(language));
                                {
                                    {
                                        boolean varD7C1E0B87149D0FC064FD18A3F2956D9_1185598607 = (locales[i].substring(3,5).equals(country));
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
        addTaint(language.getTaint());
        addTaint(country.getTaint());
        addTaint(fromMcc);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public abstract Phone.State getState();

    
    public abstract IccFileHandler getIccFileHandler();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.286 -0400", hash_original_method = "B77EA67F9749FFFAEC203B31F557B343", hash_generated_method = "2E210AB6084F81DC7EA895CC02755C07")
    public Handler getHandler() {
        Handler varB4EAC82CA7396A68D541C85D26508E83_1493953260 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1493953260 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1493953260.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1493953260;
        // ---------- Original Method ----------
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.293 -0400", hash_original_method = "E9813275B540C23EC4ABDDE1F3F36487", hash_generated_method = "EC0235845609B2A967F50EE6351F746C")
    public ServiceStateTracker getServiceStateTracker() {
        ServiceStateTracker varB4EAC82CA7396A68D541C85D26508E83_481184598 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_481184598 = null;
        varB4EAC82CA7396A68D541C85D26508E83_481184598.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_481184598;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.294 -0400", hash_original_method = "A2CFF60AF23DAF5B5D13432A0E634448", hash_generated_method = "8F44A657A1F4016358742AF977A15897")
    public CallTracker getCallTracker() {
        CallTracker varB4EAC82CA7396A68D541C85D26508E83_549222266 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_549222266 = null;
        varB4EAC82CA7396A68D541C85D26508E83_549222266.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_549222266;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.294 -0400", hash_original_method = "E12359725DA3BA4F59BA85FD7E4F143C", hash_generated_method = "F22836B21F4D571EAD1E9122DF3B1189")
    @Override
    public IccCard getIccCard() {
        IccCard varB4EAC82CA7396A68D541C85D26508E83_866177513 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_866177513 = mIccCard;
        varB4EAC82CA7396A68D541C85D26508E83_866177513.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_866177513;
        // ---------- Original Method ----------
        //return mIccCard;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.295 -0400", hash_original_method = "26C3C4C321ACD0FC593701A52D49E497", hash_generated_method = "CAFC55948E8E11CB664B2CC09A63B0B7")
    @Override
    public String getIccSerialNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_1845425283 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1845425283 = mIccRecords.iccid;
        varB4EAC82CA7396A68D541C85D26508E83_1845425283.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1845425283;
        // ---------- Original Method ----------
        //return mIccRecords.iccid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.295 -0400", hash_original_method = "9078EC96DE8D2AE9C16B88E94341FB99", hash_generated_method = "6C15B7F7E7DFCFD1C47CFBB3C67B994F")
    @Override
    public boolean getIccRecordsLoaded() {
        boolean var83CEE5D1173D41B37947C1976F7A6F36_64533055 = (mIccRecords.getRecordsLoaded());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1842302652 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1842302652;
        // ---------- Original Method ----------
        //return mIccRecords.getRecordsLoaded();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.295 -0400", hash_original_method = "1B6614D059F66BD820665EDAF3DE7F9F", hash_generated_method = "270F4F44906EE5BAD99ECF8F9427BC96")
    @Override
    public boolean getMessageWaitingIndicator() {
        boolean var9905017E0A4EF52F8E7F52DF159D611D_1063539932 = (mIccRecords.getVoiceMessageWaiting());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1614540327 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1614540327;
        // ---------- Original Method ----------
        //return mIccRecords.getVoiceMessageWaiting();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.306 -0400", hash_original_method = "EAA51813A27C6D01EBD0F8DD0837A86A", hash_generated_method = "C97D32E65652F3C419478E7FE5206AB2")
    @Override
    public boolean getCallForwardingIndicator() {
        boolean varF91C9B7616B652A3A4D61DDBCE0EC0EE_1537551733 = (mIccRecords.getVoiceCallForwardingFlag());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_795872519 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_795872519;
        // ---------- Original Method ----------
        //return mIccRecords.getVoiceCallForwardingFlag();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.307 -0400", hash_original_method = "93DCD756C677180103F6D6F7873E6AE7", hash_generated_method = "BDA9049431C657ADF54D44095431D834")
    public void queryCdmaRoamingPreference(Message response) {
        mCM.queryCdmaRoamingPreference(response);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mCM.queryCdmaRoamingPreference(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.307 -0400", hash_original_method = "D1AE94805C952F3809EAEE65E7FED134", hash_generated_method = "935A425512C47E55924523EF4046770F")
    public void setCdmaRoamingPreference(int cdmaRoamingType, Message response) {
        mCM.setCdmaRoamingPreference(cdmaRoamingType, response);
        addTaint(cdmaRoamingType);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mCM.setCdmaRoamingPreference(cdmaRoamingType, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.307 -0400", hash_original_method = "532B78C8CD74E377483500017A27260E", hash_generated_method = "475F166E2EB115CC96CDE3C6FCC95295")
    public void setCdmaSubscription(int cdmaSubscriptionType, Message response) {
        mCM.setCdmaSubscriptionSource(cdmaSubscriptionType, response);
        addTaint(cdmaSubscriptionType);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mCM.setCdmaSubscriptionSource(cdmaSubscriptionType, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.308 -0400", hash_original_method = "EA18BAD07370F2F495FB68EDF5CD8C8E", hash_generated_method = "B1EC888C06D7188115FEA6456D9E6DD5")
    public void setPreferredNetworkType(int networkType, Message response) {
        mCM.setPreferredNetworkType(networkType, response);
        addTaint(networkType);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mCM.setPreferredNetworkType(networkType, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.308 -0400", hash_original_method = "379A4BC143905A2FA132EF757E52297F", hash_generated_method = "C99DBE2356B363CFE6213040FB9415A0")
    public void getPreferredNetworkType(Message response) {
        mCM.getPreferredNetworkType(response);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mCM.getPreferredNetworkType(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.308 -0400", hash_original_method = "1E1783F8116903E275F3EB4645F9C2EE", hash_generated_method = "BB2FB1CCA4ACC949DFA4EB9D33357A15")
    public void getSmscAddress(Message result) {
        mCM.getSmscAddress(result);
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //mCM.getSmscAddress(result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.308 -0400", hash_original_method = "4D63BDB7F30F381F077564B4D4894249", hash_generated_method = "36C686EF1F1905E939EA7D0F73823433")
    public void setSmscAddress(String address, Message result) {
        mCM.setSmscAddress(address, result);
        addTaint(address.getTaint());
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //mCM.setSmscAddress(address, result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.320 -0400", hash_original_method = "63C869993C8085EA489C8231FED76E37", hash_generated_method = "B0B43EA5B4253C4F198BA424E4313FAE")
    public void setTTYMode(int ttyMode, Message onComplete) {
        mCM.setTTYMode(ttyMode, onComplete);
        addTaint(ttyMode);
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //mCM.setTTYMode(ttyMode, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.320 -0400", hash_original_method = "2CF2C1C8F165F7A0D032A77B44E87766", hash_generated_method = "76758890F6F5061ED8F7DECA89D986EC")
    public void queryTTYMode(Message onComplete) {
        mCM.queryTTYMode(onComplete);
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //mCM.queryTTYMode(onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.320 -0400", hash_original_method = "5E8CBEA5609C7848D9FB026D7FBB8ABD", hash_generated_method = "3C2C048FB378E4BFCD6CDA02239711C5")
    public void enableEnhancedVoicePrivacy(boolean enable, Message onComplete) {
        logUnexpectedCdmaMethodCall("enableEnhancedVoicePrivacy");
        addTaint(enable);
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("enableEnhancedVoicePrivacy");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.320 -0400", hash_original_method = "33AF0BA0508B34DC6251B1288B05B827", hash_generated_method = "4D2E22D3F114AF172841C0A7ACDC5CD6")
    public void getEnhancedVoicePrivacy(Message onComplete) {
        logUnexpectedCdmaMethodCall("getEnhancedVoicePrivacy");
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("getEnhancedVoicePrivacy");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.321 -0400", hash_original_method = "89D25AC6FB0D0D55BD65CF567206F30D", hash_generated_method = "2823AF3C35E73C06589AAF9EDC4DE963")
    public void setBandMode(int bandMode, Message response) {
        mCM.setBandMode(bandMode, response);
        addTaint(bandMode);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mCM.setBandMode(bandMode, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.321 -0400", hash_original_method = "83F6C692B5B60F1074FC39097E38CED5", hash_generated_method = "E8268BF8D5ABC698D93D13A29AEB6087")
    public void queryAvailableBandMode(Message response) {
        mCM.queryAvailableBandMode(response);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mCM.queryAvailableBandMode(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.321 -0400", hash_original_method = "13F8DD451E5397866EEA2E2D05CD7BB9", hash_generated_method = "46B74B328DD19D832F884C2287E62B3C")
    public void invokeOemRilRequestRaw(byte[] data, Message response) {
        mCM.invokeOemRilRequestRaw(data, response);
        addTaint(data[0]);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mCM.invokeOemRilRequestRaw(data, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.321 -0400", hash_original_method = "FF2E1FA4CC9C1321FDC1F9CFA6F4625A", hash_generated_method = "361C68BC14D19F8619635F4269BC9FBB")
    public void invokeOemRilRequestStrings(String[] strings, Message response) {
        mCM.invokeOemRilRequestStrings(strings, response);
        addTaint(strings[0].getTaint());
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mCM.invokeOemRilRequestStrings(strings, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.322 -0400", hash_original_method = "FF7C38607D5C4F28572FCAAA94A2F244", hash_generated_method = "3F05111CC8235C6253E2D7363CB24A45")
    public void notifyDataActivity() {
        mNotifier.notifyDataActivity(this);
        // ---------- Original Method ----------
        //mNotifier.notifyDataActivity(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.322 -0400", hash_original_method = "CD8E1DAAFB356590CE946A9A3EFA7BF6", hash_generated_method = "B7C2EB789B8EA18ED6CFD98FF729A3E3")
    public void notifyMessageWaitingIndicator() {
        mNotifier.notifyMessageWaitingChanged(this);
        // ---------- Original Method ----------
        //if (!mIsVoiceCapable)
            //return;
        //mNotifier.notifyMessageWaitingChanged(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.322 -0400", hash_original_method = "B949430324D30DD706A09A11AE93C217", hash_generated_method = "7FC617518745ED62F0AEB3107E7E78C7")
    public void notifyDataConnection(String reason, String apnType,
            Phone.DataState state) {
        mNotifier.notifyDataConnection(this, reason, apnType, state);
        addTaint(reason.getTaint());
        addTaint(apnType.getTaint());
        addTaint(state.getTaint());
        // ---------- Original Method ----------
        //mNotifier.notifyDataConnection(this, reason, apnType, state);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.322 -0400", hash_original_method = "FACBD8427065A5D42D63A885B3F07753", hash_generated_method = "11D6A85B0B506E25B8121956FC09C6E0")
    public void notifyDataConnection(String reason, String apnType) {
        mNotifier.notifyDataConnection(this, reason, apnType, getDataConnectionState(apnType));
        addTaint(reason.getTaint());
        addTaint(apnType.getTaint());
        // ---------- Original Method ----------
        //mNotifier.notifyDataConnection(this, reason, apnType, getDataConnectionState(apnType));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.443 -0400", hash_original_method = "0547766DA98E44E8B89F2461696DDA6A", hash_generated_method = "A95F5502E70A2B83260C07887901C0DA")
    public void notifyDataConnection(String reason) {
        String types[];
        types = getActiveApnTypes();
        {
            String apnType = types[0];
            {
                mNotifier.notifyDataConnection(this, reason, apnType, getDataConnectionState(apnType));
            } //End block
        } //End collapsed parenthetic
        addTaint(reason.getTaint());
        // ---------- Original Method ----------
        //String types[] = getActiveApnTypes();
        //for (String apnType : types) {
            //mNotifier.notifyDataConnection(this, reason, apnType, getDataConnectionState(apnType));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.443 -0400", hash_original_method = "68DB92920F159FB7A2995379683DC8DE", hash_generated_method = "69D6038F7BA8BCB3E810885D00508ED0")
    public void notifyOtaspChanged(int otaspMode) {
        mNotifier.notifyOtaspChanged(this, otaspMode);
        addTaint(otaspMode);
        // ---------- Original Method ----------
        //mNotifier.notifyOtaspChanged(this, otaspMode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.444 -0400", hash_original_method = "EBE7791CDB6F228DD3645706A64042D5", hash_generated_method = "954524DD63952ECB8726CC2B483073BB")
    public boolean isInEmergencyCall() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1872577407 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1872577407;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.444 -0400", hash_original_method = "2D052AB13CFF7511C3F5373523EDFF5B", hash_generated_method = "25D0C2E03AB8641912353448F4EB9346")
    public boolean isInEcm() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2080249696 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2080249696;
        // ---------- Original Method ----------
        //return false;
    }

    
    public abstract String getPhoneName();

    
    public abstract int getPhoneType();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.453 -0400", hash_original_method = "91CE395C2B1A59CCA21CB689DCBFE10B", hash_generated_method = "253DC91F967E51313155120E5D191CD2")
    public int getVoiceMessageCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_304098227 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_304098227;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.453 -0400", hash_original_method = "A48905F669D5C197EA0EF66127013B06", hash_generated_method = "D8206A192374EF9421FDA5233F66349A")
    public int getCdmaEriIconIndex() {
        logUnexpectedCdmaMethodCall("getCdmaEriIconIndex");
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_723607873 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_723607873;
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("getCdmaEriIconIndex");
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.454 -0400", hash_original_method = "F2685CF828A9991D177F425CEE905936", hash_generated_method = "F1B790C82ED68E20982D7B6EAB12E770")
    public int getCdmaEriIconMode() {
        logUnexpectedCdmaMethodCall("getCdmaEriIconMode");
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1682268365 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1682268365;
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("getCdmaEriIconMode");
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.454 -0400", hash_original_method = "B9212A70F84EE88792E9F77579D252EB", hash_generated_method = "40F1F7549AD9A34720F046C0F7F43826")
    public String getCdmaEriText() {
        String varB4EAC82CA7396A68D541C85D26508E83_1008727359 = null; //Variable for return #1
        logUnexpectedCdmaMethodCall("getCdmaEriText");
        varB4EAC82CA7396A68D541C85D26508E83_1008727359 = "GSM nw, no ERI";
        varB4EAC82CA7396A68D541C85D26508E83_1008727359.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1008727359;
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("getCdmaEriText");
        //return "GSM nw, no ERI";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.454 -0400", hash_original_method = "31C17E46EDF55F22A4F7752D6C0E6244", hash_generated_method = "EADBAD64DC2E21E85841057CD6D46EE5")
    public String getCdmaMin() {
        String varB4EAC82CA7396A68D541C85D26508E83_955235866 = null; //Variable for return #1
        logUnexpectedCdmaMethodCall("getCdmaMin");
        varB4EAC82CA7396A68D541C85D26508E83_955235866 = null;
        varB4EAC82CA7396A68D541C85D26508E83_955235866.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_955235866;
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("getCdmaMin");
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.460 -0400", hash_original_method = "5ED51837BFBC47DED520188DB45BE3ED", hash_generated_method = "F8C6FB05862928997CD967C8EA1F6AB0")
    public boolean isMinInfoReady() {
        logUnexpectedCdmaMethodCall("isMinInfoReady");
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_476137426 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_476137426;
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("isMinInfoReady");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.460 -0400", hash_original_method = "A959C6A3260B45047463EF5F7B599FA2", hash_generated_method = "A52A69C74C6485360649D21D84F4CE6C")
    public String getCdmaPrlVersion() {
        String varB4EAC82CA7396A68D541C85D26508E83_1883970061 = null; //Variable for return #1
        logUnexpectedCdmaMethodCall("getCdmaPrlVersion");
        varB4EAC82CA7396A68D541C85D26508E83_1883970061 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1883970061.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1883970061;
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("getCdmaPrlVersion");
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.460 -0400", hash_original_method = "2891F3B114A0E9671C3D7B6F8CA784DA", hash_generated_method = "9B503CBD877BDF19D2ADF52B1073AD8B")
    public void sendBurstDtmf(String dtmfString, int on, int off, Message onComplete) {
        logUnexpectedCdmaMethodCall("sendBurstDtmf");
        addTaint(dtmfString.getTaint());
        addTaint(on);
        addTaint(off);
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("sendBurstDtmf");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.461 -0400", hash_original_method = "1233D801AF5BD64366571B89C874921A", hash_generated_method = "C419AD7983ACE1A8CECC53CA8062906D")
    public void exitEmergencyCallbackMode() {
        logUnexpectedCdmaMethodCall("exitEmergencyCallbackMode");
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("exitEmergencyCallbackMode");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.461 -0400", hash_original_method = "A559D3AF3D26E6025D0072F9A69D12D5", hash_generated_method = "B1829B193D76CAC38AADFE9529150F72")
    public void registerForCdmaOtaStatusChange(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        logUnexpectedCdmaMethodCall("registerForCdmaOtaStatusChange");
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("registerForCdmaOtaStatusChange");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.467 -0400", hash_original_method = "ECF4F8F98FA1956C40263AEBA8AA4F0E", hash_generated_method = "5733A0E2A2FABA81219325A13D679F2C")
    public void unregisterForCdmaOtaStatusChange(Handler h) {
        logUnexpectedCdmaMethodCall("unregisterForCdmaOtaStatusChange");
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("unregisterForCdmaOtaStatusChange");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.468 -0400", hash_original_method = "D0126A4408C76F0C8443237E283C8B7B", hash_generated_method = "CF22B3A0D9367A698CFB06EF61DE2AB1")
    public void registerForSubscriptionInfoReady(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        logUnexpectedCdmaMethodCall("registerForSubscriptionInfoReady");
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("registerForSubscriptionInfoReady");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.468 -0400", hash_original_method = "87FC8275C239D995B7197317524E9D40", hash_generated_method = "218B850946A51144A7BE773BA5138994")
    public void unregisterForSubscriptionInfoReady(Handler h) {
        logUnexpectedCdmaMethodCall("unregisterForSubscriptionInfoReady");
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("unregisterForSubscriptionInfoReady");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.468 -0400", hash_original_method = "08A6E4B71FA09531A80AE7640F0ED8FC", hash_generated_method = "DA37318E63F90A34974E97192DD97BF7")
    public boolean needsOtaServiceProvisioning() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2139680842 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2139680842;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.468 -0400", hash_original_method = "A73C77982F42451CD95F88A8474FB403", hash_generated_method = "8CEDA3D186AB2620DCA39F830B5579E2")
    public boolean isOtaSpNumber(String dialStr) {
        addTaint(dialStr.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1926436897 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1926436897;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.469 -0400", hash_original_method = "663CEDCAC596E020E0D8D3DEB84218C7", hash_generated_method = "A2E0172EE3CA1284DFE7DF39B51399F4")
    public void registerForCallWaiting(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        logUnexpectedCdmaMethodCall("registerForCallWaiting");
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("registerForCallWaiting");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.469 -0400", hash_original_method = "6A9877CFE858A21BAD2DF20E221EE6F8", hash_generated_method = "2EBC4F493E0BED9B2C2B2132967EAF7F")
    public void unregisterForCallWaiting(Handler h) {
        logUnexpectedCdmaMethodCall("unregisterForCallWaiting");
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("unregisterForCallWaiting");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.469 -0400", hash_original_method = "DCA99E7B790465429FB14A326BDABF1A", hash_generated_method = "0460907A95037F278DD15DA8651A49B6")
    public void registerForEcmTimerReset(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        logUnexpectedCdmaMethodCall("registerForEcmTimerReset");
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("registerForEcmTimerReset");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.469 -0400", hash_original_method = "7FC556E6839E1551B3AA1598A94EB641", hash_generated_method = "A08FAB3A07056E67EA9E10A3860B8394")
    public void unregisterForEcmTimerReset(Handler h) {
        logUnexpectedCdmaMethodCall("unregisterForEcmTimerReset");
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("unregisterForEcmTimerReset");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.470 -0400", hash_original_method = "9EA1B9B633F04B4B40F6D988C6C6EAE0", hash_generated_method = "4BF69A3A629569EC057C66093D3B3B89")
    public void registerForSignalInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mCM.registerForSignalInfo(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mCM.registerForSignalInfo(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.477 -0400", hash_original_method = "490F0951818D5A292B4D850AA9A9557C", hash_generated_method = "C89D231B56261C224C227441E84BCE93")
    public void unregisterForSignalInfo(Handler h) {
        mCM.unregisterForSignalInfo(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mCM.unregisterForSignalInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.477 -0400", hash_original_method = "9A93FB64A77E8F3AD75482A91959C175", hash_generated_method = "9E3516F0032D24CFEB39F6944068B5CE")
    public void registerForDisplayInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mCM.registerForDisplayInfo(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mCM.registerForDisplayInfo(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.477 -0400", hash_original_method = "1D7139AB5835E964A2112E0A96A55533", hash_generated_method = "CB8F48B102096CCC5DD64737DAFA5C16")
    public void unregisterForDisplayInfo(Handler h) {
        mCM.unregisterForDisplayInfo(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mCM.unregisterForDisplayInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.478 -0400", hash_original_method = "735A13B0D1CB0B503F36D15D851EF79F", hash_generated_method = "FFB892BDA47BF5A754C3ACB7D59EF1A7")
    public void registerForNumberInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mCM.registerForNumberInfo(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mCM.registerForNumberInfo(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.478 -0400", hash_original_method = "6DBE3FA0B44D5F0F3EA0C4D2C4C9DEA2", hash_generated_method = "74B4801AE0A089972F23973367BB2239")
    public void unregisterForNumberInfo(Handler h) {
        mCM.unregisterForNumberInfo(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mCM.unregisterForNumberInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.479 -0400", hash_original_method = "D3A5B2415D3398E5BAA61633747135F3", hash_generated_method = "A34D78977D562292B42D2C43FAF7E7AB")
    public void registerForRedirectedNumberInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mCM.registerForRedirectedNumberInfo(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mCM.registerForRedirectedNumberInfo(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.479 -0400", hash_original_method = "FEE62A9F06FB60B95297A2B9A46AFB0E", hash_generated_method = "05D4A04922EA783C837CC491B36562AC")
    public void unregisterForRedirectedNumberInfo(Handler h) {
        mCM.unregisterForRedirectedNumberInfo(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mCM.unregisterForRedirectedNumberInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.479 -0400", hash_original_method = "73B61604D8C534BA3038C74FC6F1FC84", hash_generated_method = "51F868D6D4C07153F403BE557D8E7B4D")
    public void registerForLineControlInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mCM.registerForLineControlInfo( h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mCM.registerForLineControlInfo( h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.479 -0400", hash_original_method = "5D4E66E94B3A48B485E9B9F7921C3B01", hash_generated_method = "9A9F303165F48FDB22B6CD9DBA02C4BC")
    public void unregisterForLineControlInfo(Handler h) {
        mCM.unregisterForLineControlInfo(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mCM.unregisterForLineControlInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.486 -0400", hash_original_method = "590438B1B11ADBD08E7A44131058572B", hash_generated_method = "212C2F42C006C867420BCD76076C1924")
    public void registerFoT53ClirlInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mCM.registerFoT53ClirlInfo(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mCM.registerFoT53ClirlInfo(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.486 -0400", hash_original_method = "034ED9AF183776C78D98034D25F265A2", hash_generated_method = "EF26CA7D1C932779B061B9B5FB7A3078")
    public void unregisterForT53ClirInfo(Handler h) {
        mCM.unregisterForT53ClirInfo(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mCM.unregisterForT53ClirInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.486 -0400", hash_original_method = "66D030845270A8F126DBBDF302E2A141", hash_generated_method = "D771CBEE624EA317CADE12053DA66D4B")
    public void registerForT53AudioControlInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mCM.registerForT53AudioControlInfo( h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mCM.registerForT53AudioControlInfo( h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.486 -0400", hash_original_method = "C4F9238B8E9649490800210FA099DE0F", hash_generated_method = "F8CFD2CB087C4F0AE00B18D59FF19BB2")
    public void unregisterForT53AudioControlInfo(Handler h) {
        mCM.unregisterForT53AudioControlInfo(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mCM.unregisterForT53AudioControlInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.490 -0400", hash_original_method = "815749C135EEAFF1973468BF7BE05E75", hash_generated_method = "E3D88F38177129CB310AB2CB99C0E2E8")
    public void setOnEcbModeExitResponse(Handler h, int what, Object obj) {
        logUnexpectedCdmaMethodCall("setOnEcbModeExitResponse");
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("setOnEcbModeExitResponse");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.492 -0400", hash_original_method = "ECE14734C7F2F497945A22923EF26B0A", hash_generated_method = "230EAD248D5DB6A536AE4C923A6EAFDB")
    public void unsetOnEcbModeExitResponse(Handler h) {
        logUnexpectedCdmaMethodCall("unsetOnEcbModeExitResponse");
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("unsetOnEcbModeExitResponse");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.492 -0400", hash_original_method = "04CB7EBB1F2C2F5A1F94C891E246EC01", hash_generated_method = "B93BCB8D5E80B7653DEAC40D86E5C50C")
    public String[] getActiveApnTypes() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_728521149 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_728521149 = mDataConnectionTracker.getActiveApnTypes();
        varB4EAC82CA7396A68D541C85D26508E83_728521149.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_728521149;
        // ---------- Original Method ----------
        //return mDataConnectionTracker.getActiveApnTypes();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.492 -0400", hash_original_method = "D30362481D576467EFD2166079686420", hash_generated_method = "59D02C09D2DEADEF1DC413EC8BB83F3F")
    public String getActiveApnHost(String apnType) {
        String varB4EAC82CA7396A68D541C85D26508E83_1027343102 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1027343102 = mDataConnectionTracker.getActiveApnString(apnType);
        addTaint(apnType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1027343102.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1027343102;
        // ---------- Original Method ----------
        //return mDataConnectionTracker.getActiveApnString(apnType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.493 -0400", hash_original_method = "C11066F2623E480AC3C630C6CBD36058", hash_generated_method = "33CE4C37CA3FD7FD7E4C2B4EF8282573")
    public LinkProperties getLinkProperties(String apnType) {
        LinkProperties varB4EAC82CA7396A68D541C85D26508E83_1521981459 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1521981459 = mDataConnectionTracker.getLinkProperties(apnType);
        addTaint(apnType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1521981459.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1521981459;
        // ---------- Original Method ----------
        //return mDataConnectionTracker.getLinkProperties(apnType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.494 -0400", hash_original_method = "035A2689990E07C724064B64E344B05A", hash_generated_method = "FCB37E4D36581637E40CE8CC79E4CA5E")
    public LinkCapabilities getLinkCapabilities(String apnType) {
        LinkCapabilities varB4EAC82CA7396A68D541C85D26508E83_417143128 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_417143128 = mDataConnectionTracker.getLinkCapabilities(apnType);
        addTaint(apnType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_417143128.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_417143128;
        // ---------- Original Method ----------
        //return mDataConnectionTracker.getLinkCapabilities(apnType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.494 -0400", hash_original_method = "8FC26686EA9F953DFAC2E032B4ED9578", hash_generated_method = "AA38F18F20B0BB6F28586ABC91E6E76C")
    public int enableApnType(String type) {
        int varDF3C53CB85D858230747E36923D6A726_2051809544 = (mDataConnectionTracker.enableApnType(type));
        addTaint(type.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1257811525 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1257811525;
        // ---------- Original Method ----------
        //return mDataConnectionTracker.enableApnType(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.494 -0400", hash_original_method = "EEF84E670D69A41297DD287EFE00D426", hash_generated_method = "BAD70A1EA7418BFC3706E7D6B440F04C")
    public int disableApnType(String type) {
        int var6C853F768C2F44BB0E963400679EF2D6_1579533443 = (mDataConnectionTracker.disableApnType(type));
        addTaint(type.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_426330731 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_426330731;
        // ---------- Original Method ----------
        //return mDataConnectionTracker.disableApnType(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.501 -0400", hash_original_method = "0E7DDF56B2AD7D089B639A5A4C8707B8", hash_generated_method = "83B89A4DE32F9F84715CB59640DBED66")
    public boolean isDataConnectivityPossible() {
        boolean var72302C29A137970B018198D274956B4F_1468243577 = (isDataConnectivityPossible(Phone.APN_TYPE_DEFAULT));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_155288703 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_155288703;
        // ---------- Original Method ----------
        //return isDataConnectivityPossible(Phone.APN_TYPE_DEFAULT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.506 -0400", hash_original_method = "D1C4C7300A786DB2DE96913E45D224C3", hash_generated_method = "CDAABA29B91A8010172BE749A52078F2")
    public boolean isDataConnectivityPossible(String apnType) {
        boolean varDADABF19322860B2D8E43DBCBAC0403E_1455475912 = (((mDataConnectionTracker != null) &&
                (mDataConnectionTracker.isDataPossible(apnType))));
        addTaint(apnType.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1377852232 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1377852232;
        // ---------- Original Method ----------
        //return ((mDataConnectionTracker != null) &&
                //(mDataConnectionTracker.isDataPossible(apnType)));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.506 -0400", hash_original_method = "78C210B796AC9661779AB486B8F70A37", hash_generated_method = "E4457ACA811C3C4D8565D02B00955C41")
    protected void notifyNewRingingConnectionP(Connection cn) {
        AsyncResult ar;
        ar = new AsyncResult(null, cn, null);
        mNewRingingConnectionRegistrants.notifyRegistrants(ar);
        addTaint(cn.getTaint());
        // ---------- Original Method ----------
        //if (!mIsVoiceCapable)
            //return;
        //AsyncResult ar = new AsyncResult(null, cn, null);
        //mNewRingingConnectionRegistrants.notifyRegistrants(ar);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.506 -0400", hash_original_method = "E77A37BE6BEB7ED310F1875BE08F1BE3", hash_generated_method = "E3A5356587E625E501757FB995E452BF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.508 -0400", hash_original_method = "E1A10981C368CA09B703B9716F98BBE5", hash_generated_method = "8857A2531309A8914F1A067DD7DCC206")
    private void sendIncomingCallRingNotification(int token) {
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
        addTaint(token);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.508 -0400", hash_original_method = "3242BA07687ED62C3518200E2F9FB53F", hash_generated_method = "0E053E8BF9DC03D57D08FF8E7B60FDFE")
    public boolean isCspPlmnEnabled() {
        logUnexpectedGsmMethodCall("isCspPlmnEnabled");
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_448302284 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_448302284;
        // ---------- Original Method ----------
        //logUnexpectedGsmMethodCall("isCspPlmnEnabled");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.512 -0400", hash_original_method = "B1975F1CE49D1493C79D22CB0A320E47", hash_generated_method = "9148F1566DFA1DD0AB4443A4BFA13589")
    public IsimRecords getIsimRecords() {
        IsimRecords varB4EAC82CA7396A68D541C85D26508E83_1382973218 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1382973218 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1382973218.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1382973218;
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "getIsimRecords() is only supported on LTE devices");
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.512 -0400", hash_original_method = "0D543BE7AD53581775829ADD7A6346BC", hash_generated_method = "32D80756F53B0BBD186A936760EAF27B")
    public void requestIsimAuthentication(String nonce, Message result) {
        addTaint(nonce.getTaint());
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "requestIsimAuthentication() is only supported on LTE devices");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.515 -0400", hash_original_method = "60A69213567A9812671ADC8B66C5585F", hash_generated_method = "8FAA535857EC14E85120C6F18F46BD4B")
    public String getMsisdn() {
        String varB4EAC82CA7396A68D541C85D26508E83_1188071252 = null; //Variable for return #1
        logUnexpectedGsmMethodCall("getMsisdn");
        varB4EAC82CA7396A68D541C85D26508E83_1188071252 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1188071252.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1188071252;
        // ---------- Original Method ----------
        //logUnexpectedGsmMethodCall("getMsisdn");
        //return null;
    }

    
        private static void logUnexpectedCdmaMethodCall(String name) {
        Log.e(LOG_TAG, "Error! " + name + "() in PhoneBase should not be " +
                "called, CDMAPhone inactive.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.520 -0400", hash_original_method = "3916B54807B55A36DB6B185AF3F43F9B", hash_generated_method = "20728FD95391AB12EAC10E0E65771D63")
    public DataState getDataConnectionState() {
        DataState varB4EAC82CA7396A68D541C85D26508E83_1889280884 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1889280884 = getDataConnectionState(APN_TYPE_DEFAULT);
        varB4EAC82CA7396A68D541C85D26508E83_1889280884.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1889280884;
        // ---------- Original Method ----------
        //return getDataConnectionState(APN_TYPE_DEFAULT);
    }

    
        private static void logUnexpectedGsmMethodCall(String name) {
        Log.e(LOG_TAG, "Error! " + name + "() in PhoneBase should not be " +
                "called, GSMPhone inactive.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.520 -0400", hash_original_method = "3E0F86392A957104B8FBDE9CC6F59C4C", hash_generated_method = "58BFBC231130793F6A272E782A5696DC")
    public void notifyCallForwardingIndicator() {
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "Error! This function should never be executed, inactive CDMAPhone.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.521 -0400", hash_original_method = "920CBD0242A41CC292CB0CFE1F874523", hash_generated_method = "21C25FBE79724C88F08D603B8C7B434C")
    public void notifyDataConnectionFailed(String reason, String apnType) {
        mNotifier.notifyDataConnectionFailed(this, reason, apnType);
        addTaint(reason.getTaint());
        addTaint(apnType.getTaint());
        // ---------- Original Method ----------
        //mNotifier.notifyDataConnectionFailed(this, reason, apnType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.521 -0400", hash_original_method = "1FC25F07E17A01F63F573F1677883F29", hash_generated_method = "0E2834036E2777AD9B43CA5EE73F69A9")
    @Override
    public int getLteOnCdmaMode() {
        int var5CFC37F2D9C4A6A0C98F9CAA2D688F1A_1265767111 = (mCM.getLteOnCdmaMode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_646621710 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_646621710;
        // ---------- Original Method ----------
        //return mCM.getLteOnCdmaMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.521 -0400", hash_original_method = "B0657B144D34E1997F6D522B080186C1", hash_generated_method = "844E195E8427E4C1567D576B72CDE38F")
    @Override
    public void setVoiceMessageWaiting(int line, int countWaiting) {
        mIccRecords.setVoiceMessageWaiting(line, countWaiting);
        addTaint(line);
        addTaint(countWaiting);
        // ---------- Original Method ----------
        //mIccRecords.setVoiceMessageWaiting(line, countWaiting);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.522 -0400", hash_original_method = "099D11C8CFE57EFDDC5741548A2AEB3D", hash_generated_method = "2F492980013BB3A2D32D680DE5276A8C")
    @Override
    public UsimServiceTable getUsimServiceTable() {
        UsimServiceTable varB4EAC82CA7396A68D541C85D26508E83_421290825 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_421290825 = mIccRecords.getUsimServiceTable();
        varB4EAC82CA7396A68D541C85D26508E83_421290825.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_421290825;
        // ---------- Original Method ----------
        //return mIccRecords.getUsimServiceTable();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.534 -0400", hash_original_field = "8C61C83FB4E7AA2A98C50A63D7FB9679", hash_generated_field = "A92D635E73640822116CDBF982E76189")

    private static String LOG_TAG = "PHONE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.557 -0400", hash_original_field = "7F1E46EB212D9379AF8B593E529EF4C2", hash_generated_field = "5CAE480CB22B62FE8C5DA9BB47B33BCD")

    private static boolean LOCAL_DEBUG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.557 -0400", hash_original_field = "9FB4B8A90783DA9613AFFD310041951E", hash_generated_field = "30999E1536B998C0CCCADFCA2E186A73")

    public static final String NETWORK_SELECTION_KEY = "network_selection_key";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.557 -0400", hash_original_field = "07A14EDBC1369EBD89FC29D70AB51065", hash_generated_field = "4D95278747E96EA0717A9759EEFCE875")

    public static final String NETWORK_SELECTION_NAME_KEY = "network_selection_name_key";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.557 -0400", hash_original_field = "AC16C5F4A1E34C3D1DE7878A05C14512", hash_generated_field = "CFD39C473C87BFA4C5B1110D352F768C")

    public static final String DATA_DISABLED_ON_BOOT_KEY = "disabled_on_boot_key";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.557 -0400", hash_original_field = "E16D8C3D4B3A1EF070AB92CC8338E476", hash_generated_field = "29A44DF29AD3F26271827446F35DF0FB")

    protected static int EVENT_RADIO_AVAILABLE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.557 -0400", hash_original_field = "3D8E210ECF87C03DC96F905193014725", hash_generated_field = "82D598AD55EE417CA3D83EA2BA994C13")

    protected static int EVENT_SSN = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.557 -0400", hash_original_field = "4AF20B068C914F2DCD50E3651B01B455", hash_generated_field = "813224E692D436432A94CB8841C90428")

    protected static int EVENT_SIM_RECORDS_LOADED = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.557 -0400", hash_original_field = "6C846546FDB321ED9400D7DF113D907B", hash_generated_field = "22DED8A76D48AF685549EF234E52D447")

    protected static int EVENT_MMI_DONE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.557 -0400", hash_original_field = "FB959D562366CD62799427DD44F9E389", hash_generated_field = "59AF2CD1BB6C748E0652E245F6457878")

    protected static int EVENT_RADIO_ON = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.557 -0400", hash_original_field = "60B977A6A1A246E405EB6EFF72F09906", hash_generated_field = "114E50EFDD1A95C493261A8F1559C0A1")

    protected static int EVENT_GET_BASEBAND_VERSION_DONE = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.557 -0400", hash_original_field = "4B0F5621B6A951D1710A0AA717E6FE78", hash_generated_field = "516D2598E2A3617DCD8741ACA8B89A00")

    protected static int EVENT_USSD = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.557 -0400", hash_original_field = "1B78BFEC3CFED2AF2161F18379139A83", hash_generated_field = "35835ED27D7CF9C06BAC6228056838A8")

    protected static int EVENT_RADIO_OFF_OR_NOT_AVAILABLE = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.557 -0400", hash_original_field = "21F3F46C17A106F9A983519B923D057D", hash_generated_field = "66A726A47AA9E7A779858185F8872B24")

    protected static int EVENT_GET_IMEI_DONE = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.557 -0400", hash_original_field = "9882FDEAB11C65195AD70BB049481E77", hash_generated_field = "0000667FE3D281E4905CA57B9865A368")

    protected static int EVENT_GET_IMEISV_DONE = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.557 -0400", hash_original_field = "13EAD37DEFBAB1AFDB319710EDF30DA0", hash_generated_field = "7D7A095912ED9106A6FA78A1DCDB55B6")

    protected static int EVENT_GET_SIM_STATUS_DONE = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.557 -0400", hash_original_field = "AD8D0804246C1D141514EDA5940C9D1F", hash_generated_field = "FA339355D6373EEF63A5D5FBEDA036E3")

    protected static int EVENT_SET_CALL_FORWARD_DONE = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.557 -0400", hash_original_field = "4E788AADE151D5C8C7E0A706216D0C23", hash_generated_field = "4D91D32123C94A021C96272D3C336A60")

    protected static int EVENT_GET_CALL_FORWARD_DONE = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.557 -0400", hash_original_field = "3BBCE33DED884E1C10F035E4E0B678DC", hash_generated_field = "3073885B720374E37D77A1937161A4A2")

    protected static int EVENT_CALL_RING = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.558 -0400", hash_original_field = "D2E121C6F2B32945F9F009B6D03222B8", hash_generated_field = "35D329134C67379A1A059757BE3AD9D0")

    protected static int EVENT_CALL_RING_CONTINUE = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.558 -0400", hash_original_field = "3FCBE8EB5F59454A9668A2C48CC05E01", hash_generated_field = "9FA50948DD5E07D00E59DB8AF2FBC828")

    protected static int EVENT_SET_NETWORK_MANUAL_COMPLETE = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.558 -0400", hash_original_field = "C2FE1D004F9EC0A845F4110CAAE00CE9", hash_generated_field = "1DA8C9DA6CE8BEBA00CFB29F938B28E2")

    protected static int EVENT_SET_NETWORK_AUTOMATIC_COMPLETE = 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.558 -0400", hash_original_field = "968FC720F6C8981F12C9FEF464D488EA", hash_generated_field = "D89070871C642336D89B92DF5A278F19")

    protected static int EVENT_SET_CLIR_COMPLETE = 18;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.558 -0400", hash_original_field = "5D5F4AA336B5A56517328D2833900CF9", hash_generated_field = "E9637CEA764CFB0DB693479E278CCF47")

    protected static int EVENT_REGISTERED_TO_NETWORK = 19;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.558 -0400", hash_original_field = "6CD34EBB07F80972156850C9EFE76044", hash_generated_field = "53DBEF3929985CA7EC4D3D77E23FDEC7")

    protected static int EVENT_SET_VM_NUMBER_DONE = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.558 -0400", hash_original_field = "0885B96944C04E10E35E50D2F5EFB157", hash_generated_field = "4EF817AAF8242A2136A045B12023D7E8")

    protected static int EVENT_GET_DEVICE_IDENTITY_DONE = 21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.558 -0400", hash_original_field = "FD8E2E4612A2CCEFA6A37098E5316A31", hash_generated_field = "7ABAE9071DBF4B515864E6C0161354E8")

    protected static int EVENT_RUIM_RECORDS_LOADED = 22;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.558 -0400", hash_original_field = "CD55E3B1897A35367D22181D0372CB3E", hash_generated_field = "4C6B73E527138684E8D5BA5495491176")

    protected static int EVENT_NV_READY = 23;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.558 -0400", hash_original_field = "90D5FC3F23C7A02866B30F952A3CF25C", hash_generated_field = "30E49FE329C375ED1A392F3E6017B6F5")

    protected static int EVENT_SET_ENHANCED_VP = 24;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.558 -0400", hash_original_field = "F6A08538564CA706875A1011D90A2AF2", hash_generated_field = "23AFC949608F4F602D26D84414A9E1BB")

    protected static int EVENT_EMERGENCY_CALLBACK_MODE_ENTER = 25;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.558 -0400", hash_original_field = "31CEA8EBF9D9C470D2867CD87637B86F", hash_generated_field = "4B24797F06CE867F6A6CDFC6FFF3D97E")

    protected static int EVENT_EXIT_EMERGENCY_CALLBACK_RESPONSE = 26;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.558 -0400", hash_original_field = "D053E0B25088C99F47C3FD60BC2BD69F", hash_generated_field = "9A1A5B75F1AB4B2786E10ADC52774587")

    public static final String CLIR_KEY = "clir_key";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.558 -0400", hash_original_field = "595502B5C67E5C7D5745B347C567C531", hash_generated_field = "23F928F88F407C390580E9819551272F")

    public static final String DNS_SERVER_CHECK_DISABLED_KEY = "dns_server_check_disabled_key";
}

