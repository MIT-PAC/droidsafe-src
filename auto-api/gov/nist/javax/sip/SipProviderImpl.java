package gov.nist.javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.516 -0400", hash_original_field = "C2742B0786D982D4EE3DCECCEC00E889", hash_generated_field = "C372B5B3448581C0F5822346BC5BF6B5")

    private SipListener sipListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.516 -0400", hash_original_field = "37460D4BF2BA47A13FF9D922C4B14B2E", hash_generated_field = "4DAF551644AC41AE30E26F4ABCF55488")

    protected SipStackImpl sipStack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.516 -0400", hash_original_field = "3CEAB7318649FC55E6D462942E769E7E", hash_generated_field = "2A53AF8663A42FF261DC56019ACC7569")

    private ConcurrentHashMap listeningPoints;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.516 -0400", hash_original_field = "0C887D575D34CEEB43215C9C2EB3F7E0", hash_generated_field = "B13D933CCB9027F950F0F782A6866769")

    private EventScanner eventScanner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.516 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "27AA4AB7415706F85D71A67C2AA547CB")

    private String address;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.516 -0400", hash_original_field = "901555FB06E346CB065CEB9808DCFC25", hash_generated_field = "D40522EE9D0571A9162D4F847D658065")

    private int port;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.516 -0400", hash_original_field = "03F94425985D4F12F061598392CB27B5", hash_generated_field = "524F32CD9808C18576213A6E5A9B572D")

    private boolean automaticDialogSupportEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.516 -0400", hash_original_field = "B00F9FADF4204970C84368C656AF77CC", hash_generated_field = "5CCA946576EE027FCC33A16438A5DE7B")

    private String IN_ADDR_ANY = "0.0.0.0";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.516 -0400", hash_original_field = "648F89EB1D64275F1AF190105C1418E4", hash_generated_field = "18A343C90CA0F147EDF9BB2788A149EF")

    private String IN6_ADDR_ANY = "::0";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.516 -0400", hash_original_field = "48E1E0D9B22B9E0D75D9E59520D250FF", hash_generated_field = "51E780BD632743E190A61DB4A1929A94")

    private boolean dialogErrorsAutomaticallyHandled = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.516 -0400", hash_original_method = "D7A082BA7BBEB80ADC15AA42F366B72C", hash_generated_method = "58CC0CE0C4D98D56E1D4B23FD5EE5252")
    private  SipProviderImpl() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.517 -0400", hash_original_method = "E70748599E06F3AAB45B7E3DFBC2B3DC", hash_generated_method = "C7D1CA44448B68E5234FA92ECF9809FE")
    protected  SipProviderImpl(SipStackImpl sipStack) {
        this.eventScanner = sipStack.getEventScanner();
        this.sipStack = sipStack;
        this.eventScanner.incrementRefcount();
        this.listeningPoints = new ConcurrentHashMap<String,ListeningPointImpl>();
        this.automaticDialogSupportEnabled = this.sipStack
                .isAutomaticDialogSupportEnabled();
        this.dialogErrorsAutomaticallyHandled = this.sipStack.isAutomaticDialogErrorHandlingEnabled();
        // ---------- Original Method ----------
        //this.eventScanner = sipStack.getEventScanner();
        //this.sipStack = sipStack;
        //this.eventScanner.incrementRefcount();
        //this.listeningPoints = new ConcurrentHashMap<String,ListeningPointImpl>();
        //this.automaticDialogSupportEnabled = this.sipStack
                //.isAutomaticDialogSupportEnabled();
        //this.dialogErrorsAutomaticallyHandled = this.sipStack.isAutomaticDialogErrorHandlingEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.518 -0400", hash_original_method = "11E23C3DFA194FF115BF392A022E2577", hash_generated_method = "FC5708837E5643D74A08C9923DB0A968")
    protected void stop() {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1502758975 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug("Exiting provider");
        } //End collapsed parenthetic
        {
            Iterator it;
            it = listeningPoints.values().iterator();
            boolean var03729FD53960D8DCA3A41A13A0229637_618092064 = (it.hasNext());
            {
                ListeningPointImpl listeningPoint;
                listeningPoint = (ListeningPointImpl) it.next();
                listeningPoint.removeSipProvider();
            } //End block
        } //End collapsed parenthetic
        this.eventScanner.stop();
        // ---------- Original Method ----------
        //if (sipStack.isLoggingEnabled())
            //sipStack.getStackLogger().logDebug("Exiting provider");
        //for (Iterator it = listeningPoints.values().iterator(); it.hasNext();) {
            //ListeningPointImpl listeningPoint = (ListeningPointImpl) it.next();
            //listeningPoint.removeSipProvider();
        //}
        //this.eventScanner.stop();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.519 -0400", hash_original_method = "1158BA9F135FC60D78E0B26F09E9CC9C", hash_generated_method = "D241F27DE214F29C15B901326DAF126B")
    public ListeningPoint getListeningPoint(String transport) {
        ListeningPoint varB4EAC82CA7396A68D541C85D26508E83_1439873809 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Null transport param");
        varB4EAC82CA7396A68D541C85D26508E83_1439873809 = (ListeningPoint) this.listeningPoints.get(transport
                .toUpperCase());
        addTaint(transport.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1439873809.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1439873809;
        // ---------- Original Method ----------
        //if (transport == null)
            //throw new NullPointerException("Null transport param");
        //return (ListeningPoint) this.listeningPoints.get(transport
                //.toUpperCase());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.520 -0400", hash_original_method = "BA46457405F31389F30610967A0B78B2", hash_generated_method = "6436AF1641B96F8679EB18DDA0285F4E")
    public void handleEvent(EventObject sipEvent, SIPTransaction transaction) {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1439812211 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug(
                    "handleEvent " + sipEvent + "currentTransaction = "
                            + transaction + "this.sipListener = "
                            + this.getSipListener() + "sipEvent.source = "
                            + sipEvent.getSource());
                {
                    Dialog dialog;
                    dialog = ((RequestEvent) sipEvent).getDialog();
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1745035639 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger().logDebug("Dialog = " + dialog);
                    } //End collapsed parenthetic
                } //End block
                {
                    Dialog dialog;
                    dialog = ((ResponseEvent) sipEvent).getDialog();
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1753664010 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger().logDebug("Dialog = " + dialog);
                    } //End collapsed parenthetic
                } //End block
                sipStack.getStackLogger().logStackTrace();
            } //End block
        } //End collapsed parenthetic
        EventWrapper eventWrapper;
        eventWrapper = new EventWrapper(sipEvent, transaction);
        {
            this.eventScanner.addEvent(eventWrapper);
        } //End block
        {
            this.eventScanner.deliverEvent(eventWrapper);
        } //End block
        addTaint(sipEvent.getTaint());
        addTaint(transaction.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.532 -0400", hash_original_method = "E6B31C0538AF64C15CAF5AB43FC9524E", hash_generated_method = "A636F3E139EB80DA222248E8ED9B4C28")
    protected Object clone() throws java.lang.CloneNotSupportedException {
        if (DroidSafeAndroidRuntime.control) throw new java.lang.CloneNotSupportedException();
        // ---------- Original Method ----------
        //throw new java.lang.CloneNotSupportedException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.533 -0400", hash_original_method = "C6DB78E4BFC94524622F655361F90AF4", hash_generated_method = "878660698AE955F4BDCB5E2F2E6757E4")
    public void addSipListener(SipListener sipListener) throws TooManyListenersException {
        {
            sipStack.sipListener = sipListener;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new TooManyListenersException(
                    "Stack already has a listener. Only one listener per stack allowed");
        } //End block
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1985714893 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug("add SipListener " + sipListener);
        } //End collapsed parenthetic
        this.sipListener = sipListener;
        // ---------- Original Method ----------
        //if (sipStack.sipListener == null) {
            //sipStack.sipListener = sipListener;
        //} else if (sipStack.sipListener != sipListener) {
            //throw new TooManyListenersException(
                    //"Stack already has a listener. Only one listener per stack allowed");
        //}
        //if (sipStack.isLoggingEnabled())
            //sipStack.getStackLogger().logDebug("add SipListener " + sipListener);
        //this.sipListener = sipListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.533 -0400", hash_original_method = "8DF1BB234AEAFA11A00A3BD7891CCE00", hash_generated_method = "B3CE4507CE4A543FA62DEBA54B1BDF33")
    public ListeningPoint getListeningPoint() {
        ListeningPoint varB4EAC82CA7396A68D541C85D26508E83_663228575 = null; //Variable for return #1
        ListeningPoint varB4EAC82CA7396A68D541C85D26508E83_86157300 = null; //Variable for return #2
        {
            boolean var14A0E82606B7A61F437411D21145307C_1047244263 = (this.listeningPoints.size() > 0);
            varB4EAC82CA7396A68D541C85D26508E83_663228575 = (ListeningPoint) this.listeningPoints.values().iterator()
                    .next();
            varB4EAC82CA7396A68D541C85D26508E83_86157300 = null;
        } //End collapsed parenthetic
        ListeningPoint varA7E53CE21691AB073D9660D615818899_1859976349; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1859976349 = varB4EAC82CA7396A68D541C85D26508E83_663228575;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1859976349 = varB4EAC82CA7396A68D541C85D26508E83_86157300;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1859976349.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1859976349;
        // ---------- Original Method ----------
        //if (this.listeningPoints.size() > 0)
            //return (ListeningPoint) this.listeningPoints.values().iterator()
                    //.next();
        //else
            //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.534 -0400", hash_original_method = "19C35F549E02B2BEFD4FB9F187DBEB25", hash_generated_method = "CDA473D0E6D993EE804DE64B2A1011DE")
    public CallIdHeader getNewCallId() {
        CallIdHeader varB4EAC82CA7396A68D541C85D26508E83_156793160 = null; //Variable for return #1
        String callId;
        callId = Utils.getInstance().generateCallIdentifier(this.getListeningPoint()
                .getIPAddress());
        CallID callid;
        callid = new CallID();
        try 
        {
            callid.setCallId(callId);
        } //End block
        catch (java.text.ParseException ex)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_156793160 = callid;
        varB4EAC82CA7396A68D541C85D26508E83_156793160.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_156793160;
        // ---------- Original Method ----------
        //String callId = Utils.getInstance().generateCallIdentifier(this.getListeningPoint()
                //.getIPAddress());
        //CallID callid = new CallID();
        //try {
            //callid.setCallId(callId);
        //} catch (java.text.ParseException ex) {
        //}
        //return callid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.544 -0400", hash_original_method = "7DCA30FF9D29B59AA737512D4B93FBF9", hash_generated_method = "8C65C29F64B4AE6237F7590F01F50E8F")
    public ClientTransaction getNewClientTransaction(Request request) throws TransactionUnavailableException {
        ClientTransaction varB4EAC82CA7396A68D541C85D26508E83_524635592 = null; //Variable for return #1
        ClientTransaction varB4EAC82CA7396A68D541C85D26508E83_1554852153 = null; //Variable for return #2
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null request");
        {
            boolean var578FC2E912464C4A12E7CF055900B3BB_329908271 = (!sipStack.isAlive());
            if (DroidSafeAndroidRuntime.control) throw new TransactionUnavailableException("Stack is stopped");
        } //End collapsed parenthetic
        SIPRequest sipRequest;
        sipRequest = (SIPRequest) request;
        {
            boolean var8BB3A42522561BC6F555B944E81B9E93_123792586 = (sipRequest.getTransaction() != null);
            if (DroidSafeAndroidRuntime.control) throw new TransactionUnavailableException(
                    "Transaction already assigned to request");
        } //End collapsed parenthetic
        {
            boolean varB8F91E4F13509919B572D4EB6363E0F7_1727459425 = (sipRequest.getMethod().equals(Request.ACK));
            {
                if (DroidSafeAndroidRuntime.control) throw new TransactionUnavailableException ("Cannot create client transaction for  " + Request.ACK);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var8CA8DAE562F4EE2631485504216CC251_223863629 = (sipRequest.getTopmostVia() == null);
            {
                ListeningPointImpl lp;
                lp = (ListeningPointImpl) this
                    .getListeningPoint("udp");
                Via via;
                via = lp.getViaHeader();
                request.setHeader(via);
            } //End block
        } //End collapsed parenthetic
        try 
        {
            sipRequest.checkHeaders();
        } //End block
        catch (ParseException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new TransactionUnavailableException(ex.getMessage(), ex);
        } //End block
        {
            boolean var50EC3F4D5C54E361B47676E619EAAFA0_707389260 = (sipRequest.getTopmostVia().getBranch() != null
                && sipRequest.getTopmostVia().getBranch().startsWith(
                        SIPConstants.BRANCH_MAGIC_COOKIE)
                && sipStack.findTransaction((SIPRequest) request, false) != null);
            {
                if (DroidSafeAndroidRuntime.control) throw new TransactionUnavailableException(
                    "Transaction already exists!");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var80AA6E7CE4CA9828EC141D0C3E8E2623_1042972595 = (request.getMethod().equalsIgnoreCase(Request.CANCEL));
            {
                SIPClientTransaction ct;
                ct = (SIPClientTransaction) sipStack
                    .findCancelTransaction((SIPRequest) request, false);
                {
                    ClientTransaction retval;
                    retval = sipStack.createClientTransaction(
                        (SIPRequest) request, ct.getMessageChannel());
                    ((SIPTransaction) retval).addEventListener(this);
                    sipStack.addTransaction((SIPClientTransaction) retval);
                    {
                        boolean varC6530BD657A7ADFE309456660793CB51_2054883908 = (ct.getDialog() != null);
                        {
                            ((SIPClientTransaction) retval).setDialog((SIPDialog) ct
                            .getDialog(), sipRequest.getDialogId(false));
                        } //End block
                    } //End collapsed parenthetic
                    varB4EAC82CA7396A68D541C85D26508E83_524635592 = retval;
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1511541274 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug(
                    "could not find existing transaction for "
                            + ((SIPRequest) request).getFirstLine()
                            + " creating a new one ");
        } //End collapsed parenthetic
        Hop hop;
        hop = null;
        try 
        {
            hop = sipStack.getNextHop((SIPRequest) request);
            if (DroidSafeAndroidRuntime.control) throw new TransactionUnavailableException(
                        "Cannot resolve next hop -- transaction unavailable");
        } //End block
        catch (SipException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new TransactionUnavailableException(
                    "Cannot resolve next hop -- transaction unavailable", ex);
        } //End block
        String transport;
        transport = hop.getTransport();
        ListeningPointImpl listeningPoint;
        listeningPoint = (ListeningPointImpl) this
                .getListeningPoint(transport);
        String dialogId;
        dialogId = sipRequest.getDialogId(false);
        SIPDialog dialog;
        dialog = sipStack.getDialog(dialogId);
        {
            boolean varF49230B2DD2C6AFABFC95BE0EB70C68C_76231751 = (dialog != null && dialog.getState() == DialogState.TERMINATED);
            {
                sipStack.removeDialog(dialog);
            } //End block
        } //End collapsed parenthetic
        try 
        {
            String branchId;
            branchId = null;
            {
                boolean var93A504DCD46E7EC8683F0CC8BFF98434_621067159 = (sipRequest.getTopmostVia().getBranch() == null
                    || !sipRequest.getTopmostVia().getBranch().startsWith(
                            SIPConstants.BRANCH_MAGIC_COOKIE)
                            || sipStack.checkBranchId());
                {
                    branchId = Utils.getInstance().generateBranchId();
                    sipRequest.getTopmostVia().setBranch(branchId);
                } //End block
            } //End collapsed parenthetic
            Via topmostVia;
            topmostVia = sipRequest.getTopmostVia();
            {
                boolean var3017E8004C459CC9B3CF01C4594DE1C8_238162809 = (topmostVia.getTransport() == null);
                topmostVia.setTransport(transport);
            } //End collapsed parenthetic
            {
                boolean var8F4A7E15EB4EA45A579CA903340B0597_894904637 = (topmostVia.getPort() == -1);
                topmostVia.setPort(listeningPoint.getPort());
            } //End collapsed parenthetic
            branchId = sipRequest.getTopmostVia().getBranch();
            SIPClientTransaction ct;
            ct = (SIPClientTransaction) sipStack
                    .createMessageChannel(sipRequest, listeningPoint
                            .getMessageProcessor(), hop);
            if (DroidSafeAndroidRuntime.control) throw new TransactionUnavailableException("Cound not create tx");
            ct.setNextHop(hop);
            ct.setOriginalRequest(sipRequest);
            ct.setBranch(branchId);
            {
                boolean var7367A0764DE5A8FD72A1BB83DDF82032_1149465411 = (sipStack.isDialogCreated(request.getMethod()));
                {
                    ct.setDialog(dialog, sipRequest.getDialogId(false));
                    {
                        boolean var3C17FD797D120D8CEAA3BBA32E798D99_770182720 = (this.isAutomaticDialogSupportEnabled());
                        {
                            SIPDialog sipDialog;
                            sipDialog = sipStack.createDialog(ct);
                            ct.setDialog(sipDialog, sipRequest.getDialogId(false));
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    {
                        ct.setDialog(dialog, sipRequest.getDialogId(false));
                    } //End block
                } //End block
            } //End collapsed parenthetic
            ct.addEventListener(this);
            varB4EAC82CA7396A68D541C85D26508E83_1554852153 = (ClientTransaction) ct;
        } //End block
        catch (IOException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new TransactionUnavailableException(
                    "Could not resolve next hop or listening point unavailable! ",
                    ex);
        } //End block
        catch (java.text.ParseException ex)
        {
            InternalErrorHandler.handleException(ex);
            if (DroidSafeAndroidRuntime.control) throw new TransactionUnavailableException(
                    "Unexpected Exception FIXME! ", ex);
        } //End block
        catch (InvalidArgumentException ex)
        {
            InternalErrorHandler.handleException(ex);
            if (DroidSafeAndroidRuntime.control) throw new TransactionUnavailableException(
                    "Unexpected Exception FIXME! ", ex);
        } //End block
        addTaint(request.getTaint());
        ClientTransaction varA7E53CE21691AB073D9660D615818899_37920554; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_37920554 = varB4EAC82CA7396A68D541C85D26508E83_524635592;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_37920554 = varB4EAC82CA7396A68D541C85D26508E83_1554852153;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_37920554.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_37920554;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.566 -0400", hash_original_method = "569DCDD9EB405C75F83E1325FE87C1D4", hash_generated_method = "CD533E03A44E3636D715352CE90EC30B")
    public ServerTransaction getNewServerTransaction(Request request) throws TransactionAlreadyExistsException,
            TransactionUnavailableException {
        ServerTransaction varB4EAC82CA7396A68D541C85D26508E83_493279666 = null; //Variable for return #1
        ServerTransaction varB4EAC82CA7396A68D541C85D26508E83_467554896 = null; //Variable for return #2
        ServerTransaction varB4EAC82CA7396A68D541C85D26508E83_374603451 = null; //Variable for return #3
        {
            boolean var578FC2E912464C4A12E7CF055900B3BB_184702238 = (!sipStack.isAlive());
            if (DroidSafeAndroidRuntime.control) throw new TransactionUnavailableException("Stack is stopped");
        } //End collapsed parenthetic
        SIPServerTransaction transaction;
        transaction = null;
        SIPRequest sipRequest;
        sipRequest = (SIPRequest) request;
        try 
        {
            sipRequest.checkHeaders();
        } //End block
        catch (ParseException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new TransactionUnavailableException(ex.getMessage(), ex);
        } //End block
        {
            boolean var201B05658C4F9A1218A263AD3BFB8279_386405211 = (request.getMethod().equals(Request.ACK));
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_234359393 = (sipStack.isLoggingEnabled());
                    sipStack.getStackLogger().logError("Creating server transaction for ACK -- makes no sense!");
                } //End collapsed parenthetic
                if (DroidSafeAndroidRuntime.control) throw new TransactionUnavailableException("Cannot create Server transaction for ACK ");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var5680F486E9BBA4AE3D51DC65AE40A32A_260909286 = (sipRequest.getMethod().equals(Request.NOTIFY)
                && sipRequest.getFromTag() != null
                && sipRequest.getToTag() == null);
            {
                SIPClientTransaction ct;
                ct = sipStack.findSubscribeTransaction(
                    sipRequest, (ListeningPointImpl) this.getListeningPoint());
                {
                    if (DroidSafeAndroidRuntime.control) throw new TransactionUnavailableException(
                        "Cannot find matching Subscription (and gov.nist.javax.sip.DELIVER_UNSOLICITED_NOTIFY not set)");
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            boolean var848472C21B8ED1A338982BFE859C21F4_1889130518 = (!sipStack.acquireSem());
            {
                if (DroidSafeAndroidRuntime.control) throw new TransactionUnavailableException(
            "Transaction not available -- could not acquire stack lock");
            } //End block
        } //End collapsed parenthetic
        try 
        {
            {
                boolean var79496FCF147EE808D85E5D971644F143_1768985337 = (sipStack.isDialogCreated(sipRequest.getMethod()));
                {
                    {
                        boolean var0BF221D48246E2D3EEB627BFEB1153DC_1011168778 = (sipStack.findTransaction((SIPRequest) request, true) != null);
                        if (DroidSafeAndroidRuntime.control) throw new TransactionAlreadyExistsException(
                    "server transaction already exists!");
                    } //End collapsed parenthetic
                    transaction = (SIPServerTransaction) ((SIPRequest) request)
                .getTransaction();
                    if (DroidSafeAndroidRuntime.control) throw new TransactionUnavailableException(
                    "Transaction not available");
                    {
                        boolean varBF65D8C1DA9C53FFACBDFD6709555F00_978775632 = (transaction.getOriginalRequest() == null);
                        transaction.setOriginalRequest(sipRequest);
                    } //End collapsed parenthetic
                    try 
                    {
                        sipStack.addTransaction(transaction);
                    } //End block
                    catch (IOException ex)
                    {
                        if (DroidSafeAndroidRuntime.control) throw new TransactionUnavailableException(
                    "Error sending provisional response");
                    } //End block
                    transaction.addEventListener(this);
                    {
                        boolean var2FA53F6CD609BAD905BD45D19390D125_698667408 = (isAutomaticDialogSupportEnabled());
                        {
                            String dialogId;
                            dialogId = sipRequest.getDialogId(true);
                            SIPDialog dialog;
                            dialog = sipStack.getDialog(dialogId);
                            {
                                dialog = sipStack.createDialog(transaction);
                            } //End block
                            transaction.setDialog(dialog, sipRequest.getDialogId(true));
                            {
                                boolean varFD733B0149A61F36E79D158A24EC42DF_1319450214 = (sipRequest.getMethod().equals(Request.INVITE) && this.isDialogErrorsAutomaticallyHandled());
                                {
                                    sipStack.putInMergeTable(transaction, sipRequest);
                                } //End block
                            } //End collapsed parenthetic
                            dialog.addRoute(sipRequest);
                            {
                                boolean var552B1EE59DF17D024C651A7B3230204F_829435274 = (dialog.getRemoteTag() != null
                            && dialog.getLocalTag() != null);
                                {
                                    this.sipStack.putDialog(dialog);
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    {
                        boolean var2FA53F6CD609BAD905BD45D19390D125_399125763 = (isAutomaticDialogSupportEnabled());
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
                                boolean varE88996A36B6F456EF82A880E4DAEAD09_158843940 = (transaction.getOriginalRequest() == null);
                                transaction.setOriginalRequest(sipRequest);
                            } //End collapsed parenthetic
                            try 
                            {
                                sipStack.addTransaction(transaction);
                            } //End block
                            catch (IOException ex)
                            {
                                if (DroidSafeAndroidRuntime.control) throw new TransactionUnavailableException(
                        "Could not send back provisional response!");
                            } //End block
                            String dialogId;
                            dialogId = sipRequest.getDialogId(true);
                            SIPDialog dialog;
                            dialog = sipStack.getDialog(dialogId);
                            {
                                dialog.addTransaction(transaction);
                                dialog.addRoute(sipRequest);
                                transaction.setDialog(dialog, sipRequest.getDialogId(true));
                            } //End block
                        } //End block
                        {
                            transaction = (SIPServerTransaction) sipStack.findTransaction(
                            (SIPRequest) request, true);
                            if (DroidSafeAndroidRuntime.control) throw new TransactionAlreadyExistsException(
                        "Transaction exists! ");
                            transaction = (SIPServerTransaction) ((SIPRequest) request)
                    .getTransaction();
                            {
                                {
                                    boolean varA9E3FDFA9EFE1D53F3B4B78E55F1D450_1725430722 = (transaction.getOriginalRequest() == null);
                                    transaction.setOriginalRequest(sipRequest);
                                } //End collapsed parenthetic
                                sipStack.mapTransaction(transaction);
                                String dialogId;
                                dialogId = sipRequest.getDialogId(true);
                                SIPDialog dialog;
                                dialog = sipStack.getDialog(dialogId);
                                {
                                    dialog.addTransaction(transaction);
                                    dialog.addRoute(sipRequest);
                                    transaction.setDialog(dialog, sipRequest
                                    .getDialogId(true));
                                } //End block
                                varB4EAC82CA7396A68D541C85D26508E83_493279666 = transaction;
                            } //End block
                            {
                                MessageChannel mc;
                                mc = (MessageChannel) sipRequest
                        .getMessageChannel();
                                transaction = sipStack.createServerTransaction(mc);
                                if (DroidSafeAndroidRuntime.control) throw new TransactionUnavailableException(
                            "Transaction unavailable -- too many servrer transactions");
                                transaction.setOriginalRequest(sipRequest);
                                sipStack.mapTransaction(transaction);
                                String dialogId;
                                dialogId = sipRequest.getDialogId(true);
                                SIPDialog dialog;
                                dialog = sipStack.getDialog(dialogId);
                                {
                                    dialog.addTransaction(transaction);
                                    dialog.addRoute(sipRequest);
                                    transaction.setDialog(dialog, sipRequest
                                    .getDialogId(true));
                                } //End block
                                varB4EAC82CA7396A68D541C85D26508E83_467554896 = transaction;
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_374603451 = transaction;
        } //End block
        finally 
        {
            sipStack.releaseSem();
        } //End block
        addTaint(request.getTaint());
        ServerTransaction varA7E53CE21691AB073D9660D615818899_1823290648; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1823290648 = varB4EAC82CA7396A68D541C85D26508E83_493279666;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1823290648 = varB4EAC82CA7396A68D541C85D26508E83_467554896;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1823290648 = varB4EAC82CA7396A68D541C85D26508E83_374603451;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1823290648.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1823290648;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.568 -0400", hash_original_method = "4583BF79BF08EE358F0E8CEF923996E7", hash_generated_method = "12B46BFA5E79B79CC28E8DE93E9CAAEA")
    public SipStack getSipStack() {
        SipStack varB4EAC82CA7396A68D541C85D26508E83_712479904 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_712479904 = (SipStack) this.sipStack;
        varB4EAC82CA7396A68D541C85D26508E83_712479904.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_712479904;
        // ---------- Original Method ----------
        //return (SipStack) this.sipStack;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.589 -0400", hash_original_method = "8E603E1E5B83B3D4BA739C213D2D52AF", hash_generated_method = "2138EE78555671F66039C39BEB4E1042")
    public void removeSipListener(SipListener sipListener) {
        {
            boolean var3EBAC163BF77AB77C6C843748C56504B_781819972 = (sipListener == this.getSipListener());
            {
                this.sipListener = null;
            } //End block
        } //End collapsed parenthetic
        boolean found;
        found = false;
        {
            Iterator<SipProviderImpl> it;
            it = sipStack.getSipProviders();
            boolean var03729FD53960D8DCA3A41A13A0229637_1838223682 = (it.hasNext());
            {
                SipProviderImpl nextProvider;
                nextProvider = (SipProviderImpl) it.next();
                {
                    boolean varD3FFA706FB203019969170CA77B23E96_954252096 = (nextProvider.getSipListener() != null);
                    found = true;
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            sipStack.sipListener = null;
        } //End block
        // ---------- Original Method ----------
        //if (sipListener == this.getSipListener()) {
            //this.sipListener = null;
        //}
        //boolean found = false;
        //for (Iterator<SipProviderImpl> it = sipStack.getSipProviders(); it.hasNext();) {
            //SipProviderImpl nextProvider = (SipProviderImpl) it.next();
            //if (nextProvider.getSipListener() != null)
                //found = true;
        //}
        //if (!found) {
            //sipStack.sipListener = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.592 -0400", hash_original_method = "5A8CC74B0BB93A3DC57DF48200955F60", hash_generated_method = "8E63C86711BACED792BC663CEAF2EAF4")
    public void sendRequest(Request request) throws SipException {
        {
            boolean var578FC2E912464C4A12E7CF055900B3BB_1972017401 = (!sipStack.isAlive());
            if (DroidSafeAndroidRuntime.control) throw new SipException("Stack is stopped.");
        } //End collapsed parenthetic
        {
            boolean var0D914FFF58AF7E35FFEA8AEDA4904365_528509903 = (((SIPRequest) request).getRequestLine() != null
                && request.getMethod().equals(Request.ACK));
            {
                Dialog dialog;
                dialog = sipStack.getDialog(((SIPRequest) request)
                    .getDialogId(false));
                {
                    boolean varB3B78D170A5FE6F6EEE00296D839FDE4_711729936 = (dialog != null && dialog.getState() != null);
                    {
                        {
                            boolean var2AB968A8303910EE00F810B6DE3410F9_545626374 = (sipStack.isLoggingEnabled());
                            sipStack.getStackLogger().logWarning(
                        "Dialog exists -- you may want to use Dialog.sendAck() "
                                + dialog.getState());
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        Hop hop;
        hop = sipStack.getRouter((SIPRequest) request).getNextHop(request);
        if (DroidSafeAndroidRuntime.control) throw new SipException("could not determine next hop!");
        SIPRequest sipRequest;
        sipRequest = (SIPRequest) request;
        {
            boolean var89D36681177313849BAB68F82102654C_1508502913 = ((!sipRequest.isNullRequest()) && sipRequest.getTopmostVia() == null);
            if (DroidSafeAndroidRuntime.control) throw new SipException("Invalid SipRequest -- no via header!");
        } //End collapsed parenthetic
        try 
        {
            {
                boolean var1F858BD51C91427BBA6B4192654D1334_1005280961 = (!sipRequest.isNullRequest());
                {
                    Via via;
                    via = sipRequest.getTopmostVia();
                    String branch;
                    branch = via.getBranch();
                    {
                        boolean var4D8AFAC764A0F0A938EBB5692AB883DF_587684614 = (branch == null || branch.length() == 0);
                        {
                            via.setBranch(sipRequest.getTransactionId());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            MessageChannel messageChannel;
            messageChannel = null;
            {
                boolean var4902E9C89928CA7671DF78AA0FD2ABF7_2064258491 = (this.listeningPoints.containsKey(hop.getTransport()
                    .toUpperCase()));
                messageChannel = sipStack.createRawMessageChannel(
                        this.getListeningPoint(hop.getTransport()).getIPAddress(),
                        this.getListeningPoint(hop.getTransport()).getPort(), hop);
            } //End collapsed parenthetic
            {
                messageChannel.sendMessage((SIPMessage) sipRequest,hop);
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException(
                        "Could not create a message channel for "
                                + hop.toString());
            } //End block
        } //End block
        catch (IOException ex)
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1179640155 = (sipStack.isLoggingEnabled());
                {
                    sipStack.getStackLogger().logException(ex);
                } //End block
            } //End collapsed parenthetic
            if (DroidSafeAndroidRuntime.control) throw new SipException(
                    "IO Exception occured while Sending Request", ex);
        } //End block
        catch (ParseException ex1)
        {
            InternalErrorHandler.handleException(ex1);
        } //End block
        finally 
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1086846179 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug(
                        "done sending " + request.getMethod() + " to hop "
                                + hop);
            } //End collapsed parenthetic
        } //End block
        addTaint(request.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.604 -0400", hash_original_method = "9E6954B352C971BA2053951D5F8763C5", hash_generated_method = "12AF59213CBEC9A2C0ADFE094614B59B")
    public void sendResponse(Response response) throws SipException {
        {
            boolean var578FC2E912464C4A12E7CF055900B3BB_663389402 = (!sipStack.isAlive());
            if (DroidSafeAndroidRuntime.control) throw new SipException("Stack is stopped");
        } //End collapsed parenthetic
        SIPResponse sipResponse;
        sipResponse = (SIPResponse) response;
        Via via;
        via = sipResponse.getTopmostVia();
        if (DroidSafeAndroidRuntime.control) throw new SipException("No via header in response!");
        SIPServerTransaction st;
        st = (SIPServerTransaction) sipStack.findTransaction((SIPMessage)response, true);
        {
            boolean var465DED2C2BDB9C2BFE8E77E722F267EE_1402146670 = (st != null   && st.getState() != TransactionState.TERMINATED && this.isAutomaticDialogSupportEnabled());
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException("Transaction exists -- cannot send response statelessly");
            } //End block
        } //End collapsed parenthetic
        String transport;
        transport = via.getTransport();
        String host;
        host = via.getReceived();
        host = via.getHost();
        int port;
        port = via.getRPort();
        {
            port = via.getPort();
            {
                {
                    boolean var0C816DD378EF0BD3D8AA055CCE81D636_1622753819 = (transport.equalsIgnoreCase("TLS"));
                    port = 5061;
                    port = 5060;
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            boolean var46F57E4064B6D60D041159437F70D44E_1826635289 = (host.indexOf(":") > 0);
            {
                boolean varFD50F873716FDE8220E1F82E415385FD_607926114 = (host.indexOf("[") < 0);
                host = "[" + host + "]";
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        Hop hop;
        hop = sipStack.getAddressResolver().resolveAddress(
                new HopImpl(host, port, transport));
        try 
        {
            ListeningPointImpl listeningPoint;
            listeningPoint = (ListeningPointImpl) this
                    .getListeningPoint(transport);
            if (DroidSafeAndroidRuntime.control) throw new SipException(
                        "whoopsa daisy! no listening point found for transport "
                                + transport);
            MessageChannel messageChannel;
            messageChannel = sipStack.createRawMessageChannel(
                    this.getListeningPoint(hop.getTransport()).getIPAddress(),
                    listeningPoint.port, hop);
            messageChannel.sendMessage(sipResponse);
        } //End block
        catch (IOException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException(ex.getMessage());
        } //End block
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.605 -0400", hash_original_method = "0E16D45CFEA7D246360E28B311FFB756", hash_generated_method = "95E41EC2B63A0827002F012B0BC489C5")
    public synchronized void setListeningPoint(ListeningPoint listeningPoint) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Null listening point");
        ListeningPointImpl lp;
        lp = (ListeningPointImpl) listeningPoint;
        lp.sipProvider = this;
        String transport;
        transport = lp.getTransport().toUpperCase();
        this.address = listeningPoint.getIPAddress();
        this.port = listeningPoint.getPort();
        this.listeningPoints.clear();
        this.listeningPoints.put(transport, listeningPoint);
        // ---------- Original Method ----------
        //if (listeningPoint == null)
            //throw new NullPointerException("Null listening point");
        //ListeningPointImpl lp = (ListeningPointImpl) listeningPoint;
        //lp.sipProvider = this;
        //String transport = lp.getTransport().toUpperCase();
        //this.address = listeningPoint.getIPAddress();
        //this.port = listeningPoint.getPort();
        //this.listeningPoints.clear();
        //this.listeningPoints.put(transport, listeningPoint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.606 -0400", hash_original_method = "9D9F76163655F94EC324A9002FE39206", hash_generated_method = "E328A1AA91B2354F4AD3254FF6E40371")
    public Dialog getNewDialog(Transaction transaction) throws SipException {
        Dialog varB4EAC82CA7396A68D541C85D26508E83_1894987993 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Null transaction!");
        {
            boolean var578FC2E912464C4A12E7CF055900B3BB_1774127979 = (!sipStack.isAlive());
            if (DroidSafeAndroidRuntime.control) throw new SipException("Stack is stopped.");
        } //End collapsed parenthetic
        {
            boolean var0C3E3A9E68AD0E7B77C01858D9A4E447_1634208773 = (isAutomaticDialogSupportEnabled());
            if (DroidSafeAndroidRuntime.control) throw new SipException(" Error - AUTOMATIC_DIALOG_SUPPORT is on");
        } //End collapsed parenthetic
        {
            boolean var0B2E45F30D15A6A8FAE246273421368A_1032764689 = (!sipStack.isDialogCreated(transaction.getRequest().getMethod()));
            if (DroidSafeAndroidRuntime.control) throw new SipException("Dialog cannot be created for this method "
                    + transaction.getRequest().getMethod());
        } //End collapsed parenthetic
        SIPDialog dialog;
        dialog = null;
        SIPTransaction sipTransaction;
        sipTransaction = (SIPTransaction) transaction;
        {
            SIPServerTransaction st;
            st = (SIPServerTransaction) transaction;
            Response response;
            response = st.getLastResponse();
            {
                {
                    boolean var3304D06C4D0D68DD58BC19A499B51896_1693407337 = (response.getStatusCode() != 100);
                    if (DroidSafeAndroidRuntime.control) throw new SipException(
                            "Cannot set dialog after response has been sent");
                } //End collapsed parenthetic
            } //End block
            SIPRequest sipRequest;
            sipRequest = (SIPRequest) transaction.getRequest();
            String dialogId;
            dialogId = sipRequest.getDialogId(true);
            dialog = sipStack.getDialog(dialogId);
            {
                dialog = sipStack.createDialog((SIPTransaction) transaction);
                dialog.addTransaction(sipTransaction);
                dialog.addRoute(sipRequest);
                sipTransaction.setDialog(dialog, null);
            } //End block
            {
                sipTransaction.setDialog(dialog, sipRequest.getDialogId(true));
            } //End block
            {
                boolean var0B3F862740B59B54DE43EACF36DE132E_584626406 = (sipRequest.getMethod().equals(Request.INVITE) && this.isDialogErrorsAutomaticallyHandled());
                {
                    sipStack.putInMergeTable(st, sipRequest);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            SIPClientTransaction sipClientTx;
            sipClientTx = (SIPClientTransaction) transaction;
            SIPResponse response;
            response = sipClientTx.getLastResponse();
            {
                SIPRequest request;
                request = (SIPRequest) sipClientTx.getRequest();
                String dialogId;
                dialogId = request.getDialogId(false);
                dialog = sipStack.getDialog(dialogId);
                {
                    if (DroidSafeAndroidRuntime.control) throw new SipException("Dialog already exists!");
                } //End block
                {
                    dialog = sipStack.createDialog(sipTransaction);
                } //End block
                sipClientTx.setDialog(dialog, null);
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException(
                        "Cannot call this method after response is received!");
            } //End block
        } //End block
        dialog.addEventListener(this);
        varB4EAC82CA7396A68D541C85D26508E83_1894987993 = dialog;
        addTaint(transaction.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1894987993.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1894987993;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.616 -0400", hash_original_method = "DDF38266DDD18665F4022DB956C0FE2D", hash_generated_method = "483F420972E2C757EDDDC3730243D187")
    public void transactionErrorEvent(
            SIPTransactionErrorEvent transactionErrorEvent) {
        SIPTransaction transaction;
        transaction = (SIPTransaction) transactionErrorEvent
                .getSource();
        {
            boolean varEB5679C18C9B12FA2BAE5A757A24F70B_1925570447 = (transactionErrorEvent.getErrorID() == SIPTransactionErrorEvent.TRANSPORT_ERROR);
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1980101705 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logDebug(
                        "TransportError occured on " + transaction);
                    } //End block
                } //End collapsed parenthetic
                Object errorObject;
                errorObject = transactionErrorEvent.getSource();
                Timeout timeout;
                timeout = Timeout.TRANSACTION;
                TimeoutEvent ev;
                ev = null;
                {
                    ev = new TimeoutEvent(this, (ServerTransaction) errorObject,
                        timeout);
                } //End block
                {
                    SIPClientTransaction clientTx;
                    clientTx = (SIPClientTransaction) errorObject;
                    Hop hop;
                    hop = clientTx.getNextHop();
                    {
                        boolean var14AABC1BFDA670FD310E68B0ADF51E6E_107290489 = (sipStack.getRouter() instanceof RouterExt);
                        {
                            ((RouterExt) sipStack.getRouter()).transactionTimeout(hop);
                        } //End block
                    } //End collapsed parenthetic
                    ev = new TimeoutEvent(this, (ClientTransaction) errorObject,
                        timeout);
                } //End block
                this.handleEvent(ev, (SIPTransaction) errorObject);
            } //End block
            {
                boolean varBA2AA5FB6DB571657A215B2852A8845C_1301032637 = (transactionErrorEvent.getErrorID() == SIPTransactionErrorEvent.TIMEOUT_ERROR);
                {
                    Object errorObject;
                    errorObject = transactionErrorEvent.getSource();
                    Timeout timeout;
                    timeout = Timeout.TRANSACTION;
                    TimeoutEvent ev;
                    ev = null;
                    {
                        ev = new TimeoutEvent(this, (ServerTransaction) errorObject,
                        timeout);
                    } //End block
                    {
                        SIPClientTransaction clientTx;
                        clientTx = (SIPClientTransaction) errorObject;
                        Hop hop;
                        hop = clientTx.getNextHop();
                        {
                            boolean varB881FA8F5666F14D89B37ABE96A32883_1938768743 = (sipStack.getRouter() instanceof RouterExt);
                            {
                                ((RouterExt) sipStack.getRouter()).transactionTimeout(hop);
                            } //End block
                        } //End collapsed parenthetic
                        ev = new TimeoutEvent(this, (ClientTransaction) errorObject,
                        timeout);
                    } //End block
                    this.handleEvent(ev, (SIPTransaction) errorObject);
                } //End block
                {
                    boolean var1D2BD6EB7971359DC939AB655EFF19D5_455853937 = (transactionErrorEvent.getErrorID() == SIPTransactionErrorEvent.TIMEOUT_RETRANSMIT);
                    {
                        Object errorObject;
                        errorObject = transactionErrorEvent.getSource();
                        Transaction tx;
                        tx = (Transaction) errorObject;
                        {
                            boolean varF2490187573F5BF2EDB9029CF7C0A1EC_1574296540 = (tx.getDialog() != null);
                            InternalErrorHandler.handleException("Unexpected event !",
                        this.sipStack.getStackLogger());
                        } //End collapsed parenthetic
                        Timeout timeout;
                        timeout = Timeout.RETRANSMIT;
                        TimeoutEvent ev;
                        ev = null;
                        {
                            ev = new TimeoutEvent(this, (ServerTransaction) errorObject,
                        timeout);
                        } //End block
                        {
                            ev = new TimeoutEvent(this, (ClientTransaction) errorObject,
                        timeout);
                        } //End block
                        this.handleEvent(ev, (SIPTransaction) errorObject);
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        addTaint(transactionErrorEvent.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.617 -0400", hash_original_method = "3AE2B963E4C8A3C0E767E575A9114D58", hash_generated_method = "6E0550018F320A38D0294BD65C220816")
    public synchronized void dialogErrorEvent(SIPDialogErrorEvent dialogErrorEvent) {
        SIPDialog sipDialog;
        sipDialog = (SIPDialog) dialogErrorEvent.getSource();
        Reason reason;
        reason = Reason.AckNotReceived;
        {
            boolean var53D6B456EC61B70D36AF54A9F3CDB0F9_806518077 = (dialogErrorEvent.getErrorID() == SIPDialogErrorEvent.DIALOG_ACK_NOT_SENT_TIMEOUT);
            {
                reason= Reason.AckNotSent;
            } //End block
            {
                boolean var1E7F0AE14554EB8BFD0EFB0C0E20AD66_2031818208 = (dialogErrorEvent.getErrorID() == SIPDialogErrorEvent.DIALOG_REINVITE_TIMEOUT);
                {
                    reason = Reason.ReInviteTimeout;
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1492931493 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug(
                    "Dialog TimeoutError occured on " + sipDialog);
            } //End block
        } //End collapsed parenthetic
        DialogTimeoutEvent ev;
        ev = new DialogTimeoutEvent(this, sipDialog, reason);
        this.handleEvent(ev, null);
        addTaint(dialogErrorEvent.getTaint());
        // ---------- Original Method ----------
        //SIPDialog sipDialog = (SIPDialog) dialogErrorEvent.getSource();
        //Reason reason = Reason.AckNotReceived;
        //if (dialogErrorEvent.getErrorID() == SIPDialogErrorEvent.DIALOG_ACK_NOT_SENT_TIMEOUT) {
        	//reason= Reason.AckNotSent;
        //} else if (dialogErrorEvent.getErrorID() == SIPDialogErrorEvent.DIALOG_REINVITE_TIMEOUT) {
            //reason = Reason.ReInviteTimeout;
        //}
        //if (sipStack.isLoggingEnabled()) {
            //sipStack.getStackLogger().logDebug(
                    //"Dialog TimeoutError occured on " + sipDialog);
        //}
        //DialogTimeoutEvent ev = new DialogTimeoutEvent(this, sipDialog, reason);
        //this.handleEvent(ev, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.630 -0400", hash_original_method = "B3C6AC6D2F49AD76B9521CC6B14816A0", hash_generated_method = "6613C3051A7F3359012D9909072A35E4")
    public synchronized ListeningPoint[] getListeningPoints() {
        ListeningPoint[] varB4EAC82CA7396A68D541C85D26508E83_46147079 = null; //Variable for return #1
        ListeningPoint[] retval;
        retval = new ListeningPointImpl[this.listeningPoints
                .size()];
        this.listeningPoints.values().toArray(retval);
        varB4EAC82CA7396A68D541C85D26508E83_46147079 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_46147079.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_46147079;
        // ---------- Original Method ----------
        //ListeningPoint[] retval = new ListeningPointImpl[this.listeningPoints
                //.size()];
        //this.listeningPoints.values().toArray(retval);
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.632 -0400", hash_original_method = "EAE5E9A9D2E983810EEEE28894E73A1D", hash_generated_method = "F6B84F8E18C4217D7232D57FE551A41F")
    public synchronized void addListeningPoint(ListeningPoint listeningPoint) throws ObjectInUseException {
        ListeningPointImpl lp;
        lp = (ListeningPointImpl) listeningPoint;
        {
            boolean var3BCAC91CC05C68E3E7CAED1501BAC80F_339426290 = (lp.sipProvider != null && lp.sipProvider != this);
            if (DroidSafeAndroidRuntime.control) throw new ObjectInUseException(
                    "Listening point assigned to another provider");
        } //End collapsed parenthetic
        String transport;
        transport = lp.getTransport().toUpperCase();
        {
            boolean varC7F75F20EF7420C359BD4663920CAE2E_1738981178 = (this.listeningPoints.isEmpty());
            {
                this.address = listeningPoint.getIPAddress();
                this.port = listeningPoint.getPort();
            } //End block
            {
                {
                    boolean var4B71739EB69CC3B6E23285D5EFA696F4_1939687410 = ((!this.address.equals(listeningPoint.getIPAddress()))
                    || this.port != listeningPoint.getPort());
                    if (DroidSafeAndroidRuntime.control) throw new ObjectInUseException(
                        "Provider already has different IP Address associated");
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean var17C5A4B83EADE4D85E5EF5F5A08822ED_2040895840 = (this.listeningPoints.containsKey(transport)
                && this.listeningPoints.get(transport) != listeningPoint);
            if (DroidSafeAndroidRuntime.control) throw new ObjectInUseException(
                    "Listening point already assigned for transport!");
        } //End collapsed parenthetic
        lp.sipProvider = this;
        this.listeningPoints.put(transport, lp);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.633 -0400", hash_original_method = "A95AFDBCCDB5259A8B494C5125AAB0DF", hash_generated_method = "BC80C84C87B1027572564E742B3AF3BA")
    public synchronized void removeListeningPoint(ListeningPoint listeningPoint) throws ObjectInUseException {
        ListeningPointImpl lp;
        lp = (ListeningPointImpl) listeningPoint;
        {
            boolean var4778A3EEE85EB9E7DE75311A019149A8_2034670769 = (lp.messageProcessor.inUse());
            if (DroidSafeAndroidRuntime.control) throw new ObjectInUseException("Object is in use");
        } //End collapsed parenthetic
        this.listeningPoints.remove(lp.getTransport().toUpperCase());
        addTaint(listeningPoint.getTaint());
        // ---------- Original Method ----------
        //ListeningPointImpl lp = (ListeningPointImpl) listeningPoint;
        //if (lp.messageProcessor.inUse())
            //throw new ObjectInUseException("Object is in use");
        //this.listeningPoints.remove(lp.getTransport().toUpperCase());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.635 -0400", hash_original_method = "6DABC4D6488D8CA07EA47E3AEA2A5D8B", hash_generated_method = "14B9F1C2DD26B3B7407DFE87A650C395")
    public synchronized void removeListeningPoints() {
        {
            Iterator it;
            it = this.listeningPoints.values().iterator();
            boolean var9D0EDA54CCAB017AFE33C830CCA36C58_525761605 = (it
                .hasNext());
            {
                ListeningPointImpl lp;
                lp = (ListeningPointImpl) it.next();
                lp.messageProcessor.stop();
                it.remove();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (Iterator it = this.listeningPoints.values().iterator(); it
                //.hasNext();) {
            //ListeningPointImpl lp = (ListeningPointImpl) it.next();
            //lp.messageProcessor.stop();
            //it.remove();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.637 -0400", hash_original_method = "08917B93BCD125C29B1D418CFBD693FD", hash_generated_method = "96A4390FCBC998F4A7B54E2F8EF10165")
    public void setAutomaticDialogSupportEnabled(
            boolean automaticDialogSupportEnabled) {
        this.automaticDialogSupportEnabled = automaticDialogSupportEnabled;
        {
            this.dialogErrorsAutomaticallyHandled = true;
        } //End block
        // ---------- Original Method ----------
        //this.automaticDialogSupportEnabled = automaticDialogSupportEnabled;
        //if ( this.automaticDialogSupportEnabled ) {
            //this.dialogErrorsAutomaticallyHandled = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.638 -0400", hash_original_method = "18DDE4A1FF25A19616718FBEC8927BCF", hash_generated_method = "EF85EE66BDD88B1C52D7815312D58167")
    public boolean isAutomaticDialogSupportEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_163840269 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_163840269;
        // ---------- Original Method ----------
        //return automaticDialogSupportEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.639 -0400", hash_original_method = "8E72F0F9A971C2A6E1313B02079A711A", hash_generated_method = "21A90BA4CDE53CBAB0B11EDE68F90954")
    public void setDialogErrorsAutomaticallyHandled() {
        this.dialogErrorsAutomaticallyHandled = true;
        // ---------- Original Method ----------
        //this.dialogErrorsAutomaticallyHandled = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.648 -0400", hash_original_method = "D32D7DD8A91D988429F699F6AD4CC892", hash_generated_method = "431C4BD69FA4CC41D6B0E499FA3D676B")
    public boolean isDialogErrorsAutomaticallyHandled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2091683845 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2091683845;
        // ---------- Original Method ----------
        //return this.dialogErrorsAutomaticallyHandled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.657 -0400", hash_original_method = "C4DC38CCAB12B1686E686A836D3DE2C4", hash_generated_method = "FE92B2FA68F31DAB27E985A391DC244D")
    public SipListener getSipListener() {
        SipListener varB4EAC82CA7396A68D541C85D26508E83_2101648171 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2101648171 = sipListener;
        varB4EAC82CA7396A68D541C85D26508E83_2101648171.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2101648171;
        // ---------- Original Method ----------
        //return sipListener;
    }

    
}

