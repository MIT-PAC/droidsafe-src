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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.251 -0400", hash_original_field = "4FC01D2A5D48A500CF94ED84B859B122", hash_generated_field = "28502708C76D5DD6019AE19DD6820CAF")

    private int rseqNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.251 -0400", hash_original_field = "9F15D4E87A74454813575D63D7C12D0F", hash_generated_field = "C8554195ED77FFA07E4A9EB64441964B")

    private transient ServerRequestInterface requestOf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.251 -0400", hash_original_field = "91C7EC8D1C8BB75E853F70FEE324A43B", hash_generated_field = "EB87748E422C08A91C21F30B889B25BC")

    private SIPDialog dialog;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.251 -0400", hash_original_field = "391570C17AE64479C3955D268F1B5A43", hash_generated_field = "1B65F4A63DBF291C8551F347E58C0645")

    private SIPResponse pendingReliableResponse;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.251 -0400", hash_original_field = "7C9AF5BDE87C0C7EEEA91CD8F8C305B7", hash_generated_field = "F641CCD030A30F9AE3D3689D9113DD0E")

    private ProvisionalResponseTask provisionalResponseTask;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.251 -0400", hash_original_field = "B578245DF9ED3129C921D1C8DA7C1726", hash_generated_field = "098BFE37ADED63A73A471007C93A0B9D")

    private boolean retransmissionAlertEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.251 -0400", hash_original_field = "11238E38421FCCF72D2C726C56BF323D", hash_generated_field = "8C7266D76A37BFC3977933B6EEA4448F")

    private RetransmissionAlertTimerTask retransmissionAlertTimerTask;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.251 -0400", hash_original_field = "F959144D32E6BD03C3E0F81E314010B5", hash_generated_field = "E5126B373C1F848FEA63F5658E5B5C6A")

    protected boolean isAckSeen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.251 -0400", hash_original_field = "C66A13890D3B3C00B688345D1719D77E", hash_generated_field = "7878146F4B75217C90AD253031C2AB2F")

    private SIPClientTransaction pendingSubscribeTransaction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.251 -0400", hash_original_field = "812E50456F3CD0D4A6427367F4222311", hash_generated_field = "BE6AC6CBDC82F6C7D74085E5CA0E7140")

    private SIPServerTransaction inviteTransaction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.251 -0400", hash_original_field = "15FEF2927CF9187A0725F755912B7A04", hash_generated_field = "D0DC33FA09DF277419E9D78A6DADBDC8")

    private Semaphore provisionalResponseSem = new Semaphore(1);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.259 -0400", hash_original_method = "D29C36EF10CFF1709E916D648669409B", hash_generated_method = "E7E7C3E9D20C6ACC16DE4464917E3A00")
    protected  SIPServerTransaction(SIPTransactionStack sipStack, MessageChannel newChannelToUse) {
        super(sipStack, newChannelToUse);
        {
            sipStack.getTimer().schedule(new ListenerExecutionMaxTimer(),
                    sipStack.maxListenerResponseTime * 1000);
        } //End block
        this.rseqNumber = (int) (Math.random() * 1000);
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1323127998 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("Creating Server Transaction" + this.getBranchId());
                sipStack.getStackLogger().logStackTrace();
            } //End block
        } //End collapsed parenthetic
        addTaint(sipStack.getTaint());
        addTaint(newChannelToUse.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.274 -0400", hash_original_method = "05CFFFBF5E08267473584C7C9C8831C7", hash_generated_method = "1D121E1C86207505B911401960406644")
    private void sendResponse(SIPResponse transactionResponse) throws IOException {
        try 
        {
            {
                boolean var9EFBE966E135F730A1154D9309908C82_612064553 = (isReliable());
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
                            boolean var8BC61AB78A469B78B9FFCADF874AA2E5_844314833 = (transport.equalsIgnoreCase("TLS"));
                            port = 5061;
                            port = 5060;
                        } //End collapsed parenthetic
                    } //End block
                    String host;
                    host = null;
                    {
                        boolean varFAB52FD2A0D0415EDF52868F4EC52466_1004143506 = (via.getMAddr() != null);
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
        addTaint(transactionResponse.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.283 -0400", hash_original_method = "D3B4FF5E31929A9875E21530A6B99142", hash_generated_method = "3EEBB02788635AC8FD8E72B990DB01D4")
    public void setRequestInterface(ServerRequestInterface newRequestOf) {
        requestOf = newRequestOf;
        // ---------- Original Method ----------
        //requestOf = newRequestOf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.283 -0400", hash_original_method = "BE06A4E585FD9A272717267C4A83F5CF", hash_generated_method = "97A5E389AC7037B4E256F9CBCC8304A7")
    public MessageChannel getResponseChannel() {
        MessageChannel varB4EAC82CA7396A68D541C85D26508E83_1285278648 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1285278648 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1285278648.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1285278648;
        // ---------- Original Method ----------
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.287 -0400", hash_original_method = "EE01791F9851138F67FFB678FE608E3C", hash_generated_method = "F3887A5A938F3047CC07CEBE5FCFF417")
    public boolean isMessagePartOfTransaction(SIPMessage messageToTest) {
        ViaList viaHeaders;
        Via topViaHeader;
        String messageBranch;
        boolean transactionMatches;
        transactionMatches = false;
        String method;
        method = messageToTest.getCSeq().getMethod();
        {
            boolean varA587C943C2619AFFE13B94F1AB583610_1084639596 = ((method.equals(Request.INVITE) || !isTerminated()));
            {
                viaHeaders = messageToTest.getViaHeaders();
                {
                    topViaHeader = (Via) viaHeaders.getFirst();
                    messageBranch = topViaHeader.getBranch();
                    {
                        {
                            boolean varB0B1855F9231D6A8F5FD28941F9BDDD0_191336192 = (!messageBranch.toLowerCase().startsWith(
                            SIPConstants.BRANCH_MAGIC_COOKIE_LOWER_CASE));
                            {
                                messageBranch = null;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        boolean varE32D6D22F4CE4924781A107A8FB175B2_78238280 = (messageBranch != null && this.getBranch() != null);
                        {
                            {
                                boolean var6D97B93142EE0960BB0161B3820BC33B_1154238816 = (method.equals(Request.CANCEL));
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
                                boolean varE3294734A663B5145970265517B02330_1700093249 = (messageToTest.getCSeq().getMethod().equalsIgnoreCase(Request.CANCEL)
                            && !getOriginalRequest().getCSeq().getMethod().equalsIgnoreCase(
                                    Request.CANCEL));
                                {
                                    transactionMatches = false;
                                } //End block
                                {
                                    boolean var8F6BF2C074DDF0DDEAFFC56D2F91B82E_1325996808 = ((isResponse || getOriginalRequest().getRequestURI().equals(
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
        addTaint(messageToTest.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_331963442 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_331963442;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.348 -0400", hash_original_method = "6CCC5EFA22CA085040CD9EF339EE900B", hash_generated_method = "AB7D3983D46EDC420ABFAC258F80A427")
    protected void map() {
        TransactionState realState;
        realState = getRealState();
        {
            {
                boolean var31AB16103AEFA126AE0456128DBB6A94_561195427 = (isInviteTransaction() && !this.isMapped && sipStack.getTimer() != null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.349 -0400", hash_original_method = "7F46EDF7DD1A49A585957DF512054145", hash_generated_method = "86EC3A3046297111CB155D3E6A1FE8E3")
    public boolean isTransactionMapped() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1684561334 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1684561334;
        // ---------- Original Method ----------
        //return this.isMapped;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.357 -0400", hash_original_method = "56FAA78069677544853324F6F2B799B6", hash_generated_method = "8C2AA21DA73302914B157578FF095598")
    public void processRequest(SIPRequest transactionRequest, MessageChannel sourceChannel) {
        boolean toTu;
        toTu = false;
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_524038518 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("processRequest: " + transactionRequest.getFirstLine());
                sipStack.getStackLogger().logDebug("tx state = " + this.getRealState());
            } //End block
        } //End collapsed parenthetic
        try 
        {
            {
                boolean var70CEB3DDCD8D7128B1625311F4A9712B_59439461 = (getRealState() == null);
                {
                    setOriginalRequest(transactionRequest);
                    this.setState(TransactionState.TRYING);
                    toTu = true;
                    this.setPassToListener();
                    {
                        boolean var26B9564585E283B5580BF068A8F2EBC0_1182752319 = (isInviteTransaction() && this.isMapped);
                        {
                            sendMessage(transactionRequest.createResponse(100, "Trying"));
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean var61C63FC44DDBF94E9A005FDACD8F877F_1236606431 = (isInviteTransaction() && TransactionState.COMPLETED == getRealState()
                    && transactionRequest.getMethod().equals(Request.ACK));
                    {
                        this.setState(TransactionState.CONFIRMED);
                        disableRetransmissionTimer();
                        {
                            boolean var6400A483252621139629FC45C6113F96_1585508217 = (!isReliable());
                            {
                                enableTimeoutTimer(TIMER_I);
                            } //End block
                            {
                                this.setState(TransactionState.TERMINATED);
                            } //End block
                        } //End collapsed parenthetic
                        {
                            boolean var0CE4EC8BFDE23852AC02E54D6C0A99C3_1246789222 = (sipStack.isNon2XXAckPassedToListener());
                            {
                                requestOf.processRequest(transactionRequest, this);
                            } //End block
                            {
                                {
                                    boolean varA5D47C3A6259BCCCC2265DD1F84B75D4_1798613658 = (sipStack.isLoggingEnabled());
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
                        boolean var5DCA1F369F7D30BA32EEBBE4FE2D1EC4_161821120 = (transactionRequest.getMethod().equals(getOriginalRequest().getMethod()));
                        {
                            {
                                boolean var513E565483353A4E3D5B26CBC828D863_1740651728 = (TransactionState.PROCEEDING == getRealState()
                        || TransactionState.COMPLETED == getRealState());
                                {
                                    this.semRelease();
                                    {
                                        super.sendMessage(lastResponse);
                                    } //End block
                                } //End block
                                {
                                    boolean var261C36BF61BB943A059F423FCF36B492_745744495 = (transactionRequest.getMethod().equals(Request.ACK));
                                    {
                                        requestOf.processRequest(transactionRequest, this);
                                        this.semRelease();
                                    } //End block
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_1252438898 = (sipStack.isLoggingEnabled());
                                sipStack.getStackLogger().logDebug("completed processing retransmitted request : "
                        + transactionRequest.getFirstLine() + this + " txState = "
                        + this.getState() + " lastResponse = " + this.getLastResponse());
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            {
                boolean var138A866FF284A265491C1CE49B1F033D_1412461277 = (TransactionState.COMPLETED != getRealState()
                    && TransactionState.TERMINATED != getRealState() && requestOf != null);
                {
                    {
                        boolean var1B84E64E4073F1ABC138FA35CD2C39EE_1967395464 = (getOriginalRequest().getMethod().equals(transactionRequest.getMethod()));
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
                        boolean var1819F3EAA856749263E5BE101D189558_1969203382 = (((SIPTransactionStack) getSIPStack()).isDialogCreated(getOriginalRequest()
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
                            boolean var9CD63E03739FECA68F9AFA5AAC7AA721_371500940 = (transactionRequest.getMethod().equals(Request.CANCEL));
                            {
                                {
                                    boolean varA5D47C3A6259BCCCC2265DD1F84B75D4_45327968 = (sipStack.isLoggingEnabled());
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
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1237170325 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger().logDebug("Dropping request " + getRealState());
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (IOException e)
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_467374854 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logError("IOException " ,e);
            } //End collapsed parenthetic
            this.semRelease();
            this.raiseIOExceptionEvent();
        } //End block
        addTaint(transactionRequest.getTaint());
        addTaint(sourceChannel.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.370 -0400", hash_original_method = "2B73C982341966F86ADBEA04AC7851BC", hash_generated_method = "E1B7091921C5AFCDDBD21B7FACC2BCA4")
    public void sendMessage(SIPMessage messageToSend) throws IOException {
        try 
        {
            SIPResponse transactionResponse;
            int statusCode;
            transactionResponse = (SIPResponse) messageToSend;
            statusCode = transactionResponse.getStatusCode();
            try 
            {
                {
                    boolean var2F38972DBED8A4DE733E711CBE4D5C6A_1346287552 = (this.getOriginalRequest().getTopmostVia().getBranch() != null);
                    transactionResponse.getTopmostVia().setBranch(this.getBranch());
                    transactionResponse.getTopmostVia().removeParameter(ParameterNames.BRANCH);
                } //End collapsed parenthetic
                {
                    boolean varC44D49F2E08F6BF8B72E9153D7546CFA_895033328 = (!this.getOriginalRequest().getTopmostVia().hasPort());
                    transactionResponse.getTopmostVia().removePort();
                } //End collapsed parenthetic
            } //End block
            catch (ParseException ex)
            {
                ex.printStackTrace();
            } //End block
            {
                boolean varCDC23963431F718F155919E1B152A5B1_2016615382 = (!transactionResponse.getCSeq().getMethod().equals(
                    getOriginalRequest().getMethod()));
                {
                    sendResponse(transactionResponse);
                } //End block
            } //End collapsed parenthetic
            {
                boolean var4BA81FF05A67431D945A9CCF4269103B_1146258705 = (getRealState() == TransactionState.TRYING);
                {
                    {
                        this.setState(TransactionState.PROCEEDING);
                    } //End block
                    {
                        {
                            boolean var9A31CFD76FE10E8ECD86917959215919_1057004352 = (!isInviteTransaction());
                            {
                                {
                                    boolean var5823DC8E03E92FBA3E90C95804A7C591_196776503 = (!isReliable());
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
                                        boolean var6E7182B6E41B1FA498D147B67D30B4C7_1692800426 = (!isReliable());
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
                    boolean var74E8F15E3DFF3B3C75AA5FCF9E43A983_1924993932 = (getRealState() == TransactionState.PROCEEDING);
                    {
                        {
                            boolean var90CDBC638C52197AEFD58A39118A4F7B_1050402501 = (isInviteTransaction());
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
                                        boolean var6E7182B6E41B1FA498D147B67D30B4C7_431493029 = (!isReliable());
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
                                    boolean var5823DC8E03E92FBA3E90C95804A7C591_257453157 = (!isReliable());
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
                        boolean varFD4EA10AB958789F8E5208FCA031E4F7_1992624682 = (TransactionState.COMPLETED == this.getRealState());
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            try 
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_547598599 = (sipStack.isLoggingEnabled());
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
        addTaint(messageToSend.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.385 -0400", hash_original_method = "57D57213185EECDD5D38603D59833E46", hash_generated_method = "63F4063102AAC0DE9EEE76FA3FA80F09")
    public String getViaHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_389980852 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_389980852 = getMessageChannel().getViaHost();
        varB4EAC82CA7396A68D541C85D26508E83_389980852.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_389980852;
        // ---------- Original Method ----------
        //return getMessageChannel().getViaHost();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.385 -0400", hash_original_method = "AE83C408493AD4624CBF388A7C2A34C7", hash_generated_method = "775BA7EEFBA47A77905062A0B619E1DD")
    public int getViaPort() {
        int var65E79C2A809CF6EB6BDAEEC8693218FB_316447411 = (getMessageChannel().getViaPort());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_611738391 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_611738391;
        // ---------- Original Method ----------
        //return getMessageChannel().getViaPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.386 -0400", hash_original_method = "E1523787F7609795EF3E130FC3FDDFF0", hash_generated_method = "5745195D1A03308D06BB40FFF1643C1E")
    protected void fireRetransmissionTimer() {
        try 
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_936647791 = (sipStack.isLoggingEnabled());
                {
                    sipStack.getStackLogger().logDebug("fireRetransmissionTimer() -- ");
                } //End block
            } //End collapsed parenthetic
            {
                boolean var97506D4608B4B086F590DABBD0CD0224_871237796 = (isInviteTransaction() && lastResponse != null);
                {
                    {
                        boolean varF7C06CC5B09327E8D335DE2CCD7D3CB3_733139027 = (!this.retransmissionAlertEnabled || sipStack.isTransactionPendingAck(this));
                        {
                            {
                                boolean var3D62795F819C4F4A78C4C4D50F93A26D_1980060382 = (lastResponse.getStatusCode() / 100 > 2 && !this.isAckSeen);
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
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1092955236 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logException(e);
            } //End collapsed parenthetic
            raiseErrorEvent(SIPTransactionErrorEvent.TRANSPORT_ERROR);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.387 -0400", hash_original_method = "0BCA3A7152B5F6366E7B8E296683796F", hash_generated_method = "39E8B446600E3B02D36EE1EA6F2981B5")
    private void fireReliableResponseRetransmissionTimer() {
        try 
        {
            super.sendMessage(this.pendingReliableResponse);
        } //End block
        catch (IOException e)
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_540528997 = (sipStack.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.401 -0400", hash_original_method = "5968CF2AF2A16738BF27A6383A99288B", hash_generated_method = "362ED60E6108F61281B7790C60EE626A")
    protected void fireTimeoutTimer() {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1583343070 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug("SIPServerTransaction.fireTimeoutTimer this = " + this
                    + " current state = " + this.getRealState() + " method = "
                    + this.getOriginalRequest().getMethod());
        } //End collapsed parenthetic
        {
            boolean varEF6FC70B2BC7D49F8BCB472486B33C54_529837177 = (this.getMethod().equals(Request.INVITE) && sipStack.removeTransactionPendingAck(this));
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1252821507 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logDebug("Found tx pending ACK - returning");
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        SIPDialog dialog;
        dialog = (SIPDialog) this.dialog;
        {
            boolean var711DC0C89C62C02DE2CD55F932C8367D_1645182449 = (((SIPTransactionStack) getSIPStack()).isDialogCreated(this.getOriginalRequest()
                .getMethod())
                && (TransactionState.CALLING == this.getRealState() || TransactionState.TRYING == this
                        .getRealState()));
            {
                dialog.setState(SIPDialog.TERMINATED_STATE);
            } //End block
            {
                boolean var156C74E4AAD691E5CB6FF740A659469E_985360699 = (getOriginalRequest().getMethod().equals(Request.BYE));
                {
                    {
                        boolean var25DCA70E60C9BD5E73FEEE9C67F8FE8D_824862783 = (dialog != null && dialog.isTerminatedOnBye());
                        dialog.setState(SIPDialog.TERMINATED_STATE);
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            boolean varCFF580A9355E4A0C03337D867841029A_1802270868 = (TransactionState.COMPLETED == this.getRealState() && isInviteTransaction());
            {
                raiseErrorEvent(SIPTransactionErrorEvent.TIMEOUT_ERROR);
                this.setState(TransactionState.TERMINATED);
                sipStack.removeTransaction(this);
            } //End block
            {
                boolean var25FD7C39D77376EA66ABD6B6A3394696_1594041941 = (TransactionState.COMPLETED == this.getRealState() && !isInviteTransaction());
                {
                    this.setState(TransactionState.TERMINATED);
                    sipStack.removeTransaction(this);
                } //End block
                {
                    boolean var1CCAF0837A5E3451C311A891D0BFBFA5_2089018193 = (TransactionState.CONFIRMED == this.getRealState() && isInviteTransaction());
                    {
                        this.setState(TransactionState.TERMINATED);
                        sipStack.removeTransaction(this);
                    } //End block
                    {
                        boolean var626203FAA050ECF54DFCECDFAF1D2110_458049800 = (!isInviteTransaction()
                && (TransactionState.COMPLETED == this.getRealState() || TransactionState.CONFIRMED == this
                        .getRealState()));
                        {
                            this.setState(TransactionState.TERMINATED);
                        } //End block
                        {
                            boolean varA83559C532D246A8888DBE7C8E979F66_70225527 = (isInviteTransaction() && TransactionState.TERMINATED == this.getRealState());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.405 -0400", hash_original_method = "025E14F038A1EDFF743C73F970E03870", hash_generated_method = "2E7024D4EA791201F06B7037120AB74A")
    public SIPResponse getLastResponse() {
        SIPResponse varB4EAC82CA7396A68D541C85D26508E83_1011498669 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1011498669 = this.lastResponse;
        varB4EAC82CA7396A68D541C85D26508E83_1011498669.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1011498669;
        // ---------- Original Method ----------
        //return this.lastResponse;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.405 -0400", hash_original_method = "2F3F0F5B57F408B788FCEFEE82B8B33E", hash_generated_method = "0434A42502203A07E20655688877948B")
    public void setOriginalRequest(SIPRequest originalRequest) {
        super.setOriginalRequest(originalRequest);
        addTaint(originalRequest.getTaint());
        // ---------- Original Method ----------
        //super.setOriginalRequest(originalRequest);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.424 -0400", hash_original_method = "2923FE4F478A1D65305B36AFA83919C7", hash_generated_method = "359432660FA963DD6AB96A378028B7E6")
    public void sendResponse(Response response) throws SipException {
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
            boolean var801A8C3D02E183B03ADD76B333CD9A04_1717899073 = (!sipResponse.getCSeq().getMethod().equals(this.getMethod()));
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException(
                    "CSeq method does not match Request method of request that created the tx.");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var8583F5323A2033F484FF44920C32DA17_575601929 = (this.getMethod().equals(Request.SUBSCRIBE) && response.getStatusCode() / 100 == 2);
            {
                {
                    boolean var93328E4C9F22EEBC88D387CD7D731566_885152917 = (response.getHeader(ExpiresHeader.NAME) == null);
                    {
                        if (DroidSafeAndroidRuntime.control) throw new SipException("Expires header is mandatory in 2xx response of SUBSCRIBE");
                    } //End block
                    {
                        Expires requestExpires;
                        requestExpires = (Expires) this.getOriginalRequest().getExpires();
                        Expires responseExpires;
                        responseExpires = (Expires) response.getExpires();
                        {
                            boolean varE0075A921B603BC9E570B9DCD721F865_1500455928 = (requestExpires != null
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
            boolean var608F5ADBEDAABF2EF2941E100485A93B_371703325 = (sipResponse.getStatusCode() == 200
                && sipResponse.getCSeq().getMethod().equals(Request.INVITE)
                && sipResponse.getHeader(ContactHeader.NAME) == null);
            if (DroidSafeAndroidRuntime.control) throw new SipException("Contact Header is mandatory for the OK to the INVITE");
        } //End collapsed parenthetic
        {
            boolean var4C5755F16C1843940C46C342BE021419_900340538 = (!this.isMessagePartOfTransaction((SIPMessage) response));
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException("Response does not belong to this transaction.");
            } //End block
        } //End collapsed parenthetic
        try 
        {
            {
                boolean var62FEEBDDF118C29D5B0B13E4A8ACA7C2_489434087 = (this.pendingReliableResponse != null
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
                        boolean var8F764FF06393918761F5329F48DCA88C_1268575087 = (this.pendingReliableResponse != null && sipResponse.isFinalResponse());
                        {
                            this.provisionalResponseTask.cancel();
                            this.provisionalResponseTask = null;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                {
                    boolean varE68D4938E58071426E636D9DE0E3BAE2_42819699 = (sipResponse.getStatusCode() / 100 == 2
                        && sipStack.isDialogCreated(sipResponse.getCSeq().getMethod()));
                    {
                        {
                            boolean var184229ADA4EC9A360B6355C36A07A7F2_1366619450 = (dialog.getLocalTag() == null && sipResponse.getTo().getTag() == null);
                            {
                                sipResponse.getTo().setTag(Utils.getInstance().generateTag());
                            } //End block
                            {
                                boolean varA69779C1F2CA85BA38B8448E6C4853B8_782247838 = (dialog.getLocalTag() != null && sipResponse.getToTag() == null);
                                {
                                    sipResponse.setToTag(dialog.getLocalTag());
                                } //End block
                                {
                                    boolean var488A66FF6BCB78677776FD18AA65B909_1326484860 = (dialog.getLocalTag() != null && sipResponse.getToTag() != null
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
                    boolean var8AE1B0983C2CD6366DD27EBB35FA7F79_1686137404 = (!sipResponse.getCallId().getCallId().equals(dialog.getCallId().getCallId()));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new SipException("Dialog mismatch!");
                    } //End block
                } //End collapsed parenthetic
            } //End block
            String fromTag;
            fromTag = ((SIPRequest) this.getRequest()).getFrom().getTag();
            {
                boolean var97E814CAC40627CCA3A20A4845B25C15_1420586409 = (fromTag != null && sipResponse.getFromTag() != null
                    && !sipResponse.getFromTag().equals(fromTag));
                {
                    if (DroidSafeAndroidRuntime.control) throw new SipException("From tag of request does not match response from tag");
                } //End block
                {
                    sipResponse.getFrom().setTag(fromTag);
                } //End block
                {
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_200590768 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger().logDebug("WARNING -- Null From tag in request!!");
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                boolean var97953C067604E07F88AD861C7C5D5DA2_2057079721 = (dialog != null && response.getStatusCode() != 100);
                {
                    dialog.setResponseTags(sipResponse);
                    DialogState oldState;
                    oldState = dialog.getState();
                    dialog.setLastResponse(this, (SIPResponse) response);
                    {
                        boolean varA156AA3B1C7CA86C5BD16CB73196F418_789920139 = (oldState == null && dialog.getState() == DialogState.TERMINATED);
                        {
                            DialogTerminatedEvent event;
                            event = new DialogTerminatedEvent(dialog
                            .getSipProvider(), dialog);
                            dialog.getSipProvider().handleEvent(event, this);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean var4979DEAA4AC1E02739C120A9086D1CAF_544486582 = (dialog == null && this.getMethod().equals(Request.INVITE)
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
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1954082495 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logException(ex);
            } //End collapsed parenthetic
            this.setState(TransactionState.TERMINATED);
            raiseErrorEvent(SIPTransactionErrorEvent.TRANSPORT_ERROR);
            if (DroidSafeAndroidRuntime.control) throw new SipException(ex.getMessage());
        } //End block
        catch (java.text.ParseException ex1)
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1282419635 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logException(ex1);
            } //End collapsed parenthetic
            this.setState(TransactionState.TERMINATED);
            if (DroidSafeAndroidRuntime.control) throw new SipException(ex1.getMessage());
        } //End block
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.438 -0400", hash_original_method = "094652DDD499EE6CA69CC6BEDE88479D", hash_generated_method = "903E95B9D3D3E959C6402CF82A340ADD")
    private TransactionState getRealState() {
        TransactionState varB4EAC82CA7396A68D541C85D26508E83_1603723091 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1603723091 = super.getState();
        varB4EAC82CA7396A68D541C85D26508E83_1603723091.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1603723091;
        // ---------- Original Method ----------
        //return super.getState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.438 -0400", hash_original_method = "1CF9EDD0CC0B815CCCB8459FE319457E", hash_generated_method = "DE4F7FF09E5EACA67DE3DD4CD1C32186")
    public TransactionState getState() {
        TransactionState varB4EAC82CA7396A68D541C85D26508E83_114987163 = null; //Variable for return #1
        TransactionState varB4EAC82CA7396A68D541C85D26508E83_1671549715 = null; //Variable for return #2
        {
            boolean var2D23FC6A2E71E23CD23FAA7D8D6238DD_2019620084 = (this.isInviteTransaction() && TransactionState.TRYING == super.getState());
            varB4EAC82CA7396A68D541C85D26508E83_114987163 = TransactionState.PROCEEDING;
            varB4EAC82CA7396A68D541C85D26508E83_1671549715 = super.getState();
        } //End collapsed parenthetic
        TransactionState varA7E53CE21691AB073D9660D615818899_358317882; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_358317882 = varB4EAC82CA7396A68D541C85D26508E83_114987163;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_358317882 = varB4EAC82CA7396A68D541C85D26508E83_1671549715;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_358317882.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_358317882;
        // ---------- Original Method ----------
        //if (this.isInviteTransaction() && TransactionState.TRYING == super.getState())
            //return TransactionState.PROCEEDING;
        //else
            //return super.getState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.447 -0400", hash_original_method = "64016F2524A7B9A8D94F9FFA297FAA00", hash_generated_method = "263EB55758ED9BFFF0DBEAC33F28F1C9")
    public void setState(TransactionState newState) {
        {
            boolean varCEADFBA66948576529EAE152B0D866E5_173231416 = (newState == TransactionState.TERMINATED && this.isReliable()
                && (!getSIPStack().cacheServerConnections));
            {
                this.collectionTime = TIMER_J;
            } //End block
        } //End collapsed parenthetic
        super.setState(newState);
        addTaint(newState.getTaint());
        // ---------- Original Method ----------
        //if (newState == TransactionState.TERMINATED && this.isReliable()
                //&& (!getSIPStack().cacheServerConnections)) {
            //this.collectionTime = TIMER_J;
        //}
        //super.setState(newState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.447 -0400", hash_original_method = "058740AD5F567A2FC597464136294293", hash_generated_method = "1E770FFA40CAA20E3FF577A9B459C914")
    protected void startTransactionTimer() {
        {
            boolean var388A148DB1BAAE2BABBFD1571EA90BBF_1104279283 = (this.transactionTimerStarted.compareAndSet(false, true));
            {
                {
                    boolean var7F2874EE26E943E6FA8451457423E55A_1374796166 = (sipStack.getTimer() != null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.448 -0400", hash_original_method = "169DE8D7E50E65E71C46333CC9B26BAF", hash_generated_method = "12CC801C1951F16D51E9D49D1B1F829A")
    public boolean equals(Object other) {
        {
            boolean varAC16F771BB29A32F2C455E410359AF13_246502817 = (!other.getClass().equals(this.getClass()));
        } //End collapsed parenthetic
        SIPServerTransaction sst;
        sst = (SIPServerTransaction) other;
        boolean var5237E4625EB90BEF6FB94591F11614C6_1943796076 = (this.getBranch().equalsIgnoreCase(sst.getBranch()));
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1352475433 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1352475433;
        // ---------- Original Method ----------
        //if (!other.getClass().equals(this.getClass())) {
            //return false;
        //}
        //SIPServerTransaction sst = (SIPServerTransaction) other;
        //return this.getBranch().equalsIgnoreCase(sst.getBranch());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.448 -0400", hash_original_method = "BF9D0C52E87E80DCC85E6728CE121EFC", hash_generated_method = "E32514470CE5F80C00B66496FDBF6BF1")
    public Dialog getDialog() {
        Dialog varB4EAC82CA7396A68D541C85D26508E83_1997117057 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1997117057 = this.dialog;
        varB4EAC82CA7396A68D541C85D26508E83_1997117057.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1997117057;
        // ---------- Original Method ----------
        //return this.dialog;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.449 -0400", hash_original_method = "7270FFD660AE92D45E417229D33FB869", hash_generated_method = "7B2A62D71D367703FD4BAFFE98DD062C")
    public void setDialog(SIPDialog sipDialog, String dialogId) {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_931563144 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug("setDialog " + this + " dialog = " + sipDialog);
        } //End collapsed parenthetic
        this.dialog = sipDialog;
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
        addTaint(dialogId.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.473 -0400", hash_original_method = "2BF0F9BA137AD2AD36F3D6B0DBFD2123", hash_generated_method = "93F6BA068808A87C03214CC0464D1E10")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.474 -0400", hash_original_method = "113CF757EF1C74D90A992F25B2E0E550", hash_generated_method = "9F721B603D5AB9803DF47A9E85F27D5B")
    protected void sendReliableProvisionalResponse(Response relResponse) throws SipException {
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("Unacknowledged response");
        } //End block
        this.pendingReliableResponse = (SIPResponse) relResponse;
        RSeq rseq;
        rseq = (RSeq) relResponse.getHeader(RSeqHeader.NAME);
        {
            boolean varF6446DCD94E2B8540E59A055166427B1_539775910 = (relResponse.getHeader(RSeqHeader.NAME) == null);
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
                boolean varB2200E3DA6206F41DF738AE7D772F7AB_2129140137 = (this.getDialog() != null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.482 -0400", hash_original_method = "423AF4ABBE12E54C6351754EACC47E3E", hash_generated_method = "BB8150BDC8C8E7FA202A0DDBD6882E4C")
    public SIPResponse getReliableProvisionalResponse() {
        SIPResponse varB4EAC82CA7396A68D541C85D26508E83_1346799638 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1346799638 = this.pendingReliableResponse;
        varB4EAC82CA7396A68D541C85D26508E83_1346799638.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1346799638;
        // ---------- Original Method ----------
        //return this.pendingReliableResponse;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.483 -0400", hash_original_method = "C1242B9BCB6EB14AE3EB1BD030AE911A", hash_generated_method = "8A22EA39A77A70B9B870D02646B836A7")
    public boolean prackRecieved() {
        this.provisionalResponseTask.cancel();
        this.pendingReliableResponse = null;
        this.provisionalResponseSem.release();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_770616 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_770616;
        // ---------- Original Method ----------
        //if (this.pendingReliableResponse == null)
            //return false;
        //if(provisionalResponseTask != null)
        	//this.provisionalResponseTask.cancel();
        //this.pendingReliableResponse = null;
        //this.provisionalResponseSem.release();
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.484 -0400", hash_original_method = "DB7E38B465064167DDC1111F92777A32", hash_generated_method = "DDA3BCF7E84CE1AEC77AC4C676087182")
    public void enableRetransmissionAlerts() throws SipException {
        {
            boolean var156DD83E7B1C45002AC761998FCDC404_531772044 = (this.getDialog() != null);
            if (DroidSafeAndroidRuntime.control) throw new SipException("Dialog associated with tx");
            {
                boolean var32F2D406FABEF0AC68112A69E6467BFF_638633900 = (!this.getMethod().equals(Request.INVITE));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.484 -0400", hash_original_method = "9CE3EB2FC8AC208C1528F5A08B1A1A7B", hash_generated_method = "195F1A4584C42CFE83341F67ECF482EF")
    public boolean isRetransmissionAlertEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_954620590 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_954620590;
        // ---------- Original Method ----------
        //return this.retransmissionAlertEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.485 -0400", hash_original_method = "FAB076B51BB167F6E440B2394399BC94", hash_generated_method = "FF65169AA87440CAF426CDB240B0AF89")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.488 -0400", hash_original_method = "157974C13DCC3CB54CBF1C9A15C7B6B6", hash_generated_method = "81F3099A5939DE0798711A37A1B51FCD")
    public void setAckSeen() {
        this.isAckSeen = true;
        // ---------- Original Method ----------
        //this.isAckSeen = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.488 -0400", hash_original_method = "C14F76EB0E4E278210A5D612100CE915", hash_generated_method = "E4B3BCC58350D5D444EC39D470043F50")
    public boolean ackSeen() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_849748151 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_849748151;
        // ---------- Original Method ----------
        //return this.isAckSeen;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.489 -0400", hash_original_method = "6AEC262895B13A63B164E8F6877168F2", hash_generated_method = "933B9239F59250FB7BDA3E89093B23A0")
    public void setMapped(boolean b) {
        this.isMapped = true;
        addTaint(b);
        // ---------- Original Method ----------
        //this.isMapped = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.489 -0400", hash_original_method = "63F9C939BCFFEC59883E0EC5005B2509", hash_generated_method = "EC6E81A40B0FF5912A47574DDD99BB8B")
    public void setPendingSubscribe(SIPClientTransaction pendingSubscribeClientTx) {
        this.pendingSubscribeTransaction = pendingSubscribeClientTx;
        // ---------- Original Method ----------
        //this.pendingSubscribeTransaction = pendingSubscribeClientTx;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.490 -0400", hash_original_method = "D9515C627E3EA8CE075BBF27F52FBA55", hash_generated_method = "599B5D674D9E2532730F13D1EEBDB520")
    public void releaseSem() {
        {
            pendingSubscribeTransaction.releaseSem();
        } //End block
        {
            boolean var4E951FE87424D17F1293F3277DBF59F9_1198763318 = (this.inviteTransaction != null && this.getMethod().equals(Request.CANCEL));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.490 -0400", hash_original_method = "0E2D0772A5243821270857191F448BEA", hash_generated_method = "58F6C6E283CD70A04E09BF213A465752")
    public void setInviteTransaction(SIPServerTransaction st) {
        this.inviteTransaction = st;
        // ---------- Original Method ----------
        //this.inviteTransaction = st;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.490 -0400", hash_original_method = "3EE4598A64A5BA68559842E002FBD20B", hash_generated_method = "43EB79A7D03DB1CF7247A056F22B8C34")
    public SIPServerTransaction getCanceledInviteTransaction() {
        SIPServerTransaction varB4EAC82CA7396A68D541C85D26508E83_1164758799 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1164758799 = this.inviteTransaction;
        varB4EAC82CA7396A68D541C85D26508E83_1164758799.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1164758799;
        // ---------- Original Method ----------
        //return this.inviteTransaction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.512 -0400", hash_original_method = "22BE30BEEA580B63CB3DAB7D5C330535", hash_generated_method = "D48CDA86BD34DD87BAFDF80CD0D2E2AE")
    public void scheduleAckRemoval() throws IllegalStateException {
        {
            boolean varF92C33772DA55683B4274F816A4F87CF_902763985 = (this.getMethod() == null || !this.getMethod().equals(Request.ACK));
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.516 -0400", hash_original_field = "2EF3DE78A30BAAA37A078E077DA9C8FF", hash_generated_field = "6D266ECB4501DB72D6B336432EF66FBE")

        String dialogId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.516 -0400", hash_original_field = "48484A39612824059F2E51D06691465B", hash_generated_field = "3C1309F344AFB4C7FE9A836B7928DA16")

        int ticks;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.517 -0400", hash_original_field = "D576537E5E7AF4C474E0D2BD0E3839BC", hash_generated_field = "6753930BED6039429702ABCC2D7DEDDB")

        int ticksLeft;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.517 -0400", hash_original_method = "D09929C71A38D835F5CB9E6FA68F0FB4", hash_generated_method = "E2E1CBC4426DB87B5CEC048A7CEA67A3")
        public  RetransmissionAlertTimerTask(String dialogId) {
            this.ticks = SIPTransaction.T1;
            this.ticksLeft = this.ticks;
            addTaint(dialogId.getTaint());
            // ---------- Original Method ----------
            //this.ticks = SIPTransaction.T1;
            //this.ticksLeft = this.ticks;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.518 -0400", hash_original_method = "2AF4E8E71B0B58D5A8BFD9769A90D169", hash_generated_method = "32F9D300CA96480AC55B2927181B3868")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.525 -0400", hash_original_field = "48484A39612824059F2E51D06691465B", hash_generated_field = "3C1309F344AFB4C7FE9A836B7928DA16")

        int ticks;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.525 -0400", hash_original_field = "D576537E5E7AF4C474E0D2BD0E3839BC", hash_generated_field = "6753930BED6039429702ABCC2D7DEDDB")

        int ticksLeft;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.535 -0400", hash_original_method = "7F2BA0B0C3F62E74BA1198F711026EF0", hash_generated_method = "936AB35C1A1D2D3B3199B32B118A8C98")
        public  ProvisionalResponseTask() {
            this.ticks = SIPTransaction.T1;
            this.ticksLeft = this.ticks;
            // ---------- Original Method ----------
            //this.ticks = SIPTransaction.T1;
            //this.ticksLeft = this.ticks;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.537 -0400", hash_original_method = "3BA43FFA8E7EB2E8FD814B03BC519869", hash_generated_method = "7BDADA091F859F3512175798E932E15D")
        protected void runTask() {
            SIPServerTransaction serverTransaction;
            serverTransaction = SIPServerTransaction.this;
            {
                boolean var92C0250C2A0F130E2904551FA7400AFD_1519518003 = (serverTransaction.isTerminated());
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.537 -0400", hash_original_field = "0D5C3FBA5136D530029D8116C7D37369", hash_generated_field = "5A6CDDF85083E892D7A9B40C9781E270")

        SIPServerTransaction serverTransaction = SIPServerTransaction.this;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.537 -0400", hash_original_method = "250D0DA46E4093885E0FDCBFA4428EAC", hash_generated_method = "C6F9312E02D3396BE69D6D2069B3841F")
          ListenerExecutionMaxTimer() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.538 -0400", hash_original_method = "FEDCDB906765008977DAE6268EB71EAC", hash_generated_method = "AD66C3CAD00BCB5E39A223105DA03F36")
        protected void runTask() {
            try 
            {
                {
                    boolean varE423BC89CF656037002A9576F6AD2233_1418431071 = (serverTransaction.getState() == null);
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.538 -0400", hash_original_method = "C30DBC53FC262811E7ACF1B35A336493", hash_generated_method = "FD03870884CD0FB30F3B7FE0FB95C5DC")
        protected  SendTrying() {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_246536784 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug("scheduled timer for " + SIPServerTransaction.this);
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (sipStack.isLoggingEnabled())
                //sipStack.getStackLogger().logDebug("scheduled timer for " + SIPServerTransaction.this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.543 -0400", hash_original_method = "F91C856C78DFF19E74F73B1B16259454", hash_generated_method = "D2F688334EB5D23AE08F15A03BC5C233")
        protected void runTask() {
            SIPServerTransaction serverTransaction;
            serverTransaction = SIPServerTransaction.this;
            TransactionState realState;
            realState = serverTransaction.getRealState();
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_181930736 = (sipStack.isLoggingEnabled());
                    sipStack.getStackLogger().logDebug(" sending Trying current state = "
                            + serverTransaction.getRealState());
                } //End collapsed parenthetic
                try 
                {
                    serverTransaction.sendMessage(serverTransaction.getOriginalRequest()
                            .createResponse(100, "Trying"));
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1225707452 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger().logDebug(" trying sent "
                                + serverTransaction.getRealState());
                    } //End collapsed parenthetic
                } //End block
                catch (IOException ex)
                {
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1488293149 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger().logError("IO error sending  TRYING");
                    } //End collapsed parenthetic
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    class TransactionTimer extends SIPStackTimerTask {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.543 -0400", hash_original_method = "3D8EFF77F5EF9F9762C1A26A2D305727", hash_generated_method = "BAF2834C46D45E7C3B0DE9945F81DBC6")
        public  TransactionTimer() {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_976720867 = (sipStack.isLoggingEnabled());
                {
                    sipStack.getStackLogger().logDebug("TransactionTimer() : " + getTransactionId());
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (sipStack.isLoggingEnabled()) {
                //sipStack.getStackLogger().logDebug("TransactionTimer() : " + getTransactionId());
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.546 -0400", hash_original_method = "707AEBEB940FDE7695E7CB675FB731EE", hash_generated_method = "16A787AC45CBD7EC7B6FCD43E7B895C1")
        protected void runTask() {
            {
                boolean var0E63CE6845571602177DE1A2C0337464_1111706337 = (isTerminated());
                {
                    try 
                    {
                        this.cancel();
                    } //End block
                    catch (IllegalStateException ex)
                    {
                        {
                            boolean var5D283AADF1997C78E711029DD9E27848_179038751 = (!sipStack.isAlive());
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

