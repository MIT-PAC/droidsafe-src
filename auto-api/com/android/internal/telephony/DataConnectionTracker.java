package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.127 -0400", hash_original_field = "0C574BF34249141BA4157A2B3A13DF65", hash_generated_field = "35FA5A91B80F269D1DB9B36DE1EC65CA")

    protected Object mDataEnabledLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.127 -0400", hash_original_field = "83C02F715D848B29A8DCE10BED0E6E91", hash_generated_field = "029ADD06C51569E156E858EF56AC06DA")

    protected boolean mInternalDataEnabled = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.127 -0400", hash_original_field = "C50C8B8054B63CB49F8E494BC522CCEB", hash_generated_field = "68DF71977C4718650ADDCD81C2B1620F")

    protected boolean mUserDataEnabled = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.127 -0400", hash_original_field = "8BC574D28C89B1AA9EB1F52525413A33", hash_generated_field = "F49B5B07667CCB529520831482D9BAB1")

    private boolean[] dataEnabled = new boolean[APN_NUM_TYPES];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.127 -0400", hash_original_field = "4F4BB97BAFF6649F5948F3AEF5C5E004", hash_generated_field = "8420FF89B70ED10465A38AC8B70D9095")

    private int enabledCount = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.127 -0400", hash_original_field = "37622627749352C73B065DAEF77331F4", hash_generated_field = "4C2B2DCF407C9F63C855A59D9F29A37A")

    protected String mRequestedApnType = Phone.APN_TYPE_DEFAULT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.127 -0400", hash_original_field = "0B51F170940EEB2AE623BBE06DE8E32A", hash_generated_field = "1894211C4C78CAACE34F0DC8EE3A13C1")

    protected int mFailDataSetupCounter = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.127 -0400", hash_original_field = "75AAA2EE794A2614791655B02867656E", hash_generated_field = "EC29A5CA55085C10657861453E10B11C")

    protected FailCause mFailDataSetupFailCause = FailCause.ERROR_UNSPECIFIED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.127 -0400", hash_original_field = "44BC87C3198CFC247427A5305FDEA9BE", hash_generated_field = "C5284483C4CF8ED630A2E2607ED30E12")

    protected PhoneBase mPhone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.127 -0400", hash_original_field = "0F5A83CC88F3EE71F4066661CD2FB5D3", hash_generated_field = "5CE7295912ACD2604E7762D907339691")

    protected Activity mActivity = Activity.NONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.127 -0400", hash_original_field = "6C72EA28B063EE31BBEAC312EBCF2483", hash_generated_field = "CEA309476306FEF09638ED5ED829D6A1")

    protected State mState = State.IDLE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.127 -0400", hash_original_field = "C2ECAD1B16A6AC316391B5BD3F156E8F", hash_generated_field = "963D8F7E00CCB73CD43AA6DA0AE9DF2A")

    protected Handler mDataConnectionTracker = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.127 -0400", hash_original_field = "F07A7E8D1AE67A08367F6C717D5DE438", hash_generated_field = "C066AA046467E6BBB3EA5DDB129B3DB8")

    protected long mTxPkts;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.127 -0400", hash_original_field = "BC09E4210C29FFF34666B06F6307B4F2", hash_generated_field = "F031B0AD358C38347F225F90F75B03E4")

    protected long mRxPkts;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.127 -0400", hash_original_field = "E88A6F081F6EB811DC49E055A2D799F6", hash_generated_field = "D9D10A2C69888D907D9D54771B7DB2A5")

    protected int mNetStatPollPeriod;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.127 -0400", hash_original_field = "E3C4C2B3F35259439146CD5411F92DE0", hash_generated_field = "8AEC394E7895B11DB0C1B86A5A82BE9C")

    protected boolean mNetStatPollEnabled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.127 -0400", hash_original_field = "BF6EEADB4389844D7AA67B505D20D752", hash_generated_field = "B4F64D56417D37A4C51A5C74706E778F")

    protected TxRxSum mDataStallTxRxSum = new TxRxSum(0, 0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.127 -0400", hash_original_field = "3FFBAEFC9FD53A580EC601AC99081F9B", hash_generated_field = "922642510706D7E1F40906A8E67562E6")

    protected int mDataStallAlarmTag = (int) SystemClock.elapsedRealtime();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.127 -0400", hash_original_field = "3121E27D2FFCAB719F984045B26119F7", hash_generated_field = "3964C7D016D96B23E8A4F338B71B706B")

    protected PendingIntent mDataStallAlarmIntent = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.127 -0400", hash_original_field = "C9FDF2A5D3CD3973F122C86C6FBD0B48", hash_generated_field = "6467835C9ADB216F54C7DD6564D528DC")

    protected long mSentSinceLastRecv;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.127 -0400", hash_original_field = "113DA8858F130CCEA1AB8790322771B7", hash_generated_field = "34A070F678DFA34A23ADEF39527A564C")

    protected int mNoRecvPollCount = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.127 -0400", hash_original_field = "BA2632DCA63DFE3E80BE54C563DA3B60", hash_generated_field = "9A8B10322BB7B36EE6E7CC8062CC1FBF")

    protected boolean mIsWifiConnected = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.128 -0400", hash_original_field = "F624BA341CEE490E0F6E6147BBEFD20A", hash_generated_field = "12A1D0ED5463C3F1D91D57D8EA6A8B7B")

    protected PendingIntent mReconnectIntent = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.128 -0400", hash_original_field = "5C56A171AFF86F8C7A0A13B02C0B482D", hash_generated_field = "D5A8886EAF52251545AC3AD33951BCDD")

    protected int mCidActive;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.128 -0400", hash_original_field = "3F9BEBDB99B792833728E81C043D71E1", hash_generated_field = "520BD7D1996D720DF52FDD45FFE94136")

    protected boolean mAutoAttachOnCreation = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.128 -0400", hash_original_field = "144B8708956D2D49F2FD05BBF954A65B", hash_generated_field = "443F358D0A339820F2F3C7798BC25ADF")

    protected boolean mIsScreenOn = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.128 -0400", hash_original_field = "7F27308BF5E86222C75F05C218C928BE", hash_generated_field = "E7C2C970E82ACEA7CAE10990548181FE")

    protected AtomicInteger mUniqueIdGenerator = new AtomicInteger(0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.128 -0400", hash_original_field = "D307CBBB85DCF557505B4275470BF6F6", hash_generated_field = "F773E5340FE87B52017BDABC34CF0248")

    protected HashMap<Integer, DataConnection> mDataConnections = new HashMap<Integer, DataConnection>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.128 -0400", hash_original_field = "79D26F63DD5553FA40470C897E398B22", hash_generated_field = "22F5DEEB14FFD2F3D69D57FCCF0F9FB1")

    protected HashMap<Integer, DataConnectionAc> mDataConnectionAsyncChannels = new HashMap<Integer, DataConnectionAc>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.128 -0400", hash_original_field = "FA6C20B1FC2F2FE98FB6A402065CE910", hash_generated_field = "E1D4371B7D81B0ADAB75212C0682A1E6")

    protected HashMap<String, Integer> mApnToDataConnectionId = new HashMap<String, Integer>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.128 -0400", hash_original_field = "62B502403C74E21713DD7847EA23B4D5", hash_generated_field = "941E5870BFAF3D02817684E802B4207E")

    protected ConcurrentHashMap<String, ApnContext> mApnContexts;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.128 -0400", hash_original_field = "42B5BBFF6E953F5C723EB47B2978873F", hash_generated_field = "910D7E883F89F3141D476B143EF29779")

    protected ApnSetting mActiveApn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.128 -0400", hash_original_field = "F85E1B64E5CC97E2E68B558F4155CBA1", hash_generated_field = "D877191FC5F094158A904672156AA8C5")

    protected ArrayList<ApnSetting> mAllApns = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.128 -0400", hash_original_field = "229AC432B91972CC26BCF8C8ECBB4E35", hash_generated_field = "FC9CCB9D49A758A95E153C604DAFC1C3")

    protected ApnSetting mPreferredApn = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.128 -0400", hash_original_field = "0A981A794DB3A35FBC09ABB9C5C9D0C0", hash_generated_field = "B458E88DEC049EDD2472BF239226E4CB")

    protected boolean mIsPsRestricted = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.128 -0400", hash_original_field = "A0FC4D1A501D52A82344B1933DD703BB", hash_generated_field = "0421A765569015D55BB5FDAB22E936EA")

    protected boolean mIsDisposed = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.136 -0400", hash_original_field = "3DC9FC0A8AC52E83B9299E90E867B385", hash_generated_field = "5BA3D3EC1E27D0DE87B03445626CB9F0")

    protected BroadcastReceiver mIntentReceiver = new BroadcastReceiver() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.136 -0400", hash_original_method = "1961A46761D2A74B4BBC61E9BCC43068", hash_generated_method = "E7CD709C324C6B8C251471E851199F3D")
        @Override
        public void onReceive(Context context, Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            String action;
            action = intent.getAction();
            log("onReceive: action=" + action);
            {
                boolean var96145FA3EA33578069DB26D54E8F101D_879128997 = (action.equals(Intent.ACTION_SCREEN_ON));
                {
                    mIsScreenOn = true;
                    stopNetStatPoll();
                    startNetStatPoll();
                } //End block
                {
                    boolean var767BEBC8FC1BF29BC19AA771B91C30DC_1244191555 = (action.equals(Intent.ACTION_SCREEN_OFF));
                    {
                        mIsScreenOn = false;
                        stopNetStatPoll();
                        startNetStatPoll();
                    } //End block
                    {
                        boolean var657B0255569FEE532E29E31650D4768F_823562834 = (action.startsWith(getActionIntentReconnectAlarm()));
                        {
                            log("Reconnect alarm. Previous state was " + mState);
                            onActionIntentReconnectAlarm(intent);
                        } //End block
                        {
                            boolean var36F8FFF0AF59FF54D7904599A20B6C27_195004051 = (action.equals(getActionIntentDataStallAlarm()));
                            {
                                onActionIntentDataStallAlarm(intent);
                            } //End block
                            {
                                boolean varAEED26211C259A659D32D3D5886FD918_1626542736 = (action.equals(WifiManager.NETWORK_STATE_CHANGED_ACTION));
                                {
                                    android.net.NetworkInfo networkInfo;
                                    networkInfo = (NetworkInfo)
                        intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
                                    mIsWifiConnected = (networkInfo != null && networkInfo.isConnected());
                                } //End block
                                {
                                    boolean var63C3653546FDFD746F5A5E4F5D93A7DF_783233476 = (action.equals(WifiManager.WIFI_STATE_CHANGED_ACTION));
                                    {
                                        boolean enabled;
                                        enabled = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE,
                        WifiManager.WIFI_STATE_UNKNOWN) == WifiManager.WIFI_STATE_ENABLED;
                                        {
                                            mIsWifiConnected = false;
                                        } //End block
                                    } //End block
                                    {
                                        boolean varC1CD06FA6A7988C248E9A4EC09E1418D_1743694316 = (action.equals(INTENT_SET_FAIL_DATA_SETUP_COUNTER));
                                        {
                                            mFailDataSetupCounter = intent.getIntExtra(FAIL_DATA_SETUP_COUNTER, 1);
                                            mFailDataSetupFailCause = FailCause.fromInt(
                        intent.getIntExtra(FAIL_DATA_SETUP_FAIL_CAUSE,
                                                    FailCause.ERROR_UNSPECIFIED.getErrorCode()));
                                            log("set mFailDataSetupCounter=" + mFailDataSetupCounter +
                        " mFailDataSetupFailCause=" + mFailDataSetupFailCause);
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            addTaint(context.getTaint());
            addTaint(intent.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.136 -0400", hash_original_field = "8BDD1549FE3A70CEB234E0690EAEE942", hash_generated_field = "6D8A2CC8A7E85CEA15EFEA2E663FA6FC")

    private DataRoamingSettingObserver mDataRoamingSettingObserver;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.140 -0400", hash_original_method = "3BD12FD7917DD1B6F1FA4984E09C99CB", hash_generated_method = "B02C33393E2E1872D31684E1D49928C8")
    protected  DataConnectionTracker(PhoneBase phone) {
        super();
        mPhone = phone;
        IntentFilter filter;
        filter = new IntentFilter();
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
        SharedPreferences sp;
        sp = PreferenceManager.getDefaultSharedPreferences(mPhone.getContext());
        mAutoAttachOnCreation = sp.getBoolean(PhoneBase.DATA_DISABLED_ON_BOOT_KEY, false);
        mDataRoamingSettingObserver = new DataRoamingSettingObserver(mPhone);
        mDataRoamingSettingObserver.register(mPhone.getContext());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.151 -0400", hash_original_method = "C16C211E95AFFD72D353E5EF5692A650", hash_generated_method = "03F1B22E9C06C8C22E5DF7251615D6DB")
    protected boolean isDataSetupCompleteOk(AsyncResult ar) {
        {
            log("isDataSetupCompleteOk return false, ar.result=" + ar.result);
        } //End block
        {
            log("isDataSetupCompleteOk return true");
        } //End block
        ar.result = mFailDataSetupFailCause;
        {
            log("isDataSetupCompleteOk return false" +
                    " mFailDataSetupCounter=" + mFailDataSetupCounter +
                    " mFailDataSetupFailCause=" + mFailDataSetupFailCause);
        } //End block
        mFailDataSetupCounter -= 1;
        addTaint(ar.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1722388914 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1722388914;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.162 -0400", hash_original_method = "838D9E0EFB087A153045FCBAD3FD613D", hash_generated_method = "51851BAB7E999F8AEE462D05DABA3340")
    protected void onActionIntentReconnectAlarm(Intent intent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        String reason;
        reason = intent.getStringExtra(INTENT_RECONNECT_ALARM_EXTRA_REASON);
        {
            Message msg;
            msg = obtainMessage(EVENT_CLEAN_UP_CONNECTION);
            msg.arg1 = 0;
            msg.arg2 = 0;
            msg.obj = reason;
            sendMessage(msg);
        } //End block
        sendMessage(obtainMessage(EVENT_TRY_SETUP_DATA));
        addTaint(intent.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.163 -0400", hash_original_method = "A1F89C02319CA5D605879D459A1AC731", hash_generated_method = "6E9B3CAAF0C255011576F675208357B8")
    protected void onActionIntentDataStallAlarm(Intent intent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        log("onActionIntentDataStallAlarm: action=" + intent.getAction());
        Message msg;
        msg = obtainMessage(EVENT_DATA_STALL_ALARM, intent.getAction());
        msg.arg1 = intent.getIntExtra(DATA_STALL_ALARM_TAG_EXTRA, 0);
        sendMessage(msg);
        addTaint(intent.getTaint());
        // ---------- Original Method ----------
        //if (VDBG) log("onActionIntentDataStallAlarm: action=" + intent.getAction());
        //Message msg = obtainMessage(EVENT_DATA_STALL_ALARM, intent.getAction());
        //msg.arg1 = intent.getIntExtra(DATA_STALL_ALARM_TAG_EXTRA, 0);
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.185 -0400", hash_original_method = "D3ED6AC13F3F749DE4F1E160957198B8", hash_generated_method = "843FB6E0ED388E12E5700B18B6DD7923")
    public void dispose() {
        {
            Iterator<DataConnectionAc> varEB8626173DB084FB4853115B28BD3F62_658924224 = (mDataConnectionAsyncChannels.values()).iterator();
            varEB8626173DB084FB4853115B28BD3F62_658924224.hasNext();
            DataConnectionAc dcac = varEB8626173DB084FB4853115B28BD3F62_658924224.next();
            {
                dcac.disconnect();
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.186 -0400", hash_original_method = "DDDDA1A5545DB0A17ACC18101B011287", hash_generated_method = "0488109B2960F54AA95604FF69CA581E")
    protected void broadcastMessenger() {
        Intent intent;
        intent = new Intent(ACTION_DATA_CONNECTION_TRACKER_MESSENGER);
        intent.putExtra(EXTRA_MESSENGER, new Messenger(this));
        mPhone.getContext().sendBroadcast(intent);
        // ---------- Original Method ----------
        //Intent intent = new Intent(ACTION_DATA_CONNECTION_TRACKER_MESSENGER);
        //intent.putExtra(EXTRA_MESSENGER, new Messenger(this));
        //mPhone.getContext().sendBroadcast(intent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.187 -0400", hash_original_method = "3F17133E8D63AE8C7414DC58966291E3", hash_generated_method = "5DC89831CADF226152258F367EFAD926")
    public Activity getActivity() {
        Activity varB4EAC82CA7396A68D541C85D26508E83_791620860 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_791620860 = mActivity;
        varB4EAC82CA7396A68D541C85D26508E83_791620860.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_791620860;
        // ---------- Original Method ----------
        //return mActivity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.202 -0400", hash_original_method = "125099B58F8163C25EB6B1F0707923F4", hash_generated_method = "35FC49E1141C5F05900A8E93091CCE14")
    public boolean isApnTypeActive(String type) {
        {
            boolean var406626E19CADC2843874188E79EE9835_1334784108 = (Phone.APN_TYPE_DUN.equals(type));
            {
                ApnSetting dunApn;
                dunApn = fetchDunApn();
                {
                    boolean var4EA0CE97F3A12CE0F2A51BCC7C48DA8F_1797928234 = (((mActiveApn != null) && (dunApn.toString().equals(mActiveApn.toString()))));
                } //End block
            } //End block
        } //End collapsed parenthetic
        boolean var169544BDB9440CDE71D63DA907E8F9A7_2021330092 = (mActiveApn != null && mActiveApn.canHandleType(type));
        addTaint(type.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2068501341 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2068501341;
        // ---------- Original Method ----------
        //if (Phone.APN_TYPE_DUN.equals(type)) {
            //ApnSetting dunApn = fetchDunApn();
            //if (dunApn != null) {
                //return ((mActiveApn != null) && (dunApn.toString().equals(mActiveApn.toString())));
            //}
        //}
        //return mActiveApn != null && mActiveApn.canHandleType(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.203 -0400", hash_original_method = "616B5B126FC289B3EB6BE1030B710468", hash_generated_method = "27222533FA87EE97C9E53CBC390C8A11")
    protected ApnSetting fetchDunApn() {
        ApnSetting varB4EAC82CA7396A68D541C85D26508E83_1537156755 = null; //Variable for return #1
        ApnSetting varB4EAC82CA7396A68D541C85D26508E83_1828911651 = null; //Variable for return #2
        Context c;
        c = mPhone.getContext();
        String apnData;
        apnData = Settings.Secure.getString(c.getContentResolver(),
                Settings.Secure.TETHER_DUN_APN);
        ApnSetting dunSetting;
        dunSetting = ApnSetting.fromString(apnData);
        varB4EAC82CA7396A68D541C85D26508E83_1537156755 = dunSetting;
        apnData = c.getResources().getString(R.string.config_tether_apndata);
        varB4EAC82CA7396A68D541C85D26508E83_1828911651 = ApnSetting.fromString(apnData);
        ApnSetting varA7E53CE21691AB073D9660D615818899_1837551263; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1837551263 = varB4EAC82CA7396A68D541C85D26508E83_1537156755;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1837551263 = varB4EAC82CA7396A68D541C85D26508E83_1828911651;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1837551263.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1837551263;
        // ---------- Original Method ----------
        //Context c = mPhone.getContext();
        //String apnData = Settings.Secure.getString(c.getContentResolver(),
                //Settings.Secure.TETHER_DUN_APN);
        //ApnSetting dunSetting = ApnSetting.fromString(apnData);
        //if (dunSetting != null) return dunSetting;
        //apnData = c.getResources().getString(R.string.config_tether_apndata);
        //return ApnSetting.fromString(apnData);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.204 -0400", hash_original_method = "F0E40F922DBB5D19CCBEC497FB284EC5", hash_generated_method = "C4EF530673A10FDABD736B6A4F753AF2")
    public String[] getActiveApnTypes() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_753165605 = null; //Variable for return #1
        String[] result;
        {
            result = mActiveApn.types;
        } //End block
        {
            result = new String[1];
            result[0] = Phone.APN_TYPE_DEFAULT;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_753165605 = result;
        varB4EAC82CA7396A68D541C85D26508E83_753165605.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_753165605;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.204 -0400", hash_original_method = "8A278F7563F3F2CC899D3E200DD135CD", hash_generated_method = "B280EEE8E714CED0214C0F688BBEDDF6")
    public String getActiveApnString(String apnType) {
        String varB4EAC82CA7396A68D541C85D26508E83_700591245 = null; //Variable for return #1
        String result;
        result = null;
        {
            result = mActiveApn.apn;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_700591245 = result;
        addTaint(apnType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_700591245.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_700591245;
        // ---------- Original Method ----------
        //String result = null;
        //if (mActiveApn != null) {
            //result = mActiveApn.apn;
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.206 -0400", hash_original_method = "B18C74BBD4D71B87D6CD20822DAEB60C", hash_generated_method = "D5EC2E25D40A22F098EA183DDAD883B4")
    public void setDataOnRoamingEnabled(boolean enabled) {
        {
            boolean varB54F03CDB64176FFCB855FF42639A95B_424787899 = (getDataOnRoamingEnabled() != enabled);
            {
                ContentResolver resolver;
                resolver = mPhone.getContext().getContentResolver();
                Settings.Secure.putInt(resolver, Settings.Secure.DATA_ROAMING, enabled ? 1 : 0);
            } //End block
        } //End collapsed parenthetic
        addTaint(enabled);
        // ---------- Original Method ----------
        //if (getDataOnRoamingEnabled() != enabled) {
            //final ContentResolver resolver = mPhone.getContext().getContentResolver();
            //Settings.Secure.putInt(resolver, Settings.Secure.DATA_ROAMING, enabled ? 1 : 0);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.206 -0400", hash_original_method = "CA847DB1E96260749F912EC65B12A685", hash_generated_method = "D630E86F9841BB44743208A5927BF13E")
    public boolean getDataOnRoamingEnabled() {
        try 
        {
            ContentResolver resolver;
            resolver = mPhone.getContext().getContentResolver();
            boolean varE702C72B406FC62334614256CE642190_1140491747 = (Settings.Secure.getInt(resolver, Settings.Secure.DATA_ROAMING) != 0);
        } //End block
        catch (SettingNotFoundException snfe)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1947666111 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1947666111;
        // ---------- Original Method ----------
        //try {
            //final ContentResolver resolver = mPhone.getContext().getContentResolver();
            //return Settings.Secure.getInt(resolver, Settings.Secure.DATA_ROAMING) != 0;
        //} catch (SettingNotFoundException snfe) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.206 -0400", hash_original_method = "D53421F789432FAA1BE4F347AFB92C88", hash_generated_method = "F1A0FF17ADE996444E0F933195755BE5")
    private void handleDataOnRoamingChange() {
        {
            boolean var1B4EADABCFD05CFDD8C3D1EDB2CE784D_1504967739 = (mPhone.getServiceState().getRoaming());
            {
                {
                    boolean var83E97FA6F6D360AB5803CC641FB0388C_614365609 = (getDataOnRoamingEnabled());
                    {
                        resetAllRetryCounts();
                    } //End block
                } //End collapsed parenthetic
                sendMessage(obtainMessage(EVENT_ROAMING_ON));
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.228 -0400", hash_original_method = "664FE2A04A36F386D94369A328F3D0AD", hash_generated_method = "368AA79B71AFC1B597C36A9C40401089")
    protected void onDataStallAlarm(int tag) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        loge("onDataStallAlarm: not impleted tag=" + tag);
        addTaint(tag);
        // ---------- Original Method ----------
        //loge("onDataStallAlarm: not impleted tag=" + tag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.229 -0400", hash_original_method = "F3EE7F03AAF60471D3A97F562455D5DC", hash_generated_method = "B0ED4C39C33CAEB4D066B6DE663A2C55")
    @Override
    public void handleMessage(Message msg) {
        //Begin case AsyncChannel.CMD_CHANNEL_DISCONNECTED 
        {
            log("DISCONNECTED_CONNECTED: msg=" + msg);
            DataConnectionAc dcac;
            dcac = (DataConnectionAc) msg.obj;
            mDataConnectionAsyncChannels.remove(dcac.dataConnection.getDataConnectionId());
            dcac.disconnected();
        } //End block
        //End case AsyncChannel.CMD_CHANNEL_DISCONNECTED 
        //Begin case EVENT_ENABLE_NEW_APN 
        onEnableApn(msg.arg1, msg.arg2);
        //End case EVENT_ENABLE_NEW_APN 
        //Begin case EVENT_TRY_SETUP_DATA 
        String reason;
        reason = null;
        //End case EVENT_TRY_SETUP_DATA 
        //Begin case EVENT_TRY_SETUP_DATA 
        {
            reason = (String) msg.obj;
        } //End block
        //End case EVENT_TRY_SETUP_DATA 
        //Begin case EVENT_TRY_SETUP_DATA 
        onTrySetupData(reason);
        //End case EVENT_TRY_SETUP_DATA 
        //Begin case EVENT_DATA_STALL_ALARM 
        onDataStallAlarm(msg.arg1);
        //End case EVENT_DATA_STALL_ALARM 
        //Begin case EVENT_ROAMING_OFF 
        {
            boolean var6A4EDF3FAFEE8B58E0E885094E7C645E_605089034 = (getDataOnRoamingEnabled() == false);
            {
                resetAllRetryCounts();
            } //End block
        } //End collapsed parenthetic
        //End case EVENT_ROAMING_OFF 
        //Begin case EVENT_ROAMING_OFF 
        onRoamingOff();
        //End case EVENT_ROAMING_OFF 
        //Begin case EVENT_ROAMING_ON 
        onRoamingOn();
        //End case EVENT_ROAMING_ON 
        //Begin case EVENT_RADIO_AVAILABLE 
        onRadioAvailable();
        //End case EVENT_RADIO_AVAILABLE 
        //Begin case EVENT_RADIO_OFF_OR_NOT_AVAILABLE 
        onRadioOffOrNotAvailable();
        //End case EVENT_RADIO_OFF_OR_NOT_AVAILABLE 
        //Begin case EVENT_DATA_SETUP_COMPLETE 
        mCidActive = msg.arg1;
        //End case EVENT_DATA_SETUP_COMPLETE 
        //Begin case EVENT_DATA_SETUP_COMPLETE 
        onDataSetupComplete((AsyncResult) msg.obj);
        //End case EVENT_DATA_SETUP_COMPLETE 
        //Begin case EVENT_DISCONNECT_DONE 
        log("DataConnectoinTracker.handleMessage: EVENT_DISCONNECT_DONE msg=" + msg);
        //End case EVENT_DISCONNECT_DONE 
        //Begin case EVENT_DISCONNECT_DONE 
        onDisconnectDone(msg.arg1, (AsyncResult) msg.obj);
        //End case EVENT_DISCONNECT_DONE 
        //Begin case EVENT_VOICE_CALL_STARTED 
        onVoiceCallStarted();
        //End case EVENT_VOICE_CALL_STARTED 
        //Begin case EVENT_VOICE_CALL_ENDED 
        onVoiceCallEnded();
        //End case EVENT_VOICE_CALL_ENDED 
        //Begin case EVENT_CLEAN_UP_ALL_CONNECTIONS 
        {
            onCleanUpAllConnections((String) msg.obj);
        } //End block
        //End case EVENT_CLEAN_UP_ALL_CONNECTIONS 
        //Begin case EVENT_CLEAN_UP_CONNECTION 
        {
            boolean tearDown;
            tearDown = false;
            tearDown = true;
            onCleanUpConnection(tearDown, msg.arg2, (String) msg.obj);
        } //End block
        //End case EVENT_CLEAN_UP_CONNECTION 
        //Begin case EVENT_SET_INTERNAL_DATA_ENABLE 
        {
            boolean enabled;
            enabled = true;
            enabled = false;
            onSetInternalDataEnabled(enabled);
        } //End block
        //End case EVENT_SET_INTERNAL_DATA_ENABLE 
        //Begin case EVENT_RESET_DONE 
        {
            log("EVENT_RESET_DONE");
            onResetDone((AsyncResult) msg.obj);
        } //End block
        //End case EVENT_RESET_DONE 
        //Begin case CMD_SET_USER_DATA_ENABLE 
        {
            boolean enabled;
            enabled = true;
            enabled = false;
            log("CMD_SET_USER_DATA_ENABLE enabled=" + enabled);
            onSetUserDataEnabled(enabled);
        } //End block
        //End case CMD_SET_USER_DATA_ENABLE 
        //Begin case CMD_SET_DEPENDENCY_MET 
        {
            boolean met;
            met = true;
            met = false;
            log("CMD_SET_DEPENDENCY_MET met=" + met);
            Bundle bundle;
            bundle = msg.getData();
            {
                String apnType;
                apnType = (String)bundle.get(APN_TYPE_KEY);
                {
                    onSetDependencyMet(apnType, met);
                } //End block
            } //End block
        } //End block
        //End case CMD_SET_DEPENDENCY_MET 
        //Begin case CMD_SET_POLICY_DATA_ENABLE 
        {
            boolean enabled;
            enabled = true;
            enabled = false;
            onSetPolicyDataEnabled(enabled);
        } //End block
        //End case CMD_SET_POLICY_DATA_ENABLE 
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.230 -0400", hash_original_method = "8F4FE806494E709DA803471FC4054850", hash_generated_method = "2A0135BF08DD58E437EBA75568379924")
    public boolean getAnyDataEnabled() {
        boolean result;
        {
            result = (mInternalDataEnabled && mUserDataEnabled && sPolicyDataEnabled
                    && (enabledCount != 0));
        } //End block
        log("getAnyDataEnabled " + result);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1893388950 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1893388950;
        // ---------- Original Method ----------
        //final boolean result;
        //synchronized (mDataEnabledLock) {
            //result = (mInternalDataEnabled && mUserDataEnabled && sPolicyDataEnabled
                    //&& (enabledCount != 0));
        //}
        //if (!result && DBG) log("getAnyDataEnabled " + result);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.239 -0400", hash_original_method = "01BBE084CAD104CD5BF824EF92BD879D", hash_generated_method = "747656044DD5E4499487A341D78E33FA")
    protected boolean isEmergency() {
        boolean result;
        {
            result = mPhone.isInEcm() || mPhone.isInEmergencyCall();
        } //End block
        log("isEmergency: result=" + result);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1065995232 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1065995232;
        // ---------- Original Method ----------
        //final boolean result;
        //synchronized (mDataEnabledLock) {
            //result = mPhone.isInEcm() || mPhone.isInEmergencyCall();
        //}
        //log("isEmergency: result=" + result);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.244 -0400", hash_original_method = "5D23D8F3C80DDDEC0087C53C5035314E", hash_generated_method = "A8586F3AA9DCBC330D0E1E9CB4CE4E2B")
    protected int apnTypeToId(String type) {
        {
            boolean var309D3C860D69C9DD812B86CF681881B6_1633343172 = (TextUtils.equals(type, Phone.APN_TYPE_DEFAULT));
            {
                boolean var5A453EEDD3E3976BB49C9508291B2AF1_1834945538 = (TextUtils.equals(type, Phone.APN_TYPE_MMS));
                {
                    boolean var3CE0D478E88EB81F167085762129B382_1546735080 = (TextUtils.equals(type, Phone.APN_TYPE_SUPL));
                    {
                        boolean varF95EB5896A1FFC653B2B4EDAB9BA81D0_1998253260 = (TextUtils.equals(type, Phone.APN_TYPE_DUN));
                        {
                            boolean var869DCC811C6B09B9BEDB01CBDB8E3BB8_896977797 = (TextUtils.equals(type, Phone.APN_TYPE_HIPRI));
                            {
                                boolean var6BF0B7241C25AB8D91947F3EF585FCE9_475385863 = (TextUtils.equals(type, Phone.APN_TYPE_IMS));
                                {
                                    boolean var87D249D8144B57A4B6191CE038D7E433_1513795224 = (TextUtils.equals(type, Phone.APN_TYPE_FOTA));
                                    {
                                        boolean var14F7602C7EF2A0501FF08693C56BFA7B_89193954 = (TextUtils.equals(type, Phone.APN_TYPE_CBS));
                                    } //End collapsed parenthetic
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        addTaint(type.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1265253774 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1265253774;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.250 -0400", hash_original_method = "C8FDA5A0B2174A5D621C26D6E6AEF75F", hash_generated_method = "46FEDA8A28020A04D2AD7C4502562ACE")
    protected String apnIdToType(int id) {
        String varB4EAC82CA7396A68D541C85D26508E83_890454328 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1379956490 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_2138097148 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_283269030 = null; //Variable for return #4
        String varB4EAC82CA7396A68D541C85D26508E83_480005363 = null; //Variable for return #5
        String varB4EAC82CA7396A68D541C85D26508E83_2006307105 = null; //Variable for return #6
        String varB4EAC82CA7396A68D541C85D26508E83_1002913476 = null; //Variable for return #7
        String varB4EAC82CA7396A68D541C85D26508E83_1913573216 = null; //Variable for return #8
        String varB4EAC82CA7396A68D541C85D26508E83_3303107 = null; //Variable for return #9
        //Begin case APN_DEFAULT_ID 
        varB4EAC82CA7396A68D541C85D26508E83_890454328 = Phone.APN_TYPE_DEFAULT;
        //End case APN_DEFAULT_ID 
        //Begin case APN_MMS_ID 
        varB4EAC82CA7396A68D541C85D26508E83_1379956490 = Phone.APN_TYPE_MMS;
        //End case APN_MMS_ID 
        //Begin case APN_SUPL_ID 
        varB4EAC82CA7396A68D541C85D26508E83_2138097148 = Phone.APN_TYPE_SUPL;
        //End case APN_SUPL_ID 
        //Begin case APN_DUN_ID 
        varB4EAC82CA7396A68D541C85D26508E83_283269030 = Phone.APN_TYPE_DUN;
        //End case APN_DUN_ID 
        //Begin case APN_HIPRI_ID 
        varB4EAC82CA7396A68D541C85D26508E83_480005363 = Phone.APN_TYPE_HIPRI;
        //End case APN_HIPRI_ID 
        //Begin case APN_IMS_ID 
        varB4EAC82CA7396A68D541C85D26508E83_2006307105 = Phone.APN_TYPE_IMS;
        //End case APN_IMS_ID 
        //Begin case APN_FOTA_ID 
        varB4EAC82CA7396A68D541C85D26508E83_1002913476 = Phone.APN_TYPE_FOTA;
        //End case APN_FOTA_ID 
        //Begin case APN_CBS_ID 
        varB4EAC82CA7396A68D541C85D26508E83_1913573216 = Phone.APN_TYPE_CBS;
        //End case APN_CBS_ID 
        //Begin case default 
        log("Unknown id (" + id + ") in apnIdToType");
        //End case default 
        //Begin case default 
        varB4EAC82CA7396A68D541C85D26508E83_3303107 = Phone.APN_TYPE_DEFAULT;
        //End case default 
        addTaint(id);
        String varA7E53CE21691AB073D9660D615818899_1495848142; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1495848142 = varB4EAC82CA7396A68D541C85D26508E83_890454328;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1495848142 = varB4EAC82CA7396A68D541C85D26508E83_1379956490;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1495848142 = varB4EAC82CA7396A68D541C85D26508E83_2138097148;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1495848142 = varB4EAC82CA7396A68D541C85D26508E83_283269030;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_1495848142 = varB4EAC82CA7396A68D541C85D26508E83_480005363;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_1495848142 = varB4EAC82CA7396A68D541C85D26508E83_2006307105;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_1495848142 = varB4EAC82CA7396A68D541C85D26508E83_1002913476;
                break;
            case 8: //Assign result for return ordinal #8
                varA7E53CE21691AB073D9660D615818899_1495848142 = varB4EAC82CA7396A68D541C85D26508E83_1913573216;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1495848142 = varB4EAC82CA7396A68D541C85D26508E83_3303107;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1495848142.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1495848142;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.251 -0400", hash_original_method = "C93C3112872052D96A1B607494195947", hash_generated_method = "D8E44D4F2B5C9E49216223E99BF38A62")
    protected LinkProperties getLinkProperties(String apnType) {
        LinkProperties varB4EAC82CA7396A68D541C85D26508E83_1185757009 = null; //Variable for return #1
        LinkProperties varB4EAC82CA7396A68D541C85D26508E83_307009977 = null; //Variable for return #2
        int id;
        id = apnTypeToId(apnType);
        {
            boolean var3B28DF70088D079134A00EB30AD60CE7_918506546 = (isApnIdEnabled(id));
            {
                DataConnectionAc dcac;
                dcac = mDataConnectionAsyncChannels.get(0);
                varB4EAC82CA7396A68D541C85D26508E83_1185757009 = dcac.getLinkPropertiesSync();
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_307009977 = new LinkProperties();
            } //End block
        } //End collapsed parenthetic
        addTaint(apnType.getTaint());
        LinkProperties varA7E53CE21691AB073D9660D615818899_1719530083; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1719530083 = varB4EAC82CA7396A68D541C85D26508E83_1185757009;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1719530083 = varB4EAC82CA7396A68D541C85D26508E83_307009977;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1719530083.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1719530083;
        // ---------- Original Method ----------
        //int id = apnTypeToId(apnType);
        //if (isApnIdEnabled(id)) {
            //DataConnectionAc dcac = mDataConnectionAsyncChannels.get(0);
            //return dcac.getLinkPropertiesSync();
        //} else {
            //return new LinkProperties();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.252 -0400", hash_original_method = "8B34AF8E1FD52F7524E0692F560388F1", hash_generated_method = "5D7C82FD81B41CBB5FDF3A08FB595C82")
    protected LinkCapabilities getLinkCapabilities(String apnType) {
        LinkCapabilities varB4EAC82CA7396A68D541C85D26508E83_912106174 = null; //Variable for return #1
        LinkCapabilities varB4EAC82CA7396A68D541C85D26508E83_1950109791 = null; //Variable for return #2
        int id;
        id = apnTypeToId(apnType);
        {
            boolean var3B28DF70088D079134A00EB30AD60CE7_1462425411 = (isApnIdEnabled(id));
            {
                DataConnectionAc dcac;
                dcac = mDataConnectionAsyncChannels.get(0);
                varB4EAC82CA7396A68D541C85D26508E83_912106174 = dcac.getLinkCapabilitiesSync();
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1950109791 = new LinkCapabilities();
            } //End block
        } //End collapsed parenthetic
        addTaint(apnType.getTaint());
        LinkCapabilities varA7E53CE21691AB073D9660D615818899_1635437945; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1635437945 = varB4EAC82CA7396A68D541C85D26508E83_912106174;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1635437945 = varB4EAC82CA7396A68D541C85D26508E83_1950109791;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1635437945.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1635437945;
        // ---------- Original Method ----------
        //int id = apnTypeToId(apnType);
        //if (isApnIdEnabled(id)) {
            //DataConnectionAc dcac = mDataConnectionAsyncChannels.get(0);
            //return dcac.getLinkCapabilitiesSync();
        //} else {
            //return new LinkCapabilities();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.254 -0400", hash_original_method = "EA8A5478D5AABF3FA098569BF99381B3", hash_generated_method = "C0BE0545466A380794E97635A817E5B4")
    protected void notifyDataConnection(String reason) {
        {
            int id;
            id = 0;
            {
                {
                    mPhone.notifyDataConnection(reason, apnIdToType(id));
                } //End block
            } //End block
        } //End collapsed parenthetic
        notifyOffApnsOfAvailability(reason);
        addTaint(reason.getTaint());
        // ---------- Original Method ----------
        //for (int id = 0; id < APN_NUM_TYPES; id++) {
            //if (dataEnabled[id]) {
                //mPhone.notifyDataConnection(reason, apnIdToType(id));
            //}
        //}
        //notifyOffApnsOfAvailability(reason);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.260 -0400", hash_original_method = "0EE2FD1B724C501D31FB7072BBECFF7B", hash_generated_method = "E30A6CAE292CB4DEA031278662F3D64B")
    private void notifyApnIdUpToCurrent(String reason, int apnId) {
        //Begin case CONNECTING SCANNING 
        mPhone.notifyDataConnection(reason, apnIdToType(apnId), Phone.DataState.CONNECTING);
        //End case CONNECTING SCANNING 
        //Begin case CONNECTED DISCONNECTING 
        mPhone.notifyDataConnection(reason, apnIdToType(apnId), Phone.DataState.CONNECTING);
        //End case CONNECTED DISCONNECTING 
        //Begin case CONNECTED DISCONNECTING 
        mPhone.notifyDataConnection(reason, apnIdToType(apnId), Phone.DataState.CONNECTED);
        //End case CONNECTED DISCONNECTING 
        addTaint(reason.getTaint());
        addTaint(apnId);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.261 -0400", hash_original_method = "D45BD11E51C479A3FCCFFBAFE72F463B", hash_generated_method = "79FB756811C49BCC65CD01118A350E00")
    private void notifyApnIdDisconnected(String reason, int apnId) {
        mPhone.notifyDataConnection(reason, apnIdToType(apnId), Phone.DataState.DISCONNECTED);
        addTaint(reason.getTaint());
        addTaint(apnId);
        // ---------- Original Method ----------
        //mPhone.notifyDataConnection(reason, apnIdToType(apnId), Phone.DataState.DISCONNECTED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.261 -0400", hash_original_method = "AD67DC7D8E779758CC2EF151B8EB9A25", hash_generated_method = "B8A4B9E84D5DEFA64CBC597B7918947B")
    protected void notifyOffApnsOfAvailability(String reason) {
        log("notifyOffApnsOfAvailability - reason= " + reason);
        {
            int id;
            id = 0;
            {
                {
                    boolean var4E5CD2F83AC285F39052DC55CB4A94E1_109828855 = (!isApnIdEnabled(id));
                    {
                        notifyApnIdDisconnected(reason, id);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(reason.getTaint());
        // ---------- Original Method ----------
        //if (DBG) log("notifyOffApnsOfAvailability - reason= " + reason);
        //for (int id = 0; id < APN_NUM_TYPES; id++) {
            //if (!isApnIdEnabled(id)) {
                //notifyApnIdDisconnected(reason, id);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.262 -0400", hash_original_method = "8B5C5B568EA76224959243C3FA291570", hash_generated_method = "4B1C0636445B3CFF9083545AEF4FFCC1")
    public boolean isApnTypeEnabled(String apnType) {
        {
            boolean varCF600E2D886E7589A9F5438BC08F9D5E_108440680 = (isApnIdEnabled(apnTypeToId(apnType)));
        } //End block
        addTaint(apnType.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_999594359 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_999594359;
        // ---------- Original Method ----------
        //if (apnType == null) {
            //return false;
        //} else {
            //return isApnIdEnabled(apnTypeToId(apnType));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.262 -0400", hash_original_method = "453A43A7EADEB97159250F7F1E9B04E5", hash_generated_method = "4D234D78DAB232358A4A26C429BEF2C2")
    protected synchronized boolean isApnIdEnabled(int id) {
        addTaint(id);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1194446147 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1194446147;
        // ---------- Original Method ----------
        //if (id != APN_INVALID_ID) {
            //return dataEnabled[id];
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.269 -0400", hash_original_method = "B518CE0EFC616BFFCBE5135F2BCA33B7", hash_generated_method = "6C20FE7442C7217CD8E5DE546A500E53")
    public synchronized int enableApnType(String type) {
        int id;
        id = apnTypeToId(type);
        {
            log("enableApnType(" + type + "), isApnTypeActive = " + isApnTypeActive(type)
                    + ", isApnIdEnabled =" + isApnIdEnabled(id) + " and state = " + mState);
        } //End block
        {
            boolean varA853C8852E4D73E41EF53078A12AEAC4_825707380 = (!isApnTypeAvailable(type));
            {
                log("type not available");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var3B28DF70088D079134A00EB30AD60CE7_2066985862 = (isApnIdEnabled(id));
            {
                setEnabled(id, true);
            } //End block
        } //End collapsed parenthetic
        addTaint(type.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1863760209 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1863760209;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.271 -0400", hash_original_method = "A5E4EE0A9C6812357B5B6B8F3C042D82", hash_generated_method = "67BBDB32B6C6B4AB01D7AD01DA34DBAD")
    public synchronized int disableApnType(String type) {
        log("disableApnType(" + type + ")");
        int id;
        id = apnTypeToId(type);
        {
            boolean var3B28DF70088D079134A00EB30AD60CE7_252149326 = (isApnIdEnabled(id));
            {
                setEnabled(id, false);
                {
                    boolean var4038903CF6895B879BB8F22E571F633C_1443134408 = (isApnTypeActive(Phone.APN_TYPE_DEFAULT));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(type.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2017924691 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2017924691;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.275 -0400", hash_original_method = "25F13BA52E496C8972985CBEE5B69F23", hash_generated_method = "CE01BDF04C6C500D7AD4D71A895B28E2")
    protected void setEnabled(int id, boolean enable) {
        {
            log("setEnabled(" + id + ", " + enable + ") with old state = " + dataEnabled[id]
                    + " and enabledCount = " + enabledCount);
        } //End block
        Message msg;
        msg = obtainMessage(EVENT_ENABLE_NEW_APN);
        msg.arg1 = id;
        msg.arg2 = (enable ? ENABLED : DISABLED);
        sendMessage(msg);
        addTaint(id);
        addTaint(enable);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.285 -0400", hash_original_method = "6346C217AE811F98B5143DCE05848411", hash_generated_method = "42AA87E0CD986939F5B326B376DB4A83")
    protected void onEnableApn(int apnId, int enabled) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            log("EVENT_APN_ENABLE_REQUEST apnId=" + apnId + ", apnType=" + apnIdToType(apnId) +
                    ", enabled=" + enabled + ", dataEnabled = " + dataEnabled[apnId] +
                    ", enabledCount = " + enabledCount + ", isApnTypeActive = " +
                    isApnTypeActive(apnIdToType(apnId)));
        } //End block
        {
            {
                {
                    dataEnabled[apnId] = true;
                } //End block
            } //End block
            String type;
            type = apnIdToType(apnId);
            {
                boolean varF392DA59AED5AF7339423DB9E4235404_949329488 = (!isApnTypeActive(type));
                {
                    mRequestedApnType = type;
                    onEnableNewApn();
                } //End block
                {
                    notifyApnIdUpToCurrent(Phone.REASON_APN_SWITCHED, apnId);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean didDisable;
            didDisable = false;
            {
                {
                    dataEnabled[apnId] = false;
                    didDisable = true;
                } //End block
            } //End block
            {
                onCleanUpConnection(true, apnId, Phone.REASON_DATA_DISABLED);
                notifyApnIdDisconnected(Phone.REASON_DATA_DISABLED, apnId);
                {
                    boolean var77362D34A9ADAA4D41EE076EC20EEB8C_583704271 = (dataEnabled[APN_DEFAULT_ID] == true
                        && !isApnTypeActive(Phone.APN_TYPE_DEFAULT));
                    {
                        mRequestedApnType = Phone.APN_TYPE_DEFAULT;
                        onEnableNewApn();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        addTaint(enabled);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.290 -0400", hash_original_method = "FBAA4A80E4538BA497646C5AED60D911", hash_generated_method = "32D68D2D8870859115DE7BFCF2679FE7")
    protected void onEnableNewApn() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.291 -0400", hash_original_method = "58B3A2A4D2FF1B49B3A412CB94198F76", hash_generated_method = "C3F1A1C1BF3F233C84574E50CB1C5BEC")
    protected void onResetDone(AsyncResult ar) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        log("EVENT_RESET_DONE");
        String reason;
        reason = null;
        {
            reason = (String) ar.userObj;
        } //End block
        gotoIdleAndNotifyDataConnection(reason);
        addTaint(ar.getTaint());
        // ---------- Original Method ----------
        //if (DBG) log("EVENT_RESET_DONE");
        //String reason = null;
        //if (ar.userObj instanceof String) {
            //reason = (String) ar.userObj;
        //}
        //gotoIdleAndNotifyDataConnection(reason);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.294 -0400", hash_original_method = "DE9C8D1FA305A86440711210D5CC0DFB", hash_generated_method = "EC14D5F1CC5F93F87AE50DE7874844C3")
    public boolean setInternalDataEnabled(boolean enable) {
        log("setInternalDataEnabled(" + enable + ")");
        Message msg;
        msg = obtainMessage(EVENT_SET_INTERNAL_DATA_ENABLE);
        msg.arg1 = (enable ? ENABLED : DISABLED);
        sendMessage(msg);
        addTaint(enable);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_847165383 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_847165383;
        // ---------- Original Method ----------
        //if (DBG)
            //log("setInternalDataEnabled(" + enable + ")");
        //Message msg = obtainMessage(EVENT_SET_INTERNAL_DATA_ENABLE);
        //msg.arg1 = (enable ? ENABLED : DISABLED);
        //sendMessage(msg);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.300 -0400", hash_original_method = "2FFC27FC9820E2F3BAEE3098A222A5B3", hash_generated_method = "17E0658898110411B3A57C927D045245")
    protected void onSetInternalDataEnabled(boolean enabled) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            mInternalDataEnabled = enabled;
            {
                log("onSetInternalDataEnabled: changed to enabled, try to setup data call");
                resetAllRetryCounts();
                onTrySetupData(Phone.REASON_DATA_ENABLED);
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.301 -0400", hash_original_method = "68E67092B4266000A5BC48E8C37B6ED2", hash_generated_method = "41C840E052EAD05661F790915BEDAE3C")
    public void cleanUpAllConnections(String cause) {
        Message msg;
        msg = obtainMessage(EVENT_CLEAN_UP_ALL_CONNECTIONS);
        msg.obj = cause;
        sendMessage(msg);
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
        //Message msg = obtainMessage(EVENT_CLEAN_UP_ALL_CONNECTIONS);
        //msg.obj = cause;
        //sendMessage(msg);
    }

    
    public abstract boolean isDisconnected();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.305 -0400", hash_original_method = "49C3C07E31C3EAA572D4F39FF0B691FA", hash_generated_method = "C7A42AC09BBE4A8B5707BCD41D7D2B0B")
    protected void onSetUserDataEnabled(boolean enabled) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean prevEnabled;
            prevEnabled = getAnyDataEnabled();
            {
                mUserDataEnabled = enabled;
                Settings.Secure.putInt(mPhone.getContext().getContentResolver(),
                        Settings.Secure.MOBILE_DATA, enabled ? 1 : 0);
                {
                    boolean varE966989352CF1A89B6BCE35C2FF5420E_1599687681 = (prevEnabled != getAnyDataEnabled());
                    {
                        {
                            resetAllRetryCounts();
                            onTrySetupData(Phone.REASON_DATA_ENABLED);
                        } //End block
                        {
                            onCleanUpAllConnections(Phone.REASON_DATA_DISABLED);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.305 -0400", hash_original_method = "CE2949FE6361D634BBA79ED70CC5EAE2", hash_generated_method = "2FE2F2DA1817B656777C8A5B772A6D15")
    protected void onSetDependencyMet(String apnType, boolean met) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(apnType.getTaint());
        addTaint(met);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.306 -0400", hash_original_method = "5C2A966CAC36731C633B25393BAF4799", hash_generated_method = "570679A69B090FE58126EFA6382D3C20")
    protected void onSetPolicyDataEnabled(boolean enabled) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean prevEnabled;
            prevEnabled = getAnyDataEnabled();
            {
                sPolicyDataEnabled = enabled;
                {
                    boolean varE966989352CF1A89B6BCE35C2FF5420E_331940036 = (prevEnabled != getAnyDataEnabled());
                    {
                        {
                            resetAllRetryCounts();
                            onTrySetupData(Phone.REASON_DATA_ENABLED);
                        } //End block
                        {
                            onCleanUpAllConnections(Phone.REASON_DATA_DISABLED);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        addTaint(enabled);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.307 -0400", hash_original_method = "E5EFA23236CE13ACC69B88C6F16F1B0C", hash_generated_method = "41C035DBD631783CF560DD3E302F31E3")
    protected String getReryConfig(boolean forDefault) {
        String varB4EAC82CA7396A68D541C85D26508E83_1787892429 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_958905014 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_2090266447 = null; //Variable for return #3
        int rt;
        rt = mPhone.getServiceState().getRadioTechnology();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1787892429 = SystemProperties.get("ro.cdma.data_retry_config");
        } //End block
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_958905014 = SystemProperties.get("ro.gsm.data_retry_config");
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_2090266447 = SystemProperties.get("ro.gsm.2nd_data_retry_config");
            } //End block
        } //End block
        addTaint(forDefault);
        String varA7E53CE21691AB073D9660D615818899_267266236; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_267266236 = varB4EAC82CA7396A68D541C85D26508E83_1787892429;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_267266236 = varB4EAC82CA7396A68D541C85D26508E83_958905014;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_267266236 = varB4EAC82CA7396A68D541C85D26508E83_2090266447;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_267266236.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_267266236;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.344 -0400", hash_original_method = "0FD4DA1D85F6AEE253925BB7FDB228BD", hash_generated_method = "01727EF577C3A7C4B482522F7C0636B9")
    protected void resetAllRetryCounts() {
        {
            Iterator<DataConnection> var8D54139306CE59DA2A79305B93065ACC_835846240 = (mDataConnections.values()).iterator();
            var8D54139306CE59DA2A79305B93065ACC_835846240.hasNext();
            DataConnection dc = var8D54139306CE59DA2A79305B93065ACC_835846240.next();
            {
                dc.resetRetryCount();
            } //End block
        } //End collapsed parenthetic
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.345 -0400", hash_original_method = "BA61ACB3318576C64C09DAC113E0795F", hash_generated_method = "FA57034BBBA5D59687B99DF037194C62")
        public  DataRoamingSettingObserver(Handler handler) {
            super(handler);
            addTaint(handler.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.353 -0400", hash_original_method = "B90ABFF6DE01DDCB354DDF92EE51905A", hash_generated_method = "F29D7AA1BABB1F60123C2436A52E5310")
        public void register(Context context) {
            ContentResolver resolver;
            resolver = context.getContentResolver();
            resolver.registerContentObserver(
                    Settings.Secure.getUriFor(Settings.Secure.DATA_ROAMING), false, this);
            addTaint(context.getTaint());
            // ---------- Original Method ----------
            //final ContentResolver resolver = context.getContentResolver();
            //resolver.registerContentObserver(
                    //Settings.Secure.getUriFor(Settings.Secure.DATA_ROAMING), false, this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.353 -0400", hash_original_method = "A96EEB9B30A252CB5EDDDA8B92E0867E", hash_generated_method = "EB3F7481B8D1560C889C6405A768D976")
        public void unregister(Context context) {
            ContentResolver resolver;
            resolver = context.getContentResolver();
            resolver.unregisterContentObserver(this);
            addTaint(context.getTaint());
            // ---------- Original Method ----------
            //final ContentResolver resolver = context.getContentResolver();
            //resolver.unregisterContentObserver(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.358 -0400", hash_original_method = "169C7D81EE3F2154C9E94D652CC4F700", hash_generated_method = "7078379D68C8CF85B358A0DE1DB16F06")
        @Override
        public void onChange(boolean selfChange) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            handleDataOnRoamingChange();
            addTaint(selfChange);
            // ---------- Original Method ----------
            //handleDataOnRoamingChange();
        }

        
    }


    
    public class TxRxSum {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.358 -0400", hash_original_field = "9A029104A537A9F6518DBC5E97BCA4CB", hash_generated_field = "31EBFEDBE9880286CAB65EBD7356F689")

        public long txPkts;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.358 -0400", hash_original_field = "41F45C1353F236210B54784C5F09E899", hash_generated_field = "FFD759E6497E1FB8FF7E9F7E8C351B73")

        public long rxPkts;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.358 -0400", hash_original_method = "A9FFC39802399C2580CE69B9ED52FB70", hash_generated_method = "3480E04706A82CC0FC15FF716763F24D")
        public  TxRxSum() {
            reset();
            // ---------- Original Method ----------
            //reset();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.358 -0400", hash_original_method = "CBCCCAC9E5E65AD1C4A36F84309761F3", hash_generated_method = "5084D0A66E4E15FA652E0C50C229F7A5")
        public  TxRxSum(long txPkts, long rxPkts) {
            this.txPkts = txPkts;
            this.rxPkts = rxPkts;
            // ---------- Original Method ----------
            //this.txPkts = txPkts;
            //this.rxPkts = rxPkts;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.359 -0400", hash_original_method = "AD3F4A8C32B5AB82EFF11F34262CA97C", hash_generated_method = "392DAA30EB30056E5D0A513FEBC5B1E8")
        public  TxRxSum(TxRxSum sum) {
            txPkts = sum.txPkts;
            rxPkts = sum.rxPkts;
            // ---------- Original Method ----------
            //txPkts = sum.txPkts;
            //rxPkts = sum.rxPkts;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.359 -0400", hash_original_method = "AC7E7693FF46B721A881337A05B09C85", hash_generated_method = "8B79F23D5DA55C534A1AF5C4055F1390")
        public void reset() {
            txPkts = -1;
            rxPkts = -1;
            // ---------- Original Method ----------
            //txPkts = -1;
            //rxPkts = -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.359 -0400", hash_original_method = "1CA3D86B2E80A8520E2DD65A646FFF96", hash_generated_method = "8C60005ECCF83485E4ED7D8C43F93E9C")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1043260886 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1043260886 = "{txSum=" + txPkts + " rxSum=" + rxPkts + "}";
            varB4EAC82CA7396A68D541C85D26508E83_1043260886.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1043260886;
            // ---------- Original Method ----------
            //return "{txSum=" + txPkts + " rxSum=" + rxPkts + "}";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.470 -0400", hash_original_method = "4A3A2BC6E4110C10924DC1B1F4DD1644", hash_generated_method = "7EF96F301212FCC304534D3F38014DC2")
        public void updateTxRxSum() {
            boolean txUpdated, rxUpdated;
            txUpdated = false;
            rxUpdated = false;
            long txSum, rxSum;
            txSum = 0;
            rxSum = 0;
            {
                Iterator<ApnContext> var9CD107E7BA0F92F9952456E34FCCDBF9_1411120726 = (mApnContexts.values()).iterator();
                var9CD107E7BA0F92F9952456E34FCCDBF9_1411120726.hasNext();
                ApnContext apnContext = var9CD107E7BA0F92F9952456E34FCCDBF9_1411120726.next();
                {
                    {
                        boolean var2276B48A10025B18D3ED30F6663560D1_898081423 = (apnContext.getState() == State.CONNECTED);
                        {
                            DataConnectionAc dcac;
                            dcac = apnContext.getDataConnectionAc();
                            LinkProperties linkProp;
                            linkProp = dcac.getLinkPropertiesSync();
                            String iface;
                            iface = linkProp.getInterfaceName();
                            {
                                long stats;
                                stats = TrafficStats.getTxPackets(iface);
                                {
                                    txUpdated = true;
                                    txSum += stats;
                                } //End block
                                stats = TrafficStats.getRxPackets(iface);
                                {
                                    rxUpdated = true;
                                    rxSum += stats;
                                } //End block
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            this.txPkts = txSum;
            this.rxPkts = rxSum;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.470 -0400", hash_original_field = "A4622F7F72162611C8E075EE443BC26E", hash_generated_field = "D751668EF011EB030075908D0A6ACFD9")

    protected static boolean DBG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.470 -0400", hash_original_field = "F731EB70B21910E383F52051C1671657", hash_generated_field = "B825BAA66BBDA94C70A379A47D83FA46")

    protected static boolean VDBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.470 -0400", hash_original_field = "7BDA6D1A9141EE0AD7FF9598A1FEB6A4", hash_generated_field = "33A74D16876315708A9BD8BD04E30FC7")

    public static String ACTION_DATA_CONNECTION_TRACKER_MESSENGER = "com.android.internal.telephony";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.470 -0400", hash_original_field = "51DF027D281586560FC115C63DD6DEF7", hash_generated_field = "26F3AF3552BC4649D0937B13E6BC7CF8")

    public static String EXTRA_MESSENGER = "EXTRA_MESSENGER";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.470 -0400", hash_original_field = "5965E06AE63626458452FCAD583F5AA9", hash_generated_field = "1AE22D39C768C48F63AA27F9156093A3")

    protected static int BASE = Protocol.BASE_DATA_CONNECTION_TRACKER;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.470 -0400", hash_original_field = "ECA626187861A2CCB3096D5073C18D44", hash_generated_field = "68E65FE6101C99076E08D4EE9188180F")

    protected static int EVENT_DATA_SETUP_COMPLETE = BASE + 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.470 -0400", hash_original_field = "33F24341EE51BCC25663714C2A8AC519", hash_generated_field = "24C287A6573161DAA797C40875B3148C")

    protected static int EVENT_RADIO_AVAILABLE = BASE + 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.470 -0400", hash_original_field = "46DEF412949D3D229F0F086981FB575D", hash_generated_field = "1732430694CD87FF92EC61D599D404FC")

    protected static int EVENT_RECORDS_LOADED = BASE + 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.470 -0400", hash_original_field = "426A2E540BFDB2E53205370AC68A088D", hash_generated_field = "1DC43E4A7FCD3101738AAF7A0792FC01")

    protected static int EVENT_TRY_SETUP_DATA = BASE + 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.470 -0400", hash_original_field = "68D0D3D09B29128339F18635AD1150DC", hash_generated_field = "74C46BBDF3B651489070E5D2619FDBAD")

    protected static int EVENT_DATA_STATE_CHANGED = BASE + 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.470 -0400", hash_original_field = "F2CC829E98056690ECDD89CEA8DF771B", hash_generated_field = "64279DC7AC8EB260C1F0E60E6D989D2E")

    protected static int EVENT_POLL_PDP = BASE + 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.470 -0400", hash_original_field = "B1989873DB7387EF71BE1A11DDA31D66", hash_generated_field = "9C9CC05AEF328DF141409CE6C5D51EC7")

    protected static int EVENT_RADIO_OFF_OR_NOT_AVAILABLE = BASE + 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.470 -0400", hash_original_field = "AE7C2E85ED91FEA82BE6ADA84456A79C", hash_generated_field = "641A961FE197BD2D372FB60C43353F5B")

    protected static int EVENT_VOICE_CALL_STARTED = BASE + 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.470 -0400", hash_original_field = "F68B4A87FAF27CD2F0289E80AFDCEB4A", hash_generated_field = "4F5DD940F1BED806CDD7ABC40731164A")

    protected static int EVENT_VOICE_CALL_ENDED = BASE + 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.470 -0400", hash_original_field = "C0466AD2885B3AE52B71D60533BB007B", hash_generated_field = "CAF18CC10EED9DCFA36AC71305487B01")

    protected static int EVENT_DATA_CONNECTION_DETACHED = BASE + 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.471 -0400", hash_original_field = "0B97AAAEBA1C3D8083CF0885170E6D51", hash_generated_field = "71CC0C5E2FD92E658642CBD20DACF8F6")

    protected static int EVENT_LINK_STATE_CHANGED = BASE + 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.471 -0400", hash_original_field = "40AD81D1830810A9C166ED3D184C9304", hash_generated_field = "1D563C1DD7715F5C08EDC4305B8B418A")

    protected static int EVENT_ROAMING_ON = BASE + 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.471 -0400", hash_original_field = "5AD3E60C000936BC36EAE24FC4D6BFF6", hash_generated_field = "5AD829148E65DC41057BEFCEF77327B5")

    protected static int EVENT_ROAMING_OFF = BASE + 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.471 -0400", hash_original_field = "055D12EA48C72D2C9AE5C7F7406DD106", hash_generated_field = "F462E91C7171B7B2568710B44B9E52D9")

    protected static int EVENT_ENABLE_NEW_APN = BASE + 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.471 -0400", hash_original_field = "510504022D446F08C64C402076675CB3", hash_generated_field = "67844CBF194F4D2F502E611A35D4C395")

    protected static int EVENT_RESTORE_DEFAULT_APN = BASE + 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.471 -0400", hash_original_field = "326890052C84F103A1868FD54E3F3A66", hash_generated_field = "7CF2ECFBCA890A62AB1CC0718A8F0FA6")

    protected static int EVENT_DISCONNECT_DONE = BASE + 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.471 -0400", hash_original_field = "B7E3A0839C0FE078993E272A934BB5A7", hash_generated_field = "EEDF5B6F02AEC645C667529F92EC5B0B")

    protected static int EVENT_DATA_CONNECTION_ATTACHED = BASE + 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.471 -0400", hash_original_field = "D7C0AC990309F4BF30F63B057CC45F91", hash_generated_field = "456D94414F7BCF0ECF002553157BDF26")

    protected static int EVENT_DATA_STALL_ALARM = BASE + 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.471 -0400", hash_original_field = "AA99799D44889D88952331EB4BBA81A5", hash_generated_field = "475F60CDABD61915AE7396A537D5AE6C")

    protected static int EVENT_DO_RECOVERY = BASE + 18;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.471 -0400", hash_original_field = "A2B9E56589E0A1808D25BF81D2820D8F", hash_generated_field = "B86BA83C9082364BF1A0FFEBF0D61E7D")

    protected static int EVENT_APN_CHANGED = BASE + 19;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.471 -0400", hash_original_field = "4DFAB0760A0FF0BC17DF1FA9AFE7EB93", hash_generated_field = "35D09300268238B7429A7C262BE9FA2B")

    protected static int EVENT_CDMA_DATA_DETACHED = BASE + 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.471 -0400", hash_original_field = "7B446BE5FF12DCEE083E090357AE8D56", hash_generated_field = "0264A3EC329E20FD0B985C51B73A5ABB")

    protected static int EVENT_NV_READY = BASE + 21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.471 -0400", hash_original_field = "E6FDE084A4225A1557CE43DF696C02FE", hash_generated_field = "1C143E3D98C730AAD8735BC45A4DA31B")

    protected static int EVENT_PS_RESTRICT_ENABLED = BASE + 22;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.471 -0400", hash_original_field = "37AFD73B25951F6E1E8C8F9F4991E0E5", hash_generated_field = "88E67A9147A789E081FE91D7B71A1BFB")

    protected static int EVENT_PS_RESTRICT_DISABLED = BASE + 23;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.471 -0400", hash_original_field = "34C5609EBA200D1855670B4451302323", hash_generated_field = "AD86F18DB896FF32B9ABB648D3BE3614")

    public static final int EVENT_CLEAN_UP_CONNECTION = BASE + 24;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.471 -0400", hash_original_field = "CF37FF76A274159E6384837A9F7F486F", hash_generated_field = "0CDA564CB13FC007A2A13B8C8F2689E2")

    protected static int EVENT_CDMA_OTA_PROVISION = BASE + 25;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.471 -0400", hash_original_field = "BF7AF52C7FDD44135813BD775C753027", hash_generated_field = "07D624470467EB7188937F7187F1060E")

    protected static int EVENT_RESTART_RADIO = BASE + 26;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.471 -0400", hash_original_field = "DCE289D9C00CC3F12901135A087230E7", hash_generated_field = "9C695B638D7948F6438A28A20861A0B5")

    protected static int EVENT_SET_INTERNAL_DATA_ENABLE = BASE + 27;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.471 -0400", hash_original_field = "AEE40AA06967C6AA4E971FA645018541", hash_generated_field = "36C4D356AEB0EEDED0491BFE7A5972AB")

    protected static int EVENT_RESET_DONE = BASE + 28;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.471 -0400", hash_original_field = "61715180A570527CA45BE873F1A8B16F", hash_generated_field = "F77450C54EDD06E9C95E2653ED0EECF1")

    public static final int CMD_SET_USER_DATA_ENABLE = BASE + 29;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.471 -0400", hash_original_field = "BF8CD25798DFB7D44A922B1D22D07FD8", hash_generated_field = "B4E9A3F75E31EBF0819A14E7CE2FE65B")

    public static final int EVENT_CLEAN_UP_ALL_CONNECTIONS = BASE + 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.471 -0400", hash_original_field = "DBD783B09580CAD21B9BA70443B9B2B3", hash_generated_field = "D8C9AD1D6E5CBD85074BECAA38E31518")

    public static final int CMD_SET_DEPENDENCY_MET = BASE + 31;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.471 -0400", hash_original_field = "44F851B2D4C8232521C6B3BA1F442BD3", hash_generated_field = "3254C5957AFFF539FD79B974BB823F2E")

    public static final int CMD_SET_POLICY_DATA_ENABLE = BASE + 32;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.471 -0400", hash_original_field = "124CDEAD86429F817C00334490AF589A", hash_generated_field = "9C4C4851BB40BC141F3AD211EF7FDEE8")

    protected static int APN_INVALID_ID = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.472 -0400", hash_original_field = "2B9BF7683605EAF175DA931B2453C34B", hash_generated_field = "6DA2F7206415467D263E13CCC3C1AB8F")

    protected static int APN_DEFAULT_ID = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.472 -0400", hash_original_field = "F77BC24DF2981C4E95B36455ACB6486B", hash_generated_field = "72233DEE3ECEA302EB7F263689845217")

    protected static int APN_MMS_ID = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.472 -0400", hash_original_field = "3C9787C2DBFA045A02AB792A7D75AA5C", hash_generated_field = "3C5119D6813E3EC81EDD88F4360325AC")

    protected static int APN_SUPL_ID = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.472 -0400", hash_original_field = "8F0F2C37C7D84C099DD0B43F9FDCDFA3", hash_generated_field = "AB35F627358BC363217FF01A30483E80")

    protected static int APN_DUN_ID = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.472 -0400", hash_original_field = "EB9E39BC107DAD1D743877FB20DCCCB8", hash_generated_field = "48D2B59A665DEBCB1D306D01FD68F945")

    protected static int APN_HIPRI_ID = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.472 -0400", hash_original_field = "12545285308557BFDAA8F96E516DDDE8", hash_generated_field = "D5F0902729B38078CF3BE9064D7A4DBF")

    protected static int APN_IMS_ID = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.472 -0400", hash_original_field = "B615EAB39E5F698FB19CEAF230D05419", hash_generated_field = "28B647B1BAF03A5A69F66207DFD41E67")

    protected static int APN_FOTA_ID = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.472 -0400", hash_original_field = "69D4E9CA7F2362365E1DD82BCE01D5CD", hash_generated_field = "AB16530AED143ABC9E0AE17F2936C5E5")

    protected static int APN_CBS_ID = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.472 -0400", hash_original_field = "AFC301CA9725EEF2D73B132667D7CF53", hash_generated_field = "C0D5B2F5AF90AC5BD7BD38B9F369CF1F")

    protected static int APN_NUM_TYPES = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.472 -0400", hash_original_field = "E2CB925518CBBA02A412E4B68A43574E", hash_generated_field = "6F8C6ECFCCFDEEF8A111FB82FE45C371")

    public static final int DISABLED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.472 -0400", hash_original_field = "C25C0B236353087BD3025AC89A8C2385", hash_generated_field = "BBC106514DA50C961AB6371075708621")

    public static final int ENABLED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.472 -0400", hash_original_field = "F0FBA210FC19B517AD8DC129D7808481", hash_generated_field = "26D79596132C0495F601BE108CF49667")

    public static final String APN_TYPE_KEY = "apnType";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.472 -0400", hash_original_field = "739925A0F14EBFF741BB1F5884FF3580", hash_generated_field = "56895C0D208B354720B9624BFEC7E1C5")

    protected static int APN_DELAY_MILLIS = SystemProperties.getInt("persist.radio.apn_delay", 5000);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.472 -0400", hash_original_field = "84BA753F9948A72584248DEA838B164E", hash_generated_field = "F1D5EAD411587599450F20AD6F0FCBFE")

    protected static boolean sPolicyDataEnabled = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.472 -0400", hash_original_field = "B25FE785B7CAF85E1007146F56D5AB24", hash_generated_field = "417F5338B33783247D09111136BD52DE")

    protected static String DEFAULT_DATA_RETRY_CONFIG = "default_randomization=2000,"
        + "5000,10000,20000,40000,80000:5000,160000:5000,"
        + "320000:5000,640000:5000,1280000:5000,1800000:5000";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.472 -0400", hash_original_field = "DA3393F07AFE29A2E329689063E5B928", hash_generated_field = "3813BA44393081152682D3FC89F420DF")

    protected static String SECONDARY_DATA_RETRY_CONFIG = "max_retries=3, 5000, 5000, 5000";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.472 -0400", hash_original_field = "197214CA0C06EEB1EFD2EBEBA3CD4DA9", hash_generated_field = "5F2841F443ED3E537D6C4E3458112C3A")

    protected static int POLL_NETSTAT_SLOW_MILLIS = 5000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.472 -0400", hash_original_field = "AC32FF0F60419A93C046914FEEBAEA54", hash_generated_field = "CEE342C1D26600981E2988CF66379BBC")

    protected static int DEFAULT_MAX_PDP_RESET_FAIL = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.472 -0400", hash_original_field = "21CD8419E3F89579DF90527399533BBC", hash_generated_field = "22ED9C3152C98B7B7092C7129AB9F64C")

    protected static int NO_RECV_POLL_LIMIT = 24;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.472 -0400", hash_original_field = "382BAE9382F719FBCBB1A10D4BEFA72B", hash_generated_field = "9C999A6A1374A985F79A79E67849299F")

    protected static int POLL_NETSTAT_MILLIS = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.472 -0400", hash_original_field = "923194288220D08DFF21E434BF1AEEEB", hash_generated_field = "485CAA459EF24B804710C5C13344884D")

    protected static int POLL_NETSTAT_SCREEN_OFF_MILLIS = 1000*60*10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.472 -0400", hash_original_field = "D47AA84872A25D01DB68E62C67D0D911", hash_generated_field = "1B7E682EBDF77B7322B78F6E48948245")

    protected static int POLL_LONGEST_RTT = 120 * 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.472 -0400", hash_original_field = "1C3134829F1666190770E94993F178AE", hash_generated_field = "7710E0CECA8ED5258609E0261C6F8FAA")

    protected static int NUMBER_SENT_PACKETS_OF_HANG = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.472 -0400", hash_original_field = "29091498798DC27B881A4E06C3D0FEDD", hash_generated_field = "70E79BDC96D5257393D43F9AB2576F73")

    protected static int RESTORE_DEFAULT_APN_DELAY = 1 * 60 * 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.472 -0400", hash_original_field = "58557858B2FE6F52EF658629982D3750", hash_generated_field = "4556B6DC4C5C4093175417226C9DD5E9")

    protected static String APN_RESTORE_DELAY_PROP_NAME = "android.telephony.apn-restore";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.473 -0400", hash_original_field = "9703C98FBA4E5997D49E93A25FA145F2", hash_generated_field = "96E46ECDEB4B1CB449C9FCD74E2EED5C")

    protected static String NULL_IP = "0.0.0.0";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.473 -0400", hash_original_field = "EBD539F8084726EF894804EB18CFB02A", hash_generated_field = "95733B6A392CC79464ACAE9EFD6F11A4")

    protected static int DATA_STALL_ALARM_DELAY_IN_MS_DEFAULT = 1000 * 60 * 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.473 -0400", hash_original_field = "15B313C114C8CFFC8BD65B40ED360948", hash_generated_field = "D47111A711ABEE54D22041658FDFDE31")

    protected static int DATA_STALL_NO_RECV_POLL_LIMIT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.473 -0400", hash_original_field = "12CBEA904965DFA02EF67746239C8476", hash_generated_field = "A0646CF66DA9896FAD3B68017F4CB1BE")

    protected static String DATA_STALL_ALARM_TAG_EXTRA = "data.stall.alram.tag";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.473 -0400", hash_original_field = "FB709D7A9A230E69736935B6387971ED", hash_generated_field = "561F44ED019DCD17477A085873B7F60B")

    protected static String INTENT_RECONNECT_ALARM_EXTRA_REASON = "reason";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.473 -0400", hash_original_field = "9027635A00312F40B47DC9E66AC4B555", hash_generated_field = "595E3448938733901401C7ED5439EF7C")

    protected static String INTENT_SET_FAIL_DATA_SETUP_COUNTER = "com.android.internal.telephony.dataconnectiontracker.intent_set_fail_data_setup_counter";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.473 -0400", hash_original_field = "E820771C597A7FF6FD625C84D8A897CC", hash_generated_field = "958468E30E357A2C5CD2C67354E90F8F")

    protected static String FAIL_DATA_SETUP_COUNTER = "fail_data_setup_counter";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.473 -0400", hash_original_field = "736E3CF86860D80581301BC5DA74308A", hash_generated_field = "BE7A5FB230F8068BF2086B9CACE3B9C7")

    protected static String FAIL_DATA_SETUP_FAIL_CAUSE = "fail_data_setup_fail_cause";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.473 -0400", hash_original_field = "D56A0C911051F3FEC75B7F4166DA0A41", hash_generated_field = "1FD707F92968760B75C41E949815BD54")

    protected static String DEFALUT_DATA_ON_BOOT_PROP = "net.def_data_on_boot";
}

