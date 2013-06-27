package android.net.wifi.p2p;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.IConnectivityManager;
import android.os.Binder;
import android.os.IBinder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.WorkSource;
import android.os.Messenger;
import android.util.Log;
import com.android.internal.util.AsyncChannel;
import com.android.internal.util.Protocol;
import java.util.HashMap;

public class WifiP2pManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.869 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "BD8FB108D640F5B5A5EE463CD27A6D68")

    IWifiP2pManager mService;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.869 -0400", hash_original_method = "E626A45256220AE3F4AF9F0577D669AE", hash_generated_method = "AE4DAB67531AE0D3DD7CB41C112DC312")
    public  WifiP2pManager(IWifiP2pManager service) {
        mService = service;
        // ---------- Original Method ----------
        //mService = service;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.871 -0400", hash_original_method = "38C14B58266EB34A7D20FC8977BB0D6B", hash_generated_method = "885DEABEF48ED8D4239591941798D658")
    public Channel initialize(Context srcContext, Looper srcLooper, ChannelListener listener) {
        Channel varB4EAC82CA7396A68D541C85D26508E83_878877842 = null; //Variable for return #1
        Channel varB4EAC82CA7396A68D541C85D26508E83_1533218501 = null; //Variable for return #2
        Channel varB4EAC82CA7396A68D541C85D26508E83_436763018 = null; //Variable for return #3
        Messenger messenger;
        messenger = getMessenger();
        varB4EAC82CA7396A68D541C85D26508E83_878877842 = null;
        Channel c;
        c = new Channel(srcLooper, listener);
        {
            boolean var760266D613BB58F7090531F7CC73134F_669929637 = (c.mAsyncChannel.connectSync(srcContext, c.mHandler, messenger)
                == AsyncChannel.STATUS_SUCCESSFUL);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1533218501 = c;
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_436763018 = null;
            } //End block
        } //End collapsed parenthetic
        addTaint(srcContext.getTaint());
        addTaint(srcLooper.getTaint());
        addTaint(listener.getTaint());
        Channel varA7E53CE21691AB073D9660D615818899_745582673; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_745582673 = varB4EAC82CA7396A68D541C85D26508E83_878877842;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_745582673 = varB4EAC82CA7396A68D541C85D26508E83_1533218501;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_745582673 = varB4EAC82CA7396A68D541C85D26508E83_436763018;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_745582673.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_745582673;
        // ---------- Original Method ----------
        //Messenger messenger = getMessenger();
        //if (messenger == null) return null;
        //Channel c = new Channel(srcLooper, listener);
        //if (c.mAsyncChannel.connectSync(srcContext, c.mHandler, messenger)
                //== AsyncChannel.STATUS_SUCCESSFUL) {
            //return c;
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.872 -0400", hash_original_method = "980C8BB1CB1A99B001412F99FCE388F8", hash_generated_method = "FA4AC63EF430395F2EC8881E70A34D8F")
    public void enableP2p(Channel c) {
        c.mAsyncChannel.sendMessage(ENABLE_P2P);
        addTaint(c.getTaint());
        // ---------- Original Method ----------
        //if (c == null) return;
        //c.mAsyncChannel.sendMessage(ENABLE_P2P);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.873 -0400", hash_original_method = "7F5F0D1F2270C5CE1C0233D48C977521", hash_generated_method = "EBF0CD9A8326A0C2C10F61C708DD6036")
    public void disableP2p(Channel c) {
        c.mAsyncChannel.sendMessage(DISABLE_P2P);
        addTaint(c.getTaint());
        // ---------- Original Method ----------
        //if (c == null) return;
        //c.mAsyncChannel.sendMessage(DISABLE_P2P);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.901 -0400", hash_original_method = "0086A0B598F8296D0733A67938A8010C", hash_generated_method = "756168F6A95AD001CEEB1ADB8578650B")
    public void discoverPeers(Channel c, ActionListener listener) {
        c.mAsyncChannel.sendMessage(DISCOVER_PEERS, 0, c.putListener(listener));
        addTaint(c.getTaint());
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //if (c == null) return;
        //c.mAsyncChannel.sendMessage(DISCOVER_PEERS, 0, c.putListener(listener));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.907 -0400", hash_original_method = "4F415F11CAEDBF627AFEA3E6B5DED300", hash_generated_method = "424DC2A8357B1DA100CBB4A01C345CDE")
    public void connect(Channel c, WifiP2pConfig config, ActionListener listener) {
        c.mAsyncChannel.sendMessage(CONNECT, 0, c.putListener(listener), config);
        addTaint(c.getTaint());
        addTaint(config.getTaint());
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //if (c == null) return;
        //c.mAsyncChannel.sendMessage(CONNECT, 0, c.putListener(listener), config);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.908 -0400", hash_original_method = "6933E398CD84814D8BC15F50F87022E9", hash_generated_method = "B6D60EBEC6EB4BD1FFC636EA76C1973F")
    public void cancelConnect(Channel c, ActionListener listener) {
        c.mAsyncChannel.sendMessage(CANCEL_CONNECT, 0, c.putListener(listener));
        addTaint(c.getTaint());
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //if (c == null) return;
        //c.mAsyncChannel.sendMessage(CANCEL_CONNECT, 0, c.putListener(listener));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.909 -0400", hash_original_method = "C4AE7F9F2250AB1A3A1291386F0E0989", hash_generated_method = "297C3AD0879D4A242CD2366DA25FA03B")
    public void createGroup(Channel c, ActionListener listener) {
        c.mAsyncChannel.sendMessage(CREATE_GROUP, 0, c.putListener(listener));
        addTaint(c.getTaint());
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //if (c == null) return;
        //c.mAsyncChannel.sendMessage(CREATE_GROUP, 0, c.putListener(listener));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.914 -0400", hash_original_method = "34A328438D8586940446A090FD763814", hash_generated_method = "04AB6372DBA35842794C990D04C82281")
    public void removeGroup(Channel c, ActionListener listener) {
        c.mAsyncChannel.sendMessage(REMOVE_GROUP, 0, c.putListener(listener));
        addTaint(c.getTaint());
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //if (c == null) return;
        //c.mAsyncChannel.sendMessage(REMOVE_GROUP, 0, c.putListener(listener));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.915 -0400", hash_original_method = "694EBF25C431D0A14A1B93A99A392CFF", hash_generated_method = "C263E08F685125096CC2AA55E45CD717")
    public void requestPeers(Channel c, PeerListListener listener) {
        c.mAsyncChannel.sendMessage(REQUEST_PEERS, 0, c.putListener(listener));
        addTaint(c.getTaint());
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //if (c == null) return;
        //c.mAsyncChannel.sendMessage(REQUEST_PEERS, 0, c.putListener(listener));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.916 -0400", hash_original_method = "F3A4F04EC67A346ED642EB6C8CC671D5", hash_generated_method = "F06BC277C18C86E93A9C3D371CF8F44D")
    public void requestConnectionInfo(Channel c, ConnectionInfoListener listener) {
        c.mAsyncChannel.sendMessage(REQUEST_CONNECTION_INFO, 0, c.putListener(listener));
        addTaint(c.getTaint());
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //if (c == null) return;
        //c.mAsyncChannel.sendMessage(REQUEST_CONNECTION_INFO, 0, c.putListener(listener));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.919 -0400", hash_original_method = "7D2D3B8E934838E23E15D5EFD9489887", hash_generated_method = "4AED3AF9088DE31E428FF41016720196")
    public void requestGroupInfo(Channel c, GroupInfoListener listener) {
        c.mAsyncChannel.sendMessage(REQUEST_GROUP_INFO, 0, c.putListener(listener));
        addTaint(c.getTaint());
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //if (c == null) return;
        //c.mAsyncChannel.sendMessage(REQUEST_GROUP_INFO, 0, c.putListener(listener));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.935 -0400", hash_original_method = "A358F8361C96DABE1A63B04B5804B3F5", hash_generated_method = "B4D172D84E741692A1F44EFBE7FB7974")
    public Messenger getMessenger() {
        Messenger varB4EAC82CA7396A68D541C85D26508E83_2033637064 = null; //Variable for return #1
        Messenger varB4EAC82CA7396A68D541C85D26508E83_111566017 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2033637064 = mService.getMessenger();
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_111566017 = null;
        } //End block
        Messenger varA7E53CE21691AB073D9660D615818899_1317478038; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1317478038 = varB4EAC82CA7396A68D541C85D26508E83_2033637064;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1317478038 = varB4EAC82CA7396A68D541C85D26508E83_111566017;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1317478038.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1317478038;
        // ---------- Original Method ----------
        //try {
            //return mService.getMessenger();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    public static class Channel {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.936 -0400", hash_original_field = "0D438B1ED9CDBB261B59CCF16683F78E", hash_generated_field = "21467B1B6B8E8EF3583A933A5A10E73B")

        private ChannelListener mChannelListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.936 -0400", hash_original_field = "73BE67D92B4197B6480747CA81AFEF3D", hash_generated_field = "6A3AED8F9FA6C1FFD695D48BE328C5FE")

        private HashMap<Integer, Object> mListenerMap = new HashMap<Integer, Object>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.936 -0400", hash_original_field = "B381B764C2AC475C34169FE408E4449B", hash_generated_field = "32D016D75AFEC4D663625F60A7861763")

        private Object mListenerMapLock = new Object();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.936 -0400", hash_original_field = "E34126D275CBB38E791CBBF5CA51638B", hash_generated_field = "0B8623FB96B9FE37C843B8CF421AA3A5")

        private int mListenerKey = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.936 -0400", hash_original_field = "62BC6FE68D2313A76AFEFDFD1F7A12A0", hash_generated_field = "DDBFF7075CEDA1D68CD8EBEE19E8EF07")

        AsyncChannel mAsyncChannel;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.936 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "71779ABFDFD5610585018E11388B9462")

        P2pHandler mHandler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.938 -0400", hash_original_method = "CCBC86E649618B06362F4B186D38F77D", hash_generated_method = "A3FF119C5F4BDBD5BFE2F418DA8E085E")
          Channel(Looper looper, ChannelListener l) {
            mAsyncChannel = new AsyncChannel();
            mHandler = new P2pHandler(looper);
            mChannelListener = l;
            // ---------- Original Method ----------
            //mAsyncChannel = new AsyncChannel();
            //mHandler = new P2pHandler(looper);
            //mChannelListener = l;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.938 -0400", hash_original_method = "0C1075F742095C1FC6722DFAFFAF85D8", hash_generated_method = "4152F27639A86B4CFACE96A46B320045")
         int putListener(Object listener) {
            int key;
            {
                key = mListenerKey++;
                mListenerMap.put(key, listener);
            } //End block
            addTaint(listener.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1113905028 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1113905028;
            // ---------- Original Method ----------
            //if (listener == null) return 0;
            //int key;
            //synchronized (mListenerMapLock) {
                //key = mListenerKey++;
                //mListenerMap.put(key, listener);
            //}
            //return key;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.955 -0400", hash_original_method = "464423DE95DD4D04CAAC6C3D80546690", hash_generated_method = "8F3FEAD588516E104039E2609DFB16FE")
         Object getListener(int key) {
            Object varB4EAC82CA7396A68D541C85D26508E83_879043868 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_879043868 = mListenerMap.remove(key);
            } //End block
            addTaint(key);
            varB4EAC82CA7396A68D541C85D26508E83_879043868.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_879043868;
            // ---------- Original Method ----------
            //synchronized (mListenerMapLock) {
                //return mListenerMap.remove(key);
            //}
        }

        
        class P2pHandler extends Handler {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.956 -0400", hash_original_method = "1A56C06271A8BC48B0210F0B84874BB3", hash_generated_method = "2CB74D8E1E58A50B1B9DA9CA2B12C083")
              P2pHandler(Looper looper) {
                super(looper);
                addTaint(looper.getTaint());
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.960 -0400", hash_original_method = "2063A6497661251530BCD9012E9E1E5C", hash_generated_method = "62137B823EDE8EA7D256A1FF524F3DC5")
            @Override
            public void handleMessage(Message message) {
                Object listener;
                listener = getListener(message.arg2);
                //Begin case AsyncChannel.CMD_CHANNEL_DISCONNECTED 
                {
                    mChannelListener.onChannelDisconnected();
                    mChannelListener = null;
                } //End block
                //End case AsyncChannel.CMD_CHANNEL_DISCONNECTED 
                //Begin case WifiP2pManager.DISCOVER_PEERS_FAILED WifiP2pManager.CONNECT_FAILED WifiP2pManager.CANCEL_CONNECT_FAILED WifiP2pManager.CREATE_GROUP_FAILED WifiP2pManager.REMOVE_GROUP_FAILED 
                {
                    ((ActionListener) listener).onFailure(message.arg1);
                } //End block
                //End case WifiP2pManager.DISCOVER_PEERS_FAILED WifiP2pManager.CONNECT_FAILED WifiP2pManager.CANCEL_CONNECT_FAILED WifiP2pManager.CREATE_GROUP_FAILED WifiP2pManager.REMOVE_GROUP_FAILED 
                //Begin case WifiP2pManager.DISCOVER_PEERS_SUCCEEDED WifiP2pManager.CONNECT_SUCCEEDED WifiP2pManager.CANCEL_CONNECT_SUCCEEDED WifiP2pManager.CREATE_GROUP_SUCCEEDED WifiP2pManager.REMOVE_GROUP_SUCCEEDED 
                {
                    ((ActionListener) listener).onSuccess();
                } //End block
                //End case WifiP2pManager.DISCOVER_PEERS_SUCCEEDED WifiP2pManager.CONNECT_SUCCEEDED WifiP2pManager.CANCEL_CONNECT_SUCCEEDED WifiP2pManager.CREATE_GROUP_SUCCEEDED WifiP2pManager.REMOVE_GROUP_SUCCEEDED 
                //Begin case WifiP2pManager.RESPONSE_PEERS 
                WifiP2pDeviceList peers;
                peers = (WifiP2pDeviceList) message.obj;
                //End case WifiP2pManager.RESPONSE_PEERS 
                //Begin case WifiP2pManager.RESPONSE_PEERS 
                {
                    ((PeerListListener) listener).onPeersAvailable(peers);
                } //End block
                //End case WifiP2pManager.RESPONSE_PEERS 
                //Begin case WifiP2pManager.RESPONSE_CONNECTION_INFO 
                WifiP2pInfo wifiP2pInfo;
                wifiP2pInfo = (WifiP2pInfo) message.obj;
                //End case WifiP2pManager.RESPONSE_CONNECTION_INFO 
                //Begin case WifiP2pManager.RESPONSE_CONNECTION_INFO 
                {
                    ((ConnectionInfoListener) listener).onConnectionInfoAvailable(wifiP2pInfo);
                } //End block
                //End case WifiP2pManager.RESPONSE_CONNECTION_INFO 
                //Begin case WifiP2pManager.RESPONSE_GROUP_INFO 
                WifiP2pGroup group;
                group = (WifiP2pGroup) message.obj;
                //End case WifiP2pManager.RESPONSE_GROUP_INFO 
                //Begin case WifiP2pManager.RESPONSE_GROUP_INFO 
                {
                    ((GroupInfoListener) listener).onGroupInfoAvailable(group);
                } //End block
                //End case WifiP2pManager.RESPONSE_GROUP_INFO 
                //Begin case default 
                Log.d(TAG, "Ignored " + message);
                //End case default 
                addTaint(message.getTaint());
                // ---------- Original Method ----------
                // Original Method Too Long, Refer to Original Implementation
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.977 -0400", hash_original_field = "5371C5FD0DCD996C85DDF0B53BE80D6A", hash_generated_field = "9DFF8C8B6F1FF0AD60969A1D9CC86500")

    private static String TAG = "WifiP2pManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.977 -0400", hash_original_field = "36FA1347F516E48534B07CEBB7F4DB7A", hash_generated_field = "0BE943666D99FABCCF2B2C59197D22BE")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String WIFI_P2P_STATE_CHANGED_ACTION =
        "android.net.wifi.p2p.STATE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.978 -0400", hash_original_field = "1D1A4C97BA86F58C9EDCBA0606A5D764", hash_generated_field = "B4F038A53E0E35FD946B969A4DB84A99")

    public static final String EXTRA_WIFI_STATE = "wifi_p2p_state";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.978 -0400", hash_original_field = "AF3E2BB3FC4B2A138EAE5AE8639FF19B", hash_generated_field = "B541D56F69CE6B2483E8094DF6347297")

    public static final int WIFI_P2P_STATE_DISABLED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.978 -0400", hash_original_field = "4F20914F0F69BC30260F867A90974BC9", hash_generated_field = "678E7DA1D1851DE6C658B191AB4A306B")

    public static final int WIFI_P2P_STATE_ENABLED = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.978 -0400", hash_original_field = "296D71F228FE3137268D86CFF6902A51", hash_generated_field = "073E7B4EC5D79527C899782030ECF86F")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String WIFI_P2P_CONNECTION_CHANGED_ACTION =
        "android.net.wifi.p2p.CONNECTION_STATE_CHANGE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.978 -0400", hash_original_field = "67914DADF6D73A4063E5A0177A10A8B9", hash_generated_field = "38B03D68A891E0E0787ACABFCB31A33B")

    public static final String EXTRA_WIFI_P2P_INFO = "wifiP2pInfo";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.978 -0400", hash_original_field = "ACAA90A79946019658CF4D2C0E90FC45", hash_generated_field = "422031D57C1A9E39521E008A0CBF3B3C")

    public static final String EXTRA_NETWORK_INFO = "networkInfo";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.978 -0400", hash_original_field = "DAC37E4448A17DAA0BDB854C0225CA4C", hash_generated_field = "B2AF7393288899F9C62599EE162CC59A")

    public static final String EXTRA_LINK_PROPERTIES = "linkProperties";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.978 -0400", hash_original_field = "7DFD46BB73461CD7286B9FDCCCA83168", hash_generated_field = "2EE887A583B9775AF34213DD8E61A00E")

    public static final String EXTRA_LINK_CAPABILITIES = "linkCapabilities";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.978 -0400", hash_original_field = "630595BB30186451DA5AD57DC3132856", hash_generated_field = "AEFA7EDFA76ECF85D060DD57B795B2CB")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String WIFI_P2P_PEERS_CHANGED_ACTION =
        "android.net.wifi.p2p.PEERS_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.978 -0400", hash_original_field = "19720BED08870CA46D06DF57F662D9D7", hash_generated_field = "85DA0816B3D525F86BDB7BA9F8D6CAC9")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String WIFI_P2P_THIS_DEVICE_CHANGED_ACTION =
        "android.net.wifi.p2p.THIS_DEVICE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.978 -0400", hash_original_field = "00732CF6D435250E69AD49D2C31C059C", hash_generated_field = "8FF2194332A97C33EDC346D34FDBC3CC")

    public static final String EXTRA_WIFI_P2P_DEVICE = "wifiP2pDevice";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.978 -0400", hash_original_field = "79134A1DB8ECC76AEFF50843332E355F", hash_generated_field = "2C6B311258E86D8738457B4C0E7B0612")

    private static int BASE = Protocol.BASE_WIFI_P2P_MANAGER;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.978 -0400", hash_original_field = "2FB92A8AB7D7A49C8E65E9ECB4689F3E", hash_generated_field = "E2CBFBD4BAFA9BABF9DE67012EEB7D48")

    public static final int ENABLE_P2P                              = BASE + 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.978 -0400", hash_original_field = "506185DB23367D00D72355ED0DBF7BF6", hash_generated_field = "842D9113C995AF1BEE59E95DB025DD8D")

    public static final int ENABLE_P2P_FAILED                       = BASE + 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.978 -0400", hash_original_field = "95B42FE0A39762E3E46B027ED2148B17", hash_generated_field = "B101131864F3C4B21D39E42E5F540D71")

    public static final int ENABLE_P2P_SUCCEEDED                    = BASE + 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.979 -0400", hash_original_field = "65AD9A7A59EE3C1C24020343AF958809", hash_generated_field = "80D2380D71C7EB19319B3F639D85B796")

    public static final int DISABLE_P2P                             = BASE + 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.979 -0400", hash_original_field = "4199E2F3EA06283A74BAB696E0208F40", hash_generated_field = "7E17E1968A81641C8AA9FF76ACBE2207")

    public static final int DISABLE_P2P_FAILED                      = BASE + 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.979 -0400", hash_original_field = "C71C1995152CB0C9F436BB91D82E7CD4", hash_generated_field = "EABC88199A277B13539AD2CA49825B3C")

    public static final int DISABLE_P2P_SUCCEEDED                   = BASE + 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.979 -0400", hash_original_field = "12B6AE4B477A1DA06F75753FB3B84DAC", hash_generated_field = "873473486D2185DC05B0D4BCEFCF0637")

    public static final int DISCOVER_PEERS                          = BASE + 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.979 -0400", hash_original_field = "40C9D154D4A28244585B674F79E2C89C", hash_generated_field = "C6E71E44CB63688619DF3884A931F3E9")

    public static final int DISCOVER_PEERS_FAILED                   = BASE + 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.979 -0400", hash_original_field = "D69AB6BD9F62F63CC483F071902D0D36", hash_generated_field = "28BC2CED492E4F4587F4714D92CA0C0A")

    public static final int DISCOVER_PEERS_SUCCEEDED                = BASE + 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.979 -0400", hash_original_field = "B01C6881511EDB369B1BF3E415B19809", hash_generated_field = "3CE04203BA08022AC51B7A16B243F0D9")

    public static final int CONNECT                                 = BASE + 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.979 -0400", hash_original_field = "974FD4A927137399E5EF11DADAE6679C", hash_generated_field = "6828C0C050DB73222FBDDC4460790AFC")

    public static final int CONNECT_FAILED                          = BASE + 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.979 -0400", hash_original_field = "04B473375B8E73260D2A9593557C34CD", hash_generated_field = "ADB826DBB5636DF6AF699C9F5A9B10D2")

    public static final int CONNECT_SUCCEEDED                       = BASE + 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.979 -0400", hash_original_field = "2AE00A8D5B6D8C91534943A545F767F9", hash_generated_field = "3A5E899B12EA2FCF4FF151597EBA0261")

    public static final int CANCEL_CONNECT                          = BASE + 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.979 -0400", hash_original_field = "A35D3898438CD53D046A4CE591235133", hash_generated_field = "20D49525E077AF747C29EDF11C193F16")

    public static final int CANCEL_CONNECT_FAILED                   = BASE + 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.979 -0400", hash_original_field = "2FAC414B504F885A97AAF17BD8702B24", hash_generated_field = "F815097A23FA04A14F45C3A0F45464AA")

    public static final int CANCEL_CONNECT_SUCCEEDED                = BASE + 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.979 -0400", hash_original_field = "1001EF6BE56A0359D0B74E0F01E04E4C", hash_generated_field = "5B9FBB1A6854D27DCE51DF3D01A4B2B6")

    public static final int CREATE_GROUP                            = BASE + 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.979 -0400", hash_original_field = "F9797B00B84D62AD6439A22C184DC3C9", hash_generated_field = "79BC29888449B6656E9E2E9038729B95")

    public static final int CREATE_GROUP_FAILED                     = BASE + 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.979 -0400", hash_original_field = "36D9B4624141D25590A95853CACD5972", hash_generated_field = "334BCB945CEDDA2F4795FC4A7F10A0A7")

    public static final int CREATE_GROUP_SUCCEEDED                  = BASE + 18;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.979 -0400", hash_original_field = "216BBD5ABA48FFCB968AE2200A873D2E", hash_generated_field = "3910927E1A26D60ECA9A04A1551052D5")

    public static final int REMOVE_GROUP                            = BASE + 19;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.979 -0400", hash_original_field = "4ED1A1774C524D62C42E4CDDACB37461", hash_generated_field = "BF65D09FF0D02197168421EF400201EA")

    public static final int REMOVE_GROUP_FAILED                     = BASE + 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.980 -0400", hash_original_field = "6FDE578EFD6925D70217B3C87CDAF777", hash_generated_field = "D45AD53BB43974F5EA140DF24BBB78E5")

    public static final int REMOVE_GROUP_SUCCEEDED                  = BASE + 21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.980 -0400", hash_original_field = "26DDD7D96B898D8A08EB311DF1F56EB7", hash_generated_field = "A52030B6A12A159456460E88129811BD")

    public static final int REQUEST_PEERS                           = BASE + 22;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.993 -0400", hash_original_field = "7EB00D8E32DDBE0942C1FE1E5AAD65BD", hash_generated_field = "30D42890A22A2BF0B0CD5C82D129F5F9")

    public static final int RESPONSE_PEERS                          = BASE + 23;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.993 -0400", hash_original_field = "67967CE3DC2DE18818CA70EF0090A2AE", hash_generated_field = "ADB7AF3622DA8E945866D5717118CCF6")

    public static final int REQUEST_CONNECTION_INFO                 = BASE + 24;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.993 -0400", hash_original_field = "AC531CC41288AC028DE0EE5AE0F4C7B8", hash_generated_field = "0A8A4DFF96EA0D61C3B0486DDD63AEBF")

    public static final int RESPONSE_CONNECTION_INFO                = BASE + 25;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.993 -0400", hash_original_field = "DC83BE2201AC47B19B246DBA70910591", hash_generated_field = "9F0788EC9024680E3A293ACAAC35B510")

    public static final int REQUEST_GROUP_INFO                      = BASE + 26;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.994 -0400", hash_original_field = "ED1946324A37C8463B4C0B2D957F4179", hash_generated_field = "108793E00A46A0B5F9687FF23F2656A9")

    public static final int RESPONSE_GROUP_INFO                     = BASE + 27;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.994 -0400", hash_original_field = "C474D1B501A3D8EFF9BE2635241B5198", hash_generated_field = "3797C4A7095177C075FD2048AF74BB88")

    public static final int ERROR               = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.994 -0400", hash_original_field = "0079ACB227FD3CE51294E1C78E2118B5", hash_generated_field = "8889F37166918C34677A312B5A4E1F90")

    public static final int P2P_UNSUPPORTED     = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.994 -0400", hash_original_field = "82EBBA8C5B8048874EAD300339982C8F", hash_generated_field = "9CF143A792B673B16F293366139BD455")

    public static final int BUSY                = 2;
}

