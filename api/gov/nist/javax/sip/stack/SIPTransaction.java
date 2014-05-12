package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.652 -0500", hash_original_field = "C48E128D2D995ECD355B667DB9DC7865", hash_generated_field = "115540986CC405054C766E7CD52F37AE")

    /**
     * One timer tick.
     */
    protected static final int T1 = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.655 -0500", hash_original_field = "D416FB8FC3A93D1547923471AFEB1487", hash_generated_field = "7E2D9869BDB9045700E8D821F4588BDF")

    protected static final int TIMER_A = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.658 -0500", hash_original_field = "420E92C743D27E6D29FDDA91FB7D346A", hash_generated_field = "93B7D7F2080EBBB3787D866882928B33")

    protected static final int TIMER_B = 64;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.661 -0500", hash_original_field = "7C8240DF42B3EF9F24013B95BCDBFB1D", hash_generated_field = "C6478F3FDDFCC7A5866A29DA158AC357")

    protected static final int TIMER_J = 64;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.665 -0500", hash_original_field = "631676DFE4B8570701C17A5CEF0CB3E2", hash_generated_field = "A9B44A5318402784FF69AC6DA430A9D6")

    protected static final int TIMER_F = 64;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.669 -0500", hash_original_field = "FF12C6903D72287F3A749EF15CEEC191", hash_generated_field = "3DE8E426A4F01136C7ECA20307DAE43A")

    protected static final int TIMER_H = 64;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.692 -0500", hash_original_field = "4471FE1B07D942C7EC5CFFABD9EC2C78", hash_generated_field = "8BA3A0ADBD6ABEEE2C128AA938AC9DE1")

    public static final TransactionState INITIAL_STATE = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.697 -0500", hash_original_field = "D6DFCD4E204CCDC6188B934CF0CBA63E", hash_generated_field = "D317B7F0EDCFF7869AC099F8F60A26C5")

    public static final TransactionState TRYING_STATE = TransactionState.TRYING;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.700 -0500", hash_original_field = "AB3B67F5E75DC615E4B236085814A66E", hash_generated_field = "7694E1BD134F3AABB468EB52BEB662A9")

    public static final TransactionState CALLING_STATE = TransactionState.CALLING;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.703 -0500", hash_original_field = "C09516349AE203147AB4A3309CFA7333", hash_generated_field = "06F5AD8C442768658EEA785254674FFF")

    public static final TransactionState PROCEEDING_STATE = TransactionState.PROCEEDING;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.707 -0500", hash_original_field = "9D482A863A2525A731269DBFDE6D4AA3", hash_generated_field = "F0F4AEFF89B151D97D57677046A3B234")

    public static final TransactionState COMPLETED_STATE = TransactionState.COMPLETED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.710 -0500", hash_original_field = "B3C0209D4476909E2F0B64E4B87C9BF5", hash_generated_field = "EBCB27C78436E501BBCA8D4CD1A806C2")

    public static final TransactionState CONFIRMED_STATE = TransactionState.CONFIRMED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.714 -0500", hash_original_field = "D8E083DE8E33C5E11D244529A76F5A60", hash_generated_field = "B19BF2F78FE0062DCD29ACB945A7A8B5")

    public static final TransactionState TERMINATED_STATE = TransactionState.TERMINATED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.717 -0500", hash_original_field = "9D8EBA879713EC8088C2E60E88047653", hash_generated_field = "F8F7C8DEA67FC9F18B9E1E40A34E4804")

    protected static final int MAXIMUM_RETRANSMISSION_TICK_COUNT = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.631 -0500", hash_original_field = "60589DB47E64126DB50F2DE120378B21", hash_generated_field = "E1D4E9B3AAF496FD813808775B58AFF8")

    protected boolean toListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.634 -0500", hash_original_field = "02AE635AE3A9EF05DA6A2314A26493C6", hash_generated_field = "FDF4F4F2AA2747767646A2DD5D5D03CF")

    // to see the event.

    protected int BASE_TIMER_INTERVAL = SIPTransactionStack.BASE_TIMER_INTERVAL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.637 -0500", hash_original_field = "BF2FEC40E9BA2F66E6A68643E277A1C2", hash_generated_field = "AFFFDDF9E03C18C4462622216D1D744E")

    protected int T4 = 5000 / BASE_TIMER_INTERVAL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.641 -0500", hash_original_field = "6792D27A0ADB06B4A8636A672B277DEE", hash_generated_field = "5AB93F413E7E37621B4D5A565BACE4EE")

    protected int T2 = 4000 / BASE_TIMER_INTERVAL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.644 -0500", hash_original_field = "27E00605042ADDECFED70A7BBF3A35D5", hash_generated_field = "9F72081078574EE44AD3339670F6DF1F")

    protected int TIMER_I = T4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.646 -0500", hash_original_field = "E6098CA7D6D7E3673D3864DA3BE9CA49", hash_generated_field = "CA8408AC31A4B160960A20C24156B7EC")

    protected int TIMER_K = T4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.649 -0500", hash_original_field = "D34273A598627E74D049234838654274", hash_generated_field = "46098F3DF9CF80FB6A2FF1FF700C1E30")

    protected int TIMER_D = 32000 / BASE_TIMER_INTERVAL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.672 -0500", hash_original_field = "324CFAE3E8224AEDE88E789E229FDCE3", hash_generated_field = "B1A8E011179EF40B9DAC21E1148B1B78")

    protected transient Object applicationData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.675 -0500", hash_original_field = "1512DDEB34EA4DFEA7B165ECD6EE2EE0", hash_generated_field = "8CE24F874A42F410B23EF4851613017C")

    protected SIPResponse lastResponse;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.678 -0500", hash_original_field = "6CD30DCE01D3C4ED7016B14B9A35419D", hash_generated_field = "77FEBEAA4AF79617A8B0CBB244F26247")

    protected boolean isMapped;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.680 -0500", hash_original_field = "CC86BA0F6C88FCD5858CE5B76B3292DC", hash_generated_field = "3F41BA6F3B911D0AFE0A127EF365871F")

    private Semaphore semaphore;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.683 -0500", hash_original_field = "8FB3D491B16783705CA8935697DACBBC", hash_generated_field = "30E9188AD86CBF24A584DD99B37E6A4C")

    protected boolean isSemaphoreAquired;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.686 -0500", hash_original_field = "FA725AFE9A3B4550941F34A1204CD790", hash_generated_field = "CF0800764F7E78B484B9CDAF42BF922A")

    // here.

    protected String transactionId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.689 -0500", hash_original_field = "89446EA928FF624F1565F240BCD58AD7", hash_generated_field = "DC083CBA87D0EF543E9ADBF7A1B3A2FC")

    // Audit tag used by the SIP Stack audit
    public long auditTag = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.720 -0500", hash_original_field = "A4B05DD1A2BDFAA2E8FCD10E8D1815B6", hash_generated_field = "4664B9159D27EBBF3CF109F118F56F46")

    protected transient SIPTransactionStack sipStack;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.723 -0500", hash_original_field = "BD77875F08D47A4F03542967D7A8895C", hash_generated_field = "E987B06AF0DFCAA9F38DD607A12D9B39")

    protected SIPRequest originalRequest;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.726 -0500", hash_original_field = "4FEFE59A442C112954E2404DE0D21FCE", hash_generated_field = "25DB028ECDD75BE4977DFE05FC00F4D2")

    private transient MessageChannel encapsulatedChannel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.728 -0500", hash_original_field = "A714E58FF483C2E33F156CBA7BFCD38B", hash_generated_field = "6A69B321E52130622ADD35A2A3F00BA6")

    protected int peerPort;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.732 -0500", hash_original_field = "807474C8C9C79890FDD885AB0990D84B", hash_generated_field = "ACA9646C167AB8988D8D4678A1C02262")

    protected InetAddress peerInetAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.735 -0500", hash_original_field = "D5676AAB12B528025B67CF99F7A8F4EE", hash_generated_field = "C9738122113DFDEEF725F74B583F0EE7")

    protected String peerAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.738 -0500", hash_original_field = "D89E736D3DD25A80B53E476FF3F84027", hash_generated_field = "FBF73E4EC3FC246E9E63B41E9D9708E4")

    protected String peerProtocol;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.741 -0500", hash_original_field = "8AEBC2998B5E75EE998FC822539710AC", hash_generated_field = "A058668C2EAB6FEAB7356F120108ABDA")

    // Source port extracted from peer packet
    protected int peerPacketSourcePort;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.744 -0500", hash_original_field = "21FBD1F3C626244BE5AA333519378971", hash_generated_field = "AA48B9901BA1D417BEAE6C24D398429E")

    protected InetAddress peerPacketSourceAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.747 -0500", hash_original_field = "55EB381772C2F51E6AE0B4E72716ECCB", hash_generated_field = "C48464462DE8239144ADA7BDEA8A5336")

    protected AtomicBoolean transactionTimerStarted = new AtomicBoolean(false);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.750 -0500", hash_original_field = "E640BAC0D5E1BB8E3B462245AF7CD5BE", hash_generated_field = "30E846F477E8815819D75224F8F894EA")

    private String branch;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.753 -0500", hash_original_field = "842C170402669AC7A74293BBBFD3BC5D", hash_generated_field = "F42F15CDE806BBAD7F26F7952D68FCE2")

    private String method;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.755 -0500", hash_original_field = "64408540D2E0D2FFD63AC47CFF85D02F", hash_generated_field = "42D60DCE07190569B4FB5DBAE96EB838")

    private long cSeq;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.758 -0500", hash_original_field = "CA7BF7CC339403C9813E7E957B5E22A1", hash_generated_field = "1D3A2129BFAA64E672459DABFB968979")

    private TransactionState currentState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.762 -0500", hash_original_field = "037518F5FE101F688D436809244AB944", hash_generated_field = "E635400649257FF3CB3C8321A25A9521")

    private transient int retransmissionTimerLastTickCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.764 -0500", hash_original_field = "70B626A957DF19F06006E04466C8F348", hash_generated_field = "91834647ACD706C1011839DD85835F02")

    private transient int retransmissionTimerTicksLeft;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.767 -0500", hash_original_field = "7475C117572EA941AC4B923D5A2312BC", hash_generated_field = "3CE5B548E56A9CACC294CED8BA31ABAA")

    protected int timeoutTimerTicksLeft;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.770 -0500", hash_original_field = "5C0553CF9CA919840C1B9ACE152CF060", hash_generated_field = "17BD452206B118EF58DBF7409BE6123E")

    private transient Set<SIPTransactionEventListener> eventListeners;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.773 -0500", hash_original_field = "744E203B58F2BD725474A037E34EF98A", hash_generated_field = "FE5D1F0E178346BD9B131A6EBD4E1385")

    // transaction goes to  state. Pointers to these are kept around
    // for transaction matching as long as the transaction is in
    // the transaction table.
    protected From from;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.776 -0500", hash_original_field = "7646C5980A36BBF590201AE6FBC89CC1", hash_generated_field = "C448E6A4D656FF8991A12FB1F342B81A")

    protected To to;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.780 -0500", hash_original_field = "2F9DAAEB69CE1FC612F0199E6F2A4208", hash_generated_field = "45474E5168B474ED8B347CB237DE65F5")

    protected Event event;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.783 -0500", hash_original_field = "BF6182748B12F70AD82E571FD6959612", hash_generated_field = "A097F8113589FE8B954AAE5C2A8185B4")

    protected CallID callId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.786 -0500", hash_original_field = "23890D939F407637C863FECA5D2CD4A9", hash_generated_field = "6C7364C609E4DB2515878536D7BF2D7C")

    // private Object wrapper;

    // Counter for caching of connections.
    // Connection lingers for collectionTime
    // after the Transaction goes to terminated state.
    protected int collectionTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.789 -0500", hash_original_field = "3AAC19D3AAD98771FCD7661531696519", hash_generated_field = "2548F380843EE93CEFA1182D7B7D4CAB")

    protected String toTag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.791 -0500", hash_original_field = "DA9D0D47666E1A771165DC0266C76E6D", hash_generated_field = "2473B4AA5FDBB54683BF7F1A7022AFDB")

    protected String fromTag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.794 -0500", hash_original_field = "ADF7394CBDB72B8EF693EB823F6A872D", hash_generated_field = "A7AFFE900DA148C693A4DA5C908804C1")

    private boolean terminatedEventDelivered;

    /**
     * Transaction constructor.
     *
     * @param newParentStack
     *            Parent stack for this transaction.
     * @param newEncapsulatedChannel
     *            Underlying channel for this transaction.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.811 -0500", hash_original_method = "5F08F1F6762C0D715B46AA0C57E5FACB", hash_generated_method = "3E00E2E3D33C15A4D0EA6DB9A0DBAC4D")
    
protected SIPTransaction(SIPTransactionStack newParentStack,
            MessageChannel newEncapsulatedChannel) {

        sipStack = newParentStack;
        this.semaphore = new Semaphore(1,true);

        encapsulatedChannel = newEncapsulatedChannel;
        // Record this to check if the address has changed before sending
        // message to avoid possible race condition.
        this.peerPort = newEncapsulatedChannel.getPeerPort();
        this.peerAddress = newEncapsulatedChannel.getPeerAddress();
        this.peerInetAddress = newEncapsulatedChannel.getPeerInetAddress();
        // @@@ hagai
        this.peerPacketSourcePort = newEncapsulatedChannel
                .getPeerPacketSourcePort();
        this.peerPacketSourceAddress = newEncapsulatedChannel
                .getPeerPacketSourceAddress();
        this.peerProtocol = newEncapsulatedChannel.getPeerProtocol();
        if (this.isReliable()) {            
                encapsulatedChannel.useCount++;
                if (sipStack.isLoggingEnabled())
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

        // Always add the parent stack as a listener
        // of this transaction
        addEventListener(newParentStack);

    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.797 -0500", hash_original_method = "F0D7866FE2BBCD680DCAF285C3141724", hash_generated_method = "C76B605087214C261BD34AB52FA97DDC")
    
public String getBranchId() {
        return this.branch;
    }

    /**
     * Sets the request message that this transaction handles.
     *
     * @param newOriginalRequest
     *            Request being handled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.815 -0500", hash_original_method = "55609707D0B67BA3A76250F409DE303B", hash_generated_method = "1443A97B88BE09DA150E9E5EF642722D")
    
public void setOriginalRequest(SIPRequest newOriginalRequest) {

        // Branch value of topmost Via header
        String newBranch;

        if (this.originalRequest != null
                && (!this.originalRequest.getTransactionId().equals(
                        newOriginalRequest.getTransactionId()))) {
            sipStack.removeTransactionHash(this);
        }
        // This will be cleared later.

        this.originalRequest = newOriginalRequest;

        // just cache the control information so the
        // original request can be released later.
        this.method = newOriginalRequest.getMethod();
        this.from = (From) newOriginalRequest.getFrom();
        this.to = (To) newOriginalRequest.getTo();
        // Save these to avoid concurrent modification exceptions!
        this.toTag = this.to.getTag();
        this.fromTag = this.from.getTag();
        this.callId = (CallID) newOriginalRequest.getCallId();
        this.cSeq = newOriginalRequest.getCSeq().getSeqNumber();
        this.event = (Event) newOriginalRequest.getHeader("Event");
        this.transactionId = newOriginalRequest.getTransactionId();

        originalRequest.setTransaction(this);

        // If the message has an explicit branch value set,
        newBranch = ((Via) newOriginalRequest.getViaHeaders().getFirst())
                .getBranch();
        if (newBranch != null) {
            if (sipStack.isLoggingEnabled())
                sipStack.getStackLogger().logDebug("Setting Branch id : " + newBranch);

            // Override the default branch with the one
            // set by the message
            setBranch(newBranch);

        } else {
            if (sipStack.isLoggingEnabled())
                sipStack.getStackLogger().logDebug("Branch id is null - compute TID!"
                        + newOriginalRequest.encode());
            setBranch(newOriginalRequest.getTransactionId());
        }
    }

    /**
     * Gets the request being handled by this transaction.
     *
     * @return -- the original Request associated with this transaction.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.817 -0500", hash_original_method = "E55FA929D44B8592CC293995403E5C80", hash_generated_method = "3445A4A5351164C7D07F1537CFB52FCC")
    
public SIPRequest getOriginalRequest() {
        return originalRequest;
    }

    /**
     * Get the original request but cast to a Request structure.
     *
     * @return the request that generated this transaction.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.822 -0500", hash_original_method = "77DF64C3C6C54874FB57EB6F51047938", hash_generated_method = "147BA6BC6D1679C5064134534BAD968E")
    
public Request getRequest() {
        return (Request) originalRequest;
    }

    /**
     * Returns a flag stating whether this transaction is for an INVITE request
     * or not.
     *
     * @return -- true if this is an INVITE request, false if not.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.825 -0500", hash_original_method = "CD53B018E22B6706BBA3F591144F3E86", hash_generated_method = "E7A0E2CD41D8A27C9BCE35B0A31F47C0")
    
public final boolean isInviteTransaction() {
        return getMethod().equals(Request.INVITE);
    }

    /**
     * Return true if the transaction corresponds to a CANCEL message.
     *
     * @return -- true if the transaciton is a CANCEL transaction.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.828 -0500", hash_original_method = "BF9744C1CDF47773C8154FC6D9BF750F", hash_generated_method = "9F8D2EF41CDA261C98DECE7F15D1870E")
    
public final boolean isCancelTransaction() {
        return getMethod().equals(Request.CANCEL);
    }

    /**
     * Return a flag that states if this is a BYE transaction.
     *
     * @return true if the transaciton is a BYE transaction.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.831 -0500", hash_original_method = "B590647CF4DDAA4D2D7D3928C46D70C5", hash_generated_method = "E4A64426BCB2696BC6C78FEA03761FD5")
    
public final boolean isByeTransaction() {
        return getMethod().equals(Request.BYE);
    }

    /**
     * Returns the message channel used for transmitting/receiving messages for
     * this transaction. Made public in support of JAIN dual transaction model.
     *
     * @return Encapsulated MessageChannel.
     *
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.833 -0500", hash_original_method = "4873376BBCB3E7C4172E860864FE5E6F", hash_generated_method = "823E4EAD675179C9669F4BB534D4B0A6")
    
public MessageChannel getMessageChannel() {
        return encapsulatedChannel;
    }

    /**
     * Sets the Via header branch parameter used to identify this transaction.
     *
     * @param newBranch
     *            New string used as the branch for this transaction.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.836 -0500", hash_original_method = "E1AAF4400C28181416F2CF35F703EDD4", hash_generated_method = "261DB61A5EB2AA13D055802852059B1E")
    
public final void setBranch(String newBranch) {
        branch = newBranch;
    }

    /**
     * Gets the current setting for the branch parameter of this transaction.
     *
     * @return Branch parameter for this transaction.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.839 -0500", hash_original_method = "8CF2A0009E9AA335F31D8DE930BE32FD", hash_generated_method = "27B91CDA7AFC2B6991BA8D593E23ECA5")
    
public final String getBranch() {
        if (this.branch == null) {
            this.branch = getOriginalRequest().getTopmostVia().getBranch();
        }
        return branch;
    }

    /**
     * Get the method of the request used to create this transaction.
     *
     * @return the method of the request for the transaction.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.842 -0500", hash_original_method = "691C5451C67574E660997BC2056A5F23", hash_generated_method = "911549658842C84FE5B5B31D8B5FB4F0")
    
public final String getMethod() {
        return this.method;
    }

    /**
     * Get the Sequence number of the request used to create the transaction.
     *
     * @return the cseq of the request used to create the transaction.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.846 -0500", hash_original_method = "01D6A6E462A394F38C502658C03C7A92", hash_generated_method = "252059D8C2090BC4C66DE3866B8C6CFF")
    
public final long getCSeq() {
        return this.cSeq;
    }

    /**
     * Changes the state of this transaction.
     *
     * @param newState
     *            New state of this transaction.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.849 -0500", hash_original_method = "A4A5B758CCC2E3BD812410810F0DBFFC", hash_generated_method = "C6DF08C19D38F28C369FC490DD8D8975")
    
public void setState(TransactionState newState) {
        // PATCH submitted by sribeyron
        if (currentState == TransactionState.COMPLETED) {
            if (newState != TransactionState.TERMINATED
                    && newState != TransactionState.CONFIRMED)
                newState = TransactionState.COMPLETED;
        }
        if (currentState == TransactionState.CONFIRMED) {
            if (newState != TransactionState.TERMINATED)
                newState = TransactionState.CONFIRMED;
        }
        if (currentState != TransactionState.TERMINATED)
            currentState = newState;
        else
            newState = currentState;
        // END OF PATCH
        if (sipStack.isLoggingEnabled()) {
            sipStack.getStackLogger().logDebug("Transaction:setState " + newState
                    + " " + this + " branchID = " + this.getBranch()
                    + " isClient = " + (this instanceof SIPClientTransaction));
            sipStack.getStackLogger().logStackTrace();
        }
    }

    /**
     * Gets the current state of this transaction.
     *
     * @return Current state of this transaction.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.853 -0500", hash_original_method = "61525F5D630175E526789474B6CFB85F", hash_generated_method = "09130B50D1C08D40C47796C8BF125D24")
    
public TransactionState getState() {
        return this.currentState;
    }

    /**
     * Enables retransmission timer events for this transaction to begin in one
     * tick.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.856 -0500", hash_original_method = "C06C644410B862B7DEB29308419E2C70", hash_generated_method = "C04D788E22FF14F5A6D52CD4D3DEF982")
    
protected final void enableRetransmissionTimer() {
        enableRetransmissionTimer(1);
    }

    /**
     * Enables retransmission timer events for this transaction to begin after
     * the number of ticks passed to this routine.
     *
     * @param tickCount
     *            Number of ticks before the next retransmission timer event
     *            occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.859 -0500", hash_original_method = "69D842DACBECB66F6A3F4CBF6CAA3BE5", hash_generated_method = "805B1E4EFFDFF96D00CA82BBB74EAA69")
    
protected final void enableRetransmissionTimer(int tickCount) {
        // For INVITE Client transactions, double interval each time
        if (isInviteTransaction() && (this instanceof SIPClientTransaction)) {
            retransmissionTimerTicksLeft = tickCount;
        } else {
            // non-INVITE transactions and 3xx-6xx responses are capped at T2
            retransmissionTimerTicksLeft = Math.min(tickCount,
                    MAXIMUM_RETRANSMISSION_TICK_COUNT);
        }
        retransmissionTimerLastTickCount = retransmissionTimerTicksLeft;
    }

    /**
     * Turns off retransmission events for this transaction.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.862 -0500", hash_original_method = "7BF746AF9660DF3C6103C0B4973C1639", hash_generated_method = "6E53D2E91CAA8F3BDE21E17246BE4E21")
    
protected final void disableRetransmissionTimer() {
        retransmissionTimerTicksLeft = -1;
    }

    /**
     * Enables a timeout event to occur for this transaction after the number of
     * ticks passed to this method.
     *
     * @param tickCount
     *            Number of ticks before this transaction times out.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.865 -0500", hash_original_method = "C532D8E297B37B97B54B6D70870D5AC1", hash_generated_method = "EF4577ED8A117555163F6E44A5587F4C")
    
protected final void enableTimeoutTimer(int tickCount) {
        if (sipStack.isLoggingEnabled())
            sipStack.getStackLogger().logDebug("enableTimeoutTimer " + this
                    + " tickCount " + tickCount + " currentTickCount = "
                    + timeoutTimerTicksLeft);

        timeoutTimerTicksLeft = tickCount;
    }

    /**
     * Disabled the timeout timer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.868 -0500", hash_original_method = "9098113579473A4D9B2DEEE12DBC58EA", hash_generated_method = "4C3CF51972E13F55EF22EA05B3043EBE")
    
protected final void disableTimeoutTimer() {
        timeoutTimerTicksLeft = -1;
    }

    /**
     * Fired after each timer tick. Checks the retransmission and timeout timers
     * of this transaction, and fired these events if necessary.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.872 -0500", hash_original_method = "CB8F1BD04D54E1B61EA5D28A66348AD3", hash_generated_method = "8C5E3A7A5448A2D9D818D4909D4C9D1E")
    
final void fireTimer() {
        // If the timeout timer is enabled,

        if (timeoutTimerTicksLeft != -1) {
            // Count down the timer, and if it has run out,
            if (--timeoutTimerTicksLeft == 0) {
                // Fire the timeout timer
                fireTimeoutTimer();
            }
        }

        // If the retransmission timer is enabled,
        if (retransmissionTimerTicksLeft != -1) {
            // Count down the timer, and if it has run out,
            if (--retransmissionTimerTicksLeft == 0) {
                // Enable this timer to fire again after
                // twice the original time
                enableRetransmissionTimer(retransmissionTimerLastTickCount * 2);
                // Fire the timeout timer
                fireRetransmissionTimer();
            }
        } 
    }

    /**
     * Tests if this transaction has terminated.
     *
     * @return Trus if this transaction is terminated, false if not.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.875 -0500", hash_original_method = "308D399F3CCDEFF33AA1ADAF72826036", hash_generated_method = "B56298D879D72C4733AB57BCEA8A1797")
    
public final boolean isTerminated() {
        return getState() == TERMINATED_STATE;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.878 -0500", hash_original_method = "DAE59CB64F6674AD8098A54E7D2B1281", hash_generated_method = "4DC8F0ECD3E3CACF50E47B2D810C8F1C")
    
public String getHost() {
        return encapsulatedChannel.getHost();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.880 -0500", hash_original_method = "20977D5C5AB9D45A39447595F1157FC6", hash_generated_method = "507FC82E65356DC65BA9C23BE4E5CBED")
    
public String getKey() {
        return encapsulatedChannel.getKey();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.883 -0500", hash_original_method = "6EB6BE0A65CE407282FBCFAA26A62D3F", hash_generated_method = "D9CF932B519D9E316816E8CDD0051E9E")
    
public int getPort() {
        return encapsulatedChannel.getPort();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.886 -0500", hash_original_method = "28698FFA104E0D8C500A173E95CB7CFA", hash_generated_method = "12CE0678EAEEBAD384CCFE5DA73F66F3")
    
public SIPTransactionStack getSIPStack() {
        return (SIPTransactionStack) sipStack;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.889 -0500", hash_original_method = "4D24925E393EE43229BBE6696196C496", hash_generated_method = "59A6C2DC2C88854B5657B22B48B044AB")
    
public String getPeerAddress() {
        return this.peerAddress;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.891 -0500", hash_original_method = "A1F90D00B31019C3C4E0EAACEB8565BB", hash_generated_method = "313ACA6848B1E3FDD2DB6D73F242E097")
    
public int getPeerPort() {
        return this.peerPort;
    }

    // @@@ hagai
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.894 -0500", hash_original_method = "D72195827AEF451FEF473FAF2B8F43B1", hash_generated_method = "E18AA1E8DED399938A6D9ACF00727C62")
    
public int getPeerPacketSourcePort() {
        return this.peerPacketSourcePort;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.897 -0500", hash_original_method = "46454A41BD800FBE664B92E119C6A2FF", hash_generated_method = "3FBEE0ABD8642BA205D32D30763BAD49")
    
public InetAddress getPeerPacketSourceAddress() {
        return this.peerPacketSourceAddress;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.900 -0500", hash_original_method = "DE04102C176E73364B597E64B8D5F233", hash_generated_method = "DAEEF4226C7FC077515EE39E4DE21C84")
    
protected InetAddress getPeerInetAddress() {
        return this.peerInetAddress;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.903 -0500", hash_original_method = "DB79607DA3ACB5FA2D24428DF2713F98", hash_generated_method = "810EC1C4B25C89BA8602B83249B3FE8D")
    
protected String getPeerProtocol() {
        return this.peerProtocol;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.905 -0500", hash_original_method = "AEF0860991248E9299E1C6DDE1EF560C", hash_generated_method = "ABB95C087721D69D5578A647213128EC")
    
public String getTransport() {
        return encapsulatedChannel.getTransport();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.908 -0500", hash_original_method = "6845103B04473D4A2057FADE28E7D0AA", hash_generated_method = "4964DCDA40611D03107F1FA12CF69425")
    
public boolean isReliable() {
        return encapsulatedChannel.isReliable();
    }

    /**
     * Returns the Via header for this channel. Gets the Via header of the
     * underlying message channel, and adds a branch parameter to it for this
     * transaction.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.912 -0500", hash_original_method = "088E950799411477D094809B385ED56E", hash_generated_method = "242F3F79AEC11F050B31F9FA00D3F037")
    
public Via getViaHeader() {
        // Via header of the encapulated channel
        Via channelViaHeader;

        // Add the branch parameter to the underlying
        // channel's Via header
        channelViaHeader = super.getViaHeader();
        try {
            channelViaHeader.setBranch(branch);
        } catch (java.text.ParseException ex) {
        }
        return channelViaHeader;

    }

    /**
     * Process the message through the transaction and sends it to the SIP peer.
     *
     * @param messageToSend
     *            Message to send to the SIP peer.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.915 -0500", hash_original_method = "937EBFADC181BFE1D9D7AD4237E3287B", hash_generated_method = "579A073B7C99C3F02BB10835CC79ED97")
    
public void sendMessage(SIPMessage messageToSend) throws IOException {
        // Use the peer address, port and transport
        // that was specified when the transaction was
        // created. Bug was noted by Bruce Evangelder
        // soleo communications.
        try {
            encapsulatedChannel.sendMessage(messageToSend,
                    this.peerInetAddress, this.peerPort);
        } finally {
            this.startTransactionTimer();
        }
    }

    /**
     * Parse the byte array as a message, process it through the transaction,
     * and send it to the SIP peer. This is just a placeholder method -- calling
     * it will result in an IO exception.
     *
     * @param messageBytes
     *            Bytes of the message to send.
     * @param receiverAddress
     *            Address of the target peer.
     * @param receiverPort
     *            Network port of the target peer.
     *
     * @throws IOException
     *             If called.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.918 -0500", hash_original_method = "40115A27A95909E2CE679A790D4014C9", hash_generated_method = "E5DD96F72F4D57E2EA1A6BCC45489FE9")
    
protected void sendMessage(byte[] messageBytes,
            InetAddress receiverAddress, int receiverPort, boolean retry)
            throws IOException {
        throw new IOException(
                "Cannot send unparsed message through Transaction Channel!");
    }

    /**
     * Adds a new event listener to this transaction.
     *
     * @param newListener
     *            Listener to add.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.921 -0500", hash_original_method = "72CEDACA72EC4BC352365F84C4504BD8", hash_generated_method = "28A150566C385DD7BA4DE4B7D1869E1A")
    
public void addEventListener(SIPTransactionEventListener newListener) {
        eventListeners.add(newListener);
    }

    /**
     * Removed an event listener from this transaction.
     *
     * @param oldListener
     *            Listener to remove.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.924 -0500", hash_original_method = "668B9893C68F9233FC28CF7C4E017F56", hash_generated_method = "359F859380F572DDD072C11FEDC13955")
    
public void removeEventListener(SIPTransactionEventListener oldListener) {
        eventListeners.remove(oldListener);
    }

    /**
     * Creates a SIPTransactionErrorEvent and sends it to all of the listeners
     * of this transaction. This method also flags the transaction as
     * terminated.
     *
     * @param errorEventID
     *            ID of the error to raise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.927 -0500", hash_original_method = "38D8606DEF077947D947856564D84874", hash_generated_method = "4A1F4071DDF2012A94BDA424FF91831F")
    
protected void raiseErrorEvent(int errorEventID) {

        // Error event to send to all listeners
        SIPTransactionErrorEvent newErrorEvent;
        // Iterator through the list of listeners
        Iterator<SIPTransactionEventListener> listenerIterator;
        // Next listener in the list
        SIPTransactionEventListener nextListener;

        // Create the error event
        newErrorEvent = new SIPTransactionErrorEvent(this, errorEventID);

        // Loop through all listeners of this transaction
        synchronized (eventListeners) {
            listenerIterator = eventListeners.iterator();
            while (listenerIterator.hasNext()) {
                // Send the event to the next listener
                nextListener = (SIPTransactionEventListener) listenerIterator
                        .next();
                nextListener.transactionErrorEvent(newErrorEvent);
            }
        }
        // Clear the event listeners after propagating the error.
        // Retransmit notifications are just an alert to the
        // application (they are not an error).
        if (errorEventID != SIPTransactionErrorEvent.TIMEOUT_RETRANSMIT) {
            eventListeners.clear();

            // Errors always terminate a transaction
            this.setState(TransactionState.TERMINATED);

            if (this instanceof SIPServerTransaction && this.isByeTransaction()
                    && this.getDialog() != null)
                ((SIPDialog) this.getDialog())
                        .setState(SIPDialog.TERMINATED_STATE);
        }
    }

    /**
     * A shortcut way of telling if we are a server transaction.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.930 -0500", hash_original_method = "1EC803C9686336CE6058D1F41391EBE2", hash_generated_method = "CF559ABC4C0CCA765BE60757E5EAB032")
    
protected boolean isServerTransaction() {
        return this instanceof SIPServerTransaction;
    }

    /**
     * Gets the dialog object of this Transaction object. This object returns
     * null if no dialog exists. A dialog only exists for a transaction when a
     * session is setup between a User Agent Client and a User Agent Server,
     * either by a 1xx Provisional Response for an early dialog or a 200OK
     * Response for a committed dialog.
     *
     * @return the Dialog Object of this Transaction object.
     * @see Dialog
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.934 -0500", hash_original_method = "2A2D8F90205370D9F145CD8B0AEC9E6A", hash_generated_method = "3F2B96B1CC6A371F5C53B8FBA7E8C942")
    
public abstract Dialog getDialog();

    /**
     * set the dialog object.
     *
     * @param sipDialog --
     *            the dialog to set.
     * @param dialogId --
     *            the dialog id ot associate with the dialog.s
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.937 -0500", hash_original_method = "9434D78B894DA4967CDAB3F3F4CDCF5D", hash_generated_method = "3F0EB0767DF4DD74688194186849B776")
    
public abstract void setDialog(SIPDialog sipDialog, String dialogId);

    /**
     * Returns the current value of the retransmit timer in milliseconds used to
     * retransmit messages over unreliable transports.
     *
     * @return the integer value of the retransmit timer in milliseconds.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.940 -0500", hash_original_method = "A1D654E2B8EB18DBD9E2FBE3DBA84F3D", hash_generated_method = "9691FC9CA98E17379AA2D0F96C500679")
    
public int getRetransmitTimer() {
        return SIPTransactionStack.BASE_TIMER_INTERVAL;
    }

    /**
     * Get the host to assign for an outgoing Request via header.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.943 -0500", hash_original_method = "310B5DE4F217FB57953AC74F889ED704", hash_generated_method = "5EB53C68514BA8932BC6A346F16B5F85")
    
public String getViaHost() {
        return this.getViaHeader().getHost();

    }

    /**
     * Get the last response. This is used internally by the implementation.
     * Dont rely on it.
     *
     * @return the last response received (for client transactions) or sent (for
     *         server transactions).
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.945 -0500", hash_original_method = "025E14F038A1EDFF743C73F970E03870", hash_generated_method = "E4142FBCF67ABA0096A56A3990E0FF25")
    
public SIPResponse getLastResponse() {
        return this.lastResponse;
    }

    /**
     * Get the JAIN interface response
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.948 -0500", hash_original_method = "260B447AD36FE2CA2411AAAD920B4F1F", hash_generated_method = "E443F8A4E116BCEC0B4534869B57F21C")
    
public Response getResponse() {
        return (Response) this.lastResponse;
    }

    /**
     * Get the transaction Id.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.951 -0500", hash_original_method = "AB08BB44F7439305FB61E3E9EFAC9224", hash_generated_method = "4EDF50967268A6A4DFEC18CA675CB679")
    
public String getTransactionId() {
        return this.transactionId;
    }

    /**
     * Hashcode method for fast hashtable lookup.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.953 -0500", hash_original_method = "1EE454052F2EC55F5023F8455F33FFAA", hash_generated_method = "CC786C7918448ECCE3A828F26330D4A2")
    
public int hashCode() {
        if (this.transactionId == null)
            return -1;
        else
            return this.transactionId.hashCode();
    }

    /**
     * Get the port to assign for the via header of an outgoing message.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.957 -0500", hash_original_method = "F3BD37ECEE52D7438ECD340DC4DAF3CA", hash_generated_method = "44A0ECDA3D2FEB42E8E92142A5BE3B2B")
    
public int getViaPort() {
        return this.getViaHeader().getPort();
    }

    /**
     * A method that can be used to test if an incoming request belongs to this
     * transction. This does not take the transaction state into account when
     * doing the check otherwise it is identical to isMessagePartOfTransaction.
     * This is useful for checking if a CANCEL belongs to this transaction.
     *
     * @param requestToTest
     *            is the request to test.
     * @return true if the the request belongs to the transaction.
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.962 -0500", hash_original_method = "4C1135E1FB3652D771084DD3A5E7B7E8", hash_generated_method = "ADA21865678222F0DE774969FE940EC1")
    
public boolean doesCancelMatchTransaction(SIPRequest requestToTest) {

        // List of Via headers in the message to test
        ViaList viaHeaders;
        // Topmost Via header in the list
        Via topViaHeader;
        // Branch code in the topmost Via header
        String messageBranch;
        // Flags whether the select message is part of this transaction
        boolean transactionMatches;

        transactionMatches = false;

        if (this.getOriginalRequest() == null
                || this.getOriginalRequest().getMethod().equals(Request.CANCEL))
            return false;
        // Get the topmost Via header and its branch parameter
        viaHeaders = requestToTest.getViaHeaders();
        if (viaHeaders != null) {

            topViaHeader = (Via) viaHeaders.getFirst();
            messageBranch = topViaHeader.getBranch();
            if (messageBranch != null) {

                // If the branch parameter exists but
                // does not start with the magic cookie,
                if (!messageBranch.toLowerCase().startsWith(SIPConstants.BRANCH_MAGIC_COOKIE_LOWER_CASE)) {

                    // Flags this as old
                    // (RFC2543-compatible) client
                    // version
                    messageBranch = null;

                }

            }

            // If a new branch parameter exists,
            if (messageBranch != null && this.getBranch() != null) {

                // If the branch equals the branch in
                // this message,
                if (getBranch().equalsIgnoreCase(messageBranch)
                        && topViaHeader.getSentBy().equals(
                                ((Via) getOriginalRequest().getViaHeaders()
                                        .getFirst()).getSentBy())) {
                    transactionMatches = true;
                    if (sipStack.isLoggingEnabled())
                        sipStack.getStackLogger().logDebug("returning  true");
                }

            } else {
                // If this is an RFC2543-compliant message,
                // If RequestURI, To tag, From tag,
                // CallID, CSeq number, and top Via
                // headers are the same,
                if (sipStack.isLoggingEnabled())
                    sipStack.getStackLogger().logDebug("testing against "
                            + getOriginalRequest());

                if (getOriginalRequest().getRequestURI().equals(
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
                                .getViaHeaders().getFirst())) {

                    transactionMatches = true;
                }

            }

        }

        // JvB: Need to pass the CANCEL to the listener! Retransmitted INVITEs
        // set it to false
        if (transactionMatches) {
            this.setPassToListener();
        }
        return transactionMatches;
    }

    /**
     * Sets the value of the retransmit timer to the newly supplied timer value.
     * The retransmit timer is expressed in milliseconds and its default value
     * is 500ms. This method allows the application to change the transaction
     * retransmit behavior for different networks. Take the gateway proxy as an
     * example. The internal intranet is likely to be reatively uncongested and
     * the endpoints will be relatively close. The external network is the
     * general Internet. This functionality allows different retransmit times
     * for either side.
     *
     * @param retransmitTimer -
     *            the new integer value of the retransmit timer in milliseconds.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.965 -0500", hash_original_method = "348CFFAB37D4D83E29A04C573F3FF487", hash_generated_method = "0B0D785DC623BB299601F116F52FCA06")
    
public void setRetransmitTimer(int retransmitTimer) {

        if (retransmitTimer <= 0)
            throw new IllegalArgumentException(
                    "Retransmit timer must be positive!");
        if (this.transactionTimerStarted.get())
            throw new IllegalStateException(
                    "Transaction timer is already started");
        BASE_TIMER_INTERVAL = retransmitTimer;
        T4 = 5000 / BASE_TIMER_INTERVAL;

        T2 = 4000 / BASE_TIMER_INTERVAL;
        TIMER_I = T4;

        TIMER_K = T4;

        TIMER_D = 32000 / BASE_TIMER_INTERVAL;

    }

    /**
     * Close the encapsulated channel.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.968 -0500", hash_original_method = "45CE0F911469E288CC97776E84414496", hash_generated_method = "84898BF8779BC2ABB90510C20BC96234")
    
public void close() {
        this.encapsulatedChannel.close();
        if (sipStack.isLoggingEnabled())
            sipStack.getStackLogger().logDebug("Closing " + this.encapsulatedChannel);

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.970 -0500", hash_original_method = "905D593C098EC8A0BB1DC95C9B54F441", hash_generated_method = "80A80D4E9B5671F9D09E3BF267A81A19")
    
public boolean isSecure() {
        return encapsulatedChannel.isSecure();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.973 -0500", hash_original_method = "9C4DCEACA96616F074242810B487B970", hash_generated_method = "9264F5348D3D863E4D16EA3CF66D3FA7")
    
public MessageProcessor getMessageProcessor() {
        return this.encapsulatedChannel.getMessageProcessor();
    }

    /**
     * Set the application data pointer. This is un-interpreted by the stack.
     * This is provided as a conveniant way of keeping book-keeping data for
     * applications. Note that null clears the application data pointer
     * (releases it).
     *
     * @param applicationData --
     *            application data pointer to set. null clears the applicationd
     *            data pointer.
     *
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.976 -0500", hash_original_method = "552E0456C33D24CD63C8EBCDAC1D019B", hash_generated_method = "801F39B66BF2D8C554DCF3937EA2F8CE")
    
public void setApplicationData(Object applicationData) {
        this.applicationData = applicationData;
    }

    /**
     * Get the application data associated with this transaction.
     *
     * @return stored application data.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.979 -0500", hash_original_method = "5F924FC61375970A4DC758380BEBFF0F", hash_generated_method = "65575224A94F45AA5C180B0ED3AF02CA")
    
public Object getApplicationData() {
        return this.applicationData;
    }

    /**
     * Set the encapsuated channel. The peer inet address and port are set equal
     * to the message channel.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.982 -0500", hash_original_method = "739B4CAA187BE9D487A452627B0424A2", hash_generated_method = "9B48FF52570A35FD4590B11B76DB5934")
    
public void setEncapsulatedChannel(MessageChannel messageChannel) {
        this.encapsulatedChannel = messageChannel;
        this.peerInetAddress = messageChannel.getPeerInetAddress();
        this.peerPort = messageChannel.getPeerPort();
    }

    /**
     * Return the SipProvider for which the transaction is assigned.
     *
     * @return the SipProvider for the transaction.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.986 -0500", hash_original_method = "38ECF920BD32EC6B95BB00C4AAD637BA", hash_generated_method = "98E3B41A1F0F54C8AE425DB5D236C1B3")
    
public SipProviderImpl getSipProvider() {

        return this.getMessageProcessor().getListeningPoint().getProvider();
    }
    
    class LingerTimer extends SIPStackTimerTask {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.801 -0500", hash_original_method = "4F6152921EA187210C4EA8258CD889E1", hash_generated_method = "0AB0A87555F2C492D061F1FC368DAB17")
        
public LingerTimer() {
            SIPTransaction sipTransaction = SIPTransaction.this;
            if (sipStack.isLoggingEnabled()) {
                sipStack.getStackLogger().logDebug("LingerTimer : "
                        + sipTransaction.getTransactionId());
            }

        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.805 -0500", hash_original_method = "14B41A6E0BE7E84E900DADE7EB6E3A9A", hash_generated_method = "5C69997AD34E9B67D5ABE22F8CA56C49")
        
protected void runTask() {
            SIPTransaction transaction = SIPTransaction.this;
            // release the connection associated with this transaction.
            SIPTransactionStack sipStack = transaction.getSIPStack();

            if (sipStack.isLoggingEnabled()) {
                sipStack.getStackLogger().logDebug("LingerTimer: run() : "
                        + getTransactionId());
            }

            if (transaction instanceof SIPClientTransaction) {
                sipStack.removeTransaction(transaction);
                transaction.close();

            } else if (transaction instanceof ServerTransaction) {
                // Remove it from the set
                if (sipStack.isLoggingEnabled())
                    sipStack.getStackLogger().logDebug("removing" + transaction);
                sipStack.removeTransaction(transaction);
                if ((!sipStack.cacheServerConnections)
                        && --transaction.encapsulatedChannel.useCount <= 0) {
                    // Close the encapsulated socket if stack is configured
                    transaction.close(); 
                } else {
                    if (sipStack.isLoggingEnabled()
                            && (!sipStack.cacheServerConnections)
                            && transaction.isReliable()) {
                        int useCount = transaction.encapsulatedChannel.useCount;
                        sipStack.getStackLogger().logDebug("Use Count = " + useCount);
                    }
                }
            }

        }
        
    }

    /**
     * Raise an IO Exception event - this is used for reporting asynchronous IO
     * Exceptions that are attributable to this transaction.
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.989 -0500", hash_original_method = "BA06BB4C0270C8B47C1CBBF5F94DA61A", hash_generated_method = "4E508D715AADF293F634A9FF16B8C6BC")
    
public void raiseIOExceptionEvent() {
        setState(TransactionState.TERMINATED);
        String host = getPeerAddress();
        int port = getPeerPort();
        String transport = getTransport();
        IOExceptionEvent exceptionEvent = new IOExceptionEvent(this, host,
                port, transport);
        getSipProvider().handleEvent(exceptionEvent, this);
    }

    /**
     * A given tx can process only a single outstanding event at a time. This
     * semaphore gaurds re-entrancy to the transaction.
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.992 -0500", hash_original_method = "9C758C929345C5BD5429DB309FDFD6EA", hash_generated_method = "2F5C192D6B61B236AAF2BB5BBB11F17E")
    
public boolean acquireSem() {
        boolean retval = false;
        try {
            if (sipStack.getStackLogger().isLoggingEnabled()) {
                sipStack.getStackLogger().logDebug("acquireSem [[[[" + this);
                sipStack.getStackLogger().logStackTrace();
            }
            retval = this.semaphore.tryAcquire(1000, TimeUnit.MILLISECONDS);
            if ( sipStack.isLoggingEnabled())
                sipStack.getStackLogger().logDebug(
                    "acquireSem() returning : " + retval);
            return retval;
        } catch (Exception ex) {
            sipStack.getStackLogger().logError("Unexpected exception acquiring sem",
                    ex);
            InternalErrorHandler.handleException(ex);
            return false;
        } finally {
            this.isSemaphoreAquired = retval;
        }

    }

    /**
     * Release the transaction semaphore.
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.994 -0500", hash_original_method = "301846C685CE876D86A6B4185A591E30", hash_generated_method = "3D7D32BEE3E1E33391A9CAC4E1CEB7FB")
    
public void releaseSem() {
        try {

            this.toListener = false;
            this.semRelease();

        } catch (Exception ex) {
            sipStack.getStackLogger().logError("Unexpected exception releasing sem",
                    ex);

        }

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:13.997 -0500", hash_original_method = "DBC24F6DB4FEFD7D7F8639708567DC35", hash_generated_method = "CB6C2A2C73B8B99495F939A47AF3EC29")
    
protected void semRelease() {
        try {
            if (sipStack.isLoggingEnabled()) {
                sipStack.getStackLogger().logDebug("semRelease ]]]]" + this);
                sipStack.getStackLogger().logStackTrace();
            }
            this.isSemaphoreAquired = false;
            this.semaphore.release();

        } catch (Exception ex) {
            sipStack.getStackLogger().logError("Unexpected exception releasing sem",
                    ex);

        }
    }

    /**
     * Set true to pass the request up to the listener. False otherwise.
     *
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:14.001 -0500", hash_original_method = "39E9029186E8CC55AF8CBCC68EB9597C", hash_generated_method = "581EA10EE54AA8831D57C25F6E2E8D41")
    
public boolean passToListener() {
        return toListener;
    }

    /**
     * Set the passToListener flag to true.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:14.004 -0500", hash_original_method = "F5F4C78B3DFF0EDA40F4B14C1017F836", hash_generated_method = "2BF467E5CA0923F36236F809567785A8")
    
public void setPassToListener() {
        if (sipStack.isLoggingEnabled()) {
            sipStack.getStackLogger().logDebug("setPassToListener()");
        }
        this.toListener = true;

    }

    /**
     * Flag to test if the terminated event is delivered.
     *
     * @return
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:14.007 -0500", hash_original_method = "5D50ECFAFAF878A5B29EF8C830BE2C71", hash_generated_method = "231B5CEEE9169B846FADC469433C3CFD")
    
protected synchronized boolean testAndSetTransactionTerminatedEvent() {
        boolean retval = !this.terminatedEventDelivered;
        this.terminatedEventDelivered = true;
        return retval;
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:14.010 -0500", hash_original_method = "0D2015A100DFE7954256C577DAEBD143", hash_generated_method = "0BD975F8A4F112F040060C58FDC61C03")
    
public String getCipherSuite() throws UnsupportedOperationException {
        if (this.getMessageChannel() instanceof TLSMessageChannel ) {
            if (  ((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener() == null ) 
                return null;
            else if ( ((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener().getHandshakeCompletedEvent() == null)
                return null;
            else return ((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener().getHandshakeCompletedEvent().getCipherSuite();
        } else throw new UnsupportedOperationException("Not a TLS channel");

    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:14.013 -0500", hash_original_method = "1BD353D03C47A7F0291FB8AF92EA1899", hash_generated_method = "576EC9E1E6349C16601A0DC1EA2A1E3A")
    
public java.security.cert.Certificate[] getLocalCertificates() throws UnsupportedOperationException {
         if (this.getMessageChannel() instanceof TLSMessageChannel ) {
            if (  ((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener() == null ) 
                return null;
            else if ( ((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener().getHandshakeCompletedEvent() == null)
                return null;
            else return ((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener().getHandshakeCompletedEvent().getLocalCertificates();
        } else throw new UnsupportedOperationException("Not a TLS channel");
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:14.016 -0500", hash_original_method = "425975E25339AF497E9130895A1F6EC3", hash_generated_method = "2E9B9EA9638D1ECE5B87DF892DC873BF")
    
public java.security.cert.Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
        if (this.getMessageChannel() instanceof TLSMessageChannel ) {
            if (  ((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener() == null ) 
                return null;
            else if ( ((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener().getHandshakeCompletedEvent() == null)
                return null;
            else return ((TLSMessageChannel) this.getMessageChannel()).getHandshakeCompletedListener().getHandshakeCompletedEvent().getPeerCertificates();
        } else throw new UnsupportedOperationException("Not a TLS channel");

    }

    /**
     * Start the timer that runs the transaction state machine.
     *
     */

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:14.020 -0500", hash_original_method = "E5EAE26C57F5EBB157203CBA87CB951E", hash_generated_method = "30C468CB6458BA005BA4F4741CC61DEA")
    
protected abstract void startTransactionTimer();

    /**
     * Tests a message to see if it is part of this transaction.
     *
     * @return True if the message is part of this transaction, false if not.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:14.023 -0500", hash_original_method = "54A14067D4D69175B71AF6E3CF49DEDD", hash_generated_method = "AD767D86D9C16901816A5A36F2380B72")
    
public abstract boolean isMessagePartOfTransaction(SIPMessage messageToTest);

    /**
     * This method is called when this transaction's retransmission timer has
     * fired.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:14.025 -0500", hash_original_method = "FD1B342529E4AA24544A358CD24571F9", hash_generated_method = "313A5C8BF2594769199854407AB53309")
    
protected abstract void fireRetransmissionTimer();

    /**
     * This method is called when this transaction's timeout timer has fired.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:14.028 -0500", hash_original_method = "2DB190C250A960DFD23F0F74910B0F8C", hash_generated_method = "FB0522ADFC3E1A913411DC5B48DA1A35")
    
protected abstract void fireTimeoutTimer();
}

