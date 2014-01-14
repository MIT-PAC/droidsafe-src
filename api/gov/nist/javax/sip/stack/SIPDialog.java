package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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

    /**
     * Creates a new dialog based on a received NOTIFY. The dialog state is initialized
     * appropriately. The NOTIFY differs in the From tag
     * 
     * Made this a separate method to clearly distinguish what's happening here - this is a
     * non-trivial case
     * 
     * @param subscribeTx - the transaction started with the SUBSCRIBE that we sent
     * @param notifyST - the ServerTransaction created for an incoming NOTIFY
     * @return -- a new dialog created from the subscribe original SUBSCRIBE transaction.
     * 
     * 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.501 -0500", hash_original_method = "9CEA4CE8D7F35B00CDC566F3844E42FB", hash_generated_method = "45DDFF708E7F5901D1E683C220FA6C8C")
    
public static SIPDialog createFromNOTIFY(SIPClientTransaction subscribeTx,
            SIPTransaction notifyST) {
        SIPDialog d = new SIPDialog(notifyST);
        //
        // The above sets d.firstTransaction to NOTIFY (ST), correct that
        //
        d.serverTransactionFlag = false;
        // they share this one
        d.lastTransaction = subscribeTx;
        storeFirstTransactionInfo(d, subscribeTx);
        d.terminateOnBye = false;
        d.localSequenceNumber = subscribeTx.getCSeq();
        SIPRequest not = (SIPRequest) notifyST.getRequest();
        d.remoteSequenceNumber = not.getCSeq().getSeqNumber();
        d.setDialogId(not.getDialogId(true));
        d.setLocalTag(not.getToTag());
        d.setRemoteTag(not.getFromTag());
        // to properly create the Dialog object.
        // If not the stack will throw an exception when creating the response.
        d.setLastResponse(subscribeTx, subscribeTx.getLastResponse());

        // Dont use setLocal / setRemote here, they make other assumptions
        d.localParty = not.getTo().getAddress();
        d.remoteParty = not.getFrom().getAddress();

        // initialize d's route set based on the NOTIFY. Any proxies must have
        // Record-Routed
        d.addRoute(not);
        d.setState(CONFIRMED_STATE); // set state, *after* setting route set!
        return d;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.514 -0500", hash_original_method = "89C579222925300A22DBFE6EFF04DD03", hash_generated_method = "DCB69FF0E6DC13289462E175CC0C58FD")
    
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.656 -0500", hash_original_method = "10DA26C1D5D4933A010FC5F42325E504", hash_generated_method = "D828C31DA6AF75BD4A9EF1BA29C3C862")
    
private static final boolean optionPresent(ListIterator l, String option) {
        while (l.hasNext()) {
            OptionTag opt = (OptionTag) l.next();
            if (opt != null && option.equalsIgnoreCase(opt.getOptionTag()))
                return true;
        }
        return false;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.152 -0500", hash_original_field = "FAFEE689DD9BEE22199D30F0B5CB5C02", hash_generated_field = "010392E015C0F4F4EE6412AC38CADE79")

    private static final long serialVersionUID = -1429794423085204069L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.248 -0500", hash_original_field = "7D485097D3AC7F37AB9AE134C024E22B", hash_generated_field = "0217060B0F6ACCA57DEF89D56528802E")

    public final static int NULL_STATE = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.251 -0500", hash_original_field = "48BD75FEC61E503FEF57A7AB7BFC7ADD", hash_generated_field = "7E4774629A80511A1605FBB2145C202F")

    public final static int EARLY_STATE = DialogState._EARLY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.254 -0500", hash_original_field = "B1B2512C3F757FBFF999FCDC60462AB5", hash_generated_field = "45C6B699CF332D7B77B3EB2AD8AB7301")

    public final static int CONFIRMED_STATE = DialogState._CONFIRMED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.257 -0500", hash_original_field = "7541F5A0B111421F968D825B05659DEF", hash_generated_field = "80C37090AC7335F51D7D9FB4E1EC85B9")

    public final static int TERMINATED_STATE = DialogState._TERMINATED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.260 -0500", hash_original_field = "FADAFD305ADEC34F6638B9D87A1B34D6", hash_generated_field = "40DFB0E7AF36C25D0E66FE67C01F2E05")

    private static final int DIALOG_LINGER_TIME = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.155 -0500", hash_original_field = "6643AF6CD1B4E0A0C148CA67F9FC4A01", hash_generated_field = "8B7AA916EC7A88984DDF8AA52B9F1641")

    private transient boolean dialogTerminatedEventDelivered;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.158 -0500", hash_original_field = "43939ED17E777DB55D0797009C2B6B15", hash_generated_field = "9F3F9DDDB302CE97F2E415A10FABBE2D")
    
    private transient String stackTrace;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.161 -0500", hash_original_field = "842C170402669AC7A74293BBBFD3BC5D", hash_generated_field = "F42F15CDE806BBAD7F26F7952D68FCE2")

    private String method;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.164 -0500", hash_original_field = "5330D83FF9E589FD585879FB9A15AF73", hash_generated_field = "386AD1FFF2E8BC21894EEC2B1DC5720D")

    private transient boolean isAssigned;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.166 -0500", hash_original_field = "F403AF2B6E4D83C1981EA22811582426", hash_generated_field = "E1B54A10C305CE35C160FA0FCCD06B96")

    private boolean reInviteFlag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.169 -0500", hash_original_field = "324CFAE3E8224AEDE88E789E229FDCE3", hash_generated_field = "0C346A02ABD6566D7A046D5EE80C0EC0")

    private transient Object applicationData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.173 -0500", hash_original_field = "BD77875F08D47A4F03542967D7A8895C", hash_generated_field = "AD3FCBD371406352A3E03A00BDAA3D18")

    private transient SIPRequest originalRequest;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.175 -0500", hash_original_field = "1512DDEB34EA4DFEA7B165ECD6EE2EE0", hash_generated_field = "7328CD7146ABA98BB701BDA934CF1486")

    private SIPResponse lastResponse;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.178 -0500", hash_original_field = "6F9E91FFF063C690915B5CF647F0D44E", hash_generated_field = "FD37847416B987CE46514F63B11739D7")

    // so when a subsequent request will be sent it will be set and a new message channel can be
    // created
    private transient SIPTransaction firstTransaction;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.181 -0500", hash_original_field = "3F2287C37B2FC12AD80B252DF94B0823", hash_generated_field = "8E3DDDE2C9BBCFF0518502DA3A19B8FC")

    private transient SIPTransaction lastTransaction;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.183 -0500", hash_original_field = "6D266ECB4501DB72D6B336432EF66FBE", hash_generated_field = "FFD5ABB57CC8068DFE83871CA8391D63")

    private String dialogId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.187 -0500", hash_original_field = "D721CEFD4227586EA61CDF274C207E27", hash_generated_field = "047D72F6110028ED8614A185C3ADEE63")

    private transient String earlyDialogId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.189 -0500", hash_original_field = "4EF662D656AFABAEF98C118FA47BEDFA", hash_generated_field = "AD815FC4C870FA38840533B56E201007")

    private long localSequenceNumber;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.192 -0500", hash_original_field = "B0DACE40AD1024DD1C827120854C07DE", hash_generated_field = "096C078B93EFB214E2172D793F365B4D")

    private long remoteSequenceNumber;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.195 -0500", hash_original_field = "02846CE0ACCA736631C71250B6155E19", hash_generated_field = "DE4FDB012317C10FCB5EE3D6596519E1")

    protected String myTag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.197 -0500", hash_original_field = "9EBF9436B6BFC60B2C9AE91A91B0A3EC", hash_generated_field = "9777EBD405E9D84F5A9D8688CA87BB34")

    protected String hisTag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.200 -0500", hash_original_field = "B81F62D31BED2E4EEE43551B06C823AA", hash_generated_field = "873E71D84A907B69A5D7EA40A6E98B84")

    private RouteList routeList;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.203 -0500", hash_original_field = "A4B05DD1A2BDFAA2E8FCD10E8D1815B6", hash_generated_field = "648E45DA0C2D4CA0D3A6C1331273D1A8")

    private transient SIPTransactionStack sipStack;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.205 -0500", hash_original_field = "62858B617E507990DA3CC0096123D4D5", hash_generated_field = "B18AB1AD22CF960F8E3DA659D957473C")

    private int dialogState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.208 -0500", hash_original_field = "EE75B6024EBD7DEE5AE8D001B1351008", hash_generated_field = "92F226B9C77FEEDF00455BB4E4B37995")

    protected transient boolean ackSeen;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.211 -0500", hash_original_field = "6D5D6FC8FEC2783A3CB27D3EAE2C400E", hash_generated_field = "5047CDCA90F6F4D08E6FCFC3504AA33A")
    
    private transient SIPRequest lastAckSent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.214 -0500", hash_original_field = "148A10416FF7713409E611C1F7D412C4", hash_generated_field = "0D41AA5710D910AD875D10253E3B5B7B")

    private SIPRequest lastAckReceived;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.217 -0500", hash_original_field = "4573F4C85307AE75336CF9B08DC47D39", hash_generated_field = "39BFE22C217FFF2E6FD7425093780B7F")

    protected transient boolean ackProcessed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.220 -0500", hash_original_field = "CCD214351FCFA7791C4573ABAB2EFF11", hash_generated_field = "CCB890E772BC08D4A4B71682A75E6B57")

    protected transient DialogTimerTask timerTask;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.222 -0500", hash_original_field = "83AD285FEC1F2439BA5D71BF0D15ABBE", hash_generated_field = "50CA1F3CDF0B9F341970FE5A2E9968CD")

    protected transient Long nextSeqno;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.225 -0500", hash_original_field = "29BB0AB552E6687B4BA23C197B5FF0C5", hash_generated_field = "357D95D41FE555F3403B8186135E948D")

    private transient int retransmissionTicksLeft;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.228 -0500", hash_original_field = "CA55F2F37B34780B9E0D89F5D7C47AB0", hash_generated_field = "FDB9FFD63AE6B4740136DBB4E840047D")

    private transient int prevRetransmissionTicks;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.231 -0500", hash_original_field = "0B6303BEF96BE183ACC5FC83E4572B2D", hash_generated_field = "AB98AAAC4EF13468E54DBE8642C5759B")

    private long originalLocalSequenceNumber;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.234 -0500", hash_original_field = "7606FD852E27940995566D512BD5CC62", hash_generated_field = "D019361A8619CB9E208CC4A408868CF5")

    private transient int ackLine;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.237 -0500", hash_original_field = "89446EA928FF624F1565F240BCD58AD7", hash_generated_field = "B8AD8E741E80B25C3AEBA11833850788")

    public transient long auditTag = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.240 -0500", hash_original_field = "9B007C92EACBD998C759255CDEFA3456", hash_generated_field = "AA47E14678F1529DEC481AB70D8C8E54")

    // Dialog.

    protected javax.sip.address.Address localParty;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.242 -0500", hash_original_field = "B0437132C5E1045392EAE566FD2D4917", hash_generated_field = "039B4B6D9758816DF54E227BDD9B553B")

    protected javax.sip.address.Address remoteParty;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.245 -0500", hash_original_field = "699B7DF9CFF1B4D5BC70FBCBBC4F5C34", hash_generated_field = "4FB7DFE93D6674CE9A4D6470DED9D170")

    protected CallIdHeader callIdHeader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.263 -0500", hash_original_field = "355EAE520573DB8BE89F695A820E2AAF", hash_generated_field = "66E18B86E8394598F2C548C54E34F3D8")

    private boolean serverTransactionFlag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.265 -0500", hash_original_field = "ABE11E1B61EA62D737AB9769DADE074A", hash_generated_field = "58BDE3AD74EC5F605B651AEC94A1C475")

    private transient SipProviderImpl sipProvider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.268 -0500", hash_original_field = "A31BFB782BFEDAA14F092FBDC0002014", hash_generated_field = "369DECFD4E296468A8EE9210A060D65B")

    private boolean terminateOnBye;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.271 -0500", hash_original_field = "0C3E7883A84E49F8DF692BDEEB9D4B79", hash_generated_field = "024E9E66DF22C3B5E5731FC6B0083C1A")

    private transient boolean byeSent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.273 -0500", hash_original_field = "F6F3367B8DB7BC2E442A18554A67A586", hash_generated_field = "94B99C5B269359702325C3E405F1EDCC")

    // requests

    private Address remoteTarget;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.276 -0500", hash_original_field = "5B6FD022DD4B20F4D73664B25C72B6C5", hash_generated_field = "7F1ED863122BA67FB6B399180FFB61EF")

    private EventHeader eventHeader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.279 -0500", hash_original_field = "17AF5FF2A4C4300AD20D7EE11BE802C7", hash_generated_field = "BA0B3783629F1111A588217A66FE643C")

    // Stores the last OK for the INVITE
    // Used in createAck.
    private transient long lastInviteOkReceived;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.282 -0500", hash_original_field = "84A1D33DB85D926740C41EF795716F6A", hash_generated_field = "043CF414B4BC114C321725D26030C925")

    private transient Semaphore ackSem = new Semaphore(1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.285 -0500", hash_original_field = "55D4929B1F8E145A6C7EE5897E8019DD", hash_generated_field = "8391C3AA408B5C65CA6D2DAD521FC0C6")

    private transient int reInviteWaitTime = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.288 -0500", hash_original_field = "D29EAC75393E8E5F402902E0233D553C", hash_generated_field = "671578F07EF254B77AC2D4173CF99A1A")

    private transient DialogDeleteTask dialogDeleteTask;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.291 -0500", hash_original_field = "04FDD1504CBF24F6DFDBBDB72374EDE3", hash_generated_field = "B9EBB973A8692BA4C974F82BA5B997F3")

	private transient DialogDeleteIfNoAckSentTask dialogDeleteIfNoAckSentTask;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.294 -0500", hash_original_field = "1B2C94A66D1C577430F7361DDC9A242A", hash_generated_field = "173A1FD238D8569297A5D30A0D2122DA")
    
    private transient boolean isAcknowledged;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.297 -0500", hash_original_field = "92AAB117A70E48DE044D8993E50964D6", hash_generated_field = "19F7BD09CC9EC40661F8FE53075718B2")
    
    private transient long highestSequenceNumberAcknowledged = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.299 -0500", hash_original_field = "D6A942069C75A882A27F6777EC5DEAC0", hash_generated_field = "DA4CDB35B5056C6CA182EC98C7A0FE9B")
    
    private boolean isBackToBackUserAgent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.302 -0500", hash_original_field = "603C699F5FD0B730C39B3004617352E3", hash_generated_field = "7EEEE754C8F2FA7215F638E76C8E67E0")

    private boolean sequenceNumberValidation = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.305 -0500", hash_original_field = "BEE4D9EBA29271F161E0A7B564264B47", hash_generated_field = "CFB0D25D7A9D3DB327E35494FC7DE9A5")

	private transient Set<SIPDialogEventListener> eventListeners;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.308 -0500", hash_original_field = "A06E8C72AE67E7885C7693C4718C921B", hash_generated_field = "B1245AF2B94FAB1223B77DABE0E26551")

	private Semaphore timerTaskLock = new Semaphore(1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.311 -0500", hash_original_field = "96127258CC0487AD8B29AC4D4D1866B7", hash_generated_field = "9606AFFB15C5B44B32C9A01E4E1E56CD")

	// keep the whole transaction object for the duration of the dialog. It also
	// contains the non-transient information used in the replication of dialogs.
	protected boolean firstTransactionSecure;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.314 -0500", hash_original_field = "63A8879E95E8CBC18F52C28F15FAE6FF", hash_generated_field = "68EC519F0D2EE4EB55E96608058AA384")

	protected boolean firstTransactionSeen;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.316 -0500", hash_original_field = "25A2AF6977F2E0706533A83E068BD4AB", hash_generated_field = "4D111E3CF541CDB9CD69CDF93FCEDDAC")

    protected String firstTransactionMethod;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.318 -0500", hash_original_field = "2FB5712F708121EE96A7252B12F53E40", hash_generated_field = "DFB6058EA76D5E106C80BCA9A74A2D53")

    protected String firstTransactionId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.322 -0500", hash_original_field = "4B933A77F2124DE874B31CD94E4DAC08", hash_generated_field = "39C149EC307ADB72278A474A328A3BCF")

    protected boolean firstTransactionIsServerTransaction;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.324 -0500", hash_original_field = "472459B00BAA96CAA2975F1A38CF1774", hash_generated_field = "801C0A281C881455A3F35F92B0224337")

    protected int firstTransactionPort = 5060;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.327 -0500", hash_original_field = "5244BEC1D53397A44D1D97DE9CE5AC8B", hash_generated_field = "4CA7FF5DA34408C08E9FC1CA2863A04F")
   
    protected Contact contactHeader;

    // ///////////////////////////////////////////////////////////
    // Constructors.
    // ///////////////////////////////////////////////////////////
    /**
     * Protected Dialog constructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.392 -0500", hash_original_method = "B89E344ABA0B0C4EAAF339C3C960DE0F", hash_generated_method = "6D20A62D4FB6D1CF518FA5CB9C10BCF3")
    
private SIPDialog(SipProviderImpl provider) {
        this.terminateOnBye = true;
        this.routeList = new RouteList();
        this.dialogState = NULL_STATE; // not yet initialized.
        localSequenceNumber = 0;
        remoteSequenceNumber = -1;
        this.sipProvider = provider;
        eventListeners = new CopyOnWriteArraySet<SIPDialogEventListener>();
    }

    /**
     * Constructor given the first transaction.
     * 
     * @param transaction is the first transaction.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.398 -0500", hash_original_method = "BE0EB8A93E786CF5997E41E028500B95", hash_generated_method = "260BCBEC87602E90B89A6884D48D28ED")
    
public SIPDialog(SIPTransaction transaction) {
        this(transaction.getSipProvider());
       
        SIPRequest sipRequest = (SIPRequest) transaction.getRequest();
        this.callIdHeader = sipRequest.getCallId();
        this.earlyDialogId = sipRequest.getDialogId(false);
        if (transaction == null)
            throw new NullPointerException("Null tx");
        this.sipStack = transaction.sipStack;

        // this.defaultRouter = new DefaultRouter((SipStack) sipStack,
        // sipStack.outboundProxy);

        this.sipProvider = (SipProviderImpl) transaction.getSipProvider();
        if (sipProvider == null)
            throw new NullPointerException("Null Provider!");
        this.addTransaction(transaction);
        if (sipStack.isLoggingEnabled()) {
            sipStack.getStackLogger().logDebug("Creating a dialog : " + this);
            sipStack.getStackLogger().logDebug(
                    "provider port = " + this.sipProvider.getListeningPoint().getPort());
            sipStack.getStackLogger().logStackTrace();
        }
        this.isBackToBackUserAgent = sipStack.isBackToBackUserAgent;
        addEventListener(sipStack);
    }

    /**
     * Constructor given a transaction and a response.
     * 
     * @param transaction -- the transaction ( client/server)
     * @param sipResponse -- response with the appropriate tags.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.401 -0500", hash_original_method = "0305A0224D6BCDD571D54C883A13EEA2", hash_generated_method = "029D06C68882E5214B1A5B38502C0AF4")
    
public SIPDialog(SIPClientTransaction transaction, SIPResponse sipResponse) {
        this(transaction);
        if (sipResponse == null)
            throw new NullPointerException("Null SipResponse");
        this.setLastResponse(transaction, sipResponse);
        this.isBackToBackUserAgent = sipStack.isBackToBackUserAgent;
    }

    /**
     * create a sip dialog with a response ( no tx)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.405 -0500", hash_original_method = "95FF401EAA7EE3F3C9E78290081B0530", hash_generated_method = "3AE7400E6A8ADCDFC101452B65121BFE")
    
public SIPDialog(SipProviderImpl sipProvider, SIPResponse sipResponse) {
        this(sipProvider);
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
        if (sipStack.isLoggingEnabled()) {
            sipStack.getStackLogger().logDebug("Creating a dialog : " + this);
            sipStack.getStackLogger().logStackTrace();
        }
        this.isBackToBackUserAgent = sipStack.isBackToBackUserAgent;
        addEventListener(sipStack);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.395 -0500", hash_original_method = "9EE497100AA17813744E66E4A05B8669", hash_generated_method = "F8F1D831F0B483329F083128121C4BB4")
    
private void recordStackTrace() {
      StringWriter stringWriter = new StringWriter();
      PrintWriter writer = new PrintWriter(stringWriter);
      new Exception().printStackTrace(writer);
       this.stackTrace = stringWriter.getBuffer().toString();
    }

    // ///////////////////////////////////////////////////////////
    // Private methods
    // ///////////////////////////////////////////////////////////
    /**
     * A debugging print routine.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.408 -0500", hash_original_method = "40815EC709415499328FA1CBE062ACB5", hash_generated_method = "AB033A1CDE8B1578E309F49415571B96")
    
private void printRouteList() {
        if (sipStack.isLoggingEnabled()) {
            sipStack.getStackLogger().logDebug("this : " + this);
            sipStack.getStackLogger().logDebug("printRouteList : " + this.routeList.encode());
        }
    }

    /**
     * Return true if this is a client dialog.
     * 
     * @return true if the transaction that created this dialog is a client transaction and false
     *         otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.411 -0500", hash_original_method = "6746D685A6EEFE6F86FE53A5B90B58CB", hash_generated_method = "987E98FB86E6924AD630BE8C80953A6B")
    
private boolean isClientDialog() {
        SIPTransaction transaction = (SIPTransaction) this.getFirstTransaction();
        return transaction instanceof SIPClientTransaction;
    }

    /**
     * Raise an io exception for asyncrhonous retransmission of responses
     * 
     * @param host -- host to where the io was headed
     * @param port -- remote port
     * @param protocol -- protocol (udp/tcp/tls)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.413 -0500", hash_original_method = "871D6D7CB1794492ED7691CB8C5B804E", hash_generated_method = "033720C21C04EE8076D057035900CEA7")
    
private void raiseIOException(String host, int port, String protocol) {
        // Error occured in retransmitting response.
        // Deliver the error event to the listener
        // Kill the dialog.

        IOExceptionEvent ioError = new IOExceptionEvent(this, host, port, protocol);
        sipProvider.handleEvent(ioError, null);

        setState(SIPDialog.TERMINATED_STATE);
    }
    
    /**
     * Raise a dialog timeout if an ACK has not been sent or received
     * 
     * @param dialogTimeoutError 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.416 -0500", hash_original_method = "352742C76D82997D1FD2B39635FE380F", hash_generated_method = "E11AF9D090D6F2FE40004EC6207EADAF")
    
private void raiseErrorEvent(int dialogTimeoutError) {
		// Error event to send to all listeners
		SIPDialogErrorEvent newErrorEvent;
		// Iterator through the list of listeners
		Iterator<SIPDialogEventListener> listenerIterator;
		// Next listener in the list
		SIPDialogEventListener nextListener;

		// Create the error event
		newErrorEvent = new SIPDialogErrorEvent(this, dialogTimeoutError);

		// Loop through all listeners of this transaction
		synchronized (eventListeners) {
			listenerIterator = eventListeners.iterator();
			while (listenerIterator.hasNext()) {
				// Send the event to the next listener
				nextListener = (SIPDialogEventListener) listenerIterator.next();
				nextListener.dialogErrorEvent(newErrorEvent);
			}
		}
		// Clear the event listeners after propagating the error.
		eventListeners.clear();
		// Errors always terminate a dialog except if a timeout has occured because an ACK was not sent or received, then it is the responsibility of the app to terminate
		// the dialog, either by sending a BYE or by calling delete() on the dialog		
		if(dialogTimeoutError != SIPDialogErrorEvent.DIALOG_ACK_NOT_SENT_TIMEOUT &&
		        dialogTimeoutError != SIPDialogErrorEvent.DIALOG_ACK_NOT_RECEIVED_TIMEOUT &&
		        dialogTimeoutError != SIPDialogErrorEvent.DIALOG_REINVITE_TIMEOUT ) {
			delete();
		}
		// we stop the timer in any case
		stopTimer();
	}

    /**
     * Set the remote party for this Dialog.
     * 
     * @param sipMessage -- SIP Message to extract the relevant information from.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.420 -0500", hash_original_method = "E7371746614A4FB0A7068DCC784728D1", hash_generated_method = "3E54C1F5D0FE2D5478E23C48A46D6672")
    
private void setRemoteParty(SIPMessage sipMessage) {

        if (!isServer()) {

            this.remoteParty = sipMessage.getTo().getAddress();
        } else {
            this.remoteParty = sipMessage.getFrom().getAddress();

        }
        if (sipStack.isLoggingEnabled()) {
            sipStack.getStackLogger().logDebug("settingRemoteParty " + this.remoteParty);
        }
    }

    /**
     * Add a route list extracted from a record route list. If this is a server dialog then we
     * assume that the record are added to the route list IN order. If this is a client dialog
     * then we assume that the record route headers give us the route list to add in reverse
     * order.
     * 
     * @param recordRouteList -- the record route list from the incoming message.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.424 -0500", hash_original_method = "07989C3909E96A7576DAE0D29DD189A0", hash_generated_method = "4CC6F7815479BD2C24DC503B87EA800A")
    
private void addRoute(RecordRouteList recordRouteList) {
        try {
            if (this.isClientDialog()) {
                // This is a client dialog so we extract the record
                // route from the response and reverse its order to
                // careate a route list.
                this.routeList = new RouteList();
                // start at the end of the list and walk backwards

                ListIterator li = recordRouteList.listIterator(recordRouteList.size());
                boolean addRoute = true;
                while (li.hasPrevious()) {
                    RecordRoute rr = (RecordRoute) li.previous();

                    if (addRoute) {
                        Route route = new Route();
                        AddressImpl address = ((AddressImpl) ((AddressImpl) rr.getAddress())
                                .clone());

                        route.setAddress(address);
                        route.setParameters((NameValueList) rr.getParameters().clone());

                        this.routeList.add(route);
                    }
                }
            } else {
                // This is a server dialog. The top most record route
                // header is the one that is closest to us. We extract the
                // route list in the same order as the addresses in the
                // incoming request.
                this.routeList = new RouteList();
                ListIterator li = recordRouteList.listIterator();
                boolean addRoute = true;
                while (li.hasNext()) {
                    RecordRoute rr = (RecordRoute) li.next();

                    if (addRoute) {
                        Route route = new Route();
                        AddressImpl address = ((AddressImpl) ((AddressImpl) rr.getAddress())
                                .clone());
                        route.setAddress(address);
                        route.setParameters((NameValueList) rr.getParameters().clone());
                        routeList.add(route);
                    }
                }
            }
        } finally {
            if (sipStack.getStackLogger().isLoggingEnabled()) {
                Iterator it = routeList.iterator();

                while (it.hasNext()) {
                    SipURI sipUri = (SipURI) (((Route) it.next()).getAddress().getURI());
                    if (!sipUri.hasLrParam()) {                     
                    	if (sipStack.isLoggingEnabled()) {
                    		sipStack.getStackLogger().logWarning(
                                "NON LR route in Route set detected for dialog : " + this);
                        	sipStack.getStackLogger().logStackTrace();
                    	}	
                    }
                }
            }
        }
    }

    /**
     * Add a route list extacted from the contact list of the incoming message.
     * 
     * @param contactList -- contact list extracted from the incoming message.
     * 
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.426 -0500", hash_original_method = "0B8DEDA7075751956ABB1ACBE337F637", hash_generated_method = "0B8DEDA7075751956ABB1ACBE337F637")
    
void setRemoteTarget(ContactHeader contact) {
        this.remoteTarget = contact.getAddress();
        if (sipStack.isLoggingEnabled()) {
            sipStack.getStackLogger().logDebug("Dialog.setRemoteTarget: " + this.remoteTarget);
            sipStack.getStackLogger().logStackTrace();
        }

    }

    /**
     * Extract the route information from this SIP Message and add the relevant information to the
     * route set.
     * 
     * @param sipMessage is the SIP message for which we want to add the route.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.430 -0500", hash_original_method = "32344AE5A14991821D94A9D2D9260949", hash_generated_method = "C05CDFD6C74C04E01C519D3E3FE874EA")
    
private synchronized void addRoute(SIPResponse sipResponse) {

        try {
            if (sipStack.isLoggingEnabled()) {
                sipStack.getStackLogger().logDebug(
                        "setContact: dialogState: " + this + "state = " + this.getState());
            }
            if (sipResponse.getStatusCode() == 100) {
                // Do nothing for trying messages.
                return;
            } else if (this.dialogState == TERMINATED_STATE) {
                // Do nothing if the dialog state is terminated.
                return;
            } else if (this.dialogState == CONFIRMED_STATE) {
                // cannot add route list after the dialog is initialized.
                // Remote target is updated on RE-INVITE but not
                // the route list.
                if (sipResponse.getStatusCode() / 100 == 2 && !this.isServer()) {
                    ContactList contactList = sipResponse.getContactHeaders();
                    if (contactList != null
                            && SIPRequest.isTargetRefresh(sipResponse.getCSeq().getMethod())) {
                        this.setRemoteTarget((ContactHeader) contactList.getFirst());
                    }
                }
                return;
            }

            // Update route list on response if I am a client dialog.
            if (!isServer()) {

                // only update the route set if the dialog is not in the confirmed state.
                if (this.getState() != DialogState.CONFIRMED
                        && this.getState() != DialogState.TERMINATED) {
                    RecordRouteList rrlist = sipResponse.getRecordRouteHeaders();
                    // Add the route set from the incoming response in reverse
                    // order for record route headers.
                    if (rrlist != null) {
                        this.addRoute(rrlist);
                    } else {
                        // Set the rotue list to the last seen route list.
                        this.routeList = new RouteList();
                    }
                }

                ContactList contactList = sipResponse.getContactHeaders();
                if (contactList != null) {
                    this.setRemoteTarget((ContactHeader) contactList.getFirst());
                }
            }

        } finally {
            if (sipStack.isLoggingEnabled()) {
                sipStack.getStackLogger().logStackTrace();
            }
        }
    }

    /**
     * Get a cloned copy of route list for the Dialog.
     * 
     * @return -- a cloned copy of the dialog route list.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.433 -0500", hash_original_method = "EDCC5E2E639B8E515D6889EB4E225297", hash_generated_method = "FB446DB3537B9649DCAF78DCA2A5B082")
    
private synchronized RouteList getRouteList() {
        if (sipStack.isLoggingEnabled())
            sipStack.getStackLogger().logDebug("getRouteList " + this);
        // Find the top via in the route list.
        ListIterator li;
        RouteList retval = new RouteList();

        retval = new RouteList();
        if (this.routeList != null) {
            li = routeList.listIterator();
            while (li.hasNext()) {
                Route route = (Route) li.next();
                retval.add((Route) route.clone());
            }
        }

        if (sipStack.isLoggingEnabled()) {
            sipStack.getStackLogger().logDebug("----- ");
            sipStack.getStackLogger().logDebug("getRouteList for " + this);
            if (retval != null)
                sipStack.getStackLogger().logDebug("RouteList = " + retval.encode());
            if (routeList != null)
                sipStack.getStackLogger().logDebug("myRouteList = " + routeList.encode());
            sipStack.getStackLogger().logDebug("----- ");
        }
        return retval;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.436 -0500", hash_original_method = "7EC927C7EF5071E2849378214CAB8686", hash_generated_method = "7EC927C7EF5071E2849378214CAB8686")
    
void setRouteList(RouteList routeList) {
    	this.routeList = routeList;
    }

    /**
     * Sends ACK Request to the remote party of this Dialogue.
     * 
     * 
     * @param request the new ACK Request message to send.
     * @param throwIOExceptionAsSipException - throws SipException if IOEx encountered. Otherwise,
     *        no exception is propagated.
     * @param releaseAckSem - release ack semaphore.
     * @throws SipException if implementation cannot send the ACK Request for any other reason
     * 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.440 -0500", hash_original_method = "EE053BB78DA7F62675E98D1AF5A5B915", hash_generated_method = "D295859F2F9CEB8051268D51BE35BAFA")
    
private void sendAck(Request request, boolean throwIOExceptionAsSipException)
            throws SipException {
        SIPRequest ackRequest = (SIPRequest) request;
        if (sipStack.isLoggingEnabled())
            sipStack.getStackLogger().logDebug("sendAck" + this);

        if (!ackRequest.getMethod().equals(Request.ACK))
            throw new SipException("Bad request method -- should be ACK");
        if (this.getState() == null || this.getState().getValue() == EARLY_STATE) {
            if (sipStack.isLoggingEnabled()) {
                sipStack.getStackLogger().logError(
                        "Bad Dialog State for " + this + " dialogID = " + this.getDialogId());
            }
            throw new SipException("Bad dialog state " + this.getState());
        }

        if (!this.getCallId().getCallId().equals(((SIPRequest) request).getCallId().getCallId())) {
            if (sipStack.isLoggingEnabled()) {
                sipStack.getStackLogger().logError("CallID " + this.getCallId());
                sipStack.getStackLogger().logError(
                        "RequestCallID = " + ackRequest.getCallId().getCallId());
                sipStack.getStackLogger().logError("dialog =  " + this);
            }
            throw new SipException("Bad call ID in request");
        }
        try {
            if (sipStack.isLoggingEnabled()) {
                sipStack.getStackLogger().logDebug(
                        "setting from tag For outgoing ACK= " + this.getLocalTag());
                sipStack.getStackLogger().logDebug(
                        "setting To tag for outgoing ACK = " + this.getRemoteTag());
                sipStack.getStackLogger().logDebug("ack = " + ackRequest);
            }
            if (this.getLocalTag() != null)
                ackRequest.getFrom().setTag(this.getLocalTag());
            if (this.getRemoteTag() != null)
                ackRequest.getTo().setTag(this.getRemoteTag());
        } catch (ParseException ex) {
            throw new SipException(ex.getMessage());
        }

        Hop hop = sipStack.getNextHop(ackRequest);
        // Hop hop = defaultRouter.getNextHop(ackRequest);
        if (hop == null)
            throw new SipException("No route!");
        try {
            if (sipStack.isLoggingEnabled())
                sipStack.getStackLogger().logDebug("hop = " + hop);
            ListeningPointImpl lp = (ListeningPointImpl) this.sipProvider.getListeningPoint(hop
                    .getTransport());
            if (lp == null)
                throw new SipException("No listening point for this provider registered at "
                        + hop);
            InetAddress inetAddress = InetAddress.getByName(hop.getHost());
            MessageChannel messageChannel = lp.getMessageProcessor().createMessageChannel(
                    inetAddress, hop.getPort());
            boolean releaseAckSem = false;
            long cseqNo = ((SIPRequest)request).getCSeq().getSeqNumber();
            if (!this.isAckSent(cseqNo)) {
                releaseAckSem = true;
            }

            this.setLastAckSent(ackRequest);
            messageChannel.sendMessage(ackRequest);
            // Sent atleast one ACK.
            this.isAcknowledged = true;
            this.highestSequenceNumberAcknowledged = Math.max(this.highestSequenceNumberAcknowledged,
                    ((SIPRequest)ackRequest).getCSeq().getSeqNumber());
            if (releaseAckSem && this.isBackToBackUserAgent) {
                this.releaseAckSem();
            } else {
                if ( sipStack.isLoggingEnabled() ) {
                    sipStack.getStackLogger().logDebug("Not releasing ack sem for " + this + " isAckSent " + releaseAckSem );
                }
            }
        } catch (IOException ex) {
            if (throwIOExceptionAsSipException)
                throw new SipException("Could not send ack", ex);
            this.raiseIOException(hop.getHost(), hop.getPort(), hop.getTransport());
        } catch (SipException ex) {
            if (sipStack.isLoggingEnabled())
                sipStack.getStackLogger().logException(ex);
            throw ex;
        } catch (Exception ex) {
            if (sipStack.isLoggingEnabled())
                sipStack.getStackLogger().logException(ex);
            throw new SipException("Could not create message channel", ex);
        }
        if (this.dialogDeleteTask != null) {
            this.dialogDeleteTask.cancel();
            this.dialogDeleteTask = null;
        }
        this.ackSeen = true;

    }

    // /////////////////////////////////////////////////////////////
    // Package local methods
    // /////////////////////////////////////////////////////////////

    /**
     * Set the stack address. Prevent us from routing messages to ourselves.
     * 
     * @param sipStack the address of the SIP stack.
     * 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.443 -0500", hash_original_method = "0D216F13B34A5D6836A5B8174F7E5D5B", hash_generated_method = "0D216F13B34A5D6836A5B8174F7E5D5B")
    
void setStack(SIPTransactionStack sipStack) {
        this.sipStack = sipStack;

    }

    /**
     * Get the stack .
     * 
     * @return sipStack the SIP stack of the dialog.
     * 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.445 -0500", hash_original_method = "4B5A71F52939D771152A6C733BB7B273", hash_generated_method = "4B5A71F52939D771152A6C733BB7B273")
    
SIPTransactionStack getStack() {
        return sipStack;
    }

    /**
     * Return True if this dialog is terminated on BYE.
     * 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.448 -0500", hash_original_method = "82BA8A08B2E8140159AB0D3D207AD49D", hash_generated_method = "82BA8A08B2E8140159AB0D3D207AD49D")
    
boolean isTerminatedOnBye() {

        return this.terminateOnBye;
    }

    /**
     * Mark that the dialog has seen an ACK.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.451 -0500", hash_original_method = "45B7AAA172C2FB7B4FDF9001755F4630", hash_generated_method = "323CF2BAA2501BCBF8D1D678B872A121")
    
void ackReceived(SIPRequest sipRequest) {

        // Suppress retransmission of the final response
        if (this.ackSeen)
            return;
        SIPServerTransaction tr = this.getInviteTransaction();
        if (tr != null) {
            if (tr.getCSeq() == sipRequest.getCSeq().getSeqNumber()) {
            	acquireTimerTaskSem();
            	try {
	                if (this.timerTask != null) {                	                	
	                	this.timerTask.cancel();
		                this.timerTask = null;                	
	                }
            	} finally {
            		releaseTimerTaskSem();
            	}
                this.ackSeen = true;
                if (this.dialogDeleteTask != null) {
                    this.dialogDeleteTask.cancel();
                    this.dialogDeleteTask = null;
                }
                this.setLastAckReceived(sipRequest);
                if (sipStack.isLoggingEnabled()) {
                    sipStack.getStackLogger().logDebug(
                            "ackReceived for " + ((SIPTransaction) tr).getMethod());
                    this.ackLine = sipStack.getStackLogger().getLineCount();
                    this.printDebugInfo();
                }
                if (this.isBackToBackUserAgent) {
                    this.releaseAckSem();
                }
                this.setState(CONFIRMED_STATE);
            }
        }
    }

    /**
     * Return true if a terminated event was delivered to the application as a result of the
     * dialog termination.
     * 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.453 -0500", hash_original_method = "76BE8FDE36BAF0086F9828D261C3B7B9", hash_generated_method = "89A0EA0F4EC0324074E4DA97776F9D16")
    
synchronized boolean testAndSetIsDialogTerminatedEventDelivered() {
        boolean retval = this.dialogTerminatedEventDelivered;
        this.dialogTerminatedEventDelivered = true;
        return retval;
    }

    // /////////////////////////////////////////////////////////
    // Public methods
    // /////////////////////////////////////////////////////////

    /**
	 * Adds a new event listener to this dialog.
	 * 
	 * @param newListener
	 *            Listener to add.
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.456 -0500", hash_original_method = "6AC129F323D8E39FC544B245C2D3A08C", hash_generated_method = "7C3043EDFD4D4BCCA7DB4EB0E5ABAEF5")
    
public void addEventListener(SIPDialogEventListener newListener) {
		eventListeners.add(newListener);
	}

	/**
	 * Removed an event listener from this dialog.
	 * 
	 * @param oldListener
	 *            Listener to remove.
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.459 -0500", hash_original_method = "7D9E11919812D827506D2E4A9106FF10", hash_generated_method = "5E8D797A1FD11876E4CCC140AF6F7062")
    
public void removeEventListener(SIPDialogEventListener oldListener) {
		eventListeners.remove(oldListener);
	}
    
    /*
     * @see javax.sip.Dialog#setApplicationData()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.461 -0500", hash_original_method = "552E0456C33D24CD63C8EBCDAC1D019B", hash_generated_method = "801F39B66BF2D8C554DCF3937EA2F8CE")
    
public void setApplicationData(Object applicationData) {
        this.applicationData = applicationData;
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.sip.Dialog#getApplicationData()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.464 -0500", hash_original_method = "5F924FC61375970A4DC758380BEBFF0F", hash_generated_method = "65575224A94F45AA5C180B0ED3AF02CA")
    
public Object getApplicationData() {
        return this.applicationData;
    }

    /**
     * Updates the next consumable seqno.
     * 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.467 -0500", hash_original_method = "CB5AF71091E3878E29C27274F2628D83", hash_generated_method = "A6D27B47389CE75E453374C63941561F")
    
public synchronized void requestConsumed() {
        this.nextSeqno = Long.valueOf(this.getRemoteSeqNumber() + 1);

        if (sipStack.isLoggingEnabled()) {
            this.sipStack.getStackLogger().logDebug(
                    "Request Consumed -- next consumable Request Seqno = " + this.nextSeqno);
        }

    }

    /**
     * Return true if this request can be consumed by the dialog.
     * 
     * @param dialogRequest is the request to check with the dialog.
     * @return true if the dialogRequest sequence number matches the next consumable seqno.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.470 -0500", hash_original_method = "1E1A6C22D1982081DC74374A2FF63AAD", hash_generated_method = "35D1105224AA8AEBCEC68EBB9DF02513")
    
public synchronized boolean isRequestConsumable(SIPRequest dialogRequest) {
        // have not yet set remote seqno - this is a fresh
        if (dialogRequest.getMethod().equals(Request.ACK))
            throw new RuntimeException("Illegal method");

        // For loose validation this function is delegated to the application
        if (!this.isSequnceNumberValidation()) {
            return true;
        }

        // JvB: Acceptable iff remoteCSeq < cseq. remoteCSeq==-1
        // when not defined yet, so that works too
        return remoteSequenceNumber < dialogRequest.getCSeq().getSeqNumber();
    }

    /**
     * This method is called when a forked dialog is created from the client side. It starts a
     * timer task. If the timer task expires before an ACK is sent then the dialog is cancelled
     * (i.e. garbage collected ).
     * 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.472 -0500", hash_original_method = "45E0951257A8FCCA68182E75CB3B0E3E", hash_generated_method = "FAC3555792150861C9423F9EE58DE81D")
    
public void doDeferredDelete() {
        if (sipStack.getTimer() == null)
            this.setState(TERMINATED_STATE);
        else {
            this.dialogDeleteTask = new DialogDeleteTask();
            // Delete the transaction after the max ack timeout.
            sipStack.getTimer().schedule(this.dialogDeleteTask,
                    SIPTransaction.TIMER_H * SIPTransactionStack.BASE_TIMER_INTERVAL);
        }

    }

    /**
     * Set the state for this dialog.
     * 
     * @param state is the state to set for the dialog.
     */

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.475 -0500", hash_original_method = "DBF870542E6B78326B5509C5A5BAD885", hash_generated_method = "9C661A869FDF81F84E21EE42751448BC")
    
