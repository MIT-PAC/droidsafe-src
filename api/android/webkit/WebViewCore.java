package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import junit.framework.Assert;
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

public final class WebViewCore {

    //-------------------------------------------------------------------------
    // Common methods
    //-------------------------------------------------------------------------

    /**
     * Causes all timers to pause. This applies to all WebViews in the current
     * app process.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:06.961 -0500", hash_original_method = "17F8945CD061768B74E94788483D8BB3", hash_generated_method = "58CDF0B92616E046601827ABF090FF71")
    
public static void pauseTimers() {
        if (BrowserFrame.sJavaBridge == null) {
            throw new IllegalStateException(
                    "No WebView has been created in this process!");
        }
        BrowserFrame.sJavaBridge.pause();
    }

    /**
     * Resume all timers. This applies to all WebViews in the current process.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:06.964 -0500", hash_original_method = "A09FFD0724C9FDF42E343E15D3777A7E", hash_generated_method = "8EFD25694144D5D97FB4797756B34472")
    
public static void resumeTimers() {
        if (BrowserFrame.sJavaBridge == null) {
            throw new IllegalStateException(
                    "No WebView has been created in this process!");
        }
        BrowserFrame.sJavaBridge.resume();
    }

    /*
     * Given mimeType, check whether it's supported in Android media framework.
     * mimeType could be such as "audio/ogg" and "video/mp4".
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:06.968 -0500", hash_original_method = "C06DFC3BA0FF6144809A3901B3CEE279", hash_generated_method = "04B3CB843FABD7DA6B641F323A3A7C92")
    
static boolean isSupportedMediaMimeType(String mimeType) {
        int fileType = MediaFile.getFileTypeForMimeType(mimeType);
        return MediaFile.isAudioFileType(fileType)
            || MediaFile.isVideoFileType(fileType)
            || MediaFile.isPlayListFileType(fileType)
            // The following is not in Media framework, but it's supported.
            || (mimeType != null && mimeType.startsWith("video/m4v"));
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    static String nativeFindAddress(String addr, boolean caseInsensitive) {
        	return new String(addr);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.749 -0500", hash_original_method = "CD9DCFC52361DD1CC904D1A566C27AE8", hash_generated_method = "90F8448C840BDAF63B4313BE803AA33B")
    
static void reducePriority() {
        // remove the pending REDUCE_PRIORITY and RESUME_PRIORITY messages
        sWebCoreHandler.removeMessages(WebCoreThread.REDUCE_PRIORITY);
        sWebCoreHandler.removeMessages(WebCoreThread.RESUME_PRIORITY);
        sWebCoreHandler.sendMessageAtFrontOfQueue(sWebCoreHandler
                .obtainMessage(WebCoreThread.REDUCE_PRIORITY));
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.751 -0500", hash_original_method = "D199F7D9A872368E06ADA82D93B864C9", hash_generated_method = "DC36F0A420876A6776AEDE69346F722E")
    
static void resumePriority() {
        // remove the pending REDUCE_PRIORITY and RESUME_PRIORITY messages
        sWebCoreHandler.removeMessages(WebCoreThread.REDUCE_PRIORITY);
        sWebCoreHandler.removeMessages(WebCoreThread.RESUME_PRIORITY);
        sWebCoreHandler.sendMessageAtFrontOfQueue(sWebCoreHandler
                .obtainMessage(WebCoreThread.RESUME_PRIORITY));
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.753 -0500", hash_original_method = "FDF517A61BD810F4A76EEDCFD0DE563E", hash_generated_method = "2A9E509A4C64935B7E95AEF863582375")
    
static void sendStaticMessage(int messageType, Object argument) {
        if (sWebCoreHandler == null)
            return;

        sWebCoreHandler.sendMessage(sWebCoreHandler.obtainMessage(messageType, argument));
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.755 -0500", hash_original_method = "BD698E881938103C80153102B47754F9", hash_generated_method = "09C2F49DEB5E2ABE9397CDEDF745C6AB")
    
static void pauseUpdatePicture(WebViewCore core) {
        // Note: there is one possible failure mode. If pauseUpdatePicture() is
        // called from UI thread while WEBKIT_DRAW is just pulled out of the
        // queue in WebCore thread to be executed. Then update won't be blocked.
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

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.757 -0500", hash_original_method = "BDB39E0768239C7CFFB7960C06284CDC", hash_generated_method = "5F8E667C056ABBCE48A996D956B31CC7")
    
static void resumeUpdatePicture(WebViewCore core) {
        if (core != null) {
            // if mDrawIsPaused is true, ignore the setting, continue to resume
            if (!core.mDrawIsPaused)
                return;

            synchronized (core) {
                if (core.mNativeClass == 0) {
                    Log.w(LOGTAG, "Cannot resumeUpdatePicture, core destroyed!");
                    return;
                }
                core.nativeSetIsPaused(false);
                core.mDrawIsPaused = false;
                // always redraw on resume to reenable gif animations
                core.mDrawIsScheduled = false;
            }
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.760 -0500", hash_original_method = "656574A4E486E16C4AEF1FAAD1266DCC", hash_generated_method = "190CFFD41DF71E1EE4AFDA983CDD9C23")
    
static boolean isUpdatePicturePaused(WebViewCore core) {
        return core != null ? core.mDrawIsPaused : false;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:06.892 -0500", hash_original_field = "C92A9D13079E4D14D4D0606FBA5F61AD", hash_generated_field = "156AE3FBA7693C0541A9ED869503084C")

    private static final String LOGTAG = "webcore";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:06.949 -0500", hash_original_field = "6A3DA9FC322E7D7078828760267C52A1", hash_generated_field = "2678EAA1CA6FE18DABACCF28374B28C3")

    // debugging other classes that require operation within the WebCore thread.
    /* package */ static final String THREAD_NAME = "WebViewCoreThread";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.171 -0500", hash_original_field = "EFC6150695993E8116301F1243F9C9E3", hash_generated_field = "7806C85B1473EEA07D454824B9537F05")

    private static Handler sWebCoreHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.323 -0500", hash_original_field = "9B09348C3696C4A65CA0062269C19B98", hash_generated_field = "4F4FE0FB18FB73AE0075C7886A55CE16")

    // last two bytes or one of the following values
    static final int ACTION_LONGPRESS = 0x100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.325 -0500", hash_original_field = "162B3B5842605A2D160F8F2B8C2F869D", hash_generated_field = "681A806B33AE998418561D7AD6E4C4EC")

    static final int ACTION_DOUBLETAP = 0x200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.364 -0500", hash_original_field = "C5C9A2320EB0C7D2C92004E1B6C34376", hash_generated_field = "C3B1F5F343B63EED699BEDE4A3F249E3")

