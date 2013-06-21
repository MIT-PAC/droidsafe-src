package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.core.Host;
import gov.nist.core.HostPort;
import gov.nist.core.ServerLogger;
import gov.nist.core.StackLogger;
import gov.nist.core.ThreadAuditor;
import gov.nist.core.net.AddressResolver;
import gov.nist.core.net.DefaultNetworkLayer;
import gov.nist.core.net.NetworkLayer;
import gov.nist.javax.sip.DefaultAddressResolver;
import gov.nist.javax.sip.ListeningPointImpl;
import gov.nist.javax.sip.LogRecordFactory;
import gov.nist.javax.sip.SIPConstants;
import gov.nist.javax.sip.SipListenerExt;
import gov.nist.javax.sip.SipProviderImpl;
import gov.nist.javax.sip.SipStackImpl;
import gov.nist.javax.sip.header.Event;
import gov.nist.javax.sip.header.Via;
import gov.nist.javax.sip.header.extensions.JoinHeader;
import gov.nist.javax.sip.header.extensions.ReplacesHeader;
import gov.nist.javax.sip.message.SIPMessage;
import gov.nist.javax.sip.message.SIPRequest;
import gov.nist.javax.sip.message.SIPResponse;
import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.sip.ClientTransaction;
import javax.sip.Dialog;
import javax.sip.DialogState;
import javax.sip.DialogTerminatedEvent;
import javax.sip.ServerTransaction;
import javax.sip.SipException;
import javax.sip.SipListener;
import javax.sip.TransactionState;
import javax.sip.TransactionTerminatedEvent;
import javax.sip.address.Hop;
import javax.sip.address.Router;
import javax.sip.header.CallIdHeader;
import javax.sip.header.EventHeader;
import javax.sip.message.Request;
import javax.sip.message.Response;

