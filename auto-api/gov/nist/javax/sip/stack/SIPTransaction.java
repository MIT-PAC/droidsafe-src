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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.049 -0400", hash_original_field = "2B259185198C3F8BF792A605A14004E6", hash_generated_field = "E1D4E9B3AAF496FD813808775B58AFF8")

    protected boolean toListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.049 -0400", hash_original_field = "87903C91D979BEB4E00BBC5332AAE689", hash_generated_field = "9A93D89EE79003352C54A76D4BCBEF57")

    protected int BASE_TIMER_INTERVAL = SIPTransactionStack.BASE_TIMER_INTERVAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.050 -0400", hash_original_field = "47E14B32BBE9F9DF68D573CACFC16149", hash_generated_field = "AFFFDDF9E03C18C4462622216D1D744E")

    protected int T4 = 5000 / BASE_TIMER_INTERVAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.050 -0400", hash_original_field = "61039199CF671E979441018417D7D597", hash_generated_field = "5AB93F413E7E37621B4D5A565BACE4EE")

    protected int T2 = 4000 / BASE_TIMER_INTERVAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.050 -0400", hash_original_field = "B70CAA4CBFD6EE4F02C591E86E116069", hash_generated_field = "9F72081078574EE44AD3339670F6DF1F")

    protected int TIMER_I = T4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.050 -0400", hash_original_field = "F1B52E1E5C59167765233838AC175899", hash_generated_field = "CA8408AC31A4B160960A20C24156B7EC")

    protected int TIMER_K = T4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.050 -0400", hash_original_field = "A6B23354CA0D6C4DAE6F5E622B535F0B", hash_generated_field = "46098F3DF9CF80FB6A2FF1FF700C1E30")

    protected int TIMER_D = 32000 / BASE_TIMER_INTERVAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.050 -0400", hash_original_field = "756C73A51ADF7F04942C8BE97A032000", hash_generated_field = "B1A8E011179EF40B9DAC21E1148B1B78")

    protected transient Object applicationData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.050 -0400", hash_original_field = "9ECD142FA67835EFBFD693D2B0EFC756", hash_generated_field = "8CE24F874A42F410B23EF4851613017C")

    protected SIPResponse lastResponse;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.050 -0400", hash_original_field = "66CA6208A29137D8034ED70E634A1646", hash_generated_field = "77FEBEAA4AF79617A8B0CBB244F26247")

    protected boolean isMapped;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.050 -0400", hash_original_field = "CE1BC7755B9332CFACDF8EE58EF2E3C1", hash_generated_field = "3F41BA6F3B911D0AFE0A127EF365871F")

    private Semaphore semaphore;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.050 -0400", hash_original_field = "24776DD7C271F7EB52082A8DF20FE6A6", hash_generated_field = "30E9188AD86CBF24A584DD99B37E6A4C")

    protected boolean isSemaphoreAquired;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.050 -0400", hash_original_field = "671139EDEB98807421E35E63D9C29A6A", hash_generated_field = "9C238CB346335F1D207FF4BBD6C9DEAD")

    protected String transactionId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.050 -0400", hash_original_field = "C0CEB3515CA4F46A6B2A58F9563A8976", hash_generated_field = "671A9D7640781DBA64AF5A5BAE3E2701")

    public long auditTag = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.050 -0400", hash_original_field = "37460D4BF2BA47A13FF9D922C4B14B2E", hash_generated_field = "4664B9159D27EBBF3CF109F118F56F46")

    protected transient SIPTransactionStack sipStack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.050 -0400", hash_original_field = "539F42CD378873BB0F9889EFF317BAFA", hash_generated_field = "E987B06AF0DFCAA9F38DD607A12D9B39")

    protected SIPRequest originalRequest;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.050 -0400", hash_original_field = "809A0AB6067FCFE0AB1E4C7E2ED026AA", hash_generated_field = "25DB028ECDD75BE4977DFE05FC00F4D2")

    private transient MessageChannel encapsulatedChannel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.050 -0400", hash_original_field = "BBD5741C4F9994864582D25DD194C4DE", hash_generated_field = "6A69B321E52130622ADD35A2A3F00BA6")

    protected int peerPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.050 -0400", hash_original_field = "D5A8CA55B131A89C25E3C0595C953BCA", hash_generated_field = "ACA9646C167AB8988D8D4678A1C02262")

    protected InetAddress peerInetAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.050 -0400", hash_original_field = "D7FA5E7DC9BACC5016B81E35D44D1C5F", hash_generated_field = "C9738122113DFDEEF725F74B583F0EE7")

    protected String peerAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.050 -0400", hash_original_field = "EDB6E8FD971C3E6879E1A00995BCB702", hash_generated_field = "FBF73E4EC3FC246E9E63B41E9D9708E4")

    protected String peerProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.050 -0400", hash_original_field = "E2843BEFA12DEA2BD46F0D29DAA8CB35", hash_generated_field = "A5A71425C21DF932789F3BE8BFE8101E")

    protected int peerPacketSourcePort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.050 -0400", hash_original_field = "1906DDE6FBF1A1A564E69A91EBCF4043", hash_generated_field = "AA48B9901BA1D417BEAE6C24D398429E")

    protected InetAddress peerPacketSourceAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.050 -0400", hash_original_field = "95ED6E6B932BB90F37EB8D409DC725E0", hash_generated_field = "C48464462DE8239144ADA7BDEA8A5336")

    protected AtomicBoolean transactionTimerStarted = new AtomicBoolean(false);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.050 -0400", hash_original_field = "9603A224B40D7B67210B78F2E390D00F", hash_generated_field = "30E846F477E8815819D75224F8F894EA")

    private String branch;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.050 -0400", hash_original_field = "EA9F6ACA279138C58F705C8D4CB4B8CE", hash_generated_field = "F42F15CDE806BBAD7F26F7952D68FCE2")

    private String method;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.050 -0400", hash_original_field = "518FD2362F5A4BA10EAEF07A78FCCE98", hash_generated_field = "42D60DCE07190569B4FB5DBAE96EB838")

    private long cSeq;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.050 -0400", hash_original_field = "542734C7E65EC6932E6AE354B2B7DB76", hash_generated_field = "1D3A2129BFAA64E672459DABFB968979")

    private TransactionState currentState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.050 -0400", hash_original_field = "C18186E6A18F0688FA3C41006C8B7690", hash_generated_field = "E635400649257FF3CB3C8321A25A9521")

    private transient int retransmissionTimerLastTickCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.050 -0400", hash_original_field = "734EA45E3F7351452921A4A8AADED8B9", hash_generated_field = "91834647ACD706C1011839DD85835F02")

    private transient int retransmissionTimerTicksLeft;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.050 -0400", hash_original_field = "C06879E46D091BA209F56764D4F2F7AE", hash_generated_field = "3CE5B548E56A9CACC294CED8BA31ABAA")

    protected int timeoutTimerTicksLeft;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.050 -0400", hash_original_field = "FEAAE72958B4E88882F57D0164DCA2A6", hash_generated_field = "17BD452206B118EF58DBF7409BE6123E")

    private transient Set<SIPTransactionEventListener> eventListeners;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.050 -0400", hash_original_field = "D98A07F84921B24EE30F86FD8CD85C3C", hash_generated_field = "DEE2AF2482972910756C73DE5B8E2D10")

    protected From from;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.050 -0400", hash_original_field = "01B6E20344B68835C5ED1DDEDF20D531", hash_generated_field = "C448E6A4D656FF8991A12FB1F342B81A")

    protected To to;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.051 -0400", hash_original_field = "4119639092E62C55EA8BE348E4D9260D", hash_generated_field = "45474E5168B474ED8B347CB237DE65F5")

    protected Event event;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.051 -0400", hash_original_field = "0CD10A72F684313DCE7B6EF5F7F41411", hash_generated_field = "A097F8113589FE8B954AAE5C2A8185B4")

    protected CallID callId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.051 -0400", hash_original_field = "1B38361017A51E31457A871D3CC1FDE8", hash_generated_field = "6901AE467E2FAFDA07BDA528E126DAD1")

    protected int collectionTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.051 -0400", hash_original_field = "87ECE4FA02ED8396D6D6AB6F8D7024D9", hash_generated_field = "2548F380843EE93CEFA1182D7B7D4CAB")

    protected String toTag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.051 -0400", hash_original_field = "5DCBCDCA0B50FA4B705DBC416182E2D6", hash_generated_field = "2473B4AA5FDBB54683BF7F1A7022AFDB")

    protected String fromTag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.051 -0400", hash_original_field = "893B98AC1C2269A2499D4209F933A227", hash_generated_field = "A7AFFE900DA148C693A4DA5C908804C1")

    private boolean terminatedEventDelivered;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.061 -0400", hash_original_method = "5F08F1F6762C0D715B46AA0C57E5FACB", hash_generated_method = "62C3EB7F04B850ED0338AA21CCC61363")
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
            boolean varDFC5BF10E00B4CEC32C670E55EF86009_1634129494 = (this.isReliable());
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_209906911 = (sipStack.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.062 -0400", hash_original_method = "F0D7866FE2BBCD680DCAF285C3141724", hash_generated_method = "8646CA967607DAF4A7057EAA64922DBB")
    public String getBranchId() {
        String varB4EAC82CA7396A68D541C85D26508E83_1928696678 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1928696678 = this.branch;
        varB4EAC82CA7396A68D541C85D26508E83_1928696678.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1928696678;
        // ---------- Original Method ----------
        //return this.branch;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.065 -0400", hash_original_method = "55609707D0B67BA3A76250F409DE303B", hash_generated_method = "AFDC39E624F616ABB59110A45B77904E")
    public void setOriginalRequest(SIPRequest newOriginalRequest) {
        String newBranch;
        {
            boolean varED20A49E7D8795E663FD7E52527B4B8C_2134261145 = (this.originalRequest != null
                && (!this.originalRequest.getTransactionId().equals(
                        newOriginalRequest.getTransactionId())));
            {
                sipStack.removeTransactionHash(this);
            } //End block
        } //End collapsed parenthetic
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
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1940772656 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug("Setting Branch id : " + newBranch);
            } //End collapsed parenthetic
            setBranch(newBranch);
        } //End block
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_923082124 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug("Branch id is null - compute TID!"
                        + newOriginalRequest.encode());
            } //End collapsed parenthetic
            setBranch(newOriginalRequest.getTransactionId());
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.065 -0400", hash_original_method = "E55FA929D44B8592CC293995403E5C80", hash_generated_method = "09212F9FD6063AAB48EDBF4A717B233B")
    public SIPRequest getOriginalRequest() {
        SIPRequest varB4EAC82CA7396A68D541C85D26508E83_28742738 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_28742738 = originalRequest;
        varB4EAC82CA7396A68D541C85D26508E83_28742738.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_28742738;
        // ---------- Original Method ----------
        //return originalRequest;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.068 -0400", hash_original_method = "77DF64C3C6C54874FB57EB6F51047938", hash_generated_method = "44D33FB90BF753CEAA81C96BEDE1BD88")
    public Request getRequest() {
        Request varB4EAC82CA7396A68D541C85D26508E83_892047308 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_892047308 = (Request) originalRequest;
        varB4EAC82CA7396A68D541C85D26508E83_892047308.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_892047308;
        // ---------- Original Method ----------
        //return (Request) originalRequest;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.068 -0400", hash_original_method = "CD53B018E22B6706BBA3F591144F3E86", hash_generated_method = "5B202E20AEA391FE849636873FC9B07A")
    public final boolean isInviteTransaction() {
        boolean varF00C6BE92A0E41FAF82C4342626E2262_1409506942 = (getMethod().equals(Request.INVITE));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_920425658 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_920425658;
        // ---------- Original Method ----------
        //return getMethod().equals(Request.INVITE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.068 -0400", hash_original_method = "BF9744C1CDF47773C8154FC6D9BF750F", hash_generated_method = "4BFB617A50C8CF4E393551DA4FA3715E")
    public final boolean isCancelTransaction() {
        boolean varF09126792D15B60E02E36B5E7F24788C_1920139357 = (getMethod().equals(Request.CANCEL));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1415673562 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1415673562;
        // ---------- Original Method ----------
        //return getMethod().equals(Request.CANCEL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.072 -0400", hash_original_method = "B590647CF4DDAA4D2D7D3928C46D70C5", hash_generated_method = "5A2F9C76974D1B90A2C81D2E15545C24")
    public final boolean isByeTransaction() {
        boolean var6E30B2E86E105ADB2706B05016297A15_1298574538 = (getMethod().equals(Request.BYE));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1340268554 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1340268554;
        // ---------- Original Method ----------
        //return getMethod().equals(Request.BYE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.074 -0400", hash_original_method = "4873376BBCB3E7C4172E860864FE5E6F", hash_generated_method = "A9DDE786A1389F779392BAF6EEA68602")
    public MessageChannel getMessageChannel() {
        MessageChannel varB4EAC82CA7396A68D541C85D26508E83_1262857405 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1262857405 = encapsulatedChannel;
        varB4EAC82CA7396A68D541C85D26508E83_1262857405.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1262857405;
        // ---------- Original Method ----------
        //return encapsulatedChannel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.074 -0400", hash_original_method = "E1AAF4400C28181416F2CF35F703EDD4", hash_generated_method = "B52851A503E84EDC3613312ADF5BAF23")
    public final void setBranch(String newBranch) {
        branch = newBranch;
        // ---------- Original Method ----------
        //branch = newBranch;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.075 -0400", hash_original_method = "8CF2A0009E9AA335F31D8DE930BE32FD", hash_generated_method = "ABC79550ED6F6717673CB9B66C43FA42")
    public final String getBranch() {
        String varB4EAC82CA7396A68D541C85D26508E83_1911722881 = null; //Variable for return #1
        {
            this.branch = getOriginalRequest().getTopmostVia().getBranch();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1911722881 = branch;
        varB4EAC82CA7396A68D541C85D26508E83_1911722881.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1911722881;
        // ---------- Original Method ----------
        //if (this.branch == null) {
            //this.branch = getOriginalRequest().getTopmostVia().getBranch();
        //}
        //return branch;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.075 -0400", hash_original_method = "691C5451C67574E660997BC2056A5F23", hash_generated_method = "7A4DA4D27C1B57B85FCECFD4E1287395")
    public final String getMethod() {
        String varB4EAC82CA7396A68D541C85D26508E83_1904350970 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1904350970 = this.method;
        varB4EAC82CA7396A68D541C85D26508E83_1904350970.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1904350970;
        // ---------- Original Method ----------
        //return this.method;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.076 -0400", hash_original_method = "01D6A6E462A394F38C502658C03C7A92", hash_generated_method = "4D26A90A8ECCFAEAE1ABDA6B105B41A7")
    public final long getCSeq() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1564917603 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1564917603;
        // ---------- Original Method ----------
        //return this.cSeq;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.077 -0400", hash_original_method = "A4A5B758CCC2E3BD812410810F0DBFFC", hash_generated_method = "B99CBC74AF98A99C8C7F55C56E481219")
    public void setState(TransactionState newState) {
        {
            newState = TransactionState.COMPLETED;
        } //End block
        {
            newState = TransactionState.CONFIRMED;
        } //End block
        currentState = newState;
        newState = currentState;
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1084596552 = (sipStack.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.078 -0400", hash_original_method = "61525F5D630175E526789474B6CFB85F", hash_generated_method = "ECA7D115BB5D714BE976CCE08CFCE671")
    public TransactionState getState() {
        TransactionState varB4EAC82CA7396A68D541C85D26508E83_2119433690 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2119433690 = this.currentState;
        varB4EAC82CA7396A68D541C85D26508E83_2119433690.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2119433690;
        // ---------- Original Method ----------
        //return this.currentState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.082 -0400", hash_original_method = "C06C644410B862B7DEB29308419E2C70", hash_generated_method = "6A4FF161C9F76B44F033C4156E4AA7D6")
    protected final void enableRetransmissionTimer() {
        enableRetransmissionTimer(1);
        // ---------- Original Method ----------
        //enableRetransmissionTimer(1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.082 -0400", hash_original_method = "69D842DACBECB66F6A3F4CBF6CAA3BE5", hash_generated_method = "F26B3D2744CA5AB77E128E7435181660")
    protected final void enableRetransmissionTimer(int tickCount) {
        {
            boolean varF0C28EC8C9F15D61EF70697CCCF4EF42_832167962 = (isInviteTransaction() && (this instanceof SIPClientTransaction));
            {
                retransmissionTimerTicksLeft = tickCount;
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.082 -0400", hash_original_method = "7BF746AF9660DF3C6103C0B4973C1639", hash_generated_method = "2CD2716A8942EAD7668CFD177D09E769")
    protected final void disableRetransmissionTimer() {
        retransmissionTimerTicksLeft = -1;
        // ---------- Original Method ----------
        //retransmissionTimerTicksLeft = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.088 -0400", hash_original_method = "C532D8E297B37B97B54B6D70870D5AC1", hash_generated_method = "D591FD9AE29F65F3F68AFA611217CEDE")
    protected final void enableTimeoutTimer(int tickCount) {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1568160118 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug("enableTimeoutTimer " + this
                    + " tickCount " + tickCount + " currentTickCount = "
                    + timeoutTimerTicksLeft);
        } //End collapsed parenthetic
        timeoutTimerTicksLeft = tickCount;
        // ---------- Original Method ----------
        //if (sipStack.isLoggingEnabled())
            //sipStack.getStackLogger().logDebug("enableTimeoutTimer " + this
                    //+ " tickCount " + tickCount + " currentTickCount = "
                    //+ timeoutTimerTicksLeft);
        //timeoutTimerTicksLeft = tickCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.088 -0400", hash_original_method = "9098113579473A4D9B2DEEE12DBC58EA", hash_generated_method = "74EBCF06DC426C73AD0041D14DF3531F")
    protected final void disableTimeoutTimer() {
        timeoutTimerTicksLeft = -1;
        // ---------- Original Method ----------
        //timeoutTimerTicksLeft = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.088 -0400", hash_original_method = "CB8F1BD04D54E1B61EA5D28A66348AD3", hash_generated_method = "2D83B18146246D98BFA584B5E41EB2B4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.088 -0400", hash_original_method = "308D399F3CCDEFF33AA1ADAF72826036", hash_generated_method = "E4DA38057C14FCB1D49FF5E7BDA470C2")
    public final boolean isTerminated() {
        boolean var7BB039B32C96C37D7F86735250612D70_1030799761 = (getState() == TERMINATED_STATE);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1538472064 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1538472064;
        // ---------- Original Method ----------
        //return getState() == TERMINATED_STATE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.089 -0400", hash_original_method = "DAE59CB64F6674AD8098A54E7D2B1281", hash_generated_method = "F3E8EDE4FF5C847A096DBC5D79F1D045")
    public String getHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_346639690 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_346639690 = encapsulatedChannel.getHost();
        varB4EAC82CA7396A68D541C85D26508E83_346639690.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_346639690;
        // ---------- Original Method ----------
        //return encapsulatedChannel.getHost();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.089 -0400", hash_original_method = "20977D5C5AB9D45A39447595F1157FC6", hash_generated_method = "3E7AB20B5C9BA4B9DAF8FC32F5EAC73E")
    public String getKey() {
        String varB4EAC82CA7396A68D541C85D26508E83_1780177973 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1780177973 = encapsulatedChannel.getKey();
        varB4EAC82CA7396A68D541C85D26508E83_1780177973.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1780177973;
        // ---------- Original Method ----------
        //return encapsulatedChannel.getKey();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.089 -0400", hash_original_method = "6EB6BE0A65CE407282FBCFAA26A62D3F", hash_generated_method = "111610161C534299371BC2629AA8417D")
    public int getPort() {
        int var8D250738F8903F27A245FCFE34073F32_1625383588 = (encapsulatedChannel.getPort());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_132571849 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_132571849;
        // ---------- Original Method ----------
        //return encapsulatedChannel.getPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.091 -0400", hash_original_method = "28698FFA104E0D8C500A173E95CB7CFA", hash_generated_method = "425EF329D426AD1C4036D30810F67CF2")
    public SIPTransactionStack getSIPStack() {
        SIPTransactionStack varB4EAC82CA7396A68D541C85D26508E83_484480718 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_484480718 = (SIPTransactionStack) sipStack;
        varB4EAC82CA7396A68D541C85D26508E83_484480718.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_484480718;
        // ---------- Original Method ----------
        //return (SIPTransactionStack) sipStack;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.091 -0400", hash_original_method = "4D24925E393EE43229BBE6696196C496", hash_generated_method = "952B7BB5756BFAD4A1ED49EA630F8082")
    public String getPeerAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_1868126498 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1868126498 = this.peerAddress;
        varB4EAC82CA7396A68D541C85D26508E83_1868126498.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1868126498;
        // ---------- Original Method ----------
        //return this.peerAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.091 -0400", hash_original_method = "A1F90D00B31019C3C4E0EAACEB8565BB", hash_generated_method = "952A0B1DB1B0F5CFAC53A1A26C6370FC")
    public int getPeerPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1558433829 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1558433829;
        // ---------- Original Method ----------
        //return this.peerPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.093 -0400", hash_original_method = "D72195827AEF451FEF473FAF2B8F43B1", hash_generated_method = "E57F0AF3C3E9CEB03665748241E02E90")
    public int getPeerPacketSourcePort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_866100031 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_866100031;
        // ---------- Original Method ----------
        //return this.peerPacketSourcePort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.097 -0400", hash_original_method = "46454A41BD800FBE664B92E119C6A2FF", hash_generated_method = "233DE35051E9E4D39CC822BF81BA1BAD")
    public InetAddress getPeerPacketSourceAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1318261297 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1318261297 = this.peerPacketSourceAddress;
        varB4EAC82CA7396A68D541C85D26508E83_1318261297.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1318261297;
        // ---------- Original Method ----------
        //return this.peerPacketSourceAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.097 -0400", hash_original_method = "DE04102C176E73364B597E64B8D5F233", hash_generated_method = "15E3785E956CBDEF1B48B7825AEF5C8C")
    protected InetAddress getPeerInetAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_2053415700 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2053415700 = this.peerInetAddress;
        varB4EAC82CA7396A68D541C85D26508E83_2053415700.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2053415700;
        // ---------- Original Method ----------
        //return this.peerInetAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.098 -0400", hash_original_method = "DB79607DA3ACB5FA2D24428DF2713F98", hash_generated_method = "3FABF6B746558C4DD0F1F3339AB2E921")
    protected String getPeerProtocol() {
        String varB4EAC82CA7396A68D541C85D26508E83_560500266 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_560500266 = this.peerProtocol;
        varB4EAC82CA7396A68D541C85D26508E83_560500266.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_560500266;
        // ---------- Original Method ----------
        //return this.peerProtocol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.100 -0400", hash_original_method = "AEF0860991248E9299E1C6DDE1EF560C", hash_generated_method = "7E991777EBCD5B22CCAC0B21CA2F8866")
    public String getTransport() {
        String varB4EAC82CA7396A68D541C85D26508E83_415334554 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_415334554 = encapsulatedChannel.getTransport();
        varB4EAC82CA7396A68D541C85D26508E83_415334554.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_415334554;
        // ---------- Original Method ----------
        //return encapsulatedChannel.getTransport();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.102 -0400", hash_original_method = "6845103B04473D4A2057FADE28E7D0AA", hash_generated_method = "EF798EFABDF89373E819CB34F9D36D2B")
    public boolean isReliable() {
        boolean varB6C6105558E567E57AF146479D660091_1416637487 = (encapsulatedChannel.isReliable());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_179738855 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_179738855;
        // ---------- Original Method ----------
        //return encapsulatedChannel.isReliable();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.107 -0400", hash_original_method = "088E950799411477D094809B385ED56E", hash_generated_method = "88BEDDA23E06B5E597C8F70FC5726275")
    public Via getViaHeader() {
        Via varB4EAC82CA7396A68D541C85D26508E83_494132072 = null; //Variable for return #1
        Via channelViaHeader;
        channelViaHeader = super.getViaHeader();
        try 
        {
            channelViaHeader.setBranch(branch);
        } //End block
        catch (java.text.ParseException ex)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_494132072 = channelViaHeader;
        varB4EAC82CA7396A68D541C85D26508E83_494132072.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_494132072;
        // ---------- Original Method ----------
        //Via channelViaHeader;
        //channelViaHeader = super.getViaHeader();
        //try {
            //channelViaHeader.setBranch(branch);
        //} catch (java.text.ParseException ex) {
        //}
        //return channelViaHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.108 -0400", hash_original_method = "937EBFADC181BFE1D9D7AD4237E3287B", hash_generated_method = "26F2F46D174B09C0DAE699510A09E4C4")
    public void sendMessage(SIPMessage messageToSend) throws IOException {
        try 
        {
            encapsulatedChannel.sendMessage(messageToSend,
                    this.peerInetAddress, this.peerPort);
        } //End block
        finally 
        {
            this.startTransactionTimer();
        } //End block
        addTaint(messageToSend.getTaint());
        // ---------- Original Method ----------
        //try {
            //encapsulatedChannel.sendMessage(messageToSend,
                    //this.peerInetAddress, this.peerPort);
        //} finally {
            //this.startTransactionTimer();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.109 -0400", hash_original_method = "40115A27A95909E2CE679A790D4014C9", hash_generated_method = "6AD47456D0BE849C62F5DE77D81CE421")
    protected void sendMessage(byte[] messageBytes,
            InetAddress receiverAddress, int receiverPort, boolean retry) throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new IOException(
                "Cannot send unparsed message through Transaction Channel!");
        addTaint(messageBytes[0]);
        addTaint(receiverAddress.getTaint());
        addTaint(receiverPort);
        addTaint(retry);
        // ---------- Original Method ----------
        //throw new IOException(
                //"Cannot send unparsed message through Transaction Channel!");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.111 -0400", hash_original_method = "72CEDACA72EC4BC352365F84C4504BD8", hash_generated_method = "D18661C9B55695D2AF5DB01C974F3EE6")
    public void addEventListener(SIPTransactionEventListener newListener) {
        eventListeners.add(newListener);
        addTaint(newListener.getTaint());
        // ---------- Original Method ----------
        //eventListeners.add(newListener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.111 -0400", hash_original_method = "668B9893C68F9233FC28CF7C4E017F56", hash_generated_method = "732A8B0CA11B744E2AD558CB25CFDB80")
    public void removeEventListener(SIPTransactionEventListener oldListener) {
        eventListeners.remove(oldListener);
        addTaint(oldListener.getTaint());
        // ---------- Original Method ----------
        //eventListeners.remove(oldListener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.114 -0400", hash_original_method = "38D8606DEF077947D947856564D84874", hash_generated_method = "FA4AFB5D1FE28D6FB1A367BE2798AC54")
    protected void raiseErrorEvent(int errorEventID) {
        SIPTransactionErrorEvent newErrorEvent;
        Iterator<SIPTransactionEventListener> listenerIterator;
        SIPTransactionEventListener nextListener;
        newErrorEvent = new SIPTransactionErrorEvent(this, errorEventID);
        {
            listenerIterator = eventListeners.iterator();
            {
                boolean var20BE331F515CCC1CE643C3890EEC5ABE_1800578197 = (listenerIterator.hasNext());
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
                boolean var382FAAF04356B7108B4D034147E328B4_438718171 = (this instanceof SIPServerTransaction && this.isByeTransaction()
                    && this.getDialog() != null);
                ((SIPDialog) this.getDialog())
                        .setState(SIPDialog.TERMINATED_STATE);
            } //End collapsed parenthetic
        } //End block
        addTaint(errorEventID);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.116 -0400", hash_original_method = "1EC803C9686336CE6058D1F41391EBE2", hash_generated_method = "EC7478849F743490C4B18646453FF8E4")
    protected boolean isServerTransaction() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_629346159 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_629346159;
        // ---------- Original Method ----------
        //return this instanceof SIPServerTransaction;
    }

    
    public abstract Dialog getDialog();

    
    public abstract void setDialog(SIPDialog sipDialog, String dialogId);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.122 -0400", hash_original_method = "A1D654E2B8EB18DBD9E2FBE3DBA84F3D", hash_generated_method = "D5FAA986CB6FDCEB76DB0BB3B6257562")
    public int getRetransmitTimer() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_754823096 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_754823096;
        // ---------- Original Method ----------
        //return SIPTransactionStack.BASE_TIMER_INTERVAL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.125 -0400", hash_original_method = "310B5DE4F217FB57953AC74F889ED704", hash_generated_method = "9417A3643F42812BB10E811FAAA1BC41")
    public String getViaHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_1661837448 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1661837448 = this.getViaHeader().getHost();
        varB4EAC82CA7396A68D541C85D26508E83_1661837448.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1661837448;
        // ---------- Original Method ----------
        //return this.getViaHeader().getHost();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.125 -0400", hash_original_method = "025E14F038A1EDFF743C73F970E03870", hash_generated_method = "1B5E589E4869A5ABF59EB205BE8C274B")
    public SIPResponse getLastResponse() {
        SIPResponse varB4EAC82CA7396A68D541C85D26508E83_1041150007 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1041150007 = this.lastResponse;
        varB4EAC82CA7396A68D541C85D26508E83_1041150007.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1041150007;
        // ---------- Original Method ----------
        //return this.lastResponse;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.130 -0400", hash_original_method = "260B447AD36FE2CA2411AAAD920B4F1F", hash_generated_method = "36CA70C4F2E882D6545373E173D9FF6C")
    public Response getResponse() {
        Response varB4EAC82CA7396A68D541C85D26508E83_1199179558 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1199179558 = (Response) this.lastResponse;
        varB4EAC82CA7396A68D541C85D26508E83_1199179558.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1199179558;
        // ---------- Original Method ----------
        //return (Response) this.lastResponse;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.130 -0400", hash_original_method = "AB08BB44F7439305FB61E3E9EFAC9224", hash_generated_method = "53DA49A97740372FE213858F36974E98")
    public String getTransactionId() {
        String varB4EAC82CA7396A68D541C85D26508E83_940047145 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_940047145 = this.transactionId;
        varB4EAC82CA7396A68D541C85D26508E83_940047145.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_940047145;
        // ---------- Original Method ----------
        //return this.transactionId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.131 -0400", hash_original_method = "1EE454052F2EC55F5023F8455F33FFAA", hash_generated_method = "AC47436018999387E53D4A6299B36DD1")
    public int hashCode() {
        int var4C9151DE19A39E85210081D04497D7ED_1794443363 = (this.transactionId.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1877075267 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1877075267;
        // ---------- Original Method ----------
        //if (this.transactionId == null)
            //return -1;
        //else
            //return this.transactionId.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.131 -0400", hash_original_method = "F3BD37ECEE52D7438ECD340DC4DAF3CA", hash_generated_method = "CCB4C18470CAC05DAB81E834978E1C90")
    public int getViaPort() {
        int var0C6CDC10F459777D891ECCDB8DB39867_1571142363 = (this.getViaHeader().getPort());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_954410985 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_954410985;
        // ---------- Original Method ----------
        //return this.getViaHeader().getPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.138 -0400", hash_original_method = "4C1135E1FB3652D771084DD3A5E7B7E8", hash_generated_method = "7F843460326AD0FF1807EBF9DBEA19A3")
    public boolean doesCancelMatchTransaction(SIPRequest requestToTest) {
        ViaList viaHeaders;
        Via topViaHeader;
        String messageBranch;
        boolean transactionMatches;
        transactionMatches = false;
        {
            boolean varDB3FC80D18EEB586685397AA66CD0AD9_1649840269 = (this.getOriginalRequest() == null
                || this.getOriginalRequest().getMethod().equals(Request.CANCEL));
        } //End collapsed parenthetic
        viaHeaders = requestToTest.getViaHeaders();
        {
            topViaHeader = (Via) viaHeaders.getFirst();
            messageBranch = topViaHeader.getBranch();
            {
                {
                    boolean var36D9A4D2906CC61B64FFF3E977E71366_1900718711 = (!messageBranch.toLowerCase().startsWith(SIPConstants.BRANCH_MAGIC_COOKIE_LOWER_CASE));
                    {
                        messageBranch = null;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean varD825878E5C71E9D99195551828F9E150_2060830920 = (messageBranch != null && this.getBranch() != null);
                {
                    {
                        boolean var40A3BE5C85F3B3E698DEE2FF2DE53418_704437587 = (getBranch().equalsIgnoreCase(messageBranch)
                        && topViaHeader.getSentBy().equals(
                                ((Via) getOriginalRequest().getViaHeaders()
                                        .getFirst()).getSentBy()));
                        {
                            transactionMatches = true;
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_507799284 = (sipStack.isLoggingEnabled());
                                sipStack.getStackLogger().logDebug("returning  true");
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1478259946 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger().logDebug("testing against "
                            + getOriginalRequest());
                    } //End collapsed parenthetic
                    {
                        boolean varF49D98EFFEE05A7D0E6524281A64A821_429701916 = (getOriginalRequest().getRequestURI().equals(
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
        addTaint(requestToTest.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_136631608 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_136631608;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.142 -0400", hash_original_method = "348CFFAB37D4D83E29A04C573F3FF487", hash_generated_method = "420E73C26504AFDD4408E94B797B52D7")
    public void setRetransmitTimer(int retransmitTimer) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "Retransmit timer must be positive!");
        {
            boolean varD45EC8E193CE555496F99346397FAFE2_3993598 = (this.transactionTimerStarted.get());
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "Transaction timer is already started");
        } //End collapsed parenthetic
        BASE_TIMER_INTERVAL = retransmitTimer;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.143 -0400", hash_original_method = "45CE0F911469E288CC97776E84414496", hash_generated_method = "44A971061513681A3634FDD4C4C576B1")
    public void close() {
        this.encapsulatedChannel.close();
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_900097291 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug("Closing " + this.encapsulatedChannel);
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //this.encapsulatedChannel.close();
        //if (sipStack.isLoggingEnabled())
            //sipStack.getStackLogger().logDebug("Closing " + this.encapsulatedChannel);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.144 -0400", hash_original_method = "905D593C098EC8A0BB1DC95C9B54F441", hash_generated_method = "B206A43C6BC7C0DE4AF3914515235952")
    public boolean isSecure() {
        boolean var48C9EE19D6C5FA52907CC989AE9A3A00_1418589959 = (encapsulatedChannel.isSecure());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_197889044 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_197889044;
        // ---------- Original Method ----------
        //return encapsulatedChannel.isSecure();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.150 -0400", hash_original_method = "9C4DCEACA96616F074242810B487B970", hash_generated_method = "FA1C898D5615B49531276E1364D56148")
    public MessageProcessor getMessageProcessor() {
        MessageProcessor varB4EAC82CA7396A68D541C85D26508E83_2022886770 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2022886770 = this.encapsulatedChannel.getMessageProcessor();
        varB4EAC82CA7396A68D541C85D26508E83_2022886770.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2022886770;
        // ---------- Original Method ----------
        //return this.encapsulatedChannel.getMessageProcessor();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.151 -0400", hash_original_method = "552E0456C33D24CD63C8EBCDAC1D019B", hash_generated_method = "E17DD994BC845C3BDBBD70ECC432242E")
    public void setApplicationData(Object applicationData) {
        this.applicationData = applicationData;
        // ---------- Original Method ----------
        //this.applicationData = applicationData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.157 -0400", hash_original_method = "5F924FC61375970A4DC758380BEBFF0F", hash_generated_method = "28EF6542A67291F93B26615929E3952B")
    public Object getApplicationData() {
        Object varB4EAC82CA7396A68D541C85D26508E83_866902549 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_866902549 = this.applicationData;
        varB4EAC82CA7396A68D541C85D26508E83_866902549.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_866902549;
        // ---------- Original Method ----------
        //return this.applicationData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.158 -0400", hash_original_method = "739B4CAA187BE9D487A452627B0424A2", hash_generated_method = "3E247DA8F2E347E80DAB817F941F23BE")
    public void setEncapsulatedChannel(MessageChannel messageChannel) {
        this.encapsulatedChannel = messageChannel;
        this.peerInetAddress = messageChannel.getPeerInetAddress();
        this.peerPort = messageChannel.getPeerPort();
        // ---------- Original Method ----------
        //this.encapsulatedChannel = messageChannel;
        //this.peerInetAddress = messageChannel.getPeerInetAddress();
        //this.peerPort = messageChannel.getPeerPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.159 -0400", hash_original_method = "38ECF920BD32EC6B95BB00C4AAD637BA", hash_generated_method = "383135447A9808D37258B73E088FFECB")
    public SipProviderImpl getSipProvider() {
        SipProviderImpl varB4EAC82CA7396A68D541C85D26508E83_371904765 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_371904765 = this.getMessageProcessor().getListeningPoint().getProvider();
        varB4EAC82CA7396A68D541C85D26508E83_371904765.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_371904765;
        // ---------- Original Method ----------
        //return this.getMessageProcessor().getListeningPoint().getProvider();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.160 -0400", hash_original_method = "BA06BB4C0270C8B47C1CBBF5F94DA61A", hash_generated_method = "3EEAE2E16E1E1E4E008482EA45741ACC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.168 -0400", hash_original_method = "9C758C929345C5BD5429DB309FDFD6EA", hash_generated_method = "7A558532AFA609D6743457EBCC47BD6D")
    public boolean acquireSem() {
        boolean retval;
        retval = false;
        try 
        {
            {
                boolean var0C9E46B9F84667219FF0963258285136_1314193285 = (sipStack.getStackLogger().isLoggingEnabled());
                {
                    sipStack.getStackLogger().logDebug("acquireSem [[[[" + this);
                    sipStack.getStackLogger().logStackTrace();
                } //End block
            } //End collapsed parenthetic
            retval = this.semaphore.tryAcquire(1000, TimeUnit.MILLISECONDS);
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_2062876430 = (sipStack.isLoggingEnabled());
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_757212408 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_757212408;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.169 -0400", hash_original_method = "301846C685CE876D86A6B4185A591E30", hash_generated_method = "2E46BBF6796C78AED74045C8C40488CD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.174 -0400", hash_original_method = "DBC24F6DB4FEFD7D7F8639708567DC35", hash_generated_method = "8D75F4AC94E9A7EFA5B7577842D8AC40")
    protected void semRelease() {
        try 
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_578701997 = (sipStack.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.174 -0400", hash_original_method = "39E9029186E8CC55AF8CBCC68EB9597C", hash_generated_method = "1A8D38742F27E67931A98D72EC494DC9")
    public boolean passToListener() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1110547491 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1110547491;
        // ---------- Original Method ----------
        //return toListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.182 -0400", hash_original_method = "F5F4C78B3DFF0EDA40F4B14C1017F836", hash_generated_method = "C5A58817911E93F553BF36871ED8BE3C")
    public void setPassToListener() {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_484636270 = (sipStack.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.186 -0400", hash_original_method = "5D50ECFAFAF878A5B29EF8C830BE2C71", hash_generated_method = "34DDE38DF8E5F446E66CEF268EF113F8")
    protected synchronized boolean testAndSetTransactionTerminatedEvent() {
        boolean retval;
        retval = !this.terminatedEventDelivered;
        this.terminatedEventDelivered = true;
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1630110175 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1630110175;
        // ---------- Original Method ----------
        //boolean retval = !this.terminatedEventDelivered;
        //this.terminatedEventDelivered = true;
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.194 -0400", hash_original_method = "0D2015A100DFE7954256C577DAEBD143", hash_generated_method = "128F6D22FC238ED31A7D9ED999F04B8B")
    public String getCipherSuite() throws UnsupportedOperationException {
        String varB4EAC82CA7396A68D541C85D26508E83_257676830 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_40773224 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1938858421 = null; //Variable for return #3
        {
            boolean var6C6A2C453D42291A755997484653A937_2110605115 = (this.getMessageChannel() instanceof TLSMessageChannel);
            {
                {
                    boolean varFCE35EDD0B032F5EB8C912B15CF85890_1140547274 = (((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener() == null);
                    varB4EAC82CA7396A68D541C85D26508E83_257676830 = null;
                    {
                        boolean var39C45FA9CE575184B384B180A37212E6_167884675 = (((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener().getHandshakeCompletedEvent() == null);
                        varB4EAC82CA7396A68D541C85D26508E83_40773224 = null;
                        varB4EAC82CA7396A68D541C85D26508E83_1938858421 = ((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener().getHandshakeCompletedEvent().getCipherSuite();
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Not a TLS channel");
        } //End collapsed parenthetic
        String varA7E53CE21691AB073D9660D615818899_992154204; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_992154204 = varB4EAC82CA7396A68D541C85D26508E83_257676830;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_992154204 = varB4EAC82CA7396A68D541C85D26508E83_40773224;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_992154204 = varB4EAC82CA7396A68D541C85D26508E83_1938858421;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_992154204.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_992154204;
        // ---------- Original Method ----------
        //if (this.getMessageChannel() instanceof TLSMessageChannel ) {
            //if (  ((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener() == null ) 
                //return null;
            //else if ( ((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener().getHandshakeCompletedEvent() == null)
                //return null;
            //else return ((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener().getHandshakeCompletedEvent().getCipherSuite();
        //} else throw new UnsupportedOperationException("Not a TLS channel");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.200 -0400", hash_original_method = "1BD353D03C47A7F0291FB8AF92EA1899", hash_generated_method = "FF5DE7CDDC9DAC983ECCC725E3C8406E")
    public java.security.cert.Certificate[] getLocalCertificates() throws UnsupportedOperationException {
        java.security.cert.Certificate[] varB4EAC82CA7396A68D541C85D26508E83_2103252726 = null; //Variable for return #1
        java.security.cert.Certificate[] varB4EAC82CA7396A68D541C85D26508E83_1015898528 = null; //Variable for return #2
        java.security.cert.Certificate[] varB4EAC82CA7396A68D541C85D26508E83_1137041223 = null; //Variable for return #3
        {
            boolean var6C6A2C453D42291A755997484653A937_217432546 = (this.getMessageChannel() instanceof TLSMessageChannel);
            {
                {
                    boolean varFCE35EDD0B032F5EB8C912B15CF85890_1003437586 = (((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener() == null);
                    varB4EAC82CA7396A68D541C85D26508E83_2103252726 = null;
                    {
                        boolean var39C45FA9CE575184B384B180A37212E6_1565209905 = (((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener().getHandshakeCompletedEvent() == null);
                        varB4EAC82CA7396A68D541C85D26508E83_1015898528 = null;
                        varB4EAC82CA7396A68D541C85D26508E83_1137041223 = ((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener().getHandshakeCompletedEvent().getLocalCertificates();
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Not a TLS channel");
        } //End collapsed parenthetic
        java.security.cert.Certificate[] varA7E53CE21691AB073D9660D615818899_2022130768; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2022130768 = varB4EAC82CA7396A68D541C85D26508E83_2103252726;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_2022130768 = varB4EAC82CA7396A68D541C85D26508E83_1015898528;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2022130768 = varB4EAC82CA7396A68D541C85D26508E83_1137041223;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2022130768.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2022130768;
        // ---------- Original Method ----------
        //if (this.getMessageChannel() instanceof TLSMessageChannel ) {
            //if (  ((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener() == null ) 
                //return null;
            //else if ( ((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener().getHandshakeCompletedEvent() == null)
                //return null;
            //else return ((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener().getHandshakeCompletedEvent().getLocalCertificates();
        //} else throw new UnsupportedOperationException("Not a TLS channel");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.205 -0400", hash_original_method = "425975E25339AF497E9130895A1F6EC3", hash_generated_method = "D2873482E002D51A68476C3A9C45446A")
    public java.security.cert.Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
        java.security.cert.Certificate[] varB4EAC82CA7396A68D541C85D26508E83_298328084 = null; //Variable for return #1
        java.security.cert.Certificate[] varB4EAC82CA7396A68D541C85D26508E83_793572361 = null; //Variable for return #2
        java.security.cert.Certificate[] varB4EAC82CA7396A68D541C85D26508E83_431850595 = null; //Variable for return #3
        {
            boolean var6C6A2C453D42291A755997484653A937_764067118 = (this.getMessageChannel() instanceof TLSMessageChannel);
            {
                {
                    boolean varFCE35EDD0B032F5EB8C912B15CF85890_2053701198 = (((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener() == null);
                    varB4EAC82CA7396A68D541C85D26508E83_298328084 = null;
                    {
                        boolean var39C45FA9CE575184B384B180A37212E6_644749309 = (((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener().getHandshakeCompletedEvent() == null);
                        varB4EAC82CA7396A68D541C85D26508E83_793572361 = null;
                        varB4EAC82CA7396A68D541C85D26508E83_431850595 = ((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener().getHandshakeCompletedEvent().getPeerCertificates();
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Not a TLS channel");
        } //End collapsed parenthetic
        java.security.cert.Certificate[] varA7E53CE21691AB073D9660D615818899_2063190777; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2063190777 = varB4EAC82CA7396A68D541C85D26508E83_298328084;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_2063190777 = varB4EAC82CA7396A68D541C85D26508E83_793572361;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2063190777 = varB4EAC82CA7396A68D541C85D26508E83_431850595;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2063190777.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2063190777;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.212 -0400", hash_original_method = "4F6152921EA187210C4EA8258CD889E1", hash_generated_method = "64B08E3D3C5CA24FB47520E4C67942FD")
        public  LingerTimer() {
            SIPTransaction sipTransaction;
            sipTransaction = SIPTransaction.this;
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_693783998 = (sipStack.isLoggingEnabled());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.213 -0400", hash_original_method = "14B41A6E0BE7E84E900DADE7EB6E3A9A", hash_generated_method = "4EF22D3A1E042797B585EADD93D561C0")
        protected void runTask() {
            SIPTransaction transaction;
            transaction = SIPTransaction.this;
            SIPTransactionStack sipStack;
            sipStack = transaction.getSIPStack();
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1766577491 = (sipStack.isLoggingEnabled());
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
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1567770299 = (sipStack.isLoggingEnabled());
                    sipStack.getStackLogger().logDebug("removing" + transaction);
                } //End collapsed parenthetic
                sipStack.removeTransaction(transaction);
                {
                    transaction.close();
                } //End block
                {
                    {
                        boolean var4956126C243BADFE0BCC10A3ADC78702_1536540500 = (sipStack.isLoggingEnabled()
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.213 -0400", hash_original_field = "A416A668043B482EFC2F2325D3EC1153", hash_generated_field = "3B40D817B2BE2804F9DB84AD6F523C19")

    protected static int T1 = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.213 -0400", hash_original_field = "41507773B89CE446DCAC23DD50F37819", hash_generated_field = "2C502BD351A97F797EE62F32FA29DDA2")

    protected static int TIMER_A = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.213 -0400", hash_original_field = "C712D1D637F4061683A4B32D6EF6874E", hash_generated_field = "C6E57D2CEC59891A80BF99C6DDF9A206")

    protected static int TIMER_B = 64;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.213 -0400", hash_original_field = "06269F326966D3ACA4950A4B6EE7EA0B", hash_generated_field = "1CF60E2820C89E4CBBE062F750FEA6EB")

    protected static int TIMER_J = 64;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.213 -0400", hash_original_field = "51D1F67E03F85531F794EFC17953564E", hash_generated_field = "12A682BD09F055F530FE5794F659583B")

    protected static int TIMER_F = 64;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.213 -0400", hash_original_field = "5DA06C034F975ABA139B09C72EAD0872", hash_generated_field = "7E8AD7820C67E498ED0F2020296133DE")

    protected static int TIMER_H = 64;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.213 -0400", hash_original_field = "CC18DC3FB7CE731BAD3934F245CE3454", hash_generated_field = "8BA3A0ADBD6ABEEE2C128AA938AC9DE1")

    public static final TransactionState INITIAL_STATE = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.214 -0400", hash_original_field = "9226F430E079BC77D0322347132C7EE8", hash_generated_field = "D317B7F0EDCFF7869AC099F8F60A26C5")

    public static final TransactionState TRYING_STATE = TransactionState.TRYING;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.214 -0400", hash_original_field = "558B4EE8481E9F9FC0DAA8CB1CA500C8", hash_generated_field = "7694E1BD134F3AABB468EB52BEB662A9")

    public static final TransactionState CALLING_STATE = TransactionState.CALLING;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.214 -0400", hash_original_field = "2182728F7F14AB8E9B791431AC114DA8", hash_generated_field = "06F5AD8C442768658EEA785254674FFF")

    public static final TransactionState PROCEEDING_STATE = TransactionState.PROCEEDING;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.214 -0400", hash_original_field = "044D7AD2DD976AB03066B86B5AD02515", hash_generated_field = "F0F4AEFF89B151D97D57677046A3B234")

    public static final TransactionState COMPLETED_STATE = TransactionState.COMPLETED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.214 -0400", hash_original_field = "4A6DD65DC912AE7BAD7804C7F87D3681", hash_generated_field = "EBCB27C78436E501BBCA8D4CD1A806C2")

    public static final TransactionState CONFIRMED_STATE = TransactionState.CONFIRMED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.214 -0400", hash_original_field = "1D290254DA712EE27D9F5047A872DF10", hash_generated_field = "B19BF2F78FE0062DCD29ACB945A7A8B5")

    public static final TransactionState TERMINATED_STATE = TransactionState.TERMINATED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.214 -0400", hash_original_field = "C031D221A72791D98EF5BFC8F90FBED8", hash_generated_field = "1AF957046B45D89EE908F5862217FEBB")

    protected static int MAXIMUM_RETRANSMISSION_TICK_COUNT = 8;
}