public void setState(int state) {
        if (sipStack.isLoggingEnabled()) {
            sipStack.getStackLogger().logDebug(
                    "Setting dialog state for " + this + "newState = " + state);
            sipStack.getStackLogger().logStackTrace();
            if (state != NULL_STATE && state != this.dialogState)
                if (sipStack.isLoggingEnabled()) {
                    sipStack.getStackLogger().logDebug(
                            this + "  old dialog state is " + this.getState());
                    sipStack.getStackLogger().logDebug(
                            this + "  New dialog state is " + DialogState.getObject(state));
                }

        }
        this.dialogState = state;
        // Dialog is in terminated state set it up for GC.
        if (state == TERMINATED_STATE) {
            if (sipStack.getTimer() != null) { // may be null after shutdown
                sipStack.getTimer().schedule(new LingerTimer(), DIALOG_LINGER_TIME * 1000);
            }
            this.stopTimer();

        }
    }

    /**
     * Debugging print for the dialog.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.479 -0500", hash_original_method = "030EEF9CE7E1904041534ED4E8E41515", hash_generated_method = "34F509E9B318B1DBF822D35AD23B374F")
    
public void printDebugInfo() {
        if (sipStack.isLoggingEnabled()) {
            sipStack.getStackLogger().logDebug("isServer = " + isServer());
            sipStack.getStackLogger().logDebug("localTag = " + getLocalTag());
            sipStack.getStackLogger().logDebug("remoteTag = " + getRemoteTag());
            sipStack.getStackLogger().logDebug("localSequenceNumer = " + getLocalSeqNumber());
            sipStack.getStackLogger().logDebug("remoteSequenceNumer = " + getRemoteSeqNumber());
            sipStack.getStackLogger().logDebug("ackLine:" + this.getRemoteTag() + " " + ackLine);
        }
    }

    /**
     * Return true if the dialog has already seen the ack.
     * 
     * @return flag that records if the ack has been seen.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.481 -0500", hash_original_method = "1550A0F77E6D4005059B99263F67738A", hash_generated_method = "A6A00D60930B4FA389EF13900687A266")
    
public boolean isAckSeen() {
        return this.ackSeen;
    }

    /**
     * Get the last ACK for this transaction.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.484 -0500", hash_original_method = "B546264B9F955F6D37CCFB381DE1D848", hash_generated_method = "4EAF0C07DF4E137689F005EE159B4A97")
    
public SIPRequest getLastAckSent() {
        return this.lastAckSent;
    }

    /**
     * Return true if ACK was sent ( for client tx ). For server tx, this is a NO-OP ( we dont
     * send ACK).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.487 -0500", hash_original_method = "3A1F0F9E8BFDA328E094E225E007A649", hash_generated_method = "923B5C514DB34D9D00FBD8F82A5ADA7A")
    
public boolean isAckSent(long cseqNo) {
        if (this.getLastTransaction() == null)
            return true;
        if (this.getLastTransaction() instanceof ClientTransaction) {
            if (this.getLastAckSent() == null) {
                return false;
            } else {
                return cseqNo <=((SIPRequest) this.getLastAckSent()).getCSeq().getSeqNumber();
            }
        } else {
            return true;
        }
    }

    /**
     * Get the transaction that created this dialog.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.489 -0500", hash_original_method = "614E8BDEDCCD12CF6A6EF62939E9BCC1", hash_generated_method = "38C00B39BC5BDFEA51D92B94432AECB8")
    
public Transaction getFirstTransaction() {
        return this.firstTransaction;
    }

    /**
     * Gets the route set for the dialog. When acting as an User Agent Server the route set MUST
     * be set to the list of URIs in the Record-Route header field from the request, taken in
     * order and preserving all URI parameters. When acting as an User Agent Client the route set
     * MUST be set to the list of URIs in the Record-Route header field from the response, taken
     * in reverse order and preserving all URI parameters. If no Record-Route header field is
     * present in the request or response, the route set MUST be set to the empty set. This route
     * set, even if empty, overrides any pre-existing route set for future requests in this
     * dialog.
     * <p>
     * Requests within a dialog MAY contain Record-Route and Contact header fields. However, these
     * requests do not cause the dialog's route set to be modified.
     * <p>
     * The User Agent Client uses the remote target and route set to build the Request-URI and
     * Route header field of the request.
     * 
     * @return an Iterator containing a list of route headers to be used for forwarding. Empty
     *         iterator is returned if route has not been established.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.492 -0500", hash_original_method = "A5E017CF1C9F9D5F5F2E302DFCC4F846", hash_generated_method = "0EF8D6351953837871F201B18628A6AF")
    
public Iterator getRouteSet() {
        if (this.routeList == null) {
            return new LinkedList().listIterator();
        } else {
            return this.getRouteList().listIterator();
        }
    }

    /**
     * Add a Route list extracted from a SIPRequest to this Dialog.
     * 
     * @param sipRequest
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.495 -0500", hash_original_method = "A8016262F3F363A84230A54DA12F1862", hash_generated_method = "E4677857B1F1A73C67639E50F28EFECF")
    
public synchronized void addRoute(SIPRequest sipRequest) {
        if (sipStack.isLoggingEnabled()) {
            sipStack.getStackLogger().logDebug(
                    "setContact: dialogState: " + this + "state = " + this.getState());
        }

        if (this.dialogState == CONFIRMED_STATE
                && SIPRequest.isTargetRefresh(sipRequest.getMethod())) {
            this.doTargetRefresh(sipRequest);
        }
        if (this.dialogState == CONFIRMED_STATE || this.dialogState == TERMINATED_STATE) {
            return;
        }
        
        // Fix for issue #225: mustn't learn Route set from mid-dialog requests
        if ( sipRequest.getToTag()!=null ) return;
        
        // Incoming Request has the route list
        RecordRouteList rrlist = sipRequest.getRecordRouteHeaders();
        // Add the route set from the incoming response in reverse
        // order
        if (rrlist != null) {
            this.addRoute(rrlist);
        } else {
            // Set the rotue list to the last seen route list.
            this.routeList = new RouteList();
        }

        // put the contact header from the incoming request into
        // the route set. JvB: some duplication here, ref. doTargetRefresh
        ContactList contactList = sipRequest.getContactHeaders();
        if (contactList != null) {
            this.setRemoteTarget((ContactHeader) contactList.getFirst());
        }
    }

    /**
     * Set the dialog identifier.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.497 -0500", hash_original_method = "7A127BC7F5926E2623990DC3EF5AF92A", hash_generated_method = "A0E7AD6A22A40546B082A87BA4E76675")
    
public void setDialogId(String dialogId) {
        this.dialogId = dialogId;
    }

    /**
     * Return true if is server.
     * 
     * @return true if is server transaction created this dialog.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.504 -0500", hash_original_method = "3F9050C9D9DA025E9AD5115049E6DBE4", hash_generated_method = "8A9885D620EF044891FFFF2CC0C43878")
    
public boolean isServer() {
        if (this.firstTransactionSeen == false)
            return this.serverTransactionFlag;
        else
            return this.firstTransactionIsServerTransaction;

    }

    /**
     * Return true if this is a re-establishment of the dialog.
     * 
     * @return true if the reInvite flag is set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.507 -0500", hash_original_method = "78570188BA83CB17A52ACDCDF5E3A80D", hash_generated_method = "3F08D34572092F7AB6792C9F52FB440B")
    
protected boolean isReInvite() {
        return this.reInviteFlag;
    }

    /**
     * Get the id for this dialog.
     * 
     * @return the string identifier for this dialog.
     * 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.510 -0500", hash_original_method = "E7B2220F30EB97BE925BA6431B089B50", hash_generated_method = "06D4C1794271A6C9184ED3A2B1345C40")
    
public String getDialogId() {

        if (this.dialogId == null && this.lastResponse != null)
            this.dialogId = this.lastResponse.getDialogId(isServer());

        return this.dialogId;
    }
    /**
     * Add a transaction record to the dialog.
     * 
     * @param transaction is the transaction to add to the dialog.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.518 -0500", hash_original_method = "5D1D12A2E6FD98502CE24F8CA665F380", hash_generated_method = "9815C0F7E268D68A617D519D01A1341F")
    
public void addTransaction(SIPTransaction transaction) {

        SIPRequest sipRequest = (SIPRequest) transaction.getOriginalRequest();

        // Proessing a re-invite.
        if (firstTransactionSeen && !firstTransactionId.equals(transaction.getBranchId()) 
                && transaction.getMethod().equals(firstTransactionMethod)) {
            this.reInviteFlag = true;
        }

        if (firstTransactionSeen == false) {
            // Record the local and remote sequenc
            // numbers and the from and to tags for future
            // use on this dialog.
        	storeFirstTransactionInfo(this, transaction);
            if (sipRequest.getMethod().equals(Request.SUBSCRIBE))
                this.eventHeader = (EventHeader) sipRequest.getHeader(EventHeader.NAME);

            this.setLocalParty(sipRequest);
            this.setRemoteParty(sipRequest);
            this.setCallId(sipRequest);
            if (this.originalRequest == null) {
                this.originalRequest = sipRequest;
            }
            if (this.method == null) {
                this.method = sipRequest.getMethod();
            }

            if (transaction instanceof SIPServerTransaction) {
                this.hisTag = sipRequest.getFrom().getTag();
                // My tag is assigned when sending response
            } else {
                setLocalSequenceNumber(sipRequest.getCSeq().getSeqNumber());
                this.originalLocalSequenceNumber = localSequenceNumber;
                this.myTag = sipRequest.getFrom().getTag();
                if (myTag == null)
                	if (sipStack.isLoggingEnabled())
                		sipStack.getStackLogger().logError(
                            "The request's From header is missing the required Tag parameter.");
            }
        } else if (transaction.getMethod().equals(firstTransactionMethod)
                && firstTransactionIsServerTransaction != transaction.isServerTransaction()) {
            // This case occurs when you are processing a re-invite.
            // Switch from client side to server side for re-invite
            // (put the other side on hold).
        	
			storeFirstTransactionInfo(this, transaction);
			
            this.setLocalParty(sipRequest);
            this.setRemoteParty(sipRequest);
            this.setCallId(sipRequest);
            this.originalRequest = sipRequest;
            this.method = sipRequest.getMethod();

        }
        if (transaction instanceof SIPServerTransaction)
            setRemoteSequenceNumber(sipRequest.getCSeq().getSeqNumber());

        // If this is a server transaction record the remote
        // sequence number to avoid re-processing of requests
        // with the same sequence number directed towards this
        // dialog.

        this.lastTransaction = transaction;
        // set a back ptr in the incoming dialog.
        // CHECKME -- why is this here?
        // transaction.setDialog(this,sipRequest);
        if (sipStack.isLoggingEnabled()) {
            sipStack.getStackLogger()
                    .logDebug("Transaction Added " + this + myTag + "/" + hisTag);
            sipStack.getStackLogger().logDebug(
                    "TID = " + transaction.getTransactionId() + "/"
                            + transaction.isServerTransaction());
            sipStack.getStackLogger().logStackTrace();
        }
    }

    /**
     * Set the remote tag.
     * 
     * @param hisTag is the remote tag to set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.521 -0500", hash_original_method = "D993372A10E82664D688CA2C725ED950", hash_generated_method = "E6DBE1E222D41BA4D53CA2AF30D51003")
    
private void setRemoteTag(String hisTag) {
        if (sipStack.isLoggingEnabled()) {
            sipStack.getStackLogger().logDebug(
                    "setRemoteTag(): " + this + " remoteTag = " + this.hisTag + " new tag = "
                            + hisTag);
        }
        if (this.hisTag != null && hisTag != null && !hisTag.equals(this.hisTag)) {
            if (this.getState() != DialogState.EARLY) {
            	if (sipStack.isLoggingEnabled())
            		sipStack.getStackLogger().logDebug(
                        "Dialog is already established -- ignoring remote tag re-assignment");
                return;
            } else if (sipStack.isRemoteTagReassignmentAllowed()) {
            	if (sipStack.isLoggingEnabled())
            		sipStack.getStackLogger().logDebug(
                        "UNSAFE OPERATION !  tag re-assignment " + this.hisTag
                                + " trying to set to " + hisTag
                                + " can cause unexpected effects ");
                boolean removed = false;
                if (this.sipStack.getDialog(dialogId) == this) {
                    this.sipStack.removeDialog(dialogId);
                    removed = true;

                }
                // Force recomputation of Dialog ID;
                this.dialogId = null;
                this.hisTag = hisTag;
                if (removed) {
                	if (sipStack.isLoggingEnabled())
                		sipStack.getStackLogger().logDebug("ReInserting Dialog");
                    this.sipStack.putDialog(this);
                }
            }
        } else {
            if (hisTag != null) {
                this.hisTag = hisTag;
            } else {
            	if (sipStack.isLoggingEnabled())
            		sipStack.getStackLogger().logWarning("setRemoteTag : called with null argument ");
            }
        }
    }

    /**
     * Get the last transaction from the dialog.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.524 -0500", hash_original_method = "6BDB0ABA2E69E3FFFE0E9E894A65FB29", hash_generated_method = "3506E6C106B7DDC484CCC28C0EE92997")
    
public SIPTransaction getLastTransaction() {
        return this.lastTransaction;
    }

    /**
     * Get the INVITE transaction (null if no invite transaction).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.528 -0500", hash_original_method = "2B80A0EDB61F41D041D4D4B21A265288", hash_generated_method = "F9C9FACC73906840C10196A8545F7470")
    
public SIPServerTransaction getInviteTransaction() {
        DialogTimerTask t = this.timerTask;
        if (t != null)
            return t.transaction;
        else
            return null;
    }

    /**
     * Set the local sequece number for the dialog (defaults to 1 when the dialog is created).
     * 
     * @param lCseq is the local cseq number.
     * 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.531 -0500", hash_original_method = "0F222FB6A793487D534C4C9D0AE37F48", hash_generated_method = "C5DF24AFA260AE2CC049D7F53DCB730B")
    
private void setLocalSequenceNumber(long lCseq) {
        if (sipStack.isLoggingEnabled())
            sipStack.getStackLogger().logDebug(
                    "setLocalSequenceNumber: original  " + this.localSequenceNumber + " new  = "
                            + lCseq);
        if (lCseq <= this.localSequenceNumber)
            throw new RuntimeException("Sequence number should not decrease !");
        this.localSequenceNumber = lCseq;
    }

    /**
     * Set the remote sequence number for the dialog.
     * 
     * @param rCseq is the remote cseq number.
     * 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.533 -0500", hash_original_method = "2CD5B084729CE62420C092F3B17E64CA", hash_generated_method = "098888BDB01E9907C3DB8F321579F47F")
    
public void setRemoteSequenceNumber(long rCseq) {
        if (sipStack.isLoggingEnabled())
            sipStack.getStackLogger().logDebug("setRemoteSeqno " + this + "/" + rCseq);
        this.remoteSequenceNumber = rCseq;
    }

    /**
     * Increment the local CSeq # for the dialog. This is useful for if you want to create a hole
     * in the sequence number i.e. route a request outside the dialog and then resume within the
     * dialog.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.535 -0500", hash_original_method = "ACC9A2408A6E532361DDB7BDD50DD489", hash_generated_method = "BBA34FF634AACE83D8EC3A15C7EA11FF")
    
public void incrementLocalSequenceNumber() {
        ++this.localSequenceNumber;
    }

    /**
     * Get the remote sequence number (for cseq assignment of outgoing requests within this
     * dialog).
     * 
     * @deprecated
     * @return local sequence number.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.538 -0500", hash_original_method = "FC2F178305D96E73603946FEBD885895", hash_generated_method = "2ABDA4CF665AEF3BC1F3075A0E31FEA2")
    
public int getRemoteSequenceNumber() {
        return (int) this.remoteSequenceNumber;
    }

    /**
     * Get the local sequence number (for cseq assignment of outgoing requests within this
     * dialog).
     * 
     * @deprecated
     * @return local sequence number.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.540 -0500", hash_original_method = "4E94621434A30379D5E2C1A949477B38", hash_generated_method = "BAA015CC9E178C4EA2C9A99097BDA9A3")
    
public int getLocalSequenceNumber() {
        return (int) this.localSequenceNumber;
    }

    /**
     * Get the sequence number for the request that origianlly created the Dialog.
     * 
     * @return -- the original starting sequence number for this dialog.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.543 -0500", hash_original_method = "6474794E57511F2FE7B2B694C3DD0A5A", hash_generated_method = "E17C879015FB37B7DFE2A9ED4AA72F12")
    
public long getOriginalLocalSequenceNumber() {
        return this.originalLocalSequenceNumber;
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.sip.Dialog#getLocalSequenceNumberLong()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.546 -0500", hash_original_method = "4D53FF8947679D063EC9104B2E34893C", hash_generated_method = "7E5E08448DB6F34197B9A01EB0E6A099")
    
public long getLocalSeqNumber() {
        return this.localSequenceNumber;
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.sip.Dialog#getRemoteSequenceNumberLong()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.548 -0500", hash_original_method = "86EC66726C4D4B16B759790B32B2EE83", hash_generated_method = "70609D0EE950A1928DA627338B8B960B")
    
public long getRemoteSeqNumber() {
        return this.remoteSequenceNumber;
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.sip.Dialog#getLocalTag()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.551 -0500", hash_original_method = "0BA81564D0817AED393E2EAE028CBF1E", hash_generated_method = "75940A99C223B12840CDF150B90E829B")
    
public String getLocalTag() {
        return this.myTag;
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.sip.Dialog#getRemoteTag()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.553 -0500", hash_original_method = "C2413781DD6AA95F52F5C21D9381D08B", hash_generated_method = "051D4D34BEBCC755C122A0EF49EC64D1")
    
public String getRemoteTag() {

        return hisTag;
    }

    /**
     * Set local tag for the transaction.
     * 
     * @param mytag is the tag to use in From headers client transactions that belong to this
     *        dialog and for generating To tags for Server transaction requests that belong to
     *        this dialog.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.556 -0500", hash_original_method = "CA511CD87985B97DC1F9ED1FACA7DA9D", hash_generated_method = "9184D5DA7C5692E639326840978214FE")
    
private void setLocalTag(String mytag) {
        if (sipStack.isLoggingEnabled()) {
            sipStack.getStackLogger().logDebug("set Local tag " + mytag + " " + this.dialogId);
            sipStack.getStackLogger().logStackTrace();
        }

        this.myTag = mytag;

    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.sip.Dialog#delete()
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.559 -0500", hash_original_method = "34B72580F00CA0B4FA87EF05393027BE", hash_generated_method = "55CABA7431C3902664D50585516CA8A6")
    
public void delete() {
        // the reaper will get him later.
        this.setState(TERMINATED_STATE);
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.sip.Dialog#getCallId()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.561 -0500", hash_original_method = "E30651442243E5536659B8D6D7E6C300", hash_generated_method = "0E5CC1D8F5B99D76033DFFF47C9A3DC4")
    
public CallIdHeader getCallId() {
        return this.callIdHeader;
    }

    /**
     * set the call id header for this dialog.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.564 -0500", hash_original_method = "4B0BBE43D23308E79DF92279003CECC0", hash_generated_method = "89D9C93F4FC035FA318A7255127BE0CA")
    
private void setCallId(SIPRequest sipRequest) {
        this.callIdHeader = sipRequest.getCallId();
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.sip.Dialog#getLocalParty()
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.566 -0500", hash_original_method = "1786A3231AA3C60CCA9E19F7DEAE30E7", hash_generated_method = "932AF2DC47253F313A89CE544C51D0D8")
    
public javax.sip.address.Address getLocalParty() {
        return this.localParty;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.569 -0500", hash_original_method = "1D3A055B19FDF32D0E14CBB9A0F366F2", hash_generated_method = "2FD11550133185AD3D2F3894FF742738")
    
private void setLocalParty(SIPMessage sipMessage) {
        if (!isServer()) {
            this.localParty = sipMessage.getFrom().getAddress();
        } else {
            this.localParty = sipMessage.getTo().getAddress();
        }
    }

    /**
     * Returns the Address identifying the remote party. This is the value of the To header of
     * locally initiated requests in this dialogue when acting as an User Agent Client.
     * <p>
     * This is the value of the From header of recieved responses in this dialogue when acting as
     * an User Agent Server.
     * 
     * @return the address object of the remote party.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.572 -0500", hash_original_method = "CA9799D7C5644CC201AAA28B1842190A", hash_generated_method = "6E07B9A8AC0D3EF2EB59C5C58CC7F46D")
    
public javax.sip.address.Address getRemoteParty() {

        if (sipStack.isLoggingEnabled()) {
            sipStack.getStackLogger().logDebug("gettingRemoteParty " + this.remoteParty);
        }
        return this.remoteParty;

    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.sip.Dialog#getRemoteTarget()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.574 -0500", hash_original_method = "5663F20A7285801454D4B2BC61212FE3", hash_generated_method = "3F2C454D76B6DA045D1E9E92816341D2")
    
public javax.sip.address.Address getRemoteTarget() {

        return this.remoteTarget;
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.sip.Dialog#getState()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.577 -0500", hash_original_method = "81C5F6A55277F5330460057DCD70CFE0", hash_generated_method = "DFE1604E1F8A330F118D7E87EEC2142D")
    
public DialogState getState() {
        if (this.dialogState == NULL_STATE)
            return null; // not yet initialized
        return DialogState.getObject(this.dialogState);
    }

    /**
     * Returns true if this Dialog is secure i.e. if the request arrived over TLS, and the
     * Request-URI contained a SIPS URI, the "secure" flag is set to TRUE.
     * 
     * @return <code>true</code> if this dialogue was established using a sips URI over TLS, and
     *         <code>false</code> otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.579 -0500", hash_original_method = "B6F2129527CFF355191EDA726B295B54", hash_generated_method = "3E5AFBD15D73C4AB7C01CBE3C61110CE")
    
public boolean isSecure() {
        return this.firstTransactionSecure;
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.sip.Dialog#sendAck(javax.sip.message.Request)
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.582 -0500", hash_original_method = "41912A3E01B6CF39F4209C49F71F74D2", hash_generated_method = "D211142595E74EECCE73FA4C2E7F2880")
    
public void sendAck(Request request) throws SipException {
        this.sendAck(request, true);
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.sip.Dialog#createRequest(java.lang.String)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.585 -0500", hash_original_method = "802F1385694BBDC717BE4DE58C3ED44B", hash_generated_method = "8442A866F5CFE298C6822F6748D3CE89")
    
public Request createRequest(String method) throws SipException {

        if (method.equals(Request.ACK) || method.equals(Request.PRACK)) {
            throw new SipException("Invalid method specified for createRequest:" + method);
        }
        if (lastResponse != null)
            return this.createRequest(method, this.lastResponse);
        else
            throw new SipException("Dialog not yet established -- no response!");
    }

    /**
     * The method that actually does the work of creating a request.
     * 
     * @param method
     * @param response
     * @return
     * @throws SipException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.590 -0500", hash_original_method = "B004628D88AAF4473352CE6B2CF39886", hash_generated_method = "F58CAB0DD2CC456758563908E1440099")
    
private Request createRequest(String method, SIPResponse sipResponse) throws SipException {
        /*
         * Check if the dialog is in the right state (RFC 3261 section 15). The caller's UA MAY
         * send a BYE for either CONFIRMED or EARLY dialogs, and the callee's UA MAY send a BYE on
         * CONFIRMED dialogs, but MUST NOT send a BYE on EARLY dialogs.
         * 
         * Throw out cancel request.
         */

        if (method == null || sipResponse == null)
            throw new NullPointerException("null argument");

        if (method.equals(Request.CANCEL))
            throw new SipException("Dialog.createRequest(): Invalid request");

        if (this.getState() == null
                || (this.getState().getValue() == TERMINATED_STATE && !method
                        .equalsIgnoreCase(Request.BYE))
                || (this.isServer() && this.getState().getValue() == EARLY_STATE && method
                        .equalsIgnoreCase(Request.BYE)))
            throw new SipException("Dialog  " + getDialogId()
                    + " not yet established or terminated " + this.getState());

        SipUri sipUri = null;
        if (this.getRemoteTarget() != null)
            sipUri = (SipUri) this.getRemoteTarget().getURI().clone();
        else {
            sipUri = (SipUri) this.getRemoteParty().getURI().clone();
            sipUri.clearUriParms();
        }

        CSeq cseq = new CSeq();
        try {
            cseq.setMethod(method);
            cseq.setSeqNumber(this.getLocalSeqNumber());
        } catch (Exception ex) {
        	if (sipStack.isLoggingEnabled())
        		sipStack.getStackLogger().logError("Unexpected error");
            InternalErrorHandler.handleException(ex);
        }
        /*
         * Add a via header for the outbound request based on the transport of the message
         * processor.
         */

        ListeningPointImpl lp = (ListeningPointImpl) this.sipProvider
                .getListeningPoint(sipResponse.getTopmostVia().getTransport());
        if (lp == null) {
            if (sipStack.isLoggingEnabled())
                sipStack.getStackLogger().logError(
                        "Cannot find listening point for transport "
                                + sipResponse.getTopmostVia().getTransport());
            throw new SipException("Cannot find listening point for transport "
                    + sipResponse.getTopmostVia().getTransport());
        }
        Via via = lp.getViaHeader();

        From from = new From();
        from.setAddress(this.localParty);
        To to = new To();
        to.setAddress(this.remoteParty);
        SIPRequest sipRequest = sipResponse.createRequest(sipUri, via, cseq, from, to);

        /*
         * The default contact header is obtained from the provider. The application can override
         * this.
         * 
         * JvB: Should only do this for target refresh requests, ie not for BYE, PRACK, etc
         */

        if (SIPRequest.isTargetRefresh(method)) {
            ContactHeader contactHeader = ((ListeningPointImpl) this.sipProvider
                    .getListeningPoint(lp.getTransport())).createContactHeader();

            ((SipURI) contactHeader.getAddress().getURI()).setSecure(this.isSecure());
            sipRequest.setHeader(contactHeader);
        }

        try {
            /*
             * Guess of local sequence number - this is being re-set when the request is actually
             * dispatched
             */
            cseq = (CSeq) sipRequest.getCSeq();
            cseq.setSeqNumber(this.localSequenceNumber + 1);

        } catch (InvalidArgumentException ex) {
            InternalErrorHandler.handleException(ex);
        }

        if (method.equals(Request.SUBSCRIBE)) {

            if (eventHeader != null)
                sipRequest.addHeader(eventHeader);

        }

        /*
         * RFC3261, section 12.2.1.1:
         * 
         * The URI in the To field of the request MUST be set to the remote URI from the dialog
         * state. The tag in the To header field of the request MUST be set to the remote tag of
         * the dialog ID. The From URI of the request MUST be set to the local URI from the dialog
         * state. The tag in the From header field of the request MUST be set to the local tag of
         * the dialog ID. If the value of the remote or local tags is null, the tag parameter MUST
         * be omitted from the To or From header fields, respectively.
         */

        try {
            if (this.getLocalTag() != null) {
                from.setTag(this.getLocalTag());
            } else {
                from.removeTag();
            }
            if (this.getRemoteTag() != null) {
                to.setTag(this.getRemoteTag());
            } else {
                to.removeTag();
            }
        } catch (ParseException ex) {
            InternalErrorHandler.handleException(ex);
        }

        // get the route list from the dialog.
        this.updateRequest(sipRequest);

        return sipRequest;

    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.sip.Dialog#sendRequest(javax.sip.ClientTransaction)
     */

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.592 -0500", hash_original_method = "9C360B0CF1AC53C036709107CECBBC75", hash_generated_method = "BE7C133DDD41440892491C455396F867")
    
