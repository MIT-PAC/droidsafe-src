package android.webkit;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

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






class CallbackProxy extends Handler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.816 -0400", hash_original_field = "AFFD03B1A69DF9C27FA75CB579217844", hash_generated_field = "6F5FFC523604435BA0DD35F79F6A85A7")

    private volatile WebViewClient mWebViewClient;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.816 -0400", hash_original_field = "3EAB4539F16F501734ACC8C81DE24BD3", hash_generated_field = "63308D14F2EED559304A82F3B2608B81")

    private volatile WebChromeClient mWebChromeClient;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.816 -0400", hash_original_field = "72439B8F99EB438C3DA5D9CD798C6786", hash_generated_field = "99346B50377E115231263981E00655CA")

    private WebView mWebView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.816 -0400", hash_original_field = "8F78F41712391973E9C79C3C35F135BC", hash_generated_field = "28B865E4101EE3CF35095A498919E885")

    private volatile DownloadListener mDownloadListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.816 -0400", hash_original_field = "445D98F13846084C13085D4DFA45B133", hash_generated_field = "1A26E3791D15D6F62673D059D1AEED62")

    private boolean mProgressUpdatePending;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.816 -0400", hash_original_field = "FE2A86390D34D288C679FA58DC8416A1", hash_generated_field = "F9A0FA589BF9C7209A847A27628B4160")

    private volatile int mLatestProgress = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.816 -0400", hash_original_field = "B14EAD6039EB6E741B058E71B841CD60", hash_generated_field = "9FEA62D4C2030775B452E5264DAC80A8")

    private WebBackForwardList mBackForwardList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.816 -0400", hash_original_field = "941CFD4AD27F3B44FE78BBA47FC72EC8", hash_generated_field = "4D827BAF16349A0C02C13EAE658A3C84")

    private volatile WebBackForwardListClient mWebBackForwardListClient;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.816 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.816 -0400", hash_original_field = "1F94E4F555C78CDBD57A123E28B7F0D0", hash_generated_field = "DF2188EEF215035517745E80E9FEC4E8")

    private long mWebCoreThreadTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.816 -0400", hash_original_field = "CEE99203BB8F6A0CE58080EEBA575E35", hash_generated_field = "7B28D3E8445ABAD93158B33A74B93640")

    private long mWebCoreIdleTime;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.816 -0400", hash_original_method = "5020D7570AC9675C7FDC286174BD125E", hash_generated_method = "6DEE1494E92560815E1A9A4AA30DF6BB")
    public  CallbackProxy(Context context, WebView w) {
        mContext = context;
        mWebView = w;
        mBackForwardList = new WebBackForwardList(this);
        // ---------- Original Method ----------
        //mContext = context;
        //mWebView = w;
        //mBackForwardList = new WebBackForwardList(this);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.816 -0400", hash_original_method = "94198B28324F8EDCEFD396927CFF12D2", hash_generated_method = "DE4F5106C007BE6F57AC8D71C62F1D2E")
    public void setWebViewClient(WebViewClient client) {
        mWebViewClient = client;
        // ---------- Original Method ----------
        //mWebViewClient = client;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.816 -0400", hash_original_method = "F1A871AF9A3B10055BFFA9DC06A940C2", hash_generated_method = "0359D40A2DA5CDDC09817ADF7C100960")
    public WebViewClient getWebViewClient() {
WebViewClient var219327D82738A9B3892C77985DEA01B6_1238066951 =         mWebViewClient;
        var219327D82738A9B3892C77985DEA01B6_1238066951.addTaint(taint);
        return var219327D82738A9B3892C77985DEA01B6_1238066951;
        // ---------- Original Method ----------
        //return mWebViewClient;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.817 -0400", hash_original_method = "92EB7E506A2EF4886CBEC1480289BCB6", hash_generated_method = "4C169B04C3730379147B383EFDBF5622")
    public void setWebChromeClient(WebChromeClient client) {
        mWebChromeClient = client;
        // ---------- Original Method ----------
        //mWebChromeClient = client;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.817 -0400", hash_original_method = "578C7E32D2B540B07E657C95C84E837C", hash_generated_method = "9CF519299B31E4F196C60CCE1D8A71D1")
    public WebChromeClient getWebChromeClient() {
WebChromeClient varA4A83CCFC474F74A3297D64921EA0D20_354620756 =         mWebChromeClient;
        varA4A83CCFC474F74A3297D64921EA0D20_354620756.addTaint(taint);
        return varA4A83CCFC474F74A3297D64921EA0D20_354620756;
        // ---------- Original Method ----------
        //return mWebChromeClient;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.817 -0400", hash_original_method = "36DD14932709DFA3D074F96EC9039EDA", hash_generated_method = "C93408E62641713A784F45E96AAF15BB")
    public void setDownloadListener(DownloadListener client) {
        mDownloadListener = client;
        // ---------- Original Method ----------
        //mDownloadListener = client;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.817 -0400", hash_original_method = "2A97B39171573BABF631C9DB7E378DC9", hash_generated_method = "F514EDF0AA6C0B924847B226B57681DD")
    public WebBackForwardList getBackForwardList() {
WebBackForwardList var1C240D885C886394EFD8991BF7723702_266637309 =         mBackForwardList;
        var1C240D885C886394EFD8991BF7723702_266637309.addTaint(taint);
        return var1C240D885C886394EFD8991BF7723702_266637309;
        // ---------- Original Method ----------
        //return mBackForwardList;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.817 -0400", hash_original_method = "69271AEE54C61C015B6B50CD212FE110", hash_generated_method = "13A4BC55EE14A943E04C92B28D85EE99")
     void setWebBackForwardListClient(WebBackForwardListClient client) {
        mWebBackForwardListClient = client;
        // ---------- Original Method ----------
        //mWebBackForwardListClient = client;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.817 -0400", hash_original_method = "32023A06CFA84B93B3A0030ADE6E4A41", hash_generated_method = "BA4E0ABEEC522B10D5B518FB347849B5")
     WebBackForwardListClient getWebBackForwardListClient() {
WebBackForwardListClient varFDD512ADED96794B21F9708300A9CF6B_851757946 =         mWebBackForwardListClient;
        varFDD512ADED96794B21F9708300A9CF6B_851757946.addTaint(taint);
        return varFDD512ADED96794B21F9708300A9CF6B_851757946;
        // ---------- Original Method ----------
        //return mWebBackForwardListClient;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.817 -0400", hash_original_method = "43AE5B1BF40E67157C7361E5EC862A6C", hash_generated_method = "7BF1D87ED2882FB75B8A220F9E1C8A9D")
    public boolean uiOverrideUrlLoading(String overrideUrl) {
        addTaint(overrideUrl.getTaint());
        if(overrideUrl == null || overrideUrl.length() == 0)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1124535981 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1954219392 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1954219392;
        } //End block
        boolean override = false;
        if(mWebViewClient != null)        
        {
            override = mWebViewClient.shouldOverrideUrlLoading(mWebView,
                    overrideUrl);
        } //End block
        else
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
            {
            } //End block
        } //End block
        boolean varE3B3F56615D1E5F2608D2F1130A7EF54_1875735187 = (override);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1185057193 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1185057193;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.818 -0400", hash_original_method = "D32407A1261408285F08570A8F2494B0", hash_generated_method = "AE105D3B2F4DE55764E6186F61EC6518")
    public boolean uiOverrideKeyEvent(KeyEvent event) {
        addTaint(event.getTaint());
        if(mWebViewClient != null)        
        {
            boolean varA184D23C528E36D606A8EBD0FAA17368_1357007736 = (mWebViewClient.shouldOverrideKeyEvent(mWebView, event));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1650815560 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1650815560;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1615626578 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_628993291 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_628993291;
        // ---------- Original Method ----------
        //if (mWebViewClient != null) {
            //return mWebViewClient.shouldOverrideKeyEvent(mWebView, event);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.834 -0400", hash_original_method = "643B690E8360A657B90F531CC63147C4", hash_generated_method = "29FF3AFB05EBAB87C9037A7381B384FB")
    @Override
    public void handleMessage(Message msg) {
        addTaint(msg.getTaint());
switch(msg.what){
        case PAGE_STARTED:
        String startedUrl = msg.getData().getString("url");
        mWebView.onPageStarted(startedUrl);
        if(mWebViewClient != null)        
        {
            mWebViewClient.onPageStarted(mWebView, startedUrl, (Bitmap) msg.obj);
        } //End block
        break;
        case PAGE_FINISHED:
        String finishedUrl = (String) msg.obj;
        mWebView.onPageFinished(finishedUrl);
        if(mWebViewClient != null)        
        {
            mWebViewClient.onPageFinished(mWebView, finishedUrl);
        } //End block
        break;
        case RECEIVED_ICON:
        if(mWebChromeClient != null)        
        {
            mWebChromeClient.onReceivedIcon(mWebView, (Bitmap) msg.obj);
        } //End block
        break;
        case RECEIVED_TOUCH_ICON_URL:
        if(mWebChromeClient != null)        
        {
            mWebChromeClient.onReceivedTouchIconUrl(mWebView,
                            (String) msg.obj, msg.arg1 == 1);
        } //End block
        break;
        case RECEIVED_TITLE:
        if(mWebChromeClient != null)        
        {
            mWebChromeClient.onReceivedTitle(mWebView,
                            (String) msg.obj);
        } //End block
        break;
        case REPORT_ERROR:
        if(mWebViewClient != null)        
        {
            int reasonCode = msg.arg1;
            final String description = msg.getData().getString("description");
            final String failUrl = msg.getData().getString("failingUrl");
            mWebViewClient.onReceivedError(mWebView, reasonCode,
                            description, failUrl);
        } //End block
        break;
        case RESEND_POST_DATA:
        Message resend = (Message) msg.getData().getParcelable("resend");
        Message dontResend = (Message) msg.getData().getParcelable("dontResend");
        if(mWebViewClient != null)        
        {
            mWebViewClient.onFormResubmission(mWebView, dontResend,
                            resend);
        } //End block
        else
        {
            dontResend.sendToTarget();
        } //End block
        break;
        case OVERRIDE_URL:
        String overrideUrl = msg.getData().getString("url");
        boolean override = uiOverrideUrlLoading(overrideUrl);
        ResultTransport<Boolean> result = (ResultTransport<Boolean>) msg.obj;
        synchronized
(this)        {
            result.setResult(override);
            notify();
        } //End block
        break;
        case AUTH_REQUEST:
        if(mWebViewClient != null)        
        {
            HttpAuthHandler handler = (HttpAuthHandler) msg.obj;
            String host = msg.getData().getString("host");
            String realm = msg.getData().getString("realm");
            mWebViewClient.onReceivedHttpAuthRequest(mWebView, handler,
                            host, realm);
        } //End block
        break;
        case SSL_ERROR:
        if(mWebViewClient != null)        
        {
            HashMap<String, Object> map = (HashMap<String, Object>) msg.obj;
            mWebViewClient.onReceivedSslError(mWebView,
                            (SslErrorHandler) map.get("handler"),
                            (SslError) map.get("error"));
        } //End block
        break;
        case PROCEEDED_AFTER_SSL_ERROR:
        if(mWebViewClient != null)        
        {
            mWebViewClient.onProceededAfterSslError(mWebView,
                            (SslError) msg.obj);
        } //End block
        break;
        case CLIENT_CERT_REQUEST:
        if(mWebViewClient != null)        
        {
            HashMap<String, Object> map = (HashMap<String, Object>) msg.obj;
            mWebViewClient.onReceivedClientCertRequest(mWebView,
                            (ClientCertRequestHandler) map.get("handler"),
                            (String) map.get("host_and_port"));
        } //End block
        break;
        case PROGRESS:
        synchronized
(this)        {
            if(mWebChromeClient != null)            
            {
                mWebChromeClient.onProgressChanged(mWebView,
                                mLatestProgress);
            } //End block
            mProgressUpdatePending = false;
        } //End block
        break;
        case UPDATE_VISITED:
        if(mWebViewClient != null)        
        {
            mWebViewClient.doUpdateVisitedHistory(mWebView,
                            (String) msg.obj, msg.arg1 != 0);
        } //End block
        break;
        case LOAD_RESOURCE:
        if(mWebViewClient != null)        
        {
            mWebViewClient.onLoadResource(mWebView, (String) msg.obj);
        } //End block
        break;
        case DOWNLOAD_FILE:
        if(mDownloadListener != null)        
        {
            String url = msg.getData().getString("url");
            String userAgent = msg.getData().getString("userAgent");
            String contentDisposition = msg.getData().getString("contentDisposition");
            String mimetype = msg.getData().getString("mimetype");
            Long contentLength = msg.getData().getLong("contentLength");
            mDownloadListener.onDownloadStart(url, userAgent,
                            contentDisposition, mimetype, contentLength);
        } //End block
        break;
        case CREATE_WINDOW:
        if(mWebChromeClient != null)        
        {
            if(!mWebChromeClient.onCreateWindow(mWebView,
                                msg.arg1 == 1, msg.arg2 == 1,
                                (Message) msg.obj))            
            {
                synchronized
(this)                {
                    notify();
                } //End block
            } //End block
            mWebView.dismissZoomControl();
        } //End block
        break;
        case REQUEST_FOCUS:
        if(mWebChromeClient != null)        
        {
            mWebChromeClient.onRequestFocus(mWebView);
        } //End block
        break;
        case CLOSE_WINDOW:
        if(mWebChromeClient != null)        
        {
            mWebChromeClient.onCloseWindow((WebView) msg.obj);
        } //End block
        break;
        case SAVE_PASSWORD:
        Bundle bundle = msg.getData();
        String schemePlusHost = bundle.getString("host");
        String username = bundle.getString("username");
        String password = bundle.getString("password");
        if(!mWebView.onSavePassword(schemePlusHost, username, password,
                            (Message) msg.obj))        
        {
            synchronized
(this)            {
                notify();
            } //End block
        } //End block
        break;
        case ASYNC_KEYEVENTS:
        if(mWebViewClient != null)        
        {
            mWebViewClient.onUnhandledKeyEvent(mWebView,
                            (KeyEvent) msg.obj);
        } //End block
        break;
        case EXCEEDED_DATABASE_QUOTA:
        if(mWebChromeClient != null)        
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
        break;
        case REACHED_APPCACHE_MAXSIZE:
        if(mWebChromeClient != null)        
        {
            HashMap<String, Object> map = (HashMap<String, Object>) msg.obj;
            long spaceNeeded = ((Long) map.get("spaceNeeded")).longValue();
            long totalUsedQuota = ((Long) map.get("totalUsedQuota")).longValue();
            WebStorage.QuotaUpdater quotaUpdater = (WebStorage.QuotaUpdater) map.get("quotaUpdater");
            mWebChromeClient.onReachedMaxAppCacheSize(spaceNeeded,
                            totalUsedQuota, quotaUpdater);
        } //End block
        break;
        case GEOLOCATION_PERMISSIONS_SHOW_PROMPT:
        if(mWebChromeClient != null)        
        {
            HashMap<String, Object> map = (HashMap<String, Object>) msg.obj;
            String origin = (String) map.get("origin");
            GeolocationPermissions.Callback callback = (GeolocationPermissions.Callback)
                            map.get("callback");
            mWebChromeClient.onGeolocationPermissionsShowPrompt(origin,
                            callback);
        } //End block
        break;
        case GEOLOCATION_PERMISSIONS_HIDE_PROMPT:
        if(mWebChromeClient != null)        
        {
            mWebChromeClient.onGeolocationPermissionsHidePrompt();
        } //End block
        break;
        case JS_ALERT:
        if(mWebChromeClient != null)        
        {
            final JsResult res = (JsResult) msg.obj;
            String message = msg.getData().getString("message");
            String url = msg.getData().getString("url");
            if(!mWebChromeClient.onJsAlert(mWebView, url, message,
                            res))            
            {
                if(!canShowAlertDialog())                
                {
                    res.cancel();
                    res.setReady();
                    break;
                } //End block
                new AlertDialog.Builder(mContext)
                                .setTitle(getJsDialogTitle(url))
                                .setMessage(message)
                                .setPositiveButton(R.string.ok,
                                        new DialogInterface.OnClickListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.819 -0400", hash_original_method = "05F12CF533E1857877A8AD104A11AF52", hash_generated_method = "8308528D87A87126B35E711738015AE2")
        public void onClick(
                                                    DialogInterface dialog,
                                                    int which) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(which);
            addTaint(dialog.getTaint());
            res.confirm();
            // ---------- Original Method ----------
            //res.confirm();
        }
})
                                .setOnCancelListener(
                                        new DialogInterface.OnCancelListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.830 -0400", hash_original_method = "B1C3BAB04B07B0569E11AD7C29C844EB", hash_generated_method = "9FDF055D2C79806716337003609F7298")
        public void onCancel(
                                                    DialogInterface dialog) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(dialog.getTaint());
            res.cancel();
            // ---------- Original Method ----------
            //res.cancel();
        }
})
                                .show();
            } //End block
            res.setReady();
        } //End block
        break;
        case JS_CONFIRM:
        if(mWebChromeClient != null)        
        {
            final JsResult res = (JsResult) msg.obj;
            String message = msg.getData().getString("message");
            String url = msg.getData().getString("url");
            if(!mWebChromeClient.onJsConfirm(mWebView, url, message,
                            res))            
            {
                if(!canShowAlertDialog())                
                {
                    res.cancel();
                    res.setReady();
                    break;
                } //End block
                new AlertDialog.Builder(mContext)
                                .setTitle(getJsDialogTitle(url))
                                .setMessage(message)
                                .setPositiveButton(R.string.ok,
                                        new DialogInterface.OnClickListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.830 -0400", hash_original_method = "05F12CF533E1857877A8AD104A11AF52", hash_generated_method = "8308528D87A87126B35E711738015AE2")
        public void onClick(
                                                    DialogInterface dialog,
                                                    int which) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(which);
            addTaint(dialog.getTaint());
            res.confirm();
            // ---------- Original Method ----------
            //res.confirm();
        }
})
                                .setNegativeButton(R.string.cancel,
                                        new DialogInterface.OnClickListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.831 -0400", hash_original_method = "E8564283849E341A10A9BCD809087039", hash_generated_method = "4CC8165513E3F97876A2633563F3B919")
        public void onClick(
                                                    DialogInterface dialog,
                                                    int which) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(which);
            addTaint(dialog.getTaint());
            res.cancel();
            // ---------- Original Method ----------
            //res.cancel();
        }
})
                                .setOnCancelListener(
                                        new DialogInterface.OnCancelListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.831 -0400", hash_original_method = "B1C3BAB04B07B0569E11AD7C29C844EB", hash_generated_method = "9FDF055D2C79806716337003609F7298")
        public void onCancel(
                                                    DialogInterface dialog) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(dialog.getTaint());
            res.cancel();
            // ---------- Original Method ----------
            //res.cancel();
        }
})
                                .show();
            } //End block
            res.setReady();
        } //End block
        break;
        case JS_PROMPT:
        if(mWebChromeClient != null)        
        {
            final JsPromptResult res = (JsPromptResult) msg.obj;
            String message = msg.getData().getString("message");
            String defaultVal = msg.getData().getString("default");
            String url = msg.getData().getString("url");
            if(!mWebChromeClient.onJsPrompt(mWebView, url, message,
                                defaultVal, res))            
            {
                if(!canShowAlertDialog())                
                {
                    res.cancel();
                    res.setReady();
                    break;
                } //End block
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.831 -0400", hash_original_method = "0D058E55C4ABCB67B49D4279EABD89A8", hash_generated_method = "D8FF31C0D300586484A6738BCCAB1C44")
        public void onClick(
                                                    DialogInterface dialog,
                                                    int whichButton) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(whichButton);
            addTaint(dialog.getTaint());
            res.confirm(v.getText()
                                                        .toString());
            // ---------- Original Method ----------
            //res.confirm(v.getText()
                                                        //.toString());
        }
})
                                .setNegativeButton(R.string.cancel,
                                        new DialogInterface.OnClickListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.832 -0400", hash_original_method = "862A9D411C13397AC08A0EA3C0A3F1C1", hash_generated_method = "D77FD89B5D33653A2D39730F708BBA22")
        public void onClick(
                                                    DialogInterface dialog,
                                                    int whichButton) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(whichButton);
            addTaint(dialog.getTaint());
            res.cancel();
            // ---------- Original Method ----------
            //res.cancel();
        }
})
                                .setOnCancelListener(
                                        new DialogInterface.OnCancelListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.832 -0400", hash_original_method = "B1C3BAB04B07B0569E11AD7C29C844EB", hash_generated_method = "9FDF055D2C79806716337003609F7298")
        public void onCancel(
                                                    DialogInterface dialog) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(dialog.getTaint());
            res.cancel();
            // ---------- Original Method ----------
            //res.cancel();
        }
})
                                .show();
            } //End block
            res.setReady();
        } //End block
        break;
        case JS_UNLOAD:
        if(mWebChromeClient != null)        
        {
            final JsResult res = (JsResult) msg.obj;
            String message = msg.getData().getString("message");
            String url = msg.getData().getString("url");
            if(!mWebChromeClient.onJsBeforeUnload(mWebView, url,
                            message, res))            
            {
                if(!canShowAlertDialog())                
                {
                    res.cancel();
                    res.setReady();
                    break;
                } //End block
                final String m = mContext.getString(
                                R.string.js_dialog_before_unload, message);
                new AlertDialog.Builder(mContext)
                                .setMessage(m)
                                .setPositiveButton(R.string.ok,
                                        new DialogInterface.OnClickListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.832 -0400", hash_original_method = "05F12CF533E1857877A8AD104A11AF52", hash_generated_method = "8308528D87A87126B35E711738015AE2")
        public void onClick(
                                                    DialogInterface dialog,
                                                    int which) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(which);
            addTaint(dialog.getTaint());
            res.confirm();
            // ---------- Original Method ----------
            //res.confirm();
        }
})
                                .setNegativeButton(R.string.cancel,
                                        new DialogInterface.OnClickListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.833 -0400", hash_original_method = "E8564283849E341A10A9BCD809087039", hash_generated_method = "4CC8165513E3F97876A2633563F3B919")
        public void onClick(
                                                    DialogInterface dialog,
                                                    int which) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(which);
            addTaint(dialog.getTaint());
            res.cancel();
            // ---------- Original Method ----------
            //res.cancel();
        }
})
                                .show();
            } //End block
            res.setReady();
        } //End block
        break;
        case JS_TIMEOUT:
        if(mWebChromeClient != null)        
        {
            final JsResult res = (JsResult) msg.obj;
            if(mWebChromeClient.onJsTimeout())            
            {
                res.confirm();
            } //End block
            else
            {
                res.cancel();
            } //End block
            res.setReady();
        } //End block
        break;
        case RECEIVED_CERTIFICATE:
        mWebView.setCertificate((SslCertificate) msg.obj);
        break;
        case NOTIFY:
        synchronized
