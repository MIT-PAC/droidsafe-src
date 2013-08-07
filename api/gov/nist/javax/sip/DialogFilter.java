package gov.nist.javax.sip;

// Droidsafe Imports
import droidsafe.annotations.*;
import gov.nist.core.InternalErrorHandler;
import gov.nist.javax.sip.address.SipUri;
import gov.nist.javax.sip.header.Contact;
import gov.nist.javax.sip.header.Event;
import gov.nist.javax.sip.header.ReferTo;
import gov.nist.javax.sip.header.RetryAfter;
import gov.nist.javax.sip.header.Route;
import gov.nist.javax.sip.header.RouteList;
import gov.nist.javax.sip.message.MessageFactoryImpl;
import gov.nist.javax.sip.message.SIPRequest;
import gov.nist.javax.sip.message.SIPResponse;
import gov.nist.javax.sip.stack.MessageChannel;
import gov.nist.javax.sip.stack.SIPClientTransaction;
import gov.nist.javax.sip.stack.SIPDialog;
import gov.nist.javax.sip.stack.SIPServerTransaction;
import gov.nist.javax.sip.stack.SIPTransaction;
import gov.nist.javax.sip.stack.ServerRequestInterface;
import gov.nist.javax.sip.stack.ServerResponseInterface;

import java.io.IOException;

import javax.sip.ClientTransaction;
import javax.sip.DialogState;
import javax.sip.RequestEvent;
import javax.sip.ServerTransaction;
import javax.sip.SipException;
import javax.sip.SipProvider;
import javax.sip.TransactionState;
import javax.sip.header.EventHeader;
import javax.sip.header.ReferToHeader;
import javax.sip.header.ServerHeader;
import javax.sip.message.Request;
import javax.sip.message.Response;






class DialogFilter implements ServerRequestInterface, ServerResponseInterface {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.297 -0400", hash_original_field = "7C7B65A13B3BC773CE866BFD592AC7E7", hash_generated_field = "B58F2862CC3FB933DFE2CD13D62E4F29")

    protected SIPTransaction transactionChannel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.297 -0400", hash_original_field = "8464C05A1C71DC453DF2370A527F688F", hash_generated_field = "39488158E1B35E48EDB34C41C325AC90")

    protected ListeningPointImpl listeningPoint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.297 -0400", hash_original_field = "37460D4BF2BA47A13FF9D922C4B14B2E", hash_generated_field = "B028268F85C87F49A0E45B93954BF938")

