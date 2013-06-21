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
    private volatile WebViewClient mWebViewClient;
    private volatile WebChromeClient mWebChromeClient;
    private WebView mWebView;
    private volatile DownloadListener mDownloadListener;
    private boolean mProgressUpdatePending;
    private volatile int mLatestProgress = 100;
    private WebBackForwardList mBackForwardList;
    private volatile WebBackForwardListClient mWebBackForwardListClient;
    private Context mContext;
    private long mWebCoreThreadTime;
    private long mWebCoreIdleTime;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.902 -0400", hash_original_method = "5020D7570AC9675C7FDC286174BD125E", hash_generated_method = "DA1C177A429ED598FE2FD4BA7C6D5D16")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CallbackProxy(Context context, WebView w) {
        dsTaint.addTaint(w.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        mBackForwardList = new WebBackForwardList(this);
        // ---------- Original Method ----------
        //mContext = context;
        //mWebView = w;
        //mBackForwardList = new WebBackForwardList(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.902 -0400", hash_original_method = "94198B28324F8EDCEFD396927CFF12D2", hash_generated_method = "116F77D89836A6DD535A2BEAB9386BCE")
    @DSModeled(DSC.SAFE)
    public void setWebViewClient(WebViewClient client) {
        dsTaint.addTaint(client.dsTaint);
        // ---------- Original Method ----------
        //mWebViewClient = client;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.902 -0400", hash_original_method = "F1A871AF9A3B10055BFFA9DC06A940C2", hash_generated_method = "22E9E030B6E5409A7C9534822A6A46E1")
    @DSModeled(DSC.SAFE)
    public WebViewClient getWebViewClient() {
        return (WebViewClient)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mWebViewClient;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.902 -0400", hash_original_method = "92EB7E506A2EF4886CBEC1480289BCB6", hash_generated_method = "36AF36D75C3BB1941BDB64450F380CCD")
    @DSModeled(DSC.SAFE)
    public void setWebChromeClient(WebChromeClient client) {
        dsTaint.addTaint(client.dsTaint);
        // ---------- Original Method ----------
        //mWebChromeClient = client;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.902 -0400", hash_original_method = "578C7E32D2B540B07E657C95C84E837C", hash_generated_method = "793C78AF220D215CFC037D750DE2A129")
    @DSModeled(DSC.SAFE)
    public WebChromeClient getWebChromeClient() {
        return (WebChromeClient)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mWebChromeClient;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.902 -0400", hash_original_method = "36DD14932709DFA3D074F96EC9039EDA", hash_generated_method = "C852DCBC774E697FA0F6512B5902B759")
    @DSModeled(DSC.SAFE)
    public void setDownloadListener(DownloadListener client) {
        dsTaint.addTaint(client.dsTaint);
        // ---------- Original Method ----------
        //mDownloadListener = client;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.903 -0400", hash_original_method = "2A97B39171573BABF631C9DB7E378DC9", hash_generated_method = "9741834BAD147710D0AD0687605ABE57")
    @DSModeled(DSC.SAFE)
    public WebBackForwardList getBackForwardList() {
        return (WebBackForwardList)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mBackForwardList;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.903 -0400", hash_original_method = "69271AEE54C61C015B6B50CD212FE110", hash_generated_method = "739ED7B508BDA52184A065B87D965A11")
    @DSModeled(DSC.SAFE)
     void setWebBackForwardListClient(WebBackForwardListClient client) {
        dsTaint.addTaint(client.dsTaint);
        // ---------- Original Method ----------
        //mWebBackForwardListClient = client;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.903 -0400", hash_original_method = "32023A06CFA84B93B3A0030ADE6E4A41", hash_generated_method = "0F93B73D579594C4EBBEE17C4A3564C7")
    @DSModeled(DSC.SAFE)
     WebBackForwardListClient getWebBackForwardListClient() {
        return (WebBackForwardListClient)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mWebBackForwardListClient;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.903 -0400", hash_original_method = "43AE5B1BF40E67157C7361E5EC862A6C", hash_generated_method = "B71A8F52E8AC72EFB42FF74CD33F83B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean uiOverrideUrlLoading(String overrideUrl) {
        dsTaint.addTaint(overrideUrl);
        {
            boolean var46C404494DFD92BDDD02800A6B728B6E_1428721698 = (overrideUrl == null || overrideUrl.length() == 0);
        } //End collapsed parenthetic
        boolean override;
        override = false;
        {
            override = mWebViewClient.shouldOverrideUrlLoading(mWebView,
                    overrideUrl);
        } //End block
        {
            Intent intent;
            intent = new Intent(Intent.ACTION_VIEW,
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.903 -0400", hash_original_method = "D32407A1261408285F08570A8F2494B0", hash_generated_method = "D8939AF23A27CD70F4624C4C882D9A72")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean uiOverrideKeyEvent(KeyEvent event) {
        dsTaint.addTaint(event.dsTaint);
        {
            boolean varE0D5CA03F66620B4894C506375BB27AD_142818954 = (mWebViewClient.shouldOverrideKeyEvent(mWebView, event));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mWebViewClient != null) {
            //return mWebViewClient.shouldOverrideKeyEvent(mWebView, event);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.911 -0400", hash_original_method = "643B690E8360A657B90F531CC63147C4", hash_generated_method = "B25F1C57CBBF82B39C72450267FDDB3F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void handleMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        //Begin case PAGE_STARTED 
        String startedUrl;
        startedUrl = msg.getData().getString("url");
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
        String finishedUrl;
        finishedUrl = (String) msg.obj;
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
            int reasonCode;
            reasonCode = msg.arg1;
            String description;
            description = msg.getData().getString("description");
            String failUrl;
            failUrl = msg.getData().getString("failingUrl");
            mWebViewClient.onReceivedError(mWebView, reasonCode,
                            description, failUrl);
        } //End block
        //End case REPORT_ERROR 
        //Begin case RESEND_POST_DATA 
        Message resend;
        resend = (Message) msg.getData().getParcelable("resend");
        //End case RESEND_POST_DATA 
        //Begin case RESEND_POST_DATA 
        Message dontResend;
        dontResend = (Message) msg.getData().getParcelable("dontResend");
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
        String overrideUrl;
        overrideUrl = msg.getData().getString("url");
        //End case OVERRIDE_URL 
        //Begin case OVERRIDE_URL 
        boolean override;
        override = uiOverrideUrlLoading(overrideUrl);
        //End case OVERRIDE_URL 
        //Begin case OVERRIDE_URL 
        ResultTransport<Boolean> result;
        result = (ResultTransport<Boolean>) msg.obj;
        //End case OVERRIDE_URL 
        //Begin case OVERRIDE_URL 
        {
            result.setResult(override);
            notify();
        } //End block
        //End case OVERRIDE_URL 
        //Begin case AUTH_REQUEST 
        {
            HttpAuthHandler handler;
            handler = (HttpAuthHandler) msg.obj;
            String host;
            host = msg.getData().getString("host");
            String realm;
            realm = msg.getData().getString("realm");
            mWebViewClient.onReceivedHttpAuthRequest(mWebView, handler,
                            host, realm);
        } //End block
        //End case AUTH_REQUEST 
        //Begin case SSL_ERROR 
        {
            HashMap<String, Object> map;
            map = (HashMap<String, Object>) msg.obj;
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
            HashMap<String, Object> map;
            map = (HashMap<String, Object>) msg.obj;
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
            String url;
            url = msg.getData().getString("url");
            String userAgent;
            userAgent = msg.getData().getString("userAgent");
            String contentDisposition;
            contentDisposition = msg.getData().getString("contentDisposition");
            String mimetype;
            mimetype = msg.getData().getString("mimetype");
            Long contentLength;
            contentLength = msg.getData().getLong("contentLength");
            mDownloadListener.onDownloadStart(url, userAgent,
                            contentDisposition, mimetype, contentLength);
        } //End block
        //End case DOWNLOAD_FILE 
        //Begin case CREATE_WINDOW 
        {
            {
                boolean varCA4DEF2232E40AB74480F33C634607EF_1573430171 = (!mWebChromeClient.onCreateWindow(mWebView,
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
        Bundle bundle;
        bundle = msg.getData();
        //End case SAVE_PASSWORD 
        //Begin case SAVE_PASSWORD 
        String schemePlusHost;
        schemePlusHost = bundle.getString("host");
        //End case SAVE_PASSWORD 
        //Begin case SAVE_PASSWORD 
        String username;
        username = bundle.getString("username");
        //End case SAVE_PASSWORD 
        //Begin case SAVE_PASSWORD 
        String password;
        password = bundle.getString("password");
        //End case SAVE_PASSWORD 
        //Begin case SAVE_PASSWORD 
        {
            boolean var9F67D473B77F606385B1233B373B2F7E_196538260 = (!mWebView.onSavePassword(schemePlusHost, username, password,
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
            HashMap<String, Object> map;
            map = (HashMap<String, Object>) msg.obj;
            String databaseIdentifier;
            databaseIdentifier = (String) map.get("databaseIdentifier");
            String url;
            url = (String) map.get("url");
            long currentQuota;
            currentQuota = ((Long) map.get("currentQuota")).longValue();
            long totalUsedQuota;
            totalUsedQuota = ((Long) map.get("totalUsedQuota")).longValue();
            long estimatedSize;
            estimatedSize = ((Long) map.get("estimatedSize")).longValue();
            WebStorage.QuotaUpdater quotaUpdater;
            quotaUpdater = (WebStorage.QuotaUpdater) map.get("quotaUpdater");
            mWebChromeClient.onExceededDatabaseQuota(url,
                            databaseIdentifier, currentQuota, estimatedSize,
                            totalUsedQuota, quotaUpdater);
        } //End block
        //End case EXCEEDED_DATABASE_QUOTA 
        //Begin case REACHED_APPCACHE_MAXSIZE 
        {
            HashMap<String, Object> map;
            map = (HashMap<String, Object>) msg.obj;
            long spaceNeeded;
            spaceNeeded = ((Long) map.get("spaceNeeded")).longValue();
            long totalUsedQuota;
            totalUsedQuota = ((Long) map.get("totalUsedQuota")).longValue();
            WebStorage.QuotaUpdater quotaUpdater;
            quotaUpdater = (WebStorage.QuotaUpdater) map.get("quotaUpdater");
            mWebChromeClient.onReachedMaxAppCacheSize(spaceNeeded,
                            totalUsedQuota, quotaUpdater);
        } //End block
        //End case REACHED_APPCACHE_MAXSIZE 
        //Begin case GEOLOCATION_PERMISSIONS_SHOW_PROMPT 
        {
            HashMap<String, Object> map;
            map = (HashMap<String, Object>) msg.obj;
            String origin;
            origin = (String) map.get("origin");
            GeolocationPermissions.Callback callback;
            callback = (GeolocationPermissions.Callback)
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
            JsResult res;
            res = (JsResult) msg.obj;
            String message;
            message = msg.getData().getString("message");
            String url;
            url = msg.getData().getString("url");
            {
                boolean var2B314E204AF90E9D5C262473E2474057_126696619 = (!mWebChromeClient.onJsAlert(mWebView, url, message,
                            res));
                {
                    {
                        boolean var4218353CEA22DDF22AB5EDE22089AF6A_364268435 = (!canShowAlertDialog());
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
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.906 -0400", hash_original_method = "05F12CF533E1857877A8AD104A11AF52", hash_generated_method = "94A2EC75240E4150B82D879FD1724991")
                        //DSFIXME:  CODE0002: Requires DSC value to be set
                        public void onClick(
                                                    DialogInterface dialog,
                                                    int which) {
                            //DSFIXME:  CODE0009: Possible callback target function detected
                            dsTaint.addTaint(which);
                            dsTaint.addTaint(dialog.dsTaint);
                            res.confirm();
                            // ---------- Original Method ----------
                            //res.confirm();
                        }
})
                                .setOnCancelListener(
                                        new DialogInterface.OnCancelListener() {                        
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.906 -0400", hash_original_method = "B1C3BAB04B07B0569E11AD7C29C844EB", hash_generated_method = "5B766CBC9E8B63ECCB96752A1A4D4FE5")
                        //DSFIXME:  CODE0002: Requires DSC value to be set
                        public void onCancel(
                                                    DialogInterface dialog) {
                            //DSFIXME:  CODE0009: Possible callback target function detected
                            dsTaint.addTaint(dialog.dsTaint);
                            res.cancel();
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
            JsResult res;
            res = (JsResult) msg.obj;
            String message;
            message = msg.getData().getString("message");
            String url;
            url = msg.getData().getString("url");
            {
                boolean varCEC3E2F96978ADAB5E3F04F9703AB0A2_960313071 = (!mWebChromeClient.onJsConfirm(mWebView, url, message,
                            res));
                {
                    {
                        boolean var4218353CEA22DDF22AB5EDE22089AF6A_982470550 = (!canShowAlertDialog());
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
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.907 -0400", hash_original_method = "05F12CF533E1857877A8AD104A11AF52", hash_generated_method = "94A2EC75240E4150B82D879FD1724991")
                        //DSFIXME:  CODE0002: Requires DSC value to be set
                        public void onClick(
                                                    DialogInterface dialog,
                                                    int which) {
                            //DSFIXME:  CODE0009: Possible callback target function detected
                            dsTaint.addTaint(which);
                            dsTaint.addTaint(dialog.dsTaint);
                            res.confirm();
                            // ---------- Original Method ----------
                            //res.confirm();
                        }
})
                                .setNegativeButton(R.string.cancel,
                                        new DialogInterface.OnClickListener() {                        
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.907 -0400", hash_original_method = "E8564283849E341A10A9BCD809087039", hash_generated_method = "6118E287A1B623D8A3B9AC09598D35F6")
                        //DSFIXME:  CODE0002: Requires DSC value to be set
                        public void onClick(
                                                    DialogInterface dialog,
                                                    int which) {
                            //DSFIXME:  CODE0009: Possible callback target function detected
                            dsTaint.addTaint(which);
                            dsTaint.addTaint(dialog.dsTaint);
                            res.cancel();
                            // ---------- Original Method ----------
                            //res.cancel();
                        }
})
                                .setOnCancelListener(
                                        new DialogInterface.OnCancelListener() {                        
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.907 -0400", hash_original_method = "B1C3BAB04B07B0569E11AD7C29C844EB", hash_generated_method = "5B766CBC9E8B63ECCB96752A1A4D4FE5")
                        //DSFIXME:  CODE0002: Requires DSC value to be set
                        public void onCancel(
                                                    DialogInterface dialog) {
                            //DSFIXME:  CODE0009: Possible callback target function detected
                            dsTaint.addTaint(dialog.dsTaint);
                            res.cancel();
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
            JsPromptResult res;
            res = (JsPromptResult) msg.obj;
            String message;
            message = msg.getData().getString("message");
            String defaultVal;
            defaultVal = msg.getData().getString("default");
            String url;
            url = msg.getData().getString("url");
            {
                boolean varD1458F3A7A7296BB0B89C4571E6E6E68_286829792 = (!mWebChromeClient.onJsPrompt(mWebView, url, message,
                                defaultVal, res));
                {
                    {
                        boolean var4218353CEA22DDF22AB5EDE22089AF6A_563453801 = (!canShowAlertDialog());
                        {
                            res.cancel();
                            res.setReady();
                        } //End block
                    } //End collapsed parenthetic
                    LayoutInflater factory;
                    factory = LayoutInflater
                                .from(mContext);
                    View view;
                    view = factory.inflate(R.layout.js_prompt,
                                null);
                    EditText v;
                    v = (EditText) view
                                .findViewById(R.id.value);
                    v.setText(defaultVal);
                    ((TextView) view.findViewById(R.id.message))
                                .setText(message);
                    new AlertDialog.Builder(mContext)
                                .setTitle(getJsDialogTitle(url))
                                .setView(view)
                                .setPositiveButton(R.string.ok,
                                        new DialogInterface.OnClickListener() {                        
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.908 -0400", hash_original_method = "0D058E55C4ABCB67B49D4279EABD89A8", hash_generated_method = "E960742C9E74A7685DD1F27717610AF5")
                        //DSFIXME:  CODE0002: Requires DSC value to be set
                        public void onClick(
                                                    DialogInterface dialog,
                                                    int whichButton) {
                            //DSFIXME:  CODE0009: Possible callback target function detected
                            dsTaint.addTaint(whichButton);
                            dsTaint.addTaint(dialog.dsTaint);
                            res.confirm(v.getText()
                                                        .toString());
                            // ---------- Original Method ----------
                            //res.confirm(v.getText()
                                                        //.toString());
                        }
})
                                .setNegativeButton(R.string.cancel,
                                        new DialogInterface.OnClickListener() {                        
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.908 -0400", hash_original_method = "862A9D411C13397AC08A0EA3C0A3F1C1", hash_generated_method = "695ED680E49352B5E896FB62428D13A1")
                        //DSFIXME:  CODE0002: Requires DSC value to be set
                        public void onClick(
                                                    DialogInterface dialog,
                                                    int whichButton) {
                            //DSFIXME:  CODE0009: Possible callback target function detected
                            dsTaint.addTaint(whichButton);
                            dsTaint.addTaint(dialog.dsTaint);
                            res.cancel();
                            // ---------- Original Method ----------
                            //res.cancel();
                        }
})
                                .setOnCancelListener(
                                        new DialogInterface.OnCancelListener() {                        
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.909 -0400", hash_original_method = "B1C3BAB04B07B0569E11AD7C29C844EB", hash_generated_method = "5B766CBC9E8B63ECCB96752A1A4D4FE5")
                        //DSFIXME:  CODE0002: Requires DSC value to be set
                        public void onCancel(
                                                    DialogInterface dialog) {
                            //DSFIXME:  CODE0009: Possible callback target function detected
                            dsTaint.addTaint(dialog.dsTaint);
                            res.cancel();
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
            JsResult res;
            res = (JsResult) msg.obj;
            String message;
            message = msg.getData().getString("message");
            String url;
            url = msg.getData().getString("url");
            {
                boolean var8ABC06169F6D42F5FE298C298209BC4D_750181159 = (!mWebChromeClient.onJsBeforeUnload(mWebView, url,
                            message, res));
                {
                    {
                        boolean var4218353CEA22DDF22AB5EDE22089AF6A_1403797250 = (!canShowAlertDialog());
                        {
                            res.cancel();
                            res.setReady();
                        } //End block
                    } //End collapsed parenthetic
                    String m;
                    m = mContext.getString(
                                R.string.js_dialog_before_unload, message);
                    new AlertDialog.Builder(mContext)
                                .setMessage(m)
                                .setPositiveButton(R.string.ok,
                                        new DialogInterface.OnClickListener() {                        
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.909 -0400", hash_original_method = "05F12CF533E1857877A8AD104A11AF52", hash_generated_method = "94A2EC75240E4150B82D879FD1724991")
                        //DSFIXME:  CODE0002: Requires DSC value to be set
                        public void onClick(
                                                    DialogInterface dialog,
                                                    int which) {
                            //DSFIXME:  CODE0009: Possible callback target function detected
                            dsTaint.addTaint(which);
                            dsTaint.addTaint(dialog.dsTaint);
                            res.confirm();
                            // ---------- Original Method ----------
                            //res.confirm();
                        }
})
                                .setNegativeButton(R.string.cancel,
                                        new DialogInterface.OnClickListener() {                        
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.909 -0400", hash_original_method = "E8564283849E341A10A9BCD809087039", hash_generated_method = "6118E287A1B623D8A3B9AC09598D35F6")
                        //DSFIXME:  CODE0002: Requires DSC value to be set
                        public void onClick(
                                                    DialogInterface dialog,
                                                    int which) {
                            //DSFIXME:  CODE0009: Possible callback target function detected
                            dsTaint.addTaint(which);
                            dsTaint.addTaint(dialog.dsTaint);
                            res.cancel();
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
            JsResult res;
            res = (JsResult) msg.obj;
            {
                boolean var7D789827BC3613BFFF7C61EDCD02B4DD_1029955283 = (mWebChromeClient.onJsTimeout());
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
        String message;
        message = msg.getData().getString("message");
        //End case ADD_MESSAGE_TO_CONSOLE 
        //Begin case ADD_MESSAGE_TO_CONSOLE 
        String sourceID;
        sourceID = msg.getData().getString("sourceID");
        //End case ADD_MESSAGE_TO_CONSOLE 
        //Begin case ADD_MESSAGE_TO_CONSOLE 
        int lineNumber;
        lineNumber = msg.getData().getInt("lineNumber");
        //End case ADD_MESSAGE_TO_CONSOLE 
        //Begin case ADD_MESSAGE_TO_CONSOLE 
        int msgLevel;
        msgLevel = msg.getData().getInt("msgLevel");
        //End case ADD_MESSAGE_TO_CONSOLE 
        //Begin case ADD_MESSAGE_TO_CONSOLE 
        int numberOfMessageLevels;
        numberOfMessageLevels = ConsoleMessage.MessageLevel.values().length;
        //End case ADD_MESSAGE_TO_CONSOLE 
        //Begin case ADD_MESSAGE_TO_CONSOLE 
        {
            msgLevel = 0;
        } //End block
        //End case ADD_MESSAGE_TO_CONSOLE 
        //Begin case ADD_MESSAGE_TO_CONSOLE 
        ConsoleMessage.MessageLevel messageLevel;
        messageLevel = ConsoleMessage.MessageLevel.values()[msgLevel];
        //End case ADD_MESSAGE_TO_CONSOLE 
        //Begin case ADD_MESSAGE_TO_CONSOLE 
        {
            boolean var03B98152D53A46B45BCC62B17A0B0B34_1657045664 = (!mWebChromeClient.onConsoleMessage(new ConsoleMessage(message, sourceID,
                        lineNumber, messageLevel)));
            {
                String logTag;
                logTag = "Web Console";
                String logMessage;
                logMessage = message + " at " + sourceID + ":" + lineNumber;
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
            UploadFileMessageData data;
            data = (UploadFileMessageData)msg.obj;
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
            String host;
            host = msg.getData().getString("host");
            String realm;
            realm = msg.getData().getString("realm");
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
            SearchBoxImpl searchBox;
            searchBox = (SearchBoxImpl) mWebView.getSearchBox();
            @SuppressWarnings("unchecked") List<String> suggestions;
            suggestions = (List<String>) msg.obj;
            searchBox.handleSuggestions(msg.getData().getString("query"), suggestions);
        } //End block
        //End case NOTIFY_SEARCHBOX_LISTENERS 
        //Begin case AUTO_LOGIN 
        {
            {
                String realm;
                realm = msg.getData().getString("realm");
                String account;
                account = msg.getData().getString("account");
                String args;
                args = msg.getData().getString("args");
                mWebViewClient.onReceivedLoginRequest(mWebView, realm,
                            account, args);
            } //End block
        } //End block
        //End case AUTO_LOGIN 
        //Begin case SEARCHBOX_IS_SUPPORTED_CALLBACK 
        {
            SearchBoxImpl searchBox;
            searchBox = (SearchBoxImpl) mWebView.getSearchBox();
            Boolean supported;
            supported = (Boolean) msg.obj;
            searchBox.handleIsSupportedCallback(supported);
        } //End block
        //End case SEARCHBOX_IS_SUPPORTED_CALLBACK 
        //Begin case SEARCHBOX_DISPATCH_COMPLETE_CALLBACK 
        {
            SearchBoxImpl searchBox;
            searchBox = (SearchBoxImpl) mWebView.getSearchBox();
            Boolean success;
            success = (Boolean) msg.obj;
            searchBox.handleDispatchCompleteCallback(msg.getData().getString("function"),
                        msg.getData().getInt("id"), success);
        } //End block
        //End case SEARCHBOX_DISPATCH_COMPLETE_CALLBACK 
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.912 -0400", hash_original_method = "F4FA55F4EB9CE414FB8C02AF96B11745", hash_generated_method = "49E9D542614664847663A7BC2196390E")
    @DSModeled(DSC.SAFE)
    public int getProgress() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mLatestProgress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.912 -0400", hash_original_method = "ADEA75F6BB5426452E05F86965232852", hash_generated_method = "1E917B7774EEA475E723DB7EC0CF755D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void switchOutDrawHistory() {
        sendMessage(obtainMessage(SWITCH_OUT_HISTORY));
        // ---------- Original Method ----------
        //sendMessage(obtainMessage(SWITCH_OUT_HISTORY));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.912 -0400", hash_original_method = "2F62F4E531DE0AF4C82D66205801E78A", hash_generated_method = "DD1135953FEBC6771A0929FAF11B2274")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String getJsDialogTitle(String url) {
        dsTaint.addTaint(url);
        String title;
        title = url;
        {
            boolean var85E84E44E3BDEA9917ECB02744CCBE14_422172493 = (URLUtil.isDataUrl(url));
            {
                title = mContext.getString(R.string.js_dialog_title_default);
            } //End block
            {
                try 
                {
                    URL aUrl;
                    aUrl = new URL(url);
                    title = mContext.getString(R.string.js_dialog_title,
                        aUrl.getProtocol() + "://" + aUrl.getHost());
                } //End block
                catch (MalformedURLException ex)
                { }
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.913 -0400", hash_original_method = "FEA38F8F6B5615AC736396CA90380013", hash_generated_method = "E244FE2CF19ED8287438DF89DF4D3458")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onPageStarted(String url, Bitmap favicon) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(favicon.dsTaint);
        dsTaint.addTaint(url);
        {
            mWebCoreThreadTime = SystemClock.currentThreadTimeMillis();
            mWebCoreIdleTime = 0;
            Network.getInstance(mContext).startTiming();
        } //End block
        Message msg;
        msg = obtainMessage(PAGE_STARTED);
        msg.obj = favicon;
        msg.getData().putString("url", url);
        sendMessage(msg);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.913 -0400", hash_original_method = "0C202F92443A2E2B58845ECCCDAD23DA", hash_generated_method = "AFB2AF96058BE472CB7DFBCDBB048F17")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onPageFinished(String url) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(url);
        {
            Log.d("WebCore", "WebCore thread used " +
                    (SystemClock.currentThreadTimeMillis() - mWebCoreThreadTime)
                    + " ms and idled " + mWebCoreIdleTime + " ms");
            Network.getInstance(mContext).stopTiming();
        } //End block
        Message msg;
        msg = obtainMessage(PAGE_FINISHED, url);
        sendMessage(msg);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.913 -0400", hash_original_method = "CAA94892A4D7B008F19D8BD2AD9FB2D3", hash_generated_method = "665842EE96F132330F1A2A2F4E9B6343")
    @DSModeled(DSC.SAFE)
    public void onTooManyRedirects(Message cancelMsg, Message continueMsg) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(cancelMsg.dsTaint);
        dsTaint.addTaint(continueMsg.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.913 -0400", hash_original_method = "E5C6F1F12DEE48235072B52E91052ED8", hash_generated_method = "BA0A49E09D95F04B496F708D0A13E4D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onReceivedError(int errorCode, String description,
            String failingUrl) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(description);
        dsTaint.addTaint(errorCode);
        dsTaint.addTaint(failingUrl);
        Message msg;
        msg = obtainMessage(REPORT_ERROR);
        msg.arg1 = errorCode;
        msg.getData().putString("description", description);
        msg.getData().putString("failingUrl", failingUrl);
        sendMessage(msg);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.914 -0400", hash_original_method = "5E30734A74D85B2FEB399A04359A0FF5", hash_generated_method = "A50286A2180F39A3E23C4B6F14E7BD4F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onFormResubmission(Message dontResend,
            Message resend) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(resend.dsTaint);
        dsTaint.addTaint(dontResend.dsTaint);
        {
            dontResend.sendToTarget();
        } //End block
        Message msg;
        msg = obtainMessage(RESEND_POST_DATA);
        Bundle bundle;
        bundle = msg.getData();
        bundle.putParcelable("resend", resend);
        bundle.putParcelable("dontResend", dontResend);
        sendMessage(msg);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.914 -0400", hash_original_method = "6A31F6EEFC7A56081588A72CFCF2411E", hash_generated_method = "14A9DF3EE05D947FF0CF22FA9F6DF8AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean shouldOverrideUrlLoading(String url) {
        dsTaint.addTaint(url);
        ResultTransport<Boolean> res;
        res = new ResultTransport<Boolean>(false);
        Message msg;
        msg = obtainMessage(OVERRIDE_URL);
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
        boolean var6024FD61AC5A91282342DCCBC3601D4F_1837898780 = (res.getResult().booleanValue());
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.914 -0400", hash_original_method = "4FA57A455CA03EC6D649ED38E4E56F01", hash_generated_method = "C9AD25EFA0868D35115BDD169900BF5F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onReceivedHttpAuthRequest(HttpAuthHandler handler,
            String hostName, String realmName) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(realmName);
        dsTaint.addTaint(hostName);
        dsTaint.addTaint(handler.dsTaint);
        {
            handler.cancel();
        } //End block
        Message msg;
        msg = obtainMessage(AUTH_REQUEST, handler);
        msg.getData().putString("host", hostName);
        msg.getData().putString("realm", realmName);
        sendMessage(msg);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.914 -0400", hash_original_method = "8BC2AAF24BCB58C98055A520D9453CBA", hash_generated_method = "0205BFEA18BC0D9FD58A0A37AF923AEC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onReceivedSslError(SslErrorHandler handler, SslError error) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(error.dsTaint);
        dsTaint.addTaint(handler.dsTaint);
        {
            handler.cancel();
        } //End block
        Message msg;
        msg = obtainMessage(SSL_ERROR);
        HashMap<String, Object> map;
        map = new HashMap();
        map.put("handler", handler);
        map.put("error", error);
        msg.obj = map;
        sendMessage(msg);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.915 -0400", hash_original_method = "024A377297E93EBA7DF0A134D94D78F7", hash_generated_method = "752A6797DF9350ABB77A23C558D10BE3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onProceededAfterSslError(SslError error) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(error.dsTaint);
        Message msg;
        msg = obtainMessage(PROCEEDED_AFTER_SSL_ERROR);
        msg.obj = error;
        sendMessage(msg);
        // ---------- Original Method ----------
        //if (mWebViewClient == null) {
            //return;
        //}
        //Message msg = obtainMessage(PROCEEDED_AFTER_SSL_ERROR);
        //msg.obj = error;
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.916 -0400", hash_original_method = "86B49DF771A8EEA4B9DCFCD28BAACF5B", hash_generated_method = "25234B158881A46AB7E0798B76B0D8C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onReceivedClientCertRequest(ClientCertRequestHandler handler, String host_and_port) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(host_and_port);
        dsTaint.addTaint(handler.dsTaint);
        {
            handler.cancel();
        } //End block
        Message msg;
        msg = obtainMessage(CLIENT_CERT_REQUEST);
        HashMap<String, Object> map;
        map = new HashMap();
        map.put("handler", handler);
        map.put("host_and_port", host_and_port);
        msg.obj = map;
        sendMessage(msg);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.916 -0400", hash_original_method = "39DDC3E15586955BE54A8DF95CFEEEEF", hash_generated_method = "7D1E63D4DF9394E79D1C499C57ED0DF8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onReceivedCertificate(SslCertificate certificate) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(certificate.dsTaint);
        sendMessage(obtainMessage(RECEIVED_CERTIFICATE, certificate));
        // ---------- Original Method ----------
        //sendMessage(obtainMessage(RECEIVED_CERTIFICATE, certificate));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.916 -0400", hash_original_method = "1419AC91B69314146C4F39503A4D545B", hash_generated_method = "AF437337801F8F0292BDFF905DE21327")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void doUpdateVisitedHistory(String url, boolean isReload) {
        dsTaint.addTaint(isReload);
        dsTaint.addTaint(url);
        sendMessage(obtainMessage(UPDATE_VISITED, isReload ? 1 : 0, 0, url));
        // ---------- Original Method ----------
        //if (mWebViewClient == null) {
            //return;
        //}
        //sendMessage(obtainMessage(UPDATE_VISITED, isReload ? 1 : 0, 0, url));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.916 -0400", hash_original_method = "E95ED4984215917AB442D7D69416BDAD", hash_generated_method = "28B4022043877E1BF1397047A59DCBDA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     WebResourceResponse shouldInterceptRequest(String url) {
        dsTaint.addTaint(url);
        WebResourceResponse r;
        r = mWebViewClient.shouldInterceptRequest(mWebView, url);
        {
            sendMessage(obtainMessage(LOAD_RESOURCE, url));
        } //End block
        return (WebResourceResponse)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.917 -0400", hash_original_method = "AE6FAC3658CBE746F7970ADD50E1DD7A", hash_generated_method = "DB44A119E07BE67D67DB91791E0E8B78")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onUnhandledKeyEvent(KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        sendMessage(obtainMessage(ASYNC_KEYEVENTS, event));
        // ---------- Original Method ----------
        //if (mWebViewClient == null) {
            //return;
        //}
        //sendMessage(obtainMessage(ASYNC_KEYEVENTS, event));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.917 -0400", hash_original_method = "32F0A585D03AD391628455766053FDEF", hash_generated_method = "4AAE00FF1B5676EC1A6DCFBA6B7F8463")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onScaleChanged(float oldScale, float newScale) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(newScale);
        dsTaint.addTaint(oldScale);
        Message msg;
        msg = obtainMessage(SCALE_CHANGED);
        Bundle bundle;
        bundle = msg.getData();
        bundle.putFloat("old", oldScale);
        bundle.putFloat("new", newScale);
        sendMessage(msg);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.917 -0400", hash_original_method = "96CFDF49B56568DC278F123893B1481C", hash_generated_method = "E56BD5CF5C0845D28E0C2EBCE19F6DD5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void onReceivedLoginRequest(String realm, String account, String args) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(realm);
        dsTaint.addTaint(args);
        dsTaint.addTaint(account);
        Message msg;
        msg = obtainMessage(AUTO_LOGIN);
        Bundle bundle;
        bundle = msg.getData();
        bundle.putString("realm", realm);
        bundle.putString("account", account);
        bundle.putString("args", args);
        sendMessage(msg);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.917 -0400", hash_original_method = "757A7F1755FBEFCF499F2AF609552311", hash_generated_method = "1B7BE7E89397C7BBB852FE457E8B25CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onDownloadStart(String url, String userAgent,
            String contentDisposition, String mimetype, long contentLength) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(mimetype);
        dsTaint.addTaint(userAgent);
        dsTaint.addTaint(contentLength);
        dsTaint.addTaint(contentDisposition);
        dsTaint.addTaint(url);
        Message msg;
        msg = obtainMessage(DOWNLOAD_FILE);
        Bundle bundle;
        bundle = msg.getData();
        bundle.putString("url", url);
        bundle.putString("userAgent", userAgent);
        bundle.putString("mimetype", mimetype);
        bundle.putLong("contentLength", contentLength);
        bundle.putString("contentDisposition", contentDisposition);
        sendMessage(msg);
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.918 -0400", hash_original_method = "E36C2E9038F101EB831B9776820C94AF", hash_generated_method = "85C919F7F2B7BF4662F25A4CB7812CA7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onSavePassword(String schemePlusHost, String username,
            String password, Message resumeMsg) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(username);
        dsTaint.addTaint(schemePlusHost);
        dsTaint.addTaint(resumeMsg.dsTaint);
        dsTaint.addTaint(password);
        {
            junit.framework.Assert.assertNull(resumeMsg);
        } //End block
        resumeMsg = obtainMessage(NOTIFY);
        Message msg;
        msg = obtainMessage(SAVE_PASSWORD, resumeMsg);
        Bundle bundle;
        bundle = msg.getData();
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.919 -0400", hash_original_method = "FE09891259ADB46761F758E0F5C88D74", hash_generated_method = "22FDA3A63EBB9A6AE6CBC7FD2AD105D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onReceivedHttpAuthCredentials(String host, String realm,
            String username, String password) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(username);
        dsTaint.addTaint(host);
        dsTaint.addTaint(realm);
        dsTaint.addTaint(password);
        Message msg;
        msg = obtainMessage(AUTH_CREDENTIALS);
        msg.getData().putString("host", host);
        msg.getData().putString("realm", realm);
        msg.getData().putString("username", username);
        msg.getData().putString("password", password);
        sendMessage(msg);
        // ---------- Original Method ----------
        //Message msg = obtainMessage(AUTH_CREDENTIALS);
        //msg.getData().putString("host", host);
        //msg.getData().putString("realm", realm);
        //msg.getData().putString("username", username);
        //msg.getData().putString("password", password);
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.919 -0400", hash_original_method = "7D23376057076E49A1BAAD127CCE1E2E", hash_generated_method = "9057DCBCB7F3BFD18854FC51FD22A789")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onProgressChanged(int newProgress) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(newProgress);
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.920 -0400", hash_original_method = "B29F2764BB6A56E843DFC7CBC2F6C034", hash_generated_method = "756F7A7D4FE82DB34AC3287505DD861D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BrowserFrame createWindow(boolean dialog, boolean userGesture) {
        dsTaint.addTaint(userGesture);
        dsTaint.addTaint(dialog);
        WebView.WebViewTransport transport;
        transport = mWebView.new WebViewTransport();
        Message msg;
        msg = obtainMessage(NOTIFY);
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
        WebView w;
        w = transport.getWebView();
        {
            WebViewCore core;
            core = w.getWebViewCore();
            {
                core.initializeSubwindow();
                BrowserFrame var68AED7A2BEF690A67BB6930551966257_1951662464 = (core.getBrowserFrame());
            } //End block
        } //End block
        return (BrowserFrame)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.920 -0400", hash_original_method = "08655C1DEC40A72DA93F91A66B628CEC", hash_generated_method = "C28AD6A771B27FBA7D6F33F7DD8ED015")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onRequestFocus() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        sendEmptyMessage(REQUEST_FOCUS);
        // ---------- Original Method ----------
        //if (mWebChromeClient == null) {
            //return;
        //}
        //sendEmptyMessage(REQUEST_FOCUS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.920 -0400", hash_original_method = "6FD913BE3AA43F9AAEFF1CB8B9D39A33", hash_generated_method = "06963D688772D9168166B5582B79CEF8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onCloseWindow(WebView window) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(window.dsTaint);
        sendMessage(obtainMessage(CLOSE_WINDOW, window));
        // ---------- Original Method ----------
        //if (mWebChromeClient == null) {
            //return;
        //}
        //sendMessage(obtainMessage(CLOSE_WINDOW, window));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.921 -0400", hash_original_method = "F08C9B8424214ACDF6DD6A6D99BF0681", hash_generated_method = "660718B93B60270233AC6E6B9FC78F00")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onReceivedIcon(Bitmap icon) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(icon.dsTaint);
        WebHistoryItem i;
        i = mBackForwardList.getCurrentItem();
        {
            i.setFavicon(icon);
        } //End block
        sendMessage(obtainMessage(RECEIVED_ICON, icon));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.921 -0400", hash_original_method = "F0350B43E0ECCB1BDA5D312CA7F06F8A", hash_generated_method = "E0C575812A09166946EA2940EA165C81")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void onReceivedTouchIconUrl(String url, boolean precomposed) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(precomposed);
        dsTaint.addTaint(url);
        WebHistoryItem i;
        i = mBackForwardList.getCurrentItem();
        {
            i.setTouchIconUrl(url, precomposed);
        } //End block
        sendMessage(obtainMessage(RECEIVED_TOUCH_ICON_URL,
                precomposed ? 1 : 0, 0, url));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.921 -0400", hash_original_method = "91CD241BD0413BEA62EE65C753144C77", hash_generated_method = "69855717A3B9C5007BD6B1E57E075B18")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onReceivedTitle(String title) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(title);
        sendMessage(obtainMessage(RECEIVED_TITLE, title));
        // ---------- Original Method ----------
        //if (mWebChromeClient == null) {
            //return;
        //}
        //sendMessage(obtainMessage(RECEIVED_TITLE, title));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.921 -0400", hash_original_method = "7099C31F609DFFDBC7FE4DB990C0E80D", hash_generated_method = "5C48AB57C2630B256DFBD6931DED1559")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onJsAlert(String url, String message) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(message);
        dsTaint.addTaint(url);
        JsResult result;
        result = new JsResult(this, false);
        Message alert;
        alert = obtainMessage(JS_ALERT, result);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.922 -0400", hash_original_method = "043F4DC8C3BE16DF648461B096D08CDF", hash_generated_method = "5ADF394AF4EA67D1F0873A85A500F922")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onJsConfirm(String url, String message) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(message);
        dsTaint.addTaint(url);
        JsResult result;
        result = new JsResult(this, false);
        Message confirm;
        confirm = obtainMessage(JS_CONFIRM, result);
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
        boolean var24B13E75CB06D38BE89AEA8EA3E557D5_1507494201 = (result.getResult());
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.922 -0400", hash_original_method = "994C85F742AA26A8662DEB752BD55192", hash_generated_method = "3A4DAE348222A84DA90D53BA71159BB1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String onJsPrompt(String url, String message, String defaultValue) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(message);
        dsTaint.addTaint(defaultValue);
        dsTaint.addTaint(url);
        JsPromptResult result;
        result = new JsPromptResult(this);
        Message prompt;
        prompt = obtainMessage(JS_PROMPT, result);
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
        String var27D45771AE1277AC4C2EB26867C1AA0B_581281264 = (result.getStringResult());
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.923 -0400", hash_original_method = "C62C6CDF3925B75D5791E39530CD4D60", hash_generated_method = "BEFF340F74996603852D102DB8E49EDC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onJsBeforeUnload(String url, String message) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(message);
        dsTaint.addTaint(url);
        JsResult result;
        result = new JsResult(this, true);
        Message confirm;
        confirm = obtainMessage(JS_UNLOAD, result);
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
        boolean var24B13E75CB06D38BE89AEA8EA3E557D5_1931909253 = (result.getResult());
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.923 -0400", hash_original_method = "2A1C263B6B48827DF8BFBCAAE8358B4D", hash_generated_method = "FD52DC2DFA83791EA6B4266D8F0217C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onExceededDatabaseQuota(
            String url, String databaseIdentifier, long currentQuota,
            long estimatedSize, long totalUsedQuota,
            WebStorage.QuotaUpdater quotaUpdater) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(quotaUpdater.dsTaint);
        dsTaint.addTaint(totalUsedQuota);
        dsTaint.addTaint(currentQuota);
        dsTaint.addTaint(estimatedSize);
        dsTaint.addTaint(databaseIdentifier);
        dsTaint.addTaint(url);
        {
            quotaUpdater.updateQuota(currentQuota);
        } //End block
        Message exceededQuota;
        exceededQuota = obtainMessage(EXCEEDED_DATABASE_QUOTA);
        HashMap<String, Object> map;
        map = new HashMap();
        map.put("databaseIdentifier", databaseIdentifier);
        map.put("url", url);
        map.put("currentQuota", currentQuota);
        map.put("estimatedSize", estimatedSize);
        map.put("totalUsedQuota", totalUsedQuota);
        map.put("quotaUpdater", quotaUpdater);
        exceededQuota.obj = map;
        sendMessage(exceededQuota);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.923 -0400", hash_original_method = "6FEDE2ECE3E4B773BADE3DEA30808B9D", hash_generated_method = "9B815094DC86757327598B85758C74A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onReachedMaxAppCacheSize(long spaceNeeded,
            long totalUsedQuota, WebStorage.QuotaUpdater quotaUpdater) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(quotaUpdater.dsTaint);
        dsTaint.addTaint(totalUsedQuota);
        dsTaint.addTaint(spaceNeeded);
        {
            quotaUpdater.updateQuota(0);
        } //End block
        Message msg;
        msg = obtainMessage(REACHED_APPCACHE_MAXSIZE);
        HashMap<String, Object> map;
        map = new HashMap();
        map.put("spaceNeeded", spaceNeeded);
        map.put("totalUsedQuota", totalUsedQuota);
        map.put("quotaUpdater", quotaUpdater);
        msg.obj = map;
        sendMessage(msg);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.923 -0400", hash_original_method = "26533187FD051756DFC2CF1CEE3F806F", hash_generated_method = "8C4D07C3AC03DBFE13E2F03D21B0D04C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onGeolocationPermissionsShowPrompt(String origin,
            GeolocationPermissions.Callback callback) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(origin);
        Message showMessage;
        showMessage = obtainMessage(GEOLOCATION_PERMISSIONS_SHOW_PROMPT);
        HashMap<String, Object> map;
        map = new HashMap();
        map.put("origin", origin);
        map.put("callback", callback);
        showMessage.obj = map;
        sendMessage(showMessage);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.924 -0400", hash_original_method = "9C25F80E0E6C6F6C487DBDD3AFCBA4E7", hash_generated_method = "447DCA672D4F42BAD03333064199140B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onGeolocationPermissionsHidePrompt() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Message hideMessage;
        hideMessage = obtainMessage(GEOLOCATION_PERMISSIONS_HIDE_PROMPT);
        sendMessage(hideMessage);
        // ---------- Original Method ----------
        //if (mWebChromeClient == null) {
            //return;
        //}
        //Message hideMessage = obtainMessage(GEOLOCATION_PERMISSIONS_HIDE_PROMPT);
        //sendMessage(hideMessage);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.924 -0400", hash_original_method = "E08EA131E9320463E856348907B813CB", hash_generated_method = "FB52F5642C973AE30309F81838CD198C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addMessageToConsole(String message, int lineNumber, String sourceID, int msgLevel) {
        dsTaint.addTaint(sourceID);
        dsTaint.addTaint(message);
        dsTaint.addTaint(lineNumber);
        dsTaint.addTaint(msgLevel);
        Message msg;
        msg = obtainMessage(ADD_MESSAGE_TO_CONSOLE);
        msg.getData().putString("message", message);
        msg.getData().putString("sourceID", sourceID);
        msg.getData().putInt("lineNumber", lineNumber);
        msg.getData().putInt("msgLevel", msgLevel);
        sendMessage(msg);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.924 -0400", hash_original_method = "288C2B13F2CEF8B24515719050488B19", hash_generated_method = "10E6E25AFB48554870345B011D8A50B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onJsTimeout() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        JsResult result;
        result = new JsResult(this, true);
        Message timeout;
        timeout = obtainMessage(JS_TIMEOUT, result);
        {
            sendMessage(timeout);
            try 
            {
                wait();
            } //End block
            catch (InterruptedException e)
            { }
        } //End block
        boolean var24B13E75CB06D38BE89AEA8EA3E557D5_91144139 = (result.getResult());
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.924 -0400", hash_original_method = "F9E2141EE9507A71AC258BF46DA1BEA9", hash_generated_method = "216C1571BB14CAFEF85A0EA8F29E0A56")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getVisitedHistory(ValueCallback<String[]> callback) {
        dsTaint.addTaint(callback.dsTaint);
        Message msg;
        msg = obtainMessage(GET_VISITED_HISTORY);
        msg.obj = callback;
        sendMessage(msg);
        // ---------- Original Method ----------
        //if (mWebChromeClient == null) {
            //return;
        //}
        //Message msg = obtainMessage(GET_VISITED_HISTORY);
        //msg.obj = callback;
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.925 -0400", hash_original_method = "FE04684AB3D72B8C190BB2063ADDA47F", hash_generated_method = "2C680542F488FC4A6CC89DD53633CED7")
    @DSModeled(DSC.SPEC)
     Uri openFileChooser(String acceptType) {
        dsTaint.addTaint(acceptType);
        Message myMessage;
        myMessage = obtainMessage(OPEN_FILE_CHOOSER);
        UploadFile uploadFile;
        uploadFile = new UploadFile();
        UploadFileMessageData data;
        data = new UploadFileMessageData(uploadFile, acceptType);
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
        Uri var599A615D8670EDAD7F5B1E6B8645F9A1_394710229 = (uploadFile.getResult());
        return (Uri)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.925 -0400", hash_original_method = "047BE1D111CE2C04D81802E658F23AB3", hash_generated_method = "E98EFDC95BE85D38BC6770D7F3DFB1F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void onNewHistoryItem(WebHistoryItem item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(item.dsTaint);
        Message msg;
        msg = obtainMessage(ADD_HISTORY_ITEM, item);
        sendMessage(msg);
        // ---------- Original Method ----------
        //if (mWebBackForwardListClient == null) {
            //return;
        //}
        //Message msg = obtainMessage(ADD_HISTORY_ITEM, item);
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.925 -0400", hash_original_method = "895FE5553DA6237DB0B5BAA6BAF66947", hash_generated_method = "635151F4D76C96A8A04FE28EFC4DDEB2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void onIndexChanged(WebHistoryItem item, int index) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(index);
        dsTaint.addTaint(item.dsTaint);
        Message msg;
        msg = obtainMessage(HISTORY_INDEX_CHANGED, index, 0, item);
        sendMessage(msg);
        // ---------- Original Method ----------
        //if (mWebBackForwardListClient == null) {
            //return;
        //}
        //Message msg = obtainMessage(HISTORY_INDEX_CHANGED, index, 0, item);
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.925 -0400", hash_original_method = "8F94850AD3F63EF799E6BEFB2C67734D", hash_generated_method = "4E0A1F5B478223B84535932ACDF0CB2E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void setInstallableWebApp() {
        sendMessage(obtainMessage(SET_INSTALLABLE_WEBAPP));
        // ---------- Original Method ----------
        //if (mWebChromeClient == null) {
            //return;
        //}
        //sendMessage(obtainMessage(SET_INSTALLABLE_WEBAPP));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.926 -0400", hash_original_method = "8DF8998B34FE58BC5486ECCDB22BE44D", hash_generated_method = "24D045C178038D14B02808C528BFE893")
    @DSModeled(DSC.SAFE)
     boolean canShowAlertDialog() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mContext instanceof Activity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.926 -0400", hash_original_method = "C20FB9F0C31604564B2DC30DE7E0C643", hash_generated_method = "48BF3F2FC77A5D6AC84D1BC11B38FE80")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void onSearchboxSuggestionsReceived(String query, List<String> suggestions) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(query);
        dsTaint.addTaint(suggestions.dsTaint);
        Message msg;
        msg = obtainMessage(NOTIFY_SEARCHBOX_LISTENERS);
        msg.obj = suggestions;
        msg.getData().putString("query", query);
        sendMessage(msg);
        // ---------- Original Method ----------
        //Message msg = obtainMessage(NOTIFY_SEARCHBOX_LISTENERS);
        //msg.obj = suggestions;
        //msg.getData().putString("query", query);
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.926 -0400", hash_original_method = "350C274DFDDA43015C8C93D9651125A1", hash_generated_method = "2AD343278C599ED1504A2D5E2CAE0709")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void onIsSupportedCallback(boolean isSupported) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(isSupported);
        Message msg;
        msg = obtainMessage(SEARCHBOX_IS_SUPPORTED_CALLBACK);
        msg.obj = new Boolean(isSupported);
        sendMessage(msg);
        // ---------- Original Method ----------
        //Message msg = obtainMessage(SEARCHBOX_IS_SUPPORTED_CALLBACK);
        //msg.obj = new Boolean(isSupported);
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.926 -0400", hash_original_method = "18679CF45F0FBF6C3076A4EAE4B01ADE", hash_generated_method = "2571822217C1F2ADCDA5F94E91D8DEC3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void onSearchboxDispatchCompleteCallback(String function, int id, boolean success) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(id);
        dsTaint.addTaint(success);
        dsTaint.addTaint(function);
        Message msg;
        msg = obtainMessage(SEARCHBOX_DISPATCH_COMPLETE_CALLBACK);
        msg.obj = Boolean.valueOf(success);
        msg.getData().putString("function", function);
        msg.getData().putInt("id", id);
        sendMessage(msg);
        // ---------- Original Method ----------
        //Message msg = obtainMessage(SEARCHBOX_DISPATCH_COMPLETE_CALLBACK);
        //msg.obj = Boolean.valueOf(success);
        //msg.getData().putString("function", function);
        //msg.getData().putInt("id", id);
        //sendMessage(msg);
    }

    
    private static class ResultTransport<E> {
        private E mResult;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.926 -0400", hash_original_method = "DD22213D197BC89445531F8496343FB8", hash_generated_method = "B3C0921D6E7A5CA7E797D50BFE9AD6B3")
        @DSModeled(DSC.SAFE)
        public ResultTransport(E defaultResult) {
            dsTaint.addTaint(defaultResult.dsTaint);
            // ---------- Original Method ----------
            //mResult = defaultResult;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.927 -0400", hash_original_method = "23B0DB25EF15209B12B4D98F75BC4826", hash_generated_method = "DD21823BFAE65486DF9FE148A00A1959")
        @DSModeled(DSC.SAFE)
        public synchronized void setResult(E result) {
            dsTaint.addTaint(result.dsTaint);
            // ---------- Original Method ----------
            //mResult = result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.927 -0400", hash_original_method = "67EA7E4C242F8EF7A6CF084AEA447779", hash_generated_method = "2D29EEEEA370E58DAA9DAE5127EF4088")
        @DSModeled(DSC.SAFE)
        public synchronized E getResult() {
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mResult;
        }

        
    }


    
    private static class UploadFileMessageData {
        private UploadFile mCallback;
        private String mAcceptType;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.927 -0400", hash_original_method = "506E5829DE4CA65822239D45E416BF71", hash_generated_method = "9E52187EC8EE4CD6FBE6FABB4DC28E88")
        @DSModeled(DSC.SAFE)
        public UploadFileMessageData(UploadFile uploadFile, String acceptType) {
            dsTaint.addTaint(uploadFile.dsTaint);
            dsTaint.addTaint(acceptType);
            // ---------- Original Method ----------
            //mCallback = uploadFile;
            //mAcceptType = acceptType;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.927 -0400", hash_original_method = "9D48109A15DDC7CFDE503C879117A387", hash_generated_method = "DBCCFA2AC6C00146DE71325B4DCFA545")
        @DSModeled(DSC.SAFE)
        public UploadFile getUploadFile() {
            return (UploadFile)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mCallback;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.927 -0400", hash_original_method = "EE5645A876B8829341B5E714F10E353A", hash_generated_method = "CF372BC55032899D15941CC7DE484597")
        @DSModeled(DSC.SAFE)
        public String getAcceptType() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return mAcceptType;
        }

        
    }


    
    private class UploadFile implements ValueCallback<Uri> {
        private Uri mValue;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.927 -0400", hash_original_method = "03ACB4C604ACB7437F287968E3E84AA8", hash_generated_method = "03ACB4C604ACB7437F287968E3E84AA8")
                public UploadFile ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.928 -0400", hash_original_method = "4E719BBCA95A35A86F37F83B7E6AA557", hash_generated_method = "6A23E3BE3A9F25C9557901B5F72C0E91")
        @DSModeled(DSC.SPEC)
        public void onReceiveValue(Uri value) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(value.dsTaint);
            {
                Object var162CC590B8447AA31A644E693FAE87CB_1113831789 = (CallbackProxy.this);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.928 -0400", hash_original_method = "546BF3EDB8840D5BF09D8B66103FFEC6", hash_generated_method = "6900B2C465233C030BED869856E35278")
        @DSModeled(DSC.SPEC)
        public Uri getResult() {
            return (Uri)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mValue;
        }

        
    }


    
    private static final String LOGTAG = "CallbackProxy";
    private static final int PAGE_STARTED                         = 100;
    private static final int RECEIVED_ICON                        = 101;
    private static final int RECEIVED_TITLE                       = 102;
    private static final int OVERRIDE_URL                         = 103;
    private static final int AUTH_REQUEST                         = 104;
    private static final int SSL_ERROR                            = 105;
    private static final int PROGRESS                             = 106;
    private static final int UPDATE_VISITED                       = 107;
    private static final int LOAD_RESOURCE                        = 108;
    private static final int CREATE_WINDOW                        = 109;
    private static final int CLOSE_WINDOW                         = 110;
    private static final int SAVE_PASSWORD                        = 111;
    private static final int JS_ALERT                             = 112;
    private static final int JS_CONFIRM                           = 113;
    private static final int JS_PROMPT                            = 114;
    private static final int JS_UNLOAD                            = 115;
    private static final int ASYNC_KEYEVENTS                      = 116;
    private static final int DOWNLOAD_FILE                        = 118;
    private static final int REPORT_ERROR                         = 119;
    private static final int RESEND_POST_DATA                     = 120;
    private static final int PAGE_FINISHED                        = 121;
    private static final int REQUEST_FOCUS                        = 122;
    private static final int SCALE_CHANGED                        = 123;
    private static final int RECEIVED_CERTIFICATE                 = 124;
    private static final int SWITCH_OUT_HISTORY                   = 125;
    private static final int EXCEEDED_DATABASE_QUOTA              = 126;
    private static final int REACHED_APPCACHE_MAXSIZE             = 127;
    private static final int JS_TIMEOUT                           = 128;
    private static final int ADD_MESSAGE_TO_CONSOLE               = 129;
    private static final int GEOLOCATION_PERMISSIONS_SHOW_PROMPT  = 130;
    private static final int GEOLOCATION_PERMISSIONS_HIDE_PROMPT  = 131;
    private static final int RECEIVED_TOUCH_ICON_URL              = 132;
    private static final int GET_VISITED_HISTORY                  = 133;
    private static final int OPEN_FILE_CHOOSER                    = 134;
    private static final int ADD_HISTORY_ITEM                     = 135;
    private static final int HISTORY_INDEX_CHANGED                = 136;
    private static final int AUTH_CREDENTIALS                     = 137;
    private static final int SET_INSTALLABLE_WEBAPP               = 138;
    private static final int NOTIFY_SEARCHBOX_LISTENERS           = 139;
    private static final int AUTO_LOGIN                           = 140;
    private static final int CLIENT_CERT_REQUEST                  = 141;
    private static final int SEARCHBOX_IS_SUPPORTED_CALLBACK      = 142;
    private static final int SEARCHBOX_DISPATCH_COMPLETE_CALLBACK = 143;
    private static final int PROCEEDED_AFTER_SSL_ERROR            = 144;
    private static final int NOTIFY                               = 200;
    private static final boolean PERF_PROBE = false;
}

