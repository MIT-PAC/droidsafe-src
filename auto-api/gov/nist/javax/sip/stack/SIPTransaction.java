package gov.nist.javax.sip.stack;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.244 -0400", hash_original_field = "2B259185198C3F8BF792A605A14004E6", hash_generated_field = "E1D4E9B3AAF496FD813808775B58AFF8")

    protected boolean toListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.244 -0400", hash_original_field = "87903C91D979BEB4E00BBC5332AAE689", hash_generated_field = "9A93D89EE79003352C54A76D4BCBEF57")

    protected int BASE_TIMER_INTERVAL = SIPTransactionStack.BASE_TIMER_INTERVAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.244 -0400", hash_original_field = "47E14B32BBE9F9DF68D573CACFC16149", hash_generated_field = "AFFFDDF9E03C18C4462622216D1D744E")

    protected int T4 = 5000 / BASE_TIMER_INTERVAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.244 -0400", hash_original_field = "61039199CF671E979441018417D7D597", hash_generated_field = "5AB93F413E7E37621B4D5A565BACE4EE")

    protected int T2 = 4000 / BASE_TIMER_INTERVAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.244 -0400", hash_original_field = "B70CAA4CBFD6EE4F02C591E86E116069", hash_generated_field = "9F72081078574EE44AD3339670F6DF1F")

    protected int TIMER_I = T4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.244 -0400", hash_original_field = "F1B52E1E5C59167765233838AC175899", hash_generated_field = "CA8408AC31A4B160960A20C24156B7EC")

    protected int TIMER_K = T4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.244 -0400", hash_original_field = "A6B23354CA0D6C4DAE6F5E622B535F0B", hash_generated_field = "46098F3DF9CF80FB6A2FF1FF700C1E30")

    protected int TIMER_D = 32000 / BASE_TIMER_INTERVAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.244 -0400", hash_original_field = "756C73A51ADF7F04942C8BE97A032000", hash_generated_field = "B1A8E011179EF40B9DAC21E1148B1B78")

    protected transient Object applicationData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.244 -0400", hash_original_field = "9ECD142FA67835EFBFD693D2B0EFC756", hash_generated_field = "8CE24F874A42F410B23EF4851613017C")

    protected SIPResponse lastResponse;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.244 -0400", hash_original_field = "66CA6208A29137D8034ED70E634A1646", hash_generated_field = "77FEBEAA4AF79617A8B0CBB244F26247")

    protected boolean isMapped;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.244 -0400", hash_original_field = "CE1BC7755B9332CFACDF8EE58EF2E3C1", hash_generated_field = "3F41BA6F3B911D0AFE0A127EF365871F")

    private Semaphore semaphore;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.244 -0400", hash_original_field = "24776DD7C271F7EB52082A8DF20FE6A6", hash_generated_field = "30E9188AD86CBF24A584DD99B37E6A4C")

    protected boolean isSemaphoreAquired;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.244 -0400", hash_original_field = "671139EDEB98807421E35E63D9C29A6A", hash_generated_field = "9C238CB346335F1D207FF4BBD6C9DEAD")

    protected String transactionId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.244 -0400", hash_original_field = "C0CEB3515CA4F46A6B2A58F9563A8976", hash_generated_field = "671A9D7640781DBA64AF5A5BAE3E2701")

    public long auditTag = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.244 -0400", hash_original_field = "37460D4BF2BA47A13FF9D922C4B14B2E", hash_generated_field = "4664B9159D27EBBF3CF109F118F56F46")

    protected transient SIPTransactionStack sipStack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.244 -0400", hash_original_field = "539F42CD378873BB0F9889EFF317BAFA", hash_generated_field = "E987B06AF0DFCAA9F38DD607A12D9B39")

    protected SIPRequest originalRequest;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.244 -0400", hash_original_field = "809A0AB6067FCFE0AB1E4C7E2ED026AA", hash_generated_field = "25DB028ECDD75BE4977DFE05FC00F4D2")

    private transient MessageChannel encapsulatedChannel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.244 -0400", hash_original_field = "BBD5741C4F9994864582D25DD194C4DE", hash_generated_field = "6A69B321E52130622ADD35A2A3F00BA6")

    protected int peerPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.244 -0400", hash_original_field = "D5A8CA55B131A89C25E3C0595C953BCA", hash_generated_field = "ACA9646C167AB8988D8D4678A1C02262")

    protected InetAddress peerInetAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.244 -0400", hash_original_field = "D7FA5E7DC9BACC5016B81E35D44D1C5F", hash_generated_field = "C9738122113DFDEEF725F74B583F0EE7")

    protected String peerAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.244 -0400", hash_original_field = "EDB6E8FD971C3E6879E1A00995BCB702", hash_generated_field = "FBF73E4EC3FC246E9E63B41E9D9708E4")

    protected String peerProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.244 -0400", hash_original_field = "E2843BEFA12DEA2BD46F0D29DAA8CB35", hash_generated_field = "A5A71425C21DF932789F3BE8BFE8101E")

    protected int peerPacketSourcePort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.244 -0400", hash_original_field = "1906DDE6FBF1A1A564E69A91EBCF4043", hash_generated_field = "AA48B9901BA1D417BEAE6C24D398429E")

    protected InetAddress peerPacketSourceAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.244 -0400", hash_original_field = "95ED6E6B932BB90F37EB8D409DC725E0", hash_generated_field = "C48464462DE8239144ADA7BDEA8A5336")

    protected AtomicBoolean transactionTimerStarted = new AtomicBoolean(false);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.244 -0400", hash_original_field = "9603A224B40D7B67210B78F2E390D00F", hash_generated_field = "30E846F477E8815819D75224F8F894EA")

    private String branch;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.244 -0400", hash_original_field = "EA9F6ACA279138C58F705C8D4CB4B8CE", hash_generated_field = "F42F15CDE806BBAD7F26F7952D68FCE2")

    private String method;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.244 -0400", hash_original_field = "518FD2362F5A4BA10EAEF07A78FCCE98", hash_generated_field = "42D60DCE07190569B4FB5DBAE96EB838")

    private long cSeq;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.244 -0400", hash_original_field = "542734C7E65EC6932E6AE354B2B7DB76", hash_generated_field = "1D3A2129BFAA64E672459DABFB968979")

    private TransactionState currentState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.244 -0400", hash_original_field = "C18186E6A18F0688FA3C41006C8B7690", hash_generated_field = "E635400649257FF3CB3C8321A25A9521")

    private transient int retransmissionTimerLastTickCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.244 -0400", hash_original_field = "734EA45E3F7351452921A4A8AADED8B9", hash_generated_field = "91834647ACD706C1011839DD85835F02")

    private transient int retransmissionTimerTicksLeft;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.244 -0400", hash_original_field = "C06879E46D091BA209F56764D4F2F7AE", hash_generated_field = "3CE5B548E56A9CACC294CED8BA31ABAA")

    protected int timeoutTimerTicksLeft;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.244 -0400", hash_original_field = "FEAAE72958B4E88882F57D0164DCA2A6", hash_generated_field = "17BD452206B118EF58DBF7409BE6123E")

    private transient Set<SIPTransactionEventListener> eventListeners;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.244 -0400", hash_original_field = "D98A07F84921B24EE30F86FD8CD85C3C", hash_generated_field = "DEE2AF2482972910756C73DE5B8E2D10")

    protected From from;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.244 -0400", hash_original_field = "01B6E20344B68835C5ED1DDEDF20D531", hash_generated_field = "C448E6A4D656FF8991A12FB1F342B81A")

    protected To to;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.244 -0400", hash_original_field = "4119639092E62C55EA8BE348E4D9260D", hash_generated_field = "45474E5168B474ED8B347CB237DE65F5")

    protected Event event;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.244 -0400", hash_original_field = "0CD10A72F684313DCE7B6EF5F7F41411", hash_generated_field = "A097F8113589FE8B954AAE5C2A8185B4")

    protected CallID callId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.244 -0400", hash_original_field = "1B38361017A51E31457A871D3CC1FDE8", hash_generated_field = "6901AE467E2FAFDA07BDA528E126DAD1")

    protected int collectionTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.244 -0400", hash_original_field = "87ECE4FA02ED8396D6D6AB6F8D7024D9", hash_generated_field = "2548F380843EE93CEFA1182D7B7D4CAB")

    protected String toTag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.244 -0400", hash_original_field = "5DCBCDCA0B50FA4B705DBC416182E2D6", hash_generated_field = "2473B4AA5FDBB54683BF7F1A7022AFDB")

    protected String fromTag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.244 -0400", hash_original_field = "893B98AC1C2269A2499D4209F933A227", hash_generated_field = "A7AFFE900DA148C693A4DA5C908804C1")

    private boolean terminatedEventDelivered;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.246 -0400", hash_original_method = "5F08F1F6762C0D715B46AA0C57E5FACB", hash_generated_method = "D18FD62C5163E617409A8D0B2F0C8931")
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
        {
            boolean varDFC5BF10E00B4CEC32C670E55EF86009_1968620004 = (this.isReliable());
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_294742581 = (sipStack.isLoggingEnabled());
                    sipStack.getStackLogger()
                            .logDebug("use count for encapsulated channel"
                                    + this
                                    + " "
                                    + encapsulatedChannel.useCount );
                } 
            } 
        } 
        this.currentState = null;
        disableRetransmissionTimer();
        disableTimeoutTimer();
        eventListeners = Collections.synchronizedSet(new HashSet<SIPTransactionEventListener>());
        addEventListener(newParentStack);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.246 -0400", hash_original_method = "F0D7866FE2BBCD680DCAF285C3141724", hash_generated_method = "673E640403866E34F38453D9F99CE685")
    public String getBranchId() {
        String varB4EAC82CA7396A68D541C85D26508E83_488245193 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_488245193 = this.branch;
        varB4EAC82CA7396A68D541C85D26508E83_488245193.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_488245193;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.247 -0400", hash_original_method = "55609707D0B67BA3A76250F409DE303B", hash_generated_method = "DE4AE5B18544C4D7C76237F4FCD7EB25")
    public void setOriginalRequest(SIPRequest newOriginalRequest) {
        String newBranch;
        {
            boolean varED20A49E7D8795E663FD7E52527B4B8C_1787261204 = (this.originalRequest != null
                && (!this.originalRequest.getTransactionId().equals(
                        newOriginalRequest.getTransactionId())));
            {
                sipStack.removeTransactionHash(this);
            } 
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
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_345590676 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug("Setting Branch id : " + newBranch);
            } 
            setBranch(newBranch);
        } 
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1076886878 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug("Branch id is null - compute TID!"
                        + newOriginalRequest.encode());
            } 
            setBranch(newOriginalRequest.getTransactionId());
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.248 -0400", hash_original_method = "E55FA929D44B8592CC293995403E5C80", hash_generated_method = "BBAC27CD1F2417600427FEFC52BECE7D")
    public SIPRequest getOriginalRequest() {
        SIPRequest varB4EAC82CA7396A68D541C85D26508E83_881085297 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_881085297 = originalRequest;
        varB4EAC82CA7396A68D541C85D26508E83_881085297.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_881085297;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.249 -0400", hash_original_method = "77DF64C3C6C54874FB57EB6F51047938", hash_generated_method = "AE8974DC82A1D2BDB105FB18F7F651D7")
    public Request getRequest() {
        Request varB4EAC82CA7396A68D541C85D26508E83_1857789013 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1857789013 = (Request) originalRequest;
        varB4EAC82CA7396A68D541C85D26508E83_1857789013.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1857789013;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.249 -0400", hash_original_method = "CD53B018E22B6706BBA3F591144F3E86", hash_generated_method = "DD94F42F4759C6CFB08BEE58824D5079")
    public final boolean isInviteTransaction() {
        boolean varF00C6BE92A0E41FAF82C4342626E2262_356834172 = (getMethod().equals(Request.INVITE));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1668950876 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1668950876;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.250 -0400", hash_original_method = "BF9744C1CDF47773C8154FC6D9BF750F", hash_generated_method = "415EB768DC4FCEDF3DDC1337C4BAF4F6")
    public final boolean isCancelTransaction() {
        boolean varF09126792D15B60E02E36B5E7F24788C_932948903 = (getMethod().equals(Request.CANCEL));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1651527156 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1651527156;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.250 -0400", hash_original_method = "B590647CF4DDAA4D2D7D3928C46D70C5", hash_generated_method = "3386CF11E02654750D2846366543086E")
    public final boolean isByeTransaction() {
        boolean var6E30B2E86E105ADB2706B05016297A15_1264169322 = (getMethod().equals(Request.BYE));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_775219124 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_775219124;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.251 -0400", hash_original_method = "4873376BBCB3E7C4172E860864FE5E6F", hash_generated_method = "33F6D2F6FD8C69D7204514C137578BC8")
    public MessageChannel getMessageChannel() {
        MessageChannel varB4EAC82CA7396A68D541C85D26508E83_597850450 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_597850450 = encapsulatedChannel;
        varB4EAC82CA7396A68D541C85D26508E83_597850450.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_597850450;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.251 -0400", hash_original_method = "E1AAF4400C28181416F2CF35F703EDD4", hash_generated_method = "B52851A503E84EDC3613312ADF5BAF23")
    public final void setBranch(String newBranch) {
        branch = newBranch;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.252 -0400", hash_original_method = "8CF2A0009E9AA335F31D8DE930BE32FD", hash_generated_method = "DB00777C2C24A946523A548DC4460A6C")
    public final String getBranch() {
        String varB4EAC82CA7396A68D541C85D26508E83_1553190188 = null; 
        {
            this.branch = getOriginalRequest().getTopmostVia().getBranch();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1553190188 = branch;
        varB4EAC82CA7396A68D541C85D26508E83_1553190188.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1553190188;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.253 -0400", hash_original_method = "691C5451C67574E660997BC2056A5F23", hash_generated_method = "66A12369F9B29AFC7CF343E03C99ACC2")
    public final String getMethod() {
        String varB4EAC82CA7396A68D541C85D26508E83_1949991163 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1949991163 = this.method;
        varB4EAC82CA7396A68D541C85D26508E83_1949991163.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1949991163;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.254 -0400", hash_original_method = "01D6A6E462A394F38C502658C03C7A92", hash_generated_method = "EBEBCB4EE4EA2DD47AF38E6F291AD338")
    public final long getCSeq() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_673216614 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_673216614;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.255 -0400", hash_original_method = "A4A5B758CCC2E3BD812410810F0DBFFC", hash_generated_method = "2918C6BA8B0252D35B708752D8700CDE")
    public void setState(TransactionState newState) {
        {
            newState = TransactionState.COMPLETED;
        } 
        {
            newState = TransactionState.CONFIRMED;
        } 
        currentState = newState;
        newState = currentState;
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1663597092 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("Transaction:setState " + newState
                    + " " + this + " branchID = " + this.getBranch()
                    + " isClient = " + (this instanceof SIPClientTransaction));
                sipStack.getStackLogger().logStackTrace();
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.256 -0400", hash_original_method = "61525F5D630175E526789474B6CFB85F", hash_generated_method = "6F819ECA79CA2441CF08A4F866168302")
    public TransactionState getState() {
        TransactionState varB4EAC82CA7396A68D541C85D26508E83_1780714913 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1780714913 = this.currentState;
        varB4EAC82CA7396A68D541C85D26508E83_1780714913.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1780714913;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.256 -0400", hash_original_method = "C06C644410B862B7DEB29308419E2C70", hash_generated_method = "6A4FF161C9F76B44F033C4156E4AA7D6")
    protected final void enableRetransmissionTimer() {
        enableRetransmissionTimer(1);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.257 -0400", hash_original_method = "69D842DACBECB66F6A3F4CBF6CAA3BE5", hash_generated_method = "AC3D0CB6BA561E85D3644F6190091C47")
    protected final void enableRetransmissionTimer(int tickCount) {
        {
            boolean varF0C28EC8C9F15D61EF70697CCCF4EF42_1690021303 = (isInviteTransaction() && (this instanceof SIPClientTransaction));
            {
                retransmissionTimerTicksLeft = tickCount;
            } 
            {
                retransmissionTimerTicksLeft = Math.min(tickCount,
                    MAXIMUM_RETRANSMISSION_TICK_COUNT);
            } 
        } 
        retransmissionTimerLastTickCount = retransmissionTimerTicksLeft;
        
        
            
        
            
                    
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.257 -0400", hash_original_method = "7BF746AF9660DF3C6103C0B4973C1639", hash_generated_method = "2CD2716A8942EAD7668CFD177D09E769")
    protected final void disableRetransmissionTimer() {
        retransmissionTimerTicksLeft = -1;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.258 -0400", hash_original_method = "C532D8E297B37B97B54B6D70870D5AC1", hash_generated_method = "E4FF686C719D9AFC5DC7B893ECCAF7DD")
    protected final void enableTimeoutTimer(int tickCount) {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1925332794 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug("enableTimeoutTimer " + this
                    + " tickCount " + tickCount + " currentTickCount = "
                    + timeoutTimerTicksLeft);
        } 
        timeoutTimerTicksLeft = tickCount;
        
        
            
                    
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.259 -0400", hash_original_method = "9098113579473A4D9B2DEEE12DBC58EA", hash_generated_method = "74EBCF06DC426C73AD0041D14DF3531F")
    protected final void disableTimeoutTimer() {
        timeoutTimerTicksLeft = -1;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.260 -0400", hash_original_method = "CB8F1BD04D54E1B61EA5D28A66348AD3", hash_generated_method = "2D83B18146246D98BFA584B5E41EB2B4")
    final void fireTimer() {
        {
            {
                fireTimeoutTimer();
            } 
        } 
        {
            {
                enableRetransmissionTimer(retransmissionTimerLastTickCount * 2);
                fireRetransmissionTimer();
            } 
        } 
        
        
            
                
            
        
        
            
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.262 -0400", hash_original_method = "308D399F3CCDEFF33AA1ADAF72826036", hash_generated_method = "E59BBA47B87802489D445B75DF6B7208")
    public final boolean isTerminated() {
        boolean var7BB039B32C96C37D7F86735250612D70_1576956081 = (getState() == TERMINATED_STATE);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1931158548 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1931158548;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.264 -0400", hash_original_method = "DAE59CB64F6674AD8098A54E7D2B1281", hash_generated_method = "03A76E59600C19DD135B36160CA861B3")
    public String getHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_117715501 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_117715501 = encapsulatedChannel.getHost();
        varB4EAC82CA7396A68D541C85D26508E83_117715501.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_117715501;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.265 -0400", hash_original_method = "20977D5C5AB9D45A39447595F1157FC6", hash_generated_method = "B398D680899C62A0F2974BAB89631462")
    public String getKey() {
        String varB4EAC82CA7396A68D541C85D26508E83_1831737592 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1831737592 = encapsulatedChannel.getKey();
        varB4EAC82CA7396A68D541C85D26508E83_1831737592.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1831737592;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.266 -0400", hash_original_method = "6EB6BE0A65CE407282FBCFAA26A62D3F", hash_generated_method = "CF18C6F3D6EF8DCECF587DA1546043EF")
    public int getPort() {
        int var8D250738F8903F27A245FCFE34073F32_85774247 = (encapsulatedChannel.getPort());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_686833647 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_686833647;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.266 -0400", hash_original_method = "28698FFA104E0D8C500A173E95CB7CFA", hash_generated_method = "F9CC1E6B3222D45D071A5570E417A001")
    public SIPTransactionStack getSIPStack() {
        SIPTransactionStack varB4EAC82CA7396A68D541C85D26508E83_343812661 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_343812661 = (SIPTransactionStack) sipStack;
        varB4EAC82CA7396A68D541C85D26508E83_343812661.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_343812661;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.267 -0400", hash_original_method = "4D24925E393EE43229BBE6696196C496", hash_generated_method = "483CFA073243580A07911AB9ACC5FD02")
    public String getPeerAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_1114089147 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1114089147 = this.peerAddress;
        varB4EAC82CA7396A68D541C85D26508E83_1114089147.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1114089147;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.267 -0400", hash_original_method = "A1F90D00B31019C3C4E0EAACEB8565BB", hash_generated_method = "2881828161F4E96B9D48827CCED246C8")
    public int getPeerPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1275115424 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1275115424;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.267 -0400", hash_original_method = "D72195827AEF451FEF473FAF2B8F43B1", hash_generated_method = "47FE75ED7DC83C214084204D4573A648")
    public int getPeerPacketSourcePort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_724782734 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_724782734;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.267 -0400", hash_original_method = "46454A41BD800FBE664B92E119C6A2FF", hash_generated_method = "5C6684BA1C14150924EABB6D111CA252")
    public InetAddress getPeerPacketSourceAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_533054364 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_533054364 = this.peerPacketSourceAddress;
        varB4EAC82CA7396A68D541C85D26508E83_533054364.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_533054364;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.268 -0400", hash_original_method = "DE04102C176E73364B597E64B8D5F233", hash_generated_method = "4386A8D82CB9ABFBF92BABD009D1AC80")
    protected InetAddress getPeerInetAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1144970816 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1144970816 = this.peerInetAddress;
        varB4EAC82CA7396A68D541C85D26508E83_1144970816.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1144970816;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.268 -0400", hash_original_method = "DB79607DA3ACB5FA2D24428DF2713F98", hash_generated_method = "F766454A42457F485EE50260A8B95F72")
    protected String getPeerProtocol() {
        String varB4EAC82CA7396A68D541C85D26508E83_541300750 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_541300750 = this.peerProtocol;
        varB4EAC82CA7396A68D541C85D26508E83_541300750.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_541300750;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.269 -0400", hash_original_method = "AEF0860991248E9299E1C6DDE1EF560C", hash_generated_method = "5C0FCD89AA632568AFA88B6388E63431")
    public String getTransport() {
        String varB4EAC82CA7396A68D541C85D26508E83_1760228269 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1760228269 = encapsulatedChannel.getTransport();
        varB4EAC82CA7396A68D541C85D26508E83_1760228269.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1760228269;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.269 -0400", hash_original_method = "6845103B04473D4A2057FADE28E7D0AA", hash_generated_method = "8F4E8F08A4CF95CE1612C8F35CDC8E93")
    public boolean isReliable() {
        boolean varB6C6105558E567E57AF146479D660091_103031124 = (encapsulatedChannel.isReliable());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_615786993 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_615786993;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.270 -0400", hash_original_method = "088E950799411477D094809B385ED56E", hash_generated_method = "EBBDC920A505976A874DF198EE2B6327")
    public Via getViaHeader() {
        Via varB4EAC82CA7396A68D541C85D26508E83_253331370 = null; 
        Via channelViaHeader;
        channelViaHeader = super.getViaHeader();
        try 
        {
            channelViaHeader.setBranch(branch);
        } 
        catch (java.text.ParseException ex)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_253331370 = channelViaHeader;
        varB4EAC82CA7396A68D541C85D26508E83_253331370.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_253331370;
        
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.270 -0400", hash_original_method = "937EBFADC181BFE1D9D7AD4237E3287B", hash_generated_method = "26F2F46D174B09C0DAE699510A09E4C4")
    public void sendMessage(SIPMessage messageToSend) throws IOException {
        try 
        {
            encapsulatedChannel.sendMessage(messageToSend,
                    this.peerInetAddress, this.peerPort);
        } 
        finally 
        {
            this.startTransactionTimer();
        } 
        addTaint(messageToSend.getTaint());
        
        
            
                    
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.271 -0400", hash_original_method = "40115A27A95909E2CE679A790D4014C9", hash_generated_method = "6AD47456D0BE849C62F5DE77D81CE421")
    protected void sendMessage(byte[] messageBytes,
            InetAddress receiverAddress, int receiverPort, boolean retry) throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new IOException(
                "Cannot send unparsed message through Transaction Channel!");
        addTaint(messageBytes[0]);
        addTaint(receiverAddress.getTaint());
        addTaint(receiverPort);
        addTaint(retry);
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.271 -0400", hash_original_method = "72CEDACA72EC4BC352365F84C4504BD8", hash_generated_method = "D18661C9B55695D2AF5DB01C974F3EE6")
    public void addEventListener(SIPTransactionEventListener newListener) {
        eventListeners.add(newListener);
        addTaint(newListener.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.272 -0400", hash_original_method = "668B9893C68F9233FC28CF7C4E017F56", hash_generated_method = "732A8B0CA11B744E2AD558CB25CFDB80")
    public void removeEventListener(SIPTransactionEventListener oldListener) {
        eventListeners.remove(oldListener);
        addTaint(oldListener.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.272 -0400", hash_original_method = "38D8606DEF077947D947856564D84874", hash_generated_method = "26991ABD3DD5D2E2B99BFA449A1E4D2E")
    protected void raiseErrorEvent(int errorEventID) {
        SIPTransactionErrorEvent newErrorEvent;
        Iterator<SIPTransactionEventListener> listenerIterator;
        SIPTransactionEventListener nextListener;
        newErrorEvent = new SIPTransactionErrorEvent(this, errorEventID);
        {
            listenerIterator = eventListeners.iterator();
            {
                boolean var20BE331F515CCC1CE643C3890EEC5ABE_1705915379 = (listenerIterator.hasNext());
                {
                    nextListener = (SIPTransactionEventListener) listenerIterator
                        .next();
                    nextListener.transactionErrorEvent(newErrorEvent);
                } 
            } 
        } 
        {
            eventListeners.clear();
            this.setState(TransactionState.TERMINATED);
            {
                boolean var382FAAF04356B7108B4D034147E328B4_1700016684 = (this instanceof SIPServerTransaction && this.isByeTransaction()
                    && this.getDialog() != null);
                ((SIPDialog) this.getDialog())
                        .setState(SIPDialog.TERMINATED_STATE);
            } 
        } 
        addTaint(errorEventID);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.273 -0400", hash_original_method = "1EC803C9686336CE6058D1F41391EBE2", hash_generated_method = "C17E733AB1AF2F72F6407DF5057E2AB8")
    protected boolean isServerTransaction() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1502349818 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1502349818;
        
        
    }

    
    public abstract Dialog getDialog();

    
    public abstract void setDialog(SIPDialog sipDialog, String dialogId);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.273 -0400", hash_original_method = "A1D654E2B8EB18DBD9E2FBE3DBA84F3D", hash_generated_method = "9EBC3E8060698635A2D731B80457AE8D")
    public int getRetransmitTimer() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2026826566 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2026826566;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.274 -0400", hash_original_method = "310B5DE4F217FB57953AC74F889ED704", hash_generated_method = "ED9E644818F8773887FA66DB91B69DD3")
    public String getViaHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_454422365 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_454422365 = this.getViaHeader().getHost();
        varB4EAC82CA7396A68D541C85D26508E83_454422365.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_454422365;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.274 -0400", hash_original_method = "025E14F038A1EDFF743C73F970E03870", hash_generated_method = "DFFC1D6D7BFA6B309BDC4CF2C714839E")
    public SIPResponse getLastResponse() {
        SIPResponse varB4EAC82CA7396A68D541C85D26508E83_1274613207 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1274613207 = this.lastResponse;
        varB4EAC82CA7396A68D541C85D26508E83_1274613207.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1274613207;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.274 -0400", hash_original_method = "260B447AD36FE2CA2411AAAD920B4F1F", hash_generated_method = "0AACE051ED804603D45EDE7A3AED7DBA")
    public Response getResponse() {
        Response varB4EAC82CA7396A68D541C85D26508E83_112874827 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_112874827 = (Response) this.lastResponse;
        varB4EAC82CA7396A68D541C85D26508E83_112874827.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_112874827;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.275 -0400", hash_original_method = "AB08BB44F7439305FB61E3E9EFAC9224", hash_generated_method = "8E1E6A75A6057247266641146835CB29")
    public String getTransactionId() {
        String varB4EAC82CA7396A68D541C85D26508E83_1820090797 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1820090797 = this.transactionId;
        varB4EAC82CA7396A68D541C85D26508E83_1820090797.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1820090797;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.275 -0400", hash_original_method = "1EE454052F2EC55F5023F8455F33FFAA", hash_generated_method = "B9B484BAC3A98F2CBF01E2DE034A3C92")
    public int hashCode() {
        int var4C9151DE19A39E85210081D04497D7ED_680167473 = (this.transactionId.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1673668914 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1673668914;
        
        
            
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.275 -0400", hash_original_method = "F3BD37ECEE52D7438ECD340DC4DAF3CA", hash_generated_method = "884FD545BB57F08E820F6A087A23E146")
    public int getViaPort() {
        int var0C6CDC10F459777D891ECCDB8DB39867_919793901 = (this.getViaHeader().getPort());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_327398585 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_327398585;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.276 -0400", hash_original_method = "4C1135E1FB3652D771084DD3A5E7B7E8", hash_generated_method = "DCE00A740FD0FFEB00B42B3245370E4A")
    public boolean doesCancelMatchTransaction(SIPRequest requestToTest) {
        ViaList viaHeaders;
        Via topViaHeader;
        String messageBranch;
        boolean transactionMatches;
        transactionMatches = false;
        {
            boolean varDB3FC80D18EEB586685397AA66CD0AD9_836561640 = (this.getOriginalRequest() == null
                || this.getOriginalRequest().getMethod().equals(Request.CANCEL));
        } 
        viaHeaders = requestToTest.getViaHeaders();
        {
            topViaHeader = (Via) viaHeaders.getFirst();
            messageBranch = topViaHeader.getBranch();
            {
                {
                    boolean var36D9A4D2906CC61B64FFF3E977E71366_902162339 = (!messageBranch.toLowerCase().startsWith(SIPConstants.BRANCH_MAGIC_COOKIE_LOWER_CASE));
                    {
                        messageBranch = null;
                    } 
                } 
            } 
            {
                boolean varD825878E5C71E9D99195551828F9E150_25946005 = (messageBranch != null && this.getBranch() != null);
                {
                    {
                        boolean var40A3BE5C85F3B3E698DEE2FF2DE53418_1205528670 = (getBranch().equalsIgnoreCase(messageBranch)
                        && topViaHeader.getSentBy().equals(
                                ((Via) getOriginalRequest().getViaHeaders()
                                        .getFirst()).getSentBy()));
                        {
                            transactionMatches = true;
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_768006419 = (sipStack.isLoggingEnabled());
                                sipStack.getStackLogger().logDebug("returning  true");
                            } 
                        } 
                    } 
                } 
                {
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_860748239 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger().logDebug("testing against "
                            + getOriginalRequest());
                    } 
                    {
                        boolean varF49D98EFFEE05A7D0E6524281A64A821_1975260013 = (getOriginalRequest().getRequestURI().equals(
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
                        } 
                    } 
                } 
            } 
        } 
        {
            this.setPassToListener();
        } 
        addTaint(requestToTest.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1607390772 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1607390772;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.277 -0400", hash_original_method = "348CFFAB37D4D83E29A04C573F3FF487", hash_generated_method = "6447FDC7F964B9C9FE7827927739BE5A")
    public void setRetransmitTimer(int retransmitTimer) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "Retransmit timer must be positive!");
        {
            boolean varD45EC8E193CE555496F99346397FAFE2_1824575379 = (this.transactionTimerStarted.get());
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "Transaction timer is already started");
        } 
        BASE_TIMER_INTERVAL = retransmitTimer;
        T4 = 5000 / BASE_TIMER_INTERVAL;
        T2 = 4000 / BASE_TIMER_INTERVAL;
        TIMER_I = T4;
        TIMER_K = T4;
        TIMER_D = 32000 / BASE_TIMER_INTERVAL;
        
        
            
                    
        
            
                    
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.277 -0400", hash_original_method = "45CE0F911469E288CC97776E84414496", hash_generated_method = "5BEA2FBBA0820FA7ACE373D380EBD7AC")
    public void close() {
        this.encapsulatedChannel.close();
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1490376205 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug("Closing " + this.encapsulatedChannel);
        } 
        
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.278 -0400", hash_original_method = "905D593C098EC8A0BB1DC95C9B54F441", hash_generated_method = "3DD57569D1ED4B6E490CC7A98D7A7918")
    public boolean isSecure() {
        boolean var48C9EE19D6C5FA52907CC989AE9A3A00_1060079447 = (encapsulatedChannel.isSecure());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_955436071 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_955436071;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.279 -0400", hash_original_method = "9C4DCEACA96616F074242810B487B970", hash_generated_method = "E378334A4F00245E40B8C7C74C439587")
    public MessageProcessor getMessageProcessor() {
        MessageProcessor varB4EAC82CA7396A68D541C85D26508E83_211303178 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_211303178 = this.encapsulatedChannel.getMessageProcessor();
        varB4EAC82CA7396A68D541C85D26508E83_211303178.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_211303178;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.279 -0400", hash_original_method = "552E0456C33D24CD63C8EBCDAC1D019B", hash_generated_method = "E17DD994BC845C3BDBBD70ECC432242E")
    public void setApplicationData(Object applicationData) {
        this.applicationData = applicationData;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.280 -0400", hash_original_method = "5F924FC61375970A4DC758380BEBFF0F", hash_generated_method = "25A1D22388F9C95BDF51562E10E9D8D9")
    public Object getApplicationData() {
        Object varB4EAC82CA7396A68D541C85D26508E83_334316144 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_334316144 = this.applicationData;
        varB4EAC82CA7396A68D541C85D26508E83_334316144.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_334316144;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.280 -0400", hash_original_method = "739B4CAA187BE9D487A452627B0424A2", hash_generated_method = "3E247DA8F2E347E80DAB817F941F23BE")
    public void setEncapsulatedChannel(MessageChannel messageChannel) {
        this.encapsulatedChannel = messageChannel;
        this.peerInetAddress = messageChannel.getPeerInetAddress();
        this.peerPort = messageChannel.getPeerPort();
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.281 -0400", hash_original_method = "38ECF920BD32EC6B95BB00C4AAD637BA", hash_generated_method = "A0C9FC169269CF50548CB36FEF3E19BC")
    public SipProviderImpl getSipProvider() {
        SipProviderImpl varB4EAC82CA7396A68D541C85D26508E83_1344893273 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1344893273 = this.getMessageProcessor().getListeningPoint().getProvider();
        varB4EAC82CA7396A68D541C85D26508E83_1344893273.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1344893273;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.282 -0400", hash_original_method = "BA06BB4C0270C8B47C1CBBF5F94DA61A", hash_generated_method = "9D61886FD6672CD3972ACA9DAD63DF87")
    public void raiseIOExceptionEvent() {
        setState(TransactionState.TERMINATED);
        String host = getPeerAddress();
        int port = getPeerPort();
        String transport = getTransport();
        IOExceptionEvent exceptionEvent = new IOExceptionEvent(this, host,
                port, transport);
        getSipProvider().handleEvent(exceptionEvent, this);
        
        
        
        
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.283 -0400", hash_original_method = "9C758C929345C5BD5429DB309FDFD6EA", hash_generated_method = "296B6D1110E8634D24190A0E5DA87297")
    public boolean acquireSem() {
        boolean retval = false;
        try 
        {
            {
                boolean var0C9E46B9F84667219FF0963258285136_82858390 = (sipStack.getStackLogger().isLoggingEnabled());
                {
                    sipStack.getStackLogger().logDebug("acquireSem [[[[" + this);
                    sipStack.getStackLogger().logStackTrace();
                } 
            } 
            retval = this.semaphore.tryAcquire(1000, TimeUnit.MILLISECONDS);
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_713714434 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug(
                    "acquireSem() returning : " + retval);
            } 
        } 
        catch (Exception ex)
        {
            sipStack.getStackLogger().logError("Unexpected exception acquiring sem",
                    ex);
            InternalErrorHandler.handleException(ex);
        } 
        finally 
        {
            this.isSemaphoreAquired = retval;
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_92279850 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_92279850;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.284 -0400", hash_original_method = "301846C685CE876D86A6B4185A591E30", hash_generated_method = "2E46BBF6796C78AED74045C8C40488CD")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.286 -0400", hash_original_method = "DBC24F6DB4FEFD7D7F8639708567DC35", hash_generated_method = "26DDD1FED01A22F7178A425F63AD4109")
    protected void semRelease() {
        try 
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1479208049 = (sipStack.isLoggingEnabled());
                {
                    sipStack.getStackLogger().logDebug("semRelease ]]]]" + this);
                    sipStack.getStackLogger().logStackTrace();
                } 
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.287 -0400", hash_original_method = "39E9029186E8CC55AF8CBCC68EB9597C", hash_generated_method = "A2F58E43E2259B7B3A9A7B29314A5400")
    public boolean passToListener() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1951476201 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1951476201;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.288 -0400", hash_original_method = "F5F4C78B3DFF0EDA40F4B14C1017F836", hash_generated_method = "9DCAF60E554326FD80E3DD213F5F1FA8")
    public void setPassToListener() {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_2003252062 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("setPassToListener()");
            } 
        } 
        this.toListener = true;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.288 -0400", hash_original_method = "5D50ECFAFAF878A5B29EF8C830BE2C71", hash_generated_method = "91CE07D86FF7120642CFF5CCCB979C0D")
    protected synchronized boolean testAndSetTransactionTerminatedEvent() {
        boolean retval = !this.terminatedEventDelivered;
        this.terminatedEventDelivered = true;
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_872748243 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_872748243;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.290 -0400", hash_original_method = "0D2015A100DFE7954256C577DAEBD143", hash_generated_method = "6F2B60C7055A1B35CAA72D8268A11109")
    public String getCipherSuite() throws UnsupportedOperationException {
        String varB4EAC82CA7396A68D541C85D26508E83_1376887580 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1667936736 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_488010497 = null; 
        {
            boolean var6C6A2C453D42291A755997484653A937_384000617 = (this.getMessageChannel() instanceof TLSMessageChannel);
            {
                {
                    boolean varFCE35EDD0B032F5EB8C912B15CF85890_1451396772 = (((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener() == null);
                    varB4EAC82CA7396A68D541C85D26508E83_1376887580 = null;
                    {
                        boolean var39C45FA9CE575184B384B180A37212E6_955857722 = (((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener().getHandshakeCompletedEvent() == null);
                        varB4EAC82CA7396A68D541C85D26508E83_1667936736 = null;
                        varB4EAC82CA7396A68D541C85D26508E83_488010497 = ((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener().getHandshakeCompletedEvent().getCipherSuite();
                    } 
                } 
            } 
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Not a TLS channel");
        } 
        String varA7E53CE21691AB073D9660D615818899_498347941; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_498347941 = varB4EAC82CA7396A68D541C85D26508E83_1376887580;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_498347941 = varB4EAC82CA7396A68D541C85D26508E83_1667936736;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_498347941 = varB4EAC82CA7396A68D541C85D26508E83_488010497;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_498347941.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_498347941;
        
        
            
                
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.291 -0400", hash_original_method = "1BD353D03C47A7F0291FB8AF92EA1899", hash_generated_method = "26B9E9DB138F0052F1B109E2D5BA2E1A")
    public java.security.cert.Certificate[] getLocalCertificates() throws UnsupportedOperationException {
        java.security.cert.Certificate[] varB4EAC82CA7396A68D541C85D26508E83_1304259905 = null; 
        java.security.cert.Certificate[] varB4EAC82CA7396A68D541C85D26508E83_1728962350 = null; 
        java.security.cert.Certificate[] varB4EAC82CA7396A68D541C85D26508E83_727175595 = null; 
        {
            boolean var6C6A2C453D42291A755997484653A937_1050732613 = (this.getMessageChannel() instanceof TLSMessageChannel);
            {
                {
                    boolean varFCE35EDD0B032F5EB8C912B15CF85890_779066964 = (((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener() == null);
                    varB4EAC82CA7396A68D541C85D26508E83_1304259905 = null;
                    {
                        boolean var39C45FA9CE575184B384B180A37212E6_1262626689 = (((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener().getHandshakeCompletedEvent() == null);
                        varB4EAC82CA7396A68D541C85D26508E83_1728962350 = null;
                        varB4EAC82CA7396A68D541C85D26508E83_727175595 = ((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener().getHandshakeCompletedEvent().getLocalCertificates();
                    } 
                } 
            } 
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Not a TLS channel");
        } 
        java.security.cert.Certificate[] varA7E53CE21691AB073D9660D615818899_266527372; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_266527372 = varB4EAC82CA7396A68D541C85D26508E83_1304259905;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_266527372 = varB4EAC82CA7396A68D541C85D26508E83_1728962350;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_266527372 = varB4EAC82CA7396A68D541C85D26508E83_727175595;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_266527372.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_266527372;
        
        
            
                
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.294 -0400", hash_original_method = "425975E25339AF497E9130895A1F6EC3", hash_generated_method = "3424D907C1091005173D9ADC3C733E43")
    public java.security.cert.Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
        java.security.cert.Certificate[] varB4EAC82CA7396A68D541C85D26508E83_474863017 = null; 
        java.security.cert.Certificate[] varB4EAC82CA7396A68D541C85D26508E83_1911364638 = null; 
        java.security.cert.Certificate[] varB4EAC82CA7396A68D541C85D26508E83_445853585 = null; 
        {
            boolean var6C6A2C453D42291A755997484653A937_486024839 = (this.getMessageChannel() instanceof TLSMessageChannel);
            {
                {
                    boolean varFCE35EDD0B032F5EB8C912B15CF85890_1968375793 = (((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener() == null);
                    varB4EAC82CA7396A68D541C85D26508E83_474863017 = null;
                    {
                        boolean var39C45FA9CE575184B384B180A37212E6_1106465667 = (((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener().getHandshakeCompletedEvent() == null);
                        varB4EAC82CA7396A68D541C85D26508E83_1911364638 = null;
                        varB4EAC82CA7396A68D541C85D26508E83_445853585 = ((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener().getHandshakeCompletedEvent().getPeerCertificates();
                    } 
                } 
            } 
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Not a TLS channel");
        } 
        java.security.cert.Certificate[] varA7E53CE21691AB073D9660D615818899_1903282982; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1903282982 = varB4EAC82CA7396A68D541C85D26508E83_474863017;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1903282982 = varB4EAC82CA7396A68D541C85D26508E83_1911364638;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1903282982 = varB4EAC82CA7396A68D541C85D26508E83_445853585;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1903282982.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1903282982;
        
        
            
                
            
                
            
        
    }

    
    protected abstract void startTransactionTimer();

    
    public abstract boolean isMessagePartOfTransaction(SIPMessage messageToTest);

    
    protected abstract void fireRetransmissionTimer();

    
    protected abstract void fireTimeoutTimer();

    
    class LingerTimer extends SIPStackTimerTask {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.296 -0400", hash_original_method = "4F6152921EA187210C4EA8258CD889E1", hash_generated_method = "9784F01EA79F612CBC2A103564BFEDFD")
        public  LingerTimer() {
            SIPTransaction sipTransaction = SIPTransaction.this;
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_188508844 = (sipStack.isLoggingEnabled());
                {
                    sipStack.getStackLogger().logDebug("LingerTimer : "
                        + sipTransaction.getTransactionId());
                } 
            } 
            
            
            
                
                        
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.297 -0400", hash_original_method = "14B41A6E0BE7E84E900DADE7EB6E3A9A", hash_generated_method = "C2D55D9E017618C0ADD6C1A8387FC4AF")
        protected void runTask() {
            SIPTransaction transaction = SIPTransaction.this;
            SIPTransactionStack sipStack = transaction.getSIPStack();
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1482855472 = (sipStack.isLoggingEnabled());
                {
                    sipStack.getStackLogger().logDebug("LingerTimer: run() : "
                        + getTransactionId());
                } 
            } 
            {
                sipStack.removeTransaction(transaction);
                transaction.close();
            } 
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1260826872 = (sipStack.isLoggingEnabled());
                    sipStack.getStackLogger().logDebug("removing" + transaction);
                } 
                sipStack.removeTransaction(transaction);
                {
                    transaction.close();
                } 
                {
                    {
                        boolean var4956126C243BADFE0BCC10A3ADC78702_1559439529 = (sipStack.isLoggingEnabled()
                            && (!sipStack.cacheServerConnections)
                            && transaction.isReliable());
                        {
                            int useCount = transaction.encapsulatedChannel.useCount;
                            sipStack.getStackLogger().logDebug("Use Count = " + useCount);
                        } 
                    } 
                } 
            } 
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.297 -0400", hash_original_field = "A416A668043B482EFC2F2325D3EC1153", hash_generated_field = "ACC922C0E49053B414BC2B207C435038")

    protected static final int T1 = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.297 -0400", hash_original_field = "41507773B89CE446DCAC23DD50F37819", hash_generated_field = "7E2D9869BDB9045700E8D821F4588BDF")

    protected static final int TIMER_A = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.297 -0400", hash_original_field = "C712D1D637F4061683A4B32D6EF6874E", hash_generated_field = "93B7D7F2080EBBB3787D866882928B33")

    protected static final int TIMER_B = 64;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.297 -0400", hash_original_field = "06269F326966D3ACA4950A4B6EE7EA0B", hash_generated_field = "C6478F3FDDFCC7A5866A29DA158AC357")

    protected static final int TIMER_J = 64;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.297 -0400", hash_original_field = "51D1F67E03F85531F794EFC17953564E", hash_generated_field = "A9B44A5318402784FF69AC6DA430A9D6")

    protected static final int TIMER_F = 64;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.297 -0400", hash_original_field = "5DA06C034F975ABA139B09C72EAD0872", hash_generated_field = "3DE8E426A4F01136C7ECA20307DAE43A")

    protected static final int TIMER_H = 64;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.297 -0400", hash_original_field = "CC18DC3FB7CE731BAD3934F245CE3454", hash_generated_field = "8BA3A0ADBD6ABEEE2C128AA938AC9DE1")

    public static final TransactionState INITIAL_STATE = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.297 -0400", hash_original_field = "9226F430E079BC77D0322347132C7EE8", hash_generated_field = "D317B7F0EDCFF7869AC099F8F60A26C5")

    public static final TransactionState TRYING_STATE = TransactionState.TRYING;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.297 -0400", hash_original_field = "558B4EE8481E9F9FC0DAA8CB1CA500C8", hash_generated_field = "7694E1BD134F3AABB468EB52BEB662A9")

    public static final TransactionState CALLING_STATE = TransactionState.CALLING;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.297 -0400", hash_original_field = "2182728F7F14AB8E9B791431AC114DA8", hash_generated_field = "06F5AD8C442768658EEA785254674FFF")

    public static final TransactionState PROCEEDING_STATE = TransactionState.PROCEEDING;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.297 -0400", hash_original_field = "044D7AD2DD976AB03066B86B5AD02515", hash_generated_field = "F0F4AEFF89B151D97D57677046A3B234")

    public static final TransactionState COMPLETED_STATE = TransactionState.COMPLETED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.297 -0400", hash_original_field = "4A6DD65DC912AE7BAD7804C7F87D3681", hash_generated_field = "EBCB27C78436E501BBCA8D4CD1A806C2")

    public static final TransactionState CONFIRMED_STATE = TransactionState.CONFIRMED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.297 -0400", hash_original_field = "1D290254DA712EE27D9F5047A872DF10", hash_generated_field = "B19BF2F78FE0062DCD29ACB945A7A8B5")

    public static final TransactionState TERMINATED_STATE = TransactionState.TERMINATED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.297 -0400", hash_original_field = "C031D221A72791D98EF5BFC8F90FBED8", hash_generated_field = "F8F7C8DEA67FC9F18B9E1E40A34E4804")

    protected static final int MAXIMUM_RETRANSMISSION_TICK_COUNT = 8;
}

