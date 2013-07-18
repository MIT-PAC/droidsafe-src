package android.webkit;

// Droidsafe Imports
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import junit.framework.Assert;

import org.apache.harmony.security.provider.cert.X509CertImpl;

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
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

class BrowserFrame extends Handler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.285 -0400", hash_original_field = "957B64C4FA99E51BCE1B62690725D115", hash_generated_field = "62789CA10670C708EA4D387AB18C5F89")

    private CallbackProxy mCallbackProxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.285 -0400", hash_original_field = "A5E11DE354AE2FBFC3E5565E23F4F865", hash_generated_field = "D4F7B9B886C1ADC785C82D3DD8AF3DFF")

    private WebSettings mSettings;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.285 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.285 -0400", hash_original_field = "8C0B67E1F99496AB4CD09433C231BEB3", hash_generated_field = "7BDDBEC30F299EE26388591EE1BF8D76")

    private WebViewDatabase mDatabase;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.285 -0400", hash_original_field = "9371E2004CE9EC2E60E3F0EBE8ED2E84", hash_generated_field = "73DACDCC92B5BF8822959B0368CF2255")

    private WebViewCore mWebViewCore;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.286 -0400", hash_original_field = "18C5BDE066D80086E4363915A042058B", hash_generated_field = "B4EA0C57C793BB0B49B6968B7FE9D971")

    boolean mLoadInitFromJava;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.286 -0400", hash_original_field = "01D334B431DA26637B5EF7A829298F7D", hash_generated_field = "C86D106D01922BD5804E6AAE242DA6C3")

    private int mLoadType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.286 -0400", hash_original_field = "18D8FCC50BBFDBCB161CD7DD4E3404BE", hash_generated_field = "776616C56C2E01B1F2BB9B8C0B82CB21")

    private boolean mFirstLayoutDone = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.286 -0400", hash_original_field = "C5E19DCA01BDA9FF5D89D2ACFFE2F12C", hash_generated_field = "EC7856A93088DA99A6DF3A617D2EA4C1")

    private boolean mCommitted = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.286 -0400", hash_original_field = "006072914B84F6CA94E2A188B4C8239F", hash_generated_field = "EFE4830A112EE1BAABB9D028ED0F40E4")

    private boolean mBlockMessages = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.286 -0400", hash_original_field = "9CB1303D307C48F5668E893BEC7E4DA2", hash_generated_field = "9A84F3DDA9738602717ED248C7C54BA0")

    private int mOrientation = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.286 -0400", hash_original_field = "017BEB0E2B69AC773E76EDE517E49275", hash_generated_field = "288919EE03CF52ADC4ECF3BE90DB3FD0")

    private boolean mIsMainFrame;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.286 -0400", hash_original_field = "82B4A5C03B9C8E7AECA4C75B7949A817", hash_generated_field = "6BE2AF2AB55A96D7E8AF44D0319FADE3")

    private Map<String, Object> mJavaScriptObjects;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.286 -0400", hash_original_field = "860BB378791B281E4412623871A3DF71", hash_generated_field = "0CD8E441AD75D857B58751166EA1B830")

    private Set<Object> mRemovedJavaScriptObjects;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.286 -0400", hash_original_field = "AE4C5D15C981FA9DC4C7098F4216875A", hash_generated_field = "6F2547FBE326896235C67C4D21E1AAB0")

    private KeyStoreHandler mKeyStoreHandler = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.286 -0400", hash_original_field = "C2C311879F539529159B9BF820E134A3", hash_generated_field = "4A5DF3233C257C28C1B6F01FDD889A88")

    private SearchBoxImpl mSearchBox;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.286 -0400", hash_original_field = "99D531FFAA7E5CBA866FA026F509CD12", hash_generated_field = "74015A65A56B852D13D3A8DC44ECA23B")

    int mNativeFrame;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.288 -0400", hash_original_method = "0C0B9FED7DBC124A25298101B6DEE56A", hash_generated_method = "8F59F0CA8E75F56A28880E9E52A0EBAB")
    public  BrowserFrame(Context context, WebViewCore w, CallbackProxy proxy,
            WebSettings settings, Map<String, Object> javascriptInterfaces) {
        Context appContext = context.getApplicationContext();
        if(sJavaBridge == null)        
        {
            sJavaBridge = new JWebCoreJavaBridge();
            ActivityManager am = (ActivityManager) context
                    .getSystemService(Context.ACTIVITY_SERVICE);
            if(am.getMemoryClass() > 16)            
            {
                sJavaBridge.setCacheSize(8 * 1024 * 1024);
            } //End block
            else
            {
                sJavaBridge.setCacheSize(4 * 1024 * 1024);
            } //End block
            CacheManager.init(appContext);
            CookieSyncManager.createInstance(appContext);
            PluginManager.getInstance(appContext);
        } //End block
        if(sConfigCallback == null)        
        {
            sConfigCallback = new ConfigCallback(
                    (WindowManager) appContext.getSystemService(
                            Context.WINDOW_SERVICE));
            ViewRootImpl.addConfigCallback(sConfigCallback);
        } //End block
        sConfigCallback.addHandler(this);
        mJavaScriptObjects = javascriptInterfaces;
        if(mJavaScriptObjects == null)        
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
        AssetManager am = context.getAssets();
        nativeCreateFrame(w, am, proxy.getBackForwardList());
        if(DebugFlags.BROWSER_FRAME)        
        {
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.288 -0400", hash_original_method = "056144D27ACF2932EFB0C1980B0D6F98", hash_generated_method = "291B0146B05E4DA49074308B6825D6B4")
    public void loadUrl(String url, Map<String, String> extraHeaders) {
        addTaint(extraHeaders.getTaint());
        addTaint(url.getTaint());
        mLoadInitFromJava = true;
        if(URLUtil.isJavaScriptUrl(url))        
        {
            stringByEvaluatingJavaScriptFromString(
                    url.substring("javascript:".length()));
        } //End block
        else
        {
            nativeLoadUrl(url, extraHeaders);
        } //End block
        mLoadInitFromJava = false;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.289 -0400", hash_original_method = "55F163F814F53ECA11AC218202D49EB2", hash_generated_method = "53E79CDE5C3440BB15AD246809979B5D")
    public void postUrl(String url, byte[] data) {
        addTaint(data[0]);
        addTaint(url.getTaint());
        mLoadInitFromJava = true;
        nativePostUrl(url, data);
        mLoadInitFromJava = false;
        // ---------- Original Method ----------
        //mLoadInitFromJava = true;
        //nativePostUrl(url, data);
        //mLoadInitFromJava = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.289 -0400", hash_original_method = "210E874B3CC8A8754EDB8A64197F3EDD", hash_generated_method = "363D58640EB23ED54125234106665865")
    public void loadData(String baseUrl, String data, String mimeType,
            String encoding, String historyUrl) {
        addTaint(historyUrl.getTaint());
        addTaint(encoding.getTaint());
        addTaint(mimeType.getTaint());
        addTaint(data.getTaint());
        addTaint(baseUrl.getTaint());
        mLoadInitFromJava = true;
        if(historyUrl == null || historyUrl.length() == 0)        
        {
            historyUrl = "about:blank";
        } //End block
        if(data == null)        
        {
            data = "";
        } //End block
        if(baseUrl == null || baseUrl.length() == 0)        
        {
            baseUrl = "about:blank";
        } //End block
        if(mimeType == null || mimeType.length() == 0)        
        {
            mimeType = "text/html";
        } //End block
        nativeLoadData(baseUrl, data, mimeType, encoding, historyUrl);
        mLoadInitFromJava = false;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.290 -0400", hash_original_method = "FE36B1316A593126EBA1AA2EF5942205", hash_generated_method = "3B73F14AEC36F5792662E2724C1C670F")
     String saveWebArchive(String basename, boolean autoname) {
        addTaint(autoname);
        addTaint(basename.getTaint());
String var577A52C8E78ECD1A00142262F8742918_1810945317 =         nativeSaveWebArchive(basename, autoname);
        var577A52C8E78ECD1A00142262F8742918_1810945317.addTaint(taint);
        return var577A52C8E78ECD1A00142262F8742918_1810945317;
        // ---------- Original Method ----------
        //return nativeSaveWebArchive(basename, autoname);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.290 -0400", hash_original_method = "4DB46F10EA63A90C886405E235BD3A38", hash_generated_method = "E9253174B2F8808D2EA462908525728D")
    public void goBackOrForward(int steps) {
        addTaint(steps);
        mLoadInitFromJava = true;
        nativeGoBackOrForward(steps);
        mLoadInitFromJava = false;
        // ---------- Original Method ----------
        //mLoadInitFromJava = true;
        //nativeGoBackOrForward(steps);
        //mLoadInitFromJava = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.290 -0400", hash_original_method = "50E452D86A3E55153B3E0F1DD816D615", hash_generated_method = "6A45FFA75B7A4A74754C8E3E1D71B32C")
    private void reportError(int errorCode, String description, String failingUrl) {
        addTaint(failingUrl.getTaint());
        addTaint(description.getTaint());
        addTaint(errorCode);
        resetLoadingStates();
        if(description == null || description.isEmpty())        
        {
            description = ErrorStrings.getString(errorCode, mContext);
        } //End block
        mCallbackProxy.onReceivedError(errorCode, description, failingUrl);
        // ---------- Original Method ----------
        //resetLoadingStates();
        //if (description == null || description.isEmpty()) {
            //description = ErrorStrings.getString(errorCode, mContext);
        //}
        //mCallbackProxy.onReceivedError(errorCode, description, failingUrl);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.291 -0400", hash_original_method = "7B4A87199DD3BC0CC52E5F0CAA9F0064", hash_generated_method = "FA4CC3EB22F179EC946E9ABCED374DF7")
    private void resetLoadingStates() {
        mCommitted = true;
        mFirstLayoutDone = true;
        // ---------- Original Method ----------
        //mCommitted = true;
        //mFirstLayoutDone = true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.291 -0400", hash_original_method = "82C14ED51175F3BAD05958BE30AA9B50", hash_generated_method = "4DE3A34EC91C5D2CD6FDA7F21687C1BE")
     boolean committed() {
        boolean varECB201FF1883B37FDCC5CA9037698543_1587682696 = (mCommitted);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1605701707 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1605701707;
        // ---------- Original Method ----------
        //return mCommitted;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.292 -0400", hash_original_method = "6055F5425C1866007AB953B33770A39A", hash_generated_method = "7D4946188C6EEAFB75F0379993004638")
     boolean firstLayoutDone() {
        boolean varE9932ED3B0EE242D96A89686AEE3CF8E_803182091 = (mFirstLayoutDone);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1967312084 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1967312084;
        // ---------- Original Method ----------
        //return mFirstLayoutDone;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.292 -0400", hash_original_method = "9068063B02257F9D08EFF05D6BD051A9", hash_generated_method = "81350080E53B39FB6DAA6614B825D615")
     int loadType() {
        int var01D334B431DA26637B5EF7A829298F7D_799500689 = (mLoadType);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1945088927 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1945088927;
        // ---------- Original Method ----------
        //return mLoadType;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.292 -0400", hash_original_method = "027FDD69E025CF7A20175D3E84246197", hash_generated_method = "70B68A83AABC8A7B41F6165E8EEA5CF7")
     void didFirstLayout() {
        if(!mFirstLayoutDone)        
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.293 -0400", hash_original_method = "588CB65AC18071EB5B02ABC642CC0A1A", hash_generated_method = "2E65B8E91162D25D2C9C4812078B4317")
    private void loadStarted(String url, Bitmap favicon, int loadType,
            boolean isMainFrame) {
        addTaint(favicon.getTaint());
        addTaint(url.getTaint());
        mIsMainFrame = isMainFrame;
        if(isMainFrame || loadType == FRAME_LOADTYPE_STANDARD)        
        {
            mLoadType = loadType;
            if(isMainFrame)            
            {
                mCallbackProxy.onPageStarted(url, favicon);
                mFirstLayoutDone = false;
                mCommitted = false;
                mWebViewCore.removeMessages(WebViewCore.EventHub.WEBKIT_DRAW);
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.293 -0400", hash_original_method = "C9CC31AE97DBC19619CDCFC15EC7B03E", hash_generated_method = "0459F9BF44F0EE56ED1A1D9C5A359127")
    @SuppressWarnings("unused")
    private void saveFormData(HashMap<String, String> data) {
        addTaint(data.getTaint());
        if(mSettings.getSaveFormData())        
        {
            final WebHistoryItem h = mCallbackProxy.getBackForwardList()
                    .getCurrentItem();
            if(h != null)            
            {
                String url = WebTextView.urlForAutoCompleteData(h.getUrl());
                if(url != null)                
                {
                    mDatabase.setFormData(url, data);
                } //End block
            } //End block
        } //End block
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.294 -0400", hash_original_method = "F4B9AF2B8B6C0B9D0EBAE01BEE4BF775", hash_generated_method = "3EA9202D959471943C1B652BA1113612")
    @SuppressWarnings("unused")
    private boolean shouldSaveFormData() {
        if(mSettings.getSaveFormData())        
        {
            final WebHistoryItem h = mCallbackProxy.getBackForwardList()
                    .getCurrentItem();
            boolean var9DEBCCA28593B5DFE80D435C33EA4BDA_602696542 = (h != null && h.getUrl() != null);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_792099009 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_792099009;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1209244255 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1577672011 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1577672011;
        // ---------- Original Method ----------
        //if (mSettings.getSaveFormData()) {
            //final WebHistoryItem h = mCallbackProxy.getBackForwardList()
                    //.getCurrentItem();
            //return h != null && h.getUrl() != null;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.294 -0400", hash_original_method = "7094DD5A86271DA7E952B216F4C46CCD", hash_generated_method = "42AD5F662BBB07CEC71D111F21811465")
    private void transitionToCommitted(int loadType, boolean isMainFrame) {
        addTaint(isMainFrame);
        addTaint(loadType);
        if(isMainFrame)        
        {
            mCommitted = true;
            mWebViewCore.getWebView().mViewManager.postResetStateAll();
        } //End block
        // ---------- Original Method ----------
        //if (isMainFrame) {
            //mCommitted = true;
            //mWebViewCore.getWebView().mViewManager.postResetStateAll();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.294 -0400", hash_original_method = "5C2FD3A5795EB59386117F9A61E0ADCE", hash_generated_method = "FED647AD94BFD3163E6D9B403ED4562D")
    private void loadFinished(String url, int loadType, boolean isMainFrame) {
        addTaint(isMainFrame);
        addTaint(loadType);
        addTaint(url.getTaint());
        if(isMainFrame || loadType == FRAME_LOADTYPE_STANDARD)        
        {
            if(isMainFrame)            
            {
                resetLoadingStates();
                mCallbackProxy.switchOutDrawHistory();
                mCallbackProxy.onPageFinished(url);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (isMainFrame || loadType == FRAME_LOADTYPE_STANDARD) {
            //if (isMainFrame) {
                //resetLoadingStates();
                //mCallbackProxy.switchOutDrawHistory();
                //mCallbackProxy.onPageFinished(url);
            //}
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.294 -0400", hash_original_method = "D2CB1A360A21716BE59AD0C99E7F7543", hash_generated_method = "D94FE0EF656F50E06418D9F058B70999")
     void certificate(SslCertificate certificate) {
        addTaint(certificate.getTaint());
        if(mIsMainFrame)        
        {
            mCallbackProxy.onReceivedCertificate(certificate);
        } //End block
        // ---------- Original Method ----------
        //if (mIsMainFrame) {
            //mCallbackProxy.onReceivedCertificate(certificate);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.294 -0400", hash_original_method = "FF0F600C92E1745B1B3B7823F85C9072", hash_generated_method = "3C727BDF61EF3EB2B960E985C9E7AA07")
    public void destroy() {
        nativeDestroyFrame();
        mBlockMessages = true;
        removeCallbacksAndMessages(null);
        // ---------- Original Method ----------
        //nativeDestroyFrame();
        //mBlockMessages = true;
        //removeCallbacksAndMessages(null);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.295 -0400", hash_original_method = "08B10BC0FD4D849356EF434C4A57C456", hash_generated_method = "0937123E172E47DD7D9D9837FB417A57")
    @Override
    public void handleMessage(Message msg) {
        if(mBlockMessages)        
        {
            return;
        } //End block
switch(msg.what){
        case FRAME_COMPLETED:
        {
            if(mSettings.getSavePassword() && hasPasswordField())            
            {
                WebHistoryItem item = mCallbackProxy.getBackForwardList()
                            .getCurrentItem();
                if(item != null)                
                {
                    WebAddress uri = new WebAddress(item.getUrl());
                    String schemePlusHost = uri.getScheme() + uri.getHost();
                    String[] up = mDatabase.getUsernamePassword(schemePlusHost);
                    if(up != null && up[0] != null)                    
                    {
                        setUsernamePassword(up[0], up[1]);
                    } //End block
                } //End block
            } //End block
            if(!JniUtil.useChromiumHttpStack())            
            {
                WebViewWorker.getHandler().sendEmptyMessage(
                            WebViewWorker.MSG_TRIM_CACHE);
            } //End block
            break;
        } //End block
        case POLICY_FUNCTION:
        {
            nativeCallPolicyFunction(msg.arg1, msg.arg2);
            break;
        } //End block
        case ORIENTATION_CHANGED:
        {
            if(mOrientation != msg.arg1)            
            {
                mOrientation = msg.arg1;
                nativeOrientationChanged(msg.arg1);
            } //End block
            break;
        } //End block
        default:
        break;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.295 -0400", hash_original_method = "71CD366348BF98805D3BCFC6E13F61B1", hash_generated_method = "BA6008276E1A3344EFF5EF4BB6FDBDDD")
    private void setTitle(String title) {
        addTaint(title.getTaint());
        mCallbackProxy.onReceivedTitle(title);
        // ---------- Original Method ----------
        //mCallbackProxy.onReceivedTitle(title);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.295 -0400", hash_original_method = "DC38D0601A6CA8B3CA54AD6CF11C8ED7", hash_generated_method = "00D56D1D2CF0A5217865A490ACC1B7F5")
    public void externalRepresentation(Message callback) {
        addTaint(callback.getTaint());
        callback.obj = externalRepresentation();
        ;
        callback.sendToTarget();
        // ---------- Original Method ----------
        //callback.obj = externalRepresentation();
        //;
        //callback.sendToTarget();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.717 -0400", hash_original_method = "818D4287AF55B155FD9BEC63FC9BB14D", hash_generated_method = "2CE36722D89C9AAE233D32794227C266")
    private String externalRepresentation() {
    	String s = new String();
    	s.addTaint(taint);
    	return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.295 -0400", hash_original_method = "769B7E21D870172A915EE6F0EB6B2D2C", hash_generated_method = "B12B908FCAC267BD3EA1A3138A6115A6")
    public void documentAsText(Message callback) {
        addTaint(callback.getTaint());
        StringBuilder text = new StringBuilder();
        if(callback.arg1 != 0)        
        {
            text.append(documentAsText());
        } //End block
        if(callback.arg2 != 0)        
        {
            text.append(childFramesAsText());
        } //End block
        callback.obj = text.toString();
        callback.sendToTarget();
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.295 -0400", hash_original_method = "7D1B04AB7A647E05019AB7BC865C3803", hash_generated_method = "B315907147C1C1EAE867284FDBD289DA")
    private void windowObjectCleared(int nativeFramePointer) {
        addTaint(nativeFramePointer);
        Iterator<String> iter = mJavaScriptObjects.keySet().iterator();
        while
(iter.hasNext())        
        {
            String interfaceName = iter.next();
            Object object = mJavaScriptObjects.get(interfaceName);
            if(object != null)            
            {
                nativeAddJavascriptInterface(nativeFramePointer,
                        mJavaScriptObjects.get(interfaceName), interfaceName);
            } //End block
        } //End block
        mRemovedJavaScriptObjects.clear();
        stringByEvaluatingJavaScriptFromString(SearchBoxImpl.JS_BRIDGE);
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.296 -0400", hash_original_method = "2FB67C52CD526BE2C970DC0DB75D361F", hash_generated_method = "9DD093FFCBC6C94A04A4E205B430A7B6")
    public boolean handleUrl(String url) {
        addTaint(url.getTaint());
        if(mLoadInitFromJava == true)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1435754780 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1684504294 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1684504294;
        } //End block
        if(mCallbackProxy.shouldOverrideUrlLoading(url))        
        {
            didFirstLayout();
            boolean varB326B5062B2F0E69046810717534CB09_1548490792 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2027746057 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2027746057;
        } //End block
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_613670071 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1147661295 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1147661295;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.296 -0400", hash_original_method = "8112D6E9F2629FDD519CF9C502DF963B", hash_generated_method = "7ECCA4A769B27BD58BA453C5E85BEED3")
    public void addJavascriptInterface(Object obj, String interfaceName) {
        addTaint(interfaceName.getTaint());
        addTaint(obj.getTaint());
        removeJavascriptInterface(interfaceName);
        mJavaScriptObjects.put(interfaceName, obj);
        // ---------- Original Method ----------
        //assert obj != null;
        //removeJavascriptInterface(interfaceName);
        //mJavaScriptObjects.put(interfaceName, obj);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.296 -0400", hash_original_method = "D4D979316C36EF31BC47A23AC0C9BE50", hash_generated_method = "42318119BF8387797E10506DFF2DE37D")
    public void removeJavascriptInterface(String interfaceName) {
        addTaint(interfaceName.getTaint());
        if(mJavaScriptObjects.containsKey(interfaceName))        
        {
            mRemovedJavaScriptObjects.add(mJavaScriptObjects.remove(interfaceName));
        } //End block
        // ---------- Original Method ----------
        //if (mJavaScriptObjects.containsKey(interfaceName)) {
            //mRemovedJavaScriptObjects.add(mJavaScriptObjects.remove(interfaceName));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.296 -0400", hash_original_method = "DF8E19ADC1C4D892E5E9E24D72F873C3", hash_generated_method = "31B542C0BA330CDDB3A8E010FD4A6582")
    private int getFileSize(String uri) {
        addTaint(uri.getTaint());
        int size = 0;
        try 
        {
            InputStream stream = mContext.getContentResolver()
                            .openInputStream(Uri.parse(uri));
            size = stream.available();
            stream.close();
        } //End block
        catch (Exception e)
        {
        } //End block
        int varF7BD60B75B29D79B660A2859395C1A24_1526484179 = (size);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1734791534 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1734791534;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.296 -0400", hash_original_method = "D65A9387A3FB37FCB544A79FFB5606B6", hash_generated_method = "FF21175B6F104F943E1F3D3060386E66")
    private int getFile(String uri, byte[] buffer, int offset,
            int expectedSize) {
        addTaint(expectedSize);
        addTaint(offset);
        addTaint(buffer[0]);
        addTaint(uri.getTaint());
        int size = 0;
        try 
        {
            InputStream stream = mContext.getContentResolver()
                            .openInputStream(Uri.parse(uri));
            size = stream.available();
            if(size <= expectedSize && buffer != null
                    && buffer.length - offset >= size)            
            {
                stream.read(buffer, offset, size);
            } //End block
            else
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
        int varF7BD60B75B29D79B660A2859395C1A24_1653814608 = (size);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_427981221 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_427981221;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.297 -0400", hash_original_method = "60CA323AEDF7C276FF8B65BEFBD4FA69", hash_generated_method = "7D89BCA3D4AB00A29B991E0D9B7AA4A5")
    private InputStream inputStreamForAndroidResource(String url) {
        addTaint(url.getTaint());
        final String ANDROID_ASSET = "file:///android_asset/";
        final String ANDROID_RESOURCE = "file:///android_res/";
        final String ANDROID_CONTENT = "content:";
        if(url.startsWith(ANDROID_RESOURCE))        
        {
            url = url.replaceFirst(ANDROID_RESOURCE, "");
            if(url == null || url.length() == 0)            
            {
InputStream var540C13E9E156B687226421B24F2DF178_1805354417 =                 null;
                var540C13E9E156B687226421B24F2DF178_1805354417.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1805354417;
            } //End block
            int slash = url.indexOf('/');
            int dot = url.indexOf('.', slash);
            if(slash == -1 || dot == -1)            
            {
InputStream var540C13E9E156B687226421B24F2DF178_516075261 =                 null;
                var540C13E9E156B687226421B24F2DF178_516075261.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_516075261;
            } //End block
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
                if(value.type == TypedValue.TYPE_STRING)                
                {
InputStream varC78BFCF12FBFA3227A0197E64EC01945_850987104 =                     mContext.getAssets().openNonAsset(
                            value.assetCookie, value.string.toString(),
                            AssetManager.ACCESS_STREAMING);
                    varC78BFCF12FBFA3227A0197E64EC01945_850987104.addTaint(taint);
                    return varC78BFCF12FBFA3227A0197E64EC01945_850987104;
                } //End block
                else
                {
InputStream var540C13E9E156B687226421B24F2DF178_345571007 =                     null;
                    var540C13E9E156B687226421B24F2DF178_345571007.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_345571007;
                } //End block
            } //End block
            catch (Exception e)
            {
InputStream var540C13E9E156B687226421B24F2DF178_1844221166 =                 null;
                var540C13E9E156B687226421B24F2DF178_1844221166.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1844221166;
            } //End block
        } //End block
        else
        if(url.startsWith(ANDROID_ASSET))        
        {
            url = url.replaceFirst(ANDROID_ASSET, "");
            try 
            {
                AssetManager assets = mContext.getAssets();
InputStream var6EC0EF420A631EB21F555D908B217CE1_2052547921 =                 assets.open(url, AssetManager.ACCESS_STREAMING);
                var6EC0EF420A631EB21F555D908B217CE1_2052547921.addTaint(taint);
                return var6EC0EF420A631EB21F555D908B217CE1_2052547921;
            } //End block
            catch (IOException e)
            {
InputStream var540C13E9E156B687226421B24F2DF178_1943533256 =                 null;
                var540C13E9E156B687226421B24F2DF178_1943533256.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1943533256;
            } //End block
        } //End block
        else
        if(mSettings.getAllowContentAccess() &&
                   url.startsWith(ANDROID_CONTENT))        
        {
            try 
            {
                int mimeIndex = url.lastIndexOf('?');
                if(mimeIndex != -1)                
                {
                    url = url.substring(0, mimeIndex);
                } //End block
                Uri uri = Uri.parse(url);
InputStream varD596734B53E0C27C52F1BA3951A39E00_86716833 =                 mContext.getContentResolver().openInputStream(uri);
                varD596734B53E0C27C52F1BA3951A39E00_86716833.addTaint(taint);
                return varD596734B53E0C27C52F1BA3951A39E00_86716833;
            } //End block
            catch (Exception e)
            {
InputStream var540C13E9E156B687226421B24F2DF178_1487990529 =                 null;
                var540C13E9E156B687226421B24F2DF178_1487990529.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1487990529;
            } //End block
        } //End block
        else
        {
InputStream var540C13E9E156B687226421B24F2DF178_1855706854 =             null;
            var540C13E9E156B687226421B24F2DF178_1855706854.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1855706854;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.298 -0400", hash_original_method = "DEA49E30923C6B4E17F9FB446E1784D4", hash_generated_method = "9927C9B49CA5E5EF6B20077713A760B2")
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
        addTaint(password.getTaint());
        addTaint(username.getTaint());
        addTaint(synchronous);
        addTaint(userGesture);
        addTaint(mainResource);
        addTaint(cacheMode);
        addTaint(postDataIdentifier);
        addTaint(postData[0]);
        addTaint(headers.getTaint());
        addTaint(method.getTaint());
        addTaint(url.getTaint());
        addTaint(loaderHandle);
        if(mSettings.getCacheMode() != WebSettings.LOAD_DEFAULT)        
        {
            cacheMode = mSettings.getCacheMode();
        } //End block
        if(method.equals("POST"))        
        {
            if(cacheMode == WebSettings.LOAD_NORMAL)            
            {
                cacheMode = WebSettings.LOAD_NO_CACHE;
            } //End block
            String[] ret = getUsernamePassword();
            if(ret != null)            
            {
                String domUsername = ret[0];
                String domPassword = ret[1];
                maybeSavePassword(postData, domUsername, domPassword);
            } //End block
        } //End block
        boolean isMainFramePage = mIsMainFrame;
        if(DebugFlags.BROWSER_FRAME)        
        {
        } //End block
        LoadListener loadListener = LoadListener.getLoadListener(mContext,
                this, url, loaderHandle, synchronous, isMainFramePage,
                mainResource, userGesture, postDataIdentifier, username, password);
        if(LoadListener.getNativeLoaderCount() > MAX_OUTSTANDING_REQUESTS)        
        {
            loadListener.error(
                    android.net.http.EventHandler.ERROR, mContext.getString(
                            com.android.internal.R.string.httpErrorTooManyRequests));
LoadListener var443C5F621F5A64D8BC9FEC8FD919FC40_1232979518 =             loadListener;
            var443C5F621F5A64D8BC9FEC8FD919FC40_1232979518.addTaint(taint);
            return var443C5F621F5A64D8BC9FEC8FD919FC40_1232979518;
        } //End block
        FrameLoader loader = new FrameLoader(loadListener, mSettings, method,
                mCallbackProxy.shouldInterceptRequest(url));
        loader.setHeaders(headers);
        loader.setPostData(postData);
        loader.setCacheMode(headers.containsKey("If-Modified-Since")
                || headers.containsKey("If-None-Match") ? 
                        WebSettings.LOAD_NO_CACHE : cacheMode);
LoadListener varAA77A99C5C414317F827FC325B86977B_1354661431 =         !synchronous ? loadListener : null;
        varAA77A99C5C414317F827FC325B86977B_1354661431.addTaint(taint);
        return varAA77A99C5C414317F827FC325B86977B_1354661431;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.298 -0400", hash_original_method = "69B43B2B2D64063203E22417AF1B4FBE", hash_generated_method = "FE11F6942926BC79EC5A5DB1D909DC8B")
    private void maybeSavePassword(
            byte[] postData, String username, String password) {
        addTaint(password.getTaint());
        addTaint(username.getTaint());
        addTaint(postData[0]);
        if(postData == null
                || username == null || username.isEmpty()
                || password == null || password.isEmpty())        
        {
            return;
        } //End block
        if(!mSettings.getSavePassword())        
        {
            return;
        } //End block
        try 
        {
            if(DebugFlags.BROWSER_FRAME)            
            {
                Assert.assertNotNull(mCallbackProxy.getBackForwardList()
                        .getCurrentItem());
            } //End block
            WebAddress uri = new WebAddress(mCallbackProxy
                    .getBackForwardList().getCurrentItem().getUrl());
            String schemePlusHost = uri.getScheme() + uri.getHost();
            String postString = new String(postData);
            if(postString.contains(URLEncoder.encode(username)) &&
                    postString.contains(URLEncoder.encode(password)))            
            {
                String[] saved = mDatabase.getUsernamePassword(
                        schemePlusHost);
                if(saved != null)                
                {
                    if(saved[0] != null)                    
                    {
                        mDatabase.setUsernamePassword(
                                schemePlusHost, username, password);
                    } //End block
                } //End block
                else
                {
                    mCallbackProxy.onSavePassword(schemePlusHost, username,
                            password, null);
                } //End block
            } //End block
        } //End block
        catch (ParseException ex)
        {
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.298 -0400", hash_original_method = "DD9E58924AE2FD70E5FF51B9D61BCBED", hash_generated_method = "D039AB6F1350975EE0B5FC1F2D24991D")
    private WebResourceResponse shouldInterceptRequest(String url) {
        addTaint(url.getTaint());
        InputStream androidResource = inputStreamForAndroidResource(url);
        if(androidResource != null)        
        {
WebResourceResponse varC17E0FBF3891CF0435C2E90C4F781B5C_679066897 =             new WebResourceResponse(null, null, androidResource);
            varC17E0FBF3891CF0435C2E90C4F781B5C_679066897.addTaint(taint);
            return varC17E0FBF3891CF0435C2E90C4F781B5C_679066897;
        } //End block
        WebResourceResponse response = mCallbackProxy.shouldInterceptRequest(url);
        if(response == null && "browser:incognito".equals(url))        
        {
            try 
            {
                Resources res = mContext.getResources();
                InputStream ins = res.openRawResource(
                        com.android.internal.R.raw.incognito_mode_start_page);
                response = new WebResourceResponse("text/html", "utf8", ins);
            } //End block
            catch (NotFoundException ex)
            {
            } //End block
        } //End block
WebResourceResponse var2A1114F4272D753FE23A36E3D68CD293_78470257 =         response;
        var2A1114F4272D753FE23A36E3D68CD293_78470257.addTaint(taint);
        return var2A1114F4272D753FE23A36E3D68CD293_78470257;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.298 -0400", hash_original_method = "07700DAB8245AC940D55DCEF1A17B102", hash_generated_method = "A99DDA039B6F5F956DE906A1EC00DD4E")
    private void setProgress(int newProgress) {
        addTaint(newProgress);
        mCallbackProxy.onProgressChanged(newProgress);
        if(newProgress == 100)        
        {
            sendMessageDelayed(obtainMessage(FRAME_COMPLETED), 100);
        } //End block
        if(mFirstLayoutDone && newProgress > TRANSITION_SWITCH_THRESHOLD)        
        {
            mCallbackProxy.switchOutDrawHistory();
        } //End block
        // ---------- Original Method ----------
        //mCallbackProxy.onProgressChanged(newProgress);
        //if (newProgress == 100) {
            //sendMessageDelayed(obtainMessage(FRAME_COMPLETED), 100);
        //}
        //if (mFirstLayoutDone && newProgress > TRANSITION_SWITCH_THRESHOLD) {
            //mCallbackProxy.switchOutDrawHistory();
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.299 -0400", hash_original_method = "910C3A78FCE0B1E574FD9CA74D1EE7A9", hash_generated_method = "B0B490D0BDC17825AD37CAE5075B809E")
    private void didReceiveIcon(Bitmap icon) {
        addTaint(icon.getTaint());
        mCallbackProxy.onReceivedIcon(icon);
        // ---------- Original Method ----------
        //mCallbackProxy.onReceivedIcon(icon);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.299 -0400", hash_original_method = "F9E26289979EC36BEDC07872BFD387F0", hash_generated_method = "3E44B41BF9AAA9E60ADAAAEC027493E4")
    private void didReceiveTouchIconUrl(String url, boolean precomposed) {
        addTaint(precomposed);
        addTaint(url.getTaint());
        mCallbackProxy.onReceivedTouchIconUrl(url, precomposed);
        // ---------- Original Method ----------
        //mCallbackProxy.onReceivedTouchIconUrl(url, precomposed);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.299 -0400", hash_original_method = "49DBB49355B8BD4E95F5FBA6E171926E", hash_generated_method = "A3BDEE9CE0622BE787244B00BDC07F51")
    private BrowserFrame createWindow(boolean dialog, boolean userGesture) {
        addTaint(userGesture);
        addTaint(dialog);
BrowserFrame var8401B37A9D724FD0969CBF1936487F5E_1290485477 =         mCallbackProxy.createWindow(dialog, userGesture);
        var8401B37A9D724FD0969CBF1936487F5E_1290485477.addTaint(taint);
        return var8401B37A9D724FD0969CBF1936487F5E_1290485477;
        // ---------- Original Method ----------
        //return mCallbackProxy.createWindow(dialog, userGesture);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.299 -0400", hash_original_method = "05E62B842D0E318583ACCB4619923A88", hash_generated_method = "75CF187AC2BCD2C92D428CFCB1D19AF9")
    private void requestFocus() {
        mCallbackProxy.onRequestFocus();
        // ---------- Original Method ----------
        //mCallbackProxy.onRequestFocus();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.299 -0400", hash_original_method = "A6BF5F00A4A45564AACA34EE9DAEC5CF", hash_generated_method = "DC86851CF7AF503FBCA6F3D12D903045")
    private void closeWindow(WebViewCore w) {
        addTaint(w.getTaint());
        mCallbackProxy.onCloseWindow(w.getWebView());
        // ---------- Original Method ----------
        //mCallbackProxy.onCloseWindow(w.getWebView());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.299 -0400", hash_original_method = "53828DFE68036F8E35ADAC562AA427C9", hash_generated_method = "7829A1010EB00F2F5760360CED74EE3D")
    private void decidePolicyForFormResubmission(int policyFunction) {
        addTaint(policyFunction);
        Message dontResend = obtainMessage(POLICY_FUNCTION, policyFunction,
                POLICY_IGNORE);
        Message resend = obtainMessage(POLICY_FUNCTION, policyFunction,
                POLICY_USE);
        mCallbackProxy.onFormResubmission(dontResend, resend);
        // ---------- Original Method ----------
        //Message dontResend = obtainMessage(POLICY_FUNCTION, policyFunction,
                //POLICY_IGNORE);
        //Message resend = obtainMessage(POLICY_FUNCTION, policyFunction,
                //POLICY_USE);
        //mCallbackProxy.onFormResubmission(dontResend, resend);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.299 -0400", hash_original_method = "B19BAB1EEF674556A3A9CC47CD14FB0B", hash_generated_method = "85531AF173CE4890F60DF925A16BAEB4")
    private void updateVisitedHistory(String url, boolean isReload) {
        addTaint(isReload);
        addTaint(url.getTaint());
        mCallbackProxy.doUpdateVisitedHistory(url, isReload);
        // ---------- Original Method ----------
        //mCallbackProxy.doUpdateVisitedHistory(url, isReload);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.299 -0400", hash_original_method = "D3ED977A3BCAC48329E24D7D69689852", hash_generated_method = "0751337B2140FEEEB4194F5E10F1A936")
     CallbackProxy getCallbackProxy() {
CallbackProxy var2EB9D6A50345F28BE7711CCFE90E59AC_314996413 =         mCallbackProxy;
        var2EB9D6A50345F28BE7711CCFE90E59AC_314996413.addTaint(taint);
        return var2EB9D6A50345F28BE7711CCFE90E59AC_314996413;
        // ---------- Original Method ----------
        //return mCallbackProxy;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.299 -0400", hash_original_method = "F09A8DE53C03EAD5D6B2D7442C92246E", hash_generated_method = "14169E184AB054ABF348A5708CFFFA42")
     String getUserAgentString() {
String var0BAA1D2A3FE338F0474DA7205A0542F3_634307353 =         mSettings.getUserAgentString();
        var0BAA1D2A3FE338F0474DA7205A0542F3_634307353.addTaint(taint);
        return var0BAA1D2A3FE338F0474DA7205A0542F3_634307353;
        // ---------- Original Method ----------
        //return mSettings.getUserAgentString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.299 -0400", hash_original_method = "D14466E1FBBBA5A0DDC9A63472126D93", hash_generated_method = "E9E9B4D0348E4FE86B357C12AD26A0EA")
    private String getRawResFilename(int id) {
        addTaint(id);
String varF3DAD022EBABA935DC888B174E45C206_1407681354 =         getRawResFilename(id, mContext);
        varF3DAD022EBABA935DC888B174E45C206_1407681354.addTaint(taint);
        return varF3DAD022EBABA935DC888B174E45C206_1407681354;
        // ---------- Original Method ----------
        //return getRawResFilename(id, mContext);
    }

    
    @DSModeled(DSC.SPEC)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.300 -0400", hash_original_method = "E4DD03CAE364FD517B782C57726FD370", hash_generated_method = "A28A579199C3AB0F44B6FBEC2156A5D2")
    private float density() {
        float var07D4970463BE718813680AE9698FFB41_571387731 = (mContext.getResources().getDisplayMetrics().density);
                float var546ADE640B6EDFBC8A086EF31347E768_259882308 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_259882308;
        // ---------- Original Method ----------
        //return mContext.getResources().getDisplayMetrics().density;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.300 -0400", hash_original_method = "468A4DE23411D07F152B7955301757EE", hash_generated_method = "EF6FBD3E66E53A2039127B1AC512D427")
    private void didReceiveAuthenticationChallenge(
            final int handle, String host, String realm, final boolean useCachedCredentials,
            final boolean suppressDialog) {
        addTaint(suppressDialog);
        addTaint(useCachedCredentials);
        addTaint(realm.getTaint());
        addTaint(host.getTaint());
        addTaint(handle);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.044 -0400", hash_original_method = "BF59E951CBFF79EB5A7A07D0C7840C24", hash_generated_method = "56CA8B86B76D265AAC63B7DA59AFC465")
    private void reportSslCertError(final int handle, final int certError, byte certDER[],
            String url) {
        addTaint(url.getTaint());
        addTaint(certDER[0]);
        addTaint(certError);
        addTaint(handle);
        final SslError sslError;
        try 
        {
            X509Certificate cert = new X509CertImpl(certDER);
            SslCertificate sslCert = new SslCertificate(cert);
            sslError = SslError.SslErrorFromChromiumErrorCode(certError, sslCert, url);
        } //End block
        catch (IOException e)
        {
            nativeSslCertErrorCancel(handle, certError);
            return;
        } //End block
    if(SslCertLookupTable.getInstance().isAllowed(sslError))        
        {
            nativeSslCertErrorProceed(handle);
            mCallbackProxy.onProceededAfterSslError(sslError);
            return;
        } //End block
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.300 -0400", hash_original_method = "DFA7C324E28D10E855E86AE4BB5B7562", hash_generated_method = "524262539B7E53B7EF9B3A4E1A64DC62")
    private void requestClientCert(int handle, String hostAndPort) {
        addTaint(hostAndPort.getTaint());
        addTaint(handle);
        SslClientCertLookupTable table = SslClientCertLookupTable.getInstance();
        if(table.IsAllowed(hostAndPort))        
        {
            nativeSslClientCert(handle,
                                table.PrivateKey(hostAndPort),
                                table.CertificateChain(hostAndPort));
        } //End block
        else
        if(table.IsDenied(hostAndPort))        
        {
            nativeSslClientCert(handle, null, null);
        } //End block
        else
        {
            mCallbackProxy.onReceivedClientCertRequest(
                    new ClientCertRequestHandler(this, handle, hostAndPort, table), hostAndPort);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.301 -0400", hash_original_method = "322B645C7F09570DF98848B1C3D767D8", hash_generated_method = "6E825D8925534B5450B0B86FEA335874")
    private void downloadStart(String url, String userAgent,
            String contentDisposition, String mimeType, long contentLength) {
        addTaint(contentLength);
        addTaint(contentDisposition.getTaint());
        addTaint(userAgent.getTaint());
        addTaint(url.getTaint());
        if(mimeType.isEmpty())        
        {
            try 
            {
                String extension = url.substring(url.lastIndexOf('.') + 1);
                mimeType = libcore.net.MimeUtils.guessMimeTypeFromExtension(extension);
                if(mimeType == null)                
                mimeType = "";
            } //End block
            catch (IndexOutOfBoundsException exception)
            {
            } //End block
        } //End block
        mimeType = MimeTypeMap.getSingleton().remapGenericMimeType(
                mimeType, url, contentDisposition);
        if(CertTool.getCertType(mimeType) != null)        
        {
            mKeyStoreHandler = new KeyStoreHandler(mimeType);
        } //End block
        else
        {
            mCallbackProxy.onDownloadStart(url, userAgent,
                contentDisposition, mimeType, contentLength);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.301 -0400", hash_original_method = "BAE8CD84EA4D59BD4BB7CAF15EB1C07F", hash_generated_method = "EFE58B14D755EB6634C43FF69D0814E4")
    private void didReceiveData(byte data[], int size) {
        addTaint(size);
        addTaint(data[0]);
        if(mKeyStoreHandler != null)        
        mKeyStoreHandler.didReceiveData(data, size);
        // ---------- Original Method ----------
        //if (mKeyStoreHandler != null) mKeyStoreHandler.didReceiveData(data, size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.301 -0400", hash_original_method = "5EC89579D3745ABD19569589FBBBCA81", hash_generated_method = "2065A0741D852BF0226C18A5D624FA18")
    private void didFinishLoading() {
        if(mKeyStoreHandler != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.301 -0400", hash_original_method = "A2E04BD398BDF0F096F042D99402CC27", hash_generated_method = "7E32C43468D056E0AF1A3A14E1B7F0AD")
    private void setCertificate(byte cert_der[]) {
        addTaint(cert_der[0]);
        try 
        {
            X509Certificate cert = new X509CertImpl(cert_der);
            mCallbackProxy.onReceivedCertificate(new SslCertificate(cert));
        } //End block
        catch (IOException e)
        {
            return;
        } //End block
        // ---------- Original Method ----------
        //try {
            //X509Certificate cert = new X509CertImpl(cert_der);
            //mCallbackProxy.onReceivedCertificate(new SslCertificate(cert));
        //} catch (IOException e) {
            //Log.e(LOGTAG, "Can't get the certificate from WebKit, canceling");
            //return;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.301 -0400", hash_original_method = "780A48AF1DFDDD134926E1881FBB7981", hash_generated_method = "3BEBC808AEDE25AB5212913D884DEEAA")
     SearchBox getSearchBox() {
SearchBox var1389521C14C0F3148BEF0EC494B180A9_1515375469 =         mSearchBox;
        var1389521C14C0F3148BEF0EC494B180A9_1515375469.addTaint(taint);
        return var1389521C14C0F3148BEF0EC494B180A9_1515375469;
        // ---------- Original Method ----------
        //return mSearchBox;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.301 -0400", hash_original_method = "957E1FEE267AF2EB4B4A609321166001", hash_generated_method = "AC7E8ADE3EE1516B212B87095C0DF40E")
    private void autoLogin(String realm, String account, String args) {
        addTaint(args.getTaint());
        addTaint(account.getTaint());
        addTaint(realm.getTaint());
        mCallbackProxy.onReceivedLoginRequest(realm, account, args);
        // ---------- Original Method ----------
        //mCallbackProxy.onReceivedLoginRequest(realm, account, args);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.301 -0400", hash_original_method = "CAC5AC041AD65DE746A86B06B460473E", hash_generated_method = "8EFAC8AB4511B7E165DA50794474A8A3")
    private void nativeCreateFrame(WebViewCore w, AssetManager am,
            WebBackForwardList list) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.301 -0400", hash_original_method = "74AC0793AA670585A51BA4B2FC045561", hash_generated_method = "D0819FF5A9F51FEE8FA89D4F258032D7")
    public void nativeDestroyFrame() {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.302 -0400", hash_original_method = "7D705910310ED484283730AFB821A717", hash_generated_method = "77CB7497C6503548A49DEF56D571505E")
    private void nativeCallPolicyFunction(int policyFunction,
            int decision) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.302 -0400", hash_original_method = "AE07D7138DB6945AA08789E90E80B92B", hash_generated_method = "030179C599C6C6C95E46270EA13653EF")
    public void reload(boolean allowStale) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.302 -0400", hash_original_method = "53A1F9C2A72688D9CD2F75BB7D3D5005", hash_generated_method = "CECBA3DCC4E2FD2E5ECF03EAC541C67B")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.302 -0400", hash_original_method = "1BC95C43CEE0FFE1F6217DA26B59C5B9", hash_generated_method = "56AF48B8BD61F2A35430BDF6E249DFBB")
    private void nativeAddJavascriptInterface(int nativeFramePointer,
            Object obj, String interfaceName) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.302 -0400", hash_original_method = "B177754AEEE092C53184C415EE8118E6", hash_generated_method = "47094B89B018B5DFA4A910C06D3DA460")
    private void setCacheDisabled(boolean disabled) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.302 -0400", hash_original_method = "8B7AAFA05BB3F3ED8C594AA78F708D08", hash_generated_method = "F52A8D4CE8906FD3F6857DD4CC3E8A55")
    public boolean cacheDisabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1410432009 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1410432009;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.302 -0400", hash_original_method = "055468486DD4D3FA9B64A316B50FA6FA", hash_generated_method = "09DFDA49097E0044F1CB77E2DA83386B")
    public void clearCache() {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.302 -0400", hash_original_method = "6C44E95231996B5164D16D96A5AF9CAD", hash_generated_method = "F293DD4C3989DC497C60C424BC165890")
    private void nativeLoadUrl(String url, Map<String, String> headers) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.302 -0400", hash_original_method = "4DAAE38A658B1BBD069DC4A366A0C462", hash_generated_method = "7AFC02E483AE7F6035BE6C4076387ECA")
    private void nativePostUrl(String url, byte[] postData) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.302 -0400", hash_original_method = "8945167C96AD091C5C39DEC108C4839D", hash_generated_method = "84C5E27EED63249939FC5099014E7452")
    private void nativeLoadData(String baseUrl, String data,
            String mimeType, String encoding, String historyUrl) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.302 -0400", hash_original_method = "A939F96E349A2DAAC3BA975E2507007D", hash_generated_method = "B137BBF377C1DB52FA021712CD666350")
    public void stopLoading() {
        if(mIsMainFrame)        
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.302 -0400", hash_original_method = "64AB65E4A9095F9BBCDCF9CF6CF9A5F6", hash_generated_method = "863930E14611E1ACA6714E4256C8BCDF")
    private void nativeStopLoading() {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.302 -0400", hash_original_method = "9D75E2E2AB8D83EF2AA67EF8FE72195D", hash_generated_method = "E375E13C63F57E9DD6C7D7288E269BC2")
    public boolean documentHasImages() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1346344800 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1346344800;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.302 -0400", hash_original_method = "10318A015094FE1A39B49B3070F280C0", hash_generated_method = "5C408DE4703C84F098EA7A41DC7D0EB7")
    private boolean hasPasswordField() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1525352875 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1525352875;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.743 -0400", hash_original_method = "865B533AFC1748A162575C4402C4E1D7", hash_generated_method = "649B5EB499FF582D6D8E126787969B7F")
    private String[] getUsernamePassword() {
    	String[] s = new String[1];
    	s.addTaint(taint);
    	return s;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.303 -0400", hash_original_method = "2745608D69207B6EE74824552EF70660", hash_generated_method = "1A30370C37C5C66F114998E665F5DE65")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.303 -0400", hash_original_method = "08E54613B59D770C860286634891B8BB", hash_generated_method = "850BDCB5411EE09BBA08F1498E765617")
    private void nativeOrientationChanged(int orientation) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.303 -0400", hash_original_method = "68B2D8AE5CF2C1C845D97B94EDB581CC", hash_generated_method = "9AFA00EEEC77D42FCE75299FE8ECAEF0")
    private void nativeAuthenticationProceed(int handle, String username, String password) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.303 -0400", hash_original_method = "9DEA51422898C7E38A3DECD149992B9B", hash_generated_method = "24B56D25B8D4C69BCC49A3029D0425ED")
    private void nativeAuthenticationCancel(int handle) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.303 -0400", hash_original_method = "DFE86F393FFB1B33336576462A995D77", hash_generated_method = "1D2385A72CC74EB320478672DDD4F738")
    private void nativeSslCertErrorProceed(int handle) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.303 -0400", hash_original_method = "8A69525C805CE3B5326B3888FD841CA0", hash_generated_method = "0210D16961B93CFA3B6CC1A9AA6C2FFF")
    private void nativeSslCertErrorCancel(int handle, int certError) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.303 -0400", hash_original_method = "81F222D4FD7D3F4B597DBD7F9BD0D106", hash_generated_method = "9F314486FB3D8DB453A1ECAAFCC05CF8")
     void nativeSslClientCert(int handle,
                                    byte[] pkcs8EncodedPrivateKey,
                                    byte[][] asn1DerEncodedCertificateChain) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.303 -0400", hash_original_method = "154F1DF98163CFE18EB2585F133E4CD5", hash_generated_method = "A3A20DACAB5C1145EF7B71CF57819C56")
     boolean getShouldStartScrolledRight() {
        boolean var7FB4B4F6A6E5C7A93190CE945C2F26A4_744329420 = (nativeGetShouldStartScrolledRight(mNativeFrame));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_199306587 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_199306587;
        // ---------- Original Method ----------
        //return nativeGetShouldStartScrolledRight(mNativeFrame);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.304 -0400", hash_original_method = "F95D370518D151DA0A0757957627AE19", hash_generated_method = "E5BBEE0BFB63B8B1992E2E7627E0289E")
    private boolean nativeGetShouldStartScrolledRight(int nativeBrowserFrame) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1842475464 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1842475464;
    }

    
    private static class ConfigCallback implements ComponentCallbacks {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.304 -0400", hash_original_field = "3F69F22C406833C0C756A90F1331AB00", hash_generated_field = "939312DE689389EC63468038A0B3966B")

        private final ArrayList<WeakReference<Handler>> mHandlers = new ArrayList<WeakReference<Handler>>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.304 -0400", hash_original_field = "306519E50E3A91B9733D09F5D8EB985C", hash_generated_field = "3C750A4AE06B71AF3A05B7797C7182A4")

        private WindowManager mWindowManager;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.304 -0400", hash_original_method = "049F58B9ED595813037671BB1DAC0333", hash_generated_method = "0990D6314CA4E2ACF77F7549B870C8E3")
          ConfigCallback(WindowManager wm) {
            mWindowManager = wm;
            // ---------- Original Method ----------
            //mWindowManager = wm;
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.305 -0400", hash_original_method = "3638F495C0637CBBD96B9D8F0DA8CFC2", hash_generated_method = "9874BE612BFD391CAB7FF85466DEDBE9")
        public synchronized void addHandler(Handler h) {
            addTaint(h.getTaint());
            mHandlers.add(new WeakReference<Handler>(h));
            // ---------- Original Method ----------
            //mHandlers.add(new WeakReference<Handler>(h));
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.305 -0400", hash_original_method = "2BDCB7974021DF1350762A5BB88607D6", hash_generated_method = "EA9D4434CA0E68C2A4165F2AED917AD6")
        public void onConfigurationChanged(Configuration newConfig) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(newConfig.getTaint());
            if(mHandlers.size() == 0)            
            {
                return;
            } //End block
            int orientation = mWindowManager.getDefaultDisplay().getOrientation();
switch(orientation){
            case Surface.ROTATION_90:
            orientation = 90;
            break;
            case Surface.ROTATION_180:
            orientation = 180;
            break;
            case Surface.ROTATION_270:
            orientation = -90;
            break;
            case Surface.ROTATION_0:
            orientation = 0;
            break;
            default:
            break;
}            synchronized
(this)            {
                ArrayList<WeakReference> handlersToRemove = new ArrayList<WeakReference>(mHandlers.size());
for(WeakReference<Handler> wh : mHandlers)
                {
                    Handler h = wh.get();
                    if(h != null)                    
                    {
                        h.sendMessage(h.obtainMessage(ORIENTATION_CHANGED,
                                    orientation, 0));
                    } //End block
                    else
                    {
                        handlersToRemove.add(wh);
                    } //End block
                } //End block
for(WeakReference weak : handlersToRemove)
                {
                    mHandlers.remove(weak);
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.305 -0400", hash_original_method = "4F0E380BE715BF5B2ECCDB1794C8905E", hash_generated_method = "39AEB8790734ECC8DC70BBAAEE0BAB0B")
        public void onLowMemory() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            // ---------- Original Method ----------
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.305 -0400", hash_original_field = "9722F24E24D81405093C0E61AAF58518", hash_generated_field = "061362C112C980EB4954480FBAFBE378")

    private static final String LOGTAG = "webkit";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.305 -0400", hash_original_field = "CDFAF77A2FA5EC066BA0E8526D3DF9B6", hash_generated_field = "07C45052F371F817A6E9C7129020689B")

    private final static int MAX_OUTSTANDING_REQUESTS = 300;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.305 -0400", hash_original_field = "08264D80E569A896C711C6D06BF1C7FB", hash_generated_field = "94DDE74C5F4F9A005F48AE56FBE99C46")

    static final int FRAME_COMPLETED = 1001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.305 -0400", hash_original_field = "D58FFECC421A99733068B40E1BF3863E", hash_generated_field = "AF9351C3CDB755F3B9F929001804B228")

    static final int ORIENTATION_CHANGED = 1002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.305 -0400", hash_original_field = "FE767547E3C3381CD214DBBD311BD589", hash_generated_field = "C36A7AE2DF93855D8C17DDD00680C01F")

    static final int POLICY_FUNCTION = 1003;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.305 -0400", hash_original_field = "42CA85DD55D979A50F59E8033EAE23DF", hash_generated_field = "DFF5E87C0D76673051368D90F72B1604")

    static final int FRAME_LOADTYPE_STANDARD = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.305 -0400", hash_original_field = "69134FE8B8D5C2428E783F32DBD4667A", hash_generated_field = "C98CAC212FCE0950CF5C591CBA26F6CC")

    static final int FRAME_LOADTYPE_BACK = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.305 -0400", hash_original_field = "EC9164750C25708474F7809198FB9B0A", hash_generated_field = "D7F18C05A3ED8C1A9A5E43B62A743FF7")

    static final int FRAME_LOADTYPE_FORWARD = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.305 -0400", hash_original_field = "8FC4318A9366EC9598B68F0ED5B4321C", hash_generated_field = "A6DC1C43F9AA0B9E9057D9DF6E190A28")

    static final int FRAME_LOADTYPE_INDEXEDBACKFORWARD = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.305 -0400", hash_original_field = "7C337B55EFB5BF129446F63999814543", hash_generated_field = "648167BCE91CB300141EF0AFB6CD386E")

    static final int FRAME_LOADTYPE_RELOAD = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.305 -0400", hash_original_field = "E45151A6382EAF3CD93F035386BD43CD", hash_generated_field = "562F9B01E203DDE63B327BFF2B1CD946")

    static final int FRAME_LOADTYPE_RELOADALLOWINGSTALEDATA = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.305 -0400", hash_original_field = "5656BBB72E737D2EFBB47A70745C5604", hash_generated_field = "85E2877EDE72029BC342156260E07F32")

    static final int FRAME_LOADTYPE_SAME = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.305 -0400", hash_original_field = "9EFB3DB1E71EDCE68E26DB4736B8C684", hash_generated_field = "7323181853C306D4388E0BF9D6453477")

    static final int FRAME_LOADTYPE_REDIRECT = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.306 -0400", hash_original_field = "203DA8B32D1C553F34447AEC0A6A6CE2", hash_generated_field = "F07767150327DF86E3F5EFA1195635EC")

    static final int FRAME_LOADTYPE_REPLACE = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.306 -0400", hash_original_field = "8B9874510E93C75D2D1860303D1764B7", hash_generated_field = "4F198CADE81901781EF8AE5AB17DB41B")

    private static final int TRANSITION_SWITCH_THRESHOLD = 75;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.306 -0400", hash_original_field = "223854A0F98CC96430A4D417102C6786", hash_generated_field = "D7883F783809ED0F8DBFDDE29B0E7616")

    static JWebCoreJavaBridge sJavaBridge;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.306 -0400", hash_original_field = "F19C3882056A46D6E38929CE3312949C", hash_generated_field = "83DD52CDBA28345681C620B41796288C")

    static ConfigCallback sConfigCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.306 -0400", hash_original_field = "ED5999AD6D797AC5AAB7EF962BCC197B", hash_generated_field = "13740A75EDBFEE6C8A5C3D763C02E3C3")

    static final int POLICY_USE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.306 -0400", hash_original_field = "038A012F80070C6D0E2694302C5D96F5", hash_generated_field = "2FABA77BC47A5226C38B743147FB61D6")

    static final int POLICY_IGNORE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.306 -0400", hash_original_field = "0C3B665F405199970F23D4818081FB85", hash_generated_field = "3B0BA434BBAF6F143B1004BB592C5D7E")

    private static final int NODOMAIN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.306 -0400", hash_original_field = "18516BFEE79487E48612E1A5B9E185D7", hash_generated_field = "AD9F10F130C2DBFC8F084342E0C12F0A")

    private static final int LOADERROR = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.306 -0400", hash_original_field = "BD435F7DEF7B7217246B2D559271A4CB", hash_generated_field = "F4AD924B573A3AD2500D585C18423161")

    static final int DRAWABLEDIR = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.306 -0400", hash_original_field = "B7C58CFD13E85CE0D36E8ADD993680D5", hash_generated_field = "309D0176BF26B7AC77784E88B4D15E58")

    private static final int FILE_UPLOAD_LABEL = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.306 -0400", hash_original_field = "4C76E81D8F8110B8D6F02CF8E99C7BE0", hash_generated_field = "FD5A9527260C0D4BB974D71092CE0CA5")

    private static final int RESET_LABEL = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.306 -0400", hash_original_field = "4332CE042ECBFC917A5B0C3B6A803F1B", hash_generated_field = "C4DC7FB1DE12FCB7898E3269E9F8A2BA")

    private static final int SUBMIT_LABEL = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.306 -0400", hash_original_field = "910631508F84D90DCD807E27D1002B78", hash_generated_field = "AD5F5EC77DEB8EB516DC019450BAA732")

    private static final int FILE_UPLOAD_NO_FILE_CHOSEN = 7;
}

