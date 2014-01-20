package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.PendingIntent;
import android.net.LinkCapabilities;
import android.net.LinkProperties;
import android.net.ProxyProperties;
import android.os.AsyncResult;
import android.os.Message;
import android.os.SystemProperties;
import android.text.TextUtils;

import com.android.internal.util.AsyncChannel;
import com.android.internal.util.Protocol;
import com.android.internal.util.State;
import com.android.internal.util.StateMachine;

public abstract class DataConnection extends StateMachine {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.285 -0500", hash_original_field = "95D5733A0C83DB3D047D109C028C9F02", hash_generated_field = "5F5E7D64B04175B8FA820B2440F700FC")

    protected static final boolean DBG = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.287 -0500", hash_original_field = "F8CE2FA6EEC177FA658AF7AF6580B765", hash_generated_field = "9627AE94D7940D7E187DD2B77A194FB7")

    protected static final boolean VDBG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.290 -0500", hash_original_field = "B31269F5D1D0B71BAECFA09CAE8A253A", hash_generated_field = "4B6AAD30DE4CA5A855B0088556B9ED5D")

    protected static Object mCountLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.292 -0500", hash_original_field = "228E80965D19F3262507FB2E30484C98", hash_generated_field = "4928C87B5EACFDF4C672365969709FF8")

    protected static int mCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.360 -0500", hash_original_field = "720AFFCFBC95B42461630007A23E1755", hash_generated_field = "C0991AD5CABF697F4823C19D8DBFAB04")

    protected static final int BASE = Protocol.BASE_DATA_CONNECTION;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.363 -0500", hash_original_field = "F06DA4017E0C2F5AF39CBA5FC03AEC20", hash_generated_field = "1C57268A41E9E95862AAA798F982A5CA")

    protected static final int EVENT_CONNECT = BASE + 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.366 -0500", hash_original_field = "286E40B71745F243C2F9E90931D6CDAF", hash_generated_field = "05B193EA1F6AA0D2906CA9DEFC440F47")

    protected static final int EVENT_SETUP_DATA_CONNECTION_DONE = BASE + 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.369 -0500", hash_original_field = "8DA87FE32C60191F54287F6EBDD95742", hash_generated_field = "20A6FDD48CFFBF8BECBD6D4A2123C146")

    protected static final int EVENT_GET_LAST_FAIL_DONE = BASE + 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.371 -0500", hash_original_field = "57D558AF739F6BDB344E04261D4C4295", hash_generated_field = "1FAE49FEE8B55A400DD0C049ABF78522")

    protected static final int EVENT_DEACTIVATE_DONE = BASE + 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.374 -0500", hash_original_field = "1339EADF61EE7E819479C2288BE5CACA", hash_generated_field = "64C9F300F0E3BA2F29ACF2E26492BA60")

    protected static final int EVENT_DISCONNECT = BASE + 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.376 -0500", hash_original_field = "F91366C34B7ECEA99C5C5640523D8FA6", hash_generated_field = "3132177D4B230D900956EB0E80429D56")

    protected static final int EVENT_RIL_CONNECTED = BASE + 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.379 -0500", hash_original_field = "0BE7DDB64A7E64877528BE5678D03BF4", hash_generated_field = "18407D8402382A7FBFA1AC8486B0482B")

    protected static final int EVENT_LOG_BAD_DNS_ADDRESS = 50100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.408 -0500", hash_original_field = "05C3564F4310DD43CD9568F5E3092392", hash_generated_field = "13B653D205F77F7600F4F13DC999F8B9")

    protected static final String NULL_IP = "0.0.0.0";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.294 -0500", hash_original_field = "938D8A480F16E3116A97E14DA75AD4F3", hash_generated_field = "CD0721759B4466C03691E733797DD315")

    protected AsyncChannel mAc;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.297 -0500", hash_original_field = "CF1215A849C0BBCB6FD9A483E2098811", hash_generated_field = "C4FE21B00EEE6A458E193D584E7E2C76")

    private List<ApnContext> mApnList = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.298 -0500", hash_original_field = "43EA75A8E40D96F1FE9644BAABB59B27", hash_generated_field = "43EA75A8E40D96F1FE9644BAABB59B27")

    PendingIntent mReconnectIntent = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.381 -0500", hash_original_field = "3A7962EA66A8AFE9D273887F5446E51C", hash_generated_field = "861BA63EA88683DE381E86F4D6D3F1AD")

    protected ApnSetting mApn;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.384 -0500", hash_original_field = "9984816B5FE48640B78EE6DAAAF27384", hash_generated_field = "DD44804C5337E386664F560C02BE343C")

    protected int mTag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.386 -0500", hash_original_field = "4D74BFF297E0DF8FA98FF6D8A8DBA78C", hash_generated_field = "4FEA837943E73EF5CB83661843F1AD15")

    protected PhoneBase phone;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.388 -0500", hash_original_field = "159201D2737D5780BDFB3E85B6D4DD19", hash_generated_field = "580E7C4318D3476CC0659BF42E5F3A02")

    protected int mRilVersion = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.390 -0500", hash_original_field = "FED2DA254DB40ADD613AD5897371870E", hash_generated_field = "A51EAFC1706A086015D96F276D59C143")

    protected int cid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.392 -0500", hash_original_field = "D506421D50FC7C7B34F10149DF68FE33", hash_generated_field = "A5A5AFED252C7D512DACD2841D863761")

    protected LinkProperties mLinkProperties = new LinkProperties();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.396 -0500", hash_original_field = "EA43D06D762F03C359522D3FA0B77A35", hash_generated_field = "A46D45BD76CF171387C1C09380918B0D")

    protected LinkCapabilities mCapabilities = new LinkCapabilities();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.398 -0500", hash_original_field = "88A71A811D0CFD868BD514D9A7A9DADE", hash_generated_field = "BDD8643E97E5DC61E6EAAAF64140026D")

    protected long createTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.401 -0500", hash_original_field = "9C352DBC4D5154EEF1401471D8D674B6", hash_generated_field = "A20A821CFA63B57B209D4480F0D19EFE")

    protected long lastFailTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.403 -0500", hash_original_field = "8A9FC3B79EA46866070467892260FB8C", hash_generated_field = "6C25BC29EE727D8706010965EC862301")

    protected FailCause lastFailCause;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.405 -0500", hash_original_field = "9F76C170D5B7C8C5B8890E015A9F6F8C", hash_generated_field = "DE06CED5AB988CDFE56F6FF52DB76E5B")

    protected int mRetryOverride = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.410 -0500", hash_original_field = "10901FC32DF7F71F9F354DE920A6F5B1", hash_generated_field = "66F3E0510779BE4D1B59CDAC387E6C47")

    private int mRefCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.412 -0500", hash_original_field = "64F9C8FFBF59E1349A604124A0E0710A", hash_generated_field = "64F9C8FFBF59E1349A604124A0E0710A")

    Object userData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.439 -0500", hash_original_field = "9F66E723E60E4F10157FDA7C23C67293", hash_generated_field = "3325985E0136EBA5816EE6CBB3154574")

    /*
     * The id is owned by DataConnectionTracker.
     */
    private int mId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.444 -0500", hash_original_field = "A103EB355FA0105A0F2A093325C31E9B", hash_generated_field = "6C728820465A4CC87E1F72987D225AAA")

