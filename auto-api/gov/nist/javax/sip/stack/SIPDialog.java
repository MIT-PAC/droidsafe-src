package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.core.InternalErrorHandler;
import gov.nist.core.NameValueList;
import gov.nist.javax.sip.DialogExt;
import gov.nist.javax.sip.ListeningPointImpl;
import gov.nist.javax.sip.SipListenerExt;
import gov.nist.javax.sip.SipProviderImpl;
import gov.nist.javax.sip.Utils;
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.address.SipUri;
import gov.nist.javax.sip.header.Authorization;
import gov.nist.javax.sip.header.CSeq;
import gov.nist.javax.sip.header.Contact;
import gov.nist.javax.sip.header.ContactList;
import gov.nist.javax.sip.header.From;
import gov.nist.javax.sip.header.MaxForwards;
import gov.nist.javax.sip.header.RAck;
import gov.nist.javax.sip.header.RSeq;
import gov.nist.javax.sip.header.Reason;
import gov.nist.javax.sip.header.RecordRoute;
import gov.nist.javax.sip.header.RecordRouteList;
import gov.nist.javax.sip.header.Require;
import gov.nist.javax.sip.header.Route;
import gov.nist.javax.sip.header.RouteList;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.TimeStamp;
import gov.nist.javax.sip.header.To;
import gov.nist.javax.sip.header.Via;
import gov.nist.javax.sip.message.MessageFactoryImpl;
import gov.nist.javax.sip.message.SIPMessage;
import gov.nist.javax.sip.message.SIPRequest;
import gov.nist.javax.sip.message.SIPResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.net.InetAddress;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import javax.sip.ClientTransaction;
import javax.sip.DialogDoesNotExistException;
import javax.sip.DialogState;
import javax.sip.IOExceptionEvent;
import javax.sip.InvalidArgumentException;
import javax.sip.ListeningPoint;
import javax.sip.ObjectInUseException;
import javax.sip.SipException;
import javax.sip.Transaction;
import javax.sip.TransactionDoesNotExistException;
import javax.sip.TransactionState;
import javax.sip.address.Address;
import javax.sip.address.Hop;
import javax.sip.address.SipURI;
import javax.sip.header.CallIdHeader;
import javax.sip.header.ContactHeader;
import javax.sip.header.EventHeader;
import javax.sip.header.OptionTag;
import javax.sip.header.RAckHeader;
import javax.sip.header.RSeqHeader;
import javax.sip.header.ReasonHeader;
import javax.sip.header.RequireHeader;
import javax.sip.header.RouteHeader;
import javax.sip.header.SupportedHeader;
import javax.sip.header.TimeStampHeader;
import javax.sip.message.Request;
import javax.sip.message.Response;

