package gov.nist.javax.sip.stack;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.334 -0400", hash_original_field = "46C9B2C3A305D009DCA963EA55E53037", hash_generated_field = "8B7AA916EC7A88984DDF8AA52B9F1641")

    private transient boolean dialogTerminatedEventDelivered;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.334 -0400", hash_original_field = "FCD4E36FD80F450979495718DBDDAACF", hash_generated_field = "9F3F9DDDB302CE97F2E415A10FABBE2D")

    private transient String stackTrace;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.334 -0400", hash_original_field = "EA9F6ACA279138C58F705C8D4CB4B8CE", hash_generated_field = "F42F15CDE806BBAD7F26F7952D68FCE2")

    private String method;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.334 -0400", hash_original_field = "C26F5EFAA245E97571F6FC4B23DECC91", hash_generated_field = "386AD1FFF2E8BC21894EEC2B1DC5720D")

    private transient boolean isAssigned;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.334 -0400", hash_original_field = "C1EC3EDE33FAFFDB511452F99E001022", hash_generated_field = "E1B54A10C305CE35C160FA0FCCD06B96")

    private boolean reInviteFlag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.334 -0400", hash_original_field = "756C73A51ADF7F04942C8BE97A032000", hash_generated_field = "0C346A02ABD6566D7A046D5EE80C0EC0")

    private transient Object applicationData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.334 -0400", hash_original_field = "539F42CD378873BB0F9889EFF317BAFA", hash_generated_field = "AD3FCBD371406352A3E03A00BDAA3D18")

    private transient SIPRequest originalRequest;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.334 -0400", hash_original_field = "9ECD142FA67835EFBFD693D2B0EFC756", hash_generated_field = "7328CD7146ABA98BB701BDA934CF1486")

    private SIPResponse lastResponse;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.334 -0400", hash_original_field = "365BA234CE4103A64B291C10F57087FD", hash_generated_field = "4C8E3F2978B0A1967941B34B8E931926")

    private transient SIPTransaction firstTransaction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.334 -0400", hash_original_field = "EBB750D5E2AC0A12C597F9247097FE3A", hash_generated_field = "8E3DDDE2C9BBCFF0518502DA3A19B8FC")

    private transient SIPTransaction lastTransaction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.334 -0400", hash_original_field = "2EF3DE78A30BAAA37A078E077DA9C8FF", hash_generated_field = "FFD5ABB57CC8068DFE83871CA8391D63")

    private String dialogId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.334 -0400", hash_original_field = "5E278DBB57181A78536887523BDDB000", hash_generated_field = "047D72F6110028ED8614A185C3ADEE63")

    private transient String earlyDialogId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.335 -0400", hash_original_field = "DE3A634B25A226C9FC28CC0EA41F9212", hash_generated_field = "AD815FC4C870FA38840533B56E201007")

    private long localSequenceNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.335 -0400", hash_original_field = "45DD21C3FA9B2834579DDEBCBA7FDE5E", hash_generated_field = "096C078B93EFB214E2172D793F365B4D")

    private long remoteSequenceNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.335 -0400", hash_original_field = "163C6D86A43D258EE0FE3B5AC19EEB9B", hash_generated_field = "DE4FDB012317C10FCB5EE3D6596519E1")

    protected String myTag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.335 -0400", hash_original_field = "02FAD193B4B3A63F0DF3A1373D82A243", hash_generated_field = "9777EBD405E9D84F5A9D8688CA87BB34")

    protected String hisTag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.335 -0400", hash_original_field = "C433183F160826EE91E980CE55DF6B8A", hash_generated_field = "873E71D84A907B69A5D7EA40A6E98B84")

    private RouteList routeList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.335 -0400", hash_original_field = "37460D4BF2BA47A13FF9D922C4B14B2E", hash_generated_field = "648E45DA0C2D4CA0D3A6C1331273D1A8")

    private transient SIPTransactionStack sipStack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.335 -0400", hash_original_field = "9E815F1ED84873B978ADE70D5015D491", hash_generated_field = "B18AB1AD22CF960F8E3DA659D957473C")

    private int dialogState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.335 -0400", hash_original_field = "D8F45A8AC837F51166792988E4141B52", hash_generated_field = "92F226B9C77FEEDF00455BB4E4B37995")

    protected transient boolean ackSeen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.335 -0400", hash_original_field = "1653CA35CDAF1FD8B835AAB2A0098372", hash_generated_field = "5047CDCA90F6F4D08E6FCFC3504AA33A")

    private transient SIPRequest lastAckSent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.335 -0400", hash_original_field = "A2E2C0BC96483014E68E14BCA2B6829F", hash_generated_field = "0D41AA5710D910AD875D10253E3B5B7B")

    private SIPRequest lastAckReceived;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.335 -0400", hash_original_field = "5A47CDCCD7DADCBE8339DE02999F79D7", hash_generated_field = "39BFE22C217FFF2E6FD7425093780B7F")

    protected transient boolean ackProcessed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.335 -0400", hash_original_field = "804894B79B603C8794570D901AF093D4", hash_generated_field = "CCB890E772BC08D4A4B71682A75E6B57")

    protected transient DialogTimerTask timerTask;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.335 -0400", hash_original_field = "2B1914B1BDB94B6490A6024E69C1AC63", hash_generated_field = "50CA1F3CDF0B9F341970FE5A2E9968CD")

    protected transient Long nextSeqno;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.335 -0400", hash_original_field = "6D988A8035AD569D3835C3FB2E8FADD9", hash_generated_field = "357D95D41FE555F3403B8186135E948D")

    private transient int retransmissionTicksLeft;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.335 -0400", hash_original_field = "6B0B182F82159791030FD4DDF77C7D67", hash_generated_field = "FDB9FFD63AE6B4740136DBB4E840047D")

    private transient int prevRetransmissionTicks;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.335 -0400", hash_original_field = "3A3D450D6468D05390761FD1EEA48070", hash_generated_field = "AB98AAAC4EF13468E54DBE8642C5759B")

    private long originalLocalSequenceNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.335 -0400", hash_original_field = "284CCB26986C244746913731F851D61A", hash_generated_field = "D019361A8619CB9E208CC4A408868CF5")

    private transient int ackLine;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.335 -0400", hash_original_field = "C0CEB3515CA4F46A6B2A58F9563A8976", hash_generated_field = "B8AD8E741E80B25C3AEBA11833850788")

    public transient long auditTag = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.335 -0400", hash_original_field = "0491B7ABE5A57CDF01C5AF04205714CD", hash_generated_field = "5581935F145F3F50A0FF3B163F12E527")

    protected javax.sip.address.Address localParty;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.335 -0400", hash_original_field = "962BC95BC1290FCAFA045995FAE5F1E0", hash_generated_field = "039B4B6D9758816DF54E227BDD9B553B")

    protected javax.sip.address.Address remoteParty;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.335 -0400", hash_original_field = "F4E470CD8970EBBE1902E50EB09F4952", hash_generated_field = "4FB7DFE93D6674CE9A4D6470DED9D170")

    protected CallIdHeader callIdHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.335 -0400", hash_original_field = "EB27C9A1ABE6F92065F9871F11CA94DE", hash_generated_field = "66E18B86E8394598F2C548C54E34F3D8")

    private boolean serverTransactionFlag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.335 -0400", hash_original_field = "2D3F8ACEA2D147F7A52D2FA493D756C8", hash_generated_field = "58BDE3AD74EC5F605B651AEC94A1C475")

    private transient SipProviderImpl sipProvider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.335 -0400", hash_original_field = "E07EB9E73AEC54F4C343517C6319D798", hash_generated_field = "369DECFD4E296468A8EE9210A060D65B")

    private boolean terminateOnBye;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.335 -0400", hash_original_field = "354622A0C5E162C6CC6CA2314CF692C2", hash_generated_field = "024E9E66DF22C3B5E5731FC6B0083C1A")

    private transient boolean byeSent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.335 -0400", hash_original_field = "F56AF138C945E77D60FC1E857CA6ED3C", hash_generated_field = "4BFEF67A8970CE1B7ED7E72620C9AC81")

    private Address remoteTarget;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.335 -0400", hash_original_field = "F9D912BE83AE47070E860DEC06FB1BA4", hash_generated_field = "7F1ED863122BA67FB6B399180FFB61EF")

    private EventHeader eventHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.335 -0400", hash_original_field = "273FF71B50533FE65671ACDD370D0775", hash_generated_field = "25A404EC1778A9AB18E3073CD79DC005")

    private transient long lastInviteOkReceived;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.335 -0400", hash_original_field = "DA26F565CCA8C9BCABA1D6F51AA3DDB6", hash_generated_field = "043CF414B4BC114C321725D26030C925")

    private transient Semaphore ackSem = new Semaphore(1);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.335 -0400", hash_original_field = "4312EB0CC756247EAA1930550BE95F97", hash_generated_field = "8391C3AA408B5C65CA6D2DAD521FC0C6")

    private transient int reInviteWaitTime = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.335 -0400", hash_original_field = "CBA28B6F9931EA2E13D9820A8FD464DA", hash_generated_field = "671578F07EF254B77AC2D4173CF99A1A")

    private transient DialogDeleteTask dialogDeleteTask;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.335 -0400", hash_original_field = "F542E4E71711723917E3E6AE16CD8970", hash_generated_field = "B9EBB973A8692BA4C974F82BA5B997F3")

    private transient DialogDeleteIfNoAckSentTask dialogDeleteIfNoAckSentTask;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.335 -0400", hash_original_field = "26CDE53F2A363B6F09C65A5A1BE09D8A", hash_generated_field = "173A1FD238D8569297A5D30A0D2122DA")

    private transient boolean isAcknowledged;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.335 -0400", hash_original_field = "509F1D12B600B3138E1CB091EBE04C72", hash_generated_field = "19F7BD09CC9EC40661F8FE53075718B2")

    private transient long highestSequenceNumberAcknowledged = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.335 -0400", hash_original_field = "ED5DD7E8859F4FCE1BBEB3296A028766", hash_generated_field = "DA4CDB35B5056C6CA182EC98C7A0FE9B")

    private boolean isBackToBackUserAgent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.335 -0400", hash_original_field = "2B05FA302BB63D8136037DD4E39122BF", hash_generated_field = "7EEEE754C8F2FA7215F638E76C8E67E0")

    private boolean sequenceNumberValidation = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.335 -0400", hash_original_field = "FEAAE72958B4E88882F57D0164DCA2A6", hash_generated_field = "CFB0D25D7A9D3DB327E35494FC7DE9A5")

    private transient Set<SIPDialogEventListener> eventListeners;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.335 -0400", hash_original_field = "3570D6B9904467D944595544DFEA8443", hash_generated_field = "B1245AF2B94FAB1223B77DABE0E26551")

    private Semaphore timerTaskLock = new Semaphore(1);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.335 -0400", hash_original_field = "A3801CFC0CC0C9EDADB7035D96B0A52C", hash_generated_field = "D54EF62A05D422BDCA347E77C025891C")

    protected boolean firstTransactionSecure;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.335 -0400", hash_original_field = "F9F9F947ADC5F8FCF0FFE2A87E08ED9F", hash_generated_field = "68EC519F0D2EE4EB55E96608058AA384")

    protected boolean firstTransactionSeen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.335 -0400", hash_original_field = "383303C37A6BD00E4C256C602333D72B", hash_generated_field = "4D111E3CF541CDB9CD69CDF93FCEDDAC")

    protected String firstTransactionMethod;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.335 -0400", hash_original_field = "8717DD98BC5859570A4684454287E374", hash_generated_field = "DFB6058EA76D5E106C80BCA9A74A2D53")

    protected String firstTransactionId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.335 -0400", hash_original_field = "0D53979373F479A7EFA6875647AB0B78", hash_generated_field = "39C149EC307ADB72278A474A328A3BCF")

    protected boolean firstTransactionIsServerTransaction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.335 -0400", hash_original_field = "9B3271522A9E60737CFB8772E1C4861B", hash_generated_field = "801C0A281C881455A3F35F92B0224337")

    protected int firstTransactionPort = 5060;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.335 -0400", hash_original_field = "65E9D0A6D689FFB91F5650FC4788A4B6", hash_generated_field = "4CA7FF5DA34408C08E9FC1CA2863A04F")

    protected Contact contactHeader;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.336 -0400", hash_original_method = "B89E344ABA0B0C4EAAF339C3C960DE0F", hash_generated_method = "685613B365B139F14EC760382B8F90A2")
    private  SIPDialog(SipProviderImpl provider) {
        this.terminateOnBye = true;
        this.routeList = new RouteList();
        this.dialogState = NULL_STATE;
        localSequenceNumber = 0;
        remoteSequenceNumber = -1;
        this.sipProvider = provider;
        eventListeners = new CopyOnWriteArraySet<SIPDialogEventListener>();
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.337 -0400", hash_original_method = "BE0EB8A93E786CF5997E41E028500B95", hash_generated_method = "A39CD306E835D6E2D252F546534BD7FD")
    public  SIPDialog(SIPTransaction transaction) {
        this(transaction.getSipProvider());
        SIPRequest sipRequest = (SIPRequest) transaction.getRequest();
        this.callIdHeader = sipRequest.getCallId();
        this.earlyDialogId = sipRequest.getDialogId(false);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Null tx");
        this.sipStack = transaction.sipStack;
        this.sipProvider = (SipProviderImpl) transaction.getSipProvider();
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Null Provider!");
        this.addTransaction(transaction);
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1549604253 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("Creating a dialog : " + this);
                sipStack.getStackLogger().logDebug(
                    "provider port = " + this.sipProvider.getListeningPoint().getPort());
                sipStack.getStackLogger().logStackTrace();
            } 
        } 
        this.isBackToBackUserAgent = sipStack.isBackToBackUserAgent;
        addEventListener(sipStack);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.337 -0400", hash_original_method = "0305A0224D6BCDD571D54C883A13EEA2", hash_generated_method = "664CB15766C650FC565EE9A84035711E")
    public  SIPDialog(SIPClientTransaction transaction, SIPResponse sipResponse) {
        this(transaction);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Null SipResponse");
        this.setLastResponse(transaction, sipResponse);
        this.isBackToBackUserAgent = sipStack.isBackToBackUserAgent;
        addTaint(transaction.getTaint());
        addTaint(sipResponse.getTaint());
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.338 -0400", hash_original_method = "95FF401EAA7EE3F3C9E78290081B0530", hash_generated_method = "88C88A629BF01024147F9CF4AA147728")
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
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1726537894 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("Creating a dialog : " + this);
                sipStack.getStackLogger().logStackTrace();
            } 
        } 
        this.isBackToBackUserAgent = sipStack.isBackToBackUserAgent;
        addEventListener(sipStack);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.339 -0400", hash_original_method = "9EE497100AA17813744E66E4A05B8669", hash_generated_method = "D730239923E29F7DFE5B86469FB919EC")
    private void recordStackTrace() {
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        new Exception().printStackTrace(writer);
        this.stackTrace = stringWriter.getBuffer().toString();
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.340 -0400", hash_original_method = "40815EC709415499328FA1CBE062ACB5", hash_generated_method = "9DCBF13215B8438A4F76B8FDBAE96775")
    private void printRouteList() {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1471944825 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("this : " + this);
                sipStack.getStackLogger().logDebug("printRouteList : " + this.routeList.encode());
            } 
        } 
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.340 -0400", hash_original_method = "6746D685A6EEFE6F86FE53A5B90B58CB", hash_generated_method = "F4BE003ACCFDB2127ABD82C625B6A470")
    private boolean isClientDialog() {
        SIPTransaction transaction = (SIPTransaction) this.getFirstTransaction();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_646681623 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_646681623;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.341 -0400", hash_original_method = "871D6D7CB1794492ED7691CB8C5B804E", hash_generated_method = "9EB2F507E1B456435C1187C6F97690C6")
    private void raiseIOException(String host, int port, String protocol) {
        IOExceptionEvent ioError = new IOExceptionEvent(this, host, port, protocol);
        sipProvider.handleEvent(ioError, null);
        setState(SIPDialog.TERMINATED_STATE);
        addTaint(host.getTaint());
        addTaint(port);
        addTaint(protocol.getTaint());
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.341 -0400", hash_original_method = "352742C76D82997D1FD2B39635FE380F", hash_generated_method = "40B25C8E79ABE569B791B398F04AA81B")
    private void raiseErrorEvent(int dialogTimeoutError) {
        SIPDialogErrorEvent newErrorEvent;
        Iterator<SIPDialogEventListener> listenerIterator;
        SIPDialogEventListener nextListener;
        newErrorEvent = new SIPDialogErrorEvent(this, dialogTimeoutError);
        {
            listenerIterator = eventListeners.iterator();
            {
                boolean var20BE331F515CCC1CE643C3890EEC5ABE_1591367889 = (listenerIterator.hasNext());
                {
                    nextListener = (SIPDialogEventListener) listenerIterator.next();
                    nextListener.dialogErrorEvent(newErrorEvent);
                } 
            } 
        } 
        eventListeners.clear();
        {
            delete();
        } 
        stopTimer();
        addTaint(dialogTimeoutError);
        
        
        
        
        
        
			
			
				
				
			
		
        
        
		        
		        
			
		
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.342 -0400", hash_original_method = "E7371746614A4FB0A7068DCC784728D1", hash_generated_method = "69496B3044C856FEA5FA9EE8B872C9E8")
    private void setRemoteParty(SIPMessage sipMessage) {
        {
            boolean varBEE554E6D1FF8C71A0674E385CDC8906_1281313576 = (!isServer());
            {
                this.remoteParty = sipMessage.getTo().getAddress();
            } 
            {
                this.remoteParty = sipMessage.getFrom().getAddress();
            } 
        } 
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_237332785 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("settingRemoteParty " + this.remoteParty);
            } 
        } 
        
        
            
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.342 -0400", hash_original_method = "07989C3909E96A7576DAE0D29DD189A0", hash_generated_method = "3565882E68CF84698D6691D9533CB20E")
    private void addRoute(RecordRouteList recordRouteList) {
        try 
        {
            {
                boolean var07F5CF3AF0948BEF1A9D3AFE53F3C41D_1162511726 = (this.isClientDialog());
                {
                    this.routeList = new RouteList();
                    ListIterator li = recordRouteList.listIterator(recordRouteList.size());
                    boolean addRoute = true;
                    {
                        boolean var78DAF18E56E0E0C5C70FC6AF496E0718_1611556494 = (li.hasPrevious());
                        {
                            RecordRoute rr = (RecordRoute) li.previous();
                            {
                                Route route = new Route();
                                AddressImpl address = ((AddressImpl) ((AddressImpl) rr.getAddress())
                                .clone());
                                route.setAddress(address);
                                route.setParameters((NameValueList) rr.getParameters().clone());
                                this.routeList.add(route);
                            } 
                        } 
                    } 
                } 
                {
                    this.routeList = new RouteList();
                    ListIterator li = recordRouteList.listIterator();
                    boolean addRoute = true;
                    {
                        boolean var3B4C388F9F77D89F36DAE45711DE06F7_565294110 = (li.hasNext());
                        {
                            RecordRoute rr = (RecordRoute) li.next();
                            {
                                Route route = new Route();
                                AddressImpl address = ((AddressImpl) ((AddressImpl) rr.getAddress())
                                .clone());
                                route.setAddress(address);
                                route.setParameters((NameValueList) rr.getParameters().clone());
                                routeList.add(route);
                            } 
                        } 
                    } 
                } 
            } 
        } 
        finally 
        {
            {
                boolean var0C9E46B9F84667219FF0963258285136_1387824288 = (sipStack.getStackLogger().isLoggingEnabled());
                {
                    Iterator it = routeList.iterator();
                    {
                        boolean var4CA2EDBF7D27138D75E73CCD01CCB025_962823583 = (it.hasNext());
                        {
                            SipURI sipUri = (SipURI) (((Route) it.next()).getAddress().getURI());
                            {
                                boolean var1BE9C376C47A3B2A0E7DB2070A5A5EEB_1412014023 = (!sipUri.hasLrParam());
                                {
                                    {
                                        boolean var6FE8ACC5352DCA3449210F8EDED912B3_832463602 = (sipStack.isLoggingEnabled());
                                        {
                                            sipStack.getStackLogger().logWarning(
                                "NON LR route in Route set detected for dialog : " + this);
                                            sipStack.getStackLogger().logStackTrace();
                                        } 
                                    } 
                                } 
                            } 
                        } 
                    } 
                } 
            } 
        } 
        addTaint(recordRouteList.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.343 -0400", hash_original_method = "0B8DEDA7075751956ABB1ACBE337F637", hash_generated_method = "63F1ACAC64E61988552CEDE2C7C95884")
     void setRemoteTarget(ContactHeader contact) {
        this.remoteTarget = contact.getAddress();
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_52302486 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("Dialog.setRemoteTarget: " + this.remoteTarget);
                sipStack.getStackLogger().logStackTrace();
            } 
        } 
        
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.343 -0400", hash_original_method = "32344AE5A14991821D94A9D2D9260949", hash_generated_method = "3475FA925A427A196EC8102DAF03972A")
    private synchronized void addRoute(SIPResponse sipResponse) {
        try 
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1498881336 = (sipStack.isLoggingEnabled());
                {
                    sipStack.getStackLogger().logDebug(
                        "setContact: dialogState: " + this + "state = " + this.getState());
                } 
            } 
            {
                boolean var8E5EA495FB3AB2BDCCF944451D5CAD5E_1925208625 = (sipResponse.getStatusCode() == 100);
                {
                    {
                        boolean varD22FA4E0B94F71DD4671FD4FC55EBC7F_135828188 = (sipResponse.getStatusCode() / 100 == 2 && !this.isServer());
                        {
                            ContactList contactList = sipResponse.getContactHeaders();
                            {
                                boolean varBC2CD47900C4F82FA80016EBC4DC14B4_120797728 = (contactList != null
                            && SIPRequest.isTargetRefresh(sipResponse.getCSeq().getMethod()));
                                {
                                    this.setRemoteTarget((ContactHeader) contactList.getFirst());
                                } 
                            } 
                        } 
                    } 
                } 
            } 
            {
                boolean varA6A85DA8A9FDA48A0ADE5BD360D7C1FE_1385581789 = (!isServer());
                {
                    {
                        boolean var2698EF62FF779E804A95F9CA198FE43F_953891692 = (this.getState() != DialogState.CONFIRMED
                        && this.getState() != DialogState.TERMINATED);
                        {
                            RecordRouteList rrlist = sipResponse.getRecordRouteHeaders();
                            {
                                this.addRoute(rrlist);
                            } 
                            {
                                this.routeList = new RouteList();
                            } 
                        } 
                    } 
                    ContactList contactList = sipResponse.getContactHeaders();
                    {
                        this.setRemoteTarget((ContactHeader) contactList.getFirst());
                    } 
                } 
            } 
        } 
        finally 
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1702856355 = (sipStack.isLoggingEnabled());
                {
                    sipStack.getStackLogger().logStackTrace();
                } 
            } 
        } 
        addTaint(sipResponse.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.344 -0400", hash_original_method = "EDCC5E2E639B8E515D6889EB4E225297", hash_generated_method = "A3CC71B984116C97D868EE164E7E120B")
    private synchronized RouteList getRouteList() {
        RouteList varB4EAC82CA7396A68D541C85D26508E83_1131189710 = null; 
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_540835680 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug("getRouteList " + this);
        } 
        ListIterator li;
        RouteList retval = new RouteList();
        retval = new RouteList();
        {
            li = routeList.listIterator();
            {
                boolean varD1722E42EA3CA8952F93B6521D875E61_1141073471 = (li.hasNext());
                {
                    Route route = (Route) li.next();
                    retval.add((Route) route.clone());
                } 
            } 
        } 
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_37757270 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("----- ");
                sipStack.getStackLogger().logDebug("getRouteList for " + this);
                sipStack.getStackLogger().logDebug("RouteList = " + retval.encode());
                sipStack.getStackLogger().logDebug("myRouteList = " + routeList.encode());
                sipStack.getStackLogger().logDebug("----- ");
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1131189710 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1131189710.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1131189710;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.345 -0400", hash_original_method = "7EC927C7EF5071E2849378214CAB8686", hash_generated_method = "BCC8ED1A5E46655051AE536081FB079D")
     void setRouteList(RouteList routeList) {
        this.routeList = routeList;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.346 -0400", hash_original_method = "EE053BB78DA7F62675E98D1AF5A5B915", hash_generated_method = "85533A593E54EE027B153852C0E978C4")
    private void sendAck(Request request, boolean throwIOExceptionAsSipException) throws SipException {
        SIPRequest ackRequest = (SIPRequest) request;
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_83508289 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug("sendAck" + this);
        } 
        {
            boolean var83038655241FA8664F712343761B6FDA_1199349614 = (!ackRequest.getMethod().equals(Request.ACK));
            if (DroidSafeAndroidRuntime.control) throw new SipException("Bad request method -- should be ACK");
        } 
        {
            boolean var8D79CFF02C4C85D8676092EC202DE2DE_1070646761 = (this.getState() == null || this.getState().getValue() == EARLY_STATE);
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_2115163643 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logError(
                        "Bad Dialog State for " + this + " dialogID = " + this.getDialogId());
                    } 
                } 
                if (DroidSafeAndroidRuntime.control) throw new SipException("Bad dialog state " + this.getState());
            } 
        } 
        {
            boolean var3C70B6348A8CD040C6F768F885F8BDFD_1468325384 = (!this.getCallId().getCallId().equals(((SIPRequest) request).getCallId().getCallId()));
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_196384323 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logError("CallID " + this.getCallId());
                        sipStack.getStackLogger().logError(
                        "RequestCallID = " + ackRequest.getCallId().getCallId());
                        sipStack.getStackLogger().logError("dialog =  " + this);
                    } 
                } 
                if (DroidSafeAndroidRuntime.control) throw new SipException("Bad call ID in request");
            } 
        } 
        try 
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1523393096 = (sipStack.isLoggingEnabled());
                {
                    sipStack.getStackLogger().logDebug(
                        "setting from tag For outgoing ACK= " + this.getLocalTag());
                    sipStack.getStackLogger().logDebug(
                        "setting To tag for outgoing ACK = " + this.getRemoteTag());
                    sipStack.getStackLogger().logDebug("ack = " + ackRequest);
                } 
            } 
            {
                boolean var8960EF1666EE0A76790F8BA2DB88F003_62463221 = (this.getLocalTag() != null);
                ackRequest.getFrom().setTag(this.getLocalTag());
            } 
            {
                boolean var2C6389CD64DE33F7E280071219A47D88_541780545 = (this.getRemoteTag() != null);
                ackRequest.getTo().setTag(this.getRemoteTag());
            } 
        } 
        catch (ParseException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException(ex.getMessage());
        } 
        Hop hop = sipStack.getNextHop(ackRequest);
        if (DroidSafeAndroidRuntime.control) throw new SipException("No route!");
        try 
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_228745693 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug("hop = " + hop);
            } 
            ListeningPointImpl lp = (ListeningPointImpl) this.sipProvider.getListeningPoint(hop
                    .getTransport());
            if (DroidSafeAndroidRuntime.control) throw new SipException("No listening point for this provider registered at "
                        + hop);
            InetAddress inetAddress = InetAddress.getByName(hop.getHost());
            MessageChannel messageChannel = lp.getMessageProcessor().createMessageChannel(
                    inetAddress, hop.getPort());
            boolean releaseAckSem = false;
            long cseqNo = ((SIPRequest)request).getCSeq().getSeqNumber();
            {
                boolean var407F621DCBF6FFA27177104AE6265862_1704302707 = (!this.isAckSent(cseqNo));
                {
                    releaseAckSem = true;
                } 
            } 
            this.setLastAckSent(ackRequest);
            messageChannel.sendMessage(ackRequest);
            this.isAcknowledged = true;
            this.highestSequenceNumberAcknowledged = Math.max(this.highestSequenceNumberAcknowledged,
                    ((SIPRequest)ackRequest).getCSeq().getSeqNumber());
            {
                this.releaseAckSem();
            } 
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1991480197 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logDebug("Not releasing ack sem for " + this + " isAckSent " + releaseAckSem );
                    } 
                } 
            } 
        } 
        catch (IOException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("Could not send ack", ex);
            this.raiseIOException(hop.getHost(), hop.getPort(), hop.getTransport());
        } 
        catch (SipException ex)
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_2101649417 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logException(ex);
            } 
            if (DroidSafeAndroidRuntime.control) throw ex;
        } 
        catch (Exception ex)
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_64323663 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logException(ex);
            } 
            if (DroidSafeAndroidRuntime.control) throw new SipException("Could not create message channel", ex);
        } 
        {
            this.dialogDeleteTask.cancel();
            this.dialogDeleteTask = null;
        } 
        this.ackSeen = true;
        addTaint(request.getTaint());
        addTaint(throwIOExceptionAsSipException);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.347 -0400", hash_original_method = "0D216F13B34A5D6836A5B8174F7E5D5B", hash_generated_method = "833699EAF4926A44BA91EB1BE4A6B643")
     void setStack(SIPTransactionStack sipStack) {
        this.sipStack = sipStack;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.347 -0400", hash_original_method = "4B5A71F52939D771152A6C733BB7B273", hash_generated_method = "DE340CBF06A1B28020C10B03D29352A3")
     SIPTransactionStack getStack() {
        SIPTransactionStack varB4EAC82CA7396A68D541C85D26508E83_371993608 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_371993608 = sipStack;
        varB4EAC82CA7396A68D541C85D26508E83_371993608.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_371993608;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.347 -0400", hash_original_method = "82BA8A08B2E8140159AB0D3D207AD49D", hash_generated_method = "F49679FBD03547B3157C8B220D018284")
     boolean isTerminatedOnBye() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_76821869 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_76821869;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.348 -0400", hash_original_method = "45B7AAA172C2FB7B4FDF9001755F4630", hash_generated_method = "7C80F5AA2C4C977BA309CBBDED69B9CE")
     void ackReceived(SIPRequest sipRequest) {
        SIPServerTransaction tr = this.getInviteTransaction();
        {
            {
                boolean varB6355663626C1162BA1A68F49F05AEF5_1550972900 = (tr.getCSeq() == sipRequest.getCSeq().getSeqNumber());
                {
                    acquireTimerTaskSem();
                    try 
                    {
                        {
                            this.timerTask.cancel();
                            this.timerTask = null;
                        } 
                    } 
                    finally 
                    {
                        releaseTimerTaskSem();
                    } 
                    this.ackSeen = true;
                    {
                        this.dialogDeleteTask.cancel();
                        this.dialogDeleteTask = null;
                    } 
                    this.setLastAckReceived(sipRequest);
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1615201758 = (sipStack.isLoggingEnabled());
                        {
                            sipStack.getStackLogger().logDebug(
                            "ackReceived for " + ((SIPTransaction) tr).getMethod());
                            this.ackLine = sipStack.getStackLogger().getLineCount();
                            this.printDebugInfo();
                        } 
                    } 
                    {
                        this.releaseAckSem();
                    } 
                    this.setState(CONFIRMED_STATE);
                } 
            } 
        } 
        addTaint(sipRequest.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.349 -0400", hash_original_method = "76BE8FDE36BAF0086F9828D261C3B7B9", hash_generated_method = "5F6653D598B3498EA90D58B8486DBEDB")
    synchronized boolean testAndSetIsDialogTerminatedEventDelivered() {
        boolean retval = this.dialogTerminatedEventDelivered;
        this.dialogTerminatedEventDelivered = true;
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1189927748 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1189927748;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.349 -0400", hash_original_method = "6AC129F323D8E39FC544B245C2D3A08C", hash_generated_method = "DEE6DF0D485C15E3BAC1FDCEECB3E5D6")
    public void addEventListener(SIPDialogEventListener newListener) {
        eventListeners.add(newListener);
        addTaint(newListener.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.350 -0400", hash_original_method = "7D9E11919812D827506D2E4A9106FF10", hash_generated_method = "4883BF1C58DAF47B17E44080CD78F7C2")
    public void removeEventListener(SIPDialogEventListener oldListener) {
        eventListeners.remove(oldListener);
        addTaint(oldListener.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.350 -0400", hash_original_method = "552E0456C33D24CD63C8EBCDAC1D019B", hash_generated_method = "E17DD994BC845C3BDBBD70ECC432242E")
    public void setApplicationData(Object applicationData) {
        this.applicationData = applicationData;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.351 -0400", hash_original_method = "5F924FC61375970A4DC758380BEBFF0F", hash_generated_method = "8CD050B4A1985C8DB94DC0E74BDA85FB")
    public Object getApplicationData() {
        Object varB4EAC82CA7396A68D541C85D26508E83_972664826 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_972664826 = this.applicationData;
        varB4EAC82CA7396A68D541C85D26508E83_972664826.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_972664826;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.352 -0400", hash_original_method = "CB5AF71091E3878E29C27274F2628D83", hash_generated_method = "F6410E4DE15D6F3C4F0BC4C07CEB09DF")
    public synchronized void requestConsumed() {
        this.nextSeqno = Long.valueOf(this.getRemoteSeqNumber() + 1);
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1899227007 = (sipStack.isLoggingEnabled());
            {
                this.sipStack.getStackLogger().logDebug(
                    "Request Consumed -- next consumable Request Seqno = " + this.nextSeqno);
            } 
        } 
        
        
        
            
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.354 -0400", hash_original_method = "1E1A6C22D1982081DC74374A2FF63AAD", hash_generated_method = "4588AA3780474429C77EE59965114823")
    public synchronized boolean isRequestConsumable(SIPRequest dialogRequest) {
        {
            boolean var6F478D97F2432A825F39F929C2C7D5F9_1917420528 = (dialogRequest.getMethod().equals(Request.ACK));
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Illegal method");
        } 
        {
            boolean var1B071101B9F8EF253DCB47268A096682_2116839785 = (!this.isSequnceNumberValidation());
        } 
        boolean var5D47603BA0731A48F49B6853603D82AF_1849391446 = (remoteSequenceNumber < dialogRequest.getCSeq().getSeqNumber());
        addTaint(dialogRequest.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_707193828 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_707193828;
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.356 -0400", hash_original_method = "45E0951257A8FCCA68182E75CB3B0E3E", hash_generated_method = "9085F0969D812520A1C5A8B0A7080C63")
    public void doDeferredDelete() {
        {
            boolean var57BEDF91C3ACD8FDD0380E079BFC759D_2102241554 = (sipStack.getTimer() == null);
            this.setState(TERMINATED_STATE);
            {
                this.dialogDeleteTask = new DialogDeleteTask();
                sipStack.getTimer().schedule(this.dialogDeleteTask,
                    SIPTransaction.TIMER_H * SIPTransactionStack.BASE_TIMER_INTERVAL);
            } 
        } 
        
        
            
        
            
            
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.358 -0400", hash_original_method = "DBF870542E6B78326B5509C5A5BAD885", hash_generated_method = "A96FFC8F03E5DC4728CD126C74C68861")
    public void setState(int state) {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1583441579 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug(
                    "Setting dialog state for " + this + "newState = " + state);
                sipStack.getStackLogger().logStackTrace();
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1856388258 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logDebug(
                            this + "  old dialog state is " + this.getState());
                        sipStack.getStackLogger().logDebug(
                            this + "  New dialog state is " + DialogState.getObject(state));
                    } 
                } 
            } 
        } 
        this.dialogState = state;
        {
            {
                boolean var0CDA542FA791709C98BE4603D7193AE9_1229325462 = (sipStack.getTimer() != null);
                {
                    sipStack.getTimer().schedule(new LingerTimer(), DIALOG_LINGER_TIME * 1000);
                } 
            } 
            this.stopTimer();
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.360 -0400", hash_original_method = "030EEF9CE7E1904041534ED4E8E41515", hash_generated_method = "3011DECCB18DD6F054C93276A357F15E")
    public void printDebugInfo() {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_18494985 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("isServer = " + isServer());
                sipStack.getStackLogger().logDebug("localTag = " + getLocalTag());
                sipStack.getStackLogger().logDebug("remoteTag = " + getRemoteTag());
                sipStack.getStackLogger().logDebug("localSequenceNumer = " + getLocalSeqNumber());
                sipStack.getStackLogger().logDebug("remoteSequenceNumer = " + getRemoteSeqNumber());
                sipStack.getStackLogger().logDebug("ackLine:" + this.getRemoteTag() + " " + ackLine);
            } 
        } 
        
        
            
            
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.361 -0400", hash_original_method = "1550A0F77E6D4005059B99263F67738A", hash_generated_method = "DDCD6F51B9AB8E4D394BFAFB8098A422")
    public boolean isAckSeen() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_897643144 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_897643144;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.362 -0400", hash_original_method = "B546264B9F955F6D37CCFB381DE1D848", hash_generated_method = "78D048F1D9BA641D4A5BA46A2A9B9414")
    public SIPRequest getLastAckSent() {
        SIPRequest varB4EAC82CA7396A68D541C85D26508E83_2054019958 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2054019958 = this.lastAckSent;
        varB4EAC82CA7396A68D541C85D26508E83_2054019958.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2054019958;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.363 -0400", hash_original_method = "3A1F0F9E8BFDA328E094E225E007A649", hash_generated_method = "D7972645ABC17EF957C48D889665D17C")
    public boolean isAckSent(long cseqNo) {
        {
            boolean var3665C5AC96583983B5AAFA78A2A4A188_1581408778 = (this.getLastTransaction() == null);
        } 
        {
            boolean varF59958C0898BD203DEF95141C522BCCD_875811362 = (this.getLastTransaction() instanceof ClientTransaction);
            {
                {
                    boolean varCC537E3EE0A3D565D8032AB64F417D5A_275053825 = (this.getLastAckSent() == null);
                    {
                        boolean var98BAD3A8C67276872D114A7BFB474E16_62498241 = (cseqNo <=((SIPRequest) this.getLastAckSent()).getCSeq().getSeqNumber());
                    } 
                } 
            } 
        } 
        addTaint(cseqNo);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2065590146 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2065590146;
        
        
            
        
            
                
            
                
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.364 -0400", hash_original_method = "614E8BDEDCCD12CF6A6EF62939E9BCC1", hash_generated_method = "8838A1E2CCDD42FC2127FFCA7CB2AC07")
    public Transaction getFirstTransaction() {
        Transaction varB4EAC82CA7396A68D541C85D26508E83_517727028 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_517727028 = this.firstTransaction;
        varB4EAC82CA7396A68D541C85D26508E83_517727028.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_517727028;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.365 -0400", hash_original_method = "A5E017CF1C9F9D5F5F2E302DFCC4F846", hash_generated_method = "1EDDB78711F9AC4AC15B997F1D4FB0DF")
    public Iterator getRouteSet() {
        Iterator varB4EAC82CA7396A68D541C85D26508E83_1298588876 = null; 
        Iterator varB4EAC82CA7396A68D541C85D26508E83_580594493 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1298588876 = new LinkedList().listIterator();
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_580594493 = this.getRouteList().listIterator();
        } 
        Iterator varA7E53CE21691AB073D9660D615818899_1148333618; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1148333618 = varB4EAC82CA7396A68D541C85D26508E83_1298588876;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1148333618 = varB4EAC82CA7396A68D541C85D26508E83_580594493;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1148333618.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1148333618;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.365 -0400", hash_original_method = "A8016262F3F363A84230A54DA12F1862", hash_generated_method = "C06BDDD373CCD9E9A82C2E17D958F603")
    public synchronized void addRoute(SIPRequest sipRequest) {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_904323926 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug(
                    "setContact: dialogState: " + this + "state = " + this.getState());
            } 
        } 
        {
            boolean varAF9C68605D64B0F2F115C62532D2B021_1096165596 = (this.dialogState == CONFIRMED_STATE
                && SIPRequest.isTargetRefresh(sipRequest.getMethod()));
            {
                this.doTargetRefresh(sipRequest);
            } 
        } 
        {
            boolean varB1C209232695E6D70F6B684A8210FA49_1595480523 = (sipRequest.getToTag()!=null);
        } 
        RecordRouteList rrlist = sipRequest.getRecordRouteHeaders();
        {
            this.addRoute(rrlist);
        } 
        {
            this.routeList = new RouteList();
        } 
        ContactList contactList = sipRequest.getContactHeaders();
        {
            this.setRemoteTarget((ContactHeader) contactList.getFirst());
        } 
        addTaint(sipRequest.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.366 -0400", hash_original_method = "7A127BC7F5926E2623990DC3EF5AF92A", hash_generated_method = "CB8AA31A85091EA3068885635C30BAC6")
    public void setDialogId(String dialogId) {
        this.dialogId = dialogId;
        
        
    }

    
    @DSModeled(DSC.SAFE)
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.366 -0400", hash_original_method = "3F9050C9D9DA025E9AD5115049E6DBE4", hash_generated_method = "EC7B46533E20D2051688547C03D3FA31")
    public boolean isServer() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2131685444 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2131685444;
        
        
            
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.366 -0400", hash_original_method = "78570188BA83CB17A52ACDCDF5E3A80D", hash_generated_method = "0DE10178C35D9DE2927018EA222B9213")
    protected boolean isReInvite() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1694508551 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1694508551;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.367 -0400", hash_original_method = "E7B2220F30EB97BE925BA6431B089B50", hash_generated_method = "91B9FC44F24921454B832B32AC9E3606")
    public String getDialogId() {
        String varB4EAC82CA7396A68D541C85D26508E83_206678401 = null; 
        this.dialogId = this.lastResponse.getDialogId(isServer());
        varB4EAC82CA7396A68D541C85D26508E83_206678401 = this.dialogId;
        varB4EAC82CA7396A68D541C85D26508E83_206678401.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_206678401;
        
        
            
        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.368 -0400", hash_original_method = "5D1D12A2E6FD98502CE24F8CA665F380", hash_generated_method = "7AD083B34426DCC0227B207B5FA2423B")
    public void addTransaction(SIPTransaction transaction) {
        SIPRequest sipRequest = (SIPRequest) transaction.getOriginalRequest();
        {
            boolean varB7F9A6A61385E3192B10301B5B3F8549_1884526876 = (firstTransactionSeen && !firstTransactionId.equals(transaction.getBranchId()) 
                && transaction.getMethod().equals(firstTransactionMethod));
            {
                this.reInviteFlag = true;
            } 
        } 
        {
            storeFirstTransactionInfo(this, transaction);
            {
                boolean varD92DE4EDF61C41C566AE76DAC140EAB6_1601059484 = (sipRequest.getMethod().equals(Request.SUBSCRIBE));
                this.eventHeader = (EventHeader) sipRequest.getHeader(EventHeader.NAME);
            } 
            this.setLocalParty(sipRequest);
            this.setRemoteParty(sipRequest);
            this.setCallId(sipRequest);
            {
                this.originalRequest = sipRequest;
            } 
            {
                this.method = sipRequest.getMethod();
            } 
            {
                this.hisTag = sipRequest.getFrom().getTag();
            } 
            {
                setLocalSequenceNumber(sipRequest.getCSeq().getSeqNumber());
                this.originalLocalSequenceNumber = localSequenceNumber;
                this.myTag = sipRequest.getFrom().getTag();
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1225874861 = (sipStack.isLoggingEnabled());
                    sipStack.getStackLogger().logError(
                            "The request's From header is missing the required Tag parameter.");
                } 
            } 
        } 
        {
            boolean varDE98D793D4ACAAC2095FDB19E0A65B87_1839710922 = (transaction.getMethod().equals(firstTransactionMethod)
                && firstTransactionIsServerTransaction != transaction.isServerTransaction());
            {
                storeFirstTransactionInfo(this, transaction);
                this.setLocalParty(sipRequest);
                this.setRemoteParty(sipRequest);
                this.setCallId(sipRequest);
                this.originalRequest = sipRequest;
                this.method = sipRequest.getMethod();
            } 
        } 
        setRemoteSequenceNumber(sipRequest.getCSeq().getSeqNumber());
        this.lastTransaction = transaction;
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_2119159529 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger()
                    .logDebug("Transaction Added " + this + myTag + "/" + hisTag);
                sipStack.getStackLogger().logDebug(
                    "TID = " + transaction.getTransactionId() + "/"
                            + transaction.isServerTransaction());
                sipStack.getStackLogger().logStackTrace();
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.369 -0400", hash_original_method = "D993372A10E82664D688CA2C725ED950", hash_generated_method = "B194AB751BB5880B43FE471531EF5D16")
    private void setRemoteTag(String hisTag) {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1660524007 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug(
                    "setRemoteTag(): " + this + " remoteTag = " + this.hisTag + " new tag = "
                            + hisTag);
            } 
        } 
        {
            boolean var900B1255CEEB9524C1B77103CD9B853E_531552325 = (this.hisTag != null && hisTag != null && !hisTag.equals(this.hisTag));
            {
                {
                    boolean varC92ECF628E283041EE15A3395386A5F8_26018904 = (this.getState() != DialogState.EARLY);
                    {
                        {
                            boolean var2AB968A8303910EE00F810B6DE3410F9_1576461575 = (sipStack.isLoggingEnabled());
                            sipStack.getStackLogger().logDebug(
                        "Dialog is already established -- ignoring remote tag re-assignment");
                        } 
                    } 
                    {
                        boolean var882658CE99D357DAFA1231A214A8043C_868454776 = (sipStack.isRemoteTagReassignmentAllowed());
                        {
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_532604519 = (sipStack.isLoggingEnabled());
                                sipStack.getStackLogger().logDebug(
                        "UNSAFE OPERATION !  tag re-assignment " + this.hisTag
                                + " trying to set to " + hisTag
                                + " can cause unexpected effects ");
                            } 
                            boolean removed = false;
                            {
                                boolean var705F9CB3BFC32B68CBC0B119B34F8418_373326235 = (this.sipStack.getDialog(dialogId) == this);
                                {
                                    this.sipStack.removeDialog(dialogId);
                                    removed = true;
                                } 
                            } 
                            this.dialogId = null;
                            this.hisTag = hisTag;
                            {
                                {
                                    boolean varA5D47C3A6259BCCCC2265DD1F84B75D4_124044951 = (sipStack.isLoggingEnabled());
                                    sipStack.getStackLogger().logDebug("ReInserting Dialog");
                                } 
                                this.sipStack.putDialog(this);
                            } 
                        } 
                    } 
                } 
            } 
            {
                {
                    this.hisTag = hisTag;
                } 
                {
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1712048391 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger().logWarning("setRemoteTag : called with null argument ");
                    } 
                } 
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.370 -0400", hash_original_method = "6BDB0ABA2E69E3FFFE0E9E894A65FB29", hash_generated_method = "A32B7FBCF067B0197597E843429489D3")
    public SIPTransaction getLastTransaction() {
        SIPTransaction varB4EAC82CA7396A68D541C85D26508E83_548984395 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_548984395 = this.lastTransaction;
        varB4EAC82CA7396A68D541C85D26508E83_548984395.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_548984395;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.372 -0400", hash_original_method = "2B80A0EDB61F41D041D4D4B21A265288", hash_generated_method = "E1DC6B8F51B19D12DC9E9DC01C75EC1E")
    public SIPServerTransaction getInviteTransaction() {
        SIPServerTransaction varB4EAC82CA7396A68D541C85D26508E83_1373230635 = null; 
        SIPServerTransaction varB4EAC82CA7396A68D541C85D26508E83_1563019746 = null; 
        DialogTimerTask t = this.timerTask;
        varB4EAC82CA7396A68D541C85D26508E83_1373230635 = t.transaction;
        varB4EAC82CA7396A68D541C85D26508E83_1563019746 = null;
        SIPServerTransaction varA7E53CE21691AB073D9660D615818899_304073276; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_304073276 = varB4EAC82CA7396A68D541C85D26508E83_1373230635;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_304073276 = varB4EAC82CA7396A68D541C85D26508E83_1563019746;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_304073276.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_304073276;
        
        
        
            
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.374 -0400", hash_original_method = "0F222FB6A793487D534C4C9D0AE37F48", hash_generated_method = "B7FDAF73649F0A40EDA73E0DBFFF3813")
    private void setLocalSequenceNumber(long lCseq) {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_205035302 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug(
                    "setLocalSequenceNumber: original  " + this.localSequenceNumber + " new  = "
                            + lCseq);
        } 
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Sequence number should not decrease !");
        this.localSequenceNumber = lCseq;
        
        
            
                    
                            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.374 -0400", hash_original_method = "2CD5B084729CE62420C092F3B17E64CA", hash_generated_method = "3097810AEDDA649D9F3FA6679DE2A9DC")
    public void setRemoteSequenceNumber(long rCseq) {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_2057080421 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug("setRemoteSeqno " + this + "/" + rCseq);
        } 
        this.remoteSequenceNumber = rCseq;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.375 -0400", hash_original_method = "ACC9A2408A6E532361DDB7BDD50DD489", hash_generated_method = "0CE7495547330D4CCF2E73D8AE7D692E")
    public void incrementLocalSequenceNumber() {
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.375 -0400", hash_original_method = "FC2F178305D96E73603946FEBD885895", hash_generated_method = "BA62DFF1706F9A6D8F75CFB4E2F8D66C")
    public int getRemoteSequenceNumber() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_782524105 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_782524105;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.376 -0400", hash_original_method = "4E94621434A30379D5E2C1A949477B38", hash_generated_method = "7CC13D8A6EF8235EC2CDF4274095AEDE")
    public int getLocalSequenceNumber() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1118169882 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1118169882;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.376 -0400", hash_original_method = "6474794E57511F2FE7B2B694C3DD0A5A", hash_generated_method = "4B8F4728E738F86510E487121B91CB05")
    public long getOriginalLocalSequenceNumber() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_501547370 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_501547370;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.377 -0400", hash_original_method = "4D53FF8947679D063EC9104B2E34893C", hash_generated_method = "F475210FDCD49ED64711BD4A5D7884A3")
    public long getLocalSeqNumber() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1375426968 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1375426968;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.377 -0400", hash_original_method = "86EC66726C4D4B16B759790B32B2EE83", hash_generated_method = "4EE9039D6030FBF23EE80245EB657A2C")
    public long getRemoteSeqNumber() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1686986507 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1686986507;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.378 -0400", hash_original_method = "0BA81564D0817AED393E2EAE028CBF1E", hash_generated_method = "016786739D074C700D6197E9B436FABC")
    public String getLocalTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_1040890792 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1040890792 = this.myTag;
        varB4EAC82CA7396A68D541C85D26508E83_1040890792.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1040890792;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.379 -0400", hash_original_method = "C2413781DD6AA95F52F5C21D9381D08B", hash_generated_method = "7D24D0AAB81D9A81B08FB505F0DF1033")
    public String getRemoteTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_1049643139 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1049643139 = hisTag;
        varB4EAC82CA7396A68D541C85D26508E83_1049643139.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1049643139;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.380 -0400", hash_original_method = "CA511CD87985B97DC1F9ED1FACA7DA9D", hash_generated_method = "08AD61DD1E749CC4D739E91679C0C685")
    private void setLocalTag(String mytag) {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1947966565 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("set Local tag " + mytag + " " + this.dialogId);
                sipStack.getStackLogger().logStackTrace();
            } 
        } 
        this.myTag = mytag;
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.381 -0400", hash_original_method = "34B72580F00CA0B4FA87EF05393027BE", hash_generated_method = "C41AF72127A1D3997F6A353CD4B6BEE0")
    public void delete() {
        this.setState(TERMINATED_STATE);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.383 -0400", hash_original_method = "E30651442243E5536659B8D6D7E6C300", hash_generated_method = "2E8F28B08345E1AD47948A9052351BE8")
    public CallIdHeader getCallId() {
        CallIdHeader varB4EAC82CA7396A68D541C85D26508E83_1690889296 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1690889296 = this.callIdHeader;
        varB4EAC82CA7396A68D541C85D26508E83_1690889296.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1690889296;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.384 -0400", hash_original_method = "4B0BBE43D23308E79DF92279003CECC0", hash_generated_method = "517DBAA469E981201785F2FDAACB9B73")
    private void setCallId(SIPRequest sipRequest) {
        this.callIdHeader = sipRequest.getCallId();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.387 -0400", hash_original_method = "1786A3231AA3C60CCA9E19F7DEAE30E7", hash_generated_method = "C2FB77ABCE4D2986BEEA3604559D9F75")
    public javax.sip.address.Address getLocalParty() {
        javax.sip.address.Address varB4EAC82CA7396A68D541C85D26508E83_278079379 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_278079379 = this.localParty;
        varB4EAC82CA7396A68D541C85D26508E83_278079379.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_278079379;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.388 -0400", hash_original_method = "1D3A055B19FDF32D0E14CBB9A0F366F2", hash_generated_method = "188C58B3A75EF0FB62160D80E41C8F8F")
    private void setLocalParty(SIPMessage sipMessage) {
        {
            boolean varBEE554E6D1FF8C71A0674E385CDC8906_1315075560 = (!isServer());
            {
                this.localParty = sipMessage.getFrom().getAddress();
            } 
            {
                this.localParty = sipMessage.getTo().getAddress();
            } 
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.388 -0400", hash_original_method = "CA9799D7C5644CC201AAA28B1842190A", hash_generated_method = "993DADC0038EA85BF79DCD0D145F867E")
    public javax.sip.address.Address getRemoteParty() {
        javax.sip.address.Address varB4EAC82CA7396A68D541C85D26508E83_1804633701 = null; 
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1612741276 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("gettingRemoteParty " + this.remoteParty);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1804633701 = this.remoteParty;
        varB4EAC82CA7396A68D541C85D26508E83_1804633701.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1804633701;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.389 -0400", hash_original_method = "5663F20A7285801454D4B2BC61212FE3", hash_generated_method = "5D596E56571FE99A7E7D9C96CA90F4AB")
    public javax.sip.address.Address getRemoteTarget() {
        javax.sip.address.Address varB4EAC82CA7396A68D541C85D26508E83_1810747138 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1810747138 = this.remoteTarget;
        varB4EAC82CA7396A68D541C85D26508E83_1810747138.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1810747138;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.390 -0400", hash_original_method = "81C5F6A55277F5330460057DCD70CFE0", hash_generated_method = "FC67DFFE4036FD2EFA31EB8D663AE030")
    public DialogState getState() {
        DialogState varB4EAC82CA7396A68D541C85D26508E83_1889203996 = null; 
        DialogState varB4EAC82CA7396A68D541C85D26508E83_414927827 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1889203996 = null;
        varB4EAC82CA7396A68D541C85D26508E83_414927827 = DialogState.getObject(this.dialogState);
        DialogState varA7E53CE21691AB073D9660D615818899_73124492; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_73124492 = varB4EAC82CA7396A68D541C85D26508E83_1889203996;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_73124492 = varB4EAC82CA7396A68D541C85D26508E83_414927827;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_73124492.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_73124492;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.390 -0400", hash_original_method = "B6F2129527CFF355191EDA726B295B54", hash_generated_method = "9B4069D368ECE75FDF2CFC484FDD5B9B")
    public boolean isSecure() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_140932579 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_140932579;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.391 -0400", hash_original_method = "41912A3E01B6CF39F4209C49F71F74D2", hash_generated_method = "9092FE5F04B796D0CB46E57A1AA894B5")
    public void sendAck(Request request) throws SipException {
        this.sendAck(request, true);
        addTaint(request.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.392 -0400", hash_original_method = "802F1385694BBDC717BE4DE58C3ED44B", hash_generated_method = "1DEA250E629AD99D983A7FCF7D702CAE")
    public Request createRequest(String method) throws SipException {
        Request varB4EAC82CA7396A68D541C85D26508E83_735754462 = null; 
        {
            boolean var7FAEA5BBA47884C7B33E1A58D0E293FA_1192811028 = (method.equals(Request.ACK) || method.equals(Request.PRACK));
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException("Invalid method specified for createRequest:" + method);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_735754462 = this.createRequest(method, this.lastResponse);
        if (DroidSafeAndroidRuntime.control) throw new SipException("Dialog not yet established -- no response!");
        addTaint(method.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_735754462.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_735754462;
        
        
            
        
        
            
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.395 -0400", hash_original_method = "B004628D88AAF4473352CE6B2CF39886", hash_generated_method = "1D6A7FCC09D252782DA6959F0D6449FA")
    private Request createRequest(String method, SIPResponse sipResponse) throws SipException {
        Request varB4EAC82CA7396A68D541C85D26508E83_1926165749 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null argument");
        {
            boolean var901DDCA4AFD787ED4D3E774E6F5954D2_1605634746 = (method.equals(Request.CANCEL));
            if (DroidSafeAndroidRuntime.control) throw new SipException("Dialog.createRequest(): Invalid request");
        } 
        {
            boolean var6451C3E80BA914B63DA4E2C0EE66A26D_1066432006 = (this.getState() == null
                || (this.getState().getValue() == TERMINATED_STATE && !method
                        .equalsIgnoreCase(Request.BYE))
                || (this.isServer() && this.getState().getValue() == EARLY_STATE && method
                        .equalsIgnoreCase(Request.BYE)));
            if (DroidSafeAndroidRuntime.control) throw new SipException("Dialog  " + getDialogId()
                    + " not yet established or terminated " + this.getState());
        } 
        SipUri sipUri = null;
        {
            boolean var32CB10BEC2D464683496BEC61BDB1C7C_890487366 = (this.getRemoteTarget() != null);
            sipUri = (SipUri) this.getRemoteTarget().getURI().clone();
            {
                sipUri = (SipUri) this.getRemoteParty().getURI().clone();
                sipUri.clearUriParms();
            } 
        } 
        CSeq cseq = new CSeq();
        try 
        {
            cseq.setMethod(method);
            cseq.setSeqNumber(this.getLocalSeqNumber());
        } 
        catch (Exception ex)
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1436652435 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logError("Unexpected error");
            } 
            InternalErrorHandler.handleException(ex);
        } 
        ListeningPointImpl lp = (ListeningPointImpl) this.sipProvider
                .getListeningPoint(sipResponse.getTopmostVia().getTransport());
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1617219563 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logError(
                        "Cannot find listening point for transport "
                                + sipResponse.getTopmostVia().getTransport());
            } 
            if (DroidSafeAndroidRuntime.control) throw new SipException("Cannot find listening point for transport "
                    + sipResponse.getTopmostVia().getTransport());
        } 
        Via via = lp.getViaHeader();
        From from = new From();
        from.setAddress(this.localParty);
        To to = new To();
        to.setAddress(this.remoteParty);
        SIPRequest sipRequest = sipResponse.createRequest(sipUri, via, cseq, from, to);
        {
            boolean var134460D0D6709F29F302E0A7AAE6BE0A_880710782 = (SIPRequest.isTargetRefresh(method));
            {
                ContactHeader contactHeader = ((ListeningPointImpl) this.sipProvider
                    .getListeningPoint(lp.getTransport())).createContactHeader();
                ((SipURI) contactHeader.getAddress().getURI()).setSecure(this.isSecure());
                sipRequest.setHeader(contactHeader);
            } 
        } 
        try 
        {
            cseq = (CSeq) sipRequest.getCSeq();
            cseq.setSeqNumber(this.localSequenceNumber + 1);
        } 
        catch (InvalidArgumentException ex)
        {
            InternalErrorHandler.handleException(ex);
        } 
        {
            boolean varCF8EB2629DEB9D14D2D7AE3B8557C47D_968452767 = (method.equals(Request.SUBSCRIBE));
            {
                sipRequest.addHeader(eventHeader);
            } 
        } 
        try 
        {
            {
                boolean var8960EF1666EE0A76790F8BA2DB88F003_998439808 = (this.getLocalTag() != null);
                {
                    from.setTag(this.getLocalTag());
                } 
                {
                    from.removeTag();
                } 
            } 
            {
                boolean var2C6389CD64DE33F7E280071219A47D88_789402936 = (this.getRemoteTag() != null);
                {
                    to.setTag(this.getRemoteTag());
                } 
                {
                    to.removeTag();
                } 
            } 
        } 
        catch (ParseException ex)
        {
            InternalErrorHandler.handleException(ex);
        } 
        this.updateRequest(sipRequest);
        varB4EAC82CA7396A68D541C85D26508E83_1926165749 = sipRequest;
        addTaint(method.getTaint());
        addTaint(sipResponse.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1926165749.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1926165749;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.396 -0400", hash_original_method = "9C360B0CF1AC53C036709107CECBBC75", hash_generated_method = "12ADC8E628FCA65C06A8DA9FD0AEED45")
    public void sendRequest(ClientTransaction clientTransactionId) throws TransactionDoesNotExistException, SipException {
        this.sendRequest(clientTransactionId, !this.isBackToBackUserAgent);
        addTaint(clientTransactionId.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.399 -0400", hash_original_method = "E90E816BF2167876B04C570AAB507565", hash_generated_method = "23A252CD5D6ED53BACDCD778BE300DE8")
    public void sendRequest(ClientTransaction clientTransactionId, boolean allowInterleaving) throws TransactionDoesNotExistException, SipException {
        {
            boolean var0B73476425A078E6D0D1236F4BB54CAC_1511964226 = ((!allowInterleaving)
                && clientTransactionId.getRequest().getMethod().equals(Request.INVITE));
            {
                new Thread((new ReInviteSender(clientTransactionId))).start();
            } 
        } 
        SIPRequest dialogRequest = ((SIPClientTransaction) clientTransactionId)
                .getOriginalRequest();
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_151035052 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug(
                    "dialog.sendRequest " + " dialog = " + this + "\ndialogRequest = \n"
                            + dialogRequest);
        } 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null parameter");
        {
            boolean var1169745922CE63DD156260B7D456AE05_179145019 = (dialogRequest.getMethod().equals(Request.ACK)
                || dialogRequest.getMethod().equals(Request.CANCEL));
            if (DroidSafeAndroidRuntime.control) throw new SipException("Bad Request Method. " + dialogRequest.getMethod());
        } 
        {
            boolean varC96A74E8BBC3DA149625FF2EC6772871_1481702009 = (byeSent && isTerminatedOnBye() && !dialogRequest.getMethod().equals(Request.BYE));
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1074430225 = (sipStack.isLoggingEnabled());
                    sipStack.getStackLogger().logError("BYE already sent for " + this);
                } 
                if (DroidSafeAndroidRuntime.control) throw new SipException("Cannot send request; BYE already sent");
            } 
        } 
        {
            boolean varBC4604ED9CEFF5AB625860EF0715C0B5_363231123 = (dialogRequest.getTopmostVia() == null);
            {
                Via via = ((SIPClientTransaction) clientTransactionId).getOutgoingViaHeader();
                dialogRequest.addHeader(via);
            } 
        } 
        {
            boolean var906255BA0B7F8ECAF3658C3F65A640E3_881873291 = (!this.getCallId().getCallId().equalsIgnoreCase(dialogRequest.getCallId().getCallId()));
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_2110999784 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logError("CallID " + this.getCallId());
                        sipStack.getStackLogger().logError(
                        "RequestCallID = " + dialogRequest.getCallId().getCallId());
                        sipStack.getStackLogger().logError("dialog =  " + this);
                    } 
                } 
                if (DroidSafeAndroidRuntime.control) throw new SipException("Bad call ID in request");
            } 
        } 
        ((SIPClientTransaction) clientTransactionId).setDialog(this, this.dialogId);
        this.addTransaction((SIPTransaction) clientTransactionId);
        ((SIPClientTransaction) clientTransactionId).isMapped = true;
        From from = (From) dialogRequest.getFrom();
        To to = (To) dialogRequest.getTo();
        {
            boolean varB53BA052D4209F28F5E99708019E0649_971331962 = (this.getLocalTag() != null && from.getTag() != null
                && !from.getTag().equals(this.getLocalTag()));
            if (DroidSafeAndroidRuntime.control) throw new SipException("From tag mismatch expecting  " + this.getLocalTag());
        } 
        {
            boolean var89BDFDBB281A8FAD37A897E8D21F188F_912026877 = (this.getRemoteTag() != null && to.getTag() != null
                && !to.getTag().equals(this.getRemoteTag()));
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_474200380 = (sipStack.isLoggingEnabled());
                    this.sipStack.getStackLogger().logWarning(
                    "To header tag mismatch expecting " + this.getRemoteTag());
                } 
            } 
        } 
        {
            boolean varD80EDFF969ADE551B15AAA6F81B0F87F_702244137 = (this.getLocalTag() == null && dialogRequest.getMethod().equals(Request.NOTIFY));
            {
                {
                    boolean varA7B972031300250A30428BA53613E368_1321644427 = (!this.getMethod().equals(Request.SUBSCRIBE));
                    if (DroidSafeAndroidRuntime.control) throw new SipException("Trying to send NOTIFY without SUBSCRIBE Dialog!");
                } 
                this.setLocalTag(from.getTag());
            } 
        } 
        try 
        {
            {
                boolean var8960EF1666EE0A76790F8BA2DB88F003_2024531141 = (this.getLocalTag() != null);
                from.setTag(this.getLocalTag());
            } 
            {
                boolean var2C6389CD64DE33F7E280071219A47D88_229536083 = (this.getRemoteTag() != null);
                to.setTag(this.getRemoteTag());
            } 
        } 
        catch (ParseException ex)
        {
            InternalErrorHandler.handleException(ex);
        } 
        Hop hop = ((SIPClientTransaction) clientTransactionId).getNextHop();
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1092535485 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug(
                    "Using hop = " + hop.getHost() + " : " + hop.getPort());
            } 
        } 
        try 
        {
            MessageChannel messageChannel = sipStack.createRawMessageChannel(this
                    .getSipProvider().getListeningPoint(hop.getTransport()).getIPAddress(),
                    this.firstTransactionPort, hop);
            MessageChannel oldChannel = ((SIPClientTransaction) 
            		clientTransactionId).getMessageChannel();
            oldChannel.uncache();
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_725831516 = (sipStack.isLoggingEnabled());
                    sipStack.getStackLogger().logDebug(
                            "oldChannel: useCount " + oldChannel.useCount);
                } 
            } 
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_394448744 = (sipStack.isLoggingEnabled());
                    sipStack.getStackLogger().logDebug(
                            "Null message channel using outbound proxy !");
                } 
                Hop outboundProxy = sipStack.getRouter(dialogRequest).getOutboundProxy();
                if (DroidSafeAndroidRuntime.control) throw new SipException("No route found! hop=" + hop);
                messageChannel = sipStack.createRawMessageChannel(this.getSipProvider()
                        .getListeningPoint(outboundProxy.getTransport()).getIPAddress(),
                        this.firstTransactionPort, outboundProxy);
                ((SIPClientTransaction) clientTransactionId)
                            .setEncapsulatedChannel(messageChannel);
            } 
            {
                ((SIPClientTransaction) clientTransactionId)
                        .setEncapsulatedChannel(messageChannel);
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1387580210 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logDebug("using message channel " + messageChannel);
                    } 
                } 
            } 
            oldChannel.close();
        } 
        catch (Exception ex)
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_537169084 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logException(ex);
            } 
            if (DroidSafeAndroidRuntime.control) throw new SipException("Could not create message channel", ex);
        } 
        try 
        {
            dialogRequest.getCSeq().setSeqNumber(getLocalSeqNumber());
        } 
        catch (InvalidArgumentException ex)
        {
            sipStack.getStackLogger().logFatalError(ex.getMessage());
        } 
        try 
        {
            ((SIPClientTransaction) clientTransactionId).sendMessage(dialogRequest);
            {
                boolean varD35D780BD2119470ABCE216878F145E2_2065876892 = (dialogRequest.getMethod().equals(Request.BYE));
                {
                    this.byeSent = true;
                    {
                        boolean var61F0069F460C1DE219DEA32CC067873C_144238132 = (isTerminatedOnBye());
                        {
                            this.setState(DialogState._TERMINATED);
                        } 
                    } 
                } 
            } 
        } 
        catch (IOException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("error sending message", ex);
        } 
        addTaint(clientTransactionId.getTaint());
        addTaint(allowInterleaving);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.400 -0400", hash_original_method = "BB6E18DBBED43A4BEB60B225A721A13E", hash_generated_method = "F5B1C5A50773CD4F7059FC83F8CEC3AF")
    private boolean toRetransmitFinalResponse(int T2) {
        {
            this.retransmissionTicksLeft = 2 * prevRetransmissionTicks;
            this.retransmissionTicksLeft = prevRetransmissionTicks;
            this.prevRetransmissionTicks = retransmissionTicksLeft;
        } 
        addTaint(T2);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1155481138 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1155481138;
        
        
            
                
            
                
            
            
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.400 -0400", hash_original_method = "085350C5B4F086D4A04022EDF074C477", hash_generated_method = "CEED3E6C57E3AE5A6BAC9A7B6FFC14D3")
    protected void setRetransmissionTicks() {
        this.retransmissionTicksLeft = 1;
        this.prevRetransmissionTicks = 1;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.401 -0400", hash_original_method = "9B2F4C7AC7E3D2DC3FE02C5A18455E2B", hash_generated_method = "3ED09F354D4492964405DC24E44F95E4")
    public void resendAck() throws SipException {
        {
            boolean var6C2ACBE5BDF4F74D454F50C12DD0D9DC_1142927188 = (this.getLastAckSent() != null);
            {
                {
                    boolean varCB70FC8263CD09B0F1B84A47A0A0E4F7_1283587747 = (getLastAckSent().getHeader(TimeStampHeader.NAME) != null
                    && sipStack.generateTimeStampHeader);
                    {
                        TimeStamp ts = new TimeStamp();
                        try 
                        {
                            ts.setTimeStamp(System.currentTimeMillis());
                            getLastAckSent().setHeader(ts);
                        } 
                        catch (InvalidArgumentException e)
                        { }
                    } 
                } 
                this.sendAck(getLastAckSent(), false);
            } 
        } 
        
        
            
                    
                
                
                    
                    
                
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.402 -0400", hash_original_method = "691C5451C67574E660997BC2056A5F23", hash_generated_method = "DB9AFB8E7B362C2F06D64D64E977480F")
    public String getMethod() {
        String varB4EAC82CA7396A68D541C85D26508E83_1263717728 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1263717728 = this.method;
        varB4EAC82CA7396A68D541C85D26508E83_1263717728.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1263717728;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.404 -0400", hash_original_method = "1E91804F8A3049A9C15BCD340F87DF5D", hash_generated_method = "D65A9F5482073FAE443D873B0275BD76")
    protected void startTimer(SIPServerTransaction transaction) {
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_302222774 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug("Timer already running for " + getDialogId());
            } 
        } 
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_30268065 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug("Starting dialog timer for " + getDialogId());
        } 
        this.ackSeen = false;
        acquireTimerTaskSem();
        try 
        {
            {
                this.timerTask.transaction = transaction;
            } 
            {
                this.timerTask = new DialogTimerTask(transaction);
                sipStack.getTimer().schedule(timerTask, SIPTransactionStack.BASE_TIMER_INTERVAL,
	                    SIPTransactionStack.BASE_TIMER_INTERVAL);
            } 
        } 
        finally 
        {
            releaseTimerTaskSem();
        } 
        this.setRetransmissionTicks();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.405 -0400", hash_original_method = "3E7472F910A577F9E6FCB71153FF16E3", hash_generated_method = "F1187DBDC9E801B24174FAD13B752CDB")
    protected void stopTimer() {
        try 
        {
            acquireTimerTaskSem();
            try 
            {
                {
                    this.timerTask.cancel();
                    this.timerTask = null;
                } 
            } 
            finally 
            {
                releaseTimerTaskSem();
            } 
        } 
        catch (Exception ex)
        { }
        
        
        	
        	
	            
	            	
		            
	            
        	
        		
        	
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.409 -0400", hash_original_method = "B99416CED2F5EC9B5AF4977F926F9FAE", hash_generated_method = "43B60F681A67240D7C831129FAA219AD")
    public Request createPrack(Response relResponse) throws DialogDoesNotExistException,
            SipException {
        Request varB4EAC82CA7396A68D541C85D26508E83_2038779654 = null; 
        Request varB4EAC82CA7396A68D541C85D26508E83_896719523 = null; 
        {
            boolean var5F13FEDECFA24670F7B4ECAB7A40873E_1230850246 = (this.getState() == null || this.getState().equals(DialogState.TERMINATED));
            if (DroidSafeAndroidRuntime.control) throw new DialogDoesNotExistException("Dialog not initialized or terminated");
        } 
        {
            boolean var87BC905A631F8D351A6D3C712E9DE58A_1672617428 = ((RSeq) relResponse.getHeader(RSeqHeader.NAME) == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException("Missing RSeq Header");
            } 
        } 
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
            varB4EAC82CA7396A68D541C85D26508E83_2038779654 = (Request) sipRequest;
        } 
        catch (Exception ex)
        {
            InternalErrorHandler.handleException(ex);
            varB4EAC82CA7396A68D541C85D26508E83_896719523 = null;
        } 
        addTaint(relResponse.getTaint());
        Request varA7E53CE21691AB073D9660D615818899_1082298635; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1082298635 = varB4EAC82CA7396A68D541C85D26508E83_2038779654;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1082298635 = varB4EAC82CA7396A68D541C85D26508E83_896719523;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1082298635.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1082298635;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.409 -0400", hash_original_method = "AE874CF06DEDE92D6543D8F7D52B6043", hash_generated_method = "5FCECC0122B9E8F7A618CF5DDE5A486F")
    private void updateRequest(SIPRequest sipRequest) {
        RouteList rl = this.getRouteList();
        {
            boolean var1845ECD20E35B086D417AFB72F9DDE84_424094930 = (rl.size() > 0);
            {
                sipRequest.setHeader(rl);
            } 
            {
                sipRequest.removeHeader(RouteHeader.NAME);
            } 
        } 
        {
            boolean var896FD3C9C4EED86170D10D69961A19CE_850864340 = (MessageFactoryImpl.getDefaultUserAgentHeader() != null);
            {
                sipRequest.setHeader(MessageFactoryImpl.getDefaultUserAgentHeader());
            } 
        } 
        addTaint(sipRequest.getTaint());
        
        
        
            
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.412 -0400", hash_original_method = "8ECB2239C30E6B6F2CF5AEE7662DC317", hash_generated_method = "8E1B0C082AA09279F186605870692379")
    public Request createAck(long cseqno) throws InvalidArgumentException, SipException {
        Request varB4EAC82CA7396A68D541C85D26508E83_898621611 = null; 
        {
            boolean varD24E8B9BE4529879766AB23987E8AD7C_1057257293 = (!method.equals(Request.INVITE));
            if (DroidSafeAndroidRuntime.control) throw new SipException("Dialog was not created with an INVITE" + method);
        } 
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad cseq <= 0 ");
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad cseq > " + ((((long) 1) << 32) - 1));
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("Cannot create ACK - no remote Target!");
        } 
        {
            boolean var01D5629BD6EE4648A9CF76B7CC4467B7_1917451066 = (this.sipStack.isLoggingEnabled());
            {
                this.sipStack.getStackLogger().logDebug("createAck " + this + " cseqno " + cseqno);
            } 
        } 
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1808383530 = (sipStack.isLoggingEnabled());
                {
                    this.sipStack.getStackLogger().logDebug(
                    "WARNING : Attempt to crete ACK without OK " + this);
                    this.sipStack.getStackLogger().logDebug("LAST RESPONSE = " + this.lastResponse);
                } 
            } 
            if (DroidSafeAndroidRuntime.control) throw new SipException("Dialog not yet established -- no OK response!");
        } 
        try 
        {
            SipURI uri4transport = null;
            {
                boolean var88914CD57C4971E4E025A7D4C058C72C_105417539 = (this.routeList != null && !this.routeList.isEmpty());
                {
                    Route r = (Route) this.routeList.getFirst();
                    uri4transport = ((SipURI) r.getAddress().getURI());
                } 
                {
                    uri4transport = ((SipURI) this.remoteTarget.getURI());
                } 
            } 
            String transport = uri4transport.getTransportParam();
            {
                transport = uri4transport.isSecure() ? ListeningPoint.TLS : ListeningPoint.UDP;
            } 
            ListeningPointImpl lp = (ListeningPointImpl) sipProvider.getListeningPoint(transport);
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1160447884 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logError(
                        "remoteTargetURI " + this.remoteTarget.getURI());
                        sipStack.getStackLogger().logError("uri4transport = " + uri4transport);
                        sipStack.getStackLogger().logError("No LP found for transport=" + transport);
                    } 
                } 
                if (DroidSafeAndroidRuntime.control) throw new SipException(
                        "Cannot create ACK - no ListeningPoint for transport towards next hop found:"
                                + transport);
            } 
            SIPRequest sipRequest = new SIPRequest();
            sipRequest.setMethod(Request.ACK);
            sipRequest.setRequestURI((SipUri) getRemoteTarget().getURI().clone());
            sipRequest.setCallId(this.callIdHeader);
            sipRequest.setCSeq(new CSeq(cseqno, Request.ACK));
            List<Via> vias = new ArrayList<Via>();
            Via via = this.lastResponse.getTopmostVia();
            via.removeParameters();
            {
                boolean var5ACE7FF7AC32F8E6606DBA1F89AB80FD_2053961552 = (originalRequest != null && originalRequest.getTopmostVia() != null);
                {
                    NameValueList originalRequestParameters = originalRequest.getTopmostVia()
                        .getParameters();
                    {
                        boolean var6A3D0DB6457794914BB4A50CBA9DA9AB_1729573987 = (originalRequestParameters != null && originalRequestParameters.size() > 0);
                        {
                            via.setParameters((NameValueList) originalRequestParameters.clone());
                        } 
                    } 
                } 
            } 
            via.setBranch(Utils.getInstance().generateBranchId());
            vias.add(via);
            sipRequest.setVia(vias);
            From from = new From();
            from.setAddress(this.localParty);
            from.setTag(this.myTag);
            sipRequest.setFrom(from);
            To to = new To();
            to.setAddress(this.remoteParty);
            to.setTag(this.hisTag);
            sipRequest.setTo(to);
            sipRequest.setMaxForwards(new MaxForwards(70));
            {
                Authorization authorization = this.originalRequest.getAuthorization();
                sipRequest.setHeader(authorization);
            } 
            this.updateRequest(sipRequest);
            varB4EAC82CA7396A68D541C85D26508E83_898621611 = sipRequest;
        } 
        catch (Exception ex)
        {
            InternalErrorHandler.handleException(ex);
            if (DroidSafeAndroidRuntime.control) throw new SipException("unexpected exception ", ex);
        } 
        addTaint(cseqno);
        varB4EAC82CA7396A68D541C85D26508E83_898621611.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_898621611;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.413 -0400", hash_original_method = "225E26F17D14C81F6F76A7525B288E82", hash_generated_method = "F8E002B8D0B1C16BDB07E9C2F3402C5A")
    public SipProviderImpl getSipProvider() {
        SipProviderImpl varB4EAC82CA7396A68D541C85D26508E83_1004379954 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1004379954 = this.sipProvider;
        varB4EAC82CA7396A68D541C85D26508E83_1004379954.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1004379954;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.414 -0400", hash_original_method = "8A8245F47D42BA43478E00CC55ABA836", hash_generated_method = "926E58A1A024385C486CD7AE44684A34")
    public void setSipProvider(SipProviderImpl sipProvider) {
        this.sipProvider = sipProvider;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.415 -0400", hash_original_method = "CF7951DD9E6C51606E8031643391B018", hash_generated_method = "72CB8FCBF63B39753E05C2851C17060E")
    public void setResponseTags(SIPResponse sipResponse) {
        {
            boolean var8902B2D54D9D64C1AD2F6B4D577F0AC1_674993673 = (this.getLocalTag() != null || this.getRemoteTag() != null);
        } 
        String responseFromTag = sipResponse.getFromTag();
        {
            {
                boolean varEBFAC7E822975644712D237D7D794A79_294036620 = (responseFromTag.equals(this.getLocalTag()));
                {
                    sipResponse.setToTag(this.getRemoteTag());
                } 
                {
                    boolean varC5E254C584E79962FDD35AF188F3D95B_1438756142 = (responseFromTag.equals(this.getRemoteTag()));
                    {
                        sipResponse.setToTag(this.getLocalTag());
                    } 
                } 
            } 
        } 
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1835742627 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logWarning("No from tag in response! Not RFC 3261 compatible.");
            } 
        } 
        addTaint(sipResponse.getTaint());
        
        
            
        
        
        
            
                
            
                
            
        
        	
        		
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.419 -0400", hash_original_method = "80C5F1C3A7F1BF77711B99F831173748", hash_generated_method = "7B0360E5988191EA2DFB63551EFEF91A")
    public void setLastResponse(SIPTransaction transaction, SIPResponse sipResponse) {
        this.callIdHeader = sipResponse.getCallId();
        int statusCode = sipResponse.getStatusCode();
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_912737515 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logWarning(
                    "Invalid status code - 100 in setLastResponse - ignoring");
            } 
        } 
        this.lastResponse = sipResponse;
        this.setAssigned();
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_966604143 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug(
                    "sipDialog: setLastResponse:" + this + " lastResponse = "
                            + this.lastResponse.getFirstLine());
            } 
        } 
        {
            boolean varECEE72F2BE8BE87D5366A0277FBCE038_1325194308 = (this.getState() == DialogState.TERMINATED);
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_17993028 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logDebug(
                        "sipDialog: setLastResponse -- dialog is terminated - ignoring ");
                    } 
                } 
                {
                    boolean var7C21E56F04FFB7827B07DB28A1638AE6_936172927 = (sipResponse.getCSeq().getMethod().equals(Request.INVITE) && statusCode == 200);
                    {
                        this.lastInviteOkReceived = Math.max(sipResponse.getCSeq().getSeqNumber(),
                        this.lastInviteOkReceived);
                    } 
                } 
            } 
        } 
        String cseqMethod = sipResponse.getCSeq().getMethod();
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_446339696 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logStackTrace();
                sipStack.getStackLogger().logDebug("cseqMethod = " + cseqMethod);
                sipStack.getStackLogger().logDebug("dialogState = " + this.getState());
                sipStack.getStackLogger().logDebug("method = " + this.getMethod());
                sipStack.getStackLogger().logDebug("statusCode = " + statusCode);
                sipStack.getStackLogger().logDebug("transaction = " + transaction);
            } 
        } 
        {
            {
                boolean var839B41C03A2B5D99C7BD81EF76FDD890_155598440 = (sipStack.isDialogCreated(cseqMethod));
                {
                    {
                        boolean var08A2AAD99B8F98462ECF577990E03E96_316553236 = (getState() == null && (statusCode / 100 == 1));
                        {
                            setState(SIPDialog.EARLY_STATE);
                            {
                                boolean var86C6F66A5EE9F0068D7CE893541F2279_1285487419 = ((sipResponse.getToTag() != null || sipStack.rfc2543Supported)
                            && this.getRemoteTag() == null);
                                {
                                    setRemoteTag(sipResponse.getToTag());
                                    this.setDialogId(sipResponse.getDialogId(false));
                                    sipStack.putDialog(this);
                                    this.addRoute(sipResponse);
                                } 
                            } 
                        } 
                        {
                            boolean varFD6529C640F5D93B1D57A138B69C639B_1245595410 = (getState() != null && getState().equals(DialogState.EARLY)
                        && statusCode / 100 == 1);
                            {
                                {
                                    boolean var4453581B92AA957108C579A7BBD1E438_1125684843 = (cseqMethod.equals(getMethod()) && transaction != null
                            && (sipResponse.getToTag() != null || sipStack.rfc2543Supported));
                                    {
                                        setRemoteTag(sipResponse.getToTag());
                                        this.setDialogId(sipResponse.getDialogId(false));
                                        sipStack.putDialog(this);
                                        this.addRoute(sipResponse);
                                    } 
                                } 
                            } 
                            {
                                {
                                    boolean var239B25B26F48835960443934FE465816_675470676 = (cseqMethod.equals(getMethod())
                            && (sipResponse.getToTag() != null || sipStack.rfc2543Supported)
                            && this.getState() != DialogState.CONFIRMED);
                                    {
                                        setRemoteTag(sipResponse.getToTag());
                                        this.setDialogId(sipResponse.getDialogId(false));
                                        sipStack.putDialog(this);
                                        this.addRoute(sipResponse);
                                        setState(SIPDialog.CONFIRMED_STATE);
                                    } 
                                } 
                                {
                                    boolean var184B92973316EEACC4E8F3D92F947022_1696892905 = (cseqMethod.equals(Request.INVITE));
                                    {
                                        this.lastInviteOkReceived = Math.max(sipResponse.getCSeq().getSeqNumber(),
                                this.lastInviteOkReceived);
                                    } 
                                } 
                            } 
                            {
                                boolean var002EA49254D7FFC38F40D126F1CC9B93_1782409253 = (statusCode >= 300
                        && statusCode <= 699
                        && (getState() == null || (cseqMethod.equals(getMethod()) && getState()
                                .getValue() == SIPDialog.EARLY_STATE)));
                                {
                                    setState(SIPDialog.TERMINATED_STATE);
                                } 
                            } 
                        } 
                    } 
                    {
                        boolean varBE8416D96C82B905D899DAE9933207EA_1398660617 = (this.getState() != DialogState.CONFIRMED && this.getState() != DialogState.TERMINATED);
                        {
                            {
                                RecordRouteList rrList = originalRequest.getRecordRouteHeaders();
                                {
                                    ListIterator<RecordRoute> it = rrList.listIterator(rrList.size());
                                    {
                                        boolean var92523E1D2D6B9A5BA652D95D8D906FE7_1526891114 = (it.hasPrevious());
                                        {
                                            RecordRoute rr = (RecordRoute) it.previous();
                                            Route route = (Route) routeList.getFirst();
                                            {
                                                boolean varD5391073D49D26C2405CCD1345D5D087_1142175400 = (route != null && rr.getAddress().equals(route.getAddress()));
                                                {
                                                    routeList.removeFirst();
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
                    boolean var7AC6283B1986B5EAA725F6A0CF5B9F25_946751001 = (cseqMethod.equals(Request.NOTIFY)
                    && (this.getMethod().equals(Request.SUBSCRIBE) || this.getMethod().equals(
                            Request.REFER)) && sipResponse.getStatusCode() / 100 == 2
                    && this.getState() == null);
                    {
                        this.setDialogId(sipResponse.getDialogId(true));
                        sipStack.putDialog(this);
                        this.setState(SIPDialog.CONFIRMED_STATE);
                    } 
                    {
                        boolean varE749A0B488BCFEEA24F7764568DA41BB_396103115 = (cseqMethod.equals(Request.BYE) && statusCode / 100 == 2
                    && isTerminatedOnBye());
                        {
                            setState(SIPDialog.TERMINATED_STATE);
                        } 
                    } 
                } 
            } 
        } 
        {
            {
                boolean varDFD8EB8316ABF98C4152E3A58F249F7D_911007897 = (cseqMethod.equals(Request.BYE) && statusCode / 100 == 2
                    && this.isTerminatedOnBye());
                {
                    this.setState(SIPDialog.TERMINATED_STATE);
                } 
                {
                    boolean doPutDialog = false;
                    {
                        boolean var7F7C84F2182F0A7FD32A6DC59936958E_1659789809 = (getLocalTag() == null && sipResponse.getTo().getTag() != null
                        && sipStack.isDialogCreated(cseqMethod) && cseqMethod.equals(getMethod()));
                        {
                            setLocalTag(sipResponse.getTo().getTag());
                            doPutDialog = true;
                        } 
                    } 
                    {
                        {
                            {
                                setState(SIPDialog.EARLY_STATE);
                                this.setDialogId(sipResponse.getDialogId(true));
                                sipStack.putDialog(this);
                            } 
                        } 
                        {
                            {
                                boolean var5EEA5383440BFA6F3C614F44448A4223_1896126072 = (statusCode == 489
                                && (cseqMethod.equals(Request.NOTIFY) || cseqMethod
                                        .equals(Request.SUBSCRIBE)));
                                {
                                    {
                                        boolean var6FE8ACC5352DCA3449210F8EDED912B3_341236484 = (sipStack.isLoggingEnabled());
                                        sipStack.getStackLogger().logDebug(
                                    "RFC 3265 : Not setting dialog to TERMINATED for 489");
                                    } 
                                } 
                                {
                                    {
                                        boolean varE3695A6993661066E9CCD532BC123501_1207186964 = (!this.isReInvite() && getState() != DialogState.CONFIRMED);
                                        {
                                            this.setState(SIPDialog.TERMINATED_STATE);
                                        } 
                                    } 
                                } 
                            } 
                        } 
                    } 
                    {
                        {
                            boolean var8F048B81832FCC5E25717E696D6EC78F_1713010581 = (this.dialogState <= SIPDialog.EARLY_STATE
                            && (cseqMethod.equals(Request.INVITE)
                                    || cseqMethod.equals(Request.SUBSCRIBE) || cseqMethod
                                    .equals(Request.REFER)));
                            {
                                this.setState(SIPDialog.CONFIRMED_STATE);
                            } 
                        } 
                        {
                            this.setDialogId(sipResponse.getDialogId(true));
                            sipStack.putDialog(this);
                        } 
                        {
                            boolean varCABBB85C5AA4259E2991A258DBA7D46B_1772858012 = (transaction.getState() != TransactionState.TERMINATED
                            && sipResponse.getStatusCode() == Response.OK
                            && cseqMethod.equals(Request.INVITE)
                            && this.isBackToBackUserAgent);
                            {
                                {
                                    boolean varC5A2075CB8D88EC332A5381179A3C4E5_240326956 = (!this.takeAckSem());
                                    {
                                        {
                                            boolean var974BD9A3C84119780B64DA7C8AA64368_1937853246 = (sipStack.isLoggingEnabled());
                                            {
                                                sipStack.getStackLogger().logDebug(
                                            "Delete dialog -- cannot acquire ackSem");
                                            } 
                                        } 
                                        this.delete();
                                    } 
                                } 
                            } 
                        } 
                    } 
                } 
            } 
        } 
        addTaint(transaction.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.419 -0400", hash_original_method = "96CF2F98DDD4CA038A3AFDF5A5247694", hash_generated_method = "D2F589F47DEFD2BE2D8B86F8B06450CF")
    public void startRetransmitTimer(SIPServerTransaction sipServerTx, Response response) {
        {
            boolean varDA05BDD7E394F41387C809972258ED76_1178458822 = (sipServerTx.getRequest().getMethod().equals(Request.INVITE)
                && response.getStatusCode() / 100 == 2);
            {
                this.startTimer(sipServerTx);
            } 
        } 
        addTaint(sipServerTx.getTaint());
        addTaint(response.getTaint());
        
        
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.420 -0400", hash_original_method = "5F3E7F6102F24C611CAB04E5AE199DBF", hash_generated_method = "6843C137822AFD65E52C492D0946828F")
    public SIPResponse getLastResponse() {
        SIPResponse varB4EAC82CA7396A68D541C85D26508E83_1473463007 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1473463007 = lastResponse;
        varB4EAC82CA7396A68D541C85D26508E83_1473463007.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1473463007;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.420 -0400", hash_original_method = "5B8AFE9B6B91DF83BE42F6862D2EF06A", hash_generated_method = "04011C598AA11817E2828FAAA72C7959")
    private void doTargetRefresh(SIPMessage sipMessage) {
        ContactList contactList = sipMessage.getContactHeaders();
        {
            Contact contact = (Contact) contactList.getFirst();
            this.setRemoteTarget(contact);
        } 
        addTaint(sipMessage.getTaint());
        
        
        
            
            
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.421 -0400", hash_original_method = "DE196281E5E185EC5F05D42F6040C5AD", hash_generated_method = "08DB60C6CD3057F7D4638F90A476A4D2")
    public Response createReliableProvisionalResponse(int statusCode) throws InvalidArgumentException, SipException {
        Response varB4EAC82CA7396A68D541C85D26508E83_872821704 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("Not a Server Dialog!");
        } 
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("Bad status code ");
        SIPRequest request = this.originalRequest;
        {
            boolean varF7429BEB5E0EF391085C3EA5B848B555_1111128149 = (!request.getMethod().equals(Request.INVITE));
            if (DroidSafeAndroidRuntime.control) throw new SipException("Bad method");
        } 
        ListIterator<SIPHeader> list = request.getHeaders(SupportedHeader.NAME);
        {
            boolean var4A2559DE457AD8ED09DD13E71379114F_345688427 = (list == null || !optionPresent(list, "100rel"));
            {
                list = request.getHeaders(RequireHeader.NAME);
                {
                    boolean var1B8A6F1B7D3894FD5B5CD4B77CBF0692_1641357739 = (list == null || !optionPresent(list, "100rel"));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new SipException("No Supported/Require 100rel header in the request");
                    } 
                } 
            } 
        } 
        SIPResponse response = request.createResponse(statusCode);
        Require require = new Require();
        try 
        {
            require.setOptionTag("100rel");
        } 
        catch (Exception ex)
        {
            InternalErrorHandler.handleException(ex);
        } 
        response.addHeader(require);
        RSeq rseq = new RSeq();
        rseq.setSeqNumber(1L);
        RecordRouteList rrl = request.getRecordRouteHeaders();
        {
            RecordRouteList rrlclone = (RecordRouteList) rrl.clone();
            response.setHeader(rrlclone);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_872821704 = response;
        addTaint(statusCode);
        varB4EAC82CA7396A68D541C85D26508E83_872821704.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_872821704;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.423 -0400", hash_original_method = "CEB91EBD9D583AC6C7E366C7B6D0F858", hash_generated_method = "0DCA6567462D0ED74A8F81A5D4981D8A")
    public boolean handlePrack(SIPRequest prackRequest) {
        {
            boolean var0E41A90AC7F80C21FD8716EAE0D773F7_1206223190 = (!this.isServer());
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1368687658 = (sipStack.isLoggingEnabled());
                    sipStack.getStackLogger().logDebug("Dropping Prack -- not a server Dialog");
                } 
            } 
        } 
        SIPServerTransaction sipServerTransaction = (SIPServerTransaction) this
                .getFirstTransaction();
        SIPResponse sipResponse = sipServerTransaction.getReliableProvisionalResponse();
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_653221161 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger()
                        .logDebug("Dropping Prack -- ReliableResponse not found");
            } 
        } 
        RAck rack = (RAck) prackRequest.getHeader(RAckHeader.NAME);
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1433010610 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug("Dropping Prack -- rack header not found");
            } 
        } 
        CSeq cseq = (CSeq) sipResponse.getCSeq();
        {
            boolean var278DC96722B25CDE6DFD16B8198946C1_1956258288 = (!rack.getMethod().equals(cseq.getMethod()));
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_67790404 = (sipStack.isLoggingEnabled());
                    sipStack.getStackLogger().logDebug(
                        "Dropping Prack -- CSeq Header does not match PRACK");
                } 
            } 
        } 
        {
            boolean var9E7D79F6F26763E9EC31F75D4B835E42_2113174888 = (rack.getCSeqNumberLong() != cseq.getSeqNumber());
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_978337531 = (sipStack.isLoggingEnabled());
                    sipStack.getStackLogger().logDebug(
                        "Dropping Prack -- CSeq Header does not match PRACK");
                } 
            } 
        } 
        RSeq rseq = (RSeq) sipResponse.getHeader(RSeqHeader.NAME);
        {
            boolean var14265A1FCB2C0EE420AF27A8D1000FC8_783595446 = (rack.getRSequenceNumber() != rseq.getSeqNumber());
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_593664744 = (sipStack.isLoggingEnabled());
                    sipStack.getStackLogger().logDebug(
                        "Dropping Prack -- RSeq Header does not match PRACK");
                } 
            } 
        } 
        boolean var9683C82188D8B4F740D5FD5CABA0ABB6_932953554 = (sipServerTransaction.prackRecieved());
        addTaint(prackRequest.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_821727340 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_821727340;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.424 -0400", hash_original_method = "333DA078CA74B6FD5F6C9544F533B1F3", hash_generated_method = "07B20B045E7249395510434AB9FB2EEC")
    public void sendReliableProvisionalResponse(Response relResponse) throws SipException {
        {
            boolean var0E41A90AC7F80C21FD8716EAE0D773F7_1843959968 = (!this.isServer());
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException("Not a Server Dialog");
            } 
        } 
        SIPResponse sipResponse = (SIPResponse) relResponse;
        {
            boolean varF58A7EF76B015A36548669D4B5BC189B_402284473 = (relResponse.getStatusCode() == 100);
            if (DroidSafeAndroidRuntime.control) throw new SipException("Cannot send 100 as a reliable provisional response");
        } 
        {
            boolean var3F06CAF4D76D1B222835AB0581EBBF2D_607907073 = (relResponse.getStatusCode() / 100 > 2);
            if (DroidSafeAndroidRuntime.control) throw new SipException(
                    "Response code is not a 1xx response - should be in the range 101 to 199 ");
        } 
        {
            boolean var2453F1BE4A002CC1EF6C5E8F78E655A0_1165557148 = (sipResponse.getToTag() == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException(
                    "Badly formatted response -- To tag mandatory for Reliable Provisional Response");
            } 
        } 
        ListIterator requireList = (ListIterator) relResponse.getHeaders(RequireHeader.NAME);
        boolean found = false;
        {
            {
                boolean var3100C156835BFDAEC37B3A0F53F0E27B_1203318766 = (requireList.hasNext() && !found);
                {
                    RequireHeader rh = (RequireHeader) requireList.next();
                    {
                        boolean varDF9A6A091AE7E489D36022F85E7FEEE0_713622425 = (rh.getOptionTag().equalsIgnoreCase("100rel"));
                        {
                            found = true;
                        } 
                    } 
                } 
            } 
        } 
        {
            Require require = new Require("100rel");
            relResponse.addHeader(require);
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1140640345 = (sipStack.isLoggingEnabled());
                {
                    sipStack.getStackLogger().logDebug(
                        "Require header with optionTag 100rel is needed -- adding one");
                } 
            } 
        } 
        SIPServerTransaction serverTransaction = (SIPServerTransaction) this
                .getFirstTransaction();
        this.setLastResponse(serverTransaction, sipResponse);
        this.setDialogId(sipResponse.getDialogId(true));
        serverTransaction.sendReliableProvisionalResponse(relResponse);
        this.startRetransmitTimer(serverTransaction, relResponse);
        addTaint(relResponse.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.425 -0400", hash_original_method = "BF7D1FA3BFA6C180C8021919F244470C", hash_generated_method = "98FB51F17347B278C789B0BBB791F331")
    public void terminateOnBye(boolean terminateFlag) throws SipException {
        this.terminateOnBye = terminateFlag;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.425 -0400", hash_original_method = "97AA8D077ED8B88563B1FCEB7D3F7A03", hash_generated_method = "3989220F20B7D3A9147AB058D826F7D8")
    public void setAssigned() {
        this.isAssigned = true;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.426 -0400", hash_original_method = "F8427D0E95C386EDB403D30E8B4BBEC5", hash_generated_method = "5EB2E10AFF7927D5EF80B811549269C0")
    public boolean isAssigned() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1547103966 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1547103966;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.427 -0400", hash_original_method = "370EA53498504D191CA2C54D6246F992", hash_generated_method = "AB9916A508F33D042E9FA939E33CF73F")
    public Contact getMyContactHeader() {
        Contact varB4EAC82CA7396A68D541C85D26508E83_533384147 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_533384147 = contactHeader;
        varB4EAC82CA7396A68D541C85D26508E83_533384147.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_533384147;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.428 -0400", hash_original_method = "1F7F0E32648D183A0E0322F85F939567", hash_generated_method = "43B927228D590E40DC02FFF00898DB70")
    public boolean handleAck(SIPServerTransaction ackTransaction) {
        SIPRequest sipRequest = ackTransaction.getOriginalRequest();
        {
            boolean varB6606859BF451015E77F1552F52092D0_329259202 = (isAckSeen() && getRemoteSeqNumber() == sipRequest.getCSeq().getSeqNumber());
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1430941187 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logDebug(
                        "ACK already seen by dialog -- dropping Ack" + " retransmission");
                    } 
                } 
                acquireTimerTaskSem();
                try 
                {
                    {
                        this.timerTask.cancel();
                        this.timerTask = null;
                    } 
                } 
                finally 
                {
                    releaseTimerTaskSem();
                } 
            } 
            {
                boolean var4A98AE6585D44012F8F89352F9238253_1896534763 = (this.getState() == DialogState.TERMINATED);
                {
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_751892224 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger().logDebug("Dialog is terminated -- dropping ACK");
                    } 
                } 
                {
                    SIPServerTransaction tr = getInviteTransaction();
                    SIPResponse sipResponse = (tr != null ? tr.getLastResponse() : null);
                    {
                        boolean var161CF50F3C95997F419241A9096FFB37_2022905337 = (tr != null
                    && sipResponse != null
                    && sipResponse.getStatusCode() / 100 == 2
                    && sipResponse.getCSeq().getMethod().equals(Request.INVITE)
                    && sipResponse.getCSeq().getSeqNumber() == sipRequest.getCSeq()
                            .getSeqNumber());
                        {
                            ackTransaction.setDialog(this, sipResponse.getDialogId(false));
                            ackReceived(sipRequest);
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_1831878854 = (sipStack.isLoggingEnabled());
                                sipStack.getStackLogger().logDebug("ACK for 2XX response --- sending to TU ");
                            } 
                        } 
                        {
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_1239939773 = (sipStack.isLoggingEnabled());
                                sipStack.getStackLogger().logDebug(
                            " INVITE transaction not found  -- Discarding ACK");
                            } 
                        } 
                    } 
                } 
            } 
        } 
        addTaint(ackTransaction.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_764424733 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_764424733;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.429 -0400", hash_original_method = "5C164F59F3DF11F779F16A5BAEE8EAC7", hash_generated_method = "F2805544ABD5BF70A703EFAA8BCD0891")
     void setEarlyDialogId(String earlyDialogId) {
        this.earlyDialogId = earlyDialogId;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.432 -0400", hash_original_method = "275E7276434F5D20F41DC92B4F25BAEE", hash_generated_method = "277F042EC856175D07AA698D66657A55")
     String getEarlyDialogId() {
        String varB4EAC82CA7396A68D541C85D26508E83_809379949 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_809379949 = earlyDialogId;
        varB4EAC82CA7396A68D541C85D26508E83_809379949.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_809379949;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.434 -0400", hash_original_method = "5A72AC369AA326C1E4BE607E2D1E31FF", hash_generated_method = "F08C11048AE35F6D706DAF526FE75267")
     void releaseAckSem() {
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_2131527859 = (sipStack.isLoggingEnabled());
                {
                    sipStack.getStackLogger().logDebug("releaseAckSem]" + this);
                } 
            } 
            this.ackSem.release();
        } 
        
        
            
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.435 -0400", hash_original_method = "75493DFA4E25D8A29CC5DF9217BF734F", hash_generated_method = "FF13C000F320C922846B30FCC9C69DCC")
     boolean takeAckSem() {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_477614013 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("[takeAckSem " + this);
            } 
        } 
        try 
        {
            {
                boolean varF77F8A7B1E99FF133CA038DFA9D02F86_2144716692 = (!this.ackSem.tryAcquire(2, TimeUnit.SECONDS));
                {
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1073275214 = (sipStack.isLoggingEnabled());
                        {
                            sipStack.getStackLogger().logError("Cannot aquire ACK semaphore");
                        } 
                    } 
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_643172588 = (sipStack.isLoggingEnabled());
                        {
                            sipStack.getStackLogger().logDebug("Semaphore previously acquired at " + this.stackTrace);
                            sipStack.getStackLogger().logStackTrace();
                        } 
                    } 
                } 
            } 
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1921894431 = (sipStack.isLoggingEnabled());
                {
                    this.recordStackTrace();
                } 
            } 
        } 
        catch (InterruptedException ex)
        {
            sipStack.getStackLogger().logError("Cannot aquire ACK semaphore");
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_164398722 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_164398722;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.437 -0400", hash_original_method = "68D4C33CE448DB45C09F49FC9815E4FD", hash_generated_method = "EAFEA098C1D75D51099230EDA00E4652")
    private void setLastAckReceived(SIPRequest lastAckReceived) {
        this.lastAckReceived = lastAckReceived;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.439 -0400", hash_original_method = "2894D6C9FD5402948626BDE17D2ADDA1", hash_generated_method = "69BB18C02A3DE6D23345F56FBF4C208F")
    protected SIPRequest getLastAckReceived() {
        SIPRequest varB4EAC82CA7396A68D541C85D26508E83_797814166 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_797814166 = lastAckReceived;
        varB4EAC82CA7396A68D541C85D26508E83_797814166.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_797814166;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.439 -0400", hash_original_method = "AE316349F4F2DB7FF5C817D5A1FDA212", hash_generated_method = "A753A427692B7DEB55775EE2604691AF")
    private void setLastAckSent(SIPRequest lastAckSent) {
        this.lastAckSent = lastAckSent;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.440 -0400", hash_original_method = "2B44FD1497547940266A6934DB958355", hash_generated_method = "AE0BCC273C5635BC6352939099FEFB57")
    public boolean isAtleastOneAckSent() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_960568428 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_960568428;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.440 -0400", hash_original_method = "FAA2C5BC01CFE296F7D6D441890115F1", hash_generated_method = "2C50A2A7E9BD8BDD614C75B4BB84A44C")
    public boolean isBackToBackUserAgent() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_625230451 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_625230451;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.441 -0400", hash_original_method = "1ECA22F9D5D81E6992181CD96CD57EA7", hash_generated_method = "1AE943D4F143E4FE1E66519E310B1AEE")
    public synchronized void doDeferredDeleteIfNoAckSent(long seqno) {
        {
            boolean var57BEDF91C3ACD8FDD0380E079BFC759D_1025468906 = (sipStack.getTimer() == null);
            {
                this.setState(TERMINATED_STATE);
            } 
            {
                dialogDeleteIfNoAckSentTask = new DialogDeleteIfNoAckSentTask(seqno);
                sipStack.getTimer().schedule(
					dialogDeleteIfNoAckSentTask,
					SIPTransaction.TIMER_J
							* SIPTransactionStack.BASE_TIMER_INTERVAL);
            } 
        } 
        
        
			
		
			
			
					
					
							
		
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.441 -0400", hash_original_method = "782C3B034CC64F54A5BC7BB8ED6FEDA6", hash_generated_method = "5483C632656F6DE6E777597D7F71485A")
    public void setBackToBackUserAgent() {
        this.isBackToBackUserAgent = true;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.441 -0400", hash_original_method = "3A5B567A7D7C4A4D6D60D4CFA5E677D1", hash_generated_method = "C398B5BD6CE3B0440F841ADB68DD05D4")
     EventHeader getEventHeader() {
        EventHeader varB4EAC82CA7396A68D541C85D26508E83_204131821 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_204131821 = eventHeader;
        varB4EAC82CA7396A68D541C85D26508E83_204131821.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_204131821;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.442 -0400", hash_original_method = "C85F235E26C94FDBCE92FE9C88454CDD", hash_generated_method = "63FC881403C5365782CA2C6D3EBC0C51")
     void setEventHeader(EventHeader eventHeader) {
        this.eventHeader = eventHeader;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.442 -0400", hash_original_method = "D178A1777AB3611D9691A3F4A69F3B06", hash_generated_method = "944F48638C23857FD7322257F37AD5CE")
     void setServerTransactionFlag(boolean serverTransactionFlag) {
        this.serverTransactionFlag = serverTransactionFlag;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.442 -0400", hash_original_method = "B9FC7E5C15DF48754B63587E10ABF39E", hash_generated_method = "6E41B13A7FD0796718F54CCE53804461")
     void setReInviteFlag(boolean reInviteFlag) {
        this.reInviteFlag = reInviteFlag;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.443 -0400", hash_original_method = "554E3D8C2985A7B76F710766F6151401", hash_generated_method = "49C14BEBE2E2E7ACE1A7999B8F3BC962")
    public boolean isSequnceNumberValidation() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1138979734 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1138979734;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.443 -0400", hash_original_method = "07E72D397966AE985C4FA6CA39D288C5", hash_generated_method = "2CA8E42865DEC07CBC74D648985E0DA5")
    public void disableSequenceNumberValidation() {
        this.sequenceNumberValidation = false;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.443 -0400", hash_original_method = "32EDC5DA45A565F7D6F42D86C325067F", hash_generated_method = "E24F73C1DE23761D5A1B530088832E31")
    public void acquireTimerTaskSem() {
        boolean acquired = false;
        try 
        {
            acquired = this.timerTaskLock.tryAcquire(10, TimeUnit.SECONDS);
        } 
        catch (InterruptedException ex)
        {
            acquired = false;
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Impossible to acquire the dialog timer task lock");
        } 
        
        
        
            
        
            
        
        
        	
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.444 -0400", hash_original_method = "7C538F01F8063281F04142649C9B2CD0", hash_generated_method = "3B7BE3389027D7D895A0B9E59CA6FC3E")
    public void releaseTimerTaskSem() {
        this.timerTaskLock.release();
        
        
    }

    
    public class ReInviteSender implements Runnable, Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.444 -0400", hash_original_field = "ECACFFFFC22141F3C1C9CF77DDF0308D", hash_generated_field = "E3567853C7773291F6ADDE73672244A1")

        ClientTransaction ctx;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.444 -0400", hash_original_method = "420F244B37AE2567998EBC3FAC66EFCB", hash_generated_method = "F7A2B4C9B57CD24D4C0C2169969C8DE0")
        public  ReInviteSender(ClientTransaction ctx) {
            this.ctx = ctx;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.445 -0400", hash_original_method = "05496AD165548F09E9869029BA920071", hash_generated_method = "1ADB0BBCC5965FA3A846905A0639F5FF")
        public void terminate() {
            try 
            {
                ctx.terminate();
                Thread.currentThread().interrupt();
            } 
            catch (ObjectInUseException e)
            {
                sipStack.getStackLogger().logError("unexpected error", e);
            } 
            
            
                
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.447 -0400", hash_original_method = "DA8B28F4804F3F25626961946D2074C4", hash_generated_method = "03B70699FA45DCC37BD1333D5200CAA2")
        public void run() {
            try 
            {
                long timeToWait = 0;
                long startTime = System.currentTimeMillis();
                {
                    boolean varCFBA9479F56B2139A22CD810CDC2D9F0_830305790 = (!SIPDialog.this.takeAckSem());
                    {
                        {
                            boolean var2AB968A8303910EE00F810B6DE3410F9_1058831588 = (sipStack.isLoggingEnabled());
                            sipStack.getStackLogger().logError(
                            "Could not send re-INVITE time out ClientTransaction");
                        } 
                        ((SIPClientTransaction) ctx).fireTimeoutTimer();
                        {
                            boolean var4139F5E7958AE9C2F1C82A94207591C8_1794824224 = (sipProvider.getSipListener() != null && sipProvider.getSipListener() instanceof SipListenerExt);
                            {
                                raiseErrorEvent(SIPDialogErrorEvent.DIALOG_REINVITE_TIMEOUT);
                            } 
                            {
                                Request byeRequest = SIPDialog.this.createRequest(Request.BYE);
                                {
                                    boolean varD7581F5DBD86F25779F5137034C43592_1182511650 = (MessageFactoryImpl.getDefaultUserAgentHeader() != null);
                                    {
                                        byeRequest.addHeader(MessageFactoryImpl.getDefaultUserAgentHeader());
                                    } 
                                } 
                                ReasonHeader reasonHeader = new Reason();
                                reasonHeader.setCause(1024);
                                reasonHeader.setText("Timed out waiting to re-INVITE");
                                byeRequest.addHeader(reasonHeader);
                                ClientTransaction byeCtx = SIPDialog.this.getSipProvider().getNewClientTransaction(byeRequest);
                                SIPDialog.this.sendRequest(byeCtx);
                            } 
                        } 
                    } 
                } 
                {
                    boolean var269430BA4810976B135F582C3E3C146F_118157576 = (getState() != DialogState.TERMINATED);
                    {
                        timeToWait = System.currentTimeMillis() - startTime;
                    } 
                } 
                try 
                {
                    {
                        Thread.sleep(SIPDialog.this.reInviteWaitTime);
                    } 
                } 
                catch (InterruptedException ex)
                {
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1888850414 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger().logDebug("Interrupted sleep");
                    } 
                } 
                {
                    boolean var8A4D69DC3EB47276971D5D31F4B6119D_655619086 = (SIPDialog.this.getState() != DialogState.TERMINATED);
                    {
                        SIPDialog.this.sendRequest(ctx, true);
                    } 
                } 
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_580737813 = (sipStack.isLoggingEnabled());
                    sipStack.getStackLogger().logDebug("re-INVITE successfully sent");
                } 
            } 
            catch (Exception ex)
            {
                sipStack.getStackLogger().logError("Error sending re-INVITE", ex);
            } 
            finally 
            {
                this.ctx = null;
            } 
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.447 -0400", hash_original_field = "9E5A19325F636A5E87AC67BC6DE47179", hash_generated_field = "85664C6B81A73D64F3D428B9B5907950")

        private static final long serialVersionUID = 1019346148741070635L;
    }


    
    class LingerTimer extends SIPStackTimerTask implements Serializable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.447 -0400", hash_original_method = "FEDA9229694989A502508E95A3FCFE54", hash_generated_method = "CF6D3A28041C64960D5CFB7948EF46EA")
        public  LingerTimer() {
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.448 -0400", hash_original_method = "CEEC3EAE1C5B12DC43D70E37F1A80A0A", hash_generated_method = "E0D9F209796864C7C064424BA32A7ECA")
        protected void runTask() {
            SIPDialog dialog = SIPDialog.this;
            {
                eventListeners.clear();
            } 
            timerTaskLock = null;
            sipStack.removeDialog(dialog);
            
            
            
            	
            
            
            
        }

        
    }


    
    class DialogTimerTask extends SIPStackTimerTask implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.448 -0400", hash_original_field = "7CB2C68EFA45F05A90FB1DC2EE9998C4", hash_generated_field = "A1A6593A1DD707EE1D2696D147E58630")

        int nRetransmissions;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.448 -0400", hash_original_field = "F4D5B76A2418EBA4BAEABC1ED9142B54", hash_generated_field = "9542A919750E0FF108E7D24E8ABAA715")

        SIPServerTransaction transaction;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.448 -0400", hash_original_method = "99967D6CED868AEC0B4229119C79B2A3", hash_generated_method = "06BD75BECC309B66DC13C9730079A32C")
        public  DialogTimerTask(SIPServerTransaction transaction) {
            this.transaction = transaction;
            this.nRetransmissions = 0;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.449 -0400", hash_original_method = "7353CE022084912970B9E490A7F56F25", hash_generated_method = "858AAFD859AB66CCBEF16810A5F292A7")
        protected void runTask() {
            SIPDialog dialog = SIPDialog.this;
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1566706374 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug("Running dialog timer");
            } 
            SIPServerTransaction transaction = this.transaction;
            {
                {
                    boolean var4B6640D4DE774F6FA49F20C035CC9869_1403375720 = (sipProvider.getSipListener() != null && sipProvider.getSipListener() instanceof SipListenerExt);
                    {
                        raiseErrorEvent(SIPDialogErrorEvent.DIALOG_ACK_NOT_RECEIVED_TIMEOUT);
                    } 
                    {
                        dialog.delete();
                    } 
                } 
                {
                    boolean varB2E591CC8FE73A729A5DB2EFC02188A9_447714437 = (transaction != null
                        && transaction.getState() != javax.sip.TransactionState.TERMINATED);
                    {
                        transaction.raiseErrorEvent(SIPTransactionErrorEvent.TIMEOUT_ERROR);
                    } 
                } 
            } 
            {
                SIPResponse response = transaction.getLastResponse();
                {
                    boolean varEB9E7BA125F929A2C756DC8C1AAE09C1_2011420953 = (response.getStatusCode() == 200);
                    {
                        try 
                        {
                            {
                                boolean varC839103C0955C82229EFCA85F8C206DB_402350146 = (dialog.toRetransmitFinalResponse(transaction.T2));
                                transaction.sendMessage(response);
                            } 
                        } 
                        catch (IOException ex)
                        {
                            raiseIOException(transaction.getPeerAddress(), transaction.getPeerPort(),
                                transaction.getPeerProtocol());
                        } 
                        finally 
                        {
                            SIPTransactionStack stack = dialog.sipStack;
                            {
                                boolean var7E956449752FC9BA92CD92F85600E671_481177926 = (stack.isLoggingEnabled());
                                {
                                    stack.getStackLogger().logDebug("resend 200 response from " + dialog);
                                } 
                            } 
                            transaction.fireTimer();
                        } 
                    } 
                } 
            } 
            {
                boolean var4EA6B06F6CBCD1FD755A7849352DDFB9_571623357 = (dialog.isAckSeen() || dialog.dialogState == TERMINATED_STATE);
                {
                    this.transaction = null;
                    this.cancel();
                } 
            } 
            
            
        }

        
    }


    
    class DialogDeleteTask extends SIPStackTimerTask implements Serializable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.449 -0400", hash_original_method = "51B842BDCF98DBC480B551988FA04041", hash_generated_method = "51B842BDCF98DBC480B551988FA04041")
        public DialogDeleteTask ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.450 -0400", hash_original_method = "705C6BB4461CC5F37E0565BB6F16C084", hash_generated_method = "12743D2452C0A21B643AFBC46E200A26")
        protected void runTask() {
            delete();
            
            
        }

        
    }


    
    class DialogDeleteIfNoAckSentTask extends SIPStackTimerTask implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.450 -0400", hash_original_field = "D8D8C9E3082C9D3CC78D718B0D250891", hash_generated_field = "979FF677F2C7A64909253E0B01090AEC")

        private long seqno;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.450 -0400", hash_original_method = "D6D7FB77E2882EBB362E9FAF3BE7D45E", hash_generated_method = "A0EA5F4F4663FCA6881081121335338B")
        public  DialogDeleteIfNoAckSentTask(long seqno) {
            this.seqno = seqno;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.451 -0400", hash_original_method = "47EF190411AC9DCEBDEAD83DF8BB27D9", hash_generated_method = "B57EA781CB7351D49C4D568963F1BB61")
        protected void runTask() {
            {
                boolean var39396AEF52D6456D6CD60D28DE63583D_982139308 = (SIPDialog.this.highestSequenceNumberAcknowledged < seqno);
                {
                    dialogDeleteIfNoAckSentTask = null;
                    {
                        boolean var2DCCFE4A22572D9F02A458128FB13A98_927484755 = (!SIPDialog.this.isBackToBackUserAgent);
                        {
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_392986695 = (sipStack.isLoggingEnabled());
                                sipStack.getStackLogger().logError("ACK Was not sent. killing dialog");
                            } 
                            {
                                boolean varB740E386243B854D0A28C1291599B3CA_2109037676 = (((SipProviderImpl)sipProvider).getSipListener() instanceof SipListenerExt);
                                {
                                    raiseErrorEvent(SIPDialogErrorEvent.DIALOG_ACK_NOT_SENT_TIMEOUT);
                                } 
                                {
                                    delete();
                                } 
                            } 
                        } 
                        {
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_224003429 = (sipStack.isLoggingEnabled());
                                sipStack.getStackLogger().logError("ACK Was not sent. Sending BYE");
                            } 
                            {
                                boolean varB740E386243B854D0A28C1291599B3CA_2062186544 = (((SipProviderImpl)sipProvider).getSipListener() instanceof SipListenerExt);
                                {
                                    raiseErrorEvent(SIPDialogErrorEvent.DIALOG_ACK_NOT_SENT_TIMEOUT);
                                } 
                                {
                                    try 
                                    {
                                        Request byeRequest = SIPDialog.this.createRequest(Request.BYE);
                                        {
                                            boolean var53F281250CFE3DAFB9B635A8C29C3932_866489873 = (MessageFactoryImpl.getDefaultUserAgentHeader() != null);
                                            {
                                                byeRequest.addHeader(MessageFactoryImpl.getDefaultUserAgentHeader());
                                            } 
                                        } 
                                        ReasonHeader reasonHeader = new Reason();
                                        reasonHeader.setProtocol("SIP");
                                        reasonHeader.setCause(1025);
                                        reasonHeader.setText("Timed out waiting to send ACK");
                                        byeRequest.addHeader(reasonHeader);
                                        ClientTransaction byeCtx = SIPDialog.this.getSipProvider().getNewClientTransaction(byeRequest);
                                        SIPDialog.this.sendRequest(byeCtx);
                                    } 
                                    catch (Exception ex)
                                    {
                                        SIPDialog.this.delete();
                                    } 
                                } 
                            } 
                        } 
                    } 
                } 
            } 
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.451 -0400", hash_original_field = "D26B2D15C6314569F32E9D2F4BD6FEAC", hash_generated_field = "010392E015C0F4F4EE6412AC38CADE79")

    private static final long serialVersionUID = -1429794423085204069L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.451 -0400", hash_original_field = "8917280F88F70A0C2AB25626046570AB", hash_generated_field = "0217060B0F6ACCA57DEF89D56528802E")

    public final static int NULL_STATE = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.451 -0400", hash_original_field = "AA9ACD2C29B35BE3CC1FCA5452E94A3C", hash_generated_field = "7E4774629A80511A1605FBB2145C202F")

    public final static int EARLY_STATE = DialogState._EARLY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.451 -0400", hash_original_field = "6325A488137EC86B847AA6592A566C0C", hash_generated_field = "45C6B699CF332D7B77B3EB2AD8AB7301")

    public final static int CONFIRMED_STATE = DialogState._CONFIRMED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.451 -0400", hash_original_field = "0457F6F92501361FF9C1B20BAB2C93E7", hash_generated_field = "80C37090AC7335F51D7D9FB4E1EC85B9")

    public final static int TERMINATED_STATE = DialogState._TERMINATED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:45.451 -0400", hash_original_field = "A7FCE49E97B902F5858568493877FAB6", hash_generated_field = "40DFB0E7AF36C25D0E66FE67C01F2E05")

    private static final int DIALOG_LINGER_TIME = 8;
}

