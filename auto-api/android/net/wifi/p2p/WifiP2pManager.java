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
    IWifiP2pManager mService;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.801 -0400", hash_original_method = "E626A45256220AE3F4AF9F0577D669AE", hash_generated_method = "3175F206D6DFC1DE9B07A52113A36F55")
    @DSModeled(DSC.SAFE)
    public WifiP2pManager(IWifiP2pManager service) {
        dsTaint.addTaint(service.dsTaint);
        // ---------- Original Method ----------
        //mService = service;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.801 -0400", hash_original_method = "38C14B58266EB34A7D20FC8977BB0D6B", hash_generated_method = "D2A8C2EDBED97D7B09F479AB8DDEEE40")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Channel initialize(Context srcContext, Looper srcLooper, ChannelListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        dsTaint.addTaint(srcContext.dsTaint);
        dsTaint.addTaint(srcLooper.dsTaint);
        Messenger messenger;
        messenger = getMessenger();
        Channel c;
        c = new Channel(srcLooper, listener);
        {
            boolean var760266D613BB58F7090531F7CC73134F_615135182 = (c.mAsyncChannel.connectSync(srcContext, c.mHandler, messenger)
                == AsyncChannel.STATUS_SUCCESSFUL);
        } //End collapsed parenthetic
        return (Channel)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.801 -0400", hash_original_method = "980C8BB1CB1A99B001412F99FCE388F8", hash_generated_method = "FFEEA56D48B8D0EB6FB8603325964973")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void enableP2p(Channel c) {
        dsTaint.addTaint(c.dsTaint);
        c.mAsyncChannel.sendMessage(ENABLE_P2P);
        // ---------- Original Method ----------
        //if (c == null) return;
        //c.mAsyncChannel.sendMessage(ENABLE_P2P);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.801 -0400", hash_original_method = "7F5F0D1F2270C5CE1C0233D48C977521", hash_generated_method = "8472C79FFB002369F568CA617B11BB55")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void disableP2p(Channel c) {
        dsTaint.addTaint(c.dsTaint);
        c.mAsyncChannel.sendMessage(DISABLE_P2P);
        // ---------- Original Method ----------
        //if (c == null) return;
        //c.mAsyncChannel.sendMessage(DISABLE_P2P);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.802 -0400", hash_original_method = "0086A0B598F8296D0733A67938A8010C", hash_generated_method = "2EC6F2FD1F128E912D2C57515FB908A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void discoverPeers(Channel c, ActionListener listener) {
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(listener.dsTaint);
        c.mAsyncChannel.sendMessage(DISCOVER_PEERS, 0, c.putListener(listener));
        // ---------- Original Method ----------
        //if (c == null) return;
        //c.mAsyncChannel.sendMessage(DISCOVER_PEERS, 0, c.putListener(listener));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.802 -0400", hash_original_method = "4F415F11CAEDBF627AFEA3E6B5DED300", hash_generated_method = "FDB52E6A1B893757B36EAA36FF31E103")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void connect(Channel c, WifiP2pConfig config, ActionListener listener) {
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(listener.dsTaint);
        dsTaint.addTaint(config.dsTaint);
        c.mAsyncChannel.sendMessage(CONNECT, 0, c.putListener(listener), config);
        // ---------- Original Method ----------
        //if (c == null) return;
        //c.mAsyncChannel.sendMessage(CONNECT, 0, c.putListener(listener), config);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.802 -0400", hash_original_method = "6933E398CD84814D8BC15F50F87022E9", hash_generated_method = "2014FC1D7522F02B22991DFC98E06E15")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void cancelConnect(Channel c, ActionListener listener) {
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(listener.dsTaint);
        c.mAsyncChannel.sendMessage(CANCEL_CONNECT, 0, c.putListener(listener));
        // ---------- Original Method ----------
        //if (c == null) return;
        //c.mAsyncChannel.sendMessage(CANCEL_CONNECT, 0, c.putListener(listener));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.802 -0400", hash_original_method = "C4AE7F9F2250AB1A3A1291386F0E0989", hash_generated_method = "01F1660E2E64DCD644E0A4A1A47C4C2F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void createGroup(Channel c, ActionListener listener) {
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(listener.dsTaint);
        c.mAsyncChannel.sendMessage(CREATE_GROUP, 0, c.putListener(listener));
        // ---------- Original Method ----------
        //if (c == null) return;
        //c.mAsyncChannel.sendMessage(CREATE_GROUP, 0, c.putListener(listener));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.803 -0400", hash_original_method = "34A328438D8586940446A090FD763814", hash_generated_method = "1753324654ACCEA5FE30AACF098ED23B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeGroup(Channel c, ActionListener listener) {
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(listener.dsTaint);
        c.mAsyncChannel.sendMessage(REMOVE_GROUP, 0, c.putListener(listener));
        // ---------- Original Method ----------
        //if (c == null) return;
        //c.mAsyncChannel.sendMessage(REMOVE_GROUP, 0, c.putListener(listener));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.803 -0400", hash_original_method = "694EBF25C431D0A14A1B93A99A392CFF", hash_generated_method = "80594A06AB56251E6360DAD3D3261EAD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void requestPeers(Channel c, PeerListListener listener) {
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(listener.dsTaint);
        c.mAsyncChannel.sendMessage(REQUEST_PEERS, 0, c.putListener(listener));
        // ---------- Original Method ----------
        //if (c == null) return;
        //c.mAsyncChannel.sendMessage(REQUEST_PEERS, 0, c.putListener(listener));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.803 -0400", hash_original_method = "F3A4F04EC67A346ED642EB6C8CC671D5", hash_generated_method = "52DABD77FA4A31F72EFEEE5543F5C200")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void requestConnectionInfo(Channel c, ConnectionInfoListener listener) {
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(listener.dsTaint);
        c.mAsyncChannel.sendMessage(REQUEST_CONNECTION_INFO, 0, c.putListener(listener));
        // ---------- Original Method ----------
        //if (c == null) return;
        //c.mAsyncChannel.sendMessage(REQUEST_CONNECTION_INFO, 0, c.putListener(listener));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.803 -0400", hash_original_method = "7D2D3B8E934838E23E15D5EFD9489887", hash_generated_method = "A5EC3F0CDE3C1A98359B61411CE404FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void requestGroupInfo(Channel c, GroupInfoListener listener) {
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(listener.dsTaint);
        c.mAsyncChannel.sendMessage(REQUEST_GROUP_INFO, 0, c.putListener(listener));
        // ---------- Original Method ----------
        //if (c == null) return;
        //c.mAsyncChannel.sendMessage(REQUEST_GROUP_INFO, 0, c.putListener(listener));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.804 -0400", hash_original_method = "A358F8361C96DABE1A63B04B5804B3F5", hash_generated_method = "AA898BBB57720F2604AABA8278D655CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Messenger getMessenger() {
        try 
        {
            Messenger varAB82975146F1B86EF7AFAED5EB9D69F9_1726504364 = (mService.getMessenger());
        } //End block
        catch (RemoteException e)
        { }
        return (Messenger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return mService.getMessenger();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    public static class Channel {
        private ChannelListener mChannelListener;
        private HashMap<Integer, Object> mListenerMap = new HashMap<Integer, Object>();
        private Object mListenerMapLock = new Object();
        private int mListenerKey = 0;
        AsyncChannel mAsyncChannel;
        P2pHandler mHandler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.804 -0400", hash_original_method = "CCBC86E649618B06362F4B186D38F77D", hash_generated_method = "B1C9F915EE522B27DBB0FD3EE6CFD209")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         Channel(Looper looper, ChannelListener l) {
            dsTaint.addTaint(looper.dsTaint);
            dsTaint.addTaint(l.dsTaint);
            mAsyncChannel = new AsyncChannel();
            mHandler = new P2pHandler(looper);
            // ---------- Original Method ----------
            //mAsyncChannel = new AsyncChannel();
            //mHandler = new P2pHandler(looper);
            //mChannelListener = l;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.804 -0400", hash_original_method = "0C1075F742095C1FC6722DFAFFAF85D8", hash_generated_method = "FDDA1817A5272F429662351794B2D021")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         int putListener(Object listener) {
            dsTaint.addTaint(listener.dsTaint);
            int key;
            {
                key = mListenerKey++;
                mListenerMap.put(key, listener);
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //if (listener == null) return 0;
            //int key;
            //synchronized (mListenerMapLock) {
                //key = mListenerKey++;
                //mListenerMap.put(key, listener);
            //}
            //return key;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.804 -0400", hash_original_method = "464423DE95DD4D04CAAC6C3D80546690", hash_generated_method = "FCCD23F6B181C91F480DE69DD3E4B75D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         Object getListener(int key) {
            dsTaint.addTaint(key);
            {
                Object varF0373176D80D31571B48A4E894C95A4A_1932833324 = (mListenerMap.remove(key));
            } //End block
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (mListenerMapLock) {
                //return mListenerMap.remove(key);
            //}
        }

        
        class P2pHandler extends Handler {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.805 -0400", hash_original_method = "1A56C06271A8BC48B0210F0B84874BB3", hash_generated_method = "4302FF768650A85D1FC8FD2B1F62B4DE")
            //DSFIXME:  CODE0002: Requires DSC value to be set
             P2pHandler(Looper looper) {
                super(looper);
                dsTaint.addTaint(looper.dsTaint);
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.805 -0400", hash_original_method = "2063A6497661251530BCD9012E9E1E5C", hash_generated_method = "4316A8452F1D33FC926E37D9A6E0E571")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public void handleMessage(Message message) {
                dsTaint.addTaint(message.dsTaint);
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
    
    private static final String TAG = "WifiP2pManager";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String WIFI_P2P_STATE_CHANGED_ACTION =
        "android.net.wifi.p2p.STATE_CHANGED";
    public static final String EXTRA_WIFI_STATE = "wifi_p2p_state";
    public static final int WIFI_P2P_STATE_DISABLED = 1;
    public static final int WIFI_P2P_STATE_ENABLED = 2;
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String WIFI_P2P_CONNECTION_CHANGED_ACTION =
        "android.net.wifi.p2p.CONNECTION_STATE_CHANGE";
    public static final String EXTRA_WIFI_P2P_INFO = "wifiP2pInfo";
    public static final String EXTRA_NETWORK_INFO = "networkInfo";
    public static final String EXTRA_LINK_PROPERTIES = "linkProperties";
    public static final String EXTRA_LINK_CAPABILITIES = "linkCapabilities";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String WIFI_P2P_PEERS_CHANGED_ACTION =
        "android.net.wifi.p2p.PEERS_CHANGED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String WIFI_P2P_THIS_DEVICE_CHANGED_ACTION =
        "android.net.wifi.p2p.THIS_DEVICE_CHANGED";
    public static final String EXTRA_WIFI_P2P_DEVICE = "wifiP2pDevice";
    private static final int BASE = Protocol.BASE_WIFI_P2P_MANAGER;
    public static final int ENABLE_P2P                              = BASE + 1;
    public static final int ENABLE_P2P_FAILED                       = BASE + 2;
    public static final int ENABLE_P2P_SUCCEEDED                    = BASE + 3;
    public static final int DISABLE_P2P                             = BASE + 4;
    public static final int DISABLE_P2P_FAILED                      = BASE + 5;
    public static final int DISABLE_P2P_SUCCEEDED                   = BASE + 6;
    public static final int DISCOVER_PEERS                          = BASE + 7;
    public static final int DISCOVER_PEERS_FAILED                   = BASE + 8;
    public static final int DISCOVER_PEERS_SUCCEEDED                = BASE + 9;
    public static final int CONNECT                                 = BASE + 10;
    public static final int CONNECT_FAILED                          = BASE + 11;
    public static final int CONNECT_SUCCEEDED                       = BASE + 12;
    public static final int CANCEL_CONNECT                          = BASE + 13;
    public static final int CANCEL_CONNECT_FAILED                   = BASE + 14;
    public static final int CANCEL_CONNECT_SUCCEEDED                = BASE + 15;
    public static final int CREATE_GROUP                            = BASE + 16;
    public static final int CREATE_GROUP_FAILED                     = BASE + 17;
    public static final int CREATE_GROUP_SUCCEEDED                  = BASE + 18;
    public static final int REMOVE_GROUP                            = BASE + 19;
    public static final int REMOVE_GROUP_FAILED                     = BASE + 20;
    public static final int REMOVE_GROUP_SUCCEEDED                  = BASE + 21;
    public static final int REQUEST_PEERS                           = BASE + 22;
    public static final int RESPONSE_PEERS                          = BASE + 23;
    public static final int REQUEST_CONNECTION_INFO                 = BASE + 24;
    public static final int RESPONSE_CONNECTION_INFO                = BASE + 25;
    public static final int REQUEST_GROUP_INFO                      = BASE + 26;
    public static final int RESPONSE_GROUP_INFO                     = BASE + 27;
    public static final int ERROR               = 0;
    public static final int P2P_UNSUPPORTED     = 1;
    public static final int BUSY                = 2;
}

