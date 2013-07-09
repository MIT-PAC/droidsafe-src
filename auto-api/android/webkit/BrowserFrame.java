package android.webkit;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.app.ActivityManager;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.net.ParseException;
import android.net.Uri;
import android.net.WebAddress;
import android.net.http.ErrorStrings;
import android.net.http.SslCertificate;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.util.TypedValue;
import android.view.Surface;
import android.view.ViewRootImpl;
import android.view.WindowManager;
import junit.framework.Assert;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.nio.charset.Charsets;
import java.security.PrivateKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.harmony.security.provider.cert.X509CertImpl;

class BrowserFrame extends Handler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.706 -0400", hash_original_field = "957B64C4FA99E51BCE1B62690725D115", hash_generated_field = "62789CA10670C708EA4D387AB18C5F89")

    private CallbackProxy mCallbackProxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.706 -0400", hash_original_field = "A5E11DE354AE2FBFC3E5565E23F4F865", hash_generated_field = "D4F7B9B886C1ADC785C82D3DD8AF3DFF")

    private WebSettings mSettings;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.706 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.706 -0400", hash_original_field = "8C0B67E1F99496AB4CD09433C231BEB3", hash_generated_field = "7BDDBEC30F299EE26388591EE1BF8D76")

    private WebViewDatabase mDatabase;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.706 -0400", hash_original_field = "9371E2004CE9EC2E60E3F0EBE8ED2E84", hash_generated_field = "73DACDCC92B5BF8822959B0368CF2255")

    private WebViewCore mWebViewCore;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.707 -0400", hash_original_field = "18C5BDE066D80086E4363915A042058B", hash_generated_field = "B4EA0C57C793BB0B49B6968B7FE9D971")

    boolean mLoadInitFromJava;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.707 -0400", hash_original_field = "01D334B431DA26637B5EF7A829298F7D", hash_generated_field = "C86D106D01922BD5804E6AAE242DA6C3")

    private int mLoadType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.707 -0400", hash_original_field = "18D8FCC50BBFDBCB161CD7DD4E3404BE", hash_generated_field = "776616C56C2E01B1F2BB9B8C0B82CB21")

    private boolean mFirstLayoutDone = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.707 -0400", hash_original_field = "C5E19DCA01BDA9FF5D89D2ACFFE2F12C", hash_generated_field = "EC7856A93088DA99A6DF3A617D2EA4C1")

    private boolean mCommitted = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.707 -0400", hash_original_field = "006072914B84F6CA94E2A188B4C8239F", hash_generated_field = "EFE4830A112EE1BAABB9D028ED0F40E4")

    private boolean mBlockMessages = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.707 -0400", hash_original_field = "9CB1303D307C48F5668E893BEC7E4DA2", hash_generated_field = "9A84F3DDA9738602717ED248C7C54BA0")

    private int mOrientation = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.707 -0400", hash_original_field = "017BEB0E2B69AC773E76EDE517E49275", hash_generated_field = "288919EE03CF52ADC4ECF3BE90DB3FD0")

    private boolean mIsMainFrame;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.707 -0400", hash_original_field = "82B4A5C03B9C8E7AECA4C75B7949A817", hash_generated_field = "6BE2AF2AB55A96D7E8AF44D0319FADE3")

    private Map<String, Object> mJavaScriptObjects;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.707 -0400", hash_original_field = "860BB378791B281E4412623871A3DF71", hash_generated_field = "0CD8E441AD75D857B58751166EA1B830")

    private Set<Object> mRemovedJavaScriptObjects;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.707 -0400", hash_original_field = "AE4C5D15C981FA9DC4C7098F4216875A", hash_generated_field = "6F2547FBE326896235C67C4D21E1AAB0")

    private KeyStoreHandler mKeyStoreHandler = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.707 -0400", hash_original_field = "C2C311879F539529159B9BF820E134A3", hash_generated_field = "4A5DF3233C257C28C1B6F01FDD889A88")

    private SearchBoxImpl mSearchBox;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.707 -0400", hash_original_field = "99D531FFAA7E5CBA866FA026F509CD12", hash_generated_field = "74015A65A56B852D13D3A8DC44ECA23B")

    int mNativeFrame;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.708 -0400", hash_original_method = "0C0B9FED7DBC124A25298101B6DEE56A", hash_generated_method = "A8066CBF4CAFE0FBAEA6BB22A2D34422")
    public  BrowserFrame(Context context, WebViewCore w, CallbackProxy proxy,
            WebSettings settings, Map<String, Object> javascriptInterfaces) {
        Context appContext = context.getApplicationContext();
        {
            sJavaBridge = new JWebCoreJavaBridge();
            ActivityManager am = (ActivityManager) context
                    .getSystemService(Context.ACTIVITY_SERVICE);
            {
                boolean varD3D608BC6A05F257DDC787DC0D4348D6_2119403800 = (am.getMemoryClass() > 16);
                {
                    sJavaBridge.setCacheSize(8 * 1024 * 1024);
                } 
                {
                    sJavaBridge.setCacheSize(4 * 1024 * 1024);
                } 
            } 
            CacheManager.init(appContext);
            CookieSyncManager.createInstance(appContext);
            PluginManager.getInstance(appContext);
        } 
        {
            sConfigCallback = new ConfigCallback(
                    (WindowManager) appContext.getSystemService(
                            Context.WINDOW_SERVICE));
            ViewRootImpl.addConfigCallback(sConfigCallback);
        } 
        sConfigCallback.addHandler(this);
        mJavaScriptObjects = javascriptInterfaces;
        {
            mJavaScriptObjects = new HashMap<String, Object>();
        } 
        mRemovedJavaScriptObjects = new HashSet<Object>();
        mSettings = settings;
        mContext = context;
        mCallbackProxy = proxy;
        mDatabase = WebViewDatabase.getInstance(appContext);
        mWebViewCore = w;
        mSearchBox = new SearchBoxImpl(mWebViewCore, mCallbackProxy);
        mJavaScriptObjects.put(SearchBoxImpl.JS_INTERFACE_NAME, mSearchBox);
        AssetManager am = context.getAssets();
        nativeCreateFrame(w, am, proxy.getBackForwardList());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.708 -0400", hash_original_method = "056144D27ACF2932EFB0C1980B0D6F98", hash_generated_method = "A9D871D78753CC3A2B7729F07CC58102")
    public void loadUrl(String url, Map<String, String> extraHeaders) {
        mLoadInitFromJava = true;
        {
            boolean varCEBDFC4375B080C01B891460EBEF74EE_1515311456 = (URLUtil.isJavaScriptUrl(url));
            {
                stringByEvaluatingJavaScriptFromString(
                    url.substring("javascript:".length()));
            } 
            {
                nativeLoadUrl(url, extraHeaders);
            } 
        } 
        mLoadInitFromJava = false;
        addTaint(url.getTaint());
        addTaint(extraHeaders.getTaint());
        
        
        
            
                    
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.708 -0400", hash_original_method = "55F163F814F53ECA11AC218202D49EB2", hash_generated_method = "2BBB3A696BE44C499CB7A1A4A8E2EEFB")
    public void postUrl(String url, byte[] data) {
        mLoadInitFromJava = true;
        nativePostUrl(url, data);
        mLoadInitFromJava = false;
        addTaint(url.getTaint());
        addTaint(data[0]);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.709 -0400", hash_original_method = "210E874B3CC8A8754EDB8A64197F3EDD", hash_generated_method = "AC522AEAE59A6B2A48BA00C58E808606")
    public void loadData(String baseUrl, String data, String mimeType,
            String encoding, String historyUrl) {
        mLoadInitFromJava = true;
        {
            boolean var581113F7BD53DF8B7293B042681B40B2_1453558863 = (historyUrl == null || historyUrl.length() == 0);
            {
                historyUrl = "about:blank";
            } 
        } 
        {
            data = "";
        } 
        {
            boolean varCB616F65F94E18DD8D2DD4567F35B835_714757730 = (baseUrl == null || baseUrl.length() == 0);
            {
                baseUrl = "about:blank";
            } 
        } 
        {
            boolean var9AF9469A93530D5A3F337475212051A4_418122105 = (mimeType == null || mimeType.length() == 0);
            {
                mimeType = "text/html";
            } 
        } 
        nativeLoadData(baseUrl, data, mimeType, encoding, historyUrl);
        mLoadInitFromJava = false;
        addTaint(baseUrl.getTaint());
        addTaint(data.getTaint());
        addTaint(mimeType.getTaint());
        addTaint(encoding.getTaint());
        addTaint(historyUrl.getTaint());
        
        
        
            
        
        
            
        
        
            
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.710 -0400", hash_original_method = "FE36B1316A593126EBA1AA2EF5942205", hash_generated_method = "500B63E05EA6D3A7372595547D280738")
     String saveWebArchive(String basename, boolean autoname) {
        String varB4EAC82CA7396A68D541C85D26508E83_1524298652 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1524298652 = nativeSaveWebArchive(basename, autoname);
        addTaint(basename.getTaint());
        addTaint(autoname);
        varB4EAC82CA7396A68D541C85D26508E83_1524298652.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1524298652;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.711 -0400", hash_original_method = "4DB46F10EA63A90C886405E235BD3A38", hash_generated_method = "E142D1E6CCCEA6137F90879F9CE4BC83")
    public void goBackOrForward(int steps) {
        mLoadInitFromJava = true;
        nativeGoBackOrForward(steps);
        mLoadInitFromJava = false;
        addTaint(steps);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.711 -0400", hash_original_method = "50E452D86A3E55153B3E0F1DD816D615", hash_generated_method = "814DB2D71ED00E2C6C88E3F53C46F537")
    private void reportError(int errorCode, String description, String failingUrl) {
        resetLoadingStates();
        {
            boolean var40AE9761DC6AF2B0949485DECF62ABEE_1174614546 = (description == null || description.isEmpty());
            {
                description = ErrorStrings.getString(errorCode, mContext);
            } 
        } 
        mCallbackProxy.onReceivedError(errorCode, description, failingUrl);
        addTaint(errorCode);
        addTaint(description.getTaint());
        addTaint(failingUrl.getTaint());
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.711 -0400", hash_original_method = "7B4A87199DD3BC0CC52E5F0CAA9F0064", hash_generated_method = "FA4CC3EB22F179EC946E9ABCED374DF7")
    private void resetLoadingStates() {
        mCommitted = true;
        mFirstLayoutDone = true;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.712 -0400", hash_original_method = "82C14ED51175F3BAD05958BE30AA9B50", hash_generated_method = "3A60AE60CD10A1E4A3D67137ECFFD21D")
     boolean committed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1910676416 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1910676416;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.712 -0400", hash_original_method = "6055F5425C1866007AB953B33770A39A", hash_generated_method = "5E6A4C53C4A56DFCFF2BFF5982BF7026")
     boolean firstLayoutDone() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2024260128 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2024260128;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.712 -0400", hash_original_method = "9068063B02257F9D08EFF05D6BD051A9", hash_generated_method = "A996B76773E8127AE0F815F990D672FE")
     int loadType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1391956448 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1391956448;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.712 -0400", hash_original_method = "027FDD69E025CF7A20175D3E84246197", hash_generated_method = "357F4E3DB5D03FD6715BE288D2C81D45")
     void didFirstLayout() {
        {
            mFirstLayoutDone = true;
            mWebViewCore.contentDraw();
        } 
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.713 -0400", hash_original_method = "588CB65AC18071EB5B02ABC642CC0A1A", hash_generated_method = "495977A334CAC32AD68E1E398A2A2DDF")
    private void loadStarted(String url, Bitmap favicon, int loadType,
            boolean isMainFrame) {
        mIsMainFrame = isMainFrame;
        {
            mLoadType = loadType;
            {
                mCallbackProxy.onPageStarted(url, favicon);
                mFirstLayoutDone = false;
                mCommitted = false;
                mWebViewCore.removeMessages(WebViewCore.EventHub.WEBKIT_DRAW);
            } 
        } 
        addTaint(url.getTaint());
        addTaint(favicon.getTaint());
        
        
        
            
            
                
                
                
                
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.713 -0400", hash_original_method = "C9CC31AE97DBC19619CDCFC15EC7B03E", hash_generated_method = "E206FD24ED9A230005D9B4A44AB6AA73")
    @SuppressWarnings("unused")
    private void saveFormData(HashMap<String, String> data) {
        {
            boolean varE277716CFEE75D183A4BE1A1459F291C_1341253286 = (mSettings.getSaveFormData());
            {
                final WebHistoryItem h = mCallbackProxy.getBackForwardList()
                    .getCurrentItem();
                {
                    String url = WebTextView.urlForAutoCompleteData(h.getUrl());
                    {
                        mDatabase.setFormData(url, data);
                    } 
                } 
            } 
        } 
        addTaint(data.getTaint());
        
        
            
                    
            
                
                
                    
                
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.714 -0400", hash_original_method = "F4B9AF2B8B6C0B9D0EBAE01BEE4BF775", hash_generated_method = "895F2BF965F116C9B3197236FCB56B4D")
    @SuppressWarnings("unused")
    private boolean shouldSaveFormData() {
        {
            boolean varE277716CFEE75D183A4BE1A1459F291C_263979273 = (mSettings.getSaveFormData());
            {
                final WebHistoryItem h = mCallbackProxy.getBackForwardList()
                    .getCurrentItem();
                boolean var0A9CE26076094D732B198C6841494F25_1266692388 = (h != null && h.getUrl() != null);
            } 
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_545651983 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_545651983;
        
        
            
                    
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.714 -0400", hash_original_method = "7094DD5A86271DA7E952B216F4C46CCD", hash_generated_method = "BC2E329BA0A76D72F8711B8BDDABBEE8")
    private void transitionToCommitted(int loadType, boolean isMainFrame) {
        {
            mCommitted = true;
            mWebViewCore.getWebView().mViewManager.postResetStateAll();
        } 
        addTaint(loadType);
        addTaint(isMainFrame);
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.715 -0400", hash_original_method = "5C2FD3A5795EB59386117F9A61E0ADCE", hash_generated_method = "0E76D6C1B529652600CC1759CFEFC07B")
    private void loadFinished(String url, int loadType, boolean isMainFrame) {
        {
            {
                resetLoadingStates();
                mCallbackProxy.switchOutDrawHistory();
                mCallbackProxy.onPageFinished(url);
            } 
        } 
        addTaint(url.getTaint());
        addTaint(loadType);
        addTaint(isMainFrame);
        
        
            
                
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.715 -0400", hash_original_method = "D2CB1A360A21716BE59AD0C99E7F7543", hash_generated_method = "E7E6C8BB504C1ABC54529D5BF268DFFE")
     void certificate(SslCertificate certificate) {
        {
            mCallbackProxy.onReceivedCertificate(certificate);
        } 
        addTaint(certificate.getTaint());
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.715 -0400", hash_original_method = "FF0F600C92E1745B1B3B7823F85C9072", hash_generated_method = "3C727BDF61EF3EB2B960E985C9E7AA07")
    public void destroy() {
        nativeDestroyFrame();
        mBlockMessages = true;
        removeCallbacksAndMessages(null);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.716 -0400", hash_original_method = "08B10BC0FD4D849356EF434C4A57C456", hash_generated_method = "C94B6AF869EC7E1A7A4429CC932AC0F9")
    @Override
    public void handleMessage(Message msg) {
        
        {
            {
                boolean var62FF4720D31A7507990A918088ECF943_822111214 = (mSettings.getSavePassword() && hasPasswordField());
                {
                    WebHistoryItem item = mCallbackProxy.getBackForwardList()
                            .getCurrentItem();
                    {
                        WebAddress uri = new WebAddress(item.getUrl());
                        String schemePlusHost = uri.getScheme() + uri.getHost();
                        String[] up = mDatabase.getUsernamePassword(schemePlusHost);
                        {
                            setUsernamePassword(up[0], up[1]);
                        } 
                    } 
                } 
            } 
            {
                boolean var6B43FCDD8E50C7CA617498FD267AAC18_1033918617 = (!JniUtil.useChromiumHttpStack());
                {
                    WebViewWorker.getHandler().sendEmptyMessage(
                            WebViewWorker.MSG_TRIM_CACHE);
                } 
            } 
        } 
        
        
        {
            nativeCallPolicyFunction(msg.arg1, msg.arg2);
        } 
        
        
        {
            {
                mOrientation = msg.arg1;
                nativeOrientationChanged(msg.arg1);
            } 
        } 
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.716 -0400", hash_original_method = "71CD366348BF98805D3BCFC6E13F61B1", hash_generated_method = "55478C4548772023BBC8202A9F2F1945")
    private void setTitle(String title) {
        mCallbackProxy.onReceivedTitle(title);
        addTaint(title.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.717 -0400", hash_original_method = "DC38D0601A6CA8B3CA54AD6CF11C8ED7", hash_generated_method = "CADF6A855CA06C4D65518E1FB1088547")
    public void externalRepresentation(Message callback) {
        callback.obj = externalRepresentation();
        ;
        callback.sendToTarget();
        addTaint(callback.getTaint());
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.717 -0400", hash_original_method = "818D4287AF55B155FD9BEC63FC9BB14D", hash_generated_method = "2CE36722D89C9AAE233D32794227C266")
    private String externalRepresentation() {
    	String s = new String();
    	s.addTaint(taint);
    	return s;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.717 -0400", hash_original_method = "769B7E21D870172A915EE6F0EB6B2D2C", hash_generated_method = "96274C175398F093AFBCB07F994C45F6")
    public void documentAsText(Message callback) {
        StringBuilder text = new StringBuilder();
        {
            text.append(documentAsText());
        } 
        {
            text.append(childFramesAsText());
        } 
        callback.obj = text.toString();
        callback.sendToTarget();
        addTaint(callback.getTaint());
        
        
        
            
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.718 -0400", hash_original_method = "79942AAFA346C254C5198053B4C683D6", hash_generated_method = "07D5EDE5120089FA81790CBAAE4B851E")
    private String documentAsText() {
    	String s = new String();
    	s.addTaint(taint);
    	return s;
    	
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.718 -0400", hash_original_method = "BAA59F57B83FBAF7CC9F5BD462BDF4D7", hash_generated_method = "81DE64B9D9AB653AFA9FD34037C2102D")
    private String childFramesAsText() {
    	String s = new String();
    	s.addTaint(taint);
    	return s;
    	
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.718 -0400", hash_original_method = "7D1B04AB7A647E05019AB7BC865C3803", hash_generated_method = "544EE43BAE35067E80943F50A0452C4C")
    private void windowObjectCleared(int nativeFramePointer) {
        Iterator<String> iter = mJavaScriptObjects.keySet().iterator();
        {
            boolean varADABAFEBBAB7E585DD903333BD7F20A8_1098211313 = (iter.hasNext());
            {
                String interfaceName = iter.next();
                Object object = mJavaScriptObjects.get(interfaceName);
                {
                    nativeAddJavascriptInterface(nativeFramePointer,
                        mJavaScriptObjects.get(interfaceName), interfaceName);
                } 
            } 
        } 
        mRemovedJavaScriptObjects.clear();
        stringByEvaluatingJavaScriptFromString(SearchBoxImpl.JS_BRIDGE);
        addTaint(nativeFramePointer);
        
        
        
            
            
            
                
                        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.719 -0400", hash_original_method = "2FB67C52CD526BE2C970DC0DB75D361F", hash_generated_method = "73EA5E4D81727A65A23540155A4B52BA")
    public boolean handleUrl(String url) {
        {
            boolean var7DE13210A5C773F021EC43207BBDA187_875053254 = (mCallbackProxy.shouldOverrideUrlLoading(url));
            {
                didFirstLayout();
            } 
        } 
        addTaint(url.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1143668304 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1143668304;
        
        
            
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.719 -0400", hash_original_method = "8112D6E9F2629FDD519CF9C502DF963B", hash_generated_method = "E178970CCDAC65F2BC4BE3EE6E494718")
    public void addJavascriptInterface(Object obj, String interfaceName) {
        removeJavascriptInterface(interfaceName);
        mJavaScriptObjects.put(interfaceName, obj);
        addTaint(obj.getTaint());
        addTaint(interfaceName.getTaint());
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.719 -0400", hash_original_method = "D4D979316C36EF31BC47A23AC0C9BE50", hash_generated_method = "3CFB3CEE8DFDF437316B59814A1F907D")
    public void removeJavascriptInterface(String interfaceName) {
        {
            boolean varBA61D59CAAA24DBF67D72A8EF3264200_2002267228 = (mJavaScriptObjects.containsKey(interfaceName));
            {
                mRemovedJavaScriptObjects.add(mJavaScriptObjects.remove(interfaceName));
            } 
        } 
        addTaint(interfaceName.getTaint());
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.720 -0400", hash_original_method = "DF8E19ADC1C4D892E5E9E24D72F873C3", hash_generated_method = "7B9DA7C003907885EBA0ABB404B50D2C")
    private int getFileSize(String uri) {
        int size = 0;
        try 
        {
            InputStream stream = mContext.getContentResolver()
                            .openInputStream(Uri.parse(uri));
            size = stream.available();
            stream.close();
        } 
        catch (Exception e)
        { }
        addTaint(uri.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1602656467 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1602656467;
        
        
        
            
                            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.721 -0400", hash_original_method = "D65A9387A3FB37FCB544A79FFB5606B6", hash_generated_method = "A7274771AC7B3122BD874FFDBE80C0E6")
    private int getFile(String uri, byte[] buffer, int offset,
            int expectedSize) {
        int size = 0;
        try 
        {
            InputStream stream = mContext.getContentResolver()
                            .openInputStream(Uri.parse(uri));
            size = stream.available();
            {
                stream.read(buffer, offset, size);
            } 
            {
                size = 0;
            } 
            stream.close();
        } 
        catch (java.io.FileNotFoundException e)
        {
            size = 0;
        } 
        catch (java.io.IOException e2)
        {
            size = 0;
        } 
        addTaint(uri.getTaint());
        addTaint(buffer[0]);
        addTaint(offset);
        addTaint(expectedSize);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_412011100 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_412011100;
        
        
        
            
                            
            
            
                    
                
            
                
            
            
        
            
            
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.724 -0400", hash_original_method = "60CA323AEDF7C276FF8B65BEFBD4FA69", hash_generated_method = "E1BE12476E1D51F8FA9C927F677AA65B")
    private InputStream inputStreamForAndroidResource(String url) {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1528800657 = null; 
        InputStream varB4EAC82CA7396A68D541C85D26508E83_315415418 = null; 
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1157188784 = null; 
        InputStream varB4EAC82CA7396A68D541C85D26508E83_968147465 = null; 
        InputStream varB4EAC82CA7396A68D541C85D26508E83_975401420 = null; 
        InputStream varB4EAC82CA7396A68D541C85D26508E83_565323356 = null; 
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1675783857 = null; 
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1622136459 = null; 
        InputStream varB4EAC82CA7396A68D541C85D26508E83_91845693 = null; 
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1319988136 = null; 
        final String ANDROID_ASSET = "file:///android_asset/";
        final String ANDROID_RESOURCE = "file:///android_res/";
        final String ANDROID_CONTENT = "content:";
        {
            boolean varFDE4819B7BD4D15D01E52BC5B52139CC_1236143726 = (url.startsWith(ANDROID_RESOURCE));
            {
                url = url.replaceFirst(ANDROID_RESOURCE, "");
                {
                    boolean var6AB4ECE4FADE49B1DE66FC23626AC729_2131209805 = (url == null || url.length() == 0);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1528800657 = null;
                    } 
                } 
                int slash = url.indexOf('/');
                int dot = url.indexOf('.', slash);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_315415418 = null;
                } 
                String subClassName = url.substring(0, slash);
                String fieldName = url.substring(slash + 1, dot);
                String errorMsg = null;
                try 
                {
                    final Class<?> d = mContext.getApplicationContext()
                        .getClassLoader().loadClass(
                                mContext.getPackageName() + ".R$"
                                        + subClassName);
                    final java.lang.reflect.Field field = d.getField(fieldName);
                    final int id = field.getInt(null);
                    TypedValue value = new TypedValue();
                    mContext.getResources().getValue(id, value, true);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1157188784 = mContext.getAssets().openNonAsset(
                            value.assetCookie, value.string.toString(),
                            AssetManager.ACCESS_STREAMING);
                    } 
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_968147465 = null;
                    } 
                } 
                catch (Exception e)
                {
                    varB4EAC82CA7396A68D541C85D26508E83_975401420 = null;
                } 
            } 
            {
                boolean varA326CC4BBEB8E48966FD18C590AD09E0_212167525 = (url.startsWith(ANDROID_ASSET));
                {
                    url = url.replaceFirst(ANDROID_ASSET, "");
                    try 
                    {
                        AssetManager assets = mContext.getAssets();
                        varB4EAC82CA7396A68D541C85D26508E83_565323356 = assets.open(url, AssetManager.ACCESS_STREAMING);
                    } 
                    catch (IOException e)
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1675783857 = null;
                    } 
                } 
                {
                    boolean var9D1D2B0882467AD6080B338924D7EEBD_2040151598 = (mSettings.getAllowContentAccess() &&
                   url.startsWith(ANDROID_CONTENT));
                    {
                        try 
                        {
                            int mimeIndex = url.lastIndexOf('?');
                            {
                                url = url.substring(0, mimeIndex);
                            } 
                            Uri uri = Uri.parse(url);
                            varB4EAC82CA7396A68D541C85D26508E83_1622136459 = mContext.getContentResolver().openInputStream(uri);
                        } 
                        catch (Exception e)
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_91845693 = null;
                        } 
                    } 
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1319988136 = null;
                    } 
                } 
            } 
        } 
        addTaint(url.getTaint());
        InputStream varA7E53CE21691AB073D9660D615818899_1509476823; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1509476823 = varB4EAC82CA7396A68D541C85D26508E83_1528800657;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1509476823 = varB4EAC82CA7396A68D541C85D26508E83_315415418;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1509476823 = varB4EAC82CA7396A68D541C85D26508E83_1157188784;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_1509476823 = varB4EAC82CA7396A68D541C85D26508E83_968147465;
                break;
            case 5: 
                varA7E53CE21691AB073D9660D615818899_1509476823 = varB4EAC82CA7396A68D541C85D26508E83_975401420;
                break;
            case 6: 
                varA7E53CE21691AB073D9660D615818899_1509476823 = varB4EAC82CA7396A68D541C85D26508E83_565323356;
                break;
            case 7: 
                varA7E53CE21691AB073D9660D615818899_1509476823 = varB4EAC82CA7396A68D541C85D26508E83_1675783857;
                break;
            case 8: 
                varA7E53CE21691AB073D9660D615818899_1509476823 = varB4EAC82CA7396A68D541C85D26508E83_1622136459;
                break;
            case 9: 
                varA7E53CE21691AB073D9660D615818899_1509476823 = varB4EAC82CA7396A68D541C85D26508E83_91845693;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1509476823 = varB4EAC82CA7396A68D541C85D26508E83_1319988136;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1509476823.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1509476823;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.725 -0400", hash_original_method = "DEA49E30923C6B4E17F9FB446E1784D4", hash_generated_method = "BEADD5B864A0362F10A234304C7AE19A")
    private LoadListener startLoadingResource(int loaderHandle,
                                              String url,
                                              String method,
                                              HashMap headers,
                                              byte[] postData,
                                              long postDataIdentifier,
                                              int cacheMode,
                                              boolean mainResource,
                                              boolean userGesture,
                                              boolean synchronous,
                                              String username,
                                              String password) {
        LoadListener varB4EAC82CA7396A68D541C85D26508E83_800784004 = null; 
        LoadListener varB4EAC82CA7396A68D541C85D26508E83_112018095 = null; 
        {
            boolean var6F8758D2F464DBB6403377B21E3BD81A_310927396 = (mSettings.getCacheMode() != WebSettings.LOAD_DEFAULT);
            {
                cacheMode = mSettings.getCacheMode();
            } 
        } 
        {
            boolean varE136B9F2BD76354D2C6E072F73228787_410816682 = (method.equals("POST"));
            {
                {
                    cacheMode = WebSettings.LOAD_NO_CACHE;
                } 
                String[] ret = getUsernamePassword();
                {
                    String domUsername = ret[0];
                    String domPassword = ret[1];
                    maybeSavePassword(postData, domUsername, domPassword);
                } 
            } 
        } 
        boolean isMainFramePage = mIsMainFrame;
        LoadListener loadListener = LoadListener.getLoadListener(mContext,
                this, url, loaderHandle, synchronous, isMainFramePage,
                mainResource, userGesture, postDataIdentifier, username, password);
        {
            boolean var94019098962C39DF55C40C7C4C678CCF_121844758 = (LoadListener.getNativeLoaderCount() > MAX_OUTSTANDING_REQUESTS);
            {
                loadListener.error(
                    android.net.http.EventHandler.ERROR, mContext.getString(
                            com.android.internal.R.string.httpErrorTooManyRequests));
                varB4EAC82CA7396A68D541C85D26508E83_800784004 = loadListener;
            } 
        } 
        FrameLoader loader = new FrameLoader(loadListener, mSettings, method,
                mCallbackProxy.shouldInterceptRequest(url));
        loader.setHeaders(headers);
        loader.setPostData(postData);
        loader.setCacheMode(headers.containsKey("If-Modified-Since")
                || headers.containsKey("If-None-Match") ? 
                        WebSettings.LOAD_NO_CACHE : cacheMode);
        varB4EAC82CA7396A68D541C85D26508E83_112018095 = !synchronous ? loadListener : null;
        addTaint(loaderHandle);
        addTaint(url.getTaint());
        addTaint(method.getTaint());
        addTaint(headers.getTaint());
        addTaint(postData[0]);
        addTaint(postDataIdentifier);
        addTaint(cacheMode);
        addTaint(mainResource);
        addTaint(userGesture);
        addTaint(synchronous);
        addTaint(username.getTaint());
        addTaint(password.getTaint());
        LoadListener varA7E53CE21691AB073D9660D615818899_51345312; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_51345312 = varB4EAC82CA7396A68D541C85D26508E83_800784004;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_51345312 = varB4EAC82CA7396A68D541C85D26508E83_112018095;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_51345312.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_51345312;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.726 -0400", hash_original_method = "69B43B2B2D64063203E22417AF1B4FBE", hash_generated_method = "DFC8D2E080BD6C7D05B82EB66377EDC4")
    private void maybeSavePassword(
            byte[] postData, String username, String password) {
        {
            boolean var911F0604D5A8278A2892D81EDC89EA56_50217013 = (postData == null
                || username == null || username.isEmpty()
                || password == null || password.isEmpty());
        } 
        {
            boolean varF748BCF92145CEE9E6F4341D9614C6CE_1364341358 = (!mSettings.getSavePassword());
        } 
        try 
        {
            {
                Assert.assertNotNull(mCallbackProxy.getBackForwardList()
                        .getCurrentItem());
            } 
            WebAddress uri = new WebAddress(mCallbackProxy
                    .getBackForwardList().getCurrentItem().getUrl());
            String schemePlusHost = uri.getScheme() + uri.getHost();
            String postString = new String(postData);
            {
                boolean var3202C69FDDB5D23F4FF83477294755BA_130169142 = (postString.contains(URLEncoder.encode(username)) &&
                    postString.contains(URLEncoder.encode(password)));
                {
                    String[] saved = mDatabase.getUsernamePassword(
                        schemePlusHost);
                    {
                        {
                            mDatabase.setUsernamePassword(
                                schemePlusHost, username, password);
                        } 
                    } 
                    {
                        mCallbackProxy.onSavePassword(schemePlusHost, username,
                            password, null);
                    } 
                } 
            } 
        } 
        catch (ParseException ex)
        { }
        addTaint(postData[0]);
        addTaint(username.getTaint());
        addTaint(password.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.727 -0400", hash_original_method = "DD9E58924AE2FD70E5FF51B9D61BCBED", hash_generated_method = "8E99E27E333F7503A8062EBC2262CE3E")
    private WebResourceResponse shouldInterceptRequest(String url) {
        WebResourceResponse varB4EAC82CA7396A68D541C85D26508E83_1445929904 = null; 
        WebResourceResponse varB4EAC82CA7396A68D541C85D26508E83_1991826218 = null; 
        InputStream androidResource = inputStreamForAndroidResource(url);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1445929904 = new WebResourceResponse(null, null, androidResource);
        } 
        WebResourceResponse response = mCallbackProxy.shouldInterceptRequest(url);
        {
            boolean var847EBE44E86F4F89B92A16B7F267147C_1216999879 = (response == null && "browser:incognito".equals(url));
            {
                try 
                {
                    Resources res = mContext.getResources();
                    InputStream ins = res.openRawResource(
                        com.android.internal.R.raw.incognito_mode_start_page);
                    response = new WebResourceResponse("text/html", "utf8", ins);
                } 
                catch (NotFoundException ex)
                { }
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1991826218 = response;
        addTaint(url.getTaint());
        WebResourceResponse varA7E53CE21691AB073D9660D615818899_1976086314; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1976086314 = varB4EAC82CA7396A68D541C85D26508E83_1445929904;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1976086314 = varB4EAC82CA7396A68D541C85D26508E83_1991826218;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1976086314.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1976086314;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.727 -0400", hash_original_method = "07700DAB8245AC940D55DCEF1A17B102", hash_generated_method = "6CDB99422DD7CC63E11F32C6B65590AD")
    private void setProgress(int newProgress) {
        mCallbackProxy.onProgressChanged(newProgress);
        {
            sendMessageDelayed(obtainMessage(FRAME_COMPLETED), 100);
        } 
        {
            mCallbackProxy.switchOutDrawHistory();
        } 
        addTaint(newProgress);
        
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.728 -0400", hash_original_method = "910C3A78FCE0B1E574FD9CA74D1EE7A9", hash_generated_method = "8931057A11A6DB801BBACC504BC0B535")
    private void didReceiveIcon(Bitmap icon) {
        mCallbackProxy.onReceivedIcon(icon);
        addTaint(icon.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.728 -0400", hash_original_method = "F9E26289979EC36BEDC07872BFD387F0", hash_generated_method = "0C547F9A3B3FA472E5EEEA66A8C009A2")
    private void didReceiveTouchIconUrl(String url, boolean precomposed) {
        mCallbackProxy.onReceivedTouchIconUrl(url, precomposed);
        addTaint(url.getTaint());
        addTaint(precomposed);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.729 -0400", hash_original_method = "49DBB49355B8BD4E95F5FBA6E171926E", hash_generated_method = "6999FA12A2E170A75757753D32C651CB")
    private BrowserFrame createWindow(boolean dialog, boolean userGesture) {
        BrowserFrame varB4EAC82CA7396A68D541C85D26508E83_584813136 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_584813136 = mCallbackProxy.createWindow(dialog, userGesture);
        addTaint(dialog);
        addTaint(userGesture);
        varB4EAC82CA7396A68D541C85D26508E83_584813136.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_584813136;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.729 -0400", hash_original_method = "05E62B842D0E318583ACCB4619923A88", hash_generated_method = "75CF187AC2BCD2C92D428CFCB1D19AF9")
    private void requestFocus() {
        mCallbackProxy.onRequestFocus();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.729 -0400", hash_original_method = "A6BF5F00A4A45564AACA34EE9DAEC5CF", hash_generated_method = "E71E93E66A811963999EE2C83B4D6747")
    private void closeWindow(WebViewCore w) {
        mCallbackProxy.onCloseWindow(w.getWebView());
        addTaint(w.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.730 -0400", hash_original_method = "53828DFE68036F8E35ADAC562AA427C9", hash_generated_method = "6F859EE15677210125FB674A8DDAE17E")
    private void decidePolicyForFormResubmission(int policyFunction) {
        Message dontResend = obtainMessage(POLICY_FUNCTION, policyFunction,
                POLICY_IGNORE);
        Message resend = obtainMessage(POLICY_FUNCTION, policyFunction,
                POLICY_USE);
        mCallbackProxy.onFormResubmission(dontResend, resend);
        addTaint(policyFunction);
        
        
                
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.730 -0400", hash_original_method = "B19BAB1EEF674556A3A9CC47CD14FB0B", hash_generated_method = "12C358F1B02FB6A5EBCB026210775A8E")
    private void updateVisitedHistory(String url, boolean isReload) {
        mCallbackProxy.doUpdateVisitedHistory(url, isReload);
        addTaint(url.getTaint());
        addTaint(isReload);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.731 -0400", hash_original_method = "D3ED977A3BCAC48329E24D7D69689852", hash_generated_method = "12455877143015B7FAD8662FCD9EA9FE")
     CallbackProxy getCallbackProxy() {
        CallbackProxy varB4EAC82CA7396A68D541C85D26508E83_707526993 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_707526993 = mCallbackProxy;
        varB4EAC82CA7396A68D541C85D26508E83_707526993.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_707526993;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.732 -0400", hash_original_method = "F09A8DE53C03EAD5D6B2D7442C92246E", hash_generated_method = "6236BFF31CEE914D5418C25F7EE37D9D")
     String getUserAgentString() {
        String varB4EAC82CA7396A68D541C85D26508E83_958524413 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_958524413 = mSettings.getUserAgentString();
        varB4EAC82CA7396A68D541C85D26508E83_958524413.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_958524413;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.733 -0400", hash_original_method = "D14466E1FBBBA5A0DDC9A63472126D93", hash_generated_method = "03CD7C5D828F3DC8B2568B6B98ECE0EF")
    private String getRawResFilename(int id) {
        String varB4EAC82CA7396A68D541C85D26508E83_340682141 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_340682141 = getRawResFilename(id, mContext);
        addTaint(id);
        varB4EAC82CA7396A68D541C85D26508E83_340682141.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_340682141;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    static String getRawResFilename(int id, Context context) {
        int resid;
        switch (id) {
            case NODOMAIN:
                resid = com.android.internal.R.raw.nodomain;
                break;
            case LOADERROR:
                resid = com.android.internal.R.raw.loaderror;
                break;
            case DRAWABLEDIR:
                resid = com.android.internal.R.drawable.btn_check_off;
                break;
            case FILE_UPLOAD_LABEL:
                return context.getResources().getString(
                        com.android.internal.R.string.upload_file);
            case RESET_LABEL:
                return context.getResources().getString(
                        com.android.internal.R.string.reset);
            case SUBMIT_LABEL:
                return context.getResources().getString(
                        com.android.internal.R.string.submit);
            case FILE_UPLOAD_NO_FILE_CHOSEN:
                return context.getResources().getString(
                        com.android.internal.R.string.no_file_chosen);
            default:
                Log.e(LOGTAG, "getRawResFilename got incompatible resource ID");
                return "";
        }
        TypedValue value = new TypedValue();
        context.getResources().getValue(resid, value, true);
        if (id == DRAWABLEDIR) {
            String path = value.string.toString();
            int index = path.lastIndexOf('/');
            if (index < 0) {
                Log.e(LOGTAG, "Can't find drawable directory.");
                return "";
            }
            return path.substring(0, index + 1);
        }
        return value.string.toString();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.734 -0400", hash_original_method = "E4DD03CAE364FD517B782C57726FD370", hash_generated_method = "93991C3BEA65181322E5CB8CB7E9A891")
    private float density() {
        float var828FED69EC6DBC28F444BC99FA02F5DC_500122634 = (mContext.getResources().getDisplayMetrics().density);
        float var546ADE640B6EDFBC8A086EF31347E768_80841292 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_80841292;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.734 -0400", hash_original_method = "468A4DE23411D07F152B7955301757EE", hash_generated_method = "707CC33037ED07474BBB429DCFACA597")
    private void didReceiveAuthenticationChallenge(
            final int handle, String host, String realm, final boolean useCachedCredentials,
            final boolean suppressDialog) {
        HttpAuthHandler handler = new HttpAuthHandler() {
            @Override
            public boolean useHttpAuthUsernamePassword() {
                return useCachedCredentials;
            }
            @Override
            public void proceed(String username, String password) {
                nativeAuthenticationProceed(handle, username, password);
            }
            @Override
            public void cancel() {
                nativeAuthenticationCancel(handle);
            }
            @Override
            public boolean suppressDialog() {
                return suppressDialog;
            }
        };
        mCallbackProxy.onReceivedHttpAuthRequest(handler, host, realm);
        addTaint(handle);
        addTaint(host.getTaint());
        addTaint(realm.getTaint());
        addTaint(useCachedCredentials);
        addTaint(suppressDialog);
        
        
            
            
                
            
            
            
                
            
            
            
                
            
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.735 -0400", hash_original_method = "BF59E951CBFF79EB5A7A07D0C7840C24", hash_generated_method = "E28CEE2E5CC467902FEEF7816EBAF807")
    private void reportSslCertError(final int handle, final int certError, byte certDER[],
            String url) {
        final SslError sslError;
        try 
        {
            X509Certificate cert = new X509CertImpl(certDER);
            SslCertificate sslCert = new SslCertificate(cert);
            sslError = SslError.SslErrorFromChromiumErrorCode(certError, sslCert, url);
        } 
        catch (IOException e)
        {
            nativeSslCertErrorCancel(handle, certError);
            return;
        } 
        {
            boolean var9E891972169349B7CCF07279CD1AABBF_846744547 = (SslCertLookupTable.getInstance().isAllowed(sslError));
            {
                nativeSslCertErrorProceed(handle);
                mCallbackProxy.onProceededAfterSslError(sslError);
            } 
        } 
        SslErrorHandler handler = new SslErrorHandler() {
            @Override
            public void proceed() {
                SslCertLookupTable.getInstance().setIsAllowed(sslError);
                nativeSslCertErrorProceed(handle);
            }
            @Override
            public void cancel() {
                nativeSslCertErrorCancel(handle, certError);
            }
        };
        mCallbackProxy.onReceivedSslError(handler, sslError);
        addTaint(handle);
        addTaint(certError);
        addTaint(certDER[0]);
        addTaint(url.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.735 -0400", hash_original_method = "DFA7C324E28D10E855E86AE4BB5B7562", hash_generated_method = "20D0E1FF1F85BD3C0E2AC94363384EB6")
    private void requestClientCert(int handle, String hostAndPort) {
        SslClientCertLookupTable table = SslClientCertLookupTable.getInstance();
        {
            boolean var3396FDE3F71A1312687665F19E9550DF_971513545 = (table.IsAllowed(hostAndPort));
            {
                nativeSslClientCert(handle,
                                table.PrivateKey(hostAndPort),
                                table.CertificateChain(hostAndPort));
            } 
            {
                boolean var50D6A23560AA663AF990FF8C2B0C3B75_1239393996 = (table.IsDenied(hostAndPort));
                {
                    nativeSslClientCert(handle, null, null);
                } 
                {
                    mCallbackProxy.onReceivedClientCertRequest(
                    new ClientCertRequestHandler(this, handle, hostAndPort, table), hostAndPort);
                } 
            } 
        } 
        addTaint(handle);
        addTaint(hostAndPort.getTaint());
        
        
        
            
                                
                                
        
            
        
            
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.736 -0400", hash_original_method = "322B645C7F09570DF98848B1C3D767D8", hash_generated_method = "A786FA6639CE48F8AF2C41557C868216")
    private void downloadStart(String url, String userAgent,
            String contentDisposition, String mimeType, long contentLength) {
        {
            boolean var44872427025E393BE432C3478708F3FD_41615593 = (mimeType.isEmpty());
            {
                try 
                {
                    String extension = url.substring(url.lastIndexOf('.') + 1);
                    mimeType = libcore.net.MimeUtils.guessMimeTypeFromExtension(extension);
                    mimeType = "";
                } 
                catch (IndexOutOfBoundsException exception)
                { }
            } 
        } 
        mimeType = MimeTypeMap.getSingleton().remapGenericMimeType(
                mimeType, url, contentDisposition);
        {
            boolean var4B3BED1078E8417BFF574BC05F74B45C_66136523 = (CertTool.getCertType(mimeType) != null);
            {
                mKeyStoreHandler = new KeyStoreHandler(mimeType);
            } 
            {
                mCallbackProxy.onDownloadStart(url, userAgent,
                contentDisposition, mimeType, contentLength);
            } 
        } 
        addTaint(url.getTaint());
        addTaint(userAgent.getTaint());
        addTaint(contentDisposition.getTaint());
        addTaint(contentLength);
        
        
            
                
                
                
                    
            
            
        
        
                
        
            
        
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.736 -0400", hash_original_method = "BAE8CD84EA4D59BD4BB7CAF15EB1C07F", hash_generated_method = "D5625DF4D60A3564448CA5E674D53A5F")
    private void didReceiveData(byte data[], int size) {
        mKeyStoreHandler.didReceiveData(data, size);
        addTaint(data[0]);
        addTaint(size);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.736 -0400", hash_original_method = "5EC89579D3745ABD19569589FBBBCA81", hash_generated_method = "B454CCBDA172FF40AB0FF66C63354298")
    private void didFinishLoading() {
        {
            mKeyStoreHandler.installCert(mContext);
            mKeyStoreHandler = null;
        } 
        
        
          
          
      
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.737 -0400", hash_original_method = "A2E04BD398BDF0F096F042D99402CC27", hash_generated_method = "E93478DD44E8640468FA7EA1251A4BA1")
    private void setCertificate(byte cert_der[]) {
        try 
        {
            X509Certificate cert = new X509CertImpl(cert_der);
            mCallbackProxy.onReceivedCertificate(new SslCertificate(cert));
        } 
        catch (IOException e)
        { }
        addTaint(cert_der[0]);
        
        
            
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.737 -0400", hash_original_method = "780A48AF1DFDDD134926E1881FBB7981", hash_generated_method = "B755F354B8DDB5D5154C7AAB514DE3DA")
     SearchBox getSearchBox() {
        SearchBox varB4EAC82CA7396A68D541C85D26508E83_2010832686 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2010832686 = mSearchBox;
        varB4EAC82CA7396A68D541C85D26508E83_2010832686.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2010832686;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.738 -0400", hash_original_method = "957E1FEE267AF2EB4B4A609321166001", hash_generated_method = "C6F9E370D1FAA1C6CA521D0AEC1F5DEC")
    private void autoLogin(String realm, String account, String args) {
        mCallbackProxy.onReceivedLoginRequest(realm, account, args);
        addTaint(realm.getTaint());
        addTaint(account.getTaint());
        addTaint(args.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.738 -0400", hash_original_method = "CAC5AC041AD65DE746A86B06B460473E", hash_generated_method = "8EFAC8AB4511B7E165DA50794474A8A3")
    private void nativeCreateFrame(WebViewCore w, AssetManager am,
            WebBackForwardList list) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.738 -0400", hash_original_method = "74AC0793AA670585A51BA4B2FC045561", hash_generated_method = "D0819FF5A9F51FEE8FA89D4F258032D7")
    public void nativeDestroyFrame() {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.738 -0400", hash_original_method = "7D705910310ED484283730AFB821A717", hash_generated_method = "77CB7497C6503548A49DEF56D571505E")
    private void nativeCallPolicyFunction(int policyFunction,
            int decision) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.738 -0400", hash_original_method = "AE07D7138DB6945AA08789E90E80B92B", hash_generated_method = "030179C599C6C6C95E46270EA13653EF")
    public void reload(boolean allowStale) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.739 -0400", hash_original_method = "53A1F9C2A72688D9CD2F75BB7D3D5005", hash_generated_method = "CECBA3DCC4E2FD2E5ECF03EAC541C67B")
    private void nativeGoBackOrForward(int steps) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.739 -0400", hash_original_method = "F143225F39CB01C1D802EC565271C419", hash_generated_method = "29BBC25C86CDC16E4793C63D3F6022F4")
    @DSModeled(DSC.SAFE)
    public String stringByEvaluatingJavaScriptFromString(String script) {
    	String s = new String();
    	s.addTaint(taint);
    	return s;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.739 -0400", hash_original_method = "1BC95C43CEE0FFE1F6217DA26B59C5B9", hash_generated_method = "56AF48B8BD61F2A35430BDF6E249DFBB")
    private void nativeAddJavascriptInterface(int nativeFramePointer,
            Object obj, String interfaceName) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.739 -0400", hash_original_method = "B177754AEEE092C53184C415EE8118E6", hash_generated_method = "47094B89B018B5DFA4A910C06D3DA460")
    private void setCacheDisabled(boolean disabled) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.740 -0400", hash_original_method = "8B7AAFA05BB3F3ED8C594AA78F708D08", hash_generated_method = "804F69B93FC97715E0E64B052B8B3C68")
    public boolean cacheDisabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2019226374 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2019226374;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.740 -0400", hash_original_method = "055468486DD4D3FA9B64A316B50FA6FA", hash_generated_method = "09DFDA49097E0044F1CB77E2DA83386B")
    public void clearCache() {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.740 -0400", hash_original_method = "6C44E95231996B5164D16D96A5AF9CAD", hash_generated_method = "F293DD4C3989DC497C60C424BC165890")
    private void nativeLoadUrl(String url, Map<String, String> headers) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.741 -0400", hash_original_method = "4DAAE38A658B1BBD069DC4A366A0C462", hash_generated_method = "7AFC02E483AE7F6035BE6C4076387ECA")
    private void nativePostUrl(String url, byte[] postData) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.741 -0400", hash_original_method = "8945167C96AD091C5C39DEC108C4839D", hash_generated_method = "84C5E27EED63249939FC5099014E7452")
    private void nativeLoadData(String baseUrl, String data,
            String mimeType, String encoding, String historyUrl) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.741 -0400", hash_original_method = "A939F96E349A2DAAC3BA975E2507007D", hash_generated_method = "A20ED99BC6ADB1A37D77ED3EC6142CBA")
    public void stopLoading() {
        {
            resetLoadingStates();
        } 
        nativeStopLoading();
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.742 -0400", hash_original_method = "64AB65E4A9095F9BBCDCF9CF6CF9A5F6", hash_generated_method = "863930E14611E1ACA6714E4256C8BCDF")
    private void nativeStopLoading() {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.742 -0400", hash_original_method = "9D75E2E2AB8D83EF2AA67EF8FE72195D", hash_generated_method = "BB907995389D13C41910914B6848981B")
    public boolean documentHasImages() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1662592265 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1662592265;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.742 -0400", hash_original_method = "10318A015094FE1A39B49B3070F280C0", hash_generated_method = "7728379041B9C22E0AA30282A341F34C")
    private boolean hasPasswordField() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_625909019 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_625909019;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.743 -0400", hash_original_method = "865B533AFC1748A162575C4402C4E1D7", hash_generated_method = "649B5EB499FF582D6D8E126787969B7F")
    private String[] getUsernamePassword() {
    	
    	String[] s = new String[1];
    	s.addTaint(taint);
    	return s;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.743 -0400", hash_original_method = "2745608D69207B6EE74824552EF70660", hash_generated_method = "1A30370C37C5C66F114998E665F5DE65")
    private void setUsernamePassword(String username, String password) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.743 -0400", hash_original_method = "74581984BB5BC192860C6547F8D5036F", hash_generated_method = "1313694DA1B47EE7DE9BC757D7889251")
    private String nativeSaveWebArchive(String basename, boolean autoname) {
    	addTaint(autoname);
    	addTaint(basename.taint);
    	String s = new String();
    	s.addTaint(taint);
    	return s;
    }


	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.743 -0400", hash_original_method = "08E54613B59D770C860286634891B8BB", hash_generated_method = "850BDCB5411EE09BBA08F1498E765617")
    private void nativeOrientationChanged(int orientation) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.744 -0400", hash_original_method = "68B2D8AE5CF2C1C845D97B94EDB581CC", hash_generated_method = "9AFA00EEEC77D42FCE75299FE8ECAEF0")
    private void nativeAuthenticationProceed(int handle, String username, String password) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.744 -0400", hash_original_method = "9DEA51422898C7E38A3DECD149992B9B", hash_generated_method = "24B56D25B8D4C69BCC49A3029D0425ED")
    private void nativeAuthenticationCancel(int handle) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.744 -0400", hash_original_method = "DFE86F393FFB1B33336576462A995D77", hash_generated_method = "1D2385A72CC74EB320478672DDD4F738")
    private void nativeSslCertErrorProceed(int handle) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.744 -0400", hash_original_method = "8A69525C805CE3B5326B3888FD841CA0", hash_generated_method = "0210D16961B93CFA3B6CC1A9AA6C2FFF")
    private void nativeSslCertErrorCancel(int handle, int certError) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.744 -0400", hash_original_method = "81F222D4FD7D3F4B597DBD7F9BD0D106", hash_generated_method = "9F314486FB3D8DB453A1ECAAFCC05CF8")
     void nativeSslClientCert(int handle,
                                    byte[] pkcs8EncodedPrivateKey,
                                    byte[][] asn1DerEncodedCertificateChain) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.745 -0400", hash_original_method = "154F1DF98163CFE18EB2585F133E4CD5", hash_generated_method = "774B7A2200A9DB46D8DD4D488099F700")
     boolean getShouldStartScrolledRight() {
        boolean var335C30460623592B55D35997E929AE78_610592606 = (nativeGetShouldStartScrolledRight(mNativeFrame));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_318858133 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_318858133;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.745 -0400", hash_original_method = "F95D370518D151DA0A0757957627AE19", hash_generated_method = "7D652C6C8A0A1F4EBB722AA212160171")
    private boolean nativeGetShouldStartScrolledRight(int nativeBrowserFrame) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_428524675 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_428524675;
    }

    
    private static class ConfigCallback implements ComponentCallbacks {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.745 -0400", hash_original_field = "3F69F22C406833C0C756A90F1331AB00", hash_generated_field = "939312DE689389EC63468038A0B3966B")

        private final ArrayList<WeakReference<Handler>> mHandlers = new ArrayList<WeakReference<Handler>>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.745 -0400", hash_original_field = "306519E50E3A91B9733D09F5D8EB985C", hash_generated_field = "3C750A4AE06B71AF3A05B7797C7182A4")

        private WindowManager mWindowManager;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.745 -0400", hash_original_method = "049F58B9ED595813037671BB1DAC0333", hash_generated_method = "0990D6314CA4E2ACF77F7549B870C8E3")
          ConfigCallback(WindowManager wm) {
            mWindowManager = wm;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.746 -0400", hash_original_method = "3638F495C0637CBBD96B9D8F0DA8CFC2", hash_generated_method = "7474AF23E4F5F92EBF42E1D9D80D6FAE")
        public synchronized void addHandler(Handler h) {
            mHandlers.add(new WeakReference<Handler>(h));
            addTaint(h.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.757 -0400", hash_original_method = "2BDCB7974021DF1350762A5BB88607D6", hash_generated_method = "AE7FDC1644875F7E24D9FBD2AAF1A982")
        public void onConfigurationChanged(Configuration newConfig) {
            
            {
                boolean var77DE7BD4514F064D49FEE0FA393B405C_212585629 = (mHandlers.size() == 0);
            } 
            int orientation = mWindowManager.getDefaultDisplay().getOrientation();
            
            orientation = 90;
            
            
            orientation = 180;
            
            
            orientation = -90;
            
            
            orientation = 0;
            
            {
                ArrayList<WeakReference> handlersToRemove = new ArrayList<WeakReference>(mHandlers.size());
                {
                    Iterator<WeakReference<Handler>> varCECD96480F7943C24B44EAC392B955D4_25028597 = (mHandlers).iterator();
                    varCECD96480F7943C24B44EAC392B955D4_25028597.hasNext();
                    WeakReference<Handler> wh = varCECD96480F7943C24B44EAC392B955D4_25028597.next();
                    {
                        Handler h = wh.get();
                        {
                            h.sendMessage(h.obtainMessage(ORIENTATION_CHANGED,
                                    orientation, 0));
                        } 
                        {
                            handlersToRemove.add(wh);
                        } 
                    } 
                } 
                {
                    Iterator<WeakReference> varD1D4DD7CA023B24419A744496E994C66_1180401354 = (handlersToRemove).iterator();
                    varD1D4DD7CA023B24419A744496E994C66_1180401354.hasNext();
                    WeakReference weak = varD1D4DD7CA023B24419A744496E994C66_1180401354.next();
                    {
                        mHandlers.remove(weak);
                    } 
                } 
            } 
            addTaint(newConfig.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.757 -0400", hash_original_method = "4F0E380BE715BF5B2ECCDB1794C8905E", hash_generated_method = "39AEB8790734ECC8DC70BBAAEE0BAB0B")
        public void onLowMemory() {
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.757 -0400", hash_original_field = "9722F24E24D81405093C0E61AAF58518", hash_generated_field = "061362C112C980EB4954480FBAFBE378")

    private static final String LOGTAG = "webkit";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.757 -0400", hash_original_field = "CDFAF77A2FA5EC066BA0E8526D3DF9B6", hash_generated_field = "07C45052F371F817A6E9C7129020689B")

    private final static int MAX_OUTSTANDING_REQUESTS = 300;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.757 -0400", hash_original_field = "08264D80E569A896C711C6D06BF1C7FB", hash_generated_field = "94DDE74C5F4F9A005F48AE56FBE99C46")

    static final int FRAME_COMPLETED = 1001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.757 -0400", hash_original_field = "D58FFECC421A99733068B40E1BF3863E", hash_generated_field = "AF9351C3CDB755F3B9F929001804B228")

    static final int ORIENTATION_CHANGED = 1002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.757 -0400", hash_original_field = "FE767547E3C3381CD214DBBD311BD589", hash_generated_field = "C36A7AE2DF93855D8C17DDD00680C01F")

    static final int POLICY_FUNCTION = 1003;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.757 -0400", hash_original_field = "42CA85DD55D979A50F59E8033EAE23DF", hash_generated_field = "DFF5E87C0D76673051368D90F72B1604")

    static final int FRAME_LOADTYPE_STANDARD = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.757 -0400", hash_original_field = "69134FE8B8D5C2428E783F32DBD4667A", hash_generated_field = "C98CAC212FCE0950CF5C591CBA26F6CC")

    static final int FRAME_LOADTYPE_BACK = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.757 -0400", hash_original_field = "EC9164750C25708474F7809198FB9B0A", hash_generated_field = "D7F18C05A3ED8C1A9A5E43B62A743FF7")

    static final int FRAME_LOADTYPE_FORWARD = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.757 -0400", hash_original_field = "8FC4318A9366EC9598B68F0ED5B4321C", hash_generated_field = "A6DC1C43F9AA0B9E9057D9DF6E190A28")

    static final int FRAME_LOADTYPE_INDEXEDBACKFORWARD = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.757 -0400", hash_original_field = "7C337B55EFB5BF129446F63999814543", hash_generated_field = "648167BCE91CB300141EF0AFB6CD386E")

    static final int FRAME_LOADTYPE_RELOAD = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.757 -0400", hash_original_field = "E45151A6382EAF3CD93F035386BD43CD", hash_generated_field = "562F9B01E203DDE63B327BFF2B1CD946")

    static final int FRAME_LOADTYPE_RELOADALLOWINGSTALEDATA = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.757 -0400", hash_original_field = "5656BBB72E737D2EFBB47A70745C5604", hash_generated_field = "85E2877EDE72029BC342156260E07F32")

    static final int FRAME_LOADTYPE_SAME = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.757 -0400", hash_original_field = "9EFB3DB1E71EDCE68E26DB4736B8C684", hash_generated_field = "7323181853C306D4388E0BF9D6453477")

    static final int FRAME_LOADTYPE_REDIRECT = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.758 -0400", hash_original_field = "203DA8B32D1C553F34447AEC0A6A6CE2", hash_generated_field = "F07767150327DF86E3F5EFA1195635EC")

    static final int FRAME_LOADTYPE_REPLACE = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.758 -0400", hash_original_field = "8B9874510E93C75D2D1860303D1764B7", hash_generated_field = "4F198CADE81901781EF8AE5AB17DB41B")

    private static final int TRANSITION_SWITCH_THRESHOLD = 75;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.758 -0400", hash_original_field = "223854A0F98CC96430A4D417102C6786", hash_generated_field = "D7883F783809ED0F8DBFDDE29B0E7616")

    static JWebCoreJavaBridge sJavaBridge;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.758 -0400", hash_original_field = "F19C3882056A46D6E38929CE3312949C", hash_generated_field = "83DD52CDBA28345681C620B41796288C")

    static ConfigCallback sConfigCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.758 -0400", hash_original_field = "ED5999AD6D797AC5AAB7EF962BCC197B", hash_generated_field = "13740A75EDBFEE6C8A5C3D763C02E3C3")

    static final int POLICY_USE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.758 -0400", hash_original_field = "038A012F80070C6D0E2694302C5D96F5", hash_generated_field = "2FABA77BC47A5226C38B743147FB61D6")

    static final int POLICY_IGNORE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.758 -0400", hash_original_field = "0C3B665F405199970F23D4818081FB85", hash_generated_field = "3B0BA434BBAF6F143B1004BB592C5D7E")

    private static final int NODOMAIN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.758 -0400", hash_original_field = "18516BFEE79487E48612E1A5B9E185D7", hash_generated_field = "AD9F10F130C2DBFC8F084342E0C12F0A")

    private static final int LOADERROR = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.758 -0400", hash_original_field = "BD435F7DEF7B7217246B2D559271A4CB", hash_generated_field = "F4AD924B573A3AD2500D585C18423161")

    static final int DRAWABLEDIR = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.758 -0400", hash_original_field = "B7C58CFD13E85CE0D36E8ADD993680D5", hash_generated_field = "309D0176BF26B7AC77784E88B4D15E58")

    private static final int FILE_UPLOAD_LABEL = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.758 -0400", hash_original_field = "4C76E81D8F8110B8D6F02CF8E99C7BE0", hash_generated_field = "FD5A9527260C0D4BB974D71092CE0CA5")

    private static final int RESET_LABEL = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.758 -0400", hash_original_field = "4332CE042ECBFC917A5B0C3B6A803F1B", hash_generated_field = "C4DC7FB1DE12FCB7898E3269E9F8A2BA")

    private static final int SUBMIT_LABEL = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.758 -0400", hash_original_field = "910631508F84D90DCD807E27D1002B78", hash_generated_field = "AD5F5EC77DEB8EB516DC019450BAA732")

    private static final int FILE_UPLOAD_NO_FILE_CHOSEN = 7;
    
}

