/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.support.v4.widget;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * SlidingPaneLayout provides a horizontal, multi-pane layout for use at the top level
 * of a UI. A left (or first) pane is treated as a content list or browser, subordinate to a
 * primary detail view for displaying content.
 *
 * <p>Child views may overlap if their combined width exceeds the available width
 * in the SlidingPaneLayout. When this occurs the user may slide the topmost view out of the way
 * by dragging it, or by navigating in the direction of the overlapped view using a keyboard.
 * If the content of the dragged child view is itself horizontally scrollable, the user may
 * grab it by the very edge.</p>
 *
 * <p>Thanks to this sliding behavior, SlidingPaneLayout may be suitable for creating layouts
 * that can smoothly adapt across many different screen sizes, expanding out fully on larger
 * screens and collapsing on smaller screens.</p>
 *
 * <p>SlidingPaneLayout is distinct from a navigation drawer as described in the design
 * guide and should not be used in the same scenarios. SlidingPaneLayout should be thought
 * of only as a way to allow a two-pane layout normally used on larger screens to adapt to smaller
 * screens in a natural way. The interaction patterns expressed by SlidingPaneLayout imply
 * a physicality and direct information hierarchy between panes that does not necessarily exist
 * in a scenario where a navigation drawer should be used instead.</p>
 *
 * <p>Appropriate uses of SlidingPaneLayout include pairings of panes such as a contact list and
 * subordinate interactions with those contacts, or an email thread list with the content pane
 * displaying the contents of the selected thread. Inappropriate uses of SlidingPaneLayout include
 * switching between disparate functions of your app, such as jumping from a social stream view
 * to a view of your personal profile - cases such as this should use the navigation drawer
 * pattern instead. ({@link DrawerLayout DrawerLayout} implements this pattern.)</p>
 *
 * <p>Like {@link android.widget.LinearLayout LinearLayout}, SlidingPaneLayout supports
 * the use of the layout parameter <code>layout_weight</code> on child views to determine
 * how to divide leftover space after measurement is complete. It is only relevant for width.
 * When views do not overlap weight behaves as it does in a LinearLayout.</p>
 *
 * <p>When views do overlap, weight on a slideable pane indicates that the pane should be
 * sized to fill all available space in the closed state. Weight on a pane that becomes covered
 * indicates that the pane should be sized to fill all available space except a small minimum strip
 * that the user may use to grab the slideable view and pull it back over into a closed state.</p>
 */
public class SlidingPaneLayout extends ViewGroup {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:02.952 -0400", hash_original_field = "4D6F85FE02A69D47A5C743D647F0D4DE", hash_generated_field = "741FE9532C5890A9D2F60E80138E8199")

    private static final String TAG = "SlidingPaneLayout";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:02.963 -0400", hash_original_field = "183E84F0734B6B0FF1DF981F8E03DA44", hash_generated_field = "855519846DD4A55E63058F454EC5902A")

    private static final int DEFAULT_OVERHANG_SIZE = 32;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:02.970 -0400", hash_original_field = "36F9E9109E71DBF6919A343A9DA0F0A1", hash_generated_field = "7310E12DAC19292C90ABE5CC6EF24CE4")

    /**
     * If no fade color is given by default it will fade to 80% gray.
     */
    private static final int DEFAULT_FADE_COLOR = 0xcccccccc;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:02.985 -0400", hash_original_field = "C54670DE93B24E059BE5F717E4D09C60", hash_generated_field = "74F3A27C683DAC629ED059F99D65D7A5")

    private static final int MIN_FLING_VELOCITY = 400;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.121 -0400", hash_original_field = "52859FCA75BD49E8AC7C068AE731111F", hash_generated_field = "BF99EE8524AA8EA1B1FE25ED85A1862D")