    private RetryManager mRetryMgr;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.511 -0500", hash_original_field = "318F0B5CC485633A17A9BB3D6A947DAD", hash_generated_field = "69571CA19C3B558505D31735F0F9B91B")

    private DcDefaultState mDefaultState = new DcDefaultState();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.538 -0500", hash_original_field = "BECC22CB1D7DEFC9B76DCDBC746D9575", hash_generated_field = "F5AB6F71A92E9D262A29AB9EF8925002")

    private DcInactiveState mInactiveState = new DcInactiveState();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.547 -0500", hash_original_field = "7732211C0C707D528C63962D9A891513", hash_generated_field = "DDDC0B6EBEB86603B4A087252D031623")

    private DcActivatingState mActivatingState = new DcActivatingState();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.568 -0500", hash_original_field = "88D80349C45D49A19B1013C0992FCD1E", hash_generated_field = "9D5433FE7E5E65E836534512E552B10F")

    private DcActiveState mActiveState = new DcActiveState();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.578 -0500", hash_original_field = "8848D5F3D8D2821AE53A7C3ABEA0E822", hash_generated_field = "D3E64CA9FA2850A1BACA275155C23DC5")

    private DcDisconnectingState mDisconnectingState = new DcDisconnectingState();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.586 -0500", hash_original_field = "C967A4308BA600DD2F62DFD92670841C", hash_generated_field = "CD618074011D52150D4FE826A3AA4C98")

    private DcDisconnectionErrorCreatingConnection mDisconnectingErrorCreatingConnection =
                new DcDisconnectionErrorCreatingConnection();

   //***** Constructor
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.426 -0500", hash_original_method = "C1A86AB25296EBC0B07A31287A18BD02", hash_generated_method = "6664E04967608CC62C345936490F6D0C")
    
protected DataConnection(PhoneBase phone, String name, int id, RetryManager rm) {
        super(name);
        if (DBG) log("DataConnection constructor E");
        this.phone = phone;
        mId = id;
        mRetryMgr = rm;
        this.cid = -1;

        setDbg(false);
        addState(mDefaultState);
            addState(mInactiveState, mDefaultState);
            addState(mActivatingState, mDefaultState);
            addState(mActiveState, mDefaultState);
            addState(mDisconnectingState, mDefaultState);
            addState(mDisconnectingErrorCreatingConnection, mDefaultState);
        setInitialState(mInactiveState);

        mApnList = new ArrayList<ApnContext>();
        if (DBG) log("DataConnection constructor X");
    }

    //***** Abstract methods
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.415 -0500", hash_original_method = "D4E4943029EE450E10D723A13B21ADBA", hash_generated_method = "756F2EF371660D429BB5FEF72144B300")
    
@Override
    public abstract String toString();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.418 -0500", hash_original_method = "46C33C20EAAA72E99B01C269BC0804DE", hash_generated_method = "7D68C6725ADF164B57DDDA3AFBB67BBB")
    
protected abstract void onConnect(ConnectionParams cp);

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.420 -0500", hash_original_method = "B152A29494275433B17B8AB6FD767B62", hash_generated_method = "03B7A158959C6B462D6BFABDFA867604")
    
protected abstract boolean isDnsOk(String[] domainNameServers);

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.423 -0500", hash_original_method = "48DBEBE9679DD6022C78E9B6D9D15841", hash_generated_method = "43827D28600B8F0847D532E80E30A990")
    
protected abstract void log(String s);