public void sendRequest(ClientTransaction clientTransactionId)
            throws TransactionDoesNotExistException, SipException {
        this.sendRequest(clientTransactionId, !this.isBackToBackUserAgent);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.599 -0500", hash_original_method = "E90E816BF2167876B04C570AAB507565", hash_generated_method = "309148C30B0F5D36A5DEEC1FC8BB9BE8")
    
public void sendRequest(ClientTransaction clientTransactionId, boolean allowInterleaving)
            throws TransactionDoesNotExistException, SipException {

        if ( (!allowInterleaving)
                && clientTransactionId.getRequest().getMethod().equals(Request.INVITE)) {
            new Thread((new ReInviteSender(clientTransactionId))).start();
            return;
        }

        SIPRequest dialogRequest = ((SIPClientTransaction) clientTransactionId)
                .getOriginalRequest();

        if (sipStack.isLoggingEnabled())
            sipStack.getStackLogger().logDebug(
                    "dialog.sendRequest " + " dialog = " + this + "\ndialogRequest = \n"
                            + dialogRequest);

        if (clientTransactionId == null)
            throw new NullPointerException("null parameter");

        if (dialogRequest.getMethod().equals(Request.ACK)
                || dialogRequest.getMethod().equals(Request.CANCEL))
            throw new SipException("Bad Request Method. " + dialogRequest.getMethod());

        // JvB: added, allow re-sending of BYE after challenge
        if (byeSent && isTerminatedOnBye() && !dialogRequest.getMethod().equals(Request.BYE)) {
            if (sipStack.isLoggingEnabled())
                sipStack.getStackLogger().logError("BYE already sent for " + this);
            throw new SipException("Cannot send request; BYE already sent");
        }

        if (dialogRequest.getTopmostVia() == null) {
            Via via = ((SIPClientTransaction) clientTransactionId).getOutgoingViaHeader();
            dialogRequest.addHeader(via);
        }
        if (!this.getCallId().getCallId().equalsIgnoreCase(dialogRequest.getCallId().getCallId())) {

            if (sipStack.isLoggingEnabled()) {
                sipStack.getStackLogger().logError("CallID " + this.getCallId());
                sipStack.getStackLogger().logError(
                        "RequestCallID = " + dialogRequest.getCallId().getCallId());
                sipStack.getStackLogger().logError("dialog =  " + this);
            }
            throw new SipException("Bad call ID in request");
        }

        // Set the dialog back pointer.
        ((SIPClientTransaction) clientTransactionId).setDialog(this, this.dialogId);

        this.addTransaction((SIPTransaction) clientTransactionId);
        // Enable the retransmission filter for the transaction

        ((SIPClientTransaction) clientTransactionId).isMapped = true;

        From from = (From) dialogRequest.getFrom();
        To to = (To) dialogRequest.getTo();

        // Caller already did the tag assignment -- check to see if the
        // tag assignment is OK.
        if (this.getLocalTag() != null && from.getTag() != null
                && !from.getTag().equals(this.getLocalTag()))
            throw new SipException("From tag mismatch expecting  " + this.getLocalTag());

        if (this.getRemoteTag() != null && to.getTag() != null
                && !to.getTag().equals(this.getRemoteTag())) {
        	if (sipStack.isLoggingEnabled())
        		this.sipStack.getStackLogger().logWarning(
                    "To header tag mismatch expecting " + this.getRemoteTag());
        }
        /*
         * The application is sending a NOTIFY before sending the response of the dialog.
         */
        if (this.getLocalTag() == null && dialogRequest.getMethod().equals(Request.NOTIFY)) {
            if (!this.getMethod().equals(Request.SUBSCRIBE))
                throw new SipException("Trying to send NOTIFY without SUBSCRIBE Dialog!");
            this.setLocalTag(from.getTag());

        }

        try {
            if (this.getLocalTag() != null)
                from.setTag(this.getLocalTag());
            if (this.getRemoteTag() != null)
                to.setTag(this.getRemoteTag());

        } catch (ParseException ex) {

            InternalErrorHandler.handleException(ex);

        }

        Hop hop = ((SIPClientTransaction) clientTransactionId).getNextHop();
        if (sipStack.isLoggingEnabled()) {
            sipStack.getStackLogger().logDebug(
                    "Using hop = " + hop.getHost() + " : " + hop.getPort());
        }

        try {
            MessageChannel messageChannel = sipStack.createRawMessageChannel(this
                    .getSipProvider().getListeningPoint(hop.getTransport()).getIPAddress(),
                    this.firstTransactionPort, hop);
            
            MessageChannel oldChannel = ((SIPClientTransaction) 
            		clientTransactionId).getMessageChannel();

            // Remove this from the connection cache if it is in the
            // connection
            // cache and is not yet active.
            oldChannel.uncache();

            // Not configured to cache client connections.
            if (!sipStack.cacheClientConnections) {
                oldChannel.useCount--;
                if (sipStack.isLoggingEnabled())
                    sipStack.getStackLogger().logDebug(
                            "oldChannel: useCount " + oldChannel.useCount);

            }

            if (messageChannel == null) {
                /*
                 * At this point the procedures of 8.1.2 and 12.2.1.1 of RFC3261 have been tried
                 * but the resulting next hop cannot be resolved (recall that the exception thrown
                 * is caught and ignored in SIPStack.createMessageChannel() so we end up here with
                 * a null messageChannel instead of the exception handler below). All else
                 * failing, try the outbound proxy in accordance with 8.1.2, in particular: This
                 * ensures that outbound proxies that do not add Record-Route header field values
                 * will drop out of the path of subsequent requests. It allows endpoints that
                 * cannot resolve the first Route URI to delegate that task to an outbound proxy.
                 * 
                 * if one considers the 'first Route URI' of a request constructed according to
                 * 12.2.1.1 to be the request URI when the route set is empty.
                 */
                if (sipStack.isLoggingEnabled())
                    sipStack.getStackLogger().logDebug(
                            "Null message channel using outbound proxy !");
                Hop outboundProxy = sipStack.getRouter(dialogRequest).getOutboundProxy();
                if (outboundProxy == null)
                    throw new SipException("No route found! hop=" + hop);
                messageChannel = sipStack.createRawMessageChannel(this.getSipProvider()
                        .getListeningPoint(outboundProxy.getTransport()).getIPAddress(),
                        this.firstTransactionPort, outboundProxy);
                if (messageChannel != null)
                    ((SIPClientTransaction) clientTransactionId)
                            .setEncapsulatedChannel(messageChannel);
            } else {
                ((SIPClientTransaction) clientTransactionId)
                        .setEncapsulatedChannel(messageChannel);

                if (sipStack.isLoggingEnabled()) {
                    sipStack.getStackLogger().logDebug("using message channel " + messageChannel);

                }

            }

            if (messageChannel != null) messageChannel.useCount++;
            
            // See if we need to release the previously mapped channel.
            if ((!sipStack.cacheClientConnections) && oldChannel != null
                    && oldChannel.useCount <= 0)
                oldChannel.close();            
        } catch (Exception ex) {
            if (sipStack.isLoggingEnabled())
                sipStack.getStackLogger().logException(ex);
            throw new SipException("Could not create message channel", ex);
        }

        try {
            // Increment before setting!!
            localSequenceNumber++;
            dialogRequest.getCSeq().setSeqNumber(getLocalSeqNumber());
        } catch (InvalidArgumentException ex) {
            sipStack.getStackLogger().logFatalError(ex.getMessage());
        }

        try {
            ((SIPClientTransaction) clientTransactionId).sendMessage(dialogRequest);
            /*
             * Note that if the BYE is rejected then the Dialog should bo back to the ESTABLISHED
             * state so we only set state after successful send.
             */
            if (dialogRequest.getMethod().equals(Request.BYE)) {
                this.byeSent = true;
                /*
                 * Dialog goes into TERMINATED state as soon as BYE is sent. ISSUE 182.
                 */
                if (isTerminatedOnBye()) {
                    this.setState(DialogState._TERMINATED);
                }
            }
        } catch (IOException ex) {
            throw new SipException("error sending message", ex);
        }

    }

    /**
     * Return yes if the last response is to be retransmitted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.602 -0500", hash_original_method = "BB6E18DBBED43A4BEB60B225A721A13E", hash_generated_method = "7103C6B66DFFFE020479B9B82737731A")
    
private boolean toRetransmitFinalResponse(int T2) {
        if (--retransmissionTicksLeft == 0) {
            if (2 * prevRetransmissionTicks <= T2)
                this.retransmissionTicksLeft = 2 * prevRetransmissionTicks;
            else
                this.retransmissionTicksLeft = prevRetransmissionTicks;
            this.prevRetransmissionTicks = retransmissionTicksLeft;
            return true;
        } else
            return false;

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.605 -0500", hash_original_method = "085350C5B4F086D4A04022EDF074C477", hash_generated_method = "EFA88925873216E1FFB8AE9F196564BC")
    
protected void setRetransmissionTicks() {
        this.retransmissionTicksLeft = 1;
        this.prevRetransmissionTicks = 1;
    }

    /**
     * Resend the last ack.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.608 -0500", hash_original_method = "9B2F4C7AC7E3D2DC3FE02C5A18455E2B", hash_generated_method = "8F51775A76902E195D62404B13C84DFB")
    
public void resendAck() throws SipException {
        // Check for null.

        if (this.getLastAckSent() != null) {
            if (getLastAckSent().getHeader(TimeStampHeader.NAME) != null
                    && sipStack.generateTimeStampHeader) {
                TimeStamp ts = new TimeStamp();
                try {
                    ts.setTimeStamp(System.currentTimeMillis());
                    getLastAckSent().setHeader(ts);
                } catch (InvalidArgumentException e) {

                }
            }
            this.sendAck(getLastAckSent(), false);
        }

    }

    /**
     * Get the method of the request/response that resulted in the creation of the Dialog.
     * 
     * @return -- the method of the dialog.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.611 -0500", hash_original_method = "691C5451C67574E660997BC2056A5F23", hash_generated_method = "2D25ACB20A39A0DD4CC7AA6A07464E9B")
    
public String getMethod() {
        // Method of the request or response used to create this dialog
        return this.method;
    }

    /**
     * Start the dialog timer.
     * 
     * @param transaction
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.614 -0500", hash_original_method = "1E91804F8A3049A9C15BCD340F87DF5D", hash_generated_method = "2D7EC2CD6623089BA35F75339EF4DD6A")
    
protected void startTimer(SIPServerTransaction transaction) {
        if (this.timerTask != null && timerTask.transaction == transaction) {
        	if (sipStack.isLoggingEnabled())
        		sipStack.getStackLogger().logDebug("Timer already running for " + getDialogId());
            return;
        }
        if (sipStack.isLoggingEnabled())
            sipStack.getStackLogger().logDebug("Starting dialog timer for " + getDialogId());
        this.ackSeen = false;
        
		acquireTimerTaskSem();
		try {
	        if (this.timerTask != null) {
	            this.timerTask.transaction = transaction;
	        } else {
	            this.timerTask = new DialogTimerTask(transaction);
	            sipStack.getTimer().schedule(timerTask, SIPTransactionStack.BASE_TIMER_INTERVAL,
	                    SIPTransactionStack.BASE_TIMER_INTERVAL);
	        }
		} finally {
			releaseTimerTaskSem();
		}
        
        this.setRetransmissionTicks();
    }

    /**
     * Stop the dialog timer. This is called when the dialog is terminated.
     * 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.617 -0500", hash_original_method = "3E7472F910A577F9E6FCB71153FF16E3", hash_generated_method = "B67DF54C538B41794E04A6B32AF0573D")
    
protected void stopTimer() {
        try {
        	acquireTimerTaskSem();
        	try {
	            if (this.timerTask != null) {            	
	            	this.timerTask.cancel();
		            this.timerTask = null;
	            }   
        	} finally {
        		releaseTimerTaskSem();
        	}
        } catch (Exception ex) {
        }
    }

    /*
     * (non-Javadoc) Retransmissions of the reliable provisional response cease when a matching
     * PRACK is received by the UA core. PRACK is like any other request within a dialog, and the
     * UAS core processes it according to the procedures of Sections 8.2 and 12.2.2 of RFC 3261. A
     * matching PRACK is defined as one within the same dialog as the response, and whose method,
     * CSeq-num, and response-num in the RAck header field match, respectively, the method from
     * the CSeq, the sequence number from the CSeq, and the sequence number from the RSeq of the
     * reliable provisional response.
     * 
     * @see javax.sip.Dialog#createPrack(javax.sip.message.Response)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.620 -0500", hash_original_method = "B99416CED2F5EC9B5AF4977F926F9FAE", hash_generated_method = "7EEDA3D019FCC15E6A236ADF836E777C")
    
public Request createPrack(Response relResponse) throws DialogDoesNotExistException,
            SipException {

        if (this.getState() == null || this.getState().equals(DialogState.TERMINATED))
            throw new DialogDoesNotExistException("Dialog not initialized or terminated");

        if ((RSeq) relResponse.getHeader(RSeqHeader.NAME) == null) {
            throw new SipException("Missing RSeq Header");
        }

        try {
            SIPResponse sipResponse = (SIPResponse) relResponse;
            SIPRequest sipRequest = (SIPRequest) this.createRequest(Request.PRACK,
                    (SIPResponse) relResponse);
            String toHeaderTag = sipResponse.getTo().getTag();
            sipRequest.setToTag(toHeaderTag);
            RAck rack = new RAck();
            RSeq rseq = (RSeq) relResponse.getHeader(RSeqHeader.NAME);
            rack.setMethod(sipResponse.getCSeq().getMethod());
            rack.setCSequenceNumber((int) sipResponse.getCSeq().getSeqNumber());
            rack.setRSequenceNumber(rseq.getSeqNumber());
            sipRequest.setHeader(rack);
            return (Request) sipRequest;
        } catch (Exception ex) {
            InternalErrorHandler.handleException(ex);
            return null;
        }

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.623 -0500", hash_original_method = "AE874CF06DEDE92D6543D8F7D52B6043", hash_generated_method = "DEAC41E80A0CB58F87A1C1A4387CE098")
    
private void updateRequest(SIPRequest sipRequest) {

        RouteList rl = this.getRouteList();
        if (rl.size() > 0) {
            sipRequest.setHeader(rl);
        } else {
            sipRequest.removeHeader(RouteHeader.NAME);
        }
        if (MessageFactoryImpl.getDefaultUserAgentHeader() != null) {
            sipRequest.setHeader(MessageFactoryImpl.getDefaultUserAgentHeader());
        }

    }

    /*
     * (non-Javadoc) The UAC core MUST generate an ACK request for each 2xx received from the
     * transaction layer. The header fields of the ACK are constructed in the same way as for any
     * request sent within a dialog (see Section 12) with the exception of the CSeq and the header
     * fields related to authentication. The sequence number of the CSeq header field MUST be the
     * same as the INVITE being acknowledged, but the CSeq method MUST be ACK. The ACK MUST
     * contain the same credentials as the INVITE. If the 2xx contains an offer (based on the
     * rules above), the ACK MUST carry an answer in its body. If the offer in the 2xx response is
     * not acceptable, the UAC core MUST generate a valid answer in the ACK and then send a BYE
     * immediately.
     * 
     * Note that for the case of forked requests, you can create multiple outgoing invites each
     * with a different cseq and hence you need to supply the invite.
     * 
     * @see javax.sip.Dialog#createAck(long)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.629 -0500", hash_original_method = "8ECB2239C30E6B6F2CF5AEE7662DC317", hash_generated_method = "129E9FF47713E1821BC26A4F445566E2")
    
public Request createAck(long cseqno) throws InvalidArgumentException, SipException {

        // JvB: strictly speaking it is allowed to start a dialog with
        // SUBSCRIBE,
        // then send INVITE+ACK later on
        if (!method.equals(Request.INVITE))
            throw new SipException("Dialog was not created with an INVITE" + method);

        if (cseqno <= 0)
            throw new InvalidArgumentException("bad cseq <= 0 ");
        else if (cseqno > ((((long) 1) << 32) - 1))
            throw new InvalidArgumentException("bad cseq > " + ((((long) 1) << 32) - 1));

        if (this.remoteTarget == null) {
            throw new SipException("Cannot create ACK - no remote Target!");
        }

        if (this.sipStack.isLoggingEnabled()) {
            this.sipStack.getStackLogger().logDebug("createAck " + this + " cseqno " + cseqno);
        }

        // MUST ack in the same order that the OKs were received. This traps
        // out of order ACK sending. Old ACKs seqno's can always be ACKed.
        if (lastInviteOkReceived < cseqno) {
        	if (sipStack.isLoggingEnabled()) {
        		this.sipStack.getStackLogger().logDebug(
                    "WARNING : Attempt to crete ACK without OK " + this);
            	this.sipStack.getStackLogger().logDebug("LAST RESPONSE = " + this.lastResponse);
        	}
            throw new SipException("Dialog not yet established -- no OK response!");
        }

        try {

            // JvB: Transport from first entry in route set, or remote Contact
            // if none
            // Only used to find correct LP & create correct Via
            SipURI uri4transport = null;

            if (this.routeList != null && !this.routeList.isEmpty()) {
                Route r = (Route) this.routeList.getFirst();
                uri4transport = ((SipURI) r.getAddress().getURI());
            } else { // should be !=null, checked above
                uri4transport = ((SipURI) this.remoteTarget.getURI());
            }

            String transport = uri4transport.getTransportParam();
            if (transport == null) {
                // JvB fix: also support TLS
                transport = uri4transport.isSecure() ? ListeningPoint.TLS : ListeningPoint.UDP;
            }
            ListeningPointImpl lp = (ListeningPointImpl) sipProvider.getListeningPoint(transport);
            if (lp == null) {
            	if (sipStack.isLoggingEnabled()) {
            		sipStack.getStackLogger().logError(
                        "remoteTargetURI " + this.remoteTarget.getURI());
                	sipStack.getStackLogger().logError("uri4transport = " + uri4transport);
                	sipStack.getStackLogger().logError("No LP found for transport=" + transport);
            	}
                throw new SipException(
                        "Cannot create ACK - no ListeningPoint for transport towards next hop found:"
                                + transport);
            }
            SIPRequest sipRequest = new SIPRequest();
            sipRequest.setMethod(Request.ACK);
            sipRequest.setRequestURI((SipUri) getRemoteTarget().getURI().clone());
            sipRequest.setCallId(this.callIdHeader);
            sipRequest.setCSeq(new CSeq(cseqno, Request.ACK));
            List<Via> vias = new ArrayList<Via>();
            // Via via = lp.getViaHeader();
            // The user may have touched the sentby for the response.
            // so use the via header extracted from the response for the ACK =>
            // https://jain-sip.dev.java.net/issues/show_bug.cgi?id=205
            // strip the params from the via of the response and use the params from the
            // original request
            Via via = this.lastResponse.getTopmostVia();
            via.removeParameters();
            if (originalRequest != null && originalRequest.getTopmostVia() != null) {
                NameValueList originalRequestParameters = originalRequest.getTopmostVia()
                        .getParameters();
                if (originalRequestParameters != null && originalRequestParameters.size() > 0) {
                    via.setParameters((NameValueList) originalRequestParameters.clone());
                }
            }
            via.setBranch(Utils.getInstance().generateBranchId()); // new branch
            vias.add(via);
            sipRequest.setVia(vias);
            From from = new From();
            from.setAddress(this.localParty);
            from.setTag(this.myTag);
            sipRequest.setFrom(from);
            To to = new To();
            to.setAddress(this.remoteParty);
            if (hisTag != null)
                to.setTag(this.hisTag);
            sipRequest.setTo(to);
            sipRequest.setMaxForwards(new MaxForwards(70));

            if (this.originalRequest != null) {
                Authorization authorization = this.originalRequest.getAuthorization();
                if (authorization != null)
                    sipRequest.setHeader(authorization);
            }

            // ACKs for 2xx responses
            // use the Route values learned from the Record-Route of the 2xx
            // responses.
            this.updateRequest(sipRequest);

            return sipRequest;
        } catch (Exception ex) {
            InternalErrorHandler.handleException(ex);
            throw new SipException("unexpected exception ", ex);
        }

    }

    /**
     * Get the provider for this Dialog.
     * 
     * SPEC_REVISION
     * 
     * @return -- the SIP Provider associated with this transaction.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.631 -0500", hash_original_method = "225E26F17D14C81F6F76A7525B288E82", hash_generated_method = "BD31DD71B9C91C70D69CDDD980029B47")
    
public SipProviderImpl getSipProvider() {
        return this.sipProvider;
    }

    /**
     * @param sipProvider the sipProvider to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.634 -0500", hash_original_method = "8A8245F47D42BA43478E00CC55ABA836", hash_generated_method = "EB97AE7392CDEE158AA2BD31D2689EED")
    
public void setSipProvider(SipProviderImpl sipProvider) {
        this.sipProvider = sipProvider;
    }

    /**
     * Check the tags of the response against the tags of the Dialog. Return true if the respnse
     * matches the tags of the dialog. We do this check wehn sending out a response.
     * 
     * @param sipResponse -- the response to check.
     * 
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.637 -0500", hash_original_method = "CF7951DD9E6C51606E8031643391B018", hash_generated_method = "636D99CACE3C026439AFBD0AFC4A9223")
    
public void setResponseTags(SIPResponse sipResponse) {
        if (this.getLocalTag() != null || this.getRemoteTag() != null) {
            return;
        }
        String responseFromTag = sipResponse.getFromTag();
        if ( responseFromTag != null ) {
            if (responseFromTag.equals(this.getLocalTag())) {
                sipResponse.setToTag(this.getRemoteTag());
            } else if (responseFromTag.equals(this.getRemoteTag())) {
                sipResponse.setToTag(this.getLocalTag());
            }
        } else {
        	if (sipStack.isLoggingEnabled())
        		sipStack.getStackLogger().logWarning("No from tag in response! Not RFC 3261 compatible.");
        }

    }

    /**
     * Set the last response for this dialog. This method is called for updating the dialog state
     * when a response is either sent or received from within a Dialog.
     * 
     * @param transaction -- the transaction associated with the response
     * @param sipResponse -- the last response to set.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.645 -0500", hash_original_method = "80C5F1C3A7F1BF77711B99F831173748", hash_generated_method = "214158C7BCCA40FD07DF923FB3B7377B")
    
public void setLastResponse(SIPTransaction transaction, SIPResponse sipResponse) {
        this.callIdHeader = sipResponse.getCallId();     
        int statusCode = sipResponse.getStatusCode();
        if (statusCode == 100) {
        	if (sipStack.isLoggingEnabled())
        		sipStack.getStackLogger().logWarning(
                    "Invalid status code - 100 in setLastResponse - ignoring");
            return;
        }

        this.lastResponse = sipResponse;
        this.setAssigned();
        // Adjust state of the Dialog state machine.
        if (sipStack.isLoggingEnabled()) {
            sipStack.getStackLogger().logDebug(
                    "sipDialog: setLastResponse:" + this + " lastResponse = "
                            + this.lastResponse.getFirstLine());
        }
        if (this.getState() == DialogState.TERMINATED) {
            if (sipStack.isLoggingEnabled()) {
                sipStack.getStackLogger().logDebug(
                        "sipDialog: setLastResponse -- dialog is terminated - ignoring ");
            }
            // Capture the OK response for later use in createAck
            // This is handy for late arriving OK's that we want to ACK.
            if (sipResponse.getCSeq().getMethod().equals(Request.INVITE) && statusCode == 200) {
               
                this.lastInviteOkReceived = Math.max(sipResponse.getCSeq().getSeqNumber(),
                        this.lastInviteOkReceived);
            }
            return;
        }
        String cseqMethod = sipResponse.getCSeq().getMethod();
        if (sipStack.isLoggingEnabled()) {
            sipStack.getStackLogger().logStackTrace();
            sipStack.getStackLogger().logDebug("cseqMethod = " + cseqMethod);
            sipStack.getStackLogger().logDebug("dialogState = " + this.getState());
            sipStack.getStackLogger().logDebug("method = " + this.getMethod());
            sipStack.getStackLogger().logDebug("statusCode = " + statusCode);
            sipStack.getStackLogger().logDebug("transaction = " + transaction);
        }

        // JvB: don't use "!this.isServer" here
        // note that the transaction can be null for forked
        // responses.
        if (transaction == null || transaction instanceof ClientTransaction) {
            if (sipStack.isDialogCreated(cseqMethod)) {
                // Make a final tag assignment.
                if (getState() == null && (statusCode / 100 == 1)) {
                    /*
                     * Guard aginst slipping back into early state from confirmed state.
                     */
                    // Was (sipResponse.getToTag() != null || sipStack.rfc2543Supported)
                    setState(SIPDialog.EARLY_STATE);
                    if ((sipResponse.getToTag() != null || sipStack.rfc2543Supported)
                            && this.getRemoteTag() == null) {
                        setRemoteTag(sipResponse.getToTag());
                        this.setDialogId(sipResponse.getDialogId(false));
                        sipStack.putDialog(this);
                        this.addRoute(sipResponse);
                    }
                } else if (getState() != null && getState().equals(DialogState.EARLY)
                        && statusCode / 100 == 1) {
                    /*
                     * This case occurs for forked dialog responses. The To tag can change as a
                     * result of the forking. The remote target can also change as a result of the
                     * forking.
                     */
                    if (cseqMethod.equals(getMethod()) && transaction != null
                            && (sipResponse.getToTag() != null || sipStack.rfc2543Supported)) {
                        setRemoteTag(sipResponse.getToTag());
                        this.setDialogId(sipResponse.getDialogId(false));
                        sipStack.putDialog(this);
                        this.addRoute(sipResponse);
                    }
                } else if (statusCode / 100 == 2) {
                    // This is a dialog creating method (such as INVITE).
                    // 2xx response -- set the state to the confirmed
                    // state. To tag is MANDATORY for the response.

                    // Only do this if method equals initial request!

                    if (cseqMethod.equals(getMethod())
                            && (sipResponse.getToTag() != null || sipStack.rfc2543Supported)
                            && this.getState() != DialogState.CONFIRMED) {
                        setRemoteTag(sipResponse.getToTag());
                        this.setDialogId(sipResponse.getDialogId(false));
                        sipStack.putDialog(this);
                        this.addRoute(sipResponse);

                        setState(SIPDialog.CONFIRMED_STATE);
                    }

                    // Capture the OK response for later use in createAck
                    if (cseqMethod.equals(Request.INVITE)) {
                        this.lastInviteOkReceived = Math.max(sipResponse.getCSeq().getSeqNumber(),
                                this.lastInviteOkReceived);
                    }

                } else if (statusCode >= 300
                        && statusCode <= 699
                        && (getState() == null || (cseqMethod.equals(getMethod()) && getState()
                                .getValue() == SIPDialog.EARLY_STATE))) {
                    /*
                     * This case handles 3xx, 4xx, 5xx and 6xx responses. RFC 3261 Section 12.3 -
                     * dialog termination. Independent of the method, if a request outside of a
                     * dialog generates a non-2xx final response, any early dialogs created
                     * through provisional responses to that request are terminated.
                     */
                    setState(SIPDialog.TERMINATED_STATE);
                }

                /*
                 * This code is in support of "proxy" servers that are constructed as back to back
                 * user agents. This could be a dialog in the middle of the call setup path
                 * somewhere. Hence the incoming invite has record route headers in it. The
                 * response will have additional record route headers. However, for this dialog
                 * only the downstream record route headers matter. Ideally proxy servers should
                 * not be constructed as Back to Back User Agents. Remove all the record routes
                 * that are present in the incoming INVITE so you only have the downstream Route
                 * headers present in the dialog. Note that for an endpoint - you will have no
                 * record route headers present in the original request so the loop will not
                 * execute.
                 */
                if ( this.getState() != DialogState.CONFIRMED && this.getState() != DialogState.TERMINATED ) {
                    if (originalRequest != null) {
                        RecordRouteList rrList = originalRequest.getRecordRouteHeaders();
                        if (rrList != null) {
                            ListIterator<RecordRoute> it = rrList.listIterator(rrList.size());
                            while (it.hasPrevious()) {
                                RecordRoute rr = (RecordRoute) it.previous();
                                Route route = (Route) routeList.getFirst();
                                if (route != null && rr.getAddress().equals(route.getAddress())) {
                                    routeList.removeFirst();
                                } else
                                    break;
                            }
                        }
                    }
                }

            } else if (cseqMethod.equals(Request.NOTIFY)
                    && (this.getMethod().equals(Request.SUBSCRIBE) || this.getMethod().equals(
                            Request.REFER)) && sipResponse.getStatusCode() / 100 == 2
                    && this.getState() == null) {
                // This is a notify response.
                this.setDialogId(sipResponse.getDialogId(true));
                sipStack.putDialog(this);
                this.setState(SIPDialog.CONFIRMED_STATE);

            } else if (cseqMethod.equals(Request.BYE) && statusCode / 100 == 2
                    && isTerminatedOnBye()) {
                // Dialog will be terminated when the transction is terminated.
                setState(SIPDialog.TERMINATED_STATE);
            }
        } else {
            // Processing Server Dialog.

            if (cseqMethod.equals(Request.BYE) && statusCode / 100 == 2
                    && this.isTerminatedOnBye()) {
                /*
                 * Only transition to terminated state when 200 OK is returned for the BYE. Other
                 * status codes just result in leaving the state in COMPLETED state.
                 */
                this.setState(SIPDialog.TERMINATED_STATE);
            } else {
                boolean doPutDialog = false;

                if (getLocalTag() == null && sipResponse.getTo().getTag() != null
                        && sipStack.isDialogCreated(cseqMethod) && cseqMethod.equals(getMethod())) {
                    setLocalTag(sipResponse.getTo().getTag());

                    doPutDialog = true;
                }

                if (statusCode / 100 != 2) {
                    if (statusCode / 100 == 1) {
                        if (doPutDialog) {

                            setState(SIPDialog.EARLY_STATE);
                            this.setDialogId(sipResponse.getDialogId(true));
                            sipStack.putDialog(this);
                        }
                    } else {
                        /*
                         * RFC 3265 chapter 3.1.4.1 "Non-200 class final responses indicate that
                         * no subscription or dialog has been created, and no subsequent NOTIFY
                         * message will be sent. All non-200 class" + responses (with the
                         * exception of "489", described herein) have the same meanings and
                         * handling as described in SIP"
                         */
                        // Bug Fix by Jens tinfors
                        // see https://jain-sip.dev.java.net/servlets/ReadMsg?list=users&msgNo=797
                        if (statusCode == 489
                                && (cseqMethod.equals(Request.NOTIFY) || cseqMethod
                                        .equals(Request.SUBSCRIBE))) {
                        	if (sipStack.isLoggingEnabled())
                        		sipStack.getStackLogger().logDebug(
                                    "RFC 3265 : Not setting dialog to TERMINATED for 489");
                        } else {
                            // baranowb: simplest fix to
                            // https://jain-sip.dev.java.net/issues/show_bug.cgi?id=175
                            // application is responsible for terminating in this case
                            // see rfc 5057 for better explanation
                            if (!this.isReInvite() && getState() != DialogState.CONFIRMED) {
                                this.setState(SIPDialog.TERMINATED_STATE);
                            }
                        }
                    }

                } else {

                    /*
                     * JvB: RFC4235 says that when sending 2xx on UAS side, state should move to
                     * CONFIRMED
                     */
                    if (this.dialogState <= SIPDialog.EARLY_STATE
                            && (cseqMethod.equals(Request.INVITE)
                                    || cseqMethod.equals(Request.SUBSCRIBE) || cseqMethod
                                    .equals(Request.REFER))) {
                        this.setState(SIPDialog.CONFIRMED_STATE);
                    }

                    if (doPutDialog) {
                        this.setDialogId(sipResponse.getDialogId(true));
                        sipStack.putDialog(this);
                    }
                    /*
                     * We put the dialog into the table. We must wait for ACK before re-INVITE is
                     * sent
                     */
                    if (transaction.getState() != TransactionState.TERMINATED
                            && sipResponse.getStatusCode() == Response.OK
                            && cseqMethod.equals(Request.INVITE)
                            && this.isBackToBackUserAgent) {
                            /*
                             * Acquire the flag for re-INVITE so that we cannot re-INVITE before
                             * ACK is received.
                             */
                            if (!this.takeAckSem()) {
                                if (sipStack.isLoggingEnabled()) {
                                    sipStack.getStackLogger().logDebug(
                                            "Delete dialog -- cannot acquire ackSem");
                                }
                                this.delete();
                                return;
                            }
                        
                    }
                }
            }

        }

    }

    /**
     * Start the retransmit timer.
     * 
     * @param sipServerTx -- server transaction on which the response was sent
     * @param response - response that was sent.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.648 -0500", hash_original_method = "96CF2F98DDD4CA038A3AFDF5A5247694", hash_generated_method = "9B75AEEDBF87C758BEEF2F33C2660F13")
    
public void startRetransmitTimer(SIPServerTransaction sipServerTx, Response response) {
        if (sipServerTx.getRequest().getMethod().equals(Request.INVITE)
                && response.getStatusCode() / 100 == 2) {
            this.startTimer(sipServerTx);
        }
    }

    /**
     * @return -- the last response associated with the dialog.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.651 -0500", hash_original_method = "5F3E7F6102F24C611CAB04E5AE199DBF", hash_generated_method = "FFA7C7CCB5966C616475DBF14F52C60D")
    
public SIPResponse getLastResponse() {

        return lastResponse;
    }

    /**
     * Do taget refresh dialog state updates.
     * 
     * RFC 3261: Requests within a dialog MAY contain Record-Route and Contact header fields.
     * However, these requests do not cause the dialog's route set to be modified, although they
     * may modify the remote target URI. Specifically, requests that are not target refresh
     * requests do not modify the dialog's remote target URI, and requests that are target refresh
     * requests do. For dialogs that have been established with an
     * 
     * INVITE, the only target refresh request defined is re-INVITE (see Section 14). Other
     * extensions may define different target refresh requests for dialogs established in other
     * ways.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.654 -0500", hash_original_method = "5B8AFE9B6B91DF83BE42F6862D2EF06A", hash_generated_method = "6566F84799167FB9F34667EB26111658")
    
private void doTargetRefresh(SIPMessage sipMessage) {

        ContactList contactList = sipMessage.getContactHeaders();

        /*
         * INVITE is the target refresh for INVITE dialogs. SUBSCRIBE is the target refresh for
         * subscribe dialogs from the client side. This modifies the remote target URI potentially
         */
        if (contactList != null) {

            Contact contact = (Contact) contactList.getFirst();
            this.setRemoteTarget(contact);

        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.sip.Dialog#createReliableProvisionalResponse(int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.660 -0500", hash_original_method = "DE196281E5E185EC5F05D42F6040C5AD", hash_generated_method = "90D2CE041CA715FDC3C8B3BB11AD7717")
    
public Response createReliableProvisionalResponse(int statusCode)
            throws InvalidArgumentException, SipException {

        if (!(firstTransactionIsServerTransaction)) {
            throw new SipException("Not a Server Dialog!");

        }
        /*
         * A UAS MUST NOT attempt to send a 100 (Trying) response reliably. Only provisional
         * responses numbered 101 to 199 may be sent reliably. If the request did not include
         * either a Supported or Require header field indicating this feature, the UAS MUST NOT
         * send the provisional response reliably.
         */
        if (statusCode <= 100 || statusCode > 199)
            throw new InvalidArgumentException("Bad status code ");
        SIPRequest request = this.originalRequest;
        if (!request.getMethod().equals(Request.INVITE))
            throw new SipException("Bad method");

        ListIterator<SIPHeader> list = request.getHeaders(SupportedHeader.NAME);
        if (list == null || !optionPresent(list, "100rel")) {
            list = request.getHeaders(RequireHeader.NAME);
            if (list == null || !optionPresent(list, "100rel")) {
                throw new SipException("No Supported/Require 100rel header in the request");
            }
        }

        SIPResponse response = request.createResponse(statusCode);
        /*
         * The provisional response to be sent reliably is constructed by the UAS core according
         * to the procedures of Section 8.2.6 of RFC 3261. In addition, it MUST contain a Require
         * header field containing the option tag 100rel, and MUST include an RSeq header field.
         * The value of the header field for the first reliable provisional response in a
         * transaction MUST be between 1 and 2**31 - 1. It is RECOMMENDED that it be chosen
         * uniformly in this range. The RSeq numbering space is within a single transaction. This
         * means that provisional responses for different requests MAY use the same values for the
         * RSeq number.
         */
        Require require = new Require();
        try {
            require.setOptionTag("100rel");
        } catch (Exception ex) {
            InternalErrorHandler.handleException(ex);
        }
        response.addHeader(require);
        RSeq rseq = new RSeq();
        /*
         * set an arbitrary sequence number. This is actually set when the response is sent out
         */
        rseq.setSeqNumber(1L);
        /*
         * Copy the record route headers from the request to the response ( Issue 160 ). Note that
         * other 1xx headers do not get their Record Route headers copied over but reliable
         * provisional responses do. See RFC 3262 Table 2.
         */
        RecordRouteList rrl = request.getRecordRouteHeaders();
        if (rrl != null) {
            RecordRouteList rrlclone = (RecordRouteList) rrl.clone();
            response.setHeader(rrlclone);
        }

        return response;
    }

    /**
     * Do the processing necessary for the PRACK
     * 
     * @param prackRequest
     * @return true if this is the first time the tx has seen the prack ( and hence needs to be
     *         passed up to the TU)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.664 -0500", hash_original_method = "CEB91EBD9D583AC6C7E366C7B6D0F858", hash_generated_method = "18582F0D2D575DF2975D49893451B19C")
    
public boolean handlePrack(SIPRequest prackRequest) {
        /*
         * The RAck header is sent in a PRACK request to support reliability of provisional
         * responses. It contains two numbers and a method tag. The first number is the value from
         * the RSeq header in the provisional response that is being acknowledged. The next
         * number, and the method, are copied from the CSeq in the response that is being
         * acknowledged. The method name in the RAck header is case sensitive.
         */
        if (!this.isServer()) {
            if (sipStack.isLoggingEnabled())
                sipStack.getStackLogger().logDebug("Dropping Prack -- not a server Dialog");
            return false;
        }
        SIPServerTransaction sipServerTransaction = (SIPServerTransaction) this
                .getFirstTransaction();
        SIPResponse sipResponse = sipServerTransaction.getReliableProvisionalResponse();

        if (sipResponse == null) {
            if (sipStack.isLoggingEnabled())
                sipStack.getStackLogger()
                        .logDebug("Dropping Prack -- ReliableResponse not found");
            return false;
        }

        RAck rack = (RAck) prackRequest.getHeader(RAckHeader.NAME);

        if (rack == null) {
            if (sipStack.isLoggingEnabled())
                sipStack.getStackLogger().logDebug("Dropping Prack -- rack header not found");
            return false;
        }
        CSeq cseq = (CSeq) sipResponse.getCSeq();

        if (!rack.getMethod().equals(cseq.getMethod())) {
            if (sipStack.isLoggingEnabled())
                sipStack.getStackLogger().logDebug(
                        "Dropping Prack -- CSeq Header does not match PRACK");
            return false;
        }

        if (rack.getCSeqNumberLong() != cseq.getSeqNumber()) {
            if (sipStack.isLoggingEnabled())
                sipStack.getStackLogger().logDebug(
                        "Dropping Prack -- CSeq Header does not match PRACK");
            return false;
        }

        RSeq rseq = (RSeq) sipResponse.getHeader(RSeqHeader.NAME);

        if (rack.getRSequenceNumber() != rseq.getSeqNumber()) {
            if (sipStack.isLoggingEnabled())
                sipStack.getStackLogger().logDebug(
                        "Dropping Prack -- RSeq Header does not match PRACK");
            return false;
        }

        return sipServerTransaction.prackRecieved();
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.sip.Dialog#sendReliableProvisionalResponse(javax.sip.message.Response)
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.668 -0500", hash_original_method = "333DA078CA74B6FD5F6C9544F533B1F3", hash_generated_method = "A235982F26F5B3C37ECE218F0C0680AB")
    
public void sendReliableProvisionalResponse(Response relResponse) throws SipException {
        if (!this.isServer()) {
            throw new SipException("Not a Server Dialog");
        }

        SIPResponse sipResponse = (SIPResponse) relResponse;

        if (relResponse.getStatusCode() == 100)
            throw new SipException("Cannot send 100 as a reliable provisional response");

        if (relResponse.getStatusCode() / 100 > 2)
            throw new SipException(
                    "Response code is not a 1xx response - should be in the range 101 to 199 ");

        /*
         * Do a little checking on the outgoing response.
         */
        if (sipResponse.getToTag() == null) {
            throw new SipException(
                    "Badly formatted response -- To tag mandatory for Reliable Provisional Response");
        }
        ListIterator requireList = (ListIterator) relResponse.getHeaders(RequireHeader.NAME);
        boolean found = false;

        if (requireList != null) {

            while (requireList.hasNext() && !found) {
                RequireHeader rh = (RequireHeader) requireList.next();
                if (rh.getOptionTag().equalsIgnoreCase("100rel")) {
                    found = true;
                }
            }
        }

        if (!found) {
            Require require = new Require("100rel");
            relResponse.addHeader(require);
            if (sipStack.isLoggingEnabled()) {
                sipStack.getStackLogger().logDebug(
                        "Require header with optionTag 100rel is needed -- adding one");
            }

        }

        SIPServerTransaction serverTransaction = (SIPServerTransaction) this
                .getFirstTransaction();
        /*
         * put into the dialog table before sending the response so as to avoid race condition
         * with PRACK
         */
        this.setLastResponse(serverTransaction, sipResponse);

        this.setDialogId(sipResponse.getDialogId(true));

        serverTransaction.sendReliableProvisionalResponse(relResponse);

        this.startRetransmitTimer(serverTransaction, relResponse);

    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.sip.Dialog#terminateOnBye(boolean)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.671 -0500", hash_original_method = "BF7D1FA3BFA6C180C8021919F244470C", hash_generated_method = "F195A8D4F923DD811F005EC22D3A70C2")
    
public void terminateOnBye(boolean terminateFlag) throws SipException {

        this.terminateOnBye = terminateFlag;
    }

    /**
     * Set the "assigned" flag to true. We do this when inserting the dialog into the dialog table
     * of the stack.
     * 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.674 -0500", hash_original_method = "97AA8D077ED8B88563B1FCEB7D3F7A03", hash_generated_method = "BAFCD31B2896E9E1133750277E09F9F0")
    
public void setAssigned() {
        this.isAssigned = true;
    }

    /**
     * Return true if the dialog has already been mapped to a transaction.
     * 
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.676 -0500", hash_original_method = "F8427D0E95C386EDB403D30E8B4BBEC5", hash_generated_method = "54665CBF5720C1192EBEC39AEE8AD41A")
    
public boolean isAssigned() {
        return this.isAssigned;
    }

    /**
     * Get the contact header that the owner of this dialog assigned. Subsequent Requests are
     * considered to belong to the dialog if the dialog identifier matches and the contact header
     * matches the ip address and port on which the request is received.
     * 
     * @return contact header belonging to the dialog.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.679 -0500", hash_original_method = "370EA53498504D191CA2C54D6246F992", hash_generated_method = "74126E621AF7E76F94B713BA3EE9E077")
    
public Contact getMyContactHeader() {
    	return contactHeader;
    }

    /**
     * Do the necessary processing to handle an ACK directed at this Dialog.
     * 
     * @param ackTransaction -- the ACK transaction that was directed at this dialog.
     * @return -- true if the ACK was successfully consumed by the Dialog and resulted in the
     *         dialog state being changed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.682 -0500", hash_original_method = "1F7F0E32648D183A0E0322F85F939567", hash_generated_method = "7378C5C87E4A70DA63BC52C05023B2A8")
    
public boolean handleAck(SIPServerTransaction ackTransaction) {
        SIPRequest sipRequest = ackTransaction.getOriginalRequest();

        if (isAckSeen() && getRemoteSeqNumber() == sipRequest.getCSeq().getSeqNumber()) {

            if (sipStack.isLoggingEnabled()) {
                sipStack.getStackLogger().logDebug(
                        "ACK already seen by dialog -- dropping Ack" + " retransmission");
            }
            acquireTimerTaskSem();
            try {
            	if (this.timerTask != null) {            	
	                this.timerTask.cancel();
	                this.timerTask = null;
            	} 
            } finally {
        		releaseTimerTaskSem();
        	}
            return false;
        } else if (this.getState() == DialogState.TERMINATED) {
            if (sipStack.isLoggingEnabled())
                sipStack.getStackLogger().logDebug("Dialog is terminated -- dropping ACK");
            return false;

        } else {

            /*
             * This could be a re-invite processing. check to see if the ack matches with the last
             * transaction. s
             */

            SIPServerTransaction tr = getInviteTransaction();

            SIPResponse sipResponse = (tr != null ? tr.getLastResponse() : null);

            // Idiot check for sending ACK from the wrong side!
            if (tr != null
                    && sipResponse != null
                    && sipResponse.getStatusCode() / 100 == 2
                    && sipResponse.getCSeq().getMethod().equals(Request.INVITE)
                    && sipResponse.getCSeq().getSeqNumber() == sipRequest.getCSeq()
                            .getSeqNumber()) {

                ackTransaction.setDialog(this, sipResponse.getDialogId(false));
                /*
                 * record that we already saw an ACK for this dialog.
                 */

                ackReceived(sipRequest);
                if (sipStack.isLoggingEnabled())
                	sipStack.getStackLogger().logDebug("ACK for 2XX response --- sending to TU ");
                return true;

            } else {
                /*
                 * This happens when the ACK is re-transmitted and arrives too late to be
                 * processed.
                 */

                if (sipStack.isLoggingEnabled())
                    sipStack.getStackLogger().logDebug(
                            " INVITE transaction not found  -- Discarding ACK");
                return false;
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.685 -0500", hash_original_method = "5C164F59F3DF11F779F16A5BAEE8EAC7", hash_generated_method = "5C164F59F3DF11F779F16A5BAEE8EAC7")
    
void setEarlyDialogId(String earlyDialogId) {
        this.earlyDialogId = earlyDialogId;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.687 -0500", hash_original_method = "275E7276434F5D20F41DC92B4F25BAEE", hash_generated_method = "275E7276434F5D20F41DC92B4F25BAEE")
    
String getEarlyDialogId() {
        return earlyDialogId;
    }

    /**
     * Release the semaphore for ACK processing so the next re-INVITE may proceed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.689 -0500", hash_original_method = "5A72AC369AA326C1E4BE607E2D1E31FF", hash_generated_method = "5A72AC369AA326C1E4BE607E2D1E31FF")
    
void releaseAckSem() {
        if (this.isBackToBackUserAgent) {
            if (sipStack.isLoggingEnabled()) {
                sipStack.getStackLogger().logDebug("releaseAckSem]" + this);
            }
            this.ackSem.release();
        }

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.692 -0500", hash_original_method = "75493DFA4E25D8A29CC5DF9217BF734F", hash_generated_method = "75493DFA4E25D8A29CC5DF9217BF734F")
    
boolean takeAckSem() {
        if (sipStack.isLoggingEnabled()) {
            sipStack.getStackLogger().logDebug("[takeAckSem " + this);
        }
        try {
            if (!this.ackSem.tryAcquire(2, TimeUnit.SECONDS)) {
                if (sipStack.isLoggingEnabled()) {
                    sipStack.getStackLogger().logError("Cannot aquire ACK semaphore");
                }

                if ( sipStack.isLoggingEnabled() ) {
                    sipStack.getStackLogger().logDebug("Semaphore previously acquired at " + this.stackTrace);
                    sipStack.getStackLogger().logStackTrace();
                    
                }
                return false;
            }
            
            if ( sipStack.isLoggingEnabled() ) {
                
                this.recordStackTrace();
            }
            
        } catch (InterruptedException ex) {
            sipStack.getStackLogger().logError("Cannot aquire ACK semaphore");
            return false;

        }
        return true;

    }

    /**
     * @param lastAckReceived the lastAckReceived to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.695 -0500", hash_original_method = "68D4C33CE448DB45C09F49FC9815E4FD", hash_generated_method = "19284F6BC48D53A035845DBB106A70B8")
    
private void setLastAckReceived(SIPRequest lastAckReceived) {
        this.lastAckReceived = lastAckReceived;
    }

    /**
     * @return the lastAckReceived
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.698 -0500", hash_original_method = "2894D6C9FD5402948626BDE17D2ADDA1", hash_generated_method = "4FC65EF36A8F5C848F3C3D0A5E67A987")
    
protected SIPRequest getLastAckReceived() {
        return lastAckReceived;
    }

    /**
     * @param lastAckSent the lastAckSent to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.700 -0500", hash_original_method = "AE316349F4F2DB7FF5C817D5A1FDA212", hash_generated_method = "FC2F18C3A0D1F157D404C6B383970102")
    
private void setLastAckSent(SIPRequest lastAckSent) {
        this.lastAckSent = lastAckSent;
    }
    
    /**
     * @return true if an ack was ever sent for this Dialog
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.703 -0500", hash_original_method = "2B44FD1497547940266A6934DB958355", hash_generated_method = "01DB17D4D3F46C37739550C3656870AF")
    
public boolean isAtleastOneAckSent() {
        return this.isAcknowledged;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.705 -0500", hash_original_method = "FAA2C5BC01CFE296F7D6D441890115F1", hash_generated_method = "98ED41A52001427EAF5C2993A5F3D75F")
    
public boolean isBackToBackUserAgent() {
        return this.isBackToBackUserAgent;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.708 -0500", hash_original_method = "1ECA22F9D5D81E6992181CD96CD57EA7", hash_generated_method = "0C05B9D98ADCB181135CB50845784C01")
    
public synchronized void doDeferredDeleteIfNoAckSent(long seqno) {
		if (sipStack.getTimer() == null) {
			this.setState(TERMINATED_STATE);
		} else if(dialogDeleteIfNoAckSentTask == null){
			// Delete the transaction after the max ack timeout.
			dialogDeleteIfNoAckSentTask = new DialogDeleteIfNoAckSentTask(seqno);
			sipStack.getTimer().schedule(
					dialogDeleteIfNoAckSentTask,
					SIPTransaction.TIMER_J
							* SIPTransactionStack.BASE_TIMER_INTERVAL);
		}
	}

    /*
     * (non-Javadoc)
     * @see gov.nist.javax.sip.DialogExt#setBackToBackUserAgent(boolean)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.711 -0500", hash_original_method = "782C3B034CC64F54A5BC7BB8ED6FEDA6", hash_generated_method = "8A0057C847B5BCCBBD40FECBFB52FBE8")
    
public void setBackToBackUserAgent() {
        this.isBackToBackUserAgent = true;   
    }

	/**
	 * @return the eventHeader
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.713 -0500", hash_original_method = "3A5B567A7D7C4A4D6D60D4CFA5E677D1", hash_generated_method = "3A5B567A7D7C4A4D6D60D4CFA5E677D1")
    
EventHeader getEventHeader() {
		return eventHeader;
	}

	/**
	 * @param eventHeader the eventHeader to set
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.717 -0500", hash_original_method = "C85F235E26C94FDBCE92FE9C88454CDD", hash_generated_method = "C85F235E26C94FDBCE92FE9C88454CDD")
    
void setEventHeader(EventHeader eventHeader) {
		this.eventHeader = eventHeader;
	}
    
    public class ReInviteSender implements Runnable, Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.331 -0500", hash_original_field = "4C24F42930ECFF8FD418CC9B9866E513", hash_generated_field = "85664C6B81A73D64F3D428B9B5907950")

        private static final long serialVersionUID = 1019346148741070635L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.333 -0500", hash_original_field = "E3567853C7773291F6ADDE73672244A1", hash_generated_field = "E3567853C7773291F6ADDE73672244A1")

        ClientTransaction ctx;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.340 -0500", hash_original_method = "420F244B37AE2567998EBC3FAC66EFCB", hash_generated_method = "81DE7B2752B25BBE4B4D557E982DB797")
        
public ReInviteSender(ClientTransaction ctx) {
            this.ctx = ctx;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.336 -0500", hash_original_method = "05496AD165548F09E9869029BA920071", hash_generated_method = "B1BF1F68F527E2E0EF50A535E05CBAEC")
        
public void terminate() {
            try {
                ctx.terminate();
                Thread.currentThread().interrupt();
            } catch (ObjectInUseException e) {
                sipStack.getStackLogger().logError("unexpected error", e);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.345 -0500", hash_original_method = "DA8B28F4804F3F25626961946D2074C4", hash_generated_method = "D043F10192D8BCAB569D2E9F3CB4286F")
        
public void run() {
            try {
                long timeToWait = 0;
                long startTime = System.currentTimeMillis();

                if (!SIPDialog.this.takeAckSem()) {
                    /*
                     * Could not send re-INVITE fire a timeout on the INVITE.
                     */
                	if (sipStack.isLoggingEnabled())
                		sipStack.getStackLogger().logError(
                            "Could not send re-INVITE time out ClientTransaction");
                    ((SIPClientTransaction) ctx).fireTimeoutTimer();
                    /*
                     * Send BYE to the Dialog. 
                     */
                    if ( sipProvider.getSipListener() != null && sipProvider.getSipListener() instanceof SipListenerExt ) {
                        raiseErrorEvent(SIPDialogErrorEvent.DIALOG_REINVITE_TIMEOUT);
                    } else {
                        Request byeRequest = SIPDialog.this.createRequest(Request.BYE);
                        if ( MessageFactoryImpl.getDefaultUserAgentHeader() != null ) {
                            byeRequest.addHeader(MessageFactoryImpl.getDefaultUserAgentHeader());
                        }
                        ReasonHeader reasonHeader = new Reason();
                        reasonHeader.setCause(1024);
                        reasonHeader.setText("Timed out waiting to re-INVITE");
                        byeRequest.addHeader(reasonHeader);
                        ClientTransaction byeCtx = SIPDialog.this.getSipProvider().getNewClientTransaction(byeRequest);
                        SIPDialog.this.sendRequest(byeCtx);
                        return;
                    }
                }
                if (getState() != DialogState.TERMINATED) {

                    timeToWait = System.currentTimeMillis() - startTime;
                }

                /*
                 * If we had to wait for ACK then wait for the ACK to actually get to the other
                 * side. Wait for any ACK retransmissions to finish. Then send out the request.
                 * This is a hack in support of some UA that want re-INVITEs to be spaced out in
                 * time ( else they return a 400 error code ).
                 */
                try {
                    if (timeToWait != 0) {
                        Thread.sleep(SIPDialog.this.reInviteWaitTime);
                    }
                } catch (InterruptedException ex) {
                	if (sipStack.isLoggingEnabled())
                		sipStack.getStackLogger().logDebug("Interrupted sleep");
                    return;
                }
                if (SIPDialog.this.getState() != DialogState.TERMINATED) {
                    SIPDialog.this.sendRequest(ctx, true);
                }
                if (sipStack.isLoggingEnabled())
                	sipStack.getStackLogger().logDebug("re-INVITE successfully sent");
            } catch (Exception ex) {
                sipStack.getStackLogger().logError("Error sending re-INVITE", ex);
            } finally {
                this.ctx = null;
            }
        }
    }
    
    class LingerTimer extends SIPStackTimerTask implements Serializable {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.351 -0500", hash_original_method = "FEDA9229694989A502508E95A3FCFE54", hash_generated_method = "9A5C989D699EDCDAE12BD6C589E96E98")
        
public LingerTimer() {

        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.354 -0500", hash_original_method = "CEEC3EAE1C5B12DC43D70E37F1A80A0A", hash_generated_method = "B6ADDC1E43DE3F3D56BE031105193AA0")
        
protected void runTask() {
            SIPDialog dialog = SIPDialog.this;
            if(eventListeners != null) {
            	eventListeners.clear();
            }
            timerTaskLock = null;
            sipStack.removeDialog(dialog);
        }
        
    }
    
    class DialogTimerTask extends SIPStackTimerTask implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.358 -0500", hash_original_field = "A1A6593A1DD707EE1D2696D147E58630", hash_generated_field = "A1A6593A1DD707EE1D2696D147E58630")

        int nRetransmissions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.361 -0500", hash_original_field = "9542A919750E0FF108E7D24E8ABAA715", hash_generated_field = "9542A919750E0FF108E7D24E8ABAA715")

        SIPServerTransaction transaction;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.364 -0500", hash_original_method = "99967D6CED868AEC0B4229119C79B2A3", hash_generated_method = "70FAB3C25A4E795B2F73DC834A2E6D97")
        
public DialogTimerTask(SIPServerTransaction transaction) {
            this.transaction = transaction;
            this.nRetransmissions = 0;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.368 -0500", hash_original_method = "7353CE022084912970B9E490A7F56F25", hash_generated_method = "8A5C503B19DDA1E0377E335B5FCADEDC")
        
protected void runTask() {
            // If I ACK has not been seen on Dialog,
            // resend last response.
            SIPDialog dialog = SIPDialog.this;
            if (sipStack.isLoggingEnabled())
                sipStack.getStackLogger().logDebug("Running dialog timer");
            nRetransmissions++;
            SIPServerTransaction transaction = this.transaction;
            /*
             * Issue 106. Section 13.3.1.4 RFC 3261 The 2xx response is passed to the transport
             * with an interval that starts at T1 seconds and doubles for each retransmission
             * until it reaches T2 seconds If the server retransmits the 2xx response for 64*T1
             * seconds without receiving an ACK, the dialog is confirmed, but the session SHOULD
             * be terminated.
             */

            if (nRetransmissions > 64 * SIPTransaction.T1) {
                if (sipProvider.getSipListener() != null && sipProvider.getSipListener() instanceof SipListenerExt ) {
                    raiseErrorEvent(SIPDialogErrorEvent.DIALOG_ACK_NOT_RECEIVED_TIMEOUT);
                } else  {
                    dialog.delete();
                }
                if (transaction != null
                        && transaction.getState() != javax.sip.TransactionState.TERMINATED) {
                    transaction.raiseErrorEvent(SIPTransactionErrorEvent.TIMEOUT_ERROR);  
                }
            } else if ((!dialog.ackSeen) && (transaction != null)) {
                // Retransmit to 200 until ack receivedialog.
                SIPResponse response = transaction.getLastResponse();
                if (response.getStatusCode() == 200) {
                    try {

                        // resend the last response.
                        if (dialog.toRetransmitFinalResponse(transaction.T2))
                            transaction.sendMessage(response);

                    } catch (IOException ex) {

                        raiseIOException(transaction.getPeerAddress(), transaction.getPeerPort(),
                                transaction.getPeerProtocol());

                    } finally {
                        // Need to fire the timer so
                        // transaction will eventually
                        // time out whether or not
                        // the IOException occurs
                        // Note that this firing also
                        // drives Listener timeout.
                        SIPTransactionStack stack = dialog.sipStack;
                        if (stack.isLoggingEnabled()) {
                            stack.getStackLogger().logDebug("resend 200 response from " + dialog);
                        }
                        transaction.fireTimer();
                    }
                }
            }

            // Stop running this timer if the dialog is in the
            // confirmed state or ack seen if retransmit filter on.
            if (dialog.isAckSeen() || dialog.dialogState == TERMINATED_STATE) {
                this.transaction = null;
                this.cancel();

            }

        }
        
    }
    
    class DialogDeleteTask extends SIPStackTimerTask implements Serializable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:41.463 -0400", hash_original_method = "51B842BDCF98DBC480B551988FA04041", hash_generated_method = "51B842BDCF98DBC480B551988FA04041")
        public DialogDeleteTask ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.375 -0500", hash_original_method = "705C6BB4461CC5F37E0565BB6F16C084", hash_generated_method = "F682290B7878EDF0CCE83C0602AA72EC")
        
protected void runTask() {
            delete();
        }
        
    }
    
    class DialogDeleteIfNoAckSentTask extends SIPStackTimerTask implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.380 -0500", hash_original_field = "1D94E568A884549DEEB09E95E0FD15AE", hash_generated_field = "979FF677F2C7A64909253E0B01090AEC")

        private long seqno;
   
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.383 -0500", hash_original_method = "D6D7FB77E2882EBB362E9FAF3BE7D45E", hash_generated_method = "9085E59A07DA11376AB852D56D18CD6E")
        
