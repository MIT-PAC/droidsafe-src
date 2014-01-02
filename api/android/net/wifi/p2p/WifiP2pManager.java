package android.net.wifi.p2p;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.HashMap;

import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

import com.android.internal.util.AsyncChannel;
import com.android.internal.util.Protocol;




public class WifiP2pManager {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.636 -0500", hash_original_field = "3BB7A8F6BB50B4B73B08E7CCAB5C6140", hash_generated_field = "60C1E150443611DF14BBCBAE33752417")

    private static final String TAG = "WifiP2pManager";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.639 -0500", hash_original_field = "288277B577FF300EB9224B92C12B2DDA", hash_generated_field = "0BE943666D99FABCCF2B2C59197D22BE")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String WIFI_P2P_STATE_CHANGED_ACTION =
        "android.net.wifi.p2p.STATE_CHANGED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.642 -0500", hash_original_field = "C0C34F1834F69EF98F2CABE4643C2311", hash_generated_field = "B4F038A53E0E35FD946B969A4DB84A99")

    public static final String EXTRA_WIFI_STATE = "wifi_p2p_state";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.644 -0500", hash_original_field = "BF43EE23C1F4CE4E384306C7D6C89BD4", hash_generated_field = "B541D56F69CE6B2483E8094DF6347297")

    public static final int WIFI_P2P_STATE_DISABLED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.646 -0500", hash_original_field = "7C06C2628B3C90A5014ABFCE058F17C2", hash_generated_field = "678E7DA1D1851DE6C658B191AB4A306B")

    public static final int WIFI_P2P_STATE_ENABLED = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.649 -0500", hash_original_field = "D339601FBF7E56B6633222F442A0850C", hash_generated_field = "073E7B4EC5D79527C899782030ECF86F")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String WIFI_P2P_CONNECTION_CHANGED_ACTION =
        "android.net.wifi.p2p.CONNECTION_STATE_CHANGE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.651 -0500", hash_original_field = "659C1802E785710FC13941F490C85BF0", hash_generated_field = "38B03D68A891E0E0787ACABFCB31A33B")

    public static final String EXTRA_WIFI_P2P_INFO = "wifiP2pInfo";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.653 -0500", hash_original_field = "921B5A99469139AF646DB6EF6429D0F0", hash_generated_field = "422031D57C1A9E39521E008A0CBF3B3C")

    public static final String EXTRA_NETWORK_INFO = "networkInfo";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.656 -0500", hash_original_field = "A9484BF33753D4C57F8ADB53299E0F23", hash_generated_field = "B2AF7393288899F9C62599EE162CC59A")

    public static final String EXTRA_LINK_PROPERTIES = "linkProperties";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.658 -0500", hash_original_field = "F53FDD402EE015BC952A768B8006B5EF", hash_generated_field = "2EE887A583B9775AF34213DD8E61A00E")

    public static final String EXTRA_LINK_CAPABILITIES = "linkCapabilities";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.661 -0500", hash_original_field = "B9F6033FC794FD8B11249DCD1AA35E70", hash_generated_field = "AEFA7EDFA76ECF85D060DD57B795B2CB")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String WIFI_P2P_PEERS_CHANGED_ACTION =
        "android.net.wifi.p2p.PEERS_CHANGED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.663 -0500", hash_original_field = "20B8870FF2947B34126BB2042BC30CEF", hash_generated_field = "85DA0816B3D525F86BDB7BA9F8D6CAC9")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String WIFI_P2P_THIS_DEVICE_CHANGED_ACTION =
        "android.net.wifi.p2p.THIS_DEVICE_CHANGED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.666 -0500", hash_original_field = "3C194CDF6CB2C683C855BBEE4E2650AA", hash_generated_field = "8FF2194332A97C33EDC346D34FDBC3CC")

    public static final String EXTRA_WIFI_P2P_DEVICE = "wifiP2pDevice";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.671 -0500", hash_original_field = "820AA681EFDE22694C9374B8689CEB3A", hash_generated_field = "B2327E7E8CB442C29251D0B90987B173")


    private static final int BASE = Protocol.BASE_WIFI_P2P_MANAGER;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.673 -0500", hash_original_field = "FCE90E758FD4872D2FAB97A2C821705F", hash_generated_field = "E2CBFBD4BAFA9BABF9DE67012EEB7D48")

    public static final int ENABLE_P2P                              = BASE + 1;

    
    public static class Channel {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.761 -0500", hash_original_field = "4A962768E924B3302D060CDFEED2D8E1", hash_generated_field = "21467B1B6B8E8EF3583A933A5A10E73B")

        private ChannelListener mChannelListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.763 -0500", hash_original_field = "8D4FC4AA090D513929059B605E8FAE73", hash_generated_field = "6A3AED8F9FA6C1FFD695D48BE328C5FE")

        private HashMap<Integer, Object> mListenerMap = new HashMap<Integer, Object>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.765 -0500", hash_original_field = "952510129F1E3014CCCAA50D14668A13", hash_generated_field = "32D016D75AFEC4D663625F60A7861763")

        private Object mListenerMapLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.767 -0500", hash_original_field = "B7E02615DD8862E0147680C81445F592", hash_generated_field = "0B8623FB96B9FE37C843B8CF421AA3A5")

        private int mListenerKey = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.769 -0500", hash_original_field = "DDBFF7075CEDA1D68CD8EBEE19E8EF07", hash_generated_field = "DDBFF7075CEDA1D68CD8EBEE19E8EF07")


        AsyncChannel mAsyncChannel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.771 -0500", hash_original_field = "71779ABFDFD5610585018E11388B9462", hash_generated_field = "71779ABFDFD5610585018E11388B9462")

        P2pHandler mHandler;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.758 -0500", hash_original_method = "CCBC86E649618B06362F4B186D38F77D", hash_generated_method = "CCBC86E649618B06362F4B186D38F77D")
        
Channel(Looper looper, ChannelListener l) {
            mAsyncChannel = new AsyncChannel();
            mHandler = new P2pHandler(looper);
            mChannelListener = l;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.783 -0500", hash_original_method = "0C1075F742095C1FC6722DFAFFAF85D8", hash_generated_method = "0C1075F742095C1FC6722DFAFFAF85D8")
        
int putListener(Object listener) {
            if (listener == null) return 0;
            int key;
            synchronized (mListenerMapLock) {
                key = mListenerKey++;
                mListenerMap.put(key, listener);
            }
            return key;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.785 -0500", hash_original_method = "464423DE95DD4D04CAAC6C3D80546690", hash_generated_method = "464423DE95DD4D04CAAC6C3D80546690")
        
Object getListener(int key) {
            synchronized (mListenerMapLock) {
                return mListenerMap.remove(key);
            }
        }

        
        class P2pHandler extends Handler {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.773 -0500", hash_original_method = "1A56C06271A8BC48B0210F0B84874BB3", hash_generated_method = "1A56C06271A8BC48B0210F0B84874BB3")
            
P2pHandler(Looper looper) {
                super(looper);
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.778 -0500", hash_original_method = "2063A6497661251530BCD9012E9E1E5C", hash_generated_method = "96FD0C2A1DA7132FC472B033A142C2C9")
            
@Override
            public void handleMessage(Message message) {
                Object listener = getListener(message.arg2);
                switch (message.what) {
                    case AsyncChannel.CMD_CHANNEL_DISCONNECTED:
                        if (mChannelListener != null) {
                            mChannelListener.onChannelDisconnected();
                            mChannelListener = null;
                        }
                        break;
                    /* ActionListeners grouped together */
                    case WifiP2pManager.DISCOVER_PEERS_FAILED:
                    case WifiP2pManager.CONNECT_FAILED:
                    case WifiP2pManager.CANCEL_CONNECT_FAILED:
                    case WifiP2pManager.CREATE_GROUP_FAILED:
                    case WifiP2pManager.REMOVE_GROUP_FAILED:
                        if (listener != null) {
                            ((ActionListener) listener).onFailure(message.arg1);
                        }
                        break;
                    /* ActionListeners grouped together */
                    case WifiP2pManager.DISCOVER_PEERS_SUCCEEDED:
                    case WifiP2pManager.CONNECT_SUCCEEDED:
                    case WifiP2pManager.CANCEL_CONNECT_SUCCEEDED:
                    case WifiP2pManager.CREATE_GROUP_SUCCEEDED:
                    case WifiP2pManager.REMOVE_GROUP_SUCCEEDED:
                        if (listener != null) {
                            ((ActionListener) listener).onSuccess();
                        }
                        break;
                    case WifiP2pManager.RESPONSE_PEERS:
                        WifiP2pDeviceList peers = (WifiP2pDeviceList) message.obj;
                        if (listener != null) {
                            ((PeerListListener) listener).onPeersAvailable(peers);
                        }
                        break;
                    case WifiP2pManager.RESPONSE_CONNECTION_INFO:
                        WifiP2pInfo wifiP2pInfo = (WifiP2pInfo) message.obj;
                        if (listener != null) {
                            ((ConnectionInfoListener) listener).onConnectionInfoAvailable(wifiP2pInfo);
                        }
                        break;
                    case WifiP2pManager.RESPONSE_GROUP_INFO:
                        WifiP2pGroup group = (WifiP2pGroup) message.obj;
                        if (listener != null) {
                            ((GroupInfoListener) listener).onGroupInfoAvailable(group);
                        }
                        break;
                   default:
                        Log.d(TAG, "Ignored " + message);
                        break;
                }
            }

            
        }


        
    }


    
    public interface ChannelListener {
        
        public void onChannelDisconnected();
    }
    
    public interface ActionListener {
        
        public void onSuccess();
        
        public void onFailure(int reason);
    }
    
    public interface PeerListListener {
        
        public void onPeersAvailable(WifiP2pDeviceList peers);
    }
    
    public interface ConnectionInfoListener {
        
        public void onConnectionInfoAvailable(WifiP2pInfo info);
    }
    
    public interface GroupInfoListener {
        
        public void onGroupInfoAvailable(WifiP2pGroup group);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.675 -0500", hash_original_field = "5E1B1AC77017D84819943BF67015D9E9", hash_generated_field = "842D9113C995AF1BEE59E95DB025DD8D")

    public static final int ENABLE_P2P_FAILED                       = BASE + 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.677 -0500", hash_original_field = "3419BA04C3CD21384C68E26E2AE63476", hash_generated_field = "B101131864F3C4B21D39E42E5F540D71")

    public static final int ENABLE_P2P_SUCCEEDED                    = BASE + 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.679 -0500", hash_original_field = "1AF4B1552F3B99FBB47C29E72D71AB4B", hash_generated_field = "80D2380D71C7EB19319B3F639D85B796")

    public static final int DISABLE_P2P                             = BASE + 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.682 -0500", hash_original_field = "8C27EEECE1D253A4602A5FCB9385FF6A", hash_generated_field = "7E17E1968A81641C8AA9FF76ACBE2207")

    public static final int DISABLE_P2P_FAILED                      = BASE + 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.684 -0500", hash_original_field = "68DEC3179716BE5A01049F136E6D62DB", hash_generated_field = "EABC88199A277B13539AD2CA49825B3C")

    public static final int DISABLE_P2P_SUCCEEDED                   = BASE + 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.687 -0500", hash_original_field = "84D37976C9BF397803B1544F92CE00F9", hash_generated_field = "873473486D2185DC05B0D4BCEFCF0637")

    public static final int DISCOVER_PEERS                          = BASE + 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.689 -0500", hash_original_field = "58F02184BAF56334F8FE36602EC13CD6", hash_generated_field = "C6E71E44CB63688619DF3884A931F3E9")

    public static final int DISCOVER_PEERS_FAILED                   = BASE + 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.691 -0500", hash_original_field = "ED47BB178D18B0B6BDEAED1D78344EB4", hash_generated_field = "28BC2CED492E4F4587F4714D92CA0C0A")

    public static final int DISCOVER_PEERS_SUCCEEDED                = BASE + 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.694 -0500", hash_original_field = "07D1CD3DBE6999778039804B2407CF1D", hash_generated_field = "3CE04203BA08022AC51B7A16B243F0D9")

    public static final int CONNECT                                 = BASE + 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.696 -0500", hash_original_field = "9712282FE6B7CD01FCA3D49ABE0161DA", hash_generated_field = "6828C0C050DB73222FBDDC4460790AFC")

    public static final int CONNECT_FAILED                          = BASE + 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.699 -0500", hash_original_field = "6D09D111FBB8E938F6D4484ED1EBDE52", hash_generated_field = "ADB826DBB5636DF6AF699C9F5A9B10D2")

    public static final int CONNECT_SUCCEEDED                       = BASE + 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.701 -0500", hash_original_field = "9D0D8CDB1D8A9559F46B82E2B76F12ED", hash_generated_field = "3A5E899B12EA2FCF4FF151597EBA0261")

    public static final int CANCEL_CONNECT                          = BASE + 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.703 -0500", hash_original_field = "B99E81FBAD15BEF3BEF956A1E139846A", hash_generated_field = "20D49525E077AF747C29EDF11C193F16")

    public static final int CANCEL_CONNECT_FAILED                   = BASE + 14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.705 -0500", hash_original_field = "15CF5865029BF05AA3D13C26F9199E2F", hash_generated_field = "F815097A23FA04A14F45C3A0F45464AA")

    public static final int CANCEL_CONNECT_SUCCEEDED                = BASE + 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.708 -0500", hash_original_field = "5717EE859B0971E01C48F97AE2F62007", hash_generated_field = "5B9FBB1A6854D27DCE51DF3D01A4B2B6")

    public static final int CREATE_GROUP                            = BASE + 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.710 -0500", hash_original_field = "F461B0C0B27288A0DABA152628A20FC2", hash_generated_field = "79BC29888449B6656E9E2E9038729B95")

    public static final int CREATE_GROUP_FAILED                     = BASE + 17;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.713 -0500", hash_original_field = "37784D7B65CB20311F8BAA8C7E5A8430", hash_generated_field = "334BCB945CEDDA2F4795FC4A7F10A0A7")

    public static final int CREATE_GROUP_SUCCEEDED                  = BASE + 18;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.715 -0500", hash_original_field = "53762A4D055847DACA929A204B1A941D", hash_generated_field = "3910927E1A26D60ECA9A04A1551052D5")

    public static final int REMOVE_GROUP                            = BASE + 19;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.717 -0500", hash_original_field = "6F94764BEA0F060D73260D8CA725C256", hash_generated_field = "BF65D09FF0D02197168421EF400201EA")

    public static final int REMOVE_GROUP_FAILED                     = BASE + 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.720 -0500", hash_original_field = "7B9F956A0066AF30EACA63DFF2E747CF", hash_generated_field = "D45AD53BB43974F5EA140DF24BBB78E5")

    public static final int REMOVE_GROUP_SUCCEEDED                  = BASE + 21;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.722 -0500", hash_original_field = "909EAF3E9A10027CDB1F23EB37A31580", hash_generated_field = "A52030B6A12A159456460E88129811BD")

    public static final int REQUEST_PEERS                           = BASE + 22;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.725 -0500", hash_original_field = "105EF45E1694A5221A4E0C82DF0B4C87", hash_generated_field = "30D42890A22A2BF0B0CD5C82D129F5F9")

    public static final int RESPONSE_PEERS                          = BASE + 23;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.727 -0500", hash_original_field = "0AC0AEEA1B93C805C4F71BB7085FE257", hash_generated_field = "ADB7AF3622DA8E945866D5717118CCF6")

    public static final int REQUEST_CONNECTION_INFO                 = BASE + 24;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.729 -0500", hash_original_field = "AAC0D0BFAE8CA7C835B20EA972342A2B", hash_generated_field = "0A8A4DFF96EA0D61C3B0486DDD63AEBF")

    public static final int RESPONSE_CONNECTION_INFO                = BASE + 25;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.732 -0500", hash_original_field = "F102E5E5BC07176152AA7A324B4C1CBA", hash_generated_field = "9F0788EC9024680E3A293ACAAC35B510")

    public static final int REQUEST_GROUP_INFO                      = BASE + 26;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.734 -0500", hash_original_field = "7D6B5939AB1140F90B6E58CE7885064B", hash_generated_field = "108793E00A46A0B5F9687FF23F2656A9")

    public static final int RESPONSE_GROUP_INFO                     = BASE + 27;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.739 -0500", hash_original_field = "3818D37471C32EB2E8D85595F8C80F86", hash_generated_field = "3797C4A7095177C075FD2048AF74BB88")

    public static final int ERROR               = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.741 -0500", hash_original_field = "F1C53128CB5B0410E964EA692D74C14E", hash_generated_field = "8889F37166918C34677A312B5A4E1F90")

    public static final int P2P_UNSUPPORTED     = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.743 -0500", hash_original_field = "478CA633877B08E36AD51398A4B39598", hash_generated_field = "9CF143A792B673B16F293366139BD455")

    public static final int BUSY                = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.668 -0500", hash_original_field = "BD8FB108D640F5B5A5EE463CD27A6D68", hash_generated_field = "BD8FB108D640F5B5A5EE463CD27A6D68")


    IWifiP2pManager mService;

    /**
     * Create a new WifiP2pManager instance. Applications use
     * {@link android.content.Context#getSystemService Context.getSystemService()} to retrieve
     * the standard {@link android.content.Context#WIFI_P2P_SERVICE Context.WIFI_P2P_SERVICE}.
     * @param service the Binder interface
     * @hide - hide this because it takes in a parameter of type IWifiP2pManager, which
     * is a system private class.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.736 -0500", hash_original_method = "E626A45256220AE3F4AF9F0577D669AE", hash_generated_method = "888055D3277F648B49B3AA2A9A79D490")
    
public WifiP2pManager(IWifiP2pManager service) {
        mService = service;
    }

    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.775 -0400", hash_original_method = "E626A45256220AE3F4AF9F0577D669AE", hash_generated_method = "AE4DAB67531AE0D3DD7CB41C112DC312")
    public  WifiP2pManager() {
        // ---------- Original Method ----------
        //mService = service;
    }

    /**
     * Registers the application with the Wi-Fi framework. This function
     * must be the first to be called before any p2p operations are performed.
     *
     * @param srcContext is the context of the source
     * @param srcLooper is the Looper on which the callbacks are receivied
     * @param listener for callback at loss of framework communication. Can be null.
     * @return Channel instance that is necessary for performing any further p2p operations
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.789 -0500", hash_original_method = "38C14B58266EB34A7D20FC8977BB0D6B", hash_generated_method = "D65DEFF42C3E352DC70A8DE408FA409B")
    
public Channel initialize(Context srcContext, Looper srcLooper, ChannelListener listener) {
        Messenger messenger = getMessenger();
        if (messenger == null) return null;

        Channel c = new Channel(srcLooper, listener);
        if (c.mAsyncChannel.connectSync(srcContext, c.mHandler, messenger)
                == AsyncChannel.STATUS_SUCCESSFUL) {
            return c;
        } else {
            return null;
        }
    }

    /**
     * Sends in a request to the system to enable p2p. This will pop up a dialog
     * to the user and upon authorization will enable p2p.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.791 -0500", hash_original_method = "980C8BB1CB1A99B001412F99FCE388F8", hash_generated_method = "F471934A7C768EBDB9558652E73C683E")
    
public void enableP2p(Channel c) {
        if (c == null) return;
        c.mAsyncChannel.sendMessage(ENABLE_P2P);
    }

    /**
     * Sends in a request to the system to disable p2p. This will pop up a dialog
     * to the user and upon authorization will enable p2p.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.793 -0500", hash_original_method = "7F5F0D1F2270C5CE1C0233D48C977521", hash_generated_method = "7DDE0C1B3056E704324EEB613AFFD5F9")
    
public void disableP2p(Channel c) {
        if (c == null) return;
        c.mAsyncChannel.sendMessage(DISABLE_P2P);
    }

    /**
     * Initiate peer discovery. A discovery process involves scanning for available Wi-Fi peers
     * for the purpose of establishing a connection.
     *
     * <p> The function call immediately returns after sending a discovery request
     * to the framework. The application is notified of a success or failure to initiate
     * discovery through listener callbacks {@link ActionListener#onSuccess} or
     * {@link ActionListener#onFailure}.
     *
     * <p> The discovery remains active until a connection is initiated or
     * a p2p group is formed. Register for {@link #WIFI_P2P_PEERS_CHANGED_ACTION} intent to
     * determine when the framework notifies of a change as peers are discovered.
     *
     * <p> Upon receiving a {@link #WIFI_P2P_PEERS_CHANGED_ACTION} intent, an application
     * can request for the list of peers using {@link #requestPeers}.
     *
     * @param c is the channel created at {@link #initialize}
     * @param listener for callbacks on success or failure. Can be null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.796 -0500", hash_original_method = "0086A0B598F8296D0733A67938A8010C", hash_generated_method = "DF728AF2A6B811E70B7B00BAAEC08F7C")
    
public void discoverPeers(Channel c, ActionListener listener) {
        if (c == null) return;
        c.mAsyncChannel.sendMessage(DISCOVER_PEERS, 0, c.putListener(listener));
    }

    /**
     * Start a p2p connection to a device with the specified configuration.
     *
     * <p> The function call immediately returns after sending a connection request
     * to the framework. The application is notified of a success or failure to initiate
     * connect through listener callbacks {@link ActionListener#onSuccess} or
     * {@link ActionListener#onFailure}.
     *
     * <p> Register for {@link #WIFI_P2P_CONNECTION_CHANGED_ACTION} intent to
     * determine when the framework notifies of a change in connectivity.
     *
     * <p> If the current device is not part of a p2p group, a connect request initiates
     * a group negotiation with the peer.
     *
     * <p> If the current device is part of an existing p2p group or has created
     * a p2p group with {@link #createGroup}, an invitation to join the group is sent to
     * the peer device.
     *
     * @param c is the channel created at {@link #initialize}
     * @param config options as described in {@link WifiP2pConfig} class
     * @param listener for callbacks on success or failure. Can be null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.798 -0500", hash_original_method = "4F415F11CAEDBF627AFEA3E6B5DED300", hash_generated_method = "A3C021B2B3E4C0DCA4D07C724F833947")
    
public void connect(Channel c, WifiP2pConfig config, ActionListener listener) {
        if (c == null) return;
        c.mAsyncChannel.sendMessage(CONNECT, 0, c.putListener(listener), config);
    }

    /**
     * Cancel any ongoing p2p group negotiation
     *
     * <p> The function call immediately returns after sending a connection cancellation request
     * to the framework. The application is notified of a success or failure to initiate
     * cancellation through listener callbacks {@link ActionListener#onSuccess} or
     * {@link ActionListener#onFailure}.
     *
     * @param c is the channel created at {@link #initialize}
     * @param listener for callbacks on success or failure. Can be null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.800 -0500", hash_original_method = "6933E398CD84814D8BC15F50F87022E9", hash_generated_method = "9590A0583AD092D696365AAF72D6F87A")
    
public void cancelConnect(Channel c, ActionListener listener) {
        if (c == null) return;
        c.mAsyncChannel.sendMessage(CANCEL_CONNECT, 0, c.putListener(listener));
    }

    /**
     * Create a p2p group with the current device as the group owner. This essentially creates
     * an access point that can accept connections from legacy clients as well as other p2p
     * devices.
     *
     * <p class="note"><strong>Note:</strong>
     * This function would normally not be used unless the current device needs
     * to form a p2p connection with a legacy client
     *
     * <p> The function call immediately returns after sending a group creation request
     * to the framework. The application is notified of a success or failure to initiate
     * group creation through listener callbacks {@link ActionListener#onSuccess} or
     * {@link ActionListener#onFailure}.
     *
     * <p> Application can request for the group details with {@link #requestGroupInfo}.
     *
     * @param c is the channel created at {@link #initialize}
     * @param listener for callbacks on success or failure. Can be null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.802 -0500", hash_original_method = "C4AE7F9F2250AB1A3A1291386F0E0989", hash_generated_method = "EFC504FA00F4FDDF4D5E42E93EF92675")
    
public void createGroup(Channel c, ActionListener listener) {
        if (c == null) return;
        c.mAsyncChannel.sendMessage(CREATE_GROUP, 0, c.putListener(listener));
    }

    /**
     * Remove the current p2p group.
     *
     * <p> The function call immediately returns after sending a group removal request
     * to the framework. The application is notified of a success or failure to initiate
     * group removal through listener callbacks {@link ActionListener#onSuccess} or
     * {@link ActionListener#onFailure}.
     *
     * @param c is the channel created at {@link #initialize}
     * @param listener for callbacks on success or failure. Can be null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.804 -0500", hash_original_method = "34A328438D8586940446A090FD763814", hash_generated_method = "7E34A7ECF37BDD96D387F1DA051693A6")
    
public void removeGroup(Channel c, ActionListener listener) {
        if (c == null) return;
        c.mAsyncChannel.sendMessage(REMOVE_GROUP, 0, c.putListener(listener));
    }

    /**
     * Request the current list of peers.
     *
     * @param c is the channel created at {@link #initialize}
     * @param listener for callback when peer list is available. Can be null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.807 -0500", hash_original_method = "694EBF25C431D0A14A1B93A99A392CFF", hash_generated_method = "B5C39F23F897642DFEA5CFE2EFB6D114")
    
public void requestPeers(Channel c, PeerListListener listener) {
        if (c == null) return;
        c.mAsyncChannel.sendMessage(REQUEST_PEERS, 0, c.putListener(listener));
    }

    /**
     * Request device connection info.
     *
     * @param c is the channel created at {@link #initialize}
     * @param listener for callback when connection info is available. Can be null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.809 -0500", hash_original_method = "F3A4F04EC67A346ED642EB6C8CC671D5", hash_generated_method = "8C500CC33DC85EC9E99A9B05AA8EBFD6")
    
public void requestConnectionInfo(Channel c, ConnectionInfoListener listener) {
        if (c == null) return;
        c.mAsyncChannel.sendMessage(REQUEST_CONNECTION_INFO, 0, c.putListener(listener));
    }

    /**
     * Request p2p group info.
     *
     * @param c is the channel created at {@link #initialize}
     * @param listener for callback when group info is available. Can be null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.812 -0500", hash_original_method = "7D2D3B8E934838E23E15D5EFD9489887", hash_generated_method = "BE20F831DEBB442923C6C2AB4B220EBD")
    
public void requestGroupInfo(Channel c, GroupInfoListener listener) {
        if (c == null) return;
        c.mAsyncChannel.sendMessage(REQUEST_GROUP_INFO, 0, c.putListener(listener));
    }

    /**
     * Get a reference to WifiP2pService handler. This is used to establish
     * an AsyncChannel communication with WifiService
     *
     * @return Messenger pointing to the WifiP2pService handler
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:01.814 -0500", hash_original_method = "A358F8361C96DABE1A63B04B5804B3F5", hash_generated_method = "DA6144D34D1ABFD0D2380EC6E44B953A")
    
public Messenger getMessenger() {
        try {
            return mService.getMessenger();
        } catch (RemoteException e) {
            return null;
        }
    }
}

