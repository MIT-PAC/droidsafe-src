package android.webkit;

// Droidsafe Imports
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

import junit.framework.Assert;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.http.RequestHandle;
import android.net.http.RequestQueue;
import android.net.http.SslError;
import android.os.Bundle;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

class Network {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.611 -0400", hash_original_field = "1E809564B7DE2310DE54967FAFFCD227", hash_generated_field = "319865EBA225C5210ACF05AB725BAB66")

    private String mProxyUsername;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.611 -0400", hash_original_field = "8D6CAE03C36056325E8ADE152A74EE0E", hash_generated_field = "FF7DAA246C1CA604152EB48C2AF2E773")

    private String mProxyPassword;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.611 -0400", hash_original_field = "446B3D97C833B98F7071BDDC6133F7E3", hash_generated_field = "78C29B99FF935BC5FA797927660C2906")

    private RequestQueue mRequestQueue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.611 -0400", hash_original_field = "86477F9A760363AE8F8848F8FDB115F6", hash_generated_field = "8DCA1AE234186B4A67A2A4D752C208F9")

    private SslErrorHandlerImpl mSslErrorHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.611 -0400", hash_original_field = "03D2148B8F1D3C328DE9C85EDBA634DB", hash_generated_field = "53A4962277DC3F61031FDD8467194DC1")

    private HttpAuthHandlerImpl mHttpAuthHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.611 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.611 -0400", hash_original_field = "53676CF9ACC69A311F8B40D8878A560F", hash_generated_field = "02055DCC177C93D9A52A736D58C166FD")

    private boolean mRoaming;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.611 -0400", hash_original_field = "79A02826D1930C455B5B971FF3D5B373", hash_generated_field = "F11D8280BB02C785E2788B34A45DFCB7")

