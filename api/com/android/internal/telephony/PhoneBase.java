package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.660 -0400", hash_original_field = "E7C221DB31E51F3F1CDC4689D17720C2", hash_generated_field = "0AC6FF61658A415C5960AD3646988614")

    public CommandsInterface mCM;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.660 -0400", hash_original_field = "468652BF843E336CFF551B50C329526F", hash_generated_field = "198CC7CC33D8E2C02C5C9590CB5AD311")

    protected IccFileHandler mIccFileHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.660 -0400", hash_original_field = "C12E4AC723C288B61D322062D91081B5", hash_generated_field = "8A6DB45685594C6B3CA56D072EAE88A2")

    boolean mDnsCheckDisabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.660 -0400", hash_original_field = "9A9C0EBC5F526311B48334D7F45EB12C", hash_generated_field = "12EFF52E123F190477A6BAA0D7E8BFC7")

    public DataConnectionTracker mDataConnectionTracker;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.660 -0400", hash_original_field = "EE3FE7245E74958CAE8034777BEEA8B4", hash_generated_field = "7012C269E9F9BA8E17E0D6E257D14593")

    boolean mDoesRilSendMultipleCallRing;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.660 -0400", hash_original_field = "471067A610965490C0B36D06578B215E", hash_generated_field = "6DF77C84901D61F939B98BC5F13EC488")

    int mCallRingContinueToken;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.660 -0400", hash_original_field = "318D491062090302154EC3506C3334FD", hash_generated_field = "8B2C85FE062C8E1E1BE9A9671BFD773E")

    int mCallRingDelay;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.660 -0400", hash_original_field = "DD30091BF44B847FB6465E8B57CD5AB6", hash_generated_field = "7AC2DAF64A3A2115F12FB6B4AC4A0E0E")

    public boolean mIsTheCurrentActivePhone = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.661 -0400", hash_original_field = "D57DDA0136A7F0A5C975D75CCD876E99", hash_generated_field = "5B4D36755C5058654DC5817A0531A0FC")

    boolean mIsVoiceCapable = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.661 -0400", hash_original_field = "C90E66D30105E64A69B0470347184F2E", hash_generated_field = "373EB9ACD432C91447EB4C9C52571686")

    public IccRecords mIccRecords;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.661 -0400", hash_original_field = "D30B0F4E33C60E156D6B9A465CCE0A9C", hash_generated_field = "FDCA805CE2E645965D8424F392885596")

    public IccCard mIccCard;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.661 -0400", hash_original_field = "10C8BA4A75E9540145A9C975173E644E", hash_generated_field = "FFF9200D373C7FEFEF20A4999EB8139A")

    public SmsStorageMonitor mSmsStorageMonitor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.661 -0400", hash_original_field = "4D552408A6FCA16BC34ACDC443DAE64E", hash_generated_field = "7806E0DA87D41123DEDBE3D402001152")

    public SmsUsageMonitor mSmsUsageMonitor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.661 -0400", hash_original_field = "13732D6DCF8B8DFEB7A05955ED67A616", hash_generated_field = "1CCDFDF0949A05986349192A62052DA8")

    public SMSDispatcher mSMS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.661 -0400", hash_original_field = "2A00E7783B25841870BB9326860F9D07", hash_generated_field = "54C243033BEBCE89872AA38C79850516")

    protected final RegistrantList mPreciseCallStateRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.661 -0400", hash_original_field = "046AD962F76E43F793C72A8520081388", hash_generated_field = "101691E4380D6E13B925179B8832B960")

    protected final RegistrantList mNewRingingConnectionRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.661 -0400", hash_original_field = "4C7B39D5A9D904D8B1C5B59EA05D3E19", hash_generated_field = "716CB74230EA386C1645F6ADE899B5ED")

    protected final RegistrantList mIncomingRingRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.661 -0400", hash_original_field = "6B17894FE235D6A8C0BBEE6382BF1CDE", hash_generated_field = "21C4CB3D67106CE269A374EF938B2488")

    protected final RegistrantList mDisconnectRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.661 -0400", hash_original_field = "99A28BF65FE1E029B35B39D9FDFB3BFF", hash_generated_field = "CCBE3B1F1C3C43B0D0455394A23A5711")

    protected final RegistrantList mServiceStateRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.661 -0400", hash_original_field = "0AE36B7A06695323758D47DC20170D52", hash_generated_field = "772992E80B305C05B30F1419725B97CD")

    protected final RegistrantList mMmiCompleteRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.661 -0400", hash_original_field = "0B1A7701B95E2A553C6027F90A4D24CE", hash_generated_field = "114239A2A412532ACC57B1CDDF1CD841")

    protected final RegistrantList mMmiRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.661 -0400", hash_original_field = "F7ADD316BD43AB6664404F10762B7C57", hash_generated_field = "1506E6C74D88F0FEE5B24B1D055AAE0A")

    protected final RegistrantList mUnknownConnectionRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.661 -0400", hash_original_field = "9F99D3D12ACFC19F3630650F9E356767", hash_generated_field = "D49D8AF4024090CFDB28FE746E4D9BC6")

    protected final RegistrantList mSuppServiceFailedRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.661 -0400", hash_original_field = "DA288C1345E9C94467C02060ED19C6FA", hash_generated_field = "D741950DD4D297A5A97E2573D2099374")

    protected Looper mLooper;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.661 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B3359F86E29A965BC1436888E98C55A8")

    protected Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.661 -0400", hash_original_field = "B9C5CA8CA7E27D8D9C93841E740D9D20", hash_generated_field = "0DBF65814173CE16A85F1AA98BDF5F5E")

    protected PhoneNotifier mNotifier;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.662 -0400", hash_original_field = "EB66409812E41FE34BF5C0DEF3D420BF", hash_generated_field = "3A8866AF6F9DF724308515FF86538AAE")

    protected SimulatedRadioControl mSimulatedRadioControl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.662 -0400", hash_original_field = "089ED708F2208CFF55FCCE18DCF579A1", hash_generated_field = "F1D2CE7105A6C577055D5D2EA9384903")

    boolean mUnitTestMode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.662 -0400", hash_original_method = "0B01EDD7CFA10DA565A9E13F0B7F18B5", hash_generated_method = "2C3DED843498E831A7674C54CCAAFAF1")
    protected  PhoneBase(PhoneNotifier notifier, Context context, CommandsInterface ci) {
        this(notifier, context, ci, false);
        addTaint(ci.getTaint());
        addTaint(context.getTaint());
        addTaint(notifier.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.663 -0400", hash_original_method = "0B181FBA64FE5D093F6319BFF754183A", hash_generated_method = "D3D1B9806C065CC0E654F622AB0519E0")
    protected  PhoneBase(PhoneNotifier notifier, Context context, CommandsInterface ci,
            boolean unitTestMode) {
        addTaint(unitTestMode);
        this.mNotifier = notifier;
        this.mContext = context;
        mLooper = Looper.myLooper();
        mCM = ci;
        setPropertiesByCarrier();
        setUnitTestMode(unitTestMode);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.664 -0400", hash_original_method = "5E4CE6B07EFCD29EE81659A348140E39", hash_generated_method = "A69522929DAFE06C8D9AA7C8620959CB")
    public void setSystemProperty(String property, String value) {
        addTaint(value.getTaint());
        addTaint(property.getTaint());
        if(getUnitTestMode())        
        {
            return;
        } //End block
        SystemProperties.set(property, value);
        // ---------- Original Method ----------
        //if(getUnitTestMode()) {
            //return;
        //}
        //SystemProperties.set(property, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.664 -0400", hash_original_method = "E6D9767A803FC78FE4F21E8C0AA16E1B", hash_generated_method = "67C8A81B2A777B228BB9126DB0056C8C")
    public void dispose() {
        synchronized
(PhoneProxy.lockForRadioTechnologyChange)        {
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.665 -0400", hash_original_method = "AD2C393D4007178071128FB79D198E7A", hash_generated_method = "939AA9D60C792DDBF5AE38E81D1C4004")
    public void removeReferences() {
        mSmsStorageMonitor = null;
        mSmsUsageMonitor = null;
        // ---------- Original Method ----------
        //mSmsStorageMonitor = null;
        //mSmsUsageMonitor = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.666 -0400", hash_original_method = "DB16D19FE7C055C53AF6F04667B938A9", hash_generated_method = "18A135771F7E662CE07DB6C555661707")
    @Override
    public void handleMessage(Message msg) {
        addTaint(msg.getTaint());
        AsyncResult ar;
switch(msg.what){
        case EVENT_CALL_RING:
        Log.d(LOG_TAG, "Event EVENT_CALL_RING Received state=" + getState());
        ar = (AsyncResult)msg.obj;
        if(ar.exception == null)        
        {
            Phone.State state = getState();
            if((!mDoesRilSendMultipleCallRing)
                            && ((state == Phone.State.RINGING) || (state == Phone.State.IDLE)))            
            {
                mCallRingContinueToken += 1;
                sendIncomingCallRingNotification(mCallRingContinueToken);
            } //End block
            else
            {
                notifyIncomingRing();
            } //End block
        } //End block
        break;
        case EVENT_CALL_RING_CONTINUE:
        Log.d(LOG_TAG, "Event EVENT_CALL_RING_CONTINUE Received stat=" + getState());
        if(getState() == Phone.State.RINGING)        
        {
            sendIncomingCallRingNotification(msg.arg1);
        } //End block
        break;
        default:
        RuntimeException var1F26AA1784701DB7B59508D786B99B94_1892583987 = new RuntimeException("unexpected event not handled");
        var1F26AA1784701DB7B59508D786B99B94_1892583987.addTaint(taint);
        throw var1F26AA1784701DB7B59508D786B99B94_1892583987;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.666 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "4D6E7C068BD95FD5ADEB80D2E308A8AF")
    public Context getContext() {
Context var178E2AD52D6FBBB503F908168856B574_132467617 =         mContext;
        var178E2AD52D6FBBB503F908168856B574_132467617.addTaint(taint);
        return var178E2AD52D6FBBB503F908168856B574_132467617;
        // ---------- Original Method ----------
        //return mContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.666 -0400", hash_original_method = "6B58AC4FFDA912638B2751BFF719D57B", hash_generated_method = "E9D4818D2C3D7D0746F424278F12A734")
    public void disableDnsCheck(boolean b) {
        mDnsCheckDisabled = b;
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(DNS_SERVER_CHECK_DISABLED_KEY, b);
        editor.apply();
        // ---------- Original Method ----------
        //mDnsCheckDisabled = b;
        //SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        //SharedPreferences.Editor editor = sp.edit();
        //editor.putBoolean(DNS_SERVER_CHECK_DISABLED_KEY, b);
        //editor.apply();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.667 -0400", hash_original_method = "26E6CAA04D711DCC258BDCDD2AAE1C53", hash_generated_method = "EACF6FF8A83718D9888238066941119B")
    public boolean isDnsCheckDisabled() {
        boolean varC12E4AC723C288B61D322062D91081B5_2056710805 = (mDnsCheckDisabled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_71490732 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_71490732;
        // ---------- Original Method ----------
        //return mDnsCheckDisabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.667 -0400", hash_original_method = "97FD2D9125201743A42C7236EAF94A65", hash_generated_method = "7C621E1B0A0B3A56FF57A7416EAC40A4")
    public void registerForPreciseCallStateChanged(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        checkCorrectThread(h);
        mPreciseCallStateRegistrants.addUnique(h, what, obj);
        // ---------- Original Method ----------
        //checkCorrectThread(h);
        //mPreciseCallStateRegistrants.addUnique(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.668 -0400", hash_original_method = "3468093E0DED2950A146A2A89C89E0C9", hash_generated_method = "12B3762DF016F3CE29D5BD8DB1F6A8F4")
    public void unregisterForPreciseCallStateChanged(Handler h) {
        addTaint(h.getTaint());
        mPreciseCallStateRegistrants.remove(h);
        // ---------- Original Method ----------
        //mPreciseCallStateRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.668 -0400", hash_original_method = "7D1AEC63A120FA3D327FCF14A278BC6F", hash_generated_method = "C253A61217F84996C5EB67B0A3629161")
    protected void notifyPreciseCallStateChangedP() {
        AsyncResult ar = new AsyncResult(null, this, null);
        mPreciseCallStateRegistrants.notifyRegistrants(ar);
        // ---------- Original Method ----------
        //AsyncResult ar = new AsyncResult(null, this, null);
        //mPreciseCallStateRegistrants.notifyRegistrants(ar);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.669 -0400", hash_original_method = "B9AA4FF50180EB9A48B29DB9F5910CE4", hash_generated_method = "505F5E3E0F898C0D3E833E35E0976882")
    public void registerForUnknownConnection(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        checkCorrectThread(h);
        mUnknownConnectionRegistrants.addUnique(h, what, obj);
        // ---------- Original Method ----------
        //checkCorrectThread(h);
        //mUnknownConnectionRegistrants.addUnique(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.669 -0400", hash_original_method = "75B09E3F4F0ED781C6A40D2F37829CA0", hash_generated_method = "3C1C66796BFD21DB8ECDBA50EB0D8A5B")
    public void unregisterForUnknownConnection(Handler h) {
        addTaint(h.getTaint());
        mUnknownConnectionRegistrants.remove(h);
        // ---------- Original Method ----------
        //mUnknownConnectionRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.669 -0400", hash_original_method = "AD1FA3FDB645CF1FEF5A2946EFD96B38", hash_generated_method = "81B60756BBF5677EFEEB2F5D3593DDDB")
    public void registerForNewRingingConnection(
            Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        checkCorrectThread(h);
        mNewRingingConnectionRegistrants.addUnique(h, what, obj);
        // ---------- Original Method ----------
        //checkCorrectThread(h);
        //mNewRingingConnectionRegistrants.addUnique(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.669 -0400", hash_original_method = "058A0D079EFCE83305D698FFA7B5D825", hash_generated_method = "EFD625D26F94775D2143AE4AEC8A8F53")
    public void unregisterForNewRingingConnection(Handler h) {
        addTaint(h.getTaint());
        mNewRingingConnectionRegistrants.remove(h);
        // ---------- Original Method ----------
        //mNewRingingConnectionRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.669 -0400", hash_original_method = "0EC65AF661091C788FEAC732E62723E6", hash_generated_method = "19E20B7FF9F46A75D68E435F813DFB1E")
    public void registerForInCallVoicePrivacyOn(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mCM.registerForInCallVoicePrivacyOn(h,what,obj);
        // ---------- Original Method ----------
        //mCM.registerForInCallVoicePrivacyOn(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.669 -0400", hash_original_method = "AAF2DABAA6CCE680F9F5730540C91C97", hash_generated_method = "FE8D617A35B3B7853917EB368378D38C")
    public void unregisterForInCallVoicePrivacyOn(Handler h) {
        addTaint(h.getTaint());
        mCM.unregisterForInCallVoicePrivacyOn(h);
        // ---------- Original Method ----------
        //mCM.unregisterForInCallVoicePrivacyOn(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.669 -0400", hash_original_method = "5EF015768DAEEB9D8933F39BF43636FD", hash_generated_method = "FD914DD362613D04EB7FD38626FCAAC5")
    public void registerForInCallVoicePrivacyOff(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mCM.registerForInCallVoicePrivacyOff(h,what,obj);
        // ---------- Original Method ----------
        //mCM.registerForInCallVoicePrivacyOff(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.670 -0400", hash_original_method = "D5B23AF1D1217C6A3E1625439D35B2E2", hash_generated_method = "9A00F2D760F759EC4EC029EF49FED0F1")
    public void unregisterForInCallVoicePrivacyOff(Handler h) {
        addTaint(h.getTaint());
        mCM.unregisterForInCallVoicePrivacyOff(h);
        // ---------- Original Method ----------
        //mCM.unregisterForInCallVoicePrivacyOff(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.670 -0400", hash_original_method = "50A4B0D73C58D3A2BE8105C1A17D2698", hash_generated_method = "93E7CB754BCF2F3F2BF29F6AF63AF0EB")
    public void registerForIncomingRing(
            Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        checkCorrectThread(h);
        mIncomingRingRegistrants.addUnique(h, what, obj);
        // ---------- Original Method ----------
        //checkCorrectThread(h);
        //mIncomingRingRegistrants.addUnique(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.670 -0400", hash_original_method = "92E2BA35AB0B11C010FD1FF2A8E6A65B", hash_generated_method = "5AF3FC0E96966B94CB8918DA5F677931")
    public void unregisterForIncomingRing(Handler h) {
        addTaint(h.getTaint());
        mIncomingRingRegistrants.remove(h);
        // ---------- Original Method ----------
        //mIncomingRingRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.670 -0400", hash_original_method = "2053ED9D2D7BD498A1C704AFBEE337C3", hash_generated_method = "77A307DFB7ACFF21E16AE215C2EC56E2")
    public void registerForDisconnect(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        checkCorrectThread(h);
        mDisconnectRegistrants.addUnique(h, what, obj);
        // ---------- Original Method ----------
        //checkCorrectThread(h);
        //mDisconnectRegistrants.addUnique(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.670 -0400", hash_original_method = "77A19CF742BA6691CDA7407600B4E7F3", hash_generated_method = "E60A013173E951A176C9DBBAC143842C")
    public void unregisterForDisconnect(Handler h) {
        addTaint(h.getTaint());
        mDisconnectRegistrants.remove(h);
        // ---------- Original Method ----------
        //mDisconnectRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.670 -0400", hash_original_method = "D574E9C9A24655069A0054F4E3538F49", hash_generated_method = "13B2E70CDCEDEB4A43B4D006BFDA53B1")
    public void registerForSuppServiceFailed(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        checkCorrectThread(h);
        mSuppServiceFailedRegistrants.addUnique(h, what, obj);
        // ---------- Original Method ----------
        //checkCorrectThread(h);
        //mSuppServiceFailedRegistrants.addUnique(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.671 -0400", hash_original_method = "C86C69890AF660CD858A7F262F783D04", hash_generated_method = "2854C9D2BF298D9A4B01E19C39F3FAFF")
    public void unregisterForSuppServiceFailed(Handler h) {
        addTaint(h.getTaint());
        mSuppServiceFailedRegistrants.remove(h);
        // ---------- Original Method ----------
        //mSuppServiceFailedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.671 -0400", hash_original_method = "04A8F1C35CFA7005AF5258C29F5FFE2B", hash_generated_method = "9E7B2C2B42BB507CF0C7C85D50D23599")
    public void registerForMmiInitiate(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        checkCorrectThread(h);
        mMmiRegistrants.addUnique(h, what, obj);
        // ---------- Original Method ----------
        //checkCorrectThread(h);
        //mMmiRegistrants.addUnique(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.671 -0400", hash_original_method = "338E9AA4432AD835C97CF49233FF5692", hash_generated_method = "B7AD16EE45FBB211E6DF54453A0DDEC7")
    public void unregisterForMmiInitiate(Handler h) {
        addTaint(h.getTaint());
        mMmiRegistrants.remove(h);
        // ---------- Original Method ----------
        //mMmiRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.671 -0400", hash_original_method = "61BE6CB4DF9A0C652F1BC7F7AD4D4CCB", hash_generated_method = "D38EF6A67652AAAED9F54CA6538CF4B4")
    public void registerForMmiComplete(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        checkCorrectThread(h);
        mMmiCompleteRegistrants.addUnique(h, what, obj);
        // ---------- Original Method ----------
        //checkCorrectThread(h);
        //mMmiCompleteRegistrants.addUnique(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.671 -0400", hash_original_method = "FE25021AB6559853BB3705423F117C85", hash_generated_method = "802219B34CB63AAB2B851A609D2A1E8B")
    public void unregisterForMmiComplete(Handler h) {
        addTaint(h.getTaint());
        checkCorrectThread(h);
        mMmiCompleteRegistrants.remove(h);
        // ---------- Original Method ----------
        //checkCorrectThread(h);
        //mMmiCompleteRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.672 -0400", hash_original_method = "764E722E685D5D307BCF00BDB294F564", hash_generated_method = "FB7A8BD3BF9EAED27315B4987F57DB0D")
    private String getSavedNetworkSelection() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
String varCD60401527CAE784EB7E0732112CDF57_1106864540 =         sp.getString(NETWORK_SELECTION_KEY, "");
        varCD60401527CAE784EB7E0732112CDF57_1106864540.addTaint(taint);
        return varCD60401527CAE784EB7E0732112CDF57_1106864540;
        // ---------- Original Method ----------
        //SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        //return sp.getString(NETWORK_SELECTION_KEY, "");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.672 -0400", hash_original_method = "29F19DECCCFC42207CFA8F3911C2D799", hash_generated_method = "5815DA3D5BCE551E7784A65322077852")
    public void restoreSavedNetworkSelection(Message response) {
        addTaint(response.getTaint());
        String networkSelection = getSavedNetworkSelection();
        if(TextUtils.isEmpty(networkSelection))        
        {
            mCM.setNetworkSelectionModeAutomatic(response);
        } //End block
        else
        {
            mCM.setNetworkSelectionModeManual(networkSelection, response);
        } //End block
        // ---------- Original Method ----------
        //String networkSelection = getSavedNetworkSelection();
        //if (TextUtils.isEmpty(networkSelection)) {
            //mCM.setNetworkSelectionModeAutomatic(response);
        //} else {
            //mCM.setNetworkSelectionModeManual(networkSelection, response);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.672 -0400", hash_original_method = "347AF2D7A75CED9B3C82A500C1FA5AD6", hash_generated_method = "3688FCA7B96722A600A49ED95FD11CA4")
    public void setUnitTestMode(boolean f) {
        mUnitTestMode = f;
        // ---------- Original Method ----------
        //mUnitTestMode = f;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.672 -0400", hash_original_method = "958D127406A24370C06699E6AB687F2A", hash_generated_method = "182F263CE0B15E60180D2AB1DE154369")
    public boolean getUnitTestMode() {
        boolean var089ED708F2208CFF55FCCE18DCF579A1_1442078089 = (mUnitTestMode);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_348735965 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_348735965;
        // ---------- Original Method ----------
        //return mUnitTestMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.672 -0400", hash_original_method = "80E90CBCA9EDC240B4F0091FF8E28C26", hash_generated_method = "91C0ADBF8D3674EE4BAE03F9D299DAC2")
    protected void notifyDisconnectP(Connection cn) {
        addTaint(cn.getTaint());
        AsyncResult ar = new AsyncResult(null, cn, null);
        mDisconnectRegistrants.notifyRegistrants(ar);
        // ---------- Original Method ----------
        //AsyncResult ar = new AsyncResult(null, cn, null);
        //mDisconnectRegistrants.notifyRegistrants(ar);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.672 -0400", hash_original_method = "BD17CCC0601D2F340E3F675C1E59C4B9", hash_generated_method = "692E7B0155696CF19AE22F3DE9BF4DFB")
    public void registerForServiceStateChanged(
            Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        checkCorrectThread(h);
        mServiceStateRegistrants.add(h, what, obj);
        // ---------- Original Method ----------
        //checkCorrectThread(h);
        //mServiceStateRegistrants.add(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.673 -0400", hash_original_method = "5AFF1BE54185C9B4577A75EFF0396B68", hash_generated_method = "BFDC9883CF192ECCA69913A03AB49682")
    public void unregisterForServiceStateChanged(Handler h) {
        addTaint(h.getTaint());
        mServiceStateRegistrants.remove(h);
        // ---------- Original Method ----------
        //mServiceStateRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.673 -0400", hash_original_method = "6C50CDA22F8E02023B34911844DFEED2", hash_generated_method = "9EFDBBA2BFB0329F7C1B71C651C4877D")
    public void registerForRingbackTone(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mCM.registerForRingbackTone(h,what,obj);
        // ---------- Original Method ----------
        //mCM.registerForRingbackTone(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.673 -0400", hash_original_method = "475301C04BE08B381350355879425A76", hash_generated_method = "102CC8F58297441001DFBD08EC9C83A4")
    public void unregisterForRingbackTone(Handler h) {
        addTaint(h.getTaint());
        mCM.unregisterForRingbackTone(h);
        // ---------- Original Method ----------
        //mCM.unregisterForRingbackTone(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.673 -0400", hash_original_method = "6FE1177D9BF24D9A41C1BE1AD2A93980", hash_generated_method = "F5C17F9B60110592D502146CDCC289B8")
    public void registerForResendIncallMute(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mCM.registerForResendIncallMute(h,what,obj);
        // ---------- Original Method ----------
        //mCM.registerForResendIncallMute(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.673 -0400", hash_original_method = "1E28EF1EEBC2208F47A83D89926DE82E", hash_generated_method = "EA4E0BED30FCA0546F18245188BCF5BE")
    public void unregisterForResendIncallMute(Handler h) {
        addTaint(h.getTaint());
        mCM.unregisterForResendIncallMute(h);
        // ---------- Original Method ----------
        //mCM.unregisterForResendIncallMute(h);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.673 -0400", hash_original_method = "F34715D262D40C908422031B6920D016", hash_generated_method = "4A991C5D707470F1B7A17B8AA612EC14")
    public void setEchoSuppressionEnabled(boolean enabled) {
        addTaint(enabled);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.673 -0400", hash_original_method = "D42B19E1304E0F299FEED69470ACF7B6", hash_generated_method = "671440D909D834F29CEE29579A111630")
    protected void notifyServiceStateChangedP(ServiceState ss) {
        addTaint(ss.getTaint());
        AsyncResult ar = new AsyncResult(null, ss, null);
        mServiceStateRegistrants.notifyRegistrants(ar);
        mNotifier.notifyServiceState(this);
        // ---------- Original Method ----------
        //AsyncResult ar = new AsyncResult(null, ss, null);
        //mServiceStateRegistrants.notifyRegistrants(ar);
        //mNotifier.notifyServiceState(this);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.673 -0400", hash_original_method = "6C132AD700E1EDF5A17434649EDA0F2C", hash_generated_method = "D311DB53552F90633164D63DC5C92923")
    public SimulatedRadioControl getSimulatedRadioControl() {
SimulatedRadioControl var7A8CA8055AD7F901B1CDD8BE378000C3_1990792031 =         mSimulatedRadioControl;
        var7A8CA8055AD7F901B1CDD8BE378000C3_1990792031.addTaint(taint);
        return var7A8CA8055AD7F901B1CDD8BE378000C3_1990792031;
        // ---------- Original Method ----------
        //return mSimulatedRadioControl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.674 -0400", hash_original_method = "930052C83226AF8DE91A3B058305558F", hash_generated_method = "38A36B56430D0C45352B086782871FE4")
    private void checkCorrectThread(Handler h) {
        addTaint(h.getTaint());
        if(h.getLooper() != mLooper)        
        {
            RuntimeException var3EF774217284F7BBBC61A3676A0ED99C_1476919822 = new RuntimeException(
                    "com.android.internal.telephony.Phone must be used from within one thread");
            var3EF774217284F7BBBC61A3676A0ED99C_1476919822.addTaint(taint);
            throw var3EF774217284F7BBBC61A3676A0ED99C_1476919822;
        } //End block
        // ---------- Original Method ----------
        //if (h.getLooper() != mLooper) {
            //throw new RuntimeException(
                    //"com.android.internal.telephony.Phone must be used from within one thread");
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.674 -0400", hash_original_method = "FDCB651DF17FF9811415182F19CE1B4C", hash_generated_method = "75A6D6DCF7C8AF86FC22C098A918404A")
    private void setPropertiesByCarrier() {
        String carrier = SystemProperties.get("ro.carrier");
        if(null == carrier || 0 == carrier.length() || "unknown".equals(carrier))        
        {
            return;
        } //End block
        CharSequence[] carrierLocales = mContext.
                getResources().getTextArray(R.array.carrier_properties);
for(int i = 0;i < carrierLocales.length;i+=3)
        {
            String c = carrierLocales[i].toString();
            if(carrier.equals(c))            
            {
                String l = carrierLocales[i+1].toString();
                String language = l.substring(0, 2);
                String country = "";
                if(l.length() >=5)                
                {
                    country = l.substring(3, 5);
                } //End block
                setSystemLocale(language, country, false);
                if(!country.isEmpty())                
                {
                    try 
                    {
                        Settings.Secure.getInt(mContext.getContentResolver(),
                                Settings.Secure.WIFI_COUNTRY_CODE);
                    } //End block
                    catch (Settings.SettingNotFoundException e)
                    {
                        WifiManager wM = (WifiManager)
                                mContext.getSystemService(Context.WIFI_SERVICE);
                        wM.setCountryCode(country, false);
                    } //End block
                } //End block
                return;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.675 -0400", hash_original_method = "B1CAAC16126A906DDE46004E33C276B7", hash_generated_method = "F3637189447E245E9768A9FE60EA3106")
    public void setSystemLocale(String language, String country, boolean fromMcc) {
        addTaint(fromMcc);
        addTaint(country.getTaint());
        addTaint(language.getTaint());
        String l = SystemProperties.get("persist.sys.language");
        String c = SystemProperties.get("persist.sys.country");
        if(null == language)        
        {
            return;
        } //End block
        language = language.toLowerCase();
        if(null == country)        
        {
            country = "";
        } //End block
        country = country.toUpperCase();
        if((null == l || 0 == l.length()) && (null == c || 0 == c.length()))        
        {
            try 
            {
                String[] locales = mContext.getAssets().getLocales();
                final int N = locales.length;
                String bestMatch = null;
for(int i = 0;i < N;i++)
                {
                    if(locales[i]!=null && locales[i].length() >= 5 &&
                            locales[i].substring(0,2).equals(language))                    
                    {
                        if(locales[i].substring(3,5).equals(country))                        
                        {
                            bestMatch = locales[i];
                            break;
                        } //End block
                        else
                        if(null == bestMatch)                        
                        {
                            bestMatch = locales[i];
                        } //End block
                    } //End block
                } //End block
                if(null != bestMatch)                
                {
                    IActivityManager am = ActivityManagerNative.getDefault();
                    Configuration config = am.getConfiguration();
                    config.locale = new Locale(bestMatch.substring(0,2),
                                               bestMatch.substring(3,5));
                    config.userSetLocale = true;
                    am.updateConfiguration(config);
                } //End block
            } //End block
            catch (Exception e)
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public abstract Phone.State getState();

    
    public abstract IccFileHandler getIccFileHandler();

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.675 -0400", hash_original_method = "B77EA67F9749FFFAEC203B31F557B343", hash_generated_method = "865B9067A5C98A74E0F17ECCD05B177C")
    public Handler getHandler() {
Handler var72A74007B2BE62B849F475C7BDA4658B_41216296 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_41216296.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_41216296;
        // ---------- Original Method ----------
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.676 -0400", hash_original_method = "E9813275B540C23EC4ABDDE1F3F36487", hash_generated_method = "7989BF61A5D7FFB149A78022D20B60AB")
    public ServiceStateTracker getServiceStateTracker() {
ServiceStateTracker var540C13E9E156B687226421B24F2DF178_1479683013 =         null;
        var540C13E9E156B687226421B24F2DF178_1479683013.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1479683013;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.676 -0400", hash_original_method = "A2CFF60AF23DAF5B5D13432A0E634448", hash_generated_method = "BA711138D5177CC7473DB6A6BC49956A")
    public CallTracker getCallTracker() {
CallTracker var540C13E9E156B687226421B24F2DF178_501015339 =         null;
        var540C13E9E156B687226421B24F2DF178_501015339.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_501015339;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.676 -0400", hash_original_method = "E12359725DA3BA4F59BA85FD7E4F143C", hash_generated_method = "22F74BFECA08E3F80C45EC689B3B8F5F")
    @Override
    public IccCard getIccCard() {
IccCard var04E45DFEE3144BF9D1F6C3E2F71EBE34_1043438118 =         mIccCard;
        var04E45DFEE3144BF9D1F6C3E2F71EBE34_1043438118.addTaint(taint);
        return var04E45DFEE3144BF9D1F6C3E2F71EBE34_1043438118;
        // ---------- Original Method ----------
        //return mIccCard;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.676 -0400", hash_original_method = "26C3C4C321ACD0FC593701A52D49E497", hash_generated_method = "763C9436B6AA8F6F98D29AB5B8DC62B9")
    @Override
    public String getIccSerialNumber() {
String var842FFEE11450360A12571273F020FF6C_243572049 =         mIccRecords.iccid;
        var842FFEE11450360A12571273F020FF6C_243572049.addTaint(taint);
        return var842FFEE11450360A12571273F020FF6C_243572049;
        // ---------- Original Method ----------
        //return mIccRecords.iccid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.677 -0400", hash_original_method = "9078EC96DE8D2AE9C16B88E94341FB99", hash_generated_method = "5FBC009E5AB40AE43DA09D671E62D640")
    @Override
    public boolean getIccRecordsLoaded() {
        boolean var49340C34F5530E268C94E0ECD040BAFB_2134877106 = (mIccRecords.getRecordsLoaded());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_809726048 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_809726048;
        // ---------- Original Method ----------
        //return mIccRecords.getRecordsLoaded();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.677 -0400", hash_original_method = "1B6614D059F66BD820665EDAF3DE7F9F", hash_generated_method = "4FE77CC84837C673028F9F517BA19026")
    @Override
    public boolean getMessageWaitingIndicator() {
        boolean var2A19F687A4E2BA049BAD07EB0D15E08A_1460237091 = (mIccRecords.getVoiceMessageWaiting());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1591378350 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1591378350;
        // ---------- Original Method ----------
        //return mIccRecords.getVoiceMessageWaiting();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.679 -0400", hash_original_method = "EAA51813A27C6D01EBD0F8DD0837A86A", hash_generated_method = "7BA6641A016DECCD4E1A7813D3258808")
    @Override
    public boolean getCallForwardingIndicator() {
        boolean varF9D403BF7E60519D040AD7B030A4BD49_562949205 = (mIccRecords.getVoiceCallForwardingFlag());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1391301762 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1391301762;
        // ---------- Original Method ----------
        //return mIccRecords.getVoiceCallForwardingFlag();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.679 -0400", hash_original_method = "93DCD756C677180103F6D6F7873E6AE7", hash_generated_method = "2FF0A3CAD0080A602D50EE99BA79E7E9")
    public void queryCdmaRoamingPreference(Message response) {
        addTaint(response.getTaint());
        mCM.queryCdmaRoamingPreference(response);
        // ---------- Original Method ----------
        //mCM.queryCdmaRoamingPreference(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.680 -0400", hash_original_method = "D1AE94805C952F3809EAEE65E7FED134", hash_generated_method = "8FABACBC9EF520B974B7D71FFD3E9245")
    public void setCdmaRoamingPreference(int cdmaRoamingType, Message response) {
        addTaint(response.getTaint());
        addTaint(cdmaRoamingType);
        mCM.setCdmaRoamingPreference(cdmaRoamingType, response);
        // ---------- Original Method ----------
        //mCM.setCdmaRoamingPreference(cdmaRoamingType, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.680 -0400", hash_original_method = "532B78C8CD74E377483500017A27260E", hash_generated_method = "6577A150AF92DE31CAA52B863C403DA4")
    public void setCdmaSubscription(int cdmaSubscriptionType, Message response) {
        addTaint(response.getTaint());
        addTaint(cdmaSubscriptionType);
        mCM.setCdmaSubscriptionSource(cdmaSubscriptionType, response);
        // ---------- Original Method ----------
        //mCM.setCdmaSubscriptionSource(cdmaSubscriptionType, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.680 -0400", hash_original_method = "EA18BAD07370F2F495FB68EDF5CD8C8E", hash_generated_method = "A67C9EA30B113B38B7983150570F4C28")
    public void setPreferredNetworkType(int networkType, Message response) {
        addTaint(response.getTaint());
        addTaint(networkType);
        mCM.setPreferredNetworkType(networkType, response);
        // ---------- Original Method ----------
        //mCM.setPreferredNetworkType(networkType, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.680 -0400", hash_original_method = "379A4BC143905A2FA132EF757E52297F", hash_generated_method = "84A2F2AD8376131817334730F2760798")
    public void getPreferredNetworkType(Message response) {
        addTaint(response.getTaint());
        mCM.getPreferredNetworkType(response);
        // ---------- Original Method ----------
        //mCM.getPreferredNetworkType(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.681 -0400", hash_original_method = "1E1783F8116903E275F3EB4645F9C2EE", hash_generated_method = "411220A3AD664DDBF61475B7717DBA73")
    public void getSmscAddress(Message result) {
        addTaint(result.getTaint());
        mCM.getSmscAddress(result);
        // ---------- Original Method ----------
        //mCM.getSmscAddress(result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.681 -0400", hash_original_method = "4D63BDB7F30F381F077564B4D4894249", hash_generated_method = "B8462D5ABFC5177E145476A1CFC07262")
    public void setSmscAddress(String address, Message result) {
        addTaint(result.getTaint());
        addTaint(address.getTaint());
        mCM.setSmscAddress(address, result);
        // ---------- Original Method ----------
        //mCM.setSmscAddress(address, result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.681 -0400", hash_original_method = "63C869993C8085EA489C8231FED76E37", hash_generated_method = "AD86B8F9C8147F716A231D04F4D4319A")
    public void setTTYMode(int ttyMode, Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(ttyMode);
        mCM.setTTYMode(ttyMode, onComplete);
        // ---------- Original Method ----------
        //mCM.setTTYMode(ttyMode, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.681 -0400", hash_original_method = "2CF2C1C8F165F7A0D032A77B44E87766", hash_generated_method = "7B0A78EC9B3305C1516236D63078F11E")
    public void queryTTYMode(Message onComplete) {
        addTaint(onComplete.getTaint());
        mCM.queryTTYMode(onComplete);
        // ---------- Original Method ----------
        //mCM.queryTTYMode(onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.681 -0400", hash_original_method = "5E8CBEA5609C7848D9FB026D7FBB8ABD", hash_generated_method = "C60D0A2F27E7CC16EB9055413D106E2A")
    public void enableEnhancedVoicePrivacy(boolean enable, Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(enable);
        logUnexpectedCdmaMethodCall("enableEnhancedVoicePrivacy");
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("enableEnhancedVoicePrivacy");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.681 -0400", hash_original_method = "33AF0BA0508B34DC6251B1288B05B827", hash_generated_method = "D395AC77CF141A24AF231B754E0F8BF5")
    public void getEnhancedVoicePrivacy(Message onComplete) {
        addTaint(onComplete.getTaint());
        logUnexpectedCdmaMethodCall("getEnhancedVoicePrivacy");
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("getEnhancedVoicePrivacy");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.681 -0400", hash_original_method = "89D25AC6FB0D0D55BD65CF567206F30D", hash_generated_method = "15D17B863A89A069AC6C550F058CC156")
    public void setBandMode(int bandMode, Message response) {
        addTaint(response.getTaint());
        addTaint(bandMode);
        mCM.setBandMode(bandMode, response);
        // ---------- Original Method ----------
        //mCM.setBandMode(bandMode, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.682 -0400", hash_original_method = "83F6C692B5B60F1074FC39097E38CED5", hash_generated_method = "F75000445A5B8273D25A8DB9E3662C36")
    public void queryAvailableBandMode(Message response) {
        addTaint(response.getTaint());
        mCM.queryAvailableBandMode(response);
        // ---------- Original Method ----------
        //mCM.queryAvailableBandMode(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.682 -0400", hash_original_method = "13F8DD451E5397866EEA2E2D05CD7BB9", hash_generated_method = "E3CD5EAC2F0C636C1FC25633319D7EB5")
    public void invokeOemRilRequestRaw(byte[] data, Message response) {
        addTaint(response.getTaint());
        addTaint(data[0]);
        mCM.invokeOemRilRequestRaw(data, response);
        // ---------- Original Method ----------
        //mCM.invokeOemRilRequestRaw(data, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.682 -0400", hash_original_method = "FF2E1FA4CC9C1321FDC1F9CFA6F4625A", hash_generated_method = "F1E3148E85705A8ECB979E4B0BEE45CE")
    public void invokeOemRilRequestStrings(String[] strings, Message response) {
        addTaint(response.getTaint());
        addTaint(strings[0].getTaint());
        mCM.invokeOemRilRequestStrings(strings, response);
        // ---------- Original Method ----------
        //mCM.invokeOemRilRequestStrings(strings, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.682 -0400", hash_original_method = "FF7C38607D5C4F28572FCAAA94A2F244", hash_generated_method = "3F05111CC8235C6253E2D7363CB24A45")
    public void notifyDataActivity() {
        mNotifier.notifyDataActivity(this);
        // ---------- Original Method ----------
        //mNotifier.notifyDataActivity(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.682 -0400", hash_original_method = "CD8E1DAAFB356590CE946A9A3EFA7BF6", hash_generated_method = "80B27DE037EDB5FD78BF9C2A423FCCD1")
    public void notifyMessageWaitingIndicator() {
        if(!mIsVoiceCapable)        
        return;
        mNotifier.notifyMessageWaitingChanged(this);
        // ---------- Original Method ----------
        //if (!mIsVoiceCapable)
            //return;
        //mNotifier.notifyMessageWaitingChanged(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.683 -0400", hash_original_method = "B949430324D30DD706A09A11AE93C217", hash_generated_method = "958BE5A706266F70568B0FF2E07ED63B")
    public void notifyDataConnection(String reason, String apnType,
            Phone.DataState state) {
        addTaint(state.getTaint());
        addTaint(apnType.getTaint());
        addTaint(reason.getTaint());
        mNotifier.notifyDataConnection(this, reason, apnType, state);
        // ---------- Original Method ----------
        //mNotifier.notifyDataConnection(this, reason, apnType, state);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.683 -0400", hash_original_method = "FACBD8427065A5D42D63A885B3F07753", hash_generated_method = "1E85A7A53AFDDF4B11E790828E5A0B6C")
    public void notifyDataConnection(String reason, String apnType) {
        addTaint(apnType.getTaint());
        addTaint(reason.getTaint());
        mNotifier.notifyDataConnection(this, reason, apnType, getDataConnectionState(apnType));
        // ---------- Original Method ----------
        //mNotifier.notifyDataConnection(this, reason, apnType, getDataConnectionState(apnType));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.683 -0400", hash_original_method = "0547766DA98E44E8B89F2461696DDA6A", hash_generated_method = "DF9F282871118890F5354CCF7CFE14C1")
    public void notifyDataConnection(String reason) {
        addTaint(reason.getTaint());
        String types[] = getActiveApnTypes();
for(String apnType : types)
        {
            mNotifier.notifyDataConnection(this, reason, apnType, getDataConnectionState(apnType));
        } //End block
        // ---------- Original Method ----------
        //String types[] = getActiveApnTypes();
        //for (String apnType : types) {
            //mNotifier.notifyDataConnection(this, reason, apnType, getDataConnectionState(apnType));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.684 -0400", hash_original_method = "68DB92920F159FB7A2995379683DC8DE", hash_generated_method = "163E3F4A285309556FF2C38BFD286DDE")
    public void notifyOtaspChanged(int otaspMode) {
        addTaint(otaspMode);
        mNotifier.notifyOtaspChanged(this, otaspMode);
        // ---------- Original Method ----------
        //mNotifier.notifyOtaspChanged(this, otaspMode);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.684 -0400", hash_original_method = "EBE7791CDB6F228DD3645706A64042D5", hash_generated_method = "69CA6D913D7B90BEB05BBAD6A2096E07")
    public boolean isInEmergencyCall() {
        boolean var68934A3E9455FA72420237EB05902327_982992635 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_115651302 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_115651302;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.684 -0400", hash_original_method = "2D052AB13CFF7511C3F5373523EDFF5B", hash_generated_method = "FAA8371E57142960A46F9CA4D5FBFC5F")
    public boolean isInEcm() {
        boolean var68934A3E9455FA72420237EB05902327_103491776 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1826502276 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1826502276;
        // ---------- Original Method ----------
        //return false;
    }

    
    public abstract String getPhoneName();

    
    public abstract int getPhoneType();

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.684 -0400", hash_original_method = "91CE395C2B1A59CCA21CB689DCBFE10B", hash_generated_method = "F5EABE3DEEFFD50A919DE7641CA6E3AF")
    public int getVoiceMessageCount() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1731665683 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_830568355 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_830568355;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.684 -0400", hash_original_method = "A48905F669D5C197EA0EF66127013B06", hash_generated_method = "18849ACA14962B3645975D408D4965B5")
    public int getCdmaEriIconIndex() {
        logUnexpectedCdmaMethodCall("getCdmaEriIconIndex");
        int var6BB61E3B7BCE0931DA574D19D1D82C88_471144853 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1696432741 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1696432741;
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("getCdmaEriIconIndex");
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.684 -0400", hash_original_method = "F2685CF828A9991D177F425CEE905936", hash_generated_method = "E7F1C73161D73D3444BD6316485D7F7B")
    public int getCdmaEriIconMode() {
        logUnexpectedCdmaMethodCall("getCdmaEriIconMode");
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1332422751 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_364161610 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_364161610;
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("getCdmaEriIconMode");
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.684 -0400", hash_original_method = "B9212A70F84EE88792E9F77579D252EB", hash_generated_method = "96127D8158E9F9787283345850CCFAD5")
    public String getCdmaEriText() {
        logUnexpectedCdmaMethodCall("getCdmaEriText");
String varACDBCB8F58993FAC6541A3891E1D0C6B_1832169817 =         "GSM nw, no ERI";
        varACDBCB8F58993FAC6541A3891E1D0C6B_1832169817.addTaint(taint);
        return varACDBCB8F58993FAC6541A3891E1D0C6B_1832169817;
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("getCdmaEriText");
        //return "GSM nw, no ERI";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.684 -0400", hash_original_method = "31C17E46EDF55F22A4F7752D6C0E6244", hash_generated_method = "9C7E5026DA3D8236AE1E21507E7927F4")
    public String getCdmaMin() {
        logUnexpectedCdmaMethodCall("getCdmaMin");
String var540C13E9E156B687226421B24F2DF178_1038210860 =         null;
        var540C13E9E156B687226421B24F2DF178_1038210860.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1038210860;
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("getCdmaMin");
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.684 -0400", hash_original_method = "5ED51837BFBC47DED520188DB45BE3ED", hash_generated_method = "B2C5E41C8E0B96C049DC0D00E5AE53B1")
    public boolean isMinInfoReady() {
        logUnexpectedCdmaMethodCall("isMinInfoReady");
        boolean var68934A3E9455FA72420237EB05902327_1532779623 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_866160851 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_866160851;
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("isMinInfoReady");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.685 -0400", hash_original_method = "A959C6A3260B45047463EF5F7B599FA2", hash_generated_method = "F3B6F5703115749CEDDFD02962233CB4")
    public String getCdmaPrlVersion() {
        logUnexpectedCdmaMethodCall("getCdmaPrlVersion");
String var540C13E9E156B687226421B24F2DF178_1836974304 =         null;
        var540C13E9E156B687226421B24F2DF178_1836974304.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1836974304;
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("getCdmaPrlVersion");
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.685 -0400", hash_original_method = "2891F3B114A0E9671C3D7B6F8CA784DA", hash_generated_method = "04E6909B4A78CA41DAD9089F41E0C7DD")
    public void sendBurstDtmf(String dtmfString, int on, int off, Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(off);
        addTaint(on);
        addTaint(dtmfString.getTaint());
        logUnexpectedCdmaMethodCall("sendBurstDtmf");
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("sendBurstDtmf");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.686 -0400", hash_original_method = "1233D801AF5BD64366571B89C874921A", hash_generated_method = "C419AD7983ACE1A8CECC53CA8062906D")
    public void exitEmergencyCallbackMode() {
        logUnexpectedCdmaMethodCall("exitEmergencyCallbackMode");
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("exitEmergencyCallbackMode");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.687 -0400", hash_original_method = "A559D3AF3D26E6025D0072F9A69D12D5", hash_generated_method = "4111478A444A8BB5E2A3F267420A9D50")
    public void registerForCdmaOtaStatusChange(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        logUnexpectedCdmaMethodCall("registerForCdmaOtaStatusChange");
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("registerForCdmaOtaStatusChange");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.687 -0400", hash_original_method = "ECF4F8F98FA1956C40263AEBA8AA4F0E", hash_generated_method = "B90FAB2444E713EA491FB946409F73F2")
    public void unregisterForCdmaOtaStatusChange(Handler h) {
        addTaint(h.getTaint());
        logUnexpectedCdmaMethodCall("unregisterForCdmaOtaStatusChange");
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("unregisterForCdmaOtaStatusChange");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.687 -0400", hash_original_method = "D0126A4408C76F0C8443237E283C8B7B", hash_generated_method = "B65F5D7692AF373D41313EA668858F59")
    public void registerForSubscriptionInfoReady(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        logUnexpectedCdmaMethodCall("registerForSubscriptionInfoReady");
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("registerForSubscriptionInfoReady");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.688 -0400", hash_original_method = "87FC8275C239D995B7197317524E9D40", hash_generated_method = "C39CC711D7D7CEBBAB6883D41B46E050")
    public void unregisterForSubscriptionInfoReady(Handler h) {
        addTaint(h.getTaint());
        logUnexpectedCdmaMethodCall("unregisterForSubscriptionInfoReady");
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("unregisterForSubscriptionInfoReady");
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.688 -0400", hash_original_method = "08A6E4B71FA09531A80AE7640F0ED8FC", hash_generated_method = "A722F6C7A11E9D786CA1822A3754E87F")
    public boolean needsOtaServiceProvisioning() {
        boolean var68934A3E9455FA72420237EB05902327_1724845335 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_483781191 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_483781191;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.688 -0400", hash_original_method = "A73C77982F42451CD95F88A8474FB403", hash_generated_method = "A0ED1CBB83219799CF9DF773AB13CA80")
    public boolean isOtaSpNumber(String dialStr) {
        addTaint(dialStr.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_15663002 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_257368860 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_257368860;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.688 -0400", hash_original_method = "663CEDCAC596E020E0D8D3DEB84218C7", hash_generated_method = "25767D87C99BD6F890B8CFEDD3DBD504")
    public void registerForCallWaiting(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        logUnexpectedCdmaMethodCall("registerForCallWaiting");
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("registerForCallWaiting");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.688 -0400", hash_original_method = "6A9877CFE858A21BAD2DF20E221EE6F8", hash_generated_method = "87648052B23B7467CDE0D6005CFDA91B")
    public void unregisterForCallWaiting(Handler h) {
        addTaint(h.getTaint());
        logUnexpectedCdmaMethodCall("unregisterForCallWaiting");
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("unregisterForCallWaiting");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.688 -0400", hash_original_method = "DCA99E7B790465429FB14A326BDABF1A", hash_generated_method = "97B07A5B79CDC16F589548993BC405BA")
    public void registerForEcmTimerReset(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        logUnexpectedCdmaMethodCall("registerForEcmTimerReset");
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("registerForEcmTimerReset");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.688 -0400", hash_original_method = "7FC556E6839E1551B3AA1598A94EB641", hash_generated_method = "25E2FB1AD9612B2D665A773931B37EDD")
    public void unregisterForEcmTimerReset(Handler h) {
        addTaint(h.getTaint());
        logUnexpectedCdmaMethodCall("unregisterForEcmTimerReset");
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("unregisterForEcmTimerReset");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.688 -0400", hash_original_method = "9EA1B9B633F04B4B40F6D988C6C6EAE0", hash_generated_method = "1349B863B889C750F7CFB12AB9F60BE4")
    public void registerForSignalInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mCM.registerForSignalInfo(h, what, obj);
        // ---------- Original Method ----------
        //mCM.registerForSignalInfo(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.688 -0400", hash_original_method = "490F0951818D5A292B4D850AA9A9557C", hash_generated_method = "C5AA02F42BC0291693A539F216113485")
    public void unregisterForSignalInfo(Handler h) {
        addTaint(h.getTaint());
        mCM.unregisterForSignalInfo(h);
        // ---------- Original Method ----------
        //mCM.unregisterForSignalInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.689 -0400", hash_original_method = "9A93FB64A77E8F3AD75482A91959C175", hash_generated_method = "E837C60E7B4BC9AD74DFD30F7D42F51E")
    public void registerForDisplayInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mCM.registerForDisplayInfo(h, what, obj);
        // ---------- Original Method ----------
        //mCM.registerForDisplayInfo(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.689 -0400", hash_original_method = "1D7139AB5835E964A2112E0A96A55533", hash_generated_method = "6ED523A93CF6437D0BB1AF3A9EBD343F")
    public void unregisterForDisplayInfo(Handler h) {
        addTaint(h.getTaint());
        mCM.unregisterForDisplayInfo(h);
        // ---------- Original Method ----------
        //mCM.unregisterForDisplayInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.689 -0400", hash_original_method = "735A13B0D1CB0B503F36D15D851EF79F", hash_generated_method = "04DE76F8089AB8388B7E381D0B50A86C")
    public void registerForNumberInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mCM.registerForNumberInfo(h, what, obj);
        // ---------- Original Method ----------
        //mCM.registerForNumberInfo(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.689 -0400", hash_original_method = "6DBE3FA0B44D5F0F3EA0C4D2C4C9DEA2", hash_generated_method = "E1D50CF4045F6991216D59BED2DFD3E0")
    public void unregisterForNumberInfo(Handler h) {
        addTaint(h.getTaint());
        mCM.unregisterForNumberInfo(h);
        // ---------- Original Method ----------
        //mCM.unregisterForNumberInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.689 -0400", hash_original_method = "D3A5B2415D3398E5BAA61633747135F3", hash_generated_method = "F2A3127B3FBE85A69C2FDD65B207A6B4")
    public void registerForRedirectedNumberInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mCM.registerForRedirectedNumberInfo(h, what, obj);
        // ---------- Original Method ----------
        //mCM.registerForRedirectedNumberInfo(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.693 -0400", hash_original_method = "FEE62A9F06FB60B95297A2B9A46AFB0E", hash_generated_method = "205BF9F79FF7F9B3DC07B5F46F9CA7D8")
    public void unregisterForRedirectedNumberInfo(Handler h) {
        addTaint(h.getTaint());
        mCM.unregisterForRedirectedNumberInfo(h);
        // ---------- Original Method ----------
        //mCM.unregisterForRedirectedNumberInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.693 -0400", hash_original_method = "73B61604D8C534BA3038C74FC6F1FC84", hash_generated_method = "E6E39C83CE8F707EE8325192F551D26E")
    public void registerForLineControlInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mCM.registerForLineControlInfo( h, what, obj);
        // ---------- Original Method ----------
        //mCM.registerForLineControlInfo( h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.693 -0400", hash_original_method = "5D4E66E94B3A48B485E9B9F7921C3B01", hash_generated_method = "CD45C62C4A4EF586524E1C293E895E25")
    public void unregisterForLineControlInfo(Handler h) {
        addTaint(h.getTaint());
        mCM.unregisterForLineControlInfo(h);
        // ---------- Original Method ----------
        //mCM.unregisterForLineControlInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.693 -0400", hash_original_method = "590438B1B11ADBD08E7A44131058572B", hash_generated_method = "3244AA1D3D18C45D1FB6DF7E065447B9")
    public void registerFoT53ClirlInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mCM.registerFoT53ClirlInfo(h, what, obj);
        // ---------- Original Method ----------
        //mCM.registerFoT53ClirlInfo(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.694 -0400", hash_original_method = "034ED9AF183776C78D98034D25F265A2", hash_generated_method = "5C4A0EBCC16195F3CFCC77D6BC7354F2")
    public void unregisterForT53ClirInfo(Handler h) {
        addTaint(h.getTaint());
        mCM.unregisterForT53ClirInfo(h);
        // ---------- Original Method ----------
        //mCM.unregisterForT53ClirInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.694 -0400", hash_original_method = "66D030845270A8F126DBBDF302E2A141", hash_generated_method = "1D1478B7129FBE5B57A7225D9347E092")
    public void registerForT53AudioControlInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mCM.registerForT53AudioControlInfo( h, what, obj);
        // ---------- Original Method ----------
        //mCM.registerForT53AudioControlInfo( h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.694 -0400", hash_original_method = "C4F9238B8E9649490800210FA099DE0F", hash_generated_method = "00CDED32D32CF4AF9D3AF62D2B499EE0")
    public void unregisterForT53AudioControlInfo(Handler h) {
        addTaint(h.getTaint());
        mCM.unregisterForT53AudioControlInfo(h);
        // ---------- Original Method ----------
        //mCM.unregisterForT53AudioControlInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.694 -0400", hash_original_method = "815749C135EEAFF1973468BF7BE05E75", hash_generated_method = "9DB4B1125E9E9C98A4213C099FFDD239")
    public void setOnEcbModeExitResponse(Handler h, int what, Object obj) {
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        logUnexpectedCdmaMethodCall("setOnEcbModeExitResponse");
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("setOnEcbModeExitResponse");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.694 -0400", hash_original_method = "ECE14734C7F2F497945A22923EF26B0A", hash_generated_method = "D564E90862ABD059E52F527614A8F881")
    public void unsetOnEcbModeExitResponse(Handler h) {
        addTaint(h.getTaint());
        logUnexpectedCdmaMethodCall("unsetOnEcbModeExitResponse");
        // ---------- Original Method ----------
        //logUnexpectedCdmaMethodCall("unsetOnEcbModeExitResponse");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.695 -0400", hash_original_method = "04CB7EBB1F2C2F5A1F94C891E246EC01", hash_generated_method = "54A0461662D5A4073E28599902F8E33A")
    public String[] getActiveApnTypes() {
String[] varD1EFDEEF37354EC99436AF2445CEFEEF_21124253 =         mDataConnectionTracker.getActiveApnTypes();
        varD1EFDEEF37354EC99436AF2445CEFEEF_21124253.addTaint(taint);
        return varD1EFDEEF37354EC99436AF2445CEFEEF_21124253;
        // ---------- Original Method ----------
        //return mDataConnectionTracker.getActiveApnTypes();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.695 -0400", hash_original_method = "D30362481D576467EFD2166079686420", hash_generated_method = "EDA09CE3827C784EE8372A532820EFE3")
    public String getActiveApnHost(String apnType) {
        addTaint(apnType.getTaint());
String var189F325138BBB80EC0A5DE7F92E4CB69_632046509 =         mDataConnectionTracker.getActiveApnString(apnType);
        var189F325138BBB80EC0A5DE7F92E4CB69_632046509.addTaint(taint);
        return var189F325138BBB80EC0A5DE7F92E4CB69_632046509;
        // ---------- Original Method ----------
        //return mDataConnectionTracker.getActiveApnString(apnType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.695 -0400", hash_original_method = "C11066F2623E480AC3C630C6CBD36058", hash_generated_method = "48E8AA676648F910D0DEE9E658EC674B")
    public LinkProperties getLinkProperties(String apnType) {
        addTaint(apnType.getTaint());
LinkProperties var26E807B0C835AC9CCCCEF497D9B2D482_1254569970 =         mDataConnectionTracker.getLinkProperties(apnType);
        var26E807B0C835AC9CCCCEF497D9B2D482_1254569970.addTaint(taint);
        return var26E807B0C835AC9CCCCEF497D9B2D482_1254569970;
        // ---------- Original Method ----------
        //return mDataConnectionTracker.getLinkProperties(apnType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.695 -0400", hash_original_method = "035A2689990E07C724064B64E344B05A", hash_generated_method = "E6F246BF03FE8890DBEB0382FC0BCD98")
    public LinkCapabilities getLinkCapabilities(String apnType) {
        addTaint(apnType.getTaint());
LinkCapabilities var3506452F2044E11DB1F2564F4E40FE73_1836748042 =         mDataConnectionTracker.getLinkCapabilities(apnType);
        var3506452F2044E11DB1F2564F4E40FE73_1836748042.addTaint(taint);
        return var3506452F2044E11DB1F2564F4E40FE73_1836748042;
        // ---------- Original Method ----------
        //return mDataConnectionTracker.getLinkCapabilities(apnType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.695 -0400", hash_original_method = "8FC26686EA9F953DFAC2E032B4ED9578", hash_generated_method = "66C43043F8471DC8EE1512ACE0E60EF7")
    public int enableApnType(String type) {
        addTaint(type.getTaint());
        int varFFA06648F81DB8FECDAB99237C822084_595739013 = (mDataConnectionTracker.enableApnType(type));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1162711897 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1162711897;
        // ---------- Original Method ----------
        //return mDataConnectionTracker.enableApnType(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.695 -0400", hash_original_method = "EEF84E670D69A41297DD287EFE00D426", hash_generated_method = "95FE553D79DAE4CC6C12900808D15899")
    public int disableApnType(String type) {
        addTaint(type.getTaint());
        int varDDCBD4DC1272429C0DBF700C93F4C7D7_95003467 = (mDataConnectionTracker.disableApnType(type));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_44815718 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_44815718;
        // ---------- Original Method ----------
        //return mDataConnectionTracker.disableApnType(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.695 -0400", hash_original_method = "0E7DDF56B2AD7D089B639A5A4C8707B8", hash_generated_method = "72755A2137E203D6E1F4115AD06FD18A")
    public boolean isDataConnectivityPossible() {
        boolean varFF0482B5924E4138675DC6F52838FEBC_797228386 = (isDataConnectivityPossible(Phone.APN_TYPE_DEFAULT));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_295354008 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_295354008;
        // ---------- Original Method ----------
        //return isDataConnectivityPossible(Phone.APN_TYPE_DEFAULT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.700 -0400", hash_original_method = "D1C4C7300A786DB2DE96913E45D224C3", hash_generated_method = "CA58542C01487B5A3C5AB68B7E347547")
    public boolean isDataConnectivityPossible(String apnType) {
        addTaint(apnType.getTaint());
        boolean var74DD87F65CFC336A2D13755E4526F1F7_143607691 = (((mDataConnectionTracker != null) &&
                (mDataConnectionTracker.isDataPossible(apnType))));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1691241596 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1691241596;
        // ---------- Original Method ----------
        //return ((mDataConnectionTracker != null) &&
                //(mDataConnectionTracker.isDataPossible(apnType)));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.700 -0400", hash_original_method = "78C210B796AC9661779AB486B8F70A37", hash_generated_method = "2A90E6F4C1E4C1B5E1CA5670F7C6DD65")
    protected void notifyNewRingingConnectionP(Connection cn) {
        addTaint(cn.getTaint());
        if(!mIsVoiceCapable)        
        return;
        AsyncResult ar = new AsyncResult(null, cn, null);
        mNewRingingConnectionRegistrants.notifyRegistrants(ar);
        // ---------- Original Method ----------
        //if (!mIsVoiceCapable)
            //return;
        //AsyncResult ar = new AsyncResult(null, cn, null);
        //mNewRingingConnectionRegistrants.notifyRegistrants(ar);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.700 -0400", hash_original_method = "E77A37BE6BEB7ED310F1875BE08F1BE3", hash_generated_method = "C15D47BAE2311E06A50C914372655028")
    private void notifyIncomingRing() {
        if(!mIsVoiceCapable)        
        return;
        AsyncResult ar = new AsyncResult(null, this, null);
        mIncomingRingRegistrants.notifyRegistrants(ar);
        // ---------- Original Method ----------
        //if (!mIsVoiceCapable)
            //return;
        //AsyncResult ar = new AsyncResult(null, this, null);
        //mIncomingRingRegistrants.notifyRegistrants(ar);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.701 -0400", hash_original_method = "E1A10981C368CA09B703B9716F98BBE5", hash_generated_method = "D760EF37277DEE615D8C467524ED1ECD")
    private void sendIncomingCallRingNotification(int token) {
        addTaint(token);
        if(mIsVoiceCapable && !mDoesRilSendMultipleCallRing &&
                (token == mCallRingContinueToken))        
        {
            Log.d(LOG_TAG, "Sending notifyIncomingRing");
            notifyIncomingRing();
            sendMessageDelayed(
                    obtainMessage(EVENT_CALL_RING_CONTINUE, token, 0), mCallRingDelay);
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.701 -0400", hash_original_method = "3242BA07687ED62C3518200E2F9FB53F", hash_generated_method = "16EB759A560BDC044848570A55A86E42")
    public boolean isCspPlmnEnabled() {
        logUnexpectedGsmMethodCall("isCspPlmnEnabled");
        boolean var68934A3E9455FA72420237EB05902327_681378182 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1686750959 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1686750959;
        // ---------- Original Method ----------
        //logUnexpectedGsmMethodCall("isCspPlmnEnabled");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.701 -0400", hash_original_method = "B1975F1CE49D1493C79D22CB0A320E47", hash_generated_method = "791E089B3411209E5689B3F10CC520E3")
    public IsimRecords getIsimRecords() {
IsimRecords var540C13E9E156B687226421B24F2DF178_1496458991 =         null;
        var540C13E9E156B687226421B24F2DF178_1496458991.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1496458991;
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "getIsimRecords() is only supported on LTE devices");
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.701 -0400", hash_original_method = "0D543BE7AD53581775829ADD7A6346BC", hash_generated_method = "E6556443D1DB237CCBEA0837437F31AC")
    public void requestIsimAuthentication(String nonce, Message result) {
        addTaint(result.getTaint());
        addTaint(nonce.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "requestIsimAuthentication() is only supported on LTE devices");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.702 -0400", hash_original_method = "60A69213567A9812671ADC8B66C5585F", hash_generated_method = "F0B60F5E4CEECCD449260A32BDAFAC0B")
    public String getMsisdn() {
        logUnexpectedGsmMethodCall("getMsisdn");
String var540C13E9E156B687226421B24F2DF178_865355408 =         null;
        var540C13E9E156B687226421B24F2DF178_865355408.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_865355408;
        // ---------- Original Method ----------
        //logUnexpectedGsmMethodCall("getMsisdn");
        //return null;
    }

    
    private static void logUnexpectedCdmaMethodCall(String name) {
        Log.e(LOG_TAG, "Error! " + name + "() in PhoneBase should not be " +
                "called, CDMAPhone inactive.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.703 -0400", hash_original_method = "3916B54807B55A36DB6B185AF3F43F9B", hash_generated_method = "14166C6981EFE34BC924F9A354C26C38")
    public DataState getDataConnectionState() {
DataState var8C0F4AEBC8E666C24F4A67F07CB1F535_1547025907 =         getDataConnectionState(APN_TYPE_DEFAULT);
        var8C0F4AEBC8E666C24F4A67F07CB1F535_1547025907.addTaint(taint);
        return var8C0F4AEBC8E666C24F4A67F07CB1F535_1547025907;
        // ---------- Original Method ----------
        //return getDataConnectionState(APN_TYPE_DEFAULT);
    }

    
    private static void logUnexpectedGsmMethodCall(String name) {
        Log.e(LOG_TAG, "Error! " + name + "() in PhoneBase should not be " +
                "called, GSMPhone inactive.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.703 -0400", hash_original_method = "3E0F86392A957104B8FBDE9CC6F59C4C", hash_generated_method = "58BFBC231130793F6A272E782A5696DC")
    public void notifyCallForwardingIndicator() {
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "Error! This function should never be executed, inactive CDMAPhone.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.703 -0400", hash_original_method = "920CBD0242A41CC292CB0CFE1F874523", hash_generated_method = "096F8ED25DEA5C23FF75CA6D7A8F2F77")
    public void notifyDataConnectionFailed(String reason, String apnType) {
        addTaint(apnType.getTaint());
        addTaint(reason.getTaint());
        mNotifier.notifyDataConnectionFailed(this, reason, apnType);
        // ---------- Original Method ----------
        //mNotifier.notifyDataConnectionFailed(this, reason, apnType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.703 -0400", hash_original_method = "1FC25F07E17A01F63F573F1677883F29", hash_generated_method = "3E70BA9B18ECE84D4D002BF639CCC474")
    @Override
    public int getLteOnCdmaMode() {
        int varBA9EAAC58639BE785572256CEA3E0A3F_63557704 = (mCM.getLteOnCdmaMode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_162710684 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_162710684;
        // ---------- Original Method ----------
        //return mCM.getLteOnCdmaMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.703 -0400", hash_original_method = "B0657B144D34E1997F6D522B080186C1", hash_generated_method = "715EF5717695131401D21A9E8CB34662")
    @Override
    public void setVoiceMessageWaiting(int line, int countWaiting) {
        addTaint(countWaiting);
        addTaint(line);
        mIccRecords.setVoiceMessageWaiting(line, countWaiting);
        // ---------- Original Method ----------
        //mIccRecords.setVoiceMessageWaiting(line, countWaiting);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.703 -0400", hash_original_method = "099D11C8CFE57EFDDC5741548A2AEB3D", hash_generated_method = "F9625882A9864FD0C481D0035861B7F4")
    @Override
    public UsimServiceTable getUsimServiceTable() {
UsimServiceTable varFE395D5B572DC1E9B6EB7FD984E9E880_319189383 =         mIccRecords.getUsimServiceTable();
        varFE395D5B572DC1E9B6EB7FD984E9E880_319189383.addTaint(taint);
        return varFE395D5B572DC1E9B6EB7FD984E9E880_319189383;
        // ---------- Original Method ----------
        //return mIccRecords.getUsimServiceTable();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.703 -0400", hash_original_field = "8C61C83FB4E7AA2A98C50A63D7FB9679", hash_generated_field = "4A57918A348D50A14B9C302A7B5E80AE")

    private static final String LOG_TAG = "PHONE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.703 -0400", hash_original_field = "7F1E46EB212D9379AF8B593E529EF4C2", hash_generated_field = "F62F4824E5D90C8C9780C2AB171AAEE3")

    private static final boolean LOCAL_DEBUG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.705 -0400", hash_original_field = "9FB4B8A90783DA9613AFFD310041951E", hash_generated_field = "30999E1536B998C0CCCADFCA2E186A73")

    public static final String NETWORK_SELECTION_KEY = "network_selection_key";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.705 -0400", hash_original_field = "07A14EDBC1369EBD89FC29D70AB51065", hash_generated_field = "4D95278747E96EA0717A9759EEFCE875")

    public static final String NETWORK_SELECTION_NAME_KEY = "network_selection_name_key";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.705 -0400", hash_original_field = "AC16C5F4A1E34C3D1DE7878A05C14512", hash_generated_field = "CFD39C473C87BFA4C5B1110D352F768C")

    public static final String DATA_DISABLED_ON_BOOT_KEY = "disabled_on_boot_key";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.705 -0400", hash_original_field = "E16D8C3D4B3A1EF070AB92CC8338E476", hash_generated_field = "F58D8D37E826F12A67E2A3F288013066")

    protected static final int EVENT_RADIO_AVAILABLE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.705 -0400", hash_original_field = "3D8E210ECF87C03DC96F905193014725", hash_generated_field = "914F5932DA87031C3BD38F173AD82C6C")

    protected static final int EVENT_SSN = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.705 -0400", hash_original_field = "4AF20B068C914F2DCD50E3651B01B455", hash_generated_field = "9B6C9718F0C8C627151CE283AB5AB3C2")

    protected static final int EVENT_SIM_RECORDS_LOADED = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.705 -0400", hash_original_field = "6C846546FDB321ED9400D7DF113D907B", hash_generated_field = "CFD312476C2A4C418231A8C9824FB332")

    protected static final int EVENT_MMI_DONE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.705 -0400", hash_original_field = "FB959D562366CD62799427DD44F9E389", hash_generated_field = "411538EAFB0AB12810979C6A4B3D08EA")

    protected static final int EVENT_RADIO_ON = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.705 -0400", hash_original_field = "60B977A6A1A246E405EB6EFF72F09906", hash_generated_field = "A9FE15AC0003E179C4D212C4A530D275")

    protected static final int EVENT_GET_BASEBAND_VERSION_DONE = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.705 -0400", hash_original_field = "4B0F5621B6A951D1710A0AA717E6FE78", hash_generated_field = "3E57A8B14586139C14EA8450AD43475D")

    protected static final int EVENT_USSD = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.705 -0400", hash_original_field = "1B78BFEC3CFED2AF2161F18379139A83", hash_generated_field = "29A355AF2121A0E9E4E7253B2E0856DC")

    protected static final int EVENT_RADIO_OFF_OR_NOT_AVAILABLE = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.705 -0400", hash_original_field = "21F3F46C17A106F9A983519B923D057D", hash_generated_field = "2CBF0A719C2EB443AB09CD6CBC65F370")

    protected static final int EVENT_GET_IMEI_DONE = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.705 -0400", hash_original_field = "9882FDEAB11C65195AD70BB049481E77", hash_generated_field = "F67A856F5863C22B88E923DCB07E66DD")

    protected static final int EVENT_GET_IMEISV_DONE = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.705 -0400", hash_original_field = "13EAD37DEFBAB1AFDB319710EDF30DA0", hash_generated_field = "3D4A99BE365809A5EB1E511AD6BB5B53")

    protected static final int EVENT_GET_SIM_STATUS_DONE = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.705 -0400", hash_original_field = "AD8D0804246C1D141514EDA5940C9D1F", hash_generated_field = "DB3857DB2D26E19635E63A8698AC1EF9")

    protected static final int EVENT_SET_CALL_FORWARD_DONE = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.705 -0400", hash_original_field = "4E788AADE151D5C8C7E0A706216D0C23", hash_generated_field = "97F3C1FF5F112F459B560C8BD4FBD0DD")

    protected static final int EVENT_GET_CALL_FORWARD_DONE = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.705 -0400", hash_original_field = "3BBCE33DED884E1C10F035E4E0B678DC", hash_generated_field = "8C959D0AE67E3090BAF042BF196FC32E")

    protected static final int EVENT_CALL_RING = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.705 -0400", hash_original_field = "D2E121C6F2B32945F9F009B6D03222B8", hash_generated_field = "8999C19E2089FB0CACED02CBFCC703E9")

    protected static final int EVENT_CALL_RING_CONTINUE = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.705 -0400", hash_original_field = "3FCBE8EB5F59454A9668A2C48CC05E01", hash_generated_field = "E0E0E667BD342B255F47DA43AFE57188")

    protected static final int EVENT_SET_NETWORK_MANUAL_COMPLETE = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.705 -0400", hash_original_field = "C2FE1D004F9EC0A845F4110CAAE00CE9", hash_generated_field = "1870B5B507D5E8786B16A58E221DD746")

    protected static final int EVENT_SET_NETWORK_AUTOMATIC_COMPLETE = 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.705 -0400", hash_original_field = "968FC720F6C8981F12C9FEF464D488EA", hash_generated_field = "FD21C21324B661C6024ED1187C7875E6")

    protected static final int EVENT_SET_CLIR_COMPLETE = 18;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.705 -0400", hash_original_field = "5D5F4AA336B5A56517328D2833900CF9", hash_generated_field = "81455D0AA37A30A4A32EC86BBBBBED44")

    protected static final int EVENT_REGISTERED_TO_NETWORK = 19;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.705 -0400", hash_original_field = "6CD34EBB07F80972156850C9EFE76044", hash_generated_field = "075B4E9B1E591EA88F80A50CF77DB9EF")

    protected static final int EVENT_SET_VM_NUMBER_DONE = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.706 -0400", hash_original_field = "0885B96944C04E10E35E50D2F5EFB157", hash_generated_field = "92C4385C14905F645AF238D78D5E792E")

    protected static final int EVENT_GET_DEVICE_IDENTITY_DONE = 21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.706 -0400", hash_original_field = "FD8E2E4612A2CCEFA6A37098E5316A31", hash_generated_field = "15D1C2EE172DF30CB817174BCF200282")

    protected static final int EVENT_RUIM_RECORDS_LOADED = 22;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.706 -0400", hash_original_field = "CD55E3B1897A35367D22181D0372CB3E", hash_generated_field = "CEC5A5A926313E5BA6C82EC3BBD42934")

    protected static final int EVENT_NV_READY = 23;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.706 -0400", hash_original_field = "90D5FC3F23C7A02866B30F952A3CF25C", hash_generated_field = "DE3F8C6D550D91C6EE475636A277AB01")

    protected static final int EVENT_SET_ENHANCED_VP = 24;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.706 -0400", hash_original_field = "F6A08538564CA706875A1011D90A2AF2", hash_generated_field = "8BB3FE9B4018C1F340AE0CD3F8D2A7A2")

    protected static final int EVENT_EMERGENCY_CALLBACK_MODE_ENTER = 25;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.706 -0400", hash_original_field = "31CEA8EBF9D9C470D2867CD87637B86F", hash_generated_field = "F0E3A8092FBCD429DAB23C8999220D9D")

    protected static final int EVENT_EXIT_EMERGENCY_CALLBACK_RESPONSE = 26;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.706 -0400", hash_original_field = "D053E0B25088C99F47C3FD60BC2BD69F", hash_generated_field = "9A1A5B75F1AB4B2786E10ADC52774587")

    public static final String CLIR_KEY = "clir_key";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.706 -0400", hash_original_field = "595502B5C67E5C7D5745B347C567C531", hash_generated_field = "23F928F88F407C390580E9819551272F")

    public static final String DNS_SERVER_CHECK_DISABLED_KEY = "dns_server_check_disabled_key";
}

