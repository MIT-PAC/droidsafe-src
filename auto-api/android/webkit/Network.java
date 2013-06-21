package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    private String mProxyUsername;
    private String mProxyPassword;
    private RequestQueue mRequestQueue;
    private SslErrorHandlerImpl mSslErrorHandler;
    private HttpAuthHandlerImpl mHttpAuthHandler;
    private Context mContext;
    private boolean mRoaming;
    private RoamingMonitor mRoamingMonitor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.578 -0400", hash_original_method = "27D599105D57C8AB9F99EAD7FE1A52D5", hash_generated_method = "588C4418F5AB53F5E339BA55C98D9AD4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Network(Context context) {
        dsTaint.addTaint(context.dsTaint);
        {
            Assert.assertTrue(Thread.currentThread().
                    getName().equals(WebViewCore.THREAD_NAME));
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.579 -0400", hash_original_method = "7636534D5021AA0AC5AC07906EACA40E", hash_generated_method = "7F5601F286EE1E114F10A04915D7821E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void monitorRoaming() {
        mRoamingMonitor = new RoamingMonitor();
        IntentFilter filter;
        filter = new IntentFilter();
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        mContext.registerReceiver(sNetwork.mRoamingMonitor, filter);
        // ---------- Original Method ----------
        //mRoamingMonitor = new RoamingMonitor();
        //IntentFilter filter = new IntentFilter();
        //filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        //mContext.registerReceiver(sNetwork.mRoamingMonitor, filter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.579 -0400", hash_original_method = "7D0FFF1DC9E3EFF208EFD53429D521D6", hash_generated_method = "BE7BFD8BDE9F306DC358C4D926D1564B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void stopMonitoringRoaming() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.579 -0400", hash_original_method = "E40B5BA7C100221963CCC3BAE15F17EE", hash_generated_method = "A8A6959D8377988474C79EED21971927")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean requestURL(String method,
                              Map<String, String> headers,
                              byte [] postData,
                              LoadListener loader) {
        dsTaint.addTaint(headers.dsTaint);
        dsTaint.addTaint(postData[0]);
        dsTaint.addTaint(loader.dsTaint);
        dsTaint.addTaint(method);
        String url;
        url = loader.url();
        {
            boolean var9241808DC96BE6C44777088970EEB76A_1190555878 = (!URLUtil.isValidUrl(url));
        } //End collapsed parenthetic
        {
            boolean var13B7A92743A4FACAEAD7D906C72E3E73_784418304 = (URLUtil.isAssetUrl(url) || URLUtil.isResourceUrl(url)
                || URLUtil.isFileUrl(url) || URLUtil.isDataUrl(url));
        } //End collapsed parenthetic
        {
            boolean var546DB600072281783BD3F8556B81320C_1223543937 = (mRoaming && headers.containsKey("X-Moz") && "prefetch".equals(headers.get("X-Moz")));
        } //End collapsed parenthetic
        InputStream bodyProvider;
        bodyProvider = null;
        int bodyLength;
        bodyLength = 0;
        {
            bodyLength = postData.length;
            bodyProvider = new ByteArrayInputStream(postData);
        } //End block
        RequestQueue q;
        q = mRequestQueue;
        RequestHandle handle;
        handle = null;
        {
            boolean var221166D89B647BFDA3D85F45A3E4348F_502711982 = (loader.isSynchronous());
            {
                handle = q.queueSynchronousRequest(url, loader.getWebAddress(),
                    method, headers, loader, bodyProvider, bodyLength);
                loader.attachRequestHandle(handle);
                handle.processRequest();
                loader.loadSynchronousMessages();
            } //End block
            {
                handle = q.queueRequest(url, loader.getWebAddress(), method,
                    headers, loader, bodyProvider, bodyLength);
                loader.attachRequestHandle(handle);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.580 -0400", hash_original_method = "80DD6C6B450A5637726B61D58132A867", hash_generated_method = "16936551A52F4665B903EEEEA96C105E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isValidProxySet() {
        {
            boolean var3A5567FF18F71476C6C5A982FB7CBBA4_1479066045 = (mRequestQueue.getProxyHost() != null);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //synchronized (mRequestQueue) {
            //return mRequestQueue.getProxyHost() != null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.580 -0400", hash_original_method = "A2D65C5EAC5BE051C823D07EA076A5B0", hash_generated_method = "952BE2D78415F83336F1D1D378369087")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getProxyHostname() {
        String varCD3AE37C0BA89A0EA4456EF667449817_2010949565 = (mRequestQueue.getProxyHost().getHostName());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mRequestQueue.getProxyHost().getHostName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.580 -0400", hash_original_method = "1266E72491C7223244252637AD0BEC00", hash_generated_method = "397CEC4ADEC352678E15AAB6084B4F97")
    @DSModeled(DSC.SAFE)
    public synchronized String getProxyUsername() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mProxyUsername;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.580 -0400", hash_original_method = "F385770A128D43043A61D29E35184FCC", hash_generated_method = "4D6CE6A4B843C765DFB7850C40A15856")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setProxyUsername(String proxyUsername) {
        dsTaint.addTaint(proxyUsername);
        {
            Assert.assertTrue(isValidProxySet());
        } //End block
        // ---------- Original Method ----------
        //if (DebugFlags.NETWORK) {
            //Assert.assertTrue(isValidProxySet());
        //}
        //mProxyUsername = proxyUsername;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.580 -0400", hash_original_method = "B46568E038B4519332317A487603C5DC", hash_generated_method = "436B622C52AB64CE0168FE634CA66E76")
    @DSModeled(DSC.SAFE)
    public synchronized String getProxyPassword() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mProxyPassword;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.581 -0400", hash_original_method = "F4CD508AF44DC7CAF5CD08EB1469791C", hash_generated_method = "672109806390B5999264DD3C845000AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setProxyPassword(String proxyPassword) {
        dsTaint.addTaint(proxyPassword);
        {
            Assert.assertTrue(isValidProxySet());
        } //End block
        // ---------- Original Method ----------
        //if (DebugFlags.NETWORK) {
            //Assert.assertTrue(isValidProxySet());
        //}
        //mProxyPassword = proxyPassword;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.581 -0400", hash_original_method = "7A0CD8F454BFF26B05173D10B6823AEB", hash_generated_method = "A74AA748FF0ABC4700467787A655BC6F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean saveState(Bundle outState) {
        dsTaint.addTaint(outState.dsTaint);
        boolean var23A5DD913F89F38B05072A1E64502CBD_2011954938 = (mSslErrorHandler.saveState(outState));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (DebugFlags.NETWORK) {
            //Log.v(LOGTAG, "Network.saveState()");
        //}
        //return mSslErrorHandler.saveState(outState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.581 -0400", hash_original_method = "47CE65B8425CCCD6D64866E88AA89041", hash_generated_method = "A0E7BF71760017F29DF3F3096802B920")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean restoreState(Bundle inState) {
        dsTaint.addTaint(inState.dsTaint);
        boolean varC82F46112A7C73C564B1DC27227A30E6_1658842178 = (mSslErrorHandler.restoreState(inState));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (DebugFlags.NETWORK) {
            //Log.v(LOGTAG, "Network.restoreState()");
        //}
        //return mSslErrorHandler.restoreState(inState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.581 -0400", hash_original_method = "8F59473C5B0D895146F3319CE625D311", hash_generated_method = "3153B4EE6AA3E66C716C0C9142D18748")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clearUserSslPrefTable() {
        mSslErrorHandler.clear();
        // ---------- Original Method ----------
        //mSslErrorHandler.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.582 -0400", hash_original_method = "DEBCC0C268CD067DAE645A47175BAE1D", hash_generated_method = "872B786FA8AFEEB211A1468C5BA08475")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void handleSslErrorRequest(LoadListener loader) {
        dsTaint.addTaint(loader.dsTaint);
        Assert.assertNotNull(loader);
        {
            mSslErrorHandler.handleSslErrorRequest(loader);
        } //End block
        // ---------- Original Method ----------
        //if (DebugFlags.NETWORK) Assert.assertNotNull(loader);
        //if (loader != null) {
            //mSslErrorHandler.handleSslErrorRequest(loader);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.582 -0400", hash_original_method = "2B01E9B22836C8DC58E90274FB1B42A2", hash_generated_method = "31C362F3421578EA293E329B27C66571")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean checkSslPrefTable(LoadListener loader,
            SslError error) {
        dsTaint.addTaint(error.dsTaint);
        dsTaint.addTaint(loader.dsTaint);
        {
            boolean var8A9D9175BCC2D61042B9D80821CB41E7_961541162 = (mSslErrorHandler.checkSslPrefTable(loader, error));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (loader != null && error != null) {
            //return mSslErrorHandler.checkSslPrefTable(loader, error);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.582 -0400", hash_original_method = "2D361BDF919FB90BFEE4AC2A951EDF8C", hash_generated_method = "7A22634DD5ED86A17C0E38FB44F77FF5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void handleAuthRequest(LoadListener loader) {
        dsTaint.addTaint(loader.dsTaint);
        Assert.assertNotNull(loader);
        {
            mHttpAuthHandler.handleAuthRequest(loader);
        } //End block
        // ---------- Original Method ----------
        //if (DebugFlags.NETWORK) Assert.assertNotNull(loader);
        //if (loader != null) {
            //mHttpAuthHandler.handleAuthRequest(loader);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.582 -0400", hash_original_method = "B02A8324ABFB3032B553A668B2D564CC", hash_generated_method = "53DEA7F03044D0453282AF3C2D955FBB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void startTiming() {
        mRequestQueue.startTiming();
        // ---------- Original Method ----------
        //mRequestQueue.startTiming();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.582 -0400", hash_original_method = "72F9E7B8510D03EF4E589AB2ED94957F", hash_generated_method = "A489D8A61618A9CAF6E69BDDB6C9E4B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void stopTiming() {
        mRequestQueue.stopTiming();
        // ---------- Original Method ----------
        //mRequestQueue.stopTiming();
    }

    
    private class RoamingMonitor extends BroadcastReceiver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.583 -0400", hash_original_method = "B01B396667DB458A8AECEA3DE8285030", hash_generated_method = "B01B396667DB458A8AECEA3DE8285030")
                public RoamingMonitor ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.583 -0400", hash_original_method = "FF6D86ABCD7F084A4EADD45C592C2902", hash_generated_method = "BD905CDB2488D86D0B80D66359769EA0")
        @DSModeled(DSC.SPEC)
        @Override
        public void onReceive(Context context, Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(context.dsTaint);
            dsTaint.addTaint(intent.dsTaint);
            {
                boolean var97C96649CC2BBB5BAE1921B8EB878E7B_1911556797 = (!ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction()));
            } //End collapsed parenthetic
            NetworkInfo info;
            info = (NetworkInfo)intent.getParcelableExtra(ConnectivityManager.EXTRA_NETWORK_INFO);
            mRoaming = info.isRoaming();
            // ---------- Original Method ----------
            //if (!ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction()))
                //return;
            //NetworkInfo info = (NetworkInfo)intent.getParcelableExtra(ConnectivityManager.EXTRA_NETWORK_INFO);
            //if (info != null)
                //mRoaming = info.isRoaming();
        }

        
    }


    
    private static final String LOGTAG = "network";
    private static Network sNetwork;
    private static boolean sPlatformNotifications;
    private static int sPlatformNotificationEnableRefCount;
}