    static  SlidingPanelLayoutImpl IMPL;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.280 -0400", hash_original_method = "04387A56EDB04CA0797ADF4462030ED2", hash_generated_method = "6AA330704FA4C19DC1FEC22864C1163A")
        
private static boolean viewIsOpaque(View v) {
        if (ViewCompat.isOpaque(v)) return true;

        // View#isOpaque didn't take all valid opaque scrollbar modes into account
        // before API 18 (JB-MR2). On newer devices rely solely on isOpaque above and return false
        // here. On older devices, check the view's background drawable directly as a fallback.
        if (Build.VERSION.SDK_INT >= 18) return false;

        final Drawable bg = v.getBackground();
        if (bg != null) {
            return bg.getOpacity() == PixelFormat.OPAQUE;
        }
        return false;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:02.977 -0400", hash_original_field = "B924D79773174012BDD4B54888D2ACE4", hash_generated_field = "08706B33710B63B1AA3A7A769B4822FB")

    private int mSliderFadeColor = DEFAULT_FADE_COLOR;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.002 -0400", hash_original_field = "96E4764DF15631DC91F7CB8F79B98E3F", hash_generated_field = "CF055F8401F0FB5C7559C5065F8EFCA9")

    /**
     * The fade color used for the panel covered by the slider. 0 = no fading.
     */
    private int mCoveredFadeColor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.010 -0400", hash_original_field = "5D558A60F9B2BC4A26BD2126B7BC65D7", hash_generated_field = "B4ACE9AC9CEA8D6FEA7B1C1CA76E5B62")

    private Drawable mShadowDrawable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.017 -0400", hash_original_field = "D756C27674C2E7A97E4D7E89F7DD6DEF", hash_generated_field = "E60BF05A99BBB644348AC48E07DC0E8E")

    private  int mOverhangSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.023 -0400", hash_original_field = "66E1D6E5D151BC6BF72C1B687D5ECC26", hash_generated_field = "C0196945463EB148975B2A6EF76E5C9B")

    private boolean mCanSlide;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.029 -0400", hash_original_field = "0834E5B19DC1517FC99577D06BFC39CA", hash_generated_field = "4E3DCF5A8123FA89B35419BAEAE33A5C")

    private View mSlideableView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.035 -0400", hash_original_field = "3E53FC266440DF62BC622A1C30055EBF", hash_generated_field = "D21E420EE44919130C0AABD34BD35545")

    private float mSlideOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.042 -0400", hash_original_field = "82176C895BAEC7B367E2904284EA6D8B", hash_generated_field = "CB31CDC2954B390A5EFF7B95DFD626A7")

    private float mParallaxOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.048 -0400", hash_original_field = "2545B790BE8DE36DFB5F5CB6AF28174E", hash_generated_field = "A20505456895E295D222B423CE0ACF2F")

    private int mSlideRange;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.055 -0400", hash_original_field = "573DD8A411955AA9EB56A5C801B41308", hash_generated_field = "748889273C84B9C9E218E6BFA97C24D2")

    private boolean mIsUnableToDrag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.061 -0400", hash_original_field = "AB06640FDC0D9E56635F61DEC57C69D0", hash_generated_field = "A10DE469AA59BF2A6EF8E4AC3686897F")

    private int mParallaxBy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.068 -0400", hash_original_field = "25CFDFB463A965BC44C22C5B603E6082", hash_generated_field = "E8D995D721D911B655A8BA1B8E85A671")

    private float mInitialMotionX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.074 -0400", hash_original_field = "8405CC958EF7FF178B766BCBE27E1F2F", hash_generated_field = "123A2D63D23BC6C888D43FC39BEED8A4")

    private float mInitialMotionY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.080 -0400", hash_original_field = "72724023BAF20CDEBFA86994ED3AACB2", hash_generated_field = "01FD9159E0FA57133A90065425E7D01B")

    private PanelSlideListener mPanelSlideListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.086 -0400", hash_original_field = "1E4804ED97308FF97C0F5A92E503A9A3", hash_generated_field = "EE832BE4A2C091132455F74997DADC89")

    private  ViewDragHelper mDragHelper;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.093 -0400", hash_original_field = "2057981BE251F8D56CF4F1591CEB6B92", hash_generated_field = "74A2888C56C2B1A209FB88DF30439ACD")

    private boolean mPreservedOpenState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.099 -0400", hash_original_field = "E8FBC0675E7594A5CB40D0BCA74175A7", hash_generated_field = "D2103C384BE0AB58542D96A0CD23C256")

    private boolean mFirstLayout = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.107 -0400", hash_original_field = "C53D3ED3F7CBB30122A6D714A9203A7D", hash_generated_field = "570061BA9CB059462550E9BCCD2A0735")

    private final Rect mTmpRect = new Rect();

    static {
        final int deviceVersion = Build.VERSION.SDK_INT;
        if (deviceVersion >= 17) {
            IMPL = new SlidingPanelLayoutImplJBMR1();
        } else if (deviceVersion >= 16) {
            IMPL = new SlidingPanelLayoutImplJB();
        } else {
            IMPL = new SlidingPanelLayoutImplBase();
        }
    }

    /**
     * Listener for monitoring events about sliding panes.
     */
    public interface PanelSlideListener {
        /**
         * Called when a sliding pane's position changes.
         * @param panel The child view that was moved
         * @param slideOffset The new offset of this sliding pane within its range, from 0-1
         */
        public void onPanelSlide(View panel, float slideOffset);
        /**
         * Called when a sliding pane becomes slid completely open. The pane may or may not
         * be interactive at this point depending on how much of the pane is visible.
         * @param panel The child view that was slid to an open position, revealing other panes
         */
        public void onPanelOpened(View panel);

        /**
         * Called when a sliding pane becomes slid completely closed. The pane is now guaranteed
         * to be interactive. It may now obscure other views in the layout.
         * @param panel The child view that was slid to a closed position
         */
        public void onPanelClosed(View panel);
    }

    /**
     * No-op stubs for {@link PanelSlideListener}. If you only want to implement a subset
     * of the listener methods you can extend this instead of implement the full interface.
     */
    public static class SimplePanelSlideListener implements PanelSlideListener {
        @Override
        public void onPanelSlide(View panel, float slideOffset) {
        }
        @Override
        public void onPanelOpened(View panel) {
        }
        @Override
        public void onPanelClosed(View panel) {
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.114 -0400", hash_original_field = "B36620936413E2FDAB6E8EE9592F4A2D", hash_generated_field = "6D5A04C20BB307F6E1F0B44D4B940AAB")

    private final ArrayList<DisableLayerRunnable> mPostedRunnables =
            new ArrayList<DisableLayerRunnable>();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.171 -0400", hash_original_method = "6BFD85CDE2236D519D5357D7D719E08B", hash_generated_method = "00E8427D95D339722D844A93E5AF4148")
        
public SlidingPaneLayout(Context context) {
        this(context, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.177 -0400", hash_original_method = "FB02FB224A6AADBEE1833BC4CE8D1751", hash_generated_method = "845B0C8E60ED45921A7F13535E2FA709")
        
public SlidingPaneLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:17:05.015 -0400", hash_original_method = "41390F5FA64CAF41ADE8AE47BE43C4EE", hash_generated_method = "8BEA28334813EA7C26CB567CB35B30E8")
        
public SlidingPaneLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        final float density = context.getResources().getDisplayMetrics().density;
        mOverhangSize = (int) (DEFAULT_OVERHANG_SIZE * density + 0.5f);

        final ViewConfiguration viewConfig = ViewConfiguration.get(context);

        setWillNotDraw(false);

        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegate());
        ViewCompat.setImportantForAccessibility(this, ViewCompat.IMPORTANT_FOR_ACCESSIBILITY_YES);

        mDragHelper = ViewDragHelper.create(this, 0.5f, new DragHelperCallback());
        mDragHelper.setMinVelocity(MIN_FLING_VELOCITY * density);
    }

    /**
     * Set a distance to parallax the lower pane by when the upper pane is in its
     * fully closed state. The lower pane will scroll between this position and
     * its fully open state.
     *
     * @param parallaxBy Distance to parallax by in pixels
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.197 -0400", hash_original_method = "0688B841940779E22167E66014E33F8D", hash_generated_method = "F5BE2E9D070F7E64ECC993379A1152D4")
        
public void setParallaxDistance(int parallaxBy) {
        mParallaxBy = parallaxBy;
        requestLayout();
    }

    /**
     * @return The distance the lower pane will parallax by when the upper pane is fully closed.
     *
     * @see #setParallaxDistance(int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.204 -0400", hash_original_method = "903D3AD5A26FA591521C42F3A612DA7F", hash_generated_method = "68E4081B1188450A8CDC0E02E8A4E349")
        
public int getParallaxDistance() {
        return mParallaxBy;
    }

    /**
     * Set the color used to fade the sliding pane out when it is slid most of the way offscreen.
     *
     * @param color An ARGB-packed color value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.210 -0400", hash_original_method = "730D9E8F5AC2F386CC8E4D8E8FEAF6B9", hash_generated_method = "5CB7F318A50A2C2DEDCCDDB53DE89A94")
        
public void setSliderFadeColor(int color) {
        mSliderFadeColor = color;
    }

    /**
     * @return The ARGB-packed color value used to fade the sliding pane
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.216 -0400", hash_original_method = "C8E412C258577BB71D9872E9FD485133", hash_generated_method = "1E68281AE88A5D5A3F6F8A46AE65C807")
        
public int getSliderFadeColor() {
        return mSliderFadeColor;
    }

    /**
     * Set the color used to fade the pane covered by the sliding pane out when the pane
     * will become fully covered in the closed state.
     *
     * @param color An ARGB-packed color value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.222 -0400", hash_original_method = "4F552C4B26D9AFD044BC9DF8810A3021", hash_generated_method = "1F4C4D15247FB297B8919DD3BF4134BC")
        
public void setCoveredFadeColor(int color) {
        mCoveredFadeColor = color;
    }

    /**
     * @return The ARGB-packed color value used to fade the fixed pane
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.228 -0400", hash_original_method = "D436B799F18765AD390F79002492178F", hash_generated_method = "5105BB5FFFD255DB3013353E3A67C34C")
        
public int getCoveredFadeColor() {
        return mCoveredFadeColor;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.233 -0400", hash_original_method = "FFAAA25CC37BFE33631B5C4649D1D1EA", hash_generated_method = "0DF74CC9F4608BABB88688372711FE1A")
        
public void setPanelSlideListener(PanelSlideListener listener) {
        mPanelSlideListener = listener;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.239 -0400", hash_original_method = "9200384BFC8C572C67BB35F0E383B940", hash_generated_method = "9200384BFC8C572C67BB35F0E383B940")
        
void dispatchOnPanelSlide(View panel) {
        if (mPanelSlideListener != null) {
            mPanelSlideListener.onPanelSlide(panel, mSlideOffset);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.246 -0400", hash_original_method = "076B596B953AAB890ED85CFE265CED71", hash_generated_method = "076B596B953AAB890ED85CFE265CED71")
        
void dispatchOnPanelOpened(View panel) {
        if (mPanelSlideListener != null) {
            mPanelSlideListener.onPanelOpened(panel);
        }
        sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.252 -0400", hash_original_method = "206FA8CECF0D7215420AE12C4F2D65AB", hash_generated_method = "206FA8CECF0D7215420AE12C4F2D65AB")
        
void dispatchOnPanelClosed(View panel) {
        if (mPanelSlideListener != null) {
            mPanelSlideListener.onPanelClosed(panel);
        }
        sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:17:05.087 -0400", hash_original_method = "03B83C7D6245A99096FE1BE44F2A07C1", hash_generated_method = "A72AFF2A0EDFC8D37C3AF2331CEEA49C")
        
void updateObscuredViewsVisibility(View panel) {
        final boolean isLayoutRtl = isLayoutRtlSupport();
        final int startBound = isLayoutRtl ? (getWidth() - getPaddingRight()) :
            getPaddingLeft();
        final int endBound = isLayoutRtl ? getPaddingLeft() :
            (getWidth() - getPaddingRight());
        final int topBound = getPaddingTop();
        final int bottomBound = getHeight() - getPaddingBottom();
        final int left;
        final int right;
        final int top;
        final int bottom;
        if (panel != null && viewIsOpaque(panel)) {
            left = panel.getLeft();
            right = panel.getRight();
            top = panel.getTop();
            bottom = panel.getBottom();
        } else {
            left = right = top = bottom = 0;
        }

        for (int i = 0, childCount = getChildCount(); i < childCount; i++) {
            final View child = getChildAt(i);

            if (child == panel) {
                // There are still more children above the panel but they won't be affected.
                break;
            }

            final int clampedChildLeft = Math.max((isLayoutRtl ? endBound :
                startBound), child.getLeft());
            final int clampedChildTop = Math.max(topBound, child.getTop());
            final int clampedChildRight = Math.min((isLayoutRtl ? startBound :
                endBound), child.getRight());
            final int clampedChildBottom = Math.min(bottomBound, child.getBottom());
            final int vis;
            if (clampedChildLeft >= left && clampedChildTop >= top &&
                    clampedChildRight <= right && clampedChildBottom <= bottom) {
                vis = INVISIBLE;
            } else {
                vis = VISIBLE;
            }
            child.setVisibility(vis);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.272 -0400", hash_original_method = "5CE7A5A3A8529E998FC7D6BAD2B14C28", hash_generated_method = "5CE7A5A3A8529E998FC7D6BAD2B14C28")
        
void setAllChildrenVisible() {
        for (int i = 0, childCount = getChildCount(); i < childCount; i++) {
            final View child = getChildAt(i);
            if (child.getVisibility() == INVISIBLE) {
                child.setVisibility(VISIBLE);
            }
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.287 -0400", hash_original_method = "55E78F1E2A11C365755D77C284D387A2", hash_generated_method = "F4968E15513E07145315A993A80462B8")
        
@Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mFirstLayout = true;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.295 -0400", hash_original_method = "143C49C748950B77D7E86D3ED9117732", hash_generated_method = "70FBA4A7DB291334FE6267E809C36680")
        
@Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mFirstLayout = true;

        for (int i = 0, count = mPostedRunnables.size(); i < count; i++) {
            final DisableLayerRunnable dlr = mPostedRunnables.get(i);
            dlr.run();
        }
        mPostedRunnables.clear();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:17:05.152 -0400", hash_original_method = "F66E9104C9A982CD59596EB5D6567401", hash_generated_method = "C71DDB1A6192AD39610110B37944AD09")
        
@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        if (widthMode != MeasureSpec.EXACTLY) {
            if (isInEditMode()) {
                // Don't crash the layout editor. Consume all of the space if specified
                // or pick a magic number from thin air otherwise.
                // TODO Better communication with tools of this bogus state.
                // It will crash on a real device.
                if (widthMode == MeasureSpec.AT_MOST) {
                    widthMode = MeasureSpec.EXACTLY;
                } else if (widthMode == MeasureSpec.UNSPECIFIED) {
                    widthMode = MeasureSpec.EXACTLY;
                    widthSize = 300;
                }
            } else {
                throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
            }
        } else if (heightMode == MeasureSpec.UNSPECIFIED) {
            if (isInEditMode()) {
                // Don't crash the layout editor. Pick a magic number from thin air instead.
                // TODO Better communication with tools of this bogus state.
                // It will crash on a real device.
                if (heightMode == MeasureSpec.UNSPECIFIED) {
                    heightMode = MeasureSpec.AT_MOST;
                    heightSize = 300;
                }
            } else {
                throw new IllegalStateException("Height must not be UNSPECIFIED");
            }
        }

        int layoutHeight = 0;
        int maxLayoutHeight = -1;
        switch (heightMode) {
            case MeasureSpec.EXACTLY:
                layoutHeight = maxLayoutHeight = heightSize - getPaddingTop() - getPaddingBottom();
                break;
            case MeasureSpec.AT_MOST:
                maxLayoutHeight = heightSize - getPaddingTop() - getPaddingBottom();
                break;
        }

        float weightSum = 0;
        boolean canSlide = false;
        final int widthAvailable = widthSize - getPaddingLeft() - getPaddingRight();
        int widthRemaining = widthAvailable;
        final int childCount = getChildCount();

        if (childCount > 2) {
            Log.e(TAG, "onMeasure: More than two child views are not supported.");
        }

        // We'll find the current one below.
        mSlideableView = null;

        // First pass. Measure based on child LayoutParams width/height.
        // Weight will incur a second pass.
        for (int i = 0; i < childCount; i++) {
            final View child = getChildAt(i);
            final LayoutParams lp = (LayoutParams) child.getLayoutParams();

            if (child.getVisibility() == GONE) {
                lp.dimWhenOffset = false;
                continue;
            }

            if (lp.weight > 0) {
                weightSum += lp.weight;

                // If we have no width, weight is the only contributor to the final size.
                // Measure this view on the weight pass only.
                if (lp.width == 0) continue;
            }

            int childWidthSpec;
            final int horizontalMargin = lp.leftMargin + lp.rightMargin;
            if (lp.width == LayoutParams.WRAP_CONTENT) {
                childWidthSpec = MeasureSpec.makeMeasureSpec(widthAvailable - horizontalMargin,
                        MeasureSpec.AT_MOST);
            } else if (lp.width == LayoutParams.FILL_PARENT) {
                childWidthSpec = MeasureSpec.makeMeasureSpec(widthAvailable - horizontalMargin,
                        MeasureSpec.EXACTLY);
            } else {
                childWidthSpec = MeasureSpec.makeMeasureSpec(lp.width, MeasureSpec.EXACTLY);
            }

            int childHeightSpec;
            if (lp.height == LayoutParams.WRAP_CONTENT) {
                childHeightSpec = MeasureSpec.makeMeasureSpec(maxLayoutHeight, MeasureSpec.AT_MOST);
            } else if (lp.height == LayoutParams.FILL_PARENT) {
                childHeightSpec = MeasureSpec.makeMeasureSpec(maxLayoutHeight, MeasureSpec.EXACTLY);
            } else {
                childHeightSpec = MeasureSpec.makeMeasureSpec(lp.height, MeasureSpec.EXACTLY);
            }

            child.measure(childWidthSpec, childHeightSpec);
            final int childWidth = child.getMeasuredWidth();
            final int childHeight = child.getMeasuredHeight();

            if (heightMode == MeasureSpec.AT_MOST && childHeight > layoutHeight) {
                layoutHeight = Math.min(childHeight, maxLayoutHeight);
            }

            widthRemaining -= childWidth;
            canSlide |= lp.slideable = widthRemaining < 0;
            if (lp.slideable) {
                mSlideableView = child;
            }
        }

        // Resolve weight and make sure non-sliding panels are smaller than the full screen.
        if (canSlide || weightSum > 0) {
            final int fixedPanelWidthLimit = widthAvailable - mOverhangSize;

            for (int i = 0; i < childCount; i++) {
                final View child = getChildAt(i);

                if (child.getVisibility() == GONE) {
                    continue;
                }

                final LayoutParams lp = (LayoutParams) child.getLayoutParams();

                if (child.getVisibility() == GONE) {
                    continue;
                }

                final boolean skippedFirstPass = lp.width == 0 && lp.weight > 0;
                final int measuredWidth = skippedFirstPass ? 0 : child.getMeasuredWidth();
                if (canSlide && child != mSlideableView) {
                    if (lp.width < 0 && (measuredWidth > fixedPanelWidthLimit || lp.weight > 0)) {
                        // Fixed panels in a sliding configuration should
                        // be clamped to the fixed panel limit.
                        final int childHeightSpec;
                        if (skippedFirstPass) {
                            // Do initial height measurement if we skipped measuring this view
                            // the first time around.
                            if (lp.height == LayoutParams.WRAP_CONTENT) {
                                childHeightSpec = MeasureSpec.makeMeasureSpec(maxLayoutHeight,
                                        MeasureSpec.AT_MOST);
                            } else if (lp.height == LayoutParams.FILL_PARENT) {
                                childHeightSpec = MeasureSpec.makeMeasureSpec(maxLayoutHeight,
                                        MeasureSpec.EXACTLY);
                            } else {
                                childHeightSpec = MeasureSpec.makeMeasureSpec(lp.height,
                                        MeasureSpec.EXACTLY);
                            }
                        } else {
                            childHeightSpec = MeasureSpec.makeMeasureSpec(
                                    child.getMeasuredHeight(), MeasureSpec.EXACTLY);
                        }
                        final int childWidthSpec = MeasureSpec.makeMeasureSpec(
                                fixedPanelWidthLimit, MeasureSpec.EXACTLY);
                        child.measure(childWidthSpec, childHeightSpec);
                    }
                } else if (lp.weight > 0) {
                    int childHeightSpec;
                    if (lp.width == 0) {
                        // This was skipped the first time; figure out a real height spec.
                        if (lp.height == LayoutParams.WRAP_CONTENT) {
                            childHeightSpec = MeasureSpec.makeMeasureSpec(maxLayoutHeight,
                                    MeasureSpec.AT_MOST);
                        } else if (lp.height == LayoutParams.FILL_PARENT) {
                            childHeightSpec = MeasureSpec.makeMeasureSpec(maxLayoutHeight,
                                    MeasureSpec.EXACTLY);
                        } else {
                            childHeightSpec = MeasureSpec.makeMeasureSpec(lp.height,
                                    MeasureSpec.EXACTLY);
                        }
                    } else {
                        childHeightSpec = MeasureSpec.makeMeasureSpec(
                                child.getMeasuredHeight(), MeasureSpec.EXACTLY);
                    }

                    if (canSlide) {
                        // Consume available space
                        final int horizontalMargin = lp.leftMargin + lp.rightMargin;
                        final int newWidth = widthAvailable - horizontalMargin;
                        final int childWidthSpec = MeasureSpec.makeMeasureSpec(
                                newWidth, MeasureSpec.EXACTLY);
                        if (measuredWidth != newWidth) {
                            child.measure(childWidthSpec, childHeightSpec);
                        }
                    } else {
                        // Distribute the extra width proportionally similar to LinearLayout
                        final int widthToDistribute = Math.max(0, widthRemaining);
                        final int addedWidth = (int) (lp.weight * widthToDistribute / weightSum);
                        final int childWidthSpec = MeasureSpec.makeMeasureSpec(
                                measuredWidth + addedWidth, MeasureSpec.EXACTLY);
                        child.measure(childWidthSpec, childHeightSpec);
                    }
                }
            }
        }

        final int measuredWidth = widthSize;
        final int measuredHeight = layoutHeight + getPaddingTop() + getPaddingBottom();

        setMeasuredDimension(measuredWidth, measuredHeight);
        mCanSlide = canSlide;

        if (mDragHelper.getViewDragState() != ViewDragHelper.STATE_IDLE && !canSlide) {
            // Cancel scrolling in progress, it's no longer relevant.
            mDragHelper.abort();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:17:05.164 -0400", hash_original_method = "BC4176244D1FD823CEDF5A254A64B9D6", hash_generated_method = "0D3B83DD82AB6702BA2AB3C3DC942935")
        
@Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        final boolean isLayoutRtl = isLayoutRtlSupport();
        if (isLayoutRtl) {
            mDragHelper.setEdgeTrackingEnabled(ViewDragHelper.EDGE_RIGHT);
        } else {
            mDragHelper.setEdgeTrackingEnabled(ViewDragHelper.EDGE_LEFT);
        }
        final int width = r - l;
        final int paddingStart = isLayoutRtl ? getPaddingRight() : getPaddingLeft();
        final int paddingEnd = isLayoutRtl ? getPaddingLeft() : getPaddingRight();
        final int paddingTop = getPaddingTop();

        final int childCount = getChildCount();
        int xStart = paddingStart;
        int nextXStart = xStart;

        if (mFirstLayout) {
            mSlideOffset = mCanSlide && mPreservedOpenState ? 1.f : 0.f;
        }

        for (int i = 0; i < childCount; i++) {
            final View child = getChildAt(i);

            if (child.getVisibility() == GONE) {
                continue;
            }

            final LayoutParams lp = (LayoutParams) child.getLayoutParams();

            final int childWidth = child.getMeasuredWidth();
            int offset = 0;

            if (lp.slideable) {
                final int margin = lp.leftMargin + lp.rightMargin;
                final int range = Math.min(nextXStart,
                        width - paddingEnd - mOverhangSize) - xStart - margin;
                mSlideRange = range;
                final int lpMargin = isLayoutRtl ? lp.rightMargin : lp.leftMargin;
                lp.dimWhenOffset = xStart + lpMargin + range + childWidth / 2 >
                        width - paddingEnd;
                final int pos = (int) (range * mSlideOffset);
                xStart += pos + lpMargin;
                mSlideOffset = (float) pos / mSlideRange;
            } else if (mCanSlide && mParallaxBy != 0) {
                offset = (int) ((1 - mSlideOffset) * mParallaxBy);
                xStart = nextXStart;
            } else {
                xStart = nextXStart;
            }

            final int childRight;
            final int childLeft;
            if (isLayoutRtl) {
                childRight = width - xStart + offset;
                childLeft = childRight - childWidth;
            } else {
                childLeft = xStart - offset;
                childRight = childLeft + childWidth;
            }

            final int childTop = paddingTop;
            final int childBottom = childTop + child.getMeasuredHeight();
            child.layout(childLeft, paddingTop, childRight, childBottom);

            nextXStart += child.getWidth();
        }

        if (mFirstLayout) {
            if (mCanSlide) {
                if (mParallaxBy != 0) {
                    parallaxOtherViews(mSlideOffset);
                }
                if (((LayoutParams) mSlideableView.getLayoutParams()).dimWhenOffset) {
                    dimChildView(mSlideableView, mSlideOffset, mSliderFadeColor);
                }
            } else {
                // Reset the dim level of all children; it's irrelevant when nothing moves.
                for (int i = 0; i < childCount; i++) {
                    dimChildView(getChildAt(i), 0, mSliderFadeColor);
                }
            }
            updateObscuredViewsVisibility(mSlideableView);
        }

        mFirstLayout = false;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.355 -0400", hash_original_method = "998978B3234112C2871B01B8E73690D8", hash_generated_method = "F927584D2A0FC78816AD05A8FCBCDFC0")
        
@Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        // Recalculate sliding panes and their details
        if (w != oldw) {
            mFirstLayout = true;
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.360 -0400", hash_original_method = "5C0C88ADB443D8DE5D818D8420ADDE7E", hash_generated_method = "256305A2C2765F02CCDF0A61932D04A1")
        
@Override
    public void requestChildFocus(View child, View focused) {
        super.requestChildFocus(child, focused);
        if (!isInTouchMode() && !mCanSlide) {
            mPreservedOpenState = child == mSlideableView;
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.369 -0400", hash_original_method = "BE9C13098F2B2FCCE0CEAC62B099B589", hash_generated_method = "EE37562D4DDCB903FBE0E8B9621E3A57")
        
@Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        final int action = MotionEventCompat.getActionMasked(ev);

        // Preserve the open state based on the last view that was touched.
        if (!mCanSlide && action == MotionEvent.ACTION_DOWN && getChildCount() > 1) {
            // After the first things will be slideable.
            final View secondChild = getChildAt(1);
            if (secondChild != null) {
                mPreservedOpenState = !mDragHelper.isViewUnder(secondChild,
                        (int) ev.getX(), (int) ev.getY());
            }
        }

        if (!mCanSlide || (mIsUnableToDrag && action != MotionEvent.ACTION_DOWN)) {
            mDragHelper.cancel();
            return super.onInterceptTouchEvent(ev);
        }

        if (action == MotionEvent.ACTION_CANCEL || action == MotionEvent.ACTION_UP) {
            mDragHelper.cancel();
            return false;
        }

        boolean interceptTap = false;

        switch (action) {
            case MotionEvent.ACTION_DOWN: {
                mIsUnableToDrag = false;
                final float x = ev.getX();
                final float y = ev.getY();
                mInitialMotionX = x;
                mInitialMotionY = y;

                if (mDragHelper.isViewUnder(mSlideableView, (int) x, (int) y) &&
                        isDimmed(mSlideableView)) {
                    interceptTap = true;
                }
                break;
            }

            case MotionEvent.ACTION_MOVE: {
                final float x = ev.getX();
                final float y = ev.getY();
                final float adx = Math.abs(x - mInitialMotionX);
                final float ady = Math.abs(y - mInitialMotionY);
                final int slop = mDragHelper.getTouchSlop();
                if (adx > slop && ady > adx) {
                    mDragHelper.cancel();
                    mIsUnableToDrag = true;
                    return false;
                }
            }
        }

        final boolean interceptForDrag = mDragHelper.shouldInterceptTouchEvent(ev);

        return interceptForDrag || interceptTap;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.375 -0400", hash_original_method = "3E80C51FCC9628B71F5BEEE836BA61EE", hash_generated_method = "24FFD9E892DA4506547F1177A7DE3173")
        
@Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (!mCanSlide) {
            return super.onTouchEvent(ev);
        }

        mDragHelper.processTouchEvent(ev);

        final int action = ev.getAction();
        boolean wantTouchEvents = true;

        switch (action & MotionEventCompat.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN: {
                final float x = ev.getX();
                final float y = ev.getY();
                mInitialMotionX = x;
                mInitialMotionY = y;
                break;
            }

            case MotionEvent.ACTION_UP: {
                if (isDimmed(mSlideableView)) {
                    final float x = ev.getX();
                    final float y = ev.getY();
                    final float dx = x - mInitialMotionX;
                    final float dy = y - mInitialMotionY;
                    final int slop = mDragHelper.getTouchSlop();
                    if (dx * dx + dy * dy < slop * slop &&
                            mDragHelper.isViewUnder(mSlideableView, (int) x, (int) y)) {
                        // Taps close a dimmed open pane.
                        closePane(mSlideableView, 0);
                        break;
                    }
                }
                break;
            }
        }

        return wantTouchEvents;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.382 -0400", hash_original_method = "F136A81A04E7B2D21EBF2FF80CD7385C", hash_generated_method = "42D65E121A8CC492DE11BFFB97DE5902")
        
private boolean closePane(View pane, int initialVelocity) {
        if (mFirstLayout || smoothSlideTo(0.f, initialVelocity)) {
            mPreservedOpenState = false;
            return true;
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.388 -0400", hash_original_method = "8A9BBA94E1FACEA0CE51E7A63CDD39D1", hash_generated_method = "9F3BC672FE5F9DC7ABFC3F61A4CBFCC9")
        
private boolean openPane(View pane, int initialVelocity) {
        if (mFirstLayout || smoothSlideTo(1.f, initialVelocity)) {
            mPreservedOpenState = true;
            return true;
        }
        return false;
    }

    /**
     * @deprecated Renamed to {@link #openPane()} - this method is going away soon!
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.393 -0400", hash_original_method = "1DCC19EDCB58EE3C10676B1BB7AFFBBA", hash_generated_method = "08597D6096D76A9EB47C7A657D46EA3D")
        
@Deprecated
    public void smoothSlideOpen() {
        openPane();
    }

    /**
     * Open the sliding pane if it is currently slideable. If first layout
     * has already completed this will animate.
     *
     * @return true if the pane was slideable and is now open/in the process of opening
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.398 -0400", hash_original_method = "A42F5DC1E44356EC0C5F79607264EF8B", hash_generated_method = "B0C4D7DE38D452009CA68C00585EEB53")
        
public boolean openPane() {
        return openPane(mSlideableView, 0);
    }

    /**
     * @deprecated Renamed to {@link #closePane()} - this method is going away soon!
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.403 -0400", hash_original_method = "331C9C72D98A11D0A03E4CC922B83611", hash_generated_method = "EE84822C7B2867A870651D85FD5674FC")
        
@Deprecated
    public void smoothSlideClosed() {
        closePane();
    }

    /**
     * Close the sliding pane if it is currently slideable. If first layout
     * has already completed this will animate.
     *
     * @return true if the pane was slideable and is now closed/in the process of closing
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.408 -0400", hash_original_method = "62B85591A7B3309A9CD85088CEB124AC", hash_generated_method = "C1AE630AC2868613EC7BA435F4134C5B")
        
public boolean closePane() {
        return closePane(mSlideableView, 0);
    }

    /**
     * Check if the layout is completely open. It can be open either because the slider
     * itself is open revealing the left pane, or if all content fits without sliding.
     *
     * @return true if sliding panels are completely open
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.413 -0400", hash_original_method = "847FE5B05BC94AAC0D4FED725CFC85F0", hash_generated_method = "411B7724FEC90EAC3AC80C1EA40FC524")
        
public boolean isOpen() {
        return !mCanSlide || mSlideOffset == 1;
    }

    /**
     * @return true if content in this layout can be slid open and closed
     * @deprecated Renamed to {@link #isSlideable()} - this method is going away soon!
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.417 -0400", hash_original_method = "078F9D5252611EDF2720D903410386B6", hash_generated_method = "9050082274F8DF7195F83CFD194F54B0")
        
@Deprecated
    public boolean canSlide() {
        return mCanSlide;
    }

    /**
     * Check if the content in this layout cannot fully fit side by side and therefore
     * the content pane can be slid back and forth.
     *
     * @return true if content in this layout can be slid open and closed
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.422 -0400", hash_original_method = "52CB6F0E07109B0C7A4E78DE1CE0C813", hash_generated_method = "B472B0BEEAC92000D5C4E06B83F4F1AD")
        
public boolean isSlideable() {
        return mCanSlide;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:17:05.246 -0400", hash_original_method = "3BC9EDE7A074F5F60ADC077E7EC44EAD", hash_generated_method = "6CF43280D212D2F6CD0D96E2437B0483")
        
private void onPanelDragged(int newLeft) {
        if (mSlideableView == null) {
            // This can happen if we're aborting motion during layout because everything now fits.
            mSlideOffset = 0;
            return;
        }
        final boolean isLayoutRtl = isLayoutRtlSupport();
        final LayoutParams lp = (LayoutParams) mSlideableView.getLayoutParams();

        int childWidth = mSlideableView.getWidth();
        final int newStart = isLayoutRtl ? getWidth() - newLeft - childWidth : newLeft;

        final int paddingStart = isLayoutRtl ? getPaddingRight() : getPaddingLeft();
        final int lpMargin = isLayoutRtl ? lp.rightMargin : lp.leftMargin;
        final int startBound = paddingStart + lpMargin;

        mSlideOffset = (float) (newStart - startBound) / mSlideRange;

        if (mParallaxBy != 0) {
            parallaxOtherViews(mSlideOffset);
        }

        if (lp.dimWhenOffset) {
            dimChildView(mSlideableView, mSlideOffset, mSliderFadeColor);
        }
        dispatchOnPanelSlide(mSlideableView);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.438 -0400", hash_original_method = "ED528DA2E74DBEE272DB6BCEC84A259A", hash_generated_method = "432AED40A82B4C0358EC193006786AD9")
        
private void dimChildView(View v, float mag, int fadeColor) {
        final LayoutParams lp = (LayoutParams) v.getLayoutParams();

        if (mag > 0 && fadeColor != 0) {
            final int baseAlpha = (fadeColor & 0xff000000) >>> 24;
            int imag = (int) (baseAlpha * mag);
            int color = imag << 24 | (fadeColor & 0xffffff);
            if (lp.dimPaint == null) {
                lp.dimPaint = new Paint();
            }
            lp.dimPaint.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_OVER));
            if (ViewCompat.getLayerType(v) != ViewCompat.LAYER_TYPE_HARDWARE) {
                ViewCompat.setLayerType(v, ViewCompat.LAYER_TYPE_HARDWARE, lp.dimPaint);
            }
            invalidateChildRegion(v);
        } else if (ViewCompat.getLayerType(v) != ViewCompat.LAYER_TYPE_NONE) {
            if (lp.dimPaint != null) {
                lp.dimPaint.setColorFilter(null);
            }
            final DisableLayerRunnable dlr = new DisableLayerRunnable(v);
            mPostedRunnables.add(dlr);
            ViewCompat.postOnAnimation(this, dlr);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:17:05.263 -0400", hash_original_method = "2B9DB0E61867EF5CFB34622E01EAAE07", hash_generated_method = "6A448FFCF0DCD786BD08B1F8D98EEC4A")
        
@Override
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        final LayoutParams lp = (LayoutParams) child.getLayoutParams();
        boolean result;
        final int save = canvas.save(Canvas.CLIP_SAVE_FLAG);

        if (mCanSlide && !lp.slideable && mSlideableView != null) {
            // Clip against the slider; no sense drawing what will immediately be covered.
            canvas.getClipBounds(mTmpRect);
            if (isLayoutRtlSupport()) {
                mTmpRect.left = Math.max(mTmpRect.left, mSlideableView.getRight());
            } else {
                mTmpRect.right = Math.min(mTmpRect.right, mSlideableView.getLeft());
            }
            canvas.clipRect(mTmpRect);
        }

        if (Build.VERSION.SDK_INT >= 11) { // HC
            result = super.drawChild(canvas, child, drawingTime);
        } else {
            if (lp.dimWhenOffset && mSlideOffset > 0) {
                if (!child.isDrawingCacheEnabled()) {
                    child.setDrawingCacheEnabled(true);
                }
                final Bitmap cache = child.getDrawingCache();
                if (cache != null) {
                    canvas.drawBitmap(cache, child.getLeft(), child.getTop(), lp.dimPaint);
                    result = false;
                } else {
                    Log.e(TAG, "drawChild: child view " + child + " returned null drawing cache");
                    result = super.drawChild(canvas, child, drawingTime);
                }
            } else {
                if (child.isDrawingCacheEnabled()) {
                    child.setDrawingCacheEnabled(false);
                }
                result = super.drawChild(canvas, child, drawingTime);
            }
        }

        canvas.restoreToCount(save);

        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.451 -0400", hash_original_method = "4B5342F4AA278236A87AA8C27A4B1283", hash_generated_method = "905D3D8CFF7E1B8CAE8753EE8A1C3620")
        
private void invalidateChildRegion(View v) {
        IMPL.invalidateChildRegion(this, v);
    }

    /**
     * Smoothly animate mDraggingPane to the target X position within its range.
     *
     * @param slideOffset position to animate to
     * @param velocity initial velocity in case of fling, or 0.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:17:05.275 -0400", hash_original_method = "163EDC5D069EC6088E356FC7F8A55688", hash_generated_method = "4A155CCF6C86C02F3661264C45E30ABF")
        
boolean smoothSlideTo(float slideOffset, int velocity) {
        if (!mCanSlide) {
            // Nothing to do.
            return false;
        }

        final boolean isLayoutRtl = isLayoutRtlSupport();
        final LayoutParams lp = (LayoutParams) mSlideableView.getLayoutParams();

        int x;
        if (isLayoutRtl) {
            int startBound = getPaddingRight() + lp.rightMargin;
            int childWidth = mSlideableView.getWidth();
            x = (int) (getWidth() - (startBound + slideOffset * mSlideRange + childWidth));
        } else {
            int startBound = getPaddingLeft() + lp.leftMargin;
            x = (int) (startBound + slideOffset * mSlideRange);
        }

        if (mDragHelper.smoothSlideViewTo(mSlideableView, x, mSlideableView.getTop())) {
            setAllChildrenVisible();
            ViewCompat.postInvalidateOnAnimation(this);
            return true;
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.463 -0400", hash_original_method = "F0DF4F5402F448D483A72AE19100FEC2", hash_generated_method = "AFA88ACA4C0E0440AFCB32F86150F4F8")
        
@Override
    public void computeScroll() {
        if (mDragHelper.continueSettling(true)) {
            if (!mCanSlide) {
                mDragHelper.abort();
                return;
            }

            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /**
     * @deprecated Renamed to {@link #setShadowDrawableLeft(Drawable d)} to support LTR (left to
     * right language) and {@link #setShadowDrawableRight(Drawable d)} to support RTL (right to left
     * language) during opening/closing.
     *
     * @param d drawable to use as a shadow
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:17:05.286 -0400", hash_original_method = "D456004BC6B64C61E0C2D4C192C0A2BD", hash_generated_method = "2278A2DECDFA2B83E54623BF269E5409")
        
@Deprecated
    public void setShadowDrawable(Drawable d) {
        setShadowDrawableLeft(d);
    }

    /**
     * Set a drawable to use as a shadow cast by the right pane onto the left pane
     * during opening/closing.
     *
     * @param resId Resource ID of a drawable to use
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:17:05.303 -0400", hash_original_method = "60C89E8094D1A46DA7BA37B41E057A4C", hash_generated_method = "17FDA018126E3202C86508C3EFBD5822")
        
@Deprecated
    public void setShadowResource(int resId) {
        setShadowDrawable(getResources().getDrawable(resId));
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:17:05.320 -0400", hash_original_method = "B43C376F194B0AA51D5226815101461A", hash_generated_method = "288F9012DCC4FDF9AE7E9DDC63F30A2D")
        
@Override
    public void draw(Canvas c) {
        super.draw(c);
        final boolean isLayoutRtl = isLayoutRtlSupport();
        Drawable shadowDrawable;
        if (isLayoutRtl) {
            shadowDrawable = mShadowDrawableRight;
        } else {
            shadowDrawable = mShadowDrawableLeft;
        }

        final View shadowView = getChildCount() > 1 ? getChildAt(1) : null;
        if (shadowView == null || shadowDrawable == null) {
            // No need to draw a shadow if we don't have one.
            return;
        }

        final int top = shadowView.getTop();
        final int bottom = shadowView.getBottom();

        final int shadowWidth = shadowDrawable.getIntrinsicWidth();
        final int left;
        final int right;
        if (isLayoutRtlSupport()) {
            left = shadowView.getRight();
            right = left + shadowWidth;
        } else {
            right = shadowView.getLeft();
            left = right - shadowWidth;
        }

        shadowDrawable.setBounds(left, top, right, bottom);
        shadowDrawable.draw(c);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:17:05.326 -0400", hash_original_method = "F06380959A4CF712885BA2D2A3C742C2", hash_generated_method = "90FA20CD11A41F8F609CAADA2F1F96FB")
        
private void parallaxOtherViews(float slideOffset) {
        final boolean isLayoutRtl = isLayoutRtlSupport();
        final LayoutParams slideLp = (LayoutParams) mSlideableView.getLayoutParams();
        final boolean dimViews = slideLp.dimWhenOffset &&
                (isLayoutRtl ? slideLp.rightMargin : slideLp.leftMargin) <= 0;
        final int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View v = getChildAt(i);
            if (v == mSlideableView) continue;

            final int oldOffset = (int) ((1 - mParallaxOffset) * mParallaxBy);
            mParallaxOffset = slideOffset;
            final int newOffset = (int) ((1 - slideOffset) * mParallaxBy);
            final int dx = oldOffset - newOffset;

            v.offsetLeftAndRight(isLayoutRtl ? -dx : dx);

            if (dimViews) {
                dimChildView(v, isLayoutRtl ? mParallaxOffset - 1 :
                    1 - mParallaxOffset, mCoveredFadeColor);
            }
        }
    }

    /**
     * Tests scrollability within child views of v given a delta of dx.
     *
     * @param v View to test for horizontal scrollability
     * @param checkV Whether the view v passed should itself be checked for scrollability (true),
     *               or just its children (false).
     * @param dx Delta scrolled in pixels
     * @param x X coordinate of the active touch point
     * @param y Y coordinate of the active touch point
     * @return true if child views of v can be scrolled by delta of dx.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:17:05.334 -0400", hash_original_method = "4D282B996E33AD9CD5D598AFA276F406", hash_generated_method = "50A28E8AAC4A32129260B92C659B56C0")
        
protected boolean canScroll(View v, boolean checkV, int dx, int x, int y) {
        if (v instanceof ViewGroup) {
            final ViewGroup group = (ViewGroup) v;
            final int scrollX = v.getScrollX();
            final int scrollY = v.getScrollY();
            final int count = group.getChildCount();
            // Count backwards - let topmost views consume scroll distance first.
            for (int i = count - 1; i >= 0; i--) {
                // TODO: Add versioned support here for transformed views.
                // This will not work for transformed views in Honeycomb+
                final View child = group.getChildAt(i);
                if (x + scrollX >= child.getLeft() && x + scrollX < child.getRight() &&
                        y + scrollY >= child.getTop() && y + scrollY < child.getBottom() &&
                        canScroll(child, true, dx, x + scrollX - child.getLeft(),
                                y + scrollY - child.getTop())) {
                    return true;
                }
            }
        }

        return checkV && ViewCompat.canScrollHorizontally(v, (isLayoutRtlSupport() ? dx : -dx));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.499 -0400", hash_original_method = "56ED602BC0E5F7530318A3CD57B3DF74", hash_generated_method = "56ED602BC0E5F7530318A3CD57B3DF74")
        
boolean isDimmed(View child) {
        if (child == null) {
            return false;
        }
        final LayoutParams lp = (LayoutParams) child.getLayoutParams();
        return mCanSlide && lp.dimWhenOffset && mSlideOffset > 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.505 -0400", hash_original_method = "763708F2B4B4E396A96E9D3340F0B010", hash_generated_method = "DA1288B08801ADDE6F9C8699A1A5E871")
        
@Override
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.512 -0400", hash_original_method = "B55A47AEBE45609D692FB6AAFFE1D182", hash_generated_method = "A626AC0F6D2F5CB34574C3E154731C07")
        
@Override
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        return p instanceof MarginLayoutParams
                ? new LayoutParams((MarginLayoutParams) p)
                : new LayoutParams(p);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.516 -0400", hash_original_method = "0820242DFB1833A79D3A037A247A735A", hash_generated_method = "0FAAF748BA4C1D95221E65EBFCBC4B0B")
        
@Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return p instanceof LayoutParams && super.checkLayoutParams(p);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.522 -0400", hash_original_method = "1C9B9BBEC46A39865FCD3A7288415ECD", hash_generated_method = "C4E1D1D633134DBA474501AB48EC2962")
        
@Override
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(), attrs);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.528 -0400", hash_original_method = "4C9BEE57B9A73D3561EF9076AD0181AD", hash_generated_method = "212F826707988E19BFE3F5E03A02E622")
        
@Override
    protected Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();

        SavedState ss = new SavedState(superState);
        ss.isOpen = isSlideable() ? isOpen() : mPreservedOpenState;

        return ss;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:44:03.533 -0400", hash_original_method = "381A8609D52DF7016BBA3939473A8D12", hash_generated_method = "20FD930B0F102BDC4B3AB51AB5AE1CFE")
        
@Override
    protected void onRestoreInstanceState(Parcelable state) {
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());

        if (ss.isOpen) {
            openPane();
        } else {
            closePane();
        }
        mPreservedOpenState = ss.isOpen;
    }

    private class DragHelperCallback extends ViewDragHelper.Callback {

        @Override
        public boolean tryCaptureView(View child, int pointerId) {
            if (mIsUnableToDrag) {
                return false;
            }

            return ((LayoutParams) child.getLayoutParams()).slideable;
        }

        @Override
        public void onViewDragStateChanged(int state) {
            if (mDragHelper.getViewDragState() == ViewDragHelper.STATE_IDLE) {
                if (mSlideOffset == 0) {
                    updateObscuredViewsVisibility(mSlideableView);
                    dispatchOnPanelClosed(mSlideableView);
                    mPreservedOpenState = false;
                } else {
                    dispatchOnPanelOpened(mSlideableView);
                    mPreservedOpenState = true;
                }
            }
        }

        @Override
        public void onViewCaptured(View capturedChild, int activePointerId) {
            // Make all child views visible in preparation for sliding things around
            setAllChildrenVisible();
        }

        @Override
        public void onViewPositionChanged(View changedView, int left, int top, int dx, int dy) {
            onPanelDragged(left);
            invalidate();
        }

        @Override
        public void onViewReleased(View releasedChild, float xvel, float yvel) {
            final LayoutParams lp = (LayoutParams) releasedChild.getLayoutParams();
            int left = getPaddingLeft() + lp.leftMargin;
            if (xvel > 0 || (xvel == 0 && mSlideOffset > 0.5f)) {
                left += mSlideRange;
            }
            mDragHelper.settleCapturedViewAt(left, releasedChild.getTop());
            invalidate();
        }

        @Override
        public int getViewHorizontalDragRange(View child) {
            return mSlideRange;
        }

        @Override
        public int clampViewPositionHorizontal(View child, int left, int dx) {
            final LayoutParams lp = (LayoutParams) mSlideableView.getLayoutParams();
            final int leftBound = getPaddingLeft() + lp.leftMargin;
            final int rightBound = leftBound + mSlideRange;

            final int newLeft = Math.min(Math.max(left, leftBound), rightBound);

            return newLeft;
        }

        @Override
        public void onEdgeDragStarted(int edgeFlags, int pointerId) {
            mDragHelper.captureChildView(mSlideableView, pointerId);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:17:05.422 -0400", hash_original_method = "F82BAC20401988C1E724711CE338C27B", hash_generated_method = "7A2698997AEDE196F2F58AF0529D5C93")
            
@Override
        public int clampViewPositionVertical(View child, int top, int dy) {
            // Make sure we never move views vertically.
            // This could happen if the child has less height than its parent.
            return child.getTop();
        }}

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        private static final int[] ATTRS = new int[] {
            android.R.attr.layout_weight
        };

        /**
         * The weighted proportion of how much of the leftover space
         * this child should consume after measurement.
         */
        public float weight = 0;

        /**
         * True if this pane is the slideable pane in the layout.
         */
        boolean slideable;

        /**
         * True if this view should be drawn dimmed
         * when it's been offset from its default position.
         */
        boolean dimWhenOffset;

        Paint dimPaint;

        public LayoutParams() {
            super(FILL_PARENT, FILL_PARENT);
        }

        public LayoutParams(int width, int height) {
            super(width, height);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams source) {
            super(source);
        }

        public LayoutParams(MarginLayoutParams source) {
            super(source);
        }

        public LayoutParams(LayoutParams source) {
            super(source);
            this.weight = source.weight;
        }

        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);

            final TypedArray a = c.obtainStyledAttributes(attrs, ATTRS);
            this.weight = a.getFloat(0, 0);
            a.recycle();
        }

    }

