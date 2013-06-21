package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.core.InternalErrorHandler;
import gov.nist.javax.sip.SIPConstants;
import gov.nist.javax.sip.ServerTransactionExt;
import gov.nist.javax.sip.SipProviderImpl;
import gov.nist.javax.sip.Utils;
import gov.nist.javax.sip.header.Expires;
import gov.nist.javax.sip.header.ParameterNames;
import gov.nist.javax.sip.header.RSeq;
import gov.nist.javax.sip.header.Via;
import gov.nist.javax.sip.header.ViaList;
import gov.nist.javax.sip.message.SIPMessage;
import gov.nist.javax.sip.message.SIPRequest;
import gov.nist.javax.sip.message.SIPResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.TimerTask;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import javax.sip.Dialog;
import javax.sip.DialogState;
import javax.sip.DialogTerminatedEvent;
import javax.sip.ObjectInUseException;
import javax.sip.SipException;
import javax.sip.Timeout;
import javax.sip.TimeoutEvent;
import javax.sip.TransactionState;
import javax.sip.address.Hop;
import javax.sip.header.ContactHeader;
import javax.sip.header.ExpiresHeader;
import javax.sip.header.RSeqHeader;
import javax.sip.message.Request;
import javax.sip.message.Response;

public class SIPServerTransaction extends SIPTransaction implements ServerRequestInterface, javax.sip.ServerTransaction, ServerTransactionExt {
    private int rseqNumber;
    private transient ServerRequestInterface requestOf;
    private SIPDialog dialog;
    private SIPResponse pendingReliableResponse;
    private ProvisionalResponseTask provisionalResponseTask;
    private boolean retransmissionAlertEnabled;
    private RetransmissionAlertTimerTask retransmissionAlertTimerTask;
    protected boolean isAckSeen;
    private SIPClientTransaction pendingSubscribeTransaction;
    private SIPServerTransaction inviteTransaction;
    private Semaphore provisionalResponseSem = new Semaphore(1);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.690 -0400", hash_original_method = "D29C36EF10CFF1709E916D648669409B", hash_generated_method = "AF8471AF47C65642411592EF8CDDA2E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected SIPServerTransaction(SIPTransactionStack sipStack, MessageChannel newChannelToUse) {
        super(sipStack, newChannelToUse);
        dsTaint.addTaint(newChannelToUse.dsTaint);
        dsTaint.addTaint(sipStack.dsTaint);
        {
            sipStack.getTimer().schedule(new ListenerExecutionMaxTimer(),
                    sipStack.maxListenerResponseTime * 1000);
        } //End block
        this.rseqNumber = (int) (Math.random() * 1000);
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1870016804 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("Creating Server Transaction" + this.getBranchId());
                sipStack.getStackLogger().logStackTrace();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (sipStack.maxListenerResponseTime != -1) {
            //sipStack.getTimer().schedule(new ListenerExecutionMaxTimer(),
                    //sipStack.maxListenerResponseTime * 1000);
        //}
        //this.rseqNumber = (int) (Math.random() * 1000);
        //if (sipStack.isLoggingEnabled()) {
            //sipStack.getStackLogger().logDebug("Creating Server Transaction" + this.getBranchId());
            //sipStack.getStackLogger().logStackTrace();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.690 -0400", hash_original_method = "05CFFFBF5E08267473584C7C9C8831C7", hash_generated_method = "12EC808F35F808A3BC1AE9615B56E12A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sendResponse(SIPResponse transactionResponse) throws IOException {
        dsTaint.addTaint(transactionResponse.dsTaint);
        try 
        {
            {
                boolean var9EFBE966E135F730A1154D9309908C82_206445668 = (isReliable());
                {
                    getMessageChannel().sendMessage(transactionResponse);
                } //End block
                {
                    Via via;
                    via = transactionResponse.getTopmostVia();
                    String transport;
                    transport = via.getTransport();
                    if (DroidSafeAndroidRuntime.control) throw new IOException("missing transport!");
                    int port;
                    port = via.getRPort();
                    port = via.getPort();
                    {
                        {
                            boolean var8BC61AB78A469B78B9FFCADF874AA2E5_989416259 = (transport.equalsIgnoreCase("TLS"));
                            port = 5061;
                            port = 5060;
                        } //End collapsed parenthetic
                    } //End block
                    String host;
                    host = null;
                    {
                        boolean varFAB52FD2A0D0415EDF52868F4EC52466_1511990764 = (via.getMAddr() != null);
                        {
                            host = via.getMAddr();
                        } //End block
                        {
                            host = via.getParameter(Via.RECEIVED);
                            {
                                host = via.getHost();
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                    Hop hop;
                    hop = sipStack.addressResolver.resolveAddress(new HopImpl(host, port,
                        transport));
                    MessageChannel messageChannel;
                    messageChannel = ((SIPTransactionStack) getSIPStack())
                        .createRawMessageChannel(this.getSipProvider().getListeningPoint(
                                hop.getTransport()).getIPAddress(), this.getPort(), hop);
                    messageChannel.sendMessage(transactionResponse);
                    if (DroidSafeAndroidRuntime.control) throw new IOException("Could not create a message channel for " + hop);
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            this.startTransactionTimer();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.690 -0400", hash_original_method = "D3B4FF5E31929A9875E21530A6B99142", hash_generated_method = "2077CFDBEEF8CEDF914AF57907A9DE99")
    @DSModeled(DSC.SAFE)
    public void setRequestInterface(ServerRequestInterface newRequestOf) {
        dsTaint.addTaint(newRequestOf.dsTaint);
        // ---------- Original Method ----------
        //requestOf = newRequestOf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.691 -0400", hash_original_method = "BE06A4E585FD9A272717267C4A83F5CF", hash_generated_method = "CF0588025C9E8D0CABF4A9FB0DC0CD9D")
    @DSModeled(DSC.SAFE)
    public MessageChannel getResponseChannel() {
        return (MessageChannel)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.692 -0400", hash_original_method = "EE01791F9851138F67FFB678FE608E3C", hash_generated_method = "1E2D8FCC38AC63B90BC5FDA1CCCE0224")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isMessagePartOfTransaction(SIPMessage messageToTest) {
        dsTaint.addTaint(messageToTest.dsTaint);
        ViaList viaHeaders;
        Via topViaHeader;
        String messageBranch;
        boolean transactionMatches;
        transactionMatches = false;
        String method;
        method = messageToTest.getCSeq().getMethod();
        {
            boolean varA587C943C2619AFFE13B94F1AB583610_151264812 = ((method.equals(Request.INVITE) || !isTerminated()));
            {
                viaHeaders = messageToTest.getViaHeaders();
                {
                    topViaHeader = (Via) viaHeaders.getFirst();
                    messageBranch = topViaHeader.getBranch();
                    {
                        {
                            boolean varB0B1855F9231D6A8F5FD28941F9BDDD0_15402396 = (!messageBranch.toLowerCase().startsWith(
                            SIPConstants.BRANCH_MAGIC_COOKIE_LOWER_CASE));
                            {
                                messageBranch = null;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        boolean varE32D6D22F4CE4924781A107A8FB175B2_2103887540 = (messageBranch != null && this.getBranch() != null);
                        {
                            {
                                boolean var6D97B93142EE0960BB0161B3820BC33B_656304927 = (method.equals(Request.CANCEL));
                                {
                                    transactionMatches = this.getMethod().equals(Request.CANCEL)
                                && getBranch().equalsIgnoreCase(messageBranch)
                                && topViaHeader.getSentBy().equals(
                                        ((Via) getOriginalRequest().getViaHeaders().getFirst())
                                                .getSentBy());
                                } //End block
                                {
                                    transactionMatches = getBranch().equalsIgnoreCase(messageBranch)
                                && topViaHeader.getSentBy().equals(
                                        ((Via) getOriginalRequest().getViaHeaders().getFirst())
                                                .getSentBy());
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        {
                            String originalFromTag;
                            originalFromTag = super.fromTag;
                            String thisFromTag;
                            thisFromTag = messageToTest.getFrom().getTag();
                            boolean skipFrom;
                            skipFrom = (originalFromTag == null || thisFromTag == null);
                            String originalToTag;
                            originalToTag = super.toTag;
                            String thisToTag;
                            thisToTag = messageToTest.getTo().getTag();
                            boolean skipTo;
                            skipTo = (originalToTag == null || thisToTag == null);
                            boolean isResponse;
                            isResponse = (messageToTest instanceof SIPResponse);
                            {
                                boolean varE3294734A663B5145970265517B02330_1066232897 = (messageToTest.getCSeq().getMethod().equalsIgnoreCase(Request.CANCEL)
                            && !getOriginalRequest().getCSeq().getMethod().equalsIgnoreCase(
                                    Request.CANCEL));
                                {
                                    transactionMatches = false;
                                } //End block
                                {
                                    boolean var8F6BF2C074DDF0DDEAFFC56D2F91B82E_816909305 = ((isResponse || getOriginalRequest().getRequestURI().equals(
                            ((SIPRequest) messageToTest).getRequestURI()))
                            && (skipFrom || originalFromTag != null && originalFromTag.equalsIgnoreCase(thisFromTag))
                            && (skipTo || originalToTag != null && originalToTag.equalsIgnoreCase(thisToTag))
                            && getOriginalRequest().getCallId().getCallId().equalsIgnoreCase(
                                    messageToTest.getCallId().getCallId())
                            && getOriginalRequest().getCSeq().getSeqNumber() == messageToTest
                                    .getCSeq().getSeqNumber()
                            && ((!messageToTest.getCSeq().getMethod().equals(Request.CANCEL)) || getOriginalRequest()
                                    .getMethod().equals(messageToTest.getCSeq().getMethod()))
                            && topViaHeader.equals(getOriginalRequest().getViaHeaders()
                                    .getFirst()));
                                    {
                                        transactionMatches = true;
                                    } //End block
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.692 -0400", hash_original_method = "6CCC5EFA22CA085040CD9EF339EE900B", hash_generated_method = "EC807325C909C4939F4649CCC2D43CE7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void map() {
        TransactionState realState;
        realState = getRealState();
        {
            {
                boolean var31AB16103AEFA126AE0456128DBB6A94_1029681230 = (isInviteTransaction() && !this.isMapped && sipStack.getTimer() != null);
                {
                    this.isMapped = true;
                    sipStack.getTimer().schedule(new SendTrying(), 200);
                } //End block
                {
                    isMapped = true;
                } //End block
            } //End collapsed parenthetic
        } //End block
        sipStack.removePendingTransaction(this);
        // ---------- Original Method ----------
        //TransactionState realState = getRealState();
        //if (realState == null || realState == TransactionState.TRYING) {
            //if (isInviteTransaction() && !this.isMapped && sipStack.getTimer() != null) {
                //this.isMapped = true;
                //sipStack.getTimer().schedule(new SendTrying(), 200);
            //} else {
                //isMapped = true;
            //}
        //}
        //sipStack.removePendingTransaction(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.692 -0400", hash_original_method = "7F46EDF7DD1A49A585957DF512054145", hash_generated_method = "EE9255B47B6A6ACAD306BCDAF376D88B")
    @DSModeled(DSC.SAFE)
    public boolean isTransactionMapped() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.isMapped;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.694 -0400", hash_original_method = "56FAA78069677544853324F6F2B799B6", hash_generated_method = "960BA0E8F56091163F14844444198672")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void processRequest(SIPRequest transactionRequest, MessageChannel sourceChannel) {
        dsTaint.addTaint(transactionRequest.dsTaint);
        dsTaint.addTaint(sourceChannel.dsTaint);
        boolean toTu;
        toTu = false;
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_897027624 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("processRequest: " + transactionRequest.getFirstLine());
                sipStack.getStackLogger().logDebug("tx state = " + this.getRealState());
            } //End block
        } //End collapsed parenthetic
        try 
        {
            {
                boolean var70CEB3DDCD8D7128B1625311F4A9712B_1623481491 = (getRealState() == null);
                {
                    setOriginalRequest(transactionRequest);
                    this.setState(TransactionState.TRYING);
                    toTu = true;
                    this.setPassToListener();
                    {
                        boolean var26B9564585E283B5580BF068A8F2EBC0_1431755409 = (isInviteTransaction() && this.isMapped);
                        {
                            sendMessage(transactionRequest.createResponse(100, "Trying"));
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean var61C63FC44DDBF94E9A005FDACD8F877F_687186201 = (isInviteTransaction() && TransactionState.COMPLETED == getRealState()
                    && transactionRequest.getMethod().equals(Request.ACK));
                    {
                        this.setState(TransactionState.CONFIRMED);
                        disableRetransmissionTimer();
                        {
                            boolean var6400A483252621139629FC45C6113F96_1648067952 = (!isReliable());
                            {
                                enableTimeoutTimer(TIMER_I);
                            } //End block
                            {
                                this.setState(TransactionState.TERMINATED);
                            } //End block
                        } //End collapsed parenthetic
                        {
                            boolean var0CE4EC8BFDE23852AC02E54D6C0A99C3_803158159 = (sipStack.isNon2XXAckPassedToListener());
                            {
                                requestOf.processRequest(transactionRequest, this);
                            } //End block
                            {
                                {
                                    boolean varA5D47C3A6259BCCCC2265DD1F84B75D4_1014927817 = (sipStack.isLoggingEnabled());
                                    {
                                        sipStack.getStackLogger().logDebug("ACK received for server Tx "
                                + this.getTransactionId() + " not delivering to application!");
                                    } //End block
                                } //End collapsed parenthetic
                                this.semRelease();
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        boolean var5DCA1F369F7D30BA32EEBBE4FE2D1EC4_1941409741 = (transactionRequest.getMethod().equals(getOriginalRequest().getMethod()));
                        {
                            {
                                boolean var513E565483353A4E3D5B26CBC828D863_1607633949 = (TransactionState.PROCEEDING == getRealState()
                        || TransactionState.COMPLETED == getRealState());
                                {
                                    this.semRelease();
                                    {
                                        super.sendMessage(lastResponse);
                                    } //End block
                                } //End block
                                {
                                    boolean var261C36BF61BB943A059F423FCF36B492_736280920 = (transactionRequest.getMethod().equals(Request.ACK));
                                    {
                                        requestOf.processRequest(transactionRequest, this);
                                        this.semRelease();
                                    } //End block
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_1023550948 = (sipStack.isLoggingEnabled());
                                sipStack.getStackLogger().logDebug("completed processing retransmitted request : "
                        + transactionRequest.getFirstLine() + this + " txState = "
                        + this.getState() + " lastResponse = " + this.getLastResponse());
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            {
                boolean var138A866FF284A265491C1CE49B1F033D_157430632 = (TransactionState.COMPLETED != getRealState()
                    && TransactionState.TERMINATED != getRealState() && requestOf != null);
                {
                    {
                        boolean var1B84E64E4073F1ABC138FA35CD2C39EE_1876569752 = (getOriginalRequest().getMethod().equals(transactionRequest.getMethod()));
                        {
                            {
                                requestOf.processRequest(transactionRequest, this);
                            } //End block
                            this.semRelease();
                        } //End block
                        {
                            requestOf.processRequest(transactionRequest, this);
                            this.semRelease();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    {
                        boolean var1819F3EAA856749263E5BE101D189558_1071554478 = (((SIPTransactionStack) getSIPStack()).isDialogCreated(getOriginalRequest()
                        .getMethod())
                        && getRealState() == TransactionState.TERMINATED
                        && transactionRequest.getMethod().equals(Request.ACK)
                        && requestOf != null);
                        {
                            SIPDialog thisDialog;
                            thisDialog = (SIPDialog) this.dialog;
                            {
                                {
                                    thisDialog.ackReceived(transactionRequest);
                                    thisDialog.ackProcessed = true;
                                } //End block
                                requestOf.processRequest(transactionRequest, this);
                            } //End block
                            {
                                this.semRelease();
                            } //End block
                        } //End block
                        {
                            boolean var9CD63E03739FECA68F9AFA5AAC7AA721_867664135 = (transactionRequest.getMethod().equals(Request.CANCEL));
                            {
                                {
                                    boolean varA5D47C3A6259BCCCC2265DD1F84B75D4_1862968875 = (sipStack.isLoggingEnabled());
                                    sipStack.getStackLogger().logDebug("Too late to cancel Transaction");
                                } //End collapsed parenthetic
                                this.semRelease();
                                try 
                                {
                                    this.sendMessage(transactionRequest.createResponse(Response.OK));
                                } //End block
                                catch (IOException ex)
                                { }
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1707190785 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger().logDebug("Dropping request " + getRealState());
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (IOException e)
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_331772256 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logError("IOException " ,e);
            } //End collapsed parenthetic
            this.semRelease();
            this.raiseIOExceptionEvent();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.695 -0400", hash_original_method = "2B73C982341966F86ADBEA04AC7851BC", hash_generated_method = "740E951C28A5971CFE5B949367E2151E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendMessage(SIPMessage messageToSend) throws IOException {
        dsTaint.addTaint(messageToSend.dsTaint);
        try 
        {
            SIPResponse transactionResponse;
            int statusCode;
            transactionResponse = (SIPResponse) messageToSend;
            statusCode = transactionResponse.getStatusCode();
            try 
            {
                {
                    boolean var2F38972DBED8A4DE733E711CBE4D5C6A_996275653 = (this.getOriginalRequest().getTopmostVia().getBranch() != null);
                    transactionResponse.getTopmostVia().setBranch(this.getBranch());
                    transactionResponse.getTopmostVia().removeParameter(ParameterNames.BRANCH);
                } //End collapsed parenthetic
                {
                    boolean varC44D49F2E08F6BF8B72E9153D7546CFA_1941871493 = (!this.getOriginalRequest().getTopmostVia().hasPort());
                    transactionResponse.getTopmostVia().removePort();
                } //End collapsed parenthetic
            } //End block
            catch (ParseException ex)
            {
                ex.printStackTrace();
            } //End block
            {
                boolean varCDC23963431F718F155919E1B152A5B1_1435032581 = (!transactionResponse.getCSeq().getMethod().equals(
                    getOriginalRequest().getMethod()));
                {
                    sendResponse(transactionResponse);
                } //End block
            } //End collapsed parenthetic
            {
                boolean var4BA81FF05A67431D945A9CCF4269103B_759724326 = (getRealState() == TransactionState.TRYING);
                {
                    {
                        this.setState(TransactionState.PROCEEDING);
                    } //End block
                    {
                        {
                            boolean var9A31CFD76FE10E8ECD86917959215919_2041221659 = (!isInviteTransaction());
                            {
                                {
                                    boolean var5823DC8E03E92FBA3E90C95804A7C591_1630209919 = (!isReliable());
                                    {
                                        this.setState(TransactionState.COMPLETED);
                                        enableTimeoutTimer(TIMER_J);
                                    } //End block
                                    {
                                        this.setState(TransactionState.TERMINATED);
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                            {
                                {
                                    this.disableRetransmissionTimer();
                                    this.disableTimeoutTimer();
                                    this.collectionTime = TIMER_J;
                                    this.setState(TransactionState.TERMINATED);
                                    this.dialog.setRetransmissionTicks();
                                } //End block
                                {
                                    this.setState(TransactionState.COMPLETED);
                                    {
                                        boolean var6E7182B6E41B1FA498D147B67D30B4C7_751487269 = (!isReliable());
                                        {
                                            enableRetransmissionTimer();
                                        } //End block
                                    } //End collapsed parenthetic
                                    enableTimeoutTimer(TIMER_H);
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End block
                {
                    boolean var74E8F15E3DFF3B3C75AA5FCF9E43A983_987009878 = (getRealState() == TransactionState.PROCEEDING);
                    {
                        {
                            boolean var90CDBC638C52197AEFD58A39118A4F7B_2041101975 = (isInviteTransaction());
                            {
                                {
                                    this.disableRetransmissionTimer();
                                    this.disableTimeoutTimer();
                                    this.collectionTime = TIMER_J;
                                    this.setState(TransactionState.TERMINATED);
                                    this.dialog.setRetransmissionTicks();
                                } //End block
                                {
                                    this.setState(TransactionState.COMPLETED);
                                    {
                                        boolean var6E7182B6E41B1FA498D147B67D30B4C7_88370813 = (!isReliable());
                                        {
                                            enableRetransmissionTimer();
                                        } //End block
                                    } //End collapsed parenthetic
                                    enableTimeoutTimer(TIMER_H);
                                } //End block
                            } //End block
                            {
                                this.setState(TransactionState.COMPLETED);
                                {
                                    boolean var5823DC8E03E92FBA3E90C95804A7C591_57400741 = (!isReliable());
                                    {
                                        disableRetransmissionTimer();
                                        enableTimeoutTimer(TIMER_J);
                                    } //End block
                                    {
                                        this.setState(TransactionState.TERMINATED);
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        boolean varFD4EA10AB958789F8E5208FCA031E4F7_510698274 = (TransactionState.COMPLETED == this.getRealState());
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            try 
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_754517557 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logDebug(
                            "sendMessage : tx = " + this + " getState = " + this.getState());
                    } //End block
                } //End collapsed parenthetic
                lastResponse = transactionResponse;
                this.sendResponse(transactionResponse);
            } //End block
            catch (IOException e)
            {
                this.setState(TransactionState.TERMINATED);
                this.collectionTime = 0;
                if (DroidSafeAndroidRuntime.control) throw e;
            } //End block
        } //End block
        finally 
        {
            this.startTransactionTimer();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.695 -0400", hash_original_method = "57D57213185EECDD5D38603D59833E46", hash_generated_method = "2E792FDB85228A89751EE0886CB296E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getViaHost() {
        String var816C207429F5C9EC80B1129FC27E779E_847738996 = (getMessageChannel().getViaHost());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getMessageChannel().getViaHost();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.696 -0400", hash_original_method = "AE83C408493AD4624CBF388A7C2A34C7", hash_generated_method = "DE06C324B5B43B48CBED3C03B80C20C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getViaPort() {
        int var65E79C2A809CF6EB6BDAEEC8693218FB_143794204 = (getMessageChannel().getViaPort());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getMessageChannel().getViaPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.696 -0400", hash_original_method = "E1523787F7609795EF3E130FC3FDDFF0", hash_generated_method = "94BD9F53573B905651BFC196F18F1A6C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void fireRetransmissionTimer() {
        try 
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1264243921 = (sipStack.isLoggingEnabled());
                {
                    sipStack.getStackLogger().logDebug("fireRetransmissionTimer() -- ");
                } //End block
            } //End collapsed parenthetic
            {
                boolean var97506D4608B4B086F590DABBD0CD0224_2097576567 = (isInviteTransaction() && lastResponse != null);
                {
                    {
                        boolean varF7C06CC5B09327E8D335DE2CCD7D3CB3_1109180672 = (!this.retransmissionAlertEnabled || sipStack.isTransactionPendingAck(this));
                        {
                            {
                                boolean var3D62795F819C4F4A78C4C4D50F93A26D_869941565 = (lastResponse.getStatusCode() / 100 > 2 && !this.isAckSeen);
                                super.sendMessage(lastResponse);
                            } //End collapsed parenthetic
                        } //End block
                        {
                            SipProviderImpl sipProvider;
                            sipProvider = (SipProviderImpl) this.getSipProvider();
                            TimeoutEvent txTimeout;
                            txTimeout = new TimeoutEvent(sipProvider, this,
                            Timeout.RETRANSMIT);
                            sipProvider.handleEvent(txTimeout, this);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (IOException e)
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_603856874 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logException(e);
            } //End collapsed parenthetic
            raiseErrorEvent(SIPTransactionErrorEvent.TRANSPORT_ERROR);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.696 -0400", hash_original_method = "0BCA3A7152B5F6366E7B8E296683796F", hash_generated_method = "575DA5572982F2F5480FD9E411570ACF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void fireReliableResponseRetransmissionTimer() {
        try 
        {
            super.sendMessage(this.pendingReliableResponse);
        } //End block
        catch (IOException e)
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1700110308 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logException(e);
            } //End collapsed parenthetic
            this.setState(TransactionState.TERMINATED);
            raiseErrorEvent(SIPTransactionErrorEvent.TRANSPORT_ERROR);
        } //End block
        // ---------- Original Method ----------
        //try {
            //super.sendMessage(this.pendingReliableResponse);
        //} catch (IOException e) {
            //if (sipStack.isLoggingEnabled())
                //sipStack.getStackLogger().logException(e);
            //this.setState(TransactionState.TERMINATED);
            //raiseErrorEvent(SIPTransactionErrorEvent.TRANSPORT_ERROR);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.697 -0400", hash_original_method = "5968CF2AF2A16738BF27A6383A99288B", hash_generated_method = "A40EBB09D055B80E2C106E05D7689FB1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void fireTimeoutTimer() {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1153326287 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug("SIPServerTransaction.fireTimeoutTimer this = " + this
                    + " current state = " + this.getRealState() + " method = "
                    + this.getOriginalRequest().getMethod());
        } //End collapsed parenthetic
        {
            boolean varEF6FC70B2BC7D49F8BCB472486B33C54_175345364 = (this.getMethod().equals(Request.INVITE) && sipStack.removeTransactionPendingAck(this));
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_192357421 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logDebug("Found tx pending ACK - returning");
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        SIPDialog dialog;
        dialog = (SIPDialog) this.dialog;
        {
            boolean var711DC0C89C62C02DE2CD55F932C8367D_781684509 = (((SIPTransactionStack) getSIPStack()).isDialogCreated(this.getOriginalRequest()
                .getMethod())
                && (TransactionState.CALLING == this.getRealState() || TransactionState.TRYING == this
                        .getRealState()));
            {
                dialog.setState(SIPDialog.TERMINATED_STATE);
            } //End block
            {
                boolean var156C74E4AAD691E5CB6FF740A659469E_313698125 = (getOriginalRequest().getMethod().equals(Request.BYE));
                {
                    {
                        boolean var25DCA70E60C9BD5E73FEEE9C67F8FE8D_1877136936 = (dialog != null && dialog.isTerminatedOnBye());
                        dialog.setState(SIPDialog.TERMINATED_STATE);
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            boolean varCFF580A9355E4A0C03337D867841029A_812477079 = (TransactionState.COMPLETED == this.getRealState() && isInviteTransaction());
            {
                raiseErrorEvent(SIPTransactionErrorEvent.TIMEOUT_ERROR);
                this.setState(TransactionState.TERMINATED);
                sipStack.removeTransaction(this);
            } //End block
            {
                boolean var25FD7C39D77376EA66ABD6B6A3394696_208295522 = (TransactionState.COMPLETED == this.getRealState() && !isInviteTransaction());
                {
                    this.setState(TransactionState.TERMINATED);
                    sipStack.removeTransaction(this);
                } //End block
                {
                    boolean var1CCAF0837A5E3451C311A891D0BFBFA5_1545711710 = (TransactionState.CONFIRMED == this.getRealState() && isInviteTransaction());
                    {
                        this.setState(TransactionState.TERMINATED);
                        sipStack.removeTransaction(this);
                    } //End block
                    {
                        boolean var626203FAA050ECF54DFCECDFAF1D2110_234124511 = (!isInviteTransaction()
                && (TransactionState.COMPLETED == this.getRealState() || TransactionState.CONFIRMED == this
                        .getRealState()));
                        {
                            this.setState(TransactionState.TERMINATED);
                        } //End block
                        {
                            boolean varA83559C532D246A8888DBE7C8E979F66_610899895 = (isInviteTransaction() && TransactionState.TERMINATED == this.getRealState());
                            {
                                raiseErrorEvent(SIPTransactionErrorEvent.TIMEOUT_ERROR);
                                dialog.setState(SIPDialog.TERMINATED_STATE);
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.697 -0400", hash_original_method = "025E14F038A1EDFF743C73F970E03870", hash_generated_method = "6CA18EFF87D6D0650D9606EE0F8C1041")
    @DSModeled(DSC.SAFE)
    public SIPResponse getLastResponse() {
        return (SIPResponse)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.lastResponse;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.697 -0400", hash_original_method = "2F3F0F5B57F408B788FCEFEE82B8B33E", hash_generated_method = "70F04ACD8508FD6E2BBCB175FF286322")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOriginalRequest(SIPRequest originalRequest) {
        dsTaint.addTaint(originalRequest.dsTaint);
        super.setOriginalRequest(originalRequest);
        // ---------- Original Method ----------
        //super.setOriginalRequest(originalRequest);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.699 -0400", hash_original_method = "2923FE4F478A1D65305B36AFA83919C7", hash_generated_method = "A5D57BAE4501B956E7DE017246C19F91")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendResponse(Response response) throws SipException {
        dsTaint.addTaint(response.dsTaint);
        SIPResponse sipResponse;
        sipResponse = (SIPResponse) response;
        SIPDialog dialog;
        dialog = this.dialog;
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null response");
        try 
        {
            sipResponse.checkHeaders();
        } //End block
        catch (ParseException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException(ex.getMessage());
        } //End block
        {
            boolean var801A8C3D02E183B03ADD76B333CD9A04_2071371960 = (!sipResponse.getCSeq().getMethod().equals(this.getMethod()));
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException(
                    "CSeq method does not match Request method of request that created the tx.");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var8583F5323A2033F484FF44920C32DA17_2104598237 = (this.getMethod().equals(Request.SUBSCRIBE) && response.getStatusCode() / 100 == 2);
            {
                {
                    boolean var93328E4C9F22EEBC88D387CD7D731566_216650039 = (response.getHeader(ExpiresHeader.NAME) == null);
                    {
                        if (DroidSafeAndroidRuntime.control) throw new SipException("Expires header is mandatory in 2xx response of SUBSCRIBE");
                    } //End block
                    {
                        Expires requestExpires;
                        requestExpires = (Expires) this.getOriginalRequest().getExpires();
                        Expires responseExpires;
                        responseExpires = (Expires) response.getExpires();
                        {
                            boolean varE0075A921B603BC9E570B9DCD721F865_1935126740 = (requestExpires != null
                        && responseExpires.getExpires() > requestExpires.getExpires());
                            {
                                if (DroidSafeAndroidRuntime.control) throw new SipException(
                            "Response Expires time exceeds request Expires time : See RFC 3265 3.1.1");
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean var608F5ADBEDAABF2EF2941E100485A93B_97504468 = (sipResponse.getStatusCode() == 200
                && sipResponse.getCSeq().getMethod().equals(Request.INVITE)
                && sipResponse.getHeader(ContactHeader.NAME) == null);
            if (DroidSafeAndroidRuntime.control) throw new SipException("Contact Header is mandatory for the OK to the INVITE");
        } //End collapsed parenthetic
        {
            boolean var4C5755F16C1843940C46C342BE021419_1394622095 = (!this.isMessagePartOfTransaction((SIPMessage) response));
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException("Response does not belong to this transaction.");
            } //End block
        } //End collapsed parenthetic
        try 
        {
            {
                boolean var62FEEBDDF118C29D5B0B13E4A8ACA7C2_1732027707 = (this.pendingReliableResponse != null
                    && this.getDialog() != null 
                    && this.getState() != TransactionState.TERMINATED
                    && ((SIPResponse)response).getContentTypeHeader() != null 
                    && response.getStatusCode() / 100 == 2
                    && ((SIPResponse)response).getContentTypeHeader().getContentType()
                            .equalsIgnoreCase("application")
                    && ((SIPResponse)response).getContentTypeHeader().getContentSubType()
                            .equalsIgnoreCase("sdp"));
                {
                    try 
                    {
                        boolean acquired;
                        acquired = this.provisionalResponseSem.tryAcquire(1,TimeUnit.SECONDS);
                        {
                            if (DroidSafeAndroidRuntime.control) throw new SipException("cannot send response -- unacked povisional");
                        } //End block
                    } //End block
                    catch (Exception ex)
                    {
                        this.sipStack.getStackLogger().logError("Could not acquire PRACK sem ", ex);
                    } //End block
                } //End block
                {
                    {
                        boolean var8F764FF06393918761F5329F48DCA88C_1208212081 = (this.pendingReliableResponse != null && sipResponse.isFinalResponse());
                        {
                            this.provisionalResponseTask.cancel();
                            this.provisionalResponseTask = null;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                {
                    boolean varE68D4938E58071426E636D9DE0E3BAE2_1036030644 = (sipResponse.getStatusCode() / 100 == 2
                        && sipStack.isDialogCreated(sipResponse.getCSeq().getMethod()));
                    {
                        {
                            boolean var184229ADA4EC9A360B6355C36A07A7F2_965498335 = (dialog.getLocalTag() == null && sipResponse.getTo().getTag() == null);
                            {
                                sipResponse.getTo().setTag(Utils.getInstance().generateTag());
                            } //End block
                            {
                                boolean varA69779C1F2CA85BA38B8448E6C4853B8_808079295 = (dialog.getLocalTag() != null && sipResponse.getToTag() == null);
                                {
                                    sipResponse.setToTag(dialog.getLocalTag());
                                } //End block
                                {
                                    boolean var488A66FF6BCB78677776FD18AA65B909_830676335 = (dialog.getLocalTag() != null && sipResponse.getToTag() != null
                            && !dialog.getLocalTag().equals(sipResponse.getToTag()));
                                    {
                                        if (DroidSafeAndroidRuntime.control) throw new SipException("Tag mismatch dialogTag is "
                                + dialog.getLocalTag() + " responseTag is "
                                + sipResponse.getToTag());
                                    } //End block
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var8AE1B0983C2CD6366DD27EBB35FA7F79_1619443705 = (!sipResponse.getCallId().getCallId().equals(dialog.getCallId().getCallId()));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new SipException("Dialog mismatch!");
                    } //End block
                } //End collapsed parenthetic
            } //End block
            String fromTag;
            fromTag = ((SIPRequest) this.getRequest()).getFrom().getTag();
            {
                boolean var97E814CAC40627CCA3A20A4845B25C15_1278653108 = (fromTag != null && sipResponse.getFromTag() != null
                    && !sipResponse.getFromTag().equals(fromTag));
                {
                    if (DroidSafeAndroidRuntime.control) throw new SipException("From tag of request does not match response from tag");
                } //End block
                {
                    sipResponse.getFrom().setTag(fromTag);
                } //End block
                {
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_2043342910 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger().logDebug("WARNING -- Null From tag in request!!");
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                boolean var97953C067604E07F88AD861C7C5D5DA2_140848108 = (dialog != null && response.getStatusCode() != 100);
                {
                    dialog.setResponseTags(sipResponse);
                    DialogState oldState;
                    oldState = dialog.getState();
                    dialog.setLastResponse(this, (SIPResponse) response);
                    {
                        boolean varA156AA3B1C7CA86C5BD16CB73196F418_1225144726 = (oldState == null && dialog.getState() == DialogState.TERMINATED);
                        {
                            DialogTerminatedEvent event;
                            event = new DialogTerminatedEvent(dialog
                            .getSipProvider(), dialog);
                            dialog.getSipProvider().handleEvent(event, this);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean var4979DEAA4AC1E02739C120A9086D1CAF_234821558 = (dialog == null && this.getMethod().equals(Request.INVITE)
                    && this.retransmissionAlertEnabled
                    && this.retransmissionAlertTimerTask == null
                    && response.getStatusCode() / 100 == 2);
                    {
                        String dialogId;
                        dialogId = ((SIPResponse) response).getDialogId(true);
                        this.retransmissionAlertTimerTask = new RetransmissionAlertTimerTask(dialogId);
                        sipStack.retransmissionAlertTransactions.put(dialogId, this);
                        sipStack.getTimer().schedule(this.retransmissionAlertTimerTask, 0,
                        SIPTransactionStack.BASE_TIMER_INTERVAL);
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            this.sendMessage((SIPResponse) response);
            {
                dialog.startRetransmitTimer(this, (SIPResponse)response);
            } //End block
        } //End block
        catch (IOException ex)
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1863086258 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logException(ex);
            } //End collapsed parenthetic
            this.setState(TransactionState.TERMINATED);
            raiseErrorEvent(SIPTransactionErrorEvent.TRANSPORT_ERROR);
            if (DroidSafeAndroidRuntime.control) throw new SipException(ex.getMessage());
        } //End block
        catch (java.text.ParseException ex1)
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1426516659 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logException(ex1);
            } //End collapsed parenthetic
            this.setState(TransactionState.TERMINATED);
            if (DroidSafeAndroidRuntime.control) throw new SipException(ex1.getMessage());
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.700 -0400", hash_original_method = "094652DDD499EE6CA69CC6BEDE88479D", hash_generated_method = "0844837230BA7F626F8E27683AB1CB5E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private TransactionState getRealState() {
        TransactionState var6DC46E5EB12BD4CDE66858BE075D764E_2139348841 = (super.getState());
        return (TransactionState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return super.getState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.700 -0400", hash_original_method = "1CF9EDD0CC0B815CCCB8459FE319457E", hash_generated_method = "4611479BE6434ACB78F1F778F6DC0D54")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TransactionState getState() {
        {
            boolean var2D23FC6A2E71E23CD23FAA7D8D6238DD_99696218 = (this.isInviteTransaction() && TransactionState.TRYING == super.getState());
            TransactionState var85633779C9C1785ADAF1DE8B686337A0_885783211 = (super.getState());
        } //End collapsed parenthetic
        return (TransactionState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (this.isInviteTransaction() && TransactionState.TRYING == super.getState())
            //return TransactionState.PROCEEDING;
        //else
            //return super.getState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.700 -0400", hash_original_method = "64016F2524A7B9A8D94F9FFA297FAA00", hash_generated_method = "21496DC892663E69824385AB8E66A6FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setState(TransactionState newState) {
        dsTaint.addTaint(newState.dsTaint);
        {
            boolean varCEADFBA66948576529EAE152B0D866E5_1665191408 = (newState == TransactionState.TERMINATED && this.isReliable()
                && (!getSIPStack().cacheServerConnections));
            {
                this.collectionTime = TIMER_J;
            } //End block
        } //End collapsed parenthetic
        super.setState(newState);
        // ---------- Original Method ----------
        //if (newState == TransactionState.TERMINATED && this.isReliable()
                //&& (!getSIPStack().cacheServerConnections)) {
            //this.collectionTime = TIMER_J;
        //}
        //super.setState(newState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.700 -0400", hash_original_method = "058740AD5F567A2FC597464136294293", hash_generated_method = "4CBC97DE69113E79D9058035A5A1ACFD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void startTransactionTimer() {
        {
            boolean var388A148DB1BAAE2BABBFD1571EA90BBF_1134174174 = (this.transactionTimerStarted.compareAndSet(false, true));
            {
                {
                    boolean var7F2874EE26E943E6FA8451457423E55A_2059599224 = (sipStack.getTimer() != null);
                    {
                        TimerTask myTimer;
                        myTimer = new TransactionTimer();
                        sipStack.getTimer().schedule(myTimer, BASE_TIMER_INTERVAL, BASE_TIMER_INTERVAL);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (this.transactionTimerStarted.compareAndSet(false, true)) {
        	//if (sipStack.getTimer() != null) {
                //TimerTask myTimer = new TransactionTimer();
                //sipStack.getTimer().schedule(myTimer, BASE_TIMER_INTERVAL, BASE_TIMER_INTERVAL);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.701 -0400", hash_original_method = "169DE8D7E50E65E71C46333CC9B26BAF", hash_generated_method = "00A3E701668919CBEEDD0F59FCB4E01D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        {
            boolean varAC16F771BB29A32F2C455E410359AF13_1604669010 = (!other.getClass().equals(this.getClass()));
        } //End collapsed parenthetic
        SIPServerTransaction sst;
        sst = (SIPServerTransaction) other;
        boolean var5237E4625EB90BEF6FB94591F11614C6_1421929497 = (this.getBranch().equalsIgnoreCase(sst.getBranch()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!other.getClass().equals(this.getClass())) {
            //return false;
        //}
        //SIPServerTransaction sst = (SIPServerTransaction) other;
        //return this.getBranch().equalsIgnoreCase(sst.getBranch());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.701 -0400", hash_original_method = "BF9D0C52E87E80DCC85E6728CE121EFC", hash_generated_method = "C7A6E6FA48C28766F0A0FF1096210D91")
    @DSModeled(DSC.SAFE)
    public Dialog getDialog() {
        return (Dialog)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.dialog;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.701 -0400", hash_original_method = "7270FFD660AE92D45E417229D33FB869", hash_generated_method = "53AF8B3FC921E6D735A9ACB106C14353")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDialog(SIPDialog sipDialog, String dialogId) {
        dsTaint.addTaint(sipDialog.dsTaint);
        dsTaint.addTaint(dialogId);
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_2074501328 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug("setDialog " + this + " dialog = " + sipDialog);
        } //End collapsed parenthetic
        this.dialog.setAssigned();
        {
            this.retransmissionAlertTimerTask.cancel();
            {
                sipStack.retransmissionAlertTransactions
                        .remove(this.retransmissionAlertTimerTask.dialogId);
            } //End block
            this.retransmissionAlertTimerTask = null;
        } //End block
        this.retransmissionAlertEnabled = false;
        // ---------- Original Method ----------
        //if (sipStack.isLoggingEnabled())
            //sipStack.getStackLogger().logDebug("setDialog " + this + " dialog = " + sipDialog);
        //this.dialog = sipDialog;
        //if (dialogId != null)
            //this.dialog.setAssigned();
        //if (this.retransmissionAlertEnabled && this.retransmissionAlertTimerTask != null) {
            //this.retransmissionAlertTimerTask.cancel();
            //if (this.retransmissionAlertTimerTask.dialogId != null) {
                //sipStack.retransmissionAlertTransactions
                        //.remove(this.retransmissionAlertTimerTask.dialogId);
            //}
            //this.retransmissionAlertTimerTask = null;
        //}
        //this.retransmissionAlertEnabled = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.701 -0400", hash_original_method = "2BF0F9BA137AD2AD36F3D6B0DBFD2123", hash_generated_method = "93F6BA068808A87C03214CC0464D1E10")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void terminate() throws ObjectInUseException {
        this.setState(TransactionState.TERMINATED);
        {
            this.retransmissionAlertTimerTask.cancel();
            {
                this.sipStack.retransmissionAlertTransactions
                        .remove(retransmissionAlertTimerTask.dialogId);
            } //End block
            this.retransmissionAlertTimerTask = null;
        } //End block
        // ---------- Original Method ----------
        //this.setState(TransactionState.TERMINATED);
        //if (this.retransmissionAlertTimerTask != null) {
            //this.retransmissionAlertTimerTask.cancel();
            //if (retransmissionAlertTimerTask.dialogId != null) {
                //this.sipStack.retransmissionAlertTransactions
                        //.remove(retransmissionAlertTimerTask.dialogId);
            //}
            //this.retransmissionAlertTimerTask = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.702 -0400", hash_original_method = "113CF757EF1C74D90A992F25B2E0E550", hash_generated_method = "35E73EFBFEF7E9BBE74E5F6404E0B37F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void sendReliableProvisionalResponse(Response relResponse) throws SipException {
        dsTaint.addTaint(relResponse.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("Unacknowledged response");
        } //End block
        this.pendingReliableResponse = (SIPResponse) relResponse;
        RSeq rseq;
        rseq = (RSeq) relResponse.getHeader(RSeqHeader.NAME);
        {
            boolean varF6446DCD94E2B8540E59A055166427B1_2116875329 = (relResponse.getHeader(RSeqHeader.NAME) == null);
            {
                rseq = new RSeq();
                relResponse.setHeader(rseq);
            } //End block
        } //End collapsed parenthetic
        try 
        {
            rseq.setSeqNumber(this.rseqNumber);
            this.lastResponse = (SIPResponse) relResponse;
            {
                boolean varB2200E3DA6206F41DF738AE7D772F7AB_1779607835 = (this.getDialog() != null);
                {
                    boolean acquired;
                    acquired = this.provisionalResponseSem.tryAcquire(1, TimeUnit.SECONDS);
                    {
                        if (DroidSafeAndroidRuntime.control) throw new SipException("Unacknowledged response");
                    } //End block
                } //End block
            } //End collapsed parenthetic
            this.sendMessage((SIPMessage) relResponse);
            this.provisionalResponseTask = new ProvisionalResponseTask();
            this.sipStack.getTimer().schedule(provisionalResponseTask, 0,
                    SIPTransactionStack.BASE_TIMER_INTERVAL);
        } //End block
        catch (Exception ex)
        {
            InternalErrorHandler.handleException(ex);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.702 -0400", hash_original_method = "423AF4ABBE12E54C6351754EACC47E3E", hash_generated_method = "627E8B4196DDE120A51918ACB36E9C16")
    @DSModeled(DSC.SAFE)
    public SIPResponse getReliableProvisionalResponse() {
        return (SIPResponse)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.pendingReliableResponse;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.702 -0400", hash_original_method = "C1242B9BCB6EB14AE3EB1BD030AE911A", hash_generated_method = "076380E060B355A0AB3778BBE6F10611")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean prackRecieved() {
        this.provisionalResponseTask.cancel();
        this.pendingReliableResponse = null;
        this.provisionalResponseSem.release();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (this.pendingReliableResponse == null)
            //return false;
        //if(provisionalResponseTask != null)
        	//this.provisionalResponseTask.cancel();
        //this.pendingReliableResponse = null;
        //this.provisionalResponseSem.release();
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.702 -0400", hash_original_method = "DB7E38B465064167DDC1111F92777A32", hash_generated_method = "2ADB6A3848E70858A7B2015B76886458")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void enableRetransmissionAlerts() throws SipException {
        {
            boolean var156DD83E7B1C45002AC761998FCDC404_412053147 = (this.getDialog() != null);
            if (DroidSafeAndroidRuntime.control) throw new SipException("Dialog associated with tx");
            {
                boolean var32F2D406FABEF0AC68112A69E6467BFF_2011861512 = (!this.getMethod().equals(Request.INVITE));
                if (DroidSafeAndroidRuntime.control) throw new SipException("Request Method must be INVITE");
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        this.retransmissionAlertEnabled = true;
        // ---------- Original Method ----------
        //if (this.getDialog() != null)
            //throw new SipException("Dialog associated with tx");
        //else if (!this.getMethod().equals(Request.INVITE))
            //throw new SipException("Request Method must be INVITE");
        //this.retransmissionAlertEnabled = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.703 -0400", hash_original_method = "9CE3EB2FC8AC208C1528F5A08B1A1A7B", hash_generated_method = "2AE4D8B7D2C4DF74CCC7A5363CC9B285")
    @DSModeled(DSC.SAFE)
    public boolean isRetransmissionAlertEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.retransmissionAlertEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.703 -0400", hash_original_method = "FAB076B51BB167F6E440B2394399BC94", hash_generated_method = "FF65169AA87440CAF426CDB240B0AF89")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void disableRetransmissionAlerts() {
        {
            this.retransmissionAlertTimerTask.cancel();
            this.retransmissionAlertEnabled = false;
            String dialogId;
            dialogId = this.retransmissionAlertTimerTask.dialogId;
            {
                sipStack.retransmissionAlertTransactions.remove(dialogId);
            } //End block
            this.retransmissionAlertTimerTask = null;
        } //End block
        // ---------- Original Method ----------
        //if (this.retransmissionAlertTimerTask != null && this.retransmissionAlertEnabled) {
            //this.retransmissionAlertTimerTask.cancel();
            //this.retransmissionAlertEnabled = false;
            //String dialogId = this.retransmissionAlertTimerTask.dialogId;
            //if (dialogId != null) {
                //sipStack.retransmissionAlertTransactions.remove(dialogId);
            //}
            //this.retransmissionAlertTimerTask = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.703 -0400", hash_original_method = "157974C13DCC3CB54CBF1C9A15C7B6B6", hash_generated_method = "81F3099A5939DE0798711A37A1B51FCD")
    @DSModeled(DSC.SAFE)
    public void setAckSeen() {
        this.isAckSeen = true;
        // ---------- Original Method ----------
        //this.isAckSeen = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.703 -0400", hash_original_method = "C14F76EB0E4E278210A5D612100CE915", hash_generated_method = "CB9DEAA70105B9FDDBD0E0FBE63B6AA6")
    @DSModeled(DSC.SAFE)
    public boolean ackSeen() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.isAckSeen;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.703 -0400", hash_original_method = "6AEC262895B13A63B164E8F6877168F2", hash_generated_method = "11A33D7DFF097EE83AD7C5B6BEA23569")
    @DSModeled(DSC.SAFE)
    public void setMapped(boolean b) {
        dsTaint.addTaint(b);
        this.isMapped = true;
        // ---------- Original Method ----------
        //this.isMapped = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.703 -0400", hash_original_method = "63F9C939BCFFEC59883E0EC5005B2509", hash_generated_method = "76CDFFEE0B71FA2E3546AF3BEAE28D27")
    @DSModeled(DSC.SAFE)
    public void setPendingSubscribe(SIPClientTransaction pendingSubscribeClientTx) {
        dsTaint.addTaint(pendingSubscribeClientTx.dsTaint);
        // ---------- Original Method ----------
        //this.pendingSubscribeTransaction = pendingSubscribeClientTx;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.704 -0400", hash_original_method = "D9515C627E3EA8CE075BBF27F52FBA55", hash_generated_method = "CE150972D60CFCA9ECD3F415D3DD80E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void releaseSem() {
        {
            pendingSubscribeTransaction.releaseSem();
        } //End block
        {
            boolean var4E951FE87424D17F1293F3277DBF59F9_1663987824 = (this.inviteTransaction != null && this.getMethod().equals(Request.CANCEL));
            {
                this.inviteTransaction.releaseSem();
            } //End block
        } //End collapsed parenthetic
        super.releaseSem();
        // ---------- Original Method ----------
        //if (this.pendingSubscribeTransaction != null) {
            //pendingSubscribeTransaction.releaseSem();
        //} else if (this.inviteTransaction != null && this.getMethod().equals(Request.CANCEL)) {
            //this.inviteTransaction.releaseSem();
        //}
        //super.releaseSem();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.704 -0400", hash_original_method = "0E2D0772A5243821270857191F448BEA", hash_generated_method = "2FF99F614BB7706490EE2CB41FD61D8C")
    @DSModeled(DSC.SAFE)
    public void setInviteTransaction(SIPServerTransaction st) {
        dsTaint.addTaint(st.dsTaint);
        // ---------- Original Method ----------
        //this.inviteTransaction = st;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.704 -0400", hash_original_method = "3EE4598A64A5BA68559842E002FBD20B", hash_generated_method = "1DA66FEBBBC54EE184AA743B73338648")
    @DSModeled(DSC.SAFE)
    public SIPServerTransaction getCanceledInviteTransaction() {
        return (SIPServerTransaction)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.inviteTransaction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.704 -0400", hash_original_method = "22BE30BEEA580B63CB3DAB7D5C330535", hash_generated_method = "DC3DC7DF1354B75649CE0828DAF00CB5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void scheduleAckRemoval() throws IllegalStateException {
        {
            boolean varF92C33772DA55683B4274F816A4F87CF_1847964205 = (this.getMethod() == null || !this.getMethod().equals(Request.ACK));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Method is null[" + (getMethod() == null)
                    + "] or method is not ACK[" + this.getMethod() + "]");
            } //End block
        } //End collapsed parenthetic
        this.startTransactionTimer();
        // ---------- Original Method ----------
        //if (this.getMethod() == null || !this.getMethod().equals(Request.ACK)) {
            //throw new IllegalStateException("Method is null[" + (getMethod() == null)
                    //+ "] or method is not ACK[" + this.getMethod() + "]");
        //}
        //this.startTransactionTimer();
    }

    
    class RetransmissionAlertTimerTask extends SIPStackTimerTask {
        String dialogId;
        int ticks;
        int ticksLeft;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.704 -0400", hash_original_method = "D09929C71A38D835F5CB9E6FA68F0FB4", hash_generated_method = "84570CDB6C61A514EB43714F6B039A15")
        @DSModeled(DSC.SAFE)
        public RetransmissionAlertTimerTask(String dialogId) {
            dsTaint.addTaint(dialogId);
            this.ticks = SIPTransaction.T1;
            this.ticksLeft = this.ticks;
            // ---------- Original Method ----------
            //this.ticks = SIPTransaction.T1;
            //this.ticksLeft = this.ticks;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.705 -0400", hash_original_method = "2AF4E8E71B0B58D5A8BFD9769A90D169", hash_generated_method = "32F9D300CA96480AC55B2927181B3868")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected void runTask() {
            SIPServerTransaction serverTransaction;
            serverTransaction = SIPServerTransaction.this;
            {
                serverTransaction.fireRetransmissionTimer();
                this.ticksLeft = 2 * ticks;
            } //End block
            // ---------- Original Method ----------
            //SIPServerTransaction serverTransaction = SIPServerTransaction.this;
            //ticksLeft--;
            //if (ticksLeft == -1) {
                //serverTransaction.fireRetransmissionTimer();
                //this.ticksLeft = 2 * ticks;
            //}
        }

        
    }


    
    class ProvisionalResponseTask extends SIPStackTimerTask {
        int ticks;
        int ticksLeft;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.705 -0400", hash_original_method = "7F2BA0B0C3F62E74BA1198F711026EF0", hash_generated_method = "936AB35C1A1D2D3B3199B32B118A8C98")
        @DSModeled(DSC.SAFE)
        public ProvisionalResponseTask() {
            this.ticks = SIPTransaction.T1;
            this.ticksLeft = this.ticks;
            // ---------- Original Method ----------
            //this.ticks = SIPTransaction.T1;
            //this.ticksLeft = this.ticks;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.706 -0400", hash_original_method = "3BA43FFA8E7EB2E8FD814B03BC519869", hash_generated_method = "42BEB80DF5F84151CC589974B102DB5E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected void runTask() {
            SIPServerTransaction serverTransaction;
            serverTransaction = SIPServerTransaction.this;
            {
                boolean var92C0250C2A0F130E2904551FA7400AFD_1649997882 = (serverTransaction.isTerminated());
                {
                    this.cancel();
                } //End block
                {
                    {
                        serverTransaction.fireReliableResponseRetransmissionTimer();
                        this.ticksLeft = 2 * ticks;
                        this.ticks = this.ticksLeft;
                        {
                            this.cancel();
                            setState(TERMINATED_STATE);
                            fireTimeoutTimer();
                        } //End block
                    } //End block
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //SIPServerTransaction serverTransaction = SIPServerTransaction.this;
            //if (serverTransaction.isTerminated()) {
                //this.cancel();
            //} else {
                //ticksLeft--;
                //if (ticksLeft == -1) {
                    //serverTransaction.fireReliableResponseRetransmissionTimer();
                    //this.ticksLeft = 2 * ticks;
                    //this.ticks = this.ticksLeft;
                    //if (this.ticksLeft >= SIPTransaction.TIMER_H) {
                        //this.cancel();
                        //setState(TERMINATED_STATE);
                        //fireTimeoutTimer();
                    //}
                //}
            //}
        }

        
    }


    
    class ListenerExecutionMaxTimer extends SIPStackTimerTask {
        SIPServerTransaction serverTransaction = SIPServerTransaction.this;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.706 -0400", hash_original_method = "250D0DA46E4093885E0FDCBFA4428EAC", hash_generated_method = "C6F9312E02D3396BE69D6D2069B3841F")
        @DSModeled(DSC.SAFE)
         ListenerExecutionMaxTimer() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.707 -0400", hash_original_method = "FEDCDB906765008977DAE6268EB71EAC", hash_generated_method = "EE33E766593B1C289D7000929443CAF2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected void runTask() {
            try 
            {
                {
                    boolean varE423BC89CF656037002A9576F6AD2233_1381984127 = (serverTransaction.getState() == null);
                    {
                        serverTransaction.terminate();
                        SIPTransactionStack sipStack;
                        sipStack = serverTransaction.getSIPStack();
                        sipStack.removePendingTransaction(serverTransaction);
                        sipStack.removeTransaction(serverTransaction);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            catch (Exception ex)
            {
                sipStack.getStackLogger().logError("unexpected exception", ex);
            } //End block
            // ---------- Original Method ----------
            //try {
                //if (serverTransaction.getState() == null) {
                    //serverTransaction.terminate();
                    //SIPTransactionStack sipStack = serverTransaction.getSIPStack();
                    //sipStack.removePendingTransaction(serverTransaction);
                    //sipStack.removeTransaction(serverTransaction);
                //}
            //} catch (Exception ex) {
                //sipStack.getStackLogger().logError("unexpected exception", ex);
            //}
        }

        
    }


    
    class SendTrying extends SIPStackTimerTask {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.707 -0400", hash_original_method = "C30DBC53FC262811E7ACF1B35A336493", hash_generated_method = "16720364D799D18F02921B5684357044")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected SendTrying() {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_2014510145 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug("scheduled timer for " + SIPServerTransaction.this);
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (sipStack.isLoggingEnabled())
                //sipStack.getStackLogger().logDebug("scheduled timer for " + SIPServerTransaction.this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.708 -0400", hash_original_method = "F91C856C78DFF19E74F73B1B16259454", hash_generated_method = "2D9CC8F911730C87500E3AA3C4007083")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected void runTask() {
            SIPServerTransaction serverTransaction;
            serverTransaction = SIPServerTransaction.this;
            TransactionState realState;
            realState = serverTransaction.getRealState();
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1993585589 = (sipStack.isLoggingEnabled());
                    sipStack.getStackLogger().logDebug(" sending Trying current state = "
                            + serverTransaction.getRealState());
                } //End collapsed parenthetic
                try 
                {
                    serverTransaction.sendMessage(serverTransaction.getOriginalRequest()
                            .createResponse(100, "Trying"));
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1888343657 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger().logDebug(" trying sent "
                                + serverTransaction.getRealState());
                    } //End collapsed parenthetic
                } //End block
                catch (IOException ex)
                {
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_2035757583 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger().logError("IO error sending  TRYING");
                    } //End collapsed parenthetic
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    class TransactionTimer extends SIPStackTimerTask {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.708 -0400", hash_original_method = "3D8EFF77F5EF9F9762C1A26A2D305727", hash_generated_method = "810DD293334F5FB14B956B940679F131")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public TransactionTimer() {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1374911644 = (sipStack.isLoggingEnabled());
                {
                    sipStack.getStackLogger().logDebug("TransactionTimer() : " + getTransactionId());
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (sipStack.isLoggingEnabled()) {
                //sipStack.getStackLogger().logDebug("TransactionTimer() : " + getTransactionId());
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.708 -0400", hash_original_method = "707AEBEB940FDE7695E7CB675FB731EE", hash_generated_method = "D7040C94DBE5ED0833372B71610D788E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected void runTask() {
            {
                boolean var0E63CE6845571602177DE1A2C0337464_698608891 = (isTerminated());
                {
                    try 
                    {
                        this.cancel();
                    } //End block
                    catch (IllegalStateException ex)
                    {
                        {
                            boolean var5D283AADF1997C78E711029DD9E27848_801218551 = (!sipStack.isAlive());
                        } //End collapsed parenthetic
                    } //End block
                    TimerTask myTimer;
                    myTimer = new LingerTimer();
                    sipStack.getTimer().schedule(myTimer,
                        SIPTransactionStack.CONNECTION_LINGER_TIME * 1000);
                } //End block
                {
                    fireTimer();
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (isTerminated()) {
                //try {
                    //this.cancel();
                //} catch (IllegalStateException ex) {
                    //if (!sipStack.isAlive())
                        //return;
                //}
                //TimerTask myTimer = new LingerTimer();
                //sipStack.getTimer().schedule(myTimer,
                        //SIPTransactionStack.CONNECTION_LINGER_TIME * 1000);
            //} else {
                //fireTimer();
            //}
        }

        
    }


    
}

