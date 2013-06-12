package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    protected static final boolean DBG = true;
    protected static final boolean VDBG = false;
    protected static Object mCountLock = new Object();
    protected static int mCount;
    protected AsyncChannel mAc;
    private List<ApnContext> mApnList = null;
    PendingIntent mReconnectIntent = null;
    private DataConnectionTracker mDataConnectionTracker = null;
    protected static final int BASE = Protocol.BASE_DATA_CONNECTION;
    protected static final int EVENT_CONNECT = BASE + 0;
    protected static final int EVENT_SETUP_DATA_CONNECTION_DONE = BASE + 1;
    protected static final int EVENT_GET_LAST_FAIL_DONE = BASE + 2;
    protected static final int EVENT_DEACTIVATE_DONE = BASE + 3;
    protected static final int EVENT_DISCONNECT = BASE + 4;
    protected static final int EVENT_RIL_CONNECTED = BASE + 5;
    protected static final int EVENT_DISCONNECT_ALL = BASE + 6;
    protected static final int EVENT_LOG_BAD_DNS_ADDRESS = 50100;
    protected ApnSetting mApn;
    protected int mTag;
    protected PhoneBase phone;
    protected int mRilVersion = -1;
    protected int cid;
    protected LinkProperties mLinkProperties = new LinkProperties();
    protected LinkCapabilities mCapabilities = new LinkCapabilities();
    protected long createTime;
    protected long lastFailTime;
    protected FailCause lastFailCause;
    protected int mRetryOverride = -1;
    protected static final String NULL_IP = "0.0.0.0";
    private int mRefCount;
    Object userData;
    private int mId;
    private RetryManager mRetryMgr;
    private DcDefaultState mDefaultState = new DcDefaultState();
    private DcInactiveState mInactiveState = new DcInactiveState();
    private DcActivatingState mActivatingState = new DcActivatingState();
    private DcActiveState mActiveState = new DcActiveState();
    private DcDisconnectingState mDisconnectingState = new DcDisconnectingState();
    private DcDisconnectionErrorCreatingConnection mDisconnectingErrorCreatingConnection =
                new DcDisconnectionErrorCreatingConnection();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.780 -0400", hash_original_method = "D7245109588C71D28E136068E4D7CDC7", hash_generated_method = "27CE2185661A552EAB280ED7A31825F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected DataConnection(PhoneBase phone, String name, int id, RetryManager rm,
            DataConnectionTracker dct) {
        super(name);
        dsTaint.addTaint(id);
        dsTaint.addTaint(phone.dsTaint);
        dsTaint.addTaint(rm.dsTaint);
        dsTaint.addTaint(dct.dsTaint);
        dsTaint.addTaint(name);
        log("DataConnection constructor E");
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
        // ---------- Original Method ----------
        //if (DBG) log("DataConnection constructor E");
        //this.phone = phone;
        //this.mDataConnectionTracker = dct;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.780 -0400", hash_original_method = "59ED68D7EF373C505428063E232AFE5C", hash_generated_method = "E67D3F7893225778B01BBE6BB0DB29C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void tearDownData(Object o) {
        dsTaint.addTaint(o.dsTaint);
        int discReason;
        discReason = RILConstants.DEACTIVATE_REASON_NONE;
        {
            DisconnectParams dp;
            dp = (DisconnectParams)o;
            Message m;
            m = dp.onCompletedMsg;
            {
                boolean varC0DA3759AD518C5BDD466277C93185D6_722315036 = (TextUtils.equals(dp.reason, Phone.REASON_RADIO_TURNED_OFF));
                {
                    discReason = RILConstants.DEACTIVATE_REASON_RADIO_OFF;
                } //End block
                {
                    boolean var1B725C4E69E932624B2BF80526814400_412237730 = (TextUtils.equals(dp.reason, Phone.REASON_PDP_RESET));
                    {
                        discReason = RILConstants.DEACTIVATE_REASON_PDP_RESET;
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        {
            boolean varEB239098BBFA2AD31684A01774D8510E_2095982995 = (phone.mCM.getRadioState().isOn());
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.780 -0400", hash_original_method = "4864ED15F4860BAE9DD2587736D4A08F", hash_generated_method = "5E7DF38FAA78BE6693D7501BFEE6D04A")
    @DSModeled(DSC.SAFE)
    private void notifyConnectCompleted(ConnectionParams cp, FailCause cause) {
        dsTaint.addTaint(cp.dsTaint);
        dsTaint.addTaint(cause.dsTaint);
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
            lastFailTime = timeStamp;
            AsyncResult.forMessage(connectionCompletedMsg, cause,
                                   new CallSetupException(mRetryOverride));
        } //End block
        log("notifyConnectionCompleted at " + timeStamp + " cause=" + cause);
        connectionCompletedMsg.sendToTarget();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.781 -0400", hash_original_method = "FAECBFACBAA2823A6757C3F4EB7F55CB", hash_generated_method = "17AE000AC5B057BF19D233D222A5443A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void notifyDisconnectCompleted(DisconnectParams dp, boolean sendAll) {
        dsTaint.addTaint(dp.dsTaint);
        dsTaint.addTaint(sendAll);
        log("NotifyDisconnectCompleted");
        ApnContext alreadySent;
        alreadySent = null;
        String reason;
        reason = null;
        {
            Message msg;
            msg = dp.onCompletedMsg;
            {
                alreadySent = (ApnContext)msg.obj;
            } //End block
            reason = dp.reason;
            {
                log(String.format("msg=%s msg.obj=%s", msg.toString(),
                    ((msg.obj instanceof String) ? (String) msg.obj : "<no-reason>")));
            } //End block
            AsyncResult.forMessage(msg);
            msg.sendToTarget();
        } //End block
        {
            {
                Iterator<ApnContext> seatecAstronomy42 = mApnList.iterator();
                seatecAstronomy42.hasNext();
                ApnContext a = seatecAstronomy42.next();
                {
                    a.setReason(reason);
                    Message msg;
                    msg = mDataConnectionTracker.obtainMessage(
                        DataConnectionTracker.EVENT_DISCONNECT_DONE, a);
                    AsyncResult.forMessage(msg);
                    msg.sendToTarget();
                } //End block
            } //End collapsed parenthetic
        } //End block
        log("NotifyDisconnectCompleted DisconnectParams=" + dp);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.781 -0400", hash_original_method = "1BB05B964694E45E9B1991E5D1915447", hash_generated_method = "E173C4D1190922EA2CBA3E6F04B4732C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int getRadioTechnology(int defaultRadioTechnology) {
        dsTaint.addTaint(defaultRadioTechnology);
        int radioTechnology;
        {
            radioTechnology = defaultRadioTechnology;
        } //End block
        {
            radioTechnology = phone.getServiceState().getRadioTechnology() + 2;
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int radioTechnology;
        //if (mRilVersion < 6) {
            //radioTechnology = defaultRadioTechnology;
        //} else {
            //radioTechnology = phone.getServiceState().getRadioTechnology() + 2;
        //}
        //return radioTechnology;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.781 -0400", hash_original_method = "AAF5779D145C421CCE90F0916803977D", hash_generated_method = "CBCF066811053F93C1A385DB79B366C3")
    @DSModeled(DSC.SAFE)
    public int getDataConnectionId() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.781 -0400", hash_original_method = "FC51BF074579EE4E5F8C7AB511B49B8A", hash_generated_method = "6702465D262E37840B18E894E524BA69")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getRetryCount() {
        int var449CA49043C973C5751EB0A39E24CB1F_943450382 = (mRetryMgr.getRetryCount());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mRetryMgr.getRetryCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.781 -0400", hash_original_method = "21D3097027A7BF6D8D1F04609D8A2AE9", hash_generated_method = "C79CC3B7BBC9828BA94CA2F3DB539B97")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getRetryTimer() {
        int var3D330706D3357A0015985CFA9194A2D9_1411216998 = (mRetryMgr.getRetryTimer());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mRetryMgr.getRetryTimer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.781 -0400", hash_original_method = "2EFBBED22C4BDBBAA07E00436CC70BDF", hash_generated_method = "125C4C2EE0F2FE2E45E59DD73ACDDF20")
    @DSModeled(DSC.SAFE)
    public void increaseRetryCount() {
        mRetryMgr.increaseRetryCount();
        // ---------- Original Method ----------
        //mRetryMgr.increaseRetryCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.781 -0400", hash_original_method = "BE0E8B7CBE5F430456218437A69801A6", hash_generated_method = "DCC2E24B4CA5F7AAAC207C20C7250A04")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isRetryNeeded() {
        boolean var2557A79863F82C24CE058A4712E3B3F7_190216316 = (mRetryMgr.isRetryNeeded());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mRetryMgr.isRetryNeeded();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.781 -0400", hash_original_method = "6E600B114543C0C51BDDB686B0EEF1BE", hash_generated_method = "5DA16E2E073D92967458C5926B871A9B")
    @DSModeled(DSC.SAFE)
    public void resetRetryCount() {
        mRetryMgr.resetRetryCount();
        // ---------- Original Method ----------
        //mRetryMgr.resetRetryCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.781 -0400", hash_original_method = "FE4AFC35148D7FCE7B6DEB885B8B31DF", hash_generated_method = "D2B71A1549FCB4D8295D582CE0BF2CC2")
    @DSModeled(DSC.SAFE)
    public void retryForeverUsingLastTimeout() {
        mRetryMgr.retryForeverUsingLastTimeout();
        // ---------- Original Method ----------
        //mRetryMgr.retryForeverUsingLastTimeout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.781 -0400", hash_original_method = "7BE7662A27A4557E7DE38D4C4F7B834F", hash_generated_method = "9091F54F33762B9D38DC4B5C140D78D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isRetryForever() {
        boolean var491B6D9ADB68663515B16F16BFDDD6EB_733454152 = (mRetryMgr.isRetryForever());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mRetryMgr.isRetryForever();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.781 -0400", hash_original_method = "7F3E6401D154FAD4235CC7C3EA752D6F", hash_generated_method = "F66E0799D82F7E34409F54F704979A55")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean configureRetry(int maxRetryCount, int retryTime, int randomizationTime) {
        dsTaint.addTaint(maxRetryCount);
        dsTaint.addTaint(retryTime);
        dsTaint.addTaint(randomizationTime);
        boolean var5C383AB26692B2465A8A92603FAE13E1_661795163 = (mRetryMgr.configure(maxRetryCount, retryTime, randomizationTime));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mRetryMgr.configure(maxRetryCount, retryTime, randomizationTime);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.781 -0400", hash_original_method = "23B74F0922BA8C1F44E04170074AC8EE", hash_generated_method = "EBEF16C3BEEEB739F1E62DFAF1CFE008")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean configureRetry(String configStr) {
        dsTaint.addTaint(configStr);
        boolean varECAEB0BD560D7A3FDF27280B64D27C2B_627270682 = (mRetryMgr.configure(configStr));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mRetryMgr.configure(configStr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.781 -0400", hash_original_method = "14EAC6C2DDCA29A3543D7FF941CEE3A4", hash_generated_method = "3938AFF7402ED1CC58E5F892931624D4")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.782 -0400", hash_original_method = "75094A2EA3723036F1D43E5DA379759D", hash_generated_method = "437D205E9EBC3F22AD871C88F4E206B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private DataCallState.SetupResult onSetupConnectionCompleted(AsyncResult ar) {
        dsTaint.addTaint(ar.dsTaint);
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
                boolean var1E63C7E427F0E7C15DB7AC2E851044B0_132064354 = (ar.exception instanceof CommandException
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
        return (DataCallState.SetupResult)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.782 -0400", hash_original_method = "F1DF17AEAB523CA725A1A0E7587A5B33", hash_generated_method = "08E574B40ABCA7CC7DA7EE6158FCC6C1")
    @DSModeled(DSC.SAFE)
    private int getSuggestedRetryTime(AsyncResult ar) {
        dsTaint.addTaint(ar.dsTaint);
        int retry;
        retry = -1;
        {
            DataCallState response;
            response = (DataCallState) ar.result;
            retry =  response.suggestedRetryTime;
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int retry = -1;
        //if (ar.exception == null) {
            //DataCallState response = (DataCallState) ar.result;
            //retry =  response.suggestedRetryTime;
        //}
        //return retry;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.782 -0400", hash_original_method = "61A23083F49649744D5BB908131730E7", hash_generated_method = "EE2C2430DDFFE196BF6520CE93D309E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private DataCallState.SetupResult setLinkProperties(DataCallState response,
            LinkProperties lp) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(lp.dsTaint);
        boolean okToUseSystemPropertyDns;
        okToUseSystemPropertyDns = false;
        String propertyPrefix;
        propertyPrefix = "net." + response.ifname + ".";
        String dnsServers[];
        dnsServers = new String[2];
        dnsServers[0] = SystemProperties.get(propertyPrefix + "dns1");
        dnsServers[1] = SystemProperties.get(propertyPrefix + "dns2");
        okToUseSystemPropertyDns = isDnsOk(dnsServers);
        DataCallState.SetupResult varEB53BC7FB06BF4FFA7075E1595BA295D_1303195709 = (response.setLinkProperties(lp, okToUseSystemPropertyDns));
        return (DataCallState.SetupResult)dsTaint.getTaint();
        // ---------- Original Method ----------
        //boolean okToUseSystemPropertyDns = false;
        //String propertyPrefix = "net." + response.ifname + ".";
        //String dnsServers[] = new String[2];
        //dnsServers[0] = SystemProperties.get(propertyPrefix + "dns1");
        //dnsServers[1] = SystemProperties.get(propertyPrefix + "dns2");
        //okToUseSystemPropertyDns = isDnsOk(dnsServers);
        //return response.setLinkProperties(lp, okToUseSystemPropertyDns);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.782 -0400", hash_original_method = "45E9586484C37E223B6289BDE8E786AB", hash_generated_method = "E2088F8D1CBAAEF1C62F6DCA472616B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private UpdateLinkPropertyResult updateLinkProperty(DataCallState newState) {
        dsTaint.addTaint(newState.dsTaint);
        UpdateLinkPropertyResult result;
        result = new UpdateLinkPropertyResult(mLinkProperties);
        DataCallState.SetupResult setupResult;
        result.newLp = new LinkProperties();
        result.setupResult = setLinkProperties(newState, result.newLp);
        {
            log("updateLinkProperty failed : " + result.setupResult);
        } //End block
        result.newLp.setHttpProxy(mLinkProperties.getHttpProxy());
        {
            boolean var35DD507CF52E6FD709D552250B552C90_1892941766 = (DBG && (! result.oldLp.equals(result.newLp)));
            {
                log("updateLinkProperty old != new");
                log("updateLinkProperty old LP=" + result.oldLp);
                log("updateLinkProperty new LP=" + result.newLp);
            } //End block
        } //End collapsed parenthetic
        mLinkProperties = result.newLp;
        return (UpdateLinkPropertyResult)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.782 -0400", hash_original_method = "DA4DADB76FBE855C8C796E356354585B", hash_generated_method = "12C9EDDF9BE570BC81AEE73E7C96EBF8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void bringUp(Message onCompletedMsg, ApnSetting apn) {
        dsTaint.addTaint(apn.dsTaint);
        dsTaint.addTaint(onCompletedMsg.dsTaint);
        sendMessage(obtainMessage(EVENT_CONNECT, new ConnectionParams(apn, onCompletedMsg)));
        // ---------- Original Method ----------
        //sendMessage(obtainMessage(EVENT_CONNECT, new ConnectionParams(apn, onCompletedMsg)));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.782 -0400", hash_original_method = "16642B60370F95B35D583CCC8A36D6BF", hash_generated_method = "39432AFC6601B2753044D314AE377002")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void tearDown(String reason, Message onCompletedMsg) {
        dsTaint.addTaint(reason);
        dsTaint.addTaint(onCompletedMsg.dsTaint);
        sendMessage(obtainMessage(EVENT_DISCONNECT, new DisconnectParams(reason, onCompletedMsg)));
        // ---------- Original Method ----------
        //sendMessage(obtainMessage(EVENT_DISCONNECT, new DisconnectParams(reason, onCompletedMsg)));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.782 -0400", hash_original_method = "30373688C862478A157FD6B64FFCED35", hash_generated_method = "F00450AA593F960279A61A7C6ACE99F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void tearDownAll(String reason, Message onCompletedMsg) {
        dsTaint.addTaint(reason);
        dsTaint.addTaint(onCompletedMsg.dsTaint);
        sendMessage(obtainMessage(EVENT_DISCONNECT_ALL,
                new DisconnectParams(reason, onCompletedMsg)));
        // ---------- Original Method ----------
        //sendMessage(obtainMessage(EVENT_DISCONNECT_ALL,
                //new DisconnectParams(reason, onCompletedMsg)));
    }

    
    protected static class ConnectionParams {
        public int tag;
        public ApnSetting apn;
        public Message onCompletedMsg;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.782 -0400", hash_original_method = "9C883FBF948634C8BFC48155A41A0F4D", hash_generated_method = "184529A1A118366A895763EEC2E80206")
        @DSModeled(DSC.SAFE)
        public ConnectionParams(ApnSetting apn, Message onCompletedMsg) {
            dsTaint.addTaint(apn.dsTaint);
            dsTaint.addTaint(onCompletedMsg.dsTaint);
            // ---------- Original Method ----------
            //this.apn = apn;
            //this.onCompletedMsg = onCompletedMsg;
        }

        
    }


    
    protected static class DisconnectParams {
        public int tag;
        public String reason;
        public Message onCompletedMsg;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.782 -0400", hash_original_method = "8634A04E02B052AB53AF8D3EFA7F5294", hash_generated_method = "772E091DDB5D5BB3A8F0755F90AA8930")
        @DSModeled(DSC.SAFE)
        public DisconnectParams(String reason, Message onCompletedMsg) {
            dsTaint.addTaint(reason);
            dsTaint.addTaint(onCompletedMsg.dsTaint);
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
        UNACCEPTABLE_NETWORK_PARAMETER(0x10002),
        CONNECTION_TO_DATACONNECTIONAC_BROKEN(0x10003);
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
        private int mRetryOverride = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.783 -0400", hash_original_method = "A504ADA2782D67F9E42B2FFAADC374C6", hash_generated_method = "33F406BE725F883EB75341C6E93A7492")
        @DSModeled(DSC.SAFE)
         CallSetupException(int retryOverride) {
            dsTaint.addTaint(retryOverride);
            // ---------- Original Method ----------
            //mRetryOverride = retryOverride;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.783 -0400", hash_original_method = "474AEB2E917376DACCA3A8D3E49DB29C", hash_generated_method = "3096368B52DFC69759B8CE6F15D07EA9")
        @DSModeled(DSC.SAFE)
        public int getRetryOverride() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mRetryOverride;
        }

        
    }


    
    public static class UpdateLinkPropertyResult {
        public DataCallState.SetupResult setupResult = DataCallState.SetupResult.SUCCESS;
        public LinkProperties oldLp;
        public LinkProperties newLp;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.783 -0400", hash_original_method = "5FFECF7E7800E048A607977532017882", hash_generated_method = "BA37A2268AB719BF57E4F27590E92808")
        @DSModeled(DSC.SAFE)
        public UpdateLinkPropertyResult(LinkProperties curLp) {
            dsTaint.addTaint(curLp.dsTaint);
            // ---------- Original Method ----------
            //oldLp = curLp;
            //newLp = curLp;
        }

        
    }


    
    private class DcDefaultState extends State {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.783 -0400", hash_original_method = "AF33D4647C9368E21A04243E95A9DF92", hash_generated_method = "0A273BAD4C41ED731C01E9CA5B622A56")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void enter() {
            phone.mCM.registerForRilConnected(getHandler(), EVENT_RIL_CONNECTED, null);
            // ---------- Original Method ----------
            //phone.mCM.registerForRilConnected(getHandler(), EVENT_RIL_CONNECTED, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.783 -0400", hash_original_method = "B29A8A064FC1508BFE2503E3804D9F04", hash_generated_method = "95E1F243FFAD98E05A6E520CB56A61E1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void exit() {
            phone.mCM.unregisterForRilConnected(getHandler());
            // ---------- Original Method ----------
            //phone.mCM.unregisterForRilConnected(getHandler());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.784 -0400", hash_original_method = "861DABBEFC0C5CEA3EC16D264376B7D7", hash_generated_method = "12DA00EC89E063E4182BCB5B21871724")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean processMessage(Message msg) {
            dsTaint.addTaint(msg.dsTaint);
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
                    boolean var4A35D05DBEBBB0D641DCA4C1673022CB_270099536 = (!mApnList.contains(apnContext));
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
            //Begin case EVENT_DISCONNECT_ALL 
            {
                log("DcDefaultState deferring msg.what=EVENT_DISCONNECT_ALL" + mRefCount);
            } //End block
            //End case EVENT_DISCONNECT_ALL 
            //Begin case EVENT_DISCONNECT_ALL 
            deferMessage(msg);
            //End case EVENT_DISCONNECT_ALL 
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
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class DcInactiveState extends State {
        private ConnectionParams mConnectionParams = null;
        private FailCause mFailCause = null;
        private DisconnectParams mDisconnectParams = null;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.784 -0400", hash_original_method = "CBB71B6A4AE30457112F09AD25305330", hash_generated_method = "9044A34552110810ADAFDC2B75DB32A2")
        @DSModeled(DSC.SAFE)
        public void setEnterNotificationParams(ConnectionParams cp, FailCause cause,
                                               int retryOverride) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(cp.dsTaint);
            dsTaint.addTaint(cause.dsTaint);
            dsTaint.addTaint(retryOverride);
            log("DcInactiveState: setEnterNoticationParams cp,cause");
            mRetryOverride = retryOverride;
            // ---------- Original Method ----------
            //if (VDBG) log("DcInactiveState: setEnterNoticationParams cp,cause");
            //mConnectionParams = cp;
            //mFailCause = cause;
            //mRetryOverride = retryOverride;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.784 -0400", hash_original_method = "58F7FEE7FE1847BE132197954CFB7983", hash_generated_method = "52CEEBFC161F5740C31599260886C81A")
        @DSModeled(DSC.SAFE)
        public void setEnterNotificationParams(DisconnectParams dp) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(dp.dsTaint);
            log("DcInactiveState: setEnterNoticationParams dp");
            // ---------- Original Method ----------
            //if (VDBG) log("DcInactiveState: setEnterNoticationParams dp");
            //mDisconnectParams = dp;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.784 -0400", hash_original_method = "5ECFC066410D8ABDEB9EC29A69A13CA8", hash_generated_method = "059D524AC9AB0674AEAB778CE16A56B3")
        @DSModeled(DSC.SAFE)
        @Override
        public void enter() {
            mTag += 1;
            {
                log("DcInactiveState: enter notifyConnectCompleted");
                notifyConnectCompleted(mConnectionParams, mFailCause);
            } //End block
            {
                log("DcInactiveState: enter notifyDisconnectCompleted");
                notifyDisconnectCompleted(mDisconnectParams, true);
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
                //notifyDisconnectCompleted(mDisconnectParams, true);
            //}
            //clearSettings();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.784 -0400", hash_original_method = "0122D4B6A897CA907F15060B70B58C0B", hash_generated_method = "122DC4498F975CA097D58C88C978E116")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.785 -0400", hash_original_method = "5D9A3D521668E78C1CF25F8EB0112B8D", hash_generated_method = "5D0164FC021AFC022C4F4908731A4955")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean processMessage(Message msg) {
            dsTaint.addTaint(msg.dsTaint);
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
            notifyDisconnectCompleted((DisconnectParams)msg.obj, false);
            //End case EVENT_DISCONNECT 
            //Begin case EVENT_DISCONNECT 
            retVal = HANDLED;
            //End case EVENT_DISCONNECT 
            //Begin case EVENT_DISCONNECT_ALL 
            log("DcInactiveState: msg.what=EVENT_DISCONNECT_ALL");
            //End case EVENT_DISCONNECT_ALL 
            //Begin case EVENT_DISCONNECT_ALL 
            notifyDisconnectCompleted((DisconnectParams)msg.obj, false);
            //End case EVENT_DISCONNECT_ALL 
            //Begin case EVENT_DISCONNECT_ALL 
            retVal = HANDLED;
            //End case EVENT_DISCONNECT_ALL 
            //Begin case default 
            {
                log("DcInactiveState nothandled msg.what=0x" +
                                Integer.toHexString(msg.what));
            } //End block
            //End case default 
            //Begin case default 
            retVal = NOT_HANDLED;
            //End case default 
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class DcActivatingState extends State {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.785 -0400", hash_original_method = "FDE326A498C74E1E809F141FF2FEACCA", hash_generated_method = "BABE00155F97A7F98753D7ABCEBB56E1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean processMessage(Message msg) {
            dsTaint.addTaint(msg.dsTaint);
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
            throw new RuntimeException("Unknown SetupResult, should not happen");
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
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class DcActiveState extends State {
        private ConnectionParams mConnectionParams = null;
        private FailCause mFailCause = null;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.785 -0400", hash_original_method = "65AC06854CC9D1F4537757F901F06476", hash_generated_method = "DD07181A99FCFFCE07E64A74A1DE781E")
        @DSModeled(DSC.SAFE)
        public void setEnterNotificationParams(ConnectionParams cp, FailCause cause) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(cp.dsTaint);
            dsTaint.addTaint(cause.dsTaint);
            log("DcInactiveState: setEnterNoticationParams cp,cause");
            // ---------- Original Method ----------
            //if (VDBG) log("DcInactiveState: setEnterNoticationParams cp,cause");
            //mConnectionParams = cp;
            //mFailCause = cause;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.785 -0400", hash_original_method = "F04274E6B6E666DB4B8B2ADDB4ED15CF", hash_generated_method = "3909F7E71B26716E2348C0B5F183A9BE")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.785 -0400", hash_original_method = "6361033575190DC86852AD59967B3D8E", hash_generated_method = "02283EB896FC2DC834E3CEC198F944C4")
        @DSModeled(DSC.SAFE)
        @Override
        public void exit() {
            mConnectionParams = null;
            mFailCause = null;
            // ---------- Original Method ----------
            //mConnectionParams = null;
            //mFailCause = null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.786 -0400", hash_original_method = "3F86B352C4AE47D7777BCBC7DBB975E2", hash_generated_method = "E60A9B96ACDA276572C7E7B76C5B2A36")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean processMessage(Message msg) {
            dsTaint.addTaint(msg.dsTaint);
            boolean retVal;
            //Begin case EVENT_CONNECT 
            mRefCount++;
            //End case EVENT_CONNECT 
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
            mRefCount--;
            //End case EVENT_DISCONNECT 
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
                    notifyDisconnectCompleted((DisconnectParams) msg.obj, false);
                } //End block
            } //End block
            //End case EVENT_DISCONNECT 
            //Begin case EVENT_DISCONNECT 
            retVal = HANDLED;
            //End case EVENT_DISCONNECT 
            //Begin case EVENT_DISCONNECT_ALL 
            {
                log("DcActiveState msg.what=EVENT_DISCONNECT_ALL RefCount=" + mRefCount);
            } //End block
            //End case EVENT_DISCONNECT_ALL 
            //Begin case EVENT_DISCONNECT_ALL 
            mRefCount = 0;
            //End case EVENT_DISCONNECT_ALL 
            //Begin case EVENT_DISCONNECT_ALL 
            DisconnectParams dp;
            dp = (DisconnectParams) msg.obj;
            //End case EVENT_DISCONNECT_ALL 
            //Begin case EVENT_DISCONNECT_ALL 
            dp.tag = mTag;
            //End case EVENT_DISCONNECT_ALL 
            //Begin case EVENT_DISCONNECT_ALL 
            tearDownData(dp);
            //End case EVENT_DISCONNECT_ALL 
            //Begin case EVENT_DISCONNECT_ALL 
            transitionTo(mDisconnectingState);
            //End case EVENT_DISCONNECT_ALL 
            //Begin case EVENT_DISCONNECT_ALL 
            retVal = HANDLED;
            //End case EVENT_DISCONNECT_ALL 
            //Begin case default 
            {
                log("DcActiveState not handled msg.what=0x" +
                                Integer.toHexString(msg.what));
            } //End block
            //End case default 
            //Begin case default 
            retVal = NOT_HANDLED;
            //End case default 
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class DcDisconnectingState extends State {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.786 -0400", hash_original_method = "DD3249EFBD400B69680BE43C46063370", hash_generated_method = "16B40457A83C175274FE17C5F3A0A7B8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean processMessage(Message msg) {
            dsTaint.addTaint(msg.dsTaint);
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
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class DcDisconnectionErrorCreatingConnection extends State {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.786 -0400", hash_original_method = "E9D4515D62B87825C79C67876E4313E2", hash_generated_method = "535765EFC948B23E9863EF74ADCBF78C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean processMessage(Message msg) {
            dsTaint.addTaint(msg.dsTaint);
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
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
}


