package com.android.internal.telephony;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.970 -0400", hash_original_field = "0C574BF34249141BA4157A2B3A13DF65", hash_generated_field = "35FA5A91B80F269D1DB9B36DE1EC65CA")

    protected Object mDataEnabledLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.970 -0400", hash_original_field = "83C02F715D848B29A8DCE10BED0E6E91", hash_generated_field = "029ADD06C51569E156E858EF56AC06DA")

    protected boolean mInternalDataEnabled = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.970 -0400", hash_original_field = "C50C8B8054B63CB49F8E494BC522CCEB", hash_generated_field = "68DF71977C4718650ADDCD81C2B1620F")

    protected boolean mUserDataEnabled = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.970 -0400", hash_original_field = "8BC574D28C89B1AA9EB1F52525413A33", hash_generated_field = "F49B5B07667CCB529520831482D9BAB1")

    private boolean[] dataEnabled = new boolean[APN_NUM_TYPES];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.970 -0400", hash_original_field = "4F4BB97BAFF6649F5948F3AEF5C5E004", hash_generated_field = "8420FF89B70ED10465A38AC8B70D9095")

    private int enabledCount = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.970 -0400", hash_original_field = "37622627749352C73B065DAEF77331F4", hash_generated_field = "4C2B2DCF407C9F63C855A59D9F29A37A")

    protected String mRequestedApnType = Phone.APN_TYPE_DEFAULT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.970 -0400", hash_original_field = "0B51F170940EEB2AE623BBE06DE8E32A", hash_generated_field = "1894211C4C78CAACE34F0DC8EE3A13C1")

    protected int mFailDataSetupCounter = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.970 -0400", hash_original_field = "75AAA2EE794A2614791655B02867656E", hash_generated_field = "EC29A5CA55085C10657861453E10B11C")

    protected FailCause mFailDataSetupFailCause = FailCause.ERROR_UNSPECIFIED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.970 -0400", hash_original_field = "44BC87C3198CFC247427A5305FDEA9BE", hash_generated_field = "C5284483C4CF8ED630A2E2607ED30E12")

    protected PhoneBase mPhone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.970 -0400", hash_original_field = "0F5A83CC88F3EE71F4066661CD2FB5D3", hash_generated_field = "5CE7295912ACD2604E7762D907339691")

    protected Activity mActivity = Activity.NONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.970 -0400", hash_original_field = "6C72EA28B063EE31BBEAC312EBCF2483", hash_generated_field = "CEA309476306FEF09638ED5ED829D6A1")

    protected State mState = State.IDLE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.970 -0400", hash_original_field = "C2ECAD1B16A6AC316391B5BD3F156E8F", hash_generated_field = "963D8F7E00CCB73CD43AA6DA0AE9DF2A")

    protected Handler mDataConnectionTracker = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.970 -0400", hash_original_field = "F07A7E8D1AE67A08367F6C717D5DE438", hash_generated_field = "C066AA046467E6BBB3EA5DDB129B3DB8")

    protected long mTxPkts;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.970 -0400", hash_original_field = "BC09E4210C29FFF34666B06F6307B4F2", hash_generated_field = "F031B0AD358C38347F225F90F75B03E4")

    protected long mRxPkts;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.970 -0400", hash_original_field = "E88A6F081F6EB811DC49E055A2D799F6", hash_generated_field = "D9D10A2C69888D907D9D54771B7DB2A5")

    protected int mNetStatPollPeriod;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.970 -0400", hash_original_field = "E3C4C2B3F35259439146CD5411F92DE0", hash_generated_field = "8AEC394E7895B11DB0C1B86A5A82BE9C")

    protected boolean mNetStatPollEnabled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.970 -0400", hash_original_field = "BF6EEADB4389844D7AA67B505D20D752", hash_generated_field = "B4F64D56417D37A4C51A5C74706E778F")

    protected TxRxSum mDataStallTxRxSum = new TxRxSum(0, 0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.970 -0400", hash_original_field = "3FFBAEFC9FD53A580EC601AC99081F9B", hash_generated_field = "922642510706D7E1F40906A8E67562E6")

    protected int mDataStallAlarmTag = (int) SystemClock.elapsedRealtime();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.970 -0400", hash_original_field = "3121E27D2FFCAB719F984045B26119F7", hash_generated_field = "3964C7D016D96B23E8A4F338B71B706B")

    protected PendingIntent mDataStallAlarmIntent = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.970 -0400", hash_original_field = "C9FDF2A5D3CD3973F122C86C6FBD0B48", hash_generated_field = "6467835C9ADB216F54C7DD6564D528DC")

    protected long mSentSinceLastRecv;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.970 -0400", hash_original_field = "113DA8858F130CCEA1AB8790322771B7", hash_generated_field = "34A070F678DFA34A23ADEF39527A564C")

    protected int mNoRecvPollCount = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.970 -0400", hash_original_field = "BA2632DCA63DFE3E80BE54C563DA3B60", hash_generated_field = "9A8B10322BB7B36EE6E7CC8062CC1FBF")

    protected boolean mIsWifiConnected = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.970 -0400", hash_original_field = "F624BA341CEE490E0F6E6147BBEFD20A", hash_generated_field = "12A1D0ED5463C3F1D91D57D8EA6A8B7B")

    protected PendingIntent mReconnectIntent = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.970 -0400", hash_original_field = "5C56A171AFF86F8C7A0A13B02C0B482D", hash_generated_field = "D5A8886EAF52251545AC3AD33951BCDD")

    protected int mCidActive;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.970 -0400", hash_original_field = "3F9BEBDB99B792833728E81C043D71E1", hash_generated_field = "520BD7D1996D720DF52FDD45FFE94136")

    protected boolean mAutoAttachOnCreation = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.970 -0400", hash_original_field = "144B8708956D2D49F2FD05BBF954A65B", hash_generated_field = "443F358D0A339820F2F3C7798BC25ADF")

    protected boolean mIsScreenOn = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.970 -0400", hash_original_field = "7F27308BF5E86222C75F05C218C928BE", hash_generated_field = "E7C2C970E82ACEA7CAE10990548181FE")

    protected AtomicInteger mUniqueIdGenerator = new AtomicInteger(0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.970 -0400", hash_original_field = "D307CBBB85DCF557505B4275470BF6F6", hash_generated_field = "F773E5340FE87B52017BDABC34CF0248")

    protected HashMap<Integer, DataConnection> mDataConnections = new HashMap<Integer, DataConnection>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.970 -0400", hash_original_field = "79D26F63DD5553FA40470C897E398B22", hash_generated_field = "22F5DEEB14FFD2F3D69D57FCCF0F9FB1")

    protected HashMap<Integer, DataConnectionAc> mDataConnectionAsyncChannels = new HashMap<Integer, DataConnectionAc>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.970 -0400", hash_original_field = "FA6C20B1FC2F2FE98FB6A402065CE910", hash_generated_field = "E1D4371B7D81B0ADAB75212C0682A1E6")

    protected HashMap<String, Integer> mApnToDataConnectionId = new HashMap<String, Integer>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.970 -0400", hash_original_field = "62B502403C74E21713DD7847EA23B4D5", hash_generated_field = "941E5870BFAF3D02817684E802B4207E")

    protected ConcurrentHashMap<String, ApnContext> mApnContexts;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.970 -0400", hash_original_field = "42B5BBFF6E953F5C723EB47B2978873F", hash_generated_field = "910D7E883F89F3141D476B143EF29779")

    protected ApnSetting mActiveApn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.970 -0400", hash_original_field = "F85E1B64E5CC97E2E68B558F4155CBA1", hash_generated_field = "D877191FC5F094158A904672156AA8C5")

    protected ArrayList<ApnSetting> mAllApns = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.970 -0400", hash_original_field = "229AC432B91972CC26BCF8C8ECBB4E35", hash_generated_field = "FC9CCB9D49A758A95E153C604DAFC1C3")

    protected ApnSetting mPreferredApn = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.970 -0400", hash_original_field = "0A981A794DB3A35FBC09ABB9C5C9D0C0", hash_generated_field = "B458E88DEC049EDD2472BF239226E4CB")

    protected boolean mIsPsRestricted = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.970 -0400", hash_original_field = "A0FC4D1A501D52A82344B1933DD703BB", hash_generated_field = "0421A765569015D55BB5FDAB22E936EA")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.972 -0400", hash_original_field = "8BDD1549FE3A70CEB234E0690EAEE942", hash_generated_field = "6D8A2CC8A7E85CEA15EFEA2E663FA6FC")

    private DataRoamingSettingObserver mDataRoamingSettingObserver;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.973 -0400", hash_original_method = "3BD12FD7917DD1B6F1FA4984E09C99CB", hash_generated_method = "61081F5ABC9C657476329C63B2292D80")
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
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(mPhone.getContext());
        mAutoAttachOnCreation = sp.getBoolean(PhoneBase.DATA_DISABLED_ON_BOOT_KEY, false);
        mDataRoamingSettingObserver = new DataRoamingSettingObserver(mPhone);
        mDataRoamingSettingObserver.register(mPhone.getContext());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.973 -0400", hash_original_method = "C16C211E95AFFD72D353E5EF5692A650", hash_generated_method = "C3C11BF579342A81FEDEFEB0E20FCADE")
    protected boolean isDataSetupCompleteOk(AsyncResult ar) {
        {
            log("isDataSetupCompleteOk return false, ar.result=" + ar.result);
        } 
        {
            log("isDataSetupCompleteOk return true");
        } 
        ar.result = mFailDataSetupFailCause;
        {
            log("isDataSetupCompleteOk return false" +
                    " mFailDataSetupCounter=" + mFailDataSetupCounter +
                    " mFailDataSetupFailCause=" + mFailDataSetupFailCause);
        } 
        mFailDataSetupCounter -= 1;
        addTaint(ar.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1949927799 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1949927799;
        
        
            
            
        
        
            
            
        
        
        
            
                    
                    
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.974 -0400", hash_original_method = "838D9E0EFB087A153045FCBAD3FD613D", hash_generated_method = "420C74BA32C8BCCF992E6DC739618A6F")
    protected void onActionIntentReconnectAlarm(Intent intent) {
        
        String reason = intent.getStringExtra(INTENT_RECONNECT_ALARM_EXTRA_REASON);
        {
            Message msg = obtainMessage(EVENT_CLEAN_UP_CONNECTION);
            msg.arg1 = 0;
            msg.arg2 = 0;
            msg.obj = reason;
            sendMessage(msg);
        } 
        sendMessage(obtainMessage(EVENT_TRY_SETUP_DATA));
        addTaint(intent.getTaint());
        
        
        
            
            
            
            
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.975 -0400", hash_original_method = "A1F89C02319CA5D605879D459A1AC731", hash_generated_method = "3FEAEA4575AE79EF12AD9D0E66CF0B9A")
    protected void onActionIntentDataStallAlarm(Intent intent) {
        
        log("onActionIntentDataStallAlarm: action=" + intent.getAction());
        Message msg = obtainMessage(EVENT_DATA_STALL_ALARM, intent.getAction());
        msg.arg1 = intent.getIntExtra(DATA_STALL_ALARM_TAG_EXTRA, 0);
        sendMessage(msg);
        addTaint(intent.getTaint());
        
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.979 -0400", hash_original_method = "D3ED6AC13F3F749DE4F1E160957198B8", hash_generated_method = "5E7A78A9D7A3453BCAB22560EC73BC63")
    public void dispose() {
        {
            Iterator<DataConnectionAc> varEB8626173DB084FB4853115B28BD3F62_170445328 = (mDataConnectionAsyncChannels.values()).iterator();
            varEB8626173DB084FB4853115B28BD3F62_170445328.hasNext();
            DataConnectionAc dcac = varEB8626173DB084FB4853115B28BD3F62_170445328.next();
            {
                dcac.disconnect();
            } 
        } 
        mDataConnectionAsyncChannels.clear();
        mIsDisposed = true;
        mPhone.getContext().unregisterReceiver(this.mIntentReceiver);
        mDataRoamingSettingObserver.unregister(mPhone.getContext());
        
        
            
        
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.979 -0400", hash_original_method = "DDDDA1A5545DB0A17ACC18101B011287", hash_generated_method = "682F88DBA371196ED3D270082EBC7DA8")
    protected void broadcastMessenger() {
        Intent intent = new Intent(ACTION_DATA_CONNECTION_TRACKER_MESSENGER);
        intent.putExtra(EXTRA_MESSENGER, new Messenger(this));
        mPhone.getContext().sendBroadcast(intent);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.980 -0400", hash_original_method = "3F17133E8D63AE8C7414DC58966291E3", hash_generated_method = "1F3DDD83CBF5CBBC35A161C22AB7F759")
    public Activity getActivity() {
        Activity varB4EAC82CA7396A68D541C85D26508E83_2042793680 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2042793680 = mActivity;
        varB4EAC82CA7396A68D541C85D26508E83_2042793680.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2042793680;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.980 -0400", hash_original_method = "125099B58F8163C25EB6B1F0707923F4", hash_generated_method = "41428024BFF7A8B44F95CC7A862B5AA4")
    public boolean isApnTypeActive(String type) {
        {
            boolean var406626E19CADC2843874188E79EE9835_1930837341 = (Phone.APN_TYPE_DUN.equals(type));
            {
                ApnSetting dunApn = fetchDunApn();
                {
                    boolean var4EA0CE97F3A12CE0F2A51BCC7C48DA8F_1698435186 = (((mActiveApn != null) && (dunApn.toString().equals(mActiveApn.toString()))));
                } 
            } 
        } 
        boolean var169544BDB9440CDE71D63DA907E8F9A7_152531625 = (mActiveApn != null && mActiveApn.canHandleType(type));
        addTaint(type.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1133745131 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1133745131;
        
        
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.981 -0400", hash_original_method = "616B5B126FC289B3EB6BE1030B710468", hash_generated_method = "0699769341D0E9FB9BD64C063CD52631")
    protected ApnSetting fetchDunApn() {
        ApnSetting varB4EAC82CA7396A68D541C85D26508E83_149566150 = null; 
        ApnSetting varB4EAC82CA7396A68D541C85D26508E83_646116769 = null; 
        Context c = mPhone.getContext();
        String apnData = Settings.Secure.getString(c.getContentResolver(),
                Settings.Secure.TETHER_DUN_APN);
        ApnSetting dunSetting = ApnSetting.fromString(apnData);
        varB4EAC82CA7396A68D541C85D26508E83_149566150 = dunSetting;
        apnData = c.getResources().getString(R.string.config_tether_apndata);
        varB4EAC82CA7396A68D541C85D26508E83_646116769 = ApnSetting.fromString(apnData);
        ApnSetting varA7E53CE21691AB073D9660D615818899_2095941996; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2095941996 = varB4EAC82CA7396A68D541C85D26508E83_149566150;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2095941996 = varB4EAC82CA7396A68D541C85D26508E83_646116769;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2095941996.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2095941996;
        
        
        
                
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.982 -0400", hash_original_method = "F0E40F922DBB5D19CCBEC497FB284EC5", hash_generated_method = "97C457D1AA99D998A83D8C843739C4E5")
    public String[] getActiveApnTypes() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1387878627 = null; 
        String[] result;
        {
            result = mActiveApn.types;
        } 
        {
            result = new String[1];
            result[0] = Phone.APN_TYPE_DEFAULT;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1387878627 = result;
        varB4EAC82CA7396A68D541C85D26508E83_1387878627.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1387878627;
        
        
        
            
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.982 -0400", hash_original_method = "8A278F7563F3F2CC899D3E200DD135CD", hash_generated_method = "158B12FADC11F2E727F9EBC562EA31CB")
    public String getActiveApnString(String apnType) {
        String varB4EAC82CA7396A68D541C85D26508E83_692480548 = null; 
        String result = null;
        {
            result = mActiveApn.apn;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_692480548 = result;
        addTaint(apnType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_692480548.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_692480548;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.983 -0400", hash_original_method = "B18C74BBD4D71B87D6CD20822DAEB60C", hash_generated_method = "A9E97BDAF095D8A04EBA954179F944E0")
    public void setDataOnRoamingEnabled(boolean enabled) {
        {
            boolean varB54F03CDB64176FFCB855FF42639A95B_1871824206 = (getDataOnRoamingEnabled() != enabled);
            {
                final ContentResolver resolver = mPhone.getContext().getContentResolver();
                Settings.Secure.putInt(resolver, Settings.Secure.DATA_ROAMING, enabled ? 1 : 0);
            } 
        } 
        addTaint(enabled);
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.984 -0400", hash_original_method = "CA847DB1E96260749F912EC65B12A685", hash_generated_method = "C2A5293B81E4F65176DD188D5FF64E9F")
    public boolean getDataOnRoamingEnabled() {
        try 
        {
            final ContentResolver resolver = mPhone.getContext().getContentResolver();
            boolean varE702C72B406FC62334614256CE642190_1810738244 = (Settings.Secure.getInt(resolver, Settings.Secure.DATA_ROAMING) != 0);
        } 
        catch (SettingNotFoundException snfe)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1261983388 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1261983388;
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.985 -0400", hash_original_method = "D53421F789432FAA1BE4F347AFB92C88", hash_generated_method = "8C34C411145C9C5DE6D1C50EB54BE2C9")
    private void handleDataOnRoamingChange() {
        {
            boolean var1B4EADABCFD05CFDD8C3D1EDB2CE784D_984475733 = (mPhone.getServiceState().getRoaming());
            {
                {
                    boolean var83E97FA6F6D360AB5803CC641FB0388C_228157794 = (getDataOnRoamingEnabled());
                    {
                        resetAllRetryCounts();
                    } 
                } 
                sendMessage(obtainMessage(EVENT_ROAMING_ON));
            } 
        } 
        
        
            
                
            
            
        
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.993 -0400", hash_original_method = "664FE2A04A36F386D94369A328F3D0AD", hash_generated_method = "368AA79B71AFC1B597C36A9C40401089")
    protected void onDataStallAlarm(int tag) {
        
        loge("onDataStallAlarm: not impleted tag=" + tag);
        addTaint(tag);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.995 -0400", hash_original_method = "F3EE7F03AAF60471D3A97F562455D5DC", hash_generated_method = "105940566D5B3263CE9526EC1D4D3956")
    @Override
    public void handleMessage(Message msg) {
        
        {
            log("DISCONNECTED_CONNECTED: msg=" + msg);
            DataConnectionAc dcac = (DataConnectionAc) msg.obj;
            mDataConnectionAsyncChannels.remove(dcac.dataConnection.getDataConnectionId());
            dcac.disconnected();
        } 
        
        
        onEnableApn(msg.arg1, msg.arg2);
        
        
        String reason = null;
        
        
        {
            reason = (String) msg.obj;
        } 
        
        
        onTrySetupData(reason);
        
        
        onDataStallAlarm(msg.arg1);
        
        
        {
            boolean var6A4EDF3FAFEE8B58E0E885094E7C645E_693172006 = (getDataOnRoamingEnabled() == false);
            {
                resetAllRetryCounts();
            } 
        } 
        
        
        onRoamingOff();
        
        
        onRoamingOn();
        
        
        onRadioAvailable();
        
        
        onRadioOffOrNotAvailable();
        
        
        mCidActive = msg.arg1;
        
        
        onDataSetupComplete((AsyncResult) msg.obj);
        
        
        log("DataConnectoinTracker.handleMessage: EVENT_DISCONNECT_DONE msg=" + msg);
        
        
        onDisconnectDone(msg.arg1, (AsyncResult) msg.obj);
        
        
        onVoiceCallStarted();
        
        
        onVoiceCallEnded();
        
        
        {
            onCleanUpAllConnections((String) msg.obj);
        } 
        
        
        {
            boolean tearDown;
            tearDown = false;
            tearDown = true;
            onCleanUpConnection(tearDown, msg.arg2, (String) msg.obj);
        } 
        
        
        {
            boolean enabled;
            enabled = true;
            enabled = false;
            onSetInternalDataEnabled(enabled);
        } 
        
        
        {
            log("EVENT_RESET_DONE");
            onResetDone((AsyncResult) msg.obj);
        } 
        
        
        {
            boolean enabled;
            enabled = true;
            enabled = false;
            log("CMD_SET_USER_DATA_ENABLE enabled=" + enabled);
            onSetUserDataEnabled(enabled);
        } 
        
        
        {
            boolean met;
            met = true;
            met = false;
            log("CMD_SET_DEPENDENCY_MET met=" + met);
            Bundle bundle = msg.getData();
            {
                String apnType = (String)bundle.get(APN_TYPE_KEY);
                {
                    onSetDependencyMet(apnType, met);
                } 
            } 
        } 
        
        
        {
            boolean enabled;
            enabled = true;
            enabled = false;
            onSetPolicyDataEnabled(enabled);
        } 
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.995 -0400", hash_original_method = "8F4FE806494E709DA803471FC4054850", hash_generated_method = "6B126A9F5C906F30F12CF9263FE1B2B6")
    public boolean getAnyDataEnabled() {
        boolean result;
        {
            result = (mInternalDataEnabled && mUserDataEnabled && sPolicyDataEnabled
                    && (enabledCount != 0));
        } 
        log("getAnyDataEnabled " + result);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_734262741 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_734262741;
        
        
        
            
                    
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.996 -0400", hash_original_method = "01BBE084CAD104CD5BF824EF92BD879D", hash_generated_method = "4353BCFE0C36A879E20EE82324D1E437")
    protected boolean isEmergency() {
        boolean result;
        {
            result = mPhone.isInEcm() || mPhone.isInEmergencyCall();
        } 
        log("isEmergency: result=" + result);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1091612131 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1091612131;
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.997 -0400", hash_original_method = "5D23D8F3C80DDDEC0087C53C5035314E", hash_generated_method = "D0CD23D45F038B17A54BA814778CC807")
    protected int apnTypeToId(String type) {
        {
            boolean var309D3C860D69C9DD812B86CF681881B6_1805158477 = (TextUtils.equals(type, Phone.APN_TYPE_DEFAULT));
            {
                boolean var5A453EEDD3E3976BB49C9508291B2AF1_1053542687 = (TextUtils.equals(type, Phone.APN_TYPE_MMS));
                {
                    boolean var3CE0D478E88EB81F167085762129B382_1611772340 = (TextUtils.equals(type, Phone.APN_TYPE_SUPL));
                    {
                        boolean varF95EB5896A1FFC653B2B4EDAB9BA81D0_1813900321 = (TextUtils.equals(type, Phone.APN_TYPE_DUN));
                        {
                            boolean var869DCC811C6B09B9BEDB01CBDB8E3BB8_539770858 = (TextUtils.equals(type, Phone.APN_TYPE_HIPRI));
                            {
                                boolean var6BF0B7241C25AB8D91947F3EF585FCE9_1449892129 = (TextUtils.equals(type, Phone.APN_TYPE_IMS));
                                {
                                    boolean var87D249D8144B57A4B6191CE038D7E433_689963545 = (TextUtils.equals(type, Phone.APN_TYPE_FOTA));
                                    {
                                        boolean var14F7602C7EF2A0501FF08693C56BFA7B_826208266 = (TextUtils.equals(type, Phone.APN_TYPE_CBS));
                                    } 
                                } 
                            } 
                        } 
                    } 
                } 
            } 
        } 
        addTaint(type.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_500302157 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_500302157;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.999 -0400", hash_original_method = "C8FDA5A0B2174A5D621C26D6E6AEF75F", hash_generated_method = "3F51B3ED60B09E5423AC5DBF509CDB1A")
    protected String apnIdToType(int id) {
        String varB4EAC82CA7396A68D541C85D26508E83_1864584692 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_197640226 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1002938663 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1422029926 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_753303261 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_148568532 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_567467929 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_78616215 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_350242924 = null; 
        
        varB4EAC82CA7396A68D541C85D26508E83_1864584692 = Phone.APN_TYPE_DEFAULT;
        
        
        varB4EAC82CA7396A68D541C85D26508E83_197640226 = Phone.APN_TYPE_MMS;
        
        
        varB4EAC82CA7396A68D541C85D26508E83_1002938663 = Phone.APN_TYPE_SUPL;
        
        
        varB4EAC82CA7396A68D541C85D26508E83_1422029926 = Phone.APN_TYPE_DUN;
        
        
        varB4EAC82CA7396A68D541C85D26508E83_753303261 = Phone.APN_TYPE_HIPRI;
        
        
        varB4EAC82CA7396A68D541C85D26508E83_148568532 = Phone.APN_TYPE_IMS;
        
        
        varB4EAC82CA7396A68D541C85D26508E83_567467929 = Phone.APN_TYPE_FOTA;
        
        
        varB4EAC82CA7396A68D541C85D26508E83_78616215 = Phone.APN_TYPE_CBS;
        
        
        log("Unknown id (" + id + ") in apnIdToType");
        
        
        varB4EAC82CA7396A68D541C85D26508E83_350242924 = Phone.APN_TYPE_DEFAULT;
        
        addTaint(id);
        String varA7E53CE21691AB073D9660D615818899_1505738767; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1505738767 = varB4EAC82CA7396A68D541C85D26508E83_1864584692;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1505738767 = varB4EAC82CA7396A68D541C85D26508E83_197640226;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1505738767 = varB4EAC82CA7396A68D541C85D26508E83_1002938663;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_1505738767 = varB4EAC82CA7396A68D541C85D26508E83_1422029926;
                break;
            case 5: 
                varA7E53CE21691AB073D9660D615818899_1505738767 = varB4EAC82CA7396A68D541C85D26508E83_753303261;
                break;
            case 6: 
                varA7E53CE21691AB073D9660D615818899_1505738767 = varB4EAC82CA7396A68D541C85D26508E83_148568532;
                break;
            case 7: 
                varA7E53CE21691AB073D9660D615818899_1505738767 = varB4EAC82CA7396A68D541C85D26508E83_567467929;
                break;
            case 8: 
                varA7E53CE21691AB073D9660D615818899_1505738767 = varB4EAC82CA7396A68D541C85D26508E83_78616215;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1505738767 = varB4EAC82CA7396A68D541C85D26508E83_350242924;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1505738767.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1505738767;
        
        
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.000 -0400", hash_original_method = "C93C3112872052D96A1B607494195947", hash_generated_method = "AE933507E357C595FE8E473C5D8B3A18")
    protected LinkProperties getLinkProperties(String apnType) {
        LinkProperties varB4EAC82CA7396A68D541C85D26508E83_362287944 = null; 
        LinkProperties varB4EAC82CA7396A68D541C85D26508E83_710238176 = null; 
        int id = apnTypeToId(apnType);
        {
            boolean var3B28DF70088D079134A00EB30AD60CE7_543763775 = (isApnIdEnabled(id));
            {
                DataConnectionAc dcac = mDataConnectionAsyncChannels.get(0);
                varB4EAC82CA7396A68D541C85D26508E83_362287944 = dcac.getLinkPropertiesSync();
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_710238176 = new LinkProperties();
            } 
        } 
        addTaint(apnType.getTaint());
        LinkProperties varA7E53CE21691AB073D9660D615818899_1715274911; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1715274911 = varB4EAC82CA7396A68D541C85D26508E83_362287944;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1715274911 = varB4EAC82CA7396A68D541C85D26508E83_710238176;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1715274911.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1715274911;
        
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.001 -0400", hash_original_method = "8B34AF8E1FD52F7524E0692F560388F1", hash_generated_method = "A05EDC8F42FD35676A26F384360E90F8")
    protected LinkCapabilities getLinkCapabilities(String apnType) {
        LinkCapabilities varB4EAC82CA7396A68D541C85D26508E83_1485268645 = null; 
        LinkCapabilities varB4EAC82CA7396A68D541C85D26508E83_850178714 = null; 
        int id = apnTypeToId(apnType);
        {
            boolean var3B28DF70088D079134A00EB30AD60CE7_291479541 = (isApnIdEnabled(id));
            {
                DataConnectionAc dcac = mDataConnectionAsyncChannels.get(0);
                varB4EAC82CA7396A68D541C85D26508E83_1485268645 = dcac.getLinkCapabilitiesSync();
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_850178714 = new LinkCapabilities();
            } 
        } 
        addTaint(apnType.getTaint());
        LinkCapabilities varA7E53CE21691AB073D9660D615818899_88247434; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_88247434 = varB4EAC82CA7396A68D541C85D26508E83_1485268645;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_88247434 = varB4EAC82CA7396A68D541C85D26508E83_850178714;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_88247434.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_88247434;
        
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.001 -0400", hash_original_method = "EA8A5478D5AABF3FA098569BF99381B3", hash_generated_method = "0A524913CA5351D41FBEE7F51B70FF5C")
    protected void notifyDataConnection(String reason) {
        {
            int id = 0;
            {
                {
                    mPhone.notifyDataConnection(reason, apnIdToType(id));
                } 
            } 
        } 
        notifyOffApnsOfAvailability(reason);
        addTaint(reason.getTaint());
        
        
            
                
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.001 -0400", hash_original_method = "0EE2FD1B724C501D31FB7072BBECFF7B", hash_generated_method = "E30A6CAE292CB4DEA031278662F3D64B")
    private void notifyApnIdUpToCurrent(String reason, int apnId) {
        
        mPhone.notifyDataConnection(reason, apnIdToType(apnId), Phone.DataState.CONNECTING);
        
        
        mPhone.notifyDataConnection(reason, apnIdToType(apnId), Phone.DataState.CONNECTING);
        
        
        mPhone.notifyDataConnection(reason, apnIdToType(apnId), Phone.DataState.CONNECTED);
        
        addTaint(reason.getTaint());
        addTaint(apnId);
        
        
            
            
                
            
            
                
                
            
            
                
                
                
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.002 -0400", hash_original_method = "D45BD11E51C479A3FCCFFBAFE72F463B", hash_generated_method = "79FB756811C49BCC65CD01118A350E00")
    private void notifyApnIdDisconnected(String reason, int apnId) {
        mPhone.notifyDataConnection(reason, apnIdToType(apnId), Phone.DataState.DISCONNECTED);
        addTaint(reason.getTaint());
        addTaint(apnId);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.002 -0400", hash_original_method = "AD67DC7D8E779758CC2EF151B8EB9A25", hash_generated_method = "7B2BCE991D024D5665E642131BEA47C7")
    protected void notifyOffApnsOfAvailability(String reason) {
        log("notifyOffApnsOfAvailability - reason= " + reason);
        {
            int id = 0;
            {
                {
                    boolean var4E5CD2F83AC285F39052DC55CB4A94E1_961137192 = (!isApnIdEnabled(id));
                    {
                        notifyApnIdDisconnected(reason, id);
                    } 
                } 
            } 
        } 
        addTaint(reason.getTaint());
        
        
        
            
                
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.002 -0400", hash_original_method = "8B5C5B568EA76224959243C3FA291570", hash_generated_method = "6176432C5BBB4BCB5DF2D3A91E1E986E")
    public boolean isApnTypeEnabled(String apnType) {
        {
            boolean varCF600E2D886E7589A9F5438BC08F9D5E_2040234349 = (isApnIdEnabled(apnTypeToId(apnType)));
        } 
        addTaint(apnType.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1304567088 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1304567088;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.003 -0400", hash_original_method = "453A43A7EADEB97159250F7F1E9B04E5", hash_generated_method = "9ADA56ECE75BF75145F58F5F4F8829A1")
    protected synchronized boolean isApnIdEnabled(int id) {
        addTaint(id);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_901601743 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_901601743;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.003 -0400", hash_original_method = "B518CE0EFC616BFFCBE5135F2BCA33B7", hash_generated_method = "5E7A058717BA73097310716C4BA4A637")
    public synchronized int enableApnType(String type) {
        int id = apnTypeToId(type);
        {
            log("enableApnType(" + type + "), isApnTypeActive = " + isApnTypeActive(type)
                    + ", isApnIdEnabled =" + isApnIdEnabled(id) + " and state = " + mState);
        } 
        {
            boolean varA853C8852E4D73E41EF53078A12AEAC4_254885431 = (!isApnTypeAvailable(type));
            {
                log("type not available");
            } 
        } 
        {
            boolean var3B28DF70088D079134A00EB30AD60CE7_2120402526 = (isApnIdEnabled(id));
            {
                setEnabled(id, true);
            } 
        } 
        addTaint(type.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_926165175 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_926165175;
        
        
        
            
        
        
            
                    
        
        
            
            
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.004 -0400", hash_original_method = "A5E4EE0A9C6812357B5B6B8F3C042D82", hash_generated_method = "93FBDB787C5B94DB71361D8FB3F47605")
    public synchronized int disableApnType(String type) {
        log("disableApnType(" + type + ")");
        int id = apnTypeToId(type);
        {
            boolean var3B28DF70088D079134A00EB30AD60CE7_206484558 = (isApnIdEnabled(id));
            {
                setEnabled(id, false);
                {
                    boolean var4038903CF6895B879BB8F22E571F633C_1055482891 = (isApnTypeActive(Phone.APN_TYPE_DEFAULT));
                } 
            } 
        } 
        addTaint(type.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_707271716 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_707271716;
        
        
        
        
            
        
        
            
            
                
                    
                
                    
                
            
                
            
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.005 -0400", hash_original_method = "25F13BA52E496C8972985CBEE5B69F23", hash_generated_method = "8752C7388B1098A472D3030AF9614F27")
    protected void setEnabled(int id, boolean enable) {
        {
            log("setEnabled(" + id + ", " + enable + ") with old state = " + dataEnabled[id]
                    + " and enabledCount = " + enabledCount);
        } 
        Message msg = obtainMessage(EVENT_ENABLE_NEW_APN);
        msg.arg1 = id;
        msg.arg2 = (enable ? ENABLED : DISABLED);
        sendMessage(msg);
        addTaint(id);
        addTaint(enable);
        
        
            
                    
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.006 -0400", hash_original_method = "6346C217AE811F98B5143DCE05848411", hash_generated_method = "BE5BFAAC1AF40DF793E063021C1ED4B1")
    protected void onEnableApn(int apnId, int enabled) {
        
        {
            log("EVENT_APN_ENABLE_REQUEST apnId=" + apnId + ", apnType=" + apnIdToType(apnId) +
                    ", enabled=" + enabled + ", dataEnabled = " + dataEnabled[apnId] +
                    ", enabledCount = " + enabledCount + ", isApnTypeActive = " +
                    isApnTypeActive(apnIdToType(apnId)));
        } 
        {
            {
                {
                    dataEnabled[apnId] = true;
                } 
            } 
            String type = apnIdToType(apnId);
            {
                boolean varF392DA59AED5AF7339423DB9E4235404_406414254 = (!isApnTypeActive(type));
                {
                    mRequestedApnType = type;
                    onEnableNewApn();
                } 
                {
                    notifyApnIdUpToCurrent(Phone.REASON_APN_SWITCHED, apnId);
                } 
            } 
        } 
        {
            boolean didDisable = false;
            {
                {
                    dataEnabled[apnId] = false;
                    didDisable = true;
                } 
            } 
            {
                onCleanUpConnection(true, apnId, Phone.REASON_DATA_DISABLED);
                notifyApnIdDisconnected(Phone.REASON_DATA_DISABLED, apnId);
                {
                    boolean var77362D34A9ADAA4D41EE076EC20EEB8C_127074463 = (dataEnabled[APN_DEFAULT_ID] == true
                        && !isApnTypeActive(Phone.APN_TYPE_DEFAULT));
                    {
                        mRequestedApnType = Phone.APN_TYPE_DEFAULT;
                        onEnableNewApn();
                    } 
                } 
            } 
        } 
        addTaint(enabled);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.006 -0400", hash_original_method = "FBAA4A80E4538BA497646C5AED60D911", hash_generated_method = "32D68D2D8870859115DE7BFCF2679FE7")
    protected void onEnableNewApn() {
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.007 -0400", hash_original_method = "58B3A2A4D2FF1B49B3A412CB94198F76", hash_generated_method = "90D166404488124DA3551A8CE530598F")
    protected void onResetDone(AsyncResult ar) {
        
        log("EVENT_RESET_DONE");
        String reason = null;
        {
            reason = (String) ar.userObj;
        } 
        gotoIdleAndNotifyDataConnection(reason);
        addTaint(ar.getTaint());
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.007 -0400", hash_original_method = "DE9C8D1FA305A86440711210D5CC0DFB", hash_generated_method = "B569ED50450B635005D8FC1EA2186A89")
    public boolean setInternalDataEnabled(boolean enable) {
        log("setInternalDataEnabled(" + enable + ")");
        Message msg = obtainMessage(EVENT_SET_INTERNAL_DATA_ENABLE);
        msg.arg1 = (enable ? ENABLED : DISABLED);
        sendMessage(msg);
        addTaint(enable);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1476257866 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1476257866;
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.008 -0400", hash_original_method = "2FFC27FC9820E2F3BAEE3098A222A5B3", hash_generated_method = "17E0658898110411B3A57C927D045245")
    protected void onSetInternalDataEnabled(boolean enabled) {
        
        {
            mInternalDataEnabled = enabled;
            {
                log("onSetInternalDataEnabled: changed to enabled, try to setup data call");
                resetAllRetryCounts();
                onTrySetupData(Phone.REASON_DATA_ENABLED);
            } 
            {
                log("onSetInternalDataEnabled: changed to disabled, cleanUpAllConnections");
                cleanUpAllConnections(null);
            } 
        } 
        
        
            
            
                
                
                
            
                
                
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.008 -0400", hash_original_method = "68E67092B4266000A5BC48E8C37B6ED2", hash_generated_method = "074DBC07DCDA0EBA9722A87AEACC7F57")
    public void cleanUpAllConnections(String cause) {
        Message msg = obtainMessage(EVENT_CLEAN_UP_ALL_CONNECTIONS);
        msg.obj = cause;
        sendMessage(msg);
        addTaint(cause.getTaint());
        
        
        
        
    }

    
    public abstract boolean isDisconnected();

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.009 -0400", hash_original_method = "49C3C07E31C3EAA572D4F39FF0B691FA", hash_generated_method = "5052DFE7C201EB98DA42964D852DE5EF")
    protected void onSetUserDataEnabled(boolean enabled) {
        
        {
            final boolean prevEnabled = getAnyDataEnabled();
            {
                mUserDataEnabled = enabled;
                Settings.Secure.putInt(mPhone.getContext().getContentResolver(),
                        Settings.Secure.MOBILE_DATA, enabled ? 1 : 0);
                {
                    boolean varE966989352CF1A89B6BCE35C2FF5420E_2085794068 = (prevEnabled != getAnyDataEnabled());
                    {
                        {
                            resetAllRetryCounts();
                            onTrySetupData(Phone.REASON_DATA_ENABLED);
                        } 
                        {
                            onCleanUpAllConnections(Phone.REASON_DATA_DISABLED);
                        } 
                    } 
                } 
            } 
        } 
        
        
            
            
                
                
                        
                
                    
                        
                        
                    
                        
                    
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.010 -0400", hash_original_method = "CE2949FE6361D634BBA79ED70CC5EAE2", hash_generated_method = "2FE2F2DA1817B656777C8A5B772A6D15")
    protected void onSetDependencyMet(String apnType, boolean met) {
        
        addTaint(apnType.getTaint());
        addTaint(met);
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.012 -0400", hash_original_method = "5C2A966CAC36731C633B25393BAF4799", hash_generated_method = "0BB564DE3CB5AEE973F65F44E48842AA")
    protected void onSetPolicyDataEnabled(boolean enabled) {
        
        {
            final boolean prevEnabled = getAnyDataEnabled();
            {
                sPolicyDataEnabled = enabled;
                {
                    boolean varE966989352CF1A89B6BCE35C2FF5420E_367460586 = (prevEnabled != getAnyDataEnabled());
                    {
                        {
                            resetAllRetryCounts();
                            onTrySetupData(Phone.REASON_DATA_ENABLED);
                        } 
                        {
                            onCleanUpAllConnections(Phone.REASON_DATA_DISABLED);
                        } 
                    } 
                } 
            } 
        } 
        addTaint(enabled);
        
        
            
            
                
                
                    
                        
                        
                    
                        
                    
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.015 -0400", hash_original_method = "E5EFA23236CE13ACC69B88C6F16F1B0C", hash_generated_method = "77F3DB4334032C03B134DFACFA1E16A6")
    protected String getReryConfig(boolean forDefault) {
        String varB4EAC82CA7396A68D541C85D26508E83_1422978930 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1214264322 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_458131367 = null; 
        int rt = mPhone.getServiceState().getRadioTechnology();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1422978930 = SystemProperties.get("ro.cdma.data_retry_config");
        } 
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_1214264322 = SystemProperties.get("ro.gsm.data_retry_config");
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_458131367 = SystemProperties.get("ro.gsm.2nd_data_retry_config");
            } 
        } 
        addTaint(forDefault);
        String varA7E53CE21691AB073D9660D615818899_959938134; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_959938134 = varB4EAC82CA7396A68D541C85D26508E83_1422978930;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_959938134 = varB4EAC82CA7396A68D541C85D26508E83_1214264322;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_959938134 = varB4EAC82CA7396A68D541C85D26508E83_458131367;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_959938134.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_959938134;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.024 -0400", hash_original_method = "0FD4DA1D85F6AEE253925BB7FDB228BD", hash_generated_method = "DF4A140089C413DB6E3D22E5D38B12FF")
    protected void resetAllRetryCounts() {
        {
            Iterator<DataConnection> var8D54139306CE59DA2A79305B93065ACC_565010419 = (mDataConnections.values()).iterator();
            var8D54139306CE59DA2A79305B93065ACC_565010419.hasNext();
            DataConnection dc = var8D54139306CE59DA2A79305B93065ACC_565010419.next();
            {
                dc.resetRetryCount();
            } 
        } 
        
        
            
        
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.024 -0400", hash_original_method = "BA61ACB3318576C64C09DAC113E0795F", hash_generated_method = "FA57034BBBA5D59687B99DF037194C62")
        public  DataRoamingSettingObserver(Handler handler) {
            super(handler);
            addTaint(handler.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.024 -0400", hash_original_method = "B90ABFF6DE01DDCB354DDF92EE51905A", hash_generated_method = "487AD44CB3A136E5E51D9AD0525E13FB")
        public void register(Context context) {
            final ContentResolver resolver = context.getContentResolver();
            resolver.registerContentObserver(
                    Settings.Secure.getUriFor(Settings.Secure.DATA_ROAMING), false, this);
            addTaint(context.getTaint());
            
            
            
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.025 -0400", hash_original_method = "A96EEB9B30A252CB5EDDDA8B92E0867E", hash_generated_method = "484AD7C78B005DE3738C4CB86E9C4246")
        public void unregister(Context context) {
            final ContentResolver resolver = context.getContentResolver();
            resolver.unregisterContentObserver(this);
            addTaint(context.getTaint());
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.025 -0400", hash_original_method = "169C7D81EE3F2154C9E94D652CC4F700", hash_generated_method = "7078379D68C8CF85B358A0DE1DB16F06")
        @Override
        public void onChange(boolean selfChange) {
            
            handleDataOnRoamingChange();
            addTaint(selfChange);
            
            
        }

        
    }


    
    public class TxRxSum {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.025 -0400", hash_original_field = "9A029104A537A9F6518DBC5E97BCA4CB", hash_generated_field = "31EBFEDBE9880286CAB65EBD7356F689")

        public long txPkts;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.025 -0400", hash_original_field = "41F45C1353F236210B54784C5F09E899", hash_generated_field = "FFD759E6497E1FB8FF7E9F7E8C351B73")

        public long rxPkts;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.025 -0400", hash_original_method = "A9FFC39802399C2580CE69B9ED52FB70", hash_generated_method = "3480E04706A82CC0FC15FF716763F24D")
        public  TxRxSum() {
            reset();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.025 -0400", hash_original_method = "CBCCCAC9E5E65AD1C4A36F84309761F3", hash_generated_method = "5084D0A66E4E15FA652E0C50C229F7A5")
        public  TxRxSum(long txPkts, long rxPkts) {
            this.txPkts = txPkts;
            this.rxPkts = rxPkts;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.026 -0400", hash_original_method = "AD3F4A8C32B5AB82EFF11F34262CA97C", hash_generated_method = "392DAA30EB30056E5D0A513FEBC5B1E8")
        public  TxRxSum(TxRxSum sum) {
            txPkts = sum.txPkts;
            rxPkts = sum.rxPkts;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.026 -0400", hash_original_method = "AC7E7693FF46B721A881337A05B09C85", hash_generated_method = "8B79F23D5DA55C534A1AF5C4055F1390")
        public void reset() {
            txPkts = -1;
            rxPkts = -1;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.026 -0400", hash_original_method = "1CA3D86B2E80A8520E2DD65A646FFF96", hash_generated_method = "74BF04E27598E37E421AC33FF2EC5365")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1938404520 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1938404520 = "{txSum=" + txPkts + " rxSum=" + rxPkts + "}";
            varB4EAC82CA7396A68D541C85D26508E83_1938404520.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1938404520;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.028 -0400", hash_original_method = "4A3A2BC6E4110C10924DC1B1F4DD1644", hash_generated_method = "8B728B23FC074F3CAC974FD1BAE3D2F4")
        public void updateTxRxSum() {
            boolean txUpdated = false;
            boolean rxUpdated = false;
            long txSum = 0;
            long rxSum = 0;
            {
                Iterator<ApnContext> var9CD107E7BA0F92F9952456E34FCCDBF9_1139834863 = (mApnContexts.values()).iterator();
                var9CD107E7BA0F92F9952456E34FCCDBF9_1139834863.hasNext();
                ApnContext apnContext = var9CD107E7BA0F92F9952456E34FCCDBF9_1139834863.next();
                {
                    {
                        boolean var2276B48A10025B18D3ED30F6663560D1_41692363 = (apnContext.getState() == State.CONNECTED);
                        {
                            DataConnectionAc dcac = apnContext.getDataConnectionAc();
                            LinkProperties linkProp = dcac.getLinkPropertiesSync();
                            String iface = linkProp.getInterfaceName();
                            {
                                long stats = TrafficStats.getTxPackets(iface);
                                {
                                    txUpdated = true;
                                    txSum += stats;
                                } 
                                stats = TrafficStats.getRxPackets(iface);
                                {
                                    rxUpdated = true;
                                    rxSum += stats;
                                } 
                            } 
                        } 
                    } 
                } 
            } 
            this.txPkts = txSum;
            this.rxPkts = rxSum;
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.028 -0400", hash_original_field = "A4622F7F72162611C8E075EE443BC26E", hash_generated_field = "5F5E7D64B04175B8FA820B2440F700FC")

    protected static final boolean DBG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.028 -0400", hash_original_field = "F731EB70B21910E383F52051C1671657", hash_generated_field = "9627AE94D7940D7E187DD2B77A194FB7")

    protected static final boolean VDBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.028 -0400", hash_original_field = "7BDA6D1A9141EE0AD7FF9598A1FEB6A4", hash_generated_field = "33A74D16876315708A9BD8BD04E30FC7")

    public static String ACTION_DATA_CONNECTION_TRACKER_MESSENGER = "com.android.internal.telephony";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.028 -0400", hash_original_field = "51DF027D281586560FC115C63DD6DEF7", hash_generated_field = "26F3AF3552BC4649D0937B13E6BC7CF8")

    public static String EXTRA_MESSENGER = "EXTRA_MESSENGER";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.029 -0400", hash_original_field = "5965E06AE63626458452FCAD583F5AA9", hash_generated_field = "578AE35EE98E3DDD5EEAF2CBED5ACB45")

    protected static final int BASE = Protocol.BASE_DATA_CONNECTION_TRACKER;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.029 -0400", hash_original_field = "ECA626187861A2CCB3096D5073C18D44", hash_generated_field = "57E86604562BA2CD352710B284D46B74")

    protected static final int EVENT_DATA_SETUP_COMPLETE = BASE + 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.029 -0400", hash_original_field = "33F24341EE51BCC25663714C2A8AC519", hash_generated_field = "918C2E0C3F0B773EB57002039E5ADDF8")

    protected static final int EVENT_RADIO_AVAILABLE = BASE + 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.029 -0400", hash_original_field = "46DEF412949D3D229F0F086981FB575D", hash_generated_field = "9B5C18CFAB1EB82B998D3AC095B58265")

    protected static final int EVENT_RECORDS_LOADED = BASE + 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.029 -0400", hash_original_field = "426A2E540BFDB2E53205370AC68A088D", hash_generated_field = "A0525720B88653F55BA065E6AA892DC1")

    protected static final int EVENT_TRY_SETUP_DATA = BASE + 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.029 -0400", hash_original_field = "68D0D3D09B29128339F18635AD1150DC", hash_generated_field = "F6570C1A0821C4AB0BE35C147D368628")

    protected static final int EVENT_DATA_STATE_CHANGED = BASE + 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.029 -0400", hash_original_field = "F2CC829E98056690ECDD89CEA8DF771B", hash_generated_field = "FBFDC491608A17124A17D3452F208088")

    protected static final int EVENT_POLL_PDP = BASE + 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.029 -0400", hash_original_field = "B1989873DB7387EF71BE1A11DDA31D66", hash_generated_field = "27116C6686CAE7B4E6DC721A8CBA4151")

    protected static final int EVENT_RADIO_OFF_OR_NOT_AVAILABLE = BASE + 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.029 -0400", hash_original_field = "AE7C2E85ED91FEA82BE6ADA84456A79C", hash_generated_field = "7961EC29589D615AB66085BBDDF16352")

    protected static final int EVENT_VOICE_CALL_STARTED = BASE + 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.029 -0400", hash_original_field = "F68B4A87FAF27CD2F0289E80AFDCEB4A", hash_generated_field = "4E3DEF92CAD4F30419EB5EB31D45E012")

    protected static final int EVENT_VOICE_CALL_ENDED = BASE + 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.029 -0400", hash_original_field = "C0466AD2885B3AE52B71D60533BB007B", hash_generated_field = "EA6E60EE7ECE546BDE71D93811BB9270")

    protected static final int EVENT_DATA_CONNECTION_DETACHED = BASE + 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.029 -0400", hash_original_field = "0B97AAAEBA1C3D8083CF0885170E6D51", hash_generated_field = "D603A46CFC57F5E3579D3275D14987B9")

    protected static final int EVENT_LINK_STATE_CHANGED = BASE + 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.029 -0400", hash_original_field = "40AD81D1830810A9C166ED3D184C9304", hash_generated_field = "37C4B29B403735591BA4637FD7F07300")

    protected static final int EVENT_ROAMING_ON = BASE + 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.029 -0400", hash_original_field = "5AD3E60C000936BC36EAE24FC4D6BFF6", hash_generated_field = "AC2E0D687697D630951043F63F8B55EF")

    protected static final int EVENT_ROAMING_OFF = BASE + 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.029 -0400", hash_original_field = "055D12EA48C72D2C9AE5C7F7406DD106", hash_generated_field = "56ED200F83206D8C2B8AEEC777D92808")

    protected static final int EVENT_ENABLE_NEW_APN = BASE + 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.029 -0400", hash_original_field = "510504022D446F08C64C402076675CB3", hash_generated_field = "699A01D28FE3B5BA2F9DBE2E14C16720")

    protected static final int EVENT_RESTORE_DEFAULT_APN = BASE + 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.029 -0400", hash_original_field = "326890052C84F103A1868FD54E3F3A66", hash_generated_field = "8CB78322EFEEA6081C6B4812D06CDE2F")

    protected static final int EVENT_DISCONNECT_DONE = BASE + 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.029 -0400", hash_original_field = "B7E3A0839C0FE078993E272A934BB5A7", hash_generated_field = "706DAFBB316C33FB3681D6E45AF16EC5")

    protected static final int EVENT_DATA_CONNECTION_ATTACHED = BASE + 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.029 -0400", hash_original_field = "D7C0AC990309F4BF30F63B057CC45F91", hash_generated_field = "524270489D97E868640177C02C87FAEF")

    protected static final int EVENT_DATA_STALL_ALARM = BASE + 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.030 -0400", hash_original_field = "AA99799D44889D88952331EB4BBA81A5", hash_generated_field = "E6A154D47B9FDA448EB2D6ECA54E9044")

    protected static final int EVENT_DO_RECOVERY = BASE + 18;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.030 -0400", hash_original_field = "A2B9E56589E0A1808D25BF81D2820D8F", hash_generated_field = "C64987752373EDCE104AC55BCE584A2E")

    protected static final int EVENT_APN_CHANGED = BASE + 19;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.030 -0400", hash_original_field = "4DFAB0760A0FF0BC17DF1FA9AFE7EB93", hash_generated_field = "732BEB3FAC1202A7DAB02A4D73A7407D")

    protected static final int EVENT_CDMA_DATA_DETACHED = BASE + 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.030 -0400", hash_original_field = "7B446BE5FF12DCEE083E090357AE8D56", hash_generated_field = "8909A780334573F8F694B9A1EBC29A1A")

    protected static final int EVENT_NV_READY = BASE + 21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.030 -0400", hash_original_field = "E6FDE084A4225A1557CE43DF696C02FE", hash_generated_field = "2D0CA6675E7E5DF0AC5D6499149EBCAB")

    protected static final int EVENT_PS_RESTRICT_ENABLED = BASE + 22;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.030 -0400", hash_original_field = "37AFD73B25951F6E1E8C8F9F4991E0E5", hash_generated_field = "E117070A96CD4C5C470336E4EE845528")

    protected static final int EVENT_PS_RESTRICT_DISABLED = BASE + 23;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.030 -0400", hash_original_field = "34C5609EBA200D1855670B4451302323", hash_generated_field = "AD86F18DB896FF32B9ABB648D3BE3614")

    public static final int EVENT_CLEAN_UP_CONNECTION = BASE + 24;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.030 -0400", hash_original_field = "CF37FF76A274159E6384837A9F7F486F", hash_generated_field = "9FC0CEF9DBBD9CDD60A47E3B572DEE11")

    protected static final int EVENT_CDMA_OTA_PROVISION = BASE + 25;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.030 -0400", hash_original_field = "BF7AF52C7FDD44135813BD775C753027", hash_generated_field = "2E113365E66D355FEDAB98A7D37D81A7")

    protected static final int EVENT_RESTART_RADIO = BASE + 26;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.030 -0400", hash_original_field = "DCE289D9C00CC3F12901135A087230E7", hash_generated_field = "EBD7235096B041C0C308DD944A3704E2")

    protected static final int EVENT_SET_INTERNAL_DATA_ENABLE = BASE + 27;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.030 -0400", hash_original_field = "AEE40AA06967C6AA4E971FA645018541", hash_generated_field = "5034595773C1BED896C3513B3B07EC9E")

    protected static final int EVENT_RESET_DONE = BASE + 28;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.030 -0400", hash_original_field = "61715180A570527CA45BE873F1A8B16F", hash_generated_field = "F77450C54EDD06E9C95E2653ED0EECF1")

    public static final int CMD_SET_USER_DATA_ENABLE = BASE + 29;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.030 -0400", hash_original_field = "BF8CD25798DFB7D44A922B1D22D07FD8", hash_generated_field = "B4E9A3F75E31EBF0819A14E7CE2FE65B")

    public static final int EVENT_CLEAN_UP_ALL_CONNECTIONS = BASE + 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.030 -0400", hash_original_field = "DBD783B09580CAD21B9BA70443B9B2B3", hash_generated_field = "D8C9AD1D6E5CBD85074BECAA38E31518")

    public static final int CMD_SET_DEPENDENCY_MET = BASE + 31;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.030 -0400", hash_original_field = "44F851B2D4C8232521C6B3BA1F442BD3", hash_generated_field = "3254C5957AFFF539FD79B974BB823F2E")

    public static final int CMD_SET_POLICY_DATA_ENABLE = BASE + 32;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.030 -0400", hash_original_field = "124CDEAD86429F817C00334490AF589A", hash_generated_field = "07F46E413C8B3F3559740A56D5842AD9")

    protected static final int APN_INVALID_ID = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.030 -0400", hash_original_field = "2B9BF7683605EAF175DA931B2453C34B", hash_generated_field = "0E77FDDEFB918A35BF053E79F738F079")

    protected static final int APN_DEFAULT_ID = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.030 -0400", hash_original_field = "F77BC24DF2981C4E95B36455ACB6486B", hash_generated_field = "3ADA7B63B367F670A9CD841236C2E69E")

    protected static final int APN_MMS_ID = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.030 -0400", hash_original_field = "3C9787C2DBFA045A02AB792A7D75AA5C", hash_generated_field = "52A680E6667112D0AD515B82C22E851A")

    protected static final int APN_SUPL_ID = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.030 -0400", hash_original_field = "8F0F2C37C7D84C099DD0B43F9FDCDFA3", hash_generated_field = "E098D6D391DC0AB0F915C3106B1695EE")

    protected static final int APN_DUN_ID = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.030 -0400", hash_original_field = "EB9E39BC107DAD1D743877FB20DCCCB8", hash_generated_field = "4EFC758C61F82DD345E0F30EFFBD676B")

    protected static final int APN_HIPRI_ID = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.030 -0400", hash_original_field = "12545285308557BFDAA8F96E516DDDE8", hash_generated_field = "A8AD07F881EB2DE54A81F6EF15DCAC2C")

    protected static final int APN_IMS_ID = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.030 -0400", hash_original_field = "B615EAB39E5F698FB19CEAF230D05419", hash_generated_field = "E8CEDAD872DD75AEF65EC837AB693137")

    protected static final int APN_FOTA_ID = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.030 -0400", hash_original_field = "69D4E9CA7F2362365E1DD82BCE01D5CD", hash_generated_field = "2B316B7447F9D669311A7A19EECFEA03")

    protected static final int APN_CBS_ID = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.030 -0400", hash_original_field = "AFC301CA9725EEF2D73B132667D7CF53", hash_generated_field = "964D3223C076E2C626C417466FDE0286")

    protected static final int APN_NUM_TYPES = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.030 -0400", hash_original_field = "E2CB925518CBBA02A412E4B68A43574E", hash_generated_field = "6F8C6ECFCCFDEEF8A111FB82FE45C371")

    public static final int DISABLED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.031 -0400", hash_original_field = "C25C0B236353087BD3025AC89A8C2385", hash_generated_field = "BBC106514DA50C961AB6371075708621")

    public static final int ENABLED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.031 -0400", hash_original_field = "F0FBA210FC19B517AD8DC129D7808481", hash_generated_field = "26D79596132C0495F601BE108CF49667")

    public static final String APN_TYPE_KEY = "apnType";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.031 -0400", hash_original_field = "739925A0F14EBFF741BB1F5884FF3580", hash_generated_field = "A249C37DD807D068C9799A3714E5C4B5")

    protected static final int APN_DELAY_MILLIS = SystemProperties.getInt("persist.radio.apn_delay", 5000);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.031 -0400", hash_original_field = "84BA753F9948A72584248DEA838B164E", hash_generated_field = "F1D5EAD411587599450F20AD6F0FCBFE")

    protected static boolean sPolicyDataEnabled = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.031 -0400", hash_original_field = "B25FE785B7CAF85E1007146F56D5AB24", hash_generated_field = "C8ABD15820F1BC36B2FC6FA2C5BBD57E")

    protected static final String DEFAULT_DATA_RETRY_CONFIG = "default_randomization=2000,"
        + "5000,10000,20000,40000,80000:5000,160000:5000,"
        + "320000:5000,640000:5000,1280000:5000,1800000:5000";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.031 -0400", hash_original_field = "DA3393F07AFE29A2E329689063E5B928", hash_generated_field = "93ECBE2CB5D3FA004037332587C4234E")

    protected static final String SECONDARY_DATA_RETRY_CONFIG = "max_retries=3, 5000, 5000, 5000";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.031 -0400", hash_original_field = "197214CA0C06EEB1EFD2EBEBA3CD4DA9", hash_generated_field = "3E24F8F476066918BB2F3B6D1406C0E2")

    protected static final int POLL_NETSTAT_SLOW_MILLIS = 5000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.031 -0400", hash_original_field = "AC32FF0F60419A93C046914FEEBAEA54", hash_generated_field = "1A0EC6E0BA46F24B4A2694596B6E436D")

    protected static final int DEFAULT_MAX_PDP_RESET_FAIL = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.031 -0400", hash_original_field = "21CD8419E3F89579DF90527399533BBC", hash_generated_field = "1FE39315059532779489F940B44B4D66")

    protected static final int NO_RECV_POLL_LIMIT = 24;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.031 -0400", hash_original_field = "382BAE9382F719FBCBB1A10D4BEFA72B", hash_generated_field = "0D9BF9729BE1A27BBD1BF62B3384AB80")

    protected static final int POLL_NETSTAT_MILLIS = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.031 -0400", hash_original_field = "923194288220D08DFF21E434BF1AEEEB", hash_generated_field = "D7453C2438D87CC283C407D0E80A8104")

    protected static final int POLL_NETSTAT_SCREEN_OFF_MILLIS = 1000*60*10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.031 -0400", hash_original_field = "D47AA84872A25D01DB68E62C67D0D911", hash_generated_field = "142733920ADC648E7F33CA58E902D9A6")

    protected static final int POLL_LONGEST_RTT = 120 * 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.031 -0400", hash_original_field = "1C3134829F1666190770E94993F178AE", hash_generated_field = "71AF96CD56F561EBA0B98AD3621CFF6F")

    protected static final int NUMBER_SENT_PACKETS_OF_HANG = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.031 -0400", hash_original_field = "29091498798DC27B881A4E06C3D0FEDD", hash_generated_field = "AC35FDCED05C1F4EE3D61BE8C1BC35EC")

    protected static final int RESTORE_DEFAULT_APN_DELAY = 1 * 60 * 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.031 -0400", hash_original_field = "58557858B2FE6F52EF658629982D3750", hash_generated_field = "2B8A79ACDC0B6FBDAD775768D652C83F")

    protected static final String APN_RESTORE_DELAY_PROP_NAME = "android.telephony.apn-restore";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.031 -0400", hash_original_field = "9703C98FBA4E5997D49E93A25FA145F2", hash_generated_field = "13B653D205F77F7600F4F13DC999F8B9")

    protected static final String NULL_IP = "0.0.0.0";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.031 -0400", hash_original_field = "EBD539F8084726EF894804EB18CFB02A", hash_generated_field = "0411F8BF5642AECCB6A41EFE99C246EE")

    protected static final int DATA_STALL_ALARM_DELAY_IN_MS_DEFAULT = 1000 * 60 * 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.031 -0400", hash_original_field = "15B313C114C8CFFC8BD65B40ED360948", hash_generated_field = "A2AEF5834159105DB4F070F129F7D147")

    protected static final int DATA_STALL_NO_RECV_POLL_LIMIT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.031 -0400", hash_original_field = "12CBEA904965DFA02EF67746239C8476", hash_generated_field = "D4EDDFEB958C1B822CA1719D4CF16D54")

    protected static final String DATA_STALL_ALARM_TAG_EXTRA = "data.stall.alram.tag";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.031 -0400", hash_original_field = "FB709D7A9A230E69736935B6387971ED", hash_generated_field = "94DA01920C98565C8DA456DFEAE26138")

    protected static final String INTENT_RECONNECT_ALARM_EXTRA_REASON = "reason";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.031 -0400", hash_original_field = "9027635A00312F40B47DC9E66AC4B555", hash_generated_field = "8DDF5BA451DF59B3F1183C984E43D77E")

    protected static final String INTENT_SET_FAIL_DATA_SETUP_COUNTER = "com.android.internal.telephony.dataconnectiontracker.intent_set_fail_data_setup_counter";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.031 -0400", hash_original_field = "E820771C597A7FF6FD625C84D8A897CC", hash_generated_field = "3B5E09F30CCEFBA257FF0FFD68EEC79D")

    protected static final String FAIL_DATA_SETUP_COUNTER = "fail_data_setup_counter";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.031 -0400", hash_original_field = "736E3CF86860D80581301BC5DA74308A", hash_generated_field = "E2E42CE52C5DCFF5C5FC00CE54B6B5F4")

    protected static final String FAIL_DATA_SETUP_FAIL_CAUSE = "fail_data_setup_fail_cause";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.031 -0400", hash_original_field = "D56A0C911051F3FEC75B7F4166DA0A41", hash_generated_field = "1A4684138A98FC97EFDBFAB38A208838")

    protected static final String DEFALUT_DATA_ON_BOOT_PROP = "net.def_data_on_boot";
}

