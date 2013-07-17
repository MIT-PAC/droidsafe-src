package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.net.ProxyProperties;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Set;

final class JWebCoreJavaBridge extends Handler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.197 -0400", hash_original_field = "18E62AA806BC4A382C7823F4E0961736", hash_generated_field = "2974AA9EDEE26975BC6F1AFB9A7C8BD7")

    private int mNativeBridge;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.197 -0400", hash_original_field = "CD0832D4BFC5573797C2935D215714C7", hash_generated_field = "342700A0FE874BB513D596DC9C742A46")

    private boolean mHasInstantTimer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.197 -0400", hash_original_field = "A442A3B2590A0A2ADC19B92455307949", hash_generated_field = "4C6E6459810428DDB9069F262AE62676")

    private boolean mTimerPaused;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.197 -0400", hash_original_field = "EF6696E7B17246F0252D33A961BF0093", hash_generated_field = "64B51006061AD1592250F72E98B31DCF")

    private boolean mHasDeferredTimers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.197 -0400", hash_original_field = "70C6B6BC82471EFD58A06B50385328AA", hash_generated_field = "54D1A4080AE3D1D4D0316390BB67ECCC")

    private HashMap<String, String> mContentUriToFilePathMap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.197 -0400", hash_original_method = "24BC54E57520E50B51FEB9301490242D", hash_generated_method = "9B3CC2C64CF55497F3B6EC76A3A8A00C")
    public  JWebCoreJavaBridge() {
        nativeConstructor();
        // ---------- Original Method ----------
        //nativeConstructor();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.197 -0400", hash_original_method = "5F428C944882A33820E180A8794913DA", hash_generated_method = "CB8433DCF50F6DDB57C54A958589B3D3")
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.198 -0400", hash_original_method = "02E069F093A33F917985EC0A146AF5DF", hash_generated_method = "482361C838A1D6C0B6F62C16E4D30209")
    private void fireSharedTimer() {
        mHasInstantTimer = false;
        sharedTimerFired();
        // ---------- Original Method ----------
        //mHasInstantTimer = false;
        //sharedTimerFired();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.198 -0400", hash_original_method = "192555E6E84DEFC9610ACF82B6235778", hash_generated_method = "8BD83333526CED9E93B0787061AADDC3")
    @Override
    public void handleMessage(Message msg) {
        addTaint(msg.getTaint());
switch(msg.what){
        case TIMER_MESSAGE:
        {
            if(mTimerPaused)            
            {
                mHasDeferredTimers = true;
            } //End block
            else
            {
                fireSharedTimer();
            } //End block
            break;
        } //End block
        case FUNCPTR_MESSAGE:
        nativeServiceFuncPtrQueue();
        break;
        case REFRESH_PLUGINS:
        nativeUpdatePluginDirectories(PluginManager.getInstance(null)
                        .getPluginDirectories(), ((Boolean) msg.obj)
                        .booleanValue());
        break;
}
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.198 -0400", hash_original_method = "AB9D63477B4D64307AC8C3CAD493B037", hash_generated_method = "E6C1DD8C897E1EE49852D729942B140D")
    private void signalServiceFuncPtrQueue() {
        Message msg = obtainMessage(FUNCPTR_MESSAGE);
        sendMessage(msg);
        // ---------- Original Method ----------
        //Message msg = obtainMessage(FUNCPTR_MESSAGE);
        //sendMessage(msg);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.198 -0400", hash_original_method = "7F0F2EACA52373092F02E1C8C47DF6D2", hash_generated_method = "6600CFE6221B9A1E6606BE98A91D05C6")
    private void nativeServiceFuncPtrQueue() {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.199 -0400", hash_original_method = "DCDD00DDB3DA5C0826A1E2E2E5E3FA67", hash_generated_method = "96A1FD464DCFA4908690A441DD814413")
    public void pause() {
        if(!mTimerPaused)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.200 -0400", hash_original_method = "E4EBA320047EAFB61B42881338F91526", hash_generated_method = "208A1453BF2BF315D5D04C9D97B4C275")
    public void resume() {
        if(mTimerPaused)        
        {
            mTimerPaused = false;
            if(mHasDeferredTimers)            
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.200 -0400", hash_original_method = "B06B3FDC2D2CDF223C79F9432CF6B221", hash_generated_method = "40CEB3675B2F6C9D2120A50F6D591BB2")
    public void setCacheSize(int bytes) {
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.200 -0400", hash_original_method = "D5A9FC7DDB356B7F9D175C82B50A2AF1", hash_generated_method = "29D5F5345B4E8FB18A42984A246E1751")
    private void setCookies(String url, String value) {
        addTaint(value.getTaint());
        addTaint(url.getTaint());
        if(value.contains("\r") || value.contains("\n"))        
        {
            int size = value.length();
            StringBuilder buffer = new StringBuilder(size);
            int i = 0;
            while
(i != -1 && i < size)            
            {
                int ir = value.indexOf('\r', i);
                int in = value.indexOf('\n', i);
                int newi = (ir == -1) ? in : (in == -1 ? ir : (ir < in ? ir
                        : in));
                if(newi > i)                
                {
                    buffer.append(value.subSequence(i, newi));
                } //End block
                else
                if(newi == -1)                
                {
                    buffer.append(value.subSequence(i, size));
                    break;
                } //End block
                i = newi + 1;
            } //End block
            value = buffer.toString();
        } //End block
        CookieManager.getInstance().setCookie(url, value);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.201 -0400", hash_original_method = "E3D7D6931554145E868760CB2C4A26A3", hash_generated_method = "906852C9798F82C317DAEB577552160E")
    private String cookies(String url) {
        addTaint(url.getTaint());
String varAECD863DE9AAC895DB47A4271B851D54_844602701 =         CookieManager.getInstance().getCookie(url);
        varAECD863DE9AAC895DB47A4271B851D54_844602701.addTaint(taint);
        return varAECD863DE9AAC895DB47A4271B851D54_844602701;
        // ---------- Original Method ----------
        //return CookieManager.getInstance().getCookie(url);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.201 -0400", hash_original_method = "E9376C130584FE2146C1CFB7A84FB471", hash_generated_method = "EC1527D0A619519488EDA7F37ED6CA3D")
    private boolean cookiesEnabled() {
        boolean varD80850DD1D24F86E3200FD3D2B28A132_1578149805 = (CookieManager.getInstance().acceptCookie());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_739948412 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_739948412;
        // ---------- Original Method ----------
        //return CookieManager.getInstance().acceptCookie();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.201 -0400", hash_original_method = "9CEFD28F2377E55BFA773DC40D227755", hash_generated_method = "BF6DA43F9D145CCBA73817B0EA70A5A4")
    private String[] getPluginDirectories() {
String[] var07F6A7380CC680CBDF46335135D62147_899808675 =         PluginManager.getInstance(null).getPluginDirectories();
        var07F6A7380CC680CBDF46335135D62147_899808675.addTaint(taint);
        return var07F6A7380CC680CBDF46335135D62147_899808675;
        // ---------- Original Method ----------
        //return PluginManager.getInstance(null).getPluginDirectories();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.201 -0400", hash_original_method = "EA355C7E0B9693F5192FD4CEC8057AD3", hash_generated_method = "3960E0E5D1B361CBAAC87891AAC48CE7")
    private String getPluginSharedDataDirectory() {
String var0D77ECDD31455C4DF86C73A42D37FC8D_1960142804 =         PluginManager.getInstance(null).getPluginSharedDataDirectory();
        var0D77ECDD31455C4DF86C73A42D37FC8D_1960142804.addTaint(taint);
        return var0D77ECDD31455C4DF86C73A42D37FC8D_1960142804;
        // ---------- Original Method ----------
        //return PluginManager.getInstance(null).getPluginSharedDataDirectory();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.201 -0400", hash_original_method = "8308F15706BD844BBD432043C004CF45", hash_generated_method = "A512D0498C6FE08096B54AEFDDC32E76")
    private void setSharedTimer(long timemillis) {
        addTaint(timemillis);
        if(DebugFlags.J_WEB_CORE_JAVA_BRIDGE){ }        if(timemillis <= 0)        
        {
            if(mHasInstantTimer)            
            {
                return;
            } //End block
            else
            {
                mHasInstantTimer = true;
                Message msg = obtainMessage(TIMER_MESSAGE);
                sendMessageDelayed(msg, timemillis);
            } //End block
        } //End block
        else
        {
            Message msg = obtainMessage(TIMER_MESSAGE);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.202 -0400", hash_original_method = "962436894D889C4038B1520A1ECBED33", hash_generated_method = "68B6C2CBBFA028BD9F485378FE8F067F")
    private void stopSharedTimer() {
        if(DebugFlags.J_WEB_CORE_JAVA_BRIDGE)        
        {
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.202 -0400", hash_original_method = "017AD119A16DE91023E8FE76067DD440", hash_generated_method = "DBDA05051204538090FDE7915D2936FD")
    private String[] getKeyStrengthList() {
String[] varDBCAD717D2F0C05E3C7F0AAD2619EDB5_361597117 =         CertTool.getKeyStrengthList();
        varDBCAD717D2F0C05E3C7F0AAD2619EDB5_361597117.addTaint(taint);
        return varDBCAD717D2F0C05E3C7F0AAD2619EDB5_361597117;
        // ---------- Original Method ----------
        //return CertTool.getKeyStrengthList();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.202 -0400", hash_original_method = "A59843A23C4CF1F3FD140F676EC35D8E", hash_generated_method = "AA64CDE9F80BCB797E1AED4A9F17E1D6")
    synchronized private String getSignedPublicKey(int index, String challenge,
            String url) {
        addTaint(url.getTaint());
        addTaint(challenge.getTaint());
        addTaint(index);
        WebView current = sCurrentMainWebView.get();
        if(current != null)        
        {
String var6B3A61A0AB4A4B0F95275D92D5A6DE51_861029800 =             CertTool.getSignedPublicKey(
                    current.getContext(), index, challenge);
            var6B3A61A0AB4A4B0F95275D92D5A6DE51_861029800.addTaint(taint);
            return var6B3A61A0AB4A4B0F95275D92D5A6DE51_861029800;
        } //End block
        else
        {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_997479125 =             "";
            var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_997479125.addTaint(taint);
            return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_997479125;
        } //End block
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.204 -0400", hash_original_method = "7BAB6C5DC5E9A5F66D14195839893242", hash_generated_method = "66E20C7AB7E984F23F21A1AB41CDAEB5")
    private String resolveFilePathForContentUri(String uri) {
        addTaint(uri.getTaint());
        if(mContentUriToFilePathMap != null)        
        {
            String fileName = mContentUriToFilePathMap.get(uri);
            if(fileName != null)            
            {
String varBD5EACC393579FDF5D0E813DB68A2F73_2117982418 =                 fileName;
                varBD5EACC393579FDF5D0E813DB68A2F73_2117982418.addTaint(taint);
                return varBD5EACC393579FDF5D0E813DB68A2F73_2117982418;
            } //End block
        } //End block
        Uri jUri = Uri.parse(uri);
String var1EE236BB903DF73F2308F7F9F181EF48_1936949001 =         jUri.getLastPathSegment();
        var1EE236BB903DF73F2308F7F9F181EF48_1936949001.addTaint(taint);
        return var1EE236BB903DF73F2308F7F9F181EF48_1936949001;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.205 -0400", hash_original_method = "3D9A94F616B3884F20C1C47ABAEE0053", hash_generated_method = "D491AE7D999DA9602D8EE674E69E0FE6")
    public void storeFilePathForContentUri(String path, String contentUri) {
        addTaint(contentUri.getTaint());
        addTaint(path.getTaint());
        if(mContentUriToFilePathMap == null)        
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.205 -0400", hash_original_method = "48D122DFD280F464E6FED9A0593B265C", hash_generated_method = "F61E5C3079FECEB52B2DB1D9B7433BD0")
    public void updateProxy(ProxyProperties proxyProperties) {
        addTaint(proxyProperties.getTaint());
        if(proxyProperties == null)        
        {
            nativeUpdateProxy("", "");
            return;
        } //End block
        String host = proxyProperties.getHost();
        int port = proxyProperties.getPort();
        if(port != 0)        
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.205 -0400", hash_original_method = "CB9D9CAF93B6F7C6AC078700B30D5B3A", hash_generated_method = "B34C03FE423B4EE0844813601A2B0A67")
    private void nativeConstructor() {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.205 -0400", hash_original_method = "46D026C452E34CB5D17D4D7413C83210", hash_generated_method = "76DCFAD42AA6902991CC86FFBD4823C2")
    private void nativeFinalize() {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.205 -0400", hash_original_method = "509DDA1BD92D7B897CEF90224EAD9875", hash_generated_method = "AC2815A7BF25B7D98F063D4757A74F41")
    private void sharedTimerFired() {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.205 -0400", hash_original_method = "9316866F322C157E5A357156C0328836", hash_generated_method = "0894466BDD76BC6CCF8988BD75C70B60")
    private void nativeUpdatePluginDirectories(String[] directories,
            boolean reload) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.205 -0400", hash_original_method = "DB39049AAE02496ACE7C7C1E193B0ADF", hash_generated_method = "D032B386D2B3E2A3611A9E9397D501D0")
    public void setNetworkOnLine(boolean online) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.205 -0400", hash_original_method = "E4793A664EF98A715ED3BAC198AF4EBD", hash_generated_method = "0BF6A0594BE2D247A95E23B02A51ECCF")
    public void setNetworkType(String type, String subtype) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.205 -0400", hash_original_method = "E5A69925BDA73DD9E81D8A1F8F42F257", hash_generated_method = "FC09152D312FECD521F2567721C332CC")
    public void addPackageNames(Set<String> packageNames) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.206 -0400", hash_original_method = "B071A6644C9AA816555B15D21EE52FB4", hash_generated_method = "0C564C4E48A08A51377B9BD8DC556B50")
    public void addPackageName(String packageName) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.206 -0400", hash_original_method = "143D937A228206F27207E7C61286CEC1", hash_generated_method = "1C9E54868B04A06DAF8309867D2F41A3")
    public void removePackageName(String packageName) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.206 -0400", hash_original_method = "562AC1C8CCB348A368D1FD0970777261", hash_generated_method = "CDD15C7E3E55587B192A2AF9CC08B56E")
    public void nativeUpdateProxy(String newProxy, String exclusionList) {
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.206 -0400", hash_original_field = "E605D42EB73FFC3A754B2D2A5777F037", hash_generated_field = "9DF6119D97ECEA39D23976C04D9D93AA")

    private static final int TIMER_MESSAGE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.206 -0400", hash_original_field = "EA6FA30767B7541B3846DAF787248B20", hash_generated_field = "D296A0461F81AE27D7536C23AFDC4097")

    private static final int FUNCPTR_MESSAGE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.206 -0400", hash_original_field = "E7F58239AAFF2B37572DB3BEF0D72545", hash_generated_field = "C340BEA9652E0C495B0427C6F473E96D")

    private static final String LOGTAG = "webkit-timers";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.206 -0400", hash_original_field = "2EA719E7C7067924CD967FC04C8E9BCF", hash_generated_field = "A39D15884D133A48C6F4DB6358E9DE25")

    private static WeakReference<WebView> sCurrentMainWebView = new WeakReference<WebView>(null);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.206 -0400", hash_original_field = "87AA02B49A4F562563740C3EA85FEADB", hash_generated_field = "F5D453B28C787626695D682CFDA8F348")

    static final int REFRESH_PLUGINS = 100;
}

