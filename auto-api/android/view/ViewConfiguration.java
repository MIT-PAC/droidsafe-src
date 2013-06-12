package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    @Deprecated
    private static final int MAXIMUM_DRAWING_CACHE_SIZE = 480 * 800 * 4;
    private static final float SCROLL_FRICTION = 0.015f;
    private static final int OVERSCROLL_DISTANCE = 0;
    private static final int OVERFLING_DISTANCE = 6;
    private final int mEdgeSlop;
    private final int mFadingEdgeLength;
    private final int mMinimumFlingVelocity;
    private final int mMaximumFlingVelocity;
    private final int mScrollbarSize;
    private final int mTouchSlop;
    private final int mPagingTouchSlop;
    private final int mDoubleTapSlop;
    private final int mScaledTouchExplorationTapSlop;
    private final int mWindowTouchSlop;
    private final int mMaximumDrawingCacheSize;
    private final int mOverscrollDistance;
    private final int mOverflingDistance;
    private final boolean mFadingMarqueeEnabled;
    private boolean sHasPermanentMenuKey;
    private boolean sHasPermanentMenuKeySet;
    static final SparseArray<ViewConfiguration> sConfigurations =
            new SparseArray<ViewConfiguration>(2);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.048 -0400", hash_original_method = "24918D20351FE8A86EAEEE2EEBA5EB08", hash_generated_method = "9F7D23BF59538510BEE965CF2B0E6EFE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.049 -0400", hash_original_method = "815441BD896E00C6B865EAF3CE23B912", hash_generated_method = "7812FD315B63FED55EFB04BD68373B86")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ViewConfiguration(Context context) {
        dsTaint.addTaint(context.dsTaint);
        final Resources res;
        res = context.getResources();
        final DisplayMetrics metrics;
        metrics = res.getDisplayMetrics();
        final Configuration config;
        config = res.getConfiguration();
        final float density;
        density = metrics.density;
        final float sizeAndDensity;
        {
            boolean var671BB1C47693047493CD39622A896334_1673814618 = (config.isLayoutSizeAtLeast(Configuration.SCREENLAYOUT_SIZE_XLARGE));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.049 -0400", hash_original_method = "EAB98871E057FCDFFF813B18E6EC4641", hash_generated_method = "65D047D00C018AF4F4B8E7987373C246")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.049 -0400", hash_original_method = "0A2417CF394B936A6105A27E128EFF04", hash_generated_method = "1DE964CC2B413D99F6C6AAADB5B01F9C")
    @Deprecated
    public static int getScrollBarSize() {
        return SCROLL_BAR_SIZE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.049 -0400", hash_original_method = "64B2CB77402813F2D85B7730CCF96AEF", hash_generated_method = "A58A05A249CB1A6163CFF20D2F517A21")
    @DSModeled(DSC.SAFE)
    public int getScaledScrollBarSize() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mScrollbarSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.049 -0400", hash_original_method = "E421242C09568631C50949743537018E", hash_generated_method = "0299A692E41855E9E03F6A872BF18F19")
    public static int getScrollBarFadeDuration() {
        return SCROLL_BAR_FADE_DURATION;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.049 -0400", hash_original_method = "EE4CEAB6942F44112E7DC4BE20D131BC", hash_generated_method = "F67C562244575945C8A8615AD4819D70")
    public static int getScrollDefaultDelay() {
        return SCROLL_BAR_DEFAULT_DELAY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.049 -0400", hash_original_method = "8C64B9F8A7003C13690A959F566BECFE", hash_generated_method = "18196CB12B81238D19D1C78AB9B072E4")
    @Deprecated
    public static int getFadingEdgeLength() {
        return FADING_EDGE_LENGTH;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.049 -0400", hash_original_method = "DBA79B5462EB99E7DC2C8AF68ED4F8B2", hash_generated_method = "EF351E4F8CB2B95D3221ABA40A0770A6")
    @DSModeled(DSC.SAFE)
    public int getScaledFadingEdgeLength() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mFadingEdgeLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.049 -0400", hash_original_method = "986F5CD389833E1A3B848F5DFC09AF7E", hash_generated_method = "88D4DB715B5E66C35FDF33DA6308CA9F")
    public static int getPressedStateDuration() {
        return PRESSED_STATE_DURATION;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.049 -0400", hash_original_method = "4FEA2532A879AC8499A02B1497AE3156", hash_generated_method = "5BDFE3F6B4823EA868E8FC12A1E27412")
    public static int getLongPressTimeout() {
        return AppGlobals.getIntCoreSetting(Settings.Secure.LONG_PRESS_TIMEOUT,
                DEFAULT_LONG_PRESS_TIMEOUT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.049 -0400", hash_original_method = "56C3332D841CB845ED684C3342A8EF80", hash_generated_method = "6A8AFDD302B5F0B5F5471E434824883E")
    public static int getKeyRepeatTimeout() {
        return getLongPressTimeout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.049 -0400", hash_original_method = "952410958896B72F9892DD38AA0BACAC", hash_generated_method = "304F4022BE61A4A795ECF5CEF744DB12")
    public static int getKeyRepeatDelay() {
        return KEY_REPEAT_DELAY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.049 -0400", hash_original_method = "2054B3BE796FC76059006CC8B92F3425", hash_generated_method = "5AD9BFA0A5FAC59C26025C95AC442E44")
    public static int getTapTimeout() {
        return TAP_TIMEOUT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.050 -0400", hash_original_method = "712BEBBA15DDE6D9B5BA141CEBD73697", hash_generated_method = "324F7B30BF1EA0EB5F37DD6924F78453")
    public static int getJumpTapTimeout() {
        return JUMP_TAP_TIMEOUT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.050 -0400", hash_original_method = "C6977CF707F5347B0F237AB856D16490", hash_generated_method = "2CBE85464FBF2DA33E26EE594A400A04")
    public static int getDoubleTapTimeout() {
        return DOUBLE_TAP_TIMEOUT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.050 -0400", hash_original_method = "285032CB4BAC3764E315512D2B9D5FFB", hash_generated_method = "FB8D1F641C08E03888A12A63F453578C")
    public static int getHoverTapTimeout() {
        return HOVER_TAP_TIMEOUT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.050 -0400", hash_original_method = "B475AFBEADA30C05164C37D5565D4F02", hash_generated_method = "CEF9D27BD30BC4765AB0199F95597FAC")
    public static int getHoverTapSlop() {
        return HOVER_TAP_SLOP;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.050 -0400", hash_original_method = "0D971D69CF54747E28FD325D51504DA1", hash_generated_method = "C1B49118EDD5BD4713CFADB8DE2B32D8")
    @Deprecated
    public static int getEdgeSlop() {
        return EDGE_SLOP;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.050 -0400", hash_original_method = "26568609E943FB4B92788BE90A3C6865", hash_generated_method = "CE6AEBEAEDA4AFAFC43B83A795516A59")
    @DSModeled(DSC.SAFE)
    public int getScaledEdgeSlop() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mEdgeSlop;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.050 -0400", hash_original_method = "B61AC12A34EFA6AB10E7C5F3FBA1C69E", hash_generated_method = "FF1EC43C2C2F4503BA634627B550A9DB")
    @Deprecated
    public static int getTouchSlop() {
        return TOUCH_SLOP;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.050 -0400", hash_original_method = "60BD37725F7CBB3A1C18E0C12D7EC92F", hash_generated_method = "A45D699CE63BF3D500C0785208FDEE4B")
    @DSModeled(DSC.SAFE)
    public int getScaledTouchSlop() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mTouchSlop;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.050 -0400", hash_original_method = "4AE776F4126E41D66D9D9E5C3DD06CAD", hash_generated_method = "E2302A16ECA6EB0856D9F7BB408DA0DE")
    @DSModeled(DSC.SAFE)
    public int getScaledPagingTouchSlop() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mPagingTouchSlop;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.050 -0400", hash_original_method = "B21C34C9A7C650B71FC2E1314F2C1946", hash_generated_method = "DF88559979C7BF644876949C3111B086")
    @Deprecated
    public static int getDoubleTapSlop() {
        return DOUBLE_TAP_SLOP;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.050 -0400", hash_original_method = "6B30BD1A6859DBFC35C31996D22D0A66", hash_generated_method = "05493F507C541A1F1938D47BB776D7E6")
    @DSModeled(DSC.SAFE)
    public int getScaledDoubleTapSlop() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mDoubleTapSlop;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.050 -0400", hash_original_method = "B7560D2EBF5FE44925FF9E0F817886D6", hash_generated_method = "2D627D46DC92EDAE868B71A5905887A1")
    @DSModeled(DSC.SAFE)
    public int getScaledTouchExplorationTapSlop() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mScaledTouchExplorationTapSlop;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.050 -0400", hash_original_method = "41F28C9DB7B309BD1951DBE065F93772", hash_generated_method = "96FC8E748105E1AA0A906BA11C4ECA53")
    public static long getSendRecurringAccessibilityEventsInterval() {
        return SEND_RECURRING_ACCESSIBILITY_EVENTS_INTERVAL_MILLIS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.050 -0400", hash_original_method = "C4429676118726C50723506C01DBC891", hash_generated_method = "12B3ABDAF6B1DD4FC59AA5EF6A467D5B")
    @Deprecated
    public static int getWindowTouchSlop() {
        return WINDOW_TOUCH_SLOP;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.050 -0400", hash_original_method = "C43D675F470050DADBFF4CBA809EB35A", hash_generated_method = "1A997DAC636C7B667B31ACDF5D85239C")
    @DSModeled(DSC.SAFE)
    public int getScaledWindowTouchSlop() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mWindowTouchSlop;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.050 -0400", hash_original_method = "546B6EB3FB7821963DFBB7988B40EAE1", hash_generated_method = "47EC8BFCFE253501827EF425964422BE")
    @Deprecated
    public static int getMinimumFlingVelocity() {
        return MINIMUM_FLING_VELOCITY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.050 -0400", hash_original_method = "0486ED6F0D874BB9D1C234D99788A23A", hash_generated_method = "EBCF6ABED17012B5C0AA108DD79AA6A7")
    @DSModeled(DSC.SAFE)
    public int getScaledMinimumFlingVelocity() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mMinimumFlingVelocity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.050 -0400", hash_original_method = "B6BA12BC9FC63D5E48FA275CC038AC53", hash_generated_method = "5913DEFCBF0FB56BD450B397A23625CD")
    @Deprecated
    public static int getMaximumFlingVelocity() {
        return MAXIMUM_FLING_VELOCITY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.050 -0400", hash_original_method = "FB70B19A53E289FD25C6D1F0C8994CAD", hash_generated_method = "D9306599DE377A8BE826D54930335822")
    @DSModeled(DSC.SAFE)
    public int getScaledMaximumFlingVelocity() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mMaximumFlingVelocity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.051 -0400", hash_original_method = "75E98CDAD9F30C5A8AB1E3F56D4A9D35", hash_generated_method = "A1C57FDB961912F78C1CB8F88CF6035E")
    @Deprecated
    public static int getMaximumDrawingCacheSize() {
        return MAXIMUM_DRAWING_CACHE_SIZE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.051 -0400", hash_original_method = "C4F1814F49D0F58AC601C99A9F6FDB3F", hash_generated_method = "151CA1BB70F6E8FFAED6662629B505C5")
    @DSModeled(DSC.SAFE)
    public int getScaledMaximumDrawingCacheSize() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mMaximumDrawingCacheSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.051 -0400", hash_original_method = "36377B5ABE3B6C0802B86BCCF5BB67A1", hash_generated_method = "FE31667B0821845B38FCEDF3967A83C2")
    @DSModeled(DSC.SAFE)
    public int getScaledOverscrollDistance() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mOverscrollDistance;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.051 -0400", hash_original_method = "1172E195811EBBA2C8358246D6F16FAF", hash_generated_method = "122FAEAF9F4C54DBB876E5F9F92077B5")
    @DSModeled(DSC.SAFE)
    public int getScaledOverflingDistance() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mOverflingDistance;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.051 -0400", hash_original_method = "5E4968614D1816EAF1E214BAA3A99C49", hash_generated_method = "F13D58897F350F38BD659664B6311E5C")
    public static long getZoomControlsTimeout() {
        return ZOOM_CONTROLS_TIMEOUT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.051 -0400", hash_original_method = "8D8BF00437B1A756760393177D6EECAF", hash_generated_method = "AC2C3AF8025FAB610E66EB4E861FA975")
    public static long getGlobalActionKeyTimeout() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return GLOBAL_ACTIONS_KEY_TIMEOUT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.051 -0400", hash_original_method = "91748064AA7D196E0821A0CDB0FFFE72", hash_generated_method = "0793C6AAAD831A0F9B0498382432C7C6")
    public static float getScrollFriction() {
        return SCROLL_FRICTION;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.051 -0400", hash_original_method = "545A02CAD62F49742EF9C21476AFC78D", hash_generated_method = "35C29D4050596EFBA184A9D3C4872BC8")
    @DSModeled(DSC.SAFE)
    public boolean hasPermanentMenuKey() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sHasPermanentMenuKey;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.051 -0400", hash_original_method = "B98AC48BC285AD77A873792B80842BAD", hash_generated_method = "DDE52EC959D35AE612585DE46821B236")
    @DSModeled(DSC.SAFE)
    public boolean isFadingMarqueeEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mFadingMarqueeEnabled;
    }

    
}


