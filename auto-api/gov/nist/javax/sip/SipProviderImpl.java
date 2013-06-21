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
    private SipListener sipListener;
    protected SipStackImpl sipStack;
    private ConcurrentHashMap listeningPoints;
    private EventScanner eventScanner;
    private String address;
    private int port;
    private boolean automaticDialogSupportEnabled ;
    private String IN_ADDR_ANY = "0.0.0.0";
    private String IN6_ADDR_ANY = "::0";
    private boolean dialogErrorsAutomaticallyHandled = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.233 -0400", hash_original_method = "D7A082BA7BBEB80ADC15AA42F366B72C", hash_generated_method = "58CC0CE0C4D98D56E1D4B23FD5EE5252")
    @DSModeled(DSC.SAFE)
    private SipProviderImpl() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.233 -0400", hash_original_method = "E70748599E06F3AAB45B7E3DFBC2B3DC", hash_generated_method = "FAB92C0DED783909FED130732A6CEEC2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected SipProviderImpl(SipStackImpl sipStack) {
        dsTaint.addTaint(sipStack.dsTaint);
        this.eventScanner = sipStack.getEventScanner();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.233 -0400", hash_original_method = "11E23C3DFA194FF115BF392A022E2577", hash_generated_method = "0DF8FCEC1BCAD25DAF22FA64AF7D1312")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void stop() {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1186870950 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug("Exiting provider");
        } //End collapsed parenthetic
        {
            Iterator it;
            it = listeningPoints.values().iterator();
            boolean var03729FD53960D8DCA3A41A13A0229637_1942212220 = (it.hasNext());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.234 -0400", hash_original_method = "1158BA9F135FC60D78E0B26F09E9CC9C", hash_generated_method = "3A3641E81BBE78ED0A48FBC3D40931C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ListeningPoint getListeningPoint(String transport) {
        dsTaint.addTaint(transport);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Null transport param");
        ListeningPoint var31A33230E50A5A20CC517AB6A5BD1EC4_947692956 = ((ListeningPoint) this.listeningPoints.get(transport
                .toUpperCase()));
        return (ListeningPoint)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (transport == null)
            //throw new NullPointerException("Null transport param");
        //return (ListeningPoint) this.listeningPoints.get(transport
                //.toUpperCase());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.234 -0400", hash_original_method = "BA46457405F31389F30610967A0B78B2", hash_generated_method = "BD2B3F46A59363883B80A9ADCF10F6E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void handleEvent(EventObject sipEvent, SIPTransaction transaction) {
        dsTaint.addTaint(transaction.dsTaint);
        dsTaint.addTaint(sipEvent.dsTaint);
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_677817602 = (sipStack.isLoggingEnabled());
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
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1032589321 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger().logDebug("Dialog = " + dialog);
                    } //End collapsed parenthetic
                } //End block
                {
                    Dialog dialog;
                    dialog = ((ResponseEvent) sipEvent).getDialog();
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_80601427 = (sipStack.isLoggingEnabled());
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.234 -0400", hash_original_method = "E6B31C0538AF64C15CAF5AB43FC9524E", hash_generated_method = "517B78E11C39239C478E977460165312")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Object clone() throws java.lang.CloneNotSupportedException {
        if (DroidSafeAndroidRuntime.control) throw new java.lang.CloneNotSupportedException();
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new java.lang.CloneNotSupportedException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.234 -0400", hash_original_method = "C6DB78E4BFC94524622F655361F90AF4", hash_generated_method = "FCD5D9266883CE69525A8F3BCBDECA2B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addSipListener(SipListener sipListener) throws TooManyListenersException {
        dsTaint.addTaint(sipListener.dsTaint);
        {
            sipStack.sipListener = sipListener;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new TooManyListenersException(
                    "Stack already has a listener. Only one listener per stack allowed");
        } //End block
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_975364095 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug("add SipListener " + sipListener);
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.235 -0400", hash_original_method = "8DF1BB234AEAFA11A00A3BD7891CCE00", hash_generated_method = "599D030E9ECC500B85BD866058E3CBAB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ListeningPoint getListeningPoint() {
        {
            boolean var14A0E82606B7A61F437411D21145307C_1933149569 = (this.listeningPoints.size() > 0);
            ListeningPoint var49F556D7D0BCCE296AB06948ABE97749_640928277 = ((ListeningPoint) this.listeningPoints.values().iterator()
                    .next());
        } //End collapsed parenthetic
        return (ListeningPoint)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (this.listeningPoints.size() > 0)
            //return (ListeningPoint) this.listeningPoints.values().iterator()
                    //.next();
        //else
            //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.235 -0400", hash_original_method = "19C35F549E02B2BEFD4FB9F187DBEB25", hash_generated_method = "BD17CF13DC458E22F41811119A76F2EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CallIdHeader getNewCallId() {
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
        return (CallIdHeader)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.236 -0400", hash_original_method = "7DCA30FF9D29B59AA737512D4B93FBF9", hash_generated_method = "F31D9076A484B261A1C4DC09AF9FEC38")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ClientTransaction getNewClientTransaction(Request request) throws TransactionUnavailableException {
        dsTaint.addTaint(request.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null request");
        {
            boolean var578FC2E912464C4A12E7CF055900B3BB_1033503029 = (!sipStack.isAlive());
            if (DroidSafeAndroidRuntime.control) throw new TransactionUnavailableException("Stack is stopped");
        } //End collapsed parenthetic
        SIPRequest sipRequest;
        sipRequest = (SIPRequest) request;
        {
            boolean var8BB3A42522561BC6F555B944E81B9E93_333309243 = (sipRequest.getTransaction() != null);
            if (DroidSafeAndroidRuntime.control) throw new TransactionUnavailableException(
                    "Transaction already assigned to request");
        } //End collapsed parenthetic
        {
            boolean varB8F91E4F13509919B572D4EB6363E0F7_1921519639 = (sipRequest.getMethod().equals(Request.ACK));
            {
                if (DroidSafeAndroidRuntime.control) throw new TransactionUnavailableException ("Cannot create client transaction for  " + Request.ACK);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var8CA8DAE562F4EE2631485504216CC251_332661837 = (sipRequest.getTopmostVia() == null);
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
            boolean var50EC3F4D5C54E361B47676E619EAAFA0_759341324 = (sipRequest.getTopmostVia().getBranch() != null
                && sipRequest.getTopmostVia().getBranch().startsWith(
                        SIPConstants.BRANCH_MAGIC_COOKIE)
                && sipStack.findTransaction((SIPRequest) request, false) != null);
            {
                if (DroidSafeAndroidRuntime.control) throw new TransactionUnavailableException(
                    "Transaction already exists!");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var80AA6E7CE4CA9828EC141D0C3E8E2623_1098822062 = (request.getMethod().equalsIgnoreCase(Request.CANCEL));
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
                        boolean varC6530BD657A7ADFE309456660793CB51_755440852 = (ct.getDialog() != null);
                        {
                            ((SIPClientTransaction) retval).setDialog((SIPDialog) ct
                            .getDialog(), sipRequest.getDialogId(false));
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1263153885 = (sipStack.isLoggingEnabled());
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
            boolean varF49230B2DD2C6AFABFC95BE0EB70C68C_2119192855 = (dialog != null && dialog.getState() == DialogState.TERMINATED);
            {
                sipStack.removeDialog(dialog);
            } //End block
        } //End collapsed parenthetic
        try 
        {
            String branchId;
            branchId = null;
            {
                boolean var93A504DCD46E7EC8683F0CC8BFF98434_1065236221 = (sipRequest.getTopmostVia().getBranch() == null
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
                boolean var3017E8004C459CC9B3CF01C4594DE1C8_545643852 = (topmostVia.getTransport() == null);
                topmostVia.setTransport(transport);
            } //End collapsed parenthetic
            {
                boolean var8F4A7E15EB4EA45A579CA903340B0597_2092322291 = (topmostVia.getPort() == -1);
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
                boolean var7367A0764DE5A8FD72A1BB83DDF82032_1851556010 = (sipStack.isDialogCreated(request.getMethod()));
                {
                    ct.setDialog(dialog, sipRequest.getDialogId(false));
                    {
                        boolean var3C17FD797D120D8CEAA3BBA32E798D99_1619178902 = (this.isAutomaticDialogSupportEnabled());
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
        return (ClientTransaction)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.238 -0400", hash_original_method = "569DCDD9EB405C75F83E1325FE87C1D4", hash_generated_method = "6467ACF31CDA3E0301C644DD85CBA607")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ServerTransaction getNewServerTransaction(Request request) throws TransactionAlreadyExistsException,
            TransactionUnavailableException {
        dsTaint.addTaint(request.dsTaint);
        {
            boolean var578FC2E912464C4A12E7CF055900B3BB_196657905 = (!sipStack.isAlive());
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
            boolean var201B05658C4F9A1218A263AD3BFB8279_1940840204 = (request.getMethod().equals(Request.ACK));
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1274450977 = (sipStack.isLoggingEnabled());
                    sipStack.getStackLogger().logError("Creating server transaction for ACK -- makes no sense!");
                } //End collapsed parenthetic
                if (DroidSafeAndroidRuntime.control) throw new TransactionUnavailableException("Cannot create Server transaction for ACK ");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var5680F486E9BBA4AE3D51DC65AE40A32A_1876305575 = (sipRequest.getMethod().equals(Request.NOTIFY)
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
            boolean var848472C21B8ED1A338982BFE859C21F4_104371952 = (!sipStack.acquireSem());
            {
                if (DroidSafeAndroidRuntime.control) throw new TransactionUnavailableException(
            "Transaction not available -- could not acquire stack lock");
            } //End block
        } //End collapsed parenthetic
        try 
        {
            {
                boolean var79496FCF147EE808D85E5D971644F143_1073493248 = (sipStack.isDialogCreated(sipRequest.getMethod()));
                {
                    {
                        boolean var0BF221D48246E2D3EEB627BFEB1153DC_133162514 = (sipStack.findTransaction((SIPRequest) request, true) != null);
                        if (DroidSafeAndroidRuntime.control) throw new TransactionAlreadyExistsException(
                    "server transaction already exists!");
                    } //End collapsed parenthetic
                    transaction = (SIPServerTransaction) ((SIPRequest) request)
                .getTransaction();
                    if (DroidSafeAndroidRuntime.control) throw new TransactionUnavailableException(
                    "Transaction not available");
                    {
                        boolean varBF65D8C1DA9C53FFACBDFD6709555F00_1215452937 = (transaction.getOriginalRequest() == null);
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
                        boolean var2FA53F6CD609BAD905BD45D19390D125_129618852 = (isAutomaticDialogSupportEnabled());
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
                                boolean varFD733B0149A61F36E79D158A24EC42DF_210739177 = (sipRequest.getMethod().equals(Request.INVITE) && this.isDialogErrorsAutomaticallyHandled());
                                {
                                    sipStack.putInMergeTable(transaction, sipRequest);
                                } //End block
                            } //End collapsed parenthetic
                            dialog.addRoute(sipRequest);
                            {
                                boolean var552B1EE59DF17D024C651A7B3230204F_1892296641 = (dialog.getRemoteTag() != null
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
                        boolean var2FA53F6CD609BAD905BD45D19390D125_868873532 = (isAutomaticDialogSupportEnabled());
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
                                boolean varE88996A36B6F456EF82A880E4DAEAD09_2088930569 = (transaction.getOriginalRequest() == null);
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
                                    boolean varA9E3FDFA9EFE1D53F3B4B78E55F1D450_2023953626 = (transaction.getOriginalRequest() == null);
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
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            sipStack.releaseSem();
        } //End block
        return (ServerTransaction)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.238 -0400", hash_original_method = "4583BF79BF08EE358F0E8CEF923996E7", hash_generated_method = "5889196DBC20475B46925E54560C86DA")
    @DSModeled(DSC.SAFE)
    public SipStack getSipStack() {
        return (SipStack)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (SipStack) this.sipStack;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.238 -0400", hash_original_method = "8E603E1E5B83B3D4BA739C213D2D52AF", hash_generated_method = "0DF67BF1AF7FE3BBFF2B908CA415F53D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeSipListener(SipListener sipListener) {
        dsTaint.addTaint(sipListener.dsTaint);
        {
            boolean var3EBAC163BF77AB77C6C843748C56504B_1698245416 = (sipListener == this.getSipListener());
            {
                this.sipListener = null;
            } //End block
        } //End collapsed parenthetic
        boolean found;
        found = false;
        {
            Iterator<SipProviderImpl> it;
            it = sipStack.getSipProviders();
            boolean var03729FD53960D8DCA3A41A13A0229637_1232594611 = (it.hasNext());
            {
                SipProviderImpl nextProvider;
                nextProvider = (SipProviderImpl) it.next();
                {
                    boolean varD3FFA706FB203019969170CA77B23E96_151974885 = (nextProvider.getSipListener() != null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.239 -0400", hash_original_method = "5A8CC74B0BB93A3DC57DF48200955F60", hash_generated_method = "1CE034527E4E831BB3ECFC2CB7DA2E40")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendRequest(Request request) throws SipException {
        dsTaint.addTaint(request.dsTaint);
        {
            boolean var578FC2E912464C4A12E7CF055900B3BB_842927172 = (!sipStack.isAlive());
            if (DroidSafeAndroidRuntime.control) throw new SipException("Stack is stopped.");
        } //End collapsed parenthetic
        {
            boolean var0D914FFF58AF7E35FFEA8AEDA4904365_332246615 = (((SIPRequest) request).getRequestLine() != null
                && request.getMethod().equals(Request.ACK));
            {
                Dialog dialog;
                dialog = sipStack.getDialog(((SIPRequest) request)
                    .getDialogId(false));
                {
                    boolean varB3B78D170A5FE6F6EEE00296D839FDE4_1094160272 = (dialog != null && dialog.getState() != null);
                    {
                        {
                            boolean var2AB968A8303910EE00F810B6DE3410F9_1808048204 = (sipStack.isLoggingEnabled());
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
            boolean var89D36681177313849BAB68F82102654C_433502008 = ((!sipRequest.isNullRequest()) && sipRequest.getTopmostVia() == null);
            if (DroidSafeAndroidRuntime.control) throw new SipException("Invalid SipRequest -- no via header!");
        } //End collapsed parenthetic
        try 
        {
            {
                boolean var1F858BD51C91427BBA6B4192654D1334_1800106184 = (!sipRequest.isNullRequest());
                {
                    Via via;
                    via = sipRequest.getTopmostVia();
                    String branch;
                    branch = via.getBranch();
                    {
                        boolean var4D8AFAC764A0F0A938EBB5692AB883DF_1764112336 = (branch == null || branch.length() == 0);
                        {
                            via.setBranch(sipRequest.getTransactionId());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            MessageChannel messageChannel;
            messageChannel = null;
            {
                boolean var4902E9C89928CA7671DF78AA0FD2ABF7_162690216 = (this.listeningPoints.containsKey(hop.getTransport()
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
                boolean varCD7A6467843458627CC99D2CD95A9CA6_382282178 = (sipStack.isLoggingEnabled());
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
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1518942647 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug(
                        "done sending " + request.getMethod() + " to hop "
                                + hop);
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.240 -0400", hash_original_method = "9E6954B352C971BA2053951D5F8763C5", hash_generated_method = "6163540878B60017B18463B4C1FFF4DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendResponse(Response response) throws SipException {
        dsTaint.addTaint(response.dsTaint);
        {
            boolean var578FC2E912464C4A12E7CF055900B3BB_433404002 = (!sipStack.isAlive());
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
            boolean var465DED2C2BDB9C2BFE8E77E722F267EE_1738895485 = (st != null   && st.getState() != TransactionState.TERMINATED && this.isAutomaticDialogSupportEnabled());
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
                    boolean var0C816DD378EF0BD3D8AA055CCE81D636_625289974 = (transport.equalsIgnoreCase("TLS"));
                    port = 5061;
                    port = 5060;
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            boolean var46F57E4064B6D60D041159437F70D44E_1024479329 = (host.indexOf(":") > 0);
            {
                boolean varFD50F873716FDE8220E1F82E415385FD_1162611720 = (host.indexOf("[") < 0);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.240 -0400", hash_original_method = "0E16D45CFEA7D246360E28B311FFB756", hash_generated_method = "A4415A15692E800B71B594D865C34379")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setListeningPoint(ListeningPoint listeningPoint) {
        dsTaint.addTaint(listeningPoint.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.241 -0400", hash_original_method = "9D9F76163655F94EC324A9002FE39206", hash_generated_method = "DE1AB6CE033148D7FF417687534FE765")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Dialog getNewDialog(Transaction transaction) throws SipException {
        dsTaint.addTaint(transaction.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Null transaction!");
        {
            boolean var578FC2E912464C4A12E7CF055900B3BB_1719201229 = (!sipStack.isAlive());
            if (DroidSafeAndroidRuntime.control) throw new SipException("Stack is stopped.");
        } //End collapsed parenthetic
        {
            boolean var0C3E3A9E68AD0E7B77C01858D9A4E447_146122739 = (isAutomaticDialogSupportEnabled());
            if (DroidSafeAndroidRuntime.control) throw new SipException(" Error - AUTOMATIC_DIALOG_SUPPORT is on");
        } //End collapsed parenthetic
        {
            boolean var0B2E45F30D15A6A8FAE246273421368A_1102398891 = (!sipStack.isDialogCreated(transaction.getRequest().getMethod()));
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
                    boolean var3304D06C4D0D68DD58BC19A499B51896_1273359982 = (response.getStatusCode() != 100);
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
                boolean var0B3F862740B59B54DE43EACF36DE132E_1635507239 = (sipRequest.getMethod().equals(Request.INVITE) && this.isDialogErrorsAutomaticallyHandled());
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
        return (Dialog)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.242 -0400", hash_original_method = "DDF38266DDD18665F4022DB956C0FE2D", hash_generated_method = "0FE896C6F2D83D7E9579293953533A50")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void transactionErrorEvent(
            SIPTransactionErrorEvent transactionErrorEvent) {
        dsTaint.addTaint(transactionErrorEvent.dsTaint);
        SIPTransaction transaction;
        transaction = (SIPTransaction) transactionErrorEvent
                .getSource();
        {
            boolean varEB5679C18C9B12FA2BAE5A757A24F70B_1422613514 = (transactionErrorEvent.getErrorID() == SIPTransactionErrorEvent.TRANSPORT_ERROR);
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1222598827 = (sipStack.isLoggingEnabled());
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
                        boolean var14AABC1BFDA670FD310E68B0ADF51E6E_1232031238 = (sipStack.getRouter() instanceof RouterExt);
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
                boolean varBA2AA5FB6DB571657A215B2852A8845C_1791702210 = (transactionErrorEvent.getErrorID() == SIPTransactionErrorEvent.TIMEOUT_ERROR);
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
                            boolean varB881FA8F5666F14D89B37ABE96A32883_1712490117 = (sipStack.getRouter() instanceof RouterExt);
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
                    boolean var1D2BD6EB7971359DC939AB655EFF19D5_1901757039 = (transactionErrorEvent.getErrorID() == SIPTransactionErrorEvent.TIMEOUT_RETRANSMIT);
                    {
                        Object errorObject;
                        errorObject = transactionErrorEvent.getSource();
                        Transaction tx;
                        tx = (Transaction) errorObject;
                        {
                            boolean varF2490187573F5BF2EDB9029CF7C0A1EC_800222972 = (tx.getDialog() != null);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.242 -0400", hash_original_method = "3AE2B963E4C8A3C0E767E575A9114D58", hash_generated_method = "7B6E7EEDDA5CB4E60E0565DC61C513E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void dialogErrorEvent(SIPDialogErrorEvent dialogErrorEvent) {
        dsTaint.addTaint(dialogErrorEvent.dsTaint);
        SIPDialog sipDialog;
        sipDialog = (SIPDialog) dialogErrorEvent.getSource();
        Reason reason;
        reason = Reason.AckNotReceived;
        {
            boolean var53D6B456EC61B70D36AF54A9F3CDB0F9_1059639979 = (dialogErrorEvent.getErrorID() == SIPDialogErrorEvent.DIALOG_ACK_NOT_SENT_TIMEOUT);
            {
                reason= Reason.AckNotSent;
            } //End block
            {
                boolean var1E7F0AE14554EB8BFD0EFB0C0E20AD66_1529517736 = (dialogErrorEvent.getErrorID() == SIPDialogErrorEvent.DIALOG_REINVITE_TIMEOUT);
                {
                    reason = Reason.ReInviteTimeout;
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1807609589 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug(
                    "Dialog TimeoutError occured on " + sipDialog);
            } //End block
        } //End collapsed parenthetic
        DialogTimeoutEvent ev;
        ev = new DialogTimeoutEvent(this, sipDialog, reason);
        this.handleEvent(ev, null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.243 -0400", hash_original_method = "B3C6AC6D2F49AD76B9521CC6B14816A0", hash_generated_method = "3296A430A3CBFF6DF603A12D6AECDDAF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized ListeningPoint[] getListeningPoints() {
        ListeningPoint[] retval;
        retval = new ListeningPointImpl[this.listeningPoints
                .size()];
        this.listeningPoints.values().toArray(retval);
        return (ListeningPoint[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //ListeningPoint[] retval = new ListeningPointImpl[this.listeningPoints
                //.size()];
        //this.listeningPoints.values().toArray(retval);
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.243 -0400", hash_original_method = "EAE5E9A9D2E983810EEEE28894E73A1D", hash_generated_method = "E5B36880659BF66FFD57D31DA2D42324")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void addListeningPoint(ListeningPoint listeningPoint) throws ObjectInUseException {
        dsTaint.addTaint(listeningPoint.dsTaint);
        ListeningPointImpl lp;
        lp = (ListeningPointImpl) listeningPoint;
        {
            boolean var3BCAC91CC05C68E3E7CAED1501BAC80F_57903175 = (lp.sipProvider != null && lp.sipProvider != this);
            if (DroidSafeAndroidRuntime.control) throw new ObjectInUseException(
                    "Listening point assigned to another provider");
        } //End collapsed parenthetic
        String transport;
        transport = lp.getTransport().toUpperCase();
        {
            boolean varC7F75F20EF7420C359BD4663920CAE2E_1076873438 = (this.listeningPoints.isEmpty());
            {
                this.address = listeningPoint.getIPAddress();
                this.port = listeningPoint.getPort();
            } //End block
            {
                {
                    boolean var4B71739EB69CC3B6E23285D5EFA696F4_40166551 = ((!this.address.equals(listeningPoint.getIPAddress()))
                    || this.port != listeningPoint.getPort());
                    if (DroidSafeAndroidRuntime.control) throw new ObjectInUseException(
                        "Provider already has different IP Address associated");
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean var17C5A4B83EADE4D85E5EF5F5A08822ED_405827379 = (this.listeningPoints.containsKey(transport)
                && this.listeningPoints.get(transport) != listeningPoint);
            if (DroidSafeAndroidRuntime.control) throw new ObjectInUseException(
                    "Listening point already assigned for transport!");
        } //End collapsed parenthetic
        lp.sipProvider = this;
        this.listeningPoints.put(transport, lp);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.243 -0400", hash_original_method = "A95AFDBCCDB5259A8B494C5125AAB0DF", hash_generated_method = "0589337390EBAB6AB5DF091541AA4DC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void removeListeningPoint(ListeningPoint listeningPoint) throws ObjectInUseException {
        dsTaint.addTaint(listeningPoint.dsTaint);
        ListeningPointImpl lp;
        lp = (ListeningPointImpl) listeningPoint;
        {
            boolean var4778A3EEE85EB9E7DE75311A019149A8_1527892144 = (lp.messageProcessor.inUse());
            if (DroidSafeAndroidRuntime.control) throw new ObjectInUseException("Object is in use");
        } //End collapsed parenthetic
        this.listeningPoints.remove(lp.getTransport().toUpperCase());
        // ---------- Original Method ----------
        //ListeningPointImpl lp = (ListeningPointImpl) listeningPoint;
        //if (lp.messageProcessor.inUse())
            //throw new ObjectInUseException("Object is in use");
        //this.listeningPoints.remove(lp.getTransport().toUpperCase());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.243 -0400", hash_original_method = "6DABC4D6488D8CA07EA47E3AEA2A5D8B", hash_generated_method = "5DDF802F24DFF776506EAD499D3D7C76")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void removeListeningPoints() {
        {
            Iterator it;
            it = this.listeningPoints.values().iterator();
            boolean var9D0EDA54CCAB017AFE33C830CCA36C58_312241088 = (it
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.244 -0400", hash_original_method = "08917B93BCD125C29B1D418CFBD693FD", hash_generated_method = "92B4F29A955C04205EE281592922AA30")
    @DSModeled(DSC.SAFE)
    public void setAutomaticDialogSupportEnabled(
            boolean automaticDialogSupportEnabled) {
        dsTaint.addTaint(automaticDialogSupportEnabled);
        {
            this.dialogErrorsAutomaticallyHandled = true;
        } //End block
        // ---------- Original Method ----------
        //this.automaticDialogSupportEnabled = automaticDialogSupportEnabled;
        //if ( this.automaticDialogSupportEnabled ) {
            //this.dialogErrorsAutomaticallyHandled = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.244 -0400", hash_original_method = "18DDE4A1FF25A19616718FBEC8927BCF", hash_generated_method = "0B348BC49208F8261FF23D08A0EC7891")
    @DSModeled(DSC.SAFE)
    public boolean isAutomaticDialogSupportEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return automaticDialogSupportEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.244 -0400", hash_original_method = "8E72F0F9A971C2A6E1313B02079A711A", hash_generated_method = "21A90BA4CDE53CBAB0B11EDE68F90954")
    @DSModeled(DSC.SAFE)
    public void setDialogErrorsAutomaticallyHandled() {
        this.dialogErrorsAutomaticallyHandled = true;
        // ---------- Original Method ----------
        //this.dialogErrorsAutomaticallyHandled = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.244 -0400", hash_original_method = "D32D7DD8A91D988429F699F6AD4CC892", hash_generated_method = "685586814DDC1BFEF3D0043FD717FD8C")
    @DSModeled(DSC.SAFE)
    public boolean isDialogErrorsAutomaticallyHandled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.dialogErrorsAutomaticallyHandled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.244 -0400", hash_original_method = "C4DC38CCAB12B1686E686A836D3DE2C4", hash_generated_method = "7CC974893106D362D7A0EBD5F71F3ACC")
    @DSModeled(DSC.SAFE)
    public SipListener getSipListener() {
        return (SipListener)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sipListener;
    }

    
}

