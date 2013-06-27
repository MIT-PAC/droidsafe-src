package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.telephony.DataCallState.SetupResult;
import com.android.internal.util.AsyncChannel;
import com.android.internal.util.Protocol;
import com.android.internal.util.State;
import com.android.internal.util.StateMachine;
import android.app.PendingIntent;
import android.net.LinkCapabilities;
import android.net.LinkProperties;
import android.net.ProxyProperties;
import android.os.AsyncResult;
import android.os.Message;
import android.os.SystemProperties;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class DataConnection extends StateMachine {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.343 -0400", hash_original_field = "DA5953071EE7823FDF8D83F49423D96B", hash_generated_field = "CD0721759B4466C03691E733797DD315")

    protected AsyncChannel mAc;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.344 -0400", hash_original_field = "DBD79858C5E50CD8821FE7C8D65E495B", hash_generated_field = "C4FE21B00EEE6A458E193D584E7E2C76")

    private List<ApnContext> mApnList = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.344 -0400", hash_original_field = "F624BA341CEE490E0F6E6147BBEFD20A", hash_generated_field = "43EA75A8E40D96F1FE9644BAABB59B27")

    PendingIntent mReconnectIntent = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.344 -0400", hash_original_field = "D73A59E9012E9F1B2B0381F2B99244EB", hash_generated_field = "861BA63EA88683DE381E86F4D6D3F1AD")

    protected ApnSetting mApn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.344 -0400", hash_original_field = "07496860B5C53FDD66588727158D5F73", hash_generated_field = "DD44804C5337E386664F560C02BE343C")

    protected int mTag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.344 -0400", hash_original_field = "F7A42FE7211F98AC7A60A285AC3A9E87", hash_generated_field = "4FEA837943E73EF5CB83661843F1AD15")

    protected PhoneBase phone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.344 -0400", hash_original_field = "C377C6F97C92F8D0FBD252C9A0BEFE61", hash_generated_field = "580E7C4318D3476CC0659BF42E5F3A02")

    protected int mRilVersion = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.344 -0400", hash_original_field = "4B7CC5694DD3A265BAC326EABA31266E", hash_generated_field = "A51EAFC1706A086015D96F276D59C143")

    protected int cid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.344 -0400", hash_original_field = "B8279A4588519617AACD8162DC8B7A3D", hash_generated_field = "A5A5AFED252C7D512DACD2841D863761")

    protected LinkProperties mLinkProperties = new LinkProperties();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.344 -0400", hash_original_field = "16376715C2450E19AB99EA16CA75CD60", hash_generated_field = "A46D45BD76CF171387C1C09380918B0D")

    protected LinkCapabilities mCapabilities = new LinkCapabilities();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.344 -0400", hash_original_field = "1ED2E1B19B6E55D52D2473BE17A4AFD9", hash_generated_field = "BDD8643E97E5DC61E6EAAAF64140026D")

    protected long createTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.344 -0400", hash_original_field = "760B31CC56D2FB25A6A1C5A368F2683F", hash_generated_field = "A20A821CFA63B57B209D4480F0D19EFE")

    protected long lastFailTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.344 -0400", hash_original_field = "CEF28067CDCF0529C1FAE13BBD637F0D", hash_generated_field = "6C25BC29EE727D8706010965EC862301")

    protected FailCause lastFailCause;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.344 -0400", hash_original_field = "CCE2A9E206B7E958ABA7455CB2F70FC3", hash_generated_field = "DE06CED5AB988CDFE56F6FF52DB76E5B")

    protected int mRetryOverride = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.344 -0400", hash_original_field = "DAC8A06C1EDF9825CDAF6DFCD18A7ADC", hash_generated_field = "66F3E0510779BE4D1B59CDAC387E6C47")

    private int mRefCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.344 -0400", hash_original_field = "56491F2E1C74898E18BB6E47D2425B19", hash_generated_field = "64F9C8FFBF59E1349A604124A0E0710A")

    Object userData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.344 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "9AA2EA3A2433F5D6F841BEFD54A673B4")

    private int mId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.344 -0400", hash_original_field = "7D24E53F19D56D7A29B7BFB52B2F4C21", hash_generated_field = "6C728820465A4CC87E1F72987D225AAA")

    private RetryManager mRetryMgr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.344 -0400", hash_original_field = "45077AA2C731BE80F694DDAEF8E2A07C", hash_generated_field = "69571CA19C3B558505D31735F0F9B91B")

    private DcDefaultState mDefaultState = new DcDefaultState();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.344 -0400", hash_original_field = "1C6EC94A598D515735A3FE7B72C0A405", hash_generated_field = "F5AB6F71A92E9D262A29AB9EF8925002")

    private DcInactiveState mInactiveState = new DcInactiveState();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.344 -0400", hash_original_field = "3C1683BF56A594E4DEB6A2E038638234", hash_generated_field = "DDDC0B6EBEB86603B4A087252D031623")

    private DcActivatingState mActivatingState = new DcActivatingState();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.344 -0400", hash_original_field = "04925F16D72BAEAA0EE7EB33B483185E", hash_generated_field = "9D5433FE7E5E65E836534512E552B10F")

    private DcActiveState mActiveState = new DcActiveState();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.344 -0400", hash_original_field = "2B8B7AD8EC6BCD01415CED9815E426D1", hash_generated_field = "D3E64CA9FA2850A1BACA275155C23DC5")

    private DcDisconnectingState mDisconnectingState = new DcDisconnectingState();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.344 -0400", hash_original_field = "9769FD31F0BD672EC82091014B0948DA", hash_generated_field = "CD618074011D52150D4FE826A3AA4C98")

    private DcDisconnectionErrorCreatingConnection mDisconnectingErrorCreatingConnection = new DcDisconnectionErrorCreatingConnection();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.353 -0400", hash_original_method = "C1A86AB25296EBC0B07A31287A18BD02", hash_generated_method = "CA6F7A47D85CD882D0D54A4CABE138F1")
    protected  DataConnection(PhoneBase phone, String name, int id, RetryManager rm) {
        super(name);
        log("DataConnection constructor E");
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
        log("DataConnection constructor X");
        addTaint(name.getTaint());
        // ---------- Original Method ----------
        //if (DBG) log("DataConnection constructor E");
        //this.phone = phone;
        //mId = id;
        //mRetryMgr = rm;
        //this.cid = -1;
        //setDbg(false);
        //addState(mDefaultState);
        //addState(mInactiveState, mDefaultState);
        //addState(mActivatingState, mDefaultState);
        //addState(mActiveState, mDefaultState);
        //addState(mDisconnectingState, mDefaultState);
        //addState(mDisconnectingErrorCreatingConnection, mDefaultState);
        //setInitialState(mInactiveState);
        //mApnList = new ArrayList<ApnContext>();
        //if (DBG) log("DataConnection constructor X");
    }

    
        @Override
