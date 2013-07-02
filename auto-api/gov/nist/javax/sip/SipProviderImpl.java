package gov.nist.javax.sip;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.core.InternalErrorHandler;
import gov.nist.javax.sip.DialogTimeoutEvent.Reason;
import gov.nist.javax.sip.address.RouterExt;
import gov.nist.javax.sip.header.CallID;
import gov.nist.javax.sip.header.Via;
import gov.nist.javax.sip.message.SIPMessage;
import gov.nist.javax.sip.message.SIPRequest;
import gov.nist.javax.sip.message.SIPResponse;
import gov.nist.javax.sip.stack.HopImpl;
import gov.nist.javax.sip.stack.MessageChannel;
import gov.nist.javax.sip.stack.SIPClientTransaction;
import gov.nist.javax.sip.stack.SIPDialog;
import gov.nist.javax.sip.stack.SIPDialogErrorEvent;
import gov.nist.javax.sip.stack.SIPDialogEventListener;
import gov.nist.javax.sip.stack.SIPServerTransaction;
import gov.nist.javax.sip.stack.SIPTransaction;
import gov.nist.javax.sip.stack.SIPTransactionErrorEvent;
import gov.nist.javax.sip.stack.SIPTransactionEventListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.EventObject;
import java.util.Iterator;
import java.util.TooManyListenersException;
import java.util.concurrent.ConcurrentHashMap;
import javax.sip.ClientTransaction;
import javax.sip.Dialog;
import javax.sip.DialogState;
import javax.sip.InvalidArgumentException;
import javax.sip.ListeningPoint;
import javax.sip.ObjectInUseException;
import javax.sip.RequestEvent;
import javax.sip.ResponseEvent;
import javax.sip.ServerTransaction;
import javax.sip.SipException;
import javax.sip.SipListener;
import javax.sip.SipStack;
import javax.sip.Timeout;
import javax.sip.TimeoutEvent;
import javax.sip.Transaction;
import javax.sip.TransactionAlreadyExistsException;
import javax.sip.TransactionState;
import javax.sip.TransactionUnavailableException;
import javax.sip.address.Hop;
import javax.sip.header.CallIdHeader;
import javax.sip.message.Request;
import javax.sip.message.Response;