    static class SavedState extends BaseSavedState {

        public static final Parcelable.Creator<SavedState> CREATOR =
                new Parcelable.Creator<SavedState>() {
            @DSSafe(DSCat.SAFE_LIST)
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
        boolean isOpen;

        SavedState(Parcelable superState) {
            super(superState);
        }

        private SavedState(Parcel in) {
            super(in);
            isOpen = in.readInt() != 0;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(isOpen ? 1 : 0);
        }
    }

    interface SlidingPanelLayoutImpl {
        void invalidateChildRegion(SlidingPaneLayout parent, View child);
    }

    static class SlidingPanelLayoutImplBase implements SlidingPanelLayoutImpl {
        public void invalidateChildRegion(SlidingPaneLayout parent, View child) {
            ViewCompat.postInvalidateOnAnimation(parent, child.getLeft(), child.getTop(),
                    child.getRight(), child.getBottom());
        }
    }

    static class SlidingPanelLayoutImplJB extends SlidingPanelLayoutImplBase {
        /*
         * Private API hacks! Nasty! Bad!
         *
         * In Jellybean, some optimizations in the hardware UI renderer
         * prevent a changed Paint on a View using a hardware layer from having
         * the intended effect. This twiddles some internal bits on the view to force
         * it to recreate the display list.
         */
        private Method mGetDisplayList;
        private Field mRecreateDisplayList;