public abstract String toString();

    
    protected abstract void onConnect(ConnectionParams cp);

    
    protected abstract boolean isDnsOk(String[] domainNameServers);

    
    protected abstract void log(String s);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.354 -0400", hash_original_method = "59ED68D7EF373C505428063E232AFE5C", hash_generated_method = "A2646FFE37D1F99C95B1B7A5AC66A092")
    private void tearDownData(Object o) {
        int discReason;
        discReason = RILConstants.DEACTIVATE_REASON_NONE;
        {
            DisconnectParams dp;
            dp = (DisconnectParams)o;
            Message m;
            m = dp.onCompletedMsg;
            {
                boolean varC0DA3759AD518C5BDD466277C93185D6_543136426 = (TextUtils.equals(dp.reason, Phone.REASON_RADIO_TURNED_OFF));
                {
                    discReason = RILConstants.DEACTIVATE_REASON_RADIO_OFF;
                } //End block
                {
                    boolean var1B725C4E69E932624B2BF80526814400_2005264857 = (TextUtils.equals(dp.reason, Phone.REASON_PDP_RESET));
                    {
                        discReason = RILConstants.DEACTIVATE_REASON_PDP_RESET;
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        {
            boolean varEB239098BBFA2AD31684A01774D8510E_338587602 = (phone.mCM.getRadioState().isOn());
            {
                log("tearDownData radio is on, call deactivateDataCall");
                phone.mCM.deactivateDataCall(cid, discReason, obtainMessage(EVENT_DEACTIVATE_DONE, o));
            } //End block
            {
                log("tearDownData radio is off sendMessage EVENT_DEACTIVATE_DONE immediately");
                AsyncResult ar;
                ar = new AsyncResult(o, null, null);
                sendMessage(obtainMessage(EVENT_DEACTIVATE_DONE, ar));
            } //End block
        } //End collapsed parenthetic
        addTaint(o.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.355 -0400", hash_original_method = "4864ED15F4860BAE9DD2587736D4A08F", hash_generated_method = "5A84CD3B4FA8A12654EA6525276F41E7")
    private void notifyConnectCompleted(ConnectionParams cp, FailCause cause) {
        Message connectionCompletedMsg;
        connectionCompletedMsg = cp.onCompletedMsg;
        long timeStamp;
        timeStamp = System.currentTimeMillis();
        connectionCompletedMsg.arg1 = cid;
        {
            createTime = timeStamp;
            AsyncResult.forMessage(connectionCompletedMsg);
        } //End block
        {
            lastFailCause = cause;
            lastFailTime = timeStamp;
            AsyncResult.forMessage(connectionCompletedMsg, cause,
                                   new CallSetupException(mRetryOverride));
        } //End block
        log("notifyConnectionCompleted at " + timeStamp + " cause=" + cause);
        connectionCompletedMsg.sendToTarget();
        addTaint(cp.getTaint());
        // ---------- Original Method ----------
        //Message connectionCompletedMsg = cp.onCompletedMsg;
        //if (connectionCompletedMsg == null) {
            //return;
        //}
        //long timeStamp = System.currentTimeMillis();
        //connectionCompletedMsg.arg1 = cid;
        //if (cause == FailCause.NONE) {
            //createTime = timeStamp;
            //AsyncResult.forMessage(connectionCompletedMsg);
        //} else {
            //lastFailCause = cause;
            //lastFailTime = timeStamp;
            //AsyncResult.forMessage(connectionCompletedMsg, cause,
                                   //new CallSetupException(mRetryOverride));
        //}
        //if (DBG) log("notifyConnectionCompleted at " + timeStamp + " cause=" + cause);
        //connectionCompletedMsg.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.368 -0400", hash_original_method = "DB15644DADCD9FE90AC8779F50E40D9C", hash_generated_method = "01EC210DADBB2D1835DA664FC85EB522")
    private void notifyDisconnectCompleted(DisconnectParams dp) {
        log("NotifyDisconnectCompleted");
        {
            Message msg;
            msg = dp.onCompletedMsg;
            {
                log(String.format("msg=%s msg.obj=%s", msg.toString(),
                    ((msg.obj instanceof String) ? (String) msg.obj : "<no-reason>")));
            } //End block
            AsyncResult.forMessage(msg);
            msg.sendToTarget();
        } //End block
        log("NotifyDisconnectCompleted DisconnectParams=" + dp);
        addTaint(dp.getTaint());
        // ---------- Original Method ----------
        //if (VDBG) log("NotifyDisconnectCompleted");
        //if (dp.onCompletedMsg != null) {
            //Message msg = dp.onCompletedMsg;
            //if (VDBG) {
                //log(String.format("msg=%s msg.obj=%s", msg.toString(),
                    //((msg.obj instanceof String) ? (String) msg.obj : "<no-reason>")));
            //}
            //AsyncResult.forMessage(msg);
            //msg.sendToTarget();
        //}
        //if (DBG) log("NotifyDisconnectCompleted DisconnectParams=" + dp);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.368 -0400", hash_original_method = "1BB05B964694E45E9B1991E5D1915447", hash_generated_method = "4F06D644C87794A4E6929E821290310D")
    protected int getRadioTechnology(int defaultRadioTechnology) {
        int radioTechnology;
        {
            radioTechnology = defaultRadioTechnology;
        } //End block
        {
            radioTechnology = phone.getServiceState().getRadioTechnology() + 2;
        } //End block
        addTaint(defaultRadioTechnology);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1490318622 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1490318622;
        // ---------- Original Method ----------
        //int radioTechnology;
        //if (mRilVersion < 6) {
            //radioTechnology = defaultRadioTechnology;
        //} else {
            //radioTechnology = phone.getServiceState().getRadioTechnology() + 2;
        //}
        //return radioTechnology;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.369 -0400", hash_original_method = "AAF5779D145C421CCE90F0916803977D", hash_generated_method = "6137C9D1DFC324536F3950DBC6729258")
    public int getDataConnectionId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1107364178 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1107364178;
        // ---------- Original Method ----------
        //return mId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.369 -0400", hash_original_method = "FC51BF074579EE4E5F8C7AB511B49B8A", hash_generated_method = "FB39746B5F2C0A4C8FA99AFACE9626A2")
    public int getRetryCount() {
        int var449CA49043C973C5751EB0A39E24CB1F_1946998057 = (mRetryMgr.getRetryCount());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1359773157 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1359773157;
        // ---------- Original Method ----------
        //return mRetryMgr.getRetryCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.369 -0400", hash_original_method = "21D3097027A7BF6D8D1F04609D8A2AE9", hash_generated_method = "B17BFCF23A7B51B6EF02AE64A6AF4188")
    public int getRetryTimer() {
        int var3D330706D3357A0015985CFA9194A2D9_1736500869 = (mRetryMgr.getRetryTimer());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_595595940 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_595595940;
        // ---------- Original Method ----------
        //return mRetryMgr.getRetryTimer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.370 -0400", hash_original_method = "2EFBBED22C4BDBBAA07E00436CC70BDF", hash_generated_method = "0E371755B2F0C7630C7641033AED74E0")
    public void increaseRetryCount() {
        mRetryMgr.increaseRetryCount();
        // ---------- Original Method ----------
        //mRetryMgr.increaseRetryCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.370 -0400", hash_original_method = "BE0E8B7CBE5F430456218437A69801A6", hash_generated_method = "859CC59AE10A6A70E543611B987913B6")
    public boolean isRetryNeeded() {
        boolean var2557A79863F82C24CE058A4712E3B3F7_995851982 = (mRetryMgr.isRetryNeeded());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1482007851 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1482007851;
        // ---------- Original Method ----------
        //return mRetryMgr.isRetryNeeded();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.370 -0400", hash_original_method = "6E600B114543C0C51BDDB686B0EEF1BE", hash_generated_method = "32DE04BB7113D9D458E9B8A4B5F7798C")
    public void resetRetryCount() {
        mRetryMgr.resetRetryCount();
        // ---------- Original Method ----------
        //mRetryMgr.resetRetryCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.370 -0400", hash_original_method = "FE4AFC35148D7FCE7B6DEB885B8B31DF", hash_generated_method = "8D1E6E9AC70CC605B5E9E3DFBC8CC440")
    public void retryForeverUsingLastTimeout() {
        mRetryMgr.retryForeverUsingLastTimeout();
        // ---------- Original Method ----------
        //mRetryMgr.retryForeverUsingLastTimeout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.370 -0400", hash_original_method = "7BE7662A27A4557E7DE38D4C4F7B834F", hash_generated_method = "2A724F721C48983FAAB66ED5235ABC8C")
    public boolean isRetryForever() {
        boolean var491B6D9ADB68663515B16F16BFDDD6EB_1712935770 = (mRetryMgr.isRetryForever());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1233005482 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1233005482;
        // ---------- Original Method ----------
        //return mRetryMgr.isRetryForever();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.371 -0400", hash_original_method = "7F3E6401D154FAD4235CC7C3EA752D6F", hash_generated_method = "5761277C6107DFAECE348977CC900836")
    public boolean configureRetry(int maxRetryCount, int retryTime, int randomizationTime) {
        boolean var5C383AB26692B2465A8A92603FAE13E1_1011210829 = (mRetryMgr.configure(maxRetryCount, retryTime, randomizationTime));
        addTaint(maxRetryCount);
        addTaint(retryTime);
        addTaint(randomizationTime);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1902123606 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1902123606;
        // ---------- Original Method ----------
        //return mRetryMgr.configure(maxRetryCount, retryTime, randomizationTime);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.372 -0400", hash_original_method = "23B74F0922BA8C1F44E04170074AC8EE", hash_generated_method = "253556B21A17AA47CE6C1A4B2773DC44")
    public boolean configureRetry(String configStr) {
        boolean varECAEB0BD560D7A3FDF27280B64D27C2B_1452484975 = (mRetryMgr.configure(configStr));
        addTaint(configStr.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1680347234 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1680347234;
        // ---------- Original Method ----------
        //return mRetryMgr.configure(configStr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.372 -0400", hash_original_method = "14EAC6C2DDCA29A3543D7FF941CEE3A4", hash_generated_method = "DCEB0D12A18217ADB13992E69EBA0B03")
    protected void clearSettings() {
        log("clearSettings");
        createTime = -1;
        lastFailTime = -1;
        lastFailCause = FailCause.NONE;
        mRetryOverride = -1;
        mRefCount = 0;
        cid = -1;
        mLinkProperties = new LinkProperties();
        mApn = null;
        // ---------- Original Method ----------
        //if (DBG) log("clearSettings");
        //createTime = -1;
        //lastFailTime = -1;
        //lastFailCause = FailCause.NONE;
        //mRetryOverride = -1;
        //mRefCount = 0;
        //cid = -1;
        //mLinkProperties = new LinkProperties();
        //mApn = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.391 -0400", hash_original_method = "75094A2EA3723036F1D43E5DA379759D", hash_generated_method = "661D3E8C6BFFD7F95CE18BE56ADEA332")
    private DataCallState.SetupResult onSetupConnectionCompleted(AsyncResult ar) {
        DataCallState.SetupResult varB4EAC82CA7396A68D541C85D26508E83_2053154216 = null; //Variable for return #1
        DataCallState response;
        response = (DataCallState) ar.result;
        ConnectionParams cp;
        cp = (ConnectionParams) ar.userObj;
        DataCallState.SetupResult result;
        {
            {
                log("onSetupConnectionCompleted failed, ar.exception=" + ar.exception +
                    " response=" + response);
            } //End block
            {
                boolean var1E63C7E427F0E7C15DB7AC2E851044B0_1161715974 = (ar.exception instanceof CommandException
                    && ((CommandException) (ar.exception)).getCommandError()
                    == CommandException.Error.RADIO_NOT_AVAILABLE);
                {
                    result = DataCallState.SetupResult.ERR_BadCommand;
                    result.mFailCause = FailCause.RADIO_NOT_AVAILABLE;
                } //End block
                {
                    result = DataCallState.SetupResult.ERR_GetLastErrorFromRil;
                } //End block
                {
                    result = DataCallState.SetupResult.ERR_RilError;
                    result.mFailCause = FailCause.fromInt(response.status);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                log("BUG: onSetupConnectionCompleted is stale cp.tag=" + cp.tag + ", mtag=" + mTag);
            } //End block
            result = DataCallState.SetupResult.ERR_Stale;
        } //End block
        {
            result = DataCallState.SetupResult.ERR_RilError;
            result.mFailCause = FailCause.fromInt(response.status);
        } //End block
        {
            log("onSetupConnectionCompleted received DataCallState: " + response);
            cid = response.cid;
            result = updateLinkProperty(response).setupResult;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2053154216 = result;
        addTaint(ar.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2053154216.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2053154216;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.395 -0400", hash_original_method = "F1DF17AEAB523CA725A1A0E7587A5B33", hash_generated_method = "4791C282273EE0917410717455BA8385")
    private int getSuggestedRetryTime(AsyncResult ar) {
        int retry;
        retry = -1;
        {
            DataCallState response;
            response = (DataCallState) ar.result;
            retry =  response.suggestedRetryTime;
        } //End block
        addTaint(ar.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_586399828 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_586399828;
        // ---------- Original Method ----------
        //int retry = -1;
        //if (ar.exception == null) {
            //DataCallState response = (DataCallState) ar.result;
            //retry =  response.suggestedRetryTime;
        //}
        //return retry;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.404 -0400", hash_original_method = "61A23083F49649744D5BB908131730E7", hash_generated_method = "6166BB592837FC23053A9EE3757505E7")
    private DataCallState.SetupResult setLinkProperties(DataCallState response,
            LinkProperties lp) {
        DataCallState.SetupResult varB4EAC82CA7396A68D541C85D26508E83_250280841 = null; //Variable for return #1
        boolean okToUseSystemPropertyDns;
        okToUseSystemPropertyDns = false;
        String propertyPrefix;
        propertyPrefix = "net." + response.ifname + ".";
        String dnsServers[];
        dnsServers = new String[2];
        dnsServers[0] = SystemProperties.get(propertyPrefix + "dns1");
        dnsServers[1] = SystemProperties.get(propertyPrefix + "dns2");
        okToUseSystemPropertyDns = isDnsOk(dnsServers);
        varB4EAC82CA7396A68D541C85D26508E83_250280841 = response.setLinkProperties(lp, okToUseSystemPropertyDns);
        addTaint(response.getTaint());
        addTaint(lp.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_250280841.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_250280841;
        // ---------- Original Method ----------
        //boolean okToUseSystemPropertyDns = false;
        //String propertyPrefix = "net." + response.ifname + ".";
        //String dnsServers[] = new String[2];
        //dnsServers[0] = SystemProperties.get(propertyPrefix + "dns1");
        //dnsServers[1] = SystemProperties.get(propertyPrefix + "dns2");
        //okToUseSystemPropertyDns = isDnsOk(dnsServers);
        //return response.setLinkProperties(lp, okToUseSystemPropertyDns);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.406 -0400", hash_original_method = "45E9586484C37E223B6289BDE8E786AB", hash_generated_method = "A87B806276CA59298B03AF7E1392E3B7")
    private UpdateLinkPropertyResult updateLinkProperty(DataCallState newState) {
        UpdateLinkPropertyResult varB4EAC82CA7396A68D541C85D26508E83_1238189072 = null; //Variable for return #1
        UpdateLinkPropertyResult varB4EAC82CA7396A68D541C85D26508E83_2093676032 = null; //Variable for return #2
        UpdateLinkPropertyResult varB4EAC82CA7396A68D541C85D26508E83_180247280 = null; //Variable for return #3
        UpdateLinkPropertyResult result;
        result = new UpdateLinkPropertyResult(mLinkProperties);
        varB4EAC82CA7396A68D541C85D26508E83_1238189072 = result;
        DataCallState.SetupResult setupResult;
        result.newLp = new LinkProperties();
        result.setupResult = setLinkProperties(newState, result.newLp);
        {
            log("updateLinkProperty failed : " + result.setupResult);
            varB4EAC82CA7396A68D541C85D26508E83_2093676032 = result;
        } //End block
        result.newLp.setHttpProxy(mLinkProperties.getHttpProxy());
        {
            boolean var35DD507CF52E6FD709D552250B552C90_404377828 = (DBG && (! result.oldLp.equals(result.newLp)));
            {
                log("updateLinkProperty old != new");
                log("updateLinkProperty old LP=" + result.oldLp);
                log("updateLinkProperty new LP=" + result.newLp);
            } //End block
        } //End collapsed parenthetic
        mLinkProperties = result.newLp;
        varB4EAC82CA7396A68D541C85D26508E83_180247280 = result;
        addTaint(newState.getTaint());
        UpdateLinkPropertyResult varA7E53CE21691AB073D9660D615818899_1791734830; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1791734830 = varB4EAC82CA7396A68D541C85D26508E83_1238189072;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1791734830 = varB4EAC82CA7396A68D541C85D26508E83_2093676032;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1791734830 = varB4EAC82CA7396A68D541C85D26508E83_180247280;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1791734830.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1791734830;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.406 -0400", hash_original_method = "DA4DADB76FBE855C8C796E356354585B", hash_generated_method = "66030F493140D9C63678E6FDBD02C921")
    public void bringUp(Message onCompletedMsg, ApnSetting apn) {
        sendMessage(obtainMessage(EVENT_CONNECT, new ConnectionParams(apn, onCompletedMsg)));
        addTaint(onCompletedMsg.getTaint());
        addTaint(apn.getTaint());
        // ---------- Original Method ----------
        //sendMessage(obtainMessage(EVENT_CONNECT, new ConnectionParams(apn, onCompletedMsg)));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.407 -0400", hash_original_method = "16642B60370F95B35D583CCC8A36D6BF", hash_generated_method = "E9018126E6FF6A245DC7AE117B4CD793")
    public void tearDown(String reason, Message onCompletedMsg) {
        sendMessage(obtainMessage(EVENT_DISCONNECT, new DisconnectParams(reason, onCompletedMsg)));
        addTaint(reason.getTaint());
        addTaint(onCompletedMsg.getTaint());
        // ---------- Original Method ----------
        //sendMessage(obtainMessage(EVENT_DISCONNECT, new DisconnectParams(reason, onCompletedMsg)));
    }

    
    protected static class ConnectionParams {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.407 -0400", hash_original_field = "E4D23E841D8E8804190027BCE3180FA5", hash_generated_field = "FE8BF0CD5CB8CBF698330270CCCC9D95")

        public int tag;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.407 -0400", hash_original_field = "006F1F60AC2C8635325E1AE37581797A", hash_generated_field = "38CFCC1E5D60F78E53168DDFD409D179")

        public ApnSetting apn;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.407 -0400", hash_original_field = "B99F3B373002B73E9A2614F969860442", hash_generated_field = "5CDD027FA2114D7598947EC577C34B1B")

        public Message onCompletedMsg;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.483 -0400", hash_original_method = "9C883FBF948634C8BFC48155A41A0F4D", hash_generated_method = "5B1C503045A8C8AA9F1D0D2502298AF5")
        public  ConnectionParams(ApnSetting apn, Message onCompletedMsg) {
            this.apn = apn;
            this.onCompletedMsg = onCompletedMsg;
            // ---------- Original Method ----------
            //this.apn = apn;
            //this.onCompletedMsg = onCompletedMsg;
        }

        
    }


    
    protected static class DisconnectParams {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.483 -0400", hash_original_field = "E4D23E841D8E8804190027BCE3180FA5", hash_generated_field = "FE8BF0CD5CB8CBF698330270CCCC9D95")

        public int tag;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.483 -0400", hash_original_field = "40BEA8D637CDF2C1B07FCF0630482B73", hash_generated_field = "2E3A925DF54272DE75922655083A87FE")

        public String reason;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.483 -0400", hash_original_field = "B99F3B373002B73E9A2614F969860442", hash_generated_field = "5CDD027FA2114D7598947EC577C34B1B")

        public Message onCompletedMsg;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.484 -0400", hash_original_method = "8634A04E02B052AB53AF8D3EFA7F5294", hash_generated_method = "B99F546FDC561AFD0159FD12EB1DB176")
        public  DisconnectParams(String reason, Message onCompletedMsg) {
            this.reason = reason;
            this.onCompletedMsg = onCompletedMsg;
            // ---------- Original Method ----------
            //this.reason = reason;
            //this.onCompletedMsg = onCompletedMsg;
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
        private final int mErrorCode;
        private static final HashMap<Integer, FailCause> sErrorCodeToFailCauseMap;
        static {
            sErrorCodeToFailCauseMap = new HashMap<Integer, FailCause>();
            for (FailCause fc : values()) {
                sErrorCodeToFailCauseMap.put(fc.getErrorCode(), fc);
            }
        }
        FailCause(int errorCode) {
            mErrorCode = errorCode;
        }
        int getErrorCode() {
            return mErrorCode;
        }
        public boolean isPermanentFail() {
            return (this == OPERATOR_BARRED) || (this == MISSING_UNKNOWN_APN) ||
                   (this == UNKNOWN_PDP_ADDRESS_TYPE) || (this == USER_AUTHENTICATION) ||
                   (this == SERVICE_OPTION_NOT_SUPPORTED) ||
                   (this == SERVICE_OPTION_NOT_SUBSCRIBED) || (this == NSAPI_IN_USE) ||
                   (this == PROTOCOL_ERRORS);
        }
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
        public static FailCause fromInt(int errorCode) {
            FailCause fc = sErrorCodeToFailCauseMap.get(errorCode);
            if (fc == null) {
                fc = UNKNOWN;
            }
            return fc;
        }
    }

    
    public static class CallSetupException extends Exception {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.484 -0400", hash_original_field = "CCE2A9E206B7E958ABA7455CB2F70FC3", hash_generated_field = "032A6243CE5F8297EF5A6124BAD634D5")

        private int mRetryOverride = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.491 -0400", hash_original_method = "A504ADA2782D67F9E42B2FFAADC374C6", hash_generated_method = "D56974FF4E6B6EE04E4624DA72A498E3")
          CallSetupException(int retryOverride) {
            mRetryOverride = retryOverride;
            // ---------- Original Method ----------
            //mRetryOverride = retryOverride;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.491 -0400", hash_original_method = "474AEB2E917376DACCA3A8D3E49DB29C", hash_generated_method = "C1C44221EC572A824DC48C20B995D756")
        public int getRetryOverride() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_523062093 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_523062093;
            // ---------- Original Method ----------
            //return mRetryOverride;
        }

        
    }


    
    public static class UpdateLinkPropertyResult {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.491 -0400", hash_original_field = "789329C8124750D0DE93C78B911CE0DB", hash_generated_field = "C2A2765E7F96035E410CAF8D3027DAAC")

        public DataCallState.SetupResult setupResult = DataCallState.SetupResult.SUCCESS;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.491 -0400", hash_original_field = "E7D3E44D092EEA2E1D652BD6013620CD", hash_generated_field = "37B8435E7C404801E84F791E65EA2E96")

        public LinkProperties oldLp;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.491 -0400", hash_original_field = "D25BC672172ED598B59A0881EB7CA2CD", hash_generated_field = "8D8E816DF0FD888DB1A55D12D81B2844")

        public LinkProperties newLp;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.492 -0400", hash_original_method = "5FFECF7E7800E048A607977532017882", hash_generated_method = "5F3DBF488565FEEEF21CADA2F24034BE")
        public  UpdateLinkPropertyResult(LinkProperties curLp) {
            oldLp = curLp;
            newLp = curLp;
            // ---------- Original Method ----------
            //oldLp = curLp;
            //newLp = curLp;
        }

        
    }


    
    private class DcDefaultState extends State {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.492 -0400", hash_original_method = "65DC675B486478379964AECC5A2EA868", hash_generated_method = "65DC675B486478379964AECC5A2EA868")
        public DcDefaultState ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.492 -0400", hash_original_method = "AF33D4647C9368E21A04243E95A9DF92", hash_generated_method = "F27D177C1C31D4AE7056D39884557535")
        @Override
        public void enter() {
            phone.mCM.registerForRilConnected(getHandler(), EVENT_RIL_CONNECTED, null);
            // ---------- Original Method ----------
            //phone.mCM.registerForRilConnected(getHandler(), EVENT_RIL_CONNECTED, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.495 -0400", hash_original_method = "B29A8A064FC1508BFE2503E3804D9F04", hash_generated_method = "89332A3E017EEAA1B196A8EF770738C3")
        @Override
        public void exit() {
            phone.mCM.unregisterForRilConnected(getHandler());
            // ---------- Original Method ----------
            //phone.mCM.unregisterForRilConnected(getHandler());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.536 -0400", hash_original_method = "38E04FBDF2EDCBA5E9341920E990239B", hash_generated_method = "7897F392FFE4562B5DC72A780C88673E")
        @Override
        public boolean processMessage(Message msg) {
            AsyncResult ar;
            //Begin case AsyncChannel.CMD_CHANNEL_FULL_CONNECTION 
            {
                {
                    log("Disconnecting to previous connection mAc=" + mAc);
                    mAc.replyToMessage(msg, AsyncChannel.CMD_CHANNEL_FULLY_CONNECTED,
                                AsyncChannel.STATUS_FULL_CONNECTION_REFUSED_ALREADY_CONNECTED);
                } //End block
                {
                    mAc = new AsyncChannel();
                    mAc.connected(null, getHandler(), msg.replyTo);
                    log("DcDefaultState: FULL_CONNECTION reply connected");
                    mAc.replyToMessage(msg, AsyncChannel.CMD_CHANNEL_FULLY_CONNECTED,
                                AsyncChannel.STATUS_SUCCESSFUL, mId, "hi");
                } //End block
            } //End block
            //End case AsyncChannel.CMD_CHANNEL_FULL_CONNECTION 
            //Begin case AsyncChannel.CMD_CHANNEL_DISCONNECT 
            {
                log("CMD_CHANNEL_DISCONNECT");
                mAc.disconnect();
            } //End block
            //End case AsyncChannel.CMD_CHANNEL_DISCONNECT 
            //Begin case AsyncChannel.CMD_CHANNEL_DISCONNECTED 
            {
                log("CMD_CHANNEL_DISCONNECTED");
                mAc = null;
            } //End block
            //End case AsyncChannel.CMD_CHANNEL_DISCONNECTED 
            //Begin case DataConnectionAc.REQ_IS_INACTIVE 
            {
                boolean val;
                val = getCurrentState() == mInactiveState;
                log("REQ_IS_INACTIVE  isInactive=" + val);
                mAc.replyToMessage(msg, DataConnectionAc.RSP_IS_INACTIVE, val ? 1 : 0);
            } //End block
            //End case DataConnectionAc.REQ_IS_INACTIVE 
            //Begin case DataConnectionAc.REQ_GET_CID 
            {
                log("REQ_GET_CID  cid=" + cid);
                mAc.replyToMessage(msg, DataConnectionAc.RSP_GET_CID, cid);
            } //End block
            //End case DataConnectionAc.REQ_GET_CID 
            //Begin case DataConnectionAc.REQ_GET_APNSETTING 
            {
                log("REQ_GET_APNSETTING  apnSetting=" + mApn);
                mAc.replyToMessage(msg, DataConnectionAc.RSP_GET_APNSETTING, mApn);
            } //End block
            //End case DataConnectionAc.REQ_GET_APNSETTING 
            //Begin case DataConnectionAc.REQ_GET_LINK_PROPERTIES 
            {
                LinkProperties lp;
                lp = new LinkProperties(mLinkProperties);
                log("REQ_GET_LINK_PROPERTIES linkProperties" + lp);
                mAc.replyToMessage(msg, DataConnectionAc.RSP_GET_LINK_PROPERTIES, lp);
            } //End block
            //End case DataConnectionAc.REQ_GET_LINK_PROPERTIES 
            //Begin case DataConnectionAc.REQ_SET_LINK_PROPERTIES_HTTP_PROXY 
            {
                ProxyProperties proxy;
                proxy = (ProxyProperties) msg.obj;
                log("REQ_SET_LINK_PROPERTIES_HTTP_PROXY proxy=" + proxy);
                mLinkProperties.setHttpProxy(proxy);
                mAc.replyToMessage(msg, DataConnectionAc.RSP_SET_LINK_PROPERTIES_HTTP_PROXY);
            } //End block
            //End case DataConnectionAc.REQ_SET_LINK_PROPERTIES_HTTP_PROXY 
            //Begin case DataConnectionAc.REQ_UPDATE_LINK_PROPERTIES_DATA_CALL_STATE 
            {
                DataCallState newState;
                newState = (DataCallState) msg.obj;
                UpdateLinkPropertyResult result;
                result = updateLinkProperty(newState);
                {
                    log("REQ_UPDATE_LINK_PROPERTIES_DATA_CALL_STATE result="
                            + result + " newState=" + newState);
                } //End block
                mAc.replyToMessage(msg,
                                   DataConnectionAc.RSP_UPDATE_LINK_PROPERTIES_DATA_CALL_STATE,
                                   result);
            } //End block
            //End case DataConnectionAc.REQ_UPDATE_LINK_PROPERTIES_DATA_CALL_STATE 
            //Begin case DataConnectionAc.REQ_GET_LINK_CAPABILITIES 
            {
                LinkCapabilities lc;
                lc = new LinkCapabilities(mCapabilities);
                log("REQ_GET_LINK_CAPABILITIES linkCapabilities" + lc);
                mAc.replyToMessage(msg, DataConnectionAc.RSP_GET_LINK_CAPABILITIES, lc);
            } //End block
            //End case DataConnectionAc.REQ_GET_LINK_CAPABILITIES 
            //Begin case DataConnectionAc.REQ_RESET 
            log("DcDefaultState: msg.what=REQ_RESET");
            //End case DataConnectionAc.REQ_RESET 
            //Begin case DataConnectionAc.REQ_RESET 
            mAc.replyToMessage(msg, DataConnectionAc.RSP_RESET);
            //End case DataConnectionAc.REQ_RESET 
            //Begin case DataConnectionAc.REQ_RESET 
            transitionTo(mInactiveState);
            //End case DataConnectionAc.REQ_RESET 
            //Begin case DataConnectionAc.REQ_GET_REFCOUNT 
            {
                log("REQ_GET_REFCOUNT  refCount=" + mRefCount);
                mAc.replyToMessage(msg, DataConnectionAc.RSP_GET_REFCOUNT, mRefCount);
            } //End block
            //End case DataConnectionAc.REQ_GET_REFCOUNT 
            //Begin case DataConnectionAc.REQ_ADD_APNCONTEXT 
            {
                ApnContext apnContext;
                apnContext = (ApnContext) msg.obj;
                log("REQ_ADD_APNCONTEXT apn=" + apnContext.getApnType());
                {
                    boolean var4A35D05DBEBBB0D641DCA4C1673022CB_1552603047 = (!mApnList.contains(apnContext));
                    {
                        mApnList.add(apnContext);
                    } //End block
                } //End collapsed parenthetic
                mAc.replyToMessage(msg, DataConnectionAc.RSP_ADD_APNCONTEXT);
            } //End block
            //End case DataConnectionAc.REQ_ADD_APNCONTEXT 
            //Begin case DataConnectionAc.REQ_REMOVE_APNCONTEXT 
            {
                ApnContext apnContext;
                apnContext = (ApnContext) msg.obj;
                log("REQ_REMOVE_APNCONTEXT apn=" + apnContext.getApnType());
                mApnList.remove(apnContext);
                mAc.replyToMessage(msg, DataConnectionAc.RSP_REMOVE_APNCONTEXT);
            } //End block
            //End case DataConnectionAc.REQ_REMOVE_APNCONTEXT 
            //Begin case DataConnectionAc.REQ_GET_APNCONTEXT_LIST 
            {
                log("REQ_GET_APNCONTEXT_LIST num in list=" + mApnList.size());
                mAc.replyToMessage(msg, DataConnectionAc.RSP_GET_APNCONTEXT_LIST,
                                       new ArrayList<ApnContext>(mApnList));
            } //End block
            //End case DataConnectionAc.REQ_GET_APNCONTEXT_LIST 
            //Begin case DataConnectionAc.REQ_SET_RECONNECT_INTENT 
            {
                PendingIntent intent;
                intent = (PendingIntent) msg.obj;
                log("REQ_SET_RECONNECT_INTENT");
                mReconnectIntent = intent;
                mAc.replyToMessage(msg, DataConnectionAc.RSP_SET_RECONNECT_INTENT);
            } //End block
            //End case DataConnectionAc.REQ_SET_RECONNECT_INTENT 
            //Begin case DataConnectionAc.REQ_GET_RECONNECT_INTENT 
            {
                log("REQ_GET_RECONNECT_INTENT");
                mAc.replyToMessage(msg, DataConnectionAc.RSP_GET_RECONNECT_INTENT,
                                       mReconnectIntent);
            } //End block
            //End case DataConnectionAc.REQ_GET_RECONNECT_INTENT 
            //Begin case EVENT_CONNECT 
            log("DcDefaultState: msg.what=EVENT_CONNECT, fail not expected");
            //End case EVENT_CONNECT 
            //Begin case EVENT_CONNECT 
            ConnectionParams cp;
            cp = (ConnectionParams) msg.obj;
            //End case EVENT_CONNECT 
            //Begin case EVENT_CONNECT 
            notifyConnectCompleted(cp, FailCause.UNKNOWN);
            //End case EVENT_CONNECT 
            //Begin case EVENT_DISCONNECT 
            {
                log("DcDefaultState deferring msg.what=EVENT_DISCONNECT" + mRefCount);
            } //End block
            //End case EVENT_DISCONNECT 
            //Begin case EVENT_DISCONNECT 
            deferMessage(msg);
            //End case EVENT_DISCONNECT 
            //Begin case EVENT_RIL_CONNECTED 
            ar = (AsyncResult)msg.obj;
            //End case EVENT_RIL_CONNECTED 
            //Begin case EVENT_RIL_CONNECTED 
            {
                mRilVersion = (Integer)ar.result;
                {
                    log("DcDefaultState: msg.what=EVENT_RIL_CONNECTED mRilVersion=" +
                                mRilVersion);
                } //End block
            } //End block
            {
                log("Unexpected exception on EVENT_RIL_CONNECTED");
                mRilVersion = -1;
            } //End block
            //End case EVENT_RIL_CONNECTED 
            //Begin case default 
            {
                log("DcDefaultState: shouldn't happen but ignore msg.what=0x" +
                                Integer.toHexString(msg.what));
            } //End block
            //End case default 
            addTaint(msg.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_246396618 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_246396618;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class DcInactiveState extends State {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.537 -0400", hash_original_field = "96C66254DA4CBF89EC5B3143F04303D3", hash_generated_field = "88BEDA692751646D94B15E7361FCC4BA")

        private ConnectionParams mConnectionParams = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.537 -0400", hash_original_field = "F09DBEDB3757B443A2B39CA5BBE5E328", hash_generated_field = "989525539D6A577B96BED5903F7F8BDA")

        private FailCause mFailCause = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.537 -0400", hash_original_field = "23849485C3DAF4AE616338AF3DCD550A", hash_generated_field = "66B44836F757DC466942B49412EB20B6")

        private DisconnectParams mDisconnectParams = null;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.537 -0400", hash_original_method = "BBB65F37D8F6078358DD0061CFCF8B87", hash_generated_method = "BBB65F37D8F6078358DD0061CFCF8B87")
        public DcInactiveState ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.537 -0400", hash_original_method = "CBB71B6A4AE30457112F09AD25305330", hash_generated_method = "8127184C2F6ECD6017E0864641707188")
        public void setEnterNotificationParams(ConnectionParams cp, FailCause cause,
                                               int retryOverride) {
            log("DcInactiveState: setEnterNoticationParams cp,cause");
            mConnectionParams = cp;
            mFailCause = cause;
            mRetryOverride = retryOverride;
            addTaint(retryOverride);
            // ---------- Original Method ----------
            //if (VDBG) log("DcInactiveState: setEnterNoticationParams cp,cause");
            //mConnectionParams = cp;
            //mFailCause = cause;
            //mRetryOverride = retryOverride;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.537 -0400", hash_original_method = "58F7FEE7FE1847BE132197954CFB7983", hash_generated_method = "A91F4031B96A9BF5FE8E44330D1E61EB")
        public void setEnterNotificationParams(DisconnectParams dp) {
            log("DcInactiveState: setEnterNoticationParams dp");
            mDisconnectParams = dp;
            // ---------- Original Method ----------
            //if (VDBG) log("DcInactiveState: setEnterNoticationParams dp");
            //mDisconnectParams = dp;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.538 -0400", hash_original_method = "7E7CE9C76124761714CEFBB8783C6ACB", hash_generated_method = "54AE95C8910C688D373E8004A297A12A")
        @Override
        public void enter() {
            mTag += 1;
            {
                log("DcInactiveState: enter notifyConnectCompleted");
                notifyConnectCompleted(mConnectionParams, mFailCause);
            } //End block
            {
                log("DcInactiveState: enter notifyDisconnectCompleted");
                notifyDisconnectCompleted(mDisconnectParams);
            } //End block
            clearSettings();
            // ---------- Original Method ----------
            //mTag += 1;
            //if ((mConnectionParams != null) && (mFailCause != null)) {
                //if (VDBG) log("DcInactiveState: enter notifyConnectCompleted");
                //notifyConnectCompleted(mConnectionParams, mFailCause);
            //}
            //if (mDisconnectParams != null) {
                //if (VDBG) log("DcInactiveState: enter notifyDisconnectCompleted");
                //notifyDisconnectCompleted(mDisconnectParams);
            //}
            //clearSettings();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.538 -0400", hash_original_method = "0122D4B6A897CA907F15060B70B58C0B", hash_generated_method = "2FF782B07AED250A63958B87AD09AB7B")
        @Override
        public void exit() {
            mConnectionParams = null;
            mFailCause = null;
            mDisconnectParams = null;
            // ---------- Original Method ----------
            //mConnectionParams = null;
            //mFailCause = null;
            //mDisconnectParams = null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.560 -0400", hash_original_method = "F7BD47A9DC4B0FE6830EC189D0B30877", hash_generated_method = "5615404437C6D99D631E85B5D9BFFCBF")
        @Override
        public boolean processMessage(Message msg) {
            boolean retVal;
            //Begin case DataConnectionAc.REQ_RESET 
            {
                log("DcInactiveState: msg.what=RSP_RESET, ignore we're already reset");
            } //End block
            //End case DataConnectionAc.REQ_RESET 
            //Begin case DataConnectionAc.REQ_RESET 
            mAc.replyToMessage(msg, DataConnectionAc.RSP_RESET);
            //End case DataConnectionAc.REQ_RESET 
            //Begin case DataConnectionAc.REQ_RESET 
            retVal = HANDLED;
            //End case DataConnectionAc.REQ_RESET 
            //Begin case EVENT_CONNECT 
            ConnectionParams cp;
            cp = (ConnectionParams) msg.obj;
            //End case EVENT_CONNECT 
            //Begin case EVENT_CONNECT 
            cp.tag = mTag;
            //End case EVENT_CONNECT 
            //Begin case EVENT_CONNECT 
            {
                log("DcInactiveState msg.what=EVENT_CONNECT." + "RefCount = "
                                + mRefCount);
            } //End block
            //End case EVENT_CONNECT 
            //Begin case EVENT_CONNECT 
            mRefCount = 1;
            //End case EVENT_CONNECT 
            //Begin case EVENT_CONNECT 
            onConnect(cp);
            //End case EVENT_CONNECT 
            //Begin case EVENT_CONNECT 
            transitionTo(mActivatingState);
            //End case EVENT_CONNECT 
            //Begin case EVENT_CONNECT 
            retVal = HANDLED;
            //End case EVENT_CONNECT 
            //Begin case EVENT_DISCONNECT 
            log("DcInactiveState: msg.what=EVENT_DISCONNECT");
            //End case EVENT_DISCONNECT 
            //Begin case EVENT_DISCONNECT 
            notifyDisconnectCompleted((DisconnectParams)msg.obj);
            //End case EVENT_DISCONNECT 
            //Begin case EVENT_DISCONNECT 
            retVal = HANDLED;
            //End case EVENT_DISCONNECT 
            //Begin case default 
            {
                log("DcInactiveState nothandled msg.what=0x" +
                                Integer.toHexString(msg.what));
            } //End block
            //End case default 
            //Begin case default 
            retVal = NOT_HANDLED;
            //End case default 
            addTaint(msg.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1664561630 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1664561630;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class DcActivatingState extends State {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.560 -0400", hash_original_method = "3C5900F00C80F9987C90695FBB53350C", hash_generated_method = "3C5900F00C80F9987C90695FBB53350C")
        public DcActivatingState ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.562 -0400", hash_original_method = "FDE326A498C74E1E809F141FF2FEACCA", hash_generated_method = "476EA067BED9FE123E2F43245AF720B4")
        @Override
        public boolean processMessage(Message msg) {
            boolean retVal;
            AsyncResult ar;
            ConnectionParams cp;
            //Begin case EVENT_CONNECT 
            log("DcActivatingState deferring msg.what=EVENT_CONNECT refCount = "
                            + mRefCount);
            //End case EVENT_CONNECT 
            //Begin case EVENT_CONNECT 
            deferMessage(msg);
            //End case EVENT_CONNECT 
            //Begin case EVENT_CONNECT 
            retVal = HANDLED;
            //End case EVENT_CONNECT 
            //Begin case EVENT_SETUP_DATA_CONNECTION_DONE 
            log("DcActivatingState msg.what=EVENT_SETUP_DATA_CONNECTION_DONE");
            //End case EVENT_SETUP_DATA_CONNECTION_DONE 
            //Begin case EVENT_SETUP_DATA_CONNECTION_DONE 
            ar = (AsyncResult) msg.obj;
            //End case EVENT_SETUP_DATA_CONNECTION_DONE 
            //Begin case EVENT_SETUP_DATA_CONNECTION_DONE 
            cp = (ConnectionParams) ar.userObj;
            //End case EVENT_SETUP_DATA_CONNECTION_DONE 
            //Begin case EVENT_SETUP_DATA_CONNECTION_DONE 
            DataCallState.SetupResult result;
            result = onSetupConnectionCompleted(ar);
            //End case EVENT_SETUP_DATA_CONNECTION_DONE 
            //Begin case EVENT_SETUP_DATA_CONNECTION_DONE 
            log("DcActivatingState onSetupConnectionCompleted result=" + result);
            //End case EVENT_SETUP_DATA_CONNECTION_DONE 
            //Begin case EVENT_SETUP_DATA_CONNECTION_DONE 
            //Begin case SUCCESS 
            mActiveState.setEnterNotificationParams(cp, FailCause.NONE);
            //End case SUCCESS 
            //Begin case SUCCESS 
            transitionTo(mActiveState);
            //End case SUCCESS 
            //Begin case ERR_BadCommand 
            mInactiveState.setEnterNotificationParams(cp, result.mFailCause, -1);
            //End case ERR_BadCommand 
            //Begin case ERR_BadCommand 
            transitionTo(mInactiveState);
            //End case ERR_BadCommand 
            //Begin case ERR_UnacceptableParameter 
            tearDownData(cp);
            //End case ERR_UnacceptableParameter 
            //Begin case ERR_UnacceptableParameter 
            transitionTo(mDisconnectingErrorCreatingConnection);
            //End case ERR_UnacceptableParameter 
            //Begin case ERR_GetLastErrorFromRil 
            phone.mCM.getLastDataCallFailCause(
                                    obtainMessage(EVENT_GET_LAST_FAIL_DONE, cp));
            //End case ERR_GetLastErrorFromRil 
            //Begin case ERR_RilError 
            mInactiveState.setEnterNotificationParams(cp, result.mFailCause,
                                                                      getSuggestedRetryTime(ar));
            //End case ERR_RilError 
            //Begin case ERR_RilError 
            transitionTo(mInactiveState);
            //End case ERR_RilError 
            //Begin case default 
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Unknown SetupResult, should not happen");
            //End case default 
            //End case EVENT_SETUP_DATA_CONNECTION_DONE 
            //Begin case EVENT_SETUP_DATA_CONNECTION_DONE 
            retVal = HANDLED;
            //End case EVENT_SETUP_DATA_CONNECTION_DONE 
            //Begin case EVENT_GET_LAST_FAIL_DONE 
            ar = (AsyncResult) msg.obj;
            //End case EVENT_GET_LAST_FAIL_DONE 
            //Begin case EVENT_GET_LAST_FAIL_DONE 
            cp = (ConnectionParams) ar.userObj;
            //End case EVENT_GET_LAST_FAIL_DONE 
            //Begin case EVENT_GET_LAST_FAIL_DONE 
            FailCause cause;
            cause = FailCause.UNKNOWN;
            //End case EVENT_GET_LAST_FAIL_DONE 
            //Begin case EVENT_GET_LAST_FAIL_DONE 
            {
                log("DcActivatingState msg.what=EVENT_GET_LAST_FAIL_DONE");
                {
                    int rilFailCause;
                    rilFailCause = ((int[]) (ar.result))[0];
                    cause = FailCause.fromInt(rilFailCause);
                } //End block
                mInactiveState.setEnterNotificationParams(cp, cause, -1);
                transitionTo(mInactiveState);
            } //End block
            {
                {
                    log("DcActivatingState EVENT_GET_LAST_FAIL_DONE is stale cp.tag="
                                + cp.tag + ", mTag=" + mTag);
                } //End block
            } //End block
            //End case EVENT_GET_LAST_FAIL_DONE 
            //Begin case EVENT_GET_LAST_FAIL_DONE 
            retVal = HANDLED;
            //End case EVENT_GET_LAST_FAIL_DONE 
            //Begin case default 
            {
                log("DcActivatingState not handled msg.what=0x" +
                                Integer.toHexString(msg.what));
            } //End block
            //End case default 
            //Begin case default 
            retVal = NOT_HANDLED;
            //End case default 
            addTaint(msg.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_919482403 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_919482403;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class DcActiveState extends State {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.570 -0400", hash_original_field = "96C66254DA4CBF89EC5B3143F04303D3", hash_generated_field = "88BEDA692751646D94B15E7361FCC4BA")

        private ConnectionParams mConnectionParams = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.570 -0400", hash_original_field = "F09DBEDB3757B443A2B39CA5BBE5E328", hash_generated_field = "989525539D6A577B96BED5903F7F8BDA")

        private FailCause mFailCause = null;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.570 -0400", hash_original_method = "5052F6BB3696B9FBB5C9B1F89FD73944", hash_generated_method = "5052F6BB3696B9FBB5C9B1F89FD73944")
        public DcActiveState ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.571 -0400", hash_original_method = "65AC06854CC9D1F4537757F901F06476", hash_generated_method = "92626410A63E4D17A649AC7AD8F59027")
        public void setEnterNotificationParams(ConnectionParams cp, FailCause cause) {
            log("DcInactiveState: setEnterNoticationParams cp,cause");
            mConnectionParams = cp;
            mFailCause = cause;
            // ---------- Original Method ----------
            //if (VDBG) log("DcInactiveState: setEnterNoticationParams cp,cause");
            //mConnectionParams = cp;
            //mFailCause = cause;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.571 -0400", hash_original_method = "F04274E6B6E666DB4B8B2ADDB4ED15CF", hash_generated_method = "1C6450E054BB12CF4CEED6B4B3472854")
        @Override
        public void enter() {
            {
                log("DcActiveState: enter notifyConnectCompleted");
                notifyConnectCompleted(mConnectionParams, mFailCause);
            } //End block
            // ---------- Original Method ----------
            //if ((mConnectionParams != null) && (mFailCause != null)) {
                //if (VDBG) log("DcActiveState: enter notifyConnectCompleted");
                //notifyConnectCompleted(mConnectionParams, mFailCause);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.582 -0400", hash_original_method = "6361033575190DC86852AD59967B3D8E", hash_generated_method = "41F12992C45BA1B13C3E1498872DF26C")
        @Override
        public void exit() {
            mConnectionParams = null;
            mFailCause = null;
            // ---------- Original Method ----------
            //mConnectionParams = null;
            //mFailCause = null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.583 -0400", hash_original_method = "E272CADF23159A9F3D514AE20DA7ACA2", hash_generated_method = "CFD9E38A403AFFB2282D87B1B0759026")
        @Override
        public boolean processMessage(Message msg) {
            boolean retVal;
            //Begin case EVENT_CONNECT 
            log("DcActiveState msg.what=EVENT_CONNECT RefCount=" + mRefCount);
            //End case EVENT_CONNECT 
            //Begin case EVENT_CONNECT 
            {
                notifyConnectCompleted((ConnectionParams) msg.obj, FailCause.NONE);
            } //End block
            //End case EVENT_CONNECT 
            //Begin case EVENT_CONNECT 
            retVal = HANDLED;
            //End case EVENT_CONNECT 
            //Begin case EVENT_DISCONNECT 
            log("DcActiveState msg.what=EVENT_DISCONNECT RefCount=" + mRefCount);
            //End case EVENT_DISCONNECT 
            //Begin case EVENT_DISCONNECT 
            {
                DisconnectParams dp;
                dp = (DisconnectParams) msg.obj;
                dp.tag = mTag;
                tearDownData(dp);
                transitionTo(mDisconnectingState);
            } //End block
            {
                {
                    notifyDisconnectCompleted((DisconnectParams) msg.obj);
                } //End block
            } //End block
            //End case EVENT_DISCONNECT 
            //Begin case EVENT_DISCONNECT 
            retVal = HANDLED;
            //End case EVENT_DISCONNECT 
            //Begin case default 
            {
                log("DcActiveState not handled msg.what=0x" +
                                Integer.toHexString(msg.what));
            } //End block
            //End case default 
            //Begin case default 
            retVal = NOT_HANDLED;
            //End case default 
            addTaint(msg.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_912996971 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_912996971;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class DcDisconnectingState extends State {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.583 -0400", hash_original_method = "29C0CB68E08F466587ED5BC2F5C6C796", hash_generated_method = "29C0CB68E08F466587ED5BC2F5C6C796")
        public DcDisconnectingState ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.585 -0400", hash_original_method = "DD3249EFBD400B69680BE43C46063370", hash_generated_method = "C38E384FE0C08B2FA823968DAEE89C76")
        @Override
        public boolean processMessage(Message msg) {
            boolean retVal;
            //Begin case EVENT_CONNECT 
            log("DcDisconnectingState msg.what=EVENT_CONNECT. Defer. RefCount = "
                            + mRefCount);
            //End case EVENT_CONNECT 
            //Begin case EVENT_CONNECT 
            deferMessage(msg);
            //End case EVENT_CONNECT 
            //Begin case EVENT_CONNECT 
            retVal = HANDLED;
            //End case EVENT_CONNECT 
            //Begin case EVENT_DEACTIVATE_DONE 
            log("DcDisconnectingState msg.what=EVENT_DEACTIVATE_DONE");
            //End case EVENT_DEACTIVATE_DONE 
            //Begin case EVENT_DEACTIVATE_DONE 
            AsyncResult ar;
            ar = (AsyncResult) msg.obj;
            //End case EVENT_DEACTIVATE_DONE 
            //Begin case EVENT_DEACTIVATE_DONE 
            DisconnectParams dp;
            dp = (DisconnectParams) ar.userObj;
            //End case EVENT_DEACTIVATE_DONE 
            //Begin case EVENT_DEACTIVATE_DONE 
            {
                mInactiveState.setEnterNotificationParams((DisconnectParams) ar.userObj);
                transitionTo(mInactiveState);
            } //End block
            {
                log("DcDisconnectState EVENT_DEACTIVATE_DONE stale dp.tag="
                                + dp.tag + " mTag=" + mTag);
            } //End block
            //End case EVENT_DEACTIVATE_DONE 
            //Begin case EVENT_DEACTIVATE_DONE 
            retVal = HANDLED;
            //End case EVENT_DEACTIVATE_DONE 
            //Begin case default 
            {
                log("DcDisconnectingState not handled msg.what=0x" +
                                Integer.toHexString(msg.what));
            } //End block
            //End case default 
            //Begin case default 
            retVal = NOT_HANDLED;
            //End case default 
            addTaint(msg.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1169174517 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1169174517;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class DcDisconnectionErrorCreatingConnection extends State {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.596 -0400", hash_original_method = "9EEE01BC14CD1B0E43AEFA5AA17972F9", hash_generated_method = "9EEE01BC14CD1B0E43AEFA5AA17972F9")
        public DcDisconnectionErrorCreatingConnection ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.597 -0400", hash_original_method = "E9D4515D62B87825C79C67876E4313E2", hash_generated_method = "2563EA7C5C4EF8A3AF8F556EB807CD9E")
        @Override
        public boolean processMessage(Message msg) {
            boolean retVal;
            //Begin case EVENT_DEACTIVATE_DONE 
            AsyncResult ar;
            ar = (AsyncResult) msg.obj;
            //End case EVENT_DEACTIVATE_DONE 
            //Begin case EVENT_DEACTIVATE_DONE 
            ConnectionParams cp;
            cp = (ConnectionParams) ar.userObj;
            //End case EVENT_DEACTIVATE_DONE 
            //Begin case EVENT_DEACTIVATE_DONE 
            {
                {
                    log("DcDisconnectionErrorCreatingConnection" +
                                " msg.what=EVENT_DEACTIVATE_DONE");
                } //End block
                mInactiveState.setEnterNotificationParams(cp,
                                FailCause.UNACCEPTABLE_NETWORK_PARAMETER, -1);
                transitionTo(mInactiveState);
            } //End block
            {
                {
                    log("DcDisconnectionErrorCreatingConnection EVENT_DEACTIVATE_DONE" +
                                    " stale dp.tag=" + cp.tag + ", mTag=" + mTag);
                } //End block
            } //End block
            //End case EVENT_DEACTIVATE_DONE 
            //Begin case EVENT_DEACTIVATE_DONE 
            retVal = HANDLED;
            //End case EVENT_DEACTIVATE_DONE 
            //Begin case default 
            {
                log("DcDisconnectionErrorCreatingConnection not handled msg.what=0x"
                                + Integer.toHexString(msg.what));
            } //End block
            //End case default 
            //Begin case default 
            retVal = NOT_HANDLED;
            //End case default 
            addTaint(msg.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_741792764 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_741792764;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.598 -0400", hash_original_field = "A4622F7F72162611C8E075EE443BC26E", hash_generated_field = "D751668EF011EB030075908D0A6ACFD9")

    protected static boolean DBG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.598 -0400", hash_original_field = "F731EB70B21910E383F52051C1671657", hash_generated_field = "B825BAA66BBDA94C70A379A47D83FA46")

    protected static boolean VDBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.598 -0400", hash_original_field = "FDAC39383F87F7973A70D4DE67F761A9", hash_generated_field = "4B6AAD30DE4CA5A855B0088556B9ED5D")

    protected static Object mCountLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.598 -0400", hash_original_field = "4A5FC91463CC1EF00D3AA26340B946C6", hash_generated_field = "4928C87B5EACFDF4C672365969709FF8")

    protected static int mCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.598 -0400", hash_original_field = "1B5D498F3F2A701D5324361DD17F38F3", hash_generated_field = "2A114040189E24419DDB9F5571E44B9D")

    protected static int BASE = Protocol.BASE_DATA_CONNECTION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.598 -0400", hash_original_field = "042BAA48F1456211B3E8E2EDD35723DE", hash_generated_field = "1E74CB6D423E64963863A39E93E017D0")

    protected static int EVENT_CONNECT = BASE + 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.598 -0400", hash_original_field = "909D82AD06A783A74E418EEE2706B2AC", hash_generated_field = "F9B50AD5953C065A61C8C5E36AE88389")

    protected static int EVENT_SETUP_DATA_CONNECTION_DONE = BASE + 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.598 -0400", hash_original_field = "648CBEF38769E1887B33138C19E43A10", hash_generated_field = "5103ADF44AD2F27F440DEA51139F04D1")

    protected static int EVENT_GET_LAST_FAIL_DONE = BASE + 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.612 -0400", hash_original_field = "F7206AF739EA59ACF888117DDA738E0E", hash_generated_field = "1A37254BEE175BCC3B848E473E7FFFDF")

    protected static int EVENT_DEACTIVATE_DONE = BASE + 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.612 -0400", hash_original_field = "139CD29609D29AD7DF77466B48DE22A0", hash_generated_field = "D74C7FDE0AC9917B0DDEE77A6CF68A05")

    protected static int EVENT_DISCONNECT = BASE + 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.612 -0400", hash_original_field = "870957D1B8658C53A0E273F9B1853FDF", hash_generated_field = "1510F63F78DB4E491831AA2F00AF293D")

    protected static int EVENT_RIL_CONNECTED = BASE + 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.612 -0400", hash_original_field = "519C12A2F7BADEC8D8A4F60F4C24D5FF", hash_generated_field = "FD9EE92E65C43E1F551C6E867D20CFF4")

    protected static int EVENT_LOG_BAD_DNS_ADDRESS = 50100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:15.612 -0400", hash_original_field = "9703C98FBA4E5997D49E93A25FA145F2", hash_generated_field = "96E46ECDEB4B1CB449C9FCD74E2EED5C")

    protected static String NULL_IP = "0.0.0.0";
}

