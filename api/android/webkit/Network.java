package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
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





class Network {

    /**
     * @return The singleton instance of the network.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.726 -0500", hash_original_method = "0DB971BE81DD6E4DBA6818333FB8E75B", hash_generated_method = "D0FEEC16B7D2342ACF33B5B5D014DED4")
    
public static synchronized Network getInstance(Context context) {
        if (sNetwork == null) {
            // Note Context of the Application is used here, rather than
            // the what is passed in (usually a Context derived from an 
            // Activity) so the intent receivers belong to the application
            // rather than an activity - this fixes the issue where 
            // Activities are created and destroyed during the lifetime of
            // an Application
            sNetwork = new Network(context.getApplicationContext());
            if (sPlatformNotifications) {
                // Adjust the ref count before calling enable as it is already
                // taken into account when the static function was called 
                // directly
                --sPlatformNotificationEnableRefCount;
                enablePlatformNotifications();
            }
        }
        return sNetwork;
    }


    /**
     * Enables data state and proxy tracking
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.728 -0500", hash_original_method = "7745DFEE9834EC2B32DE9DD1516D53D2", hash_generated_method = "378B520FE7F4D3A46D15D74710323131")
    
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

    /**
     * If platform notifications are enabled, this should be called
     * from onPause() or onStop()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.731 -0500", hash_original_method = "3025D5078B888EFD5424B85CBBC0F438", hash_generated_method = "384BA42CFE36239283C0BDF358ABBAED")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.699 -0500", hash_original_field = "B8F296222D99B13B57A30F4500AF7F3D", hash_generated_field = "F098064C2753AB544D48EBBEF82B0BA4")


    private static final String LOGTAG = "network";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.702 -0500", hash_original_field = "0F12AD73685E2EED270D6B888608A97D", hash_generated_field = "B1F79203A591BC2F780E71886AE7DF53")

    private static Network sNetwork;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.704 -0500", hash_original_field = "83CF8551ABCA70FD7CC31A0856EED60B", hash_generated_field = "E0BC060910E0FDF6F04FD1D7C658DB7E")

    private static boolean sPlatformNotifications;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.706 -0500", hash_original_field = "1873B075B993598A1C17807F70AE2286", hash_generated_field = "041976DC0516526BB61DEF868B7B79DA")

    private static int sPlatformNotificationEnableRefCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.708 -0500", hash_original_field = "9EED3A583248BA5C5D68CA22E8D1BC51", hash_generated_field = "319865EBA225C5210ACF05AB725BAB66")

    private String mProxyUsername;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.710 -0500", hash_original_field = "33ACB10F72EAC4D6B80EC4D637466563", hash_generated_field = "FF7DAA246C1CA604152EB48C2AF2E773")

    private String mProxyPassword;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.712 -0500", hash_original_field = "2CFB054BACCE225829CD65D3DF87BAA7", hash_generated_field = "78C29B99FF935BC5FA797927660C2906")

    private RequestQueue mRequestQueue;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.714 -0500", hash_original_field = "2B6BB69D8BBCB0EC0DA23FD7A4F3C045", hash_generated_field = "8DCA1AE234186B4A67A2A4D752C208F9")

    private SslErrorHandlerImpl mSslErrorHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.716 -0500", hash_original_field = "F42E49C20D345D97B665C1D0904400AA", hash_generated_field = "53A4962277DC3F61031FDD8467194DC1")

    private HttpAuthHandlerImpl mHttpAuthHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.718 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")


    private Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.721 -0500", hash_original_field = "443BCEF3EEBE54B39D5E3E92FF87E1E4", hash_generated_field = "02055DCC177C93D9A52A736D58C166FD")

    private boolean mRoaming;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.723 -0500", hash_original_field = "6019AF50BB4065FDE523141ECCF60989", hash_generated_field = "F11D8280BB02C785E2788B34A45DFCB7")

    private RoamingMonitor mRoamingMonitor;

    /**
     * Creates a new Network object.
     * XXX: Must be created in the same thread as WebCore!!!!!
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.733 -0500", hash_original_method = "27D599105D57C8AB9F99EAD7FE1A52D5", hash_generated_method = "BB72AFB78DC5B83CD5729BB0D882B6D0")
    
private Network(Context context) {
        if (DebugFlags.NETWORK) {
            Assert.assertTrue(Thread.currentThread().
                    getName().equals(WebViewCore.THREAD_NAME));
        }
        mContext = context;
        mSslErrorHandler = new SslErrorHandlerImpl();
        mHttpAuthHandler = new HttpAuthHandlerImpl(this);

        mRequestQueue = new RequestQueue(context);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.741 -0500", hash_original_method = "7636534D5021AA0AC5AC07906EACA40E", hash_generated_method = "D1079AD858B57A228A60D912F6A19CC5")
    
private void monitorRoaming() {
        mRoamingMonitor = new RoamingMonitor();
        IntentFilter filter = new IntentFilter();
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        mContext.registerReceiver(sNetwork.mRoamingMonitor, filter);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.743 -0500", hash_original_method = "7D0FFF1DC9E3EFF208EFD53429D521D6", hash_generated_method = "2CD4B265BA8A7C98182C0E39FF71B820")
    
private void stopMonitoringRoaming() {
        if (mRoamingMonitor != null) {
            mContext.unregisterReceiver(mRoamingMonitor);
            mRoamingMonitor = null;
        }
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

    /**
     * @return True iff there is a valid proxy set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.748 -0500", hash_original_method = "80DD6C6B450A5637726B61D58132A867", hash_generated_method = "942322087D37B1E9EBE226F0061408E7")
    
public boolean isValidProxySet() {
        // The proxy host and port can be set within a different thread during
        // an Intent broadcast.
        synchronized (mRequestQueue) {
            return mRequestQueue.getProxyHost() != null;
        }
    }

    /**
     * Get the proxy hostname.
     * @return The proxy hostname obtained from the network queue and proxy
     *         settings.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.750 -0500", hash_original_method = "A2D65C5EAC5BE051C823D07EA076A5B0", hash_generated_method = "33EB32F301695BD2254CA034D9DA93A1")
    
public String getProxyHostname() {
        return mRequestQueue.getProxyHost().getHostName();
    }

    /**
     * @return The proxy username or null if none.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.752 -0500", hash_original_method = "1266E72491C7223244252637AD0BEC00", hash_generated_method = "5E4747E55E698B83588263CB1B1C253C")
    
public synchronized String getProxyUsername() {
        return mProxyUsername;
    }

    /**
     * Sets the proxy username.
     * @param proxyUsername Username to use when
     * connecting through the proxy.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.754 -0500", hash_original_method = "F385770A128D43043A61D29E35184FCC", hash_generated_method = "9C733F51F108046340B0948677C42A45")
    
public synchronized void setProxyUsername(String proxyUsername) {
        if (DebugFlags.NETWORK) {
            Assert.assertTrue(isValidProxySet());
        }

        mProxyUsername = proxyUsername;
    }

    /**
     * @return The proxy password or null if none.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.756 -0500", hash_original_method = "B46568E038B4519332317A487603C5DC", hash_generated_method = "3FC880FB3141392E74DDECBDAED7286C")
    
public synchronized String getProxyPassword() {
        return mProxyPassword;
    }

    /**
     * Sets the proxy password.
     * @param proxyPassword Password to use when
     * connecting through the proxy.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.759 -0500", hash_original_method = "F4CD508AF44DC7CAF5CD08EB1469791C", hash_generated_method = "49482F9B401FCA4F660D544106183811")
    
public synchronized void setProxyPassword(String proxyPassword) {
        if (DebugFlags.NETWORK) {
            Assert.assertTrue(isValidProxySet());
        }

        mProxyPassword = proxyPassword;
    }

    /**
     * Saves the state of network handlers (user SSL and HTTP-authentication
     * preferences).
     * @param outState The out-state to save (write) to.
     * @return True iff succeeds.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.762 -0500", hash_original_method = "7A0CD8F454BFF26B05173D10B6823AEB", hash_generated_method = "2CE211D97D047EFB47C8669D94089E80")
    
public boolean saveState(Bundle outState) {
        if (DebugFlags.NETWORK) {
            Log.v(LOGTAG, "Network.saveState()");
        }

        return mSslErrorHandler.saveState(outState);
    }

    /**
     * Restores the state of network handlers (user SSL and HTTP-authentication
     * preferences).
     * @param inState The in-state to load (read) from.
     * @return True iff succeeds.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.764 -0500", hash_original_method = "47CE65B8425CCCD6D64866E88AA89041", hash_generated_method = "9066BCE4D54754916DEFAD52BAF6D753")
    
public boolean restoreState(Bundle inState) {
        if (DebugFlags.NETWORK) {
            Log.v(LOGTAG, "Network.restoreState()");
        }

        return mSslErrorHandler.restoreState(inState);
    }

    /**
     * Clears user SSL-error preference table.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.766 -0500", hash_original_method = "8F59473C5B0D895146F3319CE625D311", hash_generated_method = "AAA96554D2828DF42DAFBE5212AB61A4")
    
public void clearUserSslPrefTable() {
        mSslErrorHandler.clear();
    }

    /**
     * Handles SSL error(s) on the way up to the user: the user must decide
     * whether errors should be ignored or not.
     * @param loader The loader that resulted in SSL errors.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.768 -0500", hash_original_method = "DEBCC0C268CD067DAE645A47175BAE1D", hash_generated_method = "D98039D6D8600053482022790B1AD718")
    
public void handleSslErrorRequest(LoadListener loader) {
        if (DebugFlags.NETWORK) Assert.assertNotNull(loader);
        if (loader != null) {
            mSslErrorHandler.handleSslErrorRequest(loader);
        }
    }

    
    private class RoamingMonitor extends BroadcastReceiver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.647 -0400", hash_original_method = "FB653F8ECDBB15EF238A4B7D0BC2CB07", hash_generated_method = "FB653F8ECDBB15EF238A4B7D0BC2CB07")
        public RoamingMonitor ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.736 -0500", hash_original_method = "FF6D86ABCD7F084A4EADD45C592C2902", hash_generated_method = "7FC9971AF3685FFFEAE89A59026BBCAC")
        
@Override
        public void onReceive(Context context, Intent intent) {
            if (!ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction()))
                return;

            NetworkInfo info = (NetworkInfo)intent.getParcelableExtra(ConnectivityManager.EXTRA_NETWORK_INFO);
            if (info != null)
                mRoaming = info.isRoaming();
        }

        
    }

    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.770 -0500", hash_original_method = "2B01E9B22836C8DC58E90274FB1B42A2", hash_generated_method = "2B01E9B22836C8DC58E90274FB1B42A2")
    
boolean checkSslPrefTable(LoadListener loader,
            SslError error) {
        if (loader != null && error != null) {
            return mSslErrorHandler.checkSslPrefTable(loader, error);
        }
        return false;
    }

     /**
     * Handles authentication requests on their way up to the user (the user
     * must provide credentials).
     * @param loader The loader that resulted in an HTTP
     * authentication request.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.773 -0500", hash_original_method = "2D361BDF919FB90BFEE4AC2A951EDF8C", hash_generated_method = "2FA62C5737D30F6A8A02EE66F40B4FCB")
    
public void handleAuthRequest(LoadListener loader) {
        if (DebugFlags.NETWORK) Assert.assertNotNull(loader);
        if (loader != null) {
            mHttpAuthHandler.handleAuthRequest(loader);
        }
    }

    // Performance probe
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.775 -0500", hash_original_method = "B02A8324ABFB3032B553A668B2D564CC", hash_generated_method = "24726FF47180D91934DCA773829B2CD6")
    
public void startTiming() {
        mRequestQueue.startTiming();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.777 -0500", hash_original_method = "72F9E7B8510D03EF4E589AB2ED94957F", hash_generated_method = "10D3AADC537A511136564321512800A5")
    
public void stopTiming() {
        mRequestQueue.stopTiming();
    }
}