(this)        {
            notify();
        } //End block
        break;
        case SCALE_CHANGED:
        if(mWebViewClient != null)        
        {
            mWebViewClient.onScaleChanged(mWebView, msg.getData()
                            .getFloat("old"), msg.getData().getFloat("new"));
        } //End block
        break;
        case SWITCH_OUT_HISTORY:
        mWebView.switchOutDrawHistory();
        break;
        case ADD_MESSAGE_TO_CONSOLE:
        if(mWebChromeClient == null)        
        {
            break;
        } //End block
        String message = msg.getData().getString("message");
        String sourceID = msg.getData().getString("sourceID");
        int lineNumber = msg.getData().getInt("lineNumber");
        int msgLevel = msg.getData().getInt("msgLevel");
        int numberOfMessageLevels = ConsoleMessage.MessageLevel.values().length;
        if(msgLevel < 0 || msgLevel >= numberOfMessageLevels)        
        {
            msgLevel = 0;
        } //End block
        ConsoleMessage.MessageLevel messageLevel = ConsoleMessage.MessageLevel.values()[msgLevel];
        if(!mWebChromeClient.onConsoleMessage(new ConsoleMessage(message, sourceID,
                        lineNumber, messageLevel)))        
        {
            String logTag = "Web Console";
            String logMessage = message + " at " + sourceID + ":" + lineNumber;
switch(messageLevel){
            case TIP:
            break;
            case LOG:
            break;
            case WARNING:
            break;
            case ERROR:
            break;
            case DEBUG:
            Log.d(logTag, logMessage);
            break;
}
        } //End block
        break;
        case GET_VISITED_HISTORY:
        if(mWebChromeClient != null)        
        {
            mWebChromeClient.getVisitedHistory((ValueCallback<String[]>)msg.obj);
        } //End block
        break;
        case OPEN_FILE_CHOOSER:
        if(mWebChromeClient != null)        
        {
            UploadFileMessageData data = (UploadFileMessageData)msg.obj;
            mWebChromeClient.openFileChooser(data.getUploadFile(), data.getAcceptType());
        } //End block
        break;
        case ADD_HISTORY_ITEM:
        if(mWebBackForwardListClient != null)        
        {
            mWebBackForwardListClient.onNewHistoryItem(
                            (WebHistoryItem) msg.obj);
        } //End block
        break;
        case HISTORY_INDEX_CHANGED:
        if(mWebBackForwardListClient != null)        
        {
            mWebBackForwardListClient.onIndexChanged(
                            (WebHistoryItem) msg.obj, msg.arg1);
        } //End block
        break;
        case AUTH_CREDENTIALS:
        {
            String host = msg.getData().getString("host");
            String realm = msg.getData().getString("realm");
            username = msg.getData().getString("username");
            password = msg.getData().getString("password");
            mWebView.setHttpAuthUsernamePassword(
                        host, realm, username, password);
            break;
        } //End block
        case SET_INSTALLABLE_WEBAPP:
        if(mWebChromeClient != null)        
        {
            mWebChromeClient.setInstallableWebApp();
        } //End block
        break;
        case NOTIFY_SEARCHBOX_LISTENERS:
        {
            SearchBoxImpl searchBox = (SearchBoxImpl) mWebView.getSearchBox();
            @SuppressWarnings("unchecked") List<String> suggestions = (List<String>) msg.obj;
            searchBox.handleSuggestions(msg.getData().getString("query"), suggestions);
            break;
        } //End block
        case AUTO_LOGIN:
        {
            if(mWebViewClient != null)            
            {
                String realm = msg.getData().getString("realm");
                String account = msg.getData().getString("account");
                String args = msg.getData().getString("args");
                mWebViewClient.onReceivedLoginRequest(mWebView, realm,
                            account, args);
            } //End block
            break;
        } //End block
        case SEARCHBOX_IS_SUPPORTED_CALLBACK:
        {
            SearchBoxImpl searchBox = (SearchBoxImpl) mWebView.getSearchBox();
            Boolean supported = (Boolean) msg.obj;
            searchBox.handleIsSupportedCallback(supported);
            break;
        } //End block
        case SEARCHBOX_DISPATCH_COMPLETE_CALLBACK:
        {
            SearchBoxImpl searchBox = (SearchBoxImpl) mWebView.getSearchBox();
            Boolean success = (Boolean) msg.obj;
            searchBox.handleDispatchCompleteCallback(msg.getData().getString("function"),
                        msg.getData().getInt("id"), success);
            break;
        } //End block
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.835 -0400", hash_original_method = "F4FA55F4EB9CE414FB8C02AF96B11745", hash_generated_method = "567EF681FE8F072A29CF36E7EE7A545E")
    public int getProgress() {
        int var2696E4DA487A70C034C78C6D39EE32D1_2015497809 = (mLatestProgress);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_326844584 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_326844584;
        // ---------- Original Method ----------
        //return mLatestProgress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.835 -0400", hash_original_method = "ADEA75F6BB5426452E05F86965232852", hash_generated_method = "1E917B7774EEA475E723DB7EC0CF755D")
     void switchOutDrawHistory() {
        sendMessage(obtainMessage(SWITCH_OUT_HISTORY));
        // ---------- Original Method ----------
        //sendMessage(obtainMessage(SWITCH_OUT_HISTORY));
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.836 -0400", hash_original_method = "2F62F4E531DE0AF4C82D66205801E78A", hash_generated_method = "239292A03E2A1C8071CF2D7C707703DE")
    private String getJsDialogTitle(String url) {
        addTaint(url.getTaint());
        String title = url;
        if(URLUtil.isDataUrl(url))        
        {
            title = mContext.getString(R.string.js_dialog_title_default);
        } //End block
        else
        {
            try 
            {
                URL aUrl = new URL(url);
                title = mContext.getString(R.string.js_dialog_title,
                        aUrl.getProtocol() + "://" + aUrl.getHost());
            } //End block
            catch (MalformedURLException ex)
            {
            } //End block
        } //End block
String varCD126D34DD1576383395AEE5945E9C28_1967986208 =         title;
        varCD126D34DD1576383395AEE5945E9C28_1967986208.addTaint(taint);
        return varCD126D34DD1576383395AEE5945E9C28_1967986208;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.836 -0400", hash_original_method = "FEA38F8F6B5615AC736396CA90380013", hash_generated_method = "CFBAA498130B0F26025309735A74A8AF")
    public void onPageStarted(String url, Bitmap favicon) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(favicon.getTaint());
        addTaint(url.getTaint());
        if(PERF_PROBE)        
        {
            mWebCoreThreadTime = SystemClock.currentThreadTimeMillis();
            mWebCoreIdleTime = 0;
            Network.getInstance(mContext).startTiming();
        } //End block
        Message msg = obtainMessage(PAGE_STARTED);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.836 -0400", hash_original_method = "0C202F92443A2E2B58845ECCCDAD23DA", hash_generated_method = "ADAE2C8838B39F33B9BC504C52C25EF6")
    public void onPageFinished(String url) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(url.getTaint());
        if(PERF_PROBE)        
        {
            Log.d("WebCore", "WebCore thread used " +
                    (SystemClock.currentThreadTimeMillis() - mWebCoreThreadTime)
                    + " ms and idled " + mWebCoreIdleTime + " ms");
            Network.getInstance(mContext).stopTiming();
        } //End block
        Message msg = obtainMessage(PAGE_FINISHED, url);
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.851 -0400", hash_original_method = "CAA94892A4D7B008F19D8BD2AD9FB2D3", hash_generated_method = "C0809B9CEB0B717846126AD99662E3B1")
    public void onTooManyRedirects(Message cancelMsg, Message continueMsg) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(continueMsg.getTaint());
        addTaint(cancelMsg.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.851 -0400", hash_original_method = "E5C6F1F12DEE48235072B52E91052ED8", hash_generated_method = "D945CDC7D58363B3C3FADA67CB453973")
    public void onReceivedError(int errorCode, String description,
            String failingUrl) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(failingUrl.getTaint());
        addTaint(description.getTaint());
        addTaint(errorCode);
        if(mWebViewClient == null)        
        {
            return;
        } //End block
        Message msg = obtainMessage(REPORT_ERROR);
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.851 -0400", hash_original_method = "5E30734A74D85B2FEB399A04359A0FF5", hash_generated_method = "65DDC04AC43181BB68163679D7F82159")
    public void onFormResubmission(Message dontResend,
            Message resend) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(resend.getTaint());
        addTaint(dontResend.getTaint());
        if(mWebViewClient == null)        
        {
            dontResend.sendToTarget();
            return;
        } //End block
        Message msg = obtainMessage(RESEND_POST_DATA);
        Bundle bundle = msg.getData();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.851 -0400", hash_original_method = "6A31F6EEFC7A56081588A72CFCF2411E", hash_generated_method = "A186F63D5A5CD8EB9FD4570DF76A6063")
    public boolean shouldOverrideUrlLoading(String url) {
        addTaint(url.getTaint());
        ResultTransport<Boolean> res = new ResultTransport<Boolean>(false);
        Message msg = obtainMessage(OVERRIDE_URL);
        msg.getData().putString("url", url);
        msg.obj = res;
        synchronized
(this)        {
            sendMessage(msg);
            try 
            {
                wait();
            } //End block
            catch (InterruptedException e)
            {
            } //End block
        } //End block
        boolean varDF1546B25C6AF6BCCFD4248C40C166AB_1065591635 = (res.getResult().booleanValue());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_130030342 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_130030342;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.851 -0400", hash_original_method = "4FA57A455CA03EC6D649ED38E4E56F01", hash_generated_method = "454878E772B11580DD3FCF39931D1F74")
    public void onReceivedHttpAuthRequest(HttpAuthHandler handler,
            String hostName, String realmName) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(realmName.getTaint());
        addTaint(hostName.getTaint());
        addTaint(handler.getTaint());
        if(mWebViewClient == null)        
        {
            handler.cancel();
            return;
        } //End block
        Message msg = obtainMessage(AUTH_REQUEST, handler);
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.852 -0400", hash_original_method = "8BC2AAF24BCB58C98055A520D9453CBA", hash_generated_method = "65108861E9D48F0E27E664564DE50635")
    public void onReceivedSslError(SslErrorHandler handler, SslError error) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(error.getTaint());
        addTaint(handler.getTaint());
        if(mWebViewClient == null)        
        {
            handler.cancel();
            return;
        } //End block
        Message msg = obtainMessage(SSL_ERROR);
        HashMap<String, Object> map = new HashMap();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.852 -0400", hash_original_method = "024A377297E93EBA7DF0A134D94D78F7", hash_generated_method = "534AB0D5ABAEAA528E2215D88054A2E6")
    public void onProceededAfterSslError(SslError error) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(error.getTaint());
        if(mWebViewClient == null)        
        {
            return;
        } //End block
        Message msg = obtainMessage(PROCEEDED_AFTER_SSL_ERROR);
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.852 -0400", hash_original_method = "86B49DF771A8EEA4B9DCFCD28BAACF5B", hash_generated_method = "FC7CB539E70C72771C32EEC72C3D0E46")
    public void onReceivedClientCertRequest(ClientCertRequestHandler handler, String host_and_port) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(host_and_port.getTaint());
        addTaint(handler.getTaint());
        if(mWebViewClient == null)        
        {
            handler.cancel();
            return;
        } //End block
        Message msg = obtainMessage(CLIENT_CERT_REQUEST);
        HashMap<String, Object> map = new HashMap();
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.852 -0400", hash_original_method = "39DDC3E15586955BE54A8DF95CFEEEEF", hash_generated_method = "C39C2E5178C612849536978728DF0F2F")
    public void onReceivedCertificate(SslCertificate certificate) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(certificate.getTaint());
        sendMessage(obtainMessage(RECEIVED_CERTIFICATE, certificate));
        // ---------- Original Method ----------
        //sendMessage(obtainMessage(RECEIVED_CERTIFICATE, certificate));
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.852 -0400", hash_original_method = "1419AC91B69314146C4F39503A4D545B", hash_generated_method = "BA71C6009B65DC8F60C5E57397F22DC3")
    public void doUpdateVisitedHistory(String url, boolean isReload) {
        addTaint(isReload);
        addTaint(url.getTaint());
        if(mWebViewClient == null)        
        {
            return;
        } //End block
        sendMessage(obtainMessage(UPDATE_VISITED, isReload ? 1 : 0, 0, url));
        // ---------- Original Method ----------
        //if (mWebViewClient == null) {
            //return;
        //}
        //sendMessage(obtainMessage(UPDATE_VISITED, isReload ? 1 : 0, 0, url));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.853 -0400", hash_original_method = "E95ED4984215917AB442D7D69416BDAD", hash_generated_method = "975B2F3C583F74D4E28E79B1F5BDEAEC")
     WebResourceResponse shouldInterceptRequest(String url) {
        addTaint(url.getTaint());
        if(mWebViewClient == null)        
        {
WebResourceResponse var540C13E9E156B687226421B24F2DF178_1067864479 =             null;
            var540C13E9E156B687226421B24F2DF178_1067864479.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1067864479;
        } //End block
        WebResourceResponse r = mWebViewClient.shouldInterceptRequest(mWebView, url);
        if(r == null)        
        {
            sendMessage(obtainMessage(LOAD_RESOURCE, url));
        } //End block
WebResourceResponse var4C1F3C86A0E56B6E375080F5F710547E_612825702 =         r;
        var4C1F3C86A0E56B6E375080F5F710547E_612825702.addTaint(taint);
        return var4C1F3C86A0E56B6E375080F5F710547E_612825702;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.853 -0400", hash_original_method = "AE6FAC3658CBE746F7970ADD50E1DD7A", hash_generated_method = "D31D3097E056B5FA7CBB8E40932FD9EF")
    public void onUnhandledKeyEvent(KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        if(mWebViewClient == null)        
        {
            return;
        } //End block
        sendMessage(obtainMessage(ASYNC_KEYEVENTS, event));
        // ---------- Original Method ----------
        //if (mWebViewClient == null) {
            //return;
        //}
        //sendMessage(obtainMessage(ASYNC_KEYEVENTS, event));
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.853 -0400", hash_original_method = "32F0A585D03AD391628455766053FDEF", hash_generated_method = "842FEA5E2981E8A19F932454811C0BD3")
    public void onScaleChanged(float oldScale, float newScale) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(newScale);
        addTaint(oldScale);
        if(mWebViewClient == null)        
        {
            return;
        } //End block
        Message msg = obtainMessage(SCALE_CHANGED);
        Bundle bundle = msg.getData();
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.853 -0400", hash_original_method = "96CFDF49B56568DC278F123893B1481C", hash_generated_method = "9BB96589F62C0923C2A031B23FD02F39")
     void onReceivedLoginRequest(String realm, String account, String args) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(args.getTaint());
        addTaint(account.getTaint());
        addTaint(realm.getTaint());
        if(mWebViewClient == null)        
        {
            return;
        } //End block
        Message msg = obtainMessage(AUTO_LOGIN);
        Bundle bundle = msg.getData();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.854 -0400", hash_original_method = "757A7F1755FBEFCF499F2AF609552311", hash_generated_method = "A57E7BA957DE5F4F45E2A4D27829E88F")
    public boolean onDownloadStart(String url, String userAgent,
            String contentDisposition, String mimetype, long contentLength) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(contentLength);
        addTaint(mimetype.getTaint());
        addTaint(contentDisposition.getTaint());
        addTaint(userAgent.getTaint());
        addTaint(url.getTaint());
        if(mDownloadListener == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1489948123 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1980707560 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1980707560;
        } //End block
        Message msg = obtainMessage(DOWNLOAD_FILE);
        Bundle bundle = msg.getData();
        bundle.putString("url", url);
        bundle.putString("userAgent", userAgent);
        bundle.putString("mimetype", mimetype);
        bundle.putLong("contentLength", contentLength);
        bundle.putString("contentDisposition", contentDisposition);
        sendMessage(msg);
        boolean varB326B5062B2F0E69046810717534CB09_1673600605 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1492949084 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1492949084;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.854 -0400", hash_original_method = "E36C2E9038F101EB831B9776820C94AF", hash_generated_method = "23C99A2F0E9B22D148BDB085E0C26584")
    public boolean onSavePassword(String schemePlusHost, String username,
            String password, Message resumeMsg) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(resumeMsg.getTaint());
        addTaint(password.getTaint());
        addTaint(username.getTaint());
        addTaint(schemePlusHost.getTaint());
        if(DebugFlags.CALLBACK_PROXY)        
        {
            junit.framework.Assert.assertNull(resumeMsg);
        } //End block
        resumeMsg = obtainMessage(NOTIFY);
        Message msg = obtainMessage(SAVE_PASSWORD, resumeMsg);
        Bundle bundle = msg.getData();
        bundle.putString("host", schemePlusHost);
        bundle.putString("username", username);
        bundle.putString("password", password);
        synchronized
(this)        {
            sendMessage(msg);
            try 
            {
                wait();
            } //End block
            catch (InterruptedException e)
            {
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1982904987 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1241503187 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1241503187;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.855 -0400", hash_original_method = "FE09891259ADB46761F758E0F5C88D74", hash_generated_method = "685DCC0577C599ACC25B05A3D2680181")
    public void onReceivedHttpAuthCredentials(String host, String realm,
            String username, String password) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(password.getTaint());
        addTaint(username.getTaint());
        addTaint(realm.getTaint());
        addTaint(host.getTaint());
        Message msg = obtainMessage(AUTH_CREDENTIALS);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.855 -0400", hash_original_method = "7D23376057076E49A1BAAD127CCE1E2E", hash_generated_method = "88F5FCBF394DBBC81563104135377A97")
    public void onProgressChanged(int newProgress) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        synchronized
(this)        {
            if(mLatestProgress == newProgress)            
            {
                return;
            } //End block
            mLatestProgress = newProgress;
            if(mWebChromeClient == null)            
            {
                return;
            } //End block
            if(!mProgressUpdatePending)            
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.855 -0400", hash_original_method = "B29F2764BB6A56E843DFC7CBC2F6C034", hash_generated_method = "60E0353C9569D84F884C8BFCF27CA4E3")
    public BrowserFrame createWindow(boolean dialog, boolean userGesture) {
        addTaint(userGesture);
        addTaint(dialog);
        if(mWebChromeClient == null)        
        {
BrowserFrame var540C13E9E156B687226421B24F2DF178_1472382114 =             null;
            var540C13E9E156B687226421B24F2DF178_1472382114.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1472382114;
        } //End block
        WebView.WebViewTransport transport = mWebView.new WebViewTransport();
        final Message msg = obtainMessage(NOTIFY);
        msg.obj = transport;
        synchronized
(this)        {
            sendMessage(obtainMessage(CREATE_WINDOW, dialog ? 1 : 0,
                    userGesture ? 1 : 0, msg));
            try 
            {
                wait();
            } //End block
            catch (InterruptedException e)
            {
            } //End block
        } //End block
        WebView w = transport.getWebView();
        if(w != null)        
        {
            WebViewCore core = w.getWebViewCore();
            if(core != null)            
            {
                core.initializeSubwindow();
BrowserFrame varB5C22104BD5B0F349A1E0CAA7A3E7517_1964794578 =                 core.getBrowserFrame();
                varB5C22104BD5B0F349A1E0CAA7A3E7517_1964794578.addTaint(taint);
                return varB5C22104BD5B0F349A1E0CAA7A3E7517_1964794578;
            } //End block
        } //End block
BrowserFrame var540C13E9E156B687226421B24F2DF178_393665050 =         null;
        var540C13E9E156B687226421B24F2DF178_393665050.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_393665050;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.855 -0400", hash_original_method = "08655C1DEC40A72DA93F91A66B628CEC", hash_generated_method = "2E75BA126814F868313BF019EE0A11D0")
    public void onRequestFocus() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if(mWebChromeClient == null)        
        {
            return;
        } //End block
        sendEmptyMessage(REQUEST_FOCUS);
        // ---------- Original Method ----------
        //if (mWebChromeClient == null) {
            //return;
        //}
        //sendEmptyMessage(REQUEST_FOCUS);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.855 -0400", hash_original_method = "6FD913BE3AA43F9AAEFF1CB8B9D39A33", hash_generated_method = "E24EEF1CE11ED62624D8C076675BC0F1")
    public void onCloseWindow(WebView window) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(window.getTaint());
        if(mWebChromeClient == null)        
        {
            return;
        } //End block
        sendMessage(obtainMessage(CLOSE_WINDOW, window));
        // ---------- Original Method ----------
        //if (mWebChromeClient == null) {
            //return;
        //}
        //sendMessage(obtainMessage(CLOSE_WINDOW, window));
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.856 -0400", hash_original_method = "F08C9B8424214ACDF6DD6A6D99BF0681", hash_generated_method = "0FC76FCD9CD9FF11D31F0C62D4AE8681")
    public void onReceivedIcon(Bitmap icon) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(icon.getTaint());
        WebHistoryItem i = mBackForwardList.getCurrentItem();
        if(i != null)        
        {
            i.setFavicon(icon);
        } //End block
        if(mWebChromeClient == null)        
        {
            return;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.870 -0400", hash_original_method = "F0350B43E0ECCB1BDA5D312CA7F06F8A", hash_generated_method = "1327EC36DA83E0AF893DF4E175241E7F")
     void onReceivedTouchIconUrl(String url, boolean precomposed) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(precomposed);
        addTaint(url.getTaint());
        WebHistoryItem i = mBackForwardList.getCurrentItem();
        if(i != null)        
        {
            i.setTouchIconUrl(url, precomposed);
        } //End block
        if(mWebChromeClient == null)        
        {
            return;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.870 -0400", hash_original_method = "91CD241BD0413BEA62EE65C753144C77", hash_generated_method = "6D29343564A2541A49EE8398A00A6849")
    public void onReceivedTitle(String title) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(title.getTaint());
        if(mWebChromeClient == null)        
        {
            return;
        } //End block
        sendMessage(obtainMessage(RECEIVED_TITLE, title));
        // ---------- Original Method ----------
        //if (mWebChromeClient == null) {
            //return;
        //}
        //sendMessage(obtainMessage(RECEIVED_TITLE, title));
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.870 -0400", hash_original_method = "7099C31F609DFFDBC7FE4DB990C0E80D", hash_generated_method = "E31FD8B6479C2570C0E96067422C6DB8")
    public void onJsAlert(String url, String message) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(message.getTaint());
        addTaint(url.getTaint());
        if(mWebChromeClient == null)        
        {
            return;
        } //End block
        JsResult result = new JsResult(this, false);
        Message alert = obtainMessage(JS_ALERT, result);
        alert.getData().putString("message", message);
        alert.getData().putString("url", url);
        synchronized
(this)        {
            sendMessage(alert);
            try 
            {
                wait();
            } //End block
            catch (InterruptedException e)
            {
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.871 -0400", hash_original_method = "043F4DC8C3BE16DF648461B096D08CDF", hash_generated_method = "3AD014275C98F4AB2367A4708307FC72")
    public boolean onJsConfirm(String url, String message) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(message.getTaint());
        addTaint(url.getTaint());
        if(mWebChromeClient == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_435308447 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_200491658 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_200491658;
        } //End block
        JsResult result = new JsResult(this, false);
        Message confirm = obtainMessage(JS_CONFIRM, result);
        confirm.getData().putString("message", message);
        confirm.getData().putString("url", url);
        synchronized
(this)        {
            sendMessage(confirm);
            try 
            {
                wait();
            } //End block
            catch (InterruptedException e)
            {
            } //End block
        } //End block
        boolean var8F25EF0C481497C3C0F9585128B5BF1F_1589647157 = (result.getResult());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2000110410 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2000110410;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.871 -0400", hash_original_method = "994C85F742AA26A8662DEB752BD55192", hash_generated_method = "B04B5F0186FC6A2575D4EDF69080D9B3")
    public String onJsPrompt(String url, String message, String defaultValue) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(defaultValue.getTaint());
        addTaint(message.getTaint());
        addTaint(url.getTaint());
        if(mWebChromeClient == null)        
        {
String var540C13E9E156B687226421B24F2DF178_1829928298 =             null;
            var540C13E9E156B687226421B24F2DF178_1829928298.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1829928298;
        } //End block
        JsPromptResult result = new JsPromptResult(this);
        Message prompt = obtainMessage(JS_PROMPT, result);
        prompt.getData().putString("message", message);
        prompt.getData().putString("default", defaultValue);
        prompt.getData().putString("url", url);
        synchronized
(this)        {
            sendMessage(prompt);
            try 
            {
                wait();
            } //End block
            catch (InterruptedException e)
            {
            } //End block
        } //End block
String var578B1A496AD41AC51C5FB6A8B2FFD5FE_220545594 =         result.getStringResult();
        var578B1A496AD41AC51C5FB6A8B2FFD5FE_220545594.addTaint(taint);
        return var578B1A496AD41AC51C5FB6A8B2FFD5FE_220545594;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.871 -0400", hash_original_method = "C62C6CDF3925B75D5791E39530CD4D60", hash_generated_method = "21FF0EA71114DF9F179BEF130BA0EF52")
    public boolean onJsBeforeUnload(String url, String message) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(message.getTaint());
        addTaint(url.getTaint());
        if(mWebChromeClient == null)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_799764244 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_845853141 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_845853141;
        } //End block
        JsResult result = new JsResult(this, true);
        Message confirm = obtainMessage(JS_UNLOAD, result);
        confirm.getData().putString("message", message);
        confirm.getData().putString("url", url);
        synchronized
(this)        {
            sendMessage(confirm);
            try 
            {
                wait();
            } //End block
            catch (InterruptedException e)
            {
            } //End block
        } //End block
        boolean var8F25EF0C481497C3C0F9585128B5BF1F_55039574 = (result.getResult());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_785169048 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_785169048;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.871 -0400", hash_original_method = "2A1C263B6B48827DF8BFBCAAE8358B4D", hash_generated_method = "7B5563D1F36A7D1FF07D43CB4E3D9B10")
    public void onExceededDatabaseQuota(
            String url, String databaseIdentifier, long currentQuota,
            long estimatedSize, long totalUsedQuota,
            WebStorage.QuotaUpdater quotaUpdater) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(quotaUpdater.getTaint());
        addTaint(totalUsedQuota);
        addTaint(estimatedSize);
        addTaint(currentQuota);
        addTaint(databaseIdentifier.getTaint());
        addTaint(url.getTaint());
        if(mWebChromeClient == null)        
        {
            quotaUpdater.updateQuota(currentQuota);
            return;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.872 -0400", hash_original_method = "6FEDE2ECE3E4B773BADE3DEA30808B9D", hash_generated_method = "9C95392AAD5C30738282EDE34ED7B4D3")
    public void onReachedMaxAppCacheSize(long spaceNeeded,
            long totalUsedQuota, WebStorage.QuotaUpdater quotaUpdater) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(quotaUpdater.getTaint());
        addTaint(totalUsedQuota);
        addTaint(spaceNeeded);
        if(mWebChromeClient == null)        
        {
            quotaUpdater.updateQuota(0);
            return;
        } //End block
        Message msg = obtainMessage(REACHED_APPCACHE_MAXSIZE);
        HashMap<String, Object> map = new HashMap();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.872 -0400", hash_original_method = "26533187FD051756DFC2CF1CEE3F806F", hash_generated_method = "EE8D3F6B2F5FC8DC2D3B1E208D82B016")
    public void onGeolocationPermissionsShowPrompt(String origin,
            GeolocationPermissions.Callback callback) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(callback.getTaint());
        addTaint(origin.getTaint());
        if(mWebChromeClient == null)        
        {
            return;
        } //End block
        Message showMessage = obtainMessage(GEOLOCATION_PERMISSIONS_SHOW_PROMPT);
        HashMap<String, Object> map = new HashMap();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.879 -0400", hash_original_method = "9C25F80E0E6C6F6C487DBDD3AFCBA4E7", hash_generated_method = "9A0E49491849C21E3D11BB7370A84677")
    public void onGeolocationPermissionsHidePrompt() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if(mWebChromeClient == null)        
        {
            return;
        } //End block
        Message hideMessage = obtainMessage(GEOLOCATION_PERMISSIONS_HIDE_PROMPT);
        sendMessage(hideMessage);
        // ---------- Original Method ----------
        //if (mWebChromeClient == null) {
            //return;
        //}
        //Message hideMessage = obtainMessage(GEOLOCATION_PERMISSIONS_HIDE_PROMPT);
        //sendMessage(hideMessage);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.880 -0400", hash_original_method = "E08EA131E9320463E856348907B813CB", hash_generated_method = "0B0767669512EBEC407F18DE0669801C")
    public void addMessageToConsole(String message, int lineNumber, String sourceID, int msgLevel) {
        addTaint(msgLevel);
        addTaint(sourceID.getTaint());
        addTaint(lineNumber);
        addTaint(message.getTaint());
        if(mWebChromeClient == null)        
        {
            return;
        } //End block
        Message msg = obtainMessage(ADD_MESSAGE_TO_CONSOLE);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.881 -0400", hash_original_method = "288C2B13F2CEF8B24515719050488B19", hash_generated_method = "55217EF895A6417440364B4AE1449672")
    public boolean onJsTimeout() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if(mWebChromeClient == null)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1895876316 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_888084718 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_888084718;
        } //End block
        JsResult result = new JsResult(this, true);
        Message timeout = obtainMessage(JS_TIMEOUT, result);
        synchronized
(this)        {
            sendMessage(timeout);
            try 
            {
                wait();
            } //End block
            catch (InterruptedException e)
            {
            } //End block
        } //End block
        boolean var8F25EF0C481497C3C0F9585128B5BF1F_970920681 = (result.getResult());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1081434062 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1081434062;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.881 -0400", hash_original_method = "F9E2141EE9507A71AC258BF46DA1BEA9", hash_generated_method = "5758519CCD7591BBAD2904F5041AD92E")
    public void getVisitedHistory(ValueCallback<String[]> callback) {
        addTaint(callback.getTaint());
        if(mWebChromeClient == null)        
        {
            return;
        } //End block
        Message msg = obtainMessage(GET_VISITED_HISTORY);
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.881 -0400", hash_original_method = "FE04684AB3D72B8C190BB2063ADDA47F", hash_generated_method = "D108DD56E579066165A075D03F4817CA")
     Uri openFileChooser(String acceptType) {
        addTaint(acceptType.getTaint());
        if(mWebChromeClient == null)        
        {
Uri var540C13E9E156B687226421B24F2DF178_2105892780 =             null;
            var540C13E9E156B687226421B24F2DF178_2105892780.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2105892780;
        } //End block
        Message myMessage = obtainMessage(OPEN_FILE_CHOOSER);
        UploadFile uploadFile = new UploadFile();
        UploadFileMessageData data = new UploadFileMessageData(uploadFile, acceptType);
        myMessage.obj = data;
        synchronized
(this)        {
            sendMessage(myMessage);
            try 
            {
                wait();
            } //End block
            catch (InterruptedException e)
            {
            } //End block
        } //End block
Uri varE22FFCE020DE18FB2CC526226D95C1A9_345608861 =         uploadFile.getResult();
        varE22FFCE020DE18FB2CC526226D95C1A9_345608861.addTaint(taint);
        return varE22FFCE020DE18FB2CC526226D95C1A9_345608861;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.882 -0400", hash_original_method = "047BE1D111CE2C04D81802E658F23AB3", hash_generated_method = "690B75F32AF69E3940688CCFE96335C3")
     void onNewHistoryItem(WebHistoryItem item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(item.getTaint());
        if(mWebBackForwardListClient == null)        
        {
            return;
        } //End block
        Message msg = obtainMessage(ADD_HISTORY_ITEM, item);
        sendMessage(msg);
        // ---------- Original Method ----------
        //if (mWebBackForwardListClient == null) {
            //return;
        //}
        //Message msg = obtainMessage(ADD_HISTORY_ITEM, item);
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.882 -0400", hash_original_method = "895FE5553DA6237DB0B5BAA6BAF66947", hash_generated_method = "5DF454C3A01EADCA53CDDF5E49C15DFC")
     void onIndexChanged(WebHistoryItem item, int index) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(index);
        addTaint(item.getTaint());
        if(mWebBackForwardListClient == null)        
        {
            return;
        } //End block
        Message msg = obtainMessage(HISTORY_INDEX_CHANGED, index, 0, item);
        sendMessage(msg);
        // ---------- Original Method ----------
        //if (mWebBackForwardListClient == null) {
            //return;
        //}
        //Message msg = obtainMessage(HISTORY_INDEX_CHANGED, index, 0, item);
        //sendMessage(msg);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.882 -0400", hash_original_method = "8F94850AD3F63EF799E6BEFB2C67734D", hash_generated_method = "0872210D815012EC57E9F15D10862B80")
     void setInstallableWebApp() {
        if(mWebChromeClient == null)        
        {
            return;
        } //End block
        sendMessage(obtainMessage(SET_INSTALLABLE_WEBAPP));
        // ---------- Original Method ----------
        //if (mWebChromeClient == null) {
            //return;
        //}
        //sendMessage(obtainMessage(SET_INSTALLABLE_WEBAPP));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.882 -0400", hash_original_method = "8DF8998B34FE58BC5486ECCDB22BE44D", hash_generated_method = "5503ECD0F969BF51537B0720B581DBBF")
     boolean canShowAlertDialog() {
        boolean varE37B05B01B9AB47E90E647D8F707F405_1470977023 = (mContext instanceof Activity);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_128851838 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_128851838;
        // ---------- Original Method ----------
        //return mContext instanceof Activity;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.882 -0400", hash_original_method = "C20FB9F0C31604564B2DC30DE7E0C643", hash_generated_method = "ADCAE33715EB0CFF33A6E0C25E15B09F")
     void onSearchboxSuggestionsReceived(String query, List<String> suggestions) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(suggestions.getTaint());
        addTaint(query.getTaint());
        Message msg = obtainMessage(NOTIFY_SEARCHBOX_LISTENERS);
        msg.obj = suggestions;
        msg.getData().putString("query", query);
        sendMessage(msg);
        // ---------- Original Method ----------
        //Message msg = obtainMessage(NOTIFY_SEARCHBOX_LISTENERS);
        //msg.obj = suggestions;
        //msg.getData().putString("query", query);
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.882 -0400", hash_original_method = "350C274DFDDA43015C8C93D9651125A1", hash_generated_method = "4496BB7DBB04A8A177CD523CA66157E3")
     void onIsSupportedCallback(boolean isSupported) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(isSupported);
        Message msg = obtainMessage(SEARCHBOX_IS_SUPPORTED_CALLBACK);
        msg.obj = new Boolean(isSupported);
        sendMessage(msg);
        // ---------- Original Method ----------
        //Message msg = obtainMessage(SEARCHBOX_IS_SUPPORTED_CALLBACK);
        //msg.obj = new Boolean(isSupported);
        //sendMessage(msg);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.883 -0400", hash_original_method = "18679CF45F0FBF6C3076A4EAE4B01ADE", hash_generated_method = "9E4BB6D379001E8E95AA01C3991863BE")
     void onSearchboxDispatchCompleteCallback(String function, int id, boolean success) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(success);
        addTaint(id);
        addTaint(function.getTaint());
        Message msg = obtainMessage(SEARCHBOX_DISPATCH_COMPLETE_CALLBACK);
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.883 -0400", hash_original_field = "313AEF43C06545BCEAC152A1C285EBE1", hash_generated_field = "8FF1976BF201D1F418EC84B9D35E5FAC")

        private E mResult;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.883 -0400", hash_original_method = "DD22213D197BC89445531F8496343FB8", hash_generated_method = "9633A2A2899E61CCB3453D5B3B8F2949")
        public  ResultTransport(E defaultResult) {
            mResult = defaultResult;
            // ---------- Original Method ----------
            //mResult = defaultResult;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.883 -0400", hash_original_method = "23B0DB25EF15209B12B4D98F75BC4826", hash_generated_method = "1CC67B1DE228486A08B2C64A649EF681")
        public synchronized void setResult(E result) {
            mResult = result;
            // ---------- Original Method ----------
            //mResult = result;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.883 -0400", hash_original_method = "67EA7E4C242F8EF7A6CF084AEA447779", hash_generated_method = "8C9EFB7DDF6E57553A7882ADBD587FF4")
        public synchronized E getResult() {
E var8EC17D26103D23643357521909BC2C9A_272225556 =             mResult;
            var8EC17D26103D23643357521909BC2C9A_272225556.addTaint(taint);
            return var8EC17D26103D23643357521909BC2C9A_272225556;
            // ---------- Original Method ----------
            //return mResult;
        }

        
    }


    
    private static class UploadFileMessageData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.883 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "141E146BCCC9E44E04F619B70ED78B17")

        private UploadFile mCallback;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.883 -0400", hash_original_field = "F7770022153C0271D858491BF09AEACC", hash_generated_field = "F1FEB7E52B3D4A532C0192C9EE3750CA")

        private String mAcceptType;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.883 -0400", hash_original_method = "506E5829DE4CA65822239D45E416BF71", hash_generated_method = "F0F40EDAB8A6F9084FBE2B1F2CCB3C4E")
        public  UploadFileMessageData(UploadFile uploadFile, String acceptType) {
            mCallback = uploadFile;
            mAcceptType = acceptType;
            // ---------- Original Method ----------
            //mCallback = uploadFile;
            //mAcceptType = acceptType;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.883 -0400", hash_original_method = "9D48109A15DDC7CFDE503C879117A387", hash_generated_method = "260D67EC2FC9DBAB1316230E324B3A9F")
        public UploadFile getUploadFile() {
UploadFile var31075088B2A2E9D45AA9874A2DA07598_1826820995 =             mCallback;
            var31075088B2A2E9D45AA9874A2DA07598_1826820995.addTaint(taint);
            return var31075088B2A2E9D45AA9874A2DA07598_1826820995;
            // ---------- Original Method ----------
            //return mCallback;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.883 -0400", hash_original_method = "EE5645A876B8829341B5E714F10E353A", hash_generated_method = "1D2408B5B669F4EBAAA93DC340C1A135")
        public String getAcceptType() {
String varE3A067C89E54BBE0AE977695F4311BA7_809612468 =             mAcceptType;
            varE3A067C89E54BBE0AE977695F4311BA7_809612468.addTaint(taint);
            return varE3A067C89E54BBE0AE977695F4311BA7_809612468;
            // ---------- Original Method ----------
            //return mAcceptType;
        }

        
    }


    
    private class UploadFile implements ValueCallback<Uri> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.883 -0400", hash_original_field = "CBAFE11E7BAE23358D70D54D132C3064", hash_generated_field = "D24B10CB4DFA145F1AD29B267930EA48")

        private Uri mValue;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.883 -0400", hash_original_method = "CA5F2E6F07869C80D280CD39F96B8098", hash_generated_method = "CA5F2E6F07869C80D280CD39F96B8098")
        public UploadFile ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.884 -0400", hash_original_method = "4E719BBCA95A35A86F37F83B7E6AA557", hash_generated_method = "DA348449E4089428CF2AC95B16237996")
        public void onReceiveValue(Uri value) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mValue = value;
            synchronized
(CallbackProxy.this)            {
                CallbackProxy.this.notify();
            } //End block
            // ---------- Original Method ----------
            //mValue = value;
            //synchronized (CallbackProxy.this) {
                //CallbackProxy.this.notify();
            //}
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.884 -0400", hash_original_method = "546BF3EDB8840D5BF09D8B66103FFEC6", hash_generated_method = "79281B0C478E0FDFAEB15AB2120955AC")
        public Uri getResult() {
Uri varD1FEA3F5EE4618A9C3646312F018E4AC_2048304322 =             mValue;
            varD1FEA3F5EE4618A9C3646312F018E4AC_2048304322.addTaint(taint);
            return varD1FEA3F5EE4618A9C3646312F018E4AC_2048304322;
            // ---------- Original Method ----------
            //return mValue;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.884 -0400", hash_original_field = "8C9130CDA2A66EF5393AEF174DCA2142", hash_generated_field = "B8BCB03548AB3F60BD02883254FAF794")

    private static final String LOGTAG = "CallbackProxy";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.884 -0400", hash_original_field = "3208979F31DB6F208ED1ABFE54C2777D", hash_generated_field = "848D750C41316648518CD8F70F77F580")

    private static final int PAGE_STARTED = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.884 -0400", hash_original_field = "0595282DB8290097D943FD4835DAE35F", hash_generated_field = "4C070FDA7C3353A448C6DD6B918D4011")

    private static final int RECEIVED_ICON = 101;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.884 -0400", hash_original_field = "32A709EF470502982DE5B92F9E51C52A", hash_generated_field = "A0CE6E78E934117E9782D63B2FEB087C")

    private static final int RECEIVED_TITLE = 102;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.884 -0400", hash_original_field = "AA16AAC9759D194D9ABC14C1DDB9C398", hash_generated_field = "8AFE3F0322EFDE154B6ADC96D0D7F5E6")

    private static final int OVERRIDE_URL = 103;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.884 -0400", hash_original_field = "96423544F2C8894B7019D641B104C0B6", hash_generated_field = "0F252CCD54E9D551DB6C5D2B2CA79448")

    private static final int AUTH_REQUEST = 104;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.884 -0400", hash_original_field = "896362D63C3AA39A676A01B7D029C192", hash_generated_field = "9B3FDF63312EC91BBA1DD5F25239A68F")

    private static final int SSL_ERROR = 105;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.884 -0400", hash_original_field = "0D541C969BF688AC1DC3481FB24093A4", hash_generated_field = "95DAFA8ADE2A61A20D5E39C60D891614")

    private static final int PROGRESS = 106;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.884 -0400", hash_original_field = "DF889AF98741612C7EBBEFD56FDECA9A", hash_generated_field = "4049E97E2BE052C03064CA677BE659A0")

    private static final int UPDATE_VISITED = 107;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.884 -0400", hash_original_field = "D54C2218A4F7767E49430B7F45943150", hash_generated_field = "A7A0D1F5ACF78125BCA9701A5CC009E5")

    private static final int LOAD_RESOURCE = 108;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.884 -0400", hash_original_field = "3D24951538BC37EE86262B035EFE145E", hash_generated_field = "DEA96639CC695B0F757C9B991BCDA133")

    private static final int CREATE_WINDOW = 109;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.884 -0400", hash_original_field = "5FD2B1A14257FCDABB95BB135FF6CBB3", hash_generated_field = "8EAC4093DD440B6EF00A8E9F4DC1C4E0")

    private static final int CLOSE_WINDOW = 110;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.884 -0400", hash_original_field = "EED1B544826A0E05E39F4EF9160C9B47", hash_generated_field = "91798D07F2F908231AFDEFD1E6B2838D")

    private static final int SAVE_PASSWORD = 111;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.884 -0400", hash_original_field = "EE0ED596D7152BB438F8241ECA3B4A75", hash_generated_field = "3440F1A73B7E8491DE1EE40C87547131")

    private static final int JS_ALERT = 112;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.884 -0400", hash_original_field = "178663701E6D5A1C3D92DDB7ABC9EFAD", hash_generated_field = "0CC6E044D6D37F23B6E16EA723CABB25")

    private static final int JS_CONFIRM = 113;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.884 -0400", hash_original_field = "691DB536EA212A54B7C75028CA5C5181", hash_generated_field = "AE03D743830B0E913C9B4A19C334D998")

    private static final int JS_PROMPT = 114;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.884 -0400", hash_original_field = "63406D7FC3EEAE564C564DA5D918F64F", hash_generated_field = "0174398F08F7C02FF7DF4D1A826D4E88")

    private static final int JS_UNLOAD = 115;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.884 -0400", hash_original_field = "A2010D893F416BE4FA618E6F4546C076", hash_generated_field = "1E66D85BCF0A6507FE185C0BA8A8AAEC")

    private static final int ASYNC_KEYEVENTS = 116;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.884 -0400", hash_original_field = "C5CA2DBA1E8EB468981612AB11E5B638", hash_generated_field = "D3C0B0285F58690CA9C630D2069D9952")

    private static final int DOWNLOAD_FILE = 118;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.884 -0400", hash_original_field = "61D34384ACB6D6E6538CBE9CACA042C2", hash_generated_field = "0FAC4F6750464F7121676D3E6DA87C34")

    private static final int REPORT_ERROR = 119;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.884 -0400", hash_original_field = "8F7FC97FFDA4549DA6CC4A114FE8B20C", hash_generated_field = "6CC195242A0EB566B41683BE41C53B6E")

    private static final int RESEND_POST_DATA = 120;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.884 -0400", hash_original_field = "B49EBE022F8B815D90EE10B8DF4B4ADB", hash_generated_field = "9FE3EFB08388A4762A3B4605C12F9F28")

    private static final int PAGE_FINISHED = 121;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.884 -0400", hash_original_field = "EEC292A48E8AF8A7AF74BA09970264A6", hash_generated_field = "B0B1B74A5F98AF2C70D4F8B3B80DC9F2")

    private static final int REQUEST_FOCUS = 122;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.884 -0400", hash_original_field = "A5F92A21341FA5B16F062DF186B2482A", hash_generated_field = "B265FEFE7FCCDB0139C5B46EFA790F5D")

    private static final int SCALE_CHANGED = 123;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.884 -0400", hash_original_field = "3419D1FC6211209D479F738FC85856E5", hash_generated_field = "57532493DFCF0603E50E226A34E196A9")

    private static final int RECEIVED_CERTIFICATE = 124;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.884 -0400", hash_original_field = "7DF692B4B90692F9A506D49F315BC808", hash_generated_field = "C787E348480EC1FDC28655E6D1E02A0E")

    private static final int SWITCH_OUT_HISTORY = 125;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.884 -0400", hash_original_field = "28A4C0BFA39FFCE75A049D12C90DA34F", hash_generated_field = "FB13A89EC337D2294B29823E36FF84A5")

    private static final int EXCEEDED_DATABASE_QUOTA = 126;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.884 -0400", hash_original_field = "5C2E4A8C6C1D6EB0AA73405358873E9D", hash_generated_field = "BC55284D336C0FEA873DFF7A4A688792")

    private static final int REACHED_APPCACHE_MAXSIZE = 127;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.884 -0400", hash_original_field = "190B5D79FB8A1AF1C80637C850307202", hash_generated_field = "0149997CB5F9EA65E0731208128064F0")

    private static final int JS_TIMEOUT = 128;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.885 -0400", hash_original_field = "66C31A0DFCEAF967AEAE99F7FE0170F0", hash_generated_field = "3DEBEE027386C9B59EB8F3BF23830816")

    private static final int ADD_MESSAGE_TO_CONSOLE = 129;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.885 -0400", hash_original_field = "90E8C851A8F6A9ECE364702E0F8FFC4E", hash_generated_field = "9E058751C8EDCA9A479290263411F486")

    private static final int GEOLOCATION_PERMISSIONS_SHOW_PROMPT = 130;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.885 -0400", hash_original_field = "4BA2D5841F9CFA2DDBA1426164A8F234", hash_generated_field = "EBBDFB81B17C0299328881EC5293A04F")

    private static final int GEOLOCATION_PERMISSIONS_HIDE_PROMPT = 131;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.885 -0400", hash_original_field = "CF11A22DA4127948A476CD033290BC8D", hash_generated_field = "94BEF01A1474B70C6F1B865162349973")

    private static final int RECEIVED_TOUCH_ICON_URL = 132;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.885 -0400", hash_original_field = "726C652F40C754AB326CA7662427B968", hash_generated_field = "14E0F99C2EE825C2B833110720A4E4A3")

    private static final int GET_VISITED_HISTORY = 133;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.885 -0400", hash_original_field = "347D8E095BC47B4EE0D0AFFCD8A441D8", hash_generated_field = "E2026B263FE01AF8EA0927AE63D344F1")

    private static final int OPEN_FILE_CHOOSER = 134;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.885 -0400", hash_original_field = "DDA4EF57BA7EDD6865AFB71F66096612", hash_generated_field = "345D7B90790909F7DE675D4763166882")

    private static final int ADD_HISTORY_ITEM = 135;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.885 -0400", hash_original_field = "E47A0D78212EBAA6C226917A718522D7", hash_generated_field = "D95397FC5C170E740C5303D3A8A05C5B")

    private static final int HISTORY_INDEX_CHANGED = 136;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.885 -0400", hash_original_field = "A6E6D65EDCEBA9E1213EF8CCE6855690", hash_generated_field = "3DCF48A106D9F1BE6A3873E099553B4A")

    private static final int AUTH_CREDENTIALS = 137;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.885 -0400", hash_original_field = "B11AA85C9F67F142C2BEC310EDCD047D", hash_generated_field = "A3AE08C91BB130064E206832AE02A418")

    private static final int SET_INSTALLABLE_WEBAPP = 138;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.885 -0400", hash_original_field = "BF9BFFEF86D2385E78EDDAE2495AB4A0", hash_generated_field = "C24B72196DDD74F7DDF12FB1EB4231BF")

    private static final int NOTIFY_SEARCHBOX_LISTENERS = 139;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.885 -0400", hash_original_field = "E846F0F51A2809AE1103C135CD963FC1", hash_generated_field = "DF1FFC74E56844B757AE85139F652013")

    private static final int AUTO_LOGIN = 140;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.885 -0400", hash_original_field = "F44C77CADA5C31603D09B4649A61FF4C", hash_generated_field = "DD570499086646796ECB453C67DFA7A2")

    private static final int CLIENT_CERT_REQUEST = 141;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.885 -0400", hash_original_field = "4B8E1AE28BB7AEE993AFE0AD150F701B", hash_generated_field = "3204AA037B01A2C415DD1AD8899FB540")

    private static final int SEARCHBOX_IS_SUPPORTED_CALLBACK = 142;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.885 -0400", hash_original_field = "EBDC352F26A1C3C736F3B415141C80D9", hash_generated_field = "23E6503B9321314390D6CC90C6F99F7C")

    private static final int SEARCHBOX_DISPATCH_COMPLETE_CALLBACK = 143;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.885 -0400", hash_original_field = "B7D6B899C6A4B45279ABA6AB53B5C958", hash_generated_field = "9051530C94DC9265299E5CDAF9B017D1")

    private static final int PROCEEDED_AFTER_SSL_ERROR = 144;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.885 -0400", hash_original_field = "E318E94680AF79EA0A7279378C0BC024", hash_generated_field = "00F56014A24A80FE2F3360FDF7B1E405")

    private static final int NOTIFY = 200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.885 -0400", hash_original_field = "F61A6BEC594680894ED6FFB6E74F8F5A", hash_generated_field = "3B2DC4ACBEB000A20672E69802960DA2")

    private static final boolean PERF_PROBE = false;
}

