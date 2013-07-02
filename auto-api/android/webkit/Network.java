package android.webkit;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.http.*;
import android.os.*;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;
import junit.framework.Assert;

class Network {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.273 -0400", hash_original_field = "1E809564B7DE2310DE54967FAFFCD227", hash_generated_field = "319865EBA225C5210ACF05AB725BAB66")

    private String mProxyUsername;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.273 -0400", hash_original_field = "8D6CAE03C36056325E8ADE152A74EE0E", hash_generated_field = "FF7DAA246C1CA604152EB48C2AF2E773")

    private String mProxyPassword;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.273 -0400", hash_original_field = "446B3D97C833B98F7071BDDC6133F7E3", hash_generated_field = "78C29B99FF935BC5FA797927660C2906")

    private RequestQueue mRequestQueue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.273 -0400", hash_original_field = "86477F9A760363AE8F8848F8FDB115F6", hash_generated_field = "8DCA1AE234186B4A67A2A4D752C208F9")

    private SslErrorHandlerImpl mSslErrorHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.273 -0400", hash_original_field = "03D2148B8F1D3C328DE9C85EDBA634DB", hash_generated_field = "53A4962277DC3F61031FDD8467194DC1")

    private HttpAuthHandlerImpl mHttpAuthHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.273 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.273 -0400", hash_original_field = "53676CF9ACC69A311F8B40D8878A560F", hash_generated_field = "02055DCC177C93D9A52A736D58C166FD")

    private boolean mRoaming;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.273 -0400", hash_original_field = "79A02826D1930C455B5B971FF3D5B373", hash_generated_field = "F11D8280BB02C785E2788B34A45DFCB7")

