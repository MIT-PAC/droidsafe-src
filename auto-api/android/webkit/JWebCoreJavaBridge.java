package android.webkit;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.951 -0400", hash_original_field = "18E62AA806BC4A382C7823F4E0961736", hash_generated_field = "2974AA9EDEE26975BC6F1AFB9A7C8BD7")

    private int mNativeBridge;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.951 -0400", hash_original_field = "CD0832D4BFC5573797C2935D215714C7", hash_generated_field = "342700A0FE874BB513D596DC9C742A46")

    private boolean mHasInstantTimer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.951 -0400", hash_original_field = "A442A3B2590A0A2ADC19B92455307949", hash_generated_field = "4C6E6459810428DDB9069F262AE62676")

    private boolean mTimerPaused;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.951 -0400", hash_original_field = "EF6696E7B17246F0252D33A961BF0093", hash_generated_field = "64B51006061AD1592250F72E98B31DCF")

    private boolean mHasDeferredTimers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.951 -0400", hash_original_field = "70C6B6BC82471EFD58A06B50385328AA", hash_generated_field = "54D1A4080AE3D1D4D0316390BB67ECCC")

    private HashMap<String, String> mContentUriToFilePathMap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.951 -0400", hash_original_method = "24BC54E57520E50B51FEB9301490242D", hash_generated_method = "9B3CC2C64CF55497F3B6EC76A3A8A00C")
    public  JWebCoreJavaBridge() {
        nativeConstructor();
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.952 -0400", hash_original_method = "5F428C944882A33820E180A8794913DA", hash_generated_method = "CB8433DCF50F6DDB57C54A958589B3D3")
    @Override
    protected void finalize() {
        nativeFinalize();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    static synchronized void setActiveWebView(WebView webview) {
        if (sCurrentMainWebView.get() != null) {
            return;
        }
        sCurrentMainWebView = new WeakReference<WebView>(webview);
    }

    
    @DSModeled(DSC.SAFE)
    static synchronized void removeActiveWebView(WebView webview) {
        if (sCurrentMainWebView.get() != webview) {
            return;
        }
        sCurrentMainWebView.clear();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.952 -0400", hash_original_method = "02E069F093A33F917985EC0A146AF5DF", hash_generated_method = "482361C838A1D6C0B6F62C16E4D30209")
    private void fireSharedTimer() {
        mHasInstantTimer = false;
        sharedTimerFired();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.953 -0400", hash_original_method = "192555E6E84DEFC9610ACF82B6235778", hash_generated_method = "3561BFEFAFDD33E4572CBA3F191003F0")
    @Override
    public void handleMessage(Message msg) {
        
        {
            {
                mHasDeferredTimers = true;
            } 
            {
                fireSharedTimer();
            } 
        } 
        
        
        nativeServiceFuncPtrQueue();
        
        
        nativeUpdatePluginDirectories(PluginManager.getInstance(null)
                        .getPluginDirectories(), ((Boolean) msg.obj)
                        .booleanValue());
        
        addTaint(msg.getTaint());
        
        
            
                
                    
                
                    
                
                
            
            
                
                
            
                
                        
                        
                
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.953 -0400", hash_original_method = "AB9D63477B4D64307AC8C3CAD493B037", hash_generated_method = "E6C1DD8C897E1EE49852D729942B140D")
    private void signalServiceFuncPtrQueue() {
        Message msg = obtainMessage(FUNCPTR_MESSAGE);
        sendMessage(msg);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.953 -0400", hash_original_method = "7F0F2EACA52373092F02E1C8C47DF6D2", hash_generated_method = "6600CFE6221B9A1E6606BE98A91D05C6")
    private void nativeServiceFuncPtrQueue() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.954 -0400", hash_original_method = "DCDD00DDB3DA5C0826A1E2E2E5E3FA67", hash_generated_method = "48D54A14874CA7D909FC22CAA61F5535")
    public void pause() {
        {
            mTimerPaused = true;
            mHasDeferredTimers = false;
        } 
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.954 -0400", hash_original_method = "E4EBA320047EAFB61B42881338F91526", hash_generated_method = "9FDB9D33D08B0603FE149B8613E9F624")
    public void resume() {
        {
            mTimerPaused = false;
            {
                mHasDeferredTimers = false;
                fireSharedTimer();
            } 
        } 
        
        
           
           
               
               
           
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.954 -0400", hash_original_method = "B06B3FDC2D2CDF223C79F9432CF6B221", hash_generated_method = "40CEB3675B2F6C9D2120A50F6D591BB2")
    public void setCacheSize(int bytes) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.954 -0400", hash_original_method = "D5A9FC7DDB356B7F9D175C82B50A2AF1", hash_generated_method = "194DCCEC876E078BA9EF34D2FAB44FCF")
    private void setCookies(String url, String value) {
        {
            boolean var391FA15D3BBE1D225A35988C2D3DE539_90686377 = (value.contains("\r") || value.contains("\n"));
            {
                int size = value.length();
                StringBuilder buffer = new StringBuilder(size);
                int i = 0;
                {
                    int ir = value.indexOf('\r', i);
                    int in = value.indexOf('\n', i);
                    int newi;
                    newi = in;
                    newi = (in == -1 ? ir : (ir < in ? ir
                        : in));
                    {
                        buffer.append(value.subSequence(i, newi));
                    } 
                    {
                        buffer.append(value.subSequence(i, size));
                    } 
                    i = newi + 1;
                } 
                value = buffer.toString();
            } 
        } 
        CookieManager.getInstance().setCookie(url, value);
        addTaint(url.getTaint());
        addTaint(value.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.955 -0400", hash_original_method = "E3D7D6931554145E868760CB2C4A26A3", hash_generated_method = "73A7D96E294302F78C235A29F8D6B722")
    private String cookies(String url) {
        String varB4EAC82CA7396A68D541C85D26508E83_66770509 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_66770509 = CookieManager.getInstance().getCookie(url);
        addTaint(url.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_66770509.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_66770509;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.955 -0400", hash_original_method = "E9376C130584FE2146C1CFB7A84FB471", hash_generated_method = "196D2562F57960D1F8C0600754199B0A")
    private boolean cookiesEnabled() {
        boolean var708720C91D68D319423AD3C37787F455_203994840 = (CookieManager.getInstance().acceptCookie());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1428213862 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1428213862;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.956 -0400", hash_original_method = "9CEFD28F2377E55BFA773DC40D227755", hash_generated_method = "AB0D4488AB7E933EB38A7B69175517D6")
    private String[] getPluginDirectories() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_671190547 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_671190547 = PluginManager.getInstance(null).getPluginDirectories();
        varB4EAC82CA7396A68D541C85D26508E83_671190547.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_671190547;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.956 -0400", hash_original_method = "EA355C7E0B9693F5192FD4CEC8057AD3", hash_generated_method = "E834C7104C0991718AE6E33D1370BCE1")
    private String getPluginSharedDataDirectory() {
        String varB4EAC82CA7396A68D541C85D26508E83_762931075 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_762931075 = PluginManager.getInstance(null).getPluginSharedDataDirectory();
        varB4EAC82CA7396A68D541C85D26508E83_762931075.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_762931075;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.957 -0400", hash_original_method = "8308F15706BD844BBD432043C004CF45", hash_generated_method = "1C59B1697730394F205EC3B5487D86ED")
    private void setSharedTimer(long timemillis) {
        {
            {
                mHasInstantTimer = true;
                Message msg = obtainMessage(TIMER_MESSAGE);
                sendMessageDelayed(msg, timemillis);
            } 
        } 
        {
            Message msg = obtainMessage(TIMER_MESSAGE);
            sendMessageDelayed(msg, timemillis);
        } 
        addTaint(timemillis);
        
        
        
            
                
            
                
                
                
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.957 -0400", hash_original_method = "962436894D889C4038B1520A1ECBED33", hash_generated_method = "A6B11E733B160CC767D95F0317ACE198")
    private void stopSharedTimer() {
        removeMessages(TIMER_MESSAGE);
        mHasInstantTimer = false;
        mHasDeferredTimers = false;
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.957 -0400", hash_original_method = "017AD119A16DE91023E8FE76067DD440", hash_generated_method = "DA18299301475BA2E60EE1305B60482D")
    private String[] getKeyStrengthList() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1100322506 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1100322506 = CertTool.getKeyStrengthList();
        varB4EAC82CA7396A68D541C85D26508E83_1100322506.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1100322506;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.958 -0400", hash_original_method = "A59843A23C4CF1F3FD140F676EC35D8E", hash_generated_method = "BA3F0D432FC0AC53CE0F61B6F11EB6DD")
    synchronized private String getSignedPublicKey(int index, String challenge,
            String url) {
        String varB4EAC82CA7396A68D541C85D26508E83_1165985728 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1611079722 = null; 
        WebView current = sCurrentMainWebView.get();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1165985728 = CertTool.getSignedPublicKey(
                    current.getContext(), index, challenge);
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1611079722 = "";
        } 
        addTaint(index);
        addTaint(challenge.getTaint());
        addTaint(url.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1613288014; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1613288014 = varB4EAC82CA7396A68D541C85D26508E83_1165985728;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1613288014 = varB4EAC82CA7396A68D541C85D26508E83_1611079722;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1613288014.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1613288014;
        
        
        
            
                    
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.959 -0400", hash_original_method = "7BAB6C5DC5E9A5F66D14195839893242", hash_generated_method = "2C9863AA142A10E35AD5D963454B1630")
    private String resolveFilePathForContentUri(String uri) {
        String varB4EAC82CA7396A68D541C85D26508E83_1607132240 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_80456942 = null; 
        {
            String fileName = mContentUriToFilePathMap.get(uri);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1607132240 = fileName;
            } 
        } 
        Uri jUri = Uri.parse(uri);
        varB4EAC82CA7396A68D541C85D26508E83_80456942 = jUri.getLastPathSegment();
        addTaint(uri.getTaint());
        String varA7E53CE21691AB073D9660D615818899_798226919; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_798226919 = varB4EAC82CA7396A68D541C85D26508E83_1607132240;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_798226919 = varB4EAC82CA7396A68D541C85D26508E83_80456942;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_798226919.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_798226919;
        
        
            
            
                
            
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.960 -0400", hash_original_method = "3D9A94F616B3884F20C1C47ABAEE0053", hash_generated_method = "5A30E54EA39E5C7AA05BB3EA892C4C7B")
    public void storeFilePathForContentUri(String path, String contentUri) {
        {
            mContentUriToFilePathMap = new HashMap<String, String>();
        } 
        mContentUriToFilePathMap.put(contentUri, path);
        addTaint(path.getTaint());
        addTaint(contentUri.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.961 -0400", hash_original_method = "48D122DFD280F464E6FED9A0593B265C", hash_generated_method = "C1179E426ADD6AA66AF2231A8610F2B9")
    public void updateProxy(ProxyProperties proxyProperties) {
        {
            nativeUpdateProxy("", "");
        } 
        String host = proxyProperties.getHost();
        int port = proxyProperties.getPort();
        host += ":" + port;
        nativeUpdateProxy(host, proxyProperties.getExclusionList());
        addTaint(proxyProperties.getTaint());
        
        
            
            
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.961 -0400", hash_original_method = "CB9D9CAF93B6F7C6AC078700B30D5B3A", hash_generated_method = "B34C03FE423B4EE0844813601A2B0A67")
    private void nativeConstructor() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.962 -0400", hash_original_method = "46D026C452E34CB5D17D4D7413C83210", hash_generated_method = "76DCFAD42AA6902991CC86FFBD4823C2")
    private void nativeFinalize() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.962 -0400", hash_original_method = "509DDA1BD92D7B897CEF90224EAD9875", hash_generated_method = "AC2815A7BF25B7D98F063D4757A74F41")
    private void sharedTimerFired() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.962 -0400", hash_original_method = "9316866F322C157E5A357156C0328836", hash_generated_method = "0894466BDD76BC6CCF8988BD75C70B60")
    private void nativeUpdatePluginDirectories(String[] directories,
            boolean reload) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.962 -0400", hash_original_method = "DB39049AAE02496ACE7C7C1E193B0ADF", hash_generated_method = "D032B386D2B3E2A3611A9E9397D501D0")
    public void setNetworkOnLine(boolean online) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.963 -0400", hash_original_method = "E4793A664EF98A715ED3BAC198AF4EBD", hash_generated_method = "0BF6A0594BE2D247A95E23B02A51ECCF")
    public void setNetworkType(String type, String subtype) {
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.963 -0400", hash_original_method = "E5A69925BDA73DD9E81D8A1F8F42F257", hash_generated_method = "FC09152D312FECD521F2567721C332CC")
    public void addPackageNames(Set<String> packageNames) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.963 -0400", hash_original_method = "B071A6644C9AA816555B15D21EE52FB4", hash_generated_method = "0C564C4E48A08A51377B9BD8DC556B50")
    public void addPackageName(String packageName) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.963 -0400", hash_original_method = "143D937A228206F27207E7C61286CEC1", hash_generated_method = "1C9E54868B04A06DAF8309867D2F41A3")
    public void removePackageName(String packageName) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.963 -0400", hash_original_method = "562AC1C8CCB348A368D1FD0970777261", hash_generated_method = "CDD15C7E3E55587B192A2AF9CC08B56E")
    public void nativeUpdateProxy(String newProxy, String exclusionList) {
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.963 -0400", hash_original_field = "E605D42EB73FFC3A754B2D2A5777F037", hash_generated_field = "9DF6119D97ECEA39D23976C04D9D93AA")

    private static final int TIMER_MESSAGE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.963 -0400", hash_original_field = "EA6FA30767B7541B3846DAF787248B20", hash_generated_field = "D296A0461F81AE27D7536C23AFDC4097")

    private static final int FUNCPTR_MESSAGE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.963 -0400", hash_original_field = "E7F58239AAFF2B37572DB3BEF0D72545", hash_generated_field = "C340BEA9652E0C495B0427C6F473E96D")

    private static final String LOGTAG = "webkit-timers";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.963 -0400", hash_original_field = "2EA719E7C7067924CD967FC04C8E9BCF", hash_generated_field = "A39D15884D133A48C6F4DB6358E9DE25")

    private static WeakReference<WebView> sCurrentMainWebView = new WeakReference<WebView>(null);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.963 -0400", hash_original_field = "87AA02B49A4F562563740C3EA85FEADB", hash_generated_field = "F5D453B28C787626695D682CFDA8F348")

    static final int REFRESH_PLUGINS = 100;
}

