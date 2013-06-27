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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.887 -0400", hash_original_field = "AFFD03B1A69DF9C27FA75CB579217844", hash_generated_field = "6F5FFC523604435BA0DD35F79F6A85A7")

    private volatile WebViewClient mWebViewClient;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.887 -0400", hash_original_field = "3EAB4539F16F501734ACC8C81DE24BD3", hash_generated_field = "63308D14F2EED559304A82F3B2608B81")

    private volatile WebChromeClient mWebChromeClient;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.887 -0400", hash_original_field = "72439B8F99EB438C3DA5D9CD798C6786", hash_generated_field = "99346B50377E115231263981E00655CA")

    private WebView mWebView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.887 -0400", hash_original_field = "8F78F41712391973E9C79C3C35F135BC", hash_generated_field = "28B865E4101EE3CF35095A498919E885")

    private volatile DownloadListener mDownloadListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.887 -0400", hash_original_field = "445D98F13846084C13085D4DFA45B133", hash_generated_field = "1A26E3791D15D6F62673D059D1AEED62")

    private boolean mProgressUpdatePending;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.887 -0400", hash_original_field = "FE2A86390D34D288C679FA58DC8416A1", hash_generated_field = "F9A0FA589BF9C7209A847A27628B4160")

    private volatile int mLatestProgress = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.887 -0400", hash_original_field = "B14EAD6039EB6E741B058E71B841CD60", hash_generated_field = "9FEA62D4C2030775B452E5264DAC80A8")

    private WebBackForwardList mBackForwardList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.887 -0400", hash_original_field = "941CFD4AD27F3B44FE78BBA47FC72EC8", hash_generated_field = "4D827BAF16349A0C02C13EAE658A3C84")

    private volatile WebBackForwardListClient mWebBackForwardListClient;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.887 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.887 -0400", hash_original_field = "1F94E4F555C78CDBD57A123E28B7F0D0", hash_generated_field = "DF2188EEF215035517745E80E9FEC4E8")

    private long mWebCoreThreadTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.887 -0400", hash_original_field = "CEE99203BB8F6A0CE58080EEBA575E35", hash_generated_field = "7B28D3E8445ABAD93158B33A74B93640")

    private long mWebCoreIdleTime;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.893 -0400", hash_original_method = "5020D7570AC9675C7FDC286174BD125E", hash_generated_method = "6DEE1494E92560815E1A9A4AA30DF6BB")
    public  CallbackProxy(Context context, WebView w) {
        mContext = context;
        mWebView = w;
        mBackForwardList = new WebBackForwardList(this);
        // ---------- Original Method ----------
        //mContext = context;
        //mWebView = w;
        //mBackForwardList = new WebBackForwardList(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.894 -0400", hash_original_method = "94198B28324F8EDCEFD396927CFF12D2", hash_generated_method = "DE4F5106C007BE6F57AC8D71C62F1D2E")
    public void setWebViewClient(WebViewClient client) {
        mWebViewClient = client;
        // ---------- Original Method ----------
        //mWebViewClient = client;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.895 -0400", hash_original_method = "F1A871AF9A3B10055BFFA9DC06A940C2", hash_generated_method = "A4796B2C9E1A8FC7B3769895383141E5")
    public WebViewClient getWebViewClient() {
        WebViewClient varB4EAC82CA7396A68D541C85D26508E83_1654292848 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1654292848 = mWebViewClient;
        varB4EAC82CA7396A68D541C85D26508E83_1654292848.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1654292848;
        // ---------- Original Method ----------
        //return mWebViewClient;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.902 -0400", hash_original_method = "92EB7E506A2EF4886CBEC1480289BCB6", hash_generated_method = "4C169B04C3730379147B383EFDBF5622")
    public void setWebChromeClient(WebChromeClient client) {
        mWebChromeClient = client;
        // ---------- Original Method ----------
        //mWebChromeClient = client;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.903 -0400", hash_original_method = "578C7E32D2B540B07E657C95C84E837C", hash_generated_method = "CE2379A26EDEA983109B8D752E951364")
    public WebChromeClient getWebChromeClient() {
        WebChromeClient varB4EAC82CA7396A68D541C85D26508E83_544034025 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_544034025 = mWebChromeClient;
        varB4EAC82CA7396A68D541C85D26508E83_544034025.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_544034025;
        // ---------- Original Method ----------
        //return mWebChromeClient;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.903 -0400", hash_original_method = "36DD14932709DFA3D074F96EC9039EDA", hash_generated_method = "C93408E62641713A784F45E96AAF15BB")
    public void setDownloadListener(DownloadListener client) {
        mDownloadListener = client;
        // ---------- Original Method ----------
        //mDownloadListener = client;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.913 -0400", hash_original_method = "2A97B39171573BABF631C9DB7E378DC9", hash_generated_method = "16A728B0D5A936F2485FA30173749949")
    public WebBackForwardList getBackForwardList() {
        WebBackForwardList varB4EAC82CA7396A68D541C85D26508E83_761005925 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_761005925 = mBackForwardList;
        varB4EAC82CA7396A68D541C85D26508E83_761005925.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_761005925;
        // ---------- Original Method ----------
        //return mBackForwardList;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.914 -0400", hash_original_method = "69271AEE54C61C015B6B50CD212FE110", hash_generated_method = "13A4BC55EE14A943E04C92B28D85EE99")
     void setWebBackForwardListClient(WebBackForwardListClient client) {
        mWebBackForwardListClient = client;
        // ---------- Original Method ----------
        //mWebBackForwardListClient = client;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.914 -0400", hash_original_method = "32023A06CFA84B93B3A0030ADE6E4A41", hash_generated_method = "B982A60D6944172B8B1AC3714FA4CE31")
     WebBackForwardListClient getWebBackForwardListClient() {
        WebBackForwardListClient varB4EAC82CA7396A68D541C85D26508E83_1621019841 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1621019841 = mWebBackForwardListClient;
        varB4EAC82CA7396A68D541C85D26508E83_1621019841.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1621019841;
        // ---------- Original Method ----------
        //return mWebBackForwardListClient;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.915 -0400", hash_original_method = "43AE5B1BF40E67157C7361E5EC862A6C", hash_generated_method = "A60EA827E4E80F316D107C256A2A5851")
    public boolean uiOverrideUrlLoading(String overrideUrl) {
        {
            boolean var46C404494DFD92BDDD02800A6B728B6E_983535518 = (overrideUrl == null || overrideUrl.length() == 0);
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
        addTaint(overrideUrl.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_749458971 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_749458971;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.916 -0400", hash_original_method = "D32407A1261408285F08570A8F2494B0", hash_generated_method = "BB174A0B941F7315FDE2C53B347ECF93")
    public boolean uiOverrideKeyEvent(KeyEvent event) {
        {
            boolean varE0D5CA03F66620B4894C506375BB27AD_1992026779 = (mWebViewClient.shouldOverrideKeyEvent(mWebView, event));
        } //End block
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1327379464 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1327379464;
        // ---------- Original Method ----------
        //if (mWebViewClient != null) {
            //return mWebViewClient.shouldOverrideKeyEvent(mWebView, event);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.018 -0400", hash_original_method = "643B690E8360A657B90F531CC63147C4", hash_generated_method = "0F674960077D6A224B144AA2C73D5DF8")
    @Override
    public void handleMessage(Message msg) {
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
                boolean varCA4DEF2232E40AB74480F33C634607EF_817134155 = (!mWebChromeClient.onCreateWindow(mWebView,
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
            boolean var9F67D473B77F606385B1233B373B2F7E_1217403083 = (!mWebView.onSavePassword(schemePlusHost, username, password,
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
                boolean var2B314E204AF90E9D5C262473E2474057_770195734 = (!mWebChromeClient.onJsAlert(mWebView, url, message,
                            res));
                {
                    {
                        boolean var4218353CEA22DDF22AB5EDE22089AF6A_657873566 = (!canShowAlertDialog());
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
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.956 -0400", hash_original_method = "05F12CF533E1857877A8AD104A11AF52", hash_generated_method = "1F29AD60BC0BF1F340E49E4138292CB4")
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
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.957 -0400", hash_original_method = "B1C3BAB04B07B0569E11AD7C29C844EB", hash_generated_method = "C32F0B4F558DAFEB5877E20C8DAF7127")
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
            JsResult res;
            res = (JsResult) msg.obj;
            String message;
            message = msg.getData().getString("message");
            String url;
            url = msg.getData().getString("url");
            {
                boolean varCEC3E2F96978ADAB5E3F04F9703AB0A2_1012669022 = (!mWebChromeClient.onJsConfirm(mWebView, url, message,
                            res));
                {
                    {
                        boolean var4218353CEA22DDF22AB5EDE22089AF6A_238568385 = (!canShowAlertDialog());
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
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.974 -0400", hash_original_method = "05F12CF533E1857877A8AD104A11AF52", hash_generated_method = "1F29AD60BC0BF1F340E49E4138292CB4")
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
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.974 -0400", hash_original_method = "E8564283849E341A10A9BCD809087039", hash_generated_method = "21F6D49BEE715812EFE3D95DC59D8862")
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
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.974 -0400", hash_original_method = "B1C3BAB04B07B0569E11AD7C29C844EB", hash_generated_method = "C32F0B4F558DAFEB5877E20C8DAF7127")
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
            JsPromptResult res;
            res = (JsPromptResult) msg.obj;
            String message;
            message = msg.getData().getString("message");
            String defaultVal;
            defaultVal = msg.getData().getString("default");
            String url;
            url = msg.getData().getString("url");
            {
                boolean varD1458F3A7A7296BB0B89C4571E6E6E68_90147454 = (!mWebChromeClient.onJsPrompt(mWebView, url, message,
                                defaultVal, res));
                {
                    {
                        boolean var4218353CEA22DDF22AB5EDE22089AF6A_2036040607 = (!canShowAlertDialog());
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
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.976 -0400", hash_original_method = "0D058E55C4ABCB67B49D4279EABD89A8", hash_generated_method = "892DACC8E5C649E0DE4B32D15CD22534")
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
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.977 -0400", hash_original_method = "862A9D411C13397AC08A0EA3C0A3F1C1", hash_generated_method = "6F8C25B774469226F5E1108116AFA52D")
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
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.977 -0400", hash_original_method = "B1C3BAB04B07B0569E11AD7C29C844EB", hash_generated_method = "C32F0B4F558DAFEB5877E20C8DAF7127")
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
            JsResult res;
            res = (JsResult) msg.obj;
            String message;
            message = msg.getData().getString("message");
            String url;
            url = msg.getData().getString("url");
            {
                boolean var8ABC06169F6D42F5FE298C298209BC4D_319560147 = (!mWebChromeClient.onJsBeforeUnload(mWebView, url,
                            message, res));
                {
                    {
                        boolean var4218353CEA22DDF22AB5EDE22089AF6A_965630629 = (!canShowAlertDialog());
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
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.995 -0400", hash_original_method = "05F12CF533E1857877A8AD104A11AF52", hash_generated_method = "1F29AD60BC0BF1F340E49E4138292CB4")
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
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.996 -0400", hash_original_method = "E8564283849E341A10A9BCD809087039", hash_generated_method = "21F6D49BEE715812EFE3D95DC59D8862")
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
            JsResult res;
            res = (JsResult) msg.obj;
            {
                boolean var7D789827BC3613BFFF7C61EDCD02B4DD_1429483478 = (mWebChromeClient.onJsTimeout());
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
            boolean var03B98152D53A46B45BCC62B17A0B0B34_1982558089 = (!mWebChromeClient.onConsoleMessage(new ConsoleMessage(message, sourceID,
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
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.034 -0400", hash_original_method = "F4FA55F4EB9CE414FB8C02AF96B11745", hash_generated_method = "3A5D9A6944586C38DF48EDEE26669BFC")
    public int getProgress() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_246644061 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_246644061;
        // ---------- Original Method ----------
        //return mLatestProgress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.034 -0400", hash_original_method = "ADEA75F6BB5426452E05F86965232852", hash_generated_method = "1E917B7774EEA475E723DB7EC0CF755D")
     void switchOutDrawHistory() {
        sendMessage(obtainMessage(SWITCH_OUT_HISTORY));
        // ---------- Original Method ----------
        //sendMessage(obtainMessage(SWITCH_OUT_HISTORY));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.035 -0400", hash_original_method = "2F62F4E531DE0AF4C82D66205801E78A", hash_generated_method = "D4466047A860C70D689E2E3F030CBB66")
    private String getJsDialogTitle(String url) {
        String varB4EAC82CA7396A68D541C85D26508E83_1442936504 = null; //Variable for return #1
        String title;
        title = url;
        {
            boolean var85E84E44E3BDEA9917ECB02744CCBE14_1470443595 = (URLUtil.isDataUrl(url));
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
        varB4EAC82CA7396A68D541C85D26508E83_1442936504 = title;
        addTaint(url.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1442936504.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1442936504;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.047 -0400", hash_original_method = "FEA38F8F6B5615AC736396CA90380013", hash_generated_method = "AA9FCC57AD65A050974D690BBF226B54")
    public void onPageStarted(String url, Bitmap favicon) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.048 -0400", hash_original_method = "0C202F92443A2E2B58845ECCCDAD23DA", hash_generated_method = "E89E2AF507AAF9A21507BE079816E166")
    public void onPageFinished(String url) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            Log.d("WebCore", "WebCore thread used " +
                    (SystemClock.currentThreadTimeMillis() - mWebCoreThreadTime)
                    + " ms and idled " + mWebCoreIdleTime + " ms");
            Network.getInstance(mContext).stopTiming();
        } //End block
        Message msg;
        msg = obtainMessage(PAGE_FINISHED, url);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.058 -0400", hash_original_method = "CAA94892A4D7B008F19D8BD2AD9FB2D3", hash_generated_method = "BE74632F1B3FA1B5D7F38007511162FF")
    public void onTooManyRedirects(Message cancelMsg, Message continueMsg) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(cancelMsg.getTaint());
        addTaint(continueMsg.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.058 -0400", hash_original_method = "E5C6F1F12DEE48235072B52E91052ED8", hash_generated_method = "996DCAB4CF0A440AC0882F45F60D3CAC")
    public void onReceivedError(int errorCode, String description,
            String failingUrl) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Message msg;
        msg = obtainMessage(REPORT_ERROR);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.061 -0400", hash_original_method = "5E30734A74D85B2FEB399A04359A0FF5", hash_generated_method = "EBFB4F7C22F74D5C80249E5889C487B3")
    public void onFormResubmission(Message dontResend,
            Message resend) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.076 -0400", hash_original_method = "6A31F6EEFC7A56081588A72CFCF2411E", hash_generated_method = "82662264985619E94C4CE25DFE74CC09")
    public boolean shouldOverrideUrlLoading(String url) {
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
        boolean var6024FD61AC5A91282342DCCBC3601D4F_1700429791 = (res.getResult().booleanValue());
        addTaint(url.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1995538133 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1995538133;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.076 -0400", hash_original_method = "4FA57A455CA03EC6D649ED38E4E56F01", hash_generated_method = "CD3CFBB59AD0C8580775D6CF3799647D")
    public void onReceivedHttpAuthRequest(HttpAuthHandler handler,
            String hostName, String realmName) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            handler.cancel();
        } //End block
        Message msg;
        msg = obtainMessage(AUTH_REQUEST, handler);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.077 -0400", hash_original_method = "8BC2AAF24BCB58C98055A520D9453CBA", hash_generated_method = "B53373B9C4222289E7B76E9836AAAE45")
    public void onReceivedSslError(SslErrorHandler handler, SslError error) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.077 -0400", hash_original_method = "024A377297E93EBA7DF0A134D94D78F7", hash_generated_method = "64E99D2C1021FF798CFC850EECCCC0EC")
    public void onProceededAfterSslError(SslError error) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Message msg;
        msg = obtainMessage(PROCEEDED_AFTER_SSL_ERROR);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.083 -0400", hash_original_method = "86B49DF771A8EEA4B9DCFCD28BAACF5B", hash_generated_method = "89AAE3AEB3DE1D09889293A5C9472E2C")
    public void onReceivedClientCertRequest(ClientCertRequestHandler handler, String host_and_port) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.092 -0400", hash_original_method = "39DDC3E15586955BE54A8DF95CFEEEEF", hash_generated_method = "33FBB913AA6B1433E152E56F557F2973")
    public void onReceivedCertificate(SslCertificate certificate) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        sendMessage(obtainMessage(RECEIVED_CERTIFICATE, certificate));
        addTaint(certificate.getTaint());
        // ---------- Original Method ----------
        //sendMessage(obtainMessage(RECEIVED_CERTIFICATE, certificate));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.093 -0400", hash_original_method = "1419AC91B69314146C4F39503A4D545B", hash_generated_method = "257A621515819E761A5E847C2CC1AD7C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.093 -0400", hash_original_method = "E95ED4984215917AB442D7D69416BDAD", hash_generated_method = "A07C40FC859CFDE13BAAA2C85902F111")
     WebResourceResponse shouldInterceptRequest(String url) {
        WebResourceResponse varB4EAC82CA7396A68D541C85D26508E83_2099921964 = null; //Variable for return #1
        WebResourceResponse varB4EAC82CA7396A68D541C85D26508E83_1576236597 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_2099921964 = null;
        } //End block
        WebResourceResponse r;
        r = mWebViewClient.shouldInterceptRequest(mWebView, url);
        {
            sendMessage(obtainMessage(LOAD_RESOURCE, url));
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1576236597 = r;
        addTaint(url.getTaint());
        WebResourceResponse varA7E53CE21691AB073D9660D615818899_58906799; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_58906799 = varB4EAC82CA7396A68D541C85D26508E83_2099921964;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_58906799 = varB4EAC82CA7396A68D541C85D26508E83_1576236597;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_58906799.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_58906799;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.094 -0400", hash_original_method = "AE6FAC3658CBE746F7970ADD50E1DD7A", hash_generated_method = "658FA0B0A870AD6482851ADC8C29B091")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.094 -0400", hash_original_method = "32F0A585D03AD391628455766053FDEF", hash_generated_method = "CBCB2713FB3DEB01F236D7E31D7E3455")
    public void onScaleChanged(float oldScale, float newScale) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Message msg;
        msg = obtainMessage(SCALE_CHANGED);
        Bundle bundle;
        bundle = msg.getData();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.095 -0400", hash_original_method = "96CFDF49B56568DC278F123893B1481C", hash_generated_method = "7CF7BE411A5F69BB3F3BAA24B4C09982")
     void onReceivedLoginRequest(String realm, String account, String args) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Message msg;
        msg = obtainMessage(AUTO_LOGIN);
        Bundle bundle;
        bundle = msg.getData();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.103 -0400", hash_original_method = "757A7F1755FBEFCF499F2AF609552311", hash_generated_method = "FB0DFD4ABDDBE3DEF9A50D31D0369E03")
    public boolean onDownloadStart(String url, String userAgent,
            String contentDisposition, String mimetype, long contentLength) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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
        addTaint(url.getTaint());
        addTaint(userAgent.getTaint());
        addTaint(contentDisposition.getTaint());
        addTaint(mimetype.getTaint());
        addTaint(contentLength);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1415765270 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1415765270;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.104 -0400", hash_original_method = "E36C2E9038F101EB831B9776820C94AF", hash_generated_method = "4B1FD3D04DDCDDE97CC1796F68B718A0")
    public boolean onSavePassword(String schemePlusHost, String username,
            String password, Message resumeMsg) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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
        addTaint(schemePlusHost.getTaint());
        addTaint(username.getTaint());
        addTaint(password.getTaint());
        addTaint(resumeMsg.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2053840469 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2053840469;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.104 -0400", hash_original_method = "FE09891259ADB46761F758E0F5C88D74", hash_generated_method = "3061FD7CB785584B1E7C6CF5AF0F00AB")
    public void onReceivedHttpAuthCredentials(String host, String realm,
            String username, String password) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Message msg;
        msg = obtainMessage(AUTH_CREDENTIALS);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.105 -0400", hash_original_method = "7D23376057076E49A1BAAD127CCE1E2E", hash_generated_method = "86A073D29B5DA25423D75C510737D1A1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.109 -0400", hash_original_method = "B29F2764BB6A56E843DFC7CBC2F6C034", hash_generated_method = "E6ADB1167C2B90B5DB0F6BD46BDD0057")
    public BrowserFrame createWindow(boolean dialog, boolean userGesture) {
        BrowserFrame varB4EAC82CA7396A68D541C85D26508E83_759187142 = null; //Variable for return #1
        BrowserFrame varB4EAC82CA7396A68D541C85D26508E83_1064173421 = null; //Variable for return #2
        BrowserFrame varB4EAC82CA7396A68D541C85D26508E83_2018617053 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_759187142 = null;
        } //End block
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
                varB4EAC82CA7396A68D541C85D26508E83_1064173421 = core.getBrowserFrame();
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2018617053 = null;
        addTaint(dialog);
        addTaint(userGesture);
        BrowserFrame varA7E53CE21691AB073D9660D615818899_1422521148; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1422521148 = varB4EAC82CA7396A68D541C85D26508E83_759187142;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1422521148 = varB4EAC82CA7396A68D541C85D26508E83_1064173421;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1422521148 = varB4EAC82CA7396A68D541C85D26508E83_2018617053;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1422521148.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1422521148;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.113 -0400", hash_original_method = "08655C1DEC40A72DA93F91A66B628CEC", hash_generated_method = "C28AD6A771B27FBA7D6F33F7DD8ED015")
    public void onRequestFocus() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        sendEmptyMessage(REQUEST_FOCUS);
        // ---------- Original Method ----------
        //if (mWebChromeClient == null) {
            //return;
        //}
        //sendEmptyMessage(REQUEST_FOCUS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.129 -0400", hash_original_method = "6FD913BE3AA43F9AAEFF1CB8B9D39A33", hash_generated_method = "2904D76E9340B830141B570CC5A06D2B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.130 -0400", hash_original_method = "F08C9B8424214ACDF6DD6A6D99BF0681", hash_generated_method = "46957D0BF1EBDC842A757C062F55A939")
    public void onReceivedIcon(Bitmap icon) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        WebHistoryItem i;
        i = mBackForwardList.getCurrentItem();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.130 -0400", hash_original_method = "F0350B43E0ECCB1BDA5D312CA7F06F8A", hash_generated_method = "65AACEA4CCD7EC97A0C4777B94DA7C52")
     void onReceivedTouchIconUrl(String url, boolean precomposed) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        WebHistoryItem i;
        i = mBackForwardList.getCurrentItem();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.131 -0400", hash_original_method = "91CD241BD0413BEA62EE65C753144C77", hash_generated_method = "07104B18FA4D2AE7D773C3C1731DE840")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.131 -0400", hash_original_method = "7099C31F609DFFDBC7FE4DB990C0E80D", hash_generated_method = "E7F2881D5F55DC2059F742EB72363D66")
    public void onJsAlert(String url, String message) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.132 -0400", hash_original_method = "043F4DC8C3BE16DF648461B096D08CDF", hash_generated_method = "F713A76C54EBB95D1C14B2E182DC1E70")
    public boolean onJsConfirm(String url, String message) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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
        boolean var24B13E75CB06D38BE89AEA8EA3E557D5_531190513 = (result.getResult());
        addTaint(url.getTaint());
        addTaint(message.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1585082980 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1585082980;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.146 -0400", hash_original_method = "994C85F742AA26A8662DEB752BD55192", hash_generated_method = "D3A548C2150321E11113AAA2772BBF6F")
    public String onJsPrompt(String url, String message, String defaultValue) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        String varB4EAC82CA7396A68D541C85D26508E83_1078462223 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_656577427 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1078462223 = null;
        } //End block
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
        varB4EAC82CA7396A68D541C85D26508E83_656577427 = result.getStringResult();
        addTaint(url.getTaint());
        addTaint(message.getTaint());
        addTaint(defaultValue.getTaint());
        String varA7E53CE21691AB073D9660D615818899_763403497; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_763403497 = varB4EAC82CA7396A68D541C85D26508E83_1078462223;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_763403497 = varB4EAC82CA7396A68D541C85D26508E83_656577427;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_763403497.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_763403497;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.147 -0400", hash_original_method = "C62C6CDF3925B75D5791E39530CD4D60", hash_generated_method = "C6328F8D46E6BDF2E7FA74E4733DE8E9")
    public boolean onJsBeforeUnload(String url, String message) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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
        boolean var24B13E75CB06D38BE89AEA8EA3E557D5_1458315386 = (result.getResult());
        addTaint(url.getTaint());
        addTaint(message.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_217012459 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_217012459;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.148 -0400", hash_original_method = "2A1C263B6B48827DF8BFBCAAE8358B4D", hash_generated_method = "407BBC442763F3BFEF2FCBF3CA15AA13")
    public void onExceededDatabaseQuota(
            String url, String databaseIdentifier, long currentQuota,
            long estimatedSize, long totalUsedQuota,
            WebStorage.QuotaUpdater quotaUpdater) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.149 -0400", hash_original_method = "6FEDE2ECE3E4B773BADE3DEA30808B9D", hash_generated_method = "F50C1B23B2EE0DFE276BF1A06990061A")
    public void onReachedMaxAppCacheSize(long spaceNeeded,
            long totalUsedQuota, WebStorage.QuotaUpdater quotaUpdater) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.166 -0400", hash_original_method = "26533187FD051756DFC2CF1CEE3F806F", hash_generated_method = "D7B54C17A3E65FC4A1B5778181AA811B")
    public void onGeolocationPermissionsShowPrompt(String origin,
            GeolocationPermissions.Callback callback) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Message showMessage;
        showMessage = obtainMessage(GEOLOCATION_PERMISSIONS_SHOW_PROMPT);
        HashMap<String, Object> map;
        map = new HashMap();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.167 -0400", hash_original_method = "9C25F80E0E6C6F6C487DBDD3AFCBA4E7", hash_generated_method = "447DCA672D4F42BAD03333064199140B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.167 -0400", hash_original_method = "E08EA131E9320463E856348907B813CB", hash_generated_method = "819C15D96E26C3928A11369F488AAEC0")
    public void addMessageToConsole(String message, int lineNumber, String sourceID, int msgLevel) {
        Message msg;
        msg = obtainMessage(ADD_MESSAGE_TO_CONSOLE);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.168 -0400", hash_original_method = "288C2B13F2CEF8B24515719050488B19", hash_generated_method = "CDB2775CBE557BE8687539AA5B7A7193")
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
        boolean var24B13E75CB06D38BE89AEA8EA3E557D5_234804469 = (result.getResult());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_731678278 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_731678278;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.168 -0400", hash_original_method = "F9E2141EE9507A71AC258BF46DA1BEA9", hash_generated_method = "915AAF2BAA3FB2BC609DBAF6F74361FE")
    public void getVisitedHistory(ValueCallback<String[]> callback) {
        Message msg;
        msg = obtainMessage(GET_VISITED_HISTORY);
        msg.obj = callback;
        sendMessage(msg);
        addTaint(callback.getTaint());
        // ---------- Original Method ----------
        //if (mWebChromeClient == null) {
            //return;
        //}
        //Message msg = obtainMessage(GET_VISITED_HISTORY);
        //msg.obj = callback;
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.169 -0400", hash_original_method = "FE04684AB3D72B8C190BB2063ADDA47F", hash_generated_method = "5280793DCB7C85AE035F97D53AEB2378")
     Uri openFileChooser(String acceptType) {
        Uri varB4EAC82CA7396A68D541C85D26508E83_52271428 = null; //Variable for return #1
        Uri varB4EAC82CA7396A68D541C85D26508E83_98344402 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_52271428 = null;
        } //End block
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
        varB4EAC82CA7396A68D541C85D26508E83_98344402 = uploadFile.getResult();
        addTaint(acceptType.getTaint());
        Uri varA7E53CE21691AB073D9660D615818899_1890570062; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1890570062 = varB4EAC82CA7396A68D541C85D26508E83_52271428;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1890570062 = varB4EAC82CA7396A68D541C85D26508E83_98344402;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1890570062.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1890570062;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.169 -0400", hash_original_method = "047BE1D111CE2C04D81802E658F23AB3", hash_generated_method = "ED28574DD14319295F83D9C680CDBA65")
     void onNewHistoryItem(WebHistoryItem item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Message msg;
        msg = obtainMessage(ADD_HISTORY_ITEM, item);
        sendMessage(msg);
        addTaint(item.getTaint());
        // ---------- Original Method ----------
        //if (mWebBackForwardListClient == null) {
            //return;
        //}
        //Message msg = obtainMessage(ADD_HISTORY_ITEM, item);
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.173 -0400", hash_original_method = "895FE5553DA6237DB0B5BAA6BAF66947", hash_generated_method = "EFA0683708B2C645B02962C18805397D")
     void onIndexChanged(WebHistoryItem item, int index) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Message msg;
        msg = obtainMessage(HISTORY_INDEX_CHANGED, index, 0, item);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.184 -0400", hash_original_method = "8F94850AD3F63EF799E6BEFB2C67734D", hash_generated_method = "4E0A1F5B478223B84535932ACDF0CB2E")
     void setInstallableWebApp() {
        sendMessage(obtainMessage(SET_INSTALLABLE_WEBAPP));
        // ---------- Original Method ----------
        //if (mWebChromeClient == null) {
            //return;
        //}
        //sendMessage(obtainMessage(SET_INSTALLABLE_WEBAPP));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.185 -0400", hash_original_method = "8DF8998B34FE58BC5486ECCDB22BE44D", hash_generated_method = "84AB115F4F8851E861A50E605A6C1479")
     boolean canShowAlertDialog() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_53983635 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_53983635;
        // ---------- Original Method ----------
        //return mContext instanceof Activity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.185 -0400", hash_original_method = "C20FB9F0C31604564B2DC30DE7E0C643", hash_generated_method = "9AAAD2E90CF789551E5D924830B7E3CA")
     void onSearchboxSuggestionsReceived(String query, List<String> suggestions) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Message msg;
        msg = obtainMessage(NOTIFY_SEARCHBOX_LISTENERS);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.186 -0400", hash_original_method = "350C274DFDDA43015C8C93D9651125A1", hash_generated_method = "106357B0422AE5D4294A2CC63C376AAF")
     void onIsSupportedCallback(boolean isSupported) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Message msg;
        msg = obtainMessage(SEARCHBOX_IS_SUPPORTED_CALLBACK);
        msg.obj = new Boolean(isSupported);
        sendMessage(msg);
        addTaint(isSupported);
        // ---------- Original Method ----------
        //Message msg = obtainMessage(SEARCHBOX_IS_SUPPORTED_CALLBACK);
        //msg.obj = new Boolean(isSupported);
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.186 -0400", hash_original_method = "18679CF45F0FBF6C3076A4EAE4B01ADE", hash_generated_method = "06BCEC815922103BFE6124F94A676C11")
     void onSearchboxDispatchCompleteCallback(String function, int id, boolean success) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Message msg;
        msg = obtainMessage(SEARCHBOX_DISPATCH_COMPLETE_CALLBACK);
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.187 -0400", hash_original_field = "313AEF43C06545BCEAC152A1C285EBE1", hash_generated_field = "8FF1976BF201D1F418EC84B9D35E5FAC")

        private E mResult;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.198 -0400", hash_original_method = "DD22213D197BC89445531F8496343FB8", hash_generated_method = "9633A2A2899E61CCB3453D5B3B8F2949")
        public  ResultTransport(E defaultResult) {
            mResult = defaultResult;
            // ---------- Original Method ----------
            //mResult = defaultResult;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.198 -0400", hash_original_method = "23B0DB25EF15209B12B4D98F75BC4826", hash_generated_method = "1CC67B1DE228486A08B2C64A649EF681")
        public synchronized void setResult(E result) {
            mResult = result;
            // ---------- Original Method ----------
            //mResult = result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.199 -0400", hash_original_method = "67EA7E4C242F8EF7A6CF084AEA447779", hash_generated_method = "AD6428FCD8E97787CEFF1B55C73EFBEF")
        public synchronized E getResult() {
            E varB4EAC82CA7396A68D541C85D26508E83_813099277 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_813099277 = mResult;
            varB4EAC82CA7396A68D541C85D26508E83_813099277.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_813099277;
            // ---------- Original Method ----------
            //return mResult;
        }

        
    }


    
    private static class UploadFileMessageData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.199 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "141E146BCCC9E44E04F619B70ED78B17")

        private UploadFile mCallback;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.199 -0400", hash_original_field = "F7770022153C0271D858491BF09AEACC", hash_generated_field = "F1FEB7E52B3D4A532C0192C9EE3750CA")

        private String mAcceptType;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.199 -0400", hash_original_method = "506E5829DE4CA65822239D45E416BF71", hash_generated_method = "F0F40EDAB8A6F9084FBE2B1F2CCB3C4E")
        public  UploadFileMessageData(UploadFile uploadFile, String acceptType) {
            mCallback = uploadFile;
            mAcceptType = acceptType;
            // ---------- Original Method ----------
            //mCallback = uploadFile;
            //mAcceptType = acceptType;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.199 -0400", hash_original_method = "9D48109A15DDC7CFDE503C879117A387", hash_generated_method = "2729F0842A03E433208CE4E8E9F99074")
        public UploadFile getUploadFile() {
            UploadFile varB4EAC82CA7396A68D541C85D26508E83_1832057888 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1832057888 = mCallback;
            varB4EAC82CA7396A68D541C85D26508E83_1832057888.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1832057888;
            // ---------- Original Method ----------
            //return mCallback;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.200 -0400", hash_original_method = "EE5645A876B8829341B5E714F10E353A", hash_generated_method = "CDF389A1613F287B27758A65DE0A5332")
        public String getAcceptType() {
            String varB4EAC82CA7396A68D541C85D26508E83_551504679 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_551504679 = mAcceptType;
            varB4EAC82CA7396A68D541C85D26508E83_551504679.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_551504679;
            // ---------- Original Method ----------
            //return mAcceptType;
        }

        
    }


    
    private class UploadFile implements ValueCallback<Uri> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.200 -0400", hash_original_field = "CBAFE11E7BAE23358D70D54D132C3064", hash_generated_field = "D24B10CB4DFA145F1AD29B267930EA48")

        private Uri mValue;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.200 -0400", hash_original_method = "CA5F2E6F07869C80D280CD39F96B8098", hash_generated_method = "CA5F2E6F07869C80D280CD39F96B8098")
        public UploadFile ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.200 -0400", hash_original_method = "4E719BBCA95A35A86F37F83B7E6AA557", hash_generated_method = "231831633AC3C6D6409DA3861CB2C58C")
        public void onReceiveValue(Uri value) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mValue = value;
            {
                Object var162CC590B8447AA31A644E693FAE87CB_142742507 = (CallbackProxy.this);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.204 -0400", hash_original_method = "546BF3EDB8840D5BF09D8B66103FFEC6", hash_generated_method = "953F48F186CCE656AA7DB77037390ACC")
        public Uri getResult() {
            Uri varB4EAC82CA7396A68D541C85D26508E83_568080672 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_568080672 = mValue;
            varB4EAC82CA7396A68D541C85D26508E83_568080672.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_568080672;
            // ---------- Original Method ----------
            //return mValue;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.204 -0400", hash_original_field = "8C9130CDA2A66EF5393AEF174DCA2142", hash_generated_field = "8EF8F7A37B1C1546640254B0FAB8AB1E")

    private static String LOGTAG = "CallbackProxy";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.204 -0400", hash_original_field = "3208979F31DB6F208ED1ABFE54C2777D", hash_generated_field = "E913E5E2124B47D70C7D4886B5A35E22")

    private static int PAGE_STARTED = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.205 -0400", hash_original_field = "0595282DB8290097D943FD4835DAE35F", hash_generated_field = "0EA40C07BC8E1B62DDBBC2E8EF2A2DA6")

    private static int RECEIVED_ICON = 101;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.205 -0400", hash_original_field = "32A709EF470502982DE5B92F9E51C52A", hash_generated_field = "CD7FB2FDED04EEDEF02F1AAC5C20E895")

    private static int RECEIVED_TITLE = 102;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.205 -0400", hash_original_field = "AA16AAC9759D194D9ABC14C1DDB9C398", hash_generated_field = "FDC0A79D62603F75138C5E0EAC13C4C6")

    private static int OVERRIDE_URL = 103;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.216 -0400", hash_original_field = "96423544F2C8894B7019D641B104C0B6", hash_generated_field = "1E6457721564C461DA03934B2F6A60B0")

    private static int AUTH_REQUEST = 104;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.217 -0400", hash_original_field = "896362D63C3AA39A676A01B7D029C192", hash_generated_field = "AFA9CD75DE8219740E3635CEDF4EA602")

    private static int SSL_ERROR = 105;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.217 -0400", hash_original_field = "0D541C969BF688AC1DC3481FB24093A4", hash_generated_field = "BE4F811673BA31471DBB712DF00DEE92")

    private static int PROGRESS = 106;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.217 -0400", hash_original_field = "DF889AF98741612C7EBBEFD56FDECA9A", hash_generated_field = "3F845427F79B74A54F4DB93330B9C5DE")

    private static int UPDATE_VISITED = 107;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.217 -0400", hash_original_field = "D54C2218A4F7767E49430B7F45943150", hash_generated_field = "4DB52AA76C405220C5678D75BB0CD99F")

    private static int LOAD_RESOURCE = 108;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.217 -0400", hash_original_field = "3D24951538BC37EE86262B035EFE145E", hash_generated_field = "2031A823DCDDB4A52337B6756D99F84F")

    private static int CREATE_WINDOW = 109;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.217 -0400", hash_original_field = "5FD2B1A14257FCDABB95BB135FF6CBB3", hash_generated_field = "E7DD6D2BAD2B9B621900615C7B6A400C")

    private static int CLOSE_WINDOW = 110;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.217 -0400", hash_original_field = "EED1B544826A0E05E39F4EF9160C9B47", hash_generated_field = "755881BF105781F8CA29C9FFEBFC74F1")

    private static int SAVE_PASSWORD = 111;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.217 -0400", hash_original_field = "EE0ED596D7152BB438F8241ECA3B4A75", hash_generated_field = "798A37AC96ECA98220E4135EA60303ED")

    private static int JS_ALERT = 112;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.217 -0400", hash_original_field = "178663701E6D5A1C3D92DDB7ABC9EFAD", hash_generated_field = "221C7A75B3813ED59C6710D6D20040A5")

    private static int JS_CONFIRM = 113;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.217 -0400", hash_original_field = "691DB536EA212A54B7C75028CA5C5181", hash_generated_field = "6EE6FC2821A4694F1E7C74C0E876B391")

    private static int JS_PROMPT = 114;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.217 -0400", hash_original_field = "63406D7FC3EEAE564C564DA5D918F64F", hash_generated_field = "43DED8FC462D13E3DB3F62B994D8C023")

    private static int JS_UNLOAD = 115;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.217 -0400", hash_original_field = "A2010D893F416BE4FA618E6F4546C076", hash_generated_field = "47F9EA496060D82F3D8F75F6BF1D5E54")

    private static int ASYNC_KEYEVENTS = 116;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.217 -0400", hash_original_field = "C5CA2DBA1E8EB468981612AB11E5B638", hash_generated_field = "03E34AA7C267CB2B5CAF4E2EF42E09DD")

    private static int DOWNLOAD_FILE = 118;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.217 -0400", hash_original_field = "61D34384ACB6D6E6538CBE9CACA042C2", hash_generated_field = "834C4AB755CAEE806D5F18550B95DDFA")

    private static int REPORT_ERROR = 119;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.217 -0400", hash_original_field = "8F7FC97FFDA4549DA6CC4A114FE8B20C", hash_generated_field = "3D39B1292637F36A21A9C63DC33FB655")

    private static int RESEND_POST_DATA = 120;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.217 -0400", hash_original_field = "B49EBE022F8B815D90EE10B8DF4B4ADB", hash_generated_field = "AE9E33B89F2D52F0686CECF224F0CE08")

    private static int PAGE_FINISHED = 121;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.217 -0400", hash_original_field = "EEC292A48E8AF8A7AF74BA09970264A6", hash_generated_field = "76736688D58A42B2751E20111B7746BE")

    private static int REQUEST_FOCUS = 122;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.217 -0400", hash_original_field = "A5F92A21341FA5B16F062DF186B2482A", hash_generated_field = "A733D54AD08164D78233A66D48AE1E1E")

    private static int SCALE_CHANGED = 123;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.217 -0400", hash_original_field = "3419D1FC6211209D479F738FC85856E5", hash_generated_field = "A2F2B028927FD9EF32A21DD027912C47")

    private static int RECEIVED_CERTIFICATE = 124;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.217 -0400", hash_original_field = "7DF692B4B90692F9A506D49F315BC808", hash_generated_field = "983B533253B3BB1185B10232804CECDC")

    private static int SWITCH_OUT_HISTORY = 125;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.217 -0400", hash_original_field = "28A4C0BFA39FFCE75A049D12C90DA34F", hash_generated_field = "6A2F1F8BF21FBF487B59DE142146E7BF")

    private static int EXCEEDED_DATABASE_QUOTA = 126;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.217 -0400", hash_original_field = "5C2E4A8C6C1D6EB0AA73405358873E9D", hash_generated_field = "7A24BC73C5B9F8FD0317BCA9D4D025E9")

    private static int REACHED_APPCACHE_MAXSIZE = 127;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.217 -0400", hash_original_field = "190B5D79FB8A1AF1C80637C850307202", hash_generated_field = "89538CB457CE4C8BA2D42B2FCA6A6317")

    private static int JS_TIMEOUT = 128;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.217 -0400", hash_original_field = "66C31A0DFCEAF967AEAE99F7FE0170F0", hash_generated_field = "507AAF54680AAD2448433A5D4B69EBE5")

    private static int ADD_MESSAGE_TO_CONSOLE = 129;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.217 -0400", hash_original_field = "90E8C851A8F6A9ECE364702E0F8FFC4E", hash_generated_field = "C315D7C2D7D3460150F6663A391D23A9")

    private static int GEOLOCATION_PERMISSIONS_SHOW_PROMPT = 130;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.217 -0400", hash_original_field = "4BA2D5841F9CFA2DDBA1426164A8F234", hash_generated_field = "0595244C18E85AF86357C78831896B38")

    private static int GEOLOCATION_PERMISSIONS_HIDE_PROMPT = 131;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.217 -0400", hash_original_field = "CF11A22DA4127948A476CD033290BC8D", hash_generated_field = "74247CD6D8678EE2674F52227B704E92")

    private static int RECEIVED_TOUCH_ICON_URL = 132;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.217 -0400", hash_original_field = "726C652F40C754AB326CA7662427B968", hash_generated_field = "5779EC9CA0A6393FF940E7CCA6130FF0")

    private static int GET_VISITED_HISTORY = 133;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.217 -0400", hash_original_field = "347D8E095BC47B4EE0D0AFFCD8A441D8", hash_generated_field = "6753077FBAF94E75535210FB135CE40B")

    private static int OPEN_FILE_CHOOSER = 134;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.217 -0400", hash_original_field = "DDA4EF57BA7EDD6865AFB71F66096612", hash_generated_field = "FCB7644C97592A42AC4D022E1B35E0DF")

    private static int ADD_HISTORY_ITEM = 135;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.217 -0400", hash_original_field = "E47A0D78212EBAA6C226917A718522D7", hash_generated_field = "BD76DC026E86005B8680BEC599B65817")

    private static int HISTORY_INDEX_CHANGED = 136;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.218 -0400", hash_original_field = "A6E6D65EDCEBA9E1213EF8CCE6855690", hash_generated_field = "549883B77A3A920E0965E3BF42180C92")

    private static int AUTH_CREDENTIALS = 137;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.218 -0400", hash_original_field = "B11AA85C9F67F142C2BEC310EDCD047D", hash_generated_field = "4A1C593E4B29BD83829C008A1BD0A059")

    private static int SET_INSTALLABLE_WEBAPP = 138;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.218 -0400", hash_original_field = "BF9BFFEF86D2385E78EDDAE2495AB4A0", hash_generated_field = "FE5414E13340CD4D53B544E61A255515")

    private static int NOTIFY_SEARCHBOX_LISTENERS = 139;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.218 -0400", hash_original_field = "E846F0F51A2809AE1103C135CD963FC1", hash_generated_field = "76FEB0C8D07AA219107C8771DBE79AB0")

    private static int AUTO_LOGIN = 140;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.218 -0400", hash_original_field = "F44C77CADA5C31603D09B4649A61FF4C", hash_generated_field = "F9738B4000F83BDA15103F03197A5B6A")

    private static int CLIENT_CERT_REQUEST = 141;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.218 -0400", hash_original_field = "4B8E1AE28BB7AEE993AFE0AD150F701B", hash_generated_field = "1CA7D8BB2A51BBC01B302410E93FC82E")

    private static int SEARCHBOX_IS_SUPPORTED_CALLBACK = 142;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.218 -0400", hash_original_field = "EBDC352F26A1C3C736F3B415141C80D9", hash_generated_field = "AFB9E575E773CF165FEC747D972A2B5C")

    private static int SEARCHBOX_DISPATCH_COMPLETE_CALLBACK = 143;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.218 -0400", hash_original_field = "B7D6B899C6A4B45279ABA6AB53B5C958", hash_generated_field = "640B91F04394FDFCDFC1187B49509460")

    private static int PROCEEDED_AFTER_SSL_ERROR = 144;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.218 -0400", hash_original_field = "E318E94680AF79EA0A7279378C0BC024", hash_generated_field = "8A8C20F2445F9131DBDCB8971D717B5F")

    private static int NOTIFY = 200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.218 -0400", hash_original_field = "F61A6BEC594680894ED6FFB6E74F8F5A", hash_generated_field = "69711E54A4CE5041B7BC3DD698551948")

    private static boolean PERF_PROBE = false;
}

