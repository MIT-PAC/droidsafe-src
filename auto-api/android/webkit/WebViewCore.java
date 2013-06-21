package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.media.MediaFile;
import android.net.ProxyProperties;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.provider.MediaStore;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.webkit.DeviceMotionService;
import android.webkit.DeviceMotionAndOrientationManager;
import android.webkit.DeviceOrientationService;
import android.webkit.JniUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;

public final class WebViewCore {
    private WebView mWebView;
    private CallbackProxy mCallbackProxy;
    private WebSettings mSettings;
    private Context mContext;
    private int mNativeClass;
    private BrowserFrame mBrowserFrame;
    private Map<String, Object> mJavascriptInterfaces;
    private int mViewportWidth = -1;
    private int mViewportHeight = -1;
    private int mViewportInitialScale = 0;
    private int mViewportMinimumScale = 0;
    private int mViewportMaximumScale = 0;
    private boolean mViewportUserScalable = true;
    private int mViewportDensityDpi = -1;
    private boolean mIsRestored = false;
    private float mRestoredScale = 0;
    private float mRestoredTextWrapScale = 0;
    private int mRestoredX = 0;
    private int mRestoredY = 0;
    private DeviceMotionAndOrientationManager mDeviceMotionAndOrientationManager =
            new DeviceMotionAndOrientationManager(this);
    private DeviceMotionService mDeviceMotionService;
    private DeviceOrientationService mDeviceOrientationService;
    private int mLowMemoryUsageThresholdMb;
    private int mHighMemoryUsageThresholdMb;
    private int mHighUsageDeltaMb;
    private EventHub mEventHub;
    private int mCurrentViewWidth = 0;
    private int mCurrentViewHeight = 0;
    private float mCurrentViewScale = 1.0f;
    private boolean mDrawIsScheduled;
    private boolean mDrawLayersIsScheduled;
    private boolean mSplitPictureIsScheduled;
    private boolean mDrawIsPaused;
    private ViewState mInitialViewState = null;
    private boolean mFirstLayoutForNonStandardLoad;
    DrawData mLastDrawData = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.170 -0400", hash_original_method = "68CF15993B11FD0BF4AA086C5A956766", hash_generated_method = "E63F0DC1FE8B9DDE8E3EDB474434B95C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WebViewCore(Context context, WebView w, CallbackProxy proxy,
            Map<String, Object> javascriptInterfaces) {
        dsTaint.addTaint(w.dsTaint);
        dsTaint.addTaint(javascriptInterfaces.dsTaint);
        dsTaint.addTaint(proxy.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        {
            {
                Thread t;
                t = new Thread(new WebCoreThread());
                t.setName(THREAD_NAME);
                t.start();
                try 
                {
                    WebViewCore.class.wait();
                } //End block
                catch (InterruptedException e)
                { }
            } //End block
        } //End block
        mEventHub = new EventHub();
        mSettings = new WebSettings(mContext, mWebView);
        WebIconDatabase.getInstance();
        WebStorage.getInstance().createUIHandler();
        GeolocationPermissions.getInstance().createUIHandler();
        ActivityManager manager;
        manager = (ActivityManager) mContext.getSystemService(
                Context.ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo memInfo;
        memInfo = new ActivityManager.MemoryInfo();
        manager.getMemoryInfo(memInfo);
        mLowMemoryUsageThresholdMb = manager.getLargeMemoryClass();
        mHighMemoryUsageThresholdMb = (int) (mLowMemoryUsageThresholdMb * 1.5);
        mHighUsageDeltaMb = mLowMemoryUsageThresholdMb / 32;
        Message init;
        init = sWebCoreHandler.obtainMessage(
                WebCoreThread.INITIALIZE, this);
        sWebCoreHandler.sendMessage(init);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.171 -0400", hash_original_method = "A9E80124E796ABAB018EC6550B6A2293", hash_generated_method = "75DB4DF1240284E133DB00C9A96C8EF2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void initialize() {
        mBrowserFrame = new BrowserFrame(mContext, this, mCallbackProxy,
                mSettings, mJavascriptInterfaces);
        mJavascriptInterfaces = null;
        mSettings.syncSettingsAndCreateHandler(mBrowserFrame);
        WebIconDatabase.getInstance().createHandler();
        WebStorage.getInstance().createHandler();
        GeolocationPermissions.getInstance().createHandler();
        mEventHub.transferMessages();
        {
            Message.obtain(mWebView.mPrivateHandler,
                    WebView.WEBCORE_INITIALIZED_MSG_ID,
                    mNativeClass, 0).sendToTarget();
        } //End block
        // ---------- Original Method ----------
        //mBrowserFrame = new BrowserFrame(mContext, this, mCallbackProxy,
                //mSettings, mJavascriptInterfaces);
        //mJavascriptInterfaces = null;
        //mSettings.syncSettingsAndCreateHandler(mBrowserFrame);
        //WebIconDatabase.getInstance().createHandler();
        //WebStorage.getInstance().createHandler();
        //GeolocationPermissions.getInstance().createHandler();
        //mEventHub.transferMessages();
        //if (mWebView != null) {
            //Message.obtain(mWebView.mPrivateHandler,
                    //WebView.WEBCORE_INITIALIZED_MSG_ID,
                    //mNativeClass, 0).sendToTarget();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.171 -0400", hash_original_method = "6D60C608DF715EFA6CF6C0614B6EA5AE", hash_generated_method = "8AA6966A0D32DCA8C668A17BEE70469F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void initializeSubwindow() {
        initialize();
        sWebCoreHandler.removeMessages(WebCoreThread.INITIALIZE, this);
        // ---------- Original Method ----------
        //initialize();
        //sWebCoreHandler.removeMessages(WebCoreThread.INITIALIZE, this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.171 -0400", hash_original_method = "49E2B5EDCA0AFC5006663CDC7A5CE915", hash_generated_method = "CE27C9705C8EA0CD2AE03AD2088A4350")
    @DSModeled(DSC.SAFE)
    synchronized BrowserFrame getBrowserFrame() {
        return (BrowserFrame)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mBrowserFrame;
    }

    
        public static void pauseTimers() {
        if (BrowserFrame.sJavaBridge == null) {
            throw new IllegalStateException(
                    "No WebView has been created in this process!");
        }
        BrowserFrame.sJavaBridge.pause();
    }

    
        public static void resumeTimers() {
        if (BrowserFrame.sJavaBridge == null) {
            throw new IllegalStateException(
                    "No WebView has been created in this process!");
        }
        BrowserFrame.sJavaBridge.resume();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.171 -0400", hash_original_method = "FDAB4AC776E0B1BB8BD354A47F4FA51B", hash_generated_method = "72601775759177436605AD1F490C1F90")
    @DSModeled(DSC.SAFE)
    public WebSettings getSettings() {
        return (WebSettings)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSettings;
    }

    
        static boolean isSupportedMediaMimeType(String mimeType) {
        int fileType = MediaFile.getFileTypeForMimeType(mimeType);
        return MediaFile.isAudioFileType(fileType)
            || MediaFile.isVideoFileType(fileType)
            || MediaFile.isPlayListFileType(fileType)
            || (mimeType != null && mimeType.startsWith("video/m4v"));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.172 -0400", hash_original_method = "1CDEF814C342D7BC6571C7725C279513", hash_generated_method = "ACFD9585F99E042D1BBEEB057C5C1F8B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void addMessageToConsole(String message, int lineNumber, String sourceID,
            int msgLevel) {
        dsTaint.addTaint(sourceID);
        dsTaint.addTaint(message);
        dsTaint.addTaint(lineNumber);
        dsTaint.addTaint(msgLevel);
        mCallbackProxy.addMessageToConsole(message, lineNumber, sourceID, msgLevel);
        // ---------- Original Method ----------
        //mCallbackProxy.addMessageToConsole(message, lineNumber, sourceID, msgLevel);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.172 -0400", hash_original_method = "F33520EFD859046BA24511601C4E309A", hash_generated_method = "C8BC648579F0AB4211F0A77BE1DFD9AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void jsAlert(String url, String message) {
        dsTaint.addTaint(message);
        dsTaint.addTaint(url);
        mCallbackProxy.onJsAlert(url, message);
        // ---------- Original Method ----------
        //mCallbackProxy.onJsAlert(url, message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.172 -0400", hash_original_method = "91FEA98D86997027CFAF7FA478DE35E9", hash_generated_method = "381C2616225D50792707832639ABC30D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void formDidBlur(int nodePointer) {
        dsTaint.addTaint(nodePointer);
        Message.obtain(mWebView.mPrivateHandler, WebView.FORM_DID_BLUR,
                nodePointer, 0).sendToTarget();
        // ---------- Original Method ----------
        //if (mWebView == null) return;
        //Message.obtain(mWebView.mPrivateHandler, WebView.FORM_DID_BLUR,
                //nodePointer, 0).sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.172 -0400", hash_original_method = "A33837A6F28FD62D569A3757B4A4C37F", hash_generated_method = "728931AA1D80E6DAB5BCF82B6EBEDB39")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String openFileChooser(String acceptType) {
        dsTaint.addTaint(acceptType);
        Uri uri;
        uri = mCallbackProxy.openFileChooser(acceptType);
        {
            String filePath;
            filePath = "";
            Cursor cursor;
            cursor = mContext.getContentResolver().query(
                    uri,
                    new String[] { MediaStore.Images.Media.DATA },
                    null, null, null);
            {
                try 
                {
                    {
                        boolean var4B88A4E0CCE1DD5CDA31BC6F14F1DD3B_444378864 = (cursor.moveToNext());
                        {
                            filePath = cursor.getString(0);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                finally 
                {
                    cursor.close();
                } //End block
            } //End block
            {
                filePath = uri.getLastPathSegment();
            } //End block
            String uriString;
            uriString = uri.toString();
            BrowserFrame.sJavaBridge.storeFilePathForContentUri(filePath, uriString);
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.173 -0400", hash_original_method = "EA467B8C1E05E16A088413F72C42053A", hash_generated_method = "2228914DF89A0910752020E895ACD430")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void exceededDatabaseQuota(String url,
                                         String databaseIdentifier,
                                         long currentQuota,
                                         long estimatedSize) {
        dsTaint.addTaint(currentQuota);
        dsTaint.addTaint(estimatedSize);
        dsTaint.addTaint(databaseIdentifier);
        dsTaint.addTaint(url);
        mCallbackProxy.onExceededDatabaseQuota(url, databaseIdentifier,
                currentQuota, estimatedSize, getUsedQuota(),
                new WebStorage.QuotaUpdater() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.173 -0400", hash_original_method = "E4861BC53EE6E98021B183ABEE253837", hash_generated_method = "AE15CF66E0F4829D0A43DD9E529239DA")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void updateQuota(long quota) {
                dsTaint.addTaint(quota);
                nativeSetNewStorageLimit(quota);
                // ---------- Original Method ----------
                //nativeSetNewStorageLimit(quota);
            }
});
        // ---------- Original Method ----------
        //mCallbackProxy.onExceededDatabaseQuota(url, databaseIdentifier,
                //currentQuota, estimatedSize, getUsedQuota(),
                //new WebStorage.QuotaUpdater() {
                        //public void updateQuota(long quota) {
                            //nativeSetNewStorageLimit(quota);
                        //}
                //});
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.173 -0400", hash_original_method = "6EBBAAC7ADAC02435B9F41E378724466", hash_generated_method = "50DC0A844FFD67744A0E5E2CD2042DC8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void reachedMaxAppCacheSize(long spaceNeeded) {
        dsTaint.addTaint(spaceNeeded);
        mCallbackProxy.onReachedMaxAppCacheSize(spaceNeeded, getUsedQuota(),
                new WebStorage.QuotaUpdater() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.173 -0400", hash_original_method = "E4861BC53EE6E98021B183ABEE253837", hash_generated_method = "AE15CF66E0F4829D0A43DD9E529239DA")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void updateQuota(long quota) {
                dsTaint.addTaint(quota);
                nativeSetNewStorageLimit(quota);
                // ---------- Original Method ----------
                //nativeSetNewStorageLimit(quota);
            }
});
        // ---------- Original Method ----------
        //mCallbackProxy.onReachedMaxAppCacheSize(spaceNeeded, getUsedQuota(),
                //new WebStorage.QuotaUpdater() {
                    //public void updateQuota(long quota) {
                        //nativeSetNewStorageLimit(quota);
                    //}
                //});
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.174 -0400", hash_original_method = "08A818E5335EEC34FB33D96D932556A7", hash_generated_method = "E7537CD6BC1E25212B60F2C5933FCCA9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void populateVisitedLinks() {
        ValueCallback callback;
        callback = new ValueCallback<String[]>() {
            public void onReceiveValue(String[] value) {
                sendMessage(EventHub.POPULATE_VISITED_LINKS, (Object)value);
            }
        };
        mCallbackProxy.getVisitedHistory(callback);
        // ---------- Original Method ----------
        //ValueCallback callback = new ValueCallback<String[]>() {
            //public void onReceiveValue(String[] value) {
                //sendMessage(EventHub.POPULATE_VISITED_LINKS, (Object)value);
            //}
        //};
        //mCallbackProxy.getVisitedHistory(callback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.174 -0400", hash_original_method = "AEE66291188900A80051B984C26C1180", hash_generated_method = "EDDE60DD8CA0C8629EBC126578778C07")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void geolocationPermissionsShowPrompt(String origin) {
        dsTaint.addTaint(origin);
        mCallbackProxy.onGeolocationPermissionsShowPrompt(origin,
                new GeolocationPermissions.Callback() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.174 -0400", hash_original_method = "A46AB3E9C99782ECB5C3BEAA7BB41F9A", hash_generated_method = "50F8CC3056A2D8B9E4ADAF0F4D20E61A")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void invoke(String origin, boolean allow, boolean remember) {
                dsTaint.addTaint(remember);
                dsTaint.addTaint(allow);
                dsTaint.addTaint(origin);
                GeolocationPermissionsData data;
                data = new GeolocationPermissionsData();
                data.mOrigin = origin;
                data.mAllow = allow;
                data.mRemember = remember;
                sendMessage(EventHub.GEOLOCATION_PERMISSIONS_PROVIDE, data);
                // ---------- Original Method ----------
                //GeolocationPermissionsData data = new GeolocationPermissionsData();
                //data.mOrigin = origin;
                //data.mAllow = allow;
                //data.mRemember = remember;
                //sendMessage(EventHub.GEOLOCATION_PERMISSIONS_PROVIDE, data);
            }
});
        // ---------- Original Method ----------
        //mCallbackProxy.onGeolocationPermissionsShowPrompt(origin,
                //new GeolocationPermissions.Callback() {
          //public void invoke(String origin, boolean allow, boolean remember) {
            //GeolocationPermissionsData data = new GeolocationPermissionsData();
            //data.mOrigin = origin;
            //data.mAllow = allow;
            //data.mRemember = remember;
            //sendMessage(EventHub.GEOLOCATION_PERMISSIONS_PROVIDE, data);
          //}
        //});
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.174 -0400", hash_original_method = "4D4892762A483BC675FC4A10EF44F79C", hash_generated_method = "1FB8371D825E9FE10F0BBD945183511A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void geolocationPermissionsHidePrompt() {
        mCallbackProxy.onGeolocationPermissionsHidePrompt();
        // ---------- Original Method ----------
        //mCallbackProxy.onGeolocationPermissionsHidePrompt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.174 -0400", hash_original_method = "8F6A3F44BB46AEBAF13827E865603705", hash_generated_method = "57A6A920CF857D6D6261F50FAA3CEA08")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean jsConfirm(String url, String message) {
        dsTaint.addTaint(message);
        dsTaint.addTaint(url);
        boolean var273421F44D5E62654B8C3EBBBD266C64_1596414855 = (mCallbackProxy.onJsConfirm(url, message));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCallbackProxy.onJsConfirm(url, message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.175 -0400", hash_original_method = "048D73921D9D83B7AF6D9F369B7BCD1A", hash_generated_method = "2CB28BC1440C50B36CF0FBAE9E00C8CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String jsPrompt(String url, String message, String defaultValue) {
        dsTaint.addTaint(message);
        dsTaint.addTaint(defaultValue);
        dsTaint.addTaint(url);
        String var128A210C0BEA7D95C19BD572B44688D4_1883009763 = (mCallbackProxy.onJsPrompt(url, message, defaultValue));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mCallbackProxy.onJsPrompt(url, message, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.175 -0400", hash_original_method = "E5A121F239BD1583646FB80C30646EA4", hash_generated_method = "91BD657742071193161361D496606523")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean jsUnload(String url, String message) {
        dsTaint.addTaint(message);
        dsTaint.addTaint(url);
        boolean varE6D95A02CA880D9BAAC68CEDF4C7FB76_911069087 = (mCallbackProxy.onJsBeforeUnload(url, message));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCallbackProxy.onJsBeforeUnload(url, message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.175 -0400", hash_original_method = "3FA5335C13C08E21D5C9AA51DF388549", hash_generated_method = "B609CB2B3F1ADD7C7021BD2146106244")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean jsInterrupt() {
        boolean var2160B208215B2B209E59CF0BAA02BAF8_1250474549 = (mCallbackProxy.onJsTimeout());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCallbackProxy.onJsTimeout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.175 -0400", hash_original_method = "1C765D2623C528E50D87B3709395270F", hash_generated_method = "A1EADBB5CBDDCBDE6CD56C582AB32869")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void setInstallableWebApp() {
        mCallbackProxy.setInstallableWebApp();
        // ---------- Original Method ----------
        //mCallbackProxy.setInstallableWebApp();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.175 -0400", hash_original_method = "CEB9108623A7C7A0C2BFBDCA074B84FE", hash_generated_method = "4574D62F5DCF8B03B58A56A3713DE32A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void enterFullscreenForVideoLayer(int layerId, String url) {
        dsTaint.addTaint(layerId);
        dsTaint.addTaint(url);
        Message message;
        message = Message.obtain(mWebView.mPrivateHandler,
                       WebView.ENTER_FULLSCREEN_VIDEO, layerId, 0);
        message.obj = url;
        message.sendToTarget();
        // ---------- Original Method ----------
        //if (mWebView == null) return;
        //Message message = Message.obtain(mWebView.mPrivateHandler,
                       //WebView.ENTER_FULLSCREEN_VIDEO, layerId, 0);
        //message.obj = url;
        //message.sendToTarget();
    }

    
        static String nativeFindAddress(String addr, boolean caseInsensitive) {
        return DSUtils.UNKNOWN_STRING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.176 -0400", hash_original_method = "3321B2428EFA479CDCDAB88856C4C216", hash_generated_method = "4F6E9ACC880EEDBEDF0C00DB397038D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeClearContent() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.176 -0400", hash_original_method = "13D7E9686CEB46717C49AB16608C51CF", hash_generated_method = "0AD4066194FDF113B1E6EB7E6F9C5ECE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeContentInvalidateAll() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.176 -0400", hash_original_method = "BFFDD95C5B679D515FF25E2212141F07", hash_generated_method = "E387973ACD90ABCAFF1710F6FFAD85A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeRecordContent(Region invalRegion, Point wh) {
        dsTaint.addTaint(wh.dsTaint);
        dsTaint.addTaint(invalRegion.dsTaint);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.176 -0400", hash_original_method = "8B828971EA2E2F12F8B254DF3483012F", hash_generated_method = "3842F7B6A5E730C60CFECEDAAA09B227")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean nativeUpdateLayers(int nativeClass, int baseLayer) {
        dsTaint.addTaint(nativeClass);
        dsTaint.addTaint(baseLayer);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.176 -0400", hash_original_method = "35C4B35D5036F5DD5E458797A063F760", hash_generated_method = "5BFA75F4FDD9C22351919ADCC2F2E82A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeNotifyAnimationStarted(int nativeClass) {
        dsTaint.addTaint(nativeClass);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.176 -0400", hash_original_method = "73C7C1AE1D8DFCB366E36E3A519B57F0", hash_generated_method = "C15376B41B87FC9320F3EDD62162A7A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean nativeFocusBoundsChanged() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.176 -0400", hash_original_method = "7060C98AD2B6D1D27FBDA877BC7BC75F", hash_generated_method = "91CA2387862A331DE258F3E736974EAB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeSplitContent(int content) {
        dsTaint.addTaint(content);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.177 -0400", hash_original_method = "0325F1899906FABB340645FF6A74C4CF", hash_generated_method = "EFD2200F07978869B91430CAD894C273")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean nativeKey(int keyCode, int unichar,
            int repeatCount, boolean isShift, boolean isAlt, boolean isSym,
            boolean isDown) {
        dsTaint.addTaint(isDown);
        dsTaint.addTaint(isAlt);
        dsTaint.addTaint(unichar);
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(isSym);
        dsTaint.addTaint(repeatCount);
        dsTaint.addTaint(isShift);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.177 -0400", hash_original_method = "70A418E65E32BB0E515A5AA033BDE85F", hash_generated_method = "99D6C3224578CBCD34FEB7473670E887")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeClick(int framePtr, int nodePtr, boolean fake) {
        dsTaint.addTaint(nodePtr);
        dsTaint.addTaint(framePtr);
        dsTaint.addTaint(fake);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.177 -0400", hash_original_method = "71551FF77A19704BFDEA681298A1C532", hash_generated_method = "712824D05779D7D37D7C3428AF6AC8B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeSendListBoxChoices(boolean[] choices, int size) {
        dsTaint.addTaint(choices[0]);
        dsTaint.addTaint(size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.177 -0400", hash_original_method = "2618C62A7F157C7D34B87A8252580B1E", hash_generated_method = "4EBF6E8EAD3B911836942B669E7960DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeSendListBoxChoice(int choice) {
        dsTaint.addTaint(choice);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.177 -0400", hash_original_method = "AA6AE3A40C1C9F44C6F8CF239E11299A", hash_generated_method = "31675566573DB236892B4FCBA4C7C5EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeCloseIdleConnections() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.177 -0400", hash_original_method = "2A4CBEA83BAEBD0A1BEAE59497423C44", hash_generated_method = "9621185E106674F5FBEFCE428870C812")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeSetSize(int width, int height, int textWrapWidth,
            float scale, int screenWidth, int screenHeight, int anchorX,
            int anchorY, boolean ignoreHeight) {
        dsTaint.addTaint(screenHeight);
        dsTaint.addTaint(ignoreHeight);
        dsTaint.addTaint(scale);
        dsTaint.addTaint(textWrapWidth);
        dsTaint.addTaint(height);
        dsTaint.addTaint(screenWidth);
        dsTaint.addTaint(width);
        dsTaint.addTaint(anchorY);
        dsTaint.addTaint(anchorX);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.177 -0400", hash_original_method = "2D1706BAD8A7F0247CBA9A3206675903", hash_generated_method = "E956EDB50287605A2DBB308EE3C1F8C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeGetContentMinPrefWidth() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.178 -0400", hash_original_method = "B8EB103A209F8746ABD011DD32864795", hash_generated_method = "8908EC8276F3588CE2A267B5948B57F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeReplaceTextfieldText(
            int oldStart, int oldEnd, String replace, int newStart, int newEnd,
            int textGeneration) {
        dsTaint.addTaint(replace);
        dsTaint.addTaint(oldEnd);
        dsTaint.addTaint(newStart);
        dsTaint.addTaint(textGeneration);
        dsTaint.addTaint(oldStart);
        dsTaint.addTaint(newEnd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.178 -0400", hash_original_method = "9A03490EFF94C535BBBC062423FDF770", hash_generated_method = "5DA592009BCE22280F4F3CE0AF0A6AB8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void passToJs(int gen,
            String currentText, int keyCode, int keyValue, boolean down,
            boolean cap, boolean fn, boolean sym) {
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(currentText);
        dsTaint.addTaint(gen);
        dsTaint.addTaint(cap);
        dsTaint.addTaint(down);
        dsTaint.addTaint(sym);
        dsTaint.addTaint(fn);
        dsTaint.addTaint(keyValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.178 -0400", hash_original_method = "731A9DE98191A7AE554758463A8E339C", hash_generated_method = "816D69CA5614F80F2B6A307B80A7F8FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeSetFocusControllerActive(boolean active) {
        dsTaint.addTaint(active);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.178 -0400", hash_original_method = "2F51FDF2CB321B99E6DFA3281F5101CC", hash_generated_method = "D66D3673E1E31DBA9620976C37A333C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeSaveDocumentState(int frame) {
        dsTaint.addTaint(frame);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.178 -0400", hash_original_method = "85DD951D7BA7B47A52141773E659FF39", hash_generated_method = "9B820FB4CB5E13A580379A76CA97072E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeMoveFocus(int framePtr, int nodePointer) {
        dsTaint.addTaint(framePtr);
        dsTaint.addTaint(nodePointer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.178 -0400", hash_original_method = "A6F32C1338CD19726DF22CA448394172", hash_generated_method = "4CAF781A2576646202A92816834CB3C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeMoveMouse(int framePtr, int x, int y) {
        dsTaint.addTaint(framePtr);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.179 -0400", hash_original_method = "C235A3B24BC384A4B13E333446CE6D73", hash_generated_method = "B32D277E9097ABD7858A85E9C6089277")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeMoveMouseIfLatest(int moveGeneration,
            int framePtr, int x, int y) {
        dsTaint.addTaint(framePtr);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        dsTaint.addTaint(moveGeneration);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.179 -0400", hash_original_method = "241A051A4ABC8D2C1F54A842088CB439", hash_generated_method = "FCF9704C3780B024775C35ED7B918EBE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String nativeRetrieveHref(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.179 -0400", hash_original_method = "FBE4886E30C0F15C8EE972672B86778C", hash_generated_method = "668079E4C4C9DFA573CE492F55A07E5E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String nativeRetrieveAnchorText(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.179 -0400", hash_original_method = "7F214D01044FDB7C0A6FFA5743028C76", hash_generated_method = "D16AEBDB175B6C569C3D77F411A69BC6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String nativeRetrieveImageSource(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.179 -0400", hash_original_method = "88A920F51B60DD8B7CF755C65AD2CD4B", hash_generated_method = "82AFA989ED63A9EC421F618704AFE7DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeStopPaintingCaret() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.179 -0400", hash_original_method = "9296BE828873621211792703531EF020", hash_generated_method = "65A8D3403F505E09E170F3034DEA4FDC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeTouchUp(int touchGeneration,
            int framePtr, int nodePtr, int x, int y) {
        dsTaint.addTaint(nodePtr);
        dsTaint.addTaint(framePtr);
        dsTaint.addTaint(touchGeneration);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.179 -0400", hash_original_method = "6E256A1C9154CE3109BDE15092BA1E46", hash_generated_method = "50390E2CD74863E7CABE740123BFC70A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean nativeHandleTouchEvent(int action, int[] idArray,
            int[] xArray, int[] yArray, int count, int actionIndex, int metaState) {
        dsTaint.addTaint(metaState);
        dsTaint.addTaint(count);
        dsTaint.addTaint(yArray[0]);
        dsTaint.addTaint(xArray[0]);
        dsTaint.addTaint(action);
        dsTaint.addTaint(actionIndex);
        dsTaint.addTaint(idArray[0]);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.180 -0400", hash_original_method = "5DF4B15A046A1C8193010BE985610007", hash_generated_method = "8B244E3CBAAF2E7E34F0C84484F4BF37")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeUpdateFrameCache() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.180 -0400", hash_original_method = "9D2250220C9E1A2522A1ED6887AE6CE9", hash_generated_method = "B10BD5DE54165533A9C0A819A66D2845")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeSetBackgroundColor(int color) {
        dsTaint.addTaint(color);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.180 -0400", hash_original_method = "AA3E36FB02CBFB05644F704D8E558646", hash_generated_method = "37ECA37C21DC786E2BCE160D5E8979EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeDumpDomTree(boolean useFile) {
        dsTaint.addTaint(useFile);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.180 -0400", hash_original_method = "BD4BD7606C8F6CEDCA447CEAD83A3B9E", hash_generated_method = "4417CB0CE0BD11BAD1A048B7F3F14ACD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeDumpRenderTree(boolean useFile) {
        dsTaint.addTaint(useFile);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.180 -0400", hash_original_method = "BA54C8246871B46F32623955B4EB301E", hash_generated_method = "BD892AD6C25879A54F4D42D86A23E0BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeDumpNavTree() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.180 -0400", hash_original_method = "8B3EC012E68CBA5C936E0A667ADD1C4C", hash_generated_method = "74DC4B2A8E47F0220A502E9F1DCB6173")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeDumpV8Counters() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.180 -0400", hash_original_method = "F3F0788077DAD1F9BFCE6F15D319CC63", hash_generated_method = "BC5A1E7687CC68FBD4FC01A3BB0A2ECC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeSetJsFlags(String flags) {
        dsTaint.addTaint(flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.180 -0400", hash_original_method = "57BBD8F6823CD4AFC27D90CDB0FA1518", hash_generated_method = "A2506F06D27BE59938587BF5249EABD6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeDeleteSelection(int start, int end,
            int textGeneration) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(textGeneration);
        dsTaint.addTaint(end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.181 -0400", hash_original_method = "E5C6AAA39851A50D9CE3B905BCD5E24D", hash_generated_method = "6F804DAAE25B381ABB549824B6EB54DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeSetSelection(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.181 -0400", hash_original_method = "439BD7C80B92A6DF144499531B46441F", hash_generated_method = "0054154364A8B0E93292BA8DE32770FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeRegisterURLSchemeAsLocal(String scheme) {
        dsTaint.addTaint(scheme);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.181 -0400", hash_original_method = "38BB405567582FE2ECD514780CDB4D80", hash_generated_method = "7EE891013866A16D1AB2E484D44712C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeSetNewStorageLimit(long limit) {
        dsTaint.addTaint(limit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.181 -0400", hash_original_method = "FB112EA9A2452AC298500FCFB087229A", hash_generated_method = "F7C543C875A0C8E811AF7E508FDCCEDA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeGeolocationPermissionsProvide(String origin, boolean allow, boolean remember) {
        dsTaint.addTaint(remember);
        dsTaint.addTaint(allow);
        dsTaint.addTaint(origin);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.181 -0400", hash_original_method = "26AE2AF434B9C69ABDC8C488B6A433CD", hash_generated_method = "A150DF9922E3D855456EE3B80F639AB9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeProvideVisitedHistory(String[] history) {
        dsTaint.addTaint(history[0]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.181 -0400", hash_original_method = "7F9DDA20412A0AF9D5E94CA5D5B0BEAA", hash_generated_method = "1C91D43905AE217C02CCD79404643318")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String nativeModifySelection(int direction, int granularity) {
        dsTaint.addTaint(direction);
        dsTaint.addTaint(granularity);
        return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.181 -0400", hash_original_method = "D1B7DF7B765695C5C682B348754C5EEE", hash_generated_method = "F1CE17105A07E4CAFDF09BB76101A5C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void stopLoading() {
        {
            mBrowserFrame.stopLoading();
        } //End block
        // ---------- Original Method ----------
        //if (DebugFlags.WEB_VIEW_CORE) Log.v(LOGTAG, "CORE stopLoading");
        //if (mBrowserFrame != null) {
            //mBrowserFrame.stopLoading();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.181 -0400", hash_original_method = "7711F35529A80997737E0C04E1483C72", hash_generated_method = "E8B29CC750F3704A391C799659FBCB5F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        mEventHub.sendMessage(msg);
        // ---------- Original Method ----------
        //mEventHub.sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.182 -0400", hash_original_method = "E19A847BDC376FCC409B2080F91A4777", hash_generated_method = "B22083976C29F4C2A36C449FBF9A04A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void sendMessage(int what) {
        dsTaint.addTaint(what);
        mEventHub.sendMessage(Message.obtain(null, what));
        // ---------- Original Method ----------
        //mEventHub.sendMessage(Message.obtain(null, what));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.182 -0400", hash_original_method = "3E0AD5D05665DC86C1B2BC352FB304E3", hash_generated_method = "C16D070AD18BC5C506BAB1F53412B50D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void sendMessage(int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        mEventHub.sendMessage(Message.obtain(null, what, obj));
        // ---------- Original Method ----------
        //mEventHub.sendMessage(Message.obtain(null, what, obj));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.182 -0400", hash_original_method = "C23BF0CD5B475AFDE2C5AFE3693DBFAC", hash_generated_method = "E46581F144B015E0FD65D296880C6831")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void sendMessage(int what, int arg1) {
        dsTaint.addTaint(arg1);
        dsTaint.addTaint(what);
        mEventHub.sendMessage(Message.obtain(null, what, arg1, 0));
        // ---------- Original Method ----------
        //mEventHub.sendMessage(Message.obtain(null, what, arg1, 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.182 -0400", hash_original_method = "BB791EA62C0999DDA8C7D0E8B12A435D", hash_generated_method = "7AB30736775E36B1F8B63F9EF4231DF3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void sendMessage(int what, int arg1, int arg2) {
        dsTaint.addTaint(arg2);
        dsTaint.addTaint(arg1);
        dsTaint.addTaint(what);
        mEventHub.sendMessage(Message.obtain(null, what, arg1, arg2));
        // ---------- Original Method ----------
        //mEventHub.sendMessage(Message.obtain(null, what, arg1, arg2));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.182 -0400", hash_original_method = "F818943F2C2BA5FC914E03EA08D08398", hash_generated_method = "E72B4C95E51620ED51021DEA96505282")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void sendMessage(int what, int arg1, Object obj) {
        dsTaint.addTaint(arg1);
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        mEventHub.sendMessage(Message.obtain(null, what, arg1, 0, obj));
        // ---------- Original Method ----------
        //mEventHub.sendMessage(Message.obtain(null, what, arg1, 0, obj));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.182 -0400", hash_original_method = "6F3BFA4748A47EA8C7E77DF53F526C02", hash_generated_method = "F150DCDBCB098FFB787F58582123B5C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void sendMessage(int what, int arg1, int arg2, Object obj) {
        dsTaint.addTaint(arg2);
        dsTaint.addTaint(arg1);
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        mEventHub.sendMessage(Message.obtain(null, what, arg1, arg2, obj));
        // ---------- Original Method ----------
        //mEventHub.sendMessage(Message.obtain(null, what, arg1, arg2, obj));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.183 -0400", hash_original_method = "D6940867453E54F97589FC877C811177", hash_generated_method = "A4E44AA77160B820807E2AFFFE8A0843")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void sendMessageAtFrontOfQueue(int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        mEventHub.sendMessageAtFrontOfQueue(Message.obtain(
                null, what, obj));
        // ---------- Original Method ----------
        //mEventHub.sendMessageAtFrontOfQueue(Message.obtain(
                //null, what, obj));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.183 -0400", hash_original_method = "E02AF416600FEDFA3677939C48774A40", hash_generated_method = "855A82C174548EA2CF19655E94E5B2C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void sendMessageDelayed(int what, Object obj, long delay) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(delay);
        mEventHub.sendMessageDelayed(Message.obtain(null, what, obj), delay);
        // ---------- Original Method ----------
        //mEventHub.sendMessageDelayed(Message.obtain(null, what, obj), delay);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.183 -0400", hash_original_method = "5A5B79979B60ACD2210356FAD25017D3", hash_generated_method = "70693CA1950917E2FE5B43CE021F9BC0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void removeMessages(int what) {
        dsTaint.addTaint(what);
        mEventHub.removeMessages(what);
        // ---------- Original Method ----------
        //mEventHub.removeMessages(what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.183 -0400", hash_original_method = "24F837264907471F101C9345660807F0", hash_generated_method = "4EB910573394E1C2C40C4AC009188F44")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void removeMessages() {
        mEventHub.removeMessages();
        // ---------- Original Method ----------
        //mEventHub.removeMessages();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.183 -0400", hash_original_method = "632CCE7E9EF22DEC0E7940476F7FAE4E", hash_generated_method = "7132B1CE839549CA48285E86C9DBC192")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void destroy() {
        {
            mEventHub.mDestroying = true;
            mEventHub.sendMessage(
                    Message.obtain(null, EventHub.DESTROY));
            mEventHub.blockMessages();
        } //End block
        // ---------- Original Method ----------
        //synchronized (mEventHub) {
            //mEventHub.mDestroying = true;
            //mEventHub.sendMessage(
                    //Message.obtain(null, EventHub.DESTROY));
            //mEventHub.blockMessages();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.184 -0400", hash_original_method = "4EA5384F21A7BECF7B7E7FDA52086518", hash_generated_method = "81BE4EA7824D1A6695F946AE183E30BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void clearCache(boolean includeDiskFiles) {
        dsTaint.addTaint(includeDiskFiles);
        mBrowserFrame.clearCache();
        {
            CacheManager.removeAllCacheFiles();
        } //End block
        // ---------- Original Method ----------
        //mBrowserFrame.clearCache();
        //if (includeDiskFiles) {
            //CacheManager.removeAllCacheFiles();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.184 -0400", hash_original_method = "AA9F9969DB77E536EC07D516D83D1BCB", hash_generated_method = "5970DFE417207ABBB5E9C864E49EC7FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void loadUrl(String url, Map<String, String> extraHeaders) {
        dsTaint.addTaint(extraHeaders.dsTaint);
        dsTaint.addTaint(url);
        mBrowserFrame.loadUrl(url, extraHeaders);
        // ---------- Original Method ----------
        //if (DebugFlags.WEB_VIEW_CORE) Log.v(LOGTAG, " CORE loadUrl " + url);
        //mBrowserFrame.loadUrl(url, extraHeaders);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.184 -0400", hash_original_method = "39AB37F211BE7296755FEECD44D0BABF", hash_generated_method = "698C90B7A2F8F8F6D2C9C18514D22967")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String saveWebArchive(String filename, boolean autoname) {
        dsTaint.addTaint(autoname);
        dsTaint.addTaint(filename);
        String var1CB677406B93C6660D7237A15A696A4A_686224886 = (mBrowserFrame.saveWebArchive(filename, autoname));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (DebugFlags.WEB_VIEW_CORE) {
            //Log.v(LOGTAG, " CORE saveWebArchive " + filename + " " + autoname);
        //}
        //return mBrowserFrame.saveWebArchive(filename, autoname);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.184 -0400", hash_original_method = "E69496F6C06CA8A97AAA7658612739AE", hash_generated_method = "88C93657A1ACF0B9496F59EE5773581D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void key(KeyEvent evt, boolean isDown) {
        dsTaint.addTaint(isDown);
        dsTaint.addTaint(evt.dsTaint);
        int keyCode;
        keyCode = evt.getKeyCode();
        int unicodeChar;
        unicodeChar = evt.getUnicodeChar();
        {
            boolean var629113EB419C0BB3B95DA845CC8A58D9_1142237459 = (keyCode == KeyEvent.KEYCODE_UNKNOWN && evt.getCharacters() != null
                && evt.getCharacters().length() > 0);
            {
                unicodeChar = evt.getCharacters().codePointAt(0);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varB7AF9169DA51A962128A0C1EE416A901_1567940835 = (!nativeKey(keyCode, unicodeChar, evt.getRepeatCount(), evt.isShiftPressed(),
                evt.isAltPressed(), evt.isSymPressed(),
                isDown) && keyCode != KeyEvent.KEYCODE_ENTER);
            {
                {
                    {
                        boolean var54B618AB61CB605F60CDFD0F53771954_596541781 = (mWebView != null && evt.isDown());
                        {
                            Message.obtain(mWebView.mPrivateHandler,
                            WebView.UNHANDLED_NAV_KEY, keyCode,
                            0).sendToTarget();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                mCallbackProxy.onUnhandledKeyEvent(evt);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.185 -0400", hash_original_method = "946C6245DADFE1E4F7C078AC5EFCBE5B", hash_generated_method = "9FE4EF7730F6B4FF6F2A09079E31F8FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void viewSizeChanged(WebView.ViewSizeData data) {
        dsTaint.addTaint(data.dsTaint);
        int w;
        w = data.mWidth;
        int h;
        h = data.mHeight;
        int textwrapWidth;
        textwrapWidth = data.mTextWrapWidth;
        float scale;
        scale = data.mScale;
        int width;
        width = calculateWindowWidth(w);
        int height;
        height = h;
        {
            float heightWidthRatio;
            heightWidthRatio = data.mHeightWidthRatio;
            float ratio;
            ratio = heightWidthRatio;
            ratio = (float) h / w;
            height = Math.round(ratio * width);
        } //End block
        nativeSetSize(width, height, textwrapWidth, scale, w,
                data.mActualViewHeight > 0 ? data.mActualViewHeight : h,
                data.mAnchorX, data.mAnchorY, data.mIgnoreHeight);
        boolean needInvalidate;
        needInvalidate = (mCurrentViewWidth == 0);
        mCurrentViewWidth = w;
        mCurrentViewHeight = h;
        mCurrentViewScale = scale;
        {
            contentDraw();
        } //End block
        mEventHub.sendMessage(Message.obtain(null,
                EventHub.UPDATE_CACHE_AND_TEXT_ENTRY));
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.185 -0400", hash_original_method = "D41B819EC6CC76FA3A89B783D40CD109", hash_generated_method = "7AFB653B2B0AB658B1324412B1D5A832")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int calculateWindowWidth(int viewWidth) {
        dsTaint.addTaint(viewWidth);
        int width;
        width = viewWidth;
        {
            boolean var3757732773C9DA3C82C0E4C387210297_1939149189 = (mSettings.getUseWideViewPort());
            {
                {
                    width = WebView.DEFAULT_VIEWPORT_WIDTH;
                } //End block
                {
                    width = mViewportWidth;
                } //End block
                {
                    width = Math.round(mWebView.getViewWidth() / mWebView.getDefaultZoomScale());
                } //End block
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int width = viewWidth;
        //if (mSettings.getUseWideViewPort()) {
            //if (mViewportWidth == -1) {
                //width = WebView.DEFAULT_VIEWPORT_WIDTH;
            //} else if (mViewportWidth > 0) {
                //width = mViewportWidth;
            //} else {
                //width = Math.round(mWebView.getViewWidth() / mWebView.getDefaultZoomScale());
            //}
        //}
        //return width;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.185 -0400", hash_original_method = "261CDCDC6F5C121338E8B1C49F51F57D", hash_generated_method = "7D15B5B8FCE7F9110E7559E6E5BB85FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sendUpdateTextEntry() {
        {
            Message.obtain(mWebView.mPrivateHandler,
                    WebView.UPDATE_TEXT_ENTRY_MSG_ID).sendToTarget();
        } //End block
        // ---------- Original Method ----------
        //if (mWebView != null) {
            //Message.obtain(mWebView.mPrivateHandler,
                    //WebView.UPDATE_TEXT_ENTRY_MSG_ID).sendToTarget();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.192 -0400", hash_original_method = "C9A09E0BE5548FD8F21659E9C96899A7", hash_generated_method = "85CCFCDFBB7222C9F28E324F692B2DD1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private long getUsedQuota() {
        WebStorage webStorage;
        webStorage = WebStorage.getInstance();
        Collection<WebStorage.Origin> origins;
        origins = webStorage.getOriginsSync();
        long usedQuota;
        usedQuota = 0;
        {
            Iterator<WebStorage.Origin> var947ACF580B48AA109FD95C7D4B051270_439714531 = (origins).iterator();
            var947ACF580B48AA109FD95C7D4B051270_439714531.hasNext();
            WebStorage.Origin website = var947ACF580B48AA109FD95C7D4B051270_439714531.next();
            {
                usedQuota += website.getQuota();
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //WebStorage webStorage = WebStorage.getInstance();
        //Collection<WebStorage.Origin> origins = webStorage.getOriginsSync();
        //if (origins == null) {
            //return 0;
        //}
        //long usedQuota = 0;
        //for (WebStorage.Origin website : origins) {
            //usedQuota += website.getQuota();
        //}
        //return usedQuota;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.192 -0400", hash_original_method = "5A8A60F9907CD1F32895929FD9CD4B62", hash_generated_method = "700E285510624DFEB0766049B7C30D34")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void splitContent(int content) {
        dsTaint.addTaint(content);
        {
            mSplitPictureIsScheduled = true;
            sendMessage(EventHub.SPLIT_PICTURE_SET, content, 0);
        } //End block
        // ---------- Original Method ----------
        //if (!mSplitPictureIsScheduled) {
            //mSplitPictureIsScheduled = true;
            //sendMessage(EventHub.SPLIT_PICTURE_SET, content, 0);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.193 -0400", hash_original_method = "16C23BC9F883695D8B710B8E94BB257A", hash_generated_method = "C4396AC8F4D155C22476285AB2DDFD40")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void webkitDrawLayers() {
        mDrawLayersIsScheduled = false;
        {
            removeMessages(EventHub.WEBKIT_DRAW);
            webkitDraw();
        } //End block
        {
            boolean var039A9D9A35DD87BA5CA4F1479333A022_1861475405 = (nativeUpdateLayers(mNativeClass, mLastDrawData.mBaseLayer));
            {
                webkitDraw();
            } //End block
        } //End collapsed parenthetic
        mWebView.mPrivateHandler.removeMessages(WebView.INVAL_RECT_MSG_ID);
        mWebView.mPrivateHandler.sendMessageAtFrontOfQueue(mWebView.mPrivateHandler
                .obtainMessage(WebView.INVAL_RECT_MSG_ID));
        // ---------- Original Method ----------
        //mDrawLayersIsScheduled = false;
        //if (mDrawIsScheduled || mLastDrawData == null) {
            //removeMessages(EventHub.WEBKIT_DRAW);
            //webkitDraw();
            //return;
        //}
        //if (nativeUpdateLayers(mNativeClass, mLastDrawData.mBaseLayer)) {
            //webkitDraw();
        //}
        //mWebView.mPrivateHandler.removeMessages(WebView.INVAL_RECT_MSG_ID);
        //mWebView.mPrivateHandler.sendMessageAtFrontOfQueue(mWebView.mPrivateHandler
                //.obtainMessage(WebView.INVAL_RECT_MSG_ID));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.193 -0400", hash_original_method = "BB9CB43D2CFBC69EF1EE145BAE6ACA31", hash_generated_method = "61540F4F02043E9BA4705F25ADFCEAA5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void webkitDraw() {
        mDrawIsScheduled = false;
        DrawData draw;
        draw = new DrawData();
        draw.mBaseLayer = nativeRecordContent(draw.mInvalRegion, draw.mContentSize);
        {
            {
                boolean var91328F1EF17FDBCA677D8BD72BECFE5F_133291779 = (mWebView != null && !mWebView.isPaused());
                {
                    mEventHub.sendMessage(Message.obtain(null, EventHub.WEBKIT_DRAW));
                } //End block
            } //End collapsed parenthetic
        } //End block
        mLastDrawData = draw;
        webkitDraw(draw);
        // ---------- Original Method ----------
        //mDrawIsScheduled = false;
        //DrawData draw = new DrawData();
        //if (DebugFlags.WEB_VIEW_CORE) Log.v(LOGTAG, "webkitDraw start");
        //draw.mBaseLayer = nativeRecordContent(draw.mInvalRegion, draw.mContentSize);
        //if (draw.mBaseLayer == 0) {
            //if (mWebView != null && !mWebView.isPaused()) {
                //if (DebugFlags.WEB_VIEW_CORE) Log.v(LOGTAG, "webkitDraw abort, resending draw message");
                //mEventHub.sendMessage(Message.obtain(null, EventHub.WEBKIT_DRAW));
            //} else {
                //if (DebugFlags.WEB_VIEW_CORE) Log.v(LOGTAG, "webkitDraw abort, webview paused");
            //}
            //return;
        //}
        //mLastDrawData = draw;
        //webkitDraw(draw);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.194 -0400", hash_original_method = "9C55B9902567F10864019D1DAA55A307", hash_generated_method = "61C14B760C3EA7DF90F0914DCFCE33BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void webkitDraw(DrawData draw) {
        dsTaint.addTaint(draw.dsTaint);
        {
            draw.mFocusSizeChanged = nativeFocusBoundsChanged();
            draw.mViewSize = new Point(mCurrentViewWidth, mCurrentViewHeight);
            {
                boolean varB1D57029EC09AF271F3C2AF9EE408353_737634938 = (mSettings.getUseWideViewPort());
                {
                    draw.mMinPrefWidth = Math.max(
                        mViewportWidth == -1 ? WebView.DEFAULT_VIEWPORT_WIDTH
                                : (mViewportWidth == 0 ? mCurrentViewWidth
                                        : mViewportWidth),
                        nativeGetContentMinPrefWidth());
                } //End block
            } //End collapsed parenthetic
            {
                draw.mViewState = mInitialViewState;
                mInitialViewState = null;
            } //End block
            {
                draw.mFirstLayoutForNonStandardLoad = true;
                mFirstLayoutForNonStandardLoad = false;
            } //End block
            Message.obtain(mWebView.mPrivateHandler,
                    WebView.NEW_PICTURE_MSG_ID, draw).sendToTarget();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        static void reducePriority() {
        sWebCoreHandler.removeMessages(WebCoreThread.REDUCE_PRIORITY);
        sWebCoreHandler.removeMessages(WebCoreThread.RESUME_PRIORITY);
        sWebCoreHandler.sendMessageAtFrontOfQueue(sWebCoreHandler
                .obtainMessage(WebCoreThread.REDUCE_PRIORITY));
    }

    
        static void resumePriority() {
        sWebCoreHandler.removeMessages(WebCoreThread.REDUCE_PRIORITY);
        sWebCoreHandler.removeMessages(WebCoreThread.RESUME_PRIORITY);
        sWebCoreHandler.sendMessageAtFrontOfQueue(sWebCoreHandler
                .obtainMessage(WebCoreThread.RESUME_PRIORITY));
    }

    
        static void sendStaticMessage(int messageType, Object argument) {
        if (sWebCoreHandler == null)
            return;
        sWebCoreHandler.sendMessage(sWebCoreHandler.obtainMessage(messageType, argument));
    }

    
        static void pauseUpdatePicture(WebViewCore core) {
        if (core != null) {
            if (!core.getSettings().enableSmoothTransition()) return;
            synchronized (core) {
                if (core.mNativeClass == 0) {
                    Log.w(LOGTAG, "Cannot pauseUpdatePicture, core destroyed or not initialized!");
                    return;
                }
                core.nativeSetIsPaused(true);
                core.mDrawIsPaused = true;
            }
        }
    }

    
        static void resumeUpdatePicture(WebViewCore core) {
        if (core != null) {
            if (!core.mDrawIsPaused)
                return;
            synchronized (core) {
                if (core.mNativeClass == 0) {
                    Log.w(LOGTAG, "Cannot resumeUpdatePicture, core destroyed!");
                    return;
                }
                core.nativeSetIsPaused(false);
                core.mDrawIsPaused = false;
                core.mDrawIsScheduled = false;
            }
        }
    }

    
        static boolean isUpdatePicturePaused(WebViewCore core) {
        return core != null ? core.mDrawIsPaused : false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.195 -0400", hash_original_method = "F63E17FBEAA6E278B676F177339490F6", hash_generated_method = "279EEC4CE61977ADEEF9158749D7ABCB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void restoreState(int index) {
        dsTaint.addTaint(index);
        WebBackForwardList list;
        list = mCallbackProxy.getBackForwardList();
        int size;
        size = list.getSize();
        {
            int i;
            i = 0;
            {
                list.getItemAtIndex(i).inflate(mBrowserFrame.mNativeFrame);
            } //End block
        } //End collapsed parenthetic
        mBrowserFrame.mLoadInitFromJava = true;
        list.restoreIndex(mBrowserFrame.mNativeFrame, index);
        mBrowserFrame.mLoadInitFromJava = false;
        // ---------- Original Method ----------
        //WebBackForwardList list = mCallbackProxy.getBackForwardList();
        //int size = list.getSize();
        //for (int i = 0; i < size; i++) {
            //list.getItemAtIndex(i).inflate(mBrowserFrame.mNativeFrame);
        //}
        //mBrowserFrame.mLoadInitFromJava = true;
        //list.restoreIndex(mBrowserFrame.mNativeFrame, index);
        //mBrowserFrame.mLoadInitFromJava = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.195 -0400", hash_original_method = "1D90769B244FD8A3CA2CA8B94E1DA948", hash_generated_method = "DB939CECA5D0A17E64FFDB8E1A00B7C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void contentDraw() {
        {
            {
                boolean var9E195732C0279075ECC2E1148458FA76_1131210042 = (mCurrentViewWidth == 0 || !mBrowserFrame.firstLayoutDone());
            } //End collapsed parenthetic
            mDrawIsScheduled = true;
            mEventHub.sendMessage(Message.obtain(null, EventHub.WEBKIT_DRAW));
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mWebView == null || mBrowserFrame == null) {
                //return;
            //}
            //if (mCurrentViewWidth == 0 || !mBrowserFrame.firstLayoutDone()) {
                //return;
            //}
            //if (mDrawIsScheduled) return;
            //mDrawIsScheduled = true;
            //mEventHub.sendMessage(Message.obtain(null, EventHub.WEBKIT_DRAW));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.196 -0400", hash_original_method = "A3D463EE1053B0BDD6C0EF630EFBF61E", hash_generated_method = "FB867318FE4B709F20DD39FA1A36D311")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void layersDraw() {
        {
            mDrawLayersIsScheduled = true;
            mEventHub.sendMessage(Message.obtain(null, EventHub.WEBKIT_DRAW_LAYERS));
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mDrawLayersIsScheduled) return;
            //mDrawLayersIsScheduled = true;
            //mEventHub.sendMessage(Message.obtain(null, EventHub.WEBKIT_DRAW_LAYERS));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.196 -0400", hash_original_method = "05930F26D8EA77E9D23F45CCAA386679", hash_generated_method = "3A0ED639E94F7EDC310BC69CD4F115C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void contentScrollTo(int x, int y, boolean animate,
            boolean onlyIfImeIsShowing) {
        dsTaint.addTaint(animate);
        dsTaint.addTaint(onlyIfImeIsShowing);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        {
            boolean varCD3A04F2DD4738ECCC7EC3F7D2EDDDFC_1976933122 = (!mBrowserFrame.firstLayoutDone());
        } //End collapsed parenthetic
        {
            Message msg;
            msg = Message.obtain(mWebView.mPrivateHandler,
                    WebView.SCROLL_TO_MSG_ID, animate ? 1 : 0,
                    onlyIfImeIsShowing ? 1 : 0, new Point(x, y));//DSFIXME:  CODE0008: Nested ternary operator in expression
            {
                mEventHub.sendMessage(Message.obtain(null,
                        EventHub.MESSAGE_RELAY, msg));
            } //End block
            {
                msg.sendToTarget();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (!mBrowserFrame.firstLayoutDone()) {
            //mRestoredX = x;
            //mRestoredY = y;
            //return;
        //}
        //if (mWebView != null) {
            //Message msg = Message.obtain(mWebView.mPrivateHandler,
                    //WebView.SCROLL_TO_MSG_ID, animate ? 1 : 0,
                    //onlyIfImeIsShowing ? 1 : 0, new Point(x, y));
            //if (mDrawIsScheduled) {
                //mEventHub.sendMessage(Message.obtain(null,
                        //EventHub.MESSAGE_RELAY, msg));
            //} else {
                //msg.sendToTarget();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.196 -0400", hash_original_method = "064E6EE33123304FAB79F7D8FF122B00", hash_generated_method = "6931F321B06992A2D903F4DE3AFD42FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sendNotifyProgressFinished() {
        sendUpdateTextEntry();
        {
            boolean var0C0A67311072ACF9A11F251AEC847BBE_1277277824 = (!JniUtil.useChromiumHttpStack());
            {
                WebViewWorker.getHandler().removeMessages(
                    WebViewWorker.MSG_CACHE_TRANSACTION_TICKER);
                WebViewWorker.getHandler().sendEmptyMessage(
                    WebViewWorker.MSG_CACHE_TRANSACTION_TICKER);
            } //End block
        } //End collapsed parenthetic
        contentDraw();
        // ---------- Original Method ----------
        //sendUpdateTextEntry();
        //if (!JniUtil.useChromiumHttpStack()) {
            //WebViewWorker.getHandler().removeMessages(
                    //WebViewWorker.MSG_CACHE_TRANSACTION_TICKER);
            //WebViewWorker.getHandler().sendEmptyMessage(
                    //WebViewWorker.MSG_CACHE_TRANSACTION_TICKER);
        //}
        //contentDraw();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.196 -0400", hash_original_method = "05A7A351E8C6AEA76F720C36B865E14E", hash_generated_method = "7DDC786F25583832F8968855D401BAA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sendViewInvalidate(int left, int top, int right, int bottom) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        {
            Message.obtain(mWebView.mPrivateHandler,
                           WebView.INVAL_RECT_MSG_ID,
                           new Rect(left, top, right, bottom)).sendToTarget();
        } //End block
        // ---------- Original Method ----------
        //if (mWebView != null) {
            //Message.obtain(mWebView.mPrivateHandler,
                           //WebView.INVAL_RECT_MSG_ID,
                           //new Rect(left, top, right, bottom)).sendToTarget();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.197 -0400", hash_original_method = "BF48D6F46DE128F968473CE7B0F81CDD", hash_generated_method = "3BC68C12777C31B302D2AC712929E186")
    @DSModeled(DSC.SAFE)
     void signalRepaintDone() {
        mRepaintScheduled = false;
        // ---------- Original Method ----------
        //mRepaintScheduled = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.197 -0400", hash_original_method = "D61E1D458239E8CEF9B36F4B5C04FED9", hash_generated_method = "7FFA6514EDCAA08F4BAA371C1E2D501F")
    @DSModeled(DSC.SAFE)
     WebView getWebView() {
        return (WebView)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mWebView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.197 -0400", hash_original_method = "C2675483324447340D13F3ECB1B2D597", hash_generated_method = "A544BAF547AB24CC48D69ED497DB507A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setViewportSettingsFromNative() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.197 -0400", hash_original_method = "7A9CDB44172FF868DD9DADCEEAD05D82", hash_generated_method = "4383A139EDF2DE400B151B2F0D8AB02F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void didFirstLayout(boolean standardLoad) {
        dsTaint.addTaint(standardLoad);
        mBrowserFrame.didFirstLayout();
        boolean updateViewState;
        updateViewState = standardLoad || mIsRestored;
        setupViewport(updateViewState);
        {
            mWebView.mViewManager.postReadyToDrawAll();
        } //End block
        {
            boolean varF62A4D41575FA673A4E6CD9E1EF24EDD_823917478 = (WebView.USE_WEBKIT_RINGS || getSettings().supportTouchOnly());
            {
                mWebView.mPrivateHandler.sendEmptyMessage(
                    WebView.SET_TOUCH_HIGHLIGHT_RECTS);
            } //End block
        } //End collapsed parenthetic
        mRestoredX = mRestoredY = 0;
        mIsRestored = false;
        mRestoredScale = mRestoredTextWrapScale = 0;
        // ---------- Original Method ----------
        //if (DebugFlags.WEB_VIEW_CORE) {
            //Log.v(LOGTAG, "didFirstLayout standardLoad =" + standardLoad);
        //}
        //mBrowserFrame.didFirstLayout();
        //if (mWebView == null) return;
        //boolean updateViewState = standardLoad || mIsRestored;
        //setupViewport(updateViewState);
        //if (!updateViewState) {
            //mWebView.mViewManager.postReadyToDrawAll();
        //}
        //if (WebView.USE_WEBKIT_RINGS || getSettings().supportTouchOnly()) {
            //mWebView.mPrivateHandler.sendEmptyMessage(
                    //WebView.SET_TOUCH_HIGHLIGHT_RECTS);
        //}
        //mRestoredX = mRestoredY = 0;
        //mIsRestored = false;
        //mRestoredScale = mRestoredTextWrapScale = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.197 -0400", hash_original_method = "A32352A77D85042345402A4E856F6371", hash_generated_method = "1068B405466FDB182CCA070760A4D34B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateViewport() {
        setupViewport(true);
        // ---------- Original Method ----------
        //setupViewport(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.200 -0400", hash_original_method = "D5D0316515645CA1EE6304290B6F23F6", hash_generated_method = "19248DA2956460D3B232ABC96BE487FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setupViewport(boolean updateViewState) {
        dsTaint.addTaint(updateViewState);
        setViewportSettingsFromNative();
        {
            {
                mViewportInitialScale = Math.max(mViewportInitialScale,
                        mViewportMinimumScale);
            } //End block
            {
                mViewportInitialScale = Math.min(mViewportInitialScale,
                        mViewportMaximumScale);
            } //End block
        } //End block
        {
            boolean var2C40C72ED9495C662481F10E1A7BC080_1091020546 = (mSettings.forceUserScalable());
            {
                mViewportUserScalable = true;
                {
                    {
                        mViewportMinimumScale = Math.min(mViewportMinimumScale,
                            mViewportInitialScale / 2);
                    } //End block
                    {
                        mViewportMaximumScale = Math.max(mViewportMaximumScale,
                            mViewportInitialScale * 2);
                    } //End block
                } //End block
                {
                    {
                        mViewportMinimumScale = Math.min(mViewportMinimumScale, 50);
                    } //End block
                    {
                        mViewportMaximumScale = Math.max(mViewportMaximumScale, 200);
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        float adjust;
        adjust = 1.0f;
        {
            {
                boolean var095106DB1305D8C0DF73B5AC45213B00_191430790 = (mWebView != null && (int)(mWebView.getDefaultZoomScale() * 100) != 100);
                {
                    adjust = mWebView.getDefaultZoomScale();
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            adjust = (float) mContext.getResources().getDisplayMetrics().densityDpi
                    / mViewportDensityDpi;
        } //End block
        {
            boolean varAA9F420BC13982494ED8D1FAB46D4380_840229774 = (adjust != mWebView.getDefaultZoomScale());
            {
                Message.obtain(mWebView.mPrivateHandler,
                    WebView.UPDATE_ZOOM_DENSITY, adjust).sendToTarget();
            } //End block
        } //End collapsed parenthetic
        int defaultScale;
        defaultScale = (int) (adjust * 100);
        {
            mViewportInitialScale *= adjust;
        } //End block
        {
            mViewportMinimumScale *= adjust;
        } //End block
        {
            mViewportMaximumScale *= adjust;
        } //End block
        {
            {
                mViewportInitialScale = defaultScale;
            } //End block
        } //End block
        {
            mViewportInitialScale = defaultScale;
            mViewportMinimumScale = defaultScale;
            mViewportMaximumScale = defaultScale;
        } //End block
        {
            mViewportMinimumScale = mViewportInitialScale;
        } //End block
        {
            mViewportMaximumScale = mViewportInitialScale;
        } //End block
        {
            mViewportWidth = 0;
        } //End block
        {
            mFirstLayoutForNonStandardLoad = true;
            ViewState viewState;
            viewState = new ViewState();
            viewState.mMinScale = mViewportMinimumScale / 100.0f;
            viewState.mMaxScale = mViewportMaximumScale / 100.0f;
            viewState.mDefaultScale = adjust;
            viewState.mMobileSite = false;
            viewState.mScrollX = 0;
            viewState.mShouldStartScrolledRight = false;
            Message.obtain(mWebView.mPrivateHandler,
                    WebView.UPDATE_ZOOM_RANGE, viewState).sendToTarget();
        } //End block
        int webViewWidth;
        int viewportWidth;
        viewportWidth = mCurrentViewWidth;
        {
            webViewWidth = mWebView.getViewWidth();
            viewportWidth = (int) (webViewWidth / adjust);
        } //End block
        {
            webViewWidth = Math.round(viewportWidth * mCurrentViewScale);
        } //End block
        mInitialViewState = new ViewState();
        mInitialViewState.mMinScale = mViewportMinimumScale / 100.0f;
        mInitialViewState.mMaxScale = mViewportMaximumScale / 100.0f;
        mInitialViewState.mDefaultScale = adjust;
        mInitialViewState.mScrollX = mRestoredX;
        mInitialViewState.mScrollY = mRestoredY;
        mInitialViewState.mShouldStartScrolledRight = (mRestoredX == 0)
                && (mRestoredY == 0)
                && (mBrowserFrame != null)
                && mBrowserFrame.getShouldStartScrolledRight();
        mInitialViewState.mMobileSite = (0 == mViewportWidth);
        {
            mInitialViewState.mIsRestored = true;
            mInitialViewState.mViewScale = mRestoredScale;
            {
                mInitialViewState.mTextWrapScale = mRestoredTextWrapScale;
            } //End block
            {
                mInitialViewState.mTextWrapScale = mInitialViewState.mViewScale;
            } //End block
        } //End block
        {
            {
                mInitialViewState.mViewScale = mInitialViewState.mTextWrapScale =
                        mViewportInitialScale / 100.0f;
            } //End block
            {
                boolean varDEB9F10F1388468BDE78E7CEBFF00566_1591070470 = (mViewportWidth > 0 && mViewportWidth < webViewWidth &&
                !getSettings().getUseFixedViewport());
                {
                    mInitialViewState.mViewScale = mInitialViewState.mTextWrapScale =
                        (float) webViewWidth / mViewportWidth;
                } //End block
                {
                    mInitialViewState.mTextWrapScale = adjust;
                    {
                        boolean varA6856BD93D50A87AC1D99B72D3E49073_1353557213 = (mSettings.getUseWideViewPort());
                        {
                            mInitialViewState.mViewScale = 0;
                        } //End block
                        {
                            mInitialViewState.mViewScale = adjust;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            mWebView.mLastHeightSent = 0;
            WebView.ViewSizeData data;
            data = new WebView.ViewSizeData();
            data.mWidth = mWebView.mLastWidthSent;
            data.mHeight = 0;
            data.mTextWrapWidth = data.mWidth;
            data.mScale = -1.0f;
            data.mIgnoreHeight = false;
            data.mAnchorX = data.mAnchorY = 0;
            mEventHub.removeMessages(EventHub.VIEW_SIZE_CHANGED);
            mEventHub.sendMessageAtFrontOfQueue(Message.obtain(null,
                    EventHub.VIEW_SIZE_CHANGED, data));
        } //End block
        {
            {
                mWebView.mLastWidthSent = 0;
            } //End block
            {
                WebView.ViewSizeData data;
                data = new WebView.ViewSizeData();
                float tentativeScale;
                tentativeScale = mInitialViewState.mViewScale;
                {
                    tentativeScale = mInitialViewState.mTextWrapScale;
                    int tentativeViewWidth;
                    tentativeViewWidth = Math.round(webViewWidth / tentativeScale);
                    int windowWidth;
                    windowWidth = calculateWindowWidth(tentativeViewWidth);
                    data.mScale = (float) webViewWidth / windowWidth;
                    {
                        boolean var702626CF71171EB0C8490DD1835B6456_1161007245 = (!mSettings.getLoadWithOverviewMode());
                        {
                            data.mScale = Math.max(data.mScale, tentativeScale);
                        } //End block
                    } //End collapsed parenthetic
                    {
                        boolean var4472321233F900C5CC1F3910B5372E99_1340850349 = (mSettings.isNarrowColumnLayout());
                        {
                            mInitialViewState.mTextWrapScale =
                                mWebView.getReadingLevelScale();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    data.mScale = tentativeScale;
                } //End block
                data.mWidth = Math.round(webViewWidth / data.mScale);
                data.mHeight = mCurrentViewHeight == 0 ?
                        Math.round(mWebView.getViewHeight() / data.mScale)
                        : Math.round((float) mCurrentViewHeight * data.mWidth / viewportWidth);
                data.mTextWrapWidth = Math.round(webViewWidth
                        / mInitialViewState.mTextWrapScale);
                data.mIgnoreHeight = false;
                data.mAnchorX = data.mAnchorY = 0;
                mEventHub.removeMessages(EventHub.VIEW_SIZE_CHANGED);
                viewSizeChanged(data);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.200 -0400", hash_original_method = "6F3A82A96A28D1D6CB79A2B2419B2F76", hash_generated_method = "D76E40462E8E983227570ABDE237834F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void restoreScale(float scale, float textWrapScale) {
        dsTaint.addTaint(scale);
        dsTaint.addTaint(textWrapScale);
        {
            boolean varD35BFC1537D634CBB5B2C1FDA9291321_13244833 = (mBrowserFrame.firstLayoutDone() == false);
            {
                mIsRestored = true;
                {
                    boolean var4BFA491A55D7EADB3D22EDD12F06D767_771257257 = (mSettings.getUseWideViewPort());
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mBrowserFrame.firstLayoutDone() == false) {
            //mIsRestored = true;
            //mRestoredScale = scale;
            //if (mSettings.getUseWideViewPort()) {
                //mRestoredTextWrapScale = textWrapScale;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.201 -0400", hash_original_method = "F9FDE50E9F3FDE0981BF3551CCB9A219", hash_generated_method = "9AA72779DA059D205E04AB0ED0DE582E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void needTouchEvents(boolean need) {
        dsTaint.addTaint(need);
        {
            Message.obtain(mWebView.mPrivateHandler,
                    WebView.WEBCORE_NEED_TOUCH_EVENTS, need ? 1 : 0, 0)
                    .sendToTarget();
        } //End block
        // ---------- Original Method ----------
        //if (mWebView != null) {
            //Message.obtain(mWebView.mPrivateHandler,
                    //WebView.WEBCORE_NEED_TOUCH_EVENTS, need ? 1 : 0, 0)
                    //.sendToTarget();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.201 -0400", hash_original_method = "117690D9297C0397B62CA4A9AAF175F7", hash_generated_method = "083E60A1DAC9648BE49BEDE0B632B5DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateTextfield(int ptr, boolean changeToPassword,
            String text, int textGeneration) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(textGeneration);
        dsTaint.addTaint(changeToPassword);
        dsTaint.addTaint(ptr);
        {
            Message msg;
            msg = Message.obtain(mWebView.mPrivateHandler,
                    WebView.UPDATE_TEXTFIELD_TEXT_MSG_ID, ptr,
                    textGeneration, text);
            msg.getData().putBoolean("password", changeToPassword);
            msg.sendToTarget();
        } //End block
        // ---------- Original Method ----------
        //if (mWebView != null) {
            //Message msg = Message.obtain(mWebView.mPrivateHandler,
                    //WebView.UPDATE_TEXTFIELD_TEXT_MSG_ID, ptr,
                    //textGeneration, text);
            //msg.getData().putBoolean("password", changeToPassword);
            //msg.sendToTarget();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.201 -0400", hash_original_method = "4C7D3AD0862D2CA84FE64B9856BAA28B", hash_generated_method = "7A2B3DFC9FCDFA753860977D93C6E2D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateTextSelection(int pointer, int start, int end,
            int textGeneration) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(pointer);
        dsTaint.addTaint(textGeneration);
        dsTaint.addTaint(end);
        {
            Message.obtain(mWebView.mPrivateHandler,
                WebView.UPDATE_TEXT_SELECTION_MSG_ID, pointer, textGeneration,
                new TextSelectionData(start, end)).sendToTarget();
        } //End block
        // ---------- Original Method ----------
        //if (mWebView != null) {
            //Message.obtain(mWebView.mPrivateHandler,
                //WebView.UPDATE_TEXT_SELECTION_MSG_ID, pointer, textGeneration,
                //new TextSelectionData(start, end)).sendToTarget();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.201 -0400", hash_original_method = "C4BB5E4EA56AD7707D8515F7F4BEC247", hash_generated_method = "6D3322017AAF9488D423867036C5988F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void clearTextEntry() {
        Message.obtain(mWebView.mPrivateHandler,
                WebView.CLEAR_TEXT_ENTRY).sendToTarget();
        // ---------- Original Method ----------
        //if (mWebView == null) return;
        //Message.obtain(mWebView.mPrivateHandler,
                //WebView.CLEAR_TEXT_ENTRY).sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.201 -0400", hash_original_method = "862481A256A95A2E1B26E19ED8AB682F", hash_generated_method = "8FA3E94989B7908AC2EFBFFCF957D5BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sendFindAgain() {
        Message.obtain(mWebView.mPrivateHandler,
                WebView.FIND_AGAIN).sendToTarget();
        // ---------- Original Method ----------
        //if (mWebView == null) return;
        //Message.obtain(mWebView.mPrivateHandler,
                //WebView.FIND_AGAIN).sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.202 -0400", hash_original_method = "1F73AE1CA1E2566920108C9D357DD01C", hash_generated_method = "811F89392751DB56E9E28BDF266564E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeUpdateFrameCacheIfLoading() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.202 -0400", hash_original_method = "F955ECFDACE0CC28D366B33E5FEC0536", hash_generated_method = "A821BAA64C8E20BCC154BA5A5E1AC6C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeRevealSelection() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.202 -0400", hash_original_method = "D72E3E2D187EE0995228637414D15F8B", hash_generated_method = "7501F363AC53343B364B251E22AD5FB7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String nativeRequestLabel(int framePtr, int nodePtr) {
        dsTaint.addTaint(nodePtr);
        dsTaint.addTaint(framePtr);
        return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.202 -0400", hash_original_method = "CDA0A8C6D295040926E78ABE78DD6146", hash_generated_method = "AF659983722591F5A9027CE114C3C459")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeScrollFocusedTextInput(float xPercent, int y) {
        dsTaint.addTaint(xPercent);
        dsTaint.addTaint(y);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.202 -0400", hash_original_method = "E13D9D9BB267DB78AE29574F59D715C7", hash_generated_method = "B72D1A25EF450AB9538B2E6FB9908665")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeSetScrollOffset(int gen, boolean sendScrollEvent, int dx, int dy) {
        dsTaint.addTaint(gen);
        dsTaint.addTaint(dx);
        dsTaint.addTaint(dy);
        dsTaint.addTaint(sendScrollEvent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.202 -0400", hash_original_method = "1D56EADE7E65827B4B9A4C6FC3F7D192", hash_generated_method = "C03A565F45A738F0526C7640FB44E930")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeSetGlobalBounds(int x, int y, int w, int h) {
        dsTaint.addTaint(w);
        dsTaint.addTaint(h);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.202 -0400", hash_original_method = "AECCF0A7E8C40F57D58CA373D809DB0E", hash_generated_method = "52CD075B0B4B905AF243940DCCCA0233")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void requestListBox(String[] array, int[] enabledArray,
            int[] selectedArray) {
        dsTaint.addTaint(selectedArray[0]);
        dsTaint.addTaint(enabledArray[0]);
        dsTaint.addTaint(array[0]);
        {
            mWebView.requestListBox(array, enabledArray, selectedArray);
        } //End block
        // ---------- Original Method ----------
        //if (mWebView != null) {
            //mWebView.requestListBox(array, enabledArray, selectedArray);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.203 -0400", hash_original_method = "9DBC344B8D87A71D6BD3CB15F0701F64", hash_generated_method = "8508EADF8D26DDD76306B59C9F3322C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void requestListBox(String[] array, int[] enabledArray,
            int selection) {
        dsTaint.addTaint(enabledArray[0]);
        dsTaint.addTaint(selection);
        dsTaint.addTaint(array[0]);
        {
            mWebView.requestListBox(array, enabledArray, selection);
        } //End block
        // ---------- Original Method ----------
        //if (mWebView != null) {
            //mWebView.requestListBox(array, enabledArray, selection);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.203 -0400", hash_original_method = "2EB26549510C49A5C07788F5DA665EE0", hash_generated_method = "59667A50A68B7457C0B227F4AD082DA3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void requestKeyboardWithSelection(int pointer, int selStart,
            int selEnd, int textGeneration) {
        dsTaint.addTaint(selStart);
        dsTaint.addTaint(pointer);
        dsTaint.addTaint(selEnd);
        dsTaint.addTaint(textGeneration);
        {
            Message.obtain(mWebView.mPrivateHandler,
                    WebView.REQUEST_KEYBOARD_WITH_SELECTION_MSG_ID, pointer,
                    textGeneration, new TextSelectionData(selStart, selEnd))
                    .sendToTarget();
        } //End block
        // ---------- Original Method ----------
        //if (mWebView != null) {
            //Message.obtain(mWebView.mPrivateHandler,
                    //WebView.REQUEST_KEYBOARD_WITH_SELECTION_MSG_ID, pointer,
                    //textGeneration, new TextSelectionData(selStart, selEnd))
                    //.sendToTarget();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.203 -0400", hash_original_method = "C7739CA97531242F19EB30C6F079B5B2", hash_generated_method = "7466A06A8125646EA6E6CA7FECB27C20")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void requestKeyboard(boolean showKeyboard) {
        dsTaint.addTaint(showKeyboard);
        {
            Message.obtain(mWebView.mPrivateHandler,
                    WebView.REQUEST_KEYBOARD, showKeyboard ? 1 : 0, 0)
                    .sendToTarget();
        } //End block
        // ---------- Original Method ----------
        //if (mWebView != null) {
            //Message.obtain(mWebView.mPrivateHandler,
                    //WebView.REQUEST_KEYBOARD, showKeyboard ? 1 : 0, 0)
                    //.sendToTarget();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.203 -0400", hash_original_method = "DC8BC22A6F75F1D5B407274C2907FB6A", hash_generated_method = "D6BC5F274D0AA649E219E528A017888E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setWebTextViewAutoFillable(int queryId, String preview) {
        dsTaint.addTaint(preview);
        dsTaint.addTaint(queryId);
        {
            Message.obtain(mWebView.mPrivateHandler, WebView.SET_AUTOFILLABLE,
                    new AutoFillData(queryId, preview))
                    .sendToTarget();
        } //End block
        // ---------- Original Method ----------
        //if (mWebView != null) {
            //Message.obtain(mWebView.mPrivateHandler, WebView.SET_AUTOFILLABLE,
                    //new AutoFillData(queryId, preview))
                    //.sendToTarget();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.203 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "B0B2DDBEB77BA94D0A4C33C64B71FA82")
    @DSModeled(DSC.SAFE)
     Context getContext() {
        return (Context)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.204 -0400", hash_original_method = "06D3F71D264B84B5441A889608149189", hash_generated_method = "3CD0C88466CC72F61A8F438CAD1F56F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void keepScreenOn(boolean screenOn) {
        dsTaint.addTaint(screenOn);
        {
            Message message;
            message = mWebView.mPrivateHandler.obtainMessage(WebView.SCREEN_ON);
            message.arg1 = screenOn ? 1 : 0;
            message.sendToTarget();
        } //End block
        // ---------- Original Method ----------
        //if (mWebView != null) {
            //Message message = mWebView.mPrivateHandler.obtainMessage(WebView.SCREEN_ON);
            //message.arg1 = screenOn ? 1 : 0;
            //message.sendToTarget();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.204 -0400", hash_original_method = "10FFBA7C056FD6BA9A1C610F1A172C8D", hash_generated_method = "47831AECAB5B027D039D130BE8C5021C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Class<?> getPluginClass(String libName, String clsName) {
        dsTaint.addTaint(libName);
        dsTaint.addTaint(clsName);
        PluginManager pluginManager;
        pluginManager = PluginManager.getInstance(null);
        String pkgName;
        pkgName = pluginManager.getPluginsAPKName(libName);
        try 
        {
            Class<?> varD149FD1E81F224B9AC4BF423CFCEA5D0_548374232 = (pluginManager.getPluginClass(pkgName, clsName));
        } //End block
        catch (NameNotFoundException e)
        { }
        catch (ClassNotFoundException e)
        { }
        return (Class<?>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mWebView == null) {
            //return null;
        //}
        //PluginManager pluginManager = PluginManager.getInstance(null);
        //String pkgName = pluginManager.getPluginsAPKName(libName);
        //if (pkgName == null) {
            //Log.w(LOGTAG, "Unable to resolve " + libName + " to a plugin APK");
            //return null;
        //}
        //try {
            //return pluginManager.getPluginClass(pkgName, clsName);
        //} catch (NameNotFoundException e) {
            //Log.e(LOGTAG, "Unable to find plugin classloader for the apk (" + pkgName + ")");
        //} catch (ClassNotFoundException e) {
            //Log.e(LOGTAG, "Unable to find plugin class (" + clsName +
                    //") in the apk (" + pkgName + ")");
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.204 -0400", hash_original_method = "56D58B33C48E10C4B09153457527EDE8", hash_generated_method = "1762913C0C63115121067D37FF2BA858")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void showFullScreenPlugin(ViewManager.ChildView childView, int orientation, int npp) {
        dsTaint.addTaint(orientation);
        dsTaint.addTaint(childView.dsTaint);
        dsTaint.addTaint(npp);
        Message message;
        message = mWebView.mPrivateHandler.obtainMessage(WebView.SHOW_FULLSCREEN);
        message.obj = childView.mView;
        message.arg1 = orientation;
        message.arg2 = npp;
        message.sendToTarget();
        // ---------- Original Method ----------
        //if (mWebView == null) {
            //return;
        //}
        //Message message = mWebView.mPrivateHandler.obtainMessage(WebView.SHOW_FULLSCREEN);
        //message.obj = childView.mView;
        //message.arg1 = orientation;
        //message.arg2 = npp;
        //message.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.205 -0400", hash_original_method = "98BEE7CF6CD4E23C3FBAA61970F9B21C", hash_generated_method = "17095E7CD399502293E2AFE11736CEEB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void hideFullScreenPlugin() {
        mWebView.mPrivateHandler.obtainMessage(WebView.HIDE_FULLSCREEN)
                .sendToTarget();
        // ---------- Original Method ----------
        //if (mWebView == null) {
            //return;
        //}
        //mWebView.mPrivateHandler.obtainMessage(WebView.HIDE_FULLSCREEN)
                //.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.205 -0400", hash_original_method = "A3E933C7DAB8D83D100D1E88122325C7", hash_generated_method = "7CE2BDAB44E7DF77D71B41EDEF0A3B41")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ViewManager.ChildView createSurface(View pluginView) {
        dsTaint.addTaint(pluginView.dsTaint);
        pluginView.setWillNotDraw(false);
        ((SurfaceView)pluginView).setZOrderOnTop(true);
        ViewManager.ChildView view;
        view = mWebView.mViewManager.createView();
        view.mView = pluginView;
        return (ViewManager.ChildView)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mWebView == null) {
            //return null;
        //}
        //if (pluginView == null) {
            //Log.e(LOGTAG, "Attempted to add an empty plugin view to the view hierarchy");
            //return null;
        //}
        //pluginView.setWillNotDraw(false);
        //if(pluginView instanceof SurfaceView)
            //((SurfaceView)pluginView).setZOrderOnTop(true);
        //ViewManager.ChildView view = mWebView.mViewManager.createView();
        //view.mView = pluginView;
        //return view;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.205 -0400", hash_original_method = "97AE1F230CE0C97985778B5B23111878", hash_generated_method = "7D81D3E1583C853348A75A17FDFEEEBC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ViewManager.ChildView addSurface(View pluginView, int x, int y,
                                             int width, int height) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        dsTaint.addTaint(pluginView.dsTaint);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        ViewManager.ChildView view;
        view = createSurface(pluginView);
        view.attachView(x, y, width, height);
        return (ViewManager.ChildView)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ViewManager.ChildView view = createSurface(pluginView);
        //view.attachView(x, y, width, height);
        //return view;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.205 -0400", hash_original_method = "75F4F4C2028D65C3C8554ED4635C74ED", hash_generated_method = "67F88891E4F970A5CA43AFFA5525CCAA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateSurface(ViewManager.ChildView childView, int x, int y,
            int width, int height) {
        dsTaint.addTaint(childView.dsTaint);
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        childView.attachView(x, y, width, height);
        // ---------- Original Method ----------
        //childView.attachView(x, y, width, height);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.206 -0400", hash_original_method = "416DFEE1629652841DDA085C9B0D0611", hash_generated_method = "0BA83B3A56F73F2C70036499F8B4BA6A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void destroySurface(ViewManager.ChildView childView) {
        dsTaint.addTaint(childView.dsTaint);
        childView.removeView();
        // ---------- Original Method ----------
        //childView.removeView();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.206 -0400", hash_original_method = "22185D2849BB84C82B1605DF19FAA2EB", hash_generated_method = "E50CBDB30714C6820375BA30FA1EEFFE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void showRect(int left, int top, int width, int height,
            int contentWidth, int contentHeight, float xPercentInDoc,
            float xPercentInView, float yPercentInDoc, float yPercentInView) {
        dsTaint.addTaint(contentHeight);
        dsTaint.addTaint(xPercentInDoc);
        dsTaint.addTaint(height);
        dsTaint.addTaint(xPercentInView);
        dsTaint.addTaint(width);
        dsTaint.addTaint(yPercentInDoc);
        dsTaint.addTaint(left);
        dsTaint.addTaint(yPercentInView);
        dsTaint.addTaint(contentWidth);
        dsTaint.addTaint(top);
        {
            ShowRectData data;
            data = new ShowRectData();
            data.mLeft = left;
            data.mTop = top;
            data.mWidth = width;
            data.mHeight = height;
            data.mContentWidth = contentWidth;
            data.mContentHeight = contentHeight;
            data.mXPercentInDoc = xPercentInDoc;
            data.mXPercentInView = xPercentInView;
            data.mYPercentInDoc = yPercentInDoc;
            data.mYPercentInView = yPercentInView;
            Message.obtain(mWebView.mPrivateHandler, WebView.SHOW_RECT_MSG_ID,
                    data).sendToTarget();
        } //End block
        // ---------- Original Method ----------
        //if (mWebView != null) {
            //ShowRectData data = new ShowRectData();
            //data.mLeft = left;
            //data.mTop = top;
            //data.mWidth = width;
            //data.mHeight = height;
            //data.mContentWidth = contentWidth;
            //data.mContentHeight = contentHeight;
            //data.mXPercentInDoc = xPercentInDoc;
            //data.mXPercentInView = xPercentInView;
            //data.mYPercentInDoc = yPercentInDoc;
            //data.mYPercentInView = yPercentInView;
            //Message.obtain(mWebView.mPrivateHandler, WebView.SHOW_RECT_MSG_ID,
                    //data).sendToTarget();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.206 -0400", hash_original_method = "1DA5EF32A9FA7AF08D14A38F102400D4", hash_generated_method = "DBFD2065477DA9E2A71A0E2C78CAE973")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void centerFitRect(int x, int y, int width, int height) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        mWebView.mPrivateHandler.obtainMessage(WebView.CENTER_FIT_RECT,
                new Rect(x, y, x + width, y + height)).sendToTarget();
        // ---------- Original Method ----------
        //if (mWebView == null) {
            //return;
        //}
        //mWebView.mPrivateHandler.obtainMessage(WebView.CENTER_FIT_RECT,
                //new Rect(x, y, x + width, y + height)).sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.206 -0400", hash_original_method = "D8FA837CEB894605C45672F0DC41EFFC", hash_generated_method = "7C9F5487D39B618F5C62A4CEB98FD0D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setScrollbarModes(int hMode, int vMode) {
        dsTaint.addTaint(hMode);
        dsTaint.addTaint(vMode);
        mWebView.mPrivateHandler.obtainMessage(WebView.SET_SCROLLBAR_MODES,
                hMode, vMode).sendToTarget();
        // ---------- Original Method ----------
        //if (mWebView == null) {
            //return;
        //}
        //mWebView.mPrivateHandler.obtainMessage(WebView.SET_SCROLLBAR_MODES,
                //hMode, vMode).sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.207 -0400", hash_original_method = "07DD7AFD4B9B08AAE72EF7B16777A3F8", hash_generated_method = "CCF7205A47061FFDA4EFE66D0DDD1C67")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unused")
    private void selectAt(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        {
            mWebView.mPrivateHandler.obtainMessage(WebView.SELECT_AT, x, y).sendToTarget();
        } //End block
        // ---------- Original Method ----------
        //if (mWebView != null) {
            //mWebView.mPrivateHandler.obtainMessage(WebView.SELECT_AT, x, y).sendToTarget();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.207 -0400", hash_original_method = "6A70D904110AF22683C1DB763A75BE10", hash_generated_method = "A305859D91500836C604DC6AC8AB2802")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void useMockDeviceOrientation() {
        mDeviceMotionAndOrientationManager.useMock();
        // ---------- Original Method ----------
        //mDeviceMotionAndOrientationManager.useMock();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.207 -0400", hash_original_method = "F3DDD41A8D23B4AE9E9585A561AEE4C2", hash_generated_method = "0512C1B93F5CC7A4DC96590A6EC4DA89")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMockDeviceOrientation(boolean canProvideAlpha, double alpha,
            boolean canProvideBeta, double beta, boolean canProvideGamma, double gamma) {
        dsTaint.addTaint(gamma);
        dsTaint.addTaint(canProvideGamma);
        dsTaint.addTaint(canProvideBeta);
        dsTaint.addTaint(alpha);
        dsTaint.addTaint(beta);
        dsTaint.addTaint(canProvideAlpha);
        mDeviceMotionAndOrientationManager.setMockOrientation(canProvideAlpha, alpha,
                canProvideBeta, beta, canProvideGamma, gamma);
        // ---------- Original Method ----------
        //mDeviceMotionAndOrientationManager.setMockOrientation(canProvideAlpha, alpha,
                //canProvideBeta, beta, canProvideGamma, gamma);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.207 -0400", hash_original_method = "2C35CA4A669368B8EA54C6F975558D19", hash_generated_method = "B346175AFAD00FD7B2C804A86698CAA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected DeviceMotionService getDeviceMotionService() {
        {
            mDeviceMotionService =
                    new DeviceMotionService(mDeviceMotionAndOrientationManager, mContext);
        } //End block
        return (DeviceMotionService)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mDeviceMotionService == null) {
            //mDeviceMotionService =
                    //new DeviceMotionService(mDeviceMotionAndOrientationManager, mContext);
        //}
        //return mDeviceMotionService;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.207 -0400", hash_original_method = "C07B296E9A86FE4EA87FDBAE8692F74E", hash_generated_method = "113AD49CC0288256BE6CD2845E318C64")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected DeviceOrientationService getDeviceOrientationService() {
        {
            mDeviceOrientationService =
                    new DeviceOrientationService(mDeviceMotionAndOrientationManager, mContext);
        } //End block
        return (DeviceOrientationService)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mDeviceOrientationService == null) {
            //mDeviceOrientationService =
                    //new DeviceOrientationService(mDeviceMotionAndOrientationManager, mContext);
        //}
        //return mDeviceOrientationService;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.208 -0400", hash_original_method = "80A2D6FB8A6209AB3E75A13699D0F2FD", hash_generated_method = "962AC863F21EC72A3F4C4E3D3223C36D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeSetIsPaused(boolean isPaused) {
        dsTaint.addTaint(isPaused);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.208 -0400", hash_original_method = "F7A6503DE7A4FD810E8E9ABDA2EEEB51", hash_generated_method = "CFD63F9A966562DF83D39FABD638C104")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativePause() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.208 -0400", hash_original_method = "5AFDAE76FDF49AA60F1B62133763C925", hash_generated_method = "A9F70FC0A49853DDC2A0592633A31EDB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeResume() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.208 -0400", hash_original_method = "46A442C7F1DFFCFE217C12A7C725FDF0", hash_generated_method = "5E0228F659C8CEAE7B4ED00D196CB7E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeFreeMemory() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.208 -0400", hash_original_method = "595EFBC436CD527B994A288C2556204C", hash_generated_method = "53EB07D01C5759DC344DB84DC7012FD9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeFullScreenPluginHidden(int npp) {
        dsTaint.addTaint(npp);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.208 -0400", hash_original_method = "B8577828D04FDB03A48BAD0D20ECEC58", hash_generated_method = "1D9DA186F7D377C5866D2185EAB12428")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativePluginSurfaceReady() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.208 -0400", hash_original_method = "47AF89A6298D2CD312EEA7CB7B014D43", hash_generated_method = "DB2C44C3BFE94AD49D54CBAAD728AA80")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean nativeValidNodeAndBounds(int frame, int node,
            Rect bounds) {
        dsTaint.addTaint(bounds.dsTaint);
        dsTaint.addTaint(node);
        dsTaint.addTaint(frame);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.209 -0400", hash_original_method = "7FB813C3814F61AA4E8EC557BEB4DCCC", hash_generated_method = "6D352AE212A5962B150007B35B719073")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ArrayList<Rect> nativeGetTouchHighlightRects(int x, int y,
            int slop) {
        dsTaint.addTaint(slop);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        return (ArrayList<Rect>)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.209 -0400", hash_original_method = "6E4751AAEDBCF283C9D69028D1EFBC56", hash_generated_method = "88132AAA580AF61A7218676CB941FA15")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeAutoFillForm(int queryId) {
        dsTaint.addTaint(queryId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.209 -0400", hash_original_method = "17FE9397F3DCB5CE24853C5F0983B585", hash_generated_method = "BB5DCB7213CF68B5778A330A553AF3A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeScrollLayer(int layer, Rect rect) {
        dsTaint.addTaint(layer);
        dsTaint.addTaint(rect.dsTaint);
    }

    
    private static class WebCoreThread implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.209 -0400", hash_original_method = "EEC23A6EA618A1B89C710438436DA3F1", hash_generated_method = "EEC23A6EA618A1B89C710438436DA3F1")
                public WebCoreThread ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.211 -0400", hash_original_method = "82DEF5A0DA884DCAB5C26C3D415DCFF4", hash_generated_method = "D88A14945C576F33632EA7F2A3AEABF2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            Looper.prepare();
            Assert.assertNull(sWebCoreHandler);
            {
                sWebCoreHandler = new Handler() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.211 -0400", hash_original_method = "C9135F359ACD716A893B99167F5F2188", hash_generated_method = "119BA8CBC2D5F9508F6ED587782276E3")
                    //DSFIXME:  CODE0002: Requires DSC value to be set
                    @Override
                    public void handleMessage(Message msg) {
                        dsTaint.addTaint(msg.dsTaint);
                        //Begin case INITIALIZE 
                        WebViewCore core;
                        core = (WebViewCore) msg.obj;
                        //End case INITIALIZE 
                        //Begin case INITIALIZE 
                        core.initialize();
                        //End case INITIALIZE 
                        //Begin case REDUCE_PRIORITY 
                        Process.setThreadPriority(
                                        Process.THREAD_PRIORITY_DEFAULT + 3 *
                                        Process.THREAD_PRIORITY_LESS_FAVORABLE);
                        //End case REDUCE_PRIORITY 
                        //Begin case RESUME_PRIORITY 
                        Process.setThreadPriority(
                                        Process.THREAD_PRIORITY_DEFAULT);
                        //End case RESUME_PRIORITY 
                        //Begin case EventHub.ADD_PACKAGE_NAME 
                        {
                            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                                            "No WebView has been created in this process!");
                        } //End block
                        //End case EventHub.ADD_PACKAGE_NAME 
                        //Begin case EventHub.ADD_PACKAGE_NAME 
                        BrowserFrame.sJavaBridge.addPackageName((String) msg.obj);
                        //End case EventHub.ADD_PACKAGE_NAME 
                        //Begin case EventHub.REMOVE_PACKAGE_NAME 
                        {
                            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                                            "No WebView has been created in this process!");
                        } //End block
                        //End case EventHub.REMOVE_PACKAGE_NAME 
                        //Begin case EventHub.REMOVE_PACKAGE_NAME 
                        BrowserFrame.sJavaBridge.removePackageName((String) msg.obj);
                        //End case EventHub.REMOVE_PACKAGE_NAME 
                        //Begin case EventHub.PROXY_CHANGED 
                        {
                            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                                            "No WebView has been created in this process!");
                        } //End block
                        //End case EventHub.PROXY_CHANGED 
                        //Begin case EventHub.PROXY_CHANGED 
                        BrowserFrame.sJavaBridge.updateProxy((ProxyProperties)msg.obj);
                        //End case EventHub.PROXY_CHANGED 
                        // ---------- Original Method ----------
                        // Original Method Too Long, Refer to Original Implementation
                    }
};
                WebViewCore.class.notify();
            } //End block
            Looper.loop();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        private static final int INITIALIZE = 0;
        private static final int REDUCE_PRIORITY = 1;
        private static final int RESUME_PRIORITY = 2;
    }


    
    static class BaseUrlData {
        String mBaseUrl;
        String mData;
        String mMimeType;
        String mEncoding;
        String mHistoryUrl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.212 -0400", hash_original_method = "0652EF8DB7A36B6DA0B1D995874F1EA4", hash_generated_method = "0652EF8DB7A36B6DA0B1D995874F1EA4")
                public BaseUrlData ()
        {
        }


    }


    
    static class CursorData {
        int mMoveGeneration;
        int mFrame;
        int mNode;
        int mX;
        int mY;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.213 -0400", hash_original_method = "CB52479A54028E5EA2D022FBED517AD0", hash_generated_method = "2AF2198D7D90862DF6B793FD22A2BE79")
        @DSModeled(DSC.SAFE)
         CursorData() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.213 -0400", hash_original_method = "6825641482AFD3BD8931BBB7542BDAEF", hash_generated_method = "0962DBE37B130C7CF8174294BE1895D9")
        @DSModeled(DSC.SAFE)
         CursorData(int frame, int node, int x, int y) {
            dsTaint.addTaint(node);
            dsTaint.addTaint(frame);
            dsTaint.addTaint(y);
            dsTaint.addTaint(x);
            // ---------- Original Method ----------
            //mFrame = frame;
            //mNode = node;
            //mX = x;
            //mY = y;
        }

        
    }


    
    static class JSInterfaceData {
        Object mObject;
        String mInterfaceName;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.213 -0400", hash_original_method = "14C6674CBE8FBF4544EAC31D0993AAD0", hash_generated_method = "14C6674CBE8FBF4544EAC31D0993AAD0")
                public JSInterfaceData ()
        {
        }


    }


    
    static class JSKeyData {
        String mCurrentText;
        KeyEvent mEvent;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.213 -0400", hash_original_method = "FE0BFB67A5C5E87A7355AB99B3371A25", hash_generated_method = "FE0BFB67A5C5E87A7355AB99B3371A25")
                public JSKeyData ()
        {
        }


    }


    
    static class MotionUpData {
        int mFrame;
        int mNode;
        Rect mBounds;
        int mX;
        int mY;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.213 -0400", hash_original_method = "D7CC35E3317ECE44C703EE6CCA0A2D5F", hash_generated_method = "D7CC35E3317ECE44C703EE6CCA0A2D5F")
                public MotionUpData ()
        {
        }


    }


    
    static class GetUrlData {
        String mUrl;
        Map<String, String> mExtraHeaders;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.213 -0400", hash_original_method = "0A4E7935988919BCE63C51B6F2E28704", hash_generated_method = "0A4E7935988919BCE63C51B6F2E28704")
                public GetUrlData ()
        {
        }


    }


    
    static class PostUrlData {
        String mUrl;
        byte[] mPostData;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.213 -0400", hash_original_method = "0CBDDE7594858DDB527DD5920FEDD78F", hash_generated_method = "0CBDDE7594858DDB527DD5920FEDD78F")
                public PostUrlData ()
        {
        }


    }


    
    static class ReplaceTextData {
        String mReplace;
        int mNewStart;
        int mNewEnd;
        int mTextGeneration;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.213 -0400", hash_original_method = "E41AC7A3AB2EBB6AE0294DD65104B673", hash_generated_method = "E41AC7A3AB2EBB6AE0294DD65104B673")
                public ReplaceTextData ()
        {
        }


    }


    
    static class TextSelectionData {
        int mStart;
        int mEnd;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.214 -0400", hash_original_method = "01ADB7A0134281E557F1A0D40D5248A7", hash_generated_method = "0447475A1A58E8627CDDC27A027A171B")
        @DSModeled(DSC.SAFE)
        public TextSelectionData(int start, int end) {
            dsTaint.addTaint(start);
            dsTaint.addTaint(end);
            // ---------- Original Method ----------
            //mStart = start;
            //mEnd = end;
        }

        
    }


    
    static class TouchUpData {
        int mMoveGeneration;
        int mFrame;
        int mNode;
        int mX;
        int mY;
        int mNativeLayer;
        Rect mNativeLayerRect = new Rect();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.214 -0400", hash_original_method = "4069C07A3045453DFA73B5C7E44C5FAC", hash_generated_method = "4069C07A3045453DFA73B5C7E44C5FAC")
                public TouchUpData ()
        {
        }


    }


    
    static class TouchHighlightData {
        int mX;
        int mY;
        int mSlop;
        int mNativeLayer;
        Rect mNativeLayerRect;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.214 -0400", hash_original_method = "198E2543A82FFA35DC0A9C3F6D063DEB", hash_generated_method = "198E2543A82FFA35DC0A9C3F6D063DEB")
                public TouchHighlightData ()
        {
        }


    }


    
    static class AutoFillData {
        private int mQueryId;
        private String mPreview;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.214 -0400", hash_original_method = "1D9359D80D7809D2772AFB2E4DAF56F3", hash_generated_method = "7A89C44F80C8B962A21270246D909A8E")
        @DSModeled(DSC.SAFE)
        public AutoFillData() {
            mQueryId = WebTextView.FORM_NOT_AUTOFILLABLE;
            mPreview = "";
            // ---------- Original Method ----------
            //mQueryId = WebTextView.FORM_NOT_AUTOFILLABLE;
            //mPreview = "";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.214 -0400", hash_original_method = "CF8D1F130162170BD4749FDD138AF5B0", hash_generated_method = "FE8AD5C0605D35DFFBD26665082B14AD")
        @DSModeled(DSC.SAFE)
        public AutoFillData(int queryId, String preview) {
            dsTaint.addTaint(preview);
            dsTaint.addTaint(queryId);
            // ---------- Original Method ----------
            //mQueryId = queryId;
            //mPreview = preview;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.214 -0400", hash_original_method = "7DF004F757D7E4F7320327B99689B65F", hash_generated_method = "1BA21ABD711736BBF6D42DF76290D9A4")
        @DSModeled(DSC.SAFE)
        public int getQueryId() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mQueryId;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.214 -0400", hash_original_method = "E4F5699DB01CFB534A6B08E3CFDC42EF", hash_generated_method = "37E3545DD0CC86D9A2DD12BDE99480C3")
        @DSModeled(DSC.SAFE)
        public String getPreviewString() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return mPreview;
        }

        
    }


    
    static class TouchEventData {
        int mAction;
        int[] mIds;
        Point[] mPoints;
        Point[] mPointsInView;
        int mActionIndex;
        int mMetaState;
        boolean mReprocess;
        MotionEvent mMotionEvent;
        int mNativeLayer;
        Rect mNativeLayerRect = new Rect();
        long mSequence;
        boolean mNativeResult;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.214 -0400", hash_original_method = "19EB2329E6C0005D2C71EE69A3871829", hash_generated_method = "19EB2329E6C0005D2C71EE69A3871829")
                public TouchEventData ()
        {
        }


    }


    
    static class GeolocationPermissionsData {
        String mOrigin;
        boolean mAllow;
        boolean mRemember;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.215 -0400", hash_original_method = "FAD97BFD82FCBC262DD69D703A132B75", hash_generated_method = "FAD97BFD82FCBC262DD69D703A132B75")
                public GeolocationPermissionsData ()
        {
        }


    }


    
    public class EventHub {
        private Handler mHandler;
        private ArrayList<Message> mMessages = new ArrayList<Message>();
        private boolean mBlockMessages;
        private boolean mDestroying;
        private int mTid;
        private int mSavedPriority;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.215 -0400", hash_original_method = "E81290CBA9EBCD5546A9E9277FAE0605", hash_generated_method = "A52E68C7F77102AEF2A85166BA2DF4B3")
        @DSModeled(DSC.SAFE)
        private EventHub() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.226 -0400", hash_original_method = "306B3D199EA83A68750A5F32B05C0197", hash_generated_method = "3318BD73A6CE1FA2646689762C31DCFD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void transferMessages() {
            mTid = Process.myTid();
            mSavedPriority = Process.getThreadPriority(mTid);
            mHandler = new Handler() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.224 -0400", hash_original_method = "F0B3B381C6E702A698555C74D6931FF7", hash_generated_method = "FFD040B07AA5188A585408DBE388E118")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public void handleMessage(Message msg) {
                    dsTaint.addTaint(msg.dsTaint);
                    //Begin case WEBKIT_DRAW 
                    webkitDraw();
                    //End case WEBKIT_DRAW 
                    //Begin case WEBKIT_DRAW_LAYERS 
                    webkitDrawLayers();
                    //End case WEBKIT_DRAW_LAYERS 
                    //Begin case DESTROY 
                    {
                        Object var57F7C9E62F50237F3839461924AB4285_1090934178 = (WebViewCore.this);
                        {
                            mBrowserFrame.destroy();
                            mBrowserFrame = null;
                            mSettings.onDestroyed();
                            mNativeClass = 0;
                            mWebView = null;
                        } //End block
                    } //End collapsed parenthetic
                    //End case DESTROY 
                    //Begin case REVEAL_SELECTION 
                    nativeRevealSelection();
                    //End case REVEAL_SELECTION 
                    //Begin case REQUEST_LABEL 
                    {
                        int nodePointer;
                        nodePointer = msg.arg2;
                        String label;
                        label = nativeRequestLabel(msg.arg1,
                                        nodePointer);
                        {
                            boolean varF735B304F54339026D0CA1C53FD41B78_153798726 = (label != null && label.length() > 0);
                            {
                                Message.obtain(mWebView.mPrivateHandler,
                                            WebView.RETURN_LABEL, nodePointer,
                                            0, label).sendToTarget();
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    //End case REQUEST_LABEL 
                    //Begin case UPDATE_FRAME_CACHE_IF_LOADING 
                    nativeUpdateFrameCacheIfLoading();
                    //End case UPDATE_FRAME_CACHE_IF_LOADING 
                    //Begin case SCROLL_TEXT_INPUT 
                    float xPercent;
                    //End case SCROLL_TEXT_INPUT 
                    //Begin case SCROLL_TEXT_INPUT 
                    {
                        xPercent = 0f;
                    } //End block
                    {
                        xPercent = ((Float) msg.obj).floatValue();
                    } //End block
                    //End case SCROLL_TEXT_INPUT 
                    //Begin case SCROLL_TEXT_INPUT 
                    nativeScrollFocusedTextInput(xPercent, msg.arg2);
                    //End case SCROLL_TEXT_INPUT 
                    //Begin case LOAD_URL 
                    {
                        CookieManager.getInstance().waitForCookieOperationsToComplete();
                        GetUrlData param;
                        param = (GetUrlData) msg.obj;
                        loadUrl(param.mUrl, param.mExtraHeaders);
                    } //End block
                    //End case LOAD_URL 
                    //Begin case POST_URL 
                    {
                        CookieManager.getInstance().waitForCookieOperationsToComplete();
                        PostUrlData param;
                        param = (PostUrlData) msg.obj;
                        mBrowserFrame.postUrl(param.mUrl, param.mPostData);
                    } //End block
                    //End case POST_URL 
                    //Begin case LOAD_DATA 
                    CookieManager.getInstance().waitForCookieOperationsToComplete();
                    //End case LOAD_DATA 
                    //Begin case LOAD_DATA 
                    BaseUrlData loadParams;
                    loadParams = (BaseUrlData) msg.obj;
                    //End case LOAD_DATA 
                    //Begin case LOAD_DATA 
                    String baseUrl;
                    baseUrl = loadParams.mBaseUrl;
                    //End case LOAD_DATA 
                    //Begin case LOAD_DATA 
                    {
                        int i;
                        i = baseUrl.indexOf(':');
                        {
                            String scheme;
                            scheme = baseUrl.substring(0, i);
                            {
                                boolean varA2E56D0D7C8A087FDA40C96A1A8A0E5C_988671064 = (!scheme.startsWith("http") &&
                                            !scheme.startsWith("ftp") &&
                                            !scheme.startsWith("about") &&
                                            !scheme.startsWith("javascript"));
                                {
                                    nativeRegisterURLSchemeAsLocal(scheme);
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                    //End case LOAD_DATA 
                    //Begin case LOAD_DATA 
                    mBrowserFrame.loadData(baseUrl,
                                    loadParams.mData,
                                    loadParams.mMimeType,
                                    loadParams.mEncoding,
                                    loadParams.mHistoryUrl);
                    //End case LOAD_DATA 
                    //Begin case LOAD_DATA 
                    nativeContentInvalidateAll();
                    //End case LOAD_DATA 
                    //Begin case STOP_LOADING 
                    {
                        boolean var1CDB79E5CA9506E38E9F47122C3F2A81_1033574338 = (mBrowserFrame.committed()
                                    && !mBrowserFrame.firstLayoutDone());
                        {
                            mBrowserFrame.didFirstLayout();
                        } //End block
                    } //End collapsed parenthetic
                    //End case STOP_LOADING 
                    //Begin case STOP_LOADING 
                    stopLoading();
                    //End case STOP_LOADING 
                    //Begin case RELOAD 
                    mBrowserFrame.reload(false);
                    //End case RELOAD 
                    //Begin case KEY_DOWN 
                    key((KeyEvent) msg.obj, true);
                    //End case KEY_DOWN 
                    //Begin case KEY_UP 
                    key((KeyEvent) msg.obj, false);
                    //End case KEY_UP 
                    //Begin case FAKE_CLICK 
                    nativeClick(msg.arg1, msg.arg2, true);
                    //End case FAKE_CLICK 
                    //Begin case CLICK 
                    nativeClick(msg.arg1, msg.arg2, false);
                    //End case CLICK 
                    //Begin case VIEW_SIZE_CHANGED 
                    {
                        viewSizeChanged((WebView.ViewSizeData) msg.obj);
                    } //End block
                    //End case VIEW_SIZE_CHANGED 
                    //Begin case SET_SCROLL_OFFSET 
                    Point pt;
                    pt = (Point) msg.obj;
                    //End case SET_SCROLL_OFFSET 
                    //Begin case SET_SCROLL_OFFSET 
                    nativeSetScrollOffset(msg.arg1, msg.arg2 == 1,
                                    pt.x, pt.y);
                    //End case SET_SCROLL_OFFSET 
                    //Begin case SET_GLOBAL_BOUNDS 
                    Rect r;
                    r = (Rect) msg.obj;
                    //End case SET_GLOBAL_BOUNDS 
                    //Begin case SET_GLOBAL_BOUNDS 
                    nativeSetGlobalBounds(r.left, r.top, r.width(),
                                r.height());
                    //End case SET_GLOBAL_BOUNDS 
                    //Begin case GO_BACK_FORWARD 
                    {
                        boolean var893023BC55997FD9309032550EA6349B_2110439293 = (!mBrowserFrame.committed() && msg.arg1 == -1 &&
                                    (mBrowserFrame.loadType() ==
                                    BrowserFrame.FRAME_LOADTYPE_STANDARD));
                        {
                            mBrowserFrame.reload(true);
                        } //End block
                        {
                            mBrowserFrame.goBackOrForward(msg.arg1);
                        } //End block
                    } //End collapsed parenthetic
                    //End case GO_BACK_FORWARD 
                    //Begin case RESTORE_STATE 
                    stopLoading();
                    //End case RESTORE_STATE 
                    //Begin case RESTORE_STATE 
                    restoreState(msg.arg1);
                    //End case RESTORE_STATE 
                    //Begin case PAUSE_TIMERS 
                    mSavedPriority = Process.getThreadPriority(mTid);
                    //End case PAUSE_TIMERS 
                    //Begin case PAUSE_TIMERS 
                    Process.setThreadPriority(mTid,
                                    Process.THREAD_PRIORITY_BACKGROUND);
                    //End case PAUSE_TIMERS 
                    //Begin case PAUSE_TIMERS 
                    pauseTimers();
                    //End case PAUSE_TIMERS 
                    //Begin case PAUSE_TIMERS 
                    {
                        boolean var2DDC5BD4BB2F6B2978F909E7F34AB06D_287917973 = (!JniUtil.useChromiumHttpStack());
                        {
                            WebViewWorker.getHandler().sendEmptyMessage(
                                        WebViewWorker.MSG_PAUSE_CACHE_TRANSACTION);
                        } //End block
                        {
                            nativeCloseIdleConnections();
                        } //End block
                    } //End collapsed parenthetic
                    //End case PAUSE_TIMERS 
                    //Begin case RESUME_TIMERS 
                    Process.setThreadPriority(mTid, mSavedPriority);
                    //End case RESUME_TIMERS 
                    //Begin case RESUME_TIMERS 
                    resumeTimers();
                    //End case RESUME_TIMERS 
                    //Begin case RESUME_TIMERS 
                    {
                        boolean var2DDC5BD4BB2F6B2978F909E7F34AB06D_906958837 = (!JniUtil.useChromiumHttpStack());
                        {
                            WebViewWorker.getHandler().sendEmptyMessage(
                                        WebViewWorker.MSG_RESUME_CACHE_TRANSACTION);
                        } //End block
                    } //End collapsed parenthetic
                    //End case RESUME_TIMERS 
                    //Begin case ON_PAUSE 
                    nativePause();
                    //End case ON_PAUSE 
                    //Begin case ON_RESUME 
                    nativeResume();
                    //End case ON_RESUME 
                    //Begin case FREE_MEMORY 
                    clearCache(false);
                    //End case FREE_MEMORY 
                    //Begin case FREE_MEMORY 
                    nativeFreeMemory();
                    //End case FREE_MEMORY 
                    //Begin case SET_NETWORK_STATE 
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("No WebView " +
                                        "has been created in this process!");
                    } //End block
                    //End case SET_NETWORK_STATE 
                    //Begin case SET_NETWORK_STATE 
                    BrowserFrame.sJavaBridge
                                    .setNetworkOnLine(msg.arg1 == 1);
                    //End case SET_NETWORK_STATE 
                    //Begin case SET_NETWORK_TYPE 
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("No WebView " +
                                        "has been created in this process!");
                    } //End block
                    //End case SET_NETWORK_TYPE 
                    //Begin case SET_NETWORK_TYPE 
                    Map<String, String> map;
                    map = (Map<String, String>) msg.obj;
                    //End case SET_NETWORK_TYPE 
                    //Begin case SET_NETWORK_TYPE 
                    BrowserFrame.sJavaBridge
                                    .setNetworkType(map.get("type"), map.get("subtype"));
                    //End case SET_NETWORK_TYPE 
                    //Begin case CLEAR_CACHE 
                    clearCache(msg.arg1 == 1);
                    //End case CLEAR_CACHE 
                    //Begin case CLEAR_HISTORY 
                    mCallbackProxy.getBackForwardList().
                                    close(mBrowserFrame.mNativeFrame);
                    //End case CLEAR_HISTORY 
                    //Begin case REPLACE_TEXT 
                    ReplaceTextData rep;
                    rep = (ReplaceTextData) msg.obj;
                    //End case REPLACE_TEXT 
                    //Begin case REPLACE_TEXT 
                    nativeReplaceTextfieldText(msg.arg1, msg.arg2,
                                    rep.mReplace, rep.mNewStart, rep.mNewEnd,
                                    rep.mTextGeneration);
                    //End case REPLACE_TEXT 
                    //Begin case PASS_TO_JS 
                    {
                        JSKeyData jsData;
                        jsData = (JSKeyData) msg.obj;
                        KeyEvent evt;
                        evt = jsData.mEvent;
                        int keyCode;
                        keyCode = evt.getKeyCode();
                        int keyValue;
                        keyValue = evt.getUnicodeChar();
                        int generation;
                        generation = msg.arg1;
                        passToJs(generation,
                                    jsData.mCurrentText,
                                    keyCode,
                                    keyValue,
                                    evt.isDown(),
                                    evt.isShiftPressed(), evt.isAltPressed(),
                                    evt.isSymPressed());
                    } //End block
                    //End case PASS_TO_JS 
                    //Begin case SAVE_DOCUMENT_STATE 
                    {
                        CursorData cDat;
                        cDat = (CursorData) msg.obj;
                        nativeSaveDocumentState(cDat.mFrame);
                    } //End block
                    //End case SAVE_DOCUMENT_STATE 
                    //Begin case CLEAR_SSL_PREF_TABLE 
                    {
                        boolean varF3475F759DD108C1DC11D60361B928EA_622572786 = (JniUtil.useChromiumHttpStack());
                        {
                            SslCertLookupTable.getInstance().clear();
                            nativeCloseIdleConnections();
                        } //End block
                        {
                            Network.getInstance(mContext).clearUserSslPrefTable();
                        } //End block
                    } //End collapsed parenthetic
                    //End case CLEAR_SSL_PREF_TABLE 
                    //Begin case TOUCH_UP 
                    TouchUpData touchUpData;
                    touchUpData = (TouchUpData) msg.obj;
                    //End case TOUCH_UP 
                    //Begin case TOUCH_UP 
                    {
                        nativeScrollLayer(touchUpData.mNativeLayer,
                                        touchUpData.mNativeLayerRect);
                    } //End block
                    //End case TOUCH_UP 
                    //Begin case TOUCH_UP 
                    nativeTouchUp(touchUpData.mMoveGeneration,
                                    touchUpData.mFrame, touchUpData.mNode,
                                    touchUpData.mX, touchUpData.mY);
                    //End case TOUCH_UP 
                    //Begin case TOUCH_EVENT 
                    {
                        TouchEventData ted;
                        ted = (TouchEventData) msg.obj;
                        int count;
                        count = ted.mPoints.length;
                        int[] xArray;
                        xArray = new int[count];
                        int[] yArray;
                        yArray = new int[count];
                        {
                            int c;
                            c = 0;
                            {
                                xArray[c] = ted.mPoints[c].x;
                                yArray[c] = ted.mPoints[c].y;
                            } //End block
                        } //End collapsed parenthetic
                        {
                            nativeScrollLayer(ted.mNativeLayer,
                                        ted.mNativeLayerRect);
                        } //End block
                        ted.mNativeResult = nativeHandleTouchEvent(ted.mAction, ted.mIds,
                                    xArray, yArray, count, ted.mActionIndex, ted.mMetaState);
                        Message.obtain(
                                    mWebView.mPrivateHandler,
                                    WebView.PREVENT_TOUCH_ID,
                                    ted.mAction,
                                    ted.mNativeResult ? 1 : 0,
                                    ted).sendToTarget();
                    } //End block
                    //End case TOUCH_EVENT 
                    //Begin case SET_ACTIVE 
                    nativeSetFocusControllerActive(msg.arg1 == 1);
                    //End case SET_ACTIVE 
                    //Begin case ADD_JS_INTERFACE 
                    JSInterfaceData jsData;
                    jsData = (JSInterfaceData) msg.obj;
                    //End case ADD_JS_INTERFACE 
                    //Begin case ADD_JS_INTERFACE 
                    mBrowserFrame.addJavascriptInterface(jsData.mObject,
                                    jsData.mInterfaceName);
                    //End case ADD_JS_INTERFACE 
                    //Begin case REMOVE_JS_INTERFACE 
                    jsData = (JSInterfaceData) msg.obj;
                    //End case REMOVE_JS_INTERFACE 
                    //Begin case REMOVE_JS_INTERFACE 
                    mBrowserFrame.removeJavascriptInterface(
                                    jsData.mInterfaceName);
                    //End case REMOVE_JS_INTERFACE 
                    //Begin case REQUEST_EXT_REPRESENTATION 
                    mBrowserFrame.externalRepresentation(
                                    (Message) msg.obj);
                    //End case REQUEST_EXT_REPRESENTATION 
                    //Begin case REQUEST_DOC_AS_TEXT 
                    mBrowserFrame.documentAsText((Message) msg.obj);
                    //End case REQUEST_DOC_AS_TEXT 
                    //Begin case SET_MOVE_FOCUS 
                    CursorData focusData;
                    focusData = (CursorData) msg.obj;
                    //End case SET_MOVE_FOCUS 
                    //Begin case SET_MOVE_FOCUS 
                    nativeMoveFocus(focusData.mFrame, focusData.mNode);
                    //End case SET_MOVE_FOCUS 
                    //Begin case SET_MOVE_MOUSE 
                    CursorData cursorData;
                    cursorData = (CursorData) msg.obj;
                    //End case SET_MOVE_MOUSE 
                    //Begin case SET_MOVE_MOUSE 
                    nativeMoveMouse(cursorData.mFrame,
                                     cursorData.mX, cursorData.mY);
                    //End case SET_MOVE_MOUSE 
                    //Begin case SET_MOVE_MOUSE_IF_LATEST 
                    CursorData cData;
                    cData = (CursorData) msg.obj;
                    //End case SET_MOVE_MOUSE_IF_LATEST 
                    //Begin case SET_MOVE_MOUSE_IF_LATEST 
                    nativeMoveMouseIfLatest(cData.mMoveGeneration,
                                    cData.mFrame,
                                    cData.mX, cData.mY);
                    //End case SET_MOVE_MOUSE_IF_LATEST 
                    //Begin case SET_MOVE_MOUSE_IF_LATEST 
                    {
                        nativeStopPaintingCaret();
                    } //End block
                    //End case SET_MOVE_MOUSE_IF_LATEST 
                    //Begin case REQUEST_CURSOR_HREF 
                    {
                        Message hrefMsg;
                        hrefMsg = (Message) msg.obj;
                        hrefMsg.getData().putString("url",
                                    nativeRetrieveHref(msg.arg1, msg.arg2));
                        hrefMsg.getData().putString("title",
                                    nativeRetrieveAnchorText(msg.arg1, msg.arg2));
                        hrefMsg.getData().putString("src",
                                    nativeRetrieveImageSource(msg.arg1, msg.arg2));
                        hrefMsg.sendToTarget();
                    } //End block
                    //End case REQUEST_CURSOR_HREF 
                    //Begin case UPDATE_CACHE_AND_TEXT_ENTRY 
                    nativeUpdateFrameCache();
                    //End case UPDATE_CACHE_AND_TEXT_ENTRY 
                    //Begin case UPDATE_CACHE_AND_TEXT_ENTRY 
                    {
                        mWebView.postInvalidate();
                    } //End block
                    //End case UPDATE_CACHE_AND_TEXT_ENTRY 
                    //Begin case UPDATE_CACHE_AND_TEXT_ENTRY 
                    sendUpdateTextEntry();
                    //End case UPDATE_CACHE_AND_TEXT_ENTRY 
                    //Begin case DOC_HAS_IMAGES 
                    Message imageResult;
                    imageResult = (Message) msg.obj;
                    //End case DOC_HAS_IMAGES 
                    //Begin case DOC_HAS_IMAGES 
                    imageResult.arg1 =
                                    mBrowserFrame.documentHasImages() ? 1 : 0;
                    //End case DOC_HAS_IMAGES 
                    //Begin case DOC_HAS_IMAGES 
                    imageResult.sendToTarget();
                    //End case DOC_HAS_IMAGES 
                    //Begin case DELETE_SELECTION 
                    TextSelectionData deleteSelectionData;
                    deleteSelectionData = (TextSelectionData) msg.obj;
                    //End case DELETE_SELECTION 
                    //Begin case DELETE_SELECTION 
                    nativeDeleteSelection(deleteSelectionData.mStart,
                                    deleteSelectionData.mEnd, msg.arg1);
                    //End case DELETE_SELECTION 
                    //Begin case SET_SELECTION 
                    nativeSetSelection(msg.arg1, msg.arg2);
                    //End case SET_SELECTION 
                    //Begin case MODIFY_SELECTION 
                    String modifiedSelectionString;
                    modifiedSelectionString = nativeModifySelection(msg.arg1,
                                    msg.arg2);
                    //End case MODIFY_SELECTION 
                    //Begin case MODIFY_SELECTION 
                    mWebView.mPrivateHandler.obtainMessage(WebView.SELECTION_STRING_CHANGED,
                                    modifiedSelectionString).sendToTarget();
                    //End case MODIFY_SELECTION 
                    //Begin case LISTBOX_CHOICES 
                    SparseBooleanArray choices;
                    choices = (SparseBooleanArray)
                                    msg.obj;
                    //End case LISTBOX_CHOICES 
                    //Begin case LISTBOX_CHOICES 
                    int choicesSize;
                    choicesSize = msg.arg1;
                    //End case LISTBOX_CHOICES 
                    //Begin case LISTBOX_CHOICES 
                    boolean[] choicesArray;
                    choicesArray = new boolean[choicesSize];
                    //End case LISTBOX_CHOICES 
                    //Begin case LISTBOX_CHOICES 
                    {
                        int c;
                        c = 0;
                        {
                            choicesArray[c] = choices.get(c);
                        } //End block
                    } //End collapsed parenthetic
                    //End case LISTBOX_CHOICES 
                    //Begin case LISTBOX_CHOICES 
                    nativeSendListBoxChoices(choicesArray,
                                    choicesSize);
                    //End case LISTBOX_CHOICES 
                    //Begin case SINGLE_LISTBOX_CHOICE 
                    nativeSendListBoxChoice(msg.arg1);
                    //End case SINGLE_LISTBOX_CHOICE 
                    //Begin case SET_BACKGROUND_COLOR 
                    nativeSetBackgroundColor(msg.arg1);
                    //End case SET_BACKGROUND_COLOR 
                    //Begin case DUMP_DOMTREE 
                    nativeDumpDomTree(msg.arg1 == 1);
                    //End case DUMP_DOMTREE 
                    //Begin case DUMP_RENDERTREE 
                    nativeDumpRenderTree(msg.arg1 == 1);
                    //End case DUMP_RENDERTREE 
                    //Begin case DUMP_NAVTREE 
                    nativeDumpNavTree();
                    //End case DUMP_NAVTREE 
                    //Begin case DUMP_V8COUNTERS 
                    nativeDumpV8Counters();
                    //End case DUMP_V8COUNTERS 
                    //Begin case SET_JS_FLAGS 
                    nativeSetJsFlags((String)msg.obj);
                    //End case SET_JS_FLAGS 
                    //Begin case CONTENT_INVALIDATE_ALL 
                    nativeContentInvalidateAll();
                    //End case CONTENT_INVALIDATE_ALL 
                    //Begin case SAVE_WEBARCHIVE 
                    WebView.SaveWebArchiveMessage saveMessage;
                    saveMessage = (WebView.SaveWebArchiveMessage)msg.obj;
                    //End case SAVE_WEBARCHIVE 
                    //Begin case SAVE_WEBARCHIVE 
                    saveMessage.mResultFile =
                                saveWebArchive(saveMessage.mBasename, saveMessage.mAutoname);
                    //End case SAVE_WEBARCHIVE 
                    //Begin case SAVE_WEBARCHIVE 
                    mWebView.mPrivateHandler.obtainMessage(
                                WebView.SAVE_WEBARCHIVE_FINISHED, saveMessage).sendToTarget();
                    //End case SAVE_WEBARCHIVE 
                    //Begin case GEOLOCATION_PERMISSIONS_PROVIDE 
                    GeolocationPermissionsData data;
                    data = (GeolocationPermissionsData) msg.obj;
                    //End case GEOLOCATION_PERMISSIONS_PROVIDE 
                    //Begin case GEOLOCATION_PERMISSIONS_PROVIDE 
                    nativeGeolocationPermissionsProvide(data.mOrigin,
                                    data.mAllow, data.mRemember);
                    //End case GEOLOCATION_PERMISSIONS_PROVIDE 
                    //Begin case SPLIT_PICTURE_SET 
                    nativeSplitContent(msg.arg1);
                    //End case SPLIT_PICTURE_SET 
                    //Begin case SPLIT_PICTURE_SET 
                    mWebView.mPrivateHandler.obtainMessage(
                                    WebView.REPLACE_BASE_CONTENT, msg.arg1, 0);
                    //End case SPLIT_PICTURE_SET 
                    //Begin case SPLIT_PICTURE_SET 
                    mSplitPictureIsScheduled = false;
                    //End case SPLIT_PICTURE_SET 
                    //Begin case CLEAR_CONTENT 
                    nativeClearContent();
                    //End case CLEAR_CONTENT 
                    //Begin case MESSAGE_RELAY 
                    ((Message) msg.obj).sendToTarget();
                    //End case MESSAGE_RELAY 
                    //Begin case POPULATE_VISITED_LINKS 
                    nativeProvideVisitedHistory((String[])msg.obj);
                    //End case POPULATE_VISITED_LINKS 
                    //Begin case VALID_NODE_BOUNDS 
                    {
                        MotionUpData motionUpData;
                        motionUpData = (MotionUpData) msg.obj;
                        {
                            boolean var3C260CC22B1DBBEA4A22E069D8F01A64_304692243 = (!nativeValidNodeAndBounds(
                                    motionUpData.mFrame, motionUpData.mNode,
                                    motionUpData.mBounds));
                            {
                                nativeUpdateFrameCache();
                            } //End block
                        } //End collapsed parenthetic
                        Message message;
                        message = mWebView.mPrivateHandler
                                    .obtainMessage(WebView.DO_MOTION_UP,
                                    motionUpData.mX, motionUpData.mY);
                        mWebView.mPrivateHandler.sendMessageAtFrontOfQueue(
                                    message);
                    } //End block
                    //End case VALID_NODE_BOUNDS 
                    //Begin case HIDE_FULLSCREEN 
                    nativeFullScreenPluginHidden(msg.arg1);
                    //End case HIDE_FULLSCREEN 
                    //Begin case PLUGIN_SURFACE_READY 
                    nativePluginSurfaceReady();
                    //End case PLUGIN_SURFACE_READY 
                    //Begin case NOTIFY_ANIMATION_STARTED 
                    nativeNotifyAnimationStarted(mNativeClass);
                    //End case NOTIFY_ANIMATION_STARTED 
                    //Begin case ADD_PACKAGE_NAMES 
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("No WebView " +
                                        "has been created in this process!");
                    } //End block
                    //End case ADD_PACKAGE_NAMES 
                    //Begin case ADD_PACKAGE_NAMES 
                    BrowserFrame.sJavaBridge.addPackageNames(
                                    (Set<String>) msg.obj);
                    //End case ADD_PACKAGE_NAMES 
                    //Begin case GET_TOUCH_HIGHLIGHT_RECTS 
                    TouchHighlightData d;
                    d = (TouchHighlightData) msg.obj;
                    //End case GET_TOUCH_HIGHLIGHT_RECTS 
                    //Begin case GET_TOUCH_HIGHLIGHT_RECTS 
                    {
                        nativeScrollLayer(d.mNativeLayer,
                                        d.mNativeLayerRect);
                    } //End block
                    //End case GET_TOUCH_HIGHLIGHT_RECTS 
                    //Begin case GET_TOUCH_HIGHLIGHT_RECTS 
                    ArrayList<Rect> rects;
                    rects = nativeGetTouchHighlightRects
                                    (d.mX, d.mY, d.mSlop);
                    //End case GET_TOUCH_HIGHLIGHT_RECTS 
                    //Begin case GET_TOUCH_HIGHLIGHT_RECTS 
                    mWebView.mPrivateHandler.obtainMessage(
                                    WebView.SET_TOUCH_HIGHLIGHT_RECTS, rects)
                                    .sendToTarget();
                    //End case GET_TOUCH_HIGHLIGHT_RECTS 
                    //Begin case USE_MOCK_DEVICE_ORIENTATION 
                    useMockDeviceOrientation();
                    //End case USE_MOCK_DEVICE_ORIENTATION 
                    //Begin case AUTOFILL_FORM 
                    nativeAutoFillForm(msg.arg1);
                    //End case AUTOFILL_FORM 
                    //Begin case AUTOFILL_FORM 
                    mWebView.mPrivateHandler.obtainMessage(WebView.AUTOFILL_COMPLETE, null)
                                    .sendToTarget();
                    //End case AUTOFILL_FORM 
                    //Begin case EXECUTE_JS 
                    {
                        {
                            Log.d(LOGTAG, "Executing JS : " + msg.obj);
                        } //End block
                        mBrowserFrame.stringByEvaluatingJavaScriptFromString((String) msg.obj);
                    } //End block
                    //End case EXECUTE_JS 
                    // ---------- Original Method ----------
                    // Original Method Too Long, Refer to Original Implementation
                }
};
            {
                int size;
                size = mMessages.size();
                {
                    int i;
                    i = 0;
                    {
                        mHandler.sendMessage(mMessages.get(i));
                    } //End block
                } //End collapsed parenthetic
                mMessages = null;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.227 -0400", hash_original_method = "A3F2FAE5568048D2CF4F883B9C3D720D", hash_generated_method = "8C2BC70978462DECAE92E748504F4C4A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private synchronized void sendMessage(Message msg) {
            dsTaint.addTaint(msg.dsTaint);
            {
                mMessages.add(msg);
            } //End block
            {
                mHandler.sendMessage(msg);
            } //End block
            // ---------- Original Method ----------
            //if (mBlockMessages) {
                //return;
            //}
            //if (mMessages != null) {
                //mMessages.add(msg);
            //} else {
                //mHandler.sendMessage(msg);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.227 -0400", hash_original_method = "2D760BF01DEDB25033C3CD5EE0C5DC00", hash_generated_method = "968750B626A75A9843D1D93B78EFA008")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private synchronized void removeMessages(int what) {
            dsTaint.addTaint(what);
            {
                mDrawIsScheduled = false;
            } //End block
            {
                Throwable throwable;
                throwable = new Throwable(
                        "EventHub.removeMessages(int what = " + what + ") is not supported " +
                        "before the WebViewCore is set up.");
            } //End block
            {
                mHandler.removeMessages(what);
            } //End block
            // ---------- Original Method ----------
            //if (mBlockMessages) {
                //return;
            //}
            //if (what == EventHub.WEBKIT_DRAW) {
                //mDrawIsScheduled = false;
            //}
            //if (mMessages != null) {
                //Throwable throwable = new Throwable(
                        //"EventHub.removeMessages(int what = " + what + ") is not supported " +
                        //"before the WebViewCore is set up.");
                //Log.w(LOGTAG, Log.getStackTraceString(throwable));
            //} else {
                //mHandler.removeMessages(what);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.227 -0400", hash_original_method = "8649C68E7EFBE767B713B2AB196A4693", hash_generated_method = "378FB40E01443BD248D1FA5147893AB8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private synchronized void sendMessageDelayed(Message msg, long delay) {
            dsTaint.addTaint(delay);
            dsTaint.addTaint(msg.dsTaint);
            mHandler.sendMessageDelayed(msg, delay);
            // ---------- Original Method ----------
            //if (mBlockMessages) {
                //return;
            //}
            //mHandler.sendMessageDelayed(msg, delay);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.228 -0400", hash_original_method = "D0F21E4A05814ED295A9D395C58D6229", hash_generated_method = "B59AEAE949E0A8B050CB86ACB46BF268")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private synchronized void sendMessageAtFrontOfQueue(Message msg) {
            dsTaint.addTaint(msg.dsTaint);
            {
                mMessages.add(0, msg);
            } //End block
            {
                mHandler.sendMessageAtFrontOfQueue(msg);
            } //End block
            // ---------- Original Method ----------
            //if (mBlockMessages) {
                //return;
            //}
            //if (mMessages != null) {
                //mMessages.add(0, msg);
            //} else {
                //mHandler.sendMessageAtFrontOfQueue(msg);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.228 -0400", hash_original_method = "2D908156D971A0132EC1B636390B02E6", hash_generated_method = "14131740913625E95BC1CF56E0E732F4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private synchronized void removeMessages() {
            mDrawIsScheduled = false;
            mSplitPictureIsScheduled = false;
            {
                mMessages.clear();
            } //End block
            {
                mHandler.removeCallbacksAndMessages(null);
            } //End block
            // ---------- Original Method ----------
            //mDrawIsScheduled = false;
            //mSplitPictureIsScheduled = false;
            //if (mMessages != null) {
                //mMessages.clear();
            //} else {
                //mHandler.removeCallbacksAndMessages(null);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.228 -0400", hash_original_method = "7F4FC3BA20FD4185DE24EC53F9CE84DB", hash_generated_method = "26B51E76D19EB36CD02103295CF60E9F")
        @DSModeled(DSC.SAFE)
        private synchronized void blockMessages() {
            mBlockMessages = true;
            // ---------- Original Method ----------
            //mBlockMessages = true;
        }

        
        static final int REVEAL_SELECTION = 96;
        static final int REQUEST_LABEL = 97;
        static final int UPDATE_FRAME_CACHE_IF_LOADING = 98;
        static final int SCROLL_TEXT_INPUT = 99;
        static final int LOAD_URL = 100;
        static final int STOP_LOADING = 101;
        static final int RELOAD = 102;
        static final int KEY_DOWN = 103;
        static final int KEY_UP = 104;
        static final int VIEW_SIZE_CHANGED = 105;
        static final int GO_BACK_FORWARD = 106;
        static final int SET_SCROLL_OFFSET = 107;
        static final int RESTORE_STATE = 108;
        static final int PAUSE_TIMERS = 109;
        static final int RESUME_TIMERS = 110;
        static final int CLEAR_CACHE = 111;
        static final int CLEAR_HISTORY = 112;
        static final int SET_SELECTION = 113;
        static final int REPLACE_TEXT = 114;
        static final int PASS_TO_JS = 115;
        static final int SET_GLOBAL_BOUNDS = 116;
        static final int UPDATE_CACHE_AND_TEXT_ENTRY = 117;
        static final int CLICK = 118;
        static final int SET_NETWORK_STATE = 119;
        static final int DOC_HAS_IMAGES = 120;
        static final int FAKE_CLICK = 121;
        static final int DELETE_SELECTION = 122;
        static final int LISTBOX_CHOICES = 123;
        static final int SINGLE_LISTBOX_CHOICE = 124;
        public static final int MESSAGE_RELAY = 125;
        static final int SET_BACKGROUND_COLOR = 126;
        static final int SET_MOVE_FOCUS = 127;
        static final int SAVE_DOCUMENT_STATE = 128;
        static final int WEBKIT_DRAW = 130;
        static final int POST_URL = 132;
        static final int SPLIT_PICTURE_SET = 133;
        static final int CLEAR_CONTENT = 134;
        static final int SET_MOVE_MOUSE = 135;
        static final int SET_MOVE_MOUSE_IF_LATEST = 136;
        static final int REQUEST_CURSOR_HREF = 137;
        static final int ADD_JS_INTERFACE = 138;
        static final int LOAD_DATA = 139;
        static final int TOUCH_UP = 140;
        static final int TOUCH_EVENT = 141;
        static final int SET_ACTIVE = 142;
        static final int ON_PAUSE = 143;
        static final int ON_RESUME = 144;
        static final int FREE_MEMORY = 145;
        static final int VALID_NODE_BOUNDS = 146;
        static final int SAVE_WEBARCHIVE = 147;
        static final int WEBKIT_DRAW_LAYERS = 148;
        static final int REMOVE_JS_INTERFACE = 149;
        static final int CLEAR_SSL_PREF_TABLE = 150;
        static final int REQUEST_EXT_REPRESENTATION = 160;
        static final int REQUEST_DOC_AS_TEXT = 161;
        static final int DUMP_DOMTREE = 170;
        static final int DUMP_RENDERTREE = 171;
        static final int DUMP_NAVTREE = 172;
        static final int DUMP_V8COUNTERS = 173;
        static final int SET_JS_FLAGS = 174;
        static final int CONTENT_INVALIDATE_ALL = 175;
        static final int GEOLOCATION_PERMISSIONS_PROVIDE = 180;
        static final int POPULATE_VISITED_LINKS = 181;
        static final int HIDE_FULLSCREEN = 182;
        static final int SET_NETWORK_TYPE = 183;
        static final int ADD_PACKAGE_NAMES = 184;
        static final int ADD_PACKAGE_NAME = 185;
        static final int REMOVE_PACKAGE_NAME = 186;
        static final int GET_TOUCH_HIGHLIGHT_RECTS = 187;
        static final int MODIFY_SELECTION = 190;
        static final int USE_MOCK_DEVICE_ORIENTATION = 191;
        static final int AUTOFILL_FORM = 192;
        static final int PROXY_CHANGED = 193;
        static final int EXECUTE_JS = 194;
        static final int PLUGIN_SURFACE_READY = 195;
        static final int NOTIFY_ANIMATION_STARTED = 196;
        private static final int DESTROY =     200;
        private static final int FIRST_PACKAGE_MSG_ID = REVEAL_SELECTION;
        private static final int LAST_PACKAGE_MSG_ID = VALID_NODE_BOUNDS;
    }


    
    static class ViewState {
        float mMinScale;
        float mMaxScale;
        float mViewScale;
        float mTextWrapScale;
        float mDefaultScale;
        int mScrollX;
        int mScrollY;
        boolean mMobileSite;
        boolean mIsRestored;
        boolean mShouldStartScrolledRight;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.228 -0400", hash_original_method = "0B2BEE328EBEFABDBA34ECCEDCD26024", hash_generated_method = "0B2BEE328EBEFABDBA34ECCEDCD26024")
                public ViewState ()
        {
        }


    }


    
    static class DrawData {
        int mBaseLayer;
        Region mInvalRegion;
        Point mViewSize;
        Point mContentSize;
        int mMinPrefWidth;
        ViewState mViewState;
        boolean mFirstLayoutForNonStandardLoad;
        boolean mFocusSizeChanged;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.229 -0400", hash_original_method = "0A5C1715167608A1FCEB50646E4B5581", hash_generated_method = "70BF4AD47CB5514A3FE69474E31423AD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         DrawData() {
            mBaseLayer = 0;
            mInvalRegion = new Region();
            mContentSize = new Point();
            // ---------- Original Method ----------
            //mBaseLayer = 0;
            //mInvalRegion = new Region();
            //mContentSize = new Point();
        }

        
    }


    
    static class ShowRectData {
        int mLeft;
        int mTop;
        int mWidth;
        int mHeight;
        int mContentWidth;
        int mContentHeight;
        float mXPercentInDoc;
        float mXPercentInView;
        float mYPercentInDoc;
        float mYPercentInView;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.229 -0400", hash_original_method = "EFC58627FEBA452E375465F9BBF146E8", hash_generated_method = "EFC58627FEBA452E375465F9BBF146E8")
                public ShowRectData ()
        {
        }


    }


    
    private static final String LOGTAG = "webcore";
    static {
        try {
            System.loadLibrary("webcore");
            System.loadLibrary("chromium_net");
        } catch (UnsatisfiedLinkError e) {
            Log.e(LOGTAG, "Unable to load native support libraries.");
        }
    }
    
    static final String THREAD_NAME = "WebViewCoreThread";
    private static Handler sWebCoreHandler;
    static final int ACTION_LONGPRESS = 0x100;
    static final int ACTION_DOUBLETAP = 0x200;
    static final String[] HandlerDebugString = {
            "REVEAL_SELECTION", 
            "REQUEST_LABEL", 
            "UPDATE_FRAME_CACHE_IF_LOADING", 
            "SCROLL_TEXT_INPUT", 
            "LOAD_URL", 
            "STOP_LOADING", 
            "RELOAD", 
            "KEY_DOWN", 
            "KEY_UP", 
            "VIEW_SIZE_CHANGED", 
            "GO_BACK_FORWARD", 
            "SET_SCROLL_OFFSET", 
            "RESTORE_STATE", 
            "PAUSE_TIMERS", 
            "RESUME_TIMERS", 
            "CLEAR_CACHE", 
            "CLEAR_HISTORY", 
            "SET_SELECTION", 
            "REPLACE_TEXT", 
            "PASS_TO_JS", 
            "SET_GLOBAL_BOUNDS", 
            "UPDATE_CACHE_AND_TEXT_ENTRY", 
            "CLICK", 
            "SET_NETWORK_STATE", 
            "DOC_HAS_IMAGES", 
            "FAKE_CLICK", 
            "DELETE_SELECTION", 
            "LISTBOX_CHOICES", 
            "SINGLE_LISTBOX_CHOICE", 
            "MESSAGE_RELAY", 
            "SET_BACKGROUND_COLOR", 
            "SET_MOVE_FOCUS", 
            "SAVE_DOCUMENT_STATE", 
            "129", 
            "WEBKIT_DRAW", 
            "131", 
            "POST_URL", 
            "SPLIT_PICTURE_SET", 
            "CLEAR_CONTENT", 
            "SET_MOVE_MOUSE", 
            "SET_MOVE_MOUSE_IF_LATEST", 
            "REQUEST_CURSOR_HREF", 
            "ADD_JS_INTERFACE", 
            "LOAD_DATA", 
            "TOUCH_UP", 
            "TOUCH_EVENT", 
            "SET_ACTIVE", 
            "ON_PAUSE",     
            "ON_RESUME",    
            "FREE_MEMORY",  
            "VALID_NODE_BOUNDS", 
            "SAVE_WEBARCHIVE", 
            "WEBKIT_DRAW_LAYERS", 
            "REMOVE_JS_INTERFACE", 
        };
    private static boolean mRepaintScheduled = false;
}

