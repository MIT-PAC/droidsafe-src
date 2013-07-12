package gov.nist.javax.sip.stack;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.core.InternalErrorHandler;
import gov.nist.core.NameValueList;
import gov.nist.javax.sip.SIPConstants;
import gov.nist.javax.sip.Utils;
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.header.Contact;
import gov.nist.javax.sip.header.RecordRoute;
import gov.nist.javax.sip.header.RecordRouteList;
import gov.nist.javax.sip.header.Route;
import gov.nist.javax.sip.header.RouteList;
import gov.nist.javax.sip.header.TimeStamp;
import gov.nist.javax.sip.header.To;
import gov.nist.javax.sip.header.Via;
import gov.nist.javax.sip.header.ViaList;
import gov.nist.javax.sip.message.SIPMessage;
import gov.nist.javax.sip.message.SIPRequest;
import gov.nist.javax.sip.message.SIPResponse;
import java.io.IOException;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.util.ListIterator;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.sip.Dialog;
import javax.sip.DialogState;
import javax.sip.InvalidArgumentException;
import javax.sip.ObjectInUseException;
import javax.sip.SipException;
import javax.sip.Timeout;
import javax.sip.TimeoutEvent;
import javax.sip.TransactionState;
import javax.sip.address.Hop;
import javax.sip.address.SipURI;
import javax.sip.header.ExpiresHeader;
import javax.sip.header.RouteHeader;
import javax.sip.header.TimeStampHeader;
import javax.sip.message.Request;

public class SIPClientTransaction extends SIPTransaction implements ServerResponseInterface, javax.sip.ClientTransaction, gov.nist.javax.sip.ClientTransactionExt {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.064 -0400", hash_original_field = "9D1B3F5D17ED1B162A9028E26EB002CF", hash_generated_field = "4FD467E2912A8CCA6B0DF0BC8D0D1212")

    private ConcurrentHashMap<String,SIPDialog> sipDialogs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.064 -0400", hash_original_field = "F4C9163F3B67F1BAF07814D81D1A5BFF", hash_generated_field = "609F87DF574B03997F5F114A0B9D153C")

    private SIPRequest lastRequest;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.064 -0400", hash_original_field = "9FF65E805E77272D5E272AE178834E8E", hash_generated_field = "EBCE51BBA382AA4A4CBC72431B4DD4F6")

    private int viaPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.065 -0400", hash_original_field = "08E65A0B18A72698816D81C11CBA7C86", hash_generated_field = "638E6682C500E41733363C20AADC9C2B")

    private String viaHost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.065 -0400", hash_original_field = "C2F5B0984A31E2BF00C102C547210A78", hash_generated_field = "D5BADECCFB140300052474F1FF053995")

    private transient ServerResponseInterface respondTo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.065 -0400", hash_original_field = "F86AD9818A501BA0007B6D4CB23A57E7", hash_generated_field = "9DA006915F9968E7F19F133BB3970E72")

    private SIPDialog defaultDialog;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.065 -0400", hash_original_field = "75129D9368F303477B6712550E089B5E", hash_generated_field = "B633077E034AF130A4E0928C373CBB0D")

    private Hop nextHop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.065 -0400", hash_original_field = "A6A57E5FB85DB2354843F5CFC0F10126", hash_generated_field = "F8A9EE3383846FA140533EA0DC849D5A")

    private boolean notifyOnRetransmit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.065 -0400", hash_original_field = "3375F1DE75A740A2863FD66BD8AF168D", hash_generated_field = "3AFD3FC295AA4B6D90EAF77E52351862")

    private boolean timeoutIfStillInCallingState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.065 -0400", hash_original_field = "E6FA2A24AC6D7E8AC19BEC7E11CB1C83", hash_generated_field = "5D7F837D171773BD9460FE3577E94E41")