public DialogDeleteIfNoAckSentTask(long seqno) {
            this.seqno = seqno;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.387 -0500", hash_original_method = "47EF190411AC9DCEBDEAD83DF8BB27D9", hash_generated_method = "3DFF5DCC3DF28D09B39CA6E4103295EC")
        
protected void runTask() {
            if (SIPDialog.this.highestSequenceNumberAcknowledged < seqno) {  
                /*
                 * Did not send ACK so we need to delete the dialog.
                 * B2BUA NOTE: we may want to send BYE to the Dialog at this 
                 * point. Do we want to make this behavior tailorable?
                 */
            	dialogDeleteIfNoAckSentTask = null;
                if ( !SIPDialog.this.isBackToBackUserAgent) {
                	if (sipStack.isLoggingEnabled())
                		sipStack.getStackLogger().logError("ACK Was not sent. killing dialog");
                	if ( ((SipProviderImpl)sipProvider).getSipListener() instanceof SipListenerExt ){
                	    raiseErrorEvent(SIPDialogErrorEvent.DIALOG_ACK_NOT_SENT_TIMEOUT);
                	} else {
                	    delete();
                	}
                } else {
                	if (sipStack.isLoggingEnabled()) 
                		sipStack.getStackLogger().logError("ACK Was not sent. Sending BYE");
                	   if ( ((SipProviderImpl)sipProvider).getSipListener() instanceof SipListenerExt ){    
                	       raiseErrorEvent(SIPDialogErrorEvent.DIALOG_ACK_NOT_SENT_TIMEOUT);
                	   } else {

                        /*
                         * Send BYE to the Dialog. 
                         * This will be removed for the next spec revision.
                         */
                        try {
                            Request byeRequest = SIPDialog.this.createRequest(Request.BYE);
                            if ( MessageFactoryImpl.getDefaultUserAgentHeader() != null ) {
                                byeRequest.addHeader(MessageFactoryImpl.getDefaultUserAgentHeader());
                            }
                            ReasonHeader reasonHeader = new Reason();
                            reasonHeader.setProtocol("SIP");
                            reasonHeader.setCause(1025);
                            reasonHeader.setText("Timed out waiting to send ACK");
                            byeRequest.addHeader(reasonHeader);
                            ClientTransaction byeCtx = SIPDialog.this.getSipProvider().getNewClientTransaction(byeRequest);
                            SIPDialog.this.sendRequest(byeCtx);
                            return;
                        } catch (Exception ex) {
                            SIPDialog.this.delete();
                        }
                    }
                }
            }
        }
        
    }

	/**
	 * @param serverTransactionFlag the serverTransactionFlag to set
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.719 -0500", hash_original_method = "D178A1777AB3611D9691A3F4A69F3B06", hash_generated_method = "D178A1777AB3611D9691A3F4A69F3B06")
    
void setServerTransactionFlag(boolean serverTransactionFlag) {
		this.serverTransactionFlag = serverTransactionFlag;
	}

	/**
	 * @param reInviteFlag the reinviteFlag to set
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.722 -0500", hash_original_method = "B9FC7E5C15DF48754B63587E10ABF39E", hash_generated_method = "B9FC7E5C15DF48754B63587E10ABF39E")
    
void setReInviteFlag(boolean reInviteFlag) {
		this.reInviteFlag = reInviteFlag;
	}
  
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.724 -0500", hash_original_method = "554E3D8C2985A7B76F710766F6151401", hash_generated_method = "AF9793985F6F6FECF5448C7E675C5D63")
    
public boolean isSequnceNumberValidation() {
	    return this.sequenceNumberValidation;
	}
   
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.727 -0500", hash_original_method = "07E72D397966AE985C4FA6CA39D288C5", hash_generated_method = "39575C5AD5393A363E43D14908040F88")
    
public void disableSequenceNumberValidation() {
        this.sequenceNumberValidation = false;
    }
   
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.729 -0500", hash_original_method = "32EDC5DA45A565F7D6F42D86C325067F", hash_generated_method = "E03C20CC40F9CB3EA65DA517FF47AFD3")
    
public void acquireTimerTaskSem() {
    	boolean acquired = false;
        try {
            acquired = this.timerTaskLock.tryAcquire(10, TimeUnit.SECONDS);
        } catch ( InterruptedException ex) {
            acquired = false;
        }
        if(!acquired) {
        	throw new IllegalStateException("Impossible to acquire the dialog timer task lock");
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:24.732 -0500", hash_original_method = "7C538F01F8063281F04142649C9B2CD0", hash_generated_method = "23765FBFB84E4E8A9BAD7EAFEDF4819F")
    
public void releaseTimerTaskSem() {
        this.timerTaskLock.release();
    }
}

