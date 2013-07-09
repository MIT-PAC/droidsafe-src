package gov.nist.javax.sip.stack;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.509 -0400", hash_original_field = "BB024B2AD3D00DEB98AA88DE95E2AC00", hash_generated_field = "4492ED7A506BF07B68742FB955C2E21E")

    protected ConcurrentHashMap<String, SIPServerTransaction> retransmissionAlertTransactions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.509 -0400", hash_original_field = "986AB2740C1F225B7EDFB5003F826DDF", hash_generated_field = "6B3C62483E89DF024C432E8562DE8605")

    protected ConcurrentHashMap<String, SIPDialog> earlyDialogTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.509 -0400", hash_original_field = "02ACB7AB69D88BAD640992A93D36CD3D", hash_generated_field = "612ED1FD1C10487B0104807B8A4F66C6")

    protected ConcurrentHashMap<String, SIPDialog> dialogTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.509 -0400", hash_original_field = "2C127BF32CCB4EDF2BF22FEA5A00E494", hash_generated_field = "02D2240A23798B540E9F3183DC11EA33")

    private Timer timer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.509 -0400", hash_original_field = "08EADE4A5AD4F48C9A3F1591D2EA1815", hash_generated_field = "32E72097D41FA2F9AA2F04A4F6D94614")

    private ConcurrentHashMap<String, SIPServerTransaction> pendingTransactions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.509 -0400", hash_original_field = "135A93B3EA7CAFC3F8629197D3B561E2", hash_generated_field = "1A605FBA2863EF25462941960BB549FD")

    private ConcurrentHashMap<String, SIPClientTransaction> clientTransactionTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.509 -0400", hash_original_field = "49B61D40D424177779367ABF96FA4884", hash_generated_field = "1F786F43A2E25D3141E2216B91F6EAFE")

    protected boolean unlimitedServerTransactionTableSize = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.509 -0400", hash_original_field = "1DF7958BDE28724C5596C6BFB0E1CCB0", hash_generated_field = "DD907A7A90AC49DD39A1CAABAC88BD51")

    protected boolean unlimitedClientTransactionTableSize = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.509 -0400", hash_original_field = "076578F2E484D4FEC2562AB10277F3D5", hash_generated_field = "F4F362BB5E335440B1EB8C2B8EEC1317")

    protected int serverTransactionTableHighwaterMark = 5000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.509 -0400", hash_original_field = "7B15FFD05552BF4F9F4CD19D72A0ECFD", hash_generated_field = "5C015B93DBBC4C9D6908F3FC81146158")

    protected int serverTransactionTableLowaterMark = 4000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.509 -0400", hash_original_field = "D3F7C88BB14A5ED2F6A20C6BEBEAFDF3", hash_generated_field = "E9B62880A44C081DDF0FEB2884673E38")

    protected int clientTransactionTableHiwaterMark = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.510 -0400", hash_original_field = "06EFD544FD136F3B0F129C5103D56B95", hash_generated_field = "5D70C98F837CF3F9C68DD58DFD91E463")

    protected int clientTransactionTableLowaterMark = 800;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.510 -0400", hash_original_field = "86AE3FC892B739DBA734E71838BA8EAB", hash_generated_field = "EF538D5EF9F88F93E351A9F5CBDE10BE")

    private AtomicInteger activeClientTransactionCount = new AtomicInteger(0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.510 -0400", hash_original_field = "9EA55D2B918C0F38F9A9DFBE46C9E48E", hash_generated_field = "17FBAB4D0971040901BD780F89591315")

    private ConcurrentHashMap<String, SIPServerTransaction> serverTransactionTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.510 -0400", hash_original_field = "EE1591222A018ABE5572A5C6C0A797E9", hash_generated_field = "F435FECE20B5CE387F33C17D84BA6487")

    private ConcurrentHashMap<String, SIPServerTransaction> mergeTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.510 -0400", hash_original_field = "C755FCEA66E8CB835ECA7BD27067C11E", hash_generated_field = "811B28F45DE9105A274B1DBADE0F6CC9")

    private ConcurrentHashMap<String,SIPServerTransaction> terminatedServerTransactionsPendingAck;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.510 -0400", hash_original_field = "517069402F23F2FF9ABD60CF4C61CBE6", hash_generated_field = "71F6115AE3CDEA5C8D231C9BD5ACFE37")

    private ConcurrentHashMap<String,SIPClientTransaction> forkedClientTransactionTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.510 -0400", hash_original_field = "E36C03BD76A3345DFD7C16B0A9186E53", hash_generated_field = "1D505020FB0AD1A554D62BDC6FA8297B")

    private StackLogger stackLogger;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.510 -0400", hash_original_field = "B90EC493A5834DC9E5B17148F47193CB", hash_generated_field = "5C234A980E10BCEA9B12BAB676094BC2")

    protected ServerLogger serverLogger;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.510 -0400", hash_original_field = "2B177EBBF6652A06414D14C8C50E3B12", hash_generated_field = "1E6D363EB172CF0996091AF3F1ED1415")

    boolean udpFlag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.510 -0400", hash_original_field = "BA389B46C420BB5A0FA673A143939AC1", hash_generated_field = "EF7A4245F4BE46C3FAE858ABF7DB8188")

    protected DefaultRouter defaultRouter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.510 -0400", hash_original_field = "D77703414D2B9CECCE906E75B64E89D7", hash_generated_field = "C4FB0B708AF2FF7CDFB610A006B5BB00")

    protected boolean needsLogging;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.510 -0400", hash_original_field = "D2577D0EF3B7CF3C35702AD5E888A547", hash_generated_field = "39AC5AA3A559BB385B76BB7FCEA06FC5")

    private boolean non2XXAckPassedToListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.510 -0400", hash_original_field = "672BD3EDBEBEC18E145C8AFB0B9BDF65", hash_generated_field = "33EBA2CEF834B663ED5264FE81682D84")

    protected IOHandler ioHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.510 -0400", hash_original_field = "CD991461F11FD761BF6EFA12FCC1C1C3", hash_generated_field = "F86372B43141F18E4A8130BDC70E29CE")

    protected boolean toExit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.510 -0400", hash_original_field = "EDEF96A12B8786AA598020FE493D9164", hash_generated_field = "D4D760F2DD059CF6C01F0C862657BA20")

    protected String stackName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.510 -0400", hash_original_field = "7226454496215DAA32BEDA538263F57C", hash_generated_field = "A47D9D5247AAB165B1980C5D8E37AD58")

    protected String stackAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.510 -0400", hash_original_field = "DF199E0AE132DFDCEDCCCEAA54175F9C", hash_generated_field = "413081F93DE42EB68D8F08C864982E20")

    protected InetAddress stackInetAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.510 -0400", hash_original_field = "D189B5282758DEAD6599821789339DB3", hash_generated_field = "272D1016DEB62E744C52940A3B0E5489")

    protected StackMessageFactory sipMessageFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.510 -0400", hash_original_field = "F3395CD54CF857DDF8F2056768FF49AE", hash_generated_field = "66410D3E71DA473D001977FF3AD7B23B")

    protected javax.sip.address.Router router;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.510 -0400", hash_original_field = "CDE1F9B6C35FC856E715F186A9E26998", hash_generated_field = "C7EB24484DBA63450BB85C2FA7FA489F")

    protected int threadPoolSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.510 -0400", hash_original_field = "1ACBA9188A93F77D3F78F321F92C1912", hash_generated_field = "F74AE6C7EF47828D3A211878D3F5E9F3")

    protected int maxConnections;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.510 -0400", hash_original_field = "340B2E73CA68D1340F1704849DB20F30", hash_generated_field = "3130D9CC177F737BBD6633DB37EE5BF1")

    protected boolean cacheServerConnections;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.510 -0400", hash_original_field = "75061F79A5A3418387A8EAF6F6FAC2F2", hash_generated_field = "768D8EDFC9A10AC079EBDEBB9B0BEA2F")

    protected boolean cacheClientConnections;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.510 -0400", hash_original_field = "7024729D82FD3921C13E8300B02C1CC8", hash_generated_field = "F13115153A6685630697524CF8732D13")

    protected boolean useRouterForAll;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.510 -0400", hash_original_field = "D54EA500688687E7A49846CC9E44F277", hash_generated_field = "DDA86EBC27B96B0FE9D286E6B5C99D02")

    protected int maxContentLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.510 -0400", hash_original_field = "BF1B271FFDC69F10249067CA74EC9584", hash_generated_field = "224FB7FE4F1198F8C1E840FE28932770")

    protected int maxMessageSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.510 -0400", hash_original_field = "074A77F279327ACEE64E9D4AEEC12D99", hash_generated_field = "185A572D15C5BAB5F976AA3554E06D13")

    private Collection<MessageProcessor> messageProcessors;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.510 -0400", hash_original_field = "8FC05721DCBB3B49F66A6D283A300B5B", hash_generated_field = "29792280DB9C85168DEBC57540E5C62A")

    protected int readTimeout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.510 -0400", hash_original_field = "24D13633EB52AF9F8D6DCB3C2ED2C648", hash_generated_field = "F280B3067DE1A528C7BB767557FE00A0")

    protected NetworkLayer networkLayer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.510 -0400", hash_original_field = "96F152D1B09078C3F6C4389AB2CD6114", hash_generated_field = "2DDBEDAE711DD575D314D6FB0824162C")

    protected String outboundProxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.510 -0400", hash_original_field = "9AEE50191BBED6B0890F8E94A389A3CE", hash_generated_field = "E23BB81A391AC77E4B947A6531D7CFF7")

    protected String routerPath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.510 -0400", hash_original_field = "408464B03DDE981FC6F053CF4CA21C22", hash_generated_field = "CBEE3D1CA29ED6AAA4A0BE3A2A3FF707")

    protected boolean isAutomaticDialogSupportEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.510 -0400", hash_original_field = "36969DE269F86EBA5C778849E2D77D36", hash_generated_field = "758951DC734FED546F5FA46D0CD9E244")

    protected HashSet<String> forkedEvents;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.510 -0400", hash_original_field = "30EE0A2AF6038C82623E548CD9ED9924", hash_generated_field = "E3C6781710F35866C48FB724B6E9B0A5")

    protected boolean generateTimeStampHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.510 -0400", hash_original_field = "20CC1F9AF77D0249618487065E0355D3", hash_generated_field = "921A218F1E68F36119322B4C0375D302")

    protected AddressResolver addressResolver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.510 -0400", hash_original_field = "9A4F347B2CDD7A88BC034DE7DE1C49B1", hash_generated_field = "7A3B05571C3C337451929576D2F6F7FC")

    protected int maxListenerResponseTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.510 -0400", hash_original_field = "8CF5659616CF24E603869D9967FC496D", hash_generated_field = "A8CD57032071313BD3D43EAEB0E5D46D")

    protected boolean rfc2543Supported = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.510 -0400", hash_original_field = "06FFC9DFE8BC8EFDE045BBFE8B51D74A", hash_generated_field = "DE990737863BADB7C6E95ED63CC9DC4C")

    protected ThreadAuditor threadAuditor = new ThreadAuditor();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.510 -0400", hash_original_field = "18CF450DF0054CF7D904E6AED9045E84", hash_generated_field = "F94964197FE0E44E12A6BA7E03E51754")

    protected LogRecordFactory logRecordFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.510 -0400", hash_original_field = "597E9AB37EABE3191749A9B8F3F983E9", hash_generated_field = "3713718BCCF6B9DFEBB0EE5CDD91B58B")

    protected boolean cancelClientTransactionChecked = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.510 -0400", hash_original_field = "212D53B82E21ED6882AABA1631FD2487", hash_generated_field = "BCB26F591F1846D975D03FEA861FFBFA")

    protected boolean remoteTagReassignmentAllowed = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.510 -0400", hash_original_field = "8A1ACCA44ACB9074E8500DD26D17C77F", hash_generated_field = "046122FB4660CF86569D7745FB6062FC")

    protected boolean logStackTraceOnMessageSend = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.510 -0400", hash_original_field = "F4917C86121EC97DE5D24BA1E8E3468F", hash_generated_field = "533CF057F33E79CEE3F6C6762D967990")

    protected int receiveUdpBufferSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.510 -0400", hash_original_field = "85144B78F884888A47BFB96276FBAB05", hash_generated_field = "9F0A96DC46E2BE3FA6703B7ECEFC7E7B")

    protected int sendUdpBufferSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.510 -0400", hash_original_field = "7A750FD6F18F1DDA4E38B3D4B5023EE1", hash_generated_field = "D2F44B156E2C7DA4668C7D5F665DAB5F")

    protected boolean stackDoesCongestionControl = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.510 -0400", hash_original_field = "FCC7FD133DB713B98A4D2C108DE01B90", hash_generated_field = "C468B3795A40E24BFA5E22186F8BD92C")

    protected boolean isBackToBackUserAgent = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.510 -0400", hash_original_field = "C6F8194A1D5AF33E9A729F0C8D674D41", hash_generated_field = "30B91514890DCCCE1053BFD830B93F8D")

    protected boolean checkBranchId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.510 -0400", hash_original_field = "DFB941AD6D02702CD41F36C2DCE642A9", hash_generated_field = "2CEA2AC21B7A7C73026A335F4F3A56EB")

    protected boolean isAutomaticDialogErrorHandlingEnabled = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.510 -0400", hash_original_field = "92DDCC06D1B886C4810373F4B5BD040A", hash_generated_field = "8D5939440DC97D0AD4D778E8F452B5A4")

    protected boolean isDialogTerminatedEventDeliveredForNullDialog = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.510 -0400", hash_original_field = "762E796CA8120FD35AC69FAC3C50EC48", hash_generated_field = "67828BA276FD46633F0EC0FF51519F0E")

    protected int maxForkTime = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.512 -0400", hash_original_method = "58A99E16B05D3536C850145BF176F1CB", hash_generated_method = "D8BC20E46E1D7175868C5D9FFEA0D1D2")
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
            boolean var4926B8FB396A99BDD38AA02CC358790B_957213971 = (getThreadAuditor().isEnabled());
            {
                timer.schedule(new PingTimer(null), 0);
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.512 -0400", hash_original_method = "A949ED7F371D2CEC2724714D98F74A81", hash_generated_method = "766B055A4B71BEB66FBCFDFD4443B1FF")
    protected  SIPTransactionStack(StackMessageFactory messageFactory) {
        this();
        this.sipMessageFactory = messageFactory;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.513 -0400", hash_original_method = "4C95AA981C09EEAD5B31E73DC1384B23", hash_generated_method = "9732942F1AE22D2ECA4FA8E124919BA9")
    protected void reInit() {
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_105633972 = (stackLogger.isLoggingEnabled());
            stackLogger.logDebug("Re-initializing !");
        } 
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
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.513 -0400", hash_original_method = "5E8E9B567A338F9125BE752CD1B53E0E", hash_generated_method = "AEA4EB2408FC910FB8CCEB8D54B373FE")
    public SocketAddress obtainLocalAddress(InetAddress dst, int dstPort,
                    InetAddress localAddress, int localPort) throws IOException {
        SocketAddress varB4EAC82CA7396A68D541C85D26508E83_456805466 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_456805466 = this.ioHandler.obtainLocalAddress(
                        dst, dstPort, localAddress, localPort);
        addTaint(dst.getTaint());
        addTaint(dstPort);
        addTaint(localAddress.getTaint());
        addTaint(localPort);
        varB4EAC82CA7396A68D541C85D26508E83_456805466.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_456805466;
        
        
                        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.514 -0400", hash_original_method = "6F4F1101C93AB1BC6C07B08D53A20694", hash_generated_method = "5AECE98B1061B15974070DD2B205769A")
    public void disableLogging() {
        this.getStackLogger().disableLogging();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.514 -0400", hash_original_method = "28B9C3C3AF577CC75DD224D050447CF4", hash_generated_method = "DD4A6695D325CC79611C0DADF7845085")
    public void enableLogging() {
        this.getStackLogger().enableLogging();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.515 -0400", hash_original_method = "F0A4CF0EC627D6BB4B7444677CFA585E", hash_generated_method = "89E91D6A436ABE91F0F2F8DC4457D9AB")
    public void printDialogTable() {
        {
            boolean var53869E3A88D96F4415B2EAEAC904AA86_246106555 = (isLoggingEnabled());
            {
                this.getStackLogger().logDebug("dialog table  = " + this.dialogTable);
                System.out.println("dialog table = " + this.dialogTable);
            } 
        } 
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.515 -0400", hash_original_method = "A39FC22DA230CCE4243CA37C766915B4", hash_generated_method = "21746C55E745239AF0333C0193A07256")
    public SIPServerTransaction getRetransmissionAlertTransaction(String dialogId) {
        SIPServerTransaction varB4EAC82CA7396A68D541C85D26508E83_1969246843 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1969246843 = (SIPServerTransaction) this.retransmissionAlertTransactions.get(dialogId);
        addTaint(dialogId.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1969246843.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1969246843;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isDialogCreated(String method) {
        return dialogCreatingMethods.contains(method);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.516 -0400", hash_original_method = "BEE1BC405D1C6F3176E5E5958D511DC6", hash_generated_method = "9C3DE16CBA913947ACC75DB5C1323A3A")
    public void addExtensionMethod(String extensionMethod) {
        {
            boolean varAD3BC2900BC07B79F07970DF4CB3E3F0_1244412359 = (extensionMethod.equals(Request.NOTIFY));
            {
                {
                    boolean varAC370D5D69DCACC466AEF155D6729732_523376615 = (stackLogger.isLoggingEnabled());
                    stackLogger.logDebug("NOTIFY Supported Natively");
                } 
            } 
            {
                dialogCreatingMethods.add(extensionMethod.trim().toUpperCase());
            } 
        } 
        addTaint(extensionMethod.getTaint());
        
        
            
                
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.516 -0400", hash_original_method = "3AD47119D9E3B66FC61FF1D5407F3E89", hash_generated_method = "21487B1A2389EE1FACB94583D40DEA01")
    public void putDialog(SIPDialog dialog) {
        String dialogId = dialog.getDialogId();
        {
            boolean var1C796C75795040E4DB7CADAEB51198DB_748367378 = (dialogTable.containsKey(dialogId));
            {
                {
                    boolean varAC370D5D69DCACC466AEF155D6729732_1537744347 = (stackLogger.isLoggingEnabled());
                    {
                        stackLogger.logDebug("putDialog: dialog already exists" + dialogId + " in table = "
                        + dialogTable.get(dialogId));
                    } 
                } 
            } 
        } 
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_1829042846 = (stackLogger.isLoggingEnabled());
            {
                stackLogger.logDebug("putDialog dialogId=" + dialogId + " dialog = " + dialog);
            } 
        } 
        dialog.setStack(this);
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_1948480242 = (stackLogger.isLoggingEnabled());
            stackLogger.logStackTrace();
        } 
        dialogTable.put(dialogId, dialog);
        addTaint(dialog.getTaint());
        
        
        
            
                
                        
            
            
        
        
            
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.517 -0400", hash_original_method = "E7A6CF8B50F165B49D6E8637D9CBF9BD", hash_generated_method = "D2ED58A9C3AA281B670AB5B82E5A6F6E")
    public SIPDialog createDialog(SIPTransaction transaction) {
        SIPDialog varB4EAC82CA7396A68D541C85D26508E83_1781801124 = null; 
        SIPDialog retval = null;
        {
            String dialogId = ((SIPRequest) transaction.getRequest()).getDialogId(false);
            {
                boolean var9131AA4695C2C63B631C355FB2D06559_456916329 = (this.earlyDialogTable.get(dialogId) != null);
                {
                    SIPDialog dialog = this.earlyDialogTable.get(dialogId);
                    {
                        boolean var402523BFFAD41D51F96075592CB2DE30_1554562292 = (dialog.getState() == null || dialog.getState() == DialogState.EARLY);
                        {
                            retval = dialog;
                        } 
                        {
                            retval = new SIPDialog(transaction);
                            this.earlyDialogTable.put(dialogId, retval);
                        } 
                    } 
                } 
                {
                    retval = new SIPDialog(transaction);
                    this.earlyDialogTable.put(dialogId, retval);
                } 
            } 
        } 
        {
            retval = new SIPDialog(transaction);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1781801124 = retval;
        addTaint(transaction.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1781801124.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1781801124;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.518 -0400", hash_original_method = "077BDE7287D2ACDD7F2A84D6156CB0F7", hash_generated_method = "79CD9727EC824A2EA59CEE1DD4C86C7E")
    public SIPDialog createDialog(SIPClientTransaction transaction, SIPResponse sipResponse) {
        SIPDialog varB4EAC82CA7396A68D541C85D26508E83_1653606271 = null; 
        String dialogId = ((SIPRequest) transaction.getRequest()).getDialogId(false);
        SIPDialog retval = null;
        {
            boolean var4AD019C6981F78972549CB283CBD152C_1428865664 = (this.earlyDialogTable.get(dialogId) != null);
            {
                retval = this.earlyDialogTable.get(dialogId);
                {
                    boolean varE9352942E72C1D75CE5290CFFD4E7B6C_1343382158 = (sipResponse.isFinalResponse());
                    {
                        this.earlyDialogTable.remove(dialogId);
                    } 
                } 
            } 
            {
                retval = new SIPDialog(transaction, sipResponse);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1653606271 = retval;
        addTaint(transaction.getTaint());
        addTaint(sipResponse.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1653606271.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1653606271;
        
        
        
        
            
            
                
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.519 -0400", hash_original_method = "C8019EE35E2246E727D64B4FEC692BA7", hash_generated_method = "ED306A449DA903E94F4041C7CB3911E9")
    public SIPDialog createDialog(SipProviderImpl sipProvider,
			SIPResponse sipResponse) {
        SIPDialog varB4EAC82CA7396A68D541C85D26508E83_608694940 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_608694940 = new SIPDialog(sipProvider, sipResponse);
        addTaint(sipProvider.getTaint());
        addTaint(sipResponse.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_608694940.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_608694940;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.519 -0400", hash_original_method = "C20BEEC896962D7D1856EB72C0C34791", hash_generated_method = "2ECFC315F3EF89D0ABCADB9CF1DA1B70")
    public void removeDialog(SIPDialog dialog) {
        String id = dialog.getDialogId();
        String earlyId = dialog.getEarlyDialogId();
        {
            this.earlyDialogTable.remove(earlyId);
            this.dialogTable.remove(earlyId);
        } 
        {
            Object old = this.dialogTable.get(id);
            {
                this.dialogTable.remove(id);
            } 
            {
                boolean var35096A2446A1B79EB944A5339DDF5D2F_1585136990 = (!dialog.testAndSetIsDialogTerminatedEventDelivered());
                {
                    DialogTerminatedEvent event = new DialogTerminatedEvent(dialog.getSipProvider(),
                        dialog);
                    dialog.getSipProvider().handleEvent(event, null);
                } 
            } 
        } 
        {
            {
                boolean var35096A2446A1B79EB944A5339DDF5D2F_426264275 = (!dialog.testAndSetIsDialogTerminatedEventDelivered());
                {
                    DialogTerminatedEvent event = new DialogTerminatedEvent(dialog.getSipProvider(),
                        dialog);
                    dialog.getSipProvider().handleEvent(event, null);
                } 
            } 
        } 
        addTaint(dialog.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.520 -0400", hash_original_method = "7CD5A4CB12647D3BBBFDC040A2B5E183", hash_generated_method = "97D09A8C9E8D1F7BD2D44BF1445CF9F0")
    public SIPDialog getDialog(String dialogId) {
        SIPDialog varB4EAC82CA7396A68D541C85D26508E83_902548665 = null; 
        SIPDialog sipDialog = (SIPDialog) dialogTable.get(dialogId);
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_1795929812 = (stackLogger.isLoggingEnabled());
            {
                stackLogger.logDebug("getDialog(" + dialogId + ") : returning " + sipDialog);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_902548665 = sipDialog;
        addTaint(dialogId.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_902548665.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_902548665;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.520 -0400", hash_original_method = "B0D51307A4FC266FC1D02389AEE54D05", hash_generated_method = "4043F48749C67BACFB121009C33A2070")
    public void removeDialog(String dialogId) {
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_1040882499 = (stackLogger.isLoggingEnabled());
            {
                stackLogger.logWarning("Silently removing dialog from table");
            } 
        } 
        dialogTable.remove(dialogId);
        addTaint(dialogId.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.521 -0400", hash_original_method = "5BA8167D6AC26A2C080E0DF071E238DD", hash_generated_method = "2794FAD0F2158B9D8EA6AA0F57BE91DE")
    public SIPClientTransaction findSubscribeTransaction(SIPRequest notifyMessage,
            ListeningPointImpl listeningPoint) {
        SIPClientTransaction varB4EAC82CA7396A68D541C85D26508E83_1305003538 = null; 
        SIPClientTransaction varB4EAC82CA7396A68D541C85D26508E83_1751043105 = null; 
        SIPClientTransaction varB4EAC82CA7396A68D541C85D26508E83_1061905357 = null; 
        SIPClientTransaction varB4EAC82CA7396A68D541C85D26508E83_1543468711 = null; 
        SIPClientTransaction retval = null;
        try 
        {
            Iterator it = clientTransactionTable.values().iterator();
            {
                boolean varCEA0B8AAFFB6C70BF01D444180FAAB1F_917378024 = (stackLogger.isLoggingEnabled());
                stackLogger.logDebug("ct table size = " + clientTransactionTable.size());
            } 
            String thisToTag = notifyMessage.getTo().getTag();
            {
                varB4EAC82CA7396A68D541C85D26508E83_1305003538 = retval;
            } 
            Event eventHdr = (Event) notifyMessage.getHeader(EventHeader.NAME);
            {
                {
                    boolean varAC370D5D69DCACC466AEF155D6729732_229041224 = (stackLogger.isLoggingEnabled());
                    {
                        stackLogger.logDebug("event Header is null -- returning null");
                    } 
                } 
                varB4EAC82CA7396A68D541C85D26508E83_1751043105 = retval;
            } 
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_278813517 = (it.hasNext());
                {
                    SIPClientTransaction ct = (SIPClientTransaction) it.next();
                    {
                        boolean varCFF1A0705DCC3B6E112E467A6D493F5D_1128521233 = (!ct.getMethod().equals(Request.SUBSCRIBE));
                    } 
                    String fromTag = ct.from.getTag();
                    Event hisEvent = ct.event;
                    {
                        boolean varD2993363F7AFB86CA04E191D1274040B_2040744307 = (stackLogger.isLoggingEnabled());
                        {
                            stackLogger.logDebug("ct.fromTag = " + fromTag);
                            stackLogger.logDebug("thisToTag = " + thisToTag);
                            stackLogger.logDebug("hisEvent = " + hisEvent);
                            stackLogger.logDebug("eventHdr " + eventHdr);
                        } 
                    } 
                    {
                        boolean var6ED9F094D5E7B37CADC33B9F7291C0D3_1881685860 = (fromTag.equalsIgnoreCase(thisToTag)
                      && hisEvent != null
                      && eventHdr.match(hisEvent)
                      && notifyMessage.getCallId().getCallId().equalsIgnoreCase(
                                ct.callId.getCallId()));
                        {
                            {
                                boolean var9282859C10B3BDA9643C67160A68D9EE_535675204 = (ct.acquireSem());
                                retval = ct;
                            } 
                            varB4EAC82CA7396A68D541C85D26508E83_1061905357 = retval;
                        } 
                    } 
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1543468711 = retval;
        } 
        finally 
        {
            {
                boolean varCEA0B8AAFFB6C70BF01D444180FAAB1F_1420702300 = (stackLogger.isLoggingEnabled());
                stackLogger.logDebug("findSubscribeTransaction : returning " + retval);
            } 
        } 
        addTaint(notifyMessage.getTaint());
        addTaint(listeningPoint.getTaint());
        SIPClientTransaction varA7E53CE21691AB073D9660D615818899_655827893; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_655827893 = varB4EAC82CA7396A68D541C85D26508E83_1305003538;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_655827893 = varB4EAC82CA7396A68D541C85D26508E83_1751043105;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_655827893 = varB4EAC82CA7396A68D541C85D26508E83_1061905357;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_655827893 = varB4EAC82CA7396A68D541C85D26508E83_1543468711;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_655827893.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_655827893;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.522 -0400", hash_original_method = "D49C9B94E89B7FEA3320280273306438", hash_generated_method = "32E90A5EAAFB8261193DA664B64BDA5D")
    public void addTransactionPendingAck(SIPServerTransaction serverTransaction) {
        String branchId = ((SIPRequest)serverTransaction.getRequest()).getTopmostVia().getBranch();
        {
            this.terminatedServerTransactionsPendingAck.put(branchId, serverTransaction);
        } 
        addTaint(serverTransaction.getTaint());
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.522 -0400", hash_original_method = "37709198085D538D169FF1DE9D9ADB9C", hash_generated_method = "00B4E43910C78EF1E199AFDD30540A87")
    public SIPServerTransaction findTransactionPendingAck(SIPRequest ackMessage) {
        SIPServerTransaction varB4EAC82CA7396A68D541C85D26508E83_760060416 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_760060416 = this.terminatedServerTransactionsPendingAck.get(ackMessage.getTopmostVia().getBranch());
        addTaint(ackMessage.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_760060416.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_760060416;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.523 -0400", hash_original_method = "B481CD0C272F0294325516CB58C4D625", hash_generated_method = "0D8FE1AE2524C0395C307D2966E3BA10")
    public boolean removeTransactionPendingAck(SIPServerTransaction serverTransaction) {
        String branchId = ((SIPRequest)serverTransaction.getRequest()).getTopmostVia().getBranch();
        {
            boolean varEBE195BF36968B3D949EA3A425E49317_1590968569 = (branchId != null && this.terminatedServerTransactionsPendingAck.containsKey(branchId));
            {
                this.terminatedServerTransactionsPendingAck.remove(branchId);
            } 
        } 
        addTaint(serverTransaction.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1806739896 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1806739896;
        
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.523 -0400", hash_original_method = "E118D63661EEDB81E619AEC2D5F479DE", hash_generated_method = "11A6A128C5CCECD26938D2E00E84CDEE")
    public boolean isTransactionPendingAck(SIPServerTransaction serverTransaction) {
        String branchId = ((SIPRequest)serverTransaction.getRequest()).getTopmostVia().getBranch();
        boolean var4577C4FD500FC681BA07DFDB97EB4243_1562753511 = (this.terminatedServerTransactionsPendingAck.contains(branchId));
        addTaint(serverTransaction.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1694840616 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1694840616;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.525 -0400", hash_original_method = "CFF098965464555AD1B1F596C34C16A1", hash_generated_method = "3B84D32EFF34B4BEF8C1CCED395A0C3F")
    public SIPTransaction findTransaction(SIPMessage sipMessage, boolean isServer) {
        SIPTransaction varB4EAC82CA7396A68D541C85D26508E83_395060661 = null; 
        SIPTransaction varB4EAC82CA7396A68D541C85D26508E83_490885749 = null; 
        SIPTransaction varB4EAC82CA7396A68D541C85D26508E83_176777392 = null; 
        SIPTransaction varB4EAC82CA7396A68D541C85D26508E83_994422384 = null; 
        SIPTransaction varB4EAC82CA7396A68D541C85D26508E83_1592201958 = null; 
        SIPTransaction retval = null;
        try 
        {
            {
                Via via = sipMessage.getTopmostVia();
                {
                    boolean var240DE521E282CF4DDD1501CDC8DEB0BE_817284551 = (via.getBranch() != null);
                    {
                        String key = sipMessage.getTransactionId();
                        retval = (SIPTransaction) serverTransactionTable.get(key);
                        {
                            boolean varDFC91DFB4BB95E42F71B00E05C1AFFB9_413146305 = (stackLogger.isLoggingEnabled());
                            getStackLogger().logDebug(
                                "serverTx: looking for key " + key + " existing="
                                + serverTransactionTable);
                        } 
                        {
                            boolean var824837A9145CA2EC03C0E877A985B1E6_726581795 = (key.startsWith(SIPConstants.BRANCH_MAGIC_COOKIE_LOWER_CASE));
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_395060661 = retval;
                            } 
                        } 
                    } 
                } 
                Iterator<SIPServerTransaction> it = serverTransactionTable.values().iterator();
                {
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_929974443 = (it.hasNext());
                    {
                        SIPServerTransaction sipServerTransaction = (SIPServerTransaction) it.next();
                        {
                            boolean varF6051FB334F93F8949404856131DFA0F_1188975608 = (sipServerTransaction.isMessagePartOfTransaction(sipMessage));
                            {
                                retval = sipServerTransaction;
                                varB4EAC82CA7396A68D541C85D26508E83_490885749 = retval;
                            } 
                        } 
                    } 
                } 
            } 
            {
                Via via = sipMessage.getTopmostVia();
                {
                    boolean var240DE521E282CF4DDD1501CDC8DEB0BE_275364394 = (via.getBranch() != null);
                    {
                        String key = sipMessage.getTransactionId();
                        {
                            boolean varDFC91DFB4BB95E42F71B00E05C1AFFB9_1606221700 = (stackLogger.isLoggingEnabled());
                            getStackLogger().logDebug("clientTx: looking for key " + key);
                        } 
                        retval = (SIPTransaction) clientTransactionTable.get(key);
                        {
                            boolean var824837A9145CA2EC03C0E877A985B1E6_645061720 = (key.startsWith(SIPConstants.BRANCH_MAGIC_COOKIE_LOWER_CASE));
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_176777392 = retval;
                            } 
                        } 
                    } 
                } 
                Iterator<SIPClientTransaction> it = clientTransactionTable.values().iterator();
                {
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_2031405497 = (it.hasNext());
                    {
                        SIPClientTransaction clientTransaction = (SIPClientTransaction) it.next();
                        {
                            boolean var35F8E4FD38F5FA1A650C87F5120892B2_1528689674 = (clientTransaction.isMessagePartOfTransaction(sipMessage));
                            {
                                retval = clientTransaction;
                                varB4EAC82CA7396A68D541C85D26508E83_994422384 = retval;
                            } 
                        } 
                    } 
                } 
            } 
        } 
        finally 
        {
            {
                boolean varDED775332D522DB4765B6C0D6DAB9C7F_763139268 = (this.getStackLogger().isLoggingEnabled());
                {
                    this.getStackLogger().logDebug("findTransaction: returning  : " + retval);
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1592201958 = retval;
        addTaint(sipMessage.getTaint());
        addTaint(isServer);
        SIPTransaction varA7E53CE21691AB073D9660D615818899_199345188; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_199345188 = varB4EAC82CA7396A68D541C85D26508E83_395060661;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_199345188 = varB4EAC82CA7396A68D541C85D26508E83_490885749;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_199345188 = varB4EAC82CA7396A68D541C85D26508E83_176777392;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_199345188 = varB4EAC82CA7396A68D541C85D26508E83_994422384;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_199345188 = varB4EAC82CA7396A68D541C85D26508E83_1592201958;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_199345188.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_199345188;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.527 -0400", hash_original_method = "EBA76BEAE03DA80AC45DCE1E9705412D", hash_generated_method = "F9C6A7A0C641E461E4F6945AD3654603")
    public SIPTransaction findCancelTransaction(SIPRequest cancelRequest, boolean isServer) {
        SIPTransaction varB4EAC82CA7396A68D541C85D26508E83_384937367 = null; 
        SIPTransaction varB4EAC82CA7396A68D541C85D26508E83_278326318 = null; 
        SIPTransaction varB4EAC82CA7396A68D541C85D26508E83_161905627 = null; 
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_1942096293 = (stackLogger.isLoggingEnabled());
            {
                stackLogger.logDebug("findCancelTransaction request= \n" + cancelRequest
                    + "\nfindCancelRequest isServer=" + isServer);
            } 
        } 
        {
            Iterator<SIPServerTransaction> li = this.serverTransactionTable.values().iterator();
            {
                boolean varD1722E42EA3CA8952F93B6521D875E61_1707926559 = (li.hasNext());
                {
                    SIPTransaction transaction = (SIPTransaction) li.next();
                    SIPServerTransaction sipServerTransaction = (SIPServerTransaction) transaction;
                    {
                        boolean var63C9AAE72219DF269358A97F4B9DD737_1015589107 = (sipServerTransaction.doesCancelMatchTransaction(cancelRequest));
                        varB4EAC82CA7396A68D541C85D26508E83_384937367 = sipServerTransaction;
                    } 
                } 
            } 
        } 
        {
            Iterator<SIPClientTransaction> li = this.clientTransactionTable.values().iterator();
            {
                boolean varD1722E42EA3CA8952F93B6521D875E61_1744240715 = (li.hasNext());
                {
                    SIPTransaction transaction = (SIPTransaction) li.next();
                    SIPClientTransaction sipClientTransaction = (SIPClientTransaction) transaction;
                    {
                        boolean varAEAD15F06F6B78E29169322410091CA1_875141641 = (sipClientTransaction.doesCancelMatchTransaction(cancelRequest));
                        varB4EAC82CA7396A68D541C85D26508E83_278326318 = sipClientTransaction;
                    } 
                } 
            } 
        } 
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_453645350 = (stackLogger.isLoggingEnabled());
            stackLogger.logDebug("Could not find transaction for cancel request");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_161905627 = null;
        addTaint(cancelRequest.getTaint());
        addTaint(isServer);
        SIPTransaction varA7E53CE21691AB073D9660D615818899_2129282354; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2129282354 = varB4EAC82CA7396A68D541C85D26508E83_384937367;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_2129282354 = varB4EAC82CA7396A68D541C85D26508E83_278326318;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2129282354 = varB4EAC82CA7396A68D541C85D26508E83_161905627;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2129282354.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2129282354;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.529 -0400", hash_original_method = "C32886C5E5EF95CE74E82DCEA7E677B6", hash_generated_method = "497666AE546ADA10297B133A41B21E7A")
    public SIPServerTransaction findPendingTransaction(SIPRequest requestReceived) {
        SIPServerTransaction varB4EAC82CA7396A68D541C85D26508E83_1198693479 = null; 
        {
            boolean var11C62F83477FD0505FB5BB12080FBCDA_1875905870 = (this.stackLogger.isLoggingEnabled());
            {
                this.stackLogger.logDebug("looking for pending tx for :"
                    + requestReceived.getTransactionId());
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1198693479 = (SIPServerTransaction) pendingTransactions.get(requestReceived.getTransactionId());
        addTaint(requestReceived.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1198693479.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1198693479;
        
        
            
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.540 -0400", hash_original_method = "DE7BCEF3CEAF7F5E4F7BCE647A148129", hash_generated_method = "E64D5E9DC56CAC40A470A65151797D2E")
    public SIPServerTransaction findMergedTransaction(SIPRequest sipRequest) {
        SIPServerTransaction varB4EAC82CA7396A68D541C85D26508E83_559548668 = null; 
        SIPServerTransaction varB4EAC82CA7396A68D541C85D26508E83_419007420 = null; 
        SIPServerTransaction varB4EAC82CA7396A68D541C85D26508E83_688895778 = null; 
        SIPServerTransaction varB4EAC82CA7396A68D541C85D26508E83_1497095262 = null; 
        SIPServerTransaction varB4EAC82CA7396A68D541C85D26508E83_1535603719 = null; 
        {
            boolean varEB91205F9E3B5AB16C809B69E830E585_2103570130 = (! sipRequest.getMethod().equals(Request.INVITE));
            {
                varB4EAC82CA7396A68D541C85D26508E83_559548668 = null;
            } 
        } 
        String mergeId = sipRequest.getMergeId();
        SIPServerTransaction mergedTransaction = (SIPServerTransaction) this.mergeTable.get(mergeId);
        {
            varB4EAC82CA7396A68D541C85D26508E83_419007420 = null;
        } 
        {
            boolean varDD5DC8FFD549FCFBE54C0C4063924793_661632151 = (mergedTransaction != null && !mergedTransaction.isMessagePartOfTransaction(sipRequest));
            {
                varB4EAC82CA7396A68D541C85D26508E83_688895778 = mergedTransaction;
            } 
            {
                {
                    Iterator<SIPDialog> var13FA49F9AC884432F840638793CBDD7F_1729385353 = (this.dialogTable.values()).iterator();
                    var13FA49F9AC884432F840638793CBDD7F_1729385353.hasNext();
                    Dialog dialog = var13FA49F9AC884432F840638793CBDD7F_1729385353.next();
                    {
                        SIPDialog sipDialog = (SIPDialog) dialog;
                        {
                            boolean varF35A178555525ACF54ED52DD1E0580BB_1490047925 = (sipDialog.getFirstTransaction()  != null && 
                   sipDialog.getFirstTransaction() instanceof ServerTransaction);
                            {
                                SIPServerTransaction serverTransaction = ((SIPServerTransaction) sipDialog.getFirstTransaction());
                                SIPRequest transactionRequest = ((SIPServerTransaction) sipDialog.getFirstTransaction()).getOriginalRequest();
                                {
                                    boolean var38302743A39D1C992E94EBEE863951D6_330689185 = ((! serverTransaction.isMessagePartOfTransaction(sipRequest))
                           && sipRequest.getMergeId().equals(transactionRequest.getMergeId()));
                                    {
                                        varB4EAC82CA7396A68D541C85D26508E83_1497095262 = (SIPServerTransaction) sipDialog.getFirstTransaction();
                                    } 
                                } 
                            } 
                        } 
                    } 
                } 
                varB4EAC82CA7396A68D541C85D26508E83_1535603719 = null;
            } 
        } 
        addTaint(sipRequest.getTaint());
        SIPServerTransaction varA7E53CE21691AB073D9660D615818899_1829156280; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1829156280 = varB4EAC82CA7396A68D541C85D26508E83_559548668;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1829156280 = varB4EAC82CA7396A68D541C85D26508E83_419007420;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1829156280 = varB4EAC82CA7396A68D541C85D26508E83_688895778;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_1829156280 = varB4EAC82CA7396A68D541C85D26508E83_1497095262;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1829156280 = varB4EAC82CA7396A68D541C85D26508E83_1535603719;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1829156280.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1829156280;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.542 -0400", hash_original_method = "365415518ECAE79EAD0CD2C9D4462A78", hash_generated_method = "8F59160F6FD9802A966DC97DE91CF06D")
    public void removePendingTransaction(SIPServerTransaction tr) {
        {
            boolean var11C62F83477FD0505FB5BB12080FBCDA_1892716048 = (this.stackLogger.isLoggingEnabled());
            {
                this.stackLogger.logDebug("removePendingTx: " + tr.getTransactionId());
            } 
        } 
        this.pendingTransactions.remove(tr.getTransactionId());
        addTaint(tr.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.543 -0400", hash_original_method = "DB6ED2CEA840316B4782573C88C3E1FC", hash_generated_method = "2CB57BFFA05123985E5CBDECF8A8922E")
    public void removeFromMergeTable(SIPServerTransaction tr) {
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_325429673 = (stackLogger.isLoggingEnabled());
            {
                this.stackLogger.logDebug("Removing tx from merge table ");
            } 
        } 
        String key = ((SIPRequest) tr.getRequest()).getMergeId();
        {
            this.mergeTable.remove(key);
        } 
        addTaint(tr.getTaint());
        
        
            
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.543 -0400", hash_original_method = "4DF3A9A601EFF55EEB4CCC4D0E1A4382", hash_generated_method = "8D50D6BE29F6D5D2534C6280C054038A")
    public void putInMergeTable(SIPServerTransaction sipTransaction, SIPRequest sipRequest) {
        String mergeKey = sipRequest.getMergeId();
        {
            this.mergeTable.put(mergeKey, sipTransaction);
        } 
        addTaint(sipTransaction.getTaint());
        addTaint(sipRequest.getTaint());
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.544 -0400", hash_original_method = "8109166214A5696534573E329912E2B5", hash_generated_method = "8CD4392F319236190EC8ABBEE623354A")
    public void mapTransaction(SIPServerTransaction transaction) {
        addTransactionHash(transaction);
        transaction.isMapped = true;
        addTaint(transaction.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.545 -0400", hash_original_method = "C3F915B9919F99B9388976510DFE400E", hash_generated_method = "DC172BDCAB2B97A55FCECC3D41B65ECB")
    public ServerRequestInterface newSIPServerRequest(SIPRequest requestReceived,
            MessageChannel requestMessageChannel) {
        ServerRequestInterface varB4EAC82CA7396A68D541C85D26508E83_290210422 = null; 
        ServerRequestInterface varB4EAC82CA7396A68D541C85D26508E83_377883654 = null; 
        ServerRequestInterface varB4EAC82CA7396A68D541C85D26508E83_329516975 = null; 
        ServerRequestInterface varB4EAC82CA7396A68D541C85D26508E83_1149652087 = null; 
        ServerRequestInterface varB4EAC82CA7396A68D541C85D26508E83_892559291 = null; 
        Iterator<SIPServerTransaction> transactionIterator;
        SIPServerTransaction nextTransaction;
        SIPServerTransaction currentTransaction;
        String key = requestReceived.getTransactionId();
        requestReceived.setMessageChannel(requestMessageChannel);
        currentTransaction = (SIPServerTransaction) serverTransactionTable.get(key);
        {
            boolean varD5F22D6501778D69EFB1B4C78D1BC071_728604762 = (currentTransaction == null
                || !currentTransaction.isMessagePartOfTransaction(requestReceived));
            {
                transactionIterator = serverTransactionTable.values().iterator();
                currentTransaction = null;
                {
                    boolean varDF525999E4178F83F821F7840AF0A701_377073088 = (!key.toLowerCase().startsWith(SIPConstants.BRANCH_MAGIC_COOKIE_LOWER_CASE));
                    {
                        {
                            boolean varE06F989DC131B262AEF6DA55B8F8DDB2_1651734911 = (transactionIterator.hasNext() && currentTransaction == null);
                            {
                                nextTransaction = (SIPServerTransaction) transactionIterator.next();
                                {
                                    boolean var7384431C022BEE094664534666A1D7AF_414978659 = (nextTransaction.isMessagePartOfTransaction(requestReceived));
                                    {
                                        currentTransaction = nextTransaction;
                                    } 
                                } 
                            } 
                        } 
                    } 
                } 
                {
                    currentTransaction = findPendingTransaction(requestReceived);
                    {
                        requestReceived.setTransaction(currentTransaction);
                        {
                            boolean varC390E2A5DFAA4F7FA1689CB7638E2EB7_1066786288 = (currentTransaction != null && currentTransaction.acquireSem());
                            varB4EAC82CA7396A68D541C85D26508E83_290210422 = currentTransaction;
                            varB4EAC82CA7396A68D541C85D26508E83_377883654 = null;
                        } 
                    } 
                    currentTransaction = createServerTransaction(requestMessageChannel);
                    {
                        currentTransaction.setOriginalRequest(requestReceived);
                        requestReceived.setTransaction(currentTransaction);
                    } 
                } 
            } 
        } 
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_863094105 = (stackLogger.isLoggingEnabled());
            {
                stackLogger.logDebug("newSIPServerRequest( " + requestReceived.getMethod() + ":"
                    + requestReceived.getTopmostVia().getBranch() + "):" + currentTransaction);
            } 
        } 
        currentTransaction.setRequestInterface(sipMessageFactory.newSIPServerRequest(
                    requestReceived, currentTransaction));
        {
            boolean var0F6C442AF508B1ABAB943F4C4B4ED076_1052848927 = (currentTransaction != null && currentTransaction.acquireSem());
            {
                varB4EAC82CA7396A68D541C85D26508E83_329516975 = currentTransaction;
            } 
            {
                try 
                {
                    {
                        boolean var73C027315BBD0DCC1A552716D2DA9C61_743377647 = (currentTransaction.isMessagePartOfTransaction(requestReceived) &&
                    currentTransaction.getMethod().equals(requestReceived.getMethod()));
                        {
                            SIPResponse trying = requestReceived.createResponse(Response.TRYING);
                            trying.removeContent();
                            currentTransaction.getMessageChannel().sendMessage(trying);
                        } 
                    } 
                } 
                catch (Exception ex)
                {
                    {
                        boolean var86B7E4A6EFF1453FB71811BCAA5C5B32_107892616 = (isLoggingEnabled());
                        stackLogger.logError("Exception occured sending TRYING");
                    } 
                } 
                varB4EAC82CA7396A68D541C85D26508E83_1149652087 = null;
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_892559291 = null;
            } 
        } 
        addTaint(requestReceived.getTaint());
        addTaint(requestMessageChannel.getTaint());
        ServerRequestInterface varA7E53CE21691AB073D9660D615818899_1841676899; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1841676899 = varB4EAC82CA7396A68D541C85D26508E83_290210422;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1841676899 = varB4EAC82CA7396A68D541C85D26508E83_377883654;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1841676899 = varB4EAC82CA7396A68D541C85D26508E83_329516975;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_1841676899 = varB4EAC82CA7396A68D541C85D26508E83_1149652087;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1841676899 = varB4EAC82CA7396A68D541C85D26508E83_892559291;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1841676899.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1841676899;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.547 -0400", hash_original_method = "62ADB5DE3DAA611F01F5B25EB82A32E9", hash_generated_method = "0EBF1E136451BDE470464AEFA6ED1258")
    public ServerResponseInterface newSIPServerResponse(SIPResponse responseReceived,
            MessageChannel responseMessageChannel) {
        ServerResponseInterface varB4EAC82CA7396A68D541C85D26508E83_720203848 = null; 
        ServerResponseInterface varB4EAC82CA7396A68D541C85D26508E83_1864157619 = null; 
        ServerResponseInterface varB4EAC82CA7396A68D541C85D26508E83_1180828753 = null; 
        ServerResponseInterface varB4EAC82CA7396A68D541C85D26508E83_1210309432 = null; 
        Iterator<SIPClientTransaction> transactionIterator;
        SIPClientTransaction nextTransaction;
        SIPClientTransaction currentTransaction;
        String key = responseReceived.getTransactionId();
        currentTransaction = (SIPClientTransaction) clientTransactionTable.get(key);
        {
            boolean varFD65E86793E7DA9A4559DFCAD3FE7A38_1860608094 = (currentTransaction == null
                || (!currentTransaction.isMessagePartOfTransaction(responseReceived) && !key
                        .startsWith(SIPConstants.BRANCH_MAGIC_COOKIE_LOWER_CASE)));
            {
                transactionIterator = clientTransactionTable.values().iterator();
                currentTransaction = null;
                {
                    boolean var02E71BDB7FE3E53290C9D60F6709CA78_640768132 = (transactionIterator.hasNext() && currentTransaction == null);
                    {
                        nextTransaction = (SIPClientTransaction) transactionIterator.next();
                        {
                            boolean varB7132609472FD4E761BE7525D40545ED_1940460330 = (nextTransaction.isMessagePartOfTransaction(responseReceived));
                            {
                                currentTransaction = nextTransaction;
                            } 
                        } 
                    } 
                } 
                {
                    {
                        boolean var0954F7596F6CFAF1C1D43DD490BBFB96_2025259730 = (this.stackLogger.isLoggingEnabled(StackLogger.TRACE_INFO));
                        {
                            responseMessageChannel.logResponse(responseReceived, System
                            .currentTimeMillis(), "before processing");
                        } 
                    } 
                    varB4EAC82CA7396A68D541C85D26508E83_720203848 = sipMessageFactory.newSIPServerResponse(responseReceived,
                        responseMessageChannel);
                } 
            } 
        } 
        boolean acquired = currentTransaction.acquireSem();
        {
            boolean var052D788439DC89D4EA99379C3615ED1C_943680127 = (this.stackLogger.isLoggingEnabled(StackLogger.TRACE_INFO));
            {
                currentTransaction.logResponse(responseReceived, System.currentTimeMillis(),
                    "before processing");
            } 
        } 
        {
            ServerResponseInterface sri = sipMessageFactory.newSIPServerResponse(
                    responseReceived, currentTransaction);
            {
                currentTransaction.setResponseInterface(sri);
            } 
            {
                {
                    boolean varB994156BC51EB47795FEDC6186A6DA25_1857187535 = (this.stackLogger.isLoggingEnabled());
                    {
                        this.stackLogger.logDebug("returning null - serverResponseInterface is null!");
                    } 
                } 
                currentTransaction.releaseSem();
                varB4EAC82CA7396A68D541C85D26508E83_1864157619 = null;
            } 
        } 
        {
            {
                boolean varCEA0B8AAFFB6C70BF01D444180FAAB1F_367170956 = (stackLogger.isLoggingEnabled());
                this.stackLogger.logDebug("Could not aquire semaphore !!");
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1180828753 = currentTransaction;
        varB4EAC82CA7396A68D541C85D26508E83_1210309432 = null;
        addTaint(responseReceived.getTaint());
        addTaint(responseMessageChannel.getTaint());
        ServerResponseInterface varA7E53CE21691AB073D9660D615818899_601896876; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_601896876 = varB4EAC82CA7396A68D541C85D26508E83_720203848;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_601896876 = varB4EAC82CA7396A68D541C85D26508E83_1864157619;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_601896876 = varB4EAC82CA7396A68D541C85D26508E83_1180828753;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_601896876 = varB4EAC82CA7396A68D541C85D26508E83_1210309432;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_601896876.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_601896876;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.549 -0400", hash_original_method = "32F3E8827D13E0BAFD4E9DD3BE9CB370", hash_generated_method = "407BBA17B630009364440EEA6DE58EB8")
    public MessageChannel createMessageChannel(SIPRequest request, MessageProcessor mp,
            Hop nextHop) throws IOException {
        MessageChannel varB4EAC82CA7396A68D541C85D26508E83_1395049398 = null; 
        MessageChannel varB4EAC82CA7396A68D541C85D26508E83_2103596633 = null; 
        SIPTransaction returnChannel;
        Host targetHost = new Host();
        targetHost.setHostname(nextHop.getHost());
        HostPort targetHostPort = new HostPort();
        targetHostPort.setHost(targetHost);
        targetHostPort.setPort(nextHop.getPort());
        MessageChannel mc = mp.createMessageChannel(targetHostPort);
        varB4EAC82CA7396A68D541C85D26508E83_1395049398 = null;
        returnChannel = createClientTransaction(request, mc);
        ((SIPClientTransaction) returnChannel).setViaPort(nextHop.getPort());
        ((SIPClientTransaction) returnChannel).setViaHost(nextHop.getHost());
        addTransactionHash(returnChannel);
        varB4EAC82CA7396A68D541C85D26508E83_2103596633 = returnChannel;
        addTaint(request.getTaint());
        addTaint(mp.getTaint());
        addTaint(nextHop.getTaint());
        MessageChannel varA7E53CE21691AB073D9660D615818899_775404568; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_775404568 = varB4EAC82CA7396A68D541C85D26508E83_1395049398;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_775404568 = varB4EAC82CA7396A68D541C85D26508E83_2103596633;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_775404568.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_775404568;
        
        
        
        
        
        
        
        
        
            
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.551 -0400", hash_original_method = "912DB48513D0A0D8594B2E782158C138", hash_generated_method = "129D117F6C49DE43DF95792EBBB81AAC")
    public SIPClientTransaction createClientTransaction(SIPRequest sipRequest,
            MessageChannel encapsulatedMessageChannel) {
        SIPClientTransaction varB4EAC82CA7396A68D541C85D26508E83_1777690885 = null; 
        SIPClientTransaction ct = new SIPClientTransaction(this, encapsulatedMessageChannel);
        ct.setOriginalRequest(sipRequest);
        varB4EAC82CA7396A68D541C85D26508E83_1777690885 = ct;
        addTaint(sipRequest.getTaint());
        addTaint(encapsulatedMessageChannel.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1777690885.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1777690885;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.552 -0400", hash_original_method = "81B760547C7425A938D45D7063876C66", hash_generated_method = "05F65E14C838AB783C0B75A9D8512085")
    public SIPServerTransaction createServerTransaction(MessageChannel encapsulatedMessageChannel) {
        SIPServerTransaction varB4EAC82CA7396A68D541C85D26508E83_472930851 = null; 
        SIPServerTransaction varB4EAC82CA7396A68D541C85D26508E83_1543590422 = null; 
        SIPServerTransaction varB4EAC82CA7396A68D541C85D26508E83_518949313 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_472930851 = new SIPServerTransaction(this, encapsulatedMessageChannel);
        } 
        {
            float threshold = ((float) (serverTransactionTable.size() - serverTransactionTableLowaterMark))
                    / ((float) (serverTransactionTableHighwaterMark - serverTransactionTableLowaterMark));
            boolean decision = Math.random() > 1.0 - threshold;
            {
                varB4EAC82CA7396A68D541C85D26508E83_1543590422 = null;
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_518949313 = new SIPServerTransaction(this, encapsulatedMessageChannel);
            } 
        } 
        addTaint(encapsulatedMessageChannel.getTaint());
        SIPServerTransaction varA7E53CE21691AB073D9660D615818899_1723336328; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1723336328 = varB4EAC82CA7396A68D541C85D26508E83_472930851;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1723336328 = varB4EAC82CA7396A68D541C85D26508E83_1543590422;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1723336328 = varB4EAC82CA7396A68D541C85D26508E83_518949313;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1723336328.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1723336328;
        
        
            
        
            
                    
            
            
                
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.552 -0400", hash_original_method = "2775112CA96E4BBD847FD3F2A14A81DE", hash_generated_method = "5494617EB33768D5833A2FD6BFC58217")
    public int getClientTransactionTableSize() {
        int var03DB7AB6196DC5D0E9988C142D712431_1109887014 = (this.clientTransactionTable.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1717472488 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1717472488;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.553 -0400", hash_original_method = "4372809DD9897424686B6F4A147D93FA", hash_generated_method = "2F4553262D6C7FBB0AAC17C520D78BED")
    public int getServerTransactionTableSize() {
        int var7FEDB251634EBCF9A56CDDB387AADB7C_1694339731 = (this.serverTransactionTable.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1732028967 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1732028967;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.553 -0400", hash_original_method = "2F0441D135E4CBEEA76B3CCA00FAD23B", hash_generated_method = "D750B16A5A5E747C598A319FCB9E1E4F")
    public void addTransaction(SIPClientTransaction clientTransaction) {
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_1866922557 = (stackLogger.isLoggingEnabled());
            stackLogger.logDebug("added transaction " + clientTransaction);
        } 
        addTransactionHash(clientTransaction);
        addTaint(clientTransaction.getTaint());
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.554 -0400", hash_original_method = "FC7C0EB4C2CF25B4E39BD000BE1A0318", hash_generated_method = "61CCD8039019E3495EA897A72BF3A573")
    public void removeTransaction(SIPTransaction sipTransaction) {
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_1828645998 = (stackLogger.isLoggingEnabled());
            {
                stackLogger.logDebug("Removing Transaction = " + sipTransaction.getTransactionId()
                    + " transaction = " + sipTransaction);
            } 
        } 
        {
            {
                boolean varCEA0B8AAFFB6C70BF01D444180FAAB1F_1863284241 = (stackLogger.isLoggingEnabled());
                stackLogger.logStackTrace();
            } 
            String key = sipTransaction.getTransactionId();
            Object removed = serverTransactionTable.remove(key);
            String method = sipTransaction.getMethod();
            this.removePendingTransaction((SIPServerTransaction) sipTransaction);
            this.removeTransactionPendingAck((SIPServerTransaction) sipTransaction);
            {
                boolean varCD28D341484E6B95D2F46E243D03836E_375767631 = (method.equalsIgnoreCase(Request.INVITE));
                {
                    this.removeFromMergeTable((SIPServerTransaction) sipTransaction);
                } 
            } 
            SipProviderImpl sipProvider = (SipProviderImpl) sipTransaction.getSipProvider();
            {
                boolean var1213E4480B57552575E83F2F9387B887_78851551 = (removed != null && sipTransaction.testAndSetTransactionTerminatedEvent());
                {
                    TransactionTerminatedEvent event = new TransactionTerminatedEvent(sipProvider,
                        (ServerTransaction) sipTransaction);
                    sipProvider.handleEvent(event, sipTransaction);
                } 
            } 
        } 
        {
            String key = sipTransaction.getTransactionId();
            Object removed = clientTransactionTable.remove(key);
            {
                boolean varCEA0B8AAFFB6C70BF01D444180FAAB1F_2094040763 = (stackLogger.isLoggingEnabled());
                {
                    stackLogger.logDebug("REMOVED client tx " + removed + " KEY = " + key);
                    {
                        SIPClientTransaction clientTx = (SIPClientTransaction)removed;
                        {
                            boolean varD1410CA2EC6660EFEAC1856DD8EB1E5A_1458125573 = (clientTx.getMethod().equals(Request.INVITE) && this.maxForkTime != 0);
                            {
                                RemoveForkedTransactionTimerTask ttask = new RemoveForkedTransactionTimerTask(clientTx);
                                this.timer.schedule(ttask, this.maxForkTime * 1000);
                            } 
                        } 
                    } 
                } 
            } 
            {
                boolean var1213E4480B57552575E83F2F9387B887_856298386 = (removed != null && sipTransaction.testAndSetTransactionTerminatedEvent());
                {
                    SipProviderImpl sipProvider = (SipProviderImpl) sipTransaction.getSipProvider();
                    TransactionTerminatedEvent event = new TransactionTerminatedEvent(sipProvider,
                        (ClientTransaction) sipTransaction);
                    sipProvider.handleEvent(event, sipTransaction);
                } 
            } 
        } 
        addTaint(sipTransaction.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.554 -0400", hash_original_method = "114E6F44E2106B74A7437814EDE26008", hash_generated_method = "AD3D463BD023D0427D0336CD014E37E5")
    public void addTransaction(SIPServerTransaction serverTransaction) throws IOException {
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_1267170354 = (stackLogger.isLoggingEnabled());
            stackLogger.logDebug("added transaction " + serverTransaction);
        } 
        serverTransaction.map();
        addTransactionHash(serverTransaction);
        addTaint(serverTransaction.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.555 -0400", hash_original_method = "A02B6100DC58EB921085C7ED44EE1D0C", hash_generated_method = "45B36D84BB1DEFA2FB2FC0632F7AD658")
    private void addTransactionHash(SIPTransaction sipTransaction) {
        SIPRequest sipRequest = sipTransaction.getOriginalRequest();
        {
            {
                {
                    boolean varD67D9F55A3909BC928BCBD79D887834D_1721252912 = (this.activeClientTransactionCount.get() > clientTransactionTableHiwaterMark);
                    {
                        try 
                        {
                            {
                                this.clientTransactionTable.wait();
                                this.activeClientTransactionCount.incrementAndGet();
                            } 
                        } 
                        catch (Exception ex)
                        {
                            {
                                boolean var337B2A9C9EA2BB40C001AEDF1FE004ED_1661390167 = (stackLogger.isLoggingEnabled());
                                {
                                    stackLogger.logError("Exception occured while waiting for room", ex);
                                } 
                            } 
                        } 
                    } 
                } 
            } 
            {
                this.activeClientTransactionCount.incrementAndGet();
            } 
            String key = sipRequest.getTransactionId();
            clientTransactionTable.put(key, (SIPClientTransaction) sipTransaction);
            {
                boolean varCEA0B8AAFFB6C70BF01D444180FAAB1F_1819822805 = (stackLogger.isLoggingEnabled());
                {
                    stackLogger.logDebug(" putTransactionHash : " + " key = " + key);
                } 
            } 
        } 
        {
            String key = sipRequest.getTransactionId();
            {
                boolean varCEA0B8AAFFB6C70BF01D444180FAAB1F_1792979323 = (stackLogger.isLoggingEnabled());
                {
                    stackLogger.logDebug(" putTransactionHash : " + " key = " + key);
                } 
            } 
            serverTransactionTable.put(key, (SIPServerTransaction) sipTransaction);
        } 
        addTaint(sipTransaction.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.556 -0400", hash_original_method = "380804F8BD40257E05E5F5A307273856", hash_generated_method = "4F6ACB5786B9867A5430799580B18CC2")
    protected void decrementActiveClientTransactionCount() {
        {
            boolean var47ED5E0FC43EE8302B13C023BBB66045_1748145671 = (this.activeClientTransactionCount.decrementAndGet() <= this.clientTransactionTableLowaterMark
                && !this.unlimitedClientTransactionTableSize);
            {
                {
                    clientTransactionTable.notify();
                } 
            } 
        } 
        
        
                
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.557 -0400", hash_original_method = "BBF1530237A94448CCB60A02BEEFAB6C", hash_generated_method = "1F399D230C27448485D699BF31905325")
    protected void removeTransactionHash(SIPTransaction sipTransaction) {
        SIPRequest sipRequest = sipTransaction.getOriginalRequest();
        {
            String key = sipTransaction.getTransactionId();
            {
                boolean varCEA0B8AAFFB6C70BF01D444180FAAB1F_636053593 = (stackLogger.isLoggingEnabled());
                {
                    stackLogger.logStackTrace();
                    stackLogger.logDebug("removing client Tx : " + key);
                } 
            } 
            clientTransactionTable.remove(key);
        } 
        {
            String key = sipTransaction.getTransactionId();
            serverTransactionTable.remove(key);
            {
                boolean varCEA0B8AAFFB6C70BF01D444180FAAB1F_1785544926 = (stackLogger.isLoggingEnabled());
                {
                    stackLogger.logDebug("removing server Tx : " + key);
                } 
            } 
        } 
        addTaint(sipTransaction.getTaint());
        
        
        
            
        
            
            
                
                
            
            
        
            
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.558 -0400", hash_original_method = "DE85950924139BCA289E1B65627F95C2", hash_generated_method = "7EBE7F2EFCA6ACE4A71F4D5ADC84DB0F")
    public synchronized void transactionErrorEvent(SIPTransactionErrorEvent transactionErrorEvent) {
        SIPTransaction transaction = (SIPTransaction) transactionErrorEvent.getSource();
        {
            boolean varEB5679C18C9B12FA2BAE5A757A24F70B_1066330955 = (transactionErrorEvent.getErrorID() == SIPTransactionErrorEvent.TRANSPORT_ERROR);
            {
                transaction.setState(SIPTransaction.TERMINATED_STATE);
                {
                    ((SIPServerTransaction) transaction).collectionTime = 0;
                } 
                transaction.disableTimeoutTimer();
                transaction.disableRetransmissionTimer();
            } 
        } 
        addTaint(transactionErrorEvent.getTaint());
        
        
        
            
            
                
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.560 -0400", hash_original_method = "2DBBC23B1910A8BC0C385035C3D36387", hash_generated_method = "92BC6F03EA174FA40AACEBFE9843D926")
    public synchronized void dialogErrorEvent(SIPDialogErrorEvent dialogErrorEvent) {
        SIPDialog sipDialog = (SIPDialog) dialogErrorEvent.getSource();
        SipListener sipListener = ((SipStackImpl)this).getSipListener();
        {
            sipDialog.delete();
        } 
        addTaint(dialogErrorEvent.getTaint());
        
        
        
        
        	
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.562 -0400", hash_original_method = "EC17AB4FB84DCA37B1579E7D41B287E3", hash_generated_method = "43EA6CEF89ECFF0BA73DE7BFA5FA8FC3")
    public void stopStack() {
        this.timer.cancel();
        timer = null;
        this.pendingTransactions.clear();
        this.toExit = true;
        {
            this.notifyAll();
        } 
        {
            clientTransactionTable.notifyAll();
        } 
        {
            MessageProcessor[] processorList;
            processorList = getMessageProcessors();
            {
                int processorIndex = 0;
                {
                    removeMessageProcessor(processorList[processorIndex]);
                } 
            } 
            this.ioHandler.closeAll();
        } 
        try 
        {
            Thread.sleep(1000);
        } 
        catch (InterruptedException ex)
        { }
        this.clientTransactionTable.clear();
        this.serverTransactionTable.clear();
        this.dialogTable.clear();
        this.serverLogger.closeLogFile();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.564 -0400", hash_original_method = "CEE88C8969112A140A79BE7502F1A5FB", hash_generated_method = "1D7A53061FA7F54FF01C314C8B3358F6")
    public void putPendingTransaction(SIPServerTransaction tr) {
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_1175024523 = (stackLogger.isLoggingEnabled());
            stackLogger.logDebug("putPendingTransaction: " + tr);
        } 
        this.pendingTransactions.put(tr.getTransactionId(), tr);
        addTaint(tr.getTaint());
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.565 -0400", hash_original_method = "A3344B5915DA0C5B05591E12A62D4610", hash_generated_method = "D109914A108C9D16B349773E442D53A2")
    public NetworkLayer getNetworkLayer() {
        NetworkLayer varB4EAC82CA7396A68D541C85D26508E83_1976105327 = null; 
        NetworkLayer varB4EAC82CA7396A68D541C85D26508E83_976465414 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1976105327 = DefaultNetworkLayer.SINGLETON;
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_976465414 = networkLayer;
        } 
        NetworkLayer varA7E53CE21691AB073D9660D615818899_357898160; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_357898160 = varB4EAC82CA7396A68D541C85D26508E83_1976105327;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_357898160 = varB4EAC82CA7396A68D541C85D26508E83_976465414;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_357898160.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_357898160;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.566 -0400", hash_original_method = "47BDB9F0F1E73BBB0BEBE9D5C68FE123", hash_generated_method = "C45C7D0A9EB97A4442787F3722F0236A")
    public boolean isLoggingEnabled() {
        {
            Object var11C62F83477FD0505FB5BB12080FBCDA_1015398308 = (this.stackLogger.isLoggingEnabled());
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1413229868 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1413229868;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.567 -0400", hash_original_method = "ACBC713DDCF210EE591047F9A9A515DC", hash_generated_method = "9EAEE7902FD7AB5F895E61A59CB9A86D")
    public StackLogger getStackLogger() {
        StackLogger varB4EAC82CA7396A68D541C85D26508E83_378207168 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_378207168 = this.stackLogger;
        varB4EAC82CA7396A68D541C85D26508E83_378207168.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_378207168;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.568 -0400", hash_original_method = "01705032DE3FE074C7E055A3A8A4FEE3", hash_generated_method = "8C7AE494B221088180927BCC1E6F9095")
    public ServerLogger getServerLogger() {
        ServerLogger varB4EAC82CA7396A68D541C85D26508E83_1754883774 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1754883774 = this.serverLogger;
        varB4EAC82CA7396A68D541C85D26508E83_1754883774.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1754883774;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.568 -0400", hash_original_method = "9DA0FD5646924F30F0B4568C00D20E6E", hash_generated_method = "4BB4E911AECFE935E256510829406BB0")
    public int getMaxMessageSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_621593667 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_621593667;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.569 -0400", hash_original_method = "F7820D79676ABCB839F961B1893B47B1", hash_generated_method = "EA170E890B9C35B538B5CB86A786F5AF")
    public void setSingleThreaded() {
        this.threadPoolSize = 1;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.570 -0400", hash_original_method = "E9690233252AAFA4C640E8F4D35D05EB", hash_generated_method = "65BB9FFF7A846847510EF99A4FA089FF")
    public void setThreadPoolSize(int size) {
        this.threadPoolSize = size;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.570 -0400", hash_original_method = "71AE725926CCD09A123AE8B2DA17A3F2", hash_generated_method = "BDCFBBD8A7091C0AC8289D984C7F139F")
    public void setMaxConnections(int nconnections) {
        this.maxConnections = nconnections;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.572 -0400", hash_original_method = "48A74B192606F2E929FFF01B3041CF91", hash_generated_method = "235C93705958C5B2E13DFC77F2FA67DB")
    public Hop getNextHop(SIPRequest sipRequest) throws SipException {
        Hop varB4EAC82CA7396A68D541C85D26508E83_1861969941 = null; 
        Hop varB4EAC82CA7396A68D541C85D26508E83_8102906 = null; 
        Hop varB4EAC82CA7396A68D541C85D26508E83_1599624558 = null; 
        Hop varB4EAC82CA7396A68D541C85D26508E83_776355066 = null; 
        Hop varB4EAC82CA7396A68D541C85D26508E83_91018494 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1861969941 = router.getNextHop(sipRequest);
            varB4EAC82CA7396A68D541C85D26508E83_8102906 = null;
        } 
        {
            {
                boolean varCB9DA79D6FC6DC73F34AC1A9AEB77BE2_578163289 = (sipRequest.getRequestURI().isSipURI() || sipRequest.getRouteHeaders() != null);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1599624558 = defaultRouter.getNextHop(sipRequest);
                } 
                {
                    varB4EAC82CA7396A68D541C85D26508E83_776355066 = router.getNextHop(sipRequest);
                } 
                varB4EAC82CA7396A68D541C85D26508E83_91018494 = null;
            } 
        } 
        addTaint(sipRequest.getTaint());
        Hop varA7E53CE21691AB073D9660D615818899_495104605; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_495104605 = varB4EAC82CA7396A68D541C85D26508E83_1861969941;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_495104605 = varB4EAC82CA7396A68D541C85D26508E83_8102906;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_495104605 = varB4EAC82CA7396A68D541C85D26508E83_1599624558;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_495104605 = varB4EAC82CA7396A68D541C85D26508E83_776355066;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_495104605 = varB4EAC82CA7396A68D541C85D26508E83_91018494;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_495104605.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_495104605;
        
        
            
                
            
                
        
            
                
            
                
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.572 -0400", hash_original_method = "F49E7F0B68A71227FAAC90E58DC1BBF8", hash_generated_method = "0DCFD4017235BFA0DF5839F534EAAED3")
    public void setStackName(String stackName) {
        this.stackName = stackName;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.573 -0400", hash_original_method = "A8237A45131D19EE871BFED3E7A5AA19", hash_generated_method = "9191D34437DC8E4BD17A25E18DAFD650")
    protected void setHostAddress(String stackAddress) throws UnknownHostException {
        {
            boolean var88033752B93C1832F0A794C7B736EEF6_797214888 = (stackAddress.indexOf(':') != stackAddress.lastIndexOf(':')
                && stackAddress.trim().charAt(0) != '[');
            this.stackAddress = '[' + stackAddress + ']';
            this.stackAddress = stackAddress;
        } 
        this.stackInetAddress = InetAddress.getByName(stackAddress);
        
        
                
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.573 -0400", hash_original_method = "54480DAD55477A9080CEE058FAAB32DE", hash_generated_method = "8CBE0F379645B4EAEFF503FA9B94258D")
    public String getHostAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_1177408321 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1177408321 = this.stackAddress;
        varB4EAC82CA7396A68D541C85D26508E83_1177408321.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1177408321;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.574 -0400", hash_original_method = "76950F41C787A5DB271675B8BBBB662A", hash_generated_method = "1E92BF9F05330CC7F9733D97887E55BC")
    protected void setRouter(Router router) {
        this.router = router;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.575 -0400", hash_original_method = "AF384EADB40CF611F4292AFC400A4743", hash_generated_method = "A7D5266390CF39300F88BBAC5AD2AC6A")
    public Router getRouter(SIPRequest request) {
        Router varB4EAC82CA7396A68D541C85D26508E83_1176934922 = null; 
        Router varB4EAC82CA7396A68D541C85D26508E83_111326017 = null; 
        Router varB4EAC82CA7396A68D541C85D26508E83_1464165114 = null; 
        Router varB4EAC82CA7396A68D541C85D26508E83_522708138 = null; 
        Router varB4EAC82CA7396A68D541C85D26508E83_954503842 = null; 
        {
            boolean varF76E09608A8C57E8EC47B53AB21A7904_172482925 = (request.getRequestLine() == null);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1176934922 = this.defaultRouter;
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_111326017 = this.router;
            } 
            {
                {
                    boolean varA3564E0CF4A90785E724764B33E54BE1_545324126 = (request.getRequestURI().getScheme().equals("sip")
                    || request.getRequestURI().getScheme().equals("sips"));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1464165114 = this.defaultRouter;
                    } 
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_522708138 = this.router;
                        varB4EAC82CA7396A68D541C85D26508E83_954503842 = defaultRouter;
                    } 
                } 
            } 
        } 
        addTaint(request.getTaint());
        Router varA7E53CE21691AB073D9660D615818899_2094424304; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2094424304 = varB4EAC82CA7396A68D541C85D26508E83_1176934922;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_2094424304 = varB4EAC82CA7396A68D541C85D26508E83_111326017;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_2094424304 = varB4EAC82CA7396A68D541C85D26508E83_1464165114;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_2094424304 = varB4EAC82CA7396A68D541C85D26508E83_522708138;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2094424304 = varB4EAC82CA7396A68D541C85D26508E83_954503842;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2094424304.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2094424304;
        
        
            
        
            
        
            
                    
                
            
                
                    
                
                    
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.575 -0400", hash_original_method = "A48D8CFCA0D4EF991F0CE4AA0090BC89", hash_generated_method = "24D5600D9455DB81214CCED290E97C99")
    public Router getRouter() {
        Router varB4EAC82CA7396A68D541C85D26508E83_1878305328 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1878305328 = this.router;
        varB4EAC82CA7396A68D541C85D26508E83_1878305328.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1878305328;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.575 -0400", hash_original_method = "DA20B42A9F145510C718334C692F5A76", hash_generated_method = "892A04214AC3824FBFBE453DBC29D5DD")
    public boolean isAlive() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_986618344 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_986618344;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.576 -0400", hash_original_method = "A1F941D6CE0FD78BF39EC8F9AC314942", hash_generated_method = "1A188872F7F3E0C8A138BDBB92F32142")
    protected void addMessageProcessor(MessageProcessor newMessageProcessor) throws IOException {
        {
            messageProcessors.add(newMessageProcessor);
        } 
        addTaint(newMessageProcessor.getTaint());
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.576 -0400", hash_original_method = "CFCCE7E1C39F0D41098F0FE9085A25D2", hash_generated_method = "7AF94A8889093D3E68E0BB53F61094F1")
    protected void removeMessageProcessor(MessageProcessor oldMessageProcessor) {
        {
            {
                boolean var7FEC726C44313EDFE272C9262D35B632_1834032734 = (messageProcessors.remove(oldMessageProcessor));
                {
                    oldMessageProcessor.stop();
                } 
            } 
        } 
        addTaint(oldMessageProcessor.getTaint());
        
        
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.577 -0400", hash_original_method = "B73144BB70E5C3E03C6EB8CA5C201D44", hash_generated_method = "11BA4D808DFEAC93048B16B067C29AEA")
    protected MessageProcessor[] getMessageProcessors() {
        MessageProcessor[] varB4EAC82CA7396A68D541C85D26508E83_1853177799 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1853177799 = (MessageProcessor[]) messageProcessors.toArray(new MessageProcessor[0]);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1853177799.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1853177799;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.579 -0400", hash_original_method = "923CC6809D53E2778E41D61552555A7F", hash_generated_method = "DB3B681EBD08C89C21B52DBE24CCC4B9")
    protected MessageProcessor createMessageProcessor(InetAddress ipAddress, int port,
            String transport) throws java.io.IOException {
        MessageProcessor varB4EAC82CA7396A68D541C85D26508E83_263751100 = null; 
        MessageProcessor varB4EAC82CA7396A68D541C85D26508E83_873226879 = null; 
        MessageProcessor varB4EAC82CA7396A68D541C85D26508E83_249458008 = null; 
        MessageProcessor varB4EAC82CA7396A68D541C85D26508E83_360358159 = null; 
        {
            boolean var7095C4F355EEA549877FC43E480D2092_644702545 = (transport.equalsIgnoreCase("udp"));
            {
                UDPMessageProcessor udpMessageProcessor = new UDPMessageProcessor(ipAddress, this,
                    port);
                this.addMessageProcessor(udpMessageProcessor);
                this.udpFlag = true;
                varB4EAC82CA7396A68D541C85D26508E83_263751100 = udpMessageProcessor;
            } 
            {
                boolean var7E17D01330C6FB4587DD37D1ACF5F9C6_93673503 = (transport.equalsIgnoreCase("tcp"));
                {
                    TCPMessageProcessor tcpMessageProcessor = new TCPMessageProcessor(ipAddress, this,
                    port);
                    this.addMessageProcessor(tcpMessageProcessor);
                    varB4EAC82CA7396A68D541C85D26508E83_873226879 = tcpMessageProcessor;
                } 
                {
                    boolean var5E363589F0885716BB91FFB4505BC89B_1144227512 = (transport.equalsIgnoreCase("tls"));
                    {
                        TLSMessageProcessor tlsMessageProcessor = new TLSMessageProcessor(ipAddress, this,
                    port);
                        this.addMessageProcessor(tlsMessageProcessor);
                        varB4EAC82CA7396A68D541C85D26508E83_249458008 = tlsMessageProcessor;
                    } 
                    {
                        boolean var11BAA59DFE2974D4AFA5B4D4F65EA219_230656805 = (transport.equalsIgnoreCase("sctp"));
                        {
                            try 
                            {
                                Class<?> mpc = ClassLoader.getSystemClassLoader().loadClass( "gov.nist.javax.sip.stack.sctp.SCTPMessageProcessor" );
                                MessageProcessor mp = (MessageProcessor) mpc.newInstance();
                                mp.initialize( ipAddress, port, this );
                                this.addMessageProcessor(mp);
                                varB4EAC82CA7396A68D541C85D26508E83_360358159 = mp;
                            } 
                            catch (ClassNotFoundException e)
                            {
                                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("SCTP not supported (needs Java 7 and SCTP jar in classpath)");
                            } 
                            catch (InstantiationException ie)
                            {
                                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Error initializing SCTP", ie);
                            } 
                            catch (IllegalAccessException ie)
                            {
                                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Error initializing SCTP", ie);
                            } 
                        } 
                        {
                            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("bad transport");
                        } 
                    } 
                } 
            } 
        } 
        addTaint(ipAddress.getTaint());
        addTaint(port);
        addTaint(transport.getTaint());
        MessageProcessor varA7E53CE21691AB073D9660D615818899_1177230213; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1177230213 = varB4EAC82CA7396A68D541C85D26508E83_263751100;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1177230213 = varB4EAC82CA7396A68D541C85D26508E83_873226879;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1177230213 = varB4EAC82CA7396A68D541C85D26508E83_249458008;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1177230213 = varB4EAC82CA7396A68D541C85D26508E83_360358159;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1177230213.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1177230213;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.580 -0400", hash_original_method = "B67F8BF0F619BF3DA8779F834D136A31", hash_generated_method = "A19418B518D97C741239C5FFDF8C7894")
    protected void setMessageFactory(StackMessageFactory messageFactory) {
        this.sipMessageFactory = messageFactory;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.583 -0400", hash_original_method = "79BA5457C24B1F2BABB705E59D2E5DE3", hash_generated_method = "93C36B9E0DC7C7179C92886267E461BE")
    public MessageChannel createRawMessageChannel(String sourceIpAddress, int sourcePort,
            Hop nextHop) throws UnknownHostException {
        MessageChannel varB4EAC82CA7396A68D541C85D26508E83_768459150 = null; 
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
            boolean var8CF1BBEBBFCBF1DC7D2F0931268CDCC1_1640502668 = (processorIterator.hasNext() && newChannel == null);
            {
                nextProcessor = (MessageProcessor) processorIterator.next();
                {
                    boolean varD30EC259292DB7E4155DAE7A640C45BC_747301224 = (nextHop.getTransport().equalsIgnoreCase(nextProcessor.getTransport())
                    && sourceIpAddress.equals(nextProcessor.getIpAddress().getHostAddress())
                    && sourcePort == nextProcessor.getPort());
                    {
                        try 
                        {
                            newChannel = nextProcessor.createMessageChannel(targetHostPort);
                        } 
                        catch (UnknownHostException ex)
                        {
                            {
                                boolean var337B2A9C9EA2BB40C001AEDF1FE004ED_2140488321 = (stackLogger.isLoggingEnabled());
                                stackLogger.logException(ex);
                            } 
                            if (DroidSafeAndroidRuntime.control) throw ex;
                        } 
                        catch (IOException e)
                        {
                            {
                                boolean var337B2A9C9EA2BB40C001AEDF1FE004ED_640024329 = (stackLogger.isLoggingEnabled());
                                stackLogger.logException(e);
                            } 
                        } 
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_768459150 = newChannel;
        addTaint(sourceIpAddress.getTaint());
        addTaint(sourcePort);
        addTaint(nextHop.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_768459150.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_768459150;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.584 -0400", hash_original_method = "35D04CBE96754834C212489B2C606D95", hash_generated_method = "7FE1730CFAF34F4FC28A9D257758A265")
    public boolean isEventForked(String ename) {
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_934177380 = (stackLogger.isLoggingEnabled());
            {
                stackLogger.logDebug("isEventForked: " + ename + " returning "
                    + this.forkedEvents.contains(ename));
            } 
        } 
        boolean var0487541C1220D18499AD3CEC1C1D9EAD_1282696884 = (this.forkedEvents.contains(ename));
        addTaint(ename.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_903979618 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_903979618;
        
        
            
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.585 -0400", hash_original_method = "8980F34FD4722FAAB08CBB90B3E36CA2", hash_generated_method = "BD1C230420E77AA7D250FC4AED38EA90")
    public AddressResolver getAddressResolver() {
        AddressResolver varB4EAC82CA7396A68D541C85D26508E83_586739317 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_586739317 = this.addressResolver;
        varB4EAC82CA7396A68D541C85D26508E83_586739317.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_586739317;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.585 -0400", hash_original_method = "3C1DAA52D018FB69E50FF9E6B399590F", hash_generated_method = "AB8878E125C4CAD1D1B4691B2D6499BB")
    public void setAddressResolver(AddressResolver addressResolver) {
        this.addressResolver = addressResolver;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.586 -0400", hash_original_method = "906B74670BE04C4A719BBC503CD663E5", hash_generated_method = "1BD4BE3CB90C933E977E9F9E4FB6AE5F")
    public void setLogRecordFactory(LogRecordFactory logRecordFactory) {
        this.logRecordFactory = logRecordFactory;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.588 -0400", hash_original_method = "2953BF87EC3C3B721F79C36C05ACD684", hash_generated_method = "09B06D818E606B60EBFF1DD1683CF702")
    public ThreadAuditor getThreadAuditor() {
        ThreadAuditor varB4EAC82CA7396A68D541C85D26508E83_825620908 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_825620908 = this.threadAuditor;
        varB4EAC82CA7396A68D541C85D26508E83_825620908.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_825620908;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.591 -0400", hash_original_method = "DA93EFB6297A5552E15BC0248101E996", hash_generated_method = "846B70A9092E6299973AA7E1CBC8C10D")
    public String auditStack(Set activeCallIDs, long leakedDialogTimer,
            long leakedTransactionTimer) {
        String varB4EAC82CA7396A68D541C85D26508E83_2101010765 = null; 
        String auditReport = null;
        String leakedDialogs = auditDialogs(activeCallIDs, leakedDialogTimer);
        String leakedServerTransactions = auditTransactions(serverTransactionTable,
                leakedTransactionTimer);
        String leakedClientTransactions = auditTransactions(clientTransactionTable,
                leakedTransactionTimer);
        {
            auditReport = "SIP Stack Audit:\n" + (leakedDialogs != null ? leakedDialogs : "")
                    + (leakedServerTransactions != null ? leakedServerTransactions : "")
                    + (leakedClientTransactions != null ? leakedClientTransactions : "");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2101010765 = auditReport;
        addTaint(activeCallIDs.getTaint());
        addTaint(leakedDialogTimer);
        addTaint(leakedTransactionTimer);
        varB4EAC82CA7396A68D541C85D26508E83_2101010765.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2101010765;
        
        
        
        
                
        
                
        
                
            
                    
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.595 -0400", hash_original_method = "5A76CC0B1A3067E5B9DACF3EB61E431C", hash_generated_method = "C6BAABFF6B47CDE9F6CFE54A3669C4FC")
    private String auditDialogs(Set activeCallIDs, long leakedDialogTimer) {
        String varB4EAC82CA7396A68D541C85D26508E83_143624850 = null; 
        String auditReport = "  Leaked dialogs:\n";
        int leakedDialogs = 0;
        long currentTime = System.currentTimeMillis();
        LinkedList dialogs;
        {
            dialogs = new LinkedList(dialogTable.values());
        } 
        Iterator it = dialogs.iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_269247274 = (it.hasNext());
            {
                SIPDialog itDialog = (SIPDialog) it.next();
                CallIdHeader callIdHeader = (itDialog != null ? itDialog.getCallId() : null);
                String callID = (callIdHeader != null ? callIdHeader.getCallId() : null);
                {
                    boolean varAD81098F41E3735D1602CF3776CF101D_929686476 = (itDialog != null && callID != null && !activeCallIDs.contains(callID));
                    {
                        {
                            itDialog.auditTag = currentTime;
                        } 
                        {
                            {
                                DialogState dialogState = itDialog.getState();
                                String dialogReport = "dialog id: " + itDialog.getDialogId()
                                + ", dialog state: "
                                + (dialogState != null ? dialogState.toString() : "null");
                                auditReport += "    " + dialogReport + "\n";
                                itDialog.setState(SIPDialog.TERMINATED_STATE);
                                {
                                    boolean var85803934B5461ABB2B9ECDE07C3FFDB4_2070512221 = (stackLogger.isLoggingEnabled());
                                    stackLogger.logDebug("auditDialogs: leaked " + dialogReport);
                                } 
                            } 
                        } 
                    } 
                } 
            } 
        } 
        {
            auditReport += "    Total: " + Integer.toString(leakedDialogs)
                    + " leaked dialogs detected and removed.\n";
        } 
        {
            auditReport = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_143624850 = auditReport;
        addTaint(activeCallIDs.getTaint());
        addTaint(leakedDialogTimer);
        varB4EAC82CA7396A68D541C85D26508E83_143624850.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_143624850;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.597 -0400", hash_original_method = "B29AC2188DE994EDE68B3EFDD85B41F1", hash_generated_method = "5F5F711BF8AFCFDB13ABAE50FBA9015B")
    private String auditTransactions(ConcurrentHashMap transactionsMap,
            long a_nLeakedTransactionTimer) {
        String varB4EAC82CA7396A68D541C85D26508E83_583912561 = null; 
        String auditReport = "  Leaked transactions:\n";
        int leakedTransactions = 0;
        long currentTime = System.currentTimeMillis();
        LinkedList transactionsList = new LinkedList(transactionsMap.values());
        Iterator it = transactionsList.iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1404333249 = (it.hasNext());
            {
                SIPTransaction sipTransaction = (SIPTransaction) it.next();
                {
                    {
                        sipTransaction.auditTag = currentTime;
                    } 
                    {
                        {
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
                            {
                                boolean varECF2FCB00A6D02E8BADBC36FDF09B326_415916801 = (isLoggingEnabled());
                                stackLogger.logDebug("auditTransactions: leaked " + transactionReport);
                            } 
                        } 
                    } 
                } 
            } 
        } 
        {
            auditReport += "    Total: " + Integer.toString(leakedTransactions)
                    + " leaked transactions detected and removed.\n";
        } 
        {
            auditReport = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_583912561 = auditReport;
        addTaint(transactionsMap.getTaint());
        addTaint(a_nLeakedTransactionTimer);
        varB4EAC82CA7396A68D541C85D26508E83_583912561.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_583912561;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.598 -0400", hash_original_method = "216776ED7A95FC4D69FC6626B7475336", hash_generated_method = "E8608B8CC182F06B0236B85EC551D976")
    public void setNon2XXAckPassedToListener(boolean passToListener) {
        this.non2XXAckPassedToListener = passToListener;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.598 -0400", hash_original_method = "6286CBBFF5CE6322EC732C5543B43EDA", hash_generated_method = "956004C810B1F94C5E868217463E9354")
    public boolean isNon2XXAckPassedToListener() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_901172501 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_901172501;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.599 -0400", hash_original_method = "39908A44D12AF4672A8DE059DC86C6F0", hash_generated_method = "1A0631D953053E250493652D3781DC27")
    public int getActiveClientTransactionCount() {
        int varF8FC6F0F03532C67FC8EC013C57CAF05_1526541199 = (activeClientTransactionCount.get());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_337334848 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_337334848;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.599 -0400", hash_original_method = "2D01936677D6715578D012ACFAF4D8A9", hash_generated_method = "323FBA11D49CF2ACCA99F4E56E4500FD")
    public boolean isRfc2543Supported() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1647426297 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1647426297;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.600 -0400", hash_original_method = "71493EE5805AD2AB9A60D51292B7773D", hash_generated_method = "446CBA1B37751D7618DF0913C947AA01")
    public boolean isCancelClientTransactionChecked() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2078044533 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2078044533;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.600 -0400", hash_original_method = "45004C11584D234E2C0351030C5C7691", hash_generated_method = "8E65FDA63B7436ACA940A7D49D6FFEF3")
    public boolean isRemoteTagReassignmentAllowed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1535984478 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1535984478;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.602 -0400", hash_original_method = "20ADA27D372C754940A803F19F3E7AD9", hash_generated_method = "76B387135D7FEFAADBF312BE3FB2177B")
    public Collection<Dialog> getDialogs() {
        Collection<Dialog> varB4EAC82CA7396A68D541C85D26508E83_126122940 = null; 
        HashSet<Dialog> dialogs = new HashSet<Dialog>();
        dialogs.addAll(this.dialogTable.values());
        dialogs.addAll(this.earlyDialogTable.values());
        varB4EAC82CA7396A68D541C85D26508E83_126122940 = dialogs;
        varB4EAC82CA7396A68D541C85D26508E83_126122940.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_126122940;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.610 -0400", hash_original_method = "9851D171868856682CD66D2C2C77C100", hash_generated_method = "7C0732400584E51180A4D1AC7264EC2C")
    public Collection<Dialog> getDialogs(DialogState state) {
        Collection<Dialog> varB4EAC82CA7396A68D541C85D26508E83_1841497649 = null; 
        HashSet<Dialog> matchingDialogs = new HashSet<Dialog>();
        {
            boolean var4484BD33CD3D459F91886F147843B739_1762104223 = (DialogState.EARLY.equals(state));
            {
                matchingDialogs.addAll(this.earlyDialogTable.values());
            } 
            {
                Collection<SIPDialog> dialogs = dialogTable.values();
                {
                    Iterator<SIPDialog> varAF4A62B1E6DB1A3E833F63312F30D56D_904902723 = (dialogs).iterator();
                    varAF4A62B1E6DB1A3E833F63312F30D56D_904902723.hasNext();
                    SIPDialog dialog = varAF4A62B1E6DB1A3E833F63312F30D56D_904902723.next();
                    {
                        {
                            boolean var2BB6D00E61F702FAA6D913BC8638615E_1704486896 = (dialog.getState() != null && dialog.getState().equals(state));
                            {
                                matchingDialogs.add(dialog);
                            } 
                        } 
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1841497649 = matchingDialogs;
        addTaint(state.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1841497649.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1841497649;
        
        
        
            
        
            
            
                
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.622 -0400", hash_original_method = "B020A334EC30ACCE61108F29E8239DE0", hash_generated_method = "3CB2306C419EC12C1DD6AF900A0BB546")
    public Dialog getReplacesDialog(ReplacesHeader replacesHeader) {
        Dialog varB4EAC82CA7396A68D541C85D26508E83_248184078 = null; 
        String cid = replacesHeader.getCallId();
        String fromTag = replacesHeader.getFromTag();
        String toTag = replacesHeader.getToTag();
        StringBuffer dialogId = new StringBuffer(cid);
        {
            dialogId.append(":");
            dialogId.append(toTag);
        } 
        {
            dialogId.append(":");
            dialogId.append(fromTag);
        } 
        String did = dialogId.toString().toLowerCase();
        {
            boolean varFDB7299A625AFEF73945BEA5BA395A9D_534582029 = (stackLogger.isLoggingEnabled());
            stackLogger.logDebug("Looking for dialog " + did);
        } 
        Dialog replacesDialog = this.dialogTable.get(did);
        {
            {
                Iterator<SIPClientTransaction> varEDF5DFD05164E4355382132B99DA269C_723139948 = (this.clientTransactionTable.values()).iterator();
                varEDF5DFD05164E4355382132B99DA269C_723139948.hasNext();
                SIPClientTransaction ctx = varEDF5DFD05164E4355382132B99DA269C_723139948.next();
                {
                    {
                        boolean varD9E48DC518AA5535EEDEFAF93267A4EE_635063517 = (ctx.getDialog(did) != null);
                        {
                            replacesDialog = ctx.getDialog(did);
                        } 
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_248184078 = replacesDialog;
        addTaint(replacesHeader.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_248184078.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_248184078;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.623 -0400", hash_original_method = "01BB795BEB07C4ED2A3CDD99078DB107", hash_generated_method = "0B8AFFD89A6E0B3D07CF0280ADFDEBB7")
    public Dialog getJoinDialog(JoinHeader joinHeader) {
        Dialog varB4EAC82CA7396A68D541C85D26508E83_1570729282 = null; 
        String cid = joinHeader.getCallId();
        String fromTag = joinHeader.getFromTag();
        String toTag = joinHeader.getToTag();
        StringBuffer retval = new StringBuffer(cid);
        {
            retval.append(":");
            retval.append(toTag);
        } 
        {
            retval.append(":");
            retval.append(fromTag);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1570729282 = this.dialogTable.get(retval.toString().toLowerCase());
        addTaint(joinHeader.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1570729282.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1570729282;
        
        
        
        
        
        
            
            
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.623 -0400", hash_original_method = "69B105104758CF3A0416D8C1D4F4DE0D", hash_generated_method = "7B24205D066AECCFC783C5A7FE5B727D")
    public void setTimer(Timer timer) {
        this.timer = timer;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.624 -0400", hash_original_method = "8E3D165A90C48C9C43C8115575D5D434", hash_generated_method = "3C7BA3AEECF7B3906DAF5707696DC68B")
    public Timer getTimer() {
        Timer varB4EAC82CA7396A68D541C85D26508E83_1410638884 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1410638884 = timer;
        varB4EAC82CA7396A68D541C85D26508E83_1410638884.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1410638884;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.624 -0400", hash_original_method = "535D845393F6631B713A5EAFAC15730B", hash_generated_method = "B7D87D124454272AA1E5192A4A706B5F")
    public int getReceiveUdpBufferSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_519978930 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_519978930;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.625 -0400", hash_original_method = "AD9781079D581597B87998F87481A2EF", hash_generated_method = "3CB289800444473A5EA7A106AC8D0F2E")
    public void setReceiveUdpBufferSize(int receiveUdpBufferSize) {
        this.receiveUdpBufferSize = receiveUdpBufferSize;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.626 -0400", hash_original_method = "7F1E49D75F179129A028D4152C30D3F6", hash_generated_method = "97DC3333C66508DCF49990849AC64F30")
    public int getSendUdpBufferSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1905871720 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1905871720;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.627 -0400", hash_original_method = "085E2E0AF6AC7C34DFF993E649718D81", hash_generated_method = "5FF890F4499E7F2DC05E16AEF2E489BA")
    public void setSendUdpBufferSize(int sendUdpBufferSize) {
        this.sendUdpBufferSize = sendUdpBufferSize;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.628 -0400", hash_original_method = "3649FCA00F1F012AB31400D887FE5668", hash_generated_method = "25F9CE48BE3D8A2B81401FE81559ECB5")
    public void setStackLogger(StackLogger stackLogger) {
        this.stackLogger = stackLogger;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.629 -0400", hash_original_method = "3A00FD245E091565EAC4D2A0BF135C63", hash_generated_method = "53E76278C34AE54D7BF5A13B88AB8627")
    public boolean checkBranchId() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_32177203 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_32177203;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.629 -0400", hash_original_method = "4B576FDEB92FCE56B4004D51F27F133D", hash_generated_method = "9045EE09E5612A4BCB84191DDFF57B6F")
    public void setLogStackTraceOnMessageSend(boolean logStackTraceOnMessageSend) {
        this.logStackTraceOnMessageSend = logStackTraceOnMessageSend;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.630 -0400", hash_original_method = "6EA33CFFB30E0EA85B4B3B5316E0B073", hash_generated_method = "EDB4D38320B7F631A7819C71704D1F37")
    public boolean isLogStackTraceOnMessageSend() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_479022387 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_479022387;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.630 -0400", hash_original_method = "BBC3144A1CF9CB1C9F37A775F293720F", hash_generated_method = "1AB264FBAA3C1AD042F7B5A0A41EB0AF")
    public void setDeliverDialogTerminatedEventForNullDialog() {
        this.isDialogTerminatedEventDeliveredForNullDialog = true;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.631 -0400", hash_original_method = "C791CC7BC6998146618C651EB49E3406", hash_generated_method = "08B4782FC6CB7D80BC5F7D8BB33D2C9C")
    public void addForkedClientTransaction(SIPClientTransaction clientTransaction) {
        this.forkedClientTransactionTable.put(clientTransaction.getTransactionId(), clientTransaction );
        addTaint(clientTransaction.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.631 -0400", hash_original_method = "A07C61DB9453AEA0A84C4416E8A5508E", hash_generated_method = "DB72E3F284CE3F8EA04B174E0327B754")
    public SIPClientTransaction getForkedTransaction(String transactionId) {
        SIPClientTransaction varB4EAC82CA7396A68D541C85D26508E83_492150082 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_492150082 = this.forkedClientTransactionTable.get(transactionId);
        addTaint(transactionId.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_492150082.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_492150082;
        
        
    }

    
    class PingTimer extends SIPStackTimerTask {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.631 -0400", hash_original_field = "BA4484AC61EF7F39E156EE38D51DF221", hash_generated_field = "3AE84B2399BFC1B1844D24A06D20C249")

        ThreadAuditor.ThreadHandle threadHandle;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.632 -0400", hash_original_method = "BD8473F7A826DDA501F390A58BAECB33", hash_generated_method = "AFD1D6DF671C7BCECC8041EEE49A6EBB")
        public  PingTimer(ThreadAuditor.ThreadHandle a_oThreadHandle) {
            threadHandle = a_oThreadHandle;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.632 -0400", hash_original_method = "D20FBACDA77D9F2BECED97C9063F3E91", hash_generated_method = "E3474560A4FD0FE526EF65032818B2CC")
        protected void runTask() {
            {
                boolean varC22F88379E8062191B8F0291837053FF_1882381618 = (getTimer() != null);
                {
                    {
                        threadHandle = getThreadAuditor().addCurrentThread();
                    } 
                    threadHandle.ping();
                    getTimer().schedule(new PingTimer(threadHandle),
                        threadHandle.getPingIntervalInMillisecs());
                } 
            } 
            
            
                
                    
                
                
                
                        
            
        }

        
    }


    
    class RemoveForkedTransactionTimerTask extends SIPStackTimerTask {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.632 -0400", hash_original_field = "7767C1945F1820BD26BE8F6047172E57", hash_generated_field = "346E85BD6DDF8042B729A2408B44CDD3")

        private SIPClientTransaction clientTransaction;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.633 -0400", hash_original_method = "D0A941D96C1666EFE3BE3721976F6AA6", hash_generated_method = "ABA505C7494D21E7D5CE259EA437DF15")
        public  RemoveForkedTransactionTimerTask(SIPClientTransaction sipClientTransaction ) {
            this.clientTransaction = sipClientTransaction;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.634 -0400", hash_original_method = "0A8A5E2C1505E2C2E84219D84E5444CF", hash_generated_method = "74E9473D704F21F1BB34BAE5007DACEC")
        @Override
        protected void runTask() {
            forkedClientTransactionTable.remove(clientTransaction.getTransactionId());
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.634 -0400", hash_original_field = "1270E8F52DAEA78D6688D9140DFF4221", hash_generated_field = "840B97A8669F66449D46242BA5765A0F")

    public static final int BASE_TIMER_INTERVAL = 500;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.634 -0400", hash_original_field = "9848A0B88D1FABCA8FBA5AB7FD5622BD", hash_generated_field = "F814FEC2CA6FC54407356E1DCD115382")

    public static final int CONNECTION_LINGER_TIME = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.634 -0400", hash_original_field = "19274966A28B7A0696AC55588DA87355", hash_generated_field = "2D1D1AE6B824DAFBEC80F6EDE67E49B0")

    protected static final Set<String> dialogCreatingMethods = new HashSet<String>();
    static {
    	dialogCreatingMethods.add(Request.REFER);
        dialogCreatingMethods.add(Request.INVITE);
        dialogCreatingMethods.add(Request.SUBSCRIBE);
    }
    
}