    private RoamingMonitor mRoamingMonitor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.274 -0400", hash_original_method = "27D599105D57C8AB9F99EAD7FE1A52D5", hash_generated_method = "6572B0B9AE4993FA10928706FC6564BF")
    private  Network(Context context) {
        {
            Assert.assertTrue(Thread.currentThread().
                    getName().equals(WebViewCore.THREAD_NAME));
        } 
        mContext = context;
        mSslErrorHandler = new SslErrorHandlerImpl();
        mHttpAuthHandler = new HttpAuthHandlerImpl(this);
        mRequestQueue = new RequestQueue(context);
        
        
            
                    
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static synchronized Network getInstance(Context context) {
        if (sNetwork == null) {
            sNetwork = new Network(context.getApplicationContext());
            if (sPlatformNotifications) {
                --sPlatformNotificationEnableRefCount;
                enablePlatformNotifications();
            }
        }
        return sNetwork;
    }

    
    @DSModeled(DSC.SAFE)
    public static void enablePlatformNotifications() {
        if (++sPlatformNotificationEnableRefCount == 1) {
            if (sNetwork != null) {
                sNetwork.mRequestQueue.enablePlatformNotifications();
                sNetwork.monitorRoaming();
            } else {
                sPlatformNotifications = true;
            }
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static void disablePlatformNotifications() {
        if (--sPlatformNotificationEnableRefCount == 0) {
            if (sNetwork != null) {
                sNetwork.mRequestQueue.disablePlatformNotifications();
                sNetwork.stopMonitoringRoaming();
            } else {
                sPlatformNotifications = false;
            }
        }
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.275 -0400", hash_original_method = "7636534D5021AA0AC5AC07906EACA40E", hash_generated_method = "573E850B74569715EC91B0516CBFD4A2")
    private void monitorRoaming() {
        mRoamingMonitor = new RoamingMonitor();
        IntentFilter filter = new IntentFilter();
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        mContext.registerReceiver(sNetwork.mRoamingMonitor, filter);
        
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.276 -0400", hash_original_method = "7D0FFF1DC9E3EFF208EFD53429D521D6", hash_generated_method = "BE7BFD8BDE9F306DC358C4D926D1564B")
    private void stopMonitoringRoaming() {
        {
            mContext.unregisterReceiver(mRoamingMonitor);
            mRoamingMonitor = null;
        } 
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.119 -0400", hash_original_method = "E40B5BA7C100221963CCC3BAE15F17EE", hash_generated_method = "963C86C2BF694C952C02FC7139CC4D6D")
    public boolean requestURL(String method,
                              Map<String, String> headers,
                              byte [] postData,
                              LoadListener loader) {
        String url;
        url = loader.url();
        {
            boolean var9241808DC96BE6C44777088970EEB76A_126593523 = (!URLUtil.isValidUrl(url));
        } 
        {
            boolean var13B7A92743A4FACAEAD7D906C72E3E73_186384305 = (URLUtil.isAssetUrl(url) || URLUtil.isResourceUrl(url)
                || URLUtil.isFileUrl(url) || URLUtil.isDataUrl(url));
        } 
        {
            boolean var546DB600072281783BD3F8556B81320C_1615825443 = (mRoaming && headers.containsKey("X-Moz") && "prefetch".equals(headers.get("X-Moz")));
        } 
        InputStream bodyProvider;
        bodyProvider = null;
        int bodyLength;
        bodyLength = 0;
        {
            bodyLength = postData.length;
            bodyProvider = new ByteArrayInputStream(postData);
        } 
        RequestQueue q;
        q = mRequestQueue;
        RequestHandle handle;
        handle = null;
        {
            boolean var221166D89B647BFDA3D85F45A3E4348F_216138516 = (loader.isSynchronous());
            {
                handle = q.queueSynchronousRequest(url, loader.getWebAddress(),
                    method, headers, loader, bodyProvider, bodyLength);
                loader.attachRequestHandle(handle);
                handle.processRequest();
                loader.loadSynchronousMessages();
            } 
            {
                handle = q.queueRequest(url, loader.getWebAddress(), method,
                    headers, loader, bodyProvider, bodyLength);
                loader.attachRequestHandle(handle);
            } 
        } 
        addTaint(method.getTaint());
        addTaint(headers.getTaint());
        addTaint(postData[0]);
        addTaint(loader.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1179949707 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1179949707;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.276 -0400", hash_original_method = "80DD6C6B450A5637726B61D58132A867", hash_generated_method = "4CA2C006705036D26F4EDFD83C0D0E27")
    public boolean isValidProxySet() {
        {
            boolean var3A5567FF18F71476C6C5A982FB7CBBA4_835299708 = (mRequestQueue.getProxyHost() != null);
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_398486819 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_398486819;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.277 -0400", hash_original_method = "A2D65C5EAC5BE051C823D07EA076A5B0", hash_generated_method = "9B435164DB7EA72346AD02D0E056FE0D")
    public String getProxyHostname() {
        String varB4EAC82CA7396A68D541C85D26508E83_1377406503 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1377406503 = mRequestQueue.getProxyHost().getHostName();
        varB4EAC82CA7396A68D541C85D26508E83_1377406503.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1377406503;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.277 -0400", hash_original_method = "1266E72491C7223244252637AD0BEC00", hash_generated_method = "DE565B38E8AB04726BC7DAE190912C2A")
    public synchronized String getProxyUsername() {
        String varB4EAC82CA7396A68D541C85D26508E83_2085041714 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2085041714 = mProxyUsername;
        varB4EAC82CA7396A68D541C85D26508E83_2085041714.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2085041714;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.278 -0400", hash_original_method = "F385770A128D43043A61D29E35184FCC", hash_generated_method = "5A96809A5336BB9814E7FDB2C6440674")
    public synchronized void setProxyUsername(String proxyUsername) {
        {
            Assert.assertTrue(isValidProxySet());
        } 
        mProxyUsername = proxyUsername;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.278 -0400", hash_original_method = "B46568E038B4519332317A487603C5DC", hash_generated_method = "4537BE69555DDD42DBC0908A1F1BE2EF")
    public synchronized String getProxyPassword() {
        String varB4EAC82CA7396A68D541C85D26508E83_119236723 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_119236723 = mProxyPassword;
        varB4EAC82CA7396A68D541C85D26508E83_119236723.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_119236723;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.278 -0400", hash_original_method = "F4CD508AF44DC7CAF5CD08EB1469791C", hash_generated_method = "8A54065C094A7F3642C392AF8C362ED7")
    public synchronized void setProxyPassword(String proxyPassword) {
        {
            Assert.assertTrue(isValidProxySet());
        } 
        mProxyPassword = proxyPassword;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.279 -0400", hash_original_method = "7A0CD8F454BFF26B05173D10B6823AEB", hash_generated_method = "C57142ADA6FEF65BC128C7A347F9ED0C")
    public boolean saveState(Bundle outState) {
        boolean var23A5DD913F89F38B05072A1E64502CBD_1366287647 = (mSslErrorHandler.saveState(outState));
        addTaint(outState.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1013036034 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1013036034;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.279 -0400", hash_original_method = "47CE65B8425CCCD6D64866E88AA89041", hash_generated_method = "E636ACDDF8A1D89C7BED12FAA6CC0378")
    public boolean restoreState(Bundle inState) {
        boolean varC82F46112A7C73C564B1DC27227A30E6_1072079416 = (mSslErrorHandler.restoreState(inState));
        addTaint(inState.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_953454933 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_953454933;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.279 -0400", hash_original_method = "8F59473C5B0D895146F3319CE625D311", hash_generated_method = "3153B4EE6AA3E66C716C0C9142D18748")
    public void clearUserSslPrefTable() {
        mSslErrorHandler.clear();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.279 -0400", hash_original_method = "DEBCC0C268CD067DAE645A47175BAE1D", hash_generated_method = "BCFF4D8DE1D14D37CC51ED43291624FD")
    public void handleSslErrorRequest(LoadListener loader) {
        Assert.assertNotNull(loader);
        {
            mSslErrorHandler.handleSslErrorRequest(loader);
        } 
        addTaint(loader.getTaint());
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.280 -0400", hash_original_method = "2B01E9B22836C8DC58E90274FB1B42A2", hash_generated_method = "8559263E1DDF724B5CEBEA06297F8277")
     boolean checkSslPrefTable(LoadListener loader,
            SslError error) {
        {
            boolean var8A9D9175BCC2D61042B9D80821CB41E7_1877990920 = (mSslErrorHandler.checkSslPrefTable(loader, error));
        } 
        addTaint(loader.getTaint());
        addTaint(error.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_539747996 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_539747996;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.280 -0400", hash_original_method = "2D361BDF919FB90BFEE4AC2A951EDF8C", hash_generated_method = "AC5AE5F17B661B55960FC30AC8726B82")
    public void handleAuthRequest(LoadListener loader) {
        Assert.assertNotNull(loader);
        {
            mHttpAuthHandler.handleAuthRequest(loader);
        } 
        addTaint(loader.getTaint());
        
        
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.280 -0400", hash_original_method = "B02A8324ABFB3032B553A668B2D564CC", hash_generated_method = "53DEA7F03044D0453282AF3C2D955FBB")
    public void startTiming() {
        mRequestQueue.startTiming();
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.280 -0400", hash_original_method = "72F9E7B8510D03EF4E589AB2ED94957F", hash_generated_method = "A489D8A61618A9CAF6E69BDDB6C9E4B6")
    public void stopTiming() {
        mRequestQueue.stopTiming();
        
        
    }

    
    private class RoamingMonitor extends BroadcastReceiver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.281 -0400", hash_original_method = "FB653F8ECDBB15EF238A4B7D0BC2CB07", hash_generated_method = "FB653F8ECDBB15EF238A4B7D0BC2CB07")
        public RoamingMonitor ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.281 -0400", hash_original_method = "FF6D86ABCD7F084A4EADD45C592C2902", hash_generated_method = "80FF5808E66FBA8F0E8F73FD0A52E442")
        @Override
        public void onReceive(Context context, Intent intent) {
            
            {
                boolean var97C96649CC2BBB5BAE1921B8EB878E7B_1013342398 = (!ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction()));
            } 
            NetworkInfo info = (NetworkInfo)intent.getParcelableExtra(ConnectivityManager.EXTRA_NETWORK_INFO);
            mRoaming = info.isRoaming();
            addTaint(context.getTaint());
            addTaint(intent.getTaint());
            
            
                
            
            
                
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.281 -0400", hash_original_field = "9C0E52F6EA09A89CC23A82A807E7244F", hash_generated_field = "F098064C2753AB544D48EBBEF82B0BA4")

    private static final String LOGTAG = "network";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.281 -0400", hash_original_field = "A9F0DA6E2FD07BF6CB22E4760A1FE9A4", hash_generated_field = "B1F79203A591BC2F780E71886AE7DF53")

    private static Network sNetwork;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.281 -0400", hash_original_field = "8D621824C94DA68363DB53D99AE9AF65", hash_generated_field = "E0BC060910E0FDF6F04FD1D7C658DB7E")

    private static boolean sPlatformNotifications;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.281 -0400", hash_original_field = "C001F032E81851F10F0C4C3085E5AACB", hash_generated_field = "041976DC0516526BB61DEF868B7B79DA")

    private static int sPlatformNotificationEnableRefCount;
}

