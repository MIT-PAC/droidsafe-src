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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.901 -0400", hash_original_field = "46C9B2C3A305D009DCA963EA55E53037", hash_generated_field = "8B7AA916EC7A88984DDF8AA52B9F1641")

    private transient boolean dialogTerminatedEventDelivered;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.901 -0400", hash_original_field = "FCD4E36FD80F450979495718DBDDAACF", hash_generated_field = "9F3F9DDDB302CE97F2E415A10FABBE2D")

    private transient String stackTrace;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.901 -0400", hash_original_field = "EA9F6ACA279138C58F705C8D4CB4B8CE", hash_generated_field = "F42F15CDE806BBAD7F26F7952D68FCE2")

    private String method;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.901 -0400", hash_original_field = "C26F5EFAA245E97571F6FC4B23DECC91", hash_generated_field = "386AD1FFF2E8BC21894EEC2B1DC5720D")

    private transient boolean isAssigned;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.901 -0400", hash_original_field = "C1EC3EDE33FAFFDB511452F99E001022", hash_generated_field = "E1B54A10C305CE35C160FA0FCCD06B96")

    private boolean reInviteFlag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.901 -0400", hash_original_field = "756C73A51ADF7F04942C8BE97A032000", hash_generated_field = "0C346A02ABD6566D7A046D5EE80C0EC0")

    private transient Object applicationData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.901 -0400", hash_original_field = "539F42CD378873BB0F9889EFF317BAFA", hash_generated_field = "AD3FCBD371406352A3E03A00BDAA3D18")

    private transient SIPRequest originalRequest;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.901 -0400", hash_original_field = "9ECD142FA67835EFBFD693D2B0EFC756", hash_generated_field = "7328CD7146ABA98BB701BDA934CF1486")

    private SIPResponse lastResponse;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.901 -0400", hash_original_field = "365BA234CE4103A64B291C10F57087FD", hash_generated_field = "4C8E3F2978B0A1967941B34B8E931926")

    private transient SIPTransaction firstTransaction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.901 -0400", hash_original_field = "EBB750D5E2AC0A12C597F9247097FE3A", hash_generated_field = "8E3DDDE2C9BBCFF0518502DA3A19B8FC")

    private transient SIPTransaction lastTransaction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.901 -0400", hash_original_field = "2EF3DE78A30BAAA37A078E077DA9C8FF", hash_generated_field = "FFD5ABB57CC8068DFE83871CA8391D63")

    private String dialogId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.901 -0400", hash_original_field = "5E278DBB57181A78536887523BDDB000", hash_generated_field = "047D72F6110028ED8614A185C3ADEE63")

    private transient String earlyDialogId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.901 -0400", hash_original_field = "DE3A634B25A226C9FC28CC0EA41F9212", hash_generated_field = "AD815FC4C870FA38840533B56E201007")

    private long localSequenceNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.901 -0400", hash_original_field = "45DD21C3FA9B2834579DDEBCBA7FDE5E", hash_generated_field = "096C078B93EFB214E2172D793F365B4D")

    private long remoteSequenceNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.901 -0400", hash_original_field = "163C6D86A43D258EE0FE3B5AC19EEB9B", hash_generated_field = "DE4FDB012317C10FCB5EE3D6596519E1")

    protected String myTag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.901 -0400", hash_original_field = "02FAD193B4B3A63F0DF3A1373D82A243", hash_generated_field = "9777EBD405E9D84F5A9D8688CA87BB34")

    protected String hisTag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.901 -0400", hash_original_field = "C433183F160826EE91E980CE55DF6B8A", hash_generated_field = "873E71D84A907B69A5D7EA40A6E98B84")

    private RouteList routeList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.901 -0400", hash_original_field = "37460D4BF2BA47A13FF9D922C4B14B2E", hash_generated_field = "648E45DA0C2D4CA0D3A6C1331273D1A8")

    private transient SIPTransactionStack sipStack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.901 -0400", hash_original_field = "9E815F1ED84873B978ADE70D5015D491", hash_generated_field = "B18AB1AD22CF960F8E3DA659D957473C")

    private int dialogState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.901 -0400", hash_original_field = "D8F45A8AC837F51166792988E4141B52", hash_generated_field = "92F226B9C77FEEDF00455BB4E4B37995")

    protected transient boolean ackSeen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.901 -0400", hash_original_field = "1653CA35CDAF1FD8B835AAB2A0098372", hash_generated_field = "5047CDCA90F6F4D08E6FCFC3504AA33A")

    private transient SIPRequest lastAckSent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.902 -0400", hash_original_field = "A2E2C0BC96483014E68E14BCA2B6829F", hash_generated_field = "0D41AA5710D910AD875D10253E3B5B7B")

    private SIPRequest lastAckReceived;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.902 -0400", hash_original_field = "5A47CDCCD7DADCBE8339DE02999F79D7", hash_generated_field = "39BFE22C217FFF2E6FD7425093780B7F")

    protected transient boolean ackProcessed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.902 -0400", hash_original_field = "804894B79B603C8794570D901AF093D4", hash_generated_field = "CCB890E772BC08D4A4B71682A75E6B57")

    protected transient DialogTimerTask timerTask;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.902 -0400", hash_original_field = "2B1914B1BDB94B6490A6024E69C1AC63", hash_generated_field = "50CA1F3CDF0B9F341970FE5A2E9968CD")

    protected transient Long nextSeqno;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.902 -0400", hash_original_field = "6D988A8035AD569D3835C3FB2E8FADD9", hash_generated_field = "357D95D41FE555F3403B8186135E948D")

    private transient int retransmissionTicksLeft;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.902 -0400", hash_original_field = "6B0B182F82159791030FD4DDF77C7D67", hash_generated_field = "FDB9FFD63AE6B4740136DBB4E840047D")

    private transient int prevRetransmissionTicks;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.902 -0400", hash_original_field = "3A3D450D6468D05390761FD1EEA48070", hash_generated_field = "AB98AAAC4EF13468E54DBE8642C5759B")

    private long originalLocalSequenceNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.902 -0400", hash_original_field = "284CCB26986C244746913731F851D61A", hash_generated_field = "D019361A8619CB9E208CC4A408868CF5")

    private transient int ackLine;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.902 -0400", hash_original_field = "C0CEB3515CA4F46A6B2A58F9563A8976", hash_generated_field = "B8AD8E741E80B25C3AEBA11833850788")

    public transient long auditTag = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.902 -0400", hash_original_field = "0491B7ABE5A57CDF01C5AF04205714CD", hash_generated_field = "5581935F145F3F50A0FF3B163F12E527")

    protected javax.sip.address.Address localParty;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.902 -0400", hash_original_field = "962BC95BC1290FCAFA045995FAE5F1E0", hash_generated_field = "039B4B6D9758816DF54E227BDD9B553B")

    protected javax.sip.address.Address remoteParty;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.902 -0400", hash_original_field = "F4E470CD8970EBBE1902E50EB09F4952", hash_generated_field = "4FB7DFE93D6674CE9A4D6470DED9D170")

    protected CallIdHeader callIdHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.902 -0400", hash_original_field = "EB27C9A1ABE6F92065F9871F11CA94DE", hash_generated_field = "66E18B86E8394598F2C548C54E34F3D8")

    private boolean serverTransactionFlag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.902 -0400", hash_original_field = "2D3F8ACEA2D147F7A52D2FA493D756C8", hash_generated_field = "58BDE3AD74EC5F605B651AEC94A1C475")

    private transient SipProviderImpl sipProvider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.902 -0400", hash_original_field = "E07EB9E73AEC54F4C343517C6319D798", hash_generated_field = "369DECFD4E296468A8EE9210A060D65B")

    private boolean terminateOnBye;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.902 -0400", hash_original_field = "354622A0C5E162C6CC6CA2314CF692C2", hash_generated_field = "024E9E66DF22C3B5E5731FC6B0083C1A")

    private transient boolean byeSent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.902 -0400", hash_original_field = "F56AF138C945E77D60FC1E857CA6ED3C", hash_generated_field = "4BFEF67A8970CE1B7ED7E72620C9AC81")

    private Address remoteTarget;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.902 -0400", hash_original_field = "F9D912BE83AE47070E860DEC06FB1BA4", hash_generated_field = "7F1ED863122BA67FB6B399180FFB61EF")

    private EventHeader eventHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.902 -0400", hash_original_field = "273FF71B50533FE65671ACDD370D0775", hash_generated_field = "25A404EC1778A9AB18E3073CD79DC005")

    private transient long lastInviteOkReceived;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.902 -0400", hash_original_field = "DA26F565CCA8C9BCABA1D6F51AA3DDB6", hash_generated_field = "043CF414B4BC114C321725D26030C925")

    private transient Semaphore ackSem = new Semaphore(1);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.902 -0400", hash_original_field = "4312EB0CC756247EAA1930550BE95F97", hash_generated_field = "8391C3AA408B5C65CA6D2DAD521FC0C6")

    private transient int reInviteWaitTime = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.902 -0400", hash_original_field = "CBA28B6F9931EA2E13D9820A8FD464DA", hash_generated_field = "671578F07EF254B77AC2D4173CF99A1A")

    private transient DialogDeleteTask dialogDeleteTask;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.902 -0400", hash_original_field = "F542E4E71711723917E3E6AE16CD8970", hash_generated_field = "B9EBB973A8692BA4C974F82BA5B997F3")

    private transient DialogDeleteIfNoAckSentTask dialogDeleteIfNoAckSentTask;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.902 -0400", hash_original_field = "26CDE53F2A363B6F09C65A5A1BE09D8A", hash_generated_field = "173A1FD238D8569297A5D30A0D2122DA")

    private transient boolean isAcknowledged;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.902 -0400", hash_original_field = "509F1D12B600B3138E1CB091EBE04C72", hash_generated_field = "19F7BD09CC9EC40661F8FE53075718B2")

    private transient long highestSequenceNumberAcknowledged = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.902 -0400", hash_original_field = "ED5DD7E8859F4FCE1BBEB3296A028766", hash_generated_field = "DA4CDB35B5056C6CA182EC98C7A0FE9B")

    private boolean isBackToBackUserAgent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.903 -0400", hash_original_field = "2B05FA302BB63D8136037DD4E39122BF", hash_generated_field = "7EEEE754C8F2FA7215F638E76C8E67E0")

    private boolean sequenceNumberValidation = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.903 -0400", hash_original_field = "FEAAE72958B4E88882F57D0164DCA2A6", hash_generated_field = "CFB0D25D7A9D3DB327E35494FC7DE9A5")

    private transient Set<SIPDialogEventListener> eventListeners;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.903 -0400", hash_original_field = "3570D6B9904467D944595544DFEA8443", hash_generated_field = "B1245AF2B94FAB1223B77DABE0E26551")

    private Semaphore timerTaskLock = new Semaphore(1);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.904 -0400", hash_original_field = "A3801CFC0CC0C9EDADB7035D96B0A52C", hash_generated_field = "D54EF62A05D422BDCA347E77C025891C")

    protected boolean firstTransactionSecure;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.904 -0400", hash_original_field = "F9F9F947ADC5F8FCF0FFE2A87E08ED9F", hash_generated_field = "68EC519F0D2EE4EB55E96608058AA384")

    protected boolean firstTransactionSeen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.904 -0400", hash_original_field = "383303C37A6BD00E4C256C602333D72B", hash_generated_field = "4D111E3CF541CDB9CD69CDF93FCEDDAC")

    protected String firstTransactionMethod;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.904 -0400", hash_original_field = "8717DD98BC5859570A4684454287E374", hash_generated_field = "DFB6058EA76D5E106C80BCA9A74A2D53")

    protected String firstTransactionId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.904 -0400", hash_original_field = "0D53979373F479A7EFA6875647AB0B78", hash_generated_field = "39C149EC307ADB72278A474A328A3BCF")

    protected boolean firstTransactionIsServerTransaction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.904 -0400", hash_original_field = "9B3271522A9E60737CFB8772E1C4861B", hash_generated_field = "801C0A281C881455A3F35F92B0224337")

    protected int firstTransactionPort = 5060;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.904 -0400", hash_original_field = "65E9D0A6D689FFB91F5650FC4788A4B6", hash_generated_field = "4CA7FF5DA34408C08E9FC1CA2863A04F")

    protected Contact contactHeader;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.919 -0400", hash_original_method = "B89E344ABA0B0C4EAAF339C3C960DE0F", hash_generated_method = "685613B365B139F14EC760382B8F90A2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.921 -0400", hash_original_method = "BE0EB8A93E786CF5997E41E028500B95", hash_generated_method = "3CED3B744227CEDC49C18BEB10F3817B")
    public  SIPDialog(SIPTransaction transaction) {
        this(transaction.getSipProvider());
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
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_301460168 = (sipStack.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.922 -0400", hash_original_method = "0305A0224D6BCDD571D54C883A13EEA2", hash_generated_method = "664CB15766C650FC565EE9A84035711E")
    public  SIPDialog(SIPClientTransaction transaction, SIPResponse sipResponse) {
        this(transaction);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Null SipResponse");
        this.setLastResponse(transaction, sipResponse);
        this.isBackToBackUserAgent = sipStack.isBackToBackUserAgent;
        addTaint(transaction.getTaint());
        addTaint(sipResponse.getTaint());
        // ---------- Original Method ----------
        //if (sipResponse == null)
            //throw new NullPointerException("Null SipResponse");
        //this.setLastResponse(transaction, sipResponse);
        //this.isBackToBackUserAgent = sipStack.isBackToBackUserAgent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.926 -0400", hash_original_method = "95FF401EAA7EE3F3C9E78290081B0530", hash_generated_method = "7B1A4CC5FE0D9FAEC2DCA896B3E838AC")
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
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1096094551 = (sipStack.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.927 -0400", hash_original_method = "9EE497100AA17813744E66E4A05B8669", hash_generated_method = "D6A70551A4C29DD8FEF6C4898914BDCD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.940 -0400", hash_original_method = "40815EC709415499328FA1CBE062ACB5", hash_generated_method = "BABC225E36DA90EFD11012BAF5A2AA55")
    private void printRouteList() {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1105283705 = (sipStack.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.941 -0400", hash_original_method = "6746D685A6EEFE6F86FE53A5B90B58CB", hash_generated_method = "C5760D9E1E547B20632ACA6F64B00BAE")
    private boolean isClientDialog() {
        SIPTransaction transaction;
        transaction = (SIPTransaction) this.getFirstTransaction();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_740621460 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_740621460;
        // ---------- Original Method ----------
        //SIPTransaction transaction = (SIPTransaction) this.getFirstTransaction();
        //return transaction instanceof SIPClientTransaction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.941 -0400", hash_original_method = "871D6D7CB1794492ED7691CB8C5B804E", hash_generated_method = "B63E395CFA256E94606BCB0E2EBDA359")
    private void raiseIOException(String host, int port, String protocol) {
        IOExceptionEvent ioError;
        ioError = new IOExceptionEvent(this, host, port, protocol);
        sipProvider.handleEvent(ioError, null);
        setState(SIPDialog.TERMINATED_STATE);
        addTaint(host.getTaint());
        addTaint(port);
        addTaint(protocol.getTaint());
        // ---------- Original Method ----------
        //IOExceptionEvent ioError = new IOExceptionEvent(this, host, port, protocol);
        //sipProvider.handleEvent(ioError, null);
        //setState(SIPDialog.TERMINATED_STATE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.942 -0400", hash_original_method = "352742C76D82997D1FD2B39635FE380F", hash_generated_method = "0D62B907AE32F788D35E4FC6247012B1")
    private void raiseErrorEvent(int dialogTimeoutError) {
        SIPDialogErrorEvent newErrorEvent;
        Iterator<SIPDialogEventListener> listenerIterator;
        SIPDialogEventListener nextListener;
        newErrorEvent = new SIPDialogErrorEvent(this, dialogTimeoutError);
        {
            listenerIterator = eventListeners.iterator();
            {
                boolean var20BE331F515CCC1CE643C3890EEC5ABE_1145076547 = (listenerIterator.hasNext());
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
        addTaint(dialogTimeoutError);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.943 -0400", hash_original_method = "E7371746614A4FB0A7068DCC784728D1", hash_generated_method = "7D9404AAD4AD32FE71EBAD51C7B9F687")
    private void setRemoteParty(SIPMessage sipMessage) {
        {
            boolean varBEE554E6D1FF8C71A0674E385CDC8906_754823129 = (!isServer());
            {
                this.remoteParty = sipMessage.getTo().getAddress();
            } //End block
            {
                this.remoteParty = sipMessage.getFrom().getAddress();
            } //End block
        } //End collapsed parenthetic
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1915266548 = (sipStack.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.944 -0400", hash_original_method = "07989C3909E96A7576DAE0D29DD189A0", hash_generated_method = "0BBF6F7434949642A9FA6FDC3073A947")
    private void addRoute(RecordRouteList recordRouteList) {
        try 
        {
            {
                boolean var07F5CF3AF0948BEF1A9D3AFE53F3C41D_65135593 = (this.isClientDialog());
                {
                    this.routeList = new RouteList();
                    ListIterator li;
                    li = recordRouteList.listIterator(recordRouteList.size());
                    boolean addRoute;
                    addRoute = true;
                    {
                        boolean var78DAF18E56E0E0C5C70FC6AF496E0718_868220148 = (li.hasPrevious());
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
                        boolean var3B4C388F9F77D89F36DAE45711DE06F7_1292527929 = (li.hasNext());
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
                boolean var0C9E46B9F84667219FF0963258285136_1155512580 = (sipStack.getStackLogger().isLoggingEnabled());
                {
                    Iterator it;
                    it = routeList.iterator();
                    {
                        boolean var4CA2EDBF7D27138D75E73CCD01CCB025_391050980 = (it.hasNext());
                        {
                            SipURI sipUri;
                            sipUri = (SipURI) (((Route) it.next()).getAddress().getURI());
                            {
                                boolean var1BE9C376C47A3B2A0E7DB2070A5A5EEB_1593523093 = (!sipUri.hasLrParam());
                                {
                                    {
                                        boolean var6FE8ACC5352DCA3449210F8EDED912B3_65401433 = (sipStack.isLoggingEnabled());
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
        addTaint(recordRouteList.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.944 -0400", hash_original_method = "0B8DEDA7075751956ABB1ACBE337F637", hash_generated_method = "04637AB9EC2FEAAEC637D2C395F55854")
     void setRemoteTarget(ContactHeader contact) {
        this.remoteTarget = contact.getAddress();
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_59151018 = (sipStack.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.958 -0400", hash_original_method = "32344AE5A14991821D94A9D2D9260949", hash_generated_method = "8FFCB717EFBA109CB69FCEDB537D1AE2")
    private synchronized void addRoute(SIPResponse sipResponse) {
        try 
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1210448224 = (sipStack.isLoggingEnabled());
                {
                    sipStack.getStackLogger().logDebug(
                        "setContact: dialogState: " + this + "state = " + this.getState());
                } //End block
            } //End collapsed parenthetic
            {
                boolean var8E5EA495FB3AB2BDCCF944451D5CAD5E_1325301666 = (sipResponse.getStatusCode() == 100);
                {
                    {
                        boolean varD22FA4E0B94F71DD4671FD4FC55EBC7F_1166555576 = (sipResponse.getStatusCode() / 100 == 2 && !this.isServer());
                        {
                            ContactList contactList;
                            contactList = sipResponse.getContactHeaders();
                            {
                                boolean varBC2CD47900C4F82FA80016EBC4DC14B4_1983766838 = (contactList != null
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
                boolean varA6A85DA8A9FDA48A0ADE5BD360D7C1FE_729972542 = (!isServer());
                {
                    {
                        boolean var2698EF62FF779E804A95F9CA198FE43F_522809463 = (this.getState() != DialogState.CONFIRMED
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
                boolean varCD7A6467843458627CC99D2CD95A9CA6_543014170 = (sipStack.isLoggingEnabled());
                {
                    sipStack.getStackLogger().logStackTrace();
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(sipResponse.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.959 -0400", hash_original_method = "EDCC5E2E639B8E515D6889EB4E225297", hash_generated_method = "B17DAAFC93B8DFCC2450530DAF2BA6FF")
    private synchronized RouteList getRouteList() {
        RouteList varB4EAC82CA7396A68D541C85D26508E83_1530796819 = null; //Variable for return #1
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1591319760 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug("getRouteList " + this);
        } //End collapsed parenthetic
        ListIterator li;
        RouteList retval;
        retval = new RouteList();
        retval = new RouteList();
        {
            li = routeList.listIterator();
            {
                boolean varD1722E42EA3CA8952F93B6521D875E61_1412108534 = (li.hasNext());
                {
                    Route route;
                    route = (Route) li.next();
                    retval.add((Route) route.clone());
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_2094722855 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("----- ");
                sipStack.getStackLogger().logDebug("getRouteList for " + this);
                sipStack.getStackLogger().logDebug("RouteList = " + retval.encode());
                sipStack.getStackLogger().logDebug("myRouteList = " + routeList.encode());
                sipStack.getStackLogger().logDebug("----- ");
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1530796819 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1530796819.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1530796819;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.971 -0400", hash_original_method = "7EC927C7EF5071E2849378214CAB8686", hash_generated_method = "BCC8ED1A5E46655051AE536081FB079D")
     void setRouteList(RouteList routeList) {
        this.routeList = routeList;
        // ---------- Original Method ----------
        //this.routeList = routeList;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.973 -0400", hash_original_method = "EE053BB78DA7F62675E98D1AF5A5B915", hash_generated_method = "3D46BCD2D3BA4FBC20BE04C2CC61D035")
    private void sendAck(Request request, boolean throwIOExceptionAsSipException) throws SipException {
        SIPRequest ackRequest;
        ackRequest = (SIPRequest) request;
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1066292948 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug("sendAck" + this);
        } //End collapsed parenthetic
        {
            boolean var83038655241FA8664F712343761B6FDA_2110796927 = (!ackRequest.getMethod().equals(Request.ACK));
            if (DroidSafeAndroidRuntime.control) throw new SipException("Bad request method -- should be ACK");
        } //End collapsed parenthetic
        {
            boolean var8D79CFF02C4C85D8676092EC202DE2DE_131743161 = (this.getState() == null || this.getState().getValue() == EARLY_STATE);
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_265893411 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logError(
                        "Bad Dialog State for " + this + " dialogID = " + this.getDialogId());
                    } //End block
                } //End collapsed parenthetic
                if (DroidSafeAndroidRuntime.control) throw new SipException("Bad dialog state " + this.getState());
            } //End block
        } //End collapsed parenthetic
        {
            boolean var3C70B6348A8CD040C6F768F885F8BDFD_842457092 = (!this.getCallId().getCallId().equals(((SIPRequest) request).getCallId().getCallId()));
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_539660177 = (sipStack.isLoggingEnabled());
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
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1766182514 = (sipStack.isLoggingEnabled());
                {
                    sipStack.getStackLogger().logDebug(
                        "setting from tag For outgoing ACK= " + this.getLocalTag());
                    sipStack.getStackLogger().logDebug(
                        "setting To tag for outgoing ACK = " + this.getRemoteTag());
                    sipStack.getStackLogger().logDebug("ack = " + ackRequest);
                } //End block
            } //End collapsed parenthetic
            {
                boolean var8960EF1666EE0A76790F8BA2DB88F003_1179570324 = (this.getLocalTag() != null);
                ackRequest.getFrom().setTag(this.getLocalTag());
            } //End collapsed parenthetic
            {
                boolean var2C6389CD64DE33F7E280071219A47D88_748902252 = (this.getRemoteTag() != null);
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
                boolean varCD7A6467843458627CC99D2CD95A9CA6_408255026 = (sipStack.isLoggingEnabled());
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
                boolean var407F621DCBF6FFA27177104AE6265862_1451392642 = (!this.isAckSent(cseqNo));
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
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_559818308 = (sipStack.isLoggingEnabled());
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
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1279411108 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logException(ex);
            } //End collapsed parenthetic
            if (DroidSafeAndroidRuntime.control) throw ex;
        } //End block
        catch (Exception ex)
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_743393212 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logException(ex);
            } //End collapsed parenthetic
            if (DroidSafeAndroidRuntime.control) throw new SipException("Could not create message channel", ex);
        } //End block
        {
            this.dialogDeleteTask.cancel();
            this.dialogDeleteTask = null;
        } //End block
        this.ackSeen = true;
        addTaint(request.getTaint());
        addTaint(throwIOExceptionAsSipException);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.974 -0400", hash_original_method = "0D216F13B34A5D6836A5B8174F7E5D5B", hash_generated_method = "833699EAF4926A44BA91EB1BE4A6B643")
     void setStack(SIPTransactionStack sipStack) {
        this.sipStack = sipStack;
        // ---------- Original Method ----------
        //this.sipStack = sipStack;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.987 -0400", hash_original_method = "4B5A71F52939D771152A6C733BB7B273", hash_generated_method = "41827272E0A0444632ABA955D0BA8AA1")
     SIPTransactionStack getStack() {
        SIPTransactionStack varB4EAC82CA7396A68D541C85D26508E83_838206310 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_838206310 = sipStack;
        varB4EAC82CA7396A68D541C85D26508E83_838206310.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_838206310;
        // ---------- Original Method ----------
        //return sipStack;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.987 -0400", hash_original_method = "82BA8A08B2E8140159AB0D3D207AD49D", hash_generated_method = "493029816330C6ADDA1C24DEE2AED107")
     boolean isTerminatedOnBye() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_752904566 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_752904566;
        // ---------- Original Method ----------
        //return this.terminateOnBye;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.988 -0400", hash_original_method = "45B7AAA172C2FB7B4FDF9001755F4630", hash_generated_method = "4BB21F3B143F3EE53E6F5C41F5D8141D")
     void ackReceived(SIPRequest sipRequest) {
        SIPServerTransaction tr;
        tr = this.getInviteTransaction();
        {
            {
                boolean varB6355663626C1162BA1A68F49F05AEF5_1636181933 = (tr.getCSeq() == sipRequest.getCSeq().getSeqNumber());
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
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_908875008 = (sipStack.isLoggingEnabled());
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
        addTaint(sipRequest.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.989 -0400", hash_original_method = "76BE8FDE36BAF0086F9828D261C3B7B9", hash_generated_method = "065E1772027DDF0F2B62372B75298733")
    synchronized boolean testAndSetIsDialogTerminatedEventDelivered() {
        boolean retval;
        retval = this.dialogTerminatedEventDelivered;
        this.dialogTerminatedEventDelivered = true;
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_786087495 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_786087495;
        // ---------- Original Method ----------
        //boolean retval = this.dialogTerminatedEventDelivered;
        //this.dialogTerminatedEventDelivered = true;
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.989 -0400", hash_original_method = "6AC129F323D8E39FC544B245C2D3A08C", hash_generated_method = "DEE6DF0D485C15E3BAC1FDCEECB3E5D6")
    public void addEventListener(SIPDialogEventListener newListener) {
        eventListeners.add(newListener);
        addTaint(newListener.getTaint());
        // ---------- Original Method ----------
        //eventListeners.add(newListener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.990 -0400", hash_original_method = "7D9E11919812D827506D2E4A9106FF10", hash_generated_method = "4883BF1C58DAF47B17E44080CD78F7C2")
    public void removeEventListener(SIPDialogEventListener oldListener) {
        eventListeners.remove(oldListener);
        addTaint(oldListener.getTaint());
        // ---------- Original Method ----------
        //eventListeners.remove(oldListener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.990 -0400", hash_original_method = "552E0456C33D24CD63C8EBCDAC1D019B", hash_generated_method = "E17DD994BC845C3BDBBD70ECC432242E")
    public void setApplicationData(Object applicationData) {
        this.applicationData = applicationData;
        // ---------- Original Method ----------
        //this.applicationData = applicationData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.990 -0400", hash_original_method = "5F924FC61375970A4DC758380BEBFF0F", hash_generated_method = "555D8918CC1AFA2808636B9F1AB217FB")
    public Object getApplicationData() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1785058394 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1785058394 = this.applicationData;
        varB4EAC82CA7396A68D541C85D26508E83_1785058394.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1785058394;
        // ---------- Original Method ----------
        //return this.applicationData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.002 -0400", hash_original_method = "CB5AF71091E3878E29C27274F2628D83", hash_generated_method = "F1172F92305080B50D84962B10D128D7")
    public synchronized void requestConsumed() {
        this.nextSeqno = Long.valueOf(this.getRemoteSeqNumber() + 1);
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_2120840241 = (sipStack.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.003 -0400", hash_original_method = "1E1A6C22D1982081DC74374A2FF63AAD", hash_generated_method = "C62A0FBE20D2532273A860C71CE40F02")
    public synchronized boolean isRequestConsumable(SIPRequest dialogRequest) {
        {
            boolean var6F478D97F2432A825F39F929C2C7D5F9_170440172 = (dialogRequest.getMethod().equals(Request.ACK));
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Illegal method");
        } //End collapsed parenthetic
        {
            boolean var1B071101B9F8EF253DCB47268A096682_1248234775 = (!this.isSequnceNumberValidation());
        } //End collapsed parenthetic
        boolean var5D47603BA0731A48F49B6853603D82AF_330789588 = (remoteSequenceNumber < dialogRequest.getCSeq().getSeqNumber());
        addTaint(dialogRequest.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_50042843 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_50042843;
        // ---------- Original Method ----------
        //if (dialogRequest.getMethod().equals(Request.ACK))
            //throw new RuntimeException("Illegal method");
        //if (!this.isSequnceNumberValidation()) {
            //return true;
        //}
        //return remoteSequenceNumber < dialogRequest.getCSeq().getSeqNumber();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.004 -0400", hash_original_method = "45E0951257A8FCCA68182E75CB3B0E3E", hash_generated_method = "CBF15A8F9B42867AF519256940436073")
    public void doDeferredDelete() {
        {
            boolean var57BEDF91C3ACD8FDD0380E079BFC759D_779423615 = (sipStack.getTimer() == null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.005 -0400", hash_original_method = "DBF870542E6B78326B5509C5A5BAD885", hash_generated_method = "4110F215B6AA321823F45DA11D08B5E2")
    public void setState(int state) {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1894453142 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug(
                    "Setting dialog state for " + this + "newState = " + state);
                sipStack.getStackLogger().logStackTrace();
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_987087604 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logDebug(
                            this + "  old dialog state is " + this.getState());
                        sipStack.getStackLogger().logDebug(
                            this + "  New dialog state is " + DialogState.getObject(state));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        this.dialogState = state;
        {
            {
                boolean var0CDA542FA791709C98BE4603D7193AE9_1357671125 = (sipStack.getTimer() != null);
                {
                    sipStack.getTimer().schedule(new LingerTimer(), DIALOG_LINGER_TIME * 1000);
                } //End block
            } //End collapsed parenthetic
            this.stopTimer();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.005 -0400", hash_original_method = "030EEF9CE7E1904041534ED4E8E41515", hash_generated_method = "4A9F1E85391E5933A4CEDBE5FED49FDA")
    public void printDebugInfo() {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_520061420 = (sipStack.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.006 -0400", hash_original_method = "1550A0F77E6D4005059B99263F67738A", hash_generated_method = "E4086B61F78894505136E5F9AB2F0B9F")
    public boolean isAckSeen() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1481340626 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1481340626;
        // ---------- Original Method ----------
        //return this.ackSeen;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.006 -0400", hash_original_method = "B546264B9F955F6D37CCFB381DE1D848", hash_generated_method = "284C44A02BDEF892B7CCE80DFE1130FD")
    public SIPRequest getLastAckSent() {
        SIPRequest varB4EAC82CA7396A68D541C85D26508E83_162763573 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_162763573 = this.lastAckSent;
        varB4EAC82CA7396A68D541C85D26508E83_162763573.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_162763573;
        // ---------- Original Method ----------
        //return this.lastAckSent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.006 -0400", hash_original_method = "3A1F0F9E8BFDA328E094E225E007A649", hash_generated_method = "D0D8D125E5CC7AFA1AB0FE8218738167")
    public boolean isAckSent(long cseqNo) {
        {
            boolean var3665C5AC96583983B5AAFA78A2A4A188_1988582907 = (this.getLastTransaction() == null);
        } //End collapsed parenthetic
        {
            boolean varF59958C0898BD203DEF95141C522BCCD_1247746057 = (this.getLastTransaction() instanceof ClientTransaction);
            {
                {
                    boolean varCC537E3EE0A3D565D8032AB64F417D5A_295338500 = (this.getLastAckSent() == null);
                    {
                        boolean var98BAD3A8C67276872D114A7BFB474E16_495950378 = (cseqNo <=((SIPRequest) this.getLastAckSent()).getCSeq().getSeqNumber());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(cseqNo);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_292315146 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_292315146;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.007 -0400", hash_original_method = "614E8BDEDCCD12CF6A6EF62939E9BCC1", hash_generated_method = "35E5F5F4D0274B38A368DEF1D9F54703")
    public Transaction getFirstTransaction() {
        Transaction varB4EAC82CA7396A68D541C85D26508E83_1907278198 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1907278198 = this.firstTransaction;
        varB4EAC82CA7396A68D541C85D26508E83_1907278198.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1907278198;
        // ---------- Original Method ----------
        //return this.firstTransaction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.007 -0400", hash_original_method = "A5E017CF1C9F9D5F5F2E302DFCC4F846", hash_generated_method = "D0EC81EBEA165646F469F2FE65569BF7")
    public Iterator getRouteSet() {
        Iterator varB4EAC82CA7396A68D541C85D26508E83_920908255 = null; //Variable for return #1
        Iterator varB4EAC82CA7396A68D541C85D26508E83_1924019076 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_920908255 = new LinkedList().listIterator();
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1924019076 = this.getRouteList().listIterator();
        } //End block
        Iterator varA7E53CE21691AB073D9660D615818899_1985593097; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1985593097 = varB4EAC82CA7396A68D541C85D26508E83_920908255;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1985593097 = varB4EAC82CA7396A68D541C85D26508E83_1924019076;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1985593097.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1985593097;
        // ---------- Original Method ----------
        //if (this.routeList == null) {
            //return new LinkedList().listIterator();
        //} else {
            //return this.getRouteList().listIterator();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.022 -0400", hash_original_method = "A8016262F3F363A84230A54DA12F1862", hash_generated_method = "36ED465474371CFE038650F898429630")
    public synchronized void addRoute(SIPRequest sipRequest) {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1572990146 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug(
                    "setContact: dialogState: " + this + "state = " + this.getState());
            } //End block
        } //End collapsed parenthetic
        {
            boolean varAF9C68605D64B0F2F115C62532D2B021_921934265 = (this.dialogState == CONFIRMED_STATE
                && SIPRequest.isTargetRefresh(sipRequest.getMethod()));
            {
                this.doTargetRefresh(sipRequest);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varB1C209232695E6D70F6B684A8210FA49_1634721542 = (sipRequest.getToTag()!=null);
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
        addTaint(sipRequest.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.023 -0400", hash_original_method = "7A127BC7F5926E2623990DC3EF5AF92A", hash_generated_method = "CB8AA31A85091EA3068885635C30BAC6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.024 -0400", hash_original_method = "3F9050C9D9DA025E9AD5115049E6DBE4", hash_generated_method = "37CE043F4F4846C2D784E8242B213B28")
    public boolean isServer() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1500898766 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1500898766;
        // ---------- Original Method ----------
        //if (this.firstTransactionSeen == false)
            //return this.serverTransactionFlag;
        //else
            //return this.firstTransactionIsServerTransaction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.025 -0400", hash_original_method = "78570188BA83CB17A52ACDCDF5E3A80D", hash_generated_method = "2E955C660F0ABC6DFE27851B5193E36E")
    protected boolean isReInvite() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1701783255 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1701783255;
        // ---------- Original Method ----------
        //return this.reInviteFlag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.032 -0400", hash_original_method = "E7B2220F30EB97BE925BA6431B089B50", hash_generated_method = "90A262F7269C883C2F5DCE5B341E02CF")
    public String getDialogId() {
        String varB4EAC82CA7396A68D541C85D26508E83_172501325 = null; //Variable for return #1
        this.dialogId = this.lastResponse.getDialogId(isServer());
        varB4EAC82CA7396A68D541C85D26508E83_172501325 = this.dialogId;
        varB4EAC82CA7396A68D541C85D26508E83_172501325.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_172501325;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.047 -0400", hash_original_method = "5D1D12A2E6FD98502CE24F8CA665F380", hash_generated_method = "201F0A516F1250FB1EA34D741C554E44")
    public void addTransaction(SIPTransaction transaction) {
        SIPRequest sipRequest;
        sipRequest = (SIPRequest) transaction.getOriginalRequest();
        {
            boolean varB7F9A6A61385E3192B10301B5B3F8549_1894579725 = (firstTransactionSeen && !firstTransactionId.equals(transaction.getBranchId()) 
                && transaction.getMethod().equals(firstTransactionMethod));
            {
                this.reInviteFlag = true;
            } //End block
        } //End collapsed parenthetic
        {
            storeFirstTransactionInfo(this, transaction);
            {
                boolean varD92DE4EDF61C41C566AE76DAC140EAB6_1846133826 = (sipRequest.getMethod().equals(Request.SUBSCRIBE));
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
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_527946456 = (sipStack.isLoggingEnabled());
                    sipStack.getStackLogger().logError(
                            "The request's From header is missing the required Tag parameter.");
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            boolean varDE98D793D4ACAAC2095FDB19E0A65B87_1851462272 = (transaction.getMethod().equals(firstTransactionMethod)
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
        this.lastTransaction = transaction;
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1252893767 = (sipStack.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.049 -0400", hash_original_method = "D993372A10E82664D688CA2C725ED950", hash_generated_method = "CC1A75CE3BD646BBC8A9DD8B24C0F422")
    private void setRemoteTag(String hisTag) {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_2011190788 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug(
                    "setRemoteTag(): " + this + " remoteTag = " + this.hisTag + " new tag = "
                            + hisTag);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var900B1255CEEB9524C1B77103CD9B853E_284256069 = (this.hisTag != null && hisTag != null && !hisTag.equals(this.hisTag));
            {
                {
                    boolean varC92ECF628E283041EE15A3395386A5F8_1840290339 = (this.getState() != DialogState.EARLY);
                    {
                        {
                            boolean var2AB968A8303910EE00F810B6DE3410F9_970678112 = (sipStack.isLoggingEnabled());
                            sipStack.getStackLogger().logDebug(
                        "Dialog is already established -- ignoring remote tag re-assignment");
                        } //End collapsed parenthetic
                    } //End block
                    {
                        boolean var882658CE99D357DAFA1231A214A8043C_1579409975 = (sipStack.isRemoteTagReassignmentAllowed());
                        {
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_1340069363 = (sipStack.isLoggingEnabled());
                                sipStack.getStackLogger().logDebug(
                        "UNSAFE OPERATION !  tag re-assignment " + this.hisTag
                                + " trying to set to " + hisTag
                                + " can cause unexpected effects ");
                            } //End collapsed parenthetic
                            boolean removed;
                            removed = false;
                            {
                                boolean var705F9CB3BFC32B68CBC0B119B34F8418_1816154260 = (this.sipStack.getDialog(dialogId) == this);
                                {
                                    this.sipStack.removeDialog(dialogId);
                                    removed = true;
                                } //End block
                            } //End collapsed parenthetic
                            this.dialogId = null;
                            this.hisTag = hisTag;
                            {
                                {
                                    boolean varA5D47C3A6259BCCCC2265DD1F84B75D4_431186779 = (sipStack.isLoggingEnabled());
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
                    this.hisTag = hisTag;
                } //End block
                {
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_2033061041 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger().logWarning("setRemoteTag : called with null argument ");
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.058 -0400", hash_original_method = "6BDB0ABA2E69E3FFFE0E9E894A65FB29", hash_generated_method = "F015A7241385CAF5C2BA3D37AD40EA15")
    public SIPTransaction getLastTransaction() {
        SIPTransaction varB4EAC82CA7396A68D541C85D26508E83_1510563400 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1510563400 = this.lastTransaction;
        varB4EAC82CA7396A68D541C85D26508E83_1510563400.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1510563400;
        // ---------- Original Method ----------
        //return this.lastTransaction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.059 -0400", hash_original_method = "2B80A0EDB61F41D041D4D4B21A265288", hash_generated_method = "55E8625D1245CD58F3E01A9A44252155")
    public SIPServerTransaction getInviteTransaction() {
        SIPServerTransaction varB4EAC82CA7396A68D541C85D26508E83_249790421 = null; //Variable for return #1
        SIPServerTransaction varB4EAC82CA7396A68D541C85D26508E83_1314278424 = null; //Variable for return #2
        DialogTimerTask t;
        t = this.timerTask;
        varB4EAC82CA7396A68D541C85D26508E83_249790421 = t.transaction;
        varB4EAC82CA7396A68D541C85D26508E83_1314278424 = null;
        SIPServerTransaction varA7E53CE21691AB073D9660D615818899_1046745630; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1046745630 = varB4EAC82CA7396A68D541C85D26508E83_249790421;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1046745630 = varB4EAC82CA7396A68D541C85D26508E83_1314278424;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1046745630.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1046745630;
        // ---------- Original Method ----------
        //DialogTimerTask t = this.timerTask;
        //if (t != null)
            //return t.transaction;
        //else
            //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.059 -0400", hash_original_method = "0F222FB6A793487D534C4C9D0AE37F48", hash_generated_method = "FCEE37B7F174E2230583C8308FFA01F8")
    private void setLocalSequenceNumber(long lCseq) {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_908242137 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug(
                    "setLocalSequenceNumber: original  " + this.localSequenceNumber + " new  = "
                            + lCseq);
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Sequence number should not decrease !");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.061 -0400", hash_original_method = "2CD5B084729CE62420C092F3B17E64CA", hash_generated_method = "867F2A179CD475107C8121488B37D82E")
    public void setRemoteSequenceNumber(long rCseq) {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1419758033 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug("setRemoteSeqno " + this + "/" + rCseq);
        } //End collapsed parenthetic
        this.remoteSequenceNumber = rCseq;
        // ---------- Original Method ----------
        //if (sipStack.isLoggingEnabled())
            //sipStack.getStackLogger().logDebug("setRemoteSeqno " + this + "/" + rCseq);
        //this.remoteSequenceNumber = rCseq;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.064 -0400", hash_original_method = "ACC9A2408A6E532361DDB7BDD50DD489", hash_generated_method = "0CE7495547330D4CCF2E73D8AE7D692E")
    public void incrementLocalSequenceNumber() {
        // ---------- Original Method ----------
        //++this.localSequenceNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.064 -0400", hash_original_method = "FC2F178305D96E73603946FEBD885895", hash_generated_method = "DB5D857BA9385266A91EACC4C4928ADC")
    public int getRemoteSequenceNumber() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_41865958 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_41865958;
        // ---------- Original Method ----------
        //return (int) this.remoteSequenceNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.072 -0400", hash_original_method = "4E94621434A30379D5E2C1A949477B38", hash_generated_method = "0671EA32DA15C6AB2D68F8A3F7CEB882")
    public int getLocalSequenceNumber() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_816343112 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_816343112;
        // ---------- Original Method ----------
        //return (int) this.localSequenceNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.073 -0400", hash_original_method = "6474794E57511F2FE7B2B694C3DD0A5A", hash_generated_method = "9ACDACAC2B8B1F0568B9983B7408535C")
    public long getOriginalLocalSequenceNumber() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_459736681 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_459736681;
        // ---------- Original Method ----------
        //return this.originalLocalSequenceNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.073 -0400", hash_original_method = "4D53FF8947679D063EC9104B2E34893C", hash_generated_method = "E3DBA173C3839C605EE0F199AFAD3B4A")
    public long getLocalSeqNumber() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_253548305 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_253548305;
        // ---------- Original Method ----------
        //return this.localSequenceNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.074 -0400", hash_original_method = "86EC66726C4D4B16B759790B32B2EE83", hash_generated_method = "AF9E3A76536DED4E4ADF6FDC66732B88")
    public long getRemoteSeqNumber() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_601245528 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_601245528;
        // ---------- Original Method ----------
        //return this.remoteSequenceNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.074 -0400", hash_original_method = "0BA81564D0817AED393E2EAE028CBF1E", hash_generated_method = "AE6E7028E24985B1DA40740138434DAC")
    public String getLocalTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_368390836 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_368390836 = this.myTag;
        varB4EAC82CA7396A68D541C85D26508E83_368390836.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_368390836;
        // ---------- Original Method ----------
        //return this.myTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.074 -0400", hash_original_method = "C2413781DD6AA95F52F5C21D9381D08B", hash_generated_method = "CB7A168F366CCE7C9D2464B5C5C1D237")
    public String getRemoteTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_778048939 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_778048939 = hisTag;
        varB4EAC82CA7396A68D541C85D26508E83_778048939.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_778048939;
        // ---------- Original Method ----------
        //return hisTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.091 -0400", hash_original_method = "CA511CD87985B97DC1F9ED1FACA7DA9D", hash_generated_method = "C51EAB42B35216F445616629986A48C1")
    private void setLocalTag(String mytag) {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1491343506 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("set Local tag " + mytag + " " + this.dialogId);
                sipStack.getStackLogger().logStackTrace();
            } //End block
        } //End collapsed parenthetic
        this.myTag = mytag;
        // ---------- Original Method ----------
        //if (sipStack.isLoggingEnabled()) {
            //sipStack.getStackLogger().logDebug("set Local tag " + mytag + " " + this.dialogId);
            //sipStack.getStackLogger().logStackTrace();
        //}
        //this.myTag = mytag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.107 -0400", hash_original_method = "34B72580F00CA0B4FA87EF05393027BE", hash_generated_method = "C41AF72127A1D3997F6A353CD4B6BEE0")
    public void delete() {
        this.setState(TERMINATED_STATE);
        // ---------- Original Method ----------
        //this.setState(TERMINATED_STATE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.107 -0400", hash_original_method = "E30651442243E5536659B8D6D7E6C300", hash_generated_method = "8847585446B96797735DD2B64A0EC59C")
    public CallIdHeader getCallId() {
        CallIdHeader varB4EAC82CA7396A68D541C85D26508E83_1220737207 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1220737207 = this.callIdHeader;
        varB4EAC82CA7396A68D541C85D26508E83_1220737207.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1220737207;
        // ---------- Original Method ----------
        //return this.callIdHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.108 -0400", hash_original_method = "4B0BBE43D23308E79DF92279003CECC0", hash_generated_method = "517DBAA469E981201785F2FDAACB9B73")
    private void setCallId(SIPRequest sipRequest) {
        this.callIdHeader = sipRequest.getCallId();
        // ---------- Original Method ----------
        //this.callIdHeader = sipRequest.getCallId();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.109 -0400", hash_original_method = "1786A3231AA3C60CCA9E19F7DEAE30E7", hash_generated_method = "ED82A6266CC5F013067AE0F0FE4DBE44")
    public javax.sip.address.Address getLocalParty() {
        javax.sip.address.Address varB4EAC82CA7396A68D541C85D26508E83_1279823680 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1279823680 = this.localParty;
        varB4EAC82CA7396A68D541C85D26508E83_1279823680.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1279823680;
        // ---------- Original Method ----------
        //return this.localParty;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.109 -0400", hash_original_method = "1D3A055B19FDF32D0E14CBB9A0F366F2", hash_generated_method = "0D29F3CFF475425C279273FC2C9D8728")
    private void setLocalParty(SIPMessage sipMessage) {
        {
            boolean varBEE554E6D1FF8C71A0674E385CDC8906_417799564 = (!isServer());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.110 -0400", hash_original_method = "CA9799D7C5644CC201AAA28B1842190A", hash_generated_method = "52E1CA7F7097820323D656CEE0702842")
    public javax.sip.address.Address getRemoteParty() {
        javax.sip.address.Address varB4EAC82CA7396A68D541C85D26508E83_74416591 = null; //Variable for return #1
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1356213393 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("gettingRemoteParty " + this.remoteParty);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_74416591 = this.remoteParty;
        varB4EAC82CA7396A68D541C85D26508E83_74416591.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_74416591;
        // ---------- Original Method ----------
        //if (sipStack.isLoggingEnabled()) {
            //sipStack.getStackLogger().logDebug("gettingRemoteParty " + this.remoteParty);
        //}
        //return this.remoteParty;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.111 -0400", hash_original_method = "5663F20A7285801454D4B2BC61212FE3", hash_generated_method = "65DC7EDB7CBCF095C97A6A2A72A42712")
    public javax.sip.address.Address getRemoteTarget() {
        javax.sip.address.Address varB4EAC82CA7396A68D541C85D26508E83_1089726610 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1089726610 = this.remoteTarget;
        varB4EAC82CA7396A68D541C85D26508E83_1089726610.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1089726610;
        // ---------- Original Method ----------
        //return this.remoteTarget;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.115 -0400", hash_original_method = "81C5F6A55277F5330460057DCD70CFE0", hash_generated_method = "8E4499246A8990944C61894385865FA0")
    public DialogState getState() {
        DialogState varB4EAC82CA7396A68D541C85D26508E83_384260016 = null; //Variable for return #1
        DialogState varB4EAC82CA7396A68D541C85D26508E83_1566146292 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_384260016 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1566146292 = DialogState.getObject(this.dialogState);
        DialogState varA7E53CE21691AB073D9660D615818899_2045632649; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2045632649 = varB4EAC82CA7396A68D541C85D26508E83_384260016;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2045632649 = varB4EAC82CA7396A68D541C85D26508E83_1566146292;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2045632649.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2045632649;
        // ---------- Original Method ----------
        //if (this.dialogState == NULL_STATE)
            //return null;
        //return DialogState.getObject(this.dialogState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.115 -0400", hash_original_method = "B6F2129527CFF355191EDA726B295B54", hash_generated_method = "4D46B577908D3B8ACEABA0E97473F88E")
    public boolean isSecure() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_501832574 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_501832574;
        // ---------- Original Method ----------
        //return this.firstTransactionSecure;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.116 -0400", hash_original_method = "41912A3E01B6CF39F4209C49F71F74D2", hash_generated_method = "9092FE5F04B796D0CB46E57A1AA894B5")
    public void sendAck(Request request) throws SipException {
        this.sendAck(request, true);
        addTaint(request.getTaint());
        // ---------- Original Method ----------
        //this.sendAck(request, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.116 -0400", hash_original_method = "802F1385694BBDC717BE4DE58C3ED44B", hash_generated_method = "01A31B2AD81F3A7C9838B91FD5CCF73B")
    public Request createRequest(String method) throws SipException {
        Request varB4EAC82CA7396A68D541C85D26508E83_1388082429 = null; //Variable for return #1
        {
            boolean var7FAEA5BBA47884C7B33E1A58D0E293FA_2142534297 = (method.equals(Request.ACK) || method.equals(Request.PRACK));
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException("Invalid method specified for createRequest:" + method);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1388082429 = this.createRequest(method, this.lastResponse);
        if (DroidSafeAndroidRuntime.control) throw new SipException("Dialog not yet established -- no response!");
        addTaint(method.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1388082429.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1388082429;
        // ---------- Original Method ----------
        //if (method.equals(Request.ACK) || method.equals(Request.PRACK)) {
            //throw new SipException("Invalid method specified for createRequest:" + method);
        //}
        //if (lastResponse != null)
            //return this.createRequest(method, this.lastResponse);
        //else
            //throw new SipException("Dialog not yet established -- no response!");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.126 -0400", hash_original_method = "B004628D88AAF4473352CE6B2CF39886", hash_generated_method = "79185D3DD9621881729D3FD0AC4A63B9")
    private Request createRequest(String method, SIPResponse sipResponse) throws SipException {
        Request varB4EAC82CA7396A68D541C85D26508E83_152347866 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null argument");
        {
            boolean var901DDCA4AFD787ED4D3E774E6F5954D2_2127446519 = (method.equals(Request.CANCEL));
            if (DroidSafeAndroidRuntime.control) throw new SipException("Dialog.createRequest(): Invalid request");
        } //End collapsed parenthetic
        {
            boolean var6451C3E80BA914B63DA4E2C0EE66A26D_1481480620 = (this.getState() == null
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
            boolean var32CB10BEC2D464683496BEC61BDB1C7C_777715028 = (this.getRemoteTarget() != null);
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
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1501353396 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logError("Unexpected error");
            } //End collapsed parenthetic
            InternalErrorHandler.handleException(ex);
        } //End block
        ListeningPointImpl lp;
        lp = (ListeningPointImpl) this.sipProvider
                .getListeningPoint(sipResponse.getTopmostVia().getTransport());
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1751243609 = (sipStack.isLoggingEnabled());
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
            boolean var134460D0D6709F29F302E0A7AAE6BE0A_1568767437 = (SIPRequest.isTargetRefresh(method));
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
            boolean varCF8EB2629DEB9D14D2D7AE3B8557C47D_1976596723 = (method.equals(Request.SUBSCRIBE));
            {
                sipRequest.addHeader(eventHeader);
            } //End block
        } //End collapsed parenthetic
        try 
        {
            {
                boolean var8960EF1666EE0A76790F8BA2DB88F003_705730259 = (this.getLocalTag() != null);
                {
                    from.setTag(this.getLocalTag());
                } //End block
                {
                    from.removeTag();
                } //End block
            } //End collapsed parenthetic
            {
                boolean var2C6389CD64DE33F7E280071219A47D88_939891015 = (this.getRemoteTag() != null);
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
        varB4EAC82CA7396A68D541C85D26508E83_152347866 = sipRequest;
        addTaint(method.getTaint());
        addTaint(sipResponse.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_152347866.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_152347866;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.139 -0400", hash_original_method = "9C360B0CF1AC53C036709107CECBBC75", hash_generated_method = "12ADC8E628FCA65C06A8DA9FD0AEED45")
    public void sendRequest(ClientTransaction clientTransactionId) throws TransactionDoesNotExistException, SipException {
        this.sendRequest(clientTransactionId, !this.isBackToBackUserAgent);
        addTaint(clientTransactionId.getTaint());
        // ---------- Original Method ----------
        //this.sendRequest(clientTransactionId, !this.isBackToBackUserAgent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.152 -0400", hash_original_method = "E90E816BF2167876B04C570AAB507565", hash_generated_method = "127B7F8D029B409BBFF4F278D5669F98")
    public void sendRequest(ClientTransaction clientTransactionId, boolean allowInterleaving) throws TransactionDoesNotExistException, SipException {
        {
            boolean var0B73476425A078E6D0D1236F4BB54CAC_44648442 = ((!allowInterleaving)
                && clientTransactionId.getRequest().getMethod().equals(Request.INVITE));
            {
                new Thread((new ReInviteSender(clientTransactionId))).start();
            } //End block
        } //End collapsed parenthetic
        SIPRequest dialogRequest;
        dialogRequest = ((SIPClientTransaction) clientTransactionId)
                .getOriginalRequest();
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_216096694 = (sipStack.isLoggingEnabled());
            sipStack.getStackLogger().logDebug(
                    "dialog.sendRequest " + " dialog = " + this + "\ndialogRequest = \n"
                            + dialogRequest);
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null parameter");
        {
            boolean var1169745922CE63DD156260B7D456AE05_1275172676 = (dialogRequest.getMethod().equals(Request.ACK)
                || dialogRequest.getMethod().equals(Request.CANCEL));
            if (DroidSafeAndroidRuntime.control) throw new SipException("Bad Request Method. " + dialogRequest.getMethod());
        } //End collapsed parenthetic
        {
            boolean varC96A74E8BBC3DA149625FF2EC6772871_740582239 = (byeSent && isTerminatedOnBye() && !dialogRequest.getMethod().equals(Request.BYE));
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1120141723 = (sipStack.isLoggingEnabled());
                    sipStack.getStackLogger().logError("BYE already sent for " + this);
                } //End collapsed parenthetic
                if (DroidSafeAndroidRuntime.control) throw new SipException("Cannot send request; BYE already sent");
            } //End block
        } //End collapsed parenthetic
        {
            boolean varBC4604ED9CEFF5AB625860EF0715C0B5_1056751895 = (dialogRequest.getTopmostVia() == null);
            {
                Via via;
                via = ((SIPClientTransaction) clientTransactionId).getOutgoingViaHeader();
                dialogRequest.addHeader(via);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var906255BA0B7F8ECAF3658C3F65A640E3_611734809 = (!this.getCallId().getCallId().equalsIgnoreCase(dialogRequest.getCallId().getCallId()));
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1911156539 = (sipStack.isLoggingEnabled());
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
            boolean varB53BA052D4209F28F5E99708019E0649_712271258 = (this.getLocalTag() != null && from.getTag() != null
                && !from.getTag().equals(this.getLocalTag()));
            if (DroidSafeAndroidRuntime.control) throw new SipException("From tag mismatch expecting  " + this.getLocalTag());
        } //End collapsed parenthetic
        {
            boolean var89BDFDBB281A8FAD37A897E8D21F188F_668831357 = (this.getRemoteTag() != null && to.getTag() != null
                && !to.getTag().equals(this.getRemoteTag()));
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1561153624 = (sipStack.isLoggingEnabled());
                    this.sipStack.getStackLogger().logWarning(
                    "To header tag mismatch expecting " + this.getRemoteTag());
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean varD80EDFF969ADE551B15AAA6F81B0F87F_1757135904 = (this.getLocalTag() == null && dialogRequest.getMethod().equals(Request.NOTIFY));
            {
                {
                    boolean varA7B972031300250A30428BA53613E368_1948237201 = (!this.getMethod().equals(Request.SUBSCRIBE));
                    if (DroidSafeAndroidRuntime.control) throw new SipException("Trying to send NOTIFY without SUBSCRIBE Dialog!");
                } //End collapsed parenthetic
                this.setLocalTag(from.getTag());
            } //End block
        } //End collapsed parenthetic
        try 
        {
            {
                boolean var8960EF1666EE0A76790F8BA2DB88F003_1147883261 = (this.getLocalTag() != null);
                from.setTag(this.getLocalTag());
            } //End collapsed parenthetic
            {
                boolean var2C6389CD64DE33F7E280071219A47D88_1437133039 = (this.getRemoteTag() != null);
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
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_373782985 = (sipStack.isLoggingEnabled());
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
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1066333077 = (sipStack.isLoggingEnabled());
                    sipStack.getStackLogger().logDebug(
                            "oldChannel: useCount " + oldChannel.useCount);
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_679776797 = (sipStack.isLoggingEnabled());
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
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1554332683 = (sipStack.isLoggingEnabled());
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
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1381044745 = (sipStack.isLoggingEnabled());
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
                boolean varD35D780BD2119470ABCE216878F145E2_2073508887 = (dialogRequest.getMethod().equals(Request.BYE));
                {
                    this.byeSent = true;
                    {
                        boolean var61F0069F460C1DE219DEA32CC067873C_1257045915 = (isTerminatedOnBye());
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
        addTaint(clientTransactionId.getTaint());
        addTaint(allowInterleaving);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.153 -0400", hash_original_method = "BB6E18DBBED43A4BEB60B225A721A13E", hash_generated_method = "23265722A9D770AF479D252C49DF5CB9")
    private boolean toRetransmitFinalResponse(int T2) {
        {
            this.retransmissionTicksLeft = 2 * prevRetransmissionTicks;
            this.retransmissionTicksLeft = prevRetransmissionTicks;
            this.prevRetransmissionTicks = retransmissionTicksLeft;
        } //End block
        addTaint(T2);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1990745358 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1990745358;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.158 -0400", hash_original_method = "085350C5B4F086D4A04022EDF074C477", hash_generated_method = "CEED3E6C57E3AE5A6BAC9A7B6FFC14D3")
    protected void setRetransmissionTicks() {
        this.retransmissionTicksLeft = 1;
        this.prevRetransmissionTicks = 1;
        // ---------- Original Method ----------
        //this.retransmissionTicksLeft = 1;
        //this.prevRetransmissionTicks = 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.159 -0400", hash_original_method = "9B2F4C7AC7E3D2DC3FE02C5A18455E2B", hash_generated_method = "96A7711C9AFED8E2DE1ACD78278B9D47")
    public void resendAck() throws SipException {
        {
            boolean var6C2ACBE5BDF4F74D454F50C12DD0D9DC_2059308940 = (this.getLastAckSent() != null);
            {
                {
                    boolean varCB70FC8263CD09B0F1B84A47A0A0E4F7_1346084319 = (getLastAckSent().getHeader(TimeStampHeader.NAME) != null
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.159 -0400", hash_original_method = "691C5451C67574E660997BC2056A5F23", hash_generated_method = "5CC12BC01D0019B61692B1DAE959502E")
    public String getMethod() {
        String varB4EAC82CA7396A68D541C85D26508E83_1589348495 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1589348495 = this.method;
        varB4EAC82CA7396A68D541C85D26508E83_1589348495.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1589348495;
        // ---------- Original Method ----------
        //return this.method;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.163 -0400", hash_original_method = "1E91804F8A3049A9C15BCD340F87DF5D", hash_generated_method = "A5153768AD9D9E9DCD46671C077BCF31")
    protected void startTimer(SIPServerTransaction transaction) {
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1437507453 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug("Timer already running for " + getDialogId());
            } //End collapsed parenthetic
        } //End block
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_1043418595 = (sipStack.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.164 -0400", hash_original_method = "3E7472F910A577F9E6FCB71153FF16E3", hash_generated_method = "F1187DBDC9E801B24174FAD13B752CDB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.171 -0400", hash_original_method = "B99416CED2F5EC9B5AF4977F926F9FAE", hash_generated_method = "2D868CB4A97A09A7BA8B0A074DE91E55")
    public Request createPrack(Response relResponse) throws DialogDoesNotExistException,
            SipException {
        Request varB4EAC82CA7396A68D541C85D26508E83_1879119962 = null; //Variable for return #1
        Request varB4EAC82CA7396A68D541C85D26508E83_1553210681 = null; //Variable for return #2
        {
            boolean var5F13FEDECFA24670F7B4ECAB7A40873E_1061727440 = (this.getState() == null || this.getState().equals(DialogState.TERMINATED));
            if (DroidSafeAndroidRuntime.control) throw new DialogDoesNotExistException("Dialog not initialized or terminated");
        } //End collapsed parenthetic
        {
            boolean var87BC905A631F8D351A6D3C712E9DE58A_227189166 = ((RSeq) relResponse.getHeader(RSeqHeader.NAME) == null);
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
            varB4EAC82CA7396A68D541C85D26508E83_1879119962 = (Request) sipRequest;
        } //End block
        catch (Exception ex)
        {
            InternalErrorHandler.handleException(ex);
            varB4EAC82CA7396A68D541C85D26508E83_1553210681 = null;
        } //End block
        addTaint(relResponse.getTaint());
        Request varA7E53CE21691AB073D9660D615818899_830889139; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_830889139 = varB4EAC82CA7396A68D541C85D26508E83_1879119962;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_830889139 = varB4EAC82CA7396A68D541C85D26508E83_1553210681;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_830889139.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_830889139;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.179 -0400", hash_original_method = "AE874CF06DEDE92D6543D8F7D52B6043", hash_generated_method = "B35EC6ABA777A39147BD4581CB7E5296")
    private void updateRequest(SIPRequest sipRequest) {
        RouteList rl;
        rl = this.getRouteList();
        {
            boolean var1845ECD20E35B086D417AFB72F9DDE84_852313708 = (rl.size() > 0);
            {
                sipRequest.setHeader(rl);
            } //End block
            {
                sipRequest.removeHeader(RouteHeader.NAME);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var896FD3C9C4EED86170D10D69961A19CE_585151246 = (MessageFactoryImpl.getDefaultUserAgentHeader() != null);
            {
                sipRequest.setHeader(MessageFactoryImpl.getDefaultUserAgentHeader());
            } //End block
        } //End collapsed parenthetic
        addTaint(sipRequest.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.190 -0400", hash_original_method = "8ECB2239C30E6B6F2CF5AEE7662DC317", hash_generated_method = "4E16157BAF695D28A7B0E6E701E7B7F1")
    public Request createAck(long cseqno) throws InvalidArgumentException, SipException {
        Request varB4EAC82CA7396A68D541C85D26508E83_2144767622 = null; //Variable for return #1
        {
            boolean varD24E8B9BE4529879766AB23987E8AD7C_1190972179 = (!method.equals(Request.INVITE));
            if (DroidSafeAndroidRuntime.control) throw new SipException("Dialog was not created with an INVITE" + method);
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad cseq <= 0 ");
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad cseq > " + ((((long) 1) << 32) - 1));
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("Cannot create ACK - no remote Target!");
        } //End block
        {
            boolean var01D5629BD6EE4648A9CF76B7CC4467B7_1491474784 = (this.sipStack.isLoggingEnabled());
            {
                this.sipStack.getStackLogger().logDebug("createAck " + this + " cseqno " + cseqno);
            } //End block
        } //End collapsed parenthetic
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_899449409 = (sipStack.isLoggingEnabled());
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
                boolean var88914CD57C4971E4E025A7D4C058C72C_134832783 = (this.routeList != null && !this.routeList.isEmpty());
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
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_235317084 = (sipStack.isLoggingEnabled());
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
                boolean var5ACE7FF7AC32F8E6606DBA1F89AB80FD_550802418 = (originalRequest != null && originalRequest.getTopmostVia() != null);
                {
                    NameValueList originalRequestParameters;
                    originalRequestParameters = originalRequest.getTopmostVia()
                        .getParameters();
                    {
                        boolean var6A3D0DB6457794914BB4A50CBA9DA9AB_1979702292 = (originalRequestParameters != null && originalRequestParameters.size() > 0);
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
            varB4EAC82CA7396A68D541C85D26508E83_2144767622 = sipRequest;
        } //End block
        catch (Exception ex)
        {
            InternalErrorHandler.handleException(ex);
            if (DroidSafeAndroidRuntime.control) throw new SipException("unexpected exception ", ex);
        } //End block
        addTaint(cseqno);
        varB4EAC82CA7396A68D541C85D26508E83_2144767622.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2144767622;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.191 -0400", hash_original_method = "225E26F17D14C81F6F76A7525B288E82", hash_generated_method = "E3E0FA58AAB3AD0D1AF91D3B6B5C24DE")
    public SipProviderImpl getSipProvider() {
        SipProviderImpl varB4EAC82CA7396A68D541C85D26508E83_436444040 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_436444040 = this.sipProvider;
        varB4EAC82CA7396A68D541C85D26508E83_436444040.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_436444040;
        // ---------- Original Method ----------
        //return this.sipProvider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.193 -0400", hash_original_method = "8A8245F47D42BA43478E00CC55ABA836", hash_generated_method = "926E58A1A024385C486CD7AE44684A34")
    public void setSipProvider(SipProviderImpl sipProvider) {
        this.sipProvider = sipProvider;
        // ---------- Original Method ----------
        //this.sipProvider = sipProvider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.195 -0400", hash_original_method = "CF7951DD9E6C51606E8031643391B018", hash_generated_method = "1FEA1B5E781F52B775ADD9404E7CA496")
    public void setResponseTags(SIPResponse sipResponse) {
        {
            boolean var8902B2D54D9D64C1AD2F6B4D577F0AC1_1474867947 = (this.getLocalTag() != null || this.getRemoteTag() != null);
        } //End collapsed parenthetic
        String responseFromTag;
        responseFromTag = sipResponse.getFromTag();
        {
            {
                boolean varEBFAC7E822975644712D237D7D794A79_1109660656 = (responseFromTag.equals(this.getLocalTag()));
                {
                    sipResponse.setToTag(this.getRemoteTag());
                } //End block
                {
                    boolean varC5E254C584E79962FDD35AF188F3D95B_1012996556 = (responseFromTag.equals(this.getRemoteTag()));
                    {
                        sipResponse.setToTag(this.getLocalTag());
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_972069520 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logWarning("No from tag in response! Not RFC 3261 compatible.");
            } //End collapsed parenthetic
        } //End block
        addTaint(sipResponse.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.216 -0400", hash_original_method = "80C5F1C3A7F1BF77711B99F831173748", hash_generated_method = "B4A4B2985A9EEE0CC14B8C92A815AD81")
    public void setLastResponse(SIPTransaction transaction, SIPResponse sipResponse) {
        this.callIdHeader = sipResponse.getCallId();
        int statusCode;
        statusCode = sipResponse.getStatusCode();
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1683928814 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logWarning(
                    "Invalid status code - 100 in setLastResponse - ignoring");
            } //End collapsed parenthetic
        } //End block
        this.lastResponse = sipResponse;
        this.setAssigned();
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_132298489 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug(
                    "sipDialog: setLastResponse:" + this + " lastResponse = "
                            + this.lastResponse.getFirstLine());
            } //End block
        } //End collapsed parenthetic
        {
            boolean varECEE72F2BE8BE87D5366A0277FBCE038_1063648193 = (this.getState() == DialogState.TERMINATED);
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_322464389 = (sipStack.isLoggingEnabled());
                    {
                        sipStack.getStackLogger().logDebug(
                        "sipDialog: setLastResponse -- dialog is terminated - ignoring ");
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var7C21E56F04FFB7827B07DB28A1638AE6_1521331317 = (sipResponse.getCSeq().getMethod().equals(Request.INVITE) && statusCode == 200);
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
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_118437700 = (sipStack.isLoggingEnabled());
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
                boolean var839B41C03A2B5D99C7BD81EF76FDD890_1342372160 = (sipStack.isDialogCreated(cseqMethod));
                {
                    {
                        boolean var08A2AAD99B8F98462ECF577990E03E96_1437043696 = (getState() == null && (statusCode / 100 == 1));
                        {
                            setState(SIPDialog.EARLY_STATE);
                            {
                                boolean var86C6F66A5EE9F0068D7CE893541F2279_998589572 = ((sipResponse.getToTag() != null || sipStack.rfc2543Supported)
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
                            boolean varFD6529C640F5D93B1D57A138B69C639B_2004952379 = (getState() != null && getState().equals(DialogState.EARLY)
                        && statusCode / 100 == 1);
                            {
                                {
                                    boolean var4453581B92AA957108C579A7BBD1E438_1712630826 = (cseqMethod.equals(getMethod()) && transaction != null
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
                                    boolean var239B25B26F48835960443934FE465816_1063622848 = (cseqMethod.equals(getMethod())
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
                                    boolean var184B92973316EEACC4E8F3D92F947022_432735568 = (cseqMethod.equals(Request.INVITE));
                                    {
                                        this.lastInviteOkReceived = Math.max(sipResponse.getCSeq().getSeqNumber(),
                                this.lastInviteOkReceived);
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                            {
                                boolean var002EA49254D7FFC38F40D126F1CC9B93_1356361017 = (statusCode >= 300
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
                        boolean varBE8416D96C82B905D899DAE9933207EA_934431900 = (this.getState() != DialogState.CONFIRMED && this.getState() != DialogState.TERMINATED);
                        {
                            {
                                RecordRouteList rrList;
                                rrList = originalRequest.getRecordRouteHeaders();
                                {
                                    ListIterator<RecordRoute> it;
                                    it = rrList.listIterator(rrList.size());
                                    {
                                        boolean var92523E1D2D6B9A5BA652D95D8D906FE7_1073727830 = (it.hasPrevious());
                                        {
                                            RecordRoute rr;
                                            rr = (RecordRoute) it.previous();
                                            Route route;
                                            route = (Route) routeList.getFirst();
                                            {
                                                boolean varD5391073D49D26C2405CCD1345D5D087_1836393622 = (route != null && rr.getAddress().equals(route.getAddress()));
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
                    boolean var7AC6283B1986B5EAA725F6A0CF5B9F25_67283427 = (cseqMethod.equals(Request.NOTIFY)
                    && (this.getMethod().equals(Request.SUBSCRIBE) || this.getMethod().equals(
                            Request.REFER)) && sipResponse.getStatusCode() / 100 == 2
                    && this.getState() == null);
                    {
                        this.setDialogId(sipResponse.getDialogId(true));
                        sipStack.putDialog(this);
                        this.setState(SIPDialog.CONFIRMED_STATE);
                    } //End block
                    {
                        boolean varE749A0B488BCFEEA24F7764568DA41BB_681000514 = (cseqMethod.equals(Request.BYE) && statusCode / 100 == 2
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
                boolean varDFD8EB8316ABF98C4152E3A58F249F7D_1410253 = (cseqMethod.equals(Request.BYE) && statusCode / 100 == 2
                    && this.isTerminatedOnBye());
                {
                    this.setState(SIPDialog.TERMINATED_STATE);
                } //End block
                {
                    boolean doPutDialog;
                    doPutDialog = false;
                    {
                        boolean var7F7C84F2182F0A7FD32A6DC59936958E_2134181989 = (getLocalTag() == null && sipResponse.getTo().getTag() != null
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
                                boolean var5EEA5383440BFA6F3C614F44448A4223_1623153531 = (statusCode == 489
                                && (cseqMethod.equals(Request.NOTIFY) || cseqMethod
                                        .equals(Request.SUBSCRIBE)));
                                {
                                    {
                                        boolean var6FE8ACC5352DCA3449210F8EDED912B3_1004219913 = (sipStack.isLoggingEnabled());
                                        sipStack.getStackLogger().logDebug(
                                    "RFC 3265 : Not setting dialog to TERMINATED for 489");
                                    } //End collapsed parenthetic
                                } //End block
                                {
                                    {
                                        boolean varE3695A6993661066E9CCD532BC123501_681071818 = (!this.isReInvite() && getState() != DialogState.CONFIRMED);
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
                            boolean var8F048B81832FCC5E25717E696D6EC78F_763886744 = (this.dialogState <= SIPDialog.EARLY_STATE
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
                            boolean varCABBB85C5AA4259E2991A258DBA7D46B_398206376 = (transaction.getState() != TransactionState.TERMINATED
                            && sipResponse.getStatusCode() == Response.OK
                            && cseqMethod.equals(Request.INVITE)
                            && this.isBackToBackUserAgent);
                            {
                                {
                                    boolean varC5A2075CB8D88EC332A5381179A3C4E5_1785103016 = (!this.takeAckSem());
                                    {
                                        {
                                            boolean var974BD9A3C84119780B64DA7C8AA64368_1324480724 = (sipStack.isLoggingEnabled());
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
        addTaint(transaction.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.220 -0400", hash_original_method = "96CF2F98DDD4CA038A3AFDF5A5247694", hash_generated_method = "C30ECD7A1013D624E26F2E5D3ED7DFD0")
    public void startRetransmitTimer(SIPServerTransaction sipServerTx, Response response) {
        {
            boolean varDA05BDD7E394F41387C809972258ED76_2022082693 = (sipServerTx.getRequest().getMethod().equals(Request.INVITE)
                && response.getStatusCode() / 100 == 2);
            {
                this.startTimer(sipServerTx);
            } //End block
        } //End collapsed parenthetic
        addTaint(sipServerTx.getTaint());
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //if (sipServerTx.getRequest().getMethod().equals(Request.INVITE)
                //&& response.getStatusCode() / 100 == 2) {
            //this.startTimer(sipServerTx);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.220 -0400", hash_original_method = "5F3E7F6102F24C611CAB04E5AE199DBF", hash_generated_method = "167B1723E8DDAB1DB85242AEC380C990")
    public SIPResponse getLastResponse() {
        SIPResponse varB4EAC82CA7396A68D541C85D26508E83_2049956835 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2049956835 = lastResponse;
        varB4EAC82CA7396A68D541C85D26508E83_2049956835.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2049956835;
        // ---------- Original Method ----------
        //return lastResponse;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.224 -0400", hash_original_method = "5B8AFE9B6B91DF83BE42F6862D2EF06A", hash_generated_method = "ECA7AE133848E8A1AAE84FC7B8C75300")
    private void doTargetRefresh(SIPMessage sipMessage) {
        ContactList contactList;
        contactList = sipMessage.getContactHeaders();
        {
            Contact contact;
            contact = (Contact) contactList.getFirst();
            this.setRemoteTarget(contact);
        } //End block
        addTaint(sipMessage.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.237 -0400", hash_original_method = "DE196281E5E185EC5F05D42F6040C5AD", hash_generated_method = "253929968E6015C69AAD946E43E1208E")
    public Response createReliableProvisionalResponse(int statusCode) throws InvalidArgumentException, SipException {
        Response varB4EAC82CA7396A68D541C85D26508E83_1568087498 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new SipException("Not a Server Dialog!");
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("Bad status code ");
        SIPRequest request;
        request = this.originalRequest;
        {
            boolean varF7429BEB5E0EF391085C3EA5B848B555_1883207159 = (!request.getMethod().equals(Request.INVITE));
            if (DroidSafeAndroidRuntime.control) throw new SipException("Bad method");
        } //End collapsed parenthetic
        ListIterator<SIPHeader> list;
        list = request.getHeaders(SupportedHeader.NAME);
        {
            boolean var4A2559DE457AD8ED09DD13E71379114F_2142779661 = (list == null || !optionPresent(list, "100rel"));
            {
                list = request.getHeaders(RequireHeader.NAME);
                {
                    boolean var1B8A6F1B7D3894FD5B5CD4B77CBF0692_1332722345 = (list == null || !optionPresent(list, "100rel"));
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
        varB4EAC82CA7396A68D541C85D26508E83_1568087498 = response;
        addTaint(statusCode);
        varB4EAC82CA7396A68D541C85D26508E83_1568087498.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1568087498;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.239 -0400", hash_original_method = "CEB91EBD9D583AC6C7E366C7B6D0F858", hash_generated_method = "C719029E9E5ECD200A233A3B2E09410F")
    public boolean handlePrack(SIPRequest prackRequest) {
        {
            boolean var0E41A90AC7F80C21FD8716EAE0D773F7_1305128423 = (!this.isServer());
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_3394134 = (sipStack.isLoggingEnabled());
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
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1239022644 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger()
                        .logDebug("Dropping Prack -- ReliableResponse not found");
            } //End collapsed parenthetic
        } //End block
        RAck rack;
        rack = (RAck) prackRequest.getHeader(RAckHeader.NAME);
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1778258209 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug("Dropping Prack -- rack header not found");
            } //End collapsed parenthetic
        } //End block
        CSeq cseq;
        cseq = (CSeq) sipResponse.getCSeq();
        {
            boolean var278DC96722B25CDE6DFD16B8198946C1_1498753863 = (!rack.getMethod().equals(cseq.getMethod()));
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1819910792 = (sipStack.isLoggingEnabled());
                    sipStack.getStackLogger().logDebug(
                        "Dropping Prack -- CSeq Header does not match PRACK");
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean var9E7D79F6F26763E9EC31F75D4B835E42_1033430339 = (rack.getCSeqNumberLong() != cseq.getSeqNumber());
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_246877132 = (sipStack.isLoggingEnabled());
                    sipStack.getStackLogger().logDebug(
                        "Dropping Prack -- CSeq Header does not match PRACK");
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        RSeq rseq;
        rseq = (RSeq) sipResponse.getHeader(RSeqHeader.NAME);
        {
            boolean var14265A1FCB2C0EE420AF27A8D1000FC8_1917714437 = (rack.getRSequenceNumber() != rseq.getSeqNumber());
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_678896406 = (sipStack.isLoggingEnabled());
                    sipStack.getStackLogger().logDebug(
                        "Dropping Prack -- RSeq Header does not match PRACK");
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        boolean var9683C82188D8B4F740D5FD5CABA0ABB6_66736340 = (sipServerTransaction.prackRecieved());
        addTaint(prackRequest.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1701290261 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1701290261;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.241 -0400", hash_original_method = "333DA078CA74B6FD5F6C9544F533B1F3", hash_generated_method = "04A110DE0015BA76267AABC93C20EB40")
    public void sendReliableProvisionalResponse(Response relResponse) throws SipException {
        {
            boolean var0E41A90AC7F80C21FD8716EAE0D773F7_2003681028 = (!this.isServer());
            {
                if (DroidSafeAndroidRuntime.control) throw new SipException("Not a Server Dialog");
            } //End block
        } //End collapsed parenthetic
        SIPResponse sipResponse;
        sipResponse = (SIPResponse) relResponse;
        {
            boolean varF58A7EF76B015A36548669D4B5BC189B_1168131153 = (relResponse.getStatusCode() == 100);
            if (DroidSafeAndroidRuntime.control) throw new SipException("Cannot send 100 as a reliable provisional response");
        } //End collapsed parenthetic
        {
            boolean var3F06CAF4D76D1B222835AB0581EBBF2D_141223443 = (relResponse.getStatusCode() / 100 > 2);
            if (DroidSafeAndroidRuntime.control) throw new SipException(
                    "Response code is not a 1xx response - should be in the range 101 to 199 ");
        } //End collapsed parenthetic
        {
            boolean var2453F1BE4A002CC1EF6C5E8F78E655A0_1354657128 = (sipResponse.getToTag() == null);
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
                boolean var3100C156835BFDAEC37B3A0F53F0E27B_397429238 = (requireList.hasNext() && !found);
                {
                    RequireHeader rh;
                    rh = (RequireHeader) requireList.next();
                    {
                        boolean varDF9A6A091AE7E489D36022F85E7FEEE0_1107821760 = (rh.getOptionTag().equalsIgnoreCase("100rel"));
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
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1298838900 = (sipStack.isLoggingEnabled());
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
        addTaint(relResponse.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.246 -0400", hash_original_method = "BF7D1FA3BFA6C180C8021919F244470C", hash_generated_method = "98FB51F17347B278C789B0BBB791F331")
    public void terminateOnBye(boolean terminateFlag) throws SipException {
        this.terminateOnBye = terminateFlag;
        // ---------- Original Method ----------
        //this.terminateOnBye = terminateFlag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.249 -0400", hash_original_method = "97AA8D077ED8B88563B1FCEB7D3F7A03", hash_generated_method = "3989220F20B7D3A9147AB058D826F7D8")
    public void setAssigned() {
        this.isAssigned = true;
        // ---------- Original Method ----------
        //this.isAssigned = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.249 -0400", hash_original_method = "F8427D0E95C386EDB403D30E8B4BBEC5", hash_generated_method = "43BBEF9C413BBCEB4471862034E9C592")
    public boolean isAssigned() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1949191131 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1949191131;
        // ---------- Original Method ----------
        //return this.isAssigned;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.249 -0400", hash_original_method = "370EA53498504D191CA2C54D6246F992", hash_generated_method = "5F6DA0FA9D4F52F6245FBA1934BD34E8")
    public Contact getMyContactHeader() {
        Contact varB4EAC82CA7396A68D541C85D26508E83_28570137 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_28570137 = contactHeader;
        varB4EAC82CA7396A68D541C85D26508E83_28570137.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_28570137;
        // ---------- Original Method ----------
        //return contactHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.265 -0400", hash_original_method = "1F7F0E32648D183A0E0322F85F939567", hash_generated_method = "8255257741D3A431E8D2094FA6173CB8")
    public boolean handleAck(SIPServerTransaction ackTransaction) {
        SIPRequest sipRequest;
        sipRequest = ackTransaction.getOriginalRequest();
        {
            boolean varB6606859BF451015E77F1552F52092D0_1860754376 = (isAckSeen() && getRemoteSeqNumber() == sipRequest.getCSeq().getSeqNumber());
            {
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_1652324738 = (sipStack.isLoggingEnabled());
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
                boolean var4A98AE6585D44012F8F89352F9238253_1866227120 = (this.getState() == DialogState.TERMINATED);
                {
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_2028910371 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger().logDebug("Dialog is terminated -- dropping ACK");
                    } //End collapsed parenthetic
                } //End block
                {
                    SIPServerTransaction tr;
                    tr = getInviteTransaction();
                    SIPResponse sipResponse;
                    sipResponse = (tr != null ? tr.getLastResponse() : null);//DSFIXME:  CODE0008: Nested ternary operator in expression
                    {
                        boolean var161CF50F3C95997F419241A9096FFB37_666722879 = (tr != null
                    && sipResponse != null
                    && sipResponse.getStatusCode() / 100 == 2
                    && sipResponse.getCSeq().getMethod().equals(Request.INVITE)
                    && sipResponse.getCSeq().getSeqNumber() == sipRequest.getCSeq()
                            .getSeqNumber());
                        {
                            ackTransaction.setDialog(this, sipResponse.getDialogId(false));
                            ackReceived(sipRequest);
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_276086553 = (sipStack.isLoggingEnabled());
                                sipStack.getStackLogger().logDebug("ACK for 2XX response --- sending to TU ");
                            } //End collapsed parenthetic
                        } //End block
                        {
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_1924060597 = (sipStack.isLoggingEnabled());
                                sipStack.getStackLogger().logDebug(
                            " INVITE transaction not found  -- Discarding ACK");
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        addTaint(ackTransaction.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1813200069 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1813200069;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.266 -0400", hash_original_method = "5C164F59F3DF11F779F16A5BAEE8EAC7", hash_generated_method = "F2805544ABD5BF70A703EFAA8BCD0891")
     void setEarlyDialogId(String earlyDialogId) {
        this.earlyDialogId = earlyDialogId;
        // ---------- Original Method ----------
        //this.earlyDialogId = earlyDialogId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.267 -0400", hash_original_method = "275E7276434F5D20F41DC92B4F25BAEE", hash_generated_method = "8EF590A990D093E98E6B9BE2CB97A516")
     String getEarlyDialogId() {
        String varB4EAC82CA7396A68D541C85D26508E83_1726115902 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1726115902 = earlyDialogId;
        varB4EAC82CA7396A68D541C85D26508E83_1726115902.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1726115902;
        // ---------- Original Method ----------
        //return earlyDialogId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.267 -0400", hash_original_method = "5A72AC369AA326C1E4BE607E2D1E31FF", hash_generated_method = "39EF63E99DB3B8FF3B4EF25E25EDEB2F")
     void releaseAckSem() {
        {
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1250028842 = (sipStack.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.268 -0400", hash_original_method = "75493DFA4E25D8A29CC5DF9217BF734F", hash_generated_method = "C57CE32445A877C84059F6CF93B382A6")
     boolean takeAckSem() {
        {
            boolean varADC6B4D22F314E4E23507BEFD4A59D21_2045648651 = (sipStack.isLoggingEnabled());
            {
                sipStack.getStackLogger().logDebug("[takeAckSem " + this);
            } //End block
        } //End collapsed parenthetic
        try 
        {
            {
                boolean varF77F8A7B1E99FF133CA038DFA9D02F86_1569200714 = (!this.ackSem.tryAcquire(2, TimeUnit.SECONDS));
                {
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_2044511290 = (sipStack.isLoggingEnabled());
                        {
                            sipStack.getStackLogger().logError("Cannot aquire ACK semaphore");
                        } //End block
                    } //End collapsed parenthetic
                    {
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_816243221 = (sipStack.isLoggingEnabled());
                        {
                            sipStack.getStackLogger().logDebug("Semaphore previously acquired at " + this.stackTrace);
                            sipStack.getStackLogger().logStackTrace();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_570906608 = (sipStack.isLoggingEnabled());
                {
                    this.recordStackTrace();
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (InterruptedException ex)
        {
            sipStack.getStackLogger().logError("Cannot aquire ACK semaphore");
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1474010477 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1474010477;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.272 -0400", hash_original_method = "68D4C33CE448DB45C09F49FC9815E4FD", hash_generated_method = "EAFEA098C1D75D51099230EDA00E4652")
    private void setLastAckReceived(SIPRequest lastAckReceived) {
        this.lastAckReceived = lastAckReceived;
        // ---------- Original Method ----------
        //this.lastAckReceived = lastAckReceived;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.272 -0400", hash_original_method = "2894D6C9FD5402948626BDE17D2ADDA1", hash_generated_method = "5B21107D507AEE6B6757AA7067EEE01E")
    protected SIPRequest getLastAckReceived() {
        SIPRequest varB4EAC82CA7396A68D541C85D26508E83_697727147 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_697727147 = lastAckReceived;
        varB4EAC82CA7396A68D541C85D26508E83_697727147.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_697727147;
        // ---------- Original Method ----------
        //return lastAckReceived;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.272 -0400", hash_original_method = "AE316349F4F2DB7FF5C817D5A1FDA212", hash_generated_method = "A753A427692B7DEB55775EE2604691AF")
    private void setLastAckSent(SIPRequest lastAckSent) {
        this.lastAckSent = lastAckSent;
        // ---------- Original Method ----------
        //this.lastAckSent = lastAckSent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.276 -0400", hash_original_method = "2B44FD1497547940266A6934DB958355", hash_generated_method = "313C4B7C4D4FCDC7AF0B0294770A0351")
    public boolean isAtleastOneAckSent() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1631179886 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1631179886;
        // ---------- Original Method ----------
        //return this.isAcknowledged;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.276 -0400", hash_original_method = "FAA2C5BC01CFE296F7D6D441890115F1", hash_generated_method = "CD6DF2BA0FA362F522DE1370DFB91F71")
    public boolean isBackToBackUserAgent() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1418449533 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1418449533;
        // ---------- Original Method ----------
        //return this.isBackToBackUserAgent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.276 -0400", hash_original_method = "1ECA22F9D5D81E6992181CD96CD57EA7", hash_generated_method = "3AB1D86F8E592D0D5F0309D12A7E03D2")
    public synchronized void doDeferredDeleteIfNoAckSent(long seqno) {
        {
            boolean var57BEDF91C3ACD8FDD0380E079BFC759D_740442866 = (sipStack.getTimer() == null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.280 -0400", hash_original_method = "782C3B034CC64F54A5BC7BB8ED6FEDA6", hash_generated_method = "5483C632656F6DE6E777597D7F71485A")
    public void setBackToBackUserAgent() {
        this.isBackToBackUserAgent = true;
        // ---------- Original Method ----------
        //this.isBackToBackUserAgent = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.281 -0400", hash_original_method = "3A5B567A7D7C4A4D6D60D4CFA5E677D1", hash_generated_method = "5B0E9EF56C7BCE919F4D2EE60C279941")
     EventHeader getEventHeader() {
        EventHeader varB4EAC82CA7396A68D541C85D26508E83_1550732901 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1550732901 = eventHeader;
        varB4EAC82CA7396A68D541C85D26508E83_1550732901.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1550732901;
        // ---------- Original Method ----------
        //return eventHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.286 -0400", hash_original_method = "C85F235E26C94FDBCE92FE9C88454CDD", hash_generated_method = "63FC881403C5365782CA2C6D3EBC0C51")
     void setEventHeader(EventHeader eventHeader) {
        this.eventHeader = eventHeader;
        // ---------- Original Method ----------
        //this.eventHeader = eventHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.286 -0400", hash_original_method = "D178A1777AB3611D9691A3F4A69F3B06", hash_generated_method = "944F48638C23857FD7322257F37AD5CE")
     void setServerTransactionFlag(boolean serverTransactionFlag) {
        this.serverTransactionFlag = serverTransactionFlag;
        // ---------- Original Method ----------
        //this.serverTransactionFlag = serverTransactionFlag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.286 -0400", hash_original_method = "B9FC7E5C15DF48754B63587E10ABF39E", hash_generated_method = "6E41B13A7FD0796718F54CCE53804461")
     void setReInviteFlag(boolean reInviteFlag) {
        this.reInviteFlag = reInviteFlag;
        // ---------- Original Method ----------
        //this.reInviteFlag = reInviteFlag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.287 -0400", hash_original_method = "554E3D8C2985A7B76F710766F6151401", hash_generated_method = "65BA393BA9EF0F05A1FF790BF390A545")
    public boolean isSequnceNumberValidation() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_101688537 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_101688537;
        // ---------- Original Method ----------
        //return this.sequenceNumberValidation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.287 -0400", hash_original_method = "07E72D397966AE985C4FA6CA39D288C5", hash_generated_method = "2CA8E42865DEC07CBC74D648985E0DA5")
    public void disableSequenceNumberValidation() {
        this.sequenceNumberValidation = false;
        // ---------- Original Method ----------
        //this.sequenceNumberValidation = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.287 -0400", hash_original_method = "32EDC5DA45A565F7D6F42D86C325067F", hash_generated_method = "283EBC055C1A2562C13F28011FC9945E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.289 -0400", hash_original_method = "7C538F01F8063281F04142649C9B2CD0", hash_generated_method = "3B7BE3389027D7D895A0B9E59CA6FC3E")
    public void releaseTimerTaskSem() {
        this.timerTaskLock.release();
        // ---------- Original Method ----------
        //this.timerTaskLock.release();
    }

    
    public class ReInviteSender implements Runnable, Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.289 -0400", hash_original_field = "ECACFFFFC22141F3C1C9CF77DDF0308D", hash_generated_field = "E3567853C7773291F6ADDE73672244A1")

        ClientTransaction ctx;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.289 -0400", hash_original_method = "420F244B37AE2567998EBC3FAC66EFCB", hash_generated_method = "F7A2B4C9B57CD24D4C0C2169969C8DE0")
        public  ReInviteSender(ClientTransaction ctx) {
            this.ctx = ctx;
            // ---------- Original Method ----------
            //this.ctx = ctx;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.290 -0400", hash_original_method = "05496AD165548F09E9869029BA920071", hash_generated_method = "1ADB0BBCC5965FA3A846905A0639F5FF")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.299 -0400", hash_original_method = "DA8B28F4804F3F25626961946D2074C4", hash_generated_method = "0DE3A92C6985CFA5AA5A26004E7C3BD5")
        public void run() {
            try 
            {
                long timeToWait;
                timeToWait = 0;
                long startTime;
                startTime = System.currentTimeMillis();
                {
                    boolean varCFBA9479F56B2139A22CD810CDC2D9F0_341585522 = (!SIPDialog.this.takeAckSem());
                    {
                        {
                            boolean var2AB968A8303910EE00F810B6DE3410F9_1779331062 = (sipStack.isLoggingEnabled());
                            sipStack.getStackLogger().logError(
                            "Could not send re-INVITE time out ClientTransaction");
                        } //End collapsed parenthetic
                        ((SIPClientTransaction) ctx).fireTimeoutTimer();
                        {
                            boolean var4139F5E7958AE9C2F1C82A94207591C8_1958693996 = (sipProvider.getSipListener() != null && sipProvider.getSipListener() instanceof SipListenerExt);
                            {
                                raiseErrorEvent(SIPDialogErrorEvent.DIALOG_REINVITE_TIMEOUT);
                            } //End block
                            {
                                Request byeRequest;
                                byeRequest = SIPDialog.this.createRequest(Request.BYE);
                                {
                                    boolean varD7581F5DBD86F25779F5137034C43592_1066254343 = (MessageFactoryImpl.getDefaultUserAgentHeader() != null);
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
                    boolean var269430BA4810976B135F582C3E3C146F_690940386 = (getState() != DialogState.TERMINATED);
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
                        boolean varDA2675C4DA71C7DD141330FDB85BC848_1842551752 = (sipStack.isLoggingEnabled());
                        sipStack.getStackLogger().logDebug("Interrupted sleep");
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean var8A4D69DC3EB47276971D5D31F4B6119D_110610371 = (SIPDialog.this.getState() != DialogState.TERMINATED);
                    {
                        SIPDialog.this.sendRequest(ctx, true);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var36EC98FEAC99F5AF404FDE8DC613FB19_2094395798 = (sipStack.isLoggingEnabled());
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.300 -0400", hash_original_field = "9E5A19325F636A5E87AC67BC6DE47179", hash_generated_field = "8354F9F2B7B552BE3794538038A855DB")

        private static long serialVersionUID = 1019346148741070635L;
    }


    
    class LingerTimer extends SIPStackTimerTask implements Serializable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.300 -0400", hash_original_method = "FEDA9229694989A502508E95A3FCFE54", hash_generated_method = "CF6D3A28041C64960D5CFB7948EF46EA")
        public  LingerTimer() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.308 -0400", hash_original_method = "CEEC3EAE1C5B12DC43D70E37F1A80A0A", hash_generated_method = "7401AED92285EC688655934F10252F65")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.308 -0400", hash_original_field = "7CB2C68EFA45F05A90FB1DC2EE9998C4", hash_generated_field = "A1A6593A1DD707EE1D2696D147E58630")

        int nRetransmissions;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.309 -0400", hash_original_field = "F4D5B76A2418EBA4BAEABC1ED9142B54", hash_generated_field = "9542A919750E0FF108E7D24E8ABAA715")

        SIPServerTransaction transaction;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.309 -0400", hash_original_method = "99967D6CED868AEC0B4229119C79B2A3", hash_generated_method = "06BD75BECC309B66DC13C9730079A32C")
        public  DialogTimerTask(SIPServerTransaction transaction) {
            this.transaction = transaction;
            this.nRetransmissions = 0;
            // ---------- Original Method ----------
            //this.transaction = transaction;
            //this.nRetransmissions = 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.310 -0400", hash_original_method = "7353CE022084912970B9E490A7F56F25", hash_generated_method = "E7D475921588C9121C85DC7F806C0930")
        protected void runTask() {
            SIPDialog dialog;
            dialog = SIPDialog.this;
            {
                boolean varCD7A6467843458627CC99D2CD95A9CA6_1649148567 = (sipStack.isLoggingEnabled());
                sipStack.getStackLogger().logDebug("Running dialog timer");
            } //End collapsed parenthetic
            SIPServerTransaction transaction;
            transaction = this.transaction;
            {
                {
                    boolean var4B6640D4DE774F6FA49F20C035CC9869_1147702724 = (sipProvider.getSipListener() != null && sipProvider.getSipListener() instanceof SipListenerExt);
                    {
                        raiseErrorEvent(SIPDialogErrorEvent.DIALOG_ACK_NOT_RECEIVED_TIMEOUT);
                    } //End block
                    {
                        dialog.delete();
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varB2E591CC8FE73A729A5DB2EFC02188A9_1633097617 = (transaction != null
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
                    boolean varEB9E7BA125F929A2C756DC8C1AAE09C1_1942733154 = (response.getStatusCode() == 200);
                    {
                        try 
                        {
                            {
                                boolean varC839103C0955C82229EFCA85F8C206DB_1363897226 = (dialog.toRetransmitFinalResponse(transaction.T2));
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
                                boolean var7E956449752FC9BA92CD92F85600E671_423219136 = (stack.isLoggingEnabled());
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
                boolean var4EA6B06F6CBCD1FD755A7849352DDFB9_1117287077 = (dialog.isAckSeen() || dialog.dialogState == TERMINATED_STATE);
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.316 -0400", hash_original_method = "51B842BDCF98DBC480B551988FA04041", hash_generated_method = "51B842BDCF98DBC480B551988FA04041")
        public DialogDeleteTask ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.316 -0400", hash_original_method = "705C6BB4461CC5F37E0565BB6F16C084", hash_generated_method = "12743D2452C0A21B643AFBC46E200A26")
        protected void runTask() {
            delete();
            // ---------- Original Method ----------
            //delete();
        }

        
    }


    
    class DialogDeleteIfNoAckSentTask extends SIPStackTimerTask implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.317 -0400", hash_original_field = "D8D8C9E3082C9D3CC78D718B0D250891", hash_generated_field = "979FF677F2C7A64909253E0B01090AEC")

        private long seqno;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.317 -0400", hash_original_method = "D6D7FB77E2882EBB362E9FAF3BE7D45E", hash_generated_method = "A0EA5F4F4663FCA6881081121335338B")
        public  DialogDeleteIfNoAckSentTask(long seqno) {
            this.seqno = seqno;
            // ---------- Original Method ----------
            //this.seqno = seqno;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.325 -0400", hash_original_method = "47EF190411AC9DCEBDEAD83DF8BB27D9", hash_generated_method = "AB82314E4BF01EEF576E71C35CE556B2")
        protected void runTask() {
            {
                boolean var39396AEF52D6456D6CD60D28DE63583D_1492506483 = (SIPDialog.this.highestSequenceNumberAcknowledged < seqno);
                {
                    dialogDeleteIfNoAckSentTask = null;
                    {
                        boolean var2DCCFE4A22572D9F02A458128FB13A98_792100459 = (!SIPDialog.this.isBackToBackUserAgent);
                        {
                            {
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_1016796103 = (sipStack.isLoggingEnabled());
                                sipStack.getStackLogger().logError("ACK Was not sent. killing dialog");
                            } //End collapsed parenthetic
                            {
                                boolean varB740E386243B854D0A28C1291599B3CA_610412616 = (((SipProviderImpl)sipProvider).getSipListener() instanceof SipListenerExt);
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
                                boolean var2DBDF8C316D1B42D56D4B0E041CAF41F_1053404862 = (sipStack.isLoggingEnabled());
                                sipStack.getStackLogger().logError("ACK Was not sent. Sending BYE");
                            } //End collapsed parenthetic
                            {
                                boolean varB740E386243B854D0A28C1291599B3CA_153324165 = (((SipProviderImpl)sipProvider).getSipListener() instanceof SipListenerExt);
                                {
                                    raiseErrorEvent(SIPDialogErrorEvent.DIALOG_ACK_NOT_SENT_TIMEOUT);
                                } //End block
                                {
                                    try 
                                    {
                                        Request byeRequest;
                                        byeRequest = SIPDialog.this.createRequest(Request.BYE);
                                        {
                                            boolean var53F281250CFE3DAFB9B635A8C29C3932_1628988008 = (MessageFactoryImpl.getDefaultUserAgentHeader() != null);
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.326 -0400", hash_original_field = "D26B2D15C6314569F32E9D2F4BD6FEAC", hash_generated_field = "B7ACD16AE283FE452620DE4D62C0226C")

    private static long serialVersionUID = -1429794423085204069L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.326 -0400", hash_original_field = "8917280F88F70A0C2AB25626046570AB", hash_generated_field = "0217060B0F6ACCA57DEF89D56528802E")

    public final static int NULL_STATE = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.326 -0400", hash_original_field = "AA9ACD2C29B35BE3CC1FCA5452E94A3C", hash_generated_field = "7E4774629A80511A1605FBB2145C202F")

    public final static int EARLY_STATE = DialogState._EARLY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.326 -0400", hash_original_field = "6325A488137EC86B847AA6592A566C0C", hash_generated_field = "45C6B699CF332D7B77B3EB2AD8AB7301")

    public final static int CONFIRMED_STATE = DialogState._CONFIRMED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.326 -0400", hash_original_field = "0457F6F92501361FF9C1B20BAB2C93E7", hash_generated_field = "80C37090AC7335F51D7D9FB4E1EC85B9")

    public final static int TERMINATED_STATE = DialogState._TERMINATED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.326 -0400", hash_original_field = "A7FCE49E97B902F5858568493877FAB6", hash_generated_field = "F79A56B9868DC3EF6FFB148595190CE6")

    private static int DIALOG_LINGER_TIME = 8;
}