        static final String[] HandlerDebugString = {
            "REVEAL_SELECTION", // 96
            "REQUEST_LABEL", // 97
            "UPDATE_FRAME_CACHE_IF_LOADING", // = 98
            "SCROLL_TEXT_INPUT", // = 99
            "LOAD_URL", // = 100;
            "STOP_LOADING", // = 101;
            "RELOAD", // = 102;
            "KEY_DOWN", // = 103;
            "KEY_UP", // = 104;
            "VIEW_SIZE_CHANGED", // = 105;
            "GO_BACK_FORWARD", // = 106;
            "SET_SCROLL_OFFSET", // = 107;
            "RESTORE_STATE", // = 108;
            "PAUSE_TIMERS", // = 109;
            "RESUME_TIMERS", // = 110;
            "CLEAR_CACHE", // = 111;
            "CLEAR_HISTORY", // = 112;
            "SET_SELECTION", // = 113;
            "REPLACE_TEXT", // = 114;
            "PASS_TO_JS", // = 115;
            "SET_GLOBAL_BOUNDS", // = 116;
            "UPDATE_CACHE_AND_TEXT_ENTRY", // = 117;
            "CLICK", // = 118;
            "SET_NETWORK_STATE", // = 119;
            "DOC_HAS_IMAGES", // = 120;
            "FAKE_CLICK", // = 121;
            "DELETE_SELECTION", // = 122;
            "LISTBOX_CHOICES", // = 123;
            "SINGLE_LISTBOX_CHOICE", // = 124;
            "MESSAGE_RELAY", // = 125;
            "SET_BACKGROUND_COLOR", // = 126;
            "SET_MOVE_FOCUS", // = 127
            "SAVE_DOCUMENT_STATE", // = 128;
            "129", // = 129;
            "WEBKIT_DRAW", // = 130;
            "131", // = 131;
            "POST_URL", // = 132;
            "SPLIT_PICTURE_SET", // = 133;
            "CLEAR_CONTENT", // = 134;
            "SET_MOVE_MOUSE", // = 135;
            "SET_MOVE_MOUSE_IF_LATEST", // = 136;
            "REQUEST_CURSOR_HREF", // = 137;
            "ADD_JS_INTERFACE", // = 138;
            "LOAD_DATA", // = 139;
            "TOUCH_UP", // = 140;
            "TOUCH_EVENT", // = 141;
            "SET_ACTIVE", // = 142;
            "ON_PAUSE",     // = 143
            "ON_RESUME",    // = 144
            "FREE_MEMORY",  // = 145
            "VALID_NODE_BOUNDS", // = 146
            "SAVE_WEBARCHIVE", // = 147
            "WEBKIT_DRAW_LAYERS", // = 148;
            "REMOVE_JS_INTERFACE", // = 149;
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.776 -0500", hash_original_field = "1E0DFB915613907C2DC918C7150B4F25", hash_generated_field = "5D3F8F446516C769748CEB66EAB40D31")

    private static boolean mRepaintScheduled = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:06.895 -0500", hash_original_field = "E044D69EE05B24F4B93E3A3B208F5343", hash_generated_field = "F3D03AACA93152F6F6578722BEFFF27E")

    // The WebView that corresponds to this WebViewCore.
    private WebView mWebView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:06.898 -0500", hash_original_field = "C50B804397335F4C59F495D6A5AAA565", hash_generated_field = "62789CA10670C708EA4D387AB18C5F89")

    private  CallbackProxy mCallbackProxy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:06.900 -0500", hash_original_field = "A5E24FAE08D22101EAD3684EE47BCBA3", hash_generated_field = "D4F7B9B886C1ADC785C82D3DD8AF3DFF")

    private  WebSettings mSettings;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:06.902 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private  Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:06.904 -0500", hash_original_field = "07FEFC5B2084F76E6CC54B7208111C50", hash_generated_field = "2BD5B1AE4AB832378640307848134713")

    private int mNativeClass;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:06.906 -0500", hash_original_field = "3FC88C05AF84F1DA5801895C1A5E2AA9", hash_generated_field = "076F5BF2A47D119E2704BFAF413B4749")

    private BrowserFrame mBrowserFrame;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:06.908 -0500", hash_original_field = "28642C9C56C4E17BFB3F9102A69B5FA2", hash_generated_field = "F17541A56F563F7681D9F0B5FA6C35F3")

    private Map<String, Object> mJavascriptInterfaces;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:06.910 -0500", hash_original_field = "7EF3B9D07AB7F25FD7BF807CB84C3EB4", hash_generated_field = "521238B14726DD513D30C80A6B0A4C4F")

    private int mViewportWidth = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:06.912 -0500", hash_original_field = "D28968F3755E188906071FC5B5299F38", hash_generated_field = "75EA3BEE624948F33D1F6360DFF985C0")

    private int mViewportHeight = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:06.915 -0500", hash_original_field = "0ECA92F7C2824961D42EC347618172AA", hash_generated_field = "CEAB5098F68220A2E297373A8452CBED")

    private int mViewportInitialScale = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:06.917 -0500", hash_original_field = "8B09A64E9D5C11864D1A8BE301D50F64", hash_generated_field = "153534A1ABB8629DDD645A0AC85B2B41")

    private int mViewportMinimumScale = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:06.919 -0500", hash_original_field = "7F520951CCE975C41E67BE129793CB49", hash_generated_field = "8A6C8840919CE5601294EFBA0BF7842F")

    private int mViewportMaximumScale = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:06.921 -0500", hash_original_field = "AA73A362D8A55A4263181FEF46D0516A", hash_generated_field = "A661C7EB7326B99462ADD2006473EBB6")

    private boolean mViewportUserScalable = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:06.923 -0500", hash_original_field = "FAE1B588E94AA75522AD6044393B6BEE", hash_generated_field = "23CD0989B091ED130F15286A65580618")

    private int mViewportDensityDpi = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:06.925 -0500", hash_original_field = "430E13CFFA9DFC88EA12C3348D065EF4", hash_generated_field = "E18380366D9A101C0E9802BA75F6285F")

    private boolean mIsRestored = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:06.927 -0500", hash_original_field = "B845916060358B4D300FA7C473545677", hash_generated_field = "7DF3DF814194A4D3E9669659B565EAA6")

    private float mRestoredScale = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:06.929 -0500", hash_original_field = "9589D78F00505247E5154D99146F3C1D", hash_generated_field = "A7C3BC549C1C4C3FA2CF2DCC3B010912")

    private float mRestoredTextWrapScale = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:06.931 -0500", hash_original_field = "1183E8579648325CCEF2F49F516AE4B7", hash_generated_field = "067608C0EFAAE5432895398625DB6A61")

    private int mRestoredX = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:06.933 -0500", hash_original_field = "D8F1BCC93E32FAC43D1656FA931ACEA2", hash_generated_field = "06A420E9C731F1A1669DED8B10031D96")

    private int mRestoredY = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:06.936 -0500", hash_original_field = "0F8A87026B53868E7FC385DA10DF2BA6", hash_generated_field = "1983618B97F984600A83B440BC15F541")

    private DeviceMotionAndOrientationManager mDeviceMotionAndOrientationManager =
            new DeviceMotionAndOrientationManager(this);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:06.938 -0500", hash_original_field = "4D3344B6324E1BA7E1DF0ED3DD608B71", hash_generated_field = "92420661BA494DCA46BDE3AD43DFB367")

    private DeviceMotionService mDeviceMotionService;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:06.940 -0500", hash_original_field = "EC9B3CAA3694630652FA4164543BBBD8", hash_generated_field = "9F3BAB665FD36E76D05874B5724604CE")

    private DeviceOrientationService mDeviceOrientationService;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:06.942 -0500", hash_original_field = "4011C681C8ECB138066969A3B437BD14", hash_generated_field = "B1C1FA299AFCD0EE8836BFF28A3ACBB2")

    private int mLowMemoryUsageThresholdMb;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:06.944 -0500", hash_original_field = "2D03524AFAA7F0C895BD236889DE5A87", hash_generated_field = "373468742C5EE8AC90EA3B7AB1294D81")

    private int mHighMemoryUsageThresholdMb;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:06.946 -0500", hash_original_field = "BAF8B5C87388F3F5A5CF684FFB0D43F2", hash_generated_field = "C3563E94A24603EC3F85758B2B971DA0")

    private int mHighUsageDeltaMb;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.169 -0500", hash_original_field = "B854382C5AC540BFEEF4FBC2BBD71D0A", hash_generated_field = "E97C48C6ED52F2E8E8BB54B79F57CF9E")

    private  EventHub mEventHub;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.661 -0500", hash_original_field = "5B1DED2D03D1302328F5361D9D546EE5", hash_generated_field = "C04E91045AFFBEFA87C572262F389255")

    private int mCurrentViewWidth = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.663 -0500", hash_original_field = "4675731D455657901B57DD6573A0B28F", hash_generated_field = "256209E290B11ACF842BB422B72F67F8")

    private int mCurrentViewHeight = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.665 -0500", hash_original_field = "CDE66333D5F5DA3CD919867F0DA421D9", hash_generated_field = "5803229BA67F4C111F2EC54135FAEBDE")

    private float mCurrentViewScale = 1.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.681 -0500", hash_original_field = "46B0253C07B37F09D58BEEECAD9C67D0", hash_generated_field = "34B754510376D214E2C01349025B5BA6")

    private boolean mDrawIsScheduled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.683 -0500", hash_original_field = "DC8148AC9FA8503E5940EBEA0B26DBF6", hash_generated_field = "400D1A405667E6D7749B38B85BCFED17")

    private boolean mDrawLayersIsScheduled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.685 -0500", hash_original_field = "E02D160F8AF45B1F7254A9CDD9613E64", hash_generated_field = "8BFF2E0C3750D9DDE06D17BA45ED39F3")

    private boolean mSplitPictureIsScheduled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.687 -0500", hash_original_field = "7FE11C853B5D2EB73C000643E5C1E913", hash_generated_field = "0C2D89B52FE2D2E58479EAC212A17A93")

    private boolean mDrawIsPaused;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.689 -0500", hash_original_field = "D7DD9F57513FB261D002C102949F4857", hash_generated_field = "F28E9E4F618A89BD5FF624C94A12894F")

    // next webkitDraw after passing the state to the UI thread.
    private ViewState mInitialViewState = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.691 -0500", hash_original_field = "27B1CFFB12B3E61CF3D315C9C963BA4A", hash_generated_field = "8538C7090C948C7AD430607E6FB8A74E")

    private boolean mFirstLayoutForNonStandardLoad;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.738 -0500", hash_original_field = "2409AAF0DDA2BB89F3E937FCB53EA95F", hash_generated_field = "2409AAF0DDA2BB89F3E937FCB53EA95F")

    DrawData mLastDrawData = null;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:06.952 -0500", hash_original_method = "68CF15993B11FD0BF4AA086C5A956766", hash_generated_method = "80EBA3890ACDA41A953DED4C2D83E8C8")
    
public WebViewCore(Context context, WebView w, CallbackProxy proxy,
            Map<String, Object> javascriptInterfaces) {
        // No need to assign this in the WebCore thread.
        mCallbackProxy = proxy;
        mWebView = w;
        mJavascriptInterfaces = javascriptInterfaces;
        // This context object is used to initialize the WebViewCore during
        // subwindow creation.
        mContext = context;

        // We need to wait for the initial thread creation before sending
        // a message to the WebCore thread.
        // XXX: This is the only time the UI thread will wait for the WebCore
        // thread!
        synchronized (WebViewCore.class) {
            if (sWebCoreHandler == null) {
                // Create a global thread and start it.
                Thread t = new Thread(new WebCoreThread());
                t.setName(THREAD_NAME);
                t.start();
                try {
                    WebViewCore.class.wait();
                } catch (InterruptedException e) {
                    Log.e(LOGTAG, "Caught exception while waiting for thread " +
                           "creation.");
                    Log.e(LOGTAG, Log.getStackTraceString(e));
                }
            }
        }
        // Create an EventHub to handle messages before and after the thread is
        // ready.
        mEventHub = new EventHub();
        // Create a WebSettings object for maintaining all settings
        mSettings = new WebSettings(mContext, mWebView);
        // The WebIconDatabase needs to be initialized within the UI thread so
        // just request the instance here.
        WebIconDatabase.getInstance();
        // Create the WebStorage singleton and the UI handler
        WebStorage.getInstance().createUIHandler();
        // Create the UI handler for GeolocationPermissions
        GeolocationPermissions.getInstance().createUIHandler();

        // Get the memory class of the current device. V8 will use these values
        // to GC more effectively.
        ActivityManager manager = (ActivityManager) mContext.getSystemService(
                Context.ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo memInfo = new ActivityManager.MemoryInfo();
        manager.getMemoryInfo(memInfo);

        // Allow us to use up to our memory class value before V8's GC kicks in.
        // These values have been determined by experimentation.
        mLowMemoryUsageThresholdMb = manager.getLargeMemoryClass();
        mHighMemoryUsageThresholdMb = (int) (mLowMemoryUsageThresholdMb * 1.5);
        // Avoid constant V8 GC when memory usage equals to working set estimate.
        mHighUsageDeltaMb = mLowMemoryUsageThresholdMb / 32;

        // Send a message to initialize the WebViewCore.
        Message init = sWebCoreHandler.obtainMessage(
                WebCoreThread.INITIALIZE, this);
        sWebCoreHandler.sendMessage(init);
    }
    
    /*
     * instead of sending a message through a queue and having message
     * processed by another thread, we process it with droidsafeHandleMessage
     */
    @DSVerified
    @DSBan(DSCat.DROIDSAFE_INTERNAL)
    public void droidsafeHandleMessage(Message msg) {
        switch (msg.what) {
            case EventHub.WEBKIT_DRAW:
                webkitDraw();
                break;

            case EventHub.WEBKIT_DRAW_LAYERS:
                webkitDrawLayers();
                break;

            case EventHub.DESTROY:
                // Time to take down the world. Cancel all pending
                // loads and destroy the native view and frame.
                synchronized (WebViewCore.this) {
                    mBrowserFrame.destroy();
                    mBrowserFrame = null;
                    mSettings.onDestroyed();
                    mNativeClass = 0;
                    mWebView = null;
                }
                break;

            case EventHub.REVEAL_SELECTION:
                nativeRevealSelection();
                break;

            case EventHub.REQUEST_LABEL:
                if (mWebView != null) {
                    int nodePointer = msg.arg2;
                    String label = nativeRequestLabel(msg.arg1,
                            nodePointer);
                    if (label != null && label.length() > 0) {
                        Message.obtain(mWebView.mPrivateHandler,
                                WebView.RETURN_LABEL, nodePointer,
                                0, label).sendToTarget();
                    }
                }
                break;

            case EventHub.UPDATE_FRAME_CACHE_IF_LOADING:
                nativeUpdateFrameCacheIfLoading();
                break;

            case EventHub.SCROLL_TEXT_INPUT:
                float xPercent;
                if (msg.obj == null) {
                    xPercent = 0f;
                } else {
                    xPercent = ((Float) msg.obj).floatValue();
                }
                nativeScrollFocusedTextInput(xPercent, msg.arg2);
                break;

            case EventHub.LOAD_URL: {
                GetUrlData param = (GetUrlData) msg.obj;
                loadUrl(param.mUrl, param.mExtraHeaders);
                break;
            }

            case EventHub.POST_URL: {
                CookieManager.getInstance().waitForCookieOperationsToComplete();
                PostUrlData param = (PostUrlData) msg.obj;
                mBrowserFrame.postUrl(param.mUrl, param.mPostData);
                
            }
            case EventHub.LOAD_DATA:
                CookieManager.getInstance().waitForCookieOperationsToComplete();
                BaseUrlData loadParams = (BaseUrlData) msg.obj;
                String baseUrl = loadParams.mBaseUrl;
                if (baseUrl != null) {
                    int i = baseUrl.indexOf(':');
                    if (i > 0) {
                        // In 1.0, WebView.loadDataWithBaseURL() could access local
                        // asset files using 'file' scheme URLs as long as the data is
                        // valid. Later versions of WebKit have tightened the
                        // restriction around when pages can access such local URLs.
                        // To maintain compatibility with 1.0, we register the scheme of
                        // the baseUrl to be considered local, as long as it is not
                        // http(s)/ftp(s)/about/javascript.
                        String scheme = baseUrl.substring(0, i);
                        if (!scheme.startsWith("http") &&
                                !scheme.startsWith("ftp") &&
                                !scheme.startsWith("about") &&
                                !scheme.startsWith("javascript")) {
                            nativeRegisterURLSchemeAsLocal(scheme);
                        }
                    }
                }
                mBrowserFrame.loadData(baseUrl,
                        loadParams.mData,
                        loadParams.mMimeType,
                        loadParams.mEncoding,
                        loadParams.mHistoryUrl);
                nativeContentInvalidateAll();
                break;

            case EventHub.STOP_LOADING:
                // If the WebCore has committed the load, but not
                // finished the first layout yet, we need to set
                // first layout done to trigger the interpreted side sync
                // up with native side
                if (mBrowserFrame.committed()
                        && !mBrowserFrame.firstLayoutDone()) {
                    mBrowserFrame.didFirstLayout();
                }
                // Do this after syncing up the layout state.
                stopLoading();
                break;

            case EventHub.RELOAD:
                mBrowserFrame.reload(false);
                break;

            case EventHub.KEY_DOWN:
                key((KeyEvent) msg.obj, true);
                break;

            case EventHub.KEY_UP:
                key((KeyEvent) msg.obj, false);
                break;

            case EventHub.FAKE_CLICK:
                nativeClick(msg.arg1, msg.arg2, true);
                break;

            case EventHub.CLICK:
                nativeClick(msg.arg1, msg.arg2, false);
                break;

            case EventHub.VIEW_SIZE_CHANGED: {
                viewSizeChanged((WebView.ViewSizeData) msg.obj);
                break;
            }
            case EventHub.SET_SCROLL_OFFSET:
                // note: these are in document coordinates
                // (inv-zoom)
                Point pt = (Point) msg.obj;
                nativeSetScrollOffset(msg.arg1, msg.arg2 == 1,
                        pt.x, pt.y);
                break;

            case EventHub.SET_GLOBAL_BOUNDS:
                Rect r = (Rect) msg.obj;
                nativeSetGlobalBounds(r.left, r.top, r.width(),
                    r.height());
                break;

            case EventHub.GO_BACK_FORWARD:
                // If it is a standard load and the load is not
                // committed yet, we interpret BACK as RELOAD
                if (!mBrowserFrame.committed() && msg.arg1 == -1 &&
                        (mBrowserFrame.loadType() ==
                        BrowserFrame.FRAME_LOADTYPE_STANDARD)) {
                    mBrowserFrame.reload(true);
                } else {
                    mBrowserFrame.goBackOrForward(msg.arg1);
                }
                break;

            case EventHub.RESTORE_STATE:
                stopLoading();
                restoreState(msg.arg1);
                break;

            case EventHub.PAUSE_TIMERS:
                break;

            case EventHub.RESUME_TIMERS:
                break;

            case EventHub.ON_PAUSE:
                nativePause();
                break;

            case EventHub.ON_RESUME:
                nativeResume();
                break;

            case EventHub.FREE_MEMORY:
                clearCache(false);
                nativeFreeMemory();
                break;

            case EventHub.SET_NETWORK_STATE:
                if (BrowserFrame.sJavaBridge == null) {
                    throw new IllegalStateException("No WebView " +
                            "has been created in this process!");
                }
                BrowserFrame.sJavaBridge
                        .setNetworkOnLine(msg.arg1 == 1);
                break;

            case EventHub.SET_NETWORK_TYPE:
                if (BrowserFrame.sJavaBridge == null) {
                    throw new IllegalStateException("No WebView " +
                            "has been created in this process!");
                }
                Map<String, String> map = (Map<String, String>) msg.obj;
                BrowserFrame.sJavaBridge
                        .setNetworkType(map.get("type"), map.get("subtype"));
                break;

            case EventHub.CLEAR_CACHE:
                clearCache(msg.arg1 == 1);
                break;

            case EventHub.CLEAR_HISTORY:
                mCallbackProxy.getBackForwardList().
                        close(mBrowserFrame.mNativeFrame);
                break;

            case EventHub.REPLACE_TEXT:
                ReplaceTextData rep = (ReplaceTextData) msg.obj;
                nativeReplaceTextfieldText(msg.arg1, msg.arg2,
                        rep.mReplace, rep.mNewStart, rep.mNewEnd,
                        rep.mTextGeneration);
                break;

            case EventHub.PASS_TO_JS: {
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
                break;
            }

            case EventHub.SAVE_DOCUMENT_STATE: {
                CursorData cDat = (CursorData) msg.obj;
                nativeSaveDocumentState(cDat.mFrame);
                break;
            }

            case EventHub.CLEAR_SSL_PREF_TABLE:
                if (JniUtil.useChromiumHttpStack()) {
                    // FIXME: This will not work for connections currently in use, as
                    // they cache the certificate responses. See http://b/5324235.
                    SslCertLookupTable.getInstance().clear();
                    nativeCloseIdleConnections();
                } else {
                    Network.getInstance(mContext).clearUserSslPrefTable();
                }
                break;

            case EventHub.TOUCH_UP:
                TouchUpData touchUpData = (TouchUpData) msg.obj;
                if (touchUpData.mNativeLayer != 0) {
                    nativeScrollLayer(touchUpData.mNativeLayer,
                            touchUpData.mNativeLayerRect);
                }
                nativeTouchUp(touchUpData.mMoveGeneration,
                        touchUpData.mFrame, touchUpData.mNode,
                        touchUpData.mX, touchUpData.mY);
                break;

            case EventHub.TOUCH_EVENT: {
                TouchEventData ted = (TouchEventData) msg.obj;
                final int count = ted.mPoints.length;
                int[] xArray = new int[count];
                int[] yArray = new int[count];
                for (int c = 0; c < count; c++) {
                    xArray[c] = ted.mPoints[c].x;
                    yArray[c] = ted.mPoints[c].y;
                }
                if (ted.mNativeLayer != 0) {
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
                break;
            }

            case EventHub.SET_ACTIVE:
                nativeSetFocusControllerActive(msg.arg1 == 1);
                break;

            case EventHub.ADD_JS_INTERFACE:
                JSInterfaceData jsData = (JSInterfaceData) msg.obj;
                mBrowserFrame.addJavascriptInterface(jsData.mObject,
                        jsData.mInterfaceName);
                break;

            case EventHub.REMOVE_JS_INTERFACE:
                jsData = (JSInterfaceData) msg.obj;
                mBrowserFrame.removeJavascriptInterface(
                        jsData.mInterfaceName);
                break;

            case EventHub.REQUEST_EXT_REPRESENTATION:
                mBrowserFrame.externalRepresentation(
                        (Message) msg.obj);
                break;

            case EventHub.REQUEST_DOC_AS_TEXT:
                mBrowserFrame.documentAsText((Message) msg.obj);
                break;

            case EventHub.SET_MOVE_FOCUS:
                CursorData focusData = (CursorData) msg.obj;
                nativeMoveFocus(focusData.mFrame, focusData.mNode);
                break;

            case EventHub.SET_MOVE_MOUSE:
                CursorData cursorData = (CursorData) msg.obj;
                nativeMoveMouse(cursorData.mFrame,
                         cursorData.mX, cursorData.mY);
                break;

            case EventHub.SET_MOVE_MOUSE_IF_LATEST:
                CursorData cData = (CursorData) msg.obj;
                nativeMoveMouseIfLatest(cData.mMoveGeneration,
                        cData.mFrame,
                        cData.mX, cData.mY);
                if (msg.arg1 == 1) {
                    nativeStopPaintingCaret();
                }
                break;

            case EventHub.REQUEST_CURSOR_HREF: {
                Message hrefMsg = (Message) msg.obj;
                hrefMsg.getData().putString("url",
                        nativeRetrieveHref(msg.arg1, msg.arg2));
                hrefMsg.getData().putString("title",
                        nativeRetrieveAnchorText(msg.arg1, msg.arg2));
                hrefMsg.getData().putString("src",
                        nativeRetrieveImageSource(msg.arg1, msg.arg2));
                hrefMsg.sendToTarget();
                break;
            }

            case EventHub.UPDATE_CACHE_AND_TEXT_ENTRY:
                nativeUpdateFrameCache();
                // FIXME: this should provide a minimal rectangle
                if (mWebView != null) {
                    mWebView.postInvalidate();
                }
                sendUpdateTextEntry();
                break;

            case EventHub.DOC_HAS_IMAGES:
                Message imageResult = (Message) msg.obj;
                imageResult.arg1 =
                        mBrowserFrame.documentHasImages() ? 1 : 0;
                imageResult.sendToTarget();
                break;

            case EventHub.DELETE_SELECTION:
                TextSelectionData deleteSelectionData
                        = (TextSelectionData) msg.obj;
                nativeDeleteSelection(deleteSelectionData.mStart,
                        deleteSelectionData.mEnd, msg.arg1);
                break;

            case EventHub.SET_SELECTION:
                nativeSetSelection(msg.arg1, msg.arg2);
                break;

            case EventHub.MODIFY_SELECTION:
                String modifiedSelectionString = nativeModifySelection(msg.arg1,
                        msg.arg2);
                mWebView.mPrivateHandler.obtainMessage(WebView.SELECTION_STRING_CHANGED,
                        modifiedSelectionString).sendToTarget();
                break;

            case EventHub.LISTBOX_CHOICES:
                SparseBooleanArray choices = (SparseBooleanArray)
                        msg.obj;
                int choicesSize = msg.arg1;
                boolean[] choicesArray = new boolean[choicesSize];
                for (int c = 0; c < choicesSize; c++) {
                    choicesArray[c] = choices.get(c);
                }
                nativeSendListBoxChoices(choicesArray,
                        choicesSize);
                break;

            case EventHub.SINGLE_LISTBOX_CHOICE:
                nativeSendListBoxChoice(msg.arg1);
                break;

            case EventHub.SET_BACKGROUND_COLOR:
                nativeSetBackgroundColor(msg.arg1);
                break;

            case EventHub.DUMP_DOMTREE:
                nativeDumpDomTree(msg.arg1 == 1);
                break;

            case EventHub.DUMP_RENDERTREE:
                nativeDumpRenderTree(msg.arg1 == 1);
                break;

            case EventHub.DUMP_NAVTREE:
                nativeDumpNavTree();
                break;

            case EventHub.DUMP_V8COUNTERS:
                nativeDumpV8Counters();
                break;

            case EventHub.SET_JS_FLAGS:
                nativeSetJsFlags((String)msg.obj);
                break;

            case EventHub.CONTENT_INVALIDATE_ALL:
                nativeContentInvalidateAll();
                break;

            case EventHub.SAVE_WEBARCHIVE:
                WebView.SaveWebArchiveMessage saveMessage =
                    (WebView.SaveWebArchiveMessage)msg.obj;
                saveMessage.mResultFile =
                    saveWebArchive(saveMessage.mBasename, saveMessage.mAutoname);
                mWebView.mPrivateHandler.obtainMessage(
                    WebView.SAVE_WEBARCHIVE_FINISHED, saveMessage).sendToTarget();
                break;

            case EventHub.GEOLOCATION_PERMISSIONS_PROVIDE:
                GeolocationPermissionsData data =
                        (GeolocationPermissionsData) msg.obj;
                nativeGeolocationPermissionsProvide(data.mOrigin,
                        data.mAllow, data.mRemember);
                break;

            case EventHub.SPLIT_PICTURE_SET:
                nativeSplitContent(msg.arg1);
                mWebView.mPrivateHandler.obtainMessage(
                        WebView.REPLACE_BASE_CONTENT, msg.arg1, 0);
                mSplitPictureIsScheduled = false;
                break;

            case EventHub.CLEAR_CONTENT:
                // Clear the view so that onDraw() will draw nothing
                // but white background
                // (See public method WebView.clearView)
                nativeClearContent();
                break;

            case EventHub.MESSAGE_RELAY:
                ((Message) msg.obj).sendToTarget();
                break;

            case EventHub.POPULATE_VISITED_LINKS:
                nativeProvideVisitedHistory((String[])msg.obj);
                break;

            case EventHub.VALID_NODE_BOUNDS: {
                MotionUpData motionUpData = (MotionUpData) msg.obj;
                if (!nativeValidNodeAndBounds(
                        motionUpData.mFrame, motionUpData.mNode,
                        motionUpData.mBounds)) {
                    nativeUpdateFrameCache();
                }
                Message message = mWebView.mPrivateHandler
                        .obtainMessage(WebView.DO_MOTION_UP,
                        motionUpData.mX, motionUpData.mY);
                mWebView.mPrivateHandler.sendMessageAtFrontOfQueue(
                        message);
                break;
            }

            case EventHub.HIDE_FULLSCREEN:
                nativeFullScreenPluginHidden(msg.arg1);
                break;

            case EventHub.PLUGIN_SURFACE_READY:
                nativePluginSurfaceReady();
                break;

            case EventHub.NOTIFY_ANIMATION_STARTED:
                nativeNotifyAnimationStarted(mNativeClass);
                break;

            case EventHub.ADD_PACKAGE_NAMES:
                if (BrowserFrame.sJavaBridge == null) {
                    throw new IllegalStateException("No WebView " +
                            "has been created in this process!");
                }
                BrowserFrame.sJavaBridge.addPackageNames(
                        (Set<String>) msg.obj);
                break;

            case EventHub.GET_TOUCH_HIGHLIGHT_RECTS:
                TouchHighlightData d = (TouchHighlightData) msg.obj;
                if (d.mNativeLayer != 0) {
                    nativeScrollLayer(d.mNativeLayer,
                            d.mNativeLayerRect);
                }
                ArrayList<Rect> rects = nativeGetTouchHighlightRects
                        (d.mX, d.mY, d.mSlop);
                mWebView.mPrivateHandler.obtainMessage(
                        WebView.SET_TOUCH_HIGHLIGHT_RECTS, rects)
                        .sendToTarget();
                break;

            case EventHub.USE_MOCK_DEVICE_ORIENTATION:
                useMockDeviceOrientation();
                break;

            case EventHub.AUTOFILL_FORM:
                nativeAutoFillForm(msg.arg1);
                mWebView.mPrivateHandler.obtainMessage(WebView.AUTOFILL_COMPLETE, null)
                        .sendToTarget();
                break;

            case EventHub.EXECUTE_JS:
                if (msg.obj instanceof String) {
                    if (DebugFlags.WEB_VIEW_CORE) {
                        Log.d(LOGTAG, "Executing JS : " + msg.obj);
                    }
                    mBrowserFrame.stringByEvaluatingJavaScriptFromString((String) msg.obj);
                }
                break;
        }
    }

    /* Initialize private data within the WebCore thread.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:06.954 -0500", hash_original_method = "A9E80124E796ABAB018EC6550B6A2293", hash_generated_method = "6034A7CAB2A644FB8ED24935C0641356")
    
private void initialize() {
        /* Initialize our private BrowserFrame class to handle all
         * frame-related functions. We need to create a new view which
         * in turn creates a C level FrameView and attaches it to the frame.
         */
        mBrowserFrame = new BrowserFrame(mContext, this, mCallbackProxy,
                mSettings, mJavascriptInterfaces);
        mJavascriptInterfaces = null;
        // Sync the native settings and also create the WebCore thread handler.
        mSettings.syncSettingsAndCreateHandler(mBrowserFrame);
        // Create the handler and transfer messages for the IconDatabase
        WebIconDatabase.getInstance().createHandler();
        // Create the handler for WebStorage
        WebStorage.getInstance().createHandler();
        // Create the handler for GeolocationPermissions.
        GeolocationPermissions.getInstance().createHandler();
        // The transferMessages call will transfer all pending messages to the
        // WebCore thread handler.
        mEventHub.transferMessages();

        // Send a message back to WebView to tell it that we have set up the
        // WebCore thread.
        if (mWebView != null) {
            Message.obtain(mWebView.mPrivateHandler,
                    WebView.WEBCORE_INITIALIZED_MSG_ID,
                    mNativeClass, 0).sendToTarget();
        }

    }

    /* Handle the initialization of WebViewCore during subwindow creation. This
     * method is called from the WebCore thread but it is called before the
     * INITIALIZE message can be handled.
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:06.956 -0500", hash_original_method = "6D60C608DF715EFA6CF6C0614B6EA5AE", hash_generated_method = "17C7B0D7B14EE85003F11B93EB7411EE")
    
void initializeSubwindow() {
        // Go ahead and initialize the core components.
        initialize();
        // Remove the INITIALIZE method so we don't try to initialize twice.
        sWebCoreHandler.removeMessages(WebCoreThread.INITIALIZE, this);
    }

    /* Get the BrowserFrame component. This is used for subwindow creation and
     * is called only from BrowserFrame in the WebCore thread. */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:06.959 -0500", hash_original_method = "49E2B5EDCA0AFC5006663CDC7A5CE915", hash_generated_method = "2A5B7221FD2A2F4D9CAD643D56D0C610")
    
synchronized BrowserFrame getBrowserFrame() {
        return mBrowserFrame;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:06.966 -0500", hash_original_method = "FDAB4AC776E0B1BB8BD354A47F4FA51B", hash_generated_method = "E93164A269DCE1BE48856D5F95880809")
    
public WebSettings getSettings() {
        return mSettings;
    }

    /**
     * Add an error message to the client's console.
     * @param message The message to add
     * @param lineNumber the line on which the error occurred
     * @param sourceID the filename of the source that caused the error.
     * @param msgLevel the log level of this message. This is a value casted to int
     *     from WebCore::MessageLevel in WebCore/page/Console.h.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:06.970 -0500", hash_original_method = "1CDEF814C342D7BC6571C7725C279513", hash_generated_method = "9EB6D26C0819AF2A92E1E8507A567125")
    
protected void addMessageToConsole(String message, int lineNumber, String sourceID,
            int msgLevel) {
        mCallbackProxy.addMessageToConsole(message, lineNumber, sourceID, msgLevel);
    }

    /**
     * Invoke a javascript alert.
     * @param message The message displayed in the alert.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:06.972 -0500", hash_original_method = "F33520EFD859046BA24511601C4E309A", hash_generated_method = "716B3D6BDC9F4141758E83666058F7D2")
    
protected void jsAlert(String url, String message) {
        mCallbackProxy.onJsAlert(url, message);
    }

    /**
     * Called by JNI.  Send a message to the UI thread to hide the soft keyboard
     * if the node pointed to by nodePointer is still in focus.
     * @param nodePointer The node which just blurred.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:06.974 -0500", hash_original_method = "91FEA98D86997027CFAF7FA478DE35E9", hash_generated_method = "60C95DD0E7EBC2810B285986FF80A9EA")
    
private void formDidBlur(int nodePointer) {
        if (mWebView == null) return;
        Message.obtain(mWebView.mPrivateHandler, WebView.FORM_DID_BLUR,
                nodePointer, 0).sendToTarget();
    }

    /**
     * Called by JNI.  Open a file chooser to upload a file.
     * @param acceptType The value of the 'accept' attribute of the
     *         input tag associated with this file picker.
     * @return String version of the URI.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:06.977 -0500", hash_original_method = "A33837A6F28FD62D569A3757B4A4C37F", hash_generated_method = "7E82179D365BB9B32C1C6D4717B3AF47")
    
private String openFileChooser(String acceptType) {
        Uri uri = mCallbackProxy.openFileChooser(acceptType);
        if (uri != null) {
            String filePath = "";
            // Note - querying for MediaStore.Images.Media.DATA
            // seems to work for all content URIs, not just images
            Cursor cursor = mContext.getContentResolver().query(
                    uri,
                    new String[] { MediaStore.Images.Media.DATA },
                    null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToNext()) {
                        filePath = cursor.getString(0);
                    }
                } finally {
                    cursor.close();
                }
            } else {
                filePath = uri.getLastPathSegment();
            }
            String uriString = uri.toString();
            BrowserFrame.sJavaBridge.storeFilePathForContentUri(filePath, uriString);
            return uriString;
        }
        return "";
    }

    /**
     * Notify the browser that the origin has exceeded it's database quota.
     * @param url The URL that caused the overflow.
     * @param databaseIdentifier The identifier of the database.
     * @param currentQuota The current quota for the origin.
     * @param estimatedSize The estimated size of the database.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:06.982 -0500", hash_original_method = "EA467B8C1E05E16A088413F72C42053A", hash_generated_method = "F49E721BD45E9B23E7BBDDD26D0BE2A3")
    
protected void exceededDatabaseQuota(String url,
                                         String databaseIdentifier,
                                         long currentQuota,
                                         long estimatedSize) {
        // Inform the callback proxy of the quota overflow. Send an object
        // that encapsulates a call to the nativeSetDatabaseQuota method to
        // awaken the sleeping webcore thread when a decision from the
        // client to allow or deny quota is available.
        mCallbackProxy.onExceededDatabaseQuota(url, databaseIdentifier,
                currentQuota, estimatedSize, getUsedQuota(),
                new WebStorage.QuotaUpdater() {
                        public void updateQuota(long quota) {
                            nativeSetNewStorageLimit(quota);
                        }
                });
    }

    /**
     * Notify the browser that the appcache has exceeded its max size.
     * @param spaceNeeded is the amount of disk space that would be needed
     * in order for the last appcache operation to succeed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:06.988 -0500", hash_original_method = "6EBBAAC7ADAC02435B9F41E378724466", hash_generated_method = "949432B92EC11D3B3A7B1E26FAC8C514")
    
protected void reachedMaxAppCacheSize(long spaceNeeded) {
        mCallbackProxy.onReachedMaxAppCacheSize(spaceNeeded, getUsedQuota(),
                new WebStorage.QuotaUpdater() {
                    public void updateQuota(long quota) {
                        nativeSetNewStorageLimit(quota);
                    }
                });
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:06.993 -0500", hash_original_method = "08A818E5335EEC34FB33D96D932556A7", hash_generated_method = "8E03914C57E0AF8355116C09F7B9F634")
    
protected void populateVisitedLinks() {
        ValueCallback callback = new ValueCallback<String[]>() {
            public void onReceiveValue(String[] value) {
                sendMessage(EventHub.POPULATE_VISITED_LINKS, (Object)value);
            }
        };
        mCallbackProxy.getVisitedHistory(callback);
    }

    /**
     * Shows a prompt to ask the user to set the Geolocation permission state
     * for the given origin.
     * @param origin The origin for which Geolocation permissions are
     *     requested.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:06.999 -0500", hash_original_method = "AEE66291188900A80051B984C26C1180", hash_generated_method = "8A7BC8F51DE746F69EFFD44041ED4430")
    
protected void geolocationPermissionsShowPrompt(String origin) {
        mCallbackProxy.onGeolocationPermissionsShowPrompt(origin,
                new GeolocationPermissions.Callback() {
          public void invoke(String origin, boolean allow, boolean remember) {
            GeolocationPermissionsData data = new GeolocationPermissionsData();
            data.mOrigin = origin;
            data.mAllow = allow;
            data.mRemember = remember;
            // Marshall to WebCore thread.
            sendMessage(EventHub.GEOLOCATION_PERMISSIONS_PROVIDE, data);
          }
        });
    }

    /**
     * Hides the Geolocation permissions prompt.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.001 -0500", hash_original_method = "4D4892762A483BC675FC4A10EF44F79C", hash_generated_method = "6B225E7E6341B41D6D4DDAF47F896BB0")
    
protected void geolocationPermissionsHidePrompt() {
        mCallbackProxy.onGeolocationPermissionsHidePrompt();
    }

    /**
     * Invoke a javascript confirm dialog.
     * @param message The message displayed in the dialog.
     * @return True if the user confirmed or false if the user cancelled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.003 -0500", hash_original_method = "8F6A3F44BB46AEBAF13827E865603705", hash_generated_method = "0ADE5E0E0E49CB1BE755BDCB2536318D")
    
protected boolean jsConfirm(String url, String message) {
        return mCallbackProxy.onJsConfirm(url, message);
    }

    /**
     * Invoke a javascript prompt dialog.
     * @param message The message to be displayed in the dialog.
     * @param defaultValue The default value in the prompt input.
     * @return The input from the user or null to indicate the user cancelled
     *         the dialog.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.005 -0500", hash_original_method = "048D73921D9D83B7AF6D9F369B7BCD1A", hash_generated_method = "67359A61641A4CD69AC9272E5B035287")
    
protected String jsPrompt(String url, String message, String defaultValue) {
        return mCallbackProxy.onJsPrompt(url, message, defaultValue);
    }

    /**
     * Invoke a javascript before unload dialog.
     * @param url The url that is requesting the dialog.
     * @param message The message displayed in the dialog.
     * @return True if the user confirmed or false if the user cancelled. False
     *         will cancel the navigation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.008 -0500", hash_original_method = "E5A121F239BD1583646FB80C30646EA4", hash_generated_method = "F3460239B7FFA29A0ADD9F93D91CE890")
    
protected boolean jsUnload(String url, String message) {
        return mCallbackProxy.onJsBeforeUnload(url, message);
    }

    /**
     *
     * Callback to notify that a JavaScript execution timeout has occured.
     * @return True if the JavaScript execution should be interrupted. False
     *         will continue the execution.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.010 -0500", hash_original_method = "3FA5335C13C08E21D5C9AA51DF388549", hash_generated_method = "B05359BEF2EC29A442BD4E975D64904B")
    
protected boolean jsInterrupt() {
        return mCallbackProxy.onJsTimeout();
    }

    /**
     * Notify the webview that this is an installable web app.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.012 -0500", hash_original_method = "1C765D2623C528E50D87B3709395270F", hash_generated_method = "4ED258459FBA012AD764630EFFA01D0C")
    
protected void setInstallableWebApp() {
        mCallbackProxy.setInstallableWebApp();
    }

    /**
     * Notify the webview that we want to display the video layer fullscreen.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.014 -0500", hash_original_method = "CEB9108623A7C7A0C2BFBDCA074B84FE", hash_generated_method = "06613A41D34C3260B95490A35F010F07")
    
protected void enterFullscreenForVideoLayer(int layerId, String url) {
        if (mWebView == null) return;
        Message message = Message.obtain(mWebView.mPrivateHandler,
                       WebView.ENTER_FULLSCREEN_VIDEO, layerId, 0);
        message.obj = url;
        message.sendToTarget();
    }

    /**
     * Empty the picture set.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.021 -0500", hash_original_method = "3321B2428EFA479CDCDAB88856C4C216", hash_generated_method = "9C0505DFA235C9DFE71D72D1F0B2ACB5")
    
    private void nativeClearContent(){
    	//Formerly a native method
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.024 -0500", hash_original_method = "13D7E9686CEB46717C49AB16608C51CF", hash_generated_method = "951C652566D282269DE64F6549D036CE")
    
    private void nativeContentInvalidateAll(){
    	//Formerly a native method
    }

    /**
     * Redraw a portion of the picture set. The Point wh returns the
     * width and height of the overall picture.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.028 -0500", hash_original_method = "BFFDD95C5B679D515FF25E2212141F07", hash_generated_method = "C67F3541CC446D5DC469E29F4DBE2A21")
    
    private int nativeRecordContent(Region invalRegion, Point wh){
    	//Formerly a native method
    	addTaint(invalRegion.getTaint());
    	addTaint(wh.getTaint());
    	return getTaintInt();
    }

    /**
     * Update the layers' content
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.032 -0500", hash_original_method = "8B828971EA2E2F12F8B254DF3483012F", hash_generated_method = "9150980E534E048DFFFD12999581B0C4")
    
    private boolean nativeUpdateLayers(int nativeClass, int baseLayer){
    	//Formerly a native method
    	addTaint(nativeClass);
    	addTaint(baseLayer);
    	return getTaintBoolean();
    }

    /**
     * Notify webkit that animations have begun (on the hardware accelerated content)
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.036 -0500", hash_original_method = "35C4B35D5036F5DD5E458797A063F760", hash_generated_method = "06BDD6176671442A00DBFA1F4DCB3855")
    
    private void nativeNotifyAnimationStarted(int nativeClass){
    	//Formerly a native method
    	addTaint(nativeClass);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.039 -0500", hash_original_method = "73C7C1AE1D8DFCB366E36E3A519B57F0", hash_generated_method = "A2C5D14E379DB8164A14EA632BB3C17D")
    
    private boolean nativeFocusBoundsChanged(){
    	//Formerly a native method
    	return getTaintBoolean();
    }

    /**
     * Splits slow parts of the picture set. Called from the webkit thread after
     * WebView.nativeDraw() returns content to be split.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.043 -0500", hash_original_method = "7060C98AD2B6D1D27FBDA877BC7BC75F", hash_generated_method = "E65E412DD98B751A0E58E3FCF93C6D6A")
    
    private void nativeSplitContent(int content){
    	//Formerly a native method
    	addTaint(content);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.046 -0500", hash_original_method = "0325F1899906FABB340645FF6A74C4CF", hash_generated_method = "59C735B55B93410FDF696FB8612347FE")
    
    private boolean nativeKey(int keyCode, int unichar,
                int repeatCount, boolean isShift, boolean isAlt, boolean isSym,
                boolean isDown){
    	//Formerly a native method
    	addTaint(keyCode);
    	addTaint(unichar);
    	addTaint(repeatCount);
    	addTaint(isShift);
    	addTaint(isAlt);
    	addTaint(isSym);
    	addTaint(isDown);
    	return getTaintBoolean();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.050 -0500", hash_original_method = "70A418E65E32BB0E515A5AA033BDE85F", hash_generated_method = "7D6D0D5F351168164B310FD9943F9C6D")
    
    private void nativeClick(int framePtr, int nodePtr, boolean fake){
    	//Formerly a native method
    	addTaint(framePtr);
    	addTaint(nodePtr);
    	addTaint(fake);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.054 -0500", hash_original_method = "71551FF77A19704BFDEA681298A1C532", hash_generated_method = "E25B5B6EEF0979FB73EA7C6976670F90")
    
    private void nativeSendListBoxChoices(boolean[] choices, int size){
    	//Formerly a native method
    	addTaint(choices[0]);
    	addTaint(size);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.057 -0500", hash_original_method = "2618C62A7F157C7D34B87A8252580B1E", hash_generated_method = "D446E0699921AEF3AC45A7B3E4740DA8")
    
    private void nativeSendListBoxChoice(int choice){
    	//Formerly a native method
    	addTaint(choice);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.061 -0500", hash_original_method = "AA6AE3A40C1C9F44C6F8CF239E11299A", hash_generated_method = "ABB95F9CA6D8ABEBCD8B1B25E66F5248")
    
    private void nativeCloseIdleConnections(){
    	//Formerly a native method
    }

    /*  Tell webkit what its width and height are, for the purposes
        of layout/line-breaking. These coordinates are in document space,
        which is the same as View coords unless we have zoomed the document
        (see nativeSetZoom).
        textWrapWidth is used by layout to wrap column around. If viewport uses
        fixed size, textWrapWidth can be different from width with zooming.
        should this be called nativeSetViewPortSize?
    */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.064 -0500", hash_original_method = "2A4CBEA83BAEBD0A1BEAE59497423C44", hash_generated_method = "97D3C30B16C2F1710C90BDFE961A83E9")
    
    private void nativeSetSize(int width, int height, int textWrapWidth,
                float scale, int screenWidth, int screenHeight, int anchorX,
                int anchorY, boolean ignoreHeight){
    	//Formerly a native method
    	addTaint(width);
    	addTaint(height);
    	addTaint(textWrapWidth);
    	addTaint(scale);
    	addTaint(screenWidth);
    	addTaint(screenHeight);
    	addTaint(anchorX);
    	addTaint(anchorY);
    	addTaint(ignoreHeight);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.067 -0500", hash_original_method = "2D1706BAD8A7F0247CBA9A3206675903", hash_generated_method = "6C168FBF67540FC8263DA35FF961A3B1")
    
    private int nativeGetContentMinPrefWidth(){
    	//Formerly a native method
    	return getTaintInt();
    }

    // Start: functions that deal with text editing
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.072 -0500", hash_original_method = "B8EB103A209F8746ABD011DD32864795", hash_generated_method = "0DF97225DD70ED402D8D5E13991BC9BF")
    
    private void nativeReplaceTextfieldText(
                int oldStart, int oldEnd, String replace, int newStart, int newEnd,
                int textGeneration){
    	//Formerly a native method
    	addTaint(oldStart);
    	addTaint(oldEnd);
    	addTaint(replace.getTaint());
    	addTaint(newStart);
    	addTaint(newEnd);
    	addTaint(textGeneration);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.076 -0500", hash_original_method = "9A03490EFF94C535BBBC062423FDF770", hash_generated_method = "D88B3A5DF8248E0285ED2693D2254595")
    
    private void passToJs(int gen,
                String currentText, int keyCode, int keyValue, boolean down,
                boolean cap, boolean fn, boolean sym){
    	//Formerly a native method
    	addTaint(gen);
    	addTaint(currentText.getTaint());
    	addTaint(keyCode);
    	addTaint(keyValue);
    	addTaint(down);
    	addTaint(cap);
    	addTaint(fn);
    	addTaint(sym);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.079 -0500", hash_original_method = "731A9DE98191A7AE554758463A8E339C", hash_generated_method = "47EA8930D32AA1A68230A41E17929681")
    
    private void nativeSetFocusControllerActive(boolean active){
    	//Formerly a native method
    	addTaint(active);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.083 -0500", hash_original_method = "2F51FDF2CB321B99E6DFA3281F5101CC", hash_generated_method = "CC610C476395B73EC85779D71E05D8BE")
    
    private void nativeSaveDocumentState(int frame){
    	//Formerly a native method
    	addTaint(frame);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.087 -0500", hash_original_method = "85DD951D7BA7B47A52141773E659FF39", hash_generated_method = "69B78D5F38E02812B2EAE92D38CAD483")
    
    private void nativeMoveFocus(int framePtr, int nodePointer){
    	//Formerly a native method
    	addTaint(framePtr);
    	addTaint(nodePointer);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.090 -0500", hash_original_method = "A6F32C1338CD19726DF22CA448394172", hash_generated_method = "DBEA8800A5BAA3F91197DD6CCD3B8E4D")
    
    private void nativeMoveMouse(int framePtr, int x, int y){
    	//Formerly a native method
    	addTaint(framePtr);
    	addTaint(x);
    	addTaint(y);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.094 -0500", hash_original_method = "C235A3B24BC384A4B13E333446CE6D73", hash_generated_method = "F536C8E277505CFC8789DF071D67BEC9")
    
    private void nativeMoveMouseIfLatest(int moveGeneration,
                int framePtr, int x, int y){
    	//Formerly a native method
    	addTaint(moveGeneration);
    	addTaint(framePtr);
    	addTaint(x);
    	addTaint(y);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.677 -0400", hash_original_method = "241A051A4ABC8D2C1F54A842088CB439", hash_generated_method = "ADDFF51CB4191E5A33B19E9FFF8D0598")
    private String nativeRetrieveHref(int x, int y) {
    	String s = new String ();
    	s.addTaint(getTaint());
    	return s;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.677 -0400", hash_original_method = "FBE4886E30C0F15C8EE972672B86778C", hash_generated_method = "00676F9B8F3E27C703CEC42462520F49")
    private String nativeRetrieveAnchorText(int x, int y) {
    	String s = new String ();
    	s.addTaint(getTaint());
    	return s;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.677 -0400", hash_original_method = "7F214D01044FDB7C0A6FFA5743028C76", hash_generated_method = "DF1E348C7A15B8A70CB12B2540802419")
    private String nativeRetrieveImageSource(int x, int y) {
    	String s = new String ();
    	s.addTaint(getTaint());
    	return s;
    }
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.108 -0500", hash_original_method = "88A920F51B60DD8B7CF755C65AD2CD4B", hash_generated_method = "D1D58B8F4A3E9161A1DDB55881CBB2AB")
    
    private void nativeStopPaintingCaret(){
    	//Formerly a native method
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.111 -0500", hash_original_method = "9296BE828873621211792703531EF020", hash_generated_method = "742FFD49F7B7056EE157F7E564D7E9C3")
    
    private void nativeTouchUp(int touchGeneration,
                int framePtr, int nodePtr, int x, int y){
    	//Formerly a native method
    	addTaint(touchGeneration);
    	addTaint(framePtr);
    	addTaint(nodePtr);
    	addTaint(x);
    	addTaint(y);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.116 -0500", hash_original_method = "6E256A1C9154CE3109BDE15092BA1E46", hash_generated_method = "CBFA2366FDB5AB4B2B1C2B8D8869BE07")
    
    private boolean nativeHandleTouchEvent(int action, int[] idArray,
                int[] xArray, int[] yArray, int count, int actionIndex, int metaState){
    	//Formerly a native method
    	addTaint(action);
    	addTaint(idArray[0]);
    	addTaint(xArray[0]);
    	addTaint(yArray[0]);
    	addTaint(count);
    	addTaint(actionIndex);
    	addTaint(metaState);
    	return getTaintBoolean();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.120 -0500", hash_original_method = "5DF4B15A046A1C8193010BE985610007", hash_generated_method = "617BB0E54EAF1943D5A4844819F3232A")
    
    private void nativeUpdateFrameCache(){
    	//Formerly a native method
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.123 -0500", hash_original_method = "9D2250220C9E1A2522A1ED6887AE6CE9", hash_generated_method = "A20F6409A1A85C4DCB818EEBA59BCAB5")
    
    private void nativeSetBackgroundColor(int color){
    	//Formerly a native method
    	addTaint(color);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.127 -0500", hash_original_method = "AA3E36FB02CBFB05644F704D8E558646", hash_generated_method = "96647FA2B51DD95C0DA984B0BC6CBA50")
    
    private void nativeDumpDomTree(boolean useFile){
    	//Formerly a native method
    	addTaint(useFile);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.130 -0500", hash_original_method = "BD4BD7606C8F6CEDCA447CEAD83A3B9E", hash_generated_method = "E54F4C9EA7B7221F5F66D6A96CD401DF")
    
    private void nativeDumpRenderTree(boolean useFile){
    	//Formerly a native method
    	addTaint(useFile);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.133 -0500", hash_original_method = "BA54C8246871B46F32623955B4EB301E", hash_generated_method = "0E44B78E9C81FCDF6D62CCC06A701113")
    
    private void nativeDumpNavTree(){
    	//Formerly a native method
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.137 -0500", hash_original_method = "8B3EC012E68CBA5C936E0A667ADD1C4C", hash_generated_method = "8A404F7924E2636E614DE988A58D5399")
    
    private void nativeDumpV8Counters(){
    	//Formerly a native method
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.140 -0500", hash_original_method = "F3F0788077DAD1F9BFCE6F15D319CC63", hash_generated_method = "E13C464D1AD39CF976DD9F5B35370CDF")
    
    private void nativeSetJsFlags(String flags){
    	//Formerly a native method
    	addTaint(flags.getTaint());
    }

    /**
     *  Delete text from start to end in the focused textfield. If there is no
     *  focus, or if start == end, silently fail.  If start and end are out of
     *  order, swap them.
     *  @param  start   Beginning of selection to delete.
     *  @param  end     End of selection to delete.
     *  @param  textGeneration Text generation number when delete was pressed.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.144 -0500", hash_original_method = "57BBD8F6823CD4AFC27D90CDB0FA1518", hash_generated_method = "DD1E638E2ACF68F61B5993ACAD2290C3")
    
    private void nativeDeleteSelection(int start, int end,
                int textGeneration){
    	//Formerly a native method
    	addTaint(start);
    	addTaint(end);
    	addTaint(textGeneration);
    }

    /**
     *  Set the selection to (start, end) in the focused textfield. If start and
     *  end are out of order, swap them.
     *  @param  start   Beginning of selection.
     *  @param  end     End of selection.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.148 -0500", hash_original_method = "E5C6AAA39851A50D9CE3B905BCD5E24D", hash_generated_method = "8453B60A26CF7AC876CC2397A298D8CA")
    
    private void nativeSetSelection(int start, int end){
    	//Formerly a native method
    	addTaint(start);
    	addTaint(end);
    }

    // Register a scheme to be treated as local scheme so that it can access
    // local asset files for resources
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.151 -0500", hash_original_method = "439BD7C80B92A6DF144499531B46441F", hash_generated_method = "98F9AB9FBE2B3B74C30DC21D960E5531")
    
    private void nativeRegisterURLSchemeAsLocal(String scheme){
    	//Formerly a native method
    	addTaint(scheme.getTaint());
    }

    /*
     * Inform webcore that the user has decided whether to allow or deny new
     * quota for the current origin or more space for the app cache, and that
     * the main thread should wake up now.
     * @param limit Is the new quota for an origin or new app cache max size.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.154 -0500", hash_original_method = "38BB405567582FE2ECD514780CDB4D80", hash_generated_method = "463C25E3F7215F5E6C4FBDCFF7F23758")
    
    private void nativeSetNewStorageLimit(long limit){
    	//Formerly a native method
    	addTaint(limit);
    }

    /**
     * Provide WebCore with a Geolocation permission state for the specified
     * origin.
     * @param origin The origin for which Geolocation permissions are provided.
     * @param allow Whether Geolocation permissions are allowed.
     * @param remember Whether this decision should be remembered beyond the
     *     life of the current page.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.158 -0500", hash_original_method = "FB112EA9A2452AC298500FCFB087229A", hash_generated_method = "6E2B72B3E31E56E7A74881663748CC80")
    
    private void nativeGeolocationPermissionsProvide(String origin, boolean allow, boolean remember){
    	//Formerly a native method
    	addTaint(origin.getTaint());
    	addTaint(allow);
    	addTaint(remember);
    }

    /**
     * Provide WebCore with the previously visted links from the history database
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.162 -0500", hash_original_method = "26AE2AF434B9C69ABDC8C488B6A433CD", hash_generated_method = "A44B6950D86BF4113CFF8D24B474C899")
    
    private void nativeProvideVisitedHistory(String[] history){
    	//Formerly a native method
    	addTaint(history[0].getTaint());
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.681 -0400", hash_original_method = "7F9DDA20412A0AF9D5E94CA5D5B0BEAA", hash_generated_method = "AA720C4F9758D8D1846FA8601154CB6F")
    private String nativeModifySelection(int direction, int granularity) {
    	String s = new String ();
    	s.addTaint(getTaint());
    	return s;
    }

    //-------------------------------------------------------------------------
    // Methods called by host activity (in the same thread)
    //-------------------------------------------------------------------------

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.625 -0500", hash_original_method = "D1B7DF7B765695C5C682B348754C5EEE", hash_generated_method = "D1B7DF7B765695C5C682B348754C5EEE")
    
void stopLoading() {
        if (DebugFlags.WEB_VIEW_CORE) Log.v(LOGTAG, "CORE stopLoading");
        if (mBrowserFrame != null) {
            mBrowserFrame.stopLoading();
        }
    }

    //-------------------------------------------------------------------------
    // Methods called by WebView
    // If it refers to local variable, it needs synchronized().
    // If it needs WebCore, it has to send message.
    //-------------------------------------------------------------------------

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.628 -0500", hash_original_method = "7711F35529A80997737E0C04E1483C72", hash_generated_method = "4931D3DEB9A7A82DBD1610858C59F580")
    
public void sendMessage(Message msg) {
        //mEventHub.sendMessage(msg);
        droidsafeHandleMessage(msg);
    }

        @DSVerified
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.629 -0500", hash_original_method = "E19A847BDC376FCC409B2080F91A4777", hash_generated_method = "E19A847BDC376FCC409B2080F91A4777")
    
void sendMessage(int what) {
        //mEventHub.sendMessage(Message.obtain(null, what));
        droidsafeHandleMessage(Message.obtain(null, what));
    }

        @DSVerified
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.631 -0500", hash_original_method = "3E0AD5D05665DC86C1B2BC352FB304E3", hash_generated_method = "3E0AD5D05665DC86C1B2BC352FB304E3")
    
void sendMessage(int what, Object obj) {
        droidsafeHandleMessage(Message.obtain(null, what, obj));
    }

        @DSVerified
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.633 -0500", hash_original_method = "C23BF0CD5B475AFDE2C5AFE3693DBFAC", hash_generated_method = "8A039920AAE37C00F14C33BD5DCF6CCC")
    
void sendMessage(int what, int arg1) {
        // just ignore the second argument (make it 0)
        //mEventHub.sendMessage(Message.obtain(null, what, arg1, 0));
        droidsafeHandleMessage(Message.obtain(null, what, arg1, 0));
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.635 -0500", hash_original_method = "BB791EA62C0999DDA8C7D0E8B12A435D", hash_generated_method = "BB791EA62C0999DDA8C7D0E8B12A435D")
    
void sendMessage(int what, int arg1, int arg2) {
        droidsafeHandleMessage(Message.obtain(null, what, arg1, arg2));
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.637 -0500", hash_original_method = "F818943F2C2BA5FC914E03EA08D08398", hash_generated_method = "54297B4E3AC7F13660667E2E67052132")
    
void sendMessage(int what, int arg1, Object obj) {
        // just ignore the second argument (make it 0)
        droidsafeHandleMessage(Message.obtain(null, what, arg1, 0, obj));
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.639 -0500", hash_original_method = "6F3BFA4748A47EA8C7E77DF53F526C02", hash_generated_method = "6F3BFA4748A47EA8C7E77DF53F526C02")
    
void sendMessage(int what, int arg1, int arg2, Object obj) {
        droidsafeHandleMessage(Message.obtain(null, what, arg1, arg2, obj));
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.641 -0500", hash_original_method = "D6940867453E54F97589FC877C811177", hash_generated_method = "D6940867453E54F97589FC877C811177")
    
void sendMessageAtFrontOfQueue(int what, Object obj) {
        droidsafeHandleMessage(Message.obtain(
                null, what, obj));
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.644 -0500", hash_original_method = "E02AF416600FEDFA3677939C48774A40", hash_generated_method = "E02AF416600FEDFA3677939C48774A40")
    
void sendMessageDelayed(int what, Object obj, long delay) {
        droidsafeHandleMessage(Message.obtain(null, what, obj));
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.646 -0500", hash_original_method = "5A5B79979B60ACD2210356FAD25017D3", hash_generated_method = "5A5B79979B60ACD2210356FAD25017D3")
    
void removeMessages(int what) {
        mEventHub.removeMessages(what);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.648 -0500", hash_original_method = "24F837264907471F101C9345660807F0", hash_generated_method = "24F837264907471F101C9345660807F0")
    
void removeMessages() {
        mEventHub.removeMessages();
    }

    /**
     * Sends a DESTROY message to WebCore.
     * Called from UI thread.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.650 -0500", hash_original_method = "632CCE7E9EF22DEC0E7940476F7FAE4E", hash_generated_method = "45ABB2D1295E8204EDBF60645FF46CE5")
    
void destroy() {
        synchronized (mEventHub) {
            // Do not call removeMessages as then we risk removing PAUSE_TIMERS
            // or RESUME_TIMERS messages, which we must still handle as they
            // are per process. DESTROY will instead trigger a white list in
            // mEventHub, skipping any remaining messages in the queue
            mEventHub.mDestroying = true;
            mEventHub.sendMessage(
                    Message.obtain(null, EventHub.DESTROY));
            mEventHub.blockMessages();
        }
    }

    //-------------------------------------------------------------------------
    // WebViewCore private methods
    //-------------------------------------------------------------------------

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.652 -0500", hash_original_method = "4EA5384F21A7BECF7B7E7FDA52086518", hash_generated_method = "312AA9C722EFB5C33B2C0A9A66295E80")
    
private void clearCache(boolean includeDiskFiles) {
        mBrowserFrame.clearCache();
        if (includeDiskFiles) {
            CacheManager.removeAllCacheFiles();
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.655 -0500", hash_original_method = "AA9F9969DB77E536EC07D516D83D1BCB", hash_generated_method = "06C87A9948F6BB1D2AA81A4FCCEB25A0")
    @DSVerified
    
private void loadUrl(String url, Map<String, String> extraHeaders) {
        if (DebugFlags.WEB_VIEW_CORE) Log.v(LOGTAG, " CORE loadUrl " + url);
        mBrowserFrame.loadUrl(url, extraHeaders);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.657 -0500", hash_original_method = "39AB37F211BE7296755FEECD44D0BABF", hash_generated_method = "90ACBB356976DFCCCE9BF62D6156F40E")
    
private String saveWebArchive(String filename, boolean autoname) {
        if (DebugFlags.WEB_VIEW_CORE) {
            Log.v(LOGTAG, " CORE saveWebArchive " + filename + " " + autoname);
        }
        return mBrowserFrame.saveWebArchive(filename, autoname);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.659 -0500", hash_original_method = "E69496F6C06CA8A97AAA7658612739AE", hash_generated_method = "6E5616C1DB472191155C118675E92139")
    
private void key(KeyEvent evt, boolean isDown) {
        if (DebugFlags.WEB_VIEW_CORE) {
            Log.v(LOGTAG, "CORE key at " + System.currentTimeMillis() + ", "
                    + evt);
        }
        int keyCode = evt.getKeyCode();
        int unicodeChar = evt.getUnicodeChar();

        if (keyCode == KeyEvent.KEYCODE_UNKNOWN && evt.getCharacters() != null
                && evt.getCharacters().length() > 0) {
            // we should only receive individual complex characters
            unicodeChar = evt.getCharacters().codePointAt(0);
        }

        if (!nativeKey(keyCode, unicodeChar, evt.getRepeatCount(), evt.isShiftPressed(),
                evt.isAltPressed(), evt.isSymPressed(),
                isDown) && keyCode != KeyEvent.KEYCODE_ENTER) {
            if (keyCode >= KeyEvent.KEYCODE_DPAD_UP
                    && keyCode <= KeyEvent.KEYCODE_DPAD_RIGHT) {
                if (DebugFlags.WEB_VIEW_CORE) {
                    Log.v(LOGTAG, "key: arrow unused by page: " + keyCode);
                }
                if (mWebView != null && evt.isDown()) {
                    Message.obtain(mWebView.mPrivateHandler,
                            WebView.UNHANDLED_NAV_KEY, keyCode,
                            0).sendToTarget();
                }
                return;
            }
            // bubble up the event handling
            // but do not bubble up the ENTER key, which would open the search
            // bar without any text.
            mCallbackProxy.onUnhandledKeyEvent(evt);
        }
    }

    // notify webkit that our virtual view size changed size (after inv-zoom)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.668 -0500", hash_original_method = "946C6245DADFE1E4F7C078AC5EFCBE5B", hash_generated_method = "C2610660FB633B59ABE98BEE10967C15")
    
private void viewSizeChanged(WebView.ViewSizeData data) {
        int w = data.mWidth;
        int h = data.mHeight;
        int textwrapWidth = data.mTextWrapWidth;
        float scale = data.mScale;
        if (DebugFlags.WEB_VIEW_CORE) {
            Log.v(LOGTAG, "viewSizeChanged w=" + w + "; h=" + h
                    + "; textwrapWidth=" + textwrapWidth + "; scale=" + scale);
        }
        if (w == 0) {
            Log.w(LOGTAG, "skip viewSizeChanged as w is 0");
            return;
        }
        int width = calculateWindowWidth(w);
        int height = h;
        if (width != w) {
            float heightWidthRatio = data.mHeightWidthRatio;
            float ratio = (heightWidthRatio > 0) ? heightWidthRatio : (float) h / w;
            height = Math.round(ratio * width);
        }
        nativeSetSize(width, height, textwrapWidth, scale, w,
                data.mActualViewHeight > 0 ? data.mActualViewHeight : h,
                data.mAnchorX, data.mAnchorY, data.mIgnoreHeight);
        // Remember the current width and height
        boolean needInvalidate = (mCurrentViewWidth == 0);
        mCurrentViewWidth = w;
        mCurrentViewHeight = h;
        mCurrentViewScale = scale;
        if (needInvalidate) {
            // ensure {@link #webkitDraw} is called as we were blocking in
            // {@link #contentDraw} when mCurrentViewWidth is 0
            if (DebugFlags.WEB_VIEW_CORE) Log.v(LOGTAG, "viewSizeChanged");
            contentDraw();
        }
        mEventHub.sendMessage(Message.obtain(null,
                EventHub.UPDATE_CACHE_AND_TEXT_ENTRY));
    }

    // Calculate width to be used in webkit window.
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.671 -0500", hash_original_method = "D41B819EC6CC76FA3A89B783D40CD109", hash_generated_method = "FC0B7EF5FE512A0237F9B8E408B6AD48")
    
private int calculateWindowWidth(int viewWidth) {
        int width = viewWidth;
        if (mSettings.getUseWideViewPort()) {
            if (mViewportWidth == -1) {
                // Fixed viewport width.
                width = WebView.DEFAULT_VIEWPORT_WIDTH;
            } else if (mViewportWidth > 0) {
                // Use website specified or desired fixed viewport width.
                width = mViewportWidth;
            } else {
                // For mobile web site.
                width = Math.round(mWebView.getViewWidth() / mWebView.getDefaultZoomScale());
            }
        }
        return width;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.673 -0500", hash_original_method = "261CDCDC6F5C121338E8B1C49F51F57D", hash_generated_method = "C91E4E3F18D7A532E55E1C1E3E3DE972")
    
private void sendUpdateTextEntry() {
        if (mWebView != null) {
            Message.obtain(mWebView.mPrivateHandler,
                    WebView.UPDATE_TEXT_ENTRY_MSG_ID).sendToTarget();
        }
    }

    // Utility method for exceededDatabaseQuota and reachedMaxAppCacheSize
    // callbacks. Computes the sum of database quota for all origins.
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.676 -0500", hash_original_method = "C9A09E0BE5548FD8F21659E9C96899A7", hash_generated_method = "F7F8E0CEADDA216FBD4881E37F6F67EE")
    
private long getUsedQuota() {
        WebStorage webStorage = WebStorage.getInstance();
        Collection<WebStorage.Origin> origins = webStorage.getOriginsSync();

        if (origins == null) {
            return 0;
        }
        long usedQuota = 0;
        for (WebStorage.Origin website : origins) {
            usedQuota += website.getQuota();
        }
        return usedQuota;
    }

    // called from UI thread
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.679 -0500", hash_original_method = "5A8A60F9907CD1F32895929FD9CD4B62", hash_generated_method = "5A8A60F9907CD1F32895929FD9CD4B62")
    
void splitContent(int content) {
        if (!mSplitPictureIsScheduled) {
            mSplitPictureIsScheduled = true;
            sendMessage(EventHub.SPLIT_PICTURE_SET, content, 0);
        }
    }

    // Only update the layers' content, not the base surface
    // PictureSet.
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.741 -0500", hash_original_method = "16C23BC9F883695D8B710B8E94BB257A", hash_generated_method = "42403754CA5B4DD1A0D17D72F91A188B")
    
private void webkitDrawLayers() {
        mDrawLayersIsScheduled = false;
        if (mDrawIsScheduled || mLastDrawData == null) {
            removeMessages(EventHub.WEBKIT_DRAW);
            webkitDraw();
            return;
        }
        // Directly update the layers we last passed to the UI side
        if (nativeUpdateLayers(mNativeClass, mLastDrawData.mBaseLayer)) {
            // If anything more complex than position has been touched, let's do a full draw
            webkitDraw();
        }
        mWebView.mPrivateHandler.removeMessages(WebView.INVAL_RECT_MSG_ID);
        mWebView.mPrivateHandler.sendMessageAtFrontOfQueue(mWebView.mPrivateHandler
                .obtainMessage(WebView.INVAL_RECT_MSG_ID));
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.743 -0500", hash_original_method = "BB9CB43D2CFBC69EF1EE145BAE6ACA31", hash_generated_method = "47AD050B296D0CA001F89A49EA02D5E3")
    
private void webkitDraw() {
        mDrawIsScheduled = false;
        DrawData draw = new DrawData();
        if (DebugFlags.WEB_VIEW_CORE) Log.v(LOGTAG, "webkitDraw start");
        draw.mBaseLayer = nativeRecordContent(draw.mInvalRegion, draw.mContentSize);
        if (draw.mBaseLayer == 0) {
            if (mWebView != null && !mWebView.isPaused()) {
                if (DebugFlags.WEB_VIEW_CORE) Log.v(LOGTAG, "webkitDraw abort, resending draw message");
                mEventHub.sendMessage(Message.obtain(null, EventHub.WEBKIT_DRAW));
            } else {
                if (DebugFlags.WEB_VIEW_CORE) Log.v(LOGTAG, "webkitDraw abort, webview paused");
            }
            return;
        }
        mLastDrawData = draw;
        webkitDraw(draw);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.747 -0500", hash_original_method = "9C55B9902567F10864019D1DAA55A307", hash_generated_method = "61CDEDD2529C67BA745EC55642238F26")
    
private void webkitDraw(DrawData draw) {
        if (mWebView != null) {
            draw.mFocusSizeChanged = nativeFocusBoundsChanged();
            draw.mViewSize = new Point(mCurrentViewWidth, mCurrentViewHeight);
            if (mSettings.getUseWideViewPort()) {
                draw.mMinPrefWidth = Math.max(
                        mViewportWidth == -1 ? WebView.DEFAULT_VIEWPORT_WIDTH
                                : (mViewportWidth == 0 ? mCurrentViewWidth
                                        : mViewportWidth),
                        nativeGetContentMinPrefWidth());
            }
            if (mInitialViewState != null) {
                draw.mViewState = mInitialViewState;
                mInitialViewState = null;
            }
            if (mFirstLayoutForNonStandardLoad) {
                draw.mFirstLayoutForNonStandardLoad = true;
                mFirstLayoutForNonStandardLoad = false;
            }
            if (DebugFlags.WEB_VIEW_CORE) Log.v(LOGTAG, "webkitDraw NEW_PICTURE_MSG_ID");
            Message.obtain(mWebView.mPrivateHandler,
                    WebView.NEW_PICTURE_MSG_ID, draw).sendToTarget();
        }
    }

    //////////////////////////////////////////////////////////////////////////

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.763 -0500", hash_original_method = "F63E17FBEAA6E278B676F177339490F6", hash_generated_method = "09794EB4B1B7B393F0508E59D0668689")
    
private void restoreState(int index) {
        WebBackForwardList list = mCallbackProxy.getBackForwardList();
        int size = list.getSize();
        for (int i = 0; i < size; i++) {
            list.getItemAtIndex(i).inflate(mBrowserFrame.mNativeFrame);
        }
        mBrowserFrame.mLoadInitFromJava = true;
        list.restoreIndex(mBrowserFrame.mNativeFrame, index);
        mBrowserFrame.mLoadInitFromJava = false;
    }

    //-------------------------------------------------------------------------
    // Implement abstract methods in WebViewCore, native WebKit callback part
    //-------------------------------------------------------------------------

    // called from JNI or WebView thread
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.765 -0500", hash_original_method = "1D90769B244FD8A3CA2CA8B94E1DA948", hash_generated_method = "7974BF522DDC5FC8A64E44D809DCF1A6")
    
void contentDraw() {
        synchronized (this) {
            if (mWebView == null || mBrowserFrame == null) {
                // We were destroyed
                return;
            }
            // don't update the Picture until we have an initial width and finish
            // the first layout
            if (mCurrentViewWidth == 0 || !mBrowserFrame.firstLayoutDone()) {
                return;
            }
            // only fire an event if this is our first request
            if (mDrawIsScheduled) return;
            mDrawIsScheduled = true;
            mEventHub.sendMessage(Message.obtain(null, EventHub.WEBKIT_DRAW));
        }
    }

    // called from JNI
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.767 -0500", hash_original_method = "A3D463EE1053B0BDD6C0EF630EFBF61E", hash_generated_method = "A3D463EE1053B0BDD6C0EF630EFBF61E")
    
void layersDraw() {
        synchronized (this) {
            if (mDrawLayersIsScheduled) return;
            mDrawLayersIsScheduled = true;
            mEventHub.sendMessage(Message.obtain(null, EventHub.WEBKIT_DRAW_LAYERS));
        }
    }

    // called by JNI
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.769 -0500", hash_original_method = "05930F26D8EA77E9D23F45CCAA386679", hash_generated_method = "E8BBDD8E57EB87F4D18F6AF5BAD704E1")
    
private void contentScrollTo(int x, int y, boolean animate,
            boolean onlyIfImeIsShowing) {
        if (!mBrowserFrame.firstLayoutDone()) {
            /*
             * WebKit restore state will be called before didFirstLayout(),
             * remember the position as it has to be applied after restoring
             * zoom factor which is controlled by screenWidth.
             */
            mRestoredX = x;
            mRestoredY = y;
            return;
        }
        if (mWebView != null) {
            Message msg = Message.obtain(mWebView.mPrivateHandler,
                    WebView.SCROLL_TO_MSG_ID, animate ? 1 : 0,
                    onlyIfImeIsShowing ? 1 : 0, new Point(x, y));
            if (mDrawIsScheduled) {
                mEventHub.sendMessage(Message.obtain(null,
                        EventHub.MESSAGE_RELAY, msg));
            } else {
                msg.sendToTarget();
            }
        }
    }

    // called by JNI
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.772 -0500", hash_original_method = "064E6EE33123304FAB79F7D8FF122B00", hash_generated_method = "D1D53CC59CD1D5F6056126B684D8A161")
    
private void sendNotifyProgressFinished() {
        sendUpdateTextEntry();
        if (!JniUtil.useChromiumHttpStack()) {
            // as CacheManager can behave based on database transaction, we need to
            // call tick() to trigger endTransaction
            WebViewWorker.getHandler().removeMessages(
                    WebViewWorker.MSG_CACHE_TRANSACTION_TICKER);
            WebViewWorker.getHandler().sendEmptyMessage(
                    WebViewWorker.MSG_CACHE_TRANSACTION_TICKER);
        }
        contentDraw();
    }

    /*  Called by JNI. The coordinates are in doc coordinates, so they need to
        be scaled before they can be used by the view system, which happens
        in WebView since it (and its thread) know the current scale factor.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.774 -0500", hash_original_method = "05A7A351E8C6AEA76F720C36B865E14E", hash_generated_method = "5F1D382C657E8E925823FB6B3C082772")
    
private void sendViewInvalidate(int left, int top, int right, int bottom) {
        if (mWebView != null) {
            Message.obtain(mWebView.mPrivateHandler,
                           WebView.INVAL_RECT_MSG_ID,
                           new Rect(left, top, right, bottom)).sendToTarget();
        }
    }

    /*
     * Called by the WebView thread
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.778 -0500", hash_original_method = "BF48D6F46DE128F968473CE7B0F81CDD", hash_generated_method = "BF48D6F46DE128F968473CE7B0F81CDD")
    
void signalRepaintDone() {
        mRepaintScheduled = false;
    }

    // Gets the WebView corresponding to this WebViewCore. Note that the
    // WebView object must only be used on the UI thread.
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.780 -0500", hash_original_method = "D61E1D458239E8CEF9B36F4B5C04FED9", hash_generated_method = "D61E1D458239E8CEF9B36F4B5C04FED9")
    
WebView getWebView() {
        return mWebView;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.785 -0500", hash_original_method = "C2675483324447340D13F3ECB1B2D597", hash_generated_method = "8DDF398F7F27329CFDB5F65AF2112CBA")
    
    private void setViewportSettingsFromNative(){
    	//Formerly a native method
    }

    // called by JNI
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.787 -0500", hash_original_method = "7A9CDB44172FF868DD9DADCEEAD05D82", hash_generated_method = "B766446A3B605AD195B96F05052A88F9")
    
private void didFirstLayout(boolean standardLoad) {
        if (DebugFlags.WEB_VIEW_CORE) {
            Log.v(LOGTAG, "didFirstLayout standardLoad =" + standardLoad);
        }

        mBrowserFrame.didFirstLayout();

        if (mWebView == null) return;

        boolean updateViewState = standardLoad || mIsRestored;
        setupViewport(updateViewState);
        // if updateRestoreState is true, ViewManager.postReadyToDrawAll() will
        // be called after the WebView updates its state. If updateRestoreState
        // is false, start to draw now as it is ready.
        if (!updateViewState) {
            mWebView.mViewManager.postReadyToDrawAll();
        }

        // remove the touch highlight when moving to a new page
        if (WebView.USE_WEBKIT_RINGS || getSettings().supportTouchOnly()) {
            mWebView.mPrivateHandler.sendEmptyMessage(
                    WebView.SET_TOUCH_HIGHLIGHT_RECTS);
        }

        // reset the scroll position, the restored offset and scales
        mRestoredX = mRestoredY = 0;
        mIsRestored = false;
        mRestoredScale = mRestoredTextWrapScale = 0;
    }

    // called by JNI
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.789 -0500", hash_original_method = "A32352A77D85042345402A4E856F6371", hash_generated_method = "027C8CEC3F767E77CA8255A542C83694")
    
private void updateViewport() {
        // Update viewport asap to make sure we get correct one.
        setupViewport(true);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.796 -0500", hash_original_method = "D5D0316515645CA1EE6304290B6F23F6", hash_generated_method = "383D407C9BD00044CAD8E055B98B92AA")
    
private void setupViewport(boolean updateViewState) {
        if (mWebView == null || mSettings == null) {
            // We've been destroyed or are being destroyed, return early
            return;
        }
        // set the viewport settings from WebKit
        setViewportSettingsFromNative();

        // clamp initial scale
        if (mViewportInitialScale > 0) {
            if (mViewportMinimumScale > 0) {
                mViewportInitialScale = Math.max(mViewportInitialScale,
                        mViewportMinimumScale);
            }
            if (mViewportMaximumScale > 0) {
                mViewportInitialScale = Math.min(mViewportInitialScale,
                        mViewportMaximumScale);
            }
        }

        if (mSettings.forceUserScalable()) {
            mViewportUserScalable = true;
            if (mViewportInitialScale > 0) {
                if (mViewportMinimumScale > 0) {
                    mViewportMinimumScale = Math.min(mViewportMinimumScale,
                            mViewportInitialScale / 2);
                }
                if (mViewportMaximumScale > 0) {
                    mViewportMaximumScale = Math.max(mViewportMaximumScale,
                            mViewportInitialScale * 2);
                }
            } else {
                if (mViewportMinimumScale > 0) {
                    mViewportMinimumScale = Math.min(mViewportMinimumScale, 50);
                }
                if (mViewportMaximumScale > 0) {
                    mViewportMaximumScale = Math.max(mViewportMaximumScale, 200);
                }
            }
        }

        // adjust the default scale to match the densityDpi
        float adjust = 1.0f;
        if (mViewportDensityDpi == -1) {
            // convert default zoom scale to a integer (percentage) to avoid any
            // issues with floating point comparisons
            if (mWebView != null && (int)(mWebView.getDefaultZoomScale() * 100) != 100) {
                adjust = mWebView.getDefaultZoomScale();
            }
        } else if (mViewportDensityDpi > 0) {
            adjust = (float) mContext.getResources().getDisplayMetrics().densityDpi
                    / mViewportDensityDpi;
        }
        if (adjust != mWebView.getDefaultZoomScale()) {
            Message.obtain(mWebView.mPrivateHandler,
                    WebView.UPDATE_ZOOM_DENSITY, adjust).sendToTarget();
        }
        int defaultScale = (int) (adjust * 100);

        if (mViewportInitialScale > 0) {
            mViewportInitialScale *= adjust;
        }
        if (mViewportMinimumScale > 0) {
            mViewportMinimumScale *= adjust;
        }
        if (mViewportMaximumScale > 0) {
            mViewportMaximumScale *= adjust;
        }

        // infer the values if they are not defined.
        if (mViewportWidth == 0) {
            if (mViewportInitialScale == 0) {
                mViewportInitialScale = defaultScale;
            }
        }
        if (mViewportUserScalable == false) {
            mViewportInitialScale = defaultScale;
            mViewportMinimumScale = defaultScale;
            mViewportMaximumScale = defaultScale;
        }
        if (mViewportMinimumScale > mViewportInitialScale
                && mViewportInitialScale != 0) {
            mViewportMinimumScale = mViewportInitialScale;
        }
        if (mViewportMaximumScale > 0
                && mViewportMaximumScale < mViewportInitialScale) {
            mViewportMaximumScale = mViewportInitialScale;
        }
        if (mViewportWidth < 0 && mViewportInitialScale == defaultScale) {
            mViewportWidth = 0;
        }

        // if mViewportWidth is 0, it means device-width, always update.
        if (mViewportWidth != 0 && !updateViewState) {
            // For non standard load, since updateViewState will be false.
            mFirstLayoutForNonStandardLoad = true;
            ViewState viewState = new ViewState();
            viewState.mMinScale = mViewportMinimumScale / 100.0f;
            viewState.mMaxScale = mViewportMaximumScale / 100.0f;
            viewState.mDefaultScale = adjust;
            // as mViewportWidth is not 0, it is not mobile site.
            viewState.mMobileSite = false;
            // for non-mobile site, we don't need minPrefWidth, set it as 0
            viewState.mScrollX = 0;
            viewState.mShouldStartScrolledRight = false;
            Message.obtain(mWebView.mPrivateHandler,
                    WebView.UPDATE_ZOOM_RANGE, viewState).sendToTarget();
            return;
        }

        // now notify webview
        // webViewWidth refers to the width in the view system
        int webViewWidth;
        // viewportWidth refers to the width in the document system
        int viewportWidth = mCurrentViewWidth;
        if (viewportWidth == 0) {
            // this may happen when WebView just starts. This is not perfect as
            // we call WebView method from WebCore thread. But not perfect
            // reference is better than no reference.
            webViewWidth = mWebView.getViewWidth();
            viewportWidth = (int) (webViewWidth / adjust);
            if (viewportWidth == 0) {
                if (DebugFlags.WEB_VIEW_CORE) {
                    Log.v(LOGTAG, "Can't get the viewWidth yet");
                }
            }
        } else {
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
        if (mIsRestored) {
            mInitialViewState.mIsRestored = true;
            mInitialViewState.mViewScale = mRestoredScale;
            if (mRestoredTextWrapScale > 0) {
                mInitialViewState.mTextWrapScale = mRestoredTextWrapScale;
            } else {
                mInitialViewState.mTextWrapScale = mInitialViewState.mViewScale;
            }
        } else {
            if (mViewportInitialScale > 0) {
                mInitialViewState.mViewScale = mInitialViewState.mTextWrapScale =
                        mViewportInitialScale / 100.0f;
            } else if (mViewportWidth > 0 && mViewportWidth < webViewWidth &&
                !getSettings().getUseFixedViewport()) {
                mInitialViewState.mViewScale = mInitialViewState.mTextWrapScale =
                        (float) webViewWidth / mViewportWidth;
            } else {
                mInitialViewState.mTextWrapScale = adjust;
                if (mSettings.getUseWideViewPort()) {
                    // 0 will trigger WebView to turn on zoom overview mode
                    mInitialViewState.mViewScale = 0;
                } else {
                    mInitialViewState.mViewScale = adjust;
                }
            }
        }

        if (mWebView.mHeightCanMeasure) {
            // Trick to ensure that the Picture has the exact height for the
            // content by forcing to layout with 0 height after the page is
            // ready, which is indicated by didFirstLayout. This is essential to
            // get rid of the white space in the GMail which uses WebView for
            // message view.
            mWebView.mLastHeightSent = 0;
            // Send a negative scale to indicate that WebCore should reuse
            // the current scale
            WebView.ViewSizeData data = new WebView.ViewSizeData();
            data.mWidth = mWebView.mLastWidthSent;
            data.mHeight = 0;
            // if mHeightCanMeasure is true, getUseWideViewPort() can't be
            // true. It is safe to use mWidth for mTextWrapWidth.
            data.mTextWrapWidth = data.mWidth;
            data.mScale = -1.0f;
            data.mIgnoreHeight = false;
            data.mAnchorX = data.mAnchorY = 0;
            // send VIEW_SIZE_CHANGED to the front of the queue so that we can
            // avoid pushing the wrong picture to the WebView side. If there is
            // a VIEW_SIZE_CHANGED in the queue, probably from WebView side,
            // ignore it as we have a new size. If we leave VIEW_SIZE_CHANGED
            // in the queue, as mLastHeightSent has been updated here, we may
            // miss the requestLayout in WebView side after the new picture.
            mEventHub.removeMessages(EventHub.VIEW_SIZE_CHANGED);
            mEventHub.sendMessageAtFrontOfQueue(Message.obtain(null,
                    EventHub.VIEW_SIZE_CHANGED, data));
        } else {
            if (viewportWidth == 0) {
                // Trick to ensure VIEW_SIZE_CHANGED will be sent from WebView
                // to WebViewCore
                mWebView.mLastWidthSent = 0;
            } else {
                WebView.ViewSizeData data = new WebView.ViewSizeData();
                // mViewScale as 0 means it is in zoom overview mode. So we don't
                // know the exact scale. If mRestoredScale is non-zero, use it;
                // otherwise just use mTextWrapScale as the initial scale.
                float tentativeScale = mInitialViewState.mViewScale;
                if (tentativeScale == 0) {
                    // The following tries to figure out more correct view scale
                    // and text wrap scale to be sent to webkit, by using some
                    // knowledge from web settings and zoom manager.

                    // Calculated window width will be used to guess the scale
                    // in zoom overview mode.
                    tentativeScale = mInitialViewState.mTextWrapScale;
                    int tentativeViewWidth = Math.round(webViewWidth / tentativeScale);
                    int windowWidth = calculateWindowWidth(tentativeViewWidth);
                    // In viewport setup time, since no content width is known, we assume
                    // the windowWidth will be the content width, to get a more likely
                    // zoom overview scale.
                    data.mScale = (float) webViewWidth / windowWidth;
                    if (!mSettings.getLoadWithOverviewMode()) {
                        // If user choose non-overview mode.
                        data.mScale = Math.max(data.mScale, tentativeScale);
                    }
                    if (mSettings.isNarrowColumnLayout()) {
                        // In case of automatic text reflow in fixed view port mode.
                        mInitialViewState.mTextWrapScale =
                                mWebView.getReadingLevelScale();
                    }
                } else {
                    // Scale is given such as when page is restored, use it.
                    data.mScale = tentativeScale;
                }
                if (DebugFlags.WEB_VIEW_CORE) {
                    Log.v(LOGTAG, "setupViewport"
                             + " mRestoredScale=" + mRestoredScale
                             + " mViewScale=" + mInitialViewState.mViewScale
                             + " mTextWrapScale=" + mInitialViewState.mTextWrapScale
                             + " data.mScale= " + data.mScale
                             );
                }
                data.mWidth = Math.round(webViewWidth / data.mScale);
                // We may get a call here when mCurrentViewHeight == 0 if webcore completes the
                // first layout before we sync our webview dimensions to it. In that case, we
                // request the real height of the webview. This is not a perfect solution as we
                // are calling a WebView method from the WebCore thread. But this is preferable
                // to syncing an incorrect height.
                data.mHeight = mCurrentViewHeight == 0 ?
                        Math.round(mWebView.getViewHeight() / data.mScale)
                        : Math.round((float) mCurrentViewHeight * data.mWidth / viewportWidth);
                data.mTextWrapWidth = Math.round(webViewWidth
                        / mInitialViewState.mTextWrapScale);
                data.mIgnoreHeight = false;
                data.mAnchorX = data.mAnchorY = 0;
                // send VIEW_SIZE_CHANGED to the front of the queue so that we
                // can avoid pushing the wrong picture to the WebView side.
                mEventHub.removeMessages(EventHub.VIEW_SIZE_CHANGED);
                // Let webkit know the scale and inner width/height immediately
                // in viewport setup time to avoid wrong information.
                viewSizeChanged(data);
            }
        }
    }

    // called by JNI
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.798 -0500", hash_original_method = "6F3A82A96A28D1D6CB79A2B2419B2F76", hash_generated_method = "8EA0ECDF4BC1237128E27BB33B658758")
    
private void restoreScale(float scale, float textWrapScale) {
        if (mBrowserFrame.firstLayoutDone() == false) {
            mIsRestored = true;
            mRestoredScale = scale;
            if (mSettings.getUseWideViewPort()) {
                mRestoredTextWrapScale = textWrapScale;
            }
        }
    }

    // called by JNI
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.800 -0500", hash_original_method = "F9FDE50E9F3FDE0981BF3551CCB9A219", hash_generated_method = "C0B704D4B5343D3FC3227D19C9BB7D68")
    
private void needTouchEvents(boolean need) {
        if (mWebView != null) {
            Message.obtain(mWebView.mPrivateHandler,
                    WebView.WEBCORE_NEED_TOUCH_EVENTS, need ? 1 : 0, 0)
                    .sendToTarget();
        }
    }

    // called by JNI
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.803 -0500", hash_original_method = "117690D9297C0397B62CA4A9AAF175F7", hash_generated_method = "CC7FE955627A62F2628779270E4D96B2")
    
private void updateTextfield(int ptr, boolean changeToPassword,
            String text, int textGeneration) {
        if (mWebView != null) {
            Message msg = Message.obtain(mWebView.mPrivateHandler,
                    WebView.UPDATE_TEXTFIELD_TEXT_MSG_ID, ptr,
                    textGeneration, text);
            msg.getData().putBoolean("password", changeToPassword);
            msg.sendToTarget();
        }
    }

    // called by JNI
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.805 -0500", hash_original_method = "4C7D3AD0862D2CA84FE64B9856BAA28B", hash_generated_method = "14152CDE72B732E56AEA90C6287D0223")
    
private void updateTextSelection(int pointer, int start, int end,
            int textGeneration) {
        if (mWebView != null) {
            Message.obtain(mWebView.mPrivateHandler,
                WebView.UPDATE_TEXT_SELECTION_MSG_ID, pointer, textGeneration,
                new TextSelectionData(start, end)).sendToTarget();
        }
    }

    // called by JNI
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.808 -0500", hash_original_method = "C4BB5E4EA56AD7707D8515F7F4BEC247", hash_generated_method = "1777340C1ECC43061C50442F52971EC3")
    
private void clearTextEntry() {
        if (mWebView == null) return;
        Message.obtain(mWebView.mPrivateHandler,
                WebView.CLEAR_TEXT_ENTRY).sendToTarget();
    }

    // called by JNI
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.810 -0500", hash_original_method = "862481A256A95A2E1B26E19ED8AB682F", hash_generated_method = "590028DDFB205BCEB134A236F98592A2")
    
private void sendFindAgain() {
        if (mWebView == null) return;
        Message.obtain(mWebView.mPrivateHandler,
                WebView.FIND_AGAIN).sendToTarget();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.814 -0500", hash_original_method = "1F73AE1CA1E2566920108C9D357DD01C", hash_generated_method = "C8F06C1C15F031C8E9E0C067CC050D97")
    
    private void nativeUpdateFrameCacheIfLoading(){
    	//Formerly a native method
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.817 -0500", hash_original_method = "F955ECFDACE0CC28D366B33E5FEC0536", hash_generated_method = "9B46A1F4657A5E7602E70A8D375A7F4F")
    
    private void nativeRevealSelection(){
    	//Formerly a native method
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.711 -0400", hash_original_method = "D72E3E2D187EE0995228637414D15F8B", hash_generated_method = "77A50DA793DDA2062D397DD558B3E833")
    private String nativeRequestLabel(int framePtr, int nodePtr) {
    	String s = new String ();
    	s.addTaint(getTaint());
    	return s;
    }
    /**
     * Scroll the focused textfield to (xPercent, y) in document space
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.824 -0500", hash_original_method = "CDA0A8C6D295040926E78ABE78DD6146", hash_generated_method = "4B933B475475A8A7E23E265423554132")
    
    private void nativeScrollFocusedTextInput(float xPercent, int y){
    	//Formerly a native method
    	addTaint(xPercent);
    	addTaint(y);
    }

    // these must be in document space (i.e. not scaled/zoomed).
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.828 -0500", hash_original_method = "E13D9D9BB267DB78AE29574F59D715C7", hash_generated_method = "665391BA722D368B737182293011ECDF")
    
    private void nativeSetScrollOffset(int gen, boolean sendScrollEvent, int dx, int dy){
    	//Formerly a native method
    	addTaint(gen);
    	addTaint(sendScrollEvent);
    	addTaint(dx);
    	addTaint(dy);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.832 -0500", hash_original_method = "1D56EADE7E65827B4B9A4C6FC3F7D192", hash_generated_method = "C2B8B7970AA5E67798295AAF22B31BE6")
    
    private void nativeSetGlobalBounds(int x, int y, int w, int h){
    	//Formerly a native method
    	addTaint(x);
    	addTaint(y);
    	addTaint(w);
    	addTaint(h);
    }

    // called by JNI
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.834 -0500", hash_original_method = "AECCF0A7E8C40F57D58CA373D809DB0E", hash_generated_method = "16C4C8F8EC00CC2B69919BE68E9797D1")
    
private void requestListBox(String[] array, int[] enabledArray,
            int[] selectedArray) {
        if (mWebView != null) {
            mWebView.requestListBox(array, enabledArray, selectedArray);
        }
    }

    // called by JNI
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.837 -0500", hash_original_method = "9DBC344B8D87A71D6BD3CB15F0701F64", hash_generated_method = "3BCB1AC536A2369D5E4C5F0DC77C2340")
    
private void requestListBox(String[] array, int[] enabledArray,
            int selection) {
        if (mWebView != null) {
            mWebView.requestListBox(array, enabledArray, selection);
        }

    }

    // called by JNI
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.839 -0500", hash_original_method = "2EB26549510C49A5C07788F5DA665EE0", hash_generated_method = "FDDF896C37C8AFAE28089E230D21A044")
    
private void requestKeyboardWithSelection(int pointer, int selStart,
            int selEnd, int textGeneration) {
        if (mWebView != null) {
            Message.obtain(mWebView.mPrivateHandler,
                    WebView.REQUEST_KEYBOARD_WITH_SELECTION_MSG_ID, pointer,
                    textGeneration, new TextSelectionData(selStart, selEnd))
                    .sendToTarget();
        }
    }

    // called by JNI
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.841 -0500", hash_original_method = "C7739CA97531242F19EB30C6F079B5B2", hash_generated_method = "BD09D54833770D746285DDBFB722CED6")
    
private void requestKeyboard(boolean showKeyboard) {
        if (mWebView != null) {
            Message.obtain(mWebView.mPrivateHandler,
                    WebView.REQUEST_KEYBOARD, showKeyboard ? 1 : 0, 0)
                    .sendToTarget();
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.843 -0500", hash_original_method = "DC8BC22A6F75F1D5B407274C2907FB6A", hash_generated_method = "F49F7418D51AD0EC420B37EBCBA28E0B")
    
private void setWebTextViewAutoFillable(int queryId, String preview) {
        if (mWebView != null) {
            Message.obtain(mWebView.mPrivateHandler, WebView.SET_AUTOFILLABLE,
                    new AutoFillData(queryId, preview))
                    .sendToTarget();
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.845 -0500", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "4F4EBC54D108D66F416C93B46580E117")
    
Context getContext() {
        return mContext;
    }

    // called by JNI
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.847 -0500", hash_original_method = "06D3F71D264B84B5441A889608149189", hash_generated_method = "88A96A9A2805E4296588B58C941FE6FD")
    
private void keepScreenOn(boolean screenOn) {
        if (mWebView != null) {
            Message message = mWebView.mPrivateHandler.obtainMessage(WebView.SCREEN_ON);
            message.arg1 = screenOn ? 1 : 0;
            message.sendToTarget();
        }
    }

    // called by JNI
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.849 -0500", hash_original_method = "10FFBA7C056FD6BA9A1C610F1A172C8D", hash_generated_method = "F0634BB0D878A51E0AC0E654A10AC6AF")
    
private Class<?> getPluginClass(String libName, String clsName) {

        if (mWebView == null) {
            return null;
        }

        PluginManager pluginManager = PluginManager.getInstance(null);

        String pkgName = pluginManager.getPluginsAPKName(libName);
        if (pkgName == null) {
            Log.w(LOGTAG, "Unable to resolve " + libName + " to a plugin APK");
            return null;
        }

        try {
            return pluginManager.getPluginClass(pkgName, clsName);
        } catch (NameNotFoundException e) {
            Log.e(LOGTAG, "Unable to find plugin classloader for the apk (" + pkgName + ")");
        } catch (ClassNotFoundException e) {
            Log.e(LOGTAG, "Unable to find plugin class (" + clsName +
                    ") in the apk (" + pkgName + ")");
        }

        return null;
    }

    // called by JNI. PluginWidget function to launch a full-screen view using a
    // View object provided by the plugin class.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.852 -0500", hash_original_method = "56D58B33C48E10C4B09153457527EDE8", hash_generated_method = "78C5A8A80881DE5AD3F8747A4C0EACB4")
    
private void showFullScreenPlugin(ViewManager.ChildView childView, int orientation, int npp) {
        if (mWebView == null) {
            return;
        }

        Message message = mWebView.mPrivateHandler.obtainMessage(WebView.SHOW_FULLSCREEN);
        message.obj = childView.mView;
        message.arg1 = orientation;
        message.arg2 = npp;
        message.sendToTarget();
    }

    // called by JNI
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.854 -0500", hash_original_method = "98BEE7CF6CD4E23C3FBAA61970F9B21C", hash_generated_method = "FE89C4B4322E738FCC7C5D6505899999")
    
private void hideFullScreenPlugin() {
        if (mWebView == null) {
            return;
        }
        mWebView.mPrivateHandler.obtainMessage(WebView.HIDE_FULLSCREEN)
                .sendToTarget();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.857 -0500", hash_original_method = "A3E933C7DAB8D83D100D1E88122325C7", hash_generated_method = "22DEDC2425273ED6CB4EC6E6B68E793F")
    
private ViewManager.ChildView createSurface(View pluginView) {
        if (mWebView == null) {
            return null;
        }

        if (pluginView == null) {
            Log.e(LOGTAG, "Attempted to add an empty plugin view to the view hierarchy");
            return null;
        }

        // ensures the view system knows the view can redraw itself
        pluginView.setWillNotDraw(false);

        if(pluginView instanceof SurfaceView)
            ((SurfaceView)pluginView).setZOrderOnTop(true);

        ViewManager.ChildView view = mWebView.mViewManager.createView();
        view.mView = pluginView;
        return view;
    }

    // called by JNI.  PluginWidget functions for creating an embedded View for
    // the surface drawing model.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.859 -0500", hash_original_method = "97AE1F230CE0C97985778B5B23111878", hash_generated_method = "AFF2A87A768285B55AA8DAEE6E592D16")
    
private ViewManager.ChildView addSurface(View pluginView, int x, int y,
                                             int width, int height) {
        ViewManager.ChildView view = createSurface(pluginView);
        view.attachView(x, y, width, height);
        return view;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.862 -0500", hash_original_method = "75F4F4C2028D65C3C8554ED4635C74ED", hash_generated_method = "4A8C077DA976503F763AFE428F6ABEE3")
    
private void updateSurface(ViewManager.ChildView childView, int x, int y,
            int width, int height) {
        childView.attachView(x, y, width, height);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.864 -0500", hash_original_method = "416DFEE1629652841DDA085C9B0D0611", hash_generated_method = "576B5C840308D0D94145A822E2D25EA6")
    
private void destroySurface(ViewManager.ChildView childView) {
        childView.removeView();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.889 -0500", hash_original_method = "22185D2849BB84C82B1605DF19FAA2EB", hash_generated_method = "D68FD53E8D71DAAE958B1AF926D457DE")
    
private void showRect(int left, int top, int width, int height,
            int contentWidth, int contentHeight, float xPercentInDoc,
            float xPercentInView, float yPercentInDoc, float yPercentInView) {
        if (mWebView != null) {
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
    }

    // called by JNI
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.892 -0500", hash_original_method = "1DA5EF32A9FA7AF08D14A38F102400D4", hash_generated_method = "C7DF747D64102E8611B227998E6D6BD1")
    
private void centerFitRect(int x, int y, int width, int height) {
        if (mWebView == null) {
            return;
        }
        mWebView.mPrivateHandler.obtainMessage(WebView.CENTER_FIT_RECT,
                new Rect(x, y, x + width, y + height)).sendToTarget();
    }

    // called by JNI
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.894 -0500", hash_original_method = "D8FA837CEB894605C45672F0DC41EFFC", hash_generated_method = "533FA1C84F813B1C642B5609839EE1D6")
    
private void setScrollbarModes(int hMode, int vMode) {
        if (mWebView == null) {
            return;
        }
        mWebView.mPrivateHandler.obtainMessage(WebView.SET_SCROLLBAR_MODES,
                hMode, vMode).sendToTarget();
    }

    // called by JNI
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.897 -0500", hash_original_method = "07DD7AFD4B9B08AAE72EF7B16777A3F8", hash_generated_method = "D48B528E8F3E3072B63F3EAEC64B308D")
    
@SuppressWarnings("unused")
    private void selectAt(int x, int y) {
        if (mWebView != null) {
            mWebView.mPrivateHandler.obtainMessage(WebView.SELECT_AT, x, y).sendToTarget();
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.899 -0500", hash_original_method = "6A70D904110AF22683C1DB763A75BE10", hash_generated_method = "C969B231EA98791A275DFD57E74C3FC3")
    
private void useMockDeviceOrientation() {
        mDeviceMotionAndOrientationManager.useMock();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.901 -0500", hash_original_method = "F3DDD41A8D23B4AE9E9585A561AEE4C2", hash_generated_method = "BFD16E4F0B03C0C55E44476F6ACE2D33")
    
public void setMockDeviceOrientation(boolean canProvideAlpha, double alpha,
            boolean canProvideBeta, double beta, boolean canProvideGamma, double gamma) {
        mDeviceMotionAndOrientationManager.setMockOrientation(canProvideAlpha, alpha,
                canProvideBeta, beta, canProvideGamma, gamma);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.903 -0500", hash_original_method = "2C35CA4A669368B8EA54C6F975558D19", hash_generated_method = "FAAAE4C8F054D6CFEE2EE4D0A044FABC")
    
protected DeviceMotionService getDeviceMotionService() {
        if (mDeviceMotionService == null) {
            mDeviceMotionService =
                    new DeviceMotionService(mDeviceMotionAndOrientationManager, mContext);
        }
        return mDeviceMotionService;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.906 -0500", hash_original_method = "C07B296E9A86FE4EA87FDBAE8692F74E", hash_generated_method = "614538BACC3BA83A601CECDF38EABE63")
    
protected DeviceOrientationService getDeviceOrientationService() {
        if (mDeviceOrientationService == null) {
            mDeviceOrientationService =
                    new DeviceOrientationService(mDeviceMotionAndOrientationManager, mContext);
        }
        return mDeviceOrientationService;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.909 -0500", hash_original_method = "80A2D6FB8A6209AB3E75A13699D0F2FD", hash_generated_method = "CF4538982C5037B5A1BC5018437C986B")
    
    private void nativeSetIsPaused(boolean isPaused){
    	//Formerly a native method
    	addTaint(isPaused);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.912 -0500", hash_original_method = "F7A6503DE7A4FD810E8E9ABDA2EEEB51", hash_generated_method = "0F5C3D2E7EEF14532DA9477B4B6DBFC1")
    
    private void nativePause(){
    	//Formerly a native method
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.916 -0500", hash_original_method = "5AFDAE76FDF49AA60F1B62133763C925", hash_generated_method = "AD61CCD7043352C3181C59605B3B1E40")
    
    private void nativeResume(){
    	//Formerly a native method
    }

    private static class WebCoreThread implements Runnable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.174 -0500", hash_original_field = "F2F3FD27E3C0039D3E93099B6B8DDCBB", hash_generated_field = "4F713FFA365E563DDF84874CBE5719C1")

        private static final int INITIALIZE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.176 -0500", hash_original_field = "8F3F15AC469BBA3B02E1013EF2AC7AF9", hash_generated_field = "D52F26E421F5AA24F0046DDA3C5C6D30")

        private static final int REDUCE_PRIORITY = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.179 -0500", hash_original_field = "708092220C813988ED106EB7C095C781", hash_generated_field = "3E1A8A26CB7DF68F6FF0F277BCB9EC28")

        private static final int RESUME_PRIORITY = 2;
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.229 -0400", hash_original_method = "2F45E06CFBCB348B09D51D400BB9B9A9", hash_generated_method = "2F45E06CFBCB348B09D51D400BB9B9A9")
        public WebCoreThread ()
        {
            //Synthesized constructor
        }
        
        
  

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.185 -0500", hash_original_method = "82DEF5A0DA884DCAB5C26C3D415DCFF4", hash_generated_method = "2E3D0317EE5893C232A5D0C05FB91FEB")
public void run() {
            Looper.prepare();
            Assert.assertNull(sWebCoreHandler);
            synchronized (WebViewCore.class) {
                sWebCoreHandler = new Handler() {
                    @Override
                    public void handleMessage(Message msg) {
                        switch (msg.what) {
                            case INITIALIZE:
                                WebViewCore core = (WebViewCore) msg.obj;
                                core.initialize();
                                break;

                            case REDUCE_PRIORITY:
                                // 3 is an adjustable number.
                                Process.setThreadPriority(
                                        Process.THREAD_PRIORITY_DEFAULT + 3 *
                                        Process.THREAD_PRIORITY_LESS_FAVORABLE);
                                break;

                            case RESUME_PRIORITY:
                                Process.setThreadPriority(
                                        Process.THREAD_PRIORITY_DEFAULT);
                                break;

                            case EventHub.ADD_PACKAGE_NAME:
                                if (BrowserFrame.sJavaBridge == null) {
                                    throw new IllegalStateException(
                                            "No WebView has been created in this process!");
                                }
                                BrowserFrame.sJavaBridge.addPackageName((String) msg.obj);
                                break;

                            case EventHub.REMOVE_PACKAGE_NAME:
                                if (BrowserFrame.sJavaBridge == null) {
                                    throw new IllegalStateException(
                                            "No WebView has been created in this process!");
                                }
                                BrowserFrame.sJavaBridge.removePackageName((String) msg.obj);
                                break;

                            case EventHub.PROXY_CHANGED:
                                if (BrowserFrame.sJavaBridge == null) {
                                    throw new IllegalStateException(
                                            "No WebView has been created in this process!");
                                }
                                BrowserFrame.sJavaBridge.updateProxy((ProxyProperties)msg.obj);
                                break;
                        }
                    }
                };
                WebViewCore.class.notify();
            }
            Looper.loop();
        }
    }
    
    static class BaseUrlData {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.190 -0500", hash_original_field = "0F88855D567BFEE131EF7A180E754162", hash_generated_field = "0F88855D567BFEE131EF7A180E754162")

        String mBaseUrl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.192 -0500", hash_original_field = "3664585E19B9FCA2DFE85009B6783215", hash_generated_field = "3664585E19B9FCA2DFE85009B6783215")

        String mData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.194 -0500", hash_original_field = "B161F982909610C03B68BAACDD54E076", hash_generated_field = "B161F982909610C03B68BAACDD54E076")

        String mMimeType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.196 -0500", hash_original_field = "532663CB004FA57020360003BD60B6E5", hash_generated_field = "532663CB004FA57020360003BD60B6E5")

        String mEncoding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.199 -0500", hash_original_field = "AEB84E0F96BC10F5DEF2A6843387856E", hash_generated_field = "AEB84E0F96BC10F5DEF2A6843387856E")

        String mHistoryUrl;
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.230 -0400", hash_original_method = "AAC8AA273862AA8B9D6E5E4822EA2513", hash_generated_method = "AAC8AA273862AA8B9D6E5E4822EA2513")
        public BaseUrlData ()
        {
            //Synthesized constructor
        }

    }
    
    static class CursorData {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.208 -0500", hash_original_field = "D59A59F4900CEA9BE8C05ED55105224C", hash_generated_field = "D59A59F4900CEA9BE8C05ED55105224C")

        int mMoveGeneration;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.210 -0500", hash_original_field = "9B989DBD5A4561D5F736D4FD676DE2CE", hash_generated_field = "9B989DBD5A4561D5F736D4FD676DE2CE")

        int mFrame;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.212 -0500", hash_original_field = "F027C31ADF98D567850EC92AEACBFEFA", hash_generated_field = "F027C31ADF98D567850EC92AEACBFEFA")

        int mNode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.214 -0500", hash_original_field = "E0802CA55986D756D3E3A834B7025711", hash_generated_field = "E0802CA55986D756D3E3A834B7025711")

        int mX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.216 -0500", hash_original_field = "C11B85C67D00215273BFDFFDFCE3FC28", hash_generated_field = "C11B85C67D00215273BFDFFDFCE3FC28")

        int mY;
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.204 -0500", hash_original_method = "CB52479A54028E5EA2D022FBED517AD0", hash_generated_method = "CB52479A54028E5EA2D022FBED517AD0")
        
CursorData() {}
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.206 -0500", hash_original_method = "6825641482AFD3BD8931BBB7542BDAEF", hash_generated_method = "6825641482AFD3BD8931BBB7542BDAEF")
        
CursorData(int frame, int node, int x, int y) {
            mFrame = frame;
            mNode = node;
            mX = x;
            mY = y;
        }
        
    }
    
    static class JSInterfaceData {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.220 -0500", hash_original_field = "63EB2904DE14485FE87749A3C0F578EC", hash_generated_field = "63EB2904DE14485FE87749A3C0F578EC")

        Object mObject;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.222 -0500", hash_original_field = "5D2D75DE4020ED94AFC743546E0FE97A", hash_generated_field = "5D2D75DE4020ED94AFC743546E0FE97A")

        String mInterfaceName;
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.231 -0400", hash_original_method = "C47EAF7170BE00EF188AF129D614A9F5", hash_generated_method = "C47EAF7170BE00EF188AF129D614A9F5")
        public JSInterfaceData ()
        {
            //Synthesized constructor
        }

    }
    
    static class JSKeyData {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.226 -0500", hash_original_field = "7557BA9FD6670B3E0CA06B263630791D", hash_generated_field = "7557BA9FD6670B3E0CA06B263630791D")

        String mCurrentText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.228 -0500", hash_original_field = "F843A40E7301C6699FB9E0A288E3C561", hash_generated_field = "F843A40E7301C6699FB9E0A288E3C561")

        KeyEvent mEvent;
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.231 -0400", hash_original_method = "95B0202B54BCEE663EF275E1A8F4EB03", hash_generated_method = "95B0202B54BCEE663EF275E1A8F4EB03")
        public JSKeyData ()
        {
            //Synthesized constructor
        }

    }
    
    static class MotionUpData {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.232 -0500", hash_original_field = "9B989DBD5A4561D5F736D4FD676DE2CE", hash_generated_field = "9B989DBD5A4561D5F736D4FD676DE2CE")

        int mFrame;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.234 -0500", hash_original_field = "F027C31ADF98D567850EC92AEACBFEFA", hash_generated_field = "F027C31ADF98D567850EC92AEACBFEFA")

        int mNode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.237 -0500", hash_original_field = "9B5975BB58D6180DFB202E80016B49DF", hash_generated_field = "9B5975BB58D6180DFB202E80016B49DF")

        Rect mBounds;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.239 -0500", hash_original_field = "E0802CA55986D756D3E3A834B7025711", hash_generated_field = "E0802CA55986D756D3E3A834B7025711")

        int mX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.241 -0500", hash_original_field = "C11B85C67D00215273BFDFFDFCE3FC28", hash_generated_field = "C11B85C67D00215273BFDFFDFCE3FC28")

        int mY;
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.231 -0400", hash_original_method = "4355A8BB53AC7F3F83470ED46BB47437", hash_generated_method = "4355A8BB53AC7F3F83470ED46BB47437")
        public MotionUpData ()
        {
            //Synthesized constructor
        }

    }
    
    static class GetUrlData {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.245 -0500", hash_original_field = "CA88DB4A75B79130313A74537195706C", hash_generated_field = "CA88DB4A75B79130313A74537195706C")

        String mUrl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.247 -0500", hash_original_field = "14E35722A33BF986AB2BBFC3C0CBCBA2", hash_generated_field = "14E35722A33BF986AB2BBFC3C0CBCBA2")

        Map<String, String> mExtraHeaders;
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.231 -0400", hash_original_method = "CF502CDAA78836D9E58C0BF8CE098EA6", hash_generated_method = "CF502CDAA78836D9E58C0BF8CE098EA6")
        public GetUrlData ()
        {
            //Synthesized constructor
        }

    }
    
    static class PostUrlData {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.251 -0500", hash_original_field = "CA88DB4A75B79130313A74537195706C", hash_generated_field = "CA88DB4A75B79130313A74537195706C")

        String mUrl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.253 -0500", hash_original_field = "2D2347367D31A512EEC0E8D215ED2DBD", hash_generated_field = "2D2347367D31A512EEC0E8D215ED2DBD")

        byte[] mPostData;
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.231 -0400", hash_original_method = "7059AB3E9E778C04182440D5313C7DC6", hash_generated_method = "7059AB3E9E778C04182440D5313C7DC6")
        public PostUrlData ()
        {
            //Synthesized constructor
        }

    }
    
    static class ReplaceTextData {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.257 -0500", hash_original_field = "226A663453FC02DD850C06CE0AA619ED", hash_generated_field = "226A663453FC02DD850C06CE0AA619ED")

        String mReplace;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.260 -0500", hash_original_field = "A73595A3B0345E5117F13612DC4CCFDE", hash_generated_field = "A73595A3B0345E5117F13612DC4CCFDE")

        int mNewStart;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.262 -0500", hash_original_field = "B601FB45644C5114D25521700D4C4DB9", hash_generated_field = "B601FB45644C5114D25521700D4C4DB9")

        int mNewEnd;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.264 -0500", hash_original_field = "199FE44F91F4F1B8CB571680578352F3", hash_generated_field = "199FE44F91F4F1B8CB571680578352F3")

        int mTextGeneration;
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.232 -0400", hash_original_method = "006F168E0387BB00C04A074431FA3645", hash_generated_method = "006F168E0387BB00C04A074431FA3645")
        public ReplaceTextData ()
        {
            //Synthesized constructor
        }

    }
    
    static class TextSelectionData {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.271 -0500", hash_original_field = "83A19D93B82C07A79F54E265C2077EC6", hash_generated_field = "83A19D93B82C07A79F54E265C2077EC6")

        int mStart;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.273 -0500", hash_original_field = "6FAA56F5628A0F1DAAFED98EBDB1C99E", hash_generated_field = "6FAA56F5628A0F1DAAFED98EBDB1C99E")

        int mEnd;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.269 -0500", hash_original_method = "01ADB7A0134281E557F1A0D40D5248A7", hash_generated_method = "51F31B1B2F671AD8E81C48600282ED45")
        
public TextSelectionData(int start, int end) {
            mStart = start;
            mEnd = end;
        }
        
    }
    
    static class TouchUpData {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.276 -0500", hash_original_field = "D59A59F4900CEA9BE8C05ED55105224C", hash_generated_field = "D59A59F4900CEA9BE8C05ED55105224C")

        int mMoveGeneration;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.279 -0500", hash_original_field = "9B989DBD5A4561D5F736D4FD676DE2CE", hash_generated_field = "9B989DBD5A4561D5F736D4FD676DE2CE")

        int mFrame;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.282 -0500", hash_original_field = "F027C31ADF98D567850EC92AEACBFEFA", hash_generated_field = "F027C31ADF98D567850EC92AEACBFEFA")

        int mNode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.284 -0500", hash_original_field = "E0802CA55986D756D3E3A834B7025711", hash_generated_field = "E0802CA55986D756D3E3A834B7025711")

        int mX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.286 -0500", hash_original_field = "C11B85C67D00215273BFDFFDFCE3FC28", hash_generated_field = "C11B85C67D00215273BFDFFDFCE3FC28")

        int mY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.288 -0500", hash_original_field = "DAF0696670C19E15E40480440A2F88F9", hash_generated_field = "DAF0696670C19E15E40480440A2F88F9")

        int mNativeLayer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.290 -0500", hash_original_field = "1F075EDD02BEA33DB423E929CF5DF8B3", hash_generated_field = "1F075EDD02BEA33DB423E929CF5DF8B3")

        Rect mNativeLayerRect = new Rect();
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.232 -0400", hash_original_method = "4711CC26AC513031C3BD47600FF5375E", hash_generated_method = "4711CC26AC513031C3BD47600FF5375E")
        public TouchUpData ()
        {
            //Synthesized constructor
        }

    }
    
    static class TouchHighlightData {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.294 -0500", hash_original_field = "E0802CA55986D756D3E3A834B7025711", hash_generated_field = "E0802CA55986D756D3E3A834B7025711")

        int mX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.296 -0500", hash_original_field = "C11B85C67D00215273BFDFFDFCE3FC28", hash_generated_field = "C11B85C67D00215273BFDFFDFCE3FC28")

        int mY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.298 -0500", hash_original_field = "36A23F758F1BAB418A00C8E7530FF272", hash_generated_field = "36A23F758F1BAB418A00C8E7530FF272")

        int mSlop;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.300 -0500", hash_original_field = "DAF0696670C19E15E40480440A2F88F9", hash_generated_field = "DAF0696670C19E15E40480440A2F88F9")

        int mNativeLayer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.302 -0500", hash_original_field = "6542388769AB508E323B9B2D0CF83E04", hash_generated_field = "6542388769AB508E323B9B2D0CF83E04")

        Rect mNativeLayerRect;
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.232 -0400", hash_original_method = "7EBB6E831321FAB695A1CB0442A597EC", hash_generated_method = "7EBB6E831321FAB695A1CB0442A597EC")
        public TouchHighlightData ()
        {
            //Synthesized constructor
        }

    }
    
    static class AutoFillData {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.317 -0500", hash_original_field = "3F8A5995BB61124C69E19BBF96B72914", hash_generated_field = "1A9B7D5E459A03CD29A94A18A042A141")

        private int mQueryId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.319 -0500", hash_original_field = "6374BBB14B9C67A0F34854556C13CAA1", hash_generated_field = "31FFD5C014EA21DA4DA7DD8A9D547D53")

        private String mPreview;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.307 -0500", hash_original_method = "1D9359D80D7809D2772AFB2E4DAF56F3", hash_generated_method = "DA6A00B09EBC7FE00BC4DFFFFF9761D6")
        
public AutoFillData() {
            mQueryId = WebTextView.FORM_NOT_AUTOFILLABLE;
            mPreview = "";
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.310 -0500", hash_original_method = "CF8D1F130162170BD4749FDD138AF5B0", hash_generated_method = "0FE0B79CF5161C5B7CC03DAA5E6FCCF6")
        
public AutoFillData(int queryId, String preview) {
            mQueryId = queryId;
            mPreview = preview;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.313 -0500", hash_original_method = "7DF004F757D7E4F7320327B99689B65F", hash_generated_method = "07C2EE867F16D29710E88AB9C49E3D4E")
        
public int getQueryId() {
            return mQueryId;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.315 -0500", hash_original_method = "E4F5699DB01CFB534A6B08E3CFDC42EF", hash_generated_method = "8A5955EDC0D2A0B15775585B43D49704")
        
public String getPreviewString() {
            return mPreview;
        }
        
    }
    
    static class TouchEventData {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.328 -0500", hash_original_field = "87F72266090A426F9B25050359B17309", hash_generated_field = "87F72266090A426F9B25050359B17309")

        int mAction;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.330 -0500", hash_original_field = "E819B465C38B8028BC46AB427A1B0B56", hash_generated_field = "E819B465C38B8028BC46AB427A1B0B56")

        int[] mIds;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.332 -0500", hash_original_field = "B3DCF7E604E73E985B3F580BA0A908EA", hash_generated_field = "B3DCF7E604E73E985B3F580BA0A908EA")

        Point[] mPoints;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.334 -0500", hash_original_field = "6C453702C678F946E46D0C5EF3CC237F", hash_generated_field = "6C453702C678F946E46D0C5EF3CC237F")

        Point[] mPointsInView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.336 -0500", hash_original_field = "F9EC98B636053754CBEB7C53CF600DA0", hash_generated_field = "F9EC98B636053754CBEB7C53CF600DA0")

        int mActionIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.338 -0500", hash_original_field = "2707C27F30BB3421B24DB98367DD2B08", hash_generated_field = "2707C27F30BB3421B24DB98367DD2B08")

        int mMetaState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.340 -0500", hash_original_field = "8929173B49E90127C15F1C598AE4AF4D", hash_generated_field = "8929173B49E90127C15F1C598AE4AF4D")

        boolean mReprocess;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.342 -0500", hash_original_field = "9DD13ABE729A13F299974C6122462E71", hash_generated_field = "9DD13ABE729A13F299974C6122462E71")

        MotionEvent mMotionEvent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.344 -0500", hash_original_field = "DAF0696670C19E15E40480440A2F88F9", hash_generated_field = "DAF0696670C19E15E40480440A2F88F9")

        int mNativeLayer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.347 -0500", hash_original_field = "1F075EDD02BEA33DB423E929CF5DF8B3", hash_generated_field = "1F075EDD02BEA33DB423E929CF5DF8B3")

        Rect mNativeLayerRect = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.349 -0500", hash_original_field = "B8B6644602DD2683A7B0A4778A62DE29", hash_generated_field = "B8B6644602DD2683A7B0A4778A62DE29")

        long mSequence;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.351 -0500", hash_original_field = "E2A349795E68B906376E94D17B04B738", hash_generated_field = "E2A349795E68B906376E94D17B04B738")

        boolean mNativeResult;
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.234 -0400", hash_original_method = "5D833927D3B75D4A9450986FF605CB3C", hash_generated_method = "5D833927D3B75D4A9450986FF605CB3C")
        public TouchEventData ()
        {
            //Synthesized constructor
        }

    }
    
    static class GeolocationPermissionsData {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.356 -0500", hash_original_field = "C27E43E4C41D4CBE4FD965D1402BAA57", hash_generated_field = "C27E43E4C41D4CBE4FD965D1402BAA57")

        String mOrigin;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.358 -0500", hash_original_field = "A7167E37AF8158CE579643A2ED8BFF31", hash_generated_field = "A7167E37AF8158CE579643A2ED8BFF31")

        boolean mAllow;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.360 -0500", hash_original_field = "088F231AED0EEA266EF56EDD1C6497CE", hash_generated_field = "088F231AED0EEA266EF56EDD1C6497CE")

        boolean mRemember;
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.234 -0400", hash_original_method = "D46B71F5C8BC4DF5D7976DC461AFF808", hash_generated_method = "D46B71F5C8BC4DF5D7976DC461AFF808")
        public GeolocationPermissionsData ()
        {
            //Synthesized constructor
        }

    }
    
    public class EventHub {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.367 -0500", hash_original_field = "A76A4025B6B436A643E3C50A7E471851", hash_generated_field = "A1A4E056845B8B693139A8C45FF0BD72")

        static final int REVEAL_SELECTION = 96;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.369 -0500", hash_original_field = "613BEB415D6108B12572991E11B42C00", hash_generated_field = "95A702E62450AA8F90586DC0EC79158C")

        static final int REQUEST_LABEL = 97;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.372 -0500", hash_original_field = "F3697FD3E03966AE9B6D8FB9B1B22B63", hash_generated_field = "281B4C01D26497075CD5765CB75D0077")

        static final int UPDATE_FRAME_CACHE_IF_LOADING = 98;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.374 -0500", hash_original_field = "06E08F80F4193CC820BAEC7317534BC0", hash_generated_field = "2BA34DD0A9639D2054B9A5B00693A908")

        static final int SCROLL_TEXT_INPUT = 99;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.377 -0500", hash_original_field = "3D416C8CD77184FB83BDBA69A99B3371", hash_generated_field = "086D57918D4358A7798E134FC092C3BB")

        static final int LOAD_URL = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.380 -0500", hash_original_field = "816EBBE31270B92FC65D4C7FBED3E779", hash_generated_field = "C733C295F0605C3FC1982015BD6F78B6")

        static final int STOP_LOADING = 101;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.382 -0500", hash_original_field = "32EEDDF1F6437948372F0304A229A32F", hash_generated_field = "C7B38026E54635BC386787F3AFC2F7C4")

        static final int RELOAD = 102;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.384 -0500", hash_original_field = "7E9CE53DA4DAEC2A190818288C6B8A6A", hash_generated_field = "7919C762EDFBC0511A97F543FFE7E251")

        static final int KEY_DOWN = 103;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.387 -0500", hash_original_field = "66E9ADA5E8EE4078A4E0C68CE8132E8B", hash_generated_field = "A5CBBF6B1244669FBFA9F6F006C227BA")

        static final int KEY_UP = 104;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.389 -0500", hash_original_field = "82C00A66B7B9B4FFBE10AA31028BE32F", hash_generated_field = "EAACB31F67B066D7D2CA5D7E23855B82")

        static final int VIEW_SIZE_CHANGED = 105;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.391 -0500", hash_original_field = "4E5E6FADA682A7A6DC4CC38C10A185B9", hash_generated_field = "D5CB605B980594BC52BBC10DC40E6266")

        static final int GO_BACK_FORWARD = 106;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.393 -0500", hash_original_field = "3F434961C721DE8007A2DAB5396BB3A9", hash_generated_field = "378A2EE3FA8A592042114561EA32D332")

        static final int SET_SCROLL_OFFSET = 107;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.396 -0500", hash_original_field = "43EA4BD4A930906E0DD50465A4357946", hash_generated_field = "F871EED787411D12EE2BA9431E64EB83")

        static final int RESTORE_STATE = 108;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.398 -0500", hash_original_field = "9C1946C580D171888FB75E25EB4E2598", hash_generated_field = "89DD19A30AEABFC7ED706641457D8982")

        static final int PAUSE_TIMERS = 109;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.401 -0500", hash_original_field = "8B64E60C0C5BD3A1DA1BC4404226E1FD", hash_generated_field = "2D98A340CF3EB3EA3724650A717350E9")

        static final int RESUME_TIMERS = 110;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.403 -0500", hash_original_field = "544F10C47F0B58FCEFAA0EEA785FB58E", hash_generated_field = "B73EE49855F361841364FF21C972BAB4")

        static final int CLEAR_CACHE = 111;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.405 -0500", hash_original_field = "231CD9CC19523FBD9041803A405FB63E", hash_generated_field = "AEC59F30BA1D81C9D5F4CE4F397F47D4")

        static final int CLEAR_HISTORY = 112;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.408 -0500", hash_original_field = "AC998F5D15E7E3868E6F7E2670693460", hash_generated_field = "6E185859BEFC79914687F7ECA5E9F874")

        static final int SET_SELECTION = 113;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.410 -0500", hash_original_field = "606BDE05D722080660E35110727A5709", hash_generated_field = "C0EB4E3347FFE212A8C18F2A3E44C7BE")

        static final int REPLACE_TEXT = 114;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.412 -0500", hash_original_field = "D3A8560BFE639597F59149D2AF5D673B", hash_generated_field = "74867D5CAE32FC825A2AE3E24431DD95")

        static final int PASS_TO_JS = 115;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.415 -0500", hash_original_field = "32498E8AE985774142853A192BB4B499", hash_generated_field = "2959DC038CF421309872D0B26605BC48")

        static final int SET_GLOBAL_BOUNDS = 116;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.417 -0500", hash_original_field = "C7B6F3D0303CCE545059906D961B4F9B", hash_generated_field = "985745CFE407397A79760A370C81EB50")

        static final int UPDATE_CACHE_AND_TEXT_ENTRY = 117;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.420 -0500", hash_original_field = "49BF74A7202ADCB2A2DD50FA6D6EC00F", hash_generated_field = "61E286EB171C779795532F131306C2B8")

        static final int CLICK = 118;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.422 -0500", hash_original_field = "D0091BE52ED60CF7574CE3558F5A50DB", hash_generated_field = "C054E26A89164E92142B9754275E54DF")

        static final int SET_NETWORK_STATE = 119;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.424 -0500", hash_original_field = "FA284D5636DE898447EE53AC5245EC62", hash_generated_field = "A807D55DE295D1B170656AD4F0201C5E")

        static final int DOC_HAS_IMAGES = 120;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.427 -0500", hash_original_field = "FEE55F899A78845FF77AB43C59A083E9", hash_generated_field = "D33F0FEAFFF69D0C42BAFDB402479110")

        static final int FAKE_CLICK = 121;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.430 -0500", hash_original_field = "6E27A0C1DF357FE9E091FA939176B012", hash_generated_field = "F26A5181B23CFECA8797551DC8D3CAE9")

        static final int DELETE_SELECTION = 122;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.432 -0500", hash_original_field = "1E597CD8BB60DD4158906D7D01A16139", hash_generated_field = "8ABAD2B9E240BA920D9928675F720B99")

        static final int LISTBOX_CHOICES = 123;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.434 -0500", hash_original_field = "3BF71BE90F1A6B88FB781A7DF3A4E774", hash_generated_field = "87CC0A49DCC346349771C56003B71750")

        static final int SINGLE_LISTBOX_CHOICE = 124;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.437 -0500", hash_original_field = "A175487245A8544A7A8867A651A8B509", hash_generated_field = "04B8BC482E2A7B96E01E5E3110E0B668")

        public static final int MESSAGE_RELAY = 125;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.439 -0500", hash_original_field = "D469BCF97E282FF0675B970FD007C50F", hash_generated_field = "6E2F6688DF5B663BAB9DD961B764EE61")

        static final int SET_BACKGROUND_COLOR = 126;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.442 -0500", hash_original_field = "FCCF870034EE25CFD6ED3E91479B2A7E", hash_generated_field = "044533B2719816EAAA2232B84AB25CEF")

        static final int SET_MOVE_FOCUS = 127;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.444 -0500", hash_original_field = "E41D4598BD40BFA20C887C4791F44368", hash_generated_field = "03D02B5B16A89402CEDE2754F4401D5C")

        static final int SAVE_DOCUMENT_STATE = 128;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.447 -0500", hash_original_field = "E861030BBA62147F1BFE70FFE7E1B372", hash_generated_field = "311987CBB915E85277F2F9AE5B25E8B9")

        static final int WEBKIT_DRAW = 130;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.449 -0500", hash_original_field = "A8036054A0877A8D907F24D6FA98E056", hash_generated_field = "3CAAA0995206DE66D86074216FC35CD6")

        static final int POST_URL = 132;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.451 -0500", hash_original_field = "1D243385835FC697E39F6B49AD7A350F", hash_generated_field = "37F5E563749301EE7D599A81A9CF7143")

        static final int SPLIT_PICTURE_SET = 133;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.453 -0500", hash_original_field = "65CE3E936B7D27369C44D0756CAC3F8E", hash_generated_field = "12980B1BE510BC8A29053E9D7D333DAB")

        static final int CLEAR_CONTENT = 134;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.455 -0500", hash_original_field = "04524E53A198197B17DF17D6C396676F", hash_generated_field = "1777EF02F537F813F3100A202247E8D6")

        static final int SET_MOVE_MOUSE = 135;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.458 -0500", hash_original_field = "A8604FC25DF4CAB7401000607AFBEF98", hash_generated_field = "32A2279F96B6FB2BD9A1A8A581BC021B")

        static final int SET_MOVE_MOUSE_IF_LATEST = 136;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.461 -0500", hash_original_field = "A4C2DF4277400713EBA70EE79E060A5B", hash_generated_field = "E21D375BD23E64F446953AB2BF9346A4")

        static final int REQUEST_CURSOR_HREF = 137;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.463 -0500", hash_original_field = "F17C9A9B42BB81A6CBBC892348A0BA87", hash_generated_field = "7CDC3D34B6EE61E2B892A9C01ABFBC9D")

        static final int ADD_JS_INTERFACE = 138;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.465 -0500", hash_original_field = "14108C36C74178A3B6D0F98FF0F46D04", hash_generated_field = "A923706DD675028E24F855109A5C9DB4")

        static final int LOAD_DATA = 139;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.469 -0500", hash_original_field = "96F130ED919E39E063E5B8892AC9206C", hash_generated_field = "040EB045A76CDEE06C177118ECAE7213")

        static final int TOUCH_UP = 140;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.471 -0500", hash_original_field = "2CBAC83254DE5F5C0223FF721B4C089A", hash_generated_field = "EA2A61439DE3D7F424486BE38A8E9097")

        static final int TOUCH_EVENT = 141;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.473 -0500", hash_original_field = "BBDAF6EC1D04D625A3B088B20758821B", hash_generated_field = "80D95538BE7C6AAD708E1345267909F2")

        // based on whether the WebView has focus and whether the WebView's
        // cursor matches the webpage's focus.
        static final int SET_ACTIVE = 142;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.476 -0500", hash_original_field = "76B6543D4A073852C28D9451686159BA", hash_generated_field = "CC928AAC2E1F292EFFECADD291C71F71")

        // is global)
        static final int ON_PAUSE = 143;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.478 -0500", hash_original_field = "022B7FCCC1B783DB00682F88F75EC19E", hash_generated_field = "E0C0F7F667064D1694A485ACA08D0272")

        static final int ON_RESUME = 144;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.480 -0500", hash_original_field = "76426E31E13274C8D5B6E6284A774FC9", hash_generated_field = "D46DC07E1723FDD9EB9D0B9D49FA6C70")

        static final int FREE_MEMORY = 145;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.483 -0500", hash_original_field = "1D049D9609D401E9B7E13B5B4893C360", hash_generated_field = "E026B9CBD97125E0F86C178AAAA6C477")

        static final int VALID_NODE_BOUNDS = 146;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.485 -0500", hash_original_field = "F06A2CB1033984BF61BC942AEB3E97AD", hash_generated_field = "8447DACB63472460CDDABE8CDCC76131")

        static final int SAVE_WEBARCHIVE = 147;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.487 -0500", hash_original_field = "03B4FC424B2D29A88EF022243AAF648D", hash_generated_field = "4719F9787C86BD531DDCD3A4F24A0CAD")

        static final int WEBKIT_DRAW_LAYERS = 148;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.490 -0500", hash_original_field = "2616F967C7ED3D6FB72639ADB22ED5DE", hash_generated_field = "259E28E910BDF11B84BC8154A04E9D36")

        static final int REMOVE_JS_INTERFACE = 149;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.492 -0500", hash_original_field = "3518D67664F52EB64F720F3B4030E23D", hash_generated_field = "7ADB3182C36D5725D5320E86C4117FC4")

        static final int CLEAR_SSL_PREF_TABLE = 150;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.494 -0500", hash_original_field = "EF3E7F03BCE8A8B3152EAD5296470DE8", hash_generated_field = "FAEA67345060AE301231EA91BE292569")

        static final int REQUEST_EXT_REPRESENTATION = 160;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.497 -0500", hash_original_field = "6A14B539800E7472CB0BD976A89CE245", hash_generated_field = "3845E0589547315CEE5E0B92DD1AD244")

        static final int REQUEST_DOC_AS_TEXT = 161;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.499 -0500", hash_original_field = "8F250CA82FF3D7DB1DAECF175C57325F", hash_generated_field = "F3C193CFC60CF3C0B322E996C8EB1503")

        static final int DUMP_DOMTREE = 170;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.501 -0500", hash_original_field = "45B929482012A5DA08FD8454B6D1FC7F", hash_generated_field = "B6BF792FD91B42804F05463A409C6712")

        static final int DUMP_RENDERTREE = 171;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.504 -0500", hash_original_field = "5C2655B0B4BB3F7A286A3985448EB87B", hash_generated_field = "FFFF59DB0DBEB41E1610B50BEEFE078B")

        static final int DUMP_NAVTREE = 172;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.507 -0500", hash_original_field = "947B35873617C8B3C2CE7350851ED5BA", hash_generated_field = "22ECFEB4F1D7198CAD9004F3F8182ACA")

        static final int DUMP_V8COUNTERS = 173;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.509 -0500", hash_original_field = "70E0DAA76A394C5D9B753272B52170EF", hash_generated_field = "2CCC2814D3A8DD935BA79DB833CB97A9")

        static final int SET_JS_FLAGS = 174;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.512 -0500", hash_original_field = "F95A5E8E6FFB317A5D284EB278D681BE", hash_generated_field = "770306EE08C5B265C944F26D759A454A")

        static final int CONTENT_INVALIDATE_ALL = 175;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.514 -0500", hash_original_field = "9449E0AC0346058A694F6597E6857FA6", hash_generated_field = "A502B6DA1FCA2647B6641D88EF81A26C")

        static final int GEOLOCATION_PERMISSIONS_PROVIDE = 180;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.517 -0500", hash_original_field = "5E28806AB4C07892E1905563869FC463", hash_generated_field = "4C4316E650B8E2C35AAC2AE6DFC9E0DC")

        static final int POPULATE_VISITED_LINKS = 181;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.519 -0500", hash_original_field = "2DD625EB58DB8E6F3B0051566B1E3EB7", hash_generated_field = "F59323C5749EC8B80626289AC6A6CA41")

        static final int HIDE_FULLSCREEN = 182;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.521 -0500", hash_original_field = "658206FDD2C8D0EC15AE0C9C9549F1A2", hash_generated_field = "4BA27FCDB8E753E9D23C35EEF4250599")

        static final int SET_NETWORK_TYPE = 183;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.523 -0500", hash_original_field = "A3F35D09B727C5734863AB4D0BE2990C", hash_generated_field = "D4353191303A307F8EC0C9FCB23A4601")

        static final int ADD_PACKAGE_NAMES = 184;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.526 -0500", hash_original_field = "B6BD2FE1DF7580F9068EBB49CEA09F9B", hash_generated_field = "CD59BAC9B7F62B4E0EC1CED1448C2ADC")

        static final int ADD_PACKAGE_NAME = 185;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.528 -0500", hash_original_field = "0353B5CEB907A67909791382B86DFC9B", hash_generated_field = "86FD47ED32409C69B4B1C1E88FCF5134")

        static final int REMOVE_PACKAGE_NAME = 186;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.531 -0500", hash_original_field = "60E5D1F5DABCCA0B62FB53E901619BD0", hash_generated_field = "26B47DF07CF581E3990DCB8B8BD0FFD6")

        static final int GET_TOUCH_HIGHLIGHT_RECTS = 187;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.533 -0500", hash_original_field = "A4FBC089158936DFC1AB1EB449198186", hash_generated_field = "EAA3BB9D3322C3641C45C69C1B8BF5A6")

        static final int MODIFY_SELECTION = 190;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.536 -0500", hash_original_field = "6526EDFE6141572F445CDF8050FB7DC1", hash_generated_field = "F6936A0587CAC5B6914A71D88CC55D4B")

        static final int USE_MOCK_DEVICE_ORIENTATION = 191;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.539 -0500", hash_original_field = "6AC2EE17F4C6A252871EA385AF049431", hash_generated_field = "4A8959279B873BDC4AC53CD29E99A969")

        static final int AUTOFILL_FORM = 192;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.541 -0500", hash_original_field = "DDFB1623B5AAA6D71B8A33D5295D34E6", hash_generated_field = "24289CC25342574331262A5EA7A3E9BF")

        static final int PROXY_CHANGED = 193;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.543 -0500", hash_original_field = "98F5D292D9FF72C037AF07AD28D4745A", hash_generated_field = "9156CA0AA536924F355C0ADD1B8E313C")

        static final int EXECUTE_JS = 194;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.545 -0500", hash_original_field = "25EA1884DB07DD201034F27B6963B21E", hash_generated_field = "5D48D0945BB3F832E09CEFB03CEA0D6B")

        static final int PLUGIN_SURFACE_READY = 195;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.547 -0500", hash_original_field = "1EB91AF4710A2B75FD7881CC84DB2939", hash_generated_field = "6F474F4430BE37C7E2D8E37E2EFD176E")

        static final int NOTIFY_ANIMATION_STARTED = 196;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.550 -0500", hash_original_field = "8D5108514893F24EF23664F1BEA41B5F", hash_generated_field = "E60DE11B53705E1D887324E4085A47B6")

        private static final int DESTROY =     200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.569 -0500", hash_original_field = "865CB75660D4DDFE633606A32C880E34", hash_generated_field = "8DAF2FCED2EB50F87603702698DEEC1B")

        private static final int FIRST_PACKAGE_MSG_ID = REVEAL_SELECTION;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.572 -0500", hash_original_field = "414CFC1CEB8F584D61D412260383F347", hash_generated_field = "5F401005531CDDC07655139C4E52E31E")

        private static final int LAST_PACKAGE_MSG_ID = VALID_NODE_BOUNDS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.552 -0500", hash_original_field = "A163099B522120C606A3CA562F90E927", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private Handler mHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.555 -0500", hash_original_field = "974D96B9C21FD81C4B11D5F5CE07F1DD", hash_generated_field = "A2334197C18CF92CD57AF90B5E857267")

        // ready.
        private ArrayList<Message> mMessages = new ArrayList<Message>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.557 -0500", hash_original_field = "A04842ACEBC13FD0591DDEF0D3E0DB43", hash_generated_field = "3199E6F9576C5BBDF32CE2C442568A06")

        // posting more messages to the EventHub or to WebView's event handler.
        private boolean mBlockMessages;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.559 -0500", hash_original_field = "1E87C43FD65330C62AE9E5E23BAF9671", hash_generated_field = "CE8E976EC7A814206E43BF5450153045")

        private boolean mDestroying;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.561 -0500", hash_original_field = "D57DDC1CAC51ACAE199378A02C9E8F89", hash_generated_field = "50324B3C89C6121270D18C08FF8C9860")

        private int mTid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.563 -0500", hash_original_field = "07823A3A72BAD694C46FD78CA6BDEDEE", hash_generated_field = "383517F47AAEBA69DE2808C9066BF35B")

        private int mSavedPriority;

        /**
         * Prevent other classes from creating an EventHub.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.566 -0500", hash_original_method = "E81290CBA9EBCD5546A9E9277FAE0605", hash_generated_method = "D6DBC22AF62AE60BA668A3E35BCCF6DF")
        
private EventHub() {}

        /**
         * Transfer all messages to the newly created webcore thread handler.
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.595 -0500", hash_original_method = "306B3D199EA83A68750A5F32B05C0197", hash_generated_method = "E26C955FC10DA1BC41E0348F453390B7")
        
private void transferMessages() {
            mTid = Process.myTid();
            mSavedPriority = Process.getThreadPriority(mTid);

            mHandler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    if (DebugFlags.WEB_VIEW_CORE) {
                        Log.v(LOGTAG, (msg.what < FIRST_PACKAGE_MSG_ID
                                || msg.what > LAST_PACKAGE_MSG_ID
                                ? Integer.toString(msg.what)
                                : HandlerDebugString[msg.what
                                        - FIRST_PACKAGE_MSG_ID])
                                + " arg1=" + msg.arg1 + " arg2=" + msg.arg2
                                + " obj=" + msg.obj);
                    }
                    if (mWebView == null || mNativeClass == 0) {
                        if (DebugFlags.WEB_VIEW_CORE) {
                            Log.w(LOGTAG, "Rejecting message " + msg.what
                                    + " because we are destroyed");
                        }
                        return;
                    }
                    if (mDestroying == true
                            && msg.what != EventHub.RESUME_TIMERS
                            && msg.what != EventHub.PAUSE_TIMERS
                            && msg.what != EventHub.DESTROY) {
                        if (DebugFlags.WEB_VIEW_CORE) {
                            Log.v(LOGTAG, "Rejecting message " + msg.what
                                    + " because we are being destroyed");
                        }
                        return;
                    }
                    switch (msg.what) {
                        case WEBKIT_DRAW:
                            webkitDraw();
                            break;

                        case WEBKIT_DRAW_LAYERS:
                            webkitDrawLayers();
                            break;

                        case DESTROY:
                            // Time to take down the world. Cancel all pending
                            // loads and destroy the native view and frame.
                            synchronized (WebViewCore.this) {
                                mBrowserFrame.destroy();
                                mBrowserFrame = null;
                                mSettings.onDestroyed();
                                mNativeClass = 0;
                                mWebView = null;
                            }
                            break;

                        case REVEAL_SELECTION:
                            nativeRevealSelection();
                            break;

                        case REQUEST_LABEL:
                            if (mWebView != null) {
                                int nodePointer = msg.arg2;
                                String label = nativeRequestLabel(msg.arg1,
                                        nodePointer);
                                if (label != null && label.length() > 0) {
                                    Message.obtain(mWebView.mPrivateHandler,
                                            WebView.RETURN_LABEL, nodePointer,
                                            0, label).sendToTarget();
                                }
                            }
                            break;

                        case UPDATE_FRAME_CACHE_IF_LOADING:
                            nativeUpdateFrameCacheIfLoading();
                            break;

                        case SCROLL_TEXT_INPUT:
                            float xPercent;
                            if (msg.obj == null) {
                                xPercent = 0f;
                            } else {
                                xPercent = ((Float) msg.obj).floatValue();
                            }
                            nativeScrollFocusedTextInput(xPercent, msg.arg2);
                            break;

                        case LOAD_URL: {
                            CookieManager.getInstance().waitForCookieOperationsToComplete();
                            GetUrlData param = (GetUrlData) msg.obj;
                            loadUrl(param.mUrl, param.mExtraHeaders);
                            break;
                        }

                        case POST_URL: {
                            CookieManager.getInstance().waitForCookieOperationsToComplete();
                            PostUrlData param = (PostUrlData) msg.obj;
                            mBrowserFrame.postUrl(param.mUrl, param.mPostData);
                            break;
                        }
                        case LOAD_DATA:
                            CookieManager.getInstance().waitForCookieOperationsToComplete();
                            BaseUrlData loadParams = (BaseUrlData) msg.obj;
                            String baseUrl = loadParams.mBaseUrl;
                            if (baseUrl != null) {
                                int i = baseUrl.indexOf(':');
                                if (i > 0) {
                                    // In 1.0, WebView.loadDataWithBaseURL() could access local
                                    // asset files using 'file' scheme URLs as long as the data is
                                    // valid. Later versions of WebKit have tightened the
                                    // restriction around when pages can access such local URLs.
                                    // To maintain compatibility with 1.0, we register the scheme of
                                    // the baseUrl to be considered local, as long as it is not
                                    // http(s)/ftp(s)/about/javascript.
                                    String scheme = baseUrl.substring(0, i);
                                    if (!scheme.startsWith("http") &&
                                            !scheme.startsWith("ftp") &&
                                            !scheme.startsWith("about") &&
                                            !scheme.startsWith("javascript")) {
                                        nativeRegisterURLSchemeAsLocal(scheme);
                                    }
                                }
                            }
                            mBrowserFrame.loadData(baseUrl,
                                    loadParams.mData,
                                    loadParams.mMimeType,
                                    loadParams.mEncoding,
                                    loadParams.mHistoryUrl);
                            nativeContentInvalidateAll();
                            break;

                        case STOP_LOADING:
                            // If the WebCore has committed the load, but not
                            // finished the first layout yet, we need to set
                            // first layout done to trigger the interpreted side sync
                            // up with native side
                            if (mBrowserFrame.committed()
                                    && !mBrowserFrame.firstLayoutDone()) {
                                mBrowserFrame.didFirstLayout();
                            }
                            // Do this after syncing up the layout state.
                            stopLoading();
                            break;

                        case RELOAD:
                            mBrowserFrame.reload(false);
                            break;

                        case KEY_DOWN:
                            key((KeyEvent) msg.obj, true);
                            break;

                        case KEY_UP:
                            key((KeyEvent) msg.obj, false);
                            break;

                        case FAKE_CLICK:
                            nativeClick(msg.arg1, msg.arg2, true);
                            break;

                        case CLICK:
                            nativeClick(msg.arg1, msg.arg2, false);
                            break;

                        case VIEW_SIZE_CHANGED: {
                            viewSizeChanged((WebView.ViewSizeData) msg.obj);
                            break;
                        }
                        case SET_SCROLL_OFFSET:
                            // note: these are in document coordinates
                            // (inv-zoom)
                            Point pt = (Point) msg.obj;
                            nativeSetScrollOffset(msg.arg1, msg.arg2 == 1,
                                    pt.x, pt.y);
                            break;

                        case SET_GLOBAL_BOUNDS:
                            Rect r = (Rect) msg.obj;
                            nativeSetGlobalBounds(r.left, r.top, r.width(),
                                r.height());
                            break;

                        case GO_BACK_FORWARD:
                            // If it is a standard load and the load is not
                            // committed yet, we interpret BACK as RELOAD
                            if (!mBrowserFrame.committed() && msg.arg1 == -1 &&
                                    (mBrowserFrame.loadType() ==
                                    BrowserFrame.FRAME_LOADTYPE_STANDARD)) {
                                mBrowserFrame.reload(true);
                            } else {
                                mBrowserFrame.goBackOrForward(msg.arg1);
                            }
                            break;

                        case RESTORE_STATE:
                            stopLoading();
                            restoreState(msg.arg1);
                            break;

                        case PAUSE_TIMERS:
                            mSavedPriority = Process.getThreadPriority(mTid);
                            Process.setThreadPriority(mTid,
                                    Process.THREAD_PRIORITY_BACKGROUND);
                            pauseTimers();
                            if (!JniUtil.useChromiumHttpStack()) {
                                WebViewWorker.getHandler().sendEmptyMessage(
                                        WebViewWorker.MSG_PAUSE_CACHE_TRANSACTION);
                            } else {
                                nativeCloseIdleConnections();
                            }
                            break;

                        case RESUME_TIMERS:
                            Process.setThreadPriority(mTid, mSavedPriority);
                            resumeTimers();
                            if (!JniUtil.useChromiumHttpStack()) {
                                WebViewWorker.getHandler().sendEmptyMessage(
                                        WebViewWorker.MSG_RESUME_CACHE_TRANSACTION);
                            }
                            break;

                        case ON_PAUSE:
                            nativePause();
                            break;

                        case ON_RESUME:
                            nativeResume();
                            break;

                        case FREE_MEMORY:
                            clearCache(false);
                            nativeFreeMemory();
                            break;

                        case SET_NETWORK_STATE:
                            if (BrowserFrame.sJavaBridge == null) {
                                throw new IllegalStateException("No WebView " +
                                        "has been created in this process!");
                            }
                            BrowserFrame.sJavaBridge
                                    .setNetworkOnLine(msg.arg1 == 1);
                            break;

                        case SET_NETWORK_TYPE:
                            if (BrowserFrame.sJavaBridge == null) {
                                throw new IllegalStateException("No WebView " +
                                        "has been created in this process!");
                            }
                            Map<String, String> map = (Map<String, String>) msg.obj;
                            BrowserFrame.sJavaBridge
                                    .setNetworkType(map.get("type"), map.get("subtype"));
                            break;

                        case CLEAR_CACHE:
                            clearCache(msg.arg1 == 1);
                            break;

                        case CLEAR_HISTORY:
                            mCallbackProxy.getBackForwardList().
                                    close(mBrowserFrame.mNativeFrame);
                            break;

                        case REPLACE_TEXT:
                            ReplaceTextData rep = (ReplaceTextData) msg.obj;
                            nativeReplaceTextfieldText(msg.arg1, msg.arg2,
                                    rep.mReplace, rep.mNewStart, rep.mNewEnd,
                                    rep.mTextGeneration);
                            break;

                        case PASS_TO_JS: {
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
                            break;
                        }

                        case SAVE_DOCUMENT_STATE: {
                            CursorData cDat = (CursorData) msg.obj;
                            nativeSaveDocumentState(cDat.mFrame);
                            break;
                        }

                        case CLEAR_SSL_PREF_TABLE:
                            if (JniUtil.useChromiumHttpStack()) {
                                // FIXME: This will not work for connections currently in use, as
                                // they cache the certificate responses. See http://b/5324235.
                                SslCertLookupTable.getInstance().clear();
                                nativeCloseIdleConnections();
                            } else {
                                Network.getInstance(mContext).clearUserSslPrefTable();
                            }
                            break;

                        case TOUCH_UP:
                            TouchUpData touchUpData = (TouchUpData) msg.obj;
                            if (touchUpData.mNativeLayer != 0) {
                                nativeScrollLayer(touchUpData.mNativeLayer,
                                        touchUpData.mNativeLayerRect);
                            }
                            nativeTouchUp(touchUpData.mMoveGeneration,
                                    touchUpData.mFrame, touchUpData.mNode,
                                    touchUpData.mX, touchUpData.mY);
                            break;

                        case TOUCH_EVENT: {
                            TouchEventData ted = (TouchEventData) msg.obj;
                            final int count = ted.mPoints.length;
                            int[] xArray = new int[count];
                            int[] yArray = new int[count];
                            for (int c = 0; c < count; c++) {
                                xArray[c] = ted.mPoints[c].x;
                                yArray[c] = ted.mPoints[c].y;
                            }
                            if (ted.mNativeLayer != 0) {
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
                            break;
                        }

                        case SET_ACTIVE:
                            nativeSetFocusControllerActive(msg.arg1 == 1);
                            break;

                        case ADD_JS_INTERFACE:
                            JSInterfaceData jsData = (JSInterfaceData) msg.obj;
                            mBrowserFrame.addJavascriptInterface(jsData.mObject,
                                    jsData.mInterfaceName);
                            break;

                        case REMOVE_JS_INTERFACE:
                            jsData = (JSInterfaceData) msg.obj;
                            mBrowserFrame.removeJavascriptInterface(
                                    jsData.mInterfaceName);
                            break;

                        case REQUEST_EXT_REPRESENTATION:
                            mBrowserFrame.externalRepresentation(
                                    (Message) msg.obj);
                            break;

                        case REQUEST_DOC_AS_TEXT:
                            mBrowserFrame.documentAsText((Message) msg.obj);
                            break;

                        case SET_MOVE_FOCUS:
                            CursorData focusData = (CursorData) msg.obj;
                            nativeMoveFocus(focusData.mFrame, focusData.mNode);
                            break;

                        case SET_MOVE_MOUSE:
                            CursorData cursorData = (CursorData) msg.obj;
                            nativeMoveMouse(cursorData.mFrame,
                                     cursorData.mX, cursorData.mY);
                            break;

                        case SET_MOVE_MOUSE_IF_LATEST:
                            CursorData cData = (CursorData) msg.obj;
                            nativeMoveMouseIfLatest(cData.mMoveGeneration,
                                    cData.mFrame,
                                    cData.mX, cData.mY);
                            if (msg.arg1 == 1) {
                                nativeStopPaintingCaret();
                            }
                            break;

                        case REQUEST_CURSOR_HREF: {
                            Message hrefMsg = (Message) msg.obj;
                            hrefMsg.getData().putString("url",
                                    nativeRetrieveHref(msg.arg1, msg.arg2));
                            hrefMsg.getData().putString("title",
                                    nativeRetrieveAnchorText(msg.arg1, msg.arg2));
                            hrefMsg.getData().putString("src",
                                    nativeRetrieveImageSource(msg.arg1, msg.arg2));
                            hrefMsg.sendToTarget();
                            break;
                        }

                        case UPDATE_CACHE_AND_TEXT_ENTRY:
                            nativeUpdateFrameCache();
                            // FIXME: this should provide a minimal rectangle
                            if (mWebView != null) {
                                mWebView.postInvalidate();
                            }
                            sendUpdateTextEntry();
                            break;

                        case DOC_HAS_IMAGES:
                            Message imageResult = (Message) msg.obj;
                            imageResult.arg1 =
                                    mBrowserFrame.documentHasImages() ? 1 : 0;
                            imageResult.sendToTarget();
                            break;

                        case DELETE_SELECTION:
                            TextSelectionData deleteSelectionData
                                    = (TextSelectionData) msg.obj;
                            nativeDeleteSelection(deleteSelectionData.mStart,
                                    deleteSelectionData.mEnd, msg.arg1);
                            break;

                        case SET_SELECTION:
                            nativeSetSelection(msg.arg1, msg.arg2);
                            break;

                        case MODIFY_SELECTION:
                            String modifiedSelectionString = nativeModifySelection(msg.arg1,
                                    msg.arg2);
                            mWebView.mPrivateHandler.obtainMessage(WebView.SELECTION_STRING_CHANGED,
                                    modifiedSelectionString).sendToTarget();
                            break;

                        case LISTBOX_CHOICES:
                            SparseBooleanArray choices = (SparseBooleanArray)
                                    msg.obj;
                            int choicesSize = msg.arg1;
                            boolean[] choicesArray = new boolean[choicesSize];
                            for (int c = 0; c < choicesSize; c++) {
                                choicesArray[c] = choices.get(c);
                            }
                            nativeSendListBoxChoices(choicesArray,
                                    choicesSize);
                            break;

                        case SINGLE_LISTBOX_CHOICE:
                            nativeSendListBoxChoice(msg.arg1);
                            break;

                        case SET_BACKGROUND_COLOR:
                            nativeSetBackgroundColor(msg.arg1);
                            break;

                        case DUMP_DOMTREE:
                            nativeDumpDomTree(msg.arg1 == 1);
                            break;

                        case DUMP_RENDERTREE:
                            nativeDumpRenderTree(msg.arg1 == 1);
                            break;

                        case DUMP_NAVTREE:
                            nativeDumpNavTree();
                            break;

                        case DUMP_V8COUNTERS:
                            nativeDumpV8Counters();
                            break;

                        case SET_JS_FLAGS:
                            nativeSetJsFlags((String)msg.obj);
                            break;

                        case CONTENT_INVALIDATE_ALL:
                            nativeContentInvalidateAll();
                            break;

                        case SAVE_WEBARCHIVE:
                            WebView.SaveWebArchiveMessage saveMessage =
                                (WebView.SaveWebArchiveMessage)msg.obj;
                            saveMessage.mResultFile =
                                saveWebArchive(saveMessage.mBasename, saveMessage.mAutoname);
                            mWebView.mPrivateHandler.obtainMessage(
                                WebView.SAVE_WEBARCHIVE_FINISHED, saveMessage).sendToTarget();
                            break;

                        case GEOLOCATION_PERMISSIONS_PROVIDE:
                            GeolocationPermissionsData data =
                                    (GeolocationPermissionsData) msg.obj;
                            nativeGeolocationPermissionsProvide(data.mOrigin,
                                    data.mAllow, data.mRemember);
                            break;

                        case SPLIT_PICTURE_SET:
                            nativeSplitContent(msg.arg1);
                            mWebView.mPrivateHandler.obtainMessage(
                                    WebView.REPLACE_BASE_CONTENT, msg.arg1, 0);
                            mSplitPictureIsScheduled = false;
                            break;

                        case CLEAR_CONTENT:
                            // Clear the view so that onDraw() will draw nothing
                            // but white background
                            // (See public method WebView.clearView)
                            nativeClearContent();
                            break;

                        case MESSAGE_RELAY:
                            ((Message) msg.obj).sendToTarget();
                            break;

                        case POPULATE_VISITED_LINKS:
                            nativeProvideVisitedHistory((String[])msg.obj);
                            break;

                        case VALID_NODE_BOUNDS: {
                            MotionUpData motionUpData = (MotionUpData) msg.obj;
                            if (!nativeValidNodeAndBounds(
                                    motionUpData.mFrame, motionUpData.mNode,
                                    motionUpData.mBounds)) {
                                nativeUpdateFrameCache();
                            }
                            Message message = mWebView.mPrivateHandler
                                    .obtainMessage(WebView.DO_MOTION_UP,
                                    motionUpData.mX, motionUpData.mY);
                            mWebView.mPrivateHandler.sendMessageAtFrontOfQueue(
                                    message);
                            break;
                        }

                        case HIDE_FULLSCREEN:
                            nativeFullScreenPluginHidden(msg.arg1);
                            break;

                        case PLUGIN_SURFACE_READY:
                            nativePluginSurfaceReady();
                            break;

                        case NOTIFY_ANIMATION_STARTED:
                            nativeNotifyAnimationStarted(mNativeClass);
                            break;

                        case ADD_PACKAGE_NAMES:
                            if (BrowserFrame.sJavaBridge == null) {
                                throw new IllegalStateException("No WebView " +
                                        "has been created in this process!");
                            }
                            BrowserFrame.sJavaBridge.addPackageNames(
                                    (Set<String>) msg.obj);
                            break;

                        case GET_TOUCH_HIGHLIGHT_RECTS:
                            TouchHighlightData d = (TouchHighlightData) msg.obj;
                            if (d.mNativeLayer != 0) {
                                nativeScrollLayer(d.mNativeLayer,
                                        d.mNativeLayerRect);
                            }
                            ArrayList<Rect> rects = nativeGetTouchHighlightRects
                                    (d.mX, d.mY, d.mSlop);
                            mWebView.mPrivateHandler.obtainMessage(
                                    WebView.SET_TOUCH_HIGHLIGHT_RECTS, rects)
                                    .sendToTarget();
                            break;

                        case USE_MOCK_DEVICE_ORIENTATION:
                            useMockDeviceOrientation();
                            break;

                        case AUTOFILL_FORM:
                            nativeAutoFillForm(msg.arg1);
                            mWebView.mPrivateHandler.obtainMessage(WebView.AUTOFILL_COMPLETE, null)
                                    .sendToTarget();
                            break;

                        case EXECUTE_JS:
                            if (msg.obj instanceof String) {
                                if (DebugFlags.WEB_VIEW_CORE) {
                                    Log.d(LOGTAG, "Executing JS : " + msg.obj);
                                }
                                mBrowserFrame.stringByEvaluatingJavaScriptFromString((String) msg.obj);
                            }
                            break;
                    }
                }
            };
            // Take all queued messages and resend them to the new handler.
            synchronized (this) {
                int size = mMessages.size();
                for (int i = 0; i < size; i++) {
                    mHandler.sendMessage(mMessages.get(i));
                }
                mMessages = null;
            }
        }

        /**
         * Send a message internally to the queue or to the handler
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.599 -0500", hash_original_method = "A3F2FAE5568048D2CF4F883B9C3D720D", hash_generated_method = "B862C7BADFD4FD07162D5B768643F727")
        
private synchronized void sendMessage(Message msg) {
            if (mBlockMessages) {
                return;
            }
            if (mMessages != null) {
                mMessages.add(msg);
            } else {
                mHandler.sendMessage(msg);
            }
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.602 -0500", hash_original_method = "2D760BF01DEDB25033C3CD5EE0C5DC00", hash_generated_method = "1302C222F3CECE0807F33B7908330E6A")
        
private synchronized void removeMessages(int what) {
            if (mBlockMessages) {
                return;
            }
            if (what == EventHub.WEBKIT_DRAW) {
                mDrawIsScheduled = false;
            }
            if (mMessages != null) {
                Throwable throwable = new Throwable(
                        "EventHub.removeMessages(int what = " + what + ") is not supported " +
                        "before the WebViewCore is set up.");
                Log.w(LOGTAG, Log.getStackTraceString(throwable));
            } else {
                mHandler.removeMessages(what);
            }
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.604 -0500", hash_original_method = "8649C68E7EFBE767B713B2AB196A4693", hash_generated_method = "3FB8F5B24BA784B1771AEF88EC850970")
        
private synchronized void sendMessageDelayed(Message msg, long delay) {
            if (mBlockMessages) {
                return;
            }
            mHandler.sendMessageDelayed(msg, delay);
        }

        /**
         * Send a message internally to the front of the queue.
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.607 -0500", hash_original_method = "D0F21E4A05814ED295A9D395C58D6229", hash_generated_method = "54241B07FD1B5E036235ECB3CFF82126")
        
private synchronized void sendMessageAtFrontOfQueue(Message msg) {
            if (mBlockMessages) {
                return;
            }
            if (mMessages != null) {
                mMessages.add(0, msg);
            } else {
                mHandler.sendMessageAtFrontOfQueue(msg);
            }
        }

        /**
         * Remove all the messages.
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.609 -0500", hash_original_method = "2D908156D971A0132EC1B636390B02E6", hash_generated_method = "F1602DC1FC34332C43F6C2E8DA85564E")
        
private synchronized void removeMessages() {
            // reset mDrawIsScheduled flag as WEBKIT_DRAW may be removed
            mDrawIsScheduled = false;
            mSplitPictureIsScheduled = false;
            if (mMessages != null) {
                mMessages.clear();
            } else {
                mHandler.removeCallbacksAndMessages(null);
            }
        }

        /**
         * Block sending messages to the EventHub.
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.611 -0500", hash_original_method = "7F4FC3BA20FD4185DE24EC53F9CE84DB", hash_generated_method = "8FFE92A71082343259180CD0F83727B9")
        
private synchronized void blockMessages() {
            mBlockMessages = true;
        }
    }
    
    static class ViewState {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.694 -0500", hash_original_field = "B32B05E9B06961C068146DEC621EAC96", hash_generated_field = "B32B05E9B06961C068146DEC621EAC96")

        float mMinScale;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.696 -0500", hash_original_field = "F1991B21BE4FD345C3E31239E4A9D26B", hash_generated_field = "F1991B21BE4FD345C3E31239E4A9D26B")

        float mMaxScale;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.698 -0500", hash_original_field = "92D32B7B49710A45199D181A0A3F6CDD", hash_generated_field = "92D32B7B49710A45199D181A0A3F6CDD")

        float mViewScale;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.700 -0500", hash_original_field = "B2BB1FC05073BD7B5469AA68A14F4A2A", hash_generated_field = "B2BB1FC05073BD7B5469AA68A14F4A2A")

        float mTextWrapScale;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.703 -0500", hash_original_field = "1BF737CEB256195165CA6AA7F00EB0A0", hash_generated_field = "1BF737CEB256195165CA6AA7F00EB0A0")

        float mDefaultScale;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.704 -0500", hash_original_field = "E9A45ED540F0B589A497E7AFE99EBA3D", hash_generated_field = "E9A45ED540F0B589A497E7AFE99EBA3D")

        int mScrollX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.707 -0500", hash_original_field = "EC6AD52CC705AA3985B25CDB13E68426", hash_generated_field = "EC6AD52CC705AA3985B25CDB13E68426")

        int mScrollY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.708 -0500", hash_original_field = "E2715834245B310B1EDEFB5A5E46DC19", hash_generated_field = "E2715834245B310B1EDEFB5A5E46DC19")

        boolean mMobileSite;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.710 -0500", hash_original_field = "DCF6E9F007CD0B21908BEEB85CA9A358", hash_generated_field = "DCF6E9F007CD0B21908BEEB85CA9A358")

        boolean mIsRestored;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.712 -0500", hash_original_field = "F0A7C1C015045A534AFE2405942522D1", hash_generated_field = "F0A7C1C015045A534AFE2405942522D1")

        boolean mShouldStartScrolledRight;
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.255 -0400", hash_original_method = "FF705DB5257E6CA3790C30389112B4B7", hash_generated_method = "FF705DB5257E6CA3790C30389112B4B7")
        public ViewState ()
        {
            //Synthesized constructor
        }

    }
    
    static class DrawData {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.720 -0500", hash_original_field = "73A6CF6AB924FFDDE75286128636047A", hash_generated_field = "73A6CF6AB924FFDDE75286128636047A")

        int mBaseLayer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.722 -0500", hash_original_field = "E790C094D998A1C09371E07D548282F9", hash_generated_field = "E790C094D998A1C09371E07D548282F9")

        Region mInvalRegion;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.724 -0500", hash_original_field = "E793ED455F3C00CD9A5CDD84292C7637", hash_generated_field = "E793ED455F3C00CD9A5CDD84292C7637")

        Point mViewSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.726 -0500", hash_original_field = "3C549D54CC067790E94520D8AD1FA542", hash_generated_field = "3C549D54CC067790E94520D8AD1FA542")

        Point mContentSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.728 -0500", hash_original_field = "050B6649CE7A7C5E58ADF2EC10BD7076", hash_generated_field = "050B6649CE7A7C5E58ADF2EC10BD7076")

        int mMinPrefWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.730 -0500", hash_original_field = "6833E897B71269A6061BC9758C2D0546", hash_generated_field = "6833E897B71269A6061BC9758C2D0546")

        ViewState mViewState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.732 -0500", hash_original_field = "27B1CFFB12B3E61CF3D315C9C963BA4A", hash_generated_field = "27B1CFFB12B3E61CF3D315C9C963BA4A")

        boolean mFirstLayoutForNonStandardLoad;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.735 -0500", hash_original_field = "30C90FD55CE7043C6521FC20BFE142EE", hash_generated_field = "30C90FD55CE7043C6521FC20BFE142EE")

        boolean mFocusSizeChanged;
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.718 -0500", hash_original_method = "0A5C1715167608A1FCEB50646E4B5581", hash_generated_method = "0A5C1715167608A1FCEB50646E4B5581")
        
DrawData() {
            mBaseLayer = 0;
            mInvalRegion = new Region();
            mContentSize = new Point();
        }
        
    }
    
    static class ShowRectData {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.866 -0500", hash_original_field = "9CA1F6E0E5F07E62C54326FC8CE74F9B", hash_generated_field = "9CA1F6E0E5F07E62C54326FC8CE74F9B")

        int mLeft;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.868 -0500", hash_original_field = "A99CCC9E9A86D41F2B4D997ACBCFA99E", hash_generated_field = "A99CCC9E9A86D41F2B4D997ACBCFA99E")

        int mTop;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.870 -0500", hash_original_field = "AF6410B200BC05DCA2CF0BE65165448A", hash_generated_field = "AF6410B200BC05DCA2CF0BE65165448A")

        int mWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.872 -0500", hash_original_field = "7DDAE255893B528E7BEBEC203BC2D9F3", hash_generated_field = "7DDAE255893B528E7BEBEC203BC2D9F3")

        int mHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.875 -0500", hash_original_field = "E53904AD377D72960D8A5847D00D2A72", hash_generated_field = "E53904AD377D72960D8A5847D00D2A72")

        int mContentWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.877 -0500", hash_original_field = "6909FC61CEAFC4290968B35F30281B2B", hash_generated_field = "6909FC61CEAFC4290968B35F30281B2B")

        int mContentHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.879 -0500", hash_original_field = "9541CF04A8FA15E14BA5558D031AB38E", hash_generated_field = "9541CF04A8FA15E14BA5558D031AB38E")

        float mXPercentInDoc;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.882 -0500", hash_original_field = "29D6FC802D779E2A67410E8D69C39C22", hash_generated_field = "29D6FC802D779E2A67410E8D69C39C22")

        float mXPercentInView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.884 -0500", hash_original_field = "687FFE76DBA3D2C22AFDA5A43C9D0215", hash_generated_field = "687FFE76DBA3D2C22AFDA5A43C9D0215")

        float mYPercentInDoc;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.886 -0500", hash_original_field = "DDCBD14F4A5E533655283E96B0B12B22", hash_generated_field = "DDCBD14F4A5E533655283E96B0B12B22")

        float mYPercentInView;
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.256 -0400", hash_original_method = "C48E9140E1D319035D16E0B3D36DB69D", hash_generated_method = "C48E9140E1D319035D16E0B3D36DB69D")
        public ShowRectData ()
        {
            //Synthesized constructor
        }

    }
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.919 -0500", hash_original_method = "46A442C7F1DFFCFE217C12A7C725FDF0", hash_generated_method = "3B41AEA8849330AC1C8EBC4B54FBB98D")
    
    private void nativeFreeMemory(){
    	//Formerly a native method
    }

    static {
        try {
            System.loadLibrary("webcore");
            System.loadLibrary("chromium_net");
        } catch (UnsatisfiedLinkError e) {
            Log.e(LOGTAG, "Unable to load native support libraries.");
        }
    }
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.923 -0500", hash_original_method = "595EFBC436CD527B994A288C2556204C", hash_generated_method = "597D331C649E14FA0EEA7F35386964A5")
    
    private void nativeFullScreenPluginHidden(int npp){
    	//Formerly a native method
    	addTaint(npp);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.927 -0500", hash_original_method = "B8577828D04FDB03A48BAD0D20ECEC58", hash_generated_method = "D3E8B67AF5353729BE7BCD2EA19B4EEA")
    
    private void nativePluginSurfaceReady(){
    	//Formerly a native method
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.930 -0500", hash_original_method = "47AF89A6298D2CD312EEA7CB7B014D43", hash_generated_method = "29186335A2C2813A0D3A5BB723C4FB7F")
    
    private boolean nativeValidNodeAndBounds(int frame, int node,
                Rect bounds){
    	//Formerly a native method
    	addTaint(frame);
    	addTaint(node);
    	addTaint(bounds.getTaint());
    	return getTaintBoolean();
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.725 -0400", hash_original_method = "7FB813C3814F61AA4E8EC557BEB4DCCC", hash_generated_method = "6B922F36DFF8369A6FE3889E21482C11")
    private ArrayList<Rect> nativeGetTouchHighlightRects(int x, int y,
            int slop) {
    	ArrayList<Rect> ret = new ArrayList<>();
    	ret.addTaint(getTaint());
    	return ret;
    }

   @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.937 -0500", hash_original_method = "6E4751AAEDBCF283C9D69028D1EFBC56", hash_generated_method = "A6823C2DD8F84E1387E92F95C90C9334")
    
    private void nativeAutoFillForm(int queryId){
    	//Formerly a native method
    	addTaint(queryId);
    }

   @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:07.941 -0500", hash_original_method = "17FE9397F3DCB5CE24853C5F0983B585", hash_generated_method = "CFC8789408919FE65212AF58020E8588")
    
    private void nativeScrollLayer(int layer, Rect rect){
    	//Formerly a native method
    	addTaint(layer);
    	addTaint(rect.getTaint());
    }

}