    private RoamingMonitor mRoamingMonitor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.612 -0400", hash_original_method = "27D599105D57C8AB9F99EAD7FE1A52D5", hash_generated_method = "8617DCB17BA1660FC623DB379F5D12C3")
    private  Network(Context context) {
        if(DebugFlags.NETWORK)        
        {
            Assert.assertTrue(Thread.currentThread().
                    getName().equals(WebViewCore.THREAD_NAME));
        } //End block
        mContext = context;
        mSslErrorHandler = new SslErrorHandlerImpl();
        mHttpAuthHandler = new HttpAuthHandlerImpl(this);
        mRequestQueue = new RequestQueue(context);
        // ---------- Original Method ----------
        //if (DebugFlags.NETWORK) {
            //Assert.assertTrue(Thread.currentThread().
                    //getName().equals(WebViewCore.THREAD_NAME));
        //}
        //mContext = context;
        //mSslErrorHandler = new SslErrorHandlerImpl();
        //mHttpAuthHandler = new HttpAuthHandlerImpl(this);
        //mRequestQueue = new RequestQueue(context);
    }

    
    @DSModeled(DSC.SPEC)
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.645 -0400", hash_original_method = "7636534D5021AA0AC5AC07906EACA40E", hash_generated_method = "573E850B74569715EC91B0516CBFD4A2")
    private void monitorRoaming() {
        mRoamingMonitor = new RoamingMonitor();
        IntentFilter filter = new IntentFilter();
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        mContext.registerReceiver(sNetwork.mRoamingMonitor, filter);
        // ---------- Original Method ----------
        //mRoamingMonitor = new RoamingMonitor();
        //IntentFilter filter = new IntentFilter();
        //filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        //mContext.registerReceiver(sNetwork.mRoamingMonitor, filter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.645 -0400", hash_original_method = "7D0FFF1DC9E3EFF208EFD53429D521D6", hash_generated_method = "B10BAEFD110786AC7BA45D78FABC82CA")
    private void stopMonitoringRoaming() {
        if(mRoamingMonitor != null)        
        {
            mContext.unregisterReceiver(mRoamingMonitor);
            mRoamingMonitor = null;
        } //End block
        // ---------- Original Method ----------
        //if (mRoamingMonitor != null) {
            //mContext.unregisterReceiver(mRoamingMonitor);
            //mRoamingMonitor = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.807 -0400", hash_original_method = "E40B5BA7C100221963CCC3BAE15F17EE", hash_generated_method = "22B52E6758FBB73DDAAC4CF7C4F2C9D4")
    public boolean requestURL(String method,
                              Map<String, String> headers,
                              byte [] postData,
                              LoadListener loader) {
        addTaint(loader.getTaint());
        addTaint(postData[0]);
        addTaint(headers.getTaint());
        addTaint(method.getTaint());
        String url = loader.url();
    if(!URLUtil.isValidUrl(url))        
        {
            boolean var68934A3E9455FA72420237EB05902327_595518074 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1768044265 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1768044265;
        } //End block
    if(URLUtil.isAssetUrl(url) || URLUtil.isResourceUrl(url)
                || URLUtil.isFileUrl(url) || URLUtil.isDataUrl(url))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1184452390 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_582037737 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_582037737;
        } //End block
    if(mRoaming && headers.containsKey("X-Moz") && "prefetch".equals(headers.get("X-Moz")))        
        {
            boolean var68934A3E9455FA72420237EB05902327_611076808 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_236062641 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_236062641;
        } //End block
        InputStream bodyProvider = null;
        int bodyLength = 0;
    if(postData != null)        
        {
            bodyLength = postData.length;
            bodyProvider = new ByteArrayInputStream(postData);
        } //End block
        RequestQueue q = mRequestQueue;
        RequestHandle handle = null;
    if(loader.isSynchronous())        
        {
            handle = q.queueSynchronousRequest(url, loader.getWebAddress(),
                    method, headers, loader, bodyProvider, bodyLength);
            loader.attachRequestHandle(handle);
            handle.processRequest();
            loader.loadSynchronousMessages();
        } //End block
        else
        {
            handle = q.queueRequest(url, loader.getWebAddress(), method,
                    headers, loader, bodyProvider, bodyLength);
            loader.attachRequestHandle(handle);
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_103265513 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_341413380 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_341413380;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.645 -0400", hash_original_method = "80DD6C6B450A5637726B61D58132A867", hash_generated_method = "E367A1F4320BA8F4A45B538FA08BE6D2")
    public boolean isValidProxySet() {
        synchronized
(mRequestQueue)        {
            boolean varBB0537527C789B6AFC5E8E9D86414387_1279181142 = (mRequestQueue.getProxyHost() != null);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1885419972 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1885419972;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mRequestQueue) {
            //return mRequestQueue.getProxyHost() != null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.645 -0400", hash_original_method = "A2D65C5EAC5BE051C823D07EA076A5B0", hash_generated_method = "560A0BA4C4222253E404FD2D24C9A51C")
    public String getProxyHostname() {
String var5E0DBFD0A810C9DF79D4FDF52FBF6DA2_1009116587 =         mRequestQueue.getProxyHost().getHostName();
        var5E0DBFD0A810C9DF79D4FDF52FBF6DA2_1009116587.addTaint(taint);
        return var5E0DBFD0A810C9DF79D4FDF52FBF6DA2_1009116587;
        // ---------- Original Method ----------
        //return mRequestQueue.getProxyHost().getHostName();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.646 -0400", hash_original_method = "1266E72491C7223244252637AD0BEC00", hash_generated_method = "FA26A23731D9EEFE263D72128D1CEC78")
    public synchronized String getProxyUsername() {
String var25846F855CBEDE427E929DAB6DAE06CB_798488304 =         mProxyUsername;
        var25846F855CBEDE427E929DAB6DAE06CB_798488304.addTaint(taint);
        return var25846F855CBEDE427E929DAB6DAE06CB_798488304;
        // ---------- Original Method ----------
        //return mProxyUsername;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.646 -0400", hash_original_method = "F385770A128D43043A61D29E35184FCC", hash_generated_method = "09BDC173FCC3971926FE697FB23E9A0C")
    public synchronized void setProxyUsername(String proxyUsername) {
        if(DebugFlags.NETWORK)        
        {
            Assert.assertTrue(isValidProxySet());
        } //End block
        mProxyUsername = proxyUsername;
        // ---------- Original Method ----------
        //if (DebugFlags.NETWORK) {
            //Assert.assertTrue(isValidProxySet());
        //}
        //mProxyUsername = proxyUsername;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.646 -0400", hash_original_method = "B46568E038B4519332317A487603C5DC", hash_generated_method = "FE83BA1F6F75C0D752F5BFBD1F765C69")
    public synchronized String getProxyPassword() {
String varF4020F95A180D57F86F89B67CE207E73_1521573849 =         mProxyPassword;
        varF4020F95A180D57F86F89B67CE207E73_1521573849.addTaint(taint);
        return varF4020F95A180D57F86F89B67CE207E73_1521573849;
        // ---------- Original Method ----------
        //return mProxyPassword;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.646 -0400", hash_original_method = "F4CD508AF44DC7CAF5CD08EB1469791C", hash_generated_method = "54075A54FCF7A683DB6DDED89B3F4ECB")
    public synchronized void setProxyPassword(String proxyPassword) {
        if(DebugFlags.NETWORK)        
        {
            Assert.assertTrue(isValidProxySet());
        } //End block
        mProxyPassword = proxyPassword;
        // ---------- Original Method ----------
        //if (DebugFlags.NETWORK) {
            //Assert.assertTrue(isValidProxySet());
        //}
        //mProxyPassword = proxyPassword;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.646 -0400", hash_original_method = "7A0CD8F454BFF26B05173D10B6823AEB", hash_generated_method = "639F8E27CABF6CF7DFAE0767287A11D7")
    public boolean saveState(Bundle outState) {
        addTaint(outState.getTaint());
        if(DebugFlags.NETWORK)        
        {
        } //End block
        boolean varBA686A6070080F6298FA074E3F9AB862_1475229489 = (mSslErrorHandler.saveState(outState));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_914851218 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_914851218;
        // ---------- Original Method ----------
        //if (DebugFlags.NETWORK) {
            //Log.v(LOGTAG, "Network.saveState()");
        //}
        //return mSslErrorHandler.saveState(outState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.646 -0400", hash_original_method = "47CE65B8425CCCD6D64866E88AA89041", hash_generated_method = "B2EE7B2C9196854D57900EB307FF00A5")
    public boolean restoreState(Bundle inState) {
        addTaint(inState.getTaint());
        if(DebugFlags.NETWORK)        
        {
        } //End block
        boolean var5C59A2682E0C15978A03489B19CA8832_766603873 = (mSslErrorHandler.restoreState(inState));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_98448742 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_98448742;
        // ---------- Original Method ----------
        //if (DebugFlags.NETWORK) {
            //Log.v(LOGTAG, "Network.restoreState()");
        //}
        //return mSslErrorHandler.restoreState(inState);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.646 -0400", hash_original_method = "8F59473C5B0D895146F3319CE625D311", hash_generated_method = "3153B4EE6AA3E66C716C0C9142D18748")
    public void clearUserSslPrefTable() {
        mSslErrorHandler.clear();
        // ---------- Original Method ----------
        //mSslErrorHandler.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.646 -0400", hash_original_method = "DEBCC0C268CD067DAE645A47175BAE1D", hash_generated_method = "5385F1D2A55BD82E8776A6435E54D0A6")
    public void handleSslErrorRequest(LoadListener loader) {
        addTaint(loader.getTaint());
        if(DebugFlags.NETWORK)        
        Assert.assertNotNull(loader);
        if(loader != null)        
        {
            mSslErrorHandler.handleSslErrorRequest(loader);
        } //End block
        // ---------- Original Method ----------
        //if (DebugFlags.NETWORK) Assert.assertNotNull(loader);
        //if (loader != null) {
            //mSslErrorHandler.handleSslErrorRequest(loader);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.646 -0400", hash_original_method = "2B01E9B22836C8DC58E90274FB1B42A2", hash_generated_method = "B4753163B5F61E6FB1C96C46D042C231")
     boolean checkSslPrefTable(LoadListener loader,
            SslError error) {
        addTaint(error.getTaint());
        addTaint(loader.getTaint());
        if(loader != null && error != null)        
        {
            boolean varF9FD0D34AF88E7AA8D60DF292A5A061E_690427029 = (mSslErrorHandler.checkSslPrefTable(loader, error));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2111511693 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2111511693;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_229280515 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_133628657 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_133628657;
        // ---------- Original Method ----------
        //if (loader != null && error != null) {
            //return mSslErrorHandler.checkSslPrefTable(loader, error);
        //}
        //return false;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.647 -0400", hash_original_method = "2D361BDF919FB90BFEE4AC2A951EDF8C", hash_generated_method = "C2E11E251BEB6263B27AED4FA3A67120")
    public void handleAuthRequest(LoadListener loader) {
        addTaint(loader.getTaint());
        if(DebugFlags.NETWORK)        
        Assert.assertNotNull(loader);
        if(loader != null)        
        {
            mHttpAuthHandler.handleAuthRequest(loader);
        } //End block
        // ---------- Original Method ----------
        //if (DebugFlags.NETWORK) Assert.assertNotNull(loader);
        //if (loader != null) {
            //mHttpAuthHandler.handleAuthRequest(loader);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.647 -0400", hash_original_method = "B02A8324ABFB3032B553A668B2D564CC", hash_generated_method = "53DEA7F03044D0453282AF3C2D955FBB")
    public void startTiming() {
        mRequestQueue.startTiming();
        // ---------- Original Method ----------
        //mRequestQueue.startTiming();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.647 -0400", hash_original_method = "72F9E7B8510D03EF4E589AB2ED94957F", hash_generated_method = "A489D8A61618A9CAF6E69BDDB6C9E4B6")
    public void stopTiming() {
        mRequestQueue.stopTiming();
        // ---------- Original Method ----------
        //mRequestQueue.stopTiming();
    }

    
    private class RoamingMonitor extends BroadcastReceiver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.647 -0400", hash_original_method = "FB653F8ECDBB15EF238A4B7D0BC2CB07", hash_generated_method = "FB653F8ECDBB15EF238A4B7D0BC2CB07")
        public RoamingMonitor ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.647 -0400", hash_original_method = "FF6D86ABCD7F084A4EADD45C592C2902", hash_generated_method = "9B961E2B1C87E83CCA1A001240A369AE")
        @Override
        public void onReceive(Context context, Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(intent.getTaint());
            addTaint(context.getTaint());
            if(!ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction()))            
            return;
            NetworkInfo info = (NetworkInfo)intent.getParcelableExtra(ConnectivityManager.EXTRA_NETWORK_INFO);
            if(info != null)            
            mRoaming = info.isRoaming();
            // ---------- Original Method ----------
            //if (!ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction()))
                //return;
            //NetworkInfo info = (NetworkInfo)intent.getParcelableExtra(ConnectivityManager.EXTRA_NETWORK_INFO);
            //if (info != null)
                //mRoaming = info.isRoaming();
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.647 -0400", hash_original_field = "9C0E52F6EA09A89CC23A82A807E7244F", hash_generated_field = "F098064C2753AB544D48EBBEF82B0BA4")

    private static final String LOGTAG = "network";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.647 -0400", hash_original_field = "A9F0DA6E2FD07BF6CB22E4760A1FE9A4", hash_generated_field = "B1F79203A591BC2F780E71886AE7DF53")

    private static Network sNetwork;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.647 -0400", hash_original_field = "8D621824C94DA68363DB53D99AE9AF65", hash_generated_field = "E0BC060910E0FDF6F04FD1D7C658DB7E")

    private static boolean sPlatformNotifications;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.647 -0400", hash_original_field = "C001F032E81851F10F0C4C3085E5AACB", hash_generated_field = "041976DC0516526BB61DEF868B7B79DA")

    private static int sPlatformNotificationEnableRefCount;
}