    /**
     * TearDown the data connection.
     *
     * @param o will be returned in AsyncResult.userObj
     *          and is either a DisconnectParams or ConnectionParams.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.429 -0500", hash_original_method = "59ED68D7EF373C505428063E232AFE5C", hash_generated_method = "3D4259D2FE3F23AC235137696717ADB9")
    
private void tearDownData(Object o) {
        int discReason = RILConstants.DEACTIVATE_REASON_NONE;
        if ((o != null) && (o instanceof DisconnectParams)) {
            DisconnectParams dp = (DisconnectParams)o;
            Message m = dp.onCompletedMsg;
            if (TextUtils.equals(dp.reason, Phone.REASON_RADIO_TURNED_OFF)) {
                discReason = RILConstants.DEACTIVATE_REASON_RADIO_OFF;
            } else if (TextUtils.equals(dp.reason, Phone.REASON_PDP_RESET)) {
                discReason = RILConstants.DEACTIVATE_REASON_PDP_RESET;
            }
        }
        if (phone.mCM.getRadioState().isOn()) {
            if (DBG) log("tearDownData radio is on, call deactivateDataCall");
            phone.mCM.deactivateDataCall(cid, discReason, obtainMessage(EVENT_DEACTIVATE_DONE, o));
        } else {
            if (DBG) log("tearDownData radio is off sendMessage EVENT_DEACTIVATE_DONE immediately");
            AsyncResult ar = new AsyncResult(o, null, null);
            sendMessage(obtainMessage(EVENT_DEACTIVATE_DONE, ar));
        }
    }

    /**
     * Send the connectionCompletedMsg.
     *
     * @param cp is the ConnectionParams
     * @param cause
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.432 -0500", hash_original_method = "4864ED15F4860BAE9DD2587736D4A08F", hash_generated_method = "29DD77408AFE5482CC56B715A14995DF")
    
private void notifyConnectCompleted(ConnectionParams cp, FailCause cause) {
        Message connectionCompletedMsg = cp.onCompletedMsg;
        if (connectionCompletedMsg == null) {
            return;
        }

        long timeStamp = System.currentTimeMillis();
        connectionCompletedMsg.arg1 = cid;

        if (cause == FailCause.NONE) {
            createTime = timeStamp;
            AsyncResult.forMessage(connectionCompletedMsg);
        } else {
            lastFailCause = cause;
            lastFailTime = timeStamp;
            AsyncResult.forMessage(connectionCompletedMsg, cause,
                                   new CallSetupException(mRetryOverride));
        }
        if (DBG) log("notifyConnectionCompleted at " + timeStamp + " cause=" + cause);

        connectionCompletedMsg.sendToTarget();
    }

    /**
     * Send ar.userObj if its a message, which is should be back to originator.
     *
     * @param dp is the DisconnectParams.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.434 -0500", hash_original_method = "DB15644DADCD9FE90AC8779F50E40D9C", hash_generated_method = "9421F2ACC31AFED0A5AACF0A608574A8")
    
private void notifyDisconnectCompleted(DisconnectParams dp) {
        if (VDBG) log("NotifyDisconnectCompleted");

        if (dp.onCompletedMsg != null) {
            Message msg = dp.onCompletedMsg;
            if (VDBG) {
                log(String.format("msg=%s msg.obj=%s", msg.toString(),
                    ((msg.obj instanceof String) ? (String) msg.obj : "<no-reason>")));
            }
            AsyncResult.forMessage(msg);
            msg.sendToTarget();
        }
        if (DBG) log("NotifyDisconnectCompleted DisconnectParams=" + dp);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.437 -0500", hash_original_method = "1BB05B964694E45E9B1991E5D1915447", hash_generated_method = "5296E9C766A0DDA4041863F5AB30CE51")
    
protected int getRadioTechnology(int defaultRadioTechnology) {
        int radioTechnology;
        if (mRilVersion < 6) {
            radioTechnology = defaultRadioTechnology;
        } else {
            radioTechnology = phone.getServiceState().getRadioTechnology() + 2;
        }
        return radioTechnology;
    }

    /**
     * Get the DataConnection ID
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.442 -0500", hash_original_method = "AAF5779D145C421CCE90F0916803977D", hash_generated_method = "17C32165BE6E00CB52C703BBAB958164")
    
public int getDataConnectionId() {
        return mId;
    }

    /**
     * @return retry manager retryCount
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.447 -0500", hash_original_method = "FC51BF074579EE4E5F8C7AB511B49B8A", hash_generated_method = "FC5EB280939A7335FB3656C981AABC0E")
    
public int getRetryCount() {
        return mRetryMgr.getRetryCount();
    }

    /**
     * @return retry manager retryTimer
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.449 -0500", hash_original_method = "21D3097027A7BF6D8D1F04609D8A2AE9", hash_generated_method = "34EE7508D16254DC2F4E0B8AD7891E2D")
    
public int getRetryTimer() {
        return mRetryMgr.getRetryTimer();
    }

    /**
     * increaseRetryCount of retry manager
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.451 -0500", hash_original_method = "2EFBBED22C4BDBBAA07E00436CC70BDF", hash_generated_method = "3C51283007DAC3D6B8DA518998C0853B")
    
public void increaseRetryCount() {
        mRetryMgr.increaseRetryCount();
    }
    
    protected static class ConnectionParams {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.304 -0500", hash_original_field = "0870A130AAC33D99955FFBF59B769627", hash_generated_field = "FE8BF0CD5CB8CBF698330270CCCC9D95")

        public int tag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.307 -0500", hash_original_field = "C701720B28D007119EDCB720F27B25FC", hash_generated_field = "38CFCC1E5D60F78E53168DDFD409D179")

        public ApnSetting apn;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.310 -0500", hash_original_field = "9D4B8E95F92CACEC0DF6EA1DAB51D1C8", hash_generated_field = "5CDD027FA2114D7598947EC577C34B1B")

        public Message onCompletedMsg;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.302 -0500", hash_original_method = "9C883FBF948634C8BFC48155A41A0F4D", hash_generated_method = "CD31ED9F4CA4BF1C48C9D97E017B09C8")
        
public ConnectionParams(ApnSetting apn, Message onCompletedMsg) {
            this.apn = apn;
            this.onCompletedMsg = onCompletedMsg;
        }
        
    }
    
    protected static class DisconnectParams {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.317 -0500", hash_original_field = "0870A130AAC33D99955FFBF59B769627", hash_generated_field = "FE8BF0CD5CB8CBF698330270CCCC9D95")

        public int tag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.319 -0500", hash_original_field = "44389B89ABFFACB25A438C09FC257320", hash_generated_field = "2E3A925DF54272DE75922655083A87FE")

        public String reason;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.322 -0500", hash_original_field = "9D4B8E95F92CACEC0DF6EA1DAB51D1C8", hash_generated_field = "5CDD027FA2114D7598947EC577C34B1B")

        public Message onCompletedMsg;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.314 -0500", hash_original_method = "8634A04E02B052AB53AF8D3EFA7F5294", hash_generated_method = "9EA182C90A3C9E62036E97AEE9320CDE")
        
public DisconnectParams(String reason, Message onCompletedMsg) {
            this.reason = reason;
            this.onCompletedMsg = onCompletedMsg;
        }
        
    }
    
    public enum FailCause {
        NONE(0),
        OPERATOR_BARRED(0x08),
        INSUFFICIENT_RESOURCES(0x1A),
        MISSING_UNKNOWN_APN(0x1B),
        UNKNOWN_PDP_ADDRESS_TYPE(0x1C),
        USER_AUTHENTICATION(0x1D),
        ACTIVATION_REJECT_GGSN(0x1E),
        ACTIVATION_REJECT_UNSPECIFIED(0x1F),
        SERVICE_OPTION_NOT_SUPPORTED(0x20),
        SERVICE_OPTION_NOT_SUBSCRIBED(0x21),
        SERVICE_OPTION_OUT_OF_ORDER(0x22),
        NSAPI_IN_USE(0x23),
        ONLY_IPV4_ALLOWED(0x32),
        ONLY_IPV6_ALLOWED(0x33),
        ONLY_SINGLE_BEARER_ALLOWED(0x34),
        PROTOCOL_ERRORS(0x6F),
        REGISTRATION_FAIL(-1),
        GPRS_REGISTRATION_FAIL(-2),
        SIGNAL_LOST(-3),
        PREF_RADIO_TECH_CHANGED(-4),
        RADIO_POWER_OFF(-5),
        TETHERED_CALL_ACTIVE(-6),
        ERROR_UNSPECIFIED(0xFFFF),
        UNKNOWN(0x10000),
        RADIO_NOT_AVAILABLE(0x10001),
        UNACCEPTABLE_NETWORK_PARAMETER(0x10002);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.327 -0500", hash_original_field = "515EB2FB135FC88F0BEB6A706140CD45", hash_generated_field = "8D738EFAB3CB336B57C8A3079211331F")

        private  int mErrorCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.330 -0500", hash_original_field = "03497A5221DDE33787A3979B57024752", hash_generated_field = "7046F801D49CDE8A4FCCEAE917E74D01")

        private static  HashMap<Integer, FailCause> sErrorCodeToFailCauseMap;
        static {
            sErrorCodeToFailCauseMap = new HashMap<Integer, FailCause>();
            for (FailCause fc : values()) {
                sErrorCodeToFailCauseMap.put(fc.getErrorCode(), fc);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.333 -0500", hash_original_method = "7BE25CC301A164F5CE305C37CCA74B46", hash_generated_method = "7BE25CC301A164F5CE305C37CCA74B46")
            
FailCause(int errorCode) {
            mErrorCode = errorCode;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.335 -0500", hash_original_method = "2CAF9569868B361A0FCF2D9EDEA3395A", hash_generated_method = "2CAF9569868B361A0FCF2D9EDEA3395A")
            
int getErrorCode() {
            return mErrorCode;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.338 -0500", hash_original_method = "C990BBAED1BD37BDF3DE0CFEDA85DEFC", hash_generated_method = "F0371AD8DAFCEF794C306F4D39F51CC7")
            
public boolean isPermanentFail() {
            return (this == OPERATOR_BARRED) || (this == MISSING_UNKNOWN_APN) ||
                   (this == UNKNOWN_PDP_ADDRESS_TYPE) || (this == USER_AUTHENTICATION) ||
                   (this == SERVICE_OPTION_NOT_SUPPORTED) ||
                   (this == SERVICE_OPTION_NOT_SUBSCRIBED) || (this == NSAPI_IN_USE) ||
                   (this == PROTOCOL_ERRORS);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.341 -0500", hash_original_method = "AC3B21386612F29123A666801F4C08FB", hash_generated_method = "C1D8C9AE39DF93FC95047D8207AABD0F")
            
public boolean isEventLoggable() {
            return (this == OPERATOR_BARRED) || (this == INSUFFICIENT_RESOURCES) ||
                    (this == UNKNOWN_PDP_ADDRESS_TYPE) || (this == USER_AUTHENTICATION) ||
                    (this == ACTIVATION_REJECT_GGSN) || (this == ACTIVATION_REJECT_UNSPECIFIED) ||
                    (this == SERVICE_OPTION_NOT_SUBSCRIBED) ||
                    (this == SERVICE_OPTION_NOT_SUPPORTED) ||
                    (this == SERVICE_OPTION_OUT_OF_ORDER) || (this == NSAPI_IN_USE) ||
                    (this == PROTOCOL_ERRORS) ||
                    (this == UNACCEPTABLE_NETWORK_PARAMETER);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.343 -0500", hash_original_method = "0E4610844A23BD727CA2B9BBF428C34D", hash_generated_method = "322464C6DBA14EEBEBEE2AACEEFEC45A")
            
public static FailCause fromInt(int errorCode) {
            FailCause fc = sErrorCodeToFailCauseMap.get(errorCode);
            if (fc == null) {
                fc = UNKNOWN;
            }
            return fc;
        }
    }
    
    public static class CallSetupException extends Exception {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.349 -0500", hash_original_field = "9F76C170D5B7C8C5B8890E015A9F6F8C", hash_generated_field = "032A6243CE5F8297EF5A6124BAD634D5")

        private int mRetryOverride = -1;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.352 -0500", hash_original_method = "A504ADA2782D67F9E42B2FFAADC374C6", hash_generated_method = "A504ADA2782D67F9E42B2FFAADC374C6")
        
CallSetupException (int retryOverride) {
            mRetryOverride = retryOverride;
        }

        @DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.355 -0500", hash_original_method = "474AEB2E917376DACCA3A8D3E49DB29C", hash_generated_method = "96C83208FBD26CDFFC9C3754156612F9")
        
public int getRetryOverride() {
            return mRetryOverride;
        }
        
    }
    
    public static class UpdateLinkPropertyResult {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.479 -0500", hash_original_field = "4D055126C293025265F46D327224A74A", hash_generated_field = "C2A2765E7F96035E410CAF8D3027DAAC")

        public DataCallState.SetupResult setupResult = DataCallState.SetupResult.SUCCESS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.481 -0500", hash_original_field = "4C3719E756320D8D808CCD90B5480FF3", hash_generated_field = "37B8435E7C404801E84F791E65EA2E96")

        public LinkProperties oldLp;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.484 -0500", hash_original_field = "3616C30591A195CFCEAC5F0645B16455", hash_generated_field = "8D8E816DF0FD888DB1A55D12D81B2844")

        public LinkProperties newLp;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.487 -0500", hash_original_method = "5FFECF7E7800E048A607977532017882", hash_generated_method = "310F93659739D52954F8838F7A51F71A")
        
public UpdateLinkPropertyResult(LinkProperties curLp) {
            oldLp = curLp;
            newLp = curLp;
        }
        
    }
    
    private class DcDefaultState extends State {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.918 -0400", hash_original_method = "65DC675B486478379964AECC5A2EA868", hash_generated_method = "65DC675B486478379964AECC5A2EA868")
        public DcDefaultState ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.495 -0500", hash_original_method = "AF33D4647C9368E21A04243E95A9DF92", hash_generated_method = "DC74020E028D20FD62D44ECBB2EF374F")
        
@Override
        public void enter() {
            phone.mCM.registerForRilConnected(getHandler(), EVENT_RIL_CONNECTED, null);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.497 -0500", hash_original_method = "B29A8A064FC1508BFE2503E3804D9F04", hash_generated_method = "471A91F66D30C114C10628B18949685B")
        
@Override
        public void exit() {
            phone.mCM.unregisterForRilConnected(getHandler());
        }
        @DSSink({DSSinkKind.SYSTEM_SETTINGS})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.503 -0500", hash_original_method = "38E04FBDF2EDCBA5E9341920E990239B", hash_generated_method = "024C34D48D405A20D921BB347C441EC0")
        
@Override
        public boolean processMessage(Message msg) {
            AsyncResult ar;

            switch (msg.what) {
                case AsyncChannel.CMD_CHANNEL_FULL_CONNECTION: {
                    if (mAc != null) {
                        if (VDBG) log("Disconnecting to previous connection mAc=" + mAc);
                        mAc.replyToMessage(msg, AsyncChannel.CMD_CHANNEL_FULLY_CONNECTED,
                                AsyncChannel.STATUS_FULL_CONNECTION_REFUSED_ALREADY_CONNECTED);
                    } else {
                        mAc = new AsyncChannel();
                        mAc.connected(null, getHandler(), msg.replyTo);
                        if (VDBG) log("DcDefaultState: FULL_CONNECTION reply connected");
                        mAc.replyToMessage(msg, AsyncChannel.CMD_CHANNEL_FULLY_CONNECTED,
                                AsyncChannel.STATUS_SUCCESSFUL, mId, "hi");
                    }
                    break;
                }
                case AsyncChannel.CMD_CHANNEL_DISCONNECT: {
                    if (VDBG) log("CMD_CHANNEL_DISCONNECT");
                    mAc.disconnect();
                    break;
                }
                case AsyncChannel.CMD_CHANNEL_DISCONNECTED: {
                    if (VDBG) log("CMD_CHANNEL_DISCONNECTED");
                    mAc = null;
                    break;
                }
                case DataConnectionAc.REQ_IS_INACTIVE: {
                    boolean val = getCurrentState() == mInactiveState;
                    if (VDBG) log("REQ_IS_INACTIVE  isInactive=" + val);
                    mAc.replyToMessage(msg, DataConnectionAc.RSP_IS_INACTIVE, val ? 1 : 0);
                    break;
                }
                case DataConnectionAc.REQ_GET_CID: {
                    if (VDBG) log("REQ_GET_CID  cid=" + cid);
                    mAc.replyToMessage(msg, DataConnectionAc.RSP_GET_CID, cid);
                    break;
                }
                case DataConnectionAc.REQ_GET_APNSETTING: {
                    if (VDBG) log("REQ_GET_APNSETTING  apnSetting=" + mApn);
                    mAc.replyToMessage(msg, DataConnectionAc.RSP_GET_APNSETTING, mApn);
                    break;
                }
                case DataConnectionAc.REQ_GET_LINK_PROPERTIES: {
                    LinkProperties lp = new LinkProperties(mLinkProperties);
                    if (VDBG) log("REQ_GET_LINK_PROPERTIES linkProperties" + lp);
                    mAc.replyToMessage(msg, DataConnectionAc.RSP_GET_LINK_PROPERTIES, lp);
                    break;
                }
                case DataConnectionAc.REQ_SET_LINK_PROPERTIES_HTTP_PROXY: {
                    ProxyProperties proxy = (ProxyProperties) msg.obj;
                    if (VDBG) log("REQ_SET_LINK_PROPERTIES_HTTP_PROXY proxy=" + proxy);
                    mLinkProperties.setHttpProxy(proxy);
                    mAc.replyToMessage(msg, DataConnectionAc.RSP_SET_LINK_PROPERTIES_HTTP_PROXY);
                    break;
                }
                case DataConnectionAc.REQ_UPDATE_LINK_PROPERTIES_DATA_CALL_STATE: {
                    DataCallState newState = (DataCallState) msg.obj;
                    UpdateLinkPropertyResult result =
                                             updateLinkProperty(newState);
                    if (VDBG) {
                        log("REQ_UPDATE_LINK_PROPERTIES_DATA_CALL_STATE result="
                            + result + " newState=" + newState);
                    }
                    mAc.replyToMessage(msg,
                                   DataConnectionAc.RSP_UPDATE_LINK_PROPERTIES_DATA_CALL_STATE,
                                   result);
                    break;
                }
                case DataConnectionAc.REQ_GET_LINK_CAPABILITIES: {
                    LinkCapabilities lc = new LinkCapabilities(mCapabilities);
                    if (VDBG) log("REQ_GET_LINK_CAPABILITIES linkCapabilities" + lc);
                    mAc.replyToMessage(msg, DataConnectionAc.RSP_GET_LINK_CAPABILITIES, lc);
                    break;
                }
                case DataConnectionAc.REQ_RESET:
                    if (VDBG) log("DcDefaultState: msg.what=REQ_RESET");
                    mAc.replyToMessage(msg, DataConnectionAc.RSP_RESET);
                    transitionTo(mInactiveState);
                    break;
                case DataConnectionAc.REQ_GET_REFCOUNT: {
                    if (VDBG) log("REQ_GET_REFCOUNT  refCount=" + mRefCount);
                    mAc.replyToMessage(msg, DataConnectionAc.RSP_GET_REFCOUNT, mRefCount);
                    break;
                }
                case DataConnectionAc.REQ_ADD_APNCONTEXT: {
                    ApnContext apnContext = (ApnContext) msg.obj;
                    if (VDBG) log("REQ_ADD_APNCONTEXT apn=" + apnContext.getApnType());
                    if (!mApnList.contains(apnContext)) {
                        mApnList.add(apnContext);
                    }
                    mAc.replyToMessage(msg, DataConnectionAc.RSP_ADD_APNCONTEXT);
                    break;
                }
                case DataConnectionAc.REQ_REMOVE_APNCONTEXT: {
                    ApnContext apnContext = (ApnContext) msg.obj;
                    if (VDBG) log("REQ_REMOVE_APNCONTEXT apn=" + apnContext.getApnType());
                    mApnList.remove(apnContext);
                    mAc.replyToMessage(msg, DataConnectionAc.RSP_REMOVE_APNCONTEXT);
                    break;
                }
                case DataConnectionAc.REQ_GET_APNCONTEXT_LIST: {
                    if (VDBG) log("REQ_GET_APNCONTEXT_LIST num in list=" + mApnList.size());
                    mAc.replyToMessage(msg, DataConnectionAc.RSP_GET_APNCONTEXT_LIST,
                                       new ArrayList<ApnContext>(mApnList));
                    break;
                }
                case DataConnectionAc.REQ_SET_RECONNECT_INTENT: {
                    PendingIntent intent = (PendingIntent) msg.obj;
                    if (VDBG) log("REQ_SET_RECONNECT_INTENT");
                    mReconnectIntent = intent;
                    mAc.replyToMessage(msg, DataConnectionAc.RSP_SET_RECONNECT_INTENT);
                    break;
                }
                case DataConnectionAc.REQ_GET_RECONNECT_INTENT: {
                    if (VDBG) log("REQ_GET_RECONNECT_INTENT");
                    mAc.replyToMessage(msg, DataConnectionAc.RSP_GET_RECONNECT_INTENT,
                                       mReconnectIntent);
                    break;
                }
                case EVENT_CONNECT:
                    if (DBG) log("DcDefaultState: msg.what=EVENT_CONNECT, fail not expected");
                    ConnectionParams cp = (ConnectionParams) msg.obj;
                    notifyConnectCompleted(cp, FailCause.UNKNOWN);
                    break;

                case EVENT_DISCONNECT:
                    if (DBG) {
                        log("DcDefaultState deferring msg.what=EVENT_DISCONNECT" + mRefCount);
                    }
                    deferMessage(msg);
                    break;

                case EVENT_RIL_CONNECTED:
                    ar = (AsyncResult)msg.obj;
                    if (ar.exception == null) {
                        mRilVersion = (Integer)ar.result;
                        if (DBG) {
                            log("DcDefaultState: msg.what=EVENT_RIL_CONNECTED mRilVersion=" +
                                mRilVersion);
                        }
                    } else {
                        log("Unexpected exception on EVENT_RIL_CONNECTED");
                        mRilVersion = -1;
                    }
                    break;

                default:
                    if (DBG) {
                        log("DcDefaultState: shouldn't happen but ignore msg.what=0x" +
                                Integer.toHexString(msg.what));
                    }
                    break;
            }

            return HANDLED;
        }
        
    }
    
    private class DcInactiveState extends State {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.514 -0500", hash_original_field = "9331D1B74412EEA32E7D978E870794E4", hash_generated_field = "88BEDA692751646D94B15E7361FCC4BA")

        private ConnectionParams mConnectionParams = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.516 -0500", hash_original_field = "ED45C6D4763DC12F21AF23A599FF017C", hash_generated_field = "989525539D6A577B96BED5903F7F8BDA")

        private FailCause mFailCause = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.519 -0500", hash_original_field = "AD5B6AA0DA39781F761F54CB6164B905", hash_generated_field = "66B44836F757DC466942B49412EB20B6")

        private DisconnectParams mDisconnectParams = null;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.919 -0400", hash_original_method = "BBB65F37D8F6078358DD0061CFCF8B87", hash_generated_method = "BBB65F37D8F6078358DD0061CFCF8B87")
        public DcInactiveState ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.521 -0500", hash_original_method = "CBB71B6A4AE30457112F09AD25305330", hash_generated_method = "F95746710C31B86C982E209E4FC0F4A7")
        
public void setEnterNotificationParams(ConnectionParams cp, FailCause cause,
                                               int retryOverride) {
            if (VDBG) log("DcInactiveState: setEnterNoticationParams cp,cause");
            mConnectionParams = cp;
            mFailCause = cause;
            mRetryOverride = retryOverride;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.523 -0500", hash_original_method = "58F7FEE7FE1847BE132197954CFB7983", hash_generated_method = "A8C0D3F94E8FE7CE2289C35DDFD62FF9")
        
public void setEnterNotificationParams(DisconnectParams dp) {
            if (VDBG) log("DcInactiveState: setEnterNoticationParams dp");
            mDisconnectParams = dp;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.526 -0500", hash_original_method = "7E7CE9C76124761714CEFBB8783C6ACB", hash_generated_method = "FDADBD9589D7359992CAA78BB7850476")
        
@Override
        public void enter() {
            mTag += 1;

            /**
             * Now that we've transitioned to Inactive state we
             * can send notifications. Previously we sent the
             * notifications in the processMessage handler but
             * that caused a race condition because the synchronous
             * call to isInactive.
             */
            if ((mConnectionParams != null) && (mFailCause != null)) {
                if (VDBG) log("DcInactiveState: enter notifyConnectCompleted");
                notifyConnectCompleted(mConnectionParams, mFailCause);
            }
            if (mDisconnectParams != null) {
                if (VDBG) log("DcInactiveState: enter notifyDisconnectCompleted");
                notifyDisconnectCompleted(mDisconnectParams);
            }
            clearSettings();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.528 -0500", hash_original_method = "0122D4B6A897CA907F15060B70B58C0B", hash_generated_method = "31F9396C28054D9B56ADAEBBDB399463")
        
@Override
        public void exit() {
            // clear notifications
            mConnectionParams = null;
            mFailCause = null;
            mDisconnectParams = null;
        }

