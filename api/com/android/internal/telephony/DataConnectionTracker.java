package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.net.LinkCapabilities;
import android.net.LinkProperties;
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.net.wifi.WifiManager;
import android.os.AsyncResult;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.provider.Settings.SettingNotFoundException;
import android.telephony.ServiceState;
import android.text.TextUtils;
import android.util.Log;
import com.android.internal.R;
import com.android.internal.telephony.DataConnection.FailCause;
import com.android.internal.util.AsyncChannel;
import com.android.internal.util.Protocol;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class DataConnectionTracker extends Handler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.550 -0400", hash_original_field = "0C574BF34249141BA4157A2B3A13DF65", hash_generated_field = "35FA5A91B80F269D1DB9B36DE1EC65CA")

    protected Object mDataEnabledLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.550 -0400", hash_original_field = "83C02F715D848B29A8DCE10BED0E6E91", hash_generated_field = "029ADD06C51569E156E858EF56AC06DA")

    protected boolean mInternalDataEnabled = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.550 -0400", hash_original_field = "C50C8B8054B63CB49F8E494BC522CCEB", hash_generated_field = "68DF71977C4718650ADDCD81C2B1620F")

    protected boolean mUserDataEnabled = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.550 -0400", hash_original_field = "8BC574D28C89B1AA9EB1F52525413A33", hash_generated_field = "F49B5B07667CCB529520831482D9BAB1")

    private boolean[] dataEnabled = new boolean[APN_NUM_TYPES];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.550 -0400", hash_original_field = "4F4BB97BAFF6649F5948F3AEF5C5E004", hash_generated_field = "8420FF89B70ED10465A38AC8B70D9095")

    private int enabledCount = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.550 -0400", hash_original_field = "37622627749352C73B065DAEF77331F4", hash_generated_field = "4C2B2DCF407C9F63C855A59D9F29A37A")

    protected String mRequestedApnType = Phone.APN_TYPE_DEFAULT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.550 -0400", hash_original_field = "0B51F170940EEB2AE623BBE06DE8E32A", hash_generated_field = "1894211C4C78CAACE34F0DC8EE3A13C1")

    protected int mFailDataSetupCounter = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.550 -0400", hash_original_field = "75AAA2EE794A2614791655B02867656E", hash_generated_field = "EC29A5CA55085C10657861453E10B11C")

    protected FailCause mFailDataSetupFailCause = FailCause.ERROR_UNSPECIFIED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.551 -0400", hash_original_field = "44BC87C3198CFC247427A5305FDEA9BE", hash_generated_field = "C5284483C4CF8ED630A2E2607ED30E12")

    protected PhoneBase mPhone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.551 -0400", hash_original_field = "0F5A83CC88F3EE71F4066661CD2FB5D3", hash_generated_field = "5CE7295912ACD2604E7762D907339691")

    protected Activity mActivity = Activity.NONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.551 -0400", hash_original_field = "6C72EA28B063EE31BBEAC312EBCF2483", hash_generated_field = "CEA309476306FEF09638ED5ED829D6A1")

    protected State mState = State.IDLE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.551 -0400", hash_original_field = "C2ECAD1B16A6AC316391B5BD3F156E8F", hash_generated_field = "963D8F7E00CCB73CD43AA6DA0AE9DF2A")

    protected Handler mDataConnectionTracker = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.551 -0400", hash_original_field = "F07A7E8D1AE67A08367F6C717D5DE438", hash_generated_field = "C066AA046467E6BBB3EA5DDB129B3DB8")

    protected long mTxPkts;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.551 -0400", hash_original_field = "BC09E4210C29FFF34666B06F6307B4F2", hash_generated_field = "F031B0AD358C38347F225F90F75B03E4")

    protected long mRxPkts;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.551 -0400", hash_original_field = "E88A6F081F6EB811DC49E055A2D799F6", hash_generated_field = "D9D10A2C69888D907D9D54771B7DB2A5")

    protected int mNetStatPollPeriod;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.551 -0400", hash_original_field = "E3C4C2B3F35259439146CD5411F92DE0", hash_generated_field = "8AEC394E7895B11DB0C1B86A5A82BE9C")

    protected boolean mNetStatPollEnabled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.551 -0400", hash_original_field = "BF6EEADB4389844D7AA67B505D20D752", hash_generated_field = "B4F64D56417D37A4C51A5C74706E778F")

    protected TxRxSum mDataStallTxRxSum = new TxRxSum(0, 0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.551 -0400", hash_original_field = "3FFBAEFC9FD53A580EC601AC99081F9B", hash_generated_field = "922642510706D7E1F40906A8E67562E6")

    protected int mDataStallAlarmTag = (int) SystemClock.elapsedRealtime();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.551 -0400", hash_original_field = "3121E27D2FFCAB719F984045B26119F7", hash_generated_field = "3964C7D016D96B23E8A4F338B71B706B")

    protected PendingIntent mDataStallAlarmIntent = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.551 -0400", hash_original_field = "C9FDF2A5D3CD3973F122C86C6FBD0B48", hash_generated_field = "6467835C9ADB216F54C7DD6564D528DC")

    protected long mSentSinceLastRecv;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.551 -0400", hash_original_field = "113DA8858F130CCEA1AB8790322771B7", hash_generated_field = "34A070F678DFA34A23ADEF39527A564C")

    protected int mNoRecvPollCount = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.552 -0400", hash_original_field = "BA2632DCA63DFE3E80BE54C563DA3B60", hash_generated_field = "9A8B10322BB7B36EE6E7CC8062CC1FBF")

    protected boolean mIsWifiConnected = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.552 -0400", hash_original_field = "F624BA341CEE490E0F6E6147BBEFD20A", hash_generated_field = "12A1D0ED5463C3F1D91D57D8EA6A8B7B")

    protected PendingIntent mReconnectIntent = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.552 -0400", hash_original_field = "5C56A171AFF86F8C7A0A13B02C0B482D", hash_generated_field = "D5A8886EAF52251545AC3AD33951BCDD")

    protected int mCidActive;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.552 -0400", hash_original_field = "3F9BEBDB99B792833728E81C043D71E1", hash_generated_field = "520BD7D1996D720DF52FDD45FFE94136")

    protected boolean mAutoAttachOnCreation = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.552 -0400", hash_original_field = "144B8708956D2D49F2FD05BBF954A65B", hash_generated_field = "443F358D0A339820F2F3C7798BC25ADF")

    protected boolean mIsScreenOn = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.552 -0400", hash_original_field = "7F27308BF5E86222C75F05C218C928BE", hash_generated_field = "E7C2C970E82ACEA7CAE10990548181FE")

    protected AtomicInteger mUniqueIdGenerator = new AtomicInteger(0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.552 -0400", hash_original_field = "D307CBBB85DCF557505B4275470BF6F6", hash_generated_field = "F773E5340FE87B52017BDABC34CF0248")

    protected HashMap<Integer, DataConnection> mDataConnections = new HashMap<Integer, DataConnection>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.552 -0400", hash_original_field = "79D26F63DD5553FA40470C897E398B22", hash_generated_field = "22F5DEEB14FFD2F3D69D57FCCF0F9FB1")

    protected HashMap<Integer, DataConnectionAc> mDataConnectionAsyncChannels = new HashMap<Integer, DataConnectionAc>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.552 -0400", hash_original_field = "FA6C20B1FC2F2FE98FB6A402065CE910", hash_generated_field = "E1D4371B7D81B0ADAB75212C0682A1E6")

    protected HashMap<String, Integer> mApnToDataConnectionId = new HashMap<String, Integer>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.552 -0400", hash_original_field = "62B502403C74E21713DD7847EA23B4D5", hash_generated_field = "941E5870BFAF3D02817684E802B4207E")

    protected ConcurrentHashMap<String, ApnContext> mApnContexts;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.552 -0400", hash_original_field = "42B5BBFF6E953F5C723EB47B2978873F", hash_generated_field = "910D7E883F89F3141D476B143EF29779")

    protected ApnSetting mActiveApn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.552 -0400", hash_original_field = "F85E1B64E5CC97E2E68B558F4155CBA1", hash_generated_field = "D877191FC5F094158A904672156AA8C5")

    protected ArrayList<ApnSetting> mAllApns = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.553 -0400", hash_original_field = "229AC432B91972CC26BCF8C8ECBB4E35", hash_generated_field = "FC9CCB9D49A758A95E153C604DAFC1C3")

    protected ApnSetting mPreferredApn = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.553 -0400", hash_original_field = "0A981A794DB3A35FBC09ABB9C5C9D0C0", hash_generated_field = "B458E88DEC049EDD2472BF239226E4CB")

    protected boolean mIsPsRestricted = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.553 -0400", hash_original_field = "A0FC4D1A501D52A82344B1933DD703BB", hash_generated_field = "0421A765569015D55BB5FDAB22E936EA")

    protected boolean mIsDisposed = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.972 -0400", hash_original_field = "3DC9FC0A8AC52E83B9299E90E867B385", hash_generated_field = "50B61350598B45B5FA16B7596B8B9FD4")

    protected BroadcastReceiver mIntentReceiver = new BroadcastReceiver() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.972 -0400", hash_original_method = "1961A46761D2A74B4BBC61E9BCC43068", hash_generated_method = "0252BFECBC373E4A0BFABE33F7D5DC8C")
        @Override
        public void onReceive(Context context, Intent intent) {
            
            String action = intent.getAction();
            log("onReceive: action=" + action);
            {
                boolean var96145FA3EA33578069DB26D54E8F101D_86358011 = (action.equals(Intent.ACTION_SCREEN_ON));
                {
                    mIsScreenOn = true;
                    stopNetStatPoll();
                    startNetStatPoll();
                } 
                {
                    boolean var767BEBC8FC1BF29BC19AA771B91C30DC_893184092 = (action.equals(Intent.ACTION_SCREEN_OFF));
                    {
                        mIsScreenOn = false;
                        stopNetStatPoll();
                        startNetStatPoll();
                    } 
                    {
                        boolean var657B0255569FEE532E29E31650D4768F_414353654 = (action.startsWith(getActionIntentReconnectAlarm()));
                        {
                            log("Reconnect alarm. Previous state was " + mState);
                            onActionIntentReconnectAlarm(intent);
                        } 
                        {
                            boolean var36F8FFF0AF59FF54D7904599A20B6C27_201922250 = (action.equals(getActionIntentDataStallAlarm()));
                            {
                                onActionIntentDataStallAlarm(intent);
                            } 
                            {
                                boolean varAEED26211C259A659D32D3D5886FD918_605196215 = (action.equals(WifiManager.NETWORK_STATE_CHANGED_ACTION));
                                {
                                    final android.net.NetworkInfo networkInfo = (NetworkInfo)
                        intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
                                    mIsWifiConnected = (networkInfo != null && networkInfo.isConnected());
                                } 
                                {
                                    boolean var63C3653546FDFD746F5A5E4F5D93A7DF_1402023471 = (action.equals(WifiManager.WIFI_STATE_CHANGED_ACTION));
                                    {
                                        final boolean enabled = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE,
                        WifiManager.WIFI_STATE_UNKNOWN) == WifiManager.WIFI_STATE_ENABLED;
                                        {
                                            mIsWifiConnected = false;
                                        } 
                                    } 
                                    {
                                        boolean varC1CD06FA6A7988C248E9A4EC09E1418D_1720769185 = (action.equals(INTENT_SET_FAIL_DATA_SETUP_COUNTER));
                                        {
                                            mFailDataSetupCounter = intent.getIntExtra(FAIL_DATA_SETUP_COUNTER, 1);
                                            mFailDataSetupFailCause = FailCause.fromInt(
                        intent.getIntExtra(FAIL_DATA_SETUP_FAIL_CAUSE,
                                                    FailCause.ERROR_UNSPECIFIED.getErrorCode()));
                                            log("set mFailDataSetupCounter=" + mFailDataSetupCounter +
                        " mFailDataSetupFailCause=" + mFailDataSetupFailCause);
                                        } 
                                    } 
                                } 
                            } 
                        } 
                    } 
                } 
            } 
            addTaint(context.getTaint());
            addTaint(intent.getTaint());
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.553 -0400", hash_original_field = "8BDD1549FE3A70CEB234E0690EAEE942", hash_generated_field = "6D8A2CC8A7E85CEA15EFEA2E663FA6FC")

    private DataRoamingSettingObserver mDataRoamingSettingObserver;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.555 -0400", hash_original_method = "3BD12FD7917DD1B6F1FA4984E09C99CB", hash_generated_method = "7BD1492D3554F7B862B51CC1AA738609")
    protected  DataConnectionTracker(PhoneBase phone) {
        super();
        mPhone = phone;
        IntentFilter filter = new IntentFilter();
        filter.addAction(getActionIntentReconnectAlarm());
        filter.addAction(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        filter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
        filter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
        filter.addAction(INTENT_SET_FAIL_DATA_SETUP_COUNTER);
        mUserDataEnabled = Settings.Secure.getInt(
                mPhone.getContext().getContentResolver(), Settings.Secure.MOBILE_DATA, 1) == 1;
        mPhone.getContext().registerReceiver(mIntentReceiver, filter, null, mPhone);
        dataEnabled[APN_DEFAULT_ID] = SystemProperties.getBoolean(DEFALUT_DATA_ON_BOOT_PROP,
                                                                  true);
    if(dataEnabled[APN_DEFAULT_ID])        
        {
            enabledCount++;
        } //End block
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(mPhone.getContext());
        mAutoAttachOnCreation = sp.getBoolean(PhoneBase.DATA_DISABLED_ON_BOOT_KEY, false);
        mDataRoamingSettingObserver = new DataRoamingSettingObserver(mPhone);
        mDataRoamingSettingObserver.register(mPhone.getContext());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.556 -0400", hash_original_method = "C16C211E95AFFD72D353E5EF5692A650", hash_generated_method = "CA869913EB3F76BF257A4EC6CDCA4A93")
    protected boolean isDataSetupCompleteOk(AsyncResult ar) {
        addTaint(ar.getTaint());
    if(ar.exception != null)        
        {
    if(DBG)            
            log("isDataSetupCompleteOk return false, ar.result=" + ar.result);
            boolean var68934A3E9455FA72420237EB05902327_1759290052 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_168117220 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_168117220;
        } //End block
    if(mFailDataSetupCounter <= 0)        
        {
    if(DBG)            
            log("isDataSetupCompleteOk return true");
            boolean varB326B5062B2F0E69046810717534CB09_1383035269 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1962884707 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1962884707;
        } //End block
        ar.result = mFailDataSetupFailCause;
    if(DBG)        
        {
            log("isDataSetupCompleteOk return false" +
                    " mFailDataSetupCounter=" + mFailDataSetupCounter +
                    " mFailDataSetupFailCause=" + mFailDataSetupFailCause);
        } //End block
        mFailDataSetupCounter -= 1;
        boolean var68934A3E9455FA72420237EB05902327_296169694 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1631553036 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1631553036;
        // ---------- Original Method ----------
        //if (ar.exception != null) {
            //if (DBG) log("isDataSetupCompleteOk return false, ar.result=" + ar.result);
            //return false;
        //}
        //if (mFailDataSetupCounter <= 0) {
            //if (DBG) log("isDataSetupCompleteOk return true");
            //return true;
        //}
        //ar.result = mFailDataSetupFailCause;
        //if (DBG) {
            //log("isDataSetupCompleteOk return false" +
                    //" mFailDataSetupCounter=" + mFailDataSetupCounter +
                    //" mFailDataSetupFailCause=" + mFailDataSetupFailCause);
        //}
        //mFailDataSetupCounter -= 1;
        //return false;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.557 -0400", hash_original_method = "838D9E0EFB087A153045FCBAD3FD613D", hash_generated_method = "536C7051BB882BF5271FE2006DB7E498")
    protected void onActionIntentReconnectAlarm(Intent intent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(intent.getTaint());
        String reason = intent.getStringExtra(INTENT_RECONNECT_ALARM_EXTRA_REASON);
    if(mState == State.FAILED)        
        {
            Message msg = obtainMessage(EVENT_CLEAN_UP_CONNECTION);
            msg.arg1 = 0;
            msg.arg2 = 0;
            msg.obj = reason;
            sendMessage(msg);
        } //End block
        sendMessage(obtainMessage(EVENT_TRY_SETUP_DATA));
        // ---------- Original Method ----------
        //String reason = intent.getStringExtra(INTENT_RECONNECT_ALARM_EXTRA_REASON);
        //if (mState == State.FAILED) {
            //Message msg = obtainMessage(EVENT_CLEAN_UP_CONNECTION);
            //msg.arg1 = 0; 
            //msg.arg2 = 0;
            //msg.obj = reason;
            //sendMessage(msg);
        //}
        //sendMessage(obtainMessage(EVENT_TRY_SETUP_DATA));
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.557 -0400", hash_original_method = "A1F89C02319CA5D605879D459A1AC731", hash_generated_method = "1C71AFF88AAA89DB68FA022702215CC6")
    protected void onActionIntentDataStallAlarm(Intent intent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(intent.getTaint());
    if(VDBG)        
        log("onActionIntentDataStallAlarm: action=" + intent.getAction());
        Message msg = obtainMessage(EVENT_DATA_STALL_ALARM, intent.getAction());
        msg.arg1 = intent.getIntExtra(DATA_STALL_ALARM_TAG_EXTRA, 0);
        sendMessage(msg);
        // ---------- Original Method ----------
        //if (VDBG) log("onActionIntentDataStallAlarm: action=" + intent.getAction());
        //Message msg = obtainMessage(EVENT_DATA_STALL_ALARM, intent.getAction());
        //msg.arg1 = intent.getIntExtra(DATA_STALL_ALARM_TAG_EXTRA, 0);
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.558 -0400", hash_original_method = "D3ED6AC13F3F749DE4F1E160957198B8", hash_generated_method = "D1D7D75C0FB346A6B2A823043E505B36")
    public void dispose() {
for(DataConnectionAc dcac : mDataConnectionAsyncChannels.values())
        {
            dcac.disconnect();
        } //End block
        mDataConnectionAsyncChannels.clear();
        mIsDisposed = true;
        mPhone.getContext().unregisterReceiver(this.mIntentReceiver);
        mDataRoamingSettingObserver.unregister(mPhone.getContext());
        // ---------- Original Method ----------
        //for (DataConnectionAc dcac : mDataConnectionAsyncChannels.values()) {
            //dcac.disconnect();
        //}
        //mDataConnectionAsyncChannels.clear();
        //mIsDisposed = true;
        //mPhone.getContext().unregisterReceiver(this.mIntentReceiver);
        //mDataRoamingSettingObserver.unregister(mPhone.getContext());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.558 -0400", hash_original_method = "DDDDA1A5545DB0A17ACC18101B011287", hash_generated_method = "682F88DBA371196ED3D270082EBC7DA8")
    protected void broadcastMessenger() {
        Intent intent = new Intent(ACTION_DATA_CONNECTION_TRACKER_MESSENGER);
        intent.putExtra(EXTRA_MESSENGER, new Messenger(this));
        mPhone.getContext().sendBroadcast(intent);
        // ---------- Original Method ----------
        //Intent intent = new Intent(ACTION_DATA_CONNECTION_TRACKER_MESSENGER);
        //intent.putExtra(EXTRA_MESSENGER, new Messenger(this));
        //mPhone.getContext().sendBroadcast(intent);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.558 -0400", hash_original_method = "3F17133E8D63AE8C7414DC58966291E3", hash_generated_method = "00D6C51F0128ACD3AA288D536B99AF7C")
    public Activity getActivity() {
Activity var3D4F4FFFAA1A051817B4856E624EDB92_591224138 =         mActivity;
        var3D4F4FFFAA1A051817B4856E624EDB92_591224138.addTaint(taint);
        return var3D4F4FFFAA1A051817B4856E624EDB92_591224138;
        // ---------- Original Method ----------
        //return mActivity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.559 -0400", hash_original_method = "125099B58F8163C25EB6B1F0707923F4", hash_generated_method = "AAA9C2F4FCFD2EED46733B8C479B720E")
    public boolean isApnTypeActive(String type) {
        addTaint(type.getTaint());
    if(Phone.APN_TYPE_DUN.equals(type))        
        {
            ApnSetting dunApn = fetchDunApn();
    if(dunApn != null)            
            {
                boolean var3AFD3BF66423A82F7AF18DA703F569EE_1973785758 = (((mActiveApn != null) && (dunApn.toString().equals(mActiveApn.toString()))));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1982802227 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1982802227;
            } //End block
        } //End block
        boolean varCBB994E2D5FD8D993D9EA8AE14203E17_1039528244 = (mActiveApn != null && mActiveApn.canHandleType(type));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_967593426 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_967593426;
        // ---------- Original Method ----------
        //if (Phone.APN_TYPE_DUN.equals(type)) {
            //ApnSetting dunApn = fetchDunApn();
            //if (dunApn != null) {
                //return ((mActiveApn != null) && (dunApn.toString().equals(mActiveApn.toString())));
            //}
        //}
        //return mActiveApn != null && mActiveApn.canHandleType(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.559 -0400", hash_original_method = "616B5B126FC289B3EB6BE1030B710468", hash_generated_method = "DC65A8B1230C1726D475C6AA72CF1174")
    protected ApnSetting fetchDunApn() {
        Context c = mPhone.getContext();
        String apnData = Settings.Secure.getString(c.getContentResolver(),
                Settings.Secure.TETHER_DUN_APN);
        ApnSetting dunSetting = ApnSetting.fromString(apnData);
    if(dunSetting != null)        
        {
ApnSetting varFA30BED9F6B1B323499332ABA08F40FB_733954953 =         dunSetting;
        varFA30BED9F6B1B323499332ABA08F40FB_733954953.addTaint(taint);
        return varFA30BED9F6B1B323499332ABA08F40FB_733954953;
        }
        apnData = c.getResources().getString(R.string.config_tether_apndata);
ApnSetting var65439A79463534529915DF75B559437E_1375255120 =         ApnSetting.fromString(apnData);
        var65439A79463534529915DF75B559437E_1375255120.addTaint(taint);
        return var65439A79463534529915DF75B559437E_1375255120;
        // ---------- Original Method ----------
        //Context c = mPhone.getContext();
        //String apnData = Settings.Secure.getString(c.getContentResolver(),
                //Settings.Secure.TETHER_DUN_APN);
        //ApnSetting dunSetting = ApnSetting.fromString(apnData);
        //if (dunSetting != null) return dunSetting;
        //apnData = c.getResources().getString(R.string.config_tether_apndata);
        //return ApnSetting.fromString(apnData);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.560 -0400", hash_original_method = "F0E40F922DBB5D19CCBEC497FB284EC5", hash_generated_method = "3266295F856DD17AA9E378B276A86986")
    public String[] getActiveApnTypes() {
        String[] result;
    if(mActiveApn != null)        
        {
            result = mActiveApn.types;
        } //End block
        else
        {
            result = new String[1];
            result[0] = Phone.APN_TYPE_DEFAULT;
        } //End block
String[] varDC838461EE2FA0CA4C9BBB70A15456B0_81340707 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_81340707.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_81340707;
        // ---------- Original Method ----------
        //String[] result;
        //if (mActiveApn != null) {
            //result = mActiveApn.types;
        //} else {
            //result = new String[1];
            //result[0] = Phone.APN_TYPE_DEFAULT;
        //}
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.560 -0400", hash_original_method = "8A278F7563F3F2CC899D3E200DD135CD", hash_generated_method = "708FB7DD74344545737B919CAE1818FC")
    public String getActiveApnString(String apnType) {
        addTaint(apnType.getTaint());
        String result = null;
    if(mActiveApn != null)        
        {
            result = mActiveApn.apn;
        } //End block
String varDC838461EE2FA0CA4C9BBB70A15456B0_1381137663 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1381137663.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1381137663;
        // ---------- Original Method ----------
        //String result = null;
        //if (mActiveApn != null) {
            //result = mActiveApn.apn;
        //}
        //return result;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.560 -0400", hash_original_method = "B18C74BBD4D71B87D6CD20822DAEB60C", hash_generated_method = "C97E710BBC1DD84173B78B810F47DD49")
    public void setDataOnRoamingEnabled(boolean enabled) {
        addTaint(enabled);
    if(getDataOnRoamingEnabled() != enabled)        
        {
            final ContentResolver resolver = mPhone.getContext().getContentResolver();
            Settings.Secure.putInt(resolver, Settings.Secure.DATA_ROAMING, enabled ? 1 : 0);
        } //End block
        // ---------- Original Method ----------
        //if (getDataOnRoamingEnabled() != enabled) {
            //final ContentResolver resolver = mPhone.getContext().getContentResolver();
            //Settings.Secure.putInt(resolver, Settings.Secure.DATA_ROAMING, enabled ? 1 : 0);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.561 -0400", hash_original_method = "CA847DB1E96260749F912EC65B12A685", hash_generated_method = "9572FE7C7D994A0B1070FFCD23EF0D9C")
    public boolean getDataOnRoamingEnabled() {
        try 
        {
            final ContentResolver resolver = mPhone.getContext().getContentResolver();
            boolean var2A5D8F9A444636551174E1DA75ABBB45_1316206271 = (Settings.Secure.getInt(resolver, Settings.Secure.DATA_ROAMING) != 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1733395766 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1733395766;
        } //End block
        catch (SettingNotFoundException snfe)
        {
            boolean var68934A3E9455FA72420237EB05902327_2042547922 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2135029035 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2135029035;
        } //End block
        // ---------- Original Method ----------
        //try {
            //final ContentResolver resolver = mPhone.getContext().getContentResolver();
            //return Settings.Secure.getInt(resolver, Settings.Secure.DATA_ROAMING) != 0;
        //} catch (SettingNotFoundException snfe) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.561 -0400", hash_original_method = "D53421F789432FAA1BE4F347AFB92C88", hash_generated_method = "6C0556EAFE4C339B1C1E54862624B0DA")
    private void handleDataOnRoamingChange() {
    if(mPhone.getServiceState().getRoaming())        
        {
    if(getDataOnRoamingEnabled())            
            {
                resetAllRetryCounts();
            } //End block
            sendMessage(obtainMessage(EVENT_ROAMING_ON));
        } //End block
        // ---------- Original Method ----------
        //if (mPhone.getServiceState().getRoaming()) {
            //if (getDataOnRoamingEnabled()) {
                //resetAllRetryCounts();
            //}
            //sendMessage(obtainMessage(EVENT_ROAMING_ON));
        //}
    }

    
    protected abstract String getActionIntentReconnectAlarm();

    
    protected abstract String getActionIntentDataStallAlarm();

    
    protected abstract void startNetStatPoll();

    
    protected abstract void stopNetStatPoll();

    
    protected abstract void restartRadio();

    
    protected abstract void log(String s);

    
    protected abstract void loge(String s);

    
    protected abstract boolean isDataAllowed();

    
    protected abstract boolean isApnTypeAvailable(String type);

    
    public abstract State getState(String apnType);

    
    protected abstract void setState(State s);

    
    protected abstract void gotoIdleAndNotifyDataConnection(String reason);

    
    protected abstract boolean onTrySetupData(String reason);

    
    protected abstract void onRoamingOff();

    
    protected abstract void onRoamingOn();

    
    protected abstract void onRadioAvailable();

    
    protected abstract void onRadioOffOrNotAvailable();

    
    protected abstract void onDataSetupComplete(AsyncResult ar);

    
    protected abstract void onDisconnectDone(int connId, AsyncResult ar);

    
    protected abstract void onVoiceCallStarted();

    
    protected abstract void onVoiceCallEnded();

    
    protected abstract void onCleanUpConnection(boolean tearDown, int apnId, String reason);

    
    protected abstract void onCleanUpAllConnections(String cause);

    
    protected abstract boolean isDataPossible(String apnType);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.563 -0400", hash_original_method = "664FE2A04A36F386D94369A328F3D0AD", hash_generated_method = "3CAB0DA860D727FE54051CF6AA1C5C68")
    protected void onDataStallAlarm(int tag) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(tag);
        loge("onDataStallAlarm: not impleted tag=" + tag);
        // ---------- Original Method ----------
        //loge("onDataStallAlarm: not impleted tag=" + tag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.564 -0400", hash_original_method = "F3EE7F03AAF60471D3A97F562455D5DC", hash_generated_method = "609BEB5ADBF8F1DC690495D2AB9B24FB")
    @Override
    public void handleMessage(Message msg) {
switch(msg.what){
        case AsyncChannel.CMD_CHANNEL_DISCONNECTED:
        {
            log("DISCONNECTED_CONNECTED: msg=" + msg);
            DataConnectionAc dcac = (DataConnectionAc) msg.obj;
            mDataConnectionAsyncChannels.remove(dcac.dataConnection.getDataConnectionId());
            dcac.disconnected();
            break;
        } //End block
        case EVENT_ENABLE_NEW_APN:
        onEnableApn(msg.arg1, msg.arg2);
        break;
        case EVENT_TRY_SETUP_DATA:
        String reason = null;
    if(msg.obj instanceof String)        
        {
            reason = (String) msg.obj;
        } //End block
        onTrySetupData(reason);
        break;
        case EVENT_DATA_STALL_ALARM:
        onDataStallAlarm(msg.arg1);
        break;
        case EVENT_ROAMING_OFF:
    if(getDataOnRoamingEnabled() == false)        
        {
            resetAllRetryCounts();
        } //End block
        onRoamingOff();
        break;
        case EVENT_ROAMING_ON:
        onRoamingOn();
        break;
        case EVENT_RADIO_AVAILABLE:
        onRadioAvailable();
        break;
        case EVENT_RADIO_OFF_OR_NOT_AVAILABLE:
        onRadioOffOrNotAvailable();
        break;
        case EVENT_DATA_SETUP_COMPLETE:
        mCidActive = msg.arg1;
        onDataSetupComplete((AsyncResult) msg.obj);
        break;
        case EVENT_DISCONNECT_DONE:
        log("DataConnectoinTracker.handleMessage: EVENT_DISCONNECT_DONE msg=" + msg);
        onDisconnectDone(msg.arg1, (AsyncResult) msg.obj);
        break;
        case EVENT_VOICE_CALL_STARTED:
        onVoiceCallStarted();
        break;
        case EVENT_VOICE_CALL_ENDED:
        onVoiceCallEnded();
        break;
        case EVENT_CLEAN_UP_ALL_CONNECTIONS:
        {
            onCleanUpAllConnections((String) msg.obj);
            break;
        } //End block
        case EVENT_CLEAN_UP_CONNECTION:
        {
            boolean tearDown = (msg.arg1 == 0) ? false : true;
            onCleanUpConnection(tearDown, msg.arg2, (String) msg.obj);
            break;
        } //End block
        case EVENT_SET_INTERNAL_DATA_ENABLE:
        {
            boolean enabled = (msg.arg1 == ENABLED) ? true : false;
            onSetInternalDataEnabled(enabled);
            break;
        } //End block
        case EVENT_RESET_DONE:
        {
    if(DBG)            
            log("EVENT_RESET_DONE");
            onResetDone((AsyncResult) msg.obj);
            break;
        } //End block
        case CMD_SET_USER_DATA_ENABLE:
        {
            final boolean enabled = (msg.arg1 == ENABLED) ? true : false;
    if(DBG)            
            log("CMD_SET_USER_DATA_ENABLE enabled=" + enabled);
            onSetUserDataEnabled(enabled);
            break;
        } //End block
        case CMD_SET_DEPENDENCY_MET:
        {
            boolean met = (msg.arg1 == ENABLED) ? true : false;
    if(DBG)            
            log("CMD_SET_DEPENDENCY_MET met=" + met);
            Bundle bundle = msg.getData();
    if(bundle != null)            
            {
                String apnType = (String)bundle.get(APN_TYPE_KEY);
    if(apnType != null)                
                {
                    onSetDependencyMet(apnType, met);
                } //End block
            } //End block
            break;
        } //End block
        case CMD_SET_POLICY_DATA_ENABLE:
        {
            final boolean enabled = (msg.arg1 == ENABLED) ? true : false;
            onSetPolicyDataEnabled(enabled);
            break;
        } //End block
        default:
        break;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.564 -0400", hash_original_method = "8F4FE806494E709DA803471FC4054850", hash_generated_method = "673F5CBB54549F41FF3B0FDE9B27FD10")
    public boolean getAnyDataEnabled() {
        boolean result;
        synchronized
(mDataEnabledLock)        {
            result = (mInternalDataEnabled && mUserDataEnabled && sPolicyDataEnabled
                    && (enabledCount != 0));
        } //End block
    if(!result && DBG)        
        log("getAnyDataEnabled " + result);
        boolean varB4A88417B3D0170D754C647C30B7216A_1188557758 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1810114829 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1810114829;
        // ---------- Original Method ----------
        //final boolean result;
        //synchronized (mDataEnabledLock) {
            //result = (mInternalDataEnabled && mUserDataEnabled && sPolicyDataEnabled
                    //&& (enabledCount != 0));
        //}
        //if (!result && DBG) log("getAnyDataEnabled " + result);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.565 -0400", hash_original_method = "01BBE084CAD104CD5BF824EF92BD879D", hash_generated_method = "013756FC902A8A325A5AB88DDE0EB4AD")
    protected boolean isEmergency() {
        boolean result;
        synchronized
(mDataEnabledLock)        {
            result = mPhone.isInEcm() || mPhone.isInEmergencyCall();
        } //End block
        log("isEmergency: result=" + result);
        boolean varB4A88417B3D0170D754C647C30B7216A_1781140845 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1333050649 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1333050649;
        // ---------- Original Method ----------
        //final boolean result;
        //synchronized (mDataEnabledLock) {
            //result = mPhone.isInEcm() || mPhone.isInEmergencyCall();
        //}
        //log("isEmergency: result=" + result);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.565 -0400", hash_original_method = "5D23D8F3C80DDDEC0087C53C5035314E", hash_generated_method = "C2FCDD9A2975C5F28FEDDD1B748F873A")
    protected int apnTypeToId(String type) {
        addTaint(type.getTaint());
    if(TextUtils.equals(type, Phone.APN_TYPE_DEFAULT))        
        {
            int var552AAEE081FF85A84C425EA0310B1FED_790324011 = (APN_DEFAULT_ID);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2101484516 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2101484516;
        } //End block
        else
    if(TextUtils.equals(type, Phone.APN_TYPE_MMS))        
        {
            int var088091602161261899D43FCE97066C0D_232949985 = (APN_MMS_ID);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1521131711 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1521131711;
        } //End block
        else
    if(TextUtils.equals(type, Phone.APN_TYPE_SUPL))        
        {
            int varC8E8D3E8DDABFD7790CBACDE6FC943E1_1546582807 = (APN_SUPL_ID);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_507228103 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_507228103;
        } //End block
        else
    if(TextUtils.equals(type, Phone.APN_TYPE_DUN))        
        {
            int varB1407336BD9D55F416911DDE967A6553_1905889129 = (APN_DUN_ID);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1322898966 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1322898966;
        } //End block
        else
    if(TextUtils.equals(type, Phone.APN_TYPE_HIPRI))        
        {
            int var41E920AA1805146D171E3430454824E9_1232189628 = (APN_HIPRI_ID);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_449559784 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_449559784;
        } //End block
        else
    if(TextUtils.equals(type, Phone.APN_TYPE_IMS))        
        {
            int var06960F8481DB4979A3F756D0A0E89971_843547637 = (APN_IMS_ID);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1322552395 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1322552395;
        } //End block
        else
    if(TextUtils.equals(type, Phone.APN_TYPE_FOTA))        
        {
            int var8BC74CAAC7D86F5A48E3BCF4C1B83AEB_1272981391 = (APN_FOTA_ID);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_232186364 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_232186364;
        } //End block
        else
    if(TextUtils.equals(type, Phone.APN_TYPE_CBS))        
        {
            int var18988192338B43273C6A1624E9426B23_2137633421 = (APN_CBS_ID);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_818664412 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_818664412;
        } //End block
        else
        {
            int var1EC82D1DB82B954F5FD45614531C7929_872544945 = (APN_INVALID_ID);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_612642761 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_612642761;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.566 -0400", hash_original_method = "C8FDA5A0B2174A5D621C26D6E6AEF75F", hash_generated_method = "D83B2548281042A698966D6E15E10DBF")
    protected String apnIdToType(int id) {
        addTaint(id);
switch(id){
        case APN_DEFAULT_ID:
String var29DC2C652AC4FB5E9AC165A1EB0FF2BC_262898228 =         Phone.APN_TYPE_DEFAULT;
        var29DC2C652AC4FB5E9AC165A1EB0FF2BC_262898228.addTaint(taint);
        return var29DC2C652AC4FB5E9AC165A1EB0FF2BC_262898228;
        case APN_MMS_ID:
String var57E34012B87523FB92321E5D9BFA4A6C_428221003 =         Phone.APN_TYPE_MMS;
        var57E34012B87523FB92321E5D9BFA4A6C_428221003.addTaint(taint);
        return var57E34012B87523FB92321E5D9BFA4A6C_428221003;
        case APN_SUPL_ID:
String var4BBB5809C08F063D1190B038B0D7FD41_1584916420 =         Phone.APN_TYPE_SUPL;
        var4BBB5809C08F063D1190B038B0D7FD41_1584916420.addTaint(taint);
        return var4BBB5809C08F063D1190B038B0D7FD41_1584916420;
        case APN_DUN_ID:
String varEC0B13F7B9720D246CE857BC861CC056_1898348172 =         Phone.APN_TYPE_DUN;
        varEC0B13F7B9720D246CE857BC861CC056_1898348172.addTaint(taint);
        return varEC0B13F7B9720D246CE857BC861CC056_1898348172;
        case APN_HIPRI_ID:
String var7528E0BE7D5F1453CAC67643BB0387D9_1319553399 =         Phone.APN_TYPE_HIPRI;
        var7528E0BE7D5F1453CAC67643BB0387D9_1319553399.addTaint(taint);
        return var7528E0BE7D5F1453CAC67643BB0387D9_1319553399;
        case APN_IMS_ID:
String varC8CDAF5B04CFBD88ACEFC89AF69B2F0D_71034724 =         Phone.APN_TYPE_IMS;
        varC8CDAF5B04CFBD88ACEFC89AF69B2F0D_71034724.addTaint(taint);
        return varC8CDAF5B04CFBD88ACEFC89AF69B2F0D_71034724;
        case APN_FOTA_ID:
String var987777C68340BF730C0CD2D72F9C4BFF_1025872301 =         Phone.APN_TYPE_FOTA;
        var987777C68340BF730C0CD2D72F9C4BFF_1025872301.addTaint(taint);
        return var987777C68340BF730C0CD2D72F9C4BFF_1025872301;
        case APN_CBS_ID:
String varB79538697CE235AA0A4B223AAE9555FC_2146536840 =         Phone.APN_TYPE_CBS;
        varB79538697CE235AA0A4B223AAE9555FC_2146536840.addTaint(taint);
        return varB79538697CE235AA0A4B223AAE9555FC_2146536840;
        default:
        log("Unknown id (" + id + ") in apnIdToType");
String var29DC2C652AC4FB5E9AC165A1EB0FF2BC_528746201 =         Phone.APN_TYPE_DEFAULT;
        var29DC2C652AC4FB5E9AC165A1EB0FF2BC_528746201.addTaint(taint);
        return var29DC2C652AC4FB5E9AC165A1EB0FF2BC_528746201;
}
        // ---------- Original Method ----------
        //switch (id) {
        //case APN_DEFAULT_ID:
            //return Phone.APN_TYPE_DEFAULT;
        //case APN_MMS_ID:
            //return Phone.APN_TYPE_MMS;
        //case APN_SUPL_ID:
            //return Phone.APN_TYPE_SUPL;
        //case APN_DUN_ID:
            //return Phone.APN_TYPE_DUN;
        //case APN_HIPRI_ID:
            //return Phone.APN_TYPE_HIPRI;
        //case APN_IMS_ID:
            //return Phone.APN_TYPE_IMS;
        //case APN_FOTA_ID:
            //return Phone.APN_TYPE_FOTA;
        //case APN_CBS_ID:
            //return Phone.APN_TYPE_CBS;
        //default:
            //log("Unknown id (" + id + ") in apnIdToType");
            //return Phone.APN_TYPE_DEFAULT;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.567 -0400", hash_original_method = "C93C3112872052D96A1B607494195947", hash_generated_method = "F5B819FF97B00A60512E158E954D1EBB")
    protected LinkProperties getLinkProperties(String apnType) {
        addTaint(apnType.getTaint());
        int id = apnTypeToId(apnType);
    if(isApnIdEnabled(id))        
        {
            DataConnectionAc dcac = mDataConnectionAsyncChannels.get(0);
LinkProperties var8BD4388B7A3814FD10D806AF7ED51688_470227201 =             dcac.getLinkPropertiesSync();
            var8BD4388B7A3814FD10D806AF7ED51688_470227201.addTaint(taint);
            return var8BD4388B7A3814FD10D806AF7ED51688_470227201;
        } //End block
        else
        {
LinkProperties varF900AB9E8929FEE5E70A9D065AB8EDB8_739000532 =             new LinkProperties();
            varF900AB9E8929FEE5E70A9D065AB8EDB8_739000532.addTaint(taint);
            return varF900AB9E8929FEE5E70A9D065AB8EDB8_739000532;
        } //End block
        // ---------- Original Method ----------
        //int id = apnTypeToId(apnType);
        //if (isApnIdEnabled(id)) {
            //DataConnectionAc dcac = mDataConnectionAsyncChannels.get(0);
            //return dcac.getLinkPropertiesSync();
        //} else {
            //return new LinkProperties();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.567 -0400", hash_original_method = "8B34AF8E1FD52F7524E0692F560388F1", hash_generated_method = "872F9B885F081FE0E9599A0D08185DA3")
    protected LinkCapabilities getLinkCapabilities(String apnType) {
        addTaint(apnType.getTaint());
        int id = apnTypeToId(apnType);
    if(isApnIdEnabled(id))        
        {
            DataConnectionAc dcac = mDataConnectionAsyncChannels.get(0);
LinkCapabilities varA8C7C4160E5DB787F53691E522778085_1007256635 =             dcac.getLinkCapabilitiesSync();
            varA8C7C4160E5DB787F53691E522778085_1007256635.addTaint(taint);
            return varA8C7C4160E5DB787F53691E522778085_1007256635;
        } //End block
        else
        {
LinkCapabilities var5BB424D660FE96EE1DB16C6054B1CD0C_92657787 =             new LinkCapabilities();
            var5BB424D660FE96EE1DB16C6054B1CD0C_92657787.addTaint(taint);
            return var5BB424D660FE96EE1DB16C6054B1CD0C_92657787;
        } //End block
        // ---------- Original Method ----------
        //int id = apnTypeToId(apnType);
        //if (isApnIdEnabled(id)) {
            //DataConnectionAc dcac = mDataConnectionAsyncChannels.get(0);
            //return dcac.getLinkCapabilitiesSync();
        //} else {
            //return new LinkCapabilities();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.567 -0400", hash_original_method = "EA8A5478D5AABF3FA098569BF99381B3", hash_generated_method = "587A5B0D19BEBC4E9735C63AA1EBE223")
    protected void notifyDataConnection(String reason) {
        addTaint(reason.getTaint());
for(int id = 0;id < APN_NUM_TYPES;id++)
        {
    if(dataEnabled[id])            
            {
                mPhone.notifyDataConnection(reason, apnIdToType(id));
            } //End block
        } //End block
        notifyOffApnsOfAvailability(reason);
        // ---------- Original Method ----------
        //for (int id = 0; id < APN_NUM_TYPES; id++) {
            //if (dataEnabled[id]) {
                //mPhone.notifyDataConnection(reason, apnIdToType(id));
            //}
        //}
        //notifyOffApnsOfAvailability(reason);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.567 -0400", hash_original_method = "0EE2FD1B724C501D31FB7072BBECFF7B", hash_generated_method = "F08D08B2A66FA39867946D4CA6BAA853")
    private void notifyApnIdUpToCurrent(String reason, int apnId) {
        addTaint(apnId);
        addTaint(reason.getTaint());
switch(mState){
        case IDLE:
        case INITING:
        break;
        case CONNECTING:
        case SCANNING:
        mPhone.notifyDataConnection(reason, apnIdToType(apnId), Phone.DataState.CONNECTING);
        break;
        case CONNECTED:
        case DISCONNECTING:
        mPhone.notifyDataConnection(reason, apnIdToType(apnId), Phone.DataState.CONNECTING);
        mPhone.notifyDataConnection(reason, apnIdToType(apnId), Phone.DataState.CONNECTED);
        break;
}
        // ---------- Original Method ----------
        //switch (mState) {
            //case IDLE:
            //case INITING:
                //break;
            //case CONNECTING:
            //case SCANNING:
                //mPhone.notifyDataConnection(reason, apnIdToType(apnId), Phone.DataState.CONNECTING);
                //break;
            //case CONNECTED:
            //case DISCONNECTING:
                //mPhone.notifyDataConnection(reason, apnIdToType(apnId), Phone.DataState.CONNECTING);
                //mPhone.notifyDataConnection(reason, apnIdToType(apnId), Phone.DataState.CONNECTED);
                //break;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.568 -0400", hash_original_method = "D45BD11E51C479A3FCCFFBAFE72F463B", hash_generated_method = "A4AF377911ED07AB1E529E91B016AB43")
    private void notifyApnIdDisconnected(String reason, int apnId) {
        addTaint(apnId);
        addTaint(reason.getTaint());
        mPhone.notifyDataConnection(reason, apnIdToType(apnId), Phone.DataState.DISCONNECTED);
        // ---------- Original Method ----------
        //mPhone.notifyDataConnection(reason, apnIdToType(apnId), Phone.DataState.DISCONNECTED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.568 -0400", hash_original_method = "AD67DC7D8E779758CC2EF151B8EB9A25", hash_generated_method = "C61E638C66BB3EF1EDCCD6F93E29F075")
    protected void notifyOffApnsOfAvailability(String reason) {
        addTaint(reason.getTaint());
    if(DBG)        
        log("notifyOffApnsOfAvailability - reason= " + reason);
for(int id = 0;id < APN_NUM_TYPES;id++)
        {
    if(!isApnIdEnabled(id))            
            {
                notifyApnIdDisconnected(reason, id);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (DBG) log("notifyOffApnsOfAvailability - reason= " + reason);
        //for (int id = 0; id < APN_NUM_TYPES; id++) {
            //if (!isApnIdEnabled(id)) {
                //notifyApnIdDisconnected(reason, id);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.568 -0400", hash_original_method = "8B5C5B568EA76224959243C3FA291570", hash_generated_method = "083E4449E27688E19E27C393196208A3")
    public boolean isApnTypeEnabled(String apnType) {
        addTaint(apnType.getTaint());
    if(apnType == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_750314368 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2033564230 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2033564230;
        } //End block
        else
        {
            boolean var44D343FDCEA1E03361C4816D22D51CE0_1181518766 = (isApnIdEnabled(apnTypeToId(apnType)));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_110225796 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_110225796;
        } //End block
        // ---------- Original Method ----------
        //if (apnType == null) {
            //return false;
        //} else {
            //return isApnIdEnabled(apnTypeToId(apnType));
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.568 -0400", hash_original_method = "453A43A7EADEB97159250F7F1E9B04E5", hash_generated_method = "E197F70994DEC26AC8B2AFBEC1E23649")
    protected synchronized boolean isApnIdEnabled(int id) {
        addTaint(id);
    if(id != APN_INVALID_ID)        
        {
            boolean var553C8A0DB1F0C5B8FA2D885C75FCB9FE_12691898 = (dataEnabled[id]);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1221857941 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1221857941;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1694832593 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1252701540 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1252701540;
        // ---------- Original Method ----------
        //if (id != APN_INVALID_ID) {
            //return dataEnabled[id];
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.568 -0400", hash_original_method = "B518CE0EFC616BFFCBE5135F2BCA33B7", hash_generated_method = "0AD0FAC40819DA3A10F4748E37F87570")
    public synchronized int enableApnType(String type) {
        addTaint(type.getTaint());
        int id = apnTypeToId(type);
    if(id == APN_INVALID_ID)        
        {
            int var828862E346BB9F0775660355A8FF69D9_1042771202 = (Phone.APN_REQUEST_FAILED);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1295731045 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1295731045;
        } //End block
    if(DBG)        
        {
            log("enableApnType(" + type + "), isApnTypeActive = " + isApnTypeActive(type)
                    + ", isApnIdEnabled =" + isApnIdEnabled(id) + " and state = " + mState);
        } //End block
    if(!isApnTypeAvailable(type))        
        {
    if(DBG)            
            log("type not available");
            int var8DA92D2F202C4CA76CA9A68B75D9B1E3_1561656875 = (Phone.APN_TYPE_NOT_AVAILABLE);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1399522097 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1399522097;
        } //End block
    if(isApnIdEnabled(id))        
        {
            int var10EDC12F6E39EB6E652C0E451BD3FCA6_244989612 = (Phone.APN_ALREADY_ACTIVE);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_299611775 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_299611775;
        } //End block
        else
        {
            setEnabled(id, true);
        } //End block
        int var294B3FA049569E2B8E6FC7D927E71152_318657349 = (Phone.APN_REQUEST_STARTED);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_887940834 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_887940834;
        // ---------- Original Method ----------
        //int id = apnTypeToId(type);
        //if (id == APN_INVALID_ID) {
            //return Phone.APN_REQUEST_FAILED;
        //}
        //if (DBG) {
            //log("enableApnType(" + type + "), isApnTypeActive = " + isApnTypeActive(type)
                    //+ ", isApnIdEnabled =" + isApnIdEnabled(id) + " and state = " + mState);
        //}
        //if (!isApnTypeAvailable(type)) {
            //if (DBG) log("type not available");
            //return Phone.APN_TYPE_NOT_AVAILABLE;
        //}
        //if (isApnIdEnabled(id)) {
            //return Phone.APN_ALREADY_ACTIVE;
        //} else {
            //setEnabled(id, true);
        //}
        //return Phone.APN_REQUEST_STARTED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.569 -0400", hash_original_method = "A5E4EE0A9C6812357B5B6B8F3C042D82", hash_generated_method = "1538B9F65434005614338F65B6A98444")
    public synchronized int disableApnType(String type) {
        addTaint(type.getTaint());
    if(DBG)        
        log("disableApnType(" + type + ")");
        int id = apnTypeToId(type);
    if(id == APN_INVALID_ID)        
        {
            int var828862E346BB9F0775660355A8FF69D9_123959553 = (Phone.APN_REQUEST_FAILED);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1714096958 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1714096958;
        } //End block
    if(isApnIdEnabled(id))        
        {
            setEnabled(id, false);
    if(isApnTypeActive(Phone.APN_TYPE_DEFAULT))            
            {
    if(dataEnabled[APN_DEFAULT_ID])                
                {
                    int var10EDC12F6E39EB6E652C0E451BD3FCA6_41574625 = (Phone.APN_ALREADY_ACTIVE);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1162767324 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1162767324;
                } //End block
                else
                {
                    int var294B3FA049569E2B8E6FC7D927E71152_341809905 = (Phone.APN_REQUEST_STARTED);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1490011116 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1490011116;
                } //End block
            } //End block
            else
            {
                int var294B3FA049569E2B8E6FC7D927E71152_1942458342 = (Phone.APN_REQUEST_STARTED);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_161112125 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_161112125;
            } //End block
        } //End block
        else
        {
            int var828862E346BB9F0775660355A8FF69D9_518979970 = (Phone.APN_REQUEST_FAILED);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1407185104 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1407185104;
        } //End block
        // ---------- Original Method ----------
        //if (DBG) log("disableApnType(" + type + ")");
        //int id = apnTypeToId(type);
        //if (id == APN_INVALID_ID) {
            //return Phone.APN_REQUEST_FAILED;
        //}
        //if (isApnIdEnabled(id)) {
            //setEnabled(id, false);
            //if (isApnTypeActive(Phone.APN_TYPE_DEFAULT)) {
                //if (dataEnabled[APN_DEFAULT_ID]) {
                    //return Phone.APN_ALREADY_ACTIVE;
                //} else {
                    //return Phone.APN_REQUEST_STARTED;
                //}
            //} else {
                //return Phone.APN_REQUEST_STARTED;
            //}
        //} else {
            //return Phone.APN_REQUEST_FAILED;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.596 -0400", hash_original_method = "25F13BA52E496C8972985CBEE5B69F23", hash_generated_method = "E22675C9A267CF554372F5A9F137F6B5")
    protected void setEnabled(int id, boolean enable) {
        addTaint(enable);
        addTaint(id);
    if(DBG)        
        {
            log("setEnabled(" + id + ", " + enable + ") with old state = " + dataEnabled[id]
                    + " and enabledCount = " + enabledCount);
        } //End block
        Message msg = obtainMessage(EVENT_ENABLE_NEW_APN);
        msg.arg1 = id;
        msg.arg2 = (enable ? ENABLED : DISABLED);
        sendMessage(msg);
        // ---------- Original Method ----------
        //if (DBG) {
            //log("setEnabled(" + id + ", " + enable + ") with old state = " + dataEnabled[id]
                    //+ " and enabledCount = " + enabledCount);
        //}
        //Message msg = obtainMessage(EVENT_ENABLE_NEW_APN);
        //msg.arg1 = id;
        //msg.arg2 = (enable ? ENABLED : DISABLED);
        //sendMessage(msg);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.598 -0400", hash_original_method = "6346C217AE811F98B5143DCE05848411", hash_generated_method = "4267FD85DCE15342EEDB209B8F62FA93")
    protected void onEnableApn(int apnId, int enabled) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(enabled);
    if(DBG)        
        {
            log("EVENT_APN_ENABLE_REQUEST apnId=" + apnId + ", apnType=" + apnIdToType(apnId) +
                    ", enabled=" + enabled + ", dataEnabled = " + dataEnabled[apnId] +
                    ", enabledCount = " + enabledCount + ", isApnTypeActive = " +
                    isApnTypeActive(apnIdToType(apnId)));
        } //End block
    if(enabled == ENABLED)        
        {
            synchronized
(this)            {
    if(!dataEnabled[apnId])                
                {
                    dataEnabled[apnId] = true;
                    enabledCount++;
                } //End block
            } //End block
            String type = apnIdToType(apnId);
    if(!isApnTypeActive(type))            
            {
                mRequestedApnType = type;
                onEnableNewApn();
            } //End block
            else
            {
                notifyApnIdUpToCurrent(Phone.REASON_APN_SWITCHED, apnId);
            } //End block
        } //End block
        else
        {
            boolean didDisable = false;
            synchronized
(this)            {
    if(dataEnabled[apnId])                
                {
                    dataEnabled[apnId] = false;
                    enabledCount--;
                    didDisable = true;
                } //End block
            } //End block
    if(didDisable && enabledCount == 0)            
            {
                onCleanUpConnection(true, apnId, Phone.REASON_DATA_DISABLED);
                notifyApnIdDisconnected(Phone.REASON_DATA_DISABLED, apnId);
    if(dataEnabled[APN_DEFAULT_ID] == true
                        && !isApnTypeActive(Phone.APN_TYPE_DEFAULT))                
                {
                    mRequestedApnType = Phone.APN_TYPE_DEFAULT;
                    onEnableNewApn();
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.599 -0400", hash_original_method = "FBAA4A80E4538BA497646C5AED60D911", hash_generated_method = "32D68D2D8870859115DE7BFCF2679FE7")
    protected void onEnableNewApn() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.599 -0400", hash_original_method = "58B3A2A4D2FF1B49B3A412CB94198F76", hash_generated_method = "E6EC58C6EC60B9666E36DB356C185DC3")
    protected void onResetDone(AsyncResult ar) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(ar.getTaint());
    if(DBG)        
        log("EVENT_RESET_DONE");
        String reason = null;
    if(ar.userObj instanceof String)        
        {
            reason = (String) ar.userObj;
        } //End block
        gotoIdleAndNotifyDataConnection(reason);
        // ---------- Original Method ----------
        //if (DBG) log("EVENT_RESET_DONE");
        //String reason = null;
        //if (ar.userObj instanceof String) {
            //reason = (String) ar.userObj;
        //}
        //gotoIdleAndNotifyDataConnection(reason);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.600 -0400", hash_original_method = "DE9C8D1FA305A86440711210D5CC0DFB", hash_generated_method = "B29CB03C397E3E2DBF258F7B37FE5AD6")
    public boolean setInternalDataEnabled(boolean enable) {
        addTaint(enable);
    if(DBG)        
        log("setInternalDataEnabled(" + enable + ")");
        Message msg = obtainMessage(EVENT_SET_INTERNAL_DATA_ENABLE);
        msg.arg1 = (enable ? ENABLED : DISABLED);
        sendMessage(msg);
        boolean varB326B5062B2F0E69046810717534CB09_1592709051 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_707068699 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_707068699;
        // ---------- Original Method ----------
        //if (DBG)
            //log("setInternalDataEnabled(" + enable + ")");
        //Message msg = obtainMessage(EVENT_SET_INTERNAL_DATA_ENABLE);
        //msg.arg1 = (enable ? ENABLED : DISABLED);
        //sendMessage(msg);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.600 -0400", hash_original_method = "2FFC27FC9820E2F3BAEE3098A222A5B3", hash_generated_method = "8389D32AB3367256CB0EACC5C34069CE")
    protected void onSetInternalDataEnabled(boolean enabled) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        synchronized
(mDataEnabledLock)        {
            mInternalDataEnabled = enabled;
    if(enabled)            
            {
                log("onSetInternalDataEnabled: changed to enabled, try to setup data call");
                resetAllRetryCounts();
                onTrySetupData(Phone.REASON_DATA_ENABLED);
            } //End block
            else
            {
                log("onSetInternalDataEnabled: changed to disabled, cleanUpAllConnections");
                cleanUpAllConnections(null);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (mDataEnabledLock) {
            //mInternalDataEnabled = enabled;
            //if (enabled) {
                //log("onSetInternalDataEnabled: changed to enabled, try to setup data call");
                //resetAllRetryCounts();
                //onTrySetupData(Phone.REASON_DATA_ENABLED);
            //} else {
                //log("onSetInternalDataEnabled: changed to disabled, cleanUpAllConnections");
                //cleanUpAllConnections(null);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.601 -0400", hash_original_method = "68E67092B4266000A5BC48E8C37B6ED2", hash_generated_method = "0A3324C6D85C80C4EA96ED03B5A504A6")
    public void cleanUpAllConnections(String cause) {
        addTaint(cause.getTaint());
        Message msg = obtainMessage(EVENT_CLEAN_UP_ALL_CONNECTIONS);
        msg.obj = cause;
        sendMessage(msg);
        // ---------- Original Method ----------
        //Message msg = obtainMessage(EVENT_CLEAN_UP_ALL_CONNECTIONS);
        //msg.obj = cause;
        //sendMessage(msg);
    }

    
    public abstract boolean isDisconnected();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.601 -0400", hash_original_method = "49C3C07E31C3EAA572D4F39FF0B691FA", hash_generated_method = "505924A69099BEEA2D31792EF160FD02")
    protected void onSetUserDataEnabled(boolean enabled) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        synchronized
(mDataEnabledLock)        {
            final boolean prevEnabled = getAnyDataEnabled();
    if(mUserDataEnabled != enabled)            
            {
                mUserDataEnabled = enabled;
                Settings.Secure.putInt(mPhone.getContext().getContentResolver(),
                        Settings.Secure.MOBILE_DATA, enabled ? 1 : 0);
    if(prevEnabled != getAnyDataEnabled())                
                {
    if(!prevEnabled)                    
                    {
                        resetAllRetryCounts();
                        onTrySetupData(Phone.REASON_DATA_ENABLED);
                    } //End block
                    else
                    {
                        onCleanUpAllConnections(Phone.REASON_DATA_DISABLED);
                    } //End block
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (mDataEnabledLock) {
            //final boolean prevEnabled = getAnyDataEnabled();
            //if (mUserDataEnabled != enabled) {
                //mUserDataEnabled = enabled;
                //Settings.Secure.putInt(mPhone.getContext().getContentResolver(),
                        //Settings.Secure.MOBILE_DATA, enabled ? 1 : 0);
                //if (prevEnabled != getAnyDataEnabled()) {
                    //if (!prevEnabled) {
                        //resetAllRetryCounts();
                        //onTrySetupData(Phone.REASON_DATA_ENABLED);
                    //} else {
                        //onCleanUpAllConnections(Phone.REASON_DATA_DISABLED);
                    //}
                //}
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.602 -0400", hash_original_method = "CE2949FE6361D634BBA79ED70CC5EAE2", hash_generated_method = "6C55747F0D53D60AFFB55AB705104FF9")
    protected void onSetDependencyMet(String apnType, boolean met) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(met);
        addTaint(apnType.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.603 -0400", hash_original_method = "5C2A966CAC36731C633B25393BAF4799", hash_generated_method = "9174B3E20DABA3A4EF849DBD02D247D5")
    protected void onSetPolicyDataEnabled(boolean enabled) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(enabled);
        synchronized
(mDataEnabledLock)        {
            final boolean prevEnabled = getAnyDataEnabled();
    if(sPolicyDataEnabled != enabled)            
            {
                sPolicyDataEnabled = enabled;
    if(prevEnabled != getAnyDataEnabled())                
                {
    if(!prevEnabled)                    
                    {
                        resetAllRetryCounts();
                        onTrySetupData(Phone.REASON_DATA_ENABLED);
                    } //End block
                    else
                    {
                        onCleanUpAllConnections(Phone.REASON_DATA_DISABLED);
                    } //End block
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (mDataEnabledLock) {
            //final boolean prevEnabled = getAnyDataEnabled();
            //if (sPolicyDataEnabled != enabled) {
                //sPolicyDataEnabled = enabled;
                //if (prevEnabled != getAnyDataEnabled()) {
                    //if (!prevEnabled) {
                        //resetAllRetryCounts();
                        //onTrySetupData(Phone.REASON_DATA_ENABLED);
                    //} else {
                        //onCleanUpAllConnections(Phone.REASON_DATA_DISABLED);
                    //}
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.623 -0400", hash_original_method = "E5EFA23236CE13ACC69B88C6F16F1B0C", hash_generated_method = "0822C9C0AD724C899A371C326A57E928")
    protected String getReryConfig(boolean forDefault) {
        addTaint(forDefault);
        int rt = mPhone.getServiceState().getRadioTechnology();
    if((rt == ServiceState.RADIO_TECHNOLOGY_IS95A) ||
            (rt == ServiceState.RADIO_TECHNOLOGY_IS95B) ||
            (rt == ServiceState.RADIO_TECHNOLOGY_1xRTT) ||
            (rt == ServiceState.RADIO_TECHNOLOGY_EVDO_0) ||
            (rt == ServiceState.RADIO_TECHNOLOGY_EVDO_A) ||
            (rt == ServiceState.RADIO_TECHNOLOGY_EVDO_B) ||
            (rt == ServiceState.RADIO_TECHNOLOGY_EHRPD))        
        {
String var0BE7A29642DA8F2FC3FE2D231FB8BF55_1511902745 =             SystemProperties.get("ro.cdma.data_retry_config");
            var0BE7A29642DA8F2FC3FE2D231FB8BF55_1511902745.addTaint(taint);
            return var0BE7A29642DA8F2FC3FE2D231FB8BF55_1511902745;
        } //End block
        else
        {
    if(forDefault)            
            {
String var39539715CE39E6F3FDE7ED579648DCAE_2135123791 =                 SystemProperties.get("ro.gsm.data_retry_config");
                var39539715CE39E6F3FDE7ED579648DCAE_2135123791.addTaint(taint);
                return var39539715CE39E6F3FDE7ED579648DCAE_2135123791;
            } //End block
            else
            {
String varA03DF2F95743D93E0748CDC768C7380D_1484173846 =                 SystemProperties.get("ro.gsm.2nd_data_retry_config");
                varA03DF2F95743D93E0748CDC768C7380D_1484173846.addTaint(taint);
                return varA03DF2F95743D93E0748CDC768C7380D_1484173846;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.623 -0400", hash_original_method = "0FD4DA1D85F6AEE253925BB7FDB228BD", hash_generated_method = "28581C5F2A08F6E07E7ED9A6FC664448")
    protected void resetAllRetryCounts() {
for(DataConnection dc : mDataConnections.values())
        {
            dc.resetRetryCount();
        } //End block
        // ---------- Original Method ----------
        //for (DataConnection dc : mDataConnections.values()) {
            //dc.resetRetryCount();
        //}
    }

    
    public enum State {
        IDLE,
        INITING,
        CONNECTING,
        SCANNING,
        CONNECTED,
        DISCONNECTING,
        FAILED
    }

    
    public enum Activity {
        NONE,
        DATAIN,
        DATAOUT,
        DATAINANDOUT,
        DORMANT
    }

    
    private class DataRoamingSettingObserver extends ContentObserver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.623 -0400", hash_original_method = "BA61ACB3318576C64C09DAC113E0795F", hash_generated_method = "FA57034BBBA5D59687B99DF037194C62")
        public  DataRoamingSettingObserver(Handler handler) {
            super(handler);
            addTaint(handler.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.624 -0400", hash_original_method = "B90ABFF6DE01DDCB354DDF92EE51905A", hash_generated_method = "1C21FA85C6974962982A1772430BCFAA")
        public void register(Context context) {
            addTaint(context.getTaint());
            final ContentResolver resolver = context.getContentResolver();
            resolver.registerContentObserver(
                    Settings.Secure.getUriFor(Settings.Secure.DATA_ROAMING), false, this);
            // ---------- Original Method ----------
            //final ContentResolver resolver = context.getContentResolver();
            //resolver.registerContentObserver(
                    //Settings.Secure.getUriFor(Settings.Secure.DATA_ROAMING), false, this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.624 -0400", hash_original_method = "A96EEB9B30A252CB5EDDDA8B92E0867E", hash_generated_method = "7AE5888FF7232265FDBCF03AE0B6D506")
        public void unregister(Context context) {
            addTaint(context.getTaint());
            final ContentResolver resolver = context.getContentResolver();
            resolver.unregisterContentObserver(this);
            // ---------- Original Method ----------
            //final ContentResolver resolver = context.getContentResolver();
            //resolver.unregisterContentObserver(this);
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.624 -0400", hash_original_method = "169C7D81EE3F2154C9E94D652CC4F700", hash_generated_method = "F220FA53DE08D00ACFA4F090899C9734")
        @Override
        public void onChange(boolean selfChange) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(selfChange);
            handleDataOnRoamingChange();
            // ---------- Original Method ----------
            //handleDataOnRoamingChange();
        }

        
    }


    
    public class TxRxSum {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.624 -0400", hash_original_field = "9A029104A537A9F6518DBC5E97BCA4CB", hash_generated_field = "31EBFEDBE9880286CAB65EBD7356F689")

        public long txPkts;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.624 -0400", hash_original_field = "41F45C1353F236210B54784C5F09E899", hash_generated_field = "FFD759E6497E1FB8FF7E9F7E8C351B73")

        public long rxPkts;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.624 -0400", hash_original_method = "A9FFC39802399C2580CE69B9ED52FB70", hash_generated_method = "3480E04706A82CC0FC15FF716763F24D")
        public  TxRxSum() {
            reset();
            // ---------- Original Method ----------
            //reset();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.624 -0400", hash_original_method = "CBCCCAC9E5E65AD1C4A36F84309761F3", hash_generated_method = "5084D0A66E4E15FA652E0C50C229F7A5")
        public  TxRxSum(long txPkts, long rxPkts) {
            this.txPkts = txPkts;
            this.rxPkts = rxPkts;
            // ---------- Original Method ----------
            //this.txPkts = txPkts;
            //this.rxPkts = rxPkts;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.624 -0400", hash_original_method = "AD3F4A8C32B5AB82EFF11F34262CA97C", hash_generated_method = "392DAA30EB30056E5D0A513FEBC5B1E8")
        public  TxRxSum(TxRxSum sum) {
            txPkts = sum.txPkts;
            rxPkts = sum.rxPkts;
            // ---------- Original Method ----------
            //txPkts = sum.txPkts;
            //rxPkts = sum.rxPkts;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.624 -0400", hash_original_method = "AC7E7693FF46B721A881337A05B09C85", hash_generated_method = "8B79F23D5DA55C534A1AF5C4055F1390")
        public void reset() {
            txPkts = -1;
            rxPkts = -1;
            // ---------- Original Method ----------
            //txPkts = -1;
            //rxPkts = -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.625 -0400", hash_original_method = "1CA3D86B2E80A8520E2DD65A646FFF96", hash_generated_method = "424845EC92644FBA88C38A132D5FD8B4")
        public String toString() {
String varF722513CD0224E005F9F0239B7D742A2_1174723447 =             "{txSum=" + txPkts + " rxSum=" + rxPkts + "}";
            varF722513CD0224E005F9F0239B7D742A2_1174723447.addTaint(taint);
            return varF722513CD0224E005F9F0239B7D742A2_1174723447;
            // ---------- Original Method ----------
            //return "{txSum=" + txPkts + " rxSum=" + rxPkts + "}";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.625 -0400", hash_original_method = "4A3A2BC6E4110C10924DC1B1F4DD1644", hash_generated_method = "6FE875392CC69D76E7E6A49694F2EE7A")
        public void updateTxRxSum() {
            boolean txUpdated = false;
            boolean rxUpdated = false;
            long txSum = 0;
            long rxSum = 0;
for(ApnContext apnContext : mApnContexts.values())
            {
    if(apnContext.getState() == State.CONNECTED)                
                {
                    DataConnectionAc dcac = apnContext.getDataConnectionAc();
    if(dcac == null)                    
                    continue;
                    LinkProperties linkProp = dcac.getLinkPropertiesSync();
    if(linkProp == null)                    
                    continue;
                    String iface = linkProp.getInterfaceName();
    if(iface != null)                    
                    {
                        long stats = TrafficStats.getTxPackets(iface);
    if(stats > 0)                        
                        {
                            txUpdated = true;
                            txSum += stats;
                        } //End block
                        stats = TrafficStats.getRxPackets(iface);
    if(stats > 0)                        
                        {
                            rxUpdated = true;
                            rxSum += stats;
                        } //End block
                    } //End block
                } //End block
            } //End block
    if(txUpdated)            
            this.txPkts = txSum;
    if(rxUpdated)            
            this.rxPkts = rxSum;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.625 -0400", hash_original_field = "A4622F7F72162611C8E075EE443BC26E", hash_generated_field = "5F5E7D64B04175B8FA820B2440F700FC")

    protected static final boolean DBG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.625 -0400", hash_original_field = "F731EB70B21910E383F52051C1671657", hash_generated_field = "9627AE94D7940D7E187DD2B77A194FB7")

    protected static final boolean VDBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.625 -0400", hash_original_field = "7BDA6D1A9141EE0AD7FF9598A1FEB6A4", hash_generated_field = "33A74D16876315708A9BD8BD04E30FC7")

    public static String ACTION_DATA_CONNECTION_TRACKER_MESSENGER = "com.android.internal.telephony";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.625 -0400", hash_original_field = "51DF027D281586560FC115C63DD6DEF7", hash_generated_field = "26F3AF3552BC4649D0937B13E6BC7CF8")

    public static String EXTRA_MESSENGER = "EXTRA_MESSENGER";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.625 -0400", hash_original_field = "5965E06AE63626458452FCAD583F5AA9", hash_generated_field = "578AE35EE98E3DDD5EEAF2CBED5ACB45")

    protected static final int BASE = Protocol.BASE_DATA_CONNECTION_TRACKER;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.625 -0400", hash_original_field = "ECA626187861A2CCB3096D5073C18D44", hash_generated_field = "57E86604562BA2CD352710B284D46B74")

    protected static final int EVENT_DATA_SETUP_COMPLETE = BASE + 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.625 -0400", hash_original_field = "33F24341EE51BCC25663714C2A8AC519", hash_generated_field = "918C2E0C3F0B773EB57002039E5ADDF8")

    protected static final int EVENT_RADIO_AVAILABLE = BASE + 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.625 -0400", hash_original_field = "46DEF412949D3D229F0F086981FB575D", hash_generated_field = "9B5C18CFAB1EB82B998D3AC095B58265")

    protected static final int EVENT_RECORDS_LOADED = BASE + 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.625 -0400", hash_original_field = "426A2E540BFDB2E53205370AC68A088D", hash_generated_field = "A0525720B88653F55BA065E6AA892DC1")

    protected static final int EVENT_TRY_SETUP_DATA = BASE + 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.625 -0400", hash_original_field = "68D0D3D09B29128339F18635AD1150DC", hash_generated_field = "F6570C1A0821C4AB0BE35C147D368628")

    protected static final int EVENT_DATA_STATE_CHANGED = BASE + 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.625 -0400", hash_original_field = "F2CC829E98056690ECDD89CEA8DF771B", hash_generated_field = "FBFDC491608A17124A17D3452F208088")

    protected static final int EVENT_POLL_PDP = BASE + 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.625 -0400", hash_original_field = "B1989873DB7387EF71BE1A11DDA31D66", hash_generated_field = "27116C6686CAE7B4E6DC721A8CBA4151")

    protected static final int EVENT_RADIO_OFF_OR_NOT_AVAILABLE = BASE + 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.625 -0400", hash_original_field = "AE7C2E85ED91FEA82BE6ADA84456A79C", hash_generated_field = "7961EC29589D615AB66085BBDDF16352")

    protected static final int EVENT_VOICE_CALL_STARTED = BASE + 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.625 -0400", hash_original_field = "F68B4A87FAF27CD2F0289E80AFDCEB4A", hash_generated_field = "4E3DEF92CAD4F30419EB5EB31D45E012")

    protected static final int EVENT_VOICE_CALL_ENDED = BASE + 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.625 -0400", hash_original_field = "C0466AD2885B3AE52B71D60533BB007B", hash_generated_field = "EA6E60EE7ECE546BDE71D93811BB9270")

    protected static final int EVENT_DATA_CONNECTION_DETACHED = BASE + 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.625 -0400", hash_original_field = "0B97AAAEBA1C3D8083CF0885170E6D51", hash_generated_field = "D603A46CFC57F5E3579D3275D14987B9")

    protected static final int EVENT_LINK_STATE_CHANGED = BASE + 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.626 -0400", hash_original_field = "40AD81D1830810A9C166ED3D184C9304", hash_generated_field = "37C4B29B403735591BA4637FD7F07300")

    protected static final int EVENT_ROAMING_ON = BASE + 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.626 -0400", hash_original_field = "5AD3E60C000936BC36EAE24FC4D6BFF6", hash_generated_field = "AC2E0D687697D630951043F63F8B55EF")

    protected static final int EVENT_ROAMING_OFF = BASE + 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.626 -0400", hash_original_field = "055D12EA48C72D2C9AE5C7F7406DD106", hash_generated_field = "56ED200F83206D8C2B8AEEC777D92808")

    protected static final int EVENT_ENABLE_NEW_APN = BASE + 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.626 -0400", hash_original_field = "510504022D446F08C64C402076675CB3", hash_generated_field = "699A01D28FE3B5BA2F9DBE2E14C16720")

    protected static final int EVENT_RESTORE_DEFAULT_APN = BASE + 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.626 -0400", hash_original_field = "326890052C84F103A1868FD54E3F3A66", hash_generated_field = "8CB78322EFEEA6081C6B4812D06CDE2F")

    protected static final int EVENT_DISCONNECT_DONE = BASE + 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.626 -0400", hash_original_field = "B7E3A0839C0FE078993E272A934BB5A7", hash_generated_field = "706DAFBB316C33FB3681D6E45AF16EC5")

    protected static final int EVENT_DATA_CONNECTION_ATTACHED = BASE + 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.626 -0400", hash_original_field = "D7C0AC990309F4BF30F63B057CC45F91", hash_generated_field = "524270489D97E868640177C02C87FAEF")

    protected static final int EVENT_DATA_STALL_ALARM = BASE + 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.626 -0400", hash_original_field = "AA99799D44889D88952331EB4BBA81A5", hash_generated_field = "E6A154D47B9FDA448EB2D6ECA54E9044")

    protected static final int EVENT_DO_RECOVERY = BASE + 18;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.626 -0400", hash_original_field = "A2B9E56589E0A1808D25BF81D2820D8F", hash_generated_field = "C64987752373EDCE104AC55BCE584A2E")

    protected static final int EVENT_APN_CHANGED = BASE + 19;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.626 -0400", hash_original_field = "4DFAB0760A0FF0BC17DF1FA9AFE7EB93", hash_generated_field = "732BEB3FAC1202A7DAB02A4D73A7407D")

    protected static final int EVENT_CDMA_DATA_DETACHED = BASE + 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.626 -0400", hash_original_field = "7B446BE5FF12DCEE083E090357AE8D56", hash_generated_field = "8909A780334573F8F694B9A1EBC29A1A")

    protected static final int EVENT_NV_READY = BASE + 21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.626 -0400", hash_original_field = "E6FDE084A4225A1557CE43DF696C02FE", hash_generated_field = "2D0CA6675E7E5DF0AC5D6499149EBCAB")

    protected static final int EVENT_PS_RESTRICT_ENABLED = BASE + 22;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.626 -0400", hash_original_field = "37AFD73B25951F6E1E8C8F9F4991E0E5", hash_generated_field = "E117070A96CD4C5C470336E4EE845528")

    protected static final int EVENT_PS_RESTRICT_DISABLED = BASE + 23;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.626 -0400", hash_original_field = "34C5609EBA200D1855670B4451302323", hash_generated_field = "AD86F18DB896FF32B9ABB648D3BE3614")

    public static final int EVENT_CLEAN_UP_CONNECTION = BASE + 24;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.626 -0400", hash_original_field = "CF37FF76A274159E6384837A9F7F486F", hash_generated_field = "9FC0CEF9DBBD9CDD60A47E3B572DEE11")

    protected static final int EVENT_CDMA_OTA_PROVISION = BASE + 25;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.626 -0400", hash_original_field = "BF7AF52C7FDD44135813BD775C753027", hash_generated_field = "2E113365E66D355FEDAB98A7D37D81A7")

    protected static final int EVENT_RESTART_RADIO = BASE + 26;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.626 -0400", hash_original_field = "DCE289D9C00CC3F12901135A087230E7", hash_generated_field = "EBD7235096B041C0C308DD944A3704E2")

    protected static final int EVENT_SET_INTERNAL_DATA_ENABLE = BASE + 27;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.626 -0400", hash_original_field = "AEE40AA06967C6AA4E971FA645018541", hash_generated_field = "5034595773C1BED896C3513B3B07EC9E")

    protected static final int EVENT_RESET_DONE = BASE + 28;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.626 -0400", hash_original_field = "61715180A570527CA45BE873F1A8B16F", hash_generated_field = "F77450C54EDD06E9C95E2653ED0EECF1")

    public static final int CMD_SET_USER_DATA_ENABLE = BASE + 29;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.626 -0400", hash_original_field = "BF8CD25798DFB7D44A922B1D22D07FD8", hash_generated_field = "B4E9A3F75E31EBF0819A14E7CE2FE65B")

    public static final int EVENT_CLEAN_UP_ALL_CONNECTIONS = BASE + 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.626 -0400", hash_original_field = "DBD783B09580CAD21B9BA70443B9B2B3", hash_generated_field = "D8C9AD1D6E5CBD85074BECAA38E31518")

    public static final int CMD_SET_DEPENDENCY_MET = BASE + 31;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.626 -0400", hash_original_field = "44F851B2D4C8232521C6B3BA1F442BD3", hash_generated_field = "3254C5957AFFF539FD79B974BB823F2E")

    public static final int CMD_SET_POLICY_DATA_ENABLE = BASE + 32;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.626 -0400", hash_original_field = "124CDEAD86429F817C00334490AF589A", hash_generated_field = "07F46E413C8B3F3559740A56D5842AD9")

    protected static final int APN_INVALID_ID = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.626 -0400", hash_original_field = "2B9BF7683605EAF175DA931B2453C34B", hash_generated_field = "0E77FDDEFB918A35BF053E79F738F079")

    protected static final int APN_DEFAULT_ID = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.626 -0400", hash_original_field = "F77BC24DF2981C4E95B36455ACB6486B", hash_generated_field = "3ADA7B63B367F670A9CD841236C2E69E")

    protected static final int APN_MMS_ID = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.626 -0400", hash_original_field = "3C9787C2DBFA045A02AB792A7D75AA5C", hash_generated_field = "52A680E6667112D0AD515B82C22E851A")

    protected static final int APN_SUPL_ID = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.626 -0400", hash_original_field = "8F0F2C37C7D84C099DD0B43F9FDCDFA3", hash_generated_field = "E098D6D391DC0AB0F915C3106B1695EE")

    protected static final int APN_DUN_ID = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.626 -0400", hash_original_field = "EB9E39BC107DAD1D743877FB20DCCCB8", hash_generated_field = "4EFC758C61F82DD345E0F30EFFBD676B")

    protected static final int APN_HIPRI_ID = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.626 -0400", hash_original_field = "12545285308557BFDAA8F96E516DDDE8", hash_generated_field = "A8AD07F881EB2DE54A81F6EF15DCAC2C")

    protected static final int APN_IMS_ID = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.626 -0400", hash_original_field = "B615EAB39E5F698FB19CEAF230D05419", hash_generated_field = "E8CEDAD872DD75AEF65EC837AB693137")

    protected static final int APN_FOTA_ID = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.627 -0400", hash_original_field = "69D4E9CA7F2362365E1DD82BCE01D5CD", hash_generated_field = "2B316B7447F9D669311A7A19EECFEA03")

    protected static final int APN_CBS_ID = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.627 -0400", hash_original_field = "AFC301CA9725EEF2D73B132667D7CF53", hash_generated_field = "964D3223C076E2C626C417466FDE0286")

    protected static final int APN_NUM_TYPES = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.627 -0400", hash_original_field = "E2CB925518CBBA02A412E4B68A43574E", hash_generated_field = "6F8C6ECFCCFDEEF8A111FB82FE45C371")

    public static final int DISABLED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.627 -0400", hash_original_field = "C25C0B236353087BD3025AC89A8C2385", hash_generated_field = "BBC106514DA50C961AB6371075708621")

    public static final int ENABLED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.627 -0400", hash_original_field = "F0FBA210FC19B517AD8DC129D7808481", hash_generated_field = "26D79596132C0495F601BE108CF49667")

    public static final String APN_TYPE_KEY = "apnType";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.627 -0400", hash_original_field = "739925A0F14EBFF741BB1F5884FF3580", hash_generated_field = "A249C37DD807D068C9799A3714E5C4B5")

    protected static final int APN_DELAY_MILLIS = SystemProperties.getInt("persist.radio.apn_delay", 5000);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.627 -0400", hash_original_field = "84BA753F9948A72584248DEA838B164E", hash_generated_field = "F1D5EAD411587599450F20AD6F0FCBFE")

    protected static boolean sPolicyDataEnabled = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.627 -0400", hash_original_field = "B25FE785B7CAF85E1007146F56D5AB24", hash_generated_field = "C8ABD15820F1BC36B2FC6FA2C5BBD57E")

    protected static final String DEFAULT_DATA_RETRY_CONFIG = "default_randomization=2000,"
        + "5000,10000,20000,40000,80000:5000,160000:5000,"
        + "320000:5000,640000:5000,1280000:5000,1800000:5000";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.627 -0400", hash_original_field = "DA3393F07AFE29A2E329689063E5B928", hash_generated_field = "93ECBE2CB5D3FA004037332587C4234E")

    protected static final String SECONDARY_DATA_RETRY_CONFIG = "max_retries=3, 5000, 5000, 5000";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.627 -0400", hash_original_field = "197214CA0C06EEB1EFD2EBEBA3CD4DA9", hash_generated_field = "3E24F8F476066918BB2F3B6D1406C0E2")

    protected static final int POLL_NETSTAT_SLOW_MILLIS = 5000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.627 -0400", hash_original_field = "AC32FF0F60419A93C046914FEEBAEA54", hash_generated_field = "1A0EC6E0BA46F24B4A2694596B6E436D")

    protected static final int DEFAULT_MAX_PDP_RESET_FAIL = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.627 -0400", hash_original_field = "21CD8419E3F89579DF90527399533BBC", hash_generated_field = "1FE39315059532779489F940B44B4D66")

    protected static final int NO_RECV_POLL_LIMIT = 24;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.627 -0400", hash_original_field = "382BAE9382F719FBCBB1A10D4BEFA72B", hash_generated_field = "0D9BF9729BE1A27BBD1BF62B3384AB80")

    protected static final int POLL_NETSTAT_MILLIS = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.627 -0400", hash_original_field = "923194288220D08DFF21E434BF1AEEEB", hash_generated_field = "D7453C2438D87CC283C407D0E80A8104")

    protected static final int POLL_NETSTAT_SCREEN_OFF_MILLIS = 1000*60*10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.627 -0400", hash_original_field = "D47AA84872A25D01DB68E62C67D0D911", hash_generated_field = "142733920ADC648E7F33CA58E902D9A6")

    protected static final int POLL_LONGEST_RTT = 120 * 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.627 -0400", hash_original_field = "1C3134829F1666190770E94993F178AE", hash_generated_field = "71AF96CD56F561EBA0B98AD3621CFF6F")

    protected static final int NUMBER_SENT_PACKETS_OF_HANG = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.627 -0400", hash_original_field = "29091498798DC27B881A4E06C3D0FEDD", hash_generated_field = "AC35FDCED05C1F4EE3D61BE8C1BC35EC")

    protected static final int RESTORE_DEFAULT_APN_DELAY = 1 * 60 * 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.627 -0400", hash_original_field = "58557858B2FE6F52EF658629982D3750", hash_generated_field = "2B8A79ACDC0B6FBDAD775768D652C83F")

    protected static final String APN_RESTORE_DELAY_PROP_NAME = "android.telephony.apn-restore";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.627 -0400", hash_original_field = "9703C98FBA4E5997D49E93A25FA145F2", hash_generated_field = "13B653D205F77F7600F4F13DC999F8B9")

    protected static final String NULL_IP = "0.0.0.0";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.627 -0400", hash_original_field = "EBD539F8084726EF894804EB18CFB02A", hash_generated_field = "0411F8BF5642AECCB6A41EFE99C246EE")

    protected static final int DATA_STALL_ALARM_DELAY_IN_MS_DEFAULT = 1000 * 60 * 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.627 -0400", hash_original_field = "15B313C114C8CFFC8BD65B40ED360948", hash_generated_field = "A2AEF5834159105DB4F070F129F7D147")

    protected static final int DATA_STALL_NO_RECV_POLL_LIMIT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.628 -0400", hash_original_field = "12CBEA904965DFA02EF67746239C8476", hash_generated_field = "D4EDDFEB958C1B822CA1719D4CF16D54")

    protected static final String DATA_STALL_ALARM_TAG_EXTRA = "data.stall.alram.tag";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.628 -0400", hash_original_field = "FB709D7A9A230E69736935B6387971ED", hash_generated_field = "94DA01920C98565C8DA456DFEAE26138")

    protected static final String INTENT_RECONNECT_ALARM_EXTRA_REASON = "reason";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.628 -0400", hash_original_field = "9027635A00312F40B47DC9E66AC4B555", hash_generated_field = "8DDF5BA451DF59B3F1183C984E43D77E")

    protected static final String INTENT_SET_FAIL_DATA_SETUP_COUNTER = "com.android.internal.telephony.dataconnectiontracker.intent_set_fail_data_setup_counter";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.628 -0400", hash_original_field = "E820771C597A7FF6FD625C84D8A897CC", hash_generated_field = "3B5E09F30CCEFBA257FF0FFD68EEC79D")

    protected static final String FAIL_DATA_SETUP_COUNTER = "fail_data_setup_counter";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.628 -0400", hash_original_field = "736E3CF86860D80581301BC5DA74308A", hash_generated_field = "E2E42CE52C5DCFF5C5FC00CE54B6B5F4")

    protected static final String FAIL_DATA_SETUP_FAIL_CAUSE = "fail_data_setup_fail_cause";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.628 -0400", hash_original_field = "D56A0C911051F3FEC75B7F4166DA0A41", hash_generated_field = "1A4684138A98FC97EFDBFAB38A208838")

    protected static final String DEFALUT_DATA_ON_BOOT_PROP = "net.def_data_on_boot";
}

