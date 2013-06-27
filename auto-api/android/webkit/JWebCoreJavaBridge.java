package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.net.ProxyProperties;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Set;

final class JWebCoreJavaBridge extends Handler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.788 -0400", hash_original_field = "18E62AA806BC4A382C7823F4E0961736", hash_generated_field = "2974AA9EDEE26975BC6F1AFB9A7C8BD7")

    private int mNativeBridge;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.788 -0400", hash_original_field = "CD0832D4BFC5573797C2935D215714C7", hash_generated_field = "342700A0FE874BB513D596DC9C742A46")

    private boolean mHasInstantTimer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.788 -0400", hash_original_field = "A442A3B2590A0A2ADC19B92455307949", hash_generated_field = "4C6E6459810428DDB9069F262AE62676")

    private boolean mTimerPaused;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.788 -0400", hash_original_field = "EF6696E7B17246F0252D33A961BF0093", hash_generated_field = "64B51006061AD1592250F72E98B31DCF")

    private boolean mHasDeferredTimers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.788 -0400", hash_original_field = "70C6B6BC82471EFD58A06B50385328AA", hash_generated_field = "54D1A4080AE3D1D4D0316390BB67ECCC")

    private HashMap<String, String> mContentUriToFilePathMap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.789 -0400", hash_original_method = "24BC54E57520E50B51FEB9301490242D", hash_generated_method = "9B3CC2C64CF55497F3B6EC76A3A8A00C")
    public  JWebCoreJavaBridge() {
        nativeConstructor();
        // ---------- Original Method ----------
        //nativeConstructor();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.789 -0400", hash_original_method = "5F428C944882A33820E180A8794913DA", hash_generated_method = "CB8433DCF50F6DDB57C54A958589B3D3")
    @Override
    protected void finalize() {
        nativeFinalize();
        // ---------- Original Method ----------
        //nativeFinalize();
    }

    
        static synchronized void setActiveWebView(WebView webview) {
        if (sCurrentMainWebView.get() != null) {
            return;
        }
        sCurrentMainWebView = new WeakReference<WebView>(webview);
    }

    
        static synchronized void removeActiveWebView(WebView webview) {
        if (sCurrentMainWebView.get() != webview) {
            return;
        }
        sCurrentMainWebView.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.807 -0400", hash_original_method = "02E069F093A33F917985EC0A146AF5DF", hash_generated_method = "482361C838A1D6C0B6F62C16E4D30209")
    private void fireSharedTimer() {
        mHasInstantTimer = false;
        sharedTimerFired();
        // ---------- Original Method ----------
        //mHasInstantTimer = false;
        //sharedTimerFired();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.808 -0400", hash_original_method = "192555E6E84DEFC9610ACF82B6235778", hash_generated_method = "3561BFEFAFDD33E4572CBA3F191003F0")
    @Override
    public void handleMessage(Message msg) {
        //Begin case TIMER_MESSAGE 
        {
            {
                mHasDeferredTimers = true;
            } //End block
            {
                fireSharedTimer();
            } //End block
        } //End block
        //End case TIMER_MESSAGE 
        //Begin case FUNCPTR_MESSAGE 
        nativeServiceFuncPtrQueue();
        //End case FUNCPTR_MESSAGE 
        //Begin case REFRESH_PLUGINS 
        nativeUpdatePluginDirectories(PluginManager.getInstance(null)
                        .getPluginDirectories(), ((Boolean) msg.obj)
                        .booleanValue());
        //End case REFRESH_PLUGINS 
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //switch (msg.what) {
            //case TIMER_MESSAGE: {
                //if (mTimerPaused) {
                    //mHasDeferredTimers = true;
                //} else {
                    //fireSharedTimer();
                //}
                //break;
            //}
            //case FUNCPTR_MESSAGE:
                //nativeServiceFuncPtrQueue();
                //break;
            //case REFRESH_PLUGINS:
                //nativeUpdatePluginDirectories(PluginManager.getInstance(null)
                        //.getPluginDirectories(), ((Boolean) msg.obj)
                        //.booleanValue());
                //break;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.812 -0400", hash_original_method = "AB9D63477B4D64307AC8C3CAD493B037", hash_generated_method = "99DCBA412150340B4D68AD691B3EE340")
    private void signalServiceFuncPtrQueue() {
        Message msg;
        msg = obtainMessage(FUNCPTR_MESSAGE);
        sendMessage(msg);
        // ---------- Original Method ----------
        //Message msg = obtainMessage(FUNCPTR_MESSAGE);
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.812 -0400", hash_original_method = "7F0F2EACA52373092F02E1C8C47DF6D2", hash_generated_method = "6600CFE6221B9A1E6606BE98A91D05C6")
    private void nativeServiceFuncPtrQueue() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.812 -0400", hash_original_method = "DCDD00DDB3DA5C0826A1E2E2E5E3FA67", hash_generated_method = "48D54A14874CA7D909FC22CAA61F5535")
    public void pause() {
        {
            mTimerPaused = true;
            mHasDeferredTimers = false;
        } //End block
        // ---------- Original Method ----------
        //if (!mTimerPaused) {
            //mTimerPaused = true;
            //mHasDeferredTimers = false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.815 -0400", hash_original_method = "E4EBA320047EAFB61B42881338F91526", hash_generated_method = "9FDB9D33D08B0603FE149B8613E9F624")
    public void resume() {
        {
            mTimerPaused = false;
            {
                mHasDeferredTimers = false;
                fireSharedTimer();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mTimerPaused) {
           //mTimerPaused = false;
           //if (mHasDeferredTimers) {
               //mHasDeferredTimers = false;
               //fireSharedTimer();
           //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.826 -0400", hash_original_method = "B06B3FDC2D2CDF223C79F9432CF6B221", hash_generated_method = "40CEB3675B2F6C9D2120A50F6D591BB2")
    public void setCacheSize(int bytes) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.827 -0400", hash_original_method = "D5A9FC7DDB356B7F9D175C82B50A2AF1", hash_generated_method = "FF16B0FBFC1243A10178F22E294F717F")
    private void setCookies(String url, String value) {
        {
            boolean var391FA15D3BBE1D225A35988C2D3DE539_1790736975 = (value.contains("\r") || value.contains("\n"));
            {
                int size;
                size = value.length();
                StringBuilder buffer;
                buffer = new StringBuilder(size);
                int i;
                i = 0;
                {
                    int ir;
                    ir = value.indexOf('\r', i);
                    int in;
                    in = value.indexOf('\n', i);
                    int newi;
                    newi = in;
                    newi = (in == -1 ? ir : (ir < in ? ir
                        : in));
                    {
                        buffer.append(value.subSequence(i, newi));
                    } //End block
                    {
                        buffer.append(value.subSequence(i, size));
                    } //End block
                    i = newi + 1;
                } //End block
                value = buffer.toString();
            } //End block
        } //End collapsed parenthetic
        CookieManager.getInstance().setCookie(url, value);
        addTaint(url.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.828 -0400", hash_original_method = "E3D7D6931554145E868760CB2C4A26A3", hash_generated_method = "8E23F6900CCE5E6D70CE4004BF63C611")
    private String cookies(String url) {
        String varB4EAC82CA7396A68D541C85D26508E83_1605656202 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1605656202 = CookieManager.getInstance().getCookie(url);
        addTaint(url.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1605656202.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1605656202;
        // ---------- Original Method ----------
        //return CookieManager.getInstance().getCookie(url);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.828 -0400", hash_original_method = "E9376C130584FE2146C1CFB7A84FB471", hash_generated_method = "BAE5E1D95B26FEF4A99E122B81F86C87")
    private boolean cookiesEnabled() {
        boolean var708720C91D68D319423AD3C37787F455_422845118 = (CookieManager.getInstance().acceptCookie());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1010000460 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1010000460;
        // ---------- Original Method ----------
        //return CookieManager.getInstance().acceptCookie();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.829 -0400", hash_original_method = "9CEFD28F2377E55BFA773DC40D227755", hash_generated_method = "1261822132B7339DDF6130722FB9D175")
    private String[] getPluginDirectories() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1763656299 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1763656299 = PluginManager.getInstance(null).getPluginDirectories();
        varB4EAC82CA7396A68D541C85D26508E83_1763656299.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1763656299;
        // ---------- Original Method ----------
        //return PluginManager.getInstance(null).getPluginDirectories();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.844 -0400", hash_original_method = "EA355C7E0B9693F5192FD4CEC8057AD3", hash_generated_method = "043D63701E9CEB25E3878846CC7BFBAA")
    private String getPluginSharedDataDirectory() {
        String varB4EAC82CA7396A68D541C85D26508E83_1663814549 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1663814549 = PluginManager.getInstance(null).getPluginSharedDataDirectory();
        varB4EAC82CA7396A68D541C85D26508E83_1663814549.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1663814549;
        // ---------- Original Method ----------
        //return PluginManager.getInstance(null).getPluginSharedDataDirectory();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.844 -0400", hash_original_method = "8308F15706BD844BBD432043C004CF45", hash_generated_method = "206FA719680892EE366B5EFD17D66A70")
    private void setSharedTimer(long timemillis) {
        {
            {
                mHasInstantTimer = true;
                Message msg;
                msg = obtainMessage(TIMER_MESSAGE);
                sendMessageDelayed(msg, timemillis);
            } //End block
        } //End block
        {
            Message msg;
            msg = obtainMessage(TIMER_MESSAGE);
            sendMessageDelayed(msg, timemillis);
        } //End block
        addTaint(timemillis);
        // ---------- Original Method ----------
        //if (DebugFlags.J_WEB_CORE_JAVA_BRIDGE) Log.v(LOGTAG, "setSharedTimer " + timemillis);
        //if (timemillis <= 0) {
            //if (mHasInstantTimer) {
                //return;
            //} else {
                //mHasInstantTimer = true;
                //Message msg = obtainMessage(TIMER_MESSAGE);
                //sendMessageDelayed(msg, timemillis);
            //}
        //} else {
            //Message msg = obtainMessage(TIMER_MESSAGE);
            //sendMessageDelayed(msg, timemillis);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.845 -0400", hash_original_method = "962436894D889C4038B1520A1ECBED33", hash_generated_method = "A6B11E733B160CC767D95F0317ACE198")
    private void stopSharedTimer() {
        removeMessages(TIMER_MESSAGE);
        mHasInstantTimer = false;
        mHasDeferredTimers = false;
        // ---------- Original Method ----------
        //if (DebugFlags.J_WEB_CORE_JAVA_BRIDGE) {
            //Log.v(LOGTAG, "stopSharedTimer removing all timers");
        //}
        //removeMessages(TIMER_MESSAGE);
        //mHasInstantTimer = false;
        //mHasDeferredTimers = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.846 -0400", hash_original_method = "017AD119A16DE91023E8FE76067DD440", hash_generated_method = "20CD708D6750D687708FCC589997BFB9")
    private String[] getKeyStrengthList() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1474203713 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1474203713 = CertTool.getKeyStrengthList();
        varB4EAC82CA7396A68D541C85D26508E83_1474203713.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1474203713;
        // ---------- Original Method ----------
        //return CertTool.getKeyStrengthList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.847 -0400", hash_original_method = "A59843A23C4CF1F3FD140F676EC35D8E", hash_generated_method = "A1DDFA7D57CFF187F229392C1342C045")
    synchronized private String getSignedPublicKey(int index, String challenge,
            String url) {
        String varB4EAC82CA7396A68D541C85D26508E83_1213246305 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_957931923 = null; //Variable for return #2
        WebView current;
        current = sCurrentMainWebView.get();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1213246305 = CertTool.getSignedPublicKey(
                    current.getContext(), index, challenge);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_957931923 = "";
        } //End block
        addTaint(index);
        addTaint(challenge.getTaint());
        addTaint(url.getTaint());
        String varA7E53CE21691AB073D9660D615818899_963982230; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_963982230 = varB4EAC82CA7396A68D541C85D26508E83_1213246305;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_963982230 = varB4EAC82CA7396A68D541C85D26508E83_957931923;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_963982230.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_963982230;
        // ---------- Original Method ----------
        //WebView current = sCurrentMainWebView.get();
        //if (current != null) {
            //return CertTool.getSignedPublicKey(
                    //current.getContext(), index, challenge);
        //} else {
            //Log.e(LOGTAG, "There is no active WebView for getSignedPublicKey");
            //return "";
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.859 -0400", hash_original_method = "7BAB6C5DC5E9A5F66D14195839893242", hash_generated_method = "0C2566E8F9F214BCCAE4962D23E84944")
    private String resolveFilePathForContentUri(String uri) {
        String varB4EAC82CA7396A68D541C85D26508E83_1694216912 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1007776086 = null; //Variable for return #2
        {
            String fileName;
            fileName = mContentUriToFilePathMap.get(uri);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1694216912 = fileName;
            } //End block
        } //End block
        Uri jUri;
        jUri = Uri.parse(uri);
        varB4EAC82CA7396A68D541C85D26508E83_1007776086 = jUri.getLastPathSegment();
        addTaint(uri.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1810479264; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1810479264 = varB4EAC82CA7396A68D541C85D26508E83_1694216912;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1810479264 = varB4EAC82CA7396A68D541C85D26508E83_1007776086;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1810479264.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1810479264;
        // ---------- Original Method ----------
        //if (mContentUriToFilePathMap != null) {
            //String fileName = mContentUriToFilePathMap.get(uri);
            //if (fileName != null) {
                //return fileName;
            //}
        //}
        //Uri jUri = Uri.parse(uri);
        //return jUri.getLastPathSegment();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.860 -0400", hash_original_method = "3D9A94F616B3884F20C1C47ABAEE0053", hash_generated_method = "5A30E54EA39E5C7AA05BB3EA892C4C7B")
    public void storeFilePathForContentUri(String path, String contentUri) {
        {
            mContentUriToFilePathMap = new HashMap<String, String>();
        } //End block
        mContentUriToFilePathMap.put(contentUri, path);
        addTaint(path.getTaint());
        addTaint(contentUri.getTaint());
        // ---------- Original Method ----------
        //if (mContentUriToFilePathMap == null) {
            //mContentUriToFilePathMap = new HashMap<String, String>();
        //}
        //mContentUriToFilePathMap.put(contentUri, path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.860 -0400", hash_original_method = "48D122DFD280F464E6FED9A0593B265C", hash_generated_method = "DF37DC564AF2DD316629A3D1024BF71C")
    public void updateProxy(ProxyProperties proxyProperties) {
        {
            nativeUpdateProxy("", "");
        } //End block
        String host;
        host = proxyProperties.getHost();
        int port;
        port = proxyProperties.getPort();
        host += ":" + port;
        nativeUpdateProxy(host, proxyProperties.getExclusionList());
        addTaint(proxyProperties.getTaint());
        // ---------- Original Method ----------
        //if (proxyProperties == null) {
            //nativeUpdateProxy("", "");
            //return;
        //}
        //String host = proxyProperties.getHost();
        //int port = proxyProperties.getPort();
        //if (port != 0)
            //host += ":" + port;
        //nativeUpdateProxy(host, proxyProperties.getExclusionList());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.860 -0400", hash_original_method = "CB9D9CAF93B6F7C6AC078700B30D5B3A", hash_generated_method = "B34C03FE423B4EE0844813601A2B0A67")
    private void nativeConstructor() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.861 -0400", hash_original_method = "46D026C452E34CB5D17D4D7413C83210", hash_generated_method = "76DCFAD42AA6902991CC86FFBD4823C2")
    private void nativeFinalize() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.862 -0400", hash_original_method = "509DDA1BD92D7B897CEF90224EAD9875", hash_generated_method = "AC2815A7BF25B7D98F063D4757A74F41")
    private void sharedTimerFired() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.862 -0400", hash_original_method = "9316866F322C157E5A357156C0328836", hash_generated_method = "0894466BDD76BC6CCF8988BD75C70B60")
    private void nativeUpdatePluginDirectories(String[] directories,
            boolean reload) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.874 -0400", hash_original_method = "DB39049AAE02496ACE7C7C1E193B0ADF", hash_generated_method = "D032B386D2B3E2A3611A9E9397D501D0")
    public void setNetworkOnLine(boolean online) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.874 -0400", hash_original_method = "E4793A664EF98A715ED3BAC198AF4EBD", hash_generated_method = "0BF6A0594BE2D247A95E23B02A51ECCF")
    public void setNetworkType(String type, String subtype) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.874 -0400", hash_original_method = "E5A69925BDA73DD9E81D8A1F8F42F257", hash_generated_method = "FC09152D312FECD521F2567721C332CC")
    public void addPackageNames(Set<String> packageNames) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.874 -0400", hash_original_method = "B071A6644C9AA816555B15D21EE52FB4", hash_generated_method = "0C564C4E48A08A51377B9BD8DC556B50")
    public void addPackageName(String packageName) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.875 -0400", hash_original_method = "143D937A228206F27207E7C61286CEC1", hash_generated_method = "1C9E54868B04A06DAF8309867D2F41A3")
    public void removePackageName(String packageName) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.875 -0400", hash_original_method = "562AC1C8CCB348A368D1FD0970777261", hash_generated_method = "CDD15C7E3E55587B192A2AF9CC08B56E")
    public void nativeUpdateProxy(String newProxy, String exclusionList) {
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.875 -0400", hash_original_field = "E605D42EB73FFC3A754B2D2A5777F037", hash_generated_field = "DABFF1EC7FB648B44A3D6F27BDE5CA4F")

    private static int TIMER_MESSAGE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.875 -0400", hash_original_field = "EA6FA30767B7541B3846DAF787248B20", hash_generated_field = "ADD077D885E205B1E59B079D0E2EC284")

    private static int FUNCPTR_MESSAGE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.875 -0400", hash_original_field = "E7F58239AAFF2B37572DB3BEF0D72545", hash_generated_field = "62B6FB8719671251D429286AC1A992CD")

    private static String LOGTAG = "webkit-timers";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.875 -0400", hash_original_field = "2EA719E7C7067924CD967FC04C8E9BCF", hash_generated_field = "A39D15884D133A48C6F4DB6358E9DE25")

    private static WeakReference<WebView> sCurrentMainWebView = new WeakReference<WebView>(null);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.875 -0400", hash_original_field = "87AA02B49A4F562563740C3EA85FEADB", hash_generated_field = "5FD6D3F6721815F68980BACF575113CD")

    static int REFRESH_PLUGINS = 100;
}

