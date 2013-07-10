package android.webkit;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.661 -0400", hash_original_field = "72439B8F99EB438C3DA5D9CD798C6786", hash_generated_field = "99346B50377E115231263981E00655CA")

    private WebView mWebView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.661 -0400", hash_original_field = "957B64C4FA99E51BCE1B62690725D115", hash_generated_field = "62789CA10670C708EA4D387AB18C5F89")

    private CallbackProxy mCallbackProxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.661 -0400", hash_original_field = "A5E11DE354AE2FBFC3E5565E23F4F865", hash_generated_field = "D4F7B9B886C1ADC785C82D3DD8AF3DFF")

    private WebSettings mSettings;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.661 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.661 -0400", hash_original_field = "CAA038815C3D0F5CB3961BAB79010E61", hash_generated_field = "2BD5B1AE4AB832378640307848134713")

    private int mNativeClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.661 -0400", hash_original_field = "210C1862D81E3FCC2FD87A83EA255D40", hash_generated_field = "076F5BF2A47D119E2704BFAF413B4749")

    private BrowserFrame mBrowserFrame;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.661 -0400", hash_original_field = "9213F7613A94ADF2C8C340D1CFEA4DD7", hash_generated_field = "F17541A56F563F7681D9F0B5FA6C35F3")

    private Map<String, Object> mJavascriptInterfaces;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.661 -0400", hash_original_field = "3F5F3F81B0D49FD1AA07175C774C1F69", hash_generated_field = "521238B14726DD513D30C80A6B0A4C4F")

    private int mViewportWidth = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.661 -0400", hash_original_field = "23321D82CA2965DD4B65CAB4B31C3F67", hash_generated_field = "75EA3BEE624948F33D1F6360DFF985C0")

    private int mViewportHeight = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.661 -0400", hash_original_field = "202FB95249A666F9527BD6ADA4783500", hash_generated_field = "CEAB5098F68220A2E297373A8452CBED")

    private int mViewportInitialScale = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.661 -0400", hash_original_field = "1ECE717685F0142EF16B33A7FA63A1CE", hash_generated_field = "153534A1ABB8629DDD645A0AC85B2B41")

    private int mViewportMinimumScale = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.661 -0400", hash_original_field = "C0A627CE8627F6C86A1E8646DA5D3019", hash_generated_field = "8A6C8840919CE5601294EFBA0BF7842F")

    private int mViewportMaximumScale = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.661 -0400", hash_original_field = "AC7DBE79A1BD6AE954D407879E62D4E3", hash_generated_field = "A661C7EB7326B99462ADD2006473EBB6")

    private boolean mViewportUserScalable = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.661 -0400", hash_original_field = "0D2AE33745057807DC36556CFAA065BF", hash_generated_field = "23CD0989B091ED130F15286A65580618")

    private int mViewportDensityDpi = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.661 -0400", hash_original_field = "BFFE1AA866906E5583F1B6125F9D41D1", hash_generated_field = "E18380366D9A101C0E9802BA75F6285F")

    private boolean mIsRestored = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.661 -0400", hash_original_field = "C62A53299347D72C6C959CEF7B23F91D", hash_generated_field = "7DF3DF814194A4D3E9669659B565EAA6")

    private float mRestoredScale = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.661 -0400", hash_original_field = "3E04D327D502C0D36F8AF3EA5A97D93E", hash_generated_field = "A7C3BC549C1C4C3FA2CF2DCC3B010912")

    private float mRestoredTextWrapScale = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.661 -0400", hash_original_field = "927F2810DD484D32D2246A0ACBEC7DEB", hash_generated_field = "067608C0EFAAE5432895398625DB6A61")

    private int mRestoredX = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.661 -0400", hash_original_field = "3807EEF0419407154B9DC217B0A06E59", hash_generated_field = "06A420E9C731F1A1669DED8B10031D96")

    private int mRestoredY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.661 -0400", hash_original_field = "05DBCAEB984951D9727D2EFB94B844F0", hash_generated_field = "1983618B97F984600A83B440BC15F541")

    private DeviceMotionAndOrientationManager mDeviceMotionAndOrientationManager = new DeviceMotionAndOrientationManager(this);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.661 -0400", hash_original_field = "05A6BCDD96F74E1B431A8BA4F77B8C32", hash_generated_field = "92420661BA494DCA46BDE3AD43DFB367")

    private DeviceMotionService mDeviceMotionService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.661 -0400", hash_original_field = "0E82571AD4FC78675288994F928CD875", hash_generated_field = "9F3BAB665FD36E76D05874B5724604CE")

    private DeviceOrientationService mDeviceOrientationService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.661 -0400", hash_original_field = "236B58D20A1A38B8B735ADD319114AFA", hash_generated_field = "B1C1FA299AFCD0EE8836BFF28A3ACBB2")

    private int mLowMemoryUsageThresholdMb;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.661 -0400", hash_original_field = "D8E2C510160A617F4705DF7BFA9B824A", hash_generated_field = "373468742C5EE8AC90EA3B7AB1294D81")

    private int mHighMemoryUsageThresholdMb;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.661 -0400", hash_original_field = "F4971BDCF12A7EF36450B220E7533FDA", hash_generated_field = "C3563E94A24603EC3F85758B2B971DA0")

    private int mHighUsageDeltaMb;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.661 -0400", hash_original_field = "4C132896367362EE4EFC7784A1378BD5", hash_generated_field = "E97C48C6ED52F2E8E8BB54B79F57CF9E")

    private EventHub mEventHub;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.661 -0400", hash_original_field = "1362BCE9035368E0D2DDF461DB1F724A", hash_generated_field = "C04E91045AFFBEFA87C572262F389255")

    private int mCurrentViewWidth = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.661 -0400", hash_original_field = "519A329E37375E8EFCFFD238966F6270", hash_generated_field = "256209E290B11ACF842BB422B72F67F8")

    private int mCurrentViewHeight = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.661 -0400", hash_original_field = "E47DEB17BB5EAE61644242B7359A019E", hash_generated_field = "5803229BA67F4C111F2EC54135FAEBDE")

    private float mCurrentViewScale = 1.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.661 -0400", hash_original_field = "1E28303EF288099FE6C3FE48CE758FB3", hash_generated_field = "34B754510376D214E2C01349025B5BA6")

    private boolean mDrawIsScheduled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.661 -0400", hash_original_field = "7B1F13262304A4BECC276270D9D12BCA", hash_generated_field = "400D1A405667E6D7749B38B85BCFED17")

    private boolean mDrawLayersIsScheduled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.661 -0400", hash_original_field = "AD25F2C4FC4A7315ADDDE59DAE08F02B", hash_generated_field = "8BFF2E0C3750D9DDE06D17BA45ED39F3")

    private boolean mSplitPictureIsScheduled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.661 -0400", hash_original_field = "00FC55C367053C15B023B5B7875CAF4C", hash_generated_field = "0C2D89B52FE2D2E58479EAC212A17A93")

    private boolean mDrawIsPaused;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.661 -0400", hash_original_field = "23D86D128DB4751AA10C8A9EB792A981", hash_generated_field = "591A2959CF4223F6B01827979A3A1BD7")

    private ViewState mInitialViewState = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.661 -0400", hash_original_field = "BD00C24C9CE113CE814ECA4C6FA28EA5", hash_generated_field = "8538C7090C948C7AD430607E6FB8A74E")

    private boolean mFirstLayoutForNonStandardLoad;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.661 -0400", hash_original_field = "8F342B742A5D710C3A689A996A9A0737", hash_generated_field = "2409AAF0DDA2BB89F3E937FCB53EA95F")

    DrawData mLastDrawData = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.662 -0400", hash_original_method = "68CF15993B11FD0BF4AA086C5A956766", hash_generated_method = "37CBF55C612EA571FC681E659B0C8AC7")
    public  WebViewCore(Context context, WebView w, CallbackProxy proxy,
            Map<String, Object> javascriptInterfaces) {
        mCallbackProxy = proxy;
        mWebView = w;
        mJavascriptInterfaces = javascriptInterfaces;
        mContext = context;
        {
            {
                Thread t = new Thread(new WebCoreThread());
                t.setName(THREAD_NAME);
                t.start();
                try 
                {
                    WebViewCore.class.wait();
                } 
                catch (InterruptedException e)
                { }
            } 
        } 
        mEventHub = new EventHub();
        mSettings = new WebSettings(mContext, mWebView);
        WebIconDatabase.getInstance();
        WebStorage.getInstance().createUIHandler();
        GeolocationPermissions.getInstance().createUIHandler();
        ActivityManager manager = (ActivityManager) mContext.getSystemService(
                Context.ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo memInfo = new ActivityManager.MemoryInfo();
        manager.getMemoryInfo(memInfo);
        mLowMemoryUsageThresholdMb = manager.getLargeMemoryClass();
        mHighMemoryUsageThresholdMb = (int) (mLowMemoryUsageThresholdMb * 1.5);
        mHighUsageDeltaMb = mLowMemoryUsageThresholdMb / 32;
        Message init = sWebCoreHandler.obtainMessage(
                WebCoreThread.INITIALIZE, this);
        sWebCoreHandler.sendMessage(init);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.663 -0400", hash_original_method = "A9E80124E796ABAB018EC6550B6A2293", hash_generated_method = "75DB4DF1240284E133DB00C9A96C8EF2")
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
        } 
        
        
                
        
        
        
        
        
        
        
            
                    
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.663 -0400", hash_original_method = "6D60C608DF715EFA6CF6C0614B6EA5AE", hash_generated_method = "8AA6966A0D32DCA8C668A17BEE70469F")
     void initializeSubwindow() {
        initialize();
        sWebCoreHandler.removeMessages(WebCoreThread.INITIALIZE, this);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.664 -0400", hash_original_method = "49E2B5EDCA0AFC5006663CDC7A5CE915", hash_generated_method = "6A8CEBCC3EABA4D5928FB085B8BFAB0A")
    synchronized BrowserFrame getBrowserFrame() {
        BrowserFrame varB4EAC82CA7396A68D541C85D26508E83_1064045607 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1064045607 = mBrowserFrame;
        varB4EAC82CA7396A68D541C85D26508E83_1064045607.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1064045607;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static void pauseTimers() {
        if (BrowserFrame.sJavaBridge == null) {
            throw new IllegalStateException(
                    "No WebView has been created in this process!");
        }
        BrowserFrame.sJavaBridge.pause();
    }

    
    @DSModeled(DSC.SAFE)
    public static void resumeTimers() {
        if (BrowserFrame.sJavaBridge == null) {
            throw new IllegalStateException(
                    "No WebView has been created in this process!");
        }
        BrowserFrame.sJavaBridge.resume();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.665 -0400", hash_original_method = "FDAB4AC776E0B1BB8BD354A47F4FA51B", hash_generated_method = "C64017BBCDAEB74B47ECD93EC27EFA4D")
    public WebSettings getSettings() {
        WebSettings varB4EAC82CA7396A68D541C85D26508E83_499245740 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_499245740 = mSettings;
        varB4EAC82CA7396A68D541C85D26508E83_499245740.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_499245740;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    static boolean isSupportedMediaMimeType(String mimeType) {
        int fileType = MediaFile.getFileTypeForMimeType(mimeType);
        return MediaFile.isAudioFileType(fileType)
            || MediaFile.isVideoFileType(fileType)
            || MediaFile.isPlayListFileType(fileType)
            || (mimeType != null && mimeType.startsWith("video/m4v"));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.665 -0400", hash_original_method = "1CDEF814C342D7BC6571C7725C279513", hash_generated_method = "5E6173ED51111B8D4133059CBDC19F1C")
    protected void addMessageToConsole(String message, int lineNumber, String sourceID,
            int msgLevel) {
        mCallbackProxy.addMessageToConsole(message, lineNumber, sourceID, msgLevel);
        addTaint(message.getTaint());
        addTaint(lineNumber);
        addTaint(sourceID.getTaint());
        addTaint(msgLevel);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.666 -0400", hash_original_method = "F33520EFD859046BA24511601C4E309A", hash_generated_method = "39BD09E24A50E03D8F706849C0ED9CA8")
    protected void jsAlert(String url, String message) {
        mCallbackProxy.onJsAlert(url, message);
        addTaint(url.getTaint());
        addTaint(message.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.666 -0400", hash_original_method = "91FEA98D86997027CFAF7FA478DE35E9", hash_generated_method = "DC4D8A9B8767CE40760777ADF2AC7211")
    private void formDidBlur(int nodePointer) {
        Message.obtain(mWebView.mPrivateHandler, WebView.FORM_DID_BLUR,
                nodePointer, 0).sendToTarget();
        addTaint(nodePointer);
        
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.667 -0400", hash_original_method = "A33837A6F28FD62D569A3757B4A4C37F", hash_generated_method = "41C377855A64D1DC2943DC47D45F6DFA")
    private String openFileChooser(String acceptType) {
        String varB4EAC82CA7396A68D541C85D26508E83_1275717603 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1521098266 = null; 
        Uri uri = mCallbackProxy.openFileChooser(acceptType);
        {
            String filePath = "";
            Cursor cursor = mContext.getContentResolver().query(
                    uri,
                    new String[] { MediaStore.Images.Media.DATA },
                    null, null, null);
            {
                try 
                {
                    {
                        boolean var4B88A4E0CCE1DD5CDA31BC6F14F1DD3B_177750443 = (cursor.moveToNext());
                        {
                            filePath = cursor.getString(0);
                        } 
                    } 
                } 
                finally 
                {
                    cursor.close();
                } 
            } 
            {
                filePath = uri.getLastPathSegment();
            } 
            String uriString = uri.toString();
            BrowserFrame.sJavaBridge.storeFilePathForContentUri(filePath, uriString);
            varB4EAC82CA7396A68D541C85D26508E83_1275717603 = uriString;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1521098266 = "";
        addTaint(acceptType.getTaint());
        String varA7E53CE21691AB073D9660D615818899_18284844; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_18284844 = varB4EAC82CA7396A68D541C85D26508E83_1275717603;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_18284844 = varB4EAC82CA7396A68D541C85D26508E83_1521098266;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_18284844.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_18284844;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.668 -0400", hash_original_method = "EA467B8C1E05E16A088413F72C42053A", hash_generated_method = "7F741963971494E750D42CDECC33F52A")
    protected void exceededDatabaseQuota(String url,
                                         String databaseIdentifier,
                                         long currentQuota,
                                         long estimatedSize) {
        mCallbackProxy.onExceededDatabaseQuota(url, databaseIdentifier,
                currentQuota, estimatedSize, getUsedQuota(),
                new WebStorage.QuotaUpdater() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.668 -0400", hash_original_method = "E4861BC53EE6E98021B183ABEE253837", hash_generated_method = "B4F8DB4690E8C85261B614B0BDCA8B9C")
            public void updateQuota(long quota) {
                nativeSetNewStorageLimit(quota);
                addTaint(quota);
                
                
            }
});
        addTaint(url.getTaint());
        addTaint(databaseIdentifier.getTaint());
        addTaint(currentQuota);
        addTaint(estimatedSize);
        
        
                
                
                        
                            
                        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.668 -0400", hash_original_method = "6EBBAAC7ADAC02435B9F41E378724466", hash_generated_method = "10AFF8554C0EF47651A777C4F12773B3")
    protected void reachedMaxAppCacheSize(long spaceNeeded) {
        mCallbackProxy.onReachedMaxAppCacheSize(spaceNeeded, getUsedQuota(),
                new WebStorage.QuotaUpdater() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.668 -0400", hash_original_method = "E4861BC53EE6E98021B183ABEE253837", hash_generated_method = "B4F8DB4690E8C85261B614B0BDCA8B9C")
            public void updateQuota(long quota) {
                nativeSetNewStorageLimit(quota);
                addTaint(quota);
                
                
            }
});
        addTaint(spaceNeeded);
        
        
                
                    
                        
                    
                
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.669 -0400", hash_original_method = "08A818E5335EEC34FB33D96D932556A7", hash_generated_method = "B2DE55DCA504CA62806941DC1037C09E")
    protected void populateVisitedLinks() {
        ValueCallback callback = new ValueCallback<String[]>() {
            public void onReceiveValue(String[] value) {
                sendMessage(EventHub.POPULATE_VISITED_LINKS, (Object)value);
            }
        };
        mCallbackProxy.getVisitedHistory(callback);
        
        
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.669 -0400", hash_original_method = "AEE66291188900A80051B984C26C1180", hash_generated_method = "55C23700A19D9F247F07A5E6437A09EA")
    protected void geolocationPermissionsShowPrompt(String origin) {
        mCallbackProxy.onGeolocationPermissionsShowPrompt(origin,
                new GeolocationPermissions.Callback() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.669 -0400", hash_original_method = "A46AB3E9C99782ECB5C3BEAA7BB41F9A", hash_generated_method = "D32185EF1F5F0AC875DF43CC3C8CFA32")
            public void invoke(String origin, boolean allow, boolean remember) {
                GeolocationPermissionsData data = new GeolocationPermissionsData();
                data.mOrigin = origin;
                data.mAllow = allow;
                data.mRemember = remember;
                sendMessage(EventHub.GEOLOCATION_PERMISSIONS_PROVIDE, data);
                addTaint(origin.getTaint());
                addTaint(allow);
                addTaint(remember);
                
                
                
                
                
                
            }
});
        addTaint(origin.getTaint());
        
        
                
          
            
            
            
            
            
          
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.670 -0400", hash_original_method = "4D4892762A483BC675FC4A10EF44F79C", hash_generated_method = "1FB8371D825E9FE10F0BBD945183511A")
    protected void geolocationPermissionsHidePrompt() {
        mCallbackProxy.onGeolocationPermissionsHidePrompt();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.670 -0400", hash_original_method = "8F6A3F44BB46AEBAF13827E865603705", hash_generated_method = "1A37385A11443EC1447114D870C1BE49")
    protected boolean jsConfirm(String url, String message) {
        boolean var273421F44D5E62654B8C3EBBBD266C64_873541606 = (mCallbackProxy.onJsConfirm(url, message));
        addTaint(url.getTaint());
        addTaint(message.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_891314567 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_891314567;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.671 -0400", hash_original_method = "048D73921D9D83B7AF6D9F369B7BCD1A", hash_generated_method = "F588B7D4F8BC1DD547BA2B3EF83A39D9")
    protected String jsPrompt(String url, String message, String defaultValue) {
        String varB4EAC82CA7396A68D541C85D26508E83_389611549 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_389611549 = mCallbackProxy.onJsPrompt(url, message, defaultValue);
        addTaint(url.getTaint());
        addTaint(message.getTaint());
        addTaint(defaultValue.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_389611549.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_389611549;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.671 -0400", hash_original_method = "E5A121F239BD1583646FB80C30646EA4", hash_generated_method = "9451011C4F7097A1B0325113D6EC0830")
    protected boolean jsUnload(String url, String message) {
        boolean varE6D95A02CA880D9BAAC68CEDF4C7FB76_1368537769 = (mCallbackProxy.onJsBeforeUnload(url, message));
        addTaint(url.getTaint());
        addTaint(message.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1885472283 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1885472283;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.671 -0400", hash_original_method = "3FA5335C13C08E21D5C9AA51DF388549", hash_generated_method = "2C2F681CB0BB8E0AEA9843D9B09D063F")
    protected boolean jsInterrupt() {
        boolean var2160B208215B2B209E59CF0BAA02BAF8_388496231 = (mCallbackProxy.onJsTimeout());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_415925363 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_415925363;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.671 -0400", hash_original_method = "1C765D2623C528E50D87B3709395270F", hash_generated_method = "A1EADBB5CBDDCBDE6CD56C582AB32869")
    protected void setInstallableWebApp() {
        mCallbackProxy.setInstallableWebApp();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.672 -0400", hash_original_method = "CEB9108623A7C7A0C2BFBDCA074B84FE", hash_generated_method = "0BCA3B0936DDCBE1EA155054445380D7")
    protected void enterFullscreenForVideoLayer(int layerId, String url) {
        Message message = Message.obtain(mWebView.mPrivateHandler,
                       WebView.ENTER_FULLSCREEN_VIDEO, layerId, 0);
        message.obj = url;
        message.sendToTarget();
        addTaint(layerId);
        addTaint(url.getTaint());
        
        
        
                       
        
        
    }

    
        @DSModeled(DSC.SAFE)
    static String nativeFindAddress(String addr, boolean caseInsensitive) {
        	return new String(addr);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.672 -0400", hash_original_method = "3321B2428EFA479CDCDAB88856C4C216", hash_generated_method = "4F6E9ACC880EEDBEDF0C00DB397038D8")
    private void nativeClearContent() {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.672 -0400", hash_original_method = "13D7E9686CEB46717C49AB16608C51CF", hash_generated_method = "0AD4066194FDF113B1E6EB7E6F9C5ECE")
    private void nativeContentInvalidateAll() {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.672 -0400", hash_original_method = "BFFDD95C5B679D515FF25E2212141F07", hash_generated_method = "2451E1F161FC581C9F822A958F7540D7")
    private int nativeRecordContent(Region invalRegion, Point wh) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1994180431 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1994180431;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.673 -0400", hash_original_method = "8B828971EA2E2F12F8B254DF3483012F", hash_generated_method = "B1781F278C3D98D31AF6842B161CEBF0")
    private boolean nativeUpdateLayers(int nativeClass, int baseLayer) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1640858835 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1640858835;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.673 -0400", hash_original_method = "35C4B35D5036F5DD5E458797A063F760", hash_generated_method = "687C3FA85FA1D50BD18004A2FEE838FA")
    private void nativeNotifyAnimationStarted(int nativeClass) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.673 -0400", hash_original_method = "73C7C1AE1D8DFCB366E36E3A519B57F0", hash_generated_method = "5482297BF7ED9B6FCAA5FF62562F970D")
    private boolean nativeFocusBoundsChanged() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1335976845 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1335976845;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.673 -0400", hash_original_method = "7060C98AD2B6D1D27FBDA877BC7BC75F", hash_generated_method = "3B45D715CF03C416DA4BB8F6A27DA159")
    private void nativeSplitContent(int content) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.673 -0400", hash_original_method = "0325F1899906FABB340645FF6A74C4CF", hash_generated_method = "F54F34221CD45A31B538B389FACCA582")
    private boolean nativeKey(int keyCode, int unichar,
            int repeatCount, boolean isShift, boolean isAlt, boolean isSym,
            boolean isDown) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1386069684 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1386069684;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.674 -0400", hash_original_method = "70A418E65E32BB0E515A5AA033BDE85F", hash_generated_method = "62299410B4CE5BEE0EEEE3E27729E36C")
    private void nativeClick(int framePtr, int nodePtr, boolean fake) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.674 -0400", hash_original_method = "71551FF77A19704BFDEA681298A1C532", hash_generated_method = "96C51C5BF4810060E3429C37F0F25D92")
    private void nativeSendListBoxChoices(boolean[] choices, int size) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.674 -0400", hash_original_method = "2618C62A7F157C7D34B87A8252580B1E", hash_generated_method = "83F52EC24953AC93B7D847FDEA82FF7B")
    private void nativeSendListBoxChoice(int choice) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.674 -0400", hash_original_method = "AA6AE3A40C1C9F44C6F8CF239E11299A", hash_generated_method = "31675566573DB236892B4FCBA4C7C5EA")
    private void nativeCloseIdleConnections() {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.675 -0400", hash_original_method = "2A4CBEA83BAEBD0A1BEAE59497423C44", hash_generated_method = "BE2E9CCB70A593FB1109CC268DEF1A23")
    private void nativeSetSize(int width, int height, int textWrapWidth,
            float scale, int screenWidth, int screenHeight, int anchorX,
            int anchorY, boolean ignoreHeight) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.675 -0400", hash_original_method = "2D1706BAD8A7F0247CBA9A3206675903", hash_generated_method = "65D457F2B980F0D20CC8BA9B64671EDC")
    private int nativeGetContentMinPrefWidth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_577327634 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_577327634;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.675 -0400", hash_original_method = "B8EB103A209F8746ABD011DD32864795", hash_generated_method = "F69C5DC5A490D9E76D21779D5FBF41A7")
    private void nativeReplaceTextfieldText(
            int oldStart, int oldEnd, String replace, int newStart, int newEnd,
            int textGeneration) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.675 -0400", hash_original_method = "9A03490EFF94C535BBBC062423FDF770", hash_generated_method = "446D05B07AB3A9158F028041C6C5DA2A")
    private void passToJs(int gen,
            String currentText, int keyCode, int keyValue, boolean down,
            boolean cap, boolean fn, boolean sym) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.675 -0400", hash_original_method = "731A9DE98191A7AE554758463A8E339C", hash_generated_method = "44087B594BD1B68677BC40CF8385BDF9")
    private void nativeSetFocusControllerActive(boolean active) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.676 -0400", hash_original_method = "2F51FDF2CB321B99E6DFA3281F5101CC", hash_generated_method = "96917C21D324BCE357717FAC362E6575")
    private void nativeSaveDocumentState(int frame) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.676 -0400", hash_original_method = "85DD951D7BA7B47A52141773E659FF39", hash_generated_method = "AFC35D779C8E96CBC77A929C17169340")
    private void nativeMoveFocus(int framePtr, int nodePointer) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.676 -0400", hash_original_method = "A6F32C1338CD19726DF22CA448394172", hash_generated_method = "D0F855B66380E1DF1E2A0A33F33CC26A")
    private void nativeMoveMouse(int framePtr, int x, int y) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.677 -0400", hash_original_method = "C235A3B24BC384A4B13E333446CE6D73", hash_generated_method = "1CECEFF87AC709217ADAAC942CCD03E9")
    private void nativeMoveMouseIfLatest(int moveGeneration,
            int framePtr, int x, int y) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.677 -0400", hash_original_method = "241A051A4ABC8D2C1F54A842088CB439", hash_generated_method = "ADDFF51CB4191E5A33B19E9FFF8D0598")
    private String nativeRetrieveHref(int x, int y) {
    	String s = new String ();
    	s.addTaint(taint);
    	return s;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.677 -0400", hash_original_method = "FBE4886E30C0F15C8EE972672B86778C", hash_generated_method = "00676F9B8F3E27C703CEC42462520F49")
    private String nativeRetrieveAnchorText(int x, int y) {
    	String s = new String ();
    	s.addTaint(taint);
    	return s;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.677 -0400", hash_original_method = "7F214D01044FDB7C0A6FFA5743028C76", hash_generated_method = "DF1E348C7A15B8A70CB12B2540802419")
    private String nativeRetrieveImageSource(int x, int y) {
    	String s = new String ();
    	s.addTaint(taint);
    	return s;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.678 -0400", hash_original_method = "88A920F51B60DD8B7CF755C65AD2CD4B", hash_generated_method = "82AFA989ED63A9EC421F618704AFE7DC")
    private void nativeStopPaintingCaret() {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.678 -0400", hash_original_method = "9296BE828873621211792703531EF020", hash_generated_method = "6A59496CA101038C76E1C08CBE3D19C9")
    private void nativeTouchUp(int touchGeneration,
            int framePtr, int nodePtr, int x, int y) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.678 -0400", hash_original_method = "6E256A1C9154CE3109BDE15092BA1E46", hash_generated_method = "B5B9577D58F305A3B87773B898104CE5")
    private boolean nativeHandleTouchEvent(int action, int[] idArray,
            int[] xArray, int[] yArray, int count, int actionIndex, int metaState) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1358016096 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1358016096;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.678 -0400", hash_original_method = "5DF4B15A046A1C8193010BE985610007", hash_generated_method = "8B244E3CBAAF2E7E34F0C84484F4BF37")
    private void nativeUpdateFrameCache() {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.678 -0400", hash_original_method = "9D2250220C9E1A2522A1ED6887AE6CE9", hash_generated_method = "D49669FF53B424D704BA7E41A65708E5")
    private void nativeSetBackgroundColor(int color) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.679 -0400", hash_original_method = "AA3E36FB02CBFB05644F704D8E558646", hash_generated_method = "03FDD117AF1C2A8B5C8D09AD40329F5C")
    private void nativeDumpDomTree(boolean useFile) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.679 -0400", hash_original_method = "BD4BD7606C8F6CEDCA447CEAD83A3B9E", hash_generated_method = "66BD1C1222C4DF40786B8A9BEF2E2C8A")
    private void nativeDumpRenderTree(boolean useFile) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.679 -0400", hash_original_method = "BA54C8246871B46F32623955B4EB301E", hash_generated_method = "BD892AD6C25879A54F4D42D86A23E0BB")
    private void nativeDumpNavTree() {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.679 -0400", hash_original_method = "8B3EC012E68CBA5C936E0A667ADD1C4C", hash_generated_method = "74DC4B2A8E47F0220A502E9F1DCB6173")
    private void nativeDumpV8Counters() {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.679 -0400", hash_original_method = "F3F0788077DAD1F9BFCE6F15D319CC63", hash_generated_method = "76C38A288F460658E3E5A341EF6EB921")
    private void nativeSetJsFlags(String flags) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.680 -0400", hash_original_method = "57BBD8F6823CD4AFC27D90CDB0FA1518", hash_generated_method = "A4FE5693211790B116C8EAFA7D878C74")
    private void nativeDeleteSelection(int start, int end,
            int textGeneration) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.680 -0400", hash_original_method = "E5C6AAA39851A50D9CE3B905BCD5E24D", hash_generated_method = "A2AF046954AC8134C9BB1FAA33476DD4")
    private void nativeSetSelection(int start, int end) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.680 -0400", hash_original_method = "439BD7C80B92A6DF144499531B46441F", hash_generated_method = "1434D7940AC15E588F0AF5B0728E24F9")
    private void nativeRegisterURLSchemeAsLocal(String scheme) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.680 -0400", hash_original_method = "38BB405567582FE2ECD514780CDB4D80", hash_generated_method = "5820102D0D5A33B904EF3D45AF245141")
    private void nativeSetNewStorageLimit(long limit) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.680 -0400", hash_original_method = "FB112EA9A2452AC298500FCFB087229A", hash_generated_method = "935E8D21C0B1E21659AAA61BDFA21FE8")
    private void nativeGeolocationPermissionsProvide(String origin, boolean allow, boolean remember) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.680 -0400", hash_original_method = "26AE2AF434B9C69ABDC8C488B6A433CD", hash_generated_method = "063DA0558EE7FB9CD38DD82A16406D74")
    private void nativeProvideVisitedHistory(String[] history) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.681 -0400", hash_original_method = "7F9DDA20412A0AF9D5E94CA5D5B0BEAA", hash_generated_method = "AA720C4F9758D8D1846FA8601154CB6F")
    private String nativeModifySelection(int direction, int granularity) {
    	String s = new String ();
    	s.addTaint(taint);
    	return s;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.681 -0400", hash_original_method = "D1B7DF7B765695C5C682B348754C5EEE", hash_generated_method = "F1CE17105A07E4CAFDF09BB76101A5C6")
     void stopLoading() {
        {
            mBrowserFrame.stopLoading();
        } 
        
        
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.681 -0400", hash_original_method = "7711F35529A80997737E0C04E1483C72", hash_generated_method = "3405D4CF27FC33344C6F22946E77E7F1")
    public void sendMessage(Message msg) {
        mEventHub.sendMessage(msg);
        addTaint(msg.getTaint());
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.681 -0400", hash_original_method = "E19A847BDC376FCC409B2080F91A4777", hash_generated_method = "888335AE5C7B9CAE78A6F5A7317DAD1C")
     void sendMessage(int what) {
        mEventHub.sendMessage(Message.obtain(null, what));
        addTaint(what);
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.681 -0400", hash_original_method = "3E0AD5D05665DC86C1B2BC352FB304E3", hash_generated_method = "9C83D6A8D50C358CE91429ADD467C686")
     void sendMessage(int what, Object obj) {
        mEventHub.sendMessage(Message.obtain(null, what, obj));
        addTaint(what);
        addTaint(obj.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.682 -0400", hash_original_method = "C23BF0CD5B475AFDE2C5AFE3693DBFAC", hash_generated_method = "1CB6F0ACC6EA94CBB190832F29A4B61E")
     void sendMessage(int what, int arg1) {
        mEventHub.sendMessage(Message.obtain(null, what, arg1, 0));
        addTaint(what);
        addTaint(arg1);
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.682 -0400", hash_original_method = "BB791EA62C0999DDA8C7D0E8B12A435D", hash_generated_method = "DAE58A8DA6ED410EDB71929E38B23D11")
     void sendMessage(int what, int arg1, int arg2) {
        mEventHub.sendMessage(Message.obtain(null, what, arg1, arg2));
        addTaint(what);
        addTaint(arg1);
        addTaint(arg2);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.682 -0400", hash_original_method = "F818943F2C2BA5FC914E03EA08D08398", hash_generated_method = "41B0A32AE88FB9618136951A21E1B9ED")
     void sendMessage(int what, int arg1, Object obj) {
        mEventHub.sendMessage(Message.obtain(null, what, arg1, 0, obj));
        addTaint(what);
        addTaint(arg1);
        addTaint(obj.getTaint());
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.682 -0400", hash_original_method = "6F3BFA4748A47EA8C7E77DF53F526C02", hash_generated_method = "5FC57679205E701498160CA9CDFB7BDC")
     void sendMessage(int what, int arg1, int arg2, Object obj) {
        mEventHub.sendMessage(Message.obtain(null, what, arg1, arg2, obj));
        addTaint(what);
        addTaint(arg1);
        addTaint(arg2);
        addTaint(obj.getTaint());
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.683 -0400", hash_original_method = "D6940867453E54F97589FC877C811177", hash_generated_method = "109D5ACE13A167EB3166CACC50F5782E")
     void sendMessageAtFrontOfQueue(int what, Object obj) {
        mEventHub.sendMessageAtFrontOfQueue(Message.obtain(
                null, what, obj));
        addTaint(what);
        addTaint(obj.getTaint());
        
        
                
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.683 -0400", hash_original_method = "E02AF416600FEDFA3677939C48774A40", hash_generated_method = "208D14B9888583952E28360C7019E3C4")
     void sendMessageDelayed(int what, Object obj, long delay) {
        mEventHub.sendMessageDelayed(Message.obtain(null, what, obj), delay);
        addTaint(what);
        addTaint(obj.getTaint());
        addTaint(delay);
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.683 -0400", hash_original_method = "5A5B79979B60ACD2210356FAD25017D3", hash_generated_method = "8CFACA9EDBA3048B4F61E54C6E2AB8DD")
     void removeMessages(int what) {
        mEventHub.removeMessages(what);
        addTaint(what);
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.683 -0400", hash_original_method = "24F837264907471F101C9345660807F0", hash_generated_method = "4EB910573394E1C2C40C4AC009188F44")
     void removeMessages() {
        mEventHub.removeMessages();
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.683 -0400", hash_original_method = "632CCE7E9EF22DEC0E7940476F7FAE4E", hash_generated_method = "7132B1CE839549CA48285E86C9DBC192")
     void destroy() {
        {
            mEventHub.mDestroying = true;
            mEventHub.sendMessage(
                    Message.obtain(null, EventHub.DESTROY));
            mEventHub.blockMessages();
        } 
        
        
            
            
                    
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.684 -0400", hash_original_method = "4EA5384F21A7BECF7B7E7FDA52086518", hash_generated_method = "1E4D118FD4F4F77A4E150A42A9A67640")
    private void clearCache(boolean includeDiskFiles) {
        mBrowserFrame.clearCache();
        {
            CacheManager.removeAllCacheFiles();
        } 
        addTaint(includeDiskFiles);
        
        
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.684 -0400", hash_original_method = "AA9F9969DB77E536EC07D516D83D1BCB", hash_generated_method = "C6248571311F421449A1C8B79DB2BE97")
    private void loadUrl(String url, Map<String, String> extraHeaders) {
        mBrowserFrame.loadUrl(url, extraHeaders);
        addTaint(url.getTaint());
        addTaint(extraHeaders.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.685 -0400", hash_original_method = "39AB37F211BE7296755FEECD44D0BABF", hash_generated_method = "12AF5E5A6C409D4CA0EAB97664ABACD6")
    private String saveWebArchive(String filename, boolean autoname) {
        String varB4EAC82CA7396A68D541C85D26508E83_1379773652 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1379773652 = mBrowserFrame.saveWebArchive(filename, autoname);
        addTaint(filename.getTaint());
        addTaint(autoname);
        varB4EAC82CA7396A68D541C85D26508E83_1379773652.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1379773652;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.685 -0400", hash_original_method = "E69496F6C06CA8A97AAA7658612739AE", hash_generated_method = "4A237C68420CD5EF43A370A4A6354899")
    private void key(KeyEvent evt, boolean isDown) {
        int keyCode = evt.getKeyCode();
        int unicodeChar = evt.getUnicodeChar();
        {
            boolean var629113EB419C0BB3B95DA845CC8A58D9_1169898918 = (keyCode == KeyEvent.KEYCODE_UNKNOWN && evt.getCharacters() != null
                && evt.getCharacters().length() > 0);
            {
                unicodeChar = evt.getCharacters().codePointAt(0);
            } 
        } 
        {
            boolean varB7AF9169DA51A962128A0C1EE416A901_1030236274 = (!nativeKey(keyCode, unicodeChar, evt.getRepeatCount(), evt.isShiftPressed(),
                evt.isAltPressed(), evt.isSymPressed(),
                isDown) && keyCode != KeyEvent.KEYCODE_ENTER);
            {
                {
                    {
                        boolean var54B618AB61CB605F60CDFD0F53771954_1612718860 = (mWebView != null && evt.isDown());
                        {
                            Message.obtain(mWebView.mPrivateHandler,
                            WebView.UNHANDLED_NAV_KEY, keyCode,
                            0).sendToTarget();
                        } 
                    } 
                } 
                mCallbackProxy.onUnhandledKeyEvent(evt);
            } 
        } 
        addTaint(evt.getTaint());
        addTaint(isDown);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.687 -0400", hash_original_method = "946C6245DADFE1E4F7C078AC5EFCBE5B", hash_generated_method = "61449077E4F261EB229082E52B144573")
    private void viewSizeChanged(WebView.ViewSizeData data) {
        int w = data.mWidth;
        int h = data.mHeight;
        int textwrapWidth = data.mTextWrapWidth;
        float scale = data.mScale;
        int width = calculateWindowWidth(w);
        int height = h;
        {
            float heightWidthRatio = data.mHeightWidthRatio;
            float ratio;
            ratio = heightWidthRatio;
            ratio = (float) h / w;
            height = Math.round(ratio * width);
        } 
        nativeSetSize(width, height, textwrapWidth, scale, w,
                data.mActualViewHeight > 0 ? data.mActualViewHeight : h,
                data.mAnchorX, data.mAnchorY, data.mIgnoreHeight);
        boolean needInvalidate = (mCurrentViewWidth == 0);
        mCurrentViewWidth = w;
        mCurrentViewHeight = h;
        mCurrentViewScale = scale;
        {
            contentDraw();
        } 
        mEventHub.sendMessage(Message.obtain(null,
                EventHub.UPDATE_CACHE_AND_TEXT_ENTRY));
        addTaint(data.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.688 -0400", hash_original_method = "D41B819EC6CC76FA3A89B783D40CD109", hash_generated_method = "98103B130F92A077F84ACF310DB2989A")
    private int calculateWindowWidth(int viewWidth) {
        int width = viewWidth;
        {
            boolean var3757732773C9DA3C82C0E4C387210297_1154720508 = (mSettings.getUseWideViewPort());
            {
                {
                    width = WebView.DEFAULT_VIEWPORT_WIDTH;
                } 
                {
                    width = mViewportWidth;
                } 
                {
                    width = Math.round(mWebView.getViewWidth() / mWebView.getDefaultZoomScale());
                } 
            } 
        } 
        addTaint(viewWidth);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1052505412 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1052505412;
        
        
        
            
                
            
                
            
                
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.688 -0400", hash_original_method = "261CDCDC6F5C121338E8B1C49F51F57D", hash_generated_method = "7D15B5B8FCE7F9110E7559E6E5BB85FA")
    private void sendUpdateTextEntry() {
        {
            Message.obtain(mWebView.mPrivateHandler,
                    WebView.UPDATE_TEXT_ENTRY_MSG_ID).sendToTarget();
        } 
        
        
            
                    
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.695 -0400", hash_original_method = "C9A09E0BE5548FD8F21659E9C96899A7", hash_generated_method = "C836B23EFD2134F98AC9CC29D6429BC6")
    private long getUsedQuota() {
        WebStorage webStorage = WebStorage.getInstance();
        Collection<WebStorage.Origin> origins = webStorage.getOriginsSync();
        long usedQuota = 0;
        {
            Iterator<WebStorage.Origin> var947ACF580B48AA109FD95C7D4B051270_1794770993 = (origins).iterator();
            var947ACF580B48AA109FD95C7D4B051270_1794770993.hasNext();
            WebStorage.Origin website = var947ACF580B48AA109FD95C7D4B051270_1794770993.next();
            {
                usedQuota += website.getQuota();
            } 
        } 
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1643882935 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1643882935;
        
        
        
        
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.696 -0400", hash_original_method = "5A8A60F9907CD1F32895929FD9CD4B62", hash_generated_method = "6BF11002AAD7A4E0CFDB0DA1DED388BC")
     void splitContent(int content) {
        {
            mSplitPictureIsScheduled = true;
            sendMessage(EventHub.SPLIT_PICTURE_SET, content, 0);
        } 
        addTaint(content);
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.696 -0400", hash_original_method = "16C23BC9F883695D8B710B8E94BB257A", hash_generated_method = "0E2A12269754EBF15098BEAF9F93C0F8")
    private void webkitDrawLayers() {
        mDrawLayersIsScheduled = false;
        {
            removeMessages(EventHub.WEBKIT_DRAW);
            webkitDraw();
        } 
        {
            boolean var039A9D9A35DD87BA5CA4F1479333A022_458561065 = (nativeUpdateLayers(mNativeClass, mLastDrawData.mBaseLayer));
            {
                webkitDraw();
            } 
        } 
        mWebView.mPrivateHandler.removeMessages(WebView.INVAL_RECT_MSG_ID);
        mWebView.mPrivateHandler.sendMessageAtFrontOfQueue(mWebView.mPrivateHandler
                .obtainMessage(WebView.INVAL_RECT_MSG_ID));
        
        
        
            
            
            
        
        
            
        
        
        
                
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.697 -0400", hash_original_method = "BB9CB43D2CFBC69EF1EE145BAE6ACA31", hash_generated_method = "14B354E66546E597D8415E1DCF804B13")
    private void webkitDraw() {
        mDrawIsScheduled = false;
        DrawData draw = new DrawData();
        draw.mBaseLayer = nativeRecordContent(draw.mInvalRegion, draw.mContentSize);
        {
            {
                boolean var91328F1EF17FDBCA677D8BD72BECFE5F_1289865291 = (mWebView != null && !mWebView.isPaused());
                {
                    mEventHub.sendMessage(Message.obtain(null, EventHub.WEBKIT_DRAW));
                } 
            } 
        } 
        mLastDrawData = draw;
        webkitDraw(draw);
        
        
        
        
        
        
            
                
                
            
                
            
            
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.698 -0400", hash_original_method = "9C55B9902567F10864019D1DAA55A307", hash_generated_method = "D84DFBDE76ADBA1B9C2BBF12764F6193")
    private void webkitDraw(DrawData draw) {
        {
            draw.mFocusSizeChanged = nativeFocusBoundsChanged();
            draw.mViewSize = new Point(mCurrentViewWidth, mCurrentViewHeight);
            {
                boolean varB1D57029EC09AF271F3C2AF9EE408353_1598320280 = (mSettings.getUseWideViewPort());
                {
                    draw.mMinPrefWidth = Math.max(
                        mViewportWidth == -1 ? WebView.DEFAULT_VIEWPORT_WIDTH
                                : (mViewportWidth == 0 ? mCurrentViewWidth
                                        : mViewportWidth),
                        nativeGetContentMinPrefWidth());
                } 
            } 
            {
                draw.mViewState = mInitialViewState;
                mInitialViewState = null;
            } 
            {
                draw.mFirstLayoutForNonStandardLoad = true;
                mFirstLayoutForNonStandardLoad = false;
            } 
            Message.obtain(mWebView.mPrivateHandler,
                    WebView.NEW_PICTURE_MSG_ID, draw).sendToTarget();
        } 
        
        
    }

    
        @DSModeled(DSC.SAFE)
    static void reducePriority() {
        sWebCoreHandler.removeMessages(WebCoreThread.REDUCE_PRIORITY);
        sWebCoreHandler.removeMessages(WebCoreThread.RESUME_PRIORITY);
        sWebCoreHandler.sendMessageAtFrontOfQueue(sWebCoreHandler
                .obtainMessage(WebCoreThread.REDUCE_PRIORITY));
    }

    
        @DSModeled(DSC.SAFE)
    static void resumePriority() {
        sWebCoreHandler.removeMessages(WebCoreThread.REDUCE_PRIORITY);
        sWebCoreHandler.removeMessages(WebCoreThread.RESUME_PRIORITY);
        sWebCoreHandler.sendMessageAtFrontOfQueue(sWebCoreHandler
                .obtainMessage(WebCoreThread.RESUME_PRIORITY));
    }

    
        @DSModeled(DSC.SPEC)
    static void sendStaticMessage(int messageType, Object argument) {
        if (sWebCoreHandler == null)
            return;
        sWebCoreHandler.sendMessage(sWebCoreHandler.obtainMessage(messageType, argument));
    }

    
        @DSModeled(DSC.SAFE)
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

    
        @DSModeled(DSC.SAFE)
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

    
        @DSModeled(DSC.SAFE)
    static boolean isUpdatePicturePaused(WebViewCore core) {
        return core != null ? core.mDrawIsPaused : false;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.700 -0400", hash_original_method = "F63E17FBEAA6E278B676F177339490F6", hash_generated_method = "DCDC17A3EBA934FE7BA8C6986123CD05")
    private void restoreState(int index) {
        WebBackForwardList list = mCallbackProxy.getBackForwardList();
        int size = list.getSize();
        {
            int i = 0;
            {
                list.getItemAtIndex(i).inflate(mBrowserFrame.mNativeFrame);
            } 
        } 
        mBrowserFrame.mLoadInitFromJava = true;
        list.restoreIndex(mBrowserFrame.mNativeFrame, index);
        mBrowserFrame.mLoadInitFromJava = false;
        addTaint(index);
        
        
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.700 -0400", hash_original_method = "1D90769B244FD8A3CA2CA8B94E1DA948", hash_generated_method = "CEB7BB35954DB2C288C1AEABFC16E552")
     void contentDraw() {
        {
            {
                boolean var9E195732C0279075ECC2E1148458FA76_9387500 = (mCurrentViewWidth == 0 || !mBrowserFrame.firstLayoutDone());
            } 
            mDrawIsScheduled = true;
            mEventHub.sendMessage(Message.obtain(null, EventHub.WEBKIT_DRAW));
        } 
        
        
            
                
            
            
                
            
            
            
            
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.701 -0400", hash_original_method = "A3D463EE1053B0BDD6C0EF630EFBF61E", hash_generated_method = "FB867318FE4B709F20DD39FA1A36D311")
     void layersDraw() {
        {
            mDrawLayersIsScheduled = true;
            mEventHub.sendMessage(Message.obtain(null, EventHub.WEBKIT_DRAW_LAYERS));
        } 
        
        
            
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.701 -0400", hash_original_method = "05930F26D8EA77E9D23F45CCAA386679", hash_generated_method = "CBCB20B65768920127275F593ABDF26F")
    private void contentScrollTo(int x, int y, boolean animate,
            boolean onlyIfImeIsShowing) {
        {
            boolean varCD3A04F2DD4738ECCC7EC3F7D2EDDDFC_1552908494 = (!mBrowserFrame.firstLayoutDone());
            {
                mRestoredX = x;
                mRestoredY = y;
            } 
        } 
        {
            Message msg = Message.obtain(mWebView.mPrivateHandler,
                    WebView.SCROLL_TO_MSG_ID, animate ? 1 : 0,
                    onlyIfImeIsShowing ? 1 : 0, new Point(x, y));
            {
                mEventHub.sendMessage(Message.obtain(null,
                        EventHub.MESSAGE_RELAY, msg));
            } 
            {
                msg.sendToTarget();
            } 
        } 
        addTaint(animate);
        addTaint(onlyIfImeIsShowing);
        
        
            
            
            
        
        
            
                    
                    
            
                
                        
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.702 -0400", hash_original_method = "064E6EE33123304FAB79F7D8FF122B00", hash_generated_method = "D2A66E2772700B0B57D485704C266B9A")
    private void sendNotifyProgressFinished() {
        sendUpdateTextEntry();
        {
            boolean var0C0A67311072ACF9A11F251AEC847BBE_1500476616 = (!JniUtil.useChromiumHttpStack());
            {
                WebViewWorker.getHandler().removeMessages(
                    WebViewWorker.MSG_CACHE_TRANSACTION_TICKER);
                WebViewWorker.getHandler().sendEmptyMessage(
                    WebViewWorker.MSG_CACHE_TRANSACTION_TICKER);
            } 
        } 
        contentDraw();
        
        
        
            
                    
            
                    
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.702 -0400", hash_original_method = "05A7A351E8C6AEA76F720C36B865E14E", hash_generated_method = "765302561E864E771B3A805F53A86B58")
    private void sendViewInvalidate(int left, int top, int right, int bottom) {
        {
            Message.obtain(mWebView.mPrivateHandler,
                           WebView.INVAL_RECT_MSG_ID,
                           new Rect(left, top, right, bottom)).sendToTarget();
        } 
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        
        
            
                           
                           
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.702 -0400", hash_original_method = "BF48D6F46DE128F968473CE7B0F81CDD", hash_generated_method = "3BC68C12777C31B302D2AC712929E186")
     void signalRepaintDone() {
        mRepaintScheduled = false;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.703 -0400", hash_original_method = "D61E1D458239E8CEF9B36F4B5C04FED9", hash_generated_method = "EE15D5909492C94311936DD06B44161E")
     WebView getWebView() {
        WebView varB4EAC82CA7396A68D541C85D26508E83_729969469 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_729969469 = mWebView;
        varB4EAC82CA7396A68D541C85D26508E83_729969469.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_729969469;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.703 -0400", hash_original_method = "C2675483324447340D13F3ECB1B2D597", hash_generated_method = "A544BAF547AB24CC48D69ED497DB507A")
    private void setViewportSettingsFromNative() {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.703 -0400", hash_original_method = "7A9CDB44172FF868DD9DADCEEAD05D82", hash_generated_method = "0CD953CF8B3030301131E70AA43F1E5C")
    private void didFirstLayout(boolean standardLoad) {
        mBrowserFrame.didFirstLayout();
        boolean updateViewState = standardLoad || mIsRestored;
        setupViewport(updateViewState);
        {
            mWebView.mViewManager.postReadyToDrawAll();
        } 
        {
            boolean varF62A4D41575FA673A4E6CD9E1EF24EDD_521072046 = (WebView.USE_WEBKIT_RINGS || getSettings().supportTouchOnly());
            {
                mWebView.mPrivateHandler.sendEmptyMessage(
                    WebView.SET_TOUCH_HIGHLIGHT_RECTS);
            } 
        } 
        mRestoredX = mRestoredY = 0;
        mIsRestored = false;
        mRestoredScale = mRestoredTextWrapScale = 0;
        addTaint(standardLoad);
        
        
            
        
        
        
        
        
        
            
        
        
            
                    
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.704 -0400", hash_original_method = "A32352A77D85042345402A4E856F6371", hash_generated_method = "1068B405466FDB182CCA070760A4D34B")
    private void updateViewport() {
        setupViewport(true);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.707 -0400", hash_original_method = "D5D0316515645CA1EE6304290B6F23F6", hash_generated_method = "B9A58816FF2E4CCE3337718AED475F02")
    private void setupViewport(boolean updateViewState) {
        setViewportSettingsFromNative();
        {
            {
                mViewportInitialScale = Math.max(mViewportInitialScale,
                        mViewportMinimumScale);
            } 
            {
                mViewportInitialScale = Math.min(mViewportInitialScale,
                        mViewportMaximumScale);
            } 
        } 
        {
            boolean var2C40C72ED9495C662481F10E1A7BC080_356292012 = (mSettings.forceUserScalable());
            {
                mViewportUserScalable = true;
                {
                    {
                        mViewportMinimumScale = Math.min(mViewportMinimumScale,
                            mViewportInitialScale / 2);
                    } 
                    {
                        mViewportMaximumScale = Math.max(mViewportMaximumScale,
                            mViewportInitialScale * 2);
                    } 
                } 
                {
                    {
                        mViewportMinimumScale = Math.min(mViewportMinimumScale, 50);
                    } 
                    {
                        mViewportMaximumScale = Math.max(mViewportMaximumScale, 200);
                    } 
                } 
            } 
        } 
        float adjust = 1.0f;
        {
            {
                boolean var095106DB1305D8C0DF73B5AC45213B00_414677661 = (mWebView != null && (int)(mWebView.getDefaultZoomScale() * 100) != 100);
                {
                    adjust = mWebView.getDefaultZoomScale();
                } 
            } 
        } 
        {
            adjust = (float) mContext.getResources().getDisplayMetrics().densityDpi
                    / mViewportDensityDpi;
        } 
        {
            boolean varAA9F420BC13982494ED8D1FAB46D4380_173106603 = (adjust != mWebView.getDefaultZoomScale());
            {
                Message.obtain(mWebView.mPrivateHandler,
                    WebView.UPDATE_ZOOM_DENSITY, adjust).sendToTarget();
            } 
        } 
        int defaultScale = (int) (adjust * 100);
        {
            mViewportInitialScale *= adjust;
        } 
        {
            mViewportMinimumScale *= adjust;
        } 
        {
            mViewportMaximumScale *= adjust;
        } 
        {
            {
                mViewportInitialScale = defaultScale;
            } 
        } 
        {
            mViewportInitialScale = defaultScale;
            mViewportMinimumScale = defaultScale;
            mViewportMaximumScale = defaultScale;
        } 
        {
            mViewportMinimumScale = mViewportInitialScale;
        } 
        {
            mViewportMaximumScale = mViewportInitialScale;
        } 
        {
            mViewportWidth = 0;
        } 
        {
            mFirstLayoutForNonStandardLoad = true;
            ViewState viewState = new ViewState();
            viewState.mMinScale = mViewportMinimumScale / 100.0f;
            viewState.mMaxScale = mViewportMaximumScale / 100.0f;
            viewState.mDefaultScale = adjust;
            viewState.mMobileSite = false;
            viewState.mScrollX = 0;
            viewState.mShouldStartScrolledRight = false;
            Message.obtain(mWebView.mPrivateHandler,
                    WebView.UPDATE_ZOOM_RANGE, viewState).sendToTarget();
        } 
        int webViewWidth;
        int viewportWidth = mCurrentViewWidth;
        {
            webViewWidth = mWebView.getViewWidth();
            viewportWidth = (int) (webViewWidth / adjust);
        } 
        {
            webViewWidth = Math.round(viewportWidth * mCurrentViewScale);
        } 
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
            } 
            {
                mInitialViewState.mTextWrapScale = mInitialViewState.mViewScale;
            } 
        } 
        {
            {
                mInitialViewState.mViewScale = mInitialViewState.mTextWrapScale =
                        mViewportInitialScale / 100.0f;
            } 
            {
                boolean varDEB9F10F1388468BDE78E7CEBFF00566_801390388 = (mViewportWidth > 0 && mViewportWidth < webViewWidth &&
                !getSettings().getUseFixedViewport());
                {
                    mInitialViewState.mViewScale = mInitialViewState.mTextWrapScale =
                        (float) webViewWidth / mViewportWidth;
                } 
                {
                    mInitialViewState.mTextWrapScale = adjust;
                    {
                        boolean varA6856BD93D50A87AC1D99B72D3E49073_462521014 = (mSettings.getUseWideViewPort());
                        {
                            mInitialViewState.mViewScale = 0;
                        } 
                        {
                            mInitialViewState.mViewScale = adjust;
                        } 
                    } 
                } 
            } 
        } 
        {
            mWebView.mLastHeightSent = 0;
            WebView.ViewSizeData data = new WebView.ViewSizeData();
            data.mWidth = mWebView.mLastWidthSent;
            data.mHeight = 0;
            data.mTextWrapWidth = data.mWidth;
            data.mScale = -1.0f;
            data.mIgnoreHeight = false;
            data.mAnchorX = data.mAnchorY = 0;
            mEventHub.removeMessages(EventHub.VIEW_SIZE_CHANGED);
            mEventHub.sendMessageAtFrontOfQueue(Message.obtain(null,
                    EventHub.VIEW_SIZE_CHANGED, data));
        } 
        {
            {
                mWebView.mLastWidthSent = 0;
            } 
            {
                WebView.ViewSizeData data = new WebView.ViewSizeData();
                float tentativeScale = mInitialViewState.mViewScale;
                {
                    tentativeScale = mInitialViewState.mTextWrapScale;
                    int tentativeViewWidth = Math.round(webViewWidth / tentativeScale);
                    int windowWidth = calculateWindowWidth(tentativeViewWidth);
                    data.mScale = (float) webViewWidth / windowWidth;
                    {
                        boolean var702626CF71171EB0C8490DD1835B6456_1010008512 = (!mSettings.getLoadWithOverviewMode());
                        {
                            data.mScale = Math.max(data.mScale, tentativeScale);
                        } 
                    } 
                    {
                        boolean var4472321233F900C5CC1F3910B5372E99_715678035 = (mSettings.isNarrowColumnLayout());
                        {
                            mInitialViewState.mTextWrapScale =
                                mWebView.getReadingLevelScale();
                        } 
                    } 
                } 
                {
                    data.mScale = tentativeScale;
                } 
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
            } 
        } 
        addTaint(updateViewState);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.708 -0400", hash_original_method = "6F3A82A96A28D1D6CB79A2B2419B2F76", hash_generated_method = "6106458B76BB5D28F97A0582B087BD7D")
    private void restoreScale(float scale, float textWrapScale) {
        {
            boolean varD35BFC1537D634CBB5B2C1FDA9291321_1518416829 = (mBrowserFrame.firstLayoutDone() == false);
            {
                mIsRestored = true;
                mRestoredScale = scale;
                {
                    boolean var4BFA491A55D7EADB3D22EDD12F06D767_1674011047 = (mSettings.getUseWideViewPort());
                    {
                        mRestoredTextWrapScale = textWrapScale;
                    } 
                } 
            } 
        } 
        
        
            
            
            
                
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.709 -0400", hash_original_method = "F9FDE50E9F3FDE0981BF3551CCB9A219", hash_generated_method = "88A9E365379F793A0A12045678209B2E")
    private void needTouchEvents(boolean need) {
        {
            Message.obtain(mWebView.mPrivateHandler,
                    WebView.WEBCORE_NEED_TOUCH_EVENTS, need ? 1 : 0, 0)
                    .sendToTarget();
        } 
        addTaint(need);
        
        
            
                    
                    
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.709 -0400", hash_original_method = "117690D9297C0397B62CA4A9AAF175F7", hash_generated_method = "6CE8807213CABB2CBBE3A70BD433B8BC")
    private void updateTextfield(int ptr, boolean changeToPassword,
            String text, int textGeneration) {
        {
            Message msg = Message.obtain(mWebView.mPrivateHandler,
                    WebView.UPDATE_TEXTFIELD_TEXT_MSG_ID, ptr,
                    textGeneration, text);
            msg.getData().putBoolean("password", changeToPassword);
            msg.sendToTarget();
        } 
        addTaint(ptr);
        addTaint(changeToPassword);
        addTaint(text.getTaint());
        addTaint(textGeneration);
        
        
            
                    
                    
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.710 -0400", hash_original_method = "4C7D3AD0862D2CA84FE64B9856BAA28B", hash_generated_method = "DD9B3C063DDD2F0B02BDB608A414B726")
    private void updateTextSelection(int pointer, int start, int end,
            int textGeneration) {
        {
            Message.obtain(mWebView.mPrivateHandler,
                WebView.UPDATE_TEXT_SELECTION_MSG_ID, pointer, textGeneration,
                new TextSelectionData(start, end)).sendToTarget();
        } 
        addTaint(pointer);
        addTaint(start);
        addTaint(end);
        addTaint(textGeneration);
        
        
            
                
                
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.710 -0400", hash_original_method = "C4BB5E4EA56AD7707D8515F7F4BEC247", hash_generated_method = "6D3322017AAF9488D423867036C5988F")
    private void clearTextEntry() {
        Message.obtain(mWebView.mPrivateHandler,
                WebView.CLEAR_TEXT_ENTRY).sendToTarget();
        
        
        
                
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.711 -0400", hash_original_method = "862481A256A95A2E1B26E19ED8AB682F", hash_generated_method = "8FA3E94989B7908AC2EFBFFCF957D5BE")
    private void sendFindAgain() {
        Message.obtain(mWebView.mPrivateHandler,
                WebView.FIND_AGAIN).sendToTarget();
        
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.711 -0400", hash_original_method = "1F73AE1CA1E2566920108C9D357DD01C", hash_generated_method = "811F89392751DB56E9E28BDF266564E7")
    private void nativeUpdateFrameCacheIfLoading() {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.711 -0400", hash_original_method = "F955ECFDACE0CC28D366B33E5FEC0536", hash_generated_method = "A821BAA64C8E20BCC154BA5A5E1AC6C2")
    private void nativeRevealSelection() {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.711 -0400", hash_original_method = "D72E3E2D187EE0995228637414D15F8B", hash_generated_method = "77A50DA793DDA2062D397DD558B3E833")
    private String nativeRequestLabel(int framePtr, int nodePtr) {
    	String s = new String ();
    	s.addTaint(taint);
    	return s;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.712 -0400", hash_original_method = "CDA0A8C6D295040926E78ABE78DD6146", hash_generated_method = "2C165711E20276C4B0E19E78026A11B0")
    private void nativeScrollFocusedTextInput(float xPercent, int y) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.712 -0400", hash_original_method = "E13D9D9BB267DB78AE29574F59D715C7", hash_generated_method = "CB28B5DE268EE4C9CD7681B2BFD5A13C")
    private void nativeSetScrollOffset(int gen, boolean sendScrollEvent, int dx, int dy) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.712 -0400", hash_original_method = "1D56EADE7E65827B4B9A4C6FC3F7D192", hash_generated_method = "B0102F6A9192DAA1337D2BE088053557")
    private void nativeSetGlobalBounds(int x, int y, int w, int h) {
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.712 -0400", hash_original_method = "AECCF0A7E8C40F57D58CA373D809DB0E", hash_generated_method = "FAEB65CFBFAA197C3CE71DF0DECC8282")
    private void requestListBox(String[] array, int[] enabledArray,
            int[] selectedArray) {
        {
            mWebView.requestListBox(array, enabledArray, selectedArray);
        } 
        addTaint(array[0].getTaint());
        addTaint(enabledArray[0]);
        addTaint(selectedArray[0]);
        
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.713 -0400", hash_original_method = "9DBC344B8D87A71D6BD3CB15F0701F64", hash_generated_method = "5FEF4FCFC0792B9C49EBD77C8B4E57E6")
    private void requestListBox(String[] array, int[] enabledArray,
            int selection) {
        {
            mWebView.requestListBox(array, enabledArray, selection);
        } 
        addTaint(array[0].getTaint());
        addTaint(enabledArray[0]);
        addTaint(selection);
        
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.713 -0400", hash_original_method = "2EB26549510C49A5C07788F5DA665EE0", hash_generated_method = "FA4EAF197F0989DC95337A6CB677D7DD")
    private void requestKeyboardWithSelection(int pointer, int selStart,
            int selEnd, int textGeneration) {
        {
            Message.obtain(mWebView.mPrivateHandler,
                    WebView.REQUEST_KEYBOARD_WITH_SELECTION_MSG_ID, pointer,
                    textGeneration, new TextSelectionData(selStart, selEnd))
                    .sendToTarget();
        } 
        addTaint(pointer);
        addTaint(selStart);
        addTaint(selEnd);
        addTaint(textGeneration);
        
        
            
                    
                    
                    
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.713 -0400", hash_original_method = "C7739CA97531242F19EB30C6F079B5B2", hash_generated_method = "BB1A34F786E4377363389440B90483F5")
    private void requestKeyboard(boolean showKeyboard) {
        {
            Message.obtain(mWebView.mPrivateHandler,
                    WebView.REQUEST_KEYBOARD, showKeyboard ? 1 : 0, 0)
                    .sendToTarget();
        } 
        addTaint(showKeyboard);
        
        
            
                    
                    
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.714 -0400", hash_original_method = "DC8BC22A6F75F1D5B407274C2907FB6A", hash_generated_method = "6FAE3D8318BB7FE914A9CF34FD43AB3E")
    private void setWebTextViewAutoFillable(int queryId, String preview) {
        {
            Message.obtain(mWebView.mPrivateHandler, WebView.SET_AUTOFILLABLE,
                    new AutoFillData(queryId, preview))
                    .sendToTarget();
        } 
        addTaint(queryId);
        addTaint(preview.getTaint());
        
        
            
                    
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.714 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "8784C66C2D5528B9C8973E7B96ACE6A3")
     Context getContext() {
        Context varB4EAC82CA7396A68D541C85D26508E83_806428528 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_806428528 = mContext;
        varB4EAC82CA7396A68D541C85D26508E83_806428528.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_806428528;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.715 -0400", hash_original_method = "06D3F71D264B84B5441A889608149189", hash_generated_method = "904970B6E806A2E5374D4392946508FA")
    private void keepScreenOn(boolean screenOn) {
        {
            Message message = mWebView.mPrivateHandler.obtainMessage(WebView.SCREEN_ON);
            message.arg1 = screenOn ? 1 : 0;
            message.sendToTarget();
        } 
        addTaint(screenOn);
        
        
            
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.716 -0400", hash_original_method = "10FFBA7C056FD6BA9A1C610F1A172C8D", hash_generated_method = "976BE1E453CCE4C21039EE1A7370DEB9")
    private Class<?> getPluginClass(String libName, String clsName) {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_639387006 = null; 
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_2019132107 = null; 
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_152953667 = null; 
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_1660937935 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_639387006 = null;
        } 
        PluginManager pluginManager = PluginManager.getInstance(null);
        String pkgName = pluginManager.getPluginsAPKName(libName);
        {
            varB4EAC82CA7396A68D541C85D26508E83_2019132107 = null;
        } 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_152953667 = pluginManager.getPluginClass(pkgName, clsName);
        } 
        catch (NameNotFoundException e)
        { }
        catch (ClassNotFoundException e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_1660937935 = null;
        addTaint(libName.getTaint());
        addTaint(clsName.getTaint());
        Class<?> varA7E53CE21691AB073D9660D615818899_565760482; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_565760482 = varB4EAC82CA7396A68D541C85D26508E83_639387006;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_565760482 = varB4EAC82CA7396A68D541C85D26508E83_2019132107;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_565760482 = varB4EAC82CA7396A68D541C85D26508E83_152953667;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_565760482 = varB4EAC82CA7396A68D541C85D26508E83_1660937935;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_565760482.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_565760482;
        
        
            
        
        
        
        
            
            
        
        
            
        
            
        
            
                    
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.716 -0400", hash_original_method = "56D58B33C48E10C4B09153457527EDE8", hash_generated_method = "5FDE654FDDA99F475C1AE049E1EC2C3E")
    private void showFullScreenPlugin(ViewManager.ChildView childView, int orientation, int npp) {
        Message message = mWebView.mPrivateHandler.obtainMessage(WebView.SHOW_FULLSCREEN);
        message.obj = childView.mView;
        message.arg1 = orientation;
        message.arg2 = npp;
        message.sendToTarget();
        addTaint(childView.getTaint());
        addTaint(orientation);
        addTaint(npp);
        
        
            
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.717 -0400", hash_original_method = "98BEE7CF6CD4E23C3FBAA61970F9B21C", hash_generated_method = "17095E7CD399502293E2AFE11736CEEB")
    private void hideFullScreenPlugin() {
        mWebView.mPrivateHandler.obtainMessage(WebView.HIDE_FULLSCREEN)
                .sendToTarget();
        
        
            
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.719 -0400", hash_original_method = "A3E933C7DAB8D83D100D1E88122325C7", hash_generated_method = "62830653F3E42E14200B6DEFB8017606")
    private ViewManager.ChildView createSurface(View pluginView) {
        ViewManager.ChildView varB4EAC82CA7396A68D541C85D26508E83_1432313348 = null; 
        ViewManager.ChildView varB4EAC82CA7396A68D541C85D26508E83_1207698516 = null; 
        ViewManager.ChildView varB4EAC82CA7396A68D541C85D26508E83_15580650 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1432313348 = null;
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1207698516 = null;
        } 
        pluginView.setWillNotDraw(false);
        ((SurfaceView)pluginView).setZOrderOnTop(true);
        ViewManager.ChildView view = mWebView.mViewManager.createView();
        view.mView = pluginView;
        varB4EAC82CA7396A68D541C85D26508E83_15580650 = view;
        addTaint(pluginView.getTaint());
        ViewManager.ChildView varA7E53CE21691AB073D9660D615818899_592200828; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_592200828 = varB4EAC82CA7396A68D541C85D26508E83_1432313348;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_592200828 = varB4EAC82CA7396A68D541C85D26508E83_1207698516;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_592200828 = varB4EAC82CA7396A68D541C85D26508E83_15580650;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_592200828.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_592200828;
        
        
            
        
        
            
            
        
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.719 -0400", hash_original_method = "97AE1F230CE0C97985778B5B23111878", hash_generated_method = "FA6A3925A341DEFB9DE87845233026DD")
    private ViewManager.ChildView addSurface(View pluginView, int x, int y,
                                             int width, int height) {
        ViewManager.ChildView varB4EAC82CA7396A68D541C85D26508E83_2051570238 = null; 
        ViewManager.ChildView view = createSurface(pluginView);
        view.attachView(x, y, width, height);
        varB4EAC82CA7396A68D541C85D26508E83_2051570238 = view;
        addTaint(pluginView.getTaint());
        addTaint(x);
        addTaint(y);
        addTaint(width);
        addTaint(height);
        varB4EAC82CA7396A68D541C85D26508E83_2051570238.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2051570238;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.719 -0400", hash_original_method = "75F4F4C2028D65C3C8554ED4635C74ED", hash_generated_method = "5F5AC011B6209DE53E9D31B8723C2038")
    private void updateSurface(ViewManager.ChildView childView, int x, int y,
            int width, int height) {
        childView.attachView(x, y, width, height);
        addTaint(childView.getTaint());
        addTaint(x);
        addTaint(y);
        addTaint(width);
        addTaint(height);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.720 -0400", hash_original_method = "416DFEE1629652841DDA085C9B0D0611", hash_generated_method = "E6B50BB4E4336EBDB5E435C77B5DC753")
    private void destroySurface(ViewManager.ChildView childView) {
        childView.removeView();
        addTaint(childView.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.720 -0400", hash_original_method = "22185D2849BB84C82B1605DF19FAA2EB", hash_generated_method = "155909D2B020C2FED4A7EBE6A553914F")
    private void showRect(int left, int top, int width, int height,
            int contentWidth, int contentHeight, float xPercentInDoc,
            float xPercentInView, float yPercentInDoc, float yPercentInView) {
        {
            ShowRectData data = new ShowRectData();
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
        } 
        addTaint(left);
        addTaint(top);
        addTaint(width);
        addTaint(height);
        addTaint(contentWidth);
        addTaint(contentHeight);
        addTaint(xPercentInDoc);
        addTaint(xPercentInView);
        addTaint(yPercentInDoc);
        addTaint(yPercentInView);
        
        
            
            
            
            
            
            
            
            
            
            
            
            
                    
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.721 -0400", hash_original_method = "1DA5EF32A9FA7AF08D14A38F102400D4", hash_generated_method = "14FF1544425D83ED0403051112314F7A")
    private void centerFitRect(int x, int y, int width, int height) {
        mWebView.mPrivateHandler.obtainMessage(WebView.CENTER_FIT_RECT,
                new Rect(x, y, x + width, y + height)).sendToTarget();
        addTaint(x);
        addTaint(y);
        addTaint(width);
        addTaint(height);
        
        
            
        
        
                
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.721 -0400", hash_original_method = "D8FA837CEB894605C45672F0DC41EFFC", hash_generated_method = "D5C4557214274D4B7A6B90A1C97EC1E7")
    private void setScrollbarModes(int hMode, int vMode) {
        mWebView.mPrivateHandler.obtainMessage(WebView.SET_SCROLLBAR_MODES,
                hMode, vMode).sendToTarget();
        addTaint(hMode);
        addTaint(vMode);
        
        
            
        
        
                
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.721 -0400", hash_original_method = "07DD7AFD4B9B08AAE72EF7B16777A3F8", hash_generated_method = "6B22B3B552A58A938865DA7EA5D03D41")
    @SuppressWarnings("unused")
    private void selectAt(int x, int y) {
        {
            mWebView.mPrivateHandler.obtainMessage(WebView.SELECT_AT, x, y).sendToTarget();
        } 
        addTaint(x);
        addTaint(y);
        
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.722 -0400", hash_original_method = "6A70D904110AF22683C1DB763A75BE10", hash_generated_method = "A305859D91500836C604DC6AC8AB2802")
    private void useMockDeviceOrientation() {
        mDeviceMotionAndOrientationManager.useMock();
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.722 -0400", hash_original_method = "F3DDD41A8D23B4AE9E9585A561AEE4C2", hash_generated_method = "E2D9D772C2CAA3469C277EB35DCD20B7")
    public void setMockDeviceOrientation(boolean canProvideAlpha, double alpha,
            boolean canProvideBeta, double beta, boolean canProvideGamma, double gamma) {
        mDeviceMotionAndOrientationManager.setMockOrientation(canProvideAlpha, alpha,
                canProvideBeta, beta, canProvideGamma, gamma);
        addTaint(canProvideAlpha);
        addTaint(alpha);
        addTaint(canProvideBeta);
        addTaint(beta);
        addTaint(canProvideGamma);
        addTaint(gamma);
        
        
                
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.723 -0400", hash_original_method = "2C35CA4A669368B8EA54C6F975558D19", hash_generated_method = "D4BE03648A8288377DC02A00EABF949C")
    protected DeviceMotionService getDeviceMotionService() {
        DeviceMotionService varB4EAC82CA7396A68D541C85D26508E83_927003992 = null; 
        {
            mDeviceMotionService =
                    new DeviceMotionService(mDeviceMotionAndOrientationManager, mContext);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_927003992 = mDeviceMotionService;
        varB4EAC82CA7396A68D541C85D26508E83_927003992.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_927003992;
        
        
            
                    
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.723 -0400", hash_original_method = "C07B296E9A86FE4EA87FDBAE8692F74E", hash_generated_method = "5D601DDFF0D2B65A8F5E39B975B9D8C2")
    protected DeviceOrientationService getDeviceOrientationService() {
        DeviceOrientationService varB4EAC82CA7396A68D541C85D26508E83_1802570908 = null; 
        {
            mDeviceOrientationService =
                    new DeviceOrientationService(mDeviceMotionAndOrientationManager, mContext);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1802570908 = mDeviceOrientationService;
        varB4EAC82CA7396A68D541C85D26508E83_1802570908.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1802570908;
        
        
            
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.723 -0400", hash_original_method = "80A2D6FB8A6209AB3E75A13699D0F2FD", hash_generated_method = "76A2CFB1DECA9D951174463AE36B770E")
    private void nativeSetIsPaused(boolean isPaused) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.724 -0400", hash_original_method = "F7A6503DE7A4FD810E8E9ABDA2EEEB51", hash_generated_method = "CFD63F9A966562DF83D39FABD638C104")
    private void nativePause() {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.724 -0400", hash_original_method = "5AFDAE76FDF49AA60F1B62133763C925", hash_generated_method = "A9F70FC0A49853DDC2A0592633A31EDB")
    private void nativeResume() {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.724 -0400", hash_original_method = "46A442C7F1DFFCFE217C12A7C725FDF0", hash_generated_method = "5E0228F659C8CEAE7B4ED00D196CB7E9")
    private void nativeFreeMemory() {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.724 -0400", hash_original_method = "595EFBC436CD527B994A288C2556204C", hash_generated_method = "BB6FDD1D1FD1CA4B18507B01F8AE57E1")
    private void nativeFullScreenPluginHidden(int npp) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.724 -0400", hash_original_method = "B8577828D04FDB03A48BAD0D20ECEC58", hash_generated_method = "1D9DA186F7D377C5866D2185EAB12428")
    private void nativePluginSurfaceReady() {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.725 -0400", hash_original_method = "47AF89A6298D2CD312EEA7CB7B014D43", hash_generated_method = "A800F7E3718D270A82D35E09D353AC5D")
    private boolean nativeValidNodeAndBounds(int frame, int node,
            Rect bounds) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_949132439 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_949132439;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.725 -0400", hash_original_method = "7FB813C3814F61AA4E8EC557BEB4DCCC", hash_generated_method = "6B922F36DFF8369A6FE3889E21482C11")
    private ArrayList<Rect> nativeGetTouchHighlightRects(int x, int y,
            int slop) {
    	
    	ArrayList<Rect> ret = new ArrayList<>();
    	ret.addTaint(taint);
    	return ret;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.725 -0400", hash_original_method = "6E4751AAEDBCF283C9D69028D1EFBC56", hash_generated_method = "6A09860699B3C4B61638E7A7F130C967")
    private void nativeAutoFillForm(int queryId) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.725 -0400", hash_original_method = "17FE9397F3DCB5CE24853C5F0983B585", hash_generated_method = "E6D0DDF142B83EF3C6533C10C92CF6DF")
    private void nativeScrollLayer(int layer, Rect rect) {
    }

    
    private static class WebCoreThread implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.725 -0400", hash_original_method = "2F45E06CFBCB348B09D51D400BB9B9A9", hash_generated_method = "2F45E06CFBCB348B09D51D400BB9B9A9")
        public WebCoreThread ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.727 -0400", hash_original_method = "82DEF5A0DA884DCAB5C26C3D415DCFF4", hash_generated_method = "B51F8A65C9D2918195FD9F39A78C12DF")
        public void run() {
            Looper.prepare();
            Assert.assertNull(sWebCoreHandler);
            {
                sWebCoreHandler = new Handler() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.727 -0400", hash_original_method = "C9135F359ACD716A893B99167F5F2188", hash_generated_method = "42941B9E4DFD3F358CDB3BE5C8CBCF7C")
                    @Override
                    public void handleMessage(Message msg) {
                        
                        WebViewCore core = (WebViewCore) msg.obj;
                        
                        
                        core.initialize();
                        
                        
                        Process.setThreadPriority(
                                        Process.THREAD_PRIORITY_DEFAULT + 3 *
                                        Process.THREAD_PRIORITY_LESS_FAVORABLE);
                        
                        
                        Process.setThreadPriority(
                                        Process.THREAD_PRIORITY_DEFAULT);
                        
                        
                        {
                            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                                            "No WebView has been created in this process!");
                        } 
                        
                        
                        BrowserFrame.sJavaBridge.addPackageName((String) msg.obj);
                        
                        
                        {
                            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                                            "No WebView has been created in this process!");
                        } 
                        
                        
                        BrowserFrame.sJavaBridge.removePackageName((String) msg.obj);
                        
                        
                        {
                            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                                            "No WebView has been created in this process!");
                        } 
                        
                        
                        BrowserFrame.sJavaBridge.updateProxy((ProxyProperties)msg.obj);
                        
                        addTaint(msg.getTaint());
                        
                        
                    }
};
                WebViewCore.class.notify();
            } 
            Looper.loop();
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.727 -0400", hash_original_field = "7F2F112EDA3A00D8B92E3195C2B202BA", hash_generated_field = "4F713FFA365E563DDF84874CBE5719C1")

        private static final int INITIALIZE = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.728 -0400", hash_original_field = "2B7426DE8672C4DD04FD5F72A7459375", hash_generated_field = "D52F26E421F5AA24F0046DDA3C5C6D30")

        private static final int REDUCE_PRIORITY = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.728 -0400", hash_original_field = "11A0BF0E136B6043FA4BBEF4AF2C259B", hash_generated_field = "3E1A8A26CB7DF68F6FF0F277BCB9EC28")

        private static final int RESUME_PRIORITY = 2;
    }


    
    static class BaseUrlData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.728 -0400", hash_original_field = "D9B4FBDB0E6D2F16C5D86CABA14AEA3B", hash_generated_field = "0F88855D567BFEE131EF7A180E754162")

        String mBaseUrl;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.728 -0400", hash_original_field = "B7DE4FF1B7CCEFDA36733D8B6DFF2904", hash_generated_field = "3664585E19B9FCA2DFE85009B6783215")

        String mData;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.728 -0400", hash_original_field = "FA38F1960A45A7EC16349AAF783A80BC", hash_generated_field = "B161F982909610C03B68BAACDD54E076")

        String mMimeType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.728 -0400", hash_original_field = "FF7D0B646B2C057679C99D4079D890AA", hash_generated_field = "532663CB004FA57020360003BD60B6E5")

        String mEncoding;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.728 -0400", hash_original_field = "689631E9A0D183A0BF582E6B4C21B9BE", hash_generated_field = "AEB84E0F96BC10F5DEF2A6843387856E")

        String mHistoryUrl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.728 -0400", hash_original_method = "AAC8AA273862AA8B9D6E5E4822EA2513", hash_generated_method = "AAC8AA273862AA8B9D6E5E4822EA2513")
        public BaseUrlData ()
        {
            
        }


    }


    
    static class CursorData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.728 -0400", hash_original_field = "3E19E9ABC5814821815309EF694E3A85", hash_generated_field = "D59A59F4900CEA9BE8C05ED55105224C")

        int mMoveGeneration;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.728 -0400", hash_original_field = "6DA737BEA5EF42439DD8B9E77062C457", hash_generated_field = "9B989DBD5A4561D5F736D4FD676DE2CE")

        int mFrame;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.728 -0400", hash_original_field = "B109B7F70AB8D395A8E61064383C52BC", hash_generated_field = "F027C31ADF98D567850EC92AEACBFEFA")

        int mNode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.728 -0400", hash_original_field = "E47D03BC59EE2C8B3B45870BE85294FB", hash_generated_field = "E0802CA55986D756D3E3A834B7025711")

        int mX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.728 -0400", hash_original_field = "29DA5B2B864236A2CCB25B548E8F5F0A", hash_generated_field = "C11B85C67D00215273BFDFFDFCE3FC28")

        int mY;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.729 -0400", hash_original_method = "CB52479A54028E5EA2D022FBED517AD0", hash_generated_method = "2AF2198D7D90862DF6B793FD22A2BE79")
          CursorData() {
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.729 -0400", hash_original_method = "6825641482AFD3BD8931BBB7542BDAEF", hash_generated_method = "6CAF887DC38E710C60F9BAB3224835B8")
          CursorData(int frame, int node, int x, int y) {
            mFrame = frame;
            mNode = node;
            mX = x;
            mY = y;
            
            
            
            
            
        }

        
    }


    
    static class JSInterfaceData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.729 -0400", hash_original_field = "48FF959108CFB83B8A6F31854D7CE0B4", hash_generated_field = "63EB2904DE14485FE87749A3C0F578EC")

        Object mObject;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.729 -0400", hash_original_field = "234538FD1AA7874AA9BF9A74C915B767", hash_generated_field = "5D2D75DE4020ED94AFC743546E0FE97A")

        String mInterfaceName;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.730 -0400", hash_original_method = "C47EAF7170BE00EF188AF129D614A9F5", hash_generated_method = "C47EAF7170BE00EF188AF129D614A9F5")
        public JSInterfaceData ()
        {
            
        }


    }


    
    static class JSKeyData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.730 -0400", hash_original_field = "36C6DD9B08907C1B6E9923C9BB685506", hash_generated_field = "7557BA9FD6670B3E0CA06B263630791D")

        String mCurrentText;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.730 -0400", hash_original_field = "9F267F577D54234C4E24847A8B17E76A", hash_generated_field = "F843A40E7301C6699FB9E0A288E3C561")

        KeyEvent mEvent;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.730 -0400", hash_original_method = "95B0202B54BCEE663EF275E1A8F4EB03", hash_generated_method = "95B0202B54BCEE663EF275E1A8F4EB03")
        public JSKeyData ()
        {
            
        }


    }


    
    static class MotionUpData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.730 -0400", hash_original_field = "6DA737BEA5EF42439DD8B9E77062C457", hash_generated_field = "9B989DBD5A4561D5F736D4FD676DE2CE")

        int mFrame;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.730 -0400", hash_original_field = "B109B7F70AB8D395A8E61064383C52BC", hash_generated_field = "F027C31ADF98D567850EC92AEACBFEFA")

        int mNode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.730 -0400", hash_original_field = "EFABBD000FF848C98F3B412897E1622D", hash_generated_field = "9B5975BB58D6180DFB202E80016B49DF")

        Rect mBounds;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.730 -0400", hash_original_field = "E47D03BC59EE2C8B3B45870BE85294FB", hash_generated_field = "E0802CA55986D756D3E3A834B7025711")

        int mX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.730 -0400", hash_original_field = "29DA5B2B864236A2CCB25B548E8F5F0A", hash_generated_field = "C11B85C67D00215273BFDFFDFCE3FC28")

        int mY;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.730 -0400", hash_original_method = "4355A8BB53AC7F3F83470ED46BB47437", hash_generated_method = "4355A8BB53AC7F3F83470ED46BB47437")
        public MotionUpData ()
        {
            
        }


    }


    
    static class GetUrlData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.730 -0400", hash_original_field = "8299C83E9CFFA2EF5909444648349221", hash_generated_field = "CA88DB4A75B79130313A74537195706C")

        String mUrl;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.730 -0400", hash_original_field = "B5E9A1ACB2F4AE4C34BB53DD479DC3FE", hash_generated_field = "14E35722A33BF986AB2BBFC3C0CBCBA2")

        Map<String, String> mExtraHeaders;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.730 -0400", hash_original_method = "CF502CDAA78836D9E58C0BF8CE098EA6", hash_generated_method = "CF502CDAA78836D9E58C0BF8CE098EA6")
        public GetUrlData ()
        {
            
        }


    }


    
    static class PostUrlData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.730 -0400", hash_original_field = "8299C83E9CFFA2EF5909444648349221", hash_generated_field = "CA88DB4A75B79130313A74537195706C")

        String mUrl;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.730 -0400", hash_original_field = "AF86FBE15EC2C25B16B35C7E4DD756CA", hash_generated_field = "2D2347367D31A512EEC0E8D215ED2DBD")

        byte[] mPostData;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.730 -0400", hash_original_method = "7059AB3E9E778C04182440D5313C7DC6", hash_generated_method = "7059AB3E9E778C04182440D5313C7DC6")
        public PostUrlData ()
        {
            
        }


    }


    
    static class ReplaceTextData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.730 -0400", hash_original_field = "3DDC9661494212B707BCC4470B07F420", hash_generated_field = "226A663453FC02DD850C06CE0AA619ED")

        String mReplace;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.730 -0400", hash_original_field = "4E1C9EE0FEC5C15CFD43E70287C61F9C", hash_generated_field = "A73595A3B0345E5117F13612DC4CCFDE")

        int mNewStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.730 -0400", hash_original_field = "D774D75587200A0E1A39A53C38DFB517", hash_generated_field = "B601FB45644C5114D25521700D4C4DB9")

        int mNewEnd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.730 -0400", hash_original_field = "9456149C71095D688A9DAD35901D5775", hash_generated_field = "199FE44F91F4F1B8CB571680578352F3")

        int mTextGeneration;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.730 -0400", hash_original_method = "006F168E0387BB00C04A074431FA3645", hash_generated_method = "006F168E0387BB00C04A074431FA3645")
        public ReplaceTextData ()
        {
            
        }


    }


    
    static class TextSelectionData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.730 -0400", hash_original_field = "59B50EB80ABF1071654EE6DE5094E070", hash_generated_field = "83A19D93B82C07A79F54E265C2077EC6")

        int mStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.730 -0400", hash_original_field = "C3B248BAD041692A85BAABC024E9FDCE", hash_generated_field = "6FAA56F5628A0F1DAAFED98EBDB1C99E")

        int mEnd;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.730 -0400", hash_original_method = "01ADB7A0134281E557F1A0D40D5248A7", hash_generated_method = "68C74A2349D8B290308F5E21B9900F70")
        public  TextSelectionData(int start, int end) {
            mStart = start;
            mEnd = end;
            
            
            
        }

        
    }


    
    static class TouchUpData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.731 -0400", hash_original_field = "3E19E9ABC5814821815309EF694E3A85", hash_generated_field = "D59A59F4900CEA9BE8C05ED55105224C")

        int mMoveGeneration;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.731 -0400", hash_original_field = "6DA737BEA5EF42439DD8B9E77062C457", hash_generated_field = "9B989DBD5A4561D5F736D4FD676DE2CE")

        int mFrame;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.731 -0400", hash_original_field = "B109B7F70AB8D395A8E61064383C52BC", hash_generated_field = "F027C31ADF98D567850EC92AEACBFEFA")

        int mNode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.731 -0400", hash_original_field = "E47D03BC59EE2C8B3B45870BE85294FB", hash_generated_field = "E0802CA55986D756D3E3A834B7025711")

        int mX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.731 -0400", hash_original_field = "29DA5B2B864236A2CCB25B548E8F5F0A", hash_generated_field = "C11B85C67D00215273BFDFFDFCE3FC28")

        int mY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.731 -0400", hash_original_field = "C64DC6350FDE29B5552C531E3D386256", hash_generated_field = "DAF0696670C19E15E40480440A2F88F9")

        int mNativeLayer;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.731 -0400", hash_original_field = "EF5760ABDBB3A1AA004066FF113FF943", hash_generated_field = "1F075EDD02BEA33DB423E929CF5DF8B3")

        Rect mNativeLayerRect = new Rect();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.731 -0400", hash_original_method = "4711CC26AC513031C3BD47600FF5375E", hash_generated_method = "4711CC26AC513031C3BD47600FF5375E")
        public TouchUpData ()
        {
            
        }


    }


    
    static class TouchHighlightData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.731 -0400", hash_original_field = "E47D03BC59EE2C8B3B45870BE85294FB", hash_generated_field = "E0802CA55986D756D3E3A834B7025711")

        int mX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.731 -0400", hash_original_field = "29DA5B2B864236A2CCB25B548E8F5F0A", hash_generated_field = "C11B85C67D00215273BFDFFDFCE3FC28")

        int mY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.731 -0400", hash_original_field = "1377F8448B1127FD45A82D089124AC6D", hash_generated_field = "36A23F758F1BAB418A00C8E7530FF272")

        int mSlop;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.731 -0400", hash_original_field = "C64DC6350FDE29B5552C531E3D386256", hash_generated_field = "DAF0696670C19E15E40480440A2F88F9")

        int mNativeLayer;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.731 -0400", hash_original_field = "303CF71BDBBBE64B6803B4F12B16DD5D", hash_generated_field = "6542388769AB508E323B9B2D0CF83E04")

        Rect mNativeLayerRect;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.731 -0400", hash_original_method = "7EBB6E831321FAB695A1CB0442A597EC", hash_generated_method = "7EBB6E831321FAB695A1CB0442A597EC")
        public TouchHighlightData ()
        {
            
        }


    }


    
    static class AutoFillData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.731 -0400", hash_original_field = "427104C070D8C07CDE4241C4F45B4A38", hash_generated_field = "1A9B7D5E459A03CD29A94A18A042A141")

        private int mQueryId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.731 -0400", hash_original_field = "3272735622572F66F0356496E4B89C9E", hash_generated_field = "31FFD5C014EA21DA4DA7DD8A9D547D53")

        private String mPreview;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.731 -0400", hash_original_method = "1D9359D80D7809D2772AFB2E4DAF56F3", hash_generated_method = "7A89C44F80C8B962A21270246D909A8E")
        public  AutoFillData() {
            mQueryId = WebTextView.FORM_NOT_AUTOFILLABLE;
            mPreview = "";
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.732 -0400", hash_original_method = "CF8D1F130162170BD4749FDD138AF5B0", hash_generated_method = "3C0A26DA9E4CAB7271DD97029ED08D6D")
        public  AutoFillData(int queryId, String preview) {
            mQueryId = queryId;
            mPreview = preview;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.732 -0400", hash_original_method = "7DF004F757D7E4F7320327B99689B65F", hash_generated_method = "0F9BA403FC2A05CEEBFCFAA42A662800")
        public int getQueryId() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_845109488 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_845109488;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.732 -0400", hash_original_method = "E4F5699DB01CFB534A6B08E3CFDC42EF", hash_generated_method = "2813A250753314C3DCF08AA833CF4DDD")
        public String getPreviewString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1699908789 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1699908789 = mPreview;
            varB4EAC82CA7396A68D541C85D26508E83_1699908789.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1699908789;
            
            
        }

        
    }


    
    static class TouchEventData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.732 -0400", hash_original_field = "A3988EEE869C06063B06A0C38A6A1E11", hash_generated_field = "87F72266090A426F9B25050359B17309")

        int mAction;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.732 -0400", hash_original_field = "36CC87084E26172DAC189652DC599476", hash_generated_field = "E819B465C38B8028BC46AB427A1B0B56")

        int[] mIds;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.732 -0400", hash_original_field = "1658D961358101D1B1CA1633B2E1FD5F", hash_generated_field = "B3DCF7E604E73E985B3F580BA0A908EA")

        Point[] mPoints;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.732 -0400", hash_original_field = "E815BCF1F0C318C21DC827836551E8A8", hash_generated_field = "6C453702C678F946E46D0C5EF3CC237F")

        Point[] mPointsInView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.732 -0400", hash_original_field = "2EA2C30C14AB457B8A8B5BCAAA48AE16", hash_generated_field = "F9EC98B636053754CBEB7C53CF600DA0")

        int mActionIndex;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.732 -0400", hash_original_field = "FAD32D411972E0A85D1D781044420C0A", hash_generated_field = "2707C27F30BB3421B24DB98367DD2B08")

        int mMetaState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.732 -0400", hash_original_field = "1064EA0C5B7FA06DBAC2572612607A38", hash_generated_field = "8929173B49E90127C15F1C598AE4AF4D")

        boolean mReprocess;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.732 -0400", hash_original_field = "FA5D2BAE926C2A19B95431CC586925B5", hash_generated_field = "9DD13ABE729A13F299974C6122462E71")

        MotionEvent mMotionEvent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.732 -0400", hash_original_field = "C64DC6350FDE29B5552C531E3D386256", hash_generated_field = "DAF0696670C19E15E40480440A2F88F9")

        int mNativeLayer;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.733 -0400", hash_original_field = "EF5760ABDBB3A1AA004066FF113FF943", hash_generated_field = "1F075EDD02BEA33DB423E929CF5DF8B3")

        Rect mNativeLayerRect = new Rect();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.733 -0400", hash_original_field = "DFA2A9B34C4EF6A435AC62654D16526E", hash_generated_field = "B8B6644602DD2683A7B0A4778A62DE29")

        long mSequence;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.733 -0400", hash_original_field = "EBF9713B5A95F73A4D5708BF85188BB5", hash_generated_field = "E2A349795E68B906376E94D17B04B738")

        boolean mNativeResult;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.733 -0400", hash_original_method = "5D833927D3B75D4A9450986FF605CB3C", hash_generated_method = "5D833927D3B75D4A9450986FF605CB3C")
        public TouchEventData ()
        {
            
        }


    }


    
    static class GeolocationPermissionsData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.733 -0400", hash_original_field = "5DE534544BF2D4878653640F4FE1E784", hash_generated_field = "C27E43E4C41D4CBE4FD965D1402BAA57")

        String mOrigin;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.733 -0400", hash_original_field = "82348AD4E838AF549ADACE60B86882E4", hash_generated_field = "A7167E37AF8158CE579643A2ED8BFF31")

        boolean mAllow;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.733 -0400", hash_original_field = "7BD440AF264E0F123D8A606895461682", hash_generated_field = "088F231AED0EEA266EF56EDD1C6497CE")

        boolean mRemember;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.733 -0400", hash_original_method = "D46B71F5C8BC4DF5D7976DC461AFF808", hash_generated_method = "D46B71F5C8BC4DF5D7976DC461AFF808")
        public GeolocationPermissionsData ()
        {
            
        }


    }


    
    public class EventHub {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.733 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private Handler mHandler;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.733 -0400", hash_original_field = "A9D8AA87700CA4751CA5FADEC8F26AE7", hash_generated_field = "72049C1F419CB507F77FF804318D26A7")

        private ArrayList<Message> mMessages = new ArrayList<Message>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.733 -0400", hash_original_field = "D703C9ED519F3CFCA12F44BCB4752D05", hash_generated_field = "3372E747E3837CDFF5BB27CD728918D3")

        private boolean mBlockMessages;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.733 -0400", hash_original_field = "F8382D7895F9E0BEB12DD7C2310308AE", hash_generated_field = "CE8E976EC7A814206E43BF5450153045")

        private boolean mDestroying;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.733 -0400", hash_original_field = "112D67724C3A8F952B4AC2B5A69FBC94", hash_generated_field = "50324B3C89C6121270D18C08FF8C9860")

        private int mTid;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.733 -0400", hash_original_field = "85EB502ED9A46BAA1B96DEDBB7D0F166", hash_generated_field = "383517F47AAEBA69DE2808C9066BF35B")

        private int mSavedPriority;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.733 -0400", hash_original_method = "E81290CBA9EBCD5546A9E9277FAE0605", hash_generated_method = "A52E68C7F77102AEF2A85166BA2DF4B3")
        private  EventHub() {
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.746 -0400", hash_original_method = "306B3D199EA83A68750A5F32B05C0197", hash_generated_method = "914761B5C2167F4EB6B935D899E5376E")
        private void transferMessages() {
            mTid = Process.myTid();
            mSavedPriority = Process.getThreadPriority(mTid);
            mHandler = new Handler() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.744 -0400", hash_original_method = "F0B3B381C6E702A698555C74D6931FF7", hash_generated_method = "1537FB90035EA73DF7E47A328C7F3F57")
                @Override
                public void handleMessage(Message msg) {
                    
                    webkitDraw();
                    
                    
                    webkitDrawLayers();
                    
                    
                    {
                        Object var57F7C9E62F50237F3839461924AB4285_373106889 = (WebViewCore.this);
                        {
                            mBrowserFrame.destroy();
                            mBrowserFrame = null;
                            mSettings.onDestroyed();
                            mNativeClass = 0;
                            mWebView = null;
                        } 
                    } 
                    
                    
                    nativeRevealSelection();
                    
                    
                    {
                        int nodePointer = msg.arg2;
                        String label = nativeRequestLabel(msg.arg1,
                                        nodePointer);
                        {
                            boolean varF735B304F54339026D0CA1C53FD41B78_275018999 = (label != null && label.length() > 0);
                            {
                                Message.obtain(mWebView.mPrivateHandler,
                                            WebView.RETURN_LABEL, nodePointer,
                                            0, label).sendToTarget();
                            } 
                        } 
                    } 
                    
                    
                    nativeUpdateFrameCacheIfLoading();
                    
                    
                    float xPercent;
                    
                    
                    {
                        xPercent = 0f;
                    } 
                    {
                        xPercent = ((Float) msg.obj).floatValue();
                    } 
                    
                    
                    nativeScrollFocusedTextInput(xPercent, msg.arg2);
                    
                    
                    {
                        CookieManager.getInstance().waitForCookieOperationsToComplete();
                        GetUrlData param = (GetUrlData) msg.obj;
                        loadUrl(param.mUrl, param.mExtraHeaders);
                    } 
                    
                    
                    {
                        CookieManager.getInstance().waitForCookieOperationsToComplete();
                        PostUrlData param = (PostUrlData) msg.obj;
                        mBrowserFrame.postUrl(param.mUrl, param.mPostData);
                    } 
                    
                    
                    CookieManager.getInstance().waitForCookieOperationsToComplete();
                    
                    
                    BaseUrlData loadParams = (BaseUrlData) msg.obj;
                    
                    
                    String baseUrl = loadParams.mBaseUrl;
                    
                    
                    {
                        int i = baseUrl.indexOf(':');
                        {
                            String scheme = baseUrl.substring(0, i);
                            {
                                boolean varA2E56D0D7C8A087FDA40C96A1A8A0E5C_1871847601 = (!scheme.startsWith("http") &&
                                            !scheme.startsWith("ftp") &&
                                            !scheme.startsWith("about") &&
                                            !scheme.startsWith("javascript"));
                                {
                                    nativeRegisterURLSchemeAsLocal(scheme);
                                } 
                            } 
                        } 
                    } 
                    
                    
                    mBrowserFrame.loadData(baseUrl,
                                    loadParams.mData,
                                    loadParams.mMimeType,
                                    loadParams.mEncoding,
                                    loadParams.mHistoryUrl);
                    
                    
                    nativeContentInvalidateAll();
                    
                    
                    {
                        boolean var1CDB79E5CA9506E38E9F47122C3F2A81_1682534786 = (mBrowserFrame.committed()
                                    && !mBrowserFrame.firstLayoutDone());
                        {
                            mBrowserFrame.didFirstLayout();
                        } 
                    } 
                    
                    
                    stopLoading();
                    
                    
                    mBrowserFrame.reload(false);
                    
                    
                    key((KeyEvent) msg.obj, true);
                    
                    
                    key((KeyEvent) msg.obj, false);
                    
                    
                    nativeClick(msg.arg1, msg.arg2, true);
                    
                    
                    nativeClick(msg.arg1, msg.arg2, false);
                    
                    
                    {
                        viewSizeChanged((WebView.ViewSizeData) msg.obj);
                    } 
                    
                    
                    Point pt = (Point) msg.obj;
                    
                    
                    nativeSetScrollOffset(msg.arg1, msg.arg2 == 1,
                                    pt.x, pt.y);
                    
                    
                    Rect r = (Rect) msg.obj;
                    
                    
                    nativeSetGlobalBounds(r.left, r.top, r.width(),
                                r.height());
                    
                    
                    {
                        boolean var893023BC55997FD9309032550EA6349B_1846643489 = (!mBrowserFrame.committed() && msg.arg1 == -1 &&
                                    (mBrowserFrame.loadType() ==
                                    BrowserFrame.FRAME_LOADTYPE_STANDARD));
                        {
                            mBrowserFrame.reload(true);
                        } 
                        {
                            mBrowserFrame.goBackOrForward(msg.arg1);
                        } 
                    } 
                    
                    
                    stopLoading();
                    
                    
                    restoreState(msg.arg1);
                    
                    
                    mSavedPriority = Process.getThreadPriority(mTid);
                    
                    
                    Process.setThreadPriority(mTid,
                                    Process.THREAD_PRIORITY_BACKGROUND);
                    
                    
                    pauseTimers();
                    
                    
                    {
                        boolean var2DDC5BD4BB2F6B2978F909E7F34AB06D_1648996105 = (!JniUtil.useChromiumHttpStack());
                        {
                            WebViewWorker.getHandler().sendEmptyMessage(
                                        WebViewWorker.MSG_PAUSE_CACHE_TRANSACTION);
                        } 
                        {
                            nativeCloseIdleConnections();
                        } 
                    } 
                    
                    
                    Process.setThreadPriority(mTid, mSavedPriority);
                    
                    
                    resumeTimers();
                    
                    
                    {
                        boolean var2DDC5BD4BB2F6B2978F909E7F34AB06D_5657031 = (!JniUtil.useChromiumHttpStack());
                        {
                            WebViewWorker.getHandler().sendEmptyMessage(
                                        WebViewWorker.MSG_RESUME_CACHE_TRANSACTION);
                        } 
                    } 
                    
                    
                    nativePause();
                    
                    
                    nativeResume();
                    
                    
                    clearCache(false);
                    
                    
                    nativeFreeMemory();
                    
                    
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("No WebView " +
                                        "has been created in this process!");
                    } 
                    
                    
                    BrowserFrame.sJavaBridge
                                    .setNetworkOnLine(msg.arg1 == 1);
                    
                    
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("No WebView " +
                                        "has been created in this process!");
                    } 
                    
                    
                    Map<String, String> map = (Map<String, String>) msg.obj;
                    
                    
                    BrowserFrame.sJavaBridge
                                    .setNetworkType(map.get("type"), map.get("subtype"));
                    
                    
                    clearCache(msg.arg1 == 1);
                    
                    
                    mCallbackProxy.getBackForwardList().
                                    close(mBrowserFrame.mNativeFrame);
                    
                    
                    ReplaceTextData rep = (ReplaceTextData) msg.obj;
                    
                    
                    nativeReplaceTextfieldText(msg.arg1, msg.arg2,
                                    rep.mReplace, rep.mNewStart, rep.mNewEnd,
                                    rep.mTextGeneration);
                    
                    
                    {
                        JSKeyData jsData = (JSKeyData) msg.obj;
                        KeyEvent evt = jsData.mEvent;
                        int keyCode = evt.getKeyCode();
                        int keyValue = evt.getUnicodeChar();
                        int generation = msg.arg1;
                        passToJs(generation,
                                    jsData.mCurrentText,
                                    keyCode,
                                    keyValue,
                                    evt.isDown(),
                                    evt.isShiftPressed(), evt.isAltPressed(),
                                    evt.isSymPressed());
                    } 
                    
                    
                    {
                        CursorData cDat = (CursorData) msg.obj;
                        nativeSaveDocumentState(cDat.mFrame);
                    } 
                    
                    
                    {
                        boolean varF3475F759DD108C1DC11D60361B928EA_620787888 = (JniUtil.useChromiumHttpStack());
                        {
                            SslCertLookupTable.getInstance().clear();
                            nativeCloseIdleConnections();
                        } 
                        {
                            Network.getInstance(mContext).clearUserSslPrefTable();
                        } 
                    } 
                    
                    
                    TouchUpData touchUpData = (TouchUpData) msg.obj;
                    
                    
                    {
                        nativeScrollLayer(touchUpData.mNativeLayer,
                                        touchUpData.mNativeLayerRect);
                    } 
                    
                    
                    nativeTouchUp(touchUpData.mMoveGeneration,
                                    touchUpData.mFrame, touchUpData.mNode,
                                    touchUpData.mX, touchUpData.mY);
                    
                    
                    {
                        TouchEventData ted = (TouchEventData) msg.obj;
                        final int count = ted.mPoints.length;
                        int[] xArray = new int[count];
                        int[] yArray = new int[count];
                        {
                            int c = 0;
                            {
                                xArray[c] = ted.mPoints[c].x;
                                yArray[c] = ted.mPoints[c].y;
                            } 
                        } 
                        {
                            nativeScrollLayer(ted.mNativeLayer,
                                        ted.mNativeLayerRect);
                        } 
                        ted.mNativeResult = nativeHandleTouchEvent(ted.mAction, ted.mIds,
                                    xArray, yArray, count, ted.mActionIndex, ted.mMetaState);
                        Message.obtain(
                                    mWebView.mPrivateHandler,
                                    WebView.PREVENT_TOUCH_ID,
                                    ted.mAction,
                                    ted.mNativeResult ? 1 : 0,
                                    ted).sendToTarget();
                    } 
                    
                    
                    nativeSetFocusControllerActive(msg.arg1 == 1);
                    
                    
                    JSInterfaceData jsData = (JSInterfaceData) msg.obj;
                    
                    
                    mBrowserFrame.addJavascriptInterface(jsData.mObject,
                                    jsData.mInterfaceName);
                    
                    
                    jsData = (JSInterfaceData) msg.obj;
                    
                    
                    mBrowserFrame.removeJavascriptInterface(
                                    jsData.mInterfaceName);
                    
                    
                    mBrowserFrame.externalRepresentation(
                                    (Message) msg.obj);
                    
                    
                    mBrowserFrame.documentAsText((Message) msg.obj);
                    
                    
                    CursorData focusData = (CursorData) msg.obj;
                    
                    
                    nativeMoveFocus(focusData.mFrame, focusData.mNode);
                    
                    
                    CursorData cursorData = (CursorData) msg.obj;
                    
                    
                    nativeMoveMouse(cursorData.mFrame,
                                     cursorData.mX, cursorData.mY);
                    
                    
                    CursorData cData = (CursorData) msg.obj;
                    
                    
                    nativeMoveMouseIfLatest(cData.mMoveGeneration,
                                    cData.mFrame,
                                    cData.mX, cData.mY);
                    
                    
                    {
                        nativeStopPaintingCaret();
                    } 
                    
                    
                    {
                        Message hrefMsg = (Message) msg.obj;
                        hrefMsg.getData().putString("url",
                                    nativeRetrieveHref(msg.arg1, msg.arg2));
                        hrefMsg.getData().putString("title",
                                    nativeRetrieveAnchorText(msg.arg1, msg.arg2));
                        hrefMsg.getData().putString("src",
                                    nativeRetrieveImageSource(msg.arg1, msg.arg2));
                        hrefMsg.sendToTarget();
                    } 
                    
                    
                    nativeUpdateFrameCache();
                    
                    
                    {
                        mWebView.postInvalidate();
                    } 
                    
                    
                    sendUpdateTextEntry();
                    
                    
                    Message imageResult = (Message) msg.obj;
                    
                    
                    imageResult.arg1 =
                                    mBrowserFrame.documentHasImages() ? 1 : 0;
                    
                    
                    imageResult.sendToTarget();
                    
                    
                    TextSelectionData deleteSelectionData = (TextSelectionData) msg.obj;
                    
                    
                    nativeDeleteSelection(deleteSelectionData.mStart,
                                    deleteSelectionData.mEnd, msg.arg1);
                    
                    
                    nativeSetSelection(msg.arg1, msg.arg2);
                    
                    
                    String modifiedSelectionString = nativeModifySelection(msg.arg1,
                                    msg.arg2);
                    
                    
                    mWebView.mPrivateHandler.obtainMessage(WebView.SELECTION_STRING_CHANGED,
                                    modifiedSelectionString).sendToTarget();
                    
                    
                    SparseBooleanArray choices = (SparseBooleanArray)
                                    msg.obj;
                    
                    
                    int choicesSize = msg.arg1;
                    
                    
                    boolean[] choicesArray = new boolean[choicesSize];
                    
                    
                    {
                        int c = 0;
                        {
                            choicesArray[c] = choices.get(c);
                        } 
                    } 
                    
                    
                    nativeSendListBoxChoices(choicesArray,
                                    choicesSize);
                    
                    
                    nativeSendListBoxChoice(msg.arg1);
                    
                    
                    nativeSetBackgroundColor(msg.arg1);
                    
                    
                    nativeDumpDomTree(msg.arg1 == 1);
                    
                    
                    nativeDumpRenderTree(msg.arg1 == 1);
                    
                    
                    nativeDumpNavTree();
                    
                    
                    nativeDumpV8Counters();
                    
                    
                    nativeSetJsFlags((String)msg.obj);
                    
                    
                    nativeContentInvalidateAll();
                    
                    
                    WebView.SaveWebArchiveMessage saveMessage = (WebView.SaveWebArchiveMessage)msg.obj;
                    
                    
                    saveMessage.mResultFile =
                                saveWebArchive(saveMessage.mBasename, saveMessage.mAutoname);
                    
                    
                    mWebView.mPrivateHandler.obtainMessage(
                                WebView.SAVE_WEBARCHIVE_FINISHED, saveMessage).sendToTarget();
                    
                    
                    GeolocationPermissionsData data = (GeolocationPermissionsData) msg.obj;
                    
                    
                    nativeGeolocationPermissionsProvide(data.mOrigin,
                                    data.mAllow, data.mRemember);
                    
                    
                    nativeSplitContent(msg.arg1);
                    
                    
                    mWebView.mPrivateHandler.obtainMessage(
                                    WebView.REPLACE_BASE_CONTENT, msg.arg1, 0);
                    
                    
                    mSplitPictureIsScheduled = false;
                    
                    
                    nativeClearContent();
                    
                    
                    ((Message) msg.obj).sendToTarget();
                    
                    
                    nativeProvideVisitedHistory((String[])msg.obj);
                    
                    
                    {
                        MotionUpData motionUpData = (MotionUpData) msg.obj;
                        {
                            boolean var3C260CC22B1DBBEA4A22E069D8F01A64_768091135 = (!nativeValidNodeAndBounds(
                                    motionUpData.mFrame, motionUpData.mNode,
                                    motionUpData.mBounds));
                            {
                                nativeUpdateFrameCache();
                            } 
                        } 
                        Message message = mWebView.mPrivateHandler
                                    .obtainMessage(WebView.DO_MOTION_UP,
                                    motionUpData.mX, motionUpData.mY);
                        mWebView.mPrivateHandler.sendMessageAtFrontOfQueue(
                                    message);
                    } 
                    
                    
                    nativeFullScreenPluginHidden(msg.arg1);
                    
                    
                    nativePluginSurfaceReady();
                    
                    
                    nativeNotifyAnimationStarted(mNativeClass);
                    
                    
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("No WebView " +
                                        "has been created in this process!");
                    } 
                    
                    
                    BrowserFrame.sJavaBridge.addPackageNames(
                                    (Set<String>) msg.obj);
                    
                    
                    TouchHighlightData d = (TouchHighlightData) msg.obj;
                    
                    
                    {
                        nativeScrollLayer(d.mNativeLayer,
                                        d.mNativeLayerRect);
                    } 
                    
                    
                    ArrayList<Rect> rects = nativeGetTouchHighlightRects
                                    (d.mX, d.mY, d.mSlop);
                    
                    
                    mWebView.mPrivateHandler.obtainMessage(
                                    WebView.SET_TOUCH_HIGHLIGHT_RECTS, rects)
                                    .sendToTarget();
                    
                    
                    useMockDeviceOrientation();
                    
                    
                    nativeAutoFillForm(msg.arg1);
                    
                    
                    mWebView.mPrivateHandler.obtainMessage(WebView.AUTOFILL_COMPLETE, null)
                                    .sendToTarget();
                    
                    
                    {
                        {
                            Log.d(LOGTAG, "Executing JS : " + msg.obj);
                        } 
                        mBrowserFrame.stringByEvaluatingJavaScriptFromString((String) msg.obj);
                    } 
                    
                    addTaint(msg.getTaint());
                    
                    
                }
};
            {
                int size = mMessages.size();
                {
                    int i = 0;
                    {
                        mHandler.sendMessage(mMessages.get(i));
                    } 
                } 
                mMessages = null;
            } 
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.747 -0400", hash_original_method = "A3F2FAE5568048D2CF4F883B9C3D720D", hash_generated_method = "8F93D4CB8746D7967B1BD6C4472B5FF7")
        private synchronized void sendMessage(Message msg) {
            {
                mMessages.add(msg);
            } 
            {
                mHandler.sendMessage(msg);
            } 
            addTaint(msg.getTaint());
            
            
                
            
            
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.748 -0400", hash_original_method = "2D760BF01DEDB25033C3CD5EE0C5DC00", hash_generated_method = "77068896FE59FE5E50D45BE0E7D2F13D")
        private synchronized void removeMessages(int what) {
            {
                mDrawIsScheduled = false;
            } 
            {
                Throwable throwable = new Throwable(
                        "EventHub.removeMessages(int what = " + what + ") is not supported " +
                        "before the WebViewCore is set up.");
            } 
            {
                mHandler.removeMessages(what);
            } 
            addTaint(what);
            
            
                
            
            
                
            
            
                
                        
                        
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.748 -0400", hash_original_method = "8649C68E7EFBE767B713B2AB196A4693", hash_generated_method = "9C14F3439E372CE49DA379464B313C60")
        private synchronized void sendMessageDelayed(Message msg, long delay) {
            mHandler.sendMessageDelayed(msg, delay);
            addTaint(msg.getTaint());
            addTaint(delay);
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.748 -0400", hash_original_method = "D0F21E4A05814ED295A9D395C58D6229", hash_generated_method = "270C08832AAC61E53247831FCA2D51DB")
        private synchronized void sendMessageAtFrontOfQueue(Message msg) {
            {
                mMessages.add(0, msg);
            } 
            {
                mHandler.sendMessageAtFrontOfQueue(msg);
            } 
            addTaint(msg.getTaint());
            
            
                
            
            
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.749 -0400", hash_original_method = "2D908156D971A0132EC1B636390B02E6", hash_generated_method = "14131740913625E95BC1CF56E0E732F4")
        private synchronized void removeMessages() {
            mDrawIsScheduled = false;
            mSplitPictureIsScheduled = false;
            {
                mMessages.clear();
            } 
            {
                mHandler.removeCallbacksAndMessages(null);
            } 
            
            
            
            
                
            
                
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.749 -0400", hash_original_method = "7F4FC3BA20FD4185DE24EC53F9CE84DB", hash_generated_method = "26B51E76D19EB36CD02103295CF60E9F")
        private synchronized void blockMessages() {
            mBlockMessages = true;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.749 -0400", hash_original_field = "0178C45FDD2DC55110AAE0FB17F5A21A", hash_generated_field = "A1A4E056845B8B693139A8C45FF0BD72")

        static final int REVEAL_SELECTION = 96;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.749 -0400", hash_original_field = "2FEB54456C37DDE131101DE12C9944AC", hash_generated_field = "95A702E62450AA8F90586DC0EC79158C")

        static final int REQUEST_LABEL = 97;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.749 -0400", hash_original_field = "25BD775DB37BFB20F88C548E1C0F0109", hash_generated_field = "281B4C01D26497075CD5765CB75D0077")

        static final int UPDATE_FRAME_CACHE_IF_LOADING = 98;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.749 -0400", hash_original_field = "608719A6EEAAECDC759726A8206CA6EF", hash_generated_field = "2BA34DD0A9639D2054B9A5B00693A908")

        static final int SCROLL_TEXT_INPUT = 99;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.749 -0400", hash_original_field = "155B5905234D36BB24B3B426A6AE6995", hash_generated_field = "086D57918D4358A7798E134FC092C3BB")

        static final int LOAD_URL = 100;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.749 -0400", hash_original_field = "897E968785EAC278E6172C470A60587D", hash_generated_field = "C733C295F0605C3FC1982015BD6F78B6")

        static final int STOP_LOADING = 101;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.749 -0400", hash_original_field = "395128927ADE3437E06046C89BD9251B", hash_generated_field = "C7B38026E54635BC386787F3AFC2F7C4")

        static final int RELOAD = 102;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.749 -0400", hash_original_field = "AC7AFDFC01CA394FA66AC754E2D9E56C", hash_generated_field = "7919C762EDFBC0511A97F543FFE7E251")

        static final int KEY_DOWN = 103;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.749 -0400", hash_original_field = "4958E0749886E68101E64DF420ED0D75", hash_generated_field = "A5CBBF6B1244669FBFA9F6F006C227BA")

        static final int KEY_UP = 104;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.749 -0400", hash_original_field = "40A3DEE81072C6EACF4AA8068FBE8A75", hash_generated_field = "EAACB31F67B066D7D2CA5D7E23855B82")

        static final int VIEW_SIZE_CHANGED = 105;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.749 -0400", hash_original_field = "4623535D7D86F649DF38D2B492B18577", hash_generated_field = "D5CB605B980594BC52BBC10DC40E6266")

        static final int GO_BACK_FORWARD = 106;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.749 -0400", hash_original_field = "07EF4446DE189E8C3A18ADEEC0B7A43F", hash_generated_field = "378A2EE3FA8A592042114561EA32D332")

        static final int SET_SCROLL_OFFSET = 107;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.749 -0400", hash_original_field = "8D542F6340C1FDDAEAE86A59C4C47862", hash_generated_field = "F871EED787411D12EE2BA9431E64EB83")

        static final int RESTORE_STATE = 108;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.749 -0400", hash_original_field = "8A526730217273C006286A9BC2767113", hash_generated_field = "89DD19A30AEABFC7ED706641457D8982")

        static final int PAUSE_TIMERS = 109;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.749 -0400", hash_original_field = "AE0F986C0CD598D4F96A5043B1202160", hash_generated_field = "2D98A340CF3EB3EA3724650A717350E9")

        static final int RESUME_TIMERS = 110;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.749 -0400", hash_original_field = "65CDFCA3D82307D3BDA1A965C14CFEB3", hash_generated_field = "B73EE49855F361841364FF21C972BAB4")

        static final int CLEAR_CACHE = 111;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.749 -0400", hash_original_field = "D0963170AC31752E6B5B310D6831C8EC", hash_generated_field = "AEC59F30BA1D81C9D5F4CE4F397F47D4")

        static final int CLEAR_HISTORY = 112;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.749 -0400", hash_original_field = "26A6ACCF763E467F3DFD8705905E1A1C", hash_generated_field = "6E185859BEFC79914687F7ECA5E9F874")

        static final int SET_SELECTION = 113;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.750 -0400", hash_original_field = "605A9B208AF321985617539FF1919CDE", hash_generated_field = "C0EB4E3347FFE212A8C18F2A3E44C7BE")

        static final int REPLACE_TEXT = 114;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.750 -0400", hash_original_field = "918B109CAA8D3A3E35ED7853F83ED70C", hash_generated_field = "74867D5CAE32FC825A2AE3E24431DD95")

        static final int PASS_TO_JS = 115;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.750 -0400", hash_original_field = "2E31E06D44BCFDEC52246494A5DB2F77", hash_generated_field = "2959DC038CF421309872D0B26605BC48")

        static final int SET_GLOBAL_BOUNDS = 116;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.750 -0400", hash_original_field = "8CB3D39ADF7D179F9067EFAC4C3DB6D0", hash_generated_field = "985745CFE407397A79760A370C81EB50")

        static final int UPDATE_CACHE_AND_TEXT_ENTRY = 117;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.750 -0400", hash_original_field = "1E5B74D4AA5697C59954F2DCA8A2F6C5", hash_generated_field = "61E286EB171C779795532F131306C2B8")

        static final int CLICK = 118;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.750 -0400", hash_original_field = "3C2860108BC79F8B2983129737588F47", hash_generated_field = "C054E26A89164E92142B9754275E54DF")

        static final int SET_NETWORK_STATE = 119;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.750 -0400", hash_original_field = "3496A7B304DCEE736CF7E802FFB0E427", hash_generated_field = "A807D55DE295D1B170656AD4F0201C5E")

        static final int DOC_HAS_IMAGES = 120;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.750 -0400", hash_original_field = "AEF103E9D940F8188113703554C1B840", hash_generated_field = "D33F0FEAFFF69D0C42BAFDB402479110")

        static final int FAKE_CLICK = 121;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.750 -0400", hash_original_field = "B9674EDC50527EE9E87708D1F5B61520", hash_generated_field = "F26A5181B23CFECA8797551DC8D3CAE9")

        static final int DELETE_SELECTION = 122;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.750 -0400", hash_original_field = "4B5E09D9826458EA4982549E5AD0A0DF", hash_generated_field = "8ABAD2B9E240BA920D9928675F720B99")

        static final int LISTBOX_CHOICES = 123;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.750 -0400", hash_original_field = "0719D2D87E91AB65E2B2EB70545A3586", hash_generated_field = "87CC0A49DCC346349771C56003B71750")

        static final int SINGLE_LISTBOX_CHOICE = 124;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.750 -0400", hash_original_field = "9A9D03ECA98271AAE84FBBFC6A03629D", hash_generated_field = "04B8BC482E2A7B96E01E5E3110E0B668")

        public static final int MESSAGE_RELAY = 125;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.750 -0400", hash_original_field = "11FFE8069A0C3D316A6AED0AAD61BFCB", hash_generated_field = "6E2F6688DF5B663BAB9DD961B764EE61")

        static final int SET_BACKGROUND_COLOR = 126;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.750 -0400", hash_original_field = "1079F442D221602DBF00DFE1382C557B", hash_generated_field = "044533B2719816EAAA2232B84AB25CEF")

        static final int SET_MOVE_FOCUS = 127;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.750 -0400", hash_original_field = "F743DECE83648C38FF4843B11AC03C7C", hash_generated_field = "03D02B5B16A89402CEDE2754F4401D5C")

        static final int SAVE_DOCUMENT_STATE = 128;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.750 -0400", hash_original_field = "447F8B2518BC6C3F2C6050DCEA569780", hash_generated_field = "311987CBB915E85277F2F9AE5B25E8B9")

        static final int WEBKIT_DRAW = 130;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.750 -0400", hash_original_field = "32A9A219E4D1DF62F969EE833662B0B3", hash_generated_field = "3CAAA0995206DE66D86074216FC35CD6")

        static final int POST_URL = 132;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.750 -0400", hash_original_field = "F550A8024A088F0C0DDA7D6C15A8C19B", hash_generated_field = "37F5E563749301EE7D599A81A9CF7143")

        static final int SPLIT_PICTURE_SET = 133;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.750 -0400", hash_original_field = "86A824DE74383185A6C589DED12CEB1E", hash_generated_field = "12980B1BE510BC8A29053E9D7D333DAB")

        static final int CLEAR_CONTENT = 134;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.750 -0400", hash_original_field = "F2DCC4000BF9EB2F216E050DC9FCB0EB", hash_generated_field = "1777EF02F537F813F3100A202247E8D6")

        static final int SET_MOVE_MOUSE = 135;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.750 -0400", hash_original_field = "545BEC7B5841B277C060B95CC6D10122", hash_generated_field = "32A2279F96B6FB2BD9A1A8A581BC021B")

        static final int SET_MOVE_MOUSE_IF_LATEST = 136;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.750 -0400", hash_original_field = "FF401E3BBF7557B9C971BFAAFB86FB7F", hash_generated_field = "E21D375BD23E64F446953AB2BF9346A4")

        static final int REQUEST_CURSOR_HREF = 137;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.750 -0400", hash_original_field = "9E35A95BEE1D3C2BBC3A39141167AD31", hash_generated_field = "7CDC3D34B6EE61E2B892A9C01ABFBC9D")

        static final int ADD_JS_INTERFACE = 138;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.750 -0400", hash_original_field = "4E48734775C76F4353FCC98F8494001C", hash_generated_field = "A923706DD675028E24F855109A5C9DB4")

        static final int LOAD_DATA = 139;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.750 -0400", hash_original_field = "08F2C51F2E9DE3B6C3D0917E24889C28", hash_generated_field = "040EB045A76CDEE06C177118ECAE7213")

        static final int TOUCH_UP = 140;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.750 -0400", hash_original_field = "302A3FDA991B8FC61DD5E7DE842F71F4", hash_generated_field = "EA2A61439DE3D7F424486BE38A8E9097")

        static final int TOUCH_EVENT = 141;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.750 -0400", hash_original_field = "0C898014AE4D9974A6532E5DC8BCF24C", hash_generated_field = "C5A24B382F1E22C70DC6FE85B44BC09D")

        static final int SET_ACTIVE = 142;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.750 -0400", hash_original_field = "324327E69AA5D9BEEA44639F198F476B", hash_generated_field = "2D5406449790A921A8C4D155013BF469")

        static final int ON_PAUSE = 143;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.750 -0400", hash_original_field = "8CE29522D18E89EACB0B775CBC5207BD", hash_generated_field = "E0C0F7F667064D1694A485ACA08D0272")

        static final int ON_RESUME = 144;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.750 -0400", hash_original_field = "9FE644EF22E01685FCFEE69ED04BE51A", hash_generated_field = "D46DC07E1723FDD9EB9D0B9D49FA6C70")

        static final int FREE_MEMORY = 145;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.750 -0400", hash_original_field = "EBEBA31CBED1A0563D9D9F7A269DDEDC", hash_generated_field = "E026B9CBD97125E0F86C178AAAA6C477")

        static final int VALID_NODE_BOUNDS = 146;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.750 -0400", hash_original_field = "9E00C3C5BD4641D798AB77D1E9DBB634", hash_generated_field = "8447DACB63472460CDDABE8CDCC76131")

        static final int SAVE_WEBARCHIVE = 147;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.750 -0400", hash_original_field = "88A0FD1396B8FC1919B777CE3C9AF38D", hash_generated_field = "4719F9787C86BD531DDCD3A4F24A0CAD")

        static final int WEBKIT_DRAW_LAYERS = 148;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.750 -0400", hash_original_field = "88F6D8137956B77E3D536C18D4D0EFC0", hash_generated_field = "259E28E910BDF11B84BC8154A04E9D36")

        static final int REMOVE_JS_INTERFACE = 149;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.750 -0400", hash_original_field = "E497FF4A2F88F6F60FDC7BA949918A94", hash_generated_field = "7ADB3182C36D5725D5320E86C4117FC4")

        static final int CLEAR_SSL_PREF_TABLE = 150;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.750 -0400", hash_original_field = "D10722F6ED0DD937B939F492EF35E8D7", hash_generated_field = "FAEA67345060AE301231EA91BE292569")

        static final int REQUEST_EXT_REPRESENTATION = 160;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.750 -0400", hash_original_field = "76D5044CD726F8C85CB2CFC31C7C1768", hash_generated_field = "3845E0589547315CEE5E0B92DD1AD244")

        static final int REQUEST_DOC_AS_TEXT = 161;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.751 -0400", hash_original_field = "B7371C4F4E0217E72174D88C067DFC06", hash_generated_field = "F3C193CFC60CF3C0B322E996C8EB1503")

        static final int DUMP_DOMTREE = 170;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.751 -0400", hash_original_field = "1592A00FFDDE226013908C6A57E57904", hash_generated_field = "B6BF792FD91B42804F05463A409C6712")

        static final int DUMP_RENDERTREE = 171;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.751 -0400", hash_original_field = "2717C5613936FC350DF4E37644F4A6FA", hash_generated_field = "FFFF59DB0DBEB41E1610B50BEEFE078B")

        static final int DUMP_NAVTREE = 172;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.751 -0400", hash_original_field = "8C16015B942E2102178692A164E14489", hash_generated_field = "22ECFEB4F1D7198CAD9004F3F8182ACA")

        static final int DUMP_V8COUNTERS = 173;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.751 -0400", hash_original_field = "C09D00753935EDEB90EEFAA346B7D5F9", hash_generated_field = "2CCC2814D3A8DD935BA79DB833CB97A9")

        static final int SET_JS_FLAGS = 174;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.751 -0400", hash_original_field = "2B4473065657905E2705BBACE2532640", hash_generated_field = "770306EE08C5B265C944F26D759A454A")

        static final int CONTENT_INVALIDATE_ALL = 175;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.751 -0400", hash_original_field = "FB2EAB32686B136709EDDB0424B8C5DC", hash_generated_field = "A502B6DA1FCA2647B6641D88EF81A26C")

        static final int GEOLOCATION_PERMISSIONS_PROVIDE = 180;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.751 -0400", hash_original_field = "99B24F1A7716E408A46E9A80432D1D59", hash_generated_field = "4C4316E650B8E2C35AAC2AE6DFC9E0DC")

        static final int POPULATE_VISITED_LINKS = 181;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.751 -0400", hash_original_field = "28482F3F0AB8CF25045AF594D0722AFF", hash_generated_field = "F59323C5749EC8B80626289AC6A6CA41")

        static final int HIDE_FULLSCREEN = 182;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.751 -0400", hash_original_field = "DC214F64561BF6BA0664492851C6B982", hash_generated_field = "4BA27FCDB8E753E9D23C35EEF4250599")

        static final int SET_NETWORK_TYPE = 183;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.751 -0400", hash_original_field = "F0F993ECC11FE6F56E511FA842A033CB", hash_generated_field = "D4353191303A307F8EC0C9FCB23A4601")

        static final int ADD_PACKAGE_NAMES = 184;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.751 -0400", hash_original_field = "30F6104A68865A9971509335897C3EC1", hash_generated_field = "CD59BAC9B7F62B4E0EC1CED1448C2ADC")

        static final int ADD_PACKAGE_NAME = 185;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.751 -0400", hash_original_field = "0CBF86B7DD0C2C6B094120BEFEBDAE94", hash_generated_field = "86FD47ED32409C69B4B1C1E88FCF5134")

        static final int REMOVE_PACKAGE_NAME = 186;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.751 -0400", hash_original_field = "FF6BB61E0B560FE45FDFC891E906DFAE", hash_generated_field = "26B47DF07CF581E3990DCB8B8BD0FFD6")

        static final int GET_TOUCH_HIGHLIGHT_RECTS = 187;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.751 -0400", hash_original_field = "69201F7FF7919A87148C063CCF25E397", hash_generated_field = "EAA3BB9D3322C3641C45C69C1B8BF5A6")

        static final int MODIFY_SELECTION = 190;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.751 -0400", hash_original_field = "96558DB1E43DAC83AAC8BB9C25998D3A", hash_generated_field = "F6936A0587CAC5B6914A71D88CC55D4B")

        static final int USE_MOCK_DEVICE_ORIENTATION = 191;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.751 -0400", hash_original_field = "03A6C820D50809FC606ADFA5A69C9C42", hash_generated_field = "4A8959279B873BDC4AC53CD29E99A969")

        static final int AUTOFILL_FORM = 192;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.751 -0400", hash_original_field = "A79593230B8E8FF467CE66C53F5E9D1A", hash_generated_field = "24289CC25342574331262A5EA7A3E9BF")

        static final int PROXY_CHANGED = 193;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.751 -0400", hash_original_field = "689AC440EC53A881ABC1DC761F39F221", hash_generated_field = "9156CA0AA536924F355C0ADD1B8E313C")

        static final int EXECUTE_JS = 194;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.751 -0400", hash_original_field = "33DF689BE30247A088AA934029F156F9", hash_generated_field = "5D48D0945BB3F832E09CEFB03CEA0D6B")

        static final int PLUGIN_SURFACE_READY = 195;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.751 -0400", hash_original_field = "EBDEB0BCA0FB33350C59009CAFFA28F5", hash_generated_field = "6F474F4430BE37C7E2D8E37E2EFD176E")

        static final int NOTIFY_ANIMATION_STARTED = 196;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.751 -0400", hash_original_field = "42E5D8F670F6358A69716D440597559B", hash_generated_field = "E60DE11B53705E1D887324E4085A47B6")

        private static final int DESTROY = 200;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.751 -0400", hash_original_field = "CACBA3A8C4B02B441CF4115872D6D8C9", hash_generated_field = "8DAF2FCED2EB50F87603702698DEEC1B")

        private static final int FIRST_PACKAGE_MSG_ID = REVEAL_SELECTION;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.751 -0400", hash_original_field = "90D300F9589EE360864405F39685DC64", hash_generated_field = "5F401005531CDDC07655139C4E52E31E")

        private static final int LAST_PACKAGE_MSG_ID = VALID_NODE_BOUNDS;
    }


    
    static class ViewState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.751 -0400", hash_original_field = "6590038AD6148871C2FA7C6C11FF3079", hash_generated_field = "B32B05E9B06961C068146DEC621EAC96")

        float mMinScale;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.751 -0400", hash_original_field = "30CE4DDEAA33298C67C20E82090CDABF", hash_generated_field = "F1991B21BE4FD345C3E31239E4A9D26B")

        float mMaxScale;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.751 -0400", hash_original_field = "D17F4EDA8D50CF68601237A2AA275370", hash_generated_field = "92D32B7B49710A45199D181A0A3F6CDD")

        float mViewScale;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.751 -0400", hash_original_field = "3190B9F88CD9ECBDD0CF99CE8D1E0B89", hash_generated_field = "B2BB1FC05073BD7B5469AA68A14F4A2A")

        float mTextWrapScale;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.751 -0400", hash_original_field = "F3150A42E04B25673AB01D2C041638C1", hash_generated_field = "1BF737CEB256195165CA6AA7F00EB0A0")

        float mDefaultScale;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.751 -0400", hash_original_field = "9DC8F9676E14E93147EBEA37CE364B55", hash_generated_field = "E9A45ED540F0B589A497E7AFE99EBA3D")

        int mScrollX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.751 -0400", hash_original_field = "4ABBFD585ECE4FE40BECD8E0C30C4E5E", hash_generated_field = "EC6AD52CC705AA3985B25CDB13E68426")

        int mScrollY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.751 -0400", hash_original_field = "258488A6A75EF8D44091980CA48422E3", hash_generated_field = "E2715834245B310B1EDEFB5A5E46DC19")

        boolean mMobileSite;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.751 -0400", hash_original_field = "2DBA53EC1BC952FD03B3BDD28BA02428", hash_generated_field = "DCF6E9F007CD0B21908BEEB85CA9A358")

        boolean mIsRestored;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.751 -0400", hash_original_field = "EA83E37F787D96E8BCBD65B26326EDDD", hash_generated_field = "F0A7C1C015045A534AFE2405942522D1")

        boolean mShouldStartScrolledRight;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.751 -0400", hash_original_method = "FF705DB5257E6CA3790C30389112B4B7", hash_generated_method = "FF705DB5257E6CA3790C30389112B4B7")
        public ViewState ()
        {
            
        }


    }


    
    static class DrawData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.751 -0400", hash_original_field = "88F5382EE3BD7F8DEED63F6EC5018138", hash_generated_field = "73A6CF6AB924FFDDE75286128636047A")

        int mBaseLayer;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.752 -0400", hash_original_field = "8FD08013DF73466B38DC6751D7A6172C", hash_generated_field = "E790C094D998A1C09371E07D548282F9")

        Region mInvalRegion;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.752 -0400", hash_original_field = "382CF1CB3F6A18F302607E4C3A589F1D", hash_generated_field = "E793ED455F3C00CD9A5CDD84292C7637")

        Point mViewSize;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.752 -0400", hash_original_field = "07ADDDDC6D5F179ADB48CCE66A4979E7", hash_generated_field = "3C549D54CC067790E94520D8AD1FA542")

        Point mContentSize;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.752 -0400", hash_original_field = "AD3A2D98B61B82499ADA8604D991DF89", hash_generated_field = "050B6649CE7A7C5E58ADF2EC10BD7076")

        int mMinPrefWidth;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.752 -0400", hash_original_field = "3F088890CFE30E538C3D2C652B474C97", hash_generated_field = "6833E897B71269A6061BC9758C2D0546")

        ViewState mViewState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.752 -0400", hash_original_field = "BD00C24C9CE113CE814ECA4C6FA28EA5", hash_generated_field = "27B1CFFB12B3E61CF3D315C9C963BA4A")

        boolean mFirstLayoutForNonStandardLoad;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.752 -0400", hash_original_field = "FBB56B1C754DD12839C104686E546E7C", hash_generated_field = "30C90FD55CE7043C6521FC20BFE142EE")

        boolean mFocusSizeChanged;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.752 -0400", hash_original_method = "0A5C1715167608A1FCEB50646E4B5581", hash_generated_method = "70BF4AD47CB5514A3FE69474E31423AD")
          DrawData() {
            mBaseLayer = 0;
            mInvalRegion = new Region();
            mContentSize = new Point();
            
            
            
            
        }

        
    }


    
    static class ShowRectData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.752 -0400", hash_original_field = "B5B776A6642DD69B16A47E6FCCAEEB6E", hash_generated_field = "9CA1F6E0E5F07E62C54326FC8CE74F9B")

        int mLeft;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.752 -0400", hash_original_field = "D09DA346C6637C81F0228C8D0347388B", hash_generated_field = "A99CCC9E9A86D41F2B4D997ACBCFA99E")

        int mTop;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.752 -0400", hash_original_field = "A3DB1626A190732E588FD0D14FC8FB31", hash_generated_field = "AF6410B200BC05DCA2CF0BE65165448A")

        int mWidth;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.752 -0400", hash_original_field = "483542B05A951AA16D89C7F809C20811", hash_generated_field = "7DDAE255893B528E7BEBEC203BC2D9F3")

        int mHeight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.752 -0400", hash_original_field = "8CAE9DDC87DDEC99A752E150A6F5EE2F", hash_generated_field = "E53904AD377D72960D8A5847D00D2A72")

        int mContentWidth;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.752 -0400", hash_original_field = "F40FB88A5310D2E8A8F0AC8C692796A5", hash_generated_field = "6909FC61CEAFC4290968B35F30281B2B")

        int mContentHeight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.752 -0400", hash_original_field = "1CB7DA806FEDE27B3D85DDC4E3AB1B0A", hash_generated_field = "9541CF04A8FA15E14BA5558D031AB38E")

        float mXPercentInDoc;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.752 -0400", hash_original_field = "A8BC8C902071D3674FC1CE7D46B9BFF8", hash_generated_field = "29D6FC802D779E2A67410E8D69C39C22")

        float mXPercentInView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.752 -0400", hash_original_field = "5DEA6D43AA731D92D2C7DC7F062E34D9", hash_generated_field = "687FFE76DBA3D2C22AFDA5A43C9D0215")

        float mYPercentInDoc;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.752 -0400", hash_original_field = "640C977429104228121173F59D55A605", hash_generated_field = "DDCBD14F4A5E533655283E96B0B12B22")

        float mYPercentInView;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.752 -0400", hash_original_method = "C48E9140E1D319035D16E0B3D36DB69D", hash_generated_method = "C48E9140E1D319035D16E0B3D36DB69D")
        public ShowRectData ()
        {
            
        }


    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.752 -0400", hash_original_field = "613F92366811897B912F043514E1C8A5", hash_generated_field = "156AE3FBA7693C0541A9ED869503084C")

    private static final String LOGTAG = "webcore";
    static {
        try {
            System.loadLibrary("webcore");
            System.loadLibrary("chromium_net");
        } catch (UnsatisfiedLinkError e) {
            Log.e(LOGTAG, "Unable to load native support libraries.");
        }
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.752 -0400", hash_original_field = "A8C3F0C0077472539258F6817F944AFB", hash_generated_field = "F8DBA8A88C166EE939C099D210E444F3")

    static final String THREAD_NAME = "WebViewCoreThread";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.752 -0400", hash_original_field = "9E86D1F0F021B5C123525EE9186215E2", hash_generated_field = "7806C85B1473EEA07D454824B9537F05")

    private static Handler sWebCoreHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.752 -0400", hash_original_field = "E116E8884695CCA9A35EDA2BFA99C2FD", hash_generated_field = "03293BED9E7EF4FD7AD7E24A578DAF9F")

    static final int ACTION_LONGPRESS = 0x100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.752 -0400", hash_original_field = "08A3376EE4C625F60CF7DC7617E3DE47", hash_generated_field = "681A806B33AE998418561D7AD6E4C4EC")

    static final int ACTION_DOUBLETAP = 0x200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.753 -0400", hash_original_field = "E325475200B3A043373A5C43E4C159CE", hash_generated_field = "3851A95DD7F1D174566A6478D4C2856D")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.753 -0400", hash_original_field = "5F26305B42DD1EACFF3673E6DF392538", hash_generated_field = "5D3F8F446516C769748CEB66EAB40D31")

    private static boolean mRepaintScheduled = false;
}

