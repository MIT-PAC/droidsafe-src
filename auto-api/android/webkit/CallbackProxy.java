package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.provider.Browser;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.android.internal.R;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CallbackProxy extends Handler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.058 -0400", hash_original_field = "AFFD03B1A69DF9C27FA75CB579217844", hash_generated_field = "6F5FFC523604435BA0DD35F79F6A85A7")

    private volatile WebViewClient mWebViewClient;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.058 -0400", hash_original_field = "3EAB4539F16F501734ACC8C81DE24BD3", hash_generated_field = "63308D14F2EED559304A82F3B2608B81")

    private volatile WebChromeClient mWebChromeClient;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.058 -0400", hash_original_field = "72439B8F99EB438C3DA5D9CD798C6786", hash_generated_field = "99346B50377E115231263981E00655CA")

    private WebView mWebView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.058 -0400", hash_original_field = "8F78F41712391973E9C79C3C35F135BC", hash_generated_field = "28B865E4101EE3CF35095A498919E885")

    private volatile DownloadListener mDownloadListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.058 -0400", hash_original_field = "445D98F13846084C13085D4DFA45B133", hash_generated_field = "1A26E3791D15D6F62673D059D1AEED62")

    private boolean mProgressUpdatePending;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.058 -0400", hash_original_field = "FE2A86390D34D288C679FA58DC8416A1", hash_generated_field = "F9A0FA589BF9C7209A847A27628B4160")

    private volatile int mLatestProgress = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.058 -0400", hash_original_field = "B14EAD6039EB6E741B058E71B841CD60", hash_generated_field = "9FEA62D4C2030775B452E5264DAC80A8")

    private WebBackForwardList mBackForwardList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.058 -0400", hash_original_field = "941CFD4AD27F3B44FE78BBA47FC72EC8", hash_generated_field = "4D827BAF16349A0C02C13EAE658A3C84")

    private volatile WebBackForwardListClient mWebBackForwardListClient;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.058 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.058 -0400", hash_original_field = "1F94E4F555C78CDBD57A123E28B7F0D0", hash_generated_field = "DF2188EEF215035517745E80E9FEC4E8")

    private long mWebCoreThreadTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.058 -0400", hash_original_field = "CEE99203BB8F6A0CE58080EEBA575E35", hash_generated_field = "7B28D3E8445ABAD93158B33A74B93640")

    private long mWebCoreIdleTime;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.059 -0400", hash_original_method = "5020D7570AC9675C7FDC286174BD125E", hash_generated_method = "6DEE1494E92560815E1A9A4AA30DF6BB")
    public  CallbackProxy(Context context, WebView w) {
        mContext = context;
        mWebView = w;
        mBackForwardList = new WebBackForwardList(this);
        // ---------- Original Method ----------
        //mContext = context;
        //mWebView = w;
        //mBackForwardList = new WebBackForwardList(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.059 -0400", hash_original_method = "94198B28324F8EDCEFD396927CFF12D2", hash_generated_method = "DE4F5106C007BE6F57AC8D71C62F1D2E")
    public void setWebViewClient(WebViewClient client) {
        mWebViewClient = client;
        // ---------- Original Method ----------
        //mWebViewClient = client;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.059 -0400", hash_original_method = "F1A871AF9A3B10055BFFA9DC06A940C2", hash_generated_method = "CE94183272D83791658EF6DF8428676D")
    public WebViewClient getWebViewClient() {
        WebViewClient varB4EAC82CA7396A68D541C85D26508E83_383810633 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_383810633 = mWebViewClient;
        varB4EAC82CA7396A68D541C85D26508E83_383810633.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_383810633;
        // ---------- Original Method ----------
        //return mWebViewClient;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.060 -0400", hash_original_method = "92EB7E506A2EF4886CBEC1480289BCB6", hash_generated_method = "4C169B04C3730379147B383EFDBF5622")
    public void setWebChromeClient(WebChromeClient client) {
        mWebChromeClient = client;
        // ---------- Original Method ----------
        //mWebChromeClient = client;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.060 -0400", hash_original_method = "578C7E32D2B540B07E657C95C84E837C", hash_generated_method = "B0FB1CC348036E8E87F51204DCBBF373")
    public WebChromeClient getWebChromeClient() {
        WebChromeClient varB4EAC82CA7396A68D541C85D26508E83_1469999128 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1469999128 = mWebChromeClient;
        varB4EAC82CA7396A68D541C85D26508E83_1469999128.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1469999128;
        // ---------- Original Method ----------
        //return mWebChromeClient;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.060 -0400", hash_original_method = "36DD14932709DFA3D074F96EC9039EDA", hash_generated_method = "C93408E62641713A784F45E96AAF15BB")
    public void setDownloadListener(DownloadListener client) {
        mDownloadListener = client;
        // ---------- Original Method ----------
        //mDownloadListener = client;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.061 -0400", hash_original_method = "2A97B39171573BABF631C9DB7E378DC9", hash_generated_method = "52771867E2A172D37F8F06784F428A26")
    public WebBackForwardList getBackForwardList() {
        WebBackForwardList varB4EAC82CA7396A68D541C85D26508E83_1182086074 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1182086074 = mBackForwardList;
        varB4EAC82CA7396A68D541C85D26508E83_1182086074.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1182086074;
        // ---------- Original Method ----------
        //return mBackForwardList;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.061 -0400", hash_original_method = "69271AEE54C61C015B6B50CD212FE110", hash_generated_method = "13A4BC55EE14A943E04C92B28D85EE99")
     void setWebBackForwardListClient(WebBackForwardListClient client) {
        mWebBackForwardListClient = client;
        // ---------- Original Method ----------
        //mWebBackForwardListClient = client;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.062 -0400", hash_original_method = "32023A06CFA84B93B3A0030ADE6E4A41", hash_generated_method = "F3118B3BBBD49613A79DA5FA5E6EAA73")
     WebBackForwardListClient getWebBackForwardListClient() {
        WebBackForwardListClient varB4EAC82CA7396A68D541C85D26508E83_865310417 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_865310417 = mWebBackForwardListClient;
        varB4EAC82CA7396A68D541C85D26508E83_865310417.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_865310417;
        // ---------- Original Method ----------
        //return mWebBackForwardListClient;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.063 -0400", hash_original_method = "43AE5B1BF40E67157C7361E5EC862A6C", hash_generated_method = "06980DEC19384963BF2957734E723A3B")
    public boolean uiOverrideUrlLoading(String overrideUrl) {
        {
            boolean var46C404494DFD92BDDD02800A6B728B6E_1772186730 = (overrideUrl == null || overrideUrl.length() == 0);
        } //End collapsed parenthetic
        boolean override = false;
        {
            override = mWebViewClient.shouldOverrideUrlLoading(mWebView,
                    overrideUrl);
        } //End block
        {
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(overrideUrl));
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.putExtra(Browser.EXTRA_APPLICATION_ID,
                    mContext.getPackageName());
            try 
            {
                mContext.startActivity(intent);
                override = true;
            } //End block
            catch (ActivityNotFoundException ex)
            { }
        } //End block
        addTaint(overrideUrl.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_720354413 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_720354413;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.063 -0400", hash_original_method = "D32407A1261408285F08570A8F2494B0", hash_generated_method = "633DBECBA86C3D3CD7DC8B4690C1B300")
    public boolean uiOverrideKeyEvent(KeyEvent event) {
        {
            boolean varE0D5CA03F66620B4894C506375BB27AD_1343759209 = (mWebViewClient.shouldOverrideKeyEvent(mWebView, event));
        } //End block
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_30843904 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_30843904;
        // ---------- Original Method ----------
        //if (mWebViewClient != null) {
            //return mWebViewClient.shouldOverrideKeyEvent(mWebView, event);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.074 -0400", hash_original_method = "643B690E8360A657B90F531CC63147C4", hash_generated_method = "BB90582AF6F698A844F828EB0E3D71FE")
    @Override
    public void handleMessage(Message msg) {
        //Begin case PAGE_STARTED 
        String startedUrl = msg.getData().getString("url");
        //End case PAGE_STARTED 
        //Begin case PAGE_STARTED 
        mWebView.onPageStarted(startedUrl);
        //End case PAGE_STARTED 
        //Begin case PAGE_STARTED 
        {
            mWebViewClient.onPageStarted(mWebView, startedUrl, (Bitmap) msg.obj);
        } //End block
        //End case PAGE_STARTED 
        //Begin case PAGE_FINISHED 
        String finishedUrl = (String) msg.obj;
        //End case PAGE_FINISHED 
        //Begin case PAGE_FINISHED 
        mWebView.onPageFinished(finishedUrl);
        //End case PAGE_FINISHED 
        //Begin case PAGE_FINISHED 
        {
            mWebViewClient.onPageFinished(mWebView, finishedUrl);
        } //End block
        //End case PAGE_FINISHED 
        //Begin case RECEIVED_ICON 
        {
            mWebChromeClient.onReceivedIcon(mWebView, (Bitmap) msg.obj);
        } //End block
        //End case RECEIVED_ICON 
        //Begin case RECEIVED_TOUCH_ICON_URL 
        {
            mWebChromeClient.onReceivedTouchIconUrl(mWebView,
                            (String) msg.obj, msg.arg1 == 1);
        } //End block
        //End case RECEIVED_TOUCH_ICON_URL 
        //Begin case RECEIVED_TITLE 
        {
            mWebChromeClient.onReceivedTitle(mWebView,
                            (String) msg.obj);
        } //End block
        //End case RECEIVED_TITLE 
        //Begin case REPORT_ERROR 
        {
            int reasonCode = msg.arg1;
            final String description = msg.getData().getString("description");
            final String failUrl = msg.getData().getString("failingUrl");
            mWebViewClient.onReceivedError(mWebView, reasonCode,
                            description, failUrl);
        } //End block
        //End case REPORT_ERROR 
        //Begin case RESEND_POST_DATA 
        Message resend = (Message) msg.getData().getParcelable("resend");
        //End case RESEND_POST_DATA 
        //Begin case RESEND_POST_DATA 
        Message dontResend = (Message) msg.getData().getParcelable("dontResend");
        //End case RESEND_POST_DATA 
        //Begin case RESEND_POST_DATA 
        {
            mWebViewClient.onFormResubmission(mWebView, dontResend,
                            resend);
        } //End block
        {
            dontResend.sendToTarget();
        } //End block
        //End case RESEND_POST_DATA 
        //Begin case OVERRIDE_URL 
        String overrideUrl = msg.getData().getString("url");
        //End case OVERRIDE_URL 
        //Begin case OVERRIDE_URL 
        boolean override = uiOverrideUrlLoading(overrideUrl);
        //End case OVERRIDE_URL 
        //Begin case OVERRIDE_URL 
        ResultTransport<Boolean> result = (ResultTransport<Boolean>) msg.obj;
        //End case OVERRIDE_URL 
        //Begin case OVERRIDE_URL 
        {
            result.setResult(override);
            notify();
        } //End block
        //End case OVERRIDE_URL 
        //Begin case AUTH_REQUEST 
        {
            HttpAuthHandler handler = (HttpAuthHandler) msg.obj;
            String host = msg.getData().getString("host");
            String realm = msg.getData().getString("realm");
            mWebViewClient.onReceivedHttpAuthRequest(mWebView, handler,
                            host, realm);
        } //End block
        //End case AUTH_REQUEST 
        //Begin case SSL_ERROR 
        {
            HashMap<String, Object> map = (HashMap<String, Object>) msg.obj;
            mWebViewClient.onReceivedSslError(mWebView,
                            (SslErrorHandler) map.get("handler"),
                            (SslError) map.get("error"));
        } //End block
        //End case SSL_ERROR 
        //Begin case PROCEEDED_AFTER_SSL_ERROR 
        {
            mWebViewClient.onProceededAfterSslError(mWebView,
                            (SslError) msg.obj);
        } //End block
        //End case PROCEEDED_AFTER_SSL_ERROR 
        //Begin case CLIENT_CERT_REQUEST 
        {
            HashMap<String, Object> map = (HashMap<String, Object>) msg.obj;
            mWebViewClient.onReceivedClientCertRequest(mWebView,
                            (ClientCertRequestHandler) map.get("handler"),
                            (String) map.get("host_and_port"));
        } //End block
        //End case CLIENT_CERT_REQUEST 
        //Begin case PROGRESS 
        {
            {
                mWebChromeClient.onProgressChanged(mWebView,
                                mLatestProgress);
            } //End block
            mProgressUpdatePending = false;
        } //End block
        //End case PROGRESS 
        //Begin case UPDATE_VISITED 
        {
            mWebViewClient.doUpdateVisitedHistory(mWebView,
                            (String) msg.obj, msg.arg1 != 0);
        } //End block
        //End case UPDATE_VISITED 
        //Begin case LOAD_RESOURCE 
        {
            mWebViewClient.onLoadResource(mWebView, (String) msg.obj);
        } //End block
        //End case LOAD_RESOURCE 
        //Begin case DOWNLOAD_FILE 
        {
            String url = msg.getData().getString("url");
            String userAgent = msg.getData().getString("userAgent");
            String contentDisposition = msg.getData().getString("contentDisposition");
            String mimetype = msg.getData().getString("mimetype");
            Long contentLength = msg.getData().getLong("contentLength");
            mDownloadListener.onDownloadStart(url, userAgent,
                            contentDisposition, mimetype, contentLength);
        } //End block
        //End case DOWNLOAD_FILE 
        //Begin case CREATE_WINDOW 
        {
            {
                boolean varCA4DEF2232E40AB74480F33C634607EF_1837991229 = (!mWebChromeClient.onCreateWindow(mWebView,
                                msg.arg1 == 1, msg.arg2 == 1,
                                (Message) msg.obj));
                {
                    {
                        notify();
                    } //End block
                } //End block
            } //End collapsed parenthetic
            mWebView.dismissZoomControl();
        } //End block
        //End case CREATE_WINDOW 
        //Begin case REQUEST_FOCUS 
        {
            mWebChromeClient.onRequestFocus(mWebView);
        } //End block
        //End case REQUEST_FOCUS 
        //Begin case CLOSE_WINDOW 
        {
            mWebChromeClient.onCloseWindow((WebView) msg.obj);
        } //End block
        //End case CLOSE_WINDOW 
        //Begin case SAVE_PASSWORD 
        Bundle bundle = msg.getData();
        //End case SAVE_PASSWORD 
        //Begin case SAVE_PASSWORD 
        String schemePlusHost = bundle.getString("host");
        //End case SAVE_PASSWORD 
        //Begin case SAVE_PASSWORD 
        String username = bundle.getString("username");
        //End case SAVE_PASSWORD 
        //Begin case SAVE_PASSWORD 
        String password = bundle.getString("password");
        //End case SAVE_PASSWORD 
        //Begin case SAVE_PASSWORD 
        {
            boolean var9F67D473B77F606385B1233B373B2F7E_543264131 = (!mWebView.onSavePassword(schemePlusHost, username, password,
                            (Message) msg.obj));
            {
                {
                    notify();
                } //End block
            } //End block
        } //End collapsed parenthetic
        //End case SAVE_PASSWORD 
        //Begin case ASYNC_KEYEVENTS 
        {
            mWebViewClient.onUnhandledKeyEvent(mWebView,
                            (KeyEvent) msg.obj);
        } //End block
        //End case ASYNC_KEYEVENTS 
        //Begin case EXCEEDED_DATABASE_QUOTA 
        {
            HashMap<String, Object> map = (HashMap<String, Object>) msg.obj;
            String databaseIdentifier = (String) map.get("databaseIdentifier");
            String url = (String) map.get("url");
            long currentQuota = ((Long) map.get("currentQuota")).longValue();
            long totalUsedQuota = ((Long) map.get("totalUsedQuota")).longValue();
            long estimatedSize = ((Long) map.get("estimatedSize")).longValue();
            WebStorage.QuotaUpdater quotaUpdater = (WebStorage.QuotaUpdater) map.get("quotaUpdater");
            mWebChromeClient.onExceededDatabaseQuota(url,
                            databaseIdentifier, currentQuota, estimatedSize,
                            totalUsedQuota, quotaUpdater);
        } //End block
        //End case EXCEEDED_DATABASE_QUOTA 
        //Begin case REACHED_APPCACHE_MAXSIZE 
        {
            HashMap<String, Object> map = (HashMap<String, Object>) msg.obj;
            long spaceNeeded = ((Long) map.get("spaceNeeded")).longValue();
            long totalUsedQuota = ((Long) map.get("totalUsedQuota")).longValue();
            WebStorage.QuotaUpdater quotaUpdater = (WebStorage.QuotaUpdater) map.get("quotaUpdater");
            mWebChromeClient.onReachedMaxAppCacheSize(spaceNeeded,
                            totalUsedQuota, quotaUpdater);
        } //End block
        //End case REACHED_APPCACHE_MAXSIZE 
        //Begin case GEOLOCATION_PERMISSIONS_SHOW_PROMPT 
        {
            HashMap<String, Object> map = (HashMap<String, Object>) msg.obj;
            String origin = (String) map.get("origin");
            GeolocationPermissions.Callback callback = (GeolocationPermissions.Callback)
                            map.get("callback");
            mWebChromeClient.onGeolocationPermissionsShowPrompt(origin,
                            callback);
        } //End block
        //End case GEOLOCATION_PERMISSIONS_SHOW_PROMPT 
        //Begin case GEOLOCATION_PERMISSIONS_HIDE_PROMPT 
        {
            mWebChromeClient.onGeolocationPermissionsHidePrompt();
        } //End block
        //End case GEOLOCATION_PERMISSIONS_HIDE_PROMPT 
        //Begin case JS_ALERT 
        {
            final JsResult res = (JsResult) msg.obj;
            String message = msg.getData().getString("message");
            String url = msg.getData().getString("url");
            {
                boolean var2B314E204AF90E9D5C262473E2474057_674011799 = (!mWebChromeClient.onJsAlert(mWebView, url, message,
                            res));
                {
                    {
                        boolean var4218353CEA22DDF22AB5EDE22089AF6A_382002749 = (!canShowAlertDialog());
                        {
                            res.cancel();
                            res.setReady();
                        } //End block
                    } //End collapsed parenthetic
                    new AlertDialog.Builder(mContext)
                                .setTitle(getJsDialogTitle(url))
                                .setMessage(message)
                                .setPositiveButton(R.string.ok,
                                        new DialogInterface.OnClickListener() {                        
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.066 -0400", hash_original_method = "05F12CF533E1857877A8AD104A11AF52", hash_generated_method = "1F29AD60BC0BF1F340E49E4138292CB4")
                        public void onClick(
                                                    DialogInterface dialog,
                                                    int which) {
                            //DSFIXME:  CODE0009: Possible callback target function detected
                            res.confirm();
                            addTaint(dialog.getTaint());
                            addTaint(which);
                            // ---------- Original Method ----------
                            //res.confirm();
                        }
})
                                .setOnCancelListener(
                                        new DialogInterface.OnCancelListener() {                        
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.066 -0400", hash_original_method = "B1C3BAB04B07B0569E11AD7C29C844EB", hash_generated_method = "C32F0B4F558DAFEB5877E20C8DAF7127")
                        public void onCancel(
                                                    DialogInterface dialog) {
                            //DSFIXME:  CODE0009: Possible callback target function detected
                            res.cancel();
                            addTaint(dialog.getTaint());
                            // ---------- Original Method ----------
                            //res.cancel();
                        }
})
                                .show();
                } //End block
            } //End collapsed parenthetic
            res.setReady();
        } //End block
        //End case JS_ALERT 
        //Begin case JS_CONFIRM 
        {
            final JsResult res = (JsResult) msg.obj;
            String message = msg.getData().getString("message");
            String url = msg.getData().getString("url");
            {
                boolean varCEC3E2F96978ADAB5E3F04F9703AB0A2_1551888694 = (!mWebChromeClient.onJsConfirm(mWebView, url, message,
                            res));
                {
                    {
                        boolean var4218353CEA22DDF22AB5EDE22089AF6A_1538685835 = (!canShowAlertDialog());
                        {
                            res.cancel();
                            res.setReady();
                        } //End block
                    } //End collapsed parenthetic
                    new AlertDialog.Builder(mContext)
                                .setTitle(getJsDialogTitle(url))
                                .setMessage(message)
                                .setPositiveButton(R.string.ok,
                                        new DialogInterface.OnClickListener() {                        
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.067 -0400", hash_original_method = "05F12CF533E1857877A8AD104A11AF52", hash_generated_method = "1F29AD60BC0BF1F340E49E4138292CB4")
                        public void onClick(
                                                    DialogInterface dialog,
                                                    int which) {
                            //DSFIXME:  CODE0009: Possible callback target function detected
                            res.confirm();
                            addTaint(dialog.getTaint());
                            addTaint(which);
                            // ---------- Original Method ----------
                            //res.confirm();
                        }
})
                                .setNegativeButton(R.string.cancel,
                                        new DialogInterface.OnClickListener() {                        
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.068 -0400", hash_original_method = "E8564283849E341A10A9BCD809087039", hash_generated_method = "21F6D49BEE715812EFE3D95DC59D8862")
                        public void onClick(
                                                    DialogInterface dialog,
                                                    int which) {
                            //DSFIXME:  CODE0009: Possible callback target function detected
                            res.cancel();
                            addTaint(dialog.getTaint());
                            addTaint(which);
                            // ---------- Original Method ----------
                            //res.cancel();
                        }
})
                                .setOnCancelListener(
                                        new DialogInterface.OnCancelListener() {                        
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.068 -0400", hash_original_method = "B1C3BAB04B07B0569E11AD7C29C844EB", hash_generated_method = "C32F0B4F558DAFEB5877E20C8DAF7127")
                        public void onCancel(
                                                    DialogInterface dialog) {
                            //DSFIXME:  CODE0009: Possible callback target function detected
                            res.cancel();
                            addTaint(dialog.getTaint());
                            // ---------- Original Method ----------
                            //res.cancel();
                        }
})
                                .show();
                } //End block
            } //End collapsed parenthetic
            res.setReady();
        } //End block
        //End case JS_CONFIRM 
        //Begin case JS_PROMPT 
        {
            final JsPromptResult res = (JsPromptResult) msg.obj;
            String message = msg.getData().getString("message");
            String defaultVal = msg.getData().getString("default");
            String url = msg.getData().getString("url");
            {
                boolean varD1458F3A7A7296BB0B89C4571E6E6E68_2079468758 = (!mWebChromeClient.onJsPrompt(mWebView, url, message,
                                defaultVal, res));
                {
                    {
                        boolean var4218353CEA22DDF22AB5EDE22089AF6A_1274405500 = (!canShowAlertDialog());
                        {
                            res.cancel();
                            res.setReady();
                        } //End block
                    } //End collapsed parenthetic
                    final LayoutInflater factory = LayoutInflater
                                .from(mContext);
                    final View view = factory.inflate(R.layout.js_prompt,
                                null);
                    final EditText v = (EditText) view
                                .findViewById(R.id.value);
                    v.setText(defaultVal);
                    ((TextView) view.findViewById(R.id.message))
                                .setText(message);
                    new AlertDialog.Builder(mContext)
                                .setTitle(getJsDialogTitle(url))
                                .setView(view)
                                .setPositiveButton(R.string.ok,
                                        new DialogInterface.OnClickListener() {                        
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.069 -0400", hash_original_method = "0D058E55C4ABCB67B49D4279EABD89A8", hash_generated_method = "892DACC8E5C649E0DE4B32D15CD22534")
                        public void onClick(
                                                    DialogInterface dialog,
                                                    int whichButton) {
                            //DSFIXME:  CODE0009: Possible callback target function detected
                            res.confirm(v.getText()
                                                        .toString());
                            addTaint(dialog.getTaint());
                            addTaint(whichButton);
                            // ---------- Original Method ----------
                            //res.confirm(v.getText()
                                                        //.toString());
                        }
})
                                .setNegativeButton(R.string.cancel,
                                        new DialogInterface.OnClickListener() {                        
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.069 -0400", hash_original_method = "862A9D411C13397AC08A0EA3C0A3F1C1", hash_generated_method = "6F8C25B774469226F5E1108116AFA52D")
                        public void onClick(
                                                    DialogInterface dialog,
                                                    int whichButton) {
                            //DSFIXME:  CODE0009: Possible callback target function detected
                            res.cancel();
                            addTaint(dialog.getTaint());
                            addTaint(whichButton);
                            // ---------- Original Method ----------
                            //res.cancel();
                        }
})
                                .setOnCancelListener(
                                        new DialogInterface.OnCancelListener() {                        
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.070 -0400", hash_original_method = "B1C3BAB04B07B0569E11AD7C29C844EB", hash_generated_method = "C32F0B4F558DAFEB5877E20C8DAF7127")
                        public void onCancel(
                                                    DialogInterface dialog) {
                            //DSFIXME:  CODE0009: Possible callback target function detected
                            res.cancel();
                            addTaint(dialog.getTaint());
                            // ---------- Original Method ----------
                            //res.cancel();
                        }
})
                                .show();
                } //End block
            } //End collapsed parenthetic
            res.setReady();
        } //End block
        //End case JS_PROMPT 
        //Begin case JS_UNLOAD 
        {
            final JsResult res = (JsResult) msg.obj;
            String message = msg.getData().getString("message");
            String url = msg.getData().getString("url");
            {
                boolean var8ABC06169F6D42F5FE298C298209BC4D_2108936074 = (!mWebChromeClient.onJsBeforeUnload(mWebView, url,
                            message, res));
                {
                    {
                        boolean var4218353CEA22DDF22AB5EDE22089AF6A_1434749854 = (!canShowAlertDialog());
                        {
                            res.cancel();
                            res.setReady();
                        } //End block
                    } //End collapsed parenthetic
                    final String m = mContext.getString(
                                R.string.js_dialog_before_unload, message);
                    new AlertDialog.Builder(mContext)
                                .setMessage(m)
                                .setPositiveButton(R.string.ok,
                                        new DialogInterface.OnClickListener() {                        
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.071 -0400", hash_original_method = "05F12CF533E1857877A8AD104A11AF52", hash_generated_method = "1F29AD60BC0BF1F340E49E4138292CB4")
                        public void onClick(
                                                    DialogInterface dialog,
                                                    int which) {
                            //DSFIXME:  CODE0009: Possible callback target function detected
                            res.confirm();
                            addTaint(dialog.getTaint());
                            addTaint(which);
                            // ---------- Original Method ----------
                            //res.confirm();
                        }
})
                                .setNegativeButton(R.string.cancel,
                                        new DialogInterface.OnClickListener() {                        
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.071 -0400", hash_original_method = "E8564283849E341A10A9BCD809087039", hash_generated_method = "21F6D49BEE715812EFE3D95DC59D8862")
                        public void onClick(
                                                    DialogInterface dialog,
                                                    int which) {
                            //DSFIXME:  CODE0009: Possible callback target function detected
                            res.cancel();
                            addTaint(dialog.getTaint());
                            addTaint(which);
                            // ---------- Original Method ----------
                            //res.cancel();
                        }
})
                                .show();
                } //End block
            } //End collapsed parenthetic
            res.setReady();
        } //End block
        //End case JS_UNLOAD 
        //Begin case JS_TIMEOUT 
        {
            final JsResult res = (JsResult) msg.obj;
            {
                boolean var7D789827BC3613BFFF7C61EDCD02B4DD_23524057 = (mWebChromeClient.onJsTimeout());
                {
                    res.confirm();
                } //End block
                {
                    res.cancel();
                } //End block
            } //End collapsed parenthetic
            res.setReady();
        } //End block
        //End case JS_TIMEOUT 
        //Begin case RECEIVED_CERTIFICATE 
        mWebView.setCertificate((SslCertificate) msg.obj);
        //End case RECEIVED_CERTIFICATE 
        //Begin case NOTIFY 
        {
            notify();
        } //End block
        //End case NOTIFY 
        //Begin case SCALE_CHANGED 
        {
            mWebViewClient.onScaleChanged(mWebView, msg.getData()
                            .getFloat("old"), msg.getData().getFloat("new"));
        } //End block
        //End case SCALE_CHANGED 
        //Begin case SWITCH_OUT_HISTORY 
        mWebView.switchOutDrawHistory();
        //End case SWITCH_OUT_HISTORY 
        //Begin case ADD_MESSAGE_TO_CONSOLE 
        String message = msg.getData().getString("message");
        //End case ADD_MESSAGE_TO_CONSOLE 
        //Begin case ADD_MESSAGE_TO_CONSOLE 
        String sourceID = msg.getData().getString("sourceID");
        //End case ADD_MESSAGE_TO_CONSOLE 
        //Begin case ADD_MESSAGE_TO_CONSOLE 
        int lineNumber = msg.getData().getInt("lineNumber");
        //End case ADD_MESSAGE_TO_CONSOLE 
        //Begin case ADD_MESSAGE_TO_CONSOLE 
        int msgLevel = msg.getData().getInt("msgLevel");
        //End case ADD_MESSAGE_TO_CONSOLE 
        //Begin case ADD_MESSAGE_TO_CONSOLE 
        int numberOfMessageLevels = ConsoleMessage.MessageLevel.values().length;
        //End case ADD_MESSAGE_TO_CONSOLE 
        //Begin case ADD_MESSAGE_TO_CONSOLE 
        {
            msgLevel = 0;
        } //End block
        //End case ADD_MESSAGE_TO_CONSOLE 
        //Begin case ADD_MESSAGE_TO_CONSOLE 
        ConsoleMessage.MessageLevel messageLevel = ConsoleMessage.MessageLevel.values()[msgLevel];
        //End case ADD_MESSAGE_TO_CONSOLE 
        //Begin case ADD_MESSAGE_TO_CONSOLE 
        {
            boolean var03B98152D53A46B45BCC62B17A0B0B34_1461043193 = (!mWebChromeClient.onConsoleMessage(new ConsoleMessage(message, sourceID,
                        lineNumber, messageLevel)));
            {
                String logTag = "Web Console";
                String logMessage = message + " at " + sourceID + ":" + lineNumber;
                //Begin case DEBUG 
                Log.d(logTag, logMessage);
                //End case DEBUG 
            } //End block
        } //End collapsed parenthetic
        //End case ADD_MESSAGE_TO_CONSOLE 
        //Begin case GET_VISITED_HISTORY 
        {
            mWebChromeClient.getVisitedHistory((ValueCallback<String[]>)msg.obj);
        } //End block
        //End case GET_VISITED_HISTORY 
        //Begin case OPEN_FILE_CHOOSER 
        {
            UploadFileMessageData data = (UploadFileMessageData)msg.obj;
            mWebChromeClient.openFileChooser(data.getUploadFile(), data.getAcceptType());
        } //End block
        //End case OPEN_FILE_CHOOSER 
        //Begin case ADD_HISTORY_ITEM 
        {
            mWebBackForwardListClient.onNewHistoryItem(
                            (WebHistoryItem) msg.obj);
        } //End block
        //End case ADD_HISTORY_ITEM 
        //Begin case HISTORY_INDEX_CHANGED 
        {
            mWebBackForwardListClient.onIndexChanged(
                            (WebHistoryItem) msg.obj, msg.arg1);
        } //End block
        //End case HISTORY_INDEX_CHANGED 
        //Begin case AUTH_CREDENTIALS 
        {
            String host = msg.getData().getString("host");
            String realm = msg.getData().getString("realm");
            username = msg.getData().getString("username");
            password = msg.getData().getString("password");
            mWebView.setHttpAuthUsernamePassword(
                        host, realm, username, password);
        } //End block
        //End case AUTH_CREDENTIALS 
        //Begin case SET_INSTALLABLE_WEBAPP 
        {
            mWebChromeClient.setInstallableWebApp();
        } //End block
        //End case SET_INSTALLABLE_WEBAPP 
        //Begin case NOTIFY_SEARCHBOX_LISTENERS 
        {
            SearchBoxImpl searchBox = (SearchBoxImpl) mWebView.getSearchBox();
            @SuppressWarnings("unchecked") List<String> suggestions = (List<String>) msg.obj;
            searchBox.handleSuggestions(msg.getData().getString("query"), suggestions);
        } //End block
        //End case NOTIFY_SEARCHBOX_LISTENERS 
        //Begin case AUTO_LOGIN 
        {
            {
                String realm = msg.getData().getString("realm");
                String account = msg.getData().getString("account");
                String args = msg.getData().getString("args");
                mWebViewClient.onReceivedLoginRequest(mWebView, realm,
                            account, args);
            } //End block
        } //End block
        //End case AUTO_LOGIN 
        //Begin case SEARCHBOX_IS_SUPPORTED_CALLBACK 
        {
            SearchBoxImpl searchBox = (SearchBoxImpl) mWebView.getSearchBox();
            Boolean supported = (Boolean) msg.obj;
            searchBox.handleIsSupportedCallback(supported);
        } //End block
        //End case SEARCHBOX_IS_SUPPORTED_CALLBACK 
        //Begin case SEARCHBOX_DISPATCH_COMPLETE_CALLBACK 
        {
            SearchBoxImpl searchBox = (SearchBoxImpl) mWebView.getSearchBox();
            Boolean success = (Boolean) msg.obj;
            searchBox.handleDispatchCompleteCallback(msg.getData().getString("function"),
                        msg.getData().getInt("id"), success);
        } //End block
        //End case SEARCHBOX_DISPATCH_COMPLETE_CALLBACK 
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.075 -0400", hash_original_method = "F4FA55F4EB9CE414FB8C02AF96B11745", hash_generated_method = "78E1895197F875382402A67B11C8183D")
    public int getProgress() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2080931953 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2080931953;
        // ---------- Original Method ----------
        //return mLatestProgress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.076 -0400", hash_original_method = "ADEA75F6BB5426452E05F86965232852", hash_generated_method = "1E917B7774EEA475E723DB7EC0CF755D")
     void switchOutDrawHistory() {
        sendMessage(obtainMessage(SWITCH_OUT_HISTORY));
        // ---------- Original Method ----------
        //sendMessage(obtainMessage(SWITCH_OUT_HISTORY));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.077 -0400", hash_original_method = "2F62F4E531DE0AF4C82D66205801E78A", hash_generated_method = "AFB1E83EA4649AF4B4F1E22BDC14F11D")
    private String getJsDialogTitle(String url) {
        String varB4EAC82CA7396A68D541C85D26508E83_828131057 = null; //Variable for return #1
        String title = url;
        {
            boolean var85E84E44E3BDEA9917ECB02744CCBE14_1557498496 = (URLUtil.isDataUrl(url));
            {
                title = mContext.getString(R.string.js_dialog_title_default);
            } //End block
            {
                try 
                {
                    URL aUrl = new URL(url);
                    title = mContext.getString(R.string.js_dialog_title,
                        aUrl.getProtocol() + "://" + aUrl.getHost());
                } //End block
                catch (MalformedURLException ex)
                { }
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_828131057 = title;
        addTaint(url.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_828131057.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_828131057;
        // ---------- Original Method ----------
        //String title = url;
        //if (URLUtil.isDataUrl(url)) {
            //title = mContext.getString(R.string.js_dialog_title_default);
        //} else {
            //try {
                //URL aUrl = new URL(url);
                //title = mContext.getString(R.string.js_dialog_title,
                        //aUrl.getProtocol() + "://" + aUrl.getHost());
            //} catch (MalformedURLException ex) {
            //}
        //}
        //return title;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.077 -0400", hash_original_method = "FEA38F8F6B5615AC736396CA90380013", hash_generated_method = "C096975B52E68C5482F2BA9308854A2B")
    public void onPageStarted(String url, Bitmap favicon) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            mWebCoreThreadTime = SystemClock.currentThreadTimeMillis();
            mWebCoreIdleTime = 0;
            Network.getInstance(mContext).startTiming();
        } //End block
        Message msg = obtainMessage(PAGE_STARTED);
        msg.obj = favicon;
        msg.getData().putString("url", url);
        sendMessage(msg);
        addTaint(url.getTaint());
        addTaint(favicon.getTaint());
        // ---------- Original Method ----------
        //if (PERF_PROBE) {
            //mWebCoreThreadTime = SystemClock.currentThreadTimeMillis();
            //mWebCoreIdleTime = 0;
            //Network.getInstance(mContext).startTiming();
        //}
        //Message msg = obtainMessage(PAGE_STARTED);
        //msg.obj = favicon;
        //msg.getData().putString("url", url);
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.077 -0400", hash_original_method = "0C202F92443A2E2B58845ECCCDAD23DA", hash_generated_method = "A322C578E63C13E64FDD85CD5E3DF118")
    public void onPageFinished(String url) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            Log.d("WebCore", "WebCore thread used " +
                    (SystemClock.currentThreadTimeMillis() - mWebCoreThreadTime)
                    + " ms and idled " + mWebCoreIdleTime + " ms");
            Network.getInstance(mContext).stopTiming();
        } //End block
        Message msg = obtainMessage(PAGE_FINISHED, url);
        sendMessage(msg);
        addTaint(url.getTaint());
        // ---------- Original Method ----------
        //if (PERF_PROBE) {
            //Log.d("WebCore", "WebCore thread used " +
                    //(SystemClock.currentThreadTimeMillis() - mWebCoreThreadTime)
                    //+ " ms and idled " + mWebCoreIdleTime + " ms");
            //Network.getInstance(mContext).stopTiming();
        //}
        //Message msg = obtainMessage(PAGE_FINISHED, url);
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.078 -0400", hash_original_method = "CAA94892A4D7B008F19D8BD2AD9FB2D3", hash_generated_method = "BE74632F1B3FA1B5D7F38007511162FF")
    public void onTooManyRedirects(Message cancelMsg, Message continueMsg) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(cancelMsg.getTaint());
        addTaint(continueMsg.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.078 -0400", hash_original_method = "E5C6F1F12DEE48235072B52E91052ED8", hash_generated_method = "BD34DA0D00B550669CFC1B18A8E7C6D4")
    public void onReceivedError(int errorCode, String description,
            String failingUrl) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Message msg = obtainMessage(REPORT_ERROR);
        msg.arg1 = errorCode;
        msg.getData().putString("description", description);
        msg.getData().putString("failingUrl", failingUrl);
        sendMessage(msg);
        addTaint(errorCode);
        addTaint(description.getTaint());
        addTaint(failingUrl.getTaint());
        // ---------- Original Method ----------
        //if (mWebViewClient == null) {
            //return;
        //}
        //Message msg = obtainMessage(REPORT_ERROR);
        //msg.arg1 = errorCode;
        //msg.getData().putString("description", description);
        //msg.getData().putString("failingUrl", failingUrl);
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.079 -0400", hash_original_method = "5E30734A74D85B2FEB399A04359A0FF5", hash_generated_method = "9B72D03A5B92C475CE49542F839FC10A")
    public void onFormResubmission(Message dontResend,
            Message resend) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            dontResend.sendToTarget();
        } //End block
        Message msg = obtainMessage(RESEND_POST_DATA);
        Bundle bundle = msg.getData();
        bundle.putParcelable("resend", resend);
        bundle.putParcelable("dontResend", dontResend);
        sendMessage(msg);
        addTaint(dontResend.getTaint());
        addTaint(resend.getTaint());
        // ---------- Original Method ----------
        //if (mWebViewClient == null) {
            //dontResend.sendToTarget();
            //return;
        //}
        //Message msg = obtainMessage(RESEND_POST_DATA);
        //Bundle bundle = msg.getData();
        //bundle.putParcelable("resend", resend);
        //bundle.putParcelable("dontResend", dontResend);
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.079 -0400", hash_original_method = "6A31F6EEFC7A56081588A72CFCF2411E", hash_generated_method = "0AD86D0C4F2FF2D9D15669E765DA218E")
    public boolean shouldOverrideUrlLoading(String url) {
        ResultTransport<Boolean> res = new ResultTransport<Boolean>(false);
        Message msg = obtainMessage(OVERRIDE_URL);
        msg.getData().putString("url", url);
        msg.obj = res;
        {
            sendMessage(msg);
            try 
            {
                wait();
            } //End block
            catch (InterruptedException e)
            { }
        } //End block
        boolean var6024FD61AC5A91282342DCCBC3601D4F_1415360067 = (res.getResult().booleanValue());
        addTaint(url.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_564141344 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_564141344;
        // ---------- Original Method ----------
        //ResultTransport<Boolean> res = new ResultTransport<Boolean>(false);
        //Message msg = obtainMessage(OVERRIDE_URL);
        //msg.getData().putString("url", url);
        //msg.obj = res;
        //synchronized (this) {
            //sendMessage(msg);
            //try {
                //wait();
            //} catch (InterruptedException e) {
                //Log.e(LOGTAG, "Caught exception while waiting for overrideUrl");
                //Log.e(LOGTAG, Log.getStackTraceString(e));
            //}
        //}
        //return res.getResult().booleanValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.080 -0400", hash_original_method = "4FA57A455CA03EC6D649ED38E4E56F01", hash_generated_method = "62C07D83E2187042684771DDB994DD7D")
    public void onReceivedHttpAuthRequest(HttpAuthHandler handler,
            String hostName, String realmName) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            handler.cancel();
        } //End block
        Message msg = obtainMessage(AUTH_REQUEST, handler);
        msg.getData().putString("host", hostName);
        msg.getData().putString("realm", realmName);
        sendMessage(msg);
        addTaint(handler.getTaint());
        addTaint(hostName.getTaint());
        addTaint(realmName.getTaint());
        // ---------- Original Method ----------
        //if (mWebViewClient == null) {
            //handler.cancel();
            //return;
        //}
        //Message msg = obtainMessage(AUTH_REQUEST, handler);
        //msg.getData().putString("host", hostName);
        //msg.getData().putString("realm", realmName);
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.080 -0400", hash_original_method = "8BC2AAF24BCB58C98055A520D9453CBA", hash_generated_method = "A69423B1BB52E10C4A27254FA23F619B")
    public void onReceivedSslError(SslErrorHandler handler, SslError error) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            handler.cancel();
        } //End block
        Message msg = obtainMessage(SSL_ERROR);
        HashMap<String, Object> map = new HashMap();
        map.put("handler", handler);
        map.put("error", error);
        msg.obj = map;
        sendMessage(msg);
        addTaint(handler.getTaint());
        addTaint(error.getTaint());
        // ---------- Original Method ----------
        //if (mWebViewClient == null) {
            //handler.cancel();
            //return;
        //}
        //Message msg = obtainMessage(SSL_ERROR);
        //HashMap<String, Object> map = new HashMap();
        //map.put("handler", handler);
        //map.put("error", error);
        //msg.obj = map;
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.080 -0400", hash_original_method = "024A377297E93EBA7DF0A134D94D78F7", hash_generated_method = "4018DE15A1C6FAA5459C11E14FEF89F2")
    public void onProceededAfterSslError(SslError error) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Message msg = obtainMessage(PROCEEDED_AFTER_SSL_ERROR);
        msg.obj = error;
        sendMessage(msg);
        addTaint(error.getTaint());
        // ---------- Original Method ----------
        //if (mWebViewClient == null) {
            //return;
        //}
        //Message msg = obtainMessage(PROCEEDED_AFTER_SSL_ERROR);
        //msg.obj = error;
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.081 -0400", hash_original_method = "86B49DF771A8EEA4B9DCFCD28BAACF5B", hash_generated_method = "94BF8FB21B85A1A429BD29B5DE5A6BFF")
    public void onReceivedClientCertRequest(ClientCertRequestHandler handler, String host_and_port) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            handler.cancel();
        } //End block
        Message msg = obtainMessage(CLIENT_CERT_REQUEST);
        HashMap<String, Object> map = new HashMap();
        map.put("handler", handler);
        map.put("host_and_port", host_and_port);
        msg.obj = map;
        sendMessage(msg);
        addTaint(handler.getTaint());
        addTaint(host_and_port.getTaint());
        // ---------- Original Method ----------
        //if (mWebViewClient == null) {
            //handler.cancel();
            //return;
        //}
        //Message msg = obtainMessage(CLIENT_CERT_REQUEST);
        //HashMap<String, Object> map = new HashMap();
        //map.put("handler", handler);
        //map.put("host_and_port", host_and_port);
        //msg.obj = map;
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.081 -0400", hash_original_method = "39DDC3E15586955BE54A8DF95CFEEEEF", hash_generated_method = "33FBB913AA6B1433E152E56F557F2973")
    public void onReceivedCertificate(SslCertificate certificate) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        sendMessage(obtainMessage(RECEIVED_CERTIFICATE, certificate));
        addTaint(certificate.getTaint());
        // ---------- Original Method ----------
        //sendMessage(obtainMessage(RECEIVED_CERTIFICATE, certificate));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.082 -0400", hash_original_method = "1419AC91B69314146C4F39503A4D545B", hash_generated_method = "257A621515819E761A5E847C2CC1AD7C")
    public void doUpdateVisitedHistory(String url, boolean isReload) {
        sendMessage(obtainMessage(UPDATE_VISITED, isReload ? 1 : 0, 0, url));
        addTaint(url.getTaint());
        addTaint(isReload);
        // ---------- Original Method ----------
        //if (mWebViewClient == null) {
            //return;
        //}
        //sendMessage(obtainMessage(UPDATE_VISITED, isReload ? 1 : 0, 0, url));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.083 -0400", hash_original_method = "E95ED4984215917AB442D7D69416BDAD", hash_generated_method = "4DC463149002EC5D46AA9CE3E993C71F")
     WebResourceResponse shouldInterceptRequest(String url) {
        WebResourceResponse varB4EAC82CA7396A68D541C85D26508E83_2082072250 = null; //Variable for return #1
        WebResourceResponse varB4EAC82CA7396A68D541C85D26508E83_1444001702 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_2082072250 = null;
        } //End block
        WebResourceResponse r = mWebViewClient.shouldInterceptRequest(mWebView, url);
        {
            sendMessage(obtainMessage(LOAD_RESOURCE, url));
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1444001702 = r;
        addTaint(url.getTaint());
        WebResourceResponse varA7E53CE21691AB073D9660D615818899_1604671399; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1604671399 = varB4EAC82CA7396A68D541C85D26508E83_2082072250;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1604671399 = varB4EAC82CA7396A68D541C85D26508E83_1444001702;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1604671399.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1604671399;
        // ---------- Original Method ----------
        //if (mWebViewClient == null) {
            //return null;
        //}
        //WebResourceResponse r =
                //mWebViewClient.shouldInterceptRequest(mWebView, url);
        //if (r == null) {
            //sendMessage(obtainMessage(LOAD_RESOURCE, url));
        //}
        //return r;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.084 -0400", hash_original_method = "AE6FAC3658CBE746F7970ADD50E1DD7A", hash_generated_method = "658FA0B0A870AD6482851ADC8C29B091")
    public void onUnhandledKeyEvent(KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        sendMessage(obtainMessage(ASYNC_KEYEVENTS, event));
        addTaint(event.getTaint());
        // ---------- Original Method ----------
        //if (mWebViewClient == null) {
            //return;
        //}
        //sendMessage(obtainMessage(ASYNC_KEYEVENTS, event));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.085 -0400", hash_original_method = "32F0A585D03AD391628455766053FDEF", hash_generated_method = "F4E7FCC685EEE3086AACD4AD610CE9C4")
    public void onScaleChanged(float oldScale, float newScale) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Message msg = obtainMessage(SCALE_CHANGED);
        Bundle bundle = msg.getData();
        bundle.putFloat("old", oldScale);
        bundle.putFloat("new", newScale);
        sendMessage(msg);
        addTaint(oldScale);
        addTaint(newScale);
        // ---------- Original Method ----------
        //if (mWebViewClient == null) {
            //return;
        //}
        //Message msg = obtainMessage(SCALE_CHANGED);
        //Bundle bundle = msg.getData();
        //bundle.putFloat("old", oldScale);
        //bundle.putFloat("new", newScale);
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.085 -0400", hash_original_method = "96CFDF49B56568DC278F123893B1481C", hash_generated_method = "E3CEFF5A3361D77264E3194C256B5A92")
     void onReceivedLoginRequest(String realm, String account, String args) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Message msg = obtainMessage(AUTO_LOGIN);
        Bundle bundle = msg.getData();
        bundle.putString("realm", realm);
        bundle.putString("account", account);
        bundle.putString("args", args);
        sendMessage(msg);
        addTaint(realm.getTaint());
        addTaint(account.getTaint());
        addTaint(args.getTaint());
        // ---------- Original Method ----------
        //if (mWebViewClient == null) {
            //return;
        //}
        //Message msg = obtainMessage(AUTO_LOGIN);
        //Bundle bundle = msg.getData();
        //bundle.putString("realm", realm);
        //bundle.putString("account", account);
        //bundle.putString("args", args);
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.086 -0400", hash_original_method = "757A7F1755FBEFCF499F2AF609552311", hash_generated_method = "53FD441F7CC6409BB741A73AFDC6C89E")
    public boolean onDownloadStart(String url, String userAgent,
            String contentDisposition, String mimetype, long contentLength) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Message msg = obtainMessage(DOWNLOAD_FILE);
        Bundle bundle = msg.getData();
        bundle.putString("url", url);
        bundle.putString("userAgent", userAgent);
        bundle.putString("mimetype", mimetype);
        bundle.putLong("contentLength", contentLength);
        bundle.putString("contentDisposition", contentDisposition);
        sendMessage(msg);
        addTaint(url.getTaint());
        addTaint(userAgent.getTaint());
        addTaint(contentDisposition.getTaint());
        addTaint(mimetype.getTaint());
        addTaint(contentLength);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_422491588 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_422491588;
        // ---------- Original Method ----------
        //if (mDownloadListener == null) {
            //return false;
        //}
        //Message msg = obtainMessage(DOWNLOAD_FILE);
        //Bundle bundle = msg.getData();
        //bundle.putString("url", url);
        //bundle.putString("userAgent", userAgent);
        //bundle.putString("mimetype", mimetype);
        //bundle.putLong("contentLength", contentLength);
        //bundle.putString("contentDisposition", contentDisposition);
        //sendMessage(msg);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.086 -0400", hash_original_method = "E36C2E9038F101EB831B9776820C94AF", hash_generated_method = "EDDFEFA54167482C7C328DEE4DB86840")
    public boolean onSavePassword(String schemePlusHost, String username,
            String password, Message resumeMsg) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            junit.framework.Assert.assertNull(resumeMsg);
        } //End block
        resumeMsg = obtainMessage(NOTIFY);
        Message msg = obtainMessage(SAVE_PASSWORD, resumeMsg);
        Bundle bundle = msg.getData();
        bundle.putString("host", schemePlusHost);
        bundle.putString("username", username);
        bundle.putString("password", password);
        {
            sendMessage(msg);
            try 
            {
                wait();
            } //End block
            catch (InterruptedException e)
            { }
        } //End block
        addTaint(schemePlusHost.getTaint());
        addTaint(username.getTaint());
        addTaint(password.getTaint());
        addTaint(resumeMsg.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1999461723 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1999461723;
        // ---------- Original Method ----------
        //if (DebugFlags.CALLBACK_PROXY) {
            //junit.framework.Assert.assertNull(resumeMsg);
        //}
        //resumeMsg = obtainMessage(NOTIFY);
        //Message msg = obtainMessage(SAVE_PASSWORD, resumeMsg);
        //Bundle bundle = msg.getData();
        //bundle.putString("host", schemePlusHost);
        //bundle.putString("username", username);
        //bundle.putString("password", password);
        //synchronized (this) {
            //sendMessage(msg);
            //try {
                //wait();
            //} catch (InterruptedException e) {
                //Log.e(LOGTAG,
                        //"Caught exception while waiting for onSavePassword");
                //Log.e(LOGTAG, Log.getStackTraceString(e));
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.087 -0400", hash_original_method = "FE09891259ADB46761F758E0F5C88D74", hash_generated_method = "38F9806EBABF402E099624DADCC359D5")
    public void onReceivedHttpAuthCredentials(String host, String realm,
            String username, String password) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Message msg = obtainMessage(AUTH_CREDENTIALS);
        msg.getData().putString("host", host);
        msg.getData().putString("realm", realm);
        msg.getData().putString("username", username);
        msg.getData().putString("password", password);
        sendMessage(msg);
        addTaint(host.getTaint());
        addTaint(realm.getTaint());
        addTaint(username.getTaint());
        addTaint(password.getTaint());
        // ---------- Original Method ----------
        //Message msg = obtainMessage(AUTH_CREDENTIALS);
        //msg.getData().putString("host", host);
        //msg.getData().putString("realm", realm);
        //msg.getData().putString("username", username);
        //msg.getData().putString("password", password);
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.087 -0400", hash_original_method = "7D23376057076E49A1BAAD127CCE1E2E", hash_generated_method = "86A073D29B5DA25423D75C510737D1A1")
    public void onProgressChanged(int newProgress) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            mLatestProgress = newProgress;
            {
                sendEmptyMessage(PROGRESS);
                mProgressUpdatePending = true;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mLatestProgress == newProgress) {
                //return;
            //}
            //mLatestProgress = newProgress;
            //if (mWebChromeClient == null) {
                //return;
            //}
            //if (!mProgressUpdatePending) {
                //sendEmptyMessage(PROGRESS);
                //mProgressUpdatePending = true;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.088 -0400", hash_original_method = "B29F2764BB6A56E843DFC7CBC2F6C034", hash_generated_method = "93C8844A4AD830E7C00AB2CA4753867E")
    public BrowserFrame createWindow(boolean dialog, boolean userGesture) {
        BrowserFrame varB4EAC82CA7396A68D541C85D26508E83_561140437 = null; //Variable for return #1
        BrowserFrame varB4EAC82CA7396A68D541C85D26508E83_567650723 = null; //Variable for return #2
        BrowserFrame varB4EAC82CA7396A68D541C85D26508E83_1375582294 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_561140437 = null;
        } //End block
        WebView.WebViewTransport transport = mWebView.new WebViewTransport();
        final Message msg = obtainMessage(NOTIFY);
        msg.obj = transport;
        {
            sendMessage(obtainMessage(CREATE_WINDOW, dialog ? 1 : 0,
                    userGesture ? 1 : 0, msg));
            try 
            {
                wait();
            } //End block
            catch (InterruptedException e)
            { }
        } //End block
        WebView w = transport.getWebView();
        {
            WebViewCore core = w.getWebViewCore();
            {
                core.initializeSubwindow();
                varB4EAC82CA7396A68D541C85D26508E83_567650723 = core.getBrowserFrame();
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1375582294 = null;
        addTaint(dialog);
        addTaint(userGesture);
        BrowserFrame varA7E53CE21691AB073D9660D615818899_1659768757; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1659768757 = varB4EAC82CA7396A68D541C85D26508E83_561140437;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1659768757 = varB4EAC82CA7396A68D541C85D26508E83_567650723;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1659768757 = varB4EAC82CA7396A68D541C85D26508E83_1375582294;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1659768757.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1659768757;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.088 -0400", hash_original_method = "08655C1DEC40A72DA93F91A66B628CEC", hash_generated_method = "C28AD6A771B27FBA7D6F33F7DD8ED015")
    public void onRequestFocus() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        sendEmptyMessage(REQUEST_FOCUS);
        // ---------- Original Method ----------
        //if (mWebChromeClient == null) {
            //return;
        //}
        //sendEmptyMessage(REQUEST_FOCUS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.089 -0400", hash_original_method = "6FD913BE3AA43F9AAEFF1CB8B9D39A33", hash_generated_method = "2904D76E9340B830141B570CC5A06D2B")
    public void onCloseWindow(WebView window) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        sendMessage(obtainMessage(CLOSE_WINDOW, window));
        addTaint(window.getTaint());
        // ---------- Original Method ----------
        //if (mWebChromeClient == null) {
            //return;
        //}
        //sendMessage(obtainMessage(CLOSE_WINDOW, window));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.089 -0400", hash_original_method = "F08C9B8424214ACDF6DD6A6D99BF0681", hash_generated_method = "B9E11387C568ADD8B22A8B5187D889CC")
    public void onReceivedIcon(Bitmap icon) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        WebHistoryItem i = mBackForwardList.getCurrentItem();
        {
            i.setFavicon(icon);
        } //End block
        sendMessage(obtainMessage(RECEIVED_ICON, icon));
        addTaint(icon.getTaint());
        // ---------- Original Method ----------
        //WebHistoryItem i = mBackForwardList.getCurrentItem();
        //if (i != null) {
            //i.setFavicon(icon);
        //}
        //if (mWebChromeClient == null) {
            //return;
        //}
        //sendMessage(obtainMessage(RECEIVED_ICON, icon));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.089 -0400", hash_original_method = "F0350B43E0ECCB1BDA5D312CA7F06F8A", hash_generated_method = "21AA562348BAE0F6DB11503C68B35C50")
     void onReceivedTouchIconUrl(String url, boolean precomposed) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        WebHistoryItem i = mBackForwardList.getCurrentItem();
        {
            i.setTouchIconUrl(url, precomposed);
        } //End block
        sendMessage(obtainMessage(RECEIVED_TOUCH_ICON_URL,
                precomposed ? 1 : 0, 0, url));
        addTaint(url.getTaint());
        addTaint(precomposed);
        // ---------- Original Method ----------
        //WebHistoryItem i = mBackForwardList.getCurrentItem();
        //if (i != null) {
            //i.setTouchIconUrl(url, precomposed);
        //}
        //if (mWebChromeClient == null) {
            //return;
        //}
        //sendMessage(obtainMessage(RECEIVED_TOUCH_ICON_URL,
                //precomposed ? 1 : 0, 0, url));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.090 -0400", hash_original_method = "91CD241BD0413BEA62EE65C753144C77", hash_generated_method = "07104B18FA4D2AE7D773C3C1731DE840")
    public void onReceivedTitle(String title) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        sendMessage(obtainMessage(RECEIVED_TITLE, title));
        addTaint(title.getTaint());
        // ---------- Original Method ----------
        //if (mWebChromeClient == null) {
            //return;
        //}
        //sendMessage(obtainMessage(RECEIVED_TITLE, title));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.090 -0400", hash_original_method = "7099C31F609DFFDBC7FE4DB990C0E80D", hash_generated_method = "ECC362B3F0CF863A6FD10DAB0FA4EFE5")
    public void onJsAlert(String url, String message) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        JsResult result = new JsResult(this, false);
        Message alert = obtainMessage(JS_ALERT, result);
        alert.getData().putString("message", message);
        alert.getData().putString("url", url);
        {
            sendMessage(alert);
            try 
            {
                wait();
            } //End block
            catch (InterruptedException e)
            { }
        } //End block
        addTaint(url.getTaint());
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        //if (mWebChromeClient == null) {
            //return;
        //}
        //JsResult result = new JsResult(this, false);
        //Message alert = obtainMessage(JS_ALERT, result);
        //alert.getData().putString("message", message);
        //alert.getData().putString("url", url);
        //synchronized (this) {
            //sendMessage(alert);
            //try {
                //wait();
            //} catch (InterruptedException e) {
                //Log.e(LOGTAG, "Caught exception while waiting for jsAlert");
                //Log.e(LOGTAG, Log.getStackTraceString(e));
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.091 -0400", hash_original_method = "043F4DC8C3BE16DF648461B096D08CDF", hash_generated_method = "0CB7E72523778D36C331E5E630805057")
    public boolean onJsConfirm(String url, String message) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        JsResult result = new JsResult(this, false);
        Message confirm = obtainMessage(JS_CONFIRM, result);
        confirm.getData().putString("message", message);
        confirm.getData().putString("url", url);
        {
            sendMessage(confirm);
            try 
            {
                wait();
            } //End block
            catch (InterruptedException e)
            { }
        } //End block
        boolean var24B13E75CB06D38BE89AEA8EA3E557D5_417749080 = (result.getResult());
        addTaint(url.getTaint());
        addTaint(message.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1244024947 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1244024947;
        // ---------- Original Method ----------
        //if (mWebChromeClient == null) {
            //return false;
        //}
        //JsResult result = new JsResult(this, false);
        //Message confirm = obtainMessage(JS_CONFIRM, result);
        //confirm.getData().putString("message", message);
        //confirm.getData().putString("url", url);
        //synchronized (this) {
            //sendMessage(confirm);
            //try {
                //wait();
            //} catch (InterruptedException e) {
                //Log.e(LOGTAG, "Caught exception while waiting for jsConfirm");
                //Log.e(LOGTAG, Log.getStackTraceString(e));
            //}
        //}
        //return result.getResult();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.092 -0400", hash_original_method = "994C85F742AA26A8662DEB752BD55192", hash_generated_method = "E8FF786C61D4512BBCE327A43F35A74F")
    public String onJsPrompt(String url, String message, String defaultValue) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        String varB4EAC82CA7396A68D541C85D26508E83_1044835375 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_277926115 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1044835375 = null;
        } //End block
        JsPromptResult result = new JsPromptResult(this);
        Message prompt = obtainMessage(JS_PROMPT, result);
        prompt.getData().putString("message", message);
        prompt.getData().putString("default", defaultValue);
        prompt.getData().putString("url", url);
        {
            sendMessage(prompt);
            try 
            {
                wait();
            } //End block
            catch (InterruptedException e)
            { }
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_277926115 = result.getStringResult();
        addTaint(url.getTaint());
        addTaint(message.getTaint());
        addTaint(defaultValue.getTaint());
        String varA7E53CE21691AB073D9660D615818899_2085198304; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2085198304 = varB4EAC82CA7396A68D541C85D26508E83_1044835375;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2085198304 = varB4EAC82CA7396A68D541C85D26508E83_277926115;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2085198304.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2085198304;
        // ---------- Original Method ----------
        //if (mWebChromeClient == null) {
            //return null;
        //}
        //JsPromptResult result = new JsPromptResult(this);
        //Message prompt = obtainMessage(JS_PROMPT, result);
        //prompt.getData().putString("message", message);
        //prompt.getData().putString("default", defaultValue);
        //prompt.getData().putString("url", url);
        //synchronized (this) {
            //sendMessage(prompt);
            //try {
                //wait();
            //} catch (InterruptedException e) {
                //Log.e(LOGTAG, "Caught exception while waiting for jsPrompt");
                //Log.e(LOGTAG, Log.getStackTraceString(e));
            //}
        //}
        //return result.getStringResult();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.093 -0400", hash_original_method = "C62C6CDF3925B75D5791E39530CD4D60", hash_generated_method = "68B4B97B9DEBCB700656992C7EC4D8D1")
    public boolean onJsBeforeUnload(String url, String message) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        JsResult result = new JsResult(this, true);
        Message confirm = obtainMessage(JS_UNLOAD, result);
        confirm.getData().putString("message", message);
        confirm.getData().putString("url", url);
        {
            sendMessage(confirm);
            try 
            {
                wait();
            } //End block
            catch (InterruptedException e)
            { }
        } //End block
        boolean var24B13E75CB06D38BE89AEA8EA3E557D5_1553832323 = (result.getResult());
        addTaint(url.getTaint());
        addTaint(message.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2024035526 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2024035526;
        // ---------- Original Method ----------
        //if (mWebChromeClient == null) {
            //return true;
        //}
        //JsResult result = new JsResult(this, true);
        //Message confirm = obtainMessage(JS_UNLOAD, result);
        //confirm.getData().putString("message", message);
        //confirm.getData().putString("url", url);
        //synchronized (this) {
            //sendMessage(confirm);
            //try {
                //wait();
            //} catch (InterruptedException e) {
                //Log.e(LOGTAG, "Caught exception while waiting for jsUnload");
                //Log.e(LOGTAG, Log.getStackTraceString(e));
            //}
        //}
        //return result.getResult();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.094 -0400", hash_original_method = "2A1C263B6B48827DF8BFBCAAE8358B4D", hash_generated_method = "6515C5409C3B5FE3D3AA49BEF287FFDD")
    public void onExceededDatabaseQuota(
            String url, String databaseIdentifier, long currentQuota,
            long estimatedSize, long totalUsedQuota,
            WebStorage.QuotaUpdater quotaUpdater) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            quotaUpdater.updateQuota(currentQuota);
        } //End block
        Message exceededQuota = obtainMessage(EXCEEDED_DATABASE_QUOTA);
        HashMap<String, Object> map = new HashMap();
        map.put("databaseIdentifier", databaseIdentifier);
        map.put("url", url);
        map.put("currentQuota", currentQuota);
        map.put("estimatedSize", estimatedSize);
        map.put("totalUsedQuota", totalUsedQuota);
        map.put("quotaUpdater", quotaUpdater);
        exceededQuota.obj = map;
        sendMessage(exceededQuota);
        addTaint(url.getTaint());
        addTaint(databaseIdentifier.getTaint());
        addTaint(currentQuota);
        addTaint(estimatedSize);
        addTaint(totalUsedQuota);
        addTaint(quotaUpdater.getTaint());
        // ---------- Original Method ----------
        //if (mWebChromeClient == null) {
            //quotaUpdater.updateQuota(currentQuota);
            //return;
        //}
        //Message exceededQuota = obtainMessage(EXCEEDED_DATABASE_QUOTA);
        //HashMap<String, Object> map = new HashMap();
        //map.put("databaseIdentifier", databaseIdentifier);
        //map.put("url", url);
        //map.put("currentQuota", currentQuota);
        //map.put("estimatedSize", estimatedSize);
        //map.put("totalUsedQuota", totalUsedQuota);
        //map.put("quotaUpdater", quotaUpdater);
        //exceededQuota.obj = map;
        //sendMessage(exceededQuota);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.095 -0400", hash_original_method = "6FEDE2ECE3E4B773BADE3DEA30808B9D", hash_generated_method = "5A864A6620DCEA7DE8435CF70F678720")
    public void onReachedMaxAppCacheSize(long spaceNeeded,
            long totalUsedQuota, WebStorage.QuotaUpdater quotaUpdater) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            quotaUpdater.updateQuota(0);
        } //End block
        Message msg = obtainMessage(REACHED_APPCACHE_MAXSIZE);
        HashMap<String, Object> map = new HashMap();
        map.put("spaceNeeded", spaceNeeded);
        map.put("totalUsedQuota", totalUsedQuota);
        map.put("quotaUpdater", quotaUpdater);
        msg.obj = map;
        sendMessage(msg);
        addTaint(spaceNeeded);
        addTaint(totalUsedQuota);
        addTaint(quotaUpdater.getTaint());
        // ---------- Original Method ----------
        //if (mWebChromeClient == null) {
            //quotaUpdater.updateQuota(0);
            //return;
        //}
        //Message msg = obtainMessage(REACHED_APPCACHE_MAXSIZE);
        //HashMap<String, Object> map = new HashMap();
        //map.put("spaceNeeded", spaceNeeded);
        //map.put("totalUsedQuota", totalUsedQuota);
        //map.put("quotaUpdater", quotaUpdater);
        //msg.obj = map;
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.095 -0400", hash_original_method = "26533187FD051756DFC2CF1CEE3F806F", hash_generated_method = "218646D885467894560889EAF1A964DB")
    public void onGeolocationPermissionsShowPrompt(String origin,
            GeolocationPermissions.Callback callback) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Message showMessage = obtainMessage(GEOLOCATION_PERMISSIONS_SHOW_PROMPT);
        HashMap<String, Object> map = new HashMap();
        map.put("origin", origin);
        map.put("callback", callback);
        showMessage.obj = map;
        sendMessage(showMessage);
        addTaint(origin.getTaint());
        addTaint(callback.getTaint());
        // ---------- Original Method ----------
        //if (mWebChromeClient == null) {
            //return;
        //}
        //Message showMessage =
                //obtainMessage(GEOLOCATION_PERMISSIONS_SHOW_PROMPT);
        //HashMap<String, Object> map = new HashMap();
        //map.put("origin", origin);
        //map.put("callback", callback);
        //showMessage.obj = map;
        //sendMessage(showMessage);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.096 -0400", hash_original_method = "9C25F80E0E6C6F6C487DBDD3AFCBA4E7", hash_generated_method = "7844EFC6CC2AB78C59897EA118E4302B")
    public void onGeolocationPermissionsHidePrompt() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Message hideMessage = obtainMessage(GEOLOCATION_PERMISSIONS_HIDE_PROMPT);
        sendMessage(hideMessage);
        // ---------- Original Method ----------
        //if (mWebChromeClient == null) {
            //return;
        //}
        //Message hideMessage = obtainMessage(GEOLOCATION_PERMISSIONS_HIDE_PROMPT);
        //sendMessage(hideMessage);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.096 -0400", hash_original_method = "E08EA131E9320463E856348907B813CB", hash_generated_method = "0DADFA9BE57A9C46483E22CDA001B57F")
    public void addMessageToConsole(String message, int lineNumber, String sourceID, int msgLevel) {
        Message msg = obtainMessage(ADD_MESSAGE_TO_CONSOLE);
        msg.getData().putString("message", message);
        msg.getData().putString("sourceID", sourceID);
        msg.getData().putInt("lineNumber", lineNumber);
        msg.getData().putInt("msgLevel", msgLevel);
        sendMessage(msg);
        addTaint(message.getTaint());
        addTaint(lineNumber);
        addTaint(sourceID.getTaint());
        addTaint(msgLevel);
        // ---------- Original Method ----------
        //if (mWebChromeClient == null) {
            //return;
        //}
        //Message msg = obtainMessage(ADD_MESSAGE_TO_CONSOLE);
        //msg.getData().putString("message", message);
        //msg.getData().putString("sourceID", sourceID);
        //msg.getData().putInt("lineNumber", lineNumber);
        //msg.getData().putInt("msgLevel", msgLevel);
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.097 -0400", hash_original_method = "288C2B13F2CEF8B24515719050488B19", hash_generated_method = "4442BFB567D5B99C4E9D448BA90A7684")
    public boolean onJsTimeout() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        JsResult result = new JsResult(this, true);
        Message timeout = obtainMessage(JS_TIMEOUT, result);
        {
            sendMessage(timeout);
            try 
            {
                wait();
            } //End block
            catch (InterruptedException e)
            { }
        } //End block
        boolean var24B13E75CB06D38BE89AEA8EA3E557D5_84232205 = (result.getResult());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_699581147 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_699581147;
        // ---------- Original Method ----------
        //if (mWebChromeClient == null) {
            //return true;
        //}
        //JsResult result = new JsResult(this, true);
        //Message timeout = obtainMessage(JS_TIMEOUT, result);
        //synchronized (this) {
            //sendMessage(timeout);
            //try {
                //wait();
            //} catch (InterruptedException e) {
                //Log.e(LOGTAG, "Caught exception while waiting for jsUnload");
                //Log.e(LOGTAG, Log.getStackTraceString(e));
            //}
        //}
        //return result.getResult();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.097 -0400", hash_original_method = "F9E2141EE9507A71AC258BF46DA1BEA9", hash_generated_method = "E85FD2F384A5CB02D8CB7AA0B8CD37B4")
    public void getVisitedHistory(ValueCallback<String[]> callback) {
        Message msg = obtainMessage(GET_VISITED_HISTORY);
        msg.obj = callback;
        sendMessage(msg);
        addTaint(callback[0].getTaint());
        // ---------- Original Method ----------
        //if (mWebChromeClient == null) {
            //return;
        //}
        //Message msg = obtainMessage(GET_VISITED_HISTORY);
        //msg.obj = callback;
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.098 -0400", hash_original_method = "FE04684AB3D72B8C190BB2063ADDA47F", hash_generated_method = "C5F3D3523CECEBE307D7F2E231D8ECFB")
     Uri openFileChooser(String acceptType) {
        Uri varB4EAC82CA7396A68D541C85D26508E83_1119002375 = null; //Variable for return #1
        Uri varB4EAC82CA7396A68D541C85D26508E83_2126524856 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1119002375 = null;
        } //End block
        Message myMessage = obtainMessage(OPEN_FILE_CHOOSER);
        UploadFile uploadFile = new UploadFile();
        UploadFileMessageData data = new UploadFileMessageData(uploadFile, acceptType);
        myMessage.obj = data;
        {
            sendMessage(myMessage);
            try 
            {
                wait();
            } //End block
            catch (InterruptedException e)
            { }
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2126524856 = uploadFile.getResult();
        addTaint(acceptType.getTaint());
        Uri varA7E53CE21691AB073D9660D615818899_1408361624; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1408361624 = varB4EAC82CA7396A68D541C85D26508E83_1119002375;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1408361624 = varB4EAC82CA7396A68D541C85D26508E83_2126524856;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1408361624.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1408361624;
        // ---------- Original Method ----------
        //if (mWebChromeClient == null) {
            //return null;
        //}
        //Message myMessage = obtainMessage(OPEN_FILE_CHOOSER);
        //UploadFile uploadFile = new UploadFile();
        //UploadFileMessageData data = new UploadFileMessageData(uploadFile, acceptType);
        //myMessage.obj = data;
        //synchronized (this) {
            //sendMessage(myMessage);
            //try {
                //wait();
            //} catch (InterruptedException e) {
                //Log.e(LOGTAG,
                        //"Caught exception while waiting for openFileChooser");
                //Log.e(LOGTAG, Log.getStackTraceString(e));
            //}
        //}
        //return uploadFile.getResult();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.098 -0400", hash_original_method = "047BE1D111CE2C04D81802E658F23AB3", hash_generated_method = "D1DF381118DBABB61BD6B0650BB07854")
     void onNewHistoryItem(WebHistoryItem item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Message msg = obtainMessage(ADD_HISTORY_ITEM, item);
        sendMessage(msg);
        addTaint(item.getTaint());
        // ---------- Original Method ----------
        //if (mWebBackForwardListClient == null) {
            //return;
        //}
        //Message msg = obtainMessage(ADD_HISTORY_ITEM, item);
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.098 -0400", hash_original_method = "895FE5553DA6237DB0B5BAA6BAF66947", hash_generated_method = "5ACC185764E0B9807A9BC723DFF1C237")
     void onIndexChanged(WebHistoryItem item, int index) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Message msg = obtainMessage(HISTORY_INDEX_CHANGED, index, 0, item);
        sendMessage(msg);
        addTaint(item.getTaint());
        addTaint(index);
        // ---------- Original Method ----------
        //if (mWebBackForwardListClient == null) {
            //return;
        //}
        //Message msg = obtainMessage(HISTORY_INDEX_CHANGED, index, 0, item);
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.099 -0400", hash_original_method = "8F94850AD3F63EF799E6BEFB2C67734D", hash_generated_method = "4E0A1F5B478223B84535932ACDF0CB2E")
     void setInstallableWebApp() {
        sendMessage(obtainMessage(SET_INSTALLABLE_WEBAPP));
        // ---------- Original Method ----------
        //if (mWebChromeClient == null) {
            //return;
        //}
        //sendMessage(obtainMessage(SET_INSTALLABLE_WEBAPP));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.099 -0400", hash_original_method = "8DF8998B34FE58BC5486ECCDB22BE44D", hash_generated_method = "DA425DDC6ECB71CC2166F86D48A51D64")
     boolean canShowAlertDialog() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_510770182 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_510770182;
        // ---------- Original Method ----------
        //return mContext instanceof Activity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.099 -0400", hash_original_method = "C20FB9F0C31604564B2DC30DE7E0C643", hash_generated_method = "210A9996F68A5592AC7D5F9BFF76DCA1")
     void onSearchboxSuggestionsReceived(String query, List<String> suggestions) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Message msg = obtainMessage(NOTIFY_SEARCHBOX_LISTENERS);
        msg.obj = suggestions;
        msg.getData().putString("query", query);
        sendMessage(msg);
        addTaint(query.getTaint());
        addTaint(suggestions.getTaint());
        // ---------- Original Method ----------
        //Message msg = obtainMessage(NOTIFY_SEARCHBOX_LISTENERS);
        //msg.obj = suggestions;
        //msg.getData().putString("query", query);
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.100 -0400", hash_original_method = "350C274DFDDA43015C8C93D9651125A1", hash_generated_method = "FA97259974EA1046F2D002D9FB3C681C")
     void onIsSupportedCallback(boolean isSupported) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Message msg = obtainMessage(SEARCHBOX_IS_SUPPORTED_CALLBACK);
        msg.obj = new Boolean(isSupported);
        sendMessage(msg);
        addTaint(isSupported);
        // ---------- Original Method ----------
        //Message msg = obtainMessage(SEARCHBOX_IS_SUPPORTED_CALLBACK);
        //msg.obj = new Boolean(isSupported);
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.100 -0400", hash_original_method = "18679CF45F0FBF6C3076A4EAE4B01ADE", hash_generated_method = "A9642A8E3B9E867F607C7A046156A5BF")
     void onSearchboxDispatchCompleteCallback(String function, int id, boolean success) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Message msg = obtainMessage(SEARCHBOX_DISPATCH_COMPLETE_CALLBACK);
        msg.obj = Boolean.valueOf(success);
        msg.getData().putString("function", function);
        msg.getData().putInt("id", id);
        sendMessage(msg);
        addTaint(function.getTaint());
        addTaint(id);
        addTaint(success);
        // ---------- Original Method ----------
        //Message msg = obtainMessage(SEARCHBOX_DISPATCH_COMPLETE_CALLBACK);
        //msg.obj = Boolean.valueOf(success);
        //msg.getData().putString("function", function);
        //msg.getData().putInt("id", id);
        //sendMessage(msg);
    }

    
    private static class ResultTransport<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.100 -0400", hash_original_field = "313AEF43C06545BCEAC152A1C285EBE1", hash_generated_field = "8FF1976BF201D1F418EC84B9D35E5FAC")

        private E mResult;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.101 -0400", hash_original_method = "DD22213D197BC89445531F8496343FB8", hash_generated_method = "9633A2A2899E61CCB3453D5B3B8F2949")
        public  ResultTransport(E defaultResult) {
            mResult = defaultResult;
            // ---------- Original Method ----------
            //mResult = defaultResult;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.101 -0400", hash_original_method = "23B0DB25EF15209B12B4D98F75BC4826", hash_generated_method = "1CC67B1DE228486A08B2C64A649EF681")
        public synchronized void setResult(E result) {
            mResult = result;
            // ---------- Original Method ----------
            //mResult = result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.102 -0400", hash_original_method = "67EA7E4C242F8EF7A6CF084AEA447779", hash_generated_method = "E91D7351EC82AD05FF5E43798AA9F411")
        public synchronized E getResult() {
            E varB4EAC82CA7396A68D541C85D26508E83_183552132 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_183552132 = mResult;
            varB4EAC82CA7396A68D541C85D26508E83_183552132.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_183552132;
            // ---------- Original Method ----------
            //return mResult;
        }

        
    }


    
    private static class UploadFileMessageData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.102 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "141E146BCCC9E44E04F619B70ED78B17")

        private UploadFile mCallback;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.102 -0400", hash_original_field = "F7770022153C0271D858491BF09AEACC", hash_generated_field = "F1FEB7E52B3D4A532C0192C9EE3750CA")

        private String mAcceptType;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.102 -0400", hash_original_method = "506E5829DE4CA65822239D45E416BF71", hash_generated_method = "F0F40EDAB8A6F9084FBE2B1F2CCB3C4E")
        public  UploadFileMessageData(UploadFile uploadFile, String acceptType) {
            mCallback = uploadFile;
            mAcceptType = acceptType;
            // ---------- Original Method ----------
            //mCallback = uploadFile;
            //mAcceptType = acceptType;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.104 -0400", hash_original_method = "9D48109A15DDC7CFDE503C879117A387", hash_generated_method = "C49BCF578091A9D0199D2AC13572DB54")
        public UploadFile getUploadFile() {
            UploadFile varB4EAC82CA7396A68D541C85D26508E83_1771790188 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1771790188 = mCallback;
            varB4EAC82CA7396A68D541C85D26508E83_1771790188.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1771790188;
            // ---------- Original Method ----------
            //return mCallback;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.105 -0400", hash_original_method = "EE5645A876B8829341B5E714F10E353A", hash_generated_method = "B63FB6DC5378381B3B4280C1901699DF")
        public String getAcceptType() {
            String varB4EAC82CA7396A68D541C85D26508E83_1206468746 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1206468746 = mAcceptType;
            varB4EAC82CA7396A68D541C85D26508E83_1206468746.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1206468746;
            // ---------- Original Method ----------
            //return mAcceptType;
        }

        
    }


    
    private class UploadFile implements ValueCallback<Uri> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.105 -0400", hash_original_field = "CBAFE11E7BAE23358D70D54D132C3064", hash_generated_field = "D24B10CB4DFA145F1AD29B267930EA48")

        private Uri mValue;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.105 -0400", hash_original_method = "CA5F2E6F07869C80D280CD39F96B8098", hash_generated_method = "CA5F2E6F07869C80D280CD39F96B8098")
        public UploadFile ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.105 -0400", hash_original_method = "4E719BBCA95A35A86F37F83B7E6AA557", hash_generated_method = "0D3D6CBC09A20A6460F1CAC777B0CFB1")
        public void onReceiveValue(Uri value) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mValue = value;
            {
                Object var162CC590B8447AA31A644E693FAE87CB_164850951 = (CallbackProxy.this);
                {
                    CallbackProxy.this.notify();
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //mValue = value;
            //synchronized (CallbackProxy.this) {
                //CallbackProxy.this.notify();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.106 -0400", hash_original_method = "546BF3EDB8840D5BF09D8B66103FFEC6", hash_generated_method = "B4F80FAFEBF49EAA555F8938A3F95F18")
        public Uri getResult() {
            Uri varB4EAC82CA7396A68D541C85D26508E83_1178610497 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1178610497 = mValue;
            varB4EAC82CA7396A68D541C85D26508E83_1178610497.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1178610497;
            // ---------- Original Method ----------
            //return mValue;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.106 -0400", hash_original_field = "8C9130CDA2A66EF5393AEF174DCA2142", hash_generated_field = "B8BCB03548AB3F60BD02883254FAF794")

    private static final String LOGTAG = "CallbackProxy";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.106 -0400", hash_original_field = "3208979F31DB6F208ED1ABFE54C2777D", hash_generated_field = "848D750C41316648518CD8F70F77F580")

    private static final int PAGE_STARTED = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.106 -0400", hash_original_field = "0595282DB8290097D943FD4835DAE35F", hash_generated_field = "4C070FDA7C3353A448C6DD6B918D4011")

    private static final int RECEIVED_ICON = 101;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.106 -0400", hash_original_field = "32A709EF470502982DE5B92F9E51C52A", hash_generated_field = "A0CE6E78E934117E9782D63B2FEB087C")

    private static final int RECEIVED_TITLE = 102;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.106 -0400", hash_original_field = "AA16AAC9759D194D9ABC14C1DDB9C398", hash_generated_field = "8AFE3F0322EFDE154B6ADC96D0D7F5E6")

    private static final int OVERRIDE_URL = 103;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.106 -0400", hash_original_field = "96423544F2C8894B7019D641B104C0B6", hash_generated_field = "0F252CCD54E9D551DB6C5D2B2CA79448")

    private static final int AUTH_REQUEST = 104;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.106 -0400", hash_original_field = "896362D63C3AA39A676A01B7D029C192", hash_generated_field = "9B3FDF63312EC91BBA1DD5F25239A68F")

    private static final int SSL_ERROR = 105;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.106 -0400", hash_original_field = "0D541C969BF688AC1DC3481FB24093A4", hash_generated_field = "95DAFA8ADE2A61A20D5E39C60D891614")

    private static final int PROGRESS = 106;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.106 -0400", hash_original_field = "DF889AF98741612C7EBBEFD56FDECA9A", hash_generated_field = "4049E97E2BE052C03064CA677BE659A0")

    private static final int UPDATE_VISITED = 107;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.106 -0400", hash_original_field = "D54C2218A4F7767E49430B7F45943150", hash_generated_field = "A7A0D1F5ACF78125BCA9701A5CC009E5")

    private static final int LOAD_RESOURCE = 108;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.106 -0400", hash_original_field = "3D24951538BC37EE86262B035EFE145E", hash_generated_field = "DEA96639CC695B0F757C9B991BCDA133")

    private static final int CREATE_WINDOW = 109;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.106 -0400", hash_original_field = "5FD2B1A14257FCDABB95BB135FF6CBB3", hash_generated_field = "8EAC4093DD440B6EF00A8E9F4DC1C4E0")

    private static final int CLOSE_WINDOW = 110;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.106 -0400", hash_original_field = "EED1B544826A0E05E39F4EF9160C9B47", hash_generated_field = "91798D07F2F908231AFDEFD1E6B2838D")

    private static final int SAVE_PASSWORD = 111;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.106 -0400", hash_original_field = "EE0ED596D7152BB438F8241ECA3B4A75", hash_generated_field = "3440F1A73B7E8491DE1EE40C87547131")

    private static final int JS_ALERT = 112;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.106 -0400", hash_original_field = "178663701E6D5A1C3D92DDB7ABC9EFAD", hash_generated_field = "0CC6E044D6D37F23B6E16EA723CABB25")

    private static final int JS_CONFIRM = 113;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.106 -0400", hash_original_field = "691DB536EA212A54B7C75028CA5C5181", hash_generated_field = "AE03D743830B0E913C9B4A19C334D998")

    private static final int JS_PROMPT = 114;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.106 -0400", hash_original_field = "63406D7FC3EEAE564C564DA5D918F64F", hash_generated_field = "0174398F08F7C02FF7DF4D1A826D4E88")

    private static final int JS_UNLOAD = 115;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.106 -0400", hash_original_field = "A2010D893F416BE4FA618E6F4546C076", hash_generated_field = "1E66D85BCF0A6507FE185C0BA8A8AAEC")

    private static final int ASYNC_KEYEVENTS = 116;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.106 -0400", hash_original_field = "C5CA2DBA1E8EB468981612AB11E5B638", hash_generated_field = "D3C0B0285F58690CA9C630D2069D9952")

    private static final int DOWNLOAD_FILE = 118;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.106 -0400", hash_original_field = "61D34384ACB6D6E6538CBE9CACA042C2", hash_generated_field = "0FAC4F6750464F7121676D3E6DA87C34")

    private static final int REPORT_ERROR = 119;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.107 -0400", hash_original_field = "8F7FC97FFDA4549DA6CC4A114FE8B20C", hash_generated_field = "6CC195242A0EB566B41683BE41C53B6E")

    private static final int RESEND_POST_DATA = 120;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.107 -0400", hash_original_field = "B49EBE022F8B815D90EE10B8DF4B4ADB", hash_generated_field = "9FE3EFB08388A4762A3B4605C12F9F28")

    private static final int PAGE_FINISHED = 121;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.107 -0400", hash_original_field = "EEC292A48E8AF8A7AF74BA09970264A6", hash_generated_field = "B0B1B74A5F98AF2C70D4F8B3B80DC9F2")

    private static final int REQUEST_FOCUS = 122;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.107 -0400", hash_original_field = "A5F92A21341FA5B16F062DF186B2482A", hash_generated_field = "B265FEFE7FCCDB0139C5B46EFA790F5D")

    private static final int SCALE_CHANGED = 123;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.107 -0400", hash_original_field = "3419D1FC6211209D479F738FC85856E5", hash_generated_field = "57532493DFCF0603E50E226A34E196A9")

    private static final int RECEIVED_CERTIFICATE = 124;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.107 -0400", hash_original_field = "7DF692B4B90692F9A506D49F315BC808", hash_generated_field = "C787E348480EC1FDC28655E6D1E02A0E")

    private static final int SWITCH_OUT_HISTORY = 125;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.107 -0400", hash_original_field = "28A4C0BFA39FFCE75A049D12C90DA34F", hash_generated_field = "FB13A89EC337D2294B29823E36FF84A5")

    private static final int EXCEEDED_DATABASE_QUOTA = 126;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.107 -0400", hash_original_field = "5C2E4A8C6C1D6EB0AA73405358873E9D", hash_generated_field = "BC55284D336C0FEA873DFF7A4A688792")

    private static final int REACHED_APPCACHE_MAXSIZE = 127;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.107 -0400", hash_original_field = "190B5D79FB8A1AF1C80637C850307202", hash_generated_field = "0149997CB5F9EA65E0731208128064F0")

    private static final int JS_TIMEOUT = 128;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.107 -0400", hash_original_field = "66C31A0DFCEAF967AEAE99F7FE0170F0", hash_generated_field = "3DEBEE027386C9B59EB8F3BF23830816")

    private static final int ADD_MESSAGE_TO_CONSOLE = 129;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.107 -0400", hash_original_field = "90E8C851A8F6A9ECE364702E0F8FFC4E", hash_generated_field = "9E058751C8EDCA9A479290263411F486")

    private static final int GEOLOCATION_PERMISSIONS_SHOW_PROMPT = 130;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.107 -0400", hash_original_field = "4BA2D5841F9CFA2DDBA1426164A8F234", hash_generated_field = "EBBDFB81B17C0299328881EC5293A04F")

    private static final int GEOLOCATION_PERMISSIONS_HIDE_PROMPT = 131;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.107 -0400", hash_original_field = "CF11A22DA4127948A476CD033290BC8D", hash_generated_field = "94BEF01A1474B70C6F1B865162349973")

    private static final int RECEIVED_TOUCH_ICON_URL = 132;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.107 -0400", hash_original_field = "726C652F40C754AB326CA7662427B968", hash_generated_field = "14E0F99C2EE825C2B833110720A4E4A3")

    private static final int GET_VISITED_HISTORY = 133;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.107 -0400", hash_original_field = "347D8E095BC47B4EE0D0AFFCD8A441D8", hash_generated_field = "E2026B263FE01AF8EA0927AE63D344F1")

    private static final int OPEN_FILE_CHOOSER = 134;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.107 -0400", hash_original_field = "DDA4EF57BA7EDD6865AFB71F66096612", hash_generated_field = "345D7B90790909F7DE675D4763166882")

    private static final int ADD_HISTORY_ITEM = 135;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.107 -0400", hash_original_field = "E47A0D78212EBAA6C226917A718522D7", hash_generated_field = "D95397FC5C170E740C5303D3A8A05C5B")

    private static final int HISTORY_INDEX_CHANGED = 136;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.107 -0400", hash_original_field = "A6E6D65EDCEBA9E1213EF8CCE6855690", hash_generated_field = "3DCF48A106D9F1BE6A3873E099553B4A")

    private static final int AUTH_CREDENTIALS = 137;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.107 -0400", hash_original_field = "B11AA85C9F67F142C2BEC310EDCD047D", hash_generated_field = "A3AE08C91BB130064E206832AE02A418")

    private static final int SET_INSTALLABLE_WEBAPP = 138;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.107 -0400", hash_original_field = "BF9BFFEF86D2385E78EDDAE2495AB4A0", hash_generated_field = "C24B72196DDD74F7DDF12FB1EB4231BF")

    private static final int NOTIFY_SEARCHBOX_LISTENERS = 139;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.107 -0400", hash_original_field = "E846F0F51A2809AE1103C135CD963FC1", hash_generated_field = "DF1FFC74E56844B757AE85139F652013")

    private static final int AUTO_LOGIN = 140;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.107 -0400", hash_original_field = "F44C77CADA5C31603D09B4649A61FF4C", hash_generated_field = "DD570499086646796ECB453C67DFA7A2")

    private static final int CLIENT_CERT_REQUEST = 141;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.107 -0400", hash_original_field = "4B8E1AE28BB7AEE993AFE0AD150F701B", hash_generated_field = "3204AA037B01A2C415DD1AD8899FB540")

    private static final int SEARCHBOX_IS_SUPPORTED_CALLBACK = 142;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.107 -0400", hash_original_field = "EBDC352F26A1C3C736F3B415141C80D9", hash_generated_field = "23E6503B9321314390D6CC90C6F99F7C")

    private static final int SEARCHBOX_DISPATCH_COMPLETE_CALLBACK = 143;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.107 -0400", hash_original_field = "B7D6B899C6A4B45279ABA6AB53B5C958", hash_generated_field = "9051530C94DC9265299E5CDAF9B017D1")

    private static final int PROCEEDED_AFTER_SSL_ERROR = 144;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.107 -0400", hash_original_field = "E318E94680AF79EA0A7279378C0BC024", hash_generated_field = "00F56014A24A80FE2F3360FDF7B1E405")

    private static final int NOTIFY = 200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.107 -0400", hash_original_field = "F61A6BEC594680894ED6FFB6E74F8F5A", hash_generated_field = "3B2DC4ACBEB000A20672E69802960DA2")

    private static final boolean PERF_PROBE = false;
}

