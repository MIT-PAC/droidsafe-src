package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.455 -0400", hash_original_field = "BB024B2AD3D00DEB98AA88DE95E2AC00", hash_generated_field = "4492ED7A506BF07B68742FB955C2E21E")

    protected ConcurrentHashMap<String, SIPServerTransaction> retransmissionAlertTransactions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.455 -0400", hash_original_field = "986AB2740C1F225B7EDFB5003F826DDF", hash_generated_field = "6B3C62483E89DF024C432E8562DE8605")

    protected ConcurrentHashMap<String, SIPDialog> earlyDialogTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.455 -0400", hash_original_field = "02ACB7AB69D88BAD640992A93D36CD3D", hash_generated_field = "612ED1FD1C10487B0104807B8A4F66C6")

    protected ConcurrentHashMap<String, SIPDialog> dialogTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.455 -0400", hash_original_field = "2C127BF32CCB4EDF2BF22FEA5A00E494", hash_generated_field = "02D2240A23798B540E9F3183DC11EA33")

    private Timer timer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.455 -0400", hash_original_field = "08EADE4A5AD4F48C9A3F1591D2EA1815", hash_generated_field = "32E72097D41FA2F9AA2F04A4F6D94614")

    private ConcurrentHashMap<String, SIPServerTransaction> pendingTransactions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.455 -0400", hash_original_field = "135A93B3EA7CAFC3F8629197D3B561E2", hash_generated_field = "1A605FBA2863EF25462941960BB549FD")

    private ConcurrentHashMap<String, SIPClientTransaction> clientTransactionTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.455 -0400", hash_original_field = "49B61D40D424177779367ABF96FA4884", hash_generated_field = "1F786F43A2E25D3141E2216B91F6EAFE")

    protected boolean unlimitedServerTransactionTableSize = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.456 -0400", hash_original_field = "1DF7958BDE28724C5596C6BFB0E1CCB0", hash_generated_field = "DD907A7A90AC49DD39A1CAABAC88BD51")

    protected boolean unlimitedClientTransactionTableSize = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.456 -0400", hash_original_field = "076578F2E484D4FEC2562AB10277F3D5", hash_generated_field = "F4F362BB5E335440B1EB8C2B8EEC1317")

    protected int serverTransactionTableHighwaterMark = 5000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.456 -0400", hash_original_field = "7B15FFD05552BF4F9F4CD19D72A0ECFD", hash_generated_field = "5C015B93DBBC4C9D6908F3FC81146158")

    protected int serverTransactionTableLowaterMark = 4000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.456 -0400", hash_original_field = "D3F7C88BB14A5ED2F6A20C6BEBEAFDF3", hash_generated_field = "E9B62880A44C081DDF0FEB2884673E38")

    protected int clientTransactionTableHiwaterMark = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.456 -0400", hash_original_field = "06EFD544FD136F3B0F129C5103D56B95", hash_generated_field = "5D70C98F837CF3F9C68DD58DFD91E463")

    protected int clientTransactionTableLowaterMark = 800;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.456 -0400", hash_original_field = "86AE3FC892B739DBA734E71838BA8EAB", hash_generated_field = "EF538D5EF9F88F93E351A9F5CBDE10BE")

    private AtomicInteger activeClientTransactionCount = new AtomicInteger(0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.456 -0400", hash_original_field = "9EA55D2B918C0F38F9A9DFBE46C9E48E", hash_generated_field = "17FBAB4D0971040901BD780F89591315")

    private ConcurrentHashMap<String, SIPServerTransaction> serverTransactionTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.456 -0400", hash_original_field = "EE1591222A018ABE5572A5C6C0A797E9", hash_generated_field = "F435FECE20B5CE387F33C17D84BA6487")

    private ConcurrentHashMap<String, SIPServerTransaction> mergeTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.456 -0400", hash_original_field = "C755FCEA66E8CB835ECA7BD27067C11E", hash_generated_field = "811B28F45DE9105A274B1DBADE0F6CC9")

    private ConcurrentHashMap<String,SIPServerTransaction> terminatedServerTransactionsPendingAck;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.456 -0400", hash_original_field = "517069402F23F2FF9ABD60CF4C61CBE6", hash_generated_field = "71F6115AE3CDEA5C8D231C9BD5ACFE37")

    private ConcurrentHashMap<String,SIPClientTransaction> forkedClientTransactionTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.456 -0400", hash_original_field = "E36C03BD76A3345DFD7C16B0A9186E53", hash_generated_field = "1D505020FB0AD1A554D62BDC6FA8297B")

    private StackLogger stackLogger;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.456 -0400", hash_original_field = "B90EC493A5834DC9E5B17148F47193CB", hash_generated_field = "5C234A980E10BCEA9B12BAB676094BC2")

    protected ServerLogger serverLogger;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.456 -0400", hash_original_field = "2B177EBBF6652A06414D14C8C50E3B12", hash_generated_field = "1E6D363EB172CF0996091AF3F1ED1415")

    boolean udpFlag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.456 -0400", hash_original_field = "BA389B46C420BB5A0FA673A143939AC1", hash_generated_field = "EF7A4245F4BE46C3FAE858ABF7DB8188")

    protected DefaultRouter defaultRouter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.456 -0400", hash_original_field = "D77703414D2B9CECCE906E75B64E89D7", hash_generated_field = "C4FB0B708AF2FF7CDFB610A006B5BB00")

    protected boolean needsLogging;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.456 -0400", hash_original_field = "D2577D0EF3B7CF3C35702AD5E888A547", hash_generated_field = "39AC5AA3A559BB385B76BB7FCEA06FC5")

    private boolean non2XXAckPassedToListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.456 -0400", hash_original_field = "672BD3EDBEBEC18E145C8AFB0B9BDF65", hash_generated_field = "33EBA2CEF834B663ED5264FE81682D84")

    protected IOHandler ioHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.457 -0400", hash_original_field = "CD991461F11FD761BF6EFA12FCC1C1C3", hash_generated_field = "F86372B43141F18E4A8130BDC70E29CE")

    protected boolean toExit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.457 -0400", hash_original_field = "EDEF96A12B8786AA598020FE493D9164", hash_generated_field = "D4D760F2DD059CF6C01F0C862657BA20")

    protected String stackName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.457 -0400", hash_original_field = "7226454496215DAA32BEDA538263F57C", hash_generated_field = "A47D9D5247AAB165B1980C5D8E37AD58")

    protected String stackAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.457 -0400", hash_original_field = "DF199E0AE132DFDCEDCCCEAA54175F9C", hash_generated_field = "413081F93DE42EB68D8F08C864982E20")

    protected InetAddress stackInetAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.457 -0400", hash_original_field = "D189B5282758DEAD6599821789339DB3", hash_generated_field = "272D1016DEB62E744C52940A3B0E5489")

    protected StackMessageFactory sipMessageFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.457 -0400", hash_original_field = "F3395CD54CF857DDF8F2056768FF49AE", hash_generated_field = "66410D3E71DA473D001977FF3AD7B23B")

    protected javax.sip.address.Router router;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.457 -0400", hash_original_field = "CDE1F9B6C35FC856E715F186A9E26998", hash_generated_field = "C7EB24484DBA63450BB85C2FA7FA489F")

    protected int threadPoolSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.457 -0400", hash_original_field = "1ACBA9188A93F77D3F78F321F92C1912", hash_generated_field = "F74AE6C7EF47828D3A211878D3F5E9F3")

    protected int maxConnections;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.457 -0400", hash_original_field = "340B2E73CA68D1340F1704849DB20F30", hash_generated_field = "3130D9CC177F737BBD6633DB37EE5BF1")

    protected boolean cacheServerConnections;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.457 -0400", hash_original_field = "75061F79A5A3418387A8EAF6F6FAC2F2", hash_generated_field = "768D8EDFC9A10AC079EBDEBB9B0BEA2F")

    protected boolean cacheClientConnections;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.457 -0400", hash_original_field = "7024729D82FD3921C13E8300B02C1CC8", hash_generated_field = "F13115153A6685630697524CF8732D13")

    protected boolean useRouterForAll;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.457 -0400", hash_original_field = "D54EA500688687E7A49846CC9E44F277", hash_generated_field = "DDA86EBC27B96B0FE9D286E6B5C99D02")

    protected int maxContentLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.457 -0400", hash_original_field = "BF1B271FFDC69F10249067CA74EC9584", hash_generated_field = "224FB7FE4F1198F8C1E840FE28932770")

    protected int maxMessageSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.457 -0400", hash_original_field = "074A77F279327ACEE64E9D4AEEC12D99", hash_generated_field = "185A572D15C5BAB5F976AA3554E06D13")

    private Collection<MessageProcessor> messageProcessors;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.457 -0400", hash_original_field = "8FC05721DCBB3B49F66A6D283A300B5B", hash_generated_field = "29792280DB9C85168DEBC57540E5C62A")

    protected int readTimeout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.457 -0400", hash_original_field = "24D13633EB52AF9F8D6DCB3C2ED2C648", hash_generated_field = "F280B3067DE1A528C7BB767557FE00A0")

    protected NetworkLayer networkLayer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.457 -0400", hash_original_field = "96F152D1B09078C3F6C4389AB2CD6114", hash_generated_field = "2DDBEDAE711DD575D314D6FB0824162C")

    protected String outboundProxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.458 -0400", hash_original_field = "9AEE50191BBED6B0890F8E94A389A3CE", hash_generated_field = "E23BB81A391AC77E4B947A6531D7CFF7")

    protected String routerPath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.458 -0400", hash_original_field = "408464B03DDE981FC6F053CF4CA21C22", hash_generated_field = "CBEE3D1CA29ED6AAA4A0BE3A2A3FF707")

    protected boolean isAutomaticDialogSupportEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.458 -0400", hash_original_field = "36969DE269F86EBA5C778849E2D77D36", hash_generated_field = "758951DC734FED546F5FA46D0CD9E244")

    protected HashSet<String> forkedEvents;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.458 -0400", hash_original_field = "30EE0A2AF6038C82623E548CD9ED9924", hash_generated_field = "E3C6781710F35866C48FB724B6E9B0A5")

    protected boolean generateTimeStampHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.458 -0400", hash_original_field = "20CC1F9AF77D0249618487065E0355D3", hash_generated_field = "921A218F1E68F36119322B4C0375D302")

    protected AddressResolver addressResolver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.458 -0400", hash_original_field = "9A4F347B2CDD7A88BC034DE7DE1C49B1", hash_generated_field = "7A3B05571C3C337451929576D2F6F7FC")

    protected int maxListenerResponseTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.458 -0400", hash_original_field = "8CF5659616CF24E603869D9967FC496D", hash_generated_field = "A8CD57032071313BD3D43EAEB0E5D46D")

    protected boolean rfc2543Supported = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.458 -0400", hash_original_field = "06FFC9DFE8BC8EFDE045BBFE8B51D74A", hash_generated_field = "DE990737863BADB7C6E95ED63CC9DC4C")

    protected ThreadAuditor threadAuditor = new ThreadAuditor();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.458 -0400", hash_original_field = "18CF450DF0054CF7D904E6AED9045E84", hash_generated_field = "F94964197FE0E44E12A6BA7E03E51754")

    protected LogRecordFactory logRecordFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.458 -0400", hash_original_field = "597E9AB37EABE3191749A9B8F3F983E9", hash_generated_field = "3713718BCCF6B9DFEBB0EE5CDD91B58B")

    protected boolean cancelClientTransactionChecked = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.458 -0400", hash_original_field = "212D53B82E21ED6882AABA1631FD2487", hash_generated_field = "BCB26F591F1846D975D03FEA861FFBFA")

    protected boolean remoteTagReassignmentAllowed = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.458 -0400", hash_original_field = "8A1ACCA44ACB9074E8500DD26D17C77F", hash_generated_field = "046122FB4660CF86569D7745FB6062FC")

    protected boolean logStackTraceOnMessageSend = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.458 -0400", hash_original_field = "F4917C86121EC97DE5D24BA1E8E3468F", hash_generated_field = "533CF057F33E79CEE3F6C6762D967990")

    protected int receiveUdpBufferSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.459 -0400", hash_original_field = "85144B78F884888A47BFB96276FBAB05", hash_generated_field = "9F0A96DC46E2BE3FA6703B7ECEFC7E7B")

    protected int sendUdpBufferSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.459 -0400", hash_original_field = "7A750FD6F18F1DDA4E38B3D4B5023EE1", hash_generated_field = "D2F44B156E2C7DA4668C7D5F665DAB5F")

    protected boolean stackDoesCongestionControl = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.459 -0400", hash_original_field = "FCC7FD133DB713B98A4D2C108DE01B90", hash_generated_field = "C468B3795A40E24BFA5E22186F8BD92C")

    protected boolean isBackToBackUserAgent = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.459 -0400", hash_original_field = "C6F8194A1D5AF33E9A729F0C8D674D41", hash_generated_field = "30B91514890DCCCE1053BFD830B93F8D")

    protected boolean checkBranchId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.459 -0400", hash_original_field = "DFB941AD6D02702CD41F36C2DCE642A9", hash_generated_field = "2CEA2AC21B7A7C73026A335F4F3A56EB")

    protected boolean isAutomaticDialogErrorHandlingEnabled = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.459 -0400", hash_original_field = "92DDCC06D1B886C4810373F4B5BD040A", hash_generated_field = "8D5939440DC97D0AD4D778E8F452B5A4")

    protected boolean isDialogTerminatedEventDeliveredForNullDialog = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.459 -0400", hash_original_field = "762E796CA8120FD35AC69FAC3C50EC48", hash_generated_field = "67828BA276FD46633F0EC0FF51519F0E")

    protected int maxForkTime = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.462 -0400", hash_original_method = "58A99E16B05D3536C850145BF176F1CB", hash_generated_method = "8C542C58F4311C4AB50C84C238C5AFA7")
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
        if(getThreadAuditor().isEnabled())        
        {
            timer.schedule(new PingTimer(null), 0);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.463 -0400", hash_original_method = "A949ED7F371D2CEC2724714D98F74A81", hash_generated_method = "766B055A4B71BEB66FBCFDFD4443B1FF")
    protected  SIPTransactionStack(StackMessageFactory messageFactory) {
        this();
        this.sipMessageFactory = messageFactory;
        // ---------- Original Method ----------
        //this.sipMessageFactory = messageFactory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.464 -0400", hash_original_method = "4C95AA981C09EEAD5B31E73DC1384B23", hash_generated_method = "0767634643CCD22D8A894FDAD0E54B40")
    protected void reInit() {
        if(stackLogger.isLoggingEnabled())        
        stackLogger.logDebug("Re-initializing !");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.464 -0400", hash_original_method = "5E8E9B567A338F9125BE752CD1B53E0E", hash_generated_method = "17732C57D3B02AEBBA0764C8BF7F980C")
    public SocketAddress obtainLocalAddress(InetAddress dst, int dstPort,
                    InetAddress localAddress, int localPort) throws IOException {
        addTaint(localPort);
        addTaint(localAddress.getTaint());
        addTaint(dstPort);
        addTaint(dst.getTaint());
SocketAddress varFFBEDFC6F5A683D71E2CD282FE3970C6_414600337 =         this.ioHandler.obtainLocalAddress(
                        dst, dstPort, localAddress, localPort);
        varFFBEDFC6F5A683D71E2CD282FE3970C6_414600337.addTaint(taint);
        return varFFBEDFC6F5A683D71E2CD282FE3970C6_414600337;
        // ---------- Original Method ----------
        //return this.ioHandler.obtainLocalAddress(
                        //dst, dstPort, localAddress, localPort);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.464 -0400", hash_original_method = "6F4F1101C93AB1BC6C07B08D53A20694", hash_generated_method = "5AECE98B1061B15974070DD2B205769A")
    public void disableLogging() {
        this.getStackLogger().disableLogging();
        // ---------- Original Method ----------
        //this.getStackLogger().disableLogging();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.464 -0400", hash_original_method = "28B9C3C3AF577CC75DD224D050447CF4", hash_generated_method = "DD4A6695D325CC79611C0DADF7845085")
    public void enableLogging() {
        this.getStackLogger().enableLogging();
        // ---------- Original Method ----------
        //this.getStackLogger().enableLogging();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.465 -0400", hash_original_method = "F0A4CF0EC627D6BB4B7444677CFA585E", hash_generated_method = "405C76E374ED936C5067EA7C0BE22F49")
    public void printDialogTable() {
        if(isLoggingEnabled())        
        {
            this.getStackLogger().logDebug("dialog table  = " + this.dialogTable);
            System.out.println("dialog table = " + this.dialogTable);
        } //End block
        // ---------- Original Method ----------
        //if (isLoggingEnabled()) {
            //this.getStackLogger().logDebug("dialog table  = " + this.dialogTable);
            //System.out.println("dialog table = " + this.dialogTable);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.465 -0400", hash_original_method = "A39FC22DA230CCE4243CA37C766915B4", hash_generated_method = "8D6DAC36A759FBD1CC2D4A4B391636B3")
    public SIPServerTransaction getRetransmissionAlertTransaction(String dialogId) {
        addTaint(dialogId.getTaint());
SIPServerTransaction var3BD8815AB752C4A453F65C3C708BDEA5_2070666965 =         (SIPServerTransaction) this.retransmissionAlertTransactions.get(dialogId);
        var3BD8815AB752C4A453F65C3C708BDEA5_2070666965.addTaint(taint);
        return var3BD8815AB752C4A453F65C3C708BDEA5_2070666965;
        // ---------- Original Method ----------
        //return (SIPServerTransaction) this.retransmissionAlertTransactions.get(dialogId);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isDialogCreated(String method) {
        return dialogCreatingMethods.contains(method);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.465 -0400", hash_original_method = "BEE1BC405D1C6F3176E5E5958D511DC6", hash_generated_method = "FEDE1A4355D17089863882F4FA8D8B20")
    public void addExtensionMethod(String extensionMethod) {
        addTaint(extensionMethod.getTaint());
        if(extensionMethod.equals(Request.NOTIFY))        
        {
            if(stackLogger.isLoggingEnabled())            
            stackLogger.logDebug("NOTIFY Supported Natively");
        } //End block
        else
        {
            dialogCreatingMethods.add(extensionMethod.trim().toUpperCase());
        } //End block
        // ---------- Original Method ----------
        //if (extensionMethod.equals(Request.NOTIFY)) {
            //if (stackLogger.isLoggingEnabled())
                //stackLogger.logDebug("NOTIFY Supported Natively");
        //} else {
            //dialogCreatingMethods.add(extensionMethod.trim().toUpperCase());
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.465 -0400", hash_original_method = "3AD47119D9E3B66FC61FF1D5407F3E89", hash_generated_method = "56B78EE3F849A4A99340DFACC6C96F36")
    public void putDialog(SIPDialog dialog) {
        addTaint(dialog.getTaint());
        String dialogId = dialog.getDialogId();
        if(dialogTable.containsKey(dialogId))        
        {
            if(stackLogger.isLoggingEnabled())            
            {
                stackLogger.logDebug("putDialog: dialog already exists" + dialogId + " in table = "
                        + dialogTable.get(dialogId));
            } //End block
            return;
        } //End block
        if(stackLogger.isLoggingEnabled())        
        {
            stackLogger.logDebug("putDialog dialogId=" + dialogId + " dialog = " + dialog);
        } //End block
        dialog.setStack(this);
        if(stackLogger.isLoggingEnabled())        
        stackLogger.logStackTrace();
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.466 -0400", hash_original_method = "E7A6CF8B50F165B49D6E8637D9CBF9BD", hash_generated_method = "8C3258F8CD6FBE7B6769BE2016DED963")
    public SIPDialog createDialog(SIPTransaction transaction) {
        addTaint(transaction.getTaint());
        SIPDialog retval = null;
        if(transaction instanceof SIPClientTransaction)        
        {
            String dialogId = ((SIPRequest) transaction.getRequest()).getDialogId(false);
            if(this.earlyDialogTable.get(dialogId) != null)            
            {
                SIPDialog dialog = this.earlyDialogTable.get(dialogId);
                if(dialog.getState() == null || dialog.getState() == DialogState.EARLY)                
                {
                    retval = dialog;
                } //End block
                else
                {
                    retval = new SIPDialog(transaction);
                    this.earlyDialogTable.put(dialogId, retval);
                } //End block
            } //End block
            else
            {
                retval = new SIPDialog(transaction);
                this.earlyDialogTable.put(dialogId, retval);
            } //End block
        } //End block
        else
        {
            retval = new SIPDialog(transaction);
        } //End block
SIPDialog varF9E19AD6135C970F387F77C6F3DE4477_1962945207 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1962945207.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1962945207;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.466 -0400", hash_original_method = "077BDE7287D2ACDD7F2A84D6156CB0F7", hash_generated_method = "8BE9DD2EF0B31F28AC9A297CC63861EE")
    public SIPDialog createDialog(SIPClientTransaction transaction, SIPResponse sipResponse) {
        addTaint(sipResponse.getTaint());
        addTaint(transaction.getTaint());
        String dialogId = ((SIPRequest) transaction.getRequest()).getDialogId(false);
        SIPDialog retval = null;
        if(this.earlyDialogTable.get(dialogId) != null)        
        {
            retval = this.earlyDialogTable.get(dialogId);
            if(sipResponse.isFinalResponse())            
            {
                this.earlyDialogTable.remove(dialogId);
            } //End block
        } //End block
        else
        {
            retval = new SIPDialog(transaction, sipResponse);
        } //End block
SIPDialog varF9E19AD6135C970F387F77C6F3DE4477_74413694 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_74413694.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_74413694;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.466 -0400", hash_original_method = "C8019EE35E2246E727D64B4FEC692BA7", hash_generated_method = "D099F5D6452FE55BC9E39EF8444E271D")
    public SIPDialog createDialog(SipProviderImpl sipProvider,
			SIPResponse sipResponse) {
        addTaint(sipResponse.getTaint());
        addTaint(sipProvider.getTaint());
SIPDialog var475990F105CC24753FBB4C7CCB8CA33B_1787398008 =         new SIPDialog(sipProvider, sipResponse);
        var475990F105CC24753FBB4C7CCB8CA33B_1787398008.addTaint(taint);
        return var475990F105CC24753FBB4C7CCB8CA33B_1787398008;
        // ---------- Original Method ----------
        //return new SIPDialog(sipProvider, sipResponse);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.467 -0400", hash_original_method = "C20BEEC896962D7D1856EB72C0C34791", hash_generated_method = "569684CCF2F0A429FE30F449C39FD980")
    public void removeDialog(SIPDialog dialog) {
        addTaint(dialog.getTaint());
        String id = dialog.getDialogId();
        String earlyId = dialog.getEarlyDialogId();
        if(earlyId != null)        
        {
            this.earlyDialogTable.remove(earlyId);
            this.dialogTable.remove(earlyId);
        } //End block
        if(id != null)        
        {
            Object old = this.dialogTable.get(id);
            if(old == dialog)            
            {
                this.dialogTable.remove(id);
            } //End block
            if(!dialog.testAndSetIsDialogTerminatedEventDelivered())            
            {
                DialogTerminatedEvent event = new DialogTerminatedEvent(dialog.getSipProvider(),
                        dialog);
                dialog.getSipProvider().handleEvent(event, null);
            } //End block
        } //End block
        else
        if(this.isDialogTerminatedEventDeliveredForNullDialog)        
        {
            if(!dialog.testAndSetIsDialogTerminatedEventDelivered())            
            {
                DialogTerminatedEvent event = new DialogTerminatedEvent(dialog.getSipProvider(),
                        dialog);
                dialog.getSipProvider().handleEvent(event, null);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.467 -0400", hash_original_method = "7CD5A4CB12647D3BBBFDC040A2B5E183", hash_generated_method = "818CAAC1095911293191BC1D8804E5DA")
    public SIPDialog getDialog(String dialogId) {
        addTaint(dialogId.getTaint());
        SIPDialog sipDialog = (SIPDialog) dialogTable.get(dialogId);
        if(stackLogger.isLoggingEnabled())        
        {
            stackLogger.logDebug("getDialog(" + dialogId + ") : returning " + sipDialog);
        } //End block
SIPDialog var5A082C2FDDCED8D139EC092CFC9DDE79_546946688 =         sipDialog;
        var5A082C2FDDCED8D139EC092CFC9DDE79_546946688.addTaint(taint);
        return var5A082C2FDDCED8D139EC092CFC9DDE79_546946688;
        // ---------- Original Method ----------
        //SIPDialog sipDialog = (SIPDialog) dialogTable.get(dialogId);
        //if (stackLogger.isLoggingEnabled()) {
            //stackLogger.logDebug("getDialog(" + dialogId + ") : returning " + sipDialog);
        //}
        //return sipDialog;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.467 -0400", hash_original_method = "B0D51307A4FC266FC1D02389AEE54D05", hash_generated_method = "F02F74A5F3F7D97B736DF3E28B329264")
    public void removeDialog(String dialogId) {
        addTaint(dialogId.getTaint());
        if(stackLogger.isLoggingEnabled())        
        {
            stackLogger.logWarning("Silently removing dialog from table");
        } //End block
        dialogTable.remove(dialogId);
        // ---------- Original Method ----------
        //if (stackLogger.isLoggingEnabled()) {
            //stackLogger.logWarning("Silently removing dialog from table");
        //}
        //dialogTable.remove(dialogId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.468 -0400", hash_original_method = "5BA8167D6AC26A2C080E0DF071E238DD", hash_generated_method = "2CDFC8313CE00D98F732F54DD7905847")
    public SIPClientTransaction findSubscribeTransaction(SIPRequest notifyMessage,
            ListeningPointImpl listeningPoint) {
        addTaint(listeningPoint.getTaint());
        addTaint(notifyMessage.getTaint());
        SIPClientTransaction retval = null;
        try 
        {
            Iterator it = clientTransactionTable.values().iterator();
            if(stackLogger.isLoggingEnabled())            
            stackLogger.logDebug("ct table size = " + clientTransactionTable.size());
            String thisToTag = notifyMessage.getTo().getTag();
            if(thisToTag == null)            
            {
SIPClientTransaction varF9E19AD6135C970F387F77C6F3DE4477_1260567685 =                 retval;
                varF9E19AD6135C970F387F77C6F3DE4477_1260567685.addTaint(taint);
                return varF9E19AD6135C970F387F77C6F3DE4477_1260567685;
            } //End block
            Event eventHdr = (Event) notifyMessage.getHeader(EventHeader.NAME);
            if(eventHdr == null)            
            {
                if(stackLogger.isLoggingEnabled())                
                {
                    stackLogger.logDebug("event Header is null -- returning null");
                } //End block
SIPClientTransaction varF9E19AD6135C970F387F77C6F3DE4477_1995726257 =                 retval;
                varF9E19AD6135C970F387F77C6F3DE4477_1995726257.addTaint(taint);
                return varF9E19AD6135C970F387F77C6F3DE4477_1995726257;
            } //End block
            while
(it.hasNext())            
            {
                SIPClientTransaction ct = (SIPClientTransaction) it.next();
                if(!ct.getMethod().equals(Request.SUBSCRIBE))                
                continue;
                String fromTag = ct.from.getTag();
                Event hisEvent = ct.event;
                if(hisEvent == null)                
                continue;
                if(stackLogger.isLoggingEnabled())                
                {
                    stackLogger.logDebug("ct.fromTag = " + fromTag);
                    stackLogger.logDebug("thisToTag = " + thisToTag);
                    stackLogger.logDebug("hisEvent = " + hisEvent);
                    stackLogger.logDebug("eventHdr " + eventHdr);
                } //End block
                if(fromTag.equalsIgnoreCase(thisToTag)
                      && hisEvent != null
                      && eventHdr.match(hisEvent)
                      && notifyMessage.getCallId().getCallId().equalsIgnoreCase(
                                ct.callId.getCallId()))                
                {
                    if(ct.acquireSem())                    
                    retval = ct;
SIPClientTransaction varF9E19AD6135C970F387F77C6F3DE4477_1820449849 =                     retval;
                    varF9E19AD6135C970F387F77C6F3DE4477_1820449849.addTaint(taint);
                    return varF9E19AD6135C970F387F77C6F3DE4477_1820449849;
                } //End block
            } //End block
SIPClientTransaction varF9E19AD6135C970F387F77C6F3DE4477_1991957262 =             retval;
            varF9E19AD6135C970F387F77C6F3DE4477_1991957262.addTaint(taint);
            return varF9E19AD6135C970F387F77C6F3DE4477_1991957262;
        } //End block
        finally 
        {
            if(stackLogger.isLoggingEnabled())            
            stackLogger.logDebug("findSubscribeTransaction : returning " + retval);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.468 -0400", hash_original_method = "D49C9B94E89B7FEA3320280273306438", hash_generated_method = "0E01EC92E5E6C27E32CAA77D468437AB")
    public void addTransactionPendingAck(SIPServerTransaction serverTransaction) {
        addTaint(serverTransaction.getTaint());
        String branchId = ((SIPRequest)serverTransaction.getRequest()).getTopmostVia().getBranch();
        if(branchId != null)        
        {
            this.terminatedServerTransactionsPendingAck.put(branchId, serverTransaction);
        } //End block
        // ---------- Original Method ----------
        //String branchId = ((SIPRequest)serverTransaction.getRequest()).getTopmostVia().getBranch();
        //if ( branchId != null ) {
            //this.terminatedServerTransactionsPendingAck.put(branchId, serverTransaction);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.468 -0400", hash_original_method = "37709198085D538D169FF1DE9D9ADB9C", hash_generated_method = "1A81D1CD36832972165529691213FE80")
    public SIPServerTransaction findTransactionPendingAck(SIPRequest ackMessage) {
        addTaint(ackMessage.getTaint());
SIPServerTransaction varFF28008081901DAAD880D5923B1D7D51_1459796796 =         this.terminatedServerTransactionsPendingAck.get(ackMessage.getTopmostVia().getBranch());
        varFF28008081901DAAD880D5923B1D7D51_1459796796.addTaint(taint);
        return varFF28008081901DAAD880D5923B1D7D51_1459796796;
        // ---------- Original Method ----------
        //return this.terminatedServerTransactionsPendingAck.get(ackMessage.getTopmostVia().getBranch());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.468 -0400", hash_original_method = "B481CD0C272F0294325516CB58C4D625", hash_generated_method = "9633A8B9C0DC8F90792CB95A2ADF618F")
    public boolean removeTransactionPendingAck(SIPServerTransaction serverTransaction) {
        addTaint(serverTransaction.getTaint());
        String branchId = ((SIPRequest)serverTransaction.getRequest()).getTopmostVia().getBranch();
        if(branchId != null && this.terminatedServerTransactionsPendingAck.containsKey(branchId))        
        {
            this.terminatedServerTransactionsPendingAck.remove(branchId);
            boolean varB326B5062B2F0E69046810717534CB09_833237847 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_369278172 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_369278172;
        } //End block
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_1867379928 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_612348126 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_612348126;
        } //End block
        // ---------- Original Method ----------
        //String branchId = ((SIPRequest)serverTransaction.getRequest()).getTopmostVia().getBranch();
        //if ( branchId != null && this.terminatedServerTransactionsPendingAck.containsKey(branchId) ) {
            //this.terminatedServerTransactionsPendingAck.remove(branchId);
            //return true;
        //} else {
            //return false;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.468 -0400", hash_original_method = "E118D63661EEDB81E619AEC2D5F479DE", hash_generated_method = "AB3EE628604C62C63E1D64713E305FA3")
    public boolean isTransactionPendingAck(SIPServerTransaction serverTransaction) {
        addTaint(serverTransaction.getTaint());
        String branchId = ((SIPRequest)serverTransaction.getRequest()).getTopmostVia().getBranch();
        boolean var5D0A1A3F945AC0690D867E97AA461A0D_1202553944 = (this.terminatedServerTransactionsPendingAck.contains(branchId));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1392023474 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1392023474;
        // ---------- Original Method ----------
        //String branchId = ((SIPRequest)serverTransaction.getRequest()).getTopmostVia().getBranch();
        //return this.terminatedServerTransactionsPendingAck.contains(branchId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.469 -0400", hash_original_method = "CFF098965464555AD1B1F596C34C16A1", hash_generated_method = "DE956E2839ADD313A6C69EBA4EF916CA")
    public SIPTransaction findTransaction(SIPMessage sipMessage, boolean isServer) {
        addTaint(isServer);
        addTaint(sipMessage.getTaint());
        SIPTransaction retval = null;
        try 
        {
            if(isServer)            
            {
                Via via = sipMessage.getTopmostVia();
                if(via.getBranch() != null)                
                {
                    String key = sipMessage.getTransactionId();
                    retval = (SIPTransaction) serverTransactionTable.get(key);
                    if(stackLogger.isLoggingEnabled())                    
                    getStackLogger().logDebug(
                                "serverTx: looking for key " + key + " existing="
                                + serverTransactionTable);
                    if(key.startsWith(SIPConstants.BRANCH_MAGIC_COOKIE_LOWER_CASE))                    
                    {
SIPTransaction varF9E19AD6135C970F387F77C6F3DE4477_1774959818 =                         retval;
                        varF9E19AD6135C970F387F77C6F3DE4477_1774959818.addTaint(taint);
                        return varF9E19AD6135C970F387F77C6F3DE4477_1774959818;
                    } //End block
                } //End block
                Iterator<SIPServerTransaction> it = serverTransactionTable.values().iterator();
                while
(it.hasNext())                
                {
                    SIPServerTransaction sipServerTransaction = (SIPServerTransaction) it.next();
                    if(sipServerTransaction.isMessagePartOfTransaction(sipMessage))                    
                    {
                        retval = sipServerTransaction;
SIPTransaction varF9E19AD6135C970F387F77C6F3DE4477_692837088 =                         retval;
                        varF9E19AD6135C970F387F77C6F3DE4477_692837088.addTaint(taint);
                        return varF9E19AD6135C970F387F77C6F3DE4477_692837088;
                    } //End block
                } //End block
            } //End block
            else
            {
                Via via = sipMessage.getTopmostVia();
                if(via.getBranch() != null)                
                {
                    String key = sipMessage.getTransactionId();
                    if(stackLogger.isLoggingEnabled())                    
                    getStackLogger().logDebug("clientTx: looking for key " + key);
                    retval = (SIPTransaction) clientTransactionTable.get(key);
                    if(key.startsWith(SIPConstants.BRANCH_MAGIC_COOKIE_LOWER_CASE))                    
                    {
SIPTransaction varF9E19AD6135C970F387F77C6F3DE4477_1938928405 =                         retval;
                        varF9E19AD6135C970F387F77C6F3DE4477_1938928405.addTaint(taint);
                        return varF9E19AD6135C970F387F77C6F3DE4477_1938928405;
                    } //End block
                } //End block
                Iterator<SIPClientTransaction> it = clientTransactionTable.values().iterator();
                while
(it.hasNext())                
                {
                    SIPClientTransaction clientTransaction = (SIPClientTransaction) it.next();
                    if(clientTransaction.isMessagePartOfTransaction(sipMessage))                    
                    {
                        retval = clientTransaction;
SIPTransaction varF9E19AD6135C970F387F77C6F3DE4477_811148815 =                         retval;
                        varF9E19AD6135C970F387F77C6F3DE4477_811148815.addTaint(taint);
                        return varF9E19AD6135C970F387F77C6F3DE4477_811148815;
                    } //End block
                } //End block
            } //End block
        } //End block
        finally 
        {
            if(this.getStackLogger().isLoggingEnabled())            
            {
                this.getStackLogger().logDebug("findTransaction: returning  : " + retval);
            } //End block
        } //End block
SIPTransaction varF9E19AD6135C970F387F77C6F3DE4477_974248453 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_974248453.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_974248453;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.470 -0400", hash_original_method = "EBA76BEAE03DA80AC45DCE1E9705412D", hash_generated_method = "7B55DCC5D81D45F958834195BB6B2A65")
    public SIPTransaction findCancelTransaction(SIPRequest cancelRequest, boolean isServer) {
        addTaint(isServer);
        addTaint(cancelRequest.getTaint());
        if(stackLogger.isLoggingEnabled())        
        {
            stackLogger.logDebug("findCancelTransaction request= \n" + cancelRequest
                    + "\nfindCancelRequest isServer=" + isServer);
        } //End block
        if(isServer)        
        {
            Iterator<SIPServerTransaction> li = this.serverTransactionTable.values().iterator();
            while
(li.hasNext())            
            {
                SIPTransaction transaction = (SIPTransaction) li.next();
                SIPServerTransaction sipServerTransaction = (SIPServerTransaction) transaction;
                if(sipServerTransaction.doesCancelMatchTransaction(cancelRequest))                
                {
SIPTransaction var1FAA5036BAA00F3EA31A8841374E84D3_1385990538 =                 sipServerTransaction;
                var1FAA5036BAA00F3EA31A8841374E84D3_1385990538.addTaint(taint);
                return var1FAA5036BAA00F3EA31A8841374E84D3_1385990538;
                }
            } //End block
        } //End block
        else
        {
            Iterator<SIPClientTransaction> li = this.clientTransactionTable.values().iterator();
            while
(li.hasNext())            
            {
                SIPTransaction transaction = (SIPTransaction) li.next();
                SIPClientTransaction sipClientTransaction = (SIPClientTransaction) transaction;
                if(sipClientTransaction.doesCancelMatchTransaction(cancelRequest))                
                {
SIPTransaction var769D0E72DBE7F4CD9C6A87A5CEAAE4D7_669336467 =                 sipClientTransaction;
                var769D0E72DBE7F4CD9C6A87A5CEAAE4D7_669336467.addTaint(taint);
                return var769D0E72DBE7F4CD9C6A87A5CEAAE4D7_669336467;
                }
            } //End block
        } //End block
        if(stackLogger.isLoggingEnabled())        
        stackLogger.logDebug("Could not find transaction for cancel request");
SIPTransaction var540C13E9E156B687226421B24F2DF178_1787752337 =         null;
        var540C13E9E156B687226421B24F2DF178_1787752337.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1787752337;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.470 -0400", hash_original_method = "C32886C5E5EF95CE74E82DCEA7E677B6", hash_generated_method = "0F0519E837B328389737159114BDB7BE")
    public SIPServerTransaction findPendingTransaction(SIPRequest requestReceived) {
        addTaint(requestReceived.getTaint());
        if(this.stackLogger.isLoggingEnabled())        
        {
            this.stackLogger.logDebug("looking for pending tx for :"
                    + requestReceived.getTransactionId());
        } //End block
SIPServerTransaction var7C702BB0E1A7E573D9515656A08040DC_455104718 =         (SIPServerTransaction) pendingTransactions.get(requestReceived.getTransactionId());
        var7C702BB0E1A7E573D9515656A08040DC_455104718.addTaint(taint);
        return var7C702BB0E1A7E573D9515656A08040DC_455104718;
        // ---------- Original Method ----------
        //if (this.stackLogger.isLoggingEnabled()) {
            //this.stackLogger.logDebug("looking for pending tx for :"
                    //+ requestReceived.getTransactionId());
        //}
        //return (SIPServerTransaction) pendingTransactions.get(requestReceived.getTransactionId());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.470 -0400", hash_original_method = "DE7BCEF3CEAF7F5E4F7BCE647A148129", hash_generated_method = "8B35C867F8E7282ED7F3DB62EEDBD807")
    public SIPServerTransaction findMergedTransaction(SIPRequest sipRequest) {
        addTaint(sipRequest.getTaint());
        if(! sipRequest.getMethod().equals(Request.INVITE))        
        {
SIPServerTransaction var540C13E9E156B687226421B24F2DF178_100181359 =             null;
            var540C13E9E156B687226421B24F2DF178_100181359.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_100181359;
        } //End block
        String mergeId = sipRequest.getMergeId();
        SIPServerTransaction mergedTransaction = (SIPServerTransaction) this.mergeTable.get(mergeId);
        if(mergeId == null)        
        {
SIPServerTransaction var540C13E9E156B687226421B24F2DF178_255694002 =             null;
            var540C13E9E156B687226421B24F2DF178_255694002.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_255694002;
        } //End block
        else
        if(mergedTransaction != null && !mergedTransaction.isMessagePartOfTransaction(sipRequest))        
        {
SIPServerTransaction varA1543672BC16962E3032E9ABD630AE97_66424140 =             mergedTransaction;
            varA1543672BC16962E3032E9ABD630AE97_66424140.addTaint(taint);
            return varA1543672BC16962E3032E9ABD630AE97_66424140;
        } //End block
        else
        {
for(Dialog dialog : this.dialogTable.values())
            {
                SIPDialog sipDialog = (SIPDialog) dialog;
                if(sipDialog.getFirstTransaction()  != null && 
                   sipDialog.getFirstTransaction() instanceof ServerTransaction)                
                {
                    SIPServerTransaction serverTransaction = ((SIPServerTransaction) sipDialog.getFirstTransaction());
                    SIPRequest transactionRequest = ((SIPServerTransaction) sipDialog.getFirstTransaction()).getOriginalRequest();
                    if((! serverTransaction.isMessagePartOfTransaction(sipRequest))
                           && sipRequest.getMergeId().equals(transactionRequest.getMergeId()))                    
                    {
SIPServerTransaction var671AAAB82D9BE575B0DC012737CF62DA_1361894827 =                         (SIPServerTransaction) sipDialog.getFirstTransaction();
                        var671AAAB82D9BE575B0DC012737CF62DA_1361894827.addTaint(taint);
                        return var671AAAB82D9BE575B0DC012737CF62DA_1361894827;
                    } //End block
                } //End block
            } //End block
SIPServerTransaction var540C13E9E156B687226421B24F2DF178_557759573 =             null;
            var540C13E9E156B687226421B24F2DF178_557759573.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_557759573;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.471 -0400", hash_original_method = "365415518ECAE79EAD0CD2C9D4462A78", hash_generated_method = "7ABFC103BBD8A8E4393CC8219D1C9C38")
    public void removePendingTransaction(SIPServerTransaction tr) {
        addTaint(tr.getTaint());
        if(this.stackLogger.isLoggingEnabled())        
        {
            this.stackLogger.logDebug("removePendingTx: " + tr.getTransactionId());
        } //End block
        this.pendingTransactions.remove(tr.getTransactionId());
        // ---------- Original Method ----------
        //if (this.stackLogger.isLoggingEnabled()) {
            //this.stackLogger.logDebug("removePendingTx: " + tr.getTransactionId());
        //}
        //this.pendingTransactions.remove(tr.getTransactionId());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.471 -0400", hash_original_method = "DB6ED2CEA840316B4782573C88C3E1FC", hash_generated_method = "9FB9EFA33E0F4BE21631212DF0EBD606")
    public void removeFromMergeTable(SIPServerTransaction tr) {
        addTaint(tr.getTaint());
        if(stackLogger.isLoggingEnabled())        
        {
            this.stackLogger.logDebug("Removing tx from merge table ");
        } //End block
        String key = ((SIPRequest) tr.getRequest()).getMergeId();
        if(key != null)        
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.471 -0400", hash_original_method = "4DF3A9A601EFF55EEB4CCC4D0E1A4382", hash_generated_method = "9DDF57C5C8CD83C9EB5FD169E6793E11")
    public void putInMergeTable(SIPServerTransaction sipTransaction, SIPRequest sipRequest) {
        addTaint(sipRequest.getTaint());
        addTaint(sipTransaction.getTaint());
        String mergeKey = sipRequest.getMergeId();
        if(mergeKey != null)        
        {
            this.mergeTable.put(mergeKey, sipTransaction);
        } //End block
        // ---------- Original Method ----------
        //String mergeKey = sipRequest.getMergeId();
        //if (mergeKey != null) {
            //this.mergeTable.put(mergeKey, sipTransaction);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.471 -0400", hash_original_method = "8109166214A5696534573E329912E2B5", hash_generated_method = "2C86B0C772BB73E87A57F67B9727B6A7")
    public void mapTransaction(SIPServerTransaction transaction) {
        addTaint(transaction.getTaint());
        if(transaction.isMapped)        
        return;
        addTransactionHash(transaction);
        transaction.isMapped = true;
        // ---------- Original Method ----------
        //if (transaction.isMapped)
            //return;
        //addTransactionHash(transaction);
        //transaction.isMapped = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.472 -0400", hash_original_method = "C3F915B9919F99B9388976510DFE400E", hash_generated_method = "E8316E146C6F4CB684E075B4FD2BEF1F")
    public ServerRequestInterface newSIPServerRequest(SIPRequest requestReceived,
            MessageChannel requestMessageChannel) {
        addTaint(requestMessageChannel.getTaint());
        addTaint(requestReceived.getTaint());
        Iterator<SIPServerTransaction> transactionIterator;
        SIPServerTransaction nextTransaction;
        SIPServerTransaction currentTransaction;
        String key = requestReceived.getTransactionId();
        requestReceived.setMessageChannel(requestMessageChannel);
        currentTransaction = (SIPServerTransaction) serverTransactionTable.get(key);
        if(currentTransaction == null
                || !currentTransaction.isMessagePartOfTransaction(requestReceived))        
        {
            transactionIterator = serverTransactionTable.values().iterator();
            currentTransaction = null;
            if(!key.toLowerCase().startsWith(SIPConstants.BRANCH_MAGIC_COOKIE_LOWER_CASE))            
            {
                while
(transactionIterator.hasNext() && currentTransaction == null)                
                {
                    nextTransaction = (SIPServerTransaction) transactionIterator.next();
                    if(nextTransaction.isMessagePartOfTransaction(requestReceived))                    
                    {
                        currentTransaction = nextTransaction;
                    } //End block
                } //End block
            } //End block
            if(currentTransaction == null)            
            {
                currentTransaction = findPendingTransaction(requestReceived);
                if(currentTransaction != null)                
                {
                    requestReceived.setTransaction(currentTransaction);
                    if(currentTransaction != null && currentTransaction.acquireSem())                    
                    {
ServerRequestInterface varF6519D3D1C7BE582230385CE50FB4124_1257236665 =                     currentTransaction;
                    varF6519D3D1C7BE582230385CE50FB4124_1257236665.addTaint(taint);
                    return varF6519D3D1C7BE582230385CE50FB4124_1257236665;
                    }
                    else
                    {
ServerRequestInterface var540C13E9E156B687226421B24F2DF178_575584138 =                     null;
                    var540C13E9E156B687226421B24F2DF178_575584138.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_575584138;
                    }
                } //End block
                currentTransaction = createServerTransaction(requestMessageChannel);
                if(currentTransaction != null)                
                {
                    currentTransaction.setOriginalRequest(requestReceived);
                    requestReceived.setTransaction(currentTransaction);
                } //End block
            } //End block
        } //End block
        if(stackLogger.isLoggingEnabled())        
        {
            stackLogger.logDebug("newSIPServerRequest( " + requestReceived.getMethod() + ":"
                    + requestReceived.getTopmostVia().getBranch() + "):" + currentTransaction);
        } //End block
        if(currentTransaction != null)        
        currentTransaction.setRequestInterface(sipMessageFactory.newSIPServerRequest(
                    requestReceived, currentTransaction));
        if(currentTransaction != null && currentTransaction.acquireSem())        
        {
ServerRequestInterface varF6519D3D1C7BE582230385CE50FB4124_652679195 =             currentTransaction;
            varF6519D3D1C7BE582230385CE50FB4124_652679195.addTaint(taint);
            return varF6519D3D1C7BE582230385CE50FB4124_652679195;
        } //End block
        else
        if(currentTransaction != null)        
        {
            try 
            {
                if(currentTransaction.isMessagePartOfTransaction(requestReceived) &&
                    currentTransaction.getMethod().equals(requestReceived.getMethod()))                
                {
                    SIPResponse trying = requestReceived.createResponse(Response.TRYING);
                    trying.removeContent();
                    currentTransaction.getMessageChannel().sendMessage(trying);
                } //End block
            } //End block
            catch (Exception ex)
            {
                if(isLoggingEnabled())                
                stackLogger.logError("Exception occured sending TRYING");
            } //End block
ServerRequestInterface var540C13E9E156B687226421B24F2DF178_1018538342 =             null;
            var540C13E9E156B687226421B24F2DF178_1018538342.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1018538342;
        } //End block
        else
        {
ServerRequestInterface var540C13E9E156B687226421B24F2DF178_994842492 =             null;
            var540C13E9E156B687226421B24F2DF178_994842492.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_994842492;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.473 -0400", hash_original_method = "62ADB5DE3DAA611F01F5B25EB82A32E9", hash_generated_method = "C97DA921F45B15AA641DF6B5318B7846")
    public ServerResponseInterface newSIPServerResponse(SIPResponse responseReceived,
            MessageChannel responseMessageChannel) {
        addTaint(responseMessageChannel.getTaint());
        addTaint(responseReceived.getTaint());
        Iterator<SIPClientTransaction> transactionIterator;
        SIPClientTransaction nextTransaction;
        SIPClientTransaction currentTransaction;
        String key = responseReceived.getTransactionId();
        currentTransaction = (SIPClientTransaction) clientTransactionTable.get(key);
        if(currentTransaction == null
                || (!currentTransaction.isMessagePartOfTransaction(responseReceived) && !key
                        .startsWith(SIPConstants.BRANCH_MAGIC_COOKIE_LOWER_CASE)))        
        {
            transactionIterator = clientTransactionTable.values().iterator();
            currentTransaction = null;
            while
(transactionIterator.hasNext() && currentTransaction == null)            
            {
                nextTransaction = (SIPClientTransaction) transactionIterator.next();
                if(nextTransaction.isMessagePartOfTransaction(responseReceived))                
                {
                    currentTransaction = nextTransaction;
                } //End block
            } //End block
            if(currentTransaction == null)            
            {
                if(this.stackLogger.isLoggingEnabled(StackLogger.TRACE_INFO))                
                {
                    responseMessageChannel.logResponse(responseReceived, System
                            .currentTimeMillis(), "before processing");
                } //End block
ServerResponseInterface var5A98C97B4F1D02183FAA02FDC3D8A274_1782366565 =                 sipMessageFactory.newSIPServerResponse(responseReceived,
                        responseMessageChannel);
                var5A98C97B4F1D02183FAA02FDC3D8A274_1782366565.addTaint(taint);
                return var5A98C97B4F1D02183FAA02FDC3D8A274_1782366565;
            } //End block
        } //End block
        boolean acquired = currentTransaction.acquireSem();
        if(this.stackLogger.isLoggingEnabled(StackLogger.TRACE_INFO))        
        {
            currentTransaction.logResponse(responseReceived, System.currentTimeMillis(),
                    "before processing");
        } //End block
        if(acquired)        
        {
            ServerResponseInterface sri = sipMessageFactory.newSIPServerResponse(
                    responseReceived, currentTransaction);
            if(sri != null)            
            {
                currentTransaction.setResponseInterface(sri);
            } //End block
            else
            {
                if(this.stackLogger.isLoggingEnabled())                
                {
                    this.stackLogger.logDebug("returning null - serverResponseInterface is null!");
                } //End block
                currentTransaction.releaseSem();
ServerResponseInterface var540C13E9E156B687226421B24F2DF178_1875505680 =                 null;
                var540C13E9E156B687226421B24F2DF178_1875505680.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1875505680;
            } //End block
        } //End block
        else
        {
            if(stackLogger.isLoggingEnabled())            
            this.stackLogger.logDebug("Could not aquire semaphore !!");
        } //End block
        if(acquired)        
        {
ServerResponseInterface varF6519D3D1C7BE582230385CE50FB4124_997452665 =         currentTransaction;
        varF6519D3D1C7BE582230385CE50FB4124_997452665.addTaint(taint);
        return varF6519D3D1C7BE582230385CE50FB4124_997452665;
        }
        else
        {
ServerResponseInterface var540C13E9E156B687226421B24F2DF178_1798009951 =         null;
        var540C13E9E156B687226421B24F2DF178_1798009951.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1798009951;
        }
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.474 -0400", hash_original_method = "32F3E8827D13E0BAFD4E9DD3BE9CB370", hash_generated_method = "9314964762E9486DEBADC5A8854E6D6A")
    public MessageChannel createMessageChannel(SIPRequest request, MessageProcessor mp,
            Hop nextHop) throws IOException {
        addTaint(nextHop.getTaint());
        addTaint(mp.getTaint());
        addTaint(request.getTaint());
        SIPTransaction returnChannel;
        Host targetHost = new Host();
        targetHost.setHostname(nextHop.getHost());
        HostPort targetHostPort = new HostPort();
        targetHostPort.setHost(targetHost);
        targetHostPort.setPort(nextHop.getPort());
        MessageChannel mc = mp.createMessageChannel(targetHostPort);
        if(mc == null)        
        {
MessageChannel var540C13E9E156B687226421B24F2DF178_1286948488 =         null;
        var540C13E9E156B687226421B24F2DF178_1286948488.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1286948488;
        }
        returnChannel = createClientTransaction(request, mc);
        ((SIPClientTransaction) returnChannel).setViaPort(nextHop.getPort());
        ((SIPClientTransaction) returnChannel).setViaHost(nextHop.getHost());
        addTransactionHash(returnChannel);
MessageChannel varA4EB2F1340F166252C120AE399485422_968312540 =         returnChannel;
        varA4EB2F1340F166252C120AE399485422_968312540.addTaint(taint);
        return varA4EB2F1340F166252C120AE399485422_968312540;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.474 -0400", hash_original_method = "912DB48513D0A0D8594B2E782158C138", hash_generated_method = "45C76D0C78117C1450C2E238DDE7CECA")
    public SIPClientTransaction createClientTransaction(SIPRequest sipRequest,
            MessageChannel encapsulatedMessageChannel) {
        addTaint(encapsulatedMessageChannel.getTaint());
        addTaint(sipRequest.getTaint());
        SIPClientTransaction ct = new SIPClientTransaction(this, encapsulatedMessageChannel);
        ct.setOriginalRequest(sipRequest);
SIPClientTransaction varB6CBF65560612EA4D10B4B8A9201976F_2096040568 =         ct;
        varB6CBF65560612EA4D10B4B8A9201976F_2096040568.addTaint(taint);
        return varB6CBF65560612EA4D10B4B8A9201976F_2096040568;
        // ---------- Original Method ----------
        //SIPClientTransaction ct = new SIPClientTransaction(this, encapsulatedMessageChannel);
        //ct.setOriginalRequest(sipRequest);
        //return ct;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.474 -0400", hash_original_method = "81B760547C7425A938D45D7063876C66", hash_generated_method = "BF8FDA39DED1B73E739B9680EAD33088")
    public SIPServerTransaction createServerTransaction(MessageChannel encapsulatedMessageChannel) {
        addTaint(encapsulatedMessageChannel.getTaint());
        if(unlimitedServerTransactionTableSize)        
        {
SIPServerTransaction varE52D098A62AE08C43CFA67AFBFB0CA01_882147396 =             new SIPServerTransaction(this, encapsulatedMessageChannel);
            varE52D098A62AE08C43CFA67AFBFB0CA01_882147396.addTaint(taint);
            return varE52D098A62AE08C43CFA67AFBFB0CA01_882147396;
        } //End block
        else
        {
            float threshold = ((float) (serverTransactionTable.size() - serverTransactionTableLowaterMark))
                    / ((float) (serverTransactionTableHighwaterMark - serverTransactionTableLowaterMark));
            boolean decision = Math.random() > 1.0 - threshold;
            if(decision)            
            {
SIPServerTransaction var540C13E9E156B687226421B24F2DF178_716707006 =                 null;
                var540C13E9E156B687226421B24F2DF178_716707006.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_716707006;
            } //End block
            else
            {
SIPServerTransaction varE52D098A62AE08C43CFA67AFBFB0CA01_1695680876 =                 new SIPServerTransaction(this, encapsulatedMessageChannel);
                varE52D098A62AE08C43CFA67AFBFB0CA01_1695680876.addTaint(taint);
                return varE52D098A62AE08C43CFA67AFBFB0CA01_1695680876;
            } //End block
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.474 -0400", hash_original_method = "2775112CA96E4BBD847FD3F2A14A81DE", hash_generated_method = "72115B12331C3346F19BADAF14A409CB")
    public int getClientTransactionTableSize() {
        int var0DB88A3FE64C4AE552E01842B13CCC2A_1775019848 = (this.clientTransactionTable.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1023064625 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1023064625;
        // ---------- Original Method ----------
        //return this.clientTransactionTable.size();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.474 -0400", hash_original_method = "4372809DD9897424686B6F4A147D93FA", hash_generated_method = "0DB4786AF1F9CA6B9C74B81A1F010B60")
    public int getServerTransactionTableSize() {
        int var0CC88CD97AF112A12FFC5A8FE01EEFE1_782055196 = (this.serverTransactionTable.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_703484116 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_703484116;
        // ---------- Original Method ----------
        //return this.serverTransactionTable.size();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.475 -0400", hash_original_method = "2F0441D135E4CBEEA76B3CCA00FAD23B", hash_generated_method = "01168C8DA273013562829F52FCEBE2DA")
    public void addTransaction(SIPClientTransaction clientTransaction) {
        addTaint(clientTransaction.getTaint());
        if(stackLogger.isLoggingEnabled())        
        stackLogger.logDebug("added transaction " + clientTransaction);
        addTransactionHash(clientTransaction);
        // ---------- Original Method ----------
        //if (stackLogger.isLoggingEnabled())
            //stackLogger.logDebug("added transaction " + clientTransaction);
        //addTransactionHash(clientTransaction);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.475 -0400", hash_original_method = "FC7C0EB4C2CF25B4E39BD000BE1A0318", hash_generated_method = "A7AA4CC75F25AD01F82BC0E81F7C8989")
    public void removeTransaction(SIPTransaction sipTransaction) {
        addTaint(sipTransaction.getTaint());
        if(stackLogger.isLoggingEnabled())        
        {
            stackLogger.logDebug("Removing Transaction = " + sipTransaction.getTransactionId()
                    + " transaction = " + sipTransaction);
        } //End block
        if(sipTransaction instanceof SIPServerTransaction)        
        {
            if(stackLogger.isLoggingEnabled())            
            stackLogger.logStackTrace();
            String key = sipTransaction.getTransactionId();
            Object removed = serverTransactionTable.remove(key);
            String method = sipTransaction.getMethod();
            this.removePendingTransaction((SIPServerTransaction) sipTransaction);
            this.removeTransactionPendingAck((SIPServerTransaction) sipTransaction);
            if(method.equalsIgnoreCase(Request.INVITE))            
            {
                this.removeFromMergeTable((SIPServerTransaction) sipTransaction);
            } //End block
            SipProviderImpl sipProvider = (SipProviderImpl) sipTransaction.getSipProvider();
            if(removed != null && sipTransaction.testAndSetTransactionTerminatedEvent())            
            {
                TransactionTerminatedEvent event = new TransactionTerminatedEvent(sipProvider,
                        (ServerTransaction) sipTransaction);
                sipProvider.handleEvent(event, sipTransaction);
            } //End block
        } //End block
        else
        {
            String key = sipTransaction.getTransactionId();
            Object removed = clientTransactionTable.remove(key);
            if(stackLogger.isLoggingEnabled())            
            {
                stackLogger.logDebug("REMOVED client tx " + removed + " KEY = " + key);
                if(removed != null)                
                {
                    SIPClientTransaction clientTx = (SIPClientTransaction)removed;
                    if(clientTx.getMethod().equals(Request.INVITE) && this.maxForkTime != 0)                    
                    {
                        RemoveForkedTransactionTimerTask ttask = new RemoveForkedTransactionTimerTask(clientTx);
                        this.timer.schedule(ttask, this.maxForkTime * 1000);
                    } //End block
                } //End block
            } //End block
            if(removed != null && sipTransaction.testAndSetTransactionTerminatedEvent())            
            {
                SipProviderImpl sipProvider = (SipProviderImpl) sipTransaction.getSipProvider();
                TransactionTerminatedEvent event = new TransactionTerminatedEvent(sipProvider,
                        (ClientTransaction) sipTransaction);
                sipProvider.handleEvent(event, sipTransaction);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.475 -0400", hash_original_method = "114E6F44E2106B74A7437814EDE26008", hash_generated_method = "EB7B15E29F89D7F2C2CE7B182C01506D")
    public void addTransaction(SIPServerTransaction serverTransaction) throws IOException {
        addTaint(serverTransaction.getTaint());
        if(stackLogger.isLoggingEnabled())        
        stackLogger.logDebug("added transaction " + serverTransaction);
        serverTransaction.map();
        addTransactionHash(serverTransaction);
        // ---------- Original Method ----------
        //if (stackLogger.isLoggingEnabled())
            //stackLogger.logDebug("added transaction " + serverTransaction);
        //serverTransaction.map();
        //addTransactionHash(serverTransaction);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.475 -0400", hash_original_method = "A02B6100DC58EB921085C7ED44EE1D0C", hash_generated_method = "2B36324108A02819C43B8B2B3A7540E9")
    private void addTransactionHash(SIPTransaction sipTransaction) {
        addTaint(sipTransaction.getTaint());
        SIPRequest sipRequest = sipTransaction.getOriginalRequest();
        if(sipTransaction instanceof SIPClientTransaction)        
        {
            if(!this.unlimitedClientTransactionTableSize)            
            {
                if(this.activeClientTransactionCount.get() > clientTransactionTableHiwaterMark)                
                {
                    try 
                    {
                        synchronized
(this.clientTransactionTable)                        {
                            this.clientTransactionTable.wait();
                            this.activeClientTransactionCount.incrementAndGet();
                        } //End block
                    } //End block
                    catch (Exception ex)
                    {
                        if(stackLogger.isLoggingEnabled())                        
                        {
                            stackLogger.logError("Exception occured while waiting for room", ex);
                        } //End block
                    } //End block
                } //End block
            } //End block
            else
            {
                this.activeClientTransactionCount.incrementAndGet();
            } //End block
            String key = sipRequest.getTransactionId();
            clientTransactionTable.put(key, (SIPClientTransaction) sipTransaction);
            if(stackLogger.isLoggingEnabled())            
            {
                stackLogger.logDebug(" putTransactionHash : " + " key = " + key);
            } //End block
        } //End block
        else
        {
            String key = sipRequest.getTransactionId();
            if(stackLogger.isLoggingEnabled())            
            {
                stackLogger.logDebug(" putTransactionHash : " + " key = " + key);
            } //End block
            serverTransactionTable.put(key, (SIPServerTransaction) sipTransaction);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.476 -0400", hash_original_method = "380804F8BD40257E05E5F5A307273856", hash_generated_method = "F9FAFC46158D31F00A45CD9787B27388")
    protected void decrementActiveClientTransactionCount() {
        if(this.activeClientTransactionCount.decrementAndGet() <= this.clientTransactionTableLowaterMark
                && !this.unlimitedClientTransactionTableSize)        
        {
            synchronized
(this.clientTransactionTable)            {
                clientTransactionTable.notify();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (this.activeClientTransactionCount.decrementAndGet() <= this.clientTransactionTableLowaterMark
                //&& !this.unlimitedClientTransactionTableSize) {
            //synchronized (this.clientTransactionTable) {
                //clientTransactionTable.notify();
            //}
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.476 -0400", hash_original_method = "BBF1530237A94448CCB60A02BEEFAB6C", hash_generated_method = "29F58E819052E6F3873652054454F62D")
    protected void removeTransactionHash(SIPTransaction sipTransaction) {
        addTaint(sipTransaction.getTaint());
        SIPRequest sipRequest = sipTransaction.getOriginalRequest();
        if(sipRequest == null)        
        return;
        if(sipTransaction instanceof SIPClientTransaction)        
        {
            String key = sipTransaction.getTransactionId();
            if(stackLogger.isLoggingEnabled())            
            {
                stackLogger.logStackTrace();
                stackLogger.logDebug("removing client Tx : " + key);
            } //End block
            clientTransactionTable.remove(key);
        } //End block
        else
        if(sipTransaction instanceof SIPServerTransaction)        
        {
            String key = sipTransaction.getTransactionId();
            serverTransactionTable.remove(key);
            if(stackLogger.isLoggingEnabled())            
            {
                stackLogger.logDebug("removing server Tx : " + key);
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.476 -0400", hash_original_method = "DE85950924139BCA289E1B65627F95C2", hash_generated_method = "82976AAAAE0DC8E62FB91C4624B05010")
    public synchronized void transactionErrorEvent(SIPTransactionErrorEvent transactionErrorEvent) {
        addTaint(transactionErrorEvent.getTaint());
        SIPTransaction transaction = (SIPTransaction) transactionErrorEvent.getSource();
        if(transactionErrorEvent.getErrorID() == SIPTransactionErrorEvent.TRANSPORT_ERROR)        
        {
            transaction.setState(SIPTransaction.TERMINATED_STATE);
            if(transaction instanceof SIPServerTransaction)            
            {
                ((SIPServerTransaction) transaction).collectionTime = 0;
            } //End block
            transaction.disableTimeoutTimer();
            transaction.disableRetransmissionTimer();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.476 -0400", hash_original_method = "2DBBC23B1910A8BC0C385035C3D36387", hash_generated_method = "E2D7FB0000142FC558E122743D290FD1")
    public synchronized void dialogErrorEvent(SIPDialogErrorEvent dialogErrorEvent) {
        addTaint(dialogErrorEvent.getTaint());
        SIPDialog sipDialog = (SIPDialog) dialogErrorEvent.getSource();
        SipListener sipListener = ((SipStackImpl)this).getSipListener();
        if(sipDialog != null && !(sipListener instanceof SipListenerExt))        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.477 -0400", hash_original_method = "EC17AB4FB84DCA37B1579E7D41B287E3", hash_generated_method = "E1E255764208016F5A4306A94EF6B961")
    public void stopStack() {
        if(this.timer != null)        
        this.timer.cancel();
        timer = null;
        this.pendingTransactions.clear();
        this.toExit = true;
        synchronized
(this)        {
            this.notifyAll();
        } //End block
        synchronized
(this.clientTransactionTable)        {
            clientTransactionTable.notifyAll();
        } //End block
        synchronized
(this.messageProcessors)        {
            MessageProcessor[] processorList;
            processorList = getMessageProcessors();
for(int processorIndex = 0;processorIndex < processorList.length;processorIndex++)
            {
                removeMessageProcessor(processorList[processorIndex]);
            } //End block
            this.ioHandler.closeAll();
        } //End block
        try 
        {
            Thread.sleep(1000);
        } //End block
        catch (InterruptedException ex)
        {
        } //End block
        this.clientTransactionTable.clear();
        this.serverTransactionTable.clear();
        this.dialogTable.clear();
        this.serverLogger.closeLogFile();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.477 -0400", hash_original_method = "CEE88C8969112A140A79BE7502F1A5FB", hash_generated_method = "8472265EA3BF43A9C6284D2FAD68931F")
    public void putPendingTransaction(SIPServerTransaction tr) {
        addTaint(tr.getTaint());
        if(stackLogger.isLoggingEnabled())        
        stackLogger.logDebug("putPendingTransaction: " + tr);
        this.pendingTransactions.put(tr.getTransactionId(), tr);
        // ---------- Original Method ----------
        //if (stackLogger.isLoggingEnabled())
            //stackLogger.logDebug("putPendingTransaction: " + tr);
        //this.pendingTransactions.put(tr.getTransactionId(), tr);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.477 -0400", hash_original_method = "A3344B5915DA0C5B05591E12A62D4610", hash_generated_method = "913C768BCE983D5B4B58B0DFB30B4928")
    public NetworkLayer getNetworkLayer() {
        if(networkLayer == null)        
        {
NetworkLayer varDA33D774FC2A8C52E553C68B2CDCDCB4_1477282805 =             DefaultNetworkLayer.SINGLETON;
            varDA33D774FC2A8C52E553C68B2CDCDCB4_1477282805.addTaint(taint);
            return varDA33D774FC2A8C52E553C68B2CDCDCB4_1477282805;
        } //End block
        else
        {
NetworkLayer varF18311AB600E5AAED7BCE43E40F6D796_1274588137 =             networkLayer;
            varF18311AB600E5AAED7BCE43E40F6D796_1274588137.addTaint(taint);
            return varF18311AB600E5AAED7BCE43E40F6D796_1274588137;
        } //End block
        // ---------- Original Method ----------
        //if (networkLayer == null) {
            //return DefaultNetworkLayer.SINGLETON;
        //} else {
            //return networkLayer;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.477 -0400", hash_original_method = "47BDB9F0F1E73BBB0BEBE9D5C68FE123", hash_generated_method = "41FDFF6D8D101F6723300067A89D9256")
    public boolean isLoggingEnabled() {
        boolean varAD122ECF75A21862E8CC1AB0404531A3_636540592 = (this.stackLogger == null ? false : this.stackLogger.isLoggingEnabled());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1432643161 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1432643161;
        // ---------- Original Method ----------
        //return this.stackLogger == null ? false : this.stackLogger.isLoggingEnabled();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.477 -0400", hash_original_method = "ACBC713DDCF210EE591047F9A9A515DC", hash_generated_method = "AB688AB961C141637B0D817D9165B9A2")
    public StackLogger getStackLogger() {
StackLogger var29D3FEA7F8E3FBDCADA1DF2E1529F6A7_473470005 =         this.stackLogger;
        var29D3FEA7F8E3FBDCADA1DF2E1529F6A7_473470005.addTaint(taint);
        return var29D3FEA7F8E3FBDCADA1DF2E1529F6A7_473470005;
        // ---------- Original Method ----------
        //return this.stackLogger;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.477 -0400", hash_original_method = "01705032DE3FE074C7E055A3A8A4FEE3", hash_generated_method = "B6224503E7266C865A21F135DDB71933")
    public ServerLogger getServerLogger() {
ServerLogger var580FA7863287C24100E1A894E747ACAF_1508053610 =         this.serverLogger;
        var580FA7863287C24100E1A894E747ACAF_1508053610.addTaint(taint);
        return var580FA7863287C24100E1A894E747ACAF_1508053610;
        // ---------- Original Method ----------
        //return this.serverLogger;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.477 -0400", hash_original_method = "9DA0FD5646924F30F0B4568C00D20E6E", hash_generated_method = "3273648CDD07064D5929AB9F132BD726")
    public int getMaxMessageSize() {
        int varEA4AD337C9E41C92C6724A923C44F279_2017912643 = (this.maxMessageSize);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_511674908 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_511674908;
        // ---------- Original Method ----------
        //return this.maxMessageSize;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.478 -0400", hash_original_method = "F7820D79676ABCB839F961B1893B47B1", hash_generated_method = "EA170E890B9C35B538B5CB86A786F5AF")
    public void setSingleThreaded() {
        this.threadPoolSize = 1;
        // ---------- Original Method ----------
        //this.threadPoolSize = 1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.478 -0400", hash_original_method = "E9690233252AAFA4C640E8F4D35D05EB", hash_generated_method = "65BB9FFF7A846847510EF99A4FA089FF")
    public void setThreadPoolSize(int size) {
        this.threadPoolSize = size;
        // ---------- Original Method ----------
        //this.threadPoolSize = size;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.478 -0400", hash_original_method = "71AE725926CCD09A123AE8B2DA17A3F2", hash_generated_method = "BDCFBBD8A7091C0AC8289D984C7F139F")
    public void setMaxConnections(int nconnections) {
        this.maxConnections = nconnections;
        // ---------- Original Method ----------
        //this.maxConnections = nconnections;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.478 -0400", hash_original_method = "48A74B192606F2E929FFF01B3041CF91", hash_generated_method = "FFFC97C416AB4C6D1B1965DE269525D4")
    public Hop getNextHop(SIPRequest sipRequest) throws SipException {
        addTaint(sipRequest.getTaint());
        if(this.useRouterForAll)        
        {
            if(router != null)            
            {
Hop var282480A5E1FCFA5E0121C25908F6FC66_1989354564 =             router.getNextHop(sipRequest);
            var282480A5E1FCFA5E0121C25908F6FC66_1989354564.addTaint(taint);
            return var282480A5E1FCFA5E0121C25908F6FC66_1989354564;
            }
            else
            {
Hop var540C13E9E156B687226421B24F2DF178_2017300875 =             null;
            var540C13E9E156B687226421B24F2DF178_2017300875.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2017300875;
            }
        } //End block
        else
        {
            if(sipRequest.getRequestURI().isSipURI() || sipRequest.getRouteHeaders() != null)            
            {
Hop var6D10AE7D3BAE7A0CBDF636B5F598EF8E_2045496805 =                 defaultRouter.getNextHop(sipRequest);
                var6D10AE7D3BAE7A0CBDF636B5F598EF8E_2045496805.addTaint(taint);
                return var6D10AE7D3BAE7A0CBDF636B5F598EF8E_2045496805;
            } //End block
            else
            if(router != null)            
            {
Hop var282480A5E1FCFA5E0121C25908F6FC66_323141637 =                 router.getNextHop(sipRequest);
                var282480A5E1FCFA5E0121C25908F6FC66_323141637.addTaint(taint);
                return var282480A5E1FCFA5E0121C25908F6FC66_323141637;
            } //End block
            else
            {
Hop var540C13E9E156B687226421B24F2DF178_552561998 =             null;
            var540C13E9E156B687226421B24F2DF178_552561998.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_552561998;
            }
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.478 -0400", hash_original_method = "F49E7F0B68A71227FAAC90E58DC1BBF8", hash_generated_method = "0DCFD4017235BFA0DF5839F534EAAED3")
    public void setStackName(String stackName) {
        this.stackName = stackName;
        // ---------- Original Method ----------
        //this.stackName = stackName;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.478 -0400", hash_original_method = "A8237A45131D19EE871BFED3E7A5AA19", hash_generated_method = "1B6F497C12DADA1FD420688D1024D2ED")
    protected void setHostAddress(String stackAddress) throws UnknownHostException {
        if(stackAddress.indexOf(':') != stackAddress.lastIndexOf(':')
                && stackAddress.trim().charAt(0) != '[')        
        this.stackAddress = '[' + stackAddress + ']';
        else
        this.stackAddress = stackAddress;
        this.stackInetAddress = InetAddress.getByName(stackAddress);
        // ---------- Original Method ----------
        //if (stackAddress.indexOf(':') != stackAddress.lastIndexOf(':')
                //&& stackAddress.trim().charAt(0) != '[')
            //this.stackAddress = '[' + stackAddress + ']';
        //else
            //this.stackAddress = stackAddress;
        //this.stackInetAddress = InetAddress.getByName(stackAddress);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.479 -0400", hash_original_method = "54480DAD55477A9080CEE058FAAB32DE", hash_generated_method = "9282387B5686A8451585A833ECCF2C12")
    public String getHostAddress() {
String var9EC703C0BC14C859AFFAE54C3E6616E3_1155379750 =         this.stackAddress;
        var9EC703C0BC14C859AFFAE54C3E6616E3_1155379750.addTaint(taint);
        return var9EC703C0BC14C859AFFAE54C3E6616E3_1155379750;
        // ---------- Original Method ----------
        //return this.stackAddress;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.479 -0400", hash_original_method = "76950F41C787A5DB271675B8BBBB662A", hash_generated_method = "1E92BF9F05330CC7F9733D97887E55BC")
    protected void setRouter(Router router) {
        this.router = router;
        // ---------- Original Method ----------
        //this.router = router;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.479 -0400", hash_original_method = "AF384EADB40CF611F4292AFC400A4743", hash_generated_method = "C3F7F45692A7CBF26AE98C5AA8D0FFAF")
    public Router getRouter(SIPRequest request) {
        addTaint(request.getTaint());
        if(request.getRequestLine() == null)        
        {
Router var624A358163D112043654E07A188D7CEE_10655702 =             this.defaultRouter;
            var624A358163D112043654E07A188D7CEE_10655702.addTaint(taint);
            return var624A358163D112043654E07A188D7CEE_10655702;
        } //End block
        else
        if(this.useRouterForAll)        
        {
Router var5F2564D314D15C9576AA1D23F0E04989_1258317041 =             this.router;
            var5F2564D314D15C9576AA1D23F0E04989_1258317041.addTaint(taint);
            return var5F2564D314D15C9576AA1D23F0E04989_1258317041;
        } //End block
        else
        {
            if(request.getRequestURI().getScheme().equals("sip")
                    || request.getRequestURI().getScheme().equals("sips"))            
            {
Router var624A358163D112043654E07A188D7CEE_1475220439 =                 this.defaultRouter;
                var624A358163D112043654E07A188D7CEE_1475220439.addTaint(taint);
                return var624A358163D112043654E07A188D7CEE_1475220439;
            } //End block
            else
            {
                if(this.router != null)                
                {
Router var5F2564D314D15C9576AA1D23F0E04989_581035996 =                 this.router;
                var5F2564D314D15C9576AA1D23F0E04989_581035996.addTaint(taint);
                return var5F2564D314D15C9576AA1D23F0E04989_581035996;
                }
                else
                {
Router var51E1E1A0504D157E21F8B126EC99633A_1272532703 =                 defaultRouter;
                var51E1E1A0504D157E21F8B126EC99633A_1272532703.addTaint(taint);
                return var51E1E1A0504D157E21F8B126EC99633A_1272532703;
                }
            } //End block
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.480 -0400", hash_original_method = "A48D8CFCA0D4EF991F0CE4AA0090BC89", hash_generated_method = "8320A0BB900B68E26EBC9AD259B10335")
    public Router getRouter() {
Router var5F2564D314D15C9576AA1D23F0E04989_1429802408 =         this.router;
        var5F2564D314D15C9576AA1D23F0E04989_1429802408.addTaint(taint);
        return var5F2564D314D15C9576AA1D23F0E04989_1429802408;
        // ---------- Original Method ----------
        //return this.router;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.480 -0400", hash_original_method = "DA20B42A9F145510C718334C692F5A76", hash_generated_method = "C3B8CD90FD5B9D1A478CE32D0EEB1B0E")
    public boolean isAlive() {
        boolean var14B13865A289994A4E02D94879AE5235_333201256 = (!toExit);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_807121375 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_807121375;
        // ---------- Original Method ----------
        //return !toExit;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.480 -0400", hash_original_method = "A1F941D6CE0FD78BF39EC8F9AC314942", hash_generated_method = "E1542F98825C5B0DAA166BAD3E888FB6")
    protected void addMessageProcessor(MessageProcessor newMessageProcessor) throws IOException {
        addTaint(newMessageProcessor.getTaint());
        synchronized
(messageProcessors)        {
            messageProcessors.add(newMessageProcessor);
        } //End block
        // ---------- Original Method ----------
        //synchronized (messageProcessors) {
            //messageProcessors.add(newMessageProcessor);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.480 -0400", hash_original_method = "CFCCE7E1C39F0D41098F0FE9085A25D2", hash_generated_method = "4BFCC04CC26CE073B4F89F4A0154BE9C")
    protected void removeMessageProcessor(MessageProcessor oldMessageProcessor) {
        addTaint(oldMessageProcessor.getTaint());
        synchronized
(messageProcessors)        {
            if(messageProcessors.remove(oldMessageProcessor))            
            {
                oldMessageProcessor.stop();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (messageProcessors) {
            //if (messageProcessors.remove(oldMessageProcessor)) {
                //oldMessageProcessor.stop();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.480 -0400", hash_original_method = "B73144BB70E5C3E03C6EB8CA5C201D44", hash_generated_method = "0029F787FA7F072AB215B02C592C1E0A")
    protected MessageProcessor[] getMessageProcessors() {
        synchronized
(messageProcessors)        {
MessageProcessor[] var630F842C7C736109F05EB29363D61B18_1560264459 =             (MessageProcessor[]) messageProcessors.toArray(new MessageProcessor[0]);
            var630F842C7C736109F05EB29363D61B18_1560264459.addTaint(taint);
            return var630F842C7C736109F05EB29363D61B18_1560264459;
        } //End block
        // ---------- Original Method ----------
        //synchronized (messageProcessors) {
            //return (MessageProcessor[]) messageProcessors.toArray(new MessageProcessor[0]);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.482 -0400", hash_original_method = "923CC6809D53E2778E41D61552555A7F", hash_generated_method = "1EFA3633558A4A8EE11C4E88CBBAD2E0")
    protected MessageProcessor createMessageProcessor(InetAddress ipAddress, int port,
            String transport) throws java.io.IOException {
        addTaint(transport.getTaint());
        addTaint(port);
        addTaint(ipAddress.getTaint());
        if(transport.equalsIgnoreCase("udp"))        
        {
            UDPMessageProcessor udpMessageProcessor = new UDPMessageProcessor(ipAddress, this,
                    port);
            this.addMessageProcessor(udpMessageProcessor);
            this.udpFlag = true;
MessageProcessor var0DB4B7A2969879F3242D11A7C8F74DA0_1408538724 =             udpMessageProcessor;
            var0DB4B7A2969879F3242D11A7C8F74DA0_1408538724.addTaint(taint);
            return var0DB4B7A2969879F3242D11A7C8F74DA0_1408538724;
        } //End block
        else
        if(transport.equalsIgnoreCase("tcp"))        
        {
            TCPMessageProcessor tcpMessageProcessor = new TCPMessageProcessor(ipAddress, this,
                    port);
            this.addMessageProcessor(tcpMessageProcessor);
MessageProcessor var1156D7737E0FCA1FC4AF80F13FEB7397_1436799521 =             tcpMessageProcessor;
            var1156D7737E0FCA1FC4AF80F13FEB7397_1436799521.addTaint(taint);
            return var1156D7737E0FCA1FC4AF80F13FEB7397_1436799521;
        } //End block
        else
        if(transport.equalsIgnoreCase("tls"))        
        {
            TLSMessageProcessor tlsMessageProcessor = new TLSMessageProcessor(ipAddress, this,
                    port);
            this.addMessageProcessor(tlsMessageProcessor);
MessageProcessor var164DE000C0E9AE1123231CEE947BFAB7_839952230 =             tlsMessageProcessor;
            var164DE000C0E9AE1123231CEE947BFAB7_839952230.addTaint(taint);
            return var164DE000C0E9AE1123231CEE947BFAB7_839952230;
        } //End block
        else
        if(transport.equalsIgnoreCase("sctp"))        
        {
            try 
            {
                Class<?> mpc = ClassLoader.getSystemClassLoader().loadClass( "gov.nist.javax.sip.stack.sctp.SCTPMessageProcessor" );
                MessageProcessor mp = (MessageProcessor) mpc.newInstance();
                mp.initialize( ipAddress, port, this );
                this.addMessageProcessor(mp);
MessageProcessor var424C833DDE1331A6E004EAEC0B63C3BF_431906192 =                 mp;
                var424C833DDE1331A6E004EAEC0B63C3BF_431906192.addTaint(taint);
                return var424C833DDE1331A6E004EAEC0B63C3BF_431906192;
            } //End block
            catch (ClassNotFoundException e)
            {
                IllegalArgumentException varE13E8386D88A0AAB0D099EA4A357777D_648305014 = new IllegalArgumentException("SCTP not supported (needs Java 7 and SCTP jar in classpath)");
                varE13E8386D88A0AAB0D099EA4A357777D_648305014.addTaint(taint);
                throw varE13E8386D88A0AAB0D099EA4A357777D_648305014;
            } //End block
            catch (InstantiationException ie)
            {
                IllegalArgumentException var561A6715BA044C0B7ECC9E55DFB641B4_194713735 = new IllegalArgumentException("Error initializing SCTP", ie);
                var561A6715BA044C0B7ECC9E55DFB641B4_194713735.addTaint(taint);
                throw var561A6715BA044C0B7ECC9E55DFB641B4_194713735;
            } //End block
            catch (IllegalAccessException ie)
            {
                IllegalArgumentException var561A6715BA044C0B7ECC9E55DFB641B4_444115577 = new IllegalArgumentException("Error initializing SCTP", ie);
                var561A6715BA044C0B7ECC9E55DFB641B4_444115577.addTaint(taint);
                throw var561A6715BA044C0B7ECC9E55DFB641B4_444115577;
            } //End block
        } //End block
        else
        {
            IllegalArgumentException varFB1B5362CCA354EBB89505DB6492107C_425497400 = new IllegalArgumentException("bad transport");
            varFB1B5362CCA354EBB89505DB6492107C_425497400.addTaint(taint);
            throw varFB1B5362CCA354EBB89505DB6492107C_425497400;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.482 -0400", hash_original_method = "B67F8BF0F619BF3DA8779F834D136A31", hash_generated_method = "A19418B518D97C741239C5FFDF8C7894")
    protected void setMessageFactory(StackMessageFactory messageFactory) {
        this.sipMessageFactory = messageFactory;
        // ---------- Original Method ----------
        //this.sipMessageFactory = messageFactory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.484 -0400", hash_original_method = "79BA5457C24B1F2BABB705E59D2E5DE3", hash_generated_method = "E0E76B433DD3C2E6F8B6ED354BB3E2EB")
    public MessageChannel createRawMessageChannel(String sourceIpAddress, int sourcePort,
            Hop nextHop) throws UnknownHostException {
        addTaint(nextHop.getTaint());
        addTaint(sourcePort);
        addTaint(sourceIpAddress.getTaint());
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
        while
(processorIterator.hasNext() && newChannel == null)        
        {
            nextProcessor = (MessageProcessor) processorIterator.next();
            if(nextHop.getTransport().equalsIgnoreCase(nextProcessor.getTransport())
                    && sourceIpAddress.equals(nextProcessor.getIpAddress().getHostAddress())
                    && sourcePort == nextProcessor.getPort())            
            {
                try 
                {
                    newChannel = nextProcessor.createMessageChannel(targetHostPort);
                } //End block
                catch (UnknownHostException ex)
                {
                    if(stackLogger.isLoggingEnabled())                    
                    stackLogger.logException(ex);
                    ex.addTaint(taint);
                    throw ex;
                } //End block
                catch (IOException e)
                {
                    if(stackLogger.isLoggingEnabled())                    
                    stackLogger.logException(e);
                } //End block
            } //End block
        } //End block
MessageChannel var820352DABCFAB75C56B22FD37914FC18_2105496308 =         newChannel;
        var820352DABCFAB75C56B22FD37914FC18_2105496308.addTaint(taint);
        return var820352DABCFAB75C56B22FD37914FC18_2105496308;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.484 -0400", hash_original_method = "35D04CBE96754834C212489B2C606D95", hash_generated_method = "A167EFD611FFF0A88284A886D4342667")
    public boolean isEventForked(String ename) {
        addTaint(ename.getTaint());
        if(stackLogger.isLoggingEnabled())        
        {
            stackLogger.logDebug("isEventForked: " + ename + " returning "
                    + this.forkedEvents.contains(ename));
        } //End block
        boolean varA2E596ED0172F5F00B9D65052C4306D5_363511252 = (this.forkedEvents.contains(ename));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2132296640 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2132296640;
        // ---------- Original Method ----------
        //if (stackLogger.isLoggingEnabled()) {
            //stackLogger.logDebug("isEventForked: " + ename + " returning "
                    //+ this.forkedEvents.contains(ename));
        //}
        //return this.forkedEvents.contains(ename);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.484 -0400", hash_original_method = "8980F34FD4722FAAB08CBB90B3E36CA2", hash_generated_method = "DA523A88B82DBEAA68A3ED956BC5F35F")
    public AddressResolver getAddressResolver() {
AddressResolver varA4A68DC6C07D6F26F8CF67350D88F0C0_2035737278 =         this.addressResolver;
        varA4A68DC6C07D6F26F8CF67350D88F0C0_2035737278.addTaint(taint);
        return varA4A68DC6C07D6F26F8CF67350D88F0C0_2035737278;
        // ---------- Original Method ----------
        //return this.addressResolver;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.484 -0400", hash_original_method = "3C1DAA52D018FB69E50FF9E6B399590F", hash_generated_method = "AB8878E125C4CAD1D1B4691B2D6499BB")
    public void setAddressResolver(AddressResolver addressResolver) {
        this.addressResolver = addressResolver;
        // ---------- Original Method ----------
        //this.addressResolver = addressResolver;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.484 -0400", hash_original_method = "906B74670BE04C4A719BBC503CD663E5", hash_generated_method = "1BD4BE3CB90C933E977E9F9E4FB6AE5F")
    public void setLogRecordFactory(LogRecordFactory logRecordFactory) {
        this.logRecordFactory = logRecordFactory;
        // ---------- Original Method ----------
        //this.logRecordFactory = logRecordFactory;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.486 -0400", hash_original_method = "2953BF87EC3C3B721F79C36C05ACD684", hash_generated_method = "30222FB89A02BEF6E39D0C920AF2E6A1")
    public ThreadAuditor getThreadAuditor() {
ThreadAuditor var7834F57257982978B2BC1F5E32B90FB6_179497342 =         this.threadAuditor;
        var7834F57257982978B2BC1F5E32B90FB6_179497342.addTaint(taint);
        return var7834F57257982978B2BC1F5E32B90FB6_179497342;
        // ---------- Original Method ----------
        //return this.threadAuditor;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.487 -0400", hash_original_method = "DA93EFB6297A5552E15BC0248101E996", hash_generated_method = "3DED50DF7F8BDB1C950C09CF65BDB70D")
    public String auditStack(Set activeCallIDs, long leakedDialogTimer,
            long leakedTransactionTimer) {
        addTaint(leakedTransactionTimer);
        addTaint(leakedDialogTimer);
        addTaint(activeCallIDs.getTaint());
        String auditReport = null;
        String leakedDialogs = auditDialogs(activeCallIDs, leakedDialogTimer);
        String leakedServerTransactions = auditTransactions(serverTransactionTable,
                leakedTransactionTimer);
        String leakedClientTransactions = auditTransactions(clientTransactionTable,
                leakedTransactionTimer);
        if(leakedDialogs != null || leakedServerTransactions != null
                || leakedClientTransactions != null)        
        {
            auditReport = "SIP Stack Audit:\n" + (leakedDialogs != null ? leakedDialogs : "")
                    + (leakedServerTransactions != null ? leakedServerTransactions : "")
                    + (leakedClientTransactions != null ? leakedClientTransactions : "");
        } //End block
String var45515A2592231F3BCF49C3DB63F02A4B_430547765 =         auditReport;
        var45515A2592231F3BCF49C3DB63F02A4B_430547765.addTaint(taint);
        return var45515A2592231F3BCF49C3DB63F02A4B_430547765;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.488 -0400", hash_original_method = "5A76CC0B1A3067E5B9DACF3EB61E431C", hash_generated_method = "0C6CA76E5407898693D4BDBA0510388E")
    private String auditDialogs(Set activeCallIDs, long leakedDialogTimer) {
        addTaint(leakedDialogTimer);
        addTaint(activeCallIDs.getTaint());
        String auditReport = "  Leaked dialogs:\n";
        int leakedDialogs = 0;
        long currentTime = System.currentTimeMillis();
        LinkedList dialogs;
        synchronized
(dialogTable)        {
            dialogs = new LinkedList(dialogTable.values());
        } //End block
        Iterator it = dialogs.iterator();
        while
(it.hasNext())        
        {
            SIPDialog itDialog = (SIPDialog) it.next();
            CallIdHeader callIdHeader = (itDialog != null ? itDialog.getCallId() : null);
            String callID = (callIdHeader != null ? callIdHeader.getCallId() : null);
            if(itDialog != null && callID != null && !activeCallIDs.contains(callID))            
            {
                if(itDialog.auditTag == 0)                
                {
                    itDialog.auditTag = currentTime;
                } //End block
                else
                {
                    if(currentTime - itDialog.auditTag >= leakedDialogTimer)                    
                    {
                        leakedDialogs++;
                        DialogState dialogState = itDialog.getState();
                        String dialogReport = "dialog id: " + itDialog.getDialogId()
                                + ", dialog state: "
                                + (dialogState != null ? dialogState.toString() : "null");
                        auditReport += "    " + dialogReport + "\n";
                        itDialog.setState(SIPDialog.TERMINATED_STATE);
                        if(stackLogger.isLoggingEnabled())                        
                        stackLogger.logDebug("auditDialogs: leaked " + dialogReport);
                    } //End block
                } //End block
            } //End block
        } //End block
        if(leakedDialogs > 0)        
        {
            auditReport += "    Total: " + Integer.toString(leakedDialogs)
                    + " leaked dialogs detected and removed.\n";
        } //End block
        else
        {
            auditReport = null;
        } //End block
String var45515A2592231F3BCF49C3DB63F02A4B_1444578192 =         auditReport;
        var45515A2592231F3BCF49C3DB63F02A4B_1444578192.addTaint(taint);
        return var45515A2592231F3BCF49C3DB63F02A4B_1444578192;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.490 -0400", hash_original_method = "B29AC2188DE994EDE68B3EFDD85B41F1", hash_generated_method = "B72C115F41F48694DAFDE293695B1AE9")
    private String auditTransactions(ConcurrentHashMap transactionsMap,
            long a_nLeakedTransactionTimer) {
        addTaint(a_nLeakedTransactionTimer);
        addTaint(transactionsMap.getTaint());
        String auditReport = "  Leaked transactions:\n";
        int leakedTransactions = 0;
        long currentTime = System.currentTimeMillis();
        LinkedList transactionsList = new LinkedList(transactionsMap.values());
        Iterator it = transactionsList.iterator();
        while
(it.hasNext())        
        {
            SIPTransaction sipTransaction = (SIPTransaction) it.next();
            if(sipTransaction != null)            
            {
                if(sipTransaction.auditTag == 0)                
                {
                    sipTransaction.auditTag = currentTime;
                } //End block
                else
                {
                    if(currentTime - sipTransaction.auditTag >= a_nLeakedTransactionTimer)                    
                    {
                        leakedTransactions++;
                        TransactionState transactionState = sipTransaction.getState();
                        SIPRequest origRequest = sipTransaction.getOriginalRequest();
                        String origRequestMethod = (origRequest != null ? origRequest.getMethod()
                                : null);
                        String transactionReport = sipTransaction.getClass().getName()
                                + ", state: "
                                + (transactionState != null ? transactionState.toString()
                                        : "null") + ", OR: "
                                + (origRequestMethod != null ? origRequestMethod : "null");
                        auditReport += "    " + transactionReport + "\n";
                        removeTransaction(sipTransaction);
                        if(isLoggingEnabled())                        
                        stackLogger.logDebug("auditTransactions: leaked " + transactionReport);
                    } //End block
                } //End block
            } //End block
        } //End block
        if(leakedTransactions > 0)        
        {
            auditReport += "    Total: " + Integer.toString(leakedTransactions)
                    + " leaked transactions detected and removed.\n";
        } //End block
        else
        {
            auditReport = null;
        } //End block
String var45515A2592231F3BCF49C3DB63F02A4B_625101491 =         auditReport;
        var45515A2592231F3BCF49C3DB63F02A4B_625101491.addTaint(taint);
        return var45515A2592231F3BCF49C3DB63F02A4B_625101491;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.490 -0400", hash_original_method = "216776ED7A95FC4D69FC6626B7475336", hash_generated_method = "E8608B8CC182F06B0236B85EC551D976")
    public void setNon2XXAckPassedToListener(boolean passToListener) {
        this.non2XXAckPassedToListener = passToListener;
        // ---------- Original Method ----------
        //this.non2XXAckPassedToListener = passToListener;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.491 -0400", hash_original_method = "6286CBBFF5CE6322EC732C5543B43EDA", hash_generated_method = "9417F86CEEEF7EFA91D601CFCCD1E19F")
    public boolean isNon2XXAckPassedToListener() {
        boolean varD2577D0EF3B7CF3C35702AD5E888A547_672762056 = (non2XXAckPassedToListener);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_816274516 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_816274516;
        // ---------- Original Method ----------
        //return non2XXAckPassedToListener;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.491 -0400", hash_original_method = "39908A44D12AF4672A8DE059DC86C6F0", hash_generated_method = "B1401065E93A6646C8953F17ED0A436E")
    public int getActiveClientTransactionCount() {
        int varA2525050DB20DC473F4A443A0825318C_1260633781 = (activeClientTransactionCount.get());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1036872919 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1036872919;
        // ---------- Original Method ----------
        //return activeClientTransactionCount.get();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.491 -0400", hash_original_method = "2D01936677D6715578D012ACFAF4D8A9", hash_generated_method = "DD6D5FD976AD104362F55576AB4531CB")
    public boolean isRfc2543Supported() {
        boolean var01C9FD53D37FBDD34CAE27990CE9CAF2_497337859 = (this.rfc2543Supported);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_75447110 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_75447110;
        // ---------- Original Method ----------
        //return this.rfc2543Supported;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.493 -0400", hash_original_method = "71493EE5805AD2AB9A60D51292B7773D", hash_generated_method = "A937C054EBC5E14DA68297630EC86516")
    public boolean isCancelClientTransactionChecked() {
        boolean varB5C3631D8A6B38E9B6E0EBE6778FF668_895015031 = (this.cancelClientTransactionChecked);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1941251977 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1941251977;
        // ---------- Original Method ----------
        //return this.cancelClientTransactionChecked;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.494 -0400", hash_original_method = "45004C11584D234E2C0351030C5C7691", hash_generated_method = "00C2C529A5131712EC1E6267FF6537D6")
    public boolean isRemoteTagReassignmentAllowed() {
        boolean var199DD0FF3A8C2F69594A84D9A64AC6AF_753402063 = (this.remoteTagReassignmentAllowed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2021036887 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2021036887;
        // ---------- Original Method ----------
        //return this.remoteTagReassignmentAllowed;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.494 -0400", hash_original_method = "20ADA27D372C754940A803F19F3E7AD9", hash_generated_method = "C7FC1930E5ABBD06B8A4583EED3E63AB")
    public Collection<Dialog> getDialogs() {
        HashSet<Dialog> dialogs = new HashSet<Dialog>();
        dialogs.addAll(this.dialogTable.values());
        dialogs.addAll(this.earlyDialogTable.values());
Collection<Dialog> var75E2EB1ACA2BA9CC3EF411FB121A2F28_1267016096 =         dialogs;
        var75E2EB1ACA2BA9CC3EF411FB121A2F28_1267016096.addTaint(taint);
        return var75E2EB1ACA2BA9CC3EF411FB121A2F28_1267016096;
        // ---------- Original Method ----------
        //HashSet<Dialog> dialogs = new HashSet<Dialog>();
        //dialogs.addAll(this.dialogTable.values());
        //dialogs.addAll(this.earlyDialogTable.values());
        //return dialogs;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.494 -0400", hash_original_method = "9851D171868856682CD66D2C2C77C100", hash_generated_method = "53CC94DCFB611C043C5FB92AB35AA1C8")
    public Collection<Dialog> getDialogs(DialogState state) {
        addTaint(state.getTaint());
        HashSet<Dialog> matchingDialogs = new HashSet<Dialog>();
        if(DialogState.EARLY.equals(state))        
        {
            matchingDialogs.addAll(this.earlyDialogTable.values());
        } //End block
        else
        {
            Collection<SIPDialog> dialogs = dialogTable.values();
for(SIPDialog dialog : dialogs)
            {
                if(dialog.getState() != null && dialog.getState().equals(state))                
                {
                    matchingDialogs.add(dialog);
                } //End block
            } //End block
        } //End block
Collection<Dialog> var67C0D28BBB6854530CDA9DEF3C7BFC06_27175439 =         matchingDialogs;
        var67C0D28BBB6854530CDA9DEF3C7BFC06_27175439.addTaint(taint);
        return var67C0D28BBB6854530CDA9DEF3C7BFC06_27175439;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.495 -0400", hash_original_method = "B020A334EC30ACCE61108F29E8239DE0", hash_generated_method = "B38E1B80EC4F864762D20F9F0D0D9DF2")
    public Dialog getReplacesDialog(ReplacesHeader replacesHeader) {
        addTaint(replacesHeader.getTaint());
        String cid = replacesHeader.getCallId();
        String fromTag = replacesHeader.getFromTag();
        String toTag = replacesHeader.getToTag();
        StringBuffer dialogId = new StringBuffer(cid);
        if(toTag != null)        
        {
            dialogId.append(":");
            dialogId.append(toTag);
        } //End block
        if(fromTag != null)        
        {
            dialogId.append(":");
            dialogId.append(fromTag);
        } //End block
        String did = dialogId.toString().toLowerCase();
        if(stackLogger.isLoggingEnabled())        
        stackLogger.logDebug("Looking for dialog " + did);
        Dialog replacesDialog = this.dialogTable.get(did);
        if(replacesDialog == null)        
        {
for(SIPClientTransaction ctx : this.clientTransactionTable.values())
            {
                if(ctx.getDialog(did) != null)                
                {
                    replacesDialog = ctx.getDialog(did);
                    break;
                } //End block
            } //End block
        } //End block
Dialog var2CC999B4D6AA9194E5C0A0B958A8CE93_646217633 =         replacesDialog;
        var2CC999B4D6AA9194E5C0A0B958A8CE93_646217633.addTaint(taint);
        return var2CC999B4D6AA9194E5C0A0B958A8CE93_646217633;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.495 -0400", hash_original_method = "01BB795BEB07C4ED2A3CDD99078DB107", hash_generated_method = "17209A6FB564D8AE1C696583E91B960E")
    public Dialog getJoinDialog(JoinHeader joinHeader) {
        addTaint(joinHeader.getTaint());
        String cid = joinHeader.getCallId();
        String fromTag = joinHeader.getFromTag();
        String toTag = joinHeader.getToTag();
        StringBuffer retval = new StringBuffer(cid);
        if(toTag != null)        
        {
            retval.append(":");
            retval.append(toTag);
        } //End block
        if(fromTag != null)        
        {
            retval.append(":");
            retval.append(fromTag);
        } //End block
Dialog var30F2B8117653FB951289E6538FA91E24_1806011305 =         this.dialogTable.get(retval.toString().toLowerCase());
        var30F2B8117653FB951289E6538FA91E24_1806011305.addTaint(taint);
        return var30F2B8117653FB951289E6538FA91E24_1806011305;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.498 -0400", hash_original_method = "69B105104758CF3A0416D8C1D4F4DE0D", hash_generated_method = "7B24205D066AECCFC783C5A7FE5B727D")
    public void setTimer(Timer timer) {
        this.timer = timer;
        // ---------- Original Method ----------
        //this.timer = timer;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.498 -0400", hash_original_method = "8E3D165A90C48C9C43C8115575D5D434", hash_generated_method = "096047971038B3E7411147058417EF17")
    public Timer getTimer() {
Timer var2B2C52ADC3F3CD1F817B9299F27438D1_123375191 =         timer;
        var2B2C52ADC3F3CD1F817B9299F27438D1_123375191.addTaint(taint);
        return var2B2C52ADC3F3CD1F817B9299F27438D1_123375191;
        // ---------- Original Method ----------
        //return timer;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.498 -0400", hash_original_method = "535D845393F6631B713A5EAFAC15730B", hash_generated_method = "89EC606BE85DF16D8D5FF380A01F78C5")
    public int getReceiveUdpBufferSize() {
        int varF4917C86121EC97DE5D24BA1E8E3468F_1966345876 = (receiveUdpBufferSize);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1896400997 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1896400997;
        // ---------- Original Method ----------
        //return receiveUdpBufferSize;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.498 -0400", hash_original_method = "AD9781079D581597B87998F87481A2EF", hash_generated_method = "3CB289800444473A5EA7A106AC8D0F2E")
    public void setReceiveUdpBufferSize(int receiveUdpBufferSize) {
        this.receiveUdpBufferSize = receiveUdpBufferSize;
        // ---------- Original Method ----------
        //this.receiveUdpBufferSize = receiveUdpBufferSize;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.498 -0400", hash_original_method = "7F1E49D75F179129A028D4152C30D3F6", hash_generated_method = "892E27AAA304BB2DAD21A61B3F83C4F2")
    public int getSendUdpBufferSize() {
        int var85144B78F884888A47BFB96276FBAB05_2125131032 = (sendUdpBufferSize);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_599003485 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_599003485;
        // ---------- Original Method ----------
        //return sendUdpBufferSize;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.499 -0400", hash_original_method = "085E2E0AF6AC7C34DFF993E649718D81", hash_generated_method = "5FF890F4499E7F2DC05E16AEF2E489BA")
    public void setSendUdpBufferSize(int sendUdpBufferSize) {
        this.sendUdpBufferSize = sendUdpBufferSize;
        // ---------- Original Method ----------
        //this.sendUdpBufferSize = sendUdpBufferSize;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.500 -0400", hash_original_method = "3649FCA00F1F012AB31400D887FE5668", hash_generated_method = "25F9CE48BE3D8A2B81401FE81559ECB5")
    public void setStackLogger(StackLogger stackLogger) {
        this.stackLogger = stackLogger;
        // ---------- Original Method ----------
        //this.stackLogger = stackLogger;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.500 -0400", hash_original_method = "3A00FD245E091565EAC4D2A0BF135C63", hash_generated_method = "B9B8B67475333F5BF1FB840EAB77A24A")
    public boolean checkBranchId() {
        boolean var78293BCEA43BA23ED4DF4DF1BB83953D_527137537 = (this.checkBranchId);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1543942023 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1543942023;
        // ---------- Original Method ----------
        //return this.checkBranchId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.500 -0400", hash_original_method = "4B576FDEB92FCE56B4004D51F27F133D", hash_generated_method = "9045EE09E5612A4BCB84191DDFF57B6F")
    public void setLogStackTraceOnMessageSend(boolean logStackTraceOnMessageSend) {
        this.logStackTraceOnMessageSend = logStackTraceOnMessageSend;
        // ---------- Original Method ----------
        //this.logStackTraceOnMessageSend = logStackTraceOnMessageSend;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.500 -0400", hash_original_method = "6EA33CFFB30E0EA85B4B3B5316E0B073", hash_generated_method = "B545A2F58564635341B602B8A22BF020")
    public boolean isLogStackTraceOnMessageSend() {
        boolean varA6E662C72D0164A3CA0C00F7E3400CCF_1830115141 = (logStackTraceOnMessageSend);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2019562721 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2019562721;
        // ---------- Original Method ----------
        //return logStackTraceOnMessageSend;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.500 -0400", hash_original_method = "BBC3144A1CF9CB1C9F37A775F293720F", hash_generated_method = "1AB264FBAA3C1AD042F7B5A0A41EB0AF")
    public void setDeliverDialogTerminatedEventForNullDialog() {
        this.isDialogTerminatedEventDeliveredForNullDialog = true;
        // ---------- Original Method ----------
        //this.isDialogTerminatedEventDeliveredForNullDialog = true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.500 -0400", hash_original_method = "C791CC7BC6998146618C651EB49E3406", hash_generated_method = "8C2EF9597FA795BB8CD73DF4831EE1DF")
    public void addForkedClientTransaction(SIPClientTransaction clientTransaction) {
        addTaint(clientTransaction.getTaint());
        this.forkedClientTransactionTable.put(clientTransaction.getTransactionId(), clientTransaction );
        // ---------- Original Method ----------
        //this.forkedClientTransactionTable.put(clientTransaction.getTransactionId(), clientTransaction );
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.502 -0400", hash_original_method = "A07C61DB9453AEA0A84C4416E8A5508E", hash_generated_method = "73BCBBF3FB8F842C2127ABE7888AE05B")
    public SIPClientTransaction getForkedTransaction(String transactionId) {
        addTaint(transactionId.getTaint());
SIPClientTransaction var631DB370CC7F7F1595271E10802FCFDA_683975953 =         this.forkedClientTransactionTable.get(transactionId);
        var631DB370CC7F7F1595271E10802FCFDA_683975953.addTaint(taint);
        return var631DB370CC7F7F1595271E10802FCFDA_683975953;
        // ---------- Original Method ----------
        //return this.forkedClientTransactionTable.get(transactionId);
    }

    
    class PingTimer extends SIPStackTimerTask {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.502 -0400", hash_original_field = "BA4484AC61EF7F39E156EE38D51DF221", hash_generated_field = "3AE84B2399BFC1B1844D24A06D20C249")

        ThreadAuditor.ThreadHandle threadHandle;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.502 -0400", hash_original_method = "BD8473F7A826DDA501F390A58BAECB33", hash_generated_method = "AFD1D6DF671C7BCECC8041EEE49A6EBB")
        public  PingTimer(ThreadAuditor.ThreadHandle a_oThreadHandle) {
            threadHandle = a_oThreadHandle;
            // ---------- Original Method ----------
            //threadHandle = a_oThreadHandle;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.502 -0400", hash_original_method = "D20FBACDA77D9F2BECED97C9063F3E91", hash_generated_method = "B04E448836563B9B68A398B06D3ACFC8")
        protected void runTask() {
            if(getTimer() != null)            
            {
                if(threadHandle == null)                
                {
                    threadHandle = getThreadAuditor().addCurrentThread();
                } //End block
                threadHandle.ping();
                getTimer().schedule(new PingTimer(threadHandle),
                        threadHandle.getPingIntervalInMillisecs());
            } //End block
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.502 -0400", hash_original_field = "7767C1945F1820BD26BE8F6047172E57", hash_generated_field = "346E85BD6DDF8042B729A2408B44CDD3")

        private SIPClientTransaction clientTransaction;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.502 -0400", hash_original_method = "D0A941D96C1666EFE3BE3721976F6AA6", hash_generated_method = "ABA505C7494D21E7D5CE259EA437DF15")
        public  RemoveForkedTransactionTimerTask(SIPClientTransaction sipClientTransaction ) {
            this.clientTransaction = sipClientTransaction;
            // ---------- Original Method ----------
            //this.clientTransaction = sipClientTransaction;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.502 -0400", hash_original_method = "0A8A5E2C1505E2C2E84219D84E5444CF", hash_generated_method = "74E9473D704F21F1BB34BAE5007DACEC")
        @Override
        protected void runTask() {
            forkedClientTransactionTable.remove(clientTransaction.getTransactionId());
            // ---------- Original Method ----------
            //forkedClientTransactionTable.remove(clientTransaction.getTransactionId());
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.502 -0400", hash_original_field = "1270E8F52DAEA78D6688D9140DFF4221", hash_generated_field = "840B97A8669F66449D46242BA5765A0F")

    public static final int BASE_TIMER_INTERVAL = 500;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.502 -0400", hash_original_field = "9848A0B88D1FABCA8FBA5AB7FD5622BD", hash_generated_field = "F814FEC2CA6FC54407356E1DCD115382")

    public static final int CONNECTION_LINGER_TIME = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:42.502 -0400", hash_original_field = "19274966A28B7A0696AC55588DA87355", hash_generated_field = "2D1D1AE6B824DAFBEC80F6EDE67E49B0")

    protected static final Set<String> dialogCreatingMethods = new HashSet<String>();
    static {
    	dialogCreatingMethods.add(Request.REFER);
        dialogCreatingMethods.add(Request.INVITE);
        dialogCreatingMethods.add(Request.SUBSCRIBE);
    }
    
}

