package gov.nist.javax.sip;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.507 -0400", hash_original_field = "7C7B65A13B3BC773CE866BFD592AC7E7", hash_generated_field = "B58F2862CC3FB933DFE2CD13D62E4F29")

    protected SIPTransaction transactionChannel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.507 -0400", hash_original_field = "8464C05A1C71DC453DF2370A527F688F", hash_generated_field = "39488158E1B35E48EDB34C41C325AC90")

    protected ListeningPointImpl listeningPoint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.507 -0400", hash_original_field = "37460D4BF2BA47A13FF9D922C4B14B2E", hash_generated_field = "B028268F85C87F49A0E45B93954BF938")

    private SipStackImpl sipStack;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.507 -0400", hash_original_method = "A91C8A8D71CBF898AE2C5B460693B699", hash_generated_method = "481B6844F1AF263D7835463CFF37158A")
    public  DialogFilter(SipStackImpl sipStack) {
        this.sipStack = sipStack;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.508 -0400", hash_original_method = "07FCA8BF1CB05FED9E9EE5BE5B9D0DF8", hash_generated_method = "4AE7860BB0E1BEA627D7E1CD5CFB578B")
    private void sendRequestPendingResponse(SIPRequest sipRequest,
            SIPServerTransaction transaction) {
        SIPResponse sipResponse = sipRequest.createResponse(Response.REQUEST_PENDING);
        ServerHeader serverHeader = MessageFactoryImpl.getDefaultServerHeader();
        {
            sipResponse.setHeader(serverHeader);
        } 
        try 
        {
            RetryAfter retryAfter = new RetryAfter();
            retryAfter.setRetryAfter(1);
            sipResponse.setHeader(retryAfter);
            {
                boolean varB40355E98F037248D6A7B38C6801D163_1378456137 = (sipRequest.getMethod().equals(Request.INVITE));
                {
                    sipStack.addTransactionPendingAck(transaction);
                } 
            } 
            transaction.sendResponse(sipResponse);
            transaction.releaseSem();
        } 
        catch (Exception ex)
        {
            sipStack.getStackLogger().logError("Problem sending error response", ex);
            transaction.releaseSem();
            sipStack.removeTransaction(transaction);
        } 
        addTaint(sipRequest.getTaint());
        addTaint(transaction.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.509 -0400", hash_original_method = "C4ABF2148AD4585DF588E0AB365097FF", hash_generated_method = "E7E8BA52882511FD454E1AE0DE763C8F")
    private void sendBadRequestResponse(SIPRequest sipRequest, SIPServerTransaction transaction,
            String reasonPhrase) {
        SIPResponse sipResponse = sipRequest.createResponse(Response.BAD_REQUEST);
        sipResponse.setReasonPhrase(reasonPhrase);
        ServerHeader serverHeader = MessageFactoryImpl.getDefaultServerHeader();
        {
            sipResponse.setHeader(serverHeader);
        } 
        try 
        {
            {
                boolean varB40355E98F037248D6A7B38C6801D163_1778283592 = (sipRequest.getMethod().equals(Request.INVITE));
                {
                    sipStack.addTransactionPendingAck(transaction);
                } 
            } 
            transaction.sendResponse(sipResponse);
            transaction.releaseSem();
        } 
        catch (Exception ex)
        {
            sipStack.getStackLogger().logError("Problem sending error response", ex);
            transaction.releaseSem();
            sipStack.removeTransaction(transaction);
        } 
        addTaint(sipRequest.getTaint());
        addTaint(transaction.getTaint());
        addTaint(reasonPhrase.getTaint());
        
        
        
            
        
        
            
        
        
            
                
            
            
            
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.509 -0400", hash_original_method = "D6292ED26CFFFD47381D5C093FDBF969", hash_generated_method = "BB1C18F48D4C14BF90348DF61C7F78E6")
    private void sendCallOrTransactionDoesNotExistResponse(SIPRequest sipRequest,
            SIPServerTransaction transaction) {
        SIPResponse sipResponse = sipRequest
                .createResponse(Response.CALL_OR_TRANSACTION_DOES_NOT_EXIST);
        ServerHeader serverHeader = MessageFactoryImpl.getDefaultServerHeader();
        {
            sipResponse.setHeader(serverHeader);
        } 
        try 
        {
            {
                boolean varB40355E98F037248D6A7B38C6801D163_1596142669 = (sipRequest.getMethod().equals(Request.INVITE));
                {
                    sipStack.addTransactionPendingAck(transaction);
                } 
            } 
            transaction.sendResponse(sipResponse);
            transaction.releaseSem();
        } 
        catch (Exception ex)
        {
            sipStack.getStackLogger().logError("Problem sending error response", ex);
            transaction.releaseSem();
            sipStack.removeTransaction(transaction);
        } 
        addTaint(sipRequest.getTaint());
        addTaint(transaction.getTaint());
        
        
                
        
        
            
        
        
            
                
            
            
            
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.510 -0400", hash_original_method = "3FDF2D179E068B8AD4629A716A32BCF6", hash_generated_method = "7A5CF876453FE89C769EC4718C13F40E")
    private void sendLoopDetectedResponse(SIPRequest sipRequest, SIPServerTransaction transaction) {
        SIPResponse sipResponse = sipRequest.createResponse(Response.LOOP_DETECTED);
        ServerHeader serverHeader = MessageFactoryImpl.getDefaultServerHeader();
        {
            sipResponse.setHeader(serverHeader);
        } 
        try 
        {
            sipStack.addTransactionPendingAck(transaction);
            transaction.sendResponse(sipResponse);
            transaction.releaseSem();
        } 
        catch (Exception ex)
        {
            sipStack.getStackLogger().logError("Problem sending error response", ex);
            transaction.releaseSem();
            sipStack.removeTransaction(transaction);
        } 
        addTaint(sipRequest.getTaint());
        addTaint(transaction.getTaint());
        
        
        
        
            
        
        
            
            
            
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.511 -0400", hash_original_method = "1BAB8A1EF49695D9BD2CE878014B3A7C", hash_generated_method = "789A4188049D917859C48BDD97D7B5A0")
    private void sendServerInternalErrorResponse(SIPRequest sipRequest,
            SIPServerTransaction transaction) {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_863666250 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger()
                    .logDebug("Sending 500 response for out of sequence message");
        } 
        SIPResponse sipResponse = sipRequest.createResponse(Response.SERVER_INTERNAL_ERROR);
        sipResponse.setReasonPhrase("Request out of order");
        {
            boolean varE71367B7FC420DF364496FD57FDD6F25_877896965 = (MessageFactoryImpl.getDefaultServerHeader() != null);
            {
                ServerHeader serverHeader = MessageFactoryImpl.getDefaultServerHeader();
                sipResponse.setHeader(serverHeader);
            } 
        } 
        try 
        {
            RetryAfter retryAfter = new RetryAfter();
            retryAfter.setRetryAfter(10);
            sipResponse.setHeader(retryAfter);
            sipStack.addTransactionPendingAck(transaction);
            transaction.sendResponse(sipResponse);
            transaction.releaseSem();
        } 
        catch (Exception ex)
        {
            sipStack.getStackLogger().logError("Problem sending response", ex);
            transaction.releaseSem();
            sipStack.removeTransaction(transaction);
        } 
        addTaint(sipRequest.getTaint());
        addTaint(transaction.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.517 -0400", hash_original_method = "358FFD6F817CCE2A8A6AEFD88EADC0D0", hash_generated_method = "42E093BE61ADAA7686102FFC51E4AA3D")
    public void processRequest(SIPRequest sipRequest, MessageChannel incomingMessageChannel) {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_564810357 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug(
                    "PROCESSING INCOMING REQUEST " + sipRequest + " transactionChannel = "
                            + transactionChannel + " listening point = "
                            + listeningPoint.getIPAddress() + ":" + listeningPoint.getPort());
        } 
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1678727071 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug(
                        "Dropping message: No listening point registered!");
            } 
        } 
        SipStackImpl sipStack = (SipStackImpl) transactionChannel.getSIPStack();
        SipProviderImpl sipProvider = listeningPoint.getProvider();
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_937313473 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug("No provider - dropping !!");
            } 
        } 
        InternalErrorHandler.handleException("Egads! no sip stack!");
        SIPServerTransaction transaction = (SIPServerTransaction) this.transactionChannel;
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_924800294 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug(
                        "transaction state = " + transaction.getState());
            } 
        } 
        String dialogId = sipRequest.getDialogId(true);
        SIPDialog dialog = sipStack.getDialog(dialogId);
        {
            boolean var8C35147A98AFF30DADBF44604DB5F9F7_622996205 = (dialog != null && sipProvider != dialog.getSipProvider());
            {
                Contact contact = dialog.getMyContactHeader();
                {
                    SipUri contactUri = (SipUri) (contact.getAddress().getURI());
                    String ipAddress = contactUri.getHost();
                    int contactPort = contactUri.getPort();
                    String contactTransport = contactUri.getTransportParam();
                    contactTransport = "udp";
                    {
                        {
                            boolean varE2885EA501158E42E31BDF8FAE2DFB15_532029545 = (contactTransport.equals("udp") || contactTransport.equals("tcp"));
                            contactPort = 5060;
                            contactPort = 5061;
                        } 
                    } 
                    {
                        boolean varECBDFD8681BEACCB1C4A54E5EA7A2BE3_408598832 = (ipAddress != null
                        && (!ipAddress.equals(listeningPoint.getIPAddress()) || contactPort != listeningPoint
                                .getPort()));
                        {
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_53603742 = (sipStack.isLoggingEnabled());
                                {
                                    sipStack.getStackLogger().logDebug(
                                "nulling dialog -- listening point mismatch!  " + contactPort
                                        + "  lp port = " + listeningPoint.getPort());
                                } 
                            } 
                            dialog = null;
                        } 
                    } 
                } 
            } 
        } 
        {
            boolean var9B43C7A4BD288E09DE245AB3A76734C6_2082720702 = (sipProvider.isAutomaticDialogSupportEnabled()
                && sipProvider.isDialogErrorsAutomaticallyHandled()
                && sipRequest.getToTag() == null);
            {
                SIPServerTransaction sipServerTransaction = sipStack
                    .findMergedTransaction(sipRequest);
                {
                    this.sendLoopDetectedResponse(sipRequest, transaction);
                } 
            } 
        } 
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_271712635 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("dialogId = " + dialogId);
                sipStack.getStackLogger().logDebug("dialog = " + dialog);
            } 
        } 
        {
            boolean var74DC7DA70403614A0158FCF949AF488C_215198396 = (sipRequest.getHeader(Route.NAME) != null && transaction.getDialog() != null);
            {
                RouteList routes = sipRequest.getRouteHeaders();
                Route route = (Route) routes.getFirst();
                SipUri uri = (SipUri) route.getAddress().getURI();
                int port;
                {
                    boolean var9DB9725AF163E169EDB784F962234379_1837765752 = (uri.getHostPort().hasPort());
                    {
                        port = uri.getHostPort().getPort();
                    } 
                    {
                        {
                            boolean varE06139CF2650C04993A642FB205435F9_801093559 = (listeningPoint.getTransport().equalsIgnoreCase("TLS"));
                            port = 5061;
                            port = 5060;
                        } 
                    } 
                } 
                String host = uri.getHost();
                {
                    boolean var7F13DC40DBFDACDD0C75F94E8076702B_345582287 = ((host.equals(listeningPoint.getIPAddress()) || host
                    .equalsIgnoreCase(listeningPoint.getSentBy()))
                    && port == listeningPoint.getPort());
                    {
                        {
                            boolean varA2EA7B726E8D2955E92EC5CEC24E87FC_1359058796 = (routes.size() == 1);
                            sipRequest.removeHeader(Route.NAME);
                            routes.removeFirst();
                        } 
                    } 
                } 
            } 
        } 
        {
            boolean varD7AF0442E74759AC1FB0D16B64859435_217903278 = (sipRequest.getMethod().equals(Request.REFER) && dialog != null
                && sipProvider.isDialogErrorsAutomaticallyHandled());
            {
                ReferToHeader sipHeader = (ReferToHeader) sipRequest.getHeader(ReferTo.NAME);
                {
                    this
                        .sendBadRequestResponse(sipRequest, transaction,
                                "Refer-To header is missing");
                } 
                SIPTransaction lastTransaction = ((SIPDialog) dialog).getLastTransaction();
                {
                    boolean var98297FAF3995B52999361BFB5CF06500_833125322 = (lastTransaction != null  && sipProvider.isDialogErrorsAutomaticallyHandled());
                    {
                        SIPRequest lastRequest = (SIPRequest) lastTransaction.getRequest();
                        {
                            {
                                boolean varB83F47265B2EAB2CC6FE0D4FE115165B_2029855832 = (!((SIPDialog) dialog).isAckSeen()   
                            && lastRequest.getMethod().equals(Request.INVITE));
                                {
                                    this.sendRequestPendingResponse(sipRequest, transaction);
                                } 
                            } 
                        } 
                        {
                            long cseqno = lastRequest.getCSeqHeader().getSeqNumber();
                            String method = lastRequest.getMethod();
                            {
                                boolean varD72140EEF39752E9B60D36C18F8B8CDE_10501583 = (method.equals(Request.INVITE) && !dialog.isAckSent(cseqno));
                                {
                                    this.sendRequestPendingResponse(sipRequest, transaction);
                                } 
                            } 
                        } 
                    } 
                } 
            } 
            {
                boolean var0C5EC9F754984B9197534DAE31433F4E_1772986071 = (sipRequest.getMethod().equals(Request.UPDATE));
                {
                    {
                        boolean varF75E99F53F801F7147949B29F933FAE6_1502395183 = (sipProvider.isAutomaticDialogSupportEnabled() && dialog == null);
                        {
                            this.sendCallOrTransactionDoesNotExistResponse(sipRequest, transaction);
                        } 
                    } 
                } 
                {
                    boolean varF16B36B5D25AE0530430F54B0EB17398_904550671 = (sipRequest.getMethod().equals(Request.ACK));
                    {
                        {
                            boolean var73A6E09F014EBAF3EE18BEFDB7721839_477277722 = (transaction != null && transaction.isInviteTransaction());
                            {
                                {
                                    boolean varA5D47C3A6259BCCCC2265DD1F84B75D4_1362121346 = (sipStack.isLoggingEnabled());
                                    sipStack.getStackLogger().logDebug("Processing ACK for INVITE Tx ");
                                } 
                            } 
                            {
                                {
                                    boolean varA5D47C3A6259BCCCC2265DD1F84B75D4_2096714786 = (sipStack.isLoggingEnabled());
                                    sipStack.getStackLogger().logDebug("Processing ACK for dialog " + dialog);
                                } 
                                {
                                    {
                                        boolean var6FE8ACC5352DCA3449210F8EDED912B3_92601977 = (sipStack.isLoggingEnabled());
                                        {
                                            sipStack.getStackLogger().logDebug(
                                "Dialog does not exist " + sipRequest.getFirstLine()
                                        + " isServerTransaction = " + true);
                                        } 
                                    } 
                                    SIPServerTransaction st = sipStack
                            .getRetransmissionAlertTransaction(dialogId);
                                    {
                                        boolean varE352A1C183E4E601EF778AF0E529DA77_122765886 = (st != null && st.isRetransmissionAlertEnabled());
                                        {
                                            st.disableRetransmissionAlerts();
                                        } 
                                    } 
                                    SIPServerTransaction ackTransaction = sipStack
                            .findTransactionPendingAck(sipRequest);
                                    {
                                        {
                                            boolean var974BD9A3C84119780B64DA7C8AA64368_1222604664 = (sipStack.isLoggingEnabled());
                                            sipStack.getStackLogger().logDebug("Found Tx pending ACK");
                                        } 
                                        try 
                                        {
                                            ackTransaction.setAckSeen();
                                            sipStack.removeTransaction(ackTransaction);
                                            sipStack.removeTransactionPendingAck(ackTransaction);
                                        } 
                                        catch (Exception ex)
                                        {
                                            {
                                                boolean varC8BF86FC1141E4E4181585335ACFB1D1_783452089 = (sipStack.isLoggingEnabled());
                                                {
                                                    sipStack.getStackLogger().logError(
                                        "Problem terminating transaction", ex);
                                                } 
                                            } 
                                        } 
                                    } 
                                } 
                                {
                                    {
                                        boolean varA0FE1183F2132979E9E0AD074A782F58_1623376615 = (!dialog.handleAck(transaction));
                                        {
                                            {
                                                boolean varEB868D3ACE63E50D8696CFBB21111866_2036975723 = (!dialog.isSequnceNumberValidation());
                                                {
                                                    {
                                                        boolean var1CA58CF859FCBE04EE708A028DDCA412_466389125 = (sipStack.isLoggingEnabled());
                                                        {
                                                            sipStack.getStackLogger().logDebug(
                                        "Dialog exists with loose dialog validation "
                                                + sipRequest.getFirstLine()
                                                + " isServerTransaction = " + true + " dialog = "
                                                + dialog.getDialogId());
                                                        } 
                                                    } 
                                                    SIPServerTransaction st = sipStack
                                    .getRetransmissionAlertTransaction(dialogId);
                                                    {
                                                        boolean var73DA9E229925D1E2E4876032DE278F33_2061559614 = (st != null && st.isRetransmissionAlertEnabled());
                                                        {
                                                            st.disableRetransmissionAlerts();
                                                        } 
                                                    } 
                                                } 
                                                {
                                                    {
                                                        boolean var1CA58CF859FCBE04EE708A028DDCA412_1020344041 = (sipStack.isLoggingEnabled());
                                                        {
                                                            sipStack.getStackLogger().logDebug(
                                        "Dropping ACK - cannot find a transaction or dialog");
                                                        } 
                                                    } 
                                                    SIPServerTransaction ackTransaction = sipStack
                                    .findTransactionPendingAck(sipRequest);
                                                    {
                                                        {
                                                            boolean var240DFB7B2BD3D164A79626CA77291C20_148158716 = (sipStack.isLoggingEnabled());
                                                            sipStack.getStackLogger().logDebug("Found Tx pending ACK");
                                                        } 
                                                        try 
                                                        {
                                                            ackTransaction.setAckSeen();
                                                            sipStack.removeTransaction(ackTransaction);
                                                            sipStack.removeTransactionPendingAck(ackTransaction);
                                                        } 
                                                        catch (Exception ex)
                                                        {
                                                            {
                                                                boolean varA0D95B65CC2D70A2B0675F3ACBF8689B_1282599367 = (sipStack.isLoggingEnabled());
                                                                {
                                                                    sipStack.getStackLogger().logError(
                                                "Problem terminating transaction", ex);
                                                                } 
                                                            } 
                                                        } 
                                                    } 
                                                } 
                                            } 
                                        } 
                                        {
                                            transaction.passToListener();
                                            dialog.addTransaction(transaction);
                                            dialog.addRoute(sipRequest);
                                            transaction.setDialog(dialog, dialogId);
                                            {
                                                boolean var1A7C116BDB0B16BEED8B2FBD8272556D_326994437 = (sipRequest.getMethod().equals(Request.INVITE)
                                && sipProvider.isDialogErrorsAutomaticallyHandled());
                                                {
                                                    sipStack.putInMergeTable(transaction, sipRequest);
                                                } 
                                            } 
                                            {
                                                try 
                                                {
                                                    sipStack.addTransaction(transaction);
                                                    transaction.scheduleAckRemoval();
                                                } 
                                                catch (IOException ex)
                                                { }
                                            } 
                                            {
                                                transaction.setMapped(true);
                                            } 
                                        } 
                                    } 
                                } 
                            } 
                        } 
                    } 
                    {
                        boolean var4359D03ED24BB6A1C73AA4474DB586FE_532599892 = (sipRequest.getMethod().equals(Request.PRACK));
                        {
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_165624876 = (sipStack.isLoggingEnabled());
                                sipStack.getStackLogger().logDebug("Processing PRACK for dialog " + dialog);
                            } 
                            {
                                boolean varB8381F2D44FFEF8EDC556F52DF90FA28_1436208356 = (dialog == null && sipProvider.isAutomaticDialogSupportEnabled());
                                {
                                    {
                                        boolean var6FE8ACC5352DCA3449210F8EDED912B3_774608987 = (sipStack.isLoggingEnabled());
                                        {
                                            sipStack.getStackLogger().logDebug(
                            "Dialog does not exist " + sipRequest.getFirstLine()
                                    + " isServerTransaction = " + true);
                                        } 
                                    } 
                                    {
                                        boolean var6FE8ACC5352DCA3449210F8EDED912B3_1987728553 = (sipStack.isLoggingEnabled());
                                        {
                                            sipStack
                            .getStackLogger()
                            .logDebug(
                                    "Sending 481 for PRACK - automatic dialog support is enabled -- cant find dialog!");
                                        } 
                                    } 
                                    SIPResponse notExist = sipRequest
                        .createResponse(Response.CALL_OR_TRANSACTION_DOES_NOT_EXIST);
                                    try 
                                    {
                                        sipProvider.sendResponse(notExist);
                                    } 
                                    catch (SipException e)
                                    {
                                        sipStack.getStackLogger().logError("error sending response", e);
                                    } 
                                    {
                                        sipStack.removeTransaction(transaction);
                                        transaction.releaseSem();
                                    } 
                                } 
                                {
                                    {
                                        boolean varA3A0470A7974A75D85F1E38AA926110E_725125542 = (!dialog.handlePrack(sipRequest));
                                        {
                                            {
                                                boolean varC8BF86FC1141E4E4181585335ACFB1D1_1879231156 = (sipStack.isLoggingEnabled());
                                                sipStack.getStackLogger().logDebug("Dropping out of sequence PRACK ");
                                            } 
                                            {
                                                sipStack.removeTransaction(transaction);
                                                transaction.releaseSem();
                                            } 
                                        } 
                                        {
                                            try 
                                            {
                                                sipStack.addTransaction(transaction);
                                                dialog.addTransaction(transaction);
                                                dialog.addRoute(sipRequest);
                                                transaction.setDialog(dialog, dialogId);
                                            } 
                                            catch (Exception ex)
                                            {
                                                InternalErrorHandler.handleException(ex);
                                            } 
                                        } 
                                    } 
                                } 
                                {
                                    {
                                        boolean var6FE8ACC5352DCA3449210F8EDED912B3_546480379 = (sipStack.isLoggingEnabled());
                                        sipStack.getStackLogger().logDebug(
                            "Processing PRACK without a DIALOG -- this must be a proxy element");
                                    } 
                                } 
                            } 
                        } 
                        {
                            boolean var223469E3016F4CBAAE79AF42372AB5C4_497009176 = (sipRequest.getMethod().equals(Request.BYE));
                            {
                                {
                                    boolean var8118EA94EB7FF7E528D9675F7D7382EF_1517316037 = (dialog != null && !dialog.isRequestConsumable(sipRequest));
                                    {
                                        {
                                            boolean var974BD9A3C84119780B64DA7C8AA64368_1534614025 = (sipStack.isLoggingEnabled());
                                            sipStack.getStackLogger().logDebug(
                            "Dropping out of sequence BYE " + dialog.getRemoteSeqNumber() + " "
                                    + sipRequest.getCSeq().getSeqNumber());
                                        } 
                                        {
                                            boolean var91C43A90EFA51B9EB63058171E9F202A_692226740 = (dialog.getRemoteSeqNumber() >= sipRequest.getCSeq().getSeqNumber()
                        && transaction.getState() == TransactionState.TRYING);
                                            {
                                                this.sendServerInternalErrorResponse(sipRequest, transaction);
                                            } 
                                        } 
                                        sipStack.removeTransaction(transaction);
                                    } 
                                    {
                                        boolean var7E61F277ADAB84A3B118D7ECFA89E811_1518846839 = (dialog == null && sipProvider.isAutomaticDialogSupportEnabled());
                                        {
                                            SIPResponse response = sipRequest
                        .createResponse(Response.CALL_OR_TRANSACTION_DOES_NOT_EXIST);
                                            response.setReasonPhrase("Dialog Not Found");
                                            {
                                                boolean varC8BF86FC1141E4E4181585335ACFB1D1_399959586 = (sipStack.isLoggingEnabled());
                                                sipStack.getStackLogger().logDebug(
                            "dropping request -- automatic dialog "
                                    + "support enabled and dialog does not exist!");
                                            } 
                                            try 
                                            {
                                                transaction.sendResponse(response);
                                            } 
                                            catch (SipException ex)
                                            {
                                                sipStack.getStackLogger().logError("Error in sending response", ex);
                                            } 
                                            {
                                                sipStack.removeTransaction(transaction);
                                                transaction.releaseSem();
                                                transaction = null;
                                            } 
                                        } 
                                    } 
                                } 
                                {
                                    try 
                                    {
                                        {
                                            boolean varD1FB173C06A75FCF4E8AC458835BFF6C_914824765 = (sipProvider == dialog.getSipProvider());
                                            {
                                                sipStack.addTransaction(transaction);
                                                dialog.addTransaction(transaction);
                                                transaction.setDialog(dialog, dialogId);
                                            } 
                                        } 
                                    } 
                                    catch (IOException ex)
                                    {
                                        InternalErrorHandler.handleException(ex);
                                    } 
                                } 
                                {
                                    boolean varA5D47C3A6259BCCCC2265DD1F84B75D4_1995628730 = (sipStack.isLoggingEnabled());
                                    {
                                        sipStack.getStackLogger().logDebug(
                        "BYE Tx = " + transaction + " isMapped ="
                                + transaction.isTransactionMapped());
                                    } 
                                } 
                            } 
                            {
                                boolean var5A587D44C8FFFD0687558BABDD2E64A8_972192547 = (sipRequest.getMethod().equals(Request.CANCEL));
                                {
                                    SIPServerTransaction st = (SIPServerTransaction) sipStack.findCancelTransaction(
                    sipRequest, true);
                                    {
                                        boolean var6FE8ACC5352DCA3449210F8EDED912B3_2082753041 = (sipStack.isLoggingEnabled());
                                        {
                                            sipStack.getStackLogger().logDebug(
                        "Got a CANCEL, InviteServerTx = " + st + " cancel Server Tx ID = "
                                + transaction + " isMapped = "
                                + transaction.isTransactionMapped());
                                        } 
                                    } 
                                    {
                                        boolean var36F2407ABDDD4CF270E5152D58918383_801581009 = (sipRequest.getMethod().equals(Request.CANCEL));
                                        {
                                            {
                                                boolean var910A93B09BD8B46A76494278BD78EE19_1110104382 = (st != null && st.getState() == SIPTransaction.TERMINATED_STATE);
                                                {
                                                    {
                                                        boolean var1CA58CF859FCBE04EE708A028DDCA412_241923856 = (sipStack.isLoggingEnabled());
                                                        sipStack.getStackLogger().logDebug("Too late to cancel Transaction");
                                                    } 
                                                    try 
                                                    {
                                                        transaction.sendResponse(sipRequest.createResponse(Response.OK));
                                                    } 
                                                    catch (Exception ex)
                                                    {
                                                        {
                                                            boolean var4FB79B1E41CF851478BD46FA49031E2A_1063407752 = (ex.getCause() != null && ex.getCause() instanceof IOException);
                                                            {
                                                                st.raiseIOExceptionEvent();
                                                            } 
                                                        } 
                                                    } 
                                                } 
                                            } 
                                            {
                                                boolean varC8BF86FC1141E4E4181585335ACFB1D1_423646968 = (sipStack.isLoggingEnabled());
                                                sipStack.getStackLogger().logDebug("Cancel transaction = " + st);
                                            } 
                                        } 
                                    } 
                                    {
                                        boolean var96EEFF7E2538EC7D178603BD843A63B5_1208407058 = (transaction != null && st != null && st.getDialog() != null);
                                        {
                                            transaction.setDialog((SIPDialog) st.getDialog(), dialogId);
                                            dialog = (SIPDialog) st.getDialog();
                                        } 
                                        {
                                            boolean var89A34BE79F626089DE9A46AA3D4D5644_1676842620 = (st == null && sipProvider.isAutomaticDialogSupportEnabled()
                    && transaction != null);
                                            {
                                                SIPResponse response = sipRequest
                        .createResponse(Response.CALL_OR_TRANSACTION_DOES_NOT_EXIST);
                                                {
                                                    boolean var3EB379B664411110CCE0F3EED18D8CFA_1538173451 = (sipStack.isLoggingEnabled());
                                                    {
                                                        sipStack.getStackLogger().logDebug(
                            "dropping request -- automatic dialog support "
                                    + "enabled and INVITE ST does not exist!");
                                                    } 
                                                } 
                                                try 
                                                {
                                                    sipProvider.sendResponse(response);
                                                } 
                                                catch (SipException ex)
                                                {
                                                    InternalErrorHandler.handleException(ex);
                                                } 
                                                {
                                                    sipStack.removeTransaction(transaction);
                                                    transaction.releaseSem();
                                                } 
                                            } 
                                        } 
                                    } 
                                    {
                                        try 
                                        {
                                            {
                                                sipStack.addTransaction(transaction);
                                                transaction.setPassToListener();
                                                transaction.setInviteTransaction(st);
                                                st.acquireSem();
                                            } 
                                        } 
                                        catch (Exception ex)
                                        {
                                            InternalErrorHandler.handleException(ex);
                                        } 
                                    } 
                                } 
                                {
                                    boolean varB4F65467E51F8CADB8FA727E0038ECE5_502929973 = (sipRequest.getMethod().equals(Request.INVITE));
                                    {
                                        SIPTransaction lastTransaction;
                                        lastTransaction = null;
                                        lastTransaction = dialog
                    .getInviteTransaction();
                                        {
                                            boolean varFFF6C63A745186E6359C3F0ACC832311_800680578 = (dialog != null && transaction != null && lastTransaction != null
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
                                                    boolean var3EB379B664411110CCE0F3EED18D8CFA_553790931 = (sipStack.isLoggingEnabled());
                                                    {
                                                        sipStack.getStackLogger().logDebug(
                            "Sending 500 response for out of sequence message");
                                                    } 
                                                } 
                                                this.sendServerInternalErrorResponse(sipRequest, transaction);
                                            } 
                                        } 
                                        lastTransaction = (dialog == null ? null : dialog.getLastTransaction());
                                        {
                                            boolean varDC33FCDDD5DAA373F0357E066C3EFCCD_1299530848 = (dialog != null
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
                                                    boolean var3EB379B664411110CCE0F3EED18D8CFA_2057738635 = (sipStack.isLoggingEnabled());
                                                    {
                                                        sipStack.getStackLogger().logDebug(
                            "Sending 491 response for client Dialog ACK not sent.");
                                                    } 
                                                } 
                                                this.sendRequestPendingResponse(sipRequest, transaction);
                                            } 
                                        } 
                                        {
                                            boolean var408778EC92ADB5D4F0BF80EA83D1A422_2142393068 = (dialog != null && lastTransaction != null
                    && sipProvider.isDialogErrorsAutomaticallyHandled()
                    && lastTransaction.isInviteTransaction()
                    && lastTransaction instanceof ServerTransaction && !dialog.isAckSeen());
                                            {
                                                {
                                                    boolean var3EB379B664411110CCE0F3EED18D8CFA_1661549975 = (sipStack.isLoggingEnabled());
                                                    {
                                                        sipStack.getStackLogger().logDebug(
                            "Sending 491 response for server Dialog ACK not seen.");
                                                    } 
                                                } 
                                                this.sendRequestPendingResponse(sipRequest, transaction);
                                            } 
                                        } 
                                    } 
                                } 
                            } 
                        } 
                    } 
                } 
            } 
        } 
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1753418776 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug(
                    "CHECK FOR OUT OF SEQ MESSAGE " + dialog + " transaction " + transaction);
            } 
        } 
        {
            boolean var48BDD4FCB5B9B348DAF5CF27ABA783E4_955039427 = (dialog != null && transaction != null && !sipRequest.getMethod().equals(Request.BYE)
                && !sipRequest.getMethod().equals(Request.CANCEL)
                && !sipRequest.getMethod().equals(Request.ACK)
                && !sipRequest.getMethod().equals(Request.PRACK));
            {
                {
                    boolean var5E9F871F958E5238EF0D614546DF8D4F_1465986086 = (!dialog.isRequestConsumable(sipRequest));
                    {
                        {
                            boolean var2AB968A8303910EE00F810B6DE3410F9_1726263191 = (sipStack.isLoggingEnabled());
                            {
                                sipStack.getStackLogger().logDebug(
                            "Dropping out of sequence message " + dialog.getRemoteSeqNumber()
                                    + " " + sipRequest.getCSeq());
                            } 
                        } 
                        {
                            boolean var97E8BF7CC65B132656689558BFB89C51_974774583 = (dialog.getRemoteSeqNumber() >= sipRequest.getCSeq().getSeqNumber()
                        && sipProvider.isDialogErrorsAutomaticallyHandled()
                        && (transaction.getState() == TransactionState.TRYING || transaction
                                .getState() == TransactionState.PROCEEDING));
                            {
                                this.sendServerInternalErrorResponse(sipRequest, transaction);
                            } 
                        } 
                    } 
                } 
                try 
                {
                    {
                        boolean var57AD5EA186EDB651D8CE5AB4BB561AE2_1763282641 = (sipProvider == dialog.getSipProvider());
                        {
                            sipStack.addTransaction(transaction);
                            dialog.addTransaction(transaction);
                            dialog.addRoute(sipRequest);
                            transaction.setDialog(dialog, dialogId);
                        } 
                    } 
                } 
                catch (IOException ex)
                {
                    transaction.raiseIOExceptionEvent();
                    sipStack.removeTransaction(transaction);
                } 
            } 
        } 
        RequestEvent sipEvent;
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_279705321 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug(
                    sipRequest.getMethod() + " transaction.isMapped = "
                            + transaction.isTransactionMapped());
            } 
        } 
        {
            boolean var06524EA1A95D3E7F1E9D8CA11A51708A_128632847 = (dialog == null && sipRequest.getMethod().equals(Request.NOTIFY));
            {
                SIPClientTransaction pendingSubscribeClientTx = sipStack.findSubscribeTransaction(
                    sipRequest, listeningPoint);
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_2053492557 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logDebug(
                        "PROCESSING NOTIFY  DIALOG == null " + pendingSubscribeClientTx);
                    } 
                } 
                {
                    boolean var1B981CBAC8C463A2565330106D8D8AE3_1213240548 = (sipProvider.isAutomaticDialogSupportEnabled() && pendingSubscribeClientTx == null
                    && !sipStack.deliverUnsolicitedNotify);
                    {
                        try 
                        {
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_298142140 = (sipStack.isLoggingEnabled());
                                {
                                    sipStack.getStackLogger().logDebug(
                                "Could not find Subscription for Notify Tx.");
                                } 
                            } 
                            Response errorResponse = sipRequest
                            .createResponse(Response.CALL_OR_TRANSACTION_DOES_NOT_EXIST);
                            errorResponse.setReasonPhrase("Subscription does not exist");
                            sipProvider.sendResponse(errorResponse);
                        } 
                        catch (Exception ex)
                        {
                            sipStack.getStackLogger().logError(
                            "Exception while sending error response statelessly", ex);
                        } 
                    } 
                } 
                {
                    transaction.setPendingSubscribe(pendingSubscribeClientTx);
                    SIPDialog subscriptionDialog = (SIPDialog) pendingSubscribeClientTx
                        .getDefaultDialog();
                    {
                        boolean var0F6E68A7D3D6E67E47CCDE3F6F21AC95_2089774918 = (subscriptionDialog == null || subscriptionDialog.getDialogId() == null
                        || !subscriptionDialog.getDialogId().equals(dialogId));
                        {
                            {
                                boolean var06C7385D21A09BE1F538DB3A4C26CF1A_1795095607 = (subscriptionDialog != null && subscriptionDialog.getDialogId() == null);
                                {
                                    subscriptionDialog.setDialogId(dialogId);
                                } 
                                {
                                    subscriptionDialog = pendingSubscribeClientTx.getDialog(dialogId);
                                } 
                            } 
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_50613306 = (sipStack.isLoggingEnabled());
                                {
                                    sipStack.getStackLogger().logDebug(
                                "PROCESSING NOTIFY Subscribe DIALOG " + subscriptionDialog);
                                } 
                            } 
                            {
                                boolean var61264EA7CBE984CBB241AF426F48C4BB_736512242 = (subscriptionDialog == null
                            && (sipProvider.isAutomaticDialogSupportEnabled() || pendingSubscribeClientTx
                                    .getDefaultDialog() != null));
                                {
                                    Event event = (Event) sipRequest.getHeader(EventHeader.NAME);
                                    {
                                        boolean var7551F67C46A9BF2F69F8DC249417BE87_1767842739 = (sipStack.isEventForked(event.getEventType()));
                                        {
                                            subscriptionDialog = SIPDialog.createFromNOTIFY(
                                    pendingSubscribeClientTx, transaction);
                                        } 
                                    } 
                                } 
                            } 
                            {
                                transaction.setDialog(subscriptionDialog, dialogId);
                                subscriptionDialog.setState(DialogState.CONFIRMED.getValue());
                                sipStack.putDialog(subscriptionDialog);
                                pendingSubscribeClientTx.setDialog(subscriptionDialog, dialogId);
                                {
                                    boolean var56EA1424ACFA2A47121556050BD2E6E4_650930241 = (!transaction.isTransactionMapped());
                                    {
                                        this.sipStack.mapTransaction(transaction);
                                        transaction.setPassToListener();
                                        try 
                                        {
                                            this.sipStack.addTransaction(transaction);
                                        } 
                                        catch (Exception ex)
                                        { }
                                    } 
                                } 
                            } 
                        } 
                        {
                            transaction.setDialog(subscriptionDialog, dialogId);
                            dialog = subscriptionDialog;
                            {
                                boolean var733DB0B9FD969609EE0DCA90A3371EAE_1689736330 = (!transaction.isTransactionMapped());
                                {
                                    this.sipStack.mapTransaction(transaction);
                                    transaction.setPassToListener();
                                    try 
                                    {
                                        this.sipStack.addTransaction(transaction);
                                    } 
                                    catch (Exception ex)
                                    { }
                                } 
                            } 
                            sipStack.putDialog(subscriptionDialog);
                            {
                                subscriptionDialog.addTransaction(pendingSubscribeClientTx);
                                pendingSubscribeClientTx.setDialog(subscriptionDialog, dialogId);
                            } 
                        } 
                    } 
                    {
                        boolean varCD4C864AAD0BDABE3381B0E19A45E3EC_1831394344 = (transaction != null
                        && ((SIPServerTransaction) transaction).isTransactionMapped());
                        {
                            sipEvent = new RequestEvent((SipProvider) sipProvider,
                            (ServerTransaction) transaction, subscriptionDialog,
                            (Request) sipRequest);
                        } 
                        {
                            sipEvent = new RequestEvent((SipProvider) sipProvider, null,
                            subscriptionDialog, (Request) sipRequest);
                        } 
                    } 
                } 
                {
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_711397331 = (sipStack.isLoggingEnabled());
                        {
                            sipStack.getStackLogger().logDebug("could not find subscribe tx");
                        } 
                    } 
                    sipEvent = new RequestEvent(sipProvider, null, null, (Request) sipRequest);
                } 
            } 
            {
                {
                    boolean var1F897FC6A02886EFEA9EFE79510B36CC_301081846 = (transaction != null
                    && (((SIPServerTransaction) transaction).isTransactionMapped()));
                    {
                        sipEvent = new RequestEvent(sipProvider, (ServerTransaction) transaction, dialog,
                        (Request) sipRequest);
                    } 
                    {
                        sipEvent = new RequestEvent(sipProvider, null, dialog, (Request) sipRequest);
                    } 
                } 
            } 
        } 
        sipProvider.handleEvent(sipEvent, transaction);
        addTaint(sipRequest.getTaint());
        addTaint(incomingMessageChannel.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.520 -0400", hash_original_method = "4FD6D5D7FFBD58CDE4927F751F9B55A3", hash_generated_method = "483A7DE0FB7FD7EF7D336E2B9FE639BF")
    public void processResponse(SIPResponse response, MessageChannel incomingMessageChannel,
            SIPDialog dialog) {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1188539234 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug(
                    "PROCESSING INCOMING RESPONSE" + response.encodeMessage());
            } 
        } 
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_593290229 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logError(
                        "Dropping message: No listening point" + " registered!");
            } 
        } 
        {
            boolean varE5AAF51FD8C4BE95480F9A8330DA6C95_362053942 = (sipStack.checkBranchId() && !Utils.getInstance().responseBelongsToUs(response));
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_215947185 = (sipStack.isLoggingEnabled());
                    {
                        sipStack
                        .getStackLogger()
                        .logError(
                                "Dropping response - topmost VIA header does not originate from this stack");
                    } 
                } 
            } 
        } 
        SipProviderImpl sipProvider = listeningPoint.getProvider();
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1463418598 = (sipStack.isLoggingEnabled());
                {
                    sipStack.getStackLogger().logError("Dropping message:  no provider");
                } 
            } 
        } 
        {
            boolean var040B3845D432851B37CAFD9378AE7CDE_203320467 = (sipProvider.getSipListener() == null);
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_176483243 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logError("No listener -- dropping response!");
                    } 
                } 
            } 
        } 
        SIPClientTransaction transaction = (SIPClientTransaction) this.transactionChannel;
        SipStackImpl sipStackImpl = sipProvider.sipStack;
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_493507557 = (sipStack.isLoggingEnabled());
            {
                sipStackImpl.getStackLogger().logDebug("Transaction = " + transaction);
            } 
        } 
        {
            {
                {
                    boolean varE7B175AF8865034C7D61EB8B89828EB1_160624576 = (response.getStatusCode() / 100 != 2);
                    {
                        {
                            boolean var2AB968A8303910EE00F810B6DE3410F9_1180397182 = (sipStack.isLoggingEnabled());
                            {
                                sipStack
                                .getStackLogger()
                                .logDebug(
                                        "Response is not a final response and dialog is found for response -- dropping response!");
                            } 
                        } 
                    } 
                    {
                        boolean varF1186D828C527F0FC804545C83D3B2C4_2050115466 = (dialog.getState() == DialogState.TERMINATED);
                        {
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_304964627 = (sipStack.isLoggingEnabled());
                                {
                                    sipStack.getStackLogger().logDebug(
                                "Dialog is terminated -- dropping response!");
                                } 
                            } 
                        } 
                        {
                            boolean ackAlreadySent = false;
                            {
                                boolean varD174CA822C582B50295D667097D2B4C3_339079399 = (dialog.isAckSeen() && dialog.getLastAckSent() != null);
                                {
                                    {
                                        boolean var5F4DE3FF9BFD4FA91AED336B5BA1404F_2143792117 = (dialog.getLastAckSent().getCSeq().getSeqNumber() == response
                                .getCSeq().getSeqNumber());
                                        {
                                            ackAlreadySent = true;
                                        } 
                                    } 
                                } 
                            } 
                            {
                                boolean varF26458E3699544D453D8368FD052D8A4_2003682662 = (ackAlreadySent
                            && response.getCSeq().getMethod().equals(dialog.getMethod()));
                                {
                                    try 
                                    {
                                        {
                                            boolean var974BD9A3C84119780B64DA7C8AA64368_777934381 = (sipStack.isLoggingEnabled());
                                            {
                                                sipStack.getStackLogger().logDebug(
                                        "Retransmission of OK detected: Resending last ACK");
                                            } 
                                        } 
                                        dialog.resendAck();
                                    } 
                                    catch (SipException ex)
                                    {
                                        sipStack.getStackLogger().logError("could not resend ack", ex);
                                    } 
                                } 
                            } 
                        } 
                    } 
                } 
            } 
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1317998650 = (sipStack.isLoggingEnabled());
                {
                    sipStack.getStackLogger().logDebug(
                        "could not find tx, handling statelessly Dialog =  " + dialog);
                } 
            } 
            ResponseEventExt sipEvent = new ResponseEventExt(sipProvider, transaction, dialog,
                    (Response) response);
            {
                boolean var007768642FD4E3B95AE9722E749A6203_1158572379 = (response.getCSeqHeader().getMethod().equals(Request.INVITE));
                {
                    SIPClientTransaction forked = this.sipStack.getForkedTransaction(response
                        .getTransactionId());
                    sipEvent.setOriginalTransaction(forked);
                } 
            } 
            sipProvider.handleEvent(sipEvent, transaction);
        } 
        ResponseEventExt responseEvent = null;
        responseEvent = new ResponseEventExt(sipProvider, (ClientTransactionExt) transaction,
                dialog, (Response) response);
        {
            boolean varA55C1203D27CB1F1AE2EDB7445ACAD7D_1251395482 = (response.getCSeqHeader().getMethod().equals(Request.INVITE));
            {
                SIPClientTransaction forked = this.sipStack.getForkedTransaction(response
                    .getTransactionId());
                responseEvent.setOriginalTransaction(forked);
            } 
        } 
        {
            boolean var3BD152FD822A20243698FAE63282F587_1189355223 = (dialog != null && response.getStatusCode() != 100);
            {
                dialog.setLastResponse(transaction, response);
                transaction.setDialog(dialog, dialog.getDialogId());
            } 
        } 
        sipProvider.handleEvent(responseEvent, transaction);
        addTaint(response.getTaint());
        addTaint(incomingMessageChannel.getTaint());
        addTaint(dialog.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.521 -0400", hash_original_method = "45F8896428832201E8BC8983A22C5151", hash_generated_method = "D1BCBF293A62B685B88F3184ED50CE26")
    public String getProcessingInfo() {
        String varB4EAC82CA7396A68D541C85D26508E83_1919246797 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1919246797 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1919246797.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1919246797;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.524 -0400", hash_original_method = "913AD64E566DC17432B7074017A68B2C", hash_generated_method = "17591A391BBA6A00605B0A2AC28C2541")
    public void processResponse(SIPResponse sipResponse, MessageChannel incomingChannel) {
        String dialogID = sipResponse.getDialogId(false);
        SIPDialog sipDialog = this.sipStack.getDialog(dialogID);
        String method = sipResponse.getCSeq().getMethod();
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_245381920 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug(
                    "PROCESSING INCOMING RESPONSE: " + sipResponse.encodeMessage());
            } 
        } 
        {
            boolean var628EC40CE8B4405B3393CE579584B6B9_946556002 = (sipStack.checkBranchId() && !Utils.getInstance().responseBelongsToUs(sipResponse));
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1336434839 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logError("Detected stray response -- dropping");
                    } 
                } 
            } 
        } 
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1882925835 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug(
                        "Dropping message: No listening point" + " registered!");
            } 
        } 
        SipProviderImpl sipProvider = listeningPoint.getProvider();
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1140673504 = (sipStack.isLoggingEnabled());
                {
                    sipStack.getStackLogger().logDebug("Dropping message:  no provider");
                } 
            } 
        } 
        {
            boolean var040B3845D432851B37CAFD9378AE7CDE_782360936 = (sipProvider.getSipListener() == null);
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1860852221 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logDebug(
                        "Dropping message:  no sipListener registered!");
                    } 
                } 
            } 
        } 
        SIPClientTransaction transaction = (SIPClientTransaction) this.transactionChannel;
        {
            sipDialog = transaction.getDialog(dialogID);
            {
                boolean var52C1FDC72070F15D9943BC0253444AE1_1468380333 = (sipDialog != null && sipDialog.getState() == DialogState.TERMINATED);
                sipDialog = null;
            } 
        } 
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1024503993 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug(
                    "Transaction = " + transaction + " sipDialog = " + sipDialog);
        } 
        {
            String originalFrom = ((SIPRequest) this.transactionChannel.getRequest())
                    .getFromTag();
            {
                boolean var0D7080960CB9367E4F2AA06C27A99A1C_2001561431 = (originalFrom == null ^ sipResponse.getFrom().getTag() == null);
                {
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1373217965 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger().logDebug("From tag mismatch -- dropping response");
                    } 
                } 
            } 
            {
                boolean varDCBDF450609B6D366ABF6954C5F40AE5_1866079054 = (originalFrom != null
                    && !originalFrom.equalsIgnoreCase(sipResponse.getFrom().getTag()));
                {
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_157360548 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger().logDebug("From tag mismatch -- dropping response");
                    } 
                } 
            } 
        } 
        {
            boolean varF4C28C749B6F53EB073755228814859E_1113079766 = (sipStack.isDialogCreated(method) && sipResponse.getStatusCode() != 100
                && sipResponse.getFrom().getTag() != null && sipResponse.getTo().getTag() != null
                && sipDialog == null);
            {
                {
                    boolean varBA1887ABE4E7EB40828929B2F50004ED_1721440282 = (sipProvider.isAutomaticDialogSupportEnabled());
                    {
                        {
                            {
                                sipDialog = sipStack.createDialog(
                                (SIPClientTransaction) this.transactionChannel, sipResponse);
                                this.transactionChannel.setDialog(sipDialog, sipResponse
                                .getDialogId(false));
                            } 
                        } 
                        {
                            sipDialog = this.sipStack.createDialog(sipProvider, sipResponse);
                        } 
                    } 
                } 
            } 
            {
                {
                    boolean var2A33A6FB66230F3C763C02B11A31B698_1715096558 = (sipDialog != null && transaction == null
                    && sipDialog.getState() != DialogState.TERMINATED);
                    {
                        {
                            boolean varA57297F1061982CB33F3268F8A8D4904_1729653949 = (sipResponse.getStatusCode() / 100 != 2);
                            {
                                {
                                    boolean varA5D47C3A6259BCCCC2265DD1F84B75D4_414043016 = (sipStack.isLoggingEnabled());
                                    sipStack.getStackLogger().logDebug(
                                "status code != 200 ; statusCode = "
                                        + sipResponse.getStatusCode());
                                } 
                            } 
                            {
                                boolean var6A3DFB971BB99F011A348D516A5DE989_1202729090 = (sipDialog.getState() == DialogState.TERMINATED);
                                {
                                    {
                                        boolean var6FE8ACC5352DCA3449210F8EDED912B3_416402940 = (sipStack.isLoggingEnabled());
                                        {
                                            sipStack.getStackLogger().logDebug(
                                "Dialog is terminated -- dropping response!");
                                        } 
                                    } 
                                    {
                                        boolean varD919ECE2500BE622A07F72F67D931CEB_1051190142 = (sipResponse.getStatusCode() / 100 == 2
                            && sipResponse.getCSeq().getMethod().equals(Request.INVITE));
                                        {
                                            try 
                                            {
                                                Request ackRequest = sipDialog.createAck(sipResponse.getCSeq()
                                    .getSeqNumber());
                                                sipDialog.sendAck(ackRequest);
                                            } 
                                            catch (Exception ex)
                                            {
                                                sipStack.getStackLogger().logError("Error creating ack", ex);
                                            } 
                                        } 
                                    } 
                                } 
                                {
                                    boolean ackAlreadySent = false;
                                    {
                                        boolean var403629A75A5A567C164D1E1B78D4DD0C_685282941 = (sipDialog.isAckSeen() && sipDialog.getLastAckSent() != null);
                                        {
                                            {
                                                boolean varB1FC30C2EF7BA643D3E3FCB6B1D03580_596945981 = (sipDialog.getLastAckSent().getCSeq().getSeqNumber() == sipResponse
                                .getCSeq().getSeqNumber()
                                && sipResponse.getDialogId(false).equals(
                                        sipDialog.getLastAckSent().getDialogId(false)));
                                                {
                                                    ackAlreadySent = true;
                                                } 
                                            } 
                                        } 
                                    } 
                                    {
                                        boolean var48B96C0860552644EFB088829DD33EF6_1164378168 = (ackAlreadySent
                            && sipResponse.getCSeq().getMethod().equals(sipDialog.getMethod()));
                                        {
                                            try 
                                            {
                                                {
                                                    boolean var3EB379B664411110CCE0F3EED18D8CFA_1319443995 = (sipStack.isLoggingEnabled());
                                                    sipStack.getStackLogger().logDebug("resending ACK");
                                                } 
                                                sipDialog.resendAck();
                                            } 
                                            catch (SipException ex)
                                            { }
                                        } 
                                    } 
                                } 
                            } 
                        } 
                    } 
                } 
            } 
        } 
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1611507733 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug("sending response to TU for processing ");
        } 
        {
            boolean varC166593AE3B3B1E64B0064A7F65529F8_1894891484 = (sipDialog != null && sipResponse.getStatusCode() != 100
                && sipResponse.getTo().getTag() != null);
            {
                sipDialog.setLastResponse(transaction, sipResponse);
            } 
        } 
        ResponseEventExt responseEvent = new ResponseEventExt(sipProvider,
                (ClientTransactionExt) transaction, sipDialog, (Response) sipResponse);
        {
            boolean var2D5D6FEC34FFCB5BC855F59C71930094_2004341332 = (sipResponse.getCSeq().getMethod().equals(Request.INVITE));
            {
                ClientTransactionExt originalTx = this.sipStack.getForkedTransaction(sipResponse
                    .getTransactionId());
                responseEvent.setOriginalTransaction(originalTx);
            } 
        } 
        sipProvider.handleEvent(responseEvent, transaction);
        addTaint(sipResponse.getTaint());
        addTaint(incomingChannel.getTaint());
        
        
    }

    
}

