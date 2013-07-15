package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.703 -0400", hash_original_field = "46C9B2C3A305D009DCA963EA55E53037", hash_generated_field = "8B7AA916EC7A88984DDF8AA52B9F1641")

    private transient boolean dialogTerminatedEventDelivered;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.703 -0400", hash_original_field = "FCD4E36FD80F450979495718DBDDAACF", hash_generated_field = "9F3F9DDDB302CE97F2E415A10FABBE2D")

    private transient String stackTrace;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.703 -0400", hash_original_field = "EA9F6ACA279138C58F705C8D4CB4B8CE", hash_generated_field = "F42F15CDE806BBAD7F26F7952D68FCE2")

    private String method;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.703 -0400", hash_original_field = "C26F5EFAA245E97571F6FC4B23DECC91", hash_generated_field = "386AD1FFF2E8BC21894EEC2B1DC5720D")

    private transient boolean isAssigned;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.703 -0400", hash_original_field = "C1EC3EDE33FAFFDB511452F99E001022", hash_generated_field = "E1B54A10C305CE35C160FA0FCCD06B96")

    private boolean reInviteFlag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.703 -0400", hash_original_field = "756C73A51ADF7F04942C8BE97A032000", hash_generated_field = "0C346A02ABD6566D7A046D5EE80C0EC0")

    private transient Object applicationData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.704 -0400", hash_original_field = "539F42CD378873BB0F9889EFF317BAFA", hash_generated_field = "AD3FCBD371406352A3E03A00BDAA3D18")

    private transient SIPRequest originalRequest;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.704 -0400", hash_original_field = "9ECD142FA67835EFBFD693D2B0EFC756", hash_generated_field = "7328CD7146ABA98BB701BDA934CF1486")

    private SIPResponse lastResponse;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.704 -0400", hash_original_field = "365BA234CE4103A64B291C10F57087FD", hash_generated_field = "4C8E3F2978B0A1967941B34B8E931926")

    private transient SIPTransaction firstTransaction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.704 -0400", hash_original_field = "EBB750D5E2AC0A12C597F9247097FE3A", hash_generated_field = "8E3DDDE2C9BBCFF0518502DA3A19B8FC")

    private transient SIPTransaction lastTransaction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.704 -0400", hash_original_field = "2EF3DE78A30BAAA37A078E077DA9C8FF", hash_generated_field = "FFD5ABB57CC8068DFE83871CA8391D63")

    private String dialogId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.704 -0400", hash_original_field = "5E278DBB57181A78536887523BDDB000", hash_generated_field = "047D72F6110028ED8614A185C3ADEE63")

    private transient String earlyDialogId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.704 -0400", hash_original_field = "DE3A634B25A226C9FC28CC0EA41F9212", hash_generated_field = "AD815FC4C870FA38840533B56E201007")

    private long localSequenceNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.704 -0400", hash_original_field = "45DD21C3FA9B2834579DDEBCBA7FDE5E", hash_generated_field = "096C078B93EFB214E2172D793F365B4D")

    private long remoteSequenceNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.704 -0400", hash_original_field = "163C6D86A43D258EE0FE3B5AC19EEB9B", hash_generated_field = "DE4FDB012317C10FCB5EE3D6596519E1")

    protected String myTag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.704 -0400", hash_original_field = "02FAD193B4B3A63F0DF3A1373D82A243", hash_generated_field = "9777EBD405E9D84F5A9D8688CA87BB34")

    protected String hisTag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.704 -0400", hash_original_field = "C433183F160826EE91E980CE55DF6B8A", hash_generated_field = "873E71D84A907B69A5D7EA40A6E98B84")

    private RouteList routeList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.704 -0400", hash_original_field = "37460D4BF2BA47A13FF9D922C4B14B2E", hash_generated_field = "648E45DA0C2D4CA0D3A6C1331273D1A8")

    private transient SIPTransactionStack sipStack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.705 -0400", hash_original_field = "9E815F1ED84873B978ADE70D5015D491", hash_generated_field = "B18AB1AD22CF960F8E3DA659D957473C")

    private int dialogState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.705 -0400", hash_original_field = "D8F45A8AC837F51166792988E4141B52", hash_generated_field = "92F226B9C77FEEDF00455BB4E4B37995")

    protected transient boolean ackSeen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.705 -0400", hash_original_field = "1653CA35CDAF1FD8B835AAB2A0098372", hash_generated_field = "5047CDCA90F6F4D08E6FCFC3504AA33A")

    private transient SIPRequest lastAckSent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.705 -0400", hash_original_field = "A2E2C0BC96483014E68E14BCA2B6829F", hash_generated_field = "0D41AA5710D910AD875D10253E3B5B7B")

    private SIPRequest lastAckReceived;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.705 -0400", hash_original_field = "5A47CDCCD7DADCBE8339DE02999F79D7", hash_generated_field = "39BFE22C217FFF2E6FD7425093780B7F")

    protected transient boolean ackProcessed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.705 -0400", hash_original_field = "804894B79B603C8794570D901AF093D4", hash_generated_field = "CCB890E772BC08D4A4B71682A75E6B57")

    protected transient DialogTimerTask timerTask;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.705 -0400", hash_original_field = "2B1914B1BDB94B6490A6024E69C1AC63", hash_generated_field = "50CA1F3CDF0B9F341970FE5A2E9968CD")

    protected transient Long nextSeqno;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.705 -0400", hash_original_field = "6D988A8035AD569D3835C3FB2E8FADD9", hash_generated_field = "357D95D41FE555F3403B8186135E948D")

    private transient int retransmissionTicksLeft;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.705 -0400", hash_original_field = "6B0B182F82159791030FD4DDF77C7D67", hash_generated_field = "FDB9FFD63AE6B4740136DBB4E840047D")

    private transient int prevRetransmissionTicks;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.705 -0400", hash_original_field = "3A3D450D6468D05390761FD1EEA48070", hash_generated_field = "AB98AAAC4EF13468E54DBE8642C5759B")

    private long originalLocalSequenceNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.705 -0400", hash_original_field = "284CCB26986C244746913731F851D61A", hash_generated_field = "D019361A8619CB9E208CC4A408868CF5")

    private transient int ackLine;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.705 -0400", hash_original_field = "C0CEB3515CA4F46A6B2A58F9563A8976", hash_generated_field = "B8AD8E741E80B25C3AEBA11833850788")

    public transient long auditTag = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.706 -0400", hash_original_field = "0491B7ABE5A57CDF01C5AF04205714CD", hash_generated_field = "5581935F145F3F50A0FF3B163F12E527")

    protected javax.sip.address.Address localParty;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.706 -0400", hash_original_field = "962BC95BC1290FCAFA045995FAE5F1E0", hash_generated_field = "039B4B6D9758816DF54E227BDD9B553B")

    protected javax.sip.address.Address remoteParty;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.706 -0400", hash_original_field = "F4E470CD8970EBBE1902E50EB09F4952", hash_generated_field = "4FB7DFE93D6674CE9A4D6470DED9D170")

    protected CallIdHeader callIdHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.706 -0400", hash_original_field = "EB27C9A1ABE6F92065F9871F11CA94DE", hash_generated_field = "66E18B86E8394598F2C548C54E34F3D8")

    private boolean serverTransactionFlag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.706 -0400", hash_original_field = "2D3F8ACEA2D147F7A52D2FA493D756C8", hash_generated_field = "58BDE3AD74EC5F605B651AEC94A1C475")

    private transient SipProviderImpl sipProvider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.706 -0400", hash_original_field = "E07EB9E73AEC54F4C343517C6319D798", hash_generated_field = "369DECFD4E296468A8EE9210A060D65B")

    private boolean terminateOnBye;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.706 -0400", hash_original_field = "354622A0C5E162C6CC6CA2314CF692C2", hash_generated_field = "024E9E66DF22C3B5E5731FC6B0083C1A")

    private transient boolean byeSent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.706 -0400", hash_original_field = "F56AF138C945E77D60FC1E857CA6ED3C", hash_generated_field = "4BFEF67A8970CE1B7ED7E72620C9AC81")

    private Address remoteTarget;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.706 -0400", hash_original_field = "F9D912BE83AE47070E860DEC06FB1BA4", hash_generated_field = "7F1ED863122BA67FB6B399180FFB61EF")

    private EventHeader eventHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.706 -0400", hash_original_field = "273FF71B50533FE65671ACDD370D0775", hash_generated_field = "25A404EC1778A9AB18E3073CD79DC005")

    private transient long lastInviteOkReceived;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.706 -0400", hash_original_field = "DA26F565CCA8C9BCABA1D6F51AA3DDB6", hash_generated_field = "043CF414B4BC114C321725D26030C925")

    private transient Semaphore ackSem = new Semaphore(1);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.706 -0400", hash_original_field = "4312EB0CC756247EAA1930550BE95F97", hash_generated_field = "8391C3AA408B5C65CA6D2DAD521FC0C6")

    private transient int reInviteWaitTime = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.707 -0400", hash_original_field = "CBA28B6F9931EA2E13D9820A8FD464DA", hash_generated_field = "671578F07EF254B77AC2D4173CF99A1A")

    private transient DialogDeleteTask dialogDeleteTask;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.707 -0400", hash_original_field = "F542E4E71711723917E3E6AE16CD8970", hash_generated_field = "B9EBB973A8692BA4C974F82BA5B997F3")

    private transient DialogDeleteIfNoAckSentTask dialogDeleteIfNoAckSentTask;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.707 -0400", hash_original_field = "26CDE53F2A363B6F09C65A5A1BE09D8A", hash_generated_field = "173A1FD238D8569297A5D30A0D2122DA")

    private transient boolean isAcknowledged;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.707 -0400", hash_original_field = "509F1D12B600B3138E1CB091EBE04C72", hash_generated_field = "19F7BD09CC9EC40661F8FE53075718B2")

    private transient long highestSequenceNumberAcknowledged = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.707 -0400", hash_original_field = "ED5DD7E8859F4FCE1BBEB3296A028766", hash_generated_field = "DA4CDB35B5056C6CA182EC98C7A0FE9B")

    private boolean isBackToBackUserAgent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.707 -0400", hash_original_field = "2B05FA302BB63D8136037DD4E39122BF", hash_generated_field = "7EEEE754C8F2FA7215F638E76C8E67E0")

    private boolean sequenceNumberValidation = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.707 -0400", hash_original_field = "FEAAE72958B4E88882F57D0164DCA2A6", hash_generated_field = "CFB0D25D7A9D3DB327E35494FC7DE9A5")

    private transient Set<SIPDialogEventListener> eventListeners;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.707 -0400", hash_original_field = "3570D6B9904467D944595544DFEA8443", hash_generated_field = "B1245AF2B94FAB1223B77DABE0E26551")

    private Semaphore timerTaskLock = new Semaphore(1);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.707 -0400", hash_original_field = "A3801CFC0CC0C9EDADB7035D96B0A52C", hash_generated_field = "D54EF62A05D422BDCA347E77C025891C")

    protected boolean firstTransactionSecure;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.707 -0400", hash_original_field = "F9F9F947ADC5F8FCF0FFE2A87E08ED9F", hash_generated_field = "68EC519F0D2EE4EB55E96608058AA384")

    protected boolean firstTransactionSeen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.707 -0400", hash_original_field = "383303C37A6BD00E4C256C602333D72B", hash_generated_field = "4D111E3CF541CDB9CD69CDF93FCEDDAC")

    protected String firstTransactionMethod;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.707 -0400", hash_original_field = "8717DD98BC5859570A4684454287E374", hash_generated_field = "DFB6058EA76D5E106C80BCA9A74A2D53")

    protected String firstTransactionId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.707 -0400", hash_original_field = "0D53979373F479A7EFA6875647AB0B78", hash_generated_field = "39C149EC307ADB72278A474A328A3BCF")

    protected boolean firstTransactionIsServerTransaction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.707 -0400", hash_original_field = "9B3271522A9E60737CFB8772E1C4861B", hash_generated_field = "801C0A281C881455A3F35F92B0224337")

    protected int firstTransactionPort = 5060;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.708 -0400", hash_original_field = "65E9D0A6D689FFB91F5650FC4788A4B6", hash_generated_field = "4CA7FF5DA34408C08E9FC1CA2863A04F")

    protected Contact contactHeader;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.709 -0400", hash_original_method = "B89E344ABA0B0C4EAAF339C3C960DE0F", hash_generated_method = "685613B365B139F14EC760382B8F90A2")
    private  SIPDialog(SipProviderImpl provider) {
        this.terminateOnBye = true;
        this.routeList = new RouteList();
        this.dialogState = NULL_STATE;
        localSequenceNumber = 0;
        remoteSequenceNumber = -1;
        this.sipProvider = provider;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.710 -0400", hash_original_method = "BE0EB8A93E786CF5997E41E028500B95", hash_generated_method = "FF2904EDE7691432C9ED1EC4D3CED466")
    public  SIPDialog(SIPTransaction transaction) {
        this(transaction.getSipProvider());
        SIPRequest sipRequest = (SIPRequest) transaction.getRequest();
        this.callIdHeader = sipRequest.getCallId();
        this.earlyDialogId = sipRequest.getDialogId(false);
    if(transaction == null)        
        {
        NullPointerException var5ABB8E014200511D46B1794EEEB3048F_900324109 = new NullPointerException("Null tx");
        var5ABB8E014200511D46B1794EEEB3048F_900324109.addTaint(taint);
        throw var5ABB8E014200511D46B1794EEEB3048F_900324109;
        }
        this.sipStack = transaction.sipStack;
        this.sipProvider = (SipProviderImpl) transaction.getSipProvider();
    if(sipProvider == null)        
        {
        NullPointerException var6A6919BD68B9186E8C9ADF8FE1C4B1A2_445891537 = new NullPointerException("Null Provider!");
        var6A6919BD68B9186E8C9ADF8FE1C4B1A2_445891537.addTaint(taint);
        throw var6A6919BD68B9186E8C9ADF8FE1C4B1A2_445891537;
        }
        this.addTransaction(transaction);
    if(sipStack.isLoggingEnabled())        
        {
            sipStack.getStackLogger().logDebug("Creating a dialog : " + this);
            sipStack.getStackLogger().logDebug(
                    "provider port = " + this.sipProvider.getListeningPoint().getPort());
            sipStack.getStackLogger().logStackTrace();
        } //End block
        this.isBackToBackUserAgent = sipStack.isBackToBackUserAgent;
        addEventListener(sipStack);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.710 -0400", hash_original_method = "0305A0224D6BCDD571D54C883A13EEA2", hash_generated_method = "0D129DB9E3754F8C133E3D66DFF6A2A5")
    public  SIPDialog(SIPClientTransaction transaction, SIPResponse sipResponse) {
        this(transaction);
        addTaint(sipResponse.getTaint());
        addTaint(transaction.getTaint());
    if(sipResponse == null)        
        {
        NullPointerException var6F75661795091444769100D02983657A_708835701 = new NullPointerException("Null SipResponse");
        var6F75661795091444769100D02983657A_708835701.addTaint(taint);
        throw var6F75661795091444769100D02983657A_708835701;
        }
        this.setLastResponse(transaction, sipResponse);
        this.isBackToBackUserAgent = sipStack.isBackToBackUserAgent;
        // ---------- Original Method ----------
        //if (sipResponse == null)
            //throw new NullPointerException("Null SipResponse");
        //this.setLastResponse(transaction, sipResponse);
        //this.isBackToBackUserAgent = sipStack.isBackToBackUserAgent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.713 -0400", hash_original_method = "95FF401EAA7EE3F3C9E78290081B0530", hash_generated_method = "40C2F0EE6B1C8077D29C4FA481DE0F43")
    public  SIPDialog(SipProviderImpl sipProvider, SIPResponse sipResponse) {
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
    if(sipStack.isLoggingEnabled())        
        {
            sipStack.getStackLogger().logDebug("Creating a dialog : " + this);
            sipStack.getStackLogger().logStackTrace();
        } //End block
        this.isBackToBackUserAgent = sipStack.isBackToBackUserAgent;
        addEventListener(sipStack);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.713 -0400", hash_original_method = "9EE497100AA17813744E66E4A05B8669", hash_generated_method = "D730239923E29F7DFE5B86469FB919EC")
    private void recordStackTrace() {
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        new Exception().printStackTrace(writer);
        this.stackTrace = stringWriter.getBuffer().toString();
        // ---------- Original Method ----------
        //StringWriter stringWriter = new StringWriter();
        //PrintWriter writer = new PrintWriter(stringWriter);
        //new Exception().printStackTrace(writer);
        //this.stackTrace = stringWriter.getBuffer().toString();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.714 -0400", hash_original_method = "40815EC709415499328FA1CBE062ACB5", hash_generated_method = "672791473F6E9DBF528505DF6025D1DB")
    private void printRouteList() {
    if(sipStack.isLoggingEnabled())        
        {
            sipStack.getStackLogger().logDebug("this : " + this);
            sipStack.getStackLogger().logDebug("printRouteList : " + this.routeList.encode());
        } //End block
        // ---------- Original Method ----------
        //if (sipStack.isLoggingEnabled()) {
            //sipStack.getStackLogger().logDebug("this : " + this);
            //sipStack.getStackLogger().logDebug("printRouteList : " + this.routeList.encode());
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.714 -0400", hash_original_method = "6746D685A6EEFE6F86FE53A5B90B58CB", hash_generated_method = "C895E6533429D8DEAE3A69A2E4EAF8D2")
    private boolean isClientDialog() {
        SIPTransaction transaction = (SIPTransaction) this.getFirstTransaction();
        boolean varC270AD65801AF812F56DD1F8DCF5492C_1713978062 = (transaction instanceof SIPClientTransaction);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1102458389 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1102458389;
        // ---------- Original Method ----------
        //SIPTransaction transaction = (SIPTransaction) this.getFirstTransaction();
        //return transaction instanceof SIPClientTransaction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.715 -0400", hash_original_method = "871D6D7CB1794492ED7691CB8C5B804E", hash_generated_method = "89CBF867C6FA598DA15F5D1A6EC4896B")
    private void raiseIOException(String host, int port, String protocol) {
        addTaint(protocol.getTaint());
        addTaint(port);
        addTaint(host.getTaint());
        IOExceptionEvent ioError = new IOExceptionEvent(this, host, port, protocol);
        sipProvider.handleEvent(ioError, null);
        setState(SIPDialog.TERMINATED_STATE);
        // ---------- Original Method ----------
        //IOExceptionEvent ioError = new IOExceptionEvent(this, host, port, protocol);
        //sipProvider.handleEvent(ioError, null);
        //setState(SIPDialog.TERMINATED_STATE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.716 -0400", hash_original_method = "352742C76D82997D1FD2B39635FE380F", hash_generated_method = "348C548DB0E2C4F49DA72B3D52EC5BB0")
    private void raiseErrorEvent(int dialogTimeoutError) {
        addTaint(dialogTimeoutError);
        SIPDialogErrorEvent newErrorEvent;
        Iterator<SIPDialogEventListener> listenerIterator;
        SIPDialogEventListener nextListener;
        newErrorEvent = new SIPDialogErrorEvent(this, dialogTimeoutError);
        synchronized
(eventListeners)        {
            listenerIterator = eventListeners.iterator();
            while
(listenerIterator.hasNext())            
            {
                nextListener = (SIPDialogEventListener) listenerIterator.next();
                nextListener.dialogErrorEvent(newErrorEvent);
            } //End block
        } //End block
        eventListeners.clear();
    if(dialogTimeoutError != SIPDialogErrorEvent.DIALOG_ACK_NOT_SENT_TIMEOUT &&
		        dialogTimeoutError != SIPDialogErrorEvent.DIALOG_ACK_NOT_RECEIVED_TIMEOUT &&
		        dialogTimeoutError != SIPDialogErrorEvent.DIALOG_REINVITE_TIMEOUT)        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.718 -0400", hash_original_method = "E7371746614A4FB0A7068DCC784728D1", hash_generated_method = "6D69CC4E5DB2276D49E392AB8FD69649")
    private void setRemoteParty(SIPMessage sipMessage) {
    if(!isServer())        
        {
            this.remoteParty = sipMessage.getTo().getAddress();
        } //End block
        else
        {
            this.remoteParty = sipMessage.getFrom().getAddress();
        } //End block
    if(sipStack.isLoggingEnabled())        
        {
            sipStack.getStackLogger().logDebug("settingRemoteParty " + this.remoteParty);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.721 -0400", hash_original_method = "07989C3909E96A7576DAE0D29DD189A0", hash_generated_method = "6AE7C00BFD2959D66437AFF9D4F6F13E")
    private void addRoute(RecordRouteList recordRouteList) {
        addTaint(recordRouteList.getTaint());
        try 
        {
    if(this.isClientDialog())            
            {
                this.routeList = new RouteList();
                ListIterator li = recordRouteList.listIterator(recordRouteList.size());
                boolean addRoute = true;
                while
(li.hasPrevious())                
                {
                    RecordRoute rr = (RecordRoute) li.previous();
    if(addRoute)                    
                    {
                        Route route = new Route();
                        AddressImpl address = ((AddressImpl) ((AddressImpl) rr.getAddress())
                                .clone());
                        route.setAddress(address);
                        route.setParameters((NameValueList) rr.getParameters().clone());
                        this.routeList.add(route);
                    } //End block
                } //End block
            } //End block
            else
            {
                this.routeList = new RouteList();
                ListIterator li = recordRouteList.listIterator();
                boolean addRoute = true;
                while
(li.hasNext())                
                {
                    RecordRoute rr = (RecordRoute) li.next();
    if(addRoute)                    
                    {
                        Route route = new Route();
                        AddressImpl address = ((AddressImpl) ((AddressImpl) rr.getAddress())
                                .clone());
                        route.setAddress(address);
                        route.setParameters((NameValueList) rr.getParameters().clone());
                        routeList.add(route);
                    } //End block
                } //End block
            } //End block
        } //End block
        finally 
        {
    if(sipStack.getStackLogger().isLoggingEnabled())            
            {
                Iterator it = routeList.iterator();
                while
(it.hasNext())                
                {
                    SipURI sipUri = (SipURI) (((Route) it.next()).getAddress().getURI());
    if(!sipUri.hasLrParam())                    
                    {
    if(sipStack.isLoggingEnabled())                        
                        {
                            sipStack.getStackLogger().logWarning(
                                "NON LR route in Route set detected for dialog : " + this);
                            sipStack.getStackLogger().logStackTrace();
                        } //End block
                    } //End block
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.723 -0400", hash_original_method = "0B8DEDA7075751956ABB1ACBE337F637", hash_generated_method = "4923407F03677309D0169C2BFE436D15")
     void setRemoteTarget(ContactHeader contact) {
        this.remoteTarget = contact.getAddress();
    if(sipStack.isLoggingEnabled())        
        {
            sipStack.getStackLogger().logDebug("Dialog.setRemoteTarget: " + this.remoteTarget);
            sipStack.getStackLogger().logStackTrace();
        } //End block
        // ---------- Original Method ----------
        //this.remoteTarget = contact.getAddress();
        //if (sipStack.isLoggingEnabled()) {
            //sipStack.getStackLogger().logDebug("Dialog.setRemoteTarget: " + this.remoteTarget);
            //sipStack.getStackLogger().logStackTrace();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.724 -0400", hash_original_method = "32344AE5A14991821D94A9D2D9260949", hash_generated_method = "EF1EC8AE84767D70CF25B4F5C3C3C60D")
    private synchronized void addRoute(SIPResponse sipResponse) {
        addTaint(sipResponse.getTaint());
        try 
        {
    if(sipStack.isLoggingEnabled())            
            {
                sipStack.getStackLogger().logDebug(
                        "setContact: dialogState: " + this + "state = " + this.getState());
            } //End block
    if(sipResponse.getStatusCode() == 100)            
            {
                return;
            } //End block
            else
    if(this.dialogState == TERMINATED_STATE)            
            {
                return;
            } //End block
            else
    if(this.dialogState == CONFIRMED_STATE)            
            {
    if(sipResponse.getStatusCode() / 100 == 2 && !this.isServer())                
                {
                    ContactList contactList = sipResponse.getContactHeaders();
    if(contactList != null
                            && SIPRequest.isTargetRefresh(sipResponse.getCSeq().getMethod()))                    
                    {
                        this.setRemoteTarget((ContactHeader) contactList.getFirst());
                    } //End block
                } //End block
                return;
            } //End block
    if(!isServer())            
            {
    if(this.getState() != DialogState.CONFIRMED
                        && this.getState() != DialogState.TERMINATED)                
                {
                    RecordRouteList rrlist = sipResponse.getRecordRouteHeaders();
    if(rrlist != null)                    
                    {
                        this.addRoute(rrlist);
                    } //End block
                    else
                    {
                        this.routeList = new RouteList();
                    } //End block
                } //End block
                ContactList contactList = sipResponse.getContactHeaders();
    if(contactList != null)                
                {
                    this.setRemoteTarget((ContactHeader) contactList.getFirst());
                } //End block
            } //End block
        } //End block
        finally 
        {
    if(sipStack.isLoggingEnabled())            
            {
                sipStack.getStackLogger().logStackTrace();
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.725 -0400", hash_original_method = "EDCC5E2E639B8E515D6889EB4E225297", hash_generated_method = "3F83A0B99C012511EFAB01F0F9881E41")
    private synchronized RouteList getRouteList() {
    if(sipStack.isLoggingEnabled())        
        sipStack.getStackLogger().logDebug("getRouteList " + this);
        ListIterator li;
        RouteList retval = new RouteList();
        retval = new RouteList();
    if(this.routeList != null)        
        {
            li = routeList.listIterator();
            while
(li.hasNext())            
            {
                Route route = (Route) li.next();
                retval.add((Route) route.clone());
            } //End block
        } //End block
    if(sipStack.isLoggingEnabled())        
        {
            sipStack.getStackLogger().logDebug("----- ");
            sipStack.getStackLogger().logDebug("getRouteList for " + this);
    if(retval != null)            
            sipStack.getStackLogger().logDebug("RouteList = " + retval.encode());
    if(routeList != null)            
            sipStack.getStackLogger().logDebug("myRouteList = " + routeList.encode());
            sipStack.getStackLogger().logDebug("----- ");
        } //End block
RouteList varF9E19AD6135C970F387F77C6F3DE4477_1349826733 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1349826733.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1349826733;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.726 -0400", hash_original_method = "7EC927C7EF5071E2849378214CAB8686", hash_generated_method = "BCC8ED1A5E46655051AE536081FB079D")
     void setRouteList(RouteList routeList) {
        this.routeList = routeList;
        // ---------- Original Method ----------
        //this.routeList = routeList;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.727 -0400", hash_original_method = "EE053BB78DA7F62675E98D1AF5A5B915", hash_generated_method = "0161CAF76521E30A2463D3F59BF63BE6")
    private void sendAck(Request request, boolean throwIOExceptionAsSipException) throws SipException {
        addTaint(throwIOExceptionAsSipException);
        addTaint(request.getTaint());
        SIPRequest ackRequest = (SIPRequest) request;
    if(sipStack.isLoggingEnabled())        
        sipStack.getStackLogger().logDebug("sendAck" + this);
    if(!ackRequest.getMethod().equals(Request.ACK))        
        {
        SipException var62169A16E3C6377C71715692CFA2A7DE_1872437082 = new SipException("Bad request method -- should be ACK");
        var62169A16E3C6377C71715692CFA2A7DE_1872437082.addTaint(taint);
        throw var62169A16E3C6377C71715692CFA2A7DE_1872437082;
        }
    if(this.getState() == null || this.getState().getValue() == EARLY_STATE)        
        {
    if(sipStack.isLoggingEnabled())            
            {
                sipStack.getStackLogger().logError(
                        "Bad Dialog State for " + this + " dialogID = " + this.getDialogId());
            } //End block
            SipException varA26FBE85574C469BC9BF2BA1222EB88D_1897875636 = new SipException("Bad dialog state " + this.getState());
            varA26FBE85574C469BC9BF2BA1222EB88D_1897875636.addTaint(taint);
            throw varA26FBE85574C469BC9BF2BA1222EB88D_1897875636;
        } //End block
    if(!this.getCallId().getCallId().equals(((SIPRequest) request).getCallId().getCallId()))        
        {
    if(sipStack.isLoggingEnabled())            
            {
                sipStack.getStackLogger().logError("CallID " + this.getCallId());
                sipStack.getStackLogger().logError(
                        "RequestCallID = " + ackRequest.getCallId().getCallId());
                sipStack.getStackLogger().logError("dialog =  " + this);
            } //End block
            SipException var596B844AD5B3EB6355BA0AC4462353B6_504079032 = new SipException("Bad call ID in request");
            var596B844AD5B3EB6355BA0AC4462353B6_504079032.addTaint(taint);
            throw var596B844AD5B3EB6355BA0AC4462353B6_504079032;
        } //End block
        try 
        {
    if(sipStack.isLoggingEnabled())            
            {
                sipStack.getStackLogger().logDebug(
                        "setting from tag For outgoing ACK= " + this.getLocalTag());
                sipStack.getStackLogger().logDebug(
                        "setting To tag for outgoing ACK = " + this.getRemoteTag());
                sipStack.getStackLogger().logDebug("ack = " + ackRequest);
            } //End block
    if(this.getLocalTag() != null)            
            ackRequest.getFrom().setTag(this.getLocalTag());
    if(this.getRemoteTag() != null)            
            ackRequest.getTo().setTag(this.getRemoteTag());
        } //End block
        catch (ParseException ex)
        {
            SipException var892635990475903AE5F007B5D011DC38_1534696517 = new SipException(ex.getMessage());
            var892635990475903AE5F007B5D011DC38_1534696517.addTaint(taint);
            throw var892635990475903AE5F007B5D011DC38_1534696517;
        } //End block
        Hop hop = sipStack.getNextHop(ackRequest);
    if(hop == null)        
        {
        SipException varFC979F3B2A88BE726243E86F84E586C4_1307420381 = new SipException("No route!");
        varFC979F3B2A88BE726243E86F84E586C4_1307420381.addTaint(taint);
        throw varFC979F3B2A88BE726243E86F84E586C4_1307420381;
        }
        try 
        {
    if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger().logDebug("hop = " + hop);
            ListeningPointImpl lp = (ListeningPointImpl) this.sipProvider.getListeningPoint(hop
                    .getTransport());
    if(lp == null)            
            {
            SipException varCFC4BE7809B11AA2FB6D4048A27E8E7A_1503323436 = new SipException("No listening point for this provider registered at "
                        + hop);
            varCFC4BE7809B11AA2FB6D4048A27E8E7A_1503323436.addTaint(taint);
            throw varCFC4BE7809B11AA2FB6D4048A27E8E7A_1503323436;
            }
            InetAddress inetAddress = InetAddress.getByName(hop.getHost());
            MessageChannel messageChannel = lp.getMessageProcessor().createMessageChannel(
                    inetAddress, hop.getPort());
            boolean releaseAckSem = false;
            long cseqNo = ((SIPRequest)request).getCSeq().getSeqNumber();
    if(!this.isAckSent(cseqNo))            
            {
                releaseAckSem = true;
            } //End block
            this.setLastAckSent(ackRequest);
            messageChannel.sendMessage(ackRequest);
            this.isAcknowledged = true;
            this.highestSequenceNumberAcknowledged = Math.max(this.highestSequenceNumberAcknowledged,
                    ((SIPRequest)ackRequest).getCSeq().getSeqNumber());
    if(releaseAckSem && this.isBackToBackUserAgent)            
            {
                this.releaseAckSem();
            } //End block
            else
            {
    if(sipStack.isLoggingEnabled())                
                {
                    sipStack.getStackLogger().logDebug("Not releasing ack sem for " + this + " isAckSent " + releaseAckSem );
                } //End block
            } //End block
        } //End block
        catch (IOException ex)
        {
    if(throwIOExceptionAsSipException)            
            {
            SipException var30C4D3FCA967A89098CC1824406526E9_1408070585 = new SipException("Could not send ack", ex);
            var30C4D3FCA967A89098CC1824406526E9_1408070585.addTaint(taint);
            throw var30C4D3FCA967A89098CC1824406526E9_1408070585;
            }
            this.raiseIOException(hop.getHost(), hop.getPort(), hop.getTransport());
        } //End block
        catch (SipException ex)
        {
    if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger().logException(ex);
            ex.addTaint(taint);
            throw ex;
        } //End block
        catch (Exception ex)
        {
    if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger().logException(ex);
            SipException var468C13692024B7295EC1F941E9CCC62D_108589780 = new SipException("Could not create message channel", ex);
            var468C13692024B7295EC1F941E9CCC62D_108589780.addTaint(taint);
            throw var468C13692024B7295EC1F941E9CCC62D_108589780;
        } //End block
    if(this.dialogDeleteTask != null)        
        {
            this.dialogDeleteTask.cancel();
            this.dialogDeleteTask = null;
        } //End block
        this.ackSeen = true;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.728 -0400", hash_original_method = "0D216F13B34A5D6836A5B8174F7E5D5B", hash_generated_method = "833699EAF4926A44BA91EB1BE4A6B643")
     void setStack(SIPTransactionStack sipStack) {
        this.sipStack = sipStack;
        // ---------- Original Method ----------
        //this.sipStack = sipStack;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.729 -0400", hash_original_method = "4B5A71F52939D771152A6C733BB7B273", hash_generated_method = "D982F9684780CD8CC12DAAA3BD55BEF5")
     SIPTransactionStack getStack() {
SIPTransactionStack var0FC1F21ED47F4C0C48881B0DAF112A16_1968614525 =         sipStack;
        var0FC1F21ED47F4C0C48881B0DAF112A16_1968614525.addTaint(taint);
        return var0FC1F21ED47F4C0C48881B0DAF112A16_1968614525;
        // ---------- Original Method ----------
        //return sipStack;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.729 -0400", hash_original_method = "82BA8A08B2E8140159AB0D3D207AD49D", hash_generated_method = "7AD7887D46E84E65E65A12E5991D549E")
     boolean isTerminatedOnBye() {
        boolean varABC556400E819DEB11D4A925E5834E58_85474078 = (this.terminateOnBye);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1209966719 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1209966719;
        // ---------- Original Method ----------
        //return this.terminateOnBye;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.730 -0400", hash_original_method = "45B7AAA172C2FB7B4FDF9001755F4630", hash_generated_method = "F5A50AD11F9FA4C79262569078ED1317")
     void ackReceived(SIPRequest sipRequest) {
        addTaint(sipRequest.getTaint());
    if(this.ackSeen)        
        return;
        SIPServerTransaction tr = this.getInviteTransaction();
    if(tr != null)        
        {
    if(tr.getCSeq() == sipRequest.getCSeq().getSeqNumber())            
            {
                acquireTimerTaskSem();
                try 
                {
    if(this.timerTask != null)                    
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
    if(this.dialogDeleteTask != null)                
                {
                    this.dialogDeleteTask.cancel();
                    this.dialogDeleteTask = null;
                } //End block
                this.setLastAckReceived(sipRequest);
    if(sipStack.isLoggingEnabled())                
                {
                    sipStack.getStackLogger().logDebug(
                            "ackReceived for " + ((SIPTransaction) tr).getMethod());
                    this.ackLine = sipStack.getStackLogger().getLineCount();
                    this.printDebugInfo();
                } //End block
    if(this.isBackToBackUserAgent)                
                {
                    this.releaseAckSem();
                } //End block
                this.setState(CONFIRMED_STATE);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.731 -0400", hash_original_method = "76BE8FDE36BAF0086F9828D261C3B7B9", hash_generated_method = "4371474E7696CD8DF2DD36F15643B5A2")
    synchronized boolean testAndSetIsDialogTerminatedEventDelivered() {
        boolean retval = this.dialogTerminatedEventDelivered;
        this.dialogTerminatedEventDelivered = true;
        boolean var020B759ADEF679A47CB9AFE965BB2314_5768139 = (retval);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1935551058 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1935551058;
        // ---------- Original Method ----------
        //boolean retval = this.dialogTerminatedEventDelivered;
        //this.dialogTerminatedEventDelivered = true;
        //return retval;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.731 -0400", hash_original_method = "6AC129F323D8E39FC544B245C2D3A08C", hash_generated_method = "0120565AC0F4E8D25CB0A93150695E98")
    public void addEventListener(SIPDialogEventListener newListener) {
        addTaint(newListener.getTaint());
        eventListeners.add(newListener);
        // ---------- Original Method ----------
        //eventListeners.add(newListener);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.731 -0400", hash_original_method = "7D9E11919812D827506D2E4A9106FF10", hash_generated_method = "615AD29ED2E17833D2453452D7BC46B8")
    public void removeEventListener(SIPDialogEventListener oldListener) {
        addTaint(oldListener.getTaint());
        eventListeners.remove(oldListener);
        // ---------- Original Method ----------
        //eventListeners.remove(oldListener);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.732 -0400", hash_original_method = "552E0456C33D24CD63C8EBCDAC1D019B", hash_generated_method = "E17DD994BC845C3BDBBD70ECC432242E")
    public void setApplicationData(Object applicationData) {
        this.applicationData = applicationData;
        // ---------- Original Method ----------
        //this.applicationData = applicationData;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.732 -0400", hash_original_method = "5F924FC61375970A4DC758380BEBFF0F", hash_generated_method = "79AAF28A09001A12FE6706B2A1B94034")
    public Object getApplicationData() {
Object varAC81821DD38AD6A8C7609D7C76D213BC_933045929 =         this.applicationData;
        varAC81821DD38AD6A8C7609D7C76D213BC_933045929.addTaint(taint);
        return varAC81821DD38AD6A8C7609D7C76D213BC_933045929;
        // ---------- Original Method ----------
        //return this.applicationData;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.733 -0400", hash_original_method = "CB5AF71091E3878E29C27274F2628D83", hash_generated_method = "7205865D3F3725D5AC9A4F36425E4555")
    public synchronized void requestConsumed() {
        this.nextSeqno = Long.valueOf(this.getRemoteSeqNumber() + 1);
    if(sipStack.isLoggingEnabled())        
        {
            this.sipStack.getStackLogger().logDebug(
                    "Request Consumed -- next consumable Request Seqno = " + this.nextSeqno);
        } //End block
        // ---------- Original Method ----------
        //this.nextSeqno = Long.valueOf(this.getRemoteSeqNumber() + 1);
        //if (sipStack.isLoggingEnabled()) {
            //this.sipStack.getStackLogger().logDebug(
                    //"Request Consumed -- next consumable Request Seqno = " + this.nextSeqno);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.733 -0400", hash_original_method = "1E1A6C22D1982081DC74374A2FF63AAD", hash_generated_method = "DCCB15916CAC757476E11EBF6B225B73")
    public synchronized boolean isRequestConsumable(SIPRequest dialogRequest) {
        addTaint(dialogRequest.getTaint());
    if(dialogRequest.getMethod().equals(Request.ACK))        
        {
        RuntimeException var19AAD423E588BC2748B7A089D394F74B_458332378 = new RuntimeException("Illegal method");
        var19AAD423E588BC2748B7A089D394F74B_458332378.addTaint(taint);
        throw var19AAD423E588BC2748B7A089D394F74B_458332378;
        }
    if(!this.isSequnceNumberValidation())        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1500495124 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1258638106 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1258638106;
        } //End block
        boolean var722E9B516422C6DBE6829B931BA3478E_714746953 = (remoteSequenceNumber < dialogRequest.getCSeq().getSeqNumber());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_810928782 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_810928782;
        // ---------- Original Method ----------
        //if (dialogRequest.getMethod().equals(Request.ACK))
            //throw new RuntimeException("Illegal method");
        //if (!this.isSequnceNumberValidation()) {
            //return true;
        //}
        //return remoteSequenceNumber < dialogRequest.getCSeq().getSeqNumber();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.733 -0400", hash_original_method = "45E0951257A8FCCA68182E75CB3B0E3E", hash_generated_method = "DE1D13475475DCD97E05ECAB4844AED0")
    public void doDeferredDelete() {
    if(sipStack.getTimer() == null)        
        this.setState(TERMINATED_STATE);
        else
        {
            this.dialogDeleteTask = new DialogDeleteTask();
            sipStack.getTimer().schedule(this.dialogDeleteTask,
                    SIPTransaction.TIMER_H * SIPTransactionStack.BASE_TIMER_INTERVAL);
        } //End block
        // ---------- Original Method ----------
        //if (sipStack.getTimer() == null)
            //this.setState(TERMINATED_STATE);
        //else {
            //this.dialogDeleteTask = new DialogDeleteTask();
            //sipStack.getTimer().schedule(this.dialogDeleteTask,
                    //SIPTransaction.TIMER_H * SIPTransactionStack.BASE_TIMER_INTERVAL);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.734 -0400", hash_original_method = "DBF870542E6B78326B5509C5A5BAD885", hash_generated_method = "3C29306C85D11C3411653C121C60FBDB")
    public void setState(int state) {
    if(sipStack.isLoggingEnabled())        
        {
            sipStack.getStackLogger().logDebug(
                    "Setting dialog state for " + this + "newState = " + state);
            sipStack.getStackLogger().logStackTrace();
    if(state != NULL_STATE && state != this.dialogState)            
    if(sipStack.isLoggingEnabled())            
            {
                sipStack.getStackLogger().logDebug(
                            this + "  old dialog state is " + this.getState());
                sipStack.getStackLogger().logDebug(
                            this + "  New dialog state is " + DialogState.getObject(state));
            } //End block
        } //End block
        this.dialogState = state;
    if(state == TERMINATED_STATE)        
        {
    if(sipStack.getTimer() != null)            
            {
                sipStack.getTimer().schedule(new LingerTimer(), DIALOG_LINGER_TIME * 1000);
            } //End block
            this.stopTimer();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.734 -0400", hash_original_method = "030EEF9CE7E1904041534ED4E8E41515", hash_generated_method = "9F308902118B12E6856BFA1D9285FC7A")
    public void printDebugInfo() {
    if(sipStack.isLoggingEnabled())        
        {
            sipStack.getStackLogger().logDebug("isServer = " + isServer());
            sipStack.getStackLogger().logDebug("localTag = " + getLocalTag());
            sipStack.getStackLogger().logDebug("remoteTag = " + getRemoteTag());
            sipStack.getStackLogger().logDebug("localSequenceNumer = " + getLocalSeqNumber());
            sipStack.getStackLogger().logDebug("remoteSequenceNumer = " + getRemoteSeqNumber());
            sipStack.getStackLogger().logDebug("ackLine:" + this.getRemoteTag() + " " + ackLine);
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.734 -0400", hash_original_method = "1550A0F77E6D4005059B99263F67738A", hash_generated_method = "F614046041D6E9BC5019376716F5BED6")
    public boolean isAckSeen() {
        boolean var861EACACBE6D61260E347F8B70DF2A09_506220206 = (this.ackSeen);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1408296500 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1408296500;
        // ---------- Original Method ----------
        //return this.ackSeen;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.734 -0400", hash_original_method = "B546264B9F955F6D37CCFB381DE1D848", hash_generated_method = "8C505C6715DEF3A855D0426979300680")
    public SIPRequest getLastAckSent() {
SIPRequest var6691D08754032FBE1E55DB1B5A009403_245357559 =         this.lastAckSent;
        var6691D08754032FBE1E55DB1B5A009403_245357559.addTaint(taint);
        return var6691D08754032FBE1E55DB1B5A009403_245357559;
        // ---------- Original Method ----------
        //return this.lastAckSent;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.735 -0400", hash_original_method = "3A1F0F9E8BFDA328E094E225E007A649", hash_generated_method = "B97613EE43BC344961341FFABC5BB86F")
    public boolean isAckSent(long cseqNo) {
        addTaint(cseqNo);
    if(this.getLastTransaction() == null)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1911031345 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1130085231 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1130085231;
        }
    if(this.getLastTransaction() instanceof ClientTransaction)        
        {
    if(this.getLastAckSent() == null)            
            {
                boolean var68934A3E9455FA72420237EB05902327_18422027 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_807385345 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_807385345;
            } //End block
            else
            {
                boolean var65D31EB5FB54FFA27534395C4EC5997A_1418120846 = (cseqNo <=((SIPRequest) this.getLastAckSent()).getCSeq().getSeqNumber());
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_145602032 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_145602032;
            } //End block
        } //End block
        else
        {
            boolean varB326B5062B2F0E69046810717534CB09_475160852 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_546577409 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_546577409;
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.735 -0400", hash_original_method = "614E8BDEDCCD12CF6A6EF62939E9BCC1", hash_generated_method = "8BAC49582F0E5DBACD1CD26352EA3886")
    public Transaction getFirstTransaction() {
Transaction var3438649A4792DF2509905DA6DFD61D20_1917821734 =         this.firstTransaction;
        var3438649A4792DF2509905DA6DFD61D20_1917821734.addTaint(taint);
        return var3438649A4792DF2509905DA6DFD61D20_1917821734;
        // ---------- Original Method ----------
        //return this.firstTransaction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.736 -0400", hash_original_method = "A5E017CF1C9F9D5F5F2E302DFCC4F846", hash_generated_method = "89DAD13F645FC97DCFFA5624B01D10F5")
    public Iterator getRouteSet() {
    if(this.routeList == null)        
        {
Iterator var9780CFEA778AE1D7C7C23AA3E9FBC598_2078531354 =             new LinkedList().listIterator();
            var9780CFEA778AE1D7C7C23AA3E9FBC598_2078531354.addTaint(taint);
            return var9780CFEA778AE1D7C7C23AA3E9FBC598_2078531354;
        } //End block
        else
        {
Iterator var4674157788617195CA241AA3F5AF84C8_1306742427 =             this.getRouteList().listIterator();
            var4674157788617195CA241AA3F5AF84C8_1306742427.addTaint(taint);
            return var4674157788617195CA241AA3F5AF84C8_1306742427;
        } //End block
        // ---------- Original Method ----------
        //if (this.routeList == null) {
            //return new LinkedList().listIterator();
        //} else {
            //return this.getRouteList().listIterator();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.736 -0400", hash_original_method = "A8016262F3F363A84230A54DA12F1862", hash_generated_method = "21EB2BD41EE91668DB7DB7DBEA19850E")
    public synchronized void addRoute(SIPRequest sipRequest) {
        addTaint(sipRequest.getTaint());
    if(sipStack.isLoggingEnabled())        
        {
            sipStack.getStackLogger().logDebug(
                    "setContact: dialogState: " + this + "state = " + this.getState());
        } //End block
    if(this.dialogState == CONFIRMED_STATE
                && SIPRequest.isTargetRefresh(sipRequest.getMethod()))        
        {
            this.doTargetRefresh(sipRequest);
        } //End block
    if(this.dialogState == CONFIRMED_STATE || this.dialogState == TERMINATED_STATE)        
        {
            return;
        } //End block
    if(sipRequest.getToTag()!=null)        
        return;
        RecordRouteList rrlist = sipRequest.getRecordRouteHeaders();
    if(rrlist != null)        
        {
            this.addRoute(rrlist);
        } //End block
        else
        {
            this.routeList = new RouteList();
        } //End block
        ContactList contactList = sipRequest.getContactHeaders();
    if(contactList != null)        
        {
            this.setRemoteTarget((ContactHeader) contactList.getFirst());
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.737 -0400", hash_original_method = "7A127BC7F5926E2623990DC3EF5AF92A", hash_generated_method = "CB8AA31A85091EA3068885635C30BAC6")
    public void setDialogId(String dialogId) {
        this.dialogId = dialogId;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.738 -0400", hash_original_method = "3F9050C9D9DA025E9AD5115049E6DBE4", hash_generated_method = "2E616388A5A8ACDD37D0DBBC710890E9")
    public boolean isServer() {
    if(this.firstTransactionSeen == false)        
        {
        boolean var909F0E09311A945BDFC16259A8931F50_60222563 = (this.serverTransactionFlag);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_582298680 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_582298680;
        }
        else
        {
        boolean varB173ECA218B9250DC31DE6E492A264E3_1609014716 = (this.firstTransactionIsServerTransaction);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_396319943 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_396319943;
        }
        // ---------- Original Method ----------
        //if (this.firstTransactionSeen == false)
            //return this.serverTransactionFlag;
        //else
            //return this.firstTransactionIsServerTransaction;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.738 -0400", hash_original_method = "78570188BA83CB17A52ACDCDF5E3A80D", hash_generated_method = "97BCD16F643B620B6FF7A116A3C08FFB")
    protected boolean isReInvite() {
        boolean var1E1B71BE61795B9280C716CC4A0F4FD7_2140925110 = (this.reInviteFlag);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1688179204 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1688179204;
        // ---------- Original Method ----------
        //return this.reInviteFlag;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.738 -0400", hash_original_method = "E7B2220F30EB97BE925BA6431B089B50", hash_generated_method = "EDD691BAE527620A3A1B114E4E9CC605")
    public String getDialogId() {
    if(this.dialogId == null && this.lastResponse != null)        
        this.dialogId = this.lastResponse.getDialogId(isServer());
String var8BDB7310D064EBC529941BE9D229C459_1658573801 =         this.dialogId;
        var8BDB7310D064EBC529941BE9D229C459_1658573801.addTaint(taint);
        return var8BDB7310D064EBC529941BE9D229C459_1658573801;
        // ---------- Original Method ----------
        //if (this.dialogId == null && this.lastResponse != null)
            //this.dialogId = this.lastResponse.getDialogId(isServer());
        //return this.dialogId;
    }

    
        @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.740 -0400", hash_original_method = "5D1D12A2E6FD98502CE24F8CA665F380", hash_generated_method = "133A8EA7F7605C2028E80FD62BF63E24")
    public void addTransaction(SIPTransaction transaction) {
        SIPRequest sipRequest = (SIPRequest) transaction.getOriginalRequest();
    if(firstTransactionSeen && !firstTransactionId.equals(transaction.getBranchId()) 
                && transaction.getMethod().equals(firstTransactionMethod))        
        {
            this.reInviteFlag = true;
        } //End block
    if(firstTransactionSeen == false)        
        {
            storeFirstTransactionInfo(this, transaction);
    if(sipRequest.getMethod().equals(Request.SUBSCRIBE))            
            this.eventHeader = (EventHeader) sipRequest.getHeader(EventHeader.NAME);
            this.setLocalParty(sipRequest);
            this.setRemoteParty(sipRequest);
            this.setCallId(sipRequest);
    if(this.originalRequest == null)            
            {
                this.originalRequest = sipRequest;
            } //End block
    if(this.method == null)            
            {
                this.method = sipRequest.getMethod();
            } //End block
    if(transaction instanceof SIPServerTransaction)            
            {
                this.hisTag = sipRequest.getFrom().getTag();
            } //End block
            else
            {
                setLocalSequenceNumber(sipRequest.getCSeq().getSeqNumber());
                this.originalLocalSequenceNumber = localSequenceNumber;
                this.myTag = sipRequest.getFrom().getTag();
    if(myTag == null)                
    if(sipStack.isLoggingEnabled())                
                sipStack.getStackLogger().logError(
                            "The request's From header is missing the required Tag parameter.");
            } //End block
        } //End block
        else
    if(transaction.getMethod().equals(firstTransactionMethod)
                && firstTransactionIsServerTransaction != transaction.isServerTransaction())        
        {
            storeFirstTransactionInfo(this, transaction);
            this.setLocalParty(sipRequest);
            this.setRemoteParty(sipRequest);
            this.setCallId(sipRequest);
            this.originalRequest = sipRequest;
            this.method = sipRequest.getMethod();
        } //End block
    if(transaction instanceof SIPServerTransaction)        
        setRemoteSequenceNumber(sipRequest.getCSeq().getSeqNumber());
        this.lastTransaction = transaction;
    if(sipStack.isLoggingEnabled())        
        {
            sipStack.getStackLogger()
                    .logDebug("Transaction Added " + this + myTag + "/" + hisTag);
            sipStack.getStackLogger().logDebug(
                    "TID = " + transaction.getTransactionId() + "/"
                            + transaction.isServerTransaction());
            sipStack.getStackLogger().logStackTrace();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.741 -0400", hash_original_method = "D993372A10E82664D688CA2C725ED950", hash_generated_method = "5B9F81BC01697E7B602CCF2CE1270A64")
    private void setRemoteTag(String hisTag) {
    if(sipStack.isLoggingEnabled())        
        {
            sipStack.getStackLogger().logDebug(
                    "setRemoteTag(): " + this + " remoteTag = " + this.hisTag + " new tag = "
                            + hisTag);
        } //End block
    if(this.hisTag != null && hisTag != null && !hisTag.equals(this.hisTag))        
        {
    if(this.getState() != DialogState.EARLY)            
            {
    if(sipStack.isLoggingEnabled())                
                sipStack.getStackLogger().logDebug(
                        "Dialog is already established -- ignoring remote tag re-assignment");
                return;
            } //End block
            else
    if(sipStack.isRemoteTagReassignmentAllowed())            
            {
    if(sipStack.isLoggingEnabled())                
                sipStack.getStackLogger().logDebug(
                        "UNSAFE OPERATION !  tag re-assignment " + this.hisTag
                                + " trying to set to " + hisTag
                                + " can cause unexpected effects ");
                boolean removed = false;
    if(this.sipStack.getDialog(dialogId) == this)                
                {
                    this.sipStack.removeDialog(dialogId);
                    removed = true;
                } //End block
                this.dialogId = null;
                this.hisTag = hisTag;
    if(removed)                
                {
    if(sipStack.isLoggingEnabled())                    
                    sipStack.getStackLogger().logDebug("ReInserting Dialog");
                    this.sipStack.putDialog(this);
                } //End block
            } //End block
        } //End block
        else
        {
    if(hisTag != null)            
            {
                this.hisTag = hisTag;
            } //End block
            else
            {
    if(sipStack.isLoggingEnabled())                
                sipStack.getStackLogger().logWarning("setRemoteTag : called with null argument ");
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.741 -0400", hash_original_method = "6BDB0ABA2E69E3FFFE0E9E894A65FB29", hash_generated_method = "1B5CB2CC3959D9A5C5B47E18FFB63965")
    public SIPTransaction getLastTransaction() {
SIPTransaction varDA3A47C7C91904CC831075ABBA895B50_1089638176 =         this.lastTransaction;
        varDA3A47C7C91904CC831075ABBA895B50_1089638176.addTaint(taint);
        return varDA3A47C7C91904CC831075ABBA895B50_1089638176;
        // ---------- Original Method ----------
        //return this.lastTransaction;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.741 -0400", hash_original_method = "2B80A0EDB61F41D041D4D4B21A265288", hash_generated_method = "1B59A76C8FC6943BD83A7E2E9C9A9F9C")
    public SIPServerTransaction getInviteTransaction() {
        DialogTimerTask t = this.timerTask;
    if(t != null)        
        {
SIPServerTransaction varAFB210AE57927A99F7B1177593DD4C61_1015434477 =         t.transaction;
        varAFB210AE57927A99F7B1177593DD4C61_1015434477.addTaint(taint);
        return varAFB210AE57927A99F7B1177593DD4C61_1015434477;
        }
        else
        {
SIPServerTransaction var540C13E9E156B687226421B24F2DF178_1243822886 =         null;
        var540C13E9E156B687226421B24F2DF178_1243822886.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1243822886;
        }
        // ---------- Original Method ----------
        //DialogTimerTask t = this.timerTask;
        //if (t != null)
            //return t.transaction;
        //else
            //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.742 -0400", hash_original_method = "0F222FB6A793487D534C4C9D0AE37F48", hash_generated_method = "0425BB03F4492405E3694F5DB0E3C109")
    private void setLocalSequenceNumber(long lCseq) {
    if(sipStack.isLoggingEnabled())        
        sipStack.getStackLogger().logDebug(
                    "setLocalSequenceNumber: original  " + this.localSequenceNumber + " new  = "
                            + lCseq);
    if(lCseq <= this.localSequenceNumber)        
        {
        RuntimeException var8D4096C60507932B188BB1D218C7B1F5_1172731261 = new RuntimeException("Sequence number should not decrease !");
        var8D4096C60507932B188BB1D218C7B1F5_1172731261.addTaint(taint);
        throw var8D4096C60507932B188BB1D218C7B1F5_1172731261;
        }
        this.localSequenceNumber = lCseq;
        // ---------- Original Method ----------
        //if (sipStack.isLoggingEnabled())
            //sipStack.getStackLogger().logDebug(
                    //"setLocalSequenceNumber: original  " + this.localSequenceNumber + " new  = "
                            //+ lCseq);
        //if (lCseq <= this.localSequenceNumber)
            //throw new RuntimeException("Sequence number should not decrease !");
        //this.localSequenceNumber = lCseq;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.742 -0400", hash_original_method = "2CD5B084729CE62420C092F3B17E64CA", hash_generated_method = "2CFB9763BFA0128AD4858A3D727F959A")
    public void setRemoteSequenceNumber(long rCseq) {
    if(sipStack.isLoggingEnabled())        
        sipStack.getStackLogger().logDebug("setRemoteSeqno " + this + "/" + rCseq);
        this.remoteSequenceNumber = rCseq;
        // ---------- Original Method ----------
        //if (sipStack.isLoggingEnabled())
            //sipStack.getStackLogger().logDebug("setRemoteSeqno " + this + "/" + rCseq);
        //this.remoteSequenceNumber = rCseq;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.742 -0400", hash_original_method = "ACC9A2408A6E532361DDB7BDD50DD489", hash_generated_method = "4AEF6995D515618F3C26C7F00A8352EC")
    public void incrementLocalSequenceNumber() {
        ++this.localSequenceNumber;
        // ---------- Original Method ----------
        //++this.localSequenceNumber;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.742 -0400", hash_original_method = "FC2F178305D96E73603946FEBD885895", hash_generated_method = "B430FA951B24C79804FA20B3587C2CC3")
    public int getRemoteSequenceNumber() {
        int varD33F6311E312446815298A1E110B995D_1539466289 = ((int) this.remoteSequenceNumber);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_586765237 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_586765237;
        // ---------- Original Method ----------
        //return (int) this.remoteSequenceNumber;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.743 -0400", hash_original_method = "4E94621434A30379D5E2C1A949477B38", hash_generated_method = "D6C960AC4856127DC78E78856A2FE83C")
    public int getLocalSequenceNumber() {
        int var0C6BD34D21D09D626B1019A6823AFA1E_1456115268 = ((int) this.localSequenceNumber);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1451993727 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1451993727;
        // ---------- Original Method ----------
        //return (int) this.localSequenceNumber;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.743 -0400", hash_original_method = "6474794E57511F2FE7B2B694C3DD0A5A", hash_generated_method = "678570BACE4448D216AD177D515284C2")
    public long getOriginalLocalSequenceNumber() {
        long var4A027BE30D247E034B3AB0F37D9FC82E_56999773 = (this.originalLocalSequenceNumber);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_181181178 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_181181178;
        // ---------- Original Method ----------
        //return this.originalLocalSequenceNumber;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.743 -0400", hash_original_method = "4D53FF8947679D063EC9104B2E34893C", hash_generated_method = "20D6B9751864F80F56856DD8BDAB1762")
    public long getLocalSeqNumber() {
        long varD6342BE63C7E830F99AC8BE7761BA814_1073940011 = (this.localSequenceNumber);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1934130598 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1934130598;
        // ---------- Original Method ----------
        //return this.localSequenceNumber;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.743 -0400", hash_original_method = "86EC66726C4D4B16B759790B32B2EE83", hash_generated_method = "55E14C53EE9AAC92A16587F81968E3CA")
    public long getRemoteSeqNumber() {
        long var23421D06372C7AE56AE33B341FD85A53_1652269855 = (this.remoteSequenceNumber);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_912426890 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_912426890;
        // ---------- Original Method ----------
        //return this.remoteSequenceNumber;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.743 -0400", hash_original_method = "0BA81564D0817AED393E2EAE028CBF1E", hash_generated_method = "42EE3C26425232AA7E63911D86ED9E73")
    public String getLocalTag() {
String varC98C6BFDE09455994EA3A0E3579B7BBE_1282382325 =         this.myTag;
        varC98C6BFDE09455994EA3A0E3579B7BBE_1282382325.addTaint(taint);
        return varC98C6BFDE09455994EA3A0E3579B7BBE_1282382325;
        // ---------- Original Method ----------
        //return this.myTag;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.743 -0400", hash_original_method = "C2413781DD6AA95F52F5C21D9381D08B", hash_generated_method = "B4335DDF4CAFC2F1A139B5D04F139A2A")
    public String getRemoteTag() {
String var9DE7A7E9315738F00198F8DF7C7E5465_457928478 =         hisTag;
        var9DE7A7E9315738F00198F8DF7C7E5465_457928478.addTaint(taint);
        return var9DE7A7E9315738F00198F8DF7C7E5465_457928478;
        // ---------- Original Method ----------
        //return hisTag;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.743 -0400", hash_original_method = "CA511CD87985B97DC1F9ED1FACA7DA9D", hash_generated_method = "8AA3E954DDDCEFBAF3594ADDDAAAA15D")
    private void setLocalTag(String mytag) {
    if(sipStack.isLoggingEnabled())        
        {
            sipStack.getStackLogger().logDebug("set Local tag " + mytag + " " + this.dialogId);
            sipStack.getStackLogger().logStackTrace();
        } //End block
        this.myTag = mytag;
        // ---------- Original Method ----------
        //if (sipStack.isLoggingEnabled()) {
            //sipStack.getStackLogger().logDebug("set Local tag " + mytag + " " + this.dialogId);
            //sipStack.getStackLogger().logStackTrace();
        //}
        //this.myTag = mytag;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.744 -0400", hash_original_method = "34B72580F00CA0B4FA87EF05393027BE", hash_generated_method = "C41AF72127A1D3997F6A353CD4B6BEE0")
    public void delete() {
        this.setState(TERMINATED_STATE);
        // ---------- Original Method ----------
        //this.setState(TERMINATED_STATE);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.744 -0400", hash_original_method = "E30651442243E5536659B8D6D7E6C300", hash_generated_method = "FC9F429DDD44F0FAA9B03B8109A3FB46")
    public CallIdHeader getCallId() {
CallIdHeader var0A1A7D5AA74854841C64078E07B44310_1464378417 =         this.callIdHeader;
        var0A1A7D5AA74854841C64078E07B44310_1464378417.addTaint(taint);
        return var0A1A7D5AA74854841C64078E07B44310_1464378417;
        // ---------- Original Method ----------
        //return this.callIdHeader;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.744 -0400", hash_original_method = "4B0BBE43D23308E79DF92279003CECC0", hash_generated_method = "517DBAA469E981201785F2FDAACB9B73")
    private void setCallId(SIPRequest sipRequest) {
        this.callIdHeader = sipRequest.getCallId();
        // ---------- Original Method ----------
        //this.callIdHeader = sipRequest.getCallId();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.745 -0400", hash_original_method = "1786A3231AA3C60CCA9E19F7DEAE30E7", hash_generated_method = "215BB35097F48311F8C9344BADCCDB35")
    public javax.sip.address.Address getLocalParty() {
javax.sip.address.Address varA324A22659E41955B199219D5C3C3E02_236856460 =         this.localParty;
        varA324A22659E41955B199219D5C3C3E02_236856460.addTaint(taint);
        return varA324A22659E41955B199219D5C3C3E02_236856460;
        // ---------- Original Method ----------
        //return this.localParty;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.745 -0400", hash_original_method = "1D3A055B19FDF32D0E14CBB9A0F366F2", hash_generated_method = "5BFC69554EF62208B88216B9ABCE5B77")
    private void setLocalParty(SIPMessage sipMessage) {
    if(!isServer())        
        {
            this.localParty = sipMessage.getFrom().getAddress();
        } //End block
        else
        {
            this.localParty = sipMessage.getTo().getAddress();
        } //End block
        // ---------- Original Method ----------
        //if (!isServer()) {
            //this.localParty = sipMessage.getFrom().getAddress();
        //} else {
            //this.localParty = sipMessage.getTo().getAddress();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.745 -0400", hash_original_method = "CA9799D7C5644CC201AAA28B1842190A", hash_generated_method = "CE79D98BC1FF70552DF48BB67E834E0C")
    public javax.sip.address.Address getRemoteParty() {
    if(sipStack.isLoggingEnabled())        
        {
            sipStack.getStackLogger().logDebug("gettingRemoteParty " + this.remoteParty);
        } //End block
javax.sip.address.Address varAAD5546F0C55460866C2AD933DC0F970_2047272162 =         this.remoteParty;
        varAAD5546F0C55460866C2AD933DC0F970_2047272162.addTaint(taint);
        return varAAD5546F0C55460866C2AD933DC0F970_2047272162;
        // ---------- Original Method ----------
        //if (sipStack.isLoggingEnabled()) {
            //sipStack.getStackLogger().logDebug("gettingRemoteParty " + this.remoteParty);
        //}
        //return this.remoteParty;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.746 -0400", hash_original_method = "5663F20A7285801454D4B2BC61212FE3", hash_generated_method = "606B27C1E0EA402A3AC536B3C52758F1")
    public javax.sip.address.Address getRemoteTarget() {
javax.sip.address.Address varFA348AB92EBF516EEB3F984FC2409B51_1306324875 =         this.remoteTarget;
        varFA348AB92EBF516EEB3F984FC2409B51_1306324875.addTaint(taint);
        return varFA348AB92EBF516EEB3F984FC2409B51_1306324875;
        // ---------- Original Method ----------
        //return this.remoteTarget;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.746 -0400", hash_original_method = "81C5F6A55277F5330460057DCD70CFE0", hash_generated_method = "81DCE2A910DDD7F2A7772C14E37DE830")
    public DialogState getState() {
    if(this.dialogState == NULL_STATE)        
        {
DialogState var540C13E9E156B687226421B24F2DF178_813448191 =         null;
        var540C13E9E156B687226421B24F2DF178_813448191.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_813448191;
        }
DialogState var3535125884B8E95BD057DA8E4211B246_1054901200 =         DialogState.getObject(this.dialogState);
        var3535125884B8E95BD057DA8E4211B246_1054901200.addTaint(taint);
        return var3535125884B8E95BD057DA8E4211B246_1054901200;
        // ---------- Original Method ----------
        //if (this.dialogState == NULL_STATE)
            //return null;
        //return DialogState.getObject(this.dialogState);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.746 -0400", hash_original_method = "B6F2129527CFF355191EDA726B295B54", hash_generated_method = "3A102B98E9F45FC5A237A7C0FE938403")
    public boolean isSecure() {
        boolean var9BC40518A7B9CE6BB5AB4B5AEDF48DB0_1047190616 = (this.firstTransactionSecure);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_648415054 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_648415054;
        // ---------- Original Method ----------
        //return this.firstTransactionSecure;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.746 -0400", hash_original_method = "41912A3E01B6CF39F4209C49F71F74D2", hash_generated_method = "4E12F206CFBC78DED7074E6E47C78FC5")
    public void sendAck(Request request) throws SipException {
        addTaint(request.getTaint());
        this.sendAck(request, true);
        // ---------- Original Method ----------
        //this.sendAck(request, true);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.746 -0400", hash_original_method = "802F1385694BBDC717BE4DE58C3ED44B", hash_generated_method = "63A93F8AA22BC4B88244E5AC2C8C564A")
    public Request createRequest(String method) throws SipException {
        addTaint(method.getTaint());
    if(method.equals(Request.ACK) || method.equals(Request.PRACK))        
        {
            SipException var930AA954654F343B81E7503ADEA14360_144523100 = new SipException("Invalid method specified for createRequest:" + method);
            var930AA954654F343B81E7503ADEA14360_144523100.addTaint(taint);
            throw var930AA954654F343B81E7503ADEA14360_144523100;
        } //End block
    if(lastResponse != null)        
        {
Request var38B8A60208B4BE77DD71253D980B16B4_357753884 =         this.createRequest(method, this.lastResponse);
        var38B8A60208B4BE77DD71253D980B16B4_357753884.addTaint(taint);
        return var38B8A60208B4BE77DD71253D980B16B4_357753884;
        }
        else
        {
        SipException varF94B9E24FEE7E745D0E4A3396340B6B6_883434945 = new SipException("Dialog not yet established -- no response!");
        varF94B9E24FEE7E745D0E4A3396340B6B6_883434945.addTaint(taint);
        throw varF94B9E24FEE7E745D0E4A3396340B6B6_883434945;
        }
        // ---------- Original Method ----------
        //if (method.equals(Request.ACK) || method.equals(Request.PRACK)) {
            //throw new SipException("Invalid method specified for createRequest:" + method);
        //}
        //if (lastResponse != null)
            //return this.createRequest(method, this.lastResponse);
        //else
            //throw new SipException("Dialog not yet established -- no response!");
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.748 -0400", hash_original_method = "B004628D88AAF4473352CE6B2CF39886", hash_generated_method = "7B06F5A794E49B2215F80BB01FE2D42B")
    private Request createRequest(String method, SIPResponse sipResponse) throws SipException {
        addTaint(sipResponse.getTaint());
        addTaint(method.getTaint());
    if(method == null || sipResponse == null)        
        {
        NullPointerException var43FEB67B635D07E4864C59AB79A74AB2_769413626 = new NullPointerException("null argument");
        var43FEB67B635D07E4864C59AB79A74AB2_769413626.addTaint(taint);
        throw var43FEB67B635D07E4864C59AB79A74AB2_769413626;
        }
    if(method.equals(Request.CANCEL))        
        {
        SipException var98D84A5A9568D05A08E05D0A7943E27A_352776202 = new SipException("Dialog.createRequest(): Invalid request");
        var98D84A5A9568D05A08E05D0A7943E27A_352776202.addTaint(taint);
        throw var98D84A5A9568D05A08E05D0A7943E27A_352776202;
        }
    if(this.getState() == null
                || (this.getState().getValue() == TERMINATED_STATE && !method
                        .equalsIgnoreCase(Request.BYE))
                || (this.isServer() && this.getState().getValue() == EARLY_STATE && method
                        .equalsIgnoreCase(Request.BYE)))        
        {
        SipException varA25CABB21BB217B60FFA73CD7AEACBF5_931524468 = new SipException("Dialog  " + getDialogId()
                    + " not yet established or terminated " + this.getState());
        varA25CABB21BB217B60FFA73CD7AEACBF5_931524468.addTaint(taint);
        throw varA25CABB21BB217B60FFA73CD7AEACBF5_931524468;
        }
        SipUri sipUri = null;
    if(this.getRemoteTarget() != null)        
        sipUri = (SipUri) this.getRemoteTarget().getURI().clone();
        else
        {
            sipUri = (SipUri) this.getRemoteParty().getURI().clone();
            sipUri.clearUriParms();
        } //End block
        CSeq cseq = new CSeq();
        try 
        {
            cseq.setMethod(method);
            cseq.setSeqNumber(this.getLocalSeqNumber());
        } //End block
        catch (Exception ex)
        {
    if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger().logError("Unexpected error");
            InternalErrorHandler.handleException(ex);
        } //End block
        ListeningPointImpl lp = (ListeningPointImpl) this.sipProvider
                .getListeningPoint(sipResponse.getTopmostVia().getTransport());
    if(lp == null)        
        {
    if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger().logError(
                        "Cannot find listening point for transport "
                                + sipResponse.getTopmostVia().getTransport());
            SipException var1A6A75F8466EA26504CE5DA07FA427E2_408688871 = new SipException("Cannot find listening point for transport "
                    + sipResponse.getTopmostVia().getTransport());
            var1A6A75F8466EA26504CE5DA07FA427E2_408688871.addTaint(taint);
            throw var1A6A75F8466EA26504CE5DA07FA427E2_408688871;
        } //End block
        Via via = lp.getViaHeader();
        From from = new From();
        from.setAddress(this.localParty);
        To to = new To();
        to.setAddress(this.remoteParty);
        SIPRequest sipRequest = sipResponse.createRequest(sipUri, via, cseq, from, to);
    if(SIPRequest.isTargetRefresh(method))        
        {
            ContactHeader contactHeader = ((ListeningPointImpl) this.sipProvider
                    .getListeningPoint(lp.getTransport())).createContactHeader();
            ((SipURI) contactHeader.getAddress().getURI()).setSecure(this.isSecure());
            sipRequest.setHeader(contactHeader);
        } //End block
        try 
        {
            cseq = (CSeq) sipRequest.getCSeq();
            cseq.setSeqNumber(this.localSequenceNumber + 1);
        } //End block
        catch (InvalidArgumentException ex)
        {
            InternalErrorHandler.handleException(ex);
        } //End block
    if(method.equals(Request.SUBSCRIBE))        
        {
    if(eventHeader != null)            
            sipRequest.addHeader(eventHeader);
        } //End block
        try 
        {
    if(this.getLocalTag() != null)            
            {
                from.setTag(this.getLocalTag());
            } //End block
            else
            {
                from.removeTag();
            } //End block
    if(this.getRemoteTag() != null)            
            {
                to.setTag(this.getRemoteTag());
            } //End block
            else
            {
                to.removeTag();
            } //End block
        } //End block
        catch (ParseException ex)
        {
            InternalErrorHandler.handleException(ex);
        } //End block
        this.updateRequest(sipRequest);
Request varC7C20CEFE913CADDEFC247E46F836F62_42363303 =         sipRequest;
        varC7C20CEFE913CADDEFC247E46F836F62_42363303.addTaint(taint);
        return varC7C20CEFE913CADDEFC247E46F836F62_42363303;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.749 -0400", hash_original_method = "9C360B0CF1AC53C036709107CECBBC75", hash_generated_method = "003F33AA8ACB517EF30B5713F2A97261")
    public void sendRequest(ClientTransaction clientTransactionId) throws TransactionDoesNotExistException, SipException {
        addTaint(clientTransactionId.getTaint());
        this.sendRequest(clientTransactionId, !this.isBackToBackUserAgent);
        // ---------- Original Method ----------
        //this.sendRequest(clientTransactionId, !this.isBackToBackUserAgent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.751 -0400", hash_original_method = "E90E816BF2167876B04C570AAB507565", hash_generated_method = "F2A94585788046D286DC15932951A3D0")
    public void sendRequest(ClientTransaction clientTransactionId, boolean allowInterleaving) throws TransactionDoesNotExistException, SipException {
        addTaint(allowInterleaving);
        addTaint(clientTransactionId.getTaint());
    if((!allowInterleaving)
                && clientTransactionId.getRequest().getMethod().equals(Request.INVITE))        
        {
            new Thread((new ReInviteSender(clientTransactionId))).start();
            return;
        } //End block
        SIPRequest dialogRequest = ((SIPClientTransaction) clientTransactionId)
                .getOriginalRequest();
    if(sipStack.isLoggingEnabled())        
        sipStack.getStackLogger().logDebug(
                    "dialog.sendRequest " + " dialog = " + this + "\ndialogRequest = \n"
                            + dialogRequest);
    if(clientTransactionId == null)        
        {
        NullPointerException varB99541E49F2D11862FACE949F74E8170_1493178995 = new NullPointerException("null parameter");
        varB99541E49F2D11862FACE949F74E8170_1493178995.addTaint(taint);
        throw varB99541E49F2D11862FACE949F74E8170_1493178995;
        }
    if(dialogRequest.getMethod().equals(Request.ACK)
                || dialogRequest.getMethod().equals(Request.CANCEL))        
        {
        SipException var64C48F12E6A1A8DF0AFFC7B6517F9903_448696165 = new SipException("Bad Request Method. " + dialogRequest.getMethod());
        var64C48F12E6A1A8DF0AFFC7B6517F9903_448696165.addTaint(taint);
        throw var64C48F12E6A1A8DF0AFFC7B6517F9903_448696165;
        }
    if(byeSent && isTerminatedOnBye() && !dialogRequest.getMethod().equals(Request.BYE))        
        {
    if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger().logError("BYE already sent for " + this);
            SipException var7AE6E50558AD845F1F953F06F2F94C91_1481780646 = new SipException("Cannot send request; BYE already sent");
            var7AE6E50558AD845F1F953F06F2F94C91_1481780646.addTaint(taint);
            throw var7AE6E50558AD845F1F953F06F2F94C91_1481780646;
        } //End block
    if(dialogRequest.getTopmostVia() == null)        
        {
            Via via = ((SIPClientTransaction) clientTransactionId).getOutgoingViaHeader();
            dialogRequest.addHeader(via);
        } //End block
    if(!this.getCallId().getCallId().equalsIgnoreCase(dialogRequest.getCallId().getCallId()))        
        {
    if(sipStack.isLoggingEnabled())            
            {
                sipStack.getStackLogger().logError("CallID " + this.getCallId());
                sipStack.getStackLogger().logError(
                        "RequestCallID = " + dialogRequest.getCallId().getCallId());
                sipStack.getStackLogger().logError("dialog =  " + this);
            } //End block
            SipException var596B844AD5B3EB6355BA0AC4462353B6_1631620621 = new SipException("Bad call ID in request");
            var596B844AD5B3EB6355BA0AC4462353B6_1631620621.addTaint(taint);
            throw var596B844AD5B3EB6355BA0AC4462353B6_1631620621;
        } //End block
        ((SIPClientTransaction) clientTransactionId).setDialog(this, this.dialogId);
        this.addTransaction((SIPTransaction) clientTransactionId);
        ((SIPClientTransaction) clientTransactionId).isMapped = true;
        From from = (From) dialogRequest.getFrom();
        To to = (To) dialogRequest.getTo();
    if(this.getLocalTag() != null && from.getTag() != null
                && !from.getTag().equals(this.getLocalTag()))        
        {
        SipException var784766FF06F3F09FC89E3A51A4038E27_1107425246 = new SipException("From tag mismatch expecting  " + this.getLocalTag());
        var784766FF06F3F09FC89E3A51A4038E27_1107425246.addTaint(taint);
        throw var784766FF06F3F09FC89E3A51A4038E27_1107425246;
        }
    if(this.getRemoteTag() != null && to.getTag() != null
                && !to.getTag().equals(this.getRemoteTag()))        
        {
    if(sipStack.isLoggingEnabled())            
            this.sipStack.getStackLogger().logWarning(
                    "To header tag mismatch expecting " + this.getRemoteTag());
        } //End block
    if(this.getLocalTag() == null && dialogRequest.getMethod().equals(Request.NOTIFY))        
        {
    if(!this.getMethod().equals(Request.SUBSCRIBE))            
            {
            SipException varE8D401CADB8EF09F695809D0EEAB5999_2049656177 = new SipException("Trying to send NOTIFY without SUBSCRIBE Dialog!");
            varE8D401CADB8EF09F695809D0EEAB5999_2049656177.addTaint(taint);
            throw varE8D401CADB8EF09F695809D0EEAB5999_2049656177;
            }
            this.setLocalTag(from.getTag());
        } //End block
        try 
        {
    if(this.getLocalTag() != null)            
            from.setTag(this.getLocalTag());
    if(this.getRemoteTag() != null)            
            to.setTag(this.getRemoteTag());
        } //End block
        catch (ParseException ex)
        {
            InternalErrorHandler.handleException(ex);
        } //End block
        Hop hop = ((SIPClientTransaction) clientTransactionId).getNextHop();
    if(sipStack.isLoggingEnabled())        
        {
            sipStack.getStackLogger().logDebug(
                    "Using hop = " + hop.getHost() + " : " + hop.getPort());
        } //End block
        try 
        {
            MessageChannel messageChannel = sipStack.createRawMessageChannel(this
                    .getSipProvider().getListeningPoint(hop.getTransport()).getIPAddress(),
                    this.firstTransactionPort, hop);
            MessageChannel oldChannel = ((SIPClientTransaction) 
            		clientTransactionId).getMessageChannel();
            oldChannel.uncache();
    if(!sipStack.cacheClientConnections)            
            {
                oldChannel.useCount--;
    if(sipStack.isLoggingEnabled())                
                sipStack.getStackLogger().logDebug(
                            "oldChannel: useCount " + oldChannel.useCount);
            } //End block
    if(messageChannel == null)            
            {
    if(sipStack.isLoggingEnabled())                
                sipStack.getStackLogger().logDebug(
                            "Null message channel using outbound proxy !");
                Hop outboundProxy = sipStack.getRouter(dialogRequest).getOutboundProxy();
    if(outboundProxy == null)                
                {
                SipException var9AC8763D57EEB5BB683F7F70FEAA781B_303861883 = new SipException("No route found! hop=" + hop);
                var9AC8763D57EEB5BB683F7F70FEAA781B_303861883.addTaint(taint);
                throw var9AC8763D57EEB5BB683F7F70FEAA781B_303861883;
                }
                messageChannel = sipStack.createRawMessageChannel(this.getSipProvider()
                        .getListeningPoint(outboundProxy.getTransport()).getIPAddress(),
                        this.firstTransactionPort, outboundProxy);
    if(messageChannel != null)                
                ((SIPClientTransaction) clientTransactionId)
                            .setEncapsulatedChannel(messageChannel);
            } //End block
            else
            {
                ((SIPClientTransaction) clientTransactionId)
                        .setEncapsulatedChannel(messageChannel);
    if(sipStack.isLoggingEnabled())                
                {
                    sipStack.getStackLogger().logDebug("using message channel " + messageChannel);
                } //End block
            } //End block
    if(messageChannel != null)            
            messageChannel.useCount++;
    if((!sipStack.cacheClientConnections) && oldChannel != null
                    && oldChannel.useCount <= 0)            
            oldChannel.close();
        } //End block
        catch (Exception ex)
        {
    if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger().logException(ex);
            SipException var468C13692024B7295EC1F941E9CCC62D_2064642510 = new SipException("Could not create message channel", ex);
            var468C13692024B7295EC1F941E9CCC62D_2064642510.addTaint(taint);
            throw var468C13692024B7295EC1F941E9CCC62D_2064642510;
        } //End block
        try 
        {
            localSequenceNumber++;
            dialogRequest.getCSeq().setSeqNumber(getLocalSeqNumber());
        } //End block
        catch (InvalidArgumentException ex)
        {
            sipStack.getStackLogger().logFatalError(ex.getMessage());
        } //End block
        try 
        {
            ((SIPClientTransaction) clientTransactionId).sendMessage(dialogRequest);
    if(dialogRequest.getMethod().equals(Request.BYE))            
            {
                this.byeSent = true;
    if(isTerminatedOnBye())                
                {
                    this.setState(DialogState._TERMINATED);
                } //End block
            } //End block
        } //End block
        catch (IOException ex)
        {
            SipException var77B5C32C270CE39CE5783EC262908103_836716977 = new SipException("error sending message", ex);
            var77B5C32C270CE39CE5783EC262908103_836716977.addTaint(taint);
            throw var77B5C32C270CE39CE5783EC262908103_836716977;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.751 -0400", hash_original_method = "BB6E18DBBED43A4BEB60B225A721A13E", hash_generated_method = "AF7C78ECA90DE7856F02E5C4DE010D90")
    private boolean toRetransmitFinalResponse(int T2) {
        addTaint(T2);
    if(--retransmissionTicksLeft == 0)        
        {
    if(2 * prevRetransmissionTicks <= T2)            
            this.retransmissionTicksLeft = 2 * prevRetransmissionTicks;
            else
            this.retransmissionTicksLeft = prevRetransmissionTicks;
            this.prevRetransmissionTicks = retransmissionTicksLeft;
            boolean varB326B5062B2F0E69046810717534CB09_232940781 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1945564058 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1945564058;
        } //End block
        else
        {
        boolean var68934A3E9455FA72420237EB05902327_1179715252 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_115500897 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_115500897;
        }
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.752 -0400", hash_original_method = "085350C5B4F086D4A04022EDF074C477", hash_generated_method = "CEED3E6C57E3AE5A6BAC9A7B6FFC14D3")
    protected void setRetransmissionTicks() {
        this.retransmissionTicksLeft = 1;
        this.prevRetransmissionTicks = 1;
        // ---------- Original Method ----------
        //this.retransmissionTicksLeft = 1;
        //this.prevRetransmissionTicks = 1;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.752 -0400", hash_original_method = "9B2F4C7AC7E3D2DC3FE02C5A18455E2B", hash_generated_method = "320AFE926AD118A104C0E3133D1D60CE")
    public void resendAck() throws SipException {
    if(this.getLastAckSent() != null)        
        {
    if(getLastAckSent().getHeader(TimeStampHeader.NAME) != null
                    && sipStack.generateTimeStampHeader)            
            {
                TimeStamp ts = new TimeStamp();
                try 
                {
                    ts.setTimeStamp(System.currentTimeMillis());
                    getLastAckSent().setHeader(ts);
                } //End block
                catch (InvalidArgumentException e)
                {
                } //End block
            } //End block
            this.sendAck(getLastAckSent(), false);
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.752 -0400", hash_original_method = "691C5451C67574E660997BC2056A5F23", hash_generated_method = "60A6C5C0940626D4240485E186E97EC7")
    public String getMethod() {
String varB88046C53AB584448F89DD952FF416E1_201281457 =         this.method;
        varB88046C53AB584448F89DD952FF416E1_201281457.addTaint(taint);
        return varB88046C53AB584448F89DD952FF416E1_201281457;
        // ---------- Original Method ----------
        //return this.method;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.752 -0400", hash_original_method = "1E91804F8A3049A9C15BCD340F87DF5D", hash_generated_method = "83B30C7FBFCF1B29A961CF8AFECA2BF3")
    protected void startTimer(SIPServerTransaction transaction) {
    if(this.timerTask != null && timerTask.transaction == transaction)        
        {
    if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger().logDebug("Timer already running for " + getDialogId());
            return;
        } //End block
    if(sipStack.isLoggingEnabled())        
        sipStack.getStackLogger().logDebug("Starting dialog timer for " + getDialogId());
        this.ackSeen = false;
        acquireTimerTaskSem();
        try 
        {
    if(this.timerTask != null)            
            {
                this.timerTask.transaction = transaction;
            } //End block
            else
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.752 -0400", hash_original_method = "3E7472F910A577F9E6FCB71153FF16E3", hash_generated_method = "D4E319FB69E8FF1956D149AC6AA63D2E")
    protected void stopTimer() {
        try 
        {
            acquireTimerTaskSem();
            try 
            {
    if(this.timerTask != null)                
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
        {
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.753 -0400", hash_original_method = "B99416CED2F5EC9B5AF4977F926F9FAE", hash_generated_method = "B2B5CC306DB608AF52FC5B941828BA8C")
    public Request createPrack(Response relResponse) throws DialogDoesNotExistException,
            SipException {
        addTaint(relResponse.getTaint());
    if(this.getState() == null || this.getState().equals(DialogState.TERMINATED))        
        {
        DialogDoesNotExistException var09B550480B16E964666DE59044C80F48_1719817408 = new DialogDoesNotExistException("Dialog not initialized or terminated");
        var09B550480B16E964666DE59044C80F48_1719817408.addTaint(taint);
        throw var09B550480B16E964666DE59044C80F48_1719817408;
        }
    if((RSeq) relResponse.getHeader(RSeqHeader.NAME) == null)        
        {
            SipException var0DEFD87ED90B1850324465A58720CE6D_2111756799 = new SipException("Missing RSeq Header");
            var0DEFD87ED90B1850324465A58720CE6D_2111756799.addTaint(taint);
            throw var0DEFD87ED90B1850324465A58720CE6D_2111756799;
        } //End block
        try 
        {
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
Request var329DEB38C1DE19DC8FC78D8608A5CF7E_1284899420 =             (Request) sipRequest;
            var329DEB38C1DE19DC8FC78D8608A5CF7E_1284899420.addTaint(taint);
            return var329DEB38C1DE19DC8FC78D8608A5CF7E_1284899420;
        } //End block
        catch (Exception ex)
        {
            InternalErrorHandler.handleException(ex);
Request var540C13E9E156B687226421B24F2DF178_62712275 =             null;
            var540C13E9E156B687226421B24F2DF178_62712275.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_62712275;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.753 -0400", hash_original_method = "AE874CF06DEDE92D6543D8F7D52B6043", hash_generated_method = "1D5FA0CF72832A2CD1D30B664619D640")
    private void updateRequest(SIPRequest sipRequest) {
        addTaint(sipRequest.getTaint());
        RouteList rl = this.getRouteList();
    if(rl.size() > 0)        
        {
            sipRequest.setHeader(rl);
        } //End block
        else
        {
            sipRequest.removeHeader(RouteHeader.NAME);
        } //End block
    if(MessageFactoryImpl.getDefaultUserAgentHeader() != null)        
        {
            sipRequest.setHeader(MessageFactoryImpl.getDefaultUserAgentHeader());
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.754 -0400", hash_original_method = "8ECB2239C30E6B6F2CF5AEE7662DC317", hash_generated_method = "07BB55B91E731A33A09130CBE2355B0A")
    public Request createAck(long cseqno) throws InvalidArgumentException, SipException {
        addTaint(cseqno);
    if(!method.equals(Request.INVITE))        
        {
        SipException varD02584A7C363913CAD5B51AA457F4962_1460460344 = new SipException("Dialog was not created with an INVITE" + method);
        varD02584A7C363913CAD5B51AA457F4962_1460460344.addTaint(taint);
        throw varD02584A7C363913CAD5B51AA457F4962_1460460344;
        }
    if(cseqno <= 0)        
        {
        InvalidArgumentException var934E5BD8D39225CB7C52B2E7052301F7_1171101357 = new InvalidArgumentException("bad cseq <= 0 ");
        var934E5BD8D39225CB7C52B2E7052301F7_1171101357.addTaint(taint);
        throw var934E5BD8D39225CB7C52B2E7052301F7_1171101357;
        }
        else
    if(cseqno > ((((long) 1) << 32) - 1))        
        {
        InvalidArgumentException varB5A670F491F0DDF66A69547D395EC5B7_819497576 = new InvalidArgumentException("bad cseq > " + ((((long) 1) << 32) - 1));
        varB5A670F491F0DDF66A69547D395EC5B7_819497576.addTaint(taint);
        throw varB5A670F491F0DDF66A69547D395EC5B7_819497576;
        }
    if(this.remoteTarget == null)        
        {
            SipException var60F9444AA3020D86DC18A4E36D28CADB_408926073 = new SipException("Cannot create ACK - no remote Target!");
            var60F9444AA3020D86DC18A4E36D28CADB_408926073.addTaint(taint);
            throw var60F9444AA3020D86DC18A4E36D28CADB_408926073;
        } //End block
    if(this.sipStack.isLoggingEnabled())        
        {
            this.sipStack.getStackLogger().logDebug("createAck " + this + " cseqno " + cseqno);
        } //End block
    if(lastInviteOkReceived < cseqno)        
        {
    if(sipStack.isLoggingEnabled())            
            {
                this.sipStack.getStackLogger().logDebug(
                    "WARNING : Attempt to crete ACK without OK " + this);
                this.sipStack.getStackLogger().logDebug("LAST RESPONSE = " + this.lastResponse);
            } //End block
            SipException varBE418CF2EB2C6A61DDA78AD60E2A6F62_215945012 = new SipException("Dialog not yet established -- no OK response!");
            varBE418CF2EB2C6A61DDA78AD60E2A6F62_215945012.addTaint(taint);
            throw varBE418CF2EB2C6A61DDA78AD60E2A6F62_215945012;
        } //End block
        try 
        {
            SipURI uri4transport = null;
    if(this.routeList != null && !this.routeList.isEmpty())            
            {
                Route r = (Route) this.routeList.getFirst();
                uri4transport = ((SipURI) r.getAddress().getURI());
            } //End block
            else
            {
                uri4transport = ((SipURI) this.remoteTarget.getURI());
            } //End block
            String transport = uri4transport.getTransportParam();
    if(transport == null)            
            {
                transport = uri4transport.isSecure() ? ListeningPoint.TLS : ListeningPoint.UDP;
            } //End block
            ListeningPointImpl lp = (ListeningPointImpl) sipProvider.getListeningPoint(transport);
    if(lp == null)            
            {
    if(sipStack.isLoggingEnabled())                
                {
                    sipStack.getStackLogger().logError(
                        "remoteTargetURI " + this.remoteTarget.getURI());
                    sipStack.getStackLogger().logError("uri4transport = " + uri4transport);
                    sipStack.getStackLogger().logError("No LP found for transport=" + transport);
                } //End block
                SipException var9A0626ACD1C4EC5171C51F465E6AD559_82971274 = new SipException(
                        "Cannot create ACK - no ListeningPoint for transport towards next hop found:"
                                + transport);
                var9A0626ACD1C4EC5171C51F465E6AD559_82971274.addTaint(taint);
                throw var9A0626ACD1C4EC5171C51F465E6AD559_82971274;
            } //End block
            SIPRequest sipRequest = new SIPRequest();
            sipRequest.setMethod(Request.ACK);
            sipRequest.setRequestURI((SipUri) getRemoteTarget().getURI().clone());
            sipRequest.setCallId(this.callIdHeader);
            sipRequest.setCSeq(new CSeq(cseqno, Request.ACK));
            List<Via> vias = new ArrayList<Via>();
            Via via = this.lastResponse.getTopmostVia();
            via.removeParameters();
    if(originalRequest != null && originalRequest.getTopmostVia() != null)            
            {
                NameValueList originalRequestParameters = originalRequest.getTopmostVia()
                        .getParameters();
    if(originalRequestParameters != null && originalRequestParameters.size() > 0)                
                {
                    via.setParameters((NameValueList) originalRequestParameters.clone());
                } //End block
            } //End block
            via.setBranch(Utils.getInstance().generateBranchId());
            vias.add(via);
            sipRequest.setVia(vias);
            From from = new From();
            from.setAddress(this.localParty);
            from.setTag(this.myTag);
            sipRequest.setFrom(from);
            To to = new To();
            to.setAddress(this.remoteParty);
    if(hisTag != null)            
            to.setTag(this.hisTag);
            sipRequest.setTo(to);
            sipRequest.setMaxForwards(new MaxForwards(70));
    if(this.originalRequest != null)            
            {
                Authorization authorization = this.originalRequest.getAuthorization();
    if(authorization != null)                
                sipRequest.setHeader(authorization);
            } //End block
            this.updateRequest(sipRequest);
Request varC7C20CEFE913CADDEFC247E46F836F62_1114837171 =             sipRequest;
            varC7C20CEFE913CADDEFC247E46F836F62_1114837171.addTaint(taint);
            return varC7C20CEFE913CADDEFC247E46F836F62_1114837171;
        } //End block
        catch (Exception ex)
        {
            InternalErrorHandler.handleException(ex);
            SipException varD00A786A6CEB1037956A251390E80EB2_639791699 = new SipException("unexpected exception ", ex);
            varD00A786A6CEB1037956A251390E80EB2_639791699.addTaint(taint);
            throw varD00A786A6CEB1037956A251390E80EB2_639791699;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.755 -0400", hash_original_method = "225E26F17D14C81F6F76A7525B288E82", hash_generated_method = "72C20F2FA3A7C0B8C9F6853C7353EDB6")
    public SipProviderImpl getSipProvider() {
SipProviderImpl varDA6985F98D2B970198C4C0F63DBC3E3D_1155909693 =         this.sipProvider;
        varDA6985F98D2B970198C4C0F63DBC3E3D_1155909693.addTaint(taint);
        return varDA6985F98D2B970198C4C0F63DBC3E3D_1155909693;
        // ---------- Original Method ----------
        //return this.sipProvider;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.755 -0400", hash_original_method = "8A8245F47D42BA43478E00CC55ABA836", hash_generated_method = "926E58A1A024385C486CD7AE44684A34")
    public void setSipProvider(SipProviderImpl sipProvider) {
        this.sipProvider = sipProvider;
        // ---------- Original Method ----------
        //this.sipProvider = sipProvider;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.755 -0400", hash_original_method = "CF7951DD9E6C51606E8031643391B018", hash_generated_method = "C1353F385285A7BF3D16079142D6518D")
    public void setResponseTags(SIPResponse sipResponse) {
        addTaint(sipResponse.getTaint());
    if(this.getLocalTag() != null || this.getRemoteTag() != null)        
        {
            return;
        } //End block
        String responseFromTag = sipResponse.getFromTag();
    if(responseFromTag != null)        
        {
    if(responseFromTag.equals(this.getLocalTag()))            
            {
                sipResponse.setToTag(this.getRemoteTag());
            } //End block
            else
    if(responseFromTag.equals(this.getRemoteTag()))            
            {
                sipResponse.setToTag(this.getLocalTag());
            } //End block
        } //End block
        else
        {
    if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger().logWarning("No from tag in response! Not RFC 3261 compatible.");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.759 -0400", hash_original_method = "80C5F1C3A7F1BF77711B99F831173748", hash_generated_method = "93C7C8580192C6FBE49A913CDC26798E")
    public void setLastResponse(SIPTransaction transaction, SIPResponse sipResponse) {
        addTaint(transaction.getTaint());
        this.callIdHeader = sipResponse.getCallId();
        int statusCode = sipResponse.getStatusCode();
    if(statusCode == 100)        
        {
    if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger().logWarning(
                    "Invalid status code - 100 in setLastResponse - ignoring");
            return;
        } //End block
        this.lastResponse = sipResponse;
        this.setAssigned();
    if(sipStack.isLoggingEnabled())        
        {
            sipStack.getStackLogger().logDebug(
                    "sipDialog: setLastResponse:" + this + " lastResponse = "
                            + this.lastResponse.getFirstLine());
        } //End block
    if(this.getState() == DialogState.TERMINATED)        
        {
    if(sipStack.isLoggingEnabled())            
            {
                sipStack.getStackLogger().logDebug(
                        "sipDialog: setLastResponse -- dialog is terminated - ignoring ");
            } //End block
    if(sipResponse.getCSeq().getMethod().equals(Request.INVITE) && statusCode == 200)            
            {
                this.lastInviteOkReceived = Math.max(sipResponse.getCSeq().getSeqNumber(),
                        this.lastInviteOkReceived);
            } //End block
            return;
        } //End block
        String cseqMethod = sipResponse.getCSeq().getMethod();
    if(sipStack.isLoggingEnabled())        
        {
            sipStack.getStackLogger().logStackTrace();
            sipStack.getStackLogger().logDebug("cseqMethod = " + cseqMethod);
            sipStack.getStackLogger().logDebug("dialogState = " + this.getState());
            sipStack.getStackLogger().logDebug("method = " + this.getMethod());
            sipStack.getStackLogger().logDebug("statusCode = " + statusCode);
            sipStack.getStackLogger().logDebug("transaction = " + transaction);
        } //End block
    if(transaction == null || transaction instanceof ClientTransaction)        
        {
    if(sipStack.isDialogCreated(cseqMethod))            
            {
    if(getState() == null && (statusCode / 100 == 1))                
                {
                    setState(SIPDialog.EARLY_STATE);
    if((sipResponse.getToTag() != null || sipStack.rfc2543Supported)
                            && this.getRemoteTag() == null)                    
                    {
                        setRemoteTag(sipResponse.getToTag());
                        this.setDialogId(sipResponse.getDialogId(false));
                        sipStack.putDialog(this);
                        this.addRoute(sipResponse);
                    } //End block
                } //End block
                else
    if(getState() != null && getState().equals(DialogState.EARLY)
                        && statusCode / 100 == 1)                
                {
    if(cseqMethod.equals(getMethod()) && transaction != null
                            && (sipResponse.getToTag() != null || sipStack.rfc2543Supported))                    
                    {
                        setRemoteTag(sipResponse.getToTag());
                        this.setDialogId(sipResponse.getDialogId(false));
                        sipStack.putDialog(this);
                        this.addRoute(sipResponse);
                    } //End block
                } //End block
                else
    if(statusCode / 100 == 2)                
                {
    if(cseqMethod.equals(getMethod())
                            && (sipResponse.getToTag() != null || sipStack.rfc2543Supported)
                            && this.getState() != DialogState.CONFIRMED)                    
                    {
                        setRemoteTag(sipResponse.getToTag());
                        this.setDialogId(sipResponse.getDialogId(false));
                        sipStack.putDialog(this);
                        this.addRoute(sipResponse);
                        setState(SIPDialog.CONFIRMED_STATE);
                    } //End block
    if(cseqMethod.equals(Request.INVITE))                    
                    {
                        this.lastInviteOkReceived = Math.max(sipResponse.getCSeq().getSeqNumber(),
                                this.lastInviteOkReceived);
                    } //End block
                } //End block
                else
    if(statusCode >= 300
                        && statusCode <= 699
                        && (getState() == null || (cseqMethod.equals(getMethod()) && getState()
                                .getValue() == SIPDialog.EARLY_STATE)))                
                {
                    setState(SIPDialog.TERMINATED_STATE);
                } //End block
    if(this.getState() != DialogState.CONFIRMED && this.getState() != DialogState.TERMINATED)                
                {
    if(originalRequest != null)                    
                    {
                        RecordRouteList rrList = originalRequest.getRecordRouteHeaders();
    if(rrList != null)                        
                        {
                            ListIterator<RecordRoute> it = rrList.listIterator(rrList.size());
                            while
(it.hasPrevious())                            
                            {
                                RecordRoute rr = (RecordRoute) it.previous();
                                Route route = (Route) routeList.getFirst();
    if(route != null && rr.getAddress().equals(route.getAddress()))                                
                                {
                                    routeList.removeFirst();
                                } //End block
                                else
                                break;
                            } //End block
                        } //End block
                    } //End block
                } //End block
            } //End block
            else
    if(cseqMethod.equals(Request.NOTIFY)
                    && (this.getMethod().equals(Request.SUBSCRIBE) || this.getMethod().equals(
                            Request.REFER)) && sipResponse.getStatusCode() / 100 == 2
                    && this.getState() == null)            
            {
                this.setDialogId(sipResponse.getDialogId(true));
                sipStack.putDialog(this);
                this.setState(SIPDialog.CONFIRMED_STATE);
            } //End block
            else
    if(cseqMethod.equals(Request.BYE) && statusCode / 100 == 2
                    && isTerminatedOnBye())            
            {
                setState(SIPDialog.TERMINATED_STATE);
            } //End block
        } //End block
        else
        {
    if(cseqMethod.equals(Request.BYE) && statusCode / 100 == 2
                    && this.isTerminatedOnBye())            
            {
                this.setState(SIPDialog.TERMINATED_STATE);
            } //End block
            else
            {
                boolean doPutDialog = false;
    if(getLocalTag() == null && sipResponse.getTo().getTag() != null
                        && sipStack.isDialogCreated(cseqMethod) && cseqMethod.equals(getMethod()))                
                {
                    setLocalTag(sipResponse.getTo().getTag());
                    doPutDialog = true;
                } //End block
    if(statusCode / 100 != 2)                
                {
    if(statusCode / 100 == 1)                    
                    {
    if(doPutDialog)                        
                        {
                            setState(SIPDialog.EARLY_STATE);
                            this.setDialogId(sipResponse.getDialogId(true));
                            sipStack.putDialog(this);
                        } //End block
                    } //End block
                    else
                    {
    if(statusCode == 489
                                && (cseqMethod.equals(Request.NOTIFY) || cseqMethod
                                        .equals(Request.SUBSCRIBE)))                        
                        {
    if(sipStack.isLoggingEnabled())                            
                            sipStack.getStackLogger().logDebug(
                                    "RFC 3265 : Not setting dialog to TERMINATED for 489");
                        } //End block
                        else
                        {
    if(!this.isReInvite() && getState() != DialogState.CONFIRMED)                            
                            {
                                this.setState(SIPDialog.TERMINATED_STATE);
                            } //End block
                        } //End block
                    } //End block
                } //End block
                else
                {
    if(this.dialogState <= SIPDialog.EARLY_STATE
                            && (cseqMethod.equals(Request.INVITE)
                                    || cseqMethod.equals(Request.SUBSCRIBE) || cseqMethod
                                    .equals(Request.REFER)))                    
                    {
                        this.setState(SIPDialog.CONFIRMED_STATE);
                    } //End block
    if(doPutDialog)                    
                    {
                        this.setDialogId(sipResponse.getDialogId(true));
                        sipStack.putDialog(this);
                    } //End block
    if(transaction.getState() != TransactionState.TERMINATED
                            && sipResponse.getStatusCode() == Response.OK
                            && cseqMethod.equals(Request.INVITE)
                            && this.isBackToBackUserAgent)                    
                    {
    if(!this.takeAckSem())                        
                        {
    if(sipStack.isLoggingEnabled())                            
                            {
                                sipStack.getStackLogger().logDebug(
                                            "Delete dialog -- cannot acquire ackSem");
                            } //End block
                            this.delete();
                            return;
                        } //End block
                    } //End block
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.761 -0400", hash_original_method = "96CF2F98DDD4CA038A3AFDF5A5247694", hash_generated_method = "EA7D219ACC547CE928E2D29D66656D92")
    public void startRetransmitTimer(SIPServerTransaction sipServerTx, Response response) {
        addTaint(response.getTaint());
        addTaint(sipServerTx.getTaint());
    if(sipServerTx.getRequest().getMethod().equals(Request.INVITE)
                && response.getStatusCode() / 100 == 2)        
        {
            this.startTimer(sipServerTx);
        } //End block
        // ---------- Original Method ----------
        //if (sipServerTx.getRequest().getMethod().equals(Request.INVITE)
                //&& response.getStatusCode() / 100 == 2) {
            //this.startTimer(sipServerTx);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.761 -0400", hash_original_method = "5F3E7F6102F24C611CAB04E5AE199DBF", hash_generated_method = "0407567DFD7C2ECD44BF405FB804B565")
    public SIPResponse getLastResponse() {
SIPResponse varB79F2C108A34EA379E0E4ADD4F794C06_308148279 =         lastResponse;
        varB79F2C108A34EA379E0E4ADD4F794C06_308148279.addTaint(taint);
        return varB79F2C108A34EA379E0E4ADD4F794C06_308148279;
        // ---------- Original Method ----------
        //return lastResponse;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.761 -0400", hash_original_method = "5B8AFE9B6B91DF83BE42F6862D2EF06A", hash_generated_method = "F73C501318BAFBD578FA6FBE51B01669")
    private void doTargetRefresh(SIPMessage sipMessage) {
        addTaint(sipMessage.getTaint());
        ContactList contactList = sipMessage.getContactHeaders();
    if(contactList != null)        
        {
            Contact contact = (Contact) contactList.getFirst();
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.762 -0400", hash_original_method = "DE196281E5E185EC5F05D42F6040C5AD", hash_generated_method = "68B6C9C9EB0D74C6C878DC79578E7F02")
    public Response createReliableProvisionalResponse(int statusCode) throws InvalidArgumentException, SipException {
        addTaint(statusCode);
    if(!(firstTransactionIsServerTransaction))        
        {
            SipException var3773B5C9D0D026ED5F7C49046CF095A8_396097080 = new SipException("Not a Server Dialog!");
            var3773B5C9D0D026ED5F7C49046CF095A8_396097080.addTaint(taint);
            throw var3773B5C9D0D026ED5F7C49046CF095A8_396097080;
        } //End block
    if(statusCode <= 100 || statusCode > 199)        
        {
        InvalidArgumentException var55BFAF999A027E1124578AC5D72C3AD2_1069225194 = new InvalidArgumentException("Bad status code ");
        var55BFAF999A027E1124578AC5D72C3AD2_1069225194.addTaint(taint);
        throw var55BFAF999A027E1124578AC5D72C3AD2_1069225194;
        }
        SIPRequest request = this.originalRequest;
    if(!request.getMethod().equals(Request.INVITE))        
        {
        SipException var81A8F80D2F06A653BE0995B742338790_1056897365 = new SipException("Bad method");
        var81A8F80D2F06A653BE0995B742338790_1056897365.addTaint(taint);
        throw var81A8F80D2F06A653BE0995B742338790_1056897365;
        }
        ListIterator<SIPHeader> list = request.getHeaders(SupportedHeader.NAME);
    if(list == null || !optionPresent(list, "100rel"))        
        {
            list = request.getHeaders(RequireHeader.NAME);
    if(list == null || !optionPresent(list, "100rel"))            
            {
                SipException varF77F0DCFF8B82A25AE5808B05365E961_100722370 = new SipException("No Supported/Require 100rel header in the request");
                varF77F0DCFF8B82A25AE5808B05365E961_100722370.addTaint(taint);
                throw varF77F0DCFF8B82A25AE5808B05365E961_100722370;
            } //End block
        } //End block
        SIPResponse response = request.createResponse(statusCode);
        Require require = new Require();
        try 
        {
            require.setOptionTag("100rel");
        } //End block
        catch (Exception ex)
        {
            InternalErrorHandler.handleException(ex);
        } //End block
        response.addHeader(require);
        RSeq rseq = new RSeq();
        rseq.setSeqNumber(1L);
        RecordRouteList rrl = request.getRecordRouteHeaders();
    if(rrl != null)        
        {
            RecordRouteList rrlclone = (RecordRouteList) rrl.clone();
            response.setHeader(rrlclone);
        } //End block
Response var2A1114F4272D753FE23A36E3D68CD293_1587961376 =         response;
        var2A1114F4272D753FE23A36E3D68CD293_1587961376.addTaint(taint);
        return var2A1114F4272D753FE23A36E3D68CD293_1587961376;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.763 -0400", hash_original_method = "CEB91EBD9D583AC6C7E366C7B6D0F858", hash_generated_method = "94D5AEF5C2FA77D9D9ABD8971F22E518")
    public boolean handlePrack(SIPRequest prackRequest) {
        addTaint(prackRequest.getTaint());
    if(!this.isServer())        
        {
    if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger().logDebug("Dropping Prack -- not a server Dialog");
            boolean var68934A3E9455FA72420237EB05902327_1045680654 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_907520537 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_907520537;
        } //End block
        SIPServerTransaction sipServerTransaction = (SIPServerTransaction) this
                .getFirstTransaction();
        SIPResponse sipResponse = sipServerTransaction.getReliableProvisionalResponse();
    if(sipResponse == null)        
        {
    if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger()
                        .logDebug("Dropping Prack -- ReliableResponse not found");
            boolean var68934A3E9455FA72420237EB05902327_1144350707 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1152017240 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1152017240;
        } //End block
        RAck rack = (RAck) prackRequest.getHeader(RAckHeader.NAME);
    if(rack == null)        
        {
    if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger().logDebug("Dropping Prack -- rack header not found");
            boolean var68934A3E9455FA72420237EB05902327_405442940 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1085458738 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1085458738;
        } //End block
        CSeq cseq = (CSeq) sipResponse.getCSeq();
    if(!rack.getMethod().equals(cseq.getMethod()))        
        {
    if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger().logDebug(
                        "Dropping Prack -- CSeq Header does not match PRACK");
            boolean var68934A3E9455FA72420237EB05902327_787621449 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_829292388 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_829292388;
        } //End block
    if(rack.getCSeqNumberLong() != cseq.getSeqNumber())        
        {
    if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger().logDebug(
                        "Dropping Prack -- CSeq Header does not match PRACK");
            boolean var68934A3E9455FA72420237EB05902327_1960745849 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1166542393 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1166542393;
        } //End block
        RSeq rseq = (RSeq) sipResponse.getHeader(RSeqHeader.NAME);
    if(rack.getRSequenceNumber() != rseq.getSeqNumber())        
        {
    if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger().logDebug(
                        "Dropping Prack -- RSeq Header does not match PRACK");
            boolean var68934A3E9455FA72420237EB05902327_1755081118 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1445415715 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1445415715;
        } //End block
        boolean var52C2AA060441B1563D3FEACD05B8E6D9_223160480 = (sipServerTransaction.prackRecieved());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1460643351 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1460643351;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.764 -0400", hash_original_method = "333DA078CA74B6FD5F6C9544F533B1F3", hash_generated_method = "1FACD8B08A14E2EC4C931280852FD466")
    public void sendReliableProvisionalResponse(Response relResponse) throws SipException {
        addTaint(relResponse.getTaint());
    if(!this.isServer())        
        {
            SipException varE4DA6432C2E2972F783F43BFFDB8C2F7_542171773 = new SipException("Not a Server Dialog");
            varE4DA6432C2E2972F783F43BFFDB8C2F7_542171773.addTaint(taint);
            throw varE4DA6432C2E2972F783F43BFFDB8C2F7_542171773;
        } //End block
        SIPResponse sipResponse = (SIPResponse) relResponse;
    if(relResponse.getStatusCode() == 100)        
        {
        SipException varC489026DD97701439037C421CB880578_872700364 = new SipException("Cannot send 100 as a reliable provisional response");
        varC489026DD97701439037C421CB880578_872700364.addTaint(taint);
        throw varC489026DD97701439037C421CB880578_872700364;
        }
    if(relResponse.getStatusCode() / 100 > 2)        
        {
        SipException varA5CC7C80B0829AEB7C20D7246B8A9989_667507290 = new SipException(
                    "Response code is not a 1xx response - should be in the range 101 to 199 ");
        varA5CC7C80B0829AEB7C20D7246B8A9989_667507290.addTaint(taint);
        throw varA5CC7C80B0829AEB7C20D7246B8A9989_667507290;
        }
    if(sipResponse.getToTag() == null)        
        {
            SipException var50AF0F9395D086659C2CA56B2D0A0DB1_94929523 = new SipException(
                    "Badly formatted response -- To tag mandatory for Reliable Provisional Response");
            var50AF0F9395D086659C2CA56B2D0A0DB1_94929523.addTaint(taint);
            throw var50AF0F9395D086659C2CA56B2D0A0DB1_94929523;
        } //End block
        ListIterator requireList = (ListIterator) relResponse.getHeaders(RequireHeader.NAME);
        boolean found = false;
    if(requireList != null)        
        {
            while
(requireList.hasNext() && !found)            
            {
                RequireHeader rh = (RequireHeader) requireList.next();
    if(rh.getOptionTag().equalsIgnoreCase("100rel"))                
                {
                    found = true;
                } //End block
            } //End block
        } //End block
    if(!found)        
        {
            Require require = new Require("100rel");
            relResponse.addHeader(require);
    if(sipStack.isLoggingEnabled())            
            {
                sipStack.getStackLogger().logDebug(
                        "Require header with optionTag 100rel is needed -- adding one");
            } //End block
        } //End block
        SIPServerTransaction serverTransaction = (SIPServerTransaction) this
                .getFirstTransaction();
        this.setLastResponse(serverTransaction, sipResponse);
        this.setDialogId(sipResponse.getDialogId(true));
        serverTransaction.sendReliableProvisionalResponse(relResponse);
        this.startRetransmitTimer(serverTransaction, relResponse);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.764 -0400", hash_original_method = "BF7D1FA3BFA6C180C8021919F244470C", hash_generated_method = "98FB51F17347B278C789B0BBB791F331")
    public void terminateOnBye(boolean terminateFlag) throws SipException {
        this.terminateOnBye = terminateFlag;
        // ---------- Original Method ----------
        //this.terminateOnBye = terminateFlag;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.764 -0400", hash_original_method = "97AA8D077ED8B88563B1FCEB7D3F7A03", hash_generated_method = "3989220F20B7D3A9147AB058D826F7D8")
    public void setAssigned() {
        this.isAssigned = true;
        // ---------- Original Method ----------
        //this.isAssigned = true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.765 -0400", hash_original_method = "F8427D0E95C386EDB403D30E8B4BBEC5", hash_generated_method = "D448D2F396FD2E3EFDD13C22A9CE11C7")
    public boolean isAssigned() {
        boolean var14CB8E5A37F977439F828E930DF8F30A_1150283838 = (this.isAssigned);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_984000728 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_984000728;
        // ---------- Original Method ----------
        //return this.isAssigned;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.765 -0400", hash_original_method = "370EA53498504D191CA2C54D6246F992", hash_generated_method = "E1764756DB2E5FCDB5C99B8CE0697D5D")
    public Contact getMyContactHeader() {
Contact varC24CB696957C609CCF2B0FDF0E2B15CD_201431820 =         contactHeader;
        varC24CB696957C609CCF2B0FDF0E2B15CD_201431820.addTaint(taint);
        return varC24CB696957C609CCF2B0FDF0E2B15CD_201431820;
        // ---------- Original Method ----------
        //return contactHeader;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.765 -0400", hash_original_method = "1F7F0E32648D183A0E0322F85F939567", hash_generated_method = "9DFB67A5C1FB67511FA299A3CF6463A4")
    public boolean handleAck(SIPServerTransaction ackTransaction) {
        addTaint(ackTransaction.getTaint());
        SIPRequest sipRequest = ackTransaction.getOriginalRequest();
    if(isAckSeen() && getRemoteSeqNumber() == sipRequest.getCSeq().getSeqNumber())        
        {
    if(sipStack.isLoggingEnabled())            
            {
                sipStack.getStackLogger().logDebug(
                        "ACK already seen by dialog -- dropping Ack" + " retransmission");
            } //End block
            acquireTimerTaskSem();
            try 
            {
    if(this.timerTask != null)                
                {
                    this.timerTask.cancel();
                    this.timerTask = null;
                } //End block
            } //End block
            finally 
            {
                releaseTimerTaskSem();
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_1319497002 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_602463766 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_602463766;
        } //End block
        else
    if(this.getState() == DialogState.TERMINATED)        
        {
    if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger().logDebug("Dialog is terminated -- dropping ACK");
            boolean var68934A3E9455FA72420237EB05902327_1427423544 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_49259975 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_49259975;
        } //End block
        else
        {
            SIPServerTransaction tr = getInviteTransaction();
            SIPResponse sipResponse = (tr != null ? tr.getLastResponse() : null);
    if(tr != null
                    && sipResponse != null
                    && sipResponse.getStatusCode() / 100 == 2
                    && sipResponse.getCSeq().getMethod().equals(Request.INVITE)
                    && sipResponse.getCSeq().getSeqNumber() == sipRequest.getCSeq()
                            .getSeqNumber())            
            {
                ackTransaction.setDialog(this, sipResponse.getDialogId(false));
                ackReceived(sipRequest);
    if(sipStack.isLoggingEnabled())                
                sipStack.getStackLogger().logDebug("ACK for 2XX response --- sending to TU ");
                boolean varB326B5062B2F0E69046810717534CB09_1806262380 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1828236493 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1828236493;
            } //End block
            else
            {
    if(sipStack.isLoggingEnabled())                
                sipStack.getStackLogger().logDebug(
                            " INVITE transaction not found  -- Discarding ACK");
                boolean var68934A3E9455FA72420237EB05902327_1370463591 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_375205359 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_375205359;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.768 -0400", hash_original_method = "5C164F59F3DF11F779F16A5BAEE8EAC7", hash_generated_method = "F2805544ABD5BF70A703EFAA8BCD0891")
     void setEarlyDialogId(String earlyDialogId) {
        this.earlyDialogId = earlyDialogId;
        // ---------- Original Method ----------
        //this.earlyDialogId = earlyDialogId;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.768 -0400", hash_original_method = "275E7276434F5D20F41DC92B4F25BAEE", hash_generated_method = "A6C10135D915E891FE028BDCB5C0F162")
     String getEarlyDialogId() {
String var5E770A468DCD83168A71F3D41C9B3988_344693167 =         earlyDialogId;
        var5E770A468DCD83168A71F3D41C9B3988_344693167.addTaint(taint);
        return var5E770A468DCD83168A71F3D41C9B3988_344693167;
        // ---------- Original Method ----------
        //return earlyDialogId;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.768 -0400", hash_original_method = "5A72AC369AA326C1E4BE607E2D1E31FF", hash_generated_method = "309C08D6ECEDA1CBB998A4CDE908E687")
     void releaseAckSem() {
    if(this.isBackToBackUserAgent)        
        {
    if(sipStack.isLoggingEnabled())            
            {
                sipStack.getStackLogger().logDebug("releaseAckSem]" + this);
            } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.769 -0400", hash_original_method = "75493DFA4E25D8A29CC5DF9217BF734F", hash_generated_method = "4A15CBB3690D2825DBD27A3198C53266")
     boolean takeAckSem() {
    if(sipStack.isLoggingEnabled())        
        {
            sipStack.getStackLogger().logDebug("[takeAckSem " + this);
        } //End block
        try 
        {
    if(!this.ackSem.tryAcquire(2, TimeUnit.SECONDS))            
            {
    if(sipStack.isLoggingEnabled())                
                {
                    sipStack.getStackLogger().logError("Cannot aquire ACK semaphore");
                } //End block
    if(sipStack.isLoggingEnabled())                
                {
                    sipStack.getStackLogger().logDebug("Semaphore previously acquired at " + this.stackTrace);
                    sipStack.getStackLogger().logStackTrace();
                } //End block
                boolean var68934A3E9455FA72420237EB05902327_781116563 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_716600269 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_716600269;
            } //End block
    if(sipStack.isLoggingEnabled())            
            {
                this.recordStackTrace();
            } //End block
        } //End block
        catch (InterruptedException ex)
        {
            sipStack.getStackLogger().logError("Cannot aquire ACK semaphore");
            boolean var68934A3E9455FA72420237EB05902327_2019510382 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_972255337 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_972255337;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_392050105 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_513888020 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_513888020;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.772 -0400", hash_original_method = "68D4C33CE448DB45C09F49FC9815E4FD", hash_generated_method = "EAFEA098C1D75D51099230EDA00E4652")
    private void setLastAckReceived(SIPRequest lastAckReceived) {
        this.lastAckReceived = lastAckReceived;
        // ---------- Original Method ----------
        //this.lastAckReceived = lastAckReceived;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.773 -0400", hash_original_method = "2894D6C9FD5402948626BDE17D2ADDA1", hash_generated_method = "321988DB500C017D88E9AB3FF17ECAE4")
    protected SIPRequest getLastAckReceived() {
SIPRequest varFA84105AD136BC5C28A74CDCB14A99CB_466348774 =         lastAckReceived;
        varFA84105AD136BC5C28A74CDCB14A99CB_466348774.addTaint(taint);
        return varFA84105AD136BC5C28A74CDCB14A99CB_466348774;
        // ---------- Original Method ----------
        //return lastAckReceived;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.773 -0400", hash_original_method = "AE316349F4F2DB7FF5C817D5A1FDA212", hash_generated_method = "A753A427692B7DEB55775EE2604691AF")
    private void setLastAckSent(SIPRequest lastAckSent) {
        this.lastAckSent = lastAckSent;
        // ---------- Original Method ----------
        //this.lastAckSent = lastAckSent;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.773 -0400", hash_original_method = "2B44FD1497547940266A6934DB958355", hash_generated_method = "1AF5D064059E7B2F0588DB3750BF3038")
    public boolean isAtleastOneAckSent() {
        boolean var899977E531E13C0EECD2DF072265BD85_1773579290 = (this.isAcknowledged);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_773529400 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_773529400;
        // ---------- Original Method ----------
        //return this.isAcknowledged;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.773 -0400", hash_original_method = "FAA2C5BC01CFE296F7D6D441890115F1", hash_generated_method = "786535A54B98265FF67BEC859630D71C")
    public boolean isBackToBackUserAgent() {
        boolean varA761FA151474EE9805C566683EFC4195_1195111492 = (this.isBackToBackUserAgent);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_220626853 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_220626853;
        // ---------- Original Method ----------
        //return this.isBackToBackUserAgent;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.773 -0400", hash_original_method = "1ECA22F9D5D81E6992181CD96CD57EA7", hash_generated_method = "D9B00C60EEFD5F118561FEC3B86223E6")
    public synchronized void doDeferredDeleteIfNoAckSent(long seqno) {
    if(sipStack.getTimer() == null)        
        {
            this.setState(TERMINATED_STATE);
        } //End block
        else
    if(dialogDeleteIfNoAckSentTask == null)        
        {
            dialogDeleteIfNoAckSentTask = new DialogDeleteIfNoAckSentTask(seqno);
            sipStack.getTimer().schedule(
					dialogDeleteIfNoAckSentTask,
					SIPTransaction.TIMER_J
							* SIPTransactionStack.BASE_TIMER_INTERVAL);
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.775 -0400", hash_original_method = "782C3B034CC64F54A5BC7BB8ED6FEDA6", hash_generated_method = "5483C632656F6DE6E777597D7F71485A")
    public void setBackToBackUserAgent() {
        this.isBackToBackUserAgent = true;
        // ---------- Original Method ----------
        //this.isBackToBackUserAgent = true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.775 -0400", hash_original_method = "3A5B567A7D7C4A4D6D60D4CFA5E677D1", hash_generated_method = "7BAC4027A96DC4EF4D3F6FDC57AE2153")
     EventHeader getEventHeader() {
EventHeader var831190736CCDD70E51757EC097B34D0B_1153655363 =         eventHeader;
        var831190736CCDD70E51757EC097B34D0B_1153655363.addTaint(taint);
        return var831190736CCDD70E51757EC097B34D0B_1153655363;
        // ---------- Original Method ----------
        //return eventHeader;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.775 -0400", hash_original_method = "C85F235E26C94FDBCE92FE9C88454CDD", hash_generated_method = "63FC881403C5365782CA2C6D3EBC0C51")
     void setEventHeader(EventHeader eventHeader) {
        this.eventHeader = eventHeader;
        // ---------- Original Method ----------
        //this.eventHeader = eventHeader;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.775 -0400", hash_original_method = "D178A1777AB3611D9691A3F4A69F3B06", hash_generated_method = "944F48638C23857FD7322257F37AD5CE")
     void setServerTransactionFlag(boolean serverTransactionFlag) {
        this.serverTransactionFlag = serverTransactionFlag;
        // ---------- Original Method ----------
        //this.serverTransactionFlag = serverTransactionFlag;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.776 -0400", hash_original_method = "B9FC7E5C15DF48754B63587E10ABF39E", hash_generated_method = "6E41B13A7FD0796718F54CCE53804461")
     void setReInviteFlag(boolean reInviteFlag) {
        this.reInviteFlag = reInviteFlag;
        // ---------- Original Method ----------
        //this.reInviteFlag = reInviteFlag;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.776 -0400", hash_original_method = "554E3D8C2985A7B76F710766F6151401", hash_generated_method = "E0719A8ACF216DAD45D428EB1E108849")
    public boolean isSequnceNumberValidation() {
        boolean var45F75ED04429BCCB8A5AA83E3B8A3DAD_887401006 = (this.sequenceNumberValidation);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_45901171 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_45901171;
        // ---------- Original Method ----------
        //return this.sequenceNumberValidation;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.777 -0400", hash_original_method = "07E72D397966AE985C4FA6CA39D288C5", hash_generated_method = "2CA8E42865DEC07CBC74D648985E0DA5")
    public void disableSequenceNumberValidation() {
        this.sequenceNumberValidation = false;
        // ---------- Original Method ----------
        //this.sequenceNumberValidation = false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.777 -0400", hash_original_method = "32EDC5DA45A565F7D6F42D86C325067F", hash_generated_method = "F1D9693CB110FC9FB476CA0860F1E472")
    public void acquireTimerTaskSem() {
        boolean acquired = false;
        try 
        {
            acquired = this.timerTaskLock.tryAcquire(10, TimeUnit.SECONDS);
        } //End block
        catch (InterruptedException ex)
        {
            acquired = false;
        } //End block
    if(!acquired)        
        {
            IllegalStateException var5395418F8C30CD49157CE8988443BED4_1209378364 = new IllegalStateException("Impossible to acquire the dialog timer task lock");
            var5395418F8C30CD49157CE8988443BED4_1209378364.addTaint(taint);
            throw var5395418F8C30CD49157CE8988443BED4_1209378364;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.778 -0400", hash_original_method = "7C538F01F8063281F04142649C9B2CD0", hash_generated_method = "3B7BE3389027D7D895A0B9E59CA6FC3E")
    public void releaseTimerTaskSem() {
        this.timerTaskLock.release();
        // ---------- Original Method ----------
        //this.timerTaskLock.release();
    }

    
    public class ReInviteSender implements Runnable, Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.778 -0400", hash_original_field = "ECACFFFFC22141F3C1C9CF77DDF0308D", hash_generated_field = "E3567853C7773291F6ADDE73672244A1")

        ClientTransaction ctx;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.778 -0400", hash_original_method = "420F244B37AE2567998EBC3FAC66EFCB", hash_generated_method = "F7A2B4C9B57CD24D4C0C2169969C8DE0")
        public  ReInviteSender(ClientTransaction ctx) {
            this.ctx = ctx;
            // ---------- Original Method ----------
            //this.ctx = ctx;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.778 -0400", hash_original_method = "05496AD165548F09E9869029BA920071", hash_generated_method = "1ADB0BBCC5965FA3A846905A0639F5FF")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.780 -0400", hash_original_method = "DA8B28F4804F3F25626961946D2074C4", hash_generated_method = "CB75E74C42DAD09E8C3E83F15B65E4B0")
        public void run() {
            try 
            {
                long timeToWait = 0;
                long startTime = System.currentTimeMillis();
    if(!SIPDialog.this.takeAckSem())                
                {
    if(sipStack.isLoggingEnabled())                    
                    sipStack.getStackLogger().logError(
                            "Could not send re-INVITE time out ClientTransaction");
                    ((SIPClientTransaction) ctx).fireTimeoutTimer();
    if(sipProvider.getSipListener() != null && sipProvider.getSipListener() instanceof SipListenerExt)                    
                    {
                        raiseErrorEvent(SIPDialogErrorEvent.DIALOG_REINVITE_TIMEOUT);
                    } //End block
                    else
                    {
                        Request byeRequest = SIPDialog.this.createRequest(Request.BYE);
    if(MessageFactoryImpl.getDefaultUserAgentHeader() != null)                        
                        {
                            byeRequest.addHeader(MessageFactoryImpl.getDefaultUserAgentHeader());
                        } //End block
                        ReasonHeader reasonHeader = new Reason();
                        reasonHeader.setCause(1024);
                        reasonHeader.setText("Timed out waiting to re-INVITE");
                        byeRequest.addHeader(reasonHeader);
                        ClientTransaction byeCtx = SIPDialog.this.getSipProvider().getNewClientTransaction(byeRequest);
                        SIPDialog.this.sendRequest(byeCtx);
                        return;
                    } //End block
                } //End block
    if(getState() != DialogState.TERMINATED)                
                {
                    timeToWait = System.currentTimeMillis() - startTime;
                } //End block
                try 
                {
    if(timeToWait != 0)                    
                    {
                        Thread.sleep(SIPDialog.this.reInviteWaitTime);
                    } //End block
                } //End block
                catch (InterruptedException ex)
                {
    if(sipStack.isLoggingEnabled())                    
                    sipStack.getStackLogger().logDebug("Interrupted sleep");
                    return;
                } //End block
    if(SIPDialog.this.getState() != DialogState.TERMINATED)                
                {
                    SIPDialog.this.sendRequest(ctx, true);
                } //End block
    if(sipStack.isLoggingEnabled())                
                sipStack.getStackLogger().logDebug("re-INVITE successfully sent");
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.781 -0400", hash_original_field = "9E5A19325F636A5E87AC67BC6DE47179", hash_generated_field = "85664C6B81A73D64F3D428B9B5907950")

        private static final long serialVersionUID = 1019346148741070635L;
    }


    
    class LingerTimer extends SIPStackTimerTask implements Serializable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.781 -0400", hash_original_method = "FEDA9229694989A502508E95A3FCFE54", hash_generated_method = "CF6D3A28041C64960D5CFB7948EF46EA")
        public  LingerTimer() {
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.781 -0400", hash_original_method = "CEEC3EAE1C5B12DC43D70E37F1A80A0A", hash_generated_method = "EE501E16522ABE97FA44C3300D0D5F84")
        protected void runTask() {
            SIPDialog dialog = SIPDialog.this;
    if(eventListeners != null)            
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.781 -0400", hash_original_field = "7CB2C68EFA45F05A90FB1DC2EE9998C4", hash_generated_field = "A1A6593A1DD707EE1D2696D147E58630")

        int nRetransmissions;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.781 -0400", hash_original_field = "F4D5B76A2418EBA4BAEABC1ED9142B54", hash_generated_field = "9542A919750E0FF108E7D24E8ABAA715")

        SIPServerTransaction transaction;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.781 -0400", hash_original_method = "99967D6CED868AEC0B4229119C79B2A3", hash_generated_method = "06BD75BECC309B66DC13C9730079A32C")
        public  DialogTimerTask(SIPServerTransaction transaction) {
            this.transaction = transaction;
            this.nRetransmissions = 0;
            // ---------- Original Method ----------
            //this.transaction = transaction;
            //this.nRetransmissions = 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.782 -0400", hash_original_method = "7353CE022084912970B9E490A7F56F25", hash_generated_method = "1764148C8631C0EA40E1D3AC22307680")
        protected void runTask() {
            SIPDialog dialog = SIPDialog.this;
    if(sipStack.isLoggingEnabled())            
            sipStack.getStackLogger().logDebug("Running dialog timer");
            nRetransmissions++;
            SIPServerTransaction transaction = this.transaction;
    if(nRetransmissions > 64 * SIPTransaction.T1)            
            {
    if(sipProvider.getSipListener() != null && sipProvider.getSipListener() instanceof SipListenerExt)                
                {
                    raiseErrorEvent(SIPDialogErrorEvent.DIALOG_ACK_NOT_RECEIVED_TIMEOUT);
                } //End block
                else
                {
                    dialog.delete();
                } //End block
    if(transaction != null
                        && transaction.getState() != javax.sip.TransactionState.TERMINATED)                
                {
                    transaction.raiseErrorEvent(SIPTransactionErrorEvent.TIMEOUT_ERROR);
                } //End block
            } //End block
            else
    if((!dialog.ackSeen) && (transaction != null))            
            {
                SIPResponse response = transaction.getLastResponse();
    if(response.getStatusCode() == 200)                
                {
                    try 
                    {
    if(dialog.toRetransmitFinalResponse(transaction.T2))                        
                        transaction.sendMessage(response);
                    } //End block
                    catch (IOException ex)
                    {
                        raiseIOException(transaction.getPeerAddress(), transaction.getPeerPort(),
                                transaction.getPeerProtocol());
                    } //End block
                    finally 
                    {
                        SIPTransactionStack stack = dialog.sipStack;
    if(stack.isLoggingEnabled())                        
                        {
                            stack.getStackLogger().logDebug("resend 200 response from " + dialog);
                        } //End block
                        transaction.fireTimer();
                    } //End block
                } //End block
            } //End block
    if(dialog.isAckSeen() || dialog.dialogState == TERMINATED_STATE)            
            {
                this.transaction = null;
                this.cancel();
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    class DialogDeleteTask extends SIPStackTimerTask implements Serializable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.783 -0400", hash_original_method = "51B842BDCF98DBC480B551988FA04041", hash_generated_method = "51B842BDCF98DBC480B551988FA04041")
        public DialogDeleteTask ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.783 -0400", hash_original_method = "705C6BB4461CC5F37E0565BB6F16C084", hash_generated_method = "12743D2452C0A21B643AFBC46E200A26")
        protected void runTask() {
            delete();
            // ---------- Original Method ----------
            //delete();
        }

        
    }


    
    class DialogDeleteIfNoAckSentTask extends SIPStackTimerTask implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.783 -0400", hash_original_field = "D8D8C9E3082C9D3CC78D718B0D250891", hash_generated_field = "979FF677F2C7A64909253E0B01090AEC")

        private long seqno;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.783 -0400", hash_original_method = "D6D7FB77E2882EBB362E9FAF3BE7D45E", hash_generated_method = "A0EA5F4F4663FCA6881081121335338B")
        public  DialogDeleteIfNoAckSentTask(long seqno) {
            this.seqno = seqno;
            // ---------- Original Method ----------
            //this.seqno = seqno;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.784 -0400", hash_original_method = "47EF190411AC9DCEBDEAD83DF8BB27D9", hash_generated_method = "355408EAE8EF8B68E8E645FA9FE4DFC4")
        protected void runTask() {
    if(SIPDialog.this.highestSequenceNumberAcknowledged < seqno)            
            {
                dialogDeleteIfNoAckSentTask = null;
    if(!SIPDialog.this.isBackToBackUserAgent)                
                {
    if(sipStack.isLoggingEnabled())                    
                    sipStack.getStackLogger().logError("ACK Was not sent. killing dialog");
    if(((SipProviderImpl)sipProvider).getSipListener() instanceof SipListenerExt)                    
                    {
                        raiseErrorEvent(SIPDialogErrorEvent.DIALOG_ACK_NOT_SENT_TIMEOUT);
                    } //End block
                    else
                    {
                        delete();
                    } //End block
                } //End block
                else
                {
    if(sipStack.isLoggingEnabled())                    
                    sipStack.getStackLogger().logError("ACK Was not sent. Sending BYE");
    if(((SipProviderImpl)sipProvider).getSipListener() instanceof SipListenerExt)                    
                    {
                        raiseErrorEvent(SIPDialogErrorEvent.DIALOG_ACK_NOT_SENT_TIMEOUT);
                    } //End block
                    else
                    {
                        try 
                        {
                            Request byeRequest = SIPDialog.this.createRequest(Request.BYE);
    if(MessageFactoryImpl.getDefaultUserAgentHeader() != null)                            
                            {
                                byeRequest.addHeader(MessageFactoryImpl.getDefaultUserAgentHeader());
                            } //End block
                            ReasonHeader reasonHeader = new Reason();
                            reasonHeader.setProtocol("SIP");
                            reasonHeader.setCause(1025);
                            reasonHeader.setText("Timed out waiting to send ACK");
                            byeRequest.addHeader(reasonHeader);
                            ClientTransaction byeCtx = SIPDialog.this.getSipProvider().getNewClientTransaction(byeRequest);
                            SIPDialog.this.sendRequest(byeCtx);
                            return;
                        } //End block
                        catch (Exception ex)
                        {
                            SIPDialog.this.delete();
                        } //End block
                    } //End block
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.784 -0400", hash_original_field = "D26B2D15C6314569F32E9D2F4BD6FEAC", hash_generated_field = "010392E015C0F4F4EE6412AC38CADE79")

    private static final long serialVersionUID = -1429794423085204069L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.784 -0400", hash_original_field = "8917280F88F70A0C2AB25626046570AB", hash_generated_field = "0217060B0F6ACCA57DEF89D56528802E")

    public final static int NULL_STATE = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.784 -0400", hash_original_field = "AA9ACD2C29B35BE3CC1FCA5452E94A3C", hash_generated_field = "7E4774629A80511A1605FBB2145C202F")

    public final static int EARLY_STATE = DialogState._EARLY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.785 -0400", hash_original_field = "6325A488137EC86B847AA6592A566C0C", hash_generated_field = "45C6B699CF332D7B77B3EB2AD8AB7301")

    public final static int CONFIRMED_STATE = DialogState._CONFIRMED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.785 -0400", hash_original_field = "0457F6F92501361FF9C1B20BAB2C93E7", hash_generated_field = "80C37090AC7335F51D7D9FB4E1EC85B9")

    public final static int TERMINATED_STATE = DialogState._TERMINATED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:44.785 -0400", hash_original_field = "A7FCE49E97B902F5858568493877FAB6", hash_generated_field = "40DFB0E7AF36C25D0E66FE67C01F2E05")

    private static final int DIALOG_LINGER_TIME = 8;
}

