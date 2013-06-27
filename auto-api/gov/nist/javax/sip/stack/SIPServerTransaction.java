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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.274 -0400", hash_original_field = "4FC01D2A5D48A500CF94ED84B859B122", hash_generated_field = "28502708C76D5DD6019AE19DD6820CAF")

    private int rseqNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.274 -0400", hash_original_field = "9F15D4E87A74454813575D63D7C12D0F", hash_generated_field = "C8554195ED77FFA07E4A9EB64441964B")

    private transient ServerRequestInterface requestOf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.274 -0400", hash_original_field = "91C7EC8D1C8BB75E853F70FEE324A43B", hash_generated_field = "EB87748E422C08A91C21F30B889B25BC")

    private SIPDialog dialog;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.274 -0400", hash_original_field = "391570C17AE64479C3955D268F1B5A43", hash_generated_field = "1B65F4A63DBF291C8551F347E58C0645")

    private SIPResponse pendingReliableResponse;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.274 -0400", hash_original_field = "7C9AF5BDE87C0C7EEEA91CD8F8C305B7", hash_generated_field = "F641CCD030A30F9AE3D3689D9113DD0E")

    private ProvisionalResponseTask provisionalResponseTask;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.274 -0400", hash_original_field = "B578245DF9ED3129C921D1C8DA7C1726", hash_generated_field = "098BFE37ADED63A73A471007C93A0B9D")

    private boolean retransmissionAlertEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.274 -0400", hash_original_field = "11238E38421FCCF72D2C726C56BF323D", hash_generated_field = "8C7266D76A37BFC3977933B6EEA4448F")

    private RetransmissionAlertTimerTask retransmissionAlertTimerTask;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.274 -0400", hash_original_field = "F959144D32E6BD03C3E0F81E314010B5", hash_generated_field = "E5126B373C1F848FEA63F5658E5B5C6A")

    protected boolean isAckSeen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.274 -0400", hash_original_field = "C66A13890D3B3C00B688345D1719D77E", hash_generated_field = "7878146F4B75217C90AD253031C2AB2F")

    private SIPClientTransaction pendingSubscribeTransaction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.275 -0400", hash_original_field = "812E50456F3CD0D4A6427367F4222311", hash_generated_field = "BE6AC6CBDC82F6C7D74085E5CA0E7140")

    private SIPServerTransaction inviteTransaction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.275 -0400", hash_original_field = "15FEF2927CF9187A0725F755912B7A04", hash_generated_field = "D0DC33FA09DF277419E9D78A6DADBDC8")

    private Semaphore provisionalResponseSem = new Semaphore(1);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.275 -0400", hash_original_method = "D29C36EF10CFF1709E916D648669409B", hash_generated_method = "087C2AC0E629DB0CD59C670FBE8C2337")
    protected  SIPServerTransaction(SIPTransactionStack sipStack, MessageChannel newChannelToUse) {
        super(sipStack, newChannelToUse);
        {
            sipStack.getTimer().schedule(new ListenerExecutionMaxTimer(),
                    sipStack.maxListenerResponseTime * 1000);
        } //End block
        this.rseqNumber = (int) (Math.random() * 1000);
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1291027075 = (sipStack.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.284 -0400", hash_original_method = "05CFFFBF5E08267473584C7C9C8831C7", hash_generated_method = "62E92FE1D136CC93E36C4E2AE4A132B6")
    private void sendResponse(SIPResponse transactionResponse) throws IOException {
        try 
        {
            {
                boolean var9EFBE966E135F730A1154D9309908C82_584654512 = (isReliable());
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
                            boolean var8BC61AB78A469B78B9FFCADF874AA2E5_304950927 = (transport.equalsIgnoreCase("TLS"));
                            port = 5061;
                            port = 5060;
                        } //End collapsed parenthetic
                    } //End block
                    String host;
                    host = null;
                    {
                        boolean varFAB52FD2A0D0415EDF52868F4EC52466_1777474438 = (via.getMAddr() != null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.285 -0400", hash_original_method = "D3B4FF5E31929A9875E21530A6B99142", hash_generated_method = "3EEBB02788635AC8FD8E72B990DB01D4")
    public void setRequestInterface(ServerRequestInterface newRequestOf) {
        requestOf = newRequestOf;
        // ---------- Original Method ----------
        //requestOf = newRequestOf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.286 -0400", hash_original_method = "BE06A4E585FD9A272717267C4A83F5CF", hash_generated_method = "ED54901F8D76565B9B78AE5D75B744B0")
    public MessageChannel getResponseChannel() {
        MessageChannel varB4EAC82CA7396A68D541C85D26508E83_138994999 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_138994999 = this;
        varB4EAC82CA7396A68D541C85D26508E83_138994999.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_138994999;
        // ---------- Original Method ----------
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.292 -0400", hash_original_method = "EE01791F9851138F67FFB678FE608E3C", hash_generated_method = "98121F44044ECCF022FDCFCC75DED49B")
    public boolean isMessagePartOfTransaction(SIPMessage messageToTest) {
        ViaList viaHeaders;
        Via topViaHeader;
        String messageBranch;
        boolean transactionMatches;
        transactionMatches = false;
        String method;
        method = messageToTest.getCSeq().getMethod();
        {
            boolean varA587C943C2619AFFE13B94F1AB583610_1147498395 = ((method.equals(Request.INVITE) || !isTerminated()));
            {
                viaHeaders = messageToTest.getViaHeaders();
                {
                    topViaHeader = (Via) viaHeaders.getFirst();
                    messageBranch = topViaHeader.getBranch();
                    {
                        {
                            boolean varB0B1855F9231D6A8F5FD28941F9BDDD0_1143170229 = (!messageBranch.toLowerCase().startsWith(
                            SIPConstants.BRANCH_MAGIC_COOKIE_LOWER_CASE));
                            {
                                messageBranch = null;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        boolean varE32D6D22F4CE4924781A107A8FB175B2_119671433 = (messageBranch != null && this.getBranch() != null);
                        {
                            {
                                boolean var6D97B93142EE0960BB0161B3820BC33B_1084347877 = (method.equals(Request.CANCEL));
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
                                boolean varE3294734A663B5145970265517B02330_1296028456 = (messageToTest.getCSeq().getMethod().equalsIgnoreCase(Request.CANCEL)
                            && !getOriginalRequest().getCSeq().getMethod().equalsIgnoreCase(
                                    Request.CANCEL));
                                {
                                    transactionMatches = false;
                                } //End block
                                {
                                    boolean var8F6BF2C074DDF0DDEAFFC56D2F91B82E_458628451 = ((isResponse || getOriginalRequest().getRequestURI().equals(
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_188420422 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_188420422;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.301 -0400", hash_original_method = "6CCC5EFA22CA085040CD9EF339EE900B", hash_generated_method = "B7BDBB8F21E330C523ECFC441206CFCF")
    protected void map() {
        TransactionState realState;
        realState = getRealState();
        {
            {
                boolean var31AB16103AEFA126AE0456128DBB6A94_1814582050 = (isInviteTransaction() && !this.isMapped && sipStack.getTimer() != null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.302 -0400", hash_original_method = "7F46EDF7DD1A49A585957DF512054145", hash_generated_method = "84E65C5AF04CAF65F735F1A9A4B4350B")
    public boolean isTransactionMapped() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1331926740 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1331926740;
        // ---------- Original Method ----------
        //return this.isMapped;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.314 -0400", hash_original_method = "56FAA78069677544853324F6F2B799B6", hash_generated_method = "1BEAF8940DA224822F338E0C7B50553D")
    public void processRequest(SIPRequest transactionRequest, MessageChannel sourceChannel) {
        boolean toTu;
        toTu = false;
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_217462798 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("processRequest: " + transactionRequest.getFirstLine());
                sipStack.getStackLogger().logDebug("tx state = " + this.getRealState());
            } //End block
        } //End collapsed parenthetic
        try 
        {
            {
                boolean var70CEB3DDCD8D7128B1625311F4A9712B_1688627225 = (getRealState() == null);
                {
                    setOriginalRequest(transactionRequest);
                    this.setState(TransactionState.TRYING);
                    toTu = true;
                    this.setPassToListener();
                    {
                        boolean var26B9564585E283B5580BF068A8F2EBC0_285739774 = (isInviteTransaction() && this.isMapped);
                        {
                            sendMessage(transactionRequest.createResponse(100, "Trying"));
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean var61C63FC44DDBF94E9A005FDACD8F877F_1781397 = (isInviteTransaction() && TransactionState.COMPLETED == getRealState()
                    && transactionRequest.getMethod().equals(Request.ACK));
                    {
                        this.setState(TransactionState.CONFIRMED);
                        disableRetransmissionTimer();
                        {
                            boolean var6400A483252621139629FC45C6113F96_1489395787 = (!isReliable());
                            {
                                enableTimeoutTimer(TIMER_I);
                            } //End block
                            {
                                this.setState(TransactionState.TERMINATED);
                            } //End block
                        } //End collapsed parenthetic
                        {
                            boolean var0CE4EC8BFDE23852AC02E54D6C0A99C3_1083706573 = (sipStack.isNon2XXAckPassedToListener());
                            {
                                requestOf.processRequest(transactionRequest, this);
                            } //End block
                            {
                                {
                                    boolean varA5D47C3A6259BCCCC2265DD1F84B75D4_2044402329 = (sipStack.isLoggingEnabled());
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
                        boolean var5DCA1F369F7D30BA32EEBBE4FE2D1EC4_1630861505 = (transactionRequest.getMethod().equals(getOriginalRequest().getMethod()));
                        {
                            {
                                boolean var513E565483353A4E3D5B26CBC828D863_1640124202 = (TransactionState.PROCEEDING == getRealState()
                        || TransactionState.COMPLETED == getRealState());
                                {
                                    this.semRelease();
                                    {
                                        super.sendMessage(lastResponse);
                                    } //End block
                                } //End block
                                {
                                    boolean var261C36BF61BB943A059F423FCF36B492_1877026616 = (transactionRequest.getMethod().equals(Request.ACK));
                                    {
                                        requestOf.processRequest(transactionRequest, this);
                                        this.semRelease();
                                    } //End block
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_116886053 = (sipStack.isLoggingEnabled());
                                sipStack.getStackLogger().logDebug("completed processing retransmitted request : "
                        + transactionRequest.getFirstLine() + this + " txState = "
                        + this.getState() + " lastResponse = " + this.getLastResponse());
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            {
                boolean var138A866FF284A265491C1CE49B1F033D_600067412 = (TransactionState.COMPLETED != getRealState()
                    && TransactionState.TERMINATED != getRealState() && requestOf != null);
                {
                    {
                        boolean var1B84E64E4073F1ABC138FA35CD2C39EE_863503774 = (getOriginalRequest().getMethod().equals(transactionRequest.getMethod()));
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
                        boolean var1819F3EAA856749263E5BE101D189558_935233459 = (((SIPTransactionStack) getSIPStack()).isDialogCreated(getOriginalRequest()
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
                            boolean var9CD63E03739FECA68F9AFA5AAC7AA721_624220837 = (transactionRequest.getMethod().equals(Request.CANCEL));
                            {
                                {
                                    boolean varA5D47C3A6259BCCCC2265DD1F84B75D4_1367242984 = (sipStack.isLoggingEnabled());
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
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1318102587 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger().logDebug("Dropping request " + getRealState());
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (IOException e)
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_319960298 = (sipStack.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.320 -0400", hash_original_method = "2B73C982341966F86ADBEA04AC7851BC", hash_generated_method = "10C77918E061A41AB1914F27DE9CC9E3")
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
                    boolean var2F38972DBED8A4DE733E711CBE4D5C6A_1234044860 = (this.getOriginalRequest().getTopmostVia().getBranch() != null);
                    transactionResponse.getTopmostVia().setBranch(this.getBranch());
                    transactionResponse.getTopmostVia().removeParameter(ParameterNames.BRANCH);
                } //End collapsed parenthetic
                {
                    boolean varC44D49F2E08F6BF8B72E9153D7546CFA_1689226202 = (!this.getOriginalRequest().getTopmostVia().hasPort());
                    transactionResponse.getTopmostVia().removePort();
                } //End collapsed parenthetic
            } //End block
            catch (ParseException ex)
            {
                ex.printStackTrace();
            } //End block
            {
                boolean varCDC23963431F718F155919E1B152A5B1_1460269804 = (!transactionResponse.getCSeq().getMethod().equals(
                    getOriginalRequest().getMethod()));
                {
                    sendResponse(transactionResponse);
                } //End block
            } //End collapsed parenthetic
            {
                boolean var4BA81FF05A67431D945A9CCF4269103B_736462093 = (getRealState() == TransactionState.TRYING);
                {
                    {
                        this.setState(TransactionState.PROCEEDING);
                    } //End block
                    {
                        {
                            boolean var9A31CFD76FE10E8ECD86917959215919_75788043 = (!isInviteTransaction());
                            {
                                {
                                    boolean var5823DC8E03E92FBA3E90C95804A7C591_574148144 = (!isReliable());
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
                                        boolean var6E7182B6E41B1FA498D147B67D30B4C7_908515912 = (!isReliable());
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
                    boolean var74E8F15E3DFF3B3C75AA5FCF9E43A983_1703901137 = (getRealState() == TransactionState.PROCEEDING);
                    {
                        {
                            boolean var90CDBC638C52197AEFD58A39118A4F7B_957177238 = (isInviteTransaction());
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
                                        boolean var6E7182B6E41B1FA498D147B67D30B4C7_1143297521 = (!isReliable());
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
                                    boolean var5823DC8E03E92FBA3E90C95804A7C591_1377279304 = (!isReliable());
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
                        boolean varFD4EA10AB958789F8E5208FCA031E4F7_969396392 = (TransactionState.COMPLETED == this.getRealState());
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            try 
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1758923665 = (sipStack.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.321 -0400", hash_original_method = "57D57213185EECDD5D38603D59833E46", hash_generated_method = "C84F2C609818AF9E4087BD6FD844A135")
    public String getViaHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_396860308 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_396860308 = getMessageChannel().getViaHost();
        varB4EAC82CA7396A68D541C85D26508E83_396860308.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_396860308;
        // ---------- Original Method ----------
        //return getMessageChannel().getViaHost();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.321 -0400", hash_original_method = "AE83C408493AD4624CBF388A7C2A34C7", hash_generated_method = "489A9C731F7A3F92B0794E49566E8F79")
    public int getViaPort() {
        int var65E79C2A809CF6EB6BDAEEC8693218FB_173701285 = (getMessageChannel().getViaPort());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1012478464 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1012478464;
        // ---------- Original Method ----------
        //return getMessageChannel().getViaPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.322 -0400", hash_original_method = "E1523787F7609795EF3E130FC3FDDFF0", hash_generated_method = "016F077D20096207D5614CEAF8621497")
    protected void fireRetransmissionTimer() {
        try 
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_778379908 = (sipStack.isLoggingEnabled());
                {
                    sipStack.getStackLogger().logDebug("fireRetransmissionTimer() -- ");
                } //End block
            } //End collapsed parenthetic
            {
                boolean var97506D4608B4B086F590DABBD0CD0224_440555323 = (isInviteTransaction() && lastResponse != null);
                {
                    {
                        boolean varF7C06CC5B09327E8D335DE2CCD7D3CB3_1758837491 = (!this.retransmissionAlertEnabled || sipStack.isTransactionPendingAck(this));
                        {
                            {
                                boolean var3D62795F819C4F4A78C4C4D50F93A26D_370333869 = (lastResponse.getStatusCode() / 100 > 2 && !this.isAckSeen);
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
                boolean varCD7A6467843458627CC99D2CD95A9CA6_957143999 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logException(e);
            } //End collapsed parenthetic
            raiseErrorEvent(SIPTransactionErrorEvent.TRANSPORT_ERROR);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.333 -0400", hash_original_method = "0BCA3A7152B5F6366E7B8E296683796F", hash_generated_method = "F7BC94E428A0D8194AEE6DB71EEFBE4E")
    private void fireReliableResponseRetransmissionTimer() {
        try 
        {
            super.sendMessage(this.pendingReliableResponse);
        } //End block
        catch (IOException e)
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_2083880143 = (sipStack.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.334 -0400", hash_original_method = "5968CF2AF2A16738BF27A6383A99288B", hash_generated_method = "79995EC03BB1F60D03B43C14EE0AA2EB")
    protected void fireTimeoutTimer() {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_183768534 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug("SIPServerTransaction.fireTimeoutTimer this = " + this
                    + " current state = " + this.getRealState() + " method = "
                    + this.getOriginalRequest().getMethod());
        } //End collapsed parenthetic
        {
            boolean varEF6FC70B2BC7D49F8BCB472486B33C54_303148638 = (this.getMethod().equals(Request.INVITE) && sipStack.removeTransactionPendingAck(this));
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1270173136 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logDebug("Found tx pending ACK - returning");
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        SIPDialog dialog;
        dialog = (SIPDialog) this.dialog;
        {
            boolean var711DC0C89C62C02DE2CD55F932C8367D_1734910837 = (((SIPTransactionStack) getSIPStack()).isDialogCreated(this.getOriginalRequest()
                .getMethod())
                && (TransactionState.CALLING == this.getRealState() || TransactionState.TRYING == this
                        .getRealState()));
            {
                dialog.setState(SIPDialog.TERMINATED_STATE);
            } //End block
            {
                boolean var156C74E4AAD691E5CB6FF740A659469E_1865960672 = (getOriginalRequest().getMethod().equals(Request.BYE));
                {
                    {
                        boolean var25DCA70E60C9BD5E73FEEE9C67F8FE8D_964572487 = (dialog != null && dialog.isTerminatedOnBye());
                        dialog.setState(SIPDialog.TERMINATED_STATE);
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            boolean varCFF580A9355E4A0C03337D867841029A_747803987 = (TransactionState.COMPLETED == this.getRealState() && isInviteTransaction());
            {
                raiseErrorEvent(SIPTransactionErrorEvent.TIMEOUT_ERROR);
                this.setState(TransactionState.TERMINATED);
                sipStack.removeTransaction(this);
            } //End block
            {
                boolean var25FD7C39D77376EA66ABD6B6A3394696_1648750349 = (TransactionState.COMPLETED == this.getRealState() && !isInviteTransaction());
                {
                    this.setState(TransactionState.TERMINATED);
                    sipStack.removeTransaction(this);
                } //End block
                {
                    boolean var1CCAF0837A5E3451C311A891D0BFBFA5_1384213583 = (TransactionState.CONFIRMED == this.getRealState() && isInviteTransaction());
                    {
                        this.setState(TransactionState.TERMINATED);
                        sipStack.removeTransaction(this);
                    } //End block
                    {
                        boolean var626203FAA050ECF54DFCECDFAF1D2110_260318624 = (!isInviteTransaction()
                && (TransactionState.COMPLETED == this.getRealState() || TransactionState.CONFIRMED == this
                        .getRealState()));
                        {
                            this.setState(TransactionState.TERMINATED);
                        } //End block
                        {
                            boolean varA83559C532D246A8888DBE7C8E979F66_221374018 = (isInviteTransaction() && TransactionState.TERMINATED == this.getRealState());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.335 -0400", hash_original_method = "025E14F038A1EDFF743C73F970E03870", hash_generated_method = "07699019900F3BDC82BA2CEC83C21316")
    public SIPResponse getLastResponse() {
        SIPResponse varB4EAC82CA7396A68D541C85D26508E83_2110765728 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2110765728 = this.lastResponse;
        varB4EAC82CA7396A68D541C85D26508E83_2110765728.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2110765728;
        // ---------- Original Method ----------
        //return this.lastResponse;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.335 -0400", hash_original_method = "2F3F0F5B57F408B788FCEFEE82B8B33E", hash_generated_method = "0434A42502203A07E20655688877948B")
    public void setOriginalRequest(SIPRequest originalRequest) {
        super.setOriginalRequest(originalRequest);
        addTaint(originalRequest.getTaint());
        // ---------- Original Method ----------
        //super.setOriginalRequest(originalRequest);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.407 -0400", hash_original_method = "2923FE4F478A1D65305B36AFA83919C7", hash_generated_method = "2A7E1F78277F0294175EC3BD85129644")
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
            boolean var801A8C3D02E183B03ADD76B333CD9A04_986615294 = (!sipResponse.getCSeq().getMethod().equals(this.getMethod()));
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException(
                    "CSeq method does not match Request method of request that created the tx.");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var8583F5323A2033F484FF44920C32DA17_998734976 = (this.getMethod().equals(Request.SUBSCRIBE) && response.getStatusCode() / 100 == 2);
            {
                {
                    boolean var93328E4C9F22EEBC88D387CD7D731566_2002715765 = (response.getHeader(ExpiresHeader.NAME) == null);
                    {
                        if (DroidSafeAndroidRuntime.control) throw new SipException("Expires header is mandatory in 2xx response of SUBSCRIBE");
                    } //End block
                    {
                        Expires requestExpires;
                        requestExpires = (Expires) this.getOriginalRequest().getExpires();
                        Expires responseExpires;
                        responseExpires = (Expires) response.getExpires();
                        {
                            boolean varE0075A921B603BC9E570B9DCD721F865_201218693 = (requestExpires != null
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
            boolean var608F5ADBEDAABF2EF2941E100485A93B_684184847 = (sipResponse.getStatusCode() == 200
                && sipResponse.getCSeq().getMethod().equals(Request.INVITE)
                && sipResponse.getHeader(ContactHeader.NAME) == null);
            if (DroidSafeAndroidRuntime.control) throw new SipException("Contact Header is mandatory for the OK to the INVITE");
        } //End collapsed parenthetic
        {
            boolean var4C5755F16C1843940C46C342BE021419_724994589 = (!this.isMessagePartOfTransaction((SIPMessage) response));
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException("Response does not belong to this transaction.");
            } //End block
        } //End collapsed parenthetic
        try 
        {
            {
                boolean var62FEEBDDF118C29D5B0B13E4A8ACA7C2_984548004 = (this.pendingReliableResponse != null
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
                        boolean var8F764FF06393918761F5329F48DCA88C_326242484 = (this.pendingReliableResponse != null && sipResponse.isFinalResponse());
                        {
                            this.provisionalResponseTask.cancel();
                            this.provisionalResponseTask = null;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                {
                    boolean varE68D4938E58071426E636D9DE0E3BAE2_1815258676 = (sipResponse.getStatusCode() / 100 == 2
                        && sipStack.isDialogCreated(sipResponse.getCSeq().getMethod()));
                    {
                        {
                            boolean var184229ADA4EC9A360B6355C36A07A7F2_313991045 = (dialog.getLocalTag() == null && sipResponse.getTo().getTag() == null);
                            {
                                sipResponse.getTo().setTag(Utils.getInstance().generateTag());
                            } //End block
                            {
                                boolean varA69779C1F2CA85BA38B8448E6C4853B8_1096106216 = (dialog.getLocalTag() != null && sipResponse.getToTag() == null);
                                {
                                    sipResponse.setToTag(dialog.getLocalTag());
                                } //End block
                                {
                                    boolean var488A66FF6BCB78677776FD18AA65B909_623820050 = (dialog.getLocalTag() != null && sipResponse.getToTag() != null
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
                    boolean var8AE1B0983C2CD6366DD27EBB35FA7F79_1849410409 = (!sipResponse.getCallId().getCallId().equals(dialog.getCallId().getCallId()));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new SipException("Dialog mismatch!");
                    } //End block
                } //End collapsed parenthetic
            } //End block
            String fromTag;
            fromTag = ((SIPRequest) this.getRequest()).getFrom().getTag();
            {
                boolean var97E814CAC40627CCA3A20A4845B25C15_646273610 = (fromTag != null && sipResponse.getFromTag() != null
                    && !sipResponse.getFromTag().equals(fromTag));
                {
                    if (DroidSafeAndroidRuntime.control) throw new SipException("From tag of request does not match response from tag");
                } //End block
                {
                    sipResponse.getFrom().setTag(fromTag);
                } //End block
                {
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_957481199 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger().logDebug("WARNING -- Null From tag in request!!");
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                boolean var97953C067604E07F88AD861C7C5D5DA2_953666322 = (dialog != null && response.getStatusCode() != 100);
                {
                    dialog.setResponseTags(sipResponse);
                    DialogState oldState;
                    oldState = dialog.getState();
                    dialog.setLastResponse(this, (SIPResponse) response);
                    {
                        boolean varA156AA3B1C7CA86C5BD16CB73196F418_1834521112 = (oldState == null && dialog.getState() == DialogState.TERMINATED);
                        {
                            DialogTerminatedEvent event;
                            event = new DialogTerminatedEvent(dialog
                            .getSipProvider(), dialog);
                            dialog.getSipProvider().handleEvent(event, this);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean var4979DEAA4AC1E02739C120A9086D1CAF_1432101331 = (dialog == null && this.getMethod().equals(Request.INVITE)
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
                boolean varCD7A6467843458627CC99D2CD95A9CA6_851428252 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logException(ex);
            } //End collapsed parenthetic
            this.setState(TransactionState.TERMINATED);
            raiseErrorEvent(SIPTransactionErrorEvent.TRANSPORT_ERROR);
            if (DroidSafeAndroidRuntime.control) throw new SipException(ex.getMessage());
        } //End block
        catch (java.text.ParseException ex1)
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1509701566 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logException(ex1);
            } //End collapsed parenthetic
            this.setState(TransactionState.TERMINATED);
            if (DroidSafeAndroidRuntime.control) throw new SipException(ex1.getMessage());
        } //End block
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.409 -0400", hash_original_method = "094652DDD499EE6CA69CC6BEDE88479D", hash_generated_method = "5AFD02218BC6D31CCBB8F2418316B5EE")
    private TransactionState getRealState() {
        TransactionState varB4EAC82CA7396A68D541C85D26508E83_726242622 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_726242622 = super.getState();
        varB4EAC82CA7396A68D541C85D26508E83_726242622.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_726242622;
        // ---------- Original Method ----------
        //return super.getState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.418 -0400", hash_original_method = "1CF9EDD0CC0B815CCCB8459FE319457E", hash_generated_method = "0EE11D44887E9BF64B75EF33189CD692")
    public TransactionState getState() {
        TransactionState varB4EAC82CA7396A68D541C85D26508E83_140620623 = null; //Variable for return #1
        TransactionState varB4EAC82CA7396A68D541C85D26508E83_1903898957 = null; //Variable for return #2
        {
            boolean var2D23FC6A2E71E23CD23FAA7D8D6238DD_2569027 = (this.isInviteTransaction() && TransactionState.TRYING == super.getState());
            varB4EAC82CA7396A68D541C85D26508E83_140620623 = TransactionState.PROCEEDING;
            varB4EAC82CA7396A68D541C85D26508E83_1903898957 = super.getState();
        } //End collapsed parenthetic
        TransactionState varA7E53CE21691AB073D9660D615818899_297180400; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_297180400 = varB4EAC82CA7396A68D541C85D26508E83_140620623;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_297180400 = varB4EAC82CA7396A68D541C85D26508E83_1903898957;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_297180400.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_297180400;
        // ---------- Original Method ----------
        //if (this.isInviteTransaction() && TransactionState.TRYING == super.getState())
            //return TransactionState.PROCEEDING;
        //else
            //return super.getState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.427 -0400", hash_original_method = "64016F2524A7B9A8D94F9FFA297FAA00", hash_generated_method = "FA5FBD1CAF6FE9AB2A819FA1BC746113")
    public void setState(TransactionState newState) {
        {
            boolean varCEADFBA66948576529EAE152B0D866E5_1018219864 = (newState == TransactionState.TERMINATED && this.isReliable()
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.427 -0400", hash_original_method = "058740AD5F567A2FC597464136294293", hash_generated_method = "504B6975F3DE030CB4A4E11F68C13E33")
    protected void startTransactionTimer() {
        {
            boolean var388A148DB1BAAE2BABBFD1571EA90BBF_596750281 = (this.transactionTimerStarted.compareAndSet(false, true));
            {
                {
                    boolean var7F2874EE26E943E6FA8451457423E55A_934309181 = (sipStack.getTimer() != null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.428 -0400", hash_original_method = "169DE8D7E50E65E71C46333CC9B26BAF", hash_generated_method = "B9AFF143405C0814D46D687DE29670A5")
    public boolean equals(Object other) {
        {
            boolean varAC16F771BB29A32F2C455E410359AF13_1256169490 = (!other.getClass().equals(this.getClass()));
        } //End collapsed parenthetic
        SIPServerTransaction sst;
        sst = (SIPServerTransaction) other;
        boolean var5237E4625EB90BEF6FB94591F11614C6_643804863 = (this.getBranch().equalsIgnoreCase(sst.getBranch()));
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_90123391 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_90123391;
        // ---------- Original Method ----------
        //if (!other.getClass().equals(this.getClass())) {
            //return false;
        //}
        //SIPServerTransaction sst = (SIPServerTransaction) other;
        //return this.getBranch().equalsIgnoreCase(sst.getBranch());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.429 -0400", hash_original_method = "BF9D0C52E87E80DCC85E6728CE121EFC", hash_generated_method = "D836CA10F1005CD2D8AE7CF936043AAB")
    public Dialog getDialog() {
        Dialog varB4EAC82CA7396A68D541C85D26508E83_1783610727 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1783610727 = this.dialog;
        varB4EAC82CA7396A68D541C85D26508E83_1783610727.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1783610727;
        // ---------- Original Method ----------
        //return this.dialog;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.430 -0400", hash_original_method = "7270FFD660AE92D45E417229D33FB869", hash_generated_method = "31DAD314978EEA98A0E630C25BD0ED78")
    public void setDialog(SIPDialog sipDialog, String dialogId) {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_2114647224 = (sipStack.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.449 -0400", hash_original_method = "2BF0F9BA137AD2AD36F3D6B0DBFD2123", hash_generated_method = "93F6BA068808A87C03214CC0464D1E10")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.450 -0400", hash_original_method = "113CF757EF1C74D90A992F25B2E0E550", hash_generated_method = "F1F1E01C9491DA9DD2EC66404D21A6FC")
    protected void sendReliableProvisionalResponse(Response relResponse) throws SipException {
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("Unacknowledged response");
        } //End block
        this.pendingReliableResponse = (SIPResponse) relResponse;
        RSeq rseq;
        rseq = (RSeq) relResponse.getHeader(RSeqHeader.NAME);
        {
            boolean varF6446DCD94E2B8540E59A055166427B1_1280146083 = (relResponse.getHeader(RSeqHeader.NAME) == null);
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
                boolean varB2200E3DA6206F41DF738AE7D772F7AB_538011519 = (this.getDialog() != null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.452 -0400", hash_original_method = "423AF4ABBE12E54C6351754EACC47E3E", hash_generated_method = "DBB54D36E1E021207A01239069FA5E6F")
    public SIPResponse getReliableProvisionalResponse() {
        SIPResponse varB4EAC82CA7396A68D541C85D26508E83_1132637763 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1132637763 = this.pendingReliableResponse;
        varB4EAC82CA7396A68D541C85D26508E83_1132637763.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1132637763;
        // ---------- Original Method ----------
        //return this.pendingReliableResponse;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.453 -0400", hash_original_method = "C1242B9BCB6EB14AE3EB1BD030AE911A", hash_generated_method = "C5B99A67B4409F2A9CC418828C7BD473")
    public boolean prackRecieved() {
        this.provisionalResponseTask.cancel();
        this.pendingReliableResponse = null;
        this.provisionalResponseSem.release();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1558865289 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1558865289;
        // ---------- Original Method ----------
        //if (this.pendingReliableResponse == null)
            //return false;
        //if(provisionalResponseTask != null)
        	//this.provisionalResponseTask.cancel();
        //this.pendingReliableResponse = null;
        //this.provisionalResponseSem.release();
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.453 -0400", hash_original_method = "DB7E38B465064167DDC1111F92777A32", hash_generated_method = "2CF0C090DD803CAB91B47F1938CEBC65")
    public void enableRetransmissionAlerts() throws SipException {
        {
            boolean var156DD83E7B1C45002AC761998FCDC404_136087795 = (this.getDialog() != null);
            if (DroidSafeAndroidRuntime.control) throw new SipException("Dialog associated with tx");
            {
                boolean var32F2D406FABEF0AC68112A69E6467BFF_1271756616 = (!this.getMethod().equals(Request.INVITE));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.454 -0400", hash_original_method = "9CE3EB2FC8AC208C1528F5A08B1A1A7B", hash_generated_method = "B999E3602B43BADF36A05870C301893E")
    public boolean isRetransmissionAlertEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_451932270 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_451932270;
        // ---------- Original Method ----------
        //return this.retransmissionAlertEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.455 -0400", hash_original_method = "FAB076B51BB167F6E440B2394399BC94", hash_generated_method = "FF65169AA87440CAF426CDB240B0AF89")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.464 -0400", hash_original_method = "157974C13DCC3CB54CBF1C9A15C7B6B6", hash_generated_method = "81F3099A5939DE0798711A37A1B51FCD")
    public void setAckSeen() {
        this.isAckSeen = true;
        // ---------- Original Method ----------
        //this.isAckSeen = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.472 -0400", hash_original_method = "C14F76EB0E4E278210A5D612100CE915", hash_generated_method = "1FA47A98BB0EF0DED5AB1503D81A1F3D")
    public boolean ackSeen() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1705626692 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1705626692;
        // ---------- Original Method ----------
        //return this.isAckSeen;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.473 -0400", hash_original_method = "6AEC262895B13A63B164E8F6877168F2", hash_generated_method = "933B9239F59250FB7BDA3E89093B23A0")
    public void setMapped(boolean b) {
        this.isMapped = true;
        addTaint(b);
        // ---------- Original Method ----------
        //this.isMapped = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.481 -0400", hash_original_method = "63F9C939BCFFEC59883E0EC5005B2509", hash_generated_method = "EC6E81A40B0FF5912A47574DDD99BB8B")
    public void setPendingSubscribe(SIPClientTransaction pendingSubscribeClientTx) {
        this.pendingSubscribeTransaction = pendingSubscribeClientTx;
        // ---------- Original Method ----------
        //this.pendingSubscribeTransaction = pendingSubscribeClientTx;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.481 -0400", hash_original_method = "D9515C627E3EA8CE075BBF27F52FBA55", hash_generated_method = "4373DAAB81BDCE31329418DC3483BC72")
    public void releaseSem() {
        {
            pendingSubscribeTransaction.releaseSem();
        } //End block
        {
            boolean var4E951FE87424D17F1293F3277DBF59F9_536529378 = (this.inviteTransaction != null && this.getMethod().equals(Request.CANCEL));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.481 -0400", hash_original_method = "0E2D0772A5243821270857191F448BEA", hash_generated_method = "58F6C6E283CD70A04E09BF213A465752")
    public void setInviteTransaction(SIPServerTransaction st) {
        this.inviteTransaction = st;
        // ---------- Original Method ----------
        //this.inviteTransaction = st;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.482 -0400", hash_original_method = "3EE4598A64A5BA68559842E002FBD20B", hash_generated_method = "8DF2F243E5D1CA91FDA839D93996BB7B")
    public SIPServerTransaction getCanceledInviteTransaction() {
        SIPServerTransaction varB4EAC82CA7396A68D541C85D26508E83_805807574 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_805807574 = this.inviteTransaction;
        varB4EAC82CA7396A68D541C85D26508E83_805807574.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_805807574;
        // ---------- Original Method ----------
        //return this.inviteTransaction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.482 -0400", hash_original_method = "22BE30BEEA580B63CB3DAB7D5C330535", hash_generated_method = "4FA5F703F3CDFC2B06294F44C751AF73")
    public void scheduleAckRemoval() throws IllegalStateException {
        {
            boolean varF92C33772DA55683B4274F816A4F87CF_124342059 = (this.getMethod() == null || !this.getMethod().equals(Request.ACK));
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.482 -0400", hash_original_field = "2EF3DE78A30BAAA37A078E077DA9C8FF", hash_generated_field = "6D266ECB4501DB72D6B336432EF66FBE")

        String dialogId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.482 -0400", hash_original_field = "48484A39612824059F2E51D06691465B", hash_generated_field = "3C1309F344AFB4C7FE9A836B7928DA16")

        int ticks;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.482 -0400", hash_original_field = "D576537E5E7AF4C474E0D2BD0E3839BC", hash_generated_field = "6753930BED6039429702ABCC2D7DEDDB")

        int ticksLeft;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.483 -0400", hash_original_method = "D09929C71A38D835F5CB9E6FA68F0FB4", hash_generated_method = "E2E1CBC4426DB87B5CEC048A7CEA67A3")
        public  RetransmissionAlertTimerTask(String dialogId) {
            this.ticks = SIPTransaction.T1;
            this.ticksLeft = this.ticks;
            addTaint(dialogId.getTaint());
            // ---------- Original Method ----------
            //this.ticks = SIPTransaction.T1;
            //this.ticksLeft = this.ticks;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.483 -0400", hash_original_method = "2AF4E8E71B0B58D5A8BFD9769A90D169", hash_generated_method = "32F9D300CA96480AC55B2927181B3868")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.483 -0400", hash_original_field = "48484A39612824059F2E51D06691465B", hash_generated_field = "3C1309F344AFB4C7FE9A836B7928DA16")

        int ticks;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.483 -0400", hash_original_field = "D576537E5E7AF4C474E0D2BD0E3839BC", hash_generated_field = "6753930BED6039429702ABCC2D7DEDDB")

        int ticksLeft;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.483 -0400", hash_original_method = "7F2BA0B0C3F62E74BA1198F711026EF0", hash_generated_method = "936AB35C1A1D2D3B3199B32B118A8C98")
        public  ProvisionalResponseTask() {
            this.ticks = SIPTransaction.T1;
            this.ticksLeft = this.ticks;
            // ---------- Original Method ----------
            //this.ticks = SIPTransaction.T1;
            //this.ticksLeft = this.ticks;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.484 -0400", hash_original_method = "3BA43FFA8E7EB2E8FD814B03BC519869", hash_generated_method = "8A2B3E9227931A541F8412CC29CA5800")
        protected void runTask() {
            SIPServerTransaction serverTransaction;
            serverTransaction = SIPServerTransaction.this;
            {
                boolean var92C0250C2A0F130E2904551FA7400AFD_979448722 = (serverTransaction.isTerminated());
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.484 -0400", hash_original_field = "0D5C3FBA5136D530029D8116C7D37369", hash_generated_field = "5A6CDDF85083E892D7A9B40C9781E270")

        SIPServerTransaction serverTransaction = SIPServerTransaction.this;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.494 -0400", hash_original_method = "250D0DA46E4093885E0FDCBFA4428EAC", hash_generated_method = "C6F9312E02D3396BE69D6D2069B3841F")
          ListenerExecutionMaxTimer() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.494 -0400", hash_original_method = "FEDCDB906765008977DAE6268EB71EAC", hash_generated_method = "8FCF9C460974CC6AB11FE3F3119D81C8")
        protected void runTask() {
            try 
            {
                {
                    boolean varE423BC89CF656037002A9576F6AD2233_1558518227 = (serverTransaction.getState() == null);
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.495 -0400", hash_original_method = "C30DBC53FC262811E7ACF1B35A336493", hash_generated_method = "83CA2CA3B2E813C61D24E9F5A93E0FF9")
        protected  SendTrying() {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1064788427 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug("scheduled timer for " + SIPServerTransaction.this);
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (sipStack.isLoggingEnabled())
                //sipStack.getStackLogger().logDebug("scheduled timer for " + SIPServerTransaction.this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.509 -0400", hash_original_method = "F91C856C78DFF19E74F73B1B16259454", hash_generated_method = "F43574DDA4C2B1301C0F0A984ACD4FF0")
        protected void runTask() {
            SIPServerTransaction serverTransaction;
            serverTransaction = SIPServerTransaction.this;
            TransactionState realState;
            realState = serverTransaction.getRealState();
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_152791135 = (sipStack.isLoggingEnabled());
                    sipStack.getStackLogger().logDebug(" sending Trying current state = "
                            + serverTransaction.getRealState());
                } //End collapsed parenthetic
                try 
                {
                    serverTransaction.sendMessage(serverTransaction.getOriginalRequest()
                            .createResponse(100, "Trying"));
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1495641416 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger().logDebug(" trying sent "
                                + serverTransaction.getRealState());
                    } //End collapsed parenthetic
                } //End block
                catch (IOException ex)
                {
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_660010414 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger().logError("IO error sending  TRYING");
                    } //End collapsed parenthetic
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    class TransactionTimer extends SIPStackTimerTask {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.510 -0400", hash_original_method = "3D8EFF77F5EF9F9762C1A26A2D305727", hash_generated_method = "7CD04A54F74E2F9AFBBDB210CE117886")
        public  TransactionTimer() {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_131273679 = (sipStack.isLoggingEnabled());
                {
                    sipStack.getStackLogger().logDebug("TransactionTimer() : " + getTransactionId());
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (sipStack.isLoggingEnabled()) {
                //sipStack.getStackLogger().logDebug("TransactionTimer() : " + getTransactionId());
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.510 -0400", hash_original_method = "707AEBEB940FDE7695E7CB675FB731EE", hash_generated_method = "4ADB31B0DDD6EDCE977233F7F46C161B")
        protected void runTask() {
            {
                boolean var0E63CE6845571602177DE1A2C0337464_675343942 = (isTerminated());
                {
                    try 
                    {
                        this.cancel();
                    } //End block
                    catch (IllegalStateException ex)
                    {
                        {
                            boolean var5D283AADF1997C78E711029DD9E27848_385671041 = (!sipStack.isAlive());
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

