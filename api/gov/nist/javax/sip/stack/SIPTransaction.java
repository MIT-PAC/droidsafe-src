package gov.nist.javax.sip.stack;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.693 -0400", hash_original_field = "2B259185198C3F8BF792A605A14004E6", hash_generated_field = "E1D4E9B3AAF496FD813808775B58AFF8")

    protected boolean toListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.693 -0400", hash_original_field = "87903C91D979BEB4E00BBC5332AAE689", hash_generated_field = "9A93D89EE79003352C54A76D4BCBEF57")

    protected int BASE_TIMER_INTERVAL = SIPTransactionStack.BASE_TIMER_INTERVAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.693 -0400", hash_original_field = "47E14B32BBE9F9DF68D573CACFC16149", hash_generated_field = "AFFFDDF9E03C18C4462622216D1D744E")

    protected int T4 = 5000 / BASE_TIMER_INTERVAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.693 -0400", hash_original_field = "61039199CF671E979441018417D7D597", hash_generated_field = "5AB93F413E7E37621B4D5A565BACE4EE")

    protected int T2 = 4000 / BASE_TIMER_INTERVAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.693 -0400", hash_original_field = "B70CAA4CBFD6EE4F02C591E86E116069", hash_generated_field = "9F72081078574EE44AD3339670F6DF1F")

    protected int TIMER_I = T4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.693 -0400", hash_original_field = "F1B52E1E5C59167765233838AC175899", hash_generated_field = "CA8408AC31A4B160960A20C24156B7EC")

    protected int TIMER_K = T4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.694 -0400", hash_original_field = "A6B23354CA0D6C4DAE6F5E622B535F0B", hash_generated_field = "46098F3DF9CF80FB6A2FF1FF700C1E30")

    protected int TIMER_D = 32000 / BASE_TIMER_INTERVAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.694 -0400", hash_original_field = "756C73A51ADF7F04942C8BE97A032000", hash_generated_field = "B1A8E011179EF40B9DAC21E1148B1B78")

    protected transient Object applicationData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.694 -0400", hash_original_field = "9ECD142FA67835EFBFD693D2B0EFC756", hash_generated_field = "8CE24F874A42F410B23EF4851613017C")

    protected SIPResponse lastResponse;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.694 -0400", hash_original_field = "66CA6208A29137D8034ED70E634A1646", hash_generated_field = "77FEBEAA4AF79617A8B0CBB244F26247")

    protected boolean isMapped;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.694 -0400", hash_original_field = "CE1BC7755B9332CFACDF8EE58EF2E3C1", hash_generated_field = "3F41BA6F3B911D0AFE0A127EF365871F")

    private Semaphore semaphore;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.694 -0400", hash_original_field = "24776DD7C271F7EB52082A8DF20FE6A6", hash_generated_field = "30E9188AD86CBF24A584DD99B37E6A4C")

    protected boolean isSemaphoreAquired;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.694 -0400", hash_original_field = "671139EDEB98807421E35E63D9C29A6A", hash_generated_field = "9C238CB346335F1D207FF4BBD6C9DEAD")

    protected String transactionId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.694 -0400", hash_original_field = "C0CEB3515CA4F46A6B2A58F9563A8976", hash_generated_field = "671A9D7640781DBA64AF5A5BAE3E2701")

    public long auditTag = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.694 -0400", hash_original_field = "37460D4BF2BA47A13FF9D922C4B14B2E", hash_generated_field = "4664B9159D27EBBF3CF109F118F56F46")

    protected transient SIPTransactionStack sipStack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.694 -0400", hash_original_field = "539F42CD378873BB0F9889EFF317BAFA", hash_generated_field = "E987B06AF0DFCAA9F38DD607A12D9B39")

    protected SIPRequest originalRequest;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.694 -0400", hash_original_field = "809A0AB6067FCFE0AB1E4C7E2ED026AA", hash_generated_field = "25DB028ECDD75BE4977DFE05FC00F4D2")

    private transient MessageChannel encapsulatedChannel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.694 -0400", hash_original_field = "BBD5741C4F9994864582D25DD194C4DE", hash_generated_field = "6A69B321E52130622ADD35A2A3F00BA6")

    protected int peerPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.694 -0400", hash_original_field = "D5A8CA55B131A89C25E3C0595C953BCA", hash_generated_field = "ACA9646C167AB8988D8D4678A1C02262")

    protected InetAddress peerInetAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.694 -0400", hash_original_field = "D7FA5E7DC9BACC5016B81E35D44D1C5F", hash_generated_field = "C9738122113DFDEEF725F74B583F0EE7")

    protected String peerAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.694 -0400", hash_original_field = "EDB6E8FD971C3E6879E1A00995BCB702", hash_generated_field = "FBF73E4EC3FC246E9E63B41E9D9708E4")

    protected String peerProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.695 -0400", hash_original_field = "E2843BEFA12DEA2BD46F0D29DAA8CB35", hash_generated_field = "A5A71425C21DF932789F3BE8BFE8101E")

    protected int peerPacketSourcePort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.695 -0400", hash_original_field = "1906DDE6FBF1A1A564E69A91EBCF4043", hash_generated_field = "AA48B9901BA1D417BEAE6C24D398429E")

    protected InetAddress peerPacketSourceAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.695 -0400", hash_original_field = "95ED6E6B932BB90F37EB8D409DC725E0", hash_generated_field = "C48464462DE8239144ADA7BDEA8A5336")

    protected AtomicBoolean transactionTimerStarted = new AtomicBoolean(false);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.695 -0400", hash_original_field = "9603A224B40D7B67210B78F2E390D00F", hash_generated_field = "30E846F477E8815819D75224F8F894EA")

    private String branch;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.695 -0400", hash_original_field = "EA9F6ACA279138C58F705C8D4CB4B8CE", hash_generated_field = "F42F15CDE806BBAD7F26F7952D68FCE2")

    private String method;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.695 -0400", hash_original_field = "518FD2362F5A4BA10EAEF07A78FCCE98", hash_generated_field = "42D60DCE07190569B4FB5DBAE96EB838")

    private long cSeq;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.695 -0400", hash_original_field = "542734C7E65EC6932E6AE354B2B7DB76", hash_generated_field = "1D3A2129BFAA64E672459DABFB968979")

    private TransactionState currentState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.695 -0400", hash_original_field = "C18186E6A18F0688FA3C41006C8B7690", hash_generated_field = "E635400649257FF3CB3C8321A25A9521")

    private transient int retransmissionTimerLastTickCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.695 -0400", hash_original_field = "734EA45E3F7351452921A4A8AADED8B9", hash_generated_field = "91834647ACD706C1011839DD85835F02")

    private transient int retransmissionTimerTicksLeft;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.695 -0400", hash_original_field = "C06879E46D091BA209F56764D4F2F7AE", hash_generated_field = "3CE5B548E56A9CACC294CED8BA31ABAA")

    protected int timeoutTimerTicksLeft;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.695 -0400", hash_original_field = "FEAAE72958B4E88882F57D0164DCA2A6", hash_generated_field = "17BD452206B118EF58DBF7409BE6123E")

    private transient Set<SIPTransactionEventListener> eventListeners;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.695 -0400", hash_original_field = "D98A07F84921B24EE30F86FD8CD85C3C", hash_generated_field = "DEE2AF2482972910756C73DE5B8E2D10")

    protected From from;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.695 -0400", hash_original_field = "01B6E20344B68835C5ED1DDEDF20D531", hash_generated_field = "C448E6A4D656FF8991A12FB1F342B81A")

    protected To to;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.695 -0400", hash_original_field = "4119639092E62C55EA8BE348E4D9260D", hash_generated_field = "45474E5168B474ED8B347CB237DE65F5")

    protected Event event;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.696 -0400", hash_original_field = "0CD10A72F684313DCE7B6EF5F7F41411", hash_generated_field = "A097F8113589FE8B954AAE5C2A8185B4")

    protected CallID callId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.696 -0400", hash_original_field = "1B38361017A51E31457A871D3CC1FDE8", hash_generated_field = "6901AE467E2FAFDA07BDA528E126DAD1")

    protected int collectionTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.696 -0400", hash_original_field = "87ECE4FA02ED8396D6D6AB6F8D7024D9", hash_generated_field = "2548F380843EE93CEFA1182D7B7D4CAB")

    protected String toTag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.696 -0400", hash_original_field = "5DCBCDCA0B50FA4B705DBC416182E2D6", hash_generated_field = "2473B4AA5FDBB54683BF7F1A7022AFDB")

    protected String fromTag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.696 -0400", hash_original_field = "893B98AC1C2269A2499D4209F933A227", hash_generated_field = "A7AFFE900DA148C693A4DA5C908804C1")

    private boolean terminatedEventDelivered;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.698 -0400", hash_original_method = "5F08F1F6762C0D715B46AA0C57E5FACB", hash_generated_method = "507DFA64D167D2D1C4A77A984FABE7F2")
    protected  SIPTransaction(SIPTransactionStack newParentStack,
            MessageChannel newEncapsulatedChannel) {
        sipStack = newParentStack;
        this.semaphore = new Semaphore(1,true);
        encapsulatedChannel = newEncapsulatedChannel;
        this.peerPort = newEncapsulatedChannel.getPeerPort();
        this.peerAddress = newEncapsulatedChannel.getPeerAddress();
        this.peerInetAddress = newEncapsulatedChannel.getPeerInetAddress();
        this.peerPacketSourcePort = newEncapsulatedChannel
                .getPeerPacketSourcePort();
        this.peerPacketSourceAddress = newEncapsulatedChannel
                .getPeerPacketSourceAddress();
        this.peerProtocol = newEncapsulatedChannel.getPeerProtocol();
    if(this.isReliable())        
        {
            encapsulatedChannel.useCount++;
    if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger()
                            .logDebug("use count for encapsulated channel"
                                    + this
                                    + " "
                                    + encapsulatedChannel.useCount );
        } 
        this.currentState = null;
        disableRetransmissionTimer();
        disableTimeoutTimer();
        eventListeners = Collections.synchronizedSet(new HashSet<SIPTransactionEventListener>());
        addEventListener(newParentStack);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.698 -0400", hash_original_method = "F0D7866FE2BBCD680DCAF285C3141724", hash_generated_method = "1003754A692B316614D8C48861F56924")
    public String getBranchId() {
String var69A3716B085C70456FAF3B1C9676E91B_656478774 =         this.branch;
        var69A3716B085C70456FAF3B1C9676E91B_656478774.addTaint(taint);
        return var69A3716B085C70456FAF3B1C9676E91B_656478774;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.700 -0400", hash_original_method = "55609707D0B67BA3A76250F409DE303B", hash_generated_method = "5A3E7EB96C64D9DB1B9AB1F3F4E85EE7")
    public void setOriginalRequest(SIPRequest newOriginalRequest) {
        String newBranch;
    if(this.originalRequest != null
                && (!this.originalRequest.getTransactionId().equals(
                        newOriginalRequest.getTransactionId())))        
        {
            sipStack.removeTransactionHash(this);
        } 
        this.originalRequest = newOriginalRequest;
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
    if(newBranch != null)        
        {
    if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger().logDebug("Setting Branch id : " + newBranch);
            setBranch(newBranch);
        } 
        else
        {
    if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger().logDebug("Branch id is null - compute TID!"
                        + newOriginalRequest.encode());
            setBranch(newOriginalRequest.getTransactionId());
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.700 -0400", hash_original_method = "E55FA929D44B8592CC293995403E5C80", hash_generated_method = "BADA579881F10EEEC34BF22ECC3D0DFD")
    public SIPRequest getOriginalRequest() {
SIPRequest var7FF81808B66774D8E374586C7A341F2C_602509946 =         originalRequest;
        var7FF81808B66774D8E374586C7A341F2C_602509946.addTaint(taint);
        return var7FF81808B66774D8E374586C7A341F2C_602509946;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.701 -0400", hash_original_method = "77DF64C3C6C54874FB57EB6F51047938", hash_generated_method = "4EE01EB37E2D5E499C61F40EE514350C")
    public Request getRequest() {
Request varF614FFA205193AB2E8AFE9343B75956F_1299787282 =         (Request) originalRequest;
        varF614FFA205193AB2E8AFE9343B75956F_1299787282.addTaint(taint);
        return varF614FFA205193AB2E8AFE9343B75956F_1299787282;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.701 -0400", hash_original_method = "CD53B018E22B6706BBA3F591144F3E86", hash_generated_method = "0E73E9E78F14B98E21EBAEEEF0A3733B")
    public final boolean isInviteTransaction() {
        boolean var9A6FB6AB55AA7A248C78398863CF2F3A_1020441351 = (getMethod().equals(Request.INVITE));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1094654286 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1094654286;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.701 -0400", hash_original_method = "BF9744C1CDF47773C8154FC6D9BF750F", hash_generated_method = "1AE006B64A4313663EE8033B967A0C63")
    public final boolean isCancelTransaction() {
        boolean var5CDC2A8F8061D8E55663D4AF2A698FD3_737614196 = (getMethod().equals(Request.CANCEL));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1058388670 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1058388670;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.701 -0400", hash_original_method = "B590647CF4DDAA4D2D7D3928C46D70C5", hash_generated_method = "C4B59CED925A9BBA5534DF8ACEF673A8")
    public final boolean isByeTransaction() {
        boolean var0CAE690BE2135C15CA3915EE2F272311_1672409198 = (getMethod().equals(Request.BYE));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_699075587 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_699075587;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.702 -0400", hash_original_method = "4873376BBCB3E7C4172E860864FE5E6F", hash_generated_method = "A6E968F05C214C09DB384749EDDBAD54")
    public MessageChannel getMessageChannel() {
MessageChannel varFC3F15518836045A127AA85AF1C78C42_1326445267 =         encapsulatedChannel;
        varFC3F15518836045A127AA85AF1C78C42_1326445267.addTaint(taint);
        return varFC3F15518836045A127AA85AF1C78C42_1326445267;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.702 -0400", hash_original_method = "E1AAF4400C28181416F2CF35F703EDD4", hash_generated_method = "B52851A503E84EDC3613312ADF5BAF23")
    public final void setBranch(String newBranch) {
        branch = newBranch;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.702 -0400", hash_original_method = "8CF2A0009E9AA335F31D8DE930BE32FD", hash_generated_method = "F44093DE8B3569FFEF5158960DCFC217")
    public final String getBranch() {
    if(this.branch == null)        
        {
            this.branch = getOriginalRequest().getTopmostVia().getBranch();
        } 
String var4DEE8E9D853AF0A4DB110F1ED90CAF03_615388617 =         branch;
        var4DEE8E9D853AF0A4DB110F1ED90CAF03_615388617.addTaint(taint);
        return var4DEE8E9D853AF0A4DB110F1ED90CAF03_615388617;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.703 -0400", hash_original_method = "691C5451C67574E660997BC2056A5F23", hash_generated_method = "A81B150E79289168E0A4D732BA92603B")
    public final String getMethod() {
String varB88046C53AB584448F89DD952FF416E1_1588684636 =         this.method;
        varB88046C53AB584448F89DD952FF416E1_1588684636.addTaint(taint);
        return varB88046C53AB584448F89DD952FF416E1_1588684636;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.704 -0400", hash_original_method = "01D6A6E462A394F38C502658C03C7A92", hash_generated_method = "A8AE1A0BFDAC193066A34AD58422C42C")
    public final long getCSeq() {
        long var1D2AA36F1399F80D5F2A7D524DA3D8D0_1179143944 = (this.cSeq);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1641584807 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1641584807;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.705 -0400", hash_original_method = "A4A5B758CCC2E3BD812410810F0DBFFC", hash_generated_method = "C20A234623471E7B99BC43F6D79E6BB6")
    public void setState(TransactionState newState) {
    if(currentState == TransactionState.COMPLETED)        
        {
    if(newState != TransactionState.TERMINATED
                    && newState != TransactionState.CONFIRMED)            
            newState = TransactionState.COMPLETED;
        } 
    if(currentState == TransactionState.CONFIRMED)        
        {
    if(newState != TransactionState.TERMINATED)            
            newState = TransactionState.CONFIRMED;
        } 
    if(currentState != TransactionState.TERMINATED)        
        currentState = newState;
        else
        newState = currentState;
    if(sipStack.isLoggingEnabled())        
        {
            sipStack.getStackLogger().logDebug("Transaction:setState " + newState
                    + " " + this + " branchID = " + this.getBranch()
                    + " isClient = " + (this instanceof SIPClientTransaction));
            sipStack.getStackLogger().logStackTrace();
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.705 -0400", hash_original_method = "61525F5D630175E526789474B6CFB85F", hash_generated_method = "045E26C15EF53C4AD4ADD8A3FDA09E87")
    public TransactionState getState() {
TransactionState varE1BA4AD4226305F575CAC15460243810_661082123 =         this.currentState;
        varE1BA4AD4226305F575CAC15460243810_661082123.addTaint(taint);
        return varE1BA4AD4226305F575CAC15460243810_661082123;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.705 -0400", hash_original_method = "C06C644410B862B7DEB29308419E2C70", hash_generated_method = "6A4FF161C9F76B44F033C4156E4AA7D6")
    protected final void enableRetransmissionTimer() {
        enableRetransmissionTimer(1);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.706 -0400", hash_original_method = "69D842DACBECB66F6A3F4CBF6CAA3BE5", hash_generated_method = "484F527D146E23BABA30C9A6058562C1")
    protected final void enableRetransmissionTimer(int tickCount) {
    if(isInviteTransaction() && (this instanceof SIPClientTransaction))        
        {
            retransmissionTimerTicksLeft = tickCount;
        } 
        else
        {
            retransmissionTimerTicksLeft = Math.min(tickCount,
                    MAXIMUM_RETRANSMISSION_TICK_COUNT);
        } 
        retransmissionTimerLastTickCount = retransmissionTimerTicksLeft;
        
        
            
        
            
                    
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.707 -0400", hash_original_method = "7BF746AF9660DF3C6103C0B4973C1639", hash_generated_method = "2CD2716A8942EAD7668CFD177D09E769")
    protected final void disableRetransmissionTimer() {
        retransmissionTimerTicksLeft = -1;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.707 -0400", hash_original_method = "C532D8E297B37B97B54B6D70870D5AC1", hash_generated_method = "B92B528D9C4918D6AC5753AA34C06043")
    protected final void enableTimeoutTimer(int tickCount) {
    if(sipStack.isLoggingEnabled())        
        sipStack.getStackLogger().logDebug("enableTimeoutTimer " + this
                    + " tickCount " + tickCount + " currentTickCount = "
                    + timeoutTimerTicksLeft);
        timeoutTimerTicksLeft = tickCount;
        
        
            
                    
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.708 -0400", hash_original_method = "9098113579473A4D9B2DEEE12DBC58EA", hash_generated_method = "74EBCF06DC426C73AD0041D14DF3531F")
    protected final void disableTimeoutTimer() {
        timeoutTimerTicksLeft = -1;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.708 -0400", hash_original_method = "CB8F1BD04D54E1B61EA5D28A66348AD3", hash_generated_method = "C79035BE2AEA44B6782CA9EC67B65A42")
    final void fireTimer() {
    if(timeoutTimerTicksLeft != -1)        
        {
    if(--timeoutTimerTicksLeft == 0)            
            {
                fireTimeoutTimer();
            } 
        } 
    if(retransmissionTimerTicksLeft != -1)        
        {
    if(--retransmissionTimerTicksLeft == 0)            
            {
                enableRetransmissionTimer(retransmissionTimerLastTickCount * 2);
                fireRetransmissionTimer();
            } 
        } 
        
        
            
                
            
        
        
            
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.708 -0400", hash_original_method = "308D399F3CCDEFF33AA1ADAF72826036", hash_generated_method = "2C51494D7A29C0B3E099B67CA5AEF79C")
    public final boolean isTerminated() {
        boolean varE8863127B3D9714A38E10664668AABE4_1377570442 = (getState() == TERMINATED_STATE);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_452164184 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_452164184;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.709 -0400", hash_original_method = "DAE59CB64F6674AD8098A54E7D2B1281", hash_generated_method = "094388D3BD9F8621878922B67585799C")
    public String getHost() {
String var864F14088ECBEB1FDA2D03258D360174_902802132 =         encapsulatedChannel.getHost();
        var864F14088ECBEB1FDA2D03258D360174_902802132.addTaint(taint);
        return var864F14088ECBEB1FDA2D03258D360174_902802132;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.709 -0400", hash_original_method = "20977D5C5AB9D45A39447595F1157FC6", hash_generated_method = "504E7BCFF9C8B9AEBDB698B3ABF7FD11")
    public String getKey() {
String varC2B066D2FB913356E48D964B4CA9A184_180888715 =         encapsulatedChannel.getKey();
        varC2B066D2FB913356E48D964B4CA9A184_180888715.addTaint(taint);
        return varC2B066D2FB913356E48D964B4CA9A184_180888715;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.709 -0400", hash_original_method = "6EB6BE0A65CE407282FBCFAA26A62D3F", hash_generated_method = "CAAC43963632114D7C0A8A8CA7AD8AFB")
    public int getPort() {
        int varD4D0DB3B89AED76953C413E873753662_252858204 = (encapsulatedChannel.getPort());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1312658397 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1312658397;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.709 -0400", hash_original_method = "28698FFA104E0D8C500A173E95CB7CFA", hash_generated_method = "CB5A5EAB36F01FCE2C6DD96FC33F22D8")
    public SIPTransactionStack getSIPStack() {
SIPTransactionStack varC3086706AAFD4DEC749E55C425A3651C_337020924 =         (SIPTransactionStack) sipStack;
        varC3086706AAFD4DEC749E55C425A3651C_337020924.addTaint(taint);
        return varC3086706AAFD4DEC749E55C425A3651C_337020924;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.709 -0400", hash_original_method = "4D24925E393EE43229BBE6696196C496", hash_generated_method = "3B57A4A46E82C8031AF72A1AEC207B02")
    public String getPeerAddress() {
String varCB519CCE5105BD67F1450F075D5E971F_1696754573 =         this.peerAddress;
        varCB519CCE5105BD67F1450F075D5E971F_1696754573.addTaint(taint);
        return varCB519CCE5105BD67F1450F075D5E971F_1696754573;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.710 -0400", hash_original_method = "A1F90D00B31019C3C4E0EAACEB8565BB", hash_generated_method = "16464A09B0B514D2742E283264F22159")
    public int getPeerPort() {
        int var863AF973F56BABC8062C15431981E0EC_214185110 = (this.peerPort);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_249798177 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_249798177;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.710 -0400", hash_original_method = "D72195827AEF451FEF473FAF2B8F43B1", hash_generated_method = "D0AE5F31C522A8202B8BEEDBD9CB73CD")
    public int getPeerPacketSourcePort() {
        int varF37401B0701A173ADC9AD9A1C74CA6CF_951713790 = (this.peerPacketSourcePort);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1403845170 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1403845170;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.710 -0400", hash_original_method = "46454A41BD800FBE664B92E119C6A2FF", hash_generated_method = "55734912ABFAC9D08BC872354B3A6F75")
    public InetAddress getPeerPacketSourceAddress() {
InetAddress var145DD1539C40EFDAE410A2D0F2A0C504_1406283055 =         this.peerPacketSourceAddress;
        var145DD1539C40EFDAE410A2D0F2A0C504_1406283055.addTaint(taint);
        return var145DD1539C40EFDAE410A2D0F2A0C504_1406283055;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.710 -0400", hash_original_method = "DE04102C176E73364B597E64B8D5F233", hash_generated_method = "231D296C569C6B3433491DA593D91B91")
    protected InetAddress getPeerInetAddress() {
InetAddress var53B67B85CB3009CA655DC6D28631430D_1182296338 =         this.peerInetAddress;
        var53B67B85CB3009CA655DC6D28631430D_1182296338.addTaint(taint);
        return var53B67B85CB3009CA655DC6D28631430D_1182296338;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.711 -0400", hash_original_method = "DB79607DA3ACB5FA2D24428DF2713F98", hash_generated_method = "0AFBB9B2B7D0BB5BBD8D390C7CF3E883")
    protected String getPeerProtocol() {
String var6B5233BA3C9F99490638F3C0025EA1D3_1412435288 =         this.peerProtocol;
        var6B5233BA3C9F99490638F3C0025EA1D3_1412435288.addTaint(taint);
        return var6B5233BA3C9F99490638F3C0025EA1D3_1412435288;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.711 -0400", hash_original_method = "AEF0860991248E9299E1C6DDE1EF560C", hash_generated_method = "D8019370FDBE11D9C83C9B5A1FE47D1B")
    public String getTransport() {
String var8B69557C59C7CB5255C13E623A252A06_598799949 =         encapsulatedChannel.getTransport();
        var8B69557C59C7CB5255C13E623A252A06_598799949.addTaint(taint);
        return var8B69557C59C7CB5255C13E623A252A06_598799949;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.711 -0400", hash_original_method = "6845103B04473D4A2057FADE28E7D0AA", hash_generated_method = "F90CA791783E635820A6BEB0AF12F420")
    public boolean isReliable() {
        boolean var6BC65AD47B6615E8F9B74695272EF683_1403523637 = (encapsulatedChannel.isReliable());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1379185450 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1379185450;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.712 -0400", hash_original_method = "088E950799411477D094809B385ED56E", hash_generated_method = "679EE746FE1C8ABA39509C0CE8859AC1")
    public Via getViaHeader() {
        Via channelViaHeader;
        channelViaHeader = super.getViaHeader();
        try 
        {
            channelViaHeader.setBranch(branch);
        } 
        catch (java.text.ParseException ex)
        {
        } 
Via var35DB1238D58BA2159EC3B88E973131F6_273465652 =         channelViaHeader;
        var35DB1238D58BA2159EC3B88E973131F6_273465652.addTaint(taint);
        return var35DB1238D58BA2159EC3B88E973131F6_273465652;
        
        
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.712 -0400", hash_original_method = "937EBFADC181BFE1D9D7AD4237E3287B", hash_generated_method = "CA951E3974C9E074CA09C8C0C0DCCBEE")
    public void sendMessage(SIPMessage messageToSend) throws IOException {
        addTaint(messageToSend.getTaint());
        try 
        {
            encapsulatedChannel.sendMessage(messageToSend,
                    this.peerInetAddress, this.peerPort);
        } 
        finally 
        {
            this.startTransactionTimer();
        } 
        
        
            
                    
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.712 -0400", hash_original_method = "40115A27A95909E2CE679A790D4014C9", hash_generated_method = "006AE1867C6C4EF5B76D1CFBAAD581FB")
    protected void sendMessage(byte[] messageBytes,
            InetAddress receiverAddress, int receiverPort, boolean retry) throws IOException {
        addTaint(retry);
        addTaint(receiverPort);
        addTaint(receiverAddress.getTaint());
        addTaint(messageBytes[0]);
        IOException var978E8801774F204ABFF2D2025709EC28_182075072 = new IOException(
                "Cannot send unparsed message through Transaction Channel!");
        var978E8801774F204ABFF2D2025709EC28_182075072.addTaint(taint);
        throw var978E8801774F204ABFF2D2025709EC28_182075072;
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.713 -0400", hash_original_method = "72CEDACA72EC4BC352365F84C4504BD8", hash_generated_method = "F7DA09D11B48574FDE4EEA1B2F226036")
    public void addEventListener(SIPTransactionEventListener newListener) {
        addTaint(newListener.getTaint());
        eventListeners.add(newListener);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.713 -0400", hash_original_method = "668B9893C68F9233FC28CF7C4E017F56", hash_generated_method = "8A0A4CA151F40BD77FFCB93B0F30B953")
    public void removeEventListener(SIPTransactionEventListener oldListener) {
        addTaint(oldListener.getTaint());
        eventListeners.remove(oldListener);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.713 -0400", hash_original_method = "38D8606DEF077947D947856564D84874", hash_generated_method = "FB3E46969BC11E9DB17EFD0A1500F153")
    protected void raiseErrorEvent(int errorEventID) {
        addTaint(errorEventID);
        SIPTransactionErrorEvent newErrorEvent;
        Iterator<SIPTransactionEventListener> listenerIterator;
        SIPTransactionEventListener nextListener;
        newErrorEvent = new SIPTransactionErrorEvent(this, errorEventID);
        synchronized
(eventListeners)        {
            listenerIterator = eventListeners.iterator();
            while
(listenerIterator.hasNext())            
            {
                nextListener = (SIPTransactionEventListener) listenerIterator
                        .next();
                nextListener.transactionErrorEvent(newErrorEvent);
            } 
        } 
    if(errorEventID != SIPTransactionErrorEvent.TIMEOUT_RETRANSMIT)        
        {
            eventListeners.clear();
            this.setState(TransactionState.TERMINATED);
    if(this instanceof SIPServerTransaction && this.isByeTransaction()
                    && this.getDialog() != null)            
            ((SIPDialog) this.getDialog())
                        .setState(SIPDialog.TERMINATED_STATE);
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.714 -0400", hash_original_method = "1EC803C9686336CE6058D1F41391EBE2", hash_generated_method = "14031FB554515ACF5A82E44E2BA6234F")
    protected boolean isServerTransaction() {
        boolean varF21D7422016FBB38431136A45CBDC14A_1513147644 = (this instanceof SIPServerTransaction);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1830613061 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1830613061;
        
        
    }

    
    public abstract Dialog getDialog();

    
    public abstract void setDialog(SIPDialog sipDialog, String dialogId);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.715 -0400", hash_original_method = "A1D654E2B8EB18DBD9E2FBE3DBA84F3D", hash_generated_method = "8C649977F67D3C6CC944082059570A0C")
    public int getRetransmitTimer() {
        int var23AF80CFEDF2EFB10CEA3D98925EF8E2_175558545 = (SIPTransactionStack.BASE_TIMER_INTERVAL);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1291459565 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1291459565;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.715 -0400", hash_original_method = "310B5DE4F217FB57953AC74F889ED704", hash_generated_method = "6244069574E788F4FAAADB1CA1EDF16B")
    public String getViaHost() {
String var99724038DB83398E3D5CEBC24CC0D9D0_227407475 =         this.getViaHeader().getHost();
        var99724038DB83398E3D5CEBC24CC0D9D0_227407475.addTaint(taint);
        return var99724038DB83398E3D5CEBC24CC0D9D0_227407475;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.715 -0400", hash_original_method = "025E14F038A1EDFF743C73F970E03870", hash_generated_method = "EB4FD0FEEE53D10A75ECB989FC1D4EA8")
    public SIPResponse getLastResponse() {
SIPResponse varA8D04ABCC2F40254E91C4FADCF1C6CA4_1864456652 =         this.lastResponse;
        varA8D04ABCC2F40254E91C4FADCF1C6CA4_1864456652.addTaint(taint);
        return varA8D04ABCC2F40254E91C4FADCF1C6CA4_1864456652;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.715 -0400", hash_original_method = "260B447AD36FE2CA2411AAAD920B4F1F", hash_generated_method = "E0E79C40B439B16355DCC376E639BAF8")
    public Response getResponse() {
Response varA56E2CBF98C095DD5D844A74D343A37C_148698759 =         (Response) this.lastResponse;
        varA56E2CBF98C095DD5D844A74D343A37C_148698759.addTaint(taint);
        return varA56E2CBF98C095DD5D844A74D343A37C_148698759;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.716 -0400", hash_original_method = "AB08BB44F7439305FB61E3E9EFAC9224", hash_generated_method = "E7315FAB5EA6277D40B4D1F69C673502")
    public String getTransactionId() {
String varB269BC87F0BB8E052BA29C2E89E50CF0_1760989021 =         this.transactionId;
        varB269BC87F0BB8E052BA29C2E89E50CF0_1760989021.addTaint(taint);
        return varB269BC87F0BB8E052BA29C2E89E50CF0_1760989021;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.716 -0400", hash_original_method = "1EE454052F2EC55F5023F8455F33FFAA", hash_generated_method = "C576FCD7A698CB948536DD2A3F730085")
    public int hashCode() {
    if(this.transactionId == null)        
        {
        int var6BB61E3B7BCE0931DA574D19D1D82C88_499286133 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_516953161 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_516953161;
        }
        else
        {
        int varCD7F07E4E7B5C131E238FCFDBB6BC31B_1044266186 = (this.transactionId.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1537053966 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1537053966;
        }
        
        
            
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.716 -0400", hash_original_method = "F3BD37ECEE52D7438ECD340DC4DAF3CA", hash_generated_method = "20C94D05B2279622A2E7D06F25CE603A")
    public int getViaPort() {
        int var751F10FF5ADEFB4E2E0ADFBC5F5B6F1F_910859436 = (this.getViaHeader().getPort());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_853950605 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_853950605;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.717 -0400", hash_original_method = "4C1135E1FB3652D771084DD3A5E7B7E8", hash_generated_method = "2E8376FCD9A3E2E7A0D1FA9EC0F7D52C")
    public boolean doesCancelMatchTransaction(SIPRequest requestToTest) {
        addTaint(requestToTest.getTaint());
        ViaList viaHeaders;
        Via topViaHeader;
        String messageBranch;
        boolean transactionMatches;
        transactionMatches = false;
    if(this.getOriginalRequest() == null
                || this.getOriginalRequest().getMethod().equals(Request.CANCEL))        
        {
        boolean var68934A3E9455FA72420237EB05902327_2028984798 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2130426037 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2130426037;
        }
        viaHeaders = requestToTest.getViaHeaders();
    if(viaHeaders != null)        
        {
            topViaHeader = (Via) viaHeaders.getFirst();
            messageBranch = topViaHeader.getBranch();
    if(messageBranch != null)            
            {
    if(!messageBranch.toLowerCase().startsWith(SIPConstants.BRANCH_MAGIC_COOKIE_LOWER_CASE))                
                {
                    messageBranch = null;
                } 
            } 
    if(messageBranch != null && this.getBranch() != null)            
            {
    if(getBranch().equalsIgnoreCase(messageBranch)
                        && topViaHeader.getSentBy().equals(
                                ((Via) getOriginalRequest().getViaHeaders()
                                        .getFirst()).getSentBy()))                
                {
                    transactionMatches = true;
    if(sipStack.isLoggingEnabled())                    
                    sipStack.getStackLogger().logDebug("returning  true");
                } 
            } 
            else
            {
    if(sipStack.isLoggingEnabled())                
                sipStack.getStackLogger().logDebug("testing against "
                            + getOriginalRequest());
    if(getOriginalRequest().getRequestURI().equals(
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
                                .getViaHeaders().getFirst()))                
                {
                    transactionMatches = true;
                } 
            } 
        } 
    if(transactionMatches)        
        {
            this.setPassToListener();
        } 
        boolean var05E079BB3C0AA5EA1496AF660BBDEC18_1583262329 = (transactionMatches);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1305261669 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1305261669;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.718 -0400", hash_original_method = "348CFFAB37D4D83E29A04C573F3FF487", hash_generated_method = "E0083F212D7AD5B4E906CA4F7B01ADBF")
    public void setRetransmitTimer(int retransmitTimer) {
    if(retransmitTimer <= 0)        
        {
        IllegalArgumentException varF744BEBCEC48B05F83C2D7DEFA099A78_692455545 = new IllegalArgumentException(
                    "Retransmit timer must be positive!");
        varF744BEBCEC48B05F83C2D7DEFA099A78_692455545.addTaint(taint);
        throw varF744BEBCEC48B05F83C2D7DEFA099A78_692455545;
        }
    if(this.transactionTimerStarted.get())        
        {
        IllegalStateException var843C287CB485549732B728964D3B08A3_1960153406 = new IllegalStateException(
                    "Transaction timer is already started");
        var843C287CB485549732B728964D3B08A3_1960153406.addTaint(taint);
        throw var843C287CB485549732B728964D3B08A3_1960153406;
        }
        BASE_TIMER_INTERVAL = retransmitTimer;
        T4 = 5000 / BASE_TIMER_INTERVAL;
        T2 = 4000 / BASE_TIMER_INTERVAL;
        TIMER_I = T4;
        TIMER_K = T4;
        TIMER_D = 32000 / BASE_TIMER_INTERVAL;
        
        
            
                    
        
            
                    
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.719 -0400", hash_original_method = "45CE0F911469E288CC97776E84414496", hash_generated_method = "636468EE19CCA9967CE7500AA948D269")
    public void close() {
        this.encapsulatedChannel.close();
    if(sipStack.isLoggingEnabled())        
        sipStack.getStackLogger().logDebug("Closing " + this.encapsulatedChannel);
        
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.719 -0400", hash_original_method = "905D593C098EC8A0BB1DC95C9B54F441", hash_generated_method = "6A328A82937ABAECF6AFFEFA59FA3EB0")
    public boolean isSecure() {
        boolean var315EFD56B377C999C65AA81EC4AB2B71_674577146 = (encapsulatedChannel.isSecure());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1677401361 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1677401361;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.719 -0400", hash_original_method = "9C4DCEACA96616F074242810B487B970", hash_generated_method = "4515CDBA86A89C8AC0C5D51E4EF92A3E")
    public MessageProcessor getMessageProcessor() {
MessageProcessor var8E785A21492670B8A0B73E87233C6A82_1311778578 =         this.encapsulatedChannel.getMessageProcessor();
        var8E785A21492670B8A0B73E87233C6A82_1311778578.addTaint(taint);
        return var8E785A21492670B8A0B73E87233C6A82_1311778578;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.720 -0400", hash_original_method = "552E0456C33D24CD63C8EBCDAC1D019B", hash_generated_method = "E17DD994BC845C3BDBBD70ECC432242E")
    public void setApplicationData(Object applicationData) {
        this.applicationData = applicationData;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.720 -0400", hash_original_method = "5F924FC61375970A4DC758380BEBFF0F", hash_generated_method = "DBAF7B4DC79D2754EA3BE91A4E96C2D8")
    public Object getApplicationData() {
Object varAC81821DD38AD6A8C7609D7C76D213BC_1453475933 =         this.applicationData;
        varAC81821DD38AD6A8C7609D7C76D213BC_1453475933.addTaint(taint);
        return varAC81821DD38AD6A8C7609D7C76D213BC_1453475933;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.720 -0400", hash_original_method = "739B4CAA187BE9D487A452627B0424A2", hash_generated_method = "3E247DA8F2E347E80DAB817F941F23BE")
    public void setEncapsulatedChannel(MessageChannel messageChannel) {
        this.encapsulatedChannel = messageChannel;
        this.peerInetAddress = messageChannel.getPeerInetAddress();
        this.peerPort = messageChannel.getPeerPort();
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.721 -0400", hash_original_method = "38ECF920BD32EC6B95BB00C4AAD637BA", hash_generated_method = "B47AD4F81E12E631311F5D564C052317")
    public SipProviderImpl getSipProvider() {
SipProviderImpl var3225FCDEC68828DBDB22B9A45DB9B695_1089364232 =         this.getMessageProcessor().getListeningPoint().getProvider();
        var3225FCDEC68828DBDB22B9A45DB9B695_1089364232.addTaint(taint);
        return var3225FCDEC68828DBDB22B9A45DB9B695_1089364232;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.721 -0400", hash_original_method = "BA06BB4C0270C8B47C1CBBF5F94DA61A", hash_generated_method = "9D61886FD6672CD3972ACA9DAD63DF87")
    public void raiseIOExceptionEvent() {
        setState(TransactionState.TERMINATED);
        String host = getPeerAddress();
        int port = getPeerPort();
        String transport = getTransport();
        IOExceptionEvent exceptionEvent = new IOExceptionEvent(this, host,
                port, transport);
        getSipProvider().handleEvent(exceptionEvent, this);
        
        
        
        
        
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.722 -0400", hash_original_method = "9C758C929345C5BD5429DB309FDFD6EA", hash_generated_method = "9F21003A704736DBDED8AB6C1E9A4AC1")
    public boolean acquireSem() {
        boolean retval = false;
        try 
        {
    if(sipStack.getStackLogger().isLoggingEnabled())            
            {
                sipStack.getStackLogger().logDebug("acquireSem [[[[" + this);
                sipStack.getStackLogger().logStackTrace();
            } 
            retval = this.semaphore.tryAcquire(1000, TimeUnit.MILLISECONDS);
    if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger().logDebug(
                    "acquireSem() returning : " + retval);
            boolean var020B759ADEF679A47CB9AFE965BB2314_1124090818 = (retval);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1944316656 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1944316656;
        } 
        catch (Exception ex)
        {
            sipStack.getStackLogger().logError("Unexpected exception acquiring sem",
                    ex);
            InternalErrorHandler.handleException(ex);
            boolean var68934A3E9455FA72420237EB05902327_1664186781 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_136471118 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_136471118;
        } 
        finally 
        {
            this.isSemaphoreAquired = retval;
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.722 -0400", hash_original_method = "301846C685CE876D86A6B4185A591E30", hash_generated_method = "2E46BBF6796C78AED74045C8C40488CD")
    public void releaseSem() {
        try 
        {
            this.toListener = false;
            this.semRelease();
        } 
        catch (Exception ex)
        {
            sipStack.getStackLogger().logError("Unexpected exception releasing sem",
                    ex);
        } 
        
        
            
            
        
            
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.722 -0400", hash_original_method = "DBC24F6DB4FEFD7D7F8639708567DC35", hash_generated_method = "9B9FF00E79E2C1EE719897C9B447EE3E")
    protected void semRelease() {
        try 
        {
    if(sipStack.isLoggingEnabled())            
            {
                sipStack.getStackLogger().logDebug("semRelease ]]]]" + this);
                sipStack.getStackLogger().logStackTrace();
            } 
            this.isSemaphoreAquired = false;
            this.semaphore.release();
        } 
        catch (Exception ex)
        {
            sipStack.getStackLogger().logError("Unexpected exception releasing sem",
                    ex);
        } 
        
        
            
                
                
            
            
            
        
            
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.722 -0400", hash_original_method = "39E9029186E8CC55AF8CBCC68EB9597C", hash_generated_method = "F5206D0381BA1368F9DDAED7915D5CA1")
    public boolean passToListener() {
        boolean var2B259185198C3F8BF792A605A14004E6_171310506 = (toListener);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_66247111 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_66247111;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.723 -0400", hash_original_method = "F5F4C78B3DFF0EDA40F4B14C1017F836", hash_generated_method = "78D7C2BAA127E2686A9C674E323257B4")
    public void setPassToListener() {
    if(sipStack.isLoggingEnabled())        
        {
            sipStack.getStackLogger().logDebug("setPassToListener()");
        } 
        this.toListener = true;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.723 -0400", hash_original_method = "5D50ECFAFAF878A5B29EF8C830BE2C71", hash_generated_method = "4264A3F83DE63E2AF83FC33F18E1B5B0")
    protected synchronized boolean testAndSetTransactionTerminatedEvent() {
        boolean retval = !this.terminatedEventDelivered;
        this.terminatedEventDelivered = true;
        boolean var020B759ADEF679A47CB9AFE965BB2314_917991896 = (retval);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1663692172 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1663692172;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.723 -0400", hash_original_method = "0D2015A100DFE7954256C577DAEBD143", hash_generated_method = "88B3F02EAAC8FEE0028994BF966DC972")
    public String getCipherSuite() throws UnsupportedOperationException {
    if(this.getMessageChannel() instanceof TLSMessageChannel)        
        {
    if(((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener() == null)            
            {
String var540C13E9E156B687226421B24F2DF178_962213241 =             null;
            var540C13E9E156B687226421B24F2DF178_962213241.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_962213241;
            }
            else
    if(((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener().getHandshakeCompletedEvent() == null)            
            {
String var540C13E9E156B687226421B24F2DF178_1936400164 =             null;
            var540C13E9E156B687226421B24F2DF178_1936400164.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1936400164;
            }
            else
            {
String var0F8063DAA649B506FBB1129D8593BD3D_1690445619 =             ((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener().getHandshakeCompletedEvent().getCipherSuite();
            var0F8063DAA649B506FBB1129D8593BD3D_1690445619.addTaint(taint);
            return var0F8063DAA649B506FBB1129D8593BD3D_1690445619;
            }
        } 
        else
        {
        UnsupportedOperationException varA298B7FD3DBD04C14E07FE112796BA7B_619040029 = new UnsupportedOperationException("Not a TLS channel");
        varA298B7FD3DBD04C14E07FE112796BA7B_619040029.addTaint(taint);
        throw varA298B7FD3DBD04C14E07FE112796BA7B_619040029;
        }
        
        
            
                
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.724 -0400", hash_original_method = "1BD353D03C47A7F0291FB8AF92EA1899", hash_generated_method = "60010E0194BDF5E4B3815D92BFC5101F")
    public java.security.cert.Certificate[] getLocalCertificates() throws UnsupportedOperationException {
    if(this.getMessageChannel() instanceof TLSMessageChannel)        
        {
    if(((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener() == null)            
            {
java.security.cert.Certificate[] var540C13E9E156B687226421B24F2DF178_1295263026 =             null;
            var540C13E9E156B687226421B24F2DF178_1295263026.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1295263026;
            }
            else
    if(((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener().getHandshakeCompletedEvent() == null)            
            {
java.security.cert.Certificate[] var540C13E9E156B687226421B24F2DF178_256143510 =             null;
            var540C13E9E156B687226421B24F2DF178_256143510.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_256143510;
            }
            else
            {
java.security.cert.Certificate[] var6376468DB45EDFCA476E9DCC32DF9FD6_505721492 =             ((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener().getHandshakeCompletedEvent().getLocalCertificates();
            var6376468DB45EDFCA476E9DCC32DF9FD6_505721492.addTaint(taint);
            return var6376468DB45EDFCA476E9DCC32DF9FD6_505721492;
            }
        } 
        else
        {
        UnsupportedOperationException varA298B7FD3DBD04C14E07FE112796BA7B_386290561 = new UnsupportedOperationException("Not a TLS channel");
        varA298B7FD3DBD04C14E07FE112796BA7B_386290561.addTaint(taint);
        throw varA298B7FD3DBD04C14E07FE112796BA7B_386290561;
        }
        
        
            
                
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.724 -0400", hash_original_method = "425975E25339AF497E9130895A1F6EC3", hash_generated_method = "06662C4F0BB5EA6352099F160D15343D")
    public java.security.cert.Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
    if(this.getMessageChannel() instanceof TLSMessageChannel)        
        {
    if(((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener() == null)            
            {
java.security.cert.Certificate[] var540C13E9E156B687226421B24F2DF178_342549534 =             null;
            var540C13E9E156B687226421B24F2DF178_342549534.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_342549534;
            }
            else
    if(((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener().getHandshakeCompletedEvent() == null)            
            {
java.security.cert.Certificate[] var540C13E9E156B687226421B24F2DF178_710485304 =             null;
            var540C13E9E156B687226421B24F2DF178_710485304.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_710485304;
            }
            else
            {
java.security.cert.Certificate[] varA18727BD0A08AB36BEAE20E808F1D430_1007331770 =             ((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener().getHandshakeCompletedEvent().getPeerCertificates();
            varA18727BD0A08AB36BEAE20E808F1D430_1007331770.addTaint(taint);
            return varA18727BD0A08AB36BEAE20E808F1D430_1007331770;
            }
        } 
        else
        {
        UnsupportedOperationException varA298B7FD3DBD04C14E07FE112796BA7B_1417414109 = new UnsupportedOperationException("Not a TLS channel");
        varA298B7FD3DBD04C14E07FE112796BA7B_1417414109.addTaint(taint);
        throw varA298B7FD3DBD04C14E07FE112796BA7B_1417414109;
        }
        
        
            
                
            
                
            
        
    }

    
    protected abstract void startTransactionTimer();

    
    public abstract boolean isMessagePartOfTransaction(SIPMessage messageToTest);

    
    protected abstract void fireRetransmissionTimer();

    
    protected abstract void fireTimeoutTimer();

    
    class LingerTimer extends SIPStackTimerTask {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.725 -0400", hash_original_method = "4F6152921EA187210C4EA8258CD889E1", hash_generated_method = "3C849E6E8703439A4E962F07A2EC3DF4")
        public  LingerTimer() {
            SIPTransaction sipTransaction = SIPTransaction.this;
    if(sipStack.isLoggingEnabled())            
            {
                sipStack.getStackLogger().logDebug("LingerTimer : "
                        + sipTransaction.getTransactionId());
            } 
            
            
            
                
                        
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.726 -0400", hash_original_method = "14B41A6E0BE7E84E900DADE7EB6E3A9A", hash_generated_method = "0C253FD0E6C3B311B4F43D2ABDD28E37")
        protected void runTask() {
            SIPTransaction transaction = SIPTransaction.this;
            SIPTransactionStack sipStack = transaction.getSIPStack();
    if(sipStack.isLoggingEnabled())            
            {
                sipStack.getStackLogger().logDebug("LingerTimer: run() : "
                        + getTransactionId());
            } 
    if(transaction instanceof SIPClientTransaction)            
            {
                sipStack.removeTransaction(transaction);
                transaction.close();
            } 
            else
    if(transaction instanceof ServerTransaction)            
            {
    if(sipStack.isLoggingEnabled())                
                sipStack.getStackLogger().logDebug("removing" + transaction);
                sipStack.removeTransaction(transaction);
    if((!sipStack.cacheServerConnections)
                        && --transaction.encapsulatedChannel.useCount <= 0)                
                {
                    transaction.close();
                } 
                else
                {
    if(sipStack.isLoggingEnabled()
                            && (!sipStack.cacheServerConnections)
                            && transaction.isReliable())                    
                    {
                        int useCount = transaction.encapsulatedChannel.useCount;
                        sipStack.getStackLogger().logDebug("Use Count = " + useCount);
                    } 
                } 
            } 
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.727 -0400", hash_original_field = "A416A668043B482EFC2F2325D3EC1153", hash_generated_field = "ACC922C0E49053B414BC2B207C435038")

    protected static final int T1 = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.727 -0400", hash_original_field = "41507773B89CE446DCAC23DD50F37819", hash_generated_field = "7E2D9869BDB9045700E8D821F4588BDF")

    protected static final int TIMER_A = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.727 -0400", hash_original_field = "C712D1D637F4061683A4B32D6EF6874E", hash_generated_field = "93B7D7F2080EBBB3787D866882928B33")

    protected static final int TIMER_B = 64;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.727 -0400", hash_original_field = "06269F326966D3ACA4950A4B6EE7EA0B", hash_generated_field = "C6478F3FDDFCC7A5866A29DA158AC357")

    protected static final int TIMER_J = 64;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.727 -0400", hash_original_field = "51D1F67E03F85531F794EFC17953564E", hash_generated_field = "A9B44A5318402784FF69AC6DA430A9D6")

    protected static final int TIMER_F = 64;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.727 -0400", hash_original_field = "5DA06C034F975ABA139B09C72EAD0872", hash_generated_field = "3DE8E426A4F01136C7ECA20307DAE43A")

    protected static final int TIMER_H = 64;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.727 -0400", hash_original_field = "CC18DC3FB7CE731BAD3934F245CE3454", hash_generated_field = "8BA3A0ADBD6ABEEE2C128AA938AC9DE1")

    public static final TransactionState INITIAL_STATE = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.727 -0400", hash_original_field = "9226F430E079BC77D0322347132C7EE8", hash_generated_field = "D317B7F0EDCFF7869AC099F8F60A26C5")

    public static final TransactionState TRYING_STATE = TransactionState.TRYING;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.728 -0400", hash_original_field = "558B4EE8481E9F9FC0DAA8CB1CA500C8", hash_generated_field = "7694E1BD134F3AABB468EB52BEB662A9")

    public static final TransactionState CALLING_STATE = TransactionState.CALLING;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.728 -0400", hash_original_field = "2182728F7F14AB8E9B791431AC114DA8", hash_generated_field = "06F5AD8C442768658EEA785254674FFF")

    public static final TransactionState PROCEEDING_STATE = TransactionState.PROCEEDING;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.728 -0400", hash_original_field = "044D7AD2DD976AB03066B86B5AD02515", hash_generated_field = "F0F4AEFF89B151D97D57677046A3B234")

    public static final TransactionState COMPLETED_STATE = TransactionState.COMPLETED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.728 -0400", hash_original_field = "4A6DD65DC912AE7BAD7804C7F87D3681", hash_generated_field = "EBCB27C78436E501BBCA8D4CD1A806C2")

    public static final TransactionState CONFIRMED_STATE = TransactionState.CONFIRMED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.728 -0400", hash_original_field = "1D290254DA712EE27D9F5047A872DF10", hash_generated_field = "B19BF2F78FE0062DCD29ACB945A7A8B5")

    public static final TransactionState TERMINATED_STATE = TransactionState.TERMINATED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.728 -0400", hash_original_field = "C031D221A72791D98EF5BFC8F90FBED8", hash_generated_field = "F8F7C8DEA67FC9F18B9E1E40A34E4804")

    protected static final int MAXIMUM_RETRANSMISSION_TICK_COUNT = 8;
}

