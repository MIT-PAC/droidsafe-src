package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.app.AppGlobals;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.RemoteException;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.SparseArray;

public class ViewConfiguration {
    private int mEdgeSlop;
    private int mFadingEdgeLength;
    private int mMinimumFlingVelocity;
    private int mMaximumFlingVelocity;
    private int mScrollbarSize;
    private int mTouchSlop;
    private int mPagingTouchSlop;
    private int mDoubleTapSlop;
    private int mScaledTouchExplorationTapSlop;
    private int mWindowTouchSlop;
    private int mMaximumDrawingCacheSize;
    private int mOverscrollDistance;
    private int mOverflingDistance;
    private boolean mFadingMarqueeEnabled;
    private boolean sHasPermanentMenuKey;
    private boolean sHasPermanentMenuKeySet;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.218 -0400", hash_original_method = "24918D20351FE8A86EAEEE2EEBA5EB08", hash_generated_method = "7CA80E922DDAD3CE631F67B3475B9CFA")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public ViewConfiguration() {
        mEdgeSlop = EDGE_SLOP;
        mFadingEdgeLength = FADING_EDGE_LENGTH;
        mMinimumFlingVelocity = MINIMUM_FLING_VELOCITY;
        mMaximumFlingVelocity = MAXIMUM_FLING_VELOCITY;
        mScrollbarSize = SCROLL_BAR_SIZE;
        mTouchSlop = TOUCH_SLOP;
        mPagingTouchSlop = PAGING_TOUCH_SLOP;
        mDoubleTapSlop = DOUBLE_TAP_SLOP;
        mScaledTouchExplorationTapSlop = TOUCH_EXPLORATION_TAP_SLOP;
        mWindowTouchSlop = WINDOW_TOUCH_SLOP;
        mMaximumDrawingCacheSize = MAXIMUM_DRAWING_CACHE_SIZE;
        mOverscrollDistance = OVERSCROLL_DISTANCE;
        mOverflingDistance = OVERFLING_DISTANCE;
        mFadingMarqueeEnabled = true;
        // ---------- Original Method ----------
        //mEdgeSlop = EDGE_SLOP;
        //mFadingEdgeLength = FADING_EDGE_LENGTH;
        //mMinimumFlingVelocity = MINIMUM_FLING_VELOCITY;
        //mMaximumFlingVelocity = MAXIMUM_FLING_VELOCITY;
        //mScrollbarSize = SCROLL_BAR_SIZE;
        //mTouchSlop = TOUCH_SLOP;
        //mPagingTouchSlop = PAGING_TOUCH_SLOP;
        //mDoubleTapSlop = DOUBLE_TAP_SLOP;
        //mScaledTouchExplorationTapSlop = TOUCH_EXPLORATION_TAP_SLOP;
        //mWindowTouchSlop = WINDOW_TOUCH_SLOP;
        //mMaximumDrawingCacheSize = MAXIMUM_DRAWING_CACHE_SIZE;
        //mOverscrollDistance = OVERSCROLL_DISTANCE;
        //mOverflingDistance = OVERFLING_DISTANCE;
        //mFadingMarqueeEnabled = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.219 -0400", hash_original_method = "815441BD896E00C6B865EAF3CE23B912", hash_generated_method = "C192F37132F8120F48B1DEDEB8ED1501")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ViewConfiguration(Context context) {
        dsTaint.addTaint(context.dsTaint);
        Resources res;
        res = context.getResources();
        DisplayMetrics metrics;
        metrics = res.getDisplayMetrics();
        Configuration config;
        config = res.getConfiguration();
        float density;
        density = metrics.density;
        float sizeAndDensity;
        {
            boolean var671BB1C47693047493CD39622A896334_1905938589 = (config.isLayoutSizeAtLeast(Configuration.SCREENLAYOUT_SIZE_XLARGE));
            {
                sizeAndDensity = density * 1.5f;
            } //End block
            {
                sizeAndDensity = density;
            } //End block
        } //End collapsed parenthetic
        mEdgeSlop = (int) (sizeAndDensity * EDGE_SLOP + 0.5f);
        mFadingEdgeLength = (int) (sizeAndDensity * FADING_EDGE_LENGTH + 0.5f);
        mMinimumFlingVelocity = (int) (density * MINIMUM_FLING_VELOCITY + 0.5f);
        mMaximumFlingVelocity = (int) (density * MAXIMUM_FLING_VELOCITY + 0.5f);
        mScrollbarSize = (int) (density * SCROLL_BAR_SIZE + 0.5f);
        mDoubleTapSlop = (int) (sizeAndDensity * DOUBLE_TAP_SLOP + 0.5f);
        mScaledTouchExplorationTapSlop = (int) (density * TOUCH_EXPLORATION_TAP_SLOP + 0.5f);
        mWindowTouchSlop = (int) (sizeAndDensity * WINDOW_TOUCH_SLOP + 0.5f);
        mMaximumDrawingCacheSize = 4 * metrics.widthPixels * metrics.heightPixels;
        mOverscrollDistance = (int) (sizeAndDensity * OVERSCROLL_DISTANCE + 0.5f);
        mOverflingDistance = (int) (sizeAndDensity * OVERFLING_DISTANCE + 0.5f);
        {
            IWindowManager wm;
            wm = Display.getWindowManager();
            try 
            {
                sHasPermanentMenuKey = wm.canStatusBarHide() && !wm.hasNavigationBar();
                sHasPermanentMenuKeySet = true;
            } //End block
            catch (RemoteException ex)
            {
                sHasPermanentMenuKey = false;
            } //End block
        } //End block
        mFadingMarqueeEnabled = res.getBoolean(
                com.android.internal.R.bool.config_ui_enableFadingMarquee);
        mTouchSlop = res.getDimensionPixelSize(
                com.android.internal.R.dimen.config_viewConfigurationTouchSlop);
        mPagingTouchSlop = mTouchSlop * 2;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        public static ViewConfiguration get(Context context) {
        final DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        final int density = (int) (100.0f * metrics.density);
        ViewConfiguration configuration = sConfigurations.get(density);
        if (configuration == null) {
            configuration = new ViewConfiguration(context);
            sConfigurations.put(density, configuration);
        }
        return configuration;
    }

    
        @Deprecated
    public static int getScrollBarSize() {
        return SCROLL_BAR_SIZE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.220 -0400", hash_original_method = "64B2CB77402813F2D85B7730CCF96AEF", hash_generated_method = "AAC54540959B0C6C7E00E4BC2776CE49")
    @DSModeled(DSC.SAFE)
    public int getScaledScrollBarSize() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mScrollbarSize;
    }

    
        public static int getScrollBarFadeDuration() {
        return SCROLL_BAR_FADE_DURATION;
    }

    
        public static int getScrollDefaultDelay() {
        return SCROLL_BAR_DEFAULT_DELAY;
    }

    
        @Deprecated
    public static int getFadingEdgeLength() {
        return FADING_EDGE_LENGTH;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.220 -0400", hash_original_method = "DBA79B5462EB99E7DC2C8AF68ED4F8B2", hash_generated_method = "367954B9CE6A588C25429E66164940B1")
    @DSModeled(DSC.SAFE)
    public int getScaledFadingEdgeLength() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mFadingEdgeLength;
    }

    
        public static int getPressedStateDuration() {
        return PRESSED_STATE_DURATION;
    }

    
        public static int getLongPressTimeout() {
        return AppGlobals.getIntCoreSetting(Settings.Secure.LONG_PRESS_TIMEOUT,
                DEFAULT_LONG_PRESS_TIMEOUT);
    }

    
        public static int getKeyRepeatTimeout() {
        return getLongPressTimeout();
    }

    
        public static int getKeyRepeatDelay() {
        return KEY_REPEAT_DELAY;
    }

    
        public static int getTapTimeout() {
        return TAP_TIMEOUT;
    }

    
        public static int getJumpTapTimeout() {
        return JUMP_TAP_TIMEOUT;
    }

    
        public static int getDoubleTapTimeout() {
        return DOUBLE_TAP_TIMEOUT;
    }

    
        public static int getHoverTapTimeout() {
        return HOVER_TAP_TIMEOUT;
    }

    
        public static int getHoverTapSlop() {
        return HOVER_TAP_SLOP;
    }

    
        @Deprecated
    public static int getEdgeSlop() {
        return EDGE_SLOP;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.222 -0400", hash_original_method = "26568609E943FB4B92788BE90A3C6865", hash_generated_method = "BDF2795E102F4DCC63A0D8FD2EEEA770")
    @DSModeled(DSC.SAFE)
    public int getScaledEdgeSlop() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mEdgeSlop;
    }

    
        @Deprecated
    public static int getTouchSlop() {
        return TOUCH_SLOP;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.222 -0400", hash_original_method = "60BD37725F7CBB3A1C18E0C12D7EC92F", hash_generated_method = "BD1FD4E50B26A8E9944FA0307C2D8178")
    @DSModeled(DSC.SAFE)
    public int getScaledTouchSlop() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mTouchSlop;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.222 -0400", hash_original_method = "4AE776F4126E41D66D9D9E5C3DD06CAD", hash_generated_method = "606877E269B18DBD1D7DC24BA41B8161")
    @DSModeled(DSC.SAFE)
    public int getScaledPagingTouchSlop() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mPagingTouchSlop;
    }

    
        @Deprecated
    public static int getDoubleTapSlop() {
        return DOUBLE_TAP_SLOP;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.222 -0400", hash_original_method = "6B30BD1A6859DBFC35C31996D22D0A66", hash_generated_method = "034A4FD19F86BB024B2CED0A5FC0E1E1")
    @DSModeled(DSC.SAFE)
    public int getScaledDoubleTapSlop() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mDoubleTapSlop;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.223 -0400", hash_original_method = "B7560D2EBF5FE44925FF9E0F817886D6", hash_generated_method = "0BE3B355C3B9D79BF2713B74027128E8")
    @DSModeled(DSC.SAFE)
    public int getScaledTouchExplorationTapSlop() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mScaledTouchExplorationTapSlop;
    }

    
        public static long getSendRecurringAccessibilityEventsInterval() {
        return SEND_RECURRING_ACCESSIBILITY_EVENTS_INTERVAL_MILLIS;
    }

    
        @Deprecated
    public static int getWindowTouchSlop() {
        return WINDOW_TOUCH_SLOP;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.223 -0400", hash_original_method = "C43D675F470050DADBFF4CBA809EB35A", hash_generated_method = "AFDD4DEFD16FD8B5E622437D5A3E494B")
    @DSModeled(DSC.SAFE)
    public int getScaledWindowTouchSlop() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mWindowTouchSlop;
    }

    
        @Deprecated
    public static int getMinimumFlingVelocity() {
        return MINIMUM_FLING_VELOCITY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.223 -0400", hash_original_method = "0486ED6F0D874BB9D1C234D99788A23A", hash_generated_method = "D791B1CF6FCC97B30D09906ADEF60404")
    @DSModeled(DSC.SAFE)
    public int getScaledMinimumFlingVelocity() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mMinimumFlingVelocity;
    }

    
        @Deprecated
    public static int getMaximumFlingVelocity() {
        return MAXIMUM_FLING_VELOCITY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.223 -0400", hash_original_method = "FB70B19A53E289FD25C6D1F0C8994CAD", hash_generated_method = "AF07F689FDD3BC877C39FE535025C683")
    @DSModeled(DSC.SAFE)
    public int getScaledMaximumFlingVelocity() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mMaximumFlingVelocity;
    }

    
        @Deprecated
    public static int getMaximumDrawingCacheSize() {
        return MAXIMUM_DRAWING_CACHE_SIZE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.224 -0400", hash_original_method = "C4F1814F49D0F58AC601C99A9F6FDB3F", hash_generated_method = "44C968D939F1BB99CD7B10A5C0645BF3")
    @DSModeled(DSC.SAFE)
    public int getScaledMaximumDrawingCacheSize() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mMaximumDrawingCacheSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.224 -0400", hash_original_method = "36377B5ABE3B6C0802B86BCCF5BB67A1", hash_generated_method = "B1CAE4085E8F87241A315A0325E5DDD6")
    @DSModeled(DSC.SAFE)
    public int getScaledOverscrollDistance() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mOverscrollDistance;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.224 -0400", hash_original_method = "1172E195811EBBA2C8358246D6F16FAF", hash_generated_method = "79043AECED058E187013D9FA20DA0646")
    @DSModeled(DSC.SAFE)
    public int getScaledOverflingDistance() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mOverflingDistance;
    }

    
        public static long getZoomControlsTimeout() {
        return ZOOM_CONTROLS_TIMEOUT;
    }

    
        public static long getGlobalActionKeyTimeout() {
        return GLOBAL_ACTIONS_KEY_TIMEOUT;
    }

    
        public static float getScrollFriction() {
        return SCROLL_FRICTION;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.225 -0400", hash_original_method = "545A02CAD62F49742EF9C21476AFC78D", hash_generated_method = "5CBFA8E8C1A467F3D10DB31ECD4D918B")
    @DSModeled(DSC.SAFE)
    public boolean hasPermanentMenuKey() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sHasPermanentMenuKey;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.225 -0400", hash_original_method = "B98AC48BC285AD77A873792B80842BAD", hash_generated_method = "F0E29BD22270E065C39C6E3E50B26D8A")
    @DSModeled(DSC.SAFE)
    public boolean isFadingMarqueeEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mFadingMarqueeEnabled;
    }

    
    public static final float PANEL_BIT_DEPTH = 24;
    public static final float ALPHA_THRESHOLD = 0.5f / PANEL_BIT_DEPTH;
    public static final float ALPHA_THRESHOLD_INT = 0x7f / PANEL_BIT_DEPTH;
    private static final int SCROLL_BAR_SIZE = 10;
    private static final int SCROLL_BAR_FADE_DURATION = 250;
    private static final int SCROLL_BAR_DEFAULT_DELAY = 300;
    private static final int FADING_EDGE_LENGTH = 12;
    private static final int PRESSED_STATE_DURATION = 125;
    private static final int DEFAULT_LONG_PRESS_TIMEOUT = 500;
    private static final int KEY_REPEAT_DELAY = 50;
    private static final int GLOBAL_ACTIONS_KEY_TIMEOUT = 500;
    private static final int TAP_TIMEOUT = 180;
    private static final int JUMP_TAP_TIMEOUT = 500;
    private static final int DOUBLE_TAP_TIMEOUT = 300;
    private static final int HOVER_TAP_TIMEOUT = 150;
    private static final int HOVER_TAP_SLOP = 20;
    private static final int ZOOM_CONTROLS_TIMEOUT = 3000;
    private static final int EDGE_SLOP = 12;
    private static final int TOUCH_SLOP = 8;
    private static final int PAGING_TOUCH_SLOP = TOUCH_SLOP * 2;
    private static final int DOUBLE_TAP_SLOP = 100;
    private static final int WINDOW_TOUCH_SLOP = 16;
    private static final int MINIMUM_FLING_VELOCITY = 50;
    private static final int MAXIMUM_FLING_VELOCITY = 8000;
    private static final int TOUCH_EXPLORATION_TAP_SLOP = 80;
    private static final long SEND_RECURRING_ACCESSIBILITY_EVENTS_INTERVAL_MILLIS = 400;
    @Deprecated private static final int MAXIMUM_DRAWING_CACHE_SIZE = 480 * 800 * 4;
    private static final float SCROLL_FRICTION = 0.015f;
    private static final int OVERSCROLL_DISTANCE = 0;
    private static final int OVERFLING_DISTANCE = 6;
    static final SparseArray<ViewConfiguration> sConfigurations =
            new SparseArray<ViewConfiguration>(2);
}