public abstract class SIPTransactionStack implements SIPTransactionEventListener, SIPDialogEventListener {
    protected ConcurrentHashMap<String, SIPServerTransaction> retransmissionAlertTransactions;
    protected ConcurrentHashMap<String, SIPDialog> earlyDialogTable;
    protected ConcurrentHashMap<String, SIPDialog> dialogTable;
    private Timer timer;
    private ConcurrentHashMap<String, SIPServerTransaction> pendingTransactions;
    private ConcurrentHashMap<String, SIPClientTransaction> clientTransactionTable;
    protected boolean unlimitedServerTransactionTableSize = true;
    protected boolean unlimitedClientTransactionTableSize = true;
    protected int serverTransactionTableHighwaterMark = 5000;
    protected int serverTransactionTableLowaterMark = 4000;
    protected int clientTransactionTableHiwaterMark = 1000;
    protected int clientTransactionTableLowaterMark = 800;
    private AtomicInteger activeClientTransactionCount = new AtomicInteger(0);
    private ConcurrentHashMap<String, SIPServerTransaction> serverTransactionTable;
    private ConcurrentHashMap<String, SIPServerTransaction> mergeTable;
    private ConcurrentHashMap<String,SIPServerTransaction> terminatedServerTransactionsPendingAck;
    private ConcurrentHashMap<String,SIPClientTransaction> forkedClientTransactionTable;
    private StackLogger stackLogger;
    protected ServerLogger serverLogger;
    boolean udpFlag;
    protected DefaultRouter defaultRouter;
    protected boolean needsLogging;
    private boolean non2XXAckPassedToListener;
    protected IOHandler ioHandler;
    protected boolean toExit;
    protected String stackName;
    protected String stackAddress;
    protected InetAddress stackInetAddress;
    protected StackMessageFactory sipMessageFactory;
    protected javax.sip.address.Router router;
    protected int threadPoolSize;
    protected int maxConnections;
    protected boolean cacheServerConnections;
    protected boolean cacheClientConnections;
    protected boolean useRouterForAll;
    protected int maxContentLength;
    protected int maxMessageSize;
    private Collection<MessageProcessor> messageProcessors;
    protected int readTimeout;
    protected NetworkLayer networkLayer;
    protected String outboundProxy;
    protected String routerPath;
    protected boolean isAutomaticDialogSupportEnabled;
    protected HashSet<String> forkedEvents;
    protected boolean generateTimeStampHeader;
    protected AddressResolver addressResolver;
    protected int maxListenerResponseTime;
    protected boolean rfc2543Supported = true;
    protected ThreadAuditor threadAuditor = new ThreadAuditor();
    protected LogRecordFactory logRecordFactory;
    protected boolean cancelClientTransactionChecked = true;
    protected boolean remoteTagReassignmentAllowed = true;
    protected boolean logStackTraceOnMessageSend = true;
    protected int receiveUdpBufferSize;
    protected int sendUdpBufferSize;
    protected boolean stackDoesCongestionControl = true;
    protected boolean isBackToBackUserAgent = false;
    protected boolean checkBranchId;
    protected boolean isAutomaticDialogErrorHandlingEnabled = true;
    protected boolean isDialogTerminatedEventDeliveredForNullDialog = false;
    protected int maxForkTime = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.946 -0400", hash_original_method = "58A99E16B05D3536C850145BF176F1CB", hash_generated_method = "FA0D4D68123D5EEA9C301047E8953D3C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected SIPTransactionStack() {
        this.toExit = false;
        this.forkedEvents = new HashSet<String>();
        this.threadPoolSize = -1;
        this.cacheServerConnections = true;
        this.cacheClientConnections = true;
        this.maxConnections = -1;
        messageProcessors = new ArrayList<MessageProcessor>();
        this.ioHandler = new IOHandler(this);
        this.readTimeout = -1;
        this.maxListenerResponseTime = -1;
        this.addressResolver = new DefaultAddressResolver();
        this.dialogTable = new ConcurrentHashMap<String, SIPDialog>();
        this.earlyDialogTable = new ConcurrentHashMap<String, SIPDialog>();
        clientTransactionTable = new ConcurrentHashMap<String, SIPClientTransaction>();
        serverTransactionTable = new ConcurrentHashMap<String, SIPServerTransaction>();
        this.terminatedServerTransactionsPendingAck = new ConcurrentHashMap<String, SIPServerTransaction>();
        mergeTable = new ConcurrentHashMap<String, SIPServerTransaction>();
        retransmissionAlertTransactions = new ConcurrentHashMap<String, SIPServerTransaction>();
        this.timer = new Timer();
        this.pendingTransactions = new ConcurrentHashMap<String, SIPServerTransaction>();
        this.forkedClientTransactionTable = new ConcurrentHashMap<String,SIPClientTransaction>();
        {
            boolean var4926B8FB396A99BDD38AA02CC358790B_351617208 = (getThreadAuditor().isEnabled());
            {
                timer.schedule(new PingTimer(null), 0);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.946 -0400", hash_original_method = "A949ED7F371D2CEC2724714D98F74A81", hash_generated_method = "8FE665F17084FF6036A4658E4013C878")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected SIPTransactionStack(StackMessageFactory messageFactory) {
        this();
        dsTaint.addTaint(messageFactory.dsTaint);
        // ---------- Original Method ----------
        //this.sipMessageFactory = messageFactory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.946 -0400", hash_original_method = "4C95AA981C09EEAD5B31E73DC1384B23", hash_generated_method = "F8ED923AF32A5786F058945282F1E6F7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void reInit() {
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_1384174124 = (stackLogger.isLoggingEnabled());
            stackLogger.logDebug("Re-initializing !");
        } //End collapsed parenthetic
        messageProcessors = new ArrayList<MessageProcessor>();
        this.ioHandler = new IOHandler(this);
        pendingTransactions = new ConcurrentHashMap<String, SIPServerTransaction>();
        clientTransactionTable = new ConcurrentHashMap<String, SIPClientTransaction>();
        serverTransactionTable = new ConcurrentHashMap<String, SIPServerTransaction>();
        retransmissionAlertTransactions = new ConcurrentHashMap<String, SIPServerTransaction>();
        mergeTable = new ConcurrentHashMap<String, SIPServerTransaction>();
        this.dialogTable = new ConcurrentHashMap<String, SIPDialog>();
        this.earlyDialogTable = new ConcurrentHashMap<String, SIPDialog>();
        this.terminatedServerTransactionsPendingAck = new ConcurrentHashMap<String,SIPServerTransaction>();
        this.forkedClientTransactionTable = new ConcurrentHashMap<String,SIPClientTransaction>();
        this.timer = new Timer();
        this.activeClientTransactionCount = new AtomicInteger(0);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.947 -0400", hash_original_method = "5E8E9B567A338F9125BE752CD1B53E0E", hash_generated_method = "11A2E313C3771BC51E0EB78581D3C2B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SocketAddress obtainLocalAddress(InetAddress dst, int dstPort,
                    InetAddress localAddress, int localPort) throws IOException {
        dsTaint.addTaint(localAddress.dsTaint);
        dsTaint.addTaint(dstPort);
        dsTaint.addTaint(localPort);
        dsTaint.addTaint(dst.dsTaint);
        SocketAddress var0815045FEAD7D5A52B1A6D79D18F49D6_1266665590 = (this.ioHandler.obtainLocalAddress(
                        dst, dstPort, localAddress, localPort));
        return (SocketAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.ioHandler.obtainLocalAddress(
                        //dst, dstPort, localAddress, localPort);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.947 -0400", hash_original_method = "6F4F1101C93AB1BC6C07B08D53A20694", hash_generated_method = "5AECE98B1061B15974070DD2B205769A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void disableLogging() {
        this.getStackLogger().disableLogging();
        // ---------- Original Method ----------
        //this.getStackLogger().disableLogging();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.947 -0400", hash_original_method = "28B9C3C3AF577CC75DD224D050447CF4", hash_generated_method = "DD4A6695D325CC79611C0DADF7845085")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void enableLogging() {
        this.getStackLogger().enableLogging();
        // ---------- Original Method ----------
        //this.getStackLogger().enableLogging();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.947 -0400", hash_original_method = "F0A4CF0EC627D6BB4B7444677CFA585E", hash_generated_method = "416C24DC95CD5F4A9F3008CFBE95FBCC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void printDialogTable() {
        {
            boolean var53869E3A88D96F4415B2EAEAC904AA86_581070830 = (isLoggingEnabled());
            {
                this.getStackLogger().logDebug("dialog table  = " + this.dialogTable);
                System.out.println("dialog table = " + this.dialogTable);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isLoggingEnabled()) {
            //this.getStackLogger().logDebug("dialog table  = " + this.dialogTable);
            //System.out.println("dialog table = " + this.dialogTable);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.947 -0400", hash_original_method = "A39FC22DA230CCE4243CA37C766915B4", hash_generated_method = "8A19943529079E10FF0B2A4DCFE0EC36")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPServerTransaction getRetransmissionAlertTransaction(String dialogId) {
        dsTaint.addTaint(dialogId);
        SIPServerTransaction var647E000CC98D603BEFCFCFC5743E38F5_970998264 = ((SIPServerTransaction) this.retransmissionAlertTransactions.get(dialogId));
        return (SIPServerTransaction)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (SIPServerTransaction) this.retransmissionAlertTransactions.get(dialogId);
    }

    
        public static boolean isDialogCreated(String method) {
        return dialogCreatingMethods.contains(method);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.948 -0400", hash_original_method = "BEE1BC405D1C6F3176E5E5958D511DC6", hash_generated_method = "862910FCB7460A8E4FC401689236FE26")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addExtensionMethod(String extensionMethod) {
        dsTaint.addTaint(extensionMethod);
        {
            boolean varAD3BC2900BC07B79F07970DF4CB3E3F0_1553852275 = (extensionMethod.equals(Request.NOTIFY));
            {
                {
                    boolean varAC370D5D69DCACC466AEF155D6729732_351126190 = (stackLogger.isLoggingEnabled());
                    stackLogger.logDebug("NOTIFY Supported Natively");
                } //End collapsed parenthetic
            } //End block
            {
                dialogCreatingMethods.add(extensionMethod.trim().toUpperCase());
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (extensionMethod.equals(Request.NOTIFY)) {
            //if (stackLogger.isLoggingEnabled())
                //stackLogger.logDebug("NOTIFY Supported Natively");
        //} else {
            //dialogCreatingMethods.add(extensionMethod.trim().toUpperCase());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.948 -0400", hash_original_method = "3AD47119D9E3B66FC61FF1D5407F3E89", hash_generated_method = "F57D7432F93073A376BDFC909848035B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void putDialog(SIPDialog dialog) {
        dsTaint.addTaint(dialog.dsTaint);
        String dialogId;
        dialogId = dialog.getDialogId();
        {
            boolean var1C796C75795040E4DB7CADAEB51198DB_171949885 = (dialogTable.containsKey(dialogId));
            {
                {
                    boolean varAC370D5D69DCACC466AEF155D6729732_1899757799 = (stackLogger.isLoggingEnabled());
                    {
                        stackLogger.logDebug("putDialog: dialog already exists" + dialogId + " in table = "
                        + dialogTable.get(dialogId));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_2129228219 = (stackLogger.isLoggingEnabled());
            {
                stackLogger.logDebug("putDialog dialogId=" + dialogId + " dialog = " + dialog);
            } //End block
        } //End collapsed parenthetic
        dialog.setStack(this);
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_804442533 = (stackLogger.isLoggingEnabled());
            stackLogger.logStackTrace();
        } //End collapsed parenthetic
        dialogTable.put(dialogId, dialog);
        // ---------- Original Method ----------
        //String dialogId = dialog.getDialogId();
        //if (dialogTable.containsKey(dialogId)) {
            //if (stackLogger.isLoggingEnabled()) {
                //stackLogger.logDebug("putDialog: dialog already exists" + dialogId + " in table = "
                        //+ dialogTable.get(dialogId));
            //}
            //return;
        //}
        //if (stackLogger.isLoggingEnabled()) {
            //stackLogger.logDebug("putDialog dialogId=" + dialogId + " dialog = " + dialog);
        //}
        //dialog.setStack(this);
        //if (stackLogger.isLoggingEnabled())
            //stackLogger.logStackTrace();
        //dialogTable.put(dialogId, dialog);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.949 -0400", hash_original_method = "E7A6CF8B50F165B49D6E8637D9CBF9BD", hash_generated_method = "7B26BED693B9178911529CAE506DA47D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPDialog createDialog(SIPTransaction transaction) {
        dsTaint.addTaint(transaction.dsTaint);
        SIPDialog retval;
        retval = null;
        {
            String dialogId;
            dialogId = ((SIPRequest) transaction.getRequest()).getDialogId(false);
            {
                boolean var9131AA4695C2C63B631C355FB2D06559_1949547264 = (this.earlyDialogTable.get(dialogId) != null);
                {
                    SIPDialog dialog;
                    dialog = this.earlyDialogTable.get(dialogId);
                    {
                        boolean var402523BFFAD41D51F96075592CB2DE30_1405224660 = (dialog.getState() == null || dialog.getState() == DialogState.EARLY);
                        {
                            retval = dialog;
                        } //End block
                        {
                            retval = new SIPDialog(transaction);
                            this.earlyDialogTable.put(dialogId, retval);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    retval = new SIPDialog(transaction);
                    this.earlyDialogTable.put(dialogId, retval);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            retval = new SIPDialog(transaction);
        } //End block
        return (SIPDialog)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.949 -0400", hash_original_method = "077BDE7287D2ACDD7F2A84D6156CB0F7", hash_generated_method = "3131096B8D452560CD49A459E2640EA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPDialog createDialog(SIPClientTransaction transaction, SIPResponse sipResponse) {
        dsTaint.addTaint(transaction.dsTaint);
        dsTaint.addTaint(sipResponse.dsTaint);
        String dialogId;
        dialogId = ((SIPRequest) transaction.getRequest()).getDialogId(false);
        SIPDialog retval;
        retval = null;
        {
            boolean var4AD019C6981F78972549CB283CBD152C_1225072471 = (this.earlyDialogTable.get(dialogId) != null);
            {
                retval = this.earlyDialogTable.get(dialogId);
                {
                    boolean varE9352942E72C1D75CE5290CFFD4E7B6C_344300973 = (sipResponse.isFinalResponse());
                    {
                        this.earlyDialogTable.remove(dialogId);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                retval = new SIPDialog(transaction, sipResponse);
            } //End block
        } //End collapsed parenthetic
        return (SIPDialog)dsTaint.getTaint();
        // ---------- Original Method ----------
        //String dialogId = ((SIPRequest) transaction.getRequest()).getDialogId(false);
        //SIPDialog retval = null;
        //if (this.earlyDialogTable.get(dialogId) != null) {
            //retval = this.earlyDialogTable.get(dialogId);
            //if (sipResponse.isFinalResponse()) {
                //this.earlyDialogTable.remove(dialogId);
            //}
        //} else {
            //retval = new SIPDialog(transaction, sipResponse);
        //}
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.949 -0400", hash_original_method = "C8019EE35E2246E727D64B4FEC692BA7", hash_generated_method = "626BAB0CFE7B881C278E58AE72E36528")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPDialog createDialog(SipProviderImpl sipProvider,
			SIPResponse sipResponse) {
        dsTaint.addTaint(sipProvider.dsTaint);
        dsTaint.addTaint(sipResponse.dsTaint);
        SIPDialog var4B7EF55982FF82403CA5B6223923FA70_31990003 = (new SIPDialog(sipProvider, sipResponse));
        return (SIPDialog)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new SIPDialog(sipProvider, sipResponse);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.950 -0400", hash_original_method = "C20BEEC896962D7D1856EB72C0C34791", hash_generated_method = "49F880D07BF803CAA375B3D58254B991")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeDialog(SIPDialog dialog) {
        dsTaint.addTaint(dialog.dsTaint);
        String id;
        id = dialog.getDialogId();
        String earlyId;
        earlyId = dialog.getEarlyDialogId();
        {
            this.earlyDialogTable.remove(earlyId);
            this.dialogTable.remove(earlyId);
        } //End block
        {
            Object old;
            old = this.dialogTable.get(id);
            {
                this.dialogTable.remove(id);
            } //End block
            {
                boolean var35096A2446A1B79EB944A5339DDF5D2F_1613618827 = (!dialog.testAndSetIsDialogTerminatedEventDelivered());
                {
                    DialogTerminatedEvent event;
                    event = new DialogTerminatedEvent(dialog.getSipProvider(),
                        dialog);
                    dialog.getSipProvider().handleEvent(event, null);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean var35096A2446A1B79EB944A5339DDF5D2F_1716008377 = (!dialog.testAndSetIsDialogTerminatedEventDelivered());
                {
                    DialogTerminatedEvent event;
                    event = new DialogTerminatedEvent(dialog.getSipProvider(),
                        dialog);
                    dialog.getSipProvider().handleEvent(event, null);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.950 -0400", hash_original_method = "7CD5A4CB12647D3BBBFDC040A2B5E183", hash_generated_method = "DC8EDC33A0EDD727FB43F2B3CFFB604F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPDialog getDialog(String dialogId) {
        dsTaint.addTaint(dialogId);
        SIPDialog sipDialog;
        sipDialog = (SIPDialog) dialogTable.get(dialogId);
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_1897551548 = (stackLogger.isLoggingEnabled());
            {
                stackLogger.logDebug("getDialog(" + dialogId + ") : returning " + sipDialog);
            } //End block
        } //End collapsed parenthetic
        return (SIPDialog)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SIPDialog sipDialog = (SIPDialog) dialogTable.get(dialogId);
        //if (stackLogger.isLoggingEnabled()) {
            //stackLogger.logDebug("getDialog(" + dialogId + ") : returning " + sipDialog);
        //}
        //return sipDialog;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.950 -0400", hash_original_method = "B0D51307A4FC266FC1D02389AEE54D05", hash_generated_method = "869BBA84FAA9F17D3E70DB7521E7367D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeDialog(String dialogId) {
        dsTaint.addTaint(dialogId);
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_518574271 = (stackLogger.isLoggingEnabled());
            {
                stackLogger.logWarning("Silently removing dialog from table");
            } //End block
        } //End collapsed parenthetic
        dialogTable.remove(dialogId);
        // ---------- Original Method ----------
        //if (stackLogger.isLoggingEnabled()) {
            //stackLogger.logWarning("Silently removing dialog from table");
        //}
        //dialogTable.remove(dialogId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.951 -0400", hash_original_method = "5BA8167D6AC26A2C080E0DF071E238DD", hash_generated_method = "A9C194FFD1F6B189E243BB4A64A8EAA0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPClientTransaction findSubscribeTransaction(SIPRequest notifyMessage,
            ListeningPointImpl listeningPoint) {
        dsTaint.addTaint(notifyMessage.dsTaint);
        dsTaint.addTaint(listeningPoint.dsTaint);
        SIPClientTransaction retval;
        retval = null;
        try 
        {
            Iterator it;
            it = clientTransactionTable.values().iterator();
            {
                boolean varCEA0B8AAFFB6C70BF01D444180FAAB1F_580770884 = (stackLogger.isLoggingEnabled());
                stackLogger.logDebug("ct table size = " + clientTransactionTable.size());
            } //End collapsed parenthetic
            String thisToTag;
            thisToTag = notifyMessage.getTo().getTag();
            Event eventHdr;
            eventHdr = (Event) notifyMessage.getHeader(EventHeader.NAME);
            {
                {
                    boolean varAC370D5D69DCACC466AEF155D6729732_992674231 = (stackLogger.isLoggingEnabled());
                    {
                        stackLogger.logDebug("event Header is null -- returning null");
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_949435265 = (it.hasNext());
                {
                    SIPClientTransaction ct;
                    ct = (SIPClientTransaction) it.next();
                    {
                        boolean varCFF1A0705DCC3B6E112E467A6D493F5D_443832619 = (!ct.getMethod().equals(Request.SUBSCRIBE));
                    } //End collapsed parenthetic
                    String fromTag;
                    fromTag = ct.from.getTag();
                    Event hisEvent;
                    hisEvent = ct.event;
                    {
                        boolean varD2993363F7AFB86CA04E191D1274040B_1239213753 = (stackLogger.isLoggingEnabled());
                        {
                            stackLogger.logDebug("ct.fromTag = " + fromTag);
                            stackLogger.logDebug("thisToTag = " + thisToTag);
                            stackLogger.logDebug("hisEvent = " + hisEvent);
                            stackLogger.logDebug("eventHdr " + eventHdr);
                        } //End block
                    } //End collapsed parenthetic
                    {
                        boolean var6ED9F094D5E7B37CADC33B9F7291C0D3_302439939 = (fromTag.equalsIgnoreCase(thisToTag)
                      && hisEvent != null
                      && eventHdr.match(hisEvent)
                      && notifyMessage.getCallId().getCallId().equalsIgnoreCase(
                                ct.callId.getCallId()));
                        {
                            {
                                boolean var9282859C10B3BDA9643C67160A68D9EE_1858123039 = (ct.acquireSem());
                                retval = ct;
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            {
                boolean varCEA0B8AAFFB6C70BF01D444180FAAB1F_680996767 = (stackLogger.isLoggingEnabled());
                stackLogger.logDebug("findSubscribeTransaction : returning " + retval);
            } //End collapsed parenthetic
        } //End block
        return (SIPClientTransaction)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.951 -0400", hash_original_method = "D49C9B94E89B7FEA3320280273306438", hash_generated_method = "AB33CB21729AB32AD3CA98E8A171E059")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addTransactionPendingAck(SIPServerTransaction serverTransaction) {
        dsTaint.addTaint(serverTransaction.dsTaint);
        String branchId;
        branchId = ((SIPRequest)serverTransaction.getRequest()).getTopmostVia().getBranch();
        {
            this.terminatedServerTransactionsPendingAck.put(branchId, serverTransaction);
        } //End block
        // ---------- Original Method ----------
        //String branchId = ((SIPRequest)serverTransaction.getRequest()).getTopmostVia().getBranch();
        //if ( branchId != null ) {
            //this.terminatedServerTransactionsPendingAck.put(branchId, serverTransaction);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.951 -0400", hash_original_method = "37709198085D538D169FF1DE9D9ADB9C", hash_generated_method = "A69DB10D9E7B549B285F206B7E538135")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPServerTransaction findTransactionPendingAck(SIPRequest ackMessage) {
        dsTaint.addTaint(ackMessage.dsTaint);
        SIPServerTransaction var563B3638D1D3F5858EB4996A00B32D4B_1158284114 = (this.terminatedServerTransactionsPendingAck.get(ackMessage.getTopmostVia().getBranch()));
        return (SIPServerTransaction)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.terminatedServerTransactionsPendingAck.get(ackMessage.getTopmostVia().getBranch());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.951 -0400", hash_original_method = "B481CD0C272F0294325516CB58C4D625", hash_generated_method = "F51D276D35C2609D7E0D3DC527F58B22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean removeTransactionPendingAck(SIPServerTransaction serverTransaction) {
        dsTaint.addTaint(serverTransaction.dsTaint);
        String branchId;
        branchId = ((SIPRequest)serverTransaction.getRequest()).getTopmostVia().getBranch();
        {
            boolean varEBE195BF36968B3D949EA3A425E49317_338579723 = (branchId != null && this.terminatedServerTransactionsPendingAck.containsKey(branchId));
            {
                this.terminatedServerTransactionsPendingAck.remove(branchId);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //String branchId = ((SIPRequest)serverTransaction.getRequest()).getTopmostVia().getBranch();
        //if ( branchId != null && this.terminatedServerTransactionsPendingAck.containsKey(branchId) ) {
            //this.terminatedServerTransactionsPendingAck.remove(branchId);
            //return true;
        //} else {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.952 -0400", hash_original_method = "E118D63661EEDB81E619AEC2D5F479DE", hash_generated_method = "2DC4A0FA3D785051C5BEFBB94DDDBF2D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isTransactionPendingAck(SIPServerTransaction serverTransaction) {
        dsTaint.addTaint(serverTransaction.dsTaint);
        String branchId;
        branchId = ((SIPRequest)serverTransaction.getRequest()).getTopmostVia().getBranch();
        boolean var4577C4FD500FC681BA07DFDB97EB4243_33682088 = (this.terminatedServerTransactionsPendingAck.contains(branchId));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //String branchId = ((SIPRequest)serverTransaction.getRequest()).getTopmostVia().getBranch();
        //return this.terminatedServerTransactionsPendingAck.contains(branchId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.952 -0400", hash_original_method = "CFF098965464555AD1B1F596C34C16A1", hash_generated_method = "0B240B657724A962B672A0759ED9962B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPTransaction findTransaction(SIPMessage sipMessage, boolean isServer) {
        dsTaint.addTaint(sipMessage.dsTaint);
        dsTaint.addTaint(isServer);
        SIPTransaction retval;
        retval = null;
        try 
        {
            {
                Via via;
                via = sipMessage.getTopmostVia();
                {
                    boolean var240DE521E282CF4DDD1501CDC8DEB0BE_1596891690 = (via.getBranch() != null);
                    {
                        String key;
                        key = sipMessage.getTransactionId();
                        retval = (SIPTransaction) serverTransactionTable.get(key);
                        {
                            boolean varDFC91DFB4BB95E42F71B00E05C1AFFB9_197547356 = (stackLogger.isLoggingEnabled());
                            getStackLogger().logDebug(
                                "serverTx: looking for key " + key + " existing="
                                + serverTransactionTable);
                        } //End collapsed parenthetic
                        {
                            boolean var824837A9145CA2EC03C0E877A985B1E6_273463329 = (key.startsWith(SIPConstants.BRANCH_MAGIC_COOKIE_LOWER_CASE));
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                Iterator<SIPServerTransaction> it;
                it = serverTransactionTable.values().iterator();
                {
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_281165915 = (it.hasNext());
                    {
                        SIPServerTransaction sipServerTransaction;
                        sipServerTransaction = (SIPServerTransaction) it.next();
                        {
                            boolean varF6051FB334F93F8949404856131DFA0F_1430270822 = (sipServerTransaction.isMessagePartOfTransaction(sipMessage));
                            {
                                retval = sipServerTransaction;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                Via via;
                via = sipMessage.getTopmostVia();
                {
                    boolean var240DE521E282CF4DDD1501CDC8DEB0BE_57890608 = (via.getBranch() != null);
                    {
                        String key;
                        key = sipMessage.getTransactionId();
                        {
                            boolean varDFC91DFB4BB95E42F71B00E05C1AFFB9_1583685769 = (stackLogger.isLoggingEnabled());
                            getStackLogger().logDebug("clientTx: looking for key " + key);
                        } //End collapsed parenthetic
                        retval = (SIPTransaction) clientTransactionTable.get(key);
                        {
                            boolean var824837A9145CA2EC03C0E877A985B1E6_297735838 = (key.startsWith(SIPConstants.BRANCH_MAGIC_COOKIE_LOWER_CASE));
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                Iterator<SIPClientTransaction> it;
                it = clientTransactionTable.values().iterator();
                {
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_578780285 = (it.hasNext());
                    {
                        SIPClientTransaction clientTransaction;
                        clientTransaction = (SIPClientTransaction) it.next();
                        {
                            boolean var35F8E4FD38F5FA1A650C87F5120892B2_399892439 = (clientTransaction.isMessagePartOfTransaction(sipMessage));
                            {
                                retval = clientTransaction;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        finally 
        {
            {
                boolean varDED775332D522DB4765B6C0D6DAB9C7F_1122513410 = (this.getStackLogger().isLoggingEnabled());
                {
                    this.getStackLogger().logDebug("findTransaction: returning  : " + retval);
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (SIPTransaction)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.953 -0400", hash_original_method = "EBA76BEAE03DA80AC45DCE1E9705412D", hash_generated_method = "7BCC280DA6602B23CB71C6E67EE890FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPTransaction findCancelTransaction(SIPRequest cancelRequest, boolean isServer) {
        dsTaint.addTaint(cancelRequest.dsTaint);
        dsTaint.addTaint(isServer);
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_1528390471 = (stackLogger.isLoggingEnabled());
            {
                stackLogger.logDebug("findCancelTransaction request= \n" + cancelRequest
                    + "\nfindCancelRequest isServer=" + isServer);
            } //End block
        } //End collapsed parenthetic
        {
            Iterator<SIPServerTransaction> li;
            li = this.serverTransactionTable.values().iterator();
            {
                boolean varD1722E42EA3CA8952F93B6521D875E61_601550796 = (li.hasNext());
                {
                    SIPTransaction transaction;
                    transaction = (SIPTransaction) li.next();
                    SIPServerTransaction sipServerTransaction;
                    sipServerTransaction = (SIPServerTransaction) transaction;
                    {
                        boolean var63C9AAE72219DF269358A97F4B9DD737_1123773927 = (sipServerTransaction.doesCancelMatchTransaction(cancelRequest));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            Iterator<SIPClientTransaction> li;
            li = this.clientTransactionTable.values().iterator();
            {
                boolean varD1722E42EA3CA8952F93B6521D875E61_161987883 = (li.hasNext());
                {
                    SIPTransaction transaction;
                    transaction = (SIPTransaction) li.next();
                    SIPClientTransaction sipClientTransaction;
                    sipClientTransaction = (SIPClientTransaction) transaction;
                    {
                        boolean varAEAD15F06F6B78E29169322410091CA1_1689131864 = (sipClientTransaction.doesCancelMatchTransaction(cancelRequest));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_732690494 = (stackLogger.isLoggingEnabled());
            stackLogger.logDebug("Could not find transaction for cancel request");
        } //End collapsed parenthetic
        return (SIPTransaction)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.953 -0400", hash_original_method = "C32886C5E5EF95CE74E82DCEA7E677B6", hash_generated_method = "10AEFE86D05628A8A779B6191B94F4B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPServerTransaction findPendingTransaction(SIPRequest requestReceived) {
        dsTaint.addTaint(requestReceived.dsTaint);
        {
            boolean var11C62F83477FD0505FB5BB12080FBCDA_1586752956 = (this.stackLogger.isLoggingEnabled());
            {
                this.stackLogger.logDebug("looking for pending tx for :"
                    + requestReceived.getTransactionId());
            } //End block
        } //End collapsed parenthetic
        SIPServerTransaction var2613A500E93013A5227C464E9EB80E2B_1403260083 = ((SIPServerTransaction) pendingTransactions.get(requestReceived.getTransactionId()));
        return (SIPServerTransaction)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (this.stackLogger.isLoggingEnabled()) {
            //this.stackLogger.logDebug("looking for pending tx for :"
                    //+ requestReceived.getTransactionId());
        //}
        //return (SIPServerTransaction) pendingTransactions.get(requestReceived.getTransactionId());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.958 -0400", hash_original_method = "DE7BCEF3CEAF7F5E4F7BCE647A148129", hash_generated_method = "F97764E33D2CFA371C8FF6A4B15C4C82")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPServerTransaction findMergedTransaction(SIPRequest sipRequest) {
        dsTaint.addTaint(sipRequest.dsTaint);
        {
            boolean varEB91205F9E3B5AB16C809B69E830E585_849058495 = (! sipRequest.getMethod().equals(Request.INVITE));
        } //End collapsed parenthetic
        String mergeId;
        mergeId = sipRequest.getMergeId();
        SIPServerTransaction mergedTransaction;
        mergedTransaction = (SIPServerTransaction) this.mergeTable.get(mergeId);
        {
            boolean varDD5DC8FFD549FCFBE54C0C4063924793_326124803 = (mergedTransaction != null && !mergedTransaction.isMessagePartOfTransaction(sipRequest));
            {
                {
                    Iterator<Dialog> var13FA49F9AC884432F840638793CBDD7F_1863448595 = (this.dialogTable.values()).iterator();
                    var13FA49F9AC884432F840638793CBDD7F_1863448595.hasNext();
                    Dialog dialog = var13FA49F9AC884432F840638793CBDD7F_1863448595.next();
                    {
                        SIPDialog sipDialog;
                        sipDialog = (SIPDialog) dialog;
                        {
                            boolean varF35A178555525ACF54ED52DD1E0580BB_2095366785 = (sipDialog.getFirstTransaction()  != null && 
                   sipDialog.getFirstTransaction() instanceof ServerTransaction);
                            {
                                SIPServerTransaction serverTransaction;
                                serverTransaction = ((SIPServerTransaction) sipDialog.getFirstTransaction());
                                SIPRequest transactionRequest;
                                transactionRequest = ((SIPServerTransaction) sipDialog.getFirstTransaction()).getOriginalRequest();
                                {
                                    boolean var38302743A39D1C992E94EBEE863951D6_1953605834 = ((! serverTransaction.isMessagePartOfTransaction(sipRequest))
                           && sipRequest.getMergeId().equals(transactionRequest.getMergeId()));
                                    {
                                        SIPServerTransaction var30DD37EAF78B65E47AD389716C23D913_150812675 = ((SIPServerTransaction) sipDialog.getFirstTransaction());
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (SIPServerTransaction)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.958 -0400", hash_original_method = "365415518ECAE79EAD0CD2C9D4462A78", hash_generated_method = "412A4D643DCC1D42A1BA5D7C4F38C1B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removePendingTransaction(SIPServerTransaction tr) {
        dsTaint.addTaint(tr.dsTaint);
        {
            boolean var11C62F83477FD0505FB5BB12080FBCDA_556081561 = (this.stackLogger.isLoggingEnabled());
            {
                this.stackLogger.logDebug("removePendingTx: " + tr.getTransactionId());
            } //End block
        } //End collapsed parenthetic
        this.pendingTransactions.remove(tr.getTransactionId());
        // ---------- Original Method ----------
        //if (this.stackLogger.isLoggingEnabled()) {
            //this.stackLogger.logDebug("removePendingTx: " + tr.getTransactionId());
        //}
        //this.pendingTransactions.remove(tr.getTransactionId());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.959 -0400", hash_original_method = "DB6ED2CEA840316B4782573C88C3E1FC", hash_generated_method = "C89762F54CAE0076AAFE491FD50BF522")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeFromMergeTable(SIPServerTransaction tr) {
        dsTaint.addTaint(tr.dsTaint);
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_1443644820 = (stackLogger.isLoggingEnabled());
            {
                this.stackLogger.logDebug("Removing tx from merge table ");
            } //End block
        } //End collapsed parenthetic
        String key;
        key = ((SIPRequest) tr.getRequest()).getMergeId();
        {
            this.mergeTable.remove(key);
        } //End block
        // ---------- Original Method ----------
        //if (stackLogger.isLoggingEnabled()) {
            //this.stackLogger.logDebug("Removing tx from merge table ");
        //}
        //String key = ((SIPRequest) tr.getRequest()).getMergeId();
        //if (key != null) {
            //this.mergeTable.remove(key);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.959 -0400", hash_original_method = "4DF3A9A601EFF55EEB4CCC4D0E1A4382", hash_generated_method = "2F9C084E67F1C4CC4EA465275BEF2BE6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void putInMergeTable(SIPServerTransaction sipTransaction, SIPRequest sipRequest) {
        dsTaint.addTaint(sipTransaction.dsTaint);
        dsTaint.addTaint(sipRequest.dsTaint);
        String mergeKey;
        mergeKey = sipRequest.getMergeId();
        {
            this.mergeTable.put(mergeKey, sipTransaction);
        } //End block
        // ---------- Original Method ----------
        //String mergeKey = sipRequest.getMergeId();
        //if (mergeKey != null) {
            //this.mergeTable.put(mergeKey, sipTransaction);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.959 -0400", hash_original_method = "8109166214A5696534573E329912E2B5", hash_generated_method = "787D1289605D8950DC1EABE8065FF089")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void mapTransaction(SIPServerTransaction transaction) {
        dsTaint.addTaint(transaction.dsTaint);
        addTransactionHash(transaction);
        transaction.isMapped = true;
        // ---------- Original Method ----------
        //if (transaction.isMapped)
            //return;
        //addTransactionHash(transaction);
        //transaction.isMapped = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.960 -0400", hash_original_method = "C3F915B9919F99B9388976510DFE400E", hash_generated_method = "9E86EB787388428F95FE02DEECB2C3FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ServerRequestInterface newSIPServerRequest(SIPRequest requestReceived,
            MessageChannel requestMessageChannel) {
        dsTaint.addTaint(requestReceived.dsTaint);
        dsTaint.addTaint(requestMessageChannel.dsTaint);
        Iterator<SIPServerTransaction> transactionIterator;
        SIPServerTransaction nextTransaction;
        SIPServerTransaction currentTransaction;
        String key;
        key = requestReceived.getTransactionId();
        requestReceived.setMessageChannel(requestMessageChannel);
        currentTransaction = (SIPServerTransaction) serverTransactionTable.get(key);
        {
            boolean varD5F22D6501778D69EFB1B4C78D1BC071_1914699092 = (currentTransaction == null
                || !currentTransaction.isMessagePartOfTransaction(requestReceived));
            {
                transactionIterator = serverTransactionTable.values().iterator();
                currentTransaction = null;
                {
                    boolean varDF525999E4178F83F821F7840AF0A701_1172998170 = (!key.toLowerCase().startsWith(SIPConstants.BRANCH_MAGIC_COOKIE_LOWER_CASE));
                    {
                        {
                            boolean varE06F989DC131B262AEF6DA55B8F8DDB2_618504463 = (transactionIterator.hasNext() && currentTransaction == null);
                            {
                                nextTransaction = (SIPServerTransaction) transactionIterator.next();
                                {
                                    boolean var7384431C022BEE094664534666A1D7AF_509714470 = (nextTransaction.isMessagePartOfTransaction(requestReceived));
                                    {
                                        currentTransaction = nextTransaction;
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    currentTransaction = findPendingTransaction(requestReceived);
                    {
                        requestReceived.setTransaction(currentTransaction);
                        {
                            boolean varC390E2A5DFAA4F7FA1689CB7638E2EB7_344694372 = (currentTransaction != null && currentTransaction.acquireSem());
                        } //End collapsed parenthetic
                    } //End block
                    currentTransaction = createServerTransaction(requestMessageChannel);
                    {
                        currentTransaction.setOriginalRequest(requestReceived);
                        requestReceived.setTransaction(currentTransaction);
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_1292598711 = (stackLogger.isLoggingEnabled());
            {
                stackLogger.logDebug("newSIPServerRequest( " + requestReceived.getMethod() + ":"
                    + requestReceived.getTopmostVia().getBranch() + "):" + currentTransaction);
            } //End block
        } //End collapsed parenthetic
        currentTransaction.setRequestInterface(sipMessageFactory.newSIPServerRequest(
                    requestReceived, currentTransaction));
        {
            boolean var0F6C442AF508B1ABAB943F4C4B4ED076_717073172 = (currentTransaction != null && currentTransaction.acquireSem());
            {
                try 
                {
                    {
                        boolean var73C027315BBD0DCC1A552716D2DA9C61_714090479 = (currentTransaction.isMessagePartOfTransaction(requestReceived) &&
                    currentTransaction.getMethod().equals(requestReceived.getMethod()));
                        {
                            SIPResponse trying;
                            trying = requestReceived.createResponse(Response.TRYING);
                            trying.removeContent();
                            currentTransaction.getMessageChannel().sendMessage(trying);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                catch (Exception ex)
                {
                    {
                        boolean var86B7E4A6EFF1453FB71811BCAA5C5B32_2056499202 = (isLoggingEnabled());
                        stackLogger.logError("Exception occured sending TRYING");
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        return (ServerRequestInterface)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.961 -0400", hash_original_method = "62ADB5DE3DAA611F01F5B25EB82A32E9", hash_generated_method = "2F707BC8E66E71E3CBF52E0B25E7D155")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ServerResponseInterface newSIPServerResponse(SIPResponse responseReceived,
            MessageChannel responseMessageChannel) {
        dsTaint.addTaint(responseMessageChannel.dsTaint);
        dsTaint.addTaint(responseReceived.dsTaint);
        Iterator<SIPClientTransaction> transactionIterator;
        SIPClientTransaction nextTransaction;
        SIPClientTransaction currentTransaction;
        String key;
        key = responseReceived.getTransactionId();
        currentTransaction = (SIPClientTransaction) clientTransactionTable.get(key);
        {
            boolean varFD65E86793E7DA9A4559DFCAD3FE7A38_351399496 = (currentTransaction == null
                || (!currentTransaction.isMessagePartOfTransaction(responseReceived) && !key
                        .startsWith(SIPConstants.BRANCH_MAGIC_COOKIE_LOWER_CASE)));
            {
                transactionIterator = clientTransactionTable.values().iterator();
                currentTransaction = null;
                {
                    boolean var02E71BDB7FE3E53290C9D60F6709CA78_2133848019 = (transactionIterator.hasNext() && currentTransaction == null);
                    {
                        nextTransaction = (SIPClientTransaction) transactionIterator.next();
                        {
                            boolean varB7132609472FD4E761BE7525D40545ED_1883191895 = (nextTransaction.isMessagePartOfTransaction(responseReceived));
                            {
                                currentTransaction = nextTransaction;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    {
                        boolean var0954F7596F6CFAF1C1D43DD490BBFB96_1520830094 = (this.stackLogger.isLoggingEnabled(StackLogger.TRACE_INFO));
                        {
                            responseMessageChannel.logResponse(responseReceived, System
                            .currentTimeMillis(), "before processing");
                        } //End block
                    } //End collapsed parenthetic
                    ServerResponseInterface var264817A937B295D22EFFEE15E65A1B82_786773040 = (sipMessageFactory.newSIPServerResponse(responseReceived,
                        responseMessageChannel));
                } //End block
            } //End block
        } //End collapsed parenthetic
        boolean acquired;
        acquired = currentTransaction.acquireSem();
        {
            boolean var052D788439DC89D4EA99379C3615ED1C_688470441 = (this.stackLogger.isLoggingEnabled(StackLogger.TRACE_INFO));
            {
                currentTransaction.logResponse(responseReceived, System.currentTimeMillis(),
                    "before processing");
            } //End block
        } //End collapsed parenthetic
        {
            ServerResponseInterface sri;
            sri = sipMessageFactory.newSIPServerResponse(
                    responseReceived, currentTransaction);
            {
                currentTransaction.setResponseInterface(sri);
            } //End block
            {
                {
                    boolean varB994156BC51EB47795FEDC6186A6DA25_1495771469 = (this.stackLogger.isLoggingEnabled());
                    {
                        this.stackLogger.logDebug("returning null - serverResponseInterface is null!");
                    } //End block
                } //End collapsed parenthetic
                currentTransaction.releaseSem();
            } //End block
        } //End block
        {
            {
                boolean varCEA0B8AAFFB6C70BF01D444180FAAB1F_1142465299 = (stackLogger.isLoggingEnabled());
                this.stackLogger.logDebug("Could not aquire semaphore !!");
            } //End collapsed parenthetic
        } //End block
        return (ServerResponseInterface)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.961 -0400", hash_original_method = "32F3E8827D13E0BAFD4E9DD3BE9CB370", hash_generated_method = "8974C4EE75026FEA69CAD12916C1FE33")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MessageChannel createMessageChannel(SIPRequest request, MessageProcessor mp,
            Hop nextHop) throws IOException {
        dsTaint.addTaint(mp.dsTaint);
        dsTaint.addTaint(request.dsTaint);
        dsTaint.addTaint(nextHop.dsTaint);
        SIPTransaction returnChannel;
        Host targetHost;
        targetHost = new Host();
        targetHost.setHostname(nextHop.getHost());
        HostPort targetHostPort;
        targetHostPort = new HostPort();
        targetHostPort.setHost(targetHost);
        targetHostPort.setPort(nextHop.getPort());
        MessageChannel mc;
        mc = mp.createMessageChannel(targetHostPort);
        returnChannel = createClientTransaction(request, mc);
        ((SIPClientTransaction) returnChannel).setViaPort(nextHop.getPort());
        ((SIPClientTransaction) returnChannel).setViaHost(nextHop.getHost());
        addTransactionHash(returnChannel);
        return (MessageChannel)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SIPTransaction returnChannel;
        //Host targetHost = new Host();
        //targetHost.setHostname(nextHop.getHost());
        //HostPort targetHostPort = new HostPort();
        //targetHostPort.setHost(targetHost);
        //targetHostPort.setPort(nextHop.getPort());
        //MessageChannel mc = mp.createMessageChannel(targetHostPort);
        //if (mc == null)
            //return null;
        //returnChannel = createClientTransaction(request, mc);
        //((SIPClientTransaction) returnChannel).setViaPort(nextHop.getPort());
        //((SIPClientTransaction) returnChannel).setViaHost(nextHop.getHost());
        //addTransactionHash(returnChannel);
        //return returnChannel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.962 -0400", hash_original_method = "912DB48513D0A0D8594B2E782158C138", hash_generated_method = "8F0E8DAEFED4EEDFE74158546D34C8A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPClientTransaction createClientTransaction(SIPRequest sipRequest,
            MessageChannel encapsulatedMessageChannel) {
        dsTaint.addTaint(sipRequest.dsTaint);
        dsTaint.addTaint(encapsulatedMessageChannel.dsTaint);
        SIPClientTransaction ct;
        ct = new SIPClientTransaction(this, encapsulatedMessageChannel);
        ct.setOriginalRequest(sipRequest);
        return (SIPClientTransaction)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SIPClientTransaction ct = new SIPClientTransaction(this, encapsulatedMessageChannel);
        //ct.setOriginalRequest(sipRequest);
        //return ct;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.962 -0400", hash_original_method = "81B760547C7425A938D45D7063876C66", hash_generated_method = "BC8640DA2A611A170E42880A1F6D9055")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPServerTransaction createServerTransaction(MessageChannel encapsulatedMessageChannel) {
        dsTaint.addTaint(encapsulatedMessageChannel.dsTaint);
        {
            SIPServerTransaction varDC6DB0E501F4206AA868B1574245E48B_734931873 = (new SIPServerTransaction(this, encapsulatedMessageChannel));
        } //End block
        {
            float threshold;
            threshold = ((float) (serverTransactionTable.size() - serverTransactionTableLowaterMark))
                    / ((float) (serverTransactionTableHighwaterMark - serverTransactionTableLowaterMark));
            boolean decision;
            decision = Math.random() > 1.0 - threshold;
            {
                SIPServerTransaction var9715CA97FFB0DA17CB15FC77C429376F_1949131148 = (new SIPServerTransaction(this, encapsulatedMessageChannel));
            } //End block
        } //End block
        return (SIPServerTransaction)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (unlimitedServerTransactionTableSize) {                
            //return new SIPServerTransaction(this, encapsulatedMessageChannel);
        //} else {
            //float threshold = ((float) (serverTransactionTable.size() - serverTransactionTableLowaterMark))
                    /// ((float) (serverTransactionTableHighwaterMark - serverTransactionTableLowaterMark));
            //boolean decision = Math.random() > 1.0 - threshold;
            //if (decision) {
                //return null;
            //} else {
                //return new SIPServerTransaction(this, encapsulatedMessageChannel);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.963 -0400", hash_original_method = "2775112CA96E4BBD847FD3F2A14A81DE", hash_generated_method = "3C1507EC80AA067ECE5476699E9BF709")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getClientTransactionTableSize() {
        int var03DB7AB6196DC5D0E9988C142D712431_906983001 = (this.clientTransactionTable.size());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.clientTransactionTable.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.963 -0400", hash_original_method = "4372809DD9897424686B6F4A147D93FA", hash_generated_method = "C0F38B2B4EECF556D25D005FE1C23D56")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getServerTransactionTableSize() {
        int var7FEDB251634EBCF9A56CDDB387AADB7C_1867056590 = (this.serverTransactionTable.size());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.serverTransactionTable.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.964 -0400", hash_original_method = "2F0441D135E4CBEEA76B3CCA00FAD23B", hash_generated_method = "B4A72AF8F076A1324868CE77B64D49AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addTransaction(SIPClientTransaction clientTransaction) {
        dsTaint.addTaint(clientTransaction.dsTaint);
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_2035377115 = (stackLogger.isLoggingEnabled());
            stackLogger.logDebug("added transaction " + clientTransaction);
        } //End collapsed parenthetic
        addTransactionHash(clientTransaction);
        // ---------- Original Method ----------
        //if (stackLogger.isLoggingEnabled())
            //stackLogger.logDebug("added transaction " + clientTransaction);
        //addTransactionHash(clientTransaction);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.964 -0400", hash_original_method = "FC7C0EB4C2CF25B4E39BD000BE1A0318", hash_generated_method = "6B73EF9D0FCF030F171961FF9FD2039A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeTransaction(SIPTransaction sipTransaction) {
        dsTaint.addTaint(sipTransaction.dsTaint);
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_2105316445 = (stackLogger.isLoggingEnabled());
            {
                stackLogger.logDebug("Removing Transaction = " + sipTransaction.getTransactionId()
                    + " transaction = " + sipTransaction);
            } //End block
        } //End collapsed parenthetic
        {
            {
                boolean varCEA0B8AAFFB6C70BF01D444180FAAB1F_1084380430 = (stackLogger.isLoggingEnabled());
                stackLogger.logStackTrace();
            } //End collapsed parenthetic
            String key;
            key = sipTransaction.getTransactionId();
            Object removed;
            removed = serverTransactionTable.remove(key);
            String method;
            method = sipTransaction.getMethod();
            this.removePendingTransaction((SIPServerTransaction) sipTransaction);
            this.removeTransactionPendingAck((SIPServerTransaction) sipTransaction);
            {
                boolean varCD28D341484E6B95D2F46E243D03836E_1481310737 = (method.equalsIgnoreCase(Request.INVITE));
                {
                    this.removeFromMergeTable((SIPServerTransaction) sipTransaction);
                } //End block
            } //End collapsed parenthetic
            SipProviderImpl sipProvider;
            sipProvider = (SipProviderImpl) sipTransaction.getSipProvider();
            {
                boolean var1213E4480B57552575E83F2F9387B887_1375000844 = (removed != null && sipTransaction.testAndSetTransactionTerminatedEvent());
                {
                    TransactionTerminatedEvent event;
                    event = new TransactionTerminatedEvent(sipProvider,
                        (ServerTransaction) sipTransaction);
                    sipProvider.handleEvent(event, sipTransaction);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            String key;
            key = sipTransaction.getTransactionId();
            Object removed;
            removed = clientTransactionTable.remove(key);
            {
                boolean varCEA0B8AAFFB6C70BF01D444180FAAB1F_1722261087 = (stackLogger.isLoggingEnabled());
                {
                    stackLogger.logDebug("REMOVED client tx " + removed + " KEY = " + key);
                    {
                        SIPClientTransaction clientTx;
                        clientTx = (SIPClientTransaction)removed;
                        {
                            boolean varD1410CA2EC6660EFEAC1856DD8EB1E5A_1230839284 = (clientTx.getMethod().equals(Request.INVITE) && this.maxForkTime != 0);
                            {
                                RemoveForkedTransactionTimerTask ttask;
                                ttask = new RemoveForkedTransactionTimerTask(clientTx);
                                this.timer.schedule(ttask, this.maxForkTime * 1000);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                boolean var1213E4480B57552575E83F2F9387B887_393049137 = (removed != null && sipTransaction.testAndSetTransactionTerminatedEvent());
                {
                    SipProviderImpl sipProvider;
                    sipProvider = (SipProviderImpl) sipTransaction.getSipProvider();
                    TransactionTerminatedEvent event;
                    event = new TransactionTerminatedEvent(sipProvider,
                        (ClientTransaction) sipTransaction);
                    sipProvider.handleEvent(event, sipTransaction);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.965 -0400", hash_original_method = "114E6F44E2106B74A7437814EDE26008", hash_generated_method = "0371D2B2545D84ED258F1733A639E45D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addTransaction(SIPServerTransaction serverTransaction) throws IOException {
        dsTaint.addTaint(serverTransaction.dsTaint);
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_1694557405 = (stackLogger.isLoggingEnabled());
            stackLogger.logDebug("added transaction " + serverTransaction);
        } //End collapsed parenthetic
        serverTransaction.map();
        addTransactionHash(serverTransaction);
        // ---------- Original Method ----------
        //if (stackLogger.isLoggingEnabled())
            //stackLogger.logDebug("added transaction " + serverTransaction);
        //serverTransaction.map();
        //addTransactionHash(serverTransaction);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.965 -0400", hash_original_method = "A02B6100DC58EB921085C7ED44EE1D0C", hash_generated_method = "8036C472AB434B5CDA6DCC3C67E934A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void addTransactionHash(SIPTransaction sipTransaction) {
        dsTaint.addTaint(sipTransaction.dsTaint);
        SIPRequest sipRequest;
        sipRequest = sipTransaction.getOriginalRequest();
        {
            {
                {
                    boolean varD67D9F55A3909BC928BCBD79D887834D_1166630598 = (this.activeClientTransactionCount.get() > clientTransactionTableHiwaterMark);
                    {
                        try 
                        {
                            {
                                this.clientTransactionTable.wait();
                                this.activeClientTransactionCount.incrementAndGet();
                            } //End block
                        } //End block
                        catch (Exception ex)
                        {
                            {
                                boolean var337B2A9C9EA2BB40C001AEDF1FE004ED_1121429771 = (stackLogger.isLoggingEnabled());
                                {
                                    stackLogger.logError("Exception occured while waiting for room", ex);
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                this.activeClientTransactionCount.incrementAndGet();
            } //End block
            String key;
            key = sipRequest.getTransactionId();
            clientTransactionTable.put(key, (SIPClientTransaction) sipTransaction);
            {
                boolean varCEA0B8AAFFB6C70BF01D444180FAAB1F_659780299 = (stackLogger.isLoggingEnabled());
                {
                    stackLogger.logDebug(" putTransactionHash : " + " key = " + key);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            String key;
            key = sipRequest.getTransactionId();
            {
                boolean varCEA0B8AAFFB6C70BF01D444180FAAB1F_1018212433 = (stackLogger.isLoggingEnabled());
                {
                    stackLogger.logDebug(" putTransactionHash : " + " key = " + key);
                } //End block
            } //End collapsed parenthetic
            serverTransactionTable.put(key, (SIPServerTransaction) sipTransaction);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.965 -0400", hash_original_method = "380804F8BD40257E05E5F5A307273856", hash_generated_method = "AA8FE761C3C154AA9671B245D2CC6C72")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void decrementActiveClientTransactionCount() {
        {
            boolean var47ED5E0FC43EE8302B13C023BBB66045_1081024549 = (this.activeClientTransactionCount.decrementAndGet() <= this.clientTransactionTableLowaterMark
                && !this.unlimitedClientTransactionTableSize);
            {
                {
                    clientTransactionTable.notify();
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (this.activeClientTransactionCount.decrementAndGet() <= this.clientTransactionTableLowaterMark
                //&& !this.unlimitedClientTransactionTableSize) {
            //synchronized (this.clientTransactionTable) {
                //clientTransactionTable.notify();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.966 -0400", hash_original_method = "BBF1530237A94448CCB60A02BEEFAB6C", hash_generated_method = "FA16874B079F327AFD0ECBAFA1A31C65")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void removeTransactionHash(SIPTransaction sipTransaction) {
        dsTaint.addTaint(sipTransaction.dsTaint);
        SIPRequest sipRequest;
        sipRequest = sipTransaction.getOriginalRequest();
        {
            String key;
            key = sipTransaction.getTransactionId();
            {
                boolean varCEA0B8AAFFB6C70BF01D444180FAAB1F_1033859743 = (stackLogger.isLoggingEnabled());
                {
                    stackLogger.logStackTrace();
                    stackLogger.logDebug("removing client Tx : " + key);
                } //End block
            } //End collapsed parenthetic
            clientTransactionTable.remove(key);
        } //End block
        {
            String key;
            key = sipTransaction.getTransactionId();
            serverTransactionTable.remove(key);
            {
                boolean varCEA0B8AAFFB6C70BF01D444180FAAB1F_1058346218 = (stackLogger.isLoggingEnabled());
                {
                    stackLogger.logDebug("removing server Tx : " + key);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //SIPRequest sipRequest = sipTransaction.getOriginalRequest();
        //if (sipRequest == null)
            //return;
        //if (sipTransaction instanceof SIPClientTransaction) {
            //String key = sipTransaction.getTransactionId();
            //if (stackLogger.isLoggingEnabled()) {
                //stackLogger.logStackTrace();
                //stackLogger.logDebug("removing client Tx : " + key);
            //}
            //clientTransactionTable.remove(key);
        //} else if (sipTransaction instanceof SIPServerTransaction) {
            //String key = sipTransaction.getTransactionId();
            //serverTransactionTable.remove(key);
            //if (stackLogger.isLoggingEnabled()) {
                //stackLogger.logDebug("removing server Tx : " + key);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.966 -0400", hash_original_method = "DE85950924139BCA289E1B65627F95C2", hash_generated_method = "ACFB7FCE39E58DE33C4FDE7D0E2F0DBD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void transactionErrorEvent(SIPTransactionErrorEvent transactionErrorEvent) {
        dsTaint.addTaint(transactionErrorEvent.dsTaint);
        SIPTransaction transaction;
        transaction = (SIPTransaction) transactionErrorEvent.getSource();
        {
            boolean varEB5679C18C9B12FA2BAE5A757A24F70B_1374990737 = (transactionErrorEvent.getErrorID() == SIPTransactionErrorEvent.TRANSPORT_ERROR);
            {
                transaction.setState(SIPTransaction.TERMINATED_STATE);
                {
                    ((SIPServerTransaction) transaction).collectionTime = 0;
                } //End block
                transaction.disableTimeoutTimer();
                transaction.disableRetransmissionTimer();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //SIPTransaction transaction = (SIPTransaction) transactionErrorEvent.getSource();
        //if (transactionErrorEvent.getErrorID() == SIPTransactionErrorEvent.TRANSPORT_ERROR) {
            //transaction.setState(SIPTransaction.TERMINATED_STATE);
            //if (transaction instanceof SIPServerTransaction) {
                //((SIPServerTransaction) transaction).collectionTime = 0;
            //}
            //transaction.disableTimeoutTimer();
            //transaction.disableRetransmissionTimer();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.966 -0400", hash_original_method = "2DBBC23B1910A8BC0C385035C3D36387", hash_generated_method = "745224129234A499D2FA2F2EBB765C33")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void dialogErrorEvent(SIPDialogErrorEvent dialogErrorEvent) {
        dsTaint.addTaint(dialogErrorEvent.dsTaint);
        SIPDialog sipDialog;
        sipDialog = (SIPDialog) dialogErrorEvent.getSource();
        SipListener sipListener;
        sipListener = ((SipStackImpl)this).getSipListener();
        {
            sipDialog.delete();
        } //End block
        // ---------- Original Method ----------
        //SIPDialog sipDialog = (SIPDialog) dialogErrorEvent.getSource();
        //SipListener sipListener = ((SipStackImpl)this).getSipListener();
        //if(sipDialog != null && !(sipListener instanceof SipListenerExt)) {
        	//sipDialog.delete();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.967 -0400", hash_original_method = "EC17AB4FB84DCA37B1579E7D41B287E3", hash_generated_method = "9CC20F4C67CFE462583CF06525632DFA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void stopStack() {
        this.timer.cancel();
        timer = null;
        this.pendingTransactions.clear();
        this.toExit = true;
        {
            this.notifyAll();
        } //End block
        {
            clientTransactionTable.notifyAll();
        } //End block
        {
            MessageProcessor[] processorList;
            processorList = getMessageProcessors();
            {
                int processorIndex;
                processorIndex = 0;
                {
                    removeMessageProcessor(processorList[processorIndex]);
                } //End block
            } //End collapsed parenthetic
            this.ioHandler.closeAll();
        } //End block
        try 
        {
            Thread.sleep(1000);
        } //End block
        catch (InterruptedException ex)
        { }
        this.clientTransactionTable.clear();
        this.serverTransactionTable.clear();
        this.dialogTable.clear();
        this.serverLogger.closeLogFile();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.967 -0400", hash_original_method = "CEE88C8969112A140A79BE7502F1A5FB", hash_generated_method = "5491A1F131B4F61D690F21A8375FE121")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void putPendingTransaction(SIPServerTransaction tr) {
        dsTaint.addTaint(tr.dsTaint);
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_597353623 = (stackLogger.isLoggingEnabled());
            stackLogger.logDebug("putPendingTransaction: " + tr);
        } //End collapsed parenthetic
        this.pendingTransactions.put(tr.getTransactionId(), tr);
        // ---------- Original Method ----------
        //if (stackLogger.isLoggingEnabled())
            //stackLogger.logDebug("putPendingTransaction: " + tr);
        //this.pendingTransactions.put(tr.getTransactionId(), tr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.967 -0400", hash_original_method = "A3344B5915DA0C5B05591E12A62D4610", hash_generated_method = "6E1026F11A0D2EEB563250748299E11C")
    @DSModeled(DSC.SAFE)
    public NetworkLayer getNetworkLayer() {
        return (NetworkLayer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (networkLayer == null) {
            //return DefaultNetworkLayer.SINGLETON;
        //} else {
            //return networkLayer;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.967 -0400", hash_original_method = "47BDB9F0F1E73BBB0BEBE9D5C68FE123", hash_generated_method = "E502D0DEFF072F4B7022BA01A3D35908")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isLoggingEnabled() {
        {
            Object var11C62F83477FD0505FB5BB12080FBCDA_1462888131 = (this.stackLogger.isLoggingEnabled());
        } //End flattened ternary
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.stackLogger == null ? false : this.stackLogger.isLoggingEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.968 -0400", hash_original_method = "ACBC713DDCF210EE591047F9A9A515DC", hash_generated_method = "6D99F8977317B8746FA596F076448E45")
    @DSModeled(DSC.SAFE)
    public StackLogger getStackLogger() {
        return (StackLogger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.stackLogger;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.968 -0400", hash_original_method = "01705032DE3FE074C7E055A3A8A4FEE3", hash_generated_method = "A5C3E60843CDA02F942DDD4D5E001EDA")
    @DSModeled(DSC.SAFE)
    public ServerLogger getServerLogger() {
        return (ServerLogger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.serverLogger;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.968 -0400", hash_original_method = "9DA0FD5646924F30F0B4568C00D20E6E", hash_generated_method = "32A6EAB0BE021F0CFEC587089749F3E3")
    @DSModeled(DSC.SAFE)
    public int getMaxMessageSize() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.maxMessageSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.968 -0400", hash_original_method = "F7820D79676ABCB839F961B1893B47B1", hash_generated_method = "EA170E890B9C35B538B5CB86A786F5AF")
    @DSModeled(DSC.SAFE)
    public void setSingleThreaded() {
        this.threadPoolSize = 1;
        // ---------- Original Method ----------
        //this.threadPoolSize = 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.968 -0400", hash_original_method = "E9690233252AAFA4C640E8F4D35D05EB", hash_generated_method = "56C7106B1D217231D099A8C4600D7852")
    @DSModeled(DSC.SAFE)
    public void setThreadPoolSize(int size) {
        dsTaint.addTaint(size);
        // ---------- Original Method ----------
        //this.threadPoolSize = size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.968 -0400", hash_original_method = "71AE725926CCD09A123AE8B2DA17A3F2", hash_generated_method = "9F0B73EEEF6940AB5666D7632C40E7F8")
    @DSModeled(DSC.SAFE)
    public void setMaxConnections(int nconnections) {
        dsTaint.addTaint(nconnections);
        // ---------- Original Method ----------
        //this.maxConnections = nconnections;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.969 -0400", hash_original_method = "48A74B192606F2E929FFF01B3041CF91", hash_generated_method = "E3B7FDAD5F0186CE8269041EF3C5AF83")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Hop getNextHop(SIPRequest sipRequest) throws SipException {
        dsTaint.addTaint(sipRequest.dsTaint);
        {
            Hop var74194ADB14B17F8E37075513BBC3586A_20617686 = (router.getNextHop(sipRequest));
        } //End block
        {
            {
                boolean varCB9DA79D6FC6DC73F34AC1A9AEB77BE2_315819602 = (sipRequest.getRequestURI().isSipURI() || sipRequest.getRouteHeaders() != null);
                {
                    Hop varFED8FE0D02DD2836DF0BA7ABE55AE44A_762419818 = (defaultRouter.getNextHop(sipRequest));
                } //End block
                {
                    Hop var589EA62FB399DAABB3CF204854B8B610_1715160867 = (router.getNextHop(sipRequest));
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (Hop)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (this.useRouterForAll) {
            //if (router != null)
                //return router.getNextHop(sipRequest);
            //else
                //return null;
        //} else {
            //if (sipRequest.getRequestURI().isSipURI() || sipRequest.getRouteHeaders() != null) {
                //return defaultRouter.getNextHop(sipRequest);
            //} else if (router != null) {
                //return router.getNextHop(sipRequest);
            //} else
                //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.969 -0400", hash_original_method = "F49E7F0B68A71227FAAC90E58DC1BBF8", hash_generated_method = "CD1847AD92016EFED7C1F56D08183737")
    @DSModeled(DSC.SAFE)
    public void setStackName(String stackName) {
        dsTaint.addTaint(stackName);
        // ---------- Original Method ----------
        //this.stackName = stackName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.969 -0400", hash_original_method = "A8237A45131D19EE871BFED3E7A5AA19", hash_generated_method = "B83820C2049AD09AF78769E7B8574541")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void setHostAddress(String stackAddress) throws UnknownHostException {
        dsTaint.addTaint(stackAddress);
        {
            boolean var88033752B93C1832F0A794C7B736EEF6_1960760760 = (stackAddress.indexOf(':') != stackAddress.lastIndexOf(':')
                && stackAddress.trim().charAt(0) != '[');
            this.stackAddress = '[' + stackAddress + ']';
        } //End collapsed parenthetic
        this.stackInetAddress = InetAddress.getByName(stackAddress);
        // ---------- Original Method ----------
        //if (stackAddress.indexOf(':') != stackAddress.lastIndexOf(':')
                //&& stackAddress.trim().charAt(0) != '[')
            //this.stackAddress = '[' + stackAddress + ']';
        //else
            //this.stackAddress = stackAddress;
        //this.stackInetAddress = InetAddress.getByName(stackAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.969 -0400", hash_original_method = "54480DAD55477A9080CEE058FAAB32DE", hash_generated_method = "F89F963923001D6BCA40648BB8167E0B")
    @DSModeled(DSC.SAFE)
    public String getHostAddress() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.stackAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.969 -0400", hash_original_method = "76950F41C787A5DB271675B8BBBB662A", hash_generated_method = "A731821818F295E91617C32B682E1479")
    @DSModeled(DSC.SAFE)
    protected void setRouter(Router router) {
        dsTaint.addTaint(router.dsTaint);
        // ---------- Original Method ----------
        //this.router = router;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.970 -0400", hash_original_method = "AF384EADB40CF611F4292AFC400A4743", hash_generated_method = "937E687C6EFBBA1535BBB5142DB644AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Router getRouter(SIPRequest request) {
        dsTaint.addTaint(request.dsTaint);
        {
            boolean varF76E09608A8C57E8EC47B53AB21A7904_1270580986 = (request.getRequestLine() == null);
            {
                {
                    boolean varA3564E0CF4A90785E724764B33E54BE1_1635677330 = (request.getRequestURI().getScheme().equals("sip")
                    || request.getRequestURI().getScheme().equals("sips"));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (Router)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (request.getRequestLine() == null) {
            //return this.defaultRouter;
        //} else if (this.useRouterForAll) {
            //return this.router;
        //} else {
            //if (request.getRequestURI().getScheme().equals("sip")
                    //|| request.getRequestURI().getScheme().equals("sips")) {
                //return this.defaultRouter;
            //} else {
                //if (this.router != null)
                    //return this.router;
                //else
                    //return defaultRouter;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.970 -0400", hash_original_method = "A48D8CFCA0D4EF991F0CE4AA0090BC89", hash_generated_method = "A617407500C97ABD1CC72A9549E5AC20")
    @DSModeled(DSC.SAFE)
    public Router getRouter() {
        return (Router)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.router;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.970 -0400", hash_original_method = "DA20B42A9F145510C718334C692F5A76", hash_generated_method = "8CDF1F77D3060024E05E016E90491F36")
    @DSModeled(DSC.SAFE)
    public boolean isAlive() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return !toExit;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.970 -0400", hash_original_method = "A1F941D6CE0FD78BF39EC8F9AC314942", hash_generated_method = "50A9573F1131EE3D0BC8A565E00C333A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void addMessageProcessor(MessageProcessor newMessageProcessor) throws IOException {
        dsTaint.addTaint(newMessageProcessor.dsTaint);
        {
            messageProcessors.add(newMessageProcessor);
        } //End block
        // ---------- Original Method ----------
        //synchronized (messageProcessors) {
            //messageProcessors.add(newMessageProcessor);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.970 -0400", hash_original_method = "CFCCE7E1C39F0D41098F0FE9085A25D2", hash_generated_method = "95E1D2EF7736C8FBA5B938F173E78268")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void removeMessageProcessor(MessageProcessor oldMessageProcessor) {
        dsTaint.addTaint(oldMessageProcessor.dsTaint);
        {
            {
                boolean var7FEC726C44313EDFE272C9262D35B632_100907418 = (messageProcessors.remove(oldMessageProcessor));
                {
                    oldMessageProcessor.stop();
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //synchronized (messageProcessors) {
            //if (messageProcessors.remove(oldMessageProcessor)) {
                //oldMessageProcessor.stop();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.971 -0400", hash_original_method = "B73144BB70E5C3E03C6EB8CA5C201D44", hash_generated_method = "019C59DDD24AC867E44F8F37A0200424")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected MessageProcessor[] getMessageProcessors() {
        {
            MessageProcessor[] var69CD374F678C9A5B9FDE08D49D851136_1082609913 = ((MessageProcessor[]) messageProcessors.toArray(new MessageProcessor[0]));
        } //End block
        return (MessageProcessor[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (messageProcessors) {
            //return (MessageProcessor[]) messageProcessors.toArray(new MessageProcessor[0]);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.971 -0400", hash_original_method = "923CC6809D53E2778E41D61552555A7F", hash_generated_method = "5AA886D1894FBB59C7E8B164DFC5FE01")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected MessageProcessor createMessageProcessor(InetAddress ipAddress, int port,
            String transport) throws java.io.IOException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(transport);
        dsTaint.addTaint(ipAddress.dsTaint);
        {
            boolean var7095C4F355EEA549877FC43E480D2092_301622368 = (transport.equalsIgnoreCase("udp"));
            {
                UDPMessageProcessor udpMessageProcessor;
                udpMessageProcessor = new UDPMessageProcessor(ipAddress, this,
                    port);
                this.addMessageProcessor(udpMessageProcessor);
                this.udpFlag = true;
            } //End block
            {
                boolean var7E17D01330C6FB4587DD37D1ACF5F9C6_1219920370 = (transport.equalsIgnoreCase("tcp"));
                {
                    TCPMessageProcessor tcpMessageProcessor;
                    tcpMessageProcessor = new TCPMessageProcessor(ipAddress, this,
                    port);
                    this.addMessageProcessor(tcpMessageProcessor);
                } //End block
                {
                    boolean var5E363589F0885716BB91FFB4505BC89B_177656859 = (transport.equalsIgnoreCase("tls"));
                    {
                        TLSMessageProcessor tlsMessageProcessor;
                        tlsMessageProcessor = new TLSMessageProcessor(ipAddress, this,
                    port);
                        this.addMessageProcessor(tlsMessageProcessor);
                    } //End block
                    {
                        boolean var11BAA59DFE2974D4AFA5B4D4F65EA219_1304646541 = (transport.equalsIgnoreCase("sctp"));
                        {
                            try 
                            {
                                Class<?> mpc;
                                mpc = ClassLoader.getSystemClassLoader().loadClass( "gov.nist.javax.sip.stack.sctp.SCTPMessageProcessor" );
                                MessageProcessor mp;
                                mp = (MessageProcessor) mpc.newInstance();
                                mp.initialize( ipAddress, port, this );
                                this.addMessageProcessor(mp);
                            } //End block
                            catch (ClassNotFoundException e)
                            {
                                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("SCTP not supported (needs Java 7 and SCTP jar in classpath)");
                            } //End block
                            catch (InstantiationException ie)
                            {
                                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Error initializing SCTP", ie);
                            } //End block
                            catch (IllegalAccessException ie)
                            {
                                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Error initializing SCTP", ie);
                            } //End block
                        } //End block
                        {
                            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("bad transport");
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        return (MessageProcessor)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.971 -0400", hash_original_method = "B67F8BF0F619BF3DA8779F834D136A31", hash_generated_method = "724EF5FD2C380F622104964A9D0BBACE")
    @DSModeled(DSC.SAFE)
    protected void setMessageFactory(StackMessageFactory messageFactory) {
        dsTaint.addTaint(messageFactory.dsTaint);
        // ---------- Original Method ----------
        //this.sipMessageFactory = messageFactory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.972 -0400", hash_original_method = "79BA5457C24B1F2BABB705E59D2E5DE3", hash_generated_method = "14235BCF93AB6EA4A5766A996FB68290")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MessageChannel createRawMessageChannel(String sourceIpAddress, int sourcePort,
            Hop nextHop) throws UnknownHostException {
        dsTaint.addTaint(sourcePort);
        dsTaint.addTaint(nextHop.dsTaint);
        dsTaint.addTaint(sourceIpAddress);
        Host targetHost;
        HostPort targetHostPort;
        Iterator processorIterator;
        MessageProcessor nextProcessor;
        MessageChannel newChannel;
        targetHost = new Host();
        targetHost.setHostname(nextHop.getHost());
        targetHostPort = new HostPort();
        targetHostPort.setHost(targetHost);
        targetHostPort.setPort(nextHop.getPort());
        newChannel = null;
        processorIterator = messageProcessors.iterator();
        {
            boolean var8CF1BBEBBFCBF1DC7D2F0931268CDCC1_1691025025 = (processorIterator.hasNext() && newChannel == null);
            {
                nextProcessor = (MessageProcessor) processorIterator.next();
                {
                    boolean varD30EC259292DB7E4155DAE7A640C45BC_566123485 = (nextHop.getTransport().equalsIgnoreCase(nextProcessor.getTransport())
                    && sourceIpAddress.equals(nextProcessor.getIpAddress().getHostAddress())
                    && sourcePort == nextProcessor.getPort());
                    {
                        try 
                        {
                            newChannel = nextProcessor.createMessageChannel(targetHostPort);
                        } //End block
                        catch (UnknownHostException ex)
                        {
                            {
                                boolean var337B2A9C9EA2BB40C001AEDF1FE004ED_301090033 = (stackLogger.isLoggingEnabled());
                                stackLogger.logException(ex);
                            } //End collapsed parenthetic
                            if (DroidSafeAndroidRuntime.control) throw ex;
                        } //End block
                        catch (IOException e)
                        {
                            {
                                boolean var337B2A9C9EA2BB40C001AEDF1FE004ED_1003281926 = (stackLogger.isLoggingEnabled());
                                stackLogger.logException(e);
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (MessageChannel)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.972 -0400", hash_original_method = "35D04CBE96754834C212489B2C606D95", hash_generated_method = "F5D1A94018BA6586CED86E7FB70989B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isEventForked(String ename) {
        dsTaint.addTaint(ename);
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_1498483821 = (stackLogger.isLoggingEnabled());
            {
                stackLogger.logDebug("isEventForked: " + ename + " returning "
                    + this.forkedEvents.contains(ename));
            } //End block
        } //End collapsed parenthetic
        boolean var0487541C1220D18499AD3CEC1C1D9EAD_304414498 = (this.forkedEvents.contains(ename));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (stackLogger.isLoggingEnabled()) {
            //stackLogger.logDebug("isEventForked: " + ename + " returning "
                    //+ this.forkedEvents.contains(ename));
        //}
        //return this.forkedEvents.contains(ename);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.972 -0400", hash_original_method = "8980F34FD4722FAAB08CBB90B3E36CA2", hash_generated_method = "4BBA6D8789D8E8B09595E998659E30A5")
    @DSModeled(DSC.SAFE)
    public AddressResolver getAddressResolver() {
        return (AddressResolver)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.addressResolver;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.972 -0400", hash_original_method = "3C1DAA52D018FB69E50FF9E6B399590F", hash_generated_method = "CD9867422E2AC1EA971B5005BB47988A")
    @DSModeled(DSC.SAFE)
    public void setAddressResolver(AddressResolver addressResolver) {
        dsTaint.addTaint(addressResolver.dsTaint);
        // ---------- Original Method ----------
        //this.addressResolver = addressResolver;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.972 -0400", hash_original_method = "906B74670BE04C4A719BBC503CD663E5", hash_generated_method = "C761784BE12248E53EE59913F37631B1")
    @DSModeled(DSC.SAFE)
    public void setLogRecordFactory(LogRecordFactory logRecordFactory) {
        dsTaint.addTaint(logRecordFactory.dsTaint);
        // ---------- Original Method ----------
        //this.logRecordFactory = logRecordFactory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.973 -0400", hash_original_method = "2953BF87EC3C3B721F79C36C05ACD684", hash_generated_method = "58F7F8978BE8C48A1706ABDAF714A8CF")
    @DSModeled(DSC.SAFE)
    public ThreadAuditor getThreadAuditor() {
        return (ThreadAuditor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.threadAuditor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.973 -0400", hash_original_method = "DA93EFB6297A5552E15BC0248101E996", hash_generated_method = "BC3F2848852E4F06CE73AB9CB4D6BCAC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String auditStack(Set activeCallIDs, long leakedDialogTimer,
            long leakedTransactionTimer) {
        dsTaint.addTaint(activeCallIDs.dsTaint);
        dsTaint.addTaint(leakedDialogTimer);
        dsTaint.addTaint(leakedTransactionTimer);
        String auditReport;
        auditReport = null;
        String leakedDialogs;
        leakedDialogs = auditDialogs(activeCallIDs, leakedDialogTimer);
        String leakedServerTransactions;
        leakedServerTransactions = auditTransactions(serverTransactionTable,
                leakedTransactionTimer);
        String leakedClientTransactions;
        leakedClientTransactions = auditTransactions(clientTransactionTable,
                leakedTransactionTimer);
        {
            auditReport = "SIP Stack Audit:\n" + (leakedDialogs != null ? leakedDialogs : "")
                    + (leakedServerTransactions != null ? leakedServerTransactions : "")
                    + (leakedClientTransactions != null ? leakedClientTransactions : "");
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String auditReport = null;
        //String leakedDialogs = auditDialogs(activeCallIDs, leakedDialogTimer);
        //String leakedServerTransactions = auditTransactions(serverTransactionTable,
                //leakedTransactionTimer);
        //String leakedClientTransactions = auditTransactions(clientTransactionTable,
                //leakedTransactionTimer);
        //if (leakedDialogs != null || leakedServerTransactions != null
                //|| leakedClientTransactions != null) {
            //auditReport = "SIP Stack Audit:\n" + (leakedDialogs != null ? leakedDialogs : "")
                    //+ (leakedServerTransactions != null ? leakedServerTransactions : "")
                    //+ (leakedClientTransactions != null ? leakedClientTransactions : "");
        //}
        //return auditReport;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.974 -0400", hash_original_method = "5A76CC0B1A3067E5B9DACF3EB61E431C", hash_generated_method = "A9F99273BA22968489144E7CF9996A99")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String auditDialogs(Set activeCallIDs, long leakedDialogTimer) {
        dsTaint.addTaint(activeCallIDs.dsTaint);
        dsTaint.addTaint(leakedDialogTimer);
        String auditReport;
        auditReport = "  Leaked dialogs:\n";
        int leakedDialogs;
        leakedDialogs = 0;
        long currentTime;
        currentTime = System.currentTimeMillis();
        LinkedList dialogs;
        {
            dialogs = new LinkedList(dialogTable.values());
        } //End block
        Iterator it;
        it = dialogs.iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_91278407 = (it.hasNext());
            {
                SIPDialog itDialog;
                itDialog = (SIPDialog) it.next();
                CallIdHeader callIdHeader;
                callIdHeader = (itDialog != null ? itDialog.getCallId() : null);//DSFIXME:  CODE0008: Nested ternary operator in expression
                String callID;
                callID = (callIdHeader != null ? callIdHeader.getCallId() : null);//DSFIXME:  CODE0008: Nested ternary operator in expression
                {
                    boolean varAD81098F41E3735D1602CF3776CF101D_474079508 = (itDialog != null && callID != null && !activeCallIDs.contains(callID));
                    {
                        {
                            itDialog.auditTag = currentTime;
                        } //End block
                        {
                            {
                                DialogState dialogState;
                                dialogState = itDialog.getState();
                                String dialogReport;
                                dialogReport = "dialog id: " + itDialog.getDialogId()
                                + ", dialog state: "
                                + (dialogState != null ? dialogState.toString() : "null");//DSFIXME:  CODE0008: Nested ternary operator in expression
                                auditReport += "    " + dialogReport + "\n";
                                itDialog.setState(SIPDialog.TERMINATED_STATE);
                                {
                                    boolean var85803934B5461ABB2B9ECDE07C3FFDB4_1094165774 = (stackLogger.isLoggingEnabled());
                                    stackLogger.logDebug("auditDialogs: leaked " + dialogReport);
                                } //End collapsed parenthetic
                            } //End block
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            auditReport += "    Total: " + Integer.toString(leakedDialogs)
                    + " leaked dialogs detected and removed.\n";
        } //End block
        {
            auditReport = null;
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.974 -0400", hash_original_method = "B29AC2188DE994EDE68B3EFDD85B41F1", hash_generated_method = "D863F57A979C50954D21C752E19A6127")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String auditTransactions(ConcurrentHashMap transactionsMap,
            long a_nLeakedTransactionTimer) {
        dsTaint.addTaint(a_nLeakedTransactionTimer);
        dsTaint.addTaint(transactionsMap.dsTaint);
        String auditReport;
        auditReport = "  Leaked transactions:\n";
        int leakedTransactions;
        leakedTransactions = 0;
        long currentTime;
        currentTime = System.currentTimeMillis();
        LinkedList transactionsList;
        transactionsList = new LinkedList(transactionsMap.values());
        Iterator it;
        it = transactionsList.iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1767557722 = (it.hasNext());
            {
                SIPTransaction sipTransaction;
                sipTransaction = (SIPTransaction) it.next();
                {
                    {
                        sipTransaction.auditTag = currentTime;
                    } //End block
                    {
                        {
                            TransactionState transactionState;
                            transactionState = sipTransaction.getState();
                            SIPRequest origRequest;
                            origRequest = sipTransaction.getOriginalRequest();
                            String origRequestMethod;
                            origRequestMethod = (origRequest != null ? origRequest.getMethod()
                                : null);//DSFIXME:  CODE0008: Nested ternary operator in expression
                            String transactionReport;
                            transactionReport = sipTransaction.getClass().getName()
                                + ", state: "
                                + (transactionState != null ? transactionState.toString()
                                        : "null") + ", OR: "
                                + (origRequestMethod != null ? origRequestMethod : "null");//DSFIXME:  CODE0008: Nested ternary operator in expression
                            auditReport += "    " + transactionReport + "\n";
                            removeTransaction(sipTransaction);
                            {
                                boolean varECF2FCB00A6D02E8BADBC36FDF09B326_29628809 = (isLoggingEnabled());
                                stackLogger.logDebug("auditTransactions: leaked " + transactionReport);
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            auditReport += "    Total: " + Integer.toString(leakedTransactions)
                    + " leaked transactions detected and removed.\n";
        } //End block
        {
            auditReport = null;
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.974 -0400", hash_original_method = "216776ED7A95FC4D69FC6626B7475336", hash_generated_method = "BACE47F5F2FC7A5F434F1A3F32D02D54")
    @DSModeled(DSC.SAFE)
    public void setNon2XXAckPassedToListener(boolean passToListener) {
        dsTaint.addTaint(passToListener);
        // ---------- Original Method ----------
        //this.non2XXAckPassedToListener = passToListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.975 -0400", hash_original_method = "6286CBBFF5CE6322EC732C5543B43EDA", hash_generated_method = "0927A2FD6EA2EBAA5E968B057CF9C2AB")
    @DSModeled(DSC.SAFE)
    public boolean isNon2XXAckPassedToListener() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return non2XXAckPassedToListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.975 -0400", hash_original_method = "39908A44D12AF4672A8DE059DC86C6F0", hash_generated_method = "3ED745CB905C840412C77C788C8DF520")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getActiveClientTransactionCount() {
        int varF8FC6F0F03532C67FC8EC013C57CAF05_1893355150 = (activeClientTransactionCount.get());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return activeClientTransactionCount.get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.975 -0400", hash_original_method = "2D01936677D6715578D012ACFAF4D8A9", hash_generated_method = "8252417257433CD5E3BFD17D5918D8F8")
    @DSModeled(DSC.SAFE)
    public boolean isRfc2543Supported() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.rfc2543Supported;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.975 -0400", hash_original_method = "71493EE5805AD2AB9A60D51292B7773D", hash_generated_method = "74CB28BDCE48F09A2F0A8CE7819F3FC2")
    @DSModeled(DSC.SAFE)
    public boolean isCancelClientTransactionChecked() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.cancelClientTransactionChecked;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.975 -0400", hash_original_method = "45004C11584D234E2C0351030C5C7691", hash_generated_method = "81FDDFA02716D72A59E6688A9217B1D9")
    @DSModeled(DSC.SAFE)
    public boolean isRemoteTagReassignmentAllowed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.remoteTagReassignmentAllowed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.975 -0400", hash_original_method = "20ADA27D372C754940A803F19F3E7AD9", hash_generated_method = "842C816698003667C3513B0586902B80")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Collection<Dialog> getDialogs() {
        HashSet<Dialog> dialogs;
        dialogs = new HashSet<Dialog>();
        dialogs.addAll(this.dialogTable.values());
        dialogs.addAll(this.earlyDialogTable.values());
        return (Collection<Dialog>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //HashSet<Dialog> dialogs = new HashSet<Dialog>();
        //dialogs.addAll(this.dialogTable.values());
        //dialogs.addAll(this.earlyDialogTable.values());
        //return dialogs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.980 -0400", hash_original_method = "9851D171868856682CD66D2C2C77C100", hash_generated_method = "4F1401407E6FDA32CE101A1C043E331F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Collection<Dialog> getDialogs(DialogState state) {
        dsTaint.addTaint(state.dsTaint);
        HashSet<Dialog> matchingDialogs;
        matchingDialogs = new HashSet<Dialog>();
        {
            boolean var4484BD33CD3D459F91886F147843B739_367150073 = (DialogState.EARLY.equals(state));
            {
                matchingDialogs.addAll(this.earlyDialogTable.values());
            } //End block
            {
                Collection<SIPDialog> dialogs;
                dialogs = dialogTable.values();
                {
                    Iterator<SIPDialog> varAF4A62B1E6DB1A3E833F63312F30D56D_1812377961 = (dialogs).iterator();
                    varAF4A62B1E6DB1A3E833F63312F30D56D_1812377961.hasNext();
                    SIPDialog dialog = varAF4A62B1E6DB1A3E833F63312F30D56D_1812377961.next();
                    {
                        {
                            boolean var2BB6D00E61F702FAA6D913BC8638615E_965629277 = (dialog.getState() != null && dialog.getState().equals(state));
                            {
                                matchingDialogs.add(dialog);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (Collection<Dialog>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //HashSet<Dialog> matchingDialogs = new HashSet<Dialog>();
        //if (DialogState.EARLY.equals(state)) {
            //matchingDialogs.addAll(this.earlyDialogTable.values());
        //} else {
            //Collection<SIPDialog> dialogs = dialogTable.values();
            //for (SIPDialog dialog : dialogs) {
                //if (dialog.getState() != null && dialog.getState().equals(state)) {
                    //matchingDialogs.add(dialog);
                //}
            //}
        //}
        //return matchingDialogs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.990 -0400", hash_original_method = "B020A334EC30ACCE61108F29E8239DE0", hash_generated_method = "4720218A6CB5F2998698CBD5532F1BBF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Dialog getReplacesDialog(ReplacesHeader replacesHeader) {
        dsTaint.addTaint(replacesHeader.dsTaint);
        String cid;
        cid = replacesHeader.getCallId();
        String fromTag;
        fromTag = replacesHeader.getFromTag();
        String toTag;
        toTag = replacesHeader.getToTag();
        StringBuffer dialogId;
        dialogId = new StringBuffer(cid);
        {
            dialogId.append(":");
            dialogId.append(toTag);
        } //End block
        {
            dialogId.append(":");
            dialogId.append(fromTag);
        } //End block
        String did;
        did = dialogId.toString().toLowerCase();
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_56899981 = (stackLogger.isLoggingEnabled());
            stackLogger.logDebug("Looking for dialog " + did);
        } //End collapsed parenthetic
        Dialog replacesDialog;
        replacesDialog = this.dialogTable.get(did);
        {
            {
                Iterator<SIPClientTransaction> varEDF5DFD05164E4355382132B99DA269C_1691229814 = (this.clientTransactionTable.values()).iterator();
                varEDF5DFD05164E4355382132B99DA269C_1691229814.hasNext();
                SIPClientTransaction ctx = varEDF5DFD05164E4355382132B99DA269C_1691229814.next();
                {
                    {
                        boolean varD9E48DC518AA5535EEDEFAF93267A4EE_300819118 = (ctx.getDialog(did) != null);
                        {
                            replacesDialog = ctx.getDialog(did);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (Dialog)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.991 -0400", hash_original_method = "01BB795BEB07C4ED2A3CDD99078DB107", hash_generated_method = "850D713E2E6084ECD4474210E54151A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Dialog getJoinDialog(JoinHeader joinHeader) {
        dsTaint.addTaint(joinHeader.dsTaint);
        String cid;
        cid = joinHeader.getCallId();
        String fromTag;
        fromTag = joinHeader.getFromTag();
        String toTag;
        toTag = joinHeader.getToTag();
        StringBuffer retval;
        retval = new StringBuffer(cid);
        {
            retval.append(":");
            retval.append(toTag);
        } //End block
        {
            retval.append(":");
            retval.append(fromTag);
        } //End block
        Dialog var26C433BE95C4A4394D79F56973F9D337_1135784765 = (this.dialogTable.get(retval.toString().toLowerCase()));
        return (Dialog)dsTaint.getTaint();
        // ---------- Original Method ----------
        //String cid = joinHeader.getCallId();
        //String fromTag = joinHeader.getFromTag();
        //String toTag = joinHeader.getToTag();
        //StringBuffer retval = new StringBuffer(cid);
        //if (toTag != null) {
            //retval.append(":");
            //retval.append(toTag);
        //}
        //if (fromTag != null) {
            //retval.append(":");
            //retval.append(fromTag);
        //}
        //return this.dialogTable.get(retval.toString().toLowerCase());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.992 -0400", hash_original_method = "69B105104758CF3A0416D8C1D4F4DE0D", hash_generated_method = "753CCDDFF2838E02C42010AD3BA03184")
    @DSModeled(DSC.SAFE)
    public void setTimer(Timer timer) {
        dsTaint.addTaint(timer.dsTaint);
        // ---------- Original Method ----------
        //this.timer = timer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.992 -0400", hash_original_method = "8E3D165A90C48C9C43C8115575D5D434", hash_generated_method = "C1E2E02F274D461592F7307E9093F327")
    @DSModeled(DSC.SAFE)
    public Timer getTimer() {
        return (Timer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return timer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.992 -0400", hash_original_method = "535D845393F6631B713A5EAFAC15730B", hash_generated_method = "33F5CA1EE94BBA4F741963C6FB0118FF")
    @DSModeled(DSC.SAFE)
    public int getReceiveUdpBufferSize() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return receiveUdpBufferSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.992 -0400", hash_original_method = "AD9781079D581597B87998F87481A2EF", hash_generated_method = "3E29D339D832EC4C8FC453650F3927FD")
    @DSModeled(DSC.SAFE)
    public void setReceiveUdpBufferSize(int receiveUdpBufferSize) {
        dsTaint.addTaint(receiveUdpBufferSize);
        // ---------- Original Method ----------
        //this.receiveUdpBufferSize = receiveUdpBufferSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.992 -0400", hash_original_method = "7F1E49D75F179129A028D4152C30D3F6", hash_generated_method = "3A90D2F18E2B85792354C63E04E85535")
    @DSModeled(DSC.SAFE)
    public int getSendUdpBufferSize() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return sendUdpBufferSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.992 -0400", hash_original_method = "085E2E0AF6AC7C34DFF993E649718D81", hash_generated_method = "40B5846EA995CE575D09AE78B92FD123")
    @DSModeled(DSC.SAFE)
    public void setSendUdpBufferSize(int sendUdpBufferSize) {
        dsTaint.addTaint(sendUdpBufferSize);
        // ---------- Original Method ----------
        //this.sendUdpBufferSize = sendUdpBufferSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.993 -0400", hash_original_method = "3649FCA00F1F012AB31400D887FE5668", hash_generated_method = "62CA809EA8AD7513853E2C4D9928684C")
    @DSModeled(DSC.SAFE)
    public void setStackLogger(StackLogger stackLogger) {
        dsTaint.addTaint(stackLogger.dsTaint);
        // ---------- Original Method ----------
        //this.stackLogger = stackLogger;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.993 -0400", hash_original_method = "3A00FD245E091565EAC4D2A0BF135C63", hash_generated_method = "E86369D5CAB3BD29862C1A1FB0F8B047")
    @DSModeled(DSC.SAFE)
    public boolean checkBranchId() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.checkBranchId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.993 -0400", hash_original_method = "4B576FDEB92FCE56B4004D51F27F133D", hash_generated_method = "62D7FFAE110BFFBF50DEC4DC4C1EB308")
    @DSModeled(DSC.SAFE)
    public void setLogStackTraceOnMessageSend(boolean logStackTraceOnMessageSend) {
        dsTaint.addTaint(logStackTraceOnMessageSend);
        // ---------- Original Method ----------
        //this.logStackTraceOnMessageSend = logStackTraceOnMessageSend;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.993 -0400", hash_original_method = "6EA33CFFB30E0EA85B4B3B5316E0B073", hash_generated_method = "C1197F557F47218E89CC5C427184683C")
    @DSModeled(DSC.SAFE)
    public boolean isLogStackTraceOnMessageSend() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return logStackTraceOnMessageSend;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.993 -0400", hash_original_method = "BBC3144A1CF9CB1C9F37A775F293720F", hash_generated_method = "1AB264FBAA3C1AD042F7B5A0A41EB0AF")
    @DSModeled(DSC.SAFE)
    public void setDeliverDialogTerminatedEventForNullDialog() {
        this.isDialogTerminatedEventDeliveredForNullDialog = true;
        // ---------- Original Method ----------
        //this.isDialogTerminatedEventDeliveredForNullDialog = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.994 -0400", hash_original_method = "C791CC7BC6998146618C651EB49E3406", hash_generated_method = "BB63CA3E610C00679F242468A84F3664")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addForkedClientTransaction(SIPClientTransaction clientTransaction) {
        dsTaint.addTaint(clientTransaction.dsTaint);
        this.forkedClientTransactionTable.put(clientTransaction.getTransactionId(), clientTransaction );
        // ---------- Original Method ----------
        //this.forkedClientTransactionTable.put(clientTransaction.getTransactionId(), clientTransaction );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.994 -0400", hash_original_method = "A07C61DB9453AEA0A84C4416E8A5508E", hash_generated_method = "65F52532D8128E21F61C7912B3F523F7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPClientTransaction getForkedTransaction(String transactionId) {
        dsTaint.addTaint(transactionId);
        SIPClientTransaction var2016E26251D2C08FB23BEDC81C22098F_99008153 = (this.forkedClientTransactionTable.get(transactionId));
        return (SIPClientTransaction)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.forkedClientTransactionTable.get(transactionId);
    }

    
    class PingTimer extends SIPStackTimerTask {
        ThreadAuditor.ThreadHandle threadHandle;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.994 -0400", hash_original_method = "BD8473F7A826DDA501F390A58BAECB33", hash_generated_method = "30407791D225D1C12F279C7761B32946")
        @DSModeled(DSC.SAFE)
        public PingTimer(ThreadAuditor.ThreadHandle a_oThreadHandle) {
            dsTaint.addTaint(a_oThreadHandle.dsTaint);
            // ---------- Original Method ----------
            //threadHandle = a_oThreadHandle;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.994 -0400", hash_original_method = "D20FBACDA77D9F2BECED97C9063F3E91", hash_generated_method = "4E9E75769E0F4D7E97A6A67DE49306FE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected void runTask() {
            {
                boolean varC22F88379E8062191B8F0291837053FF_1298715151 = (getTimer() != null);
                {
                    {
                        threadHandle = getThreadAuditor().addCurrentThread();
                    } //End block
                    threadHandle.ping();
                    getTimer().schedule(new PingTimer(threadHandle),
                        threadHandle.getPingIntervalInMillisecs());
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (getTimer() != null) {
                //if (threadHandle == null) {
                    //threadHandle = getThreadAuditor().addCurrentThread();
                //}
                //threadHandle.ping();
                //getTimer().schedule(new PingTimer(threadHandle),
                        //threadHandle.getPingIntervalInMillisecs());
            //}
        }

        
    }


    
    class RemoveForkedTransactionTimerTask extends SIPStackTimerTask {
        private SIPClientTransaction clientTransaction;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.994 -0400", hash_original_method = "D0A941D96C1666EFE3BE3721976F6AA6", hash_generated_method = "B9B58299DDF1BCC9B86DE3ABE3FCD393")
        @DSModeled(DSC.SAFE)
        public RemoveForkedTransactionTimerTask(SIPClientTransaction sipClientTransaction ) {
            dsTaint.addTaint(sipClientTransaction.dsTaint);
            // ---------- Original Method ----------
            //this.clientTransaction = sipClientTransaction;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.995 -0400", hash_original_method = "0A8A5E2C1505E2C2E84219D84E5444CF", hash_generated_method = "74E9473D704F21F1BB34BAE5007DACEC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected void runTask() {
            forkedClientTransactionTable.remove(clientTransaction.getTransactionId());
            // ---------- Original Method ----------
            //forkedClientTransactionTable.remove(clientTransaction.getTransactionId());
        }

        
    }


    
    public static final int BASE_TIMER_INTERVAL = 500;
    public static final int CONNECTION_LINGER_TIME = 8;
    protected static final Set<String> dialogCreatingMethods = new HashSet<String>();
    static {
    	dialogCreatingMethods.add(Request.REFER);
        dialogCreatingMethods.add(Request.INVITE);
        dialogCreatingMethods.add(Request.SUBSCRIBE);
    }
    
}

