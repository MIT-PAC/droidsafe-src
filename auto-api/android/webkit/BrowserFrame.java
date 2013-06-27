package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.413 -0400", hash_original_field = "957B64C4FA99E51BCE1B62690725D115", hash_generated_field = "62789CA10670C708EA4D387AB18C5F89")

    private CallbackProxy mCallbackProxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.413 -0400", hash_original_field = "A5E11DE354AE2FBFC3E5565E23F4F865", hash_generated_field = "D4F7B9B886C1ADC785C82D3DD8AF3DFF")

    private WebSettings mSettings;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.413 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.413 -0400", hash_original_field = "8C0B67E1F99496AB4CD09433C231BEB3", hash_generated_field = "7BDDBEC30F299EE26388591EE1BF8D76")

    private WebViewDatabase mDatabase;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.413 -0400", hash_original_field = "9371E2004CE9EC2E60E3F0EBE8ED2E84", hash_generated_field = "73DACDCC92B5BF8822959B0368CF2255")

    private WebViewCore mWebViewCore;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.413 -0400", hash_original_field = "18C5BDE066D80086E4363915A042058B", hash_generated_field = "B4EA0C57C793BB0B49B6968B7FE9D971")

    boolean mLoadInitFromJava;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.413 -0400", hash_original_field = "01D334B431DA26637B5EF7A829298F7D", hash_generated_field = "C86D106D01922BD5804E6AAE242DA6C3")

    private int mLoadType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.413 -0400", hash_original_field = "18D8FCC50BBFDBCB161CD7DD4E3404BE", hash_generated_field = "776616C56C2E01B1F2BB9B8C0B82CB21")

    private boolean mFirstLayoutDone = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.413 -0400", hash_original_field = "C5E19DCA01BDA9FF5D89D2ACFFE2F12C", hash_generated_field = "EC7856A93088DA99A6DF3A617D2EA4C1")

    private boolean mCommitted = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.413 -0400", hash_original_field = "006072914B84F6CA94E2A188B4C8239F", hash_generated_field = "EFE4830A112EE1BAABB9D028ED0F40E4")

    private boolean mBlockMessages = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.413 -0400", hash_original_field = "9CB1303D307C48F5668E893BEC7E4DA2", hash_generated_field = "9A84F3DDA9738602717ED248C7C54BA0")

    private int mOrientation = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.413 -0400", hash_original_field = "017BEB0E2B69AC773E76EDE517E49275", hash_generated_field = "288919EE03CF52ADC4ECF3BE90DB3FD0")

    private boolean mIsMainFrame;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.413 -0400", hash_original_field = "82B4A5C03B9C8E7AECA4C75B7949A817", hash_generated_field = "6BE2AF2AB55A96D7E8AF44D0319FADE3")

    private Map<String, Object> mJavaScriptObjects;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.413 -0400", hash_original_field = "860BB378791B281E4412623871A3DF71", hash_generated_field = "0CD8E441AD75D857B58751166EA1B830")

    private Set<Object> mRemovedJavaScriptObjects;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.413 -0400", hash_original_field = "AE4C5D15C981FA9DC4C7098F4216875A", hash_generated_field = "6F2547FBE326896235C67C4D21E1AAB0")

    private KeyStoreHandler mKeyStoreHandler = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.413 -0400", hash_original_field = "C2C311879F539529159B9BF820E134A3", hash_generated_field = "4A5DF3233C257C28C1B6F01FDD889A88")

    private SearchBoxImpl mSearchBox;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.413 -0400", hash_original_field = "99D531FFAA7E5CBA866FA026F509CD12", hash_generated_field = "74015A65A56B852D13D3A8DC44ECA23B")

    int mNativeFrame;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.415 -0400", hash_original_method = "0C0B9FED7DBC124A25298101B6DEE56A", hash_generated_method = "C3244A1BF02C84509DFC3280C460E2C5")
    public  BrowserFrame(Context context, WebViewCore w, CallbackProxy proxy,
            WebSettings settings, Map<String, Object> javascriptInterfaces) {
        Context appContext;
        appContext = context.getApplicationContext();
        {
            sJavaBridge = new JWebCoreJavaBridge();
            ActivityManager am;
            am = (ActivityManager) context
                    .getSystemService(Context.ACTIVITY_SERVICE);
            {
                boolean varD3D608BC6A05F257DDC787DC0D4348D6_1576288414 = (am.getMemoryClass() > 16);
                {
                    sJavaBridge.setCacheSize(8 * 1024 * 1024);
                } //End block
                {
                    sJavaBridge.setCacheSize(4 * 1024 * 1024);
                } //End block
            } //End collapsed parenthetic
            CacheManager.init(appContext);
            CookieSyncManager.createInstance(appContext);
            PluginManager.getInstance(appContext);
        } //End block
        {
            sConfigCallback = new ConfigCallback(
                    (WindowManager) appContext.getSystemService(
                            Context.WINDOW_SERVICE));
            ViewRootImpl.addConfigCallback(sConfigCallback);
        } //End block
        sConfigCallback.addHandler(this);
        mJavaScriptObjects = javascriptInterfaces;
        {
            mJavaScriptObjects = new HashMap<String, Object>();
        } //End block
        mRemovedJavaScriptObjects = new HashSet<Object>();
        mSettings = settings;
        mContext = context;
        mCallbackProxy = proxy;
        mDatabase = WebViewDatabase.getInstance(appContext);
        mWebViewCore = w;
        mSearchBox = new SearchBoxImpl(mWebViewCore, mCallbackProxy);
        mJavaScriptObjects.put(SearchBoxImpl.JS_INTERFACE_NAME, mSearchBox);
        AssetManager am;
        am = context.getAssets();
        nativeCreateFrame(w, am, proxy.getBackForwardList());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.423 -0400", hash_original_method = "056144D27ACF2932EFB0C1980B0D6F98", hash_generated_method = "C0FE3FF011603FC0A92896E0FBD4AC19")
    public void loadUrl(String url, Map<String, String> extraHeaders) {
        mLoadInitFromJava = true;
        {
            boolean varCEBDFC4375B080C01B891460EBEF74EE_783921311 = (URLUtil.isJavaScriptUrl(url));
            {
                stringByEvaluatingJavaScriptFromString(
                    url.substring("javascript:".length()));
            } //End block
            {
                nativeLoadUrl(url, extraHeaders);
            } //End block
        } //End collapsed parenthetic
        mLoadInitFromJava = false;
        addTaint(url.getTaint());
        addTaint(extraHeaders.getTaint());
        // ---------- Original Method ----------
        //mLoadInitFromJava = true;
        //if (URLUtil.isJavaScriptUrl(url)) {
            //stringByEvaluatingJavaScriptFromString(
                    //url.substring("javascript:".length()));
        //} else {
            //nativeLoadUrl(url, extraHeaders);
        //}
        //mLoadInitFromJava = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.423 -0400", hash_original_method = "55F163F814F53ECA11AC218202D49EB2", hash_generated_method = "2BBB3A696BE44C499CB7A1A4A8E2EEFB")
    public void postUrl(String url, byte[] data) {
        mLoadInitFromJava = true;
        nativePostUrl(url, data);
        mLoadInitFromJava = false;
        addTaint(url.getTaint());
        addTaint(data[0]);
        // ---------- Original Method ----------
        //mLoadInitFromJava = true;
        //nativePostUrl(url, data);
        //mLoadInitFromJava = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.427 -0400", hash_original_method = "210E874B3CC8A8754EDB8A64197F3EDD", hash_generated_method = "60891DF6A2F9A5242D3EA7D6C9DD16E4")
    public void loadData(String baseUrl, String data, String mimeType,
            String encoding, String historyUrl) {
        mLoadInitFromJava = true;
        {
            boolean var581113F7BD53DF8B7293B042681B40B2_1989472096 = (historyUrl == null || historyUrl.length() == 0);
            {
                historyUrl = "about:blank";
            } //End block
        } //End collapsed parenthetic
        {
            data = "";
        } //End block
        {
            boolean varCB616F65F94E18DD8D2DD4567F35B835_542000086 = (baseUrl == null || baseUrl.length() == 0);
            {
                baseUrl = "about:blank";
            } //End block
        } //End collapsed parenthetic
        {
            boolean var9AF9469A93530D5A3F337475212051A4_755918477 = (mimeType == null || mimeType.length() == 0);
            {
                mimeType = "text/html";
            } //End block
        } //End collapsed parenthetic
        nativeLoadData(baseUrl, data, mimeType, encoding, historyUrl);
        mLoadInitFromJava = false;
        addTaint(baseUrl.getTaint());
        addTaint(data.getTaint());
        addTaint(mimeType.getTaint());
        addTaint(encoding.getTaint());
        addTaint(historyUrl.getTaint());
        // ---------- Original Method ----------
        //mLoadInitFromJava = true;
        //if (historyUrl == null || historyUrl.length() == 0) {
            //historyUrl = "about:blank";
        //}
        //if (data == null) {
            //data = "";
        //}
        //if (baseUrl == null || baseUrl.length() == 0) {
            //baseUrl = "about:blank";
        //}
        //if (mimeType == null || mimeType.length() == 0) {
            //mimeType = "text/html";
        //}
        //nativeLoadData(baseUrl, data, mimeType, encoding, historyUrl);
        //mLoadInitFromJava = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.434 -0400", hash_original_method = "FE36B1316A593126EBA1AA2EF5942205", hash_generated_method = "0A14FFC35EB3D5B9DCDDBC50E3A23D85")
     String saveWebArchive(String basename, boolean autoname) {
        String varB4EAC82CA7396A68D541C85D26508E83_2076815011 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2076815011 = nativeSaveWebArchive(basename, autoname);
        addTaint(basename.getTaint());
        addTaint(autoname);
        varB4EAC82CA7396A68D541C85D26508E83_2076815011.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2076815011;
        // ---------- Original Method ----------
        //return nativeSaveWebArchive(basename, autoname);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.434 -0400", hash_original_method = "4DB46F10EA63A90C886405E235BD3A38", hash_generated_method = "E142D1E6CCCEA6137F90879F9CE4BC83")
    public void goBackOrForward(int steps) {
        mLoadInitFromJava = true;
        nativeGoBackOrForward(steps);
        mLoadInitFromJava = false;
        addTaint(steps);
        // ---------- Original Method ----------
        //mLoadInitFromJava = true;
        //nativeGoBackOrForward(steps);
        //mLoadInitFromJava = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.434 -0400", hash_original_method = "50E452D86A3E55153B3E0F1DD816D615", hash_generated_method = "DF710B4E689CFEC5591B78F48B41E155")
    private void reportError(int errorCode, String description, String failingUrl) {
        resetLoadingStates();
        {
            boolean var40AE9761DC6AF2B0949485DECF62ABEE_1319462128 = (description == null || description.isEmpty());
            {
                description = ErrorStrings.getString(errorCode, mContext);
            } //End block
        } //End collapsed parenthetic
        mCallbackProxy.onReceivedError(errorCode, description, failingUrl);
        addTaint(errorCode);
        addTaint(description.getTaint());
        addTaint(failingUrl.getTaint());
        // ---------- Original Method ----------
        //resetLoadingStates();
        //if (description == null || description.isEmpty()) {
            //description = ErrorStrings.getString(errorCode, mContext);
        //}
        //mCallbackProxy.onReceivedError(errorCode, description, failingUrl);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.435 -0400", hash_original_method = "7B4A87199DD3BC0CC52E5F0CAA9F0064", hash_generated_method = "FA4CC3EB22F179EC946E9ABCED374DF7")
    private void resetLoadingStates() {
        mCommitted = true;
        mFirstLayoutDone = true;
        // ---------- Original Method ----------
        //mCommitted = true;
        //mFirstLayoutDone = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.435 -0400", hash_original_method = "82C14ED51175F3BAD05958BE30AA9B50", hash_generated_method = "4410139D937EE6FC451152725F26E68A")
     boolean committed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2116359385 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2116359385;
        // ---------- Original Method ----------
        //return mCommitted;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.435 -0400", hash_original_method = "6055F5425C1866007AB953B33770A39A", hash_generated_method = "CA103738971543B1293005D2FDE3A422")
     boolean firstLayoutDone() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1960002298 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1960002298;
        // ---------- Original Method ----------
        //return mFirstLayoutDone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.435 -0400", hash_original_method = "9068063B02257F9D08EFF05D6BD051A9", hash_generated_method = "911F13C79BE3A1AC4E9FE4210252017F")
     int loadType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1900168630 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1900168630;
        // ---------- Original Method ----------
        //return mLoadType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.444 -0400", hash_original_method = "027FDD69E025CF7A20175D3E84246197", hash_generated_method = "357F4E3DB5D03FD6715BE288D2C81D45")
     void didFirstLayout() {
        {
            mFirstLayoutDone = true;
            mWebViewCore.contentDraw();
        } //End block
        // ---------- Original Method ----------
        //if (!mFirstLayoutDone) {
            //mFirstLayoutDone = true;
            //mWebViewCore.contentDraw();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.444 -0400", hash_original_method = "588CB65AC18071EB5B02ABC642CC0A1A", hash_generated_method = "495977A334CAC32AD68E1E398A2A2DDF")
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
            } //End block
        } //End block
        addTaint(url.getTaint());
        addTaint(favicon.getTaint());
        // ---------- Original Method ----------
        //mIsMainFrame = isMainFrame;
        //if (isMainFrame || loadType == FRAME_LOADTYPE_STANDARD) {
            //mLoadType = loadType;
            //if (isMainFrame) {
                //mCallbackProxy.onPageStarted(url, favicon);
                //mFirstLayoutDone = false;
                //mCommitted = false;
                //mWebViewCore.removeMessages(WebViewCore.EventHub.WEBKIT_DRAW);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.445 -0400", hash_original_method = "C9CC31AE97DBC19619CDCFC15EC7B03E", hash_generated_method = "91C2EB78415E0BAACE274E2380C2C400")
    @SuppressWarnings("unused")
    private void saveFormData(HashMap<String, String> data) {
        {
            boolean varE277716CFEE75D183A4BE1A1459F291C_32245653 = (mSettings.getSaveFormData());
            {
                WebHistoryItem h;
                h = mCallbackProxy.getBackForwardList()
                    .getCurrentItem();
                {
                    String url;
                    url = WebTextView.urlForAutoCompleteData(h.getUrl());
                    {
                        mDatabase.setFormData(url, data);
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(data.getTaint());
        // ---------- Original Method ----------
        //if (mSettings.getSaveFormData()) {
            //final WebHistoryItem h = mCallbackProxy.getBackForwardList()
                    //.getCurrentItem();
            //if (h != null) {
                //String url = WebTextView.urlForAutoCompleteData(h.getUrl());
                //if (url != null) {
                    //mDatabase.setFormData(url, data);
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.445 -0400", hash_original_method = "F4B9AF2B8B6C0B9D0EBAE01BEE4BF775", hash_generated_method = "8DF8530FA2AFFF5399A89B38D0865560")
    @SuppressWarnings("unused")
    private boolean shouldSaveFormData() {
        {
            boolean varE277716CFEE75D183A4BE1A1459F291C_678431525 = (mSettings.getSaveFormData());
            {
                WebHistoryItem h;
                h = mCallbackProxy.getBackForwardList()
                    .getCurrentItem();
                boolean var0A9CE26076094D732B198C6841494F25_188070209 = (h != null && h.getUrl() != null);
            } //End block
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1406558268 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1406558268;
        // ---------- Original Method ----------
        //if (mSettings.getSaveFormData()) {
            //final WebHistoryItem h = mCallbackProxy.getBackForwardList()
                    //.getCurrentItem();
            //return h != null && h.getUrl() != null;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.446 -0400", hash_original_method = "7094DD5A86271DA7E952B216F4C46CCD", hash_generated_method = "BC2E329BA0A76D72F8711B8BDDABBEE8")
    private void transitionToCommitted(int loadType, boolean isMainFrame) {
        {
            mCommitted = true;
            mWebViewCore.getWebView().mViewManager.postResetStateAll();
        } //End block
        addTaint(loadType);
        addTaint(isMainFrame);
        // ---------- Original Method ----------
        //if (isMainFrame) {
            //mCommitted = true;
            //mWebViewCore.getWebView().mViewManager.postResetStateAll();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.446 -0400", hash_original_method = "5C2FD3A5795EB59386117F9A61E0ADCE", hash_generated_method = "0E76D6C1B529652600CC1759CFEFC07B")
    private void loadFinished(String url, int loadType, boolean isMainFrame) {
        {
            {
                resetLoadingStates();
                mCallbackProxy.switchOutDrawHistory();
                mCallbackProxy.onPageFinished(url);
            } //End block
        } //End block
        addTaint(url.getTaint());
        addTaint(loadType);
        addTaint(isMainFrame);
        // ---------- Original Method ----------
        //if (isMainFrame || loadType == FRAME_LOADTYPE_STANDARD) {
            //if (isMainFrame) {
                //resetLoadingStates();
                //mCallbackProxy.switchOutDrawHistory();
                //mCallbackProxy.onPageFinished(url);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.453 -0400", hash_original_method = "D2CB1A360A21716BE59AD0C99E7F7543", hash_generated_method = "E7E6C8BB504C1ABC54529D5BF268DFFE")
     void certificate(SslCertificate certificate) {
        {
            mCallbackProxy.onReceivedCertificate(certificate);
        } //End block
        addTaint(certificate.getTaint());
        // ---------- Original Method ----------
        //if (mIsMainFrame) {
            //mCallbackProxy.onReceivedCertificate(certificate);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.454 -0400", hash_original_method = "FF0F600C92E1745B1B3B7823F85C9072", hash_generated_method = "3C727BDF61EF3EB2B960E985C9E7AA07")
    public void destroy() {
        nativeDestroyFrame();
        mBlockMessages = true;
        removeCallbacksAndMessages(null);
        // ---------- Original Method ----------
        //nativeDestroyFrame();
        //mBlockMessages = true;
        //removeCallbacksAndMessages(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.455 -0400", hash_original_method = "08B10BC0FD4D849356EF434C4A57C456", hash_generated_method = "524F2C880FFC41BB99BCD329578A287B")
    @Override
    public void handleMessage(Message msg) {
        //Begin case FRAME_COMPLETED 
        {
            {
                boolean var62FF4720D31A7507990A918088ECF943_1501405654 = (mSettings.getSavePassword() && hasPasswordField());
                {
                    WebHistoryItem item;
                    item = mCallbackProxy.getBackForwardList()
                            .getCurrentItem();
                    {
                        WebAddress uri;
                        uri = new WebAddress(item.getUrl());
                        String schemePlusHost;
                        schemePlusHost = uri.getScheme() + uri.getHost();
                        String[] up;
                        up = mDatabase.getUsernamePassword(schemePlusHost);
                        {
                            setUsernamePassword(up[0], up[1]);
                        } //End block
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                boolean var6B43FCDD8E50C7CA617498FD267AAC18_407201936 = (!JniUtil.useChromiumHttpStack());
                {
                    WebViewWorker.getHandler().sendEmptyMessage(
                            WebViewWorker.MSG_TRIM_CACHE);
                } //End block
            } //End collapsed parenthetic
        } //End block
        //End case FRAME_COMPLETED 
        //Begin case POLICY_FUNCTION 
        {
            nativeCallPolicyFunction(msg.arg1, msg.arg2);
        } //End block
        //End case POLICY_FUNCTION 
        //Begin case ORIENTATION_CHANGED 
        {
            {
                mOrientation = msg.arg1;
                nativeOrientationChanged(msg.arg1);
            } //End block
        } //End block
        //End case ORIENTATION_CHANGED 
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.455 -0400", hash_original_method = "71CD366348BF98805D3BCFC6E13F61B1", hash_generated_method = "55478C4548772023BBC8202A9F2F1945")
    private void setTitle(String title) {
        mCallbackProxy.onReceivedTitle(title);
        addTaint(title.getTaint());
        // ---------- Original Method ----------
        //mCallbackProxy.onReceivedTitle(title);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.456 -0400", hash_original_method = "DC38D0601A6CA8B3CA54AD6CF11C8ED7", hash_generated_method = "CADF6A855CA06C4D65518E1FB1088547")
    public void externalRepresentation(Message callback) {
        callback.obj = externalRepresentation();
        ;
        callback.sendToTarget();
        addTaint(callback.getTaint());
        // ---------- Original Method ----------
        //callback.obj = externalRepresentation();
        //;
        //callback.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.456 -0400", hash_original_method = "818D4287AF55B155FD9BEC63FC9BB14D", hash_generated_method = "2CE36722D89C9AAE233D32794227C266")
    private String externalRepresentation() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.473 -0400", hash_original_method = "769B7E21D870172A915EE6F0EB6B2D2C", hash_generated_method = "FAEC694C08D0659FD40F665ABEC9CC9C")
    public void documentAsText(Message callback) {
        StringBuilder text;
        text = new StringBuilder();
        {
            text.append(documentAsText());
        } //End block
        {
            text.append(childFramesAsText());
        } //End block
        callback.obj = text.toString();
        callback.sendToTarget();
        addTaint(callback.getTaint());
        // ---------- Original Method ----------
        //StringBuilder text = new StringBuilder();
        //if (callback.arg1 != 0) {
            //text.append(documentAsText());
        //}
        //if (callback.arg2 != 0) {
            //text.append(childFramesAsText());
        //}
        //callback.obj = text.toString();
        //callback.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.474 -0400", hash_original_method = "79942AAFA346C254C5198053B4C683D6", hash_generated_method = "07D5EDE5120089FA81790CBAAE4B851E")
    private String documentAsText() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.474 -0400", hash_original_method = "BAA59F57B83FBAF7CC9F5BD462BDF4D7", hash_generated_method = "81DE64B9D9AB653AFA9FD34037C2102D")
    private String childFramesAsText() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.475 -0400", hash_original_method = "7D1B04AB7A647E05019AB7BC865C3803", hash_generated_method = "3D3AD9864B1B3A74E92E2222856E44CA")
    private void windowObjectCleared(int nativeFramePointer) {
        Iterator<String> iter;
        iter = mJavaScriptObjects.keySet().iterator();
        {
            boolean varADABAFEBBAB7E585DD903333BD7F20A8_1640312597 = (iter.hasNext());
            {
                String interfaceName;
                interfaceName = iter.next();
                Object object;
                object = mJavaScriptObjects.get(interfaceName);
                {
                    nativeAddJavascriptInterface(nativeFramePointer,
                        mJavaScriptObjects.get(interfaceName), interfaceName);
                } //End block
            } //End block
        } //End collapsed parenthetic
        mRemovedJavaScriptObjects.clear();
        stringByEvaluatingJavaScriptFromString(SearchBoxImpl.JS_BRIDGE);
        addTaint(nativeFramePointer);
        // ---------- Original Method ----------
        //Iterator<String> iter = mJavaScriptObjects.keySet().iterator();
        //while (iter.hasNext())  {
            //String interfaceName = iter.next();
            //Object object = mJavaScriptObjects.get(interfaceName);
            //if (object != null) {
                //nativeAddJavascriptInterface(nativeFramePointer,
                        //mJavaScriptObjects.get(interfaceName), interfaceName);
            //}
        //}
        //mRemovedJavaScriptObjects.clear();
        //stringByEvaluatingJavaScriptFromString(SearchBoxImpl.JS_BRIDGE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.475 -0400", hash_original_method = "2FB67C52CD526BE2C970DC0DB75D361F", hash_generated_method = "3526E2F9CC926DD89DF57ACF599F45B5")
    public boolean handleUrl(String url) {
        {
            boolean var7DE13210A5C773F021EC43207BBDA187_1473046635 = (mCallbackProxy.shouldOverrideUrlLoading(url));
            {
                didFirstLayout();
            } //End block
        } //End collapsed parenthetic
        addTaint(url.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1685898436 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1685898436;
        // ---------- Original Method ----------
        //if (mLoadInitFromJava == true) {
            //return false;
        //}
        //if (mCallbackProxy.shouldOverrideUrlLoading(url)) {
            //didFirstLayout();
            //return true;
        //} else {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.476 -0400", hash_original_method = "8112D6E9F2629FDD519CF9C502DF963B", hash_generated_method = "E178970CCDAC65F2BC4BE3EE6E494718")
    public void addJavascriptInterface(Object obj, String interfaceName) {
        removeJavascriptInterface(interfaceName);
        mJavaScriptObjects.put(interfaceName, obj);
        addTaint(obj.getTaint());
        addTaint(interfaceName.getTaint());
        // ---------- Original Method ----------
        //assert obj != null;
        //removeJavascriptInterface(interfaceName);
        //mJavaScriptObjects.put(interfaceName, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.477 -0400", hash_original_method = "D4D979316C36EF31BC47A23AC0C9BE50", hash_generated_method = "D2DD4930E0AFCC3E2A393747100251D1")
    public void removeJavascriptInterface(String interfaceName) {
        {
            boolean varBA61D59CAAA24DBF67D72A8EF3264200_1040567783 = (mJavaScriptObjects.containsKey(interfaceName));
            {
                mRemovedJavaScriptObjects.add(mJavaScriptObjects.remove(interfaceName));
            } //End block
        } //End collapsed parenthetic
        addTaint(interfaceName.getTaint());
        // ---------- Original Method ----------
        //if (mJavaScriptObjects.containsKey(interfaceName)) {
            //mRemovedJavaScriptObjects.add(mJavaScriptObjects.remove(interfaceName));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.477 -0400", hash_original_method = "DF8E19ADC1C4D892E5E9E24D72F873C3", hash_generated_method = "37AC26A94442460E9CBA08DC9C8C6138")
    private int getFileSize(String uri) {
        int size;
        size = 0;
        try 
        {
            InputStream stream;
            stream = mContext.getContentResolver()
                            .openInputStream(Uri.parse(uri));
            size = stream.available();
            stream.close();
        } //End block
        catch (Exception e)
        { }
        addTaint(uri.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_144581412 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_144581412;
        // ---------- Original Method ----------
        //int size = 0;
        //try {
            //InputStream stream = mContext.getContentResolver()
                            //.openInputStream(Uri.parse(uri));
            //size = stream.available();
            //stream.close();
        //} catch (Exception e) {}
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.568 -0400", hash_original_method = "D65A9387A3FB37FCB544A79FFB5606B6", hash_generated_method = "04D1FC63BFC99475B2332BC4788146AD")
    private int getFile(String uri, byte[] buffer, int offset,
            int expectedSize) {
        int size;
        size = 0;
        try 
        {
            InputStream stream;
            stream = mContext.getContentResolver()
                            .openInputStream(Uri.parse(uri));
            size = stream.available();
            {
                stream.read(buffer, offset, size);
            } //End block
            {
                size = 0;
            } //End block
            stream.close();
        } //End block
        catch (java.io.FileNotFoundException e)
        {
            size = 0;
        } //End block
        catch (java.io.IOException e2)
        {
            size = 0;
        } //End block
        addTaint(uri.getTaint());
        addTaint(buffer[0]);
        addTaint(offset);
        addTaint(expectedSize);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1677335958 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1677335958;
        // ---------- Original Method ----------
        //int size = 0;
        //try {
            //InputStream stream = mContext.getContentResolver()
                            //.openInputStream(Uri.parse(uri));
            //size = stream.available();
            //if (size <= expectedSize && buffer != null
                    //&& buffer.length - offset >= size) {
                //stream.read(buffer, offset, size);
            //} else {
                //size = 0;
            //}
            //stream.close();
        //} catch (java.io.FileNotFoundException e) {
            //Log.e(LOGTAG, "FileNotFoundException:" + e);
            //size = 0;
        //} catch (java.io.IOException e2) {
            //Log.e(LOGTAG, "IOException: " + e2);
            //size = 0;
        //}
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.574 -0400", hash_original_method = "60CA323AEDF7C276FF8B65BEFBD4FA69", hash_generated_method = "95FD7B03C92A03ECC534CEED2AFC39D3")
    private InputStream inputStreamForAndroidResource(String url) {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1832730655 = null; //Variable for return #1
        InputStream varB4EAC82CA7396A68D541C85D26508E83_560848028 = null; //Variable for return #2
        InputStream varB4EAC82CA7396A68D541C85D26508E83_700611552 = null; //Variable for return #3
        InputStream varB4EAC82CA7396A68D541C85D26508E83_213008759 = null; //Variable for return #4
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1936431865 = null; //Variable for return #5
        InputStream varB4EAC82CA7396A68D541C85D26508E83_2076186553 = null; //Variable for return #6
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1920185478 = null; //Variable for return #7
        InputStream varB4EAC82CA7396A68D541C85D26508E83_193388037 = null; //Variable for return #8
        InputStream varB4EAC82CA7396A68D541C85D26508E83_316624496 = null; //Variable for return #9
        InputStream varB4EAC82CA7396A68D541C85D26508E83_583085867 = null; //Variable for return #10
        String ANDROID_ASSET;
        ANDROID_ASSET = "file:///android_asset/";
        String ANDROID_RESOURCE;
        ANDROID_RESOURCE = "file:///android_res/";
        String ANDROID_CONTENT;
        ANDROID_CONTENT = "content:";
        {
            boolean varFDE4819B7BD4D15D01E52BC5B52139CC_314534574 = (url.startsWith(ANDROID_RESOURCE));
            {
                url = url.replaceFirst(ANDROID_RESOURCE, "");
                {
                    boolean var6AB4ECE4FADE49B1DE66FC23626AC729_274536596 = (url == null || url.length() == 0);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1832730655 = null;
                    } //End block
                } //End collapsed parenthetic
                int slash;
                slash = url.indexOf('/');
                int dot;
                dot = url.indexOf('.', slash);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_560848028 = null;
                } //End block
                String subClassName;
                subClassName = url.substring(0, slash);
                String fieldName;
                fieldName = url.substring(slash + 1, dot);
                String errorMsg;
                errorMsg = null;
                try 
                {
                    Class<?> d;
                    d = mContext.getApplicationContext()
                        .getClassLoader().loadClass(
                                mContext.getPackageName() + ".R$"
                                        + subClassName);
                    java.lang.reflect.Field field;
                    field = d.getField(fieldName);
                    int id;
                    id = field.getInt(null);
                    TypedValue value;
                    value = new TypedValue();
                    mContext.getResources().getValue(id, value, true);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_700611552 = mContext.getAssets().openNonAsset(
                            value.assetCookie, value.string.toString(),
                            AssetManager.ACCESS_STREAMING);
                    } //End block
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_213008759 = null;
                    } //End block
                } //End block
                catch (Exception e)
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1936431865 = null;
                } //End block
            } //End block
            {
                boolean varA326CC4BBEB8E48966FD18C590AD09E0_1855045391 = (url.startsWith(ANDROID_ASSET));
                {
                    url = url.replaceFirst(ANDROID_ASSET, "");
                    try 
                    {
                        AssetManager assets;
                        assets = mContext.getAssets();
                        varB4EAC82CA7396A68D541C85D26508E83_2076186553 = assets.open(url, AssetManager.ACCESS_STREAMING);
                    } //End block
                    catch (IOException e)
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1920185478 = null;
                    } //End block
                } //End block
                {
                    boolean var9D1D2B0882467AD6080B338924D7EEBD_533143830 = (mSettings.getAllowContentAccess() &&
                   url.startsWith(ANDROID_CONTENT));
                    {
                        try 
                        {
                            int mimeIndex;
                            mimeIndex = url.lastIndexOf('?');
                            {
                                url = url.substring(0, mimeIndex);
                            } //End block
                            Uri uri;
                            uri = Uri.parse(url);
                            varB4EAC82CA7396A68D541C85D26508E83_193388037 = mContext.getContentResolver().openInputStream(uri);
                        } //End block
                        catch (Exception e)
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_316624496 = null;
                        } //End block
                    } //End block
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_583085867 = null;
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        addTaint(url.getTaint());
        InputStream varA7E53CE21691AB073D9660D615818899_1429261208; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1429261208 = varB4EAC82CA7396A68D541C85D26508E83_1832730655;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1429261208 = varB4EAC82CA7396A68D541C85D26508E83_560848028;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1429261208 = varB4EAC82CA7396A68D541C85D26508E83_700611552;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1429261208 = varB4EAC82CA7396A68D541C85D26508E83_213008759;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_1429261208 = varB4EAC82CA7396A68D541C85D26508E83_1936431865;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_1429261208 = varB4EAC82CA7396A68D541C85D26508E83_2076186553;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_1429261208 = varB4EAC82CA7396A68D541C85D26508E83_1920185478;
                break;
            case 8: //Assign result for return ordinal #8
                varA7E53CE21691AB073D9660D615818899_1429261208 = varB4EAC82CA7396A68D541C85D26508E83_193388037;
                break;
            case 9: //Assign result for return ordinal #9
                varA7E53CE21691AB073D9660D615818899_1429261208 = varB4EAC82CA7396A68D541C85D26508E83_316624496;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1429261208 = varB4EAC82CA7396A68D541C85D26508E83_583085867;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1429261208.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1429261208;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.595 -0400", hash_original_method = "DEA49E30923C6B4E17F9FB446E1784D4", hash_generated_method = "2E50B63861D6DEC73C0B2C93C2968C88")
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
        LoadListener varB4EAC82CA7396A68D541C85D26508E83_1255173587 = null; //Variable for return #1
        LoadListener varB4EAC82CA7396A68D541C85D26508E83_694192155 = null; //Variable for return #2
        {
            boolean var6F8758D2F464DBB6403377B21E3BD81A_569309425 = (mSettings.getCacheMode() != WebSettings.LOAD_DEFAULT);
            {
                cacheMode = mSettings.getCacheMode();
            } //End block
        } //End collapsed parenthetic
        {
            boolean varE136B9F2BD76354D2C6E072F73228787_194886233 = (method.equals("POST"));
            {
                {
                    cacheMode = WebSettings.LOAD_NO_CACHE;
                } //End block
                String[] ret;
                ret = getUsernamePassword();
                {
                    String domUsername;
                    domUsername = ret[0];
                    String domPassword;
                    domPassword = ret[1];
                    maybeSavePassword(postData, domUsername, domPassword);
                } //End block
            } //End block
        } //End collapsed parenthetic
        boolean isMainFramePage;
        isMainFramePage = mIsMainFrame;
        LoadListener loadListener;
        loadListener = LoadListener.getLoadListener(mContext,
                this, url, loaderHandle, synchronous, isMainFramePage,
                mainResource, userGesture, postDataIdentifier, username, password);
        {
            boolean var94019098962C39DF55C40C7C4C678CCF_1215129778 = (LoadListener.getNativeLoaderCount() > MAX_OUTSTANDING_REQUESTS);
            {
                loadListener.error(
                    android.net.http.EventHandler.ERROR, mContext.getString(
                            com.android.internal.R.string.httpErrorTooManyRequests));
                varB4EAC82CA7396A68D541C85D26508E83_1255173587 = loadListener;
            } //End block
        } //End collapsed parenthetic
        FrameLoader loader;
        loader = new FrameLoader(loadListener, mSettings, method,
                mCallbackProxy.shouldInterceptRequest(url));
        loader.setHeaders(headers);
        loader.setPostData(postData);
        loader.setCacheMode(headers.containsKey("If-Modified-Since")
                || headers.containsKey("If-None-Match") ? 
                        WebSettings.LOAD_NO_CACHE : cacheMode);
        varB4EAC82CA7396A68D541C85D26508E83_694192155 = !synchronous ? loadListener : null;
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
        LoadListener varA7E53CE21691AB073D9660D615818899_135240858; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_135240858 = varB4EAC82CA7396A68D541C85D26508E83_1255173587;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_135240858 = varB4EAC82CA7396A68D541C85D26508E83_694192155;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_135240858.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_135240858;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.597 -0400", hash_original_method = "69B43B2B2D64063203E22417AF1B4FBE", hash_generated_method = "093ECF35A86A63D065DD04B26E8D7224")
    private void maybeSavePassword(
            byte[] postData, String username, String password) {
        {
            boolean var911F0604D5A8278A2892D81EDC89EA56_1259778293 = (postData == null
                || username == null || username.isEmpty()
                || password == null || password.isEmpty());
        } //End collapsed parenthetic
        {
            boolean varF748BCF92145CEE9E6F4341D9614C6CE_737464217 = (!mSettings.getSavePassword());
        } //End collapsed parenthetic
        try 
        {
            {
                Assert.assertNotNull(mCallbackProxy.getBackForwardList()
                        .getCurrentItem());
            } //End block
            WebAddress uri;
            uri = new WebAddress(mCallbackProxy
                    .getBackForwardList().getCurrentItem().getUrl());
            String schemePlusHost;
            schemePlusHost = uri.getScheme() + uri.getHost();
            String postString;
            postString = new String(postData);
            {
                boolean var3202C69FDDB5D23F4FF83477294755BA_715247668 = (postString.contains(URLEncoder.encode(username)) &&
                    postString.contains(URLEncoder.encode(password)));
                {
                    String[] saved;
                    saved = mDatabase.getUsernamePassword(
                        schemePlusHost);
                    {
                        {
                            mDatabase.setUsernamePassword(
                                schemePlusHost, username, password);
                        } //End block
                    } //End block
                    {
                        mCallbackProxy.onSavePassword(schemePlusHost, username,
                            password, null);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (ParseException ex)
        { }
        addTaint(postData[0]);
        addTaint(username.getTaint());
        addTaint(password.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.605 -0400", hash_original_method = "DD9E58924AE2FD70E5FF51B9D61BCBED", hash_generated_method = "0A17AD81C2C1E1548364CCB7825C543D")
    private WebResourceResponse shouldInterceptRequest(String url) {
        WebResourceResponse varB4EAC82CA7396A68D541C85D26508E83_325365270 = null; //Variable for return #1
        WebResourceResponse varB4EAC82CA7396A68D541C85D26508E83_554545656 = null; //Variable for return #2
        InputStream androidResource;
        androidResource = inputStreamForAndroidResource(url);
        {
            varB4EAC82CA7396A68D541C85D26508E83_325365270 = new WebResourceResponse(null, null, androidResource);
        } //End block
        WebResourceResponse response;
        response = mCallbackProxy.shouldInterceptRequest(url);
        {
            boolean var847EBE44E86F4F89B92A16B7F267147C_1097052113 = (response == null && "browser:incognito".equals(url));
            {
                try 
                {
                    Resources res;
                    res = mContext.getResources();
                    InputStream ins;
                    ins = res.openRawResource(
                        com.android.internal.R.raw.incognito_mode_start_page);
                    response = new WebResourceResponse("text/html", "utf8", ins);
                } //End block
                catch (NotFoundException ex)
                { }
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_554545656 = response;
        addTaint(url.getTaint());
        WebResourceResponse varA7E53CE21691AB073D9660D615818899_1536732559; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1536732559 = varB4EAC82CA7396A68D541C85D26508E83_325365270;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1536732559 = varB4EAC82CA7396A68D541C85D26508E83_554545656;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1536732559.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1536732559;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.606 -0400", hash_original_method = "07700DAB8245AC940D55DCEF1A17B102", hash_generated_method = "6CDB99422DD7CC63E11F32C6B65590AD")
    private void setProgress(int newProgress) {
        mCallbackProxy.onProgressChanged(newProgress);
        {
            sendMessageDelayed(obtainMessage(FRAME_COMPLETED), 100);
        } //End block
        {
            mCallbackProxy.switchOutDrawHistory();
        } //End block
        addTaint(newProgress);
        // ---------- Original Method ----------
        //mCallbackProxy.onProgressChanged(newProgress);
        //if (newProgress == 100) {
            //sendMessageDelayed(obtainMessage(FRAME_COMPLETED), 100);
        //}
        //if (mFirstLayoutDone && newProgress > TRANSITION_SWITCH_THRESHOLD) {
            //mCallbackProxy.switchOutDrawHistory();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.606 -0400", hash_original_method = "910C3A78FCE0B1E574FD9CA74D1EE7A9", hash_generated_method = "8931057A11A6DB801BBACC504BC0B535")
    private void didReceiveIcon(Bitmap icon) {
        mCallbackProxy.onReceivedIcon(icon);
        addTaint(icon.getTaint());
        // ---------- Original Method ----------
        //mCallbackProxy.onReceivedIcon(icon);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.607 -0400", hash_original_method = "F9E26289979EC36BEDC07872BFD387F0", hash_generated_method = "0C547F9A3B3FA472E5EEEA66A8C009A2")
    private void didReceiveTouchIconUrl(String url, boolean precomposed) {
        mCallbackProxy.onReceivedTouchIconUrl(url, precomposed);
        addTaint(url.getTaint());
        addTaint(precomposed);
        // ---------- Original Method ----------
        //mCallbackProxy.onReceivedTouchIconUrl(url, precomposed);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.607 -0400", hash_original_method = "49DBB49355B8BD4E95F5FBA6E171926E", hash_generated_method = "1D2442BA73AE2B95F1BCC261F59BAC36")
    private BrowserFrame createWindow(boolean dialog, boolean userGesture) {
        BrowserFrame varB4EAC82CA7396A68D541C85D26508E83_861875396 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_861875396 = mCallbackProxy.createWindow(dialog, userGesture);
        addTaint(dialog);
        addTaint(userGesture);
        varB4EAC82CA7396A68D541C85D26508E83_861875396.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_861875396;
        // ---------- Original Method ----------
        //return mCallbackProxy.createWindow(dialog, userGesture);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.608 -0400", hash_original_method = "05E62B842D0E318583ACCB4619923A88", hash_generated_method = "75CF187AC2BCD2C92D428CFCB1D19AF9")
    private void requestFocus() {
        mCallbackProxy.onRequestFocus();
        // ---------- Original Method ----------
        //mCallbackProxy.onRequestFocus();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.608 -0400", hash_original_method = "A6BF5F00A4A45564AACA34EE9DAEC5CF", hash_generated_method = "E71E93E66A811963999EE2C83B4D6747")
    private void closeWindow(WebViewCore w) {
        mCallbackProxy.onCloseWindow(w.getWebView());
        addTaint(w.getTaint());
        // ---------- Original Method ----------
        //mCallbackProxy.onCloseWindow(w.getWebView());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.612 -0400", hash_original_method = "53828DFE68036F8E35ADAC562AA427C9", hash_generated_method = "BE2D7F7DE03C2E2EB6044DBB6B4E7038")
    private void decidePolicyForFormResubmission(int policyFunction) {
        Message dontResend;
        dontResend = obtainMessage(POLICY_FUNCTION, policyFunction,
                POLICY_IGNORE);
        Message resend;
        resend = obtainMessage(POLICY_FUNCTION, policyFunction,
                POLICY_USE);
        mCallbackProxy.onFormResubmission(dontResend, resend);
        addTaint(policyFunction);
        // ---------- Original Method ----------
        //Message dontResend = obtainMessage(POLICY_FUNCTION, policyFunction,
                //POLICY_IGNORE);
        //Message resend = obtainMessage(POLICY_FUNCTION, policyFunction,
                //POLICY_USE);
        //mCallbackProxy.onFormResubmission(dontResend, resend);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.612 -0400", hash_original_method = "B19BAB1EEF674556A3A9CC47CD14FB0B", hash_generated_method = "12C358F1B02FB6A5EBCB026210775A8E")
    private void updateVisitedHistory(String url, boolean isReload) {
        mCallbackProxy.doUpdateVisitedHistory(url, isReload);
        addTaint(url.getTaint());
        addTaint(isReload);
        // ---------- Original Method ----------
        //mCallbackProxy.doUpdateVisitedHistory(url, isReload);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.630 -0400", hash_original_method = "D3ED977A3BCAC48329E24D7D69689852", hash_generated_method = "5C27EB660720F83EA42F146B68E413E1")
     CallbackProxy getCallbackProxy() {
        CallbackProxy varB4EAC82CA7396A68D541C85D26508E83_1707288155 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1707288155 = mCallbackProxy;
        varB4EAC82CA7396A68D541C85D26508E83_1707288155.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1707288155;
        // ---------- Original Method ----------
        //return mCallbackProxy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.631 -0400", hash_original_method = "F09A8DE53C03EAD5D6B2D7442C92246E", hash_generated_method = "6677C43E959CBA87A07D652D9F2930F1")
     String getUserAgentString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2055174981 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2055174981 = mSettings.getUserAgentString();
        varB4EAC82CA7396A68D541C85D26508E83_2055174981.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2055174981;
        // ---------- Original Method ----------
        //return mSettings.getUserAgentString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.631 -0400", hash_original_method = "D14466E1FBBBA5A0DDC9A63472126D93", hash_generated_method = "B241D6828224C95AAD01DA76EB560147")
    private String getRawResFilename(int id) {
        String varB4EAC82CA7396A68D541C85D26508E83_50293542 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_50293542 = getRawResFilename(id, mContext);
        addTaint(id);
        varB4EAC82CA7396A68D541C85D26508E83_50293542.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_50293542;
        // ---------- Original Method ----------
        //return getRawResFilename(id, mContext);
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.632 -0400", hash_original_method = "E4DD03CAE364FD517B782C57726FD370", hash_generated_method = "6477C62ED8F1A772041DC6B5F3F19FA6")
    private float density() {
        float var828FED69EC6DBC28F444BC99FA02F5DC_1451199119 = (mContext.getResources().getDisplayMetrics().density);
        float var546ADE640B6EDFBC8A086EF31347E768_1379870150 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1379870150;
        // ---------- Original Method ----------
        //return mContext.getResources().getDisplayMetrics().density;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.632 -0400", hash_original_method = "468A4DE23411D07F152B7955301757EE", hash_generated_method = "E7873867BB6B42917F91614D13C1A7F2")
    private void didReceiveAuthenticationChallenge(
            final int handle, String host, String realm, final boolean useCachedCredentials,
            final boolean suppressDialog) {
        HttpAuthHandler handler;
        handler = new HttpAuthHandler() {
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
        // ---------- Original Method ----------
        //HttpAuthHandler handler = new HttpAuthHandler() {
            //@Override
            //public boolean useHttpAuthUsernamePassword() {
                //return useCachedCredentials;
            //}
            //@Override
            //public void proceed(String username, String password) {
                //nativeAuthenticationProceed(handle, username, password);
            //}
            //@Override
            //public void cancel() {
                //nativeAuthenticationCancel(handle);
            //}
            //@Override
            //public boolean suppressDialog() {
                //return suppressDialog;
            //}
        //};
        //mCallbackProxy.onReceivedHttpAuthRequest(handler, host, realm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.640 -0400", hash_original_method = "BF59E951CBFF79EB5A7A07D0C7840C24", hash_generated_method = "9EAD4C9A07385C3E92E9F289624BED1B")
    private void reportSslCertError(final int handle, final int certError, byte certDER[],
            String url) {
        SslError sslError;
        try 
        {
            X509Certificate cert;
            cert = new X509CertImpl(certDER);
            SslCertificate sslCert;
            sslCert = new SslCertificate(cert);
            sslError = SslError.SslErrorFromChromiumErrorCode(certError, sslCert, url);
        } //End block
        catch (IOException e)
        {
            nativeSslCertErrorCancel(handle, certError);
        } //End block
        {
            boolean var9E891972169349B7CCF07279CD1AABBF_132091743 = (SslCertLookupTable.getInstance().isAllowed(sslError));
            {
                nativeSslCertErrorProceed(handle);
                mCallbackProxy.onProceededAfterSslError(sslError);
            } //End block
        } //End collapsed parenthetic
        SslErrorHandler handler;
        handler = new SslErrorHandler() {
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
        addTaint(certDER);
        addTaint(url.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.641 -0400", hash_original_method = "DFA7C324E28D10E855E86AE4BB5B7562", hash_generated_method = "5CF4580BBBDA2AFAEE05159F5461032C")
    private void requestClientCert(int handle, String hostAndPort) {
        SslClientCertLookupTable table;
        table = SslClientCertLookupTable.getInstance();
        {
            boolean var3396FDE3F71A1312687665F19E9550DF_746198192 = (table.IsAllowed(hostAndPort));
            {
                nativeSslClientCert(handle,
                                table.PrivateKey(hostAndPort),
                                table.CertificateChain(hostAndPort));
            } //End block
            {
                boolean var50D6A23560AA663AF990FF8C2B0C3B75_1248540318 = (table.IsDenied(hostAndPort));
                {
                    nativeSslClientCert(handle, null, null);
                } //End block
                {
                    mCallbackProxy.onReceivedClientCertRequest(
                    new ClientCertRequestHandler(this, handle, hostAndPort, table), hostAndPort);
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        addTaint(handle);
        addTaint(hostAndPort.getTaint());
        // ---------- Original Method ----------
        //SslClientCertLookupTable table = SslClientCertLookupTable.getInstance();
        //if (table.IsAllowed(hostAndPort)) {
            //nativeSslClientCert(handle,
                                //table.PrivateKey(hostAndPort),
                                //table.CertificateChain(hostAndPort));
        //} else if (table.IsDenied(hostAndPort)) {
            //nativeSslClientCert(handle, null, null);
        //} else {
            //mCallbackProxy.onReceivedClientCertRequest(
                    //new ClientCertRequestHandler(this, handle, hostAndPort, table), hostAndPort);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.642 -0400", hash_original_method = "322B645C7F09570DF98848B1C3D767D8", hash_generated_method = "CE87A795A23024C1C7EA46F00EFF7405")
    private void downloadStart(String url, String userAgent,
            String contentDisposition, String mimeType, long contentLength) {
        {
            boolean var44872427025E393BE432C3478708F3FD_924656783 = (mimeType.isEmpty());
            {
                try 
                {
                    String extension;
                    extension = url.substring(url.lastIndexOf('.') + 1);
                    mimeType = libcore.net.MimeUtils.guessMimeTypeFromExtension(extension);
                    mimeType = "";
                } //End block
                catch (IndexOutOfBoundsException exception)
                { }
            } //End block
        } //End collapsed parenthetic
        mimeType = MimeTypeMap.getSingleton().remapGenericMimeType(
                mimeType, url, contentDisposition);
        {
            boolean var4B3BED1078E8417BFF574BC05F74B45C_1951547178 = (CertTool.getCertType(mimeType) != null);
            {
                mKeyStoreHandler = new KeyStoreHandler(mimeType);
            } //End block
            {
                mCallbackProxy.onDownloadStart(url, userAgent,
                contentDisposition, mimeType, contentLength);
            } //End block
        } //End collapsed parenthetic
        addTaint(url.getTaint());
        addTaint(userAgent.getTaint());
        addTaint(contentDisposition.getTaint());
        addTaint(contentLength);
        // ---------- Original Method ----------
        //if (mimeType.isEmpty()) {
            //try {
                //String extension = url.substring(url.lastIndexOf('.') + 1);
                //mimeType = libcore.net.MimeUtils.guessMimeTypeFromExtension(extension);
                //if (mimeType == null)
                    //mimeType = "";
            //} catch(IndexOutOfBoundsException exception) {
            //}
        //}
        //mimeType = MimeTypeMap.getSingleton().remapGenericMimeType(
                //mimeType, url, contentDisposition);
        //if (CertTool.getCertType(mimeType) != null) {
            //mKeyStoreHandler = new KeyStoreHandler(mimeType);
        //} else {
            //mCallbackProxy.onDownloadStart(url, userAgent,
                //contentDisposition, mimeType, contentLength);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.647 -0400", hash_original_method = "BAE8CD84EA4D59BD4BB7CAF15EB1C07F", hash_generated_method = "FE3C00D2DBD6D2F8DDFCD87E8A2B2C7C")
    private void didReceiveData(byte data[], int size) {
        mKeyStoreHandler.didReceiveData(data, size);
        addTaint(data);
        addTaint(size);
        // ---------- Original Method ----------
        //if (mKeyStoreHandler != null) mKeyStoreHandler.didReceiveData(data, size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.660 -0400", hash_original_method = "5EC89579D3745ABD19569589FBBBCA81", hash_generated_method = "B454CCBDA172FF40AB0FF66C63354298")
    private void didFinishLoading() {
        {
            mKeyStoreHandler.installCert(mContext);
            mKeyStoreHandler = null;
        } //End block
        // ---------- Original Method ----------
        //if (mKeyStoreHandler != null) {
          //mKeyStoreHandler.installCert(mContext);
          //mKeyStoreHandler = null;
      //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.660 -0400", hash_original_method = "A2E04BD398BDF0F096F042D99402CC27", hash_generated_method = "9F2511EA049336B38989490948CE53C2")
    private void setCertificate(byte cert_der[]) {
        try 
        {
            X509Certificate cert;
            cert = new X509CertImpl(cert_der);
            mCallbackProxy.onReceivedCertificate(new SslCertificate(cert));
        } //End block
        catch (IOException e)
        { }
        addTaint(cert_der);
        // ---------- Original Method ----------
        //try {
            //X509Certificate cert = new X509CertImpl(cert_der);
            //mCallbackProxy.onReceivedCertificate(new SslCertificate(cert));
        //} catch (IOException e) {
            //Log.e(LOGTAG, "Can't get the certificate from WebKit, canceling");
            //return;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.661 -0400", hash_original_method = "780A48AF1DFDDD134926E1881FBB7981", hash_generated_method = "71FD360305D2E95BD7B282CDC1BC76DE")
     SearchBox getSearchBox() {
        SearchBox varB4EAC82CA7396A68D541C85D26508E83_1539395659 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1539395659 = mSearchBox;
        varB4EAC82CA7396A68D541C85D26508E83_1539395659.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1539395659;
        // ---------- Original Method ----------
        //return mSearchBox;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.661 -0400", hash_original_method = "957E1FEE267AF2EB4B4A609321166001", hash_generated_method = "C6F9E370D1FAA1C6CA521D0AEC1F5DEC")
    private void autoLogin(String realm, String account, String args) {
        mCallbackProxy.onReceivedLoginRequest(realm, account, args);
        addTaint(realm.getTaint());
        addTaint(account.getTaint());
        addTaint(args.getTaint());
        // ---------- Original Method ----------
        //mCallbackProxy.onReceivedLoginRequest(realm, account, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.661 -0400", hash_original_method = "CAC5AC041AD65DE746A86B06B460473E", hash_generated_method = "8EFAC8AB4511B7E165DA50794474A8A3")
    private void nativeCreateFrame(WebViewCore w, AssetManager am,
            WebBackForwardList list) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.661 -0400", hash_original_method = "74AC0793AA670585A51BA4B2FC045561", hash_generated_method = "D0819FF5A9F51FEE8FA89D4F258032D7")
    public void nativeDestroyFrame() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.662 -0400", hash_original_method = "7D705910310ED484283730AFB821A717", hash_generated_method = "77CB7497C6503548A49DEF56D571505E")
    private void nativeCallPolicyFunction(int policyFunction,
            int decision) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.662 -0400", hash_original_method = "AE07D7138DB6945AA08789E90E80B92B", hash_generated_method = "030179C599C6C6C95E46270EA13653EF")
    public void reload(boolean allowStale) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.662 -0400", hash_original_method = "53A1F9C2A72688D9CD2F75BB7D3D5005", hash_generated_method = "CECBA3DCC4E2FD2E5ECF03EAC541C67B")
    private void nativeGoBackOrForward(int steps) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.662 -0400", hash_original_method = "F143225F39CB01C1D802EC565271C419", hash_generated_method = "29BBC25C86CDC16E4793C63D3F6022F4")
    public String stringByEvaluatingJavaScriptFromString(String script) {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.663 -0400", hash_original_method = "1BC95C43CEE0FFE1F6217DA26B59C5B9", hash_generated_method = "56AF48B8BD61F2A35430BDF6E249DFBB")
    private void nativeAddJavascriptInterface(int nativeFramePointer,
            Object obj, String interfaceName) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.663 -0400", hash_original_method = "B177754AEEE092C53184C415EE8118E6", hash_generated_method = "47094B89B018B5DFA4A910C06D3DA460")
    private void setCacheDisabled(boolean disabled) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.663 -0400", hash_original_method = "8B7AAFA05BB3F3ED8C594AA78F708D08", hash_generated_method = "498163ECE391EE2808EB3D909FADFC0A")
    public boolean cacheDisabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2106035938 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2106035938;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.663 -0400", hash_original_method = "055468486DD4D3FA9B64A316B50FA6FA", hash_generated_method = "09DFDA49097E0044F1CB77E2DA83386B")
    public void clearCache() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.677 -0400", hash_original_method = "6C44E95231996B5164D16D96A5AF9CAD", hash_generated_method = "F293DD4C3989DC497C60C424BC165890")
    private void nativeLoadUrl(String url, Map<String, String> headers) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.677 -0400", hash_original_method = "4DAAE38A658B1BBD069DC4A366A0C462", hash_generated_method = "7AFC02E483AE7F6035BE6C4076387ECA")
    private void nativePostUrl(String url, byte[] postData) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.677 -0400", hash_original_method = "8945167C96AD091C5C39DEC108C4839D", hash_generated_method = "84C5E27EED63249939FC5099014E7452")
    private void nativeLoadData(String baseUrl, String data,
            String mimeType, String encoding, String historyUrl) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.678 -0400", hash_original_method = "A939F96E349A2DAAC3BA975E2507007D", hash_generated_method = "A20ED99BC6ADB1A37D77ED3EC6142CBA")
    public void stopLoading() {
        {
            resetLoadingStates();
        } //End block
        nativeStopLoading();
        // ---------- Original Method ----------
        //if (mIsMainFrame) {
            //resetLoadingStates();
        //}
        //nativeStopLoading();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.678 -0400", hash_original_method = "64AB65E4A9095F9BBCDCF9CF6CF9A5F6", hash_generated_method = "863930E14611E1ACA6714E4256C8BCDF")
    private void nativeStopLoading() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.678 -0400", hash_original_method = "9D75E2E2AB8D83EF2AA67EF8FE72195D", hash_generated_method = "F5D38A4E6305F74EDC414F87387B9C60")
    public boolean documentHasImages() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_24932347 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_24932347;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.678 -0400", hash_original_method = "10318A015094FE1A39B49B3070F280C0", hash_generated_method = "9AA4C64A8447139D54F712C53A78878A")
    private boolean hasPasswordField() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_969648772 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_969648772;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.679 -0400", hash_original_method = "865B533AFC1748A162575C4402C4E1D7", hash_generated_method = "649B5EB499FF582D6D8E126787969B7F")
    private String[] getUsernamePassword() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.679 -0400", hash_original_method = "2745608D69207B6EE74824552EF70660", hash_generated_method = "1A30370C37C5C66F114998E665F5DE65")
    private void setUsernamePassword(String username, String password) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.680 -0400", hash_original_method = "74581984BB5BC192860C6547F8D5036F", hash_generated_method = "1313694DA1B47EE7DE9BC757D7889251")
    private String nativeSaveWebArchive(String basename, boolean autoname) {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.680 -0400", hash_original_method = "08E54613B59D770C860286634891B8BB", hash_generated_method = "850BDCB5411EE09BBA08F1498E765617")
    private void nativeOrientationChanged(int orientation) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.680 -0400", hash_original_method = "68B2D8AE5CF2C1C845D97B94EDB581CC", hash_generated_method = "9AFA00EEEC77D42FCE75299FE8ECAEF0")
    private void nativeAuthenticationProceed(int handle, String username, String password) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.680 -0400", hash_original_method = "9DEA51422898C7E38A3DECD149992B9B", hash_generated_method = "24B56D25B8D4C69BCC49A3029D0425ED")
    private void nativeAuthenticationCancel(int handle) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.681 -0400", hash_original_method = "DFE86F393FFB1B33336576462A995D77", hash_generated_method = "1D2385A72CC74EB320478672DDD4F738")
    private void nativeSslCertErrorProceed(int handle) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.681 -0400", hash_original_method = "8A69525C805CE3B5326B3888FD841CA0", hash_generated_method = "0210D16961B93CFA3B6CC1A9AA6C2FFF")
    private void nativeSslCertErrorCancel(int handle, int certError) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.681 -0400", hash_original_method = "81F222D4FD7D3F4B597DBD7F9BD0D106", hash_generated_method = "9F314486FB3D8DB453A1ECAAFCC05CF8")
     void nativeSslClientCert(int handle,
                                    byte[] pkcs8EncodedPrivateKey,
                                    byte[][] asn1DerEncodedCertificateChain) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.685 -0400", hash_original_method = "154F1DF98163CFE18EB2585F133E4CD5", hash_generated_method = "CA49CE4368D585978DD8DC5385D243FD")
     boolean getShouldStartScrolledRight() {
        boolean var335C30460623592B55D35997E929AE78_33498047 = (nativeGetShouldStartScrolledRight(mNativeFrame));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_345285602 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_345285602;
        // ---------- Original Method ----------
        //return nativeGetShouldStartScrolledRight(mNativeFrame);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.686 -0400", hash_original_method = "F95D370518D151DA0A0757957627AE19", hash_generated_method = "D64B92CB2FACAAF0122823B81C40ADD4")
    private boolean nativeGetShouldStartScrolledRight(int nativeBrowserFrame) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1493242273 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1493242273;
    }

    
    private static class ConfigCallback implements ComponentCallbacks {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.686 -0400", hash_original_field = "3F69F22C406833C0C756A90F1331AB00", hash_generated_field = "9FBDE0090F668B66E923BB76706C0274")

        private ArrayList<WeakReference<Handler>> mHandlers = new ArrayList<WeakReference<Handler>>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.686 -0400", hash_original_field = "306519E50E3A91B9733D09F5D8EB985C", hash_generated_field = "3C750A4AE06B71AF3A05B7797C7182A4")

        private WindowManager mWindowManager;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.686 -0400", hash_original_method = "049F58B9ED595813037671BB1DAC0333", hash_generated_method = "0990D6314CA4E2ACF77F7549B870C8E3")
          ConfigCallback(WindowManager wm) {
            mWindowManager = wm;
            // ---------- Original Method ----------
            //mWindowManager = wm;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.703 -0400", hash_original_method = "3638F495C0637CBBD96B9D8F0DA8CFC2", hash_generated_method = "7474AF23E4F5F92EBF42E1D9D80D6FAE")
        public synchronized void addHandler(Handler h) {
            mHandlers.add(new WeakReference<Handler>(h));
            addTaint(h.getTaint());
            // ---------- Original Method ----------
            //mHandlers.add(new WeakReference<Handler>(h));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.812 -0400", hash_original_method = "2BDCB7974021DF1350762A5BB88607D6", hash_generated_method = "AE4F83A08F44B814D8BEE06B9779C6E5")
        public void onConfigurationChanged(Configuration newConfig) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                boolean var77DE7BD4514F064D49FEE0FA393B405C_1685338464 = (mHandlers.size() == 0);
            } //End collapsed parenthetic
            int orientation;
            orientation = mWindowManager.getDefaultDisplay().getOrientation();
            //Begin case Surface.ROTATION_90 
            orientation = 90;
            //End case Surface.ROTATION_90 
            //Begin case Surface.ROTATION_180 
            orientation = 180;
            //End case Surface.ROTATION_180 
            //Begin case Surface.ROTATION_270 
            orientation = -90;
            //End case Surface.ROTATION_270 
            //Begin case Surface.ROTATION_0 
            orientation = 0;
            //End case Surface.ROTATION_0 
            {
                ArrayList<WeakReference> handlersToRemove;
                handlersToRemove = new ArrayList<WeakReference>(mHandlers.size());
                {
                    Iterator<WeakReference<Handler>> varCECD96480F7943C24B44EAC392B955D4_1018751130 = (mHandlers).iterator();
                    varCECD96480F7943C24B44EAC392B955D4_1018751130.hasNext();
                    WeakReference<Handler> wh = varCECD96480F7943C24B44EAC392B955D4_1018751130.next();
                    {
                        Handler h;
                        h = wh.get();
                        {
                            h.sendMessage(h.obtainMessage(ORIENTATION_CHANGED,
                                    orientation, 0));
                        } //End block
                        {
                            handlersToRemove.add(wh);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                {
                    Iterator<WeakReference> varD1D4DD7CA023B24419A744496E994C66_1423230727 = (handlersToRemove).iterator();
                    varD1D4DD7CA023B24419A744496E994C66_1423230727.hasNext();
                    WeakReference weak = varD1D4DD7CA023B24419A744496E994C66_1423230727.next();
                    {
                        mHandlers.remove(weak);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            addTaint(newConfig.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.813 -0400", hash_original_method = "4F0E380BE715BF5B2ECCDB1794C8905E", hash_generated_method = "39AEB8790734ECC8DC70BBAAEE0BAB0B")
        public void onLowMemory() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            // ---------- Original Method ----------
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.813 -0400", hash_original_field = "9722F24E24D81405093C0E61AAF58518", hash_generated_field = "E56CE2F3E60B73E43C117C0293F7827E")

    private static String LOGTAG = "webkit";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.813 -0400", hash_original_field = "CDFAF77A2FA5EC066BA0E8526D3DF9B6", hash_generated_field = "3469E6A25ECFF689AE0556A6156305B2")

    private static int MAX_OUTSTANDING_REQUESTS = 300;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.813 -0400", hash_original_field = "08264D80E569A896C711C6D06BF1C7FB", hash_generated_field = "EED01861B0D25D69C56836ADD990237F")

    static int FRAME_COMPLETED = 1001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.813 -0400", hash_original_field = "D58FFECC421A99733068B40E1BF3863E", hash_generated_field = "338DC058E56F6F900F98242E964B3DD2")

    static int ORIENTATION_CHANGED = 1002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.813 -0400", hash_original_field = "FE767547E3C3381CD214DBBD311BD589", hash_generated_field = "B48DFF43FA8F879E9D486385DF35EED1")

    static int POLICY_FUNCTION = 1003;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.813 -0400", hash_original_field = "42CA85DD55D979A50F59E8033EAE23DF", hash_generated_field = "61F609BB74D4605C497062FCB44D58BB")

    static int FRAME_LOADTYPE_STANDARD = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.813 -0400", hash_original_field = "69134FE8B8D5C2428E783F32DBD4667A", hash_generated_field = "D8F73B52BF1715C1F76AADCCCCB534C6")

    static int FRAME_LOADTYPE_BACK = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.813 -0400", hash_original_field = "EC9164750C25708474F7809198FB9B0A", hash_generated_field = "290A4850A233E3168ED7D048FA88A22A")

    static int FRAME_LOADTYPE_FORWARD = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.813 -0400", hash_original_field = "8FC4318A9366EC9598B68F0ED5B4321C", hash_generated_field = "B27C3012B92051F6C7E9776ED41E9528")

    static int FRAME_LOADTYPE_INDEXEDBACKFORWARD = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.813 -0400", hash_original_field = "7C337B55EFB5BF129446F63999814543", hash_generated_field = "ABB2B1FF742D951ED0FD72D7A3F1B6BF")

    static int FRAME_LOADTYPE_RELOAD = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.813 -0400", hash_original_field = "E45151A6382EAF3CD93F035386BD43CD", hash_generated_field = "5A850786224607481D1BE6C13AE8670E")

    static int FRAME_LOADTYPE_RELOADALLOWINGSTALEDATA = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.813 -0400", hash_original_field = "5656BBB72E737D2EFBB47A70745C5604", hash_generated_field = "5E82BC48F8861E6A3945B1C5A06EB906")

    static int FRAME_LOADTYPE_SAME = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.813 -0400", hash_original_field = "9EFB3DB1E71EDCE68E26DB4736B8C684", hash_generated_field = "D4E77C1374392B7F6B5199F4D919F98E")

    static int FRAME_LOADTYPE_REDIRECT = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.813 -0400", hash_original_field = "203DA8B32D1C553F34447AEC0A6A6CE2", hash_generated_field = "9231EDB443ECAAC7C5B799B1AA189E55")

    static int FRAME_LOADTYPE_REPLACE = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.813 -0400", hash_original_field = "8B9874510E93C75D2D1860303D1764B7", hash_generated_field = "51833415D33A75A813B2C165CB016230")

    private static int TRANSITION_SWITCH_THRESHOLD = 75;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.813 -0400", hash_original_field = "223854A0F98CC96430A4D417102C6786", hash_generated_field = "D7883F783809ED0F8DBFDDE29B0E7616")

    static JWebCoreJavaBridge sJavaBridge;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.813 -0400", hash_original_field = "F19C3882056A46D6E38929CE3312949C", hash_generated_field = "83DD52CDBA28345681C620B41796288C")

    static ConfigCallback sConfigCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.813 -0400", hash_original_field = "ED5999AD6D797AC5AAB7EF962BCC197B", hash_generated_field = "30713D190AD3708723D9B97DDDF29A46")

    static int POLICY_USE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.813 -0400", hash_original_field = "038A012F80070C6D0E2694302C5D96F5", hash_generated_field = "95C3198A8FE658C9AD0E011E8F4A62DE")

    static int POLICY_IGNORE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.813 -0400", hash_original_field = "0C3B665F405199970F23D4818081FB85", hash_generated_field = "E8E9F004BB9569640F1E0592AE50F4C0")

    private static int NODOMAIN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.813 -0400", hash_original_field = "18516BFEE79487E48612E1A5B9E185D7", hash_generated_field = "5B6A8DFEB7335E4AC4AB7DDF87F240DF")

    private static int LOADERROR = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.813 -0400", hash_original_field = "BD435F7DEF7B7217246B2D559271A4CB", hash_generated_field = "730353F2212097C2D1CBDF58D0AE1E9E")

    static int DRAWABLEDIR = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.813 -0400", hash_original_field = "B7C58CFD13E85CE0D36E8ADD993680D5", hash_generated_field = "308A993A3197E18F4EF2F0F0503358B8")

    private static int FILE_UPLOAD_LABEL = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.813 -0400", hash_original_field = "4C76E81D8F8110B8D6F02CF8E99C7BE0", hash_generated_field = "7B09D84F8D1671C86FAE189CE3CBF3CE")

    private static int RESET_LABEL = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.813 -0400", hash_original_field = "4332CE042ECBFC917A5B0C3B6A803F1B", hash_generated_field = "E25867E1C081203F4F4650B025653F86")

    private static int SUBMIT_LABEL = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.813 -0400", hash_original_field = "910631508F84D90DCD807E27D1002B78", hash_generated_field = "4B512D217C12D266165741E3EA56595A")

    private static int FILE_UPLOAD_NO_FILE_CHOSEN = 7;
}