    private int callingStateTimeoutCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.066 -0400", hash_original_method = "7433B8F0086E8DE587CA3684570FA4BD", hash_generated_method = "D0BB4646DF55AEC0B8DDCD47BEFC4796")
    protected  SIPClientTransaction(SIPTransactionStack newSIPStack, MessageChannel newChannelToUse) {
        super(newSIPStack, newChannelToUse);
        addTaint(newChannelToUse.getTaint());
        addTaint(newSIPStack.getTaint());
        setBranch(Utils.getInstance().generateBranchId());
        this.messageProcessor = newChannelToUse.messageProcessor;
        this.setEncapsulatedChannel(newChannelToUse);
        this.notifyOnRetransmit = false;
        this.timeoutIfStillInCallingState = false;
    if(sipStack.isLoggingEnabled())        
        {
            sipStack.getStackLogger().logDebug("Creating clientTransaction " + this);
            sipStack.getStackLogger().logStackTrace();
        } 
        this.sipDialogs = new ConcurrentHashMap();
        
        
        
        
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.066 -0400", hash_original_method = "A499701B9B92E6B9F8BD35BBCEA7DB79", hash_generated_method = "81BDAC6E2EAD5181CA933DB4CA73C8DB")
    public void setResponseInterface(ServerResponseInterface newRespondTo) {
    if(sipStack.isLoggingEnabled())        
        {
            sipStack.getStackLogger().logDebug(
                    "Setting response interface for " + this + " to " + newRespondTo);
    if(newRespondTo == null)            
            {
                sipStack.getStackLogger().logStackTrace();
                sipStack.getStackLogger().logDebug("WARNING -- setting to null!");
            } 
        } 
        respondTo = newRespondTo;
        
        
            
                    
            
                
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.067 -0400", hash_original_method = "2565B9EE896335E27EEEABBB213A9C77", hash_generated_method = "4C91543A7C49DF18A4299B12AAA2A1C9")
    public MessageChannel getRequestChannel() {
MessageChannel var72A74007B2BE62B849F475C7BDA4658B_1142558802 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1142558802.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1142558802;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.069 -0400", hash_original_method = "C99C4952C168074F3FBA7AB2C1372665", hash_generated_method = "2DC08E8E4A0B879E2FB4B503275D1F8A")
    public boolean isMessagePartOfTransaction(SIPMessage messageToTest) {
        addTaint(messageToTest.getTaint());
        ViaList viaHeaders = messageToTest.getViaHeaders();
        boolean transactionMatches;
        String messageBranch = ((Via) viaHeaders.getFirst()).getBranch();
        boolean rfc3261Compliant = getBranch() != null
                && messageBranch != null
                && getBranch().toLowerCase().startsWith(
                        SIPConstants.BRANCH_MAGIC_COOKIE_LOWER_CASE)
                && messageBranch.toLowerCase().startsWith(
                        SIPConstants.BRANCH_MAGIC_COOKIE_LOWER_CASE);
        transactionMatches = false;
    if(TransactionState.COMPLETED == this.getState())        
        {
    if(rfc3261Compliant)            
            {
                transactionMatches = getBranch().equalsIgnoreCase(
                        ((Via) viaHeaders.getFirst()).getBranch())
                        && getMethod().equals(messageToTest.getCSeq().getMethod());
            } 
            else
            {
                transactionMatches = getBranch().equals(messageToTest.getTransactionId());
            } 
        } 
        else
    if(!isTerminated())        
        {
    if(rfc3261Compliant)            
            {
    if(viaHeaders != null)                
                {
    if(getBranch().equalsIgnoreCase(((Via) viaHeaders.getFirst()).getBranch()))                    
                    {
                        transactionMatches = getOriginalRequest().getCSeq().getMethod().equals(
                                messageToTest.getCSeq().getMethod());
                    } 
                } 
            } 
            else
            {
    if(getBranch() != null)                
                {
                    transactionMatches = getBranch().equalsIgnoreCase(
                            messageToTest.getTransactionId());
                } 
                else
                {
                    transactionMatches = getOriginalRequest().getTransactionId()
                            .equalsIgnoreCase(messageToTest.getTransactionId());
                } 
            } 
        } 
        boolean var05E079BB3C0AA5EA1496AF660BBDEC18_523638485 = (transactionMatches);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1000610598 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1000610598;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.071 -0400", hash_original_method = "1DFD8968C3CA232EAF5E448E3048EE02", hash_generated_method = "7A603E1F44F89C22440E584A8D85AB74")
    public void sendMessage(SIPMessage messageToSend) throws IOException {
        addTaint(messageToSend.getTaint());
        try 
        {
            SIPRequest transactionRequest;
            transactionRequest = (SIPRequest) messageToSend;
            Via topVia = (Via) transactionRequest.getViaHeaders().getFirst();
            try 
            {
                topVia.setBranch(getBranch());
            } 
            catch (java.text.ParseException ex)
            {
            } 
    if(sipStack.isLoggingEnabled())            
            {
                sipStack.getStackLogger().logDebug("Sending Message " + messageToSend);
                sipStack.getStackLogger().logDebug("TransactionState " + this.getState());
            } 
    if(TransactionState.PROCEEDING == getState()
                    || TransactionState.CALLING == getState())            
            {
    if(transactionRequest.getMethod().equals(Request.ACK))                
                {
    if(isReliable())                    
                    {
                        this.setState(TransactionState.TERMINATED);
                    } 
                    else
                    {
                        this.setState(TransactionState.COMPLETED);
                    } 
                    super.sendMessage(transactionRequest);
                    return;
                } 
            } 
            try 
            {
                lastRequest = transactionRequest;
    if(getState() == null)                
                {
                    setOriginalRequest(transactionRequest);
    if(transactionRequest.getMethod().equals(Request.INVITE))                    
                    {
                        this.setState(TransactionState.CALLING);
                    } 
                    else
    if(transactionRequest.getMethod().equals(Request.ACK))                    
                    {
                        this.setState(TransactionState.TERMINATED);
                    } 
                    else
                    {
                        this.setState(TransactionState.TRYING);
                    } 
    if(!isReliable())                    
                    {
                        enableRetransmissionTimer();
                    } 
    if(isInviteTransaction())                    
                    {
                        enableTimeoutTimer(TIMER_B);
                    } 
                    else
                    {
                        enableTimeoutTimer(TIMER_F);
                    } 
                } 
                super.sendMessage(transactionRequest);
            } 
            catch (IOException e)
            {
                this.setState(TransactionState.TERMINATED);
                e.addTaint(taint);
                throw e;
            } 
        } 
        finally 
        {
            this.isMapped = true;
            this.startTransactionTimer();
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.073 -0400", hash_original_method = "27FC8E987828EB63A48AA2B14048F41C", hash_generated_method = "DA679BFF18BA26AD4A1EF8DA988AEEA4")
    public synchronized void processResponse(SIPResponse transactionResponse,
            MessageChannel sourceChannel, SIPDialog dialog) {
        addTaint(dialog.getTaint());
        addTaint(sourceChannel.getTaint());
        addTaint(transactionResponse.getTaint());
    if(getState() == null)        
        return;
    if((TransactionState.COMPLETED == this.getState() || TransactionState.TERMINATED == this
                .getState())
                && transactionResponse.getStatusCode() / 100 == 1)        
        {
            return;
        } 
    if(sipStack.isLoggingEnabled())        
        {
            sipStack.getStackLogger().logDebug(
                    "processing " + transactionResponse.getFirstLine() + "current state = "
                            + getState());
            sipStack.getStackLogger().logDebug("dialog = " + dialog);
        } 
        this.lastResponse = transactionResponse;
        try 
        {
    if(isInviteTransaction())            
            inviteClientTransaction(transactionResponse, sourceChannel, dialog);
            else
            nonInviteClientTransaction(transactionResponse, sourceChannel, dialog);
        } 
        catch (IOException ex)
        {
    if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger().logException(ex);
            this.setState(TransactionState.TERMINATED);
            raiseErrorEvent(SIPTransactionErrorEvent.TRANSPORT_ERROR);
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.075 -0400", hash_original_method = "ADF3D75C6ADD47CBC6B3D63B5D3998CF", hash_generated_method = "0E34F8263D7006E4E63431945E103609")
    private void nonInviteClientTransaction(SIPResponse transactionResponse,
            MessageChannel sourceChannel, SIPDialog sipDialog) throws IOException {
        addTaint(sipDialog.getTaint());
        addTaint(sourceChannel.getTaint());
        addTaint(transactionResponse.getTaint());
        int statusCode = transactionResponse.getStatusCode();
    if(TransactionState.TRYING == this.getState())        
        {
    if(statusCode / 100 == 1)            
            {
                this.setState(TransactionState.PROCEEDING);
                enableRetransmissionTimer(MAXIMUM_RETRANSMISSION_TICK_COUNT);
                enableTimeoutTimer(TIMER_F);
    if(respondTo != null)                
                {
                    respondTo.processResponse(transactionResponse, this, sipDialog);
                } 
                else
                {
                    this.semRelease();
                } 
            } 
            else
    if(200 <= statusCode && statusCode <= 699)            
            {
    if(respondTo != null)                
                {
                    respondTo.processResponse(transactionResponse, this, sipDialog);
                } 
                else
                {
                    this.semRelease();
                } 
    if(!isReliable())                
                {
                    this.setState(TransactionState.COMPLETED);
                    enableTimeoutTimer(TIMER_K);
                } 
                else
                {
                    this.setState(TransactionState.TERMINATED);
                } 
            } 
        } 
        else
    if(TransactionState.PROCEEDING == this.getState())        
        {
    if(statusCode / 100 == 1)            
            {
    if(respondTo != null)                
                {
                    respondTo.processResponse(transactionResponse, this, sipDialog);
                } 
                else
                {
                    this.semRelease();
                } 
            } 
            else
    if(200 <= statusCode && statusCode <= 699)            
            {
    if(respondTo != null)                
                {
                    respondTo.processResponse(transactionResponse, this, sipDialog);
                } 
                else
                {
                    this.semRelease();
                } 
                disableRetransmissionTimer();
                disableTimeoutTimer();
    if(!isReliable())                
                {
                    this.setState(TransactionState.COMPLETED);
                    enableTimeoutTimer(TIMER_K);
                } 
                else
                {
                    this.setState(TransactionState.TERMINATED);
                } 
            } 
        } 
        else
        {
    if(sipStack.isLoggingEnabled())            
            {
                sipStack.getStackLogger().logDebug(
                        " Not sending response to TU! " + getState());
            } 
            this.semRelease();
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.079 -0400", hash_original_method = "C74AAAAD68DF1265333F033333BC207B", hash_generated_method = "F9C87560DDA7F0452FEDB1728923712A")
    private void inviteClientTransaction(SIPResponse transactionResponse,
            MessageChannel sourceChannel, SIPDialog dialog) throws IOException {
        addTaint(dialog.getTaint());
        addTaint(sourceChannel.getTaint());
        addTaint(transactionResponse.getTaint());
        int statusCode = transactionResponse.getStatusCode();
    if(TransactionState.TERMINATED == this.getState())        
        {
            boolean ackAlreadySent = false;
    if(dialog != null && dialog.isAckSeen() && dialog.getLastAckSent() != null)            
            {
    if(dialog.getLastAckSent().getCSeq().getSeqNumber() == transactionResponse.getCSeq()
                        .getSeqNumber()
                        && transactionResponse.getFromTag().equals(
                                dialog.getLastAckSent().getFromTag()))                
                {
                    ackAlreadySent = true;
                } 
            } 
    if(dialog!= null && ackAlreadySent
                    && transactionResponse.getCSeq().getMethod().equals(dialog.getMethod()))            
            {
                try 
                {
    if(sipStack.isLoggingEnabled())                    
                    sipStack.getStackLogger().logDebug("resending ACK");
                    dialog.resendAck();
                } 
                catch (SipException ex)
                {
                } 
            } 
            this.semRelease();
            return;
        } 
        else
    if(TransactionState.CALLING == this.getState())        
        {
    if(statusCode / 100 == 2)            
            {
                disableRetransmissionTimer();
                disableTimeoutTimer();
                this.setState(TransactionState.TERMINATED);
    if(respondTo != null)                
                respondTo.processResponse(transactionResponse, this, dialog);
                else
                {
                    this.semRelease();
                } 
            } 
            else
    if(statusCode / 100 == 1)            
            {
                disableRetransmissionTimer();
                disableTimeoutTimer();
                this.setState(TransactionState.PROCEEDING);
    if(respondTo != null)                
                respondTo.processResponse(transactionResponse, this, dialog);
                else
                {
                    this.semRelease();
                } 
            } 
            else
    if(300 <= statusCode && statusCode <= 699)            
            {
                try 
                {
                    sendMessage((SIPRequest) createErrorAck());
                } 
                catch (Exception ex)
                {
                    sipStack.getStackLogger().logError(
                            "Unexpected Exception sending ACK -- sending error AcK ", ex);
                } 
    if(respondTo != null)                
                {
                    respondTo.processResponse(transactionResponse, this, dialog);
                } 
                else
                {
                    this.semRelease();
                } 
    if(this.getDialog() != null &&  ((SIPDialog)this.getDialog()).isBackToBackUserAgent())                
                {
                    ((SIPDialog) this.getDialog()).releaseAckSem();
                } 
    if(!isReliable())                
                {
                    this.setState(TransactionState.COMPLETED);
                    enableTimeoutTimer(TIMER_D);
                } 
                else
                {
                    this.setState(TransactionState.TERMINATED);
                } 
            } 
        } 
        else
    if(TransactionState.PROCEEDING == this.getState())        
        {
    if(statusCode / 100 == 1)            
            {
    if(respondTo != null)                
                {
                    respondTo.processResponse(transactionResponse, this, dialog);
                } 
                else
                {
                    this.semRelease();
                } 
            } 
            else
    if(statusCode / 100 == 2)            
            {
                this.setState(TransactionState.TERMINATED);
    if(respondTo != null)                
                {
                    respondTo.processResponse(transactionResponse, this, dialog);
                } 
                else
                {
                    this.semRelease();
                } 
            } 
            else
    if(300 <= statusCode && statusCode <= 699)            
            {
                try 
                {
                    sendMessage((SIPRequest) createErrorAck());
                } 
                catch (Exception ex)
                {
                    InternalErrorHandler.handleException(ex);
                } 
    if(this.getDialog() != null)                
                {
                    ((SIPDialog) this.getDialog()).releaseAckSem();
                } 
    if(!isReliable())                
                {
                    this.setState(TransactionState.COMPLETED);
                    this.enableTimeoutTimer(TIMER_D);
                } 
                else
                {
                    this.setState(TransactionState.TERMINATED);
                } 
    if(respondTo != null)                
                respondTo.processResponse(transactionResponse, this, dialog);
                else
                {
                    this.semRelease();
                } 
            } 
        } 
        else
    if(TransactionState.COMPLETED == this.getState())        
        {
    if(300 <= statusCode && statusCode <= 699)            
            {
                try 
                {
                    sendMessage((SIPRequest) createErrorAck());
                } 
                catch (Exception ex)
                {
                    InternalErrorHandler.handleException(ex);
                } 
                finally 
                {
                    this.semRelease();
                } 
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.085 -0400", hash_original_method = "9C1F15FBE6A7795E5EE0D6BE4F94BCBE", hash_generated_method = "9772A30A5E65305C03DC7976FD7DD218")
    public void sendRequest() throws SipException {
        SIPRequest sipRequest = this.getOriginalRequest();
    if(this.getState() != null)        
        {
        SipException var323EC48B4E48AB2794DF82AC704E6880_891982536 = new SipException("Request already sent");
        var323EC48B4E48AB2794DF82AC704E6880_891982536.addTaint(taint);
        throw var323EC48B4E48AB2794DF82AC704E6880_891982536;
        }
    if(sipStack.isLoggingEnabled())        
        {
            sipStack.getStackLogger().logDebug("sendRequest() " + sipRequest);
        } 
        try 
        {
            sipRequest.checkHeaders();
        } 
        catch (ParseException ex)
        {
    if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger().logError("missing required header");
            SipException var892635990475903AE5F007B5D011DC38_308191792 = new SipException(ex.getMessage());
            var892635990475903AE5F007B5D011DC38_308191792.addTaint(taint);
            throw var892635990475903AE5F007B5D011DC38_308191792;
        } 
    if(getMethod().equals(Request.SUBSCRIBE)
                && sipRequest.getHeader(ExpiresHeader.NAME) == null)        
        {
    if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger().logWarning(
                    "Expires header missing in outgoing subscribe --"
                            + " Notifier will assume implied value on event package");
        } 
        try 
        {
    if(this.getOriginalRequest().getMethod().equals(Request.CANCEL)
                    && sipStack.isCancelClientTransactionChecked())            
            {
                SIPClientTransaction ct = (SIPClientTransaction) sipStack.findCancelTransaction(
                        this.getOriginalRequest(), false);
    if(ct == null)                
                {
                    SipException var5623065BB8CB1B84B3235D801110D626_790747168 = new SipException("Could not find original tx to cancel. RFC 3261 9.1");
                    var5623065BB8CB1B84B3235D801110D626_790747168.addTaint(taint);
                    throw var5623065BB8CB1B84B3235D801110D626_790747168;
                } 
                else
    if(ct.getState() == null)                
                {
                    SipException varD384862B33895AC5BA03FBB252919FF0_1709478876 = new SipException(
                            "State is null no provisional response yet -- cannot cancel RFC 3261 9.1");
                    varD384862B33895AC5BA03FBB252919FF0_1709478876.addTaint(taint);
                    throw varD384862B33895AC5BA03FBB252919FF0_1709478876;
                } 
                else
    if(!ct.getMethod().equals(Request.INVITE))                
                {
                    SipException var9A48AF195A96F4F65AFD0681AD6B8DFA_918608441 = new SipException("Cannot cancel non-invite requests RFC 3261 9.1");
                    var9A48AF195A96F4F65AFD0681AD6B8DFA_918608441.addTaint(taint);
                    throw var9A48AF195A96F4F65AFD0681AD6B8DFA_918608441;
                } 
            } 
            else
    if(this.getOriginalRequest().getMethod().equals(Request.BYE)
                    || this.getOriginalRequest().getMethod().equals(Request.NOTIFY))            
            {
                SIPDialog dialog = sipStack.getDialog(this.getOriginalRequest()
                        .getDialogId(false));
    if(this.getSipProvider().isAutomaticDialogSupportEnabled() && dialog != null)                
                {
                    SipException var51DB0FE9536946D398FFD0021FFBD630_585071793 = new SipException(
                            "Dialog is present and AutomaticDialogSupport is enabled for "
                                    + " the provider -- Send the Request using the Dialog.sendRequest(transaction)");
                    var51DB0FE9536946D398FFD0021FFBD630_585071793.addTaint(taint);
                    throw var51DB0FE9536946D398FFD0021FFBD630_585071793;
                } 
            } 
    if(this.getMethod().equals(Request.INVITE))            
            {
                SIPDialog dialog = this.getDefaultDialog();
    if(dialog != null && dialog.isBackToBackUserAgent())                
                {
    if(! dialog.takeAckSem())                    
                    {
                        SipException var6D42BBD9DCA679354CDF7F25AB3CB52B_1125633871 = new SipException ("Failed to take ACK semaphore");
                        var6D42BBD9DCA679354CDF7F25AB3CB52B_1125633871.addTaint(taint);
                        throw var6D42BBD9DCA679354CDF7F25AB3CB52B_1125633871;
                    } 
                } 
            } 
            this.isMapped = true;
            this.sendMessage(sipRequest);
        } 
        catch (IOException ex)
        {
            this.setState(TransactionState.TERMINATED);
            SipException var9970C3F2D77AA08BF1A0FB59825D7A46_175794343 = new SipException("IO Error sending request", ex);
            var9970C3F2D77AA08BF1A0FB59825D7A46_175794343.addTaint(taint);
            throw var9970C3F2D77AA08BF1A0FB59825D7A46_175794343;
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.087 -0400", hash_original_method = "328DA368C3B0C5FF79EC2B4ACE66A1A9", hash_generated_method = "FA557C4BFA3C175EFC0192B72F6B3A23")
    protected void fireRetransmissionTimer() {
        try 
        {
    if(this.getState() == null || !this.isMapped)            
            return;
            boolean inv = isInviteTransaction();
            TransactionState s = this.getState();
    if((inv && TransactionState.CALLING == s)
                    || (!inv && (TransactionState.TRYING == s || TransactionState.PROCEEDING == s)))            
            {
    if(lastRequest != null)                
                {
    if(sipStack.generateTimeStampHeader
                            && lastRequest.getHeader(TimeStampHeader.NAME) != null)                    
                    {
                        long milisec = System.currentTimeMillis();
                        TimeStamp timeStamp = new TimeStamp();
                        try 
                        {
                            timeStamp.setTimeStamp(milisec);
                        } 
                        catch (InvalidArgumentException ex)
                        {
                            InternalErrorHandler.handleException(ex);
                        } 
                        lastRequest.setHeader(timeStamp);
                    } 
                    super.sendMessage(lastRequest);
    if(this.notifyOnRetransmit)                    
                    {
                        TimeoutEvent txTimeout = new TimeoutEvent(this.getSipProvider(), this,
                                Timeout.RETRANSMIT);
                        this.getSipProvider().handleEvent(txTimeout, this);
                    } 
    if(this.timeoutIfStillInCallingState
                            && this.getState() == TransactionState.CALLING)                    
                    {
                        this.callingStateTimeoutCount--;
    if(callingStateTimeoutCount == 0)                        
                        {
                            TimeoutEvent timeoutEvent = new TimeoutEvent(this.getSipProvider(),
                                    this, Timeout.RETRANSMIT);
                            this.getSipProvider().handleEvent(timeoutEvent, this);
                            this.timeoutIfStillInCallingState = false;
                        } 
                    } 
                } 
            } 
        } 
        catch (IOException e)
        {
            this.raiseIOExceptionEvent();
            raiseErrorEvent(SIPTransactionErrorEvent.TRANSPORT_ERROR);
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.089 -0400", hash_original_method = "F0DB4D0E841E14FF88BA6095928288BF", hash_generated_method = "66BED8820FB28123830C985DF6631E58")
    protected void fireTimeoutTimer() {
    if(sipStack.isLoggingEnabled())        
        sipStack.getStackLogger().logDebug("fireTimeoutTimer " + this);
        SIPDialog dialog = (SIPDialog) this.getDialog();
    if(TransactionState.CALLING == this.getState()
                || TransactionState.TRYING == this.getState()
                || TransactionState.PROCEEDING == this.getState())        
        {
    if(dialog != null
                    && (dialog.getState() == null || dialog.getState() == DialogState.EARLY))            
            {
    if(((SIPTransactionStack) getSIPStack()).isDialogCreated(this
                        .getOriginalRequest().getMethod()))                
                {
                    dialog.delete();
                } 
            } 
            else
    if(dialog != null)            
            {
    if(getOriginalRequest().getMethod().equalsIgnoreCase(Request.BYE)
                        && dialog.isTerminatedOnBye())                
                {
                    dialog.delete();
                } 
            } 
        } 
    if(TransactionState.COMPLETED != this.getState())        
        {
            raiseErrorEvent(SIPTransactionErrorEvent.TIMEOUT_ERROR);
    if(this.getOriginalRequest().getMethod().equalsIgnoreCase(Request.CANCEL))            
            {
                SIPClientTransaction inviteTx = (SIPClientTransaction) this.getOriginalRequest()
                        .getInviteTransaction();
    if(inviteTx != null
                        && ((inviteTx.getState() == TransactionState.CALLING || inviteTx
                                .getState() == TransactionState.PROCEEDING))
                        && inviteTx.getDialog() != null)                
                {
                    inviteTx.setState(TransactionState.TERMINATED);
                } 
            } 
        } 
        else
        {
            this.setState(TransactionState.TERMINATED);
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.091 -0400", hash_original_method = "2914559B80386C20A981D1BD82B7352B", hash_generated_method = "7226DA9F18D476F0D7FE0169C37E014F")
    public Request createCancel() throws SipException {
        SIPRequest originalRequest = this.getOriginalRequest();
    if(originalRequest == null)        
        {
        SipException var18B76834363424CDD125E2AA64838D19_771885779 = new SipException("Bad state " + getState());
        var18B76834363424CDD125E2AA64838D19_771885779.addTaint(taint);
        throw var18B76834363424CDD125E2AA64838D19_771885779;
        }
    if(!originalRequest.getMethod().equals(Request.INVITE))        
        {
        SipException varA18337FC5CB83A82DBEDAFC4C2492923_2125978174 = new SipException("Only INIVTE may be cancelled");
        varA18337FC5CB83A82DBEDAFC4C2492923_2125978174.addTaint(taint);
        throw varA18337FC5CB83A82DBEDAFC4C2492923_2125978174;
        }
    if(originalRequest.getMethod().equalsIgnoreCase(Request.ACK))        
        {
        SipException var78FB36631624D00982EED30DEED5BB40_1977420518 = new SipException("Cannot Cancel ACK!");
        var78FB36631624D00982EED30DEED5BB40_1977420518.addTaint(taint);
        throw var78FB36631624D00982EED30DEED5BB40_1977420518;
        }
        else
        {
            SIPRequest cancelRequest = originalRequest.createCancelRequest();
            cancelRequest.setInviteTransaction(this);
Request varACA153049E738A20BB5740684F6D8EF1_1642353904 =             cancelRequest;
            varACA153049E738A20BB5740684F6D8EF1_1642353904.addTaint(taint);
            return varACA153049E738A20BB5740684F6D8EF1_1642353904;
        } 
        
        
        
            
        
            
        
            
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.095 -0400", hash_original_method = "59092618FB848453FA0559AC58047778", hash_generated_method = "1E8CB41AE502330E7B51A10DD36FC49A")
    public Request createAck() throws SipException {
        SIPRequest originalRequest = this.getOriginalRequest();
    if(originalRequest == null)        
        {
        SipException varB03D7382310E3D88ABC47C127A09486A_1703324073 = new SipException("bad state " + getState());
        varB03D7382310E3D88ABC47C127A09486A_1703324073.addTaint(taint);
        throw varB03D7382310E3D88ABC47C127A09486A_1703324073;
        }
    if(getMethod().equalsIgnoreCase(Request.ACK))        
        {
            SipException var009E015AE15B853B2D4591E9AABA5E99_1857240044 = new SipException("Cannot ACK an ACK!");
            var009E015AE15B853B2D4591E9AABA5E99_1857240044.addTaint(taint);
            throw var009E015AE15B853B2D4591E9AABA5E99_1857240044;
        } 
        else
    if(lastResponse == null)        
        {
            SipException varD59D3207F7990DD4DAC24E65A1CE35E6_1107699290 = new SipException("bad Transaction state");
            varD59D3207F7990DD4DAC24E65A1CE35E6_1107699290.addTaint(taint);
            throw varD59D3207F7990DD4DAC24E65A1CE35E6_1107699290;
        } 
        else
    if(lastResponse.getStatusCode() < 200)        
        {
    if(sipStack.isLoggingEnabled())            
            {
                sipStack.getStackLogger().logDebug("lastResponse = " + lastResponse);
            } 
            SipException varD7CEAC34620F3EF85D7F67F88F42DD93_1152737622 = new SipException("Cannot ACK a provisional response!");
            varD7CEAC34620F3EF85D7F67F88F42DD93_1152737622.addTaint(taint);
            throw varD7CEAC34620F3EF85D7F67F88F42DD93_1152737622;
        } 
        SIPRequest ackRequest = originalRequest.createAckRequest((To) lastResponse.getTo());
        RecordRouteList recordRouteList = lastResponse.getRecordRouteHeaders();
    if(recordRouteList == null)        
        {
    if(lastResponse.getContactHeaders() != null
                    && lastResponse.getStatusCode() / 100 != 3)            
            {
                Contact contact = (Contact) lastResponse.getContactHeaders().getFirst();
                javax.sip.address.URI uri = (javax.sip.address.URI) contact.getAddress().getURI()
                        .clone();
                ackRequest.setRequestURI(uri);
            } 
Request var53E5C6F852A0BB73314408FE0ABC9A68_1570006350 =             ackRequest;
            var53E5C6F852A0BB73314408FE0ABC9A68_1570006350.addTaint(taint);
            return var53E5C6F852A0BB73314408FE0ABC9A68_1570006350;
        } 
        ackRequest.removeHeader(RouteHeader.NAME);
        RouteList routeList = new RouteList();
        ListIterator<RecordRoute> li = recordRouteList.listIterator(recordRouteList.size());
        while
(li.hasPrevious())        
        {
            RecordRoute rr = (RecordRoute) li.previous();
            Route route = new Route();
            route.setAddress((AddressImpl) ((AddressImpl) rr.getAddress()).clone());
            route.setParameters((NameValueList) rr.getParameters().clone());
            routeList.add(route);
        } 
        Contact contact = null;
    if(lastResponse.getContactHeaders() != null)        
        {
            contact = (Contact) lastResponse.getContactHeaders().getFirst();
        } 
    if(!((SipURI) ((Route) routeList.getFirst()).getAddress().getURI()).hasLrParam())        
        {
            Route route = null;
    if(contact != null)            
            {
                route = new Route();
                route.setAddress((AddressImpl) ((AddressImpl) (contact.getAddress())).clone());
            } 
            Route firstRoute = (Route) routeList.getFirst();
            routeList.removeFirst();
            javax.sip.address.URI uri = firstRoute.getAddress().getURI();
            ackRequest.setRequestURI(uri);
    if(route != null)            
            routeList.add(route);
            ackRequest.addHeader(routeList);
        } 
        else
        {
    if(contact != null)            
            {
                javax.sip.address.URI uri = (javax.sip.address.URI) contact.getAddress().getURI()
                        .clone();
                ackRequest.setRequestURI(uri);
                ackRequest.addHeader(routeList);
            } 
        } 
Request var53E5C6F852A0BB73314408FE0ABC9A68_146420723 =         ackRequest;
        var53E5C6F852A0BB73314408FE0ABC9A68_146420723.addTaint(taint);
        return var53E5C6F852A0BB73314408FE0ABC9A68_146420723;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.098 -0400", hash_original_method = "C777E21FF4216BC8A7ADE1EB27ADDE8D", hash_generated_method = "3A24E950C548B9DFAC9043ABE8444A4E")
    private final Request createErrorAck() throws SipException, ParseException {
        SIPRequest originalRequest = this.getOriginalRequest();
    if(originalRequest == null)        
        {
        SipException varB03D7382310E3D88ABC47C127A09486A_1671600032 = new SipException("bad state " + getState());
        varB03D7382310E3D88ABC47C127A09486A_1671600032.addTaint(taint);
        throw varB03D7382310E3D88ABC47C127A09486A_1671600032;
        }
    if(!getMethod().equals(Request.INVITE))        
        {
            SipException var33C0B577B139AB1BF6F1006FA990B153_957290893 = new SipException("Can only ACK an INVITE!");
            var33C0B577B139AB1BF6F1006FA990B153_957290893.addTaint(taint);
            throw var33C0B577B139AB1BF6F1006FA990B153_957290893;
        } 
        else
    if(lastResponse == null)        
        {
            SipException varD59D3207F7990DD4DAC24E65A1CE35E6_783788986 = new SipException("bad Transaction state");
            varD59D3207F7990DD4DAC24E65A1CE35E6_783788986.addTaint(taint);
            throw varD59D3207F7990DD4DAC24E65A1CE35E6_783788986;
        } 
        else
    if(lastResponse.getStatusCode() < 200)        
        {
    if(sipStack.isLoggingEnabled())            
            {
                sipStack.getStackLogger().logDebug("lastResponse = " + lastResponse);
            } 
            SipException varD7CEAC34620F3EF85D7F67F88F42DD93_1348155516 = new SipException("Cannot ACK a provisional response!");
            varD7CEAC34620F3EF85D7F67F88F42DD93_1348155516.addTaint(taint);
            throw varD7CEAC34620F3EF85D7F67F88F42DD93_1348155516;
        } 
Request varB1D621DACB597072EA649D0AC7D0DC3C_937818894 =         originalRequest.createErrorAck((To) lastResponse.getTo());
        varB1D621DACB597072EA649D0AC7D0DC3C_937818894.addTaint(taint);
        return varB1D621DACB597072EA649D0AC7D0DC3C_937818894;
        
        
        
            
        
            
        
            
        
            
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.099 -0400", hash_original_method = "FADEF945106DA805CF02027B2BE28020", hash_generated_method = "F178A79F5020E3C9AEE90D08526F030A")
    protected void setViaPort(int port) {
        this.viaPort = port;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.100 -0400", hash_original_method = "0E538A29C97CB223EF1CD12A71C73074", hash_generated_method = "49F7B6C2EB4C3BA81CAAD6672E78455A")
    protected void setViaHost(String host) {
        this.viaHost = host;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.101 -0400", hash_original_method = "133D8E60A07873D19335FF91037EC663", hash_generated_method = "49F2742BDA860C79A6AA5C13D1872B22")
    public int getViaPort() {
        int varD43D0AD9254055D58B581E8CE6E033A9_1401385945 = (this.viaPort);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_89671843 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_89671843;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.101 -0400", hash_original_method = "BFF3BD5D9B7619BE758B5D7001336743", hash_generated_method = "8C823B2476B7CA20353AF8D93C46BC89")
    public String getViaHost() {
String var5C49F2A6248841A6C8138BE7213E150E_630854032 =         this.viaHost;
        var5C49F2A6248841A6C8138BE7213E150E_630854032.addTaint(taint);
        return var5C49F2A6248841A6C8138BE7213E150E_630854032;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.102 -0400", hash_original_method = "0750F8DA140E6BEE450B9743ACFD7E44", hash_generated_method = "1DA5E16F2C6E5397F6F66AF1CF8C3E6A")
    public Via getOutgoingViaHeader() {
Via var9A2F2EDE559A039B7F1EAC2CD02F6527_1068274590 =         this.getMessageProcessor().getViaHeader();
        var9A2F2EDE559A039B7F1EAC2CD02F6527_1068274590.addTaint(taint);
        return var9A2F2EDE559A039B7F1EAC2CD02F6527_1068274590;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.102 -0400", hash_original_method = "B250DD181A3373E2CC04255377753F31", hash_generated_method = "6CCA103991603EF3F3C26F3C09E7F13D")
    public void clearState() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.103 -0400", hash_original_method = "513C7C1329620A072B43100259C2C5F6", hash_generated_method = "7E5B38E45DDC0A88EF7BA5931A947D15")
    public void setState(TransactionState newState) {
        addTaint(newState.getTaint());
    if(newState == TransactionState.TERMINATED && this.isReliable()
                && (!getSIPStack().cacheClientConnections))        
        {
            this.collectionTime = TIMER_J;
        } 
    if(super.getState() != TransactionState.COMPLETED
                && (newState == TransactionState.COMPLETED || newState == TransactionState.TERMINATED))        
        {
            sipStack.decrementActiveClientTransactionCount();
        } 
        super.setState(newState);
        
        
                
            
        
        
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.103 -0400", hash_original_method = "8AD9FEC5ADB8A6F1DFBB290459716C8C", hash_generated_method = "580BF89705E4BAF1556D75F00CF9DF2F")
    protected void startTransactionTimer() {
    if(this.transactionTimerStarted.compareAndSet(false, true))        
        {
            TimerTask myTimer = new TransactionTimer();
    if(sipStack.getTimer() != null)            
            {
                sipStack.getTimer().schedule(myTimer, BASE_TIMER_INTERVAL, BASE_TIMER_INTERVAL);
            } 
        } 
        
        
	        
	        
	            
	        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.104 -0400", hash_original_method = "ACD8113ABC5B192A943EAFBD5656CA38", hash_generated_method = "9600A5B5EE9B39E2643E3ED4DD70BFBE")
    public void terminate() throws ObjectInUseException {
        this.setState(TransactionState.TERMINATED);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.104 -0400", hash_original_method = "8BA63F6111F6111C9CE6504A86A67BA3", hash_generated_method = "E81B4DD9DF499238BEF55A39E5D4DF25")
    public boolean checkFromTag(SIPResponse sipResponse) {
        addTaint(sipResponse.getTaint());
        String originalFromTag = ((SIPRequest) this.getRequest()).getFromTag();
    if(this.defaultDialog != null)        
        {
    if(originalFromTag == null ^ sipResponse.getFrom().getTag() == null)            
            {
    if(sipStack.isLoggingEnabled())                
                sipStack.getStackLogger().logDebug("From tag mismatch -- dropping response");
                boolean var68934A3E9455FA72420237EB05902327_452375060 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1094306447 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1094306447;
            } 
    if(originalFromTag != null
                    && !originalFromTag.equalsIgnoreCase(sipResponse.getFrom().getTag()))            
            {
    if(sipStack.isLoggingEnabled())                
                sipStack.getStackLogger().logDebug("From tag mismatch -- dropping response");
                boolean var68934A3E9455FA72420237EB05902327_1297845665 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_953560749 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_953560749;
            } 
        } 
        boolean varB326B5062B2F0E69046810717534CB09_1640487494 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1748968769 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1748968769;
        
        
        
            
            	
            		
                
            
            
                    
            	
            		
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.106 -0400", hash_original_method = "38065D3AA78F19CFA0459E8A308EC067", hash_generated_method = "44E26C3D20ED462A154C7CA8C027EBF4")
    public void processResponse(SIPResponse sipResponse, MessageChannel incomingChannel) {
        addTaint(incomingChannel.getTaint());
        addTaint(sipResponse.getTaint());
        SIPDialog dialog = null;
        String method = sipResponse.getCSeq().getMethod();
        String dialogId = sipResponse.getDialogId(false);
    if(method.equals(Request.CANCEL) && lastRequest != null)        
        {
            SIPClientTransaction ict = (SIPClientTransaction) lastRequest.getInviteTransaction();
    if(ict != null)            
            {
                dialog = ict.defaultDialog;
            } 
        } 
        else
        {
            dialog = this.getDialog(dialogId);
        } 
    if(dialog == null)        
        {
            int code = sipResponse.getStatusCode();
    if((code > 100 && code < 300)
            && (sipResponse.getToTag() != null || sipStack.isRfc2543Supported())
                    && sipStack.isDialogCreated(method))            
            {
                synchronized
(this)                {
    if(defaultDialog != null)                    
                    {
    if(sipResponse.getFromTag() != null)                        
                        {
                            SIPResponse dialogResponse = defaultDialog.getLastResponse();
                            String defaultDialogId = defaultDialog.getDialogId();
    if(dialogResponse == null
                                    || (method.equals(Request.SUBSCRIBE)
                                            && dialogResponse.getCSeq().getMethod().equals(
                                                    Request.NOTIFY) && defaultDialogId
                                            .equals(dialogId)))                            
                            {
                                defaultDialog.setLastResponse(this, sipResponse);
                                dialog = defaultDialog;
                            } 
                            else
                            {
                                dialog = sipStack.getDialog(dialogId);
    if(dialog == null)                                
                                {
    if(defaultDialog.isAssigned())                                    
                                    {
                                        dialog = sipStack.createDialog(this, sipResponse);
                                    } 
                                } 
                            } 
    if(dialog != null)                            
                            {
                                this.setDialog(dialog, dialog.getDialogId());
                            } 
                            else
                            {
                                sipStack.getStackLogger().logError("dialog is unexpectedly null",new NullPointerException());
                            } 
                        } 
                        else
                        {
                            RuntimeException var6755A7A7F32D8B6EF3BEF356B4AC67B6_624335313 = new RuntimeException("Response without from-tag");
                            var6755A7A7F32D8B6EF3BEF356B4AC67B6_624335313.addTaint(taint);
                            throw var6755A7A7F32D8B6EF3BEF356B4AC67B6_624335313;
                        } 
                    } 
                    else
                    {
    if(sipStack.isAutomaticDialogSupportEnabled)                        
                        {
                            dialog = sipStack.createDialog(this, sipResponse);
                            this.setDialog(dialog, dialog.getDialogId());
                        } 
                    } 
                } 
            } 
            else
            {
                dialog = defaultDialog;
            } 
        } 
        else
        {
            dialog.setLastResponse(this, sipResponse);
        } 
        this.processResponse(sipResponse, incomingChannel, dialog);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.109 -0400", hash_original_method = "A455A41B989A73F91883A443A89AF007", hash_generated_method = "03379E1FDBF0FBA344A96497417F6C4D")
    public Dialog getDialog() {
        Dialog retval = null;
    if(this.lastResponse != null && this.lastResponse.getFromTag() != null
                && this.lastResponse.getToTag() != null
                && this.lastResponse.getStatusCode() != 100)        
        {
            String dialogId = this.lastResponse.getDialogId(false);
            retval = (Dialog) getDialog(dialogId);
        } 
    if(retval == null)        
        {
            retval = (Dialog) this.defaultDialog;
        } 
    if(sipStack.isLoggingEnabled())        
        {
            sipStack.getStackLogger().logDebug(
                    " sipDialogs =  " + sipDialogs + " default dialog " + this.defaultDialog
                            + " retval " + retval);
        } 
Dialog varF9E19AD6135C970F387F77C6F3DE4477_1975662560 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1975662560.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1975662560;
        
        
        
                
                
            
            
        
        
            
        
        
            
                    
                            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.110 -0400", hash_original_method = "7CA3466B3B290C9233529520194EB8A2", hash_generated_method = "BCBCA9C5E02D30E8DD0182337BCD7EA5")
    public SIPDialog getDialog(String dialogId) {
        addTaint(dialogId.getTaint());
        SIPDialog retval = (SIPDialog) this.sipDialogs.get(dialogId);
SIPDialog varF9E19AD6135C970F387F77C6F3DE4477_1140293123 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1140293123.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1140293123;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.112 -0400", hash_original_method = "9816411304542A0CA40176674DC457D1", hash_generated_method = "4AC0895193352FCBF75500EA243C9E0F")
    public void setDialog(SIPDialog sipDialog, String dialogId) {
        addTaint(dialogId.getTaint());
    if(sipStack.isLoggingEnabled())        
        sipStack.getStackLogger().logDebug(
                    "setDialog: " + dialogId + "sipDialog = " + sipDialog);
    if(sipDialog == null)        
        {
    if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger().logError("NULL DIALOG!!");
            NullPointerException varDBD8AFDE5895AD4848FD81F119F093F5_1953674118 = new NullPointerException("bad dialog null");
            varDBD8AFDE5895AD4848FD81F119F093F5_1953674118.addTaint(taint);
            throw varDBD8AFDE5895AD4848FD81F119F093F5_1953674118;
        } 
    if(this.defaultDialog == null)        
        {
            this.defaultDialog = sipDialog;
    if(this.getMethod().equals(Request.INVITE) && this.getSIPStack().maxForkTime != 0)            
            {
                this.getSIPStack().addForkedClientTransaction(this);
            } 
        } 
    if(dialogId != null && sipDialog.getDialogId() != null)        
        {
            this.sipDialogs.put(dialogId, sipDialog);
        } 
        
        
            
                    
        
        	
        		
            
        
        
            
            
                
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.112 -0400", hash_original_method = "EC86D15857564E1427115ADA6B1A0784", hash_generated_method = "B6F0EEECAF49882C9F1428AC519ACE61")
    public SIPDialog getDefaultDialog() {
SIPDialog var07DB6ED3B1EC8AA2EFC7D90D814BC07B_1424461629 =         this.defaultDialog;
        var07DB6ED3B1EC8AA2EFC7D90D814BC07B_1424461629.addTaint(taint);
        return var07DB6ED3B1EC8AA2EFC7D90D814BC07B_1424461629;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.113 -0400", hash_original_method = "BBF8312DD6859DF11BA280D3CE71F333", hash_generated_method = "92C54DFEBE82A33476818E16370481AA")
    public void setNextHop(Hop hop) {
        this.nextHop = hop;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.113 -0400", hash_original_method = "F8BB258224ADAD4254DDBC66AEC6C06F", hash_generated_method = "AE49BEEE15B5B0ACF595CA52F779798C")
    public Hop getNextHop() {
Hop var7E6D0C89CF2547AEC7B1741A7E613AB4_312760731 =         nextHop;
        var7E6D0C89CF2547AEC7B1741A7E613AB4_312760731.addTaint(taint);
        return var7E6D0C89CF2547AEC7B1741A7E613AB4_312760731;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.113 -0400", hash_original_method = "5A4A2DE6DA5EAFA8C9F9B9398CD98855", hash_generated_method = "77796E2667351045720A96FACE4561A1")
    public void setNotifyOnRetransmit(boolean notifyOnRetransmit) {
        this.notifyOnRetransmit = notifyOnRetransmit;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.114 -0400", hash_original_method = "27ED93829BD70EC80C4ABB0868670759", hash_generated_method = "4EFDC1ACDA544FCAE44E17B51A2D5C56")
    public boolean isNotifyOnRetransmit() {
        boolean varA6A57E5FB85DB2354843F5CFC0F10126_453490194 = (notifyOnRetransmit);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_259613249 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_259613249;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.114 -0400", hash_original_method = "E7190C5FA03F5363EA136DFEC0492C73", hash_generated_method = "A815816922C53FB5571D66EB4D353EEE")
    public void alertIfStillInCallingStateBy(int count) {
        this.timeoutIfStillInCallingState = true;
        this.callingStateTimeoutCount = count;
        
        
        
    }

    
    public class TransactionTimer extends SIPStackTimerTask {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.115 -0400", hash_original_method = "7764BAFD5C7951E95371726125E892CE", hash_generated_method = "33DB74724AFAD3CA3F59EFA77CA701E3")
        public  TransactionTimer() {
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.115 -0400", hash_original_method = "0968D865D1ED49C59C7D505E50E4DC62", hash_generated_method = "56E212B85E11A641E734CB49ACDBB9CC")
        protected void runTask() {
            SIPClientTransaction clientTransaction;
            SIPTransactionStack sipStack;
            clientTransaction = SIPClientTransaction.this;
            sipStack = clientTransaction.sipStack;
    if(clientTransaction.isTerminated())            
            {
    if(sipStack.isLoggingEnabled())                
                {
                    sipStack.getStackLogger().logDebug(
                            "removing  = " + clientTransaction + " isReliable "
                                    + clientTransaction.isReliable());
                } 
                sipStack.removeTransaction(clientTransaction);
                try 
                {
                    this.cancel();
                } 
                catch (IllegalStateException ex)
                {
    if(!sipStack.isAlive())                    
                    return;
                } 
    if((!sipStack.cacheClientConnections) && clientTransaction.isReliable())                
                {
                    int newUseCount = --clientTransaction.getMessageChannel().useCount;
    if(newUseCount <= 0)                    
                    {
                        TimerTask myTimer = new LingerTimer();
                        sipStack.getTimer().schedule(myTimer,
                                SIPTransactionStack.CONNECTION_LINGER_TIME * 1000);
                    } 
                } 
                else
                {
    if(sipStack.isLoggingEnabled() && clientTransaction.isReliable())                    
                    {
                        int useCount = clientTransaction.getMessageChannel().useCount;
    if(sipStack.isLoggingEnabled())                        
                        sipStack.getStackLogger().logDebug("Client Use Count = " + useCount);
                    } 
                } 
            } 
            else
            {
                clientTransaction.fireTimer();
            } 
            
            
        }

        
    }


    
}