        @DSSink({DSSinkKind.SYSTEM_SETTINGS})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.533 -0500", hash_original_method = "F7BD47A9DC4B0FE6830EC189D0B30877", hash_generated_method = "7104AADBEBBFA08DC060F2BE7B466FC1")
        
@Override
        public boolean processMessage(Message msg) {
            boolean retVal;

            switch (msg.what) {
                case DataConnectionAc.REQ_RESET:
                    if (DBG) {
                        log("DcInactiveState: msg.what=RSP_RESET, ignore we're already reset");
                    }
                    mAc.replyToMessage(msg, DataConnectionAc.RSP_RESET);
                    retVal = HANDLED;
                    break;

                case EVENT_CONNECT:
                    ConnectionParams cp = (ConnectionParams) msg.obj;
                    cp.tag = mTag;
                    if (DBG) {
                        log("DcInactiveState msg.what=EVENT_CONNECT." + "RefCount = "
                                + mRefCount);
                    }
                    mRefCount = 1;
                    onConnect(cp);
                    transitionTo(mActivatingState);
                    retVal = HANDLED;
                    break;

                case EVENT_DISCONNECT:
                    if (DBG) log("DcInactiveState: msg.what=EVENT_DISCONNECT");
                    notifyDisconnectCompleted((DisconnectParams)msg.obj);
                    retVal = HANDLED;
                    break;

                default:
                    if (VDBG) {
                        log("DcInactiveState nothandled msg.what=0x" +
                                Integer.toHexString(msg.what));
                    }
                    retVal = NOT_HANDLED;
                    break;
            }
            return retVal;
        }
        
    }
    
    private class DcActivatingState extends State {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.920 -0400", hash_original_method = "3C5900F00C80F9987C90695FBB53350C", hash_generated_method = "3C5900F00C80F9987C90695FBB53350C")
        public DcActivatingState ()
        {
            //Synthesized constructor
        }
        @DSSink({DSSinkKind.SYSTEM_SETTINGS})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.542 -0500", hash_original_method = "FDE326A498C74E1E809F141FF2FEACCA", hash_generated_method = "CCE75B88E351D297485030F1DE4820E4")
        
@Override
        public boolean processMessage(Message msg) {
            boolean retVal;
            AsyncResult ar;
            ConnectionParams cp;

            switch (msg.what) {
                case EVENT_CONNECT:
                    if (DBG) log("DcActivatingState deferring msg.what=EVENT_CONNECT refCount = "
                            + mRefCount);
                    deferMessage(msg);
                    retVal = HANDLED;
                    break;

                case EVENT_SETUP_DATA_CONNECTION_DONE:
                    if (DBG) log("DcActivatingState msg.what=EVENT_SETUP_DATA_CONNECTION_DONE");

                    ar = (AsyncResult) msg.obj;
                    cp = (ConnectionParams) ar.userObj;

                    DataCallState.SetupResult result = onSetupConnectionCompleted(ar);
                    if (DBG) log("DcActivatingState onSetupConnectionCompleted result=" + result);
                    switch (result) {
                        case SUCCESS:
                            // All is well
                            mActiveState.setEnterNotificationParams(cp, FailCause.NONE);
                            transitionTo(mActiveState);
                            break;
                        case ERR_BadCommand:
                            // Vendor ril rejected the command and didn't connect.
                            // Transition to inactive but send notifications after
                            // we've entered the mInactive state.
                            mInactiveState.setEnterNotificationParams(cp, result.mFailCause, -1);
                            transitionTo(mInactiveState);
                            break;
                        case ERR_UnacceptableParameter:
                            // The addresses given from the RIL are bad
                            tearDownData(cp);
                            transitionTo(mDisconnectingErrorCreatingConnection);
                            break;
                        case ERR_GetLastErrorFromRil:
                            // Request failed and this is an old RIL
                            phone.mCM.getLastDataCallFailCause(
                                    obtainMessage(EVENT_GET_LAST_FAIL_DONE, cp));
                            break;
                        case ERR_RilError:
                            // Request failed and mFailCause has the reason
                            mInactiveState.setEnterNotificationParams(cp, result.mFailCause,
                                                                      getSuggestedRetryTime(ar));
                            transitionTo(mInactiveState);
                            break;
                        case ERR_Stale:
                            // Request is stale, ignore.
                            break;
                        default:
                            throw new RuntimeException("Unknown SetupResult, should not happen");
                    }
                    retVal = HANDLED;
                    break;

                case EVENT_GET_LAST_FAIL_DONE:
                    ar = (AsyncResult) msg.obj;
                    cp = (ConnectionParams) ar.userObj;
                    FailCause cause = FailCause.UNKNOWN;

                    if (cp.tag == mTag) {
                        if (DBG) log("DcActivatingState msg.what=EVENT_GET_LAST_FAIL_DONE");
                        if (ar.exception == null) {
                            int rilFailCause = ((int[]) (ar.result))[0];
                            cause = FailCause.fromInt(rilFailCause);
                        }
                        // Transition to inactive but send notifications after
                        // we've entered the mInactive state.
                        mInactiveState.setEnterNotificationParams(cp, cause, -1);
                        transitionTo(mInactiveState);
                    } else {
                        if (DBG) {
                            log("DcActivatingState EVENT_GET_LAST_FAIL_DONE is stale cp.tag="
                                + cp.tag + ", mTag=" + mTag);
                        }
                    }

                    retVal = HANDLED;
                    break;

                default:
                    if (VDBG) {
                        log("DcActivatingState not handled msg.what=0x" +
                                Integer.toHexString(msg.what));
                    }
                    retVal = NOT_HANDLED;
                    break;
            }
            return retVal;
        }
        
    }
    
    private class DcActiveState extends State {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.550 -0500", hash_original_field = "9331D1B74412EEA32E7D978E870794E4", hash_generated_field = "88BEDA692751646D94B15E7361FCC4BA")

        private ConnectionParams mConnectionParams = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.552 -0500", hash_original_field = "ED45C6D4763DC12F21AF23A599FF017C", hash_generated_field = "989525539D6A577B96BED5903F7F8BDA")

        private FailCause mFailCause = null;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.922 -0400", hash_original_method = "5052F6BB3696B9FBB5C9B1F89FD73944", hash_generated_method = "5052F6BB3696B9FBB5C9B1F89FD73944")
        public DcActiveState ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.555 -0500", hash_original_method = "65AC06854CC9D1F4537757F901F06476", hash_generated_method = "10EC41C7C6977BCF1FFAB3A732480EE5")
        
public void setEnterNotificationParams(ConnectionParams cp, FailCause cause) {
            if (VDBG) log("DcInactiveState: setEnterNoticationParams cp,cause");
            mConnectionParams = cp;
            mFailCause = cause;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.558 -0500", hash_original_method = "F04274E6B6E666DB4B8B2ADDB4ED15CF", hash_generated_method = "9C1242280C9541F362D38EE0DA29BA42")
        
@Override public void enter() {
            /**
             * Now that we've transitioned to Active state we
             * can send notifications. Previously we sent the
             * notifications in the processMessage handler but
             * that caused a race condition because the synchronous
             * call to isActive.
             */
            if ((mConnectionParams != null) && (mFailCause != null)) {
                if (VDBG) log("DcActiveState: enter notifyConnectCompleted");
                notifyConnectCompleted(mConnectionParams, mFailCause);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.561 -0500", hash_original_method = "6361033575190DC86852AD59967B3D8E", hash_generated_method = "BBED3B03F5FFE8CC08D2DFA346B74DDD")
        
@Override
        public void exit() {
            // clear notifications
            mConnectionParams = null;
            mFailCause = null;
        }

        @DSSink({DSSinkKind.SYSTEM_SETTINGS})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.564 -0500", hash_original_method = "E272CADF23159A9F3D514AE20DA7ACA2", hash_generated_method = "45DE66645C6A9E15E4697E27BA2B200B")
        
@Override
        public boolean processMessage(Message msg) {
            boolean retVal;

            switch (msg.what) {
                case EVENT_CONNECT:
                    mRefCount++;
                    if (DBG) log("DcActiveState msg.what=EVENT_CONNECT RefCount=" + mRefCount);
                    if (msg.obj != null) {
                        notifyConnectCompleted((ConnectionParams) msg.obj, FailCause.NONE);
                    }
                    retVal = HANDLED;
                    break;
                case EVENT_DISCONNECT:
                    mRefCount--;
                    if (DBG) log("DcActiveState msg.what=EVENT_DISCONNECT RefCount=" + mRefCount);
                    if (mRefCount == 0)
                    {
                        DisconnectParams dp = (DisconnectParams) msg.obj;
                        dp.tag = mTag;
                        tearDownData(dp);
                        transitionTo(mDisconnectingState);
                    } else {
                        if (msg.obj != null) {
                            notifyDisconnectCompleted((DisconnectParams) msg.obj);
                        }
                    }
                    retVal = HANDLED;
                    break;

                default:
                    if (VDBG) {
                        log("DcActiveState not handled msg.what=0x" +
                                Integer.toHexString(msg.what));
                    }
                    retVal = NOT_HANDLED;
                    break;
            }
            return retVal;
        }
        
    }
    
    private class DcDisconnectingState extends State {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.923 -0400", hash_original_method = "29C0CB68E08F466587ED5BC2F5C6C796", hash_generated_method = "29C0CB68E08F466587ED5BC2F5C6C796")
        public DcDisconnectingState ()
        {
            //Synthesized constructor
        }
        @DSSink({DSSinkKind.SYSTEM_SETTINGS})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.573 -0500", hash_original_method = "DD3249EFBD400B69680BE43C46063370", hash_generated_method = "CA76C19EE6D4A5F25104AD5C7D5CBC7D")
        
@Override
        public boolean processMessage(Message msg) {
            boolean retVal;

            switch (msg.what) {
                case EVENT_CONNECT:
                    if (DBG) log("DcDisconnectingState msg.what=EVENT_CONNECT. Defer. RefCount = "
                            + mRefCount);
                    deferMessage(msg);
                    retVal = HANDLED;
                    break;

                case EVENT_DEACTIVATE_DONE:
                    if (DBG) log("DcDisconnectingState msg.what=EVENT_DEACTIVATE_DONE");
                    AsyncResult ar = (AsyncResult) msg.obj;
                    DisconnectParams dp = (DisconnectParams) ar.userObj;
                    if (dp.tag == mTag) {
                        // Transition to inactive but send notifications after
                        // we've entered the mInactive state.
                        mInactiveState.setEnterNotificationParams((DisconnectParams) ar.userObj);
                        transitionTo(mInactiveState);
                    } else {
                        if (DBG) log("DcDisconnectState EVENT_DEACTIVATE_DONE stale dp.tag="
                                + dp.tag + " mTag=" + mTag);
                    }
                    retVal = HANDLED;
                    break;

                default:
                    if (VDBG) {
                        log("DcDisconnectingState not handled msg.what=0x" +
                                Integer.toHexString(msg.what));
                    }
                    retVal = NOT_HANDLED;
                    break;
            }
            return retVal;
        }
        
    }
    
    private class DcDisconnectionErrorCreatingConnection extends State {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.924 -0400", hash_original_method = "9EEE01BC14CD1B0E43AEFA5AA17972F9", hash_generated_method = "9EEE01BC14CD1B0E43AEFA5AA17972F9")
        public DcDisconnectionErrorCreatingConnection ()
        {
            //Synthesized constructor
        }
        @DSSink({DSSinkKind.SYSTEM_SETTINGS})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.581 -0500", hash_original_method = "E9D4515D62B87825C79C67876E4313E2", hash_generated_method = "527B9BB21F5B68B1236CBF0C7A1B3A22")
        
@Override
        public boolean processMessage(Message msg) {
            boolean retVal;

            switch (msg.what) {
                case EVENT_DEACTIVATE_DONE:
                    AsyncResult ar = (AsyncResult) msg.obj;
                    ConnectionParams cp = (ConnectionParams) ar.userObj;
                    if (cp.tag == mTag) {
                        if (DBG) {
                            log("DcDisconnectionErrorCreatingConnection" +
                                " msg.what=EVENT_DEACTIVATE_DONE");
                        }

                        // Transition to inactive but send notifications after
                        // we've entered the mInactive state.
                        mInactiveState.setEnterNotificationParams(cp,
                                FailCause.UNACCEPTABLE_NETWORK_PARAMETER, -1);
                        transitionTo(mInactiveState);
                    } else {
                        if (DBG) {
                            log("DcDisconnectionErrorCreatingConnection EVENT_DEACTIVATE_DONE" +
                                    " stale dp.tag=" + cp.tag + ", mTag=" + mTag);
                        }
                    }
                    retVal = HANDLED;
                    break;

                default:
                    if (VDBG) {
                        log("DcDisconnectionErrorCreatingConnection not handled msg.what=0x"
                                + Integer.toHexString(msg.what));
                    }
                    retVal = NOT_HANDLED;
                    break;
            }
            return retVal;
        }
        
    }

    /**
     * @return retry manager isRetryNeeded
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.453 -0500", hash_original_method = "BE0E8B7CBE5F430456218437A69801A6", hash_generated_method = "63D61DEBE696AB53F58E55129B2BEA7E")
    
public boolean isRetryNeeded() {
        return mRetryMgr.isRetryNeeded();
    }

    /**
     * resetRetryCount of retry manager
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.456 -0500", hash_original_method = "6E600B114543C0C51BDDB686B0EEF1BE", hash_generated_method = "7F306DCD411DEC2D7B406E5C361F8D8B")
    
public void resetRetryCount() {
        mRetryMgr.resetRetryCount();
    }

    /**
     * set retryForeverUsingLasttimeout of retry manager
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.458 -0500", hash_original_method = "FE4AFC35148D7FCE7B6DEB885B8B31DF", hash_generated_method = "A57A561DABF82C08BCC8D59E43370070")
    
public void retryForeverUsingLastTimeout() {
        mRetryMgr.retryForeverUsingLastTimeout();
    }

    /**
     * @return retry manager isRetryForever
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.460 -0500", hash_original_method = "7BE7662A27A4557E7DE38D4C4F7B834F", hash_generated_method = "4D25C45DD61B55EC85A4BCDC82B33DF8")
    
public boolean isRetryForever() {
        return mRetryMgr.isRetryForever();
    }

    /**
     * @return whether the retry config is set successfully or not
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.463 -0500", hash_original_method = "7F3E6401D154FAD4235CC7C3EA752D6F", hash_generated_method = "719D61E4FDCDA2501750D227233085F3")
    
public boolean configureRetry(int maxRetryCount, int retryTime, int randomizationTime) {
        return mRetryMgr.configure(maxRetryCount, retryTime, randomizationTime);
    }

    /**
     * @return whether the retry config is set successfully or not
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.465 -0500", hash_original_method = "23B74F0922BA8C1F44E04170074AC8EE", hash_generated_method = "FF391CC5822CC646A6CB5E61E7BC7116")
    
public boolean configureRetry(String configStr) {
        return mRetryMgr.configure(configStr);
    }

    /*
     * **************************************************************************
     * End members owned by DataConnectionTracker
     * **************************************************************************
     */

    /**
     * Clear all settings called when entering mInactiveState.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.467 -0500", hash_original_method = "14EAC6C2DDCA29A3543D7FF941CEE3A4", hash_generated_method = "EF706BA182F080CEAE6EE67D305C3FC3")
    
protected void clearSettings() {
        if (DBG) log("clearSettings");

        createTime = -1;
        lastFailTime = -1;
        lastFailCause = FailCause.NONE;
        mRetryOverride = -1;
        mRefCount = 0;
        cid = -1;

        mLinkProperties = new LinkProperties();
        mApn = null;
    }

    /**
     * Process setup completion.
     *
     * @param ar is the result
     * @return SetupResult.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.471 -0500", hash_original_method = "75094A2EA3723036F1D43E5DA379759D", hash_generated_method = "BFA7FE6A24ABD2E78AA0E1B78CFE8EAA")
    
private DataCallState.SetupResult onSetupConnectionCompleted(AsyncResult ar) {
        DataCallState response = (DataCallState) ar.result;
        ConnectionParams cp = (ConnectionParams) ar.userObj;
        DataCallState.SetupResult result;

        if (ar.exception != null) {
            if (DBG) {
                log("onSetupConnectionCompleted failed, ar.exception=" + ar.exception +
                    " response=" + response);
            }

            if (ar.exception instanceof CommandException
                    && ((CommandException) (ar.exception)).getCommandError()
                    == CommandException.Error.RADIO_NOT_AVAILABLE) {
                result = DataCallState.SetupResult.ERR_BadCommand;
                result.mFailCause = FailCause.RADIO_NOT_AVAILABLE;
            } else if ((response == null) || (response.version < 4)) {
                result = DataCallState.SetupResult.ERR_GetLastErrorFromRil;
            } else {
                result = DataCallState.SetupResult.ERR_RilError;
                result.mFailCause = FailCause.fromInt(response.status);
            }
        } else if (cp.tag != mTag) {
            if (DBG) {
                log("BUG: onSetupConnectionCompleted is stale cp.tag=" + cp.tag + ", mtag=" + mTag);
            }
            result = DataCallState.SetupResult.ERR_Stale;
        } else if (response.status != 0) {
            result = DataCallState.SetupResult.ERR_RilError;
            result.mFailCause = FailCause.fromInt(response.status);
        } else {
            if (DBG) log("onSetupConnectionCompleted received DataCallState: " + response);
            cid = response.cid;
            result = updateLinkProperty(response).setupResult;
        }

        return result;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.474 -0500", hash_original_method = "F1DF17AEAB523CA725A1A0E7587A5B33", hash_generated_method = "B875365F6645C433F911EE264E8920EF")
    
private int getSuggestedRetryTime(AsyncResult ar) {
        int retry = -1;
        if (ar.exception == null) {
            DataCallState response = (DataCallState) ar.result;
            retry =  response.suggestedRetryTime;
        }
        return retry;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.476 -0500", hash_original_method = "61A23083F49649744D5BB908131730E7", hash_generated_method = "24D77B8D63BA4531CDF47D1BD1328EF4")
    
private DataCallState.SetupResult setLinkProperties(DataCallState response,
            LinkProperties lp) {
        // Check if system property dns usable
        boolean okToUseSystemPropertyDns = false;
        String propertyPrefix = "net." + response.ifname + ".";
        String dnsServers[] = new String[2];
        dnsServers[0] = SystemProperties.get(propertyPrefix + "dns1");
        dnsServers[1] = SystemProperties.get(propertyPrefix + "dns2");
        okToUseSystemPropertyDns = isDnsOk(dnsServers);

        // set link properties based on data call response
        return response.setLinkProperties(lp, okToUseSystemPropertyDns);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.492 -0500", hash_original_method = "45E9586484C37E223B6289BDE8E786AB", hash_generated_method = "A0BCB6F9A13B2E81768550526AC72A0B")
    
private UpdateLinkPropertyResult updateLinkProperty(DataCallState newState) {
        UpdateLinkPropertyResult result = new UpdateLinkPropertyResult(mLinkProperties);

        if (newState == null) return result;

        DataCallState.SetupResult setupResult;
        result.newLp = new LinkProperties();

        // set link properties based on data call response
        result.setupResult = setLinkProperties(newState, result.newLp);
        if (result.setupResult != DataCallState.SetupResult.SUCCESS) {
            if (DBG) log("updateLinkProperty failed : " + result.setupResult);
            return result;
        }
        // copy HTTP proxy as it is not part DataCallState.
        result.newLp.setHttpProxy(mLinkProperties.getHttpProxy());

        if (DBG && (! result.oldLp.equals(result.newLp))) {
            if (DBG) log("updateLinkProperty old != new");
            if (VDBG) log("updateLinkProperty old LP=" + result.oldLp);
            if (VDBG) log("updateLinkProperty new LP=" + result.newLp);
        }
        mLinkProperties = result.newLp;

        return result;
    }

    // ******* public interface

    /**
     * Bring up a connection to the apn and return an AsyncResult in onCompletedMsg.
     * Used for cellular networks that use Acesss Point Names (APN) such
     * as GSM networks.
     *
     * @param onCompletedMsg is sent with its msg.obj as an AsyncResult object.
     *        With AsyncResult.userObj set to the original msg.obj,
     *        AsyncResult.result = FailCause and AsyncResult.exception = Exception().
     * @param apn is the Access Point Name to bring up a connection to
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.588 -0500", hash_original_method = "DA4DADB76FBE855C8C796E356354585B", hash_generated_method = "02DE71F5A2DED1B8D1539D74DA0D1203")
    
public void bringUp(Message onCompletedMsg, ApnSetting apn) {
        sendMessage(obtainMessage(EVENT_CONNECT, new ConnectionParams(apn, onCompletedMsg)));
    }

    /**
     * Tear down the connection through the apn on the network.
     *
     * @param onCompletedMsg is sent with its msg.obj as an AsyncResult object.
     *        With AsyncResult.userObj set to the original msg.obj.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:48.590 -0500", hash_original_method = "16642B60370F95B35D583CCC8A36D6BF", hash_generated_method = "4F2A70DA28EDB1BEF6AAC105F0EB59FD")
    
public void tearDown(String reason, Message onCompletedMsg) {
        sendMessage(obtainMessage(EVENT_DISCONNECT, new DisconnectParams(reason, onCompletedMsg)));
    }
}

