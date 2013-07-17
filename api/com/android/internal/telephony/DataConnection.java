package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.896 -0400", hash_original_field = "DA5953071EE7823FDF8D83F49423D96B", hash_generated_field = "CD0721759B4466C03691E733797DD315")

    protected AsyncChannel mAc;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.896 -0400", hash_original_field = "DBD79858C5E50CD8821FE7C8D65E495B", hash_generated_field = "C4FE21B00EEE6A458E193D584E7E2C76")

    private List<ApnContext> mApnList = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.896 -0400", hash_original_field = "F624BA341CEE490E0F6E6147BBEFD20A", hash_generated_field = "43EA75A8E40D96F1FE9644BAABB59B27")

    PendingIntent mReconnectIntent = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.896 -0400", hash_original_field = "D73A59E9012E9F1B2B0381F2B99244EB", hash_generated_field = "861BA63EA88683DE381E86F4D6D3F1AD")

    protected ApnSetting mApn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.896 -0400", hash_original_field = "07496860B5C53FDD66588727158D5F73", hash_generated_field = "DD44804C5337E386664F560C02BE343C")

    protected int mTag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.897 -0400", hash_original_field = "F7A42FE7211F98AC7A60A285AC3A9E87", hash_generated_field = "4FEA837943E73EF5CB83661843F1AD15")

    protected PhoneBase phone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.897 -0400", hash_original_field = "C377C6F97C92F8D0FBD252C9A0BEFE61", hash_generated_field = "580E7C4318D3476CC0659BF42E5F3A02")

    protected int mRilVersion = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.897 -0400", hash_original_field = "4B7CC5694DD3A265BAC326EABA31266E", hash_generated_field = "A51EAFC1706A086015D96F276D59C143")

    protected int cid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.897 -0400", hash_original_field = "B8279A4588519617AACD8162DC8B7A3D", hash_generated_field = "A5A5AFED252C7D512DACD2841D863761")

    protected LinkProperties mLinkProperties = new LinkProperties();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.897 -0400", hash_original_field = "16376715C2450E19AB99EA16CA75CD60", hash_generated_field = "A46D45BD76CF171387C1C09380918B0D")

    protected LinkCapabilities mCapabilities = new LinkCapabilities();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.897 -0400", hash_original_field = "1ED2E1B19B6E55D52D2473BE17A4AFD9", hash_generated_field = "BDD8643E97E5DC61E6EAAAF64140026D")

    protected long createTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.897 -0400", hash_original_field = "760B31CC56D2FB25A6A1C5A368F2683F", hash_generated_field = "A20A821CFA63B57B209D4480F0D19EFE")

    protected long lastFailTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.897 -0400", hash_original_field = "CEF28067CDCF0529C1FAE13BBD637F0D", hash_generated_field = "6C25BC29EE727D8706010965EC862301")

    protected FailCause lastFailCause;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.897 -0400", hash_original_field = "CCE2A9E206B7E958ABA7455CB2F70FC3", hash_generated_field = "DE06CED5AB988CDFE56F6FF52DB76E5B")

    protected int mRetryOverride = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.897 -0400", hash_original_field = "DAC8A06C1EDF9825CDAF6DFCD18A7ADC", hash_generated_field = "66F3E0510779BE4D1B59CDAC387E6C47")

    private int mRefCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.897 -0400", hash_original_field = "56491F2E1C74898E18BB6E47D2425B19", hash_generated_field = "64F9C8FFBF59E1349A604124A0E0710A")

    Object userData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.897 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "9AA2EA3A2433F5D6F841BEFD54A673B4")

    private int mId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.897 -0400", hash_original_field = "7D24E53F19D56D7A29B7BFB52B2F4C21", hash_generated_field = "6C728820465A4CC87E1F72987D225AAA")

    private RetryManager mRetryMgr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.897 -0400", hash_original_field = "45077AA2C731BE80F694DDAEF8E2A07C", hash_generated_field = "69571CA19C3B558505D31735F0F9B91B")

    private DcDefaultState mDefaultState = new DcDefaultState();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.897 -0400", hash_original_field = "1C6EC94A598D515735A3FE7B72C0A405", hash_generated_field = "F5AB6F71A92E9D262A29AB9EF8925002")

    private DcInactiveState mInactiveState = new DcInactiveState();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.897 -0400", hash_original_field = "3C1683BF56A594E4DEB6A2E038638234", hash_generated_field = "DDDC0B6EBEB86603B4A087252D031623")

    private DcActivatingState mActivatingState = new DcActivatingState();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.897 -0400", hash_original_field = "04925F16D72BAEAA0EE7EB33B483185E", hash_generated_field = "9D5433FE7E5E65E836534512E552B10F")

    private DcActiveState mActiveState = new DcActiveState();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.898 -0400", hash_original_field = "2B8B7AD8EC6BCD01415CED9815E426D1", hash_generated_field = "D3E64CA9FA2850A1BACA275155C23DC5")

    private DcDisconnectingState mDisconnectingState = new DcDisconnectingState();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.898 -0400", hash_original_field = "9769FD31F0BD672EC82091014B0948DA", hash_generated_field = "CD618074011D52150D4FE826A3AA4C98")

    private DcDisconnectionErrorCreatingConnection mDisconnectingErrorCreatingConnection = new DcDisconnectionErrorCreatingConnection();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.899 -0400", hash_original_method = "C1A86AB25296EBC0B07A31287A18BD02", hash_generated_method = "FF17E6215528B33FC51F74A116EF414D")
    protected  DataConnection(PhoneBase phone, String name, int id, RetryManager rm) {
        super(name);
        addTaint(name.getTaint());
        if(DBG)        
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
        if(DBG)        
        log("DataConnection constructor X");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.901 -0400", hash_original_method = "59ED68D7EF373C505428063E232AFE5C", hash_generated_method = "40C33FD9737C4F2776F556CC995C1DDE")
    private void tearDownData(Object o) {
        addTaint(o.getTaint());
        int discReason = RILConstants.DEACTIVATE_REASON_NONE;
        if((o != null) && (o instanceof DisconnectParams))        
        {
            DisconnectParams dp = (DisconnectParams)o;
            Message m = dp.onCompletedMsg;
            if(TextUtils.equals(dp.reason, Phone.REASON_RADIO_TURNED_OFF))            
            {
                discReason = RILConstants.DEACTIVATE_REASON_RADIO_OFF;
            } //End block
            else
            if(TextUtils.equals(dp.reason, Phone.REASON_PDP_RESET))            
            {
                discReason = RILConstants.DEACTIVATE_REASON_PDP_RESET;
            } //End block
        } //End block
        if(phone.mCM.getRadioState().isOn())        
        {
            if(DBG)            
            log("tearDownData radio is on, call deactivateDataCall");
            phone.mCM.deactivateDataCall(cid, discReason, obtainMessage(EVENT_DEACTIVATE_DONE, o));
        } //End block
        else
        {
            if(DBG)            
            log("tearDownData radio is off sendMessage EVENT_DEACTIVATE_DONE immediately");
            AsyncResult ar = new AsyncResult(o, null, null);
            sendMessage(obtainMessage(EVENT_DEACTIVATE_DONE, ar));
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.902 -0400", hash_original_method = "4864ED15F4860BAE9DD2587736D4A08F", hash_generated_method = "0422BD222B7D78A64B5666D029F2F8DD")
    private void notifyConnectCompleted(ConnectionParams cp, FailCause cause) {
        addTaint(cp.getTaint());
        Message connectionCompletedMsg = cp.onCompletedMsg;
        if(connectionCompletedMsg == null)        
        {
            return;
        } //End block
        long timeStamp = System.currentTimeMillis();
        connectionCompletedMsg.arg1 = cid;
        if(cause == FailCause.NONE)        
        {
            createTime = timeStamp;
            AsyncResult.forMessage(connectionCompletedMsg);
        } //End block
        else
        {
            lastFailCause = cause;
            lastFailTime = timeStamp;
            AsyncResult.forMessage(connectionCompletedMsg, cause,
                                   new CallSetupException(mRetryOverride));
        } //End block
        if(DBG)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.903 -0400", hash_original_method = "DB15644DADCD9FE90AC8779F50E40D9C", hash_generated_method = "B1801680D87068F7BB6249BB80312C0E")
    private void notifyDisconnectCompleted(DisconnectParams dp) {
        addTaint(dp.getTaint());
        if(VDBG)        
        log("NotifyDisconnectCompleted");
        if(dp.onCompletedMsg != null)        
        {
            Message msg = dp.onCompletedMsg;
            if(VDBG)            
            {
                log(String.format("msg=%s msg.obj=%s", msg.toString(),
                    ((msg.obj instanceof String) ? (String) msg.obj : "<no-reason>")));
            } //End block
            AsyncResult.forMessage(msg);
            msg.sendToTarget();
        } //End block
        if(DBG)        
        log("NotifyDisconnectCompleted DisconnectParams=" + dp);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.904 -0400", hash_original_method = "1BB05B964694E45E9B1991E5D1915447", hash_generated_method = "291EB36F37354AD2C22795FA353979AD")
    protected int getRadioTechnology(int defaultRadioTechnology) {
        addTaint(defaultRadioTechnology);
        int radioTechnology;
        if(mRilVersion < 6)        
        {
            radioTechnology = defaultRadioTechnology;
        } //End block
        else
        {
            radioTechnology = phone.getServiceState().getRadioTechnology() + 2;
        } //End block
        int varA66BB72250253C04C03E47D14B7D979C_193751641 = (radioTechnology);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1078381650 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1078381650;
        // ---------- Original Method ----------
        //int radioTechnology;
        //if (mRilVersion < 6) {
            //radioTechnology = defaultRadioTechnology;
        //} else {
            //radioTechnology = phone.getServiceState().getRadioTechnology() + 2;
        //}
        //return radioTechnology;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.914 -0400", hash_original_method = "AAF5779D145C421CCE90F0916803977D", hash_generated_method = "1E0D7FFAAA1F113D0A0FE4F2B7E779DC")
    public int getDataConnectionId() {
        int var6AC7F06B6413A1BE9C136DC7DF0D2B60_930770934 = (mId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2067965001 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2067965001;
        // ---------- Original Method ----------
        //return mId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.914 -0400", hash_original_method = "FC51BF074579EE4E5F8C7AB511B49B8A", hash_generated_method = "3D73255E3ACB724677B990A4F502C4F9")
    public int getRetryCount() {
        int var856722A58FF7F8FC2D44F69E6603CDE1_103943147 = (mRetryMgr.getRetryCount());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1480372223 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1480372223;
        // ---------- Original Method ----------
        //return mRetryMgr.getRetryCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.914 -0400", hash_original_method = "21D3097027A7BF6D8D1F04609D8A2AE9", hash_generated_method = "0EE803B049F2D147150586A2042CFED6")
    public int getRetryTimer() {
        int var40230F6DAFFC9B4870524C7581051C68_467758969 = (mRetryMgr.getRetryTimer());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1833876803 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1833876803;
        // ---------- Original Method ----------
        //return mRetryMgr.getRetryTimer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.914 -0400", hash_original_method = "2EFBBED22C4BDBBAA07E00436CC70BDF", hash_generated_method = "0E371755B2F0C7630C7641033AED74E0")
    public void increaseRetryCount() {
        mRetryMgr.increaseRetryCount();
        // ---------- Original Method ----------
        //mRetryMgr.increaseRetryCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.914 -0400", hash_original_method = "BE0E8B7CBE5F430456218437A69801A6", hash_generated_method = "936DCC864427DDC4488B6112BD3DFFA1")
    public boolean isRetryNeeded() {
        boolean var8CFC4B429BB22FAC1C66AB2505A18020_115209703 = (mRetryMgr.isRetryNeeded());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1397196377 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1397196377;
        // ---------- Original Method ----------
        //return mRetryMgr.isRetryNeeded();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.915 -0400", hash_original_method = "6E600B114543C0C51BDDB686B0EEF1BE", hash_generated_method = "32DE04BB7113D9D458E9B8A4B5F7798C")
    public void resetRetryCount() {
        mRetryMgr.resetRetryCount();
        // ---------- Original Method ----------
        //mRetryMgr.resetRetryCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.915 -0400", hash_original_method = "FE4AFC35148D7FCE7B6DEB885B8B31DF", hash_generated_method = "8D1E6E9AC70CC605B5E9E3DFBC8CC440")
    public void retryForeverUsingLastTimeout() {
        mRetryMgr.retryForeverUsingLastTimeout();
        // ---------- Original Method ----------
        //mRetryMgr.retryForeverUsingLastTimeout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.915 -0400", hash_original_method = "7BE7662A27A4557E7DE38D4C4F7B834F", hash_generated_method = "81AF5C8070C9704F70F3E5710282AA23")
    public boolean isRetryForever() {
        boolean var83983FC62F4738DD7E28A321F54D1CF6_1169127073 = (mRetryMgr.isRetryForever());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_358691947 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_358691947;
        // ---------- Original Method ----------
        //return mRetryMgr.isRetryForever();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.915 -0400", hash_original_method = "7F3E6401D154FAD4235CC7C3EA752D6F", hash_generated_method = "C32370C3C83DFF31BF4CB2A32BA7C576")
    public boolean configureRetry(int maxRetryCount, int retryTime, int randomizationTime) {
        addTaint(randomizationTime);
        addTaint(retryTime);
        addTaint(maxRetryCount);
        boolean varA2719F40E8789F490E21F83232E29078_1069657602 = (mRetryMgr.configure(maxRetryCount, retryTime, randomizationTime));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1432342638 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1432342638;
        // ---------- Original Method ----------
        //return mRetryMgr.configure(maxRetryCount, retryTime, randomizationTime);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.915 -0400", hash_original_method = "23B74F0922BA8C1F44E04170074AC8EE", hash_generated_method = "6A6D3F45D63050954BCBB20A968607D9")
    public boolean configureRetry(String configStr) {
        addTaint(configStr.getTaint());
        boolean varEA1F984E883E77F7BBDC5CAD765E84EF_529965382 = (mRetryMgr.configure(configStr));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1255174870 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1255174870;
        // ---------- Original Method ----------
        //return mRetryMgr.configure(configStr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.915 -0400", hash_original_method = "14EAC6C2DDCA29A3543D7FF941CEE3A4", hash_generated_method = "183F622F9B2FEC94ECFF704FEC664F4C")
    protected void clearSettings() {
        if(DBG)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.916 -0400", hash_original_method = "75094A2EA3723036F1D43E5DA379759D", hash_generated_method = "BEA429400F242F796610DD303FED745E")
    private DataCallState.SetupResult onSetupConnectionCompleted(AsyncResult ar) {
        addTaint(ar.getTaint());
        DataCallState response = (DataCallState) ar.result;
        ConnectionParams cp = (ConnectionParams) ar.userObj;
        DataCallState.SetupResult result;
        if(ar.exception != null)        
        {
            if(DBG)            
            {
                log("onSetupConnectionCompleted failed, ar.exception=" + ar.exception +
                    " response=" + response);
            } //End block
            if(ar.exception instanceof CommandException
                    && ((CommandException) (ar.exception)).getCommandError()
                    == CommandException.Error.RADIO_NOT_AVAILABLE)            
            {
                result = DataCallState.SetupResult.ERR_BadCommand;
                result.mFailCause = FailCause.RADIO_NOT_AVAILABLE;
            } //End block
            else
            if((response == null) || (response.version < 4))            
            {
                result = DataCallState.SetupResult.ERR_GetLastErrorFromRil;
            } //End block
            else
            {
                result = DataCallState.SetupResult.ERR_RilError;
                result.mFailCause = FailCause.fromInt(response.status);
            } //End block
        } //End block
        else
        if(cp.tag != mTag)        
        {
            if(DBG)            
            {
                log("BUG: onSetupConnectionCompleted is stale cp.tag=" + cp.tag + ", mtag=" + mTag);
            } //End block
            result = DataCallState.SetupResult.ERR_Stale;
        } //End block
        else
        if(response.status != 0)        
        {
            result = DataCallState.SetupResult.ERR_RilError;
            result.mFailCause = FailCause.fromInt(response.status);
        } //End block
        else
        {
            if(DBG)            
            log("onSetupConnectionCompleted received DataCallState: " + response);
            cid = response.cid;
            result = updateLinkProperty(response).setupResult;
        } //End block
DataCallState.SetupResult varDC838461EE2FA0CA4C9BBB70A15456B0_156992028 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_156992028.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_156992028;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.916 -0400", hash_original_method = "F1DF17AEAB523CA725A1A0E7587A5B33", hash_generated_method = "97E0EAEB82C4A1A200D8FDDCD26E1712")
    private int getSuggestedRetryTime(AsyncResult ar) {
        addTaint(ar.getTaint());
        int retry = -1;
        if(ar.exception == null)        
        {
            DataCallState response = (DataCallState) ar.result;
            retry =  response.suggestedRetryTime;
        } //End block
        int var165E6D21E0A2CC9EBB32CA05F90E0FA7_1822282864 = (retry);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1647719137 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1647719137;
        // ---------- Original Method ----------
        //int retry = -1;
        //if (ar.exception == null) {
            //DataCallState response = (DataCallState) ar.result;
            //retry =  response.suggestedRetryTime;
        //}
        //return retry;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.916 -0400", hash_original_method = "61A23083F49649744D5BB908131730E7", hash_generated_method = "E827284F6027FB80F95C9D642A7C6F5F")
    private DataCallState.SetupResult setLinkProperties(DataCallState response,
            LinkProperties lp) {
        addTaint(lp.getTaint());
        addTaint(response.getTaint());
        boolean okToUseSystemPropertyDns = false;
        String propertyPrefix = "net." + response.ifname + ".";
        String dnsServers[] = new String[2];
        dnsServers[0] = SystemProperties.get(propertyPrefix + "dns1");
        dnsServers[1] = SystemProperties.get(propertyPrefix + "dns2");
        okToUseSystemPropertyDns = isDnsOk(dnsServers);
DataCallState.SetupResult varB3E099EEEE237B1B0921398F20EF7758_304925393 =         response.setLinkProperties(lp, okToUseSystemPropertyDns);
        varB3E099EEEE237B1B0921398F20EF7758_304925393.addTaint(taint);
        return varB3E099EEEE237B1B0921398F20EF7758_304925393;
        // ---------- Original Method ----------
        //boolean okToUseSystemPropertyDns = false;
        //String propertyPrefix = "net." + response.ifname + ".";
        //String dnsServers[] = new String[2];
        //dnsServers[0] = SystemProperties.get(propertyPrefix + "dns1");
        //dnsServers[1] = SystemProperties.get(propertyPrefix + "dns2");
        //okToUseSystemPropertyDns = isDnsOk(dnsServers);
        //return response.setLinkProperties(lp, okToUseSystemPropertyDns);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.916 -0400", hash_original_method = "45E9586484C37E223B6289BDE8E786AB", hash_generated_method = "E8C9DE6160B84AE0A35CDC74488A142E")
    private UpdateLinkPropertyResult updateLinkProperty(DataCallState newState) {
        addTaint(newState.getTaint());
        UpdateLinkPropertyResult result = new UpdateLinkPropertyResult(mLinkProperties);
        if(newState == null)        
        {
UpdateLinkPropertyResult varDC838461EE2FA0CA4C9BBB70A15456B0_1674349866 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1674349866.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1674349866;
        }
        DataCallState.SetupResult setupResult;
        result.newLp = new LinkProperties();
        result.setupResult = setLinkProperties(newState, result.newLp);
        if(result.setupResult != DataCallState.SetupResult.SUCCESS)        
        {
            if(DBG)            
            log("updateLinkProperty failed : " + result.setupResult);
UpdateLinkPropertyResult varDC838461EE2FA0CA4C9BBB70A15456B0_1551425210 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_1551425210.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_1551425210;
        } //End block
        result.newLp.setHttpProxy(mLinkProperties.getHttpProxy());
        if(DBG && (! result.oldLp.equals(result.newLp)))        
        {
            if(DBG)            
            log("updateLinkProperty old != new");
            if(VDBG)            
            log("updateLinkProperty old LP=" + result.oldLp);
            if(VDBG)            
            log("updateLinkProperty new LP=" + result.newLp);
        } //End block
        mLinkProperties = result.newLp;
UpdateLinkPropertyResult varDC838461EE2FA0CA4C9BBB70A15456B0_113861393 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_113861393.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_113861393;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.917 -0400", hash_original_method = "DA4DADB76FBE855C8C796E356354585B", hash_generated_method = "A393135805A2D8AEA0546C83C412E478")
    public void bringUp(Message onCompletedMsg, ApnSetting apn) {
        addTaint(apn.getTaint());
        addTaint(onCompletedMsg.getTaint());
        sendMessage(obtainMessage(EVENT_CONNECT, new ConnectionParams(apn, onCompletedMsg)));
        // ---------- Original Method ----------
        //sendMessage(obtainMessage(EVENT_CONNECT, new ConnectionParams(apn, onCompletedMsg)));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.917 -0400", hash_original_method = "16642B60370F95B35D583CCC8A36D6BF", hash_generated_method = "EAA936056D24C9F0F618B1FC01C8824C")
    public void tearDown(String reason, Message onCompletedMsg) {
        addTaint(onCompletedMsg.getTaint());
        addTaint(reason.getTaint());
        sendMessage(obtainMessage(EVENT_DISCONNECT, new DisconnectParams(reason, onCompletedMsg)));
        // ---------- Original Method ----------
        //sendMessage(obtainMessage(EVENT_DISCONNECT, new DisconnectParams(reason, onCompletedMsg)));
    }

    
    protected static class ConnectionParams {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.917 -0400", hash_original_field = "E4D23E841D8E8804190027BCE3180FA5", hash_generated_field = "FE8BF0CD5CB8CBF698330270CCCC9D95")

        public int tag;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.917 -0400", hash_original_field = "006F1F60AC2C8635325E1AE37581797A", hash_generated_field = "38CFCC1E5D60F78E53168DDFD409D179")

        public ApnSetting apn;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.917 -0400", hash_original_field = "B99F3B373002B73E9A2614F969860442", hash_generated_field = "5CDD027FA2114D7598947EC577C34B1B")

        public Message onCompletedMsg;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.917 -0400", hash_original_method = "9C883FBF948634C8BFC48155A41A0F4D", hash_generated_method = "5B1C503045A8C8AA9F1D0D2502298AF5")
        public  ConnectionParams(ApnSetting apn, Message onCompletedMsg) {
            this.apn = apn;
            this.onCompletedMsg = onCompletedMsg;
            // ---------- Original Method ----------
            //this.apn = apn;
            //this.onCompletedMsg = onCompletedMsg;
        }

        
    }


    
    protected static class DisconnectParams {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.917 -0400", hash_original_field = "E4D23E841D8E8804190027BCE3180FA5", hash_generated_field = "FE8BF0CD5CB8CBF698330270CCCC9D95")

        public int tag;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.917 -0400", hash_original_field = "40BEA8D637CDF2C1B07FCF0630482B73", hash_generated_field = "2E3A925DF54272DE75922655083A87FE")

        public String reason;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.917 -0400", hash_original_field = "B99F3B373002B73E9A2614F969860442", hash_generated_field = "5CDD027FA2114D7598947EC577C34B1B")

        public Message onCompletedMsg;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.917 -0400", hash_original_method = "8634A04E02B052AB53AF8D3EFA7F5294", hash_generated_method = "B99F546FDC561AFD0159FD12EB1DB176")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.917 -0400", hash_original_field = "CCE2A9E206B7E958ABA7455CB2F70FC3", hash_generated_field = "032A6243CE5F8297EF5A6124BAD634D5")

        private int mRetryOverride = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.917 -0400", hash_original_method = "A504ADA2782D67F9E42B2FFAADC374C6", hash_generated_method = "D56974FF4E6B6EE04E4624DA72A498E3")
          CallSetupException(int retryOverride) {
            mRetryOverride = retryOverride;
            // ---------- Original Method ----------
            //mRetryOverride = retryOverride;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.918 -0400", hash_original_method = "474AEB2E917376DACCA3A8D3E49DB29C", hash_generated_method = "D39201A29CD393DEA03873F404F9F35A")
        public int getRetryOverride() {
            int var847246398D99EC2E1B8C5A876FE0F1E9_88663147 = (mRetryOverride);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1974156429 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1974156429;
            // ---------- Original Method ----------
            //return mRetryOverride;
        }

        
    }


    
    public static class UpdateLinkPropertyResult {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.918 -0400", hash_original_field = "789329C8124750D0DE93C78B911CE0DB", hash_generated_field = "C2A2765E7F96035E410CAF8D3027DAAC")

        public DataCallState.SetupResult setupResult = DataCallState.SetupResult.SUCCESS;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.918 -0400", hash_original_field = "E7D3E44D092EEA2E1D652BD6013620CD", hash_generated_field = "37B8435E7C404801E84F791E65EA2E96")

        public LinkProperties oldLp;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.918 -0400", hash_original_field = "D25BC672172ED598B59A0881EB7CA2CD", hash_generated_field = "8D8E816DF0FD888DB1A55D12D81B2844")

        public LinkProperties newLp;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.918 -0400", hash_original_method = "5FFECF7E7800E048A607977532017882", hash_generated_method = "5F3DBF488565FEEEF21CADA2F24034BE")
        public  UpdateLinkPropertyResult(LinkProperties curLp) {
            oldLp = curLp;
            newLp = curLp;
            // ---------- Original Method ----------
            //oldLp = curLp;
            //newLp = curLp;
        }

        
    }


    
    private class DcDefaultState extends State {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.918 -0400", hash_original_method = "65DC675B486478379964AECC5A2EA868", hash_generated_method = "65DC675B486478379964AECC5A2EA868")
        public DcDefaultState ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.918 -0400", hash_original_method = "AF33D4647C9368E21A04243E95A9DF92", hash_generated_method = "F27D177C1C31D4AE7056D39884557535")
        @Override
        public void enter() {
            phone.mCM.registerForRilConnected(getHandler(), EVENT_RIL_CONNECTED, null);
            // ---------- Original Method ----------
            //phone.mCM.registerForRilConnected(getHandler(), EVENT_RIL_CONNECTED, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.918 -0400", hash_original_method = "B29A8A064FC1508BFE2503E3804D9F04", hash_generated_method = "89332A3E017EEAA1B196A8EF770738C3")
        @Override
        public void exit() {
            phone.mCM.unregisterForRilConnected(getHandler());
            // ---------- Original Method ----------
            //phone.mCM.unregisterForRilConnected(getHandler());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.919 -0400", hash_original_method = "38E04FBDF2EDCBA5E9341920E990239B", hash_generated_method = "A28ED068FA17E03CC655D6E58981CD17")
        @Override
        public boolean processMessage(Message msg) {
            addTaint(msg.getTaint());
            AsyncResult ar;
switch(msg.what){
            case AsyncChannel.CMD_CHANNEL_FULL_CONNECTION:
            {
                if(mAc != null)                
                {
                    if(VDBG)                    
                    log("Disconnecting to previous connection mAc=" + mAc);
                    mAc.replyToMessage(msg, AsyncChannel.CMD_CHANNEL_FULLY_CONNECTED,
                                AsyncChannel.STATUS_FULL_CONNECTION_REFUSED_ALREADY_CONNECTED);
                } //End block
                else
                {
                    mAc = new AsyncChannel();
                    mAc.connected(null, getHandler(), msg.replyTo);
                    if(VDBG)                    
                    log("DcDefaultState: FULL_CONNECTION reply connected");
                    mAc.replyToMessage(msg, AsyncChannel.CMD_CHANNEL_FULLY_CONNECTED,
                                AsyncChannel.STATUS_SUCCESSFUL, mId, "hi");
                } //End block
                break;
            } //End block
            case AsyncChannel.CMD_CHANNEL_DISCONNECT:
            {
                if(VDBG)                
                log("CMD_CHANNEL_DISCONNECT");
                mAc.disconnect();
                break;
            } //End block
            case AsyncChannel.CMD_CHANNEL_DISCONNECTED:
            {
                if(VDBG)                
                log("CMD_CHANNEL_DISCONNECTED");
                mAc = null;
                break;
            } //End block
            case DataConnectionAc.REQ_IS_INACTIVE:
            {
                boolean val = getCurrentState() == mInactiveState;
                if(VDBG)                
                log("REQ_IS_INACTIVE  isInactive=" + val);
                mAc.replyToMessage(msg, DataConnectionAc.RSP_IS_INACTIVE, val ? 1 : 0);
                break;
            } //End block
            case DataConnectionAc.REQ_GET_CID:
            {
                if(VDBG)                
                log("REQ_GET_CID  cid=" + cid);
                mAc.replyToMessage(msg, DataConnectionAc.RSP_GET_CID, cid);
                break;
            } //End block
            case DataConnectionAc.REQ_GET_APNSETTING:
            {
                if(VDBG)                
                log("REQ_GET_APNSETTING  apnSetting=" + mApn);
                mAc.replyToMessage(msg, DataConnectionAc.RSP_GET_APNSETTING, mApn);
                break;
            } //End block
            case DataConnectionAc.REQ_GET_LINK_PROPERTIES:
            {
                LinkProperties lp = new LinkProperties(mLinkProperties);
                if(VDBG)                
                log("REQ_GET_LINK_PROPERTIES linkProperties" + lp);
                mAc.replyToMessage(msg, DataConnectionAc.RSP_GET_LINK_PROPERTIES, lp);
                break;
            } //End block
            case DataConnectionAc.REQ_SET_LINK_PROPERTIES_HTTP_PROXY:
            {
                ProxyProperties proxy = (ProxyProperties) msg.obj;
                if(VDBG)                
                log("REQ_SET_LINK_PROPERTIES_HTTP_PROXY proxy=" + proxy);
                mLinkProperties.setHttpProxy(proxy);
                mAc.replyToMessage(msg, DataConnectionAc.RSP_SET_LINK_PROPERTIES_HTTP_PROXY);
                break;
            } //End block
            case DataConnectionAc.REQ_UPDATE_LINK_PROPERTIES_DATA_CALL_STATE:
            {
                DataCallState newState = (DataCallState) msg.obj;
                UpdateLinkPropertyResult result = updateLinkProperty(newState);
                if(VDBG)                
                {
                    log("REQ_UPDATE_LINK_PROPERTIES_DATA_CALL_STATE result="
                            + result + " newState=" + newState);
                } //End block
                mAc.replyToMessage(msg,
                                   DataConnectionAc.RSP_UPDATE_LINK_PROPERTIES_DATA_CALL_STATE,
                                   result);
                break;
            } //End block
            case DataConnectionAc.REQ_GET_LINK_CAPABILITIES:
            {
                LinkCapabilities lc = new LinkCapabilities(mCapabilities);
                if(VDBG)                
                log("REQ_GET_LINK_CAPABILITIES linkCapabilities" + lc);
                mAc.replyToMessage(msg, DataConnectionAc.RSP_GET_LINK_CAPABILITIES, lc);
                break;
            } //End block
            case DataConnectionAc.REQ_RESET:
            if(VDBG)            
            log("DcDefaultState: msg.what=REQ_RESET");
            mAc.replyToMessage(msg, DataConnectionAc.RSP_RESET);
            transitionTo(mInactiveState);
            break;
            case DataConnectionAc.REQ_GET_REFCOUNT:
            {
                if(VDBG)                
                log("REQ_GET_REFCOUNT  refCount=" + mRefCount);
                mAc.replyToMessage(msg, DataConnectionAc.RSP_GET_REFCOUNT, mRefCount);
                break;
            } //End block
            case DataConnectionAc.REQ_ADD_APNCONTEXT:
            {
                ApnContext apnContext = (ApnContext) msg.obj;
                if(VDBG)                
                log("REQ_ADD_APNCONTEXT apn=" + apnContext.getApnType());
                if(!mApnList.contains(apnContext))                
                {
                    mApnList.add(apnContext);
                } //End block
                mAc.replyToMessage(msg, DataConnectionAc.RSP_ADD_APNCONTEXT);
                break;
            } //End block
            case DataConnectionAc.REQ_REMOVE_APNCONTEXT:
            {
                ApnContext apnContext = (ApnContext) msg.obj;
                if(VDBG)                
                log("REQ_REMOVE_APNCONTEXT apn=" + apnContext.getApnType());
                mApnList.remove(apnContext);
                mAc.replyToMessage(msg, DataConnectionAc.RSP_REMOVE_APNCONTEXT);
                break;
            } //End block
            case DataConnectionAc.REQ_GET_APNCONTEXT_LIST:
            {
                if(VDBG)                
                log("REQ_GET_APNCONTEXT_LIST num in list=" + mApnList.size());
                mAc.replyToMessage(msg, DataConnectionAc.RSP_GET_APNCONTEXT_LIST,
                                       new ArrayList<ApnContext>(mApnList));
                break;
            } //End block
            case DataConnectionAc.REQ_SET_RECONNECT_INTENT:
            {
                PendingIntent intent = (PendingIntent) msg.obj;
                if(VDBG)                
                log("REQ_SET_RECONNECT_INTENT");
                mReconnectIntent = intent;
                mAc.replyToMessage(msg, DataConnectionAc.RSP_SET_RECONNECT_INTENT);
                break;
            } //End block
            case DataConnectionAc.REQ_GET_RECONNECT_INTENT:
            {
                if(VDBG)                
                log("REQ_GET_RECONNECT_INTENT");
                mAc.replyToMessage(msg, DataConnectionAc.RSP_GET_RECONNECT_INTENT,
                                       mReconnectIntent);
                break;
            } //End block
            case EVENT_CONNECT:
            if(DBG)            
            log("DcDefaultState: msg.what=EVENT_CONNECT, fail not expected");
            ConnectionParams cp = (ConnectionParams) msg.obj;
            notifyConnectCompleted(cp, FailCause.UNKNOWN);
            break;
            case EVENT_DISCONNECT:
            if(DBG)            
            {
                log("DcDefaultState deferring msg.what=EVENT_DISCONNECT" + mRefCount);
            } //End block
            deferMessage(msg);
            break;
            case EVENT_RIL_CONNECTED:
            ar = (AsyncResult)msg.obj;
            if(ar.exception == null)            
            {
                mRilVersion = (Integer)ar.result;
                if(DBG)                
                {
                    log("DcDefaultState: msg.what=EVENT_RIL_CONNECTED mRilVersion=" +
                                mRilVersion);
                } //End block
            } //End block
            else
            {
                log("Unexpected exception on EVENT_RIL_CONNECTED");
                mRilVersion = -1;
            } //End block
            break;
            default:
            if(DBG)            
            {
                log("DcDefaultState: shouldn't happen but ignore msg.what=0x" +
                                Integer.toHexString(msg.what));
            } //End block
            break;
}            boolean var9A5C682455CE10CEF6DFEE3AEF3730A5_821050123 = (HANDLED);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_464957440 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_464957440;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class DcInactiveState extends State {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.919 -0400", hash_original_field = "96C66254DA4CBF89EC5B3143F04303D3", hash_generated_field = "88BEDA692751646D94B15E7361FCC4BA")

        private ConnectionParams mConnectionParams = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.919 -0400", hash_original_field = "F09DBEDB3757B443A2B39CA5BBE5E328", hash_generated_field = "989525539D6A577B96BED5903F7F8BDA")

        private FailCause mFailCause = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.919 -0400", hash_original_field = "23849485C3DAF4AE616338AF3DCD550A", hash_generated_field = "66B44836F757DC466942B49412EB20B6")

        private DisconnectParams mDisconnectParams = null;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.919 -0400", hash_original_method = "BBB65F37D8F6078358DD0061CFCF8B87", hash_generated_method = "BBB65F37D8F6078358DD0061CFCF8B87")
        public DcInactiveState ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.919 -0400", hash_original_method = "CBB71B6A4AE30457112F09AD25305330", hash_generated_method = "CDF958F2AA876817F9330E37B1E1D834")
        public void setEnterNotificationParams(ConnectionParams cp, FailCause cause,
                                               int retryOverride) {
            addTaint(retryOverride);
            if(VDBG)            
            log("DcInactiveState: setEnterNoticationParams cp,cause");
            mConnectionParams = cp;
            mFailCause = cause;
            mRetryOverride = retryOverride;
            // ---------- Original Method ----------
            //if (VDBG) log("DcInactiveState: setEnterNoticationParams cp,cause");
            //mConnectionParams = cp;
            //mFailCause = cause;
            //mRetryOverride = retryOverride;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.920 -0400", hash_original_method = "58F7FEE7FE1847BE132197954CFB7983", hash_generated_method = "22EAB28409D32344C2A22692C17E5698")
        public void setEnterNotificationParams(DisconnectParams dp) {
            if(VDBG)            
            log("DcInactiveState: setEnterNoticationParams dp");
            mDisconnectParams = dp;
            // ---------- Original Method ----------
            //if (VDBG) log("DcInactiveState: setEnterNoticationParams dp");
            //mDisconnectParams = dp;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.920 -0400", hash_original_method = "7E7CE9C76124761714CEFBB8783C6ACB", hash_generated_method = "94AC668A01B24D3E313EEA2D82FF364A")
        @Override
        public void enter() {
            mTag += 1;
            if((mConnectionParams != null) && (mFailCause != null))            
            {
                if(VDBG)                
                log("DcInactiveState: enter notifyConnectCompleted");
                notifyConnectCompleted(mConnectionParams, mFailCause);
            } //End block
            if(mDisconnectParams != null)            
            {
                if(VDBG)                
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.920 -0400", hash_original_method = "0122D4B6A897CA907F15060B70B58C0B", hash_generated_method = "2FF782B07AED250A63958B87AD09AB7B")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.920 -0400", hash_original_method = "F7BD47A9DC4B0FE6830EC189D0B30877", hash_generated_method = "A58AE8FC10DBAB42D4D3CBB30666D5F3")
        @Override
        public boolean processMessage(Message msg) {
            addTaint(msg.getTaint());
            boolean retVal;
switch(msg.what){
            case DataConnectionAc.REQ_RESET:
            if(DBG)            
            {
                log("DcInactiveState: msg.what=RSP_RESET, ignore we're already reset");
            } //End block
            mAc.replyToMessage(msg, DataConnectionAc.RSP_RESET);
            retVal = HANDLED;
            break;
            case EVENT_CONNECT:
            ConnectionParams cp = (ConnectionParams) msg.obj;
            cp.tag = mTag;
            if(DBG)            
            {
                log("DcInactiveState msg.what=EVENT_CONNECT." + "RefCount = "
                                + mRefCount);
            } //End block
            mRefCount = 1;
            onConnect(cp);
            transitionTo(mActivatingState);
            retVal = HANDLED;
            break;
            case EVENT_DISCONNECT:
            if(DBG)            
            log("DcInactiveState: msg.what=EVENT_DISCONNECT");
            notifyDisconnectCompleted((DisconnectParams)msg.obj);
            retVal = HANDLED;
            break;
            default:
            if(VDBG)            
            {
                log("DcInactiveState nothandled msg.what=0x" +
                                Integer.toHexString(msg.what));
            } //End block
            retVal = NOT_HANDLED;
            break;
}            boolean var1E6151782509B2C92750CFF962B742CD_1227173413 = (retVal);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2037967876 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2037967876;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class DcActivatingState extends State {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.920 -0400", hash_original_method = "3C5900F00C80F9987C90695FBB53350C", hash_generated_method = "3C5900F00C80F9987C90695FBB53350C")
        public DcActivatingState ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.921 -0400", hash_original_method = "FDE326A498C74E1E809F141FF2FEACCA", hash_generated_method = "191D3163D2183E46E086CA7EAFBF3EBF")
        @Override
        public boolean processMessage(Message msg) {
            addTaint(msg.getTaint());
            boolean retVal;
            AsyncResult ar;
            ConnectionParams cp;
switch(msg.what){
            case EVENT_CONNECT:
            if(DBG)            
            log("DcActivatingState deferring msg.what=EVENT_CONNECT refCount = "
                            + mRefCount);
            deferMessage(msg);
            retVal = HANDLED;
            break;
            case EVENT_SETUP_DATA_CONNECTION_DONE:
            if(DBG)            
            log("DcActivatingState msg.what=EVENT_SETUP_DATA_CONNECTION_DONE");
            ar = (AsyncResult) msg.obj;
            cp = (ConnectionParams) ar.userObj;
            DataCallState.SetupResult result = onSetupConnectionCompleted(ar);
            if(DBG)            
            log("DcActivatingState onSetupConnectionCompleted result=" + result);
switch(result){
            case SUCCESS:
            mActiveState.setEnterNotificationParams(cp, FailCause.NONE);
            transitionTo(mActiveState);
            break;
            case ERR_BadCommand:
            mInactiveState.setEnterNotificationParams(cp, result.mFailCause, -1);
            transitionTo(mInactiveState);
            break;
            case ERR_UnacceptableParameter:
            tearDownData(cp);
            transitionTo(mDisconnectingErrorCreatingConnection);
            break;
            case ERR_GetLastErrorFromRil:
            phone.mCM.getLastDataCallFailCause(
                                    obtainMessage(EVENT_GET_LAST_FAIL_DONE, cp));
            break;
            case ERR_RilError:
            mInactiveState.setEnterNotificationParams(cp, result.mFailCause,
                                                                      getSuggestedRetryTime(ar));
            transitionTo(mInactiveState);
            break;
            case ERR_Stale:
            break;
            default:
            RuntimeException var961B9E5B7637169B45BEE401AD57C019_1297642952 = new RuntimeException("Unknown SetupResult, should not happen");
            var961B9E5B7637169B45BEE401AD57C019_1297642952.addTaint(taint);
            throw var961B9E5B7637169B45BEE401AD57C019_1297642952;
}            retVal = HANDLED;
            break;
            case EVENT_GET_LAST_FAIL_DONE:
            ar = (AsyncResult) msg.obj;
            cp = (ConnectionParams) ar.userObj;
            FailCause cause = FailCause.UNKNOWN;
            if(cp.tag == mTag)            
            {
                if(DBG)                
                log("DcActivatingState msg.what=EVENT_GET_LAST_FAIL_DONE");
                if(ar.exception == null)                
                {
                    int rilFailCause = ((int[]) (ar.result))[0];
                    cause = FailCause.fromInt(rilFailCause);
                } //End block
                mInactiveState.setEnterNotificationParams(cp, cause, -1);
                transitionTo(mInactiveState);
            } //End block
            else
            {
                if(DBG)                
                {
                    log("DcActivatingState EVENT_GET_LAST_FAIL_DONE is stale cp.tag="
                                + cp.tag + ", mTag=" + mTag);
                } //End block
            } //End block
            retVal = HANDLED;
            break;
            default:
            if(VDBG)            
            {
                log("DcActivatingState not handled msg.what=0x" +
                                Integer.toHexString(msg.what));
            } //End block
            retVal = NOT_HANDLED;
            break;
}            boolean var1E6151782509B2C92750CFF962B742CD_1916839149 = (retVal);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_936876154 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_936876154;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class DcActiveState extends State {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.922 -0400", hash_original_field = "96C66254DA4CBF89EC5B3143F04303D3", hash_generated_field = "88BEDA692751646D94B15E7361FCC4BA")

        private ConnectionParams mConnectionParams = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.922 -0400", hash_original_field = "F09DBEDB3757B443A2B39CA5BBE5E328", hash_generated_field = "989525539D6A577B96BED5903F7F8BDA")

        private FailCause mFailCause = null;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.922 -0400", hash_original_method = "5052F6BB3696B9FBB5C9B1F89FD73944", hash_generated_method = "5052F6BB3696B9FBB5C9B1F89FD73944")
        public DcActiveState ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.922 -0400", hash_original_method = "65AC06854CC9D1F4537757F901F06476", hash_generated_method = "01BFD2E6F6C2A381AB36D1A73A10E96B")
        public void setEnterNotificationParams(ConnectionParams cp, FailCause cause) {
            if(VDBG)            
            log("DcInactiveState: setEnterNoticationParams cp,cause");
            mConnectionParams = cp;
            mFailCause = cause;
            // ---------- Original Method ----------
            //if (VDBG) log("DcInactiveState: setEnterNoticationParams cp,cause");
            //mConnectionParams = cp;
            //mFailCause = cause;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.922 -0400", hash_original_method = "F04274E6B6E666DB4B8B2ADDB4ED15CF", hash_generated_method = "A69E3344F17933321C16A3E549F1A752")
        @Override
        public void enter() {
            if((mConnectionParams != null) && (mFailCause != null))            
            {
                if(VDBG)                
                log("DcActiveState: enter notifyConnectCompleted");
                notifyConnectCompleted(mConnectionParams, mFailCause);
            } //End block
            // ---------- Original Method ----------
            //if ((mConnectionParams != null) && (mFailCause != null)) {
                //if (VDBG) log("DcActiveState: enter notifyConnectCompleted");
                //notifyConnectCompleted(mConnectionParams, mFailCause);
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.922 -0400", hash_original_method = "6361033575190DC86852AD59967B3D8E", hash_generated_method = "41F12992C45BA1B13C3E1498872DF26C")
        @Override
        public void exit() {
            mConnectionParams = null;
            mFailCause = null;
            // ---------- Original Method ----------
            //mConnectionParams = null;
            //mFailCause = null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.923 -0400", hash_original_method = "E272CADF23159A9F3D514AE20DA7ACA2", hash_generated_method = "AA8480DF0D4389AD4CFF2C663F0AC9BA")
        @Override
        public boolean processMessage(Message msg) {
            addTaint(msg.getTaint());
            boolean retVal;
switch(msg.what){
            case EVENT_CONNECT:
            mRefCount++;
            if(DBG)            
            log("DcActiveState msg.what=EVENT_CONNECT RefCount=" + mRefCount);
            if(msg.obj != null)            
            {
                notifyConnectCompleted((ConnectionParams) msg.obj, FailCause.NONE);
            } //End block
            retVal = HANDLED;
            break;
            case EVENT_DISCONNECT:
            mRefCount--;
            if(DBG)            
            log("DcActiveState msg.what=EVENT_DISCONNECT RefCount=" + mRefCount);
            if(mRefCount == 0)            
            {
                DisconnectParams dp = (DisconnectParams) msg.obj;
                dp.tag = mTag;
                tearDownData(dp);
                transitionTo(mDisconnectingState);
            } //End block
            else
            {
                if(msg.obj != null)                
                {
                    notifyDisconnectCompleted((DisconnectParams) msg.obj);
                } //End block
            } //End block
            retVal = HANDLED;
            break;
            default:
            if(VDBG)            
            {
                log("DcActiveState not handled msg.what=0x" +
                                Integer.toHexString(msg.what));
            } //End block
            retVal = NOT_HANDLED;
            break;
}            boolean var1E6151782509B2C92750CFF962B742CD_403880913 = (retVal);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_705236716 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_705236716;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class DcDisconnectingState extends State {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.923 -0400", hash_original_method = "29C0CB68E08F466587ED5BC2F5C6C796", hash_generated_method = "29C0CB68E08F466587ED5BC2F5C6C796")
        public DcDisconnectingState ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.923 -0400", hash_original_method = "DD3249EFBD400B69680BE43C46063370", hash_generated_method = "8EC1246E89768E668548AF37B1CF7500")
        @Override
        public boolean processMessage(Message msg) {
            addTaint(msg.getTaint());
            boolean retVal;
switch(msg.what){
            case EVENT_CONNECT:
            if(DBG)            
            log("DcDisconnectingState msg.what=EVENT_CONNECT. Defer. RefCount = "
                            + mRefCount);
            deferMessage(msg);
            retVal = HANDLED;
            break;
            case EVENT_DEACTIVATE_DONE:
            if(DBG)            
            log("DcDisconnectingState msg.what=EVENT_DEACTIVATE_DONE");
            AsyncResult ar = (AsyncResult) msg.obj;
            DisconnectParams dp = (DisconnectParams) ar.userObj;
            if(dp.tag == mTag)            
            {
                mInactiveState.setEnterNotificationParams((DisconnectParams) ar.userObj);
                transitionTo(mInactiveState);
            } //End block
            else
            {
                if(DBG)                
                log("DcDisconnectState EVENT_DEACTIVATE_DONE stale dp.tag="
                                + dp.tag + " mTag=" + mTag);
            } //End block
            retVal = HANDLED;
            break;
            default:
            if(VDBG)            
            {
                log("DcDisconnectingState not handled msg.what=0x" +
                                Integer.toHexString(msg.what));
            } //End block
            retVal = NOT_HANDLED;
            break;
}            boolean var1E6151782509B2C92750CFF962B742CD_99606857 = (retVal);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1428101808 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1428101808;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class DcDisconnectionErrorCreatingConnection extends State {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.924 -0400", hash_original_method = "9EEE01BC14CD1B0E43AEFA5AA17972F9", hash_generated_method = "9EEE01BC14CD1B0E43AEFA5AA17972F9")
        public DcDisconnectionErrorCreatingConnection ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.924 -0400", hash_original_method = "E9D4515D62B87825C79C67876E4313E2", hash_generated_method = "E4AA0B2060A5859BD5647A3DA5E95BF6")
        @Override
        public boolean processMessage(Message msg) {
            addTaint(msg.getTaint());
            boolean retVal;
switch(msg.what){
            case EVENT_DEACTIVATE_DONE:
            AsyncResult ar = (AsyncResult) msg.obj;
            ConnectionParams cp = (ConnectionParams) ar.userObj;
            if(cp.tag == mTag)            
            {
                if(DBG)                
                {
                    log("DcDisconnectionErrorCreatingConnection" +
                                " msg.what=EVENT_DEACTIVATE_DONE");
                } //End block
                mInactiveState.setEnterNotificationParams(cp,
                                FailCause.UNACCEPTABLE_NETWORK_PARAMETER, -1);
                transitionTo(mInactiveState);
            } //End block
            else
            {
                if(DBG)                
                {
                    log("DcDisconnectionErrorCreatingConnection EVENT_DEACTIVATE_DONE" +
                                    " stale dp.tag=" + cp.tag + ", mTag=" + mTag);
                } //End block
            } //End block
            retVal = HANDLED;
            break;
            default:
            if(VDBG)            
            {
                log("DcDisconnectionErrorCreatingConnection not handled msg.what=0x"
                                + Integer.toHexString(msg.what));
            } //End block
            retVal = NOT_HANDLED;
            break;
}            boolean var1E6151782509B2C92750CFF962B742CD_63930288 = (retVal);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1206113837 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1206113837;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.924 -0400", hash_original_field = "A4622F7F72162611C8E075EE443BC26E", hash_generated_field = "5F5E7D64B04175B8FA820B2440F700FC")

    protected static final boolean DBG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.924 -0400", hash_original_field = "F731EB70B21910E383F52051C1671657", hash_generated_field = "9627AE94D7940D7E187DD2B77A194FB7")

    protected static final boolean VDBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.924 -0400", hash_original_field = "FDAC39383F87F7973A70D4DE67F761A9", hash_generated_field = "4B6AAD30DE4CA5A855B0088556B9ED5D")

    protected static Object mCountLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.924 -0400", hash_original_field = "4A5FC91463CC1EF00D3AA26340B946C6", hash_generated_field = "4928C87B5EACFDF4C672365969709FF8")

    protected static int mCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.924 -0400", hash_original_field = "1B5D498F3F2A701D5324361DD17F38F3", hash_generated_field = "C0991AD5CABF697F4823C19D8DBFAB04")

    protected static final int BASE = Protocol.BASE_DATA_CONNECTION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.924 -0400", hash_original_field = "042BAA48F1456211B3E8E2EDD35723DE", hash_generated_field = "1C57268A41E9E95862AAA798F982A5CA")

    protected static final int EVENT_CONNECT = BASE + 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.924 -0400", hash_original_field = "909D82AD06A783A74E418EEE2706B2AC", hash_generated_field = "05B193EA1F6AA0D2906CA9DEFC440F47")

    protected static final int EVENT_SETUP_DATA_CONNECTION_DONE = BASE + 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.924 -0400", hash_original_field = "648CBEF38769E1887B33138C19E43A10", hash_generated_field = "20A6FDD48CFFBF8BECBD6D4A2123C146")

    protected static final int EVENT_GET_LAST_FAIL_DONE = BASE + 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.924 -0400", hash_original_field = "F7206AF739EA59ACF888117DDA738E0E", hash_generated_field = "1FAE49FEE8B55A400DD0C049ABF78522")

    protected static final int EVENT_DEACTIVATE_DONE = BASE + 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.924 -0400", hash_original_field = "139CD29609D29AD7DF77466B48DE22A0", hash_generated_field = "64C9F300F0E3BA2F29ACF2E26492BA60")

    protected static final int EVENT_DISCONNECT = BASE + 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.924 -0400", hash_original_field = "870957D1B8658C53A0E273F9B1853FDF", hash_generated_field = "3132177D4B230D900956EB0E80429D56")

    protected static final int EVENT_RIL_CONNECTED = BASE + 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.924 -0400", hash_original_field = "519C12A2F7BADEC8D8A4F60F4C24D5FF", hash_generated_field = "18407D8402382A7FBFA1AC8486B0482B")

    protected static final int EVENT_LOG_BAD_DNS_ADDRESS = 50100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.924 -0400", hash_original_field = "9703C98FBA4E5997D49E93A25FA145F2", hash_generated_field = "13B653D205F77F7600F4F13DC999F8B9")

    protected static final String NULL_IP = "0.0.0.0";
}