        SlidingPanelLayoutImplJB() {
            try {
                mGetDisplayList = View.class.getDeclaredMethod("getDisplayList", (Class[]) null);
            } catch (NoSuchMethodException e) {
                Log.e(TAG, "Couldn't fetch getDisplayList method; dimming won't work right.", e);
            }
            try {
                mRecreateDisplayList = View.class.getDeclaredField("mRecreateDisplayList");
                mRecreateDisplayList.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e(TAG, "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", e);
            }
        }

        @Override
        public void invalidateChildRegion(SlidingPaneLayout parent, View child) {
            if (mGetDisplayList != null && mRecreateDisplayList != null) {
                try {
                    mRecreateDisplayList.setBoolean(child, true);
                    mGetDisplayList.invoke(child, (Object[]) null);
                } catch (Exception e) {
                    Log.e(TAG, "Error refreshing display list state", e);
                }
            } else {
                // Slow path. REALLY slow path. Let's hope we don't get here.
                child.invalidate();
                return;
            }
            super.invalidateChildRegion(parent, child);
        }
    }

    static class SlidingPanelLayoutImplJBMR1 extends SlidingPanelLayoutImplBase {
        @Override
        public void invalidateChildRegion(SlidingPaneLayout parent, View child) {
            ViewCompat.setLayerPaint(child, ((LayoutParams) child.getLayoutParams()).dimPaint);
        }
    }

