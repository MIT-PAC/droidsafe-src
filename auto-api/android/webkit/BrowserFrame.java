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
    private CallbackProxy mCallbackProxy;
    private WebSettings mSettings;
    private Context mContext;
    private WebViewDatabase mDatabase;
    private WebViewCore mWebViewCore;
    boolean mLoadInitFromJava;
    private int mLoadType;
    private boolean mFirstLayoutDone = true;
    private boolean mCommitted = true;
    private boolean mBlockMessages = false;
    private int mOrientation = -1;
    private boolean mIsMainFrame;
    private Map<String, Object> mJavaScriptObjects;
    private Set<Object> mRemovedJavaScriptObjects;
    private KeyStoreHandler mKeyStoreHandler = null;
    private SearchBoxImpl mSearchBox;
    int mNativeFrame;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.686 -0400", hash_original_method = "0C0B9FED7DBC124A25298101B6DEE56A", hash_generated_method = "20F340342FFB9D237C4723FF8A31A3EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BrowserFrame(Context context, WebViewCore w, CallbackProxy proxy,
            WebSettings settings, Map<String, Object> javascriptInterfaces) {
        dsTaint.addTaint(w.dsTaint);
        dsTaint.addTaint(javascriptInterfaces.dsTaint);
        dsTaint.addTaint(settings.dsTaint);
        dsTaint.addTaint(proxy.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        Context appContext;
        appContext = context.getApplicationContext();
        {
            sJavaBridge = new JWebCoreJavaBridge();
            ActivityManager am;
            am = (ActivityManager) context
                    .getSystemService(Context.ACTIVITY_SERVICE);
            {
                boolean varD3D608BC6A05F257DDC787DC0D4348D6_1085404532 = (am.getMemoryClass() > 16);
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
        {
            mJavaScriptObjects = new HashMap<String, Object>();
        } //End block
        mRemovedJavaScriptObjects = new HashSet<Object>();
        mDatabase = WebViewDatabase.getInstance(appContext);
        mSearchBox = new SearchBoxImpl(mWebViewCore, mCallbackProxy);
        mJavaScriptObjects.put(SearchBoxImpl.JS_INTERFACE_NAME, mSearchBox);
        AssetManager am;
        am = context.getAssets();
        nativeCreateFrame(w, am, proxy.getBackForwardList());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.686 -0400", hash_original_method = "056144D27ACF2932EFB0C1980B0D6F98", hash_generated_method = "F155204250249D75822CF94222646741")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void loadUrl(String url, Map<String, String> extraHeaders) {
        dsTaint.addTaint(extraHeaders.dsTaint);
        dsTaint.addTaint(url);
        mLoadInitFromJava = true;
        {
            boolean varCEBDFC4375B080C01B891460EBEF74EE_2054023433 = (URLUtil.isJavaScriptUrl(url));
            {
                stringByEvaluatingJavaScriptFromString(
                    url.substring("javascript:".length()));
            } //End block
            {
                nativeLoadUrl(url, extraHeaders);
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.686 -0400", hash_original_method = "55F163F814F53ECA11AC218202D49EB2", hash_generated_method = "4F2029ABC959B6A6DF258907FA5E0847")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void postUrl(String url, byte[] data) {
        dsTaint.addTaint(data[0]);
        dsTaint.addTaint(url);
        mLoadInitFromJava = true;
        nativePostUrl(url, data);
        mLoadInitFromJava = false;
        // ---------- Original Method ----------
        //mLoadInitFromJava = true;
        //nativePostUrl(url, data);
        //mLoadInitFromJava = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.687 -0400", hash_original_method = "210E874B3CC8A8754EDB8A64197F3EDD", hash_generated_method = "9BD44EF65C4A27696D2FF675B99D1625")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void loadData(String baseUrl, String data, String mimeType,
            String encoding, String historyUrl) {
        dsTaint.addTaint(baseUrl);
        dsTaint.addTaint(historyUrl);
        dsTaint.addTaint(encoding);
        dsTaint.addTaint(data);
        dsTaint.addTaint(mimeType);
        mLoadInitFromJava = true;
        {
            boolean var581113F7BD53DF8B7293B042681B40B2_861913169 = (historyUrl == null || historyUrl.length() == 0);
            {
                historyUrl = "about:blank";
            } //End block
        } //End collapsed parenthetic
        {
            data = "";
        } //End block
        {
            boolean varCB616F65F94E18DD8D2DD4567F35B835_133201912 = (baseUrl == null || baseUrl.length() == 0);
            {
                baseUrl = "about:blank";
            } //End block
        } //End collapsed parenthetic
        {
            boolean var9AF9469A93530D5A3F337475212051A4_1847434685 = (mimeType == null || mimeType.length() == 0);
            {
                mimeType = "text/html";
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.687 -0400", hash_original_method = "FE36B1316A593126EBA1AA2EF5942205", hash_generated_method = "CD4480C8333445EE8E64EF2DC6C86479")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     String saveWebArchive(String basename, boolean autoname) {
        dsTaint.addTaint(basename);
        dsTaint.addTaint(autoname);
        String var1B8A10629A954067ECB8A5C2DB4B2FA4_122134852 = (nativeSaveWebArchive(basename, autoname));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return nativeSaveWebArchive(basename, autoname);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.687 -0400", hash_original_method = "4DB46F10EA63A90C886405E235BD3A38", hash_generated_method = "B112D08AC1FECB2817A98E10B971E904")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void goBackOrForward(int steps) {
        dsTaint.addTaint(steps);
        mLoadInitFromJava = true;
        nativeGoBackOrForward(steps);
        mLoadInitFromJava = false;
        // ---------- Original Method ----------
        //mLoadInitFromJava = true;
        //nativeGoBackOrForward(steps);
        //mLoadInitFromJava = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.688 -0400", hash_original_method = "50E452D86A3E55153B3E0F1DD816D615", hash_generated_method = "F8C98C490FDE32E85474EB7FE37D1158")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void reportError(int errorCode, String description, String failingUrl) {
        dsTaint.addTaint(description);
        dsTaint.addTaint(errorCode);
        dsTaint.addTaint(failingUrl);
        resetLoadingStates();
        {
            boolean var40AE9761DC6AF2B0949485DECF62ABEE_341720222 = (description == null || description.isEmpty());
            {
                description = ErrorStrings.getString(errorCode, mContext);
            } //End block
        } //End collapsed parenthetic
        mCallbackProxy.onReceivedError(errorCode, description, failingUrl);
        // ---------- Original Method ----------
        //resetLoadingStates();
        //if (description == null || description.isEmpty()) {
            //description = ErrorStrings.getString(errorCode, mContext);
        //}
        //mCallbackProxy.onReceivedError(errorCode, description, failingUrl);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.688 -0400", hash_original_method = "7B4A87199DD3BC0CC52E5F0CAA9F0064", hash_generated_method = "FA4CC3EB22F179EC946E9ABCED374DF7")
    @DSModeled(DSC.SAFE)
    private void resetLoadingStates() {
        mCommitted = true;
        mFirstLayoutDone = true;
        // ---------- Original Method ----------
        //mCommitted = true;
        //mFirstLayoutDone = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.688 -0400", hash_original_method = "82C14ED51175F3BAD05958BE30AA9B50", hash_generated_method = "C46D10B175D21D1130850F8DB735B3EB")
    @DSModeled(DSC.SAFE)
     boolean committed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCommitted;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.688 -0400", hash_original_method = "6055F5425C1866007AB953B33770A39A", hash_generated_method = "2AEF21B11C7C2CA66B9D96D472DC6144")
    @DSModeled(DSC.SAFE)
     boolean firstLayoutDone() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mFirstLayoutDone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.688 -0400", hash_original_method = "9068063B02257F9D08EFF05D6BD051A9", hash_generated_method = "3DEE93D00E1DA10AB3BA99BA76BC99FD")
    @DSModeled(DSC.SAFE)
     int loadType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mLoadType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.688 -0400", hash_original_method = "027FDD69E025CF7A20175D3E84246197", hash_generated_method = "357F4E3DB5D03FD6715BE288D2C81D45")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.689 -0400", hash_original_method = "588CB65AC18071EB5B02ABC642CC0A1A", hash_generated_method = "6CE776F7BD7A8558E7A66FED3ADA5CE2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void loadStarted(String url, Bitmap favicon, int loadType,
            boolean isMainFrame) {
        dsTaint.addTaint(loadType);
        dsTaint.addTaint(isMainFrame);
        dsTaint.addTaint(favicon.dsTaint);
        dsTaint.addTaint(url);
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.689 -0400", hash_original_method = "C9CC31AE97DBC19619CDCFC15EC7B03E", hash_generated_method = "48F9590BE208FB3F39E2750B2414BE80")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unused")
    private void saveFormData(HashMap<String, String> data) {
        dsTaint.addTaint(data.dsTaint);
        {
            boolean varE277716CFEE75D183A4BE1A1459F291C_96517260 = (mSettings.getSaveFormData());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.689 -0400", hash_original_method = "F4B9AF2B8B6C0B9D0EBAE01BEE4BF775", hash_generated_method = "ABA107F3B5331DE5D6FCB7E3B1030DA2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unused")
    private boolean shouldSaveFormData() {
        {
            boolean varE277716CFEE75D183A4BE1A1459F291C_343562560 = (mSettings.getSaveFormData());
            {
                WebHistoryItem h;
                h = mCallbackProxy.getBackForwardList()
                    .getCurrentItem();
                boolean var0A9CE26076094D732B198C6841494F25_1559425910 = (h != null && h.getUrl() != null);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mSettings.getSaveFormData()) {
            //final WebHistoryItem h = mCallbackProxy.getBackForwardList()
                    //.getCurrentItem();
            //return h != null && h.getUrl() != null;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.689 -0400", hash_original_method = "7094DD5A86271DA7E952B216F4C46CCD", hash_generated_method = "A4BDE308950CFF38AC3FF7C7D0A0D0E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void transitionToCommitted(int loadType, boolean isMainFrame) {
        dsTaint.addTaint(loadType);
        dsTaint.addTaint(isMainFrame);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.690 -0400", hash_original_method = "5C2FD3A5795EB59386117F9A61E0ADCE", hash_generated_method = "B92421F47A6465003344BD3C2AB43A8F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void loadFinished(String url, int loadType, boolean isMainFrame) {
        dsTaint.addTaint(loadType);
        dsTaint.addTaint(isMainFrame);
        dsTaint.addTaint(url);
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.690 -0400", hash_original_method = "D2CB1A360A21716BE59AD0C99E7F7543", hash_generated_method = "EB87825D83EA8210AAD0F485DEC0C555")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void certificate(SslCertificate certificate) {
        dsTaint.addTaint(certificate.dsTaint);
        {
            mCallbackProxy.onReceivedCertificate(certificate);
        } //End block
        // ---------- Original Method ----------
        //if (mIsMainFrame) {
            //mCallbackProxy.onReceivedCertificate(certificate);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.690 -0400", hash_original_method = "FF0F600C92E1745B1B3B7823F85C9072", hash_generated_method = "3C727BDF61EF3EB2B960E985C9E7AA07")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void destroy() {
        nativeDestroyFrame();
        mBlockMessages = true;
        removeCallbacksAndMessages(null);
        // ---------- Original Method ----------
        //nativeDestroyFrame();
        //mBlockMessages = true;
        //removeCallbacksAndMessages(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.690 -0400", hash_original_method = "08B10BC0FD4D849356EF434C4A57C456", hash_generated_method = "8B9B9B8D59DE1F6D6CDF0518AD58CDF2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void handleMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        //Begin case FRAME_COMPLETED 
        {
            {
                boolean var62FF4720D31A7507990A918088ECF943_1766203623 = (mSettings.getSavePassword() && hasPasswordField());
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
                boolean var6B43FCDD8E50C7CA617498FD267AAC18_1357483783 = (!JniUtil.useChromiumHttpStack());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.691 -0400", hash_original_method = "71CD366348BF98805D3BCFC6E13F61B1", hash_generated_method = "7281036E5F4DED8C9688AC39BA240510")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setTitle(String title) {
        dsTaint.addTaint(title);
        mCallbackProxy.onReceivedTitle(title);
        // ---------- Original Method ----------
        //mCallbackProxy.onReceivedTitle(title);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.691 -0400", hash_original_method = "DC38D0601A6CA8B3CA54AD6CF11C8ED7", hash_generated_method = "19A7301EE8C100BEB22BC7212738A962")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void externalRepresentation(Message callback) {
        dsTaint.addTaint(callback.dsTaint);
        callback.obj = externalRepresentation();
        ;
        callback.sendToTarget();
        // ---------- Original Method ----------
        //callback.obj = externalRepresentation();
        //;
        //callback.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.691 -0400", hash_original_method = "818D4287AF55B155FD9BEC63FC9BB14D", hash_generated_method = "0E59D327209166EADAE959643C741D62")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String externalRepresentation() {
        return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.691 -0400", hash_original_method = "769B7E21D870172A915EE6F0EB6B2D2C", hash_generated_method = "5918F58FAA9C1D3FDFCE23220F89C16C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void documentAsText(Message callback) {
        dsTaint.addTaint(callback.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.691 -0400", hash_original_method = "79942AAFA346C254C5198053B4C683D6", hash_generated_method = "DCC91B1EB77C9CD30D2886A3CA1093BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String documentAsText() {
        return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.692 -0400", hash_original_method = "BAA59F57B83FBAF7CC9F5BD462BDF4D7", hash_generated_method = "93CC954A17E3A95BA0DACA35959345E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String childFramesAsText() {
        return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.692 -0400", hash_original_method = "7D1B04AB7A647E05019AB7BC865C3803", hash_generated_method = "E2014F56694190D2425322236954345A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void windowObjectCleared(int nativeFramePointer) {
        dsTaint.addTaint(nativeFramePointer);
        Iterator<String> iter;
        iter = mJavaScriptObjects.keySet().iterator();
        {
            boolean varADABAFEBBAB7E585DD903333BD7F20A8_929526439 = (iter.hasNext());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.692 -0400", hash_original_method = "2FB67C52CD526BE2C970DC0DB75D361F", hash_generated_method = "C8BA50151A101860084ADE418D62CD3C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean handleUrl(String url) {
        dsTaint.addTaint(url);
        {
            boolean var7DE13210A5C773F021EC43207BBDA187_911325264 = (mCallbackProxy.shouldOverrideUrlLoading(url));
            {
                didFirstLayout();
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.692 -0400", hash_original_method = "8112D6E9F2629FDD519CF9C502DF963B", hash_generated_method = "00FF88616F83C691A8A1F61065978B90")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addJavascriptInterface(Object obj, String interfaceName) {
        dsTaint.addTaint(interfaceName);
        dsTaint.addTaint(obj.dsTaint);
        removeJavascriptInterface(interfaceName);
        mJavaScriptObjects.put(interfaceName, obj);
        // ---------- Original Method ----------
        //assert obj != null;
        //removeJavascriptInterface(interfaceName);
        //mJavaScriptObjects.put(interfaceName, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.692 -0400", hash_original_method = "D4D979316C36EF31BC47A23AC0C9BE50", hash_generated_method = "1B324697FD54AA90A424A20FC4B50AC9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeJavascriptInterface(String interfaceName) {
        dsTaint.addTaint(interfaceName);
        {
            boolean varBA61D59CAAA24DBF67D72A8EF3264200_98736279 = (mJavaScriptObjects.containsKey(interfaceName));
            {
                mRemovedJavaScriptObjects.add(mJavaScriptObjects.remove(interfaceName));
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mJavaScriptObjects.containsKey(interfaceName)) {
            //mRemovedJavaScriptObjects.add(mJavaScriptObjects.remove(interfaceName));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.693 -0400", hash_original_method = "DF8E19ADC1C4D892E5E9E24D72F873C3", hash_generated_method = "241FD9D89F91044D1B849BFADAF130BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getFileSize(String uri) {
        dsTaint.addTaint(uri);
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.693 -0400", hash_original_method = "D65A9387A3FB37FCB544A79FFB5606B6", hash_generated_method = "1F0AB6255E074CAC5E75F698CE8B682A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getFile(String uri, byte[] buffer, int offset,
            int expectedSize) {
        dsTaint.addTaint(buffer[0]);
        dsTaint.addTaint(expectedSize);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(uri);
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.694 -0400", hash_original_method = "60CA323AEDF7C276FF8B65BEFBD4FA69", hash_generated_method = "0CE2445A2965C87ABE3F99D83C00F992")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private InputStream inputStreamForAndroidResource(String url) {
        dsTaint.addTaint(url);
        String ANDROID_ASSET;
        ANDROID_ASSET = "file:///android_asset/";
        String ANDROID_RESOURCE;
        ANDROID_RESOURCE = "file:///android_res/";
        String ANDROID_CONTENT;
        ANDROID_CONTENT = "content:";
        {
            boolean varFDE4819B7BD4D15D01E52BC5B52139CC_346504751 = (url.startsWith(ANDROID_RESOURCE));
            {
                url = url.replaceFirst(ANDROID_RESOURCE, "");
                {
                    boolean var6AB4ECE4FADE49B1DE66FC23626AC729_749573818 = (url == null || url.length() == 0);
                } //End collapsed parenthetic
                int slash;
                slash = url.indexOf('/');
                int dot;
                dot = url.indexOf('.', slash);
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
                        InputStream varDB5A80C30C924F56C08336FA11E34729_1556354195 = (mContext.getAssets().openNonAsset(
                            value.assetCookie, value.string.toString(),
                            AssetManager.ACCESS_STREAMING));
                    } //End block
                } //End block
                catch (Exception e)
                { }
            } //End block
            {
                boolean varA326CC4BBEB8E48966FD18C590AD09E0_1021271793 = (url.startsWith(ANDROID_ASSET));
                {
                    url = url.replaceFirst(ANDROID_ASSET, "");
                    try 
                    {
                        AssetManager assets;
                        assets = mContext.getAssets();
                        InputStream varFCC190A54AE444415A937863173B389C_1558106273 = (assets.open(url, AssetManager.ACCESS_STREAMING));
                    } //End block
                    catch (IOException e)
                    { }
                } //End block
                {
                    boolean var9D1D2B0882467AD6080B338924D7EEBD_1101236367 = (mSettings.getAllowContentAccess() &&
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
                            InputStream var7F6AC9DE7577B15D3E21530D7CC95F1A_1002623020 = (mContext.getContentResolver().openInputStream(uri));
                        } //End block
                        catch (Exception e)
                        { }
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        return (InputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.695 -0400", hash_original_method = "DEA49E30923C6B4E17F9FB446E1784D4", hash_generated_method = "1E36B81441FE7D70433E04AF0D4D8FBD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        dsTaint.addTaint(headers.dsTaint);
        dsTaint.addTaint(username);
        dsTaint.addTaint(postDataIdentifier);
        dsTaint.addTaint(postData[0]);
        dsTaint.addTaint(mainResource);
        dsTaint.addTaint(loaderHandle);
        dsTaint.addTaint(userGesture);
        dsTaint.addTaint(method);
        dsTaint.addTaint(synchronous);
        dsTaint.addTaint(password);
        dsTaint.addTaint(cacheMode);
        dsTaint.addTaint(url);
        {
            boolean var6F8758D2F464DBB6403377B21E3BD81A_554952344 = (mSettings.getCacheMode() != WebSettings.LOAD_DEFAULT);
            {
                cacheMode = mSettings.getCacheMode();
            } //End block
        } //End collapsed parenthetic
        {
            boolean varE136B9F2BD76354D2C6E072F73228787_1468159742 = (method.equals("POST"));
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
            boolean var94019098962C39DF55C40C7C4C678CCF_1132901419 = (LoadListener.getNativeLoaderCount() > MAX_OUTSTANDING_REQUESTS);
            {
                loadListener.error(
                    android.net.http.EventHandler.ERROR, mContext.getString(
                            com.android.internal.R.string.httpErrorTooManyRequests));
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
        return (LoadListener)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.695 -0400", hash_original_method = "69B43B2B2D64063203E22417AF1B4FBE", hash_generated_method = "1C4FDD3E7752A04E1C073C130257BC9C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void maybeSavePassword(
            byte[] postData, String username, String password) {
        dsTaint.addTaint(username);
        dsTaint.addTaint(postData[0]);
        dsTaint.addTaint(password);
        {
            boolean var911F0604D5A8278A2892D81EDC89EA56_1368352285 = (postData == null
                || username == null || username.isEmpty()
                || password == null || password.isEmpty());
        } //End collapsed parenthetic
        {
            boolean varF748BCF92145CEE9E6F4341D9614C6CE_2063897064 = (!mSettings.getSavePassword());
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
                boolean var3202C69FDDB5D23F4FF83477294755BA_504011180 = (postString.contains(URLEncoder.encode(username)) &&
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.696 -0400", hash_original_method = "1F3B79BD64689949D611D3C7448B30E7", hash_generated_method = "FF083B3B1D55CB3AA1B0CC48A7B6A080")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private WebResourceResponse shouldInterceptRequest(String url) {
        dsTaint.addTaint(url);
        InputStream androidResource;
        androidResource = inputStreamForAndroidResource(url);
        {
            WebResourceResponse varB0E3D1ED971D995B102F7B6E4A07CEDD_1439652316 = (new WebResourceResponse(null, null, androidResource));
        } //End block
        {
            boolean var2EA2AD5659C13164CC598F5F4B7C9684_1901963051 = (!mSettings.getAllowFileAccess() && url.startsWith("file://"));
            {
                WebResourceResponse var1FF1ED1E3BB9FA5D44EDEC50A90B9550_1332614976 = (new WebResourceResponse(null, null, null));
            } //End block
        } //End collapsed parenthetic
        WebResourceResponse response;
        response = mCallbackProxy.shouldInterceptRequest(url);
        {
            boolean var847EBE44E86F4F89B92A16B7F267147C_1773197422 = (response == null && "browser:incognito".equals(url));
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
        return (WebResourceResponse)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.696 -0400", hash_original_method = "07700DAB8245AC940D55DCEF1A17B102", hash_generated_method = "EFEF590ECC9D33FBF0E4405501802755")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setProgress(int newProgress) {
        dsTaint.addTaint(newProgress);
        mCallbackProxy.onProgressChanged(newProgress);
        {
            sendMessageDelayed(obtainMessage(FRAME_COMPLETED), 100);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.696 -0400", hash_original_method = "910C3A78FCE0B1E574FD9CA74D1EE7A9", hash_generated_method = "35E4B3CFEDEBAA89CE0EB98473D75D02")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void didReceiveIcon(Bitmap icon) {
        dsTaint.addTaint(icon.dsTaint);
        mCallbackProxy.onReceivedIcon(icon);
        // ---------- Original Method ----------
        //mCallbackProxy.onReceivedIcon(icon);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.696 -0400", hash_original_method = "F9E26289979EC36BEDC07872BFD387F0", hash_generated_method = "B1067F91DBEA4CB18B8B261C86C774A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void didReceiveTouchIconUrl(String url, boolean precomposed) {
        dsTaint.addTaint(precomposed);
        dsTaint.addTaint(url);
        mCallbackProxy.onReceivedTouchIconUrl(url, precomposed);
        // ---------- Original Method ----------
        //mCallbackProxy.onReceivedTouchIconUrl(url, precomposed);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.696 -0400", hash_original_method = "49DBB49355B8BD4E95F5FBA6E171926E", hash_generated_method = "0C0382423FB9F9BBB2CDC83DF3360FF5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private BrowserFrame createWindow(boolean dialog, boolean userGesture) {
        dsTaint.addTaint(userGesture);
        dsTaint.addTaint(dialog);
        BrowserFrame var5AC594AAC2A5E212DBE99ABD1B79C222_1347672811 = (mCallbackProxy.createWindow(dialog, userGesture));
        return (BrowserFrame)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCallbackProxy.createWindow(dialog, userGesture);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.697 -0400", hash_original_method = "05E62B842D0E318583ACCB4619923A88", hash_generated_method = "75CF187AC2BCD2C92D428CFCB1D19AF9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void requestFocus() {
        mCallbackProxy.onRequestFocus();
        // ---------- Original Method ----------
        //mCallbackProxy.onRequestFocus();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.697 -0400", hash_original_method = "A6BF5F00A4A45564AACA34EE9DAEC5CF", hash_generated_method = "BBB65253747844CC6EAD96B42B17C6B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void closeWindow(WebViewCore w) {
        dsTaint.addTaint(w.dsTaint);
        mCallbackProxy.onCloseWindow(w.getWebView());
        // ---------- Original Method ----------
        //mCallbackProxy.onCloseWindow(w.getWebView());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.697 -0400", hash_original_method = "53828DFE68036F8E35ADAC562AA427C9", hash_generated_method = "14B15D133B31EE76D1AD0B07D1DE9AE0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void decidePolicyForFormResubmission(int policyFunction) {
        dsTaint.addTaint(policyFunction);
        Message dontResend;
        dontResend = obtainMessage(POLICY_FUNCTION, policyFunction,
                POLICY_IGNORE);
        Message resend;
        resend = obtainMessage(POLICY_FUNCTION, policyFunction,
                POLICY_USE);
        mCallbackProxy.onFormResubmission(dontResend, resend);
        // ---------- Original Method ----------
        //Message dontResend = obtainMessage(POLICY_FUNCTION, policyFunction,
                //POLICY_IGNORE);
        //Message resend = obtainMessage(POLICY_FUNCTION, policyFunction,
                //POLICY_USE);
        //mCallbackProxy.onFormResubmission(dontResend, resend);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.697 -0400", hash_original_method = "B19BAB1EEF674556A3A9CC47CD14FB0B", hash_generated_method = "16763400B45D60190045D649D5B0E3F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateVisitedHistory(String url, boolean isReload) {
        dsTaint.addTaint(isReload);
        dsTaint.addTaint(url);
        mCallbackProxy.doUpdateVisitedHistory(url, isReload);
        // ---------- Original Method ----------
        //mCallbackProxy.doUpdateVisitedHistory(url, isReload);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.697 -0400", hash_original_method = "D3ED977A3BCAC48329E24D7D69689852", hash_generated_method = "B10E0BDC05149E0B7570F9E36D11D0E8")
    @DSModeled(DSC.SAFE)
     CallbackProxy getCallbackProxy() {
        return (CallbackProxy)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCallbackProxy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.697 -0400", hash_original_method = "F09A8DE53C03EAD5D6B2D7442C92246E", hash_generated_method = "04C942B51174E4BF83EDD78FD818EA9D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     String getUserAgentString() {
        String varB60E92230C0E8DA563F114C42EA1EC7D_2063246516 = (mSettings.getUserAgentString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSettings.getUserAgentString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.698 -0400", hash_original_method = "D14466E1FBBBA5A0DDC9A63472126D93", hash_generated_method = "BD67E353DEF34CABF6DA668ED48A8EE6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String getRawResFilename(int id) {
        dsTaint.addTaint(id);
        String var30A113532FCB5A8C2F37DEE9921C5AA7_833222027 = (getRawResFilename(id, mContext));
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.698 -0400", hash_original_method = "E4DD03CAE364FD517B782C57726FD370", hash_generated_method = "DB2BCBBBC0E6E89C8E268B0837E5D077")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private float density() {
        float var828FED69EC6DBC28F444BC99FA02F5DC_1650606908 = (mContext.getResources().getDisplayMetrics().density);
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mContext.getResources().getDisplayMetrics().density;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.698 -0400", hash_original_method = "468A4DE23411D07F152B7955301757EE", hash_generated_method = "DA4C4D07B256003BA3985E4301041F08")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void didReceiveAuthenticationChallenge(
            final int handle, String host, String realm, final boolean useCachedCredentials,
            final boolean suppressDialog) {
        dsTaint.addTaint(host);
        dsTaint.addTaint(handle);
        dsTaint.addTaint(realm);
        dsTaint.addTaint(suppressDialog);
        dsTaint.addTaint(useCachedCredentials);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.699 -0400", hash_original_method = "97FC7CDAEAC134FF2FCE50444AA0C7A7", hash_generated_method = "C88C16DFF9F3D22052EE4AA1409FAFA1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void reportSslCertError(final int handle, final int certError, byte certDER[],
            String url) {
        dsTaint.addTaint(handle);
        dsTaint.addTaint(certDER);
        dsTaint.addTaint(url);
        dsTaint.addTaint(certError);
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
            boolean var9E891972169349B7CCF07279CD1AABBF_1057804374 = (SslCertLookupTable.getInstance().isAllowed(sslError));
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
                post(new Runnable() {
                        public void run() {
                            nativeSslCertErrorProceed(handle);
                        }
                    });
            }
            @Override
            public void cancel() {
                post(new Runnable() {
                        public void run() {
                            nativeSslCertErrorCancel(handle, certError);
                        }
                    });
            }
        };
        mCallbackProxy.onReceivedSslError(handler, sslError);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.699 -0400", hash_original_method = "DFA7C324E28D10E855E86AE4BB5B7562", hash_generated_method = "C53C198B3751EFD708BC205DF036F35B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void requestClientCert(int handle, String hostAndPort) {
        dsTaint.addTaint(handle);
        dsTaint.addTaint(hostAndPort);
        SslClientCertLookupTable table;
        table = SslClientCertLookupTable.getInstance();
        {
            boolean var3396FDE3F71A1312687665F19E9550DF_1195707855 = (table.IsAllowed(hostAndPort));
            {
                nativeSslClientCert(handle,
                                table.PrivateKey(hostAndPort),
                                table.CertificateChain(hostAndPort));
            } //End block
            {
                boolean var50D6A23560AA663AF990FF8C2B0C3B75_953733369 = (table.IsDenied(hostAndPort));
                {
                    nativeSslClientCert(handle, null, null);
                } //End block
                {
                    mCallbackProxy.onReceivedClientCertRequest(
                    new ClientCertRequestHandler(this, handle, hostAndPort, table), hostAndPort);
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.699 -0400", hash_original_method = "322B645C7F09570DF98848B1C3D767D8", hash_generated_method = "070DDE986205ECD4B5F6CFD62E4CDC0F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void downloadStart(String url, String userAgent,
            String contentDisposition, String mimeType, long contentLength) {
        dsTaint.addTaint(userAgent);
        dsTaint.addTaint(contentLength);
        dsTaint.addTaint(contentDisposition);
        dsTaint.addTaint(mimeType);
        dsTaint.addTaint(url);
        {
            boolean var44872427025E393BE432C3478708F3FD_269169016 = (mimeType.isEmpty());
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
            boolean var4B3BED1078E8417BFF574BC05F74B45C_203018167 = (CertTool.getCertType(mimeType) != null);
            {
                mKeyStoreHandler = new KeyStoreHandler(mimeType);
            } //End block
            {
                mCallbackProxy.onDownloadStart(url, userAgent,
                contentDisposition, mimeType, contentLength);
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.700 -0400", hash_original_method = "BAE8CD84EA4D59BD4BB7CAF15EB1C07F", hash_generated_method = "8F2BBF22B24415484EB42061AA1B7061")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void didReceiveData(byte data[], int size) {
        dsTaint.addTaint(data);
        dsTaint.addTaint(size);
        mKeyStoreHandler.didReceiveData(data, size);
        // ---------- Original Method ----------
        //if (mKeyStoreHandler != null) mKeyStoreHandler.didReceiveData(data, size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.700 -0400", hash_original_method = "5EC89579D3745ABD19569589FBBBCA81", hash_generated_method = "B454CCBDA172FF40AB0FF66C63354298")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.700 -0400", hash_original_method = "A2E04BD398BDF0F096F042D99402CC27", hash_generated_method = "C191F048E7A9D3C8DFCE188034F731E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setCertificate(byte cert_der[]) {
        dsTaint.addTaint(cert_der);
        try 
        {
            X509Certificate cert;
            cert = new X509CertImpl(cert_der);
            mCallbackProxy.onReceivedCertificate(new SslCertificate(cert));
        } //End block
        catch (IOException e)
        { }
        // ---------- Original Method ----------
        //try {
            //X509Certificate cert = new X509CertImpl(cert_der);
            //mCallbackProxy.onReceivedCertificate(new SslCertificate(cert));
        //} catch (IOException e) {
            //Log.e(LOGTAG, "Can't get the certificate from WebKit, canceling");
            //return;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.700 -0400", hash_original_method = "780A48AF1DFDDD134926E1881FBB7981", hash_generated_method = "8AFB37762A656E87D5A4F8B5F0FF1A25")
    @DSModeled(DSC.SAFE)
     SearchBox getSearchBox() {
        return (SearchBox)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSearchBox;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.700 -0400", hash_original_method = "957E1FEE267AF2EB4B4A609321166001", hash_generated_method = "2C9A72D9E7179DAA2EC579887950D4B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void autoLogin(String realm, String account, String args) {
        dsTaint.addTaint(realm);
        dsTaint.addTaint(args);
        dsTaint.addTaint(account);
        mCallbackProxy.onReceivedLoginRequest(realm, account, args);
        // ---------- Original Method ----------
        //mCallbackProxy.onReceivedLoginRequest(realm, account, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.700 -0400", hash_original_method = "CAC5AC041AD65DE746A86B06B460473E", hash_generated_method = "430224C14F2B4503AC631F51C24482F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeCreateFrame(WebViewCore w, AssetManager am,
            WebBackForwardList list) {
        dsTaint.addTaint(w.dsTaint);
        dsTaint.addTaint(am.dsTaint);
        dsTaint.addTaint(list.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.701 -0400", hash_original_method = "74AC0793AA670585A51BA4B2FC045561", hash_generated_method = "D0819FF5A9F51FEE8FA89D4F258032D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void nativeDestroyFrame() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.701 -0400", hash_original_method = "7D705910310ED484283730AFB821A717", hash_generated_method = "F6661CC8FB7710C2B56516A261A24FE5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeCallPolicyFunction(int policyFunction,
            int decision) {
        dsTaint.addTaint(policyFunction);
        dsTaint.addTaint(decision);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.701 -0400", hash_original_method = "AE07D7138DB6945AA08789E90E80B92B", hash_generated_method = "FDECDDE9168C10300879EDAD4E84E8C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void reload(boolean allowStale) {
        dsTaint.addTaint(allowStale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.701 -0400", hash_original_method = "53A1F9C2A72688D9CD2F75BB7D3D5005", hash_generated_method = "692A1C78284A704D39696E85EF1C9906")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeGoBackOrForward(int steps) {
        dsTaint.addTaint(steps);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.701 -0400", hash_original_method = "F143225F39CB01C1D802EC565271C419", hash_generated_method = "34D8157A7916A31A075A631B7E05D86F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String stringByEvaluatingJavaScriptFromString(String script) {
        dsTaint.addTaint(script);
        return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.702 -0400", hash_original_method = "1BC95C43CEE0FFE1F6217DA26B59C5B9", hash_generated_method = "9784B976311FEF045D68A3A554198D76")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeAddJavascriptInterface(int nativeFramePointer,
            Object obj, String interfaceName) {
        dsTaint.addTaint(interfaceName);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(nativeFramePointer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.702 -0400", hash_original_method = "B177754AEEE092C53184C415EE8118E6", hash_generated_method = "FE8C8881BE4FEB65E45F68585D514DE4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setCacheDisabled(boolean disabled) {
        dsTaint.addTaint(disabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.702 -0400", hash_original_method = "8B7AAFA05BB3F3ED8C594AA78F708D08", hash_generated_method = "1EB7D32BF69060F6621F2E9C8B022EFE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean cacheDisabled() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.702 -0400", hash_original_method = "055468486DD4D3FA9B64A316B50FA6FA", hash_generated_method = "09DFDA49097E0044F1CB77E2DA83386B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clearCache() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.702 -0400", hash_original_method = "6C44E95231996B5164D16D96A5AF9CAD", hash_generated_method = "6BF258CF5319509785E584DAE0E07E09")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeLoadUrl(String url, Map<String, String> headers) {
        dsTaint.addTaint(headers.dsTaint);
        dsTaint.addTaint(url);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.703 -0400", hash_original_method = "4DAAE38A658B1BBD069DC4A366A0C462", hash_generated_method = "2FBDB662C0F30BA770747D6072A9DE86")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativePostUrl(String url, byte[] postData) {
        dsTaint.addTaint(postData[0]);
        dsTaint.addTaint(url);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.703 -0400", hash_original_method = "8945167C96AD091C5C39DEC108C4839D", hash_generated_method = "5248F9A24B8F7A801D3DFA8B122FA920")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeLoadData(String baseUrl, String data,
            String mimeType, String encoding, String historyUrl) {
        dsTaint.addTaint(baseUrl);
        dsTaint.addTaint(historyUrl);
        dsTaint.addTaint(encoding);
        dsTaint.addTaint(data);
        dsTaint.addTaint(mimeType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.703 -0400", hash_original_method = "A939F96E349A2DAAC3BA975E2507007D", hash_generated_method = "A20ED99BC6ADB1A37D77ED3EC6142CBA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.703 -0400", hash_original_method = "64AB65E4A9095F9BBCDCF9CF6CF9A5F6", hash_generated_method = "863930E14611E1ACA6714E4256C8BCDF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeStopLoading() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.703 -0400", hash_original_method = "9D75E2E2AB8D83EF2AA67EF8FE72195D", hash_generated_method = "C7FCC7BB3E743B04DE6CB983FDDC522F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean documentHasImages() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.704 -0400", hash_original_method = "10318A015094FE1A39B49B3070F280C0", hash_generated_method = "55F21E8CCE6FC82AEB6DE7B53771E87E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean hasPasswordField() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.704 -0400", hash_original_method = "865B533AFC1748A162575C4402C4E1D7", hash_generated_method = "3138383513B549311867BF88C5FB3B1B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String[] getUsernamePassword() {
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.704 -0400", hash_original_method = "2745608D69207B6EE74824552EF70660", hash_generated_method = "FD9F91C0054C1895183732EA69546CFB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setUsernamePassword(String username, String password) {
        dsTaint.addTaint(username);
        dsTaint.addTaint(password);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.704 -0400", hash_original_method = "74581984BB5BC192860C6547F8D5036F", hash_generated_method = "C4277784070A5527009C3910C1CB90CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String nativeSaveWebArchive(String basename, boolean autoname) {
        dsTaint.addTaint(basename);
        dsTaint.addTaint(autoname);
        return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.704 -0400", hash_original_method = "08E54613B59D770C860286634891B8BB", hash_generated_method = "7AFE8CDFE7AC965AAF19E582592B16FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeOrientationChanged(int orientation) {
        dsTaint.addTaint(orientation);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.704 -0400", hash_original_method = "68B2D8AE5CF2C1C845D97B94EDB581CC", hash_generated_method = "55A43D244076FDD0D5CD4ACEDAD9C8F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeAuthenticationProceed(int handle, String username, String password) {
        dsTaint.addTaint(username);
        dsTaint.addTaint(handle);
        dsTaint.addTaint(password);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.705 -0400", hash_original_method = "9DEA51422898C7E38A3DECD149992B9B", hash_generated_method = "4563B425A8580E8CCB9B40C5E108BBDF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeAuthenticationCancel(int handle) {
        dsTaint.addTaint(handle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.705 -0400", hash_original_method = "DFE86F393FFB1B33336576462A995D77", hash_generated_method = "BBE86C48AAF6BB93BF6F867DAA3AFB24")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeSslCertErrorProceed(int handle) {
        dsTaint.addTaint(handle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.705 -0400", hash_original_method = "8A69525C805CE3B5326B3888FD841CA0", hash_generated_method = "C7A5002DD58ADC0A016E32C7331EF0F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeSslCertErrorCancel(int handle, int certError) {
        dsTaint.addTaint(handle);
        dsTaint.addTaint(certError);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.705 -0400", hash_original_method = "81F222D4FD7D3F4B597DBD7F9BD0D106", hash_generated_method = "95A3A734021916AF01F0D5BE144D8E93")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void nativeSslClientCert(int handle,
                                    byte[] pkcs8EncodedPrivateKey,
                                    byte[][] asn1DerEncodedCertificateChain) {
        dsTaint.addTaint(handle);
        dsTaint.addTaint(asn1DerEncodedCertificateChain[0][0]);
        dsTaint.addTaint(pkcs8EncodedPrivateKey[0]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.705 -0400", hash_original_method = "154F1DF98163CFE18EB2585F133E4CD5", hash_generated_method = "4CFE1FFEDB3FE43BA59B6B8CA536A51E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean getShouldStartScrolledRight() {
        boolean var335C30460623592B55D35997E929AE78_142217143 = (nativeGetShouldStartScrolledRight(mNativeFrame));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return nativeGetShouldStartScrolledRight(mNativeFrame);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.705 -0400", hash_original_method = "F95D370518D151DA0A0757957627AE19", hash_generated_method = "9F87C08D758FCB226175E44C001F49E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean nativeGetShouldStartScrolledRight(int nativeBrowserFrame) {
        dsTaint.addTaint(nativeBrowserFrame);
        return dsTaint.getTaintBoolean();
    }

    
    private static class ConfigCallback implements ComponentCallbacks {
        private ArrayList<WeakReference<Handler>> mHandlers =
                new ArrayList<WeakReference<Handler>>();
        private WindowManager mWindowManager;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.706 -0400", hash_original_method = "049F58B9ED595813037671BB1DAC0333", hash_generated_method = "1BD4DA99092FF4445EE482CE2E2FBC7D")
        @DSModeled(DSC.SAFE)
         ConfigCallback(WindowManager wm) {
            dsTaint.addTaint(wm.dsTaint);
            // ---------- Original Method ----------
            //mWindowManager = wm;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.706 -0400", hash_original_method = "3638F495C0637CBBD96B9D8F0DA8CFC2", hash_generated_method = "B82860C1ED4D0226E6195A2A65865A6F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public synchronized void addHandler(Handler h) {
            dsTaint.addTaint(h.dsTaint);
            mHandlers.add(new WeakReference<Handler>(h));
            // ---------- Original Method ----------
            //mHandlers.add(new WeakReference<Handler>(h));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.719 -0400", hash_original_method = "2BDCB7974021DF1350762A5BB88607D6", hash_generated_method = "A6DE4783FC798DA13D8281356550356D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onConfigurationChanged(Configuration newConfig) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(newConfig.dsTaint);
            {
                boolean var77DE7BD4514F064D49FEE0FA393B405C_417717615 = (mHandlers.size() == 0);
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
                    Iterator<WeakReference<Handler>> varCECD96480F7943C24B44EAC392B955D4_15974255 = (mHandlers).iterator();
                    varCECD96480F7943C24B44EAC392B955D4_15974255.hasNext();
                    WeakReference<Handler> wh = varCECD96480F7943C24B44EAC392B955D4_15974255.next();
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
                    Iterator<WeakReference> varD1D4DD7CA023B24419A744496E994C66_324643682 = (handlersToRemove).iterator();
                    varD1D4DD7CA023B24419A744496E994C66_324643682.hasNext();
                    WeakReference weak = varD1D4DD7CA023B24419A744496E994C66_324643682.next();
                    {
                        mHandlers.remove(weak);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.722 -0400", hash_original_method = "4F0E380BE715BF5B2ECCDB1794C8905E", hash_generated_method = "39AEB8790734ECC8DC70BBAAEE0BAB0B")
        @DSModeled(DSC.SAFE)
        public void onLowMemory() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            // ---------- Original Method ----------
        }

        
    }


    
    private static final String LOGTAG = "webkit";
    private final static int MAX_OUTSTANDING_REQUESTS = 300;
    static final int FRAME_COMPLETED = 1001;
    static final int ORIENTATION_CHANGED = 1002;
    static final int POLICY_FUNCTION = 1003;
    static final int FRAME_LOADTYPE_STANDARD = 0;
    static final int FRAME_LOADTYPE_BACK = 1;
    static final int FRAME_LOADTYPE_FORWARD = 2;
    static final int FRAME_LOADTYPE_INDEXEDBACKFORWARD = 3;
    static final int FRAME_LOADTYPE_RELOAD = 4;
    static final int FRAME_LOADTYPE_RELOADALLOWINGSTALEDATA = 5;
    static final int FRAME_LOADTYPE_SAME = 6;
    static final int FRAME_LOADTYPE_REDIRECT = 7;
    static final int FRAME_LOADTYPE_REPLACE = 8;
    private static final int TRANSITION_SWITCH_THRESHOLD = 75;
    static JWebCoreJavaBridge sJavaBridge;
    static ConfigCallback sConfigCallback;
    static final int POLICY_USE = 0;
    static final int POLICY_IGNORE = 2;
    private static final int NODOMAIN = 1;
    private static final int LOADERROR = 2;
    static final int DRAWABLEDIR = 3;
    private static final int FILE_UPLOAD_LABEL = 4;
    private static final int RESET_LABEL = 5;
    private static final int SUBMIT_LABEL = 6;
    private static final int FILE_UPLOAD_NO_FILE_CHOSEN = 7;
}

