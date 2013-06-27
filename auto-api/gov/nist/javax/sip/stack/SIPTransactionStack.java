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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.274 -0400", hash_original_field = "BB024B2AD3D00DEB98AA88DE95E2AC00", hash_generated_field = "4492ED7A506BF07B68742FB955C2E21E")

    protected ConcurrentHashMap<String, SIPServerTransaction> retransmissionAlertTransactions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.274 -0400", hash_original_field = "986AB2740C1F225B7EDFB5003F826DDF", hash_generated_field = "6B3C62483E89DF024C432E8562DE8605")

    protected ConcurrentHashMap<String, SIPDialog> earlyDialogTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.274 -0400", hash_original_field = "02ACB7AB69D88BAD640992A93D36CD3D", hash_generated_field = "612ED1FD1C10487B0104807B8A4F66C6")

    protected ConcurrentHashMap<String, SIPDialog> dialogTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.274 -0400", hash_original_field = "2C127BF32CCB4EDF2BF22FEA5A00E494", hash_generated_field = "02D2240A23798B540E9F3183DC11EA33")

    private Timer timer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.274 -0400", hash_original_field = "08EADE4A5AD4F48C9A3F1591D2EA1815", hash_generated_field = "32E72097D41FA2F9AA2F04A4F6D94614")

    private ConcurrentHashMap<String, SIPServerTransaction> pendingTransactions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.274 -0400", hash_original_field = "135A93B3EA7CAFC3F8629197D3B561E2", hash_generated_field = "1A605FBA2863EF25462941960BB549FD")

    private ConcurrentHashMap<String, SIPClientTransaction> clientTransactionTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.274 -0400", hash_original_field = "49B61D40D424177779367ABF96FA4884", hash_generated_field = "1F786F43A2E25D3141E2216B91F6EAFE")

    protected boolean unlimitedServerTransactionTableSize = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.274 -0400", hash_original_field = "1DF7958BDE28724C5596C6BFB0E1CCB0", hash_generated_field = "DD907A7A90AC49DD39A1CAABAC88BD51")

    protected boolean unlimitedClientTransactionTableSize = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.274 -0400", hash_original_field = "076578F2E484D4FEC2562AB10277F3D5", hash_generated_field = "F4F362BB5E335440B1EB8C2B8EEC1317")

    protected int serverTransactionTableHighwaterMark = 5000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.274 -0400", hash_original_field = "7B15FFD05552BF4F9F4CD19D72A0ECFD", hash_generated_field = "5C015B93DBBC4C9D6908F3FC81146158")

    protected int serverTransactionTableLowaterMark = 4000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.274 -0400", hash_original_field = "D3F7C88BB14A5ED2F6A20C6BEBEAFDF3", hash_generated_field = "E9B62880A44C081DDF0FEB2884673E38")

    protected int clientTransactionTableHiwaterMark = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.274 -0400", hash_original_field = "06EFD544FD136F3B0F129C5103D56B95", hash_generated_field = "5D70C98F837CF3F9C68DD58DFD91E463")

    protected int clientTransactionTableLowaterMark = 800;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.274 -0400", hash_original_field = "86AE3FC892B739DBA734E71838BA8EAB", hash_generated_field = "EF538D5EF9F88F93E351A9F5CBDE10BE")

    private AtomicInteger activeClientTransactionCount = new AtomicInteger(0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.274 -0400", hash_original_field = "9EA55D2B918C0F38F9A9DFBE46C9E48E", hash_generated_field = "17FBAB4D0971040901BD780F89591315")

    private ConcurrentHashMap<String, SIPServerTransaction> serverTransactionTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.274 -0400", hash_original_field = "EE1591222A018ABE5572A5C6C0A797E9", hash_generated_field = "F435FECE20B5CE387F33C17D84BA6487")

    private ConcurrentHashMap<String, SIPServerTransaction> mergeTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.275 -0400", hash_original_field = "C755FCEA66E8CB835ECA7BD27067C11E", hash_generated_field = "811B28F45DE9105A274B1DBADE0F6CC9")

    private ConcurrentHashMap<String,SIPServerTransaction> terminatedServerTransactionsPendingAck;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.275 -0400", hash_original_field = "517069402F23F2FF9ABD60CF4C61CBE6", hash_generated_field = "71F6115AE3CDEA5C8D231C9BD5ACFE37")

    private ConcurrentHashMap<String,SIPClientTransaction> forkedClientTransactionTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.275 -0400", hash_original_field = "E36C03BD76A3345DFD7C16B0A9186E53", hash_generated_field = "1D505020FB0AD1A554D62BDC6FA8297B")

    private StackLogger stackLogger;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.275 -0400", hash_original_field = "B90EC493A5834DC9E5B17148F47193CB", hash_generated_field = "5C234A980E10BCEA9B12BAB676094BC2")

    protected ServerLogger serverLogger;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.275 -0400", hash_original_field = "2B177EBBF6652A06414D14C8C50E3B12", hash_generated_field = "1E6D363EB172CF0996091AF3F1ED1415")

    boolean udpFlag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.275 -0400", hash_original_field = "BA389B46C420BB5A0FA673A143939AC1", hash_generated_field = "EF7A4245F4BE46C3FAE858ABF7DB8188")

    protected DefaultRouter defaultRouter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.275 -0400", hash_original_field = "D77703414D2B9CECCE906E75B64E89D7", hash_generated_field = "C4FB0B708AF2FF7CDFB610A006B5BB00")

    protected boolean needsLogging;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.275 -0400", hash_original_field = "D2577D0EF3B7CF3C35702AD5E888A547", hash_generated_field = "39AC5AA3A559BB385B76BB7FCEA06FC5")

    private boolean non2XXAckPassedToListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.275 -0400", hash_original_field = "672BD3EDBEBEC18E145C8AFB0B9BDF65", hash_generated_field = "33EBA2CEF834B663ED5264FE81682D84")

    protected IOHandler ioHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.275 -0400", hash_original_field = "CD991461F11FD761BF6EFA12FCC1C1C3", hash_generated_field = "F86372B43141F18E4A8130BDC70E29CE")

    protected boolean toExit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.275 -0400", hash_original_field = "EDEF96A12B8786AA598020FE493D9164", hash_generated_field = "D4D760F2DD059CF6C01F0C862657BA20")

    protected String stackName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.275 -0400", hash_original_field = "7226454496215DAA32BEDA538263F57C", hash_generated_field = "A47D9D5247AAB165B1980C5D8E37AD58")

    protected String stackAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.275 -0400", hash_original_field = "DF199E0AE132DFDCEDCCCEAA54175F9C", hash_generated_field = "413081F93DE42EB68D8F08C864982E20")

    protected InetAddress stackInetAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.275 -0400", hash_original_field = "D189B5282758DEAD6599821789339DB3", hash_generated_field = "272D1016DEB62E744C52940A3B0E5489")

    protected StackMessageFactory sipMessageFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.275 -0400", hash_original_field = "F3395CD54CF857DDF8F2056768FF49AE", hash_generated_field = "66410D3E71DA473D001977FF3AD7B23B")

    protected javax.sip.address.Router router;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.275 -0400", hash_original_field = "CDE1F9B6C35FC856E715F186A9E26998", hash_generated_field = "C7EB24484DBA63450BB85C2FA7FA489F")

    protected int threadPoolSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.275 -0400", hash_original_field = "1ACBA9188A93F77D3F78F321F92C1912", hash_generated_field = "F74AE6C7EF47828D3A211878D3F5E9F3")

    protected int maxConnections;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.275 -0400", hash_original_field = "340B2E73CA68D1340F1704849DB20F30", hash_generated_field = "3130D9CC177F737BBD6633DB37EE5BF1")

    protected boolean cacheServerConnections;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.275 -0400", hash_original_field = "75061F79A5A3418387A8EAF6F6FAC2F2", hash_generated_field = "768D8EDFC9A10AC079EBDEBB9B0BEA2F")

    protected boolean cacheClientConnections;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.275 -0400", hash_original_field = "7024729D82FD3921C13E8300B02C1CC8", hash_generated_field = "F13115153A6685630697524CF8732D13")

    protected boolean useRouterForAll;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.275 -0400", hash_original_field = "D54EA500688687E7A49846CC9E44F277", hash_generated_field = "DDA86EBC27B96B0FE9D286E6B5C99D02")

    protected int maxContentLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.275 -0400", hash_original_field = "BF1B271FFDC69F10249067CA74EC9584", hash_generated_field = "224FB7FE4F1198F8C1E840FE28932770")

    protected int maxMessageSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.275 -0400", hash_original_field = "074A77F279327ACEE64E9D4AEEC12D99", hash_generated_field = "185A572D15C5BAB5F976AA3554E06D13")

    private Collection<MessageProcessor> messageProcessors;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.275 -0400", hash_original_field = "8FC05721DCBB3B49F66A6D283A300B5B", hash_generated_field = "29792280DB9C85168DEBC57540E5C62A")

    protected int readTimeout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.275 -0400", hash_original_field = "24D13633EB52AF9F8D6DCB3C2ED2C648", hash_generated_field = "F280B3067DE1A528C7BB767557FE00A0")

    protected NetworkLayer networkLayer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.275 -0400", hash_original_field = "96F152D1B09078C3F6C4389AB2CD6114", hash_generated_field = "2DDBEDAE711DD575D314D6FB0824162C")

    protected String outboundProxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.275 -0400", hash_original_field = "9AEE50191BBED6B0890F8E94A389A3CE", hash_generated_field = "E23BB81A391AC77E4B947A6531D7CFF7")

    protected String routerPath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.276 -0400", hash_original_field = "408464B03DDE981FC6F053CF4CA21C22", hash_generated_field = "CBEE3D1CA29ED6AAA4A0BE3A2A3FF707")

    protected boolean isAutomaticDialogSupportEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.276 -0400", hash_original_field = "36969DE269F86EBA5C778849E2D77D36", hash_generated_field = "758951DC734FED546F5FA46D0CD9E244")

    protected HashSet<String> forkedEvents;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.276 -0400", hash_original_field = "30EE0A2AF6038C82623E548CD9ED9924", hash_generated_field = "E3C6781710F35866C48FB724B6E9B0A5")

    protected boolean generateTimeStampHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.276 -0400", hash_original_field = "20CC1F9AF77D0249618487065E0355D3", hash_generated_field = "921A218F1E68F36119322B4C0375D302")

    protected AddressResolver addressResolver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.276 -0400", hash_original_field = "9A4F347B2CDD7A88BC034DE7DE1C49B1", hash_generated_field = "7A3B05571C3C337451929576D2F6F7FC")

    protected int maxListenerResponseTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.276 -0400", hash_original_field = "8CF5659616CF24E603869D9967FC496D", hash_generated_field = "A8CD57032071313BD3D43EAEB0E5D46D")

    protected boolean rfc2543Supported = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.276 -0400", hash_original_field = "06FFC9DFE8BC8EFDE045BBFE8B51D74A", hash_generated_field = "DE990737863BADB7C6E95ED63CC9DC4C")

    protected ThreadAuditor threadAuditor = new ThreadAuditor();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.276 -0400", hash_original_field = "18CF450DF0054CF7D904E6AED9045E84", hash_generated_field = "F94964197FE0E44E12A6BA7E03E51754")

    protected LogRecordFactory logRecordFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.276 -0400", hash_original_field = "597E9AB37EABE3191749A9B8F3F983E9", hash_generated_field = "3713718BCCF6B9DFEBB0EE5CDD91B58B")

    protected boolean cancelClientTransactionChecked = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.276 -0400", hash_original_field = "212D53B82E21ED6882AABA1631FD2487", hash_generated_field = "BCB26F591F1846D975D03FEA861FFBFA")

    protected boolean remoteTagReassignmentAllowed = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.276 -0400", hash_original_field = "8A1ACCA44ACB9074E8500DD26D17C77F", hash_generated_field = "046122FB4660CF86569D7745FB6062FC")

    protected boolean logStackTraceOnMessageSend = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.276 -0400", hash_original_field = "F4917C86121EC97DE5D24BA1E8E3468F", hash_generated_field = "533CF057F33E79CEE3F6C6762D967990")

    protected int receiveUdpBufferSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.276 -0400", hash_original_field = "85144B78F884888A47BFB96276FBAB05", hash_generated_field = "9F0A96DC46E2BE3FA6703B7ECEFC7E7B")

    protected int sendUdpBufferSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.276 -0400", hash_original_field = "7A750FD6F18F1DDA4E38B3D4B5023EE1", hash_generated_field = "D2F44B156E2C7DA4668C7D5F665DAB5F")

    protected boolean stackDoesCongestionControl = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.276 -0400", hash_original_field = "FCC7FD133DB713B98A4D2C108DE01B90", hash_generated_field = "C468B3795A40E24BFA5E22186F8BD92C")

    protected boolean isBackToBackUserAgent = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.276 -0400", hash_original_field = "C6F8194A1D5AF33E9A729F0C8D674D41", hash_generated_field = "30B91514890DCCCE1053BFD830B93F8D")

    protected boolean checkBranchId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.276 -0400", hash_original_field = "DFB941AD6D02702CD41F36C2DCE642A9", hash_generated_field = "2CEA2AC21B7A7C73026A335F4F3A56EB")

    protected boolean isAutomaticDialogErrorHandlingEnabled = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.276 -0400", hash_original_field = "92DDCC06D1B886C4810373F4B5BD040A", hash_generated_field = "8D5939440DC97D0AD4D778E8F452B5A4")

    protected boolean isDialogTerminatedEventDeliveredForNullDialog = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.276 -0400", hash_original_field = "762E796CA8120FD35AC69FAC3C50EC48", hash_generated_field = "67828BA276FD46633F0EC0FF51519F0E")

    protected int maxForkTime = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.290 -0400", hash_original_method = "58A99E16B05D3536C850145BF176F1CB", hash_generated_method = "2E3C3B3675AC7D72F3E9CA5D2DECC008")
    protected  SIPTransactionStack() {
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
            boolean var4926B8FB396A99BDD38AA02CC358790B_858389223 = (getThreadAuditor().isEnabled());
            {
                timer.schedule(new PingTimer(null), 0);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.293 -0400", hash_original_method = "A949ED7F371D2CEC2724714D98F74A81", hash_generated_method = "766B055A4B71BEB66FBCFDFD4443B1FF")
    protected  SIPTransactionStack(StackMessageFactory messageFactory) {
        this();
        this.sipMessageFactory = messageFactory;
        // ---------- Original Method ----------
        //this.sipMessageFactory = messageFactory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.294 -0400", hash_original_method = "4C95AA981C09EEAD5B31E73DC1384B23", hash_generated_method = "7FFA8F45A19FC7DDC575A3D229866AD6")
    protected void reInit() {
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_872459698 = (stackLogger.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.299 -0400", hash_original_method = "5E8E9B567A338F9125BE752CD1B53E0E", hash_generated_method = "04B42BE92C6AF7FFCD3AEF3AF4DC5E86")
    public SocketAddress obtainLocalAddress(InetAddress dst, int dstPort,
                    InetAddress localAddress, int localPort) throws IOException {
        SocketAddress varB4EAC82CA7396A68D541C85D26508E83_571954640 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_571954640 = this.ioHandler.obtainLocalAddress(
                        dst, dstPort, localAddress, localPort);
        addTaint(dst.getTaint());
        addTaint(dstPort);
        addTaint(localAddress.getTaint());
        addTaint(localPort);
        varB4EAC82CA7396A68D541C85D26508E83_571954640.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_571954640;
        // ---------- Original Method ----------
        //return this.ioHandler.obtainLocalAddress(
                        //dst, dstPort, localAddress, localPort);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.299 -0400", hash_original_method = "6F4F1101C93AB1BC6C07B08D53A20694", hash_generated_method = "5AECE98B1061B15974070DD2B205769A")
    public void disableLogging() {
        this.getStackLogger().disableLogging();
        // ---------- Original Method ----------
        //this.getStackLogger().disableLogging();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.304 -0400", hash_original_method = "28B9C3C3AF577CC75DD224D050447CF4", hash_generated_method = "DD4A6695D325CC79611C0DADF7845085")
    public void enableLogging() {
        this.getStackLogger().enableLogging();
        // ---------- Original Method ----------
        //this.getStackLogger().enableLogging();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.309 -0400", hash_original_method = "F0A4CF0EC627D6BB4B7444677CFA585E", hash_generated_method = "7FF71FA69FDB9AC4D74F63FBB96051BF")
    public void printDialogTable() {
        {
            boolean var53869E3A88D96F4415B2EAEAC904AA86_841092217 = (isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.310 -0400", hash_original_method = "A39FC22DA230CCE4243CA37C766915B4", hash_generated_method = "C60B589429D87F5761FC58DABC9AE148")
    public SIPServerTransaction getRetransmissionAlertTransaction(String dialogId) {
        SIPServerTransaction varB4EAC82CA7396A68D541C85D26508E83_298606951 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_298606951 = (SIPServerTransaction) this.retransmissionAlertTransactions.get(dialogId);
        addTaint(dialogId.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_298606951.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_298606951;
        // ---------- Original Method ----------
        //return (SIPServerTransaction) this.retransmissionAlertTransactions.get(dialogId);
    }

    
        public static boolean isDialogCreated(String method) {
        return dialogCreatingMethods.contains(method);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.310 -0400", hash_original_method = "BEE1BC405D1C6F3176E5E5958D511DC6", hash_generated_method = "340D972FCC99856832C760D57B3A4C14")
    public void addExtensionMethod(String extensionMethod) {
        {
            boolean varAD3BC2900BC07B79F07970DF4CB3E3F0_621959482 = (extensionMethod.equals(Request.NOTIFY));
            {
                {
                    boolean varAC370D5D69DCACC466AEF155D6729732_1304828709 = (stackLogger.isLoggingEnabled());
                    stackLogger.logDebug("NOTIFY Supported Natively");
                } //End collapsed parenthetic
            } //End block
            {
                dialogCreatingMethods.add(extensionMethod.trim().toUpperCase());
            } //End block
        } //End collapsed parenthetic
        addTaint(extensionMethod.getTaint());
        // ---------- Original Method ----------
        //if (extensionMethod.equals(Request.NOTIFY)) {
            //if (stackLogger.isLoggingEnabled())
                //stackLogger.logDebug("NOTIFY Supported Natively");
        //} else {
            //dialogCreatingMethods.add(extensionMethod.trim().toUpperCase());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.311 -0400", hash_original_method = "3AD47119D9E3B66FC61FF1D5407F3E89", hash_generated_method = "75C23C026BC6E09470BFE6DE87BAA2B2")
    public void putDialog(SIPDialog dialog) {
        String dialogId;
        dialogId = dialog.getDialogId();
        {
            boolean var1C796C75795040E4DB7CADAEB51198DB_1183805968 = (dialogTable.containsKey(dialogId));
            {
                {
                    boolean varAC370D5D69DCACC466AEF155D6729732_1391360682 = (stackLogger.isLoggingEnabled());
                    {
                        stackLogger.logDebug("putDialog: dialog already exists" + dialogId + " in table = "
                        + dialogTable.get(dialogId));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_1561232367 = (stackLogger.isLoggingEnabled());
            {
                stackLogger.logDebug("putDialog dialogId=" + dialogId + " dialog = " + dialog);
            } //End block
        } //End collapsed parenthetic
        dialog.setStack(this);
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_1589549889 = (stackLogger.isLoggingEnabled());
            stackLogger.logStackTrace();
        } //End collapsed parenthetic
        dialogTable.put(dialogId, dialog);
        addTaint(dialog.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.319 -0400", hash_original_method = "E7A6CF8B50F165B49D6E8637D9CBF9BD", hash_generated_method = "F54C6D96E10F4C6217D7B810AF8EABF1")
    public SIPDialog createDialog(SIPTransaction transaction) {
        SIPDialog varB4EAC82CA7396A68D541C85D26508E83_1700426499 = null; //Variable for return #1
        SIPDialog retval;
        retval = null;
        {
            String dialogId;
            dialogId = ((SIPRequest) transaction.getRequest()).getDialogId(false);
            {
                boolean var9131AA4695C2C63B631C355FB2D06559_2122991652 = (this.earlyDialogTable.get(dialogId) != null);
                {
                    SIPDialog dialog;
                    dialog = this.earlyDialogTable.get(dialogId);
                    {
                        boolean var402523BFFAD41D51F96075592CB2DE30_914570663 = (dialog.getState() == null || dialog.getState() == DialogState.EARLY);
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
        varB4EAC82CA7396A68D541C85D26508E83_1700426499 = retval;
        addTaint(transaction.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1700426499.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1700426499;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.320 -0400", hash_original_method = "077BDE7287D2ACDD7F2A84D6156CB0F7", hash_generated_method = "CAD10DF123288DD217FBBA185737B685")
    public SIPDialog createDialog(SIPClientTransaction transaction, SIPResponse sipResponse) {
        SIPDialog varB4EAC82CA7396A68D541C85D26508E83_1591922840 = null; //Variable for return #1
        String dialogId;
        dialogId = ((SIPRequest) transaction.getRequest()).getDialogId(false);
        SIPDialog retval;
        retval = null;
        {
            boolean var4AD019C6981F78972549CB283CBD152C_818576464 = (this.earlyDialogTable.get(dialogId) != null);
            {
                retval = this.earlyDialogTable.get(dialogId);
                {
                    boolean varE9352942E72C1D75CE5290CFFD4E7B6C_1776780273 = (sipResponse.isFinalResponse());
                    {
                        this.earlyDialogTable.remove(dialogId);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                retval = new SIPDialog(transaction, sipResponse);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1591922840 = retval;
        addTaint(transaction.getTaint());
        addTaint(sipResponse.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1591922840.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1591922840;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.321 -0400", hash_original_method = "C8019EE35E2246E727D64B4FEC692BA7", hash_generated_method = "5138839FE91EB8187D8BC4E834F25752")
    public SIPDialog createDialog(SipProviderImpl sipProvider,
			SIPResponse sipResponse) {
        SIPDialog varB4EAC82CA7396A68D541C85D26508E83_495460330 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_495460330 = new SIPDialog(sipProvider, sipResponse);
        addTaint(sipProvider.getTaint());
        addTaint(sipResponse.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_495460330.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_495460330;
        // ---------- Original Method ----------
        //return new SIPDialog(sipProvider, sipResponse);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.321 -0400", hash_original_method = "C20BEEC896962D7D1856EB72C0C34791", hash_generated_method = "5376D6777D95337212148B1396A1B13F")
    public void removeDialog(SIPDialog dialog) {
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
                boolean var35096A2446A1B79EB944A5339DDF5D2F_1706911784 = (!dialog.testAndSetIsDialogTerminatedEventDelivered());
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
                boolean var35096A2446A1B79EB944A5339DDF5D2F_1743538889 = (!dialog.testAndSetIsDialogTerminatedEventDelivered());
                {
                    DialogTerminatedEvent event;
                    event = new DialogTerminatedEvent(dialog.getSipProvider(),
                        dialog);
                    dialog.getSipProvider().handleEvent(event, null);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(dialog.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.333 -0400", hash_original_method = "7CD5A4CB12647D3BBBFDC040A2B5E183", hash_generated_method = "B25F83077A854E1F34670D9C02EEDABA")
    public SIPDialog getDialog(String dialogId) {
        SIPDialog varB4EAC82CA7396A68D541C85D26508E83_423430356 = null; //Variable for return #1
        SIPDialog sipDialog;
        sipDialog = (SIPDialog) dialogTable.get(dialogId);
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_899861796 = (stackLogger.isLoggingEnabled());
            {
                stackLogger.logDebug("getDialog(" + dialogId + ") : returning " + sipDialog);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_423430356 = sipDialog;
        addTaint(dialogId.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_423430356.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_423430356;
        // ---------- Original Method ----------
        //SIPDialog sipDialog = (SIPDialog) dialogTable.get(dialogId);
        //if (stackLogger.isLoggingEnabled()) {
            //stackLogger.logDebug("getDialog(" + dialogId + ") : returning " + sipDialog);
        //}
        //return sipDialog;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.334 -0400", hash_original_method = "B0D51307A4FC266FC1D02389AEE54D05", hash_generated_method = "C5DEE203B4903D3C236E1FC5E0648217")
    public void removeDialog(String dialogId) {
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_804632870 = (stackLogger.isLoggingEnabled());
            {
                stackLogger.logWarning("Silently removing dialog from table");
            } //End block
        } //End collapsed parenthetic
        dialogTable.remove(dialogId);
        addTaint(dialogId.getTaint());
        // ---------- Original Method ----------
        //if (stackLogger.isLoggingEnabled()) {
            //stackLogger.logWarning("Silently removing dialog from table");
        //}
        //dialogTable.remove(dialogId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.346 -0400", hash_original_method = "5BA8167D6AC26A2C080E0DF071E238DD", hash_generated_method = "52B969EC6632AB527F952A8351D9FEA6")
    public SIPClientTransaction findSubscribeTransaction(SIPRequest notifyMessage,
            ListeningPointImpl listeningPoint) {
        SIPClientTransaction varB4EAC82CA7396A68D541C85D26508E83_1539925519 = null; //Variable for return #1
        SIPClientTransaction varB4EAC82CA7396A68D541C85D26508E83_1800209160 = null; //Variable for return #2
        SIPClientTransaction varB4EAC82CA7396A68D541C85D26508E83_1100220262 = null; //Variable for return #3
        SIPClientTransaction varB4EAC82CA7396A68D541C85D26508E83_893411574 = null; //Variable for return #4
        SIPClientTransaction retval;
        retval = null;
        try 
        {
            Iterator it;
            it = clientTransactionTable.values().iterator();
            {
                boolean varCEA0B8AAFFB6C70BF01D444180FAAB1F_271762573 = (stackLogger.isLoggingEnabled());
                stackLogger.logDebug("ct table size = " + clientTransactionTable.size());
            } //End collapsed parenthetic
            String thisToTag;
            thisToTag = notifyMessage.getTo().getTag();
            {
                varB4EAC82CA7396A68D541C85D26508E83_1539925519 = retval;
            } //End block
            Event eventHdr;
            eventHdr = (Event) notifyMessage.getHeader(EventHeader.NAME);
            {
                {
                    boolean varAC370D5D69DCACC466AEF155D6729732_845095337 = (stackLogger.isLoggingEnabled());
                    {
                        stackLogger.logDebug("event Header is null -- returning null");
                    } //End block
                } //End collapsed parenthetic
                varB4EAC82CA7396A68D541C85D26508E83_1800209160 = retval;
            } //End block
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1175782696 = (it.hasNext());
                {
                    SIPClientTransaction ct;
                    ct = (SIPClientTransaction) it.next();
                    {
                        boolean varCFF1A0705DCC3B6E112E467A6D493F5D_503431492 = (!ct.getMethod().equals(Request.SUBSCRIBE));
                    } //End collapsed parenthetic
                    String fromTag;
                    fromTag = ct.from.getTag();
                    Event hisEvent;
                    hisEvent = ct.event;
                    {
                        boolean varD2993363F7AFB86CA04E191D1274040B_520147385 = (stackLogger.isLoggingEnabled());
                        {
                            stackLogger.logDebug("ct.fromTag = " + fromTag);
                            stackLogger.logDebug("thisToTag = " + thisToTag);
                            stackLogger.logDebug("hisEvent = " + hisEvent);
                            stackLogger.logDebug("eventHdr " + eventHdr);
                        } //End block
                    } //End collapsed parenthetic
                    {
                        boolean var6ED9F094D5E7B37CADC33B9F7291C0D3_1522045436 = (fromTag.equalsIgnoreCase(thisToTag)
                      && hisEvent != null
                      && eventHdr.match(hisEvent)
                      && notifyMessage.getCallId().getCallId().equalsIgnoreCase(
                                ct.callId.getCallId()));
                        {
                            {
                                boolean var9282859C10B3BDA9643C67160A68D9EE_44450533 = (ct.acquireSem());
                                retval = ct;
                            } //End collapsed parenthetic
                            varB4EAC82CA7396A68D541C85D26508E83_1100220262 = retval;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_893411574 = retval;
        } //End block
        finally 
        {
            {
                boolean varCEA0B8AAFFB6C70BF01D444180FAAB1F_1624582886 = (stackLogger.isLoggingEnabled());
                stackLogger.logDebug("findSubscribeTransaction : returning " + retval);
            } //End collapsed parenthetic
        } //End block
        addTaint(notifyMessage.getTaint());
        addTaint(listeningPoint.getTaint());
        SIPClientTransaction varA7E53CE21691AB073D9660D615818899_685263962; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_685263962 = varB4EAC82CA7396A68D541C85D26508E83_1539925519;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_685263962 = varB4EAC82CA7396A68D541C85D26508E83_1800209160;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_685263962 = varB4EAC82CA7396A68D541C85D26508E83_1100220262;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_685263962 = varB4EAC82CA7396A68D541C85D26508E83_893411574;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_685263962.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_685263962;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.347 -0400", hash_original_method = "D49C9B94E89B7FEA3320280273306438", hash_generated_method = "F90D32E584EF24DDC40255D1329DAA8C")
    public void addTransactionPendingAck(SIPServerTransaction serverTransaction) {
        String branchId;
        branchId = ((SIPRequest)serverTransaction.getRequest()).getTopmostVia().getBranch();
        {
            this.terminatedServerTransactionsPendingAck.put(branchId, serverTransaction);
        } //End block
        addTaint(serverTransaction.getTaint());
        // ---------- Original Method ----------
        //String branchId = ((SIPRequest)serverTransaction.getRequest()).getTopmostVia().getBranch();
        //if ( branchId != null ) {
            //this.terminatedServerTransactionsPendingAck.put(branchId, serverTransaction);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.347 -0400", hash_original_method = "37709198085D538D169FF1DE9D9ADB9C", hash_generated_method = "E50AB206208F2CF10F0A84561396DCB5")
    public SIPServerTransaction findTransactionPendingAck(SIPRequest ackMessage) {
        SIPServerTransaction varB4EAC82CA7396A68D541C85D26508E83_1789412 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1789412 = this.terminatedServerTransactionsPendingAck.get(ackMessage.getTopmostVia().getBranch());
        addTaint(ackMessage.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1789412.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1789412;
        // ---------- Original Method ----------
        //return this.terminatedServerTransactionsPendingAck.get(ackMessage.getTopmostVia().getBranch());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.400 -0400", hash_original_method = "B481CD0C272F0294325516CB58C4D625", hash_generated_method = "19F4FF36A0EDC2529919EEF2D85C46AE")
    public boolean removeTransactionPendingAck(SIPServerTransaction serverTransaction) {
        String branchId;
        branchId = ((SIPRequest)serverTransaction.getRequest()).getTopmostVia().getBranch();
        {
            boolean varEBE195BF36968B3D949EA3A425E49317_8802749 = (branchId != null && this.terminatedServerTransactionsPendingAck.containsKey(branchId));
            {
                this.terminatedServerTransactionsPendingAck.remove(branchId);
            } //End block
        } //End collapsed parenthetic
        addTaint(serverTransaction.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_296783534 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_296783534;
        // ---------- Original Method ----------
        //String branchId = ((SIPRequest)serverTransaction.getRequest()).getTopmostVia().getBranch();
        //if ( branchId != null && this.terminatedServerTransactionsPendingAck.containsKey(branchId) ) {
            //this.terminatedServerTransactionsPendingAck.remove(branchId);
            //return true;
        //} else {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.401 -0400", hash_original_method = "E118D63661EEDB81E619AEC2D5F479DE", hash_generated_method = "1D5A621D801C8C995AD5AED4392883A7")
    public boolean isTransactionPendingAck(SIPServerTransaction serverTransaction) {
        String branchId;
        branchId = ((SIPRequest)serverTransaction.getRequest()).getTopmostVia().getBranch();
        boolean var4577C4FD500FC681BA07DFDB97EB4243_1530562739 = (this.terminatedServerTransactionsPendingAck.contains(branchId));
        addTaint(serverTransaction.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1648499703 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1648499703;
        // ---------- Original Method ----------
        //String branchId = ((SIPRequest)serverTransaction.getRequest()).getTopmostVia().getBranch();
        //return this.terminatedServerTransactionsPendingAck.contains(branchId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.403 -0400", hash_original_method = "CFF098965464555AD1B1F596C34C16A1", hash_generated_method = "83A975F10045A4EDD5E28990AB47102E")
    public SIPTransaction findTransaction(SIPMessage sipMessage, boolean isServer) {
        SIPTransaction varB4EAC82CA7396A68D541C85D26508E83_1178826872 = null; //Variable for return #1
        SIPTransaction varB4EAC82CA7396A68D541C85D26508E83_1573803251 = null; //Variable for return #2
        SIPTransaction varB4EAC82CA7396A68D541C85D26508E83_1044320742 = null; //Variable for return #3
        SIPTransaction varB4EAC82CA7396A68D541C85D26508E83_1531734065 = null; //Variable for return #4
        SIPTransaction varB4EAC82CA7396A68D541C85D26508E83_963310042 = null; //Variable for return #5
        SIPTransaction retval;
        retval = null;
        try 
        {
            {
                Via via;
                via = sipMessage.getTopmostVia();
                {
                    boolean var240DE521E282CF4DDD1501CDC8DEB0BE_1184628693 = (via.getBranch() != null);
                    {
                        String key;
                        key = sipMessage.getTransactionId();
                        retval = (SIPTransaction) serverTransactionTable.get(key);
                        {
                            boolean varDFC91DFB4BB95E42F71B00E05C1AFFB9_1931397531 = (stackLogger.isLoggingEnabled());
                            getStackLogger().logDebug(
                                "serverTx: looking for key " + key + " existing="
                                + serverTransactionTable);
                        } //End collapsed parenthetic
                        {
                            boolean var824837A9145CA2EC03C0E877A985B1E6_251348152 = (key.startsWith(SIPConstants.BRANCH_MAGIC_COOKIE_LOWER_CASE));
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_1178826872 = retval;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                Iterator<SIPServerTransaction> it;
                it = serverTransactionTable.values().iterator();
                {
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_785023655 = (it.hasNext());
                    {
                        SIPServerTransaction sipServerTransaction;
                        sipServerTransaction = (SIPServerTransaction) it.next();
                        {
                            boolean varF6051FB334F93F8949404856131DFA0F_781972603 = (sipServerTransaction.isMessagePartOfTransaction(sipMessage));
                            {
                                retval = sipServerTransaction;
                                varB4EAC82CA7396A68D541C85D26508E83_1573803251 = retval;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                Via via;
                via = sipMessage.getTopmostVia();
                {
                    boolean var240DE521E282CF4DDD1501CDC8DEB0BE_1398914798 = (via.getBranch() != null);
                    {
                        String key;
                        key = sipMessage.getTransactionId();
                        {
                            boolean varDFC91DFB4BB95E42F71B00E05C1AFFB9_361529096 = (stackLogger.isLoggingEnabled());
                            getStackLogger().logDebug("clientTx: looking for key " + key);
                        } //End collapsed parenthetic
                        retval = (SIPTransaction) clientTransactionTable.get(key);
                        {
                            boolean var824837A9145CA2EC03C0E877A985B1E6_1508513568 = (key.startsWith(SIPConstants.BRANCH_MAGIC_COOKIE_LOWER_CASE));
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_1044320742 = retval;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                Iterator<SIPClientTransaction> it;
                it = clientTransactionTable.values().iterator();
                {
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_1768767248 = (it.hasNext());
                    {
                        SIPClientTransaction clientTransaction;
                        clientTransaction = (SIPClientTransaction) it.next();
                        {
                            boolean var35F8E4FD38F5FA1A650C87F5120892B2_1751186501 = (clientTransaction.isMessagePartOfTransaction(sipMessage));
                            {
                                retval = clientTransaction;
                                varB4EAC82CA7396A68D541C85D26508E83_1531734065 = retval;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        finally 
        {
            {
                boolean varDED775332D522DB4765B6C0D6DAB9C7F_2113930784 = (this.getStackLogger().isLoggingEnabled());
                {
                    this.getStackLogger().logDebug("findTransaction: returning  : " + retval);
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_963310042 = retval;
        addTaint(sipMessage.getTaint());
        addTaint(isServer);
        SIPTransaction varA7E53CE21691AB073D9660D615818899_1529812574; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1529812574 = varB4EAC82CA7396A68D541C85D26508E83_1178826872;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1529812574 = varB4EAC82CA7396A68D541C85D26508E83_1573803251;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1529812574 = varB4EAC82CA7396A68D541C85D26508E83_1044320742;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1529812574 = varB4EAC82CA7396A68D541C85D26508E83_1531734065;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1529812574 = varB4EAC82CA7396A68D541C85D26508E83_963310042;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1529812574.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1529812574;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.409 -0400", hash_original_method = "EBA76BEAE03DA80AC45DCE1E9705412D", hash_generated_method = "BA121113DA634A079DD760FC67175DAA")
    public SIPTransaction findCancelTransaction(SIPRequest cancelRequest, boolean isServer) {
        SIPTransaction varB4EAC82CA7396A68D541C85D26508E83_985469709 = null; //Variable for return #1
        SIPTransaction varB4EAC82CA7396A68D541C85D26508E83_698317859 = null; //Variable for return #2
        SIPTransaction varB4EAC82CA7396A68D541C85D26508E83_1325432676 = null; //Variable for return #3
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_869490657 = (stackLogger.isLoggingEnabled());
            {
                stackLogger.logDebug("findCancelTransaction request= \n" + cancelRequest
                    + "\nfindCancelRequest isServer=" + isServer);
            } //End block
        } //End collapsed parenthetic
        {
            Iterator<SIPServerTransaction> li;
            li = this.serverTransactionTable.values().iterator();
            {
                boolean varD1722E42EA3CA8952F93B6521D875E61_177834941 = (li.hasNext());
                {
                    SIPTransaction transaction;
                    transaction = (SIPTransaction) li.next();
                    SIPServerTransaction sipServerTransaction;
                    sipServerTransaction = (SIPServerTransaction) transaction;
                    {
                        boolean var63C9AAE72219DF269358A97F4B9DD737_232823150 = (sipServerTransaction.doesCancelMatchTransaction(cancelRequest));
                        varB4EAC82CA7396A68D541C85D26508E83_985469709 = sipServerTransaction;
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            Iterator<SIPClientTransaction> li;
            li = this.clientTransactionTable.values().iterator();
            {
                boolean varD1722E42EA3CA8952F93B6521D875E61_122641963 = (li.hasNext());
                {
                    SIPTransaction transaction;
                    transaction = (SIPTransaction) li.next();
                    SIPClientTransaction sipClientTransaction;
                    sipClientTransaction = (SIPClientTransaction) transaction;
                    {
                        boolean varAEAD15F06F6B78E29169322410091CA1_100159565 = (sipClientTransaction.doesCancelMatchTransaction(cancelRequest));
                        varB4EAC82CA7396A68D541C85D26508E83_698317859 = sipClientTransaction;
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_118583550 = (stackLogger.isLoggingEnabled());
            stackLogger.logDebug("Could not find transaction for cancel request");
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1325432676 = null;
        addTaint(cancelRequest.getTaint());
        addTaint(isServer);
        SIPTransaction varA7E53CE21691AB073D9660D615818899_1567185833; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1567185833 = varB4EAC82CA7396A68D541C85D26508E83_985469709;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1567185833 = varB4EAC82CA7396A68D541C85D26508E83_698317859;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1567185833 = varB4EAC82CA7396A68D541C85D26508E83_1325432676;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1567185833.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1567185833;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.409 -0400", hash_original_method = "C32886C5E5EF95CE74E82DCEA7E677B6", hash_generated_method = "32D12A7401781BB7804C70FCCC326B92")
    public SIPServerTransaction findPendingTransaction(SIPRequest requestReceived) {
        SIPServerTransaction varB4EAC82CA7396A68D541C85D26508E83_1474856143 = null; //Variable for return #1
        {
            boolean var11C62F83477FD0505FB5BB12080FBCDA_2007156656 = (this.stackLogger.isLoggingEnabled());
            {
                this.stackLogger.logDebug("looking for pending tx for :"
                    + requestReceived.getTransactionId());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1474856143 = (SIPServerTransaction) pendingTransactions.get(requestReceived.getTransactionId());
        addTaint(requestReceived.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1474856143.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1474856143;
        // ---------- Original Method ----------
        //if (this.stackLogger.isLoggingEnabled()) {
            //this.stackLogger.logDebug("looking for pending tx for :"
                    //+ requestReceived.getTransactionId());
        //}
        //return (SIPServerTransaction) pendingTransactions.get(requestReceived.getTransactionId());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.448 -0400", hash_original_method = "DE7BCEF3CEAF7F5E4F7BCE647A148129", hash_generated_method = "CBB280EE1620FCE3D26022DE12226159")
    public SIPServerTransaction findMergedTransaction(SIPRequest sipRequest) {
        SIPServerTransaction varB4EAC82CA7396A68D541C85D26508E83_394593348 = null; //Variable for return #1
        SIPServerTransaction varB4EAC82CA7396A68D541C85D26508E83_615949907 = null; //Variable for return #2
        SIPServerTransaction varB4EAC82CA7396A68D541C85D26508E83_482549218 = null; //Variable for return #3
        SIPServerTransaction varB4EAC82CA7396A68D541C85D26508E83_90272600 = null; //Variable for return #4
        SIPServerTransaction varB4EAC82CA7396A68D541C85D26508E83_432544227 = null; //Variable for return #5
        {
            boolean varEB91205F9E3B5AB16C809B69E830E585_1304259687 = (! sipRequest.getMethod().equals(Request.INVITE));
            {
                varB4EAC82CA7396A68D541C85D26508E83_394593348 = null;
            } //End block
        } //End collapsed parenthetic
        String mergeId;
        mergeId = sipRequest.getMergeId();
        SIPServerTransaction mergedTransaction;
        mergedTransaction = (SIPServerTransaction) this.mergeTable.get(mergeId);
        {
            varB4EAC82CA7396A68D541C85D26508E83_615949907 = null;
        } //End block
        {
            boolean varDD5DC8FFD549FCFBE54C0C4063924793_2145961612 = (mergedTransaction != null && !mergedTransaction.isMessagePartOfTransaction(sipRequest));
            {
                varB4EAC82CA7396A68D541C85D26508E83_482549218 = mergedTransaction;
            } //End block
            {
                {
                    Iterator<Dialog> var13FA49F9AC884432F840638793CBDD7F_931042843 = (this.dialogTable.values()).iterator();
                    var13FA49F9AC884432F840638793CBDD7F_931042843.hasNext();
                    Dialog dialog = var13FA49F9AC884432F840638793CBDD7F_931042843.next();
                    {
                        SIPDialog sipDialog;
                        sipDialog = (SIPDialog) dialog;
                        {
                            boolean varF35A178555525ACF54ED52DD1E0580BB_1468772257 = (sipDialog.getFirstTransaction()  != null && 
                   sipDialog.getFirstTransaction() instanceof ServerTransaction);
                            {
                                SIPServerTransaction serverTransaction;
                                serverTransaction = ((SIPServerTransaction) sipDialog.getFirstTransaction());
                                SIPRequest transactionRequest;
                                transactionRequest = ((SIPServerTransaction) sipDialog.getFirstTransaction()).getOriginalRequest();
                                {
                                    boolean var38302743A39D1C992E94EBEE863951D6_2133063400 = ((! serverTransaction.isMessagePartOfTransaction(sipRequest))
                           && sipRequest.getMergeId().equals(transactionRequest.getMergeId()));
                                    {
                                        varB4EAC82CA7396A68D541C85D26508E83_90272600 = (SIPServerTransaction) sipDialog.getFirstTransaction();
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                varB4EAC82CA7396A68D541C85D26508E83_432544227 = null;
            } //End block
        } //End collapsed parenthetic
        addTaint(sipRequest.getTaint());
        SIPServerTransaction varA7E53CE21691AB073D9660D615818899_1510259468; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1510259468 = varB4EAC82CA7396A68D541C85D26508E83_394593348;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1510259468 = varB4EAC82CA7396A68D541C85D26508E83_615949907;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1510259468 = varB4EAC82CA7396A68D541C85D26508E83_482549218;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1510259468 = varB4EAC82CA7396A68D541C85D26508E83_90272600;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1510259468 = varB4EAC82CA7396A68D541C85D26508E83_432544227;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1510259468.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1510259468;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.455 -0400", hash_original_method = "365415518ECAE79EAD0CD2C9D4462A78", hash_generated_method = "28FAD46461AA85903675910E96E76EDE")
    public void removePendingTransaction(SIPServerTransaction tr) {
        {
            boolean var11C62F83477FD0505FB5BB12080FBCDA_1776781444 = (this.stackLogger.isLoggingEnabled());
            {
                this.stackLogger.logDebug("removePendingTx: " + tr.getTransactionId());
            } //End block
        } //End collapsed parenthetic
        this.pendingTransactions.remove(tr.getTransactionId());
        addTaint(tr.getTaint());
        // ---------- Original Method ----------
        //if (this.stackLogger.isLoggingEnabled()) {
            //this.stackLogger.logDebug("removePendingTx: " + tr.getTransactionId());
        //}
        //this.pendingTransactions.remove(tr.getTransactionId());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.455 -0400", hash_original_method = "DB6ED2CEA840316B4782573C88C3E1FC", hash_generated_method = "12BA75A1CA63612DC9145D58D1C55432")
    public void removeFromMergeTable(SIPServerTransaction tr) {
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_1871032017 = (stackLogger.isLoggingEnabled());
            {
                this.stackLogger.logDebug("Removing tx from merge table ");
            } //End block
        } //End collapsed parenthetic
        String key;
        key = ((SIPRequest) tr.getRequest()).getMergeId();
        {
            this.mergeTable.remove(key);
        } //End block
        addTaint(tr.getTaint());
        // ---------- Original Method ----------
        //if (stackLogger.isLoggingEnabled()) {
            //this.stackLogger.logDebug("Removing tx from merge table ");
        //}
        //String key = ((SIPRequest) tr.getRequest()).getMergeId();
        //if (key != null) {
            //this.mergeTable.remove(key);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.455 -0400", hash_original_method = "4DF3A9A601EFF55EEB4CCC4D0E1A4382", hash_generated_method = "214FA5ED9F021DB03AAAA39CC0F3A2EE")
    public void putInMergeTable(SIPServerTransaction sipTransaction, SIPRequest sipRequest) {
        String mergeKey;
        mergeKey = sipRequest.getMergeId();
        {
            this.mergeTable.put(mergeKey, sipTransaction);
        } //End block
        addTaint(sipTransaction.getTaint());
        addTaint(sipRequest.getTaint());
        // ---------- Original Method ----------
        //String mergeKey = sipRequest.getMergeId();
        //if (mergeKey != null) {
            //this.mergeTable.put(mergeKey, sipTransaction);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.459 -0400", hash_original_method = "8109166214A5696534573E329912E2B5", hash_generated_method = "8CD4392F319236190EC8ABBEE623354A")
    public void mapTransaction(SIPServerTransaction transaction) {
        addTransactionHash(transaction);
        transaction.isMapped = true;
        addTaint(transaction.getTaint());
        // ---------- Original Method ----------
        //if (transaction.isMapped)
            //return;
        //addTransactionHash(transaction);
        //transaction.isMapped = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.476 -0400", hash_original_method = "C3F915B9919F99B9388976510DFE400E", hash_generated_method = "D7235D5669E03B47D14009929137211A")
    public ServerRequestInterface newSIPServerRequest(SIPRequest requestReceived,
            MessageChannel requestMessageChannel) {
        ServerRequestInterface varB4EAC82CA7396A68D541C85D26508E83_1762355666 = null; //Variable for return #1
        ServerRequestInterface varB4EAC82CA7396A68D541C85D26508E83_1187938946 = null; //Variable for return #2
        ServerRequestInterface varB4EAC82CA7396A68D541C85D26508E83_2132007556 = null; //Variable for return #3
        ServerRequestInterface varB4EAC82CA7396A68D541C85D26508E83_2146745019 = null; //Variable for return #4
        ServerRequestInterface varB4EAC82CA7396A68D541C85D26508E83_632612141 = null; //Variable for return #5
        Iterator<SIPServerTransaction> transactionIterator;
        SIPServerTransaction nextTransaction;
        SIPServerTransaction currentTransaction;
        String key;
        key = requestReceived.getTransactionId();
        requestReceived.setMessageChannel(requestMessageChannel);
        currentTransaction = (SIPServerTransaction) serverTransactionTable.get(key);
        {
            boolean varD5F22D6501778D69EFB1B4C78D1BC071_789046999 = (currentTransaction == null
                || !currentTransaction.isMessagePartOfTransaction(requestReceived));
            {
                transactionIterator = serverTransactionTable.values().iterator();
                currentTransaction = null;
                {
                    boolean varDF525999E4178F83F821F7840AF0A701_1914754057 = (!key.toLowerCase().startsWith(SIPConstants.BRANCH_MAGIC_COOKIE_LOWER_CASE));
                    {
                        {
                            boolean varE06F989DC131B262AEF6DA55B8F8DDB2_511475344 = (transactionIterator.hasNext() && currentTransaction == null);
                            {
                                nextTransaction = (SIPServerTransaction) transactionIterator.next();
                                {
                                    boolean var7384431C022BEE094664534666A1D7AF_1712879273 = (nextTransaction.isMessagePartOfTransaction(requestReceived));
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
                            boolean varC390E2A5DFAA4F7FA1689CB7638E2EB7_492599479 = (currentTransaction != null && currentTransaction.acquireSem());
                            varB4EAC82CA7396A68D541C85D26508E83_1762355666 = currentTransaction;
                            varB4EAC82CA7396A68D541C85D26508E83_1187938946 = null;
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
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_208341068 = (stackLogger.isLoggingEnabled());
            {
                stackLogger.logDebug("newSIPServerRequest( " + requestReceived.getMethod() + ":"
                    + requestReceived.getTopmostVia().getBranch() + "):" + currentTransaction);
            } //End block
        } //End collapsed parenthetic
        currentTransaction.setRequestInterface(sipMessageFactory.newSIPServerRequest(
                    requestReceived, currentTransaction));
        {
            boolean var0F6C442AF508B1ABAB943F4C4B4ED076_1774266328 = (currentTransaction != null && currentTransaction.acquireSem());
            {
                varB4EAC82CA7396A68D541C85D26508E83_2132007556 = currentTransaction;
            } //End block
            {
                try 
                {
                    {
                        boolean var73C027315BBD0DCC1A552716D2DA9C61_167136365 = (currentTransaction.isMessagePartOfTransaction(requestReceived) &&
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
                        boolean var86B7E4A6EFF1453FB71811BCAA5C5B32_1722918405 = (isLoggingEnabled());
                        stackLogger.logError("Exception occured sending TRYING");
                    } //End collapsed parenthetic
                } //End block
                varB4EAC82CA7396A68D541C85D26508E83_2146745019 = null;
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_632612141 = null;
            } //End block
        } //End collapsed parenthetic
        addTaint(requestReceived.getTaint());
        addTaint(requestMessageChannel.getTaint());
        ServerRequestInterface varA7E53CE21691AB073D9660D615818899_1197529055; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1197529055 = varB4EAC82CA7396A68D541C85D26508E83_1762355666;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1197529055 = varB4EAC82CA7396A68D541C85D26508E83_1187938946;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1197529055 = varB4EAC82CA7396A68D541C85D26508E83_2132007556;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1197529055 = varB4EAC82CA7396A68D541C85D26508E83_2146745019;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1197529055 = varB4EAC82CA7396A68D541C85D26508E83_632612141;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1197529055.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1197529055;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.489 -0400", hash_original_method = "62ADB5DE3DAA611F01F5B25EB82A32E9", hash_generated_method = "F59C00F299AE457C5D93BD3470E87B31")
    public ServerResponseInterface newSIPServerResponse(SIPResponse responseReceived,
            MessageChannel responseMessageChannel) {
        ServerResponseInterface varB4EAC82CA7396A68D541C85D26508E83_1533370016 = null; //Variable for return #1
        ServerResponseInterface varB4EAC82CA7396A68D541C85D26508E83_797457286 = null; //Variable for return #2
        ServerResponseInterface varB4EAC82CA7396A68D541C85D26508E83_478250222 = null; //Variable for return #3
        ServerResponseInterface varB4EAC82CA7396A68D541C85D26508E83_362883809 = null; //Variable for return #4
        Iterator<SIPClientTransaction> transactionIterator;
        SIPClientTransaction nextTransaction;
        SIPClientTransaction currentTransaction;
        String key;
        key = responseReceived.getTransactionId();
        currentTransaction = (SIPClientTransaction) clientTransactionTable.get(key);
        {
            boolean varFD65E86793E7DA9A4559DFCAD3FE7A38_1934876769 = (currentTransaction == null
                || (!currentTransaction.isMessagePartOfTransaction(responseReceived) && !key
                        .startsWith(SIPConstants.BRANCH_MAGIC_COOKIE_LOWER_CASE)));
            {
                transactionIterator = clientTransactionTable.values().iterator();
                currentTransaction = null;
                {
                    boolean var02E71BDB7FE3E53290C9D60F6709CA78_244160654 = (transactionIterator.hasNext() && currentTransaction == null);
                    {
                        nextTransaction = (SIPClientTransaction) transactionIterator.next();
                        {
                            boolean varB7132609472FD4E761BE7525D40545ED_1843836834 = (nextTransaction.isMessagePartOfTransaction(responseReceived));
                            {
                                currentTransaction = nextTransaction;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    {
                        boolean var0954F7596F6CFAF1C1D43DD490BBFB96_834942286 = (this.stackLogger.isLoggingEnabled(StackLogger.TRACE_INFO));
                        {
                            responseMessageChannel.logResponse(responseReceived, System
                            .currentTimeMillis(), "before processing");
                        } //End block
                    } //End collapsed parenthetic
                    varB4EAC82CA7396A68D541C85D26508E83_1533370016 = sipMessageFactory.newSIPServerResponse(responseReceived,
                        responseMessageChannel);
                } //End block
            } //End block
        } //End collapsed parenthetic
        boolean acquired;
        acquired = currentTransaction.acquireSem();
        {
            boolean var052D788439DC89D4EA99379C3615ED1C_149444597 = (this.stackLogger.isLoggingEnabled(StackLogger.TRACE_INFO));
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
                    boolean varB994156BC51EB47795FEDC6186A6DA25_1969977829 = (this.stackLogger.isLoggingEnabled());
                    {
                        this.stackLogger.logDebug("returning null - serverResponseInterface is null!");
                    } //End block
                } //End collapsed parenthetic
                currentTransaction.releaseSem();
                varB4EAC82CA7396A68D541C85D26508E83_797457286 = null;
            } //End block
        } //End block
        {
            {
                boolean varCEA0B8AAFFB6C70BF01D444180FAAB1F_148813687 = (stackLogger.isLoggingEnabled());
                this.stackLogger.logDebug("Could not aquire semaphore !!");
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_478250222 = currentTransaction;
        varB4EAC82CA7396A68D541C85D26508E83_362883809 = null;
        addTaint(responseReceived.getTaint());
        addTaint(responseMessageChannel.getTaint());
        ServerResponseInterface varA7E53CE21691AB073D9660D615818899_437295493; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_437295493 = varB4EAC82CA7396A68D541C85D26508E83_1533370016;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_437295493 = varB4EAC82CA7396A68D541C85D26508E83_797457286;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_437295493 = varB4EAC82CA7396A68D541C85D26508E83_478250222;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_437295493 = varB4EAC82CA7396A68D541C85D26508E83_362883809;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_437295493.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_437295493;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.505 -0400", hash_original_method = "32F3E8827D13E0BAFD4E9DD3BE9CB370", hash_generated_method = "E99FAD383A8E392BD07105E2630946B3")
    public MessageChannel createMessageChannel(SIPRequest request, MessageProcessor mp,
            Hop nextHop) throws IOException {
        MessageChannel varB4EAC82CA7396A68D541C85D26508E83_1176457273 = null; //Variable for return #1
        MessageChannel varB4EAC82CA7396A68D541C85D26508E83_1561573449 = null; //Variable for return #2
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
        varB4EAC82CA7396A68D541C85D26508E83_1176457273 = null;
        returnChannel = createClientTransaction(request, mc);
        ((SIPClientTransaction) returnChannel).setViaPort(nextHop.getPort());
        ((SIPClientTransaction) returnChannel).setViaHost(nextHop.getHost());
        addTransactionHash(returnChannel);
        varB4EAC82CA7396A68D541C85D26508E83_1561573449 = returnChannel;
        addTaint(request.getTaint());
        addTaint(mp.getTaint());
        addTaint(nextHop.getTaint());
        MessageChannel varA7E53CE21691AB073D9660D615818899_1700512467; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1700512467 = varB4EAC82CA7396A68D541C85D26508E83_1176457273;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1700512467 = varB4EAC82CA7396A68D541C85D26508E83_1561573449;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1700512467.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1700512467;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.507 -0400", hash_original_method = "912DB48513D0A0D8594B2E782158C138", hash_generated_method = "BD516BBDE5B7E277F2345155FE6F1677")
    public SIPClientTransaction createClientTransaction(SIPRequest sipRequest,
            MessageChannel encapsulatedMessageChannel) {
        SIPClientTransaction varB4EAC82CA7396A68D541C85D26508E83_953879547 = null; //Variable for return #1
        SIPClientTransaction ct;
        ct = new SIPClientTransaction(this, encapsulatedMessageChannel);
        ct.setOriginalRequest(sipRequest);
        varB4EAC82CA7396A68D541C85D26508E83_953879547 = ct;
        addTaint(sipRequest.getTaint());
        addTaint(encapsulatedMessageChannel.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_953879547.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_953879547;
        // ---------- Original Method ----------
        //SIPClientTransaction ct = new SIPClientTransaction(this, encapsulatedMessageChannel);
        //ct.setOriginalRequest(sipRequest);
        //return ct;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.511 -0400", hash_original_method = "81B760547C7425A938D45D7063876C66", hash_generated_method = "32A885F32DB0CD3D97D79B096020EDA4")
    public SIPServerTransaction createServerTransaction(MessageChannel encapsulatedMessageChannel) {
        SIPServerTransaction varB4EAC82CA7396A68D541C85D26508E83_1212698102 = null; //Variable for return #1
        SIPServerTransaction varB4EAC82CA7396A68D541C85D26508E83_645057767 = null; //Variable for return #2
        SIPServerTransaction varB4EAC82CA7396A68D541C85D26508E83_444672288 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_1212698102 = new SIPServerTransaction(this, encapsulatedMessageChannel);
        } //End block
        {
            float threshold;
            threshold = ((float) (serverTransactionTable.size() - serverTransactionTableLowaterMark))
                    / ((float) (serverTransactionTableHighwaterMark - serverTransactionTableLowaterMark));
            boolean decision;
            decision = Math.random() > 1.0 - threshold;
            {
                varB4EAC82CA7396A68D541C85D26508E83_645057767 = null;
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_444672288 = new SIPServerTransaction(this, encapsulatedMessageChannel);
            } //End block
        } //End block
        addTaint(encapsulatedMessageChannel.getTaint());
        SIPServerTransaction varA7E53CE21691AB073D9660D615818899_253424250; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_253424250 = varB4EAC82CA7396A68D541C85D26508E83_1212698102;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_253424250 = varB4EAC82CA7396A68D541C85D26508E83_645057767;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_253424250 = varB4EAC82CA7396A68D541C85D26508E83_444672288;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_253424250.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_253424250;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.512 -0400", hash_original_method = "2775112CA96E4BBD847FD3F2A14A81DE", hash_generated_method = "D456FBED573248E045FAEE288978BEBA")
    public int getClientTransactionTableSize() {
        int var03DB7AB6196DC5D0E9988C142D712431_1221305516 = (this.clientTransactionTable.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1671856872 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1671856872;
        // ---------- Original Method ----------
        //return this.clientTransactionTable.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.513 -0400", hash_original_method = "4372809DD9897424686B6F4A147D93FA", hash_generated_method = "C6701AE1736D59648BC8B5AC292C3F11")
    public int getServerTransactionTableSize() {
        int var7FEDB251634EBCF9A56CDDB387AADB7C_1251045465 = (this.serverTransactionTable.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1475184800 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1475184800;
        // ---------- Original Method ----------
        //return this.serverTransactionTable.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.527 -0400", hash_original_method = "2F0441D135E4CBEEA76B3CCA00FAD23B", hash_generated_method = "F059C5FD7CC91F9C546389233CF05C2D")
    public void addTransaction(SIPClientTransaction clientTransaction) {
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_1871740470 = (stackLogger.isLoggingEnabled());
            stackLogger.logDebug("added transaction " + clientTransaction);
        } //End collapsed parenthetic
        addTransactionHash(clientTransaction);
        addTaint(clientTransaction.getTaint());
        // ---------- Original Method ----------
        //if (stackLogger.isLoggingEnabled())
            //stackLogger.logDebug("added transaction " + clientTransaction);
        //addTransactionHash(clientTransaction);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.528 -0400", hash_original_method = "FC7C0EB4C2CF25B4E39BD000BE1A0318", hash_generated_method = "E92F1C9556E06BD801BD421C21403750")
    public void removeTransaction(SIPTransaction sipTransaction) {
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_1215189602 = (stackLogger.isLoggingEnabled());
            {
                stackLogger.logDebug("Removing Transaction = " + sipTransaction.getTransactionId()
                    + " transaction = " + sipTransaction);
            } //End block
        } //End collapsed parenthetic
        {
            {
                boolean varCEA0B8AAFFB6C70BF01D444180FAAB1F_1341967323 = (stackLogger.isLoggingEnabled());
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
                boolean varCD28D341484E6B95D2F46E243D03836E_1129788718 = (method.equalsIgnoreCase(Request.INVITE));
                {
                    this.removeFromMergeTable((SIPServerTransaction) sipTransaction);
                } //End block
            } //End collapsed parenthetic
            SipProviderImpl sipProvider;
            sipProvider = (SipProviderImpl) sipTransaction.getSipProvider();
            {
                boolean var1213E4480B57552575E83F2F9387B887_604847258 = (removed != null && sipTransaction.testAndSetTransactionTerminatedEvent());
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
                boolean varCEA0B8AAFFB6C70BF01D444180FAAB1F_1665983103 = (stackLogger.isLoggingEnabled());
                {
                    stackLogger.logDebug("REMOVED client tx " + removed + " KEY = " + key);
                    {
                        SIPClientTransaction clientTx;
                        clientTx = (SIPClientTransaction)removed;
                        {
                            boolean varD1410CA2EC6660EFEAC1856DD8EB1E5A_2064549192 = (clientTx.getMethod().equals(Request.INVITE) && this.maxForkTime != 0);
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
                boolean var1213E4480B57552575E83F2F9387B887_1849170750 = (removed != null && sipTransaction.testAndSetTransactionTerminatedEvent());
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
        addTaint(sipTransaction.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.529 -0400", hash_original_method = "114E6F44E2106B74A7437814EDE26008", hash_generated_method = "6FC61E0D17774D9DFDFDC4CD4689F081")
    public void addTransaction(SIPServerTransaction serverTransaction) throws IOException {
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_1403893334 = (stackLogger.isLoggingEnabled());
            stackLogger.logDebug("added transaction " + serverTransaction);
        } //End collapsed parenthetic
        serverTransaction.map();
        addTransactionHash(serverTransaction);
        addTaint(serverTransaction.getTaint());
        // ---------- Original Method ----------
        //if (stackLogger.isLoggingEnabled())
            //stackLogger.logDebug("added transaction " + serverTransaction);
        //serverTransaction.map();
        //addTransactionHash(serverTransaction);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.540 -0400", hash_original_method = "A02B6100DC58EB921085C7ED44EE1D0C", hash_generated_method = "82D578829020B0CBB8A2E4260405219B")
    private void addTransactionHash(SIPTransaction sipTransaction) {
        SIPRequest sipRequest;
        sipRequest = sipTransaction.getOriginalRequest();
        {
            {
                {
                    boolean varD67D9F55A3909BC928BCBD79D887834D_47892709 = (this.activeClientTransactionCount.get() > clientTransactionTableHiwaterMark);
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
                                boolean var337B2A9C9EA2BB40C001AEDF1FE004ED_288551177 = (stackLogger.isLoggingEnabled());
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
                boolean varCEA0B8AAFFB6C70BF01D444180FAAB1F_1718854384 = (stackLogger.isLoggingEnabled());
                {
                    stackLogger.logDebug(" putTransactionHash : " + " key = " + key);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            String key;
            key = sipRequest.getTransactionId();
            {
                boolean varCEA0B8AAFFB6C70BF01D444180FAAB1F_41187201 = (stackLogger.isLoggingEnabled());
                {
                    stackLogger.logDebug(" putTransactionHash : " + " key = " + key);
                } //End block
            } //End collapsed parenthetic
            serverTransactionTable.put(key, (SIPServerTransaction) sipTransaction);
        } //End block
        addTaint(sipTransaction.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.541 -0400", hash_original_method = "380804F8BD40257E05E5F5A307273856", hash_generated_method = "30B1EA1EBA9141B4D62467D31200B414")
    protected void decrementActiveClientTransactionCount() {
        {
            boolean var47ED5E0FC43EE8302B13C023BBB66045_1088160955 = (this.activeClientTransactionCount.decrementAndGet() <= this.clientTransactionTableLowaterMark
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.542 -0400", hash_original_method = "BBF1530237A94448CCB60A02BEEFAB6C", hash_generated_method = "B5CC9B9D18A0854EEB02AF41C912FC93")
    protected void removeTransactionHash(SIPTransaction sipTransaction) {
        SIPRequest sipRequest;
        sipRequest = sipTransaction.getOriginalRequest();
        {
            String key;
            key = sipTransaction.getTransactionId();
            {
                boolean varCEA0B8AAFFB6C70BF01D444180FAAB1F_130375945 = (stackLogger.isLoggingEnabled());
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
                boolean varCEA0B8AAFFB6C70BF01D444180FAAB1F_1812031511 = (stackLogger.isLoggingEnabled());
                {
                    stackLogger.logDebug("removing server Tx : " + key);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(sipTransaction.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.546 -0400", hash_original_method = "DE85950924139BCA289E1B65627F95C2", hash_generated_method = "E5C2CCC10276A3EE1151AC9F48CE84A6")
    public synchronized void transactionErrorEvent(SIPTransactionErrorEvent transactionErrorEvent) {
        SIPTransaction transaction;
        transaction = (SIPTransaction) transactionErrorEvent.getSource();
        {
            boolean varEB5679C18C9B12FA2BAE5A757A24F70B_1066760637 = (transactionErrorEvent.getErrorID() == SIPTransactionErrorEvent.TRANSPORT_ERROR);
            {
                transaction.setState(SIPTransaction.TERMINATED_STATE);
                {
                    ((SIPServerTransaction) transaction).collectionTime = 0;
                } //End block
                transaction.disableTimeoutTimer();
                transaction.disableRetransmissionTimer();
            } //End block
        } //End collapsed parenthetic
        addTaint(transactionErrorEvent.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.547 -0400", hash_original_method = "2DBBC23B1910A8BC0C385035C3D36387", hash_generated_method = "10685477707F526F81225135A46D131F")
    public synchronized void dialogErrorEvent(SIPDialogErrorEvent dialogErrorEvent) {
        SIPDialog sipDialog;
        sipDialog = (SIPDialog) dialogErrorEvent.getSource();
        SipListener sipListener;
        sipListener = ((SipStackImpl)this).getSipListener();
        {
            sipDialog.delete();
        } //End block
        addTaint(dialogErrorEvent.getTaint());
        // ---------- Original Method ----------
        //SIPDialog sipDialog = (SIPDialog) dialogErrorEvent.getSource();
        //SipListener sipListener = ((SipStackImpl)this).getSipListener();
        //if(sipDialog != null && !(sipListener instanceof SipListenerExt)) {
        	//sipDialog.delete();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.557 -0400", hash_original_method = "EC17AB4FB84DCA37B1579E7D41B287E3", hash_generated_method = "9CC20F4C67CFE462583CF06525632DFA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.558 -0400", hash_original_method = "CEE88C8969112A140A79BE7502F1A5FB", hash_generated_method = "3F4E029D004AB05B34E16CB86E87825D")
    public void putPendingTransaction(SIPServerTransaction tr) {
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_1396022332 = (stackLogger.isLoggingEnabled());
            stackLogger.logDebug("putPendingTransaction: " + tr);
        } //End collapsed parenthetic
        this.pendingTransactions.put(tr.getTransactionId(), tr);
        addTaint(tr.getTaint());
        // ---------- Original Method ----------
        //if (stackLogger.isLoggingEnabled())
            //stackLogger.logDebug("putPendingTransaction: " + tr);
        //this.pendingTransactions.put(tr.getTransactionId(), tr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.558 -0400", hash_original_method = "A3344B5915DA0C5B05591E12A62D4610", hash_generated_method = "2588303F4153E3755AA17A9A103393C5")
    public NetworkLayer getNetworkLayer() {
        NetworkLayer varB4EAC82CA7396A68D541C85D26508E83_659388321 = null; //Variable for return #1
        NetworkLayer varB4EAC82CA7396A68D541C85D26508E83_558160192 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_659388321 = DefaultNetworkLayer.SINGLETON;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_558160192 = networkLayer;
        } //End block
        NetworkLayer varA7E53CE21691AB073D9660D615818899_801227977; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_801227977 = varB4EAC82CA7396A68D541C85D26508E83_659388321;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_801227977 = varB4EAC82CA7396A68D541C85D26508E83_558160192;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_801227977.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_801227977;
        // ---------- Original Method ----------
        //if (networkLayer == null) {
            //return DefaultNetworkLayer.SINGLETON;
        //} else {
            //return networkLayer;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.567 -0400", hash_original_method = "47BDB9F0F1E73BBB0BEBE9D5C68FE123", hash_generated_method = "1ADF9C0C07286BD2C7D1FE1079025D49")
    public boolean isLoggingEnabled() {
        {
            Object var11C62F83477FD0505FB5BB12080FBCDA_1107107627 = (this.stackLogger.isLoggingEnabled());
        } //End flattened ternary
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1557581374 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1557581374;
        // ---------- Original Method ----------
        //return this.stackLogger == null ? false : this.stackLogger.isLoggingEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.568 -0400", hash_original_method = "ACBC713DDCF210EE591047F9A9A515DC", hash_generated_method = "62CE7E4876C1BA50FE6FB309C1A70A6E")
    public StackLogger getStackLogger() {
        StackLogger varB4EAC82CA7396A68D541C85D26508E83_41488461 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_41488461 = this.stackLogger;
        varB4EAC82CA7396A68D541C85D26508E83_41488461.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_41488461;
        // ---------- Original Method ----------
        //return this.stackLogger;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.568 -0400", hash_original_method = "01705032DE3FE074C7E055A3A8A4FEE3", hash_generated_method = "1D52FD6083C85265F045EBF9C54BC436")
    public ServerLogger getServerLogger() {
        ServerLogger varB4EAC82CA7396A68D541C85D26508E83_781817319 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_781817319 = this.serverLogger;
        varB4EAC82CA7396A68D541C85D26508E83_781817319.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_781817319;
        // ---------- Original Method ----------
        //return this.serverLogger;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.569 -0400", hash_original_method = "9DA0FD5646924F30F0B4568C00D20E6E", hash_generated_method = "5CCDC8D8C16EA9DA1438381A0A7CD63D")
    public int getMaxMessageSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_508694566 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_508694566;
        // ---------- Original Method ----------
        //return this.maxMessageSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.569 -0400", hash_original_method = "F7820D79676ABCB839F961B1893B47B1", hash_generated_method = "EA170E890B9C35B538B5CB86A786F5AF")
    public void setSingleThreaded() {
        this.threadPoolSize = 1;
        // ---------- Original Method ----------
        //this.threadPoolSize = 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.569 -0400", hash_original_method = "E9690233252AAFA4C640E8F4D35D05EB", hash_generated_method = "65BB9FFF7A846847510EF99A4FA089FF")
    public void setThreadPoolSize(int size) {
        this.threadPoolSize = size;
        // ---------- Original Method ----------
        //this.threadPoolSize = size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.574 -0400", hash_original_method = "71AE725926CCD09A123AE8B2DA17A3F2", hash_generated_method = "BDCFBBD8A7091C0AC8289D984C7F139F")
    public void setMaxConnections(int nconnections) {
        this.maxConnections = nconnections;
        // ---------- Original Method ----------
        //this.maxConnections = nconnections;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.582 -0400", hash_original_method = "48A74B192606F2E929FFF01B3041CF91", hash_generated_method = "AAD94D4DBDCE1AF6BDFF6B059C1B12D2")
    public Hop getNextHop(SIPRequest sipRequest) throws SipException {
        Hop varB4EAC82CA7396A68D541C85D26508E83_867116522 = null; //Variable for return #1
        Hop varB4EAC82CA7396A68D541C85D26508E83_1287103832 = null; //Variable for return #2
        Hop varB4EAC82CA7396A68D541C85D26508E83_2123821056 = null; //Variable for return #3
        Hop varB4EAC82CA7396A68D541C85D26508E83_881877948 = null; //Variable for return #4
        Hop varB4EAC82CA7396A68D541C85D26508E83_290570138 = null; //Variable for return #5
        {
            varB4EAC82CA7396A68D541C85D26508E83_867116522 = router.getNextHop(sipRequest);
            varB4EAC82CA7396A68D541C85D26508E83_1287103832 = null;
        } //End block
        {
            {
                boolean varCB9DA79D6FC6DC73F34AC1A9AEB77BE2_52808092 = (sipRequest.getRequestURI().isSipURI() || sipRequest.getRouteHeaders() != null);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_2123821056 = defaultRouter.getNextHop(sipRequest);
                } //End block
                {
                    varB4EAC82CA7396A68D541C85D26508E83_881877948 = router.getNextHop(sipRequest);
                } //End block
                varB4EAC82CA7396A68D541C85D26508E83_290570138 = null;
            } //End collapsed parenthetic
        } //End block
        addTaint(sipRequest.getTaint());
        Hop varA7E53CE21691AB073D9660D615818899_1418926379; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1418926379 = varB4EAC82CA7396A68D541C85D26508E83_867116522;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1418926379 = varB4EAC82CA7396A68D541C85D26508E83_1287103832;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1418926379 = varB4EAC82CA7396A68D541C85D26508E83_2123821056;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1418926379 = varB4EAC82CA7396A68D541C85D26508E83_881877948;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1418926379 = varB4EAC82CA7396A68D541C85D26508E83_290570138;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1418926379.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1418926379;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.582 -0400", hash_original_method = "F49E7F0B68A71227FAAC90E58DC1BBF8", hash_generated_method = "0DCFD4017235BFA0DF5839F534EAAED3")
    public void setStackName(String stackName) {
        this.stackName = stackName;
        // ---------- Original Method ----------
        //this.stackName = stackName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.583 -0400", hash_original_method = "A8237A45131D19EE871BFED3E7A5AA19", hash_generated_method = "017AC73D107B25DA2193103F3AD27633")
    protected void setHostAddress(String stackAddress) throws UnknownHostException {
        {
            boolean var88033752B93C1832F0A794C7B736EEF6_1489509028 = (stackAddress.indexOf(':') != stackAddress.lastIndexOf(':')
                && stackAddress.trim().charAt(0) != '[');
            this.stackAddress = '[' + stackAddress + ']';
            this.stackAddress = stackAddress;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.583 -0400", hash_original_method = "54480DAD55477A9080CEE058FAAB32DE", hash_generated_method = "8E77A162D5C3FF30A15150FD7A3475CE")
    public String getHostAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_1069587004 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1069587004 = this.stackAddress;
        varB4EAC82CA7396A68D541C85D26508E83_1069587004.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1069587004;
        // ---------- Original Method ----------
        //return this.stackAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.596 -0400", hash_original_method = "76950F41C787A5DB271675B8BBBB662A", hash_generated_method = "1E92BF9F05330CC7F9733D97887E55BC")
    protected void setRouter(Router router) {
        this.router = router;
        // ---------- Original Method ----------
        //this.router = router;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.598 -0400", hash_original_method = "AF384EADB40CF611F4292AFC400A4743", hash_generated_method = "F54B9F1CEA5938E1483419471FF94D4A")
    public Router getRouter(SIPRequest request) {
        Router varB4EAC82CA7396A68D541C85D26508E83_1832290804 = null; //Variable for return #1
        Router varB4EAC82CA7396A68D541C85D26508E83_850729729 = null; //Variable for return #2
        Router varB4EAC82CA7396A68D541C85D26508E83_1841279955 = null; //Variable for return #3
        Router varB4EAC82CA7396A68D541C85D26508E83_1163197237 = null; //Variable for return #4
        Router varB4EAC82CA7396A68D541C85D26508E83_175703969 = null; //Variable for return #5
        {
            boolean varF76E09608A8C57E8EC47B53AB21A7904_1808390041 = (request.getRequestLine() == null);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1832290804 = this.defaultRouter;
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_850729729 = this.router;
            } //End block
            {
                {
                    boolean varA3564E0CF4A90785E724764B33E54BE1_1158395750 = (request.getRequestURI().getScheme().equals("sip")
                    || request.getRequestURI().getScheme().equals("sips"));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1841279955 = this.defaultRouter;
                    } //End block
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1163197237 = this.router;
                        varB4EAC82CA7396A68D541C85D26508E83_175703969 = defaultRouter;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(request.getTaint());
        Router varA7E53CE21691AB073D9660D615818899_1107010336; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1107010336 = varB4EAC82CA7396A68D541C85D26508E83_1832290804;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1107010336 = varB4EAC82CA7396A68D541C85D26508E83_850729729;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1107010336 = varB4EAC82CA7396A68D541C85D26508E83_1841279955;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1107010336 = varB4EAC82CA7396A68D541C85D26508E83_1163197237;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1107010336 = varB4EAC82CA7396A68D541C85D26508E83_175703969;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1107010336.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1107010336;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.598 -0400", hash_original_method = "A48D8CFCA0D4EF991F0CE4AA0090BC89", hash_generated_method = "D41F5A09F0B328D959AA3C71F4DAB62E")
    public Router getRouter() {
        Router varB4EAC82CA7396A68D541C85D26508E83_359047114 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_359047114 = this.router;
        varB4EAC82CA7396A68D541C85D26508E83_359047114.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_359047114;
        // ---------- Original Method ----------
        //return this.router;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.598 -0400", hash_original_method = "DA20B42A9F145510C718334C692F5A76", hash_generated_method = "A801EFEAF2C33C0CA385B001F7AFF4E3")
    public boolean isAlive() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_627511957 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_627511957;
        // ---------- Original Method ----------
        //return !toExit;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.599 -0400", hash_original_method = "A1F941D6CE0FD78BF39EC8F9AC314942", hash_generated_method = "1A188872F7F3E0C8A138BDBB92F32142")
    protected void addMessageProcessor(MessageProcessor newMessageProcessor) throws IOException {
        {
            messageProcessors.add(newMessageProcessor);
        } //End block
        addTaint(newMessageProcessor.getTaint());
        // ---------- Original Method ----------
        //synchronized (messageProcessors) {
            //messageProcessors.add(newMessageProcessor);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.610 -0400", hash_original_method = "CFCCE7E1C39F0D41098F0FE9085A25D2", hash_generated_method = "F8FD2EAABBBC83B17AF7E2C18171595B")
    protected void removeMessageProcessor(MessageProcessor oldMessageProcessor) {
        {
            {
                boolean var7FEC726C44313EDFE272C9262D35B632_796207741 = (messageProcessors.remove(oldMessageProcessor));
                {
                    oldMessageProcessor.stop();
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(oldMessageProcessor.getTaint());
        // ---------- Original Method ----------
        //synchronized (messageProcessors) {
            //if (messageProcessors.remove(oldMessageProcessor)) {
                //oldMessageProcessor.stop();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.611 -0400", hash_original_method = "B73144BB70E5C3E03C6EB8CA5C201D44", hash_generated_method = "C3A5320C51A5819F4423350E76464FAA")
    protected MessageProcessor[] getMessageProcessors() {
        MessageProcessor[] varB4EAC82CA7396A68D541C85D26508E83_2018847111 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_2018847111 = (MessageProcessor[]) messageProcessors.toArray(new MessageProcessor[0]);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2018847111.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2018847111;
        // ---------- Original Method ----------
        //synchronized (messageProcessors) {
            //return (MessageProcessor[]) messageProcessors.toArray(new MessageProcessor[0]);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.616 -0400", hash_original_method = "923CC6809D53E2778E41D61552555A7F", hash_generated_method = "2512974D08CA603191480E3C3D08CD8D")
    protected MessageProcessor createMessageProcessor(InetAddress ipAddress, int port,
            String transport) throws java.io.IOException {
        MessageProcessor varB4EAC82CA7396A68D541C85D26508E83_597869993 = null; //Variable for return #1
        MessageProcessor varB4EAC82CA7396A68D541C85D26508E83_1192137675 = null; //Variable for return #2
        MessageProcessor varB4EAC82CA7396A68D541C85D26508E83_55592313 = null; //Variable for return #3
        MessageProcessor varB4EAC82CA7396A68D541C85D26508E83_538576253 = null; //Variable for return #4
        {
            boolean var7095C4F355EEA549877FC43E480D2092_1839867198 = (transport.equalsIgnoreCase("udp"));
            {
                UDPMessageProcessor udpMessageProcessor;
                udpMessageProcessor = new UDPMessageProcessor(ipAddress, this,
                    port);
                this.addMessageProcessor(udpMessageProcessor);
                this.udpFlag = true;
                varB4EAC82CA7396A68D541C85D26508E83_597869993 = udpMessageProcessor;
            } //End block
            {
                boolean var7E17D01330C6FB4587DD37D1ACF5F9C6_353755593 = (transport.equalsIgnoreCase("tcp"));
                {
                    TCPMessageProcessor tcpMessageProcessor;
                    tcpMessageProcessor = new TCPMessageProcessor(ipAddress, this,
                    port);
                    this.addMessageProcessor(tcpMessageProcessor);
                    varB4EAC82CA7396A68D541C85D26508E83_1192137675 = tcpMessageProcessor;
                } //End block
                {
                    boolean var5E363589F0885716BB91FFB4505BC89B_47953831 = (transport.equalsIgnoreCase("tls"));
                    {
                        TLSMessageProcessor tlsMessageProcessor;
                        tlsMessageProcessor = new TLSMessageProcessor(ipAddress, this,
                    port);
                        this.addMessageProcessor(tlsMessageProcessor);
                        varB4EAC82CA7396A68D541C85D26508E83_55592313 = tlsMessageProcessor;
                    } //End block
                    {
                        boolean var11BAA59DFE2974D4AFA5B4D4F65EA219_476335272 = (transport.equalsIgnoreCase("sctp"));
                        {
                            try 
                            {
                                Class<?> mpc;
                                mpc = ClassLoader.getSystemClassLoader().loadClass( "gov.nist.javax.sip.stack.sctp.SCTPMessageProcessor" );
                                MessageProcessor mp;
                                mp = (MessageProcessor) mpc.newInstance();
                                mp.initialize( ipAddress, port, this );
                                this.addMessageProcessor(mp);
                                varB4EAC82CA7396A68D541C85D26508E83_538576253 = mp;
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
        addTaint(ipAddress.getTaint());
        addTaint(port);
        addTaint(transport.getTaint());
        MessageProcessor varA7E53CE21691AB073D9660D615818899_1590688365; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1590688365 = varB4EAC82CA7396A68D541C85D26508E83_597869993;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1590688365 = varB4EAC82CA7396A68D541C85D26508E83_1192137675;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1590688365 = varB4EAC82CA7396A68D541C85D26508E83_55592313;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1590688365 = varB4EAC82CA7396A68D541C85D26508E83_538576253;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1590688365.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1590688365;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.631 -0400", hash_original_method = "B67F8BF0F619BF3DA8779F834D136A31", hash_generated_method = "A19418B518D97C741239C5FFDF8C7894")
    protected void setMessageFactory(StackMessageFactory messageFactory) {
        this.sipMessageFactory = messageFactory;
        // ---------- Original Method ----------
        //this.sipMessageFactory = messageFactory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.633 -0400", hash_original_method = "79BA5457C24B1F2BABB705E59D2E5DE3", hash_generated_method = "3FD5C8FDF886A14706172850D14313A3")
    public MessageChannel createRawMessageChannel(String sourceIpAddress, int sourcePort,
            Hop nextHop) throws UnknownHostException {
        MessageChannel varB4EAC82CA7396A68D541C85D26508E83_1564329065 = null; //Variable for return #1
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
            boolean var8CF1BBEBBFCBF1DC7D2F0931268CDCC1_1783002740 = (processorIterator.hasNext() && newChannel == null);
            {
                nextProcessor = (MessageProcessor) processorIterator.next();
                {
                    boolean varD30EC259292DB7E4155DAE7A640C45BC_246101896 = (nextHop.getTransport().equalsIgnoreCase(nextProcessor.getTransport())
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
                                boolean var337B2A9C9EA2BB40C001AEDF1FE004ED_1531588547 = (stackLogger.isLoggingEnabled());
                                stackLogger.logException(ex);
                            } //End collapsed parenthetic
                            if (DroidSafeAndroidRuntime.control) throw ex;
                        } //End block
                        catch (IOException e)
                        {
                            {
                                boolean var337B2A9C9EA2BB40C001AEDF1FE004ED_89060639 = (stackLogger.isLoggingEnabled());
                                stackLogger.logException(e);
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1564329065 = newChannel;
        addTaint(sourceIpAddress.getTaint());
        addTaint(sourcePort);
        addTaint(nextHop.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1564329065.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1564329065;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.637 -0400", hash_original_method = "35D04CBE96754834C212489B2C606D95", hash_generated_method = "E1C14DE46CC0F5819457C8377F4B6D26")
    public boolean isEventForked(String ename) {
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_899794376 = (stackLogger.isLoggingEnabled());
            {
                stackLogger.logDebug("isEventForked: " + ename + " returning "
                    + this.forkedEvents.contains(ename));
            } //End block
        } //End collapsed parenthetic
        boolean var0487541C1220D18499AD3CEC1C1D9EAD_709911891 = (this.forkedEvents.contains(ename));
        addTaint(ename.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_12436721 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_12436721;
        // ---------- Original Method ----------
        //if (stackLogger.isLoggingEnabled()) {
            //stackLogger.logDebug("isEventForked: " + ename + " returning "
                    //+ this.forkedEvents.contains(ename));
        //}
        //return this.forkedEvents.contains(ename);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.644 -0400", hash_original_method = "8980F34FD4722FAAB08CBB90B3E36CA2", hash_generated_method = "118534B7E3E6C8BA8A064D539779FA19")
    public AddressResolver getAddressResolver() {
        AddressResolver varB4EAC82CA7396A68D541C85D26508E83_155552167 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_155552167 = this.addressResolver;
        varB4EAC82CA7396A68D541C85D26508E83_155552167.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_155552167;
        // ---------- Original Method ----------
        //return this.addressResolver;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.645 -0400", hash_original_method = "3C1DAA52D018FB69E50FF9E6B399590F", hash_generated_method = "AB8878E125C4CAD1D1B4691B2D6499BB")
    public void setAddressResolver(AddressResolver addressResolver) {
        this.addressResolver = addressResolver;
        // ---------- Original Method ----------
        //this.addressResolver = addressResolver;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.645 -0400", hash_original_method = "906B74670BE04C4A719BBC503CD663E5", hash_generated_method = "1BD4BE3CB90C933E977E9F9E4FB6AE5F")
    public void setLogRecordFactory(LogRecordFactory logRecordFactory) {
        this.logRecordFactory = logRecordFactory;
        // ---------- Original Method ----------
        //this.logRecordFactory = logRecordFactory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.645 -0400", hash_original_method = "2953BF87EC3C3B721F79C36C05ACD684", hash_generated_method = "BFB1705E9BB25245BCB4BCC1B5F55649")
    public ThreadAuditor getThreadAuditor() {
        ThreadAuditor varB4EAC82CA7396A68D541C85D26508E83_719879531 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_719879531 = this.threadAuditor;
        varB4EAC82CA7396A68D541C85D26508E83_719879531.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_719879531;
        // ---------- Original Method ----------
        //return this.threadAuditor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.649 -0400", hash_original_method = "DA93EFB6297A5552E15BC0248101E996", hash_generated_method = "93118A2A2A2F8912526011A63D7E2146")
    public String auditStack(Set activeCallIDs, long leakedDialogTimer,
            long leakedTransactionTimer) {
        String varB4EAC82CA7396A68D541C85D26508E83_43656027 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_43656027 = auditReport;
        addTaint(activeCallIDs.getTaint());
        addTaint(leakedDialogTimer);
        addTaint(leakedTransactionTimer);
        varB4EAC82CA7396A68D541C85D26508E83_43656027.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_43656027;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.665 -0400", hash_original_method = "5A76CC0B1A3067E5B9DACF3EB61E431C", hash_generated_method = "C3F19BB133AEFD30A48FD54D02E46B36")
    private String auditDialogs(Set activeCallIDs, long leakedDialogTimer) {
        String varB4EAC82CA7396A68D541C85D26508E83_2056291685 = null; //Variable for return #1
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
            boolean var03729FD53960D8DCA3A41A13A0229637_469706285 = (it.hasNext());
            {
                SIPDialog itDialog;
                itDialog = (SIPDialog) it.next();
                CallIdHeader callIdHeader;
                callIdHeader = (itDialog != null ? itDialog.getCallId() : null);//DSFIXME:  CODE0008: Nested ternary operator in expression
                String callID;
                callID = (callIdHeader != null ? callIdHeader.getCallId() : null);//DSFIXME:  CODE0008: Nested ternary operator in expression
                {
                    boolean varAD81098F41E3735D1602CF3776CF101D_1603616604 = (itDialog != null && callID != null && !activeCallIDs.contains(callID));
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
                                    boolean var85803934B5461ABB2B9ECDE07C3FFDB4_277474020 = (stackLogger.isLoggingEnabled());
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
        varB4EAC82CA7396A68D541C85D26508E83_2056291685 = auditReport;
        addTaint(activeCallIDs.getTaint());
        addTaint(leakedDialogTimer);
        varB4EAC82CA7396A68D541C85D26508E83_2056291685.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2056291685;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.670 -0400", hash_original_method = "B29AC2188DE994EDE68B3EFDD85B41F1", hash_generated_method = "B64A81DCDC8B865C83B48D01F940C2CC")
    private String auditTransactions(ConcurrentHashMap transactionsMap,
            long a_nLeakedTransactionTimer) {
        String varB4EAC82CA7396A68D541C85D26508E83_529481808 = null; //Variable for return #1
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
            boolean var03729FD53960D8DCA3A41A13A0229637_2045039300 = (it.hasNext());
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
                                boolean varECF2FCB00A6D02E8BADBC36FDF09B326_1867189282 = (isLoggingEnabled());
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
        varB4EAC82CA7396A68D541C85D26508E83_529481808 = auditReport;
        addTaint(transactionsMap.getTaint());
        addTaint(a_nLeakedTransactionTimer);
        varB4EAC82CA7396A68D541C85D26508E83_529481808.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_529481808;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.671 -0400", hash_original_method = "216776ED7A95FC4D69FC6626B7475336", hash_generated_method = "E8608B8CC182F06B0236B85EC551D976")
    public void setNon2XXAckPassedToListener(boolean passToListener) {
        this.non2XXAckPassedToListener = passToListener;
        // ---------- Original Method ----------
        //this.non2XXAckPassedToListener = passToListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.671 -0400", hash_original_method = "6286CBBFF5CE6322EC732C5543B43EDA", hash_generated_method = "614D3722BDBE14A761306B7DE216EE3A")
    public boolean isNon2XXAckPassedToListener() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_758766786 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_758766786;
        // ---------- Original Method ----------
        //return non2XXAckPassedToListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.671 -0400", hash_original_method = "39908A44D12AF4672A8DE059DC86C6F0", hash_generated_method = "FFE67DF9B198001A54433DE7C622D246")
    public int getActiveClientTransactionCount() {
        int varF8FC6F0F03532C67FC8EC013C57CAF05_1851560360 = (activeClientTransactionCount.get());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_654993098 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_654993098;
        // ---------- Original Method ----------
        //return activeClientTransactionCount.get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.671 -0400", hash_original_method = "2D01936677D6715578D012ACFAF4D8A9", hash_generated_method = "73EFE0B4FD118604B38777BD6D472176")
    public boolean isRfc2543Supported() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_719077856 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_719077856;
        // ---------- Original Method ----------
        //return this.rfc2543Supported;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.678 -0400", hash_original_method = "71493EE5805AD2AB9A60D51292B7773D", hash_generated_method = "EB70EF42FAB6BFDCC24102CD72B3503C")
    public boolean isCancelClientTransactionChecked() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1385525525 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1385525525;
        // ---------- Original Method ----------
        //return this.cancelClientTransactionChecked;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.691 -0400", hash_original_method = "45004C11584D234E2C0351030C5C7691", hash_generated_method = "54D715B0E47B58E47EA19F597F84BD21")
    public boolean isRemoteTagReassignmentAllowed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_529100884 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_529100884;
        // ---------- Original Method ----------
        //return this.remoteTagReassignmentAllowed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.692 -0400", hash_original_method = "20ADA27D372C754940A803F19F3E7AD9", hash_generated_method = "E0A9C023E4610070DA39C65231A4B857")
    public Collection<Dialog> getDialogs() {
        Collection<Dialog> varB4EAC82CA7396A68D541C85D26508E83_1025094540 = null; //Variable for return #1
        HashSet<Dialog> dialogs;
        dialogs = new HashSet<Dialog>();
        dialogs.addAll(this.dialogTable.values());
        dialogs.addAll(this.earlyDialogTable.values());
        varB4EAC82CA7396A68D541C85D26508E83_1025094540 = dialogs;
        varB4EAC82CA7396A68D541C85D26508E83_1025094540.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1025094540;
        // ---------- Original Method ----------
        //HashSet<Dialog> dialogs = new HashSet<Dialog>();
        //dialogs.addAll(this.dialogTable.values());
        //dialogs.addAll(this.earlyDialogTable.values());
        //return dialogs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.743 -0400", hash_original_method = "9851D171868856682CD66D2C2C77C100", hash_generated_method = "1B4526C197094E14E05FA3D36FEA43CB")
    public Collection<Dialog> getDialogs(DialogState state) {
        Collection<Dialog> varB4EAC82CA7396A68D541C85D26508E83_4555581 = null; //Variable for return #1
        HashSet<Dialog> matchingDialogs;
        matchingDialogs = new HashSet<Dialog>();
        {
            boolean var4484BD33CD3D459F91886F147843B739_378591481 = (DialogState.EARLY.equals(state));
            {
                matchingDialogs.addAll(this.earlyDialogTable.values());
            } //End block
            {
                Collection<SIPDialog> dialogs;
                dialogs = dialogTable.values();
                {
                    Iterator<SIPDialog> varAF4A62B1E6DB1A3E833F63312F30D56D_865024338 = (dialogs).iterator();
                    varAF4A62B1E6DB1A3E833F63312F30D56D_865024338.hasNext();
                    SIPDialog dialog = varAF4A62B1E6DB1A3E833F63312F30D56D_865024338.next();
                    {
                        {
                            boolean var2BB6D00E61F702FAA6D913BC8638615E_1367640698 = (dialog.getState() != null && dialog.getState().equals(state));
                            {
                                matchingDialogs.add(dialog);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_4555581 = matchingDialogs;
        addTaint(state.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_4555581.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_4555581;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.830 -0400", hash_original_method = "B020A334EC30ACCE61108F29E8239DE0", hash_generated_method = "DADD02F8D6AD89BFC06187283F4DC794")
    public Dialog getReplacesDialog(ReplacesHeader replacesHeader) {
        Dialog varB4EAC82CA7396A68D541C85D26508E83_1690020424 = null; //Variable for return #1
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
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_745840894 = (stackLogger.isLoggingEnabled());
            stackLogger.logDebug("Looking for dialog " + did);
        } //End collapsed parenthetic
        Dialog replacesDialog;
        replacesDialog = this.dialogTable.get(did);
        {
            {
                Iterator<SIPClientTransaction> varEDF5DFD05164E4355382132B99DA269C_2029338127 = (this.clientTransactionTable.values()).iterator();
                varEDF5DFD05164E4355382132B99DA269C_2029338127.hasNext();
                SIPClientTransaction ctx = varEDF5DFD05164E4355382132B99DA269C_2029338127.next();
                {
                    {
                        boolean varD9E48DC518AA5535EEDEFAF93267A4EE_1623083386 = (ctx.getDialog(did) != null);
                        {
                            replacesDialog = ctx.getDialog(did);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1690020424 = replacesDialog;
        addTaint(replacesHeader.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1690020424.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1690020424;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.832 -0400", hash_original_method = "01BB795BEB07C4ED2A3CDD99078DB107", hash_generated_method = "D59A9527BA02C2210BA5A1214397355D")
    public Dialog getJoinDialog(JoinHeader joinHeader) {
        Dialog varB4EAC82CA7396A68D541C85D26508E83_301697101 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_301697101 = this.dialogTable.get(retval.toString().toLowerCase());
        addTaint(joinHeader.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_301697101.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_301697101;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.891 -0400", hash_original_method = "69B105104758CF3A0416D8C1D4F4DE0D", hash_generated_method = "7B24205D066AECCFC783C5A7FE5B727D")
    public void setTimer(Timer timer) {
        this.timer = timer;
        // ---------- Original Method ----------
        //this.timer = timer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.892 -0400", hash_original_method = "8E3D165A90C48C9C43C8115575D5D434", hash_generated_method = "BF22C9A827CA13663FE9C59E6786098B")
    public Timer getTimer() {
        Timer varB4EAC82CA7396A68D541C85D26508E83_599422516 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_599422516 = timer;
        varB4EAC82CA7396A68D541C85D26508E83_599422516.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_599422516;
        // ---------- Original Method ----------
        //return timer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.892 -0400", hash_original_method = "535D845393F6631B713A5EAFAC15730B", hash_generated_method = "0C8B50207406440F9143C0C06CFA7BA2")
    public int getReceiveUdpBufferSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1155527882 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1155527882;
        // ---------- Original Method ----------
        //return receiveUdpBufferSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.892 -0400", hash_original_method = "AD9781079D581597B87998F87481A2EF", hash_generated_method = "3CB289800444473A5EA7A106AC8D0F2E")
    public void setReceiveUdpBufferSize(int receiveUdpBufferSize) {
        this.receiveUdpBufferSize = receiveUdpBufferSize;
        // ---------- Original Method ----------
        //this.receiveUdpBufferSize = receiveUdpBufferSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.892 -0400", hash_original_method = "7F1E49D75F179129A028D4152C30D3F6", hash_generated_method = "9CE294C7F54BA184363D152282745A47")
    public int getSendUdpBufferSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_654588208 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_654588208;
        // ---------- Original Method ----------
        //return sendUdpBufferSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.893 -0400", hash_original_method = "085E2E0AF6AC7C34DFF993E649718D81", hash_generated_method = "5FF890F4499E7F2DC05E16AEF2E489BA")
    public void setSendUdpBufferSize(int sendUdpBufferSize) {
        this.sendUdpBufferSize = sendUdpBufferSize;
        // ---------- Original Method ----------
        //this.sendUdpBufferSize = sendUdpBufferSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.893 -0400", hash_original_method = "3649FCA00F1F012AB31400D887FE5668", hash_generated_method = "25F9CE48BE3D8A2B81401FE81559ECB5")
    public void setStackLogger(StackLogger stackLogger) {
        this.stackLogger = stackLogger;
        // ---------- Original Method ----------
        //this.stackLogger = stackLogger;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.893 -0400", hash_original_method = "3A00FD245E091565EAC4D2A0BF135C63", hash_generated_method = "EC301F2C8690BC99ADD740E96EA20C38")
    public boolean checkBranchId() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_720339275 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_720339275;
        // ---------- Original Method ----------
        //return this.checkBranchId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.897 -0400", hash_original_method = "4B576FDEB92FCE56B4004D51F27F133D", hash_generated_method = "9045EE09E5612A4BCB84191DDFF57B6F")
    public void setLogStackTraceOnMessageSend(boolean logStackTraceOnMessageSend) {
        this.logStackTraceOnMessageSend = logStackTraceOnMessageSend;
        // ---------- Original Method ----------
        //this.logStackTraceOnMessageSend = logStackTraceOnMessageSend;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.897 -0400", hash_original_method = "6EA33CFFB30E0EA85B4B3B5316E0B073", hash_generated_method = "CA5A3EA2669D15A6D90DD32D5CFCF8A0")
    public boolean isLogStackTraceOnMessageSend() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1652682188 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1652682188;
        // ---------- Original Method ----------
        //return logStackTraceOnMessageSend;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.902 -0400", hash_original_method = "BBC3144A1CF9CB1C9F37A775F293720F", hash_generated_method = "1AB264FBAA3C1AD042F7B5A0A41EB0AF")
    public void setDeliverDialogTerminatedEventForNullDialog() {
        this.isDialogTerminatedEventDeliveredForNullDialog = true;
        // ---------- Original Method ----------
        //this.isDialogTerminatedEventDeliveredForNullDialog = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.902 -0400", hash_original_method = "C791CC7BC6998146618C651EB49E3406", hash_generated_method = "08B4782FC6CB7D80BC5F7D8BB33D2C9C")
    public void addForkedClientTransaction(SIPClientTransaction clientTransaction) {
        this.forkedClientTransactionTable.put(clientTransaction.getTransactionId(), clientTransaction );
        addTaint(clientTransaction.getTaint());
        // ---------- Original Method ----------
        //this.forkedClientTransactionTable.put(clientTransaction.getTransactionId(), clientTransaction );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.924 -0400", hash_original_method = "A07C61DB9453AEA0A84C4416E8A5508E", hash_generated_method = "1C4E0F3ED1610E7FE23E6A1036E2172F")
    public SIPClientTransaction getForkedTransaction(String transactionId) {
        SIPClientTransaction varB4EAC82CA7396A68D541C85D26508E83_1568089229 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1568089229 = this.forkedClientTransactionTable.get(transactionId);
        addTaint(transactionId.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1568089229.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1568089229;
        // ---------- Original Method ----------
        //return this.forkedClientTransactionTable.get(transactionId);
    }

    
    class PingTimer extends SIPStackTimerTask {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.924 -0400", hash_original_field = "BA4484AC61EF7F39E156EE38D51DF221", hash_generated_field = "3AE84B2399BFC1B1844D24A06D20C249")

        ThreadAuditor.ThreadHandle threadHandle;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.925 -0400", hash_original_method = "BD8473F7A826DDA501F390A58BAECB33", hash_generated_method = "AFD1D6DF671C7BCECC8041EEE49A6EBB")
        public  PingTimer(ThreadAuditor.ThreadHandle a_oThreadHandle) {
            threadHandle = a_oThreadHandle;
            // ---------- Original Method ----------
            //threadHandle = a_oThreadHandle;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.929 -0400", hash_original_method = "D20FBACDA77D9F2BECED97C9063F3E91", hash_generated_method = "1F3B7F83076419B383E64396F7D52690")
        protected void runTask() {
            {
                boolean varC22F88379E8062191B8F0291837053FF_1992546764 = (getTimer() != null);
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.929 -0400", hash_original_field = "7767C1945F1820BD26BE8F6047172E57", hash_generated_field = "346E85BD6DDF8042B729A2408B44CDD3")

        private SIPClientTransaction clientTransaction;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.930 -0400", hash_original_method = "D0A941D96C1666EFE3BE3721976F6AA6", hash_generated_method = "ABA505C7494D21E7D5CE259EA437DF15")
        public  RemoveForkedTransactionTimerTask(SIPClientTransaction sipClientTransaction ) {
            this.clientTransaction = sipClientTransaction;
            // ---------- Original Method ----------
            //this.clientTransaction = sipClientTransaction;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.930 -0400", hash_original_method = "0A8A5E2C1505E2C2E84219D84E5444CF", hash_generated_method = "74E9473D704F21F1BB34BAE5007DACEC")
        @Override
        protected void runTask() {
            forkedClientTransactionTable.remove(clientTransaction.getTransactionId());
            // ---------- Original Method ----------
            //forkedClientTransactionTable.remove(clientTransaction.getTransactionId());
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.930 -0400", hash_original_field = "1270E8F52DAEA78D6688D9140DFF4221", hash_generated_field = "840B97A8669F66449D46242BA5765A0F")

    public static final int BASE_TIMER_INTERVAL = 500;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.930 -0400", hash_original_field = "9848A0B88D1FABCA8FBA5AB7FD5622BD", hash_generated_field = "F814FEC2CA6FC54407356E1DCD115382")

    public static final int CONNECTION_LINGER_TIME = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:37.930 -0400", hash_original_field = "19274966A28B7A0696AC55588DA87355", hash_generated_field = "388A390124AA7825F100A1798379215A")

    protected static Set<String> dialogCreatingMethods = new HashSet<String>();
    static {
    	dialogCreatingMethods.add(Request.REFER);
        dialogCreatingMethods.add(Request.INVITE);
        dialogCreatingMethods.add(Request.SUBSCRIBE);
    }
    
}