public class SipProviderImpl implements javax.sip.SipProvider, gov.nist.javax.sip.SipProviderExt, SIPTransactionEventListener, SIPDialogEventListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.828 -0400", hash_original_field = "C2742B0786D982D4EE3DCECCEC00E889", hash_generated_field = "C372B5B3448581C0F5822346BC5BF6B5")

    private SipListener sipListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.828 -0400", hash_original_field = "37460D4BF2BA47A13FF9D922C4B14B2E", hash_generated_field = "4DAF551644AC41AE30E26F4ABCF55488")

    protected SipStackImpl sipStack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.828 -0400", hash_original_field = "3CEAB7318649FC55E6D462942E769E7E", hash_generated_field = "2A53AF8663A42FF261DC56019ACC7569")

    private ConcurrentHashMap listeningPoints;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.828 -0400", hash_original_field = "0C887D575D34CEEB43215C9C2EB3F7E0", hash_generated_field = "B13D933CCB9027F950F0F782A6866769")

    private EventScanner eventScanner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.828 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "27AA4AB7415706F85D71A67C2AA547CB")

    private String address;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.828 -0400", hash_original_field = "901555FB06E346CB065CEB9808DCFC25", hash_generated_field = "D40522EE9D0571A9162D4F847D658065")

    private int port;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.828 -0400", hash_original_field = "03F94425985D4F12F061598392CB27B5", hash_generated_field = "524F32CD9808C18576213A6E5A9B572D")

    private boolean automaticDialogSupportEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.828 -0400", hash_original_field = "B00F9FADF4204970C84368C656AF77CC", hash_generated_field = "5CCA946576EE027FCC33A16438A5DE7B")

    private String IN_ADDR_ANY = "0.0.0.0";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.828 -0400", hash_original_field = "648F89EB1D64275F1AF190105C1418E4", hash_generated_field = "18A343C90CA0F147EDF9BB2788A149EF")

    private String IN6_ADDR_ANY = "::0";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.828 -0400", hash_original_field = "48E1E0D9B22B9E0D75D9E59520D250FF", hash_generated_field = "51E780BD632743E190A61DB4A1929A94")

    private boolean dialogErrorsAutomaticallyHandled = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.829 -0400", hash_original_method = "D7A082BA7BBEB80ADC15AA42F366B72C", hash_generated_method = "58CC0CE0C4D98D56E1D4B23FD5EE5252")
    private  SipProviderImpl() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.829 -0400", hash_original_method = "E70748599E06F3AAB45B7E3DFBC2B3DC", hash_generated_method = "C7D1CA44448B68E5234FA92ECF9809FE")
    protected  SipProviderImpl(SipStackImpl sipStack) {
        this.eventScanner = sipStack.getEventScanner();
        this.sipStack = sipStack;
        this.eventScanner.incrementRefcount();
        this.listeningPoints = new ConcurrentHashMap<String,ListeningPointImpl>();
        this.automaticDialogSupportEnabled = this.sipStack
                .isAutomaticDialogSupportEnabled();
        this.dialogErrorsAutomaticallyHandled = this.sipStack.isAutomaticDialogErrorHandlingEnabled();
        
        
        
        
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.830 -0400", hash_original_method = "11E23C3DFA194FF115BF392A022E2577", hash_generated_method = "B45C4896115EEB0D6E6C61F930EECF2E")
    protected void stop() {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1277045260 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug("Exiting provider");
        } 
        {
            Iterator it = listeningPoints.values().iterator();
            boolean var03729FD53960D8DCA3A41A13A0229637_2108621006 = (it.hasNext());
            {
                ListeningPointImpl listeningPoint = (ListeningPointImpl) it.next();
                listeningPoint.removeSipProvider();
            } 
        } 
        this.eventScanner.stop();
        
        
            
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.830 -0400", hash_original_method = "1158BA9F135FC60D78E0B26F09E9CC9C", hash_generated_method = "DF64FD65066D90AE35358B78955DE8CA")
    public ListeningPoint getListeningPoint(String transport) {
        ListeningPoint varB4EAC82CA7396A68D541C85D26508E83_1471070546 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Null transport param");
        varB4EAC82CA7396A68D541C85D26508E83_1471070546 = (ListeningPoint) this.listeningPoints.get(transport
                .toUpperCase());
        addTaint(transport.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1471070546.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1471070546;
        
        
            
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.831 -0400", hash_original_method = "BA46457405F31389F30610967A0B78B2", hash_generated_method = "2D29DC6CAE0B9E00FB0542FC21D6CB99")
    public void handleEvent(EventObject sipEvent, SIPTransaction transaction) {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_82301021 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug(
                    "handleEvent " + sipEvent + "currentTransaction = "
                            + transaction + "this.sipListener = "
                            + this.getSipListener() + "sipEvent.source = "
                            + sipEvent.getSource());
                {
                    Dialog dialog = ((RequestEvent) sipEvent).getDialog();
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1088324027 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger().logDebug("Dialog = " + dialog);
                    } 
                } 
                {
                    Dialog dialog = ((ResponseEvent) sipEvent).getDialog();
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1983788711 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger().logDebug("Dialog = " + dialog);
                    } 
                } 
                sipStack.getStackLogger().logStackTrace();
            } 
        } 
        EventWrapper eventWrapper = new EventWrapper(sipEvent, transaction);
        {
            this.eventScanner.addEvent(eventWrapper);
        } 
        {
            this.eventScanner.deliverEvent(eventWrapper);
        } 
        addTaint(sipEvent.getTaint());
        addTaint(transaction.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.832 -0400", hash_original_method = "E6B31C0538AF64C15CAF5AB43FC9524E", hash_generated_method = "A636F3E139EB80DA222248E8ED9B4C28")
    protected Object clone() throws java.lang.CloneNotSupportedException {
        throw new java.lang.CloneNotSupportedException();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.833 -0400", hash_original_method = "C6DB78E4BFC94524622F655361F90AF4", hash_generated_method = "0E9D3B50D2BE3A0934169AD87F37AD8B")
    public void addSipListener(SipListener sipListener) throws TooManyListenersException {
        {
            sipStack.sipListener = sipListener;
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new TooManyListenersException(
                    "Stack already has a listener. Only one listener per stack allowed");
        } 
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1276240689 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug("add SipListener " + sipListener);
        } 
        this.sipListener = sipListener;
        
        
            
        
            
                    
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.834 -0400", hash_original_method = "8DF1BB234AEAFA11A00A3BD7891CCE00", hash_generated_method = "1BDD76AC1B09EFAF3B6903F570A1AEFB")
    public ListeningPoint getListeningPoint() {
        ListeningPoint varB4EAC82CA7396A68D541C85D26508E83_153221568 = null; 
        ListeningPoint varB4EAC82CA7396A68D541C85D26508E83_1066600459 = null; 
        {
            boolean var14A0E82606B7A61F437411D21145307C_536164403 = (this.listeningPoints.size() > 0);
            varB4EAC82CA7396A68D541C85D26508E83_153221568 = (ListeningPoint) this.listeningPoints.values().iterator()
                    .next();
            varB4EAC82CA7396A68D541C85D26508E83_1066600459 = null;
        } 
        ListeningPoint varA7E53CE21691AB073D9660D615818899_1774830251; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1774830251 = varB4EAC82CA7396A68D541C85D26508E83_153221568;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1774830251 = varB4EAC82CA7396A68D541C85D26508E83_1066600459;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1774830251.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1774830251;
        
        
            
                    
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.835 -0400", hash_original_method = "19C35F549E02B2BEFD4FB9F187DBEB25", hash_generated_method = "011CD9EC9E086C61C32565DA5996FF08")
    public CallIdHeader getNewCallId() {
        CallIdHeader varB4EAC82CA7396A68D541C85D26508E83_552337623 = null; 
        String callId = Utils.getInstance().generateCallIdentifier(this.getListeningPoint()
                .getIPAddress());
        CallID callid = new CallID();
        try 
        {
            callid.setCallId(callId);
        } 
        catch (java.text.ParseException ex)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_552337623 = callid;
        varB4EAC82CA7396A68D541C85D26508E83_552337623.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_552337623;
        
        
                
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.837 -0400", hash_original_method = "7DCA30FF9D29B59AA737512D4B93FBF9", hash_generated_method = "4F4530F3EF6BC7AF2C5495C2420F8630")
    public ClientTransaction getNewClientTransaction(Request request) throws TransactionUnavailableException {
        ClientTransaction varB4EAC82CA7396A68D541C85D26508E83_456329536 = null; 
        ClientTransaction varB4EAC82CA7396A68D541C85D26508E83_1519789853 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null request");
        {
            boolean var578FC2E912464C4A12E7CF055900B3BB_754591244 = (!sipStack.isAlive());
            if (DroidSafeAndroidRuntime.control) throw new TransactionUnavailableException("Stack is stopped");
        } 
        SIPRequest sipRequest = (SIPRequest) request;
        {
            boolean var8BB3A42522561BC6F555B944E81B9E93_1746142578 = (sipRequest.getTransaction() != null);
            if (DroidSafeAndroidRuntime.control) throw new TransactionUnavailableException(
                    "Transaction already assigned to request");
        } 
        {
            boolean varB8F91E4F13509919B572D4EB6363E0F7_1302002207 = (sipRequest.getMethod().equals(Request.ACK));
            {
                if (DroidSafeAndroidRuntime.control) throw new TransactionUnavailableException ("Cannot create client transaction for  " + Request.ACK);
            } 
        } 
        {
            boolean var8CA8DAE562F4EE2631485504216CC251_663919317 = (sipRequest.getTopmostVia() == null);
            {
                ListeningPointImpl lp = (ListeningPointImpl) this
                    .getListeningPoint("udp");
                Via via = lp.getViaHeader();
                request.setHeader(via);
            } 
        } 
        try 
        {
            sipRequest.checkHeaders();
        } 
        catch (ParseException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new TransactionUnavailableException(ex.getMessage(), ex);
        } 
        {
            boolean var50EC3F4D5C54E361B47676E619EAAFA0_1767903359 = (sipRequest.getTopmostVia().getBranch() != null
                && sipRequest.getTopmostVia().getBranch().startsWith(
                        SIPConstants.BRANCH_MAGIC_COOKIE)
                && sipStack.findTransaction((SIPRequest) request, false) != null);
            {
                if (DroidSafeAndroidRuntime.control) throw new TransactionUnavailableException(
                    "Transaction already exists!");
            } 
        } 
        {
            boolean var80AA6E7CE4CA9828EC141D0C3E8E2623_2124228514 = (request.getMethod().equalsIgnoreCase(Request.CANCEL));
            {
                SIPClientTransaction ct = (SIPClientTransaction) sipStack
                    .findCancelTransaction((SIPRequest) request, false);
                {
                    ClientTransaction retval = sipStack.createClientTransaction(
                        (SIPRequest) request, ct.getMessageChannel());
                    ((SIPTransaction) retval).addEventListener(this);
                    sipStack.addTransaction((SIPClientTransaction) retval);
                    {
                        boolean varC6530BD657A7ADFE309456660793CB51_965462265 = (ct.getDialog() != null);
                        {
                            ((SIPClientTransaction) retval).setDialog((SIPDialog) ct
                            .getDialog(), sipRequest.getDialogId(false));
                        } 
                    } 
                    varB4EAC82CA7396A68D541C85D26508E83_456329536 = retval;
                } 
            } 
        } 
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1300451995 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug(
                    "could not find existing transaction for "
                            + ((SIPRequest) request).getFirstLine()
                            + " creating a new one ");
        } 
        Hop hop = null;
        try 
        {
            hop = sipStack.getNextHop((SIPRequest) request);
            if (DroidSafeAndroidRuntime.control) throw new TransactionUnavailableException(
                        "Cannot resolve next hop -- transaction unavailable");
        } 
        catch (SipException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new TransactionUnavailableException(
                    "Cannot resolve next hop -- transaction unavailable", ex);
        } 
        String transport = hop.getTransport();
        ListeningPointImpl listeningPoint = (ListeningPointImpl) this
                .getListeningPoint(transport);
        String dialogId = sipRequest.getDialogId(false);
        SIPDialog dialog = sipStack.getDialog(dialogId);
        {
            boolean varF49230B2DD2C6AFABFC95BE0EB70C68C_1516666062 = (dialog != null && dialog.getState() == DialogState.TERMINATED);
            {
                sipStack.removeDialog(dialog);
            } 
        } 
        try 
        {
            String branchId = null;
            {
                boolean var93A504DCD46E7EC8683F0CC8BFF98434_1370817788 = (sipRequest.getTopmostVia().getBranch() == null
                    || !sipRequest.getTopmostVia().getBranch().startsWith(
                            SIPConstants.BRANCH_MAGIC_COOKIE)
                            || sipStack.checkBranchId());
                {
                    branchId = Utils.getInstance().generateBranchId();
                    sipRequest.getTopmostVia().setBranch(branchId);
                } 
            } 
            Via topmostVia = sipRequest.getTopmostVia();
            {
                boolean var3017E8004C459CC9B3CF01C4594DE1C8_1010580746 = (topmostVia.getTransport() == null);
                topmostVia.setTransport(transport);
            } 
            {
                boolean var8F4A7E15EB4EA45A579CA903340B0597_708505975 = (topmostVia.getPort() == -1);
                topmostVia.setPort(listeningPoint.getPort());
            } 
            branchId = sipRequest.getTopmostVia().getBranch();
            SIPClientTransaction ct = (SIPClientTransaction) sipStack
                    .createMessageChannel(sipRequest, listeningPoint
                            .getMessageProcessor(), hop);
            if (DroidSafeAndroidRuntime.control) throw new TransactionUnavailableException("Cound not create tx");
            ct.setNextHop(hop);
            ct.setOriginalRequest(sipRequest);
            ct.setBranch(branchId);
            {
                boolean var7367A0764DE5A8FD72A1BB83DDF82032_2112083380 = (sipStack.isDialogCreated(request.getMethod()));
                {
                    ct.setDialog(dialog, sipRequest.getDialogId(false));
                    {
                        boolean var3C17FD797D120D8CEAA3BBA32E798D99_1215629028 = (this.isAutomaticDialogSupportEnabled());
                        {
                            SIPDialog sipDialog = sipStack.createDialog(ct);
                            ct.setDialog(sipDialog, sipRequest.getDialogId(false));
                        } 
                    } 
                } 
                {
                    {
                        ct.setDialog(dialog, sipRequest.getDialogId(false));
                    } 
                } 
            } 
            ct.addEventListener(this);
            varB4EAC82CA7396A68D541C85D26508E83_1519789853 = (ClientTransaction) ct;
        } 
        catch (IOException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new TransactionUnavailableException(
                    "Could not resolve next hop or listening point unavailable! ",
                    ex);
        } 
        catch (java.text.ParseException ex)
        {
            InternalErrorHandler.handleException(ex);
            if (DroidSafeAndroidRuntime.control) throw new TransactionUnavailableException(
                    "Unexpected Exception FIXME! ", ex);
        } 
        catch (InvalidArgumentException ex)
        {
            InternalErrorHandler.handleException(ex);
            if (DroidSafeAndroidRuntime.control) throw new TransactionUnavailableException(
                    "Unexpected Exception FIXME! ", ex);
        } 
        addTaint(request.getTaint());
        ClientTransaction varA7E53CE21691AB073D9660D615818899_1044531381; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1044531381 = varB4EAC82CA7396A68D541C85D26508E83_456329536;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1044531381 = varB4EAC82CA7396A68D541C85D26508E83_1519789853;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1044531381.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1044531381;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.842 -0400", hash_original_method = "569DCDD9EB405C75F83E1325FE87C1D4", hash_generated_method = "0042808F16EACFAB0979F52B2D59FFF9")
    public ServerTransaction getNewServerTransaction(Request request) throws TransactionAlreadyExistsException,
            TransactionUnavailableException {
        ServerTransaction varB4EAC82CA7396A68D541C85D26508E83_878339824 = null; 
        ServerTransaction varB4EAC82CA7396A68D541C85D26508E83_1868682527 = null; 
        ServerTransaction varB4EAC82CA7396A68D541C85D26508E83_467923476 = null; 
        {
            boolean var578FC2E912464C4A12E7CF055900B3BB_1830887779 = (!sipStack.isAlive());
            if (DroidSafeAndroidRuntime.control) throw new TransactionUnavailableException("Stack is stopped");
        } 
        SIPServerTransaction transaction = null;
        SIPRequest sipRequest = (SIPRequest) request;
        try 
        {
            sipRequest.checkHeaders();
        } 
        catch (ParseException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new TransactionUnavailableException(ex.getMessage(), ex);
        } 
        {
            boolean var201B05658C4F9A1218A263AD3BFB8279_1095809828 = (request.getMethod().equals(Request.ACK));
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1223608045 = (sipStack.isLoggingEnabled());
                    sipStack.getStackLogger().logError("Creating server transaction for ACK -- makes no sense!");
                } 
                if (DroidSafeAndroidRuntime.control) throw new TransactionUnavailableException("Cannot create Server transaction for ACK ");
            } 
        } 
        {
            boolean var5680F486E9BBA4AE3D51DC65AE40A32A_1063834586 = (sipRequest.getMethod().equals(Request.NOTIFY)
                && sipRequest.getFromTag() != null
                && sipRequest.getToTag() == null);
            {
                SIPClientTransaction ct = sipStack.findSubscribeTransaction(
                    sipRequest, (ListeningPointImpl) this.getListeningPoint());
                {
                    if (DroidSafeAndroidRuntime.control) throw new TransactionUnavailableException(
                        "Cannot find matching Subscription (and gov.nist.javax.sip.DELIVER_UNSOLICITED_NOTIFY not set)");
                } 
            } 
        } 
        {
            boolean var848472C21B8ED1A338982BFE859C21F4_863728850 = (!sipStack.acquireSem());
            {
                if (DroidSafeAndroidRuntime.control) throw new TransactionUnavailableException(
            "Transaction not available -- could not acquire stack lock");
            } 
        } 
        try 
        {
            {
                boolean var79496FCF147EE808D85E5D971644F143_13902164 = (sipStack.isDialogCreated(sipRequest.getMethod()));
                {
                    {
                        boolean var0BF221D48246E2D3EEB627BFEB1153DC_518407508 = (sipStack.findTransaction((SIPRequest) request, true) != null);
                        if (DroidSafeAndroidRuntime.control) throw new TransactionAlreadyExistsException(
                    "server transaction already exists!");
                    } 
                    transaction = (SIPServerTransaction) ((SIPRequest) request)
                .getTransaction();
                    if (DroidSafeAndroidRuntime.control) throw new TransactionUnavailableException(
                    "Transaction not available");
                    {
                        boolean varBF65D8C1DA9C53FFACBDFD6709555F00_1716170730 = (transaction.getOriginalRequest() == null);
                        transaction.setOriginalRequest(sipRequest);
                    } 
                    try 
                    {
                        sipStack.addTransaction(transaction);
                    } 
                    catch (IOException ex)
                    {
                        if (DroidSafeAndroidRuntime.control) throw new TransactionUnavailableException(
                    "Error sending provisional response");
                    } 
                    transaction.addEventListener(this);
                    {
                        boolean var2FA53F6CD609BAD905BD45D19390D125_840520499 = (isAutomaticDialogSupportEnabled());
                        {
                            String dialogId = sipRequest.getDialogId(true);
                            SIPDialog dialog = sipStack.getDialog(dialogId);
                            {
                                dialog = sipStack.createDialog(transaction);
                            } 
                            transaction.setDialog(dialog, sipRequest.getDialogId(true));
                            {
                                boolean varFD733B0149A61F36E79D158A24EC42DF_275210484 = (sipRequest.getMethod().equals(Request.INVITE) && this.isDialogErrorsAutomaticallyHandled());
                                {
                                    sipStack.putInMergeTable(transaction, sipRequest);
                                } 
                            } 
                            dialog.addRoute(sipRequest);
                            {
                                boolean var552B1EE59DF17D024C651A7B3230204F_573400280 = (dialog.getRemoteTag() != null
                            && dialog.getLocalTag() != null);
                                {
                                    this.sipStack.putDialog(dialog);
                                } 
                            } 
                        } 
                    } 
                } 
                {
                    {
                        boolean var2FA53F6CD609BAD905BD45D19390D125_1663449436 = (isAutomaticDialogSupportEnabled());
                        {
                            transaction = (SIPServerTransaction) sipStack.findTransaction(
                            (SIPRequest) request, true);
                            if (DroidSafeAndroidRuntime.control) throw new TransactionAlreadyExistsException(
                        "Transaction exists! ");
                            transaction = (SIPServerTransaction) ((SIPRequest) request)
                    .getTransaction();
                            if (DroidSafeAndroidRuntime.control) throw new TransactionUnavailableException(
                        "Transaction not available!");
                            {
                                boolean varE88996A36B6F456EF82A880E4DAEAD09_910483164 = (transaction.getOriginalRequest() == null);
                                transaction.setOriginalRequest(sipRequest);
                            } 
                            try 
                            {
                                sipStack.addTransaction(transaction);
                            } 
                            catch (IOException ex)
                            {
                                if (DroidSafeAndroidRuntime.control) throw new TransactionUnavailableException(
                        "Could not send back provisional response!");
                            } 
                            String dialogId = sipRequest.getDialogId(true);
                            SIPDialog dialog = sipStack.getDialog(dialogId);
                            {
                                dialog.addTransaction(transaction);
                                dialog.addRoute(sipRequest);
                                transaction.setDialog(dialog, sipRequest.getDialogId(true));
                            } 
                        } 
                        {
                            transaction = (SIPServerTransaction) sipStack.findTransaction(
                            (SIPRequest) request, true);
                            if (DroidSafeAndroidRuntime.control) throw new TransactionAlreadyExistsException(
                        "Transaction exists! ");
                            transaction = (SIPServerTransaction) ((SIPRequest) request)
                    .getTransaction();
                            {
                                {
                                    boolean varA9E3FDFA9EFE1D53F3B4B78E55F1D450_1653916980 = (transaction.getOriginalRequest() == null);
                                    transaction.setOriginalRequest(sipRequest);
                                } 
                                sipStack.mapTransaction(transaction);
                                String dialogId = sipRequest.getDialogId(true);
                                SIPDialog dialog = sipStack.getDialog(dialogId);
                                {
                                    dialog.addTransaction(transaction);
                                    dialog.addRoute(sipRequest);
                                    transaction.setDialog(dialog, sipRequest
                                    .getDialogId(true));
                                } 
                                varB4EAC82CA7396A68D541C85D26508E83_878339824 = transaction;
                            } 
                            {
                                MessageChannel mc = (MessageChannel) sipRequest
                        .getMessageChannel();
                                transaction = sipStack.createServerTransaction(mc);
                                if (DroidSafeAndroidRuntime.control) throw new TransactionUnavailableException(
                            "Transaction unavailable -- too many servrer transactions");
                                transaction.setOriginalRequest(sipRequest);
                                sipStack.mapTransaction(transaction);
                                String dialogId = sipRequest.getDialogId(true);
                                SIPDialog dialog = sipStack.getDialog(dialogId);
                                {
                                    dialog.addTransaction(transaction);
                                    dialog.addRoute(sipRequest);
                                    transaction.setDialog(dialog, sipRequest
                                    .getDialogId(true));
                                } 
                                varB4EAC82CA7396A68D541C85D26508E83_1868682527 = transaction;
                            } 
                        } 
                    } 
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_467923476 = transaction;
        } 
        finally 
        {
            sipStack.releaseSem();
        } 
        addTaint(request.getTaint());
        ServerTransaction varA7E53CE21691AB073D9660D615818899_1893791214; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1893791214 = varB4EAC82CA7396A68D541C85D26508E83_878339824;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1893791214 = varB4EAC82CA7396A68D541C85D26508E83_1868682527;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1893791214 = varB4EAC82CA7396A68D541C85D26508E83_467923476;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1893791214.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1893791214;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.844 -0400", hash_original_method = "4583BF79BF08EE358F0E8CEF923996E7", hash_generated_method = "D295239AAC197811BBE3FE06E931FDA1")
    public SipStack getSipStack() {
        SipStack varB4EAC82CA7396A68D541C85D26508E83_1988802193 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1988802193 = (SipStack) this.sipStack;
        varB4EAC82CA7396A68D541C85D26508E83_1988802193.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1988802193;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.846 -0400", hash_original_method = "8E603E1E5B83B3D4BA739C213D2D52AF", hash_generated_method = "6C3B1468A77AFDA7D4CE6ECFE0E9D742")
    public void removeSipListener(SipListener sipListener) {
        {
            boolean var3EBAC163BF77AB77C6C843748C56504B_292174643 = (sipListener == this.getSipListener());
            {
                this.sipListener = null;
            } 
        } 
        boolean found = false;
        {
            Iterator<SipProviderImpl> it = sipStack.getSipProviders();
            boolean var03729FD53960D8DCA3A41A13A0229637_1417744150 = (it.hasNext());
            {
                SipProviderImpl nextProvider = (SipProviderImpl) it.next();
                {
                    boolean varD3FFA706FB203019969170CA77B23E96_179318059 = (nextProvider.getSipListener() != null);
                    found = true;
                } 
            } 
        } 
        {
            sipStack.sipListener = null;
        } 
        
        
            
        
        
        
            
            
                
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.849 -0400", hash_original_method = "5A8CC74B0BB93A3DC57DF48200955F60", hash_generated_method = "ED65158FA9B190D31BAD37B4B66D8F6F")
    public void sendRequest(Request request) throws SipException {
        {
            boolean var578FC2E912464C4A12E7CF055900B3BB_955090431 = (!sipStack.isAlive());
            if (DroidSafeAndroidRuntime.control) throw new SipException("Stack is stopped.");
        } 
        {
            boolean var0D914FFF58AF7E35FFEA8AEDA4904365_1647939092 = (((SIPRequest) request).getRequestLine() != null
                && request.getMethod().equals(Request.ACK));
            {
                Dialog dialog = sipStack.getDialog(((SIPRequest) request)
                    .getDialogId(false));
                {
                    boolean varB3B78D170A5FE6F6EEE00296D839FDE4_1369019062 = (dialog != null && dialog.getState() != null);
                    {
                        {
                            boolean var2AB968A8303910EE00F810B6DE3410F9_1295629080 = (sipStack.isLoggingEnabled());
                            sipStack.getStackLogger().logWarning(
                        "Dialog exists -- you may want to use Dialog.sendAck() "
                                + dialog.getState());
                        } 
                    } 
                } 
            } 
        } 
        Hop hop = sipStack.getRouter((SIPRequest) request).getNextHop(request);
        if (DroidSafeAndroidRuntime.control) throw new SipException("could not determine next hop!");
        SIPRequest sipRequest = (SIPRequest) request;
        {
            boolean var89D36681177313849BAB68F82102654C_2145481671 = ((!sipRequest.isNullRequest()) && sipRequest.getTopmostVia() == null);
            if (DroidSafeAndroidRuntime.control) throw new SipException("Invalid SipRequest -- no via header!");
        } 
        try 
        {
            {
                boolean var1F858BD51C91427BBA6B4192654D1334_559241360 = (!sipRequest.isNullRequest());
                {
                    Via via = sipRequest.getTopmostVia();
                    String branch = via.getBranch();
                    {
                        boolean var4D8AFAC764A0F0A938EBB5692AB883DF_217254946 = (branch == null || branch.length() == 0);
                        {
                            via.setBranch(sipRequest.getTransactionId());
                        } 
                    } 
                } 
            } 
            MessageChannel messageChannel = null;
            {
                boolean var4902E9C89928CA7671DF78AA0FD2ABF7_385589405 = (this.listeningPoints.containsKey(hop.getTransport()
                    .toUpperCase()));
                messageChannel = sipStack.createRawMessageChannel(
                        this.getListeningPoint(hop.getTransport()).getIPAddress(),
                        this.getListeningPoint(hop.getTransport()).getPort(), hop);
            } 
            {
                messageChannel.sendMessage((SIPMessage) sipRequest,hop);
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException(
                        "Could not create a message channel for "
                                + hop.toString());
            } 
        } 
        catch (IOException ex)
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_272175016 = (sipStack.isLoggingEnabled());
                {
                    sipStack.getStackLogger().logException(ex);
                } 
            } 
            if (DroidSafeAndroidRuntime.control) throw new SipException(
                    "IO Exception occured while Sending Request", ex);
        } 
        catch (ParseException ex1)
        {
            InternalErrorHandler.handleException(ex1);
        } 
        finally 
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_187532233 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug(
                        "done sending " + request.getMethod() + " to hop "
                                + hop);
            } 
        } 
        addTaint(request.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.850 -0400", hash_original_method = "9E6954B352C971BA2053951D5F8763C5", hash_generated_method = "93F7F54E7B640AF291E2AC2A77193A18")
    public void sendResponse(Response response) throws SipException {
        {
            boolean var578FC2E912464C4A12E7CF055900B3BB_1001715180 = (!sipStack.isAlive());
            if (DroidSafeAndroidRuntime.control) throw new SipException("Stack is stopped");
        } 
        SIPResponse sipResponse = (SIPResponse) response;
        Via via = sipResponse.getTopmostVia();
        if (DroidSafeAndroidRuntime.control) throw new SipException("No via header in response!");
        SIPServerTransaction st = (SIPServerTransaction) sipStack.findTransaction((SIPMessage)response, true);
        {
            boolean var465DED2C2BDB9C2BFE8E77E722F267EE_811311573 = (st != null   && st.getState() != TransactionState.TERMINATED && this.isAutomaticDialogSupportEnabled());
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException("Transaction exists -- cannot send response statelessly");
            } 
        } 
        String transport = via.getTransport();
        String host = via.getReceived();
        host = via.getHost();
        int port = via.getRPort();
        {
            port = via.getPort();
            {
                {
                    boolean var0C816DD378EF0BD3D8AA055CCE81D636_1128673323 = (transport.equalsIgnoreCase("TLS"));
                    port = 5061;
                    port = 5060;
                } 
            } 
        } 
        {
            boolean var46F57E4064B6D60D041159437F70D44E_1763292235 = (host.indexOf(":") > 0);
            {
                boolean varFD50F873716FDE8220E1F82E415385FD_1839850221 = (host.indexOf("[") < 0);
                host = "[" + host + "]";
            } 
        } 
        Hop hop = sipStack.getAddressResolver().resolveAddress(
                new HopImpl(host, port, transport));
        try 
        {
            ListeningPointImpl listeningPoint = (ListeningPointImpl) this
                    .getListeningPoint(transport);
            if (DroidSafeAndroidRuntime.control) throw new SipException(
                        "whoopsa daisy! no listening point found for transport "
                                + transport);
            MessageChannel messageChannel = sipStack.createRawMessageChannel(
                    this.getListeningPoint(hop.getTransport()).getIPAddress(),
                    listeningPoint.port, hop);
            messageChannel.sendMessage(sipResponse);
        } 
        catch (IOException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException(ex.getMessage());
        } 
        addTaint(response.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.851 -0400", hash_original_method = "0E16D45CFEA7D246360E28B311FFB756", hash_generated_method = "23E0FCDD53C5E065EF577AE37976A758")
    public synchronized void setListeningPoint(ListeningPoint listeningPoint) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Null listening point");
        ListeningPointImpl lp = (ListeningPointImpl) listeningPoint;
        lp.sipProvider = this;
        String transport = lp.getTransport().toUpperCase();
        this.address = listeningPoint.getIPAddress();
        this.port = listeningPoint.getPort();
        this.listeningPoints.clear();
        this.listeningPoints.put(transport, listeningPoint);
        
        
            
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.853 -0400", hash_original_method = "9D9F76163655F94EC324A9002FE39206", hash_generated_method = "505651BC5E2EE6E4CBFC2791EC9C4A5C")
    public Dialog getNewDialog(Transaction transaction) throws SipException {
        Dialog varB4EAC82CA7396A68D541C85D26508E83_1517786707 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Null transaction!");
        {
            boolean var578FC2E912464C4A12E7CF055900B3BB_838788492 = (!sipStack.isAlive());
            if (DroidSafeAndroidRuntime.control) throw new SipException("Stack is stopped.");
        } 
        {
            boolean var0C3E3A9E68AD0E7B77C01858D9A4E447_94494678 = (isAutomaticDialogSupportEnabled());
            if (DroidSafeAndroidRuntime.control) throw new SipException(" Error - AUTOMATIC_DIALOG_SUPPORT is on");
        } 
        {
            boolean var0B2E45F30D15A6A8FAE246273421368A_774466548 = (!sipStack.isDialogCreated(transaction.getRequest().getMethod()));
            if (DroidSafeAndroidRuntime.control) throw new SipException("Dialog cannot be created for this method "
                    + transaction.getRequest().getMethod());
        } 
        SIPDialog dialog = null;
        SIPTransaction sipTransaction = (SIPTransaction) transaction;
        {
            SIPServerTransaction st = (SIPServerTransaction) transaction;
            Response response = st.getLastResponse();
            {
                {
                    boolean var3304D06C4D0D68DD58BC19A499B51896_834770732 = (response.getStatusCode() != 100);
                    if (DroidSafeAndroidRuntime.control) throw new SipException(
                            "Cannot set dialog after response has been sent");
                } 
            } 
            SIPRequest sipRequest = (SIPRequest) transaction.getRequest();
            String dialogId = sipRequest.getDialogId(true);
            dialog = sipStack.getDialog(dialogId);
            {
                dialog = sipStack.createDialog((SIPTransaction) transaction);
                dialog.addTransaction(sipTransaction);
                dialog.addRoute(sipRequest);
                sipTransaction.setDialog(dialog, null);
            } 
            {
                sipTransaction.setDialog(dialog, sipRequest.getDialogId(true));
            } 
            {
                boolean var0B3F862740B59B54DE43EACF36DE132E_2114528693 = (sipRequest.getMethod().equals(Request.INVITE) && this.isDialogErrorsAutomaticallyHandled());
                {
                    sipStack.putInMergeTable(st, sipRequest);
                } 
            } 
        } 
        {
            SIPClientTransaction sipClientTx = (SIPClientTransaction) transaction;
            SIPResponse response = sipClientTx.getLastResponse();
            {
                SIPRequest request = (SIPRequest) sipClientTx.getRequest();
                String dialogId = request.getDialogId(false);
                dialog = sipStack.getDialog(dialogId);
                {
                    if (DroidSafeAndroidRuntime.control) throw new SipException("Dialog already exists!");
                } 
                {
                    dialog = sipStack.createDialog(sipTransaction);
                } 
                sipClientTx.setDialog(dialog, null);
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException(
                        "Cannot call this method after response is received!");
            } 
        } 
        dialog.addEventListener(this);
        varB4EAC82CA7396A68D541C85D26508E83_1517786707 = dialog;
        addTaint(transaction.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1517786707.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1517786707;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.855 -0400", hash_original_method = "DDF38266DDD18665F4022DB956C0FE2D", hash_generated_method = "7BA69344B99C75861966FBCF16731179")
    public void transactionErrorEvent(
            SIPTransactionErrorEvent transactionErrorEvent) {
        SIPTransaction transaction = (SIPTransaction) transactionErrorEvent
                .getSource();
        {
            boolean varEB5679C18C9B12FA2BAE5A757A24F70B_403246099 = (transactionErrorEvent.getErrorID() == SIPTransactionErrorEvent.TRANSPORT_ERROR);
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_456881793 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logDebug(
                        "TransportError occured on " + transaction);
                    } 
                } 
                Object errorObject = transactionErrorEvent.getSource();
                Timeout timeout = Timeout.TRANSACTION;
                TimeoutEvent ev = null;
                {
                    ev = new TimeoutEvent(this, (ServerTransaction) errorObject,
                        timeout);
                } 
                {
                    SIPClientTransaction clientTx = (SIPClientTransaction) errorObject;
                    Hop hop = clientTx.getNextHop();
                    {
                        boolean var14AABC1BFDA670FD310E68B0ADF51E6E_139665340 = (sipStack.getRouter() instanceof RouterExt);
                        {
                            ((RouterExt) sipStack.getRouter()).transactionTimeout(hop);
                        } 
                    } 
                    ev = new TimeoutEvent(this, (ClientTransaction) errorObject,
                        timeout);
                } 
                this.handleEvent(ev, (SIPTransaction) errorObject);
            } 
            {
                boolean varBA2AA5FB6DB571657A215B2852A8845C_1672250719 = (transactionErrorEvent.getErrorID() == SIPTransactionErrorEvent.TIMEOUT_ERROR);
                {
                    Object errorObject = transactionErrorEvent.getSource();
                    Timeout timeout = Timeout.TRANSACTION;
                    TimeoutEvent ev = null;
                    {
                        ev = new TimeoutEvent(this, (ServerTransaction) errorObject,
                        timeout);
                    } 
                    {
                        SIPClientTransaction clientTx = (SIPClientTransaction) errorObject;
                        Hop hop = clientTx.getNextHop();
                        {
                            boolean varB881FA8F5666F14D89B37ABE96A32883_1087625502 = (sipStack.getRouter() instanceof RouterExt);
                            {
                                ((RouterExt) sipStack.getRouter()).transactionTimeout(hop);
                            } 
                        } 
                        ev = new TimeoutEvent(this, (ClientTransaction) errorObject,
                        timeout);
                    } 
                    this.handleEvent(ev, (SIPTransaction) errorObject);
                } 
                {
                    boolean var1D2BD6EB7971359DC939AB655EFF19D5_1260857752 = (transactionErrorEvent.getErrorID() == SIPTransactionErrorEvent.TIMEOUT_RETRANSMIT);
                    {
                        Object errorObject = transactionErrorEvent.getSource();
                        Transaction tx = (Transaction) errorObject;
                        {
                            boolean varF2490187573F5BF2EDB9029CF7C0A1EC_64337482 = (tx.getDialog() != null);
                            InternalErrorHandler.handleException("Unexpected event !",
                        this.sipStack.getStackLogger());
                        } 
                        Timeout timeout = Timeout.RETRANSMIT;
                        TimeoutEvent ev = null;
                        {
                            ev = new TimeoutEvent(this, (ServerTransaction) errorObject,
                        timeout);
                        } 
                        {
                            ev = new TimeoutEvent(this, (ClientTransaction) errorObject,
                        timeout);
                        } 
                        this.handleEvent(ev, (SIPTransaction) errorObject);
                    } 
                } 
            } 
        } 
        addTaint(transactionErrorEvent.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.856 -0400", hash_original_method = "3AE2B963E4C8A3C0E767E575A9114D58", hash_generated_method = "CA1DEEAFEBC0F116ADF249346CEEC307")
    public synchronized void dialogErrorEvent(SIPDialogErrorEvent dialogErrorEvent) {
        SIPDialog sipDialog = (SIPDialog) dialogErrorEvent.getSource();
        Reason reason = Reason.AckNotReceived;
        {
            boolean var53D6B456EC61B70D36AF54A9F3CDB0F9_1355386943 = (dialogErrorEvent.getErrorID() == SIPDialogErrorEvent.DIALOG_ACK_NOT_SENT_TIMEOUT);
            {
                reason= Reason.AckNotSent;
            } 
            {
                boolean var1E7F0AE14554EB8BFD0EFB0C0E20AD66_1967661296 = (dialogErrorEvent.getErrorID() == SIPDialogErrorEvent.DIALOG_REINVITE_TIMEOUT);
                {
                    reason = Reason.ReInviteTimeout;
                } 
            } 
        } 
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_837250015 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug(
                    "Dialog TimeoutError occured on " + sipDialog);
            } 
        } 
        DialogTimeoutEvent ev = new DialogTimeoutEvent(this, sipDialog, reason);
        this.handleEvent(ev, null);
        addTaint(dialogErrorEvent.getTaint());
        
        
        
        
        	
        
            
        
        
            
                    
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.857 -0400", hash_original_method = "B3C6AC6D2F49AD76B9521CC6B14816A0", hash_generated_method = "6B83B9119DCE2C1271CD8A395AEF0B09")
    public synchronized ListeningPoint[] getListeningPoints() {
        ListeningPoint[] varB4EAC82CA7396A68D541C85D26508E83_1621412666 = null; 
        ListeningPoint[] retval = new ListeningPointImpl[this.listeningPoints
                .size()];
        this.listeningPoints.values().toArray(retval);
        varB4EAC82CA7396A68D541C85D26508E83_1621412666 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1621412666.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1621412666;
        
        
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.858 -0400", hash_original_method = "EAE5E9A9D2E983810EEEE28894E73A1D", hash_generated_method = "FE80D30035A621F9A7EFD44E1AB51CA8")
    public synchronized void addListeningPoint(ListeningPoint listeningPoint) throws ObjectInUseException {
        ListeningPointImpl lp = (ListeningPointImpl) listeningPoint;
        {
            boolean var3BCAC91CC05C68E3E7CAED1501BAC80F_356387680 = (lp.sipProvider != null && lp.sipProvider != this);
            if (DroidSafeAndroidRuntime.control) throw new ObjectInUseException(
                    "Listening point assigned to another provider");
        } 
        String transport = lp.getTransport().toUpperCase();
        {
            boolean varC7F75F20EF7420C359BD4663920CAE2E_2114953906 = (this.listeningPoints.isEmpty());
            {
                this.address = listeningPoint.getIPAddress();
                this.port = listeningPoint.getPort();
            } 
            {
                {
                    boolean var4B71739EB69CC3B6E23285D5EFA696F4_963487209 = ((!this.address.equals(listeningPoint.getIPAddress()))
                    || this.port != listeningPoint.getPort());
                    if (DroidSafeAndroidRuntime.control) throw new ObjectInUseException(
                        "Provider already has different IP Address associated");
                } 
            } 
        } 
        {
            boolean var17C5A4B83EADE4D85E5EF5F5A08822ED_283443869 = (this.listeningPoints.containsKey(transport)
                && this.listeningPoints.get(transport) != listeningPoint);
            if (DroidSafeAndroidRuntime.control) throw new ObjectInUseException(
                    "Listening point already assigned for transport!");
        } 
        lp.sipProvider = this;
        this.listeningPoints.put(transport, lp);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.858 -0400", hash_original_method = "A95AFDBCCDB5259A8B494C5125AAB0DF", hash_generated_method = "A0AE4139312ADAFBF2F42E2CCEC5E449")
    public synchronized void removeListeningPoint(ListeningPoint listeningPoint) throws ObjectInUseException {
        ListeningPointImpl lp = (ListeningPointImpl) listeningPoint;
        {
            boolean var4778A3EEE85EB9E7DE75311A019149A8_1281202313 = (lp.messageProcessor.inUse());
            if (DroidSafeAndroidRuntime.control) throw new ObjectInUseException("Object is in use");
        } 
        this.listeningPoints.remove(lp.getTransport().toUpperCase());
        addTaint(listeningPoint.getTaint());
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.859 -0400", hash_original_method = "6DABC4D6488D8CA07EA47E3AEA2A5D8B", hash_generated_method = "A82801FE4C2AAE8E6D18738A8894649C")
    public synchronized void removeListeningPoints() {
        {
            Iterator it = this.listeningPoints.values().iterator();
            boolean var9D0EDA54CCAB017AFE33C830CCA36C58_1493691179 = (it
                .hasNext());
            {
                ListeningPointImpl lp = (ListeningPointImpl) it.next();
                lp.messageProcessor.stop();
                it.remove();
            } 
        } 
        
        
                
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.859 -0400", hash_original_method = "08917B93BCD125C29B1D418CFBD693FD", hash_generated_method = "96A4390FCBC998F4A7B54E2F8EF10165")
    public void setAutomaticDialogSupportEnabled(
            boolean automaticDialogSupportEnabled) {
        this.automaticDialogSupportEnabled = automaticDialogSupportEnabled;
        {
            this.dialogErrorsAutomaticallyHandled = true;
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.859 -0400", hash_original_method = "18DDE4A1FF25A19616718FBEC8927BCF", hash_generated_method = "B05C166E3E7FBEF72596B63B405144C8")
    public boolean isAutomaticDialogSupportEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_822509633 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_822509633;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.860 -0400", hash_original_method = "8E72F0F9A971C2A6E1313B02079A711A", hash_generated_method = "21A90BA4CDE53CBAB0B11EDE68F90954")
    public void setDialogErrorsAutomaticallyHandled() {
        this.dialogErrorsAutomaticallyHandled = true;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.860 -0400", hash_original_method = "D32D7DD8A91D988429F699F6AD4CC892", hash_generated_method = "AB8DE902C98BBDD7EDE71B8ED5229255")
    public boolean isDialogErrorsAutomaticallyHandled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1639984687 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1639984687;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.860 -0400", hash_original_method = "C4DC38CCAB12B1686E686A836D3DE2C4", hash_generated_method = "4F5CCCC96DE9878EF942C5DC4090FBC8")
    public SipListener getSipListener() {
        SipListener varB4EAC82CA7396A68D541C85D26508E83_1700905401 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1700905401 = sipListener;
        varB4EAC82CA7396A68D541C85D26508E83_1700905401.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1700905401;
        
        
    }

    
}