    class AccessibilityDelegate extends AccessibilityDelegateCompat {
        private final Rect mTmpRect = new Rect();

        @Override
        public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
            final AccessibilityNodeInfoCompat superNode = AccessibilityNodeInfoCompat.obtain(info);
            super.onInitializeAccessibilityNodeInfo(host, superNode);
            copyNodeInfoNoChildren(info, superNode);
            superNode.recycle();

            info.setClassName(SlidingPaneLayout.class.getName());
            info.setSource(host);

            final ViewParent parent = ViewCompat.getParentForAccessibility(host);
            if (parent instanceof View) {
                info.setParent((View) parent);
            }

            // This is a best-approximation of addChildrenForAccessibility()
            // that accounts for filtering.
            final int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                final View child = getChildAt(i);
                if (!filter(child) && (child.getVisibility() == View.VISIBLE)) {
                    // Force importance to "yes" since we can't read the value.
                    ViewCompat.setImportantForAccessibility(
                            child, ViewCompat.IMPORTANT_FOR_ACCESSIBILITY_YES);
                    info.addChild(child);
                }
            }
        }

        @Override
        public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
            super.onInitializeAccessibilityEvent(host, event);

            event.setClassName(SlidingPaneLayout.class.getName());
        }

        @Override
        public boolean onRequestSendAccessibilityEvent(ViewGroup host, View child,
                AccessibilityEvent event) {
            if (!filter(child)) {
                return super.onRequestSendAccessibilityEvent(host, child, event);
            }
            return false;
        }

        public boolean filter(View child) {
            return isDimmed(child);
        }

        /**
         * This should really be in AccessibilityNodeInfoCompat, but there unfortunately
         * seem to be a few elements that are not easily cloneable using the underlying API.
         * Leave it private here as it's not general-purpose useful.
         */
        private void copyNodeInfoNoChildren(AccessibilityNodeInfoCompat dest,
                AccessibilityNodeInfoCompat src) {
            final Rect rect = mTmpRect;

            src.getBoundsInParent(rect);
            dest.setBoundsInParent(rect);

            src.getBoundsInScreen(rect);
            dest.setBoundsInScreen(rect);

            dest.setVisibleToUser(src.isVisibleToUser());
            dest.setPackageName(src.getPackageName());
            dest.setClassName(src.getClassName());
            dest.setContentDescription(src.getContentDescription());

            dest.setEnabled(src.isEnabled());
            dest.setClickable(src.isClickable());
            dest.setFocusable(src.isFocusable());
            dest.setFocused(src.isFocused());
            dest.setAccessibilityFocused(src.isAccessibilityFocused());
            dest.setSelected(src.isSelected());
            dest.setLongClickable(src.isLongClickable());

            dest.addAction(src.getActions());

            dest.setMovementGranularities(src.getMovementGranularities());
        }
    }

    private class DisableLayerRunnable implements Runnable {
        final View mChildView;

        DisableLayerRunnable(View childView) {
            mChildView = childView;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void run() {
            if (mChildView.getParent() == SlidingPaneLayout.this) {
                ViewCompat.setLayerType(mChildView, ViewCompat.LAYER_TYPE_NONE, null);
                invalidateChildRegion(mChildView);
            }
            mPostedRunnables.remove(this);
        }
    }

    /**
     * Set a drawable to use as a shadow cast by the left pane onto the right pane
     * during opening/closing to support right to left language.
     *
     * @param d drawable to use as a shadow
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:17:05.297 -0400", hash_original_method = "D4CAE6D3200E06DBB37AA00E17AB84FC", hash_generated_method = "FEF97D2B2E5FEA2E54C583B8E30A3B5C")
        
public void setShadowDrawableRight(Drawable d) {
        mShadowDrawableRight = d;
    }

    /**
     * Set a drawable to use as a shadow cast by the right pane onto the left pane
     * during opening/closing.
     *
     * @param resId Resource ID of a drawable to use
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:17:05.308 -0400", hash_original_method = "9DEE745324A494FBE465C89D12C27890", hash_generated_method = "0D888FD0EDAC9663E3D470055376F604")
        
public void setShadowResourceLeft(int resId) {
        setShadowDrawableLeft(getResources().getDrawable(resId));
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:17:04.820 -0400", hash_original_field = "DC66D65BD573B5375E59A83CECFDFDF6", hash_generated_field = "B8CC33EB6FC4122C07D3E904016F8C50")

    private Drawable mShadowDrawableLeft;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:17:05.657 -0400", hash_original_method = "A54B147584955D06E420F90BEDB19470", hash_generated_method = "463406EACA32FD2D8126DA5174025851")
            
private boolean isLayoutRtlSupport() {
        return ViewCompat.getLayoutDirection(this) == ViewCompat.LAYOUT_DIRECTION_RTL;
    }

    /**
     * Set a drawable to use as a shadow cast by the left pane onto the right pane
     * during opening/closing to support right to left language.
     *
     * @param resId Resource ID of a drawable to use
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:17:05.314 -0400", hash_original_method = "C65738CBCDC9C9D4735B3EEABE5356BC", hash_generated_method = "77F096B66DF48E9C4346F25E45A43A2C")
        
public void setShadowResourceRight(int resId) {
        setShadowDrawableRight(getResources().getDrawable(resId));
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:17:04.828 -0400", hash_original_field = "635D19781AE747333F986A22082A23B6", hash_generated_field = "9BA680880AFA3F9EBCB0B863237F371E")

    private Drawable mShadowDrawableRight;

    /**
     * Set a drawable to use as a shadow cast by the right pane onto the left pane
     * during opening/closing.
     *
     * @param d drawable to use as a shadow
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:17:05.291 -0400", hash_original_method = "4D13455D83DCC855DC616F929F4D5E40", hash_generated_method = "6D552621362E8129440D54476180378C")
        
public void setShadowDrawableLeft(Drawable d) {
        mShadowDrawableLeft = d;
    }}
