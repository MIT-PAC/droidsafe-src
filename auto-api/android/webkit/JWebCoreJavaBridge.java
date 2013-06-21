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
    private int mNativeBridge;
    private boolean mHasInstantTimer;
    private boolean mTimerPaused;
    private boolean mHasDeferredTimers;
    private HashMap<String, String> mContentUriToFilePathMap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.417 -0400", hash_original_method = "24BC54E57520E50B51FEB9301490242D", hash_generated_method = "9B3CC2C64CF55497F3B6EC76A3A8A00C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JWebCoreJavaBridge() {
        nativeConstructor();
        // ---------- Original Method ----------
        //nativeConstructor();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.417 -0400", hash_original_method = "5F428C944882A33820E180A8794913DA", hash_generated_method = "CB8433DCF50F6DDB57C54A958589B3D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.418 -0400", hash_original_method = "02E069F093A33F917985EC0A146AF5DF", hash_generated_method = "482361C838A1D6C0B6F62C16E4D30209")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void fireSharedTimer() {
        mHasInstantTimer = false;
        sharedTimerFired();
        // ---------- Original Method ----------
        //mHasInstantTimer = false;
        //sharedTimerFired();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.419 -0400", hash_original_method = "192555E6E84DEFC9610ACF82B6235778", hash_generated_method = "6032B5B301AAF897A60D790CB9950C7D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void handleMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.419 -0400", hash_original_method = "AB9D63477B4D64307AC8C3CAD493B037", hash_generated_method = "99DCBA412150340B4D68AD691B3EE340")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void signalServiceFuncPtrQueue() {
        Message msg;
        msg = obtainMessage(FUNCPTR_MESSAGE);
        sendMessage(msg);
        // ---------- Original Method ----------
        //Message msg = obtainMessage(FUNCPTR_MESSAGE);
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.419 -0400", hash_original_method = "7F0F2EACA52373092F02E1C8C47DF6D2", hash_generated_method = "6600CFE6221B9A1E6606BE98A91D05C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeServiceFuncPtrQueue() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.419 -0400", hash_original_method = "DCDD00DDB3DA5C0826A1E2E2E5E3FA67", hash_generated_method = "48D54A14874CA7D909FC22CAA61F5535")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.420 -0400", hash_original_method = "E4EBA320047EAFB61B42881338F91526", hash_generated_method = "9FDB9D33D08B0603FE149B8613E9F624")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.420 -0400", hash_original_method = "B06B3FDC2D2CDF223C79F9432CF6B221", hash_generated_method = "4B8613BFD0639FAD225040FB7776F166")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCacheSize(int bytes) {
        dsTaint.addTaint(bytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.420 -0400", hash_original_method = "D5A9FC7DDB356B7F9D175C82B50A2AF1", hash_generated_method = "8C9D7BB47D6B79AA5D062559575A988A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setCookies(String url, String value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(url);
        {
            boolean var391FA15D3BBE1D225A35988C2D3DE539_1073717130 = (value.contains("\r") || value.contains("\n"));
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.421 -0400", hash_original_method = "E3D7D6931554145E868760CB2C4A26A3", hash_generated_method = "5B25066F3E8ADE474A5699FC10C60885")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String cookies(String url) {
        dsTaint.addTaint(url);
        String var6E76092D0131A948F9FF2490F11893A4_622195064 = (CookieManager.getInstance().getCookie(url));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return CookieManager.getInstance().getCookie(url);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.421 -0400", hash_original_method = "E9376C130584FE2146C1CFB7A84FB471", hash_generated_method = "8876DBD176947F9F3BE9B5A78A8B0CCE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean cookiesEnabled() {
        boolean var708720C91D68D319423AD3C37787F455_899544615 = (CookieManager.getInstance().acceptCookie());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return CookieManager.getInstance().acceptCookie();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.421 -0400", hash_original_method = "9CEFD28F2377E55BFA773DC40D227755", hash_generated_method = "C6EB4F3CD1BBAD918B24D2EA0C4B5A71")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String[] getPluginDirectories() {
        String[] varD5F3500725D2F6659EA7FDA07C4F439F_57943782 = (PluginManager.getInstance(null).getPluginDirectories());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return PluginManager.getInstance(null).getPluginDirectories();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.421 -0400", hash_original_method = "EA355C7E0B9693F5192FD4CEC8057AD3", hash_generated_method = "448013755EA32710571C2B797768067E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String getPluginSharedDataDirectory() {
        String varE0B9E98EC3404971D214441C7FF651D7_1828612250 = (PluginManager.getInstance(null).getPluginSharedDataDirectory());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return PluginManager.getInstance(null).getPluginSharedDataDirectory();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.421 -0400", hash_original_method = "8308F15706BD844BBD432043C004CF45", hash_generated_method = "CD31748BA82A525233932E202C23555A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setSharedTimer(long timemillis) {
        dsTaint.addTaint(timemillis);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.422 -0400", hash_original_method = "962436894D889C4038B1520A1ECBED33", hash_generated_method = "A6B11E733B160CC767D95F0317ACE198")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.422 -0400", hash_original_method = "017AD119A16DE91023E8FE76067DD440", hash_generated_method = "ECAC39501F1CC37727BD82715FE5BE51")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String[] getKeyStrengthList() {
        String[] var0AA139A2F6BB9F58347E382436786FAB_1044828599 = (CertTool.getKeyStrengthList());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return CertTool.getKeyStrengthList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.422 -0400", hash_original_method = "A59843A23C4CF1F3FD140F676EC35D8E", hash_generated_method = "6BB07FA535E5C8BA3440FD9F2692F5CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized private String getSignedPublicKey(int index, String challenge,
            String url) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(challenge);
        dsTaint.addTaint(url);
        WebView current;
        current = sCurrentMainWebView.get();
        {
            String var347E28B32DFE1F146AC738CEC00C910D_1357822902 = (CertTool.getSignedPublicKey(
                    current.getContext(), index, challenge));
        } //End block
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.422 -0400", hash_original_method = "7BAB6C5DC5E9A5F66D14195839893242", hash_generated_method = "F429770C09F07043A5E4BE16FEFFC432")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String resolveFilePathForContentUri(String uri) {
        dsTaint.addTaint(uri);
        {
            String fileName;
            fileName = mContentUriToFilePathMap.get(uri);
        } //End block
        Uri jUri;
        jUri = Uri.parse(uri);
        String varD1DE3ACD1D0D12DF52C85C62B6FEAC56_404566425 = (jUri.getLastPathSegment());
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.423 -0400", hash_original_method = "3D9A94F616B3884F20C1C47ABAEE0053", hash_generated_method = "5C904BEE58F8E52A285B97CAAC0C632E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void storeFilePathForContentUri(String path, String contentUri) {
        dsTaint.addTaint(contentUri);
        dsTaint.addTaint(path);
        {
            mContentUriToFilePathMap = new HashMap<String, String>();
        } //End block
        mContentUriToFilePathMap.put(contentUri, path);
        // ---------- Original Method ----------
        //if (mContentUriToFilePathMap == null) {
            //mContentUriToFilePathMap = new HashMap<String, String>();
        //}
        //mContentUriToFilePathMap.put(contentUri, path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.423 -0400", hash_original_method = "48D122DFD280F464E6FED9A0593B265C", hash_generated_method = "056AFF3321B962B4F091468FF0D1B052")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void updateProxy(ProxyProperties proxyProperties) {
        dsTaint.addTaint(proxyProperties.dsTaint);
        {
            nativeUpdateProxy("", "");
        } //End block
        String host;
        host = proxyProperties.getHost();
        int port;
        port = proxyProperties.getPort();
        host += ":" + port;
        nativeUpdateProxy(host, proxyProperties.getExclusionList());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.423 -0400", hash_original_method = "CB9D9CAF93B6F7C6AC078700B30D5B3A", hash_generated_method = "B34C03FE423B4EE0844813601A2B0A67")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeConstructor() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.423 -0400", hash_original_method = "46D026C452E34CB5D17D4D7413C83210", hash_generated_method = "76DCFAD42AA6902991CC86FFBD4823C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeFinalize() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.424 -0400", hash_original_method = "509DDA1BD92D7B897CEF90224EAD9875", hash_generated_method = "AC2815A7BF25B7D98F063D4757A74F41")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sharedTimerFired() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.424 -0400", hash_original_method = "9316866F322C157E5A357156C0328836", hash_generated_method = "54C0C21900AE17FC251299CE2677752A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeUpdatePluginDirectories(String[] directories,
            boolean reload) {
        dsTaint.addTaint(directories[0]);
        dsTaint.addTaint(reload);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.424 -0400", hash_original_method = "DB39049AAE02496ACE7C7C1E193B0ADF", hash_generated_method = "7BFD5A7ED95467712B9CE87AE61F03B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setNetworkOnLine(boolean online) {
        dsTaint.addTaint(online);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.424 -0400", hash_original_method = "E4793A664EF98A715ED3BAC198AF4EBD", hash_generated_method = "D304A649D7D8A6E63A7D598827B85802")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setNetworkType(String type, String subtype) {
        dsTaint.addTaint(subtype);
        dsTaint.addTaint(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.424 -0400", hash_original_method = "E5A69925BDA73DD9E81D8A1F8F42F257", hash_generated_method = "EE5A68D48A9AE02DA1FC215093EB9137")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addPackageNames(Set<String> packageNames) {
        dsTaint.addTaint(packageNames.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.424 -0400", hash_original_method = "B071A6644C9AA816555B15D21EE52FB4", hash_generated_method = "90AA1E10452F794D7CFC15411B478422")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addPackageName(String packageName) {
        dsTaint.addTaint(packageName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.425 -0400", hash_original_method = "143D937A228206F27207E7C61286CEC1", hash_generated_method = "4B2F2639865772F83A06104C532B8F4B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removePackageName(String packageName) {
        dsTaint.addTaint(packageName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.425 -0400", hash_original_method = "562AC1C8CCB348A368D1FD0970777261", hash_generated_method = "2C78A825EF4D06CDD148A63764618FF6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void nativeUpdateProxy(String newProxy, String exclusionList) {
        dsTaint.addTaint(exclusionList);
        dsTaint.addTaint(newProxy);
    }

    
    private static final int TIMER_MESSAGE = 1;
    private static final int FUNCPTR_MESSAGE = 2;
    private static final String LOGTAG = "webkit-timers";
    private static WeakReference<WebView> sCurrentMainWebView =
            new WeakReference<WebView>(null);
    static final int REFRESH_PLUGINS = 100;
}

