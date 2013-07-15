package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.384 -0400", hash_original_field = "4FC01D2A5D48A500CF94ED84B859B122", hash_generated_field = "28502708C76D5DD6019AE19DD6820CAF")

    private int rseqNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.384 -0400", hash_original_field = "9F15D4E87A74454813575D63D7C12D0F", hash_generated_field = "C8554195ED77FFA07E4A9EB64441964B")

    private transient ServerRequestInterface requestOf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.384 -0400", hash_original_field = "91C7EC8D1C8BB75E853F70FEE324A43B", hash_generated_field = "EB87748E422C08A91C21F30B889B25BC")

    private SIPDialog dialog;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.385 -0400", hash_original_field = "391570C17AE64479C3955D268F1B5A43", hash_generated_field = "1B65F4A63DBF291C8551F347E58C0645")

    private SIPResponse pendingReliableResponse;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.385 -0400", hash_original_field = "7C9AF5BDE87C0C7EEEA91CD8F8C305B7", hash_generated_field = "F641CCD030A30F9AE3D3689D9113DD0E")

    private ProvisionalResponseTask provisionalResponseTask;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.386 -0400", hash_original_field = "B578245DF9ED3129C921D1C8DA7C1726", hash_generated_field = "098BFE37ADED63A73A471007C93A0B9D")

    private boolean retransmissionAlertEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.387 -0400", hash_original_field = "11238E38421FCCF72D2C726C56BF323D", hash_generated_field = "8C7266D76A37BFC3977933B6EEA4448F")

    private RetransmissionAlertTimerTask retransmissionAlertTimerTask;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.387 -0400", hash_original_field = "F959144D32E6BD03C3E0F81E314010B5", hash_generated_field = "E5126B373C1F848FEA63F5658E5B5C6A")

    protected boolean isAckSeen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.388 -0400", hash_original_field = "C66A13890D3B3C00B688345D1719D77E", hash_generated_field = "7878146F4B75217C90AD253031C2AB2F")

    private SIPClientTransaction pendingSubscribeTransaction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.388 -0400", hash_original_field = "812E50456F3CD0D4A6427367F4222311", hash_generated_field = "BE6AC6CBDC82F6C7D74085E5CA0E7140")

    private SIPServerTransaction inviteTransaction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.388 -0400", hash_original_field = "15FEF2927CF9187A0725F755912B7A04", hash_generated_field = "D0DC33FA09DF277419E9D78A6DADBDC8")

    private Semaphore provisionalResponseSem = new Semaphore(1);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.392 -0400", hash_original_method = "D29C36EF10CFF1709E916D648669409B", hash_generated_method = "15F353E13F85C6C70FC7B37C3AC3A689")
    protected  SIPServerTransaction(SIPTransactionStack sipStack, MessageChannel newChannelToUse) {
        super(sipStack, newChannelToUse);
        addTaint(newChannelToUse.getTaint());
        addTaint(sipStack.getTaint());
    if(sipStack.maxListenerResponseTime != -1)        
        {
            sipStack.getTimer().schedule(new ListenerExecutionMaxTimer(),
                    sipStack.maxListenerResponseTime * 1000);
        } //End block
        this.rseqNumber = (int) (Math.random() * 1000);
    if(sipStack.isLoggingEnabled())        
        {
            sipStack.getStackLogger().logDebug("Creating Server Transaction" + this.getBranchId());
            sipStack.getStackLogger().logStackTrace();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.397 -0400", hash_original_method = "05CFFFBF5E08267473584C7C9C8831C7", hash_generated_method = "642198C329D4FD55325BBDB238D6C3E3")
    private void sendResponse(SIPResponse transactionResponse) throws IOException {
        addTaint(transactionResponse.getTaint());
        try 
        {
    if(isReliable())            
            {
                getMessageChannel().sendMessage(transactionResponse);
            } //End block
            else
            {
                Via via = transactionResponse.getTopmostVia();
                String transport = via.getTransport();
    if(transport == null)                
                {
                IOException var12A1D4854EB7BA4C443940FD1E096488_2077591968 = new IOException("missing transport!");
                var12A1D4854EB7BA4C443940FD1E096488_2077591968.addTaint(taint);
                throw var12A1D4854EB7BA4C443940FD1E096488_2077591968;
                }
                int port = via.getRPort();
    if(port == -1)                
                port = via.getPort();
    if(port == -1)                
                {
    if(transport.equalsIgnoreCase("TLS"))                    
                    port = 5061;
                    else
                    port = 5060;
                } //End block
                String host = null;
    if(via.getMAddr() != null)                
                {
                    host = via.getMAddr();
                } //End block
                else
                {
                    host = via.getParameter(Via.RECEIVED);
    if(host == null)                    
                    {
                        host = via.getHost();
                    } //End block
                } //End block
                Hop hop = sipStack.addressResolver.resolveAddress(new HopImpl(host, port,
                        transport));
                MessageChannel messageChannel = ((SIPTransactionStack) getSIPStack())
                        .createRawMessageChannel(this.getSipProvider().getListeningPoint(
                                hop.getTransport()).getIPAddress(), this.getPort(), hop);
    if(messageChannel != null)                
                messageChannel.sendMessage(transactionResponse);
                else
                {
                IOException var2A6949DB0D85087F7C6C2D0585615C76_314324087 = new IOException("Could not create a message channel for " + hop);
                var2A6949DB0D85087F7C6C2D0585615C76_314324087.addTaint(taint);
                throw var2A6949DB0D85087F7C6C2D0585615C76_314324087;
                }
            } //End block
        } //End block
        finally 
        {
            this.startTransactionTimer();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.398 -0400", hash_original_method = "D3B4FF5E31929A9875E21530A6B99142", hash_generated_method = "3EEBB02788635AC8FD8E72B990DB01D4")
    public void setRequestInterface(ServerRequestInterface newRequestOf) {
        requestOf = newRequestOf;
        // ---------- Original Method ----------
        //requestOf = newRequestOf;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.400 -0400", hash_original_method = "BE06A4E585FD9A272717267C4A83F5CF", hash_generated_method = "DDBBA7A1CCD91B7075605BBEC9FB1772")
    public MessageChannel getResponseChannel() {
MessageChannel var72A74007B2BE62B849F475C7BDA4658B_894804217 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_894804217.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_894804217;
        // ---------- Original Method ----------
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.404 -0400", hash_original_method = "EE01791F9851138F67FFB678FE608E3C", hash_generated_method = "C832392B905D427BBAC2FED563675223")
    public boolean isMessagePartOfTransaction(SIPMessage messageToTest) {
        addTaint(messageToTest.getTaint());
        ViaList viaHeaders;
        Via topViaHeader;
        String messageBranch;
        boolean transactionMatches;
        transactionMatches = false;
        String method = messageToTest.getCSeq().getMethod();
    if((method.equals(Request.INVITE) || !isTerminated()))        
        {
            viaHeaders = messageToTest.getViaHeaders();
    if(viaHeaders != null)            
            {
                topViaHeader = (Via) viaHeaders.getFirst();
                messageBranch = topViaHeader.getBranch();
    if(messageBranch != null)                
                {
    if(!messageBranch.toLowerCase().startsWith(
                            SIPConstants.BRANCH_MAGIC_COOKIE_LOWER_CASE))                    
                    {
                        messageBranch = null;
                    } //End block
                } //End block
    if(messageBranch != null && this.getBranch() != null)                
                {
    if(method.equals(Request.CANCEL))                    
                    {
                        transactionMatches = this.getMethod().equals(Request.CANCEL)
                                && getBranch().equalsIgnoreCase(messageBranch)
                                && topViaHeader.getSentBy().equals(
                                        ((Via) getOriginalRequest().getViaHeaders().getFirst())
                                                .getSentBy());
                    } //End block
                    else
                    {
                        transactionMatches = getBranch().equalsIgnoreCase(messageBranch)
                                && topViaHeader.getSentBy().equals(
                                        ((Via) getOriginalRequest().getViaHeaders().getFirst())
                                                .getSentBy());
                    } //End block
                } //End block
                else
                {
                    String originalFromTag = super.fromTag;
                    String thisFromTag = messageToTest.getFrom().getTag();
                    boolean skipFrom = (originalFromTag == null || thisFromTag == null);
                    String originalToTag = super.toTag;
                    String thisToTag = messageToTest.getTo().getTag();
                    boolean skipTo = (originalToTag == null || thisToTag == null);
                    boolean isResponse = (messageToTest instanceof SIPResponse);
    if(messageToTest.getCSeq().getMethod().equalsIgnoreCase(Request.CANCEL)
                            && !getOriginalRequest().getCSeq().getMethod().equalsIgnoreCase(
                                    Request.CANCEL))                    
                    {
                        transactionMatches = false;
                    } //End block
                    else
    if((isResponse || getOriginalRequest().getRequestURI().equals(
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
                                    .getFirst()))                    
                    {
                        transactionMatches = true;
                    } //End block
                } //End block
            } //End block
        } //End block
        boolean var05E079BB3C0AA5EA1496AF660BBDEC18_1214230790 = (transactionMatches);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_238618346 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_238618346;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.406 -0400", hash_original_method = "6CCC5EFA22CA085040CD9EF339EE900B", hash_generated_method = "360F3ADB0F7CA65F6FF8E85AF3FFBC43")
    protected void map() {
        TransactionState realState = getRealState();
    if(realState == null || realState == TransactionState.TRYING)        
        {
    if(isInviteTransaction() && !this.isMapped && sipStack.getTimer() != null)            
            {
                this.isMapped = true;
                sipStack.getTimer().schedule(new SendTrying(), 200);
            } //End block
            else
            {
                isMapped = true;
            } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.407 -0400", hash_original_method = "7F46EDF7DD1A49A585957DF512054145", hash_generated_method = "B27A138FF63F1571C0B2F7FF59A9ABFD")
    public boolean isTransactionMapped() {
        boolean var3EFD70DAF0E407AA43EE2BB65D3566A1_886073798 = (this.isMapped);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1514920103 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1514920103;
        // ---------- Original Method ----------
        //return this.isMapped;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.409 -0400", hash_original_method = "56FAA78069677544853324F6F2B799B6", hash_generated_method = "FD11098172505A26D00C302E84534BAA")
    public void processRequest(SIPRequest transactionRequest, MessageChannel sourceChannel) {
        addTaint(sourceChannel.getTaint());
        addTaint(transactionRequest.getTaint());
        boolean toTu = false;
    if(sipStack.isLoggingEnabled())        
        {
            sipStack.getStackLogger().logDebug("processRequest: " + transactionRequest.getFirstLine());
            sipStack.getStackLogger().logDebug("tx state = " + this.getRealState());
        } //End block
        try 
        {
    if(getRealState() == null)            
            {
                setOriginalRequest(transactionRequest);
                this.setState(TransactionState.TRYING);
                toTu = true;
                this.setPassToListener();
    if(isInviteTransaction() && this.isMapped)                
                {
                    sendMessage(transactionRequest.createResponse(100, "Trying"));
                } //End block
            } //End block
            else
    if(isInviteTransaction() && TransactionState.COMPLETED == getRealState()
                    && transactionRequest.getMethod().equals(Request.ACK))            
            {
                this.setState(TransactionState.CONFIRMED);
                disableRetransmissionTimer();
    if(!isReliable())                
                {
                    enableTimeoutTimer(TIMER_I);
                } //End block
                else
                {
                    this.setState(TransactionState.TERMINATED);
                } //End block
    if(sipStack.isNon2XXAckPassedToListener())                
                {
                    requestOf.processRequest(transactionRequest, this);
                } //End block
                else
                {
    if(sipStack.isLoggingEnabled())                    
                    {
                        sipStack.getStackLogger().logDebug("ACK received for server Tx "
                                + this.getTransactionId() + " not delivering to application!");
                    } //End block
                    this.semRelease();
                } //End block
                return;
            } //End block
            else
    if(transactionRequest.getMethod().equals(getOriginalRequest().getMethod()))            
            {
    if(TransactionState.PROCEEDING == getRealState()
                        || TransactionState.COMPLETED == getRealState())                
                {
                    this.semRelease();
    if(lastResponse != null)                    
                    {
                        super.sendMessage(lastResponse);
                    } //End block
                } //End block
                else
    if(transactionRequest.getMethod().equals(Request.ACK))                
                {
    if(requestOf != null)                    
                    requestOf.processRequest(transactionRequest, this);
                    else
                    this.semRelease();
                } //End block
    if(sipStack.isLoggingEnabled())                
                sipStack.getStackLogger().logDebug("completed processing retransmitted request : "
                        + transactionRequest.getFirstLine() + this + " txState = "
                        + this.getState() + " lastResponse = " + this.getLastResponse());
                return;
            } //End block
    if(TransactionState.COMPLETED != getRealState()
                    && TransactionState.TERMINATED != getRealState() && requestOf != null)            
            {
    if(getOriginalRequest().getMethod().equals(transactionRequest.getMethod()))                
                {
    if(toTu)                    
                    {
                        requestOf.processRequest(transactionRequest, this);
                    } //End block
                    else
                    this.semRelease();
                } //End block
                else
                {
    if(requestOf != null)                    
                    requestOf.processRequest(transactionRequest, this);
                    else
                    this.semRelease();
                } //End block
            } //End block
            else
            {
    if(((SIPTransactionStack) getSIPStack()).isDialogCreated(getOriginalRequest()
                        .getMethod())
                        && getRealState() == TransactionState.TERMINATED
                        && transactionRequest.getMethod().equals(Request.ACK)
                        && requestOf != null)                
                {
                    SIPDialog thisDialog = (SIPDialog) this.dialog;
    if(thisDialog == null || !thisDialog.ackProcessed)                    
                    {
    if(thisDialog != null)                        
                        {
                            thisDialog.ackReceived(transactionRequest);
                            thisDialog.ackProcessed = true;
                        } //End block
                        requestOf.processRequest(transactionRequest, this);
                    } //End block
                    else
                    {
                        this.semRelease();
                    } //End block
                } //End block
                else
    if(transactionRequest.getMethod().equals(Request.CANCEL))                
                {
    if(sipStack.isLoggingEnabled())                    
                    sipStack.getStackLogger().logDebug("Too late to cancel Transaction");
                    this.semRelease();
                    try 
                    {
                        this.sendMessage(transactionRequest.createResponse(Response.OK));
                    } //End block
                    catch (IOException ex)
                    {
                    } //End block
                } //End block
    if(sipStack.isLoggingEnabled())                
                sipStack.getStackLogger().logDebug("Dropping request " + getRealState());
            } //End block
        } //End block
        catch (IOException e)
        {
    if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger().logError("IOException " ,e);
            this.semRelease();
            this.raiseIOExceptionEvent();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.413 -0400", hash_original_method = "2B73C982341966F86ADBEA04AC7851BC", hash_generated_method = "A26D4D0EF11D51E96D26F4F2A04C542B")
    public void sendMessage(SIPMessage messageToSend) throws IOException {
        addTaint(messageToSend.getTaint());
        try 
        {
            SIPResponse transactionResponse;
            int statusCode;
            transactionResponse = (SIPResponse) messageToSend;
            statusCode = transactionResponse.getStatusCode();
            try 
            {
    if(this.getOriginalRequest().getTopmostVia().getBranch() != null)                
                transactionResponse.getTopmostVia().setBranch(this.getBranch());
                else
                transactionResponse.getTopmostVia().removeParameter(ParameterNames.BRANCH);
    if(!this.getOriginalRequest().getTopmostVia().hasPort())                
                transactionResponse.getTopmostVia().removePort();
            } //End block
            catch (ParseException ex)
            {
                ex.printStackTrace();
            } //End block
    if(!transactionResponse.getCSeq().getMethod().equals(
                    getOriginalRequest().getMethod()))            
            {
                sendResponse(transactionResponse);
                return;
            } //End block
    if(getRealState() == TransactionState.TRYING)            
            {
    if(statusCode / 100 == 1)                
                {
                    this.setState(TransactionState.PROCEEDING);
                } //End block
                else
    if(200 <= statusCode && statusCode <= 699)                
                {
    if(!isInviteTransaction())                    
                    {
    if(!isReliable())                        
                        {
                            this.setState(TransactionState.COMPLETED);
                            enableTimeoutTimer(TIMER_J);
                        } //End block
                        else
                        {
                            this.setState(TransactionState.TERMINATED);
                        } //End block
                    } //End block
                    else
                    {
    if(statusCode / 100 == 2)                        
                        {
                            this.disableRetransmissionTimer();
                            this.disableTimeoutTimer();
                            this.collectionTime = TIMER_J;
                            this.setState(TransactionState.TERMINATED);
    if(this.dialog != null)                            
                            this.dialog.setRetransmissionTicks();
                        } //End block
                        else
                        {
                            this.setState(TransactionState.COMPLETED);
    if(!isReliable())                            
                            {
                                enableRetransmissionTimer();
                            } //End block
                            enableTimeoutTimer(TIMER_H);
                        } //End block
                    } //End block
                } //End block
            } //End block
            else
    if(getRealState() == TransactionState.PROCEEDING)            
            {
    if(isInviteTransaction())                
                {
    if(statusCode / 100 == 2)                    
                    {
                        this.disableRetransmissionTimer();
                        this.disableTimeoutTimer();
                        this.collectionTime = TIMER_J;
                        this.setState(TransactionState.TERMINATED);
    if(this.dialog != null)                        
                        this.dialog.setRetransmissionTicks();
                    } //End block
                    else
    if(300 <= statusCode && statusCode <= 699)                    
                    {
                        this.setState(TransactionState.COMPLETED);
    if(!isReliable())                        
                        {
                            enableRetransmissionTimer();
                        } //End block
                        enableTimeoutTimer(TIMER_H);
                    } //End block
                } //End block
                else
    if(200 <= statusCode && statusCode <= 699)                
                {
                    this.setState(TransactionState.COMPLETED);
    if(!isReliable())                    
                    {
                        disableRetransmissionTimer();
                        enableTimeoutTimer(TIMER_J);
                    } //End block
                    else
                    {
                        this.setState(TransactionState.TERMINATED);
                    } //End block
                } //End block
            } //End block
            else
    if(TransactionState.COMPLETED == this.getRealState())            
            {
                return;
            } //End block
            try 
            {
    if(sipStack.isLoggingEnabled())                
                {
                    sipStack.getStackLogger().logDebug(
                            "sendMessage : tx = " + this + " getState = " + this.getState());
                } //End block
                lastResponse = transactionResponse;
                this.sendResponse(transactionResponse);
            } //End block
            catch (IOException e)
            {
                this.setState(TransactionState.TERMINATED);
                this.collectionTime = 0;
                e.addTaint(taint);
                throw e;
            } //End block
        } //End block
        finally 
        {
            this.startTransactionTimer();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.414 -0400", hash_original_method = "57D57213185EECDD5D38603D59833E46", hash_generated_method = "34E409A7929C3833BE776B17CB7AEDCD")
    public String getViaHost() {
String var829AB8E41EC16E528E3235849BDA35FA_1100998108 =         getMessageChannel().getViaHost();
        var829AB8E41EC16E528E3235849BDA35FA_1100998108.addTaint(taint);
        return var829AB8E41EC16E528E3235849BDA35FA_1100998108;
        // ---------- Original Method ----------
        //return getMessageChannel().getViaHost();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.414 -0400", hash_original_method = "AE83C408493AD4624CBF388A7C2A34C7", hash_generated_method = "7A8965CDB8AE99EA275869AAEDE39B08")
    public int getViaPort() {
        int var59113D1155EF399B1193686110522320_796926493 = (getMessageChannel().getViaPort());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1730196561 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1730196561;
        // ---------- Original Method ----------
        //return getMessageChannel().getViaPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.415 -0400", hash_original_method = "E1523787F7609795EF3E130FC3FDDFF0", hash_generated_method = "A09906DF7E585BC6DB50E0E660174F0D")
    protected void fireRetransmissionTimer() {
        try 
        {
    if(sipStack.isLoggingEnabled())            
            {
                sipStack.getStackLogger().logDebug("fireRetransmissionTimer() -- ");
            } //End block
    if(isInviteTransaction() && lastResponse != null)            
            {
    if(!this.retransmissionAlertEnabled || sipStack.isTransactionPendingAck(this))                
                {
    if(lastResponse.getStatusCode() / 100 > 2 && !this.isAckSeen)                    
                    super.sendMessage(lastResponse);
                } //End block
                else
                {
                    SipProviderImpl sipProvider = (SipProviderImpl) this.getSipProvider();
                    TimeoutEvent txTimeout = new TimeoutEvent(sipProvider, this,
                            Timeout.RETRANSMIT);
                    sipProvider.handleEvent(txTimeout, this);
                } //End block
            } //End block
        } //End block
        catch (IOException e)
        {
    if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger().logException(e);
            raiseErrorEvent(SIPTransactionErrorEvent.TRANSPORT_ERROR);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.416 -0400", hash_original_method = "0BCA3A7152B5F6366E7B8E296683796F", hash_generated_method = "53BDA6ABD558E686C57E0EAF51D4B05A")
    private void fireReliableResponseRetransmissionTimer() {
        try 
        {
            super.sendMessage(this.pendingReliableResponse);
        } //End block
        catch (IOException e)
        {
    if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger().logException(e);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.417 -0400", hash_original_method = "5968CF2AF2A16738BF27A6383A99288B", hash_generated_method = "3C52F4991EF175B4238DCAF6C8C51269")
    protected void fireTimeoutTimer() {
    if(sipStack.isLoggingEnabled())        
        sipStack.getStackLogger().logDebug("SIPServerTransaction.fireTimeoutTimer this = " + this
                    + " current state = " + this.getRealState() + " method = "
                    + this.getOriginalRequest().getMethod());
    if(this.getMethod().equals(Request.INVITE) && sipStack.removeTransactionPendingAck(this))        
        {
    if(sipStack.isLoggingEnabled())            
            {
                sipStack.getStackLogger().logDebug("Found tx pending ACK - returning");
            } //End block
            return;
        } //End block
        SIPDialog dialog = (SIPDialog) this.dialog;
    if(((SIPTransactionStack) getSIPStack()).isDialogCreated(this.getOriginalRequest()
                .getMethod())
                && (TransactionState.CALLING == this.getRealState() || TransactionState.TRYING == this
                        .getRealState()))        
        {
            dialog.setState(SIPDialog.TERMINATED_STATE);
        } //End block
        else
    if(getOriginalRequest().getMethod().equals(Request.BYE))        
        {
    if(dialog != null && dialog.isTerminatedOnBye())            
            dialog.setState(SIPDialog.TERMINATED_STATE);
        } //End block
    if(TransactionState.COMPLETED == this.getRealState() && isInviteTransaction())        
        {
            raiseErrorEvent(SIPTransactionErrorEvent.TIMEOUT_ERROR);
            this.setState(TransactionState.TERMINATED);
            sipStack.removeTransaction(this);
        } //End block
        else
    if(TransactionState.COMPLETED == this.getRealState() && !isInviteTransaction())        
        {
            this.setState(TransactionState.TERMINATED);
            sipStack.removeTransaction(this);
        } //End block
        else
    if(TransactionState.CONFIRMED == this.getRealState() && isInviteTransaction())        
        {
            this.setState(TransactionState.TERMINATED);
            sipStack.removeTransaction(this);
        } //End block
        else
    if(!isInviteTransaction()
                && (TransactionState.COMPLETED == this.getRealState() || TransactionState.CONFIRMED == this
                        .getRealState()))        
        {
            this.setState(TransactionState.TERMINATED);
        } //End block
        else
    if(isInviteTransaction() && TransactionState.TERMINATED == this.getRealState())        
        {
            raiseErrorEvent(SIPTransactionErrorEvent.TIMEOUT_ERROR);
    if(dialog != null)            
            dialog.setState(SIPDialog.TERMINATED_STATE);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.418 -0400", hash_original_method = "025E14F038A1EDFF743C73F970E03870", hash_generated_method = "4C083454C86509D24F069411A9E1DE9A")
    public SIPResponse getLastResponse() {
SIPResponse varA8D04ABCC2F40254E91C4FADCF1C6CA4_2079710502 =         this.lastResponse;
        varA8D04ABCC2F40254E91C4FADCF1C6CA4_2079710502.addTaint(taint);
        return varA8D04ABCC2F40254E91C4FADCF1C6CA4_2079710502;
        // ---------- Original Method ----------
        //return this.lastResponse;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.419 -0400", hash_original_method = "2F3F0F5B57F408B788FCEFEE82B8B33E", hash_generated_method = "3899FBAC5CE9C5C17359F88579C12094")
    public void setOriginalRequest(SIPRequest originalRequest) {
        addTaint(originalRequest.getTaint());
        super.setOriginalRequest(originalRequest);
        // ---------- Original Method ----------
        //super.setOriginalRequest(originalRequest);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.422 -0400", hash_original_method = "2923FE4F478A1D65305B36AFA83919C7", hash_generated_method = "8FC352C4DACC46BBF0E4B5F8EA1636F6")
    public void sendResponse(Response response) throws SipException {
        addTaint(response.getTaint());
        SIPResponse sipResponse = (SIPResponse) response;
        SIPDialog dialog = this.dialog;
    if(response == null)        
        {
        NullPointerException var190E09AD406BC82357F9E7E542B577DC_959405915 = new NullPointerException("null response");
        var190E09AD406BC82357F9E7E542B577DC_959405915.addTaint(taint);
        throw var190E09AD406BC82357F9E7E542B577DC_959405915;
        }
        try 
        {
            sipResponse.checkHeaders();
        } //End block
        catch (ParseException ex)
        {
            SipException var892635990475903AE5F007B5D011DC38_1226471392 = new SipException(ex.getMessage());
            var892635990475903AE5F007B5D011DC38_1226471392.addTaint(taint);
            throw var892635990475903AE5F007B5D011DC38_1226471392;
        } //End block
    if(!sipResponse.getCSeq().getMethod().equals(this.getMethod()))        
        {
            SipException var6F65629CBB58AA86D67A24D8999062BE_308381788 = new SipException(
                    "CSeq method does not match Request method of request that created the tx.");
            var6F65629CBB58AA86D67A24D8999062BE_308381788.addTaint(taint);
            throw var6F65629CBB58AA86D67A24D8999062BE_308381788;
        } //End block
    if(this.getMethod().equals(Request.SUBSCRIBE) && response.getStatusCode() / 100 == 2)        
        {
    if(response.getHeader(ExpiresHeader.NAME) == null)            
            {
                SipException var2956AF8CBE360868C9824C79E92BFA81_673558878 = new SipException("Expires header is mandatory in 2xx response of SUBSCRIBE");
                var2956AF8CBE360868C9824C79E92BFA81_673558878.addTaint(taint);
                throw var2956AF8CBE360868C9824C79E92BFA81_673558878;
            } //End block
            else
            {
                Expires requestExpires = (Expires) this.getOriginalRequest().getExpires();
                Expires responseExpires = (Expires) response.getExpires();
    if(requestExpires != null
                        && responseExpires.getExpires() > requestExpires.getExpires())                
                {
                    SipException varADDB8166AE9174E66314706B1EFE2E7E_904818915 = new SipException(
                            "Response Expires time exceeds request Expires time : See RFC 3265 3.1.1");
                    varADDB8166AE9174E66314706B1EFE2E7E_904818915.addTaint(taint);
                    throw varADDB8166AE9174E66314706B1EFE2E7E_904818915;
                } //End block
            } //End block
        } //End block
    if(sipResponse.getStatusCode() == 200
                && sipResponse.getCSeq().getMethod().equals(Request.INVITE)
                && sipResponse.getHeader(ContactHeader.NAME) == null)        
        {
        SipException var532963B449A3E46EC0E35B8EBE494202_595757584 = new SipException("Contact Header is mandatory for the OK to the INVITE");
        var532963B449A3E46EC0E35B8EBE494202_595757584.addTaint(taint);
        throw var532963B449A3E46EC0E35B8EBE494202_595757584;
        }
    if(!this.isMessagePartOfTransaction((SIPMessage) response))        
        {
            SipException var66BBC614CAD78313E2B09670FCABE9FC_1579210441 = new SipException("Response does not belong to this transaction.");
            var66BBC614CAD78313E2B09670FCABE9FC_1579210441.addTaint(taint);
            throw var66BBC614CAD78313E2B09670FCABE9FC_1579210441;
        } //End block
        try 
        {
    if(this.pendingReliableResponse != null
                    && this.getDialog() != null 
                    && this.getState() != TransactionState.TERMINATED
                    && ((SIPResponse)response).getContentTypeHeader() != null 
                    && response.getStatusCode() / 100 == 2
                    && ((SIPResponse)response).getContentTypeHeader().getContentType()
                            .equalsIgnoreCase("application")
                    && ((SIPResponse)response).getContentTypeHeader().getContentSubType()
                            .equalsIgnoreCase("sdp"))            
            {
                try 
                {
                    boolean acquired = this.provisionalResponseSem.tryAcquire(1,TimeUnit.SECONDS);
    if(!acquired)                    
                    {
                        SipException varE9769C829FEFF8F654201E857DE97D64_2067206070 = new SipException("cannot send response -- unacked povisional");
                        varE9769C829FEFF8F654201E857DE97D64_2067206070.addTaint(taint);
                        throw varE9769C829FEFF8F654201E857DE97D64_2067206070;
                    } //End block
                } //End block
                catch (Exception ex)
                {
                    this.sipStack.getStackLogger().logError("Could not acquire PRACK sem ", ex);
                } //End block
            } //End block
            else
            {
    if(this.pendingReliableResponse != null && sipResponse.isFinalResponse())                
                {
                    this.provisionalResponseTask.cancel();
                    this.provisionalResponseTask = null;
                } //End block
            } //End block
    if(dialog != null)            
            {
    if(sipResponse.getStatusCode() / 100 == 2
                        && sipStack.isDialogCreated(sipResponse.getCSeq().getMethod()))                
                {
    if(dialog.getLocalTag() == null && sipResponse.getTo().getTag() == null)                    
                    {
                        sipResponse.getTo().setTag(Utils.getInstance().generateTag());
                    } //End block
                    else
    if(dialog.getLocalTag() != null && sipResponse.getToTag() == null)                    
                    {
                        sipResponse.setToTag(dialog.getLocalTag());
                    } //End block
                    else
    if(dialog.getLocalTag() != null && sipResponse.getToTag() != null
                            && !dialog.getLocalTag().equals(sipResponse.getToTag()))                    
                    {
                        SipException varA545CADB667B9E4EBABC6F23F6E45F2A_1336772630 = new SipException("Tag mismatch dialogTag is "
                                + dialog.getLocalTag() + " responseTag is "
                                + sipResponse.getToTag());
                        varA545CADB667B9E4EBABC6F23F6E45F2A_1336772630.addTaint(taint);
                        throw varA545CADB667B9E4EBABC6F23F6E45F2A_1336772630;
                    } //End block
                } //End block
    if(!sipResponse.getCallId().getCallId().equals(dialog.getCallId().getCallId()))                
                {
                    SipException var423C79D9D8600044115797712BCBEBB3_692571506 = new SipException("Dialog mismatch!");
                    var423C79D9D8600044115797712BCBEBB3_692571506.addTaint(taint);
                    throw var423C79D9D8600044115797712BCBEBB3_692571506;
                } //End block
            } //End block
            String fromTag = ((SIPRequest) this.getRequest()).getFrom().getTag();
    if(fromTag != null && sipResponse.getFromTag() != null
                    && !sipResponse.getFromTag().equals(fromTag))            
            {
                SipException varC322CDB3C0D1B7DAE859F17CA4306A3A_516426697 = new SipException("From tag of request does not match response from tag");
                varC322CDB3C0D1B7DAE859F17CA4306A3A_516426697.addTaint(taint);
                throw varC322CDB3C0D1B7DAE859F17CA4306A3A_516426697;
            } //End block
            else
    if(fromTag != null)            
            {
                sipResponse.getFrom().setTag(fromTag);
            } //End block
            else
            {
    if(sipStack.isLoggingEnabled())                
                sipStack.getStackLogger().logDebug("WARNING -- Null From tag in request!!");
            } //End block
    if(dialog != null && response.getStatusCode() != 100)            
            {
                dialog.setResponseTags(sipResponse);
                DialogState oldState = dialog.getState();
                dialog.setLastResponse(this, (SIPResponse) response);
    if(oldState == null && dialog.getState() == DialogState.TERMINATED)                
                {
                    DialogTerminatedEvent event = new DialogTerminatedEvent(dialog
                            .getSipProvider(), dialog);
                    dialog.getSipProvider().handleEvent(event, this);
                } //End block
            } //End block
            else
    if(dialog == null && this.getMethod().equals(Request.INVITE)
                    && this.retransmissionAlertEnabled
                    && this.retransmissionAlertTimerTask == null
                    && response.getStatusCode() / 100 == 2)            
            {
                String dialogId = ((SIPResponse) response).getDialogId(true);
                this.retransmissionAlertTimerTask = new RetransmissionAlertTimerTask(dialogId);
                sipStack.retransmissionAlertTransactions.put(dialogId, this);
                sipStack.getTimer().schedule(this.retransmissionAlertTimerTask, 0,
                        SIPTransactionStack.BASE_TIMER_INTERVAL);
            } //End block
            this.sendMessage((SIPResponse) response);
    if(dialog != null)            
            {
                dialog.startRetransmitTimer(this, (SIPResponse)response);
            } //End block
        } //End block
        catch (IOException ex)
        {
    if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger().logException(ex);
            this.setState(TransactionState.TERMINATED);
            raiseErrorEvent(SIPTransactionErrorEvent.TRANSPORT_ERROR);
            SipException var892635990475903AE5F007B5D011DC38_2002319331 = new SipException(ex.getMessage());
            var892635990475903AE5F007B5D011DC38_2002319331.addTaint(taint);
            throw var892635990475903AE5F007B5D011DC38_2002319331;
        } //End block
        catch (java.text.ParseException ex1)
        {
    if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger().logException(ex1);
            this.setState(TransactionState.TERMINATED);
            SipException var2FB375FB5B7DC48A26A08D71CB8F538C_1345249942 = new SipException(ex1.getMessage());
            var2FB375FB5B7DC48A26A08D71CB8F538C_1345249942.addTaint(taint);
            throw var2FB375FB5B7DC48A26A08D71CB8F538C_1345249942;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.427 -0400", hash_original_method = "094652DDD499EE6CA69CC6BEDE88479D", hash_generated_method = "27A979B5A946231A0661AD6CC8BF53A4")
    private TransactionState getRealState() {
TransactionState varB2F6DC77C80BF408EE3A0FF5E79E41E6_1348159246 =         super.getState();
        varB2F6DC77C80BF408EE3A0FF5E79E41E6_1348159246.addTaint(taint);
        return varB2F6DC77C80BF408EE3A0FF5E79E41E6_1348159246;
        // ---------- Original Method ----------
        //return super.getState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.427 -0400", hash_original_method = "1CF9EDD0CC0B815CCCB8459FE319457E", hash_generated_method = "27C11793166415CB07ED96C4503745AF")
    public TransactionState getState() {
    if(this.isInviteTransaction() && TransactionState.TRYING == super.getState())        
        {
TransactionState varAC5F3B42E4D269EAC0613AF120A48D0C_1078302454 =         TransactionState.PROCEEDING;
        varAC5F3B42E4D269EAC0613AF120A48D0C_1078302454.addTaint(taint);
        return varAC5F3B42E4D269EAC0613AF120A48D0C_1078302454;
        }
        else
        {
TransactionState varB2F6DC77C80BF408EE3A0FF5E79E41E6_995708970 =         super.getState();
        varB2F6DC77C80BF408EE3A0FF5E79E41E6_995708970.addTaint(taint);
        return varB2F6DC77C80BF408EE3A0FF5E79E41E6_995708970;
        }
        // ---------- Original Method ----------
        //if (this.isInviteTransaction() && TransactionState.TRYING == super.getState())
            //return TransactionState.PROCEEDING;
        //else
            //return super.getState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.429 -0400", hash_original_method = "64016F2524A7B9A8D94F9FFA297FAA00", hash_generated_method = "AA01CDD68E738D9738710C2833E0BC06")
    public void setState(TransactionState newState) {
        addTaint(newState.getTaint());
    if(newState == TransactionState.TERMINATED && this.isReliable()
                && (!getSIPStack().cacheServerConnections))        
        {
            this.collectionTime = TIMER_J;
        } //End block
        super.setState(newState);
        // ---------- Original Method ----------
        //if (newState == TransactionState.TERMINATED && this.isReliable()
                //&& (!getSIPStack().cacheServerConnections)) {
            //this.collectionTime = TIMER_J;
        //}
        //super.setState(newState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.429 -0400", hash_original_method = "058740AD5F567A2FC597464136294293", hash_generated_method = "60897C79AA11C6ACE891B9974D425457")
    protected void startTransactionTimer() {
    if(this.transactionTimerStarted.compareAndSet(false, true))        
        {
    if(sipStack.getTimer() != null)            
            {
                TimerTask myTimer = new TransactionTimer();
                sipStack.getTimer().schedule(myTimer, BASE_TIMER_INTERVAL, BASE_TIMER_INTERVAL);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (this.transactionTimerStarted.compareAndSet(false, true)) {
        	//if (sipStack.getTimer() != null) {
                //TimerTask myTimer = new TransactionTimer();
                //sipStack.getTimer().schedule(myTimer, BASE_TIMER_INTERVAL, BASE_TIMER_INTERVAL);
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.431 -0400", hash_original_method = "169DE8D7E50E65E71C46333CC9B26BAF", hash_generated_method = "454A69A6AD4EB0CCBB8C1CE46A74DDB2")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
    if(!other.getClass().equals(this.getClass()))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1328425529 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_848054140 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_848054140;
        } //End block
        SIPServerTransaction sst = (SIPServerTransaction) other;
        boolean varC0ED219B1A3D84045C2E29362B7DCF01_1983062519 = (this.getBranch().equalsIgnoreCase(sst.getBranch()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_138638207 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_138638207;
        // ---------- Original Method ----------
        //if (!other.getClass().equals(this.getClass())) {
            //return false;
        //}
        //SIPServerTransaction sst = (SIPServerTransaction) other;
        //return this.getBranch().equalsIgnoreCase(sst.getBranch());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.431 -0400", hash_original_method = "BF9D0C52E87E80DCC85E6728CE121EFC", hash_generated_method = "57995225D597EFD8F8DA7ADBC9BB1918")
    public Dialog getDialog() {
Dialog var8318F0A3FDFE0CD78A89325807A453A1_1741933962 =         this.dialog;
        var8318F0A3FDFE0CD78A89325807A453A1_1741933962.addTaint(taint);
        return var8318F0A3FDFE0CD78A89325807A453A1_1741933962;
        // ---------- Original Method ----------
        //return this.dialog;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.433 -0400", hash_original_method = "7270FFD660AE92D45E417229D33FB869", hash_generated_method = "E5B1C7305B56FBF7BB341E338DBB03E9")
    public void setDialog(SIPDialog sipDialog, String dialogId) {
        addTaint(dialogId.getTaint());
    if(sipStack.isLoggingEnabled())        
        sipStack.getStackLogger().logDebug("setDialog " + this + " dialog = " + sipDialog);
        this.dialog = sipDialog;
    if(dialogId != null)        
        this.dialog.setAssigned();
    if(this.retransmissionAlertEnabled && this.retransmissionAlertTimerTask != null)        
        {
            this.retransmissionAlertTimerTask.cancel();
    if(this.retransmissionAlertTimerTask.dialogId != null)            
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.434 -0400", hash_original_method = "2BF0F9BA137AD2AD36F3D6B0DBFD2123", hash_generated_method = "C9BDD3E86D25BD05A3F28D604D609510")
    public void terminate() throws ObjectInUseException {
        this.setState(TransactionState.TERMINATED);
    if(this.retransmissionAlertTimerTask != null)        
        {
            this.retransmissionAlertTimerTask.cancel();
    if(retransmissionAlertTimerTask.dialogId != null)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.435 -0400", hash_original_method = "113CF757EF1C74D90A992F25B2E0E550", hash_generated_method = "DBEB1227A4C2C3B134CC9ECD0BBC1E82")
    protected void sendReliableProvisionalResponse(Response relResponse) throws SipException {
    if(this.pendingReliableResponse != null)        
        {
            SipException var74C090F52593454438136C48CAAA224C_1557913653 = new SipException("Unacknowledged response");
            var74C090F52593454438136C48CAAA224C_1557913653.addTaint(taint);
            throw var74C090F52593454438136C48CAAA224C_1557913653;
        } //End block
        else
        this.pendingReliableResponse = (SIPResponse) relResponse;
        RSeq rseq = (RSeq) relResponse.getHeader(RSeqHeader.NAME);
    if(relResponse.getHeader(RSeqHeader.NAME) == null)        
        {
            rseq = new RSeq();
            relResponse.setHeader(rseq);
        } //End block
        try 
        {
            this.rseqNumber++;
            rseq.setSeqNumber(this.rseqNumber);
            this.lastResponse = (SIPResponse) relResponse;
    if(this.getDialog() != null)            
            {
                boolean acquired = this.provisionalResponseSem.tryAcquire(1, TimeUnit.SECONDS);
    if(!acquired)                
                {
                    SipException var74C090F52593454438136C48CAAA224C_1891534484 = new SipException("Unacknowledged response");
                    var74C090F52593454438136C48CAAA224C_1891534484.addTaint(taint);
                    throw var74C090F52593454438136C48CAAA224C_1891534484;
                } //End block
            } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.436 -0400", hash_original_method = "423AF4ABBE12E54C6351754EACC47E3E", hash_generated_method = "F9CAA8F495542BF879935A979A3F0049")
    public SIPResponse getReliableProvisionalResponse() {
SIPResponse varCCD20FA3C20A668DB65724A0DBBEFF4A_1150980557 =         this.pendingReliableResponse;
        varCCD20FA3C20A668DB65724A0DBBEFF4A_1150980557.addTaint(taint);
        return varCCD20FA3C20A668DB65724A0DBBEFF4A_1150980557;
        // ---------- Original Method ----------
        //return this.pendingReliableResponse;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.437 -0400", hash_original_method = "C1242B9BCB6EB14AE3EB1BD030AE911A", hash_generated_method = "74227C18C36DDA35173FA071736FDCF7")
    public boolean prackRecieved() {
    if(this.pendingReliableResponse == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_450237194 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_944419138 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_944419138;
        }
    if(provisionalResponseTask != null)        
        this.provisionalResponseTask.cancel();
        this.pendingReliableResponse = null;
        this.provisionalResponseSem.release();
        boolean varB326B5062B2F0E69046810717534CB09_1170135539 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_206184254 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_206184254;
        // ---------- Original Method ----------
        //if (this.pendingReliableResponse == null)
            //return false;
        //if(provisionalResponseTask != null)
        	//this.provisionalResponseTask.cancel();
        //this.pendingReliableResponse = null;
        //this.provisionalResponseSem.release();
        //return true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.438 -0400", hash_original_method = "DB7E38B465064167DDC1111F92777A32", hash_generated_method = "2CA8CAA17855DC5A9DDF7DC10CF3AB6F")
    public void enableRetransmissionAlerts() throws SipException {
    if(this.getDialog() != null)        
        {
        SipException varF27B447FDE6DC8E8DAC2C7BE073B3375_360217017 = new SipException("Dialog associated with tx");
        varF27B447FDE6DC8E8DAC2C7BE073B3375_360217017.addTaint(taint);
        throw varF27B447FDE6DC8E8DAC2C7BE073B3375_360217017;
        }
        else
    if(!this.getMethod().equals(Request.INVITE))        
        {
        SipException varB3B1C5B7A5F6455DF7696476601FDEAD_1076690057 = new SipException("Request Method must be INVITE");
        varB3B1C5B7A5F6455DF7696476601FDEAD_1076690057.addTaint(taint);
        throw varB3B1C5B7A5F6455DF7696476601FDEAD_1076690057;
        }
        this.retransmissionAlertEnabled = true;
        // ---------- Original Method ----------
        //if (this.getDialog() != null)
            //throw new SipException("Dialog associated with tx");
        //else if (!this.getMethod().equals(Request.INVITE))
            //throw new SipException("Request Method must be INVITE");
        //this.retransmissionAlertEnabled = true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.439 -0400", hash_original_method = "9CE3EB2FC8AC208C1528F5A08B1A1A7B", hash_generated_method = "2A83098C939B5F4DFAA8D9010132435C")
    public boolean isRetransmissionAlertEnabled() {
        boolean var06DD7699B0CFD16DCF2F35BC20BAFCD6_1325760395 = (this.retransmissionAlertEnabled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1265142856 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1265142856;
        // ---------- Original Method ----------
        //return this.retransmissionAlertEnabled;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.440 -0400", hash_original_method = "FAB076B51BB167F6E440B2394399BC94", hash_generated_method = "FD24943A672AE5C7E896E7FD152985F2")
    public void disableRetransmissionAlerts() {
    if(this.retransmissionAlertTimerTask != null && this.retransmissionAlertEnabled)        
        {
            this.retransmissionAlertTimerTask.cancel();
            this.retransmissionAlertEnabled = false;
            String dialogId = this.retransmissionAlertTimerTask.dialogId;
    if(dialogId != null)            
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.441 -0400", hash_original_method = "157974C13DCC3CB54CBF1C9A15C7B6B6", hash_generated_method = "81F3099A5939DE0798711A37A1B51FCD")
    public void setAckSeen() {
        this.isAckSeen = true;
        // ---------- Original Method ----------
        //this.isAckSeen = true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.442 -0400", hash_original_method = "C14F76EB0E4E278210A5D612100CE915", hash_generated_method = "F1CAD3C155A0289C5178A5CE8453F0DB")
    public boolean ackSeen() {
        boolean varA61195AC9D39A5A37AEF21FF99EADADA_1413455382 = (this.isAckSeen);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1351824208 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1351824208;
        // ---------- Original Method ----------
        //return this.isAckSeen;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.442 -0400", hash_original_method = "6AEC262895B13A63B164E8F6877168F2", hash_generated_method = "A83B7DB6CE3883DE4A7F1C4A7C4F0588")
    public void setMapped(boolean b) {
        addTaint(b);
        this.isMapped = true;
        // ---------- Original Method ----------
        //this.isMapped = true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.443 -0400", hash_original_method = "63F9C939BCFFEC59883E0EC5005B2509", hash_generated_method = "EC6E81A40B0FF5912A47574DDD99BB8B")
    public void setPendingSubscribe(SIPClientTransaction pendingSubscribeClientTx) {
        this.pendingSubscribeTransaction = pendingSubscribeClientTx;
        // ---------- Original Method ----------
        //this.pendingSubscribeTransaction = pendingSubscribeClientTx;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.444 -0400", hash_original_method = "D9515C627E3EA8CE075BBF27F52FBA55", hash_generated_method = "9969DCB5D871EEF4BCF8648BC7392A7C")
    public void releaseSem() {
    if(this.pendingSubscribeTransaction != null)        
        {
            pendingSubscribeTransaction.releaseSem();
        } //End block
        else
    if(this.inviteTransaction != null && this.getMethod().equals(Request.CANCEL))        
        {
            this.inviteTransaction.releaseSem();
        } //End block
        super.releaseSem();
        // ---------- Original Method ----------
        //if (this.pendingSubscribeTransaction != null) {
            //pendingSubscribeTransaction.releaseSem();
        //} else if (this.inviteTransaction != null && this.getMethod().equals(Request.CANCEL)) {
            //this.inviteTransaction.releaseSem();
        //}
        //super.releaseSem();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.444 -0400", hash_original_method = "0E2D0772A5243821270857191F448BEA", hash_generated_method = "58F6C6E283CD70A04E09BF213A465752")
    public void setInviteTransaction(SIPServerTransaction st) {
        this.inviteTransaction = st;
        // ---------- Original Method ----------
        //this.inviteTransaction = st;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.445 -0400", hash_original_method = "3EE4598A64A5BA68559842E002FBD20B", hash_generated_method = "77AB64BD418CDCD01AF580B588D23A02")
    public SIPServerTransaction getCanceledInviteTransaction() {
SIPServerTransaction var4366A1E0CE05E8DD96D50952869C4149_1296817432 =         this.inviteTransaction;
        var4366A1E0CE05E8DD96D50952869C4149_1296817432.addTaint(taint);
        return var4366A1E0CE05E8DD96D50952869C4149_1296817432;
        // ---------- Original Method ----------
        //return this.inviteTransaction;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.445 -0400", hash_original_method = "22BE30BEEA580B63CB3DAB7D5C330535", hash_generated_method = "EFAE7E16A7BD91CB20E4F9AA091979FF")
    public void scheduleAckRemoval() throws IllegalStateException {
    if(this.getMethod() == null || !this.getMethod().equals(Request.ACK))        
        {
            IllegalStateException var01D211FE8F0930C093011B9946DE8439_1007274 = new IllegalStateException("Method is null[" + (getMethod() == null)
                    + "] or method is not ACK[" + this.getMethod() + "]");
            var01D211FE8F0930C093011B9946DE8439_1007274.addTaint(taint);
            throw var01D211FE8F0930C093011B9946DE8439_1007274;
        } //End block
        this.startTransactionTimer();
        // ---------- Original Method ----------
        //if (this.getMethod() == null || !this.getMethod().equals(Request.ACK)) {
            //throw new IllegalStateException("Method is null[" + (getMethod() == null)
                    //+ "] or method is not ACK[" + this.getMethod() + "]");
        //}
        //this.startTransactionTimer();
    }

    
    class RetransmissionAlertTimerTask extends SIPStackTimerTask {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.446 -0400", hash_original_field = "2EF3DE78A30BAAA37A078E077DA9C8FF", hash_generated_field = "6D266ECB4501DB72D6B336432EF66FBE")

        String dialogId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.446 -0400", hash_original_field = "48484A39612824059F2E51D06691465B", hash_generated_field = "3C1309F344AFB4C7FE9A836B7928DA16")

        int ticks;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.446 -0400", hash_original_field = "D576537E5E7AF4C474E0D2BD0E3839BC", hash_generated_field = "6753930BED6039429702ABCC2D7DEDDB")

        int ticksLeft;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.447 -0400", hash_original_method = "D09929C71A38D835F5CB9E6FA68F0FB4", hash_generated_method = "AA5DD423EFE7E935018FF3A31BFE2303")
        public  RetransmissionAlertTimerTask(String dialogId) {
            addTaint(dialogId.getTaint());
            this.ticks = SIPTransaction.T1;
            this.ticksLeft = this.ticks;
            // ---------- Original Method ----------
            //this.ticks = SIPTransaction.T1;
            //this.ticksLeft = this.ticks;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.448 -0400", hash_original_method = "2AF4E8E71B0B58D5A8BFD9769A90D169", hash_generated_method = "8B45D91BBFDD557CD91FD8392AB8D176")
        protected void runTask() {
            SIPServerTransaction serverTransaction = SIPServerTransaction.this;
            ticksLeft--;
    if(ticksLeft == -1)            
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.449 -0400", hash_original_field = "48484A39612824059F2E51D06691465B", hash_generated_field = "3C1309F344AFB4C7FE9A836B7928DA16")

        int ticks;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.449 -0400", hash_original_field = "D576537E5E7AF4C474E0D2BD0E3839BC", hash_generated_field = "6753930BED6039429702ABCC2D7DEDDB")

        int ticksLeft;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.450 -0400", hash_original_method = "7F2BA0B0C3F62E74BA1198F711026EF0", hash_generated_method = "936AB35C1A1D2D3B3199B32B118A8C98")
        public  ProvisionalResponseTask() {
            this.ticks = SIPTransaction.T1;
            this.ticksLeft = this.ticks;
            // ---------- Original Method ----------
            //this.ticks = SIPTransaction.T1;
            //this.ticksLeft = this.ticks;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.452 -0400", hash_original_method = "3BA43FFA8E7EB2E8FD814B03BC519869", hash_generated_method = "5ACE34290795D96F0D2AC3AA8D4C544D")
        protected void runTask() {
            SIPServerTransaction serverTransaction = SIPServerTransaction.this;
    if(serverTransaction.isTerminated())            
            {
                this.cancel();
            } //End block
            else
            {
                ticksLeft--;
    if(ticksLeft == -1)                
                {
                    serverTransaction.fireReliableResponseRetransmissionTimer();
                    this.ticksLeft = 2 * ticks;
                    this.ticks = this.ticksLeft;
    if(this.ticksLeft >= SIPTransaction.TIMER_H)                    
                    {
                        this.cancel();
                        setState(TERMINATED_STATE);
                        fireTimeoutTimer();
                    } //End block
                } //End block
            } //End block
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.453 -0400", hash_original_field = "0D5C3FBA5136D530029D8116C7D37369", hash_generated_field = "5A6CDDF85083E892D7A9B40C9781E270")

        SIPServerTransaction serverTransaction = SIPServerTransaction.this;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.453 -0400", hash_original_method = "250D0DA46E4093885E0FDCBFA4428EAC", hash_generated_method = "C6F9312E02D3396BE69D6D2069B3841F")
          ListenerExecutionMaxTimer() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.454 -0400", hash_original_method = "FEDCDB906765008977DAE6268EB71EAC", hash_generated_method = "1D57A1537CA58EA274CC9009C5578C90")
        protected void runTask() {
            try 
            {
    if(serverTransaction.getState() == null)                
                {
                    serverTransaction.terminate();
                    SIPTransactionStack sipStack = serverTransaction.getSIPStack();
                    sipStack.removePendingTransaction(serverTransaction);
                    sipStack.removeTransaction(serverTransaction);
                } //End block
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.455 -0400", hash_original_method = "C30DBC53FC262811E7ACF1B35A336493", hash_generated_method = "EB8EEF4900FBE44B1A8651A4FFDC251C")
        protected  SendTrying() {
    if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger().logDebug("scheduled timer for " + SIPServerTransaction.this);
            // ---------- Original Method ----------
            //if (sipStack.isLoggingEnabled())
                //sipStack.getStackLogger().logDebug("scheduled timer for " + SIPServerTransaction.this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.455 -0400", hash_original_method = "F91C856C78DFF19E74F73B1B16259454", hash_generated_method = "082340EE3F1CFB24C29EBF25F2C3ABC7")
        protected void runTask() {
            SIPServerTransaction serverTransaction = SIPServerTransaction.this;
            TransactionState realState = serverTransaction.getRealState();
    if(realState == null || TransactionState.TRYING == realState)            
            {
    if(sipStack.isLoggingEnabled())                
                sipStack.getStackLogger().logDebug(" sending Trying current state = "
                            + serverTransaction.getRealState());
                try 
                {
                    serverTransaction.sendMessage(serverTransaction.getOriginalRequest()
                            .createResponse(100, "Trying"));
    if(sipStack.isLoggingEnabled())                    
                    sipStack.getStackLogger().logDebug(" trying sent "
                                + serverTransaction.getRealState());
                } //End block
                catch (IOException ex)
                {
    if(sipStack.isLoggingEnabled())                    
                    sipStack.getStackLogger().logError("IO error sending  TRYING");
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    class TransactionTimer extends SIPStackTimerTask {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.456 -0400", hash_original_method = "3D8EFF77F5EF9F9762C1A26A2D305727", hash_generated_method = "92844DFA086947510B0646EF295579DC")
        public  TransactionTimer() {
    if(sipStack.isLoggingEnabled())            
            {
                sipStack.getStackLogger().logDebug("TransactionTimer() : " + getTransactionId());
            } //End block
            // ---------- Original Method ----------
            //if (sipStack.isLoggingEnabled()) {
                //sipStack.getStackLogger().logDebug("TransactionTimer() : " + getTransactionId());
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:45.457 -0400", hash_original_method = "707AEBEB940FDE7695E7CB675FB731EE", hash_generated_method = "ACC2B3359B088C337991188F49BDD469")
        protected void runTask() {
    if(isTerminated())            
            {
                try 
                {
                    this.cancel();
                } //End block
                catch (IllegalStateException ex)
                {
    if(!sipStack.isAlive())                    
                    return;
                } //End block
                TimerTask myTimer = new LingerTimer();
                sipStack.getTimer().schedule(myTimer,
                        SIPTransactionStack.CONNECTION_LINGER_TIME * 1000);
            } //End block
            else
            {
                fireTimer();
            } //End block
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

