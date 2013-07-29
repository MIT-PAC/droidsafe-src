package android.view;

// Droidsafe Imports
import android.app.AppGlobals;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.RemoteException;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ViewConfiguration {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.783 -0400", hash_original_field = "7572292F9A0C0E3DA861F35B2F9EB690", hash_generated_field = "28AD0F459ECA25E08B8AF100A990B431")

    private int mEdgeSlop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.783 -0400", hash_original_field = "827A52B85CF8A98C1BAE5458C6B4B4F5", hash_generated_field = "BDC56F2B5F3D2AC25089A5150086EC5F")

    private int mFadingEdgeLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.784 -0400", hash_original_field = "950A8222B535BF5159B013E5329A56C7", hash_generated_field = "19DF3CA9C4A086C5604F6C8FC7721322")

    private int mMinimumFlingVelocity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.784 -0400", hash_original_field = "8ED13B950D5803064219CE68BB8F2695", hash_generated_field = "7F5E59D933F0155E107640D32355B310")

    private int mMaximumFlingVelocity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.784 -0400", hash_original_field = "E8596193B8D43C34B40311F87AB4FCD6", hash_generated_field = "5F6809D206F835FAE286C3238D869AC7")

    private int mScrollbarSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.784 -0400", hash_original_field = "3DFFFAD10926598D18EEC50D61DE79CA", hash_generated_field = "3B323323DD6A6BF972666D993592C670")

    private int mTouchSlop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.784 -0400", hash_original_field = "D601D279C05E34D2E9921B35CB90BAB6", hash_generated_field = "D1E477DC8F276E48EC9C9AAEB9FC42A1")

    private int mPagingTouchSlop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.784 -0400", hash_original_field = "F450F850864B9ECCFF82FE2087B59917", hash_generated_field = "E3F200D7EF3C7FA6B9D85E756BD947D5")

    private int mDoubleTapSlop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.784 -0400", hash_original_field = "65E37DD557E6D0E9D40F0750A85C869B", hash_generated_field = "F1E4C8B8C10EED258C69F3270B427286")

    private int mScaledTouchExplorationTapSlop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.784 -0400", hash_original_field = "2A69574802589D7DE45CCCB3649B1790", hash_generated_field = "7AAF281D4CF32CCE4AFDDFD12AA22E61")

    private int mWindowTouchSlop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.784 -0400", hash_original_field = "3BDF1FAEEAA948FC1D6E05137A75FC00", hash_generated_field = "496A8039FEB96FF34A34BAD3DDBFCA0A")

    private int mMaximumDrawingCacheSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.784 -0400", hash_original_field = "7A5B6F76BA72A8D6AFCFCEA14B8C2556", hash_generated_field = "7B0107E1CAE9FFC281D766335539D7C4")

    private int mOverscrollDistance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.784 -0400", hash_original_field = "755491871A4FCE3E01181030F8FEB178", hash_generated_field = "06022A8A798B4C892D35D0FFB16D2FDF")

    private int mOverflingDistance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.784 -0400", hash_original_field = "B38C8D561AB27D8D243BC403028E7F56", hash_generated_field = "249C70833B7AE5BEEF7C58B3181D1CF0")

    private boolean mFadingMarqueeEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.784 -0400", hash_original_field = "C1DDB0579B2A8CD16E731E3F7E518AD4", hash_generated_field = "F0C5D2873D8EDEF272362A711C85BDB5")

    private boolean sHasPermanentMenuKey;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.784 -0400", hash_original_field = "4C1941B70435CBE95D950CE674590BD2", hash_generated_field = "885609D211F3B6965A8D53C92F40BA67")

    private boolean sHasPermanentMenuKeySet;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.786 -0400", hash_original_method = "24918D20351FE8A86EAEEE2EEBA5EB08", hash_generated_method = "7CA80E922DDAD3CE631F67B3475B9CFA")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.790 -0400", hash_original_method = "815441BD896E00C6B865EAF3CE23B912", hash_generated_method = "741E1AEA6E1447EBEF97500CA42EEC3A")
    private  ViewConfiguration(Context context) {
        addTaint(context.getTaint());
        final Resources res = context.getResources();
        final DisplayMetrics metrics = res.getDisplayMetrics();
        final Configuration config = res.getConfiguration();
        final float density = metrics.density;
        float sizeAndDensity;
        if(config.isLayoutSizeAtLeast(Configuration.SCREENLAYOUT_SIZE_XLARGE))        
        {
            sizeAndDensity = density * 1.5f;
        } //End block
        else
        {
            sizeAndDensity = density;
        } //End block
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
        if(!sHasPermanentMenuKeySet)        
        {
            IWindowManager wm = Display.getWindowManager();
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @Deprecated
    public static int getScrollBarSize() {
        return SCROLL_BAR_SIZE;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.791 -0400", hash_original_method = "64B2CB77402813F2D85B7730CCF96AEF", hash_generated_method = "2EB5F9093B5606B50FD548C8A4718A6A")
    public int getScaledScrollBarSize() {
        int varE8596193B8D43C34B40311F87AB4FCD6_1522865909 = (mScrollbarSize);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1168551290 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1168551290;
        // ---------- Original Method ----------
        //return mScrollbarSize;
    }

    
    @DSModeled(DSC.SAFE)
    public static int getScrollBarFadeDuration() {
        return SCROLL_BAR_FADE_DURATION;
    }

    
    @DSModeled(DSC.SAFE)
    public static int getScrollDefaultDelay() {
        return SCROLL_BAR_DEFAULT_DELAY;
    }

    
    @DSModeled(DSC.SAFE)
    @Deprecated
    public static int getFadingEdgeLength() {
        return FADING_EDGE_LENGTH;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.792 -0400", hash_original_method = "DBA79B5462EB99E7DC2C8AF68ED4F8B2", hash_generated_method = "B85E6720E632504B5F0EEDF24E62CF08")
    public int getScaledFadingEdgeLength() {
        int var827A52B85CF8A98C1BAE5458C6B4B4F5_119316809 = (mFadingEdgeLength);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1322589443 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1322589443;
        // ---------- Original Method ----------
        //return mFadingEdgeLength;
    }

    
    @DSModeled(DSC.SAFE)
    public static int getPressedStateDuration() {
        return PRESSED_STATE_DURATION;
    }

    
    @DSModeled(DSC.SAFE)
    public static int getLongPressTimeout() {
        return AppGlobals.getIntCoreSetting(Settings.Secure.LONG_PRESS_TIMEOUT,
                DEFAULT_LONG_PRESS_TIMEOUT);
    }

    
    @DSModeled(DSC.SAFE)
    public static int getKeyRepeatTimeout() {
        return getLongPressTimeout();
    }

    
    @DSModeled(DSC.SAFE)
    public static int getKeyRepeatDelay() {
        return KEY_REPEAT_DELAY;
    }

    
    @DSModeled(DSC.SAFE)
    public static int getTapTimeout() {
        return TAP_TIMEOUT;
    }

    
    @DSModeled(DSC.SAFE)
    public static int getJumpTapTimeout() {
        return JUMP_TAP_TIMEOUT;
    }

    
    @DSModeled(DSC.SAFE)
    public static int getDoubleTapTimeout() {
        return DOUBLE_TAP_TIMEOUT;
    }

    
    @DSModeled(DSC.SAFE)
    public static int getHoverTapTimeout() {
        return HOVER_TAP_TIMEOUT;
    }

    
    @DSModeled(DSC.SAFE)
    public static int getHoverTapSlop() {
        return HOVER_TAP_SLOP;
    }

    
    @DSModeled(DSC.SAFE)
    @Deprecated
    public static int getEdgeSlop() {
        return EDGE_SLOP;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.795 -0400", hash_original_method = "26568609E943FB4B92788BE90A3C6865", hash_generated_method = "344D812A1E02E0A8BD8F0B72EAECFB67")
    public int getScaledEdgeSlop() {
        int var7572292F9A0C0E3DA861F35B2F9EB690_145580303 = (mEdgeSlop);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_311038449 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_311038449;
        // ---------- Original Method ----------
        //return mEdgeSlop;
    }

    
    @DSModeled(DSC.SAFE)
    @Deprecated
    public static int getTouchSlop() {
        return TOUCH_SLOP;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.795 -0400", hash_original_method = "60BD37725F7CBB3A1C18E0C12D7EC92F", hash_generated_method = "AC3B251A883498111426CEB2836E69D3")
    public int getScaledTouchSlop() {
        int var3DFFFAD10926598D18EEC50D61DE79CA_1255914769 = (mTouchSlop);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_19475350 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_19475350;
        // ---------- Original Method ----------
        //return mTouchSlop;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.795 -0400", hash_original_method = "4AE776F4126E41D66D9D9E5C3DD06CAD", hash_generated_method = "F7526E66D4FCA3C95B26CED9B2230D26")
    public int getScaledPagingTouchSlop() {
        int varD601D279C05E34D2E9921B35CB90BAB6_1656990941 = (mPagingTouchSlop);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1832376446 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1832376446;
        // ---------- Original Method ----------
        //return mPagingTouchSlop;
    }

    
    @DSModeled(DSC.SAFE)
    @Deprecated
    public static int getDoubleTapSlop() {
        return DOUBLE_TAP_SLOP;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.795 -0400", hash_original_method = "6B30BD1A6859DBFC35C31996D22D0A66", hash_generated_method = "6F6975BC092CF3BE6327747A5CD896FD")
    public int getScaledDoubleTapSlop() {
        int varF450F850864B9ECCFF82FE2087B59917_609961423 = (mDoubleTapSlop);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1997920788 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1997920788;
        // ---------- Original Method ----------
        //return mDoubleTapSlop;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.795 -0400", hash_original_method = "B7560D2EBF5FE44925FF9E0F817886D6", hash_generated_method = "99C92AF975E8BDDBFCF6E94117420471")
    public int getScaledTouchExplorationTapSlop() {
        int var65E37DD557E6D0E9D40F0750A85C869B_781233794 = (mScaledTouchExplorationTapSlop);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1637385558 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1637385558;
        // ---------- Original Method ----------
        //return mScaledTouchExplorationTapSlop;
    }

    
    @DSModeled(DSC.SAFE)
    public static long getSendRecurringAccessibilityEventsInterval() {
        return SEND_RECURRING_ACCESSIBILITY_EVENTS_INTERVAL_MILLIS;
    }

    
    @DSModeled(DSC.SAFE)
    @Deprecated
    public static int getWindowTouchSlop() {
        return WINDOW_TOUCH_SLOP;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.795 -0400", hash_original_method = "C43D675F470050DADBFF4CBA809EB35A", hash_generated_method = "B937ACD3BFA53A542EA5516CB77A1CE8")
    public int getScaledWindowTouchSlop() {
        int var2A69574802589D7DE45CCCB3649B1790_554975216 = (mWindowTouchSlop);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_301992063 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_301992063;
        // ---------- Original Method ----------
        //return mWindowTouchSlop;
    }

    
    @DSModeled(DSC.SAFE)
    @Deprecated
    public static int getMinimumFlingVelocity() {
        return MINIMUM_FLING_VELOCITY;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.796 -0400", hash_original_method = "0486ED6F0D874BB9D1C234D99788A23A", hash_generated_method = "3AAA0043C9699CAF92C79C56DB6B14DB")
    public int getScaledMinimumFlingVelocity() {
        int var950A8222B535BF5159B013E5329A56C7_482559736 = (mMinimumFlingVelocity);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_235780028 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_235780028;
        // ---------- Original Method ----------
        //return mMinimumFlingVelocity;
    }

    
    @DSModeled(DSC.SAFE)
    @Deprecated
    public static int getMaximumFlingVelocity() {
        return MAXIMUM_FLING_VELOCITY;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.796 -0400", hash_original_method = "FB70B19A53E289FD25C6D1F0C8994CAD", hash_generated_method = "C723865601EBC885CCA9E3EEEAE4F0A3")
    public int getScaledMaximumFlingVelocity() {
        int var8ED13B950D5803064219CE68BB8F2695_516941983 = (mMaximumFlingVelocity);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2081718715 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2081718715;
        // ---------- Original Method ----------
        //return mMaximumFlingVelocity;
    }

    
    @DSModeled(DSC.SAFE)
    @Deprecated
    public static int getMaximumDrawingCacheSize() {
        return MAXIMUM_DRAWING_CACHE_SIZE;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.796 -0400", hash_original_method = "C4F1814F49D0F58AC601C99A9F6FDB3F", hash_generated_method = "46BA75210F268BC4BA608C4F00C87270")
    public int getScaledMaximumDrawingCacheSize() {
        int var3BDF1FAEEAA948FC1D6E05137A75FC00_1878233872 = (mMaximumDrawingCacheSize);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_349430841 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_349430841;
        // ---------- Original Method ----------
        //return mMaximumDrawingCacheSize;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.796 -0400", hash_original_method = "36377B5ABE3B6C0802B86BCCF5BB67A1", hash_generated_method = "887A9AC0F40DEF4259C645B424068202")
    public int getScaledOverscrollDistance() {
        int var7A5B6F76BA72A8D6AFCFCEA14B8C2556_792117250 = (mOverscrollDistance);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1075713508 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1075713508;
        // ---------- Original Method ----------
        //return mOverscrollDistance;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.796 -0400", hash_original_method = "1172E195811EBBA2C8358246D6F16FAF", hash_generated_method = "F9665D4BD1057348F8480874AD51148E")
    public int getScaledOverflingDistance() {
        int var755491871A4FCE3E01181030F8FEB178_938906671 = (mOverflingDistance);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_975211884 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_975211884;
        // ---------- Original Method ----------
        //return mOverflingDistance;
    }

    
    @DSModeled(DSC.SAFE)
    public static long getZoomControlsTimeout() {
        return ZOOM_CONTROLS_TIMEOUT;
    }

    
    @DSModeled(DSC.SAFE)
    public static long getGlobalActionKeyTimeout() {
        return GLOBAL_ACTIONS_KEY_TIMEOUT;
    }

    
    @DSModeled(DSC.SAFE)
    public static float getScrollFriction() {
        return SCROLL_FRICTION;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.797 -0400", hash_original_method = "545A02CAD62F49742EF9C21476AFC78D", hash_generated_method = "41C263B94A8E1870B4FF3430C9BB8011")
    public boolean hasPermanentMenuKey() {
        boolean varC1DDB0579B2A8CD16E731E3F7E518AD4_1564984286 = (sHasPermanentMenuKey);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1650351423 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1650351423;
        // ---------- Original Method ----------
        //return sHasPermanentMenuKey;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.797 -0400", hash_original_method = "B98AC48BC285AD77A873792B80842BAD", hash_generated_method = "832F7AF46202397A5D8C824E18838301")
    public boolean isFadingMarqueeEnabled() {
        boolean varB38C8D561AB27D8D243BC403028E7F56_1491373823 = (mFadingMarqueeEnabled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1056776869 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1056776869;
        // ---------- Original Method ----------
        //return mFadingMarqueeEnabled;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.797 -0400", hash_original_field = "C5D3E6034709A7AC9EA5746A1E428B65", hash_generated_field = "9747DCAA618DB198D5B9A1CE115BFF97")

    public static final float PANEL_BIT_DEPTH = 24;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.797 -0400", hash_original_field = "C7C9161BEFFCFA080361179B9B90102C", hash_generated_field = "A32F9F21F286F09C5FFE13705521F9D3")

    public static final float ALPHA_THRESHOLD = 0.5f / PANEL_BIT_DEPTH;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.797 -0400", hash_original_field = "4A07BC36D98D16479A7F0D959FAC265F", hash_generated_field = "35907D06006F393F45FB2B825ED40F7E")

    public static final float ALPHA_THRESHOLD_INT = 0x7f / PANEL_BIT_DEPTH;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.797 -0400", hash_original_field = "7DA8DA005633606C8EC301E81AC0706C", hash_generated_field = "3C1AEDD67D3CBB2346030240E15975B8")

    private static final int SCROLL_BAR_SIZE = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.797 -0400", hash_original_field = "5DAA48AB55E95A75FD6230B6AAE73202", hash_generated_field = "69F1E09B4DFF23ED0400BB441B773E33")

    private static final int SCROLL_BAR_FADE_DURATION = 250;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.797 -0400", hash_original_field = "49EF42C37EB6583AD8088BF82E3D9FF6", hash_generated_field = "19E2096CA52B8B5AB2F0EAD8007373AA")

    private static final int SCROLL_BAR_DEFAULT_DELAY = 300;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.797 -0400", hash_original_field = "D15BAAEB5629F7A5E42A512ADA91E546", hash_generated_field = "768D465CF398D0FEDC762F453F3623FE")

    private static final int FADING_EDGE_LENGTH = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.797 -0400", hash_original_field = "F0C6303FDAA7182C046310D15CA8B43F", hash_generated_field = "31F150ED1E5B1E3235C847EC46AC2706")

    private static final int PRESSED_STATE_DURATION = 125;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.797 -0400", hash_original_field = "6533AC81E1D3C14BD5D33A430C012688", hash_generated_field = "C5A105FE1289431C0CEFF3BB7FF405DA")

    private static final int DEFAULT_LONG_PRESS_TIMEOUT = 500;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.797 -0400", hash_original_field = "6F6FFD67B1B03BF6F154E9602385D163", hash_generated_field = "3D836E3388C779C8690BE80FA4A6F639")

    private static final int KEY_REPEAT_DELAY = 50;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.797 -0400", hash_original_field = "3359170353C3B1017DBA134B76DACAC9", hash_generated_field = "43F76CA836CE9CF3A61450B7AEB8F1C4")

    private static final int GLOBAL_ACTIONS_KEY_TIMEOUT = 500;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.797 -0400", hash_original_field = "6BBB2B018D722753A6AB3587DC275DF2", hash_generated_field = "3B1ECBEFF4C233CD9096673DB2F61155")

    private static final int TAP_TIMEOUT = 180;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.797 -0400", hash_original_field = "2A11B0B6D4B75535BC16B103A48AEBF3", hash_generated_field = "B908F38E70932BF1EFBA4B20FA1600BC")

    private static final int JUMP_TAP_TIMEOUT = 500;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.797 -0400", hash_original_field = "058FDEC0A28A5E37490EE0802607EC87", hash_generated_field = "B64EC6E883DFD581B5107E3F1C037D53")

    private static final int DOUBLE_TAP_TIMEOUT = 300;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.797 -0400", hash_original_field = "59F4065BD6221308690552320B5B3FE5", hash_generated_field = "1D5315E446DB64B1CC0113AAC2F20BB3")

    private static final int HOVER_TAP_TIMEOUT = 150;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.797 -0400", hash_original_field = "B03EF1CD2E4C4060AA68AE5FC127023D", hash_generated_field = "826505813607467A967020234193803D")

    private static final int HOVER_TAP_SLOP = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.797 -0400", hash_original_field = "727E21F177BE2563E9C9A027DF3C3A06", hash_generated_field = "7D5B0868A3F0CD926510FAE9036FE33E")

    private static final int ZOOM_CONTROLS_TIMEOUT = 3000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.797 -0400", hash_original_field = "EEF54F2080DB01A6DC145F165C6D4B78", hash_generated_field = "767C6F21B4C4A54A1D58C8845A829D24")

    private static final int EDGE_SLOP = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.797 -0400", hash_original_field = "67F5949D3FBBF47C0A276DE0414FE53B", hash_generated_field = "F9B41BB7FB919140842B55419F14CC34")

    private static final int TOUCH_SLOP = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.797 -0400", hash_original_field = "F460B07A1BFF27B4A98FB0D1F018EB78", hash_generated_field = "C45984564C2B2B383F066672D6ECDA36")

    private static final int PAGING_TOUCH_SLOP = TOUCH_SLOP * 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.797 -0400", hash_original_field = "71F1B1F80B85617768DB798637BD9CD3", hash_generated_field = "05521582705C7F65706759CD1CD8CECE")

    private static final int DOUBLE_TAP_SLOP = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.797 -0400", hash_original_field = "625846D6DA3F36ED198DE41F67E15100", hash_generated_field = "0A7EC28EE18866A9A9040E60DC4AC97B")

    private static final int WINDOW_TOUCH_SLOP = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.797 -0400", hash_original_field = "4D92C82BC8F2420AB114BEB62CD7ED87", hash_generated_field = "590039E7A300DBFA22B66BABAA6920B7")

    private static final int MINIMUM_FLING_VELOCITY = 50;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.797 -0400", hash_original_field = "A0CB4C2BC155C75831C0EB8121DAC42C", hash_generated_field = "C16FA29D3B701C0D89C79F0F0AD1AFBD")

    private static final int MAXIMUM_FLING_VELOCITY = 8000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.798 -0400", hash_original_field = "5EF308B3B293B88F7EE2697177AF6212", hash_generated_field = "EFD34AF3F488A3C760252D09EC59545A")

    private static final int TOUCH_EXPLORATION_TAP_SLOP = 80;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.798 -0400", hash_original_field = "CC00C275BB38C0FDF966C67CDAAB27F8", hash_generated_field = "F01671ACC3F6966DA3CE6C8E1BE7CEB3")

    private static final long SEND_RECURRING_ACCESSIBILITY_EVENTS_INTERVAL_MILLIS = 400;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.798 -0400", hash_original_field = "9F6846B5205BEE47C7C2E206B5046E88", hash_generated_field = "F8FD2906DEF15086D200C8CDD2D0C403")

    @Deprecated private static final int MAXIMUM_DRAWING_CACHE_SIZE = 480 * 800 * 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.798 -0400", hash_original_field = "59623B47C79647B0179EB90EFDFF2E84", hash_generated_field = "2CE696167C09B1199A3DDBBEA5A4BE43")

    private static final float SCROLL_FRICTION = 0.015f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.798 -0400", hash_original_field = "F622317E035BF413F10B223376292C35", hash_generated_field = "A04E9AC91D01157C378DC4613C063B24")

    private static final int OVERSCROLL_DISTANCE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.798 -0400", hash_original_field = "0BAFCFD5BDC060F85A993533F48576E7", hash_generated_field = "DA2D178DBF8807F9A6080C62905A485A")

    private static final int OVERFLING_DISTANCE = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:45.798 -0400", hash_original_field = "380143A01B9C2E733DA63B7F7A7593FD", hash_generated_field = "EEDF2561C792A30151768943796E598A")

    static final SparseArray<ViewConfiguration> sConfigurations = new SparseArray<ViewConfiguration>(2);
}

