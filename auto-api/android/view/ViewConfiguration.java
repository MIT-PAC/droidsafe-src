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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.789 -0400", hash_original_field = "7572292F9A0C0E3DA861F35B2F9EB690", hash_generated_field = "28AD0F459ECA25E08B8AF100A990B431")

    private int mEdgeSlop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.790 -0400", hash_original_field = "827A52B85CF8A98C1BAE5458C6B4B4F5", hash_generated_field = "BDC56F2B5F3D2AC25089A5150086EC5F")

    private int mFadingEdgeLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.790 -0400", hash_original_field = "950A8222B535BF5159B013E5329A56C7", hash_generated_field = "19DF3CA9C4A086C5604F6C8FC7721322")

    private int mMinimumFlingVelocity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.790 -0400", hash_original_field = "8ED13B950D5803064219CE68BB8F2695", hash_generated_field = "7F5E59D933F0155E107640D32355B310")

    private int mMaximumFlingVelocity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.790 -0400", hash_original_field = "E8596193B8D43C34B40311F87AB4FCD6", hash_generated_field = "5F6809D206F835FAE286C3238D869AC7")

    private int mScrollbarSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.790 -0400", hash_original_field = "3DFFFAD10926598D18EEC50D61DE79CA", hash_generated_field = "3B323323DD6A6BF972666D993592C670")

    private int mTouchSlop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.790 -0400", hash_original_field = "D601D279C05E34D2E9921B35CB90BAB6", hash_generated_field = "D1E477DC8F276E48EC9C9AAEB9FC42A1")

    private int mPagingTouchSlop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.790 -0400", hash_original_field = "F450F850864B9ECCFF82FE2087B59917", hash_generated_field = "E3F200D7EF3C7FA6B9D85E756BD947D5")

    private int mDoubleTapSlop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.790 -0400", hash_original_field = "65E37DD557E6D0E9D40F0750A85C869B", hash_generated_field = "F1E4C8B8C10EED258C69F3270B427286")

    private int mScaledTouchExplorationTapSlop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.790 -0400", hash_original_field = "2A69574802589D7DE45CCCB3649B1790", hash_generated_field = "7AAF281D4CF32CCE4AFDDFD12AA22E61")

    private int mWindowTouchSlop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.790 -0400", hash_original_field = "3BDF1FAEEAA948FC1D6E05137A75FC00", hash_generated_field = "496A8039FEB96FF34A34BAD3DDBFCA0A")

    private int mMaximumDrawingCacheSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.790 -0400", hash_original_field = "7A5B6F76BA72A8D6AFCFCEA14B8C2556", hash_generated_field = "7B0107E1CAE9FFC281D766335539D7C4")

    private int mOverscrollDistance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.790 -0400", hash_original_field = "755491871A4FCE3E01181030F8FEB178", hash_generated_field = "06022A8A798B4C892D35D0FFB16D2FDF")

    private int mOverflingDistance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.790 -0400", hash_original_field = "B38C8D561AB27D8D243BC403028E7F56", hash_generated_field = "249C70833B7AE5BEEF7C58B3181D1CF0")

    private boolean mFadingMarqueeEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.790 -0400", hash_original_field = "C1DDB0579B2A8CD16E731E3F7E518AD4", hash_generated_field = "F0C5D2873D8EDEF272362A711C85BDB5")

    private boolean sHasPermanentMenuKey;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.790 -0400", hash_original_field = "4C1941B70435CBE95D950CE674590BD2", hash_generated_field = "885609D211F3B6965A8D53C92F40BA67")

    private boolean sHasPermanentMenuKeySet;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.809 -0400", hash_original_method = "24918D20351FE8A86EAEEE2EEBA5EB08", hash_generated_method = "7CA80E922DDAD3CE631F67B3475B9CFA")
    @Deprecated
    public  ViewConfiguration() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.820 -0400", hash_original_method = "815441BD896E00C6B865EAF3CE23B912", hash_generated_method = "40FFD2A13B107226334BD4DB983BAD0B")
    private  ViewConfiguration(Context context) {
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
            boolean var671BB1C47693047493CD39622A896334_64777753 = (config.isLayoutSizeAtLeast(Configuration.SCREENLAYOUT_SIZE_XLARGE));
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
        addTaint(context.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.835 -0400", hash_original_method = "64B2CB77402813F2D85B7730CCF96AEF", hash_generated_method = "32DC9DB615C5A48563B1F9CD3ED99194")
    public int getScaledScrollBarSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1890985085 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1890985085;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.836 -0400", hash_original_method = "DBA79B5462EB99E7DC2C8AF68ED4F8B2", hash_generated_method = "C0E40BAB75EB741F8AF9F73D832CDDCD")
    public int getScaledFadingEdgeLength() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_305569237 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_305569237;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.853 -0400", hash_original_method = "26568609E943FB4B92788BE90A3C6865", hash_generated_method = "419AE14C9528CEEDBDE6D1F99A9A2B6B")
    public int getScaledEdgeSlop() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_411464640 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_411464640;
        // ---------- Original Method ----------
        //return mEdgeSlop;
    }

    
        @Deprecated
    public static int getTouchSlop() {
        return TOUCH_SLOP;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.871 -0400", hash_original_method = "60BD37725F7CBB3A1C18E0C12D7EC92F", hash_generated_method = "4755AC5B20D7E25AC145665627CF955D")
    public int getScaledTouchSlop() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2068304076 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2068304076;
        // ---------- Original Method ----------
        //return mTouchSlop;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.871 -0400", hash_original_method = "4AE776F4126E41D66D9D9E5C3DD06CAD", hash_generated_method = "AE5CDD70485F96E98100D7F52134CE56")
    public int getScaledPagingTouchSlop() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1956994613 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1956994613;
        // ---------- Original Method ----------
        //return mPagingTouchSlop;
    }

    
        @Deprecated
    public static int getDoubleTapSlop() {
        return DOUBLE_TAP_SLOP;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.872 -0400", hash_original_method = "6B30BD1A6859DBFC35C31996D22D0A66", hash_generated_method = "8B1611F18C54F245A97695D847AAAD98")
    public int getScaledDoubleTapSlop() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_883712711 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_883712711;
        // ---------- Original Method ----------
        //return mDoubleTapSlop;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.872 -0400", hash_original_method = "B7560D2EBF5FE44925FF9E0F817886D6", hash_generated_method = "8C3BACB3EEC819427BF89E5C2B96F157")
    public int getScaledTouchExplorationTapSlop() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1438152432 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1438152432;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.873 -0400", hash_original_method = "C43D675F470050DADBFF4CBA809EB35A", hash_generated_method = "B96A8948EA7CBEA359928D3527E26531")
    public int getScaledWindowTouchSlop() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_543940719 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_543940719;
        // ---------- Original Method ----------
        //return mWindowTouchSlop;
    }

    
        @Deprecated
    public static int getMinimumFlingVelocity() {
        return MINIMUM_FLING_VELOCITY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.876 -0400", hash_original_method = "0486ED6F0D874BB9D1C234D99788A23A", hash_generated_method = "977BCD4CC81C0159AA7FD962E93613F9")
    public int getScaledMinimumFlingVelocity() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2038634615 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2038634615;
        // ---------- Original Method ----------
        //return mMinimumFlingVelocity;
    }

    
        @Deprecated
    public static int getMaximumFlingVelocity() {
        return MAXIMUM_FLING_VELOCITY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.877 -0400", hash_original_method = "FB70B19A53E289FD25C6D1F0C8994CAD", hash_generated_method = "37226C2618F45350CAD69985CD99F4EE")
    public int getScaledMaximumFlingVelocity() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_108037137 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_108037137;
        // ---------- Original Method ----------
        //return mMaximumFlingVelocity;
    }

    
        @Deprecated
    public static int getMaximumDrawingCacheSize() {
        return MAXIMUM_DRAWING_CACHE_SIZE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.902 -0400", hash_original_method = "C4F1814F49D0F58AC601C99A9F6FDB3F", hash_generated_method = "0233BCE7F56113CCE289A33052D3C8DE")
    public int getScaledMaximumDrawingCacheSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_734715643 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_734715643;
        // ---------- Original Method ----------
        //return mMaximumDrawingCacheSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.903 -0400", hash_original_method = "36377B5ABE3B6C0802B86BCCF5BB67A1", hash_generated_method = "E152469F13E33F3E20BC9187E25B0B19")
    public int getScaledOverscrollDistance() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1632713696 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1632713696;
        // ---------- Original Method ----------
        //return mOverscrollDistance;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.903 -0400", hash_original_method = "1172E195811EBBA2C8358246D6F16FAF", hash_generated_method = "93112EA42A7E6B1924F9F165C3188DA4")
    public int getScaledOverflingDistance() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2083482785 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2083482785;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.904 -0400", hash_original_method = "545A02CAD62F49742EF9C21476AFC78D", hash_generated_method = "90473057C16003CA0E7B24C841D3C15D")
    public boolean hasPermanentMenuKey() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2147179666 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2147179666;
        // ---------- Original Method ----------
        //return sHasPermanentMenuKey;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.904 -0400", hash_original_method = "B98AC48BC285AD77A873792B80842BAD", hash_generated_method = "62088EFF1C7E504F3A0DC0BFCF350F94")
    public boolean isFadingMarqueeEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_615985195 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_615985195;
        // ---------- Original Method ----------
        //return mFadingMarqueeEnabled;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.904 -0400", hash_original_field = "C5D3E6034709A7AC9EA5746A1E428B65", hash_generated_field = "9747DCAA618DB198D5B9A1CE115BFF97")

    public static final float PANEL_BIT_DEPTH = 24;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.904 -0400", hash_original_field = "C7C9161BEFFCFA080361179B9B90102C", hash_generated_field = "A32F9F21F286F09C5FFE13705521F9D3")

    public static final float ALPHA_THRESHOLD = 0.5f / PANEL_BIT_DEPTH;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.904 -0400", hash_original_field = "4A07BC36D98D16479A7F0D959FAC265F", hash_generated_field = "35907D06006F393F45FB2B825ED40F7E")

    public static final float ALPHA_THRESHOLD_INT = 0x7f / PANEL_BIT_DEPTH;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.904 -0400", hash_original_field = "7DA8DA005633606C8EC301E81AC0706C", hash_generated_field = "2A9D45092DF9E600EBD3BDAF63D42BC0")

    private static int SCROLL_BAR_SIZE = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.904 -0400", hash_original_field = "5DAA48AB55E95A75FD6230B6AAE73202", hash_generated_field = "3C2BAC5B8FEE1374C736B88F8CCBF8AB")

    private static int SCROLL_BAR_FADE_DURATION = 250;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.904 -0400", hash_original_field = "49EF42C37EB6583AD8088BF82E3D9FF6", hash_generated_field = "C75C73FF6C525B6F6ADE067E6C5CE415")

    private static int SCROLL_BAR_DEFAULT_DELAY = 300;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.904 -0400", hash_original_field = "D15BAAEB5629F7A5E42A512ADA91E546", hash_generated_field = "A2539EC447440807BC21D57AC331D730")

    private static int FADING_EDGE_LENGTH = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.905 -0400", hash_original_field = "F0C6303FDAA7182C046310D15CA8B43F", hash_generated_field = "9DEDB051F6E27E935BB6313F8901FE54")

    private static int PRESSED_STATE_DURATION = 125;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.905 -0400", hash_original_field = "6533AC81E1D3C14BD5D33A430C012688", hash_generated_field = "46F29C5EB13B611D339724595C145B5A")

    private static int DEFAULT_LONG_PRESS_TIMEOUT = 500;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.905 -0400", hash_original_field = "6F6FFD67B1B03BF6F154E9602385D163", hash_generated_field = "65F5EAECBBFF3F2C3699F20777ED4F00")

    private static int KEY_REPEAT_DELAY = 50;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.905 -0400", hash_original_field = "3359170353C3B1017DBA134B76DACAC9", hash_generated_field = "E6136659A3D5FE84C8831D12323858FB")

    private static int GLOBAL_ACTIONS_KEY_TIMEOUT = 500;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.905 -0400", hash_original_field = "6BBB2B018D722753A6AB3587DC275DF2", hash_generated_field = "BB8303EDF122184770CB326571860B83")

    private static int TAP_TIMEOUT = 180;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.905 -0400", hash_original_field = "2A11B0B6D4B75535BC16B103A48AEBF3", hash_generated_field = "AC1B0EA2B71DE5D7A802EEA4AE3D3B2F")

    private static int JUMP_TAP_TIMEOUT = 500;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.905 -0400", hash_original_field = "058FDEC0A28A5E37490EE0802607EC87", hash_generated_field = "D8549D14485DA1586C94E9F6D37E6EBC")

    private static int DOUBLE_TAP_TIMEOUT = 300;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.905 -0400", hash_original_field = "59F4065BD6221308690552320B5B3FE5", hash_generated_field = "28B9276BB089ADA6EE23AB73D4D97533")

    private static int HOVER_TAP_TIMEOUT = 150;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.905 -0400", hash_original_field = "B03EF1CD2E4C4060AA68AE5FC127023D", hash_generated_field = "7342B0E48055D9334F9E4BBFB14CC5D8")

    private static int HOVER_TAP_SLOP = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.905 -0400", hash_original_field = "727E21F177BE2563E9C9A027DF3C3A06", hash_generated_field = "4764B8A29C81D0ED0B39514A64BD52DB")

    private static int ZOOM_CONTROLS_TIMEOUT = 3000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.905 -0400", hash_original_field = "EEF54F2080DB01A6DC145F165C6D4B78", hash_generated_field = "340CE7FEA2823EAF4287CB9E26BF7A37")

    private static int EDGE_SLOP = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.905 -0400", hash_original_field = "67F5949D3FBBF47C0A276DE0414FE53B", hash_generated_field = "EC35C979E2100D1A64B67971478B294D")

    private static int TOUCH_SLOP = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.905 -0400", hash_original_field = "F460B07A1BFF27B4A98FB0D1F018EB78", hash_generated_field = "4276A521E6026C3C0431564B913DED19")

    private static int PAGING_TOUCH_SLOP = TOUCH_SLOP * 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.905 -0400", hash_original_field = "71F1B1F80B85617768DB798637BD9CD3", hash_generated_field = "AE95795F6C6C39C532485A258C5DE88D")

    private static int DOUBLE_TAP_SLOP = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.905 -0400", hash_original_field = "625846D6DA3F36ED198DE41F67E15100", hash_generated_field = "8CCEE2555FA0BE249D18AE7ADB8BB3F9")

    private static int WINDOW_TOUCH_SLOP = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.905 -0400", hash_original_field = "4D92C82BC8F2420AB114BEB62CD7ED87", hash_generated_field = "27F7B708743F5FC0687F15BD9B1FF870")

    private static int MINIMUM_FLING_VELOCITY = 50;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.905 -0400", hash_original_field = "A0CB4C2BC155C75831C0EB8121DAC42C", hash_generated_field = "0A88F1B2C3672277ACC388C85E34822D")

    private static int MAXIMUM_FLING_VELOCITY = 8000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.905 -0400", hash_original_field = "5EF308B3B293B88F7EE2697177AF6212", hash_generated_field = "DF7BA3087A60C037D00D4978DADE1710")

    private static int TOUCH_EXPLORATION_TAP_SLOP = 80;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.905 -0400", hash_original_field = "CC00C275BB38C0FDF966C67CDAAB27F8", hash_generated_field = "A7EBD0CA590BB0DC96A0F2579A8B21F0")

    private static long SEND_RECURRING_ACCESSIBILITY_EVENTS_INTERVAL_MILLIS = 400;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.905 -0400", hash_original_field = "9F6846B5205BEE47C7C2E206B5046E88", hash_generated_field = "7E8C98E9D9F4C10BCBA112DCA08CCC28")

    @Deprecated private static int MAXIMUM_DRAWING_CACHE_SIZE = 480 * 800 * 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.905 -0400", hash_original_field = "59623B47C79647B0179EB90EFDFF2E84", hash_generated_field = "563C9E7DB3C59AC224F44002D55237C8")

    private static float SCROLL_FRICTION = 0.015f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.912 -0400", hash_original_field = "F622317E035BF413F10B223376292C35", hash_generated_field = "C91B421CD3B9E2906EDFCC567DCE6235")

    private static int OVERSCROLL_DISTANCE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.912 -0400", hash_original_field = "0BAFCFD5BDC060F85A993533F48576E7", hash_generated_field = "36471201609601FA0941351A916DDAA6")

    private static int OVERFLING_DISTANCE = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:51.912 -0400", hash_original_field = "380143A01B9C2E733DA63B7F7A7593FD", hash_generated_field = "E2506D327C40B82B42734E28670A4FE0")

    static SparseArray<ViewConfiguration> sConfigurations = new SparseArray<ViewConfiguration>(2);
}

