package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.core.InternalErrorHandler;
import gov.nist.javax.sip.SIPConstants;
import gov.nist.javax.sip.SipProviderImpl;
import gov.nist.javax.sip.header.CallID;
import gov.nist.javax.sip.header.Event;
import gov.nist.javax.sip.header.From;
import gov.nist.javax.sip.header.To;
import gov.nist.javax.sip.header.Via;
import gov.nist.javax.sip.header.ViaList;
import gov.nist.javax.sip.message.SIPMessage;
import gov.nist.javax.sip.message.SIPRequest;
import gov.nist.javax.sip.message.SIPResponse;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.sip.Dialog;
import javax.sip.IOExceptionEvent;
import javax.sip.ServerTransaction;
import javax.sip.TransactionState;
import javax.sip.message.Request;
import javax.sip.message.Response;

public abstract class SIPTransaction extends MessageChannel implements javax.sip.Transaction, gov.nist.javax.sip.TransactionExt {
    protected boolean toListener;
    protected int BASE_TIMER_INTERVAL = SIPTransactionStack.BASE_TIMER_INTERVAL;
    protected int T4 = 5000 / BASE_TIMER_INTERVAL;
    protected int T2 = 4000 / BASE_TIMER_INTERVAL;
    protected int TIMER_I = T4;
    protected int TIMER_K = T4;
    protected int TIMER_D = 32000 / BASE_TIMER_INTERVAL;
    protected transient Object applicationData;
    protected SIPResponse lastResponse;
    protected boolean isMapped;
    private Semaphore semaphore;
    protected boolean isSemaphoreAquired;
    protected String transactionId;
    public long auditTag = 0;
    protected transient SIPTransactionStack sipStack;
    protected SIPRequest originalRequest;
    private transient MessageChannel encapsulatedChannel;
    protected int peerPort;
    protected InetAddress peerInetAddress;
    protected String peerAddress;
    protected String peerProtocol;
    protected int peerPacketSourcePort;
    protected InetAddress peerPacketSourceAddress;
    protected AtomicBoolean transactionTimerStarted = new AtomicBoolean(false);
    private String branch;
    private String method;
    private long cSeq;
    private TransactionState currentState;
    private transient int retransmissionTimerLastTickCount;
    private transient int retransmissionTimerTicksLeft;
    protected int timeoutTimerTicksLeft;
    private transient Set<SIPTransactionEventListener> eventListeners;
    protected From from;
    protected To to;
    protected Event event;
    protected CallID callId;
    protected int collectionTime;
    protected String toTag;
    protected String fromTag;
    private boolean terminatedEventDelivered;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.832 -0400", hash_original_method = "5F08F1F6762C0D715B46AA0C57E5FACB", hash_generated_method = "AA52E1B24D2BF1697A6E128E8DDF63AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected SIPTransaction(SIPTransactionStack newParentStack,
            MessageChannel newEncapsulatedChannel) {
        dsTaint.addTaint(newParentStack.dsTaint);
        dsTaint.addTaint(newEncapsulatedChannel.dsTaint);
        this.semaphore = new Semaphore(1,true);
        this.peerPort = newEncapsulatedChannel.getPeerPort();
        this.peerAddress = newEncapsulatedChannel.getPeerAddress();
        this.peerInetAddress = newEncapsulatedChannel.getPeerInetAddress();
        this.peerPacketSourcePort = newEncapsulatedChannel
                .getPeerPacketSourcePort();
        this.peerPacketSourceAddress = newEncapsulatedChannel
                .getPeerPacketSourceAddress();
        this.peerProtocol = newEncapsulatedChannel.getPeerProtocol();
        {
            boolean varDFC5BF10E00B4CEC32C670E55EF86009_359255037 = (this.isReliable());
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1214564836 = (sipStack.isLoggingEnabled());
                    sipStack.getStackLogger()
                            .logDebug("use count for encapsulated channel"
                                    + this
                                    + " "
                                    + encapsulatedChannel.useCount );
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        this.currentState = null;
        disableRetransmissionTimer();
        disableTimeoutTimer();
        eventListeners = Collections.synchronizedSet(new HashSet<SIPTransactionEventListener>());
        addEventListener(newParentStack);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.833 -0400", hash_original_method = "F0D7866FE2BBCD680DCAF285C3141724", hash_generated_method = "A85C8BB9EF3609D5651054D71D8BEBCB")
    @DSModeled(DSC.SAFE)
    public String getBranchId() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.branch;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.833 -0400", hash_original_method = "55609707D0B67BA3A76250F409DE303B", hash_generated_method = "7883D24AECA9A87881398A2CD2D0713C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOriginalRequest(SIPRequest newOriginalRequest) {
        dsTaint.addTaint(newOriginalRequest.dsTaint);
        String newBranch;
        {
            boolean varED20A49E7D8795E663FD7E52527B4B8C_1122728761 = (this.originalRequest != null
                && (!this.originalRequest.getTransactionId().equals(
                        newOriginalRequest.getTransactionId())));
            {
                sipStack.removeTransactionHash(this);
            } //End block
        } //End collapsed parenthetic
        this.method = newOriginalRequest.getMethod();
        this.from = (From) newOriginalRequest.getFrom();
        this.to = (To) newOriginalRequest.getTo();
        this.toTag = this.to.getTag();
        this.fromTag = this.from.getTag();
        this.callId = (CallID) newOriginalRequest.getCallId();
        this.cSeq = newOriginalRequest.getCSeq().getSeqNumber();
        this.event = (Event) newOriginalRequest.getHeader("Event");
        this.transactionId = newOriginalRequest.getTransactionId();
        originalRequest.setTransaction(this);
        newBranch = ((Via) newOriginalRequest.getViaHeaders().getFirst())
                .getBranch();
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1953168891 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug("Setting Branch id : " + newBranch);
            } //End collapsed parenthetic
            setBranch(newBranch);
        } //End block
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_2134677244 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug("Branch id is null - compute TID!"
                        + newOriginalRequest.encode());
            } //End collapsed parenthetic
            setBranch(newOriginalRequest.getTransactionId());
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.834 -0400", hash_original_method = "E55FA929D44B8592CC293995403E5C80", hash_generated_method = "85376C33FA6080E4624821BD660AFF3B")
    @DSModeled(DSC.SAFE)
    public SIPRequest getOriginalRequest() {
        return (SIPRequest)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return originalRequest;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.834 -0400", hash_original_method = "77DF64C3C6C54874FB57EB6F51047938", hash_generated_method = "5F3E47937C372E678411B6612B5E5A9B")
    @DSModeled(DSC.SAFE)
    public Request getRequest() {
        return (Request)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (Request) originalRequest;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.834 -0400", hash_original_method = "CD53B018E22B6706BBA3F591144F3E86", hash_generated_method = "2CF292B2E8D373C160DBBF7AA0BB0810")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isInviteTransaction() {
        boolean varF00C6BE92A0E41FAF82C4342626E2262_1633291473 = (getMethod().equals(Request.INVITE));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getMethod().equals(Request.INVITE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.834 -0400", hash_original_method = "BF9744C1CDF47773C8154FC6D9BF750F", hash_generated_method = "6850873D4407216041978B6A01FCC059")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isCancelTransaction() {
        boolean varF09126792D15B60E02E36B5E7F24788C_542194200 = (getMethod().equals(Request.CANCEL));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getMethod().equals(Request.CANCEL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.834 -0400", hash_original_method = "B590647CF4DDAA4D2D7D3928C46D70C5", hash_generated_method = "B44B6199A9EC291CCEEED8B5DC7D16A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isByeTransaction() {
        boolean var6E30B2E86E105ADB2706B05016297A15_792603871 = (getMethod().equals(Request.BYE));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getMethod().equals(Request.BYE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.835 -0400", hash_original_method = "4873376BBCB3E7C4172E860864FE5E6F", hash_generated_method = "28F324897B0372A3C5F0EE2D5DCD1CD4")
    @DSModeled(DSC.SAFE)
    public MessageChannel getMessageChannel() {
        return (MessageChannel)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return encapsulatedChannel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.835 -0400", hash_original_method = "E1AAF4400C28181416F2CF35F703EDD4", hash_generated_method = "5491D8170DDBA92514A62C0020985F47")
    @DSModeled(DSC.SAFE)
    public final void setBranch(String newBranch) {
        dsTaint.addTaint(newBranch);
        // ---------- Original Method ----------
        //branch = newBranch;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.835 -0400", hash_original_method = "8CF2A0009E9AA335F31D8DE930BE32FD", hash_generated_method = "8690D737973A23880D53E0D671AED7F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String getBranch() {
        {
            this.branch = getOriginalRequest().getTopmostVia().getBranch();
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (this.branch == null) {
            //this.branch = getOriginalRequest().getTopmostVia().getBranch();
        //}
        //return branch;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.835 -0400", hash_original_method = "691C5451C67574E660997BC2056A5F23", hash_generated_method = "90E5E58722A8E0A26C4D8FB8E98B3127")
    @DSModeled(DSC.SAFE)
    public final String getMethod() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.method;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.835 -0400", hash_original_method = "01D6A6E462A394F38C502658C03C7A92", hash_generated_method = "0200D8A859E4DE7A04278AC9F26AE861")
    @DSModeled(DSC.SAFE)
    public final long getCSeq() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return this.cSeq;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.836 -0400", hash_original_method = "A4A5B758CCC2E3BD812410810F0DBFFC", hash_generated_method = "179870F60F371098C74C28EB1A2F92AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setState(TransactionState newState) {
        dsTaint.addTaint(newState.dsTaint);
        {
            newState = TransactionState.COMPLETED;
        } //End block
        {
            newState = TransactionState.CONFIRMED;
        } //End block
        newState = currentState;
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_699457888 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("Transaction:setState " + newState
                    + " " + this + " branchID = " + this.getBranch()
                    + " isClient = " + (this instanceof SIPClientTransaction));
                sipStack.getStackLogger().logStackTrace();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.836 -0400", hash_original_method = "61525F5D630175E526789474B6CFB85F", hash_generated_method = "768B01648B158EB1A3FF640E26FA55C6")
    @DSModeled(DSC.SAFE)
    public TransactionState getState() {
        return (TransactionState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.currentState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.836 -0400", hash_original_method = "C06C644410B862B7DEB29308419E2C70", hash_generated_method = "6A4FF161C9F76B44F033C4156E4AA7D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final void enableRetransmissionTimer() {
        enableRetransmissionTimer(1);
        // ---------- Original Method ----------
        //enableRetransmissionTimer(1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.836 -0400", hash_original_method = "69D842DACBECB66F6A3F4CBF6CAA3BE5", hash_generated_method = "5FDBFBA440101270A11F0E8B26FF725C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final void enableRetransmissionTimer(int tickCount) {
        dsTaint.addTaint(tickCount);
        {
            boolean varF0C28EC8C9F15D61EF70697CCCF4EF42_364755221 = (isInviteTransaction() && (this instanceof SIPClientTransaction));
            {
                retransmissionTimerTicksLeft = Math.min(tickCount,
                    MAXIMUM_RETRANSMISSION_TICK_COUNT);
            } //End block
        } //End collapsed parenthetic
        retransmissionTimerLastTickCount = retransmissionTimerTicksLeft;
        // ---------- Original Method ----------
        //if (isInviteTransaction() && (this instanceof SIPClientTransaction)) {
            //retransmissionTimerTicksLeft = tickCount;
        //} else {
            //retransmissionTimerTicksLeft = Math.min(tickCount,
                    //MAXIMUM_RETRANSMISSION_TICK_COUNT);
        //}
        //retransmissionTimerLastTickCount = retransmissionTimerTicksLeft;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.837 -0400", hash_original_method = "7BF746AF9660DF3C6103C0B4973C1639", hash_generated_method = "2CD2716A8942EAD7668CFD177D09E769")
    @DSModeled(DSC.SAFE)
    protected final void disableRetransmissionTimer() {
        retransmissionTimerTicksLeft = -1;
        // ---------- Original Method ----------
        //retransmissionTimerTicksLeft = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.837 -0400", hash_original_method = "C532D8E297B37B97B54B6D70870D5AC1", hash_generated_method = "8556EC4118079866BB2DB23482832F23")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final void enableTimeoutTimer(int tickCount) {
        dsTaint.addTaint(tickCount);
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1938570027 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug("enableTimeoutTimer " + this
                    + " tickCount " + tickCount + " currentTickCount = "
                    + timeoutTimerTicksLeft);
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (sipStack.isLoggingEnabled())
            //sipStack.getStackLogger().logDebug("enableTimeoutTimer " + this
                    //+ " tickCount " + tickCount + " currentTickCount = "
                    //+ timeoutTimerTicksLeft);
        //timeoutTimerTicksLeft = tickCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.837 -0400", hash_original_method = "9098113579473A4D9B2DEEE12DBC58EA", hash_generated_method = "74EBCF06DC426C73AD0041D14DF3531F")
    @DSModeled(DSC.SAFE)
    protected final void disableTimeoutTimer() {
        timeoutTimerTicksLeft = -1;
        // ---------- Original Method ----------
        //timeoutTimerTicksLeft = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.837 -0400", hash_original_method = "CB8F1BD04D54E1B61EA5D28A66348AD3", hash_generated_method = "2D83B18146246D98BFA584B5E41EB2B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void fireTimer() {
        {
            {
                fireTimeoutTimer();
            } //End block
        } //End block
        {
            {
                enableRetransmissionTimer(retransmissionTimerLastTickCount * 2);
                fireRetransmissionTimer();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (timeoutTimerTicksLeft != -1) {
            //if (--timeoutTimerTicksLeft == 0) {
                //fireTimeoutTimer();
            //}
        //}
        //if (retransmissionTimerTicksLeft != -1) {
            //if (--retransmissionTimerTicksLeft == 0) {
                //enableRetransmissionTimer(retransmissionTimerLastTickCount * 2);
                //fireRetransmissionTimer();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.837 -0400", hash_original_method = "308D399F3CCDEFF33AA1ADAF72826036", hash_generated_method = "068F107675564B7D8998E71B7356F7B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isTerminated() {
        boolean var7BB039B32C96C37D7F86735250612D70_1131137832 = (getState() == TERMINATED_STATE);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getState() == TERMINATED_STATE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.838 -0400", hash_original_method = "DAE59CB64F6674AD8098A54E7D2B1281", hash_generated_method = "0EEFE3AD7FB6C3C2FEFC237A9A17D889")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getHost() {
        String var391DFD238FC7D691032475C415963969_1730583963 = (encapsulatedChannel.getHost());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return encapsulatedChannel.getHost();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.838 -0400", hash_original_method = "20977D5C5AB9D45A39447595F1157FC6", hash_generated_method = "006CC0C5D7748F477DEA919800B8F90D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getKey() {
        String var867B97D6DDAF7085D245B5DC159653A4_267607312 = (encapsulatedChannel.getKey());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return encapsulatedChannel.getKey();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.838 -0400", hash_original_method = "6EB6BE0A65CE407282FBCFAA26A62D3F", hash_generated_method = "30847A50AB413DD26CE7505917FC8C1F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getPort() {
        int var8D250738F8903F27A245FCFE34073F32_1243624221 = (encapsulatedChannel.getPort());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return encapsulatedChannel.getPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.838 -0400", hash_original_method = "28698FFA104E0D8C500A173E95CB7CFA", hash_generated_method = "73754896A274EB4671B169F2839DE544")
    @DSModeled(DSC.SAFE)
    public SIPTransactionStack getSIPStack() {
        return (SIPTransactionStack)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (SIPTransactionStack) sipStack;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.838 -0400", hash_original_method = "4D24925E393EE43229BBE6696196C496", hash_generated_method = "3EA5581B1AAAA4E242BBAE278F06D152")
    @DSModeled(DSC.SAFE)
    public String getPeerAddress() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.peerAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.839 -0400", hash_original_method = "A1F90D00B31019C3C4E0EAACEB8565BB", hash_generated_method = "1927EB786842F1D65D72F33E01977D1D")
    @DSModeled(DSC.SAFE)
    public int getPeerPort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.peerPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.839 -0400", hash_original_method = "D72195827AEF451FEF473FAF2B8F43B1", hash_generated_method = "01A29E0D784ECDC2EB23E9A7975061BD")
    @DSModeled(DSC.SAFE)
    public int getPeerPacketSourcePort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.peerPacketSourcePort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.839 -0400", hash_original_method = "46454A41BD800FBE664B92E119C6A2FF", hash_generated_method = "ABBBE06990191C40E9C8F69BAA890B7C")
    @DSModeled(DSC.SAFE)
    public InetAddress getPeerPacketSourceAddress() {
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.peerPacketSourceAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.839 -0400", hash_original_method = "DE04102C176E73364B597E64B8D5F233", hash_generated_method = "3625F76D6991E6BE77BA012C9579F790")
    @DSModeled(DSC.SAFE)
    protected InetAddress getPeerInetAddress() {
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.peerInetAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.839 -0400", hash_original_method = "DB79607DA3ACB5FA2D24428DF2713F98", hash_generated_method = "EF9D1957BAF05182F4A5615F740F6423")
    @DSModeled(DSC.SAFE)
    protected String getPeerProtocol() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.peerProtocol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.839 -0400", hash_original_method = "AEF0860991248E9299E1C6DDE1EF560C", hash_generated_method = "640C22A92B1263349C12883BF367B06D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getTransport() {
        String varB1AFF9750690ACBD5CD40F4F5E221388_148617871 = (encapsulatedChannel.getTransport());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return encapsulatedChannel.getTransport();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.840 -0400", hash_original_method = "6845103B04473D4A2057FADE28E7D0AA", hash_generated_method = "F4A939E7629D765BF72629C89954F219")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isReliable() {
        boolean varB6C6105558E567E57AF146479D660091_1668281831 = (encapsulatedChannel.isReliable());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return encapsulatedChannel.isReliable();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.840 -0400", hash_original_method = "088E950799411477D094809B385ED56E", hash_generated_method = "988091D561BA73A7B6B570A7D2CFA758")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Via getViaHeader() {
        Via channelViaHeader;
        channelViaHeader = super.getViaHeader();
        try 
        {
            channelViaHeader.setBranch(branch);
        } //End block
        catch (java.text.ParseException ex)
        { }
        return (Via)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Via channelViaHeader;
        //channelViaHeader = super.getViaHeader();
        //try {
            //channelViaHeader.setBranch(branch);
        //} catch (java.text.ParseException ex) {
        //}
        //return channelViaHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.840 -0400", hash_original_method = "937EBFADC181BFE1D9D7AD4237E3287B", hash_generated_method = "9F2A30F6D7FDC738ED9593DEE506FF56")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendMessage(SIPMessage messageToSend) throws IOException {
        dsTaint.addTaint(messageToSend.dsTaint);
        try 
        {
            encapsulatedChannel.sendMessage(messageToSend,
                    this.peerInetAddress, this.peerPort);
        } //End block
        finally 
        {
            this.startTransactionTimer();
        } //End block
        // ---------- Original Method ----------
        //try {
            //encapsulatedChannel.sendMessage(messageToSend,
                    //this.peerInetAddress, this.peerPort);
        //} finally {
            //this.startTransactionTimer();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.840 -0400", hash_original_method = "40115A27A95909E2CE679A790D4014C9", hash_generated_method = "DD0868218ED1FB2DDECEA8722DA2B7CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void sendMessage(byte[] messageBytes,
            InetAddress receiverAddress, int receiverPort, boolean retry) throws IOException {
        dsTaint.addTaint(retry);
        dsTaint.addTaint(receiverPort);
        dsTaint.addTaint(receiverAddress.dsTaint);
        dsTaint.addTaint(messageBytes[0]);
        if (DroidSafeAndroidRuntime.control) throw new IOException(
                "Cannot send unparsed message through Transaction Channel!");
        // ---------- Original Method ----------
        //throw new IOException(
                //"Cannot send unparsed message through Transaction Channel!");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.841 -0400", hash_original_method = "72CEDACA72EC4BC352365F84C4504BD8", hash_generated_method = "73CE147BE6F93677E322952568191AAB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addEventListener(SIPTransactionEventListener newListener) {
        dsTaint.addTaint(newListener.dsTaint);
        eventListeners.add(newListener);
        // ---------- Original Method ----------
        //eventListeners.add(newListener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.841 -0400", hash_original_method = "668B9893C68F9233FC28CF7C4E017F56", hash_generated_method = "8A20EBD8600B10CE6D58AD521B05B325")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeEventListener(SIPTransactionEventListener oldListener) {
        dsTaint.addTaint(oldListener.dsTaint);
        eventListeners.remove(oldListener);
        // ---------- Original Method ----------
        //eventListeners.remove(oldListener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.841 -0400", hash_original_method = "38D8606DEF077947D947856564D84874", hash_generated_method = "83E44D5BB11D02F863B4DC5CA6473249")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void raiseErrorEvent(int errorEventID) {
        dsTaint.addTaint(errorEventID);
        SIPTransactionErrorEvent newErrorEvent;
        Iterator<SIPTransactionEventListener> listenerIterator;
        SIPTransactionEventListener nextListener;
        newErrorEvent = new SIPTransactionErrorEvent(this, errorEventID);
        {
            listenerIterator = eventListeners.iterator();
            {
                boolean var20BE331F515CCC1CE643C3890EEC5ABE_710166181 = (listenerIterator.hasNext());
                {
                    nextListener = (SIPTransactionEventListener) listenerIterator
                        .next();
                    nextListener.transactionErrorEvent(newErrorEvent);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            eventListeners.clear();
            this.setState(TransactionState.TERMINATED);
            {
                boolean var382FAAF04356B7108B4D034147E328B4_1175653845 = (this instanceof SIPServerTransaction && this.isByeTransaction()
                    && this.getDialog() != null);
                ((SIPDialog) this.getDialog())
                        .setState(SIPDialog.TERMINATED_STATE);
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.841 -0400", hash_original_method = "1EC803C9686336CE6058D1F41391EBE2", hash_generated_method = "9E1255B6A5F3F31FBCD8A049A81BA7D3")
    @DSModeled(DSC.SAFE)
    protected boolean isServerTransaction() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this instanceof SIPServerTransaction;
    }

    
    public abstract Dialog getDialog();

    
    public abstract void setDialog(SIPDialog sipDialog, String dialogId);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.842 -0400", hash_original_method = "A1D654E2B8EB18DBD9E2FBE3DBA84F3D", hash_generated_method = "BF9A218DC2098585755955F831ADE4D8")
    @DSModeled(DSC.SAFE)
    public int getRetransmitTimer() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return SIPTransactionStack.BASE_TIMER_INTERVAL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.844 -0400", hash_original_method = "310B5DE4F217FB57953AC74F889ED704", hash_generated_method = "0499514ED7F3D5F3F5D12D11848C696D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getViaHost() {
        String varCEFBE3A270EF934F27E2585ADB70E355_1825024402 = (this.getViaHeader().getHost());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.getViaHeader().getHost();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.844 -0400", hash_original_method = "025E14F038A1EDFF743C73F970E03870", hash_generated_method = "6CA18EFF87D6D0650D9606EE0F8C1041")
    @DSModeled(DSC.SAFE)
    public SIPResponse getLastResponse() {
        return (SIPResponse)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.lastResponse;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.844 -0400", hash_original_method = "260B447AD36FE2CA2411AAAD920B4F1F", hash_generated_method = "00817DF74571FA9819B28217048C8D82")
    @DSModeled(DSC.SAFE)
    public Response getResponse() {
        return (Response)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (Response) this.lastResponse;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.844 -0400", hash_original_method = "AB08BB44F7439305FB61E3E9EFAC9224", hash_generated_method = "27FF396E7B203A2A42D172CC60CDD965")
    @DSModeled(DSC.SAFE)
    public String getTransactionId() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.transactionId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.844 -0400", hash_original_method = "1EE454052F2EC55F5023F8455F33FFAA", hash_generated_method = "58FFDA6E2FA9F894A1A09EEE385230A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int hashCode() {
        int var4C9151DE19A39E85210081D04497D7ED_1626691918 = (this.transactionId.hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (this.transactionId == null)
            //return -1;
        //else
            //return this.transactionId.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.845 -0400", hash_original_method = "F3BD37ECEE52D7438ECD340DC4DAF3CA", hash_generated_method = "D64314ED0A24EB7CD02592F2CCC5BDEA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getViaPort() {
        int var0C6CDC10F459777D891ECCDB8DB39867_284605786 = (this.getViaHeader().getPort());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.getViaHeader().getPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.845 -0400", hash_original_method = "4C1135E1FB3652D771084DD3A5E7B7E8", hash_generated_method = "834B043D8D89830D77F3F71E73FA9E04")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean doesCancelMatchTransaction(SIPRequest requestToTest) {
        dsTaint.addTaint(requestToTest.dsTaint);
        ViaList viaHeaders;
        Via topViaHeader;
        String messageBranch;
        boolean transactionMatches;
        transactionMatches = false;
        {
            boolean varDB3FC80D18EEB586685397AA66CD0AD9_1717135840 = (this.getOriginalRequest() == null
                || this.getOriginalRequest().getMethod().equals(Request.CANCEL));
        } //End collapsed parenthetic
        viaHeaders = requestToTest.getViaHeaders();
        {
            topViaHeader = (Via) viaHeaders.getFirst();
            messageBranch = topViaHeader.getBranch();
            {
                {
                    boolean var36D9A4D2906CC61B64FFF3E977E71366_1229019539 = (!messageBranch.toLowerCase().startsWith(SIPConstants.BRANCH_MAGIC_COOKIE_LOWER_CASE));
                    {
                        messageBranch = null;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean varD825878E5C71E9D99195551828F9E150_1046704596 = (messageBranch != null && this.getBranch() != null);
                {
                    {
                        boolean var40A3BE5C85F3B3E698DEE2FF2DE53418_481637102 = (getBranch().equalsIgnoreCase(messageBranch)
                        && topViaHeader.getSentBy().equals(
                                ((Via) getOriginalRequest().getViaHeaders()
                                        .getFirst()).getSentBy()));
                        {
                            transactionMatches = true;
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_919753244 = (sipStack.isLoggingEnabled());
                                sipStack.getStackLogger().logDebug("returning  true");
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1668506490 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger().logDebug("testing against "
                            + getOriginalRequest());
                    } //End collapsed parenthetic
                    {
                        boolean varF49D98EFFEE05A7D0E6524281A64A821_461489031 = (getOriginalRequest().getRequestURI().equals(
                        requestToTest.getRequestURI())
                        && getOriginalRequest().getTo().equals(
                                requestToTest.getTo())
                        && getOriginalRequest().getFrom().equals(
                                requestToTest.getFrom())
                        && getOriginalRequest().getCallId().getCallId().equals(
                                requestToTest.getCallId().getCallId())
                        && getOriginalRequest().getCSeq().getSeqNumber() == requestToTest
                                .getCSeq().getSeqNumber()
                        && topViaHeader.equals(getOriginalRequest()
                                .getViaHeaders().getFirst()));
                        {
                            transactionMatches = true;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            this.setPassToListener();
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.846 -0400", hash_original_method = "348CFFAB37D4D83E29A04C573F3FF487", hash_generated_method = "630277FE5630D4EDED5340250683FF66")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setRetransmitTimer(int retransmitTimer) {
        dsTaint.addTaint(retransmitTimer);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "Retransmit timer must be positive!");
        {
            boolean varD45EC8E193CE555496F99346397FAFE2_861021146 = (this.transactionTimerStarted.get());
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "Transaction timer is already started");
        } //End collapsed parenthetic
        T4 = 5000 / BASE_TIMER_INTERVAL;
        T2 = 4000 / BASE_TIMER_INTERVAL;
        TIMER_I = T4;
        TIMER_K = T4;
        TIMER_D = 32000 / BASE_TIMER_INTERVAL;
        // ---------- Original Method ----------
        //if (retransmitTimer <= 0)
            //throw new IllegalArgumentException(
                    //"Retransmit timer must be positive!");
        //if (this.transactionTimerStarted.get())
            //throw new IllegalStateException(
                    //"Transaction timer is already started");
        //BASE_TIMER_INTERVAL = retransmitTimer;
        //T4 = 5000 / BASE_TIMER_INTERVAL;
        //T2 = 4000 / BASE_TIMER_INTERVAL;
        //TIMER_I = T4;
        //TIMER_K = T4;
        //TIMER_D = 32000 / BASE_TIMER_INTERVAL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.846 -0400", hash_original_method = "45CE0F911469E288CC97776E84414496", hash_generated_method = "32D7E174EF2D5D5FEF56E1A373688D06")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void close() {
        this.encapsulatedChannel.close();
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1940635174 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug("Closing " + this.encapsulatedChannel);
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //this.encapsulatedChannel.close();
        //if (sipStack.isLoggingEnabled())
            //sipStack.getStackLogger().logDebug("Closing " + this.encapsulatedChannel);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.846 -0400", hash_original_method = "905D593C098EC8A0BB1DC95C9B54F441", hash_generated_method = "561AB51581B9627397B8BE1A7107FF59")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isSecure() {
        boolean var48C9EE19D6C5FA52907CC989AE9A3A00_545072315 = (encapsulatedChannel.isSecure());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return encapsulatedChannel.isSecure();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.846 -0400", hash_original_method = "9C4DCEACA96616F074242810B487B970", hash_generated_method = "2293EB29A85F59212401F3B81E76897D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MessageProcessor getMessageProcessor() {
        MessageProcessor var545C55F89AADA2BD3924F6A4D7446C8D_649496327 = (this.encapsulatedChannel.getMessageProcessor());
        return (MessageProcessor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.encapsulatedChannel.getMessageProcessor();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.847 -0400", hash_original_method = "552E0456C33D24CD63C8EBCDAC1D019B", hash_generated_method = "8D4DDB013B0F594611E074B5CF4E663E")
    @DSModeled(DSC.SAFE)
    public void setApplicationData(Object applicationData) {
        dsTaint.addTaint(applicationData.dsTaint);
        // ---------- Original Method ----------
        //this.applicationData = applicationData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.847 -0400", hash_original_method = "5F924FC61375970A4DC758380BEBFF0F", hash_generated_method = "38CB1AED90A48D60BFA15010A96EEDEF")
    @DSModeled(DSC.SAFE)
    public Object getApplicationData() {
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.applicationData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.847 -0400", hash_original_method = "739B4CAA187BE9D487A452627B0424A2", hash_generated_method = "2270154D3F7E324D243C8F89E8B9A531")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setEncapsulatedChannel(MessageChannel messageChannel) {
        dsTaint.addTaint(messageChannel.dsTaint);
        this.peerInetAddress = messageChannel.getPeerInetAddress();
        this.peerPort = messageChannel.getPeerPort();
        // ---------- Original Method ----------
        //this.encapsulatedChannel = messageChannel;
        //this.peerInetAddress = messageChannel.getPeerInetAddress();
        //this.peerPort = messageChannel.getPeerPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.847 -0400", hash_original_method = "38ECF920BD32EC6B95BB00C4AAD637BA", hash_generated_method = "D2EBB2D1F63AD773DDDBD6A5B38DE479")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SipProviderImpl getSipProvider() {
        SipProviderImpl varC0723037C083DFEC24F8F61B0803395C_1306579374 = (this.getMessageProcessor().getListeningPoint().getProvider());
        return (SipProviderImpl)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.getMessageProcessor().getListeningPoint().getProvider();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.847 -0400", hash_original_method = "BA06BB4C0270C8B47C1CBBF5F94DA61A", hash_generated_method = "3EEAE2E16E1E1E4E008482EA45741ACC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void raiseIOExceptionEvent() {
        setState(TransactionState.TERMINATED);
        String host;
        host = getPeerAddress();
        int port;
        port = getPeerPort();
        String transport;
        transport = getTransport();
        IOExceptionEvent exceptionEvent;
        exceptionEvent = new IOExceptionEvent(this, host,
                port, transport);
        getSipProvider().handleEvent(exceptionEvent, this);
        // ---------- Original Method ----------
        //setState(TransactionState.TERMINATED);
        //String host = getPeerAddress();
        //int port = getPeerPort();
        //String transport = getTransport();
        //IOExceptionEvent exceptionEvent = new IOExceptionEvent(this, host,
                //port, transport);
        //getSipProvider().handleEvent(exceptionEvent, this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.848 -0400", hash_original_method = "9C758C929345C5BD5429DB309FDFD6EA", hash_generated_method = "AB1DAA401003C28B5827D8B804F9E2A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean acquireSem() {
        boolean retval;
        retval = false;
        try 
        {
            {
                boolean var0C9E46B9F84667219FF0963258285136_1253860415 = (sipStack.getStackLogger().isLoggingEnabled());
                {
                    sipStack.getStackLogger().logDebug("acquireSem [[[[" + this);
                    sipStack.getStackLogger().logStackTrace();
                } //End block
            } //End collapsed parenthetic
            retval = this.semaphore.tryAcquire(1000, TimeUnit.MILLISECONDS);
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1171533033 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug(
                    "acquireSem() returning : " + retval);
            } //End collapsed parenthetic
        } //End block
        catch (Exception ex)
        {
            sipStack.getStackLogger().logError("Unexpected exception acquiring sem",
                    ex);
            InternalErrorHandler.handleException(ex);
        } //End block
        finally 
        {
            this.isSemaphoreAquired = retval;
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.849 -0400", hash_original_method = "301846C685CE876D86A6B4185A591E30", hash_generated_method = "2E46BBF6796C78AED74045C8C40488CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void releaseSem() {
        try 
        {
            this.toListener = false;
            this.semRelease();
        } //End block
        catch (Exception ex)
        {
            sipStack.getStackLogger().logError("Unexpected exception releasing sem",
                    ex);
        } //End block
        // ---------- Original Method ----------
        //try {
            //this.toListener = false;
            //this.semRelease();
        //} catch (Exception ex) {
            //sipStack.getStackLogger().logError("Unexpected exception releasing sem",
                    //ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.849 -0400", hash_original_method = "DBC24F6DB4FEFD7D7F8639708567DC35", hash_generated_method = "EBBB4D06D1732FF888540DCAA491DE51")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void semRelease() {
        try 
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1305441543 = (sipStack.isLoggingEnabled());
                {
                    sipStack.getStackLogger().logDebug("semRelease ]]]]" + this);
                    sipStack.getStackLogger().logStackTrace();
                } //End block
            } //End collapsed parenthetic
            this.isSemaphoreAquired = false;
            this.semaphore.release();
        } //End block
        catch (Exception ex)
        {
            sipStack.getStackLogger().logError("Unexpected exception releasing sem",
                    ex);
        } //End block
        // ---------- Original Method ----------
        //try {
            //if (sipStack.isLoggingEnabled()) {
                //sipStack.getStackLogger().logDebug("semRelease ]]]]" + this);
                //sipStack.getStackLogger().logStackTrace();
            //}
            //this.isSemaphoreAquired = false;
            //this.semaphore.release();
        //} catch (Exception ex) {
            //sipStack.getStackLogger().logError("Unexpected exception releasing sem",
                    //ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.850 -0400", hash_original_method = "39E9029186E8CC55AF8CBCC68EB9597C", hash_generated_method = "CF316B1ACEFE83B21B370635102264D9")
    @DSModeled(DSC.SAFE)
    public boolean passToListener() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return toListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.850 -0400", hash_original_method = "F5F4C78B3DFF0EDA40F4B14C1017F836", hash_generated_method = "B622A9D20BBC2897573A6E17B0FE6039")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPassToListener() {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_2097672300 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("setPassToListener()");
            } //End block
        } //End collapsed parenthetic
        this.toListener = true;
        // ---------- Original Method ----------
        //if (sipStack.isLoggingEnabled()) {
            //sipStack.getStackLogger().logDebug("setPassToListener()");
        //}
        //this.toListener = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.850 -0400", hash_original_method = "5D50ECFAFAF878A5B29EF8C830BE2C71", hash_generated_method = "B05AF9147DFF9224A16CFD61B246CE71")
    @DSModeled(DSC.SAFE)
    protected synchronized boolean testAndSetTransactionTerminatedEvent() {
        boolean retval;
        retval = !this.terminatedEventDelivered;
        this.terminatedEventDelivered = true;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean retval = !this.terminatedEventDelivered;
        //this.terminatedEventDelivered = true;
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.850 -0400", hash_original_method = "0D2015A100DFE7954256C577DAEBD143", hash_generated_method = "C39CE08CE422A45EB4F2E6B70D3F275B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getCipherSuite() throws UnsupportedOperationException {
        {
            boolean var6C6A2C453D42291A755997484653A937_1817106902 = (this.getMessageChannel() instanceof TLSMessageChannel);
            {
                {
                    boolean varFCE35EDD0B032F5EB8C912B15CF85890_520054732 = (((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener() == null);
                    {
                        boolean var39C45FA9CE575184B384B180A37212E6_1800802351 = (((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener().getHandshakeCompletedEvent() == null);
                        String varC101F6726996686231DCCD11206E3B02_147274326 = (((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener().getHandshakeCompletedEvent().getCipherSuite());
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Not a TLS channel");
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (this.getMessageChannel() instanceof TLSMessageChannel ) {
            //if (  ((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener() == null ) 
                //return null;
            //else if ( ((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener().getHandshakeCompletedEvent() == null)
                //return null;
            //else return ((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener().getHandshakeCompletedEvent().getCipherSuite();
        //} else throw new UnsupportedOperationException("Not a TLS channel");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.851 -0400", hash_original_method = "1BD353D03C47A7F0291FB8AF92EA1899", hash_generated_method = "67199D09DF24633E7DDE11DE26F960D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public java.security.cert.Certificate[] getLocalCertificates() throws UnsupportedOperationException {
        {
            boolean var6C6A2C453D42291A755997484653A937_1491673051 = (this.getMessageChannel() instanceof TLSMessageChannel);
            {
                {
                    boolean varFCE35EDD0B032F5EB8C912B15CF85890_197256653 = (((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener() == null);
                    {
                        boolean var39C45FA9CE575184B384B180A37212E6_1227728669 = (((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener().getHandshakeCompletedEvent() == null);
                        java.security.cert.Certificate[] var0912FA8F263A7575D33AD95B31BBF23F_600744255 = (((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener().getHandshakeCompletedEvent().getLocalCertificates());
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Not a TLS channel");
        } //End collapsed parenthetic
        return (java.security.cert.Certificate[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (this.getMessageChannel() instanceof TLSMessageChannel ) {
            //if (  ((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener() == null ) 
                //return null;
            //else if ( ((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener().getHandshakeCompletedEvent() == null)
                //return null;
            //else return ((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener().getHandshakeCompletedEvent().getLocalCertificates();
        //} else throw new UnsupportedOperationException("Not a TLS channel");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.851 -0400", hash_original_method = "425975E25339AF497E9130895A1F6EC3", hash_generated_method = "2F725E0F8B9EBD210FEB9B116595EAEC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public java.security.cert.Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
        {
            boolean var6C6A2C453D42291A755997484653A937_1631110290 = (this.getMessageChannel() instanceof TLSMessageChannel);
            {
                {
                    boolean varFCE35EDD0B032F5EB8C912B15CF85890_367787209 = (((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener() == null);
                    {
                        boolean var39C45FA9CE575184B384B180A37212E6_1183187926 = (((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener().getHandshakeCompletedEvent() == null);
                        java.security.cert.Certificate[] varF24FA89604EA7955EEB0F39938C11688_557382504 = (((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener().getHandshakeCompletedEvent().getPeerCertificates());
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Not a TLS channel");
        } //End collapsed parenthetic
        return (java.security.cert.Certificate[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (this.getMessageChannel() instanceof TLSMessageChannel ) {
            //if (  ((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener() == null ) 
                //return null;
            //else if ( ((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener().getHandshakeCompletedEvent() == null)
                //return null;
            //else return ((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener().getHandshakeCompletedEvent().getPeerCertificates();
        //} else throw new UnsupportedOperationException("Not a TLS channel");
    }

    
    protected abstract void startTransactionTimer();

    
    public abstract boolean isMessagePartOfTransaction(SIPMessage messageToTest);

    
    protected abstract void fireRetransmissionTimer();

    
    protected abstract void fireTimeoutTimer();

    
    class LingerTimer extends SIPStackTimerTask {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.852 -0400", hash_original_method = "4F6152921EA187210C4EA8258CD889E1", hash_generated_method = "24194E88E85E8CCE89A7CDE98B0946D9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public LingerTimer() {
            SIPTransaction sipTransaction;
            sipTransaction = SIPTransaction.this;
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_517531766 = (sipStack.isLoggingEnabled());
                {
                    sipStack.getStackLogger().logDebug("LingerTimer : "
                        + sipTransaction.getTransactionId());
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //SIPTransaction sipTransaction = SIPTransaction.this;
            //if (sipStack.isLoggingEnabled()) {
                //sipStack.getStackLogger().logDebug("LingerTimer : "
                        //+ sipTransaction.getTransactionId());
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.852 -0400", hash_original_method = "14B41A6E0BE7E84E900DADE7EB6E3A9A", hash_generated_method = "A82A02095F4FDE258B1E5D21107ACBAC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected void runTask() {
            SIPTransaction transaction;
            transaction = SIPTransaction.this;
            SIPTransactionStack sipStack;
            sipStack = transaction.getSIPStack();
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1344462297 = (sipStack.isLoggingEnabled());
                {
                    sipStack.getStackLogger().logDebug("LingerTimer: run() : "
                        + getTransactionId());
                } //End block
            } //End collapsed parenthetic
            {
                sipStack.removeTransaction(transaction);
                transaction.close();
            } //End block
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_354345600 = (sipStack.isLoggingEnabled());
                    sipStack.getStackLogger().logDebug("removing" + transaction);
                } //End collapsed parenthetic
                sipStack.removeTransaction(transaction);
                {
                    transaction.close();
                } //End block
                {
                    {
                        boolean var4956126C243BADFE0BCC10A3ADC78702_862544444 = (sipStack.isLoggingEnabled()
                            && (!sipStack.cacheServerConnections)
                            && transaction.isReliable());
                        {
                            int useCount;
                            useCount = transaction.encapsulatedChannel.useCount;
                            sipStack.getStackLogger().logDebug("Use Count = " + useCount);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    protected static final int T1 = 1;
    protected static final int TIMER_A = 1;
    protected static final int TIMER_B = 64;
    protected static final int TIMER_J = 64;
    protected static final int TIMER_F = 64;
    protected static final int TIMER_H = 64;
    public static final TransactionState INITIAL_STATE = null;
    public static final TransactionState TRYING_STATE = TransactionState.TRYING;
    public static final TransactionState CALLING_STATE = TransactionState.CALLING;
    public static final TransactionState PROCEEDING_STATE = TransactionState.PROCEEDING;
    public static final TransactionState COMPLETED_STATE = TransactionState.COMPLETED;
    public static final TransactionState CONFIRMED_STATE = TransactionState.CONFIRMED;
    public static final TransactionState TERMINATED_STATE = TransactionState.TERMINATED;
    protected static final int MAXIMUM_RETRANSMISSION_TICK_COUNT = 8;
}

