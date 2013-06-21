package gov.nist.javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.core.InternalErrorHandler;
import gov.nist.javax.sip.address.SipUri;
import gov.nist.javax.sip.header.Contact;
import gov.nist.javax.sip.header.Event;
import gov.nist.javax.sip.header.ReferTo;
import gov.nist.javax.sip.header.RetryAfter;
import gov.nist.javax.sip.header.Route;
import gov.nist.javax.sip.header.RouteList;
import gov.nist.javax.sip.header.Server;
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
import java.util.TimerTask;
import javax.sip.ClientTransaction;
import javax.sip.DialogState;
import javax.sip.InvalidArgumentException;
import javax.sip.ObjectInUseException;
import javax.sip.RequestEvent;
import javax.sip.ResponseEvent;
import javax.sip.ServerTransaction;
import javax.sip.SipException;
import javax.sip.SipProvider;
import javax.sip.TransactionState;
import javax.sip.header.CSeqHeader;
import javax.sip.header.EventHeader;
import javax.sip.header.ReferToHeader;
import javax.sip.header.ServerHeader;
import javax.sip.message.Request;
import javax.sip.message.Response;

class DialogFilter implements ServerRequestInterface, ServerResponseInterface {
    protected SIPTransaction transactionChannel;
    protected ListeningPointImpl listeningPoint;
    private SipStackImpl sipStack;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.071 -0400", hash_original_method = "A91C8A8D71CBF898AE2C5B460693B699", hash_generated_method = "7D4904E6ECD41E39A90ED35CC97FD5E1")
    @DSModeled(DSC.SAFE)
    public DialogFilter(SipStackImpl sipStack) {
        dsTaint.addTaint(sipStack.dsTaint);
        // ---------- Original Method ----------
        //this.sipStack = sipStack;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.071 -0400", hash_original_method = "07FCA8BF1CB05FED9E9EE5BE5B9D0DF8", hash_generated_method = "40D09C38C3606AC9878831C0F092E16C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sendRequestPendingResponse(SIPRequest sipRequest,
            SIPServerTransaction transaction) {
        dsTaint.addTaint(transaction.dsTaint);
        dsTaint.addTaint(sipRequest.dsTaint);
        SIPResponse sipResponse;
        sipResponse = sipRequest.createResponse(Response.REQUEST_PENDING);
        ServerHeader serverHeader;
        serverHeader = MessageFactoryImpl.getDefaultServerHeader();
        {
            sipResponse.setHeader(serverHeader);
        } //End block
        try 
        {
            RetryAfter retryAfter;
            retryAfter = new RetryAfter();
            retryAfter.setRetryAfter(1);
            sipResponse.setHeader(retryAfter);
            {
                boolean varB40355E98F037248D6A7B38C6801D163_475278166 = (sipRequest.getMethod().equals(Request.INVITE));
                {
                    sipStack.addTransactionPendingAck(transaction);
                } //End block
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.072 -0400", hash_original_method = "C4ABF2148AD4585DF588E0AB365097FF", hash_generated_method = "4E06FA222956950E823EAF35B6C2F1FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sendBadRequestResponse(SIPRequest sipRequest, SIPServerTransaction transaction,
            String reasonPhrase) {
        dsTaint.addTaint(transaction.dsTaint);
        dsTaint.addTaint(reasonPhrase);
        dsTaint.addTaint(sipRequest.dsTaint);
        SIPResponse sipResponse;
        sipResponse = sipRequest.createResponse(Response.BAD_REQUEST);
        sipResponse.setReasonPhrase(reasonPhrase);
        ServerHeader serverHeader;
        serverHeader = MessageFactoryImpl.getDefaultServerHeader();
        {
            sipResponse.setHeader(serverHeader);
        } //End block
        try 
        {
            {
                boolean varB40355E98F037248D6A7B38C6801D163_1376600759 = (sipRequest.getMethod().equals(Request.INVITE));
                {
                    sipStack.addTransactionPendingAck(transaction);
                } //End block
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.072 -0400", hash_original_method = "D6292ED26CFFFD47381D5C093FDBF969", hash_generated_method = "74CA37E37D6EA5FC9F7E25CFC3F081F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sendCallOrTransactionDoesNotExistResponse(SIPRequest sipRequest,
            SIPServerTransaction transaction) {
        dsTaint.addTaint(transaction.dsTaint);
        dsTaint.addTaint(sipRequest.dsTaint);
        SIPResponse sipResponse;
        sipResponse = sipRequest
                .createResponse(Response.CALL_OR_TRANSACTION_DOES_NOT_EXIST);
        ServerHeader serverHeader;
        serverHeader = MessageFactoryImpl.getDefaultServerHeader();
        {
            sipResponse.setHeader(serverHeader);
        } //End block
        try 
        {
            {
                boolean varB40355E98F037248D6A7B38C6801D163_1981319263 = (sipRequest.getMethod().equals(Request.INVITE));
                {
                    sipStack.addTransactionPendingAck(transaction);
                } //End block
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.072 -0400", hash_original_method = "3FDF2D179E068B8AD4629A716A32BCF6", hash_generated_method = "0AA102755D8318E1BAAA392728D5D92F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sendLoopDetectedResponse(SIPRequest sipRequest, SIPServerTransaction transaction) {
        dsTaint.addTaint(transaction.dsTaint);
        dsTaint.addTaint(sipRequest.dsTaint);
        SIPResponse sipResponse;
        sipResponse = sipRequest.createResponse(Response.LOOP_DETECTED);
        ServerHeader serverHeader;
        serverHeader = MessageFactoryImpl.getDefaultServerHeader();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.073 -0400", hash_original_method = "1BAB8A1EF49695D9BD2CE878014B3A7C", hash_generated_method = "04F7A70052A54767066F35C6E33CAD65")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sendServerInternalErrorResponse(SIPRequest sipRequest,
            SIPServerTransaction transaction) {
        dsTaint.addTaint(transaction.dsTaint);
        dsTaint.addTaint(sipRequest.dsTaint);
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_2082616906 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger()
                    .logDebug("Sending 500 response for out of sequence message");
        } //End collapsed parenthetic
        SIPResponse sipResponse;
        sipResponse = sipRequest.createResponse(Response.SERVER_INTERNAL_ERROR);
        sipResponse.setReasonPhrase("Request out of order");
        {
            boolean varE71367B7FC420DF364496FD57FDD6F25_2058739052 = (MessageFactoryImpl.getDefaultServerHeader() != null);
            {
                ServerHeader serverHeader;
                serverHeader = MessageFactoryImpl.getDefaultServerHeader();
                sipResponse.setHeader(serverHeader);
            } //End block
        } //End collapsed parenthetic
        try 
        {
            RetryAfter retryAfter;
            retryAfter = new RetryAfter();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.078 -0400", hash_original_method = "358FFD6F817CCE2A8A6AEFD88EADC0D0", hash_generated_method = "D709479ACC6E9E2C99AFC86808E6B9B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void processRequest(SIPRequest sipRequest, MessageChannel incomingMessageChannel) {
        dsTaint.addTaint(incomingMessageChannel.dsTaint);
        dsTaint.addTaint(sipRequest.dsTaint);
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1138638896 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug(
                    "PROCESSING INCOMING REQUEST " + sipRequest + " transactionChannel = "
                            + transactionChannel + " listening point = "
                            + listeningPoint.getIPAddress() + ":" + listeningPoint.getPort());
        } //End collapsed parenthetic
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1674235438 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug(
                        "Dropping message: No listening point registered!");
            } //End collapsed parenthetic
        } //End block
        SipStackImpl sipStack;
        sipStack = (SipStackImpl) transactionChannel.getSIPStack();
        SipProviderImpl sipProvider;
        sipProvider = listeningPoint.getProvider();
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_689869826 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug("No provider - dropping !!");
            } //End collapsed parenthetic
        } //End block
        InternalErrorHandler.handleException("Egads! no sip stack!");
        SIPServerTransaction transaction;
        transaction = (SIPServerTransaction) this.transactionChannel;
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_635276090 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug(
                        "transaction state = " + transaction.getState());
            } //End collapsed parenthetic
        } //End block
        String dialogId;
        dialogId = sipRequest.getDialogId(true);
        SIPDialog dialog;
        dialog = sipStack.getDialog(dialogId);
        {
            boolean var8C35147A98AFF30DADBF44604DB5F9F7_2118563123 = (dialog != null && sipProvider != dialog.getSipProvider());
            {
                Contact contact;
                contact = dialog.getMyContactHeader();
                {
                    SipUri contactUri;
                    contactUri = (SipUri) (contact.getAddress().getURI());
                    String ipAddress;
                    ipAddress = contactUri.getHost();
                    int contactPort;
                    contactPort = contactUri.getPort();
                    String contactTransport;
                    contactTransport = contactUri.getTransportParam();
                    contactTransport = "udp";
                    {
                        {
                            boolean varE2885EA501158E42E31BDF8FAE2DFB15_863648816 = (contactTransport.equals("udp") || contactTransport.equals("tcp"));
                            contactPort = 5060;
                            contactPort = 5061;
                        } //End collapsed parenthetic
                    } //End block
                    {
                        boolean varECBDFD8681BEACCB1C4A54E5EA7A2BE3_1053349806 = (ipAddress != null
                        && (!ipAddress.equals(listeningPoint.getIPAddress()) || contactPort != listeningPoint
                                .getPort()));
                        {
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_913334509 = (sipStack.isLoggingEnabled());
                                {
                                    sipStack.getStackLogger().logDebug(
                                "nulling dialog -- listening point mismatch!  " + contactPort
                                        + "  lp port = " + listeningPoint.getPort());
                                } //End block
                            } //End collapsed parenthetic
                            dialog = null;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            boolean var9B43C7A4BD288E09DE245AB3A76734C6_1079589305 = (sipProvider.isAutomaticDialogSupportEnabled()
                && sipProvider.isDialogErrorsAutomaticallyHandled()
                && sipRequest.getToTag() == null);
            {
                SIPServerTransaction sipServerTransaction;
                sipServerTransaction = sipStack
                    .findMergedTransaction(sipRequest);
                {
                    this.sendLoopDetectedResponse(sipRequest, transaction);
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_2008662819 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("dialogId = " + dialogId);
                sipStack.getStackLogger().logDebug("dialog = " + dialog);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var74DC7DA70403614A0158FCF949AF488C_450572344 = (sipRequest.getHeader(Route.NAME) != null && transaction.getDialog() != null);
            {
                RouteList routes;
                routes = sipRequest.getRouteHeaders();
                Route route;
                route = (Route) routes.getFirst();
                SipUri uri;
                uri = (SipUri) route.getAddress().getURI();
                int port;
                {
                    boolean var9DB9725AF163E169EDB784F962234379_143894857 = (uri.getHostPort().hasPort());
                    {
                        port = uri.getHostPort().getPort();
                    } //End block
                    {
                        {
                            boolean varE06139CF2650C04993A642FB205435F9_1684240272 = (listeningPoint.getTransport().equalsIgnoreCase("TLS"));
                            port = 5061;
                            port = 5060;
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                String host;
                host = uri.getHost();
                {
                    boolean var7F13DC40DBFDACDD0C75F94E8076702B_915423333 = ((host.equals(listeningPoint.getIPAddress()) || host
                    .equalsIgnoreCase(listeningPoint.getSentBy()))
                    && port == listeningPoint.getPort());
                    {
                        {
                            boolean varA2EA7B726E8D2955E92EC5CEC24E87FC_1654449286 = (routes.size() == 1);
                            sipRequest.removeHeader(Route.NAME);
                            routes.removeFirst();
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean varD7AF0442E74759AC1FB0D16B64859435_997762082 = (sipRequest.getMethod().equals(Request.REFER) && dialog != null
                && sipProvider.isDialogErrorsAutomaticallyHandled());
            {
                ReferToHeader sipHeader;
                sipHeader = (ReferToHeader) sipRequest.getHeader(ReferTo.NAME);
                {
                    this
                        .sendBadRequestResponse(sipRequest, transaction,
                                "Refer-To header is missing");
                } //End block
                SIPTransaction lastTransaction;
                lastTransaction = ((SIPDialog) dialog).getLastTransaction();
                {
                    boolean var98297FAF3995B52999361BFB5CF06500_734911602 = (lastTransaction != null  && sipProvider.isDialogErrorsAutomaticallyHandled());
                    {
                        SIPRequest lastRequest;
                        lastRequest = (SIPRequest) lastTransaction.getRequest();
                        {
                            {
                                boolean varB83F47265B2EAB2CC6FE0D4FE115165B_415063948 = (!((SIPDialog) dialog).isAckSeen()   
                            && lastRequest.getMethod().equals(Request.INVITE));
                                {
                                    this.sendRequestPendingResponse(sipRequest, transaction);
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        {
                            long cseqno;
                            cseqno = lastRequest.getCSeqHeader().getSeqNumber();
                            String method;
                            method = lastRequest.getMethod();
                            {
                                boolean varD72140EEF39752E9B60D36C18F8B8CDE_519090011 = (method.equals(Request.INVITE) && !dialog.isAckSent(cseqno));
                                {
                                    this.sendRequestPendingResponse(sipRequest, transaction);
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean var0C5EC9F754984B9197534DAE31433F4E_1319803118 = (sipRequest.getMethod().equals(Request.UPDATE));
                {
                    {
                        boolean varF75E99F53F801F7147949B29F933FAE6_1308790278 = (sipProvider.isAutomaticDialogSupportEnabled() && dialog == null);
                        {
                            this.sendCallOrTransactionDoesNotExistResponse(sipRequest, transaction);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean varF16B36B5D25AE0530430F54B0EB17398_1988814248 = (sipRequest.getMethod().equals(Request.ACK));
                    {
                        {
                            boolean var73A6E09F014EBAF3EE18BEFDB7721839_229706067 = (transaction != null && transaction.isInviteTransaction());
                            {
                                {
                                    boolean varA5D47C3A6259BCCCC2265DD1F84B75D4_660758714 = (sipStack.isLoggingEnabled());
                                    sipStack.getStackLogger().logDebug("Processing ACK for INVITE Tx ");
                                } //End collapsed parenthetic
                            } //End block
                            {
                                {
                                    boolean varA5D47C3A6259BCCCC2265DD1F84B75D4_1142929841 = (sipStack.isLoggingEnabled());
                                    sipStack.getStackLogger().logDebug("Processing ACK for dialog " + dialog);
                                } //End collapsed parenthetic
                                {
                                    {
                                        boolean var6FE8ACC5352DCA3449210F8EDED912B3_787501371 = (sipStack.isLoggingEnabled());
                                        {
                                            sipStack.getStackLogger().logDebug(
                                "Dialog does not exist " + sipRequest.getFirstLine()
                                        + " isServerTransaction = " + true);
                                        } //End block
                                    } //End collapsed parenthetic
                                    SIPServerTransaction st;
                                    st = sipStack
                            .getRetransmissionAlertTransaction(dialogId);
                                    {
                                        boolean varE352A1C183E4E601EF778AF0E529DA77_30285301 = (st != null && st.isRetransmissionAlertEnabled());
                                        {
                                            st.disableRetransmissionAlerts();
                                        } //End block
                                    } //End collapsed parenthetic
                                    SIPServerTransaction ackTransaction;
                                    ackTransaction = sipStack
                            .findTransactionPendingAck(sipRequest);
                                    {
                                        {
                                            boolean var974BD9A3C84119780B64DA7C8AA64368_1796144182 = (sipStack.isLoggingEnabled());
                                            sipStack.getStackLogger().logDebug("Found Tx pending ACK");
                                        } //End collapsed parenthetic
                                        try 
                                        {
                                            ackTransaction.setAckSeen();
                                            sipStack.removeTransaction(ackTransaction);
                                            sipStack.removeTransactionPendingAck(ackTransaction);
                                        } //End block
                                        catch (Exception ex)
                                        {
                                            {
                                                boolean varC8BF86FC1141E4E4181585335ACFB1D1_1463348391 = (sipStack.isLoggingEnabled());
                                                {
                                                    sipStack.getStackLogger().logError(
                                        "Problem terminating transaction", ex);
                                                } //End block
                                            } //End collapsed parenthetic
                                        } //End block
                                    } //End block
                                } //End block
                                {
                                    {
                                        boolean varA0FE1183F2132979E9E0AD074A782F58_997345251 = (!dialog.handleAck(transaction));
                                        {
                                            {
                                                boolean varEB868D3ACE63E50D8696CFBB21111866_101792912 = (!dialog.isSequnceNumberValidation());
                                                {
                                                    {
                                                        boolean var1CA58CF859FCBE04EE708A028DDCA412_1936509093 = (sipStack.isLoggingEnabled());
                                                        {
                                                            sipStack.getStackLogger().logDebug(
                                        "Dialog exists with loose dialog validation "
                                                + sipRequest.getFirstLine()
                                                + " isServerTransaction = " + true + " dialog = "
                                                + dialog.getDialogId());
                                                        } //End block
                                                    } //End collapsed parenthetic
                                                    SIPServerTransaction st;
                                                    st = sipStack
                                    .getRetransmissionAlertTransaction(dialogId);
                                                    {
                                                        boolean var73DA9E229925D1E2E4876032DE278F33_1362038666 = (st != null && st.isRetransmissionAlertEnabled());
                                                        {
                                                            st.disableRetransmissionAlerts();
                                                        } //End block
                                                    } //End collapsed parenthetic
                                                } //End block
                                                {
                                                    {
                                                        boolean var1CA58CF859FCBE04EE708A028DDCA412_1136304019 = (sipStack.isLoggingEnabled());
                                                        {
                                                            sipStack.getStackLogger().logDebug(
                                        "Dropping ACK - cannot find a transaction or dialog");
                                                        } //End block
                                                    } //End collapsed parenthetic
                                                    SIPServerTransaction ackTransaction;
                                                    ackTransaction = sipStack
                                    .findTransactionPendingAck(sipRequest);
                                                    {
                                                        {
                                                            boolean var240DFB7B2BD3D164A79626CA77291C20_1677936249 = (sipStack.isLoggingEnabled());
                                                            sipStack.getStackLogger().logDebug("Found Tx pending ACK");
                                                        } //End collapsed parenthetic
                                                        try 
                                                        {
                                                            ackTransaction.setAckSeen();
                                                            sipStack.removeTransaction(ackTransaction);
                                                            sipStack.removeTransactionPendingAck(ackTransaction);
                                                        } //End block
                                                        catch (Exception ex)
                                                        {
                                                            {
                                                                boolean varA0D95B65CC2D70A2B0675F3ACBF8689B_314878008 = (sipStack.isLoggingEnabled());
                                                                {
                                                                    sipStack.getStackLogger().logError(
                                                "Problem terminating transaction", ex);
                                                                } //End block
                                                            } //End collapsed parenthetic
                                                        } //End block
                                                    } //End block
                                                } //End block
                                            } //End collapsed parenthetic
                                        } //End block
                                        {
                                            transaction.passToListener();
                                            dialog.addTransaction(transaction);
                                            dialog.addRoute(sipRequest);
                                            transaction.setDialog(dialog, dialogId);
                                            {
                                                boolean var1A7C116BDB0B16BEED8B2FBD8272556D_761703566 = (sipRequest.getMethod().equals(Request.INVITE)
                                && sipProvider.isDialogErrorsAutomaticallyHandled());
                                                {
                                                    sipStack.putInMergeTable(transaction, sipRequest);
                                                } //End block
                                            } //End collapsed parenthetic
                                            {
                                                try 
                                                {
                                                    sipStack.addTransaction(transaction);
                                                    transaction.scheduleAckRemoval();
                                                } //End block
                                                catch (IOException ex)
                                                { }
                                            } //End block
                                            {
                                                transaction.setMapped(true);
                                            } //End block
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        boolean var4359D03ED24BB6A1C73AA4474DB586FE_1586815809 = (sipRequest.getMethod().equals(Request.PRACK));
                        {
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_1295948856 = (sipStack.isLoggingEnabled());
                                sipStack.getStackLogger().logDebug("Processing PRACK for dialog " + dialog);
                            } //End collapsed parenthetic
                            {
                                boolean varB8381F2D44FFEF8EDC556F52DF90FA28_1956341854 = (dialog == null && sipProvider.isAutomaticDialogSupportEnabled());
                                {
                                    {
                                        boolean var6FE8ACC5352DCA3449210F8EDED912B3_1253493404 = (sipStack.isLoggingEnabled());
                                        {
                                            sipStack.getStackLogger().logDebug(
                            "Dialog does not exist " + sipRequest.getFirstLine()
                                    + " isServerTransaction = " + true);
                                        } //End block
                                    } //End collapsed parenthetic
                                    {
                                        boolean var6FE8ACC5352DCA3449210F8EDED912B3_126055192 = (sipStack.isLoggingEnabled());
                                        {
                                            sipStack
                            .getStackLogger()
                            .logDebug(
                                    "Sending 481 for PRACK - automatic dialog support is enabled -- cant find dialog!");
                                        } //End block
                                    } //End collapsed parenthetic
                                    SIPResponse notExist;
                                    notExist = sipRequest
                        .createResponse(Response.CALL_OR_TRANSACTION_DOES_NOT_EXIST);
                                    try 
                                    {
                                        sipProvider.sendResponse(notExist);
                                    } //End block
                                    catch (SipException e)
                                    {
                                        sipStack.getStackLogger().logError("error sending response", e);
                                    } //End block
                                    {
                                        sipStack.removeTransaction(transaction);
                                        transaction.releaseSem();
                                    } //End block
                                } //End block
                                {
                                    {
                                        boolean varA3A0470A7974A75D85F1E38AA926110E_615025917 = (!dialog.handlePrack(sipRequest));
                                        {
                                            {
                                                boolean varC8BF86FC1141E4E4181585335ACFB1D1_124668673 = (sipStack.isLoggingEnabled());
                                                sipStack.getStackLogger().logDebug("Dropping out of sequence PRACK ");
                                            } //End collapsed parenthetic
                                            {
                                                sipStack.removeTransaction(transaction);
                                                transaction.releaseSem();
                                            } //End block
                                        } //End block
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
                                    } //End collapsed parenthetic
                                } //End block
                                {
                                    {
                                        boolean var6FE8ACC5352DCA3449210F8EDED912B3_1202806737 = (sipStack.isLoggingEnabled());
                                        sipStack.getStackLogger().logDebug(
                            "Processing PRACK without a DIALOG -- this must be a proxy element");
                                    } //End collapsed parenthetic
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        {
                            boolean var223469E3016F4CBAAE79AF42372AB5C4_2020297648 = (sipRequest.getMethod().equals(Request.BYE));
                            {
                                {
                                    boolean var8118EA94EB7FF7E528D9675F7D7382EF_1133064698 = (dialog != null && !dialog.isRequestConsumable(sipRequest));
                                    {
                                        {
                                            boolean var974BD9A3C84119780B64DA7C8AA64368_769101447 = (sipStack.isLoggingEnabled());
                                            sipStack.getStackLogger().logDebug(
                            "Dropping out of sequence BYE " + dialog.getRemoteSeqNumber() + " "
                                    + sipRequest.getCSeq().getSeqNumber());
                                        } //End collapsed parenthetic
                                        {
                                            boolean var91C43A90EFA51B9EB63058171E9F202A_1601263768 = (dialog.getRemoteSeqNumber() >= sipRequest.getCSeq().getSeqNumber()
                        && transaction.getState() == TransactionState.TRYING);
                                            {
                                                this.sendServerInternalErrorResponse(sipRequest, transaction);
                                            } //End block
                                        } //End collapsed parenthetic
                                        sipStack.removeTransaction(transaction);
                                    } //End block
                                    {
                                        boolean var7E61F277ADAB84A3B118D7ECFA89E811_804227548 = (dialog == null && sipProvider.isAutomaticDialogSupportEnabled());
                                        {
                                            SIPResponse response;
                                            response = sipRequest
                        .createResponse(Response.CALL_OR_TRANSACTION_DOES_NOT_EXIST);
                                            response.setReasonPhrase("Dialog Not Found");
                                            {
                                                boolean varC8BF86FC1141E4E4181585335ACFB1D1_662333781 = (sipStack.isLoggingEnabled());
                                                sipStack.getStackLogger().logDebug(
                            "dropping request -- automatic dialog "
                                    + "support enabled and dialog does not exist!");
                                            } //End collapsed parenthetic
                                            try 
                                            {
                                                transaction.sendResponse(response);
                                            } //End block
                                            catch (SipException ex)
                                            {
                                                sipStack.getStackLogger().logError("Error in sending response", ex);
                                            } //End block
                                            {
                                                sipStack.removeTransaction(transaction);
                                                transaction.releaseSem();
                                                transaction = null;
                                            } //End block
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End collapsed parenthetic
                                {
                                    try 
                                    {
                                        {
                                            boolean varD1FB173C06A75FCF4E8AC458835BFF6C_58559836 = (sipProvider == dialog.getSipProvider());
                                            {
                                                sipStack.addTransaction(transaction);
                                                dialog.addTransaction(transaction);
                                                transaction.setDialog(dialog, dialogId);
                                            } //End block
                                        } //End collapsed parenthetic
                                    } //End block
                                    catch (IOException ex)
                                    {
                                        InternalErrorHandler.handleException(ex);
                                    } //End block
                                } //End block
                                {
                                    boolean varA5D47C3A6259BCCCC2265DD1F84B75D4_158904805 = (sipStack.isLoggingEnabled());
                                    {
                                        sipStack.getStackLogger().logDebug(
                        "BYE Tx = " + transaction + " isMapped ="
                                + transaction.isTransactionMapped());
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                            {
                                boolean var5A587D44C8FFFD0687558BABDD2E64A8_2092239280 = (sipRequest.getMethod().equals(Request.CANCEL));
                                {
                                    SIPServerTransaction st;
                                    st = (SIPServerTransaction) sipStack.findCancelTransaction(
                    sipRequest, true);
                                    {
                                        boolean var6FE8ACC5352DCA3449210F8EDED912B3_814215464 = (sipStack.isLoggingEnabled());
                                        {
                                            sipStack.getStackLogger().logDebug(
                        "Got a CANCEL, InviteServerTx = " + st + " cancel Server Tx ID = "
                                + transaction + " isMapped = "
                                + transaction.isTransactionMapped());
                                        } //End block
                                    } //End collapsed parenthetic
                                    {
                                        boolean var36F2407ABDDD4CF270E5152D58918383_803939011 = (sipRequest.getMethod().equals(Request.CANCEL));
                                        {
                                            {
                                                boolean var910A93B09BD8B46A76494278BD78EE19_979023655 = (st != null && st.getState() == SIPTransaction.TERMINATED_STATE);
                                                {
                                                    {
                                                        boolean var1CA58CF859FCBE04EE708A028DDCA412_1117925708 = (sipStack.isLoggingEnabled());
                                                        sipStack.getStackLogger().logDebug("Too late to cancel Transaction");
                                                    } //End collapsed parenthetic
                                                    try 
                                                    {
                                                        transaction.sendResponse(sipRequest.createResponse(Response.OK));
                                                    } //End block
                                                    catch (Exception ex)
                                                    {
                                                        {
                                                            boolean var4FB79B1E41CF851478BD46FA49031E2A_977849385 = (ex.getCause() != null && ex.getCause() instanceof IOException);
                                                            {
                                                                st.raiseIOExceptionEvent();
                                                            } //End block
                                                        } //End collapsed parenthetic
                                                    } //End block
                                                } //End block
                                            } //End collapsed parenthetic
                                            {
                                                boolean varC8BF86FC1141E4E4181585335ACFB1D1_724526725 = (sipStack.isLoggingEnabled());
                                                sipStack.getStackLogger().logDebug("Cancel transaction = " + st);
                                            } //End collapsed parenthetic
                                        } //End block
                                    } //End collapsed parenthetic
                                    {
                                        boolean var96EEFF7E2538EC7D178603BD843A63B5_1568566033 = (transaction != null && st != null && st.getDialog() != null);
                                        {
                                            transaction.setDialog((SIPDialog) st.getDialog(), dialogId);
                                            dialog = (SIPDialog) st.getDialog();
                                        } //End block
                                        {
                                            boolean var89A34BE79F626089DE9A46AA3D4D5644_1956218299 = (st == null && sipProvider.isAutomaticDialogSupportEnabled()
                    && transaction != null);
                                            {
                                                SIPResponse response;
                                                response = sipRequest
                        .createResponse(Response.CALL_OR_TRANSACTION_DOES_NOT_EXIST);
                                                {
                                                    boolean var3EB379B664411110CCE0F3EED18D8CFA_711976680 = (sipStack.isLoggingEnabled());
                                                    {
                                                        sipStack.getStackLogger().logDebug(
                            "dropping request -- automatic dialog support "
                                    + "enabled and INVITE ST does not exist!");
                                                    } //End block
                                                } //End collapsed parenthetic
                                                try 
                                                {
                                                    sipProvider.sendResponse(response);
                                                } //End block
                                                catch (SipException ex)
                                                {
                                                    InternalErrorHandler.handleException(ex);
                                                } //End block
                                                {
                                                    sipStack.removeTransaction(transaction);
                                                    transaction.releaseSem();
                                                } //End block
                                            } //End block
                                        } //End collapsed parenthetic
                                    } //End collapsed parenthetic
                                    {
                                        try 
                                        {
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
                                {
                                    boolean varB4F65467E51F8CADB8FA727E0038ECE5_1372750489 = (sipRequest.getMethod().equals(Request.INVITE));
                                    {
                                        SIPTransaction lastTransaction;
                                        lastTransaction = null;
                                        lastTransaction = dialog
                    .getInviteTransaction();
                                        {
                                            boolean varFFF6C63A745186E6359C3F0ACC832311_1735349738 = (dialog != null && transaction != null && lastTransaction != null
                    && sipRequest.getCSeq().getSeqNumber() > dialog.getRemoteSeqNumber()
                    && lastTransaction instanceof SIPServerTransaction
                    && sipProvider.isDialogErrorsAutomaticallyHandled()
                    && dialog.isSequnceNumberValidation()
                    && lastTransaction.isInviteTransaction()
                    && lastTransaction.getState() != TransactionState.COMPLETED
                    && lastTransaction.getState() != TransactionState.TERMINATED
                    && lastTransaction.getState() != TransactionState.CONFIRMED);
                                            {
                                                {
                                                    boolean var3EB379B664411110CCE0F3EED18D8CFA_167569696 = (sipStack.isLoggingEnabled());
                                                    {
                                                        sipStack.getStackLogger().logDebug(
                            "Sending 500 response for out of sequence message");
                                                    } //End block
                                                } //End collapsed parenthetic
                                                this.sendServerInternalErrorResponse(sipRequest, transaction);
                                            } //End block
                                        } //End collapsed parenthetic
                                        lastTransaction = (dialog == null ? null : dialog.getLastTransaction());
                                        {
                                            boolean varDC33FCDDD5DAA373F0357E066C3EFCCD_1168638758 = (dialog != null
                    && sipProvider.isDialogErrorsAutomaticallyHandled()
                    && lastTransaction != null
                    && lastTransaction.isInviteTransaction()
                    && lastTransaction instanceof ClientTransaction
                    && lastTransaction.getLastResponse() != null
                    && lastTransaction.getLastResponse().getStatusCode() == 200
                    && !dialog.isAckSent(lastTransaction.getLastResponse().getCSeq()
                            .getSeqNumber()));
                                            {
                                                {
                                                    boolean var3EB379B664411110CCE0F3EED18D8CFA_32283792 = (sipStack.isLoggingEnabled());
                                                    {
                                                        sipStack.getStackLogger().logDebug(
                            "Sending 491 response for client Dialog ACK not sent.");
                                                    } //End block
                                                } //End collapsed parenthetic
                                                this.sendRequestPendingResponse(sipRequest, transaction);
                                            } //End block
                                        } //End collapsed parenthetic
                                        {
                                            boolean var408778EC92ADB5D4F0BF80EA83D1A422_1170748770 = (dialog != null && lastTransaction != null
                    && sipProvider.isDialogErrorsAutomaticallyHandled()
                    && lastTransaction.isInviteTransaction()
                    && lastTransaction instanceof ServerTransaction && !dialog.isAckSeen());
                                            {
                                                {
                                                    boolean var3EB379B664411110CCE0F3EED18D8CFA_1580508498 = (sipStack.isLoggingEnabled());
                                                    {
                                                        sipStack.getStackLogger().logDebug(
                            "Sending 491 response for server Dialog ACK not seen.");
                                                    } //End block
                                                } //End collapsed parenthetic
                                                this.sendRequestPendingResponse(sipRequest, transaction);
                                            } //End block
                                        } //End collapsed parenthetic
                                    } //End block
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1018366746 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug(
                    "CHECK FOR OUT OF SEQ MESSAGE " + dialog + " transaction " + transaction);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var48BDD4FCB5B9B348DAF5CF27ABA783E4_739062870 = (dialog != null && transaction != null && !sipRequest.getMethod().equals(Request.BYE)
                && !sipRequest.getMethod().equals(Request.CANCEL)
                && !sipRequest.getMethod().equals(Request.ACK)
                && !sipRequest.getMethod().equals(Request.PRACK));
            {
                {
                    boolean var5E9F871F958E5238EF0D614546DF8D4F_206299395 = (!dialog.isRequestConsumable(sipRequest));
                    {
                        {
                            boolean var2AB968A8303910EE00F810B6DE3410F9_669221267 = (sipStack.isLoggingEnabled());
                            {
                                sipStack.getStackLogger().logDebug(
                            "Dropping out of sequence message " + dialog.getRemoteSeqNumber()
                                    + " " + sipRequest.getCSeq());
                            } //End block
                        } //End collapsed parenthetic
                        {
                            boolean var97E8BF7CC65B132656689558BFB89C51_734303196 = (dialog.getRemoteSeqNumber() >= sipRequest.getCSeq().getSeqNumber()
                        && sipProvider.isDialogErrorsAutomaticallyHandled()
                        && (transaction.getState() == TransactionState.TRYING || transaction
                                .getState() == TransactionState.PROCEEDING));
                            {
                                this.sendServerInternalErrorResponse(sipRequest, transaction);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                try 
                {
                    {
                        boolean var57AD5EA186EDB651D8CE5AB4BB561AE2_355368523 = (sipProvider == dialog.getSipProvider());
                        {
                            sipStack.addTransaction(transaction);
                            dialog.addTransaction(transaction);
                            dialog.addRoute(sipRequest);
                            transaction.setDialog(dialog, dialogId);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                catch (IOException ex)
                {
                    transaction.raiseIOExceptionEvent();
                    sipStack.removeTransaction(transaction);
                } //End block
            } //End block
        } //End collapsed parenthetic
        RequestEvent sipEvent;
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_112709847 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug(
                    sipRequest.getMethod() + " transaction.isMapped = "
                            + transaction.isTransactionMapped());
            } //End block
        } //End collapsed parenthetic
        {
            boolean var06524EA1A95D3E7F1E9D8CA11A51708A_1389113092 = (dialog == null && sipRequest.getMethod().equals(Request.NOTIFY));
            {
                SIPClientTransaction pendingSubscribeClientTx;
                pendingSubscribeClientTx = sipStack.findSubscribeTransaction(
                    sipRequest, listeningPoint);
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_323343424 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logDebug(
                        "PROCESSING NOTIFY  DIALOG == null " + pendingSubscribeClientTx);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var1B981CBAC8C463A2565330106D8D8AE3_1512300699 = (sipProvider.isAutomaticDialogSupportEnabled() && pendingSubscribeClientTx == null
                    && !sipStack.deliverUnsolicitedNotify);
                    {
                        try 
                        {
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_2130678131 = (sipStack.isLoggingEnabled());
                                {
                                    sipStack.getStackLogger().logDebug(
                                "Could not find Subscription for Notify Tx.");
                                } //End block
                            } //End collapsed parenthetic
                            Response errorResponse;
                            errorResponse = sipRequest
                            .createResponse(Response.CALL_OR_TRANSACTION_DOES_NOT_EXIST);
                            errorResponse.setReasonPhrase("Subscription does not exist");
                            sipProvider.sendResponse(errorResponse);
                        } //End block
                        catch (Exception ex)
                        {
                            sipStack.getStackLogger().logError(
                            "Exception while sending error response statelessly", ex);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                {
                    transaction.setPendingSubscribe(pendingSubscribeClientTx);
                    SIPDialog subscriptionDialog;
                    subscriptionDialog = (SIPDialog) pendingSubscribeClientTx
                        .getDefaultDialog();
                    {
                        boolean var0F6E68A7D3D6E67E47CCDE3F6F21AC95_1478520772 = (subscriptionDialog == null || subscriptionDialog.getDialogId() == null
                        || !subscriptionDialog.getDialogId().equals(dialogId));
                        {
                            {
                                boolean var06C7385D21A09BE1F538DB3A4C26CF1A_1729323373 = (subscriptionDialog != null && subscriptionDialog.getDialogId() == null);
                                {
                                    subscriptionDialog.setDialogId(dialogId);
                                } //End block
                                {
                                    subscriptionDialog = pendingSubscribeClientTx.getDialog(dialogId);
                                } //End block
                            } //End collapsed parenthetic
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_2051369563 = (sipStack.isLoggingEnabled());
                                {
                                    sipStack.getStackLogger().logDebug(
                                "PROCESSING NOTIFY Subscribe DIALOG " + subscriptionDialog);
                                } //End block
                            } //End collapsed parenthetic
                            {
                                boolean var61264EA7CBE984CBB241AF426F48C4BB_2073059180 = (subscriptionDialog == null
                            && (sipProvider.isAutomaticDialogSupportEnabled() || pendingSubscribeClientTx
                                    .getDefaultDialog() != null));
                                {
                                    Event event;
                                    event = (Event) sipRequest.getHeader(EventHeader.NAME);
                                    {
                                        boolean var7551F67C46A9BF2F69F8DC249417BE87_923152191 = (sipStack.isEventForked(event.getEventType()));
                                        {
                                            subscriptionDialog = SIPDialog.createFromNOTIFY(
                                    pendingSubscribeClientTx, transaction);
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                            } //End collapsed parenthetic
                            {
                                transaction.setDialog(subscriptionDialog, dialogId);
                                subscriptionDialog.setState(DialogState.CONFIRMED.getValue());
                                sipStack.putDialog(subscriptionDialog);
                                pendingSubscribeClientTx.setDialog(subscriptionDialog, dialogId);
                                {
                                    boolean var56EA1424ACFA2A47121556050BD2E6E4_783588456 = (!transaction.isTransactionMapped());
                                    {
                                        this.sipStack.mapTransaction(transaction);
                                        transaction.setPassToListener();
                                        try 
                                        {
                                            this.sipStack.addTransaction(transaction);
                                        } //End block
                                        catch (Exception ex)
                                        { }
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End block
                        {
                            transaction.setDialog(subscriptionDialog, dialogId);
                            dialog = subscriptionDialog;
                            {
                                boolean var733DB0B9FD969609EE0DCA90A3371EAE_718676072 = (!transaction.isTransactionMapped());
                                {
                                    this.sipStack.mapTransaction(transaction);
                                    transaction.setPassToListener();
                                    try 
                                    {
                                        this.sipStack.addTransaction(transaction);
                                    } //End block
                                    catch (Exception ex)
                                    { }
                                } //End block
                            } //End collapsed parenthetic
                            sipStack.putDialog(subscriptionDialog);
                            {
                                subscriptionDialog.addTransaction(pendingSubscribeClientTx);
                                pendingSubscribeClientTx.setDialog(subscriptionDialog, dialogId);
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                    {
                        boolean varCD4C864AAD0BDABE3381B0E19A45E3EC_1034419623 = (transaction != null
                        && ((SIPServerTransaction) transaction).isTransactionMapped());
                        {
                            sipEvent = new RequestEvent((SipProvider) sipProvider,
                            (ServerTransaction) transaction, subscriptionDialog,
                            (Request) sipRequest);
                        } //End block
                        {
                            sipEvent = new RequestEvent((SipProvider) sipProvider, null,
                            subscriptionDialog, (Request) sipRequest);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_535813933 = (sipStack.isLoggingEnabled());
                        {
                            sipStack.getStackLogger().logDebug("could not find subscribe tx");
                        } //End block
                    } //End collapsed parenthetic
                    sipEvent = new RequestEvent(sipProvider, null, null, (Request) sipRequest);
                } //End block
            } //End block
            {
                {
                    boolean var1F897FC6A02886EFEA9EFE79510B36CC_1211072799 = (transaction != null
                    && (((SIPServerTransaction) transaction).isTransactionMapped()));
                    {
                        sipEvent = new RequestEvent(sipProvider, (ServerTransaction) transaction, dialog,
                        (Request) sipRequest);
                    } //End block
                    {
                        sipEvent = new RequestEvent(sipProvider, null, dialog, (Request) sipRequest);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        sipProvider.handleEvent(sipEvent, transaction);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.081 -0400", hash_original_method = "4FD6D5D7FFBD58CDE4927F751F9B55A3", hash_generated_method = "368AEF40F42919E32D80F5B763FD30D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void processResponse(SIPResponse response, MessageChannel incomingMessageChannel,
            SIPDialog dialog) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(incomingMessageChannel.dsTaint);
        dsTaint.addTaint(dialog.dsTaint);
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1361361920 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug(
                    "PROCESSING INCOMING RESPONSE" + response.encodeMessage());
            } //End block
        } //End collapsed parenthetic
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_295926883 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logError(
                        "Dropping message: No listening point" + " registered!");
            } //End collapsed parenthetic
        } //End block
        {
            boolean varE5AAF51FD8C4BE95480F9A8330DA6C95_206456659 = (sipStack.checkBranchId() && !Utils.getInstance().responseBelongsToUs(response));
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1536325446 = (sipStack.isLoggingEnabled());
                    {
                        sipStack
                        .getStackLogger()
                        .logError(
                                "Dropping response - topmost VIA header does not originate from this stack");
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        SipProviderImpl sipProvider;
        sipProvider = listeningPoint.getProvider();
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_205797149 = (sipStack.isLoggingEnabled());
                {
                    sipStack.getStackLogger().logError("Dropping message:  no provider");
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean var040B3845D432851B37CAFD9378AE7CDE_2134181913 = (sipProvider.getSipListener() == null);
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_859798641 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logError("No listener -- dropping response!");
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        SIPClientTransaction transaction;
        transaction = (SIPClientTransaction) this.transactionChannel;
        SipStackImpl sipStackImpl;
        sipStackImpl = sipProvider.sipStack;
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1174700961 = (sipStack.isLoggingEnabled());
            {
                sipStackImpl.getStackLogger().logDebug("Transaction = " + transaction);
            } //End block
        } //End collapsed parenthetic
        {
            {
                {
                    boolean varE7B175AF8865034C7D61EB8B89828EB1_1171045739 = (response.getStatusCode() / 100 != 2);
                    {
                        {
                            boolean var2AB968A8303910EE00F810B6DE3410F9_1330515685 = (sipStack.isLoggingEnabled());
                            {
                                sipStack
                                .getStackLogger()
                                .logDebug(
                                        "Response is not a final response and dialog is found for response -- dropping response!");
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        boolean varF1186D828C527F0FC804545C83D3B2C4_2094865069 = (dialog.getState() == DialogState.TERMINATED);
                        {
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_615603156 = (sipStack.isLoggingEnabled());
                                {
                                    sipStack.getStackLogger().logDebug(
                                "Dialog is terminated -- dropping response!");
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        {
                            boolean ackAlreadySent;
                            ackAlreadySent = false;
                            {
                                boolean varD174CA822C582B50295D667097D2B4C3_1159692786 = (dialog.isAckSeen() && dialog.getLastAckSent() != null);
                                {
                                    {
                                        boolean var5F4DE3FF9BFD4FA91AED336B5BA1404F_1355177215 = (dialog.getLastAckSent().getCSeq().getSeqNumber() == response
                                .getCSeq().getSeqNumber());
                                        {
                                            ackAlreadySent = true;
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                            } //End collapsed parenthetic
                            {
                                boolean varF26458E3699544D453D8368FD052D8A4_889528980 = (ackAlreadySent
                            && response.getCSeq().getMethod().equals(dialog.getMethod()));
                                {
                                    try 
                                    {
                                        {
                                            boolean var974BD9A3C84119780B64DA7C8AA64368_330992063 = (sipStack.isLoggingEnabled());
                                            {
                                                sipStack.getStackLogger().logDebug(
                                        "Retransmission of OK detected: Resending last ACK");
                                            } //End block
                                        } //End collapsed parenthetic
                                        dialog.resendAck();
                                    } //End block
                                    catch (SipException ex)
                                    {
                                        sipStack.getStackLogger().logError("could not resend ack", ex);
                                    } //End block
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_974968558 = (sipStack.isLoggingEnabled());
                {
                    sipStack.getStackLogger().logDebug(
                        "could not find tx, handling statelessly Dialog =  " + dialog);
                } //End block
            } //End collapsed parenthetic
            ResponseEventExt sipEvent;
            sipEvent = new ResponseEventExt(sipProvider, transaction, dialog,
                    (Response) response);
            {
                boolean var007768642FD4E3B95AE9722E749A6203_1183458992 = (response.getCSeqHeader().getMethod().equals(Request.INVITE));
                {
                    SIPClientTransaction forked;
                    forked = this.sipStack.getForkedTransaction(response
                        .getTransactionId());
                    sipEvent.setOriginalTransaction(forked);
                } //End block
            } //End collapsed parenthetic
            sipProvider.handleEvent(sipEvent, transaction);
        } //End block
        ResponseEventExt responseEvent;
        responseEvent = null;
        responseEvent = new ResponseEventExt(sipProvider, (ClientTransactionExt) transaction,
                dialog, (Response) response);
        {
            boolean varA55C1203D27CB1F1AE2EDB7445ACAD7D_598210489 = (response.getCSeqHeader().getMethod().equals(Request.INVITE));
            {
                SIPClientTransaction forked;
                forked = this.sipStack.getForkedTransaction(response
                    .getTransactionId());
                responseEvent.setOriginalTransaction(forked);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var3BD152FD822A20243698FAE63282F587_1962616960 = (dialog != null && response.getStatusCode() != 100);
            {
                dialog.setLastResponse(transaction, response);
                transaction.setDialog(dialog, dialog.getDialogId());
            } //End block
        } //End collapsed parenthetic
        sipProvider.handleEvent(responseEvent, transaction);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.082 -0400", hash_original_method = "45F8896428832201E8BC8983A22C5151", hash_generated_method = "A2F94819F64B2EE47C3E72202329A8FF")
    @DSModeled(DSC.SAFE)
    public String getProcessingInfo() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.083 -0400", hash_original_method = "913AD64E566DC17432B7074017A68B2C", hash_generated_method = "5372A4A4448D2075D357437542F7E6E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void processResponse(SIPResponse sipResponse, MessageChannel incomingChannel) {
        dsTaint.addTaint(incomingChannel.dsTaint);
        dsTaint.addTaint(sipResponse.dsTaint);
        String dialogID;
        dialogID = sipResponse.getDialogId(false);
        SIPDialog sipDialog;
        sipDialog = this.sipStack.getDialog(dialogID);
        String method;
        method = sipResponse.getCSeq().getMethod();
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_2035722369 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug(
                    "PROCESSING INCOMING RESPONSE: " + sipResponse.encodeMessage());
            } //End block
        } //End collapsed parenthetic
        {
            boolean var628EC40CE8B4405B3393CE579584B6B9_1532294984 = (sipStack.checkBranchId() && !Utils.getInstance().responseBelongsToUs(sipResponse));
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_4419956 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logError("Detected stray response -- dropping");
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1222352716 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug(
                        "Dropping message: No listening point" + " registered!");
            } //End collapsed parenthetic
        } //End block
        SipProviderImpl sipProvider;
        sipProvider = listeningPoint.getProvider();
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1517335156 = (sipStack.isLoggingEnabled());
                {
                    sipStack.getStackLogger().logDebug("Dropping message:  no provider");
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean var040B3845D432851B37CAFD9378AE7CDE_1381102062 = (sipProvider.getSipListener() == null);
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_211073885 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logDebug(
                        "Dropping message:  no sipListener registered!");
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        SIPClientTransaction transaction;
        transaction = (SIPClientTransaction) this.transactionChannel;
        {
            sipDialog = transaction.getDialog(dialogID);
            {
                boolean var52C1FDC72070F15D9943BC0253444AE1_2080563645 = (sipDialog != null && sipDialog.getState() == DialogState.TERMINATED);
                sipDialog = null;
            } //End collapsed parenthetic
        } //End block
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_656517324 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug(
                    "Transaction = " + transaction + " sipDialog = " + sipDialog);
        } //End collapsed parenthetic
        {
            String originalFrom;
            originalFrom = ((SIPRequest) this.transactionChannel.getRequest())
                    .getFromTag();
            {
                boolean var0D7080960CB9367E4F2AA06C27A99A1C_601236536 = (originalFrom == null ^ sipResponse.getFrom().getTag() == null);
                {
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1777974905 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger().logDebug("From tag mismatch -- dropping response");
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                boolean varDCBDF450609B6D366ABF6954C5F40AE5_12299332 = (originalFrom != null
                    && !originalFrom.equalsIgnoreCase(sipResponse.getFrom().getTag()));
                {
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1763964750 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger().logDebug("From tag mismatch -- dropping response");
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean varF4C28C749B6F53EB073755228814859E_1931996516 = (sipStack.isDialogCreated(method) && sipResponse.getStatusCode() != 100
                && sipResponse.getFrom().getTag() != null && sipResponse.getTo().getTag() != null
                && sipDialog == null);
            {
                {
                    boolean varBA1887ABE4E7EB40828929B2F50004ED_688479107 = (sipProvider.isAutomaticDialogSupportEnabled());
                    {
                        {
                            {
                                sipDialog = sipStack.createDialog(
                                (SIPClientTransaction) this.transactionChannel, sipResponse);
                                this.transactionChannel.setDialog(sipDialog, sipResponse
                                .getDialogId(false));
                            } //End block
                        } //End block
                        {
                            sipDialog = this.sipStack.createDialog(sipProvider, sipResponse);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean var2A33A6FB66230F3C763C02B11A31B698_2123338830 = (sipDialog != null && transaction == null
                    && sipDialog.getState() != DialogState.TERMINATED);
                    {
                        {
                            boolean varA57297F1061982CB33F3268F8A8D4904_269735713 = (sipResponse.getStatusCode() / 100 != 2);
                            {
                                {
                                    boolean varA5D47C3A6259BCCCC2265DD1F84B75D4_1410071014 = (sipStack.isLoggingEnabled());
                                    sipStack.getStackLogger().logDebug(
                                "status code != 200 ; statusCode = "
                                        + sipResponse.getStatusCode());
                                } //End collapsed parenthetic
                            } //End block
                            {
                                boolean var6A3DFB971BB99F011A348D516A5DE989_1414099198 = (sipDialog.getState() == DialogState.TERMINATED);
                                {
                                    {
                                        boolean var6FE8ACC5352DCA3449210F8EDED912B3_710119298 = (sipStack.isLoggingEnabled());
                                        {
                                            sipStack.getStackLogger().logDebug(
                                "Dialog is terminated -- dropping response!");
                                        } //End block
                                    } //End collapsed parenthetic
                                    {
                                        boolean varD919ECE2500BE622A07F72F67D931CEB_1399233201 = (sipResponse.getStatusCode() / 100 == 2
                            && sipResponse.getCSeq().getMethod().equals(Request.INVITE));
                                        {
                                            try 
                                            {
                                                Request ackRequest;
                                                ackRequest = sipDialog.createAck(sipResponse.getCSeq()
                                    .getSeqNumber());
                                                sipDialog.sendAck(ackRequest);
                                            } //End block
                                            catch (Exception ex)
                                            {
                                                sipStack.getStackLogger().logError("Error creating ack", ex);
                                            } //End block
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                                {
                                    boolean ackAlreadySent;
                                    ackAlreadySent = false;
                                    {
                                        boolean var403629A75A5A567C164D1E1B78D4DD0C_1552807756 = (sipDialog.isAckSeen() && sipDialog.getLastAckSent() != null);
                                        {
                                            {
                                                boolean varB1FC30C2EF7BA643D3E3FCB6B1D03580_1065216137 = (sipDialog.getLastAckSent().getCSeq().getSeqNumber() == sipResponse
                                .getCSeq().getSeqNumber()
                                && sipResponse.getDialogId(false).equals(
                                        sipDialog.getLastAckSent().getDialogId(false)));
                                                {
                                                    ackAlreadySent = true;
                                                } //End block
                                            } //End collapsed parenthetic
                                        } //End block
                                    } //End collapsed parenthetic
                                    {
                                        boolean var48B96C0860552644EFB088829DD33EF6_7254855 = (ackAlreadySent
                            && sipResponse.getCSeq().getMethod().equals(sipDialog.getMethod()));
                                        {
                                            try 
                                            {
                                                {
                                                    boolean var3EB379B664411110CCE0F3EED18D8CFA_2144316459 = (sipStack.isLoggingEnabled());
                                                    sipStack.getStackLogger().logDebug("resending ACK");
                                                } //End collapsed parenthetic
                                                sipDialog.resendAck();
                                            } //End block
                                            catch (SipException ex)
                                            { }
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_931012031 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug("sending response to TU for processing ");
        } //End collapsed parenthetic
        {
            boolean varC166593AE3B3B1E64B0064A7F65529F8_1068851012 = (sipDialog != null && sipResponse.getStatusCode() != 100
                && sipResponse.getTo().getTag() != null);
            {
                sipDialog.setLastResponse(transaction, sipResponse);
            } //End block
        } //End collapsed parenthetic
        ResponseEventExt responseEvent;
        responseEvent = new ResponseEventExt(sipProvider,
                (ClientTransactionExt) transaction, sipDialog, (Response) sipResponse);
        {
            boolean var2D5D6FEC34FFCB5BC855F59C71930094_973185020 = (sipResponse.getCSeq().getMethod().equals(Request.INVITE));
            {
                ClientTransactionExt originalTx;
                originalTx = this.sipStack.getForkedTransaction(sipResponse
                    .getTransactionId());
                responseEvent.setOriginalTransaction(originalTx);
            } //End block
        } //End collapsed parenthetic
        sipProvider.handleEvent(responseEvent, transaction);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