public class SIPDialog implements javax.sip.Dialog, DialogExt {
    private transient boolean dialogTerminatedEventDelivered;
    private transient String stackTrace;
    private String method;
    private transient boolean isAssigned;
    private boolean reInviteFlag;
    private transient Object applicationData;
    private transient SIPRequest originalRequest;
    private SIPResponse lastResponse;
    private transient SIPTransaction firstTransaction;
    private transient SIPTransaction lastTransaction;
    private String dialogId;
    private transient String earlyDialogId;
    private long localSequenceNumber;
    private long remoteSequenceNumber;
    protected String myTag;
    protected String hisTag;
    private RouteList routeList;
    private transient SIPTransactionStack sipStack;
    private int dialogState;
    protected transient boolean ackSeen;
    private transient SIPRequest lastAckSent;
    private SIPRequest lastAckReceived;
    protected transient boolean ackProcessed;
    protected transient DialogTimerTask timerTask;
    protected transient Long nextSeqno;
    private transient int retransmissionTicksLeft;
    private transient int prevRetransmissionTicks;
    private long originalLocalSequenceNumber;
    private transient int ackLine;
    public transient long auditTag = 0;
    protected javax.sip.address.Address localParty;
    protected javax.sip.address.Address remoteParty;
    protected CallIdHeader callIdHeader;
    private boolean serverTransactionFlag;
    private transient SipProviderImpl sipProvider;
    private boolean terminateOnBye;
    private transient boolean byeSent;
    private Address remoteTarget;
    private EventHeader eventHeader;
    private transient long lastInviteOkReceived;
    private transient Semaphore ackSem = new Semaphore(1);
    private transient int reInviteWaitTime = 100;
    private transient DialogDeleteTask dialogDeleteTask;
    private transient DialogDeleteIfNoAckSentTask dialogDeleteIfNoAckSentTask;
    private transient boolean isAcknowledged;
    private transient long highestSequenceNumberAcknowledged = -1;
    private boolean isBackToBackUserAgent;
    private boolean sequenceNumberValidation = true;
    private transient Set<SIPDialogEventListener> eventListeners;
    private Semaphore timerTaskLock = new Semaphore(1);
    protected boolean firstTransactionSecure;
    protected boolean firstTransactionSeen;
    protected String firstTransactionMethod;
    protected String firstTransactionId;
    protected boolean firstTransactionIsServerTransaction;
    protected int firstTransactionPort = 5060;
    protected Contact contactHeader;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.384 -0400", hash_original_method = "B89E344ABA0B0C4EAAF339C3C960DE0F", hash_generated_method = "032DA93E8D301372F51EB873FFB47884")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private SIPDialog(SipProviderImpl provider) {
        dsTaint.addTaint(provider.dsTaint);
        this.terminateOnBye = true;
        this.routeList = new RouteList();
        this.dialogState = NULL_STATE;
        localSequenceNumber = 0;
        remoteSequenceNumber = -1;
        eventListeners = new CopyOnWriteArraySet<SIPDialogEventListener>();
        // ---------- Original Method ----------
        //this.terminateOnBye = true;
        //this.routeList = new RouteList();
        //this.dialogState = NULL_STATE;
        //localSequenceNumber = 0;
        //remoteSequenceNumber = -1;
        //this.sipProvider = provider;
        //eventListeners = new CopyOnWriteArraySet<SIPDialogEventListener>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.385 -0400", hash_original_method = "BE0EB8A93E786CF5997E41E028500B95", hash_generated_method = "F8959E3AD4856B646829858A4DD45277")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPDialog(SIPTransaction transaction) {
        this(transaction.getSipProvider());
        dsTaint.addTaint(transaction.dsTaint);
        SIPRequest sipRequest;
        sipRequest = (SIPRequest) transaction.getRequest();
        this.callIdHeader = sipRequest.getCallId();
        this.earlyDialogId = sipRequest.getDialogId(false);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Null tx");
        this.sipStack = transaction.sipStack;
        this.sipProvider = (SipProviderImpl) transaction.getSipProvider();
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Null Provider!");
        this.addTransaction(transaction);
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_469811830 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("Creating a dialog : " + this);
                sipStack.getStackLogger().logDebug(
                    "provider port = " + this.sipProvider.getListeningPoint().getPort());
                sipStack.getStackLogger().logStackTrace();
            } //End block
        } //End collapsed parenthetic
        this.isBackToBackUserAgent = sipStack.isBackToBackUserAgent;
        addEventListener(sipStack);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.385 -0400", hash_original_method = "0305A0224D6BCDD571D54C883A13EEA2", hash_generated_method = "74975BD2FA92D290D21BFE01D9B6ADF1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPDialog(SIPClientTransaction transaction, SIPResponse sipResponse) {
        this(transaction);
        dsTaint.addTaint(transaction.dsTaint);
        dsTaint.addTaint(sipResponse.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Null SipResponse");
        this.setLastResponse(transaction, sipResponse);
        this.isBackToBackUserAgent = sipStack.isBackToBackUserAgent;
        // ---------- Original Method ----------
        //if (sipResponse == null)
            //throw new NullPointerException("Null SipResponse");
        //this.setLastResponse(transaction, sipResponse);
        //this.isBackToBackUserAgent = sipStack.isBackToBackUserAgent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.385 -0400", hash_original_method = "95FF401EAA7EE3F3C9E78290081B0530", hash_generated_method = "972E74303F49945BE9DB59F983E77FD8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPDialog(SipProviderImpl sipProvider, SIPResponse sipResponse) {
        this(sipProvider);
        dsTaint.addTaint(sipProvider.dsTaint);
        dsTaint.addTaint(sipResponse.dsTaint);
        this.sipStack = (SIPTransactionStack) sipProvider.getSipStack();
        this.setLastResponse(null, sipResponse);
        this.localSequenceNumber = sipResponse.getCSeq().getSeqNumber();
        this.originalLocalSequenceNumber = localSequenceNumber;
        this.myTag = sipResponse.getFrom().getTag();
        this.hisTag = sipResponse.getTo().getTag();
        this.localParty = sipResponse.getFrom().getAddress();
        this.remoteParty = sipResponse.getTo().getAddress();
        this.method = sipResponse.getCSeq().getMethod();
        this.callIdHeader = sipResponse.getCallId();
        this.serverTransactionFlag = false;
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_594688721 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("Creating a dialog : " + this);
                sipStack.getStackLogger().logStackTrace();
            } //End block
        } //End collapsed parenthetic
        this.isBackToBackUserAgent = sipStack.isBackToBackUserAgent;
        addEventListener(sipStack);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.386 -0400", hash_original_method = "9EE497100AA17813744E66E4A05B8669", hash_generated_method = "D6A70551A4C29DD8FEF6C4898914BDCD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void recordStackTrace() {
        StringWriter stringWriter;
        stringWriter = new StringWriter();
        PrintWriter writer;
        writer = new PrintWriter(stringWriter);
        new Exception().printStackTrace(writer);
        this.stackTrace = stringWriter.getBuffer().toString();
        // ---------- Original Method ----------
        //StringWriter stringWriter = new StringWriter();
        //PrintWriter writer = new PrintWriter(stringWriter);
        //new Exception().printStackTrace(writer);
        //this.stackTrace = stringWriter.getBuffer().toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.386 -0400", hash_original_method = "40815EC709415499328FA1CBE062ACB5", hash_generated_method = "AB7BC5D14C6E234389DD2EE1D355B3F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void printRouteList() {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_2026766626 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("this : " + this);
                sipStack.getStackLogger().logDebug("printRouteList : " + this.routeList.encode());
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (sipStack.isLoggingEnabled()) {
            //sipStack.getStackLogger().logDebug("this : " + this);
            //sipStack.getStackLogger().logDebug("printRouteList : " + this.routeList.encode());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.386 -0400", hash_original_method = "6746D685A6EEFE6F86FE53A5B90B58CB", hash_generated_method = "75D36357D1FD98B812D56B0AF1F1D8BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isClientDialog() {
        SIPTransaction transaction;
        transaction = (SIPTransaction) this.getFirstTransaction();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //SIPTransaction transaction = (SIPTransaction) this.getFirstTransaction();
        //return transaction instanceof SIPClientTransaction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.386 -0400", hash_original_method = "871D6D7CB1794492ED7691CB8C5B804E", hash_generated_method = "1D6FDEE4ADC4C9FE92D79AA4AE2E771D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void raiseIOException(String host, int port, String protocol) {
        dsTaint.addTaint(port);
        dsTaint.addTaint(protocol);
        dsTaint.addTaint(host);
        IOExceptionEvent ioError;
        ioError = new IOExceptionEvent(this, host, port, protocol);
        sipProvider.handleEvent(ioError, null);
        setState(SIPDialog.TERMINATED_STATE);
        // ---------- Original Method ----------
        //IOExceptionEvent ioError = new IOExceptionEvent(this, host, port, protocol);
        //sipProvider.handleEvent(ioError, null);
        //setState(SIPDialog.TERMINATED_STATE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.386 -0400", hash_original_method = "352742C76D82997D1FD2B39635FE380F", hash_generated_method = "E3ADBFDF445AD33DC4091A1ACB722EE3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void raiseErrorEvent(int dialogTimeoutError) {
        dsTaint.addTaint(dialogTimeoutError);
        SIPDialogErrorEvent newErrorEvent;
        Iterator<SIPDialogEventListener> listenerIterator;
        SIPDialogEventListener nextListener;
        newErrorEvent = new SIPDialogErrorEvent(this, dialogTimeoutError);
        {
            listenerIterator = eventListeners.iterator();
            {
                boolean var20BE331F515CCC1CE643C3890EEC5ABE_976742986 = (listenerIterator.hasNext());
                {
                    nextListener = (SIPDialogEventListener) listenerIterator.next();
                    nextListener.dialogErrorEvent(newErrorEvent);
                } //End block
            } //End collapsed parenthetic
        } //End block
        eventListeners.clear();
        {
            delete();
        } //End block
        stopTimer();
        // ---------- Original Method ----------
        //SIPDialogErrorEvent newErrorEvent;
        //Iterator<SIPDialogEventListener> listenerIterator;
        //SIPDialogEventListener nextListener;
        //newErrorEvent = new SIPDialogErrorEvent(this, dialogTimeoutError);
        //synchronized (eventListeners) {
			//listenerIterator = eventListeners.iterator();
			//while (listenerIterator.hasNext()) {
				//nextListener = (SIPDialogEventListener) listenerIterator.next();
				//nextListener.dialogErrorEvent(newErrorEvent);
			//}
		//}
        //eventListeners.clear();
        //if(dialogTimeoutError != SIPDialogErrorEvent.DIALOG_ACK_NOT_SENT_TIMEOUT &&
		        //dialogTimeoutError != SIPDialogErrorEvent.DIALOG_ACK_NOT_RECEIVED_TIMEOUT &&
		        //dialogTimeoutError != SIPDialogErrorEvent.DIALOG_REINVITE_TIMEOUT ) {
			//delete();
		//}
        //stopTimer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.387 -0400", hash_original_method = "E7371746614A4FB0A7068DCC784728D1", hash_generated_method = "0EC84DE35CEF9CBFC30BC484FAB2BE4E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setRemoteParty(SIPMessage sipMessage) {
        dsTaint.addTaint(sipMessage.dsTaint);
        {
            boolean varBEE554E6D1FF8C71A0674E385CDC8906_1352651557 = (!isServer());
            {
                this.remoteParty = sipMessage.getTo().getAddress();
            } //End block
            {
                this.remoteParty = sipMessage.getFrom().getAddress();
            } //End block
        } //End collapsed parenthetic
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_2059330985 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("settingRemoteParty " + this.remoteParty);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!isServer()) {
            //this.remoteParty = sipMessage.getTo().getAddress();
        //} else {
            //this.remoteParty = sipMessage.getFrom().getAddress();
        //}
        //if (sipStack.isLoggingEnabled()) {
            //sipStack.getStackLogger().logDebug("settingRemoteParty " + this.remoteParty);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.387 -0400", hash_original_method = "07989C3909E96A7576DAE0D29DD189A0", hash_generated_method = "6CB9182FD4E2C7DC4B76162DE3A52D45")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void addRoute(RecordRouteList recordRouteList) {
        dsTaint.addTaint(recordRouteList.dsTaint);
        try 
        {
            {
                boolean var07F5CF3AF0948BEF1A9D3AFE53F3C41D_2040872418 = (this.isClientDialog());
                {
                    this.routeList = new RouteList();
                    ListIterator li;
                    li = recordRouteList.listIterator(recordRouteList.size());
                    boolean addRoute;
                    addRoute = true;
                    {
                        boolean var78DAF18E56E0E0C5C70FC6AF496E0718_1138755486 = (li.hasPrevious());
                        {
                            RecordRoute rr;
                            rr = (RecordRoute) li.previous();
                            {
                                Route route;
                                route = new Route();
                                AddressImpl address;
                                address = ((AddressImpl) ((AddressImpl) rr.getAddress())
                                .clone());
                                route.setAddress(address);
                                route.setParameters((NameValueList) rr.getParameters().clone());
                                this.routeList.add(route);
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    this.routeList = new RouteList();
                    ListIterator li;
                    li = recordRouteList.listIterator();
                    boolean addRoute;
                    addRoute = true;
                    {
                        boolean var3B4C388F9F77D89F36DAE45711DE06F7_735718364 = (li.hasNext());
                        {
                            RecordRoute rr;
                            rr = (RecordRoute) li.next();
                            {
                                Route route;
                                route = new Route();
                                AddressImpl address;
                                address = ((AddressImpl) ((AddressImpl) rr.getAddress())
                                .clone());
                                route.setAddress(address);
                                route.setParameters((NameValueList) rr.getParameters().clone());
                                routeList.add(route);
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            {
                boolean var0C9E46B9F84667219FF0963258285136_373575930 = (sipStack.getStackLogger().isLoggingEnabled());
                {
                    Iterator it;
                    it = routeList.iterator();
                    {
                        boolean var4CA2EDBF7D27138D75E73CCD01CCB025_298068842 = (it.hasNext());
                        {
                            SipURI sipUri;
                            sipUri = (SipURI) (((Route) it.next()).getAddress().getURI());
                            {
                                boolean var1BE9C376C47A3B2A0E7DB2070A5A5EEB_829048817 = (!sipUri.hasLrParam());
                                {
                                    {
                                        boolean var6FE8ACC5352DCA3449210F8EDED912B3_1447744872 = (sipStack.isLoggingEnabled());
                                        {
                                            sipStack.getStackLogger().logWarning(
                                "NON LR route in Route set detected for dialog : " + this);
                                            sipStack.getStackLogger().logStackTrace();
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.388 -0400", hash_original_method = "0B8DEDA7075751956ABB1ACBE337F637", hash_generated_method = "159711731034A0014A9CE90FEF639A08")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void setRemoteTarget(ContactHeader contact) {
        dsTaint.addTaint(contact.dsTaint);
        this.remoteTarget = contact.getAddress();
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1407665855 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("Dialog.setRemoteTarget: " + this.remoteTarget);
                sipStack.getStackLogger().logStackTrace();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //this.remoteTarget = contact.getAddress();
        //if (sipStack.isLoggingEnabled()) {
            //sipStack.getStackLogger().logDebug("Dialog.setRemoteTarget: " + this.remoteTarget);
            //sipStack.getStackLogger().logStackTrace();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.388 -0400", hash_original_method = "32344AE5A14991821D94A9D2D9260949", hash_generated_method = "A414286184250FA2430862E35EFDDAAC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized void addRoute(SIPResponse sipResponse) {
        dsTaint.addTaint(sipResponse.dsTaint);
        try 
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1633326761 = (sipStack.isLoggingEnabled());
                {
                    sipStack.getStackLogger().logDebug(
                        "setContact: dialogState: " + this + "state = " + this.getState());
                } //End block
            } //End collapsed parenthetic
            {
                boolean var8E5EA495FB3AB2BDCCF944451D5CAD5E_1278984146 = (sipResponse.getStatusCode() == 100);
                {
                    {
                        boolean varD22FA4E0B94F71DD4671FD4FC55EBC7F_946435761 = (sipResponse.getStatusCode() / 100 == 2 && !this.isServer());
                        {
                            ContactList contactList;
                            contactList = sipResponse.getContactHeaders();
                            {
                                boolean varBC2CD47900C4F82FA80016EBC4DC14B4_1301822887 = (contactList != null
                            && SIPRequest.isTargetRefresh(sipResponse.getCSeq().getMethod()));
                                {
                                    this.setRemoteTarget((ContactHeader) contactList.getFirst());
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                boolean varA6A85DA8A9FDA48A0ADE5BD360D7C1FE_401171155 = (!isServer());
                {
                    {
                        boolean var2698EF62FF779E804A95F9CA198FE43F_1341020359 = (this.getState() != DialogState.CONFIRMED
                        && this.getState() != DialogState.TERMINATED);
                        {
                            RecordRouteList rrlist;
                            rrlist = sipResponse.getRecordRouteHeaders();
                            {
                                this.addRoute(rrlist);
                            } //End block
                            {
                                this.routeList = new RouteList();
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                    ContactList contactList;
                    contactList = sipResponse.getContactHeaders();
                    {
                        this.setRemoteTarget((ContactHeader) contactList.getFirst());
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1027147923 = (sipStack.isLoggingEnabled());
                {
                    sipStack.getStackLogger().logStackTrace();
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.389 -0400", hash_original_method = "EDCC5E2E639B8E515D6889EB4E225297", hash_generated_method = "99E76D61685370EB18251A28B4FD7A32")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized RouteList getRouteList() {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1002130453 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug("getRouteList " + this);
        } //End collapsed parenthetic
        ListIterator li;
        RouteList retval;
        retval = new RouteList();
        retval = new RouteList();
        {
            li = routeList.listIterator();
            {
                boolean varD1722E42EA3CA8952F93B6521D875E61_1909055517 = (li.hasNext());
                {
                    Route route;
                    route = (Route) li.next();
                    retval.add((Route) route.clone());
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_147370046 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("----- ");
                sipStack.getStackLogger().logDebug("getRouteList for " + this);
                sipStack.getStackLogger().logDebug("RouteList = " + retval.encode());
                sipStack.getStackLogger().logDebug("myRouteList = " + routeList.encode());
                sipStack.getStackLogger().logDebug("----- ");
            } //End block
        } //End collapsed parenthetic
        return (RouteList)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.389 -0400", hash_original_method = "7EC927C7EF5071E2849378214CAB8686", hash_generated_method = "B34F493F764F138473C6EF2B6C8383A5")
    @DSModeled(DSC.SAFE)
     void setRouteList(RouteList routeList) {
        dsTaint.addTaint(routeList.dsTaint);
        // ---------- Original Method ----------
        //this.routeList = routeList;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.390 -0400", hash_original_method = "EE053BB78DA7F62675E98D1AF5A5B915", hash_generated_method = "D9EFB403433C73B625F2A9735B224C23")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sendAck(Request request, boolean throwIOExceptionAsSipException) throws SipException {
        dsTaint.addTaint(throwIOExceptionAsSipException);
        dsTaint.addTaint(request.dsTaint);
        SIPRequest ackRequest;
        ackRequest = (SIPRequest) request;
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_474715924 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug("sendAck" + this);
        } //End collapsed parenthetic
        {
            boolean var83038655241FA8664F712343761B6FDA_1346599646 = (!ackRequest.getMethod().equals(Request.ACK));
            if (DroidSafeAndroidRuntime.control) throw new SipException("Bad request method -- should be ACK");
        } //End collapsed parenthetic
        {
            boolean var8D79CFF02C4C85D8676092EC202DE2DE_889948948 = (this.getState() == null || this.getState().getValue() == EARLY_STATE);
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_948477676 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logError(
                        "Bad Dialog State for " + this + " dialogID = " + this.getDialogId());
                    } //End block
                } //End collapsed parenthetic
                if (DroidSafeAndroidRuntime.control) throw new SipException("Bad dialog state " + this.getState());
            } //End block
        } //End collapsed parenthetic
        {
            boolean var3C70B6348A8CD040C6F768F885F8BDFD_459697534 = (!this.getCallId().getCallId().equals(((SIPRequest) request).getCallId().getCallId()));
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1144085748 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logError("CallID " + this.getCallId());
                        sipStack.getStackLogger().logError(
                        "RequestCallID = " + ackRequest.getCallId().getCallId());
                        sipStack.getStackLogger().logError("dialog =  " + this);
                    } //End block
                } //End collapsed parenthetic
                if (DroidSafeAndroidRuntime.control) throw new SipException("Bad call ID in request");
            } //End block
        } //End collapsed parenthetic
        try 
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_306688132 = (sipStack.isLoggingEnabled());
                {
                    sipStack.getStackLogger().logDebug(
                        "setting from tag For outgoing ACK= " + this.getLocalTag());
                    sipStack.getStackLogger().logDebug(
                        "setting To tag for outgoing ACK = " + this.getRemoteTag());
                    sipStack.getStackLogger().logDebug("ack = " + ackRequest);
                } //End block
            } //End collapsed parenthetic
            {
                boolean var8960EF1666EE0A76790F8BA2DB88F003_523361283 = (this.getLocalTag() != null);
                ackRequest.getFrom().setTag(this.getLocalTag());
            } //End collapsed parenthetic
            {
                boolean var2C6389CD64DE33F7E280071219A47D88_1646952423 = (this.getRemoteTag() != null);
                ackRequest.getTo().setTag(this.getRemoteTag());
            } //End collapsed parenthetic
        } //End block
        catch (ParseException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException(ex.getMessage());
        } //End block
        Hop hop;
        hop = sipStack.getNextHop(ackRequest);
        if (DroidSafeAndroidRuntime.control) throw new SipException("No route!");
        try 
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1892133771 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug("hop = " + hop);
            } //End collapsed parenthetic
            ListeningPointImpl lp;
            lp = (ListeningPointImpl) this.sipProvider.getListeningPoint(hop
                    .getTransport());
            if (DroidSafeAndroidRuntime.control) throw new SipException("No listening point for this provider registered at "
                        + hop);
            InetAddress inetAddress;
            inetAddress = InetAddress.getByName(hop.getHost());
            MessageChannel messageChannel;
            messageChannel = lp.getMessageProcessor().createMessageChannel(
                    inetAddress, hop.getPort());
            boolean releaseAckSem;
            releaseAckSem = false;
            long cseqNo;
            cseqNo = ((SIPRequest)request).getCSeq().getSeqNumber();
            {
                boolean var407F621DCBF6FFA27177104AE6265862_1784853964 = (!this.isAckSent(cseqNo));
                {
                    releaseAckSem = true;
                } //End block
            } //End collapsed parenthetic
            this.setLastAckSent(ackRequest);
            messageChannel.sendMessage(ackRequest);
            this.isAcknowledged = true;
            this.highestSequenceNumberAcknowledged = Math.max(this.highestSequenceNumberAcknowledged,
                    ((SIPRequest)ackRequest).getCSeq().getSeqNumber());
            {
                this.releaseAckSem();
            } //End block
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_636669380 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logDebug("Not releasing ack sem for " + this + " isAckSent " + releaseAckSem );
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        catch (IOException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("Could not send ack", ex);
            this.raiseIOException(hop.getHost(), hop.getPort(), hop.getTransport());
        } //End block
        catch (SipException ex)
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1949488635 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logException(ex);
            } //End collapsed parenthetic
            if (DroidSafeAndroidRuntime.control) throw ex;
        } //End block
        catch (Exception ex)
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1319732959 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logException(ex);
            } //End collapsed parenthetic
            if (DroidSafeAndroidRuntime.control) throw new SipException("Could not create message channel", ex);
        } //End block
        {
            this.dialogDeleteTask.cancel();
            this.dialogDeleteTask = null;
        } //End block
        this.ackSeen = true;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.390 -0400", hash_original_method = "0D216F13B34A5D6836A5B8174F7E5D5B", hash_generated_method = "23FF79A9389D58C4E31017B42AB6FD99")
    @DSModeled(DSC.SAFE)
     void setStack(SIPTransactionStack sipStack) {
        dsTaint.addTaint(sipStack.dsTaint);
        // ---------- Original Method ----------
        //this.sipStack = sipStack;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.391 -0400", hash_original_method = "4B5A71F52939D771152A6C733BB7B273", hash_generated_method = "456FE13EA5B625AD04E92A1923B2E394")
    @DSModeled(DSC.SAFE)
     SIPTransactionStack getStack() {
        return (SIPTransactionStack)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sipStack;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.391 -0400", hash_original_method = "82BA8A08B2E8140159AB0D3D207AD49D", hash_generated_method = "2AE391822018F69EB4113851A7447F02")
    @DSModeled(DSC.SAFE)
     boolean isTerminatedOnBye() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.terminateOnBye;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.391 -0400", hash_original_method = "45B7AAA172C2FB7B4FDF9001755F4630", hash_generated_method = "744A94410CDF36F550CED10FDF0BA370")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void ackReceived(SIPRequest sipRequest) {
        dsTaint.addTaint(sipRequest.dsTaint);
        SIPServerTransaction tr;
        tr = this.getInviteTransaction();
        {
            {
                boolean varB6355663626C1162BA1A68F49F05AEF5_373104043 = (tr.getCSeq() == sipRequest.getCSeq().getSeqNumber());
                {
                    acquireTimerTaskSem();
                    try 
                    {
                        {
                            this.timerTask.cancel();
                            this.timerTask = null;
                        } //End block
                    } //End block
                    finally 
                    {
                        releaseTimerTaskSem();
                    } //End block
                    this.ackSeen = true;
                    {
                        this.dialogDeleteTask.cancel();
                        this.dialogDeleteTask = null;
                    } //End block
                    this.setLastAckReceived(sipRequest);
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_2134334643 = (sipStack.isLoggingEnabled());
                        {
                            sipStack.getStackLogger().logDebug(
                            "ackReceived for " + ((SIPTransaction) tr).getMethod());
                            this.ackLine = sipStack.getStackLogger().getLineCount();
                            this.printDebugInfo();
                        } //End block
                    } //End collapsed parenthetic
                    {
                        this.releaseAckSem();
                    } //End block
                    this.setState(CONFIRMED_STATE);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.391 -0400", hash_original_method = "76BE8FDE36BAF0086F9828D261C3B7B9", hash_generated_method = "5261183D8AB880EC8F183E6940E88132")
    @DSModeled(DSC.SAFE)
    synchronized boolean testAndSetIsDialogTerminatedEventDelivered() {
        boolean retval;
        retval = this.dialogTerminatedEventDelivered;
        this.dialogTerminatedEventDelivered = true;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean retval = this.dialogTerminatedEventDelivered;
        //this.dialogTerminatedEventDelivered = true;
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.391 -0400", hash_original_method = "6AC129F323D8E39FC544B245C2D3A08C", hash_generated_method = "7424564B1B132A69984B8FE0085C6030")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addEventListener(SIPDialogEventListener newListener) {
        dsTaint.addTaint(newListener.dsTaint);
        eventListeners.add(newListener);
        // ---------- Original Method ----------
        //eventListeners.add(newListener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.392 -0400", hash_original_method = "7D9E11919812D827506D2E4A9106FF10", hash_generated_method = "C1A59FAFBF993E6486B226F1C5C5FFA3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeEventListener(SIPDialogEventListener oldListener) {
        dsTaint.addTaint(oldListener.dsTaint);
        eventListeners.remove(oldListener);
        // ---------- Original Method ----------
        //eventListeners.remove(oldListener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.392 -0400", hash_original_method = "552E0456C33D24CD63C8EBCDAC1D019B", hash_generated_method = "8D4DDB013B0F594611E074B5CF4E663E")
    @DSModeled(DSC.SAFE)
    public void setApplicationData(Object applicationData) {
        dsTaint.addTaint(applicationData.dsTaint);
        // ---------- Original Method ----------
        //this.applicationData = applicationData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.392 -0400", hash_original_method = "5F924FC61375970A4DC758380BEBFF0F", hash_generated_method = "38CB1AED90A48D60BFA15010A96EEDEF")
    @DSModeled(DSC.SAFE)
    public Object getApplicationData() {
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.applicationData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.392 -0400", hash_original_method = "CB5AF71091E3878E29C27274F2628D83", hash_generated_method = "010EA77018ED752B9554575AE1CA1224")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void requestConsumed() {
        this.nextSeqno = Long.valueOf(this.getRemoteSeqNumber() + 1);
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1987675228 = (sipStack.isLoggingEnabled());
            {
                this.sipStack.getStackLogger().logDebug(
                    "Request Consumed -- next consumable Request Seqno = " + this.nextSeqno);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //this.nextSeqno = Long.valueOf(this.getRemoteSeqNumber() + 1);
        //if (sipStack.isLoggingEnabled()) {
            //this.sipStack.getStackLogger().logDebug(
                    //"Request Consumed -- next consumable Request Seqno = " + this.nextSeqno);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.392 -0400", hash_original_method = "1E1A6C22D1982081DC74374A2FF63AAD", hash_generated_method = "38F2D93EA3BB9DB0B2BCDE4EB3F6EBE6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized boolean isRequestConsumable(SIPRequest dialogRequest) {
        dsTaint.addTaint(dialogRequest.dsTaint);
        {
            boolean var6F478D97F2432A825F39F929C2C7D5F9_1982243610 = (dialogRequest.getMethod().equals(Request.ACK));
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Illegal method");
        } //End collapsed parenthetic
        {
            boolean var1B071101B9F8EF253DCB47268A096682_1120568378 = (!this.isSequnceNumberValidation());
        } //End collapsed parenthetic
        boolean var5D47603BA0731A48F49B6853603D82AF_827208255 = (remoteSequenceNumber < dialogRequest.getCSeq().getSeqNumber());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (dialogRequest.getMethod().equals(Request.ACK))
            //throw new RuntimeException("Illegal method");
        //if (!this.isSequnceNumberValidation()) {
            //return true;
        //}
        //return remoteSequenceNumber < dialogRequest.getCSeq().getSeqNumber();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.393 -0400", hash_original_method = "45E0951257A8FCCA68182E75CB3B0E3E", hash_generated_method = "953C531C3B0065CBAFE31379F5F05BC2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void doDeferredDelete() {
        {
            boolean var57BEDF91C3ACD8FDD0380E079BFC759D_1069767632 = (sipStack.getTimer() == null);
            this.setState(TERMINATED_STATE);
            {
                this.dialogDeleteTask = new DialogDeleteTask();
                sipStack.getTimer().schedule(this.dialogDeleteTask,
                    SIPTransaction.TIMER_H * SIPTransactionStack.BASE_TIMER_INTERVAL);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (sipStack.getTimer() == null)
            //this.setState(TERMINATED_STATE);
        //else {
            //this.dialogDeleteTask = new DialogDeleteTask();
            //sipStack.getTimer().schedule(this.dialogDeleteTask,
                    //SIPTransaction.TIMER_H * SIPTransactionStack.BASE_TIMER_INTERVAL);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.393 -0400", hash_original_method = "DBF870542E6B78326B5509C5A5BAD885", hash_generated_method = "DE75C82EB140ACE42C5231A6EDF59E54")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setState(int state) {
        dsTaint.addTaint(state);
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_541864897 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug(
                    "Setting dialog state for " + this + "newState = " + state);
                sipStack.getStackLogger().logStackTrace();
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1793135365 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logDebug(
                            this + "  old dialog state is " + this.getState());
                        sipStack.getStackLogger().logDebug(
                            this + "  New dialog state is " + DialogState.getObject(state));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            {
                boolean var0CDA542FA791709C98BE4603D7193AE9_1002507249 = (sipStack.getTimer() != null);
                {
                    sipStack.getTimer().schedule(new LingerTimer(), DIALOG_LINGER_TIME * 1000);
                } //End block
            } //End collapsed parenthetic
            this.stopTimer();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.393 -0400", hash_original_method = "030EEF9CE7E1904041534ED4E8E41515", hash_generated_method = "A710B548B61011103ACB70488967FCB1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void printDebugInfo() {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_194612860 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("isServer = " + isServer());
                sipStack.getStackLogger().logDebug("localTag = " + getLocalTag());
                sipStack.getStackLogger().logDebug("remoteTag = " + getRemoteTag());
                sipStack.getStackLogger().logDebug("localSequenceNumer = " + getLocalSeqNumber());
                sipStack.getStackLogger().logDebug("remoteSequenceNumer = " + getRemoteSeqNumber());
                sipStack.getStackLogger().logDebug("ackLine:" + this.getRemoteTag() + " " + ackLine);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (sipStack.isLoggingEnabled()) {
            //sipStack.getStackLogger().logDebug("isServer = " + isServer());
            //sipStack.getStackLogger().logDebug("localTag = " + getLocalTag());
            //sipStack.getStackLogger().logDebug("remoteTag = " + getRemoteTag());
            //sipStack.getStackLogger().logDebug("localSequenceNumer = " + getLocalSeqNumber());
            //sipStack.getStackLogger().logDebug("remoteSequenceNumer = " + getRemoteSeqNumber());
            //sipStack.getStackLogger().logDebug("ackLine:" + this.getRemoteTag() + " " + ackLine);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.394 -0400", hash_original_method = "1550A0F77E6D4005059B99263F67738A", hash_generated_method = "9D74420E2EB6BAB1BCCB0AA7A1EBD94A")
    @DSModeled(DSC.SAFE)
    public boolean isAckSeen() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.ackSeen;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.394 -0400", hash_original_method = "B546264B9F955F6D37CCFB381DE1D848", hash_generated_method = "853767E4BFF66DBD82F0A5E2F6DFDA27")
    @DSModeled(DSC.SAFE)
    public SIPRequest getLastAckSent() {
        return (SIPRequest)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.lastAckSent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.394 -0400", hash_original_method = "3A1F0F9E8BFDA328E094E225E007A649", hash_generated_method = "2E81E065A540EC5A2F7552CFB6D00465")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isAckSent(long cseqNo) {
        dsTaint.addTaint(cseqNo);
        {
            boolean var3665C5AC96583983B5AAFA78A2A4A188_508665716 = (this.getLastTransaction() == null);
        } //End collapsed parenthetic
        {
            boolean varF59958C0898BD203DEF95141C522BCCD_1718364566 = (this.getLastTransaction() instanceof ClientTransaction);
            {
                {
                    boolean varCC537E3EE0A3D565D8032AB64F417D5A_1239755977 = (this.getLastAckSent() == null);
                    {
                        boolean var98BAD3A8C67276872D114A7BFB474E16_1421811263 = (cseqNo <=((SIPRequest) this.getLastAckSent()).getCSeq().getSeqNumber());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (this.getLastTransaction() == null)
            //return true;
        //if (this.getLastTransaction() instanceof ClientTransaction) {
            //if (this.getLastAckSent() == null) {
                //return false;
            //} else {
                //return cseqNo <=((SIPRequest) this.getLastAckSent()).getCSeq().getSeqNumber();
            //}
        //} else {
            //return true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.394 -0400", hash_original_method = "614E8BDEDCCD12CF6A6EF62939E9BCC1", hash_generated_method = "8A4B9B291F2FD7457AF58F2337B9C9C6")
    @DSModeled(DSC.SAFE)
    public Transaction getFirstTransaction() {
        return (Transaction)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.firstTransaction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.394 -0400", hash_original_method = "A5E017CF1C9F9D5F5F2E302DFCC4F846", hash_generated_method = "2070211FA2EE21B956CF49535AE8143B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Iterator getRouteSet() {
        {
            Iterator var5A706C62CD757DBD02213E464DB7BF11_459626333 = (new LinkedList().listIterator());
        } //End block
        {
            Iterator var33720B76DC0920C15E502714C299F400_376562601 = (this.getRouteList().listIterator());
        } //End block
        return (Iterator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (this.routeList == null) {
            //return new LinkedList().listIterator();
        //} else {
            //return this.getRouteList().listIterator();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.395 -0400", hash_original_method = "A8016262F3F363A84230A54DA12F1862", hash_generated_method = "B077DF508013CDD701F14E15C8BCC32E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void addRoute(SIPRequest sipRequest) {
        dsTaint.addTaint(sipRequest.dsTaint);
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1207522741 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug(
                    "setContact: dialogState: " + this + "state = " + this.getState());
            } //End block
        } //End collapsed parenthetic
        {
            boolean varAF9C68605D64B0F2F115C62532D2B021_522345056 = (this.dialogState == CONFIRMED_STATE
                && SIPRequest.isTargetRefresh(sipRequest.getMethod()));
            {
                this.doTargetRefresh(sipRequest);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varB1C209232695E6D70F6B684A8210FA49_529323939 = (sipRequest.getToTag()!=null);
        } //End collapsed parenthetic
        RecordRouteList rrlist;
        rrlist = sipRequest.getRecordRouteHeaders();
        {
            this.addRoute(rrlist);
        } //End block
        {
            this.routeList = new RouteList();
        } //End block
        ContactList contactList;
        contactList = sipRequest.getContactHeaders();
        {
            this.setRemoteTarget((ContactHeader) contactList.getFirst());
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.395 -0400", hash_original_method = "7A127BC7F5926E2623990DC3EF5AF92A", hash_generated_method = "483F81185E9099E2FFA1B6308203C5CB")
    @DSModeled(DSC.SAFE)
    public void setDialogId(String dialogId) {
        dsTaint.addTaint(dialogId);
        // ---------- Original Method ----------
        //this.dialogId = dialogId;
    }

    
        public static SIPDialog createFromNOTIFY(SIPClientTransaction subscribeTx,
            SIPTransaction notifyST) {
        SIPDialog d = new SIPDialog(notifyST);
        d.serverTransactionFlag = false;
        d.lastTransaction = subscribeTx;
        storeFirstTransactionInfo(d, subscribeTx);
        d.terminateOnBye = false;
        d.localSequenceNumber = subscribeTx.getCSeq();
        SIPRequest not = (SIPRequest) notifyST.getRequest();
        d.remoteSequenceNumber = not.getCSeq().getSeqNumber();
        d.setDialogId(not.getDialogId(true));
        d.setLocalTag(not.getToTag());
        d.setRemoteTag(not.getFromTag());
        d.setLastResponse(subscribeTx, subscribeTx.getLastResponse());
        d.localParty = not.getTo().getAddress();
        d.remoteParty = not.getFrom().getAddress();
        d.addRoute(not);
        d.setState(CONFIRMED_STATE);
        return d;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.395 -0400", hash_original_method = "3F9050C9D9DA025E9AD5115049E6DBE4", hash_generated_method = "04734C1AA5F0CAD42511C46633996D90")
    @DSModeled(DSC.SAFE)
    public boolean isServer() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (this.firstTransactionSeen == false)
            //return this.serverTransactionFlag;
        //else
            //return this.firstTransactionIsServerTransaction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.395 -0400", hash_original_method = "78570188BA83CB17A52ACDCDF5E3A80D", hash_generated_method = "026DA71002FD5BBA72BB6A050402CAD8")
    @DSModeled(DSC.SAFE)
    protected boolean isReInvite() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.reInviteFlag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.396 -0400", hash_original_method = "E7B2220F30EB97BE925BA6431B089B50", hash_generated_method = "A4E6D06935F1029000009232000F47C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDialogId() {
        this.dialogId = this.lastResponse.getDialogId(isServer());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (this.dialogId == null && this.lastResponse != null)
            //this.dialogId = this.lastResponse.getDialogId(isServer());
        //return this.dialogId;
    }

    
        private static void storeFirstTransactionInfo(SIPDialog dialog, SIPTransaction transaction) {
        dialog.firstTransaction = transaction;
        dialog.firstTransactionSeen = true;
        dialog.firstTransactionIsServerTransaction = transaction.isServerTransaction();
        dialog.firstTransactionSecure = transaction.getRequest().getRequestURI().getScheme()
        	.equalsIgnoreCase("sips");
        dialog.firstTransactionPort = transaction.getPort();
        dialog.firstTransactionId = transaction.getBranchId();
        dialog.firstTransactionMethod = transaction.getMethod();
        if (dialog.isServer()) {
            SIPServerTransaction st = (SIPServerTransaction) transaction;
            SIPResponse response = st.getLastResponse();
            dialog.contactHeader = response != null ? response.getContactHeader() : null;
        } else {
            SIPClientTransaction ct = (SIPClientTransaction) transaction;
            if (ct != null){
            	SIPRequest sipRequest = ct.getOriginalRequest();
            	dialog.contactHeader = sipRequest.getContactHeader();
            }
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.396 -0400", hash_original_method = "5D1D12A2E6FD98502CE24F8CA665F380", hash_generated_method = "0A8892624BE0D45DC045CD5AFB01102D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addTransaction(SIPTransaction transaction) {
        dsTaint.addTaint(transaction.dsTaint);
        SIPRequest sipRequest;
        sipRequest = (SIPRequest) transaction.getOriginalRequest();
        {
            boolean varB7F9A6A61385E3192B10301B5B3F8549_1149550924 = (firstTransactionSeen && !firstTransactionId.equals(transaction.getBranchId()) 
                && transaction.getMethod().equals(firstTransactionMethod));
            {
                this.reInviteFlag = true;
            } //End block
        } //End collapsed parenthetic
        {
            storeFirstTransactionInfo(this, transaction);
            {
                boolean varD92DE4EDF61C41C566AE76DAC140EAB6_1570211105 = (sipRequest.getMethod().equals(Request.SUBSCRIBE));
                this.eventHeader = (EventHeader) sipRequest.getHeader(EventHeader.NAME);
            } //End collapsed parenthetic
            this.setLocalParty(sipRequest);
            this.setRemoteParty(sipRequest);
            this.setCallId(sipRequest);
            {
                this.originalRequest = sipRequest;
            } //End block
            {
                this.method = sipRequest.getMethod();
            } //End block
            {
                this.hisTag = sipRequest.getFrom().getTag();
            } //End block
            {
                setLocalSequenceNumber(sipRequest.getCSeq().getSeqNumber());
                this.originalLocalSequenceNumber = localSequenceNumber;
                this.myTag = sipRequest.getFrom().getTag();
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_228833612 = (sipStack.isLoggingEnabled());
                    sipStack.getStackLogger().logError(
                            "The request's From header is missing the required Tag parameter.");
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            boolean varDE98D793D4ACAAC2095FDB19E0A65B87_875425950 = (transaction.getMethod().equals(firstTransactionMethod)
                && firstTransactionIsServerTransaction != transaction.isServerTransaction());
            {
                storeFirstTransactionInfo(this, transaction);
                this.setLocalParty(sipRequest);
                this.setRemoteParty(sipRequest);
                this.setCallId(sipRequest);
                this.originalRequest = sipRequest;
                this.method = sipRequest.getMethod();
            } //End block
        } //End collapsed parenthetic
        setRemoteSequenceNumber(sipRequest.getCSeq().getSeqNumber());
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_807826486 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger()
                    .logDebug("Transaction Added " + this + myTag + "/" + hisTag);
                sipStack.getStackLogger().logDebug(
                    "TID = " + transaction.getTransactionId() + "/"
                            + transaction.isServerTransaction());
                sipStack.getStackLogger().logStackTrace();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.397 -0400", hash_original_method = "D993372A10E82664D688CA2C725ED950", hash_generated_method = "86BF7228940C941508287DDC89A5CB15")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setRemoteTag(String hisTag) {
        dsTaint.addTaint(hisTag);
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_581285718 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug(
                    "setRemoteTag(): " + this + " remoteTag = " + this.hisTag + " new tag = "
                            + hisTag);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var900B1255CEEB9524C1B77103CD9B853E_707380474 = (this.hisTag != null && hisTag != null && !hisTag.equals(this.hisTag));
            {
                {
                    boolean varC92ECF628E283041EE15A3395386A5F8_405292390 = (this.getState() != DialogState.EARLY);
                    {
                        {
                            boolean var2AB968A8303910EE00F810B6DE3410F9_547726942 = (sipStack.isLoggingEnabled());
                            sipStack.getStackLogger().logDebug(
                        "Dialog is already established -- ignoring remote tag re-assignment");
                        } //End collapsed parenthetic
                    } //End block
                    {
                        boolean var882658CE99D357DAFA1231A214A8043C_1061561848 = (sipStack.isRemoteTagReassignmentAllowed());
                        {
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_1563050756 = (sipStack.isLoggingEnabled());
                                sipStack.getStackLogger().logDebug(
                        "UNSAFE OPERATION !  tag re-assignment " + this.hisTag
                                + " trying to set to " + hisTag
                                + " can cause unexpected effects ");
                            } //End collapsed parenthetic
                            boolean removed;
                            removed = false;
                            {
                                boolean var705F9CB3BFC32B68CBC0B119B34F8418_1685111286 = (this.sipStack.getDialog(dialogId) == this);
                                {
                                    this.sipStack.removeDialog(dialogId);
                                    removed = true;
                                } //End block
                            } //End collapsed parenthetic
                            this.dialogId = null;
                            {
                                {
                                    boolean varA5D47C3A6259BCCCC2265DD1F84B75D4_1957469168 = (sipStack.isLoggingEnabled());
                                    sipStack.getStackLogger().logDebug("ReInserting Dialog");
                                } //End collapsed parenthetic
                                this.sipStack.putDialog(this);
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
            {
                {
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1067257606 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger().logWarning("setRemoteTag : called with null argument ");
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.397 -0400", hash_original_method = "6BDB0ABA2E69E3FFFE0E9E894A65FB29", hash_generated_method = "E2188632F41865E303D48FEFC6D2BBEA")
    @DSModeled(DSC.SAFE)
    public SIPTransaction getLastTransaction() {
        return (SIPTransaction)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.lastTransaction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.397 -0400", hash_original_method = "2B80A0EDB61F41D041D4D4B21A265288", hash_generated_method = "EFB595EA0FF0004BB6F64C19D2881D0E")
    @DSModeled(DSC.SAFE)
    public SIPServerTransaction getInviteTransaction() {
        DialogTimerTask t;
        t = this.timerTask;
        return (SIPServerTransaction)dsTaint.getTaint();
        // ---------- Original Method ----------
        //DialogTimerTask t = this.timerTask;
        //if (t != null)
            //return t.transaction;
        //else
            //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.398 -0400", hash_original_method = "0F222FB6A793487D534C4C9D0AE37F48", hash_generated_method = "A3D3F07AB087807263BC4C08E1E2A721")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setLocalSequenceNumber(long lCseq) {
        dsTaint.addTaint(lCseq);
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_321257997 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug(
                    "setLocalSequenceNumber: original  " + this.localSequenceNumber + " new  = "
                            + lCseq);
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Sequence number should not decrease !");
        // ---------- Original Method ----------
        //if (sipStack.isLoggingEnabled())
            //sipStack.getStackLogger().logDebug(
                    //"setLocalSequenceNumber: original  " + this.localSequenceNumber + " new  = "
                            //+ lCseq);
        //if (lCseq <= this.localSequenceNumber)
            //throw new RuntimeException("Sequence number should not decrease !");
        //this.localSequenceNumber = lCseq;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.398 -0400", hash_original_method = "2CD5B084729CE62420C092F3B17E64CA", hash_generated_method = "0CADA34F5789A19B744BCC43CE8FB372")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setRemoteSequenceNumber(long rCseq) {
        dsTaint.addTaint(rCseq);
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_2138936481 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug("setRemoteSeqno " + this + "/" + rCseq);
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (sipStack.isLoggingEnabled())
            //sipStack.getStackLogger().logDebug("setRemoteSeqno " + this + "/" + rCseq);
        //this.remoteSequenceNumber = rCseq;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.398 -0400", hash_original_method = "ACC9A2408A6E532361DDB7BDD50DD489", hash_generated_method = "0CE7495547330D4CCF2E73D8AE7D692E")
    @DSModeled(DSC.SAFE)
    public void incrementLocalSequenceNumber() {
        // ---------- Original Method ----------
        //++this.localSequenceNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.398 -0400", hash_original_method = "FC2F178305D96E73603946FEBD885895", hash_generated_method = "B00EE2B79593E2FB553911FBE652BD60")
    @DSModeled(DSC.SAFE)
    public int getRemoteSequenceNumber() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (int) this.remoteSequenceNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.398 -0400", hash_original_method = "4E94621434A30379D5E2C1A949477B38", hash_generated_method = "2FEA21F69643F17361070C0E4FDC8F88")
    @DSModeled(DSC.SAFE)
    public int getLocalSequenceNumber() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (int) this.localSequenceNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.399 -0400", hash_original_method = "6474794E57511F2FE7B2B694C3DD0A5A", hash_generated_method = "06A4BCB0E3D3CA3F74FC7104831E8111")
    @DSModeled(DSC.SAFE)
    public long getOriginalLocalSequenceNumber() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return this.originalLocalSequenceNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.399 -0400", hash_original_method = "4D53FF8947679D063EC9104B2E34893C", hash_generated_method = "787354790866191F840AEF73F021CBE0")
    @DSModeled(DSC.SAFE)
    public long getLocalSeqNumber() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return this.localSequenceNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.399 -0400", hash_original_method = "86EC66726C4D4B16B759790B32B2EE83", hash_generated_method = "AA01959603C298B7DDF6031401E49C04")
    @DSModeled(DSC.SAFE)
    public long getRemoteSeqNumber() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return this.remoteSequenceNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.399 -0400", hash_original_method = "0BA81564D0817AED393E2EAE028CBF1E", hash_generated_method = "CB7FCB5748AD7505E3F432DC591E59A9")
    @DSModeled(DSC.SAFE)
    public String getLocalTag() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.myTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.399 -0400", hash_original_method = "C2413781DD6AA95F52F5C21D9381D08B", hash_generated_method = "04334432D0D3BB149A84778E902AB205")
    @DSModeled(DSC.SAFE)
    public String getRemoteTag() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return hisTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.400 -0400", hash_original_method = "CA511CD87985B97DC1F9ED1FACA7DA9D", hash_generated_method = "02AF476E8BF0BFFEFFF69538D96CAF48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setLocalTag(String mytag) {
        dsTaint.addTaint(mytag);
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1399892017 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("set Local tag " + mytag + " " + this.dialogId);
                sipStack.getStackLogger().logStackTrace();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (sipStack.isLoggingEnabled()) {
            //sipStack.getStackLogger().logDebug("set Local tag " + mytag + " " + this.dialogId);
            //sipStack.getStackLogger().logStackTrace();
        //}
        //this.myTag = mytag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.400 -0400", hash_original_method = "34B72580F00CA0B4FA87EF05393027BE", hash_generated_method = "C41AF72127A1D3997F6A353CD4B6BEE0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void delete() {
        this.setState(TERMINATED_STATE);
        // ---------- Original Method ----------
        //this.setState(TERMINATED_STATE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.401 -0400", hash_original_method = "E30651442243E5536659B8D6D7E6C300", hash_generated_method = "4252B49C883B503DD7A4EC3281C69810")
    @DSModeled(DSC.SAFE)
    public CallIdHeader getCallId() {
        return (CallIdHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.callIdHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.401 -0400", hash_original_method = "4B0BBE43D23308E79DF92279003CECC0", hash_generated_method = "6DFC671A53AC344FE55280AC05D0D7BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setCallId(SIPRequest sipRequest) {
        dsTaint.addTaint(sipRequest.dsTaint);
        this.callIdHeader = sipRequest.getCallId();
        // ---------- Original Method ----------
        //this.callIdHeader = sipRequest.getCallId();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.401 -0400", hash_original_method = "1786A3231AA3C60CCA9E19F7DEAE30E7", hash_generated_method = "E2B560137289DFE6870C8CA0E810E067")
    @DSModeled(DSC.SAFE)
    public javax.sip.address.Address getLocalParty() {
        return (javax.sip.address.Address)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.localParty;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.402 -0400", hash_original_method = "1D3A055B19FDF32D0E14CBB9A0F366F2", hash_generated_method = "88FE2DE89567A5747A77032D4A7DA7F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setLocalParty(SIPMessage sipMessage) {
        dsTaint.addTaint(sipMessage.dsTaint);
        {
            boolean varBEE554E6D1FF8C71A0674E385CDC8906_2121970723 = (!isServer());
            {
                this.localParty = sipMessage.getFrom().getAddress();
            } //End block
            {
                this.localParty = sipMessage.getTo().getAddress();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!isServer()) {
            //this.localParty = sipMessage.getFrom().getAddress();
        //} else {
            //this.localParty = sipMessage.getTo().getAddress();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.402 -0400", hash_original_method = "CA9799D7C5644CC201AAA28B1842190A", hash_generated_method = "D7A8F2C1E719E378E8A48C95512CD43D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public javax.sip.address.Address getRemoteParty() {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1929097966 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("gettingRemoteParty " + this.remoteParty);
            } //End block
        } //End collapsed parenthetic
        return (javax.sip.address.Address)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (sipStack.isLoggingEnabled()) {
            //sipStack.getStackLogger().logDebug("gettingRemoteParty " + this.remoteParty);
        //}
        //return this.remoteParty;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.402 -0400", hash_original_method = "5663F20A7285801454D4B2BC61212FE3", hash_generated_method = "E9AA818949357BA9E0C230DB3767684B")
    @DSModeled(DSC.SAFE)
    public javax.sip.address.Address getRemoteTarget() {
        return (javax.sip.address.Address)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.remoteTarget;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.402 -0400", hash_original_method = "81C5F6A55277F5330460057DCD70CFE0", hash_generated_method = "FDA8440260B26F4ED0CB13033D27937E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DialogState getState() {
        DialogState varA3F3ED55C9CBDB891D87640254EBE6BC_276105541 = (DialogState.getObject(this.dialogState));
        return (DialogState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (this.dialogState == NULL_STATE)
            //return null;
        //return DialogState.getObject(this.dialogState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.402 -0400", hash_original_method = "B6F2129527CFF355191EDA726B295B54", hash_generated_method = "707BC72E954671806974FF9E256E159F")
    @DSModeled(DSC.SAFE)
    public boolean isSecure() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.firstTransactionSecure;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.402 -0400", hash_original_method = "41912A3E01B6CF39F4209C49F71F74D2", hash_generated_method = "D8A0B4E6AA0C032FBD2041F5255E68E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendAck(Request request) throws SipException {
        dsTaint.addTaint(request.dsTaint);
        this.sendAck(request, true);
        // ---------- Original Method ----------
        //this.sendAck(request, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.403 -0400", hash_original_method = "802F1385694BBDC717BE4DE58C3ED44B", hash_generated_method = "E080729698F32F997E5572D981E2698D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Request createRequest(String method) throws SipException {
        dsTaint.addTaint(method);
        {
            boolean var7FAEA5BBA47884C7B33E1A58D0E293FA_40505231 = (method.equals(Request.ACK) || method.equals(Request.PRACK));
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException("Invalid method specified for createRequest:" + method);
            } //End block
        } //End collapsed parenthetic
        Request var4C7EFCF2F678DE89E1A3F7921D8B02F1_417880914 = (this.createRequest(method, this.lastResponse));
        if (DroidSafeAndroidRuntime.control) throw new SipException("Dialog not yet established -- no response!");
        return (Request)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (method.equals(Request.ACK) || method.equals(Request.PRACK)) {
            //throw new SipException("Invalid method specified for createRequest:" + method);
        //}
        //if (lastResponse != null)
            //return this.createRequest(method, this.lastResponse);
        //else
            //throw new SipException("Dialog not yet established -- no response!");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.404 -0400", hash_original_method = "B004628D88AAF4473352CE6B2CF39886", hash_generated_method = "77B0F01B5EE4A2AA647C9674DC3BE342")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Request createRequest(String method, SIPResponse sipResponse) throws SipException {
        dsTaint.addTaint(sipResponse.dsTaint);
        dsTaint.addTaint(method);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null argument");
        {
            boolean var901DDCA4AFD787ED4D3E774E6F5954D2_2118124337 = (method.equals(Request.CANCEL));
            if (DroidSafeAndroidRuntime.control) throw new SipException("Dialog.createRequest(): Invalid request");
        } //End collapsed parenthetic
        {
            boolean var6451C3E80BA914B63DA4E2C0EE66A26D_1221143966 = (this.getState() == null
                || (this.getState().getValue() == TERMINATED_STATE && !method
                        .equalsIgnoreCase(Request.BYE))
                || (this.isServer() && this.getState().getValue() == EARLY_STATE && method
                        .equalsIgnoreCase(Request.BYE)));
            if (DroidSafeAndroidRuntime.control) throw new SipException("Dialog  " + getDialogId()
                    + " not yet established or terminated " + this.getState());
        } //End collapsed parenthetic
        SipUri sipUri;
        sipUri = null;
        {
            boolean var32CB10BEC2D464683496BEC61BDB1C7C_2079524551 = (this.getRemoteTarget() != null);
            sipUri = (SipUri) this.getRemoteTarget().getURI().clone();
            {
                sipUri = (SipUri) this.getRemoteParty().getURI().clone();
                sipUri.clearUriParms();
            } //End block
        } //End collapsed parenthetic
        CSeq cseq;
        cseq = new CSeq();
        try 
        {
            cseq.setMethod(method);
            cseq.setSeqNumber(this.getLocalSeqNumber());
        } //End block
        catch (Exception ex)
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1606609219 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logError("Unexpected error");
            } //End collapsed parenthetic
            InternalErrorHandler.handleException(ex);
        } //End block
        ListeningPointImpl lp;
        lp = (ListeningPointImpl) this.sipProvider
                .getListeningPoint(sipResponse.getTopmostVia().getTransport());
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1787276116 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logError(
                        "Cannot find listening point for transport "
                                + sipResponse.getTopmostVia().getTransport());
            } //End collapsed parenthetic
            if (DroidSafeAndroidRuntime.control) throw new SipException("Cannot find listening point for transport "
                    + sipResponse.getTopmostVia().getTransport());
        } //End block
        Via via;
        via = lp.getViaHeader();
        From from;
        from = new From();
        from.setAddress(this.localParty);
        To to;
        to = new To();
        to.setAddress(this.remoteParty);
        SIPRequest sipRequest;
        sipRequest = sipResponse.createRequest(sipUri, via, cseq, from, to);
        {
            boolean var134460D0D6709F29F302E0A7AAE6BE0A_797160144 = (SIPRequest.isTargetRefresh(method));
            {
                ContactHeader contactHeader;
                contactHeader = ((ListeningPointImpl) this.sipProvider
                    .getListeningPoint(lp.getTransport())).createContactHeader();
                ((SipURI) contactHeader.getAddress().getURI()).setSecure(this.isSecure());
                sipRequest.setHeader(contactHeader);
            } //End block
        } //End collapsed parenthetic
        try 
        {
            cseq = (CSeq) sipRequest.getCSeq();
            cseq.setSeqNumber(this.localSequenceNumber + 1);
        } //End block
        catch (InvalidArgumentException ex)
        {
            InternalErrorHandler.handleException(ex);
        } //End block
        {
            boolean varCF8EB2629DEB9D14D2D7AE3B8557C47D_1683741981 = (method.equals(Request.SUBSCRIBE));
            {
                sipRequest.addHeader(eventHeader);
            } //End block
        } //End collapsed parenthetic
        try 
        {
            {
                boolean var8960EF1666EE0A76790F8BA2DB88F003_395580763 = (this.getLocalTag() != null);
                {
                    from.setTag(this.getLocalTag());
                } //End block
                {
                    from.removeTag();
                } //End block
            } //End collapsed parenthetic
            {
                boolean var2C6389CD64DE33F7E280071219A47D88_754238992 = (this.getRemoteTag() != null);
                {
                    to.setTag(this.getRemoteTag());
                } //End block
                {
                    to.removeTag();
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (ParseException ex)
        {
            InternalErrorHandler.handleException(ex);
        } //End block
        this.updateRequest(sipRequest);
        return (Request)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.404 -0400", hash_original_method = "9C360B0CF1AC53C036709107CECBBC75", hash_generated_method = "2BDBF8A95D00646B8B3CB41C58E7810D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendRequest(ClientTransaction clientTransactionId) throws TransactionDoesNotExistException, SipException {
        dsTaint.addTaint(clientTransactionId.dsTaint);
        this.sendRequest(clientTransactionId, !this.isBackToBackUserAgent);
        // ---------- Original Method ----------
        //this.sendRequest(clientTransactionId, !this.isBackToBackUserAgent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.406 -0400", hash_original_method = "E90E816BF2167876B04C570AAB507565", hash_generated_method = "F3387703E99F4902307455F4094DA059")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendRequest(ClientTransaction clientTransactionId, boolean allowInterleaving) throws TransactionDoesNotExistException, SipException {
        dsTaint.addTaint(clientTransactionId.dsTaint);
        dsTaint.addTaint(allowInterleaving);
        {
            boolean var0B73476425A078E6D0D1236F4BB54CAC_1013691005 = ((!allowInterleaving)
                && clientTransactionId.getRequest().getMethod().equals(Request.INVITE));
            {
                new Thread((new ReInviteSender(clientTransactionId))).start();
            } //End block
        } //End collapsed parenthetic
        SIPRequest dialogRequest;
        dialogRequest = ((SIPClientTransaction) clientTransactionId)
                .getOriginalRequest();
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1306047936 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug(
                    "dialog.sendRequest " + " dialog = " + this + "\ndialogRequest = \n"
                            + dialogRequest);
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null parameter");
        {
            boolean var1169745922CE63DD156260B7D456AE05_144048380 = (dialogRequest.getMethod().equals(Request.ACK)
                || dialogRequest.getMethod().equals(Request.CANCEL));
            if (DroidSafeAndroidRuntime.control) throw new SipException("Bad Request Method. " + dialogRequest.getMethod());
        } //End collapsed parenthetic
        {
            boolean varC96A74E8BBC3DA149625FF2EC6772871_97038067 = (byeSent && isTerminatedOnBye() && !dialogRequest.getMethod().equals(Request.BYE));
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1646056368 = (sipStack.isLoggingEnabled());
                    sipStack.getStackLogger().logError("BYE already sent for " + this);
                } //End collapsed parenthetic
                if (DroidSafeAndroidRuntime.control) throw new SipException("Cannot send request; BYE already sent");
            } //End block
        } //End collapsed parenthetic
        {
            boolean varBC4604ED9CEFF5AB625860EF0715C0B5_1470107814 = (dialogRequest.getTopmostVia() == null);
            {
                Via via;
                via = ((SIPClientTransaction) clientTransactionId).getOutgoingViaHeader();
                dialogRequest.addHeader(via);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var906255BA0B7F8ECAF3658C3F65A640E3_146209475 = (!this.getCallId().getCallId().equalsIgnoreCase(dialogRequest.getCallId().getCallId()));
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_199444948 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logError("CallID " + this.getCallId());
                        sipStack.getStackLogger().logError(
                        "RequestCallID = " + dialogRequest.getCallId().getCallId());
                        sipStack.getStackLogger().logError("dialog =  " + this);
                    } //End block
                } //End collapsed parenthetic
                if (DroidSafeAndroidRuntime.control) throw new SipException("Bad call ID in request");
            } //End block
        } //End collapsed parenthetic
        ((SIPClientTransaction) clientTransactionId).setDialog(this, this.dialogId);
        this.addTransaction((SIPTransaction) clientTransactionId);
        ((SIPClientTransaction) clientTransactionId).isMapped = true;
        From from;
        from = (From) dialogRequest.getFrom();
        To to;
        to = (To) dialogRequest.getTo();
        {
            boolean varB53BA052D4209F28F5E99708019E0649_104735753 = (this.getLocalTag() != null && from.getTag() != null
                && !from.getTag().equals(this.getLocalTag()));
            if (DroidSafeAndroidRuntime.control) throw new SipException("From tag mismatch expecting  " + this.getLocalTag());
        } //End collapsed parenthetic
        {
            boolean var89BDFDBB281A8FAD37A897E8D21F188F_70344318 = (this.getRemoteTag() != null && to.getTag() != null
                && !to.getTag().equals(this.getRemoteTag()));
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_471300901 = (sipStack.isLoggingEnabled());
                    this.sipStack.getStackLogger().logWarning(
                    "To header tag mismatch expecting " + this.getRemoteTag());
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean varD80EDFF969ADE551B15AAA6F81B0F87F_1683078565 = (this.getLocalTag() == null && dialogRequest.getMethod().equals(Request.NOTIFY));
            {
                {
                    boolean varA7B972031300250A30428BA53613E368_30764499 = (!this.getMethod().equals(Request.SUBSCRIBE));
                    if (DroidSafeAndroidRuntime.control) throw new SipException("Trying to send NOTIFY without SUBSCRIBE Dialog!");
                } //End collapsed parenthetic
                this.setLocalTag(from.getTag());
            } //End block
        } //End collapsed parenthetic
        try 
        {
            {
                boolean var8960EF1666EE0A76790F8BA2DB88F003_805116554 = (this.getLocalTag() != null);
                from.setTag(this.getLocalTag());
            } //End collapsed parenthetic
            {
                boolean var2C6389CD64DE33F7E280071219A47D88_245905328 = (this.getRemoteTag() != null);
                to.setTag(this.getRemoteTag());
            } //End collapsed parenthetic
        } //End block
        catch (ParseException ex)
        {
            InternalErrorHandler.handleException(ex);
        } //End block
        Hop hop;
        hop = ((SIPClientTransaction) clientTransactionId).getNextHop();
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_2083787607 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug(
                    "Using hop = " + hop.getHost() + " : " + hop.getPort());
            } //End block
        } //End collapsed parenthetic
        try 
        {
            MessageChannel messageChannel;
            messageChannel = sipStack.createRawMessageChannel(this
                    .getSipProvider().getListeningPoint(hop.getTransport()).getIPAddress(),
                    this.firstTransactionPort, hop);
            MessageChannel oldChannel;
            oldChannel = ((SIPClientTransaction) 
            		clientTransactionId).getMessageChannel();
            oldChannel.uncache();
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_289081887 = (sipStack.isLoggingEnabled());
                    sipStack.getStackLogger().logDebug(
                            "oldChannel: useCount " + oldChannel.useCount);
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_729524221 = (sipStack.isLoggingEnabled());
                    sipStack.getStackLogger().logDebug(
                            "Null message channel using outbound proxy !");
                } //End collapsed parenthetic
                Hop outboundProxy;
                outboundProxy = sipStack.getRouter(dialogRequest).getOutboundProxy();
                if (DroidSafeAndroidRuntime.control) throw new SipException("No route found! hop=" + hop);
                messageChannel = sipStack.createRawMessageChannel(this.getSipProvider()
                        .getListeningPoint(outboundProxy.getTransport()).getIPAddress(),
                        this.firstTransactionPort, outboundProxy);
                ((SIPClientTransaction) clientTransactionId)
                            .setEncapsulatedChannel(messageChannel);
            } //End block
            {
                ((SIPClientTransaction) clientTransactionId)
                        .setEncapsulatedChannel(messageChannel);
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_559538664 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logDebug("using message channel " + messageChannel);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            oldChannel.close();
        } //End block
        catch (Exception ex)
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_164764888 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logException(ex);
            } //End collapsed parenthetic
            if (DroidSafeAndroidRuntime.control) throw new SipException("Could not create message channel", ex);
        } //End block
        try 
        {
            dialogRequest.getCSeq().setSeqNumber(getLocalSeqNumber());
        } //End block
        catch (InvalidArgumentException ex)
        {
            sipStack.getStackLogger().logFatalError(ex.getMessage());
        } //End block
        try 
        {
            ((SIPClientTransaction) clientTransactionId).sendMessage(dialogRequest);
            {
                boolean varD35D780BD2119470ABCE216878F145E2_1618351637 = (dialogRequest.getMethod().equals(Request.BYE));
                {
                    this.byeSent = true;
                    {
                        boolean var61F0069F460C1DE219DEA32CC067873C_197314415 = (isTerminatedOnBye());
                        {
                            this.setState(DialogState._TERMINATED);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (IOException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("error sending message", ex);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.406 -0400", hash_original_method = "BB6E18DBBED43A4BEB60B225A721A13E", hash_generated_method = "8F6067DB39173D2C61280ABF5B2B3D4D")
    @DSModeled(DSC.SAFE)
    private boolean toRetransmitFinalResponse(int T2) {
        dsTaint.addTaint(T2);
        {
            this.retransmissionTicksLeft = 2 * prevRetransmissionTicks;
            this.retransmissionTicksLeft = prevRetransmissionTicks;
            this.prevRetransmissionTicks = retransmissionTicksLeft;
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (--retransmissionTicksLeft == 0) {
            //if (2 * prevRetransmissionTicks <= T2)
                //this.retransmissionTicksLeft = 2 * prevRetransmissionTicks;
            //else
                //this.retransmissionTicksLeft = prevRetransmissionTicks;
            //this.prevRetransmissionTicks = retransmissionTicksLeft;
            //return true;
        //} else
            //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.406 -0400", hash_original_method = "085350C5B4F086D4A04022EDF074C477", hash_generated_method = "CEED3E6C57E3AE5A6BAC9A7B6FFC14D3")
    @DSModeled(DSC.SAFE)
    protected void setRetransmissionTicks() {
        this.retransmissionTicksLeft = 1;
        this.prevRetransmissionTicks = 1;
        // ---------- Original Method ----------
        //this.retransmissionTicksLeft = 1;
        //this.prevRetransmissionTicks = 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.407 -0400", hash_original_method = "9B2F4C7AC7E3D2DC3FE02C5A18455E2B", hash_generated_method = "F8E14C458E7A08431E826192A35E6335")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void resendAck() throws SipException {
        {
            boolean var6C2ACBE5BDF4F74D454F50C12DD0D9DC_1328411062 = (this.getLastAckSent() != null);
            {
                {
                    boolean varCB70FC8263CD09B0F1B84A47A0A0E4F7_1389996088 = (getLastAckSent().getHeader(TimeStampHeader.NAME) != null
                    && sipStack.generateTimeStampHeader);
                    {
                        TimeStamp ts;
                        ts = new TimeStamp();
                        try 
                        {
                            ts.setTimeStamp(System.currentTimeMillis());
                            getLastAckSent().setHeader(ts);
                        } //End block
                        catch (InvalidArgumentException e)
                        { }
                    } //End block
                } //End collapsed parenthetic
                this.sendAck(getLastAckSent(), false);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (this.getLastAckSent() != null) {
            //if (getLastAckSent().getHeader(TimeStampHeader.NAME) != null
                    //&& sipStack.generateTimeStampHeader) {
                //TimeStamp ts = new TimeStamp();
                //try {
                    //ts.setTimeStamp(System.currentTimeMillis());
                    //getLastAckSent().setHeader(ts);
                //} catch (InvalidArgumentException e) {
                //}
            //}
            //this.sendAck(getLastAckSent(), false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.407 -0400", hash_original_method = "691C5451C67574E660997BC2056A5F23", hash_generated_method = "E416FDFFB284E6CD1525F551DC901FBA")
    @DSModeled(DSC.SAFE)
    public String getMethod() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.method;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.407 -0400", hash_original_method = "1E91804F8A3049A9C15BCD340F87DF5D", hash_generated_method = "8365C79BB573D059FBF43B1C08D07F66")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void startTimer(SIPServerTransaction transaction) {
        dsTaint.addTaint(transaction.dsTaint);
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1006013220 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug("Timer already running for " + getDialogId());
            } //End collapsed parenthetic
        } //End block
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1299042752 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug("Starting dialog timer for " + getDialogId());
        } //End collapsed parenthetic
        this.ackSeen = false;
        acquireTimerTaskSem();
        try 
        {
            {
                this.timerTask.transaction = transaction;
            } //End block
            {
                this.timerTask = new DialogTimerTask(transaction);
                sipStack.getTimer().schedule(timerTask, SIPTransactionStack.BASE_TIMER_INTERVAL,
	                    SIPTransactionStack.BASE_TIMER_INTERVAL);
            } //End block
        } //End block
        finally 
        {
            releaseTimerTaskSem();
        } //End block
        this.setRetransmissionTicks();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.407 -0400", hash_original_method = "3E7472F910A577F9E6FCB71153FF16E3", hash_generated_method = "F1187DBDC9E801B24174FAD13B752CDB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void stopTimer() {
        try 
        {
            acquireTimerTaskSem();
            try 
            {
                {
                    this.timerTask.cancel();
                    this.timerTask = null;
                } //End block
            } //End block
            finally 
            {
                releaseTimerTaskSem();
            } //End block
        } //End block
        catch (Exception ex)
        { }
        // ---------- Original Method ----------
        //try {
        	//acquireTimerTaskSem();
        	//try {
	            //if (this.timerTask != null) {            	
	            	//this.timerTask.cancel();
		            //this.timerTask = null;
	            //}   
        	//} finally {
        		//releaseTimerTaskSem();
        	//}
        //} catch (Exception ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.408 -0400", hash_original_method = "B99416CED2F5EC9B5AF4977F926F9FAE", hash_generated_method = "A4FA68A9B8AD2FEEA4E8992531D626BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Request createPrack(Response relResponse) throws DialogDoesNotExistException,
            SipException {
        dsTaint.addTaint(relResponse.dsTaint);
        {
            boolean var5F13FEDECFA24670F7B4ECAB7A40873E_265811248 = (this.getState() == null || this.getState().equals(DialogState.TERMINATED));
            if (DroidSafeAndroidRuntime.control) throw new DialogDoesNotExistException("Dialog not initialized or terminated");
        } //End collapsed parenthetic
        {
            boolean var87BC905A631F8D351A6D3C712E9DE58A_348588530 = ((RSeq) relResponse.getHeader(RSeqHeader.NAME) == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException("Missing RSeq Header");
            } //End block
        } //End collapsed parenthetic
        try 
        {
            SIPResponse sipResponse;
            sipResponse = (SIPResponse) relResponse;
            SIPRequest sipRequest;
            sipRequest = (SIPRequest) this.createRequest(Request.PRACK,
                    (SIPResponse) relResponse);
            String toHeaderTag;
            toHeaderTag = sipResponse.getTo().getTag();
            sipRequest.setToTag(toHeaderTag);
            RAck rack;
            rack = new RAck();
            RSeq rseq;
            rseq = (RSeq) relResponse.getHeader(RSeqHeader.NAME);
            rack.setMethod(sipResponse.getCSeq().getMethod());
            rack.setCSequenceNumber((int) sipResponse.getCSeq().getSeqNumber());
            rack.setRSequenceNumber(rseq.getSeqNumber());
            sipRequest.setHeader(rack);
        } //End block
        catch (Exception ex)
        {
            InternalErrorHandler.handleException(ex);
        } //End block
        return (Request)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.408 -0400", hash_original_method = "AE874CF06DEDE92D6543D8F7D52B6043", hash_generated_method = "8F94D6D17C98F25BAEB22D94EEECA29D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateRequest(SIPRequest sipRequest) {
        dsTaint.addTaint(sipRequest.dsTaint);
        RouteList rl;
        rl = this.getRouteList();
        {
            boolean var1845ECD20E35B086D417AFB72F9DDE84_2120089946 = (rl.size() > 0);
            {
                sipRequest.setHeader(rl);
            } //End block
            {
                sipRequest.removeHeader(RouteHeader.NAME);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var896FD3C9C4EED86170D10D69961A19CE_562910290 = (MessageFactoryImpl.getDefaultUserAgentHeader() != null);
            {
                sipRequest.setHeader(MessageFactoryImpl.getDefaultUserAgentHeader());
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //RouteList rl = this.getRouteList();
        //if (rl.size() > 0) {
            //sipRequest.setHeader(rl);
        //} else {
            //sipRequest.removeHeader(RouteHeader.NAME);
        //}
        //if (MessageFactoryImpl.getDefaultUserAgentHeader() != null) {
            //sipRequest.setHeader(MessageFactoryImpl.getDefaultUserAgentHeader());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.409 -0400", hash_original_method = "8ECB2239C30E6B6F2CF5AEE7662DC317", hash_generated_method = "2A23E535A56A460F6A6C796AFA1028F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Request createAck(long cseqno) throws InvalidArgumentException, SipException {
        dsTaint.addTaint(cseqno);
        {
            boolean varD24E8B9BE4529879766AB23987E8AD7C_1407847032 = (!method.equals(Request.INVITE));
            if (DroidSafeAndroidRuntime.control) throw new SipException("Dialog was not created with an INVITE" + method);
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad cseq <= 0 ");
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad cseq > " + ((((long) 1) << 32) - 1));
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("Cannot create ACK - no remote Target!");
        } //End block
        {
            boolean var01D5629BD6EE4648A9CF76B7CC4467B7_1073884979 = (this.sipStack.isLoggingEnabled());
            {
                this.sipStack.getStackLogger().logDebug("createAck " + this + " cseqno " + cseqno);
            } //End block
        } //End collapsed parenthetic
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1568301130 = (sipStack.isLoggingEnabled());
                {
                    this.sipStack.getStackLogger().logDebug(
                    "WARNING : Attempt to crete ACK without OK " + this);
                    this.sipStack.getStackLogger().logDebug("LAST RESPONSE = " + this.lastResponse);
                } //End block
            } //End collapsed parenthetic
            if (DroidSafeAndroidRuntime.control) throw new SipException("Dialog not yet established -- no OK response!");
        } //End block
        try 
        {
            SipURI uri4transport;
            uri4transport = null;
            {
                boolean var88914CD57C4971E4E025A7D4C058C72C_1173263814 = (this.routeList != null && !this.routeList.isEmpty());
                {
                    Route r;
                    r = (Route) this.routeList.getFirst();
                    uri4transport = ((SipURI) r.getAddress().getURI());
                } //End block
                {
                    uri4transport = ((SipURI) this.remoteTarget.getURI());
                } //End block
            } //End collapsed parenthetic
            String transport;
            transport = uri4transport.getTransportParam();
            {
                transport = uri4transport.isSecure() ? ListeningPoint.TLS : ListeningPoint.UDP;
            } //End block
            ListeningPointImpl lp;
            lp = (ListeningPointImpl) sipProvider.getListeningPoint(transport);
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_273371621 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logError(
                        "remoteTargetURI " + this.remoteTarget.getURI());
                        sipStack.getStackLogger().logError("uri4transport = " + uri4transport);
                        sipStack.getStackLogger().logError("No LP found for transport=" + transport);
                    } //End block
                } //End collapsed parenthetic
                if (DroidSafeAndroidRuntime.control) throw new SipException(
                        "Cannot create ACK - no ListeningPoint for transport towards next hop found:"
                                + transport);
            } //End block
            SIPRequest sipRequest;
            sipRequest = new SIPRequest();
            sipRequest.setMethod(Request.ACK);
            sipRequest.setRequestURI((SipUri) getRemoteTarget().getURI().clone());
            sipRequest.setCallId(this.callIdHeader);
            sipRequest.setCSeq(new CSeq(cseqno, Request.ACK));
            List<Via> vias;
            vias = new ArrayList<Via>();
            Via via;
            via = this.lastResponse.getTopmostVia();
            via.removeParameters();
            {
                boolean var5ACE7FF7AC32F8E6606DBA1F89AB80FD_1472314021 = (originalRequest != null && originalRequest.getTopmostVia() != null);
                {
                    NameValueList originalRequestParameters;
                    originalRequestParameters = originalRequest.getTopmostVia()
                        .getParameters();
                    {
                        boolean var6A3D0DB6457794914BB4A50CBA9DA9AB_362572048 = (originalRequestParameters != null && originalRequestParameters.size() > 0);
                        {
                            via.setParameters((NameValueList) originalRequestParameters.clone());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            via.setBranch(Utils.getInstance().generateBranchId());
            vias.add(via);
            sipRequest.setVia(vias);
            From from;
            from = new From();
            from.setAddress(this.localParty);
            from.setTag(this.myTag);
            sipRequest.setFrom(from);
            To to;
            to = new To();
            to.setAddress(this.remoteParty);
            to.setTag(this.hisTag);
            sipRequest.setTo(to);
            sipRequest.setMaxForwards(new MaxForwards(70));
            {
                Authorization authorization;
                authorization = this.originalRequest.getAuthorization();
                sipRequest.setHeader(authorization);
            } //End block
            this.updateRequest(sipRequest);
        } //End block
        catch (Exception ex)
        {
            InternalErrorHandler.handleException(ex);
            if (DroidSafeAndroidRuntime.control) throw new SipException("unexpected exception ", ex);
        } //End block
        return (Request)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.409 -0400", hash_original_method = "225E26F17D14C81F6F76A7525B288E82", hash_generated_method = "4031A8914AADA0912E7ACD285A16C23F")
    @DSModeled(DSC.SAFE)
    public SipProviderImpl getSipProvider() {
        return (SipProviderImpl)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.sipProvider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.410 -0400", hash_original_method = "8A8245F47D42BA43478E00CC55ABA836", hash_generated_method = "21D4CB8CD14F4D8659266C1B46DB92DE")
    @DSModeled(DSC.SAFE)
    public void setSipProvider(SipProviderImpl sipProvider) {
        dsTaint.addTaint(sipProvider.dsTaint);
        // ---------- Original Method ----------
        //this.sipProvider = sipProvider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.410 -0400", hash_original_method = "CF7951DD9E6C51606E8031643391B018", hash_generated_method = "6B49A7F8410703E675809D6D896375A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setResponseTags(SIPResponse sipResponse) {
        dsTaint.addTaint(sipResponse.dsTaint);
        {
            boolean var8902B2D54D9D64C1AD2F6B4D577F0AC1_1224880301 = (this.getLocalTag() != null || this.getRemoteTag() != null);
        } //End collapsed parenthetic
        String responseFromTag;
        responseFromTag = sipResponse.getFromTag();
        {
            {
                boolean varEBFAC7E822975644712D237D7D794A79_1226142787 = (responseFromTag.equals(this.getLocalTag()));
                {
                    sipResponse.setToTag(this.getRemoteTag());
                } //End block
                {
                    boolean varC5E254C584E79962FDD35AF188F3D95B_428093212 = (responseFromTag.equals(this.getRemoteTag()));
                    {
                        sipResponse.setToTag(this.getLocalTag());
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1461576515 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logWarning("No from tag in response! Not RFC 3261 compatible.");
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //if (this.getLocalTag() != null || this.getRemoteTag() != null) {
            //return;
        //}
        //String responseFromTag = sipResponse.getFromTag();
        //if ( responseFromTag != null ) {
            //if (responseFromTag.equals(this.getLocalTag())) {
                //sipResponse.setToTag(this.getRemoteTag());
            //} else if (responseFromTag.equals(this.getRemoteTag())) {
                //sipResponse.setToTag(this.getLocalTag());
            //}
        //} else {
        	//if (sipStack.isLoggingEnabled())
        		//sipStack.getStackLogger().logWarning("No from tag in response! Not RFC 3261 compatible.");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.412 -0400", hash_original_method = "80C5F1C3A7F1BF77711B99F831173748", hash_generated_method = "892F00D7EF4CFD9BBA0EE803CC5F2B9F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setLastResponse(SIPTransaction transaction, SIPResponse sipResponse) {
        dsTaint.addTaint(transaction.dsTaint);
        dsTaint.addTaint(sipResponse.dsTaint);
        this.callIdHeader = sipResponse.getCallId();
        int statusCode;
        statusCode = sipResponse.getStatusCode();
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1202233900 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logWarning(
                    "Invalid status code - 100 in setLastResponse - ignoring");
            } //End collapsed parenthetic
        } //End block
        this.setAssigned();
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_891172084 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug(
                    "sipDialog: setLastResponse:" + this + " lastResponse = "
                            + this.lastResponse.getFirstLine());
            } //End block
        } //End collapsed parenthetic
        {
            boolean varECEE72F2BE8BE87D5366A0277FBCE038_89450518 = (this.getState() == DialogState.TERMINATED);
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1139517616 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logDebug(
                        "sipDialog: setLastResponse -- dialog is terminated - ignoring ");
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var7C21E56F04FFB7827B07DB28A1638AE6_679855951 = (sipResponse.getCSeq().getMethod().equals(Request.INVITE) && statusCode == 200);
                    {
                        this.lastInviteOkReceived = Math.max(sipResponse.getCSeq().getSeqNumber(),
                        this.lastInviteOkReceived);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        String cseqMethod;
        cseqMethod = sipResponse.getCSeq().getMethod();
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_2744948 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logStackTrace();
                sipStack.getStackLogger().logDebug("cseqMethod = " + cseqMethod);
                sipStack.getStackLogger().logDebug("dialogState = " + this.getState());
                sipStack.getStackLogger().logDebug("method = " + this.getMethod());
                sipStack.getStackLogger().logDebug("statusCode = " + statusCode);
                sipStack.getStackLogger().logDebug("transaction = " + transaction);
            } //End block
        } //End collapsed parenthetic
        {
            {
                boolean var839B41C03A2B5D99C7BD81EF76FDD890_890731168 = (sipStack.isDialogCreated(cseqMethod));
                {
                    {
                        boolean var08A2AAD99B8F98462ECF577990E03E96_617610532 = (getState() == null && (statusCode / 100 == 1));
                        {
                            setState(SIPDialog.EARLY_STATE);
                            {
                                boolean var86C6F66A5EE9F0068D7CE893541F2279_916603244 = ((sipResponse.getToTag() != null || sipStack.rfc2543Supported)
                            && this.getRemoteTag() == null);
                                {
                                    setRemoteTag(sipResponse.getToTag());
                                    this.setDialogId(sipResponse.getDialogId(false));
                                    sipStack.putDialog(this);
                                    this.addRoute(sipResponse);
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        {
                            boolean varFD6529C640F5D93B1D57A138B69C639B_1611685011 = (getState() != null && getState().equals(DialogState.EARLY)
                        && statusCode / 100 == 1);
                            {
                                {
                                    boolean var4453581B92AA957108C579A7BBD1E438_1979390584 = (cseqMethod.equals(getMethod()) && transaction != null
                            && (sipResponse.getToTag() != null || sipStack.rfc2543Supported));
                                    {
                                        setRemoteTag(sipResponse.getToTag());
                                        this.setDialogId(sipResponse.getDialogId(false));
                                        sipStack.putDialog(this);
                                        this.addRoute(sipResponse);
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                            {
                                {
                                    boolean var239B25B26F48835960443934FE465816_1411732232 = (cseqMethod.equals(getMethod())
                            && (sipResponse.getToTag() != null || sipStack.rfc2543Supported)
                            && this.getState() != DialogState.CONFIRMED);
                                    {
                                        setRemoteTag(sipResponse.getToTag());
                                        this.setDialogId(sipResponse.getDialogId(false));
                                        sipStack.putDialog(this);
                                        this.addRoute(sipResponse);
                                        setState(SIPDialog.CONFIRMED_STATE);
                                    } //End block
                                } //End collapsed parenthetic
                                {
                                    boolean var184B92973316EEACC4E8F3D92F947022_1375917619 = (cseqMethod.equals(Request.INVITE));
                                    {
                                        this.lastInviteOkReceived = Math.max(sipResponse.getCSeq().getSeqNumber(),
                                this.lastInviteOkReceived);
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                            {
                                boolean var002EA49254D7FFC38F40D126F1CC9B93_454910160 = (statusCode >= 300
                        && statusCode <= 699
                        && (getState() == null || (cseqMethod.equals(getMethod()) && getState()
                                .getValue() == SIPDialog.EARLY_STATE)));
                                {
                                    setState(SIPDialog.TERMINATED_STATE);
                                } //End block
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                    {
                        boolean varBE8416D96C82B905D899DAE9933207EA_303637754 = (this.getState() != DialogState.CONFIRMED && this.getState() != DialogState.TERMINATED);
                        {
                            {
                                RecordRouteList rrList;
                                rrList = originalRequest.getRecordRouteHeaders();
                                {
                                    ListIterator<RecordRoute> it;
                                    it = rrList.listIterator(rrList.size());
                                    {
                                        boolean var92523E1D2D6B9A5BA652D95D8D906FE7_1438236133 = (it.hasPrevious());
                                        {
                                            RecordRoute rr;
                                            rr = (RecordRoute) it.previous();
                                            Route route;
                                            route = (Route) routeList.getFirst();
                                            {
                                                boolean varD5391073D49D26C2405CCD1345D5D087_1252037423 = (route != null && rr.getAddress().equals(route.getAddress()));
                                                {
                                                    routeList.removeFirst();
                                                } //End block
                                            } //End collapsed parenthetic
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean var7AC6283B1986B5EAA725F6A0CF5B9F25_447761688 = (cseqMethod.equals(Request.NOTIFY)
                    && (this.getMethod().equals(Request.SUBSCRIBE) || this.getMethod().equals(
                            Request.REFER)) && sipResponse.getStatusCode() / 100 == 2
                    && this.getState() == null);
                    {
                        this.setDialogId(sipResponse.getDialogId(true));
                        sipStack.putDialog(this);
                        this.setState(SIPDialog.CONFIRMED_STATE);
                    } //End block
                    {
                        boolean varE749A0B488BCFEEA24F7764568DA41BB_1422821417 = (cseqMethod.equals(Request.BYE) && statusCode / 100 == 2
                    && isTerminatedOnBye());
                        {
                            setState(SIPDialog.TERMINATED_STATE);
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varDFD8EB8316ABF98C4152E3A58F249F7D_1299732247 = (cseqMethod.equals(Request.BYE) && statusCode / 100 == 2
                    && this.isTerminatedOnBye());
                {
                    this.setState(SIPDialog.TERMINATED_STATE);
                } //End block
                {
                    boolean doPutDialog;
                    doPutDialog = false;
                    {
                        boolean var7F7C84F2182F0A7FD32A6DC59936958E_1201365730 = (getLocalTag() == null && sipResponse.getTo().getTag() != null
                        && sipStack.isDialogCreated(cseqMethod) && cseqMethod.equals(getMethod()));
                        {
                            setLocalTag(sipResponse.getTo().getTag());
                            doPutDialog = true;
                        } //End block
                    } //End collapsed parenthetic
                    {
                        {
                            {
                                setState(SIPDialog.EARLY_STATE);
                                this.setDialogId(sipResponse.getDialogId(true));
                                sipStack.putDialog(this);
                            } //End block
                        } //End block
                        {
                            {
                                boolean var5EEA5383440BFA6F3C614F44448A4223_932526425 = (statusCode == 489
                                && (cseqMethod.equals(Request.NOTIFY) || cseqMethod
                                        .equals(Request.SUBSCRIBE)));
                                {
                                    {
                                        boolean var6FE8ACC5352DCA3449210F8EDED912B3_117312962 = (sipStack.isLoggingEnabled());
                                        sipStack.getStackLogger().logDebug(
                                    "RFC 3265 : Not setting dialog to TERMINATED for 489");
                                    } //End collapsed parenthetic
                                } //End block
                                {
                                    {
                                        boolean varE3695A6993661066E9CCD532BC123501_646444949 = (!this.isReInvite() && getState() != DialogState.CONFIRMED);
                                        {
                                            this.setState(SIPDialog.TERMINATED_STATE);
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                    {
                        {
                            boolean var8F048B81832FCC5E25717E696D6EC78F_256318136 = (this.dialogState <= SIPDialog.EARLY_STATE
                            && (cseqMethod.equals(Request.INVITE)
                                    || cseqMethod.equals(Request.SUBSCRIBE) || cseqMethod
                                    .equals(Request.REFER)));
                            {
                                this.setState(SIPDialog.CONFIRMED_STATE);
                            } //End block
                        } //End collapsed parenthetic
                        {
                            this.setDialogId(sipResponse.getDialogId(true));
                            sipStack.putDialog(this);
                        } //End block
                        {
                            boolean varCABBB85C5AA4259E2991A258DBA7D46B_33789935 = (transaction.getState() != TransactionState.TERMINATED
                            && sipResponse.getStatusCode() == Response.OK
                            && cseqMethod.equals(Request.INVITE)
                            && this.isBackToBackUserAgent);
                            {
                                {
                                    boolean varC5A2075CB8D88EC332A5381179A3C4E5_1510275219 = (!this.takeAckSem());
                                    {
                                        {
                                            boolean var974BD9A3C84119780B64DA7C8AA64368_458764504 = (sipStack.isLoggingEnabled());
                                            {
                                                sipStack.getStackLogger().logDebug(
                                            "Delete dialog -- cannot acquire ackSem");
                                            } //End block
                                        } //End collapsed parenthetic
                                        this.delete();
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.413 -0400", hash_original_method = "96CF2F98DDD4CA038A3AFDF5A5247694", hash_generated_method = "AB2250768DA0F2216DFC128B50D3D3C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void startRetransmitTimer(SIPServerTransaction sipServerTx, Response response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(sipServerTx.dsTaint);
        {
            boolean varDA05BDD7E394F41387C809972258ED76_1765749983 = (sipServerTx.getRequest().getMethod().equals(Request.INVITE)
                && response.getStatusCode() / 100 == 2);
            {
                this.startTimer(sipServerTx);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (sipServerTx.getRequest().getMethod().equals(Request.INVITE)
                //&& response.getStatusCode() / 100 == 2) {
            //this.startTimer(sipServerTx);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.413 -0400", hash_original_method = "5F3E7F6102F24C611CAB04E5AE199DBF", hash_generated_method = "60D590ED4B8C23F135E8F2ED80605822")
    @DSModeled(DSC.SAFE)
    public SIPResponse getLastResponse() {
        return (SIPResponse)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return lastResponse;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.413 -0400", hash_original_method = "5B8AFE9B6B91DF83BE42F6862D2EF06A", hash_generated_method = "3FF24638F594D8D12B927BF141A6BD72")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void doTargetRefresh(SIPMessage sipMessage) {
        dsTaint.addTaint(sipMessage.dsTaint);
        ContactList contactList;
        contactList = sipMessage.getContactHeaders();
        {
            Contact contact;
            contact = (Contact) contactList.getFirst();
            this.setRemoteTarget(contact);
        } //End block
        // ---------- Original Method ----------
        //ContactList contactList = sipMessage.getContactHeaders();
        //if (contactList != null) {
            //Contact contact = (Contact) contactList.getFirst();
            //this.setRemoteTarget(contact);
        //}
    }

    
        private static final boolean optionPresent(ListIterator l, String option) {
        while (l.hasNext()) {
            OptionTag opt = (OptionTag) l.next();
            if (opt != null && option.equalsIgnoreCase(opt.getOptionTag()))
                return true;
        }
        return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.414 -0400", hash_original_method = "DE196281E5E185EC5F05D42F6040C5AD", hash_generated_method = "462C10980F49E8D926F0C452AAEC2E17")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Response createReliableProvisionalResponse(int statusCode) throws InvalidArgumentException, SipException {
        dsTaint.addTaint(statusCode);
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("Not a Server Dialog!");
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("Bad status code ");
        SIPRequest request;
        request = this.originalRequest;
        {
            boolean varF7429BEB5E0EF391085C3EA5B848B555_1309101517 = (!request.getMethod().equals(Request.INVITE));
            if (DroidSafeAndroidRuntime.control) throw new SipException("Bad method");
        } //End collapsed parenthetic
        ListIterator<SIPHeader> list;
        list = request.getHeaders(SupportedHeader.NAME);
        {
            boolean var4A2559DE457AD8ED09DD13E71379114F_149789046 = (list == null || !optionPresent(list, "100rel"));
            {
                list = request.getHeaders(RequireHeader.NAME);
                {
                    boolean var1B8A6F1B7D3894FD5B5CD4B77CBF0692_1901508408 = (list == null || !optionPresent(list, "100rel"));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new SipException("No Supported/Require 100rel header in the request");
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        SIPResponse response;
        response = request.createResponse(statusCode);
        Require require;
        require = new Require();
        try 
        {
            require.setOptionTag("100rel");
        } //End block
        catch (Exception ex)
        {
            InternalErrorHandler.handleException(ex);
        } //End block
        response.addHeader(require);
        RSeq rseq;
        rseq = new RSeq();
        rseq.setSeqNumber(1L);
        RecordRouteList rrl;
        rrl = request.getRecordRouteHeaders();
        {
            RecordRouteList rrlclone;
            rrlclone = (RecordRouteList) rrl.clone();
            response.setHeader(rrlclone);
        } //End block
        return (Response)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.414 -0400", hash_original_method = "CEB91EBD9D583AC6C7E366C7B6D0F858", hash_generated_method = "4E87D7DC5CC2B2E7F75B946593F6B4B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean handlePrack(SIPRequest prackRequest) {
        dsTaint.addTaint(prackRequest.dsTaint);
        {
            boolean var0E41A90AC7F80C21FD8716EAE0D773F7_1515579382 = (!this.isServer());
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1676974899 = (sipStack.isLoggingEnabled());
                    sipStack.getStackLogger().logDebug("Dropping Prack -- not a server Dialog");
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        SIPServerTransaction sipServerTransaction;
        sipServerTransaction = (SIPServerTransaction) this
                .getFirstTransaction();
        SIPResponse sipResponse;
        sipResponse = sipServerTransaction.getReliableProvisionalResponse();
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_2122855502 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger()
                        .logDebug("Dropping Prack -- ReliableResponse not found");
            } //End collapsed parenthetic
        } //End block
        RAck rack;
        rack = (RAck) prackRequest.getHeader(RAckHeader.NAME);
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1911878461 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug("Dropping Prack -- rack header not found");
            } //End collapsed parenthetic
        } //End block
        CSeq cseq;
        cseq = (CSeq) sipResponse.getCSeq();
        {
            boolean var278DC96722B25CDE6DFD16B8198946C1_448896025 = (!rack.getMethod().equals(cseq.getMethod()));
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_888373329 = (sipStack.isLoggingEnabled());
                    sipStack.getStackLogger().logDebug(
                        "Dropping Prack -- CSeq Header does not match PRACK");
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean var9E7D79F6F26763E9EC31F75D4B835E42_1868738990 = (rack.getCSeqNumberLong() != cseq.getSeqNumber());
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_2096276657 = (sipStack.isLoggingEnabled());
                    sipStack.getStackLogger().logDebug(
                        "Dropping Prack -- CSeq Header does not match PRACK");
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        RSeq rseq;
        rseq = (RSeq) sipResponse.getHeader(RSeqHeader.NAME);
        {
            boolean var14265A1FCB2C0EE420AF27A8D1000FC8_1308714179 = (rack.getRSequenceNumber() != rseq.getSeqNumber());
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_897517554 = (sipStack.isLoggingEnabled());
                    sipStack.getStackLogger().logDebug(
                        "Dropping Prack -- RSeq Header does not match PRACK");
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        boolean var9683C82188D8B4F740D5FD5CABA0ABB6_2075803466 = (sipServerTransaction.prackRecieved());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.415 -0400", hash_original_method = "333DA078CA74B6FD5F6C9544F533B1F3", hash_generated_method = "79B5624EC913F2477456A9D4BC52F0B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendReliableProvisionalResponse(Response relResponse) throws SipException {
        dsTaint.addTaint(relResponse.dsTaint);
        {
            boolean var0E41A90AC7F80C21FD8716EAE0D773F7_1451809609 = (!this.isServer());
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException("Not a Server Dialog");
            } //End block
        } //End collapsed parenthetic
        SIPResponse sipResponse;
        sipResponse = (SIPResponse) relResponse;
        {
            boolean varF58A7EF76B015A36548669D4B5BC189B_136717872 = (relResponse.getStatusCode() == 100);
            if (DroidSafeAndroidRuntime.control) throw new SipException("Cannot send 100 as a reliable provisional response");
        } //End collapsed parenthetic
        {
            boolean var3F06CAF4D76D1B222835AB0581EBBF2D_464590116 = (relResponse.getStatusCode() / 100 > 2);
            if (DroidSafeAndroidRuntime.control) throw new SipException(
                    "Response code is not a 1xx response - should be in the range 101 to 199 ");
        } //End collapsed parenthetic
        {
            boolean var2453F1BE4A002CC1EF6C5E8F78E655A0_1637813025 = (sipResponse.getToTag() == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException(
                    "Badly formatted response -- To tag mandatory for Reliable Provisional Response");
            } //End block
        } //End collapsed parenthetic
        ListIterator requireList;
        requireList = (ListIterator) relResponse.getHeaders(RequireHeader.NAME);
        boolean found;
        found = false;
        {
            {
                boolean var3100C156835BFDAEC37B3A0F53F0E27B_724307314 = (requireList.hasNext() && !found);
                {
                    RequireHeader rh;
                    rh = (RequireHeader) requireList.next();
                    {
                        boolean varDF9A6A091AE7E489D36022F85E7FEEE0_703039467 = (rh.getOptionTag().equalsIgnoreCase("100rel"));
                        {
                            found = true;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            Require require;
            require = new Require("100rel");
            relResponse.addHeader(require);
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1871130238 = (sipStack.isLoggingEnabled());
                {
                    sipStack.getStackLogger().logDebug(
                        "Require header with optionTag 100rel is needed -- adding one");
                } //End block
            } //End collapsed parenthetic
        } //End block
        SIPServerTransaction serverTransaction;
        serverTransaction = (SIPServerTransaction) this
                .getFirstTransaction();
        this.setLastResponse(serverTransaction, sipResponse);
        this.setDialogId(sipResponse.getDialogId(true));
        serverTransaction.sendReliableProvisionalResponse(relResponse);
        this.startRetransmitTimer(serverTransaction, relResponse);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.415 -0400", hash_original_method = "BF7D1FA3BFA6C180C8021919F244470C", hash_generated_method = "EF49557A4FF9EE63B70FF5431B0BCAA1")
    @DSModeled(DSC.SAFE)
    public void terminateOnBye(boolean terminateFlag) throws SipException {
        dsTaint.addTaint(terminateFlag);
        // ---------- Original Method ----------
        //this.terminateOnBye = terminateFlag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.415 -0400", hash_original_method = "97AA8D077ED8B88563B1FCEB7D3F7A03", hash_generated_method = "3989220F20B7D3A9147AB058D826F7D8")
    @DSModeled(DSC.SAFE)
    public void setAssigned() {
        this.isAssigned = true;
        // ---------- Original Method ----------
        //this.isAssigned = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.416 -0400", hash_original_method = "F8427D0E95C386EDB403D30E8B4BBEC5", hash_generated_method = "433FF69572CE64256C9EBB6BB324281E")
    @DSModeled(DSC.SAFE)
    public boolean isAssigned() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.isAssigned;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.416 -0400", hash_original_method = "370EA53498504D191CA2C54D6246F992", hash_generated_method = "CA36179AD6646062216731E31AC059D6")
    @DSModeled(DSC.SAFE)
    public Contact getMyContactHeader() {
        return (Contact)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return contactHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.416 -0400", hash_original_method = "1F7F0E32648D183A0E0322F85F939567", hash_generated_method = "799601261C7CC494C1DFF0CE6997B391")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean handleAck(SIPServerTransaction ackTransaction) {
        dsTaint.addTaint(ackTransaction.dsTaint);
        SIPRequest sipRequest;
        sipRequest = ackTransaction.getOriginalRequest();
        {
            boolean varB6606859BF451015E77F1552F52092D0_861472104 = (isAckSeen() && getRemoteSeqNumber() == sipRequest.getCSeq().getSeqNumber());
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1557746779 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logDebug(
                        "ACK already seen by dialog -- dropping Ack" + " retransmission");
                    } //End block
                } //End collapsed parenthetic
                acquireTimerTaskSem();
                try 
                {
                    {
                        this.timerTask.cancel();
                        this.timerTask = null;
                    } //End block
                } //End block
                finally 
                {
                    releaseTimerTaskSem();
                } //End block
            } //End block
            {
                boolean var4A98AE6585D44012F8F89352F9238253_804181851 = (this.getState() == DialogState.TERMINATED);
                {
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_20731150 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger().logDebug("Dialog is terminated -- dropping ACK");
                    } //End collapsed parenthetic
                } //End block
                {
                    SIPServerTransaction tr;
                    tr = getInviteTransaction();
                    SIPResponse sipResponse;
                    sipResponse = (tr != null ? tr.getLastResponse() : null);//DSFIXME:  CODE0008: Nested ternary operator in expression
                    {
                        boolean var161CF50F3C95997F419241A9096FFB37_1621054773 = (tr != null
                    && sipResponse != null
                    && sipResponse.getStatusCode() / 100 == 2
                    && sipResponse.getCSeq().getMethod().equals(Request.INVITE)
                    && sipResponse.getCSeq().getSeqNumber() == sipRequest.getCSeq()
                            .getSeqNumber());
                        {
                            ackTransaction.setDialog(this, sipResponse.getDialogId(false));
                            ackReceived(sipRequest);
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_156882529 = (sipStack.isLoggingEnabled());
                                sipStack.getStackLogger().logDebug("ACK for 2XX response --- sending to TU ");
                            } //End collapsed parenthetic
                        } //End block
                        {
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_508392979 = (sipStack.isLoggingEnabled());
                                sipStack.getStackLogger().logDebug(
                            " INVITE transaction not found  -- Discarding ACK");
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.417 -0400", hash_original_method = "5C164F59F3DF11F779F16A5BAEE8EAC7", hash_generated_method = "780165E8C8C02AEBC68ADE3D8A6AEBC4")
    @DSModeled(DSC.SAFE)
     void setEarlyDialogId(String earlyDialogId) {
        dsTaint.addTaint(earlyDialogId);
        // ---------- Original Method ----------
        //this.earlyDialogId = earlyDialogId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.417 -0400", hash_original_method = "275E7276434F5D20F41DC92B4F25BAEE", hash_generated_method = "37BD73CB43722624C8CAB20229C7D26F")
    @DSModeled(DSC.SAFE)
     String getEarlyDialogId() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return earlyDialogId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.417 -0400", hash_original_method = "5A72AC369AA326C1E4BE607E2D1E31FF", hash_generated_method = "F7815EDF3B5324541985D01B86413B62")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void releaseAckSem() {
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_255600135 = (sipStack.isLoggingEnabled());
                {
                    sipStack.getStackLogger().logDebug("releaseAckSem]" + this);
                } //End block
            } //End collapsed parenthetic
            this.ackSem.release();
        } //End block
        // ---------- Original Method ----------
        //if (this.isBackToBackUserAgent) {
            //if (sipStack.isLoggingEnabled()) {
                //sipStack.getStackLogger().logDebug("releaseAckSem]" + this);
            //}
            //this.ackSem.release();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.418 -0400", hash_original_method = "75493DFA4E25D8A29CC5DF9217BF734F", hash_generated_method = "ADD0096881ADC3DC3BAC95C997B00115")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean takeAckSem() {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_383587344 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("[takeAckSem " + this);
            } //End block
        } //End collapsed parenthetic
        try 
        {
            {
                boolean varF77F8A7B1E99FF133CA038DFA9D02F86_1205791458 = (!this.ackSem.tryAcquire(2, TimeUnit.SECONDS));
                {
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_311173852 = (sipStack.isLoggingEnabled());
                        {
                            sipStack.getStackLogger().logError("Cannot aquire ACK semaphore");
                        } //End block
                    } //End collapsed parenthetic
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1429795494 = (sipStack.isLoggingEnabled());
                        {
                            sipStack.getStackLogger().logDebug("Semaphore previously acquired at " + this.stackTrace);
                            sipStack.getStackLogger().logStackTrace();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1358470278 = (sipStack.isLoggingEnabled());
                {
                    this.recordStackTrace();
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (InterruptedException ex)
        {
            sipStack.getStackLogger().logError("Cannot aquire ACK semaphore");
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.419 -0400", hash_original_method = "68D4C33CE448DB45C09F49FC9815E4FD", hash_generated_method = "007D86D8C9C3BDFDB0C23C50BC8CAA08")
    @DSModeled(DSC.SAFE)
    private void setLastAckReceived(SIPRequest lastAckReceived) {
        dsTaint.addTaint(lastAckReceived.dsTaint);
        // ---------- Original Method ----------
        //this.lastAckReceived = lastAckReceived;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.419 -0400", hash_original_method = "2894D6C9FD5402948626BDE17D2ADDA1", hash_generated_method = "8E0649C88ACE24C6C5E68C1B3C860FDD")
    @DSModeled(DSC.SAFE)
    protected SIPRequest getLastAckReceived() {
        return (SIPRequest)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return lastAckReceived;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.420 -0400", hash_original_method = "AE316349F4F2DB7FF5C817D5A1FDA212", hash_generated_method = "18FEA6AD877961E621AEB1BBA40F769F")
    @DSModeled(DSC.SAFE)
    private void setLastAckSent(SIPRequest lastAckSent) {
        dsTaint.addTaint(lastAckSent.dsTaint);
        // ---------- Original Method ----------
        //this.lastAckSent = lastAckSent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.420 -0400", hash_original_method = "2B44FD1497547940266A6934DB958355", hash_generated_method = "46C047AB64373B72D52EF9E34BF1C4EA")
    @DSModeled(DSC.SAFE)
    public boolean isAtleastOneAckSent() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.isAcknowledged;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.420 -0400", hash_original_method = "FAA2C5BC01CFE296F7D6D441890115F1", hash_generated_method = "5D6A7CDB2417AA4070EE356669C2AB12")
    @DSModeled(DSC.SAFE)
    public boolean isBackToBackUserAgent() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.isBackToBackUserAgent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.420 -0400", hash_original_method = "1ECA22F9D5D81E6992181CD96CD57EA7", hash_generated_method = "38DF1A255D6D3BC7E3238BA3DFD42AF4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void doDeferredDeleteIfNoAckSent(long seqno) {
        dsTaint.addTaint(seqno);
        {
            boolean var57BEDF91C3ACD8FDD0380E079BFC759D_1851196788 = (sipStack.getTimer() == null);
            {
                this.setState(TERMINATED_STATE);
            } //End block
            {
                dialogDeleteIfNoAckSentTask = new DialogDeleteIfNoAckSentTask(seqno);
                sipStack.getTimer().schedule(
					dialogDeleteIfNoAckSentTask,
					SIPTransaction.TIMER_J
							* SIPTransactionStack.BASE_TIMER_INTERVAL);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (sipStack.getTimer() == null) {
			//this.setState(TERMINATED_STATE);
		//} else if(dialogDeleteIfNoAckSentTask == null){
			//dialogDeleteIfNoAckSentTask = new DialogDeleteIfNoAckSentTask(seqno);
			//sipStack.getTimer().schedule(
					//dialogDeleteIfNoAckSentTask,
					//SIPTransaction.TIMER_J
							//* SIPTransactionStack.BASE_TIMER_INTERVAL);
		//}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.420 -0400", hash_original_method = "782C3B034CC64F54A5BC7BB8ED6FEDA6", hash_generated_method = "5483C632656F6DE6E777597D7F71485A")
    @DSModeled(DSC.SAFE)
    public void setBackToBackUserAgent() {
        this.isBackToBackUserAgent = true;
        // ---------- Original Method ----------
        //this.isBackToBackUserAgent = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.421 -0400", hash_original_method = "3A5B567A7D7C4A4D6D60D4CFA5E677D1", hash_generated_method = "EA50B51783C7BC0A08C89CA3135D4FD6")
    @DSModeled(DSC.SAFE)
     EventHeader getEventHeader() {
        return (EventHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return eventHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.421 -0400", hash_original_method = "C85F235E26C94FDBCE92FE9C88454CDD", hash_generated_method = "39FE6375F162BA49EBAD8064BAB467E8")
    @DSModeled(DSC.SAFE)
     void setEventHeader(EventHeader eventHeader) {
        dsTaint.addTaint(eventHeader.dsTaint);
        // ---------- Original Method ----------
        //this.eventHeader = eventHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.421 -0400", hash_original_method = "D178A1777AB3611D9691A3F4A69F3B06", hash_generated_method = "C02317694E2C77F17290D253A96A937D")
    @DSModeled(DSC.SAFE)
     void setServerTransactionFlag(boolean serverTransactionFlag) {
        dsTaint.addTaint(serverTransactionFlag);
        // ---------- Original Method ----------
        //this.serverTransactionFlag = serverTransactionFlag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.421 -0400", hash_original_method = "B9FC7E5C15DF48754B63587E10ABF39E", hash_generated_method = "8A4F96534613B6A8683C4C955BCF0103")
    @DSModeled(DSC.SAFE)
     void setReInviteFlag(boolean reInviteFlag) {
        dsTaint.addTaint(reInviteFlag);
        // ---------- Original Method ----------
        //this.reInviteFlag = reInviteFlag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.421 -0400", hash_original_method = "554E3D8C2985A7B76F710766F6151401", hash_generated_method = "074F7DD10839983F67F1D3BFEDF37F45")
    @DSModeled(DSC.SAFE)
    public boolean isSequnceNumberValidation() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.sequenceNumberValidation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.422 -0400", hash_original_method = "07E72D397966AE985C4FA6CA39D288C5", hash_generated_method = "2CA8E42865DEC07CBC74D648985E0DA5")
    @DSModeled(DSC.SAFE)
    public void disableSequenceNumberValidation() {
        this.sequenceNumberValidation = false;
        // ---------- Original Method ----------
        //this.sequenceNumberValidation = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.422 -0400", hash_original_method = "32EDC5DA45A565F7D6F42D86C325067F", hash_generated_method = "283EBC055C1A2562C13F28011FC9945E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void acquireTimerTaskSem() {
        boolean acquired;
        acquired = false;
        try 
        {
            acquired = this.timerTaskLock.tryAcquire(10, TimeUnit.SECONDS);
        } //End block
        catch (InterruptedException ex)
        {
            acquired = false;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Impossible to acquire the dialog timer task lock");
        } //End block
        // ---------- Original Method ----------
        //boolean acquired = false;
        //try {
            //acquired = this.timerTaskLock.tryAcquire(10, TimeUnit.SECONDS);
        //} catch ( InterruptedException ex) {
            //acquired = false;
        //}
        //if(!acquired) {
        	//throw new IllegalStateException("Impossible to acquire the dialog timer task lock");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.422 -0400", hash_original_method = "7C538F01F8063281F04142649C9B2CD0", hash_generated_method = "3B7BE3389027D7D895A0B9E59CA6FC3E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void releaseTimerTaskSem() {
        this.timerTaskLock.release();
        // ---------- Original Method ----------
        //this.timerTaskLock.release();
    }

    
    public class ReInviteSender implements Runnable, Serializable {
        ClientTransaction ctx;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.422 -0400", hash_original_method = "420F244B37AE2567998EBC3FAC66EFCB", hash_generated_method = "F91C5866B5E583B7C9822CA9C0CFE5E1")
        @DSModeled(DSC.SAFE)
        public ReInviteSender(ClientTransaction ctx) {
            dsTaint.addTaint(ctx.dsTaint);
            // ---------- Original Method ----------
            //this.ctx = ctx;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.423 -0400", hash_original_method = "05496AD165548F09E9869029BA920071", hash_generated_method = "1ADB0BBCC5965FA3A846905A0639F5FF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void terminate() {
            try 
            {
                ctx.terminate();
                Thread.currentThread().interrupt();
            } //End block
            catch (ObjectInUseException e)
            {
                sipStack.getStackLogger().logError("unexpected error", e);
            } //End block
            // ---------- Original Method ----------
            //try {
                //ctx.terminate();
                //Thread.currentThread().interrupt();
            //} catch (ObjectInUseException e) {
                //sipStack.getStackLogger().logError("unexpected error", e);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.423 -0400", hash_original_method = "DA8B28F4804F3F25626961946D2074C4", hash_generated_method = "D15C4792F6576D0B9A915F56DA6F0F07")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            try 
            {
                long timeToWait;
                timeToWait = 0;
                long startTime;
                startTime = System.currentTimeMillis();
                {
                    boolean varCFBA9479F56B2139A22CD810CDC2D9F0_1853426490 = (!SIPDialog.this.takeAckSem());
                    {
                        {
                            boolean var2AB968A8303910EE00F810B6DE3410F9_1266034411 = (sipStack.isLoggingEnabled());
                            sipStack.getStackLogger().logError(
                            "Could not send re-INVITE time out ClientTransaction");
                        } //End collapsed parenthetic
                        ((SIPClientTransaction) ctx).fireTimeoutTimer();
                        {
                            boolean var4139F5E7958AE9C2F1C82A94207591C8_1860965146 = (sipProvider.getSipListener() != null && sipProvider.getSipListener() instanceof SipListenerExt);
                            {
                                raiseErrorEvent(SIPDialogErrorEvent.DIALOG_REINVITE_TIMEOUT);
                            } //End block
                            {
                                Request byeRequest;
                                byeRequest = SIPDialog.this.createRequest(Request.BYE);
                                {
                                    boolean varD7581F5DBD86F25779F5137034C43592_1120096187 = (MessageFactoryImpl.getDefaultUserAgentHeader() != null);
                                    {
                                        byeRequest.addHeader(MessageFactoryImpl.getDefaultUserAgentHeader());
                                    } //End block
                                } //End collapsed parenthetic
                                ReasonHeader reasonHeader;
                                reasonHeader = new Reason();
                                reasonHeader.setCause(1024);
                                reasonHeader.setText("Timed out waiting to re-INVITE");
                                byeRequest.addHeader(reasonHeader);
                                ClientTransaction byeCtx;
                                byeCtx = SIPDialog.this.getSipProvider().getNewClientTransaction(byeRequest);
                                SIPDialog.this.sendRequest(byeCtx);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var269430BA4810976B135F582C3E3C146F_1495621311 = (getState() != DialogState.TERMINATED);
                    {
                        timeToWait = System.currentTimeMillis() - startTime;
                    } //End block
                } //End collapsed parenthetic
                try 
                {
                    {
                        Thread.sleep(SIPDialog.this.reInviteWaitTime);
                    } //End block
                } //End block
                catch (InterruptedException ex)
                {
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_194198451 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger().logDebug("Interrupted sleep");
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean var8A4D69DC3EB47276971D5D31F4B6119D_472250580 = (SIPDialog.this.getState() != DialogState.TERMINATED);
                    {
                        SIPDialog.this.sendRequest(ctx, true);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_280210128 = (sipStack.isLoggingEnabled());
                    sipStack.getStackLogger().logDebug("re-INVITE successfully sent");
                } //End collapsed parenthetic
            } //End block
            catch (Exception ex)
            {
                sipStack.getStackLogger().logError("Error sending re-INVITE", ex);
            } //End block
            finally 
            {
                this.ctx = null;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        private static final long serialVersionUID = 1019346148741070635L;
    }


    
    class LingerTimer extends SIPStackTimerTask implements Serializable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.424 -0400", hash_original_method = "FEDA9229694989A502508E95A3FCFE54", hash_generated_method = "CF6D3A28041C64960D5CFB7948EF46EA")
        @DSModeled(DSC.SAFE)
        public LingerTimer() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.424 -0400", hash_original_method = "CEEC3EAE1C5B12DC43D70E37F1A80A0A", hash_generated_method = "7401AED92285EC688655934F10252F65")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected void runTask() {
            SIPDialog dialog;
            dialog = SIPDialog.this;
            {
                eventListeners.clear();
            } //End block
            timerTaskLock = null;
            sipStack.removeDialog(dialog);
            // ---------- Original Method ----------
            //SIPDialog dialog = SIPDialog.this;
            //if(eventListeners != null) {
            	//eventListeners.clear();
            //}
            //timerTaskLock = null;
            //sipStack.removeDialog(dialog);
        }

        
    }


    
    class DialogTimerTask extends SIPStackTimerTask implements Serializable {
        int nRetransmissions;
        SIPServerTransaction transaction;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.424 -0400", hash_original_method = "99967D6CED868AEC0B4229119C79B2A3", hash_generated_method = "29BD4F064B6B916EBE0E6BCDFD2C4DB5")
        @DSModeled(DSC.SAFE)
        public DialogTimerTask(SIPServerTransaction transaction) {
            dsTaint.addTaint(transaction.dsTaint);
            this.nRetransmissions = 0;
            // ---------- Original Method ----------
            //this.transaction = transaction;
            //this.nRetransmissions = 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.425 -0400", hash_original_method = "7353CE022084912970B9E490A7F56F25", hash_generated_method = "9DF106B4FCC6CBAC826366F0DE4096F3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected void runTask() {
            SIPDialog dialog;
            dialog = SIPDialog.this;
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_961332908 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug("Running dialog timer");
            } //End collapsed parenthetic
            SIPServerTransaction transaction;
            transaction = this.transaction;
            {
                {
                    boolean var4B6640D4DE774F6FA49F20C035CC9869_1732580609 = (sipProvider.getSipListener() != null && sipProvider.getSipListener() instanceof SipListenerExt);
                    {
                        raiseErrorEvent(SIPDialogErrorEvent.DIALOG_ACK_NOT_RECEIVED_TIMEOUT);
                    } //End block
                    {
                        dialog.delete();
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varB2E591CC8FE73A729A5DB2EFC02188A9_24492152 = (transaction != null
                        && transaction.getState() != javax.sip.TransactionState.TERMINATED);
                    {
                        transaction.raiseErrorEvent(SIPTransactionErrorEvent.TIMEOUT_ERROR);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                SIPResponse response;
                response = transaction.getLastResponse();
                {
                    boolean varEB9E7BA125F929A2C756DC8C1AAE09C1_943380504 = (response.getStatusCode() == 200);
                    {
                        try 
                        {
                            {
                                boolean varC839103C0955C82229EFCA85F8C206DB_20065953 = (dialog.toRetransmitFinalResponse(transaction.T2));
                                transaction.sendMessage(response);
                            } //End collapsed parenthetic
                        } //End block
                        catch (IOException ex)
                        {
                            raiseIOException(transaction.getPeerAddress(), transaction.getPeerPort(),
                                transaction.getPeerProtocol());
                        } //End block
                        finally 
                        {
                            SIPTransactionStack stack;
                            stack = dialog.sipStack;
                            {
                                boolean var7E956449752FC9BA92CD92F85600E671_1750163353 = (stack.isLoggingEnabled());
                                {
                                    stack.getStackLogger().logDebug("resend 200 response from " + dialog);
                                } //End block
                            } //End collapsed parenthetic
                            transaction.fireTimer();
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean var4EA6B06F6CBCD1FD755A7849352DDFB9_205350733 = (dialog.isAckSeen() || dialog.dialogState == TERMINATED_STATE);
                {
                    this.transaction = null;
                    this.cancel();
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    class DialogDeleteTask extends SIPStackTimerTask implements Serializable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.425 -0400", hash_original_method = "F5F1F8AAD0E466013C610957B539961C", hash_generated_method = "F5F1F8AAD0E466013C610957B539961C")
                public DialogDeleteTask ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.426 -0400", hash_original_method = "705C6BB4461CC5F37E0565BB6F16C084", hash_generated_method = "12743D2452C0A21B643AFBC46E200A26")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected void runTask() {
            delete();
            // ---------- Original Method ----------
            //delete();
        }

        
    }


    
    class DialogDeleteIfNoAckSentTask extends SIPStackTimerTask implements Serializable {
        private long seqno;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.427 -0400", hash_original_method = "D6D7FB77E2882EBB362E9FAF3BE7D45E", hash_generated_method = "5C3DFB6587B89F55A31EA0BFFB8A2BAA")
        @DSModeled(DSC.SAFE)
        public DialogDeleteIfNoAckSentTask(long seqno) {
            dsTaint.addTaint(seqno);
            // ---------- Original Method ----------
            //this.seqno = seqno;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.428 -0400", hash_original_method = "47EF190411AC9DCEBDEAD83DF8BB27D9", hash_generated_method = "CCB81880CF97BE7AC92E41941B6C7681")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected void runTask() {
            {
                boolean var39396AEF52D6456D6CD60D28DE63583D_292234300 = (SIPDialog.this.highestSequenceNumberAcknowledged < seqno);
                {
                    dialogDeleteIfNoAckSentTask = null;
                    {
                        boolean var2DCCFE4A22572D9F02A458128FB13A98_2134873396 = (!SIPDialog.this.isBackToBackUserAgent);
                        {
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_1195460343 = (sipStack.isLoggingEnabled());
                                sipStack.getStackLogger().logError("ACK Was not sent. killing dialog");
                            } //End collapsed parenthetic
                            {
                                boolean varB740E386243B854D0A28C1291599B3CA_1136501704 = (((SipProviderImpl)sipProvider).getSipListener() instanceof SipListenerExt);
                                {
                                    raiseErrorEvent(SIPDialogErrorEvent.DIALOG_ACK_NOT_SENT_TIMEOUT);
                                } //End block
                                {
                                    delete();
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        {
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_224392534 = (sipStack.isLoggingEnabled());
                                sipStack.getStackLogger().logError("ACK Was not sent. Sending BYE");
                            } //End collapsed parenthetic
                            {
                                boolean varB740E386243B854D0A28C1291599B3CA_121499360 = (((SipProviderImpl)sipProvider).getSipListener() instanceof SipListenerExt);
                                {
                                    raiseErrorEvent(SIPDialogErrorEvent.DIALOG_ACK_NOT_SENT_TIMEOUT);
                                } //End block
                                {
                                    try 
                                    {
                                        Request byeRequest;
                                        byeRequest = SIPDialog.this.createRequest(Request.BYE);
                                        {
                                            boolean var53F281250CFE3DAFB9B635A8C29C3932_122633313 = (MessageFactoryImpl.getDefaultUserAgentHeader() != null);
                                            {
                                                byeRequest.addHeader(MessageFactoryImpl.getDefaultUserAgentHeader());
                                            } //End block
                                        } //End collapsed parenthetic
                                        ReasonHeader reasonHeader;
                                        reasonHeader = new Reason();
                                        reasonHeader.setProtocol("SIP");
                                        reasonHeader.setCause(1025);
                                        reasonHeader.setText("Timed out waiting to send ACK");
                                        byeRequest.addHeader(reasonHeader);
                                        ClientTransaction byeCtx;
                                        byeCtx = SIPDialog.this.getSipProvider().getNewClientTransaction(byeRequest);
                                        SIPDialog.this.sendRequest(byeCtx);
                                    } //End block
                                    catch (Exception ex)
                                    {
                                        SIPDialog.this.delete();
                                    } //End block
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private static final long serialVersionUID = -1429794423085204069L;
    public final static int NULL_STATE = -1;
    public final static int EARLY_STATE = DialogState._EARLY;
    public final static int CONFIRMED_STATE = DialogState._CONFIRMED;
    public final static int TERMINATED_STATE = DialogState._TERMINATED;
    private static final int DIALOG_LINGER_TIME = 8;
}