    private SipStackImpl sipStack;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.298 -0400", hash_original_method = "A91C8A8D71CBF898AE2C5B460693B699", hash_generated_method = "481B6844F1AF263D7835463CFF37158A")
    public  DialogFilter(SipStackImpl sipStack) {
        this.sipStack = sipStack;
        // ---------- Original Method ----------
        //this.sipStack = sipStack;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.298 -0400", hash_original_method = "07FCA8BF1CB05FED9E9EE5BE5B9D0DF8", hash_generated_method = "C2991BF5741F1BF5E19981744A53DAB0")
    private void sendRequestPendingResponse(SIPRequest sipRequest,
            SIPServerTransaction transaction) {
        addTaint(transaction.getTaint());
        addTaint(sipRequest.getTaint());
        SIPResponse sipResponse = sipRequest.createResponse(Response.REQUEST_PENDING);
        ServerHeader serverHeader = MessageFactoryImpl.getDefaultServerHeader();
        if(serverHeader != null)        
        {
            sipResponse.setHeader(serverHeader);
        } //End block
        try 
        {
            RetryAfter retryAfter = new RetryAfter();
            retryAfter.setRetryAfter(1);
            sipResponse.setHeader(retryAfter);
            if(sipRequest.getMethod().equals(Request.INVITE))            
            {
                sipStack.addTransactionPendingAck(transaction);
            } //End block
            transaction.sendResponse(sipResponse);
            transaction.releaseSem();
        } //End block
        catch (Exception ex)
        {
            sipStack.getStackLogger().logError("Problem sending error response", ex);
            transaction.releaseSem();
            sipStack.removeTransaction(transaction);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.299 -0400", hash_original_method = "C4ABF2148AD4585DF588E0AB365097FF", hash_generated_method = "3C45A442134062488CB3C1E5FEC61B20")
    private void sendBadRequestResponse(SIPRequest sipRequest, SIPServerTransaction transaction,
            String reasonPhrase) {
        addTaint(reasonPhrase.getTaint());
        addTaint(transaction.getTaint());
        addTaint(sipRequest.getTaint());
        SIPResponse sipResponse = sipRequest.createResponse(Response.BAD_REQUEST);
        if(reasonPhrase != null)        
        sipResponse.setReasonPhrase(reasonPhrase);
        ServerHeader serverHeader = MessageFactoryImpl.getDefaultServerHeader();
        if(serverHeader != null)        
        {
            sipResponse.setHeader(serverHeader);
        } //End block
        try 
        {
            if(sipRequest.getMethod().equals(Request.INVITE))            
            {
                sipStack.addTransactionPendingAck(transaction);
            } //End block
            transaction.sendResponse(sipResponse);
            transaction.releaseSem();
        } //End block
        catch (Exception ex)
        {
            sipStack.getStackLogger().logError("Problem sending error response", ex);
            transaction.releaseSem();
            sipStack.removeTransaction(transaction);
        } //End block
        // ---------- Original Method ----------
        //SIPResponse sipResponse = sipRequest.createResponse(Response.BAD_REQUEST);
        //if (reasonPhrase != null)
            //sipResponse.setReasonPhrase(reasonPhrase);
        //ServerHeader serverHeader = MessageFactoryImpl.getDefaultServerHeader();
        //if (serverHeader != null) {
            //sipResponse.setHeader(serverHeader);
        //}
        //try {
            //if (sipRequest.getMethod().equals(Request.INVITE)) {
                //sipStack.addTransactionPendingAck(transaction);
            //}
            //transaction.sendResponse(sipResponse);
            //transaction.releaseSem();
        //} catch (Exception ex) {
            //sipStack.getStackLogger().logError("Problem sending error response", ex);
            //transaction.releaseSem();
            //sipStack.removeTransaction(transaction);
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.299 -0400", hash_original_method = "D6292ED26CFFFD47381D5C093FDBF969", hash_generated_method = "8D842766B6A0D5FC56C70A65B0D3FEFC")
    private void sendCallOrTransactionDoesNotExistResponse(SIPRequest sipRequest,
            SIPServerTransaction transaction) {
        addTaint(transaction.getTaint());
        addTaint(sipRequest.getTaint());
        SIPResponse sipResponse = sipRequest
                .createResponse(Response.CALL_OR_TRANSACTION_DOES_NOT_EXIST);
        ServerHeader serverHeader = MessageFactoryImpl.getDefaultServerHeader();
        if(serverHeader != null)        
        {
            sipResponse.setHeader(serverHeader);
        } //End block
        try 
        {
            if(sipRequest.getMethod().equals(Request.INVITE))            
            {
                sipStack.addTransactionPendingAck(transaction);
            } //End block
            transaction.sendResponse(sipResponse);
            transaction.releaseSem();
        } //End block
        catch (Exception ex)
        {
            sipStack.getStackLogger().logError("Problem sending error response", ex);
            transaction.releaseSem();
            sipStack.removeTransaction(transaction);
        } //End block
        // ---------- Original Method ----------
        //SIPResponse sipResponse = sipRequest
                //.createResponse(Response.CALL_OR_TRANSACTION_DOES_NOT_EXIST);
        //ServerHeader serverHeader = MessageFactoryImpl.getDefaultServerHeader();
        //if (serverHeader != null) {
            //sipResponse.setHeader(serverHeader);
        //}
        //try {
            //if (sipRequest.getMethod().equals(Request.INVITE)) {
                //sipStack.addTransactionPendingAck(transaction);
            //}
            //transaction.sendResponse(sipResponse);
            //transaction.releaseSem();
        //} catch (Exception ex) {
            //sipStack.getStackLogger().logError("Problem sending error response", ex);
            //transaction.releaseSem();
            //sipStack.removeTransaction(transaction);
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.300 -0400", hash_original_method = "3FDF2D179E068B8AD4629A716A32BCF6", hash_generated_method = "7C3E3BB5D0AED9482BDC21A4564D35AF")
    private void sendLoopDetectedResponse(SIPRequest sipRequest, SIPServerTransaction transaction) {
        addTaint(transaction.getTaint());
        addTaint(sipRequest.getTaint());
        SIPResponse sipResponse = sipRequest.createResponse(Response.LOOP_DETECTED);
        ServerHeader serverHeader = MessageFactoryImpl.getDefaultServerHeader();
        if(serverHeader != null)        
        {
            sipResponse.setHeader(serverHeader);
        } //End block
        try 
        {
            sipStack.addTransactionPendingAck(transaction);
            transaction.sendResponse(sipResponse);
            transaction.releaseSem();
        } //End block
        catch (Exception ex)
        {
            sipStack.getStackLogger().logError("Problem sending error response", ex);
            transaction.releaseSem();
            sipStack.removeTransaction(transaction);
        } //End block
        // ---------- Original Method ----------
        //SIPResponse sipResponse = sipRequest.createResponse(Response.LOOP_DETECTED);
        //ServerHeader serverHeader = MessageFactoryImpl.getDefaultServerHeader();
        //if (serverHeader != null) {
            //sipResponse.setHeader(serverHeader);
        //}
        //try {
            //sipStack.addTransactionPendingAck(transaction);
            //transaction.sendResponse(sipResponse);
            //transaction.releaseSem();
        //} catch (Exception ex) {
            //sipStack.getStackLogger().logError("Problem sending error response", ex);
            //transaction.releaseSem();
            //sipStack.removeTransaction(transaction);
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.301 -0400", hash_original_method = "1BAB8A1EF49695D9BD2CE878014B3A7C", hash_generated_method = "427025AD73609E2016D48BA2C79DE31D")
    private void sendServerInternalErrorResponse(SIPRequest sipRequest,
            SIPServerTransaction transaction) {
        addTaint(transaction.getTaint());
        addTaint(sipRequest.getTaint());
        if(sipStack.isLoggingEnabled())        
        sipStack.getStackLogger()
                    .logDebug("Sending 500 response for out of sequence message");
        SIPResponse sipResponse = sipRequest.createResponse(Response.SERVER_INTERNAL_ERROR);
        sipResponse.setReasonPhrase("Request out of order");
        if(MessageFactoryImpl.getDefaultServerHeader() != null)        
        {
            ServerHeader serverHeader = MessageFactoryImpl.getDefaultServerHeader();
            sipResponse.setHeader(serverHeader);
        } //End block
        try 
        {
            RetryAfter retryAfter = new RetryAfter();
            retryAfter.setRetryAfter(10);
            sipResponse.setHeader(retryAfter);
            sipStack.addTransactionPendingAck(transaction);
            transaction.sendResponse(sipResponse);
            transaction.releaseSem();
        } //End block
        catch (Exception ex)
        {
            sipStack.getStackLogger().logError("Problem sending response", ex);
            transaction.releaseSem();
            sipStack.removeTransaction(transaction);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.311 -0400", hash_original_method = "358FFD6F817CCE2A8A6AEFD88EADC0D0", hash_generated_method = "50225232CD8E4D82B588863A1CBEF5FE")
    public void processRequest(SIPRequest sipRequest, MessageChannel incomingMessageChannel) {
        addTaint(incomingMessageChannel.getTaint());
        addTaint(sipRequest.getTaint());
        if(sipStack.isLoggingEnabled())        
        sipStack.getStackLogger().logDebug(
                    "PROCESSING INCOMING REQUEST " + sipRequest + " transactionChannel = "
                            + transactionChannel + " listening point = "
                            + listeningPoint.getIPAddress() + ":" + listeningPoint.getPort());
        if(listeningPoint == null)        
        {
            if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger().logDebug(
                        "Dropping message: No listening point registered!");
            return;
        } //End block
        SipStackImpl sipStack = (SipStackImpl) transactionChannel.getSIPStack();
        SipProviderImpl sipProvider = listeningPoint.getProvider();
        if(sipProvider == null)        
        {
            if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger().logDebug("No provider - dropping !!");
            return;
        } //End block
        if(sipStack == null)        
        InternalErrorHandler.handleException("Egads! no sip stack!");
        SIPServerTransaction transaction = (SIPServerTransaction) this.transactionChannel;
        if(transaction != null)        
        {
            if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger().logDebug(
                        "transaction state = " + transaction.getState());
        } //End block
        String dialogId = sipRequest.getDialogId(true);
        SIPDialog dialog = sipStack.getDialog(dialogId);
        if(dialog != null && sipProvider != dialog.getSipProvider())        
        {
            Contact contact = dialog.getMyContactHeader();
            if(contact != null)            
            {
                SipUri contactUri = (SipUri) (contact.getAddress().getURI());
                String ipAddress = contactUri.getHost();
                int contactPort = contactUri.getPort();
                String contactTransport = contactUri.getTransportParam();
                if(contactTransport == null)                
                contactTransport = "udp";
                if(contactPort == -1)                
                {
                    if(contactTransport.equals("udp") || contactTransport.equals("tcp"))                    
                    contactPort = 5060;
                    else
                    contactPort = 5061;
                } //End block
                if(ipAddress != null
                        && (!ipAddress.equals(listeningPoint.getIPAddress()) || contactPort != listeningPoint
                                .getPort()))                
                {
                    if(sipStack.isLoggingEnabled())                    
                    {
                        sipStack.getStackLogger().logDebug(
                                "nulling dialog -- listening point mismatch!  " + contactPort
                                        + "  lp port = " + listeningPoint.getPort());
                    } //End block
                    dialog = null;
                } //End block
            } //End block
        } //End block
        if(sipProvider.isAutomaticDialogSupportEnabled()
                && sipProvider.isDialogErrorsAutomaticallyHandled()
                && sipRequest.getToTag() == null)        
        {
            SIPServerTransaction sipServerTransaction = sipStack
                    .findMergedTransaction(sipRequest);
            if(sipServerTransaction != null)            
            {
                this.sendLoopDetectedResponse(sipRequest, transaction);
                return;
            } //End block
        } //End block
        if(sipStack.isLoggingEnabled())        
        {
            sipStack.getStackLogger().logDebug("dialogId = " + dialogId);
            sipStack.getStackLogger().logDebug("dialog = " + dialog);
        } //End block
        if(sipRequest.getHeader(Route.NAME) != null && transaction.getDialog() != null)        
        {
            RouteList routes = sipRequest.getRouteHeaders();
            Route route = (Route) routes.getFirst();
            SipUri uri = (SipUri) route.getAddress().getURI();
            int port;
            if(uri.getHostPort().hasPort())            
            {
                port = uri.getHostPort().getPort();
            } //End block
            else
            {
                if(listeningPoint.getTransport().equalsIgnoreCase("TLS"))                
                port = 5061;
                else
                port = 5060;
            } //End block
            String host = uri.getHost();
            if((host.equals(listeningPoint.getIPAddress()) || host
                    .equalsIgnoreCase(listeningPoint.getSentBy()))
                    && port == listeningPoint.getPort())            
            {
                if(routes.size() == 1)                
                sipRequest.removeHeader(Route.NAME);
                else
                routes.removeFirst();
            } //End block
        } //End block
        if(sipRequest.getMethod().equals(Request.REFER) && dialog != null
                && sipProvider.isDialogErrorsAutomaticallyHandled())        
        {
            ReferToHeader sipHeader = (ReferToHeader) sipRequest.getHeader(ReferTo.NAME);
            if(sipHeader == null)            
            {
                this
                        .sendBadRequestResponse(sipRequest, transaction,
                                "Refer-To header is missing");
                return;
            } //End block
            SIPTransaction lastTransaction = ((SIPDialog) dialog).getLastTransaction();
            if(lastTransaction != null  && sipProvider.isDialogErrorsAutomaticallyHandled())            
            {
                SIPRequest lastRequest = (SIPRequest) lastTransaction.getRequest();
                if(lastTransaction instanceof SIPServerTransaction)                
                {
                    if(!((SIPDialog) dialog).isAckSeen()   
                            && lastRequest.getMethod().equals(Request.INVITE))                    
                    {
                        this.sendRequestPendingResponse(sipRequest, transaction);
                        return;
                    } //End block
                } //End block
                else
                if(lastTransaction instanceof SIPClientTransaction)                
                {
                    long cseqno = lastRequest.getCSeqHeader().getSeqNumber();
                    String method = lastRequest.getMethod();
                    if(method.equals(Request.INVITE) && !dialog.isAckSent(cseqno))                    
                    {
                        this.sendRequestPendingResponse(sipRequest, transaction);
                        return;
                    } //End block
                } //End block
            } //End block
        } //End block
        else
        if(sipRequest.getMethod().equals(Request.UPDATE))        
        {
            if(sipProvider.isAutomaticDialogSupportEnabled() && dialog == null)            
            {
                this.sendCallOrTransactionDoesNotExistResponse(sipRequest, transaction);
                return;
            } //End block
        } //End block
        else
        if(sipRequest.getMethod().equals(Request.ACK))        
        {
            if(transaction != null && transaction.isInviteTransaction())            
            {
                if(sipStack.isLoggingEnabled())                
                sipStack.getStackLogger().logDebug("Processing ACK for INVITE Tx ");
            } //End block
            else
            {
                if(sipStack.isLoggingEnabled())                
                sipStack.getStackLogger().logDebug("Processing ACK for dialog " + dialog);
                if(dialog == null)                
                {
                    if(sipStack.isLoggingEnabled())                    
                    {
                        sipStack.getStackLogger().logDebug(
                                "Dialog does not exist " + sipRequest.getFirstLine()
                                        + " isServerTransaction = " + true);
                    } //End block
                    SIPServerTransaction st = sipStack
                            .getRetransmissionAlertTransaction(dialogId);
                    if(st != null && st.isRetransmissionAlertEnabled())                    
                    {
                        st.disableRetransmissionAlerts();
                    } //End block
                    SIPServerTransaction ackTransaction = sipStack
                            .findTransactionPendingAck(sipRequest);
                    if(ackTransaction != null)                    
                    {
                        if(sipStack.isLoggingEnabled())                        
                        sipStack.getStackLogger().logDebug("Found Tx pending ACK");
                        try 
                        {
                            ackTransaction.setAckSeen();
                            sipStack.removeTransaction(ackTransaction);
                            sipStack.removeTransactionPendingAck(ackTransaction);
                        } //End block
                        catch (Exception ex)
                        {
                            if(sipStack.isLoggingEnabled())                            
                            {
                                sipStack.getStackLogger().logError(
                                        "Problem terminating transaction", ex);
                            } //End block
                        } //End block
                        return;
                    } //End block
                } //End block
                else
                {
                    if(!dialog.handleAck(transaction))                    
                    {
                        if(!dialog.isSequnceNumberValidation())                        
                        {
                            if(sipStack.isLoggingEnabled())                            
                            {
                                sipStack.getStackLogger().logDebug(
                                        "Dialog exists with loose dialog validation "
                                                + sipRequest.getFirstLine()
                                                + " isServerTransaction = " + true + " dialog = "
                                                + dialog.getDialogId());
                            } //End block
                            SIPServerTransaction st = sipStack
                                    .getRetransmissionAlertTransaction(dialogId);
                            if(st != null && st.isRetransmissionAlertEnabled())                            
                            {
                                st.disableRetransmissionAlerts();
                            } //End block
                        } //End block
                        else
                        {
                            if(sipStack.isLoggingEnabled())                            
                            {
                                sipStack.getStackLogger().logDebug(
                                        "Dropping ACK - cannot find a transaction or dialog");
                            } //End block
                            SIPServerTransaction ackTransaction = sipStack
                                    .findTransactionPendingAck(sipRequest);
                            if(ackTransaction != null)                            
                            {
                                if(sipStack.isLoggingEnabled())                                
                                sipStack.getStackLogger().logDebug("Found Tx pending ACK");
                                try 
                                {
                                    ackTransaction.setAckSeen();
                                    sipStack.removeTransaction(ackTransaction);
                                    sipStack.removeTransactionPendingAck(ackTransaction);
                                } //End block
                                catch (Exception ex)
                                {
                                    if(sipStack.isLoggingEnabled())                                    
                                    {
                                        sipStack.getStackLogger().logError(
                                                "Problem terminating transaction", ex);
                                    } //End block
                                } //End block
                            } //End block
                            return;
                        } //End block
                    } //End block
                    else
                    {
                        transaction.passToListener();
                        dialog.addTransaction(transaction);
                        dialog.addRoute(sipRequest);
                        transaction.setDialog(dialog, dialogId);
                        if(sipRequest.getMethod().equals(Request.INVITE)
                                && sipProvider.isDialogErrorsAutomaticallyHandled())                        
                        {
                            sipStack.putInMergeTable(transaction, sipRequest);
                        } //End block
                        if(sipStack.deliverTerminatedEventForAck)                        
                        {
                            try 
                            {
                                sipStack.addTransaction(transaction);
                                transaction.scheduleAckRemoval();
                            } //End block
                            catch (IOException ex)
                            {
                            } //End block
                        } //End block
                        else
                        {
                            transaction.setMapped(true);
                        } //End block
                    } //End block
                } //End block
            } //End block
        } //End block
        else
        if(sipRequest.getMethod().equals(Request.PRACK))        
        {
            if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger().logDebug("Processing PRACK for dialog " + dialog);
            if(dialog == null && sipProvider.isAutomaticDialogSupportEnabled())            
            {
                if(sipStack.isLoggingEnabled())                
                {
                    sipStack.getStackLogger().logDebug(
                            "Dialog does not exist " + sipRequest.getFirstLine()
                                    + " isServerTransaction = " + true);
                } //End block
                if(sipStack.isLoggingEnabled())                
                {
                    sipStack
                            .getStackLogger()
                            .logDebug(
                                    "Sending 481 for PRACK - automatic dialog support is enabled -- cant find dialog!");
                } //End block
                SIPResponse notExist = sipRequest
                        .createResponse(Response.CALL_OR_TRANSACTION_DOES_NOT_EXIST);
                try 
                {
                    sipProvider.sendResponse(notExist);
                } //End block
                catch (SipException e)
                {
                    sipStack.getStackLogger().logError("error sending response", e);
                } //End block
                if(transaction != null)                
                {
                    sipStack.removeTransaction(transaction);
                    transaction.releaseSem();
                } //End block
                return;
            } //End block
            else
            if(dialog != null)            
            {
                if(!dialog.handlePrack(sipRequest))                
                {
                    if(sipStack.isLoggingEnabled())                    
                    sipStack.getStackLogger().logDebug("Dropping out of sequence PRACK ");
                    if(transaction != null)                    
                    {
                        sipStack.removeTransaction(transaction);
                        transaction.releaseSem();
                    } //End block
                    return;
                } //End block
                else
                {
                    try 
                    {
                        sipStack.addTransaction(transaction);
                        dialog.addTransaction(transaction);
                        dialog.addRoute(sipRequest);
                        transaction.setDialog(dialog, dialogId);
                    } //End block
                    catch (Exception ex)
                    {
                        InternalErrorHandler.handleException(ex);
                    } //End block
                } //End block
            } //End block
            else
            {
                if(sipStack.isLoggingEnabled())                
                sipStack.getStackLogger().logDebug(
                            "Processing PRACK without a DIALOG -- this must be a proxy element");
            } //End block
        } //End block
        else
        if(sipRequest.getMethod().equals(Request.BYE))        
        {
            if(dialog != null && !dialog.isRequestConsumable(sipRequest))            
            {
                if(sipStack.isLoggingEnabled())                
                sipStack.getStackLogger().logDebug(
                            "Dropping out of sequence BYE " + dialog.getRemoteSeqNumber() + " "
                                    + sipRequest.getCSeq().getSeqNumber());
                if(dialog.getRemoteSeqNumber() >= sipRequest.getCSeq().getSeqNumber()
                        && transaction.getState() == TransactionState.TRYING)                
                {
                    this.sendServerInternalErrorResponse(sipRequest, transaction);
                } //End block
                if(transaction != null)                
                sipStack.removeTransaction(transaction);
                return;
            } //End block
            else
            if(dialog == null && sipProvider.isAutomaticDialogSupportEnabled())            
            {
                SIPResponse response = sipRequest
                        .createResponse(Response.CALL_OR_TRANSACTION_DOES_NOT_EXIST);
                response.setReasonPhrase("Dialog Not Found");
                if(sipStack.isLoggingEnabled())                
                sipStack.getStackLogger().logDebug(
                            "dropping request -- automatic dialog "
                                    + "support enabled and dialog does not exist!");
                try 
                {
                    transaction.sendResponse(response);
                } //End block
                catch (SipException ex)
                {
                    sipStack.getStackLogger().logError("Error in sending response", ex);
                } //End block
                if(transaction != null)                
                {
                    sipStack.removeTransaction(transaction);
                    transaction.releaseSem();
                    transaction = null;
                } //End block
                return;
            } //End block
            if(transaction != null && dialog != null)            
            {
                try 
                {
                    if(sipProvider == dialog.getSipProvider())                    
                    {
                        sipStack.addTransaction(transaction);
                        dialog.addTransaction(transaction);
                        transaction.setDialog(dialog, dialogId);
                    } //End block
                } //End block
                catch (IOException ex)
                {
                    InternalErrorHandler.handleException(ex);
                } //End block
            } //End block
            if(sipStack.isLoggingEnabled())            
            {
                sipStack.getStackLogger().logDebug(
                        "BYE Tx = " + transaction + " isMapped ="
                                + transaction.isTransactionMapped());
            } //End block
        } //End block
        else
        if(sipRequest.getMethod().equals(Request.CANCEL))        
        {
            SIPServerTransaction st = (SIPServerTransaction) sipStack.findCancelTransaction(
                    sipRequest, true);
            if(sipStack.isLoggingEnabled())            
            {
                sipStack.getStackLogger().logDebug(
                        "Got a CANCEL, InviteServerTx = " + st + " cancel Server Tx ID = "
                                + transaction + " isMapped = "
                                + transaction.isTransactionMapped());
            } //End block
            if(sipRequest.getMethod().equals(Request.CANCEL))            
            {
                if(st != null && st.getState() == SIPTransaction.TERMINATED_STATE)                
                {
                    if(sipStack.isLoggingEnabled())                    
                    sipStack.getStackLogger().logDebug("Too late to cancel Transaction");
                    try 
                    {
                        transaction.sendResponse(sipRequest.createResponse(Response.OK));
                    } //End block
                    catch (Exception ex)
                    {
                        if(ex.getCause() != null && ex.getCause() instanceof IOException)                        
                        {
                            st.raiseIOExceptionEvent();
                        } //End block
                    } //End block
                    return;
                } //End block
                if(sipStack.isLoggingEnabled())                
                sipStack.getStackLogger().logDebug("Cancel transaction = " + st);
            } //End block
            if(transaction != null && st != null && st.getDialog() != null)            
            {
                transaction.setDialog((SIPDialog) st.getDialog(), dialogId);
                dialog = (SIPDialog) st.getDialog();
            } //End block
            else
            if(st == null && sipProvider.isAutomaticDialogSupportEnabled()
                    && transaction != null)            
            {
                SIPResponse response = sipRequest
                        .createResponse(Response.CALL_OR_TRANSACTION_DOES_NOT_EXIST);
                if(sipStack.isLoggingEnabled())                
                {
                    sipStack.getStackLogger().logDebug(
                            "dropping request -- automatic dialog support "
                                    + "enabled and INVITE ST does not exist!");
                } //End block
                try 
                {
                    sipProvider.sendResponse(response);
                } //End block
                catch (SipException ex)
                {
                    InternalErrorHandler.handleException(ex);
                } //End block
                if(transaction != null)                
                {
                    sipStack.removeTransaction(transaction);
                    transaction.releaseSem();
                } //End block
                return;
            } //End block
            if(st != null)            
            {
                try 
                {
                    if(transaction != null)                    
                    {
                        sipStack.addTransaction(transaction);
                        transaction.setPassToListener();
                        transaction.setInviteTransaction(st);
                        st.acquireSem();
                    } //End block
                } //End block
                catch (Exception ex)
                {
                    InternalErrorHandler.handleException(ex);
                } //End block
            } //End block
        } //End block
        else
        if(sipRequest.getMethod().equals(Request.INVITE))        
        {
            SIPTransaction lastTransaction = dialog == null ? null : dialog
                    .getInviteTransaction();
            if(dialog != null && transaction != null && lastTransaction != null
                    && sipRequest.getCSeq().getSeqNumber() > dialog.getRemoteSeqNumber()
                    && lastTransaction instanceof SIPServerTransaction
                    && sipProvider.isDialogErrorsAutomaticallyHandled()
                    && dialog.isSequnceNumberValidation()
                    && lastTransaction.isInviteTransaction()
                    && lastTransaction.getState() != TransactionState.COMPLETED
                    && lastTransaction.getState() != TransactionState.TERMINATED
                    && lastTransaction.getState() != TransactionState.CONFIRMED)            
            {
                if(sipStack.isLoggingEnabled())                
                {
                    sipStack.getStackLogger().logDebug(
                            "Sending 500 response for out of sequence message");
                } //End block
                this.sendServerInternalErrorResponse(sipRequest, transaction);
                return;
            } //End block
            lastTransaction = (dialog == null ? null : dialog.getLastTransaction());
            if(dialog != null
                    && sipProvider.isDialogErrorsAutomaticallyHandled()
                    && lastTransaction != null
                    && lastTransaction.isInviteTransaction()
                    && lastTransaction instanceof ClientTransaction
                    && lastTransaction.getLastResponse() != null
                    && lastTransaction.getLastResponse().getStatusCode() == 200
                    && !dialog.isAckSent(lastTransaction.getLastResponse().getCSeq()
                            .getSeqNumber()))            
            {
                if(sipStack.isLoggingEnabled())                
                {
                    sipStack.getStackLogger().logDebug(
                            "Sending 491 response for client Dialog ACK not sent.");
                } //End block
                this.sendRequestPendingResponse(sipRequest, transaction);
                return;
            } //End block
            if(dialog != null && lastTransaction != null
                    && sipProvider.isDialogErrorsAutomaticallyHandled()
                    && lastTransaction.isInviteTransaction()
                    && lastTransaction instanceof ServerTransaction && !dialog.isAckSeen())            
            {
                if(sipStack.isLoggingEnabled())                
                {
                    sipStack.getStackLogger().logDebug(
                            "Sending 491 response for server Dialog ACK not seen.");
                } //End block
                this.sendRequestPendingResponse(sipRequest, transaction);
                return;
            } //End block
        } //End block
        if(sipStack.isLoggingEnabled())        
        {
            sipStack.getStackLogger().logDebug(
                    "CHECK FOR OUT OF SEQ MESSAGE " + dialog + " transaction " + transaction);
        } //End block
        if(dialog != null && transaction != null && !sipRequest.getMethod().equals(Request.BYE)
                && !sipRequest.getMethod().equals(Request.CANCEL)
                && !sipRequest.getMethod().equals(Request.ACK)
                && !sipRequest.getMethod().equals(Request.PRACK))        
        {
            if(!dialog.isRequestConsumable(sipRequest))            
            {
                if(sipStack.isLoggingEnabled())                
                {
                    sipStack.getStackLogger().logDebug(
                            "Dropping out of sequence message " + dialog.getRemoteSeqNumber()
                                    + " " + sipRequest.getCSeq());
                } //End block
                if(dialog.getRemoteSeqNumber() >= sipRequest.getCSeq().getSeqNumber()
                        && sipProvider.isDialogErrorsAutomaticallyHandled()
                        && (transaction.getState() == TransactionState.TRYING || transaction
                                .getState() == TransactionState.PROCEEDING))                
                {
                    this.sendServerInternalErrorResponse(sipRequest, transaction);
                } //End block
                return;
            } //End block
            try 
            {
                if(sipProvider == dialog.getSipProvider())                
                {
                    sipStack.addTransaction(transaction);
                    dialog.addTransaction(transaction);
                    dialog.addRoute(sipRequest);
                    transaction.setDialog(dialog, dialogId);
                } //End block
            } //End block
            catch (IOException ex)
            {
                transaction.raiseIOExceptionEvent();
                sipStack.removeTransaction(transaction);
                return;
            } //End block
        } //End block
        RequestEvent sipEvent;
        if(sipStack.isLoggingEnabled())        
        {
            sipStack.getStackLogger().logDebug(
                    sipRequest.getMethod() + " transaction.isMapped = "
                            + transaction.isTransactionMapped());
        } //End block
        if(dialog == null && sipRequest.getMethod().equals(Request.NOTIFY))        
        {
            SIPClientTransaction pendingSubscribeClientTx = sipStack.findSubscribeTransaction(
                    sipRequest, listeningPoint);
            if(sipStack.isLoggingEnabled())            
            {
                sipStack.getStackLogger().logDebug(
                        "PROCESSING NOTIFY  DIALOG == null " + pendingSubscribeClientTx);
            } //End block
            if(sipProvider.isAutomaticDialogSupportEnabled() && pendingSubscribeClientTx == null
                    && !sipStack.deliverUnsolicitedNotify)            
            {
                try 
                {
                    if(sipStack.isLoggingEnabled())                    
                    {
                        sipStack.getStackLogger().logDebug(
                                "Could not find Subscription for Notify Tx.");
                    } //End block
                    Response errorResponse = sipRequest
                            .createResponse(Response.CALL_OR_TRANSACTION_DOES_NOT_EXIST);
                    errorResponse.setReasonPhrase("Subscription does not exist");
                    sipProvider.sendResponse(errorResponse);
                    return;
                } //End block
                catch (Exception ex)
                {
                    sipStack.getStackLogger().logError(
                            "Exception while sending error response statelessly", ex);
                    return;
                } //End block
            } //End block
            if(pendingSubscribeClientTx != null)            
            {
                transaction.setPendingSubscribe(pendingSubscribeClientTx);
                SIPDialog subscriptionDialog = (SIPDialog) pendingSubscribeClientTx
                        .getDefaultDialog();
                if(subscriptionDialog == null || subscriptionDialog.getDialogId() == null
                        || !subscriptionDialog.getDialogId().equals(dialogId))                
                {
                    if(subscriptionDialog != null && subscriptionDialog.getDialogId() == null)                    
                    {
                        subscriptionDialog.setDialogId(dialogId);
                    } //End block
                    else
                    {
                        subscriptionDialog = pendingSubscribeClientTx.getDialog(dialogId);
                    } //End block
                    if(sipStack.isLoggingEnabled())                    
                    {
                        sipStack.getStackLogger().logDebug(
                                "PROCESSING NOTIFY Subscribe DIALOG " + subscriptionDialog);
                    } //End block
                    if(subscriptionDialog == null
                            && (sipProvider.isAutomaticDialogSupportEnabled() || pendingSubscribeClientTx
                                    .getDefaultDialog() != null))                    
                    {
                        Event event = (Event) sipRequest.getHeader(EventHeader.NAME);
                        if(sipStack.isEventForked(event.getEventType()))                        
                        {
                            subscriptionDialog = SIPDialog.createFromNOTIFY(
                                    pendingSubscribeClientTx, transaction);
                        } //End block
                    } //End block
                    if(subscriptionDialog != null)                    
                    {
                        transaction.setDialog(subscriptionDialog, dialogId);
                        subscriptionDialog.setState(DialogState.CONFIRMED.getValue());
                        sipStack.putDialog(subscriptionDialog);
                        pendingSubscribeClientTx.setDialog(subscriptionDialog, dialogId);
                        if(!transaction.isTransactionMapped())                        
                        {
                            this.sipStack.mapTransaction(transaction);
                            transaction.setPassToListener();
                            try 
                            {
                                this.sipStack.addTransaction(transaction);
                            } //End block
                            catch (Exception ex)
                            {
                            } //End block
                        } //End block
                    } //End block
                } //End block
                else
                {
                    transaction.setDialog(subscriptionDialog, dialogId);
                    dialog = subscriptionDialog;
                    if(!transaction.isTransactionMapped())                    
                    {
                        this.sipStack.mapTransaction(transaction);
                        transaction.setPassToListener();
                        try 
                        {
                            this.sipStack.addTransaction(transaction);
                        } //End block
                        catch (Exception ex)
                        {
                        } //End block
                    } //End block
                    sipStack.putDialog(subscriptionDialog);
                    if(pendingSubscribeClientTx != null)                    
                    {
                        subscriptionDialog.addTransaction(pendingSubscribeClientTx);
                        pendingSubscribeClientTx.setDialog(subscriptionDialog, dialogId);
                    } //End block
                } //End block
                if(transaction != null
                        && ((SIPServerTransaction) transaction).isTransactionMapped())                
                {
                    sipEvent = new RequestEvent((SipProvider) sipProvider,
                            (ServerTransaction) transaction, subscriptionDialog,
                            (Request) sipRequest);
                } //End block
                else
                {
                    sipEvent = new RequestEvent((SipProvider) sipProvider, null,
                            subscriptionDialog, (Request) sipRequest);
                } //End block
            } //End block
            else
            {
                if(sipStack.isLoggingEnabled())                
                {
                    sipStack.getStackLogger().logDebug("could not find subscribe tx");
                } //End block
                sipEvent = new RequestEvent(sipProvider, null, null, (Request) sipRequest);
            } //End block
        } //End block
        else
        {
            if(transaction != null
                    && (((SIPServerTransaction) transaction).isTransactionMapped()))            
            {
                sipEvent = new RequestEvent(sipProvider, (ServerTransaction) transaction, dialog,
                        (Request) sipRequest);
            } //End block
            else
            {
                sipEvent = new RequestEvent(sipProvider, null, dialog, (Request) sipRequest);
            } //End block
        } //End block
        sipProvider.handleEvent(sipEvent, transaction);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.320 -0400", hash_original_method = "4FD6D5D7FFBD58CDE4927F751F9B55A3", hash_generated_method = "CD0A10724738E10435A8F9733300C81A")
    public void processResponse(SIPResponse response, MessageChannel incomingMessageChannel,
            SIPDialog dialog) {
        addTaint(dialog.getTaint());
        addTaint(incomingMessageChannel.getTaint());
        addTaint(response.getTaint());
        if(sipStack.isLoggingEnabled())        
        {
            sipStack.getStackLogger().logDebug(
                    "PROCESSING INCOMING RESPONSE" + response.encodeMessage());
        } //End block
        if(listeningPoint == null)        
        {
            if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger().logError(
                        "Dropping message: No listening point" + " registered!");
            return;
        } //End block
        if(sipStack.checkBranchId() && !Utils.getInstance().responseBelongsToUs(response))        
        {
            if(sipStack.isLoggingEnabled())            
            {
                sipStack
                        .getStackLogger()
                        .logError(
                                "Dropping response - topmost VIA header does not originate from this stack");
            } //End block
            return;
        } //End block
        SipProviderImpl sipProvider = listeningPoint.getProvider();
        if(sipProvider == null)        
        {
            if(sipStack.isLoggingEnabled())            
            {
                sipStack.getStackLogger().logError("Dropping message:  no provider");
            } //End block
            return;
        } //End block
        if(sipProvider.getSipListener() == null)        
        {
            if(sipStack.isLoggingEnabled())            
            {
                sipStack.getStackLogger().logError("No listener -- dropping response!");
            } //End block
            return;
        } //End block
        SIPClientTransaction transaction = (SIPClientTransaction) this.transactionChannel;
        SipStackImpl sipStackImpl = sipProvider.sipStack;
        if(sipStack.isLoggingEnabled())        
        {
            sipStackImpl.getStackLogger().logDebug("Transaction = " + transaction);
        } //End block
        if(transaction == null)        
        {
            if(dialog != null)            
            {
                if(response.getStatusCode() / 100 != 2)                
                {
                    if(sipStack.isLoggingEnabled())                    
                    {
                        sipStack
                                .getStackLogger()
                                .logDebug(
                                        "Response is not a final response and dialog is found for response -- dropping response!");
                    } //End block
                    return;
                } //End block
                else
                if(dialog.getState() == DialogState.TERMINATED)                
                {
                    if(sipStack.isLoggingEnabled())                    
                    {
                        sipStack.getStackLogger().logDebug(
                                "Dialog is terminated -- dropping response!");
                    } //End block
                    return;
                } //End block
                else
                {
                    boolean ackAlreadySent = false;
                    if(dialog.isAckSeen() && dialog.getLastAckSent() != null)                    
                    {
                        if(dialog.getLastAckSent().getCSeq().getSeqNumber() == response
                                .getCSeq().getSeqNumber())                        
                        {
                            ackAlreadySent = true;
                        } //End block
                    } //End block
                    if(ackAlreadySent
                            && response.getCSeq().getMethod().equals(dialog.getMethod()))                    
                    {
                        try 
                        {
                            if(sipStack.isLoggingEnabled())                            
                            {
                                sipStack.getStackLogger().logDebug(
                                        "Retransmission of OK detected: Resending last ACK");
                            } //End block
                            dialog.resendAck();
                            return;
                        } //End block
                        catch (SipException ex)
                        {
                            sipStack.getStackLogger().logError("could not resend ack", ex);
                        } //End block
                    } //End block
                } //End block
            } //End block
            if(sipStack.isLoggingEnabled())            
            {
                sipStack.getStackLogger().logDebug(
                        "could not find tx, handling statelessly Dialog =  " + dialog);
            } //End block
            ResponseEventExt sipEvent = new ResponseEventExt(sipProvider, transaction, dialog,
                    (Response) response);
            if(response.getCSeqHeader().getMethod().equals(Request.INVITE))            
            {
                SIPClientTransaction forked = this.sipStack.getForkedTransaction(response
                        .getTransactionId());
                sipEvent.setOriginalTransaction(forked);
            } //End block
            sipProvider.handleEvent(sipEvent, transaction);
            return;
        } //End block
        ResponseEventExt responseEvent = null;
        responseEvent = new ResponseEventExt(sipProvider, (ClientTransactionExt) transaction,
                dialog, (Response) response);
        if(response.getCSeqHeader().getMethod().equals(Request.INVITE))        
        {
            SIPClientTransaction forked = this.sipStack.getForkedTransaction(response
                    .getTransactionId());
            responseEvent.setOriginalTransaction(forked);
        } //End block
        if(dialog != null && response.getStatusCode() != 100)        
        {
            dialog.setLastResponse(transaction, response);
            transaction.setDialog(dialog, dialog.getDialogId());
        } //End block
        sipProvider.handleEvent(responseEvent, transaction);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.320 -0400", hash_original_method = "45F8896428832201E8BC8983A22C5151", hash_generated_method = "CBBA15DFB3797A83E68887E861DCF330")
    public String getProcessingInfo() {
String var540C13E9E156B687226421B24F2DF178_1092383572 =         null;
        var540C13E9E156B687226421B24F2DF178_1092383572.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1092383572;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.322 -0400", hash_original_method = "913AD64E566DC17432B7074017A68B2C", hash_generated_method = "90926C2FE27D0BC76E18BF4CA1C0EE79")
    public void processResponse(SIPResponse sipResponse, MessageChannel incomingChannel) {
        addTaint(incomingChannel.getTaint());
        addTaint(sipResponse.getTaint());
        String dialogID = sipResponse.getDialogId(false);
        SIPDialog sipDialog = this.sipStack.getDialog(dialogID);
        String method = sipResponse.getCSeq().getMethod();
        if(sipStack.isLoggingEnabled())        
        {
            sipStack.getStackLogger().logDebug(
                    "PROCESSING INCOMING RESPONSE: " + sipResponse.encodeMessage());
        } //End block
        if(sipStack.checkBranchId() && !Utils.getInstance().responseBelongsToUs(sipResponse))        
        {
            if(sipStack.isLoggingEnabled())            
            {
                sipStack.getStackLogger().logError("Detected stray response -- dropping");
            } //End block
            return;
        } //End block
        if(listeningPoint == null)        
        {
            if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger().logDebug(
                        "Dropping message: No listening point" + " registered!");
            return;
        } //End block
        SipProviderImpl sipProvider = listeningPoint.getProvider();
        if(sipProvider == null)        
        {
            if(sipStack.isLoggingEnabled())            
            {
                sipStack.getStackLogger().logDebug("Dropping message:  no provider");
            } //End block
            return;
        } //End block
        if(sipProvider.getSipListener() == null)        
        {
            if(sipStack.isLoggingEnabled())            
            {
                sipStack.getStackLogger().logDebug(
                        "Dropping message:  no sipListener registered!");
            } //End block
            return;
        } //End block
        SIPClientTransaction transaction = (SIPClientTransaction) this.transactionChannel;
        if(sipDialog == null && transaction != null)        
        {
            sipDialog = transaction.getDialog(dialogID);
            if(sipDialog != null && sipDialog.getState() == DialogState.TERMINATED)            
            sipDialog = null;
        } //End block
        if(sipStack.isLoggingEnabled())        
        sipStack.getStackLogger().logDebug(
                    "Transaction = " + transaction + " sipDialog = " + sipDialog);
        if(this.transactionChannel != null)        
        {
            String originalFrom = ((SIPRequest) this.transactionChannel.getRequest())
                    .getFromTag();
            if(originalFrom == null ^ sipResponse.getFrom().getTag() == null)            
            {
                if(sipStack.isLoggingEnabled())                
                sipStack.getStackLogger().logDebug("From tag mismatch -- dropping response");
                return;
            } //End block
            if(originalFrom != null
                    && !originalFrom.equalsIgnoreCase(sipResponse.getFrom().getTag()))            
            {
                if(sipStack.isLoggingEnabled())                
                sipStack.getStackLogger().logDebug("From tag mismatch -- dropping response");
                return;
            } //End block
        } //End block
        if(sipStack.isDialogCreated(method) && sipResponse.getStatusCode() != 100
                && sipResponse.getFrom().getTag() != null && sipResponse.getTo().getTag() != null
                && sipDialog == null)        
        {
            if(sipProvider.isAutomaticDialogSupportEnabled())            
            {
                if(this.transactionChannel != null)                
                {
                    if(sipDialog == null)                    
                    {
                        sipDialog = sipStack.createDialog(
                                (SIPClientTransaction) this.transactionChannel, sipResponse);
                        this.transactionChannel.setDialog(sipDialog, sipResponse
                                .getDialogId(false));
                    } //End block
                } //End block
                else
                {
                    sipDialog = this.sipStack.createDialog(sipProvider, sipResponse);
                } //End block
            } //End block
        } //End block
        else
        {
            if(sipDialog != null && transaction == null
                    && sipDialog.getState() != DialogState.TERMINATED)            
            {
                if(sipResponse.getStatusCode() / 100 != 2)                
                {
                    if(sipStack.isLoggingEnabled())                    
                    sipStack.getStackLogger().logDebug(
                                "status code != 200 ; statusCode = "
                                        + sipResponse.getStatusCode());
                } //End block
                else
                if(sipDialog.getState() == DialogState.TERMINATED)                
                {
                    if(sipStack.isLoggingEnabled())                    
                    {
                        sipStack.getStackLogger().logDebug(
                                "Dialog is terminated -- dropping response!");
                    } //End block
                    if(sipResponse.getStatusCode() / 100 == 2
                            && sipResponse.getCSeq().getMethod().equals(Request.INVITE))                    
                    {
                        try 
                        {
                            Request ackRequest = sipDialog.createAck(sipResponse.getCSeq()
                                    .getSeqNumber());
                            sipDialog.sendAck(ackRequest);
                        } //End block
                        catch (Exception ex)
                        {
                            sipStack.getStackLogger().logError("Error creating ack", ex);
                        } //End block
                    } //End block
                    return;
                } //End block
                else
                {
                    boolean ackAlreadySent = false;
                    if(sipDialog.isAckSeen() && sipDialog.getLastAckSent() != null)                    
                    {
                        if(sipDialog.getLastAckSent().getCSeq().getSeqNumber() == sipResponse
                                .getCSeq().getSeqNumber()
                                && sipResponse.getDialogId(false).equals(
                                        sipDialog.getLastAckSent().getDialogId(false)))                        
                        {
                            ackAlreadySent = true;
                        } //End block
                    } //End block
                    if(ackAlreadySent
                            && sipResponse.getCSeq().getMethod().equals(sipDialog.getMethod()))                    
                    {
                        try 
                        {
                            if(sipStack.isLoggingEnabled())                            
                            sipStack.getStackLogger().logDebug("resending ACK");
                            sipDialog.resendAck();
                            return;
                        } //End block
                        catch (SipException ex)
                        {
                        } //End block
                    } //End block
                } //End block
            } //End block
        } //End block
        if(sipStack.isLoggingEnabled())        
        sipStack.getStackLogger().logDebug("sending response to TU for processing ");
        if(sipDialog != null && sipResponse.getStatusCode() != 100
                && sipResponse.getTo().getTag() != null)        
        {
            sipDialog.setLastResponse(transaction, sipResponse);
        } //End block
        ResponseEventExt responseEvent = new ResponseEventExt(sipProvider,
                (ClientTransactionExt) transaction, sipDialog, (Response) sipResponse);
        if(sipResponse.getCSeq().getMethod().equals(Request.INVITE))        
        {
            ClientTransactionExt originalTx = this.sipStack.getForkedTransaction(sipResponse
                    .getTransactionId());
            responseEvent.setOriginalTransaction(originalTx);
        } //End block
        sipProvider.handleEvent(responseEvent, transaction);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

