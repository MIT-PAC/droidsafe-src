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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.205 -0400", hash_original_field = "BB024B2AD3D00DEB98AA88DE95E2AC00", hash_generated_field = "4492ED7A506BF07B68742FB955C2E21E")

    protected ConcurrentHashMap<String, SIPServerTransaction> retransmissionAlertTransactions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.205 -0400", hash_original_field = "986AB2740C1F225B7EDFB5003F826DDF", hash_generated_field = "6B3C62483E89DF024C432E8562DE8605")

    protected ConcurrentHashMap<String, SIPDialog> earlyDialogTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.205 -0400", hash_original_field = "02ACB7AB69D88BAD640992A93D36CD3D", hash_generated_field = "612ED1FD1C10487B0104807B8A4F66C6")

    protected ConcurrentHashMap<String, SIPDialog> dialogTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.205 -0400", hash_original_field = "2C127BF32CCB4EDF2BF22FEA5A00E494", hash_generated_field = "02D2240A23798B540E9F3183DC11EA33")

    private Timer timer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.205 -0400", hash_original_field = "08EADE4A5AD4F48C9A3F1591D2EA1815", hash_generated_field = "32E72097D41FA2F9AA2F04A4F6D94614")

    private ConcurrentHashMap<String, SIPServerTransaction> pendingTransactions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.205 -0400", hash_original_field = "135A93B3EA7CAFC3F8629197D3B561E2", hash_generated_field = "1A605FBA2863EF25462941960BB549FD")

    private ConcurrentHashMap<String, SIPClientTransaction> clientTransactionTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.205 -0400", hash_original_field = "49B61D40D424177779367ABF96FA4884", hash_generated_field = "1F786F43A2E25D3141E2216B91F6EAFE")

    protected boolean unlimitedServerTransactionTableSize = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.205 -0400", hash_original_field = "1DF7958BDE28724C5596C6BFB0E1CCB0", hash_generated_field = "DD907A7A90AC49DD39A1CAABAC88BD51")

    protected boolean unlimitedClientTransactionTableSize = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.205 -0400", hash_original_field = "076578F2E484D4FEC2562AB10277F3D5", hash_generated_field = "F4F362BB5E335440B1EB8C2B8EEC1317")

    protected int serverTransactionTableHighwaterMark = 5000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.205 -0400", hash_original_field = "7B15FFD05552BF4F9F4CD19D72A0ECFD", hash_generated_field = "5C015B93DBBC4C9D6908F3FC81146158")

    protected int serverTransactionTableLowaterMark = 4000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.205 -0400", hash_original_field = "D3F7C88BB14A5ED2F6A20C6BEBEAFDF3", hash_generated_field = "E9B62880A44C081DDF0FEB2884673E38")

    protected int clientTransactionTableHiwaterMark = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.205 -0400", hash_original_field = "06EFD544FD136F3B0F129C5103D56B95", hash_generated_field = "5D70C98F837CF3F9C68DD58DFD91E463")

    protected int clientTransactionTableLowaterMark = 800;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.205 -0400", hash_original_field = "86AE3FC892B739DBA734E71838BA8EAB", hash_generated_field = "EF538D5EF9F88F93E351A9F5CBDE10BE")

    private AtomicInteger activeClientTransactionCount = new AtomicInteger(0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.205 -0400", hash_original_field = "9EA55D2B918C0F38F9A9DFBE46C9E48E", hash_generated_field = "17FBAB4D0971040901BD780F89591315")

    private ConcurrentHashMap<String, SIPServerTransaction> serverTransactionTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.205 -0400", hash_original_field = "EE1591222A018ABE5572A5C6C0A797E9", hash_generated_field = "F435FECE20B5CE387F33C17D84BA6487")

    private ConcurrentHashMap<String, SIPServerTransaction> mergeTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.205 -0400", hash_original_field = "C755FCEA66E8CB835ECA7BD27067C11E", hash_generated_field = "811B28F45DE9105A274B1DBADE0F6CC9")

    private ConcurrentHashMap<String,SIPServerTransaction> terminatedServerTransactionsPendingAck;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.205 -0400", hash_original_field = "517069402F23F2FF9ABD60CF4C61CBE6", hash_generated_field = "71F6115AE3CDEA5C8D231C9BD5ACFE37")

    private ConcurrentHashMap<String,SIPClientTransaction> forkedClientTransactionTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.205 -0400", hash_original_field = "E36C03BD76A3345DFD7C16B0A9186E53", hash_generated_field = "1D505020FB0AD1A554D62BDC6FA8297B")

    private StackLogger stackLogger;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.205 -0400", hash_original_field = "B90EC493A5834DC9E5B17148F47193CB", hash_generated_field = "5C234A980E10BCEA9B12BAB676094BC2")

    protected ServerLogger serverLogger;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.205 -0400", hash_original_field = "2B177EBBF6652A06414D14C8C50E3B12", hash_generated_field = "1E6D363EB172CF0996091AF3F1ED1415")

    boolean udpFlag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.205 -0400", hash_original_field = "BA389B46C420BB5A0FA673A143939AC1", hash_generated_field = "EF7A4245F4BE46C3FAE858ABF7DB8188")

    protected DefaultRouter defaultRouter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.205 -0400", hash_original_field = "D77703414D2B9CECCE906E75B64E89D7", hash_generated_field = "C4FB0B708AF2FF7CDFB610A006B5BB00")

    protected boolean needsLogging;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.205 -0400", hash_original_field = "D2577D0EF3B7CF3C35702AD5E888A547", hash_generated_field = "39AC5AA3A559BB385B76BB7FCEA06FC5")

    private boolean non2XXAckPassedToListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.205 -0400", hash_original_field = "672BD3EDBEBEC18E145C8AFB0B9BDF65", hash_generated_field = "33EBA2CEF834B663ED5264FE81682D84")

    protected IOHandler ioHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.205 -0400", hash_original_field = "CD991461F11FD761BF6EFA12FCC1C1C3", hash_generated_field = "F86372B43141F18E4A8130BDC70E29CE")

    protected boolean toExit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.206 -0400", hash_original_field = "EDEF96A12B8786AA598020FE493D9164", hash_generated_field = "D4D760F2DD059CF6C01F0C862657BA20")

    protected String stackName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.206 -0400", hash_original_field = "7226454496215DAA32BEDA538263F57C", hash_generated_field = "A47D9D5247AAB165B1980C5D8E37AD58")

    protected String stackAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.206 -0400", hash_original_field = "DF199E0AE132DFDCEDCCCEAA54175F9C", hash_generated_field = "413081F93DE42EB68D8F08C864982E20")

    protected InetAddress stackInetAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.206 -0400", hash_original_field = "D189B5282758DEAD6599821789339DB3", hash_generated_field = "272D1016DEB62E744C52940A3B0E5489")

    protected StackMessageFactory sipMessageFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.206 -0400", hash_original_field = "F3395CD54CF857DDF8F2056768FF49AE", hash_generated_field = "66410D3E71DA473D001977FF3AD7B23B")

    protected javax.sip.address.Router router;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.206 -0400", hash_original_field = "CDE1F9B6C35FC856E715F186A9E26998", hash_generated_field = "C7EB24484DBA63450BB85C2FA7FA489F")

    protected int threadPoolSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.206 -0400", hash_original_field = "1ACBA9188A93F77D3F78F321F92C1912", hash_generated_field = "F74AE6C7EF47828D3A211878D3F5E9F3")

    protected int maxConnections;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.206 -0400", hash_original_field = "340B2E73CA68D1340F1704849DB20F30", hash_generated_field = "3130D9CC177F737BBD6633DB37EE5BF1")

    protected boolean cacheServerConnections;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.206 -0400", hash_original_field = "75061F79A5A3418387A8EAF6F6FAC2F2", hash_generated_field = "768D8EDFC9A10AC079EBDEBB9B0BEA2F")

    protected boolean cacheClientConnections;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.206 -0400", hash_original_field = "7024729D82FD3921C13E8300B02C1CC8", hash_generated_field = "F13115153A6685630697524CF8732D13")

    protected boolean useRouterForAll;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.206 -0400", hash_original_field = "D54EA500688687E7A49846CC9E44F277", hash_generated_field = "DDA86EBC27B96B0FE9D286E6B5C99D02")

    protected int maxContentLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.206 -0400", hash_original_field = "BF1B271FFDC69F10249067CA74EC9584", hash_generated_field = "224FB7FE4F1198F8C1E840FE28932770")

    protected int maxMessageSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.206 -0400", hash_original_field = "074A77F279327ACEE64E9D4AEEC12D99", hash_generated_field = "185A572D15C5BAB5F976AA3554E06D13")

    private Collection<MessageProcessor> messageProcessors;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.206 -0400", hash_original_field = "8FC05721DCBB3B49F66A6D283A300B5B", hash_generated_field = "29792280DB9C85168DEBC57540E5C62A")

    protected int readTimeout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.206 -0400", hash_original_field = "24D13633EB52AF9F8D6DCB3C2ED2C648", hash_generated_field = "F280B3067DE1A528C7BB767557FE00A0")

    protected NetworkLayer networkLayer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.210 -0400", hash_original_field = "96F152D1B09078C3F6C4389AB2CD6114", hash_generated_field = "2DDBEDAE711DD575D314D6FB0824162C")

    protected String outboundProxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.210 -0400", hash_original_field = "9AEE50191BBED6B0890F8E94A389A3CE", hash_generated_field = "E23BB81A391AC77E4B947A6531D7CFF7")

    protected String routerPath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.210 -0400", hash_original_field = "408464B03DDE981FC6F053CF4CA21C22", hash_generated_field = "CBEE3D1CA29ED6AAA4A0BE3A2A3FF707")

    protected boolean isAutomaticDialogSupportEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.210 -0400", hash_original_field = "36969DE269F86EBA5C778849E2D77D36", hash_generated_field = "758951DC734FED546F5FA46D0CD9E244")

    protected HashSet<String> forkedEvents;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.210 -0400", hash_original_field = "30EE0A2AF6038C82623E548CD9ED9924", hash_generated_field = "E3C6781710F35866C48FB724B6E9B0A5")

    protected boolean generateTimeStampHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.210 -0400", hash_original_field = "20CC1F9AF77D0249618487065E0355D3", hash_generated_field = "921A218F1E68F36119322B4C0375D302")

    protected AddressResolver addressResolver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.210 -0400", hash_original_field = "9A4F347B2CDD7A88BC034DE7DE1C49B1", hash_generated_field = "7A3B05571C3C337451929576D2F6F7FC")

    protected int maxListenerResponseTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.210 -0400", hash_original_field = "8CF5659616CF24E603869D9967FC496D", hash_generated_field = "A8CD57032071313BD3D43EAEB0E5D46D")

    protected boolean rfc2543Supported = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.210 -0400", hash_original_field = "06FFC9DFE8BC8EFDE045BBFE8B51D74A", hash_generated_field = "DE990737863BADB7C6E95ED63CC9DC4C")

    protected ThreadAuditor threadAuditor = new ThreadAuditor();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.210 -0400", hash_original_field = "18CF450DF0054CF7D904E6AED9045E84", hash_generated_field = "F94964197FE0E44E12A6BA7E03E51754")

    protected LogRecordFactory logRecordFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.210 -0400", hash_original_field = "597E9AB37EABE3191749A9B8F3F983E9", hash_generated_field = "3713718BCCF6B9DFEBB0EE5CDD91B58B")

    protected boolean cancelClientTransactionChecked = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.211 -0400", hash_original_field = "212D53B82E21ED6882AABA1631FD2487", hash_generated_field = "BCB26F591F1846D975D03FEA861FFBFA")

    protected boolean remoteTagReassignmentAllowed = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.211 -0400", hash_original_field = "8A1ACCA44ACB9074E8500DD26D17C77F", hash_generated_field = "046122FB4660CF86569D7745FB6062FC")

    protected boolean logStackTraceOnMessageSend = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.211 -0400", hash_original_field = "F4917C86121EC97DE5D24BA1E8E3468F", hash_generated_field = "533CF057F33E79CEE3F6C6762D967990")

    protected int receiveUdpBufferSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.211 -0400", hash_original_field = "85144B78F884888A47BFB96276FBAB05", hash_generated_field = "9F0A96DC46E2BE3FA6703B7ECEFC7E7B")

    protected int sendUdpBufferSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.211 -0400", hash_original_field = "7A750FD6F18F1DDA4E38B3D4B5023EE1", hash_generated_field = "D2F44B156E2C7DA4668C7D5F665DAB5F")

    protected boolean stackDoesCongestionControl = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.211 -0400", hash_original_field = "FCC7FD133DB713B98A4D2C108DE01B90", hash_generated_field = "C468B3795A40E24BFA5E22186F8BD92C")

    protected boolean isBackToBackUserAgent = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.211 -0400", hash_original_field = "C6F8194A1D5AF33E9A729F0C8D674D41", hash_generated_field = "30B91514890DCCCE1053BFD830B93F8D")

    protected boolean checkBranchId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.211 -0400", hash_original_field = "DFB941AD6D02702CD41F36C2DCE642A9", hash_generated_field = "2CEA2AC21B7A7C73026A335F4F3A56EB")

    protected boolean isAutomaticDialogErrorHandlingEnabled = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.211 -0400", hash_original_field = "92DDCC06D1B886C4810373F4B5BD040A", hash_generated_field = "8D5939440DC97D0AD4D778E8F452B5A4")

    protected boolean isDialogTerminatedEventDeliveredForNullDialog = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.211 -0400", hash_original_field = "762E796CA8120FD35AC69FAC3C50EC48", hash_generated_field = "67828BA276FD46633F0EC0FF51519F0E")

    protected int maxForkTime = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.222 -0400", hash_original_method = "58A99E16B05D3536C850145BF176F1CB", hash_generated_method = "EA5A650C776E53894F5B3B31C8DFC56E")
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
            boolean var4926B8FB396A99BDD38AA02CC358790B_1001289079 = (getThreadAuditor().isEnabled());
            {
                timer.schedule(new PingTimer(null), 0);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.222 -0400", hash_original_method = "A949ED7F371D2CEC2724714D98F74A81", hash_generated_method = "766B055A4B71BEB66FBCFDFD4443B1FF")
    protected  SIPTransactionStack(StackMessageFactory messageFactory) {
        this();
        this.sipMessageFactory = messageFactory;
        // ---------- Original Method ----------
        //this.sipMessageFactory = messageFactory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.233 -0400", hash_original_method = "4C95AA981C09EEAD5B31E73DC1384B23", hash_generated_method = "61C02BAA41D680288A6BB80F2C21D46A")
    protected void reInit() {
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_1731183237 = (stackLogger.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.234 -0400", hash_original_method = "5E8E9B567A338F9125BE752CD1B53E0E", hash_generated_method = "36FA1502A18965EDF98A3DFC20902DA0")
    public SocketAddress obtainLocalAddress(InetAddress dst, int dstPort,
                    InetAddress localAddress, int localPort) throws IOException {
        SocketAddress varB4EAC82CA7396A68D541C85D26508E83_1021398825 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1021398825 = this.ioHandler.obtainLocalAddress(
                        dst, dstPort, localAddress, localPort);
        addTaint(dst.getTaint());
        addTaint(dstPort);
        addTaint(localAddress.getTaint());
        addTaint(localPort);
        varB4EAC82CA7396A68D541C85D26508E83_1021398825.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1021398825;
        // ---------- Original Method ----------
        //return this.ioHandler.obtainLocalAddress(
                        //dst, dstPort, localAddress, localPort);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.235 -0400", hash_original_method = "6F4F1101C93AB1BC6C07B08D53A20694", hash_generated_method = "5AECE98B1061B15974070DD2B205769A")
    public void disableLogging() {
        this.getStackLogger().disableLogging();
        // ---------- Original Method ----------
        //this.getStackLogger().disableLogging();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.235 -0400", hash_original_method = "28B9C3C3AF577CC75DD224D050447CF4", hash_generated_method = "DD4A6695D325CC79611C0DADF7845085")
    public void enableLogging() {
        this.getStackLogger().enableLogging();
        // ---------- Original Method ----------
        //this.getStackLogger().enableLogging();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.235 -0400", hash_original_method = "F0A4CF0EC627D6BB4B7444677CFA585E", hash_generated_method = "4D3AE0FE244E1AC00A6C47D78B7D0001")
    public void printDialogTable() {
        {
            boolean var53869E3A88D96F4415B2EAEAC904AA86_511425788 = (isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.251 -0400", hash_original_method = "A39FC22DA230CCE4243CA37C766915B4", hash_generated_method = "70FFC0067A08F4CE899C1C496ED6F618")
    public SIPServerTransaction getRetransmissionAlertTransaction(String dialogId) {
        SIPServerTransaction varB4EAC82CA7396A68D541C85D26508E83_450741063 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_450741063 = (SIPServerTransaction) this.retransmissionAlertTransactions.get(dialogId);
        addTaint(dialogId.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_450741063.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_450741063;
        // ---------- Original Method ----------
        //return (SIPServerTransaction) this.retransmissionAlertTransactions.get(dialogId);
    }

    
        public static boolean isDialogCreated(String method) {
        return dialogCreatingMethods.contains(method);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.252 -0400", hash_original_method = "BEE1BC405D1C6F3176E5E5958D511DC6", hash_generated_method = "845CFD8AEA2F4CCD4ADCE95DC0587439")
    public void addExtensionMethod(String extensionMethod) {
        {
            boolean varAD3BC2900BC07B79F07970DF4CB3E3F0_850454728 = (extensionMethod.equals(Request.NOTIFY));
            {
                {
                    boolean varAC370D5D69DCACC466AEF155D6729732_631983441 = (stackLogger.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.253 -0400", hash_original_method = "3AD47119D9E3B66FC61FF1D5407F3E89", hash_generated_method = "3EE2C169B57375DE4287A7F4474F7880")
    public void putDialog(SIPDialog dialog) {
        String dialogId;
        dialogId = dialog.getDialogId();
        {
            boolean var1C796C75795040E4DB7CADAEB51198DB_1720153440 = (dialogTable.containsKey(dialogId));
            {
                {
                    boolean varAC370D5D69DCACC466AEF155D6729732_2041913806 = (stackLogger.isLoggingEnabled());
                    {
                        stackLogger.logDebug("putDialog: dialog already exists" + dialogId + " in table = "
                        + dialogTable.get(dialogId));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_1557899099 = (stackLogger.isLoggingEnabled());
            {
                stackLogger.logDebug("putDialog dialogId=" + dialogId + " dialog = " + dialog);
            } //End block
        } //End collapsed parenthetic
        dialog.setStack(this);
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_305861358 = (stackLogger.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.266 -0400", hash_original_method = "E7A6CF8B50F165B49D6E8637D9CBF9BD", hash_generated_method = "E8282EB64D0D25B576A2B844798C7942")
    public SIPDialog createDialog(SIPTransaction transaction) {
        SIPDialog varB4EAC82CA7396A68D541C85D26508E83_701561947 = null; //Variable for return #1
        SIPDialog retval;
        retval = null;
        {
            String dialogId;
            dialogId = ((SIPRequest) transaction.getRequest()).getDialogId(false);
            {
                boolean var9131AA4695C2C63B631C355FB2D06559_1731071935 = (this.earlyDialogTable.get(dialogId) != null);
                {
                    SIPDialog dialog;
                    dialog = this.earlyDialogTable.get(dialogId);
                    {
                        boolean var402523BFFAD41D51F96075592CB2DE30_1029898951 = (dialog.getState() == null || dialog.getState() == DialogState.EARLY);
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
        varB4EAC82CA7396A68D541C85D26508E83_701561947 = retval;
        addTaint(transaction.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_701561947.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_701561947;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.267 -0400", hash_original_method = "077BDE7287D2ACDD7F2A84D6156CB0F7", hash_generated_method = "BCEE0F21B31BDE3F4084A7B703AB7E9C")
    public SIPDialog createDialog(SIPClientTransaction transaction, SIPResponse sipResponse) {
        SIPDialog varB4EAC82CA7396A68D541C85D26508E83_1807933270 = null; //Variable for return #1
        String dialogId;
        dialogId = ((SIPRequest) transaction.getRequest()).getDialogId(false);
        SIPDialog retval;
        retval = null;
        {
            boolean var4AD019C6981F78972549CB283CBD152C_421066296 = (this.earlyDialogTable.get(dialogId) != null);
            {
                retval = this.earlyDialogTable.get(dialogId);
                {
                    boolean varE9352942E72C1D75CE5290CFFD4E7B6C_516378981 = (sipResponse.isFinalResponse());
                    {
                        this.earlyDialogTable.remove(dialogId);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                retval = new SIPDialog(transaction, sipResponse);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1807933270 = retval;
        addTaint(transaction.getTaint());
        addTaint(sipResponse.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1807933270.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1807933270;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.275 -0400", hash_original_method = "C8019EE35E2246E727D64B4FEC692BA7", hash_generated_method = "4D427BED34BF1F5FB28349B510E4DA09")
    public SIPDialog createDialog(SipProviderImpl sipProvider,
			SIPResponse sipResponse) {
        SIPDialog varB4EAC82CA7396A68D541C85D26508E83_2137545380 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2137545380 = new SIPDialog(sipProvider, sipResponse);
        addTaint(sipProvider.getTaint());
        addTaint(sipResponse.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2137545380.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2137545380;
        // ---------- Original Method ----------
        //return new SIPDialog(sipProvider, sipResponse);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.276 -0400", hash_original_method = "C20BEEC896962D7D1856EB72C0C34791", hash_generated_method = "CEB4ABAF10A6E0B55D717519741DF7BD")
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
                boolean var35096A2446A1B79EB944A5339DDF5D2F_1566490288 = (!dialog.testAndSetIsDialogTerminatedEventDelivered());
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
                boolean var35096A2446A1B79EB944A5339DDF5D2F_468086024 = (!dialog.testAndSetIsDialogTerminatedEventDelivered());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.276 -0400", hash_original_method = "7CD5A4CB12647D3BBBFDC040A2B5E183", hash_generated_method = "61552DFA36DA0CB1C9DF11FBBF88F70C")
    public SIPDialog getDialog(String dialogId) {
        SIPDialog varB4EAC82CA7396A68D541C85D26508E83_2143396833 = null; //Variable for return #1
        SIPDialog sipDialog;
        sipDialog = (SIPDialog) dialogTable.get(dialogId);
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_1917155991 = (stackLogger.isLoggingEnabled());
            {
                stackLogger.logDebug("getDialog(" + dialogId + ") : returning " + sipDialog);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_2143396833 = sipDialog;
        addTaint(dialogId.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2143396833.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2143396833;
        // ---------- Original Method ----------
        //SIPDialog sipDialog = (SIPDialog) dialogTable.get(dialogId);
        //if (stackLogger.isLoggingEnabled()) {
            //stackLogger.logDebug("getDialog(" + dialogId + ") : returning " + sipDialog);
        //}
        //return sipDialog;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.277 -0400", hash_original_method = "B0D51307A4FC266FC1D02389AEE54D05", hash_generated_method = "0CB803BD9B23EAF5E417DDADE1EE54E4")
    public void removeDialog(String dialogId) {
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_193663291 = (stackLogger.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.287 -0400", hash_original_method = "5BA8167D6AC26A2C080E0DF071E238DD", hash_generated_method = "20E2F14CE9E72A99E242C83F60A2C0D1")
    public SIPClientTransaction findSubscribeTransaction(SIPRequest notifyMessage,
            ListeningPointImpl listeningPoint) {
        SIPClientTransaction varB4EAC82CA7396A68D541C85D26508E83_506229522 = null; //Variable for return #1
        SIPClientTransaction varB4EAC82CA7396A68D541C85D26508E83_1649414403 = null; //Variable for return #2
        SIPClientTransaction varB4EAC82CA7396A68D541C85D26508E83_1688511569 = null; //Variable for return #3
        SIPClientTransaction varB4EAC82CA7396A68D541C85D26508E83_1038348160 = null; //Variable for return #4
        SIPClientTransaction retval;
        retval = null;
        try 
        {
            Iterator it;
            it = clientTransactionTable.values().iterator();
            {
                boolean varCEA0B8AAFFB6C70BF01D444180FAAB1F_582060038 = (stackLogger.isLoggingEnabled());
                stackLogger.logDebug("ct table size = " + clientTransactionTable.size());
            } //End collapsed parenthetic
            String thisToTag;
            thisToTag = notifyMessage.getTo().getTag();
            {
                varB4EAC82CA7396A68D541C85D26508E83_506229522 = retval;
            } //End block
            Event eventHdr;
            eventHdr = (Event) notifyMessage.getHeader(EventHeader.NAME);
            {
                {
                    boolean varAC370D5D69DCACC466AEF155D6729732_957445425 = (stackLogger.isLoggingEnabled());
                    {
                        stackLogger.logDebug("event Header is null -- returning null");
                    } //End block
                } //End collapsed parenthetic
                varB4EAC82CA7396A68D541C85D26508E83_1649414403 = retval;
            } //End block
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1236892310 = (it.hasNext());
                {
                    SIPClientTransaction ct;
                    ct = (SIPClientTransaction) it.next();
                    {
                        boolean varCFF1A0705DCC3B6E112E467A6D493F5D_1725092902 = (!ct.getMethod().equals(Request.SUBSCRIBE));
                    } //End collapsed parenthetic
                    String fromTag;
                    fromTag = ct.from.getTag();
                    Event hisEvent;
                    hisEvent = ct.event;
                    {
                        boolean varD2993363F7AFB86CA04E191D1274040B_1500745819 = (stackLogger.isLoggingEnabled());
                        {
                            stackLogger.logDebug("ct.fromTag = " + fromTag);
                            stackLogger.logDebug("thisToTag = " + thisToTag);
                            stackLogger.logDebug("hisEvent = " + hisEvent);
                            stackLogger.logDebug("eventHdr " + eventHdr);
                        } //End block
                    } //End collapsed parenthetic
                    {
                        boolean var6ED9F094D5E7B37CADC33B9F7291C0D3_1621541048 = (fromTag.equalsIgnoreCase(thisToTag)
                      && hisEvent != null
                      && eventHdr.match(hisEvent)
                      && notifyMessage.getCallId().getCallId().equalsIgnoreCase(
                                ct.callId.getCallId()));
                        {
                            {
                                boolean var9282859C10B3BDA9643C67160A68D9EE_1030598440 = (ct.acquireSem());
                                retval = ct;
                            } //End collapsed parenthetic
                            varB4EAC82CA7396A68D541C85D26508E83_1688511569 = retval;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1038348160 = retval;
        } //End block
        finally 
        {
            {
                boolean varCEA0B8AAFFB6C70BF01D444180FAAB1F_1073715110 = (stackLogger.isLoggingEnabled());
                stackLogger.logDebug("findSubscribeTransaction : returning " + retval);
            } //End collapsed parenthetic
        } //End block
        addTaint(notifyMessage.getTaint());
        addTaint(listeningPoint.getTaint());
        SIPClientTransaction varA7E53CE21691AB073D9660D615818899_1267758157; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1267758157 = varB4EAC82CA7396A68D541C85D26508E83_506229522;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1267758157 = varB4EAC82CA7396A68D541C85D26508E83_1649414403;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1267758157 = varB4EAC82CA7396A68D541C85D26508E83_1688511569;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1267758157 = varB4EAC82CA7396A68D541C85D26508E83_1038348160;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1267758157.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1267758157;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.288 -0400", hash_original_method = "D49C9B94E89B7FEA3320280273306438", hash_generated_method = "F90D32E584EF24DDC40255D1329DAA8C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.289 -0400", hash_original_method = "37709198085D538D169FF1DE9D9ADB9C", hash_generated_method = "9DE1D8FA7FC52DB7F030839E02C4E5D2")
    public SIPServerTransaction findTransactionPendingAck(SIPRequest ackMessage) {
        SIPServerTransaction varB4EAC82CA7396A68D541C85D26508E83_2050549420 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2050549420 = this.terminatedServerTransactionsPendingAck.get(ackMessage.getTopmostVia().getBranch());
        addTaint(ackMessage.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2050549420.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2050549420;
        // ---------- Original Method ----------
        //return this.terminatedServerTransactionsPendingAck.get(ackMessage.getTopmostVia().getBranch());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.289 -0400", hash_original_method = "B481CD0C272F0294325516CB58C4D625", hash_generated_method = "59AE1F8D22ED9F16CDA59E0BAC6958D0")
    public boolean removeTransactionPendingAck(SIPServerTransaction serverTransaction) {
        String branchId;
        branchId = ((SIPRequest)serverTransaction.getRequest()).getTopmostVia().getBranch();
        {
            boolean varEBE195BF36968B3D949EA3A425E49317_587294086 = (branchId != null && this.terminatedServerTransactionsPendingAck.containsKey(branchId));
            {
                this.terminatedServerTransactionsPendingAck.remove(branchId);
            } //End block
        } //End collapsed parenthetic
        addTaint(serverTransaction.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1850875339 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1850875339;
        // ---------- Original Method ----------
        //String branchId = ((SIPRequest)serverTransaction.getRequest()).getTopmostVia().getBranch();
        //if ( branchId != null && this.terminatedServerTransactionsPendingAck.containsKey(branchId) ) {
            //this.terminatedServerTransactionsPendingAck.remove(branchId);
            //return true;
        //} else {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.290 -0400", hash_original_method = "E118D63661EEDB81E619AEC2D5F479DE", hash_generated_method = "F2BD7EAC23459B44FC621948657F83C2")
    public boolean isTransactionPendingAck(SIPServerTransaction serverTransaction) {
        String branchId;
        branchId = ((SIPRequest)serverTransaction.getRequest()).getTopmostVia().getBranch();
        boolean var4577C4FD500FC681BA07DFDB97EB4243_1455487887 = (this.terminatedServerTransactionsPendingAck.contains(branchId));
        addTaint(serverTransaction.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1122432897 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1122432897;
        // ---------- Original Method ----------
        //String branchId = ((SIPRequest)serverTransaction.getRequest()).getTopmostVia().getBranch();
        //return this.terminatedServerTransactionsPendingAck.contains(branchId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.291 -0400", hash_original_method = "CFF098965464555AD1B1F596C34C16A1", hash_generated_method = "1D37D971AC0A2157CF3DB664EF8897EB")
    public SIPTransaction findTransaction(SIPMessage sipMessage, boolean isServer) {
        SIPTransaction varB4EAC82CA7396A68D541C85D26508E83_1026313101 = null; //Variable for return #1
        SIPTransaction varB4EAC82CA7396A68D541C85D26508E83_189010970 = null; //Variable for return #2
        SIPTransaction varB4EAC82CA7396A68D541C85D26508E83_1732307169 = null; //Variable for return #3
        SIPTransaction varB4EAC82CA7396A68D541C85D26508E83_102972806 = null; //Variable for return #4
        SIPTransaction varB4EAC82CA7396A68D541C85D26508E83_27765203 = null; //Variable for return #5
        SIPTransaction retval;
        retval = null;
        try 
        {
            {
                Via via;
                via = sipMessage.getTopmostVia();
                {
                    boolean var240DE521E282CF4DDD1501CDC8DEB0BE_600987194 = (via.getBranch() != null);
                    {
                        String key;
                        key = sipMessage.getTransactionId();
                        retval = (SIPTransaction) serverTransactionTable.get(key);
                        {
                            boolean varDFC91DFB4BB95E42F71B00E05C1AFFB9_137932917 = (stackLogger.isLoggingEnabled());
                            getStackLogger().logDebug(
                                "serverTx: looking for key " + key + " existing="
                                + serverTransactionTable);
                        } //End collapsed parenthetic
                        {
                            boolean var824837A9145CA2EC03C0E877A985B1E6_374844900 = (key.startsWith(SIPConstants.BRANCH_MAGIC_COOKIE_LOWER_CASE));
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_1026313101 = retval;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                Iterator<SIPServerTransaction> it;
                it = serverTransactionTable.values().iterator();
                {
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_1711221015 = (it.hasNext());
                    {
                        SIPServerTransaction sipServerTransaction;
                        sipServerTransaction = (SIPServerTransaction) it.next();
                        {
                            boolean varF6051FB334F93F8949404856131DFA0F_1568099623 = (sipServerTransaction.isMessagePartOfTransaction(sipMessage));
                            {
                                retval = sipServerTransaction;
                                varB4EAC82CA7396A68D541C85D26508E83_189010970 = retval;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                Via via;
                via = sipMessage.getTopmostVia();
                {
                    boolean var240DE521E282CF4DDD1501CDC8DEB0BE_994687588 = (via.getBranch() != null);
                    {
                        String key;
                        key = sipMessage.getTransactionId();
                        {
                            boolean varDFC91DFB4BB95E42F71B00E05C1AFFB9_1154009763 = (stackLogger.isLoggingEnabled());
                            getStackLogger().logDebug("clientTx: looking for key " + key);
                        } //End collapsed parenthetic
                        retval = (SIPTransaction) clientTransactionTable.get(key);
                        {
                            boolean var824837A9145CA2EC03C0E877A985B1E6_1255203717 = (key.startsWith(SIPConstants.BRANCH_MAGIC_COOKIE_LOWER_CASE));
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_1732307169 = retval;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                Iterator<SIPClientTransaction> it;
                it = clientTransactionTable.values().iterator();
                {
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_1175070781 = (it.hasNext());
                    {
                        SIPClientTransaction clientTransaction;
                        clientTransaction = (SIPClientTransaction) it.next();
                        {
                            boolean var35F8E4FD38F5FA1A650C87F5120892B2_857135689 = (clientTransaction.isMessagePartOfTransaction(sipMessage));
                            {
                                retval = clientTransaction;
                                varB4EAC82CA7396A68D541C85D26508E83_102972806 = retval;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        finally 
        {
            {
                boolean varDED775332D522DB4765B6C0D6DAB9C7F_1499182753 = (this.getStackLogger().isLoggingEnabled());
                {
                    this.getStackLogger().logDebug("findTransaction: returning  : " + retval);
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_27765203 = retval;
        addTaint(sipMessage.getTaint());
        addTaint(isServer);
        SIPTransaction varA7E53CE21691AB073D9660D615818899_1529171428; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1529171428 = varB4EAC82CA7396A68D541C85D26508E83_1026313101;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1529171428 = varB4EAC82CA7396A68D541C85D26508E83_189010970;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1529171428 = varB4EAC82CA7396A68D541C85D26508E83_1732307169;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1529171428 = varB4EAC82CA7396A68D541C85D26508E83_102972806;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1529171428 = varB4EAC82CA7396A68D541C85D26508E83_27765203;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1529171428.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1529171428;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.311 -0400", hash_original_method = "EBA76BEAE03DA80AC45DCE1E9705412D", hash_generated_method = "189D3B545B675891A5E719B8ED28AC93")
    public SIPTransaction findCancelTransaction(SIPRequest cancelRequest, boolean isServer) {
        SIPTransaction varB4EAC82CA7396A68D541C85D26508E83_598822124 = null; //Variable for return #1
        SIPTransaction varB4EAC82CA7396A68D541C85D26508E83_1586718893 = null; //Variable for return #2
        SIPTransaction varB4EAC82CA7396A68D541C85D26508E83_1841754426 = null; //Variable for return #3
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_912356288 = (stackLogger.isLoggingEnabled());
            {
                stackLogger.logDebug("findCancelTransaction request= \n" + cancelRequest
                    + "\nfindCancelRequest isServer=" + isServer);
            } //End block
        } //End collapsed parenthetic
        {
            Iterator<SIPServerTransaction> li;
            li = this.serverTransactionTable.values().iterator();
            {
                boolean varD1722E42EA3CA8952F93B6521D875E61_898808300 = (li.hasNext());
                {
                    SIPTransaction transaction;
                    transaction = (SIPTransaction) li.next();
                    SIPServerTransaction sipServerTransaction;
                    sipServerTransaction = (SIPServerTransaction) transaction;
                    {
                        boolean var63C9AAE72219DF269358A97F4B9DD737_2011506112 = (sipServerTransaction.doesCancelMatchTransaction(cancelRequest));
                        varB4EAC82CA7396A68D541C85D26508E83_598822124 = sipServerTransaction;
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            Iterator<SIPClientTransaction> li;
            li = this.clientTransactionTable.values().iterator();
            {
                boolean varD1722E42EA3CA8952F93B6521D875E61_1294853140 = (li.hasNext());
                {
                    SIPTransaction transaction;
                    transaction = (SIPTransaction) li.next();
                    SIPClientTransaction sipClientTransaction;
                    sipClientTransaction = (SIPClientTransaction) transaction;
                    {
                        boolean varAEAD15F06F6B78E29169322410091CA1_1866476062 = (sipClientTransaction.doesCancelMatchTransaction(cancelRequest));
                        varB4EAC82CA7396A68D541C85D26508E83_1586718893 = sipClientTransaction;
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_146332194 = (stackLogger.isLoggingEnabled());
            stackLogger.logDebug("Could not find transaction for cancel request");
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1841754426 = null;
        addTaint(cancelRequest.getTaint());
        addTaint(isServer);
        SIPTransaction varA7E53CE21691AB073D9660D615818899_364123416; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_364123416 = varB4EAC82CA7396A68D541C85D26508E83_598822124;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_364123416 = varB4EAC82CA7396A68D541C85D26508E83_1586718893;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_364123416 = varB4EAC82CA7396A68D541C85D26508E83_1841754426;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_364123416.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_364123416;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.311 -0400", hash_original_method = "C32886C5E5EF95CE74E82DCEA7E677B6", hash_generated_method = "86585D28FAC5BB300977672831979BA8")
    public SIPServerTransaction findPendingTransaction(SIPRequest requestReceived) {
        SIPServerTransaction varB4EAC82CA7396A68D541C85D26508E83_275331335 = null; //Variable for return #1
        {
            boolean var11C62F83477FD0505FB5BB12080FBCDA_594446403 = (this.stackLogger.isLoggingEnabled());
            {
                this.stackLogger.logDebug("looking for pending tx for :"
                    + requestReceived.getTransactionId());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_275331335 = (SIPServerTransaction) pendingTransactions.get(requestReceived.getTransactionId());
        addTaint(requestReceived.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_275331335.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_275331335;
        // ---------- Original Method ----------
        //if (this.stackLogger.isLoggingEnabled()) {
            //this.stackLogger.logDebug("looking for pending tx for :"
                    //+ requestReceived.getTransactionId());
        //}
        //return (SIPServerTransaction) pendingTransactions.get(requestReceived.getTransactionId());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.449 -0400", hash_original_method = "DE7BCEF3CEAF7F5E4F7BCE647A148129", hash_generated_method = "7B98F0861ACBA43E2FFA6495B3FE57C5")
    public SIPServerTransaction findMergedTransaction(SIPRequest sipRequest) {
        SIPServerTransaction varB4EAC82CA7396A68D541C85D26508E83_183130791 = null; //Variable for return #1
        SIPServerTransaction varB4EAC82CA7396A68D541C85D26508E83_608136733 = null; //Variable for return #2
        SIPServerTransaction varB4EAC82CA7396A68D541C85D26508E83_655719899 = null; //Variable for return #3
        SIPServerTransaction varB4EAC82CA7396A68D541C85D26508E83_1616097541 = null; //Variable for return #4
        SIPServerTransaction varB4EAC82CA7396A68D541C85D26508E83_306435772 = null; //Variable for return #5
        {
            boolean varEB91205F9E3B5AB16C809B69E830E585_1688152672 = (! sipRequest.getMethod().equals(Request.INVITE));
            {
                varB4EAC82CA7396A68D541C85D26508E83_183130791 = null;
            } //End block
        } //End collapsed parenthetic
        String mergeId;
        mergeId = sipRequest.getMergeId();
        SIPServerTransaction mergedTransaction;
        mergedTransaction = (SIPServerTransaction) this.mergeTable.get(mergeId);
        {
            varB4EAC82CA7396A68D541C85D26508E83_608136733 = null;
        } //End block
        {
            boolean varDD5DC8FFD549FCFBE54C0C4063924793_1784844672 = (mergedTransaction != null && !mergedTransaction.isMessagePartOfTransaction(sipRequest));
            {
                varB4EAC82CA7396A68D541C85D26508E83_655719899 = mergedTransaction;
            } //End block
            {
                {
                    Iterator<Dialog> var13FA49F9AC884432F840638793CBDD7F_1139307512 = (this.dialogTable.values()).iterator();
                    var13FA49F9AC884432F840638793CBDD7F_1139307512.hasNext();
                    Dialog dialog = var13FA49F9AC884432F840638793CBDD7F_1139307512.next();
                    {
                        SIPDialog sipDialog;
                        sipDialog = (SIPDialog) dialog;
                        {
                            boolean varF35A178555525ACF54ED52DD1E0580BB_472023155 = (sipDialog.getFirstTransaction()  != null && 
                   sipDialog.getFirstTransaction() instanceof ServerTransaction);
                            {
                                SIPServerTransaction serverTransaction;
                                serverTransaction = ((SIPServerTransaction) sipDialog.getFirstTransaction());
                                SIPRequest transactionRequest;
                                transactionRequest = ((SIPServerTransaction) sipDialog.getFirstTransaction()).getOriginalRequest();
                                {
                                    boolean var38302743A39D1C992E94EBEE863951D6_1575193391 = ((! serverTransaction.isMessagePartOfTransaction(sipRequest))
                           && sipRequest.getMergeId().equals(transactionRequest.getMergeId()));
                                    {
                                        varB4EAC82CA7396A68D541C85D26508E83_1616097541 = (SIPServerTransaction) sipDialog.getFirstTransaction();
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                varB4EAC82CA7396A68D541C85D26508E83_306435772 = null;
            } //End block
        } //End collapsed parenthetic
        addTaint(sipRequest.getTaint());
        SIPServerTransaction varA7E53CE21691AB073D9660D615818899_1090151600; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1090151600 = varB4EAC82CA7396A68D541C85D26508E83_183130791;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1090151600 = varB4EAC82CA7396A68D541C85D26508E83_608136733;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1090151600 = varB4EAC82CA7396A68D541C85D26508E83_655719899;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1090151600 = varB4EAC82CA7396A68D541C85D26508E83_1616097541;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1090151600 = varB4EAC82CA7396A68D541C85D26508E83_306435772;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1090151600.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1090151600;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.452 -0400", hash_original_method = "365415518ECAE79EAD0CD2C9D4462A78", hash_generated_method = "CD9EB28B97BD41E21D65D4F2E00A00A8")
    public void removePendingTransaction(SIPServerTransaction tr) {
        {
            boolean var11C62F83477FD0505FB5BB12080FBCDA_2131841336 = (this.stackLogger.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.452 -0400", hash_original_method = "DB6ED2CEA840316B4782573C88C3E1FC", hash_generated_method = "5594CDD77F4036D0841F453EC09AACFB")
    public void removeFromMergeTable(SIPServerTransaction tr) {
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_937238647 = (stackLogger.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.453 -0400", hash_original_method = "4DF3A9A601EFF55EEB4CCC4D0E1A4382", hash_generated_method = "214FA5ED9F021DB03AAAA39CC0F3A2EE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.453 -0400", hash_original_method = "8109166214A5696534573E329912E2B5", hash_generated_method = "8CD4392F319236190EC8ABBEE623354A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.458 -0400", hash_original_method = "C3F915B9919F99B9388976510DFE400E", hash_generated_method = "4701EEF10D4117BE69CE8BAFC7462056")
    public ServerRequestInterface newSIPServerRequest(SIPRequest requestReceived,
            MessageChannel requestMessageChannel) {
        ServerRequestInterface varB4EAC82CA7396A68D541C85D26508E83_1778467341 = null; //Variable for return #1
        ServerRequestInterface varB4EAC82CA7396A68D541C85D26508E83_994800432 = null; //Variable for return #2
        ServerRequestInterface varB4EAC82CA7396A68D541C85D26508E83_1923147311 = null; //Variable for return #3
        ServerRequestInterface varB4EAC82CA7396A68D541C85D26508E83_1514601038 = null; //Variable for return #4
        ServerRequestInterface varB4EAC82CA7396A68D541C85D26508E83_545207224 = null; //Variable for return #5
        Iterator<SIPServerTransaction> transactionIterator;
        SIPServerTransaction nextTransaction;
        SIPServerTransaction currentTransaction;
        String key;
        key = requestReceived.getTransactionId();
        requestReceived.setMessageChannel(requestMessageChannel);
        currentTransaction = (SIPServerTransaction) serverTransactionTable.get(key);
        {
            boolean varD5F22D6501778D69EFB1B4C78D1BC071_2042179984 = (currentTransaction == null
                || !currentTransaction.isMessagePartOfTransaction(requestReceived));
            {
                transactionIterator = serverTransactionTable.values().iterator();
                currentTransaction = null;
                {
                    boolean varDF525999E4178F83F821F7840AF0A701_1583864640 = (!key.toLowerCase().startsWith(SIPConstants.BRANCH_MAGIC_COOKIE_LOWER_CASE));
                    {
                        {
                            boolean varE06F989DC131B262AEF6DA55B8F8DDB2_1862549058 = (transactionIterator.hasNext() && currentTransaction == null);
                            {
                                nextTransaction = (SIPServerTransaction) transactionIterator.next();
                                {
                                    boolean var7384431C022BEE094664534666A1D7AF_1191130663 = (nextTransaction.isMessagePartOfTransaction(requestReceived));
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
                            boolean varC390E2A5DFAA4F7FA1689CB7638E2EB7_1835324187 = (currentTransaction != null && currentTransaction.acquireSem());
                            varB4EAC82CA7396A68D541C85D26508E83_1778467341 = currentTransaction;
                            varB4EAC82CA7396A68D541C85D26508E83_994800432 = null;
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
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_943782673 = (stackLogger.isLoggingEnabled());
            {
                stackLogger.logDebug("newSIPServerRequest( " + requestReceived.getMethod() + ":"
                    + requestReceived.getTopmostVia().getBranch() + "):" + currentTransaction);
            } //End block
        } //End collapsed parenthetic
        currentTransaction.setRequestInterface(sipMessageFactory.newSIPServerRequest(
                    requestReceived, currentTransaction));
        {
            boolean var0F6C442AF508B1ABAB943F4C4B4ED076_1744367004 = (currentTransaction != null && currentTransaction.acquireSem());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1923147311 = currentTransaction;
            } //End block
            {
                try 
                {
                    {
                        boolean var73C027315BBD0DCC1A552716D2DA9C61_218882537 = (currentTransaction.isMessagePartOfTransaction(requestReceived) &&
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
                        boolean var86B7E4A6EFF1453FB71811BCAA5C5B32_841383974 = (isLoggingEnabled());
                        stackLogger.logError("Exception occured sending TRYING");
                    } //End collapsed parenthetic
                } //End block
                varB4EAC82CA7396A68D541C85D26508E83_1514601038 = null;
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_545207224 = null;
            } //End block
        } //End collapsed parenthetic
        addTaint(requestReceived.getTaint());
        addTaint(requestMessageChannel.getTaint());
        ServerRequestInterface varA7E53CE21691AB073D9660D615818899_1539747103; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1539747103 = varB4EAC82CA7396A68D541C85D26508E83_1778467341;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1539747103 = varB4EAC82CA7396A68D541C85D26508E83_994800432;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1539747103 = varB4EAC82CA7396A68D541C85D26508E83_1923147311;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1539747103 = varB4EAC82CA7396A68D541C85D26508E83_1514601038;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1539747103 = varB4EAC82CA7396A68D541C85D26508E83_545207224;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1539747103.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1539747103;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.478 -0400", hash_original_method = "62ADB5DE3DAA611F01F5B25EB82A32E9", hash_generated_method = "4634F4922F2883C9F633EDAE027638CD")
    public ServerResponseInterface newSIPServerResponse(SIPResponse responseReceived,
            MessageChannel responseMessageChannel) {
        ServerResponseInterface varB4EAC82CA7396A68D541C85D26508E83_1614753957 = null; //Variable for return #1
        ServerResponseInterface varB4EAC82CA7396A68D541C85D26508E83_317528511 = null; //Variable for return #2
        ServerResponseInterface varB4EAC82CA7396A68D541C85D26508E83_390905432 = null; //Variable for return #3
        ServerResponseInterface varB4EAC82CA7396A68D541C85D26508E83_1128663765 = null; //Variable for return #4
        Iterator<SIPClientTransaction> transactionIterator;
        SIPClientTransaction nextTransaction;
        SIPClientTransaction currentTransaction;
        String key;
        key = responseReceived.getTransactionId();
        currentTransaction = (SIPClientTransaction) clientTransactionTable.get(key);
        {
            boolean varFD65E86793E7DA9A4559DFCAD3FE7A38_84882302 = (currentTransaction == null
                || (!currentTransaction.isMessagePartOfTransaction(responseReceived) && !key
                        .startsWith(SIPConstants.BRANCH_MAGIC_COOKIE_LOWER_CASE)));
            {
                transactionIterator = clientTransactionTable.values().iterator();
                currentTransaction = null;
                {
                    boolean var02E71BDB7FE3E53290C9D60F6709CA78_1112632497 = (transactionIterator.hasNext() && currentTransaction == null);
                    {
                        nextTransaction = (SIPClientTransaction) transactionIterator.next();
                        {
                            boolean varB7132609472FD4E761BE7525D40545ED_1737882921 = (nextTransaction.isMessagePartOfTransaction(responseReceived));
                            {
                                currentTransaction = nextTransaction;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    {
                        boolean var0954F7596F6CFAF1C1D43DD490BBFB96_300391488 = (this.stackLogger.isLoggingEnabled(StackLogger.TRACE_INFO));
                        {
                            responseMessageChannel.logResponse(responseReceived, System
                            .currentTimeMillis(), "before processing");
                        } //End block
                    } //End collapsed parenthetic
                    varB4EAC82CA7396A68D541C85D26508E83_1614753957 = sipMessageFactory.newSIPServerResponse(responseReceived,
                        responseMessageChannel);
                } //End block
            } //End block
        } //End collapsed parenthetic
        boolean acquired;
        acquired = currentTransaction.acquireSem();
        {
            boolean var052D788439DC89D4EA99379C3615ED1C_1681737798 = (this.stackLogger.isLoggingEnabled(StackLogger.TRACE_INFO));
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
                    boolean varB994156BC51EB47795FEDC6186A6DA25_1932777098 = (this.stackLogger.isLoggingEnabled());
                    {
                        this.stackLogger.logDebug("returning null - serverResponseInterface is null!");
                    } //End block
                } //End collapsed parenthetic
                currentTransaction.releaseSem();
                varB4EAC82CA7396A68D541C85D26508E83_317528511 = null;
            } //End block
        } //End block
        {
            {
                boolean varCEA0B8AAFFB6C70BF01D444180FAAB1F_1413864958 = (stackLogger.isLoggingEnabled());
                this.stackLogger.logDebug("Could not aquire semaphore !!");
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_390905432 = currentTransaction;
        varB4EAC82CA7396A68D541C85D26508E83_1128663765 = null;
        addTaint(responseReceived.getTaint());
        addTaint(responseMessageChannel.getTaint());
        ServerResponseInterface varA7E53CE21691AB073D9660D615818899_604577882; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_604577882 = varB4EAC82CA7396A68D541C85D26508E83_1614753957;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_604577882 = varB4EAC82CA7396A68D541C85D26508E83_317528511;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_604577882 = varB4EAC82CA7396A68D541C85D26508E83_390905432;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_604577882 = varB4EAC82CA7396A68D541C85D26508E83_1128663765;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_604577882.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_604577882;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.484 -0400", hash_original_method = "32F3E8827D13E0BAFD4E9DD3BE9CB370", hash_generated_method = "29F1D06E2728637FE1FDCD06BDF8A32D")
    public MessageChannel createMessageChannel(SIPRequest request, MessageProcessor mp,
            Hop nextHop) throws IOException {
        MessageChannel varB4EAC82CA7396A68D541C85D26508E83_791277539 = null; //Variable for return #1
        MessageChannel varB4EAC82CA7396A68D541C85D26508E83_822164385 = null; //Variable for return #2
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
        varB4EAC82CA7396A68D541C85D26508E83_791277539 = null;
        returnChannel = createClientTransaction(request, mc);
        ((SIPClientTransaction) returnChannel).setViaPort(nextHop.getPort());
        ((SIPClientTransaction) returnChannel).setViaHost(nextHop.getHost());
        addTransactionHash(returnChannel);
        varB4EAC82CA7396A68D541C85D26508E83_822164385 = returnChannel;
        addTaint(request.getTaint());
        addTaint(mp.getTaint());
        addTaint(nextHop.getTaint());
        MessageChannel varA7E53CE21691AB073D9660D615818899_1216150566; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1216150566 = varB4EAC82CA7396A68D541C85D26508E83_791277539;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1216150566 = varB4EAC82CA7396A68D541C85D26508E83_822164385;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1216150566.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1216150566;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.487 -0400", hash_original_method = "912DB48513D0A0D8594B2E782158C138", hash_generated_method = "8AC11D58C95FF4D8BEF287CA3B673C49")
    public SIPClientTransaction createClientTransaction(SIPRequest sipRequest,
            MessageChannel encapsulatedMessageChannel) {
        SIPClientTransaction varB4EAC82CA7396A68D541C85D26508E83_426825425 = null; //Variable for return #1
        SIPClientTransaction ct;
        ct = new SIPClientTransaction(this, encapsulatedMessageChannel);
        ct.setOriginalRequest(sipRequest);
        varB4EAC82CA7396A68D541C85D26508E83_426825425 = ct;
        addTaint(sipRequest.getTaint());
        addTaint(encapsulatedMessageChannel.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_426825425.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_426825425;
        // ---------- Original Method ----------
        //SIPClientTransaction ct = new SIPClientTransaction(this, encapsulatedMessageChannel);
        //ct.setOriginalRequest(sipRequest);
        //return ct;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.488 -0400", hash_original_method = "81B760547C7425A938D45D7063876C66", hash_generated_method = "DF46A9EEBBF16DC701A8239B81BDDA66")
    public SIPServerTransaction createServerTransaction(MessageChannel encapsulatedMessageChannel) {
        SIPServerTransaction varB4EAC82CA7396A68D541C85D26508E83_1152542765 = null; //Variable for return #1
        SIPServerTransaction varB4EAC82CA7396A68D541C85D26508E83_49732157 = null; //Variable for return #2
        SIPServerTransaction varB4EAC82CA7396A68D541C85D26508E83_687098108 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_1152542765 = new SIPServerTransaction(this, encapsulatedMessageChannel);
        } //End block
        {
            float threshold;
            threshold = ((float) (serverTransactionTable.size() - serverTransactionTableLowaterMark))
                    / ((float) (serverTransactionTableHighwaterMark - serverTransactionTableLowaterMark));
            boolean decision;
            decision = Math.random() > 1.0 - threshold;
            {
                varB4EAC82CA7396A68D541C85D26508E83_49732157 = null;
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_687098108 = new SIPServerTransaction(this, encapsulatedMessageChannel);
            } //End block
        } //End block
        addTaint(encapsulatedMessageChannel.getTaint());
        SIPServerTransaction varA7E53CE21691AB073D9660D615818899_1079224376; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1079224376 = varB4EAC82CA7396A68D541C85D26508E83_1152542765;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1079224376 = varB4EAC82CA7396A68D541C85D26508E83_49732157;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1079224376 = varB4EAC82CA7396A68D541C85D26508E83_687098108;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1079224376.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1079224376;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.488 -0400", hash_original_method = "2775112CA96E4BBD847FD3F2A14A81DE", hash_generated_method = "F8E70AAD8CCB60E1CFAFB907D8796402")
    public int getClientTransactionTableSize() {
        int var03DB7AB6196DC5D0E9988C142D712431_1793153668 = (this.clientTransactionTable.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_821547987 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_821547987;
        // ---------- Original Method ----------
        //return this.clientTransactionTable.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.489 -0400", hash_original_method = "4372809DD9897424686B6F4A147D93FA", hash_generated_method = "9BC3DA9BC46F3289DA8558477DAA98C8")
    public int getServerTransactionTableSize() {
        int var7FEDB251634EBCF9A56CDDB387AADB7C_87233996 = (this.serverTransactionTable.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_667684188 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_667684188;
        // ---------- Original Method ----------
        //return this.serverTransactionTable.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.491 -0400", hash_original_method = "2F0441D135E4CBEEA76B3CCA00FAD23B", hash_generated_method = "996A0B31A0496DCD798A237305074BE6")
    public void addTransaction(SIPClientTransaction clientTransaction) {
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_789350104 = (stackLogger.isLoggingEnabled());
            stackLogger.logDebug("added transaction " + clientTransaction);
        } //End collapsed parenthetic
        addTransactionHash(clientTransaction);
        addTaint(clientTransaction.getTaint());
        // ---------- Original Method ----------
        //if (stackLogger.isLoggingEnabled())
            //stackLogger.logDebug("added transaction " + clientTransaction);
        //addTransactionHash(clientTransaction);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.493 -0400", hash_original_method = "FC7C0EB4C2CF25B4E39BD000BE1A0318", hash_generated_method = "F7742EECC052D7272E75DD3DCAC07931")
    public void removeTransaction(SIPTransaction sipTransaction) {
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_1773419628 = (stackLogger.isLoggingEnabled());
            {
                stackLogger.logDebug("Removing Transaction = " + sipTransaction.getTransactionId()
                    + " transaction = " + sipTransaction);
            } //End block
        } //End collapsed parenthetic
        {
            {
                boolean varCEA0B8AAFFB6C70BF01D444180FAAB1F_1950377033 = (stackLogger.isLoggingEnabled());
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
                boolean varCD28D341484E6B95D2F46E243D03836E_1648516715 = (method.equalsIgnoreCase(Request.INVITE));
                {
                    this.removeFromMergeTable((SIPServerTransaction) sipTransaction);
                } //End block
            } //End collapsed parenthetic
            SipProviderImpl sipProvider;
            sipProvider = (SipProviderImpl) sipTransaction.getSipProvider();
            {
                boolean var1213E4480B57552575E83F2F9387B887_224692724 = (removed != null && sipTransaction.testAndSetTransactionTerminatedEvent());
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
                boolean varCEA0B8AAFFB6C70BF01D444180FAAB1F_725406154 = (stackLogger.isLoggingEnabled());
                {
                    stackLogger.logDebug("REMOVED client tx " + removed + " KEY = " + key);
                    {
                        SIPClientTransaction clientTx;
                        clientTx = (SIPClientTransaction)removed;
                        {
                            boolean varD1410CA2EC6660EFEAC1856DD8EB1E5A_1567914685 = (clientTx.getMethod().equals(Request.INVITE) && this.maxForkTime != 0);
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
                boolean var1213E4480B57552575E83F2F9387B887_535176790 = (removed != null && sipTransaction.testAndSetTransactionTerminatedEvent());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.494 -0400", hash_original_method = "114E6F44E2106B74A7437814EDE26008", hash_generated_method = "2AD84F0DA1738992483BB93F3980A77E")
    public void addTransaction(SIPServerTransaction serverTransaction) throws IOException {
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_110709490 = (stackLogger.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.508 -0400", hash_original_method = "A02B6100DC58EB921085C7ED44EE1D0C", hash_generated_method = "F3FCF58304C513E173D320E974EF254A")
    private void addTransactionHash(SIPTransaction sipTransaction) {
        SIPRequest sipRequest;
        sipRequest = sipTransaction.getOriginalRequest();
        {
            {
                {
                    boolean varD67D9F55A3909BC928BCBD79D887834D_1954559909 = (this.activeClientTransactionCount.get() > clientTransactionTableHiwaterMark);
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
                                boolean var337B2A9C9EA2BB40C001AEDF1FE004ED_1139701077 = (stackLogger.isLoggingEnabled());
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
                boolean varCEA0B8AAFFB6C70BF01D444180FAAB1F_1077898085 = (stackLogger.isLoggingEnabled());
                {
                    stackLogger.logDebug(" putTransactionHash : " + " key = " + key);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            String key;
            key = sipRequest.getTransactionId();
            {
                boolean varCEA0B8AAFFB6C70BF01D444180FAAB1F_979966427 = (stackLogger.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.509 -0400", hash_original_method = "380804F8BD40257E05E5F5A307273856", hash_generated_method = "C3B6607D3CE74D1F54868A5531E42786")
    protected void decrementActiveClientTransactionCount() {
        {
            boolean var47ED5E0FC43EE8302B13C023BBB66045_1254899588 = (this.activeClientTransactionCount.decrementAndGet() <= this.clientTransactionTableLowaterMark
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.516 -0400", hash_original_method = "BBF1530237A94448CCB60A02BEEFAB6C", hash_generated_method = "B85138F582A82B413A04254483B6AB72")
    protected void removeTransactionHash(SIPTransaction sipTransaction) {
        SIPRequest sipRequest;
        sipRequest = sipTransaction.getOriginalRequest();
        {
            String key;
            key = sipTransaction.getTransactionId();
            {
                boolean varCEA0B8AAFFB6C70BF01D444180FAAB1F_424989674 = (stackLogger.isLoggingEnabled());
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
                boolean varCEA0B8AAFFB6C70BF01D444180FAAB1F_262106912 = (stackLogger.isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.517 -0400", hash_original_method = "DE85950924139BCA289E1B65627F95C2", hash_generated_method = "9D99EA12A34F99CCAE2BBA3FEAE58635")
    public synchronized void transactionErrorEvent(SIPTransactionErrorEvent transactionErrorEvent) {
        SIPTransaction transaction;
        transaction = (SIPTransaction) transactionErrorEvent.getSource();
        {
            boolean varEB5679C18C9B12FA2BAE5A757A24F70B_2126844395 = (transactionErrorEvent.getErrorID() == SIPTransactionErrorEvent.TRANSPORT_ERROR);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.517 -0400", hash_original_method = "2DBBC23B1910A8BC0C385035C3D36387", hash_generated_method = "10685477707F526F81225135A46D131F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.518 -0400", hash_original_method = "EC17AB4FB84DCA37B1579E7D41B287E3", hash_generated_method = "9CC20F4C67CFE462583CF06525632DFA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.519 -0400", hash_original_method = "CEE88C8969112A140A79BE7502F1A5FB", hash_generated_method = "2599F20867168309AC781678E2AFBDA8")
    public void putPendingTransaction(SIPServerTransaction tr) {
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_524736191 = (stackLogger.isLoggingEnabled());
            stackLogger.logDebug("putPendingTransaction: " + tr);
        } //End collapsed parenthetic
        this.pendingTransactions.put(tr.getTransactionId(), tr);
        addTaint(tr.getTaint());
        // ---------- Original Method ----------
        //if (stackLogger.isLoggingEnabled())
            //stackLogger.logDebug("putPendingTransaction: " + tr);
        //this.pendingTransactions.put(tr.getTransactionId(), tr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.519 -0400", hash_original_method = "A3344B5915DA0C5B05591E12A62D4610", hash_generated_method = "DC72F1DE35BB184BD7D05222ACEE0A9F")
    public NetworkLayer getNetworkLayer() {
        NetworkLayer varB4EAC82CA7396A68D541C85D26508E83_795245079 = null; //Variable for return #1
        NetworkLayer varB4EAC82CA7396A68D541C85D26508E83_216786792 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_795245079 = DefaultNetworkLayer.SINGLETON;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_216786792 = networkLayer;
        } //End block
        NetworkLayer varA7E53CE21691AB073D9660D615818899_870083721; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_870083721 = varB4EAC82CA7396A68D541C85D26508E83_795245079;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_870083721 = varB4EAC82CA7396A68D541C85D26508E83_216786792;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_870083721.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_870083721;
        // ---------- Original Method ----------
        //if (networkLayer == null) {
            //return DefaultNetworkLayer.SINGLETON;
        //} else {
            //return networkLayer;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.519 -0400", hash_original_method = "47BDB9F0F1E73BBB0BEBE9D5C68FE123", hash_generated_method = "505FE6440D3D858325DC9E346A8E38B4")
    public boolean isLoggingEnabled() {
        {
            Object var11C62F83477FD0505FB5BB12080FBCDA_1378725577 = (this.stackLogger.isLoggingEnabled());
        } //End flattened ternary
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2052197829 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2052197829;
        // ---------- Original Method ----------
        //return this.stackLogger == null ? false : this.stackLogger.isLoggingEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.521 -0400", hash_original_method = "ACBC713DDCF210EE591047F9A9A515DC", hash_generated_method = "CA261A3C809CB777BDED2FDE10C8D2FC")
    public StackLogger getStackLogger() {
        StackLogger varB4EAC82CA7396A68D541C85D26508E83_1996383818 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1996383818 = this.stackLogger;
        varB4EAC82CA7396A68D541C85D26508E83_1996383818.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1996383818;
        // ---------- Original Method ----------
        //return this.stackLogger;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.522 -0400", hash_original_method = "01705032DE3FE074C7E055A3A8A4FEE3", hash_generated_method = "D5B89C6EEB6670A8F7A14F76A5BF6595")
    public ServerLogger getServerLogger() {
        ServerLogger varB4EAC82CA7396A68D541C85D26508E83_597974717 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_597974717 = this.serverLogger;
        varB4EAC82CA7396A68D541C85D26508E83_597974717.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_597974717;
        // ---------- Original Method ----------
        //return this.serverLogger;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.522 -0400", hash_original_method = "9DA0FD5646924F30F0B4568C00D20E6E", hash_generated_method = "4A4DB19FAB7576A09E902D69147943E5")
    public int getMaxMessageSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_586727992 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_586727992;
        // ---------- Original Method ----------
        //return this.maxMessageSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.522 -0400", hash_original_method = "F7820D79676ABCB839F961B1893B47B1", hash_generated_method = "EA170E890B9C35B538B5CB86A786F5AF")
    public void setSingleThreaded() {
        this.threadPoolSize = 1;
        // ---------- Original Method ----------
        //this.threadPoolSize = 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.523 -0400", hash_original_method = "E9690233252AAFA4C640E8F4D35D05EB", hash_generated_method = "65BB9FFF7A846847510EF99A4FA089FF")
    public void setThreadPoolSize(int size) {
        this.threadPoolSize = size;
        // ---------- Original Method ----------
        //this.threadPoolSize = size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.523 -0400", hash_original_method = "71AE725926CCD09A123AE8B2DA17A3F2", hash_generated_method = "BDCFBBD8A7091C0AC8289D984C7F139F")
    public void setMaxConnections(int nconnections) {
        this.maxConnections = nconnections;
        // ---------- Original Method ----------
        //this.maxConnections = nconnections;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.525 -0400", hash_original_method = "48A74B192606F2E929FFF01B3041CF91", hash_generated_method = "608F0635F113F80059B7E26F8D4C58E2")
    public Hop getNextHop(SIPRequest sipRequest) throws SipException {
        Hop varB4EAC82CA7396A68D541C85D26508E83_110916628 = null; //Variable for return #1
        Hop varB4EAC82CA7396A68D541C85D26508E83_1908361563 = null; //Variable for return #2
        Hop varB4EAC82CA7396A68D541C85D26508E83_516683825 = null; //Variable for return #3
        Hop varB4EAC82CA7396A68D541C85D26508E83_16394203 = null; //Variable for return #4
        Hop varB4EAC82CA7396A68D541C85D26508E83_951612059 = null; //Variable for return #5
        {
            varB4EAC82CA7396A68D541C85D26508E83_110916628 = router.getNextHop(sipRequest);
            varB4EAC82CA7396A68D541C85D26508E83_1908361563 = null;
        } //End block
        {
            {
                boolean varCB9DA79D6FC6DC73F34AC1A9AEB77BE2_1141080139 = (sipRequest.getRequestURI().isSipURI() || sipRequest.getRouteHeaders() != null);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_516683825 = defaultRouter.getNextHop(sipRequest);
                } //End block
                {
                    varB4EAC82CA7396A68D541C85D26508E83_16394203 = router.getNextHop(sipRequest);
                } //End block
                varB4EAC82CA7396A68D541C85D26508E83_951612059 = null;
            } //End collapsed parenthetic
        } //End block
        addTaint(sipRequest.getTaint());
        Hop varA7E53CE21691AB073D9660D615818899_755047168; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_755047168 = varB4EAC82CA7396A68D541C85D26508E83_110916628;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_755047168 = varB4EAC82CA7396A68D541C85D26508E83_1908361563;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_755047168 = varB4EAC82CA7396A68D541C85D26508E83_516683825;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_755047168 = varB4EAC82CA7396A68D541C85D26508E83_16394203;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_755047168 = varB4EAC82CA7396A68D541C85D26508E83_951612059;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_755047168.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_755047168;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.538 -0400", hash_original_method = "F49E7F0B68A71227FAAC90E58DC1BBF8", hash_generated_method = "0DCFD4017235BFA0DF5839F534EAAED3")
    public void setStackName(String stackName) {
        this.stackName = stackName;
        // ---------- Original Method ----------
        //this.stackName = stackName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.546 -0400", hash_original_method = "A8237A45131D19EE871BFED3E7A5AA19", hash_generated_method = "049F2198F1372D9401B89B9BB7674CC8")
    protected void setHostAddress(String stackAddress) throws UnknownHostException {
        {
            boolean var88033752B93C1832F0A794C7B736EEF6_414170037 = (stackAddress.indexOf(':') != stackAddress.lastIndexOf(':')
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.546 -0400", hash_original_method = "54480DAD55477A9080CEE058FAAB32DE", hash_generated_method = "CE44E584ACB6BB101864E0ADCAD0C868")
    public String getHostAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_732545308 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_732545308 = this.stackAddress;
        varB4EAC82CA7396A68D541C85D26508E83_732545308.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_732545308;
        // ---------- Original Method ----------
        //return this.stackAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.547 -0400", hash_original_method = "76950F41C787A5DB271675B8BBBB662A", hash_generated_method = "1E92BF9F05330CC7F9733D97887E55BC")
    protected void setRouter(Router router) {
        this.router = router;
        // ---------- Original Method ----------
        //this.router = router;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.547 -0400", hash_original_method = "AF384EADB40CF611F4292AFC400A4743", hash_generated_method = "63F981CDD2F4CCA6B007090372FB4838")
    public Router getRouter(SIPRequest request) {
        Router varB4EAC82CA7396A68D541C85D26508E83_2102806809 = null; //Variable for return #1
        Router varB4EAC82CA7396A68D541C85D26508E83_587743148 = null; //Variable for return #2
        Router varB4EAC82CA7396A68D541C85D26508E83_1984172295 = null; //Variable for return #3
        Router varB4EAC82CA7396A68D541C85D26508E83_827064743 = null; //Variable for return #4
        Router varB4EAC82CA7396A68D541C85D26508E83_885816777 = null; //Variable for return #5
        {
            boolean varF76E09608A8C57E8EC47B53AB21A7904_1966946580 = (request.getRequestLine() == null);
            {
                varB4EAC82CA7396A68D541C85D26508E83_2102806809 = this.defaultRouter;
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_587743148 = this.router;
            } //End block
            {
                {
                    boolean varA3564E0CF4A90785E724764B33E54BE1_1441652306 = (request.getRequestURI().getScheme().equals("sip")
                    || request.getRequestURI().getScheme().equals("sips"));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1984172295 = this.defaultRouter;
                    } //End block
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_827064743 = this.router;
                        varB4EAC82CA7396A68D541C85D26508E83_885816777 = defaultRouter;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(request.getTaint());
        Router varA7E53CE21691AB073D9660D615818899_2083156801; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2083156801 = varB4EAC82CA7396A68D541C85D26508E83_2102806809;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_2083156801 = varB4EAC82CA7396A68D541C85D26508E83_587743148;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_2083156801 = varB4EAC82CA7396A68D541C85D26508E83_1984172295;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_2083156801 = varB4EAC82CA7396A68D541C85D26508E83_827064743;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2083156801 = varB4EAC82CA7396A68D541C85D26508E83_885816777;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2083156801.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2083156801;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.548 -0400", hash_original_method = "A48D8CFCA0D4EF991F0CE4AA0090BC89", hash_generated_method = "F2FA69A9E58E632482629E8946C4CDF5")
    public Router getRouter() {
        Router varB4EAC82CA7396A68D541C85D26508E83_1512928940 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1512928940 = this.router;
        varB4EAC82CA7396A68D541C85D26508E83_1512928940.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1512928940;
        // ---------- Original Method ----------
        //return this.router;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.548 -0400", hash_original_method = "DA20B42A9F145510C718334C692F5A76", hash_generated_method = "898892045753850237C1A6D5079E282A")
    public boolean isAlive() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1561796899 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1561796899;
        // ---------- Original Method ----------
        //return !toExit;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.548 -0400", hash_original_method = "A1F941D6CE0FD78BF39EC8F9AC314942", hash_generated_method = "1A188872F7F3E0C8A138BDBB92F32142")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.564 -0400", hash_original_method = "CFCCE7E1C39F0D41098F0FE9085A25D2", hash_generated_method = "D8877AC3B47D7F3B3BC062CD0922A131")
    protected void removeMessageProcessor(MessageProcessor oldMessageProcessor) {
        {
            {
                boolean var7FEC726C44313EDFE272C9262D35B632_1154954853 = (messageProcessors.remove(oldMessageProcessor));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.565 -0400", hash_original_method = "B73144BB70E5C3E03C6EB8CA5C201D44", hash_generated_method = "B6C692D4EE9627C90A93ED94BF2FFD9F")
    protected MessageProcessor[] getMessageProcessors() {
        MessageProcessor[] varB4EAC82CA7396A68D541C85D26508E83_1078137874 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_1078137874 = (MessageProcessor[]) messageProcessors.toArray(new MessageProcessor[0]);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1078137874.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1078137874;
        // ---------- Original Method ----------
        //synchronized (messageProcessors) {
            //return (MessageProcessor[]) messageProcessors.toArray(new MessageProcessor[0]);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.569 -0400", hash_original_method = "923CC6809D53E2778E41D61552555A7F", hash_generated_method = "EA197D43BBBBE66605A269BA656CA1D0")
    protected MessageProcessor createMessageProcessor(InetAddress ipAddress, int port,
            String transport) throws java.io.IOException {
        MessageProcessor varB4EAC82CA7396A68D541C85D26508E83_1917831200 = null; //Variable for return #1
        MessageProcessor varB4EAC82CA7396A68D541C85D26508E83_1047165334 = null; //Variable for return #2
        MessageProcessor varB4EAC82CA7396A68D541C85D26508E83_43538822 = null; //Variable for return #3
        MessageProcessor varB4EAC82CA7396A68D541C85D26508E83_32110928 = null; //Variable for return #4
        {
            boolean var7095C4F355EEA549877FC43E480D2092_1081923121 = (transport.equalsIgnoreCase("udp"));
            {
                UDPMessageProcessor udpMessageProcessor;
                udpMessageProcessor = new UDPMessageProcessor(ipAddress, this,
                    port);
                this.addMessageProcessor(udpMessageProcessor);
                this.udpFlag = true;
                varB4EAC82CA7396A68D541C85D26508E83_1917831200 = udpMessageProcessor;
            } //End block
            {
                boolean var7E17D01330C6FB4587DD37D1ACF5F9C6_1784228124 = (transport.equalsIgnoreCase("tcp"));
                {
                    TCPMessageProcessor tcpMessageProcessor;
                    tcpMessageProcessor = new TCPMessageProcessor(ipAddress, this,
                    port);
                    this.addMessageProcessor(tcpMessageProcessor);
                    varB4EAC82CA7396A68D541C85D26508E83_1047165334 = tcpMessageProcessor;
                } //End block
                {
                    boolean var5E363589F0885716BB91FFB4505BC89B_1365825454 = (transport.equalsIgnoreCase("tls"));
                    {
                        TLSMessageProcessor tlsMessageProcessor;
                        tlsMessageProcessor = new TLSMessageProcessor(ipAddress, this,
                    port);
                        this.addMessageProcessor(tlsMessageProcessor);
                        varB4EAC82CA7396A68D541C85D26508E83_43538822 = tlsMessageProcessor;
                    } //End block
                    {
                        boolean var11BAA59DFE2974D4AFA5B4D4F65EA219_2129456285 = (transport.equalsIgnoreCase("sctp"));
                        {
                            try 
                            {
                                Class<?> mpc;
                                mpc = ClassLoader.getSystemClassLoader().loadClass( "gov.nist.javax.sip.stack.sctp.SCTPMessageProcessor" );
                                MessageProcessor mp;
                                mp = (MessageProcessor) mpc.newInstance();
                                mp.initialize( ipAddress, port, this );
                                this.addMessageProcessor(mp);
                                varB4EAC82CA7396A68D541C85D26508E83_32110928 = mp;
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
        MessageProcessor varA7E53CE21691AB073D9660D615818899_118401954; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_118401954 = varB4EAC82CA7396A68D541C85D26508E83_1917831200;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_118401954 = varB4EAC82CA7396A68D541C85D26508E83_1047165334;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_118401954 = varB4EAC82CA7396A68D541C85D26508E83_43538822;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_118401954 = varB4EAC82CA7396A68D541C85D26508E83_32110928;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_118401954.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_118401954;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.569 -0400", hash_original_method = "B67F8BF0F619BF3DA8779F834D136A31", hash_generated_method = "A19418B518D97C741239C5FFDF8C7894")
    protected void setMessageFactory(StackMessageFactory messageFactory) {
        this.sipMessageFactory = messageFactory;
        // ---------- Original Method ----------
        //this.sipMessageFactory = messageFactory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.571 -0400", hash_original_method = "79BA5457C24B1F2BABB705E59D2E5DE3", hash_generated_method = "866BBEA214F4965B1D4D75332C5BB072")
    public MessageChannel createRawMessageChannel(String sourceIpAddress, int sourcePort,
            Hop nextHop) throws UnknownHostException {
        MessageChannel varB4EAC82CA7396A68D541C85D26508E83_1223007424 = null; //Variable for return #1
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
            boolean var8CF1BBEBBFCBF1DC7D2F0931268CDCC1_1014386494 = (processorIterator.hasNext() && newChannel == null);
            {
                nextProcessor = (MessageProcessor) processorIterator.next();
                {
                    boolean varD30EC259292DB7E4155DAE7A640C45BC_338343014 = (nextHop.getTransport().equalsIgnoreCase(nextProcessor.getTransport())
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
                                boolean var337B2A9C9EA2BB40C001AEDF1FE004ED_1020436537 = (stackLogger.isLoggingEnabled());
                                stackLogger.logException(ex);
                            } //End collapsed parenthetic
                            if (DroidSafeAndroidRuntime.control) throw ex;
                        } //End block
                        catch (IOException e)
                        {
                            {
                                boolean var337B2A9C9EA2BB40C001AEDF1FE004ED_1290848090 = (stackLogger.isLoggingEnabled());
                                stackLogger.logException(e);
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1223007424 = newChannel;
        addTaint(sourceIpAddress.getTaint());
        addTaint(sourcePort);
        addTaint(nextHop.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1223007424.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1223007424;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.571 -0400", hash_original_method = "35D04CBE96754834C212489B2C606D95", hash_generated_method = "9D62D0CEAE907E409BD3CCDEC64AB301")
    public boolean isEventForked(String ename) {
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_793148625 = (stackLogger.isLoggingEnabled());
            {
                stackLogger.logDebug("isEventForked: " + ename + " returning "
                    + this.forkedEvents.contains(ename));
            } //End block
        } //End collapsed parenthetic
        boolean var0487541C1220D18499AD3CEC1C1D9EAD_1419714462 = (this.forkedEvents.contains(ename));
        addTaint(ename.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_442476614 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_442476614;
        // ---------- Original Method ----------
        //if (stackLogger.isLoggingEnabled()) {
            //stackLogger.logDebug("isEventForked: " + ename + " returning "
                    //+ this.forkedEvents.contains(ename));
        //}
        //return this.forkedEvents.contains(ename);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.571 -0400", hash_original_method = "8980F34FD4722FAAB08CBB90B3E36CA2", hash_generated_method = "9D2D97D2AE00B0F9EEC112F6AFCD63FC")
    public AddressResolver getAddressResolver() {
        AddressResolver varB4EAC82CA7396A68D541C85D26508E83_492209135 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_492209135 = this.addressResolver;
        varB4EAC82CA7396A68D541C85D26508E83_492209135.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_492209135;
        // ---------- Original Method ----------
        //return this.addressResolver;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.578 -0400", hash_original_method = "3C1DAA52D018FB69E50FF9E6B399590F", hash_generated_method = "AB8878E125C4CAD1D1B4691B2D6499BB")
    public void setAddressResolver(AddressResolver addressResolver) {
        this.addressResolver = addressResolver;
        // ---------- Original Method ----------
        //this.addressResolver = addressResolver;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.578 -0400", hash_original_method = "906B74670BE04C4A719BBC503CD663E5", hash_generated_method = "1BD4BE3CB90C933E977E9F9E4FB6AE5F")
    public void setLogRecordFactory(LogRecordFactory logRecordFactory) {
        this.logRecordFactory = logRecordFactory;
        // ---------- Original Method ----------
        //this.logRecordFactory = logRecordFactory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.579 -0400", hash_original_method = "2953BF87EC3C3B721F79C36C05ACD684", hash_generated_method = "7E6F281926C7FE52AF19BFEF6721802F")
    public ThreadAuditor getThreadAuditor() {
        ThreadAuditor varB4EAC82CA7396A68D541C85D26508E83_1335855747 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1335855747 = this.threadAuditor;
        varB4EAC82CA7396A68D541C85D26508E83_1335855747.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1335855747;
        // ---------- Original Method ----------
        //return this.threadAuditor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.580 -0400", hash_original_method = "DA93EFB6297A5552E15BC0248101E996", hash_generated_method = "1ADCD4949F1F6BEB94370296EACE22B4")
    public String auditStack(Set activeCallIDs, long leakedDialogTimer,
            long leakedTransactionTimer) {
        String varB4EAC82CA7396A68D541C85D26508E83_304506020 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_304506020 = auditReport;
        addTaint(activeCallIDs.getTaint());
        addTaint(leakedDialogTimer);
        addTaint(leakedTransactionTimer);
        varB4EAC82CA7396A68D541C85D26508E83_304506020.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_304506020;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.581 -0400", hash_original_method = "5A76CC0B1A3067E5B9DACF3EB61E431C", hash_generated_method = "39D7910564F08396E7E08A492FDF5FCD")
    private String auditDialogs(Set activeCallIDs, long leakedDialogTimer) {
        String varB4EAC82CA7396A68D541C85D26508E83_477051740 = null; //Variable for return #1
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
            boolean var03729FD53960D8DCA3A41A13A0229637_710960922 = (it.hasNext());
            {
                SIPDialog itDialog;
                itDialog = (SIPDialog) it.next();
                CallIdHeader callIdHeader;
                callIdHeader = (itDialog != null ? itDialog.getCallId() : null);//DSFIXME:  CODE0008: Nested ternary operator in expression
                String callID;
                callID = (callIdHeader != null ? callIdHeader.getCallId() : null);//DSFIXME:  CODE0008: Nested ternary operator in expression
                {
                    boolean varAD81098F41E3735D1602CF3776CF101D_1510194900 = (itDialog != null && callID != null && !activeCallIDs.contains(callID));
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
                                    boolean var85803934B5461ABB2B9ECDE07C3FFDB4_522090274 = (stackLogger.isLoggingEnabled());
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
        varB4EAC82CA7396A68D541C85D26508E83_477051740 = auditReport;
        addTaint(activeCallIDs.getTaint());
        addTaint(leakedDialogTimer);
        varB4EAC82CA7396A68D541C85D26508E83_477051740.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_477051740;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.582 -0400", hash_original_method = "B29AC2188DE994EDE68B3EFDD85B41F1", hash_generated_method = "E3AAE1659FC4BE16B36F17E95006C773")
    private String auditTransactions(ConcurrentHashMap transactionsMap,
            long a_nLeakedTransactionTimer) {
        String varB4EAC82CA7396A68D541C85D26508E83_1881970098 = null; //Variable for return #1
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
            boolean var03729FD53960D8DCA3A41A13A0229637_697189593 = (it.hasNext());
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
                                boolean varECF2FCB00A6D02E8BADBC36FDF09B326_524711981 = (isLoggingEnabled());
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
        varB4EAC82CA7396A68D541C85D26508E83_1881970098 = auditReport;
        addTaint(transactionsMap.getTaint());
        addTaint(a_nLeakedTransactionTimer);
        varB4EAC82CA7396A68D541C85D26508E83_1881970098.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1881970098;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.583 -0400", hash_original_method = "216776ED7A95FC4D69FC6626B7475336", hash_generated_method = "E8608B8CC182F06B0236B85EC551D976")
    public void setNon2XXAckPassedToListener(boolean passToListener) {
        this.non2XXAckPassedToListener = passToListener;
        // ---------- Original Method ----------
        //this.non2XXAckPassedToListener = passToListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.596 -0400", hash_original_method = "6286CBBFF5CE6322EC732C5543B43EDA", hash_generated_method = "B192CC7C6EE7CF8B3B11F67AA91CA13A")
    public boolean isNon2XXAckPassedToListener() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1443139632 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1443139632;
        // ---------- Original Method ----------
        //return non2XXAckPassedToListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.596 -0400", hash_original_method = "39908A44D12AF4672A8DE059DC86C6F0", hash_generated_method = "587DB8A6AE7D5AD8696BBAE89B36C224")
    public int getActiveClientTransactionCount() {
        int varF8FC6F0F03532C67FC8EC013C57CAF05_2062291897 = (activeClientTransactionCount.get());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1828956675 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1828956675;
        // ---------- Original Method ----------
        //return activeClientTransactionCount.get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.598 -0400", hash_original_method = "2D01936677D6715578D012ACFAF4D8A9", hash_generated_method = "183F4D79FAC31EF47C89947777D1098D")
    public boolean isRfc2543Supported() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1229355873 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1229355873;
        // ---------- Original Method ----------
        //return this.rfc2543Supported;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.598 -0400", hash_original_method = "71493EE5805AD2AB9A60D51292B7773D", hash_generated_method = "C9C43944CB43A88157EDE349F16555E9")
    public boolean isCancelClientTransactionChecked() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1377341646 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1377341646;
        // ---------- Original Method ----------
        //return this.cancelClientTransactionChecked;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.600 -0400", hash_original_method = "45004C11584D234E2C0351030C5C7691", hash_generated_method = "23F7B241EA7EFAFBEB074A688BB29DC0")
    public boolean isRemoteTagReassignmentAllowed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1374434656 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1374434656;
        // ---------- Original Method ----------
        //return this.remoteTagReassignmentAllowed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.600 -0400", hash_original_method = "20ADA27D372C754940A803F19F3E7AD9", hash_generated_method = "0A4F0CC20AF8A43CCFE7DCD9C21E5382")
    public Collection<Dialog> getDialogs() {
        Collection<Dialog> varB4EAC82CA7396A68D541C85D26508E83_1969534323 = null; //Variable for return #1
        HashSet<Dialog> dialogs;
        dialogs = new HashSet<Dialog>();
        dialogs.addAll(this.dialogTable.values());
        dialogs.addAll(this.earlyDialogTable.values());
        varB4EAC82CA7396A68D541C85D26508E83_1969534323 = dialogs;
        varB4EAC82CA7396A68D541C85D26508E83_1969534323.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1969534323;
        // ---------- Original Method ----------
        //HashSet<Dialog> dialogs = new HashSet<Dialog>();
        //dialogs.addAll(this.dialogTable.values());
        //dialogs.addAll(this.earlyDialogTable.values());
        //return dialogs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.633 -0400", hash_original_method = "9851D171868856682CD66D2C2C77C100", hash_generated_method = "6DFA1449C9A9649BD20B725C3226D4D1")
    public Collection<Dialog> getDialogs(DialogState state) {
        Collection<Dialog> varB4EAC82CA7396A68D541C85D26508E83_1701536705 = null; //Variable for return #1
        HashSet<Dialog> matchingDialogs;
        matchingDialogs = new HashSet<Dialog>();
        {
            boolean var4484BD33CD3D459F91886F147843B739_2100263114 = (DialogState.EARLY.equals(state));
            {
                matchingDialogs.addAll(this.earlyDialogTable.values());
            } //End block
            {
                Collection<SIPDialog> dialogs;
                dialogs = dialogTable.values();
                {
                    Iterator<SIPDialog> varAF4A62B1E6DB1A3E833F63312F30D56D_1877659827 = (dialogs).iterator();
                    varAF4A62B1E6DB1A3E833F63312F30D56D_1877659827.hasNext();
                    SIPDialog dialog = varAF4A62B1E6DB1A3E833F63312F30D56D_1877659827.next();
                    {
                        {
                            boolean var2BB6D00E61F702FAA6D913BC8638615E_2084496811 = (dialog.getState() != null && dialog.getState().equals(state));
                            {
                                matchingDialogs.add(dialog);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1701536705 = matchingDialogs;
        addTaint(state.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1701536705.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1701536705;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.687 -0400", hash_original_method = "B020A334EC30ACCE61108F29E8239DE0", hash_generated_method = "4FB8E26C19E3715E0B14102BD73918BB")
    public Dialog getReplacesDialog(ReplacesHeader replacesHeader) {
        Dialog varB4EAC82CA7396A68D541C85D26508E83_1097744901 = null; //Variable for return #1
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
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_735501225 = (stackLogger.isLoggingEnabled());
            stackLogger.logDebug("Looking for dialog " + did);
        } //End collapsed parenthetic
        Dialog replacesDialog;
        replacesDialog = this.dialogTable.get(did);
        {
            {
                Iterator<SIPClientTransaction> varEDF5DFD05164E4355382132B99DA269C_2007061546 = (this.clientTransactionTable.values()).iterator();
                varEDF5DFD05164E4355382132B99DA269C_2007061546.hasNext();
                SIPClientTransaction ctx = varEDF5DFD05164E4355382132B99DA269C_2007061546.next();
                {
                    {
                        boolean varD9E48DC518AA5535EEDEFAF93267A4EE_142034516 = (ctx.getDialog(did) != null);
                        {
                            replacesDialog = ctx.getDialog(did);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1097744901 = replacesDialog;
        addTaint(replacesHeader.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1097744901.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1097744901;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.694 -0400", hash_original_method = "01BB795BEB07C4ED2A3CDD99078DB107", hash_generated_method = "BBC2C0D7DD0C4245F08992DFD3C9C545")
    public Dialog getJoinDialog(JoinHeader joinHeader) {
        Dialog varB4EAC82CA7396A68D541C85D26508E83_126528120 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_126528120 = this.dialogTable.get(retval.toString().toLowerCase());
        addTaint(joinHeader.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_126528120.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_126528120;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.694 -0400", hash_original_method = "69B105104758CF3A0416D8C1D4F4DE0D", hash_generated_method = "7B24205D066AECCFC783C5A7FE5B727D")
    public void setTimer(Timer timer) {
        this.timer = timer;
        // ---------- Original Method ----------
        //this.timer = timer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.695 -0400", hash_original_method = "8E3D165A90C48C9C43C8115575D5D434", hash_generated_method = "F752D1D0923C16D47B7D987454D5BE19")
    public Timer getTimer() {
        Timer varB4EAC82CA7396A68D541C85D26508E83_131752407 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_131752407 = timer;
        varB4EAC82CA7396A68D541C85D26508E83_131752407.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_131752407;
        // ---------- Original Method ----------
        //return timer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.696 -0400", hash_original_method = "535D845393F6631B713A5EAFAC15730B", hash_generated_method = "3BEE4078529A3AEA9B5699ECA393CE1F")
    public int getReceiveUdpBufferSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_166549240 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_166549240;
        // ---------- Original Method ----------
        //return receiveUdpBufferSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.697 -0400", hash_original_method = "AD9781079D581597B87998F87481A2EF", hash_generated_method = "3CB289800444473A5EA7A106AC8D0F2E")
    public void setReceiveUdpBufferSize(int receiveUdpBufferSize) {
        this.receiveUdpBufferSize = receiveUdpBufferSize;
        // ---------- Original Method ----------
        //this.receiveUdpBufferSize = receiveUdpBufferSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.697 -0400", hash_original_method = "7F1E49D75F179129A028D4152C30D3F6", hash_generated_method = "CAE4A379870286AB4D9EFAAD333D5290")
    public int getSendUdpBufferSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_555525403 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_555525403;
        // ---------- Original Method ----------
        //return sendUdpBufferSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.698 -0400", hash_original_method = "085E2E0AF6AC7C34DFF993E649718D81", hash_generated_method = "5FF890F4499E7F2DC05E16AEF2E489BA")
    public void setSendUdpBufferSize(int sendUdpBufferSize) {
        this.sendUdpBufferSize = sendUdpBufferSize;
        // ---------- Original Method ----------
        //this.sendUdpBufferSize = sendUdpBufferSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.698 -0400", hash_original_method = "3649FCA00F1F012AB31400D887FE5668", hash_generated_method = "25F9CE48BE3D8A2B81401FE81559ECB5")
    public void setStackLogger(StackLogger stackLogger) {
        this.stackLogger = stackLogger;
        // ---------- Original Method ----------
        //this.stackLogger = stackLogger;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.699 -0400", hash_original_method = "3A00FD245E091565EAC4D2A0BF135C63", hash_generated_method = "8A89CF871C9822FB3C97ABB3C83C4BF7")
    public boolean checkBranchId() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_940040305 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_940040305;
        // ---------- Original Method ----------
        //return this.checkBranchId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.699 -0400", hash_original_method = "4B576FDEB92FCE56B4004D51F27F133D", hash_generated_method = "9045EE09E5612A4BCB84191DDFF57B6F")
    public void setLogStackTraceOnMessageSend(boolean logStackTraceOnMessageSend) {
        this.logStackTraceOnMessageSend = logStackTraceOnMessageSend;
        // ---------- Original Method ----------
        //this.logStackTraceOnMessageSend = logStackTraceOnMessageSend;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.715 -0400", hash_original_method = "6EA33CFFB30E0EA85B4B3B5316E0B073", hash_generated_method = "F2DE6D047B1D076E5EA5B2803DD263AB")
    public boolean isLogStackTraceOnMessageSend() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1201689420 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1201689420;
        // ---------- Original Method ----------
        //return logStackTraceOnMessageSend;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.715 -0400", hash_original_method = "BBC3144A1CF9CB1C9F37A775F293720F", hash_generated_method = "1AB264FBAA3C1AD042F7B5A0A41EB0AF")
    public void setDeliverDialogTerminatedEventForNullDialog() {
        this.isDialogTerminatedEventDeliveredForNullDialog = true;
        // ---------- Original Method ----------
        //this.isDialogTerminatedEventDeliveredForNullDialog = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.715 -0400", hash_original_method = "C791CC7BC6998146618C651EB49E3406", hash_generated_method = "08B4782FC6CB7D80BC5F7D8BB33D2C9C")
    public void addForkedClientTransaction(SIPClientTransaction clientTransaction) {
        this.forkedClientTransactionTable.put(clientTransaction.getTransactionId(), clientTransaction );
        addTaint(clientTransaction.getTaint());
        // ---------- Original Method ----------
        //this.forkedClientTransactionTable.put(clientTransaction.getTransactionId(), clientTransaction );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.716 -0400", hash_original_method = "A07C61DB9453AEA0A84C4416E8A5508E", hash_generated_method = "91EC983B3EB6669B9EE8AD8835930E04")
    public SIPClientTransaction getForkedTransaction(String transactionId) {
        SIPClientTransaction varB4EAC82CA7396A68D541C85D26508E83_1470236809 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1470236809 = this.forkedClientTransactionTable.get(transactionId);
        addTaint(transactionId.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1470236809.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1470236809;
        // ---------- Original Method ----------
        //return this.forkedClientTransactionTable.get(transactionId);
    }

    
    class PingTimer extends SIPStackTimerTask {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.716 -0400", hash_original_field = "BA4484AC61EF7F39E156EE38D51DF221", hash_generated_field = "3AE84B2399BFC1B1844D24A06D20C249")

        ThreadAuditor.ThreadHandle threadHandle;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.716 -0400", hash_original_method = "BD8473F7A826DDA501F390A58BAECB33", hash_generated_method = "AFD1D6DF671C7BCECC8041EEE49A6EBB")
        public  PingTimer(ThreadAuditor.ThreadHandle a_oThreadHandle) {
            threadHandle = a_oThreadHandle;
            // ---------- Original Method ----------
            //threadHandle = a_oThreadHandle;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.718 -0400", hash_original_method = "D20FBACDA77D9F2BECED97C9063F3E91", hash_generated_method = "6794D0D3D84FD48D7BAD5EC281629EE7")
        protected void runTask() {
            {
                boolean varC22F88379E8062191B8F0291837053FF_808791906 = (getTimer() != null);
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.718 -0400", hash_original_field = "7767C1945F1820BD26BE8F6047172E57", hash_generated_field = "346E85BD6DDF8042B729A2408B44CDD3")

        private SIPClientTransaction clientTransaction;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.719 -0400", hash_original_method = "D0A941D96C1666EFE3BE3721976F6AA6", hash_generated_method = "ABA505C7494D21E7D5CE259EA437DF15")
        public  RemoveForkedTransactionTimerTask(SIPClientTransaction sipClientTransaction ) {
            this.clientTransaction = sipClientTransaction;
            // ---------- Original Method ----------
            //this.clientTransaction = sipClientTransaction;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.719 -0400", hash_original_method = "0A8A5E2C1505E2C2E84219D84E5444CF", hash_generated_method = "74E9473D704F21F1BB34BAE5007DACEC")
        @Override
        protected void runTask() {
            forkedClientTransactionTable.remove(clientTransaction.getTransactionId());
            // ---------- Original Method ----------
            //forkedClientTransactionTable.remove(clientTransaction.getTransactionId());
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.719 -0400", hash_original_field = "1270E8F52DAEA78D6688D9140DFF4221", hash_generated_field = "840B97A8669F66449D46242BA5765A0F")

    public static final int BASE_TIMER_INTERVAL = 500;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.720 -0400", hash_original_field = "9848A0B88D1FABCA8FBA5AB7FD5622BD", hash_generated_field = "F814FEC2CA6FC54407356E1DCD115382")

    public static final int CONNECTION_LINGER_TIME = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.720 -0400", hash_original_field = "19274966A28B7A0696AC55588DA87355", hash_generated_field = "388A390124AA7825F100A1798379215A")

    protected static Set<String> dialogCreatingMethods = new HashSet<String>();
    static {
    	dialogCreatingMethods.add(Request.REFER);
        dialogCreatingMethods.add(Request.INVITE);
        dialogCreatingMethods.add(Request.SUBSCRIBE);
    }
    
}

